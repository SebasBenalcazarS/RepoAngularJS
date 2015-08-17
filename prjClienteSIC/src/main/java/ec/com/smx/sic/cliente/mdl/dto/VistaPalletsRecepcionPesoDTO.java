/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.bodega.EnumEstadosPallets;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaPalletsRecepcionPesoID;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
public class VistaPalletsRecepcionPesoDTO extends SearchDTO {
	
	@EmbeddedId
	private VistaPalletsRecepcionPesoID id = new VistaPalletsRecepcionPesoID();
	
	private String codigoBarras;
	private Integer cantidad;
	private BigDecimal peso;
	private BigDecimal pesoBruto;
	private String valorEstadoDatosTarea;
	private Integer codigoTipoControlCosto;
	private String valorTipoControlCosto;
	private String nombreCatalogoEstadoTarea;
	private String nombreCatalogoTipoControlCosto;
	private String codigoCatalogoValorTipoControlCosto;
	private String codigoPerfil;
	private String userName;
	private String codigoFuncionario;
	
	private Long codigoProcesoLogistico;
	private Integer codigoAreaTrabajo;
	private Long codigoTipoTareaPerfil;
	private Integer codigoAreaSublugarTrabajo;
	private Long codigoDetalleSeccionOrigen ;
	private Long codigoDetalleSeccionDestino ;
	
	private Integer codigoTipoMarca;
	private String valorTipoMarca;
	
	private Long secuencialDatosTarea;
	
	private String codigoArticulo;
	private Long codigoUnidadManejo;
	
	@Transient
	private Boolean seleccionado = Boolean.FALSE;
	
//	/**
//	 * @return the codigoDatosTarea
//	 */
//	public Long getCodigoDatosTarea() {
//		return codigoDatosTarea;
//	}
//	/**
//	 * @param codigoDatosTarea the codigoDatosTarea to set
//	 */
//	public void setCodigoDatosTarea(Long codigoDatosTarea) {
//		this.codigoDatosTarea = codigoDatosTarea;
//	}
	
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}
	/**
	 * @return the codigoTipoMarca
	 */
	public Integer getCodigoTipoMarca() {
		return codigoTipoMarca;
	}
	/**
	 * @param codigoTipoMarca the codigoTipoMarca to set
	 */
	public void setCodigoTipoMarca(Integer codigoTipoMarca) {
		this.codigoTipoMarca = codigoTipoMarca;
	}
	/**
	 * @return the valorTipoMarca
	 */
	public String getValorTipoMarca() {
		return valorTipoMarca;
	}
	/**
	 * @param valorTipoMarca the valorTipoMarca to set
	 */
	public void setValorTipoMarca(String valorTipoMarca) {
		this.valorTipoMarca = valorTipoMarca;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the peso
	 */
	public BigDecimal getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
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
	 * @return the codigoTipoControlCosto
	 */
	public Integer getCodigoTipoControlCosto() {
		return codigoTipoControlCosto;
	}
	/**
	 * @param codigoTipoControlCosto the codigoTipoControlCosto to set
	 */
	public void setCodigoTipoControlCosto(Integer codigoTipoControlCosto) {
		this.codigoTipoControlCosto = codigoTipoControlCosto;
	}
	/**
	 * @return the valorTipoControlCosto
	 */
	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}
	/**
	 * @param valorTipoControlCosto the valorTipoControlCosto to set
	 */
	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}
	/**
	 * @return the nombreCatalogoEstadoTarea
	 */
	public String getNombreCatalogoEstadoTarea() {
		return nombreCatalogoEstadoTarea;
	}
	/**
	 * @param nombreCatalogoEstadoTarea the nombreCatalogoEstadoTarea to set
	 */
	public void setNombreCatalogoEstadoTarea(String nombreCatalogoEstadoTarea) {
		this.nombreCatalogoEstadoTarea = nombreCatalogoEstadoTarea;
	}
	/**
	 * @return the nombreCatalogoTipoControlCosto
	 */
	public String getNombreCatalogoTipoControlCosto() {
		return nombreCatalogoTipoControlCosto;
	}
	/**
	 * @param nombreCatalogoTipoControlCosto the nombreCatalogoTipoControlCosto to set
	 */
	public void setNombreCatalogoTipoControlCosto(String nombreCatalogoTipoControlCosto) {
		this.nombreCatalogoTipoControlCosto = nombreCatalogoTipoControlCosto;
	}
	/**
	 * @return the codigoCatalogoValorTipoControlCosto
	 */
	public String getCodigoCatalogoValorTipoControlCosto() {
		return codigoCatalogoValorTipoControlCosto;
	}
	/**
	 * @param codigoCatalogoValorTipoControlCosto the codigoCatalogoValorTipoControlCosto to set
	 */
	public void setCodigoCatalogoValorTipoControlCosto(String codigoCatalogoValorTipoControlCosto) {
		this.codigoCatalogoValorTipoControlCosto = codigoCatalogoValorTipoControlCosto;
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
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}
	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
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
	
//	/**
//	 * @return the codigoTarea
//	 */
//	public Long getCodigoTarea() {
//		return codigoTarea;
//	}
//	/**
//	 * @param codigoTarea the codigoTarea to set
//	 */
//	public void setCodigoTarea(Long codigoTarea) {
//		this.codigoTarea = codigoTarea;
//	}
	
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
	 * @return the codigoAreaSublugarTrabajo
	 */
	public Integer getCodigoAreaSublugarTrabajo() {
		return codigoAreaSublugarTrabajo;
	}
	/**
	 * @param codigoAreaSublugarTrabajo the codigoAreaSublugarTrabajo to set
	 */
	public void setCodigoAreaSublugarTrabajo(Integer codigoAreaSublugarTrabajo) {
		this.codigoAreaSublugarTrabajo = codigoAreaSublugarTrabajo;
	}
	/**
	 * @return the codigoDetalleSeccionOrigen
	 */
	public Long getCodigoDetalleSeccionOrigen() {
		return codigoDetalleSeccionOrigen;
	}
	/**
	 * @param codigoDetalleSeccionOrigen the codigoDetalleSeccionOrigen to set
	 */
	public void setCodigoDetalleSeccionOrigen(Long codigoDetalleSeccionOrigen) {
		this.codigoDetalleSeccionOrigen = codigoDetalleSeccionOrigen;
	}
	/**
	 * @return the codigoDetalleSeccionDestino
	 */
	public Long getCodigoDetalleSeccionDestino() {
		return codigoDetalleSeccionDestino;
	}
	/**
	 * @param codigoDetalleSeccionDestino the codigoDetalleSeccionDestino to set
	 */
	public void setCodigoDetalleSeccionDestino(Long codigoDetalleSeccionDestino) {
		this.codigoDetalleSeccionDestino = codigoDetalleSeccionDestino;
	}
	
	/**
	 * @return the id
	 */
	public VistaPalletsRecepcionPesoID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaPalletsRecepcionPesoID id) {
		this.id = id;
	}
	
	/**
	 * @return the secuencialDatosTarea
	 */
	public Long getSecuencialDatosTarea() {
		return secuencialDatosTarea;
	}
	/**
	 * @param secuencialDatosTarea the secuencialDatosTarea to set
	 */
	public void setSecuencialDatosTarea(Long secuencialDatosTarea) {
		this.secuencialDatosTarea = secuencialDatosTarea;
	}
	
	/**
	 * Retorna si es un estado valido para seleccionar el pallet en la recepcion de perecibles
	 * @param vistaPalletsRecepcionPeso
	 * @return
	 */
	public Boolean getEstadoValidoParaSeleccionar () {
		
		if (this.valorEstadoDatosTarea == null) {
			return Boolean.FALSE;
		} else if (this.valorEstadoDatosTarea.equals(EnumEstadosPallets.EN_PROCESO.getEstado()) || 
				this.valorEstadoDatosTarea.equals(EnumEstadosPallets.ANULADO.getEstado()) || this.valorEstadoDatosTarea.equals(EnumEstadosPallets.EN_ANDEN.getEstado())) {
			
			return Boolean.FALSE;
			
		} else {
			return Boolean.TRUE;
		}
		
	}
	
	/**
	 * Retorna si el pallet esta en un estado valido para se pesado
	 * @return
	 */
	public Boolean getEstadoValidoPesar () {
		
		if (this.valorEstadoDatosTarea == null) {
			return Boolean.FALSE;
		} else if (this.valorEstadoDatosTarea.equals(EnumEstadosPallets.EN_BALANZA.getEstado())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	/**
	 * @return the pesoBruto
	 */
	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}
	/**
	 * @param pesoBruto the pesoBruto to set
	 */
	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
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
	
}
