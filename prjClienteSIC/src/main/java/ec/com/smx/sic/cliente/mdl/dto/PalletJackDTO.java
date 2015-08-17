/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.PalletJackID;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTPALLETJACK")
public class PalletJackDTO extends AuditoriaBaseDTO{
	/**
	 * Clave primaria de la tabla PalletJack
	 *
	 */
	@EmbeddedId
	PalletJackID id = new PalletJackID();
	
	/**
	 * Descripcion del pallet jack
	 */
	@Column(name = "DESCRIPCION")
	private String descripcion ;
	
	/**
	 * Codigo de referencia del pallet jack
	 */
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia ;
	
	/**
	 * Valor del tipo de pallet
	 */
	@Column(name = "VALORTIPOPALLET")
	private String valorTipoPallet ;
	
	/**
	 * Valor del tipo de pallet
	 */
	@Column(name = "CODIGOTIPOPALLET")
	private Integer codigoTipoPallet ;
	
	/**
	 * Estado del registro
	 */
	@Column(name = "ESTADO")
	private String estado ;
	
	@Transient
	private Boolean seleccionado = Boolean.FALSE;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOPALLET", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOPALLET", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoPalletDTO;

	/**
	 * 
	 * SETTERS & GETTERS
	 * 
	 */
	
	/**
	 * @return the id
	 */
	public PalletJackID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PalletJackID id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the tipoPalletValor
	 */
	public String getValorTipoPallet() {
		return valorTipoPallet;
	}

	/**
	 * @param tipoPalletValor the tipoPalletValor to set
	 */
	public void setValorTipoPallet(String valorTipoPallet) {
		this.valorTipoPallet = valorTipoPallet;
	}

	/**
	 * @return the codigoTipoPallet
	 */
	public Integer getCodigoTipoPallet() {
		return codigoTipoPallet;
	}

	/**
	 * @param codigoTipoPallet the codigoTipoPallet to set
	 */
	public void setCodigoTipoPallet(Integer codigoTipoPallet) {
		this.codigoTipoPallet = codigoTipoPallet;
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

	/**
	 * @return the tipoPallet
	 */
	public CatalogoValorDTO getTipoPalletDTO() {
		return tipoPalletDTO;
	}

	/**
	 * @param tipoPallet the tipoPallet to set
	 */
	public void setTipoPalletDTO(CatalogoValorDTO tipoPallet) {
		this.tipoPalletDTO = tipoPallet;
	}

	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	
}
