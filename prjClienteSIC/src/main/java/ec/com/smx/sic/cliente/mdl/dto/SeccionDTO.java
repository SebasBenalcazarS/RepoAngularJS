
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
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.SeccionID;


/**
 * Almacena todas las secciones de la estructura logistica
 *
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTSECCION")
public class SeccionDTO extends AuditoriaBaseDTO{

	/**
	 * Clave primaria de la tabla Seccion
	 *
	 */
	@EmbeddedId
	private SeccionID id = new SeccionID();
	
	/**
	 * Descripcion de la seccion
	 *
	 */
	@Column
	private String descripcionSeccion ;

	/**
	 * Codigo del tipo de seccion de la estructura logistica en el catalogo
	 *
	 */
	@Column
	private Integer codigoTipoSeccion ;
	
	/**
	 * Codigo del area de trabajo
	 *
	 */
	@Column
	private Integer codigoAreaTrabajo ;

	@Column
	private Integer codigoAreaTrabajoPadre;
	
	/**
	 * Valor del tipo de seccion de la estructura logistica en el catalogo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String valorTipoSeccion ;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;

	/**
	 * Constructor
	 */
	public SeccionDTO(){
		
	}
	
	/**
	 * Obtiene la relacion con los detalles de la seccion
	 */
	@OneToMany(mappedBy = "seccionDTO")
	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<DetalleSeccionDTO> detalleSeccionCol;
	
	/**
	 * Relacion con el catalogo 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOSECCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOSECCION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoSeccion;
	
	/**
	 * Relacion con el area de trabajo 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOAREATRABAJO", insertable=false, updatable=false, referencedColumnName="CODIGOAREASUBLUGARTRABAJO"),
		@JoinColumn(name="CODIGOAREATRABAJOPADRE", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO areaSublugarTrabajoDTO;
	
	@Transient
	private Collection<DetalleSeccionDTO> pasillosNoAsignadosCol;

	
	/**
	 * Colocamos la estructua de ubicaciones
	 */
	@Transient
	private Collection<AsignacionArticuloUnidadManejoDTO> asignacionArticuloUnidadManejoCol;
	
	@Transient
	private Integer codigoReferenciaAreaTrabajo;
	
	@Transient
	private String descripcionAreaTrabajo; 
	
	/**
	 * @return the descripcionSeccion
	 */
	public String getDescripcionSeccion() {
		return descripcionSeccion;
	}

	/**
	 * @param descripcionSeccion the descripcionSeccion to set
	 */
	public void setDescripcionSeccion(String descripcionSeccion) {
		this.descripcionSeccion = descripcionSeccion;
	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoSeccion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTipoSeccion</code>
	 */
	public Integer getCodigoTipoSeccion(){
		return this.codigoTipoSeccion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoSeccion</code>.
	 * @param codigoTipoSeccion1 
	 *		El valor a establecer para la propiedad <code>codigoTipoSeccion</code>.
	 */
	public void setCodigoTipoSeccion( Integer codigoTipoSeccion1 ){
		this.codigoTipoSeccion=codigoTipoSeccion1;
		
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
	 * Retorna valor de propiedad <code>valorTipoSeccion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>valorTipoSeccion</code>
	 */
	public String getValorTipoSeccion(){
		return this.valorTipoSeccion;
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
	 * @param valorTipoSeccion the valorTipoSeccion to set
	 */
	public void setValorTipoSeccion(String valorTipoSeccion) {
		this.valorTipoSeccion = valorTipoSeccion;
	}

	/**
	 * @return the detalleSeccionCol
	 */
	public Collection<DetalleSeccionDTO> getDetalleSeccionCol() {
		return detalleSeccionCol;
	}

	/**
	 * @param detalleSeccionCol the detalleSeccionCol to set
	 */
	public void setDetalleSeccionCol(Collection<DetalleSeccionDTO> detalleSeccionCol) {
		this.detalleSeccionCol = detalleSeccionCol;
	}

	/**
	 * Retorna valor de propiedad <code>tipoSeccion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>tipoSeccion</code>
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoSeccion(){
		return this.tipoSeccion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoSeccion</code>.
	 * @param tipoSeccion1 
	 *		El valor a establecer para la propiedad <code>tipoSeccion</code>.
	 */
	public void setTipoSeccion( ec.com.smx.corpv2.dto.CatalogoValorDTO tipoSeccion1 ){
		this.tipoSeccion=tipoSeccion1;
	}

	/**
	 * @return the codigoAreaTrabajoPadre
	 */
	public Integer getCodigoAreaTrabajoPadre() {
		return codigoAreaTrabajoPadre;
	}

	/**
	 * @param codigoAreaTrabajoPadre the codigoAreaTrabajoPadre to set
	 */
	public void setCodigoAreaTrabajoPadre(Integer codigoAreaTrabajoPadre) {
		this.codigoAreaTrabajoPadre = codigoAreaTrabajoPadre;
	}

	/**
	 * @return the areaSublugarTrabajoDTO
	 */
	public ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO getAreaSublugarTrabajoDTO() {
		return areaSublugarTrabajoDTO;
	}

	/**
	 * @param areaSublugarTrabajoDTO the areaSublugarTrabajoDTO to set
	 */
	public void setAreaSublugarTrabajoDTO(ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO areaSublugarTrabajoDTO) {
		this.areaSublugarTrabajoDTO = areaSublugarTrabajoDTO;
	}

	/**
	 * @return the id
	 */
	public SeccionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(SeccionID id) {
		this.id = id;
	}

	/**
	 * @return the pasillosNoAsignadosCol
	 */
	public Collection<DetalleSeccionDTO> getPasillosNoAsignadosCol() {
		return pasillosNoAsignadosCol;
	}

	/**
	 * @param pasillosNoAsignadosCol the pasillosNoAsignadosCol to set
	 */
	public void setPasillosNoAsignadosCol(
			Collection<DetalleSeccionDTO> pasillosNoAsignadosCol) {
		this.pasillosNoAsignadosCol = pasillosNoAsignadosCol;
	}


	/**
	 * @return the asignacionArticuloUnidadManejoCol
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> getAsignacionArticuloUnidadManejoCol() {
		return asignacionArticuloUnidadManejoCol;
	}

	/**
	 * @param asignacionArticuloUnidadManejoCol the asignacionArticuloUnidadManejoCol to set
	 */
	public void setAsignacionArticuloUnidadManejoCol(
			Collection<AsignacionArticuloUnidadManejoDTO> asignacionArticuloUnidadManejoCol) {
		this.asignacionArticuloUnidadManejoCol = asignacionArticuloUnidadManejoCol;
	}

	/**
	 * @return the codigoReferenciaAreaTrabajo
	 */
	public Integer getCodigoReferenciaAreaTrabajo() {
		return codigoReferenciaAreaTrabajo;
	}

	/**
	 * @param codigoReferenciaAreaTrabajo the codigoReferenciaAreaTrabajo to set
	 */
	public void setCodigoReferenciaAreaTrabajo(Integer codigoReferenciaAreaTrabajo) {
		this.codigoReferenciaAreaTrabajo = codigoReferenciaAreaTrabajo;
	}

	/**
	 * @return the descripcionAreaTrabajo
	 */
	public String getDescripcionAreaTrabajo() {
		return descripcionAreaTrabajo;
	}

	/**
	 * @param descripcionAreaTrabajo the descripcionAreaTrabajo to set
	 */
	public void setDescripcionAreaTrabajo(String descripcionAreaTrabajo) {
		this.descripcionAreaTrabajo = descripcionAreaTrabajo;
	}
	
	
}