package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los enumerados de los tipos de catalogos que intervienen en los procesos de bodega
 * @author fcollaguazo
 *
 */
public enum EnumTipoCatalogoBodega {
	
	TIPO_BODEGA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.tipo.bodega")),
	TIPO_SECCION(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.ubicacion.codigo.tipo.seccion")),
	TIPO_UBICACION(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.ubicacion.codigo.tipo.ubicacion")),
	TIPO_PROCESO(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.proceso")),
	TIPO_ALMACENAMIENTO(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.almacenamiento")),
	TIPO_SENTIDO_PASILLO(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.pasillo.codigo.tipo.sentido")),
	TIPO_AREA_TRABAJO(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.area.trabajo")),
	TIPO_TAREAS_MONTACARGISTA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.tareas.montacarguista")),
	TIPO_ENTREGA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.entrega")),
	TIPO_CONFIGURACION_RECEPCION(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.configuracion.recepcion")),
	TIPO_GRAVEDAD(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.gravedad")),
	TIPO_VALIDACION_FACTURAS(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.codigo.catalogo.configuracion.validacion.facturas")),
	TIPO_RELACION_DETALLES_ORDEN_COMPRA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.relacion.detalles.orden.compra")),
	TIPO_VALIDACION_PROCESO_RECEPCION(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.codigo.catalogo.tipo.validacion.recepcion")),
	TIPO_CONTROL_LOGISTICO(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.control.logistico")),
	TIPO_UBICACION_DESPACHO(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.recepcion.tipo.ubicacion.despacho")),
	TIPO_MARCA_PALLET(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.codigo.catalogo.tipo.marca.pallet.recepcion")),
	
	TIPO_ESTADO_PALLET(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.pallets.tipo.estado.pallet")),
	TIPO_ESTADO_TAREA_RECIBIDOR(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.estado.tarea.recibidor")),
	TIPO_ESTADO_TAREA_RECOLECTOR(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.estado.tarea.recolector")),
	TIPO_ESTADO_TAREA_MONTACARGUISTA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.estado.tarea.montacarguista")),
	
	TIPO_ACCIONES_RECOLECTOR(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tarea.recolector.accion.recolector")),
	TIPO_ACCIONES_RECIBIDOR(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tarea.recibidor.accion.recibidor")),
	TIPO_ACCION_TAREA_MONTACARGUISTA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.accion.tarea.montacarguista")),
	TIPO_ACCION_ESTADOS_PALLET(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.pallets.tipo.accion.estado.pallet")),
	TIPO_ESTADO_USUARIO_PERFIL(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.estado.usuario.perfil")),
	
	// Relacion furgon con anden del calendario planificacion
	TIPO_FURGON_CALENDARIO_BODEGA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.calendario.entregas.codigo.tipo.seccion")),
	
	// Relacion del estado del funcionadio con el tipo tarea 
	TIPO_ESTADO_FUNCIONARIO_TAREA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.estado.funcionario.tipo.tarea")),
	
	// Relacion de la tabla tarea con el monitor de procesos logistico (se debe hacer left o inner join al consulta los proceso logisticos)
	TIPO_RELACION_TAREA_MONITOR_PROCESO_LOGISTICO(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.catalogo.relacion.tabla.tarea.monitor.abastos.codigo.catalogo.tipo"))
	;
	
	private Integer tipoCatalogo;
	
	private EnumTipoCatalogoBodega(Integer tipoCatalogo){
		this.tipoCatalogo = tipoCatalogo;
	}

	/**
	 * @return the tipoCatalogo
	 */
	public Integer getTipoCatalogo() {
		return tipoCatalogo;
	}

	/**
	 * @param tipoCatalogo the tipoCatalogo to set
	 */
	public void setTipoCatalogo(Integer tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}
}
