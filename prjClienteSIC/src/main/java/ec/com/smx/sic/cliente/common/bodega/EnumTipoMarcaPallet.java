
package ec.com.smx.sic.cliente.common.bodega;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores que intervienen en la marca de los pallets de la recepcion
 * 
 * @author lguaman
 *
 */
public enum EnumTipoMarcaPallet {

	//MARCAS QUE PUEDE TENER UN PALLET
	VALOR_MARCA_PALLET_SIN_PESAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.pallet.sin.pesar")),
	VALOR_MARCA_PALLET_PESADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.pallet.pesado")),
	VALOR_MARCA_PALLET_ENCERADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.pallet.encerado")),
	VALOR_MARCA_PALLET_REPESADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.pallet.repesado")),
	
	;
		
	
	private String codigoCatalogoValor;
	
	private EnumTipoMarcaPallet(String codigoCatalogoValor){
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
