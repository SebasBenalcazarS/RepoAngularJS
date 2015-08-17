package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ec.com.smx.sic.cliente.common.annotation.Compare;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.SeveridadConflictoArticulo;
import ec.com.smx.sic.cliente.mdl.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;

@SuppressWarnings("serial")
public abstract class ArticuloProveedorGestionPrecioTransient extends AuditoriaBaseDTO {

	// Valores calculados con costo bruto anterior
	protected Double costoNeto;
	protected Double margenPVP;
	protected Double margenSMX;

	// Valores calculados con costo bruto nuevo
	@Compare
	protected Double costoNetoNuevo;
	@Compare
	protected Double margenPVPNuevo;
	@Compare
	protected Double margenSMXNuevo;

	protected Double costoNetoNCAnterior;
	protected Double costoNetoNCNuevo;
	protected Double costoNetoNotaCreditoVsPvpAnterior;
	protected Double costoNetoNotaCreditoVsPvpNuevo;
	protected Double pvpVsCostoNetoNotaCreditoAnterior;
	protected Double pvpVsCostoNetoNotaCreditoNuevo;
	protected Double ventaCostoNetoNCAnterior;
	protected Double ventaCostoNetoNCNuevo;
	protected Double variacionCostoBruto;
	protected Double porcentajeVariacionCostoBruto;
	
	private Boolean existeMensajeValidacionConflicto;
	private Map<SeveridadConflictoArticulo, Set<String>> mensajesConflictosArticuloProveedor;
	private Collection<PrecioDiferenciadoArticuloGestionDTO> margenesPreciosDiferenciadosArticuloProveedor;


	/**
	 * @return the existeMensajeValidacionConflicto
	 */
	public Boolean getExisteMensajeValidacionConflicto() {
		return existeMensajeValidacionConflicto;
	}
	/**
	 * @param existeMensajeValidacionConflicto the existeMensajeValidacionConflicto to set
	 */
	public void setExisteMensajeValidacionConflicto(Boolean existeMensajeValidacionConflicto) {
		this.existeMensajeValidacionConflicto = existeMensajeValidacionConflicto;
	}
	/**
	 * @return the mensajesConflictosArticuloProveedor
	 */
	public Map<SeveridadConflictoArticulo, Set<String>> getMensajesConflictosArticuloProveedor() {
		return mensajesConflictosArticuloProveedor;
	}
	/**
	 * @param mensajesConflictosArticuloProveedor the mensajesConflictosArticuloProveedor to set
	 */
	public void setMensajesConflictosArticuloProveedor(Map<SeveridadConflictoArticulo, Set<String>> mensajesConflictosArticuloProveedor) {
		this.mensajesConflictosArticuloProveedor = mensajesConflictosArticuloProveedor;
	}
	/**
	 * @return the margenesPreciosDiferenciadosArticuloProveedor
	 */
	public Collection<PrecioDiferenciadoArticuloGestionDTO> getMargenesPreciosDiferenciadosArticuloProveedor() {
		return margenesPreciosDiferenciadosArticuloProveedor;
	}
	/**
	 * @param margenesPreciosDiferenciadosArticuloProveedor the margenesPreciosDiferenciadosArticuloProveedor to set
	 */
	public void setMargenesPreciosDiferenciadosArticuloProveedor(Collection<PrecioDiferenciadoArticuloGestionDTO> margenesPreciosDiferenciadosArticuloProveedor) {
		this.margenesPreciosDiferenciadosArticuloProveedor = margenesPreciosDiferenciadosArticuloProveedor;
	}
}