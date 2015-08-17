/*
 * Creado el 2009-04-20
 */
package ec.com.smx.sic.cliente.resources;


/**
 * Gestor del archivo de propiedades interno de la Aplicacion
 * 
 * @author srivera
 * @author Mario Braganza
 */

public final class SICMessages extends AbstractMessages {
	
	private static final SICMessages INSTANCIA = new SICMessages();

	public static final String PAGE_SIZE = "parametro.tamanio.pagina";
	public static final String SYSTEM_ID = "ec.com.smx.codigo.sistema.sic";

	
	private SICMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.SICAplicacion"));   
	}
	
	public static SICMessages getInstancia(){
		return INSTANCIA;
	}
}

