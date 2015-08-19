/**
 * 
 */
package ec.com.smx.sic.cliente.common.procesamientoventas.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OType;

import ec.com.smx.framework.utilitario.nosql.common.util.ODocumentUtil;
import ec.com.smx.framework.utilitario.nosql.common.util.OIndexUtil;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.procesamientoventas.constantes.ProcesamientoVentasConstantes;
import ec.com.smx.sic.cliente.common.procesamientoventas.constantes.TipoClusterProcesamientoVenta;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public final class ProcesamientoVentasClusterUtil {

	private static final ProcesamientoVentasClusterUtil INSTANCE = new ProcesamientoVentasClusterUtil();

	private ProcesamientoVentasClusterUtil(){}

	public static ProcesamientoVentasClusterUtil getInstance(){
		return INSTANCE;
	}


	/**
	 * @param clusterDate
	 * @return
	 */
	private String getPrefixClusterYear(Date clusterDate) {

		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);		
		calendarLocaleES.setTime(clusterDate);

		return String.valueOf(calendarLocaleES.get(Calendar.YEAR));

	}


	/**
	 * @param clusterDate
	 * @param clusterTransationCode
	 * @return
	 */
	private String getPrefixClusterYearTransaction(Date clusterDate, Integer clusterTransationCode) {

		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);		
		calendarLocaleES.setTime(clusterDate);

		return String.valueOf(calendarLocaleES.get(Calendar.YEAR))
				.concat(String.valueOf(clusterTransationCode));

	}


	/**
	 * @param clusterDate
	 * @param clusterTransationCode
	 * @return
	 */
	private String getPrefixClusterYearMonthTransaction(Date clusterDate, Integer clusterTransationCode) {

		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);		
		calendarLocaleES.setTime(clusterDate);

		return String.valueOf(calendarLocaleES.get(Calendar.YEAR))
				.concat(String.valueOf(calendarLocaleES.get(Calendar.MONTH) + 1))
				.concat(String.valueOf(clusterTransationCode));

	}


	/**
	 * @param currentClassName
	 * @param currentDate
	 * @param currentTransationCode
	 * @return
	 * @throws SICException
	 */
	private String getClusterNameYearMonthTransaction(String currentClassName, Date currentDate, Integer currentTransationCode) throws SICException {	

		if (StringUtils.isEmpty(currentClassName) || currentDate == null || currentTransationCode == null) {
			throw new SICException("Todos los parametros son obligatorios...");
		}

		// Generar nombre completo del cluster
		return currentClassName.concat(getPrefixClusterYearMonthTransaction(currentDate, currentTransationCode));

	}


	/**
	 * @param currentClassName
	 * @param currentDate
	 * @param currentTransationCode
	 * @return
	 * @throws SICException
	 */
	private String getClusterNameYearTransaction(String currentClassName, Date currentDate, Integer currentTransationCode) throws SICException {	

		if (StringUtils.isEmpty(currentClassName) || currentDate == null || currentTransationCode == null) {
			throw new SICException("Todos los parametros son obligatorios...");
		}

		// Generar nombre completo del cluster
		return currentClassName.concat(getPrefixClusterYearTransaction(currentDate, currentTransationCode));

	}	


	/**
	 * @param currentClassName
	 * @param currentDate
	 * @return
	 * @throws SICException
	 */
	private String getClusterNameYear(String currentClassName, Date currentDate) throws SICException {	

		if (StringUtils.isEmpty(currentClassName) || currentDate == null) {
			throw new SICException("Todos los parametros son obligatorios...");
		}

		// Generar nombre completo del cluster
		return currentClassName.concat(getPrefixClusterYear(currentDate));

	}


	/**
	 * @param dateValidate
	 * @return
	 */
	public Integer getDayOfYearForDate(Date dateValidate) {

		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);		
		calendarLocaleES.setTime(dateValidate);

		return calendarLocaleES.get(Calendar.DAY_OF_YEAR);

	}
	
	public Date getDateForDayOfYear(Integer day, Date fecha) {
		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);
		calendarLocaleES.setTime(fecha);
		calendarLocaleES.set(Calendar.DAY_OF_YEAR, day);
		
		return calendarLocaleES.getTime();
	}

	public Date getDateForDayOfYear(Integer day, Integer year) {
		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);
		calendarLocaleES.set(year, 1, 1);
		calendarLocaleES.set(Calendar.DAY_OF_YEAR, day);
		
		return calendarLocaleES.getTime();
	}

	public Date getDateForDayOfYear(Integer day, String year) {
		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);
		calendarLocaleES.set(Integer.parseInt(year), 1, 1);
		calendarLocaleES.set(Calendar.DAY_OF_YEAR, day);
		
		return calendarLocaleES.getTime();
	}

	/**
	 * @param dateValidate
	 * @return
	 */
	public Integer getYearForDate(Date dateValidate) {

		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);		
		calendarLocaleES.setTime(dateValidate);

		return calendarLocaleES.get(Calendar.YEAR);

	}


	/**
	 * @param tipoClusterProcesamientoVenta
	 * @param currentClassName
	 * @param currentDate
	 * @param currentTransationCode
	 * @return
	 */
	public String getClusterClassName(TipoClusterProcesamientoVenta tipoClusterProcesamientoVenta,
			String currentClassName, Date currentDate,  Integer currentTransationCode) {

		String clusterClassName = null;

		if (TipoClusterProcesamientoVenta.YEAR.equals(tipoClusterProcesamientoVenta)) {
			if (tipoClusterProcesamientoVenta == null || StringUtils.isEmpty(currentClassName) || currentDate == null) {
				throw new SICException("Los parametros: tipoClusterProcesamientoVenta, currentClassName, currentDate son obligatorios...");
			}	
		}
		else {
			if (tipoClusterProcesamientoVenta == null || StringUtils.isEmpty(currentClassName) || currentDate == null || currentTransationCode == null) {
				throw new SICException("Todos los parametros son obligatorios...");
			}			
		}		

		switch (tipoClusterProcesamientoVenta) {
		case YEAR:
			clusterClassName = getClusterNameYear(currentClassName, currentDate);
			break;

		case YEAR_TRANSACTION:
			clusterClassName = getClusterNameYearTransaction(currentClassName, currentDate, currentTransationCode);
			break;

		case YEAR_MONTH_TRANSACTION:
			clusterClassName = getClusterNameYearMonthTransaction(currentClassName, currentDate, currentTransationCode);
			break;
		}

		return clusterClassName;

	}


	/**
	 * @param db
	 * @param tipoClusterProcesamientoVenta
	 * @param currentClassName
	 * @param currentDate
	 * @param currentTransationCode
	 * @return
	 * @throws SICException
	 */
	public String getClusterClassValidated(ODatabaseDocumentTx db, TipoClusterProcesamientoVenta tipoClusterProcesamientoVenta,
			String currentClassName, Date currentDate,  Integer currentTransationCode) throws SICException {

		if (db == null) {
			throw new SICException("El objeto de base es obligatorio...");
		}

		// Generar nombre completo del cluster
		String clusterClassValidated = getClusterClassName(tipoClusterProcesamientoVenta, currentClassName, currentDate, currentTransationCode);

		// Validar si existe cluster
		if (ODocumentUtil.existClusterName(db, clusterClassValidated)) {
			return clusterClassValidated;
		}

		return null;
	}


	/**
	 * @param db
	 * @param tipoClusterProcesamientoVenta
	 * @param indexName
	 * @param currentDate
	 * @param transactionCode
	 * @throws SICException
	 */
	public synchronized void createIndexForClusterClass(ODatabaseDocumentTx db, TipoClusterProcesamientoVenta tipoClusterProcesamientoVenta,
			String indexName, Date currentDate, Integer transactionCode, OType[] dataTypesIndex) throws SICException {

		String indexNameForClass;

		try {

			if (db == null || tipoClusterProcesamientoVenta == null 
					|| StringUtils.isEmpty(indexName) || currentDate == null 
					|| transactionCode == null || dataTypesIndex == null 
					|| (dataTypesIndex != null && dataTypesIndex.length == 0)) {

				throw new SICException("Todos los parametros son obligatorios...");
			}

			// Generar nombre de indice para un cluster de una clase
			indexNameForClass = getClusterClassName(tipoClusterProcesamientoVenta, indexName, currentDate, transactionCode);			

			// Crear indice si no existe
			OIndexUtil.createIndex(db, indexNameForClass, dataTypesIndex);

		} catch (Exception e) {
			throw new SICException("Error al validar y crear un indice para una cluster de una clase...", e);
		}

	}


	/**
	 * @param db
	 * @param tipoClusterProcesamientoVenta
	 * @param className
	 * @param currentDate
	 * @param transactionCode
	 * @throws SICException
	 */
	public synchronized void addClusterToClass(ODatabaseDocumentTx db, TipoClusterProcesamientoVenta tipoClusterProcesamientoVenta,
			String className, Date currentDate, Integer transactionCode) throws SICException {

		String clusterName;

		try {

			// Generar cluster para agregarlo a la clase
			clusterName = getClusterClassName(tipoClusterProcesamientoVenta, className, currentDate, transactionCode);

			// Crear cluster si no existe
			ODocumentUtil.addClusterToClass(db, className, clusterName);

		} catch (Exception e) {
			throw new SICException("Error al validar y crear un cluster en una clase...", e);
		}
	}

	/**
	 * 
	 * @param mapStringString
	 * @return
	 */
	public Map<Integer, BigDecimal> convertirEnMapIntegerBigDecimal(Map<String, Object> mapStringString) {
		Map<Integer, BigDecimal> mapa = new HashMap<>();
	
		for (Map.Entry<String, Object> entry : mapStringString.entrySet()) {
			mapa.put(Integer.parseInt(entry.getKey()), new BigDecimal(entry.getValue().toString()));
		}
		
		return mapa;
	}
	
	/**
	 * Este método eventualmente se puede elimnar hasta encontrar la sintaxis de filtrar mapas embebidos en orientdb
	 * @param map
	 * @param diaInicial
	 * @param diaFinal
	 * @return
	 */
	public Map<Integer, BigDecimal> verificarFechas(Map<Integer, BigDecimal> map, Integer diaInicial, Integer diaFinal) {
		
		Map<Integer, BigDecimal> nuevoMapa = new HashMap<>();
		for (Map.Entry<Integer, BigDecimal> entry : map.entrySet()) {
			if (entry.getKey() >= diaInicial && entry.getKey() <= diaFinal) {
				nuevoMapa.put(entry.getKey(), entry.getValue());
			}
		}
		return nuevoMapa;
	}

	/**
	 * 
	 * @return
	 */
	public Comparator<Integer> comparadorDatoPrecioMargenReal() {
		return new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1.compareTo(i2);
			}
		};
	}
	
	public String devolverTiposPrecioConcatenados(String tipoConsulta) {
		if ("D".equals(tipoConsulta)) {
			return "'" + SICArticuloConstantes.TIPO_PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_DIARIO +"','" + SICArticuloConstantes.TIPO_PRECIO_BASE_DESCUENTO_DIARIO + "'";
		} else if ("A".equals(tipoConsulta)) {
			return "'" + SICArticuloConstantes.TIPO_PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_ACUMULADO + "','" + SICArticuloConstantes.TIPO_PRECIO_BASE_DESCUENTO_ACUMULADO + "'";
		}
		return "";
	}

	public List<Date> devolverAniosIntermedios(Date fechaInicial, Date fechaFinal) {
		List<Date> lista = new ArrayList<>();
		
		Calendar calendarLocaleES = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);
		
		for (int i=-1; i < (getYearForDate(fechaFinal) - getYearForDate(fechaInicial)); i++) {
			calendarLocaleES.set(getYearForDate(fechaInicial) + 1 + i , 1, 1);
			lista.add(calendarLocaleES.getTime());
		}
		
		return lista;
	}
	
}
