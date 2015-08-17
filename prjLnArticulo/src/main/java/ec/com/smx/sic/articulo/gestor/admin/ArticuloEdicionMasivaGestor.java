package ec.com.smx.sic.articulo.gestor.admin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.loggin.resources.LogUtilMessages;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.generadorexportacion.spring.batch.core.ExtendedJobParameter;
import ec.com.smx.mensajeria.commons.resources.MensajeriaMessages;
import ec.com.smx.mensajeria.commons.util.ConstantesSMS;
import ec.com.smx.mensajeria.dto.EventoDTO;
import ec.com.smx.mensajeria.dto.id.EventoID;
import ec.com.smx.mensajeria.estructura.ArchivoAdjuntoEST;
import ec.com.smx.mensajeria.estructura.MailMensajeEST;
import ec.com.smx.mensajeria.gestor.MensajeriaG;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumRegistroEdicionMasiva;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloEdicionMasivaGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.IArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloImportacion.IArticuloProveedorImportacionGestor;
import ec.com.smx.sic.cliente.gestor.articulo.clase.IArticuloClaseGestor;
import ec.com.smx.sic.cliente.gestor.articulo.ley.podermercado.IArticuloLeyMercadoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEdicionInternaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.observacion.ArticuloObservacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroMasivoDAO;

public class ArticuloEdicionMasivaGestor implements IArticuloEdicionMasivaGestor{
	
	IArticuloRegistroMasivoDAO articuloRegistroMasivoDAO;//interfaz del dao que contiene los metodos de registro
	IArticuloAlcanceGestor articuloAlcanceGestor;//interfaz del gestor que registra el cambio de prototipo y alcances por local
	ICalculoArticuloGestor calculoArticuloGestor;//interfaz del gestor que administra los calculos y consultas del articulo
	private IArticuloClaseGestor articuloClaseGestor;
	Collection<ArticuloEdicionMasivaVO> articulosRegistrados;//coleccion de articulos registrados
	Collection<ArticuloEdicionMasivaVO> articulosNoRegistrados;//coleccion de articulos no registrados
	
	ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor;
	
	private DataGestor dataGestor;//datagestor, usado para realizar una consulta en base
	MensajeriaG mensajeriaG;//clase que administra el mensaje al mail del usuario logeado
	
	private JobLauncher jobLauncher;
	private Job edicionMasivaArticulosJob;
	private IArticuloLeyMercadoGestor articuloLeyMercadoGestor;
	
	private IArticuloProveedorImportacionGestor articuloProveedorImportacionGestor;//gestor que contiene la logica del articulo proveedor importacion
	
	/**
	 * registra el articulo en base al enumerado asignado
	 */
	@SuppressWarnings("unchecked")
	public void registrarArticuloMasivamente(ArticuloEdicionMasivaVO articulo)throws SICException{
		try {
			
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOGENERAL)){
					if(articulo.getClase() != null && StringUtils.equals(articulo.getCodigoClase(),SICArticuloConstantes.CODIGO_CLASE_ARTICULO_T) 
							&& (articulo.getFechaInicioTemporada() == null || articulo.getFechaFinTemporada() == null)){
						throw new SICException("Error en el registro de la clase, la fecha de inicio y fin son requeridas");
					}
					articuloRegistroMasivoDAO.actualizarDatosArticulo(articulo);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOTEMPORADA)){
					if(StringUtils.equals(articulo.getCodigoClase(),SICArticuloConstantes.CODIGO_CLASE_ARTICULO_T)){
						if(articulo.getFechaInicioTemporada() != null && articulo.getFechaFinTemporada() != null){
							articuloRegistroMasivoDAO.actualizarTemporadaArticulo(articulo , articulo.getFechaInicioTemporada() , articulo.getFechaFinTemporada());
						}
						else{
							throw new SICException("Error en el registro de la clase, la fecha de inicio y fin son requeridas");
						}
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOLEYMERCADO)){
					this.registrarEstadoArticuloLeyMercado(articulo);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOCLASE) && articulo.getCodigoClase() != null){
					this.guardarArticuloClase(articulo);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOCLASEINTERNO)){
					this.registrarArticuloClaseInternamente(articulo);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOMEDIDA)){
					articuloRegistroMasivoDAO.actualizarArticuloMedida(articulo);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOMEDIDAINTERNO)){
					if(articuloRegistroMasivoDAO.validarCaracteristicaDinamica(articulo , TipoCatalogoArticulo.CARACTERISTICA_TIENEPRESENTACIONES , null)){
						articuloRegistroMasivoDAO.actualizarArticuloMedida(articulo);
					}else{
						articulo.getErroresRegistro().add(SICArticuloConstantes.MENSAJE_REGISTRO_CARDIN_ARTICULOMEDIDA);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOCOMERCIAL)){
					articuloRegistroMasivoDAO.actualizarArticuloComercial(articulo);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOMARCACOMERCIALINTERNO)){
					String mensaje = articuloRegistroMasivoDAO.actualizarMarcaComercialInternamente(articulo);
					if(StringUtils.isNotEmpty(mensaje)){
						articulo.getErroresRegistro().add(mensaje);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOCONTROLTIPOPRECIO)){
					String mensaje = articuloRegistroMasivoDAO.actualizarValorTipoControlCosto(articulo);
					if(StringUtils.isNotEmpty(mensaje)){
						articulo.getErroresRegistro().add(mensaje);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOVIDAUTIL)){
					articuloRegistroMasivoDAO.actualizarDatosDuracionConservacion(articulo, SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL, articulo.getTiempoVidaUtil());
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOTIEMPOREFRIGERACION)){
					articuloRegistroMasivoDAO.actualizarDatosDuracionConservacion(articulo, SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO, articulo.getTiempoRefrigeracion());
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOTIEMPOCONGENLACION)){
					articuloRegistroMasivoDAO.actualizarDatosDuracionConservacion(articulo, SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO, articulo.getTiempoCongelacion());
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOVIDAUTILINTERNO)){
					//validamos si el articulo contiene las caracteristicas dinamicas de duracion conservacion
					if(articuloRegistroMasivoDAO.validarCaracteristicaDinamica(articulo , SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL)){
						articuloRegistroMasivoDAO.actualizarDatosDuracionConservacion(articulo, SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL, articulo.getTiempoVidaUtil());
					}else{
						articulo.getErroresRegistro().add(SICArticuloConstantes.MENSAJE_REGISTRO_CARDIN_VIDAUTIL);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOTIEMPOREFRIGERACIONINTERNO)){
					//validamos si el articulo contiene las caracteristicas dinamicas de duracion conservacion
					if(articuloRegistroMasivoDAO.validarCaracteristicaDinamica(articulo , SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO)){
						articuloRegistroMasivoDAO.actualizarDatosDuracionConservacion(articulo, SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO, articulo.getTiempoRefrigeracion());
					}else{
						articulo.getErroresRegistro().add(SICArticuloConstantes.MENSAJE_REGISTRO_CARDIN_REFRIGERADO);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOTIEMPOCONGENLACIONINTERNO)){
					//validamos si el articulo contiene las caracteristicas dinamicas de duracion conservacion
					if(articuloRegistroMasivoDAO.validarCaracteristicaDinamica(articulo , SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO)){
						articuloRegistroMasivoDAO.actualizarDatosDuracionConservacion(articulo, SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO, articulo.getTiempoCongelacion());
					}else{
						articulo.getErroresRegistro().add(SICArticuloConstantes.MENSAJE_REGISTRO_CARDIN_CONGELADO);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOPROVEEDOR)){
					if(articulo.getReferenciaExterna() != null || articulo.getReferenciaInterna() != null){
						articuloRegistroMasivoDAO.actualizarReferenciaProveedor(articulo);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOPROVEEDORINTERNO)){
					articuloRegistroMasivoDAO.actualizarProveedorInternamente(articulo);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOIMPORTACIONINTERNO)){
					Collection<String> codigosProveedor = articuloRegistroMasivoDAO.obtenerCodigosProveedores(articulo , Boolean.TRUE);
					if(CollectionUtils.isNotEmpty(codigosProveedor)){
						for(String codigoProveedor : codigosProveedor){
							articulo.setCodigoProveedor(codigoProveedor);
							this.registrarActualizarArticuloImportacion(articulo);
						}
					}else{
						articulo.getErroresRegistro().add(SICArticuloConstantes.MENSAJE_REGISTRO_PROVEEDORIMPORTADO);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOIMPORTACION)){
					this.registrarActualizarArticuloImportacion(articulo);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOMATERIAL)){
					articuloRegistroMasivoDAO.actualizarArticuloMaterial(articulo , SICArticuloConstantes.getInstancia().CODIGOTIPOMATERIAL , SICArticuloConstantes.getInstancia().VALOR_TIPOMATERIAL_OTRO);
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOAGRUPADOR)){
					if(articulo.getCodigoTipoAgrupador() != null && articulo.getValorTipoAgrupador() != null){
						articuloRegistroMasivoDAO.actualizarArticuloAgrupador(articulo);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOCARACTERISTICAESPECIAL)) {
					for(ArticuloEdicionMasivaVO articuloMasivo : articulo.getCaracteristicasEspeciales()) {
						if(articuloMasivo.getCodigoTipoAgrupador() != null && articuloMasivo.getValorTipoAgrupador() != null && articuloMasivo.hasDynamicProperty("debeGuardar") && articuloMasivo.getDynamicProperty("debeGuardar").equals(Boolean.TRUE)) {
							articuloMasivo.setCodigoCompania(articulo.getCodigoCompania());
							articuloMasivo.setUsuarioModificacion(articulo.getUsuarioModificacion());
							articuloRegistroMasivoDAO.crearOActualizarCaracteristicaEspecial(articuloMasivo);
						}
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOAGRUPADORINTERNO)){
					if(articulo.getCodigoTipoAgrupador() != null && articulo.getValorTipoAgrupador() != null){
						articuloRegistroMasivoDAO.actualizarArticuloAgrupador(articulo);
					}else{
						articulo.setCodigoTipoAgrupador(SICArticuloConstantes.getInstancia().CATALOGOTIPO_AGRUPADOR);
						articuloRegistroMasivoDAO.inactivarAgrupadorArticulo(articulo);
					}
				}
				
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOPROTOTIPO)){
					if(articulo.hasDynamicProperty("articuloVO")){
						ArticuloVO articuloVO = (ArticuloVO) articulo.getDynamicProperty("articuloVO");
						articuloAlcanceGestor.insertarAlcancesCambioPrototipo(articuloVO);
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOIMPUESTO)){	
					if(articulo.getDynamicProperty("articuloImpuestoCol") != null){
						Collection<ArticuloImpuestoDTO> artImpCol = (Collection<ArticuloImpuestoDTO>) articulo.getDynamicProperty("articuloImpuestoCol");
						for (ArticuloImpuestoDTO articuloImpuestoDTO : artImpCol) {
							articuloRegistroMasivoDAO.registrarActualizarArticuloImpuesto(articuloImpuestoDTO);	
						}
					}
				}
				
				if(articulo.getEnumRegistroEdicionMasiva().contains(EnumRegistroEdicionMasiva.ARTICULOIMPUESTOINTERNO)){	
					if(articulo.getDynamicProperty("articuloImpuestoCol") != null){
						Collection<ArticuloImpuestoDTO> artImpCol = (Collection<ArticuloImpuestoDTO>) articulo.getDynamicProperty("articuloImpuestoCol");

						Collection<ArticuloImpuestoDTO> impuestosOrdenados = armarEstructuraImpuestos(artImpCol);
						
						for (ArticuloImpuestoDTO articuloImpuestoDTO : impuestosOrdenados) {
							String mensaje = articuloRegistroMasivoDAO.registrarImpuestosInternamente(articuloImpuestoDTO);
							if(StringUtils.isNotEmpty(mensaje)){
								articulo.getErroresRegistro().add(mensaje);
							}
						}
					}
				}
				
				//registramos la auditoria del articulo
				articuloRegistroMasivoDAO.registrarAuditoriaArticulo(articulo);
				
				//registramos la auditoria del articulo (sistema y opcion)
				this.registrarAuditoriaExtendida(articulo.getCodigoCompania(), articulo.getCodigoArticulo(), LogUtilMessages.getInstancia().getString("log.sistema.MAX"), articulo.getCodigoOpcion());
			
		}
		catch (SICException e){
			throw new SICException(e.getCodigoError(), "Ha ocurrido un error al registrar el art\u00EDculo", e);
		}
		
	}
	
	/**
	 * Metodo para guardar los causales en el articuloClase
	 * @param articulo
	 */
	private void guardarArticuloClase(ArticuloEdicionMasivaVO articulo){
		try{
			Logeable.LOG_SICV2.info("Metodo guardarArticuloClase :: " + articulo.getCausal() +" - " + articulo.getCodigoTipoCausal());
			ArticuloClaseDTO articuloClaseDTO = new ArticuloClaseDTO();
			articuloClaseDTO.setCodigoTipoCausal(articulo.getCodigoTipoCausal());
			articuloClaseDTO.setClaseArticuloAnterior(articulo.getClaseArticuloAnterior());
			articuloClaseDTO.setClaseArticulo(articulo.getCodigoClase());
			articuloClaseDTO.setSecuencialArtCla(articulo.getSecuencialArtCla());
			articuloClaseDTO.getId().setCodigoCompania(articulo.getCodigoCompania());
			articuloClaseDTO.getId().setCodigoArticulo(articulo.getCodigoArticulo());
//			if( articulo.getCausal() != null ){
//				List<String> valorTipoCausal= Arrays.asList(articulo.getCausal().split(" - "));
				articuloClaseDTO.setValorTipoCausal(articulo.getValorTipoCausal());
//			}
			articuloClaseDTO.setUserId(articulo.getUsuarioModificacion());
			if(articulo.getSecuencialArtCla() != null){
				articuloClaseDTO.setIdUsuarioModificacion(articulo.getUsuarioModificacion());
				articuloClaseDTO.setIdUsuarioCambioClase(articulo.getUsuarioModificacion());
				articuloClaseDTO.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
			}else{
				articuloClaseDTO.setRegisterDate(new Timestamp(System.currentTimeMillis()));
			}
			articuloClaseGestor.registrarArticuloClase(articuloClaseDTO);
			articulo.setSecuencialArtCla(articuloClaseDTO.getSecuencialArtCla());
		}
		catch (SICException e){
			throw new SICException(e);
		}
	}
	
	private void registrarArticuloClaseInternamente(ArticuloEdicionMasivaVO articulo)throws SICException{
		try{
			//validamos si existen cambios en la clase y causal
			if(articuloRegistroMasivoDAO.validarValoresArticuloClase(articulo)){
				//guardamos solo el codigo clase del articulo
				String codigoClaseNueva = (String) articulo.getDynamicProperty("codigoClaseNueva");
				articulo.setCodigoClase(codigoClaseNueva);
				articuloRegistroMasivoDAO.actualizarDatosArticulo(articulo);
				//validamos si si tiene temporada
				if(StringUtils.equals(articulo.getCodigoClase(),SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_T)
					&&(articulo.getFechaInicioTemporada() != null && articulo.getFechaFinTemporada() != null)){
						articuloRegistroMasivoDAO.actualizarTemporadaArticulo(articulo , articulo.getFechaInicioTemporada() , articulo.getFechaFinTemporada());
				}
				//actualizamos el articulo clase y bitacora
				this.guardarArticuloClase(articulo);
			}
		}catch(SICException e){
			throw e;
		}
	}
	
	public void registrarEstadoArticuloLeyMercado(ArticuloEdicionMasivaVO articulo) throws SICException{
		try{
			if(articulo != null && (StringUtils.equals(articulo.getCodigoClase(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O))){
				this.articuloLeyMercadoGestor.descodificarArticuloLeyMercado(articulo.getCodigoCompania(), articulo.getCodigoArticulo(), articulo.getUsuarioModificacion(), articulo.getCodigoTipoCausal(), articulo.getValorTipoCausal());				
			}
			//Esto e debe implemetar cuando se den de baja a productos
			if(articulo != null && StringUtils.equals(articulo.getClaseArticuloAnterior(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O)	&& !StringUtils.equals(articulo.getCodigoClase(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O)){
				this.articuloLeyMercadoGestor.reactivarArticuloLeyMercado(articulo.getCodigoCompania(), articulo.getCodigoArticulo(), articulo.getUsuarioModificacion());
			}
		}catch(SICException e){			
			throw new SICException(e.getCodigoError(),"Ha ocurrido un error al registrar EstadoArticuloLeyMercado", e);
		}
	}
	
	private void registrarActualizarArticuloImportacion(ArticuloEdicionMasivaVO articulo) throws SICException{
		if(articulo.getCostoMonedaOrigen() != null || articulo.getPorcentajeComision() != null){
			//verificamos en base si existe el articulo importacion
			Integer numArtProUmp = articuloRegistroMasivoDAO.contarArticuloImportacion(articulo);
			//si no existe registramos en base 
			if(numArtProUmp == 0 && articulo.getCostoMonedaOrigen() != null){
				articuloRegistroMasivoDAO.registrarArticuloImportacion(articulo);
			}else{
				//verificamos si existe diferencia entre los valores existentes en base y los nuevos, si es asi registramos una bitacora
				ArticuloImportacionDTO articuloImportacionDTO = new ArticuloImportacionDTO();
				articuloImportacionDTO.getId().setCodigoCompania(articulo.getCodigoCompania());
				articuloImportacionDTO.getId().setCodigoArticulo(articulo.getCodigoArticulo());
				articuloImportacionDTO.getId().setCodigoProveedor(articulo.getCodigoProveedor());
				articuloImportacionDTO.setCostoMonedaOrigen(articulo.getCostoMonedaOrigen());
				articuloImportacionDTO.setPorcentajeComision(articulo.getPorcentajeComision());
				articuloProveedorImportacionGestor.verificarArticuloImportacionHistorico(articuloImportacionDTO, Boolean.TRUE);
				//actualizamos los valores
				articuloRegistroMasivoDAO.actualizarArticuloImportacion(articulo);
			}
		}
	}
	
	/**
	 * registra el articulo en la tabla pendiente por integracion
	 */
	public void registrarArticuloIntegracion(ArticuloEdicionMasivaVO articulo)throws SICException{
		try {
			this.articuloRegistroMasivoDAO.registrarArticuloPendienteIntegracion(articulo.getCodigoCompania() , articulo.getCodigoArticulo() , articulo.getUsuarioModificacion() , TipoCatalogoArticulo.PROCESO_INTEGRACION_EDICIONMASIVAARTICULOS);
		}catch (SICException e){
			throw new SICException(e);
		}
	}
	
	/**
	 * metodo que realiza el registro internamente (proceso ciego) de los articulos
	 */
	public void registrarArticuloInternamente(Collection<ArticuloEdicionMasivaVO> articuloCol , Integer totalArticulos , Long fechaModificacion)throws SICException{
		Logeable.LOG_SICV2.info("Ingresando al metodo que registra articulos masivamente");
		Boolean registradoCorrectamente = Boolean.TRUE;
		
		for(ArticuloEdicionMasivaVO edicionMasivaVO : articuloCol){
			try{
				//asignamos el codigo de la opcion del item
				edicionMasivaVO.setCodigoOpcion(SICArticuloConstantes.getInstancia().CODIGO_OPCION_EDICION_MASIVA_INTERNA);
				SICFactory.getInstancia().articulo.getArticuloService().registrarArticuloEdicionMasiva(edicionMasivaVO);
			}catch (SICException e){
				registradoCorrectamente = Boolean.FALSE;
				Logeable.LOG_SICV2.info("Ocurrio un error en el registro del articulo "+e.getMessage());
				edicionMasivaVO.getErroresRegistro().add(e.getMessage());
			}finally{
				//si el articulo tuvo errores registramos en la tabla temporal
				if(CollectionUtils.isNotEmpty(edicionMasivaVO.getErroresRegistro())){
					//obtenemos los mensajes de error
					StringBuilder errores = new StringBuilder();
					for(String error : edicionMasivaVO.getErroresRegistro()){
						errores.append(error).append(" ;");
					}
					this.articuloRegistroMasivoDAO.registrarArticuloObservacion(edicionMasivaVO.getCodigoBarrasArticulo() , errores.toString() , edicionMasivaVO.getUsuarioModificacion() , fechaModificacion);
				}
				
				//si se registro correctamente registramos como pendiente de integracion
				if(registradoCorrectamente){
					try {
						SICFactory.getInstancia().articulo.getArticuloService().registrarArticuloIntegracion(edicionMasivaVO);
					}
					catch (SICException e){
						Logeable.LOG_SICV2.info("Ocurrio un error al integrar el articulo "+e.getMessage());
						throw new SICException("Ocurrio un error al integrar el articulo");
					}
				}
			}
		}
	}
	
	/**
	 * metodo que registra los cambios de los articulos editados
	 */
	public String registrarArticulo(Collection<ArticuloEdicionMasivaVO> articuloCol, Boolean envioMail) throws SICException{
		Logeable.LOG_SICV2.info("Ingresando al metodo que registra articulos masivamente");
		StringBuilder codigosArtNoREgistrados = new StringBuilder();
		if(CollectionUtils.isNotEmpty(articuloCol)){
			articulosRegistrados = new ArrayList<ArticuloEdicionMasivaVO>();
			articulosNoRegistrados = new ArrayList<ArticuloEdicionMasivaVO>();
			Boolean existeCambio = Boolean.FALSE;
			Boolean registrado = Boolean.FALSE;
			SICException error = new SICException("Ocurrio un error al registrar los articulos");
			Boolean errorLeyMercado = Boolean.FALSE;
			for(ArticuloEdicionMasivaVO edicionMasivaVO : articuloCol){
				
				try{
					registrado = Boolean.TRUE;
					existeCambio = Boolean.FALSE;
					Integer cont = 0;
					if(CollectionUtils.isNotEmpty(edicionMasivaVO.getEnumRegistroEdicionMasiva())){
						existeCambio = Boolean.TRUE;
						Logeable.LOG_SICV2.info(cont.toString());
						//asignamos el codigo de la opcion del item
						edicionMasivaVO.setCodigoOpcion(SICArticuloConstantes.getInstancia().CODIGO_OPCION_EDICION_MASIVA_ASISTIDA);
						SICFactory.getInstancia().articulo.getArticuloService().registrarArticuloEdicionMasiva(edicionMasivaVO);
						cont ++;
					}
				}
				catch (SICException e){
					registrado = Boolean.FALSE;
					articulosNoRegistrados.add(edicionMasivaVO);
					edicionMasivaVO.setValidacionRegistroError(Boolean.TRUE);
					error = e;
					if( e.getCodigoError() != null  && "001".equals(e.getCodigoError()) ){
						errorLeyMercado = Boolean.TRUE;
					}
					Logeable.LOG_SICV2.info("Ocurrio un error en el registro del articulo "+e.getMessage());
				}
				finally{
					if(registrado && existeCambio){
						articulosRegistrados.add(edicionMasivaVO);
						edicionMasivaVO.setValidacionRegistroError(Boolean.FALSE);
					}
				}
			}
			//registra los articulos que se han guardado con exito registra en la tabla pendiente de integracion
			if(CollectionUtils.isNotEmpty(articulosRegistrados)){
				Logeable.LOG_SICV2.info("Ingresando al metodo que integra los articulos registrados");
				Collection<ArticuloEdicionMasivaVO> articulosNoRepetidos = obtenerArticulosCodigoUnico(articulosRegistrados);
				for(ArticuloEdicionMasivaVO edicionMasivaVO : articulosNoRepetidos){
					try {
						SICFactory.getInstancia().articulo.getArticuloService().registrarArticuloIntegracion(edicionMasivaVO);
					}
					catch (SICException e){
						Logeable.LOG_SICV2.info("Ocurrio un error al registrar los articulos "+e.getMessage());
						throw new SICException("Ocurrio un error al registrar los articulos");
					}
				}
			}
			if(CollectionUtils.isNotEmpty(articulosNoRegistrados)){
				Integer count = 0; 
				for(ArticuloEdicionMasivaVO edicionMasivaVO : articulosNoRegistrados){
					count ++;
					if(count < articulosNoRegistrados.size()){
						codigosArtNoREgistrados.append(edicionMasivaVO.getCodigoBarrasArticulo()+", ");
					}else{
						codigosArtNoREgistrados.append(edicionMasivaVO.getCodigoBarrasArticulo()+" ");
					}
				}
				codigosArtNoREgistrados.append(", "+errorLeyMercado);
			}
			//Se valida el envio de mail
			if(envioMail){
				Logeable.LOG_SICV2.info("Ingresando al metodo que envia el mail del registro");
				SICFactory.getInstancia().articulo.getArticuloService().envioMailEdicionMasivaArticulo(articuloCol.iterator().next().getCodigoCompania(), articuloCol.iterator().next().getUsuarioModificacion(), articulosNoRegistrados , CollectionUtils.isNotEmpty(articulosRegistrados));
			}
			else if(CollectionUtils.isEmpty(articulosRegistrados) && CollectionUtils.isNotEmpty(articulosNoRegistrados)){
				throw error;
			}
		} 
		return codigosArtNoREgistrados.toString();
	}
	
	
	public Integer consultarNumeroArticulosRegistrados(String sqlQuery) throws SICException{
		try{
			return calculoBusquedaArticuloGestor.buscarCantidadArticulosEdicionInterna(sqlQuery);
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Ocurrio un error al obtener el numero de articulos registrados: "+e.getMessage());
			throw new SICException("Ocurrio un error al obtener el numero de articulos registrados");
		}
	}
	
	
	public void registroArticulosMasivoInterno(String sqlQuery , ArticuloEdicionMasivaVO plantillaRegistro , String usuarioModificacion , Integer numArticulos , String fechaModificacion , Integer codigoCompania)throws SICException{
		
		try { 
			Logeable.LOG_SICV2.info(numArticulos.toString());
			JobExecution jobExecution = null;
			
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("fechaEjecucion", new JobParameter(new Date()));
			params.put("consultaHQL", new JobParameter(sqlQuery));
			params.put("viewAlias", new JobParameter("vista"));
			params.put("baseDTO", new ExtendedJobParameter(new ArticuloEdicionInternaDTO()));
			params.put("plantillaRegistro", new ExtendedJobParameter(plantillaRegistro));
			params.put("usuarioModificacion", new JobParameter(usuarioModificacion));
			params.put("totalArticulos", new JobParameter(numArticulos.toString()));
			params.put("fechaModificacion", new JobParameter(fechaModificacion));
			params.put("codigoCompania", new JobParameter(codigoCompania.toString()));
			
			try {
				jobExecution = jobLauncher.run(edicionMasivaArticulosJob, new JobParameters(params));
			} catch (JobExecutionAlreadyRunningException e) {
				// TODO Auto-generated catch block
				Logeable.LOG_SICV2.info(e.getMessage());
			} catch (JobRestartException e) {
				// TODO Auto-generated catch block
				Logeable.LOG_SICV2.info(e.getMessage());
			} catch (JobInstanceAlreadyCompleteException e) {
				// TODO Auto-generated catch block
				Logeable.LOG_SICV2.info(e.getMessage());
			} catch (JobParametersInvalidException e) {
				// TODO Auto-generated catch block
				Logeable.LOG_SICV2.info(e.getMessage());
			}
			Logeable.LOG_SICV2.info("El trabajo ha finalizado con estado:{} ", jobExecution.getExitStatus());
			
			if (jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
				Logeable.LOG_SICV2.info("Ingresando al metodo que envia el mail del registro");
				SICFactory.getInstancia().articulo.getArticuloService().envioMailEdicionInternaArticulo( codigoCompania, usuarioModificacion , numArticulos , Long.parseLong(fechaModificacion));
			}
			
		}catch(SICException e){
			Logeable.LOG_SICV2.info("Ocurrio un error en la actualizacion masiva interna de articulos: "+e.getMessage());
			throw new SICException("Ocurrio un error en la actualizacion masiva interna de articulos");
		}
	}
	
	/**
	 * gestiona el envio del mail al usuario logeado
	 */
	public void envioMailEdicionMasivaArticulo(Integer codigoCompania, String userId, Collection<ArticuloEdicionMasivaVO> articulosNoRegistrados , Boolean datosRegistrados)throws SICException{
		//Obtenemos el mail del usuario
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		userDto = dataGestor.findUnique(userDto);
		//Validar el usuario
		if(userDto == null || StringUtils.isBlank(userDto.getUserEmail())){
			throw new SICException("El usuario no posee mail");
		}
		
		EventoID eventoID = new EventoID();
		eventoID.setCodigoEvento(SICConstantes.CODIGO_EVENTOID_MAIL_EDICION_MASIVA_ARTICULOS);
		eventoID.setSystemId(SICConstantes.CODIGO_SISTEMA_MAX);
		eventoID.setCompanyId(codigoCompania);
		enviarMailEdicion(eventoID, new String[]{userDto.getUserEmail()},userDto.getUserCompleteName(),null, "Edici\u00F3n masiva de art\u00EDculos", articulosNoRegistrados , datosRegistrados);
	}
	
	/**
	 * gestiona el envio del mail al usuario logeado
	 */
	public void envioMailEdicionInternaArticulo(Integer codigoCompania, String userId, Integer datosRegistrados , Long fechaModificacion)throws SICException{
		//Obtenemos el mail del usuario
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		userDto = dataGestor.findUnique(userDto);
		//Validar el usuario
		if(userDto == null || StringUtils.isBlank(userDto.getUserEmail())){
			throw new SICException("El usuario no posee mail");
		}
		
		EventoID eventoID = new EventoID();
		eventoID.setCodigoEvento(SICConstantes.CODIGO_EVENTOID_MAIL_EDICION_MASIVA_ARTICULOS);
		eventoID.setSystemId(SICConstantes.CODIGO_SISTEMA_MAX);
		eventoID.setCompanyId(codigoCompania);
		
		//DECLARAMOS EL ARCHIVO ADJUNTO COMO NULO
		ArchivoAdjuntoEST archivoAdjuntoEST = null;
		ByteArrayOutputStream baos = null;
		
		//obtenemos los articulos que contienen observaciones(por el usuario y la fecha de modificacion)
		Collection<ArticuloObservacionDTO> articuloObservacionCol = articuloRegistroMasivoDAO.obtenerArticuloObservacion(userId, fechaModificacion);
		
		//validamos si no existe observaciones
		if(CollectionUtils.isNotEmpty(articuloObservacionCol)){
		
			//arma la estructura final con las observaciones
			Collection<ArticuloObservacionDTO> articuloObservacionColFinal = new ArrayList<ArticuloObservacionDTO>();
			for(ArticuloObservacionDTO articuloObservacionDTO2 : articuloObservacionCol){
				String[] observaciones = articuloObservacionDTO2.getObservacion().split(";");
				ArticuloObservacionDTO articuloObservacionNuevo;
				if(observaciones.length > 0){
					for(String observacion : observaciones){
						articuloObservacionNuevo = new ArticuloObservacionDTO();
						articuloObservacionNuevo.setCodigoBarras(articuloObservacionDTO2.getCodigoBarras());
						articuloObservacionNuevo.setObservacion(observacion);
						articuloObservacionColFinal.add(articuloObservacionNuevo);
					}
				}
				//agregamos una fila en blanco despues de cada articulo
				articuloObservacionNuevo = new ArticuloObservacionDTO();
				articuloObservacionNuevo.setCodigoBarras("");
				articuloObservacionNuevo.setObservacion("");
				articuloObservacionColFinal.add(articuloObservacionNuevo);
			}
			
			//registra valores en las cabeceras de las columnas
			List<String> cabecerasCol=new ArrayList<String>();
			cabecerasCol.add("");
			cabecerasCol.add("CODIGO BARRAS");
			cabecerasCol.add("OBSERVACIONES");
			
			//creamos el libro con las observaciones
			Workbook libro = new XSSFWorkbook();
			Sheet hoja = libro.createSheet("Novedades");
			//registra los anchos de las columnas
	        hoja.setColumnWidth(0, 3000);
	        hoja.setColumnWidth(1, 5400);
	        hoja.setColumnWidth(2, 35000);
	        
			Font fuente = libro.createFont();
			//fuente.setFontName("Arial");
			fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			CellStyle estiloCeldaTitle = libro.createCellStyle();
			estiloCeldaTitle.setFont(fuente);
			estiloCeldaTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			estiloCeldaTitle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloCeldaTitle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloCeldaTitle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloCeldaTitle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			
			CellStyle estiloCeldaHeader = libro.createCellStyle();
			estiloCeldaHeader.setFont(fuente);
			estiloCeldaHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			
			Row titulo = hoja.createRow(0);
	        Cell cellTitulo = titulo.createCell(0);
	        cellTitulo.setCellValue("NOVEDADES EN LA EDICI\u00D3N MASIVA DE ART\u00CDCULOS");
	        cellTitulo.setCellStyle(estiloCeldaHeader);
	        
	        //creamos un espacio despues del titulo
	        hoja.createRow(1);
			
			//inmoviliza las dos primeras filas
	        hoja.createFreezePane(0, 3);
	        //agrupamos las celdas para el titulo
	        hoja.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
	        //variable que registra el codigo barras actual
			String codigoBarras = null;
			
			//armamos la estructura del excel con los datos consultados en base
			  for(int i=0 ; i <= articuloObservacionColFinal.size() ; i++){
		        	Row row = hoja.createRow(i+2);
		        	
		        	ArticuloObservacionDTO articuloObservacion = null;
		        	
		        	for(int j=0 ; j < cabecerasCol.size() ;j ++){
		        		Cell cell = row.createCell(j);
		        		if(i==0){
		        			cell.setCellValue(cabecerasCol.get(j));
			       			if(StringUtils.isNotEmpty(cabecerasCol.get(j))) cell.setCellStyle(estiloCeldaTitle);
		        		}else{
		        			articuloObservacion = (ArticuloObservacionDTO) CollectionUtils.get(articuloObservacionColFinal, i-1);
		        			if(j==0){
		        				cell.setCellValue("");
		           			}
		        			if(j==1){
		        				if(!StringUtils.equals(codigoBarras, articuloObservacion.getCodigoBarras())){
		        					cell.setCellValue(articuloObservacion.getCodigoBarras());
		        				}else{
		        					cell.setCellValue("");
		        				}
		        				codigoBarras = articuloObservacion.getCodigoBarras();
		           			} 
		        			if(j==2){
		        				cell.setCellValue(articuloObservacion.getObservacion());
		           			}
		        		}
		        	}
		        }
			
			baos = new ByteArrayOutputStream();
			try {
				libro.write(baos);
			} catch (IOException e) {
				Logeable.LOG_SICV2.info("ocurrio un error al crear el archivo: "+e.getMessage());
			}
			byte[] xls = baos.toByteArray();
	        
	        archivoAdjuntoEST = new ArchivoAdjuntoEST();
	        archivoAdjuntoEST.setArchivo(xls);
	        archivoAdjuntoEST.setNombreArchivo("Novedades edicion masiva.xlsx");
	        archivoAdjuntoEST.setNombreCompletoArcAdj("Novedades edicion masiva.xlsx");
	        archivoAdjuntoEST.setTipoArchivo("application/vnd.ms-excel;charset=UTF-8");
		}
        
		enviarMailEdicionInterna(eventoID, new String[]{userDto.getUserEmail()},userDto.getUserCompleteName(),null, "Edici\u00F3n masiva de art\u00EDculos", archivoAdjuntoEST , datosRegistrados);
		
		//eliminamos los datos que ya se enviaron al mail
		articuloRegistroMasivoDAO.removerArticuloObservacion(userId, fechaModificacion);
		try {
			if(baos != null) baos.close();
		} catch (IOException e) {
			Logeable.LOG_SICV2.info("ocurrio un error al cerrar el archivo: "+e.getMessage());
		}
	}
	
	/**
	 * este metodo envia la plantilla del mail a enviarse
	 * @param eventoID
	 * @param para
	 * @param cc
	 * @param contenido
	 * @param asunto
	 * @return
	 * @throws SICException
	 */
	private void enviarMailEdicion(EventoID eventoID, String para[],String userRecipient, String[] cc, String asunto, Collection<ArticuloEdicionMasivaVO> articulosNoRegistrados ,Boolean datosRegistrados) throws SICException {
		try {			
			EventoDTO eventoDTO = mensajeriaG.obtenerEventoPorID(eventoID);
			Logeable.LOG_SICV2.info("El evento es: {}",eventoDTO.getAsuntoEvento());
			
			MailMensajeEST mailMensajeEST = new MailMensajeEST();
			mailMensajeEST.setPara(para);
			mailMensajeEST.setCc(cc);
			mailMensajeEST.setCco(cc);
			mailMensajeEST.setAsunto(asunto);
			mailMensajeEST.setMensajeXML(obtenerXMLMensaje(userRecipient, articulosNoRegistrados , datosRegistrados));
			mailMensajeEST.setEventoDTO(eventoDTO);
			mailMensajeEST.setHost(MensajeriaMessages.getString("mail.serverHost"));
			mailMensajeEST.setPuerto(MensajeriaMessages.getString("mail.puerto"));
			mailMensajeEST.setFormatoHTML(true);

			mensajeriaG.envioMail(mailMensajeEST, ConstantesSMS.BORRAR_ARCHIVOS_NO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error en el metodo enviarMail",e);
			throw new SICException("Error al enviar mail {}",e);
		}
	}
	
	/**
	 * este metodo envia la plantilla del mail a enviarse
	 * @param eventoID
	 * @param para
	 * @param cc
	 * @param contenido
	 * @param asunto
	 * @return
	 * @throws SICException
	 */
	private void enviarMailEdicionInterna(EventoID eventoID, String para[],String userRecipient, String[] cc, String asunto,  ArchivoAdjuntoEST archivoAdjuntoEST , Integer cantidadArticulosRegistrados) throws SICException {
		try {			
			EventoDTO eventoDTO = mensajeriaG.obtenerEventoPorID(eventoID);
			Logeable.LOG_SICV2.info("El evento es: {}",eventoDTO.getAsuntoEvento());
			
			MailMensajeEST mailMensajeEST = new MailMensajeEST();
			mailMensajeEST.setPara(para);
			mailMensajeEST.setCc(cc);
			mailMensajeEST.setCco(cc);
			mailMensajeEST.setAsunto(asunto);
			mailMensajeEST.setMensajeXML(obtenerXMLMensajeInterno(userRecipient , cantidadArticulosRegistrados , archivoAdjuntoEST != null));
			mailMensajeEST.setEventoDTO(eventoDTO);
			mailMensajeEST.setHost(MensajeriaMessages.getString("mail.serverHost"));
			mailMensajeEST.setPuerto(MensajeriaMessages.getString("mail.puerto"));
			mailMensajeEST.setFormatoHTML(true);
			if(archivoAdjuntoEST != null){
				ArchivoAdjuntoEST [] archivoAdjuntoESTVector = new ArchivoAdjuntoEST [1];
				archivoAdjuntoESTVector [0] = archivoAdjuntoEST;
				mailMensajeEST.setArchivosAdjuntosEST(archivoAdjuntoESTVector);
			}
			
			mensajeriaG.envioMail(mailMensajeEST, ConstantesSMS.BORRAR_ARCHIVOS_NO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error en el metodo enviarMail",e);
			throw new SICException("Error al enviar mail {}",e);
		}
	}
	
	/**
	 * Permite obtener el xml necesario para la plantilla xsl
	 * @param para
	 * @param articulos
	 * @return
	 */
	private String obtenerXMLMensaje(String para, Collection<ArticuloEdicionMasivaVO> articulosNoRegistrados , Boolean datosRegistrados){
		StringBuilder mensajeXML = new StringBuilder();
		mensajeXML.append("<?xml version='1.0' encoding='UTF-8'?>");
		mensajeXML.append("<datos>");
		mensajeXML.append("<para>"+para+"</para>");
		if(datosRegistrados){
			mensajeXML.append("<textoCabecera>Se ha realizado correctamente el registro en la edici\u00F3n masiva de art\u00EDculos</textoCabecera>");
		}
		else{
			mensajeXML.append("<textoCabecera></textoCabecera>");
		}
		if(CollectionUtils.isNotEmpty(articulosNoRegistrados)){
			mensajeXML.append("<textoCabeceraError>Los siguientes art\u00EDculos no se registraron</textoCabeceraError>");
			for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO:articulosNoRegistrados){
				mensajeXML.append("<articulos>");
				mensajeXML.append("<codigoBarras>"+articuloEdicionMasivaVO.getCodigoBarrasArticulo()+"</codigoBarras>");
				mensajeXML.append("<descripcion>"+articuloEdicionMasivaVO.getDescripcion()+"</descripcion>");
				mensajeXML.append("</articulos>");
			}
		}
		
		mensajeXML.append("</datos>");
		return mensajeXML.toString();
	}
	
	/**
	 * Permite obtener el xml necesario para la plantilla xsl
	 * @param para
	 * @param articulos
	 * @return
	 */
	private String obtenerXMLMensajeInterno(String para , Integer datosRegistrados , Boolean datosAdjuntos){
		StringBuilder mensajeXML = new StringBuilder();
		mensajeXML.append("<?xml version='1.0' encoding='UTF-8'?>");
		mensajeXML.append("<datos>");
		mensajeXML.append("<para>"+para+"</para>");
		if(datosRegistrados != 0 && datosRegistrados > 0){
			mensajeXML.append("<textoCabecera>Se ha realizado correctamente el registro en la edici\u00F3n masiva de art\u00EDculos, "+datosRegistrados.toString()+" art\u00EDculos procesados.");
			if(datosAdjuntos){
				mensajeXML.append("<br/>");
				mensajeXML.append("Algunos campos no se actualizaron debido a restricciones y/o caracter\u00EDsticas din\u00E1micas. Los art\u00EDculos que contienen campos que no se procesaron se encuentran en el archivo adjunto");
			}
			mensajeXML.append("</textoCabecera>");
		}
		else{
			mensajeXML.append("<textoCabecera></textoCabecera>");
		}
		/*if(datosAdjuntos){
			mensajeXML.append("<textoCabeceraError>Algunos campos no se actualizaron debido a restricciones y/o caracter\u00EDsticas din\u00E1micas. Los art\u00EDculos que contienen campos que no se procesaron se encuentran en el archivo adjunto </textoCabeceraError>");
		}*/
		
		mensajeXML.append("</datos>");
		return mensajeXML.toString();
	}
	
	
	
	
	/**
	 * metodo que obtiene los articulos con el codigo del articulo que no se repita
	 * @param articulosRegistradosCol
	 * @return
	 */
	private Collection<ArticuloEdicionMasivaVO> obtenerArticulosCodigoUnico(Collection<ArticuloEdicionMasivaVO> articulosRegistradosCol){
		Collection<ArticuloEdicionMasivaVO> articulosIntegrarCol = new ArrayList<ArticuloEdicionMasivaVO>();
		for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO : articulosRegistradosCol){
			if(!verificarExistenciaArticulo(articuloEdicionMasivaVO, articulosIntegrarCol)){
				articulosIntegrarCol.add(articuloEdicionMasivaVO);
			}
		}
		return articulosIntegrarCol;
	}
	
	/**
	 * verifica si el articulo parametrizado se encuentra en la coleccion
	 * @param articuloEdicionMasivaVO
	 * @param artCol
	 * @return
	 */
	private Boolean verificarExistenciaArticulo(ArticuloEdicionMasivaVO articuloEdicionMasivaVO , Collection<ArticuloEdicionMasivaVO> artCol){
		
		if(CollectionUtils.isNotEmpty(artCol)){
			for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO2 : artCol){
				if(StringUtils.equals(articuloEdicionMasivaVO2.getCodigoArticulo(),articuloEdicionMasivaVO.getCodigoArticulo())){
					return Boolean.TRUE;
				}
			}
		}
		
		return Boolean.FALSE;
	}
	
	/**
	 * metodo que registra la auditoria del articulo , (sistema y opcion)
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoSistema
	 * @param codigoOpcion
	 */
	public void registrarAuditoriaExtendida(Integer codigoCompania , String codigoArticulo , String codigoSistema , String codigoOpcion) throws SICException {
		try{
			if(!articuloRegistroMasivoDAO.verificarExistenciaAuditoriaExtendida(codigoCompania , codigoArticulo)){
				articuloRegistroMasivoDAO.registrarAuditoriaExtendida(codigoCompania , codigoArticulo , codigoSistema , codigoOpcion);
			}else{
				articuloRegistroMasivoDAO.actualizarAuditoriaExtendida(codigoCompania , codigoArticulo , codigoSistema , codigoOpcion);
			}
		}catch(SICException e){
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException("Ha ocurrido un error al registrar la auditoria del articulo");
		}
	}
	
	/**
	 *  validamos el orden en que me llega los impuestos (primero el impuesto iva 12 y despues el impuesto iva 0)
	 *	si el imp iva 0 se va a activar y el imp iva 12 se inactivara se debe cambiar el orden en que llega
	 *	puesto que si llega el imp iva 12 se verifica que exista el imp iva 12 y no se activara, por lo cual es nesesario
	 *	inactivar primero el imp iva0 
	 * @param articuloImpuestoCol
	 * @return
	 */
	private Collection<ArticuloImpuestoDTO> armarEstructuraImpuestos(Collection<ArticuloImpuestoDTO> articuloImpuestoCol){
		
		ArticuloImpuestoDTO articuloImpuestoIva0 = (ArticuloImpuestoDTO) CollectionUtils.find(articuloImpuestoCol, new BeanPredicate("id.codigoTipoImpuesto" , PredicateUtils.equalPredicate(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA_0)));
		ArticuloImpuestoDTO articuloImpuestoIva12 = (ArticuloImpuestoDTO) CollectionUtils.find(articuloImpuestoCol, new BeanPredicate("id.codigoTipoImpuesto" , PredicateUtils.equalPredicate(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA)));
	
		if(articuloImpuestoIva0 != null && articuloImpuestoIva12 != null){
			if((StringUtils.equals(articuloImpuestoIva12.getEstadoArticuloImpuesto(), SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO) 
				&& (StringUtils.equals(articuloImpuestoIva0.getEstadoArticuloImpuesto(), SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO)
				|| (StringUtils.equals(articuloImpuestoIva0.getEstadoArticuloImpuesto(), SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)
				&& ( BooleanUtils.isFalse(articuloImpuestoIva0.getEsParaCompra()) || BooleanUtils.isFalse(articuloImpuestoIva0.getEsParaVenta())))))){
						
						
				ArticuloImpuestoDTO articuloImpuestoIva12Clon = SerializationUtils.clone(articuloImpuestoIva12);
				//removemos el iva12 de la primera posicion
				articuloImpuestoCol.remove(articuloImpuestoIva12);
				//agregamos el iva12 al final de la coleccion
				articuloImpuestoCol.add(articuloImpuestoIva12Clon);
			}
		}
		return articuloImpuestoCol;
	}
	
	/**
	 * @return the articuloRegistroMasivoDAO
	 */
	public IArticuloRegistroMasivoDAO getArticuloRegistroMasivoDAO() {
		return articuloRegistroMasivoDAO;
	}

	/**
	 * @param articuloRegistroMasivoDAO the articuloRegistroMasivoDAO to set
	 */
	public void setArticuloRegistroMasivoDAO(IArticuloRegistroMasivoDAO articuloRegistroMasivoDAO) {
		this.articuloRegistroMasivoDAO = articuloRegistroMasivoDAO;
	}

	/**
	 * @return the articuloAlcanceGestor
	 */
	public IArticuloAlcanceGestor getArticuloAlcanceGestor() {
		return articuloAlcanceGestor;
	}

	/**
	 * @param articuloAlcanceGestor the articuloAlcanceGestor to set
	 */
	public void setArticuloAlcanceGestor(IArticuloAlcanceGestor articuloAlcanceGestor) {
		this.articuloAlcanceGestor = articuloAlcanceGestor;
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @param mensajeriaG the mensajeriaG to set
	 */
	public void setMensajeriaG(MensajeriaG mensajeriaG) {
		this.mensajeriaG = mensajeriaG;
	}
	
	public void setArticuloClaseGestor(IArticuloClaseGestor articuloClaseGestor) {
		this.articuloClaseGestor = articuloClaseGestor;
	}
	
	public void setCalculoArticuloGestor(ICalculoArticuloGestor calculoArticuloGestor) {
		this.calculoArticuloGestor = calculoArticuloGestor;
	}

	/**
	 * @param jobLauncher
	 *            the jobLauncher to set
	 */
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	/**
	 * @param edicionMasivaArticulosJob the edicionMasivaArticulosJob to set
	 */
	public void setEdicionMasivaArticulosJob(Job edicionMasivaArticulosJob) {
		this.edicionMasivaArticulosJob = edicionMasivaArticulosJob;
	}

	public void setArticuloLeyMercadoGestor(IArticuloLeyMercadoGestor articuloLeyMercadoGestor) {
		this.articuloLeyMercadoGestor = articuloLeyMercadoGestor;
	}
	
	public void setCalculoBusquedaArticuloGestor(ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor) {
		this.calculoBusquedaArticuloGestor = calculoBusquedaArticuloGestor;
	}

	/**
	 * @param articuloProveedorImportacionGestor the articuloProveedorImportacionGestor to set
	 */
	public void setArticuloProveedorImportacionGestor(IArticuloProveedorImportacionGestor articuloProveedorImportacionGestor) {
		this.articuloProveedorImportacionGestor = articuloProveedorImportacionGestor;
	}
}
