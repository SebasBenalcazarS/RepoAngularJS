/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;

/**
 * Subconsulta para obtener el codigo de una orden de compra estado a partir de un detalle de orden de compra estado
 * 
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
public class OrdenCompraDetalleEstadoRestriccion implements CriteriaRestriction {
	/**
	 * DTO OrdenCompraDetalleEstadoDTO
	 */
	private Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs;
	
	/**
	 * Constructor
	 * @param ordenCompraDetalleEstadoDTO Un OrdenCompraDetalleEstadoDTO
	 */
	public OrdenCompraDetalleEstadoRestriccion(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) {
		this.ordenCompraDetalleEstadoDTOs = ordenCompraDetalleEstadoDTOs;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Criterion getCriteriaRestriction() {
		Collection<Long> codigosOCDE = CollectionUtils.collect(this.ordenCompraDetalleEstadoDTOs, new GetInvokerTransformer("id.codigoOrdenCompraDetalleEstado"));
		DetachedCriteria subCriteriaOrdenCompraEstado = DetachedCriteria.forClass(OrdenCompraEstadoDTO.class,"this");
		subCriteriaOrdenCompraEstado.createAlias("ordenCompraDetalleEstadoCol", "OCDE"); 
		subCriteriaOrdenCompraEstado.add(Restrictions.in("OCDE.id.codigoOrdenCompraDetalleEstado", codigosOCDE));
		
		Projection projection = Projections.property("codigoOrdenCompra");
		
		subCriteriaOrdenCompraEstado.setProjection(projection);
		
		//return Subqueries.propertyEq("codigoOrdenCompra", subCriteriaOrdenCompraEstado);
		
		return Subqueries.propertyIn("codigoOrdenCompra", subCriteriaOrdenCompraEstado);
	}
	
}
