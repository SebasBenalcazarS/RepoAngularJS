/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import ec.com.smx.sic.cliente.resources.cambioprecios.SICCambioPreciosMessages;

/**
 * @author Victor Jaramillo
 *
 */
public enum DatosTablaPrecioArticulo {
	
	INDICE_TABLA(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.indice.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.indice.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.indice.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.indice.tooltip")),
			
	SELECCIONAR(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.seleccionar.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.seleccionar.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.seleccionar.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.seleccionar.tooltip")),			
			
	APLICAR(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.aplicar.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.aplicar.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.aplicar.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.aplicar.tooltip")),
			
	CODIGO_BARRAS(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigobarras.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigobarras.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigobarras.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigobarras.tooltip")),
	
	DESCRIPCION_ARTICULO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.descripcionArticulo.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.descripcionArticulo.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.descripcionArticulo.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.descripcionArticulo.tooltip")),
			
	COLUMN_MEDIDA_ARTICULO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.medida.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.medida.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.medida.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.medida.tooltip")),

	CLASE(  
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.clase.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.clase.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.clase.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.clase.tooltip")),
			
	PROVEEDORES_RELACIONADOS(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.proveedores.relacionados.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.proveedores.relacionados.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.proveedores.relacionados.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.proveedores.tooltip")),
			
	CONFLICTOS(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.tooltip")),
			
	CODIGO_PROVEEDOR(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigoProveedor.id")),
			
	CODIGO_JDE_PROVEEDOR(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigoJDEProveedor.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigoJDEProveedor.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigoJDEProveedor.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigoJDEProveedor.tooltip")),
	
	NOMBRE_PROVEEDOR(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.nombreProveedor.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.nombreProveedor.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.nombreProveedor.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.nombreProveedor.tooltip")),	
	
	COSTO_NETO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.final")),
			
	COSTO_MONEDA_ORIGEN(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costo.moneda.origen.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costo.moneda.origen.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costo.moneda.origen.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costo.moneda.origen.tooltip")),
			
	COSTO_DERECHO_IMPORTACION(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costo.derecho.importacion.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costo.derecho.importacion.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costo.derecho.importacion.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costo.derecho.importacion.tooltip")),
	
	COSTO_BRUTO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoBruto.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoBruto.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoBruto.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoBruto.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoBruto.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoBruto.final")),
	
	PRECIO_VENTA_PUBLICO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioPvp.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioPvp.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioPvp.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioPvp.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioPvp.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioPvp.final")),
	
	MARGEN_PVP(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenPvp.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenPvp.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenPvp.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenPvp.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenPvp.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenPvp.final")),
			
	PRECIO_SMX(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmx.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmx.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmx.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmx.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmx.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmx.final")),
			
	MARGEN_SMX(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenSmx.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenSmx.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenSmx.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenSmx.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenSmx.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.margenSmx.final")),
			
	TIPO_PRECIO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tipoPrecio.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tipoPrecio.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tipoPrecio.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tipoPrecio.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tipoPrecio.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tipoPrecio.final")),
			
	PRECIO_SMX_NA(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmxNa.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmxNa.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmxNa.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmxNa.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmxNa.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmxNa.final")),
			
	LOCAL(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.verlocal.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.verlocal.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.verlocal.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.verlocal.tooltip")),
			
	PROMOCION(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.promocion.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.promocion.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.promocion.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.promocion.tooltip")),
			
	CLASIFICACION(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.clasificacion.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.clasificacion.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.clasificacion.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.clasificacion.tooltip")),
			
	OBSERVACIONES_ARTICULO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.observacionesArticulo.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.observacionesArticulo.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.observacionesArticulo.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.observacionesArticulo.tooltip")),
			
	CODIGO_ARTICULO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigo.articulo")),	
			
	CODIGO_COMPANIA(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigo.compania")),
	
	CONDICIONES_GESTION_ARTICULO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.condiciones")),
	
	ESTADO_CONDICION_GESTION_ARTICULO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.estadoCondicion")),
	
	DESCUENTO_GESTION_ARTICULO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.descuento.columna.id")),
	
	LISTA_DESCUENTOS_GESTION_ARTICULO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.descuentos.lista.id")),
			
	USER_ID(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.user.id")),
	
	CODIGO_GESTIONPRECIO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigo.gestionprecio")),
	
	TIENE_PROVEEDORES_RELACIONADOS(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tiene.proveedores.relacionados")),
	
	TOGGLE(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.toggle")),
	
	ELIMINAR_PVP(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.eliminar.PVP")),
	
	LOCAL_TABLE_CODIGO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.local.codigo.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.local.codigo.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.local.codigo.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.local.codigo.tooltip")),
			
	LOCAL_TABLE_DESCRIPCION(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.local.nombre.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.local.nombre.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.local.nombre.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.local.nombre.tooltip")),
			
	PRECIO_SMX_PADRE(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmxPadre.id")),
	
	PRECIO_SMX_NA_PADRE(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmxNaPadre.id")),
	
	PORCENTAJE_NO_AFILIADO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentaje.noAfiliado.id")),
	
	COLUMNS_CAMBIO_PRECIOS(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.parametros.columnsCambioPrecios")),
	
	MODO_EDITAR_TABLA(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.parametros.editar")),
	
	MENSAJE_INICILIZACION_TABLA(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.parametros.mensajeInicial")),
	
	MENSAJE_ERROR_TABLA(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.parametros.mensajeError")),

	STYLE_ROW_SELECCIONADO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.rowStyleClass")),
	
	EXISTEN_CONFLICTOS(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.existenConflicto")),
	
	MENSAJES_CONFLICTOS(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.existeMsgConflictos")),
	
	TIENE_ARTICULOS_RELACIONADOS(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tieneArticuloRelacionado")),
	
	MENSAJE_VALIDACION(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.mensajesValidacion.id")),
	
	CODIGOS_TIPO_RELACION(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigosTiposRelaciones.id")),
	
	CODIGOS_ARTICULO_RELACION(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.codigosArticulosRelacion.id")),
	
	REGLAS_CALCULO_PRECIOS(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.reglasCalculoPrecios.id")),
	
	TIPOS_PRECIO_ARTICULO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.tiposPrecios.id")),
	
	CODIGO_ARTICULO_PRECIO_DIFERENCIADO(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioDifereciando.codigo.id")),
	
	ARTICULO_PRECIO_SMX(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.precioSmx.id"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmx.label"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.precioSmx.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.precioSmx.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.precioSmx.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.precioSmx.final")),
	
	ARTICULO_PORCENTAJE(SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.porcentaje.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.porcentaje.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.porcentaje.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.porcentaje.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.porcentaje.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.porcentaje.final")),
			
	ACCION(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.accion.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.accion.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.accion.field"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.conflictos.accion.tooltip"),
			null, null),
	COSTO_NETO_INCLUIDA_NOTA_CREDITO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.final")),
	COSTO_NETO_INCLUIDA_NOTA_CREDITO_VS_PVP(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.pvp.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.pvp.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.pvp.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.pvp.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.pvp.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.costoNeto.notaCredito.pvp.final")),
	PVP_VS_PRECIO_SUPERMAXI(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.precioSMX.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.precioSMX.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.precioSMX.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.precioSMX.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.precioSMX.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.precioSMX.final")),
	PVP_VS_COSTO_NETO_INCLUIDO_NOTA_CREDITO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.costoNeto.notaCredito.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.costoNeto.notaCredito.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.costoNeto.notaCredito.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.costoNeto.notaCredito.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.costoNeto.notaCredito.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.pvp.costoNeto.notaCredito.final")),
	VENTA_COSTONETO_NOTACREDITO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.ventaCostoNetoNC.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.ventaCostoNetoNC.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.ventaCostoNetoNC.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.ventaCostoNetoNC.tooltip"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.ventaCostoNetoNC.inicial"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.ventaCostoNetoNC.final")),
	VARIACION_COSTO_BRUTO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.variacionCostoBruto.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.variacionCostoBruto.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.variacionCostoBruto.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.variacionCostoBruto.tooltip")),
	PORCENTAJE_VARIACION_COSTO_BRUTO(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentajeVariacionCostoBruto.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentajeVariacionCostoBruto.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentajeVariacionCostoBruto.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentajeVariacionCostoBruto.tooltip")),
	VARIACION_VENTA(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.variacionVenta.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.variacionVenta.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.variacionVenta.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.variacionVenta.tooltip")),
	PORCENTAJE_VARIACION_VENTA(
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentajeVariacionVenta.id"),
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentajeVariacionVenta.label"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentajeVariacionVenta.field"), 
			SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.porcentajeVariacionVenta.tooltip"))
	;
			
	private String id;
	private String label;
	private String toolTip;
	private String field;
	private String inicio;
	private String fin;
	
	
	/**
	 * 
	 * @param id
	 * @param label	 
	 * @param field
	 */
	private DatosTablaPrecioArticulo(String id, String label, String field){
		this.id = id;
		this.label = label;		
		this.field = field;
	}
	
	

	/**
	 * 
	 * @param id	 
	 */
	private DatosTablaPrecioArticulo(String id){
		this.id = id;		
	}
	
	
	
	
	/**
	 * 
	 * @param id
	 * @param label
	 * @param toolTip
	 * @param field
	 */
	private DatosTablaPrecioArticulo(String id, String label, String field, String tooltip){
		this.id = id;
		this.label = label;
		this.toolTip=tooltip;
		this.field = field;
	}
	
	/**
	 * 
	 * @param id
	 * @param label
	 * @param toolTip
	 * @param field
	 * @param inicial
	 * @param final
	 */
	private DatosTablaPrecioArticulo(String id, String label, String field, String tooltip,String inicial,String fin){
		this.id = id;
		this.label = label;
		this.toolTip=tooltip;
		this.field = field;
		this.inicio = inicial;
		this.fin = fin;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the toolTip
	 */
	public String getToolTip() {
		return toolTip;
	}

	/**
	 * @param toolTip the toolTip to set
	 */
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	
	public String getInicial() {
		return inicio;
	}

	public void setInicial(String inicial) {
		this.inicio = inicial;
	}

	public String getfinal() {
		return fin;
	}

	public void setfinal(String fin) {
		this.fin = fin;
	}
}
