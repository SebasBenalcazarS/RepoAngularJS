/*
 * Kruger 2014 
 */
package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * <b> Contiene las constantes usadas en la recepcion de juguetes. </b>
 * 
 * @author mchiliquinga, Date: 09/04/2014
 * 
 */
public interface IConstantesRecepcionJuguetes {

	String CODIGO_BARRAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.tipo.codigo.barras");

	String NOMBRE_CODIGO_BARRAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.tipo.codigo.barras.nombre");

	String CODIGO_INTERNO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.tipo.codigo.interno");

	String NOMBRE_CODIGO_INTERNO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.tipo.codigo.interno.nombre");

	String COLUMNA_EMBARQUE= SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.embarque");

	String COLUMNA_DESCRIPCION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.descipcionArticulo");

	String COLUMNA_UNIDAD_EMPAQUE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.unidadEmpaque");

	String COLUMNA_EMPAQUE_VALOR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.cantidadUnidadManejo");
	/**
	 * Define codigo de barras del articulo es EAN o INT
	 */
	String COLUMNA_TIPO_CODIGO_ARTICULO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.tipoCodigoArticulo");

	String COLUMNA_CODIGO_BARRAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.codigoBarras");

	String COLUMNA_CANTIDAD_DISPONIBLE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.cantidadDisponible");

	String COLUMNA_CODIGO_ARTICULO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.codigoArticulo");

	String COLUMNA_CODIGO_REFERENCIA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.codigoReferenciasProvedor");

	String COLUMNA_TAMANIO_ARTICULO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.tamanio");
	/**
	 * Define si es el articulo es precodificado o cidificado (PCO, COD)
	 */
	String COLUMNA_ESTADO_ARTICULO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.estadoArticulo");
	
	String COLUMNA_EMBARQUE_NOMBRE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.embarque.nombre");

	String COLUMNA_DESCRIPCION_NOMBRE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.descipcionArticulo.nombre");

	String COLUMNA_UNIDAD_EMPAQUE_NOMBRE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.unidadEmpaque.nombre");

	String COLUMNA_EMPAQUE_VALOR_NOMBRE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.cantidadUnidadManejo.nombre");
	
	String COLUMNA_EMPAQUE_VALOR_TOOLTIP = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.cantidadUnidadManejo.toolTip");
	
	String COLUMNA_TIPO_CODIGO_ARTICULO_NOMBRE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.tipoCodigoArticulo.nombre");
	
	String COLUMNA_TIPO_CODIGO_ARTICULO_TOOLTIP = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.tipoCodigoArticulo.toolTip");

	String COLUMNA_CODIGO_BARRAS_NOMBRE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.codigoBarras.nombre");

	String COLUMNA_CANTIDAD_DISPONIBLE_NOMBRE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.cantidadDisponible.nombre");
	
	String COLUMNA_CANTIDAD_DISPONIBLE_TOOLTIP = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.slickgrid.columna.cantidadDisponible.toolTip");
	
	String COLUMNA_CANTIDAD_ENTREGADA = "cantidadEntregada";
	
	String COLUMNA_CANTIDAD_ENTREGADA_NOMBRE = "Cant. Recibida";
	
	String COLUMNA_CANTIDAD_ENTREGADA_TOOLTIP = "Cantidad Recibida";
	
	String COLUMNA_CANTIDAD_PEDIDA_IMPORTACION = "cantidadPedidaImportacion";
	
	String COLUMNA_CANTIDAD_PEDIDA_IMPORTACION_NOMBRE = "Pedida(UNI)";
	
	String COLUMNA_CANTIDAD_PEDIDA_IMPORTACION_TOOLTIP = "Cantidad pedida al realizar la importaci\u00f3n";
	
	String COLUMNA_CANTIDAD_EN_CAJAS = "cantidadEnCajas";
	
	String COLUMNA_CANTIDAD_EN_CAJAS_NOMBRE = "Pendiente(CAJ)";
	
	String COLUMNA_CANTIDAD_EN_CAJAS_TOOLTIP = "Cantidad pendiente por recibir en cajas";
	
	String DATOS_INICIALES_GRID = "[]";

	/**
	 * Editor de codigo de barras, implementado en el archivo main.js en el
	 * proyecto prjWebSIC en la siguiente ubicacion:
	 * scr/main/webapp/resources/js/bodegas/recepcionJuguetes/
	 */
	String CODIGO_BARRAS_EDITOR = "codigoBarrasEditor";

	/**
	 * Editor para la columna codigo de articulo, implementado en el archivo main.js en el
	 * proyecto prjWebSIC en la siguiente ubicacion:
	 * scr/main/webapp/resources/js/bodegas/recepcionJuguetes/
	 */
	String TIPO_CODIGO_EDITOR = "tipoCodigoEditor";

	/**
	 * Editor para la columna Pzas, implementado en el archivo main.js en el
	 * proyecto prjWebSIC en la siguiente ubicacion:
	 * scr/main/webapp/resources/js/bodegas/recepcionJuguetes/
	 */
	String VALOR_UNIDAD_EMAQUE_EDITOR = "valorUnidadEmpaqueEditor";

	/**
	 * Editor para la columna Cantidad, implementado en el archivo main.js en el
	 * proyecto prjWebSIC en la siguiente ubicacion:
	 * scr/main/webapp/resources/js/bodegas/recepcionJuguetes/
	 */
	String VALOR_CANTIDAD_EDITOR = "valorCantidadEditor";
	
	/**
	 * Tipo de recepcion; agregado por un problema en el enumerador EnumTipoRecepcion
	 */
	String NORMAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.recepcion.normal");
	
	String COLUMNA_REFERENCIA_PROVEEDOR = "codigoReferenciaProveedor";
	
	String COLUMNA_REFERENCIA_PROVEEDOR_NOMBRE = "Ref. externa";
	
	String COLUMNA_REFERENCIA_PROVEEDOR_TOOLTIP = "Referencia externa del proveedor";
	
	String COLUMNA_MARCA_COMERCIAL = "marcaComercial";
	
	String COLUMNA_MARCA_COMERCIAL_NOMBRE = "M. Comercial";
	
	String COLUMNA_MARCA_COMERCIAL_TOOLTIP = "Marca comercial del art\u00EDculo";
	
	/**
	 * Constante que contiene un SQL para encontrar el ultimo estado de la orden de compra registrado en el historico
	 */
	String SUB_SELECT_HISTORICO = "SELECT CODIGOESTADOCATVAL FROM SCORCTORDCOMHISEST WHERE CODIGOORDENCOMPRA = OC.CODIGOORDENCOMPRA AND FECHAREGISTRO IN (SELECT MAX(FECHAREGISTRO) FROM SCORCTORDCOMHISEST WHERE CODIGOORDENCOMPRA = OC.CODIGOORDENCOMPRA)";
	
	String COLUMNA_PCO_COD = "preCod";
	
	String COLUMNA_PCO_COD_NOMBRE = "Est. Art.";
	
	String COLUMNA_PCO_COD_TOOLTIP = "Estado del art\u00EDculo";
	
	String BLANK = "";
	
	String COLUMNA_MONEDA = "costoMonedaOrigen"; 
	
	String COLUMNA_MONEDA_NOMBRE = "Cto. moneda"; 
	
	String COLUMNA_MONEDA_TOOLTIP ="Costo de la moneda de origen";
	
	String COLUMNA_GRUPO_TRABAJO = "nombreGrupoTrabajo";
	
	String COLUMNA_GRUPO_TRABAJO_NOMBRE ="Prototipo";
	
	String COLUMNA_GRUPO_TOOLTIP = "Nombre del grupo de trabajo";
	
	Integer TIPO_RELACION_DETALLES_ORDEN_COMPRA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.relacion.detalles.orden.compra");
	
	String CAMBIO_CODIGOS_BARRAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.juguetes.cambio.codigo.barras");
	
	String COLUMNA_NUMERO_ORDEN = "numeroOrdenCompra";
	
	String COLUMNA_NUMERO_ORDEN_NOMBRE = "Num. Ord. Com";
	
	String COLUMNA_NUMERO_ORDEN_TOOLTIP = "Numero de la orden de compra";
	
	String NEW_ROW_EDITOR = "newRowEditor";
	
	String FUNCIONALIDAD_RECEPCION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.juguetes.funcionalidad.recepcion");
	
	String COLUMNA_IND_PROPIETARIO = "codigoIndicadorPropietario";
	
	String COLUMNA_IND_PROPIETARIO_NOMBRE = "Ind. Propietario";
	
	String COLUMNA_IND_PROPIETARIO_TOOLTIP = "Indicador propietario";
	
	String FIELD_CLASIFICACION = "codigoClasificacion";
	
	String FIELD_ID_ARTICULO = "id.codigoArticulo";

}
