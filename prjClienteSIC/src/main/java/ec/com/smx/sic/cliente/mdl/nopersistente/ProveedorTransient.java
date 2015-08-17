package ec.com.smx.sic.cliente.mdl.nopersistente;

import javax.persistence.Transient;

import ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BaseProveedorDTO;

@SuppressWarnings("serial")
@Deprecated
public abstract class ProveedorTransient extends BaseProveedorDTO {
	
	@Deprecated
	private String npCodigoTipoContacto;
	@Deprecated
    private String npCatalogoTipo;
	@Deprecated
    private Long npFiltroCodigoPeriodo;
	@Deprecated
    private Boolean registraParticipaciones;
	@Deprecated
    private String procesoEnvioMail;
	@Deprecated
    private Integer tiempoStock;
	@Deprecated
    private Double porcentajeComisionImp;
	@Deprecated
    private ConfiguracionNivelPagoDTO configuracionNivelPagoDTO;
    
	@Transient
	private Boolean selected;
	/**
	 * @return the npCodigoTipoContacto
	 */
    @Deprecated
	public String getNpCodigoTipoContacto() {
		return npCodigoTipoContacto;
	}
	/**
	 * @param npCodigoTipoContacto the npCodigoTipoContacto to set
	 */
    @Deprecated
	public void setNpCodigoTipoContacto(String npCodigoTipoContacto) {
		this.npCodigoTipoContacto = npCodigoTipoContacto;
	}
	/**
	 * @return the npCatalogoTipo
	 */
    @Deprecated
	public String getNpCatalogoTipo() {
		return npCatalogoTipo;
	}
	/**
	 * @param npCatalogoTipo the npCatalogoTipo to set
	 */
    @Deprecated
	public void setNpCatalogoTipo(String npCatalogoTipo) {
		this.npCatalogoTipo = npCatalogoTipo;
	}
	/**
	 * @return the npFiltroCodigoPeriodo
	 */
    @Deprecated
	public Long getNpFiltroCodigoPeriodo() {
		return npFiltroCodigoPeriodo;
	}
	/**
	 * @param npFiltroCodigoPeriodo the npFiltroCodigoPeriodo to set
	 */
    @Deprecated
	public void setNpFiltroCodigoPeriodo(Long npFiltroCodigoPeriodo) {
		this.npFiltroCodigoPeriodo = npFiltroCodigoPeriodo;
	}
	/**
	 * @return the registraParticipaciones
	 */
    @Deprecated
	public Boolean getRegistraParticipaciones() {
		return registraParticipaciones;
	}
	/**
	 * @param registraParticipaciones the registraParticipaciones to set
	 */
    @Deprecated
	public void setRegistraParticipaciones(Boolean registraParticipaciones) {
		this.registraParticipaciones = registraParticipaciones;
	}
	/**
	 * @return the procesoEnvioMail
	 */
    @Deprecated
	public String getProcesoEnvioMail() {
		return procesoEnvioMail;
	}
	/**
	 * @param procesoEnvioMail the procesoEnvioMail to set
	 */
    @Deprecated
	public void setProcesoEnvioMail(String procesoEnvioMail) {
		this.procesoEnvioMail = procesoEnvioMail;
	}
	/**
	 * @return the configuracionNivelPagoDTO
	 */
    @Deprecated
	public ConfiguracionNivelPagoDTO getConfiguracionNivelPagoDTO() {
		return configuracionNivelPagoDTO;
	}
	/**
	 * @param configuracionNivelPagoDTO the configuracionNivelPagoDTO to set
	 */
    @Deprecated
	public void setConfiguracionNivelPagoDTO(
			ConfiguracionNivelPagoDTO configuracionNivelPagoDTO) {
		this.configuracionNivelPagoDTO = configuracionNivelPagoDTO;
	}
	/**
	 * @return the tiempoStock
	 */
    @Deprecated
	public Integer getTiempoStock() {
		return tiempoStock;
	}
	/**
	 * @param tiempoStock the tiempoStock to set
	 */
    @Deprecated
	public void setTiempoStock(Integer tiempoStock) {
		this.tiempoStock = tiempoStock;
	}
	/**
	 * @return the porcentajeComisionImp
	 */
	@Deprecated
	public Double getPorcentajeComisionImp() {
		return porcentajeComisionImp;
	}
	/**
	 * @param porcentajeComisionImp the porcentajeComisionImp to set
	 */
	@Deprecated
	public void setPorcentajeComisionImp(Double porcentajeComisionImp) {
		this.porcentajeComisionImp = porcentajeComisionImp;
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
}
