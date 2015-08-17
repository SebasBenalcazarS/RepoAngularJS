package ec.com.smx.sic.articulo.persistence.dao.preciodiferenciado;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado.IArticuloPrecioDiferenciadoDAO;

public class ArticuloPrecioDiferenciadoDAO implements Logeable, IArticuloPrecioDiferenciadoDAO{

	private IHibernateH<ArticuloPrecioDiferenciadoDTO> hibernateH;
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloPrecioDiferenciadoDAO#obtenerArticuloPrecioDiferenciado(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Collection<ArticuloPrecioDiferenciadoDTO> obtenerArticulosPrecioDiferenciado(Integer codigoCompania, String codigoArticulo, String estado) throws SICException {
		Logeable.LOG_SICV2.info(":: obtenerArticuloPrecioDiferenciado ::");
		
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("select artpre from ").append(ArticuloPrecioDiferenciadoDTO.class.getName()).append(" artpre ")
			.append("where artpre.id.codigoCompania = :pCompania ")
			.append("and artpre.codigoArticulo = :pCodigoArticulo ")
			.append("and artpre.estado = :pEstado ");
			
			Query select = session.createQuery(query.toString());
						
			//parametros 
			select.setInteger("pCompania", codigoCompania);
			select.setString("pCodigoArticulo", codigoArticulo);
			select.setString("pEstado", estado);
			
			return select.list();
			
		} catch (Exception e) {
			throw new SICException("Error al buscar la informaci\u00F3n de art\u00EDculo precio diferenciado.", e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloPrecioDiferenciadoDAO#guardarArticuloPrecioDiferenciado(ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO)
	 */
	public void guardarArticuloPrecioDiferenciado(ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciadoDTO) throws SICException{
		Logeable.LOG_SICV2.info(":: guardarArticuloPrecioDiferenciado ::");
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			hibernateH.crearObjeto(articuloPrecioDiferenciadoDTO);
			session.flush();
			
		} catch (Exception e) {
			throw new SICException("Error al guardar el art\u00EDculo precio diferenciado.", e);
		}
	}
	
	@Override
	public void actualizarArticuloPrecioDiferenciado(ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciadoDTO) throws SICException{
		Logeable.LOG_SICV2.info(":: actualizarArticuloPrecioDiferenciado ::");
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			//hibernateH.actualizarObjeto(articuloPrecioDiferenciadoDTO);
			
			StringBuilder query = new StringBuilder();
			query.append("update ").append(ArticuloPrecioDiferenciadoDTO.class.getName())
			.append(" set valor = :pValor " )
			.append(" , porcentajeMargen = :pPorcentaje " );
			if( articuloPrecioDiferenciadoDTO.getValorAnterior()!=null ){
				query.append(" , valorAnterior = :pValorAnterior " );
			}
			if( articuloPrecioDiferenciadoDTO.getPorcentajeMargenAnterior()!=null ){
				query.append(" , porcentajeMargenAnterior = :pPorcentajeAnterior " );
			}
			query.append(" , estado = :pEstado " )
			.append(" , codigoTipoPrecio = :pCodigoTipoPrecio " )
			.append(" , idUsuarioModificacion = :pIdUsuarioModificacion, fechaModificacion = :pFechaModificacion ")
			.append("where codigoCompania = :pCompania ")
			.append("and secuencial = :pSecuencial ");
			
			Query select = session.createQuery(query.toString());
						
			//parametros 
			select.setInteger("pCompania", articuloPrecioDiferenciadoDTO.getId().getCodigoCompania());
			select.setLong("pSecuencial", articuloPrecioDiferenciadoDTO.getId().getSecuencial());
			select.setDouble("pValor", articuloPrecioDiferenciadoDTO.getValor());
			select.setDouble("pPorcentaje", articuloPrecioDiferenciadoDTO.getPorcentajeMargen());
			if( articuloPrecioDiferenciadoDTO.getValorAnterior()!=null ){
				select.setDouble("pValorAnterior", articuloPrecioDiferenciadoDTO.getValorAnterior());
			}
			if( articuloPrecioDiferenciadoDTO.getPorcentajeMargenAnterior()!=null ){
				select.setDouble("pPorcentajeAnterior", articuloPrecioDiferenciadoDTO.getPorcentajeMargenAnterior());
			}
			select.setString("pEstado", articuloPrecioDiferenciadoDTO.getEstado());
			select.setString("pCodigoTipoPrecio", articuloPrecioDiferenciadoDTO.getCodigoTipoPrecio());
			select.setString("pIdUsuarioModificacion", articuloPrecioDiferenciadoDTO.getIdUsuarioModificacion());
			select.setTimestamp("pFechaModificacion", articuloPrecioDiferenciadoDTO.getFechaModificacion());
			
			
			Integer total = select.executeUpdate();
			LOG_SICV2.info("Se actualizo ArticuloPrecioDiferenciado = ", total);
					
			session.flush();
			
		} catch (Exception e) {
			throw new SICException("Error al actualizar el art\u00EDculo precio diferenciado.", e);
		}
	}
	
	@Override
	public Collection<ArticuloPrecioDiferenciadoDTO> buscarArticuloPrecioDiferenciadoPorValor(ArticuloPrecioDiferenciadoDTO artPreDif) throws SICException {
		Logeable.LOG_SICV2.info(":: obtenerArticuloPrecioDiferenciado ::");
		
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("from ").append(ArticuloPrecioDiferenciadoDTO.class.getName()).append(" artpre ")
			.append("where artpre.id.codigoCompania = :pCompania ");
//			if( artPreDif.getId().getSecuencial() != null ){
//				query.append("and artpre.id.secuencial = :pSecuencial ");
//			}else{
				query.append("and artpre.valor = :pValor ");
//			}
			query.append("and artpre.codigoArticulo = :pCodigoArticulo ")	
			.append("and artpre.estado = :pEstado ");		
			
			Query select = session.createQuery(query.toString());
						
			//parametros 
			select.setInteger("pCompania", artPreDif.getId().getCodigoCompania());
//			if( artPreDif.getId().getSecuencial() != null ){
//				select.setDouble("pSecuencial", artPreDif.getId().getSecuencial());
//			}else{
				select.setDouble("pValor", artPreDif.getValor());
//			}
			select.setString("pCodigoArticulo", artPreDif.getCodigoArticulo());
			select.setString("pEstado", SICConstantes.ESTADO_INACTIVO_NUMERICO);
			
			
			return select.list();
			
		} catch (Exception e) {
			throw new SICException("Error al buscar la informaci\u00F3n de art\u00EDculo precio diferenciado.", e);
		}
	}
	
	public void setHibernateH(IHibernateH<ArticuloPrecioDiferenciadoDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}

}

