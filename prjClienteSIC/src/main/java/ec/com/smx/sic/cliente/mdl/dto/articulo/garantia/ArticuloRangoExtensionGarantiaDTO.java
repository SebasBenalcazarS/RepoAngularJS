/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.articulo.garantia;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.articulo.ArticuloRangoExtensionGarantiaID;

/**
 * Objeto que representa los rangos de costos para las garantias extendidas de los productos
 * @author eharo
 *
 */

@Entity
@Table (name = "SCSMETRANEXTGAR")
@SuppressWarnings("serial")
public class ArticuloRangoExtensionGarantiaDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ArticuloRangoExtensionGarantiaID id = new ArticuloRangoExtensionGarantiaID();
	
	/**
	 * Valor desde el caul se considera el precio
	 */
	@Column(name = "RANGOINICIAL", nullable = false)
	private Double rangoInicial;
	
	/**
	 * Valor hasta el caul se considera el precio
	 */
	@Column(name = "RANGOFINAL", nullable = false)
	private Double rangoFinal;
	
	/**
	 * Si el costo se calcula desde un porcentaje del precio
	 */
	@Column(name = "PORCENTAJE", nullable = false)
	private Integer porcentaje;
	
	/**
	 * Si el costo es fijo para los productos
	 */
	@Column(name = "VALOR", nullable = false)
	private Double valor ;
	
	/**
	 * Valor que tendrá para un periodo de tiempo
	 */
	@Column(name = "TIEMPO", nullable = false)
	private Integer tiempo ;	
	
	/**
	 * Monto minimo que puede tener una Garantia extendida
	 */
	@Column(name = "VALORMINIMO", nullable = false)
	private Double valorMinimo;
	
	/**
	 * Estado del registro
	 */
	@Column(name = "ESTADO", nullable = false)
	private String estado;

	/**
	 * @return the id
	 */
	public ArticuloRangoExtensionGarantiaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloRangoExtensionGarantiaID id) {
		this.id = id;
	}

	/**
	 * @return the rangoInicial
	 */
	public Double getRangoInicial() {
		return rangoInicial;
	}

	/**
	 * @param rangoInicial the rangoInicial to set
	 */
	public void setRangoInicial(Double rangoInicial) {
		this.rangoInicial = rangoInicial;
	}

	/**
	 * @return the rangoFinal
	 */
	public Double getRangoFinal() {
		return rangoFinal;
	}

	/**
	 * @param rangoFinal the rangoFinal to set
	 */
	public void setRangoFinal(Double rangoFinal) {
		this.rangoFinal = rangoFinal;
	}

	/**
	 * @return the porcentaje
	 */
	public Integer getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the tiempo
	 */
	public Integer getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * @return the valorMinimo
	 */
	public Double getValorMinimo() {
		return valorMinimo;
	}

	/**
	 * @param valorMinimo the valorMinimo to set
	 */
	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
