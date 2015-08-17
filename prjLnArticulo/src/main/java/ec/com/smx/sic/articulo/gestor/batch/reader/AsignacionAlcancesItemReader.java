/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.batch.reader;

import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.database.orm.HibernateQueryProvider;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import ec.com.kruger.encriptacion.excepcion.EncriptacionExcepcion;
import ec.com.kruger.encriptacion.util.CodificacionUtil;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.HibernateH;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * @author jmontenegro
 *
 */
public class AsignacionAlcancesItemReader<T extends SearchDTO> extends AbstractItemCountingItemStreamItemReader<T> implements ItemStream, InitializingBean {

	/**
	 * Plantilla de busqueda
	 */
	private SearchDTO baseDTO;

	private HibernateH<T> hibernateH;

	private SessionFactory sessionFactory;

	private HibernateQueryProvider queryProvider;

	private boolean useStatelessSession = true;

	private StatelessSession statelessSession;

	private Session statefulSession;

	private ScrollableResults cursor;

	private boolean initialized = false;

	private int fetchSize;

	public AsignacionAlcancesItemReader() {
		setName(ClassUtils.getShortName(AsignacionAlcancesItemReader.class));
	}

	/**
	 * @param hibernateH
	 *            the hibernateH to set
	 */
	public void setHibernateH(HibernateH<T> hibernateH) {
		this.hibernateH = hibernateH;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.state(fetchSize >= 0, "fetchSize must not be negative");
		Assert.state(sessionFactory != null, "A SessionFactory must be provided");

		if (queryProvider == null) {
			Assert.notNull(sessionFactory, "session factory must be set");
		}
		// making sure that the appropriate (Hibernate) query provider is set
		else {
			Assert.state(queryProvider != null, "Hibernate query provider must be set");
		}
	}

	/**
	 * Fetch size used internally by Hibernate to limit amount of data fetched
	 * from database per round trip.
	 * 
	 * @param fetchSize
	 *            the fetch size to pass down to Hibernate
	 */
	public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
	}

	/**
	 * A query provider. Either this or the {{@link #setQueryString(String)
	 * query string} or the {{@link #setQueryName(String) query name} should be
	 * set.
	 * 
	 * @param queryProvider
	 *            Hibernate query provider
	 */
	public void setQueryProvider(HibernateQueryProvider queryProvider) {
		this.queryProvider = queryProvider;
	}

	/**
	 * The Hibernate SessionFactory to use the create a session.
	 * 
	 * @param sessionFactory
	 *            the {@link SessionFactory} to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Can be set only in uninitialized state.
	 * 
	 * @param useStatelessSession
	 *            <code>true</code> to use {@link StatelessSession}
	 *            <code>false</code> to use standard hibernate {@link Session}
	 */
	public void setUseStatelessSession(boolean useStatelessSession) {
		Assert.state(statefulSession == null && statelessSession == null, "The useStatelessSession flag can only be set before a session is initialized.");
		this.useStatelessSession = useStatelessSession;
	}

	int cont = 0;

	protected T doRead() throws Exception {
		synchronized (cursor) {
			if (cursor.next()) {
				Object[] data = cursor.get();
				
				ArticuloDTO articuloDTO = new ArticuloDTO();
				articuloDTO.setCodigoBarrasActivo(new ArticuloBitacoraCodigoBarrasDTO());
				
				if(data[0] != null){
					articuloDTO.getId().setCodigoArticulo((String)data[0]);
				}
				if(data[1] != null){
					articuloDTO.getCodigoBarrasActivo().getId().setCodigoBarras((String)data[1]);
				}
				if(data[2] != null){
					articuloDTO.setDescripcionArticulo((String)data[2]);
				}
				// Assume if there is only one item that it is the data the user
				// wants.
				// If there is only one item this is going to be a nasty shock
				// if T is an array type but there's not much else we can do...
				@SuppressWarnings("unchecked")
				T item = (T) articuloDTO;

				// System.out.print(cont+" - "+item);
				cont++;
				return item;

			}
			return null;
		}
	}

	/**
	 * Open hibernate session and create a forward-only cursor for the query.
	 */
	@SuppressWarnings("unchecked")
	protected void doOpen() throws Exception {
		try {
			Assert.state(!initialized, "Cannot open an already opened ItemReader, call close first");
			Boolean enableLike = Boolean.TRUE;
			Boolean clearCache = Boolean.TRUE;

			T template = (T) this.baseDTO;
			Criteria criteria = createCriteria();

			// Se obtiene el resultTransformer
			if (template.getCriteriaSearch() != null && template.getCriteriaSearch().getResultTransformer() != null) {
				criteria.setResultTransformer(template.getCriteriaSearch().getResultTransformer());
			}

			// Se obtiene el criteria
			criteria = hibernateH.getCriteriaQuery(criteria, template, enableLike, clearCache);

			// Se agrega las proyecciones
			if (template.getCriteriaSearch() != null && template.getCriteriaSearch().getResultTransformer() != null) {
				hibernateH.addProjection(template, template.getCriteriaSearch());
			}

			// Se agrega las relaciones
			hibernateH.addRelations(template, criteria, template.getCriteriaSearch(), enableLike);

			// Se aplica el transformador de la clase final
			if (template.getCriteriaSearch() != null && template.getCriteriaSearch().getResultTransformer() != null) {
				template.getCriteriaSearch().getResultTransformer().setResultClass(template.getClass());
				criteria.setResultTransformer(template.getCriteriaSearch().getResultTransformer());
			}
			
			ProjectionList projections = Projections.projectionList()
					.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("codigoBarras"),"codigoBarras")
					.add(Projections.property("descripcionArticulo"),"descripcionArticulo");
			
			criteria.setProjection(Projections.distinct(projections));
			
			criteria.setFetchSize(fetchSize);
			// Se aplica el cursor
			cursor = hibernateH.scroll(template, criteria);
			initialized = true;
		} catch (Exception e) {
			// System.out.println(e);
			// e.printStackTrace();
			Logeable.LOG_SICV2.info(e.getMessage());
		}
	}
	
	/**
	 * Open appropriate type of hibernate session and create the query.
	 */
	public Criteria createCriteria() {

		if (useStatelessSession) {
			if (statelessSession == null) {
				statelessSession = hibernateH.getSessionFactory().openStatelessSession();
			}
			return statelessSession.createCriteria(this.baseDTO.getClass());
		}
		if (statefulSession == null) {
			statefulSession = hibernateH.getSessionFactory().openSession();
		}
		return statefulSession.createCriteria(this.baseDTO.getClass());
	}

	/**
	 * Update the context and clear the session if stateful.
	 * 
	 * @param executionContext
	 *            the current {@link ExecutionContext}
	 * @throws ItemStreamException
	 *             if there is a problem
	 */
	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		super.update(executionContext);
		if (statefulSession != null) {
			statefulSession.clear();
		}
	}

	/**
	 * Wind forward through the result set to the item requested. Also clears
	 * the session every now and then (if stateful) to avoid memory problems.
	 * The frequency of session clearing is the larger of the fetch size (if
	 * set) and 100.
	 * 
	 * @param itemIndex
	 *            the first item to read
	 * @throws Exception
	 *             if there is a problem
	 * @see AbstractItemCountingItemStreamItemReader#jumpToItem(int)
	 */
	@Override
	protected void jumpToItem(int itemIndex) throws Exception {
		int flushSize = Math.max(fetchSize, 100);
		for (int i = 0; i < itemIndex; i++) {
			cursor.next();
			if (i % flushSize == 0 && !useStatelessSession) {
				statefulSession.clear(); // Clears in-memory cache
			}
		}
	}

	/**
	 * Close the cursor and hibernate session.
	 */
	protected void doClose() throws Exception {

		initialized = false;

		if (cursor != null) {
			cursor.close();
		}

		if (statelessSession != null) {
			statelessSession.close();
			statelessSession = null;
		}
		if (statefulSession != null) {
			statefulSession.close();
			statefulSession = null;
		}

	}

	/**
	 * @param baseDTO
	 *            the baseDTO to set
	 */
	public void setBaseDTO(SearchDTO baseDTO) {
		this.baseDTO = baseDTO;
	}

	public void setEncodedBaseDTO(String encodedBaseDTO) throws EncriptacionExcepcion {
		baseDTO = CodificacionUtil.getInstancia().decodificarStringAObjeto(encodedBaseDTO, SearchDTO.class);
	}
}
