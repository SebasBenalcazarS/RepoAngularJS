package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;

/**
 * VO para manejar los datos de la entidad OrdenCompraDetalleEstadoDTO con sus relaciones: ordenCompraEstadoDTO
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
public class FacturaDigitalVO extends BaseVO<OrdenCompraDetalleEstadoDTO>{

	private String codigoClasificacion;
	private String codigoArticulo;
	private Date fechaCaducidad;
	private ClasificacionDTO clasificacionDTO;
	private Long codigoOrdenCompraEstado;
	private String nombreMarca;
	private OrdenCompraEstadoDTO ordenCompraEstadoDTO;
	private BodegaDTO bodegaDTO;
	private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO;
	private Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOCol;
	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
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
	 * @return the clasificacionDTO
	 */
	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}
	/**
	 * @param clasificacionDTO the clasificacionDTO to set
	 */
	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}
	/**
	 * @return the ordenCompraDetalleEstadoDTOCol
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> getOrdenCompraDetalleEstadoDTOCol() {
		return ordenCompraDetalleEstadoDTOCol;
	}
	/**
	 * @param ordenCompraDetalleEstadoDTOCol the ordenCompraDetalleEstadoDTOCol to set
	 */
	public void setOrdenCompraDetalleEstadoDTOCol(
			Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOCol) {
		this.ordenCompraDetalleEstadoDTOCol = ordenCompraDetalleEstadoDTOCol;
	}
	/**
	 * @return the codigoOrdenCompraEstado
	 */
	public Long getCodigoOrdenCompraEstado() {
		return codigoOrdenCompraEstado;
	}
	/**
	 * @param codigoOrdenCompraEstado the codigoOrdenCompraEstado to set
	 */
	public void setCodigoOrdenCompraEstado(Long codigoOrdenCompraEstado) {
		this.codigoOrdenCompraEstado = codigoOrdenCompraEstado;
	}
	/**
	 * @return the ordenCompraEstadoDTO
	 */
	public OrdenCompraEstadoDTO getOrdenCompraEstadoDTO() {
		return ordenCompraEstadoDTO;
	}
	/**
	 * @param ordenCompraEstadoDTO the ordenCompraEstadoDTO to set
	 */
	public void setOrdenCompraEstadoDTO(OrdenCompraEstadoDTO ordenCompraEstadoDTO) {
		this.ordenCompraEstadoDTO = ordenCompraEstadoDTO;
	}
	/**
	 * @return the ordenCompraDetalleEstadoDTO
	 */
	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstadoDTO() {
		return ordenCompraDetalleEstadoDTO;
	}
	/**
	 * @param ordenCompraDetalleEstadoDTO the ordenCompraDetalleEstadoDTO to set
	 */
	public void setOrdenCompraDetalleEstadoDTO(
			OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) {
		this.ordenCompraDetalleEstadoDTO = ordenCompraDetalleEstadoDTO;
	}
	/**
	 * @return the fechaCaducidad
	 */
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	/**
	 * @return the bodegaDTO
	 */
	public BodegaDTO getBodegaDTO() {
		return bodegaDTO;
	}
	/**
	 * @param bodegaDTO the bodegaDTO to set
	 */
	public void setBodegaDTO(BodegaDTO bodegaDTO) {
		this.bodegaDTO = bodegaDTO;
	}
	/**
	 * @return the nombreMarca
	 */
	public String getNombreMarca() {
		return nombreMarca;
	}
	/**
	 * @param nombreMarca the nombreMarca to set
	 */
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	
}
