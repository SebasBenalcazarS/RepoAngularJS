package ec.com.smx.sic.cliente.persistencia.proveedor.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;

import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;


/**
 * @author Marcelo Hidalgo
 * 
 */
public final class ProveedoresUtilDAO {

	private static Collection<AsignacionTipoDescuentoDTO> asignacionesTipoDescuentoMax;
	
	private static final ProveedoresUtilDAO INSTANCIA = new ProveedoresUtilDAO();

	private ProveedoresUtilDAO() {}

	public static ProveedoresUtilDAO getInstancia(){
		return INSTANCIA;
	}
	
	public Integer obtenerSecuencialAsignacionTipoDescuentoPorTipoAsignacion(Integer codigoCompania, String valorTipoAsignacion, String codigoTipoDescuento, String valorTipoAplicacion){
		if (CollectionUtils.isEmpty(asignacionesTipoDescuentoMax)){
			asignacionesTipoDescuentoMax = SICFactory.getInstancia().proveedor.getProveedorClasificacionServicio().obtenerSecuencialesAsignacionTipoDescuento(codigoCompania);
		}
		
		if(CollectionUtils.isNotEmpty(asignacionesTipoDescuentoMax)){
			Collection<Predicate> predicates = new ArrayList<Predicate>();
			
			predicates.add(PredicateUtils.transformedPredicate(new GetInvokerTransformer("codigoTipoDescuento"), PredicateUtils.equalPredicate(codigoTipoDescuento)));
			predicates.add(PredicateUtils.transformedPredicate(new GetInvokerTransformer("valorAsignacionTipoDescuento"), PredicateUtils.equalPredicate(valorTipoAsignacion)));
			predicates.add(PredicateUtils.transformedPredicate(new GetInvokerTransformer("valorAplicacionTipoDescuento"), PredicateUtils.equalPredicate(valorTipoAplicacion)));
			
			AsignacionTipoDescuentoDTO asignacionTipoDescuento = (AsignacionTipoDescuentoDTO) CollectionUtils.find(asignacionesTipoDescuentoMax, PredicateUtils.allPredicate(predicates));
			if(asignacionTipoDescuento != null){
				return asignacionTipoDescuento.getId().getSecuencialAsignacionTipoDescuento();
			}
		}
		return null;
	}
}
