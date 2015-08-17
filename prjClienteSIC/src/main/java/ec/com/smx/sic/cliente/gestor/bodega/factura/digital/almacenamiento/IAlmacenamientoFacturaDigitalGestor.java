package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.almacenamiento;

import ec.com.smx.frameworkv2.multicompany.dto.UserCompanySystemDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.BodegaVO;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;

public interface IAlmacenamientoFacturaDigitalGestor {

	/**
	 * M&eacute;todo que crea una autorizaci&oacute;n para la solicitud de andenes adicionales en una entrega.
	 * @param bodegaVO
	 * @param userCompanySystemDto
	 * @return
	 * @throws SICException
	 */
	public EntregaVO crearEntregaAutorizacion(BodegaVO bodegaVO, UserCompanySystemDto userCompanySystemDto,String codigoProveedor) throws SICException;

}
