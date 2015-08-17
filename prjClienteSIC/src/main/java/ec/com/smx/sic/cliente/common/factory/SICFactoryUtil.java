package ec.com.smx.sic.cliente.common.factory;

import java.util.HashSet;
import java.util.Set;

public class SICFactoryUtil {
	/**
	 * 
	 * @return
	 */
	public String[] getContextos(){

		Set<String> contextSet = new HashSet<String>();
		addContext(SICFactoryConstantes.CONTEXTO, contextSet);
		addContext(ArticuloFactoryConstantes.CONTEXTO,contextSet);
		addContext(AdministracionFactoryConstantes.CONTEXTO,contextSet);
		addContext(ProveedorFactoryConstantes.CONTEXTO,contextSet);
		addContext(SICOficinaExteriorFactoryConstantes.CONTEXTO,contextSet);
		addContext(OrdenCompraFactoryConstantes.CONTEXTO,contextSet);
		addContext(BodegaFactoryConstantes.CONTEXTO,contextSet);
		addContext(RecargaCuponFactoryConstantes.CONTEXTO,contextSet);
		addContext(CambioPreciosFactoryConstantes.CONTEXTO,contextSet);
		addContext(PedidoAsistidoFactoryConstantes.CONTEXTO,contextSet);
		addContext(RecipientesFactoryConstantes.CONTEXTO,contextSet);
		addContext(ProduccionFactoryConstantes.CONTEXTO, contextSet);
		addContext(ControlRutasFactoryConstantes.CONTEXTO,contextSet);
		addContext(OfertasFactoryConstantes.CONTEXTO,contextSet);
		addContext(ConveniosFactoryConstantes.CONTEXTO,contextSet);
		addContext(RecibidoNoContabilizadoFactoryConstantes.CONTEXTO, contextSet);
		addContext(ProcesamientoVentasFactoryConstantes.CONTEXTO, contextSet);
		addContext(FruverFactoryConstantes.CONTEXTO, contextSet);
		
		return contextSet.toArray(new String[contextSet.size()]);
	}

	private void addContext(String[] contextPaths,Set<String> contextSet){
		for (String contextPath : contextPaths) {
			contextSet.add(contextPath);
		}
	}
}
