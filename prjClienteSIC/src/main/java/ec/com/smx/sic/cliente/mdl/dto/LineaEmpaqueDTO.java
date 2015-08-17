package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Tabla que representa a una linea de empaque o produccion
 * 
 * @author srodriguez
 */

@SuppressWarnings({ "serial"})
@Entity
@Table(name = "SBLOGTLINEMP")
public class LineaEmpaqueDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla Linea Empaque
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueID id = new ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueID();


	/**
	 * Especifica la descripci�n o nombre de la linea de empaque
	 */
	@Column(name = "DESCRIPCION")
	@ComparatorTypeField
	private java.lang.String descripcion;

	/**
	 * Especifica la descripci�n o nombre de la linea de empaque
	 */
	@Column(name = "DESCRIPCIONCORTA")
	@ComparatorTypeField
	private java.lang.String descripcionCorta;

	/**
	 * Especifica el modelo de la linea de empaque
	 */
	@Column(name = "MODELO")
	@ComparatorTypeField
	private java.lang.String modelo;

	/**
	 * Especifica el numero de serie de la linea de empaque
	 */
	@Column(name = "SERIE")
	@ComparatorTypeField
	private java.lang.String serie;
	
	/**
	 * Especifica el anio de fabricacion de de la linea de empaque
	 */
	@Column(name = "ANIOFABRICACION")
	@ComparatorTypeField
	private java.lang.Integer anioFabricacion;
	
	/**
	 * Especifica la fecha de la compra de de la linea de empaque
	 */
	@Column(name = "FECHACOMPRA")
	@ComparatorTypeField
	private java.util.Date fechaCompra;

	
	/**
	 * Especifica el c�dgo de referencia del negocio
	 */
	@Column(name = "CODIGOREFERENCIA")
	@ComparatorTypeField
	private java.lang.Integer codigoReferencia;
	
	/**
	 * Especifica el c�digo del Centro de Distribuci�n
	 */
	@Column(name = "CODIGOCDT")
	@ComparatorTypeField
	private java.lang.Integer codigoCDT;
	
	/**
	 * Especifica el c�dgo de la Bodega
	 */
	@Column(name = "CODIGOBODEGA")
	@ComparatorTypeField
	private java.lang.Integer codigoBOD;
	
	/**
	 * Especifica el c�dgo de la SubBodega
	 */
	@Column(name = "CODIGOSUBBODEGA")
	@ComparatorTypeField
	private java.lang.Integer codigoSBO;
	
	
	/**
	 * Especifica el modelo de la linea de empaque
	 */
	@Column(name = "UBICACION")
	@ComparatorTypeField
	private java.lang.Integer ubicacion;

	
	/**
	 * Especifica el estado [Activo e Inactivo][1,0] de de la linea de empaque
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private java.lang.String estado;

	
	
	/**
	 * Especifica la descripci�n o nombre de la linea de empaque
	 */
	@Column(name = "CODIGODETALLESECCION")
	@ComparatorTypeField
	private java.lang.Long codigoDetalleSeccion;
	
	/**
	 * Especifica la descripci�n o nombre de la linea de empaque
	 */
	@Column(name = "CODIGOTIPOLINEAEMPAQUE")
	@ComparatorTypeField
	private java.lang.Integer codigoTipoLineaEmpaque;
	
	/**
	 * Especifica la descripci�n o nombre de la linea de empaque
	 */
	@Column(name = "CODIGOVALORLINEAEMPAQUE")
	@ComparatorTypeField
	private java.lang.String codigoValorLineaEmpaque;
	
	
	/**
	 * Especifica la descripci�n o nombre de la linea de empaque
	 */
	@Column(name = "PAISFABRICACION")
	@ComparatorTypeField
	private java.lang.String codigoPaisFabricacion;
	

	/**
	 * Obtiene la relacion con el cat�logo de detalle secci�n
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGODETALLESECCION", insertable = false, updatable = false, referencedColumnName = "CODIGODETALLESECCION") })
	private DetalleSeccionDTO detalleSeccionDTO;

	/**
	 * Obtiene la relacion con el cat�logo del tipo de funcion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOTIPOLINEAEMPAQUE", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), @JoinColumn(name = "CODIGOVALORLINEAEMPAQUE", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALOR") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoLineaEmpacadoraDTO;

	
	/**
	 * Obtiene la relacion con el cat�logo de division politica
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "PAISFABRICACION", referencedColumnName = "CODIGODIVGEOPOL", insertable = false, updatable = false) })
	private DivisionGeoPoliticaDTO paisFabricacionDTO;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;

	/**
	 * 
	 */

	@OneToMany(mappedBy = "lineaEmpaqueDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<BitacoraMantenimientoLineaEmpaqueDTO> bitacorasMantenimientoLineaEmpaqueDTO;
	
	/**
	 * 
	 */

	@OneToMany(mappedBy = "lineaEmpaqueDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaEmpaqueArticuloDTO> lineaEmpaqueArticulosDTO;
	
	/**
	 * 
	 */

	@OneToMany(mappedBy = "lineaEmpaqueDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaEmpaqueFuncionarioDTO> lineaEmpaqueFuncionariosDTO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
	/*Getters y Setter de la Aplicaci�n*/

	/**
	 * M�todo Getter del campo id
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueID getId() {
		return id;
	}

	/**
	 * M�todo Setter the id
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueID id) {
		this.id = id;
	}

	/**
	 * M�todo Getter del campo descripcion
	 * @return the descripcion
	 */
	public java.lang.String getDescripcion() {
		return descripcion;
	}

	/**
	 * M�todo Setter the descripcion
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * M�todo Getter del campo descripcionCorta
	 * @return the descripcionCorta
	 */
	public java.lang.String getDescripcionCorta() {
		return descripcionCorta;
	}

	/**
	 * M�todo Setter the descripcionCorta
	 * @param descripcionCorta the descripcionCorta to set
	 */
	public void setDescripcionCorta(java.lang.String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	/**
	 * M�todo Getter del campo modelo
	 * @return the modelo
	 */
	public java.lang.String getModelo() {
		return modelo;
	}

	/**
	 * M�todo Setter the modelo
	 * @param modelo the modelo to set
	 */
	public void setModelo(java.lang.String modelo) {
		this.modelo = modelo;
	}

	/**
	 * M�todo Getter del campo serie
	 * @return the serie
	 */
	public java.lang.String getSerie() {
		return serie;
	}

	/**
	 * M�todo Setter the serie
	 * @param serie the serie to set
	 */
	public void setSerie(java.lang.String serie) {
		this.serie = serie;
	}

	/**
	 * M�todo Getter del campo anioFabricacion
	 * @return the anioFabricacion
	 */
	public java.lang.Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	/**
	 * M�todo Setter the anioFabricacion
	 * @param anioFabricacion the anioFabricacion to set
	 */
	public void setAnioFabricacion(java.lang.Integer anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	/**
	 * M�todo Getter del campo fechaCompra
	 * @return the fechaCompra
	 */
	public java.util.Date getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * M�todo Setter the fechaCompra
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(java.util.Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
	 * M�todo Getter del campo codigoReferencia
	 * @return the codigoReferencia
	 */
	public java.lang.Integer getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * M�todo Setter the codigoReferencia
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(java.lang.Integer codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * M�todo Getter del campo codigoCDT
	 * @return the codigoCDT
	 */
	public java.lang.Integer getCodigoCDT() {
		return codigoCDT;
	}

	/**
	 * M�todo Setter the codigoCDT
	 * @param codigoCDT the codigoCDT to set
	 */
	public void setCodigoCDT(java.lang.Integer codigoCDT) {
		this.codigoCDT = codigoCDT;
	}

	/**
	 * M�todo Getter del campo codigoBOD
	 * @return the codigoBOD
	 */
	public java.lang.Integer getCodigoBOD() {
		return codigoBOD;
	}

	/**
	 * M�todo Setter the codigoBOD
	 * @param codigoBOD the codigoBOD to set
	 */
	public void setCodigoBOD(java.lang.Integer codigoBOD) {
		this.codigoBOD = codigoBOD;
	}

	/**
	 * M�todo Getter del campo codigoSBO
	 * @return the codigoSBO
	 */
	public java.lang.Integer getCodigoSBO() {
		return codigoSBO;
	}

	/**
	 * M�todo Setter the codigoSBO
	 * @param codigoSBO the codigoSBO to set
	 */
	public void setCodigoSBO(java.lang.Integer codigoSBO) {
		this.codigoSBO = codigoSBO;
	}

	/**
	 * M�todo Getter del campo ubicacion
	 * @return the ubicacion
	 */
	public java.lang.Integer getUbicacion() {
		return ubicacion;
	}

	/**
	 * M�todo Setter the ubicacion
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(java.lang.Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * M�todo Getter del campo estado
	 * @return the estado
	 */
	public java.lang.String getEstado() {
		return estado;
	}

	/**
	 * M�todo Setter the estado
	 * @param estado the estado to set
	 */
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	/**
	 * M�todo Getter del campo codigoDetalleSeccion
	 * @return the codigoDetalleSeccion
	 */
	public java.lang.Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * M�todo Setter the codigoDetalleSeccion
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(java.lang.Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	/**
	 * M�todo Getter del campo codigoTipoLineaEmpaque
	 * @return the codigoTipoLineaEmpaque
	 */
	public java.lang.Integer getCodigoTipoLineaEmpaque() {
		return codigoTipoLineaEmpaque;
	}

	/**
	 * M�todo Setter the codigoTipoLineaEmpaque
	 * @param codigoTipoLineaEmpaque the codigoTipoLineaEmpaque to set
	 */
	public void setCodigoTipoLineaEmpaque(java.lang.Integer codigoTipoLineaEmpaque) {
		this.codigoTipoLineaEmpaque = codigoTipoLineaEmpaque;
	}

	/**
	 * M�todo Getter del campo codigoValorLineaEmpaque
	 * @return the codigoValorLineaEmpaque
	 */
	public java.lang.String getCodigoValorLineaEmpaque() {
		return codigoValorLineaEmpaque;
	}

	/**
	 * M�todo Setter the codigoValorLineaEmpaque
	 * @param codigoValorLineaEmpaque the codigoValorLineaEmpaque to set
	 */
	public void setCodigoValorLineaEmpaque(java.lang.String codigoValorLineaEmpaque) {
		this.codigoValorLineaEmpaque = codigoValorLineaEmpaque;
	}

	/**
	 * M�todo Getter del campo codigoPaisFabricacion
	 * @return the codigoPaisFabricacion
	 */
	public java.lang.String getCodigoPaisFabricacion() {
		return codigoPaisFabricacion;
	}

	/**
	 * M�todo Setter the codigoPaisFabricacion
	 * @param codigoPaisFabricacion the codigoPaisFabricacion to set
	 */
	public void setCodigoPaisFabricacion(java.lang.String codigoPaisFabricacion) {
		this.codigoPaisFabricacion = codigoPaisFabricacion;
	}

	/**
	 * M�todo Getter del campo detalleSeccionDTO
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * M�todo Setter the detalleSeccionDTO
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}

	/**
	 * M�todo Getter del campo tipoLineaEmpacadoraDTO
	 * @return the tipoLineaEmpacadoraDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoLineaEmpacadoraDTO() {
		return tipoLineaEmpacadoraDTO;
	}

	/**
	 * M�todo Setter the tipoLineaEmpacadoraDTO
	 * @param tipoLineaEmpacadoraDTO the tipoLineaEmpacadoraDTO to set
	 */
	public void setTipoLineaEmpacadoraDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoLineaEmpacadoraDTO) {
		this.tipoLineaEmpacadoraDTO = tipoLineaEmpacadoraDTO;
	}

	/**
	 * M�todo Getter del campo paisFabricacionDTO
	 * @return the paisFabricacionDTO
	 */
	public DivisionGeoPoliticaDTO getPaisFabricacionDTO() {
		return paisFabricacionDTO;
	}

	/**
	 * M�todo Setter the paisFabricacionDTO
	 * @param paisFabricacionDTO the paisFabricacionDTO to set
	 */
	public void setPaisFabricacionDTO(DivisionGeoPoliticaDTO paisFabricacionDTO) {
		this.paisFabricacionDTO = paisFabricacionDTO;
	}

//	/**
//	 * M�todo Getter del campo areaTrabajoCDT
//	 * @return the areaTrabajoCDT
//	 */
//	public AreaTrabajoDTO getAreaTrabajoCDT() {
//		return areaTrabajoCDT;
//	}
//
//	/**
//	 * M�todo Setter the areaTrabajoCDT
//	 * @param areaTrabajoCDT the areaTrabajoCDT to set
//	 */
//	public void setAreaTrabajoCDT(AreaTrabajoDTO areaTrabajoCDT) {
//		this.areaTrabajoCDT = areaTrabajoCDT;
//	}
//
//	/**
//	 * M�todo Getter del campo areaTrabajoBOD
//	 * @return the areaTrabajoBOD
//	 */
//	public AreaTrabajoDTO getAreaTrabajoBOD() {
//		return areaTrabajoBOD;
//	}
//
//	/**
//	 * M�todo Setter the areaTrabajoBOD
//	 * @param areaTrabajoBOD the areaTrabajoBOD to set
//	 */
//	public void setAreaTrabajoBOD(AreaTrabajoDTO areaTrabajoBOD) {
//		this.areaTrabajoBOD = areaTrabajoBOD;
//	}
//
//	/**
//	 * M�todo Getter del campo areaTrabajoSBO
//	 * @return the areaTrabajoSBO
//	 */
//	public AreaTrabajoDTO getAreaTrabajoSBO() {
//		return areaTrabajoSBO;
//	}
//
//	/**
//	 * M�todo Setter the areaTrabajoSBO
//	 * @param areaTrabajoSBO the areaTrabajoSBO to set
//	 */
//	public void setAreaTrabajoSBO(AreaTrabajoDTO areaTrabajoSBO) {
//		this.areaTrabajoSBO = areaTrabajoSBO;
//	}

	/**
	 * M�todo Getter del campo idUsuarioRegistro
	 * @return the idUsuarioRegistro
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * M�todo Setter the idUsuarioRegistro
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * M�todo Getter del campo fechaRegistro
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * M�todo Setter the fechaRegistro
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * M�todo Getter del campo idUsuarioModificacion
	 * @return the idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * M�todo Setter the idUsuarioModificacion
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * M�todo Getter del campo fechaModificacion
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * M�todo Setter the fechaModificacion
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * M�todo Getter del campo bitacorasMantenimientoLineaEmpaqueDTO
	 * @return the bitacorasMantenimientoLineaEmpaqueDTO
	 */
	public Collection<BitacoraMantenimientoLineaEmpaqueDTO> getBitacorasMantenimientoLineaEmpaqueDTO() {
		return bitacorasMantenimientoLineaEmpaqueDTO;
	}

	/**
	 * M�todo Setter the bitacorasMantenimientoLineaEmpaqueDTO
	 * @param bitacorasMantenimientoLineaEmpaqueDTO the bitacorasMantenimientoLineaEmpaqueDTO to set
	 */
	public void setBitacorasMantenimientoLineaEmpaqueDTO(Collection<BitacoraMantenimientoLineaEmpaqueDTO> bitacorasMantenimientoLineaEmpaqueDTO) {
		this.bitacorasMantenimientoLineaEmpaqueDTO = bitacorasMantenimientoLineaEmpaqueDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaEmpaqueDTO other = (LineaEmpaqueDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Collection<LineaEmpaqueArticuloDTO> getLineaEmpaqueArticulosDTO() {
		return lineaEmpaqueArticulosDTO;
	}

	public void setLineaEmpaqueArticulosDTO(Collection<LineaEmpaqueArticuloDTO> lineaEmpaqueArticulosDTO) {
		this.lineaEmpaqueArticulosDTO = lineaEmpaqueArticulosDTO;
	}

	public Collection<LineaEmpaqueFuncionarioDTO> getLineaEmpaqueFuncionariosDTO() {
		return lineaEmpaqueFuncionariosDTO;
	}

	public void setLineaEmpaqueFuncionariosDTO(Collection<LineaEmpaqueFuncionarioDTO> lineaEmpaqueFuncionariosDTO) {
		this.lineaEmpaqueFuncionariosDTO = lineaEmpaqueFuncionariosDTO;
	}
	
	

}
