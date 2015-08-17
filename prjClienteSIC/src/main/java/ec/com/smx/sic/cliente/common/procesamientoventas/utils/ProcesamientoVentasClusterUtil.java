/**
 * 
 */
package ec.com.smx.sic.cliente.common.procesamientoventas.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OType;

import ec.com.smx.framework.utilitario.nosql.common.util.ODocumentUtil;
import ec.com.smx.framework.utilitario.nosql.common.util.OIndexUtil;
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

}
