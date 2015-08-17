package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CalendarioBodegaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;

@SuppressWarnings("serial")
public class CalendarioBodegaProveedorVO extends BaseVO<CalendarioBodegaProveedorDTO>{

	private Integer codigoBodega;
	private BodegaDTO bodegaDTO;
	private PedidoDTO pedidoDTO;
	private Date fechaEntrega;
	private Integer diaFechaEntrega;
	private Collection<CalendarioBodegaProveedorDTO> calendarioBodegaProveedorDTOCol;
	/**
	 * @return the codigoBodega
	 */
	public Integer getCodigoBodega() {
		return codigoBodega;
	}
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(Integer codigoBodega) {
		this.codigoBodega = codigoBodega;
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
	 * @return the pedidoDTO
	 */
	public PedidoDTO getPedidoDTO() {
		return pedidoDTO;
	}
	/**
	 * @param pedidoDTO the pedidoDTO to set
	 */
	public void setPedidoDTO(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
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
	 * @return the diaFechaEntrega
	 */
	public Integer getDiaFechaEntrega() {
		return diaFechaEntrega;
	}
	/**
	 * @param diaFechaEntrega the diaFechaEntrega to set
	 */
	public void setDiaFechaEntrega(Integer diaFechaEntrega) {
		this.diaFechaEntrega = diaFechaEntrega;
	}
	/**
	 * @return the calendarioBodegaProveedorDTOCol
	 */
	public Collection<CalendarioBodegaProveedorDTO> getCalendarioBodegaProveedorDTOCol() {
		return calendarioBodegaProveedorDTOCol;
	}
	/**
	 * @param calendarioBodegaProveedorDTOCol the calendarioBodegaProveedorDTOCol to set
	 */
	public void setCalendarioBodegaProveedorDTOCol(
			Collection<CalendarioBodegaProveedorDTO> calendarioBodegaProveedorDTOCol) {
		this.calendarioBodegaProveedorDTOCol = calendarioBodegaProveedorDTOCol;
	}
	
}
