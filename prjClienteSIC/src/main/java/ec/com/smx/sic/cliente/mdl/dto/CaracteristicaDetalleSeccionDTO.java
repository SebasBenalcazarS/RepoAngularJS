
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
import ec.com.smx.sic.cliente.mdl.dto.id.CaracteristicaDetalleSeccionID;

/**
 * Especifica las caracteristicas dinamicas del detalle de la seccion de la estructura logistica
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCARDETSEC")
public class CaracteristicaDetalleSeccionDTO extends AuditoriaBaseDTO {

	/**
	 * Clave primaria de la tabla DetalleSeccion
	 *
	 */
	@EmbeddedId
	private CaracteristicaDetalleSeccionID id = new CaracteristicaDetalleSeccionID();
	
	/**
	 * Especifica el codigo de la seccion
	 *
	 */
	@Column
	@ComparatorTypeField
	private java.lang.Long codigoDetalleSeccion ;

	/**
	 * C�digo del tipo de ubicaci�n de la estructura log�stica en el cat�logo
	 *
	 */
	@Column
	private Integer codigoTipoCaracteristica ;

	/**
	 * Valor del tipo de ubicaci�n de la estructura log�stica en el cat�logo (Valores R-> Real - V -> Virtual)
	 *
	 */
	@Column
	private String valorTipoCaracteristica ;

	
	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	@ComparatorTypeField
	@Column
	private String estado ;
	
	/**
	 * Especifica la relacion con la seccion de la estructura logistica
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO detalleSeccionDTO;
	
	/**
	 * Obtiene la relacion con el cat�logo del tipo de ubicaciones
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOCARACTERISTICA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOCARACTERISTICA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoCaracteristicaDTO;

	
	public CaracteristicaDetalleSeccionDTO() {
		
	}


	/**
	 * @return the id
	 */
	public CaracteristicaDetalleSeccionID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(CaracteristicaDetalleSeccionID id) {
		this.id = id;
	}


	/**
	 * @return the codigoDetalleSeccion
	 */
	public java.lang.Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}


	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(java.lang.Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}


	/**
	 * @return the codigoTipoCaracteristica
	 */
	public Integer getCodigoTipoCaracteristica() {
		return codigoTipoCaracteristica;
	}


	/**
	 * @param codigoTipoCaracteristica the codigoTipoCaracteristica to set
	 */
	public void setCodigoTipoCaracteristica(Integer codigoTipoCaracteristica) {
		this.codigoTipoCaracteristica = codigoTipoCaracteristica;
	}


	/**
	 * @return the valorTipoCaracteristica
	 */
	public String getValorTipoCaracteristica() {
		return valorTipoCaracteristica;
	}


	/**
	 * @param valorTipoCaracteristica the valorTipoCaracteristica to set
	 */
	public void setValorTipoCaracteristica(String valorTipoCaracteristica) {
		this.valorTipoCaracteristica = valorTipoCaracteristica;
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
	 * @return the detalleSeccionDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}


	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}


	/**
	 * @return the tipoCaracteristicaDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoCaracteristicaDTO() {
		return tipoCaracteristicaDTO;
	}


	/**
	 * @param tipoCaracteristicaDTO the tipoCaracteristicaDTO to set
	 */
	public void setTipoCaracteristicaDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoCaracteristicaDTO) {
		this.tipoCaracteristicaDTO = tipoCaracteristicaDTO;
	}
	
}