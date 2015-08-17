package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

public enum EnumComponentesArticulos {
			MAX_ART_ADM_DATGEN(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.datosGenerales")),
			MAX_ART_ADM_DATCOM(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.datosComerciales")),
			MAX_ART_ADM_REGSAN(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.registroSanitario")),
			MAX_ART_ADM_IMPREGSAN(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.impresionRegSan")),
			MAX_ART_ADM_EDIREGSAN(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.editarRegSan")),
			MAX_ART_ADM_DATETI(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.datosEtiqueta")),
			MAX_ART_ADM_LEYETI(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.leyEtiquetado")),
			MAX_ART_ADM_EDILEYETI(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.leyEtiquetado.edicion")),
			MAX_ART_ADM_ETIMERC(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.etiquetadoMercancias")),
			MAX_ART_ADM_EDIETIMERC(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.etiquetadoMercancias.edicion")),
			MAX_ART_ADM_ETIPRE(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.etiquetadoPrecios")),
			MAX_ART_ADM_DATLOG(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.datosLogisticos")),
			MAX_ART_ADM_CREART(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.nuevo")),
			MAX_ART_BUS_ARCCUP(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.cupon.archivo")),
			MAX_ART_ADM_GENETISEM(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.etiquetas.archivo")),
			MAX_ART_BUS_COL_COS(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.visualizarCostos")),
			MAX_ART_BUS_COL_MARPAR(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.visualizarMarcaParticipacion")),
			MAX_ART_ADM_GUAART(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.guardar")),
			MAX_ART_BUS_ART(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda")),
			MAX_ART_BUS_FIL_ART(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.articulo")),
			MAX_ART_BUS_FIL_ART_CODUNI(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.articulo.codigoUnico")),
			MAX_ART_BUS_FIL_ART_CODBAR(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.articulo.codigoBarras")),
			MAX_ART_BUS_FIL_REGSAN(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.registroSanitario")),
			MAX_ART_BUS_FIL_ESTCOM(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.estructuraComercial")),
			MAX_ART_BUS_FIL_SUBBOD(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.subbodega")),
			MAX_ART_BUS_FIL_PRO(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.proveedores")),
			MAX_ART_BUS_NOT(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.notificacion")),
			MAX_ART_BUS_REP(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.filtros.reporte")),
			MAX_ART_ADM_EDIARTCAB(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.edicion.cabecera")),
			MAX_ART_BUS_OPTTBL(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.opcionesTabla")),
			MAX_ART_ADM_EDIAPLREGSAN(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.edicion.regsan.aplica")),
			MAX_ART_ADM_MER_GAR(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.tab.garantias.mercancias"));
	
	private final String componentId;

	private EnumComponentesArticulos(String componentId) {
		this.componentId = componentId;
	}

	public String getComponentId() {
		return componentId;
	}
}
