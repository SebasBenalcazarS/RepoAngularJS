package ec.com.smx.sic.cliente.mdl.vo;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

@SuppressWarnings("serial")
public class DetalleSeccionVO extends BaseVO<DetalleSeccionDTO>{
	private Long pasillo;
	private Long rack;
	private Long nivel;
	private Long surtido;
	//private String valorSurtido;

	
	public Long getPasillo() {
		return pasillo;
	}
	public void setPasillo(Long pasillo) {
		this.pasillo = pasillo;
	}
	public Long getRack() {
		return rack;
	}
	public void setRack(Long rack) {
		this.rack = rack;
	}
	public Long getNivel() {
		return nivel;
	}
	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

	public void setSurtido(Long surtido) {
		this.surtido = surtido;
	}
	public Long getSurtido() {
		return surtido;
	}

}
