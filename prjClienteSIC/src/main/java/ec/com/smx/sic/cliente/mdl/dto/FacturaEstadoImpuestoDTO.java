
package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.FacturaEstadoImpuestoID;


/**
 * Almacena todas las tareas de la estructura logistica
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITFACESTIMP")
public class FacturaEstadoImpuestoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.FacturaEstadoImpuestoID id = new ec.com.smx.sic.cliente.mdl.dto.id.FacturaEstadoImpuestoID();

	/**
	 * Total del impuesto
	 * 
	 */
	@Column(name = "TOTALIMPUESTO")
    private BigDecimal totalImpuesto;
	
	/**
	 * Total del impuesto proveedor
	 * 
	 */
	@Column(name = "TOTALIMPUESTOPROVEEDOR")
    private BigDecimal totalImpuestoProveedor;
	
	/**
	 * Tarifa del impuesto, Campo no persistente
	 * 
	 * 
	 */
	@Transient
	@Column(name = "TARIFAIMPUESTO")
    private BigDecimal tarifaImpuesto;
	
	/**
	 * Estado del registro
	 */
	@Column
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;
	
	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	private java.sql.Timestamp fechaRegistro;
	
	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Column(name="FECHAACTUALIZACION")
	private java.sql.Timestamp fechaModificacion;
	
	/**
	 * Especifica el Valor total del impuesto
	 */
	@Column(name = "TOTALSUJETOIMPUESTO")
    private BigDecimal totalSujetoImpuesto;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOTIPOIMPUESTO", referencedColumnName = "CODIGOTIPOIMPUESTO", insertable = false, updatable = false)
    })
    private TipoImpuestoDTO tipoImpuesto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOFACTURAESTADO", referencedColumnName = "CODIGOFACTURAESTADO", insertable = false, updatable = false)
    })
    private FacturaEstadoDTO facturaEstado;
	
	@OneToMany(mappedBy = "facturaEstadoImpuestoDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<FacturaDesgloseImpuestoDTO> facturaDesgloseImpuestoCol;
	
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
	public FacturaEstadoImpuestoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(FacturaEstadoImpuestoID id) {
		this.id = id;
	}

	/**
	 * @return the totalImpuesto
	 */
	public BigDecimal getTotalImpuesto() {
		return totalImpuesto;
	}

	/**
	 * @param totalImpuesto the totalImpuesto to set
	 */
	public void setTotalImpuesto(BigDecimal totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}

	/**
	 * @return the tarifaImpuesto
	 */
	public BigDecimal getTarifaImpuesto() {
		return tarifaImpuesto;
	}

	/**
	 * @param tarifaImpuesto the tarifaImpuesto to set
	 */
	public void setTarifaImpuesto(BigDecimal tarifaImpuesto) {
		this.tarifaImpuesto = tarifaImpuesto;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public TipoImpuestoDTO getTipoImpuesto() {
		return tipoImpuesto;
	}

	public void setTipoImpuesto(TipoImpuestoDTO tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}

	/**
	 * @return the facturaEstado
	 */
	public FacturaEstadoDTO getFacturaEstado() {
		return facturaEstado;
	}

	/**
	 * @param facturaEstado the facturaEstado to set
	 */
	public void setFacturaEstado(FacturaEstadoDTO facturaEstado) {
		this.facturaEstado = facturaEstado;
	}

	public BigDecimal getTotalImpuestoProveedor() {
		return totalImpuestoProveedor;
	}

	public void setTotalImpuestoProveedor(BigDecimal totalImpuestoProveedor) {
		this.totalImpuestoProveedor = totalImpuestoProveedor;
	}

	/**
	 * @return the totalSujetoImpuesto
	 */
	public BigDecimal getTotalSujetoImpuesto() {
		return totalSujetoImpuesto;
	}

	/**
	 * @param totalSujetoImpuesto the totalSujetoImpuesto to set
	 */
	public void setTotalSujetoImpuesto(BigDecimal totalSujetoImpuesto) {
		this.totalSujetoImpuesto = totalSujetoImpuesto;
	}

	public Collection<FacturaDesgloseImpuestoDTO> getFacturaDesgloseImpuestoCol() {
		return facturaDesgloseImpuestoCol;
	}

	public void setFacturaDesgloseImpuestoCol(Collection<FacturaDesgloseImpuestoDTO> facturaDesgloseImpuestoCol) {
		this.facturaDesgloseImpuestoCol = facturaDesgloseImpuestoCol;
	}

}