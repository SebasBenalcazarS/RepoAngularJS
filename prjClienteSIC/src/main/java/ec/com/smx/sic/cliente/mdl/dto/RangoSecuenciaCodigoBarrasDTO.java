/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.RangoSecuenciaCodigoBarrasID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTRANSECINTCODBAR")
public class RangoSecuenciaCodigoBarrasDTO extends SearchDTO{

	@EmbeddedId
	private RangoSecuenciaCodigoBarrasID id = new RangoSecuenciaCodigoBarrasID();
	@Deprecated
	private String valorTipoSecuencia;
	@Deprecated
	private Integer codigoTipoSecuencia;
	private Long valorMinimo;
	private Long valorMaximo;
	private Long valorActual;
	private Integer prefijoPOS;
	
	@OneToMany(mappedBy = "rangoSecuencia")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<SecuenciaCodigoBarrasDTO> secuencias;
	
	/**
	 * @return the id
	 */
	public RangoSecuenciaCodigoBarrasID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(RangoSecuenciaCodigoBarrasID id) {
		this.id = id;
	}
	/**
	 * @return the valorTipoSecuencia
	 */
	public String getValorTipoSecuencia() {
		return valorTipoSecuencia;
	}
	/**
	 * @param valorTipoSecuencia the valorTipoSecuencia to set
	 */
	public void setValorTipoSecuencia(String valorTipoSecuencia) {
		this.valorTipoSecuencia = valorTipoSecuencia;
	}
	/**
	 * @return the codigoTipoSecuencia
	 */
	public Integer getCodigoTipoSecuencia() {
		return codigoTipoSecuencia;
	}
	/**
	 * @param codigoTipoSecuencia the codigoTipoSecuencia to set
	 */
	public void setCodigoTipoSecuencia(Integer codigoTipoSecuencia) {
		this.codigoTipoSecuencia = codigoTipoSecuencia;
	}
	/**
	 * @return the valorMinimo
	 */
	public Long getValorMinimo() {
		return valorMinimo;
	}
	/**
	 * @param valorMinimo the valorMinimo to set
	 */
	public void setValorMinimo(Long valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	/**
	 * @return the valorMaximo
	 */
	public Long getValorMaximo() {
		return valorMaximo;
	}
	/**
	 * @param valorMaximo the valorMaximo to set
	 */
	public void setValorMaximo(Long valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	/**
	 * @return the valorActual
	 */
	public Long getValorActual() {
		return valorActual;
	}
	/**
	 * @param valorActual the valorActual to set
	 */
	public void setValorActual(Long valorActual) {
		this.valorActual = valorActual;
	}
	/**
	 * @return the prefijoPOS
	 */
	public Integer getPrefijoPOS() {
		return prefijoPOS;
	}
	/**
	 * @param prefijoPOS the prefijoPOS to set
	 */
	public void setPrefijoPOS(Integer prefijoPOS) {
		this.prefijoPOS = prefijoPOS;
	}
	/**
	 * @return the secuencias
	 */
	public Collection<SecuenciaCodigoBarrasDTO> getSecuencias() {
		return secuencias;
	}
	/**
	 * @param secuencias the secuencias to set
	 */
	public void setSecuencias(Collection<SecuenciaCodigoBarrasDTO> secuencias) {
		this.secuencias = secuencias;
	}
	
}