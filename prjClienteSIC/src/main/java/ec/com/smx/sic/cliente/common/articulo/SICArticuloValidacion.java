/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author fmunoz
 *
 */
public final class SICArticuloValidacion {

	public static final String VALIDACIONCODIGOBARRAS_DESACTIVARCREAR = "1";
	public static final String VALIDACIONCODIGOBARRAS_ACTUALIZAR = "2";
	public static final String VALIDACIONCODIGOBARRAS_SINACCION = "3";
	
	
	//MENSAJES DE ERROR GENERICOS
	public static final String MENSAJE_ERROR_REGISTRAR_ARTICULO = SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo");
	public static final String MENSAJE_ERROR_REGISTRAR_ARTICULO_ARCHIVO = SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.archivo");
	
	private static final SICArticuloValidacion INSTANICA = new SICArticuloValidacion();
	private SICArticuloValidacion() {}
	/**
	 * @return the iNSTANCIA
	 */
	public static SICArticuloValidacion getInstancia() {
		return INSTANICA;
	}
	
	public Boolean calcularPrecioMayorista(ArticuloDTO articuloDTO){
		if(
				(articuloDTO.getPrecioBase() < SICArticuloConstantes.getInstancia().LIMITE_PRECIOBASE_SINIMPUESTO_CALCULOMAYORISTA 
						&& (articuloDTO.getTotalImpuestosVenta() != null && articuloDTO.getTotalImpuestosVenta().get(SICArticuloCalculo.CLAVE_PORCENTAJEIMPUESTO) == 0)
						&& (articuloDTO.getTotalImpuestosVenta() != null && articuloDTO.getTotalImpuestosVenta().get(SICArticuloCalculo.CLAVE_VALORIMPUESTO) == 0))
				|| 
				(articuloDTO.getPrecioBase() < SICArticuloConstantes.getInstancia().LIMITE_PRECIOBASE_SINIMPUESTO_CALCULOMAYORISTA 
						&& articuloDTO.getTotalImpuestosVenta() == null)
				||
				(articuloDTO.getPrecioBase() < SICArticuloConstantes.getInstancia().LIMITE_PRECIOBASE_CONIMPUESTO_CALCULOMAYORISTA 
						&& 
							(articuloDTO.getTotalImpuestosVenta() != null && (articuloDTO.getTotalImpuestosVenta().get(SICArticuloCalculo.CLAVE_PORCENTAJEIMPUESTO) > 0
							|| articuloDTO.getTotalImpuestosVenta().get(SICArticuloCalculo.CLAVE_VALORIMPUESTO) > 0)))
			)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}
	
	public Boolean esArchivoRegistroSanitario(String tipoArchivo){
		return SICArticuloConstantes.getInstancia().TIPOARCHIVO_DOCREGSAN.equals(tipoArchivo)
				|| SICArticuloConstantes.getInstancia().TIPOARCHIVO_IMGREGSAN.equals(tipoArchivo);
	}
}
