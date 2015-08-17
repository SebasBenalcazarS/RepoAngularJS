
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.DefinicionEstructuraLogisticaID;

/**
 * Contiene los archivos XML con las carateristicas de las secciones que existen en la estructura logistica
 *
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDEFESTLOG")
public class DefinicionEstructuraLogisticaDTO  extends AuditoriaBaseDTO{

	
	/**
	 * Clave primaria de la tabla DefinicionEstructuraLogistica
	 *
	 */
	@EmbeddedId
	private DefinicionEstructuraLogisticaID id;
	
	/**
	 * Contiene el archivo XML con las caracteristicas de las seccion
	 *
	 */
	private java.sql.Clob definicionXML ;

	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	private String estado ;

	/**
	 * Relacion con el catalogo valor saber el tipo de proceso:
	 * recepcion/despacho
	 * 
	 */

	/**
	 * Retorna valor de propiedad <code>definicionXML</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>definicionXML</code>
	 */
	public java.sql.Clob getDefinicionXML(){
		return this.definicionXML;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>definicionXML</code>.
	 * @param definicionXML1 
	 *		El valor a establecer para la propiedad <code>definicionXML</code>.
	 */
	public void setDefinicionXML( java.sql.Clob definicionXML1 ){
		this.definicionXML=definicionXML1;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the id
	 */
	public DefinicionEstructuraLogisticaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(DefinicionEstructuraLogisticaID id) {
		this.id = id;
	}

}