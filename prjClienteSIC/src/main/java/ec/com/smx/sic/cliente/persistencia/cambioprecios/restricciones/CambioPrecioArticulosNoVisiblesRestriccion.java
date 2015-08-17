/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoEjecucionGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoGestionPrecio;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;
import ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.GestionPrecioUtilDAO;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class CambioPrecioArticulosNoVisiblesRestriccion implements CriteriaRestriction{

	private Integer codigoComapania;

	public CambioPrecioArticulosNoVisiblesRestriccion(Integer codigoCompania) {
		this.codigoComapania = codigoCompania;
	}

	@Override
	public Criterion getCriteriaRestriction() {

		DetachedCriteria subSelectArtVig;
		Disjunction disjunctionVenta;
		Disjunction disjunctionCosto;
		
		disjunctionVenta = Restrictions.disjunction();
		disjunctionCosto = Restrictions.disjunction();
		
		subSelectArtVig = DetachedCriteria.forClass(ArticuloProveedorGestionPrecioDTO.class, "articuloProveedorGestionPrecio");
		subSelectArtVig.setProjection(Projections.property("articuloProveedorGestionPrecio.id.codigoArticulo"));
		
		subSelectArtVig.createAlias("articuloProveedorGestionPrecio.valorCostoGestion", "valorCostoGestion");
		subSelectArtVig.createAlias("articuloProveedorGestionPrecio.articuloGestionPrecio", "articuloGestionPrecio");
		subSelectArtVig.createAlias("articuloGestionPrecio.gestionPrecio", "gestionPrecio");
		
		// Fijar filtros por defecto articulo proveedor gestion precio
		subSelectArtVig.add(Restrictions.eq("articuloProveedorGestionPrecio.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
		// Fijar filtros gestion precio
		subSelectArtVig.add(Restrictions.eq("gestionPrecio.id.codigoCompania", this.codigoComapania));
		subSelectArtVig.add(Restrictions.eq("gestionPrecio.valorTipoGestionPrecio", TipoGestionPrecio.CAMBIO_PRECIO.getValorTipoGestionPrecio()));
		subSelectArtVig.add(Restrictions.eq("gestionPrecio.codigoTipoGestionPrecio", TipoGestionPrecio.CODIGO_TIPO_GESTION_PRECIO));

		// Fijar filtros articulo gestion precio
		subSelectArtVig.add(Restrictions.eq("articuloGestionPrecio.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		subSelectArtVig.add(Restrictions.eq("articuloGestionPrecio.codigoTipoEstado",EstadoGestionPrecio.CODIGO_ESTADO_GESTION_PRECIO));
		subSelectArtVig.add(Restrictions.eq("articuloGestionPrecio.codigoEstadoEjecucion",EstadoEjecucionGestionPrecio.CODIGO_ESTADO_EJECUCION_GESTION_PRECIO));
		
		disjunctionVenta.add(Restrictions.in("articuloGestionPrecio.valorTipoEstado", new String[]{
				EstadoGestionPrecio.CONFIRMADO.getValorEstadoGestionPrecio(),
				EstadoGestionPrecio.AUTORIZADO.getValorEstadoGestionPrecio(),
				EstadoGestionPrecio.DESAUTORIZADO.getValorEstadoGestionPrecio()}));
		disjunctionVenta.add(GestionPrecioUtilDAO.getInstancia().obtenerRestriccionEstadoEjecucionPorFinalizar("articuloGestionPrecio", "valorCostoGestion"));
		
		subSelectArtVig.add(disjunctionVenta);
		
		// Fijar filtros valor costo gestion
		subSelectArtVig.add(Restrictions.eq("valorCostoGestion.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		subSelectArtVig.add(Restrictions.eq("valorCostoGestion.codigoTipoEstado",EstadoGestionPrecio.CODIGO_ESTADO_GESTION_PRECIO));
		subSelectArtVig.add(Restrictions.eq("valorCostoGestion.codigoEstadoEjecucion",EstadoEjecucionGestionPrecio.CODIGO_ESTADO_EJECUCION_GESTION_PRECIO));
		
		disjunctionCosto.add(Restrictions.in("valorCostoGestion.valorTipoEstado", new String[]{
				EstadoGestionPrecio.CONFIRMADO.getValorEstadoGestionPrecio(),
				EstadoGestionPrecio.AUTORIZADO.getValorEstadoGestionPrecio(),
				EstadoGestionPrecio.DESAUTORIZADO.getValorEstadoGestionPrecio()}));
		disjunctionCosto.add(GestionPrecioUtilDAO.getInstancia().obtenerRestriccionEstadoEjecucionPorFinalizar("articuloGestionPrecio", "valorCostoGestion"));
		
		subSelectArtVig.add(disjunctionCosto);
		
		return Subqueries.propertyNotIn("id.codigoArticulo", subSelectArtVig);
	}
}