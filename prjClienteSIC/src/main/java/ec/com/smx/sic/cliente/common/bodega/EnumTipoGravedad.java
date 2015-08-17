
package ec.com.smx.sic.cliente.common.bodega;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en los procesos de bodega
 * 
 * @author lguaman
 *
 */
public enum EnumTipoGravedad {

	//VALORES DE TIPO DE GRAVEDAD LISTA DEL GUARDIA
	TIPO_GRAVEDAD_NORMAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.gravedad.normal")),
	TIPO_GRAVEDAD_ADVERTENCIA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.gravedad.advertencia")),
	TIPO_GRAVEDAD_ERROR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.gravedad.error")),
	;
	
	private String codigoCatalogoValor;
	
	private EnumTipoGravedad(String codigoCatalogoValor){
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
