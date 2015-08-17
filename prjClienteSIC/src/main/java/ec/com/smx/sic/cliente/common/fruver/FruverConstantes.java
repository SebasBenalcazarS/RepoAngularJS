/**
 * 
 */
package ec.com.smx.sic.cliente.common.fruver;

import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.fruver.SICFruverMessages;


/**
 * @author gnolivos
 *
 */
public final class FruverConstantes {
	
	private static final FruverConstantes INSTANCIA = new FruverConstantes();
	
	// Tipo estado solicitud proveedor
	public static final Integer CODIGO_TIPO_ESTADO = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.codigoTipoEstadoSolicitud");
	public static final String VALOR_TIPO_ESTADO_GUARDADO = SICFruverMessages.getInstancia().getString("ec.com.smx.sic.fruver.valor.tipoEstado.guardado");
	public static final String VALOR_TIPO_ESTADO_ENVIADO = SICFruverMessages.getInstancia().getString("ec.com.smx.sic.fruver.valor.tipoEstado.enviado");
	public static final String VALOR_TIPO_ESTADO_GENERADO = SICFruverMessages.getInstancia().getString("ec.com.smx.sic.fruver.valor.tipoEstado.generado");
	
	// Tipo solicitud proveedor
	public static final Integer CODIGO_TIPO = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.codigoTipoSolicitud");
	public static final String VALOR_TIPO_OFERTA = SICFruverMessages.getInstancia().getString("ec.com.smx.sic.fruver.valor.tipo.oferta");
	public static final String VALOR_TIPO_APROBACION = SICFruverMessages.getInstancia().getString("ec.com.smx.sic.fruver.valor.tipo.aprobacion");
	
	//Rango de fecha
	public static final Integer CODIGO_RANGO_FECHAS = SICFruverMessages.getInstancia().getInteger("ec.com.smx.sic.fruver.codigo.rango.fechas");
	public static final Integer CODIGO_RANGO_HORAS_FECHAS = SICFruverMessages.getInstancia().getInteger("ec.com.smx.sic.fruver.codigo.rango.horas.fechas");
	
	private FruverConstantes(){}
	
	/**
	 * @return the iNSTANCIA
	 */
	public static FruverConstantes getInstancia() {
		return INSTANCIA;
	}

}
