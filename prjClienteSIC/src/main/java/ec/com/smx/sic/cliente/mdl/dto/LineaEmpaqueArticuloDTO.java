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
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueArticuloID;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase
 * LineaEmpaqueDTO
 * 
 * @see ec.com.smx.corpv2.dto.LineaEmpaqueArticuloDTO
 * 
 * @author srodriguez
 */

@SuppressWarnings({ "serial"})
@Entity
@Table(name = "SBLOGTLINEMPART")
public class LineaEmpaqueArticuloDTO extends SimpleAuditDTO {
	/**
	 * Clave primaria de la tabla LineaEmpaqueArticuloDTO
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueArticuloID id = new ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueArticuloID();

	/**
	 * Especifica el porcentaje de merma por cada art�culo
	 */
	@Column(name = "PORCENTAJEMERMA")
	@ComparatorTypeField
	private java.lang.Double porcentajeMerma;

	/**
	 * Especifica el numero de personas necesarias
	 */
	@Column(name = "PERSONASNECESARIAS")
	@ComparatorTypeField
	private java.lang.Integer personasNecesarias;

	/**
	 * Especifica el numero de personas maximas
	 */
	@Column(name = "PERSONASMAXIMAS")
	@ComparatorTypeField
	private java.lang.Integer personasMaximas;

	/**
	 * Especifica el codigo del catalogo
	 */
	@Column(name = "CODIGOTIPOTIEMPOPRODUCCION")
	@ComparatorTypeField
	private java.lang.Integer codigoTipoTiempoProduccion;

	/**
	 * Especifica el codigo del catalogo
	 */
	@Column(name = "CODIGOVALORTIEMPOPRODUCCION")
	@ComparatorTypeField
	private java.lang.String codigoValorTiempoProduccion;

	/**
	 * Especifica el numero de personas maximas
	 */
	@Column(name = "TIEMPOPRODUCCION")
	@ComparatorTypeField
	private java.lang.Double tiempoProduccion;
	
	/**
	 * Especifica el numero de personas maximas
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private java.lang.String estado;

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
	 * Obtiene la relacion con el cat�logo del tipo de funcion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOTIPOTIEMPOPRODUCCION", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), @JoinColumn(name = "CODIGOVALORTIEMPOPRODUCCION", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALOR") })
	private CatalogoValorDTO tipoTiempoDTO;

	/**
	 * Obtiene la relacion con el cat�logo de la linea de empaque
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOLINEAEMPAQUE", insertable = false, updatable = false, referencedColumnName = "CODIGOLINEAEMPAQUE") })
	private LineaEmpaqueDTO lineaEmpaqueDTO;

	/**
	 * Obtiene la relacion con el cat�logo de articulo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOARTICULO", insertable = false, updatable = false, referencedColumnName = "CODIGOARTICULO") })
	private ArticuloDTO articuloDTO;
	

	/**
	 * M�todo Getter del campo id
	 * 
	 * @return the id
	 */
	public LineaEmpaqueArticuloID getId() {
		return id;
	}

	/**
	 * M�todo Setter the id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueArticuloID id) {
		this.id = id;
	}

	/**
	 * M�todo Getter del campo porcentajeMerma
	 * 
	 * @return the porcentajeMerma
	 */
	public java.lang.Double getPorcentajeMerma() {
		return porcentajeMerma;
	}

	/**
	 * M�todo Setter the porcentajeMerma
	 * 
	 * @param porcentajeMerma
	 *            the porcentajeMerma to set
	 */
	public void setPorcentajeMerma(java.lang.Double porcentajeMerma) {
		this.porcentajeMerma = porcentajeMerma;
	}

	/**
	 * M�todo Getter del campo personasNecesarias
	 * 
	 * @return the personasNecesarias
	 */
	public java.lang.Integer getPersonasNecesarias() {
		return personasNecesarias;
	}

	/**
	 * M�todo Setter the personasNecesarias
	 * 
	 * @param personasNecesarias
	 *            the personasNecesarias to set
	 */
	public void setPersonasNecesarias(java.lang.Integer personasNecesarias) {
		this.personasNecesarias = personasNecesarias;
	}

	/**
	 * M�todo Getter del campo personasMaximas
	 * 
	 * @return the personasMaximas
	 */
	public java.lang.Integer getPersonasMaximas() {
		return personasMaximas;
	}

	/**
	 * M�todo Setter the personasMaximas
	 * 
	 * @param personasMaximas
	 *            the personasMaximas to set
	 */
	public void setPersonasMaximas(java.lang.Integer personasMaximas) {
		this.personasMaximas = personasMaximas;
	}

	/**
	 * M�todo Getter del campo tiempoProduccion
	 * 
	 * @return the tiempoProduccion
	 */
	public java.lang.Double getTiempoProduccion() {
		return tiempoProduccion;
	}

	/**
	 * M�todo Setter the tiempoProduccion
	 * 
	 * @param tiempoProduccion
	 *            the tiempoProduccion to set
	 */
	public void setTiempoProduccion(java.lang.Double tiempoProduccion) {
		this.tiempoProduccion = tiempoProduccion;
	}

	/**
	 * M�todo Getter del campo idUsuarioRegistro
	 * 
	 * @return the idUsuarioRegistro
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * M�todo Setter the idUsuarioRegistro
	 * 
	 * @param idUsuarioRegistro
	 *            the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * M�todo Getter del campo fechaRegistro
	 * 
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * M�todo Setter the fechaRegistro
	 * 
	 * @param fechaRegistro
	 *            the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * M�todo Getter del campo idUsuarioModificacion
	 * 
	 * @return the idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * M�todo Setter the idUsuarioModificacion
	 * 
	 * @param idUsuarioModificacion
	 *            the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * M�todo Getter del campo fechaModificacion
	 * 
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * M�todo Setter the fechaModificacion
	 * 
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * M�todo Getter del campo tipoTiempoDTO
	 * 
	 * @return the tipoTiempoDTO
	 */
	public CatalogoValorDTO getTipoTiempoDTO() {
		return tipoTiempoDTO;
	}

	/**
	 * M�todo Setter the tipoTiempoDTO
	 * 
	 * @param tipoTiempoDTO
	 *            the tipoTiempoDTO to set
	 */
	public void setTipoTiempoDTO(CatalogoValorDTO tipoTiempoDTO) {
		this.tipoTiempoDTO = tipoTiempoDTO;
	}

	/**
	 * M�todo Getter del campo lineaEmpaqueDTO
	 * 
	 * @return the lineaEmpaqueDTO
	 */
	public LineaEmpaqueDTO getLineaEmpaqueDTO() {
		return lineaEmpaqueDTO;
	}

	/**
	 * M�todo Setter the lineaEmpaqueDTO
	 * 
	 * @param lineaEmpaqueDTO
	 *            the lineaEmpaqueDTO to set
	 */
	public void setLineaEmpaqueDTO(LineaEmpaqueDTO lineaEmpaqueDTO) {
		this.lineaEmpaqueDTO = lineaEmpaqueDTO;
	}

	/**
	 * M�todo Getter del campo articuloDTO
	 * 
	 * @return the articuloDTO
	 */
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	/**
	 * M�todo Setter the articuloDTO
	 * 
	 * @param articuloDTO
	 *            the articuloDTO to set
	 */
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	/**
	 * M�todo Getter del campo codigoTipoTiempoProduccion
	 * @return the codigoTipoTiempoProduccion
	 */
	public java.lang.Integer getCodigoTipoTiempoProduccion() {
		return codigoTipoTiempoProduccion;
	}

	/**
	 * M�todo Setter the codigoTipoTiempoProduccion
	 * @param codigoTipoTiempoProduccion the codigoTipoTiempoProduccion to set
	 */
	public void setCodigoTipoTiempoProduccion(java.lang.Integer codigoTipoTiempoProduccion) {
		this.codigoTipoTiempoProduccion = codigoTipoTiempoProduccion;
	}

	/**
	 * M�todo Getter del campo codigoValorTiempoProduccion
	 * 
	 * @return the codigoValorTiempoProduccion
	 */
	public java.lang.String getCodigoValorTiempoProduccion() {
		return codigoValorTiempoProduccion;
	}

	/**
	 * M�todo Setter the codigoValorTiempoProduccion
	 * 
	 * @param codigoValorTiempoProduccion
	 *            the codigoValorTiempoProduccion to set
	 */
	public void setCodigoValorTiempoProduccion(java.lang.String codigoValorTiempoProduccion) {
		this.codigoValorTiempoProduccion = codigoValorTiempoProduccion;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LineaEmpaqueArticuloDTO [id=" + id + "]";
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
		LineaEmpaqueArticuloDTO other = (LineaEmpaqueArticuloDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

}
