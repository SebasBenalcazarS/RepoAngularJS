package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaMonitorMontacargaCorredorID;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings("serial")
public class VistaMonitorMontacargaCorredorDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaMonitorMontacargaCorredorID id = new VistaMonitorMontacargaCorredorID();
	
	//campos de la tabla TareaDTO - SBTARTTAREA
	private String estadoTarea;
	private String valorEstadoTarea;
	private String referenceCode;
	//campo de la tabla CatalogoValorDTO - SSPCOTCATALOGOVALOR
	private String valorCatalogoEstadoTarea;
	
	
	//campos de la tabla DetalleTareaDTO - SBTARTDETTAR
	private Integer orden;
	//campos de la tabla DetalleSeccionDTO - SBLOGTDETSEC
//	private Long idSeccionNave;
//	private String nombreSeccionNave;
	
	//campos de la tabla UserDto - KSSEGTUSER
	private String userName;
	
	//campos de la tabla TareaDatosTareaDTO - SBLOGTTARDATTAR
	private Long codigoTareaDatosTarea;
	
	//campos de la tabla DatosTareaDTO - SBLOGTDATTAR
	private Long codigoDatosTarea;
	private String codigoBarrasContenedor;
	private Integer codigoAreaTrabajo;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubBodega;
	private Integer cantidadArticulosPallet;
	private String valorEstadoDatosTarea;
	private String ubicacionActual;
	
	//campos de la tabla ArticuloUnidadManejoProveedorDTO - SCSADTARTUNIMANPRO
	@Transient
	private String codigoProveedor;
	
	//campos de la tabla ArticuloUnidadManejoDTO - SCSADTARTUNIMAN
	private Long codigoUnidadManejo;
	private Integer valorUnidadManejo;
	
	//campos de la tabla ArticuloDTO - SCSPETARTICULO
	private String codigoArticulo;
	private String descripcionArticulo;
	
	//campos de la tabla ArticuloBitacoraCodigoBarrasDTO - SCSADTARTBITCODBAR
	private String codigoBarras;
	private Date fechaFinalActivo;
	
	//campos de la tabla ArticuloMedidaDTO - SCSADTARTMED
	private String referenciaMedida;
	private Double cantidadMedida;
	
	//campos de la tabla AreaTrabajoDTO - SSPCOTAREATRABAJO para el DC
	private Integer codigoReferenciaCD;
	private String nombreAreaTrabajoCD;
	
	//campos de la tabla AreaTrabajoDTO - SSPCOTAREATRABAJO para la BOD
	private Integer codigoReferenciaBOD;
	private String nombreAreaTrabajoBOD;
	
	//campos de la tabla AreaTrabajoDTO - SSPCOTAREATRABAJO para la SUB 
	private Integer codigoReferenciaSUB;
	private String nombreAreaTrabajoSUB;
	
	public VistaMonitorMontacargaCorredorDTO () {}

	/**
	 * @return the id
	 */
	public VistaMonitorMontacargaCorredorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaMonitorMontacargaCorredorID id) {
		this.id = id;
	}

	/**
	 * @return the estadoTarea
	 */
	public String getEstadoTarea() {
		return estadoTarea;
	}

	/**
	 * @param estadoTarea the estadoTarea to set
	 */
	public void setEstadoTarea(String estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	/**
	 * @return the referenceCode
	 */
	public String getReferenceCode() {
		return referenceCode;
	}

	/**
	 * @param referenceCode the referenceCode to set
	 */
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	/**
	 * @return the codigoTareaDatosTarea
	 */
	public Long getCodigoTareaDatosTarea() {
		return codigoTareaDatosTarea;
	}

	/**
	 * @param codigoTareaDatosTarea the codigoTareaDatosTarea to set
	 */
	public void setCodigoTareaDatosTarea(Long codigoTareaDatosTarea) {
		this.codigoTareaDatosTarea = codigoTareaDatosTarea;
	}

	/**
	 * @return the codigoDatosTarea
	 */
	public Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}

	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}

	/**
	 * @return the codigoBarrasContenedor
	 */
	public String getCodigoBarrasContenedor() {
		return codigoBarrasContenedor;
	}

	/**
	 * @param codigoBarrasContenedor the codigoBarrasContenedor to set
	 */
	public void setCodigoBarrasContenedor(String codigoBarrasContenedor) {
		this.codigoBarrasContenedor = codigoBarrasContenedor;
	}


	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * @return the fechaFinalActivo
	 */
	public Date getFechaFinalActivo() {
		return fechaFinalActivo;
	}

	/**
	 * @param fechaFinalActivo the fechaFinalActivo to set
	 */
	public void setFechaFinalActivo(Date fechaFinalActivo) {
		this.fechaFinalActivo = fechaFinalActivo;
	}

	/**
	 * @return the referenciaMedida
	 */
	public String getReferenciaMedida() {
		return referenciaMedida;
	}

	/**
	 * @param referenciaMedida the referenciaMedida to set
	 */
	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}

	/**
	 * @return the cantidadMedida
	 */
	public Double getCantidadMedida() {
		return cantidadMedida;
	}

	/**
	 * @param cantidadMedida the cantidadMedida to set
	 */
	public void setCantidadMedida(Double cantidadMedida) {
		this.cantidadMedida = cantidadMedida;
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
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}

	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}

	/**
	 * @return the codigoAreaTrabajoSubBodega
	 */
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}

	/**
	 * @param codigoAreaTrabajoSubBodega the codigoAreaTrabajoSubBodega to set
	 */
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the nombreAreaTrabajoCD
	 */
	public String getNombreAreaTrabajoCD() {
		return nombreAreaTrabajoCD;
	}

	/**
	 * @param nombreAreaTrabajoCD the nombreAreaTrabajoCD to set
	 */
	public void setNombreAreaTrabajoCD(String nombreAreaTrabajoCD) {
		this.nombreAreaTrabajoCD = nombreAreaTrabajoCD;
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
	 * @return the nombreAreaTrabajoBOD
	 */
	public String getNombreAreaTrabajoBOD() {
		return nombreAreaTrabajoBOD;
	}

	/**
	 * @param nombreAreaTrabajoBOD the nombreAreaTrabajoBOD to set
	 */
	public void setNombreAreaTrabajoBOD(String nombreAreaTrabajoBOD) {
		this.nombreAreaTrabajoBOD = nombreAreaTrabajoBOD;
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
	 * @return the nombreAreaTrabajoSUB
	 */
	public String getNombreAreaTrabajoSUB() {
		return nombreAreaTrabajoSUB;
	}

	/**
	 * @param nombreAreaTrabajoSUB the nombreAreaTrabajoSUB to set
	 */
	public void setNombreAreaTrabajoSUB(String nombreAreaTrabajoSUB) {
		this.nombreAreaTrabajoSUB = nombreAreaTrabajoSUB;
	}

	/**
	 * @return the cantidadArticulosPallet
	 */
	public Integer getCantidadArticulosPallet() {
		return cantidadArticulosPallet;
	}

	/**
	 * @param cantidadArticulosPallet the cantidadArticulosPallet to set
	 */
	public void setCantidadArticulosPallet(Integer cantidadArticulosPallet) {
		this.cantidadArticulosPallet = cantidadArticulosPallet;
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
	 * @return the valorEstadoDatosTarea
	 */
	public String getValorEstadoDatosTarea() {
		return valorEstadoDatosTarea;
	}

	/**
	 * @param valorEstadoDatosTarea the valorEstadoDatosTarea to set
	 */
	public void setValorEstadoDatosTarea(String valorEstadoDatosTarea) {
		this.valorEstadoDatosTarea = valorEstadoDatosTarea;
	}

	/**
	 * @return the ubicacionActual
	 */
	public String getUbicacionActual() {
		return ubicacionActual;
	}

	/**
	 * @param ubicacionActual the ubicacionActual to set
	 */
	public void setUbicacionActual(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
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
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * @return the valorCatalogoEstadoTarea
	 */
	public String getValorCatalogoEstadoTarea() {
		return valorCatalogoEstadoTarea;
	}

	/**
	 * @param valorCatalogoEstadoTarea the valorCatalogoEstadoTarea to set
	 */
	public void setValorCatalogoEstadoTarea(String valorCatalogoEstadoTarea) {
		this.valorCatalogoEstadoTarea = valorCatalogoEstadoTarea;
	}

}
