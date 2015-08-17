package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraRelacionadoID;

/**
 * 
 * @author amunoz
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTORDCOMREL")
public class OrdenCompraRelacionadaDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private OrdenCompraRelacionadoID id= new OrdenCompraRelacionadoID();
	
	
    @Column(name = "CODIGOTIPOCATVAL", nullable=false)
    @ComparatorTypeField
    private String codigoTipoCatVal;
   
    @Column(name = "CODIGOTIPOCATTIP", nullable=false)
    private Integer codigoTipoCatTip;
    
    @Column(name = "NUMEROCOTIZACION")
    private String numeroCotizacion;
    
    @Column(name = "ESTADO", nullable=false)
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable=false)
    private String idUsuarioRegistro;
   
    @RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
   
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idusuariomodificacion;

    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
    })
    private OrdenCompraDTO ordenCompra;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOORDENCOMPRARELACIONADA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
    })
    private OrdenCompraDTO ordenCompraRelacionada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOTIPOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOTIPOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO tipo;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;

    
	public OrdenCompraRelacionadoID getId() {
		return id;
	}

	public void setId(OrdenCompraRelacionadoID id) {
		this.id = id;
	}

	public String getCodigoTipoCatVal() {
		return codigoTipoCatVal;
	}

	public void setCodigoTipoCatVal(String codigoTipoCatVal) {
		this.codigoTipoCatVal = codigoTipoCatVal;
	}

	public Integer getCodigoTipoCatTip() {
		return codigoTipoCatTip;
	}

	public void setCodigoTipoCatTip(Integer codigoTipoCatTip) {
		this.codigoTipoCatTip = codigoTipoCatTip;
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

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getIdusuariomodificacion() {
		return idusuariomodificacion;
	}

	public void setIdusuariomodificacion(String idusuariomodificacion) {
		this.idusuariomodificacion = idusuariomodificacion;
	}

	public Date getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public OrdenCompraDTO getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompraDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	public OrdenCompraDTO getOrdenCompraRelacionada() {
		return ordenCompraRelacionada;
	}

	public void setOrdenCompraRelacionada(OrdenCompraDTO ordenCompraRelacionada) {
		this.ordenCompraRelacionada = ordenCompraRelacionada;
	}

	/**
	 * @return the numeroCotizacion
	 */
	public String getNumeroCotizacion() {
		return numeroCotizacion;
	}

	/**
	 * @param numeroCotizacion the numeroCotizacion to set
	 */
	public void setNumeroCotizacion(String numeroCotizacion) {
		this.numeroCotizacion = numeroCotizacion;
	}

	/**
	 * @return the tipo
	 */
	public CatalogoValorDTO getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(CatalogoValorDTO tipo) {
		this.tipo = tipo;
	}
	
}
