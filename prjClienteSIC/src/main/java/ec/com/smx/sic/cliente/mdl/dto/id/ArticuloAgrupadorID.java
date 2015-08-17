package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloDuracionConservacion
 * 
 * @author fmunoz
 */
@Embeddable
@SuppressWarnings("serial")
public class ArticuloAgrupadorID extends ArticuloID {
	
	/**
	 * Codigo del Tipo de agrupador del Articulo
	 *
	 */
	@Column(name = "CODIGOTIPOAGRUPADOR", nullable = false)
	private Integer codigoTipoAgrupador ;		

	/**
	 * Valor del Tipo de agrupador del Articulo
	 *
	 */
	@Column(name = "VALORTIPOAGRUPADOR", nullable = false)
	private String valorTipoAgrupador ;

	/**
	 * @return the codigoTipoAgrupador
	 */
	public Integer getCodigoTipoAgrupador() {
		return codigoTipoAgrupador;
	}

	/**
	 * @param codigoTipoAgrupador the codigoTipoAgrupador to set
	 */
	public void setCodigoTipoAgrupador(Integer codigoTipoAgrupador) {
		this.codigoTipoAgrupador = codigoTipoAgrupador;
	}

	/**
	 * @return the valorTipoAgrupador
	 */
	public String getValorTipoAgrupador() {
		return valorTipoAgrupador;
	}

	/**
	 * @param valorTipoAgrupador the valorTipoAgrupador to set
	 */
	public void setValorTipoAgrupador(String valorTipoAgrupador) {
		this.valorTipoAgrupador = valorTipoAgrupador;
	}
	
}
