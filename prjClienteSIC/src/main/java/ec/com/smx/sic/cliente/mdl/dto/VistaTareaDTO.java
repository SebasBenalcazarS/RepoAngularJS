package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaTareaID;

@SuppressWarnings("serial")
public class VistaTareaDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaTareaID id = new VistaTareaID();

	private Long secuencialTarea;
	
	private Integer codigoEstadoTarea;
	private String valorEstadoTarea;
	private Long codigoTipoTareaPerfil;
	private Long codigoTipoTarea;
	private String codigoReferenciaTipoTarea;
	
	private Integer codigoAreaTrabajo;
	private Integer codigoAreaSubLugarTrabajo;
	
	private Integer codigoAreaTrabajoCD;
	private Integer codigoAreaTrabajoBOD;
	private Integer codigoAreaTrabajoSUB;
	
	private Integer codigoReferenciaCD;
	private Integer codigoReferenciaBOD;
	private Integer codigoReferenciaSUB;
	
	private String codigoFuncionario;
	private String codigoPerfil;

	private Date fechaRegistro;
	private Date fechaAsignacion;
	
	private Date fechaRecepcion;
	
	private Long codigoProcesoLogistico;
	private Long secuencialProcesoLogistico;
	private Integer codigoEstadoProcesoLogistico;
	private String valorEstadoProcesoLogistico;
	
	private Long codigoRecepcionProveedor;
	private Long secuencialRecepcionProveedor;
	private String valorTipoRecepcion;
	private Boolean activarEscaneoManual;
	
	private String codigoProveedor ;
	private String codigoJDEProveedor;
	private String nombreProveedor;
	
	private Integer cantidadAndenes;
	private String andenReferencia;
	
	private Long codigoDetalleTarea;
	private Long codigoDetalleSeccion;
	
	/**
	 * @return the id
	 */
	public VistaTareaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaTareaID id) {
		this.id = id;
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
	 * @return the codigoTipoTareaPerfil
	 */
	public Long getCodigoTipoTareaPerfil() {
		return codigoTipoTareaPerfil;
	}

	/**
	 * @param codigoTipoTareaPerfil the codigoTipoTareaPerfil to set
	 */
	public void setCodigoTipoTareaPerfil(Long codigoTipoTareaPerfil) {
		this.codigoTipoTareaPerfil = codigoTipoTareaPerfil;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the codigoEstadoTarea
	 */
	public Integer getCodigoEstadoTarea() {
		return codigoEstadoTarea;
	}

	/**
	 * @param codigoEstadoTarea the codigoEstadoTarea to set
	 */
	public void setCodigoEstadoTarea(Integer codigoEstadoTarea) {
		this.codigoEstadoTarea = codigoEstadoTarea;
	}

	/**
	 * @return the valorEstadoTarea
	 */
	public String getValorEstadoTarea() {
		return valorEstadoTarea;
	}

	/**
	 * @param valorEstadoTarea the valorEstadoTarea to set
	 */
	public void setValorEstadoTarea(String valorEstadoTarea) {
		this.valorEstadoTarea = valorEstadoTarea;
	}

	/**
	 * @return the codigoTipoTarea
	 */
	public Long getCodigoTipoTarea() {
		return codigoTipoTarea;
	}

	/**
	 * @param codigoTipoTarea the codigoTipoTarea to set
	 */
	public void setCodigoTipoTarea(Long codigoTipoTarea) {
		this.codigoTipoTarea = codigoTipoTarea;
	}

	/**
	 * @return the codigoReferenciaTipoTarea
	 */
	public String getCodigoReferenciaTipoTarea() {
		return codigoReferenciaTipoTarea;
	}

	/**
	 * @param codigoReferenciaTipoTarea the codigoReferenciaTipoTarea to set
	 */
	public void setCodigoReferenciaTipoTarea(String codigoReferenciaTipoTarea) {
		this.codigoReferenciaTipoTarea = codigoReferenciaTipoTarea;
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
	 * @return the codigoAreaSubLugarTrabajo
	 */
	public Integer getCodigoAreaSubLugarTrabajo() {
		return codigoAreaSubLugarTrabajo;
	}

	/**
	 * @param codigoAreaSubLugarTrabajo the codigoAreaSubLugarTrabajo to set
	 */
	public void setCodigoAreaSubLugarTrabajo(Integer codigoAreaSubLugarTrabajo) {
		this.codigoAreaSubLugarTrabajo = codigoAreaSubLugarTrabajo;
	}

	/**
	 * @return the codigoEstadoProcesoLogistico
	 */
	public Integer getCodigoEstadoProcesoLogistico() {
		return codigoEstadoProcesoLogistico;
	}

	/**
	 * @param codigoEstadoProcesoLogistico the codigoEstadoProcesoLogistico to set
	 */
	public void setCodigoEstadoProcesoLogistico(Integer codigoEstadoProcesoLogistico) {
		this.codigoEstadoProcesoLogistico = codigoEstadoProcesoLogistico;
	}

	/**
	 * @return the valorEstadoProcesoLogistico
	 */
	public String getValorEstadoProcesoLogistico() {
		return valorEstadoProcesoLogistico;
	}

	/**
	 * @param valorEstadoProcesoLogistico the valorEstadoProcesoLogistico to set
	 */
	public void setValorEstadoProcesoLogistico(String valorEstadoProcesoLogistico) {
		this.valorEstadoProcesoLogistico = valorEstadoProcesoLogistico;
	}

	/**
	 * @return the codigoRecepcionProveedor
	 */
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}

	/**
	 * @param codigoRecepcionProveedor the codigoRecepcionProveedor to set
	 */
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the codigoJDEProveedor
	 */
	public String getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}

	/**
	 * @param codigoJDEProveedor the codigoJDEProveedor to set
	 */
	public void setCodigoJDEProveedor(String codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}

	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	/**
	 * @return the cantidadAndenes
	 */
	public Integer getCantidadAndenes() {
		return cantidadAndenes;
	}

	/**
	 * @param cantidadAndenes the cantidadAndenes to set
	 */
	public void setCantidadAndenes(Integer cantidadAndenes) {
		this.cantidadAndenes = cantidadAndenes;
	}

	/**
	 * @return the andenReferencia
	 */
	public String getAndenReferencia() {
		return andenReferencia;
	}

	/**
	 * @param andenReferencia the andenReferencia to set
	 */
	public void setAndenReferencia(String andenReferencia) {
		this.andenReferencia = andenReferencia;
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
	 * @return the codigoPerfil
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	/**
	 * @return the fechaAsignacion
	 */
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * @param fechaAsignacion the fechaAsignacion to set
	 */
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
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
	 * @return the codigoDetalleTarea
	 */
	public Long getCodigoDetalleTarea() {
		return codigoDetalleTarea;
	}

	/**
	 * @param codigoDetalleTarea the codigoDetalleTarea to set
	 */
	public void setCodigoDetalleTarea(Long codigoDetalleTarea) {
		this.codigoDetalleTarea = codigoDetalleTarea;
	}

	/**
	 * @return the codigoDetalleSeccion
	 */
	public Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	/**
	 * @return the codigoAreaTrabajoCD
	 */
	public Integer getCodigoAreaTrabajoCD() {
		return codigoAreaTrabajoCD;
	}

	/**
	 * @param codigoAreaTrabajoCD the codigoAreaTrabajoCD to set
	 */
	public void setCodigoAreaTrabajoCD(Integer codigoAreaTrabajoCD) {
		this.codigoAreaTrabajoCD = codigoAreaTrabajoCD;
	}

	/**
	 * @return the codigoReferenciaCD
	 */
	public Integer getCodigoReferenciaCD() {
		return codigoReferenciaCD;
	}

	/**
	 * @param codigoReferenciaCD the codigoReferenciaCD to set
	 */
	public void setCodigoReferenciaCD(Integer codigoReferenciaCD) {
		this.codigoReferenciaCD = codigoReferenciaCD;
	}

	/**
	 * @return the codigoReferenciaBOD
	 */
	public Integer getCodigoReferenciaBOD() {
		return codigoReferenciaBOD;
	}

	/**
	 * @param codigoReferenciaBOD the codigoReferenciaBOD to set
	 */
	public void setCodigoReferenciaBOD(Integer codigoReferenciaBOD) {
		this.codigoReferenciaBOD = codigoReferenciaBOD;
	}

	/**
	 * @return the codigoReferenciaSUB
	 */
	public Integer getCodigoReferenciaSUB() {
		return codigoReferenciaSUB;
	}

	/**
	 * @param codigoReferenciaSUB the codigoReferenciaSUB to set
	 */
	public void setCodigoReferenciaSUB(Integer codigoReferenciaSUB) {
		this.codigoReferenciaSUB = codigoReferenciaSUB;
	}

	/**
	 * @return the codigoAreaTrabajoBOD
	 */
	public Integer getCodigoAreaTrabajoBOD() {
		return codigoAreaTrabajoBOD;
	}

	/**
	 * @param codigoAreaTrabajoBOD the codigoAreaTrabajoBOD to set
	 */
	public void setCodigoAreaTrabajoBOD(Integer codigoAreaTrabajoBOD) {
		this.codigoAreaTrabajoBOD = codigoAreaTrabajoBOD;
	}

	/**
	 * @return the codigoAreaTrabajoSUB
	 */
	public Integer getCodigoAreaTrabajoSUB() {
		return codigoAreaTrabajoSUB;
	}

	/**
	 * @param codigoAreaTrabajoSUB the codigoAreaTrabajoSUB to set
	 */
	public void setCodigoAreaTrabajoSUB(Integer codigoAreaTrabajoSUB) {
		this.codigoAreaTrabajoSUB = codigoAreaTrabajoSUB;
	}

	/**
	 * @return the valorTipoRecepcion
	 */
	public String getValorTipoRecepcion() {
		return valorTipoRecepcion;
	}

	/**
	 * @param valorTipoRecepcion the valorTipoRecepcion to set
	 */
	public void setValorTipoRecepcion(String valorTipoRecepcion) {
		this.valorTipoRecepcion = valorTipoRecepcion;
	}

	/**
	 * @return the activarEscaneoManual
	 */
	public Boolean getActivarEscaneoManual() {
		return activarEscaneoManual;
	}

	/**
	 * @param activarEscaneoManual the activarEscaneoManual to set
	 */
	public void setActivarEscaneoManual(Boolean activarEscaneoManual) {
		this.activarEscaneoManual = activarEscaneoManual;
	}

	/**
	 * @return the secuencialTarea
	 */
	public Long getSecuencialTarea() {
		return secuencialTarea;
	}

	/**
	 * @param secuencialTarea the secuencialTarea to set
	 */
	public void setSecuencialTarea(Long secuencialTarea) {
		this.secuencialTarea = secuencialTarea;
	}

	/**
	 * @return the secuencialProcesoLogistico
	 */
	public Long getSecuencialProcesoLogistico() {
		return secuencialProcesoLogistico;
	}

	/**
	 * @param secuencialProcesoLogistico the secuencialProcesoLogistico to set
	 */
	public void setSecuencialProcesoLogistico(Long secuencialProcesoLogistico) {
		this.secuencialProcesoLogistico = secuencialProcesoLogistico;
	}

	/**
	 * @return the secuencialRecepcionProveedor
	 */
	public Long getSecuencialRecepcionProveedor() {
		return secuencialRecepcionProveedor;
	}

	/**
	 * @param secuencialRecepcionProveedor the secuencialRecepcionProveedor to set
	 */
	public void setSecuencialRecepcionProveedor(Long secuencialRecepcionProveedor) {
		this.secuencialRecepcionProveedor = secuencialRecepcionProveedor;
	}
	
}
