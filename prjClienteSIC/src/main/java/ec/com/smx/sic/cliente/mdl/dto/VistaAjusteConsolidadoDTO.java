package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Permite obtener los valores totales de ajustes de las notas de ingreso consolidadas
 * @author fcollaguazo
 *
 */
@Entity
public class VistaAjusteConsolidadoDTO {

	@Id
	private String valorTipoAjuste;
	
	private BigDecimal valorTotalAjustes;

	public String getValorTipoAjuste() {
		return valorTipoAjuste;
	}

	public void setValorTipoAjuste(String valorTipoAjuste) {
		this.valorTipoAjuste = valorTipoAjuste;
	}

	public BigDecimal getValorTotalAjustes() {
		return valorTotalAjustes;
	}

	public void setValorTotalAjustes(BigDecimal valorTotalAjustes) {
		this.valorTotalAjustes = valorTotalAjustes;
	}
}
