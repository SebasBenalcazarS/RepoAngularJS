package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@Embeddable
@SuppressWarnings("serial")
public class ArticuloClasificacionArchivoID implements Serializable{

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del Archivo del artículo
	 * 
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSARTCLAARC")
	@Column(name = "CODIGOARCHIVO", nullable = false)
	private Integer codigoArchivo;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoArchivo
	 */
	public Integer getCodigoArchivo() {
		return codigoArchivo;
	}

	/**
	 * @param codigoArchivo the codigoArchivo to set
	 */
	public void setCodigoArchivo(Integer codigoArchivo) {
		this.codigoArchivo = codigoArchivo;
	}
}
