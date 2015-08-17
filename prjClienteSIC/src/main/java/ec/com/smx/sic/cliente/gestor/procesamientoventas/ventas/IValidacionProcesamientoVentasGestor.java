package ec.com.smx.sic.cliente.gestor.procesamientoventas.ventas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.procesamientoventas.MigrarDatosProcesoVentaDTO;

public interface IValidacionProcesamientoVentasGestor extends Serializable {


	/**
	 * @param nameFile
	 * @param listaDatosArchivoFTP
	 * @param codigoLocal
	 * @param fechaEjecucion
	 * @param mensaje
	 * @throws SICException
	 */
	void validarArticulosFaltantesMAX(String nameFile, List<? extends MigrarDatosProcesoVentaDTO> listaDatosArchivoFTP, Integer codigoLocal, Date fechaEjecucion, String mensaje) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param listaArticulosSIC
	 * @param codigosBarrasMAX
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> crearArticulosNuevosSIC(Integer codigoCompania,List<? extends MigrarDatosProcesoVentaDTO> listaArticulosSIC, Set<String> codigosBarrasMAX) throws SICException;

}