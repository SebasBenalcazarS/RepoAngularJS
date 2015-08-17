package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArchivoDocumentoXmlDTO
 * 
 * @author fcollaguazo
 */
@Embeddable
@SuppressWarnings("serial")
public class ArchivoDocumentoXmlID implements Serializable{

	/**
	 * Codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Codigo de la retencion
	 * 
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFDISECARCDOCXML")
	@Column(name = "CODARCDOCXML", nullable = false)
	private Integer codigoArchivoDocumentoXml;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	public Integer getCodigoArchivoDocumentoXml() {
		return codigoArchivoDocumentoXml;
	}

	public void setCodigoArchivoDocumentoXml(Integer codigoArchivoDocumentoXml) {
		this.codigoArchivoDocumentoXml = codigoArchivoDocumentoXml;
	}
}
