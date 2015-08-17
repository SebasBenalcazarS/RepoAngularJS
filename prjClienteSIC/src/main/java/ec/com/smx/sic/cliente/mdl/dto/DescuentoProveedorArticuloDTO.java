package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;

/**
 * Resumen de los descuentos configurados por proveedor-articulo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTDESARTPRO")
public class DescuentoProveedorArticuloDTO extends AuditoriaBaseDTO {

	public static final String COSTO_NETO_PARCIAL = "cnp";
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DescuentoProveedorArticuloID id = new ec.com.smx.sic.cliente.mdl.dto.id.DescuentoProveedorArticuloID();

	/**
	 * Observacion para el descuento aplicado
	 * 
	 */
	private String observacion;
	/**
	 * Estado del registro
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Porcentaje aplicado
	 * 
	 */
	private Double porcentajeDescuento;
	
	
	private Integer codigoEquivalenciaDescuento;
	
	/**
	 * Codigo del proveedor
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;

	/**
	 * Codigo del articulo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	
	@Column(name = "SECUENCIALASITIPDES", nullable = false)
	private Integer secuencialAsignacionTipoDescuento;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO articuloProveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "SECUENCIALASITIPDES", referencedColumnName = "SECUENCIALASITIPDES", insertable = false, updatable = false)
	})
	private AsignacionTipoDescuentoDTO asignacionTipoDescuento;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOEQUIVALENCIADESCUENTO", insertable=false, updatable=false, referencedColumnName="CODIGOEQUIVALENCIA")})
	private EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuento;
	
//	@ManyToOne(fetch = LAZY)
//	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
//		@JoinColumn(name = "CODIGOTIPODESCUENTO", referencedColumnName = "CODIGOTIPODESCUENTO", insertable = false, updatable = false)})
	@Transient
	private TipoDescuentoDTO npTipoDescuento;
	
	@Transient
	private String proveedorTipoDescuento ; //variable usada en Historial de Cambios

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DescuentoProveedorArticuloID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DescuentoProveedorArticuloID id1) {
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
	 * Retorna valor de propiedad <code>articuloProveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>articuloProveedor</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO getArticuloProveedor() {
		return this.articuloProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articuloProveedor</code>.
	 * 
	 * @param articuloProveedor1
	 *            El valor a establecer para la propiedad <code>articuloProveedor</code>.
	 */
	public void setArticuloProveedor(ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO articuloProveedor1) {
		this.articuloProveedor = articuloProveedor1;
	}

	/**
	 * @return the tipoDescuento
	 */
	public TipoDescuentoDTO getNPTipoDescuento() {
		return npTipoDescuento;
	}

	/**
	 * @param tipoDescuento the tipoDescuento to set
	 */
	public void setNPTipoDescuento(TipoDescuentoDTO npTipoDescuento) {
		this.npTipoDescuento = npTipoDescuento;
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


	public Integer getCodigoEquivalenciaDescuento() {
		return codigoEquivalenciaDescuento;
	}

	public void setCodigoEquivalenciaDescuento(Integer codigoEquivalenciaDescuento) {
		this.codigoEquivalenciaDescuento = codigoEquivalenciaDescuento;
	}

	/**
	 * @return the equivalenciaPorcentajeDescuento
	 */
	public EquivalenciaPorcentajeDescuentoDTO getEquivalenciaPorcentajeDescuento() {
		return equivalenciaPorcentajeDescuento;
	}

	/**
	 * @param equivalenciaPorcentajeDescuento the equivalenciaPorcentajeDescuento to set
	 */
	public void setEquivalenciaPorcentajeDescuento(EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuento) {
		this.equivalenciaPorcentajeDescuento = equivalenciaPorcentajeDescuento;
	}
	
	public Boolean getTieneEquivalenciaPorcentajeDescuento(){
		return isLoaded(equivalenciaPorcentajeDescuento) && equivalenciaPorcentajeDescuento != null;
	}

	public String getProveedorTipoDescuento() {
		proveedorTipoDescuento = this.articuloProveedor.getVistaProveedor().getNombreProveedor().concat("-").concat(this.asignacionTipoDescuento.getTipoDescuento().getDescripcion())
				.concat(" - valor(%): ").concat(this.getPorcentajeDescuento().toString());
		return proveedorTipoDescuento;
	}

	public void setProveedorTipoDescuento(String proveedorTipoDescuento) {
		this.proveedorTipoDescuento = this.articuloProveedor.getVistaProveedor().getNombreProveedor().concat("-").concat(this.asignacionTipoDescuento.getTipoDescuento().getDescripcion())
				.concat(" - valor(%): ").concat(this.getPorcentajeDescuento().toString());
	}

	/**
	 * @return the secuencialAsignacionTipoDescuento
	 */
	public Integer getSecuencialAsignacionTipoDescuento() {
		return secuencialAsignacionTipoDescuento;
	}

	/**
	 * @param secuencialAsignacionTipoDescuento the secuencialAsignacionTipoDescuento to set
	 */
	public void setSecuencialAsignacionTipoDescuento(Integer secuencialAsignacionTipoDescuento) {
		this.secuencialAsignacionTipoDescuento = secuencialAsignacionTipoDescuento;
	}

	/**
	 * @return the asignacionTipoDescuento
	 */
	public AsignacionTipoDescuentoDTO getAsignacionTipoDescuento() {
		return asignacionTipoDescuento;
	}

	/**
	 * @param asignacionTipoDescuento the asignacionTipoDescuento to set
	 */
	public void setAsignacionTipoDescuento(AsignacionTipoDescuentoDTO asignacionTipoDescuento) {
		this.asignacionTipoDescuento = asignacionTipoDescuento;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
		
}
