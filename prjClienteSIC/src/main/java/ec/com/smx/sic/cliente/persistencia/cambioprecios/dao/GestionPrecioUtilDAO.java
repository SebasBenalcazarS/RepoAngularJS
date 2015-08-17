package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.shard.ShardNamingStrategy;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoEjecucionGestionPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;

/**
 * @author Marcelo Hidalgo
 * 
 */
public final class GestionPrecioUtilDAO {

	private static final GestionPrecioUtilDAO INSTANCIA = new GestionPrecioUtilDAO();

	private GestionPrecioUtilDAO() {}

	public static GestionPrecioUtilDAO getInstancia(){
		return INSTANCIA;
	}

	public void completarArticuloCriteriaPlantilla(Criteria criteria, String aliasArticulo, Integer codigoCompania) throws SICException {

		try {
			if(criteria != null && StringUtils.isNotEmpty(aliasArticulo) && codigoCompania != null) {

				// Joins
				criteria.createAlias(aliasArticulo+".clasificacionDTO", "clasificacion");
				criteria.createAlias(aliasArticulo+".articuloComercialDTO", "artCom");
				criteria.createAlias(aliasArticulo+".articuloMedidaDTO", "artMed");	
				criteria.createAlias(aliasArticulo+".articuloPrecioCol", "artPreCol", CriteriaSpecification.LEFT_JOIN);				

				// Where
				criteria.add(Restrictions.eq(aliasArticulo+".id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq(aliasArticulo+".estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.add(Restrictions.eq(aliasArticulo+".codigoEstado", SICArticuloConstantes.ESTADOARTICULO_CODIFICADO));
				criteria.add(Restrictions.eq(aliasArticulo+".codigoTipoArticulo", SICArticuloConstantes.CODIGO_TIPOARTICULO_PRODUCTO));
				criteria.add(Restrictions.eq("artPreCol.estadoPrecio", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.add(Restrictions.eq("clasificacion.valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
				criteria.add(Restrictions.eq("clasificacion.codigoTipoEstructura", TiposCatalogoConstantes.TIPO_ESTRUCTURA));

			}
		} catch (Exception e) {
			throw new SICException("Ocurrio un ERROR al obtener la plantilla de articulo");
		}
	}

	public void completarArticuloProveedorCriteriaPlantilla(Criteria criteria, String aliasArticuloProveedor, Integer codigoCompania) throws SICException {
		try {
			// Joins
			criteria.createAlias(aliasArticuloProveedor + ".descuentoProveedorArticuloCol", "descuentoProveedorArticuloCol", CriteriaSpecification.LEFT_JOIN, Restrictions.eq("descuentoProveedorArticuloCol.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.createAlias("descuentoProveedorArticuloCol.equivalenciaPorcentajeDescuento", "equivalenciaPorcentajeDescuento", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("descuentoProveedorArticuloCol.asignacionTipoDescuento", "asignacionTipoDescuentoProArt", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias(aliasArticuloProveedor + ".unidadesManejo", "unidadesManejo", CriteriaSpecification.LEFT_JOIN, Restrictions.eq("unidadesManejo.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.createAlias("unidadesManejo.equivalenciaPorcentajeDescuentoCol", "equivalenciaPorcentajeDescuentoCol", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("equivalenciaPorcentajeDescuentoCol.asignacionTipoDescuento", "asignacionTipoDescuentoEquUniMan", CriteriaSpecification.LEFT_JOIN);

			// Where
			criteria.add(Restrictions.eq(aliasArticuloProveedor + ".id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq(aliasArticuloProveedor + ".estadoArticuloProveedor", SICConstantes.ESTADO_ACTIVO_NUMERICO));

		} catch (Exception e) {
			throw new SICException("Ocurrio un ERROR al obtener la plantilla de articulo proveedor");
		}
	}

	public Disjunction obtenerRestriccionEstadoEjecucionPorFinalizar(String aliarArticuloGestionPrecio, String aliasValorCostoGestion) {
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.neProperty(aliarArticuloGestionPrecio + ".valorEstadoEjecucion", aliasValorCostoGestion + ".valorEstadoEjecucion"));
		disjunction.add(Restrictions.eq(aliarArticuloGestionPrecio + ".valorEstadoEjecucion", EstadoEjecucionGestionPrecio.PROCESADO.getValorEstadoEjecucionGestionPrecio()));
		disjunction.add(Restrictions.eq(aliasValorCostoGestion + ".valorEstadoEjecucion", EstadoEjecucionGestionPrecio.PROCESADO.getValorEstadoEjecucionGestionPrecio()));
		
		return disjunction;
	}
	
	/**
	 * Obtener los locales de un articulo especifico
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoArticuloPrecioDiferenciado
	 * @param codigoEstablecimiento
	 * @return
	 */
	public Criterion obtenerAreaTrabajoArticulo(Integer codigoCompania, String codigoArticulo, Long codigoArticuloPrecioDiferenciado, Integer codigoEstablecimiento) {
		DetachedCriteria subSelectArtLoc;
		Disjunction disjunction;
		
		try {
			disjunction = Restrictions.disjunction();
			
			// Complementa con el subfijo LOC a SCSADTART, es decir trae de base SCSADTARTLOC
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			// Select
			subSelectArtLoc = DetachedCriteria.forClass(ArticuloLocalDTO.class,"artloc");
			
			// Join
			if (codigoEstablecimiento == null)
				subSelectArtLoc.createAlias("artloc.local", "aretra", CriteriaSpecification.INNER_JOIN);
			
			// Where
			subSelectArtLoc.add(Restrictions.eq("artloc.id.codigoCompania", codigoCompania));
			subSelectArtLoc.add(Restrictions.eq("artloc.id.codigoArticulo", codigoArticulo));
			subSelectArtLoc.add(Restrictions.eq("artloc.estadoArticuloLocal", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			if (codigoEstablecimiento == null) {
				subSelectArtLoc.add(Restrictions.eq("aretra.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
				subSelectArtLoc.add(Restrictions.eqProperty("est.id.codigoEstablecimiento", "aretra.codigoEstablecimiento"));
			}	
			else 
				subSelectArtLoc.add(Restrictions.eqProperty("artloc.id.codigoLocal", "aretra.id.codigoAreaTrabajo"));
			
			if (codigoArticuloPrecioDiferenciado != null) {
				disjunction.add(obtenerArticuloLocalPrecio(codigoArticuloPrecioDiferenciado));
				disjunction.add(obtenerArticuloLocalGestionPrecio(codigoArticuloPrecioDiferenciado));
				subSelectArtLoc.add(disjunction);
			}
			
			// Campos
			if (codigoEstablecimiento == null)
				subSelectArtLoc.setProjection(Projections.property("aretra.codigoEstablecimiento"));
			else
				subSelectArtLoc.setProjection(Projections.property("artloc.id.codigoArticulo"));
			
			return Subqueries.exists(subSelectArtLoc);
			
		} catch (Exception e) {
			throw new SICException("Ha ocurrido un error al obtener los locales de los articulos. Metodo: obtenerAreaTrabajoArticulo().. ", e);
		}
	}
	
	/**
	 * Obtener datos de articulo local precio
	 * 
	 * @param codigoArticuloPrecioDiferenciado
	 * @return
	 */
	private Criterion obtenerArticuloLocalPrecio(Long codigoArticuloPrecioDiferenciado) {
		DetachedCriteria subSeltArtLocPre;
		
		try {
			// Select
			subSeltArtLocPre = DetachedCriteria.forClass(ArticuloLocalPrecioDTO.class,"artlocpre");
			
			// Where
			subSeltArtLocPre.add(Restrictions.eq("artlocpre.id.codigoTipoPrecio", SICArticuloConstantes.TIPO_PRECIO_BASE));
			subSeltArtLocPre.add(Restrictions.eq("artlocpre.secuencialPrecioDiferenciado", codigoArticuloPrecioDiferenciado));
			subSeltArtLocPre.add(Restrictions.eq("artlocpre.estadoPrecio", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			subSeltArtLocPre.add(Restrictions.eqProperty("artlocpre.id.codigoArticulo", "artloc.id.codigoArticulo"));
			
			subSeltArtLocPre.add(Restrictions.eqProperty("artlocpre.id.codigoCompania", "aretra.id.codigoCompania"));
			subSeltArtLocPre.add(Restrictions.eqProperty("artlocpre.id.codigoLocal", "aretra.id.codigoAreaTrabajo"));
			
			subSeltArtLocPre.setProjection(Projections.property("artlocpre.id.codigoLocal"));
			
			return Subqueries.exists(subSeltArtLocPre);
			
		} catch (Exception e) {
			throw new SICException("Ha ocurrido un error al obtener datos de articulo local precio. Metodo: obtenerArticuloLocalPrecio().. ", e);
		}
	}
	
	/**
	 * Obtener datos de articulo local gestion precios
	 * 
	 * @param codigoArticuloPrecioDiferenciado
	 * @return
	 */
	private Criterion obtenerArticuloLocalGestionPrecio(Long codigoArticuloPrecioDiferenciado) {
		DetachedCriteria subSeltArtLocGesPre;
		
		try {
			// Select
			subSeltArtLocGesPre = DetachedCriteria.forClass(ArticuloLocalGestionPrecioDTO.class,"artlocgespre");
			
			// Where
			subSeltArtLocGesPre.add(Restrictions.eq("artlocgespre.secuencialPreDif", codigoArticuloPrecioDiferenciado));
			subSeltArtLocGesPre.add(Restrictions.eq("artlocgespre.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			subSeltArtLocGesPre.add(Restrictions.eqProperty("artlocgespre.codigoArticulo", "artloc.id.codigoArticulo"));
			
			subSeltArtLocGesPre.add(Restrictions.eqProperty("artlocgespre.id.codigoCompania", "aretra.id.codigoCompania"));
			subSeltArtLocGesPre.add(Restrictions.eqProperty("artlocgespre.codigoLocal", "aretra.id.codigoAreaTrabajo"));
			
			subSeltArtLocGesPre.setProjection(Projections.property("artlocgespre.codigoLocal"));
			
			return Subqueries.exists(subSeltArtLocGesPre);
			
		} catch (Exception e) {
			throw new SICException("Ha ocurrido un error al obtener datos de articulo local gestion precios. Metodo: obtenerArticuloLocalGestionPrecio().. ", e);
		}
	}
}
