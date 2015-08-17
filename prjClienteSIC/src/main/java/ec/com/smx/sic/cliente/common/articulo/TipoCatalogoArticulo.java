/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author fmunoz
 *
 */
public interface TipoCatalogoArticulo {

	public Integer TIPO_APLICACION_DESCUENTO = 211;
	public Integer TIPO_ASIGNACION_DESCUENTO = 1516;

    public Integer CARACTERISTICA_APLICAPRECIOVARIABLE = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.precioVariable");
    public Integer CARACTERISTICA_TIENEETIQUETAS = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneEtiquetas");
    public Integer CARACTERISTICA_TIENEUSOS = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneUsos");
    public Integer CARACTERISTICA_REFRIGERADOCONGELADO = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.refrigeradoCongelado");
    public Integer CARACTERISTICA_TIENEGARANTIA = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneGarantia");
    public Integer CARACTERISTICA_NOPERMITIDOENRECETA = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.noPermitidoEnReceta");
    public Integer CARACTERISTICA_TIENETALLAS = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneTallas");
    public Integer CARACTERISTICA_TIENECOLORES = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneColores");
    public Integer CARACTERISTICA_TIENESABORES = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneSabores");
    public Integer CARACTERISTICA_TIENEAROMAS = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneAromas");
    public Integer CARACTERISTICA_TIENECARACTERISTICAS = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneCaracteristicas");
    public Integer CARACTERISTICA_TIENEPRESENTACIONES = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tienePresentaciones");
    public Integer CARACTERISTICA_TIENEDIMENSIONES = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneDimensiones");
    public Integer CARACTERISTICA_NOTIENECONTROLROTULADO = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.noTieneControlRotulado");
    public Integer CARACTERISTICA_TIENEINDICADORPROPIETARIO = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.tieneIndicadorPropietario");
    public Integer CARACTERISTICA_VALIDACION_REGISTROSANITARIO = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.validacionRegistroSanitario");
    public Integer CARACTERISTICA_ESPERECIBLE = 422;
    public Integer CARACTERISTICA_VERIFICA_FECHACADUCIDAD = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.verificaFechaCaducidad");
    public Integer VERIFICA_PESO_VARIABLE = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.verificaPesoVariable");
    public Integer VERIFICA_LEY_ETIQUETADO = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.verificaSegmentoEtiquetas");
    public Integer VERIFICA_ETIQUETA_MERCANCIAS = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.EtiquetadoMercancias");
    public Integer CARACTERISTICA_NOAPLICAPVP = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.noAplicaPVP");
    public Integer CARACTERISTICA_COSTOBRUTOMAYORPVP = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.costoBrutoMayorPVP");
    public Integer CARACTERISTICA_PSUPMAYORCOSTONETO = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.PSUPmayorCostoNeto");
    public Integer CARACTERISTICA_CALCULO_PRECIO = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.calculo.precios");
    public Integer CARACTERISTICA_NO_APLICA_VALIDACION_TEMPORADA = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.no.aplica.validacion.temporada");
    public Integer CARACTERISTICA_OMISION_ASIGNACION_ALCANCES = SICArticuloMessages.getInstancia().getInteger("catalogo.caracteristica.omision.asignacion.alcances");
    
    
    public Integer AGRUPADOR_NATURALEZA = SICArticuloMessages.getInstancia().getInteger("catalogo.valor.agrupador.naturalezaArticulo");
    public String VALOR_NATURALEZA_PAPEL =  SICArticuloMessages.getInstancia().getString("catalogo.valor.naturaleza.cupon.papel");
    public String VALOR_NATURALEZA_VIRTUAL =  SICArticuloMessages.getInstancia().getString("catalogo.valor.naturaleza.cupon.virtual");
    public Integer LEYENDA_PREDETERMINADA_ARTICULO = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.leyendaPredeterminadaArticulo");
    
    public Integer TIPO_NOVEDAD_IMPORTACION = 253;
    public String VALOR_NOVEDAD_REFERENCIAPROVEEDOR= "1";
    public String VALOR_NOVEDAD_CODIGOBARRAS = "2";
    public String VALOR_NOVEDAD_CODIGOBARRAS_REFERENCIAPROVEEDOR = "3";
    public String VALOR_NOVEDAD_EXISTENTE_DIFERENCIAS_PROFORMA = "4";
    
    public Integer TIPO_ESTADO_NOVEDAD = 254;
    public String VALOR_ESTADO_NOVEDAD_RESUELTO = "RES";
    public String VALOR_ESTADO_NOVEDAD_PENDIENTE = "PEN";
    
    public Integer TIPOS_ETIQUETA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoEtiquetaArticulo");
    public Integer TIPOS_USO_CARNES = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoUsoCarnes");
    public String VALOR_USO_CARNES_TODO_USO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.usosCarnes.todoUso");
    
    public Integer TIPO_CONVENIO_PROVEEDOR = 255;
    public Integer TIPO_CONVENIO_INDICADOR_I = 256;
    public String VALOR_INDICADOR_I = "IDI";
    
    public Integer TIPO_CARACTERISTICA_TRANSGENICO = 258;
    public String VALOR_CARACTERISTICA_TRANSGENICO = "1";
    public String VALOR_CARACTERISTICA_NO_TRANSGENICO = "0";
    
    public Integer TIPOS_UNIDADES_MEDIDA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.unidadesMedida");
    public Integer TIPO_UNIDAD_MASA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoUnidadMasa");
    
    public Integer TIPO_CONTEXTO_ENVASE = 261;
    //tipos de estados de revision del registro sanitario
    public Integer TIPOESTADO_REVISIONREGISTROSANITARIO_IMPORTADO = 9044;
    public Integer TIPOESTADO_REVISIONREGISTROSANITARIO_INTERNO = 9045;
    //valores de los tipos de revision
    public String VALOR_REVISIONREGISTROSANITARIO_INTERNO_NORMAL = "RRS";
    public String VALOR_REVISIONREGISTROSANITARIO_INTERNO_INFNUT = "RIN";
    
    public String VALOR_LEYENDA_DESCUENTO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.leyenda.descuento");
    public String VALOR_LEYENDA_PRECIO_NORMAL_AFILIADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.leyenda.precio.normal");
    public String VALOR_LEYENDA_PRECIO_CUPON = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.leyenda.precio.cupon");      
    public String VALOR_LEYENDA_TERMINOS_CONDICIONES = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.leyenda.terminos.condiciones");
    public String VALOR_LEYENDA_PRECIO_CADA_KILO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.leyenda.precio.cada.kilo");
    
    public Integer CODIGO_NUTRICIONAL_GRASA = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.componente.nutricional.grasa");
    public Integer CODIGO_NUTRICIONAL_AZUCAR = 24;
    public Integer CODIGO_NUTRICIONAL_SAL = 25;
    
    public Integer AGRUPADOR_CONVERSION_UNIDADES = 268;
    public String VALOR_CONVERSION_UNIDADES_MEDIDA = "1";
    public String VALOR_CONVERSION_UNIDADES_MINIMA = "2";
    
    //valores articulo tipo costo proveedor
    public Integer AGRUPADOR_TIPO_COSTO = 312;
    public String VALOR_TIPO_COSTO_PROYECTADO1 = "CP1";
    public String VALOR_TIPO_COSTO_PROYECTADO2 = "CP2";
    
    //valores de las unidades de medida
    public String UNIDAD_MEDIDA_GRAMO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.unidad.medida.gramo");
    public String UNIDAD_MEDIDA_MILILITRO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.unidad.medida.mililitro");

    public Integer COMPONENTE_NUTRICIONAL_AZUCAR = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.azucar");
    public Integer COMPONENTE_NUTRICIONAL_CALCIO = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.calcio");
    public Integer COMPONENTE_NUTRICIONAL_CARBOHIDRATOS = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.carbohidratos");
    public Integer COMPONENTE_NUTRICIONAL_COLESTEROL = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.colesterol");
    public Integer COMPONENTE_NUTRICIONAL_FIBRAALIMENTARIA = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.fibraAlimentaria");
    public Integer COMPONENTE_NUTRICIONAL_GRASASATURADA = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.grasaSaturada");
    public Integer COMPONENTE_NUTRICIONAL_FIBRADIETETICA = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.fibraDietetica");
    public Integer COMPONENTE_NUTRICIONAL_GRASATOTAL = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.grasaTotal");
    public Integer COMPONENTE_NUTRICIONAL_GRASATRANS = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.grasaTrans");
    public Integer COMPONENTE_NUTRICIONAL_HIERRO = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.hierro");
    public Integer COMPONENTE_NUTRICIONAL_PROTEINA = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.proteina");
    public Integer COMPONENTE_NUTRICIONAL_SODIO = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.sodio");
    public Integer COMPONENTE_NUTRICIONAL_VITAMINAA = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.vitaminaa");
    public Integer COMPONENTE_NUTRICIONAL_VITAMINAC = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.vitaminac");
    public Integer COMPONENTE_NUTRICIONAL_GRASAMONOINSATURADA = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.grasaMonoinsaturada");
    public Integer COMPONENTE_NUTRICIONAL_GRASAPOLIINSATURADA = SICArticuloMessages.getInstancia().getInteger("componente.nutricional.grasaPoliinsaturada");
    
    //tipos de estudio nutricional
    public Integer TIPO_ESTUDIO_NUTRICIONAL = 269;
    public String ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO = "1";
    public String ESTUDIO_NUTRICIONAL_ANALISIS_BROMATOLOGICO = "2";
    
    //segmentos de creacion de un articulo
    public Integer PASOS_CREACION_ARTICULO = 226;
    public String VALOR_PASOCREACION_OMISION = "0";
    
    public Integer TIPO_ESTADO_APLICA_REGISTRO_SANITARIO = 272;
    public String VALOR_APLICA_REGISTRO_SANITARIO = "SA";
    public String VALOR_NO_APLICA_REGISTRO_SANITARIO = "NA";
    public String VALOR_NUNCA_APLICA_REGISTRO_SANITARIO = "NCA";
    //tipo de duracion conservacion
    public Integer TIPO_CODIGO_DURACION_CONSERVACION = 221;
    //tipos de proceso en la integracion asincrona con el SIC
    public Integer TIPO_PROCESO_INTEGRACION=271;
    public String PROCESO_INTEGRACION_CREACIONARTICULO="1";
    public String PROCESO_INTEGRACION_EDICIONARTICULO="2";
    public String PROCESO_INTEGRACION_MODIFICACIONCODIGOBARRAS="3";
    public String PROCESO_INTEGRACION_ACTIVACIONARTICULO="4";
    public String PROCESO_INTEGRACION_EDICIONMASIVAARTICULOS="5";
    public String PROCESO_INTEGRACION_CREACIONMASIVAARTICULOS="6";
    public String PROCESO_INTEGRACION_ACTUALIZACIONARTICULOSPORARCHIVO="7";
    public String PROCESO_INTEGRACION_ACTUALIZACION_CONDICIONES_COMERCIALES = "8";
    public String PROCESO_INTEGRACION_CAMBIO_PRECIOS_MAX_A_SIC = "9";
    public String PROCESO_INTEGRACION_DATOS_LOGISTICOS_ARTICULO = "10";

    // tipos de divisiones
    public String VALOR_DIVISION_UNO = "0001";
    public String VALOR_DIVISION_DOS = "0002";
    
    public Integer TIPO_CAUSALES_ARTICULO = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.catalogo.tipo.causal.articulo");
    public Integer TIPO_CAUSALES_ARTICULO_CLASE_O = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.catalogo.tipo.causal.articulo.clase.o");
    public Integer TIPO_CAUSALES_ARTICULO_CLASE_E = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.catalogo.tipo.causal.articulo.clase.e");
    public Integer TIPO_CAUSALES_ARTICULO_CLASE_I = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.catalogo.tipo.causal.articulo.clase.i");

    public Integer TIPO_ESTADO_LEY_MERCADO = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.estadoLeyPoderMercado");
    public String ESTADO_LEY_MERCADO_CODIFICADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.estadoLeyPoderMercado.codificado");
    public String ESTADO_LEY_MERCADO_DESCODIFICADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.estadoLeyPoderMercado.descodificado");
    public String ESTADO_LEY_MERCADO_REACTIVADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.estadoLeyPoderMercado.reactivado");
    
    //Tipo Marca Especial Ariculo
    public Integer TIPO_MARCAS_ESPECIALES = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipo.tipoMarcaEspecial");
    public String PRODUCTO_INTELIGENTE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipoMarcaEspecial.productoEspecial");
}