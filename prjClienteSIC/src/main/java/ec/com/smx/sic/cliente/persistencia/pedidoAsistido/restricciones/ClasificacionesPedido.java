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
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoClasificacionDTO;

/**
 * @author finga
 * 
 */
public class ClasificacionesPedido implements CriteriaRestriction, Logeable {

	private static final long serialVersionUID = 1L;
	private Long codigoPedidoAreaTrabajo;

	/**
	 * Restricci&oacute;n que obtiene los c&oacute;digos de las clasificaciones
	 * del pedido (codigo pedido area trabajo como par&aacute;metro)
	 * 
	 * @param pCodigoPedidoAreaTrabajo
	 */
	public ClasificacionesPedido(Long pCodigoPedidoAreaTrabajo) {
		this.codigoPedidoAreaTrabajo = pCodigoPedidoAreaTrabajo;
	}

	/**
	 * @see ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction#getCriteriaRestriction()
	 */
	@Override
	public Criterion getCriteriaRestriction() throws SICException {

		Criterion clasesPedidoAsistido = null;

		try {

			DetachedCriteria clasificacionesPedido = DetachedCriteria.forClass(PedidoAreaTrabajoClasificacionDTO.class, "clasificacionPedido");

			// Proyecciones
			clasificacionesPedido.setProjection(Projections.property("id.codigoClasificacion"));

			// Restricciones
			clasificacionesPedido
			.add(Restrictions.eq("id.codigoPedidoAreaTrabajo", this.codigoPedidoAreaTrabajo))
			.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));

			clasesPedidoAsistido = Subqueries.propertyIn("codigoClasificacion", clasificacionesPedido);

		} catch (SICException se) {
			se.getStackTrace();
			throw new SICException("Error al aplicar restriccion de clasificaciones de pedido en articulos");
		}

		return clasesPedidoAsistido;
	}

}
