package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaUbicacionPalletMontacargusitaID;


@Entity
public class VistaUbicacionPalletMontacarguistaDTO {
	@EmbeddedId
	private VistaUbicacionPalletMontacargusitaID id = new VistaUbicacionPalletMontacargusitaID();
	//Campos Detalle Tarea
	private java.lang.Long codigoDetalleSeccionOrigen ;
	
	//Detalle Seccion
	private String identificadorOrigen ;	
	private String nombreOrigen;
	
	//Datos Tarea
	private Integer codigoAreaTrabajo;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubbodega;
	private String codigoBarras ;
	private Date fechaCaducidadPallet;
	private Date fechaElaboracion;
	private Integer codigoCatalogoTipoRelacionadoTarea;	
	private String codigoCatalogoValorRelacionadoTarea;
	private String lote;
	
	@Transient
	private String codigoConsecutivo = "";

	@Transient
	private String codigoPerfil;//Campo para enviar el codigo del perfil para la asignacion de una tarea
	@Transient
	private String userId;
	
	/**
	 * @return the id
	 */
	public VistaUbicacionPalletMontacargusitaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaUbicacionPalletMontacargusitaID id) {
		this.id = id;
	}

	/**
	 * @return the codigoDetalleSeccionOrigen
	 */
	public java.lang.Long getCodigoDetalleSeccionOrigen() {
		return codigoDetalleSeccionOrigen;
	}

	/**
	 * @param codigoDetalleSeccionOrigen the codigoDetalleSeccionOrigen to set
	 */
	public void setCodigoDetalleSeccionOrigen(java.lang.Long codigoDetalleSeccionOrigen) {
		this.codigoDetalleSeccionOrigen = codigoDetalleSeccionOrigen;
	}

	/**
	 * @return the identificadorOrigen
	 */
	public String getIdentificadorOrigen() {
		return identificadorOrigen;
	}

	/**
	 * @param identificadorOrigen the identificadorOrigen to set
	 */
	public void setIdentificadorOrigen(String identificadorOrigen) {
		this.identificadorOrigen = identificadorOrigen;
	}

	/**
	 * @return the nombreOrigen
	 */
	public String getNombreOrigen() {
		return nombreOrigen;
	}

	/**
	 * @param nombreOrigen the nombreOrigen to set
	 */
	public void setNombreOrigen(String nombreOrigen) {
		this.nombreOrigen = nombreOrigen;
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
	 * @return the codigoAreaTrabajoSubbodega
	 */
	public Integer getCodigoAreaTrabajoSubbodega() {
		return codigoAreaTrabajoSubbodega;
	}

	/**
	 * @param codigoAreaTrabajoSubbodega the codigoAreaTrabajoSubbodega to set
	 */
	public void setCodigoAreaTrabajoSubbodega(Integer codigoAreaTrabajoSubbodega) {
		this.codigoAreaTrabajoSubbodega = codigoAreaTrabajoSubbodega;
	}
	
	/**
	 * @return the codigoCatalogoTipoRelacionadoTarea
	 */
	public Integer getCodigoCatalogoTipoRelacionadoTarea() {
		return codigoCatalogoTipoRelacionadoTarea;
	}
	/**
	 * @param codigoCatalogoTipoRelacionadoTarea the codigoCatalogoTipoRelacionadoTarea to set
	 */
	public void setCodigoCatalogoTipoRelacionadoTarea(Integer codigoCatalogoTipoRelacionadoTarea) {
		this.codigoCatalogoTipoRelacionadoTarea = codigoCatalogoTipoRelacionadoTarea;
	}
	/**
	 * @return the codigoCatalogoValorRelacionadoTarea
	 */
	public String getCodigoCatalogoValorRelacionadoTarea() {
		return codigoCatalogoValorRelacionadoTarea;
	}
	/**
	 * @param codigoCatalogoValorRelacionadoTarea the codigoCatalogoValorRelacionadoTarea to set
	 */
	public void setCodigoCatalogoValorRelacionadoTarea(String codigoCatalogoValorRelacionadoTarea) {
		this.codigoCatalogoValorRelacionadoTarea = codigoCatalogoValorRelacionadoTarea;
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
	 * @return the fechaCaducidadPallet
	 */
	public Date getFechaCaducidadPallet() {
		return fechaCaducidadPallet;
	}

	/**
	 * @param fechaCaducidadPallet the fechaCaducidadPallet to set
	 */
	public void setFechaCaducidadPallet(Date fechaCaducidadPallet) {
		this.fechaCaducidadPallet = fechaCaducidadPallet;
	}

	/**
	 * @return the codigoConsecutivo
	 */
	public String getCodigoConsecutivo() {
	
		if(StringUtils.isNotEmpty(codigoBarras)){
			if(codigoBarras.length() == 13){
				return codigoBarras.substring(5, 12);
			}
		}
		return codigoConsecutivo;
	}

	/**
	 * @param codigoConsecutivo the codigoConsecutivo to set
	 */
	public void setCodigoConsecutivo(String codigoConsecutivo) {
		this.codigoConsecutivo = codigoConsecutivo;
	}

	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}

	/**
	 * @return the fechaElaboracion
	 */
	public Date getFechaElaboracion() {
		return fechaElaboracion;
	}

	/**
	 * @param fechaElaboracion the fechaElaboracion to set
	 */
	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}
		
	
}

