package ec.com.smx.sic.cliente.common.procesamientoventas.beans;

import java.util.Collection;
import java.util.HashSet;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.cambioprecios.CambioPreciosUtil;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;

/**
 * @author Marcelo Hidalgo
 *
 */
public final class ProcesamientoVentasThread {
	
	private final static ProcesamientoVentasThread INSTANCE = new ProcesamientoVentasThread();

	public ProcesamientoVentasThread() {
	}
	
	public static ProcesamientoVentasThread getInstance() {
		return INSTANCE;
	}
	
	public static void actualizarPreciosArticulos(final Collection<ArticuloPrecioDTO> articulosPrecios){
		final Integer numeroHilos = 5;
		Thread thread;
		Integer iteraciones;
		Integer numeroArticulosPorHilo; 
		try {
			numeroArticulosPorHilo = articulosPrecios.size() / numeroHilos;
			if(numeroArticulosPorHilo <= 1)
				numeroArticulosPorHilo = articulosPrecios.size();
			iteraciones = CambioPreciosUtil.getInstance().calcularIteracionesConsultasDinamicas(articulosPrecios.size(), numeroArticulosPorHilo);
			
			for(int i=0; i< iteraciones; i++){
				final Collection<ArticuloPrecioDTO> articulosPrecioAlmacenar = CambioPreciosUtil.getInstance().obtenerItemsConsultaPorIteracionActual(new HashSet<ArticuloPrecioDTO>(articulosPrecios), numeroArticulosPorHilo, i);
				
				thread = new Thread("hilo procesamiento ventas "+ i){
					public void run() {
						SICFactory.getInstancia().articulo.getArticuloService().registrarPrecioArticuloPorTipoPrecio(articulosPrecioAlmacenar);
					};
				};
				thread.start();
				thread.join();
			}
		} catch (InterruptedException e) {
			Logeable.LOG_SICV2.error("Ocurrio un ERROR al actualizar los precios de articulos por hilos");
		}
	}

}
