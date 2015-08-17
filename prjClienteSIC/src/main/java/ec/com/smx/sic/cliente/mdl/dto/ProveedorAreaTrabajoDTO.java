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
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorAreaTrabajoID;
import ec.com.smx.sic.cliente.mdl.nopersistente.ProveedorAreaTrabajoTransient;

/**
 * @author rpalacios
 */
@Entity
@Table(name="SCPROTPROARETRA")
public class ProveedorAreaTrabajoDTO extends ProveedorAreaTrabajoTransient {

	private static final long serialVersionUID = 1L;
	/*
	 * id 
	 */
	@EmbeddedId
	private ProveedorAreaTrabajoID id = new ProveedorAreaTrabajoID();
	
	/*
	 * Codigo del proveedor
	 */
	@Column (name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	/*
	 * Codigo de area de trabajo al que puede pertenecer el proveedor
	 */
	@Column (name = "CODIGOAREATRABAJO", nullable = false)
	private Integer codigoAreaTrabajo;
	
	/*
	 * Identifica si el registro es el que se usara por defecto
	 * Posibles valores: 1 y 0
	 */
	@ComparatorTypeField
	@Column (name = "PREDETERMINADO")
	private String predeterminado;
	
	/*
	 * Estado del registro
	 * Posibles valores: 1 y 0
	 */
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ProveedorDTO proveedorDTO;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOAREATRABAJO", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
	private AreaTrabajoDTO areaTrabajoDTO;
	
	

//***************************************************************************************************************
	/**
	 * @return the id
	 */
	public ProveedorAreaTrabajoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ProveedorAreaTrabajoID id) {
		this.id = id;
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
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the predeterminado
	 */
	public String getPredeterminado() {
		return predeterminado;
	}

	/**
	 * @param predeterminado the predeterminado to set
	 */
	public void setPredeterminado(String predeterminado) {
		this.predeterminado = predeterminado;
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
	 * @return the proveedorDTO
	 */
	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	/**
	 * @param proveedorDTO the proveedorDTO to set
	 */
	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	/**
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}	
}