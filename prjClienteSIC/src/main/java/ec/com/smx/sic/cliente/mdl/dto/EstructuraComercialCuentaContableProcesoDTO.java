package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.EstructuraComercialCuentaContableProcesoID;

/**
 * Permite relacionar la cuenta contables a cualquien nivel de la estructura comercial o articulo a travez del proceso	
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTESTCOMCUECONPRO")
public class EstructuraComercialCuentaContableProcesoDTO extends SimpleAuditDTO{

	@EmbeddedId
	private EstructuraComercialCuentaContableProcesoID id = new EstructuraComercialCuentaContableProcesoID();
	
	@ComparatorTypeField
	private String codigoEstructuraComercial;

	@ComparatorTypeField
	private String codigoSubClasificacion;
	
	@ComparatorTypeField
	private String codigoArticulo;
	
	private Long codigoProceso;
	
	@ComparatorTypeField
	private String cuentaContable;
	
	@ComparatorTypeField
	private String estado;
	
	@ComparatorTypeField
	private String idUsuarioRegistro;
	
	private Date fechaRegistro;
	
	@ComparatorTypeField
	private String idUsuarioModificacion;
	
	private Date fechaModificacion;

	public EstructuraComercialCuentaContableProcesoID getId() {
		return id;
	}

	public void setId(EstructuraComercialCuentaContableProcesoID id) {
		this.id = id;
	}

	public String getCodigoEstructuraComercial() {
		return codigoEstructuraComercial;
	}

	public void setCodigoEstructuraComercial(String codigoEstructuraComercial) {
		this.codigoEstructuraComercial = codigoEstructuraComercial;
	}

	public String getCodigoSubClasificacion() {
		return codigoSubClasificacion;
	}

	public void setCodigoSubClasificacion(String codigoSubClasificacion) {
		this.codigoSubClasificacion = codigoSubClasificacion;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Long getCodigoProceso() {
		return codigoProceso;
	}

	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}
