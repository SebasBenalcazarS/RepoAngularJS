package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class AreaTrabajoPorReferenciaLocal implements CriteriaRestriction{
	
	private Collection<Integer> codigosReferenciaAreaTrabajo;
	private String property = null;
	
	/**
	 * @param numeroOrdenCompra
	 * @param property
	 */
	public AreaTrabajoPorReferenciaLocal(Collection<Integer> codigosReferenciaAreaTrabajo, String property) {
		super();
		this.codigosReferenciaAreaTrabajo = codigosReferenciaAreaTrabajo;
		this.property = property;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		Junction areaTrabajoJunctionCDT = null; 
		Junction areaTrabajoJunctionOFI = null;
		try {
			DetachedCriteria subSelectAreaTrabajoOrdenCompra;
			subSelectAreaTrabajoOrdenCompra = DetachedCriteria.forClass(AreaTrabajoDTO.class, "areaTrabajo");
			subSelectAreaTrabajoOrdenCompra.setProjection(Projections.distinct(Projections.property("areaTrabajo.id.codigoAreaTrabajo")));
			subSelectAreaTrabajoOrdenCompra.createAlias("areaTrabajo.establecimientoCiudadDTO", "establecimientoCiudad");
			subSelectAreaTrabajoOrdenCompra.createAlias("establecimientoCiudad.establecimientoDTO", "establecimiento");
			
			/** RESTRICCIONES*/
			subSelectAreaTrabajoOrdenCompra.add(Restrictions.eqProperty("areaTrabajo.id.codigoAreaTrabajo",
					 													"pedido.codigoAreaTrabajoPedido"));
			subSelectAreaTrabajoOrdenCompra.add(Restrictions.eq("establecimientoCiudad.estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
			subSelectAreaTrabajoOrdenCompra.add(Restrictions.eq("establecimiento.estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
			
			//Restricciones areas de trabajo
			areaTrabajoJunctionCDT = Restrictions.conjunction();
			areaTrabajoJunctionCDT.add(Restrictions.in("areaTrabajo.codigoReferencia", codigosReferenciaAreaTrabajo));
			areaTrabajoJunctionCDT.add(Restrictions.not(Restrictions.in("areaTrabajo.tipoAreaTrabajoValor", 
										new String[]{CorporativoConstantes.TIPO_AREATRABAJO_OFICINA, CorporativoConstantes.TIPO_AREATRABAJO_SUBBODEGA})));
			areaTrabajoJunctionCDT.add(Restrictions.eq("areaTrabajo.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			areaTrabajoJunctionCDT.add(Restrictions.ne("establecimiento.tipoEstablecimiento", CorporativoConstantes.TIPO_ESTABLECIMIENTO_ADMINISTRATIVO));
			
			//Restricciones oficinas
			areaTrabajoJunctionOFI = Restrictions.conjunction();
			
			areaTrabajoJunctionOFI.add(Restrictions.in("areaTrabajo.codigoReferencia", 
												      CollectionUtils.collect(codigosReferenciaAreaTrabajo, new Transformer() {
												      @Override
												      public Object transform(Object arg0) {return ((Integer) arg0) * -1;}})));
			
			areaTrabajoJunctionOFI.add(Restrictions.eq("areaTrabajo.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_OFICINA));
			areaTrabajoJunctionOFI.add(Restrictions.eq("areaTrabajo.estadoAreaTrabajo", SICConstantes.ESTADO_INACTIVO_LITERAL));
			areaTrabajoJunctionOFI.add(Restrictions.eq("establecimiento.tipoEstablecimiento", CorporativoConstantes.TIPO_ESTABLECIMIENTO_ADMINISTRATIVO));
			
			subSelectAreaTrabajoOrdenCompra.add(Restrictions.or(areaTrabajoJunctionCDT, areaTrabajoJunctionOFI));
			criterion = Subqueries.propertyIn(this.property, subSelectAreaTrabajoOrdenCompra);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci\u00F3n \u00F3rdenes de compra por area de trabajo");
		}
		return criterion;
	}
}
