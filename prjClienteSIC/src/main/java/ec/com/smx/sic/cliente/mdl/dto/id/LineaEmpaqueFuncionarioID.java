package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class LineaEmpaqueFuncionarioID implements Serializable{

	/**
	 * C�digo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Especifica el c�digo num�rico de la linea de empaque
	 * */
	@Column(name = "CODIGOLINEAEMPAQUE", nullable = false)
	private Integer codigoLineaEmpaque;

	/**
	 * Especifica el c�digo num�rico del art�culo
	 * */
	@Column(name = "CODIGOFUNCIONARIO", nullable = false)
	private String codigoFuncionario;

	/**
	 * M�todo Getter del campo codigoCompania
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * M�todo Setter the codigoCompania
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * M�todo Getter del campo codigoLineaEmpaque
	 * @return the codigoLineaEmpaque
	 */
	public Integer getCodigoLineaEmpaque() {
		return codigoLineaEmpaque;
	}

	/**
	 * M�todo Setter the codigoLineaEmpaque
	 * @param codigoLineaEmpaque the codigoLineaEmpaque to set
	 */
	public void setCodigoLineaEmpaque(Integer codigoLineaEmpaque) {
		this.codigoLineaEmpaque = codigoLineaEmpaque;
	}

	/**
	 * M�todo Getter del campo codigoFuncionario
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * M�todo Setter the codigoFuncionario
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoFuncionario == null) ? 0 : codigoFuncionario.hashCode());
		result = prime * result + ((codigoLineaEmpaque == null) ? 0 : codigoLineaEmpaque.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaEmpaqueFuncionarioID other = (LineaEmpaqueFuncionarioID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoFuncionario == null) {
			if (other.codigoFuncionario != null)
				return false;
		} else if (!codigoFuncionario.equals(other.codigoFuncionario))
			return false;
		if (codigoLineaEmpaque == null) {
			if (other.codigoLineaEmpaque != null)
				return false;
		} else if (!codigoLineaEmpaque.equals(other.codigoLineaEmpaque))
			return false;
		return true;
	}
}
