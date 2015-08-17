package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.encriptacion.util.CodificacionUtil;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.articulo.gestor.alcance.ArticuloAlcanceGestor;
import ec.com.smx.sic.articulo.persistence.dao.ArticuloAlcanceDAO;
import ec.com.smx.sic.articulo.servicio.ArticuloAlcanceServicio;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * Obtiene los datos que retorna el reader del cursor
 * @author fcollaguazo
 *
 */
public class ArticuloAlcanceItemWriter<T extends SearchDTO> implements ItemWriter<ArticuloDTO>{

	/**
	 * Plantilla de busqueda y parametros
	 */
	private String articuloVOString;
	
	private Integer count = 0;
	
	private ArticuloVO articuloVO = null;
	
	@Override
	public void write(List<? extends ArticuloDTO> articuloCol) throws SICException {
		Logeable.LOG_SICV2.info("****************************---------------********************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando ArticuloAlcanceItemWriter<T extends SearchDTO>");
		Logeable.LOG_SICV2.info("****************************---------------********************************");
		try {
			
			if(articuloVO == null){
				articuloVO = CodificacionUtil.getInstancia().decodificarStringAObjeto(articuloVOString, ArticuloVO.class);
			}
			//Actualizar la informacion en articulo local y articulo
			if(CollectionUtils.isNotEmpty(articuloCol)){
				count += articuloCol.size();
				Logeable.LOG_SICV2.info("Total de articulos {}, plantilla {}",count);
				
				SICFactory.getInstancia().articulo.getArticuloAlcanceServicio().asignarAlcancesAreaTrabajo(articuloCol, articuloVO);
				
			}
		} catch (SICException e) {			
			Logeable.LOG_SICV2.info("Total de articulos  plantilla {}", e);
			
			String mensaje = null;
			StackTraceElement[] stack = e.getStackTrace();
			if(stack.length != 0){
				mensaje = obtenerCausaExcepcion(e.getCause());
				if(mensaje == null){
					mensaje = obtenerMensajeExcepcion(stack).concat(" - ").concat(e.toString());
				}
			}
			
			//se crea la bitacora de error de alcances
			if(CollectionUtils.isNotEmpty(articuloCol)){
				String codigoArticulo = articuloCol.get(0).getId().getCodigoArticulo();
				SICFactory.getInstancia().articulo.getArticuloAlcanceServicio().insertarBitacoraArticuloAreaTrabajoError(articuloVO, codigoArticulo, mensaje);
			}
		}
	}
	
	/**
	 * Permite obtener el primer nivel donde se produjo el error
	 * @param error Causa que contiene al siguiente nivel
	 * @return Mensaje de error
	 */
	private String obtenerCausaExcepcion(Throwable error){
		if(error != null){
			StackTraceElement[] stack = error.getStackTrace();
			if(stack.length != 0){
				if(error.getCause() != null){
					return obtenerCausaExcepcion(error.getCause());
				}
				return obtenerMensajeExcepcion(stack).concat(" - ").concat(error.toString());
			}	
		}
		return null;
	}
	
	/**
	 * Permite obtener la linea en la que se produjo el error
	 * @param stack Pila generada por el error
	 * @return Metodo y linea donde se produjo el error
	 */
	private String obtenerMensajeExcepcion(StackTraceElement[] stack){
		for(StackTraceElement element : stack){
			if(element.getClassName().equals(ArticuloAlcanceDAO.class.getCanonicalName()) ||
			   element.getClassName().equals(ArticuloAlcanceGestor.class.getCanonicalName()) || 
			   element.getClassName().equals(ArticuloAlcanceServicio.class.getCanonicalName())){
				return element.toString();
			}
		}
		return "";
	}

	/**
	 * @param articuloVOString the articuloVOString to set
	 */
	public void setArticuloVOString(String articuloVOString) {
		this.articuloVOString = articuloVOString;
	}
	
}