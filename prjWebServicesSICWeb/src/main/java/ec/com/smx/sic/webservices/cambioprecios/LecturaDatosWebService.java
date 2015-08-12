package ec.com.smx.sic.webservices.cambioprecios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosHistorialCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.ProveedorReporteCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.ReporteTransporte;
import ec.com.smx.sic.cliente.common.cambioprecios.constantes.TipoBusquedaCambioPrecios;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.HistorialPrecioDiferenciadoArticuloDTO;

/**
 * 
 * @author dgutierrez@kruger.com.ec (Danny Gutierrez)
 */
@Controller
@Scope(value = "request")
public class LecturaDatosWebService {
	
	/**
	 * Metodo del Servicio de Reportes que envia los parametros del reporte en JSON
	 */
	@SuppressWarnings({})
	@RequestMapping(value = "/paramReporte", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> paramReporte(@RequestBody String jsonString) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		JsonParser parser = new JsonParser();
		JsonObject o = (JsonObject)parser.parse(jsonString);
		
		String userCompleteName = o.get("userCompleteName").toString();
		
		Date fecha = new Date();
		String terminal = "LecturaDatosWebService";
		
		JsonObject jr = new JsonObject();
		jr.addProperty("usuario", userCompleteName);
		jr.addProperty("fecha", sdf.format(fecha));
		jr.addProperty("terminal", terminal);

		return new ResponseEntity<String>(jr.toString(), null, HttpStatus.OK);
	}
	
	/**
	 * Metodo del Servicio de Reportes que envia los datos del reporte en JSON
	 */
	@SuppressWarnings({})
	@RequestMapping(value = "/dataReporte", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dataReporte(@RequestBody String jsonString) throws SICException {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			ReporteTransporte reporteTransporte = mapper.readValue(jsonString, ReporteTransporte.class);
			TipoBusquedaCambioPrecios tipo = reporteTransporte.getTipo();
			
			ArrayList<ISearchTemplate> parametros = new ArrayList<ISearchTemplate>(reporteTransporte.devolverLista());
			
			Collection<DatosHistorialCambioPrecio> datosCompletos = null;
			
			if (tipo.equals(TipoBusquedaCambioPrecios.DATOS_GENERALES_CAMBIO_PRECIO)) {
				
				Collection<ArticuloProveedorGestionPrecioDTO> datosPrevios = SICFactory.getInstancia().cambioPrecios.getAdministracionCambioPreciosServicio()
						.obtenerBusquedaCambioPrecios(	reporteTransporte.getCodigoCompania(),
														reporteTransporte.getCodigoFuncionario(), 
														reporteTransporte.getIncluirPreciosDif(),
														parametros, tipo);
				
				if (datosPrevios == null) {
					throw new SICException("La consulta no tiene datos para mostrar");
				}
				
				datosCompletos = SICFactory.getInstancia().cambioPrecios.getAdministracionCambioPreciosServicio().convertirFormato(datosPrevios);
			
			} else if (tipo.equals(TipoBusquedaCambioPrecios.HISTORIAL_CAMBIO_PRECIO)) {
				
				datosCompletos = SICFactory.getInstancia().cambioPrecios.getAdministracionCambioPreciosServicio()
						.obtenerBusquedaCambioPrecios(	reporteTransporte.getCodigoCompania(),
														reporteTransporte.getCodigoFuncionario(),
														reporteTransporte.getIncluirPreciosDif(),
														parametros, tipo);
			}
			
			// Peticion de la Informacion de Inflacion por articulo
			SICFactory.getInstancia().cambioPrecios.getAdministracionCambioPreciosServicio()
				.calcularInflacionArticulos(datosCompletos);
			
			// Conversion de los datos a un TreeMapa
			TreeMap<ProveedorReporteCambioPrecio, TreeMap<DatosHistorialCambioPrecio, List<HistorialPrecioDiferenciadoArticuloDTO>>> treeMap = 
					SICFactory.getInstancia().cambioPrecios.getAdministracionCambioPreciosServicio().convertirEnTreeMap(datosCompletos);
					
			// Conversion del mapa en un objeto Json
			JsonObject objetoJson = SICFactory.getInstancia().cambioPrecios.getAdministracionCambioPreciosServicio().convertirJson(treeMap);
			String sj = objetoJson.toString();
			return new ResponseEntity<String>(sj, null, HttpStatus.OK);
		} catch (SICException sex) {
			return new ResponseEntity<String>("{ \"mensajeError\" : \""+ sex.getMessage() + "\" }", null, HttpStatus.OK);
		} catch (Exception ex) {
			Logeable.LOG_SICV2.error("Error (dataReporte) : ", ex);
			return new ResponseEntity<String>("{ \"mensajeError\" : \"Ha sucedido un error. Consulte con el Administrador\" }", null, HttpStatus.OK);
		}
	}
}
