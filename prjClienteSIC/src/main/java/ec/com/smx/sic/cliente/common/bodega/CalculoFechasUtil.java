package ec.com.smx.sic.cliente.common.bodega;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.exception.SICException;

public final class CalculoFechasUtil {

	/**
	 * Constructor
	 */
	private CalculoFechasUtil() {

	}

	private static final CalculoFechasUtil INSTANCIA = new CalculoFechasUtil();

	/**
	 * @return the instancia
	 */
	public static CalculoFechasUtil getInstancia() {
		return INSTANCIA;
	}
	
	/**
	 * Devuelve el nombre del dia de la semana
	 * 
	 * @param fecha
	 * @return
	 */
	public String obtenerDiaFecha (Date fecha) {		
		//actualiza el dia
		Calendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fecha);				
		if (fechaCalendario.get(GregorianCalendar.DAY_OF_WEEK) == 1 )
			return "Domingo";		
		else if (fechaCalendario.get(GregorianCalendar.DAY_OF_WEEK) == 2 )			
			return "Lunes";
		else if (fechaCalendario.get(GregorianCalendar.DAY_OF_WEEK) == 3 )			
			return "Martes";
		else if (fechaCalendario.get(GregorianCalendar.DAY_OF_WEEK) == 4 )			
			return "Mi\u00E9rcoles";
		else if (fechaCalendario.get(GregorianCalendar.DAY_OF_WEEK) == 5 )			
			return "Jueves";
		else if (fechaCalendario.get(GregorianCalendar.DAY_OF_WEEK) == 6 )			
			return "Viernes";
		else 			
			return "S\u00E1bado";	
	}

	/**
	 * Devuelve el nombre del mes
	 * 
	 * @param fecha
	 * @return
	 */
	public String obtenerMesFecha (Date fecha) {		
		Calendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fecha);
		if (fechaCalendario.get(GregorianCalendar.MONTH) == 0 )
			return "Enero";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 1 )
			return "Febrero";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 2 )
			return "Marzo";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 3 )
			return "Abril";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 4 )
			return "Mayo";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 5 )
			return "Junio";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 6 )
			return "Julio";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 7 )
			return "Agosto";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 8 )
			return "Septiembre";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 9 )
			return "Octubre";
		else if (fechaCalendario.get(GregorianCalendar.MONTH) == 10 )
			return "Noviembre";
		else
			return "Diciembre";
	}

	/**
	 * Devuelve el rango de una fecha desde las 00:00 hasta las 24:00
	 * 
	 * @param fecha
	 * @param tiempoAntes
	 * @param tiempoDespues
	 * @return
	 */
	public RangeValue<Date> obtenerRangoFecha(Date fecha, Integer numeroDiasAux) {
		Integer numeroDias = numeroDiasAux;
		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date(fecha.getTime()));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Timestamp fecha1 = new Timestamp(cal.getTimeInMillis());

		if (numeroDias == null) {
			numeroDias = 0;
		}

		cal.add(Calendar.DATE, numeroDias);
		Timestamp fecha2 = new Timestamp(cal.getTimeInMillis());

		RangeValue<Date> rangeValue = new RangeValue<Date>();
		rangeValue.setBottomValue(fecha1);
		rangeValue.setTopValue(fecha2);

		return rangeValue;
	}
	
	public RangeValue<Date> obtenerRangoFecha(Date fecha) {

		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date(fecha.getTime()));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Timestamp fecha1 = new Timestamp(cal.getTimeInMillis());

		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);

		Timestamp fecha2 = new Timestamp(cal.getTimeInMillis());

		RangeValue<Date> rangeValue = new RangeValue<Date>();
		rangeValue.setBottomValue(fecha1);
		rangeValue.setTopValue(fecha2);

		return rangeValue;
	}
	
	public RangeValue<Time> obtenerRangoHora(Time hora, Integer numeroHorasAux) {
		Integer numeroHoras = numeroHorasAux;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(hora.getTime());

		if (numeroHoras == null) {
			numeroHoras = 0;
		}
		
		cal.add(Calendar.HOUR_OF_DAY, numeroHoras);
		Time hora2 = new Time(cal.getTimeInMillis());

		RangeValue<Time> rangeValue = new RangeValue<Time>();
		rangeValue.setBottomValue(hora);
		rangeValue.setTopValue(hora2);

		return rangeValue;
	}
	
	/**
	 * Paremetriza un rango de hora desde los 00 minutos hasta los 59 minutos
	 * @param hora
	 * @return
	 */
	public RangeValue<Time> obtenerRangoHora(Time hora) {

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(hora.getTime());

		int numeroMinutos = 59;
		
		cal.set(Calendar.MINUTE, numeroMinutos);
		Time hora2 = new Time(cal.getTimeInMillis());

		RangeValue<Time> rangeValue = new RangeValue<Time>();
		rangeValue.setBottomValue(hora);
		rangeValue.setTopValue(hora2);

		return rangeValue;
	}

	/**
	 * Calcula la hora de espera para la recepcion en bodega del proveedor
	 * 
	 * @param fecha
	 * @return
	 */
	public RangeValue<Timestamp> obtenerRangoHoraEntrega(Timestamp fecha, Integer tiempoAntes, Integer tiempoDespues) {
		Calendar cal = Calendar.getInstance(); // locale-specific

		cal.setTime(new Date(fecha.getTime()));
		// cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		if (tiempoAntes != null) {
			cal.add(Calendar.MILLISECOND, -tiempoAntes);
		}
		Timestamp fecha1 = new Timestamp(cal.getTimeInMillis());

		if (tiempoAntes != null) {
			cal.add(Calendar.MILLISECOND, tiempoDespues);
		}
		Timestamp fecha2 = new Timestamp(cal.getTimeInMillis());

		RangeValue<Timestamp> rangeValue = new RangeValue<Timestamp>();
		rangeValue.setBottomValue(fecha1);
		rangeValue.setTopValue(fecha2);

		return rangeValue;
	}
	
	/**
	 * 
	 * @param fecha
	 * @param dias
	 * @return
	 */
	public Date incrementarDiasFecha(Date fecha, Integer dias) {
		Calendar cal = Calendar.getInstance();
		if (fecha != null && dias != null && dias > 0) {
			cal.setTime(fecha);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.add(Calendar.DATE, dias);
			return cal.getTime();
		} 
		return fecha;
	}
	
	public Integer calcularDiferenciaHoras(Time timeHoraMayor, Time timeHoraMenor) {
		//Operaciones sobre la hora mayor
		Calendar calendarHoraMayor = Calendar.getInstance();
		calendarHoraMayor.setTime(timeHoraMayor);
		int horaMayor = calendarHoraMayor.get(GregorianCalendar.HOUR_OF_DAY);
		
		//Operaciones sobre la hora menor
		Calendar calendarHoraMenor = Calendar.getInstance();
		calendarHoraMenor.setTime(timeHoraMenor);
		int horaMenor = calendarHoraMenor.get(GregorianCalendar.HOUR_OF_DAY);
		
		//Calcula la diferencia de horas entre la horaMayor y horaMenor
		int diferenciaHoras = horaMayor - horaMenor;
		
		return diferenciaHoras;
	}

	/**
	 * Calcula el rango de fechas para una busquedas
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public RangeValue<Date> obtenerRangoFecha(Date fechaInicio, Date fechaFin) {
		RangeValue<Date> rangeValue = new RangeValue<Date>();
		Calendar cal = Calendar.getInstance(); // locale-specific
		cal.setTime(fechaInicio);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		rangeValue.setBottomValue(cal.getTime());

		if (fechaFin != null) {
			cal.setTime(fechaFin);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.add(Calendar.DATE, 1);
			rangeValue.setTopValue(cal.getTime());
		} else {
			cal.setTime(fechaInicio);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.add(Calendar.DATE, 1);
			rangeValue.setTopValue(cal.getTime());
		}
		return rangeValue;
	}

	/**
	 * 
	 * @param fechaEntrega
	 * @return
	 */
	public Long obtenerFechaFormatoLong(Date fechaEntrega) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaEntrega);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTimeInMillis();
	}

	/**
	 * Obtiene el dia de la semana de una fecha
	 * 
	 * @param fecha
	 *            Una fecha
	 * @return Dia de la semana
	 */
	public Integer obtenerDiaSemanaCalendario(Date fecha) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		return calendario.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Suma un determinado numero de horas a una fecha
	 * 
	 * @param fecha
	 *            Un Date
	 * @param numHoras
	 *            Numero de horas de rango
	 * @return Un Date
	 */
	public Date sumarHorasFecha(Date fecha, Integer numHoras) {
		if (numHoras == null) {
			return fecha;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fecha.getTime()));
		cal.add(Calendar.HOUR_OF_DAY, numHoras);
		return cal.getTime();
	}
	
	/**
	 * Obtiene la fecha con la hora actual en un rango de horas
	 * 
	 * @param numHoras
	 *            Numero de horas de rango
	 * @return Un RangeValue de Date
	 */
	public RangeValue<Date> obtenerFechaActualHoraRange(Integer numHoras) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date(System.currentTimeMillis()));
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Date fecha1 = cal.getTime();

		cal.add(Calendar.HOUR_OF_DAY, numHoras);
		Timestamp fecha2 = new Timestamp(cal.getTimeInMillis());

		RangeValue<Date> rangeValue = new RangeValue<Date>();
		rangeValue.setBottomValue(fecha1);
		rangeValue.setTopValue(fecha2);

		return rangeValue;
	}

	/**
	 * Concatena la fecha y la hora un solo Date
	 * @param fecha Un Date
	 * @param hora Un Time
	 * @return Un Date
	 */
	public Date obtenerFechaConHora(Date fecha, Time hora) {
		Calendar calFecha = Calendar.getInstance();
		Calendar calHora = Calendar.getInstance();

		calFecha.setTime(fecha);

		if (hora != null) {
			calHora.setTime(hora);
			calFecha.set(Calendar.HOUR_OF_DAY, calHora.get(Calendar.HOUR_OF_DAY));
			calFecha.set(Calendar.MINUTE, calHora.get(Calendar.MINUTE));
			calFecha.set(Calendar.SECOND, calHora.get(Calendar.SECOND));
			calFecha.set(Calendar.MILLISECOND, calHora.get(Calendar.MILLISECOND));
		}

		return calFecha.getTime();
	}

	/**
	 * Obtiene la hora actual en formato HH:mm:ss del sistema sin fecha en Date
	 * 
	 * @return Un Date
	 */
	public Time obtenerHoraActualCompleta() throws SICException{
		Time horaActual = null;
		Date fechaActual = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			fechaActual = new Date(System.currentTimeMillis());
			String strHoraActual = sdf.format(fechaActual);
			fechaActual = sdf.parse(strHoraActual);
			horaActual = new Time(fechaActual.getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return horaActual;
	}
	
	public Time obtenerHoraFormater(Date date, String formato) throws SICException{
		Time horaFormat = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			String strHora = sdf.format(date);
			Date horaDate = sdf.parse(strHora);
			horaFormat = new Time(horaDate.getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return horaFormat;
	}
	
	public Time obtenerHora0() throws SICException{
		Time hora0 = CalculoFechasUtil.getInstancia().obtenerHoraActual();
		try {
			Calendar calHora = Calendar.getInstance();
			if (hora0 != null) {
				calHora.set(Calendar.HOUR_OF_DAY, 0);				
				calHora.set(Calendar.MINUTE, 0);
				calHora.set(Calendar.SECOND, 0);
				calHora.set(Calendar.MILLISECOND, 0);
			}
			hora0 = new Time(calHora.getTime().getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return hora0;
	}
	
	public String obtenerHoraFormaterToString(Date date, String formato)throws SICException{
		String strHora = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			strHora = sdf.format(date);
		} catch (Exception e) {
			throw new SICException(e);
		}
		return strHora;
	}
	
	public String obtenerFechaFormaterToString(Date date, String formato) throws SICException{
		String strFecha = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			strFecha = sdf.format(date);
		} catch (Exception e) {
			throw new SICException(e);
		}
		return strFecha;
	}
	
	public Date obtenerFechaTrunk(Date date)throws SICException{
		Date fechaTrunk = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strHora = sdf.format(date);
			fechaTrunk = sdf.parse(strHora);
		} catch (Exception e) {
			throw new SICException(e);
		}
		return fechaTrunk;
	}

	/**
	 * Obtiene la hora actual en formato HH del sistema sin fecha en Date
	 * 
	 * @return Un Date
	 */
	public Time obtenerHoraActual()throws SICException{
		Time horaActual = null;
		Date fechaActual = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH");
			fechaActual = new Date(System.currentTimeMillis());
			String strHoraActual = sdf.format(fechaActual);
			fechaActual = sdf.parse(strHoraActual);
			horaActual = new Time(fechaActual.getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return horaActual;
	}
	
	public Time obtenerHoraActual(String formatAux) throws SICException{
		String format = formatAux;
		Time horaActual = null;
		Date fechaActual = null;
		try {
			if (StringUtils.isEmpty(format)) {
				format = "HH:mm";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			fechaActual = new Date(System.currentTimeMillis());
			String strHoraActual = sdf.format(fechaActual);
			fechaActual = sdf.parse(strHoraActual);
			horaActual = new Time(fechaActual.getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return horaActual;
	}
	
	public Time obtenerHoraTrunk(Date date)throws SICException{
		Time horaTrunk = null;
		Date fechaActual = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH");
			String strHora = sdf.format(date);
			fechaActual = sdf.parse(strHora);
			horaTrunk = new Time(fechaActual.getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return horaTrunk;
	}
	
	public Time obtenerHoraTrunk(Time horaAux) throws SICException{
		Time hora = horaAux;
		try {
			Calendar calHora = Calendar.getInstance();
			if (hora != null) {
				calHora.setTime(hora);				
				calHora.set(Calendar.MINUTE, 0);
				calHora.set(Calendar.SECOND, 0);
				calHora.set(Calendar.MILLISECOND, 0);
			}
			hora = new Time(calHora.getTime().getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return hora;
	}
	
	public Time obtenerHoraTrunk(Time hora, String formater) throws SICException {
		Time hor = null;
		try {
			if (hora != null) {
				SimpleDateFormat sdf = new SimpleDateFormat(formater);
				String strHora = sdf.format(hora);
				Date date = sdf.parse(strHora);
				hor = new Time(date.getTime());
			}
		} catch (Exception e) {
			throw new SICException(e);
		}
		return hor;
	}
	
	public Time obtenerHoraActualTrunk() throws SICException{
		Time horaActual = this.obtenerHoraActual();
		try {
			Calendar calHora = Calendar.getInstance();
			if (horaActual != null) {
				calHora.setTime(horaActual);				
				calHora.set(Calendar.MINUTE, 0);
				calHora.set(Calendar.SECOND, 0);
				calHora.set(Calendar.MILLISECOND, 0);
			}
			horaActual = new Time(calHora.getTime().getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return horaActual;
	}

	public Time obtenerHora(Date fecha) throws SICException{
		Time horaFecha = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String strHoraFecha = sdf.format(fecha);
			Date date = sdf.parse(strHoraFecha);
			horaFecha = new Time(date.getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return horaFecha;
	}
	
	public Time obtenerHoraByString(String strHora) throws SICException{
		Time time = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date hora = sdf.parse(strHora);
			time = new Time(hora.getTime());
		} catch (Exception e) {
			throw new SICException(e);
		}
		return time;
	}
	
	public Date obtenerFechaByString(String strDate) throws SICException{
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(strDate);
		} catch (Exception e) {
			throw new SICException(e);
		}
		
		return date;
	}
	
	public Time seleccionarHoraAnterior(List<Time> timesAux, Time hora) {
		Time timeSelected = null;
		List<Time> times = timesAux;
		
		if (CollectionUtils.isNotEmpty(times)) {
			times = this.ordenarTimes(times);
			for (Time time : times) {
				if (time.compareTo(hora) == -1) {
					timeSelected = time;
				} else {
					break;
				}
			}
		}
		return timeSelected;
	}
	
	public Time seleccionarHoraSiguiente(List<Time> timesAux, Time hora) {
		List<Time> times = timesAux;
		Time timeSelected = null;
		
		if (CollectionUtils.isNotEmpty(times)) {
			times = this.ordenarTimes(times);
			for (Time time : times) {
				if (time.compareTo(hora) == 1) {
					timeSelected = time;
					break;
				}
			}
		}
		return timeSelected;
	}
	
	public List<Time> ordenarTimes(List<Time> times) {
		if (CollectionUtils.isNotEmpty(times)) {
			Collections.sort(times, new Comparator<Time>() {
				@Override
				public int compare(Time time1, Time time2) {
					return time1.compareTo(time2);
				};
			});
		}
		return times;
	}
	
	public Time existeTimePorHora(List<Time> times, Time timeSearchAux) {
		Time timeSearch = timeSearchAux;
		Time timeSelected = null;
		if (CollectionUtils.isNotEmpty(times) && timeSearch != null) {
			timeSearch = CalculoFechasUtil.getInstancia().obtenerHoraTrunk(timeSearch);
			for (Time time : times) {
				Time timeFind = CalculoFechasUtil.getInstancia().obtenerHoraTrunk(time);
				if (timeFind.compareTo(timeSearch) == 0) {
					timeSelected = time;
					break;
				}
			}
		}
		return timeSelected;
	}
}
