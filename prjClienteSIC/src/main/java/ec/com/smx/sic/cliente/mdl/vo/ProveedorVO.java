package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.common.proveedor.CodigoResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoEstadoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;



public class ProveedorVO extends CaracteristicaProveedorVO{


	private static final long serialVersionUID = 1L;

	private String npTipoProveedor;
	private FuncionarioDTO funcionarioProveedor; 
	private Long npCodigoProveedor;
	private String npNumeroRuc;
	private Boolean crearRoles = false;
	private Boolean interproveedor;
	private Boolean importado;
	private Boolean participaciones;
	private Boolean esSuperUsuario = Boolean.FALSE;		// Pregunta si un proveedor es SuperUsuario o no
	private String numeroRUCFinanciero; 
	private CodigoResultadoValidacionProveedor codigoValidacionJDE;
	private ParametrosProveedorVO parametrosProveedorVO;
	private IIdentificadorProveedorVO identificadorProveedorVO;
	private Collection<UsuarioProveedor> usuariosProveedor;
	private TipoProveedor tipoProveedor;
	private TipoEstadoProveedor tipoEstadoProveedor;
	private String secuencialConfiguracionNivelPagoActual;
	private String observacionCambioSecuencialConfiguracionNivelPagoActual;
	private Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados;
	private String accesItemID;
	private Boolean esArticulo;
	private Boolean esServicio;
	
	/**
	 * @return the secuencialConfiguracionNivelPagoActual
	 */
	public String getSecuencialConfiguracionNivelPagoActual() {
		return secuencialConfiguracionNivelPagoActual;
	}

	/**
	 * @param secuencialConfiguracionNivelPagoActual the secuencialConfiguracionNivelPagoActual to set
	 */
	public void setSecuencialConfiguracionNivelPagoActual(String secuencialConfiguracionNivelPagoActual) {
		this.secuencialConfiguracionNivelPagoActual = secuencialConfiguracionNivelPagoActual;
	}

	/**
	 * @return the npNumeroRuc
	 */
	public String getNpNumeroRuc() {
		return npNumeroRuc;
	}

	/**
	 * @param npNumeroRuc the npNumeroRuc to set
	 */
	public void setNpNumeroRuc(String npNumeroRuc) {
		this.npNumeroRuc = npNumeroRuc;
	}

	/**
	 * @return the npTipoProveedor
	 */
	public String getNpTipoProveedor() {
		return npTipoProveedor;
	}

	/**
	 * @param npTipoProveedor the npTipoProveedor to set
	 */
	public void setNpTipoProveedor(String npTipoProveedor) {
		this.npTipoProveedor = npTipoProveedor;
	}

	/**
	 * @return the funcionarioProveedor
	 */
	public FuncionarioDTO getFuncionarioProveedor() {
		return funcionarioProveedor;
	}

	/**
	 * @param funcionarioProveedor the funcionarioProveedor to set
	 */
	public void setFuncionarioProveedor(FuncionarioDTO funcionarioProveedor) {
		this.funcionarioProveedor = funcionarioProveedor;
	}

	/**
	 * @return the crearRoles
	 */
	public Boolean getCrearRoles() {
		return crearRoles;
	}

	/**
	 * @param crearRoles the crearRoles to set
	 */
	public void setCrearRoles(Boolean crearRoles) {
		this.crearRoles = crearRoles;
	}

	/**
	 * @return the interproveedor
	 */
	public Boolean getInterproveedor() {
		return interproveedor;
	}

	/**
	 * @param interproveedor the interproveedor to set
	 */
	public void setInterproveedor(Boolean interproveedor) {
		this.interproveedor = interproveedor;
	}

	/**
	 * @return the importado
	 */
	public Boolean getImportado() {
		return importado;
	}

	/**
	 * @param importado the importado to set
	 */
	public void setImportado(Boolean importado) {
		this.importado = importado;
	}

	/**
	 * @return the participaciones
	 */
	public Boolean getParticipaciones() {
		return participaciones;
	}

	/**
	 * @param participaciones the participaciones to set
	 */
	public void setParticipaciones(Boolean participaciones) {
		this.participaciones = participaciones;
	}

	/**
	 * @return the npCodigoProveedor
	 */
	public Long getNpCodigoProveedor() {
		return npCodigoProveedor;
	}

	/**
	 * @param npCodigoProveedor the npCodigoProveedor to set
	 */
	public void setNpCodigoProveedor(Long npCodigoProveedor) {
		this.npCodigoProveedor = npCodigoProveedor;
	}

	/**
	 * @return the numeroRUCFinanciero
	 */
	public String getNumeroRUCFinanciero() {
		return numeroRUCFinanciero;
	}

	/**
	 * @param numeroRUCFinanciero the numeroRUCFinanciero to set
	 */
	public void setNumeroRUCFinanciero(String numeroRUCFinanciero) {
		this.numeroRUCFinanciero = numeroRUCFinanciero;
	}

	/**
	 * @return the codigoValidacionJDE
	 */
	public CodigoResultadoValidacionProveedor getCodigoValidacionJDE() {
		return codigoValidacionJDE;
	}

	/**
	 * @param codigoValidacionJDE the codigoValidacionJDE to set
	 */
	public void setCodigoValidacionJDE(CodigoResultadoValidacionProveedor codigoValidacionJDE) {
		this.codigoValidacionJDE = codigoValidacionJDE;
	}

	/**
	 * @return the parametrosProveedorVO
	 */
	public ParametrosProveedorVO getParametrosProveedorVO() {
		return parametrosProveedorVO;
	}

	/**
	 * @param parametrosProveedorVO the parametrosProveedorVO to set
	 */
	public void setParametrosProveedorVO(ParametrosProveedorVO parametrosProveedorVO) {
		this.parametrosProveedorVO = parametrosProveedorVO;
	}

	/**
	 * @return the identificadorProveedorVO
	 */
	public IIdentificadorProveedorVO getIdentificadorProveedorVO() {
		return identificadorProveedorVO;
	}

	/**
	 * @param identificadorProveedorVO the identificadorProveedorVO to set
	 */
	public void setIdentificadorProveedorVO(IIdentificadorProveedorVO identificadorProveedorVO) {
		this.identificadorProveedorVO = identificadorProveedorVO;
	}

	/**
	 * @return the tipoProveedor
	 */
	public TipoProveedor getTipoProveedor() {
		return tipoProveedor;
	}

	/**
	 * @param tipoProveedor the tipoProveedor to set
	 */
	public void setTipoProveedor(TipoProveedor tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}

	/**
	 * @return the tipoEstadoProveedor
	 */
	public TipoEstadoProveedor getTipoEstadoProveedor() {
		return tipoEstadoProveedor;
	}

	/**
	 * @param tipoEstadoProveedor the tipoEstadoProveedor to set
	 */
	public void setTipoEstadoProveedor(TipoEstadoProveedor tipoEstadoProveedor) {
		this.tipoEstadoProveedor = tipoEstadoProveedor;
	}

	/**
	 * @return the usuariosProveedor
	 */
	public Collection<UsuarioProveedor> getUsuariosProveedor() {
		return usuariosProveedor;
	}

	/**
	 * @param usuariosProveedor the usuariosProveedor to set
	 */
	public void setUsuariosProveedor(Collection<UsuarioProveedor> usuariosProveedor) {
		this.usuariosProveedor = usuariosProveedor;
	}

	/**
	 * @return the observacionCambioSecuencialConfiguracionNivelPagoActual
	 */
	public String getObservacionCambioSecuencialConfiguracionNivelPagoActual() {
		return observacionCambioSecuencialConfiguracionNivelPagoActual;
	}

	/**
	 * @param observacionCambioSecuencialConfiguracionNivelPagoActual the observacionCambioSecuencialConfiguracionNivelPagoActual to set
	 */
	public void setObservacionCambioSecuencialConfiguracionNivelPagoActual(String observacionCambioSecuencialConfiguracionNivelPagoActual) {
		this.observacionCambioSecuencialConfiguracionNivelPagoActual = observacionCambioSecuencialConfiguracionNivelPagoActual;
	}

	/**
	 * @return the contactosRelacionados
	 */
	public Collection<DatoContactoPersonaLocalizacionDTO> getContactosRelacionados() {
		return contactosRelacionados;
	}

	/**
	 * @param contactosRelacionados the contactosRelacionados to set
	 */
	public void setContactosRelacionados(Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados) {
		this.contactosRelacionados = contactosRelacionados;
	}

	/**
	 * @return the esSuperUsuario
	 */
	public Boolean getEsSuperUsuario() {
		return esSuperUsuario;
	}

	/**
	 * @param esSuperUsuario the esSuperUsuario to set
	 */
	public void setEsSuperUsuario(Boolean esSuperUsuario) {
		this.esSuperUsuario = esSuperUsuario;
	}

	/**
	 * @return the accesItemID
	 */
	public String getAccesItemID() {
		return accesItemID;
	}

	/**
	 * @param accesItemID the accesItemID to set
	 */
	public void setAccesItemID(String accesItemID) {
		this.accesItemID = accesItemID;
	}

	/**
	 * @return the esArticulo
	 */
	public Boolean getEsArticulo() {
		return esArticulo;
	}

	/**
	 * @param esArticulo the esArticulo to set
	 */
	public void setEsArticulo(Boolean esArticulo) {
		this.esArticulo = esArticulo;
	}

	/**
	 * @return the esServicio
	 */
	public Boolean getEsServicio() {
		return esServicio;
	}

	/**
	 * @param esServicio the esServicio to set
	 */
	public void setEsServicio(Boolean esServicio) {
		this.esServicio = esServicio;
	}

}
