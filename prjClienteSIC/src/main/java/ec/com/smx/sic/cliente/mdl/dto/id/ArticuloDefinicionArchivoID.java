package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloDefinicionArchivo
 * 
 * @see ec.com.smx.sic.adm.dto.ArticuloDefinicionArchivo
 * 
 * @author kruger
 */
@Embeddable
@SuppressWarnings("serial")
public class ArticuloDefinicionArchivoID implements Serializable{

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del Archivo del artículo
	 * 
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSARTDEFARC")
	@Column(name = "CODIGOARCHIVO", nullable = false)
	private Integer codigoArchivo;

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

	/**
	 * Retorna valor de propiedad <code>codigoArchivo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoArchivo</code>
	 */
	public Integer getCodigoArchivo() {
		return this.codigoArchivo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArchivo</code>.
	 * 
	 * @param codigoArchivo1
	 *            El valor a establecer para la propiedad <code>codigoArchivo</code>.
	 */
	public void setCodigoArchivo(Integer codigoArchivo1) {
		this.codigoArchivo = codigoArchivo1;

	}

}
