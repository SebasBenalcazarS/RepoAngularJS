/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.corpv2.common.seguridades.autorizacion.IAuthorizationComponent;
import ec.com.smx.corpv2.etiquetado.exception.EtiquetadoException;
import ec.com.smx.corpv2.etiquetado.modelo.dto.TagFormatDTO;
import ec.com.smx.framework.common.util.predicate.InPredicate;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.generadorexportacion.dto.EnvioDTO;
import ec.com.smx.generadorexportacion.dto.id.FormatoID;
import ec.com.smx.generadorexportacion.exception.GeneradorExportacionException;
import ec.com.smx.generadorexportacion.listener.GeneracionExportacionListener;
import ec.com.smx.generadorexportacion.util.GeneradorExportacionService;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.common.articulo.EnumSubProcesoGuardadoArticulo;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloValidacion;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaBusquedaEdicionMasivaArticulos;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.common.articulo.filtros.PlantillaFiltrosBusquedaB2B;
import ec.com.smx.sic.cliente.common.proveedor.ProveedorConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloEdicionMasivaGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.accion.IAccionArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloLeyenda;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloProveedorNovedadGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestorB2B;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.precios.IValidacionArticuloReglasComercialesGestor;
import ec.com.smx.sic.cliente.gestor.articulo.archivo.IArticuloArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloPrecioDiferenciado.IArticuloPrecioDiferenciadoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloagrupador.IArticuloAgrupadorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.auditoria.almacenamiento.IAlmacenamientoAuditoriaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.clase.IArticuloClaseGestor;
import ec.com.smx.sic.cliente.gestor.articulo.ley.podermercado.IArticuloLeyMercadoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.mercancias.IArticuloMercanciaGestor;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.IArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.regsan.IArticuloRegistroSanitarioGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDuracionConservacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstructuraComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaMercanciaCatalogoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMaterialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoVentaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloCodBarrasEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCampoMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.ContenedorArticulo;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloAsignacionLocalVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloGeneralVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloIntegracionDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloLocalPrecioDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IVistaCampoMercanciaDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.restricciones.ArticuloTemporadaRestriction;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.dao.IArticuloNuevoImportadoDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
/**
 * Implementaci&oacute;n de los sevicios para el control de art&iacute;culos
 * @author fmunoz
 *
 */
public class ArticuloGestor extends BaseArticuloGestor implements IArticuloGestor,Logeable{
 
	private IArticuloArchivoGestor articuloArchivoGestor;
	
	private IArticuloRegistroSanitarioGestor articuloRegistroSanitarioGestor;
	private IValidacionArticuloGestor validacionArticuloGestor;
	
	private ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor;
	private ICalculoArticuloProveedorNovedadGestor calculoArticuloProveedorNovedadGestor;
	private IAccionArticuloGestor accionArticuloGestor;
	
	private IArticuloDAO articuloDAO;
	private IArticuloLocalPrecioDAO articuloLocalPrecioDAO;
	private ICalculoArticuloLeyenda calculoArticuloLeyenda;
	private ICalculoBusquedaArticuloGestorB2B calculoBusquedaArticuloGestorB2B;
	private IAlmacenamientoAuditoriaArticuloGestor almacenamientoAuditoriaArticuloGestor;
	private IValidacionArticuloReglasComercialesGestor validacionArticuloReglasComercialesGestor;
	private IParametroGestor parametroGestor;
	private IVistaCampoMercanciaDAO camposMercanciaDAO;
	private IArticuloMercanciaGestor articuloMercanciaGestor;
	private IArticuloClaseGestor articuloClaseGestor;
	private IArticuloNuevoImportadoDAO articuloNuevoImportadoDAO;
	private IArticuloLeyMercadoGestor articuloLeyMercadoGestor;
	private IArticuloAgrupadorGestor articuloAgrupadorGestor;
	private IArticuloPrecioDiferenciadoGestor articuloPrecioDiferenciadoGestor;
	private IArticuloEdicionMasivaGestor articuloEdicionMasivaGestor; 
	private IArticuloIntegracionDAO articuloIntegracionDAO;

	
	/**
	 * Realiza la actualizaci&oacute;n de un art&iacute;culo en la base de datos 
	 * @param articuloVO
	 */
	public ArticuloVO registrarArticulo(ArticuloVO articuloVO) throws SICException{
		
		Logeable.LOG_SICV2.info("------------------------------------------------------------------------");
		Logeable.LOG_SICV2.info("----------------------- INICIO REGISTRO ARTICULO -----------------------");
		Logeable.LOG_SICV2.info("------------------------------------------------------------------------");
		
		ArticuloDTO respaldo = null;
		Boolean registrarSubProceso = Boolean.TRUE;
		try{
			final String campoCodigoArticulo = "id.codigoArticulo";
			Boolean esCreacion = articuloVO.getBaseDTO().getId().getCodigoArticulo() == null;
			registrarSubProceso = articuloVO.getSubProcesoGuardadoArticulo() == null;
			//se respalda el articulo antes de realizar cualquier cambio
			//respaldo = SerializationUtils.clone(articuloVO.getBaseDTO());
			respaldo = calculoArticuloGestor.respaldarDatosArticulo(articuloVO, registrarSubProceso);
			//se incia el respaldo de algunos datos del articulo
			articuloVO.setEsCreacion(esCreacion);
			this.calculoArticuloGestor.asignarCamposArticulo(articuloVO);
			//ejecucion de reglas de negocio
			this.validacionArticuloGestor.validarConsistenciaDatos(articuloVO.getBaseDTO());
			//validacion de la descripcion del articulo que no tenga caracteres especiales						
			validacionDescripcionArticulo(articuloVO);				
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.CODIGOBARRAS)){
				this.calculoArticuloGestor.asignarCamposCodigoBarras(articuloVO, validacionArticuloGestor.validarAsignacionCodigoBarras(articuloVO));
			}					
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULO)){
				if(BooleanUtils.isFalse(esCreacion)){
					String estadoArticulo = this.articuloDAO.obtenerEstadoArticulo(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo());
					articuloVO.addDynamicProperty("estadoArticuloAnterior", estadoArticulo);
				}
				this.registrarArticuloGeneral(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOLEYMERCADO)){
				this.registrarEstadoArticuloLeyMercado(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOCLASE)){
				this.registrarArticuloClase(articuloVO);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOCOMERCIAL)){
				this.articuloComercialGestor.registrarArticuloComercial(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOTEMPORADA)){			
				this.registrarArticuloTemporada(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOGARANTIA)){
				registrarArticuloGarantia(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOADICIONAL)){
				registrarArticuloInformacionAdicional(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOCARACTERISTICAS)){
				registrarArticuloCaracteristicas(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOINTERNET)){			
				registrarArticuloInternet(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOMEDIDA)){			
				registrarArticuloMedida(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULODEFINICIONARCHIVO)){
				registrarArticuloDefinicionArchivo(articuloVO);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOETIQUETA)){			
				registrarArticuloEtiqueta(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOETIQUETAMERCANCIA)){	
				registrarArticuloEtiquetaMercancia(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULODURACIONCONSERVACION)){			
				registrarArticuloDuracionConservacion(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOUSO)){			
				registrarArticuloUso(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOPROVEEDOR)){
				registrarArticuloProveedor(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOUNIDADMANEJO)){
				
				this.articuloUnidadManejoGestor.registrarArticuloUnidadManejo(articuloVO);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOPROCESOLOGISTICO)){			
				this.calculoArticuloGestor.registrarArticuloProcesoLogistico(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOIMPUESTO)){			
				registrarArticuloImpuesto(articuloVO, esCreacion, campoCodigoArticulo);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOMATERIAL)){			
				registrarArticuloMaterial(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.DESCUENTOVENTAARTICULO)){			
				registrarDescuentoVentaArticulo(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.REGISTROSANITARIO)){
				this.articuloRegistroSanitarioGestor.registrarDatosNutricionalesDesdeArticulo(articuloVO);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.AGRUPADOR)){
				this.articuloAgrupadorGestor.registrarAgrupadorArticulo(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULORELACIONADO)){
				registrarArticuloRelacionado(articuloVO, esCreacion, campoCodigoArticulo);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOPRECIOS)){	
				registrarArticuloPrecio(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOPRECIODIFERENCIADO)){	
				registrarArticuloPrecioDiferenciado(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.PRECIOSPORLOCAL)){
				this.registrarArticuloLocal(articuloVO, esCreacion);			
				
				if(esCreacion){					
					ClasificacionDTO clasificacionDTO = articuloVO.getBaseDTO().getClasificacionDTO();
					if(clasificacionDTO == null && articuloVO.getBaseDTO().getCodigoClienteImportacion() != null){
						clasificacionDTO = this.articuloNuevoImportadoDAO.obtenerClasificacionPorCliente(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getCodigoClienteImportacion());
					}
					if(clasificacionDTO != null && articuloVO.getBaseDTO().getCodigoClienteImportacion() != null && StringUtils.equals(clasificacionDTO.getCodigoBodega(),SICArticuloConstantes.getInstancia().CODIGO_SUBBODEGA_JUGUETES)){
						this.articuloAlcanceGestor.insertarAlcancePorPrototipo(articuloVO);
					}
				}
			}			
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOALCANCE)){
				this.registrarAlcanceArticulo(articuloVO);
			}
			
			//solo si es un articulo nuevo se toman en cuenta las siguientes relaciones
			this.calculoArticuloGestor.asignarPrototipoAlcance(articuloVO.getBaseDTO());
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.LEYENDA)){
				this.calculoArticuloLeyenda.guardarArticuloLeyenda(articuloVO);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ESTRUCTURACOMERCIALCLIENTE)){
				registrarArticuloEstructuraComercial(articuloVO, esCreacion);
			}
			
			this.validacionArticuloGestor.validarDatosArticuloCupon(articuloVO);
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.SEGMENTOCODIFICACION)){
				registrarSegmentosCodificacionArticulo(articuloVO, esCreacion);
			}
			
			if(registrarSubProceso || articuloVO.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOLOCALASIGNACION)){
				registrarArticuloLocalPedido(articuloVO);
			}
			
			this.registrarArticuloEstablecimientoOrdenCompra(articuloVO);
			
			this.calculoArticuloProveedorNovedadGestor.registrarNovedadArticuloProveedor(articuloVO);
			
			if(!SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO.equals(articuloVO.getBaseDTO().getCodigoEstado()) && articuloVO.getBaseDTO().hasDynamicProperty(ArticuloTransient.PROCESO_CREACION_MASIVA_ARTICULO)){
				if(articuloVO.getBaseDTO().getId().getCodigoCompania() == null){
					throw new SICException("Error al registrar alcance de bodegas a subbodegas.");
				}else{
					this.articuloAlcanceGestor.registrarAlcanceBodegasSubbodega(articuloVO);
				}
			}
			if(articuloVO.getBaseDTO().getTransferirDatosSIC()){
				this.calculoArticuloGestor.registrarArticuloPendienteIntegracion(articuloVO);
			}
			
			//registramos la auditoria(opcion y sistema) de la cual fue registrada el articulo
			this.registrarAuditoriaExtendida(articuloVO);
			
			this.calculoArticuloGestor.restablecerArticuloVO(articuloVO, null, registrarSubProceso, Boolean.FALSE);
			
			if(articuloVO.getDynamicProperty("esCreacion") == null)
				this.almacenamientoAuditoriaArticuloGestor.registrarLogAuditoriaArticulo(articuloVO);				
			
		}catch (SICException e) {
			//se reasigna el objeto respaldado
			this.calculoArticuloGestor.restablecerArticuloVO(articuloVO, respaldo, registrarSubProceso, Boolean.TRUE);
			throw e;
		}catch (Exception e) {
			//se reasigna el objeto respaldado
			this.calculoArticuloGestor.restablecerArticuloVO(articuloVO, respaldo, registrarSubProceso, Boolean.TRUE);
			throw new SICException(SICArticuloValidacion.getInstancia().MENSAJE_ERROR_REGISTRAR_ARTICULO,e);
		}finally{
			respaldo = null;
		}
		
		Logeable.LOG_SICV2.info("---------------------------------------------------------------------");
		Logeable.LOG_SICV2.info("----------------------- FIN REGISTRO ARTICULO -----------------------");
		Logeable.LOG_SICV2.info("---------------------------------------------------------------------");
		
		return articuloVO;
	}

	private void validacionDescripcionArticulo(ArticuloVO articuloVO) {		
		String descripcion = articuloVO.getBaseDTO().getDescripcionArticulo();
		ParametroDTO parametro = parametroGestor.obtenerParametro(articuloVO.getCodigoCompania(), SICParametros.PARAMETRO_CARACTERES_ESPECIALES_DESCRIPCION_ARTICULO, SICConstantes.getInstancia().CODIGO_SISTEMA_MAX);						
		String fil = parametro.getValorParametro().replace("\\","");
		String[] filtros = fil.split("u");		
		String filtro = "";										
		for(int i = 1; i< filtros.length; i++){
			int hexVal = Integer.parseInt(filtros[i],16);
			filtro += (char)hexVal;			
			Boolean validar = StringUtils.contains(descripcion, filtro);						
			if(validar){				
				descripcion = StringUtils.remove(descripcion, filtro);				
			}				
			filtro = "";
		}
		articuloVO.getBaseDTO().setDescripcionArticulo(descripcion);		
	}
	
	public ArticuloDTO obtenerPrecioEspecial(ArticuloDTO articuloDTO, Double precio, String codigoTipoPrecio){
		if(articuloDTO.getTieneArticuloPrecio()){
			Object precioBase = CollectionUtils.find(articuloDTO.getArticuloPrecioCol(), new BeanPredicate("id.codigoTipoPrecio",PredicateUtils.equalPredicate("BAS")));
			ArticuloPrecioDTO articuloPrecioBase = null;
			if(precioBase == null){
				throw new SICException("El articulo no tiene asignado un precio.");
			}else{
				articuloPrecioBase = (ArticuloPrecioDTO) precioBase;
			}
			articuloPrecioBase.setValorActual(precio);
			
			Object precioMayoreo = CollectionUtils.find(articuloDTO.getArticuloPrecioCol(), new BeanPredicate("id.codigoTipoPrecio",PredicateUtils.equalPredicate(codigoTipoPrecio)));
			
			if(precioMayoreo == null){
				ArticuloPrecioDTO articuloPrecioDTO = new ArticuloPrecioDTO();
				articuloPrecioDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
				articuloPrecioDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
				articuloPrecioDTO.getId().setCodigoTipoPrecio(codigoTipoPrecio);
				articuloPrecioDTO.setArticuloUnidadManejo(new ArticuloUnidadManejoDTO());
				articuloPrecioDTO.getArticuloUnidadManejo().setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
				articuloPrecioDTO.getArticuloUnidadManejo().getArticuloUnidadManejoUsoCol().add(new ArticuloUnidadManejoUsoDTO());				
				ArticuloPrecioDTO articuloPrecioMayoreoDTO = dataGestor.findUnique(articuloPrecioDTO);
				if(articuloPrecioMayoreoDTO != null){
					articuloPrecioMayoreoDTO.getArticuloUnidadManejo().setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);					
					for(ArticuloUnidadManejoUsoDTO artUniManUsoDTO:articuloPrecioMayoreoDTO.getArticuloUnidadManejo().getArticuloUnidadManejoUsoCol()){
						artUniManUsoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					}					
					articuloDTO.getArticuloPrecioCol().add(articuloPrecioMayoreoDTO);
				}
			}
		}		
		return articuloDTO;		
	}
	
	/**
	 * Metodo que me permite validar informacion mediante reglas de negocio del articulo a crear/actualizar y que me permite inactivar/crear una bitacora de codigo de barras  
	 * SubProcesoGuardadoArticulo.GENERAL
	 * @param articuloVO
	 * @param relations
	 * @param esCreacion
	 */
	protected void registrarArticuloGeneral(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando articulo");
		
		Map<String, Object> relations = null;
		try{
			//se respaldan y anulan las relaciones del articulo antes de guardar
			relations = SICUtil.getInstance().clearRelations(articuloVO.getBaseDTO());
			
			if(articuloVO.getBaseDTO().getCodigoBarrasActivo() != null){
				articuloVO.getBaseDTO().setCodigoBarras(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras());
				articuloVO.getBaseDTO().setCodigoBarrasPOS(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoBarrasPOS());
				articuloVO.getBaseDTO().setCodigoTipoCodigoArticulo(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo());
			}
			
			if(esCreacion){
				dataGestor.create(articuloVO.getBaseDTO());
			}else{
				dataGestor.update(articuloVO.getBaseDTO());
			}
			
			if(SICArticuloValidacion.VALIDACIONCODIGOBARRAS_DESACTIVARCREAR.equals(articuloVO.getEstValCodBar())){
				//se crea la nueva bitacora
				articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				dataGestor.create(articuloVO.getBaseDTO().getCodigoBarrasActivo());
				articuloVO.setEstValCodBar(null);
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error(SICArticuloValidacion.MENSAJE_ERROR_REGISTRAR_ARTICULO +e.getMessage());
			throw new SICException(SICArticuloValidacion.MENSAJE_ERROR_REGISTRAR_ARTICULO, e);
		}finally{
			//se recuperan las relaciones
			SICUtil.getInstance().restoreRelations(articuloVO.getBaseDTO(), relations);
			relations = null;
		}
		
	}
	
	/**
	 * Metodo para registrar las caracteristicas del articulo
	 * @param articuloDTO
	 * @param esCreacion
	 * @throws SICException
	 * @author eharo
	 */
	private void registrarArticuloCaracteristicas(ArticuloVO articuloVO, Boolean esCreacion) throws SICException {
		Logeable.LOG_SICV2.info("==> Registrando caracteristicas articulo esCreacion: {}", esCreacion);
		try{
			if(articuloVO != null && CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getCaracteristicaDTOSet())){
				articuloMercanciaGestor.transGuardarCaracteristicas(articuloVO.getUserId(), articuloVO.getBaseDTO().getCaracteristicaDTOSet());
			}
		}catch(Exception e){
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.caracteristicas"), e);
		}
	}
	
	public void registrarArticuloClase(ArticuloVO articuloVO) throws SICException{
		LOG_SICV2.info("==> Metodo de registro de ArticuloClase.");
		try{
			if(articuloVO != null && articuloVO.getBaseDTO() != null && SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloClaseDTO())){
				articuloVO.getBaseDTO().getArticuloClaseDTO().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				articuloVO.getBaseDTO().getArticuloClaseDTO().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				articuloVO.getBaseDTO().getArticuloClaseDTO().setClaseArticulo(articuloVO.getBaseDTO().getClaseArticulo());
				articuloVO.getBaseDTO().getArticuloClaseDTO().setUserId(articuloVO.getBaseDTO().getUserId());
				this.articuloClaseGestor.registrarArticuloClase(articuloVO.getBaseDTO().getArticuloClaseDTO());
			}
		}catch(SICException e){
			throw new SICException("Ha ocurrido un error al registrar ArticuloClase", e);
		}
	}
	
	public void registrarEstadoArticuloLeyMercado(ArticuloVO articuloVO, Boolean esCreacion) throws SICException{
		LOG_SICV2.info("==> Metodo de registro de EstadoArticuloLeyMercado.");
		try{
			if(BooleanUtils.isFalse(esCreacion) && articuloVO != null && articuloVO.getBaseDTO() != null 
					&& (StringUtils.equals(articuloVO.getBaseDTO().getClaseArticulo(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O))){
				this.articuloLeyMercadoGestor.descodificarArticuloLeyMercado(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId(), articuloVO.getBaseDTO().getArticuloClaseDTO().getCodigoTipoCausal(), articuloVO.getBaseDTO().getArticuloClaseDTO().getValorTipoCausal());				
			}
			
			if(BooleanUtils.isFalse(esCreacion) && articuloVO != null && articuloVO.getBaseDTO() != null 
					&& (StringUtils.equals(articuloVO.getBaseDTO().getEstadoArticulo(), SICConstantes.ESTADO_INACTIVO_NUMERICO))){
				this.articuloLeyMercadoGestor.descodificarArticuloLeyMercado(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId(), 314, "INA");				
			}
			
			//Esto e debe implemetar cuando se den de baja a productos
			if(BooleanUtils.isFalse(esCreacion) && articuloVO != null && articuloVO.getBaseDTO() != null && StringUtils.equals(articuloVO.getBaseDTO().getArticuloClaseDTO().getClaseArticuloAnterior(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O)
					&& !StringUtils.equals(articuloVO.getBaseDTO().getClaseArticulo(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O) && StringUtils.equals(articuloVO.getBaseDTO().getEstadoArticulo(), SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				this.articuloLeyMercadoGestor.reactivarArticuloLeyMercado(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId());
			}
			
			//Esto e debe implemetar cuando se den de baja a productos
			String estadoArticuloAnterior = (String) articuloVO.getDynamicProperty("estadoArticuloAnterior");
			if(BooleanUtils.isFalse(esCreacion) && articuloVO != null && articuloVO.getBaseDTO() != null && !StringUtils.equals(articuloVO.getBaseDTO().getClaseArticulo(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O) 
					&& StringUtils.equals(articuloVO.getBaseDTO().getEstadoArticulo(), SICConstantes.ESTADO_ACTIVO_NUMERICO) && StringUtils.equals(estadoArticuloAnterior, SICConstantes.ESTADO_INACTIVO_NUMERICO)){
				this.articuloLeyMercadoGestor.reactivarArticuloLeyMercado(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId());
			}
		}catch(SICException e){
			throw new SICException("Ha ocurrido un error al registrar EstadoArticuloLeyMercado", e);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOTEMPORADA
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarArticuloTemporada(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando clase articulo temporada");
		try{
			if(articuloVO.getBaseDTO().getClaseArticulo() != null && articuloVO.getBaseDTO().getClaseArticulo().equals(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada"))
					 && articuloVO.getBaseDTO().getTieneArticuloTemporada()){
				articuloVO.getBaseDTO().getArticuloTemporadaDTO().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				articuloVO.getBaseDTO().getArticuloTemporadaDTO().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				articuloVO.getBaseDTO().getArticuloTemporadaDTO().setUserId(articuloVO.getBaseDTO().getUserId());
				if(esCreacion){
					dataGestor.create(articuloVO.getBaseDTO().getArticuloTemporadaDTO());
				}else{
					dataGestor.createOrUpdate(articuloVO.getBaseDTO().getArticuloTemporadaDTO());}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.temporada"),e);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOGARANTIA
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarArticuloGarantia(ArticuloVO articuloVO, Boolean esCreacion) throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando articulo garantia");
		try{
			if(articuloVO.getBaseDTO().getTieneArticuloGarantia()){
				articuloVO.getBaseDTO().getArticuloGarantiaDTO().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				articuloVO.getBaseDTO().getArticuloGarantiaDTO().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				articuloVO.getBaseDTO().getArticuloGarantiaDTO().setUserId(articuloVO.getBaseDTO().getUserId());
				calculoArticuloGestor.asignarCamposArticuloGarantia(articuloVO.getBaseDTO().getArticuloGarantiaDTO());
				if(esCreacion){
					dataGestor.create(articuloVO.getBaseDTO().getArticuloGarantiaDTO());
				}else{
					dataGestor.createOrUpdate(articuloVO.getBaseDTO().getArticuloGarantiaDTO());}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.garantia"),e);
		}
	}
	
	
	private void registrarArticuloInformacionAdicional(ArticuloVO articuloVO, Boolean esCreacion) throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando ArticuloInformacionAdicional");
		try{
			if(articuloVO.getBaseDTO().getTieneArticuloInformacionAdicional()){
				articuloVO.getBaseDTO().getArticuloInformacionAdicionalDTO().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				articuloVO.getBaseDTO().getArticuloInformacionAdicionalDTO().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				articuloVO.getBaseDTO().getArticuloInformacionAdicionalDTO().setUserId(articuloVO.getBaseDTO().getUserId());
				if(esCreacion){
					dataGestor.create(articuloVO.getBaseDTO().getArticuloInformacionAdicionalDTO());
				}else{
					dataGestor.createOrUpdate(articuloVO.getBaseDTO().getArticuloInformacionAdicionalDTO());}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.adicional"), e);
		}
	}
	
	
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOINTERNET
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarArticuloInternet(ArticuloVO articuloVO,Boolean esCreacion){
		
		Logeable.LOG_SICV2.info("==> Registrando articulo internet");
		if(articuloVO.getBaseDTO().getTieneArticuloInternet()){
			articuloVO.getBaseDTO().getArticuloInternetDTO().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			articuloVO.getBaseDTO().getArticuloInternetDTO().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			articuloVO.getBaseDTO().getArticuloInternetDTO().setUserId(articuloVO.getBaseDTO().getUserId());
			calculoArticuloGestor.asignarCamposArticuloInternet(articuloVO.getBaseDTO().getArticuloInternetDTO());
			if(esCreacion){
				dataGestor.create(articuloVO.getBaseDTO().getArticuloInternetDTO());
			}else{
				dataGestor.createOrUpdate(articuloVO.getBaseDTO().getArticuloInternetDTO());}
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOMEDIDA
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarArticuloMedida(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Articulo medida");
		try{
			if(articuloVO.getBaseDTO().getTieneArticuloMedida()){
				articuloVO.getBaseDTO().getArticuloMedidaDTO().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				articuloVO.getBaseDTO().getArticuloMedidaDTO().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				articuloVO.getBaseDTO().getArticuloMedidaDTO().setUserId(articuloVO.getBaseDTO().getUserId());
				calculoArticuloGestor.asignarCamposArticuloMedida(articuloVO.getBaseDTO().getArticuloMedidaDTO());
				if(esCreacion){
					dataGestor.create(articuloVO.getBaseDTO().getArticuloMedidaDTO());
				}else{
					dataGestor.createOrUpdate(articuloVO.getBaseDTO().getArticuloMedidaDTO());}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.medida"),e);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULODEFINICIONARCHIVO
	 * @param articuloVO
	 */
	private void registrarArticuloDefinicionArchivo(ArticuloVO articuloVO)throws SICException{
		Logeable.LOG_SICV2.info("==> Registrando Articulo Definicion Archivo");
		if(articuloVO.getBaseDTO().getTieneArticuloDefinicionArchivo()){
			//Cambio de nombre de la imagen a .png para envio por FTP
			if(articuloVO.getBaseDTO().getCodigoTipoArticulo().equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON)){
				if(articuloVO.getBaseDTO().getArticuloDefinicionArchivoCol()!=null && !articuloVO.getBaseDTO().getArticuloDefinicionArchivoCol().isEmpty()){
					for(ArticuloDefinicionArchivoDTO archivoDto : articuloVO.getBaseDTO().getArticuloDefinicionArchivoCol()){
						String nombreImagenFinal=archivoDto.getNombreArchivo();
						String[] nombreImagen = nombreImagenFinal.split("\\.");
						nombreImagenFinal = nombreImagen[0]+"."+"png"; 
						archivoDto.setNombreArchivo(nombreImagenFinal);
					}
				}
			}
			for(ArticuloDefinicionArchivoDTO dto : articuloVO.getBaseDTO().getArticuloDefinicionArchivoCol()){
				//solamente se guardan los archivos que tienen que ver directamente con el articulo
				if(!SICArticuloValidacion.getInstancia().esArchivoRegistroSanitario(dto.getValorTipoArchivo())){
					dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					dto.setUserId(articuloVO.getBaseDTO().getUserId());
					dto.setCodigoRegistroSanitarioArticulo(null);
					this.registrarArticuloArchivo(dto);
				}
			}
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOETIQUETA
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarArticuloEtiqueta(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		Logeable.LOG_SICV2.info("==> Registrando Articulo etiqueta");
		try{
			if(articuloVO.getBaseDTO().getTieneArticuloEtiqueta()){
				for(ArticuloEtiquetaDTO articuloEtiquetaDTO : articuloVO.getBaseDTO().getArticuloEtiquetaCol()){
					articuloEtiquetaDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					articuloEtiquetaDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					articuloEtiquetaDTO.setUserId(articuloVO.getBaseDTO().getUserId());
					if(esCreacion){
						articuloEtiquetaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(articuloEtiquetaDTO);
					}else{
						dataGestor.createOrUpdate(articuloEtiquetaDTO);}
				}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.etiqueta"),e);
		}
	}
	
	/**
	 * Metodo  que registr4a el articuloMercancia por articulo
	 * @author aquingaluisa
	 * @param articuloVO
	 * @param esCreacion
	 * @throws SICException
	 */
	@Override
	public void registrarArticuloEtiquetaMercancia(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		Logeable.LOG_SICV2.info("==> Registrando Etiqueta Mercancia");
		try{
			if(articuloVO.getBaseDTO().getTieneArticuloEtiquetaMercnacia()){
				for(ArticuloEtiquetaMercanciaDTO articuloEtiquetaMercanciaDTO : articuloVO.getBaseDTO().getArticuloEtiquetaMercanciaCol()){
					//caso de que el objeto este nulo, ya que el nombre es obligatorio y deberia tenear al guardar
					if(articuloEtiquetaMercanciaDTO.getNombreProducto() != null){												
												
						articuloEtiquetaMercanciaDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());						
						articuloEtiquetaMercanciaDTO.setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
						articuloEtiquetaMercanciaDTO.setUserId(articuloVO.getBaseDTO().getUserId());
						
						//convierte campos a MAYUSCULAS
						camposMayuscula(articuloEtiquetaMercanciaDTO);
						//Valido si articuloEtiquetaMercancia es para crear o actualizar
						esCreacion = articuloEtiquetaMercanciaDTO.getId().getCodigoArticuloEtiquetaMercancia() == null ? Boolean.TRUE : Boolean.FALSE;
						
						if(esCreacion){
							//TODO: 1. Obtener secuencial para articuloetiquetamercanciaCatalogo
							// 2. Setear el secuencial en el Id de articuloEtiquetaMercanciaDTO
							//3. crear objeto del tipo ArticuloEtiquetaMercanciaCatalogo
							//4.	
							
							//Obtiene el secuencia de articulos etiquetado mercancia
							Long secuencia = dataGestor.findNextSequenceValue(SICConstantes.ESQUEMABD, "SCSADSARTETIMER", null);
							articuloEtiquetaMercanciaDTO.getId().setCodigoArticuloEtiquetaMercancia(secuencia);							
							
							articuloEtiquetaMercanciaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							dataGestor.create(articuloEtiquetaMercanciaDTO);
							
							for(ArticuloEtiquetaMercanciaCatalogoDTO articuloEtiquetaMercanciaCatalogoDTO : articuloEtiquetaMercanciaDTO.getArticuloEtiquetaMercanciaCatalogoCol()){								
								articuloEtiquetaMercanciaCatalogoDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
								articuloEtiquetaMercanciaCatalogoDTO.setCodigoArticuloEtiquetaMercancia(secuencia);								
								articuloEtiquetaMercanciaCatalogoDTO.setUsuarioRegistro(articuloVO.getBaseDTO().getUserId());
								articuloEtiquetaMercanciaCatalogoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								dataGestor.create(articuloEtiquetaMercanciaCatalogoDTO);
							}
							
						}else{
							articuloEtiquetaMercanciaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							dataGestor.createOrUpdate(articuloEtiquetaMercanciaDTO);
							for(ArticuloEtiquetaMercanciaCatalogoDTO articuloEtiquetaMercanciaCatalogoDTO : articuloEtiquetaMercanciaDTO.getArticuloEtiquetaMercanciaCatalogoCol()){
								articuloEtiquetaMercanciaCatalogoDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
								articuloEtiquetaMercanciaCatalogoDTO.setUsuarioActualizacion(articuloVO.getBaseDTO().getUserId());
								dataGestor.createOrUpdate(articuloEtiquetaMercanciaCatalogoDTO);
							}
						}
					}
				}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.etiqueta"),e);
		}
	}
	
	/**
	 * Metodo para poner los campos etiquetas en Mayusculas
	 * @author dbravo
	 */
	public void camposMayuscula(ArticuloEtiquetaMercanciaDTO articuloEtiquetaMercanciaDTO){
		
		// nombre producto
		if(articuloEtiquetaMercanciaDTO.getNombreProducto() != null){
			articuloEtiquetaMercanciaDTO.setNombreProducto(articuloEtiquetaMercanciaDTO.getNombreProducto().toUpperCase());
		}
		
		// marca comercial
		if(articuloEtiquetaMercanciaDTO.getMarcaComercial() != null){
			articuloEtiquetaMercanciaDTO.setMarcaComercial(articuloEtiquetaMercanciaDTO.getMarcaComercial().toUpperCase());
		}
		
		// lote
		if(articuloEtiquetaMercanciaDTO.getLote() != null){
			articuloEtiquetaMercanciaDTO.setLote(articuloEtiquetaMercanciaDTO.getLote().toUpperCase());
		}
		
		//modelo		
		if(articuloEtiquetaMercanciaDTO.getModelo() != null){
			articuloEtiquetaMercanciaDTO.setModelo(articuloEtiquetaMercanciaDTO.getModelo().toUpperCase());
		}
		
		//razon social fabricante		
		if(articuloEtiquetaMercanciaDTO.getRazonSocialFabricante() != null){
			articuloEtiquetaMercanciaDTO.setRazonSocialFabricante(articuloEtiquetaMercanciaDTO.getRazonSocialFabricante().toUpperCase());
		}
		
		//direccion Fabricante
		if(articuloEtiquetaMercanciaDTO.getDireccionFabricante() != null){
			articuloEtiquetaMercanciaDTO.setDireccionFabricante(articuloEtiquetaMercanciaDTO.getDireccionFabricante().toUpperCase());
		}
		
		//Razon social Importador
		if(articuloEtiquetaMercanciaDTO.getRazonSocialImportador() != null){
			articuloEtiquetaMercanciaDTO.setRazonSocialImportador(articuloEtiquetaMercanciaDTO.getRazonSocialImportador().toUpperCase());
		}
		
		//Direccion importador
		if(articuloEtiquetaMercanciaDTO.getDireccionImportador() != null){
			articuloEtiquetaMercanciaDTO.setDireccionImportador(articuloEtiquetaMercanciaDTO.getDireccionImportador().toUpperCase());
		}
		
		//lista componentes		
		if(articuloEtiquetaMercanciaDTO.getListaComponentes() != null){
			articuloEtiquetaMercanciaDTO.setListaComponentes(articuloEtiquetaMercanciaDTO.getListaComponentes().toUpperCase());
		}
		
		//condiciones conservacion
		if(articuloEtiquetaMercanciaDTO.getCondicionesConservacion() != null){
			articuloEtiquetaMercanciaDTO.setCondicionesConservacion(articuloEtiquetaMercanciaDTO.getCondicionesConservacion().toUpperCase());
		}
		
		//Norma tecnica
		if(articuloEtiquetaMercanciaDTO.getNormaTecnicaReferencia() != null){
			articuloEtiquetaMercanciaDTO.setNormaTecnicaReferencia(articuloEtiquetaMercanciaDTO.getNormaTecnicaReferencia().toUpperCase());
		}
		
		//Advertencias
		if(articuloEtiquetaMercanciaDTO.getAdvertencia() != null){
			articuloEtiquetaMercanciaDTO.setAdvertencia(articuloEtiquetaMercanciaDTO.getAdvertencia().toUpperCase());
		}
		
		//Traduccion
		if(articuloEtiquetaMercanciaDTO.getTraduccion() != null){
			articuloEtiquetaMercanciaDTO.setTraduccion(articuloEtiquetaMercanciaDTO.getTraduccion().toUpperCase());
		}
	}
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULODURACIONCONSERVACION
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarArticuloDuracionConservacion(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Articulo Duracion Conservacion");
		try{
			if(articuloVO.getBaseDTO().getTieneArticuloDuracionConservacion()){
				for(ArticuloDuracionConservacionDTO dto : articuloVO.getBaseDTO().getArticuloDuracionConservacionCol()){
					dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					dto.setUserId(articuloVO.getBaseDTO().getUserId());
					calculoArticuloGestor.asignarCamposArticuloDuracionConservacion(dto);
					if(esCreacion){
						dto.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(dto);
					}else{
						dataGestor.createOrUpdate(dto);}
				}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.conservacion"),e);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOUSO
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarArticuloUso(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando usos de articulo");
		try{
			if(articuloVO.getBaseDTO().getTieneArticuloUso()){
				for(ArticuloUsoDTO articuloUsoDTO : articuloVO.getBaseDTO().getArticuloUsoCol()){
					articuloUsoDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					articuloUsoDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					articuloUsoDTO.setUserId(articuloVO.getBaseDTO().getUserId());
					if(esCreacion){
						articuloUsoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(articuloUsoDTO);
					}else{
						dataGestor.createOrUpdate(articuloUsoDTO);}
				}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.uso"),e);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOPROVEEDOR
	 * @param articuloVO
	 * @param esCreacion
	 */
	@Override
	public void registrarArticuloProveedor(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Articulo Proveedor");
		
		if(articuloVO.getBaseDTO().getTieneArticuloProveedor()){
			articuloProveedorGestor.registrarArticuloProveedorDesdeArticulo(articuloVO, esCreacion);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOIMPUESTO
	 * @param articuloVO
	 * @param esCreacion
	 * @param campoCodigoArticulo
	 */
	private void registrarArticuloImpuesto(ArticuloVO articuloVO,Boolean esCreacion,String campoCodigoArticulo)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Articulo Impuesto");
		Map<String, Object> relations = null;
		ArticuloImpuestoDTO aiActual = null;
		try{
			if(articuloVO.getBaseDTO().getArticuloImpuestoCol() != null && !SearchDTO.isLazy(articuloVO.getBaseDTO().getArticuloImpuestoCol())){
				if(!esCreacion){
					articuloDAO.actualizarEstadoRelacion(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), campoCodigoArticulo,
							SICConstantes.ESTADO_INACTIVO_NUMERICO, "estadoArticuloImpuesto", ArticuloImpuestoDTO.class);}
				for(ArticuloImpuestoDTO dto : articuloVO.getBaseDTO().getArticuloImpuestoCol()){
					dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					dto.setUserId(articuloVO.getBaseDTO().getUserId());
					aiActual = dto;
					relations = SICUtil.getInstance().clearRelations(dto);
					if(esCreacion){
						dto.setEstadoArticuloImpuesto(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(dto);
					}else{
						dataGestor.createOrUpdate(dto);}
					SICUtil.getInstance().restoreRelations(dto, relations);
					relations = null;
				}
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.impuesto"),e);
		}finally{
			SICUtil.getInstance().restoreRelations(aiActual, relations);
			relations = null;
			aiActual = null;
		}
		
	}	
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOMATERIAL
	 * @param articuloVO
	 * @param esCreacion
	 */
	@Override
	public void registrarArticuloMaterial(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Articulo Material");
		try{
			if(articuloVO.getBaseDTO().getTieneArticuloMaterial()){
				for(ArticuloMaterialDTO dto : articuloVO.getBaseDTO().getArticuloMaterialDTOs()){
					dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					dto.setUserId(articuloVO.getBaseDTO().getUserId());
					calculoArticuloGestor.asignarCamposArticuloMaterial(dto);
					if(esCreacion){
						dataGestor.create(dto);
					}else{
						dataGestor.createOrUpdate(dto);}
				}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.material"),e);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.DESCUENTOVENTAARTICULO
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarDescuentoVentaArticulo(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		Logeable.LOG_SICV2.info("==> Registrando Descuento Venta Articulo");
		try{
			if(articuloVO.getBaseDTO().getTieneDescuentoVentaArticulo()){
				for(DescuentoVentaArticuloDTO dto : articuloVO.getBaseDTO().getDescuentoVentaArticuloCol()){
					dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					dto.setUserId(articuloVO.getBaseDTO().getUserId());
					if(dto.getPorcentajeDescuento() == null){
						dto.setPorcentajeDescuento(0D);
					}
					
					if(esCreacion){
						dto.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(dto);
					}else{
						dataGestor.createOrUpdate(dto);}
				}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.descuento"),e);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULORELACIONADO
	 * @param articuloVO
	 * @param esCreacion
	 * @param campoCodigoArticulo
	 */
	private void registrarArticuloRelacionado(ArticuloVO articuloVO,Boolean esCreacion,String campoCodigoArticulo)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Articulo Relacionado");
		try{
			if(articuloVO.getBaseDTO().getArticuloRelacionCol() != null && !SearchDTO.isLazy(articuloVO.getBaseDTO().getArticuloRelacionCol())){
				if(!esCreacion){
					articuloDAO.actualizarEstadoRelacion(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), campoCodigoArticulo,
							SICConstantes.ESTADO_INACTIVO_NUMERICO, "estado", ArticuloRelacionDTO.class);}
				for(ArticuloRelacionDTO dto : articuloVO.getBaseDTO().getArticuloRelacionCol()){
					dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());					
					dto.setUserId(articuloVO.getBaseDTO().getUserId());
					if(esCreacion){
						dto.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(dto);
					}else{
						dataGestor.createOrUpdate(dto);
					}					
				} 
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.relacionado"),e);
		}
	}
	
	/**
	 * Permite eliminar un objeto ArticuloPrecioDTO de la coleccion
	 * @param articuloDTO ArticuloDTO
	 * @param noValidos Coleccion que almacena los ArticuloPrecio no validos
	 */
	@SuppressWarnings("unchecked")
	private void validarArticuloLocalPrecio(ArticuloDTO articuloDTO, Collection<ArticuloPrecioDTO> noValidos){
		if(CollectionUtils.isNotEmpty(articuloDTO.getArticuloPrecioCol())){
			if(articuloDTO.getDynamicProperty("verificaProcesoMayoreo") != null && 
					(Boolean)articuloDTO.getDynamicProperty("verificaProcesoMayoreo")){
				ArticuloPrecioDTO articuloPrecioDTO = (ArticuloPrecioDTO)CollectionUtils.find(articuloDTO.getArticuloPrecioCol(), 
						new BeanPredicate("id.codigoTipoPrecio", PredicateUtils.equalPredicate(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA)));
				noValidos.add(articuloPrecioDTO);
				
				articuloDTO.setArticuloPrecioCol(CollectionUtils.select(articuloDTO.getArticuloPrecioCol(), 
						new BeanPredicate("id.codigoTipoPrecio", PredicateUtils.notPredicate(new InPredicate<String>( Arrays.asList(
								new String[]{SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA}))))));
			}
		}					
	}
	
	/**
	 * 
	 * @param articuloVO
	 * @param esCreacion
	 * @throws SICException
	 */
	private void registrarArticuloPrecio(ArticuloVO articuloVO, Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando articulo precios");
		ArticuloPrecioDTO apActual = null;
		Map<String, Object> relations = null;
		try{
			ArticuloDTO articuloDTO = articuloVO.getBaseDTO();
			boolean esProcesoCodificacion =  articuloDTO.getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) != null ;
			boolean margenFijado = esProcesoCodificacion && BooleanUtils.isTrue((Boolean)articuloDTO.getDynamicProperty(SICArticuloConstantes.MARGENFIJADO));
			
			if(articuloDTO.getTieneArticuloPrecio()){
				Collection<ArticuloPrecioDTO> noValidos = new ArrayList<ArticuloPrecioDTO>();			
				if(esProcesoCodificacion ){
					this.cambiarPrecioArticuloPreCodificadoImportado(articuloDTO);
				}
				this.validarArticuloLocalPrecio(articuloDTO, noValidos);
				for(ArticuloPrecioDTO ap : articuloDTO.getArticuloPrecioCol()){
					
					if(StringUtils.isNotEmpty(ap.getId().getCodigoTipoPrecio())){
						Double margenPrecio = null;
						if(!margenFijado){
							margenPrecio = ap.getMargenPrecio();
							ap.setMargenPrecio(null);
						}
						ap.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
						ap.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
						ap.setUserId(articuloDTO.getUserId());
						apActual = ap;
						relations = SICUtil.getInstance().clearRelations(ap);
						if(esCreacion){
							ap.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							dataGestor.create(ap);
						}else{
							dataGestor.createOrUpdate(ap);}
						SICUtil.getInstance().restoreRelations(ap, relations);
						relations = null;
						
						if(margenPrecio != null){
							dataGestor.detach(ap);
							ap.setMargenPrecio(margenPrecio);
						}
					}else{
						noValidos.add(ap);
					}
				}
				articuloDTO.getArticuloPrecioCol().removeAll(noValidos);
				noValidos = null;
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.precio"),e);
		}finally{
			SICUtil.getInstance().restoreRelations(apActual, relations);
		}
	}
	/**
	 * 
	 * @param articuloVO
	 * @param esCreacion
	 * @throws SICException
	 */
	private void registrarArticuloPrecioDiferenciado(ArticuloVO articuloVO, Boolean esCreacion)throws SICException{
		Logeable.LOG_SICV2.info("==> Registrando articulo precio diferenciado");
		try{
			Collection<ArticuloPrecioDiferenciadoDTO> articuloPrecioDiferenciadoDTOCol = (Collection<ArticuloPrecioDiferenciadoDTO>)articuloVO.getDynamicProperty("articuloPrecioDiferenciadoDTOCol");
			ArticuloGestionPrecioDTO articuloGestionPrecioConflictos = (ArticuloGestionPrecioDTO) articuloVO.getDynamicProperty("articuloGestionPrecioConflictos");
			this.articuloPrecioDiferenciadoGestor.registrarCollArticuloPrecioDiferenciado(articuloPrecioDiferenciadoDTOCol, articuloGestionPrecioConflictos);			
		}catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException("Error al registrar el precio diferenciado.");
		}
	}
	
	/**
	 * 
	 * @param articuloDTO
	 */
	@SuppressWarnings("unchecked")
	private void cambiarPrecioArticuloPreCodificadoImportado(ArticuloDTO articuloDTO){
		String origenProveedor = this.calculoArticuloGestor.obtenerOrigenArticulo(articuloDTO);
		final Boolean esImportado = ProveedorConstantes.getInstancia().PROVEEDOR_IMPORTADO.equals(origenProveedor);
		final Boolean noTienePrecio = articuloDTO.hasDynamicProperty(ArticuloTransient.PRECIO_ARTICULO_PROVEEDOR_IMPORTADO) && BooleanUtils.isFalse((Boolean)articuloDTO.getDynamicProperty(ArticuloTransient.PRECIO_ARTICULO_PROVEEDOR_IMPORTADO));
		if(esImportado && noTienePrecio){
			
			final Predicate predicateIn = new BeanPredicate("id.codigoTipoPrecio", new InPredicate<String>( Arrays.asList(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE, SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP)));
			final Collection<ArticuloPrecioDTO> precios = CollectionUtils.select(articuloDTO.getArticuloPrecioCol(), predicateIn);
			
			if( CollectionUtils.isNotEmpty(precios) ){
				for( final ArticuloPrecioDTO articuloPrecioDTO : precios ){
					if(StringUtils.equals(articuloPrecioDTO.getId().getCodigoTipoPrecio(),  SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)){
						articuloPrecioDTO.setValorActual(SICArticuloConstantes.getInstancia().VALOR_PREDETERMINADO_PRECIO);
					}
					if(StringUtils.equals(articuloPrecioDTO.getId().getCodigoTipoPrecio(),  SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP)){
						articuloPrecioDTO.setValorActual(SICArticuloConstantes.getInstancia().VALOR_PREDETERMINADO_PRECIO_PVP);
					}
				}
			}
			
		}
	}
	
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.PRECIOSPORLOCAL
	 * @param articuloVO
	 * @param esCreacion
	 */
	private void registrarArticuloLocal(ArticuloVO articuloVO, Boolean esCreacion)throws SICException{
		try{
			Map<String, Object> relations = null;
			Logeable.LOG_SICV2.info("==> Registrando datos por local");
			ArticuloDTO articuloDTO = articuloVO.getBaseDTO();
			//se consultan los precios del articulo
			ArticuloPrecioDTO filtroAP = new ArticuloPrecioDTO();
			filtroAP.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			filtroAP.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			filtroAP.setArticuloUnidadManejo(new ArticuloUnidadManejoDTO());
			Collection<ArticuloPrecioDTO> precios = dataGestor.findObjects(filtroAP);
			if(!articuloVO.getBaseDTO().getTieneArticuloPrecio()){
				articuloVO.getBaseDTO().setArticuloPrecioCol(precios);
			}
			
			if(articuloDTO.getTieneArticuloLocal()){
				
				this.articuloAlcanceGestor.asignarArticuloAlcanceAreasTrabajo(articuloVO);
				
				for(ArticuloLocalDTO dto : articuloDTO.getArticuloLocalCol()){
					
					//if( dto.getTieneArticuloLocalPrecioCol() && dto.getCodigoArticuloLocal() != null){
					if( dto.getTieneArticuloLocalPrecioCol()){
						if(!esCreacion){
							//antes se desactivan todos los precios del articulo por local
							articuloLocalPrecioDAO.actualizarEstadoPorArticuloLocal(dto.getId().getCodigoCompania(), dto.getId().getCodigoLocal(), dto.getId().getCodigoArticulo(), 
								SICConstantes.ESTADO_INACTIVO_NUMERICO);
						}
						if(CollectionUtils.isNotEmpty(dto.getArticuloLocalPrecioCol())){
							for(ArticuloLocalPrecioDTO alp : dto.getArticuloLocalPrecioCol()){
								if(StringUtils.isNotEmpty(alp.getId().getCodigoTipoPrecio()) && 
										!alp.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP)){ //&&
										//!alp.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)){
									
									alp.getId().setCodigoCompania(dto.getId().getCodigoCompania());
									alp.getId().setCodigoArticulo(dto.getId().getCodigoArticulo());
									alp.getId().setCodigoLocal(dto.getId().getCodigoLocal());
									alp.setUserId(articuloDTO.getUserId());
									if(StringUtils.isEmpty(alp.getEstadoPrecio())){
										alp.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									}
									
									/*if( alp.getFechaInicioVigencia() == null ){
										alp.setFechaInicioVigencia(DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH));
									}*/
									
									//se verifica si el precio padre existe en la base									
									ArticuloPrecioDTO ap = (ArticuloPrecioDTO)CollectionUtils.find(precios, new BeanPredicate("id.codigoTipoPrecio", PredicateUtils.equalPredicate(alp.getId().getCodigoTipoPrecio()))  );
									if(ap == null){
										ap = new ArticuloPrecioDTO();
										ap.getId().setCodigoCompania(dto.getId().getCodigoCompania());
										ap.getId().setCodigoArticulo(dto.getId().getCodigoArticulo());
										ap.getId().setCodigoTipoPrecio(alp.getId().getCodigoTipoPrecio());
										ap.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										ap.setUserId(articuloDTO.getUserId());
										if(alp.getTieneArticuloPrecio()){
											ap.setCodigoUnidadManejo(alp.getArticuloPrecio().getCodigoUnidadManejo());
										}
										relations = SICUtil.getInstance().clearRelations(ap);
										dataGestor.create(ap);
										SICUtil.getInstance().restoreRelations(ap, relations);
										precios.add(ap);
									}
									relations = SICUtil.getInstance().clearRelations(alp);
									try{
										if(esCreacion){
											dataGestor.create(alp);
										}else{
											dataGestor.createOrUpdate(alp);
										}
									}catch(Exception e){
										throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.local"),e);
									}finally{
										SICUtil.getInstance().restoreRelations(alp, relations);
										relations = null;
									}
								}
							}
						}
					}
				}
			}
			if(esCreacion){
				if(articuloVO.getBaseDTO().hasDynamicProperty(ArticuloTransient.PROCESO_CREACION_MASIVA_ARTICULO)){
					//validamos si el codigogrupoalcance no es nulo, entonces llamamos al metodo que asigna alcances
					if(articuloVO.getBaseDTO().getCodigoGrupoAlcance() != null){
						this.articuloAlcanceGestor.insertarAlcancesCambioPrototipo(articuloVO);	
					}
				}else{
					articuloAlcanceGestor.insertarArticulosMasivoEstablecimientos(articuloVO);
				}
			}else{				
				articuloAlcanceGestor.activarDesactivarArticulosMasivoEstablecimientos(articuloVO);
				articuloAlcanceGestor.insertarArticulosMasivoEstablecimientos(articuloVO);
			}
			
//			registrarArticuloEstablecimiento(articuloDTO);
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.local"),e);
		}
	}
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.SEGMENTOCODIFICACION
	 * @param articuloDTO
	 * @param esCreacion
	 */
	private int registrarSegmentosCodificacionArticulo(ArticuloVO articuloVO, Boolean esCreacion)throws SICException{
		Logeable.LOG_SICV2.info("==> Registrando segmento de creacion");
		int registrosAfectados = 0;
		try{
			ArticuloDTO articuloDTO = articuloVO.getBaseDTO();
			if(articuloDTO.getTieneSegmentoCreacionArticulo()){
				if(articuloDTO.getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO)){
					registrosAfectados = articuloDAO.completarCodificacionArticulo(articuloDTO);
				}else{
					for(SegmentoCreacionArticuloDTO sca : articuloDTO.getSegmentoCreacionArticulos()){
						sca.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
						sca.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
						sca.setUserId(articuloDTO.getUserId());
						if(!StringUtils.isEmpty(sca.getId().getValorPasoCreacion())){
							sca.getId().setCodigoPasoCreacion(SICArticuloConstantes.getInstancia().CODIGOCATALOGOPASOSCREACIONARTICULO);
						}
						if(StringUtils.isEmpty(sca.getEstadoSegmento())){
							sca.setEstadoSegmento(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						}
						//se verifica si cada paso esta completo
						validacionArticuloGestor.validarPasoCreacion(sca, articuloVO);
						if(esCreacion){
							dataGestor.create(sca);
						}else{
							dataGestor.createOrUpdate(sca);
						}
					}
				}
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.segcreart"),e);
		}
		return registrosAfectados;
	}
	
	/**
	 * 
	 */
	private void registrarArticuloEstructuraComercial(ArticuloVO articuloVO, Boolean esCreacion)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Articulo estructura comercial");
		try{
			if(articuloVO.getBaseDTO().getEstructuraComercialClienteCol() != null && !SearchDTO.isLazy(articuloVO.getBaseDTO().getEstructuraComercialClienteCol())){
				if(!esCreacion){
					articuloDAO.actualizarEstadoRelacion(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), "id.codigoArticulo",
							SICConstantes.ESTADO_INACTIVO_NUMERICO, "estado", ArticuloEstructuraComercialDTO.class);}
				for(ArticuloEstructuraComercialDTO dto : articuloVO.getBaseDTO().getEstructuraComercialClienteCol()){
					dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());					
					dto.setUserId(articuloVO.getBaseDTO().getUserId());
					if(esCreacion){
						dto.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(dto);
					}else{
						dataGestor.createOrUpdate(dto);
					}					
				} 
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.estcom"),e);
		}
	}
	
	/**
	 * 
	 */
	public void registrarArticuloMasivo(Collection<ArticuloDTO> articuloDTOs, Set<EnumSubProcesoGuardadoArticulo> enumSubProcesoGuardadoArticulo) throws SICException{
		Collection<ArticuloVO> articuloDTOCol = new ArrayList<ArticuloVO>();
		for(ArticuloDTO articuloDTO : articuloDTOs){
			ArticuloVO articuloVO = new ArticuloVO();
			articuloDTO.setTransferirDatosSIC(Boolean.FALSE); //para que NO se envie articulo por articulo
			articuloVO.setBaseDTO(articuloDTO);
			articuloVO.setSubProcesoGuardadoArticulo(enumSubProcesoGuardadoArticulo);
			registrarArticulo(articuloVO);
			articuloDTOCol.add(articuloVO);
			LOG_SICV2.info("Se registro: "+articuloVO.getBaseDTO().getId().getCodigoArticulo());
		}	
		//se envia el total
		accionArticuloGestor.transferirDatosArticuloSIC(articuloDTOCol, Boolean.FALSE, null);
	}

	/**
	 * 
	 * @param articulos
	 */
	public ArticuloVO registrarArticuloPrecioMasivo(Collection<ArticuloDTO> articulos) {
		ArticuloVO resultado = new ArticuloVO();
		Map<String, Object> relations = null;
		for (ArticuloDTO dto : articulos) {
			try {
				calculoArticuloGestor.asignarPrototipoAlcance(dto);
				ArticuloVO av = new ArticuloVO();
				av.setBaseDTO(dto);
				this.registrarArticuloLocal(av, Boolean.FALSE);
				// se respaldan y anulan las relaciones del articulo antes de
				// guardar
				relations = SICUtil.getInstance().clearRelations(dto);
				dataGestor.update(dto);
			} catch (Exception e) {
				resultado.addError(dto.getCodigoBarrasActivo().getId().getCodigoBarras() + ": " + e.getMessage());
			} finally {
				SICUtil.getInstance().restoreRelations(dto, relations);
			}
		}
		return resultado;
	}
	
	/**
	 * 
	 * @param articuloDefinicionArchivoDTO
	 * @throws SICRuleException
	 */
	public void registrarArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICException{
		articuloArchivoGestor.registrarArticuloArchivo(articuloDefinicionArchivoDTO);
	}
	
	/**
	 * 
	 * @param articuloDefinicionArchivoDTO
	 * @throws SICRuleException
	 */
	public void registrarArticuloArchivoCol(Collection<ArticuloDefinicionArchivoDTO> articuloDefinicionArchivoCol)throws SICException{
		for(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO : articuloDefinicionArchivoCol){
			articuloArchivoGestor.registrarArticuloArchivo(articuloDefinicionArchivoDTO);
		}
	}
	/**
	 * 
	 * @param articuloEtiquetaDTO
	 * @throws SICException
	 */
	public void registrarArticuloEtiqueta(ArticuloEtiquetaDTO articuloEtiquetaDTO)throws SICException{
		try{
			dataGestor.createOrUpdate(articuloEtiquetaDTO);
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	/**
	 * 
	 * @param articuloEtiquetaDTO
	 * @throws SICException
	 */
	public void registrarArticuloUso(ArticuloUsoDTO articuloUsoDTO)throws SICException{
		try{
			calculoArticuloGestor.asignarCamposArticuloUso(articuloUsoDTO);
			dataGestor.createOrUpdate(articuloUsoDTO);
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * metodo que registra el articulo establecimiento
	 * @author corbe
	 * @param articuloVO
	 * @throws SICException
	 */
	private void registrarArticuloEstablecimientoOrdenCompra(ArticuloVO articuloVO) throws SICException{
		try{
			if(SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloEstablecimientoCol()) && CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloEstablecimientoCol())){
				for(ArticuloEstablecimientoDTO articuloEstablecimientoDTO : articuloVO.getBaseDTO().getArticuloEstablecimientoCol()){
					articuloEstablecimientoDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					articuloEstablecimientoDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					if(articuloEstablecimientoDTO.getId().getCodigoEstablecimiento() == null){
						throw new SICException("Para realizar el registro se necesita el c\u00F3digo del establecimiento");
					}
					if(articuloEstablecimientoDTO.getUserId() == null && articuloVO.getBaseDTO().getUserId() != null){
						articuloEstablecimientoDTO.setUserId(articuloVO.getBaseDTO().getUserId());
					}
					if(articuloEstablecimientoDTO.getEstadoArticuloEstablecimiento() == null){
						articuloEstablecimientoDTO.setEstadoArticuloEstablecimiento(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					}
					dataGestor.createOrUpdate(articuloEstablecimientoDTO);
				}
			}
		}
		catch (SICException e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw e;
		}catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException(e);
		}
	}
	
	private void registrarArticuloLocalPedido(ArticuloVO articuloVO) throws SICException {
		articuloAlcanceGestor.registrarArticuloLocalPedido(articuloVO.getLocalesPedidoCol());
	}
	
	private void registrarAlcanceArticulo(ArticuloVO articuloVO) throws SICException {
		articuloAlcanceGestor.registrarAlcanceAreasTrabajoArticulo(articuloVO);
	}

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO obtenerArticuloCodigoBarrasActivo(Integer codigoCompania, String codigoBarras) throws SICException {
		return calculoArticuloGestor.obtenerArticuloCodigoBarrasActivo(codigoCompania, codigoBarras);
	}
	
	
	/**
	 * Este m&eacute;todo obtiene los art&iacute;culos junto con los precios, si se env&iacute;a asignado alg&uacute;n valor en la propiedad npCodigoLocal del objeto plantilla, obtiene los precios del local
	 * siempre y cuando est&aacute;n activos o existan
	 * @param con 		- Interface contenedora objeto <code>ArticuloDTO</code>
	 * @param clase 	- La clase del objeto a raiz de la consulta
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public <x extends SearchDTO & ContenedorArticulo> Collection<x> obtenerArticuloVenta(ContenedorArticulo con, Class<x> clase)throws SICException{
		Collection<x> resultados= null;
		try{
			ArticuloDTO articuloDTO = con.getArticuloContenido();
			calculoBusquedaArticuloGestor.incluirRestricionesEspecialesArticulo(articuloDTO);
			calculoBusquedaArticuloGestor.asignarRestricionesDevolucionArticulo(articuloDTO);
			if(articuloDTO.hasDynamicProperty(ArticuloTransient.HABILITADO_ARTICULO_TEMPORADA)){
				articuloDTO.getCriteriaRestrictions().add(new ArticuloTemporadaRestriction("id.codigoArticulo"));
			}
			if(articuloDTO.getNpCodigoLocal() != null){
				calculoBusquedaArticuloGestor.asignarRelacionesArticuloAlcance(articuloDTO);
			}
			//se crean la relaciones
			calculoBusquedaArticuloGestor.asignarRelacionesArticuloPrecio(articuloDTO);
			//asignamos la relacion con clasificacion
			if(!articuloDTO.getTieneClasificacion()){
				articuloDTO.setClasificacionDTO(new ClasificacionDTO());
			}
			resultados = dataGestor.findObjects((x)con);
			asignarDatosArticuloLocal(resultados, articuloDTO);
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e);
		}
		return resultados;
	}
	
	/**
	 * Este m&eacute;todo obtiene los art&iacute;culos junto con los precios, si se env&iacute;a asignado alg&uacute;n valor en la propiedad npCodigoLocal del objeto plantilla, obtiene los precios del local
	 * siempre y cuando est&aacute;n activos o existan
	 * @param articuloDTO 	- objeto plantilla para la consulta
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticuloVenta(ArticuloDTO articuloDTO)throws SICException{
		return obtenerArticuloVenta(articuloDTO, ArticuloDTO.class);
	}
	
	/** 
	 * 
	 * @param articulos
	 * @param filtro
	 */
	public void asignarDatosArticuloLocal(Collection<? extends ContenedorArticulo> articulos, ArticuloDTO filtro){
		final String estadoActivo = SICConstantes.ESTADO_ACTIVO_NUMERICO;
		if(articulos != null && filtro.getNpCodigoLocal()!= null){
			for(ContenedorArticulo conart : articulos){
				ArticuloDTO dto = conart.getArticuloContenido();
				dto.setNpCodigoLocal(filtro.getNpCodigoLocal());				
				for(ArticuloPrecioDTO ap : dto.getArticuloPrecioCol()){
					if(ap.getTieneArticuloLocalPrecio()){
						for(ArticuloLocalPrecioDTO alp : ap.getArticuloLocalPrecioCol()){
							if(ap.getId().getCodigoTipoPrecio().equals(alp.getId().getCodigoTipoPrecio())){
								alp.setArticuloPrecio(ap);
								if(alp.getEstadoPrecio().equals(estadoActivo))
									ap.setNpArticuloLocalPrecio(alp);
								break;
							}
						}
					}
				}
				if(filtro.getNpCodigoLocal() == null){
					dto.setEnumTipoPrecio(EnumTipoPrecio.NINGUNO);
				}else{
					dto.setEnumTipoPrecio(this.validacionArticuloReglasComercialesGestor.obtenerTipoPrecioLocal(dto));
				}
			}
		}
	}
	
	/**
	 * 
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloPrecioDTO> obtenerArticuloPrecio(ArticuloPrecioDTO articuloPrecioDTO)throws SICException{
		try{
			//se crean las relaciones
			calculoBusquedaArticuloGestor.asignarRelacionesArticuloPrecio(articuloPrecioDTO);
			return dataGestor.findObjects(articuloPrecioDTO);
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Obtiene los precios por local basado en un tipo espec&iacute;fico de precio
	 * @param articuloPrecioDTO
	 * @param cargarRelacionArticuloPrecio
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloLocalPrecioDTO> obtenerArticuloLocalPrecio(ArticuloLocalPrecioDTO alp)throws SICException{
		try{
			//se crea el objeto filtro y las relaciones
			//calculoArticuloGestor.asignarRelacionesArticuloLocalPrecio(alp);
			if(alp.getArticuloPrecio() == null){
				alp.setArticuloPrecio(new ArticuloPrecioDTO()); //relaci?n con art?culo precio
				calculoBusquedaArticuloGestor.asignarRelacionesArticuloPrecio(alp.getArticuloPrecio());
			}
			Collection<ArticuloLocalPrecioDTO> alpCol =  dataGestor.findObjects(alp);
			return alpCol;
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e);
		}
	}

	public Collection<ArticuloDTO> buscarTodoArticulos(ArticuloVO articuloVO,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX, IAuthorizationComponent authorizationComponent) throws SICException {		
		return calculoBusquedaArticuloGestor.buscarTodoArticulos(articuloVO, plantillaFiltrosBusquedaMAX, authorizationComponent);
	}
	
	public Collection<ArticuloDTO> buscarTodoArticulosCupon(ArticuloVO articuloVO,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX) throws SICException {		
		return calculoBusquedaArticuloGestor.buscarTodoArticulosCupon(articuloVO, plantillaFiltrosBusquedaMAX);
	}
	
	/**
	 * gestor que busca la cantidad de articulos en la edicion masiva
	 */
	public Long buscarCantidadArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException {		
		return calculoBusquedaArticuloGestor.buscarCantidadArticulosEdicionMasiva(plantillaFiltrosBusquedaMAX);
	}
	
	/**
	 * gestor que busca los articulos en la edicion masiva
	 */
	public Collection<ArticuloEdicionMasivaVO> buscarArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException {		
		return calculoBusquedaArticuloGestor.buscarArticulosEdicionMasiva(plantillaFiltrosBusquedaMAX);
	}
	
	public SearchResultDTO<ArticuloDTO> buscarArticulosSimple(ArticuloVO articuloVO,Set<EnumTipoRelacionArticulo> relacionArticulos,Integer maximoArticulos) throws SICException {
		return calculoBusquedaArticuloGestor.buscarArticulosSimple(articuloVO, relacionArticulos,maximoArticulos);
	}
	/**
	 * Metodo para obtener los Articulos segun condiciones especificas sin precios
	 */
	public SearchResultDTO<ArticuloDTO> obtenerArticulo(ArticuloDTO articuloDTO){
		calculoBusquedaArticuloGestor.incluirRestricionesEspecialesArticulo(articuloDTO);
		return dataGestor.findObjectsPaged(articuloDTO);
	}
	
	public void cambiarEstadoArticulo(Collection<ArticuloDTO> articuloDTOCol,String estado,UserDto userDto) throws SICException {
		articuloDAO.cambiarEstadoArticulo(articuloDTOCol, estado, userDto);
	}
	
	public void cambiarEstadoArticuloProveeedor(Collection<ArticuloProveedorDTO> articuloProveedorDTOCol,String estado,UserDto userDto) throws SICException{
		articuloDAO.cambiarEstadoArticuloProveeedor(articuloProveedorDTOCol, estado, userDto);
	}

	
	public ArticuloBitacoraCodigoBarrasDTO validarAsignacionCodigoBarras(ArticuloVO articuloVO)throws SICRuleException{
		return validacionArticuloGestor.validarAsignacionCodigoBarras(articuloVO);
	}
	
	@Override
	public void validarAsignacionCodigoBarras(Integer codigoCompania, String codigoArticulo, String codigoBarras) throws SICRuleException {
		this.validacionArticuloGestor.validarAsignacionCodigoBarras(codigoCompania, codigoArticulo, codigoBarras);
	}

	/**
	 * Obtiene la lista de art&iacute;culos que no est&aacute;n en promoci&oacute;n
	 * @param articuloDTO		el/los par&aacute;metros de consulta
	 * @return					la informaci&oacute;n solicitada
	 * @throws SICException		en caso de error al ejecutar el m&eacute;todo
	 */
	public SearchResultDTO<ArticuloDTO> obtenerArticulosSinPromocionPorLocal(ArticuloDTO articuloDTO) throws SICException {
		SearchResultDTO<ArticuloDTO> articuloDTOs = articuloDAO.obtenerArticulosSinPromocionPorLocal(articuloDTO);		
		Collection<ArticuloDTO> articuloResults = new ArrayList<ArticuloDTO>(); 
		
		for(ArticuloDTO artDTO: articuloDTOs.getResults()){
			ArticuloDTO dto = new ArticuloDTO();
			dto.setArtBitCodBarCol(articuloDTO.getArtBitCodBarCol());
			dto.setArticuloProveedorCol(articuloDTO.getArticuloProveedorCol());
			dto.setArticuloComercialDTO(articuloDTO.getArticuloComercialDTO());
			dto.setClasificacionDTO(new ClasificacionDTO());
			dto.getId().setCodigoArticulo(artDTO.getId().getCodigoArticulo());
			dto.getId().setCodigoCompania(artDTO.getId().getCodigoCompania());
			dto.setNpCodigoLocal(articuloDTO.getArticuloLocalCol().iterator().next().getId().getCodigoLocal());
			articuloResults.add((this.obtenerArticuloVenta(dto)).iterator().next());
		}
		articuloDTOs.setResults(articuloResults);
		return articuloDTOs;
	}
	
	/**
	 * Realiza el registro de las clases de art&iacute;culo
	 * @param claseArticuloDTO
	 * @throws SICException
	 */
	public void registrarClaseArticulo(ClaseArticuloDTO claseArticuloDTO) throws SICException{
		try{
			if(claseArticuloDTO.getId()==null || StringUtils.isEmpty(claseArticuloDTO.getId().getCodigoClaseArticulo())){
				throw new SICException("El id del objeto no puede ser nulo");}
			dataGestor.createOrUpdate(claseArticuloDTO);
		}catch (Exception e){
			throw new SICException(e);
		}

	}
	
	public void incluirRestriccionesBusquedaArticulo(ArticuloVO articuloFiltro,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException{
		calculoBusquedaArticuloGestor.incluirRestriccionesBusquedaArticulo(articuloFiltro, plantillaFiltrosBusqueda);
	}
		
	public void cargarCadenaDescuentos(ArticuloProveedorDTO articuloProveedorDTO) throws SICException{
		calculoBusquedaArticuloGestor.cargarCadenaDescuentos(articuloProveedorDTO);
	}
	
	public void asignarRelacionesArticuloCosto(ArticuloDTO articuloDTO) throws SICException{
		calculoBusquedaArticuloGestor.asignarRelacionesArticuloCosto(articuloDTO);
	}
	/**
	 * 
	 * @param locales
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return
	 * @throws SICException
	 */
	@Override
	public void validarCantidadCuponesActivosLocal(ArticuloVO articuloVO) throws SICException{
		validacionArticuloGestor.validarCantidadMaximaCuponesActivosLocal(articuloVO);
	}
	
	public void cargarRelacion(ArticuloDTO articuloDTO,  EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		calculoBusquedaArticuloGestor.cargarRelacion(articuloDTO, tiposRelacion);
	}
	
	@Override
	public SearchResultDTO<ArticuloDTO> buscarArticulos(ArticuloVO articuloVO, IAuthorizationComponent authorizationComponent) throws SICException {
		return calculoBusquedaArticuloGestor.buscarArticulos(articuloVO, authorizationComponent);
	}
	
	public void registrarArticulos(Collection<ArticuloDTO> articuloDTOs) throws SICException{//TODO
		Collection<ArticuloVO> articuloVOs = new ArrayList<ArticuloVO>();
		for(ArticuloDTO articuloDTO : articuloDTOs){
			ArticuloVO articuloVO = new ArticuloVO();
			articuloVO.setBaseDTO(articuloDTO);
			Set<EnumSubProcesoGuardadoArticulo> enumSubProcesoGuardadoArticulo = new HashSet<EnumSubProcesoGuardadoArticulo>();
			enumSubProcesoGuardadoArticulo.add(EnumSubProcesoGuardadoArticulo.REGISTROSANITARIO);
			enumSubProcesoGuardadoArticulo.add(EnumSubProcesoGuardadoArticulo.ARTICULOPROVEEDOR);
			enumSubProcesoGuardadoArticulo.add(EnumSubProcesoGuardadoArticulo.ARTICULO);
			enumSubProcesoGuardadoArticulo.add(EnumSubProcesoGuardadoArticulo.ARTICULOCOMERCIAL);
			enumSubProcesoGuardadoArticulo.add(EnumSubProcesoGuardadoArticulo.ARTICULODEFINICIONARCHIVO);
			
			articuloVO.setSubProcesoGuardadoArticulo(enumSubProcesoGuardadoArticulo);
			articuloVO.getBaseDTO().setTransferirDatosSIC(Boolean.FALSE);
			this.registrarArticulo(articuloVO);
			articuloVO.getBaseDTO().setTransferirDatosSIC(Boolean.TRUE);
			articuloVOs.add(articuloVO);
		}
		this.accionArticuloGestor.transferirDatosArticuloSIC(articuloVOs, Boolean.FALSE, null);
	}
	
	@Override
	public void inactivarCupones(Integer codigoCompania, String codigoArticulo, String userId) throws SICException{
		if(codigoCompania == null){
			throw new SICException("No existe codigo compania.");
		}
		if(codigoArticulo == null){
			throw new SICException("No existe codigo articulo.");
		}
		if(userId == null){
			throw new SICException("No existe userId.");
		}
		
		this.articuloDAO.inactivarArticulo(codigoCompania, codigoArticulo, userId);
		this.calculoArticuloGestor.registrarSecuenciaDisponible(codigoCompania, codigoArticulo, userId);
		this.articuloIntegracionDAO.registrarArticuloPendienteIntegracion(codigoCompania, codigoArticulo, TipoCatalogoArticulo.PROCESO_INTEGRACION_EDICIONARTICULO, userId);
	}
	
	public VistaArticuloCodBarrasEtiquetaMercanciaDTO obtenerMercanciaporCodigoBarras(String codigoBarras, Integer codigoCompania)throws SICException{
		return camposMercanciaDAO.obtenerMercanciaporCodigoBarras(codigoBarras, codigoCompania);
	}
	
	/**
	 * @author aquingaluisa
	 */
	public void generarArchivoImpresionEtiquetaMercancias(Collection<ArticuloEtiquetaMercanciaDTO> articuloEtiquetaMercanciaDTOCol,TagFormatDTO formatoEtiqueta,UserDto userDto,String remoteHost,String nombreBatParametro,String nombreTxtParametro)  throws SICException{
		if(articuloEtiquetaMercanciaDTOCol != null && CollectionUtils.isNotEmpty(articuloEtiquetaMercanciaDTOCol)){
			//obtengo el formato para eliminar caracteres espsciales en los campos de mercnacias
			ParametroDTO parametroDTO = parametroGestor.obtenerParametro(((ArticuloEtiquetaMercanciaDTO)CollectionUtils.get(articuloEtiquetaMercanciaDTOCol, 0)).getId().getCodigoCompania(),
					SICArticuloConstantes.getInstancia().VALOR_ID_PARAMETRO_PATERN_ETIQUETA_MERCANCIA);
			if(parametroDTO != null && StringUtils.isNotEmpty(parametroDTO.getValorParametro())){//iteretro todas las etiquetas enviadas
				for(ArticuloEtiquetaMercanciaDTO mercanciasMediator: articuloEtiquetaMercanciaDTOCol){
					if(mercanciasMediator.getTraduccion()!=null)mercanciasMediator.setTraduccion(mercanciasMediator.getTraduccion().replaceAll(parametroDTO.getValorParametro(), " ").replaceAll("\\s+", " "));
					if(mercanciasMediator.getListaComponentes()!=null)mercanciasMediator.setListaComponentes(mercanciasMediator.getListaComponentes().replaceAll(parametroDTO.getValorParametro(), " ").replaceAll("\\s+", " "));
					if(mercanciasMediator.getCondicionesConservacion()!=null)mercanciasMediator.setCondicionesConservacion(mercanciasMediator.getCondicionesConservacion().replaceAll(parametroDTO.getValorParametro(), " ").replaceAll("\\s+", " "));
					if(mercanciasMediator.getAdvertencia()!=null)mercanciasMediator.setAdvertencia(mercanciasMediator.getAdvertencia().replaceAll(parametroDTO.getValorParametro(), " ").replaceAll("\\s+", " "));
				}
			}else{
				Logeable.LOG_SICV2.warn("**************************** no se encontro el parametro para eliminar caracteres especiales***************************");
			}
			//completo los datos faltantes
			for(ArticuloEtiquetaMercanciaDTO mercanciasMediator: articuloEtiquetaMercanciaDTOCol){
				if(mercanciasMediator.getCodigoBarras() == null){
					mercanciasMediator.setCodigoBarras(mercanciasMediator.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
				}
			}
			
			SimpleDateFormat tiempo = new SimpleDateFormat("yyyyMMddHHmmssSS");
			String carpeta = tiempo.format(new Date());
			//creo la carpeta en el directorio temporal
			File directorio = new File(System.getProperty("java.io.tmpdir"), carpeta);
			if (directorio.mkdir()) {
				Logeable.LOG_SICV2.info("Creando la carpeta temporal:{}", directorio.getAbsolutePath());
			}

			String nombreArchivo = nombreTxtParametro;
			
//			Collection<Object> impresionesCol = new ArrayList<Object>();
//			// se agregan los detalles de impresion
//			impresionesCol.add(articuloEtiquetaMercanciaDTO);
			
			// Generar archivo
			File file = new File(directorio, nombreArchivo);
			GeneradorExportacionService exportacionService = new GeneradorExportacionService();
			FormatoID formatoID = new FormatoID();
			try {
				formatoID.setCodigoCompania(((ArticuloEtiquetaMercanciaDTO)CollectionUtils.get(articuloEtiquetaMercanciaDTOCol, 0)).getId().getCodigoCompania());
			} catch (Exception e) {
				throw new SICException("El formato no se pudo establecer", e);
			}
//			formatoID.setCodigoSistema(LogUtilMessages.getInstancia().getString("log.sistema.MAX"));
//			formatoID.setCodigoFormato(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionEtiquetaMercanciasTraduccion.codigoFormato"));
			formatoID.setCodigoSistema(formatoEtiqueta.getCodeSystem());
			formatoID.setCodigoFormato(formatoEtiqueta.getCodeFormat());
			GeneracionExportacionListener listener = new GeneracionExportacionListener() {
				public void recibirNotificacionInclusionObjeto(EnvioDTO arg0, Object arg1, Date arg2) throws GeneradorExportacionException {
				}
				@SuppressWarnings({ "rawtypes" })
				public void recibirNotificacionFinalizacionExitosaEnvio(EnvioDTO arg0, Collection arg1, Date arg2) throws GeneradorExportacionException {
				}
				@SuppressWarnings({ "rawtypes" })
				public void recibirNotificacionErrorEnvio(EnvioDTO arg0, Collection arg1, Object arg2, Throwable arg3, Date arg4) throws GeneradorExportacionException {
				}
			};
			exportacionService.addListener(listener);
			try {
				// si existen datos del detalle se exporta el archivo...
				if (articuloEtiquetaMercanciaDTOCol != null && CollectionUtils.isNotEmpty(articuloEtiquetaMercanciaDTOCol)) {
					String usuarioId = userDto.getUserId();
					EnvioDTO envio = exportacionService.inicializarEnvio(formatoID, usuarioId);
					exportacionService.transRealizarEnvioDatos(articuloEtiquetaMercanciaDTOCol, envio.getId(), file, usuarioId);
				}

			} catch (Exception e) {
				throw new SICException("Ha ocurrido un error al generar el archivo", e);
			}

			Logeable.LOG_SICV2.info("El archivo {} ha sido creado correctamente", file.getAbsolutePath());
			
//			String nombreBat = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionEtiquetaMercanciasTraduccion.nombreBat");
			String nombreBat = nombreBatParametro;
			File fileExec = new File(directorio, nombreBat);
			FileWriter fw = null;
			PrintWriter pw = null;
			
			try {
				fw = new FileWriter(fileExec);
				pw = new PrintWriter(fw);
				pw.println("cd " + SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionEtiquetaMercancias.directorioRemotoCompleto"));
				pw.println(formatoEtiqueta.getNameFile());
				pw.close();
				Logeable.LOG_SICV2.info("El archivo {} ha sido creado correctamente", fileExec.getAbsolutePath());
			} catch (IOException e2) {
				Logeable.LOG_SICV2.error("Error: ", e2);
				throw new SICException("No se pudo generar el archivo bat", e2);
			} finally {
				if (null != fw)
					try {
						fw.close();
						pw.close();
					} catch (IOException e) {
						Logeable.LOG_SICV2.error("Error: ", e);
					}
			}
			Logeable.LOG_SICV2.info("****Datos actualizar*****");
			// datos para subir por FTP los archivos
			String directorioRemotoFTP = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionEtiquetaMercancias.directorioRemotoFTP");
			String user = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionMercancias.ftp.us");
			String pass = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionMercancias.ftp.ps");
			FTPClient ftpClient = new FTPClient();
			boolean successful = false;
			try {
				String remoteHostToConnect = null;
				if(StringUtils.equals(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionMercancias.ftp.skip.serverRequest"), SICConstantes.ESTADO_ACTIVO_NUMERICO)){
					remoteHostToConnect = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionMercancias.ftp.serverName");
				}else{
					remoteHostToConnect = InetAddress.getByName(remoteHost).getCanonicalHostName();
				}
				Logeable.LOG_SICV2.info("Connecting to server: " + remoteHostToConnect);
				Logeable.LOG_SICV2.info("Port: " + SICArticuloConstantes.getInstancia().VALOR_PUERTO_FTP);
				ftpClient.connect(remoteHostToConnect, SICArticuloConstantes.getInstancia().VALOR_PUERTO_FTP);			
				ftpClient.setFileType(FTP.ASCII_FILE_TYPE);				
				boolean conectado = ftpClient.login(user, pass);			
				Logeable.LOG_SICV2.info("Connected to server {}: " + conectado,remoteHostToConnect);
				if(!conectado){
					throw new SICException("Ha ocurrido un error al autenticarse con el servidor FTP.");
				}
		        ftpClient.changeWorkingDirectory(directorioRemotoFTP);
		        Collection<File> archivosCol = new ArrayList<File>();
				archivosCol.add(file);
				archivosCol.add(fileExec);
				for (File archivo : archivosCol) {
					InputStream in = new FileInputStream(archivo);
					ftpClient.storeFile(archivo.getName(),in);	
					in.close();
				}
				Logeable.LOG_SICV2.info(ftpClient.getReplyString());
				if(!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())){
					ftpClient.logout();
					successful = false;
					throw new SICException("Ha ocurrido un error al transferir los archivos");
				}
				Logeable.LOG_SICV2.info("Connection is working: " + ftpClient.noop()); // check that control connection is working OK
				ftpClient.logout();
				successful = true;
				Logeable.LOG_SICV2.info("Send successful:" + successful);				
			} catch (SocketException e){
				Logeable.LOG_SICV2.error("Server closed connection: ", e.getMessage());
				throw new SICException("Ha ocurrido un error al comunicarse con el servidor FTP", e);
	        }catch (FTPConnectionClosedException e){
	        	Logeable.LOG_SICV2.error("Server closed connection: ", e.getMessage());
				throw new SICException("Ha ocurrido un error al comunicarse con el servidor FTP", e);
	        }catch (IOException e) {
	        	Logeable.LOG_SICV2.error("Error al transferir archivos: ", e.getMessage());
	        	throw new SICException("Ha ocurrido un error al transferir los archivos", e);
			} finally {
				try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	            	Logeable.LOG_SICV2.error("Error al cerrar la conexion.");
	            	throw new SICException("Ha ocurrido un error al cerrar la conexion", ex);
	            }
				try {
					Logeable.LOG_SICV2.info("Eliminando carpeta temporal:{}", directorio.getAbsoluteFile());
					FileUtils.deleteDirectory(directorio);
				} catch (IOException e) {
					Logeable.LOG_SICV2.error(e.getMessage());
					Logeable.LOG_SICV2.error("Error al eliminar la carpeta temporal.");
		        	throw new SICException("Error al eliminar la carpeta temporal.", e);
				}
				file=null;
				exportacionService=null;
			}
			file=null;
			exportacionService=null;
			directorio = null;
		}
		
	}
	
	@Override
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, Integer codigoCompania) throws SICException {
		return this.articuloDAO.obtenerExistenciaCaracteristicaDinamica(codigoClasificacion, codigoTipoCaracteristica, codigoCompania);
	}
	
	public Collection<String> obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> artUniMnjCol){
		return this.articuloBitacoraGestor.obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(articuloVO, artUniMnjCol);
	}
	
	public Collection<ArticuloDTO> obtenerArticuloPorUnidadesManejoCodBarras(Integer compania, String codigoBarras){
		return this.articuloBitacoraGestor.obtenerArticuloPorUnidadesManejoCodBarras(compania, codigoBarras);
	}
	
	public String obtenerCodigoBarrasActivoPorArticulo(String codigoArticulo,Integer codigoCompania) throws SICException{
		return this.articuloBitacoraGestor.obtenerCodigoBarrasActivoPorArticulo(codigoArticulo, codigoCompania);
	}
	
	@Override
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, String codigoValorCaracteristica, Integer codigoCompania) throws SICException {
		return this.articuloDAO.obtenerExistenciaCaracteristicaDinamica(codigoClasificacion, codigoTipoCaracteristica, codigoValorCaracteristica, codigoCompania);
	}
	
	@Override
	public void validarPreciosCostos(final Integer presentacion, final Boolean ventaPrecioAfiliado, final Double porcentajeNA, Double costoBruto, Double precioBase, Double pvp, Collection<ArticuloImpuestoDTO> articuloImpuestos
			, final Collection<DescuentoProveedorArticuloDTO> descuentosProveedor , final Set<EnumCaracteristicaDinamica> caracteristicasDinamicas) throws SICRuleException{
		this.validacionArticuloReglasComercialesGestor.validarPreciosCostos(presentacion, ventaPrecioAfiliado, porcentajeNA, costoBruto, precioBase, pvp, articuloImpuestos, descuentosProveedor, caracteristicasDinamicas);
	}
	
	@Override
	public EnumTipoPrecio obtenerTipoPrecioLocal(ArticuloDTO articuloDTO) throws SICException{
		return this.validacionArticuloReglasComercialesGestor.obtenerTipoPrecioLocal(articuloDTO);
	}
	
	
	/**
	 * Permite obtener registros de art&iacute;culo local a partir de los filtros de b&uacute;squeda de art&iacute;culos
	 * @author dalmeida
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloAlcanceEST> obtenerArticulosLocalAlcance(ArticuloVO articuloVO) throws SICException{
		return articuloDAO.obtenerArticulosLocalAlcance(articuloVO);
	}
	
	@Override
	public SearchResultDTO<ArticuloDTO> buscarArticulosB2B(ArticuloVO articuloVO) throws SICException {
		return calculoBusquedaArticuloGestorB2B.buscarArticulosB2B(articuloVO);
	}
	
	@Override
	public void incluirRestriccionesBusquedaArticuloB2B(ArticuloVO articuloFiltro,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException{
		this.calculoBusquedaArticuloGestorB2B.incluirRestriccionesBusquedaArticuloB2B(articuloFiltro, plantillaFiltrosBusqueda);
	}	
	
	@Override
	public Collection<ArticuloDTO> buscarTodoArticulosB2B(ArticuloVO articuloVO,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException {		
		return calculoBusquedaArticuloGestorB2B.buscarTodoArticulosB2B(articuloVO, plantillaFiltrosBusqueda);
	}

	/**
	 * Metodo para obtener los campos de la Etiqueta para la Mercancia
	 * @author dbravo
	 */
	@Override
	public VistaCampoMercanciaDTO obtenerCamposEtiquetaMercancia(String codigoArticulo, Integer codigoCompania) throws SICException {
		// TODO Auto-generated method stub	
		try{
			//VistaRazonSocialProveedorDTO vistaRazonSocialProveedorDTO = new VistaRazonSocialProveedorDTO();
			VistaCampoMercanciaDTO vistaCampoMercanciaDTO = camposMercanciaDAO.obtenerCamposMercancia(codigoArticulo, codigoCompania);
					
			//RAZON SOCIAL DE LA IMPORTADORA es TRUE IMPORTADO, FALSE NACIONAL
			vistaCampoMercanciaDTO.setRazonSocialImportador(esArticuloImportado(codigoArticulo, codigoCompania));
			
			return vistaCampoMercanciaDTO;
			
		}catch(Exception ex){
			Logeable.LOG_SICV2.error(ex.getMessage());
			throw new SICException(ex);
		}
	}
	
	/**
	 * Metodo devuelve si un articulo es importado = TRUE o Nacional = FALSE
	 * @author dbravo
	 */
	@Override
	public Boolean esArticuloImportado(String codigoArticulo, Integer codigoCompania){
		try{
			String resultado = camposMercanciaDAO.obtenerCodigoClasificacionParaValidacionImportado(codigoArticulo, codigoCompania);
			Integer numero;
			if(resultado == null){
				return Boolean.FALSE;
			}
			else{
				numero = Integer.parseInt(resultado);
				if((numero%2) == 0){// numero es par
					return Boolean.FALSE;
				}
				else{// numero es impar
					return Boolean.TRUE;
				}
			}
		}catch(NumberFormatException ex){// el resultado no es un numero sino un String
			return Boolean.FALSE;
		}
		
	}
	
	@Override
	public <T> void enviarArchivoFtp(Collection<T> objectToGenererateFile, TagFormatDTO formatoEtiqueta, String usuario, String remoteHost, Integer puertoFtp, String nombreBatParametro, String nombreTxtParametro, String directorioRemotoBat, String usuarioFtp, String passwordFtp, String directorioRemotoFtp) throws SICException {
		// simpre debe tener datos
		if (objectToGenererateFile != null
				&& CollectionUtils.isNotEmpty(objectToGenererateFile)
				&& formatoEtiqueta != null && usuario != null
				&& remoteHost != null && nombreBatParametro != null
				&& nombreTxtParametro != null && puertoFtp != null
				&& directorioRemotoBat !=null && usuarioFtp != null
				&& passwordFtp !=null && directorioRemotoFtp != null) {
			if (formatoEtiqueta.getId() != null) { 
				// siempre debe tener el codigo de la compania, necesaria para realizar las consultas
				if (formatoEtiqueta.getId().getCompanyId() != null) {
					//cargo la fecha  y hora actual
					SimpleDateFormat tiempo = new SimpleDateFormat("yyyyMMddHHmmssSS");
					//asignar un nombre a la carpeta con  la fecha
					String carpeta = tiempo.format(new Date())+usuario+formatoEtiqueta.getCodeFormat();
					//crear la carpeta en el directorio temporal
					File directorio = new File(System.getProperty("java.io.tmpdir"), carpeta);
					if (directorio.mkdir()) {
						LOG_SICV2.info("Creando la carpeta temporal:{}", directorio.getAbsolutePath());
					}
					// Generar archivo en el directorio descrito, y el nombre del archivo txt
					File file = new File(directorio, nombreTxtParametro);
					GeneradorExportacionService exportacionService = new GeneradorExportacionService();
					//formar el formato para utilizar en generacion exportacion
					FormatoID formatoID = new FormatoID();
					formatoID.setCodigoCompania(formatoEtiqueta.getId().getCompanyId());
					//datos necesarios para las consultas
					formatoID.setCodigoSistema(formatoEtiqueta.getCodeSystem());
					formatoID.setCodigoFormato(formatoEtiqueta.getCodeFormat());
					//listener necesario para generacion exportacion
					GeneracionExportacionListener listener = new GeneracionExportacionListener() {
						public void recibirNotificacionInclusionObjeto(
								EnvioDTO arg0, Object arg1, Date arg2)
								throws GeneradorExportacionException {
						}
						@SuppressWarnings({ "rawtypes" })
						public void recibirNotificacionFinalizacionExitosaEnvio(
								EnvioDTO arg0, Collection arg1, Date arg2)
								throws GeneradorExportacionException {
						}
						@SuppressWarnings({ "rawtypes" })
						public void recibirNotificacionErrorEnvio(
								EnvioDTO arg0, Collection arg1, Object arg2,
								Throwable arg3, Date arg4)
								throws GeneradorExportacionException {
						}
					};
					//agregar el listner al objeto expotacion
					exportacionService.addListener(listener);
					
					try {
						//crear el objeto envio para generacion exportacion
						EnvioDTO envio = exportacionService.inicializarEnvio(formatoID, usuario);
						exportacionService.transRealizarEnvioDatos(objectToGenererateFile, envio.getId(), file, usuario);
					} catch (GeneradorExportacionException e) {
						throw new EtiquetadoException("Ha ocurrido un error al generar el archivo", e);
					}
					//al llegar aqui el archivo se encuentra generado con exito
					LOG_SICV2.info("El archivo {} ha sido creado correctamente", file.getAbsolutePath());
					//crear el archivo bat
					File fileBat = new File(directorio, nombreBatParametro);
					//necesarios para crear el archivo
					FileWriter fileWriter = null;
					PrintWriter printWrinter = null;
					try {
						fileWriter = new FileWriter(fileBat);
						printWrinter = new PrintWriter(fileWriter);
						//escribir en el archivo bat
						printWrinter.println("cd " + directorioRemotoBat);
						printWrinter.println(formatoEtiqueta.getNameFile());
						printWrinter.close();
						LOG_SICV2.info("El archivo {} ha sido creado correctamente", fileBat.getAbsolutePath());
					} catch (IOException e2) {
						LOG_SICV2.error("Error: ", e2);
						throw new EtiquetadoException("No se pudo generar el archivo bat", e2);
					} finally {
						if (null != fileWriter)
							try {
								fileWriter.close();
								printWrinter.close();
							} catch (IOException e) {
								LOG_SICV2.error("Error: ", e);
							}
					}
					//iniciar el ftp
					FTPClient ftpClient = new FTPClient();
					boolean successful = false;
					try {
						ftpClient.connect(remoteHost, puertoFtp);			
						ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
						boolean conectado = ftpClient.login(usuarioFtp, passwordFtp);			
						LOG_SICV2.info("Connected to server {}: " + conectado,directorioRemotoFtp);
						if(!conectado){
							throw new EtiquetadoException("Ha ocurrido un error al autenticarse con el servidor FTP.");
						}
						ftpClient.changeWorkingDirectory(directorioRemotoFtp);
						Collection<File> archivosCol = new ArrayList<File>();
						archivosCol.add(file);
						archivosCol.add(fileBat);
						for (File archivo : archivosCol) {
							InputStream in = new FileInputStream(archivo);
							ftpClient.storeFile(archivo.getName(),in);	
							in.close();
						}
						if(!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())){
							ftpClient.logout();
							successful = false;
							throw new EtiquetadoException("Ha ocurrido un error al transferir los archivos");
						}
						LOG_SICV2.info("Connection is working: " + ftpClient.noop()); 
						ftpClient.logout();
						successful = true;
						LOG_SICV2.info("Send successful:" + successful);
					} catch (SocketException e){
						LOG_SICV2.error("Server closed connection: ", e.getMessage());
						throw new EtiquetadoException("Ha ocurrido un error al comunicarse con el servidor FTP", e);
			        }catch (FTPConnectionClosedException e){
			        	LOG_SICV2.error("Server closed connection: ", e.getMessage());
						throw new EtiquetadoException("Ha ocurrido un error al comunicarse con el servidor FTP", e);
			        }catch (IOException e) {
			        	LOG_SICV2.error("Error al transferir archivos: ", e.getMessage());
			        	throw new EtiquetadoException("Ha ocurrido un error al transferir los archivos", e);
					}
					finally {
						try {
			                if (ftpClient.isConnected()) {
			                    ftpClient.disconnect();
			                }
			            } catch (IOException ex) {
			            	LOG_SICV2.error("Error al cerrar la conexion.");
			            	throw new EtiquetadoException("Ha ocurrido un error al cerrar la conexion", ex);
			            }
						try {
							LOG_SICV2.info("Eliminando carpeta temporal:{}", directorio.getAbsoluteFile());
							FileUtils.deleteDirectory(directorio);
						} catch (IOException e) {
							Logeable.LOG_SICV2.error(e.getMessage());
							LOG_SICV2.error("Error al eliminar la carpeta temporal.");
				        	throw new EtiquetadoException("Error al eliminar la carpeta temporal.", e);
						}
						file=null;
						exportacionService=null;
					}
					file=null;
					exportacionService=null;
					directorio = null;
					fileBat=null;
				} else {
					throw new IllegalArgumentException("formatoEtiqueta debe tener datos en el id");
				}
			} else {
				throw new IllegalArgumentException("formatoEtiqueta debe tener datos en el id");
			}

		} else {
			throw new IllegalArgumentException(
					"Todos los parametros  deben contener datos");
		}
	}
	
	public Collection<ArticuloAgrupadorDTO> obtenerArticuloAgrupadorPorCodigoTipoAgrupador(Integer codigoCompania, String codigoArticulo, Integer codigoTipoAgrupador) throws SICException {
		return this.articuloAgrupadorGestor.obtenerArticuloAgrupadorPorCodigoTipoAgrupador(codigoCompania, codigoArticulo, codigoTipoAgrupador);
	}

	public String integrarDatosRecepcionArticuloSIC(Integer codigoCompania, String codigoBarras) throws Exception{
		return this.accionArticuloGestor.integrarDatosRecepcionArticuloSIC(codigoCompania, codigoBarras);
	}
	
	public SearchResultDTO<ArticuloDTO> buscarArticuloBasico(Criterion criterioBusqueda , Integer firstResult ,Integer maxResults , Boolean findNum , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException{
		return calculoBusquedaArticuloGestor.buscarArticuloBasico(criterioBusqueda , firstResult , maxResults , findNum , busquedaSimpleArticuloVO);
	}
	
	public Boolean validarAplicaMayoreo(ArticuloDTO articuloDTO) throws SICException{
		return validacionArticuloReglasComercialesGestor.validarAplicaMayoreo(articuloDTO);
	}
	
	public Collection<ArticuloDTO> obtenerArticulos(Collection<String> codigosArticulo) throws SICException{
		return articuloDAO.obtenerArticulos(codigosArticulo);
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerInformacionArticulo(Integer codigoCompania, String[] codigoArticulos, String[] codigoBarras, String[] codigoClasificacion, String[] codigoProveedores, EnumTipoRelacionArticulo... tiposRelacion){
		Collection<ArticuloDTO> articuloDTOs = this.articuloDAO.obtenerInformacionArticulo(codigoCompania, codigoArticulos, codigoBarras, codigoClasificacion, codigoProveedores, tiposRelacion);
		if(CollectionUtils.isNotEmpty(articuloDTOs)){
			for(ArticuloDTO articuloInfo : articuloDTOs){
				if(articuloInfo.getTieneArticuloPrecio()){
					for(ArticuloPrecioDTO dto : articuloInfo.getArticuloPrecioCol()){
						dto.setArticulo(articuloInfo);
					}
				}
			}
		}
		return articuloDTOs;
	}
	
	/**
	 * registra la auditoria del articulo (sistema y opcion)
	 * @param articuloVO
	 */
	private void registrarAuditoriaExtendida(ArticuloVO articuloVO){
		if(StringUtils.isNotEmpty(articuloVO.getSystemId()) && StringUtils.isNotEmpty(articuloVO.getAccessItemId())){
			//verficamos cuando el articulo fue creado desde excel
			String codigoOpcion = null;
			if(articuloVO.hasDynamicProperty("opcionCreacionArchivo")){
				//validamos cuando se registra desde creacion por excel se registre una sola vez, (ya que se llama al metodo guardarArticulo en dos ocaciones, la segunda es para codificar el articulo)
				if(articuloVO.hasDynamicProperty("registrarAuditoriaExtendida")){
					codigoOpcion = (String) articuloVO.getDynamicProperty("opcionCreacionArchivo");
				}
			}else{
				codigoOpcion = articuloVO.getAccessItemId();
			}
			if(codigoOpcion != null){
				articuloEdicionMasivaGestor.registrarAuditoriaExtendida(articuloVO.getBaseDTO().getId().getCodigoCompania() , articuloVO.getBaseDTO().getId().getCodigoArticulo() , articuloVO.getSystemId() , codigoOpcion);
			}
		}
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerInformacionGeneral(Integer codigoCompania, String[] codigoArticulos, String[] codigoProveedores) throws SICException {
		return this.articuloDAO.obtenerInformacionGeneral(codigoCompania, codigoArticulos, codigoProveedores);
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerCostosArticulos(String[] codigoArticulos) throws SICException {
		return this.articuloDAO.obtenerCostosArticulos(codigoArticulos);
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerCostosNetosArticulos(String[] codigoArticulos, String[] codigoProveedor) throws SICException {
		return this.articuloDAO.obtenerCostosNetosArticulos(codigoArticulos, codigoProveedor);
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerPreciosPorCodigo(Integer codigoCompania,String []codigoArticulos ){
		return this.articuloDAO.obtenerPreciosPorCodigo(codigoCompania, codigoArticulos);
	}
	
	@Override
	public Collection<ArticuloDTO> validarArticuloRelacion(ArticuloVO articuloVO)throws SICException{
		return this.articuloDAO.validarArticuloRelacion(articuloVO);
	}
	
	public String registrarArticuloEAN(String codigoBarras , Integer codigoCompania , String idUsuario , Boolean validarEan) throws SICException{
		//primeramente validamos si el codigo de barras es un ean valido, dependiendo del parametro
		ValidatorImpl validador = new ValidatorImpl();
	    if ( (BooleanUtils.isTrue(validarEan) && validador.validateEAN(codigoBarras)) || BooleanUtils.isFalse(validarEan)) {
	    	try{
		    	ArticuloVO articuloVO = calculoArticuloGestor.crearArticuloEAN(codigoBarras, codigoCompania);
		        validacionArticuloGestor.validarAsignacionCodigoBarras(articuloVO);
	        	calculoArticuloGestor.asignarValoresArticuloEAN(articuloVO, codigoCompania , idUsuario);
	        	articuloVO.setSubProcesoGuardadoArticulo(new HashSet<EnumSubProcesoGuardadoArticulo>());
	    		articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULO);
	    		articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOCOMERCIAL);
	    		articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOMEDIDA);
	    		articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.SEGMENTOCODIFICACION);
	    		
	    		this.registrarArticulo(articuloVO);
	    		return articuloVO.getBaseDTO().getId().getCodigoArticulo();
	    	}catch(SICRuleException re){
    			throw re;
    		}catch(SICException ec){
    			throw ec;
    		}catch(Exception e){
    			throw e;
    		}
	    		
	    }else{
	    	throw new SICException("El codigo de barras no es un ean valido");
	    }
	}
	
	@Override
	public void registrarPrecioArticuloPorTipoPrecio(Collection<ArticuloPrecioDTO> articulosPrecio) {
		this.articuloLocalPrecioDAO.registrarPrecioArticuloPorTipoPrecio(articulosPrecio);
	}
	
	@Override
	public List<ArticuloPrecioDTO> obtenerDatosArticulosPreciosPorTiposPrecios(Integer codigoCompania, Set<String> codigosArticulo, Set<EnumTipoPrecio> tiposPrecios) throws SICException {
		return this.articuloLocalPrecioDAO.obtenerDatosArticulosPreciosPorTiposPrecios(codigoCompania, codigosArticulo, tiposPrecios);
	}
	
	@Override
	public Integer inactivarUnidadManejoPorPrioridad(Integer codigoCompania, String codigoArticulo, Integer prioridad, String userId, Long... codigoUnidadManejo) throws SICException {
		return this.articuloUnidadManejoGestor.inactivarUnidadManejoPorPrioridad(codigoCompania, codigoArticulo, prioridad, userId, codigoUnidadManejo);
	}
	
	//-------------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------GETTER Y SETTERS------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------------
	
	public void setCalculoBusquedaArticuloGestorB2B(ICalculoBusquedaArticuloGestorB2B calculoBusquedaArticuloGestorB2B) {
		this.calculoBusquedaArticuloGestorB2B = calculoBusquedaArticuloGestorB2B;
	}

	public void setArticuloArchivoGestor(IArticuloArchivoGestor articuloArchivoGestor) {
		this.articuloArchivoGestor = articuloArchivoGestor;
	}
	
	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}
	
	/**
	 * @return the dataGestor
	 */
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	/**
	 * @return the accionArticuloGestor
	 */
	public IAccionArticuloGestor getAccionArticuloGestor() {
		return accionArticuloGestor;
	}

	/**
	 * @param accionArticuloGestor the accionArticuloGestor to set
	 */
	public void setAccionArticuloGestor(IAccionArticuloGestor accionArticuloGestor) {
		this.accionArticuloGestor = accionArticuloGestor;
	}

	/**
	 * @param articuloLocalPrecioDAO the articuloLocalPrecioDAO to set
	 */
	public void setArticuloLocalPrecioDAO(IArticuloLocalPrecioDAO articuloLocalPrecioDAO) {
		this.articuloLocalPrecioDAO = articuloLocalPrecioDAO;
	}

	/**
	 * @param calculoBusquedaArticuloGestor the calculoBusquedaArticuloGestor to set
	 */
	public void setCalculoBusquedaArticuloGestor(ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor) {
		this.calculoBusquedaArticuloGestor = calculoBusquedaArticuloGestor;
	}

	/**
	 * @return the articuloProveedorGestor
	 */
	public IArticuloProveedorGestor getArticuloProveedorGestor() {
		return articuloProveedorGestor;
	}

	/**
	 * @param articuloProveedorGestor the articuloProveedorGestor to set
	 */
	public void setArticuloProveedorGestor(IArticuloProveedorGestor articuloProveedorGestor) {
		this.articuloProveedorGestor = articuloProveedorGestor;
	}

	/**
	 * @return the articuloRegistroSanitarioGestor
	 */
	public IArticuloRegistroSanitarioGestor getArticuloRegistroSanitarioGestor() {
		return articuloRegistroSanitarioGestor;
	}

	/**
	 * @param articuloRegistroSanitarioGestor the articuloRegistroSanitarioGestor to set
	 */
	public void setArticuloRegistroSanitarioGestor(IArticuloRegistroSanitarioGestor articuloRegistroSanitarioGestor) {
		this.articuloRegistroSanitarioGestor = articuloRegistroSanitarioGestor;
	}

	/**
	 * @param calculoArticuloProveedorNovedadGestor the calculoArticuloProveedorNovedadGestor to set
	 */
	public void setCalculoArticuloProveedorNovedadGestor(ICalculoArticuloProveedorNovedadGestor calculoArticuloProveedorNovedadGestor) {
		this.calculoArticuloProveedorNovedadGestor = calculoArticuloProveedorNovedadGestor;
	}

	/**
	 * @param validacionArticuloGestor the validacionArticuloGestor to set
	 */
	public final void setValidacionArticuloGestor(IValidacionArticuloGestor validacionArticuloGestor) {
		this.validacionArticuloGestor = validacionArticuloGestor;
	}
	public void setAlmacenamientoAuditoriaArticuloGestor(IAlmacenamientoAuditoriaArticuloGestor almacenamientoAuditoriaArticuloGestor) {
		this.almacenamientoAuditoriaArticuloGestor = almacenamientoAuditoriaArticuloGestor;
	}

	/**
	 * @param validacionArticuloReglasComercialesGestor the validacionArticuloReglasComercialesGestor to set
	 */
	public void setValidacionArticuloReglasComercialesGestor(IValidacionArticuloReglasComercialesGestor validacionArticuloReglasComercialesGestor) {
		this.validacionArticuloReglasComercialesGestor = validacionArticuloReglasComercialesGestor;
	}

	public IVistaCampoMercanciaDAO getCamposMercanciaDAO() {
		return camposMercanciaDAO;
	}

	public void setCamposMercanciaDAO(IVistaCampoMercanciaDAO camposMercanciaDAO) {
		this.camposMercanciaDAO = camposMercanciaDAO;
	}
	
	public Collection<ArticuloAsignacionLocalVO> obtenerArticuloLocal(ArticuloID articuloId , Integer tipoAreaTrabajoTic , String tipoAreaTrabajoValor , Boolean consultarCamposAsignacion)throws SICException{
		return this.calculoBusquedaArticuloGestor.obtenerArticuloLocal(articuloId , tipoAreaTrabajoTic , tipoAreaTrabajoValor , consultarCamposAsignacion);
	}
	public IParametroGestor getParametroGestor() {
		return parametroGestor;
	}

	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}
	
	/**
	 * @param articuloMercanciaGestor the articuloMercanciaGestor to set
	 */
	public void setArticuloMercanciaGestor(IArticuloMercanciaGestor articuloMercanciaGestor) {
		this.articuloMercanciaGestor = articuloMercanciaGestor;
	}

	public void setArticuloClaseGestor(IArticuloClaseGestor articuloClaseGestor) {
		this.articuloClaseGestor = articuloClaseGestor;
	}

	public void setCalculoArticuloLeyenda(ICalculoArticuloLeyenda calculoArticuloLeyenda) {
		this.calculoArticuloLeyenda = calculoArticuloLeyenda;
	}

	public void setArticuloNuevoImportadoDAO(IArticuloNuevoImportadoDAO articuloNuevoImportadoDAO) {
		this.articuloNuevoImportadoDAO = articuloNuevoImportadoDAO;
	}

	public void setArticuloLeyMercadoGestor(IArticuloLeyMercadoGestor articuloLeyMercadoGestor) {
		this.articuloLeyMercadoGestor = articuloLeyMercadoGestor;
	}

	public void setArticuloAgrupadorGestor(IArticuloAgrupadorGestor articuloAgrupadorGestor) {
		this.articuloAgrupadorGestor = articuloAgrupadorGestor;
	}

	public void setArticuloPrecioDiferenciadoGestor(IArticuloPrecioDiferenciadoGestor articuloPrecioDiferenciadoGestor) {
		this.articuloPrecioDiferenciadoGestor = articuloPrecioDiferenciadoGestor;
	}
	
	public void setArticuloEdicionMasivaGestor(IArticuloEdicionMasivaGestor articuloEdicionMasivaGestor) {
		this.articuloEdicionMasivaGestor = articuloEdicionMasivaGestor;
	}

	/**
	 * @author rali
	 * Accion que realiza la busqueda de artículos historicamente relacionados por su codigo de barras.
	 */
	public Collection<ArticuloDTO> obtenerArticulosCodigoBarras(Integer codigoCompania, String codbar, String codart) throws SICException {
      return this.articuloBitacoraGestor.obtenerArticuloPorCodBarras(codigoCompania, codbar, codart);
	}

	public void setArticuloIntegracionDAO(IArticuloIntegracionDAO articuloIntegracionDAO) {
		this.articuloIntegracionDAO = articuloIntegracionDAO;
	}

	@Override
	public ArticuloGeneralVO obtenerArticuloEtiqueta(Integer codigoCompania, String codigoBarras, String codigoFuncionario, String... clasificaciones) throws SICException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Obtiene la coleccion de articulos en base del articuloVO
	 * @param articuloVO
	 * @param codigoCompania
	 * @param obtenerRelaciones valor booleano que trae las relaciones de ArticuloDTO
	 * @param colClasificacionLeyMercado clasificaciones a las aplica la ley de mercado
	 * @return
	 * @throws SICException
	 * @author derazo
	 */
	@Override
	public Collection<ArticuloDTO> obtenerArticulosSinPaginar (ArticuloVO articuloVO, Integer codigoCompania, Boolean obtenerRelaciones, Collection <String> colClasificacionLeyMercado)throws SICException{
		if(codigoCompania == null){
			throw new SICException("No existe codigo compania.");
		}
		if(articuloVO == null){
			throw new SICException("No existe informacion para buscar los articulo.");
		}
		return this.articuloDAO.obtenerArticulosSinPaginar(articuloVO, codigoCompania,  obtenerRelaciones, colClasificacionLeyMercado);
	}
}
