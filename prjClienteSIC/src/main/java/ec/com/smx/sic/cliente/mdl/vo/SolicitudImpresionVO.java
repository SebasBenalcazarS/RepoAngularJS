package ec.com.smx.sic.cliente.mdl.vo;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.etiquetado.modelo.dto.PrintRequestDTO;
/**
 * 
 * @author aquingaluisa
 *
 */
@SuppressWarnings("serial")
public class SolicitudImpresionVO  extends BaseVO<PrintRequestDTO>{
	private Integer codigoCompania;
	private String userId;
	
	
	public SolicitudImpresionVO(Integer codigoCompania,String userId) {
		this.codigoCompania = codigoCompania;
		this.userId = userId;
		
	}
	public SolicitudImpresionVO(Integer codigoCompania,String userId,PrintRequestDTO solicitudImpresion) {
		this.codigoCompania = codigoCompania;
		this.userId = userId;
		this.setBaseDTO(solicitudImpresion);
	}
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
