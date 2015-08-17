package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;

/**
 * @author finga
 *
 */
@SuppressWarnings("serial")
public class FiltroEstadoPedido implements CriteriaRestriction, Logeable {

	private Long codigoPedidoAreaTrabajo; 
	private String tipoFiltro;

	/**
	 * Restricci&oacute;n que obtiene los c&oacute;digos de unidad de manejo de los detalles de un pedido 
	 * seg&uacute;n tipo filtro enviado como par&aacute;metro
	 * 
	 * @param pCodigoPedidoAreaTrabajo
	 * @param pTipoFiltro
	 */
	public FiltroEstadoPedido(Long pCodigoPedidoAreaTrabajo, String pTipoFiltro){
		this.codigoPedidoAreaTrabajo = pCodigoPedidoAreaTrabajo;
		this.tipoFiltro = pTipoFiltro;
	}
	
	/**
	 * @see ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction#getCriteriaRestriction()
	 */
	@Override
	public Criterion getCriteriaRestriction() throws SICException {

		Criterion filtroEstado = null;

		try {

			DetachedCriteria detalleHijo = DetachedCriteria.forClass(PedidoAreaTrabajoDetalleDTO.class, "pedidoAreaTrabajoDetalle");

			// Proyecciones
			detalleHijo.setProjection(Projections.property("codigoUnidadManejo"));

			// Restricciones
			detalleHijo.add(Restrictions.eq("codigoPedidoAreaTrabajo", this.codigoPedidoAreaTrabajo))
			.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO))
			;

			// Restricciones por tipo
			if(this.tipoFiltro.equals("pedidos")){
				detalleHijo.add(Restrictions.gt("cantidadPedida", 0));
			}else if(this.tipoFiltro.equals("stand_by")){
				detalleHijo.add(Restrictions.eq("articuloMarcado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			}

			filtroEstado = Subqueries.propertyIn("id.codigoUnidadManejo", detalleHijo);

		} catch (SICException se) {
			se.getStackTrace();
			throw new SICException("Error al aplicar restriccion de Filtro estado en el pedido");
		}

		return filtroEstado;
	}
	
	

}
