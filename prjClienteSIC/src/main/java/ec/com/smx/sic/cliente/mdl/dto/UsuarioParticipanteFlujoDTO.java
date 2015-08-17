/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.UsuarioParticipanteFlujoID;

/**
 * @author jpucha
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITUSRPARFLU")
public class UsuarioParticipanteFlujoDTO extends SimpleAuditDTO {

	
	@EmbeddedId
	private UsuarioParticipanteFlujoID id = new UsuarioParticipanteFlujoID();
	
	/**
	 * area de trabajo a la cual pertenece el usuario
	 */
@Column(name = "CODIGOAREATRABAJO",nullable=false)
	private Integer codigoAreaTrabajo;
	
	/**
	 * usuario responsable de mover el caso en el workflow
	 */
	@Column(name = "USUARIOID")
	private String idUsuario;
	
	/**
	 * codigo catalogo tipo de la categoria de usuario
	 */
	@Column(name = "CODIGOCATALOGOTIPOUSUPARFLU", nullable=false)
	private Integer codigoCatalogoTipoUsuParFlu;
	
	/**
	 * codigo catalogo valor de la categoria de usuario
	 */
	@Column(name = "CODIGOCATALOGOVALORUSUPARFLU",nullable=false)
	private String codigoCatalogoValorUsuParFlu;
	
	/**
	 * nivel en el que esta un usuario para realizar asignar,aprobar,contabilizar,adjuntar
	 */
	@Column(name = "NIVEL")
	private String nivel;
	
	/**
	 * monto que tiene un usuario para realizar asignar,aprobar,contabilizar,adjuntar
	 */
	@Column(name = "MONTO")
	private BigDecimal monto;
	
	/**
	 * ACT, INA
	 */
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "IDUSUARIOREGISTRO",nullable=false)
	private String idUsuarioRegistro;
	
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	@Column(name = "FECHAREGISTRO",nullable=false)
	private Date fechaRegistro;
	
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
	
	
	/**
	 * Dto usuarios
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "USUARIOID", referencedColumnName = "USERID", insertable = false, updatable = false)
    })
    private UserDto usuarioDTO;
	
	/**
	 * Dto del catalogo de categoria usuarios
	 */
	@ManyToOne(fetch= FetchType.LAZY)
	    @JoinColumns({
	    	@JoinColumn(name = "CODIGOCATALOGOTIPOUSUPARFLU", referencedColumnName= "CODIGOCATALOGOTIPO", insertable=false, updatable=false),
	    	@JoinColumn(name = "CODIGOCATALOGOVALORUSUPARFLU", referencedColumnName = "CODIGOCATALOGOVALOR" , insertable = false, updatable= false)
	    })
	private CatalogoValorDTO catalogoCategoriaUsuarioDTO;
	
	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	/**
	 * @return the monto
	 */
	public BigDecimal getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
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
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}
	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the id
	 */
	public UsuarioParticipanteFlujoID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(UsuarioParticipanteFlujoID id) {
		this.id = id;
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
	 * @return the codigoCatalogoTipoUsuParFlu
	 */
	public Integer getCodigoCatalogoTipoUsuParFlu() {
		return codigoCatalogoTipoUsuParFlu;
	}
	/**
	 * @param codigoCatalogoTipoUsuParFlu the codigoCatalogoTipoUsuParFlu to set
	 */
	public void setCodigoCatalogoTipoUsuParFlu(Integer codigoCatalogoTipoUsuParFlu) {
		this.codigoCatalogoTipoUsuParFlu = codigoCatalogoTipoUsuParFlu;
	}
	/**
	 * @return the codigoCatalogoValorUsuParFlu
	 */
	public String getCodigoCatalogoValorUsuParFlu() {
		return codigoCatalogoValorUsuParFlu;
	}
	/**
	 * @param codigoCatalogoValorUsuParFlu the codigoCatalogoValorUsuParFlu to set
	 */
	public void setCodigoCatalogoValorUsuParFlu(String codigoCatalogoValorUsuParFlu) {
		this.codigoCatalogoValorUsuParFlu = codigoCatalogoValorUsuParFlu;
	}
	/**
	/**
	 * @return the catalogoCategoriaUsuarioDTO
	 */
	public CatalogoValorDTO getCatalogoCategoriaUsuarioDTO() {
		return catalogoCategoriaUsuarioDTO;
	}
	/**
	 * @param catalogoCategoriaUsuarioDTO the catalogoCategoriaUsuarioDTO to set
	 */
	public void setCatalogoCategoriaUsuarioDTO(CatalogoValorDTO catalogoCategoriaUsuarioDTO) {
		this.catalogoCategoriaUsuarioDTO = catalogoCategoriaUsuarioDTO;
	}
	/**
	 * @return the usuarioDTO
	 */
	public UserDto getUsuarioDTO() {
		return usuarioDTO;
	}
	/**
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UserDto usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
}
