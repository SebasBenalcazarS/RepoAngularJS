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
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.MarcaArticuloID;

/**
 * Entidad que almacena el cat&aacute;logo de marcas que puede tener un art&iacute;culo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTMARCA")
public class MarcaArticuloDTO extends SimpleAuditDTO {

	@EmbeddedId
	private MarcaArticuloID id;

	
	/**
	 * Nombre de la marca de un art&iacute;culo
	 */
	private String nombre;
	
	
	/**
	 * Descripci&oacute;n larga de la marca de un art&iacute;culo
	 */
	private String descripcion;
	
	
	/**
	 * Indica el si la marca de un art&iacute;culo est&aacute; activa o inactiva. Los valores permitos son: [0] Inactivo [1] Activo
	 */
	@ComparatorTypeField
	private String estado;
	
	
	/**
	 * Valor del tipo de marca en el catalogo
	 */
	@ComparatorTypeField
	@Column(name="VALORTIPOMARCA")
	private String valorTipoMarca;
	
	
	/**
	 * Codigo del tipo de marca en el catalogo
	 */
	@Column(name="CODIGOTIPOMARCA")
	private Integer codigoTipoMarca;
	
	/**
	 * Tiene precio saldo
	 */
	@Column(name="TIENEPRECIOSALDO")
	private Boolean tienePrecioSaldo;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 */
	@RegisterUserIdField
	private String usuarioRegistro;

	
	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	
	/**
	 * Id del usuario que realizo la &uacute;ltima actualizaci&oacute;n.
	 */
	@LastModifierUserIdField
	private String usuarioModificacion;

	
	/**
	 * Fecha en la que se realizo la &uacute;ltima actualizaci&oacute;n.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	
	private Long secuencialMarcaSIC;
	
	
	@Transient
	private Boolean selected;
	
	//variable usada en Historial de cambios
	@Transient
	private String varMarcaArticulo;
	
	@OneToMany(mappedBy = "marcaComercialArticulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<ArticuloComercialDTO> articuloComercialCol;
	
	@OneToMany(mappedBy = "marcaArticulo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol;
	
	@OneToMany(mappedBy = "marcaArticuloDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<ProveedorMarcaDTO> proveedorMarcaCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOMARCA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOMARCA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoMarca;

	
	/**
	 * Abreviacion del nombre de la marca
	 */
	private String abreviatura;

	
	public MarcaArticuloDTO() {
		this.id = new MarcaArticuloID();
	}

	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public MarcaArticuloID getId() {
		return this.id;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(MarcaArticuloID id1) {
		this.id = id1;
	}
	
	
	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;
	}
	
	
	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;
	}

	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre != null ? nombre.toUpperCase() : null;
	}

	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion != null ? descripcion.toUpperCase() : null;
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
	 * @return the usuarioRegistro
	 */
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	
	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	
	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	
	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	
	/**
	 * @return the valorTipoMarca
	 */
	public String getValorTipoMarca() {
		return valorTipoMarca;
	}

	
	/**
	 * @param valorTipoMarca the valorTipoMarca to set
	 */
	public void setValorTipoMarca(String valorTipoMarca) {
		this.valorTipoMarca = valorTipoMarca;
	}

	
	/**
	 * @return the codigoTipoMarca
	 */
	public Integer getCodigoTipoMarca() {
		return codigoTipoMarca;
	}

	
	/**
	 * @param codigoTipoMarca the codigoTipoMarca to set
	 */
	public void setCodigoTipoMarca(Integer codigoTipoMarca) {
		this.codigoTipoMarca = codigoTipoMarca;
	}

	
	/**
	 * @return the tipoMarca
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoMarca() {
		return tipoMarca;
	}

	
	/**
	 * @param tipoMarca the tipoMarca to set
	 */
	public void setTipoMarca(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoMarca) {
		this.tipoMarca = tipoMarca;
	}

	
	public Collection<ProveedorMarcaDTO> getProveedorMarcaCol() {
		return proveedorMarcaCol;
	}

	
	public void setProveedorMarcaCol(Collection<ProveedorMarcaDTO> proveedorMarcaCol) {
		this.proveedorMarcaCol = proveedorMarcaCol;
	}

	
	/**
	 * @return the secuencialMarcaSIC
	 */
	public Long getSecuencialMarcaSIC() {
		return secuencialMarcaSIC;
	}

	
	/**
	 * @param secuencialMarcaSIC the secuencialMarcaSIC to set
	 */
	public void setSecuencialMarcaSIC(Long secuencialMarcaSIC) {
		this.secuencialMarcaSIC = secuencialMarcaSIC;
	}


	/**
	 * @return the selected
	 */
	public Boolean getSelected() {
		return selected;
	}


	/**
	 * @param selected the selected to set
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getVarMarcaArticulo() {
		this.varMarcaArticulo = this.getId().getSecuencialMarca().toString().concat(" - ").concat(this.getNombre());
		return varMarcaArticulo;
	}

	public void setVarMarcaArticulo(String varMarcaArticulo) {
		this.varMarcaArticulo = this.getId().getSecuencialMarca().toString().concat(" - ").concat(this.getNombre());
	}

	/**
	 * @return the articuloComercialCol
	 */
	public Collection<ArticuloComercialDTO> getArticuloComercialCol() {
		return articuloComercialCol;
	}


	/**
	 * @param articuloComercialCol the articuloComercialCol to set
	 */
	public void setArticuloComercialCol(Collection<ArticuloComercialDTO> articuloComercialCol) {
		this.articuloComercialCol = articuloComercialCol;
	}


	/**
	 * @return the abreviatura
	 */
	public String getAbreviatura() {
		return abreviatura;
	}


	/**
	 * @param abreviatura the abreviatura to set
	 */
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}


	/**
	 * @return the marcaFuncionarioTipoMarcaCol
	 */
	public Collection<MarcaFuncionarioTipoMarcaDTO> getMarcaFuncionarioTipoMarcaCol() {
		return marcaFuncionarioTipoMarcaCol;
	}


	/**
	 * @param marcaFuncionarioTipoMarcaCol the marcaFuncionarioTipoMarcaCol to set
	 */
	public void setMarcaFuncionarioTipoMarcaCol(Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol) {
		this.marcaFuncionarioTipoMarcaCol = marcaFuncionarioTipoMarcaCol;
	}


	/**
	 * @return the tienePrecioSaldo
	 */
	public Boolean getTienePrecioSaldo() {
		return tienePrecioSaldo;
	}


	/**
	 * @param tienePrecioSaldo the tienePrecioSaldo to set
	 */
	public void setTienePrecioSaldo(Boolean tienePrecioSaldo) {
		this.tienePrecioSaldo = tienePrecioSaldo;
	}

}
