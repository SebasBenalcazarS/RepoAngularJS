package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaEstadoImpDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class FacturasImportacionesPorEmbarqueRestriction implements CriteriaRestriction{
	
	private SearchTemplateDTO<String> numeroFactura;
	private SearchTemplateDTO<String> codigoProveedor = null;
	private SearchTemplateDTO<String> numeroDocumento = null;
	private BaseCriteriaRestriction nombreProveedor = null;
	private SearchTemplateDTO<String> numeroNotaPedido = null;
	private String property = null;
		
	/**
	 * @param numeroOrdenCompra
	 * @param property
	 */
	public FacturasImportacionesPorEmbarqueRestriction(SearchTemplateDTO<String> numeroFactura, SearchTemplateDTO<String> codigoProveedor,
													   SearchTemplateDTO<String> numeroDocumento, BaseCriteriaRestriction nombreProveedor, String property, SearchTemplateDTO<String> numeroNotaPedido) {
		super();
		this.numeroFactura = numeroFactura;
		this.codigoProveedor = codigoProveedor;
		this.numeroDocumento = numeroDocumento;
		this.nombreProveedor = nombreProveedor;
		this.numeroNotaPedido = numeroNotaPedido;
		this.property = property;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		try {
			DetachedCriteria subSelectFacturaEstado;
			subSelectFacturaEstado = DetachedCriteria.forClass(FacturaEstadoImpDTO.class, "facturaEstadoImp");
			subSelectFacturaEstado.setProjection(Projections.distinct(Projections.property("facturaEstadoImp.codigoEmbarqueEstado")));
			subSelectFacturaEstado.createAlias("facturaEstadoImp.factura", "factura");
			subSelectFacturaEstado.createAlias("factura.ordenCompraFacturas", "ordenCompraFacturas");
			subSelectFacturaEstado.createAlias("ordenCompraFacturas.ordenCompra", "ordenCompra");
			subSelectFacturaEstado.createAlias("ordenCompra.vistaProveedor", "proveedor");
			if (numeroFactura != null) {//fitro numero factura
				subSelectFacturaEstado.add(numeroFactura.addExpression());
			}
			//Filtros proveedor
			if (codigoProveedor != null) {//Codigo proveedor
				subSelectFacturaEstado.add(codigoProveedor.addExpression());
			}
			if (numeroDocumento != null) {//Numero documento
				subSelectFacturaEstado.add(numeroDocumento.addExpression());
			}
			if (nombreProveedor != null) {//Nombre proveedor
				subSelectFacturaEstado.add(nombreProveedor.getCriteriaRestriction());
			}
			
			if (numeroNotaPedido != null) {//Numero nota de pedido
				subSelectFacturaEstado.add(numeroNotaPedido.addExpression());
			}
			subSelectFacturaEstado.add(Restrictions.eq("factura.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_LITERAL));//Estado activo de la factura
			subSelectFacturaEstado.add(Restrictions.isNull("facturaEstadoImp.fechaFin"));//Ultimo estado de la factura
			criterion = Subqueries.propertyIn(this.property, subSelectFacturaEstado);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n facturas importaciones por embarque");
		}
		return criterion;
	}
}
