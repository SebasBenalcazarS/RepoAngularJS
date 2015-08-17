
package ec.com.smx.sic.cliente.common.bodega;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en los procesos de bodega
 * 
 * @author acaiza
 *
 */
public enum EnumTipoEntrega {

	//VALORES DE TIPO DE CREACION DE ENTREGAS
	TIPO_FACTURA_DIGITAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.entrega.facturaDigital")),
	TIPO_PLANIFICACION_CALENDARIO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.entrega.planificacionCalendario")),
	TIPO_MIGRACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.entrega.migracion")),
	TIPO_AUTORIZACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.entrega.autorizacion")),
	;
	
	private String codigoCatalogoValor;
	
	private EnumTipoEntrega(String codigoCatalogoValor){
		this.codigoCatalogoValor = codigoCatalogoValor;
	}

	/**
	 * @return the codigoCatalogoValor
	 */
	public String getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}

	/**
	 * @param codigoCatalogoValor the codigoCatalogoValor to set
	 */
	public void setCodigoCatalogoValor(String codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}
}
