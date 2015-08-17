package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;

/**
 * Resumen de los descuentos configurados por porveedor-clasificación
 * 
 * @author kruger
 */
@Entity
@Table(name="SCSADTDESPROCLA")
@SuppressWarnings("serial")
public class DescuentoProveedorClasificacionDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DescuentoProveedorClasificacionID id = new ec.com.smx.sic.cliente.mdl.dto.id.DescuentoProveedorClasificacionID();

	/**
	 * Observación para el descuento aplicado
	 * 
	 */
	private String observacion;

	/**
	 * Estado del registro, sus valores pueden ser: [1] activo [0] inactivo
	 * 
	 */
	@ComparatorTypeField
	private String estado;

	/**
	 * Porcentaje aplicado
	 * 
	 */
	private Double porcentajeDescuento;
	
	/**
	 * Código del proveedor
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;

	/**
	 * Código de clasificación, que se relaciona con la tabla de clasificaciones, referencia a los registros del nivel 3 en la tabla de
	 * Clasificaciones
	 */
	@Column(name = "CODIGOCLASIFICACION", nullable = false)	
	private String codigoClasificacion;

	/**
	 * Secuencial del tipo de descuento
	 */
	@Column(name = "SECUENCIALASITIPDES", nullable = false)
	private Integer secuencialAsignacionTipoDescuento;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO proveedorClasificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "SECUENCIALASITIPDES", referencedColumnName = "SECUENCIALASITIPDES", insertable = false, updatable = false)
	})
	private AsignacionTipoDescuentoDTO asignacionTipoDescuento;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DescuentoProveedorClasificacionID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DescuentoProveedorClasificacionID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>observacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>observacion</code>
	 */
	public String getObservacion() {
		return this.observacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>observacion</code>.
	 * 
	 * @param observacion1
	 *            El valor a establecer para la propiedad <code>observacion</code>.
	 */
	public void setObservacion(String observacion1) {
		this.observacion = observacion1;

		if (observacion != null && observacion.length() > 512) {
			observacion = observacion.substring(0, 512);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * 
	 * @param estado1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado1) {
		this.estado = estado1;

		if (estado != null && estado.length() > 1) {
			estado = estado.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>porcentajeDescuento</code>
	 * 
	 * @return Retorna valor de propiedad <code>porcentajeDescuento</code>
	 */
	public Double getPorcentajeDescuento() {
		return this.porcentajeDescuento;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>porcentajeDescuento</code>.
	 * 
	 * @param porcentajeDescuento1
	 *            El valor a establecer para la propiedad <code>porcentajeDescuento</code>.
	 */
	public void setPorcentajeDescuento(Double porcentajeDescuento1) {
		this.porcentajeDescuento = porcentajeDescuento1;

	}

	/**
	 * Retorna valor de propiedad <code>proveedorClasificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>proveedorClasificacion</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO getProveedorClasificacion() {
		return this.proveedorClasificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedorClasificacion</code>.
	 * 
	 * @param proveedorClasificacion1
	 *            El valor a establecer para la propiedad <code>proveedorClasificacion</code>.
	 */
	public void setProveedorClasificacion(ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO proveedorClasificacion1) {
		this.proveedorClasificacion = proveedorClasificacion1;
	}

	/**
	 * @return the codigoDescripcionDesCla
	 */
	public String getCodigoDescripcionDesCla() {
		return this.getCodigoClasificacion().concat(" ").concat(this.asignacionTipoDescuento.getTipoDescuento().getDescripcion());
	}

	public AsignacionTipoDescuentoDTO getAsignacionTipoDescuento() {
		return asignacionTipoDescuento;
	}

	public void setAsignacionTipoDescuento(AsignacionTipoDescuentoDTO asignacionTipoDescuento) {
		this.asignacionTipoDescuento = asignacionTipoDescuento;
	}
	
	/**
	 * Retorna valor de propiedad <code>codigoProveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoProveedor</code>
	 */
	public String getCodigoProveedor() {
		return this.codigoProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoProveedor</code>.
	 * 
	 * @param codigoProveedor1
	 *            El valor a establecer para la propiedad <code>codigoProveedor</code>.
	 */
	public void setCodigoProveedor(String codigoProveedor1) {
		this.codigoProveedor = codigoProveedor1;

		if (codigoProveedor != null && codigoProveedor.length() > 10) {
			codigoProveedor = codigoProveedor.substring(0, 10);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoClasificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoClasificacion</code>
	 */
	public String getCodigoClasificacion() {
		return this.codigoClasificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoClasificacion</code>.
	 * 
	 * @param codigoClasificacion1
	 *            El valor a establecer para la propiedad <code>codigoClasificacion</code>.
	 */
	public void setCodigoClasificacion(String codigoClasificacion1) {
		this.codigoClasificacion = codigoClasificacion1;

		if (codigoClasificacion != null && codigoClasificacion.length() > 10) {
			codigoClasificacion = codigoClasificacion.substring(0, 10);
		}

	}

	public Integer getSecuencialAsignacionTipoDescuento() {
		return secuencialAsignacionTipoDescuento;
	}

	public void setSecuencialAsignacionTipoDescuento(Integer secuencialAsignacionTipoDescuento) {
		this.secuencialAsignacionTipoDescuento = secuencialAsignacionTipoDescuento;
	}
}
