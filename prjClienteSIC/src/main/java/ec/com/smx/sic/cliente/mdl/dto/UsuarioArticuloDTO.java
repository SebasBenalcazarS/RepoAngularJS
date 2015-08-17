package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.mdl.dto.id.UsuarioArticuloID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTUSUART")
public class UsuarioArticuloDTO extends AuditoriaBaseDTO {

	/**
	 * id de usuario articulo
	 */
	@EmbeddedId
	private UsuarioArticuloID id = new UsuarioArticuloID();
	
	/**
	 * codigo usuario articulo
	 */
	@Column
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSECUSUART")
	private java.lang.Long codigoUsuarioArticulo ;
	
	/**
	 * codigo del proceso
	 */
	@Column
	private java.lang.Long codigoProceso ;
	
	/**
	 * estado 
	 */
	@Column
	@ComparatorTypeField
	private String estado ;

	
	public UsuarioArticuloID getId() {
		return id;
	}

	public void setId(UsuarioArticuloID id) {
		this.id = id;
	}

	public java.lang.Long getCodigoUsuarioArticulo() {
		return codigoUsuarioArticulo;
	}

	public void setCodigoUsuarioArticulo(java.lang.Long codigoUsuarioArticulo) {
		this.codigoUsuarioArticulo = codigoUsuarioArticulo;
	}

	public java.lang.Long getCodigoProceso() {
		return codigoProceso;
	}

	public void setCodigoProceso(java.lang.Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
