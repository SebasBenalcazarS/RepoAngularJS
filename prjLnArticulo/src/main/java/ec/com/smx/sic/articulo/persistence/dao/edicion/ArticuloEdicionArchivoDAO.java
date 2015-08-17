/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.edicion;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.ManejoFechas;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloTemporadaDTO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.informacion.ArticuloInfoVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author eharo
 *
 */
public class ArticuloEdicionArchivoDAO implements IArticuloEdicionArchivoDAO, Logeable {
	
	SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO#imprimirAcceso(java.lang.String)
	 */
	@Override
	public void imprimirAcceso(String nombre) throws SICException {

		Logeable.LOG_SICV2.info("LLEGO AL DAO. " + ArticuloEdicionArchivoDAO.class.getName());
		Logeable.LOG_SICV2.info("El nombre ingresado es: " + nombre);
		
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO#listaCabecerasEdicion(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoValorDTO> listaCabecerasEdicion(Integer tipoCabeceras) throws SICException {
		List<CatalogoValorDTO> cabecerasEdicion = null;
		Session session = null;
		try{
			if(tipoCabeceras != null){
				session = sessionFactory.getCurrentSession();
				session.clear();
				
				Criteria criteria = session.createCriteria(CatalogoValorDTO.class, "cabeceras");
				criteria.add(Restrictions.eq("cabeceras.id.codigoCatalogoTipo", tipoCabeceras));
				criteria.add(Restrictions.eq("cabeceras.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.addOrder(Order.asc("cabeceras.orden"));
				
				cabecerasEdicion = criteria.list();
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al encontrar las cabeceras. {}", e.getMessage());
		}
		return cabecerasEdicion;
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO#obtenerCodigoArticuloDesdeCodigoBarras(java.lang.Integer, java.lang.String)
	 */
	@Override
	public String obtenerCodigoArticuloDesdeCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException {
		String codigoArticulo = StringUtils.EMPTY;
		Session session = null;
		StringBuilder hql = null;
		Query query = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(StringUtils.trim(codigoBarras))){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				hql = new StringBuilder();
				
				hql.append("select bcb.id.codigoArticulo from ").append(ArticuloBitacoraCodigoBarrasDTO.class.getName()).append(" bcb ");
				hql.append(" where ");
				hql.append(" bcb.id.codigoCompania = :pCodigoCompania ");
				hql.append(" and bcb.id.codigoBarras = :pCodigoBarras ");
				hql.append(" and bcb.estadoArticuloBitacora = :pEstadoActivoNumerico ");
				
				query = session.createQuery(String.valueOf(hql));
				query.setInteger("pCodigoCompania", codigoCompania);
				query.setString("pCodigoBarras", codigoBarras);
				query.setString("pEstadoActivoNumerico", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				codigoArticulo = String.valueOf(query.uniqueResult());
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al buscar el codigo de articulo. {}", e.getMessage());
		}finally{
			session = null;
			hql = null;
			query = null;
		}
		return codigoArticulo;
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO#editarClaseArticulo(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO)
	 */
	@Override
	public Integer editarClaseArticulo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException {
		Integer editado = 0;
		String claseArticulo = StringUtils.EMPTY;
		try{
			if(articuloEdicionMasivaArchivoVO != null){
				claseArticulo = articuloEdicionMasivaArchivoVO.getClase();
				if(StringUtils.equals(claseArticulo, SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada"))){
					editarArticuloClase(articuloEdicionMasivaArchivoVO);
					editarArticuloTemporada(articuloEdicionMasivaArchivoVO);
					editado = 1;
				}else{
					editarArticuloClase(articuloEdicionMasivaArchivoVO);
					editado = 1;
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al editar el articulo. {}", e.getMessage());
		}
		return editado;
	}
	
	private Integer editarArticuloClase(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO){
		Integer editado = 0;
		Session session = null;
		Timestamp fechaActual = null;
		Query query = null;
		StringBuilder update = null;
		try{
			
			if(articuloEdicionMasivaArchivoVO != null){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				fechaActual = new Timestamp(Calendar.getInstance().getTimeInMillis());
				
				update = new StringBuilder();
				update.append("update ").append(ArticuloDTO.class.getName())
				.append("  set claseArticulo = :pClaseArticulo ")
				.append(", fechaUltimaActualizacion = :pFechaUltimaActualizacion ")
				.append(", usuarioActualizacion = :pUsuarioActualizacion ")
				.append("  where ")
				.append(" id.codigoCompania = :pCodigoCompania ")
				.append(" and ")
				.append(" id.codigoArticulo = :pCodigoArticulo ");
				
				query = session.createQuery(String.valueOf(update));
				query.setString("pClaseArticulo", articuloEdicionMasivaArchivoVO.getClase());
				query.setTimestamp("pFechaUltimaActualizacion", fechaActual);
				query.setString("pUsuarioActualizacion", articuloEdicionMasivaArchivoVO.getUsuarioModificacion());
				query.setInteger("pCodigoCompania", articuloEdicionMasivaArchivoVO.getCodigoCompania());
				query.setString("pCodigoArticulo", articuloEdicionMasivaArchivoVO.getCodigoArticulo());
				
				editado = query.executeUpdate();
				
				session.flush();
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al editar el articulo clase. {}", e.getMessage());
		}finally{
			session = null;
			fechaActual = null;
			query = null;
		}
		return editado;
	}
	
	private Integer editarArticuloTemporada(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO){
		Integer editado = 0;
		Boolean existeArticuloTemp = Boolean.FALSE;
		ArticuloTemporadaDTO articuloTemporadaDTO = null;
		try{
			if(articuloEdicionMasivaArchivoVO != null){
				articuloTemporadaDTO = verificarExisteArticuloTemporada(articuloEdicionMasivaArchivoVO);
				
				if(articuloTemporadaDTO != null){
					existeArticuloTemp = Boolean.TRUE;
				}
			}
			if(existeArticuloTemp){
				actualizarArticuloTemporada(articuloEdicionMasivaArchivoVO, articuloTemporadaDTO);
			}else{
				crearArticuloTemporada(articuloEdicionMasivaArchivoVO);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al editar el articulo temporada. {}", e.getMessage());
		}
		return editado;
	}
	
	private ArticuloTemporadaDTO verificarExisteArticuloTemporada(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO){
		ArticuloTemporadaDTO existe = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(articuloEdicionMasivaArchivoVO != null){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloTemporadaDTO.class, "artTemp");
				criteria.add(Restrictions.eq("artTemp.id.codigoCompania", articuloEdicionMasivaArchivoVO.getCodigoCompania()));
				criteria.add(Restrictions.eq("artTemp.id.codigoArticulo", articuloEdicionMasivaArchivoVO.getCodigoArticulo()));
				
				existe = (ArticuloTemporadaDTO) criteria.uniqueResult();
				
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al verificarExisteArticuloTemporada. {}", e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return existe;
	}
	
	private Integer actualizarArticuloTemporada(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, ArticuloTemporadaDTO articuloTemporadaDTO){
		Integer actualizado = 0;
		Session session = null;
		Timestamp fechaActual = null;
		try{
			if(articuloEdicionMasivaArchivoVO != null && articuloTemporadaDTO != null){
				
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				fechaActual = new Timestamp(Calendar.getInstance().getTimeInMillis());
				
				articuloTemporadaDTO.setFechaInicioTemporada(ManejoFechas.convertStringDate(articuloEdicionMasivaArchivoVO.getFechaInicioTemporada()));
				articuloTemporadaDTO.setFechaFinTemporada(ManejoFechas.convertStringDate(articuloEdicionMasivaArchivoVO.getFechaFinTemporada()));
				articuloTemporadaDTO.setFechaModificacion(fechaActual);
				articuloTemporadaDTO.setIdUsuarioModificacion(articuloEdicionMasivaArchivoVO.getUsuarioModificacion());
				
				session.update(articuloTemporadaDTO);
//				session.getTransaction().commit();
				session.flush();
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al actualizar el articulo temporada. {}", e.getMessage());
		}
		return actualizado;
	}
	
	private void crearArticuloTemporada(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO){
		ArticuloTemporadaDTO articuloTemporadaDTO = null;
		Session session = null;
		Timestamp fechaActual = null;
		try{
			if(articuloEdicionMasivaArchivoVO != null){
				
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				fechaActual = new Timestamp(Calendar.getInstance().getTimeInMillis());
				articuloTemporadaDTO = new ArticuloTemporadaDTO();
				articuloTemporadaDTO.getId().setCodigoArticulo(articuloEdicionMasivaArchivoVO.getCodigoArticulo());
				articuloTemporadaDTO.getId().setCodigoCompania(articuloEdicionMasivaArchivoVO.getCodigoCompania());
				articuloTemporadaDTO.setFechaInicioTemporada(ManejoFechas.convertStringDate(articuloEdicionMasivaArchivoVO.getFechaInicioTemporada()));
				articuloTemporadaDTO.setFechaFinTemporada(ManejoFechas.convertStringDate(articuloEdicionMasivaArchivoVO.getFechaFinTemporada()));
				articuloTemporadaDTO.setRegisterUserId(articuloEdicionMasivaArchivoVO.getUsuarioModificacion());
				articuloTemporadaDTO.setIdUsuarioRegistro(articuloEdicionMasivaArchivoVO.getUsuarioModificacion());
				articuloTemporadaDTO.setFechaRegistro(fechaActual);
				articuloTemporadaDTO.setRegisterDate(fechaActual);
				
				session.save(articuloTemporadaDTO);
				session.flush();
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar crear el articulo temporada. {}", e.getMessage());
		}
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO#obtenerUsuario(java.lang.String)
	 */
	@Override
	public UserDto obtenerUsuario(String usuarioId) throws SICException {
		UserDto usuario = null;
		Criteria criteria = null;
		Session session = null;
		try{
			session = this.sessionFactory.getCurrentSession();
			session.clear();

			criteria = session.createCriteria(UserDto.class, "usu");
			criteria.add(Restrictions.eq("usu.userId", usuarioId));
			
			usuario = (UserDto) criteria.uniqueResult();
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar buscar el usuario. {}", e.getMessage());
		}
		return usuario;
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO#codigoTipoArticulo(java.lang.Integer, java.lang.String)
	 */
	@Override
	public ArticuloInfoVO obtenerArticuloEdicionArchivo(Integer codigoCompania, String codigoBarras) throws SICException {
		ArticuloInfoVO articulo = null;
		Session session = null;
		StringBuilder hql = null;
		Query query = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(StringUtils.trim(codigoBarras))){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				hql = new StringBuilder();
				
				hql.append("select a.id.codigoArticulo as codigoArticulo, a.codigoTipoArticulo as codigoTipoArticulo, a.claseArticulo as claseArticulo from ").append(ArticuloDTO.class.getName()).append(" a ")
				.append(" where ")
				.append(" a.id.codigoCompania = :pCodigoCompania ")
				.append(" and a.id.codigoArticulo  = (")
				.append(" select ab.id.codigoArticulo from ").append(ArticuloBitacoraCodigoBarrasDTO.class.getName()).append(" ab ")
				.append(" where ")
				.append(" ab.id.codigoBarras = :pCodigoBarras ")
				.append(" and ab.id.codigoCompania = :pCodigoCompania ")
				.append(" and ab.estadoArticuloBitacora = :pEstadoActivoNumerico) ");
				
				query = session.createQuery(String.valueOf(hql));
				query.setInteger("pCodigoCompania", codigoCompania);
				query.setString("pCodigoBarras", codigoBarras);
				query.setString("pEstadoActivoNumerico", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				query.setResultTransformer(Transformers.aliasToBean(ArticuloInfoVO.class));
				
				articulo = (ArticuloInfoVO) query.uniqueResult();
			}
			
			return articulo;
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener ArticuloEdicionArchivo. {}", e.getMessage());
			throw new SICException("Ha ocurrido un error al obtener ArticuloEdicionArchivo.", e);
		}finally{
			session = null;
		}
		
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO#validarCodigoBarras(java.lang.Integer, java.lang.String, org.hibernate.criterion.Criterion)
	 */
	@Override
	public Boolean validarExisteCodigoBarras(Integer codigoCompania, String codigoBarras, Criterion usuarioLineaComercial) throws SICException {
		Boolean existeCodigoBarras = Boolean.FALSE;
		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = null;
		Session session = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(StringUtils.trim(codigoBarras)) && usuarioLineaComercial != null){
				articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
				session = sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
					
				Criteria criteria = session.createCriteria(ArticuloBitacoraCodigoBarrasDTO.class, "bitCodigoBarras");
				criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("id.codigoBarras", codigoBarras));
				criteria.add(Restrictions.eq("estadoArticuloBitacora", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.createAlias("articulo", "articulo");
				criteria.add(usuarioLineaComercial);
				
				articuloBitacoraCodigoBarrasDTO = (ArticuloBitacoraCodigoBarrasDTO) criteria.uniqueResult();
				existeCodigoBarras = (articuloBitacoraCodigoBarrasDTO != null ? Boolean.TRUE : Boolean.FALSE);
				
				session.flush();
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar si existe el articulo por codigo de barras. {}", e.getMessage());
		}
		return existeCodigoBarras;
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO#obtenerClaseAnteriorArticulo(java.lang.Integer, java.lang.String)
	 */
	@Override
	public String obtenerClaseAnteriorArticulo(Integer codigoCompania, String codigoArticulo) throws SICException {
		Session session = null;
		StringBuilder hql = null;
		Query query = null;
		String claseAnterior = StringUtils.EMPTY;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				hql = new StringBuilder();
				
				hql.append("select a.claseArticulo from ").append(ArticuloDTO.class.getName()).append(" a ")
				.append(" where ")
				.append(" a.id.codigoCompania = :pCodigoCompania ")
				.append(" and a.id.codigoArticulo  = :pCodigoArticulo ")
				.append(" and a.estadoArticulo = :pEstadoActivoNumerico ");
				
				query = session.createQuery(String.valueOf(hql));
				query.setInteger("pCodigoCompania", codigoCompania);
				query.setString("pCodigoArticulo", codigoArticulo);
				query.setString("pEstadoActivoNumerico", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				claseAnterior = String.valueOf(query.uniqueResult());
				session.flush();
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al buscar la clase anterior del articulo. {}",e.getMessage());
		}
		return claseAnterior;
	}
}
