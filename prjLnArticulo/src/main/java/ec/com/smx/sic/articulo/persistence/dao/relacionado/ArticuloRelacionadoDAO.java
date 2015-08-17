package ec.com.smx.sic.articulo.persistence.dao.relacionado;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.relacionado.IArticuloRelacionadoDAO;

/** 
 * Clase que me permite acceder e interactuar con los datos de la tabla referenciada en la entidad ArticuloRelacionDTO
 * @author mgranda
 */
public class ArticuloRelacionadoDAO implements IArticuloRelacionadoDAO, Logeable{
	
	private SessionFactory sessionFactory;
		
	/**
	 * M\u00E9todo que permite relacionar varios art\u00EDculos con un tipo de relaci\u00F3n espec\u00EDfica a un art\u00EDculo princial
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param valorTipoRelacion
	 * @param userId
	 * @param codigosArticulosRelacionados
	 * @return
	 * @throws SICException
	 */
	@Override
	public Integer relacionarArticulo(Integer codigoCompania, String codigoArticulo, String valorTipoRelacion, String userId, String... codigosArticulosRelacionados) throws SICException{
		try {
			
			int count = 0;//variable que obtendra el numero total de registros creados y actualizados
			
			if(ArrayUtils.isNotEmpty(codigosArticulosRelacionados)){
				/*Se obtiene la sesion de hibernate y se limpia*/
				final Session session = this.sessionFactory.getCurrentSession();
				
				/*Se obtienen los codigo de los articulo relacionados existentes para actualizar*/
				Collection<String> codigoRelacionadosExistentes = this.obtenerCodigosArticulosRelacionadosExistentes(codigoCompania, codigoArticulo, valorTipoRelacion, codigosArticulosRelacionados);
				
				/*Se obtienen los codigo de los articulo relacionados nuevos para crear*/
				Collection<String> codigoRelacionadosNuevos = new ArrayList<String>(Arrays.asList(codigosArticulosRelacionados));
				
				codigoRelacionadosNuevos.removeAll(codigoRelacionadosExistentes);
				
				if(CollectionUtils.isNotEmpty(codigoRelacionadosExistentes)){
					/*Se limpia la sesion del hibernate*/
					session.clear();
					
					/*Se prepara el hql de actualizacion*/
					StringBuilder hqlUpdate = new StringBuilder("update ").append(ArticuloRelacionDTO.class.getName()).append(" ar set estado = :pEstado, idUsuarioModificacion = :pUserId, fechaModificacion = current_timestamp() ")
					.append("where ar.id.codigoCompania = :pCodigoCompania and ar.id.codigoArticulo = :pCodigoArticulo and ar.id.codigoArticuloRelacionado in (:pCodigosRelacionados) and ar.codigoTipoRelacion = :pCodigoTipoRelacion and ar.valorTipoRelacion = :pValorTipoRelacion and ar.estado <> :pEstado");
					
					/*Se prepara el query de actualizacion*/
					Query query = session.createQuery(hqlUpdate.toString());				
					
					/*Se asignan los parametros al query*/
					query.setParameter("pCodigoCompania", codigoCompania);
					query.setParameter("pCodigoArticulo", codigoArticulo);
					query.setParameterList("pCodigosRelacionados", codigosArticulosRelacionados);
					query.setParameter("pCodigoTipoRelacion", SICArticuloConstantes.CODIGOTIPOARTICULORELACION);
					query.setParameter("pValorTipoRelacion", valorTipoRelacion);
					query.setParameter("pEstado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
					query.setParameter("pUserId", userId);
					
					/*Ejecutamos y realizamos commit del registro*/
					count = query.executeUpdate();
					
				}
				
				if(CollectionUtils.isNotEmpty(codigoRelacionadosNuevos)){
					/*Se obtiene la sesion de hibernate y se limpia*/
					session.clear();
					
					/*Se prepara el SQL de insercion*/
					StringBuilder sqlInsert = new StringBuilder("INSERT INTO SCSADTARTREL (CODIGOCOMPANIA, CODIGOARTICULO, CODIGOARTICULORELACIONADO, CANTIDAD, CODIGOTIPORELACION, VALORTIPORELACION, ESTADO, IDUSUARIOREGISTRO, FECHAREGISTRO) ")
					.append("VALUES(:pCodigoCompania, :pCodigoArticulo, :pCodigoArticuloRelacionado, :pCantidad, :pCodigoTipoRelacion, :pValorTipoRelacion, :pEstado, :pUserId, CURRENT_TIMESTAMP)");
					
					/*Se prepara el query de actualizacion*/
					Query query = session.createSQLQuery(sqlInsert.toString());
					
					/*Se asignan los parametros al query*/
					query.setParameter("pCodigoCompania", codigoCompania);
					query.setParameter("pCodigoArticulo", codigoArticulo);
					query.setParameter("pCantidad", SICArticuloConstantes.CANTIDAD_DEFAULT_RELACION_ARTICULO);
					query.setParameter("pCodigoTipoRelacion", SICArticuloConstantes.CODIGOTIPOARTICULORELACION);
					query.setParameter("pValorTipoRelacion", valorTipoRelacion);
					query.setParameter("pEstado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
					query.setParameter("pUserId", userId);
					
					for(String codigoRelacionadoNuevo : codigoRelacionadosNuevos){
						query.setParameter("pCodigoArticuloRelacionado", codigoRelacionadoNuevo);
						/*Ejecutamos y realizamos commit del registro*/
						count = count + query.executeUpdate();
					}
				}
			}
			
			return count;
		} catch (Exception e) {
			throw new SICException(MessageFormat.format("Ha ocurrido un error al asociar los art\u00EDculos con relacion {0}", valorTipoRelacion), e);
		}
	}
	
	/**
	 * Metodo que permite obtener el total de articulos relacionados con un tipo especifico
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param valorTipoRelacion
	 * @param codigoArticuloRelacionado
	 * @return
	 * @throws SICException
	 */
	public Long countArticuloRelacionado(Integer codigoCompania, String codigoArticulo, String valorTipoRelacion, String codigoArticuloRelacionado) throws SICException{
		LOG_SICV2.info("==> Conteo ArticuloRelacionado.");
		Long count = 0L;//variable que obtendra el numero total articulos relacionados
		Session session = null;
		Criteria criteria = null;
		try {
			/*Se obtiene la sesion de hibernate y se limpia*/
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			/*Se prepara el Criteria para el conteo*/
			criteria = session.createCriteria(ArticuloRelacionDTO.class, "ar");
			criteria.setProjection(Projections.rowCount());
			criteria.add(Restrictions.eq("ar.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("ar.id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("ar.id.codigoArticuloRelacionado", codigoArticuloRelacionado));
			criteria.add(Restrictions.eq("ar.valorTipoRelacion", valorTipoRelacion));
			
			/*Ejecutamos el criteria*/
			count = (Long) criteria.uniqueResult();
			
		} catch (Exception e) {
			throw new SICException(MessageFormat.format("Ha ocurrido un error al contar los art\u00EDculos con relacion {0}", valorTipoRelacion), e);
		}
		return count;
	}
	
	/**
	 * Metodo que obtiene los codigos de articulos relacionados a un articulo especifico
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param valorTipoRelacion
	 * @param codigosArticulosRelacionados
	 * @return
	 * @throws SICException
	 */
	private Collection<String> obtenerCodigosArticulosRelacionadosExistentes(Integer codigoCompania, String codigoArticulo, String valorTipoRelacion, String... codigosArticulosRelacionados) throws SICException{
		LOG_SICV2.info("==> Obtener codigos articulos relacionados existentes.");
		Collection<String> codigosArticulosRelacionadosExistentes = null;
		Session session = null;
		Criteria criteria = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloRelacionDTO.class, "ar");
			criteria.setProjection(Projections.property("id.codigoArticuloRelacionado"));
			criteria.add(Restrictions.eq("ar.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("ar.id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.in("ar.id.codigoArticuloRelacionado", codigosArticulosRelacionados));			
			criteria.add(Restrictions.eq("ar.valorTipoRelacion", valorTipoRelacion));
			codigosArticulosRelacionadosExistentes = criteria.list();
			
		} catch (Exception e) {
			throw new SICException(MessageFormat.format("Ha ocurrido un error al obtener los c\u00F3digos de art\u00EDculos relacionados de tipo {0}", valorTipoRelacion), e);
		}
		return codigosArticulosRelacionadosExistentes;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloRelacionDTO> obtenerArticulosRelacionadosCol(Integer codigoCompania, Collection<String> codigosBarrasArticulo, String valorTipoRelacion, String codigoTipoArticulo) throws SICException{
		Collection<ArticuloRelacionDTO> articulosRelacionadosCol = null;
		Criteria criteria = null;
		try{
			this.sessionFactory.getCurrentSession().clear();
			criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloRelacionDTO.class, "AR");
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("AR.id.codigoCompania"), "id.codigoCompania")
					.add(Projections.property("AR.id.codigoArticulo"), "id.codigoArticulo")
					.add(Projections.property("AR.id.codigoArticuloRelacionado"), "id.codigoArticuloRelacionado")
					.add(Projections.property("AR.valorTipoRelacion"), "valorTipoRelacion")
					.add(Projections.property("AR.articuloRelacion.id.codigoArticulo"), "articuloRelacion.id.codigoArticulo"));
			
			criteria.createAlias("articulo", "A");
			
			criteria.add(Restrictions.eq("AR.id.codigoCompania", codigoCompania));
			
			if(codigosBarrasArticulo.size() == 1){
				criteria.add(Restrictions.eq("A.codigoBarras", codigosBarrasArticulo.iterator().next()));
			}else{
				criteria.add(Restrictions.in("A.codigoBarras", codigosBarrasArticulo));
			}
			
			criteria.add(Restrictions.eq("AR.valorTipoRelacion", valorTipoRelacion));
			criteria.add(Restrictions.eq("AR.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			if(StringUtils.isNotBlank(codigoTipoArticulo)){
				criteria.createAlias("articuloRelacion", "ARE");
				criteria.add(Restrictions.eq("ARE.codigoTipoArticulo", codigoTipoArticulo));
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloRelacionDTO.class));
			
			articulosRelacionadosCol = criteria.list();
			
			return articulosRelacionadosCol;
			
		}catch(SICException e){
			throw new SICException(MessageFormat.format("Ha ocurrido un error al obtener los articulos relacionados {0}", valorTipoRelacion), e);
		}
	}
}
