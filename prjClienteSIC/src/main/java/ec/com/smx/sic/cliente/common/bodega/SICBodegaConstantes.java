package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;
	
public final class SICBodegaConstantes {

	public static final Integer CODIGO_CATALOGO_TIPO_ESTADOS_PROCESO_LOGISTICO = Integer.parseInt(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.tipo.estado.proceso.logistico"));

	public static final String CODIGO_PERFIL_ESTRUCTURA_LOGISTICA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.perfil.estructura.logistica");

	public static final String CODIGO_PERFIL_LOGISTICO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.codigo.perfil.logistico");
	
	public static final Integer CODIGOTIPOUSOUNIMAN = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoUsoUnidadManejo");

	public static final Integer CODIGOCATALOGO_TIPO_NATURALEZA_AREA_TRABAJO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoNaturalezaAreaTrabajo");

	public static final String CODIGO_PARAMETRO_AGRUPADOR_IMPUESTOS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.factura.interna.parametro.agrupador.impuestos");

	/**
	 * Codigos para establecimientos area de trabajo
	 * 
	 * */
	public static final Integer CODIGO_ESTABLECIMIENTO_MACROBODEGA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.establecimiento.macrobodega");
	public static final Integer CODIGO_ESTABLECIMIENTO_CENTRO_DISTRIBUCION = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.establecimiento.centro.distribucion");
	public static final Integer CODIGO_ESTABLECIMIENTO_BODEGA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.establecimiento.bodega");
	public static final Integer CODIGO_ESTABLECIMIENTO_SUBBODEGA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.establecimiento.subbodega");

	/**
	 * Codigos para establecimientos ciudad area de trabajo
	 * 
	 * */
	public static final String CODIGO_ESTABLECIMIENTO_CIUDAD = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.establecimiento.ciudad");

	/**
	 * Codigos para ubicaciones del area de trabajo
	 */
	// constantes estructura logistica
	public static final Integer CODIGO_TIPO_SECCION = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.ubicacion.codigo.tipo.seccion");
	public static final String CODIGO_VALOR_TIPO_SECCION_UBICACION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.ubicacion");
	public static final String CODIGO_VALOR_TIPO_SECCION_PASILLO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.pasillo");
	public static final String CODIGO_VALOR_TIPO_SECCION_RACK = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.rack");
	public static final String CODIGO_VALOR_TIPO_SECCION_SUBNAVE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.subnave");
	public static final String CODIGO_VALOR_TIPO_SECCION_NAVE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.nave");
	public static final String CODIGO_VALOR_TIPO_SECCION_ANDEN = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.anden");
	public static final String CODIGO_VALOR_TIPO_SECCION_AREA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.area");
	public static final String CODIGO_VALOR_TIPO_SECCION_BALANZA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.balanza");

	public static final Integer CODIGO_TIPO_AREA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.ubicacion.codigo.tipo.area");
	public static final String CODIGO_VALOR_TIPO_AREA_DESPACHO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.area.despacho");
	public static final String CODIGO_VALOR_TIPO_AREA_RECEPCION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.codigo.tipo.area.recepcion");
	public static final String CODIGO_VALOR_TIPO_AREA_TRANSITO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.codigo.tipo.area.transito");
	public static final String CODIGO_VALOR_TIPO_AREA_BASCULA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.codigo.tipo.area.bascula");

	public static final Integer CODIGO_TIPO_UBICACION = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.ubicacion.codigo.tipo.ubicacion");
	public static final String CODIGO_VALOR_TIPO_UBICACION_VIRTUAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.ubicacion.virtual");
	public static final String CODIGO_VALOR_TIPO_UBICACION_FISICA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.ubicacion.fisica");

	// tipo de almacenamiento de la ubicacion
	public static final Integer CODIGO_TIPO_ALMACENAMIENTO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.almacenamiento");
	public static final String CODIGO_VALOR_TIPO_ALMACENAMIENTO_SURTIDO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.valor.tipo.almacenamiento.surtido");
	public static final String CODIGO_VALOR_TIPO_ALMACENAMIENTO_RESERVA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.valor.tipo.almacenamiento.reserva");

	public static final String CODIGO_UBICACION_NOSURTIDO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.nosurtido");
	public static final String CODIGO_UBICACION_NOUBICACION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.noubicacion");
	public static final Integer CODIGO_TIPO_UNIDAD_EMPAQUE = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.unidad.tipo.empaque");
	public static final String VALOR_PORCENTAJE_MINIMO_UBICACION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.porcentaje.minimo.valido");

	// tipo lado del rack
	public static final Integer CODIGO_TIPO_LADO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.rack.codigo.tipo.lado");
	public static final String CODIGO_VALOR_TIPO_LADO_PAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.rack.valor.tipo.lado.par");
	public static final String CODIGO_VALOR_TIPO_LADO_NON = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.rack.valor.tipo.lado.non");
	public static final String CODIGO_VALOR_TIPO_LADO_PARNON = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.rack.valor.tipo.lado.parnon");

	// tipo sentido del pasillo
	public static final Integer CODIGO_TIPO_SENTIDO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.pasillo.codigo.tipo.sentido");
	public static final String CODIGO_VALOR_TIPO_SENTIDO_ENTRADA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.pasillo.codigo.valor.tipo.sentido.entrada");
	public static final String CODIGO_VALOR_TIPO_SENTIDO_SALIDA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.pasillo.codigo.valor.tipo.sentido.salida");

	// Formato para generar la ubicacion
	public static final Integer FORMATO_UBICACION_PASILLO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.formato.ubicacion.pasillo");
	public static final Integer FORMATO_UBICACION_RACK = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.formato.ubicacion.rack");
	public static final Integer FORMATO_UBICACION_NIVEL = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.formato.ubicacion.nivel");
	// maximo de resultados en busqueda
	public static final Integer NUMERO_MAXIMO_RESULTADOS = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.logistica.bodega.maximo.resultados");
	// tipo de asignacion del anden
	public static final Integer CODIGO_TIPO_ASIGNACION = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.anden.codigo.tipo.asignacion");
	public static final String CODIGO_VALOR_TIPO_ASIGNACION_LOCAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.anden.codigo.valor.tipo.local");
	public static final String CODIGO_VALOR_TIPO_ASIGNACION_PROVEEDOR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.anden.codigo.valor.tipo.proveedor");
	// Mecanismo de balanza
	public static final Integer CODIGO_MECANISMO_BALANZA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.balanza.codigo.mecanismo");
	public static final String CODIGO_VALOR_MECANISMO_BALANZA_MANUAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.balanza.codigo.valor.tipo.manual");
	public static final String CODIGO_VALOR_MECANISMO_BALANZA_AUTOMATICO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.balanza.codigo.valor.tipo.automatico");
	//tipo de balanza
	public static final Integer CODIGO_TIPO_BALANZA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.balanza.codigo.tipo");
	public static final String CODIGO_VALOR_TIPO_BALANZA_RIEL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.balanza.codigo.valor.tipo.riel");
	public static final String CODIGO_VALOR_TIPO_BALANZA_FURGON = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.balanza.codigo.valor.tipo.furgon");
	public static final String CODIGO_VALOR_TIPO_BALANZA_PALLET = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.balanza.codigo.valor.tipo.pallet");
	//tipo estado
	public static final Integer CODIGO_ESTADO_ANDEN = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.anden.codigo.estado");
	public static final String ESTADO_ANDEN_LIBRE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.anden.valor.estado.libre");
	public static final String ESTADO_ANDEN_OCUPADO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.anden.valor.estado.ocupado");
	
	/**
	 * Codigo proceso factura digital
	 */

	public static final String CODIGO_PROCESO_FACTURA_DIGITAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.facturadigital.solicitud.andenes.clase.codigoclase");

	/**
	 * Tipos de facturas
	 */
	public static final String CODIGO_VALOR_FACTURA_INTERNA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.factura.interna");
	public static final String CODIGO_VALOR_FACTURA_FISICA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.factura.fisica");
	public static final String CODIGO_VALOR_FACTURA_DIGITAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.factura.digital");
	public static final String CODIGO_VALOR_NOTA_CREDITO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.nota.credito");
	public static final String CODIGO_VALOR_NOTA_DEBITO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.nota.debito");
	public static final String CODIGO_VALOR_FACTURA_ELECTRONICA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.factura.electronica");
	public static final String CODIGO_VALOR_NOTA_CREDITO_ELECTRONICA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.nota.credito.electronica");
	public static final String CODIGO_VALOR_NOTA_DEBITO_ELECTRONICA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.nota.debito.electronica");

	/**
	 *Tipo documento retencion
	 */
	public static final String CODIGO_VALOR_RETENCION_ELECTRONICA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.tipo.documento.retencion.electronica");
	
	/**
	 * Tipos de Ajustes
	
	public static final Integer CODIGO_CATALOGO_TIPO_AJUSTES = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.catalogo.tipoAjuste.codigo.catalogo.tipo");
	public static final String CODIGO_CATALOGO_VALOR_AJUSTE_MAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.tipoAjuste.codigo.catalogo.valorMas");
	public static final String CODIGO_CATALOGO_VALOR_AJUSTE_MENOS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.tipoAjuste.codigo.catalogo.valorMenos");
	 */
	/**
	 * Clases de Ajustes
	 */
	public static final Integer CODIGO_CATALOGO_CLASES_AJUSTES = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.catalogo.claseAjuste.codigo.catalogo.tipo");
	public static final String CODIGO_CATALOGO_VALOR_AJUSTE_MANUAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.claseAjuste.codigo.catalogo.valorManual");
	public static final String CODIGO_CATALOGO_VALOR_AJUSTE_AUTOMATICO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.claseAjuste.codigo.catalogo.valorAutomatico");
	
	/**
	 * Tipos de AjusteFacturaEstado
	 */
	public static final Integer CODIGO_CATALOGO_TIPO_AJUSTE_FACTURAESTADO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.catalogo.tipoAjusteFacturaEstado.codigo.catalogo.tipo");
	public static final String CODIGO_CATALOGO_VALOR_AJUSTE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.tipoAjusteFacturaEstado.codigo.catalogo.valor.ajuste");
	public static final String CODIGO_CATALOGO_VALOR_DEVOLUCION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.tipoAjusteFacturaEstado.codigo.catalogo.valor.devolucion");

	/**
	 * Estados de las notas de ingreso
	 */
	public static final Integer CODIGO_CATALOGO_TIPO_ESTADOS_NOTA_INGRESO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.codigo.catalogo.tipo");
	public static final String CODIGO_CATALOGO_VALOR_ESTADO_INICIO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estado.nota.ingreso.catalogo.valor.inicio");
	public static final String CODIGO_CATALOGO_VALOR_ESTADO_CUENTAS_POR_PAGAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estado.nota.ingreso.catalogo.valor.fin");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_RECHAZADAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasRechazadas");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_APROBADAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasRevisadas");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_CONTABILIZADAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasEnviadas");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_REVISADAS_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasRevisadasConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_REVISADAS_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasRevisadasSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_APROBADAS_FORZADAS_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasAprobadasForzadasConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_APROBADAS_FORZADAS_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasAprobadasForzadasSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_APROBADAS_FORZADAS_REVISADAS_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasAprobadasForzadasRevisadasConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_FACTURAS_APROBADAS_FORZADAS_REVISADAS_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.estados.nota.ingreso.catalogo.valor.facturasAprobadasForzadasRevisadasSinDiferencias");
	
	/**
	 * Acciones para cambiar de estado
	 */
	public static final Integer CODIGO_CATALOGO_TIPO_ACCIONES_NOTA_INGRESO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.catalogo.acciones.nota.ingreso.codigo.catalogo.tipo");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_INICIAR_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.iniciarConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_INICIAR_FACTURAS_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.iniciarSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CUADRAR_FACTURA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.cuadrar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_RECHAZAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.rechazar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_APROBAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.revisar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CONTABILIZAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.enviar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CONTABILIZAR_FORZADO_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.contabilizarForzadoConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CONTABILIZAR_FORZADO_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.contabilizarForzadoSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CONTABILIZAR_FORZADO_REVISADO_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.contabilizarForzadoRevisadoConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CONTABILIZAR_FORZADO_REVISADO_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.contabilizarForzadoRevisadoSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CUENTAS_POR_PAGAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.finalizar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_RENVIAR_CUENTAS_POR_PAGAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.renviar.finalizar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_ACTIVAR_RECHAZADA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.activar.rechazada");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_ACTIVAR_RECHAZADA_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.activar.rechazada.conDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_ACTIVAR_RECHAZADA_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.activar.rechazada.sinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REGRESAR_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.regresarConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REGRESAR_REVISADO_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.regresarRevisadoConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_APLICAR_AJUSTE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.aplicar.ajuste");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REVISAR_CON_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.revisar.conSinDiferencia");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_SINDIFERENCIAS_REVISAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.sinDiferenciasRevisar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CONDIFERENCIAS_REVISAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.conDiferenciasRevisar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REVISADO_SINDIFERENCIA_RECHAZAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.revisadoSinDiferencia.rechazar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REVISADO_CONDIFERENCIA_RECHAZAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.revisadoConDiferencia.rechazar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_SINDIFERENCIA_RECHAZAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.sinDiferencia.rechazar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_CONDIFERENCIA_RECHAZAR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.conDiferencia.rechazar");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_APROBAR_REVISADO_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.aprobar.revisado.sinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_INICIAR_REVISADO_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.iniciarRevisadoConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_INICIAR_REVISADO_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.iniciarRevisadoSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_APROBAR_FORZADO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.aprobarForzado");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_APROBAR_FORZADO_CON_DIFERENCIA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.aprobarForzadoConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_APROBAR_FORZADO_SIN_DIFERENCIA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.aprobarForzadoSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_APROBAR_FORZADO_REVISADO_CON_DIFERENCIA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.aprobarForzadoRevisadoConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_APROBAR_FORZADO_REVISADO_SIN_DIFERENCIA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.aprobarForzadoRevisadoSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_POR_HACER = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.porHacer");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REGRESAR_FORZADAS_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.facturasRegresarForzadasConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REGRESAR_FORZADAS_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.facturasRegresarForzadasSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REGRESAR_FORZADAS_REVISADAS_CON_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.facturasRegresarForzadasRevisadasConDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REGRESAR_FORZADAS_REVISADAS_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.facturasRegresarForzadasRevisadasSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REGRESAR_REVISADAS_SIN_DIFERENCIAS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.facturasRegresarRevisadasSinDiferencias");
	public static final String CODIGO_CATALOGO_VALOR_ACCION_REGRESAR_APROBADO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.accion.nota.ingreso.catalogo.valor.regresarAprobado");
	
	
	public static final String ENABLE_IMPRESION_FIN = "1";
	public static final String DISABLE_SHOW_ERROR = "0";

	/*
	 * Parametros para los ajustes automaticos.
	 */
	public static final String VALOR_OBSERVACION_AJUSTE_AUTOMATICO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recibido.no.facturado.ajuste.automatico.observacion.default");
	public static final String VALOR_AUTORIZADO_POR_AJUSTE_AUTOMATICO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recibido.no.facturado.ajuste.automatico.autorizado.por.default");

	public static final Integer CANTIDAD_DECIMALES_CALCULAR_PESO_RECEPCION = Integer.parseInt(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.cantidad.decimales.calcular.peso.recepcion"));

	/* Tipos de proceso de recepcion en el SIC */
	public static final String PROCESO_RECEPCION_ANTIGUA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.recpecion.sic.antigua");
	public static final String PROCESO_RECEPCION_FACTURA_DIGITAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.recpecion.sic.facturaDigital");

	/**
	 * TIPO AUTORIZACIONES POR CLAVE
	 */
	public static final String TIPO_NUMERO_INTENTOS_AUTORIZACION_CLAVE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.numero.intentos.autorizacion.clave");
	public static final String PROCESO_AUTORIZACION_AREA_TRABAJO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.proceso.autorizacion.area.trabajo");

	/**
	 * TIPO PALLETS RECEPCION
	 */
	public static final String TIPO_PALLET_ELECTRICO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.pallet.electrico.bodega");
	public static final String TIPO_PALLET_MANUAL = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.pallet.manual.bodega");

	/**
	 * CONFIGURACIONES DE RECEPCION
	 */
	public static final String TIPO_CONFIGURACION_PARAMETRO_PESO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.configuracion.recepcion.parametro.peso.bodega");
	public static final String TIPO_CONFIGURACION_TIEMPO_ESTIMADO_RECEPCION_PALLET = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.configuracion.tiempo.estimado.recepcion.pallet");
	public static final String TIPO_CONFIGURACION_TIEMPO_INICIO_RECEPCION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.configuracion.tiempo.inicio.recepcion");
	public static final String TIPO_CONFIGURACION_TIEMPO_INICIO_ASIGNACION = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.configuracion.tiempo.inicio.asignacion");

	/**
	 * ACCIONES DE ARTICULOS DE RECEPCION DE PERECIBLES
	 */

	public static final String ACCION_ARTIULOS_PERECIBLES_ENCERAR_PALLET = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.articulos.recepcion.perecibles.accion.encerarPallet");
	public static final String ACCION_ARTIULOS_PERECIBLES_CANCELAR_PALLET = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.articulos.recepcion.perecibles.accion.eliminarPallet");

	// Constantes de los tipos de documentos y la transaccion correspodiente; necesarios para generar los secuenciales de la factura interna.
	public static final int CODIGO_DOCUMENTO_FACTURA_INTERNA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.factura.interna.configuracion.secuencial.facturaInterna");
	public static final int CODIGO_DOCUMENTO_NOTA_INGRESO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.factura.interna.configuracion.notaIngreso");
	public static final int CODIGO_TRANSACCION_RECEPCION_ABASTOS = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.factura.interna.transaccion.recepcion.Abastos");

	// Constante para la impresion de reportes
	public static final String UBICACION_PLANTILLA_FACTURA_INTERNA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.factura.plantilla.impresion.xsl");
	public static final String UBICACION_PLANTILLA_REPORTE_TESORERIA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.plantilla.impresion.reporte.tesoreria.xsl");
	public static final String PARAMETRO_GRUPO_IMPRESION_BODEGA = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.parametro.grupo.impresion");

	
	/*Codigos migracion para recpion SIC-MAX*/
	public static final Integer CODIGO_MIGRACION_RECEPCION_FINALIZADA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.migracion.recepcion.finalizado");
	public static final Integer CODIGO_MIGRACION_RECEPCION_PENDIENTE = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.migracion.recepcion.pendiente");
	public static final Integer VALOR_TOTAL_RECEPCION_FINALIZADA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.migracion.recepcion.valorFinalizada");
	
	//Constates para corregir errores de pmd
	public static final String UNCHEKED = "unchecked";
	public static final String ESTADO = "estado";
	public static final String CODIGO_COMPANIA = "codigoCompania";
	public static final String FIELD_CODIGO_ORDEN_COMPRA_DETALLE_ESTADO = "id.codigoOrdenCompraDetalleEstado";
	public static final String ERROR_VALIDACION_FACTURA = "FACTURAS_VALIDADAS_IMCOMPLETAS";
	public static final String ERROR_DIFERENCIAS_NO_REGISTRADAS = "DIFERENCIAS_SIN_REGISTRAR";
	public static final String HORA_INICIO = "horaInicio";

	// Constantes para la auditoria
	public static final String IDENTIFICADOR_AUDITORIA_CPR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.auditoria.cambio.precio.recepcion");
	public static final Integer TIPOLOG_AUDITORIACPR = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.auditoria.registro.cambio.precio.recepcion.tipoLog");
	public static final String IDENTIFICADOR_AUDITORIA_AIM = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.auditoria.administrar.ingreso.manual");
	public static final String IDENTIFICADOR_AUDITORIA_AIC = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.auditoria.administrar.ingreso.caja");
	public static final String IDENTIFICADOR_AUDITORIA_MP = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.auditoria.administrar.modificar.pallet");
	public static final String IDENTIFICADOR_AUDITORIA_CP = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.auditoria.administrar.cancelar.pallet");
	public static final Integer TIPOLOG_AUDITORIAAIM = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.auditoria.registro.administrar.ingreso.manual.tipolog");
	public static final Integer TIPOLOG_AUDITORIAAIC = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.auditoria.registro.administrar.ingreso.caja.tipolog");
	public static final Integer TIPOLOG_AUDITORIAMP = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.auditoria.registro.modificar.pallet.tipolog");
	public static final Integer TIPOLOG_AUDITORIACP = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.auditoria.registro.cancelar.pallet.tipolog");
	public static final String IDENTIFICADOR_AUDITORIA_CVE = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.auditoria.configurar.validaciones.etiquetado.recepcion");
	public static final Integer TIPOLOG_AUDITORIACVE = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.auditoria.configurar.validaciones.etiquetado.recepcion.tipolog");
	
	/*Tipo catalogo factura en sitio*/
	public static final Integer CODIGO_TIPO_FACTURA_EN_SITIO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.facturaEnSitio");
	
	public static final String RECEPCION_PERFIL_RECLECTOR = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.perfil.recolector");
	
	public static final String ESTADO_PALLET_ANULADO = EnumEstadosPallets.ANULADO.getEstado();

	public static final String CODIGO_BARRAS_PALLET_INCOMPLETO = SICBodegaMessajes.getInstancia().getString("bodega.codigo.barras.palletIncompleto");
	
	/*Constantes para el tipo de justificaciones en la recepcion*/
	public static final String TIPO_JUSTIFICACION_REGISTRO_SANITARIO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.justificaciones.etiquetado.registro.sanitario");
	public static final String TIPO_JUSTIFICACION_TRANSGENICO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.justificaciones.etiquetado.transgenico");
	public static final String TIPO_JUSTIFICACION_SEMAFORO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.justificaciones.etiquetado.semaforo");

	/*Constantes para los procesos del popup de articulos*/
	public static final String PROCESO_MOSTRAR_ARTICULOS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.articulos.proceso.mostrar.articulos.recepcion");
	public static final String PROCESO_MOSTRAR_PALLETS_ARTICULOS = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.articulos.proceso.mostrar.pallets.articulos.recepcion");
	public static final String PROCESO_REGISTRAR_PESO_PALLET = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.articulos.proceso.registrar.peso.pallet.recepcion");
	public static final String PROCESO_CAMBIAR_COSTO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.articulos.proceso.cambiar.costo.recepcion");
	public static final String PROCESO_CONFIGURAR_VALIDACIONES_ETIQUETADO = SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.articulos.proceso.configurar.validaciones.etiquetado.recepcion");	
	
	/*Campos edicion datos extra*/
	public static final String CODIGO_CAMPO_PESO= "peso";
	public static final String CODIGO_CAMPO_ALTO= "alto";
	public static final String CODIGO_CAMPO_ANCHO= "ancho";
	public static final String CODIGO_CAMPO_PROFUNDIDAD= "profundidad";
	public static final String CODIGO_CAMPO_AREA_ALMACENAMIENTO = "areaAlmacenamiento";
	public static final String CODIGO_CAMPO_UBICACION_DESPACHO = "tipoUbicacion";
	public static final String CODIGO_CAMPO_TIPO_RECIPIENTE = "tipoRelacion";
	public static final String CODIGO_CAMPO_TIPO_CONSERVACION = "tipoConservacion";
	public static final String CODIGO_CAMPO_CANTIDAD_POR_PALLET= "cantidadPallet";
	public static final String CODIGO_CAMPO_CANTIDAD= "cantidad";
	public static final String CODIGO_CAMPO_ES_COMPARTIDO= "pc";
	public static final String CODIGO_CAMPO_RECIBIDO_POR_PALLET= "pa";
	public static final String CODIGO_CAMPO_TIENE_TARA= "tieneTara";
	
	/*Nombre de los identificadores en el mapa que cual contien valores extras para la factura interna*/
	public static final String VALOR_PROVEEDOR_TARIFA_IVA0 = "valorProveedorTarifaIva0";
	public static final String VALOR_PROVEEDOR_TARIFA_IVA = "valorProveedorTarifaIva";
	public static final String VALOR_PROVEEDOR_ICE = "valorProveedorICE";
	
	/*Asignacion usuarios bodega*/
	public static final Integer CODIGO_CATALOGO_TIPO_DISPONIBILIDAD_FUNCIONARIO = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.codigo.catalogo.tipo.disponibilidad.funcionario");
	public static final Integer CODIGO_CATALOGO_TIPO_ESTADO_FUNCIONARIO_TAREA = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.estado.funcionario.tipo.tarea");
	
	/**
	 * PARAMETROS DE INTEGRACION
	 */
	public static final int CANTIDAD_MAXIMA_ITEMS_A_INTEGRAR_DATOS_LOGISTICOS = SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.cantidad.maxima.items.a.integrar.datos.logisticos"); 
}
