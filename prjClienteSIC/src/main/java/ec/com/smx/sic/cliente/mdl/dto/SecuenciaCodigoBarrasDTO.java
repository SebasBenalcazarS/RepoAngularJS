/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.SecuenciaCodigoBarrasID;

/**
 * @author guvidia
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTCODSECINT")
public class SecuenciaCodigoBarrasDTO extends SearchDTO{

	@EmbeddedId
	private SecuenciaCodigoBarrasID id = new SecuenciaCodigoBarrasID();
	private String valorTipoSecuencia;
	private Integer codigoTipoSecuencia;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "IDENTIFICADOR", referencedColumnName = "IDENTIFICADOR", insertable = false, updatable = false) })
	private RangoSecuenciaCodigoBarrasDTO rangoSecuencia;
	
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
	
	public SecuenciaCodigoBarrasID getId() {
		return id;
	}
	
	public void setId(SecuenciaCodigoBarrasID id) {
		this.id = id;
	}
	
	public RangoSecuenciaCodigoBarrasDTO getRangoSecuencia() {
		return rangoSecuencia;
	}
	
	public void setRangoSecuencia(RangoSecuenciaCodigoBarrasDTO rangoSecuencia) {
		this.rangoSecuencia = rangoSecuencia;
	}
	
}