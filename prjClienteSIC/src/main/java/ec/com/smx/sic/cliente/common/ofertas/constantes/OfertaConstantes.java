/**
 * 
 */
package ec.com.smx.sic.cliente.common.ofertas.constantes;

import ec.com.smx.sic.cliente.resources.ofertas.SICOfertasMessages;

/**
 * @author gnolivos
 *
 */
public final class OfertaConstantes {
	
	private static final OfertaConstantes INSTANCIA = new OfertaConstantes();
	
	private OfertaConstantes() { }
	
	public static OfertaConstantes getInstancia(){
		return INSTANCIA;
	}

	// Valor tipo ofertas
    public final String CODIGO_CATALOGO_VALOR_OFERTA_VENTA			= "VEN";
    public final String CODIGO_CATALOGO_VALOR_COSTO 				= "COS";
    public final String CODIGO_CATALOGO_VALOR_OFERTA_VENTA_COSTO 	= "VYC";
    
    // Tipos de oferta
    public final String CODIGO_TIPO_OFERTA_VENTA = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.codigo.tipo.oferta.venta");
    public final String CODIGO_TIPO_OFERTA_COSTO = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.codigo.tipo.oferta.costo");
    public final String CODIGO_TIPO_OFERTA_VENTA_COSTO = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.codigo.tipo.oferta.venta.costo");
    public final String DESCRIPCION_TIPO_OFERTA_VENTA = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.descripcion.tipo.oferta.venta");
    public final String DESCRIPCION_TIPO_OFERTA_COSTO = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.descripcion.tipo.oferta.costo");
    public final String DESCRIPCION_TIPO_OFERTA_VENTA_COSTO = SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.descripcion.tipo.oferta.venta.costo");
    
}
