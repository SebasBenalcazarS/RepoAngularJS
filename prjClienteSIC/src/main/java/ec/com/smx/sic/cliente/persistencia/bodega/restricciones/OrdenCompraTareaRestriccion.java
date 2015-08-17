/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

/**
 * Consulta las ordenes de compra de una Tarea en base a los datos de un TareaDTO y OrdenCompraEstadoDTO
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
public class OrdenCompraTareaRestriccion implements CriteriaRestriction {
	/**
	 * Gestor TareaDTO
	 */
	private TareaDTO tareaDTO;
	
	private OrdenCompraEstadoDTO ordenCompraEstadoDTO;
	
	/**
	 * 
	 * @param tareaDTO 
	 */
	public OrdenCompraTareaRestriccion(TareaDTO tareaDTO, OrdenCompraEstadoDTO ordenCompraEstadoDTO) {
		this.tareaDTO = tareaDTO;
		this.ordenCompraEstadoDTO = ordenCompraEstadoDTO;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria subCriteriaOrdenCompraEstado = DetachedCriteria.forClass(OrdenCompraEstadoDTO.class,"OCE");
		subCriteriaOrdenCompraEstado.createAlias("entregaOrdenCompraEstadoDTOCol", "EOCE"); 
		subCriteriaOrdenCompraEstado.createAlias("EOCE.entrega", "E");
		subCriteriaOrdenCompraEstado.createAlias("E.entregaRecepcionProveedorDTOCol", "ERP");
		subCriteriaOrdenCompraEstado.createAlias("ERP.recepcionProveedorDTO", "RP");
		subCriteriaOrdenCompraEstado.createAlias("RP.procesoLogisticoDTO", "PL");
		subCriteriaOrdenCompraEstado.createAlias("PL.tareaCol", "T");
		
		subCriteriaOrdenCompraEstado.add(Restrictions.eq("T.id.codigoTarea", tareaDTO.getId().getCodigoTarea()));
		subCriteriaOrdenCompraEstado.add(Restrictions.eq("T.id.codigoCompania", tareaDTO.getId().getCodigoCompania()));
		
		if (ordenCompraEstadoDTO != null) {
			if (ordenCompraEstadoDTO.getCodigoEstadoCatTip() != null) {
				subCriteriaOrdenCompraEstado.add(Restrictions.eq("OCE.codigoEstadoCatTip", ordenCompraEstadoDTO.getCodigoEstadoCatTip()));
			}
			if (StringUtils.isNotEmpty(ordenCompraEstadoDTO.getCodigoEstadoCatVal())) {
				subCriteriaOrdenCompraEstado.add(Restrictions.eq("OCE.codigoEstadoCatVal", ordenCompraEstadoDTO.getCodigoEstadoCatVal()));
			}
		}
		
		Projection projection = Projections.property("codigoOrdenCompra");
		
		subCriteriaOrdenCompraEstado.setProjection(projection);
		
		return Subqueries.propertyIn("codigoOrdenCompra", subCriteriaOrdenCompraEstado);
	}
	
}
