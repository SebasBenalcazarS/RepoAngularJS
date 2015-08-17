/*
 * Creado el 16/06/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.sispe.MotivoDescuentoID;

/**
 * @author walvarez
 * @author osaransig
 * 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.MotivoDescuentoDTO")
@Table(name = "SCSPETMOTDES")
public class MotivoDescuentoDTO extends AuditoriaBaseDTO<MotivoDescuentoID> {

	private String descripcionMotivoDescuento;
	private String estadoMotivoDescuento;



	public MotivoDescuentoDTO() {
		MotivoDescuentoID motivoDescuentoID = new MotivoDescuentoID();
		this.setId(motivoDescuentoID);
	}

	
	
	
	public MotivoDescuentoDTO(Boolean valor) {
		this.id = new MotivoDescuentoID(valor);
	}
	
	/**
	 * @return Devuelve descripcionMotivoDescuento.
	 */
	public String getDescripcionMotivoDescuento() {
		return descripcionMotivoDescuento;
	}

	/**
	 * @param descripcionMotivoDescuento
	 *            El descripcionMotivoDescuento a establecer.
	 */
	public void setDescripcionMotivoDescuento(String descripcionMotivoDescuento) {
		this.descripcionMotivoDescuento = descripcionMotivoDescuento;
	}

	/**
	 * @return Devuelve estadoMotivoDescuento.
	 */
	public String getEstadoMotivoDescuento() {
		return estadoMotivoDescuento;
	}

	/**
	 * @param estadoMotivoDescuento
	 *            El estadoMotivoDescuento a establecer.
	 */
	public void setEstadoMotivoDescuento(String estadoMotivoDescuento) {
		this.estadoMotivoDescuento = estadoMotivoDescuento;
	}

	/**
	 * @return Devuelve id.
	 */
	public MotivoDescuentoID getId() {
		return id;
	}

	/**
	 * @param id
	 *            El id a establecer.
	 */
	public void setId(MotivoDescuentoID id) {
		this.id = id;
	}
}
