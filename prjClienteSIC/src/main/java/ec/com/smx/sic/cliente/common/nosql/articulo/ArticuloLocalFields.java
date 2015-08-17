/**
 * 
 */
package ec.com.smx.sic.cliente.common.nosql.articulo;


import ec.com.smx.framework.utilitario.nosql.common.constants.AuditoriaFields;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;


/**
 * Atributos que se utilizan en la clase ArticuloLocalDTO de OrientDB
 * @author wcaiza
 *
 */
public class ArticuloLocalFields extends AuditoriaFields{
	
	public final static String CODIGO_COMPANIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoCompania");
	public final static String CODIGO_ARTICULO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoArticulo");
	public final static String CODIGO_LOCAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoLocal");
	public final static String ESTADO_ARTICULO_LOCAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.estadoArticuloLocal");
	public final static String FECHA_INICIAL_ALCANCE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.fechaInicialAlcance");
	public final static String FECHA_FINAL_ALCANCE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.fechaFinalAlcance");
	public final static String MINIMO_STOCK = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.minimoStock");
	public final static String MAXIMO_STOCK = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.maximoStock");
	public final static String CODIGO_REFERENCIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoReferencia");
	public final static String ESTADO_CODIGO_REFERENCIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.estadoCodigoReferencia");
	public final static String ESTADO_INTEGRACION_ALCANCE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.estadoIntegracionAlcance");
	public final static String ID_USUARIO_ACTIVACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.idUsuarioActivacion");
	public final static String FECHA_ACTIVACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.fechaActivacion");
	public final static String ID_USUARIO_INACTIVACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.idUsuarioInactivacion");
	public final static String FECHA_INACTIVACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.fechaInactivacion");
	public final static String CODIGO_SISTEMA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoSistema");
	public final static String CODIGO_OPCION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoOpcion");
	public final static String VALOR_TIPO_ASIGNACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.valorTipoAsignacion");
	public final static String CODIGO_TIPO_ASIGNACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoTipoAsignacion");
	public final static String NOTIFICAR_LOCAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.notificarLocal");
	public final static String APERTURA_LOCAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.aperturaLocal");
	public final static String VALOR_TIPO_AREA_TRABAJO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.valorTipoAreaTrabajo");
	public final static String CODIGO_TIPO_AREA_TRABAJO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoTipoAreaTrabajo");
	public final static String CODIGO_GRUPO_ALCANCE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.field.codigoGrupoAlcance");
	
}
