/**
 * 
 */
package ec.com.smx.sic.cliente.common.bodega;

import java.util.HashMap;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author jmontenegro
 *
 */
public class UbicacionesUtils {

	private static final UbicacionesUtils INSTANCIA = new UbicacionesUtils();

	
	
	public void addJoinBusquedaUbicaciones(Criteria criteria,Set<EnumValorFiltrosUbicacion> join){
		
		criteria.createAlias("detalleSeccionPadreDTO", "detSecNav");
		criteria.createAlias("detSecNav.seccionDTO", "seccNav");
		criteria.createAlias("detalleSeccionDTO", "detSecSubNav");
		criteria.createAlias("detSecSubNav.seccionDTO", "seccSubNav");
		
		criteria.createAlias("detSecSubNav.relacionSeccionPadreCol", "relSe2");
		criteria.createAlias("relSe2.detalleSeccionDTO", "detSecPas");
		criteria.createAlias("detSecPas.seccionDTO", "seccPas");
		
		criteria.createAlias("detSecPas.relacionSeccionPadreCol", "relSe3");
		criteria.createAlias("relSe3.detalleSeccionDTO", "detSecRac");
		criteria.createAlias("detSecRac.seccionDTO", "seccRac");
		
		criteria.createAlias("detSecRac.relacionSeccionPadreCol", "relSe4");
		criteria.createAlias("relSe4.detalleSeccionDTO", "detSecUbi");
		criteria.createAlias("detSecUbi.seccionDTO", "seccUbi");
		
		if(join != null && join.contains(EnumValorFiltrosUbicacion.AREA)){
			criteria.createAlias("detSecUbi.relacionSeccionCol", "relSe5");
			criteria.createAlias("relSe5.detalleSeccionPadreDTO", "detSecArea");
			criteria.createAlias("detSecArea.seccionDTO", "seccArea");
		}
		
		if(join != null && join.contains(EnumValorFiltrosUbicacion.ISARTICULO)){
			criteria.createAlias("detSecUbi.asignacionArticuloUnidadManejoCol", "asigUniMan", CriteriaSpecification.LEFT_JOIN,Restrictions.eq("asigUniMan.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.createAlias("asigUniMan.articuloUnidadManejoDTO", "artUniMan", CriteriaSpecification.LEFT_JOIN,Restrictions.eq("artUniMan.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.createAlias("artUniMan.articulo", "articulo", CriteriaSpecification.LEFT_JOIN,Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		}
		
		if(join != null && join.contains(EnumValorFiltrosUbicacion.AREAT)){
			criteria.createAlias("detSecUbi.relacionSeccionCol", "relSe5");
			criteria.createAlias("relSe5.detalleSeccionPadreDTO", "detSecArea");
			criteria.createAlias("detSecArea.seccionDTO", "seccArea");
		}
	}
	
	
	public Criterion addRestriccionBusquedaUbicacionesBasicas(Set<EnumValorFiltrosUbicacion> join){

		Conjunction conjunction = new Conjunction();
		
		conjunction.add(Restrictions.eq("relSecc.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("detSecNav.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("seccNav.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("detSecSubNav.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("seccSubNav.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("relSe2.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("detSecPas.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("seccPas.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("relSe3.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("detSecRac.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("seccRac.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("relSe4.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("detSecUbi.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		conjunction.add(Restrictions.eq("seccUbi.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));

		if(join != null && join.contains(EnumValorFiltrosUbicacion.AREA)){
			conjunction.add(Restrictions.eq("relSe5.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			conjunction.add(Restrictions.eq("detSecArea.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			conjunction.add(Restrictions.eq("seccArea.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		}
		
		conjunction.add(Restrictions.eq("seccNav.valorTipoSeccion", SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_NAVE));
		conjunction.add(Restrictions.eq("seccSubNav.valorTipoSeccion", SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_SUBNAVE));
		conjunction.add(Restrictions.eq("seccPas.valorTipoSeccion", SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_PASILLO));
		conjunction.add(Restrictions.eq("seccRac.valorTipoSeccion", SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_RACK));
		conjunction.add(Restrictions.eq("seccUbi.valorTipoSeccion", SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION));
		if(join != null && join.contains(EnumValorFiltrosUbicacion.AREA)){
			conjunction.add(Restrictions.eq("seccArea.valorTipoSeccion", SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_AREA)); 
		}
		conjunction.add(Restrictions.eq("detSecUbi.valorTipoUbicacion",SICBodegaConstantes.CODIGO_VALOR_TIPO_UBICACION_FISICA ));
		conjunction.add(Restrictions.eq("detSecUbi.codigoTipoUbicacion",SICBodegaConstantes.CODIGO_TIPO_UBICACION ));
		
		return conjunction;
	}
	
	public Criterion addRestriccionBusquedaUbicacionesFilter(HashMap<EnumValorFiltrosUbicacion, Object> filter){
		
		Conjunction conjunction = new Conjunction();
		
		if(filter.containsKey(EnumValorFiltrosUbicacion.SUBNAVE)){				
			conjunction.add(Restrictions.eq("detSecSubNav.identificador",filter.get(EnumValorFiltrosUbicacion.SUBNAVE).toString()));
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.PASILLO_INICIAL) || filter.containsKey(EnumValorFiltrosUbicacion.PASILLO_FINAL)){
			Long pasIni;
			Long pasFin;
			
			if(filter.containsKey(EnumValorFiltrosUbicacion.PASILLO_INICIAL) && filter.containsKey(EnumValorFiltrosUbicacion.PASILLO_FINAL)){
				pasIni = Long.valueOf(filter.get(EnumValorFiltrosUbicacion.PASILLO_INICIAL).toString());
				pasFin =  Long.valueOf(filter.get(EnumValorFiltrosUbicacion.PASILLO_FINAL).toString());
				
				conjunction.add(Restrictions.between("detSecPas.ordenar", pasIni, pasFin));
			}else if(filter.containsKey(EnumValorFiltrosUbicacion.PASILLO_INICIAL)){
				pasIni = Long.valueOf(filter.get(EnumValorFiltrosUbicacion.PASILLO_INICIAL).toString());
				
				conjunction.add(Restrictions.ge("detSecPas.ordenar", pasIni));
			}else if(filter.containsKey(EnumValorFiltrosUbicacion.PASILLO_FINAL)){
				pasFin = Long.valueOf(filter.get(EnumValorFiltrosUbicacion.PASILLO_FINAL).toString());
				
				conjunction.add(Restrictions.le("detSecPas.ordenar", pasFin));
			}
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.RACK_INICIAL) || filter.containsKey(EnumValorFiltrosUbicacion.RACK_FINAL)){
			Long rackIni;
			Long rackFin;
			
			if(filter.containsKey(EnumValorFiltrosUbicacion.RACK_INICIAL) && filter.containsKey(EnumValorFiltrosUbicacion.RACK_FINAL)){
				rackIni = Long.valueOf(filter.get(EnumValorFiltrosUbicacion.RACK_INICIAL).toString());
				rackFin = Long.valueOf(filter.get(EnumValorFiltrosUbicacion.RACK_FINAL).toString());
				
				conjunction.add(Restrictions.between("detSecRac.ordenar", rackIni, rackFin));
			}else if(filter.containsKey(EnumValorFiltrosUbicacion.RACK_INICIAL)){
				rackIni = Long.valueOf(filter.get(EnumValorFiltrosUbicacion.RACK_INICIAL).toString());
				
				conjunction.add(Restrictions.ge("detSecRac.ordenar", rackIni));
			}else if(filter.containsKey(EnumValorFiltrosUbicacion.RACK_FINAL)){
				rackFin = Long.valueOf(filter.get(EnumValorFiltrosUbicacion.RACK_FINAL).toString());
				
				conjunction.add(Restrictions.le("detSecRac.ordenar", rackFin));
			}
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.AREA)){
			Long codSec = Long.valueOf(filter.get(EnumValorFiltrosUbicacion.AREA).toString());
			
			conjunction.add(Restrictions.eq("seccArea.id.codigoSeccion", codSec));
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.TIPOALMACENAMIENTO)){
			
			conjunction.add(Restrictions.eq("detSecUbi.valorTipoAlmacenamiento", filter.get(EnumValorFiltrosUbicacion.TIPOALMACENAMIENTO).toString()));
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.CODIGOBARRAS)){
			
			conjunction.add(Restrictions.like("articulo.codigoBarras", filter.get(EnumValorFiltrosUbicacion.CODIGOBARRAS).toString(),MatchMode.ANYWHERE));
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.CODIGOBARRASUNIDADMANEJO)){
			conjunction.add(Restrictions.like("artUniMan.codigoBarrasUnidadManejo", filter.get(EnumValorFiltrosUbicacion.CODIGOBARRASUNIDADMANEJO).toString(),MatchMode.ANYWHERE));
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.DESCRIPCIONARTICULO)){
			
			conjunction.add(Restrictions.like("articulo.descripcionArticulo", filter.get(EnumValorFiltrosUbicacion.DESCRIPCIONARTICULO).toString(),MatchMode.ANYWHERE));
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.UBICACION_INICIAL)){
			
			conjunction.add(Restrictions.like("detSecUbi.identificador", filter.get(EnumValorFiltrosUbicacion.UBICACION_INICIAL).toString(),MatchMode.ANYWHERE));
		}
		if(filter.containsKey(EnumValorFiltrosUbicacion.CANTIDADUNIDADMANEJO)){
			Integer cant = Integer.valueOf(filter.get(EnumValorFiltrosUbicacion.CANTIDADUNIDADMANEJO).toString());
			conjunction.add(Restrictions.eq("asigUniMan.cantidad", cant));
		}
		
		return conjunction;
	}
	
	
	
	
	
	
	/**
	 * @return the instancia
	 */
	public static UbicacionesUtils getInstancia() {
		return INSTANCIA;
	}
	
	
	
}
