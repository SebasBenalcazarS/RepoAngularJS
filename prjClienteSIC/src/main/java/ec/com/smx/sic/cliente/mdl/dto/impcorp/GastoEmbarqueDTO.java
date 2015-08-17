/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.GastoEmbarqueID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTGASEMB")
public class GastoEmbarqueDTO extends AuditoriaBaseDTO<GastoEmbarqueID>{
	@Column(name = "CODIGOTIPOCATTIP")
	private Long codigoTipoCatTip;
	
	@Column(name = "CODIGOTIPOCATVAL")
	private Long codigoTipoCatVal;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "NOMBRECORTO")
	private String nombreCorto;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipo;
	
	@OneToMany(mappedBy = "gastoEmbarque")
	private Collection<CondicionGastoEmbarqueDTO> condicionesGastoEmbarque;

	/**
	 * @return devuelve el valor de la propiedad codigoTipoCatTip
	 */
	public Long getCodigoTipoCatTip() {
		return codigoTipoCatTip;
	}

	/**
	 * @param codigoTipoCatTip establece el valor a la propiedad codigoTipoCatTip
	 */
	public void setCodigoTipoCatTip(Long codigoTipoCatTip) {
		this.codigoTipoCatTip = codigoTipoCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipoCatVal
	 */
	public Long getCodigoTipoCatVal() {
		return codigoTipoCatVal;
	}

	/**
	 * @param codigoTipoCatVal establece el valor a la propiedad codigoTipoCatVal
	 */
	public void setCodigoTipoCatVal(Long codigoTipoCatVal) {
		this.codigoTipoCatVal = codigoTipoCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre establece el valor a la propiedad nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return devuelve el valor de la propiedad nombreCorto
	 */
	public String getNombreCorto() {
		return nombreCorto;
	}

	/**
	 * @param nombreCorto establece el valor a la propiedad nombreCorto
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	/**
	 * @return devuelve el valor de la propiedad estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado establece el valor a la propiedad estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return devuelve el valor de la propiedad tipo
	 */
	public CatalogoValorImpDTO getTipo() {
		return tipo;
	}

	/**
	 * @param tipo establece el valor a la propiedad tipo
	 */
	public void setTipo(CatalogoValorImpDTO tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return devuelve el valor de la propiedad condicionesGastoEmbarque
	 */
	public Collection<CondicionGastoEmbarqueDTO> getCondicionesGastoEmbarque() {
		return condicionesGastoEmbarque;
	}

	/**
	 * @param condicionesGastoEmbarque establece el valor a la propiedad condicionesGastoEmbarque
	 */
	public void setCondicionesGastoEmbarque(
			Collection<CondicionGastoEmbarqueDTO> condicionesGastoEmbarque) {
		this.condicionesGastoEmbarque = condicionesGastoEmbarque;
	}
	
}
