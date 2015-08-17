package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.auditoria.commons.resources.AuditoriaMessages;
import ec.com.smx.corporativo.commons.resources.CorporativoMessages;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;
import ec.com.smx.sic.cliente.resources.cambioprecios.SICCambioPreciosMessages;
import ec.com.smx.sic.cliente.resources.controlRutas.SICControlRutasMessages;
import ec.com.smx.sic.cliente.resources.fruver.SICFruverMessages;
import ec.com.smx.sic.cliente.resources.ofertas.SICOfertasMessages;
import ec.com.smx.sic.cliente.resources.oficinaexterior.SICOficinaExteriorMessages;
import ec.com.smx.sic.cliente.resources.ordenCompra.SICOrdenCompraMessages;
import ec.com.smx.sic.cliente.resources.pedidoAsistido.SICPedidoAsistidoMessages;
import ec.com.smx.sic.cliente.resources.procesamientoventas.SICProcesamientoVentasMessages;
import ec.com.smx.sic.cliente.resources.produccionEmpacado.SICProduccionMessajes;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;
import ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponMessages;
import ec.com.smx.sic.cliente.resources.recibidoNoContabilizado.SICRecibidoNoContabilizadoMessages;
import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;

public interface SICFactoryConstantes {
	String BEANREF_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.beanref");
	String APPLICATION_FACTORY_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.applicationfactory");
	String[] CONTEXTO = {APPLICATION_FACTORY_CONTEXTPATH};
	String APPLICATION_CONTEXT_BEAN = "sicV2ApplicationContext";
	String DATASOURCE_CONTEXTPATH =  SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.datasource");
	String SESSIONFACTORY_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.sessionfactory");

	//Servicio y Beans de administracion
	String ADMIN_SERVICE_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.service");
	String ADMIN_SPRING_BATCH_BEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.batch.bean");
	String ADMIN_APLICACIONCACHEBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.bean.aplicacioncache");
	String ADMIN_CALCULOSECUENCIABEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.bean.calculosecuencia");
	String ADMIN_PARAMETROBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.bean.parametro");
	String ADMIN_MIGRACIONBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.bean.migracion");
	String ADMIN_TRANSACCIONES_BEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.bean.transacciones");
	String ADMIN_CODIGO_BEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.bean.codigo");
	String LOG_PROCESOS_MIGRACION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.bean.log.procesosmigracion");

	//Servicio y Beans de Articulo
	String ARTICULO_SERVICE_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.service");
	String ARTICULO_CALCULOSERVICE_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.calculo.service"); //servicio separado
	String ARTICULO_ADMINBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.admin");
	String ARTICULO_ARCHIVOBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.archivo");
	String ARTICULO_REGSANBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.regsan");
	String ARTICULO_ROTULADOBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.rotulado");
	String ARTICULO_CATALOGOBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.catalogo");
	String ARTICULO_ESTCOMBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.estructuracomercial");
	String ARTICULO_ALCANCE_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.alcance");
	String ARTICULO_ALCANCE_NOSQL_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.alcance.nosql");
	String ARTICULO_LINCOMBEAN_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.lineacomercial");
	String ARTICULO_PROVEEDOR_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.proveedor");
	String ARTICULO_PROVACC_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.proveedor.accion");
	String ARTICULO_ARCHIVO_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.archivo");	
	String ARTICULO_ACCION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.accion");
	String ARTICULO_CALSEC_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.admin.bean.calculosecuencia");
	String ARTICULO_PROMOCION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.promocion");
	String ARTICULO_RELACIONADO_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.articulorelacionado");
	String ARTICULO_ALCANCES_BATCH_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.alcances.batch");
	String ARTICULO_ALCANCES_ARCHIVO_BATCH_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.alcances.archivo.batch");
	String ARTICULO_ALCANCES_ARCHIVO_ARTICULO_BATCH_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.alcances.archivo.articulo.batch");
	String ARTICULO_ALCANCE_NOSQL_BATCH_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.alcance.nosql.batch");
	String ARTICULO_AGRUPADOR_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.agrupador");
	String ARTICULO_TAREAPROGRAMADA_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.tareaprogramada");
	String ARTICULO_UNIDADMANEJO_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.unidadmanejo");
	String ARTICULO_PROVEEDOR_IMPORTACION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.articuloProveedorImportacion");
	String ARTICULO_NOVEDAD_CUPON_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.novedad.cupon");
	String ARTICULO_BEAN_AUDITORIA_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.auditoria");
	String ARTICULO_BEAN_SOLICITUDIMPRESION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.solicitudImpresion");
	String ARTICULO_BEAN_PROCESO_LOGISTICO_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.proceso.logistico");
	String ARTICULO_BEAN_VALIDACION_DATOS_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.validacion");
	//beans usuario articulo
	String ARTICULO_BEAN_USUARIO_AUTORIZACION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.usuario.articulo");
	String ARTICULO_BEAN_CLASIFICACION_DAO_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.clasificacion.dao");
	String ARTICULO_BEAN_FUNCIONARIOAREATRABAJO_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.funcionarioareatrabajo");	
		
	/*IMPLEMENTACION MERCANCIAS EHARO*/
	String ARTICULO_BEAN_MERCANCIAS_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.mercancias");
	/*ARTICULO PROCESOS MASIVOS EHARO*/
	String ARTICULO_BEAN_MASIVO_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.masivo");
	
	//FIXME:eliminar la siguiente linea e descomentar esta linea para la funcionalidad de articulos terminados
	String ARTICULO_PRODUCCION_CONTEXTPATH = "";
	//String ARTICULO_PRODUCCION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.articulo.bean.produccion");
	
	//Servicio y Beans de Proveedores
	String PROVEEDOR_BEAN_SERVICIO_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.servicio");
	String PROVEEDOR_BEAN_ADMINISTRACION_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.administracion");
	String PROVEEDOR_BEAN_OFICINA_EXTERIOR_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.oficinaExterior");
	String PROVEEDOR_BEAN_CALCULO_DATOS_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.calculoDatos");
	String PROVEEDOR_BEAN_VALIDACION_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.validacion");
	String PROVEEDOR_BEAN_AUDITORIA_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.auditoria");
	String PROVEEDOR_BEAN_TIPO_PROVEEDOR_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.tipoProveedor");
	String PROVEEDOR_BEAN_DATOS_CONTACTOS_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.calculoDatosContactos");
	String PROVEEDOR_BEAN_BUSQUEDA_PROVEEDOR_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.busquedaProveedor");

	// Servicio y Beans de proveedores de servicios
	String PROVEEDOR_SERVICIOS_BEAN_SERVICIO_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedorServicios.beans.servicio");
	String PROVEEDOR_SERVICIOS_BEAN_ADMINISTRACION_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedorServicios.beans.administracion");
	String PROVEEDOR_SERVICIOS_BEAN_DAO_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedorServicios.beans.daos");

	//Servicio y Beans de areas de trabajo de proveedores
	String PROVEEDOR_AREA_TRABAJO_SERVICIO_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.areaTrabajo.servicio");
	String PROVEEDOR_AREA_TRABAJO_BEAN_CALCULO_DATOS_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.areaTrabajo.bean.calculoDatos");
	String PROVEEDOR_AREA_TRABAJO_BEAN_ALMACENAMIENTO_DATOS_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.areaTrabajo.bean.almacenamientoDatos");
		
	//Servicio y Beans de Proveedores - Usuarios Proveedor
	String FUNCIONARIO_BEAN_ALMACENAMIENTO_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.almacenamiento.usuariosProveedor");
	String PROVEEDOR_BEAN_DATOS_USUARIOS_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.calculo.usuariosProveedor");
	String FUNCIONARIO_BEAN_VALIDACION_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.validacion.usuariosProveedor");

	//Servicio y Beans de Oficinas en el exterior
	String OFICINA_EXTERIOR_SERVICIO_CONTEXTPATH = SICOficinaExteriorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.oficinaexterior.servicio");
	String OFICINA_EXTERIOR_BEAN_VALIDACION_CONTEXTPATH = SICOficinaExteriorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.oficinaexterior.bean.validacion");
	String OFICINA_EXTERIOR_BEAN_CALCULO_DATOS_CONTEXTPATH = SICOficinaExteriorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.oficinaexterior.bean.calculoDatos");
	String OFICINA_EXTERIOR_BEAN_ALMACENAMIENTO_CONTEXTPATH = SICOficinaExteriorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.oficinaexterior.bean.almacenamiento");

	//Servicio y Beans de marcas de proveedores
	String MARCA_PROVEEDOR_SERVICIO_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.marcaProveedor.servicio");
	String MARCA_PROVEEDOR_BEAN_CALCULO_DATOS_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.marcaProveedor.bean.calculoDatos");
	String MARCA_PROVEEDOR_BEAN_ALMACENAMIENTO_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.marcaProveedor.bean.almacenamiento");

	//Beans de proveedor funcionario relacionado
	String PROVEEDOR_FUNCIONARIO_RELACIONADO_BEAN_DAO_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedorFuncionarioRelacionado.dao");

	// Beans de proveedor clasificacion
	String PROVEEDOR_CLASIFICACION_BEAN_CALCULO_CONTEXPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contexpath.spring.proveedorClasificacion.calculo");
	String PROVEEDOR_CLASIFICACION_BEAN_ALMACENAMIENTO_CONTEXPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contexpath.spring.proveedorClasificacion.almacenamiento");
	String PROVEEDOR_CLASIFICACION_BEAN_VALIDACION_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contexpath.spring.proveedorClasificacion.validacion");
	
	String PROVEEDOR_ASPECTOS_BEAN_CONTEXTPATH = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.proveedor.bean.aspectos");
	
	//Beans de Sincronizacion
	String SINCRONIZACION_ARTICULO_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.sincronizacion.bean.articulo");

	//Servicio y beans de Orden de Compra
	String ORDEN_COMPRA_BEAN_SERVICIO_CONTEXTPATH = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ordenCompra.servicio");
	String ORDEN_COMPRA_BEAN_MIGRACION_CONTEXTPATH = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ordenCompra.migracion");
	String ORDEN_COMPRA_BEAN_ADMIN_CONTEXTPATH = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ordenCompra.admin");
	String ORDEN_COMPRA_BEAN_BATCH_CONTEXTPATH = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ordenCompra.batch");
	
	//Servicio y beans de Pedido asistido
	String PEDIDO_ASISTIDO_BEAN_SERVICIO_CONTEXTPATH = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.pedidoAsistido.servicio");
	String PEDIDO_ASISTIDO_BEAN_CREACION_CONTEXTPATH = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.pedidoAsistido.creacion");
	String PEDIDO_ASISTIDO_BEAN_CONFIGURACION_CONTEXTPATH = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.pedidoAsistido.configuracion");
	String PEDIDO_ASISTIDO_BEAN_MIGRACION_CONTEXTPATH = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.pedidoAsistido.migracion");
	String PEDIDO_ASISTIDO_BEAN_MONITOREO_CONTEXTPATH = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.pedidoAsistido.monitoreo");
	String PEDIDO_ASISTIDO_BEAN_FIJO_CONTEXTPATH = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.pedidoAsistido.fijo");
	String PEDIDO_ASISTIDO_BEAN_AUDITORIAS_CONTEXTPATH = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.pedidoAsistido.auditorias");
	String PEDIDO_ASISTIDO_BEAN_ORDENPORPEDIDO_CONTEXTPATH = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.pedidoAsistido.interface");

	
	//Servicio y beans de Control de Rutas
	String CONTROL_RUTA_BEAN_SERVICIO_CONTEXTPATH = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.controlRutas.servicio");
	String CONTROL_RUTA_BEAN_ADMIN_CONTEXTPATH = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.controlRutas.admin");
		
	//Servicio y beans de Cambio de precios
	String CAMBIO_PRECIOS_BEAN_SERVICIO_CONTEXTPATH = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.cambioprecios.servicio");
	String CAMBIO_PRECIOS_BEAN_SPRING_DAOS_CONTEXTPATH = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.cambioprecios.beans.daos");
	String CAMBIO_PRECIOS_BEAN_ADMINISTRACION_CONTEXTPATH = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.cambioprecios.beans.administracion");
	String CAMBIO_PRECIOS_BEAN_ARCHIVO_PLANO_CONTEXTPATH = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.cambioprecios.beans.archivoplano");
	String CAMBIO_PRECIOS_BEAN_ASISTIDO_CONTEXTPATH = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.cambioprecios.beans.asistido");
	String CAMBIO_PRECIOS_BEAN_BUSQUEDA_CONTEXTPATH = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.cambioprecios.beans.busqueda");
	String CAMBIO_PRECIOS_BEAN_PLANTILLA_CONTEXTPATH = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.cambioprecios.beans.plantilla");
	String CAMBIO_PRECIOS_BEAN_ARTICULO_CONTEXTPATH = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.cambioprecios.beans.articulo");

	//Servicio y beans de Procesamiento de ventas
	String PROCESAMIENTOVENTAS_BEAN_SERVICIO_CONTEXPATH               = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.servicio");
	String PROCESAMIENTOVENTAS_BEAN_ADMINISTRACION_CONTEXPATH         = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.administracion");
	String PROCESAMIENTOVENTAS_BEAN_ADMINISTRACION_BATCH_CONTEXPATH   = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.administracion.batch");
	String PROCESAMIENTOVENTAS_BEAN_DESCUENTOS_BATCH_CONTEXPATH       = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.descuentos.batch");
	String PROCESAMIENTOVENTAS_BEAN_DESCUENTOS_CONTEXPATH             = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.descuentos");
	String PROCESAMIENTOVENTAS_BEAN_RECUPERACIONES_BATCH_CONTEXPATH       = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.recuperaciones.batch");
	String PROCESAMIENTOVENTAS_BEAN_RECUPERACIONES_CONTEXPATH             = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.recuperaciones");
	String PROCESAMIENTOVENTAS_BEAN_DAOS_CONTEXPATH                   =SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.daos");
	String PROCESAMIENTOVENTAS_BEAN_VENTAS_BATCH_CONTEXPATH           =SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.ventas.batch");
	String PROCESAMIENTOVENTAS_BEAN_VENTAS_CONTEXPATH                 =SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.procesamientoventas.ventas");

	// Servicio y beans de Ofertas
	String OFERTAS_BEAN_SERVICIO_CONTEXTPATH = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ofertas.servicio");
	String OFERTAS_BEAN_SPRING_DAOS_CONTEXTPATH = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ofertas.beans.daos");
	String OFERTAS_BEAN_ADMINISTRACION_CONTEXTPATH = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ofertas.beans.administracion");
	String OFERTAS_BEAN_BUSQUEDA_CONTEXTPATH = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ofertas.beans.busqueda");
	String OFERTAS_BEAN_ARTICULO_CONTEXTPATH = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.ofertas.beans.articulo");
	
	//Servicio y beans de Recipientes
	String RECIPIENTES_BEAN_SERVICIO_CONTEXTPATH = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recipientes.servicio");
	String RECIPIENTES_BEAN_MIGRACION_CONTEXTPATH = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recipientes.migracion");
	String RECIPIENTES_BEAN_ADMIN_CONTEXTPATH = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recipientes.admin");
	String RECIPIENTES_BEAN_BATCH_CONTEXTPATH = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recipientes.batch");
	String RECIPIENTES_BEAN_BUSQUEDA_CONTEXTPATH = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recipientes.busqueda");
	String RECIPIENTES_BEAN_VALIDACION_CONTEXTPATH = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recipientes.validacion");	
	String RECIPIENTES_BEAN_IMPRESION_CONTEXTPATH = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recipientes.impresion");
	
	//Beans de bodega
	String BODEGA_BEAN_SERVICIO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.bean.servicio");
	String BODEGA_BEAN_CALCULO_DATOS_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.bean.calculoDatos");
	String BODEGA_BEAN_VALIDACION_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.bean.validacion");
	String BODEGA_BEAN_DAO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.bean.dao");
	String BODEGA_BEAN_ALMACENAMIENTO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.bean.almacenamiento");
	String BODEGA_BEAN_SECCION_DAO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.bean.seccion.dao");
	String ESTRUCTURA_LOGISTICA_BEAN_SERVICIO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.estructura.logistica.bean.servicio");
	String ESTRUCTURA_LOGISTICA_BEAN_ALMACENAMIENTO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.estructura.logistica.bean.almacenamiento");
	String ESTRUCTURA_LOGISTICA_BEAN_DAO_CONTEXTPATH=SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.estructura.logistica.bean.dao");
	String ESTRUCTURA_LOGISTICA_BEAN_ARCHIVO_BATCH_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.estructura.logistica.bean.archivo.batch");

	String RECEPCION_BODEGA_BEAN_DAO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.dao");
	String RECEPCION_BODEGA_BEAN_SERVICIO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.servicio");
	String RECEPCION_BODEGA_BEAN_CALCULO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.calculo");
	String RECEPCION_BODEGA_BEAN_VALIDACION_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.validacion");
	String RECEPCION_BODEGA_BEAN_ALMACENAMIENTO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.almacenamiento");
	String RECEPCION_BODEGA_BEAN_OPERADOR_LOGISTICO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.operador.logistico");
	String RECEPCION_BODEGA_BEAN_CALCULO_ASIGNACION_TAREAS_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.calculo.asignacion.tareas");
	String RECEPCION_BODEGA_BEAN_BATCH_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.perecibles.batch");
	
	String BODEGA_RECEPCION_BEAN_LISTA_PROVEEDORES = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.recepcion.bean.listaProveedores");
	
	String TAREAS_BODEGA_BEAN_CALCULO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.tareas.bean.calculo");
	String TAREAS_BODEGA_BEAN_ALMACENAMIENTO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.tareas.bean.almacenamiento");
	String TAREAS_BODEGA_BEAN_VALIDACION_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.tareas.bean.validacion");
	String TAREAS_BODEGA_BEAN_SERVICIO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.tareas.bean.servicio");
	
	//Beans aspectos de bodega
	String BODEGA_ASPECTOS_BEAN_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.bean.aspectos");
	
	//Autorizaciones por clave
	String BODEGA_AUTORIZACIONES_BEAN_GESTOR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.autorizaciones.bean.gestor");
	String BODEGA_AUTORIZACIONES_BEAN_SERVICIO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.autorizaciones.bean.servicio");
	
	//Despachos
	String DESPACHO_BODEGA_BEAN_SERVICIO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.despacho.bean.servicio");
	String DESPACHO_BODEGA_BEAN_CALCULO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.despacho.bean.calculo");
	String DESPACHO_BODEGA_BEAN_CONFIGURACION_SECCIONES_TRABAJO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.despacho.bean.configuracion.secciones.trabajo");
	String DESPACHO_BODEGA_BEAN_ALMACENAMIENTO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.despacho.bean.almacenamiento");
	String DESPACHO_BODEGA_BEAN_PARAMETROS_DESPACHO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.despacho.bean.parametros.despacho");
	String DESPACHO_BODEGA_BEAN_DAO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.despacho.bean.dao");
	
	//Integracion
	String BODEGA_BEAN_ACCION_DAO_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.bean.accion.dao");
	String BODEGA_BEAN_ACCION_GESTOR_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.bean.accion.gestor");
			
	//Configuracion batch migracion ordenes compra B2B - SIC
	String BODEGA_MIGRACION_ORDENES_COMPRA_CONTEXTPATH = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.bodega.administracion.migracion.batch");

	//Beans Datos Corporativos
	String DATOS_CORPORATIVOS_BEAN_ADMINISTRACION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.datosCorporativos.service");

	//Beans Datos Corporativos
	String ENVIO_MAIL_BEAN_ADMINISTRACION_CONTEXTPATH = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.enviomail.service");
	
	//Beans de ASISTENTE DE COMPRAS
	String ASISTENTE_COMPRAS_BEAN_SERVICIO_CONTEXTPATH = RecargaCuponMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recarga.cupones.bean.servicio");
	String ASISTENTE_COMPRAS_BEAN_GESTOR_CONTEXTPATH = RecargaCuponMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recarga.cupones.bean.gestor");
	String ASISTENTE_COMPRAS_BEAN_GESTOR_BATCH_CONTEXTPATH = RecargaCuponMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recarga.cupones.bean.gestorBatch");
	String ASISTENTE_COMPRAS_BEAN_TASK_CONTEXTPATH = RecargaCuponMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.recarga.cupones.bean.push");
	
	//Identificador de servicios Asistente Compras
	String CLIENTE_CUPON_SERVICE = "sacClienteCuponServiceTrans";
	String ENVIOCUPON_SERVICE = "sacEnvioCuponServiceTrans";
	String CUPON_SERVICE = "sacCuponServiceTrans";
	String TAREAPROGRAMADA_RECARGA_CUPON_SERVICE = "sacTareaProgramadaServiceTrans";
	String REGISTROCORPORATIVO_SERVICE = "sacRegistroCorporativoServiceTrans";
	String LISTA_SERVICE = "sacListaServiceTrans";
	String PUSH_TASK = "sacPushUtil";
	String CONVENIO_CUPON_SERVICE = "sacConvenioCuponServiceTrans";
	String CONTENIDO_SERVICE = "sacContenidoServiceTrans";

	//Identificador de Servicios transaccionales de Control de rutas
	String ADMIN_FURGON_SERVICIO =  "sicAdminFurgonServicio";
	String ADMIN_TRANSPORTE_SERVICIO = "sicAdminTransporteServicio";
	String ADMIN_TRANSPORTISTA_SERVICIO = "sicAdminTransportistaServicio";
	String ADMIN_GUIAS_SERVICIO = "sicAdminGuiasServicio";
	String MONITORE_RUTA_SERVICIO = "sicMonitoreoRutaServicio";
	
	//Identificador de Servicios Transaccionales de Administracion
	String SERVICE_DATA = "dataService";
	String ADMIN_PARAMETROSERVICIO = "sicParametroServicio";
	String ADMIN_TAREAPROGRAMADASERVICIO = "sicTareaProgramadaServicio";
	String ADMIN_ENVIOMAIL = "sicEnvioMailServicio";

	//Identificador de Servicios transaccionales de Datos Corporativos
	String ADMIN_DATOSCORPORATIVOS_SERVICIO = "sicDatosCorporativosServicio";
	String ADMIN_PROCESO_SERVICIO = "sicProcesoServicio";

	//Identificador de Servicios Transaccionales de Articulos
	String ARTICULO_ADMINSERVICIO = "sicArticuloServicio";
	String ARTICULO_ARCHIVOSERVICIO = "sicArticuloArchivoServicio";
	String ARTICULO_ESTCOMSERVICIO = "sicEstructuraComercialServicio";
	String ARTICULO_CATALOGOSERVICIO = "sicCatalogoArticuloServicio";
	String ARTICULO_REGSANSERVICIO = "sicArticuloRegistroSanitarioServicio";
	String ARTICULO_ROTULADOSERVICIO = "sicArticuloRotuladoServicio";
	String ARTICULO_CALCULOSERVICIO = "sicArticuloCalculoServicio";
	String ARTICULO_VALIDACIONSERVICIO = "sicArticuloValidacionServicio";
	String ARTICULO_ALCANCESERVICIO = "sicArticuloAlcanceServicio";
	String ARTICULO_LINCOMSERVICIO = "sicLineaComercialServicio";
	String ARTICULO_PROMSERVICIO = "sicArticuloPromocionServicio";
	String ARTICULO_RELSERVICIO = "sicArticuloRelacionadoServicio";
	String ARTICULO_SOLICITUDIMPRESION = "sicArticuloSolicitudImpresionServicio";
	String ARTICULO_USUARIO_AUTORIZACION = "sicUsuarioAutorizacionServicio";
	/*IMPLEMENTACION MERCANCIAS*/
	String ARTICULO_MERCANCIASERVICIO = "sicArticuloMercanciaServicio";
	/*ARTICULO MASIVO SERVICIO*/
	String ARTICULO_MASIVO = "sicArticuloMasivoServicio";
	/*ARTICULO ETIQUETA*/
	String ARTICULO_ETIQUETA = "sicArticuloEtiquetaServicio";
	/*MARCA ARTICULO*/
	String MARCA_ARTICULO = "sicMarcaArticuloServicio";
	
	/*Servico articuloLocal noSql*/
	String ARTICULO_ALCANCE_NOSQL_SERVICIO = "sicArticuloAlcanceNoSqlServicio";

	String ARTICULO_PRODUCCIONSERVICIO = "sicArticuloProduccionServicio";
	
	//Identificador de Servicios Transaccionales de Proveedores
	String PROVEEDOR_ADMINISTRACION_SERVICIO = "sicAdministracionProveedorServicio";
	String PROVEEDOR_DATOS_SERVICIO = "sicDatosProveedorServicio";
	String PROVEEDOR_VALIDACION_SERVICIO = "sicValidacionProveedorServicio";
	String PROVEEDOR_AUDITORIA_SERVICIO = "sicAuditoriaProveedorServicio";
	String PROVEEDOR_DATOS_USUARIOS_SERVICIO = "sicCalculoDatosUsuariosProveedorServicio";
	String PROVEEDOR_CLASIFICACION_SERVICIO = "sicProveedorClasificacionServicio";

	//Identificador de Servicios Transaccionales de Oficinas en el Exterior
	String OFICINA_EXTERIOR_VALIDACION_SERVICIOS = "sicValidacionOficinaExteriorServicio";
	String OFICINA_EXTERIOR_DATOS_SERVICIOS = "sicDatosOficinaExteriorServicio";
	String OFICIAN_EXTERIOR_SERVICIO = "sicOficinaExteriorServicio";
	String PROVEEDOR_OFICIAN_EXTERIOR_SERVICIO = "sicProveedorOficinaExteriorServicio";

	//Identificador de Servicios Transaccionales de Marcas de Proveedores
	String MARCA_PROVEEDOR_SERVICIO = "sicMarcaProveedorServicio";

	//Identificador de Servicios Transaccionales de Orden de Compra
	String ORDEN_COMPRA_SERVICIO = "sicOrdenCompraServicio";
	String ORDEN_COMPRA_MIGRAR_SERVICIO = "sicMigracionOrdenCompraServicio";
	
	//Identificador de Servicios Transaccionales de Orden de Compra
	String PEDIDO_ASISTIDO_ACCION_SERVICIO = "sicAccionPedidoAsistidoServicio";
	String PEDIDO_ASISTIDO_ALMACENAMIENTO_SERVICIO = "sicAlmacenamientoPedidoAsistidoServicio";
	String PEDIDO_ASISTIDO_CALCULO_SERVICIO = "sicCalculoPedidoAsistidoServicio";
	String PEDIDO_ASISTIDO_VALIDACION_SERVICIO = "sicValidacionPedidoAsistidoServicio";
	String PEDIDO_ASISTIDO_MIGRACION_SERVICIO = "sicMigracionPedidoAsistidoServicio";
	
	//Identificador de Servicios Transaccionales de Cambio de precios
	String CAMBIO_PRECIOS_ADMINISTRACION_SERVICIO = "sicAdministracionCambioPreciosServicio";
	String CAMBIO_PRECIOS_ASISTIDO_SERVICIO = "sicAsistidoCambioPreciosServicio";
	String CAMBIO_PRECIOS_ARCHIVO_PLANO_SERVICIO = "sicArchivoPlanoCambioPreciosServicio";
	String CAMBIO_PRECIOS_PLANTILLA_SERVICIO = "sicPlantillaCambioPreciosServicio";
	String CAMBIO_PRECIOS_ARTICULO_SERVICIO = "sicArticuloCambioPreciosServicio";
	String MIGRACION_CAMBIO_PRECIOS_SERVICIO = "sicAccionMigracionCambioPreciosServicio";
	String HISTORIAL_CAMBIO_PRECIOS_SERVICIO = "sicAccionHistorialCambioPreciosServicio";
	
	//Identificador de Servicios Transaccionales de Procesamiento de ventas
	String PROCESAMIENTOVENTAS_VENTAS_SERVICIO = "sicProcesamientoVentasServicio";
	String PROCESAMIENTOVENTAS_DESCUENTOS_SERVICIO = "sicProcesamientoVentasDescuentosServicio";
	String PROCESAMIENTOVENTAS_RECUPERACIONES_SERVICIO = "sicProcesamientoVentasRecuperacionesServicio";
	String PROCESAMIENTOVENTAS_ARTICULOS_SERVICIO = "sicProcesamientoVentasArticulosServicio";
	
	//Identificador de Servicios Transaccionales de Ofertas
	String OFERTAS_ADMINISTRACION_SERVICIO = "sicAdministracionOfertasServicio";
	String OFERTAS_ARTICULO_SERVICIO = "sicArticuloOfertasServicio";
	
	//Identificador de Servicios de Bodega
	String BODEGA_ADMINISTRACION_SERVICIOS = "sicAdministracionBodegaServicio";
	String BODEGA_RECEPCION_SERVICIOS = "sicRecepcionBodegaServicio";
	String BODEGA_RECEPCION_ORDEN_COMPRA_SERVICIOS = "sicRecepcionOrdenCompraServicio";
	String BODEGA_FACTURA_DIGITAL_SERVICIO = "sicFacturaDigitalServicio";
	String BODEGA_ENTREGAS_PROVEEDOR_SERVICIO = "sicEntregasProveedorServicio";
	String BODEGA_FACTURAS_PROVEEDOR_SERVICIO = "sicFacturasProveedorServicio";
	String BODEGA_RECEPCION_PROVEEDOR_SERVICIO_SCANNER = "sicRecepcionProveedorServicioScanner";
	String BODEGA_RECEPCION_CALENDARIO_PLANIFICACION_SERVICIO = "sicRecepcionBodegaCalendarioPlanificacionServicio";
	String BODEGA_RECEPCION_PROVEEDORES_SERVICIO = "sicRecepcionProveedoresServicio";
	String BODEGA_RECEPCION_NOVEDADES_SERVICIO = "sicRecepcionNovedadesServicio";
	String BODEGA_ARTICULO_SERVICIO = "sicBodegaArticuloCalculoServicio";
	String BODEGA_RECEPCION_PROVEEDORES_SERVICIO_SCANNER = "sicRecepcionProveedorServicioScanner";
	String BODEGA_RECEPCION_ASIGNACION_AUTOMATICA_FUNCIONARIO_TAREA = "sicAsignacionAutomaticaFuncionarioTareaServicio";
	String BODEGA_RECEPCION_FACTURA_INTERNA_SERVICIO = "sicRecepcionFacturaInternaServicio";
	String BODEGA_DESPACHO_BODEGA_SERVICIOS = "sicDespachoBodegaServicio";
	String BODEGA_MONTACARGA_CORREDOR_SERVICIOS = "sicMontacargaCorredorServicio";
	String BODEGA_RECIBIDO_NO_CONTABILIZADO_SERVICIOS = "sicRecibidoNoContabilizadoServicio";
	String BODEGA_AUTORIZACIONES_CLAVE_SERVICIO = "sicAutorizacionesClaveServicio";
	String BODEGA_RECEPCION_PALLET_JACK_SERVICIO = "sicPalletJackRecepcionServicio";
	String BODEGA_RECEPCION_CONFIGURACIONES_SERVICIO = "sicConfiguracionesRecepcionServicio";
	String BODEGA_RECEPCION_PROGRAMAS_MONTACARGUISTA_SERVICIO = "sicProgramasMontacarguistaServicio";
	String BODEGA_RECEPCION_MODIFICAR_PALLETS_SERVICIO = "sicModificarPalletsRecepcionServicio";
	String BODEGA_RECEPCION_EDICION_DATOS_EXTRA_SERVICIO = "sicEdicionDatosExtraServicio";
	String BODEGA_TAREAS_SERVICIO = "sicTareasBodegaServicio";
	String BODEGA_INTEGRACION_BODEGA_SERVICIO = "sicIntegracionBodegaRecepcionServicio";
	String BODEGA_ASIGNACION_USUARIOS_SERVICIO = "sicAsignacionUsuariosBodegaServicio";
	String BODEGA_RECEPCION_FUNCIONARIO_SERVICIO = "sicRecepcionFuncionarioServicio";
	
	//Identificador de Servicios de Estructura Logistica
	String BODEGA_ESTRUCTURA_LOGISTICA_SERVICIOS = "sicEstructuraLogisticaServicio";
	
	//Identificador de Servicios Transaccionales de Recipientes
	String RECIPIENTES_SERVICIO = "sicRecipientesServicio";
	//Identificador de Servicios Transaccionales de Recipientes
	String CANJE_RECIPIENTES_SERVICIO = "sicCanjeRecipientesServicio";
	String ENTREGA_RECIPIENTES_SERVICIO = "sicEntregaRecipientesServicio";
	String IMPRESION_RECIPIENTES_SERVICIO = "sicImpresionRecipientesServicio";
	
	//Beans de Produccion y Empacado
	String PRODUCCION_BEAN_LINEAS_EMPAQUE_SERVICIO_CONTEXTPATH = SICProduccionMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.produccion.administracion.lineasEmpaque.bean.servicio");
	String PRODUCCION_BEAN_LINEAS_EMPAQUE_GESTOR_CONTEXTPATH = SICProduccionMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.produccion.administracion.lineasEmpaque.bean.gestor");
	String PRODUCCION_BEANS_LINEAS_EMPAQUE_DAO_CONTEXTPATH = SICProduccionMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.produccion.administracion.lineasEmpaque.bean.dao");

	//Identificador de Servicios de Produccion y Empacado
	String PRODUCCION_ADMINISTRACION_LINEAS_EMPAQUE_SERVICIOS = "sicAdministracionLineasEmpaqueServicio";

	String PRODUCCION_BEANS_ARTICULOS_LINEA_EMPAQUE = SICProduccionMessajes.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.produccion.administracion.lineasEmpaque.bean.dao");
	
	//Rutas de contexto
	String CONTEXT_RECIBIDO_NO_CONTABILIZADO_DAO_BEANS= SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.recibidoNoContabilizadoDAOBeans");
	String CONTEXT_RECIBIDO_NO_CONTABILIZADO_CALCULO_GESTOR_BEANS = SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoContabilizadoCalculoBeans");
	String CONTEXT_RECIBIDO_NO_CONTABILIZADO_ALMACENAMIENTO_GESTOR_BEANS =SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoContabilizadoAlmacenamientoBeans");
	String CONTEXT_RECIBIDO_NO_CONTABILIZADO_SERVICE_BEANS = SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoContabilizadoServicioBeans");
	String CONTEXT_RECIBIDO_NO_CONTABILIZADO_INTEGRACION_BEANS = SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoContabilizadoIntegracionBeans");
	String CONTEXT_RECIBIDO_NO_CONTABILIZADO_TAREASPROGRAMADAS_BEANS = SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoContabilizadoTareasProgramadasBeans");
	String CONTEXT_RECIBIDO_NO_CONTABILIZADO_TAREASPROGRAMADAS_SERVICIO_BEANS = SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoContabilizadoTareasProgramadasServicioBeans");
	String CONTEXT_RECIBIDO_NO_CONTABILIZADO_VALIDACION_GESTOR_BEANS = SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoContabilizadoValidacionBeans.xml");
	String CONTEXT_RECIBIDO_NO_COTEJADO_REPORTE_SERVICIO_BEANS = SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoCotejadoReporteServicioBeans.xml");
	String CONTEXT_RECIBIDO_NO_COOTEJADO_REPORTE_GESTOR_BEANS = SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.recibidonocontabilizado.spring.config.SICRecibidoNoCotejadoReporteBeans.xml");
	
	//Id's de los servicios (Beans)
	String RECIBIDO_NO_CONTABILIZADO_SERVICIOS = "sicRecibidoNoContabilizadoServicio";
	String RETENCIONES_SERVICIOS = "sicRetencionesServicio";
	String RECIBIDO_NO_CONTABILIZADO_TAREAS_PROGRAMADAS_SERVICIO = "sicRecibidoNoContabilizadoTareasProgramadasServicio";
	String RECIBIDO_NO_COTEJADO_REPORTE_SERVICIOS = "sicReporteRecibidoNoCotejadoServicio";
	
	// Bean para auditoria
	String CONTEXT_FACTURACION_AUDITORIA_PRING_BEANS= AuditoriaMessages.getString("ec.com.smx.auditoria.commons.contextpath.spring");
	String CONTEXT_FACTURACION_CORPORATIVO_BEANS = CorporativoMessages.getString("ec.com.smx.corporativo.commons.contextpath");

	//Identificador de Servicios Transaccionales de Orden de Compra
	String LOG_PROCESOS_MIGRACION_SERVICIO = "sicLogProcesosMigracionServicio";
	
	//Servicio y beans de Fruver
	String FRUVER_BEAN_SERVICIO_CONTEXTPATH = SICFruverMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.fruver.servicio");
	String FRUVER_BEAN_ADMIN_CONTEXTPATH = SICFruverMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.spring.fruver.admin");
	
	//Identificador de Servicios Transaccionales de Orden de Compra
	String FRUVER_SERVICIO = "sicFruverServicio";

	// Servicio proveedor de servicios
	String PROVEEDOR_AREA_TRABAJO_SERVICIO = "sicProveedorAreaTrabajoServicio";
}
