package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.DetalleConfiguracionProcesoPerfilDTO;
import ec.com.smx.corpv2.dto.FuncionarioLogisticoDTO;

/**
 * @author cpescobar
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public class MantenimientoUsuariosBodegaVO extends BaseVO<MantenimientoUsuariosBodegaVO> implements Serializable {

	private Integer codigoCompania;
	
	private String userId;
	
	private String cuentaUsuario;
	
	private String nombreUsuario;
	
	private String codigoFuncionario;
	
	private FuncionarioLogisticoDTO funcionarioLogisticoDTO;
	
	private AreaTrabajoDTO areaTrabajoSeleccionada;
	
	private AreaTrabajoDTO areaTrabajoPorDefecto;
	
	private DetalleConfiguracionProcesoPerfilDTO procesoPerfilPorDefecto;
	
	private Collection<DetalleConfiguracionProcesoPerfilDTO> detalleConfiguracionProcesoPerfilCol;
	
	private Collection<Long> codigoDetalleSeccion;

	/**
	 * @return the detalleConfiguracionProcesoPerfilCol
	 */
	public Collection<DetalleConfiguracionProcesoPerfilDTO> getDetalleConfiguracionProcesoPerfilCol() {
		return detalleConfiguracionProcesoPerfilCol;
	}

	/**
	 * @param detalleConfiguracionProcesoPerfilCol the detalleConfiguracionProcesoPerfilCol to set
	 */
	public void setDetalleConfiguracionProcesoPerfilCol(Collection<DetalleConfiguracionProcesoPerfilDTO> detalleConfiguracionProcesoPerfilCol) {
		this.detalleConfiguracionProcesoPerfilCol = detalleConfiguracionProcesoPerfilCol;
	}

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the cuentaUsuario
	 */
	public String getCuentaUsuario() {
		return cuentaUsuario;
	}

	/**
	 * @param cuentaUsuario the cuentaUsuario to set
	 */
	public void setCuentaUsuario(String cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	/**
	 * @return the funcionarioLogisticoDTO 
	 */
	public FuncionarioLogisticoDTO getFuncionarioLogisticoDTO() {
		return funcionarioLogisticoDTO;
	}

	/**
	 * @param funcionarioLogisticoDTO the funcionarioLogisticoDTO to set 
	 */
	public void setFuncionarioLogisticoDTO(FuncionarioLogisticoDTO funcionarioLogisticoDTO) {
		this.funcionarioLogisticoDTO = funcionarioLogisticoDTO;
	}

	/**
	 * @return the areaTrabajoSeleccionada
	 */
	public AreaTrabajoDTO getAreaTrabajoSeleccionada() {
		return areaTrabajoSeleccionada;
	}

	/**
	 * @param areaTrabajoSeleccionada the areaTrabajoSeleccionada to set
	 */
	public void setAreaTrabajoSeleccionada(AreaTrabajoDTO areaTrabajoSeleccionada) {
		this.areaTrabajoSeleccionada = areaTrabajoSeleccionada;
	}

	/**
	 * @return the codigoDetalleSeccion
	 */
	public Collection<Long> getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(Collection<Long> codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}
	
	/**
	 * @return the areaTrabajoPorDefecto
	 */
	public AreaTrabajoDTO getAreaTrabajoPorDefecto() {
		return areaTrabajoPorDefecto;
	}

	/**
	 * @param areaTrabajoPorDefecto the areaTrabajoPorDefecto to set
	 */
	public void setAreaTrabajoPorDefecto(AreaTrabajoDTO areaTrabajoPorDefecto) {
		this.areaTrabajoPorDefecto = areaTrabajoPorDefecto;
	}

	/**
	 * @return the procesoPerfilPorDefecto
	 */
	public DetalleConfiguracionProcesoPerfilDTO getProcesoPerfilPorDefecto() {
		return procesoPerfilPorDefecto;
	}

	/**
	 * @param procesoPerfilPorDefecto the procesoPerfilPorDefecto to set
	 */
	public void setProcesoPerfilPorDefecto(DetalleConfiguracionProcesoPerfilDTO procesoPerfilPorDefecto) {
		this.procesoPerfilPorDefecto = procesoPerfilPorDefecto;
	}
}
