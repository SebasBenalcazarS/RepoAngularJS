package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.restricciones;

import java.util.Date;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.pedidoAsistido.ComparadorBodegaPereciblesUtil;
import ec.com.smx.sic.cliente.common.pedidoAsistido.SICPedidoAsistidoConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoClaseDTO;

/**
 * @author finga
 * 
 */
@SuppressWarnings("serial")
public class ClasesArticulo implements CriteriaRestriction, Logeable {

	private String propertyClasePedido;
	private String propertyArticuloTemporada;
	private Integer codigoCompania;
	private Integer codigoBodega;

	/**
	 * Restricci&oacute;n para obtener las clases de art&iacute;culos disponibles para pedido asistido
	 * 
	 * @param codigoCompania
	 * @param propertyIn
	 */
	public ClasesArticulo(String propertyClasePedido, String propertyArticuloTemporada, Integer codigoCompania, Integer codigoBodega) {
		this.propertyClasePedido = propertyClasePedido;
		this.propertyArticuloTemporada = propertyArticuloTemporada;
		this.codigoCompania = codigoCompania;
		this.codigoBodega = codigoBodega;
	}

	/**
	 * @see ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction#getCriteriaRestriction()
	 */
	@Override
	public Criterion getCriteriaRestriction() throws SICException {

		Conjunction resultado = null;
		Date fechaActual = new Date();

		try {
			//clases de articulos para pedido asistido
			DetachedCriteria clasesPedido = DetachedCriteria.forClass(ProcesoClaseDTO.class, "procesoClase");
			clasesPedido.setProjection(Projections.property("procesoClase.id.codigoClaseArticulo"));
			clasesPedido.add(Restrictions.eq("procesoClase.id.codigoProceso", SICPedidoAsistidoConstantes.CODIGO_PROCESO_PEDIDO_ASISTIDO));
			clasesPedido.add(Restrictions.eq("procesoClase.id.codigoCompania", codigoCompania));
			clasesPedido.add(Restrictions.eq("procesoClase.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			Criterion clasesPedidoAsistido = Subqueries.propertyIn(this.propertyClasePedido, clasesPedido);
			
			//validacion articulo temporada
			Conjunction conjunction = Restrictions.conjunction();
			conjunction.add(Restrictions.eq(this.propertyClasePedido, SICPedidoAsistidoConstantes.CODIGO_CLASE_TEMPORADA));
			conjunction.add(Restrictions.le(SearchDTO.getPropertyAlias(this.propertyArticuloTemporada).concat(".fechaInicioTemporada"), fechaActual));
			conjunction.add(Restrictions.ge(SearchDTO.getPropertyAlias(this.propertyArticuloTemporada).concat(".fechaFinTemporada"), fechaActual));

			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.ne(this.propertyClasePedido, SICPedidoAsistidoConstantes.CODIGO_CLASE_TEMPORADA));
			disjunction.add(conjunction);

			//resultado
			resultado = Restrictions.conjunction();
			resultado.add(clasesPedidoAsistido);
			resultado.add(disjunction);
			
			//validacion si es subbodega de perecibles
			if(ComparadorBodegaPereciblesUtil.verificarBodegaPerecibles(this.codigoBodega)){
				resultado.add(Restrictions.not(Restrictions.in(this.propertyClasePedido, new String[]{ 
						SICPedidoAsistidoConstantes.CODIGO_CLASE_NOOBS_NORES, SICPedidoAsistidoConstantes.CODIGO_CLASE_OBSOLETA})));
			}
		} catch (Exception e) {
			LOG_SICV2.error("Se produjo un error al momento de armar la restriccion: {}",e);
			throw new SICException("Se produjo un error al momento de armar la restriccion");
		}

		return resultado;
	}

}
