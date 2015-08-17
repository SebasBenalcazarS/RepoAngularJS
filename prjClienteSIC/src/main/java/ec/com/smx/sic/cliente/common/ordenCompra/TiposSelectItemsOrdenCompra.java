package ec.com.smx.sic.cliente.common.ordenCompra;

import java.util.Arrays;
import java.util.List;

/**
 * @author aguato
 *
 */
public enum TiposSelectItemsOrdenCompra {

	/**Generacion de orden de compra*/
	ORDEN_COMPRA(SICOrdenCompraConstantes.CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENVIADA, SICOrdenCompraConstantes.LABEL_GRC_ORDEN_COMPRA),
	NOTA_PEDIDO(SICOrdenCompraConstantes.CODIGO_VALOR_ESTADO_ORDENCOMPRA_NOTAPEDIDO, SICOrdenCompraConstantes.LABEL_GRC_NOTA_PEDIDO),
	
	/**Ordenamiento de articulos*/
	CODIGO_BARRAS_ARTICULO(SICOrdenCompraConstantes.PATRON_ORDENAR_POR_CODIGO_BARRAS, SICOrdenCompraConstantes.LABEL_ORDENAR_POR_CODIGO_BARRAS),
	DESCRIPCION_ARTICULO(SICOrdenCompraConstantes.PATRON_ORDENAR_POR_DESCRIPCION, SICOrdenCompraConstantes.LABEL_ORDENAR_POR_DECRIPCION),
	CODIGO_UNICO_ARTICULO(SICOrdenCompraConstantes.PATRON_ORDENAR_POR_CODIGO_UNICO, SICOrdenCompraConstantes.LABEL_ORDENAR_POR_CODIGO_UNICO);
	
	private final String value;
	private final String label;
	
	private TiposSelectItemsOrdenCompra(String value, String label) {
		this.value = value;
		this.label = label;
	}
	
	/**
	 * Tipos de generacion de orden de compra
	 * @return
	 */
	public static List<TiposSelectItemsOrdenCompra> getTipoGeneracionOrdenCompra(){
		return Arrays.asList(new TiposSelectItemsOrdenCompra[]{TiposSelectItemsOrdenCompra.ORDEN_COMPRA,
															   TiposSelectItemsOrdenCompra.NOTA_PEDIDO});
	}
	
	/**
	 * Tipos de ordenamiento
	 * para articulos
	 * 
	 * @return
	 */
	public static List<TiposSelectItemsOrdenCompra> getTipoOrdenamientoArticulosOrdenCompra(){
		return Arrays.asList(new TiposSelectItemsOrdenCompra[] {TiposSelectItemsOrdenCompra.CODIGO_BARRAS_ARTICULO, 
																TiposSelectItemsOrdenCompra.DESCRIPCION_ARTICULO,
																TiposSelectItemsOrdenCompra.CODIGO_UNICO_ARTICULO});
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
}
