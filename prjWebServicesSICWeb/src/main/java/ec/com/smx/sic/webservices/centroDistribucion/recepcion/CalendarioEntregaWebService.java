package ec.com.smx.sic.webservices.centroDistribucion.recepcion;

import java.lang.reflect.Type;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.framework.jsf.commons.components.MonthlyCalendarComponent;
import ec.com.smx.framework.jsf.commons.util.components.AtributosCalendarUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.bodega.EnumCatalogoValorBodega;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaAutorizacionCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaAutorizacionCalendarioEntregaBodegaID;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaCalendarioEntregaBodegaID;
import ec.com.smx.sic.cliente.mdl.vo.CalendarioPlanificacionVO;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

@Controller
@Scope(value="request")
public class CalendarioEntregaWebService {
	
	@Autowired
	@Qualifier("gson")	
	private Gson gson;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/datosautorizacion", method = RequestMethod.GET,headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> getDatosAutorizacion(
			@RequestParam(value = "codigoCompania", required = false) Integer codigoCompania,
			@RequestParam(value = "codigoProveedor", required = false) String codigoProveedor,
			@RequestParam(value = "numeroCaso", required = false) String numeroCaso,
			@RequestParam(value = "callHead", required = false) Boolean callHead,
			@RequestParam(value = "codigoDetalleEntregaProveedor", required = false) Long codigoDetalleEntregaProveedor,
			@RequestParam(value = "codigoHoraCalendario", required = false) Long codigoHoraCalendario,
			@RequestParam(value = "cantidadSolicitada", required = false) Integer cantidadSolicitada,
			@RequestParam(value = "codigoAreaTrabajo", required = false) Integer codigoAreaTrabajo,
			@RequestParam(value = "descripcionAreaTrabajo", required = false) String descripcionAreaTrabajo,
			@RequestParam(value = "fechaCaducidad", required = false) String fechaCaducidad,
			@RequestParam(value = "fechaIni", required = false) String fechaIniTipoCal, 
			@RequestParam(value = "fechaFin", required = false) String fechaFinTipoCal,
			@RequestParam(value = "diaSemana", required = false) String diaSemanaTipoCal,
			@RequestParam(value = "tipoCalendario", required = false) String tipoCalendario,
			HttpServletRequest request) {
		
		Logeable.LOG_SICV2.info("METODO::getDatosAutorizacion:");
		
		try {			
			Logeable.LOG_SICV2.info("codigoCompania: {}", codigoCompania);
			Logeable.LOG_SICV2.info("codigoProveedor: {}", codigoProveedor);
			Logeable.LOG_SICV2.info("numeroCaso: {}", numeroCaso);
			Logeable.LOG_SICV2.info("callHead: {}", callHead);
			Logeable.LOG_SICV2.info("codigoDetalleEntregaProveedor: {}", codigoDetalleEntregaProveedor);
			Logeable.LOG_SICV2.info("cantidadSolicitada: {}", cantidadSolicitada);
			Logeable.LOG_SICV2.info("fechaCaducidad: {}", fechaCaducidad);
			
			String fechaCalendario = null;
			if("SEMANA".equals(tipoCalendario)){
				fechaCalendario = obtenerFechaDiaSemana(fechaIniTipoCal,fechaFinTipoCal, diaSemanaTipoCal); 
			}else {
				fechaCalendario = fechaIniTipoCal;
			}			
			Logeable.LOG_SICV2.info("fecha: {}", fechaCalendario);
			Calendar fechaSeleccionada = new GregorianCalendar();
			fechaSeleccionada.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fechaCalendario));			
			Map<Long, HorariosDisponiblesAutorizar> horaDiaMap;
			
			/****************************************************************************/			
			Calendar calendarFechaSelectIni = new GregorianCalendar();
			Calendar calendarFechaSelectFin = new GregorianCalendar();
			Calendar calendarFechaCad = new GregorianCalendar();
			calendarFechaSelectIni.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fechaCalendario));//FECHA DE INICIO, ES LA FECHA SELECCIONADA
			calendarFechaCad.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fechaCalendario));			
			//validar fecha inicio
			Calendar hoy = new GregorianCalendar();
			String fechaIniCalendar = String.valueOf(hoy.get(GregorianCalendar.YEAR))+"-"+String.valueOf(hoy.get(GregorianCalendar.MONTH)+1)+"-"+String.valueOf(hoy.get(GregorianCalendar.DAY_OF_MONTH));
			hoy.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fechaIniCalendar));
			while (calendarFechaSelectIni.compareTo(hoy)==1){
				calendarFechaSelectIni.add(GregorianCalendar.DAY_OF_MONTH, -1);
			}			
			if(callHead){
				if(fechaCaducidad == null){
					calendarFechaCad.add(GregorianCalendar.DAY_OF_MONTH, +7);
					fechaCaducidad = String.valueOf(calendarFechaCad.get(GregorianCalendar.YEAR))+"-"+String.valueOf(calendarFechaCad.get(GregorianCalendar.MONTH)+1)+"-"+String.valueOf(calendarFechaCad.get(GregorianCalendar.DAY_OF_MONTH));
				}
				calendarFechaSelectFin.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fechaCaducidad));//FEHA FIN, DESDE FECHA
			}
			String fechaIni = String.valueOf(calendarFechaSelectIni.get(GregorianCalendar.YEAR))+"-"+String.valueOf(calendarFechaSelectIni.get(GregorianCalendar.MONTH)+1)+"-"+String.valueOf(calendarFechaSelectIni.get(GregorianCalendar.DAY_OF_MONTH));
			String fechaFin = String.valueOf(calendarFechaSelectFin.get(GregorianCalendar.YEAR))+"-"+String.valueOf(calendarFechaSelectFin.get(GregorianCalendar.MONTH)+1)+"-"+String.valueOf(calendarFechaSelectFin.get(GregorianCalendar.DAY_OF_MONTH));
			Logeable.LOG_SICV2.info("FI:: {}  FF:: {} ", fechaIni, fechaFin);
			/****************************************************************************/
			
			Collection<DatosAutorizacionJson> vistaAutorizacionEntregaList = new ArrayList<DatosAutorizacionJson>();
			Collection<HorariosDisponiblesAutorizar> horariosDisponiblesAutorizarList = new ArrayList<HorariosDisponiblesAutorizar>();

			VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionEntrega = SICFactory.getInstancia().bodega.getCalendarioPlanificacionBodegaServicio().findVistaAutorizacionCalendarioEntregaBodegaDTO(codigoCompania, numeroCaso, codigoProveedor, codigoAreaTrabajo, new SimpleDateFormat("yyyy-MM-dd").parse(fechaIni), new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin), fechaSeleccionada.getTime(), callHead, codigoDetalleEntregaProveedor, codigoHoraCalendario, Boolean.TRUE);
			Map<String, String> configuracionesEncontradas = obtenerConfiguraciones(codigoAreaTrabajo);
			
			if(vistaAutorizacionEntrega != null){
				//Datos de la informacion de la cabecera del popup
				DatosAutorizacionJson datosAutorizacionJson = new DatosAutorizacionJson();
				datosAutorizacionJson.setCodigoAutorizacion(vistaAutorizacionEntrega.getId().getCodigoAutorizacion());
				datosAutorizacionJson.setCodigoCompania(vistaAutorizacionEntrega.getId().getCodigoCompania());
				datosAutorizacionJson.setCodigoSistema(vistaAutorizacionEntrega.getId().getCodigoSistema());
				datosAutorizacionJson.setDescripcion(vistaAutorizacionEntrega.getDescripcion());
				datosAutorizacionJson.setEstadoAutorizacion(vistaAutorizacionEntrega.getEstadoAutorizacion());
				datosAutorizacionJson.setFechaSolicitud(vistaAutorizacionEntrega.getFechaSolicitud());
				datosAutorizacionJson.setNombreProveedor(vistaAutorizacionEntrega.getNombreProveedor());
				datosAutorizacionJson.setNombreUsuarioAutorizador(vistaAutorizacionEntrega.getNombreUsuarioAutorizador());
				datosAutorizacionJson.setNombreUsuarioAutorizado(vistaAutorizacionEntrega.getNombreUsuarioAutorizado());
				datosAutorizacionJson.setIdUsuarioAutorizador(vistaAutorizacionEntrega.getIdUsuarioAutorizador());
				datosAutorizacionJson.setCodigoHoraCalendario(vistaAutorizacionEntrega.getId().getCodigoHoraCalendario());
				datosAutorizacionJson.setCodigoDetalleEntregaProveedor(vistaAutorizacionEntrega.getId().getCodigoDetalleEntregaProveedor());
				datosAutorizacionJson.setCantidadSolicitada(cantidadSolicitada);
				datosAutorizacionJson.setNumeroCaso(numeroCaso);
				datosAutorizacionJson.setFechaSeleccionada(fechaCalendario);
				//carga los datos para el calendario del popup
				if(callHead){
					DatosCalendarioMonthly datosCalendarioMonthly = inicializarCalendarioEntrega(vistaAutorizacionEntrega.getAndenesDisponibles(), fechaCalendario, codigoCompania, codigoAreaTrabajo, codigoProveedor, fechaCaducidad);
					datosAutorizacionJson.setDatosCalendarioMonthly(datosCalendarioMonthly);
				}
				//carga los datos de la plantilla de horaios y andendes 
				if(CollectionUtils.isNotEmpty(vistaAutorizacionEntrega.getHorariosDisponibles())){
					horaDiaMap = this.plantillaHorario(vistaAutorizacionEntrega.getHorariosDisponibles().iterator().next(), configuracionesEncontradas.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.minima")), configuracionesEncontradas.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.maxima")), configuracionesEncontradas.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.cantidad.maxima.andenes")));
					for (VistaCalendarioEntregaBodegaDTO vistaAutorizacionEntregaBodegaDTO : vistaAutorizacionEntrega.getHorariosDisponibles()) {
						HorariosDisponiblesAutorizar detalleCalendario = new HorariosDisponiblesAutorizar();
						detalleCalendario.setHoraInicioTime(vistaAutorizacionEntregaBodegaDTO.getHoraInicio().getTime());
						detalleCalendario.setHoraInicio(String.valueOf(vistaAutorizacionEntregaBodegaDTO.getHoraInicio()));
						detalleCalendario.setCantidadDisponible(vistaAutorizacionEntregaBodegaDTO.getCantidadDisponible());
						detalleCalendario.setCantidadFurgones(vistaAutorizacionEntregaBodegaDTO.getCantidadFurgones());
						detalleCalendario.setCantidadUtilizada(vistaAutorizacionEntregaBodegaDTO.getCantidadUtilizada());
						detalleCalendario.setCantidadBultos(vistaAutorizacionEntregaBodegaDTO.getCantidadBultos());
						detalleCalendario.setCodigoAreaTrabajo(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoAreaTrabajoSeleccion());
						detalleCalendario.setCodigoProveedor(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoProveedor());
						detalleCalendario.setDiaSemana(vistaAutorizacionEntregaBodegaDTO.getDiaSemana());
						detalleCalendario.setFechaCalendario(vistaAutorizacionEntregaBodegaDTO.getFechaCalendario());
						detalleCalendario.setCantidadPlanificada(vistaAutorizacionEntregaBodegaDTO.getCantidadPlanificada());
						//detalleCalendario.setCodigoAreaTrabajoSubBodega(vistaAutorizacionEntregaBodegaDTO.getCodigoAreaTrabajoSubBodega());
						detalleCalendario.setCodigoCalendario(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoCalendario());
						//detalleCalendario.setCodigoCentroDistribucion(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoCentroDistribucion());
						detalleCalendario.setCodigoDetalleCalendario(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoDetalleCalendario());
						detalleCalendario.setCodigoHoraCalendario(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoHoraCalendario());
						detalleCalendario.setCodigoJDE(vistaAutorizacionEntregaBodegaDTO.getCodigoJDE());
						//detalleCalendario.setCodigoSubBodegaART(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoSubBodegaART());
						detalleCalendario.setDescripcionAreaTrabajo(new StringBuilder().append(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoAreaTrabajoSeleccion()).append(" - ").append(vistaAutorizacionEntregaBodegaDTO.getDescripcionAreaTrabajo()).toString());
						detalleCalendario.setNumeroRegistro(vistaAutorizacionEntregaBodegaDTO.getId().getNumeroRegistro());
						detalleCalendario.setCodigoCompania(vistaAutorizacionEntregaBodegaDTO.getId().getCodigoCompania());
						detalleCalendario.setAndenesDefault(configuracionesEncontradas.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.cantidad.maxima.andenes")));		
						horaDiaMap.put(vistaAutorizacionEntregaBodegaDTO.getHoraInicio().getTime(),detalleCalendario);
					}
				}else{
					VistaCalendarioEntregaBodegaDTO vistaCal = new VistaCalendarioEntregaBodegaDTO();
					//vistaCal.getId().setCodigoBodegaART(codigoBodegaART);
					vistaCal.getId().setCodigoProveedor(codigoProveedor);
					vistaCal.getId().setCodigoCompania(codigoCompania);
					vistaCal.getId().setCodigoAreaTrabajoSeleccion(codigoAreaTrabajo);
					//vistaCal.getId().setCodigoSubBodegaART(codigoSubBodegaART);
					vistaCal.setCodigoAreaTrabajo(codigoAreaTrabajo);
					vistaCal.setDescripcionAreaTrabajo(descripcionAreaTrabajo);
					horaDiaMap = this.plantillaHorario(vistaCal, configuracionesEncontradas.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.minima")), configuracionesEncontradas.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.maxima")), configuracionesEncontradas.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.cantidad.maxima.andenes")));
				}
				for (Entry<Long, HorariosDisponiblesAutorizar> entry : horaDiaMap.entrySet()) {
					horariosDisponiblesAutorizarList.add(entry.getValue());
				}				
				datosAutorizacionJson.setHorariosDisponiblesAutorizar(horariosDisponiblesAutorizarList);				
				vistaAutorizacionEntregaList.add(datosAutorizacionJson);
			}			
			Logeable.LOG_SICV2.info("datos:: {}", gson.toJson(vistaAutorizacionEntregaList));
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			return new ResponseEntity(gson.toJson(vistaAutorizacionEntregaList),responseHeaders,HttpStatus.OK);
			//return vistaAutorizacionEntregaList;
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Método: inicializarCalendarioEntrega", e);
		}
		return null;
	}
	
	public Map<Long, HorariosDisponiblesAutorizar> plantillaHorario(VistaCalendarioEntregaBodegaDTO vistaCal, String horaMinima, String horaMaxima, String andenes){		
		Logeable.LOG_SICV2.info("METODO:plantillaHorario");
		//crea la plantilla de los horarios
		AreaTrabajoDTO areaTrabajo = new AreaTrabajoDTO();
		areaTrabajo.getId().setCodigoAreaTrabajo(vistaCal.getId().getCodigoAreaTrabajoSeleccion());
		
		Logeable.LOG_SICV2.info("HMIN: {}", horaMinima);
		Logeable.LOG_SICV2.info("HMAX: {}", horaMaxima);
		
		String[] horaMaximaS = horaMaxima.split(":");
		String[] horaMinimaS = horaMinima.split(":");
		
		int horaInicioDefault = Integer.parseInt(horaMinimaS[0]);
		int horaFinalDefault = Integer.parseInt(horaMaximaS[0]);
		int anioJavaCero = 1970;
		int mesJavaCero = Calendar.JANUARY;
		int diaJavaCero = 1;
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		Map<Long, HorariosDisponiblesAutorizar> horaDiaMap = new TreeMap<Long, HorariosDisponiblesAutorizar>();

		for (int i = horaInicioDefault; i <= horaFinalDefault; i++) {
			HorariosDisponiblesAutorizar detalleCalendario = new HorariosDisponiblesAutorizar();
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, anioJavaCero);
			calendar.set(Calendar.MONTH, mesJavaCero);
			calendar.set(Calendar.DATE, diaJavaCero);
			calendar.set(Calendar.HOUR_OF_DAY, i);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			detalleCalendario.setHoraInicio(dateFormat.format(calendar.getTime()));
			detalleCalendario.setHoraInicioTime(calendar.getTimeInMillis());
			detalleCalendario.setAndenesDefault(andenes);
			detalleCalendario.setCodigoAreaTrabajo(vistaCal.getId().getCodigoAreaTrabajoSeleccion());
			detalleCalendario.setCodigoProveedor(vistaCal.getId().getCodigoProveedor());			
			//detalleCalendario.setCodigoSubBodegaART(vistaCal.getId().getCodigoSubBodegaART());
			detalleCalendario.setCodigoCompania(vistaCal.getId().getCodigoCompania());
			//detalleCalendario.setCodigoAreaTrabajoSubBodega(vistaCal.getCodigoAreaTrabajoSubBodega());
			detalleCalendario.setDescripcionAreaTrabajo(new StringBuilder()
					.append(vistaCal.getId().getCodigoAreaTrabajoSeleccion())
					.append(" - ").append(vistaCal.getDescripcionAreaTrabajo()).toString());
						
			horaDiaMap.put(calendar.getTimeInMillis(), detalleCalendario);
		}		
		return horaDiaMap;
	}
	
	public DatosCalendarioMonthly inicializarCalendarioEntrega(Collection<VistaCalendarioEntregaBodegaDTO> vistaCalendarioList, String fechaSeleccionada, Integer codigoCompania, Integer codigoBodegaART, String codigoProveedor, String numeroMaxFecha) {
		try {
			DatosCalendarioMonthly datosCalendarioMonthly = new DatosCalendarioMonthly();
			Collection<AtributosCalendarUtil> atributosCalendarUtilCol = new ArrayList<AtributosCalendarUtil>();			
			//Datos iniciales del calendario del popup
			if(vistaCalendarioList != null){
				for(VistaCalendarioEntregaBodegaDTO vistaCal : vistaCalendarioList){
					AtributosCalendarUtil atributosCalendarUtil = new AtributosCalendarUtil();
					Calendar calendarFecha = new GregorianCalendar(); 
					calendarFecha.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(vistaCal.getFechaCalendario()));					
					atributosCalendarUtil.setChkSeleccionado(Boolean.FALSE);
					atributosCalendarUtil.setAnio(calendarFecha.get(GregorianCalendar.YEAR));
					atributosCalendarUtil.setDia(calendarFecha.get(GregorianCalendar.DAY_OF_MONTH));
					atributosCalendarUtil.setMes(calendarFecha.get(GregorianCalendar.MONTH)+1);
					atributosCalendarUtil.setEstado(Boolean.TRUE);
					Logeable.LOG_SICV2.info("Key fechaInicio:: {}", new SimpleDateFormat("yyyy-MM-dd").parse(vistaCal.getFechaCalendario()));
					Logeable.LOG_SICV2.info("getCantidadDisponible:: {}", vistaCal.getCantidadDisponible());

					atributosCalendarUtil.setLabelText(vistaCal.getCantidadDisponible() + " And");
					atributosCalendarUtil.setLabelTextDos(vistaCal.getCantidadBultos() + " Bul");
					
					atributosCalendarUtilCol.add(atributosCalendarUtil);
				}
			}
			MonthlyCalendarComponent calendarioComponente = new MonthlyCalendarComponent(atributosCalendarUtilCol);
			Type listType = new TypeToken<ArrayList<AtributosCalendarUtil>>() {
			}.getType();
			Collection<AtributosCalendarUtil> element = gson.fromJson(calendarioComponente.getCadenabloqueosCalendario(), listType);
			datosCalendarioMonthly.setBloquearFechaAnterior(Boolean.TRUE);
			datosCalendarioMonthly.setCadenaBloqueos(element);
			datosCalendarioMonthly.setCadenaEmulaConstructor("");
			datosCalendarioMonthly.setCadenaFechasSelecionas("");
			datosCalendarioMonthly.setFechaMax(numeroMaxFecha);
			datosCalendarioMonthly.setModoInicio("enable");
			datosCalendarioMonthly.setMultiSeleccion("1");
			return datosCalendarioMonthly;
			
		} catch (Exception e) {
			throw new SICException("Método inicializarCalendarioEntrega", e);
		}
	}	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/guardarAutorizacion", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> guardarAutorizacion(
			@RequestParam(value = "listaAutorizacion", required = true) String listaAutorizacion,
			@RequestParam(value = "cabeceraAutorizacion", required = true) String cabeceraAutorizacion,
			@RequestParam(value = "fechaInicio", required = true) String fechaInicio,
			@RequestParam(value = "fechaFin", required = false) String fechaFin,
			@RequestParam(value = "tipoCalendario", required = true) String tipoCalendario,
			@RequestParam(value = "codigoAreaTrabajo", required = true) Integer codigoAreaTrabajo,
			@RequestParam(value = "filtroSolicitudes", required = false) String filtroSolicitudes) throws JsonProcessingException {
		
		try{
			
			CalendarioAutirizacion[] calendarioAutorizacion = gson.fromJson(listaAutorizacion, CalendarioAutirizacion[].class);
			Logeable.LOG_SICV2.info(listaAutorizacion);
			
			Collection<VistaCalendarioEntregaBodegaDTO> listaCalendarioEntregas = new ArrayList<VistaCalendarioEntregaBodegaDTO>();
			int andenesSeleccionados = this.obtenerListaCalendarioEntregas(calendarioAutorizacion, listaCalendarioEntregas);
			
//			Integer andenesSeleccionados = (Integer)mapListaCalendarioEntregas.get("andenesSeleccionados");
//			Collection<VistaCalendarioEntregaBodegaDTO> listaCalendarioEntregas = 
//					(Collection<VistaCalendarioEntregaBodegaDTO>)mapListaCalendarioEntregas.get("listaCalendarioEntregas");
			
			//llena los datos de la autorizacion Padre
			CabeceraAutirizacion autorizacionPadre = gson.fromJson(cabeceraAutorizacion, CabeceraAutirizacion.class);
			VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionPadre = llenarVistaAutorizacionCalendarioBodega(andenesSeleccionados, autorizacionPadre);
			
			String calendarioJson = null;
			
			Date fechaInicioD = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
			Date fechaFinD = StringUtils.isNotBlank(fechaFin) ? new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin) : null;
			
			CalendarioPlanificacionVO calendario = SICFactory.getInstancia().bodega
					.getCalendarioPlanificacionBodegaServicio().transGuardarAutorizacion(listaCalendarioEntregas,
							vistaAutorizacionPadre, autorizacionPadre.numeroCaso, tipoCalendario, fechaInicioD, fechaFinD, autorizacionPadre.codigoCompania, codigoAreaTrabajo, filtroSolicitudes);
			
			calendarioJson = gson.toJson(calendario);
//			String calendarioJson = JsonPojoMapper.getInstance().writeValueAsString(calendario);
			Logeable.LOG_SICV2.info("calendario Json:: {}", calendarioJson);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/jsonp; charset=utf-8");
//			responseHeaders.add("Access-Control-Allow-Origin", "*");
			
			return new ResponseEntity(calendarioJson, responseHeaders,HttpStatus.OK);
			
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Ocurrio un error en la conversion de las fechas {}", e.toString());
		}
		return null;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/guardarAutorizacionMasiva", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity<String> guardarAutorizacionMasiva(
			@RequestParam(value = "listaAutorizacion", required = true) String listaAutorizacion,
			@RequestParam(value = "cabeceraAutorizacion", required = true) String cabeceraAutorizacion) {
		
		String respuestaWebService = null;
		Map<String, String> datosRespuesta = new HashMap<String, String>();
		ResponseEntity responseEntity = null;
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/jsonp; charset=utf-8");
		responseHeaders.add("Access-Control-Allow-Origin", "*");
		
		try{
			CalendarioAutirizacion[] calendarioAutorizacion = gson.fromJson(listaAutorizacion, CalendarioAutirizacion[].class);
			Logeable.LOG_SICV2.info(listaAutorizacion);
			
			Collection<VistaCalendarioEntregaBodegaDTO> listaCalendarioEntregas = new ArrayList<VistaCalendarioEntregaBodegaDTO>();
			
			int andenesSeleccionados = this.obtenerListaCalendarioEntregas(calendarioAutorizacion, listaCalendarioEntregas);
			
			//llena los datos de la autorizacion Padre
			CabeceraAutirizacion autorizacionPadre = gson.fromJson(cabeceraAutorizacion, CabeceraAutirizacion.class);
			VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionPadre = llenarVistaAutorizacionCalendarioBodega(andenesSeleccionados, autorizacionPadre);
		
			SICFactory.getInstancia().bodega.getCalendarioPlanificacionBodegaServicio()
					.transGuardarAutorizacion(listaCalendarioEntregas, vistaAutorizacionPadre, autorizacionPadre.numeroCaso);
			
			datosRespuesta.put("respuesta", "OK");
			datosRespuesta.put("mensaje", "OK");
			respuestaWebService = gson.toJson(datosRespuesta);
			responseEntity =  new ResponseEntity(respuestaWebService, responseHeaders, HttpStatus.OK);
			
		} catch(Exception e){
			datosRespuesta.put("respuesta", "ERROR");
			datosRespuesta.put("mensaje", e.getMessage());
			respuestaWebService = gson.toJson(datosRespuesta);
			responseEntity =  new ResponseEntity(respuestaWebService, responseHeaders, HttpStatus.OK);
			Logeable.LOG_SICV2.error("Ocurrio al procesar la autorizacion seleccionada {}", e.toString());
		} finally {
			datosRespuesta = null;
		}
		
		Logeable.LOG_SICV2.info("respuestaWebService Json: {}", respuestaWebService);
		
		return responseEntity;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/obtenerDatosCalendario", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getDatosCalendario (@RequestParam(value = "fechaInicio", required = true) String fechaInicio,
			@RequestParam(value = "fechaFin", required = false) String fechaFin,
			@RequestParam(value = "tipoFiltro", required = true)  String tipoFiltro,
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "codigoAreaTrabajo", required = true) Integer codigoAreaTrabajo,
			@RequestParam(value = "firstResult", required = true) Integer firstResult,
			@RequestParam(value = "pageSize", required = true) Integer pageSize,
			@RequestParam(value = "lastId", required = false) Integer lastId) {
		
		Logeable.LOG_SICV2.info(" *** getDatosCalendario *** ");
		
		String calendarioJson = null;
		
		try {
			
			Date fechaInicioD = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
			CalendarioPlanificacionVO calendarioPlanificacionVO = null; 
			
			if (StringUtils.isBlank(fechaFin)) {
				calendarioPlanificacionVO =	SICFactory.getInstancia().bodega.getCalendarioPlanificacionBodegaServicio().
						buscarCalendarioEntregasDiarioFiltrado(codigoCompania, codigoAreaTrabajo, null, fechaInicioD, Boolean.TRUE, tipoFiltro, firstResult, pageSize, Boolean.FALSE);
			} else {
				Date fechaFinD = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
				calendarioPlanificacionVO = SICFactory.getInstancia().bodega.getCalendarioPlanificacionBodegaServicio().
						buscarCalendarioEntregasSemanalFiltrado(codigoCompania, codigoAreaTrabajo, null, fechaInicioD, fechaFinD, Boolean.TRUE, tipoFiltro, firstResult, pageSize, lastId, Boolean.FALSE);
			}
			
			calendarioJson = gson.toJson(calendarioPlanificacionVO);
			Logeable.LOG_SICV2.info("calendario Json:: {}", calendarioJson);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/jsonp; charset=utf-8");
			responseHeaders.add("Access-Control-Allow-Origin", "*");
			
			return new ResponseEntity(calendarioJson, responseHeaders,HttpStatus.OK);
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Ocurrio un error al obtenerDatosCalendario webService {}", e.toString());
		}
		
		return null;
	}
	
	private int obtenerListaCalendarioEntregas(CalendarioAutirizacion[] calendarioAutorizacion, 
			Collection<VistaCalendarioEntregaBodegaDTO> listaCalendarioEntregas) {
		
//		Map<String, Object> map = new HashMap<String, Object>();
		
//		Collection<VistaCalendarioEntregaBodegaDTO> listaCalendarioEntregas = new ArrayList<VistaCalendarioEntregaBodegaDTO>();
		int andenesSeleccionados = 0;
		//llena los datos del calendario Autorizacion
		for (int i=0; i<calendarioAutorizacion.length; i++ ) {
			VistaCalendarioEntregaBodegaID vistaCalendarioID = new VistaCalendarioEntregaBodegaID();
			VistaCalendarioEntregaBodegaDTO vistaCalendarioEntregas = new VistaCalendarioEntregaBodegaDTO();
			//llena los campos del ID
			vistaCalendarioID.setCodigoCalendario((calendarioAutorizacion[i].codigoCalendario));
			vistaCalendarioID.setCodigoHoraCalendario((calendarioAutorizacion[i].codigoHoraCalendario));
			vistaCalendarioID.setCodigoDetalleCalendario((calendarioAutorizacion[i].codigoDetalleCalendario));
			vistaCalendarioID.setCodigoCompania((calendarioAutorizacion[i].codigoCompania));
			vistaCalendarioID.setCodigoProveedor((calendarioAutorizacion[i].codigoProveedor));
			vistaCalendarioID.setCodigoAreaTrabajoSeleccion((calendarioAutorizacion[i].codigoAreaTrabajo));
			vistaCalendarioID.setNumeroRegistro((calendarioAutorizacion[i].numeroRegistro));
			vistaCalendarioEntregas.setId(vistaCalendarioID);
			vistaCalendarioEntregas.setFechaCalendario(calendarioAutorizacion[i].fecha);
			vistaCalendarioEntregas.setCodigoAreaTrabajo(calendarioAutorizacion[i].codigoAreaTrabajo);
			vistaCalendarioEntregas.setDescripcionAreaTrabajo(calendarioAutorizacion[i].descripcionAreaTrabajo);
			vistaCalendarioEntregas.setHoraInicio(Time.valueOf(calendarioAutorizacion[i].hora));
			vistaCalendarioEntregas.setCantidadAutorizada(calendarioAutorizacion[i].andenesSeleccionados);
			andenesSeleccionados += calendarioAutorizacion[i].andenesSeleccionados;
			//agrega al collection
			listaCalendarioEntregas.add(vistaCalendarioEntregas);
		}
		
//		map.put("andenesSeleccionados", andenesSeleccionados);
//		map.put("listaCalendarioEntregas", listaCalendarioEntregas);
//		
//		return map;
		return andenesSeleccionados;
		
	}

	private VistaAutorizacionCalendarioEntregaBodegaDTO 
			llenarVistaAutorizacionCalendarioBodega(Integer andenesSeleccionados, CabeceraAutirizacion autorizacionPadre) {
		
		VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionPadre = new VistaAutorizacionCalendarioEntregaBodegaDTO();
		vistaAutorizacionPadre.setId(new VistaAutorizacionCalendarioEntregaBodegaID());
		vistaAutorizacionPadre.getId().setCodigoAutorizacion(autorizacionPadre.codigoAutorizacion);
		vistaAutorizacionPadre.getId().setCodigoCompania(autorizacionPadre.codigoCompania);
		vistaAutorizacionPadre.getId().setCodigoSistema(autorizacionPadre.codigoSistema);
		vistaAutorizacionPadre.getId().setCodigoHoraCalendario(autorizacionPadre.codigoHoraCalendario);
		vistaAutorizacionPadre.getId().setCodigoDetalleEntregaProveedor(autorizacionPadre.codigoDetalleEntregaProveedor);
		vistaAutorizacionPadre.setDescripcion(autorizacionPadre.descripcion);
		vistaAutorizacionPadre.setEstadoAutorizacion(autorizacionPadre.estadoAutorizacion);
		vistaAutorizacionPadre.setFechaSolicitud(autorizacionPadre.fechaSolicitud);
		vistaAutorizacionPadre.setNombreProveedor(autorizacionPadre.nombreProveedor);
		vistaAutorizacionPadre.setNombreUsuarioAutorizador(autorizacionPadre.nombreUsuarioAutorizador);
		vistaAutorizacionPadre.setObservacionAprobacion(autorizacionPadre.observacion);
		vistaAutorizacionPadre.setCodigoBodegaART(autorizacionPadre.codigoBodega);
		vistaAutorizacionPadre.setIdUsuarioAutorizador(autorizacionPadre.idUsuarioAutorizador);
		vistaAutorizacionPadre.setCantidadAndenesAprobados(andenesSeleccionados);
		vistaAutorizacionPadre.setCantidadAndenesRechazados(autorizacionPadre.cantidadRechazada);
		vistaAutorizacionPadre.setObservacionRechazo(autorizacionPadre.observacionRechazo);
		return vistaAutorizacionPadre;
		
	}
	
	public String obtenerFechaDiaSemana(String fechaIni,	String fechaFin, String diaSemana) {
		Logeable.LOG_SICV2.info("METODO::getObtenerFechaDiaSemana");
		try {			
			Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaIni);
			Date fechaFinal = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
			String fechaSeleccionada = new SimpleDateFormat("yyyy-MM-dd").format(obtenerDiaSemana(fechaInicio, fechaFinal, obtenerDiaSemanaNum(diaSemana)));
			return fechaSeleccionada;
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("METODO::getObtenerFechaDiaSemana", e);
		}
		return null;
	}
		
	public Date obtenerDiaSemana(Date fechaIni, Date fechaFin, Integer diaSemana){
		Logeable.LOG_SICV2.info("METODO:: obtenerDiaSemana");
		Calendar calendarioIni = new GregorianCalendar();
		Calendar calendarioFin = new GregorianCalendar();
		calendarioIni.setTime(fechaIni);
		calendarioFin.setTime(fechaFin);
		while (calendarioIni.get(GregorianCalendar.DAY_OF_WEEK) >= 0){
			if (calendarioIni.get(GregorianCalendar.DAY_OF_WEEK) == diaSemana ){
				return calendarioIni.getTime();
			}
			calendarioIni.add(GregorianCalendar.DAY_OF_MONTH, 1);			
		}		
		return calendarioIni.getTime();		
	}
	
	/**
	 * 
	 * @param fecha1
	 * @param fecha2
	 * @return numero de dias entre fecha1 y fecha2
	 */
	public Integer obtenerDiasEntreFechas(String fecha1, String fecha2){
		Calendar fechaInicio = new GregorianCalendar();	
		Calendar fechaFin = new GregorianCalendar();
		Integer dias = 1;
		try {
			 Logeable.LOG_SICV2.info("N. fecha1:: {}", fecha1);
			 Logeable.LOG_SICV2.info("N. fecha2:: {}", fecha2);
			if(StringUtils.isNotEmpty(fecha2) && StringUtils.isNotEmpty(fecha1)){
				fechaInicio.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fecha1));
				fechaFin.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fecha2));
				while (fechaInicio.getTimeInMillis() < fechaFin.getTimeInMillis()){
					fechaInicio.add(GregorianCalendar.DAY_OF_MONTH, +1);
					dias++;
				}
				Logeable.LOG_SICV2.info("N. dias {}", dias);
				return dias;
			}
		} catch (ParseException e) {
			Logeable.LOG_SICV2.error("Método obtenerDiasEntreFechas :: ", e);		
		}
		return dias;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> obtenerConfiguraciones(Integer codigoAreaTrabajo){
		Map<String, String> configuraciones = new HashMap<String, String>();
		CaracteristicaProcesoAreaTrabajoDTO procesoAreaTrabajoDTO = new CaracteristicaProcesoAreaTrabajoDTO();
		try {
			procesoAreaTrabajoDTO.setCaracteristicaCatalogoTipo(Integer.valueOf(EnumCatalogoValorBodega.VALOR_CODIGOCATALOGO_CONFIGURACION_CALENDARIO.getCodigoCatalogoValor()));
			Collection<String> configuracionesPlantilla = new ArrayList<String>();
			configuracionesPlantilla.add(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.minima"));
			configuracionesPlantilla.add(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.maxima"));
			configuracionesPlantilla.add(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.cantidad.maxima.andenes"));
			procesoAreaTrabajoDTO.addCriteriaSearchParameter("caracteristicaCatalogoValor", ComparatorTypeEnum.IN_COMPARATOR, configuracionesPlantilla);
			procesoAreaTrabajoDTO.setCodigoAreaTrabajo(codigoAreaTrabajo);
			procesoAreaTrabajoDTO.setEstado(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);		
			Collection<CaracteristicaProcesoAreaTrabajoDTO> procesosAreaTrabajoDTOEncontrados =  SICFactory.getInstancia().administracion.getDataService().findObjects(procesoAreaTrabajoDTO);
			if(procesosAreaTrabajoDTOEncontrados != null){
				for (CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO : procesosAreaTrabajoDTOEncontrados) {
					if(caracteristicaProcesoAreaTrabajoDTO.getCaracteristicaCatalogoValor().equals(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.minima"))){
						configuraciones.put(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.minima"), caracteristicaProcesoAreaTrabajoDTO.getValorCaracteristica());
					}
					else if(caracteristicaProcesoAreaTrabajoDTO.getCaracteristicaCatalogoValor().equals(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.maxima"))){
						configuraciones.put(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.maxima"), caracteristicaProcesoAreaTrabajoDTO.getValorCaracteristica());
					}
					else{
						configuraciones.put(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.cantidad.maxima.andenes"), caracteristicaProcesoAreaTrabajoDTO.getValorCaracteristica());
					}
				}
			}
			if(configuraciones.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.minima")) == null){
				configuraciones.put(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.minima"), SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.hora.minima.por.defecto.calendario.bodega"));
			}
			if(configuraciones.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.maxima")) == null){
				configuraciones.put(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.hora.maxima"), SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.hora.maxima.por.defecto.calendario.bodega"));
			}
			if(configuraciones.get(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.cantidad.maxima.andenes")) == null){
				configuraciones.put(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.cantidad.maxima.andenes"), SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.cantidad.maxima.andenes.por.defecto"));
			}
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Método obtenerConfiguraciones :: ", e);
		}
		return configuraciones;
	}
	
	public Integer obtenerDiaSemanaNum(String dia) {		
		if ("DOMINGO".equals(dia))
			return 1;		
		else if ("LUNES".equals(dia))			
			return 2;
		else if ("MARTES".equals(dia))			
			return 3;
		else if ("MIERCOLES".equals(dia))			
			return 4;
		else if ("JUEVES".equals(dia))			
			return 5;
		else if ("VIERNES".equals(dia))			
			return 6;
		else if ("SABADO".equals(dia))			
			return 7;
		return null;
	}

	class CalendarioAutirizacion {
		public Long codigoCalendario; 
		public Long codigoHoraCalendario;
		public Long codigoDetalleCalendario;
		public Integer codigoCompania;
		public String codigoProveedor;
		public Integer numeroRegistro;		
		public String fecha;
		public String hora;
		public String indice;
		public String descripcionAreaTrabajo;
		public Integer andenesSeleccionados;
		public Integer andenesDisponibles;	
		public Integer codigoAreaTrabajo;
	}
	
	class CabeceraAutirizacion {
		public Integer codigoCompania;
		public Long codigoAutorizacion; 
		public String codigoSistema;
		public String idUsuarioAutorizador;
		public String nombreUsuarioAutorizador;		
		public String estadoAutorizacion;		
		public String fechaSolicitud;	
		public Integer cantidadSolicitada;
		public String nombreProveedor;	
		public Long codigoHoraCalendario;
		public Long codigoDetalleEntregaProveedor;			
		public String descripcion;		
		public String observacion;
		public String numeroCaso;
		public Integer cantidadRechazada;
		public String observacionRechazo;
		public Integer codigoBodega;
		public String tipoVista;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/obtenerDatosCalendarioProveedor", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getDatosCalendarioProveedor (@RequestParam(value = "fechaInicio", required = true) String fechaInicio,
			@RequestParam(value = "fechaFin", required = false) String fechaFin,
			@RequestParam(value = "codigoJDEProveedor", required = false) String codigoJDEProveedor,
			@RequestParam(value = "nombreProveedor", required = false) String nombreProveedor,
			@RequestParam(value = "tipoFiltro", required = true)  String tipoFiltro,
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "codigoAreaTrabajo", required = true) Integer codigoAreaTrabajo) {
		
		Logeable.LOG_SICV2.info(" *** getDatosCalendarioProveedor *** ");
		
		String calendarioJson = null;
		
		try {
			
			Date fechaInicioD = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
			CalendarioPlanificacionVO calendarioPlanificacionVO = null; 
			
			if (StringUtils.isBlank(fechaFin)) {
				calendarioPlanificacionVO =	SICFactory.getInstancia().bodega.getCalendarioPlanificacionBodegaServicio().
						buscarCalendarioEntregasDiarioProveedor(codigoCompania, codigoAreaTrabajo, codigoJDEProveedor, nombreProveedor, fechaInicioD, Boolean.TRUE, tipoFiltro, null, null);
			} else {
				Date fechaFinD = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
				calendarioPlanificacionVO = SICFactory.getInstancia().bodega.getCalendarioPlanificacionBodegaServicio().
						buscarCalendarioEntregasSemanalProveedor(codigoCompania, codigoAreaTrabajo, codigoJDEProveedor, nombreProveedor, fechaInicioD, fechaFinD, Boolean.TRUE, tipoFiltro, null, null, null);
			}
			
			calendarioJson = gson.toJson(calendarioPlanificacionVO);
			Logeable.LOG_SICV2.info("calendario Json:: {}", calendarioJson);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/jsonp; charset=utf-8");
			responseHeaders.add("Access-Control-Allow-Origin", "*");
			
			return new ResponseEntity(calendarioJson, responseHeaders,HttpStatus.OK);
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al obtenerDatosCalendario webService {}", e.toString());
		}
		
		return null;
	}
}
