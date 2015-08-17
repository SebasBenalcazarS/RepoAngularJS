package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorDetalleSeccionID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;


/**
 * Registra los andenes que tiene una recepcion
 * @author dalmeida
 *
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTRECPRODETSEC")
public class RecepcionProveedorDetalleSeccionDTO extends AuditoriaBaseDTO {

	/**
	 * Clave primaria de la tabla RecepcionProveedorArticulo
	 */
	@EmbeddedId
	private RecepcionProveedorDetalleSeccionID id = new RecepcionProveedorDetalleSeccionID();

	/**
	 * Campo para optimizar los procesos de actualizacion de registros
	 */
	@Column(name = "SECUENCIALRECPRODETSEC")
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , 
		name = "SBLOGSECRECPRODETSECSEC", 
	    sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
		castTo=@Cast(sqlType=Types.NUMERIC,precision=9,scale=0))
	private Long secuencialRecepcionProveedorDetalleSeccion;

	/**
	 * Codigo de la recepcion del proveedor
	 */
	@Column(name = "CODIGORECEPCIONPROVEEDOR")
	private Long codigoRecepcionProveedor;

	/**
	 * Codigo de articulo de la unidad de manejo
	 */
	@ComparatorTypeField
	@Column(name = "CODIGODETALLESECCION", nullable = false)
	private Long codigoDetalleSeccion;

	/**
	 * Especifica la relacion con RecepcionProveedor
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGORECEPCIONPROVEEDOR", insertable = false, updatable = false, referencedColumnName = "CODIGORECEPCIONPROVEEDOR") 
	})
	private RecepcionProveedorDTO recepcionProveedorDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionDTO;

	@ComparatorTypeField
	@Column(name = "ESTADO")
	private String estado;

	/**
	 * @return the id
	 */
	public RecepcionProveedorDetalleSeccionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(RecepcionProveedorDetalleSeccionID id) {
		this.id = id;
	}

	/**
	 * @return the secuencialRecepcionProveedorDetalleSeccion
	 */
	public Long getSecuencialRecepcionProveedorDetalleSeccion() {
		return secuencialRecepcionProveedorDetalleSeccion;
	}

	/**
	 * @param secuencialRecepcionProveedorDetalleSeccion the secuencialRecepcionProveedorDetalleSeccion to set
	 */
	public void setSecuencialRecepcionProveedorDetalleSeccion(Long secuencialRecepcionProveedorDetalleSeccion) {
		this.secuencialRecepcionProveedorDetalleSeccion = secuencialRecepcionProveedorDetalleSeccion;
	}

	/**
	 * @return the codigoRecepcionProveedor
	 */
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}

	/**
	 * @param codigoRecepcionProveedor the codigoRecepcionProveedor to set
	 */
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}

	/**
	 * @return the codigoDetalleSeccion
	 */
	public Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	/**
	 * @return the recepcionProveedorDTO
	 */
	public RecepcionProveedorDTO getRecepcionProveedorDTO() {
		return recepcionProveedorDTO;
	}

	/**
	 * @param recepcionProveedorDTO the recepcionProveedorDTO to set
	 */
	public void setRecepcionProveedorDTO(RecepcionProveedorDTO recepcionProveedorDTO) {
		this.recepcionProveedorDTO = recepcionProveedorDTO;
	}

	/**
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
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

}
