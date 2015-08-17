package ec.com.smx.sic.cliente.gestor.proveedor.marcaProveedor.almacenamiento;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

public interface IAlmacenamientoDatosMarcaProveedorGestor extends Serializable {

	/**
	 * @param proveedorVO
	 * @param proveedorMarcaTotal
	 * @param proveedorMarcaRegistrar
	 * @return Collection<ProveedorMarcaDTO>
	 * @throws SICException
	 */
	public void guardarDatosProveedorMarca(ProveedorVO proveedorVO, ResultadoValidacionProveedor resultadoValidacionProveedor, 
			Collection<ProveedorMarcaDTO> proveedorMarcaTotal, Collection<ProveedorMarcaDTO> proveedorMarcaRegistrar) throws Exception;
}
