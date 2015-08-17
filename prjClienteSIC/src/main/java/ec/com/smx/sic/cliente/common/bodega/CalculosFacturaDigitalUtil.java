package ec.com.smx.sic.cliente.common.bodega;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;

public class CalculosFacturaDigitalUtil {

	/**
	 * Constructor
	 */
	public CalculosFacturaDigitalUtil() {

	}

	public FacturaEstadoDTO calcularTotalesFactura(FacturaEstadoDTO facturaEstadoDTO) {
		//
		if (CollectionUtils.isNotEmpty(facturaEstadoDTO.getFacturaDigitalESTs())) {
			
			TipoImpuestoDTO tipoImpuestoDTO = null; 
					
			// valor I.V.A 12%
			tipoImpuestoDTO = new TipoImpuestoDTO();
			tipoImpuestoDTO.setCodigoGrupoImpuesto(SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_IVA);
			tipoImpuestoDTO.getId().setCodigoTipoImpuesto(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA);

			Collection<FacturaDigitalEST> articulosTipoImpuestoOmisionIVA = this.obtenerArticuloImpuestoFactura(facturaEstadoDTO.getFacturaDigitalESTs(), tipoImpuestoDTO);
			BigDecimal totalIVA12 = this.sumarFacturaDigitalEST(articulosTipoImpuestoOmisionIVA);
			facturaEstadoDTO.addDynamicProperty("totalIVA12", totalIVA12);
			
			// valor I.V.A 12%
			tipoImpuestoDTO = new TipoImpuestoDTO();
			tipoImpuestoDTO.setCodigoGrupoImpuesto(SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_ICE);
			tipoImpuestoDTO.getId().setCodigoTipoImpuesto(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA_0);

			Collection<FacturaDigitalEST> articulosTipoImpuestoOmisionIVA0= this.obtenerArticuloImpuestoFactura(facturaEstadoDTO.getFacturaDigitalESTs(), tipoImpuestoDTO);
			BigDecimal totalIVA0 = this.sumarFacturaDigitalEST(articulosTipoImpuestoOmisionIVA0);
			facturaEstadoDTO.addDynamicProperty("totalIVA0", totalIVA0);
			
			// valor I.V.E 
			tipoImpuestoDTO = new TipoImpuestoDTO();
			tipoImpuestoDTO.setCodigoGrupoImpuesto(SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_VERDE);
			tipoImpuestoDTO.getId().setCodigoTipoImpuesto(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVE);

			Collection<FacturaDigitalEST> articulosTipoImpuestoOmisionIVE = this.obtenerArticuloImpuestoFactura(facturaEstadoDTO.getFacturaDigitalESTs(), tipoImpuestoDTO);
			BigDecimal totalIVE = this.sumarFacturaDigitalEST(articulosTipoImpuestoOmisionIVE);
			facturaEstadoDTO.addDynamicProperty("totalIVE", totalIVE);
				
		}
		return facturaEstadoDTO;
	}
	
	public BigDecimal sumarFacturaDigitalEST(Collection<FacturaDigitalEST> facturaDigitalESTs) {
		BigDecimal total = new BigDecimal(0);
		if (CollectionUtils.isNotEmpty(facturaDigitalESTs)) {
			for (FacturaDigitalEST facturaDigitalEST : facturaDigitalESTs) {
				Integer cantidadIngresada = Integer.parseInt(facturaDigitalEST.getDynamicProperty("cantidadIngresada").toString());
				Integer valorUnidadManejo = facturaDigitalEST.getOrdenCompraDetalleEstadoDTO().getArticuloUnidadManejoProveedor().getArticuloUnidadManejoDTO().getValorUnidadManejo();
				BigDecimal costoNeto = facturaDigitalEST.getCostoNeto();
				BigDecimal totalArticulo = new BigDecimal(cantidadIngresada).multiply(new BigDecimal(valorUnidadManejo)).multiply(costoNeto)
						.setScale(SICConstantes.getInstancia().CANTIDADDECIMALCUATRO, RoundingMode.HALF_UP);
				total.add(totalArticulo);
			}
		}
		return total;
	}
	
	
	public Collection<FacturaDigitalEST> obtenerArticuloImpuestoFactura(Collection<FacturaDigitalEST> facturaDigitalESTs, TipoImpuestoDTO tipoImpuestoDTO) {
		Collection<FacturaDigitalEST> filters = new ArrayList<FacturaDigitalEST>();
		if (CollectionUtils.isNotEmpty(facturaDigitalESTs)) {
			for (FacturaDigitalEST facturaDigitalEST : facturaDigitalESTs) {
				OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO = facturaDigitalEST.getOrdenCompraDetalleEstadoDTO();
				Collection<OrdenCompraDetalleEstadoImpuestoDTO> ordenCompraDetalleEstadoImpuestoCol = ordenCompraDetalleEstadoDTO.getOrdenCompraDetalleEstadoImpuestoCol();
				for (OrdenCompraDetalleEstadoImpuestoDTO ordenCompraDetalleEstadoImpuestoDTO : ordenCompraDetalleEstadoImpuestoCol) {
					if(tipoImpuestoDTO.getId().getCodigoTipoImpuesto().equals(ordenCompraDetalleEstadoImpuestoDTO.getCodigoTipoImpuesto())) {
						filters.add(facturaDigitalEST);
					}
				}
			}
		}
		return filters;
	}
}
