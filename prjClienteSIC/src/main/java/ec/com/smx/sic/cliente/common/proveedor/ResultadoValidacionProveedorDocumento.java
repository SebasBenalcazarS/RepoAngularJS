/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.kruger.utilitario.dao.commons.constants.EventTypeEnum;


/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class ResultadoValidacionProveedorDocumento extends CodigoResultadoValidacionProveedor {
	
	
	/**
	 * 
	 * @param accion
	 * @param mostrarAlerta
	 * @param eventType
	 */
	public ResultadoValidacionProveedorDocumento(Accion accion,
			Boolean mostrarAlerta, EventTypeEnum eventType) {
		super(accion, mostrarAlerta, eventType);
	}
	
	public final static ResultadoValidacionProveedorDocumento CREAR = new ResultadoValidacionProveedorDocumento(Accion.CREAR, false, EventTypeEnum.CREATE){};
	public final static ResultadoValidacionProveedorDocumento PROVEEDOR_EXISTENTE = new ResultadoValidacionProveedorDocumento(Accion.VISUALIZAR, false, null){};
	public final static ResultadoValidacionProveedorDocumento PERSONA_PROVEEDOR_EXISTENTE = new ResultadoValidacionProveedorDocumento(Accion.EDITAR, false, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorDocumento EMPRESA_PROVEEDOR_EXISTENTE = new ResultadoValidacionProveedorDocumento(Accion.EDITAR, false, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorDocumento DOCUMENTO_NO_CORRESPONDE_PERSONA_EMPRESA = new ResultadoValidacionProveedorDocumento(Accion.ERROR, false, null){};
	public final static ResultadoValidacionProveedorDocumento PROVEEDOR_PROVISIONAL_EXISTENTE = new ResultadoValidacionProveedorDocumento(Accion.VISUALIZAR, false, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorDocumento VARIOS_PROVEEDORES_MISMA_EMPRESA = new ResultadoValidacionProveedorDocumento(Accion.ERROR, false, null){};
	


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.proveedor.CodigoResultadoValidacionProveedor#getTipoValidacionProveedor()
	 */
	@Override
	public TipoValidacionProveedor getTipoValidacionProveedor() {
		return TipoValidacionProveedor.DOCUMENTO;
	}
}
