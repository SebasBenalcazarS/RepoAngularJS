
package ec.com.smx.sic.cliente.common.bodega;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;


/**
 * @author dalmeida
 *
 */
public enum EnumDiferenciasRecepcion {
	
	CANTIDAD_EXCESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.novedad.catalogo.valor.cantidad.justificada.excedente")),
	CANTIDAD_FALTANTE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.novedad.catalogo.valor.cantidad.justificada.faltante")),
	POSITIVO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.novedad.cantidad.excedente")),
	NEGATIVO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.novedad.cantidad.faltante")),
	
	MENSAJE_CANTIDAD_EXCESO(SICBodegaMessajes.getInstancia().getString("recepcion.etiqueta.diferencias.novedades.oficina.cantidad.exceso")), 
	MENSAJE_CANTIDAD_JUSTIFICADA_EXCEDIDA(SICBodegaMessajes.getInstancia().getString("recepcion.etiqueta.diferencias.novedades.oficina.cantidad.justificada.excedida")) 
	;
	
	private String valor;
	
	private EnumDiferenciasRecepcion(String valor){
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

}
