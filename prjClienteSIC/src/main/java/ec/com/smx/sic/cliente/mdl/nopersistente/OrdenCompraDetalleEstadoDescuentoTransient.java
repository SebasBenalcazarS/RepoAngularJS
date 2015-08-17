package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.math.BigDecimal;

import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * @author mhidalgo
 *
 */
@SuppressWarnings("serial")
public abstract class OrdenCompraDetalleEstadoDescuentoTransient extends SimpleAuditDTO{
	
	@Transient
    protected BigDecimal porcentajeDescuentoNuevo;

	public void setPorcentajeDescuentoNuevo(BigDecimal porcentajeDescuentoNuevo) {
		this.porcentajeDescuentoNuevo = porcentajeDescuentoNuevo;
	}

}
