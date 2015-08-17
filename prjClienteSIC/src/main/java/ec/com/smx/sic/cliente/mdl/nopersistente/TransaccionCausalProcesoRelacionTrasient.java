package ec.com.smx.sic.cliente.mdl.nopersistente;

import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
public class TransaccionCausalProcesoRelacionTrasient extends SimpleAuditDTO{
	@Id
	private Integer numRow;
	private String codigoCausalValorRelacionado;
	private Integer codigoCausalTipoRelacionado;
	private String codigoExternoRelacionado;
	private String nombreCausalRelacionado;
	private String codigoCausalValorPadre;
	private Integer codigoCausalTipoPadre;
	private String codigoExternoPadre;
	private String nombreCausalPadre;
	
	public String getCodigoCausalValorRelacionado() {
		return codigoCausalValorRelacionado;
	}
	public void setCodigoCausalValorRelacionado(String codigoCausalValorRelacionado) {
		this.codigoCausalValorRelacionado = codigoCausalValorRelacionado;
	}
	public Integer getCodigoCausalTipoRelacionado() {
		return codigoCausalTipoRelacionado;
	}
	public void setCodigoCausalTipoRelacionado(Integer codigoCausalTipoRelacionado) {
		this.codigoCausalTipoRelacionado = codigoCausalTipoRelacionado;
	}
	public String getCodigoExternoRelacionado() {
		return codigoExternoRelacionado;
	}
	public void setCodigoExternoRelacionado(String codigoExternoRelacionado) {
		this.codigoExternoRelacionado = codigoExternoRelacionado;
	}
	public String getNombreCausalRelacionado() {
		return nombreCausalRelacionado;
	}
	public void setNombreCausalRelacionado(String nombreCausalRelacionado) {
		this.nombreCausalRelacionado = nombreCausalRelacionado;
	}
	public String getCodigoCausalValorPadre() {
		return codigoCausalValorPadre;
	}
	public void setCodigoCausalValorPadre(String codigoCausalValorPadre) {
		this.codigoCausalValorPadre = codigoCausalValorPadre;
	}
	public Integer getCodigoCausalTipoPadre() {
		return codigoCausalTipoPadre;
	}
	public void setCodigoCausalTipoPadre(Integer codigoCausalTipoPadre) {
		this.codigoCausalTipoPadre = codigoCausalTipoPadre;
	}
	public String getCodigoExternoPadre() {
		return codigoExternoPadre;
	}
	public void setCodigoExternoPadre(String codigoExternoPadre) {
		this.codigoExternoPadre = codigoExternoPadre;
	}
	public String getNombreCausalPadre() {
		return nombreCausalPadre;
	}
	public void setNombreCausalPadre(String nombreCausalPadre) {
		this.nombreCausalPadre = nombreCausalPadre;
	}
	public Integer getNumRow() {
		return numRow;
	}
	public void setNumRow(Integer numRow) {
		this.numRow = numRow;
	}
	
	

	
}
