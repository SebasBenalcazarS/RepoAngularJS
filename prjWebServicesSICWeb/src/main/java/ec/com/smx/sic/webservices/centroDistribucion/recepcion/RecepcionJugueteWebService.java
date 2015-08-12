/*
 * Kruger 2014 
 */
package ec.com.smx.sic.webservices.centroDistribucion.recepcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.smx.corpv2.common.factory.CorporativoFactory;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.EstablecimientoCiudadDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.bodega.IConstantesRecepcionJuguetes;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.ordenCompra.SICOrdenCompraConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionJugueteDTO;

/**
 * <b> Web services usados en la recepcion de juguetes. </b>
 * 
 * @author mchiliquinga, Date: 07/04/2014
 * 
 */
@Controller
@Scope(value = "request")
public class RecepcionJugueteWebService {

	@Autowired
	@Qualifier("gson")
	private Gson gson;
	
	private static final ValidatorImpl VALIDADOR = new ValidatorImpl();
	

	/**
	 * <b> Verifica que la cadena que se pasa como parametro sea un codigo de barras valido; este metodo es utilizado desde un archivo js (main.js) en
	 * la recepcion de juguetes . </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 11/04/2014]
	 * </p>
	 * 
	 * @param codigoBarrasEAN
	 *            es el codigo de barras que se le envia desde js (slickGrid)
	 * @return
	 */
	@RequestMapping(value = "/codigoBarrasValidador", method = RequestMethod.GET)
	public @ResponseBody String validarCodigoBarras(@RequestParam(value = "codigoBarrasEAN", required = false) String codigoBarrasEAN) {
		String estadoValidado = null;
		Map<String, String> datosValidador = new HashMap<String, String>();
		String errorMessage = "Por favor ingrese un c\u00f3digo de barras v\u00e1lido";
		try {
			if (StringUtils.isEmpty(codigoBarrasEAN)) {
				throw new SICException(errorMessage);
			}
			if (!(VALIDADOR.validateEAN(codigoBarrasEAN) || validarCodigoInternoExistente(codigoBarrasEAN))) {
				throw new SICException(errorMessage);
			}
			SICFactory.getInstancia().articulo.getArticuloValidacionServicio().validarCondigoEANunico(codigoBarrasEAN, null);
			datosValidador.put("id", "1");
			datosValidador.put("codigoValido", "true");
			datosValidador.put("errorMessage", "");
		} catch (RuntimeException e) {
			datosValidador.put("id", "0");
			datosValidador.put("codigoValido", "false");
			datosValidador.put("errorMessage", e.getMessage());
		}
		estadoValidado = gson.toJson(datosValidador);
		Logeable.LOG_SICV2.info("estadoValidado: {}", estadoValidado);
		return estadoValidado;
	}
	
	public Boolean validarCodigoInternoExistente(String codigoIngresado) {
		Boolean respuesta = Boolean.FALSE;
		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasPlantilla = new ArticuloBitacoraCodigoBarrasDTO();
		articuloBitacoraCodigoBarrasPlantilla.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articuloBitacoraCodigoBarrasPlantilla.getId().setCodigoBarras(codigoIngresado);
		articuloBitacoraCodigoBarrasPlantilla.setCodigoTipoCodigoArticulo(SICArticuloConstantes.TIPO_CODBAR_INTERNO);
		articuloBitacoraCodigoBarrasPlantilla.setArticulo(new ArticuloDTO());
		articuloBitacoraCodigoBarrasPlantilla.getArticulo().setCodigoEstado(SICArticuloConstantes.ESTADOARTICULO_CODIFICADO);
		articuloBitacoraCodigoBarrasPlantilla.getArticulo().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		Collection<ArticuloBitacoraCodigoBarrasDTO> resultadoCol = SICFactory.getInstancia().administracion.getDataService().findObjects(
				articuloBitacoraCodigoBarrasPlantilla);
		if (CollectionUtils.isNotEmpty(resultadoCol)) {
			respuesta = Boolean.TRUE;
		}

		return respuesta;
	}
	 
	/**
	 * <b> Crea una cadena de tipo JSON la cual contiene los articulos que tienen conflicto con los codigos de barras. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 21/05/2014]
	 * </p>
	 * 
	 * @param codigoBarrasEAN
	 *            codigo de barras enviado desde el SlickGrid cuando existe conflictos en dicho codigo
	 * @param codigoCompania
	 *            es elo codigo de la compania
	 * @param codigoProveedor
	 *            condigo del proveedor con el cual se esta realizando la recepcion
	 * @param referenciaProveedor
	 *            codigo de referencia del proveedor del articulo original
	 * @return cadena JSON con los datos del articulo para realizar el cambio
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/obtenerArticuloExistentes", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> obtenerDatosArticulosExistentes(@RequestParam(value = "codigoBarrasEAN", required = false) String codigoBarrasEAN, 
			@RequestParam(value = "codigoCompania", required = false) String codigoCompania, 
			@RequestParam(value = "codigoProveedor", required = false) String codigoProveedor,
			@RequestParam(value = "referenciaProveedor", required = false) String referenciaProveedor) {
		String datosArticulosJSON = null;
		Map<String, Object> datosArticulosMap = null;
		String estadoValidado = null;
		Collection<Map<String, Object>> datosArticulosCol = new ArrayList<Map<String, Object>>();
		Map<String, String> datosValidador = new HashMap<String, String>();

		CatalogoValorDTO usoCatalogoValor = new CatalogoValorDTO();
		usoCatalogoValor.getId().setCodigoCatalogoTipo(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
		usoCatalogoValor.getId().setCodigoCatalogoValor(SICArticuloConstantes.VALORUSOUNIMANCOMPRA );
		
		try {
			Collection<ArticuloDTO> articulosPorCodigoBarras = SICFactory.getInstancia().articulo.getArticuloCalculoService()
					.buscarArticulosPorCodigoBarrasUso(Integer.valueOf(codigoCompania), codigoBarrasEAN, usoCatalogoValor, codigoProveedor);

			int id = 1;
			if (CollectionUtils.isEmpty(articulosPorCodigoBarras)) {
				datosValidador.put("id", "t");
				datosValidador.put("esValido", "true");
				datosValidador.put("articulosCol", "");
				datosValidador.put("errorMessage", "");
			} else {
				//Validacion de articulos inactivos con codigos de barras asociados
				BeanPredicate articuloActivoPredicate = new BeanPredicate("estadoArticulo",
						PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO));
				Collection<ArticuloDTO> articulosActivosPorCodigoBarras = CollectionUtils.select(articulosPorCodigoBarras,
						articuloActivoPredicate);

				BeanPredicate articuloInactivoPredicate = new BeanPredicate("estadoArticulo",
						PredicateUtils.equalPredicate(SICConstantes.ESTADO_INACTIVO_NUMERICO));
				Collection<ArticuloDTO> articulosInactivosPorCodigoBarras = CollectionUtils.select(articulosPorCodigoBarras,
						articuloInactivoPredicate);	
					
				if (CollectionUtils.isEmpty(articulosInactivosPorCodigoBarras)
						&& CollectionUtils.isNotEmpty(articulosActivosPorCodigoBarras)) {
					Collection<Map<String, String>> datosUnidadManejo = null;
					Map<String, String> datosUnidadManejoArticulo = null;
					for (ArticuloDTO articulo : articulosActivosPorCodigoBarras) {
						datosArticulosMap = new HashMap<String, Object>();
						datosUnidadManejo = new ArrayList<Map<String, String>>();
						id++;
						datosArticulosMap.put("id", String.valueOf(id));
						datosArticulosMap.put("codigoArticulo", articulo.getId().getCodigoArticulo());
						datosArticulosMap.put("descripcionArticulo", articulo.getDescripcionArticulo());
						datosArticulosMap.put("codigoBarras", articulo.getCodigoBarrasActivo().getId().getCodigoBarras());
						datosArticulosMap.put("codigoClasificacion", articulo.getClasificacionDTO().getId().getCodigoClasificacion());
						datosArticulosMap.put("descripcionClasificacion", articulo.getClasificacionDTO().getDescripcionClasificacion());
						agregarCodigoreferenciaProveedor(datosArticulosMap, articulo, referenciaProveedor);
						if (CollectionUtils.isNotEmpty(articulo.getArticuloUnidadManejoCol())) {
							for (ArticuloUnidadManejoDTO articuloUnidadManejo : articulo.getArticuloUnidadManejoCol()) {
								datosUnidadManejoArticulo = new HashMap<String, String>();
								datosUnidadManejoArticulo.put("codigoUnidadManejo", articuloUnidadManejo.getId().getCodigoUnidadManejo().toString());
								datosUnidadManejoArticulo.put("valorUnidadManejo", articuloUnidadManejo.getValorUnidadManejo().toString());	
								datosUnidadManejoArticulo.put("tipoUnidadManejo", articuloUnidadManejo.getValorTipoUnidadEmpaque());
								datosUnidadManejo.add(datosUnidadManejoArticulo);
							}
						}
						datosArticulosMap.put("unidadesManejo", datosUnidadManejo);
						datosArticulosCol.add(datosArticulosMap);
					}
					datosArticulosMap = new HashMap<String, Object>();
					datosArticulosMap.put("id", "interno");
					datosArticulosMap.put("codigoBarras", "Codigo interno");
					datosArticulosCol.add(datosArticulosMap);
					
					datosArticulosJSON = gson.toJson(datosArticulosCol);
					Logeable.LOG_SICV2.info("articulos: {}", datosArticulosJSON);
					datosValidador.put("id", "f");
					datosValidador.put("esValido", "false");
					datosValidador.put("errorMessage", "");
					datosValidador.put("articulosCol", datosArticulosJSON);					
				} else if (CollectionUtils.isNotEmpty(articulosInactivosPorCodigoBarras)
						&& CollectionUtils.isEmpty(articulosActivosPorCodigoBarras)) {
					datosValidador.put("id", "t");
					datosValidador.put("esValido", "0");
					datosValidador.put("articulosCol", "");
					datosValidador.put("errorMessage", "");
					datosValidador.put("esReutilizacionCodigoBarras", "true");
				} else if (CollectionUtils.isNotEmpty(articulosInactivosPorCodigoBarras)
						&& CollectionUtils.isNotEmpty(articulosActivosPorCodigoBarras)) {
					throw new SICException("Existe inconsistencia de datos.");
				}
			}
		} catch (RuntimeException e) {
			Logeable.LOG_SICV2.info("error: {}", e);
			datosValidador.clear();
			datosValidador.put("id", "0");
			datosValidador.put("esValido", "no");
			datosValidador.put("errorMessage", "");
			datosValidador.put("articulosCol", "");
		}
		estadoValidado = gson.toJson(datosValidador);
		Logeable.LOG_SICV2.info("estadoValidado: {}", estadoValidado);
		return new ResponseEntity<String>(estadoValidado, createHttpHeaders(), HttpStatus.OK);
	}	
	
	/**
	 * <b> Agrega el codigo de referencia del proveedor; si el articulo con el cual se ca a realizar el remplazo no esta asociado al
	 * proveedor se despliega el codigo de referncia que tiene el articulo original. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 17/07/2015]
	 * </p>
	 * 
	 * @param datosArticulosMap
	 *            mapa para crear la cadena JSON
	 * @param articulo
	 *            es el articulo con el cual se realiza el remplazo
	 * @param referenciaProveedor
	 *            es el codigo de referencia del proveedor del articulo original
	 */
	private void agregarCodigoreferenciaProveedor(Map<String, Object> datosArticulosMap, ArticuloDTO articulo, String referenciaProveedor) {
		if (CollectionUtils.isNotEmpty(articulo.getArticuloProveedorCol())) {
			datosArticulosMap.put("codigoReferenciaProveedor", articulo.getArticuloProveedorCol().iterator().next()
					.getCodigoReferenciaProveedor());
		} else {
			datosArticulosMap.put("codigoReferenciaProveedor", referenciaProveedor);
		}
	}
	
	@RequestMapping(value = "/datosArticulos", method = RequestMethod.GET)
	@Deprecated
	public @ResponseBody String obtenerDatosArticulos(@RequestParam(value = "codigoBarrasEAN", required = false) String codigoBarrasEAN, 
			@RequestParam(value = "codigoCompania", required = false) String codigoCompania) {
		String datosArticulosJSON = null;
		Map<String, String> datosArticulosMap = null;
		Collection<Map<String, String>> datosArticulosCol = new ArrayList<Map<String, String>>();
		Collection<ArticuloDTO> articulosPorCodigoBarras = SICFactory.getInstancia().articulo.getArticuloCalculoService().buscarArticulosPorCodigoBarras(
				Integer.valueOf(codigoCompania), codigoBarrasEAN);
		int id = 0;
		for (ArticuloDTO articulo : articulosPorCodigoBarras) {
			datosArticulosMap = new HashMap<String, String>();
			id++;
			datosArticulosMap.put("id", String.valueOf(id));
			datosArticulosMap.put("codigoArticulo", articulo.getId().getCodigoArticulo());
			datosArticulosMap.put("descripcionArticulo", articulo.getDescripcionArticulo());
			datosArticulosMap.put("codigoBarras", articulo.getArtBitCodBarCol().iterator().next().getId().getCodigoBarras());
			datosArticulosCol.add(datosArticulosMap);
		}
		
		datosArticulosJSON = gson.toJson(datosArticulosCol);
		Logeable.LOG_SICV2.info("estadoValidado: {}", datosArticulosJSON);
		return datosArticulosJSON;
	}
	
	/**
	 * <b> Realiza la actualizacion con el dato seleccionado en el popUp de la recepcion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 21/05/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoProveedor
	 * @return
	 */ 
	@RequestMapping(value = "/actualizarArticuloOrdenCompra", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> actualizarArticuloOrdenCompra(@RequestParam(value = "codigoCompania", required = false) String codigoCompania,
			@RequestParam(value = "codigoOrdenCompraDetalleEstado", required = false) String codigoOrdenCompraDetalleEstado,
			@RequestParam(value = "codigoArticulo", required = false) String codigoArticulo,
			@RequestParam(value = "codigoUnidadManejo", required = false) String codigoUnidadManejo,
			@RequestParam(value = "valorUnidadManejo", required = false) String valorUnidadManejo,
			@RequestParam(value = "codigoProveedor", required = false) String codigoProveedor,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "codigoEmbarque", required = false) String codigoEmbarque,
			@RequestParam(value = "accessItem", required = false) String accessItem,
			@RequestParam(value = "systemId", required = false) String systemId) {
		
		String retorno="";
		Map<String, String> datosValidador = new HashMap<String, String>();
		
		String datosActualizados;
		try {
			Long codigoUnidadManejoP = codigoUnidadManejo != null && !codigoUnidadManejo.equals("null") ? Long.valueOf(codigoUnidadManejo): null;
			Integer valorUnidadManejoP = valorUnidadManejo != null ?  Integer.valueOf(valorUnidadManejo): null;
			VistaRecepcionJugueteDTO recepcionJuguete = new VistaRecepcionJugueteDTO();
			recepcionJuguete.setCodigoUnidadManejo(codigoUnidadManejoP);
			recepcionJuguete.setCantidadUnidadManejo(valorUnidadManejoP);
			recepcionJuguete.getId().setCodigoArticulo(codigoArticulo);
			recepcionJuguete.getId().setCodigoCompania(Integer.valueOf(codigoCompania));
			recepcionJuguete.getId().setCodigoProveedor(codigoProveedor);
			recepcionJuguete.getId().setCodigoEmbarque(Long.valueOf(codigoEmbarque));
			recepcionJuguete.getId().setCodigoOrdenCompraDetalleEstado(Long.valueOf(codigoOrdenCompraDetalleEstado));
			
			List<VistaRecepcionJugueteDTO> datosRecepcion = (List<VistaRecepcionJugueteDTO>) SICFactory.getInstancia().bodega
					.getRecepcionBodegaServicio().transCambiarArticuloOrdenCompraDetalleEstado(recepcionJuguete, systemId, accessItem,
							userId);
			datosActualizados = SICFactory.getInstancia().bodega.getRecepcionBodegaServicio().crearDatosSlickGrid(datosRecepcion);
			
			datosValidador.put("id", "1");
			datosValidador.put("codigoValido", "true");
			datosValidador.put("errorMessage", "");
			datosValidador.put("datosRecepcion", datosActualizados);
		} catch (RuntimeException e) {
			datosValidador.put("id", "0");
			datosValidador.put("codigoValido", "false");
			datosValidador.put("datosRecepcion", "");
			datosValidador.put("errorMessage", e.getMessage());
			Logeable.LOG_SICV2.info("error: {}", e);
		}
		retorno = gson.toJson(datosValidador);
		Logeable.LOG_SICV2.info("estadoValidado: {}", retorno);
		return new ResponseEntity<String>(retorno, createHttpHeaders(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/undoBarCodeWS", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> undoBarCode(@RequestParam(value = "codigoCompania", required = false) String codigoCompania,
			@RequestParam(value = "codigoOrdenCompraDetalleEstado", required = false) String codigoOrdenCompraDetalleEstado,
			@RequestParam(value = "codigoArticulo", required = false) String codigoArticulo,
			@RequestParam(value = "codigoUnidadManejo", required = false) String codigoUnidadManejo,
			@RequestParam(value = "codigoProveedor", required = false) String codigoProveedor,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "codigoEmbarque", required = false) String codigoEmbarque) {

		String retorno="";
		Map<String, String> restarData = new HashMap<String, String>();
		
		String datosActualizados;
		try {
			List<VistaRecepcionJugueteDTO> datosRecepcion = (List<VistaRecepcionJugueteDTO>) SICFactory.getInstancia().bodega.getRecepcionBodegaServicio()
					.transReversaArticuloOrdenCompraDetalleEstado(Integer.valueOf(codigoCompania), Long.valueOf(codigoOrdenCompraDetalleEstado), codigoArticulo,
							Long.valueOf(codigoUnidadManejo), codigoProveedor, userId, Long.valueOf(codigoEmbarque));
			
			eliminarCodigoBarrasEnCodigoInterno(datosRecepcion);
			datosActualizados = SICFactory.getInstancia().bodega.getRecepcionBodegaServicio().crearDatosSlickGrid(datosRecepcion);
			restarData.put("id", "1");
			restarData.put("codigoRetorno", "true");
			restarData.put("datosArticuloRestaurado", datosActualizados);
			restarData.put("errorMessage", "");
		} catch (Exception e) {
			restarData.put("id", "0");
			restarData.put("codigoRetorno", "false");
			restarData.put("datosArticuloRestaurado", "");
			restarData.put("errorMessage", "Error al realizar la actualizacion del articulo");
			Logeable.LOG_SICV2.info("error: {}", e);
		}
		retorno = gson.toJson(restarData);
		Logeable.LOG_SICV2.info("estadoValidado: {}", retorno);
		return new ResponseEntity<String>(retorno, createHttpHeaders(), HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/marcasComercialesWS", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> obtenerMarcasComerciales(@RequestParam(value = "codigoCompania", required = false) String codigoCompania,
			@RequestParam(value = "codigoProveedor", required = false) String codigoProveedor, @RequestParam(value = "userId", required = false) String userId) {

		String retorno="";
		Map<String, String> datosPopUpJSON = new HashMap<String, String>();
		String datosMarcaJSON = null;
		Collection<ProveedorMarcaDTO> datosMarcaProveedor = null;
		BeanPredicate beanPredicate = null;

		try {
			Collection<ProveedorMarcaDTO> marcasProveedor = null;
			if (StringUtils.isNotEmpty(codigoProveedor) && !StringUtils.contains(codigoProveedor, "null")) {
				marcasProveedor = SICFactory.getInstancia().proveedor.getMarcaProveedorServicio().obtenerProveedorMarcaFuncionario(Integer.valueOf(codigoCompania),
						new HashSet<String>(Arrays.asList(codigoProveedor.split(","))), userId);
			} else{
				marcasProveedor = SICFactory.getInstancia().proveedor.getMarcaProveedorServicio().obtenerProveedorMarcaFuncionario(Integer.valueOf(codigoCompania),
						null, userId);
			}
			
			if (CollectionUtils.isEmpty(marcasProveedor)) {
				throw new SICException("No existen datos para mostrar");
			}
			
			if (StringUtils.isNotEmpty(codigoProveedor) && StringUtils.contains(codigoProveedor, ",")) {
				datosMarcaProveedor = marcasProveedor;
				beanPredicate = new BeanPredicate("id.secuencialMarca", PredicateUtils.uniquePredicate());
				marcasProveedor = CollectionUtils.select(marcasProveedor, beanPredicate);
			}
			
			Map<String, String> datosMarcaMap = null;
			Collection<Map<String, String>> datosMarcaCol = new ArrayList<Map<String, String>>();
			int id = 0;
			for (ProveedorMarcaDTO proveedorMarca : marcasProveedor) {
				datosMarcaMap = new HashMap<String, String>();
				id++;
				datosMarcaMap.put("id", String.valueOf(id));
				datosMarcaMap.put("codigoProveedor", String.valueOf(proveedorMarca.getId().getCodigoProveedor()));
				datosMarcaMap.put("tipoMarca", proveedorMarca.getMarcaArticuloDTO().getNombre());
				datosMarcaMap.put("secuencialMarca", proveedorMarca.getMarcaArticuloDTO().getId().getSecuencialMarca().toString());
				datosMarcaMap.put("valorTipoMarca", proveedorMarca.getMarcaArticuloDTO().getValorTipoMarca());
				datosMarcaMap.put("codigosProveedores", crearDatosCodigosProveedorMarca(
						codigoProveedor, beanPredicate, proveedorMarca.getId().getSecuencialMarca(), datosMarcaProveedor));
				datosMarcaCol.add(datosMarcaMap);
			}
			datosMarcaJSON = gson.toJson(datosMarcaCol);
			datosPopUpJSON.put("id", "1");
			datosPopUpJSON.put("codigoRetorno", "true");
			datosPopUpJSON.put("datosMarcas", datosMarcaJSON);
			datosPopUpJSON.put("errorMessage", "");
		} catch (RuntimeException e) {
			datosPopUpJSON.put("id", "0");
			datosPopUpJSON.put("codigoRetorno", "false");
			datosPopUpJSON.put("datosMarcas", "");
			datosPopUpJSON.put("errorMessage", e.getMessage());
			Logeable.LOG_SICV2.info("error: {}", e);
		}
		retorno = gson.toJson(datosPopUpJSON);
		Logeable.LOG_SICV2.info("datos popUp marcas: {}", retorno);
		return new ResponseEntity<String>(retorno, createHttpHeaders(), HttpStatus.OK);
	}
	
	/**
	 * <b> Retorna una cadela JSON la cual es una coleccion que tiene todos los prototipos existentes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/06/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @return
	 */ 
	@RequestMapping(value = "/prototiposColWS", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> obtenerPrototiposCol(@RequestParam(value = "codigoCompania", required = false) String codigoCompania) {
		String datosMarcaJSON = null;
		try {
			Collection<GrupoTrabajoDTO> prototipos = SICFactory.getInstancia().bodega.getRecepcionBodegaServicio().obtenerPrototipos(Integer.valueOf(codigoCompania));
			if (CollectionUtils.isEmpty(prototipos)) {
				throw new SICException("No existen datos para mostrar");
			}
			
			Map<String, String> datosMarcaMap = null;
			Collection<Map<String, String>> datosMarcaCol = new ArrayList<Map<String, String>>();
			int id = 0;
			for (GrupoTrabajoDTO grupoTrabajo : prototipos) {
				datosMarcaMap = new HashMap<String, String>();
				id++;
				datosMarcaMap.put("id", String.valueOf(id));
				datosMarcaMap.put("codigoGrupoTrabajo", String.valueOf(grupoTrabajo.getId().getCodigoGrupoTrabajo()));
				datosMarcaMap.put("nombrePrototipo", grupoTrabajo.getNombreGrupoTrabajo());
				datosMarcaMap.put("descripcionPrototipo", grupoTrabajo.getDescripcionGrupoTrabajo());
				datosMarcaCol.add(datosMarcaMap);
			}
			datosMarcaJSON = gson.toJson(datosMarcaCol);
		} catch (RuntimeException e) {
			Logeable.LOG_SICV2.info("error: {}", e);
		}
		Logeable.LOG_SICV2.info("datos popUp marcas: {}", datosMarcaJSON);
		return new ResponseEntity<String>(datosMarcaJSON, createHttpHeaders(), HttpStatus.OK);
	}
	
	/**
	 * <b> Obtiene todas las unidades de manejo asosciadas a un articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/06/2014]
	 * </p>
	 * 
	 * @param codigoArticulo
	 * @return
	 */ 
	@RequestMapping(value = "/unidadesManejoPorArticuloWS", method = RequestMethod.GET)
	public @ResponseBody String obtenerUnidadesManejoPorArticulo(@RequestParam(value = "codigoArticulo", required = false) String codigoArticulo) {
		String estadoValidado = null;
		Map<String, String> datosUnidadManejo = new HashMap<String, String>();
		try {
			if (StringUtils.isBlank(codigoArticulo)) {
				throw new SICException("No existen datos para mostrar");
			}
			
			ArticuloDTO articuloDTO = new ArticuloDTO();
			articuloDTO.getId().setCodigoArticulo(codigoArticulo);
			Collection<ArticuloUnidadManejoDTO> unidadesManejo = SICFactory.getInstancia().articulo.getArticuloService().obtenerUnidadesManejoActivasPorArticulo(
					articuloDTO);
			if (CollectionUtils.isEmpty(unidadesManejo)) {
				throw new SICException("No existen datos para mostrar");
			} 
			
			int id = 0;
			Map<String, String> datosUnidadManejoArticulo = null;
			Collection<Map<String, String>> datosUnidadManejoCol = new ArrayList<Map<String, String>>();
			String datosUnidadesManejoJSON = null;
			for (ArticuloUnidadManejoDTO unidadManejo : unidadesManejo) {
				datosUnidadManejoArticulo = new HashMap<String, String>();
				id++;
				datosUnidadManejoArticulo.put("id", String.valueOf(id));
				datosUnidadManejoArticulo.put("codigoUnidadManejo", unidadManejo.getId().getCodigoUnidadManejo().toString());
				datosUnidadManejoArticulo.put("valorUnidadManejo", unidadManejo.getValorUnidadManejo().toString());
				datosUnidadManejoArticulo.put("unidadEmpaque", unidadManejo.getValorTipoUnidadEmpaque());
				datosUnidadManejoCol.add(datosUnidadManejoArticulo);
			}
			datosUnidadesManejoJSON = gson.toJson(datosUnidadManejoCol);
			datosUnidadManejo.put("id", "1");
			datosUnidadManejo.put("codigoRetorno", "true");
			datosUnidadManejo.put("datosUnidadManejo", datosUnidadesManejoJSON);
			datosUnidadManejo.put("errorMessage", "");
		} catch (RuntimeException e) {
			datosUnidadManejo.put("id", "0");
			datosUnidadManejo.put("codigoRetorno", "false");
			datosUnidadManejo.put("datosUnidadManejo", "");
			datosUnidadManejo.put("errorMessage", e.getMessage());
			Logeable.LOG_SICV2.info("error: {}", e);
		}
		estadoValidado = gson.toJson(datosUnidadManejo);
		Logeable.LOG_SICV2.info("datosUnidadManejo: {}", estadoValidado);
		return estadoValidado;
	}
	
	/**
	 * <b> Obtiene los locales de un grupo de alcance; si el codigo del grupo de trabajo es personalizado, obtiene todos los locales existentes.
	 * </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/06/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoGrupoTrabajo
	 * @return
	 */ 
	public Collection<GrupoAreaTrabajoDTO> cargarLocalesPrototipoAlcance(Integer codigoCompania, Long codigoGrupoTrabajo) {
		if (SICArticuloConstantes.CODIGOPROTOTIPOPERSONALIZADO.longValue() == codigoGrupoTrabajo.longValue()) {
			return crearGruposAreaTrabajoPersonalizadas(codigoCompania);
		} else {
			return obtenerGrupoAreasTrabajoPorId(codigoCompania, codigoGrupoTrabajo);
		}
	}
	
	/**
	 * <b> Obtiene todos los locales existentes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/07/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @return
	 */ 
	public Collection<AreaTrabajoDTO> obtenberAreasTrabajoPersonalizadas(Integer codigoCompania) {
		AreaTrabajoDTO areaTrabajoFiltro = null;
		try {
			areaTrabajoFiltro = new AreaTrabajoDTO();
			areaTrabajoFiltro.getId().setCodigoCompania(codigoCompania);
			areaTrabajoFiltro.setTipoAreaTrabajoTIC(TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
			areaTrabajoFiltro.setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL);
			areaTrabajoFiltro.setEstadoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);
			areaTrabajoFiltro.setEstablecimientoCiudadDTO(new EstablecimientoCiudadDTO());
			areaTrabajoFiltro.getEstablecimientoCiudadDTO().setEstablecimientoDTO(new EstablecimientoDTO());
			areaTrabajoFiltro.setOrderByField(OrderBy.orderAsc(new String[] {"codigoEstablecimiento", "id.codigoAreaTrabajo"}));
			return CorporativoFactory.getInstancia().getDataService().findObjects(areaTrabajoFiltro);
		} catch (RuntimeException e) {
			Logeable.LOG_SICV2.error("Error al obtener los articulos personalizados", e);
			return null;
		}
	}
	
	/**
	 * <b> En base a la coleccion 'areasTrabajo' la cual representa todos los locales existentes, crea una coleccion de tipo GrupoAreaTrabajoDTO, esto
	 * en caso de que el prototipo de alcance sea personalizado, finalmente estos datos son los que se mostraran en el popUp de prototipos al tratar de
	 * modificarlos en pantalla. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/07/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @return
	 */ 
	public Collection<GrupoAreaTrabajoDTO> crearGruposAreaTrabajoPersonalizadas(Integer codigoCompania) {
		Collection<AreaTrabajoDTO> areasTrabajo = obtenberAreasTrabajoPersonalizadas(codigoCompania);
		Collection<GrupoAreaTrabajoDTO> grupoAreasTrabajos = null;
		GrupoAreaTrabajoDTO grupoAreaTrabajo;
		if (CollectionUtils.isNotEmpty(areasTrabajo)) {
			grupoAreasTrabajos = new ArrayList<GrupoAreaTrabajoDTO>();
			for (AreaTrabajoDTO areaTrabajo : areasTrabajo) {
				grupoAreaTrabajo = new GrupoAreaTrabajoDTO();
				grupoAreaTrabajo.setAreaTrabajoDTO(areaTrabajo);
				grupoAreasTrabajos.add(grupoAreaTrabajo);
			}
		}
		return grupoAreasTrabajos;
	}
	
	/**
	 * <b> Obtiene una coleccion de tipo GrupoAreaTrabajoDTO filtrata por el id selecciona en el comboBox del popUp de prototipos. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/07/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoGrupoTrabajo
	 *            codigo del prototipo de lacance seleccioando en el combo
	 * @return
	 */ 
	public Collection<GrupoAreaTrabajoDTO> obtenerGrupoAreasTrabajoPorId(Integer codigoCompania, Long codigoGrupoTrabajo) {
		GrupoAreaTrabajoDTO filtro;
		filtro = new GrupoAreaTrabajoDTO();
		filtro.getId().setCodigoCompania(codigoCompania);
		filtro.getId().setCodigoGrupoTrabajo(codigoGrupoTrabajo);
		filtro.setAreaTrabajoDTO(new AreaTrabajoDTO());
		filtro.getAreaTrabajoDTO().setTipoAreaTrabajoTIC(TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		filtro.getAreaTrabajoDTO().setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL);
		filtro.getAreaTrabajoDTO().setEstadoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);
		filtro.getAreaTrabajoDTO().setEstablecimientoCiudadDTO(new EstablecimientoCiudadDTO());
		filtro.getAreaTrabajoDTO().getEstablecimientoCiudadDTO().setEstablecimientoDTO(new EstablecimientoDTO());
		filtro.setEstadoGrupoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);
		filtro.setOrderByField(OrderBy.orderAsc(new String[] {"areaTrabajoDTO.codigoEstablecimiento", "id.codigoAreaTrabajo"}));
		return SICFactory.getInstancia().administracion.getDataService().findObjects(filtro);
	}
	
	/**
	 * <b> Obtiene todos los locales de un grupo de trabaja. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 16/07/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoGrupoTrabajo
	 * @return
	 */ 
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/localesPorGrupoTrabajoWS", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> obtenerLocalesPorGrupoTrabajo(@RequestParam(value = "codigoCompania", required = false) String codigoCompania, 
			@RequestParam(value = "codigoGrupoTrabajo", required = false) String codigoGrupoTrabajo, 
			@RequestParam(value = "codigoArticulo", required = false) String codigoArticulo,
			@RequestParam(value = "isEditPrototipo", required = false) String isEditPrototipo,
			@RequestParam(value = "codigoGrupoTrabajoBase", required = false) String codigoGrupoTrabajoBase) {
		String localesJSON = null;
		try {
			Integer codigoCompaniaValue = Integer.valueOf(codigoCompania);
			Long codigoGrupoTrabajoValue = Long.valueOf(codigoGrupoTrabajo);
			Collection<GrupoAreaTrabajoDTO> locales = cargarLocalesPrototipoAlcance(codigoCompaniaValue, codigoGrupoTrabajoValue);
			Map<String, String> local = null;
			Collection localesPrototipo = null;
			String predicatePropertie = Boolean.TRUE.toString().equals(isEditPrototipo) ? "areaTrabajoDTO.id.codigoAreaTrabajo" : "id.codigoLocal";
			Collection<Map<String, String>> datosLocalCol = new ArrayList<Map<String, String>>();
			StringBuilder establecimietoLocal = new StringBuilder();
			BeanPredicate beanPredicate = new BeanPredicate(predicatePropertie, null);
			localesPrototipo = definirDatosParaValidar(codigoCompaniaValue, codigoGrupoTrabajoValue, codigoGrupoTrabajoBase, isEditPrototipo,
					codigoArticulo);
			
			int id = 1;
			for (GrupoAreaTrabajoDTO establecimiento : locales) {
				local = new HashMap<String, String>();
				local.put("id", String.valueOf(id));
				local.put("nombreEstablecimiento", establecimiento.getAreaTrabajoDTO().getEstablecimientoCiudadDTO().getEstablecimientoDTO()
						.getNombreEstablecimiento());
				establecimietoLocal.append(establecimiento.getAreaTrabajoDTO().getId().getCodigoAreaTrabajo());
				establecimietoLocal.append(" - ");
				establecimietoLocal.append(establecimiento.getAreaTrabajoDTO().getEstablecimientoCiudadDTO().getEstablecimientoDTO()
						.getAbreviaturaEstablecimiento() == null ? "" : establecimiento.getAreaTrabajoDTO().getEstablecimientoCiudadDTO().getEstablecimientoDTO()
								.getAbreviaturaEstablecimiento() );
				establecimietoLocal.append(" - ");
				establecimietoLocal.append(establecimiento.getAreaTrabajoDTO().getNombreAreaTrabajo());
				local.put("local",establecimietoLocal.toString());
				local.put("codigoAreaTrabajo", establecimiento.getAreaTrabajoDTO().getId().getCodigoAreaTrabajo().toString());
				Boolean isSelected = validarLocalSelected(localesPrototipo, beanPredicate, establecimiento.getAreaTrabajoDTO().getId()
						.getCodigoAreaTrabajo());
				local.put("isSelected", isSelected.toString());
				datosLocalCol.add(local);
				id ++;
				establecimietoLocal.delete(0, establecimietoLocal.length());
			}
			localesJSON = gson.toJson(datosLocalCol);
			Logeable.LOG_SICV2.info("datos local: {}", localesJSON);
		} catch (RuntimeException e) {
			Logeable.LOG_SICV2.info("error: {}", e);
		}
		return new ResponseEntity<String>(localesJSON, createHttpHeaders(), HttpStatus.OK);
	}
	
	/**
	 * <b> En base a una coleccion de locales verifica si el codigo del area de trabajo que se le pasa como parametro se encuentra dentro de dicha
	 * coleccion, de ser ese el caso al personalizar el prototipo este se mostrara marcado(check box con visto). </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 06/11/2014]
	 * </p>
	 * 
	 * @param locales
	 *            son los locales donde tiene alcance el prototipo seleccionado
	 * @param beanPredicate
	 *            predicado que define si el local se muestra con un check o no
	 * @param codigoAreaTrabajo
	 *            es el codigo del area de trabajo que se evalua
	 * @return
	 */ 
	@SuppressWarnings("rawtypes")
	private Boolean validarLocalSelected(Collection locales, BeanPredicate beanPredicate, Integer codigoAreaTrabajo) {
		boolean existeAlcanceLocal = false;
		if (CollectionUtils.isNotEmpty(locales)) {
			beanPredicate.setPredicate(PredicateUtils.equalPredicate(codigoAreaTrabajo));
			existeAlcanceLocal = CollectionUtils.exists(locales, beanPredicate);
		}
		return existeAlcanceLocal;
	}
	
	/**
	 * <b> Obtiene una coleccion de tipo 'ArticuloLocalDTO' o 'GrupoAreaTrabajoDTO' el cual sirve para validar donde tiene alcance el prototipo
	 * seleccionado(mostrar marcado el checkbox del componente de prototipos), si el protipo del articulo es personalizado la validacion se debe
	 * realizar sobre la coleccion de tipo 'ArticuloLocalDTO', si se trata de personalizar un protipo en base a uno ya existente la validacion es
	 * sobre la coleccion de tipo GrupoAreaTrabajoDTO. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 06/11/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoGrupoTrabajo
	 *            codigo del grupo de trabajo personalizado
	 * @param codigoGrupoTrabajoBase
	 *            codigo del prototipo base para realizar la personalizacion
	 * @param isEditPrototipo
	 *            define si se esta personalizando un prototipo en base a uno existente
	 * @param codigoArticulo
	 *            es el codigo del articulo para obtener los datos para realizar la primera validacion
	 * @return
	 */ 
	@SuppressWarnings("rawtypes")
	private Collection definirDatosParaValidar(Integer codigoCompania, Long codigoGrupoTrabajo, String codigoGrupoTrabajoBase,
			String isEditPrototipo, String codigoArticulo) {
		Collection localesPrototipo = null;
		List<ArticuloLocalDTO> localesPorArticulo = null;
		Collection<GrupoAreaTrabajoDTO> localesPorGrupoTrabajo = null;
		if (SICArticuloConstantes.CODIGOPROTOTIPOPERSONALIZADO.longValue() == codigoGrupoTrabajo.longValue()
				&& StringUtils.isNotBlank(codigoArticulo)) {
			localesPorArticulo = SICFactory.getInstancia().bodega.getRecepcionBodegaServicio().obtenerLocalesPorArticulo(codigoCompania,
					codigoArticulo, SICConstantes.ESTADO_ACTIVO_NUMERICO);
			localesPrototipo = localesPorArticulo;
		}
		
		if (Boolean.TRUE.toString().equals(isEditPrototipo)) {
			localesPorGrupoTrabajo = obtenerGrupoAreasTrabajoPorId(codigoCompania, Long.valueOf(codigoGrupoTrabajoBase));
			localesPrototipo = localesPorGrupoTrabajo;
		}
		
		return localesPrototipo;
	}
	
	/**
	 * <b> Obtiene un parametro necesario para realizar la recepcion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 16/07/2014]
	 * </p>
	 * 
	 * @param codigoParametro
	 * @return
	 */ 
	@RequestMapping(value = "/obtenerParametroConstante", method = RequestMethod.GET)
	public @ResponseBody String obtenerParametroConstante(@RequestParam(value = "codigoParametro", required = false) String codigoParametro) {
		String parametroJSON = null;
		Map<String, String> parametro = new HashMap<String, String>();
		try {
			String valorParametro =  obtenerParametro(codigoParametro);
			parametro.put("valorParametro", valorParametro);
			parametro.put("estadoRetorno", "1");
			
		} catch (RuntimeException e) {
			Logeable.LOG_SICV2.info("error: {}", e);
			parametro.put("valorParametro", IConstantesRecepcionJuguetes.BLANK);
			parametro.put("estadoRetorno", "0");
		}
		parametroJSON = gson.toJson(parametro);
		Logeable.LOG_SICV2.info("datos parametro: {}", parametroJSON);
		return parametroJSON;
	}
	
	/**
	 * <b> En base a un identificador retorna el parametro solicitado. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 16/07/2014]
	 * </p>
	 * 
	 * @param codigoParametro
	 * @return
	 */ 
	private String obtenerParametro(String codigoParametro) {
		int valorCodigo = Integer.valueOf(codigoParametro);
		String valorRetorno = null;
		switch (valorCodigo) {
		case 0:
			valorRetorno = SICOrdenCompraConstantes.PEDIDO_MIGRACION_PRECODIFICAR.toString();
			break;
		case 1:
			valorRetorno = SICArticuloConstantes.CODIGOPROTOTIPOPERSONALIZADO.toString();
			break;
		case 2:
			valorRetorno = SICArticuloConstantes.ESTADOARTICULO_PRECODIFICADO;
			break;
		case 3:
			valorRetorno = SICArticuloConstantes.ESTADOARTICULO_CODIFICADO;
			break;
		case 4:
			TipoImpuestoDTO impuesto = new TipoImpuestoDTO();
			impuesto.getId().setCodigoTipoImpuesto(SICArticuloConstantes.TIPOIMPUESTO_OMISION_IDN);
			impuesto = SICFactory.getInstancia().administracion.getDataService().findUnique(impuesto);
			Double valorImpuesto = impuesto.getPorcentajeImpuesto();
			valorImpuesto = (valorImpuesto / 100);
			valorRetorno = valorImpuesto.toString();
			break;
		}
		
		return valorRetorno;
	}
	
	/**
	 * <b> Elimina el codigo de barras en caso de que el articulo sea precodificado y tenga codigo interno. 24-06-2014 En este punto la funcionalidad
	 * ha cambiado; basta con que el articulo se precodificado para que el codigo de barras este en blanco </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 28/04/2014]
	 * </p>
	 * 
	 * @param vistaRecepcionJuguetes
	 */ 
	private void eliminarCodigoBarrasEnCodigoInterno(List<VistaRecepcionJugueteDTO> vistaRecepcionJuguetes) {
		for (VistaRecepcionJugueteDTO vistaRecepcionJuguete : vistaRecepcionJuguetes) {
			if (SICArticuloConstantes.ESTADOARTICULO_PRECODIFICADO.equals(vistaRecepcionJuguete.getEstadoArticulo())) {
				vistaRecepcionJuguete.setCodigoBarras(IConstantesRecepcionJuguetes.BLANK);
			}
		}
	}
	
	/**
	 * <b> Obtiene todos los codigos de proveedores asociados a una marca. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 29/07/2014]
	 * </p>
	 * 
	 * @param beanPredicate
	 * @param secuencialMarca
	 * @param datosMarcaProveedor
	 * @return
	 */ 
	@SuppressWarnings("unchecked")
	private String crearDatosCodigosProveedorMarca(String codigoProveedor, BeanPredicate beanPredicate, Long secuencialMarca,
			Collection<ProveedorMarcaDTO> datosMarcaProveedor) {
		StringBuilder codigosProveedores = null;
		if (StringUtils.isNotEmpty(codigoProveedor) && StringUtils.contains(codigoProveedor, ",")) {
			codigosProveedores = new StringBuilder();
			beanPredicate.setPredicate(PredicateUtils.equalPredicate(secuencialMarca));
			Collection<ProveedorMarcaDTO> proveedores = CollectionUtils.select(datosMarcaProveedor, beanPredicate);
			if (CollectionUtils.isNotEmpty(proveedores)) {
				for (ProveedorMarcaDTO proveedor : proveedores) {
					codigosProveedores.append(proveedor.getId().getCodigoProveedor());
					codigosProveedores.append(",");
				}
				codigosProveedores.delete(codigosProveedores.lastIndexOf(","), codigosProveedores.length());
			}
		}
		return codigosProveedores == null ? "" : codigosProveedores.toString();
	}
	
	/**
	 * <b> Valida que el articulo sea editable de acuerdo con las caracteristicas que posee. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 12/01/2015]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoClasificacion
	 *            es la clasififcacion del articulo
	 * @return cadena en formato JSON que define si es o no editable la fila seleccionada
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/definirArticuloEditable", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity<String> definirArticuloEditable(@RequestParam(value = "codigoCompania", required = false) String codigoCompania,
			@RequestParam(value = "codigoClasificacion", required = false) String codigoClasificacion) {
		String isArticuloEditable = null;
		Map<String, String> isEditableJSON;
		try {
			if (StringUtils.isBlank(codigoClasificacion)) {
				throw new SICException("El art\u00edculo no posee una clasificaci\u00f3n, revise por favor.");
			}
			
			isEditableJSON = new HashMap<String, String>();
			Integer codigoCompaniaValue = Integer.valueOf(codigoCompania);
			Collection<CaracteristicaDinamicaDTO> caracteristicasDinamicas;
			String isEditable = null;
			caracteristicasDinamicas = SICFactory.getInstancia().bodega.getRecepcionBodegaServicio().obtenerCaratecristicasDinamicas(
					codigoCompaniaValue, Collections.singleton(codigoClasificacion), TipoCatalogoArticulo.CARACTERISTICA_TIENEINDICADORPROPIETARIO);
			
			isEditable = CollectionUtils.isEmpty(caracteristicasDinamicas) ? Boolean.FALSE.toString() : Boolean.TRUE.toString();
			if (Boolean.FALSE.toString().equals(isEditable)) {
				throw new SICException("Las caracter\u00edsticas del art\u00edculo no permiten modificar el indicador propietario.");
			}
			isEditableJSON.put("isEditable", isEditable);
			isArticuloEditable = gson.toJson(isEditableJSON);
			return new ResponseEntity(isArticuloEditable, createHttpHeaders(), HttpStatus.OK);
		} catch (SICException e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al obteber los datos webService {}", e.getMessage());
			return createResponseError(e.getMessage());
		} catch (JsonIOException e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al obteber los datos webService {}", e.getMessage());
			return createResponseError(e.getMessage());
		}
	}
	
	/**
	 * <b> Crea un response de error para todos los casos que exista una excepcion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 12/01/2015]
	 * </p>
	 * 
	 * @param errorMessage mensaje de error que se agrega a la cadena JSON
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ResponseEntity createResponseError (String errorMessage) {
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("errorStatus", "1");
		responseMap.put("errorMessage", errorMessage);
		String resposeJSON = gson.toJson(responseMap);
		return new ResponseEntity(resposeJSON, createHttpHeaders(), HttpStatus.OK);
	}
	
	/**
	 * <b> Crea el Headers en formato JSON y la codificacion correspondiente. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 12/01/2015]
	 * </p>
	 * 
	 * @return
	 */
	private HttpHeaders createHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/jsonp; charset=utf-8");
		responseHeaders.add("Access-Control-Allow-Origin", "*");
		return responseHeaders;
	}
	
	/**
	 * <b> En caso de remplazar un articulo se debe validar que el dato por el cual se esta remplazando pertenezca a la bodega de juguetes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 12/01/2015]
	 * </p>
	 * 
	 * @param codigoClasificacion clasificacion del articulo seleccionado en el poopUp
	 * @return
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/validarArticuloBodegaJuguetes", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity<String> validarArticuloBodegaJuguetes(@RequestParam(value = "codigoClasificacion", required = false) String codigoClasificacion) {
		String estadoClasificacionJSON = null;
		Map<String, String> clasificacionJuguetesJSON = null;		
		try {
			if (StringUtils.isBlank(codigoClasificacion)) {
				throw new SICException("El art\u00edculo no posee una clasificaci\u00f3n, revise por favor.");
			}
			
			SICFactory.getInstancia().bodega.getRecepcionBodegaServicio().validarClasificacionBodegaJuguetes(codigoClasificacion,
					SICOrdenCompraConstantes.CODIGO_SUBBODEGA_JUGUETES, SICConstantes.ESTADO_ACTIVO_NUMERICO);
			clasificacionJuguetesJSON = new HashMap<String, String>();
			clasificacionJuguetesJSON.put("isClasificacionJuguetes", "true");
			estadoClasificacionJSON = gson.toJson(clasificacionJuguetesJSON);
			return new ResponseEntity(estadoClasificacionJSON, createHttpHeaders(), HttpStatus.OK);
		} catch (SICException e) {
			return createResponseError(e.getMessage());
		} catch (JsonIOException e) {
			return createResponseError(e.getMessage());
		}
	}
	
}
