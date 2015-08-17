/*
 * Kruger 2015 
 */ 
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.reporte.tesoreria;

import org.jdom.Document;

import ec.com.smx.corpv2.dto.DefinicionGrupoImpresoraDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * <b> Permite procesar los datos del reporte. </b>
 *
 * @author mchiliquinga, Date: 16/3/2015
 *
 */
public interface IReporteTesoreriaDocumentoGestor {
	
	/**
	 * <b> obtiene una impresora asociada al area de trabajo del usuario logeado. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 13/3/2015]
	 * </p>
	 *
	 * @param codigoCompania
	 *            compania asociada al usuario logeado
	 * @param codigoAreaTrabajo
	 *            area de trabajo asociada al usuario logeado
	 * @return impresora configurada
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error
	 */ 
	 DefinicionGrupoImpresoraDTO obtenerImpresora(Integer codigoCompania, Integer codigoAreaTrabajo) throws SICException;
	 
	/**
	 * <b> Crea un documento con los datos del reporte, este documento se imprimira en una ipresora previamente configurada. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 13/3/2015]
	 * </p>
	 *
	 * @param plantillaXML
	 *            contiene los datos del reporte en formato XML
	 * @return Documento con los datos del reporte
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error
	 */
	Document obtenerDocumentReporte(StringBuilder plantillaXML) throws SICException;
	
	/**
	 * <b> Iimprime el reporte haciendo uso de servicio proporcionado por el proyecto de etiquetado. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 13/3/2015]
	 * </p>
	 *
	 * @param impresoraSelecionada
	 *            impresora en la cual se imprimira el reporte
	 * @param documento
	 *            Documento que contiene los datos del reporte
	 */ 
	void imprimir(DefinicionGrupoImpresoraDTO impresoraSelecionada, Document documento) throws SICException;
	
	/**
	 * <b> En base a una plantilla en formato XML genera un arreglo de bytes para desplegar el reprote en formato PDF. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 17/3/2015]
	 * </p>
	 *
	 * @param contenidoXML
	 *            cadena en formato XML con los datos para el reporte
	 * @return arreglo de bytes con los datos del reporte
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error
	 */ 
	byte[] generarBytesReporteTesoreria(StringBuilder contenidoXML) throws SICException;

}
