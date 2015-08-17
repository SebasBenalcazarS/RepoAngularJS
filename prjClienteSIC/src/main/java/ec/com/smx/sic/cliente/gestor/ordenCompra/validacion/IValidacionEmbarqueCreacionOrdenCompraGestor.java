package ec.com.smx.sic.cliente.gestor.ordenCompra.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraRecepcionVO;
import ec.com.smx.sic.cliente.mdl.vo.ValidacionOrdenCompraEmbarqueVO;

public interface IValidacionEmbarqueCreacionOrdenCompraGestor {

	/**
	 * @param ordenCompraVO
	 * @param embarquesSeleccionados
	 * @return
	 * @throws SICException
	 */
	public Collection<ValidacionOrdenCompraEmbarqueVO> validacionEmbarqueOrdenCompra(
			AdminOrdenCompraRecepcionVO ordenCompraRecepcionVO,
			Collection<EmbarqueEstadoImpDTO> embarquesSeleccionados) throws SICException;
}
