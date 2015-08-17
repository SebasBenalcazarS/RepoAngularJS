package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueFactorDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaEstadoImpDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class FactoresRecepcionEmbarqueRestriction implements CriteriaRestriction, Logeable{
	private Integer codigoCompania;
	private String property = null;
	private String codigosClientes = null;
	
	/**
	 * @param codigoCompania
	 * @param property
	 * @param codigosClientes
	 */
	public FactoresRecepcionEmbarqueRestriction(Integer codigoCompania, String property, String codigosClientes) {
		super();
		this.codigoCompania = codigoCompania;
		this.property = property;
		this.codigosClientes = codigosClientes;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		try {
			//FACTORES
			DetachedCriteria subSelectFactores;
			subSelectFactores = DetachedCriteria.forClass(EmbarqueFactorDTO.class, "embarqueFactor");
			subSelectFactores.setProjection(Projections.distinct(Projections.property("embarqueFactor.codigoEmbarqueEstado")));
			subSelectFactores.add(Restrictions.eq("embarqueFactor.id.codigoCompania", codigoCompania));
			subSelectFactores.add(Restrictions.isNull("embarqueFactor.fechaFin"));
			subSelectFactores.add(Restrictions.eqProperty("embarqueFactor.codigoEmbarqueEstado", CriteriaSpecification.ROOT_ALIAS + ".id.codigoEmbarqueEstado"));
			
			criterion = Restrictions.or(Restrictions.and(Subqueries.propertyIn(this.property, getDetachedCriteriaFacturaEstado(Boolean.FALSE)), 
														 Subqueries.propertyCoalesce(this.property, ComparatorTypeEnum.EQUAL_COMPARATOR, "0", subSelectFactores)), 
										Subqueries.propertyIn(property, getDetachedCriteriaFacturaEstado(Boolean.TRUE)));
					
			
		} catch (Exception e) {
			throw new SICException("Se produjo un error al momento de armar la restricci\u00F3n factores/facturas por embarque");
		}
		return criterion;
	}
	
	/**
	 * Verifica si es factura
	 * de juguetes
	 * 
	 * @param esJuguete
	 * @return
	 */
	private DetachedCriteria getDetachedCriteriaFacturaEstado(Boolean esJuguete) throws SICException{
		DetachedCriteria subSelectFacturaEstado = null;
		try {
			subSelectFacturaEstado = DetachedCriteria.forClass(FacturaEstadoImpDTO.class, "facturaEstadoImp");
			subSelectFacturaEstado.setProjection(Projections.distinct(Projections.property("facturaEstadoImp.codigoEmbarqueEstado")));
			subSelectFacturaEstado.createAlias("facturaEstadoImp.factura", "factura");
			subSelectFacturaEstado.createAlias("factura.ordenCompraFacturas", "ordenCompraFacturas");
			subSelectFacturaEstado.createAlias("ordenCompraFacturas.ordenCompra", "ordenCompra");
			subSelectFacturaEstado.createAlias("ordenCompra.clienteImportacioComprador", "clienteImportacioComprador");
			subSelectFacturaEstado.createAlias("clienteImportacioComprador.clienteImportacion", "clienteImportacion");
			subSelectFacturaEstado.add((esJuguete) ? Restrictions.in("clienteImportacion.siglas", this.codigosClientes.split(",")) 
												   : Restrictions.not(Restrictions.in("clienteImportacion.siglas", this.codigosClientes.split(","))));
			subSelectFacturaEstado.add(Restrictions.eqProperty("facturaEstadoImp.codigoEmbarqueEstado", CriteriaSpecification.ROOT_ALIAS + ".id.codigoEmbarqueEstado"));
			subSelectFacturaEstado.add(Restrictions.eq("factura.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_LITERAL));//Estado activo de la factura
			subSelectFacturaEstado.add(Restrictions.isNull("facturaEstadoImp.fechaFin"));//Ultimo estado de la factura
		} catch (Exception e) {
			LOG_SICV2.error("Error al armar la restriccion para verificar si las facturas del embarque son de juguetes.");
			throw new SICException("Error al armar restricci\u00F3n de facturas de compradores de la l\u00EDnea comercial de JUGUETES");
		}
		return subSelectFacturaEstado;
	}
}
