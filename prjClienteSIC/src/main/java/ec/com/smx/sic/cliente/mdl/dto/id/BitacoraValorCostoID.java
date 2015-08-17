package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class BitacoraValorCostoID implements Serializable {

	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOVALORCOSTOGESTION" , nullable = false)	
	private Long codigoValorCostoGestion;
	
	@Column(name = "VALORTIPOESTADO", nullable = false)	
	private String valorTipoEstado;
	
	@Column(name = "CODIGOTIPOESTADO", nullable = false)
	private Integer codigoTipoEstado;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoValorCostoGestion
	 */
	public Long getCodigoValorCostoGestion() {
		return codigoValorCostoGestion;
	}

	/**
	 * @param codigoValorCostoGestion the codigoValorCostoGestion to set
	 */
	public void setCodigoValorCostoGestion(Long codigoValorCostoGestion) {
		this.codigoValorCostoGestion = codigoValorCostoGestion;
	}

	/**
	 * @return the valorTipoEstado
	 */
	public String getValorTipoEstado() {
		return valorTipoEstado;
	}

	/**
	 * @param valorTipoEstado the valorTipoEstado to set
	 */
	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	/**
	 * @return the codigoTipoEstado
	 */
	public Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	/**
	 * @param codigoTipoEstado the codigoTipoEstado to set
	 */
	public void setCodigoTipoEstado(Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

}
