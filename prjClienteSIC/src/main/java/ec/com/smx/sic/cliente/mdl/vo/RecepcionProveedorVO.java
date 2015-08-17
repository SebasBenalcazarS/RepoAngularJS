package ec.com.smx.sic.cliente.mdl.vo;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.plantillas.dto.ConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.GrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.frameworkv2.multicompany.dto.UserCompanySystemDto;
import ec.com.smx.sic.cliente.common.bodega.EnumTipoChecklist;
import ec.com.smx.sic.cliente.common.bodega.EnumTipoEntrega;
import ec.com.smx.sic.cliente.common.bodega.EnumTipoRecepcion;
import ec.com.smx.sic.cliente.common.bodega.EnumTipoPedido;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatoBasicoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

@SuppressWarnings("serial")
public class RecepcionProveedorVO extends BaseVO<RecepcionProveedorDTO> {
	
	private ProcesoLogisticoDTO procesoLogisticoDTO;
	
	private VistaProveedorDTO vistaProveedorDTO;
	
	private DatoBasicoProveedorDTO datoBasicoProveedorDTO;
	
	private AreaTrabajoDTO areaTrabajoDTO;
	
	private FuncionarioDTO funcionarioDTO;
	
	private TareaDTO tareaDTO;
	
	private EnumTipoPedido tipoPedido;
	
	private EnumTipoRecepcion tipoRecepcion;
	
	private EnumTipoEntrega tipoConfiguracionEntrega;
	
	private Date fechaEntrega;
	
	private Date fechaRecepcion;
	
	private Time hora;
	
	private String placa;
	
	private Integer furgonesDisponibles;
	
	private Integer furgonesUtilizados;
	
	private Collection<BodegaDTO> bodegaDTOs;
	
	private BodegaDTO bodega;
	
	private BodegaDTO centroDistribucion;
	
	private EntregaDTO entregaDTO;
	
	private Collection<RecepcionProveedorDTO> recepcionProveedorDTOs;
	
	private Collection<DetalleSeccionDTO> andenes;
	
	private Collection<EntregaDTO> entregaDTOs;
	
	private EnumTipoChecklist tipoChecklist;
	
	private ConfiguracionPlantillaDTO configuracionPlantillaDTO;
	
	private Collection<DetalleSeccionDTO> andenesPendientes;
	
	private AutorizacionDTO autorizacionDTO;
	
	private Collection<AutorizacionDTO> autorizacionesPadres;
	
	private DetalleRecepcionEntregaDTO detalleRecepcionEntregaDTO;
	
	private Collection<GrupoCampoPlantillaDTO> preguntasAutorizar;
	
	private UserCompanySystemDto informacionUsurio;
	
	private Collection<DetalleCalendarioDTO> detalleCalendarioDTOs;
	
	private Long codigoEntregaDetalleCalendarioProveedor;
	
	private DetalleSeccionDTO andenAsignado;
	
	private ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO;
	
	/**
	 * @return the procesoLogisticoDTO
	 */
	public ProcesoLogisticoDTO getProcesoLogisticoDTO() {
		return procesoLogisticoDTO;
	}

	/**
	 * @param procesoLogisticoDTO the procesoLogisticoDTO to set
	 */
	public void setProcesoLogisticoDTO(ProcesoLogisticoDTO procesoLogisticoDTO) {
		this.procesoLogisticoDTO = procesoLogisticoDTO;
	}

	/**
	 * @return the vistaProveedorDTO
	 */
	public VistaProveedorDTO getVistaProveedorDTO() {
		return vistaProveedorDTO;
	}

	/**
	 * @param vistaProveedorDTO the vistaProveedorDTO to set
	 */
	public void setVistaProveedorDTO(VistaProveedorDTO vistaProveedorDTO) {
		this.vistaProveedorDTO = vistaProveedorDTO;
	}

	/**
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

	/**
	 * @return the tareaDTO
	 */
	public TareaDTO getTareaDTO() {
		return tareaDTO;
	}

	/**
	 * @param tareaDTO the tareaDTO to set
	 */
	public void setTareaDTO(TareaDTO tareaDTO) {
		this.tareaDTO = tareaDTO;
	}

	/**
	 * @return the funcionarioDTO
	 */
	public FuncionarioDTO getFuncionarioDTO() {
		return funcionarioDTO;
	}

	/**
	 * @param funcionarioDTO the funcionarioDTO to set
	 */
	public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
		this.funcionarioDTO = funcionarioDTO;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the datoBasicoProveedorDTO
	 */
	public DatoBasicoProveedorDTO getDatoBasicoProveedorDTO() {
		return datoBasicoProveedorDTO;
	}

	/**
	 * @param datoBasicoProveedorDTO the datoBasicoProveedorDTO to set
	 */
	public void setDatoBasicoProveedorDTO(DatoBasicoProveedorDTO datoBasicoProveedorDTO) {
		this.datoBasicoProveedorDTO = datoBasicoProveedorDTO;
	}

	/**
	 * @return the furgonesDisponible
	 */
	public Integer getFurgonesDisponibles() {
		return furgonesDisponibles;
	}

	/**
	 * @param furgonesDisponible the furgonesDisponible to set
	 */
	public void setFurgonesDisponibles(Integer furgonesDisponibles) {
		this.furgonesDisponibles = furgonesDisponibles;
	}

	/**
	 * @return the furgonesUtilizados
	 */
	public Integer getFurgonesUtilizados() {
		return furgonesUtilizados;
	}

	/**
	 * @param furgonesUtilizados the furgonesUtilizados to set
	 */
	public void setFurgonesUtilizados(Integer furgonesUtilizados) {
		this.furgonesUtilizados = furgonesUtilizados;
	}

	/**
	 * @return the bodegaDTOs
	 */
	public Collection<BodegaDTO> getBodegaDTOs() {
		return bodegaDTOs;
	}

	/**
	 * @param bodegaDTOs the bodegaDTOs to set
	 */
	public void setBodegaDTOs(Collection<BodegaDTO> bodegaDTOs) {
		this.bodegaDTOs = bodegaDTOs;
	}

	/**
	 * @return the fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	/**
	 * @return the hora
	 */
	public Time getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(Time hora) {
		this.hora = hora;
	}

	/**
	 * @return the bodega
	 */
	public BodegaDTO getBodega() {
		return bodega;
	}

	/**
	 * @param bodega the bodega to set
	 */
	public void setBodega(BodegaDTO bodega) {
		this.bodega = bodega;
	}

	/**
	 * @return the centroDistribucion
	 */
	public BodegaDTO getCentroDistribucion() {
		return centroDistribucion;
	}

	/**
	 * @param centroDistribucion the centroDistribucion to set
	 */
	public void setCentroDistribucion(BodegaDTO centroDistribucion) {
		this.centroDistribucion = centroDistribucion;
	}

	/**
	 * @return the recepcionProveedorDTOs
	 */
	public Collection<RecepcionProveedorDTO> getRecepcionProveedorDTOs() {
		return recepcionProveedorDTOs;
	}

	/**
	 * @param recepcionProveedorDTOs the recepcionProveedorDTOs to set
	 */
	public void setRecepcionProveedorDTOs(Collection<RecepcionProveedorDTO> recepcionProveedorDTOs) {
		this.recepcionProveedorDTOs = recepcionProveedorDTOs;
	}

	/**
	 * @return the entregaDTO
	 */
	public EntregaDTO getEntregaDTO() {
		return entregaDTO;
	}

	/**
	 * @param entregaDTO the entregaDTO to set
	 */
	public void setEntregaDTO(EntregaDTO entregaDTO) {
		this.entregaDTO = entregaDTO;
	}

	/**
	 * @return the entregaDTOs
	 */
	public Collection<EntregaDTO> getEntregaDTOs() {
		return entregaDTOs;
	}

	/**
	 * @param entregaDTOs the entregaDTOs to set
	 */
	public void setEntregaDTOs(Collection<EntregaDTO> entregaDTOs) {
		this.entregaDTOs = entregaDTOs;
	}

	/**
	 * @return the andenes
	 */
	public Collection<DetalleSeccionDTO> getAndenes() {
		return andenes;
	}

	/**
	 * @param andenes the andenes to set
	 */
	public void setAndenes(Collection<DetalleSeccionDTO> andenes) {
		this.andenes = andenes;
	}

	/**
	 * @return the configuracionPlantillaDTO
	 */
	public ConfiguracionPlantillaDTO getConfiguracionPlantillaDTO() {
		return configuracionPlantillaDTO;
	}

	/**
	 * @param configuracionPlantillaDTO the configuracionPlantillaDTO to set
	 */
	public void setConfiguracionPlantillaDTO(ConfiguracionPlantillaDTO configuracionPlantillaDTO) {
		this.configuracionPlantillaDTO = configuracionPlantillaDTO;
	}

	/**
	 * @return the andenesPendientes
	 */
	public Collection<DetalleSeccionDTO> getAndenesPendientes() {
		return andenesPendientes;
	}

	/**
	 * @param andenesPendientes the andenesPendientes to set
	 */
	public void setAndenesPendientes(Collection<DetalleSeccionDTO> andenesPendientes) {
		this.andenesPendientes = andenesPendientes;
	}

	/**
	 * @return the autorizacionDTO
	 */
	public final AutorizacionDTO getAutorizacionDTO() {
		return autorizacionDTO;
	}

	/**
	 * @param autorizacionDTO the autorizacionDTO to set
	 */
	public final void setAutorizacionDTO(AutorizacionDTO autorizacionDTO) {
		this.autorizacionDTO = autorizacionDTO;
	}

	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the autorizacionesPadres
	 */
	public Collection<AutorizacionDTO> getAutorizacionesPadres() {
		return autorizacionesPadres;
	}

	/**
	 * @param autorizacionesPadres the autorizacionesPadres to set
	 */
	public void setAutorizacionesPadres(Collection<AutorizacionDTO> autorizacionesPadres) {
		this.autorizacionesPadres = autorizacionesPadres;
	}

	/**
	 * @return the preguntasAutorizar
	 */
	public Collection<GrupoCampoPlantillaDTO> getPreguntasAutorizar() {
		return preguntasAutorizar;
	}

	/**
	 * @param preguntasAutorizar the preguntasAutorizar to set
	 */
	public void setPreguntasAutorizar(Collection<GrupoCampoPlantillaDTO> preguntasAutorizar) {
		this.preguntasAutorizar = preguntasAutorizar;
	}

	/**
	 * @return the informacionUsurio
	 */
	public UserCompanySystemDto getInformacionUsurio() {
		return informacionUsurio;
	}

	/**
	 * @param informacionUsurio the informacionUsurio to set
	 */
	public void setInformacionUsurio(UserCompanySystemDto informacionUsurio) {
		this.informacionUsurio = informacionUsurio;
	}

	/**
	 * @return the detalleCalendarioDTOs
	 */
	public Collection<DetalleCalendarioDTO> getDetalleCalendarioDTOs() {
		return detalleCalendarioDTOs;
	}

	/**
	 * @param detalleCalendarioDTOs the detalleCalendarioDTOs to set
	 */
	public void setDetalleCalendarioDTOs(Collection<DetalleCalendarioDTO> detalleCalendarioDTOs) {
		this.detalleCalendarioDTOs = detalleCalendarioDTOs;
	}

	/**
	 * @return the tipoConfiguracionRecepcion
	 */
	public EnumTipoRecepcion getTipoRecepcion() {
		return tipoRecepcion;
	}

	/**
	 * @param tipoRecepcion the tipoRecepcion to set
	 */
	public void setTipoRecepcion(EnumTipoRecepcion tipoRecepcion) {
		this.tipoRecepcion = tipoRecepcion;
	}

	/**
	 * @return the tipoPedido
	 */
	public EnumTipoPedido getTipoPedido() {
		return tipoPedido;
	}

	/**
	 * @param tipoPedido the tipoPedido to set
	 */
	public void setTipoPedido(EnumTipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	/**
	 * @return the tipoChecklist
	 */
	public EnumTipoChecklist getTipoChecklist() {
		return tipoChecklist;
	}

	/**
	 * @param tipoChecklist the tipoChecklist to set
	 */
	public void setTipoChecklist(EnumTipoChecklist tipoChecklist) {
		this.tipoChecklist = tipoChecklist;
	}

	/**
	 * @return the codigoEntregaDetalleCalendarioProveedor
	 */
	public Long getCodigoEntregaDetalleCalendarioProveedor() {
		return codigoEntregaDetalleCalendarioProveedor;
	}

	/**
	 * @param codigoEntregaDetalleCalendarioProveedor the codigoEntregaDetalleCalendarioProveedor to set
	 */
	public void setCodigoEntregaDetalleCalendarioProveedor(Long codigoEntregaDetalleCalendarioProveedor) {
		this.codigoEntregaDetalleCalendarioProveedor = codigoEntregaDetalleCalendarioProveedor;
	}

	/**
	 * @return the andenAsignado
	 */
	public DetalleSeccionDTO getAndenAsignado() {
		return andenAsignado;
	}

	/**
	 * @param andenAsignado the andenAsignado to set
	 */
	public void setAndenAsignado(DetalleSeccionDTO andenAsignado) {
		this.andenAsignado = andenAsignado;
	}

	/**
	 * @return the detalleRecepcionEntregaDTO
	 */
	public DetalleRecepcionEntregaDTO getDetalleRecepcionEntregaDTO() {
		return detalleRecepcionEntregaDTO;
	}

	/**
	 * @param detalleRecepcionEntregaDTO the detalleRecepcionEntregaDTO to set
	 */
	public void setDetalleRecepcionEntregaDTO(DetalleRecepcionEntregaDTO detalleRecepcionEntregaDTO) {
		this.detalleRecepcionEntregaDTO = detalleRecepcionEntregaDTO;
	}

	/**
	 * @return the valorConfiguracionPlantillaDTO
	 */
	public ValorConfiguracionPlantillaDTO getValorConfiguracionPlantillaDTO() {
		return valorConfiguracionPlantillaDTO;
	}

	/**
	 * @param valorConfiguracionPlantillaDTO the valorConfiguracionPlantillaDTO to set
	 */
	public void setValorConfiguracionPlantillaDTO(ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO) {
		this.valorConfiguracionPlantillaDTO = valorConfiguracionPlantillaDTO;
	}

	/**
	 * @return the tipoConfiguracionEntrega
	 */
	public EnumTipoEntrega getTipoEntrega() {
		return tipoConfiguracionEntrega;
	}

	/**
	 * @param tipoConfiguracionEntrega the tipoConfiguracionEntrega to set
	 */
	public void setTipoEntrega(EnumTipoEntrega tipoConfiguracionEntrega) {
		this.tipoConfiguracionEntrega = tipoConfiguracionEntrega;
	}

}
