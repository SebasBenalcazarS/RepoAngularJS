/**
 * 
 */
package ec.com.smx.sic.cliente.common.fruver.util;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ec.com.smx.framework.common.util.ConverterUtil;

/**
 * @author KRUGER\jcayo
 *
 */
public final class  FruverDateUtil {

	/**
	 * Suma un número de dias a una fecha
	 * @param fch
	 * @param dias
	 * @return
	 */
	public static Date sumarFechasDias(Date fecha, int dias) {
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(fecha.getTime());
		cal.add(Calendar.DATE, dias);
		return new Date(cal.getTimeInMillis());
	}


	/**
	 * Obtiene un fecha inicial a partir de un número de día de la próxima semana
	 * @param primerDiaRango
	 * @return
	 */
	public static Date obtenerFechaInicial(Integer primerDiaRango){
		Integer numeroDiasSemana = 7;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		return ConverterUtil.getTruncDate(sumarFechasDias(cal.getTime(), numeroDiasSemana+primerDiaRango));
	}

	/**
	 * Obtiene una fecha final apartir de una fecha inicial y un número de días a sumar
	 * @param fechaInicial
	 * @param numeroDiasRango
	 * @return
	 */
	public static Date obtenerFechaFinal(Date fechaInicial, Integer numeroDiasRango){
		return ConverterUtil.getTruncDate(sumarFechasDias(fechaInicial, numeroDiasRango));
	}

	/**
	 * Permite obtener el dia indicado agregandole horas, minutos y segundos de forma determinada
	 * @param fecha fecha inicial de la que se parte la combinacion
	 * @param dias dias que se suma a la fecha indicada
	 * @param horas horas que se agrega a la fecha indicada
	 * @return Fecha compuesta
	 */
	public static Date obtenerDiaHoras(Date fecha,int dias, Time horas){
		GregorianCalendar gC1 = new GregorianCalendar();
		GregorianCalendar gC2 = new GregorianCalendar();		
		Date dia  =   ConverterUtil.getTruncDate(sumarFechasDias(fecha, dias));
		gC1.setTime(dia);
		gC2.setTime(horas);
		gC1.set(GregorianCalendar.HOUR_OF_DAY, gC2.get(Calendar.HOUR_OF_DAY));
		gC1.set(GregorianCalendar.MINUTE, gC2.get(Calendar.MINUTE));
		gC1.set(GregorianCalendar.SECOND, gC2.get(Calendar.SECOND));
		return new Date(gC1.getTimeInMillis());
	}
}
