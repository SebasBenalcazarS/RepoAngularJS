package ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.precios;

import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;

public interface IValidacionArticuloReglasComercialesGestor {
	
	void validarPreciosCostos(Integer presentacion, Boolean ventaPrecioAfiliado, Double porcentajeNA, Double costoBruto, Double precioBase, Double pvp, Collection<ArticuloImpuestoDTO> articuloImpuestos, Collection<DescuentoProveedorArticuloDTO> descuentosProveedor, Set<EnumCaracteristicaDinamica> caracteristicasDinamicas) throws SICRuleException;
	
	Boolean validarAplicaMayoreo(ArticuloDTO articuloDTO) throws SICException;
	
	EnumTipoPrecio obtenerTipoPrecioLocal(ArticuloDTO articuloDTO) throws SICException;
	
	Boolean aplicaPrecioMayoreoLocal(ArticuloDTO articuloDTO) throws SICException;
	
	Boolean aplicaPrecioCajaLocal(ArticuloDTO articuloDTO) throws SICException;

}
