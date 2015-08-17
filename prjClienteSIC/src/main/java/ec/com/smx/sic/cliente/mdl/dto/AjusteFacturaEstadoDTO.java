package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

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

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.AjusteFacturaEstadoID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTAJUFACEST")
public class AjusteFacturaEstadoDTO extends SimpleAuditDTO{
	/**
	 * Clave primaria de la tabla AjusteFacturaEstadoDTO
	 * 
	 */
	@EmbeddedId
	private AjusteFacturaEstadoID id = new AjusteFacturaEstadoID();
	
	/*@Column(name = "CODIGOTIPOAJUSTE", nullable = false)
	private Integer codigoTipoAjuste;
	
	@Column(name = "VALORTIPOAJUSTE", nullable = false)
	private String valorTipoAjuste;*/
	
	@Column(name = "CODIGOCLASEAJUSTE", nullable = false)
	private Integer codigoClaseAjuste;
	
	@Column(name = "VALORCLASEAJUSTE", nullable = false)
	private String valorClaseAjuste;
	
	//Estas columnas hacen referencia al catalogo valor del tipo de ajuste si es un ajuste o es una devolucion
	@Column(name = "CODIGOTIPO", nullable = false)
	private Integer codigoTipo;
	
	@Column(name = "VALORTIPO", nullable = false)
	private String valorTipo;
	//////
	//En este campo se almacena el numero de la devolucion en caso de que el ajuste sea una devolución
	@Column(name = "NUMERODEVOLUCION ", nullable = true)
	private String numeroDevolucion;
	
	
	@Column(name = "VALORTOTALAJUSTE", nullable = false)
	private BigDecimal valorTotalAjuste;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@Column
	@RegisterDateField
	private Date fechaRegistro;
	
	@Column(nullable = false)
	@RegisterUserIdField
	private String usuarioRegistro;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
	
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String usuarioModificacion;
	
	@Transient
	private Boolean expandir = Boolean.FALSE;
	
	
	/**
	 * Referencia con la tabla catalogo valor Tipo Ajuste
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOTIPOAJUSTE", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "valorTipoAjuste", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO tipoAjusteDTO;

	@OneToMany(mappedBy = "ajusteFacturaEstadoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleAjusteFacturaEstadoDTO> detallesAjusteFacturaEstadoCol;
	
	@OneToMany(mappedBy = "ajusteFacturaEstadoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<AjusteFacturaDTO> ajusteFacturaCol;
	
	/**
	 * Referencia con la tabla catalogo valor Tipo Ajuste
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOTIPO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "VALORTIPO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO tipoDTO;
	
	/**
	 * Referencia con la tabla catalogo valor Tipo Ajuste
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCLASEAJUSTE", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "VALORCLASEAJUSTE", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO claseAjusteDTO;
	
	@Transient
	private Collection<DetalleAjusteFacturaEstadoDTO> detallesAjusteFacturaEstadoAnteriorCol;
	
	public AjusteFacturaEstadoID getId() {
		return id;
	}

	public void setId(AjusteFacturaEstadoID id) {
		this.id = id;
	}

	/*public Integer getCodigoTipoAjuste() {
		return codigoTipoAjuste;
	}

	public void setCodigoTipoAjuste(Integer codigoTipoAjuste) {
		this.codigoTipoAjuste = codigoTipoAjuste;
	}

	public String getValorTipoAjuste() {
		return valorTipoAjuste;
	}

	public void setValorTipoAjuste(String valorTipoAjuste) {
		this.valorTipoAjuste = valorTipoAjuste;
	}*/

	public Integer getCodigoClaseAjuste() {
		return codigoClaseAjuste;
	}

	public void setCodigoClaseAjuste(Integer codigoClaseAjuste) {
		this.codigoClaseAjuste = codigoClaseAjuste;
	}

	public String getValorClaseAjuste() {
		return valorClaseAjuste;
	}

	public void setValorClaseAjuste(String valorClaseAjuste) {
		this.valorClaseAjuste = valorClaseAjuste;
	}

	public BigDecimal getValorTotalAjuste() {
		return valorTotalAjuste;
	}

	public void setValorTotalAjuste(BigDecimal valorTotalAjuste) {
		this.valorTotalAjuste = valorTotalAjuste;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public CatalogoValorDTO getTipoAjusteDTO() {
		return tipoAjusteDTO;
	}

	public void setTipoAjusteDTO(CatalogoValorDTO tipoAjusteDTO) {
		this.tipoAjusteDTO = tipoAjusteDTO;
	}
	
	public CatalogoValorDTO getClaseAjusteDTO() {
		return claseAjusteDTO;
	}

	public void setClaseAjusteDTO(CatalogoValorDTO claseAjusteDTO) {
		this.claseAjusteDTO = claseAjusteDTO;
	}

	public Collection<DetalleAjusteFacturaEstadoDTO> getDetallesAjusteFacturaEstadoCol() {
		return detallesAjusteFacturaEstadoCol;
	}

	public void setDetallesAjusteFacturaEstadoCol(Collection<DetalleAjusteFacturaEstadoDTO> detallesAjusteFacturaEstadoCol) {
		this.detallesAjusteFacturaEstadoCol = detallesAjusteFacturaEstadoCol;
	}

	public Collection<AjusteFacturaDTO> getAjusteFacturaCol() {
		return ajusteFacturaCol;
	}

	public void setAjusteFacturaCol(Collection<AjusteFacturaDTO> ajusteFacturaCol) {
		this.ajusteFacturaCol = ajusteFacturaCol;
	}

	public Integer getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(Integer codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public String getValorTipo() {
		return valorTipo;
	}

	public void setValorTipo(String valorTipo) {
		this.valorTipo = valorTipo;
	}

	public String getNumeroDevolucion() {
		return numeroDevolucion;
	}

	public void setNumeroDevolucion(String numeroDevolucion) {
		this.numeroDevolucion = numeroDevolucion;
	}

	public Boolean getExpandir() {
		return expandir;
	}

	public void setExpandir(Boolean expandir) {
		this.expandir = expandir;
	}

	public CatalogoValorDTO getTipoDTO() {
		return tipoDTO;
	}

	public void setTipoDTO(CatalogoValorDTO tipoDTO) {
		this.tipoDTO = tipoDTO;
	}

	public Collection<DetalleAjusteFacturaEstadoDTO> getDetallesAjusteFacturaEstadoAnteriorCol() {
		return detallesAjusteFacturaEstadoAnteriorCol;
	}

	public void setDetallesAjusteFacturaEstadoAnteriorCol(Collection<DetalleAjusteFacturaEstadoDTO> detallesAjusteFacturaEstadoAnteriorCol) {
		this.detallesAjusteFacturaEstadoAnteriorCol = detallesAjusteFacturaEstadoAnteriorCol;
	}
}
