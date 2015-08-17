package ec.com.smx.sic.articulo.persistence.dao.preciodiferenciado;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.ISequenceDataBase;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.SequenceValueAddition;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoEjecucionGestionPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.BitacoraArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraArticuloLocalPrecioID;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado.IArticuloLocalGestionPrecioDAO;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

public class ArticuloLocalGestionPrecioDAO implements Logeable, IArticuloLocalGestionPrecioDAO{

	private IHibernateH<ArticuloLocalGestionPrecioDTO> hibernateH;
	private ISequenceDataBase sequenceGenerator;
	
	public ISequenceDataBase getSequenceGenerator() {
		return sequenceGenerator;
	}

	public void setSequenceGenerator(ISequenceDataBase sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado.IArticuloLocalGestionPrecioDAO#guardarArticuloLocalGestionPrecio(ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO)
	 */
	public void guardarArticuloLocalGestionPrecio(ArticuloLocalGestionPrecioDTO articuloLocalGestionPrecioDTO) throws SICException{
		Logeable.LOG_SICV2.info(":: guardarArticuloLocalGestionPrecio ::");
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
				
			hibernateH.crearObjeto(articuloLocalGestionPrecioDTO);
			
			session.flush();
			
		} catch (Exception e) {
			throw new SICException("Error al guardar el art\u00EDculo local gesti\u00F3n precio.", e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado.IArticuloLocalGestionPrecioDAO#actualizarArticuloLocalGestionPrecio(ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO)
	 */
	public void actualizarArticuloLocalGestionPrecio(ArticuloLocalGestionPrecioDTO articuloLocalGestionPrecioDTO) throws SICException{
		Logeable.LOG_SICV2.info(":: actualizarArticuloLocalGestionPrecio ::");
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query.append("update ").append(ArticuloLocalGestionPrecioDTO.class.getName()).append(" artlocalpre ")
			.append("set artlocalpre.estado = :pEstado, artlocalpre.codigoLocal = :pcodigoAreaTrabajo, artlocalpre.fechaInicio = :pfechaInicio, ")
			.append(" artlocalpre.fechaFin = :pfechaFin, artlocalpre.idUsuarioModificacion = :pidUsuarioModificacion, artlocalpre.fechaModificacion = :pfechaModificacion ")
			.append("where artlocalpre.id.codigoCompania = :pCompania ")
			.append("and artlocalpre.id.secuencialArtLocGesPre = :psecuencialArtLocGesPre ")
			.append("and artlocalpre.secuencialPreDif = :psecuencialPreDif ")
			.append("and artlocalpre.codigoArticulo = :pCodigoArticulo ");
			
			Query update = session.createQuery(query.toString());
						
			//parametros 
			update.setInteger("pCompania", articuloLocalGestionPrecioDTO.getId().getCodigoCompania());
			update.setLong("psecuencialArtLocGesPre", articuloLocalGestionPrecioDTO.getId().getSecuencialArtLocGesPre());
			update.setString("pCodigoArticulo", articuloLocalGestionPrecioDTO.getCodigoArticulo());
			update.setLong("psecuencialPreDif", articuloLocalGestionPrecioDTO.getSecuencialPreDif());
			update.setString("pEstado", articuloLocalGestionPrecioDTO.getEstado());
			update.setInteger("pcodigoAreaTrabajo", articuloLocalGestionPrecioDTO.getCodigoLocal());
			update.setTimestamp("pfechaInicio", articuloLocalGestionPrecioDTO.getFechaInicio());
			update.setTimestamp("pfechaFin", articuloLocalGestionPrecioDTO.getFechaFin());
			update.setString("pidUsuarioModificacion", articuloLocalGestionPrecioDTO.getIdUsuarioModificacion());
			update.setTimestamp("pfechaModificacion", articuloLocalGestionPrecioDTO.getFechaModificacion());
			
			Integer result = update.executeUpdate();
			LOG_SICV2.info("Registros actualizados", result);	
			
			session.flush();
			
		} catch (Exception e) {
			throw new SICException("Error al actulizar el art\u00EDculo local gesti\u00F3n precio.", e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado.IArticuloLocalGestionPrecioDAO#obtenerArticulosLocalPrecio(java.lang.Integer, java.lang.String, java.lang.Long, java.lang.String)
	 */
	public Collection<ArticuloLocalGestionPrecioDTO> obtenerArticulosLocalPrecio(Integer codigoCompania, String codigoArticulo, Long secuenciaPreDif, String estado) throws SICException {
		Logeable.LOG_SICV2.info(":: obtenerArticulosLocalPrecio ::");
		
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("select artlocalpre from ").append(ArticuloLocalGestionPrecioDTO.class.getName()).append(" artlocalpre ")
			.append("where artlocalpre.id.codigoCompania = :pCompania ")
			.append("and artlocalpre.secuencialPreDif = :psecuencialPreDif ")
			.append("and artlocalpre.codigoArticulo = :pCodigoArticulo ")
			.append("and artlocalpre.estado = :pEstado ");
			
			Query select = session.createQuery(query.toString());
						
			//parametros 
			select.setInteger("pCompania", codigoCompania);
			select.setString("pCodigoArticulo", codigoArticulo);
			select.setLong("psecuencialPreDif", secuenciaPreDif);
			select.setString("pEstado", estado);
			
			return select.list();
			
		} catch (Exception e) {
			throw new SICException("Error al buscar la informaci\u00F3n de art\u00EDculo precio diferenciado.", e);
		}
	}

	public void setHibernateH(IHibernateH<ArticuloLocalGestionPrecioDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}

	
	public Collection<ArticuloLocalGestionPrecioDTO> obtenerArticulosLocalesPreciosPlanificados(Integer codigoCompania, Date fechaCierre) throws SICException{
		Session session;
		try {
	
			session = hibernateH.getHibernateSession();
			session.clear();
			
			Criteria cr = session.createCriteria(ArticuloLocalGestionPrecioDTO.class, "algp");
			
			//Join
			cr.createAlias("algp.articuloPrecioDif", "artPreDif");
				
			//where
			cr.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			cr.add(Restrictions.le("fechaInicio", fechaCierre));
			cr.add(Restrictions.eq("codigoEstadoEjecucion", EstadoEjecucionGestionPrecio.CODIGO_ESTADO_EJECUCION_GESTION_PRECIO));
			cr.add(Restrictions.not(Restrictions.eq("valorEstadoEjecucion", EstadoEjecucionGestionPrecio.FINALIZADO.getValorEstadoEjecucionGestionPrecio())));
			
			return cr.list();
		} catch (Exception e) {
			throw new SICException("Error al obtener los precios planificados con fecha de cierre " + fechaCierre);
		}
	}

	@Override
	public void actualizarEstadoEjecucionArticuloLocalGestionPrecio(ArticuloLocalGestionPrecioDTO articuloLocalGestionPrecioDTO, String userId) throws SICException {
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query.append("update ").append(ArticuloLocalGestionPrecioDTO.class.getName()).append(" artlocalpre ")
			.append("set artlocalpre.idUsuarioModificacion = :pIdUsuarioModificacion, artlocalpre.fechaModificacion = :pfechaModificacion, artlocalpre.valorEstadoEjecucion = :pValorEstadoEjecucion ")
			.append("where artlocalpre.id.codigoCompania = :pCompania ")
			.append("and artlocalpre.id.secuencialArtLocGesPre = :psecuencialArtLocGesPre ")
			.append("and artlocalpre.secuencialPreDif = :psecuencialPreDif ")
			.append("and artlocalpre.codigoArticulo = :pCodigoArticulo ");
			
			Query update = session.createQuery(query.toString());
						
			//parametros 
			update.setInteger("pCompania", articuloLocalGestionPrecioDTO.getId().getCodigoCompania());
			update.setLong("psecuencialArtLocGesPre", articuloLocalGestionPrecioDTO.getId().getSecuencialArtLocGesPre());
			update.setString("pCodigoArticulo", articuloLocalGestionPrecioDTO.getCodigoArticulo());
			update.setString("pValorEstadoEjecucion", articuloLocalGestionPrecioDTO.getValorEstadoEjecucion());
			update.setString("pIdUsuarioModificacion", userId);
			update.setLong("psecuencialPreDif", articuloLocalGestionPrecioDTO.getSecuencialPreDif());
			update.setTimestamp("pfechaModificacion", articuloLocalGestionPrecioDTO.getFechaModificacion());
			
			Integer result = update.executeUpdate();
			LOG_SICV2.info("Registros actualizados", result);	
			
		} catch (Exception e) {
			throw new SICException("Error al actulizar el art\u00EDculo local gesti\u00F3n precio.", e);
		}
		
	}

	@Override
	public void eliminarPreciosArticulosLocalFinalizados(ArticuloLocalGestionPrecioDTO articuloLocalGestionPrecio, String userId) throws SICException {
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			BitacoraArticuloLocalPrecioDTO bitacora = new BitacoraArticuloLocalPrecioDTO();
			bitacora.getId().setCodigoCompania(articuloLocalGestionPrecio.getId().getCodigoCompania());
			bitacora.setCodigoArticulo(articuloLocalGestionPrecio.getCodigoArticulo());
			bitacora.setCodigoLocal(articuloLocalGestionPrecio.getCodigoLocal());
			bitacora.setCodigoTipoPrecio(articuloLocalGestionPrecio.getArticuloPrecioDif().getCodigoTipoPrecio());
			bitacora.setValor(articuloLocalGestionPrecio.getArticuloPrecioDif().getValor());
			bitacora.setFechaInicioActivo(articuloLocalGestionPrecio.getFechaInicio());
			bitacora.setFechaFinActivo(articuloLocalGestionPrecio.getFechaFin());
			bitacora.setUserId(userId);
			SequenceValueAddition addition = null;
			Long codigoSec = sequenceGenerator.getNextSequenceValue(DescriptorSecuenciasSIC.NOMBRE_ESQUEMA, BitacoraArticuloLocalPrecioID.NOMBRE_SECUENCIA, Long.class, addition);
			bitacora.getId().setSecuencialBitacora(codigoSec);
			session.save(bitacora);
			
			query = new StringBuilder();
			query.append("delete from  ").append(ArticuloLocalGestionPrecioDTO.class.getName()).append(" artlocalpre ")
			.append("where artlocalpre.id.codigoCompania = :pCompania ")
			.append("and artlocalpre.id.secuencialArtLocGesPre = :pSecuencialArtLocGesPre ");
			
			Query delete = session.createQuery(query.toString());
			//parametros 
			delete.setInteger("pCompania", articuloLocalGestionPrecio.getId().getCodigoCompania());
			delete.setLong("pSecuencialArtLocGesPre", articuloLocalGestionPrecio.getId().getSecuencialArtLocGesPre());
			delete.executeUpdate();
		} catch (Exception e) {
			throw new SICException("Error al eliminar los precios planificados finalizados");
		}
		
	}
}

