package ec.com.smx.sic.webservices.fruver;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.framework.ad.json.JsonPojoMapper;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.fruver.FruverConstantes;
import ec.com.smx.sic.cliente.common.fruver.util.FruverDateUtil;
import ec.com.smx.sic.cliente.common.ordenCompra.SICOrdenCompraConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloOfertaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.FechaOfertaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.OfertaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroRangoFechaDTO;
import ec.com.smx.sic.web.proveedor.componente.filtrosbusquedaproveedor.FiltroBusquedaArticulo;
import ec.com.smx.sic.web.proveedor.constantes.TipoFiltroBusqueda;

/**
 * 
 * @author jcayo<josecayo4@gmail.com>
 *
 */

@Controller
@RequestMapping("/ws/ofertaProveedor")
@Scope(value = "request")
public class OfertaProveedor {

	@Autowired
	@Qualifier("gson")	
	private Gson gson;


	/**
	 * Método para consultar artículos de un  proveedor 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoBarras
	 * @param descripcion
	 * @param condicionalCodigoBarras
	 * @param condicionalDescripcion
	 * @param usuarioSesion
	 * @return
	 */
	@RequestMapping(value = "/buscarArticulos", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody
	ResponseEntity<String> buscarArticulos(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "codigoProveedor", required = true) String codigoProveedor,
			@RequestParam(value = "codigoBarras", required = false) String  codigoBarras,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "condicionalCodigoBarras", required = false) String  condicionalCodigoBarras,
			@RequestParam(value = "condicionalDescripcion", required = false) String condicionalDescripcion,
			@RequestParam(value = "usuarioSesion", required = true) String usuarioSesion) {



		DatosBusquedaArticulosJSON datosBusqueda = null;
		HttpHeaders headers = null;
		String datos = "[]";

		try{

			datosBusqueda = buscarArticulosOfertaProveedor(codigoCompania, codigoProveedor, codigoBarras, descripcion, condicionalCodigoBarras, condicionalDescripcion, usuarioSesion);
			if( datosBusqueda != null ){
				datos = JsonPojoMapper.getInstance().writeValueAsString(datosBusqueda);
			}

			headers = new HttpHeaders();					
			headers.add("Content-Type", "application/json; charset=utf-8");
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar articulos: {}", e.getMessage());
			return new ResponseEntity<String>(datos, headers, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/validarAccesoSolicitudes", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String>  validarAccesoSolicitudes(@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania){
		HttpHeaders headers = null;
		String datos = "{}";
		try{
			//obtener el parametro de rango para dias y horas de acceso
			ParametroRangoFechaDTO  parametroRangoFechaDTO = SICFactory.getInstancia().fruver.getFruverServicio().obtenerParametroRangoFecha(codigoCompania, FruverConstantes.CODIGO_RANGO_HORAS_FECHAS);
			//obtener el primer dia de la semana
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

			//obtener dia inicial y final del rango de validacion
			Date diaInicial =  FruverDateUtil.obtenerDiaHoras(cal.getTime(), parametroRangoFechaDTO.getDiaInicial(), parametroRangoFechaDTO.getHoraInicial());
			Date diaFinal = FruverDateUtil.obtenerDiaHoras(diaInicial, parametroRangoFechaDTO.getCantidadDias(), parametroRangoFechaDTO.getHoraFinal());			

			//se obtiene la fecha actual
			Date diaActual = Calendar.getInstance().getTime();					
			if(diaActual.compareTo(diaInicial) >= 0 && diaActual.compareTo(diaFinal) <= 0){				
				datos = JsonPojoMapper.getInstance().writeValueAsString(Boolean.TRUE);
			}else{
				datos = JsonPojoMapper.getInstance().writeValueAsString(Boolean.FALSE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar datos de acceso al sistema: {}", e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/esOfertaEnviada", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String>  esOfertaEnviada(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "codigoProveedor", required = true) String codigoProveedor){
		
		HttpHeaders headers = null;
		String datos = "{}";
		try{			
			datos = JsonPojoMapper.getInstance().writeValueAsString(SICFactory.getInstancia().fruver.getFruverServicio().esOfertaEnviada(codigoCompania, codigoProveedor));
		}catch(Exception e){
			LOG_SICV2.error("Error al validar el estado de la oferta: {}", e.getMessage());
			return new ResponseEntity<String>(datos, headers, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}


	/********SECCION GUARDADO DE DATOS ******************************************************************/	
	/**
	 * Permite registrar la informacion de las ofertas que realiza el proveedor para determinados productos
	 * @param datosArticuloCol Productos asociados al proveedor
	 * @return Status de la peticion
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/guardarOfertasProveedor/{codigoCompania}/{codigoOferta}/{codigoProveedor}", consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String>guardarOfertasProveedor(@PathVariable("codigoCompania") Integer codigoCompania,
			@PathVariable("codigoOferta") Long codigoOferta, @PathVariable("codigoProveedor") String codigoProveedor,  @RequestBody String datosArticuloCol) {		
		HttpHeaders headers = null;
		String dataOK = "{\"status\":\"OK\"}";
		String dataFail = "{\"status\":\"FAIL\"}";
		try {
			if(!datosArticuloCol.isEmpty()){

				String userId = "FRM0"; //TODO se debe eliminar al obtener el dato de session

				//validacion de codigoOferta
				codigoOferta = (codigoOferta == 0) ? null : codigoOferta;

				//Construir el objeto OfertaProveedorDTO			
				OfertaProveedorDTO ofertaProveedorDTO = new OfertaProveedorDTO();
				ofertaProveedorDTO.getId().setCodigoProveedor(codigoProveedor);
				ofertaProveedorDTO.getId().setCodigoCompania(codigoCompania);
				ofertaProveedorDTO.getId().setCodigoOferta(codigoOferta);
				ofertaProveedorDTO.setNumeroOferta("0000000001");
				ofertaProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);				
				ofertaProveedorDTO.setUserId(userId); //TODO asignar usuario de auditoria
				ofertaProveedorDTO.setFechaOfertaProveedor(new ArrayList<FechaOfertaProveedorDTO>());

				String fecha = null;
				Integer cantidad = null;
				BigDecimal peso = null;
				Map<String, Object> datosPrincipales = null;
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Articulo[] datosArticulo =  gson.fromJson(datosArticuloCol, Articulo[].class);
				Map<String, FechaOfertaProveedorDTO> fechaOfertaProveedorMap =new HashMap<String, FechaOfertaProveedorDTO>();
				for(Articulo articulo : datosArticulo){	
					for(Object valor : articulo.getValores().values()){
						datosPrincipales = (Map<String, Object>)valor;
						fecha = datosPrincipales.get("fecha").toString();
						peso = (datosPrincipales.get("peso") == null || datosPrincipales.get("peso").toString().isEmpty()) ? null : new BigDecimal(datosPrincipales.get("peso").toString());
						cantidad = (datosPrincipales.get("cantidad") == null|| datosPrincipales.get("cantidad") .toString().isEmpty()) ? null : (Double.valueOf( datosPrincipales.get("cantidad").toString())).intValue();

						//verificar si ya existe la fecha registrada
						FechaOfertaProveedorDTO fechaOfertaProveedorDTO  = fechaOfertaProveedorMap.get(fecha);
						if(fechaOfertaProveedorDTO == null){
							Long codigoFechaOferta = datosPrincipales.get("codigoFechaOferta") == null ? null :(Double.valueOf(datosPrincipales.get("codigoFechaOferta").toString())).longValue();
							fechaOfertaProveedorDTO = new FechaOfertaProveedorDTO();
							fechaOfertaProveedorDTO.getId().setCodigoCompania(codigoCompania);
							fechaOfertaProveedorDTO.getId().setCodigoFechaOferta(codigoFechaOferta);
							fechaOfertaProveedorDTO.setCodigoProveedor(codigoProveedor);
							fechaOfertaProveedorDTO.setFecha( formatter.parse(fecha));				
							fechaOfertaProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							fechaOfertaProveedorDTO.setUserId(userId); //TODO asignar usuario de auditoria
							fechaOfertaProveedorDTO.setCodigoTipoEstado(FruverConstantes.CODIGO_TIPO_ESTADO);
							fechaOfertaProveedorDTO.setValorTipoEstado(FruverConstantes.VALOR_TIPO_ESTADO_GUARDADO);
							fechaOfertaProveedorDTO.setCodigoTipoOferta(FruverConstantes.CODIGO_TIPO);
							fechaOfertaProveedorDTO.setValorTipoOferta(FruverConstantes.VALOR_TIPO_OFERTA);
							fechaOfertaProveedorDTO.setOfertaProveedor(ofertaProveedorDTO);
							fechaOfertaProveedorMap.put(fecha, fechaOfertaProveedorDTO);
						}

						//si ingresa valores
						if(peso != null || cantidad != null){
							Long codigoArticuloOferta = datosPrincipales.get("codigoArticuloOferta") == null ? null :  (Double.valueOf(datosPrincipales.get("codigoArticuloOferta").toString())).longValue();				
							ArticuloOfertaProveedorDTO articuloOfertaProveedorDTO  = new ArticuloOfertaProveedorDTO();
							articuloOfertaProveedorDTO.getId().setCodigoCompania(codigoCompania);
							articuloOfertaProveedorDTO.getId().setCodigoArticuloOferta(codigoArticuloOferta);
							articuloOfertaProveedorDTO.setCodigoUnidadManejo(articulo.getCodigoUnidadManejo());
							articuloOfertaProveedorDTO.setCodigoArticulo(articulo.getCodigoArticulo()); //TODO reemplazar por codigo de articulo
							articuloOfertaProveedorDTO.setCodigoProveedor(codigoProveedor);
							articuloOfertaProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							articuloOfertaProveedorDTO.setUserId(userId); //TODO asignar usuario de auditoria
							articuloOfertaProveedorDTO.setCantidad(articulo.getTipoControlCosto().equals("3") ? 0 : cantidad);
							articuloOfertaProveedorDTO.setPeso(articulo.getTipoControlCosto().equals("2") ? new BigDecimal(0) : peso);
							articuloOfertaProveedorDTO.setFechaOfertaProveedor(fechaOfertaProveedorDTO);
							if(fechaOfertaProveedorDTO.getArticuloOfertaProveedor() == null){
								fechaOfertaProveedorDTO.setArticuloOfertaProveedor(new ArrayList<ArticuloOfertaProveedorDTO>());							
							}
							fechaOfertaProveedorDTO.getArticuloOfertaProveedor().add(articuloOfertaProveedorDTO);
						}
					}
				}
				//verificar que fechas tienen ofertas de articulos
				for(FechaOfertaProveedorDTO fechaOfertaProveedor : fechaOfertaProveedorMap.values()){
					if(fechaOfertaProveedor.getTieneArticuloOfertaProveedor()){
						ofertaProveedorDTO.getFechaOfertaProveedor().add(fechaOfertaProveedor);						
					}
				}				
				//se inserta la informacion en la BD
				if(CollectionUtils.isNotEmpty(ofertaProveedorDTO.getFechaOfertaProveedor())){
					boolean esCreacion = (codigoOferta == null) ? Boolean.TRUE : Boolean.FALSE;
					SICFactory.getInstancia().fruver.getFruverServicio().guardarOfertasProveedor(ofertaProveedorDTO, esCreacion);
				}
			}
		} catch (ParseException e) {
			LOG_SICV2.error("Error: {}", e);
		}catch (Exception e) {
			return new ResponseEntity<String>(dataFail, headers, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(dataOK, headers, HttpStatus.OK);
	}

	/**
	 * Permite modificar el estado de las ofertas que realiza el proveedor a enviadas
	 * @param jsonData Datos generales
	 * @return status de la solicitud
	 */
	@RequestMapping(value = "/enviarOfertasProveedor", consumes="application/json", method = RequestMethod.POST, headers = "Accept= application/json")
	private @ResponseBody ResponseEntity<String> enviarOfertasProveedor(@RequestBody String jsonData){
		HttpHeaders headers = null;
		String dataOK = "{\"status\":\"OK\"}";
		String dataFail = "{\"status\":\"FAIL\"}";
		try {
			JsonParser parser = new JsonParser();
			JsonObject data =	(JsonObject)parser.parse(jsonData);
			int codigoCompania = data.get("codigoCompania").getAsInt();
			int codigoOferta = data.get("codigoOferta").getAsInt();
			String codigoProveedor = data.get("codigoProveedor").getAsString();						
			SICFactory.getInstancia().fruver.getFruverServicio().enviarOfertasProveedor(codigoCompania, codigoOferta, codigoProveedor);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(dataFail, headers, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(dataOK, headers, HttpStatus.OK);
	}

	/********SECCION GUARDADO DE DATOS *****************************************************************/

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoBarras
	 * @param descripcion
	 * @param condicionalCodigoBarras
	 * @param condicionalDescripcion
	 * @param usuarioSesion
	 * @return
	 */
	public DatosBusquedaArticulosJSON buscarArticulosOfertaProveedor( Integer codigoCompania, String codigoProveedor, String  codigoBarras, String descripcion, String condicionalCodigoBarras, String condicionalDescripcion, String usuarioSesion){

		Map<String,Object> filtros = cargarFiltros(codigoCompania, codigoBarras, descripcion, condicionalCodigoBarras,condicionalDescripcion);

		ParametroRangoFechaDTO  parametroRangoFechaDTO = SICFactory.getInstancia().fruver.getFruverServicio().obtenerParametroRangoFecha(codigoCompania, FruverConstantes.CODIGO_RANGO_FECHAS);
		Collection<ArticuloOfertaProveedorDTO> articulosOfertaCol = SICFactory.getInstancia().fruver.getFruverServicio().buscarArticulosOfertaProveedor(codigoCompania, codigoProveedor, filtros, parametroRangoFechaDTO);

		//Recorrer articulos encontrados
		Collection<Articulo> articuloCol = null;
		Map<String,Object> datosGenerales = null;
		if(CollectionUtils.isNotEmpty(articulosOfertaCol)){

			datosGenerales = new HashMap<>();
			articuloCol = new ArrayList<>();
			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");

			HashMap<String, Articulo> articulos = new HashMap<>();

			for(ArticuloOfertaProveedorDTO articuloOfertaProveedorDTO: articulosOfertaCol){

				if(!datosGenerales.containsKey("codigoOferta")){
					datosGenerales.put("codigoOferta", articuloOfertaProveedorDTO.getFechaOfertaProveedor().getCodigoOferta());
					datosGenerales.put("codigoCompania", codigoCompania);
					datosGenerales.put("codigoProveedor", codigoProveedor);
				}

				//Verificamos si no se ha registrado el articulo
				if(!articulos.containsKey(articuloOfertaProveedorDTO.getCodigoArticulo())){

					Articulo articulo = new Articulo();
					articulo.setCodigoBarras(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getArticulo().getCodigoBarras());
					articulo.setDescripcion(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getArticulo().getDescripcionArticulo());
					articulo.setTamanio(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO().getReferenciaMedida());
					articulo.setTipoControlCosto(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getValorTipoControlCosto());
					articulo.setCodigoArticulo(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getArticulo().getId().getCodigoArticulo());
					articulo.setCantidadMaxima(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloProveedor().getCantidadMaximaOfertada());
					articulo.setPesoMaximo(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloProveedor().getPesoMaximoOfertado());
					articulo.setCodigoUnidadManejo(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getId().getCodigoUnidadManejo());
					articulo.setValorUnidadManejo(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getValorUnidadManejo());
					articulo.setPesoAproximado(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getPesoAproximadoRecepcion());
					articulo.setUnidadManejo(
							articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getValorUnidadManejo().toString().concat(" ")
							.concat(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getArticuloUnidadManejoDTO().getValorTipoUnidadEmpaque()));

					articulo.setValores(new HashMap<String,Object>());

					for(int i=0;i<parametroRangoFechaDTO.getCantidadDias(); i++){

						Date fecha = FruverDateUtil.sumarFechasDias(parametroRangoFechaDTO.getFechaInicial(), i);

						// Buscamos si existe una oferta de ese articulo en esa fecha
						ArticuloOfertaProveedorDTO articuloOferta =  
								(ArticuloOfertaProveedorDTO) CollectionUtils.find(articulosOfertaCol, 
										PredicateUtils.andPredicate(
												PredicateUtils.andPredicate(
														PredicateUtils.transformedPredicate(new GetInvokerTransformer("codigoArticulo"), PredicateUtils.equalPredicate(articuloOfertaProveedorDTO.getCodigoArticulo())), 
														PredicateUtils.transformedPredicate(new GetInvokerTransformer("fechaOfertaProveedor.fecha"), PredicateUtils.equalPredicate(fecha))),
												PredicateUtils.transformedPredicate(new GetInvokerTransformer("codigoUnidadManejo"), PredicateUtils.equalPredicate(articuloOfertaProveedorDTO.getArticuloUnidadManejoProveedorDTO().getId().getCodigoUnidadManejo()))));

						//Seteamos los valores de la oferta
						cargarValores(simple, articulo, i, articuloOferta);

					}
					//Agrupamos los resultados encontrados
					articulos.put(articuloOfertaProveedorDTO.getCodigoArticulo(), articulo);
				}
			}	

			//Recorremos los resusltados agrupados
			Iterator<Entry<String, Articulo>> it = articulos.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Articulo> entry = (Map.Entry<String, OfertaProveedor.Articulo>)it.next();
				articuloCol.add((Articulo) entry.getValue());
			}
		}

		DatosBusquedaArticulosJSON datos = new DatosBusquedaArticulosJSON();
		datos.setColumnasCabecera(obtenerCabecera(parametroRangoFechaDTO));
		datos.setDatosGenerales(datosGenerales);
		datos.setDatosArticuloCol(articuloCol);

		return datos;
	}

	private void cargarValores(SimpleDateFormat simple, Articulo articulo, int i,ArticuloOfertaProveedorDTO articuloOferta) {
		Map<String,Object> fecha = new HashMap<>();
		fecha.put("fecha", simple.format(articuloOferta.getFechaOfertaProveedor().getFecha()));
		fecha.put("cantidad", articuloOferta.getCantidad());
		fecha.put("peso", articuloOferta.getPeso());
		fecha.put("codigoFechaOferta", articuloOferta.getFechaOfertaProveedor().getId().getCodigoFechaOferta());
		fecha.put("codigoArticuloOferta", articuloOferta.getId().getCodigoArticuloOferta());
		articulo.getValores().put("fecha"+i, fecha);
	}



	public Collection<CabeceraColumnaJSON>  obtenerCabecera(ParametroRangoFechaDTO parametroRangoFechaDTO){
		Collection<CabeceraColumnaJSON> cabeceras = new ArrayList<CabeceraColumnaJSON>();

		CabeceraColumnaJSON cab1 = new CabeceraColumnaJSON();
		cab1.setDisplayName("Código barras");
		cab1.setName("codigoBarras");
		cab1.setHeaderTooltip("Código de barras");

		cabeceras.add(cab1);


		CabeceraColumnaJSON cab4 = new CabeceraColumnaJSON();
		cab4.setDisplayName("Descripción");
		cab4.setName("descripcion");
		cab4.setHeaderTooltip(" Descripción");

		cabeceras.add(cab4);

		CabeceraColumnaJSON cab5 = new CabeceraColumnaJSON();
		cab5.setDisplayName("Tamaño");
		cab5.setName("tamanio");
		cab5.setHeaderTooltip(" Tamaño");

		cabeceras.add(cab5);

		CabeceraColumnaJSON cab6 = new CabeceraColumnaJSON();
		cab6.setDisplayName("Uni. man.");
		cab6.setName("unidadManejo");
		cab6.setHeaderTooltip("Unidad de manejo");

		cabeceras.add(cab6);


		SimpleDateFormat simple = new SimpleDateFormat("EEEE dd/MM/yyyy");
		for(int i=0; i< parametroRangoFechaDTO.getCantidadDias(); i++){
			CabeceraColumnaJSON cab7 = new CabeceraColumnaJSON();
			Date fecha = FruverDateUtil.sumarFechasDias(parametroRangoFechaDTO.getFechaInicial(), i);
			String nombreColumna = simple.format(fecha);
			cab7.setDisplayName(nombreColumna);
			cab7.setName("valores.fecha"+i);
			cab7.setHeaderTooltip(nombreColumna);
			cabeceras.add(cab7);
		}
		return cabeceras;
	}



	private Map<String, Object> cargarFiltros(Integer codigoCompania, String codigoBarras, String descripcion,String condicionalCodigoBarras, String condicionalDescripcion) {

		//Ocultar filtros
		List<TipoFiltroBusqueda> filtrosOcultosArt = new ArrayList<TipoFiltroBusqueda>();
		filtrosOcultosArt.add(TipoFiltroBusqueda.ARTICULO_ESTADO);
		filtrosOcultosArt.add(TipoFiltroBusqueda.ARTICULO_CLASE);
		filtrosOcultosArt.add(TipoFiltroBusqueda.ARTICULO_MEDIDA);
		filtrosOcultosArt.add(TipoFiltroBusqueda.ARTICULO_CODIGO_REFERENCIA_INTERNA);
		filtrosOcultosArt.add(TipoFiltroBusqueda.ARTICULO_CODIGO_REFERENCIA_EXTERNA);

		//Filtros visibles

		Map<TipoFiltroBusqueda, String> componentesArticuloMap = new HashMap<TipoFiltroBusqueda, String>();

		if(StringUtils.isNotEmpty(codigoBarras)){
			componentesArticuloMap.put(TipoFiltroBusqueda.ARTICULO_CODIGO_BARRAS, "articulo.codigoBarras");
		}else{
			filtrosOcultosArt.add(TipoFiltroBusqueda.ARTICULO_CODIGO_BARRAS);
		}

		if(StringUtils.isNotEmpty(descripcion)){
			componentesArticuloMap.put(TipoFiltroBusqueda.ARTICULO_DESCRIPCION,  "articulo.descripcionArticulo");
		}else{
			filtrosOcultosArt.add(TipoFiltroBusqueda.ARTICULO_DESCRIPCION);
		}


		FiltroBusquedaArticulo filtroBusquedaArticuloF = new FiltroBusquedaArticulo(codigoCompania, componentesArticuloMap, filtrosOcultosArt, Integer.valueOf(SICOrdenCompraConstantes.PROCESO_ORDENCOMPRA_CREACION));

		if(filtroBusquedaArticuloF.getCompCodigoBarras()!=null){
			filtroBusquedaArticuloF.getCompCodigoBarras().setParameterValue(codigoBarras);
			filtroBusquedaArticuloF.getCompCodigoBarras().setComparatorTypeEnum(getTipoComparador(condicionalCodigoBarras));
		}

		if(filtroBusquedaArticuloF.getCompDescripcionArticulo() !=null){
			filtroBusquedaArticuloF.getCompDescripcionArticulo().setParameterValue(descripcion);
			filtroBusquedaArticuloF.getCompDescripcionArticulo().setComparatorTypeEnum(getTipoComparador(condicionalDescripcion));
		}
		Map<String, Object> filtros = new HashMap<>();
		filtros.put("filtroBusquedaArticuloF", filtroBusquedaArticuloF.obtenerPlantillaBusquedaArticulo());

		return filtros;
	}

	private ComparatorTypeEnum getTipoComparador(String comparador){
		ComparatorTypeEnum comparator = null;
		//this.conditionals = ["EXACTO", "INICIO", "FIN","CONTENGA"];
		switch (comparador) { 

		case "INICIO":
			comparator = ComparatorTypeEnum.LIKE_START_COMPARATOR;	
			break;
		case "FIN":
			comparator = ComparatorTypeEnum.LIKE_END_COMPARATOR;	
			break;
		case "CONTENGA":
			comparator = ComparatorTypeEnum.LIKE_ANYWHERE_COMPARATOR;	
			break;
		default:
			comparator = ComparatorTypeEnum.EQUAL_COMPARATOR;	
			break;
		}
		return comparator;
	}

	class CabeceraColumnaJSON implements Serializable{
		private String name;
		private String displayName;
		private String headerTooltip;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDisplayName() {
			return displayName;
		}
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		public String getHeaderTooltip() {
			return headerTooltip;
		}
		public void setHeaderTooltip(String headerTooltip) {
			this.headerTooltip = headerTooltip;
		}
	}

	class Articulo implements Serializable{
		private String codigoArticulo;
		private String codigoBarras;
		private String descripcion;
		private String tamanio;
		private Integer cantidadMaxima;
		private BigDecimal pesoMaximo;
		private String tipoControlCosto;
		private Map<String,Object> valores;
		private Long codigoUnidadManejo;
		private Integer valorUnidadManejo;
		private String unidadManejo;
		private Double pesoAproximado;

		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getCodigoBarras() {
			return codigoBarras;
		}
		public void setCodigoBarras(String codigoBarras) {
			this.codigoBarras = codigoBarras;
		}
		public String getTamanio() {
			return tamanio;
		}
		public void setTamanio(String tamanio) {
			this.tamanio = tamanio;
		}
		public String getTipoControlCosto() {
			return tipoControlCosto;
		}
		public void setTipoControlCosto(String tipoControlCosto) {
			this.tipoControlCosto = tipoControlCosto;
		}
		public Map<String, Object> getValores() {
			return valores;
		}
		public void setValores(Map<String, Object> valores) {
			this.valores = valores;
		}
		public String getCodigoArticulo() {
			return codigoArticulo;
		}
		public void setCodigoArticulo(String codigoArticulo) {
			this.codigoArticulo = codigoArticulo;
		}
		public Integer getCantidadMaxima() {
			return cantidadMaxima;
		}
		public void setCantidadMaxima(Integer cantidadMaxima) {
			this.cantidadMaxima = cantidadMaxima;
		}
		public BigDecimal getPesoMaximo() {
			return pesoMaximo;
		}
		public void setPesoMaximo(BigDecimal pesoMaximo) {
			this.pesoMaximo = pesoMaximo;
		}
		public Long getCodigoUnidadManejo() {
			return codigoUnidadManejo;
		}
		public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
			this.codigoUnidadManejo = codigoUnidadManejo;
		}
		public Integer getValorUnidadManejo() {
			return valorUnidadManejo;
		}
		public void setValorUnidadManejo(Integer valorUnidadManejo) {
			this.valorUnidadManejo = valorUnidadManejo;
		}
		public String getUnidadManejo() {
			return unidadManejo;
		}
		public void setUnidadManejo(String unidadManejo) {
			this.unidadManejo = unidadManejo;
		}
		public Double getPesoAproximado() {
			return pesoAproximado;
		}
		public void setPesoAproximado(Double pesoAproximado) {
			this.pesoAproximado = pesoAproximado;
		}		

	}

	class DatosBusquedaArticulosJSON implements Serializable{	
		private Collection<CabeceraColumnaJSON> columnasCabecera;
		private Map<String,Object> datosGenerales;
		private Collection<Articulo> datosArticuloCol;

		public Collection<CabeceraColumnaJSON> getColumnasCabecera() {
			return columnasCabecera;
		}

		public void setColumnasCabecera(Collection<CabeceraColumnaJSON> columnasCabecera) {
			this.columnasCabecera = columnasCabecera;
		}

		public Collection<Articulo> getDatosArticuloCol() {
			return datosArticuloCol;
		}

		public void setDatosArticuloCol(Collection<Articulo> datosArticuloCol) {
			this.datosArticuloCol = datosArticuloCol;
		}

		public Map<String, Object> getDatosGenerales() {
			return datosGenerales;
		}

		public void setDatosGenerales(Map<String, Object> datosGenerales) {
			this.datosGenerales = datosGenerales;
		}
	}
}