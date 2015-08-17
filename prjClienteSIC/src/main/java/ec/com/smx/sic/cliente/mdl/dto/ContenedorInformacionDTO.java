/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ContenedorInformacionID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCADMTCONINF")
public class ContenedorInformacionDTO extends SimpleAuditDTO{
	@EmbeddedId
	private ContenedorInformacionID id = new ContenedorInformacionID();
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "TARA")
	private BigDecimal tara;
	
	@Column(name = "PESOCARGAUTIL")
	private BigDecimal pesoCargaUtil;
	
	@Column(name = "CAPACIDAD")
	private BigDecimal capacidad;
	
	@Column(name = "LONGITUD")
	private BigDecimal longitud;

	@Column(name = "ANCHO")
	private BigDecimal ancho;
	
	@Column(name = "ALTO")
	private BigDecimal alto;

	/**
	 * @return the id
	 */
	public ContenedorInformacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ContenedorInformacionID id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tara
	 */
	public BigDecimal getTara() {
		return tara;
	}

	/**
	 * @param tara the tara to set
	 */
	public void setTara(BigDecimal tara) {
		this.tara = tara;
	}

	/**
	 * @return the pesoCargaUtil
	 */
	public BigDecimal getPesoCargaUtil() {
		return pesoCargaUtil;
	}

	/**
	 * @param pesoCargaUtil the pesoCargaUtil to set
	 */
	public void setPesoCargaUtil(BigDecimal pesoCargaUtil) {
		this.pesoCargaUtil = pesoCargaUtil;
	}

	/**
	 * @return the capacidad
	 */
	public BigDecimal getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(BigDecimal capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * @return the longitud
	 */
	public BigDecimal getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the ancho
	 */
	public BigDecimal getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(BigDecimal ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the alto
	 */
	public BigDecimal getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(BigDecimal alto) {
		this.alto = alto;
	}
	
}
