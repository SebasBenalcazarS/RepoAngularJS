package ec.com.smx.sic.cliente.common.produccion.lineasEmpaque.filtros;

import ec.com.smx.sic.cliente.resources.produccionEmpacado.SICProduccionMessajes;



/**
 * 
 * @author acuenca
 *
 */
public class SICProduccionConstantes {

	private static final SICProduccionConstantes INSTANCIA = new SICProduccionConstantes();
	
	public static SICProduccionConstantes getInstancia() {
		return INSTANCIA;
	}
	
	
	public static final Integer CODIGO_TIEMPO_PRODUCCION = SICProduccionMessajes.getInstancia().getInteger("codigo.catalogo.tipo.tiempoProduccion");
}
