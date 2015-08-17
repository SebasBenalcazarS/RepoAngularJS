/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.kruger.utilitario.dao.commons.constants.EventTypeEnum;


/**
 * @author Mario Braganza 
 * @author lyacchirema
 *
 */
@SuppressWarnings("serial")
public class ResultadoValidacionProveedorCodigo extends CodigoResultadoValidacionProveedor {
	
	public enum ResultadoValidacionRUCFinanciero{
		RUC_DUPLICADO,
		RUC_NO_DUPLICADO;
	}
	
	/**
	 * 
	 * @param accion
	 * @param mostrarAlerta
	 * @param eventType
	 */
	public ResultadoValidacionProveedorCodigo(Accion accion,
			Boolean mostrarAlerta, EventTypeEnum eventType) {
		super(accion, mostrarAlerta, eventType);
	}

	public final static ResultadoValidacionProveedorCodigo NO_EXISTE_JDE = new ResultadoValidacionProveedorCodigo(Accion.ERROR, false, null){};
	public final static ResultadoValidacionProveedorCodigo NO_EXISTE_RUC_JDE = new ResultadoValidacionProveedorCodigo(Accion.ERROR, false, null){};
	
	public final static ResultadoValidacionProveedorCodigo CREAR = new ResultadoValidacionProveedorCodigo(Accion.CREAR, false, EventTypeEnum.CREATE){};
	public final static ResultadoValidacionProveedorCodigo CON_RUC = new ResultadoValidacionProveedorCodigo(Accion.EDITAR, false, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorCodigo SIN_RUC = new ResultadoValidacionProveedorCodigo(Accion.CREAR, false, EventTypeEnum.CREATE){};

	public final static ResultadoValidacionProveedorCodigo ACTUALIZAR_PROVEEDOR_PROVISIONAL = new ResultadoValidacionProveedorCodigo(Accion.EDITAR, true, EventTypeEnum.UPDATE) {};
	public final static ResultadoValidacionProveedorCodigo CREAR_RUC_NO_VALIDO_JDE = new ResultadoValidacionProveedorCodigo(Accion.VALIDAR, true, EventTypeEnum.CREATE){};
	public final static ResultadoValidacionProveedorCodigo SIN_RUC_RUC_NO_VALIDO_JDE = new ResultadoValidacionProveedorCodigo(Accion.VALIDAR, true, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorCodigo RUC_VALIDO = new ResultadoValidacionProveedorCodigo(Accion.CREAR, false, EventTypeEnum.CREATE){};
	public final static ResultadoValidacionProveedorCodigo VARIOS_JDE = new ResultadoValidacionProveedorCodigo(Accion.EDITAR, true, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorCodigo RUC_NO_VALIDO_JDE = new ResultadoValidacionProveedorCodigo(Accion.EDITAR, true, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorCodigo RUC_NO_IGUALES_JDE_CORPORATIVO = new ResultadoValidacionProveedorCodigo(Accion.EDITAR, true, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorCodigo RUC_NO_IGUALES_JDE_CORPORATIVO_NO_VALIDO_CORPORATIVO = new ResultadoValidacionProveedorCodigo(Accion.EDITAR, true, EventTypeEnum.UPDATE){};
	public final static ResultadoValidacionProveedorCodigo VARIOS_JDE_BASE_FINANCIERA = new ResultadoValidacionProveedorCodigo(Accion.ERROR, false, null){};
	public final static ResultadoValidacionProveedorCodigo SOLO_EXISTE_JDE_BASE_CORPORATIVA = new ResultadoValidacionProveedorCodigo(Accion.ERROR, false, null){};
	public final static ResultadoValidacionProveedorCodigo RUC_VACIO_BASE_FINANCIERA = new ResultadoValidacionProveedorCodigo(Accion.VALIDAR, false, null){};
	public final static ResultadoValidacionProveedorCodigo RUC_NO_VALIDO_BASE_FINANCIERA = new ResultadoValidacionProveedorCodigo(Accion.VALIDAR, false, null){};
	public final static ResultadoValidacionProveedorCodigo SIN_RUC_BASE_CORPORATIVA = new ResultadoValidacionProveedorCodigo(Accion.ERROR, false, null){};
	public final static ResultadoValidacionProveedorCodigo JDE_BASE_FINANCIERA_DIFERENTE_JDE_BASE_CORPORATIVA = new ResultadoValidacionProveedorCodigo(Accion.ERROR, false, null){};
	public final static ResultadoValidacionProveedorCodigo VARIOS_PROVEEDORES_MISMA_EMPRESA = new ResultadoValidacionProveedorCodigo(Accion.ERROR, false, null){};
	

	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.proveedor.CodigoResultadoValidacionProveedor#getTipoValidacionProveedor()
	 */
	@Override
	public TipoValidacionProveedor getTipoValidacionProveedor() {
		return TipoValidacionProveedor.CODIGO;
	}
	
	
	
}
