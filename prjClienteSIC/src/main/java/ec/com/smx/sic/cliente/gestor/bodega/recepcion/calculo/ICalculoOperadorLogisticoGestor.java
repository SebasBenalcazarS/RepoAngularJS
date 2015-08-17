package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.OperadorLogisticoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;

public interface ICalculoOperadorLogisticoGestor {
	
	/**
	 * Permite obtener los datos del operador log&iacute;stico a partir del c&oacute;digo de la persona
	 * @param operadorLogisticoDTO
	 * @return
	 * @throws SICException
	 */
	public OperadorLogisticoDTO obtenerInformacionOperadorLogistico(OperadorLogisticoDTO operadorLogisticoDTO) throws SICException;
	
	/**
	 * Permite obtener los proveedores del operador log&iacute;sticos que est&aacute;n registrados en el DetalleRecepcionEntrega
	 * @param operadorLogisticoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleRecepcionEntregaDTO> obtenerProveedoresOperadorLogistico(OperadorLogisticoDTO operadorLogisticoDTO)throws SICException;
	
	/**
	 * Permite validar a partir del co&oacute;digo del proveedor si este tiene alg&uacute;n registro como FacturaDigital o como PlanificacionBodega
	 * @param codigoProveedor
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleRecepcionEntregaDTO> validarProveedorOperadorLogistico(String codigoProveedor,Integer codigoCompania)throws SICException;
	
	/**
	 * Valida si el proveedor seleccionado tiene operador logistico asignado
	 * @param recepcionProveedorVO
	 * @return
	 * @throws SICException
	 */
	public Boolean tieneOperadorLogistico(RecepcionProveedorVO recepcionProveedorVO)throws SICException;
}
