package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.auditoria.ArticuloAuditoriaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.observacion.ArticuloObservacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroMasivoDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

public class ArticuloRegistroMasivoDAO implements IArticuloRegistroMasivoDAO {
	private SessionFactory sessionFactory;
	
	public void actualizarDatosArticulo(ArticuloEdicionMasivaVO articuloDTO) throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder query = null;
			Query sqlQuery = null;
			query = new StringBuilder();
			query.append("UPDATE SCSPETARTICULO SET"); 
			if(articuloDTO.getDescripcion() != null){
				query.append(" DESCRIPCIONARTICULO = '"+articuloDTO.getDescripcion()+"',");
			}
			if(articuloDTO.getSubClasificacion() != null){
				query.append(" CODIGOSUBCLASIFICACION = '"+articuloDTO.getSubClasificacion()+"',");
			}
			if(articuloDTO.getCodigoClase() != null){
				query.append(" CLASEARTICULO = '"+articuloDTO.getCodigoClase()+"',");
			}
			query.append(" FECHAULTIMAACTUALIZACION = '"+articuloDTO.getFechaModificacion()+"',");
			query.append(" USUARIOACTUALIZACION = '"+articuloDTO.getUsuarioModificacion()+"'");
			query.append(" WHERE CODIGOARTICULO = '"+articuloDTO.getCodigoArticulo()+"'");
			query.append(" AND CODIGOCOMPANIA = "+articuloDTO.getCodigoCompania());
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public void actualizarTemporadaArticulo(ArticuloEdicionMasivaVO articuloEdicionVO , String fechaInicio , String fechaFin) throws SICException {
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder query = null;
			Query sqlQuery = null;
			query = new StringBuilder();
			query.append("SELECT COUNT(1) FROM SCSADTARTTEM");
			query.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
			query.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
			sqlQuery = session.createSQLQuery(query.toString());
			Object cantObject=  sqlQuery.uniqueResult();
			Integer numArtTemp = Integer.parseInt(cantObject.toString());
			if(numArtTemp == 0){
				session.clear();
				StringBuilder queryCreate = new StringBuilder();
				queryCreate.append("INSERT INTO SCSADTARTTEM");
				queryCreate.append(" (CODIGOCOMPANIA,CODIGOARTICULO,FECHAINICIOTEMPORADA,FECHAFINTEMPORADA,IDUSUARIOREGISTRO,FECHAREGISTRO) VALUES");
				queryCreate.append(" ("+articuloEdicionVO.getCodigoCompania()+",'"+articuloEdicionVO.getCodigoArticulo()+"',");
				queryCreate.append(" '"+fechaInicio+"','"+fechaFin+"',");
				queryCreate.append(" '"+articuloEdicionVO.getUsuarioModificacion()+"','"+articuloEdicionVO.getFechaModificacion()+"')");
				Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
				sqlQueryCreate.executeUpdate();
				session.flush();
			}
			else{
				session.clear();
				StringBuilder queryUpdate = new StringBuilder();
				queryUpdate.append("UPDATE SCSADTARTTEM SET");
				queryUpdate.append(" FECHAINICIOTEMPORADA = '"+fechaInicio+"',");
				queryUpdate.append(" FECHAFINTEMPORADA = '"+fechaFin+"',");
				queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionVO.getFechaModificacion()+"',");
				queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionVO.getUsuarioModificacion()+"'");
				queryUpdate.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
				queryUpdate.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
				Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
				sqlQueryUpdate.executeUpdate();
				session.flush();
			}
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	 public void actualizarArticuloMedida(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException{
		 try{
			 Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder queryUpdate = new StringBuilder();
			queryUpdate.append("UPDATE SCSADTARTMED SET");
			queryUpdate.append(" REFERENCIAMEDIDA = '"+articuloEdicionVO.getTamanio()+"',");
			queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionVO.getFechaModificacion()+"',");
			queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionVO.getUsuarioModificacion()+"'");
			queryUpdate.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
			queryUpdate.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
			Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
			sqlQueryUpdate.executeUpdate();
			session.flush();
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public void actualizarReferenciaProveedor(ArticuloEdicionMasivaVO articuloEdicionMasivaVO) throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder queryUpdate = new StringBuilder();
			queryUpdate.append("UPDATE SCSADTARTPRO SET");
			if(articuloEdicionMasivaVO.getReferenciaInterna() != null){
				queryUpdate.append(" CODIGOREFERENCIAINTERNA = '"+articuloEdicionMasivaVO.getReferenciaInterna()+"',");
			}
			if(articuloEdicionMasivaVO.getReferenciaExterna() != null){
				queryUpdate.append(" CODIGOREFERENCIAPROVEEDOR = '"+articuloEdicionMasivaVO.getReferenciaExterna()+"',");
			}
			queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionMasivaVO.getUsuarioModificacion()+"',");
			queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionMasivaVO.getFechaModificacion()+"'");
			queryUpdate.append(" WHERE CODIGOCOMPANIA = "+articuloEdicionMasivaVO.getCodigoCompania());
			queryUpdate.append(" AND CODIGOARTICULO = '"+articuloEdicionMasivaVO.getCodigoArticulo()+"'");
			queryUpdate.append(" AND CODIGOPROVEEDOR = '"+articuloEdicionMasivaVO.getCodigoProveedor()+"'");
			Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
			sqlQueryUpdate.executeUpdate();
			session.flush();
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<String> obtenerCodigosProveedores(ArticuloEdicionMasivaVO articuloEdicionMasivaVO , Boolean esImportado)throws SICException{
		try{
			Collection<String> codigosProveedores = null;
			//buscamos los codigos de los proveedores del articulo
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder querySelect = new StringBuilder();
			querySelect.append("SELECT AP.CODIGOPROVEEDOR FROM SCSADTARTPRO AP ");
			if(esImportado){
				querySelect.append(" LEFT JOIN SCSADTARTPROIMP API ON API.CODIGOCOMPANIA = AP.CODIGOCOMPANIA AND API.CODIGOPROVEEDOR = AP.CODIGOPROVEEDOR AND API.CODIGOARTICULO = AP.CODIGOARTICULO");
				querySelect.append(" LEFT JOIN SCSPETPROVEEDOR PR ON AP.CODIGOCOMPANIA = PR.CODIGOCOMPANIA AND AP.CODIGOPROVEEDOR = PR.CODIGOPROVEEDOR");
				querySelect.append(" LEFT JOIN SCSADTPROIMP PI ON PR.CODIGOCOMPANIA = PI.CODIGOCOMPANIA AND PR.CODIGOPROVEEDOR = PI.CODIGOPROVEEDOR");
			}
			querySelect.append(" WHERE AP.CODIGOARTICULO = '"+articuloEdicionMasivaVO.getCodigoArticulo()+"'");
			querySelect.append(" AND AP.CODIGOCOMPANIA = "+articuloEdicionMasivaVO.getCodigoCompania());
			querySelect.append(" AND AP.ESTADOARTICULOPROVEEDOR = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'");
			if(esImportado){
				querySelect.append(" AND (PR.ORIGENPROVEEDOR = '"+SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado")+"' OR PI.ESIMPORTADOR = '"+SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO+"')");
			}
			Query sqlQuery = session.createSQLQuery(querySelect.toString());
			codigosProveedores = sqlQuery.list();
			return codigosProveedores;
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public void actualizarProveedorInternamente(ArticuloEdicionMasivaVO articuloEdicionMasivaVO) throws SICException{
		Collection<String> codigosProveedor = obtenerCodigosProveedores(articuloEdicionMasivaVO , Boolean.FALSE);
		if(CollectionUtils.isNotEmpty(codigosProveedor)){
			for(String codigoProveedor : codigosProveedor){
				articuloEdicionMasivaVO.setCodigoProveedor(codigoProveedor);
				this.actualizarReferenciaProveedor(articuloEdicionMasivaVO);
			}
		}
	}
	
	
	 public void actualizarArticuloComercial(ArticuloEdicionMasivaVO articuloEdicionMasivaVO)throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder queryUpdate = new StringBuilder();
			//StringBuilder queryCampos = new StringBuilder();
			String estadoVerFecCad = null;
			queryUpdate.append("UPDATE SCSADTARTCOM SET");
			
			if(articuloEdicionMasivaVO.getCodigoPaisOrigen() != null){
				queryUpdate.append(" CODIGOPAISORIGEN = '"+articuloEdicionMasivaVO.getCodigoPaisOrigen()+"',");
			}
			if(articuloEdicionMasivaVO.getCodigoLugarCompra() != null){
				queryUpdate.append(" CODIGOLUGARCOMPRA = '"+articuloEdicionMasivaVO.getCodigoLugarCompra()+"',");
			}
			if(articuloEdicionMasivaVO.getCodigoMarcaComercial() != null){
				queryUpdate.append(" CODIGOMARCACOMERCIAL = "+articuloEdicionMasivaVO.getCodigoMarcaComercial()+",");
			}
			if(articuloEdicionMasivaVO.getMarcaParticipacion() != null){
				queryUpdate.append(" MARCAPARTICIPACIONES = '"+articuloEdicionMasivaVO.getMarcaParticipacion()+"',");
			}
			if(articuloEdicionMasivaVO.getVerificaFechaCaducidad() != null){
				estadoVerFecCad = articuloEdicionMasivaVO.getVerificaFechaCaducidad() ? SICConstantes.ESTADO_ACTIVO_NUMERICO : SICConstantes.ESTADO_INACTIVO_NUMERICO;
				queryUpdate.append(" VERFECCADREC = '"+estadoVerFecCad+"',");
			}
			if(articuloEdicionMasivaVO.getCodigoTipoControlPrecio() != null && !StringUtils.equals(articuloEdicionMasivaVO.getCodigoTipoControlPrecio(), "NA")){
				queryUpdate.append(" CODIGOTIPOCONTROLCOSTO = "+SICConstantes.TIPO_CONTROL_COSTO+",");
				queryUpdate.append(" VALORTIPOCONTROLCOSTO = '"+articuloEdicionMasivaVO.getCodigoTipoControlPrecio()+"',");
			}
			
			/*String finalSentencia = StringUtils.substring(queryCampos.toString(), queryCampos.length() - 1);
			
			if(StringUtils.equals(finalSentencia, ",")){
				String nuevaSentencia = queryCampos.toString().substring(0, queryCampos.length() - 1);
				queryCampos = new StringBuilder();
				queryCampos.append(nuevaSentencia);
			}*/
			
			queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionMasivaVO.getFechaModificacion()+"',");
			queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionMasivaVO.getUsuarioModificacion()+"'");
			queryUpdate.append(" WHERE CODIGOCOMPANIA = "+articuloEdicionMasivaVO.getCodigoCompania());
			queryUpdate.append(" AND CODIGOARTICULO = '"+articuloEdicionMasivaVO.getCodigoArticulo()+"'");
			
			Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
			sqlQueryUpdate.executeUpdate();
			session.flush();
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	 
	public String actualizarMarcaComercialInternamente(ArticuloEdicionMasivaVO articuloEdicionMasivaVO)throws SICException{
		try{
			String mensaje = "";
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			Long codigoMarcaComercial = (Long) articuloEdicionMasivaVO.getDynamicProperty("codigoMarcaComercial");
			//consultamos si la marca comercial pertenece al proveedor del articulo
			Query querySelect = null;
			StringBuilder sqlQuerySelect = new StringBuilder();
			sqlQuerySelect.append("SELECT COUNT(1) FROM SCSADTPROMAR PM LEFT JOIN SCSADTARTPRO AP");
			sqlQuerySelect.append(" ON PM.CODIGOCOMPANIA = AP.CODIGOCOMPANIA AND PM.CODIGOPROVEEDOR = AP.CODIGOPROVEEDOR");
			sqlQuerySelect.append(" WHERE PM.SECUENCIALMARCA = "+codigoMarcaComercial);
			sqlQuerySelect.append(" AND AP.CODIGOCOMPANIA = "+articuloEdicionMasivaVO.getCodigoCompania());
			sqlQuerySelect.append(" AND AP.CODIGOARTICULO = '"+articuloEdicionMasivaVO.getCodigoArticulo()+"'");
			querySelect = session.createSQLQuery(sqlQuerySelect.toString());
			Integer numeroMarcaProveedor = (Integer) querySelect.uniqueResult();
			//si numeroMarcaProveedor es mayor a 0 significa que la marca esta asociada a un proveedor
			if(numeroMarcaProveedor > 0){
				//actualizamos la marca comercial y nulificamos los otros valores para que actualize solo la marca
				ArticuloEdicionMasivaVO edicionMasivaVO = new ArticuloEdicionMasivaVO();
				edicionMasivaVO.setCodigoMarcaComercial(codigoMarcaComercial);
				edicionMasivaVO.setCodigoCompania(articuloEdicionMasivaVO.getCodigoCompania());
				edicionMasivaVO.setCodigoArticulo(articuloEdicionMasivaVO.getCodigoArticulo());
				edicionMasivaVO.setUsuarioModificacion(articuloEdicionMasivaVO.getUsuarioModificacion());
				edicionMasivaVO.setFechaModificacion(articuloEdicionMasivaVO.getFechaModificacion());
				this.actualizarArticuloComercial(edicionMasivaVO);
			}else{
				mensaje = SICArticuloConstantes.MENSAJE_REGISTRO_MARCACOMERCIAL;
			}
			
			return mensaje;
			
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	 
	 /**
	 * este metodo es usado en la edicion interna cuando no sabemos el codigotipocontrolcosto
	 * @param articuloEdicionMasivaVO
	 * @throws SICException
	 */
	public String actualizarValorTipoControlCosto(ArticuloEdicionMasivaVO articuloEdicionMasivaVO)throws SICException{
		try{
			//consultamos cual es el valor tipo control costo, para determinar que no sea pieza - pieza
			String mensaje = "";
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			Query sqlQuery = null;
			StringBuilder query = new StringBuilder();
			query.append("SELECT VALORTIPOCONTROLCOSTO FROM SCSADTARTCOM");
			query.append(" WHERE CODIGOCOMPANIA = "+articuloEdicionMasivaVO.getCodigoCompania());
			query.append(" AND CODIGOARTICULO = '"+articuloEdicionMasivaVO.getCodigoArticulo()+"'");
			sqlQuery = session.createSQLQuery(query.toString());
			String valorTipoControlCostoFound = (String)sqlQuery.uniqueResult();
			if(!StringUtils.equals(valorTipoControlCostoFound, SICArticuloConstantes.getInstancia().TIPOCALCULOPRECIOPESO)){
				//si no es pieza - pieza, actualizamos el registro
				session.clear();
				String valorTipoControlCostoNuevo = (String) articuloEdicionMasivaVO.getDynamicProperty("valorTipoControlCosto");
				//validamos que el valor a cambiar sea diferente del que existe en base
				if(!StringUtils.equals(valorTipoControlCostoFound , valorTipoControlCostoNuevo)){
					Query sqlUpdate = null;
					StringBuilder queryUpdate = new StringBuilder();
					queryUpdate.append("UPDATE SCSADTARTCOM SET");
					queryUpdate.append(" CODIGOTIPOCONTROLCOSTO = "+SICConstantes.TIPO_CONTROL_COSTO+",");
					queryUpdate.append(" VALORTIPOCONTROLCOSTO = '"+valorTipoControlCostoNuevo+"',");
					queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionMasivaVO.getFechaModificacion()+"',");
					queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionMasivaVO.getUsuarioModificacion()+"'");
					queryUpdate.append(" WHERE CODIGOCOMPANIA = "+articuloEdicionMasivaVO.getCodigoCompania());
					queryUpdate.append(" AND CODIGOARTICULO = '"+articuloEdicionMasivaVO.getCodigoArticulo()+"'");
					Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
					sqlQueryUpdate.executeUpdate();
					session.flush();
				}
			}else{
				mensaje = SICArticuloConstantes.MENSAJE_REGISTRO_TIPOCONTROLPRECIO;
			}
			
			return mensaje;
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	 
	public void actualizarDatosDuracionConservacion(ArticuloEdicionMasivaVO articuloEdicionVO , Integer codigoTipoConservacion, String valorTipoConservacion, Integer valorVidaUtil)throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			Query sqlQuery = null;
			StringBuilder querySelect = new StringBuilder();
			querySelect.append("SELECT COUNT(1) FROM SCSADTARTDURCON");
			querySelect.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
			querySelect.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
			querySelect.append(" AND VALORTIPOCONSERVACION = '"+valorTipoConservacion+"'");
			querySelect.append(" AND CODIGOTIPOCONSERVACION = "+codigoTipoConservacion);
			sqlQuery = session.createSQLQuery(querySelect.toString());
			Object cantObject=  sqlQuery.uniqueResult();
			Integer numArtDurCon = Integer.parseInt(cantObject.toString());
			if(numArtDurCon == 0){
				if(valorVidaUtil != null){
					session.clear();
					StringBuilder queryCreate = new StringBuilder();
					queryCreate.append("INSERT INTO SCSADTARTDURCON");
					queryCreate.append(" (CODIGOCOMPANIA,CODIGOARTICULO,CODIGOTIPOCONSERVACION,VALORTIPOCONSERVACION,ESTADO,DIASVIDAUTIL,IDUSUARIOREGISTRO,FECHAREGISTRO) VALUES");
					queryCreate.append(" ("+articuloEdicionVO.getCodigoCompania()+",'"+articuloEdicionVO.getCodigoArticulo()+"',");
					queryCreate.append(" "+codigoTipoConservacion+",'"+valorTipoConservacion+"',");
					queryCreate.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',"+valorVidaUtil+",");
					queryCreate.append(" '"+articuloEdicionVO.getUsuarioModificacion()+"','"+articuloEdicionVO.getFechaModificacion()+"')");
					Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
					sqlQueryCreate.executeUpdate();
					session.flush();
				}
			}
			else{
				session.clear();
				StringBuilder queryUpdate = new StringBuilder();
				queryUpdate.append("UPDATE SCSADTARTDURCON SET");
				if(valorVidaUtil != null){
					queryUpdate.append(" DIASVIDAUTIL = '"+valorVidaUtil+"',");
					queryUpdate.append(" ESTADO = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
				}
				else{
					queryUpdate.append(" ESTADO = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
				}
				queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionVO.getFechaModificacion()+"',");
				queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionVO.getUsuarioModificacion()+"'");
				queryUpdate.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
				queryUpdate.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
				queryUpdate.append(" AND VALORTIPOCONSERVACION = '"+valorTipoConservacion+"'");
				queryUpdate.append(" AND CODIGOTIPOCONSERVACION = "+codigoTipoConservacion);
				Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
				sqlQueryUpdate.executeUpdate();
				session.flush();
			}
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public Integer contarArticuloImportacion(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			Query sqlQuery = null;
			StringBuilder querySelect = new StringBuilder();
			querySelect.append("SELECT COUNT(1) FROM SCSADTARTPROIMP");
			querySelect.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
			querySelect.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
			querySelect.append(" AND CODIGOPROVEEDOR = '"+articuloEdicionVO.getCodigoProveedor()+"'");
			sqlQuery = session.createSQLQuery(querySelect.toString());
			Object cantObject=  sqlQuery.uniqueResult();
			Integer numArtProImp = Integer.parseInt(cantObject.toString());
			return numArtProImp;
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	public void registrarArticuloImportacion(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder queryCreate = new StringBuilder();
			queryCreate.append("INSERT INTO SCSADTARTPROIMP");
			queryCreate.append(" (CODIGOCOMPANIA,CODIGOARTICULO,CODIGOPROVEEDOR,CODIGOMONEDAORIGEN,COSTOMONEDAORIGEN,PORCENTAJECOMISION,IDUSUARIOREGISTRO,FECHAREGISTRO) VALUES");
			queryCreate.append(" ("+articuloEdicionVO.getCodigoCompania()+",'"+articuloEdicionVO.getCodigoArticulo()+"',");
			queryCreate.append(" '"+articuloEdicionVO.getCodigoProveedor()+"',"+SICArticuloConstantes.VALOR_MONEDA_DOLAR+",");
			queryCreate.append(" "+articuloEdicionVO.getCostoMonedaOrigen()+","+articuloEdicionVO.getPorcentajeComision()+",");
			queryCreate.append(" '"+articuloEdicionVO.getUsuarioModificacion()+"','"+articuloEdicionVO.getFechaModificacion()+"')");
			Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
			sqlQueryCreate.executeUpdate();
			session.flush();
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	public void actualizarArticuloImportacion(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException{
		Session session;
		session = sessionFactory.getCurrentSession();
		session.clear();
		StringBuilder queryUpdate = new StringBuilder();
		queryUpdate.append("UPDATE SCSADTARTPROIMP SET");
		if(articuloEdicionVO.getCostoMonedaOrigen() != null){
			queryUpdate.append(" COSTOMONEDAORIGEN = "+articuloEdicionVO.getCostoMonedaOrigen()+",");
		}
		if(articuloEdicionVO.getPorcentajeComision() != null){
			queryUpdate.append(" PORCENTAJECOMISION = "+articuloEdicionVO.getPorcentajeComision()+",");
		}
		queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionVO.getFechaModificacion()+"',");
		queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionVO.getUsuarioModificacion()+"'");
		queryUpdate.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
		queryUpdate.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
		queryUpdate.append(" AND CODIGOPROVEEDOR = '"+articuloEdicionVO.getCodigoProveedor()+"'");
		Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
		sqlQueryUpdate.executeUpdate();
		session.flush();
	}
	
	public void actualizarArticuloMaterial(ArticuloEdicionMasivaVO articuloEdicionVO, Integer codigoTipoMaterial , String valorTipoMaterial)throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			Query sqlQuery = null;
			StringBuilder querySelect = new StringBuilder();
			querySelect.append("SELECT COUNT(1) FROM SCSADTARTMAT");
			querySelect.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
			querySelect.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
			querySelect.append(" AND CODIGOTIPOMATERIAL = "+codigoTipoMaterial);
			querySelect.append(" AND VALORTIPOMATERIAL = '"+valorTipoMaterial+"'");
			sqlQuery = session.createSQLQuery(querySelect.toString());
			Object cantObject=  sqlQuery.uniqueResult();
			Integer numArtMat = Integer.parseInt(cantObject.toString());
			if(numArtMat == 0){
				session.clear();
				StringBuilder queryCreate = new StringBuilder();
				queryCreate.append("INSERT INTO SCSADTARTMAT");
				queryCreate.append(" (CODIGOCOMPANIA,CODIGOARTICULO,CODIGOTIPOMATERIAL,VALORTIPOMATERIAL,ESTADO,ESPRINCIPAL,OBSERVACION,IDUSUARIOREGISTRO,FECHAREGISTRO) VALUES");
				queryCreate.append(" ("+articuloEdicionVO.getCodigoCompania()+",'"+articuloEdicionVO.getCodigoArticulo()+"',");
				queryCreate.append(" "+codigoTipoMaterial+",'"+valorTipoMaterial+"',");
				queryCreate.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"','"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
				queryCreate.append(" '"+articuloEdicionVO.getMaterial()+"',");
				queryCreate.append(" '"+articuloEdicionVO.getUsuarioModificacion()+"','"+articuloEdicionVO.getFechaModificacion()+"')");
				Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
				sqlQueryCreate.executeUpdate();
				session.flush();
			}
			else{
				session.clear();
				StringBuilder queryUpdate = new StringBuilder();
				queryUpdate.append("UPDATE SCSADTARTMAT SET");
				queryUpdate.append(" OBSERVACION = '"+articuloEdicionVO.getMaterial()+"',");
				queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionVO.getFechaModificacion()+"',");
				queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionVO.getUsuarioModificacion()+"'");
				queryUpdate.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
				queryUpdate.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
				queryUpdate.append(" AND CODIGOTIPOMATERIAL = "+codigoTipoMaterial);
				queryUpdate.append(" AND VALORTIPOMATERIAL = '"+valorTipoMaterial+"'");
				Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
				sqlQueryUpdate.executeUpdate();
				session.flush();
			}
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public void inactivarAgrupadorArticulo(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException{
		Session session;
		session = sessionFactory.getCurrentSession();
		session.clear();
		StringBuilder queryUpdate = new StringBuilder();
		queryUpdate.append("UPDATE SCARTTARTAGR SET");
		queryUpdate.append(" ESTADO = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
		queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionVO.getFechaModificacion()+"',");
		queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionVO.getUsuarioModificacion()+"'");
		queryUpdate.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
		queryUpdate.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
		queryUpdate.append(" AND CODIGOTIPOAGRUPADOR = "+articuloEdicionVO.getCodigoTipoAgrupador());
		Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
		sqlQueryUpdate.executeUpdate();
		session.flush();
	}
	
	public void actualizarArticuloAgrupador(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			Query sqlQuery = null;
			StringBuilder querySelect = new StringBuilder();
			querySelect.append("SELECT COUNT(1) FROM SCARTTARTAGR");
			querySelect.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
			querySelect.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
			querySelect.append(" AND VALORTIPOAGRUPADOR = '"+articuloEdicionVO.getValorTipoAgrupador()+"'");
			querySelect.append(" AND CODIGOTIPOAGRUPADOR = "+articuloEdicionVO.getCodigoTipoAgrupador());
			sqlQuery = session.createSQLQuery(querySelect.toString());
			Object cantObject=  sqlQuery.uniqueResult();
			Integer numArtAgr = Integer.parseInt(cantObject.toString());
			if(numArtAgr == 0){
				if(articuloEdicionVO.getAgrupador() != null){
					this.inactivarAgrupadorArticulo(articuloEdicionVO);
					session.clear();
					StringBuilder queryCreate = new StringBuilder();
					queryCreate.append("INSERT INTO SCARTTARTAGR");
					queryCreate.append(" (CODIGOCOMPANIA,CODIGOARTICULO,CODIGOTIPOAGRUPADOR,VALORTIPOAGRUPADOR,ESTADO,IDUSUARIOREGISTRO,FECHAREGISTRO) VALUES");
					queryCreate.append(" ("+articuloEdicionVO.getCodigoCompania()+",'"+articuloEdicionVO.getCodigoArticulo()+"',");
					queryCreate.append(" "+articuloEdicionVO.getCodigoTipoAgrupador()+",'"+articuloEdicionVO.getValorTipoAgrupador()+"',");
					queryCreate.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
					queryCreate.append(" '"+articuloEdicionVO.getUsuarioModificacion()+"','"+articuloEdicionVO.getFechaModificacion()+"')");
					Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
					sqlQueryCreate.executeUpdate();
					session.flush();
				}
			}else{
				session.clear();
				StringBuilder queryUpdate = new StringBuilder();
				queryUpdate.append("UPDATE SCARTTARTAGR SET");
				if(articuloEdicionVO.getAgrupador()  != null){
					this.inactivarAgrupadorArticulo(articuloEdicionVO);
					queryUpdate.append(" ESTADO = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
				}
				else{
					queryUpdate.append(" ESTADO = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
				}
				queryUpdate.append(" FECHAMODIFICACION = '"+articuloEdicionVO.getFechaModificacion()+"',");
				queryUpdate.append(" IDUSUARIOMODIFICACION = '"+articuloEdicionVO.getUsuarioModificacion()+"'");
				queryUpdate.append(" WHERE CODIGOARTICULO = '"+articuloEdicionVO.getCodigoArticulo()+"'");
				queryUpdate.append(" AND CODIGOCOMPANIA = "+articuloEdicionVO.getCodigoCompania());
				queryUpdate.append(" AND VALORTIPOAGRUPADOR = '"+articuloEdicionVO.getValorTipoAgrupador()+"'");
				queryUpdate.append(" AND CODIGOTIPOAGRUPADOR = "+articuloEdicionVO.getCodigoTipoAgrupador());
				Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
				sqlQueryUpdate.executeUpdate();
				session.flush();
			}
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	private Boolean existeArticuloAgrupador(ArticuloEdicionMasivaVO articuloEdicionVO) throws SICException {
		Session session;
		StringBuilder query;
		Query hqlQuery = null;
		session = sessionFactory.getCurrentSession();
		Long total = 0L;
		try {
			session.clear();
			query = new StringBuilder();
			query.append("SELECT COUNT(*) ");
			query.append("FROM ").append(ArticuloAgrupadorDTO.class.getName());
			query.append(" WHERE id.codigoCompania = :pCodigoCompania");
			query.append(" AND id.codigoArticulo = :pCodigoArticulo");
			query.append(" AND id.codigoTipoAgrupador = :pCodigoTipoAgrupador");
			query.append(" AND id.valorTipoAgrupador = :pValorTipoAgrupador");
			
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setInteger("pCodigoCompania", articuloEdicionVO.getCodigoCompania());
			hqlQuery.setString("pCodigoArticulo", articuloEdicionVO.getCodigoArticulo());
			hqlQuery.setInteger("pCodigoTipoAgrupador", articuloEdicionVO.getCodigoTipoAgrupador());
			hqlQuery.setString("pValorTipoAgrupador", articuloEdicionVO.getValorTipoAgrupador());
			
			total = (Long) hqlQuery.uniqueResult();
			
		} catch(Exception e) {
			throw new SICException("Error al consultar un Agrupador", e);
		}
		
		return (total > 0L);
	}
	
	/**
	 * Permite actualizar un agrupador del tipo Caracteristica Especial
	 * @param articuloEdicionVO
	 * @throws SICException
	 */
	private void actualizaCaracteristicaEspecial(ArticuloEdicionMasivaVO articuloEdicionVO) throws SICException {
		Session session;
		Query hqlQuery;
		StringBuilder query;
		//articuloEdicionVO.getEvent() DEVE VENIR CON EL ESTADO
		String estado = (articuloEdicionVO.getEvent().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO))? SICConstantes.ESTADO_ACTIVO_NUMERICO : SICConstantes.ESTADO_INACTIVO_NUMERICO;
		session = sessionFactory.getCurrentSession();
		try {
			
			session.clear();
			
			query = new StringBuilder();
			query.append("update ArticuloAgrupadorDTO set estado = :pEstado");
			query.append(" ,idUsuarioModificacion = :pIdUsuarioModificacion");
			query.append(" ,fechaModificacion = :pFechaModificacion");
			query.append(" where ");
			query.append(" id.codigoCompania = :pCodigoCompania");
			query.append(" and id.codigoArticulo = :pCodigoArticulo");
			query.append(" and id.codigoTipoAgrupador = :pCodigoTipoAgrupador");
			query.append(" and id.valorTipoAgrupador = :pValorTipoAgrupador");
			
			hqlQuery = session.createQuery(query.toString());
			
			hqlQuery.setInteger("pCodigoCompania", articuloEdicionVO.getCodigoCompania());
			hqlQuery.setString("pCodigoArticulo", articuloEdicionVO.getCodigoArticulo());
			hqlQuery.setInteger("pCodigoTipoAgrupador", articuloEdicionVO.getCodigoTipoAgrupador());
			hqlQuery.setString("pValorTipoAgrupador", articuloEdicionVO.getValorTipoAgrupador());
			hqlQuery.setString("pEstado", estado);
			hqlQuery.setString("pIdUsuarioModificacion", articuloEdicionVO.getUsuarioModificacion());
			hqlQuery.setTimestamp("pFechaModificacion", new Timestamp(System.currentTimeMillis()));
			hqlQuery.executeUpdate();
			
		} catch(Exception e) {
			throw new SICException("Error al actualizar la caracter\u00EDstica Especial", e);
		} finally {
			session.flush();
		}
	}
	
	/**
	 * Permite crear un agrupador del tipo Caracteristica Especial
	 * @param articuloEdicionVO
	 * @throws SICException
	 */
	private void crearArticuloAgrupador(ArticuloEdicionMasivaVO articuloEdicionVO) throws SICException {
		Session session;
		Query sqlQuery;
		StringBuilder query;
		
		session = sessionFactory.getCurrentSession();
		try {
			query = new StringBuilder();
			query.append("INSERT INTO SCARTTARTAGR");
			query.append(" (CODIGOCOMPANIA,CODIGOARTICULO,CODIGOTIPOAGRUPADOR,VALORTIPOAGRUPADOR,ESTADO,IDUSUARIOREGISTRO,FECHAREGISTRO) VALUES");
			query.append(" ("+articuloEdicionVO.getCodigoCompania()+",'"+articuloEdicionVO.getCodigoArticulo()+"',");
			query.append(" "+articuloEdicionVO.getCodigoTipoAgrupador()+",'"+articuloEdicionVO.getValorTipoAgrupador()+"',");
			query.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
			query.append(" '"+articuloEdicionVO.getUsuarioModificacion()+"','"+new Timestamp(System.currentTimeMillis())+"')");
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
		} catch(Exception e) {
			throw new SICException("Error al guardar la caracter\u00EDstica Especial", e);
		} finally {
			session.flush();
		}
	}
	
	/**
	 * Crea o actualiza un agrupador del Tipo caracteristica Especial
	 * @param articuloEdicionVO
	 */
	public void crearOActualizarCaracteristicaEspecial(ArticuloEdicionMasivaVO articuloEdicionVO) throws SICException {
		if(this.existeArticuloAgrupador(articuloEdicionVO)) {
			this.actualizaCaracteristicaEspecial(articuloEdicionVO);
		} else {
			this.crearArticuloAgrupador(articuloEdicionVO);
		}
	}
	
	
	public void actualizarPrototipoArticulo(ArticuloEdicionMasivaVO articuloDTO) throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder query = null;
			Query sqlQuery = null;
			query = new StringBuilder();
			query.append("UPDATE SCSPETARTICULO SET"); 
			query.append(" CODIGOGRUPOALCANCE = "+articuloDTO.getCodigoPrototipoAlcance()+",");
			query.append(" FECHAULTIMAACTUALIZACION = '"+articuloDTO.getFechaModificacion()+"',");
			query.append(" USUARIOACTUALIZACION = '"+articuloDTO.getUsuarioModificacion()+"'");
			query.append(" WHERE CODIGOARTICULO = '"+articuloDTO.getCodigoArticulo()+"'");
			query.append(" AND CODIGOCOMPANIA = "+articuloDTO.getCodigoCompania());
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public void registrarArticuloPendienteIntegracion(Integer codigoCompania , String codigoArticulo , String usuarioModificacion , String valorTipoProceso)throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder queryCreate = new StringBuilder();
			queryCreate.append("INSERT INTO SCARTTARTPENINT");
			queryCreate.append(" (CODIGOCOMPANIA,CODIGOARTICULO,SECUENCIAL,ESTADO,VALORTIPOPROCESO,CODIGOTIPOPROCESO,IDUSUARIOREGISTRO,FECHAREGISTRO) VALUES");
			queryCreate.append(" ("+codigoCompania+",'"+codigoArticulo+"',");
			queryCreate.append(" NEXT VALUE FOR SCSADSARTPENINT,");
			queryCreate.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
			queryCreate.append(" '"+valorTipoProceso+"',"+TipoCatalogoArticulo.TIPO_PROCESO_INTEGRACION+",");
			queryCreate.append(" '"+usuarioModificacion+"',CURRENT_TIMESTAMP)");
			Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
			sqlQueryCreate.executeUpdate();
			session.flush();
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroMasivoDAO#registrarActualizarArticuloImpuesto(ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO)
	 */
	public void registrarActualizarArticuloImpuesto(ArticuloImpuestoDTO articuloImpuestoDTO)throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			Query sqlQuery = null;
			StringBuilder querySelect = new StringBuilder();
			querySelect.append("SELECT COUNT(1) FROM SCSADTARTIMP");
			querySelect.append(" WHERE CODIGOARTICULO =:pCodigoArticulo");
			querySelect.append(" AND CODIGOCOMPANIA =:pCodigoCompania");
			querySelect.append(" AND CODIGOTIPOIMPUESTO =:pCodigoTipoImpuesto");
						
			sqlQuery = session.createSQLQuery(querySelect.toString())
			.setParameter("pCodigoArticulo", articuloImpuestoDTO.getId().getCodigoArticulo())
			.setParameter("pCodigoCompania", articuloImpuestoDTO.getId().getCodigoCompania())
			.setParameter("pCodigoTipoImpuesto", articuloImpuestoDTO.getId().getCodigoTipoImpuesto());			
			
			Object cantObject=  sqlQuery.uniqueResult();
			Integer numArtAgr = Integer.parseInt(cantObject.toString());
			if(numArtAgr == 0){
				articuloImpuestoDTO.setIdUsuarioRegistro(articuloImpuestoDTO.getIdUsuarioModificacion());
				articuloImpuestoDTO.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
				this.registrarArticuloImpuesto(articuloImpuestoDTO);
			}
			else{
				this.actualizarArticuloImpuesto(articuloImpuestoDTO);
			}
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public String registrarImpuestosInternamente(ArticuloImpuestoDTO articuloImpuestoDTO) throws SICException{
		try{
			String mensaje = "";
			Boolean esImpuestoIva = false;
			Integer numImpuestoIvaComprobar = 0; 
			//consultamos el articulo impuesto
			ArticuloImpuestoDTO impuestoFound = null;
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			Criteria criteria = session.createCriteria(ArticuloImpuestoDTO.class);
			criteria.add(Restrictions.eq("id.codigoCompania", articuloImpuestoDTO.getId().getCodigoCompania()));
			criteria.add(Restrictions.eq("id.codigoArticulo", articuloImpuestoDTO.getId().getCodigoArticulo()));
			criteria.add(Restrictions.eq("id.codigoTipoImpuesto", articuloImpuestoDTO.getId().getCodigoTipoImpuesto()));
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("estadoArticuloImpuesto"),("estadoArticuloImpuesto"));
			proList.add(Projections.property("esParaCompra"),("esParaCompra"));
			proList.add(Projections.property("esParaVenta"),("esParaVenta"));
			criteria.setProjection(proList);
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloImpuestoDTO.class));
			impuestoFound = (ArticuloImpuestoDTO) criteria.uniqueResult();
			Integer codigoImpuestoComprobar = null;
			
			//validamos si el impuesto es de tipo iva, si  es asi consultamos si no registramos el nuevo impuesto tipo iva
			if(articuloImpuestoDTO.getId().getCodigoTipoImpuesto().compareTo(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA) == 0
				|| articuloImpuestoDTO.getId().getCodigoTipoImpuesto().compareTo(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA_0) == 0){
				esImpuestoIva = true;
				codigoImpuestoComprobar = articuloImpuestoDTO.getId().getCodigoTipoImpuesto().compareTo(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA) == 0 ? SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA_0 : SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA;
				
				//consultamos si existe un impuesto tipo iva que no sea el registro que viene desde pantalla
				session.clear();
				Criteria criteriaImpuesto = session.createCriteria(ArticuloImpuestoDTO.class);
				ProjectionList proyeccionImpuesto = Projections.projectionList();
				proyeccionImpuesto.add(Projections.rowCount());
				criteriaImpuesto.add(Restrictions.eq("id.codigoCompania", articuloImpuestoDTO.getId().getCodigoCompania()));
				criteriaImpuesto.add(Restrictions.eq("id.codigoArticulo", articuloImpuestoDTO.getId().getCodigoArticulo()));
				criteriaImpuesto.add(Restrictions.eq("id.codigoTipoImpuesto", codigoImpuestoComprobar));
				criteriaImpuesto.add(Restrictions.eq("estadoArticuloImpuesto", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				criteriaImpuesto.setProjection(proyeccionImpuesto);
				Long numImpuestos = (Long) criteriaImpuesto.uniqueResult();
				numImpuestoIvaComprobar = numImpuestos.intValue();
			}
			//validamos si el impuesto a registrar es tipo iva y que el impuesto iva consultado para comprobar no exista
			if((esImpuestoIva && numImpuestoIvaComprobar.equals(0)) || !esImpuestoIva){
				if(impuestoFound == null){
					articuloImpuestoDTO.setIdUsuarioRegistro(articuloImpuestoDTO.getIdUsuarioModificacion());
					articuloImpuestoDTO.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
					//validamos si uno de los usos es activo
					if(BooleanUtils.isTrue(articuloImpuestoDTO.getEsParaCompra()) || BooleanUtils.isTrue(articuloImpuestoDTO.getEsParaVenta())){
						//si alguno de los usos viene nulo, asignamos el valor de falso
						if(articuloImpuestoDTO.getEsParaCompra() == null)  articuloImpuestoDTO.setEsParaCompra(Boolean.FALSE);
						if(articuloImpuestoDTO.getEsParaVenta() == null) articuloImpuestoDTO.setEsParaVenta(Boolean.FALSE);
						//registramos el articulo impuesto
						this.registrarArticuloImpuesto(articuloImpuestoDTO);
					}
				}else{
					//actualizamos el articulo impuesto
					//si el estado es inactivo y vamos a activar validamos que uno de los usos sea activo
					if(StringUtils.equals(impuestoFound.getEstadoArticuloImpuesto(), SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO) 
							&& StringUtils.equals(articuloImpuestoDTO.getEstadoArticuloImpuesto(), SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)){
						if(BooleanUtils.isTrue(articuloImpuestoDTO.getEsParaCompra()) || BooleanUtils.isTrue(articuloImpuestoDTO.getEsParaVenta())){
							this.actualizarArticuloImpuestoInternamente(articuloImpuestoDTO);
						}
					}else{
						//si alguno de los usos viene nulo, asignamos el valor que viene de base
						if(articuloImpuestoDTO.getEsParaCompra() == null)  articuloImpuestoDTO.setEsParaCompra(impuestoFound.getEsParaCompra());
						if(articuloImpuestoDTO.getEsParaVenta() == null) articuloImpuestoDTO.setEsParaVenta(impuestoFound.getEsParaVenta());
						//validamos si los dos usos son inactivos inactivamos el articulo impuesto
						if(!articuloImpuestoDTO.getEsParaCompra() && !articuloImpuestoDTO.getEsParaVenta()){
							articuloImpuestoDTO.setEstadoArticuloImpuesto(SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO);
						}
						this.actualizarArticuloImpuestoInternamente(articuloImpuestoDTO);
					}
				}
			}else{
				if(esImpuestoIva){
					String primerIva = "12";
					String segundoIva = "0";
					if(codigoImpuestoComprobar.compareTo(SICArticuloConstantes.TIPOIMPUESTO_OMISION_IVA) == 0){
						primerIva = "0";
						segundoIva = "12";
					}
					mensaje = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.mensaje.registro.impuesto.iva"),primerIva,segundoIva);
				}
			}
			
			return mensaje;
			
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	private void actualizarArticuloImpuesto(ArticuloImpuestoDTO articuloImpuestoDTO) throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			session.update(articuloImpuestoDTO);
			session.flush();
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	private void actualizarArticuloImpuestoInternamente(ArticuloImpuestoDTO articuloImpuestoDTO) throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder query = new StringBuilder();
			Query sqlQuery = null;
			query.append("UPDATE SCSADTARTIMP SET"); 
			query.append(" ESTADOARTICULOIMPUESTO = '"+articuloImpuestoDTO.getEstadoArticuloImpuesto()+"',");
			
			if(articuloImpuestoDTO.getEsParaCompra() != null){
				String estadoCompra = articuloImpuestoDTO.getEsParaCompra() ? SICConstantes.ESTADO_ACTIVO_NUMERICO : SICConstantes.ESTADO_INACTIVO_NUMERICO;
				query.append(" ESPARACOMPRA = '"+estadoCompra+"',");
			}
			if(articuloImpuestoDTO.getEsParaVenta() != null){ 
				String estadoVenta = articuloImpuestoDTO.getEsParaVenta() ? SICConstantes.ESTADO_ACTIVO_NUMERICO : SICConstantes.ESTADO_INACTIVO_NUMERICO;
				query.append(" ESPARAVENTA = '"+estadoVenta+"',");
			}
			
			query.append(" IDUSUARIOMODIFICACION = '"+articuloImpuestoDTO.getIdUsuarioModificacion()+"',");
			query.append(" FECHAMODIFICACION = '"+articuloImpuestoDTO.getFechaModificacion()+"'");
			query.append(" WHERE CODIGOARTICULO = '"+articuloImpuestoDTO.getId().getCodigoArticulo()+"'");
			query.append(" AND CODIGOCOMPANIA = "+articuloImpuestoDTO.getId().getCodigoCompania());
			query.append(" AND CODIGOTIPOIMPUESTO = "+articuloImpuestoDTO.getId().getCodigoTipoImpuesto());
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	private void registrarArticuloImpuesto(ArticuloImpuestoDTO articuloImpuestoDTO) throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			session.save(articuloImpuestoDTO); 
			session.flush();
		}
		catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public Boolean validarValoresArticuloClase(ArticuloEdicionMasivaVO articuloEdicionMasivaVO) throws SICException{
		try{
			Boolean existenCambios = Boolean.FALSE;
			//consultamos la clase actual del articulo
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			Query queryClase;
			StringBuilder sqlQueryClase = new StringBuilder();
			sqlQueryClase.append(" SELECT CLASEARTICULO FROM SCSPETARTICULO");
			sqlQueryClase.append(" WHERE CODIGOARTICULO = '"+articuloEdicionMasivaVO.getCodigoArticulo()+"'");
			sqlQueryClase.append(" AND CODIGOCOMPANIA = "+articuloEdicionMasivaVO.getCodigoCompania());
			queryClase = session.createSQLQuery(sqlQueryClase.toString());
			String codigoClaseActual = (String) queryClase.uniqueResult();
			articuloEdicionMasivaVO.setClaseArticuloAnterior(codigoClaseActual);
			
			//consultamos el articulo clase
			session.clear();
			Criteria criteria = session.createCriteria(ArticuloClaseDTO.class);
			criteria.add(Restrictions.eq("id.codigoCompania", articuloEdicionMasivaVO.getCodigoCompania()));
			criteria.add(Restrictions.eq("id.codigoArticulo", articuloEdicionMasivaVO.getCodigoArticulo()));
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("valorTipoCausal"),("valorTipoCausal"));
			proList.add(Projections.property("secuencialArtCla"),("secuencialArtCla"));
			criteria.setProjection(proList);
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloClaseDTO.class));
			ArticuloClaseDTO articuloClaseFound = (ArticuloClaseDTO) criteria.uniqueResult();
			
			String codigoClaseNueva = (String) articuloEdicionMasivaVO.getDynamicProperty("codigoClaseNueva");
			if(!StringUtils.equals(codigoClaseActual, codigoClaseNueva)){
				existenCambios = Boolean.TRUE;
			}
			if(articuloClaseFound != null){
				articuloEdicionMasivaVO.setSecuencialArtCla(articuloClaseFound.getSecuencialArtCla());
				if(!StringUtils.equals(articuloClaseFound.getValorTipoCausal(), articuloEdicionMasivaVO.getValorTipoCausal())){
					existenCambios = Boolean.TRUE;
				}
			}
			return existenCambios;
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public Boolean validarCaracteristicaDinamica(ArticuloEdicionMasivaVO articuloEdicionMasivaVO , Integer codigoTipoCaracteristica , String valorTipoCaracteristica) throws SICException{
		Session session;
		session = sessionFactory.getCurrentSession();
		session.clear();
		Query query;
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT COUNT(1) FROM SCSADTCARDIN CD LEFT JOIN SCSPETARTICULO ART ON CD.CODIGOCLASIFICACION = ART.CODIGOCLASIFICACION");
		sqlQuery.append(" WHERE CD.CODIGOTIPOCARACTERISTICA = "+codigoTipoCaracteristica);
		if(valorTipoCaracteristica != null){
			sqlQuery.append(" AND CD.CODIGOVALORCARACTERISTICA = '"+valorTipoCaracteristica+"'");
		}
		sqlQuery.append(" AND ART.CODIGOARTICULO = '"+articuloEdicionMasivaVO.getCodigoArticulo()+"'");
		query = session.createSQLQuery(sqlQuery.toString());
		Integer numeroCaracteristicaEspecial = (Integer) query.uniqueResult();
		if(numeroCaracteristicaEspecial > 0){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public void registrarAuditoriaArticulo(ArticuloEdicionMasivaVO articuloDTO ) throws SICException{
		try{
			Session session;
			session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder query = null;
			Query sqlQuery = null;
			query = new StringBuilder();
			query.append("UPDATE SCSPETARTICULO SET"); 
			query.append(" FECHAULTIMAACTUALIZACION = CURRENT_TIMESTAMP,");
			query.append(" USUARIOACTUALIZACION = '"+articuloDTO.getUsuarioModificacion()+"'");
			query.append(" WHERE CODIGOARTICULO = '"+articuloDTO.getCodigoArticulo()+"'");
			query.append(" AND CODIGOCOMPANIA = "+articuloDTO.getCodigoCompania());
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public Boolean verificarExistenciaAuditoriaExtendida(Integer codigoCompania , String codigoArticulo) throws SICException{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			Criteria criteria = session.createCriteria(ArticuloAuditoriaDTO.class);
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.rowCount());
			criteria.setProjection(proList);
			Object cantidadRegistros=  criteria.uniqueResult();
			Integer numArtAud = Integer.parseInt(cantidadRegistros.toString());
			
			if(numArtAud > 0){
				return true;
			}
			return false;
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public void registrarAuditoriaExtendida(Integer codigoCompania , String codigoArticulo , String codigoSistema , String codigoOpcion) throws SICException{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			
			StringBuilder queryCreate = new StringBuilder();
			queryCreate.append("INSERT INTO SCARTTARTAUD");
			queryCreate.append(" (CODIGOCOMPANIA,CODIGOARTICULO,CODOPCCRE,CODSISCRE) VALUES (:pCodigoCompania , :pCodigoArticulo , :pCodigoOpcionCreacion , :pCodigoSistemaCreacion)");
			Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
			sqlQueryCreate.setParameter("pCodigoCompania", codigoCompania);
			sqlQueryCreate.setParameter("pCodigoArticulo", codigoArticulo);
			sqlQueryCreate.setParameter("pCodigoSistemaCreacion", codigoSistema);
			sqlQueryCreate.setParameter("pCodigoOpcionCreacion", codigoOpcion);
			sqlQueryCreate.executeUpdate();
			
			session.flush();
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	public void actualizarAuditoriaExtendida(Integer codigoCompania , String codigoArticulo , String codigoSistema , String codigoOpcion) throws SICException{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			
			StringBuilder queryUpdate = new StringBuilder();
			queryUpdate.append("UPDATE SCARTTARTAUD SET");
			queryUpdate.append(" CODOPCACT = :pCodigoOpcionActualizacion,");
			queryUpdate.append(" CODSISACT = :pCodigoSistemaActualizacion");
			queryUpdate.append(" WHERE CODIGOCOMPANIA = :pCodigoCompania AND CODIGOARTICULO = :pCodigoArticulo");
			
			Query sqlQueryUpdate = session.createSQLQuery(queryUpdate.toString());
			sqlQueryUpdate.setParameter("pCodigoOpcionActualizacion", codigoOpcion);
			sqlQueryUpdate.setParameter("pCodigoSistemaActualizacion", codigoSistema);
			sqlQueryUpdate.setParameter("pCodigoCompania", codigoCompania);
			sqlQueryUpdate.setParameter("pCodigoArticulo", codigoArticulo);
			sqlQueryUpdate.executeUpdate();
			
			session.flush();
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	@Override
	public void registrarArticuloObservacion(String codigoBarras , String observaciones , String usuarioModificacion , Long fechaModificacion) throws SICException {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			
			StringBuilder queryCreate = new StringBuilder();
			queryCreate.append("INSERT INTO SCARTTARTOBSTMP");
			queryCreate.append(" (USUARIOMODIFICACION,FECHAMODIFICACION,CODIGOBARRAS,OBSERVACION) VALUES (:pUsuarioModificacion , :pFechaModificacion , :pCodigoBarras , :pObservaciones)");
			Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
			sqlQueryCreate.setParameter("pUsuarioModificacion", usuarioModificacion);
			sqlQueryCreate.setParameter("pFechaModificacion", fechaModificacion);
			sqlQueryCreate.setParameter("pCodigoBarras", codigoBarras);
			sqlQueryCreate.setParameter("pObservaciones", observaciones);
			sqlQueryCreate.executeUpdate();
			
			session.flush();
			
		}catch (Exception e){
			throw new SICException(e);
		}
	}
	
	@Override
	public Collection<ArticuloObservacionDTO> obtenerArticuloObservacion(String usuarioModificacion , Long fechaModificacion) throws SICException {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			
			Criteria criteria = session.createCriteria(ArticuloObservacionDTO.class);
			criteria.add(Restrictions.eq("id.usuarioModificacion", usuarioModificacion));
			criteria.add(Restrictions.eq("id.fechaModificacion", fechaModificacion));
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("codigoBarras"),("codigoBarras"));
			proList.add(Projections.property("observacion"),("observacion"));
			criteria.setProjection(proList);
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloObservacionDTO.class));
			
			Collection<ArticuloObservacionDTO> articulosCol = criteria.list();
			return articulosCol;
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	@Override
	public void removerArticuloObservacion(String usuarioModificacion , Long fechaModificacion) throws SICException {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
			session.clear();
						
			StringBuilder query = new StringBuilder();
			query.append("delete from ").append(ArticuloObservacionDTO.class.getName())
			.append(" where usuarioModificacion = :pUsuarioModificacion ")
			.append("and fechaModificacion = :pFechaModificacion ");
			
			Query update = session.createQuery(query.toString());
						
			//parametros 
			update.setParameter("pUsuarioModificacion", usuarioModificacion);
			update.setParameter("pFechaModificacion", fechaModificacion);
			
			Integer total = update.executeUpdate();
			Logeable.LOG_SICV2.info("se elimino el articulo observacion : "+total);
			session.flush();
			
		} catch (Exception e) {
			throw new SICException("Error al actualizar el art\u00EDculo.", e);
		}
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
