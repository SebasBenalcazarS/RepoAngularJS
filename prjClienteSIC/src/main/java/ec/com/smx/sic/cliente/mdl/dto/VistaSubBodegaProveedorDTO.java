/** ec.com.smx.sic.cliente.mdl.dto
 * VistaSubBodegaProveedorDTO.java
 * @author srodriguez
 * 9/3/2015
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaSubBodegaProveedorID;

/**
 * @author srodriguez
 *
 */
@Entity
@Table(name="SCCEMVSUBBODPRO")
public class VistaSubBodegaProveedorDTO {
	
	/** Variable del tipo VistaSubBodegaProveedorID VistaSubBodegaProveedorDTO.java
	 * @author srodriguez
	 * 9/3/2015
	 */
	@EmbeddedId
	private VistaSubBodegaProveedorID id;
	
	/** Variable del tipo String VistaSubBodegaProveedorDTO.java
	 * @author srodriguez
	 * 9/3/2015
	 */
	private String descripcionBodega;
	
	/** Variable del tipo String VistaSubBodegaProveedorDTO.java
	 * @author srodriguez
	 * 9/3/2015
	 */
	private String valorTipoAreaTrabajo;

	/** Metodo que retorna id del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @return VistaSubBodegaProveedorID id 
	 */
	public VistaSubBodegaProveedorID getId() {
		return id;
	}

	/** Metodo que asigna el valor id en id del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @param id
	 */
	
	public void setId(VistaSubBodegaProveedorID id) {
		this.id = id;
	}

	/** Metodo que retorna descripcionBodega del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @return String descripcionBodega 
	 */
	public String getDescripcionBodega() {
		return descripcionBodega;
	}

	/** Metodo que asigna el valor descripcionBodega en descripcionBodega del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @param descripcionBodega
	 */
	
	public void setDescripcionBodega(String descripcionBodega) {
		this.descripcionBodega = descripcionBodega;
	}

	/** Metodo que retorna valorTipoAreaTrabajo del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @return String valorTipoAreaTrabajo 
	 */
	public String getValorTipoAreaTrabajo() {
		return valorTipoAreaTrabajo;
	}

	/** Metodo que asigna el valor valorTipoAreaTrabajo en valorTipoAreaTrabajo del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @param valorTipoAreaTrabajo
	 */
	
	public void setValorTipoAreaTrabajo(String valorTipoAreaTrabajo) {
		this.valorTipoAreaTrabajo = valorTipoAreaTrabajo;
	}

	
	
}
