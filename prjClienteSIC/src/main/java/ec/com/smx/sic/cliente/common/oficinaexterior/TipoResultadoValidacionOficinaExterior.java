/**
 * 
 */
package ec.com.smx.sic.cliente.common.oficinaexterior;

import ec.com.kruger.utilitario.dao.commons.constants.EventTypeEnum;
import ec.com.smx.sic.cliente.common.proveedor.CodigoResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoValidacionProveedor;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class TipoResultadoValidacionOficinaExterior extends
		CodigoResultadoValidacionProveedor {
	
	
	/**
	 * 
	 * @param accion
	 * @param mostrarAlerta
	 * @param eventType
	 */
	public TipoResultadoValidacionOficinaExterior(Accion accion,
			Boolean mostrarAlerta, EventTypeEnum eventType){
		
		super(accion, mostrarAlerta, eventType);
	}
	
	
	public final static TipoResultadoValidacionOficinaExterior CREAR = new TipoResultadoValidacionOficinaExterior(Accion.CREAR, false, EventTypeEnum.CREATE){};
	public final static TipoResultadoValidacionOficinaExterior EDITAR = new TipoResultadoValidacionOficinaExterior(Accion.EDITAR, false, EventTypeEnum.UPDATE){};
	public final static TipoResultadoValidacionOficinaExterior PERSONA_EXISTENTE_SIN_OFICINA_EXTERIOR = new TipoResultadoValidacionOficinaExterior(Accion.CREAR, false, EventTypeEnum.UPDATE){};
	public final static TipoResultadoValidacionOficinaExterior EMPRESA_EXISTENTE_SIN_OFICINA_EXTERIOR = new TipoResultadoValidacionOficinaExterior(Accion.CREAR, false, EventTypeEnum.UPDATE){};
	public final static TipoResultadoValidacionOficinaExterior VARIAS_OFICINAS_MISMA_EMPRESA = new TipoResultadoValidacionOficinaExterior(Accion.ERROR, false, null){};
	

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.proveedor.CodigoResultadoValidacionProveedor#getTipoValidacionProveedor()
	 */
	@Override
	public TipoValidacionProveedor getTipoValidacionProveedor() {
		return TipoValidacionProveedor.DOCUMENTO;
	}

}
