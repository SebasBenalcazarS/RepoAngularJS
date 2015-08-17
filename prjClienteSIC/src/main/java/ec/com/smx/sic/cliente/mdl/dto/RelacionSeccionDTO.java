package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.RelacionSeccionID;

/**
 * Contiene la relaci�n de secciones para la configuraci�n por correspondencia de secciones

 *
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTRELSEC")
public class RelacionSeccionDTO extends AuditoriaBaseDTO {

	/**
	 * Clave primaria de la tabla RelacionSeccion
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.RelacionSeccionID id = new ec.com.smx.sic.cliente.mdl.dto.id.RelacionSeccionID();
	
	public RelacionSeccionDTO() {
		
	}
	
	/**
	 * Indica el estado del registro: [1] activo, [0] inactivo  
	 *
	 */
	@ComparatorTypeField
	private String estado ;

	/**
	 * Obtiene la relacion principal del detalle seccion
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGODETALLESECCIONPADRE", insertable=false, updatable=false, referencedColumnName="CODIGODETALLESECCION")})
	private DetalleSeccionDTO detalleSeccionPadreDTO;

	/**
	 * Obtiene la relaci�n con el detalle secci�n
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGODETALLESECCION", insertable=false, updatable=false, referencedColumnName="CODIGODETALLESECCION")})
	private DetalleSeccionDTO detalleSeccionDTO;

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado(){
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * @param estado1 
	 *		El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado( String estado1 ){
		this.estado=estado1;
	}

	/**
	 * Retorna valor de propiedad <code>detalleSeccionPadreDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>detalleSeccionPadreDTO</code>
	 */
	public DetalleSeccionDTO getDetalleSeccionPadreDTO(){
		return this.detalleSeccionPadreDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>detalleSeccionPadreDTO</code>.
	 * @param detalleSeccionPadreDTO1 
	 *		El valor a establecer para la propiedad <code>detalleSeccionPadreDTO</code>.
	 */
	public void setDetalleSeccionPadreDTO( DetalleSeccionDTO detalleSeccionPadreDTO1 ){
		this.detalleSeccionPadreDTO=detalleSeccionPadreDTO1;
	}

	/**
	 * Retorna valor de propiedad <code>detalleSeccionDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>detalleSeccionDTO</code>
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO(){
		return this.detalleSeccionDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>detalleSeccionDTO</code>.
	 * @param detalleSeccionDTO1 
	 *		El valor a establecer para la propiedad <code>detalleSeccionDTO</code>.
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO1 ){
		this.detalleSeccionDTO=detalleSeccionDTO1;
	}

	/**
	 * @return the id
	 */
	public RelacionSeccionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(RelacionSeccionID id) {
		this.id = id;
	}

}
