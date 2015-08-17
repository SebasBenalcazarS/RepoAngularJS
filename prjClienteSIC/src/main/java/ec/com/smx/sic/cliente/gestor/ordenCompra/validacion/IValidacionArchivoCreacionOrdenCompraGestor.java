package ec.com.smx.sic.cliente.gestor.ordenCompra.validacion;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;

public interface IValidacionArchivoCreacionOrdenCompraGestor {

	/**
	 * @param ordenCompraCreacionVO
	 * @param inputStreamArchOrdenCompra
	 * @throws SICException
	 */
	@SuppressWarnings("rawtypes")
	public LinkedHashMap<String, List> validacionArchivoOrdenCompra(
			AdminOrdenCompraVO ordenCompraCreacionVO,
			InputStream inputStreamArchOrdenCompra) throws SICException;
	
	public void obtenerCabeceraArchivoValidado(HSSFWorkbook wb, HSSFSheet sheet, boolean notaPedido, boolean observacion) throws SICException;
}
