package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@SuppressWarnings("serial")
@MappedSuperclass
public class EmbarqueFactorFacturaDocumentoAbstract <T extends BaseID> extends AuditoriaBaseDTO<T> {

	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUEFACTOR", referencedColumnName = "CODIGOEMBARQUEFACTOR", insertable = false, updatable = false)
	})
	private EmbarqueFactorDTO embarqueFactor;
	


	
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
	 * @return devuelve el valor de la propiedad embarqueFactor
	 */
	public EmbarqueFactorDTO getEmbarqueFactor() {
		return embarqueFactor;
	}

	/**
	 * @param embarqueFactor establece el valor a la propiedad embarqueFactor
	 */
	public void setEmbarqueFactor(EmbarqueFactorDTO embarqueFactor) {
		this.embarqueFactor = embarqueFactor;
	}


}
