/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.accion;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.integration.exception.IntegrationException;
import ec.com.integration.service.IntegrationServiceI;
import ec.com.integration.util.IntegrationUtil;
import ec.com.kruger.utilitario.dao.commons.annotations.RelationField.JoinType;
import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.exception.DAOException;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.dto.UbicacionTransaccionDivisionGeoPoliticaDTO;
import ec.com.smx.corpv2.etiquetado.modelo.dto.TagDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.frameworkv2.util.constants.CatalogTypeConstant;
import ec.com.smx.frameworkv2.util.constants.FrameworkConstants;
import ec.com.smx.mensajeria.commons.exception.MENSAJERIAException;
import ec.com.smx.mensajeria.commons.resources.MensajeriaMessages;
import ec.com.smx.mensajeria.dto.EventoDTO;
import ec.com.smx.mensajeria.dto.id.EventoID;
import ec.com.smx.mensajeria.estructura.MailMensajeEST;
import ec.com.smx.mensajeria.gestor.MensajeriaG;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICConstantesEnvioMail;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.cambioprecios.CambioPreciosUtil;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.GestionPrecioConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.accion.IAccionArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.IArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.accion.IAccionArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.proveedor.administracion.accion.IAccionIntegracionRegistroProveedorGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDuracionConservacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloTemporadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoVentaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.GrupoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloIntegracionDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloMigracionArticuloPortalDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.accion.IAccionArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.pendienteintegracion.IArticuloPendienteIntegracionDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.integracion.dto.CabeceraIDTO;
import ec.com.smx.sic.integracion.dto.articulo.ObtenerDatosRecepcionArticuloIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistrarClaseArticuloIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroArticuloDetalleIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroArticuloIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroArticuloLocalDetalleIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroArticuloLocalIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroArticuloRelacionadoDetalleIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroArticuloRelacionadoIDTO;
import ec.com.smx.sic.integracion.resources.SICIntegracionMessages;
import ec.com.smx.sic.integracion.util.SICIntegracion;
import ec.com.smx.sic.integracion.util.UtilIntegracion;

/**
 * @author fmunoz
 *
 */
public class AccionArticuloGestor implements IAccionArticuloGestor, Logeable{
	
	private IAccionArticuloProveedorGestor accionArticuloProveedorGestor;
	private IAccionIntegracionRegistroProveedorGestor accionIntegracionRegistroCondicionComercialGestor;
	private DataGestor dataGestor;
	private ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor;
	private ICalculoArticuloGestor calculoArticuloGestor;
	private IArticuloAlcanceGestor articuloAlcanceGestor;
	private IArticuloIntegracionDAO articuloIntegracionDAO;
	private IArticuloMigracionArticuloPortalDAO articuloMigracionArticuloPortalDAO;
	private MensajeriaG mensajeriaG;
	private final String STRING_CERO= "0";
	private final String STRING_VACIO= " ";
	//private final Double PRECIO_OMISION= 0.01d;
	private final String PRECIO_OMISION_STR = "0.01";
	private final String USUARIO_OMISION="FRM0";
	private DecimalFormat df = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US));
	private SimpleDateFormat simpleDateFormatSIC = new SimpleDateFormat("yyyyMMdd");
	private final String ORIGEN_NACIONAL_SIC= "N";
	private final String FECHA_OMISION = "00000000";
	private Boolean esIntegracionActiva = Boolean.TRUE;
	private IParametroGestor parametroGestor;
	private IArticuloPendienteIntegracionDAO articuloPendienteIntegracionDAO;
	private IAccionArticuloDAO articuloAccionDAO;
	
	/**
	 * Obtener los datos de recepcion de articulo
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	private ObtenerDatosRecepcionArticuloIDTO obtenerDatosRecepcionArticulo(Integer codigoCompania, String codigoBarras) throws SICException {

		ObtenerDatosRecepcionArticuloIDTO obtenerDatosRecepcionArticulo;
		
		try {
			obtenerDatosRecepcionArticulo = new ObtenerDatosRecepcionArticuloIDTO();
			obtenerDatosRecepcionArticulo.getControlProceso().setProceso(SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.obtenerDatosRecepcionArticulo"));
			obtenerDatosRecepcionArticulo.getControlProceso().setCodigoCompania(codigoCompania);
			obtenerDatosRecepcionArticulo.getControlProceso().setResultado(SICIntegracionMessages.getString("ec.com.smx.sic.integracion.resultado.proceso.falso"));
			obtenerDatosRecepcionArticulo.getControlProceso().setCodigoServicio(UtilIntegracion.CODIGOSERVICIO_GESTIONARARTICULO);
			
			//Codigo de barras
			obtenerDatosRecepcionArticulo.setCodigoBarras(codigoBarras);

			//Fecha recepcion
			obtenerDatosRecepcionArticulo.setFechaRecepcion(null);
			
			Logeable.LOG_SICV2.info("************** OBTENER DATOS RECEPCION **************");
			Logeable.LOG_SICV2.info("CODIGO COMPANIA: ..... {}", obtenerDatosRecepcionArticulo.getControlProceso().getCodigoCompania());
			Logeable.LOG_SICV2.info("CODIGO BARRAS: ....... {}", obtenerDatosRecepcionArticulo.getCodigoBarras());
			Logeable.LOG_SICV2.info("FECHA RECEPCION: ..... {}", obtenerDatosRecepcionArticulo.getFechaRecepcion());

			return obtenerDatosRecepcionArticulo;
		} catch (DAOException e) {
			throw new SICException(e);
		} catch (SICException e) {
			throw e;
		}
	}
	
	/**
	 * Integrar con el sic la obtencion de datos al momento de recibir un articulo
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @throws Exception
	 */
	@Override
	public String integrarDatosRecepcionArticuloSIC(Integer codigoCompania, String codigoBarras) throws Exception {
		try {
			if(permitirIntegracion(codigoCompania)) {

				ObtenerDatosRecepcionArticuloIDTO resultadoDatosRecepcionArticulo = (ObtenerDatosRecepcionArticuloIDTO) SICIntegracion.procesarMensaje(
						obtenerDatosRecepcionArticulo(codigoCompania, codigoBarras));

				//Integracion activa
				if(resultadoDatosRecepcionArticulo != null) {
					if(resultadoDatosRecepcionArticulo.getControlProceso().getResultado().equals(UtilIntegracion.PROCESADO) ||
							resultadoDatosRecepcionArticulo.getControlProceso().getResultado().equals(UtilIntegracion.PROCESADO_SIN_FECHA))
						//el formato de la fecha siempre devuelve yyyymmdd
						return resultadoDatosRecepcionArticulo.getFechaRecepcion();
					else 
						throw new SICException(resultadoDatosRecepcionArticulo.getControlProceso().getResultado());
				}
				else{
					Logeable.LOG_SICV2.info("Integracion no activa");
					throw new SICException("Integracion no activa");
				}
			}
		} catch (SICException e) {
			throw e;
		} catch (IntegrationException e) {
		    throw e;
		} catch (Exception e) {
			throw new SICException(e);
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.admin.accion.IAccionArticuloGestor#transferirDatosArticuloSIC(java.util.Collection)
	 */
	@Override
	public void transferirDatosArticuloSIC(Collection<ArticuloVO> articulos, Boolean esAsincrono, Object servicioIntegracion)throws SICException{
		
		ArticuloDTO articuloReferencia = articulos.iterator().next().getBaseDTO();
		//se verifica el parametro de integracion al SIC
		if(permitirIntegracion(articuloReferencia.getId().getCodigoCompania())){
			RegistroArticuloIDTO regArtRollBack = null;
			
			String tipoProceso = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.registro.articulo");
			Boolean usarIntegracionCompleta = articuloReferencia.getDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA) != null;
			if(usarIntegracionCompleta){
				tipoProceso = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.registro.articulo.max");
			}
			Collection<ArticuloProveedorDTO> artProCol = null;
			Collection<ArticuloLocalDTO> artLocCol = null;
			Collection<ArticuloRelacionDTO> artRelCol = null;
			Collection<ArticuloLocalDTO> artLocColAnterior = null;
			Collection<ArticuloRelacionDTO> artRelColAnterior = null;
			Map<Long, String> prototipos = new HashMap<Long, String>();
			Map<String, Integer> paises = new HashMap<String, Integer>();
			Map<String, String> tipoDistribucion = new HashMap<String, String>();
			Map<Long, String> tiposEtiqueta = new HashMap<Long, String>();
			Map<String, String> tiposUso = new HashMap<String, String>();
			Map<String, String> tiposAgrupador = new HashMap<String, String>();
			
			RegistroArticuloIDTO registroArticulo = null;
			int inicio = 0;
			int fin = SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
			int iteraciones = 1;
			int residuo = 0;
			try{
				iteraciones = articulos.size() / SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
				residuo = articulos.size() % SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
				Collection<ArticuloVO> subcoleccion = articulos;
				if(iteraciones == 0){
					iteraciones = 1;
				}else if(residuo > 0){
					iteraciones++;
				}
				
				//se envia los datos particionados
				for(int i = 1; i<=iteraciones;i++){
					if(iteraciones > 1){
						if(iteraciones > i){
							subcoleccion = ((List<ArticuloVO>)articulos).subList(inicio, fin);
						}else{
							subcoleccion = ((List<ArticuloVO>)articulos).subList(inicio, articulos.size());
						}
					}
					inicio = inicio + SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
					fin = fin + SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
					
					//se crea el objeto para enviar los datos del articulo
					registroArticulo = new RegistroArticuloIDTO();
					if(CollectionUtils.isNotEmpty(articulos)){
						registroArticulo.getControlProceso().setCodigoCompania(articulos.iterator().next().getBaseDTO().getId().getCodigoCompania());
					}					
					registroArticulo.getControlProceso().setProceso(tipoProceso);
					registroArticulo.setUsuarioRegistro(!articulos.isEmpty() ? articulos.iterator().next().getBaseDTO().getUserId() : USUARIO_OMISION);
					registroArticulo.setDetalle(new ArrayList<RegistroArticuloDetalleIDTO>());
					
					//se crea el objeto para enviar el rollback
					regArtRollBack = new RegistroArticuloIDTO();
					regArtRollBack.getControlProceso().setCodigoCompania(registroArticulo.getControlProceso().getCodigoCompania());
					regArtRollBack.getControlProceso().setProceso(tipoProceso);
					regArtRollBack.setUsuarioRegistro(registroArticulo.getUsuarioRegistro());
					
					for(ArticuloVO vo : subcoleccion){
						if(vo.getBaseDTO().getTransferirDatosSIC() && !vo.getBaseDTO().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO)){
							RegistroArticuloDetalleIDTO item = new RegistroArticuloDetalleIDTO();
							RegistroArticuloDetalleIDTO itemRollBack = new RegistroArticuloDetalleIDTO();
							
							if(esAsincrono){
								final String procesoIntegracion = (String)vo.getBaseDTO().getDynamicProperty(ArticuloTransient.PROCESO_INTEGRACION_SIC);
								if(TipoCatalogoArticulo.PROCESO_INTEGRACION_CREACIONARTICULO.equals(procesoIntegracion) || TipoCatalogoArticulo.PROCESO_INTEGRACION_ACTIVACIONARTICULO.equals(procesoIntegracion) 
										|| StringUtils.equals(TipoCatalogoArticulo.PROCESO_INTEGRACION_CREACIONMASIVAARTICULOS, procesoIntegracion)){
									item.setCodigoProveedor(vo.getBaseDTO().getArticuloProveedorCol().iterator().next().getVistaProveedor().getCodigoJDEProveedor());
								}
								if(TipoCatalogoArticulo.PROCESO_INTEGRACION_MODIFICACIONCODIGOBARRAS.equals(procesoIntegracion)){
									List<ArticuloBitacoraCodigoBarrasDTO> codigos = new ArrayList<ArticuloBitacoraCodigoBarrasDTO>(vo.getBaseDTO().getArtBitCodBarCol());
									//se ordena descendentemente por fecha de creacion
									Collections.sort(codigos, new Comparator<ArticuloBitacoraCodigoBarrasDTO>() {
										@Override
										public int compare(ArticuloBitacoraCodigoBarrasDTO o1, ArticuloBitacoraCodigoBarrasDTO o2) {
											return o2.getFechaRegistro().compareTo(o1.getFechaRegistro());
										}
									});
									//asigna el primer codigo de barras inactivo
									for(ArticuloBitacoraCodigoBarrasDTO ab : codigos){
										if(SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(ab.getEstadoArticuloBitacora())){
											item.setCodigoBarrasAnterior(ab.getId().getCodigoBarras());
											break;
										}
									}
								}
							}else if(usarIntegracionCompleta){
								completarDatosAlFinalizarCodificacion(vo, item);
							}
							//datos para reversa
							itemRollBack.setCodigoBarras(vo.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras());
							itemRollBack.setEstadoRollback(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							
							//---------------- DATOS PRINCIPALES ----------------
							item.setCodigoBarras(vo.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras());
							item.setCodigoBarrasPOS(vo.getBaseDTO().getCodigoBarrasActivo().getCodigoBarrasPOS());
							if(StringUtils.equals(item.getCodigoBarrasPOS(), SICConstantes.VALOR_NOASIGNADO)){
								item.setCodigoBarrasPOS(STRING_CERO);
							}

							if(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO.equals(vo.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo()) ) {
								item.setTipoCodigoBarras(SICArticuloConstantes.getInstancia().TIPOCODIGOBARRASSIC_INTERNO);
							}else{
								item.setTipoCodigoBarras(SICArticuloConstantes.getInstancia().TIPOCODIGOBARRASSIC_EXTERNO);
							}
							if(StringUtils.isNotEmpty(vo.getBaseDTO().getEstadoArticulo())){
								item.setEstado(vo.getBaseDTO().getEstadoArticulo());
							}
							if(StringUtils.isNotEmpty(vo.getBaseDTO().getDescripcionArticulo())){
								item.setDescripcionArticulo(vo.getBaseDTO().getDescripcionArticulo());
							}
							if(StringUtils.isNotEmpty(vo.getBaseDTO().getClaseArticulo())){
								item.setClaseArticulo(vo.getBaseDTO().getClaseArticulo());
							}
							if(StringUtils.isNotEmpty(vo.getBaseDTO().getCodigoClasificacion())){
								item.setCodigoClasificacion(vo.getBaseDTO().getCodigoClasificacion());
							}
							if(StringUtils.isNotEmpty(vo.getBaseDTO().getCodigoSubClasificacion())){
								item.setCodigoSubClasificacion(vo.getBaseDTO().getCodigoSubClasificacion());
							}
							if(StringUtils.isNotEmpty(vo.getBaseDTO().getValorEstadoTransgenico())){
								item.setEstadoTransgenico(vo.getBaseDTO().getValorEstadoTransgenico());
							}
							if(BooleanUtils.isTrue(vo.getBaseDTO().getIndicadorI())){
								item.setIndicadorI(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							}else{
								item.setIndicadorI(SICConstantes.ESTADO_INACTIVO_NUMERICO);
							}
							if(vo.getBaseDTO().getImportancia() != null){
								EstablecimientoDTO est = new EstablecimientoDTO();
								est.getId().setCodigoCompania(vo.getBaseDTO().getId().getCodigoCompania());
								est.getId().setCodigoEstablecimiento(vo.getBaseDTO().getImportancia());
								est = dataGestor.findUnique(est);
								if(est != null && StringUtils.isNotEmpty(est.getNombreCorto())){
									item.setImportancia(est.getNombreCorto());
								}
							}
							if(usarIntegracionCompleta){
								if(vo.getBaseDTO().getCodigoGrupoAlcance() != null){
									String prototipoAlcance = null;
									if(vo.getBaseDTO().getTieneGrupoAlcance() && 
											vo.getBaseDTO().getCodigoGrupoAlcance().compareTo(vo.getBaseDTO().getGrupoAlcanceDTO().getId().getCodigoGrupoTrabajo()) == 0){
										prototipoAlcance = vo.getBaseDTO().getGrupoAlcanceDTO().getCodigoReferencia();
									}else if(prototipos.get(vo.getBaseDTO().getCodigoGrupoAlcance()) != null){
										prototipoAlcance = prototipos.get(vo.getBaseDTO().getCodigoGrupoAlcance());
									}else{
										//se realiza la consulta sobre el grupo de trabajo
										GrupoTrabajoDTO gru = new GrupoTrabajoDTO();
										gru.getId().setCodigoCompania(vo.getBaseDTO().getId().getCodigoCompania());
										gru.getId().setCodigoGrupoTrabajo(vo.getBaseDTO().getCodigoGrupoAlcance());
										gru = dataGestor.findUnique(gru);
										prototipos.put(vo.getBaseDTO().getCodigoGrupoAlcance(), gru.getCodigoReferencia());
										prototipoAlcance = gru.getCodigoReferencia();
									}
									item.setPrototipoAlcance(prototipoAlcance);
								}else{
									item.setPrototipoAlcance(" ");
								}
								
								//------------- MEDIDAS ---------------
								asignarDatosMedida(vo, item);
								
								//----------- ARTICULO TEMPORADA -----------
								if(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada").equals(vo.getBaseDTO().getClaseArticulo())
										&& vo.getBaseDTO().getTieneArticuloTemporada()){
									item.setFechaInicioTemporada(simpleDateFormatSIC.format(vo.getBaseDTO().getArticuloTemporadaDTO().getFechaInicioTemporada()));
									item.setFechaFinTemporada(simpleDateFormatSIC.format(vo.getBaseDTO().getArticuloTemporadaDTO().getFechaFinTemporada()));
								}
								
								//------------- ARTICULO COMERCIAL ---------------
								asignarDatosComerciales(vo, item, paises);
								
								//------------------- PRECIOS -----------------------
								asignarDatosPrecio(vo, item);
								
								//------------------ GARANTIA ---------------------
								if(vo.getBaseDTO().getTieneArticuloGarantia()){
									item.setEstadoGarantia(vo.getBaseDTO().getArticuloGarantiaDTO().getEstadoGarantia());
								}
								
								if(vo.getBaseDTO().hasDynamicProperty("notificar")){
									item.setEstadoNotificacion(SICIntegracionMessages.ESTADO_ACTIVO_NUMERICO);
								}
								
								//------------------ CONSERVACION ---------------------
								if(vo.getBaseDTO().getArticuloDuracionConservacionCol() != null && !SearchDTO.isLazy(vo.getBaseDTO().getArticuloDuracionConservacionCol())){
									item.setDiasUtilCongelado(0);
									item.setDiasUtilRefrigerado(0);
									item.setTiempoVidaUtil(0);
									for(ArticuloDuracionConservacionDTO adur : vo.getBaseDTO().getArticuloDuracionConservacionCol()){
										if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(adur.getEstado())){
											if(SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO.equals(adur.getId().getValorTipoConservacion())){
												item.setDiasUtilCongelado(adur.getDiasVidaUtil());
											}else if(SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO.equals(adur.getId().getValorTipoConservacion())){
												item.setDiasUtilRefrigerado(adur.getDiasVidaUtil());
											}else if(SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL.equals(adur.getId().getValorTipoConservacion())){
												item.setTiempoVidaUtil(adur.getDiasVidaUtil());
											}
										}
									}
								}
								
								//---------------- ETIQUETAS --------------
								asignarDatosEtiqueta(vo, item, tiposEtiqueta);
								asignarDatosSemaforo(vo, item);
								
								//----------------- USOS ----------------
								asignarDatosUso(vo, item, tiposUso);
								
								//---------------------LOGISTICO ----------------------
								asignarDatosLogisticos(vo, item, tipoDistribucion);
							}
							
							//-------- registro sanitario ---------
							asignarDatosRegistroSanitario(vo, item);
							
							//----------------- AGRUPADORES -----------------
							asignarDatosAgrupadores(vo, item, tiposAgrupador);
							
							//se agrega el item al detalle
							registroArticulo.getDetalle().add(item);
							//se agrega el item para el proceso rollback
							if(vo.getBaseDTO().getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) != null){
								if(regArtRollBack.getDetalle() == null){
									regArtRollBack.setDetalle(new ArrayList<RegistroArticuloDetalleIDTO>());
								}
								regArtRollBack.getDetalle().add(itemRollBack);
							}
							
							//las siguientes relaciones solo se agregan si el articulo esta activo
							if(StringUtils.equals(vo.getBaseDTO().getEstadoArticulo(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
								//se aumenta la referencia al articulo en las relaciones articulo proveedor
								if(vo.getBaseDTO().getTieneArticuloProveedor()){
									for(ArticuloProveedorDTO ap : vo.getBaseDTO().getArticuloProveedorCol()){
										ap.setArticulo(vo.getBaseDTO());
										ap.setUserId(vo.getBaseDTO().getUserId());
									}
									if(artProCol == null){
										artProCol = new ArrayList<ArticuloProveedorDTO>();
									}
									artProCol.addAll(vo.getBaseDTO().getArticuloProveedorCol());
									LOG_SICV2.info("size proveedor: "+artProCol.size());
								}
								
								if(usarIntegracionCompleta){
									//articulo local
									if(vo.getBaseDTO().getTieneArticuloLocal()){
										for(ArticuloLocalDTO al : vo.getBaseDTO().getArticuloLocalCol()){
											al.setArticulo(vo.getBaseDTO());
											al.setUserId(vo.getBaseDTO().getUserId());
										}
										if(artLocCol == null){
											artLocCol = new ArrayList<ArticuloLocalDTO>();
										}
										artLocCol.addAll(vo.getBaseDTO().getArticuloLocalCol());
									}
									//articulo relacion
									if(vo.getBaseDTO().getArticuloRelacionCol() != null && !SearchDTO.isLazy(vo.getBaseDTO().getArticuloRelacionCol())){
										for(ArticuloRelacionDTO ar : vo.getBaseDTO().getArticuloRelacionCol()){
											ar.setArticulo(vo.getBaseDTO());
											ar.setUserId(vo.getBaseDTO().getUserId());
										}
										if(artRelCol == null){
											artRelCol = new ArrayList<ArticuloRelacionDTO>();
										}
										artRelCol.addAll(vo.getBaseDTO().getArticuloRelacionCol());
									}
									//datos originales
									if(vo.getBaseDTOAnterior()!= null){
										//articulo relacion
										if(vo.getBaseDTOAnterior().getTieneArticuloRelacionado()){
											for(ArticuloRelacionDTO ar : vo.getBaseDTOAnterior().getArticuloRelacionCol()){
												ar.setArticulo(vo.getBaseDTOAnterior());
											}
											if(artRelColAnterior == null){
												artRelColAnterior = new ArrayList<ArticuloRelacionDTO>();
											}
											artRelColAnterior.addAll(vo.getBaseDTOAnterior().getArticuloRelacionCol());
										}
										//articulo local
										if(vo.getBaseDTOAnterior().getTieneArticuloLocal()){
											for(ArticuloLocalDTO ar : vo.getBaseDTOAnterior().getArticuloLocalCol()){
												ar.setArticulo(vo.getBaseDTOAnterior());
											}
											if(artLocColAnterior == null){
												artLocColAnterior = new ArrayList<ArticuloLocalDTO>();
											}
											artLocColAnterior.addAll(vo.getBaseDTOAnterior().getArticuloLocalCol());
										}
									}
								}
							}
						}
					}
					
					//inicia la integracion
					if(CollectionUtils.isNotEmpty(registroArticulo.getDetalle())){
						
						//1.- primero se debe enviar las condiciones comerciales para que se pueda crear en el proveedor y puedan ser asignas al articulo si es creacion
						//enviar condiciones comerciales
						if(CollectionUtils.isNotEmpty(artProCol)){
							this.enviarCondicionesComercialesAlSic(artProCol);
						}
						
						IntegrationServiceI integrationServiceI = (IntegrationServiceI)servicioIntegracion;
						if(integrationServiceI == null){
							integrationServiceI = SICIntegracion.iniciarConexion(registroArticulo.getControlProceso().getCodigoServicio());
						}
						
						SICIntegracion.procesarMensaje(registroArticulo, integrationServiceI);
						// si tiene proveedores que enviar
						if(CollectionUtils.isNotEmpty(artProCol)){
							ArticuloProveedorDTO apReferencia = artProCol.iterator().next();
							if(usarIntegracionCompleta){
								apReferencia.addDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA, Boolean.TRUE);
							}else{
								apReferencia.removeDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA);
							}
							
							LOG_SICV2.info("-----------------------------------------------------");
							LOG_SICV2.info("Se va a procesar la integracion de articulo proveedor");
							LOG_SICV2.info("-----------------------------------------------------");
							accionArticuloProveedorGestor.transferirDatosArticuloProveedorSIC(artProCol, esAsincrono, integrationServiceI);
						
						}
						if(usarIntegracionCompleta){
							this.transferirDatosArticuloLocal(artLocCol, artLocColAnterior, articuloReferencia, integrationServiceI);
							this.transferirDatosArticuloRelacion(artRelCol, artRelColAnterior, articuloReferencia, integrationServiceI);
						}
						
					}
					registroArticulo = null;
				}
	
			}catch (SICException e) {
				if(!esAsincrono && SICIntegracionMessages.CODIGO_ERROR_INTEGRACION.equals(e.getCodigoError())){
					procesoRollBack(regArtRollBack, e.getMessage());
				}
				throw e;
			}catch (IntegrationException e) {
				String mensaje = "";
				if(e.getMessage()!= null && e.getMessage().startsWith(SICIntegracionMessages.CODIGO_ERROR_INTEGRACION)){
					mensaje = e.getMessage();
				}
				if(e.getMessage()!= null && e.getMessage().contains("2033")){
					mensaje = "Ha ocurrido un error de comunicaci\u00F3n con SIC.";
				}
				if(!esAsincrono){
					procesoRollBack(regArtRollBack, mensaje);
				}
				throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo").concat(" en el SIC: ").concat(mensaje), e);
			}catch (Exception e) {
				throw new SICException("Error al intentar enviar el art\u00EDculo al SIC",e);
			}finally{
				registroArticulo = null;artProCol = null;artLocCol=null;artRelCol=null;artRelColAnterior=null;artLocColAnterior=null;
				prototipos = null;paises=null;tipoDistribucion=null;tiposEtiqueta = null;tiposUso=null;tiposAgrupador=null;
			}
		}
	}
	
	
	/**
	 * 
	 */
	private void enviarCondicionesComercialesAlSic(Collection<ArticuloProveedorDTO> artProCol){
		
		if( CollectionUtils.isNotEmpty(artProCol) ){
			
			Set<CondicionComercialEmbeddable> condicionComercialEmbeddables = null;
			
			condicionComercialEmbeddables = this.obtenerIntegracionCondicionComercialEmbeddable(artProCol);
			
			if( CollectionUtils.isNotEmpty(condicionComercialEmbeddables) ){
				
				LOG_SICV2.info("----------------------------------------------------------");
				LOG_SICV2.info("Se va a procesar la integracion de condiciones comerciales");
				LOG_SICV2.info("----------------------------------------------------------");
				
				for( CondicionComercialEmbeddable comercialEmbeddable : condicionComercialEmbeddables ){
					
					this.accionIntegracionRegistroCondicionComercialGestor.integrarProveedorClasificacionSIC(comercialEmbeddable.getCodigoCompania(), comercialEmbeddable.getCodigoProveedor(), comercialEmbeddable.getCodigoJDEProveedor(), comercialEmbeddable.getIdUsuarioActual(), comercialEmbeddable.getCodigosClasificacion());
					
				}
				
			}
			
		}
	}
	
	/**
	 * 
	 * @param artProCol
	 * @return
	 */
	private Set<CondicionComercialEmbeddable> obtenerIntegracionCondicionComercialEmbeddable(Collection<ArticuloProveedorDTO> artProCol){
		if( CollectionUtils.isNotEmpty(artProCol) ){
				
			//ordena por proveedor
			Collections.sort((List<ArticuloProveedorDTO>)artProCol, new Comparator<ArticuloProveedorDTO>(){

				@Override
				public int compare(ArticuloProveedorDTO articuloProveedorDTO1, ArticuloProveedorDTO articuloProveedorDTO2) {
					return articuloProveedorDTO1.getId().getCodigoProveedor().compareTo(articuloProveedorDTO2.getId().getCodigoProveedor());
				}
				
			});
			
			String codigoProveedor = null;
			Set<AccionArticuloGestor.CondicionComercialEmbeddable> condicionesComercial = null;
			CondicionComercialEmbeddable condicionComercialEmbeddable =  null;
			Set<String> codigosClasificacion = null;
			
			condicionesComercial = new LinkedHashSet<AccionArticuloGestor.CondicionComercialEmbeddable>();
			
			for( ArticuloProveedorDTO articuloProveedorDTO : artProCol ){
				
				//verifica si es proceso de creacion
				final String procesoIntegracion = (String)articuloProveedorDTO.getArticulo().getDynamicProperty(ArticuloTransient.PROCESO_INTEGRACION_SIC);
				final Boolean esProcesoCreacion = TipoCatalogoArticulo.PROCESO_INTEGRACION_CREACIONARTICULO.equals(procesoIntegracion) || TipoCatalogoArticulo.PROCESO_INTEGRACION_ACTIVACIONARTICULO.equals(procesoIntegracion);
				
				if( articuloProveedorDTO.getTieneArticulo() && articuloProveedorDTO.getTieneVistaProveedor() && esProcesoCreacion ){
					
					if( !StringUtils.equals(articuloProveedorDTO.getId().getCodigoProveedor(), codigoProveedor) ){
						
						//inicializa las clasificaciones
						codigosClasificacion = new TreeSet<String>();
						//asigana el proveedor
						codigoProveedor = articuloProveedorDTO.getId().getCodigoProveedor();
						//inicializa CondicionComercialEmbeddable
						condicionComercialEmbeddable = new CondicionComercialEmbeddable(articuloProveedorDTO.getId().getCodigoCompania(), articuloProveedorDTO.getId().getCodigoProveedor(), articuloProveedorDTO.getVistaProveedor().getCodigoJDEProveedor(), articuloProveedorDTO.getIdUsuarioRegistro(), codigosClasificacion);
						//agrega CondicionComercialEmbeddable
						condicionesComercial.add(condicionComercialEmbeddable);
						
					}
					
					codigosClasificacion.add(articuloProveedorDTO.getArticulo().getCodigoClasificacion());
				}
			}
			
			return condicionesComercial;
		}
		return null;
	}
	
	

	private void procesoRollBack(RegistroArticuloIDTO regArtRollBack, String mensajeOriginal){
		if(regArtRollBack != null && CollectionUtils.isNotEmpty(regArtRollBack.getDetalle())){
			try{
				SICIntegracion.procesarMensaje(regArtRollBack);
			}catch(Exception e1){throw new SICException(mensajeOriginal.concat(" ").concat(SICArticuloMessages.getInstancia().getString("mensaje.error.reversa.integracion")),e1);}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void asignarDatosEtiqueta(ArticuloVO vo, RegistroArticuloDetalleIDTO item, Map<Long, String> tiposEtiqueta){
		if(vo.getBaseDTO().getArticuloEtiquetaCol() != null && !SearchDTO.isLazy(vo.getBaseDTO().getArticuloEtiquetaCol())){
			//obtiene todas las etiquetas activas
			Collection<ArticuloEtiquetaDTO> etiquetasActivas = CollectionUtils.select(vo.getBaseDTO().getArticuloEtiquetaCol(), new BeanPredicate("estado", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
			item.setTipoEtiqueta(STRING_CERO);
			if( CollectionUtils.isNotEmpty(etiquetasActivas) ){
				for( final ArticuloEtiquetaDTO articuloEtiquetaDTO : etiquetasActivas ){
					//verifica que la etiqueta sea para preciar articulo y que tenga el codigo de referencia para enviar al SIC
					if(articuloEtiquetaDTO.getTieneTagDTO()){
						if(StringUtils.equals(FrameworkConstants.ETIQUETA_PRECIAR_ARTICULO, articuloEtiquetaDTO.getTagDTO().getGroupTagValue()) && 
							StringUtils.isNotEmpty(articuloEtiquetaDTO.getTagDTO().getReferenceCode() )){
							item.setTipoEtiqueta(articuloEtiquetaDTO.getTagDTO().getReferenceCode());
						}
					//si el mapa contiene el codigo de la etiqueta en el mapa asiga
					}else if(tiposEtiqueta.get(articuloEtiquetaDTO.getId().getTagCode()) != null){
						item.setTipoEtiqueta(tiposEtiqueta.get(articuloEtiquetaDTO.getId().getTagCode()));
					}else{
						//si la etiqueta no tiene la relacion TagDTO buscamos para posterioermente guardar en el mapa y sacar el codigo de referencia para enviar al SIC
						TagDTO tagDTO = new TagDTO();
						tagDTO.getId().setTagCode(articuloEtiquetaDTO.getId().getTagCode());
						tagDTO.setGroupTagValue(FrameworkConstants.ETIQUETA_PRECIAR_ARTICULO);
						tagDTO.setGroupTagType(CatalogTypeConstant.TIPO_ETIQUETAS);
						
						tagDTO = dataGestor.findUnique(tagDTO);
						if( tagDTO != null ){
							tiposEtiqueta.put(articuloEtiquetaDTO.getId().getTagCode(), tagDTO.getReferenceCode());
							item.setTipoEtiqueta(tagDTO.getReferenceCode());
						}
					}
				}
				
			}
			
		}
	}
	
	@SuppressWarnings("unchecked")
	private void asignarDatosSemaforo(ArticuloVO vo, RegistroArticuloDetalleIDTO item){
		if(vo.getBaseDTO().getArticuloEtiquetaCol() != null && !SearchDTO.isLazy(vo.getBaseDTO().getArticuloEtiquetaCol())){
			//obtiene todas las etiquetas activas
			Collection<ArticuloEtiquetaDTO> etiquetasActivas = CollectionUtils.select(vo.getBaseDTO().getArticuloEtiquetaCol(), new BeanPredicate("estado", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
			item.setSemaforo(STRING_CERO);
			if(CollectionUtils.isNotEmpty(etiquetasActivas) ){
				for( final ArticuloEtiquetaDTO articuloEtiquetaDTO : etiquetasActivas ){					
					//verifica que la etiqueta sea semaforo para enviar al SIC
					if(articuloEtiquetaDTO.getId().getTagCode().compareTo(SICArticuloConstantes.getInstancia().ETIQUETA_SEMAFORO) == 0){
						item.setSemaforo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					}
				}
			}
		}
	}
	
	private void asignarDatosRegistroSanitario(ArticuloVO vo, RegistroArticuloDetalleIDTO item){
//		if(BooleanUtils.isFalse(vo.getBaseDTO().getAplicaRegistroSanitario())){
		if(	vo.getBaseDTO().getValorAplicaRegistroSanitario() != null && vo.getBaseDTO().getCodigoAplicaRegistroSanitario() != null &&
			TipoCatalogoArticulo.TIPO_ESTADO_APLICA_REGISTRO_SANITARIO.compareTo(vo.getBaseDTO().getCodigoAplicaRegistroSanitario()) == 0 &&
			(	StringUtils.equals(vo.getBaseDTO().getValorAplicaRegistroSanitario(),TipoCatalogoArticulo.VALOR_NO_APLICA_REGISTRO_SANITARIO) ||
				StringUtils.equals(vo.getBaseDTO().getValorAplicaRegistroSanitario(),TipoCatalogoArticulo.VALOR_NUNCA_APLICA_REGISTRO_SANITARIO)
			)){
			item.setRegistroSanitario(STRING_VACIO);
			item.setFechaCaducidadRegistroSanitario(FECHA_OMISION);
		}else if(SearchDTO.isLoaded(vo.getBaseDTO().getRegistroSanitarioCol())){
			for(RelacionArticuloRegistroSanitarioDTO dto : vo.getBaseDTO().getRegistroSanitarioCol()){
				if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(dto.getEstado())
						&& TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO.equals(dto.getRegistroSanitario().getValorTipoEstudioNutricional())){
					item.setRegistroSanitario(dto.getRegistroSanitario().getRegistroSanitario());
					item.setFechaCaducidadRegistroSanitario(dto.getRegistroSanitario().getFechaCaducidadRegistroSanitario() != null ? simpleDateFormatSIC.format(dto.getRegistroSanitario().getFechaCaducidadRegistroSanitario()) : FECHA_OMISION);
					break;
				}
			}
		}
	}
	
	private void asignarDatosMedida(ArticuloVO vo, RegistroArticuloDetalleIDTO item){
		if(vo.getBaseDTO().getTieneArticuloMedida()){
			if(vo.getBaseDTO().getArticuloMedidaDTO().getCantidadMedida() != null){
				item.setCantidadMedida(vo.getBaseDTO().getArticuloMedidaDTO().getCantidadMedida());
			}else{item.setCantidadMedida(1d);}
			
			if(StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloMedidaDTO().getValorTipoMedida()) && 
					!vo.getBaseDTO().getArticuloMedidaDTO().getValorTipoMedida().equals(SICConstantes.VALOR_NOASIGNADO)){
				item.setUnidadMedida(vo.getBaseDTO().getArticuloMedidaDTO().getValorTipoMedida());
			}else{
				item.setUnidadMedida(SICArticuloConstantes.getInstancia().TIPOMEDIDA_NOAPLICA_SIC);
			}
			if(vo.getBaseDTO().getArticuloMedidaDTO().getPresentacion() != null){
				item.setPresentacion(vo.getBaseDTO().getArticuloMedidaDTO().getPresentacion());
			}
			if(StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloMedidaDTO().getReferenciaMedida())){
				item.setReferenciaMedida(vo.getBaseDTO().getArticuloMedidaDTO().getReferenciaMedida());
			}else{
				item.setReferenciaMedida("UNID");
			}
		}
	}
	
	private void asignarDatosComerciales(ArticuloVO vo, RegistroArticuloDetalleIDTO item, Map<String, Integer> paises){
		if(vo.getBaseDTO().getTieneArticuloComercial()){
			if(StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloComercialDTO().getValorTipoControlCosto()) && 
					!SICConstantes.VALOR_NOASIGNADO.equals(vo.getBaseDTO().getArticuloComercialDTO().getValorTipoControlCosto())){
				item.setTipoControlPrecio(vo.getBaseDTO().getArticuloComercialDTO().getValorTipoControlCosto());}
			if(vo.getBaseDTO().getArticuloComercialDTO().getPesoAproximadoVenta() != null){
				item.setPesoAproximadoVenta(SICUtil.getInstance().roundNumber(vo.getBaseDTO().getArticuloComercialDTO().getPesoAproximadoVenta(), 2));
			}else{item.setPesoAproximadoVenta(0d);}
			
			if(vo.getBaseDTO().getArticuloComercialDTO().getPesoAproximadoRecepcion() != null){
				item.setPesoAproximadoRecepcion(SICUtil.getInstance().roundNumber(vo.getBaseDTO().getArticuloComercialDTO().getPesoAproximadoRecepcion(), 2));
			}else{item.setPesoAproximadoRecepcion(0d);}
			
			//-------------------------- TODO temporal para pruebas --------------------------
//			item.setPaisOrigen(SICConstantes.CODIGO_ECUADOR_SIC);
//			item.setEstadoOrigen("N");
			
			if(vo.getBaseDTO().getArticuloComercialDTO().getCodigoLugarCompra() != null){
				if(SICArticuloConstantes.CODIGO_LUGAR_COMPRA_ECUADOR.equals(vo.getBaseDTO().getArticuloComercialDTO().getCodigoLugarCompra())){
					item.setPaisOrigen(SICConstantes.CODIGO_ECUADOR_SIC);
				}else if(paises.get(vo.getBaseDTO().getArticuloComercialDTO().getCodigoLugarCompra()) != null){
					item.setPaisOrigen(paises.get(vo.getBaseDTO().getArticuloComercialDTO().getCodigoLugarCompra()));
				}else{
					UbicacionTransaccionDivisionGeoPoliticaDTO lc = null;
					if(SearchDTO.isLoaded(vo.getBaseDTO().getArticuloComercialDTO().getUbicacionTransaccionDivisionGeoPoliticaDTO())
							&& StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloComercialDTO().getUbicacionTransaccionDivisionGeoPoliticaDTO().getCodigoReferencia())){
						lc = vo.getBaseDTO().getArticuloComercialDTO().getUbicacionTransaccionDivisionGeoPoliticaDTO();
					}else{
						lc = new UbicacionTransaccionDivisionGeoPoliticaDTO();
						lc.getId().setCodigoUbicacionTransaccionDivisionGeoPolitica(vo.getBaseDTO().getArticuloComercialDTO().getCodigoLugarCompra());
						lc.getId().setCodigoCompania(vo.getBaseDTO().getArticuloComercialDTO().getId().getCodigoCompania());
						lc = dataGestor.findUnique(lc);
					}
					item.setPaisOrigen(Integer.valueOf(lc.getCodigoReferencia()));
					paises.put(String.valueOf(vo.getBaseDTO().getArticuloComercialDTO().getCodigoLugarCompra()), item.getPaisOrigen());
				}
				item.setEstadoOrigen(vo.getBaseDTO().getArticuloComercialDTO().getEstadoOrigenArticulo());
			}else{
				item.setPaisOrigen(SICConstantes.CODIGO_ECUADOR_SIC);
				item.setEstadoOrigen(ORIGEN_NACIONAL_SIC);
			}
			
			if(vo.getBaseDTO().getArticuloComercialDTO().getMarcaParticipaciones() != null){
				if(vo.getBaseDTO().getArticuloComercialDTO().getMarcaParticipaciones().length() == 1){
					item.setMarcaParticipaciones(vo.getBaseDTO().getArticuloComercialDTO().getMarcaParticipaciones());
				}
			}else{
				item.setMarcaParticipaciones(STRING_VACIO);
			}
			
			if(vo.getBaseDTO().getArticuloComercialDTO().getCodigoMarcaComercial() != null){
				item.setCodigoMarcaComercial(vo.getBaseDTO().getArticuloComercialDTO().getCodigoMarcaComercial());
			}else{
				item.setCodigoMarcaComercial(0l);
			}
			
			if(vo.getBaseDTO().getArticuloComercialDTO().getVerFecCadRec()){
				item.setIndicadorFechaCaducidad(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			}else{
				item.setIndicadorFechaCaducidad(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			}
			
			if(StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloComercialDTO().getValorTipoDeducible())){
				item.setDeducible(vo.getBaseDTO().getArticuloComercialDTO().getValorTipoDeducible());
			}else{
				item.setDeducible(STRING_VACIO);
			}
			
			item.setVentaPrecioAfiliado(BooleanUtils.isTrue(vo.getBaseDTO().getArticuloComercialDTO().getVentaPrecioAfiliado()) ? SICConstantes.ESTADO_ACTIVO_NUMERICO : SICConstantes.ESTADO_INACTIVO_NUMERICO);
		}
	}
	
	private void asignarDatosPrecio(ArticuloVO vo, RegistroArticuloDetalleIDTO item){
		
		if(vo.getBaseDTO().getCodigoTipoArticulo().equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON)){
			//asignacion de precios para los cupones
			item.setPvp(PRECIO_OMISION_STR);
			item.setPrecioBase(PRECIO_OMISION_STR);
			item.setPrecioPacto(PRECIO_OMISION_STR);
			Double valor = null;
			if(vo.getBaseDTO().getTieneDescuentoVentaArticulo()){
				for(DescuentoVentaArticuloDTO dto : vo.getBaseDTO().getDescuentoVentaArticuloCol()){
					if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(dto.getEstado()) && dto.getValorDescuento() != null && dto.getValorDescuento() > 0){
						valor = dto.getValorDescuento();
						break;
					}
				}
			}
			if(valor == null){
				for(ArticuloPrecioDTO ap : vo.getBaseDTO().getArticuloPrecioCol()){
					if(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE.equals(ap.getId().getCodigoTipoPrecio())){
						valor = ap.getValorActual();
					}
				}
			}
			if(valor != null){
				item.setPvp(df.format(valor));
				item.setPrecioBase(df.format(valor));
				item.setPrecioPacto(df.format(valor));
			}
		}else if(vo.getBaseDTO().getTieneArticuloPrecio()){
			item.setUnidadMayoreo(Integer.valueOf(STRING_CERO));
			item.setDescuentoMayoreo(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(Double.valueOf(STRING_CERO)));
			for(ArticuloPrecioDTO ap : vo.getBaseDTO().getArticuloPrecioCol()){
				if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP)){
					item.setPvp(df.format(ap.getValorActual()));
				}else if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)){
					//ap.getArticulo().setDescuentoVentaArticuloCol(vo.getBaseDTO().getDescuentoVentaArticuloCol());
					item.setPrecioBase(df.format(ap.getValorActual()));
					item.setPrecioPacto(df.format(calculoArticuloGestor.calcularPrecioBaseSinDescuento(ap)));
					double descuentoPacto = 0;
					for(DescuentoVentaArticuloDTO dva : vo.getBaseDTO().getDescuentoVentaArticuloCol()){
						if(dva.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
							descuentoPacto = descuentoPacto + dva.getPorcentajeDescuento().doubleValue();
						}
					}
					item.setDescuentoPacto(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(descuentoPacto));
					
				}else if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA) && 
					SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(ap.getEstadoPrecio()) && 
					ap.getTieneArticuloUnidadManejo() && SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(ap.getArticuloUnidadManejo().getEstadoUnidadManejo())){					
						item.setUnidadMayoreo(ap.getArticuloUnidadManejo().getValorUnidadManejo());
						item.setDescuentoMayoreo(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(ap.getArticuloUnidadManejo().getDescuentoVenta()));	
					
				}else if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA)
						&& SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(ap.getEstadoPrecio())
						&& ap.getTieneArticuloUnidadManejo() && SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(ap.getArticuloUnidadManejo().getEstadoUnidadManejo())){
					item.setDescuentoCaja(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(ap.getArticuloUnidadManejo().getDescuentoVenta()));
				}
			}
		}

		//----------------- IMPUESTOS ----------------------
		if(vo.getBaseDTO().getArticuloImpuestoCol()!= null && !SearchDTO.isLazy(vo.getBaseDTO().getArticuloImpuestoCol())){
			//se inicializan los impuestos
			item.setImpuestoVerdeCompra(0d);
			item.setImpuestoVerdeVenta(0d);
			item.setPorcentajeIVACompra(0d);
			item.setPorcentajeIVAVenta(0d);
			
			ArticuloImpuestoDTO articuloImpuestoDTO = (ArticuloImpuestoDTO)CollectionUtils.find(vo.getBaseDTO().getArticuloImpuestoCol(), new Predicate() {
				@Override
				public boolean evaluate(Object arg0) {
					ArticuloImpuestoDTO artimp = (ArticuloImpuestoDTO)arg0;
					return SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA.equals(artimp.getId().getCodigoTipoImpuesto())
							&& SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(artimp.getEstadoArticuloImpuesto());
				}
			});
			if(articuloImpuestoDTO != null){
				item.setPorcentajeIVACompra(articuloImpuestoDTO.getEsParaCompra() ? articuloImpuestoDTO.getTipoImpuestoArticulo().getPorcentajeImpuesto() : 0d);
				item.setPorcentajeIVAVenta(articuloImpuestoDTO.getEsParaVenta() ? articuloImpuestoDTO.getTipoImpuestoArticulo().getPorcentajeImpuesto() : 0d);
			}
			
			if(!vo.getBaseDTO().getCodigoTipoArticulo().equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON)){
				articuloImpuestoDTO = (ArticuloImpuestoDTO)CollectionUtils.find(vo.getBaseDTO().getArticuloImpuestoCol(), new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
						ArticuloImpuestoDTO artimp = (ArticuloImpuestoDTO)arg0;
						return SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVE.equals(artimp.getId().getCodigoTipoImpuesto())
								&& SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(artimp.getEstadoArticuloImpuesto());
					}
				});
				if(articuloImpuestoDTO != null){
					item.setImpuestoVerdeCompra(articuloImpuestoDTO.getTipoImpuestoArticulo().getValorImpuesto());
					item.setImpuestoVerdeVenta(articuloImpuestoDTO.getTipoImpuestoArticulo().getValorImpuesto());
				}
			}
		}
	}
	
	private void asignarDatosLogisticos(ArticuloVO vo, RegistroArticuloDetalleIDTO item, Map<String, String> tipoDistribucion){
		if(vo.getBaseDTO().getTieneArticuloProcesoLogistico()){
			if(StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorTipoDistribucion())
					&& !vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorTipoDistribucion().equals(SICConstantes.VALOR_NOASIGNADO)){
				
				if(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getTieneTipoDistribucion()
						&& StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getTipoDistribucion().getCodigoExterno())){
					item.setTipoDistribucion(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getTipoDistribucion().getCodigoExterno());
				}else if(tipoDistribucion.get(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorTipoDistribucion()) != null){
					item.setTipoDistribucion(tipoDistribucion.get(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorTipoDistribucion()));
				}else{
					CatalogoValorDTO cat = new CatalogoValorDTO();
					cat.getId().setCodigoCatalogoTipo(SICArticuloConstantes.getInstancia().CODIGOCATALOGO_TIPODISTRIBUCION);
					cat.getId().setCodigoCatalogoValor(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorTipoDistribucion());
					cat = dataGestor.findUnique(cat);
					item.setTipoDistribucion(cat.getCodigoExterno());
					tipoDistribucion.put(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorTipoDistribucion(), cat.getCodigoExterno());
				}
			}else{
				item.setTipoDistribucion(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			}
			
			if(StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorContenedorDistribucion())
					&& !vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorContenedorDistribucion().equals(SICConstantes.VALOR_NOASIGNADO)){
				item.setPalletizado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			}else{
				item.setPalletizado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			}
			
			item.setTieneTara(BooleanUtils.isTrue(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getTieneTara()) ? SICConstantes.ESTADO_ACTIVO_NUMERICO : SICConstantes.ESTADO_INACTIVO_NUMERICO);
			if(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getCodigoIndicadorPropietario() != null){
				item.setIndicadorPropietario(String.valueOf(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getCodigoIndicadorPropietario()));
			}else{
				item.setIndicadorPropietario(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			}
			
			if(StringUtils.isNotEmpty(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorAreaConservacionBodega())
					&& !vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorAreaConservacionBodega().equals(SICConstantes.VALOR_NOASIGNADO)){
				item.setAreaBodega(vo.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorAreaConservacionBodega());
			}
		}
	}
	
	private void asignarDatosAgrupadores(ArticuloVO vo, RegistroArticuloDetalleIDTO item, Map<String, String> tiposAgrupador){
		//TODO el campo TOP todavia no se va a pasar al SIC hasta que el BI se integre con MAX
		if(vo.getBaseDTO().getArticuloAgrupadorCol() != null && !SearchDTO.isLazy(vo.getBaseDTO().getArticuloAgrupadorCol())){
			String agrupador = null;
			item.setProductoInteligente(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			for(ArticuloAgrupadorDTO agr : vo.getBaseDTO().getArticuloAgrupadorCol()){
				//solo si es activo y pertenece al catalogo correcto
				if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(agr.getEstado())
						&& !SICConstantes.VALOR_NOASIGNADO.equals(agr.getId().getValorTipoAgrupador())){
					if(SICArticuloConstantes.getInstancia().CATALOGOTIPO_AGRUPADOR.equals(agr.getId().getCodigoTipoAgrupador())){
						if(SearchDTO.isLoaded(agr.getTipoAgrupador()) && StringUtils.isNotEmpty(agr.getTipoAgrupador().getCodigoExterno())){
							agrupador = agr.getTipoAgrupador().getCodigoExterno();
						}else if(tiposAgrupador.get(agr.getId().getValorTipoAgrupador()) != null){
							agrupador = tiposAgrupador.get(agr.getId().getValorTipoAgrupador());
						}else{
							CatalogoValorDTO cat = new CatalogoValorDTO();
							cat.getId().setCodigoCatalogoTipo(SICArticuloConstantes.getInstancia().CATALOGOTIPO_AGRUPADOR);
							cat.getId().setCodigoCatalogoValor(agr.getId().getValorTipoAgrupador());
							cat = dataGestor.findUnique(cat);
							if(StringUtils.isNotEmpty(cat.getCodigoExterno())){
								agrupador = cat.getCodigoExterno();
								tiposAgrupador.put(agr.getId().getValorTipoAgrupador(), cat.getCodigoExterno());
							}
						}
						if(agrupador != null){
							item.setAgrupador(Integer.valueOf(agrupador));
							break;
						}
					}
					else if(TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES.equals(agr.getId().getCodigoTipoAgrupador()) && StringUtils.equals(TipoCatalogoArticulo.PRODUCTO_INTELIGENTE, agr.getId().getValorTipoAgrupador())){
						item.setProductoInteligente(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					}
				}
			}
		}
	}
	
	private void asignarDatosUso(ArticuloVO vo, RegistroArticuloDetalleIDTO item, Map<String, String> tiposUso){
		if(vo.getBaseDTO().getArticuloUsoCol() != null && !SearchDTO.isLazy(vo.getBaseDTO().getArticuloUsoCol())){
			int cont = 1;
			String tipoUso = null;
			item.setUso1(STRING_CERO);
			item.setUso2(STRING_CERO);
			
			ArticuloUsoDTO todoUso = (ArticuloUsoDTO) CollectionUtils.find(vo.getBaseDTO().getArticuloUsoCol(), new BeanPredicate("id.valorTipoUso", PredicateUtils.equalPredicate(TipoCatalogoArticulo.VALOR_USO_CARNES_TODO_USO)));
			
			if(todoUso != null && SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(todoUso.getEstado()) && SearchDTO.isLoaded(todoUso.getTipoUso()) && StringUtils.isNotEmpty(todoUso.getTipoUso().getCodigoExterno())){
				tipoUso = todoUso.getTipoUso().getCodigoExterno();
				item.setUso1(tipoUso);
				item.setUso2(tipoUso);
			}else{
				for(ArticuloUsoDTO uso : vo.getBaseDTO().getArticuloUsoCol()){
					if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(uso.getEstado())
							&& !SICConstantes.VALOR_NOASIGNADO.equals(uso.getId().getValorTipoUso())){
						if(cont == 3){break;}
						if(SearchDTO.isLoaded(uso.getTipoUso()) && StringUtils.isNotEmpty(uso.getTipoUso().getCodigoExterno())){
							tipoUso = uso.getTipoUso().getCodigoExterno();
						}else if(tiposUso.get(uso.getId().getValorTipoUso()) != null){
							tipoUso = tiposUso.get(uso.getId().getValorTipoUso());
						}else{
							CatalogoValorDTO cat = new CatalogoValorDTO();
							cat.getId().setCodigoCatalogoTipo(TipoCatalogoArticulo.TIPOS_USO_CARNES);
							cat.getId().setCodigoCatalogoValor(uso.getId().getValorTipoUso());
							cat = dataGestor.findUnique(cat);
							tipoUso = cat.getCodigoExterno();
							tiposUso.put(uso.getId().getValorTipoUso(), cat.getCodigoExterno());
						}
						
						if(cont == 1){
							item.setUso1(tipoUso);
						}else{
							item.setUso2(tipoUso);
						}
						cont ++;
					}
				}
			}
			
			
		}
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.admin.accion.IAccionArticuloGestor#transferirDatosArticuloSIC(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO)
	 */
	@Override
	public void transferirDatosArticuloSIC(ArticuloVO articulo, Boolean esAsincrona, Object servicioIntegracion)throws SICException{
		Collection<ArticuloVO> items = new ArrayList<ArticuloVO>(1);
		items.add(articulo);
		transferirDatosArticuloSIC(items, esAsincrona, servicioIntegracion);
	}
	
	@Override
	public Collection<ArticuloPendienteIntegracionDTO> obtenerArticuloPendientesIntegracion(Integer codigoCompania, String valorTipoProceso) throws SICException {
		ArticuloPendienteIntegracionDTO api = null;
		SearchResultDTO<ArticuloPendienteIntegracionDTO> artPenIntCol = null;
		try{
			if( this.verificarParametroIntegracion(codigoCompania) ){
				//se verifican si hay articulos pendientes de enviar al SIC
				api = new ArticuloPendienteIntegracionDTO();
				api.getId().setCodigoCompania(codigoCompania);
				api.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				api.setFirstResult(0);				
				ParametroDTO parametroDTO = parametroGestor.obtenerParametro(codigoCompania, SICArticuloConstantes.PARAMETRO_NUMERO_MAXIMO_ARTICULOS_INTEGRACION);
				api.setMaxResults(Integer.valueOf(parametroDTO.getValorParametro()));
				api.setCountAgain(Boolean.FALSE);
				if(StringUtils.isEmpty(valorTipoProceso)){
					api.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoProceso", ComparatorTypeEnum.IN_COMPARATOR, new String[]{TipoCatalogoArticulo.PROCESO_INTEGRACION_CREACIONARTICULO, TipoCatalogoArticulo.PROCESO_INTEGRACION_EDICIONARTICULO}));
				}else{
					api.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoProceso", ComparatorTypeEnum.EQUAL_COMPARATOR, valorTipoProceso));
				}
				api.setOrderByField(OrderBy.orderAsc(new String[]{"valorTipoProceso","fechaRegistro"}));
				artPenIntCol = dataGestor.findObjectsPaged(api);
			}
		}catch(SICException e){
			LOG_SICV2.error("Ha ocurrido un error al obtener articulos por integrar.");
		}catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al obtener articulos por integrar.");
		}
		return artPenIntCol.getResults();
	}
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public void transferirDatosArticuloSICAsincrona(Integer codigoCompania, Collection<ArticuloPendienteIntegracionDTO> artPenIntCol)throws SICException{//TODO
		ArticuloDTO articuloFiltro1 = null;
		IntegrationServiceI integrationServiceI = null;
		try{
			if(CollectionUtils.isNotEmpty(artPenIntCol)){
				//se crea el objeto filtro para el articulo
				articuloFiltro1 = new ArticuloDTO();
				articuloFiltro1.getId().setCodigoCompania(codigoCompania);
				articuloFiltro1.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
				articuloFiltro1.getArtBitCodBarCol().add(new ArticuloBitacoraCodigoBarrasDTO());
				//relaciones con precios
				calculoBusquedaArticuloGestor.asignarRelacionesArticuloPrecio(articuloFiltro1);
				//relaciones con proceso logistico
				articuloFiltro1.setArticuloProcesoLogisticoDTO(new ArticuloProcesoLogisticoDTO());
				articuloFiltro1.getArticuloProcesoLogisticoDTO().setTipoDistribucion(new CatalogoValorDTO());
				//relacion con prototipo de alcance
				articuloFiltro1.setGrupoAlcanceDTO(new GrupoTrabajoDTO());
				//relacion con articulo comercial
				articuloFiltro1.setArticuloComercialDTO(new ArticuloComercialDTO());
				//relacion con articulo temporada
				articuloFiltro1.setArticuloTemporadaDTO(new ArticuloTemporadaDTO());
				//relacion con articulo medida
				articuloFiltro1.setArticuloMedidaDTO(new ArticuloMedidaDTO());
				//relacion con articulo garantia
				articuloFiltro1.setArticuloGarantiaDTO(new ArticuloGarantiaDTO());
				
				//relacion con descuentos en la venta
				articuloFiltro1.addJoin("descuentoVentaArticuloCol", JoinType.LEFT, new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				//relacion con articulo relacion
				asignarRelacionesArticuloRelacion(articuloFiltro1, Boolean.FALSE);
				//relacion con etiquetas
				asignarRelacionesEtiquetas(articuloFiltro1);
				//relacion con usos
				asignarRelacionesUsos(articuloFiltro1);
				//relaciones con duracion conservacion
				asignarRelacionesArticuloConservacion(articuloFiltro1);
				//relaciones con el agrupador
				asignarRelacionesArticuloAgrupador(articuloFiltro1);
				
				//se crea el filtro para los proveedores del articulo
				ArticuloProveedorDTO apFiltro = new ArticuloProveedorDTO();
				apFiltro.getId().setCodigoCompania(codigoCompania);
				accionArticuloProveedorGestor.construirRelacionesArticuloProveedor(apFiltro);
				apFiltro.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				apFiltro.setVistaProveedor(new VistaProveedorDTO());
				apFiltro.setArticuloProveedorImpuestoCol(new ArrayList<ArticuloProveedorImpuestoDTO>());
				ArticuloProveedorImpuestoDTO articuloProveedorImpuestoDTO = new ArticuloProveedorImpuestoDTO();
				articuloProveedorImpuestoDTO.setTipoImpuestoDTO(new TipoImpuestoDTO());
				articuloProveedorImpuestoDTO.getTipoImpuestoDTO().setGrupoImpuesto(new GrupoImpuestoDTO());
				apFiltro.getArticuloProveedorImpuestoCol().add(articuloProveedorImpuestoDTO);
				apFiltro.setOrderByField(OrderBy.orderAsc("fechaRegistro"));
				
				//se crea el filtro para los locales
				ArticuloLocalDTO al = new ArticuloLocalDTO();
				al.getId().setCodigoCompania(codigoCompania);
				al.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL);
				
				//se crea el filtro para el registro sanitario
				RelacionArticuloRegistroSanitarioDTO ars = new RelacionArticuloRegistroSanitarioDTO();
				ars.getId().setCodigoCompania(codigoCompania);
				ars.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				ars.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
				ars.getRegistroSanitario().setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO);
				ars.getRegistroSanitario().setCodigoTipoEstudioNutricional(TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL);
				ars.setOrderByField(OrderBy.orderAsc("registroSanitario.fechaRegistro"));
				
				//se crea el objeto vo
				ArticuloVO vo = new ArticuloVO();
				MultiKeyMap multiKey = new MultiKeyMap();
				integrationServiceI = SICIntegracion.iniciarConexion(UtilIntegracion.CODIGOSERVICIO_GESTIONARARTICULO);
				for(ArticuloPendienteIntegracionDTO dto : artPenIntCol){
					SICFactory.getInstancia().administracion.getTareaProgramadaService().transferirArticuloSICAsincrona(codigoCompania, articuloFiltro1, artPenIntCol, dto, multiKey, integrationServiceI, vo, al, apFiltro, ars);
				}				
			}
		}catch(SICException e){
			LOG_SICV2.error("", e.getMessage());
		}catch (Exception e) {
			LOG_SICV2.error("", e.getMessage());
		}finally{
			SICIntegracion.detenerConexion(integrationServiceI);
			integrationServiceI=null;
		}
	}
	
	@Override
	public void transferirArticuloSICAsincrona(Integer codigoCompania, ArticuloDTO articuloPlantilla, Collection<ArticuloPendienteIntegracionDTO> artPenIntCol, ArticuloPendienteIntegracionDTO articuloPendienteIntegracionDTO, MultiKeyMap multiKey, IntegrationServiceI integrationServiceI, ArticuloVO vo, ArticuloLocalDTO al, ArticuloProveedorDTO apFiltro, RelacionArticuloRegistroSanitarioDTO ars)throws SICException{//TODO
		ArticuloDTO articuloResultado = null;
		Long secuencialRegistro = null;
		try{
			if(!multiKey.containsKey(articuloPendienteIntegracionDTO.getCodigoArticulo(), articuloPendienteIntegracionDTO.getValorTipoProceso())){
				secuencialRegistro = articuloPendienteIntegracionDTO.getId().getSecuencial();
				articuloPlantilla.getId().setCodigoArticulo(articuloPendienteIntegracionDTO.getCodigoArticulo());
				articuloResultado = dataGestor.findUnique(articuloPlantilla);
				//se cargan los locales
				al.getId().setCodigoArticulo(articuloPendienteIntegracionDTO.getCodigoArticulo());
				articuloResultado.setArticuloLocalCol(dataGestor.findObjects(al));
				
				ars.getId().setCodigoArticulo(articuloPendienteIntegracionDTO.getCodigoArticulo());
				articuloResultado.setRegistroSanitarioCol(dataGestor.findObjects(ars));
				
				//se carga el articulo proveedor
				apFiltro.getId().setCodigoArticulo(articuloPendienteIntegracionDTO.getCodigoArticulo());
				articuloResultado.setArticuloProveedorCol(dataGestor.findObjects(apFiltro));
				
				vo.setBaseDTO(articuloResultado);
				vo.getBaseDTO().addDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA, Boolean.TRUE);
				vo.getBaseDTO().addDynamicProperty(ArticuloTransient.PROCESO_INTEGRACION_SIC, articuloPendienteIntegracionDTO.getValorTipoProceso());
				vo.getBaseDTO().setUserId(articuloPendienteIntegracionDTO.getIdUsuarioRegistro());
				
				//se verifica si se debe notificar como cambio de garantia
				if(articuloResultado.getTieneArticuloGarantia()){
					Long count = this.articuloPendienteIntegracionDAO.contarArticuloNovedad(articuloResultado.getId().getCodigoCompania(), articuloResultado.getId().getCodigoArticulo(), articuloPendienteIntegracionDTO.getValorTipoProceso());
					if(count > 0){
						vo.getBaseDTO().addDynamicProperty("notificar", Boolean.TRUE);
					}
				}
				
				transferirDatosArticuloSIC(vo, Boolean.TRUE, integrationServiceI);
				Collection<ArticuloPendienteIntegracionDTO> articuloPendienteIntegracionCol =  CollectionUtils.select(artPenIntCol, new BeanPredicate("codigoArticulo", PredicateUtils.equalPredicate(articuloPendienteIntegracionDTO.getCodigoArticulo())));
				articuloPendienteIntegracionCol = ColeccionesUtil.sort(articuloPendienteIntegracionCol, ColeccionesUtil.ORDEN_DESC, "fechaRegistro");
				if(articuloPendienteIntegracionCol != null){
					Date fechaAscendente = articuloPendienteIntegracionCol.iterator().next().getFechaRegistro();
					LOG_SICV2.info(MessageFormat.format("Secuencial de art\u00EDculo a integrar: {0} con fecha mayor: {1}", secuencialRegistro.toString(), fechaAscendente.toString()));
					this.articuloIntegracionDAO.eliminarArticulosIntegrados(articuloPendienteIntegracionDTO.getId().getCodigoCompania(), articuloPendienteIntegracionDTO.getCodigoArticulo(), articuloPendienteIntegracionDTO.getValorTipoProceso(), fechaAscendente);
				}else{
					this.articuloIntegracionDAO.eliminarArticulosIntegrados(articuloPendienteIntegracionDTO.getId().getCodigoCompania(), articuloPendienteIntegracionDTO.getId().getSecuencial());
				}
				
				multiKey.put(articuloPendienteIntegracionDTO.getCodigoArticulo(), articuloPendienteIntegracionDTO.getValorTipoProceso(), Boolean.TRUE);
			}
		}catch(SICException e){
			//tratarError(codigoCompania, secuencialRegistro, e.getMessage(), articuloResultado);
			tratarError(codigoCompania, secuencialRegistro, e.getMessage());
			LOG_SICV2.error("Ha ocurrido un error en la integracion con SIC:",e);
			Logeable.LOG_SICV2.error(e.getMessage());
		}catch (Exception e) {
			tratarError(codigoCompania, secuencialRegistro, e.getMessage());
			LOG_SICV2.error("Ha ocurrido un error en la integracion con SIC:",e);
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private Boolean verificarParametroIntegracion(Integer compania){
		LOG_SICV2.info("VERIFICAR PARAMETRO DE INTEGRACION");
		try {
			ParametroDTO paramIntegracionSIC = new ParametroDTO();
			paramIntegracionSIC.setEstado(SICConstantes.ESTADO_ACTIVO_LITERAL);
			paramIntegracionSIC.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_INTEGRACION_SIC);
			paramIntegracionSIC.getId().setCodigoCompania(compania);
			paramIntegracionSIC = dataGestor.findUnique(paramIntegracionSIC);
			if (paramIntegracionSIC != null) {
				if (Boolean.valueOf(paramIntegracionSIC.getValorParametro()))
					return Boolean.TRUE;
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al consultar el parametro de integracion.");
			throw new SICException("Ha ocurrido un error al consultar el par\u00E1metro de integraci\u00F3n.", e);
		}
		return Boolean.FALSE;
	}

	private void tratarError(Integer codigoCompania, Long secuencialRegistro, String observacion){
		try{
			if(secuencialRegistro != null){
				articuloIntegracionDAO.actualizarArticuloIntegracion(codigoCompania, secuencialRegistro, observacion);
			}
			//se envia el correo para informar el error
			/*EventoID eventoID = new EventoID();
			eventoID.setCompanyId(codigoCompania);
			eventoID.setCodigoEvento(SICConstantesEnvioMail.EVENTO_ERROR_INTEGRACION_ARTICULO);
			eventoID.setSystemId(SICConstantes.CODIGO_SISTEMA_MAX);
        	EventoDTO eventoEncontrado = mensajeriaG.obtenerEventoPorID(eventoID);
        	
        	if(eventoEncontrado != null){
        		String mensajeIntegracion = null;
    			if(articuloProcesado != null){
    				mensajeIntegracion = MessageFormat.format(eventoEncontrado.getDescripcionEvento(), " ".concat(articuloProcesado.getCodigoBarrasActivo().getId().getCodigoBarras()), observacion);
    			}else{
    				mensajeIntegracion = MessageFormat.format(eventoEncontrado.getDescripcionEvento(), "", observacion);
    			}
    			
    			ParametroDTO parametroDTO = new ParametroDTO();
    			parametroDTO.getId().setCodigoCompania(codigoCompania);
    			parametroDTO.getId().setCodigoParametro(SICParametros.getInstancia().CORREOS_NOTIFICACION_ERROR_INTEGRACION_ARTICULO);
    			parametroDTO = dataGestor.findUnique(parametroDTO);
    			
    			if(parametroDTO != null){
    				//se forma la estructura del mensaje
                	MailMensajeEST mailMensajeEST = new MailMensajeEST();
                	mailMensajeEST.setMensaje(mensajeIntegracion);
                	mailMensajeEST.setDe(eventoEncontrado.getEmailRemitente());
                	String[] para = parametroDTO.getValorParametro().split(",");
                	mailMensajeEST.setPara(para);
                	mailMensajeEST.setAsunto(eventoEncontrado.getAsuntoEvento());
                	//mailMensajeEST.setFormatoHTML(Boolean.TRUE);
                	mailMensajeEST.setEventoDTO(eventoEncontrado);
                	mailMensajeEST.setGuardarMensaje(Boolean.FALSE);
                	mailMensajeEST.setHost(MensajeriaMessages.getString("mail.serverHost"));
    	        	mailMensajeEST.setPuerto(MensajeriaMessages.getString("mail.puerto"));
    	        	
        			mensajeriaG.envioMail(mailMensajeEST, Boolean.FALSE);
    			}
        	}*/
		}catch(Exception e){
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	
	/**
	 * Obtiene la estructura xml del mensaje a enviar
	 * @param articuloPendienteIntegracionList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private StringBuilder obtenerEstructuraEmailXmlErrorSIC(Collection<ArticuloPendienteIntegracionDTO> articuloPendienteIntegracionList){
		StringBuilder contenidoXml = new StringBuilder();
		contenidoXml.append("<?xml version=\"1.0\"?>");
		contenidoXml.append("<articulos>");
		for(ArticuloPendienteIntegracionDTO artPenInt: articuloPendienteIntegracionList){
			contenidoXml.append("<articulo")
			.append(" codigoBarras = \"").append(StringEscapeUtils .escapeXml(artPenInt.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras()))
			.append("\" observacion = \"").append(StringEscapeUtils.escapeXml(artPenInt.getObservacion()))
			.append("\" />");
		}
		contenidoXml.append("</articulos>");
		return contenidoXml;
	}
	
	/**
	 * Permite enviar el email
	 * @param eventoDTO EventoDTO
	 * @param destinatarios Destinatarios a los que se les envia el email
	 * @param contenidoXml Contenido del Mensaje
	 * @param esFormatoHtml True si el mensaje es html, False en caso contrario
	 * @param eliminarArchivos True si se debe eliminar archivos, False en caso contrario
	 * @throws Exception 
	 */
	private void enviarEmail(EventoDTO eventoDTO, String[] destinatarios, StringBuilder contenidoXml, Boolean esFormatoHtml, Boolean eliminarArchivos)
			throws Exception {
		MailMensajeEST mailMensajeEST = new MailMensajeEST();
		mailMensajeEST.setEventoDTO(eventoDTO);
		//mailMensajeEST.setGuardarMensaje(Boolean.FALSE);
		mailMensajeEST.setHost(MensajeriaMessages.getString("mail.serverHost"));
		mailMensajeEST.setPuerto(MensajeriaMessages.getString("mail.puerto"));
		mailMensajeEST.setFormatoHTML(esFormatoHtml);
		mailMensajeEST.setPara(destinatarios);
		mailMensajeEST.setReemplazarRemitente(Boolean.FALSE);
		mailMensajeEST.setDe(eventoDTO.getEmailRemitente());
		mailMensajeEST.setAsunto(eventoDTO.getAsuntoEvento());
		String contenido = contenidoXml.toString(); 
		mailMensajeEST.setMensajeXML(contenido);
		mensajeriaG.envioMail(mailMensajeEST, eliminarArchivos);
	}
	
	/**
	 * Permite obtener la informaci\u00F3n necesaria para el envio del correo de los art\u00EDculos con errores en la Integraci\u00F3n del SIC
	 * @param eventoDTO EventoDTO
	 */
	public void enviarErroresIntegracionSIC(Integer codigoCompania){
		EventoDTO eventoEmail = null;
		EventoID eventoIdEmail = null;
		Collection<ArticuloPendienteIntegracionDTO> articuloPendienteIntegracionList = null;
    	try {
    		articuloPendienteIntegracionList = articuloIntegracionDAO.obtenerArticulosErrorIntegracionSic(codigoCompania);
    		
    		if(CollectionUtils.isNotEmpty(articuloPendienteIntegracionList)){
        		//se envia el correo para informar el error
        		eventoEmail = new EventoDTO();
    			eventoIdEmail = new EventoID();
    			eventoIdEmail.setCompanyId(codigoCompania);
    			eventoIdEmail.setCodigoEvento(SICConstantesEnvioMail.EVENTO_ERROR_INTEGRACION_ARTICULO);
    			eventoIdEmail.setSystemId(SICConstantes.CODIGO_SISTEMA_MAX);
    			eventoEmail= mensajeriaG.obtenerEventoPorID(eventoIdEmail);
    			
    			if(eventoEmail != null){
        			ParametroDTO parametroDTO = new ParametroDTO();
        			parametroDTO.getId().setCodigoCompania(codigoCompania);
        			parametroDTO.getId().setCodigoParametro(SICParametros.getInstancia().CORREOS_NOTIFICACION_ERROR_INTEGRACION_ARTICULO);
        			parametroDTO = dataGestor.findUnique(parametroDTO);
        			
        			if(parametroDTO != null && !parametroDTO.getValorParametro().isEmpty()){
                    	String[] para = parametroDTO.getValorParametro().split(",");
                    	StringBuilder contenidoXML = this.obtenerEstructuraEmailXmlErrorSIC(articuloPendienteIntegracionList);
                    	this.enviarEmail(eventoEmail, para, contenidoXML, Boolean.TRUE, Boolean.FALSE);
        			}
            	}
    		}
		} catch (MENSAJERIAException e) {
			LOG_SICV2.error("Error al enviar email en el metodo enviarErroresIntegracionSic", e);
		}catch (Exception e) {
			LOG_SICV2.error("Error al enviar email en el metodo enviarErroresIntegracionSic", e);
		}
	}
	
	private void completarDatosAlFinalizarCodificacion(final ArticuloVO articuloVO, RegistroArticuloDetalleIDTO item){
		if(articuloVO.getBaseDTO().getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) != null){
			
			ArticuloProveedorDTO ap = articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next();
			ap.addDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO, Boolean.TRUE);
			
			//el codigo jde se toma directamente del VO
			item.setCodigoProveedor(ap.getVistaProveedor().getCodigoJDEProveedor());
			//se realiza la busqueda del articulo para completar los datos faltantes
			ArticuloDTO filtro = new ArticuloDTO();
			filtro.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			filtro.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			Boolean realizarConsulta = Boolean.FALSE;
			
			if(!articuloVO.getBaseDTO().getTieneArticuloPrecio()){
				LOG_SICV2.info("carga precios");
				calculoBusquedaArticuloGestor.asignarRelacionesArticuloPrecio(filtro);
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneArticuloProcesoLogistico()){
				filtro.setArticuloProcesoLogisticoDTO(new ArticuloProcesoLogisticoDTO());
				filtro.getArticuloProcesoLogisticoDTO().setTipoDistribucion(new CatalogoValorDTO());
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneGrupoAlcance()){
				LOG_SICV2.info("carga prototipo alcance");
				filtro.setGrupoAlcanceDTO(new GrupoTrabajoDTO());
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneArticuloComercial()){
				LOG_SICV2.info("carga comercial");
				filtro.setArticuloComercialDTO(new ArticuloComercialDTO());
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneArticuloTemporada()){
				LOG_SICV2.info("carga temporada");
				filtro.setArticuloTemporadaDTO(new ArticuloTemporadaDTO());
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneArticuloMedida()){
				LOG_SICV2.info("carga medidaas");
				filtro.setArticuloMedidaDTO(new ArticuloMedidaDTO());
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneArticuloImpuestoCol()){
				LOG_SICV2.info("carga impuestos");
				calculoBusquedaArticuloGestor.asignarRelacionesArticuloImpuesto(filtro);
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneDescuentoVentaArticulo()){
				filtro.addJoin("descuentoVentaArticuloCol", JoinType.LEFT, new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneArticuloRelacionado()){
				LOG_SICV2.info("carga relacionados");
				realizarConsulta = Boolean.TRUE;
				asignarRelacionesArticuloRelacion(filtro, Boolean.TRUE);
			}
			if(!articuloVO.getBaseDTO().getTieneArticuloLocal()){
				LOG_SICV2.info("carga alcances");
				realizarConsulta = Boolean.TRUE;
				asignarRelacionesArticuloLocal(filtro, Boolean.TRUE);
			}
			if(!articuloVO.getBaseDTO().getTieneRegistroSanitario()){
				LOG_SICV2.info("carga registro sanitario");
				realizarConsulta = Boolean.TRUE;
				asignarRelacionesRegistroSanitario(filtro);
			}
			if(!articuloVO.getBaseDTO().getTieneEtiquetas()){
				LOG_SICV2.info("carga etiquetas");
				realizarConsulta = Boolean.TRUE;
				asignarRelacionesEtiquetas(filtro);
			}
			if(!SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloGarantiaDTO())){
				LOG_SICV2.info("carga garantia");
				filtro.setArticuloGarantiaDTO(new ArticuloGarantiaDTO());
				realizarConsulta = Boolean.TRUE;
			}
			if(!articuloVO.getBaseDTO().getTieneUsos()){
				LOG_SICV2.info("carga usos");
				realizarConsulta = Boolean.TRUE;
				asignarRelacionesUsos(filtro);
			}
			if(!articuloVO.getBaseDTO().getTieneDuracionConservacion()){
				LOG_SICV2.info("carga tiempo conservacion");
				realizarConsulta = Boolean.TRUE;
				asignarRelacionesArticuloConservacion(filtro);
			}
			if(!articuloVO.getBaseDTO().getTieneArticuloAgrupador()){
				LOG_SICV2.info("carga agrupadores");
				realizarConsulta = Boolean.TRUE;
				asignarRelacionesArticuloAgrupador(filtro);
			}
			
			if(realizarConsulta){
				filtro = dataGestor.findUnique(filtro);
				
				articuloVO.getBaseDTO().setArticuloPrecioCol(filtro.getArticuloPrecioCol());
				articuloVO.getBaseDTO().setArticuloImpuestoCol(filtro.getArticuloImpuestoCol());
				articuloVO.getBaseDTO().setDescuentoVentaArticuloCol(filtro.getDescuentoVentaArticuloCol());
				
				if(!articuloVO.getBaseDTO().getTieneGrupoAlcance()){
					articuloVO.getBaseDTO().setGrupoAlcanceDTO(filtro.getGrupoAlcanceDTO());
				}
				if(!articuloVO.getBaseDTO().getTieneArticuloComercial()){
					articuloVO.getBaseDTO().setArticuloComercialDTO(filtro.getArticuloComercialDTO());
				}
				if(!articuloVO.getBaseDTO().getTieneArticuloTemporada()){
					articuloVO.getBaseDTO().setArticuloTemporadaDTO(filtro.getArticuloTemporadaDTO());
				}
				if(!articuloVO.getBaseDTO().getTieneArticuloMedida()){
					articuloVO.getBaseDTO().setArticuloMedidaDTO(filtro.getArticuloMedidaDTO());
				}
				if(!articuloVO.getBaseDTO().getTieneDescuentoVentaArticulo()){
					articuloVO.getBaseDTO().setDescuentoVentaArticuloCol(filtro.getDescuentoVentaArticuloCol());
				}
				if(!articuloVO.getBaseDTO().getTieneArticuloImpuestoCol()){
					articuloVO.getBaseDTO().setArticuloImpuestoCol(filtro.getArticuloImpuestoCol());
				}
				if(!articuloVO.getBaseDTO().getTieneArticuloProcesoLogistico()){
					articuloVO.getBaseDTO().setArticuloProcesoLogisticoDTO(filtro.getArticuloProcesoLogisticoDTO());
				}
				if(!articuloVO.getBaseDTO().getTieneArticuloRelacionado()){
					articuloVO.getBaseDTO().setArticuloRelacionCol(filtro.getArticuloRelacionCol());
				}
				if(!articuloVO.getBaseDTO().getTieneArticuloLocal()){
					articuloVO.getBaseDTO().setArticuloLocalCol(filtro.getArticuloLocalCol());
				}
				if(!articuloVO.getBaseDTO().getTieneRegistroSanitario()){
					articuloVO.getBaseDTO().setRegistroSanitarioCol(filtro.getRegistroSanitarioCol());
				}
				if(!articuloVO.getBaseDTO().getTieneEtiquetas()){
					articuloVO.getBaseDTO().setArticuloEtiquetaCol(filtro.getArticuloEtiquetaCol());
				}
				if(!SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloGarantiaDTO())){
					articuloVO.getBaseDTO().setArticuloGarantiaDTO(filtro.getArticuloGarantiaDTO());
				}
				if(!articuloVO.getBaseDTO().getTieneUsos()){
					articuloVO.getBaseDTO().setArticuloUsoCol(filtro.getArticuloUsoCol());
				}
				if(!articuloVO.getBaseDTO().getTieneDuracionConservacion()){
					articuloVO.getBaseDTO().setArticuloDuracionConservacionCol(filtro.getArticuloDuracionConservacionCol());
				}
				if(!articuloVO.getBaseDTO().getTieneArticuloAgrupador()){
					articuloVO.getBaseDTO().setArticuloAgrupadorCol(filtro.getArticuloAgrupadorCol());
				}
			}
			filtro = null;
		}else if(StringUtils.equals(articuloVO.getBaseDTO().getEstadoArticulo(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
			if(articuloVO.getBaseDTOAnterior() != null && SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(articuloVO.getBaseDTOAnterior().getEstadoArticulo())
					&& SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(articuloVO.getBaseDTO().getEstadoArticulo())){
				ArticuloProveedorDTO ap = articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next();
				item.setCodigoProveedor(ap.getVistaProveedor().getCodigoJDEProveedor());
			}
			//se controla la asignacion del codigo de barras anterior
			if(articuloVO.getBaseDTOAnterior() != null && !articuloVO.getBaseDTOAnterior().getCodigoBarrasActivo().getId().getCodigoBarras().equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras())){
				item.setCodigoBarrasAnterior(articuloVO.getBaseDTOAnterior().getCodigoBarrasActivo().getId().getCodigoBarras());
			}
		}
	}
	
	private void asignarRelacionesArticuloLocal(ArticuloDTO filtro, Boolean registrosActivos){
		filtro.setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
		ArticuloLocalDTO al = new ArticuloLocalDTO();
		if(registrosActivos){
			al.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloLocal", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		}
		//al.setArticuloLocalPrecioCol(new ArrayList<ArticuloLocalPrecioDTO>());
		filtro.getArticuloLocalCol().add(al);
	}
	private void asignarRelacionesArticuloRelacion(ArticuloDTO filtro, Boolean registrosActivos){
		filtro.setArticuloRelacionCol(new ArrayList<ArticuloRelacionDTO>());
		ArticuloRelacionDTO ar = new ArticuloRelacionDTO();
		ar.setArticuloRelacion(new ArticuloDTO());
		if(registrosActivos){
			ar.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		}
		ar.getArticuloRelacion().setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		ArticuloBitacoraCodigoBarrasDTO abcb = new ArticuloBitacoraCodigoBarrasDTO();
		abcb.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		ar.getArticuloRelacion().getArtBitCodBarCol().add(abcb);
		filtro.getArticuloRelacionCol().add(ar);
	}
	private void asignarRelacionesArticuloAgrupador(ArticuloDTO filtro){
		ArticuloAgrupadorDTO agr = new ArticuloAgrupadorDTO();
		agr.setTipoAgrupador(new CatalogoValorDTO());
		agr.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		filtro.setArticuloAgrupadorCol(new ArrayList<ArticuloAgrupadorDTO>());
		filtro.getArticuloAgrupadorCol().add(agr);
	}
	private void asignarRelacionesArticuloConservacion(ArticuloDTO filtro){
		ArticuloDuracionConservacionDTO adc = new ArticuloDuracionConservacionDTO();
		adc.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		adc.setTipoConservacionDTO(new CatalogoValorDTO());
		filtro.setArticuloDuracionConservacionCol(new ArrayList<ArticuloDuracionConservacionDTO>());
		filtro.getArticuloDuracionConservacionCol().add(adc);
	}
	private void asignarRelacionesUsos(ArticuloDTO filtro){
		ArticuloUsoDTO au = new ArticuloUsoDTO();
		au.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		au.setTipoUso(new CatalogoValorDTO());
		filtro.setArticuloUsoCol(new ArrayList<ArticuloUsoDTO>());
		filtro.getArticuloUsoCol().add(au);
	}
	private void asignarRelacionesEtiquetas(ArticuloDTO filtro){
		ArticuloEtiquetaDTO eti = new ArticuloEtiquetaDTO();
		eti.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		eti.setTagDTO(new TagDTO());
		//eti.getTagDTO().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("groupTagType", ComparatorTypeEnum.EQUAL_COMPARATOR, CatalogTypeConstant.TIPO_ETIQUETAS));
		//eti.getTagDTO().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("groupTagValue", ComparatorTypeEnum.EQUAL_COMPARATOR, FrameworkConstants.ETIQUETA_PRECIAR_ARTICULO));
		filtro.setArticuloEtiquetaCol(new ArrayList<ArticuloEtiquetaDTO>());
		filtro.getArticuloEtiquetaCol().add(eti);
	}
	private void asignarRelacionesRegistroSanitario(ArticuloDTO filtro){
		RelacionArticuloRegistroSanitarioDTO rel = new RelacionArticuloRegistroSanitarioDTO();
		rel.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		rel.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
		rel.getRegistroSanitario().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoTipoEstudioNutricional", ComparatorTypeEnum.EQUAL_COMPARATOR, TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL));
		rel.getRegistroSanitario().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoEstudioNutricional", ComparatorTypeEnum.EQUAL_COMPARATOR, TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO));
		filtro.setRegistroSanitarioCol(new ArrayList<RelacionArticuloRegistroSanitarioDTO>());
		filtro.getRegistroSanitarioCol().add(rel);
	}
	
	/**
	 * 
	 * @param detalleActual		- Colecci&oacute;n modificada de los art&iacute;culos por local
	 * @param detalleOriginal	- Colecci&oacute;n original de los art&iacute;culos por local
	 * @throws SICException
	 */
	private void transferirDatosArticuloLocal(Collection<ArticuloLocalDTO> detalleActual, Collection<ArticuloLocalDTO> detalleOriginal, ArticuloDTO articuloDTO,
			IntegrationServiceI integrationServiceI)throws SICException{
		if(esIntegracionActiva){
			final String TIPOPROCESO = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.registrarArticuloLocal");
			RegistroArticuloLocalIDTO registroArticuloLocal = null;
			Set<String> codigosBarra = null;
			try{
				//se crea el objeto para enviar los datos del articulo
				registroArticuloLocal = new RegistroArticuloLocalIDTO();
				registroArticuloLocal.getControlProceso().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
				registroArticuloLocal.getControlProceso().setProceso(TIPOPROCESO);
				registroArticuloLocal.setUsuarioRegistro(articuloDTO.getUserId());
				
				LOG_SICV2.info("activos");
				codigosBarra = new HashSet<String>();
				if(CollectionUtils.isNotEmpty(detalleActual)){
					for(ArticuloLocalDTO dto : detalleActual){
						RegistroArticuloLocalDetalleIDTO item = new RegistroArticuloLocalDetalleIDTO();
						item.setCodigoBarras(dto.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
						item.setCodigoAreaTrabajo(dto.getId().getCodigoLocal());
						item.setEstadoAlcance(dto.getEstadoArticuloLocal());
						if(registroArticuloLocal.getDetalle() == null){
							registroArticuloLocal.setDetalle(new ArrayList<RegistroArticuloLocalDetalleIDTO>());
						}
						registroArticuloLocal.getDetalle().add(item);
						LOG_SICV2.info("local: "+dto.getId().getCodigoLocal());
						codigosBarra.add(item.getCodigoBarras());
					}
				}
				//solo si el articulo NO es cupon
				if(!SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON.equals(articuloDTO.getCodigoTipoArticulo())){
					
					Collection<ArticuloLocalDTO> bodegasCol = articuloAlcanceGestor.obtenerBodegasParaCentroDistribucion(articuloDTO, SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
					
					// Obtener codigos de bodegas 
					Set<Integer> codigosBodegas = new HashSet<Integer>(CollectionUtils.collect(bodegasCol, new GetInvokerTransformer("id.codigoLocal")));
					
					if(CollectionUtils.isNotEmpty(codigosBodegas)){
						
						ArticuloLocalDTO cDTemp = null;	
						Collection<ArticuloLocalDTO> listaFinal = new ArrayList<ArticuloLocalDTO>();
						Collection<ArticuloLocalDTO> listaCDEstadosFinales = new ArrayList<ArticuloLocalDTO>();
						
						Collection<AreaSublugarTrabajoDTO> centrosDistribucion = articuloAlcanceGestor.obtenerCentrosDeDistribucionConEstados(codigosBodegas);
						// Obtener codigos de referencia CD 
						Set<Integer> codigosReferenciaCD = new HashSet<Integer>(CollectionUtils.collect(centrosDistribucion, new GetInvokerTransformer("areaTrabajoDTO.codigoReferencia")));
						
						// Se arma una plantilla de los CD con sus respectivos estados
						// CD BOD EST
						// 100 10 0
						// 100 11 1
						for(AreaSublugarTrabajoDTO areaSubLugar : centrosDistribucion){
							for(ArticuloLocalDTO articuloLocal : bodegasCol){
								if(areaSubLugar.getId().getCodigoAreaSublugarTrabajo().equals(articuloLocal.getId().getCodigoLocal())){
									cDTemp = new ArticuloLocalDTO();
									// Seteamos el estado CD
									cDTemp.setEstadoArticuloLocal(articuloLocal.getEstadoArticuloLocal());
									// Seteamos el codigo de referencia trabajo CD
									cDTemp.setCodigoReferencia(areaSubLugar.getAreaTrabajoDTO().getCodigoReferencia().toString());
									// Creamos una nueva plantilla de CD con sus estados respectivos 
									listaCDEstadosFinales.add(cDTemp);
								}
							}
						}
						
						//Collection<Integer> codCDRegistrados = new ArrayList<Integer>();
						
						// CD, EST --> 100, 1
						for(Integer centroDistribucion : codigosReferenciaCD){
							cDTemp = new ArticuloLocalDTO();
							
							// Agrupamos por codigo de referencia CD y validamos si existe al menos una bodega activa
							Predicate predicate = PredicateUtils.transformedPredicate(new GetInvokerTransformer("codigoReferencia"), PredicateUtils.equalPredicate(centroDistribucion.toString()));
							predicate = PredicateUtils.andPredicate(predicate, PredicateUtils.transformedPredicate(new GetInvokerTransformer("estadoArticuloLocal"), PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
							
							Boolean centroD = CollectionUtils.exists(listaCDEstadosFinales, predicate);
							// Valida el estado del CD
							if(BooleanUtils.isTrue(centroD)){
								cDTemp.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							}else
								cDTemp.setEstadoArticuloLocal(SICConstantes.ESTADO_INACTIVO_NUMERICO);
							// Seteamos el codigo de la bodega
							cDTemp.setCodigoReferencia(centroDistribucion.toString());
							// Creamos una nueva plantilla de CD con sus estados respectivos 
							listaFinal.add(cDTemp);
						}
						
						for(ArticuloLocalDTO centroDis : listaFinal){
							//for(String cb : codigosBarra){
								// se agregan las bodegas para todos los articulos
								RegistroArticuloLocalDetalleIDTO item = new RegistroArticuloLocalDetalleIDTO();
								item.setCodigoBarras(articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras()); //cb
								item.setCodigoAreaTrabajo(Integer.valueOf(centroDis.getCodigoReferencia()));
								item.setEstadoAlcance(centroDis.getEstadoArticuloLocal());
								if(registroArticuloLocal.getDetalle() == null ){
									registroArticuloLocal.setDetalle(new ArrayList<RegistroArticuloLocalDetalleIDTO>()); 
								}
								registroArticuloLocal.getDetalle().add(item);
								
								LOG_SICV2.info("Codigo referencia CD: "+ centroDis.getCodigoReferencia());
							//}
						}
					}					
					
					// Transferir Oficinas
					Collection<ArticuloLocalDTO> oficinasCol = articuloAlcanceGestor.consultarAreasTrabajoAsignadas(articuloDTO, SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA, Boolean.FALSE);
					for(ArticuloLocalDTO oficinasDto : oficinasCol){
						//for(String cb : codigosBarra){
							// se agregan las oficinas para todos los articulos
							RegistroArticuloLocalDetalleIDTO item = new RegistroArticuloLocalDetalleIDTO();
							item.setCodigoBarras(articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras()); //cb
							item.setCodigoAreaTrabajo(oficinasDto.getLocal().getCodigoReferencia() * -1);
							item.setEstadoAlcance(oficinasDto.getEstadoArticuloLocal());
							if(registroArticuloLocal.getDetalle() == null ){
								registroArticuloLocal.setDetalle(new ArrayList<RegistroArticuloLocalDetalleIDTO>()); 
							}
							registroArticuloLocal.getDetalle().add(item);
							
							LOG_SICV2.info("Oficina: "+oficinasDto.getId().getCodigoLocal());
						//}
					}
//					Collection<ArticuloLocalDTO> colArtLoc = articuloAlcanceGestor.obtenerColeccionCDPredeterminadosAlcances(articuloDTO.getId().getCodigoCompania());
//					for(ArticuloLocalDTO dto : colArtLoc){
//						//se agregan las bodegas para todos los articulos enviados
//						for(String cb : codigosBarra){
//							RegistroArticuloLocalDetalleIDTO item = new RegistroArticuloLocalDetalleIDTO();
//							item.setCodigoBarras(cb);
//							item.setCodigoAreaTrabajo(dto.getId().getCodigoLocal());
//							item.setEstadoAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//							if(registroArticuloLocal.getDetalle() == null){
//								registroArticuloLocal.setDetalle(new ArrayList<RegistroArticuloLocalDetalleIDTO>());
//							}
//							registroArticuloLocal.getDetalle().add(item);
//						}
//						LOG_SICV2.info("bodega: "+dto.getId().getCodigoLocal());
//					}
				}
				
				//se verifican los objetos que se desactivaron
				if(articuloDTO.getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) == null && CollectionUtils.isNotEmpty(detalleOriginal)){
					LOG_SICV2.info("inactivos");
					for(final ArticuloLocalDTO artlocori : detalleOriginal){
						if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(artlocori.getEstadoArticuloLocal())){
							ArticuloLocalDTO encontrado = (ArticuloLocalDTO)CollectionUtils.find(detalleActual, new Predicate() {
								@Override
								public boolean evaluate(Object arg0) {
									ArticuloLocalDTO artlocact = (ArticuloLocalDTO)arg0;
									return artlocact.getId().getCodigoArticulo().equals(artlocori.getId().getCodigoArticulo()) && artlocact.getId().getCodigoLocal().equals(artlocori.getId().getCodigoLocal());
								}
							});
							if(encontrado == null || (SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(artlocori.getEstadoArticuloLocal())
									&& SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(encontrado.getEstadoArticuloLocal()))){
								RegistroArticuloLocalDetalleIDTO item = new RegistroArticuloLocalDetalleIDTO();
								item.setCodigoBarras(artlocori.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
								item.setCodigoAreaTrabajo(artlocori.getId().getCodigoLocal());
								item.setEstadoAlcance(SICConstantes.ESTADO_INACTIVO_NUMERICO);
								if(registroArticuloLocal.getDetalle() == null){
									registroArticuloLocal.setDetalle(new ArrayList<RegistroArticuloLocalDetalleIDTO>());
								}
								registroArticuloLocal.getDetalle().add(item);
								LOG_SICV2.info("local: "+artlocori.getId().getCodigoLocal());
							}
						}
					}
				}
				
				if(CollectionUtils.isNotEmpty(registroArticuloLocal.getDetalle())){
					if(integrationServiceI != null){
						SICIntegracion.procesarMensaje(registroArticuloLocal, integrationServiceI);
					}else{
						SICIntegracion.procesarMensaje(registroArticuloLocal);
					}
				}
			}catch (IntegrationException e) {
				StringBuilder mensajeError = new StringBuilder(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.local"))
				.append("en el SIC: {0}");
				SICException se = new SICException(MessageFormat.format(mensajeError.toString(), e.getMessage()), e);
				se.setCodigoError(SICIntegracionMessages.CODIGO_ERROR_INTEGRACION);
				throw se;
			}catch (Exception e) {
				throw new SICException(e);
			}finally{
				registroArticuloLocal = null;
				codigosBarra = null;
			}
		}
	}
	
	/**
	 * 
	 * @param detalleActual		- Colecci&oacute;n modificada de los art&iacute;culos relacionados con otros
	 * @param detalleOriginal	- Colecci&oacute;n original de los art&iacute;culos relacionados con otros
	 * @throws SICException
	 */
	private void transferirDatosArticuloRelacion(Collection<ArticuloRelacionDTO> detalleActual, Collection<ArticuloRelacionDTO> detalleOriginal, ArticuloDTO articuloDTO,
			IntegrationServiceI integrationServiceI)throws SICException{
		if(esIntegracionActiva){
			final String TIPOPROCESO = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.registrarArticuloRelacion");
			RegistroArticuloRelacionadoIDTO registroArticuloRelacion = null;
			try{				
				/*ParametroDTO par = new ParametroDTO();
				par.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
				par.getId().setCodigoParametro(SICParametros.getInstancia().CLASIFICACION_RECETASESPECIALES);
				par = dataGestor.findUnique(par);*/							
				
				int inicio = 0;
				int fin = SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
				int iteraciones = 1;
				int residuo = 0;
				iteraciones = detalleActual.size() / SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
				residuo = detalleActual.size() % SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
				
				Collection<ArticuloRelacionDTO> subcoleccion = detalleActual;
				if(iteraciones == 0){
					iteraciones = 1;
				}else if(residuo > 0){
					iteraciones++;
				}																		
								
				//se envia los datos particionados
				for(int i = 1; i<=iteraciones;i++){
					if(iteraciones > 1){
						if(iteraciones > i){
							subcoleccion = ((List<ArticuloRelacionDTO>)detalleActual).subList(inicio, fin);
						}else{
							subcoleccion = ((List<ArticuloRelacionDTO>)detalleActual).subList(inicio, detalleActual.size());
						}
					}
					inicio = inicio + SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
					fin = fin + SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();									

					//se crea el objeto para enviar los datos del articulo
					registroArticuloRelacion = new RegistroArticuloRelacionadoIDTO();
					registroArticuloRelacion.getControlProceso().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
					registroArticuloRelacion.setUsuarioRegistro(articuloDTO.getUserId());
					registroArticuloRelacion.getControlProceso().setProceso(TIPOPROCESO);
					
					if(CollectionUtils.isNotEmpty(subcoleccion)){
						for(ArticuloRelacionDTO dto : subcoleccion){
							//if(!esRelacionRecetasEspeciales(dto, par.getValorParametro())
							//		&& !StringUtils.equals(dto.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras(), dto.getArticuloRelacion().getCodigoBarrasActivo().getId().getCodigoBarras())){
							if(!StringUtils.equals(dto.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras(), dto.getArticuloRelacion().getCodigoBarrasActivo().getId().getCodigoBarras())){
								RegistroArticuloRelacionadoDetalleIDTO item = new RegistroArticuloRelacionadoDetalleIDTO();
								item.setTipoRelacion(dto.getValorTipoRelacion());
								item.setCodigoBarras(dto.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
								item.setCodigoBarrasRelacionado(dto.getArticuloRelacion().getCodigoBarrasActivo().getId().getCodigoBarras());
								if(dto.getCantidad() != null)
									item.setCantidad(dto.getCantidad());
								item.setEstado(dto.getEstado());
								if(registroArticuloRelacion.getDetalle() == null){
									registroArticuloRelacion.setDetalle(new ArrayList<RegistroArticuloRelacionadoDetalleIDTO>());
								}
								registroArticuloRelacion.getDetalle().add(item);
							}
						}					
					}
								
					//se verifican los objetos que se desactivaron
					if(articuloDTO.getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) == null && CollectionUtils.isNotEmpty(detalleOriginal)){
						for(final ArticuloRelacionDTO regori : detalleOriginal){
							ArticuloRelacionDTO encontrado = (ArticuloRelacionDTO)CollectionUtils.find(detalleActual, new Predicate() {
								@Override
								public boolean evaluate(Object arg0) {
									ArticuloRelacionDTO regact = ((ArticuloRelacionDTO)arg0);
									return regact.getId().getCodigoArticulo().equals(regori.getId().getCodigoArticulo()) && regact.getId().getCodigoArticuloRelacionado().equals(regori.getId().getCodigoArticuloRelacionado());
								}
							});
							if(encontrado == null && 
									!StringUtils.equals(regori.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras(), regori.getArticuloRelacion().getCodigoBarrasActivo().getId().getCodigoBarras())){
								RegistroArticuloRelacionadoDetalleIDTO item = new RegistroArticuloRelacionadoDetalleIDTO();
								item.setCodigoBarras(regori.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
								item.setCodigoBarrasRelacionado(regori.getArticuloRelacion().getCodigoBarrasActivo().getId().getCodigoBarras());
								item.setTipoRelacion(regori.getValorTipoRelacion());
								item.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
								if(registroArticuloRelacion.getDetalle() == null){
									registroArticuloRelacion.setDetalle(new ArrayList<RegistroArticuloRelacionadoDetalleIDTO>());
								}
								registroArticuloRelacion.getDetalle().add(item);
							}
						}
					}
				
					if(CollectionUtils.isNotEmpty(registroArticuloRelacion.getDetalle())){
						if(integrationServiceI != null){
							SICIntegracion.procesarMensaje(registroArticuloRelacion, integrationServiceI);
						}else{
							SICIntegracion.procesarMensaje(registroArticuloRelacion);
						}
					}
				}
			}catch (IntegrationException e) {
				StringBuilder mensajeError = new StringBuilder(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.relacionado"))
				.append("en el SIC: {0}");
				SICException se = new SICException(MessageFormat.format(mensajeError.toString(), e.getMessage()), e);
				se.setCodigoError(SICIntegracionMessages.CODIGO_ERROR_INTEGRACION);
				throw se;
			}catch (Exception e) {
				throw new SICException(e);
			}finally{
				registroArticuloRelacion = null;
			}
		}
	}

	/**
	 * @return
	 */
	private Boolean permitirIntegracion(Integer codigoCompania){
		LOG_SICV2.info("SE VERIFICA EL PARAMETRO DE INTEGRACION");
		ParametroDTO parametroDTO = new ParametroDTO();
		parametroDTO.getId().setCodigoCompania(codigoCompania);
		parametroDTO.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_INTEGRACION_SIC);
		parametroDTO = dataGestor.findUnique(parametroDTO);
		if(parametroDTO != null){
			esIntegracionActiva = Boolean.valueOf(parametroDTO.getValorParametro());
			LOG_SICV2.info("integracion: "+esIntegracionActiva);
		}
		return esIntegracionActiva;
	}
	
	public void validarDatosArticuloSIC(){
		
	}
	
	/**
	 * metodo que migra la informacion de articulo portal
	 */
	public void migrarArticulosInformacionPortal(Integer codigoCompania)throws SICException{
		articuloMigracionArticuloPortalDAO.migrarArticulosInformacionPortal(codigoCompania);
	}
	
	/**
	 * sincroniza la informacion de articulo ley de mercado(es nuevo, dependiendo de la fecha
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void sincronizarInformacionArticuloLeyMercado(Integer codigoCompania)throws SICException{
		this.articuloAccionDAO.sincronizarInformacionArticuloLeyMercado(codigoCompania);
	}
	
	// ////////////////////////////////
	// / METODOS DE PROYECTO SICIMPL
	// ////////////////////////////////

	/**
	 * 
	 * @param articulos
	 * @param clase
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public static void modificarClaseArticulo(Collection<ArticuloDTO> articulos, String clase) throws IntegrationException {
		final String templateOUT = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.xsl.MODCLAARTS");
		final String templateIN = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.xsl.MODCLAARTE");
		final String tipoProcesoOUT = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.tipoProceso.modificarClaseArticulo");
		CabeceraIDTO<RegistrarClaseArticuloIDTO> cabecera = new CabeceraIDTO<RegistrarClaseArticuloIDTO>();
		IntegrationServiceI integrationService = null;
		try {
			if (SICIntegracion.esActivaIntegracion() && !articulos.isEmpty()) {
				final Integer codigoCompania = articulos.iterator().next().getId().getCodigoCompania();
				cabecera.getControlProceso().setCodigoCompania(codigoCompania);
				cabecera.getControlProceso().setProceso(tipoProcesoOUT);
				cabecera.getControlProceso().setResultado(SICIntegracionMessages.getString("ec.com.smx.sic.integracion.resultado.proceso.falso"));
				cabecera.setDetalle(new ArrayList<RegistrarClaseArticuloIDTO>());
				for (ArticuloDTO dto : articulos) {
					RegistrarClaseArticuloIDTO intDetalleArticuloDTO = new RegistrarClaseArticuloIDTO();
					intDetalleArticuloDTO.setCodigoArticulo(Long.valueOf(dto.getId().getCodigoArticulo()));
					intDetalleArticuloDTO.setClaseArticulo(clase);
					cabecera.getDetalle().add(intDetalleArticuloDTO);
				}

				// Instanciar la conexion
				integrationService = SICIntegracion.iniciarConexion(UtilIntegracion.COLAENTRADA_SERVICIOARTICULO, UtilIntegracion.COLASALIDA_SERVICIOARTICULO);
				// SALIDA (Enviar mensaje)
				byte[] sispeMsgId = SICIntegracion.enviarMensaje(cabecera, templateOUT, new byte[0], integrationService, IntegrationUtil.TIPO_MSG_REQUEST);
				LOG_SICV2.info("el id del mensaje MODCLAARTS es: {}", sispeMsgId);

				// ENTRADA (Recibir respuesta)
				cabecera = (CabeceraIDTO<RegistrarClaseArticuloIDTO>) SICIntegracion.recibirMensaje(cabecera, sispeMsgId, templateIN, integrationService);
				if (cabecera.getControlProceso().getResultado().startsWith(SICIntegracionMessages.getString("ec.com.smx.sic.integracion.resultado.proceso.falso"))) {
					throw new IntegrationException("No se pudo completar el proceso. ".concat(cabecera.getControlProceso().getResultado()));
				}
			}
		} catch (IntegrationException ex) {
			LOG_SICV2.error("Error: ", ex);
			throw ex;
		} catch (Exception ex) {
			LOG_SICV2.error("Error: ", ex);
			throw new IntegrationException(UtilIntegracion.OBSERVACION_ERROR);
		} finally {
			try {
				if (integrationService != null)
					integrationService.stop();
			} catch (IntegrationException e) {
				LOG_SICV2.error("Error al detener la conexion de respuesta", e);
			}
			integrationService = null;
		}
	}
	
	@Override
	public Boolean consultarExistenciaArticulosIntegrados(Integer codigoCompania, String[] codigosArticulos) throws SICException {
		return this.articuloIntegracionDAO.consultarExistenciaArticulosIntegrados(codigoCompania, codigosArticulos);
	}
	
	@Override
	public void transferirDatosArticuloProveedorSIC(Integer codigoCompania, Collection<ArticuloPendienteIntegracionDTO> articulosPendientesDeIntegracion) throws SICException {
		IntegrationServiceI servicioIntegracion = null;
		Collection<ArticuloProveedorDTO> articulosProveedor;
		Integer iteraciones;
		List<String> codigosArticulosIntegrados;
		try {
			if(CollectionUtils.isNotEmpty(articulosPendientesDeIntegracion)){
				articulosProveedor = new ArrayList<ArticuloProveedorDTO>(0);
				
				// Calcular el maximo de iteraciones a realizar para la busqueda
				Set<Long> secuenciales = new HashSet<Long>(CollectionUtils.collect(articulosPendientesDeIntegracion, new GetInvokerTransformer("id.secuencial")));
				
				iteraciones = CambioPreciosUtil.getInstance().calcularIteracionesConsultasDinamicas(secuenciales.size(),
						GestionPrecioConstantes.getInstancia().CANTIDAD_DATOS_CONSULTA_DINAMICA);

				//Iterar por cada bloque de maximo 900 proveedores
				for(int i=0 ; i<iteraciones ; i++) {
					Set<Long> codigosSecuencialesConsultar = CambioPreciosUtil.getInstance().obtenerItemsConsultaPorIteracionActual(secuenciales,
							GestionPrecioConstantes.getInstancia().CANTIDAD_DATOS_CONSULTA_DINAMICA, i);
					Set<String> codigosArticulosConsultar = new HashSet<String>(CollectionUtils.collect(ColeccionesUtil.getInstance().selectWithIn(articulosPendientesDeIntegracion, "id.secuencial", codigosSecuencialesConsultar), new GetInvokerTransformer("codigoArticulo")));  
					Set<String> codigosProveedoresConsultar = new HashSet<String>(CollectionUtils.collect(ColeccionesUtil.getInstance().selectWithIn(articulosPendientesDeIntegracion, "id.secuencial", codigosSecuencialesConsultar), new GetInvokerTransformer("codigoProveedor")));
					
					articulosProveedor.addAll(SICFactory.getInstancia().administracion.getTareaProgramadaService().obtenerArticulosProveedor(codigoCompania, codigosArticulosConsultar, codigosProveedoresConsultar));
				}
				
				if(CollectionUtils.isNotEmpty(articulosProveedor)){
					codigosArticulosIntegrados = new ArrayList<String>();
					
					for(ArticuloPendienteIntegracionDTO dto : articulosPendientesDeIntegracion){
						
						//Solamente SI aun no ha sido integrado
						if(BooleanUtils.isFalse(codigosArticulosIntegrados.contains(dto.getCodigoArticulo()))){
							
							Collection<ArticuloPendienteIntegracionDTO> articulos = CollectionUtils.select(articulosPendientesDeIntegracion, 
									PredicateUtils.transformedPredicate(new GetInvokerTransformer("codigoArticulo"), PredicateUtils.equalPredicate(dto.getCodigoArticulo())));
							
							Collection<ArticuloProveedorDTO> proveedores = CollectionUtils.select(articulosProveedor, 
									PredicateUtils.transformedPredicate(new GetInvokerTransformer("articulo.id.codigoArticulo"), PredicateUtils.equalPredicate(dto.getCodigoArticulo())));
							
							try {
								SICFactory.getInstancia().administracion.getTareaProgramadaService().transferirDatosArticuloProveedorSIC(codigoCompania, servicioIntegracion, dto, articulos, proveedores);
							} catch (Exception e) {
								continue;
							}
							codigosArticulosIntegrados.add(dto.getCodigoArticulo());
						}
						
					}
				}
				
			}
		} catch (SICException e) {
			LOG_SICV2.error("", e.getMessage());
		} catch (Exception e) {
			LOG_SICV2.error("", e.getMessage());
		} finally{
			articulosProveedor = null;
			codigosArticulosIntegrados = null;
		}
		
	}

	@Override
	public void transferirDatosArticuloProveedorSIC(Integer codigoCompania, IntegrationServiceI servicioIntegracion, ArticuloPendienteIntegracionDTO dto, Collection<ArticuloPendienteIntegracionDTO> articulos, Collection<ArticuloProveedorDTO> proveedores) throws SICException{

		try {
			proveedores.iterator().next().addDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA, Boolean.TRUE);
			proveedores.iterator().next().setUserId(proveedores.iterator().next().getUserId() != null ? proveedores.iterator().next().getUserId() : USUARIO_OMISION);
			this.accionArticuloProveedorGestor.transferirDatosArticuloProveedorSIC(proveedores, Boolean.TRUE, servicioIntegracion);
			
			Collection<ArticuloPendienteIntegracionDTO> articuloPendienteIntegracionCol =  CollectionUtils.select(articulos, new BeanPredicate("codigoArticulo", PredicateUtils.equalPredicate(dto.getCodigoArticulo())));
			articuloPendienteIntegracionCol = ColeccionesUtil.sort(articuloPendienteIntegracionCol, ColeccionesUtil.ORDEN_DESC, "fechaRegistro");
			if(articuloPendienteIntegracionCol != null){
				Date fechaAscendente = articuloPendienteIntegracionCol.iterator().next().getFechaRegistro();
				this.articuloIntegracionDAO.eliminarArticulosIntegrados(codigoCompania,dto.getCodigoArticulo(), TipoCatalogoArticulo.PROCESO_INTEGRACION_ACTUALIZACION_CONDICIONES_COMERCIALES,fechaAscendente);
			}
		} catch (Exception e) {
			articuloIntegracionDAO.actualizarArticuloIntegracion(codigoCompania, dto.getId().getSecuencial(), e.getMessage());
			throw new SICException("Error al integrar condiciones comerciales al SIC",e);
		}
	}
	
	/**
	 * @param accionArticuloProveedorGestor the accionArticuloProveedorGestor to set
	 */
	public void setAccionArticuloProveedorGestor(IAccionArticuloProveedorGestor accionArticuloProveedorGestor) {
		this.accionArticuloProveedorGestor = accionArticuloProveedorGestor;
	}
	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	/**
	 * @return the calculoBusquedaArticuloGestor
	 */
	public ICalculoBusquedaArticuloGestor getCalculoBusquedaArticuloGestor() {
		return calculoBusquedaArticuloGestor;
	}
	/**
	 * @param calculoBusquedaArticuloGestor the calculoBusquedaArticuloGestor to set
	 */
	public void setCalculoBusquedaArticuloGestor(ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor) {
		this.calculoBusquedaArticuloGestor = calculoBusquedaArticuloGestor;
	}

	/**
	 * @param calculoArticuloGestor the calculoArticuloGestor to set
	 */
	public void setCalculoArticuloGestor(ICalculoArticuloGestor calculoArticuloGestor) {
		this.calculoArticuloGestor = calculoArticuloGestor;
	}

	/**
	 * @return the calculoArticuloGestor
	 */
	public ICalculoArticuloGestor getCalculoArticuloGestor() {
		return calculoArticuloGestor;
	}

	public void setArticuloAlcanceGestor(IArticuloAlcanceGestor articuloAlcanceGestor) {
		this.articuloAlcanceGestor = articuloAlcanceGestor;
	}

	public void setArticuloIntegracionDAO(IArticuloIntegracionDAO articuloIntegracionDAO) {
		this.articuloIntegracionDAO = articuloIntegracionDAO;
	}

	public void setMensajeriaG(MensajeriaG mensajeriaG) {
		this.mensajeriaG = mensajeriaG;
	}
	
	

	public void setAccionIntegracionRegistroCondicionComercialGestor(IAccionIntegracionRegistroProveedorGestor accionIntegracionRegistroCondicionComercialGestor) {
		this.accionIntegracionRegistroCondicionComercialGestor = accionIntegracionRegistroCondicionComercialGestor;
	}



	/**
	 * Clase que permite encapsular los parametros para enviar las condiciones comerciales al sic
	 * @author gaortiz
	 *
	 */
	public class CondicionComercialEmbeddable implements Comparator<String>{
		private final Integer codigoCompania;
		private final String codigoProveedor;
		private final String codigoJDEProveedor;
		private final String idUsuarioActual;
		private final Set<String> codigosClasificacion;
		
		public CondicionComercialEmbeddable(Integer codigoCompania, String codigoProveedor, String codigoJDEProveedor, String idUsuarioActual, Set<String> codigosClasificacion) {
			super();
			this.codigoCompania = codigoCompania;
			this.codigoProveedor = codigoProveedor;
			this.codigoJDEProveedor = codigoJDEProveedor;
			this.idUsuarioActual = idUsuarioActual;
			this.codigosClasificacion = codigosClasificacion;
		}


		@Override
		public int compare(java.lang.String o1, java.lang.String o2) {
			return o1.compareTo(o2);
		}
		
		
		public final Integer getCodigoCompania() {
			return codigoCompania;
		}


		public final String getCodigoProveedor() {
			return codigoProveedor;
		}


		public final String getCodigoJDEProveedor() {
			return codigoJDEProveedor;
		}


		public final String getIdUsuarioActual() {
			return idUsuarioActual;
		}


		public final Set<String> getCodigosClasificacion() {
			return codigosClasificacion;
		}
	}

	/**
	 * @param articuloMigracionArticuloPortalDAO the articuloMigracionArticuloPortalDAO to set
	 */
	public void setArticuloMigracionArticuloPortalDAO(IArticuloMigracionArticuloPortalDAO articuloMigracionArticuloPortalDAO) {
		this.articuloMigracionArticuloPortalDAO = articuloMigracionArticuloPortalDAO;
	}

	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}

	@Override
	public Collection<ArticuloProveedorDTO> obtenerArticulosProveedor(Integer codigoCompania, Set<String> codigosArticulos, Set<String> codigosProveedores) throws SICException {
		return this.articuloIntegracionDAO.obtenerArticulosProveedor(codigoCompania, codigosArticulos, codigosProveedores);
	}

	public void setArticuloPendienteIntegracionDAO(IArticuloPendienteIntegracionDAO articuloPendienteIntegracionDAO) {
		this.articuloPendienteIntegracionDAO = articuloPendienteIntegracionDAO;
	}

	public void setArticuloAccionDAO(IAccionArticuloDAO articuloAccionDAO) {
		this.articuloAccionDAO = articuloAccionDAO;
	}
}
