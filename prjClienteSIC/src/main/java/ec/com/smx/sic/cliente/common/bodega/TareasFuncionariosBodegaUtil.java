package ec.com.smx.sic.cliente.common.bodega;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

/**
 * Clase para obtener valores referentes a las tareas que realizan los funcionarios en las bodegas
 * @author wcaiza
 *
 */
public final class TareasFuncionariosBodegaUtil {
	
	private static final TareasFuncionariosBodegaUtil INSTANCIA = new TareasFuncionariosBodegaUtil();
	
	private TareasFuncionariosBodegaUtil () {};
	
	public static TareasFuncionariosBodegaUtil getInstancia(){
		return INSTANCIA;
	}
	
	private Collection<String> estadosTareaRecolectorTrabajar;
	
	private Collection<String> estadosTareaRecolectorContinuarTrabajo;
	
	/**
	 * Estados de las tareas q puede tener un recolector para iniciar o continuar a trabajar con una tarea.</br>
	 * <li>REGISTRADA = REG</li>
	 * <li>ASIGNADA = ASI</li>
	 * <li>ENPROCESO = EPR</li>
	 * @return the estadosTareaRecolectorTrabajar
	 */
	public Collection<String> getEstadosTareaRecolectorTrabajar() {
		if (CollectionUtils.isEmpty(estadosTareaRecolectorTrabajar)) {
			estadosTareaRecolectorTrabajar = this.obtenerEstadosTareaRecolectorIniciarContinuarTrabajar();
		}
		return estadosTareaRecolectorTrabajar;
	}
	
	/**
	 * Estados de las tareas q puede tener un recolector para continuar a trabajar con una tarea.</br>
	 * <li>ASIGNADA = ASI</li>
	 * <li>ENPROCESO = EPR</li>
	 * @return the estadosTareaRecolectorContinuarTrabajo
	 */
	public Collection<String> getEstadosTareaRecolectorContinuarTrabajo() {
		if (CollectionUtils.isEmpty(estadosTareaRecolectorContinuarTrabajo)) {
			estadosTareaRecolectorContinuarTrabajo = obtenerEstadosTareaRecolectorContinuarTrabajar();
		}
		return estadosTareaRecolectorContinuarTrabajo;
	}
	
	/**
	 * Obtener los estados de las tareas q puede tener un recolector para iniciar a trabajar con una tarea.
	 * @return
	 */
	private Collection<String> obtenerEstadosTareaRecolectorIniciarContinuarTrabajar () {
		
		Collection<String> listaEstadosTarea = new ArrayList<String>();
		listaEstadosTarea.add(EnumEstadosTareaRecolector.REGISTRADA.getEstado());
		listaEstadosTarea.add(EnumEstadosTareaRecolector.ASIGNADA.getEstado());
		listaEstadosTarea.add(EnumEstadosTareaRecolector.ENPROCESO.getEstado());
		
		return listaEstadosTarea;
	}
	
	/**
	 * Estados de las tareas q puede tener un recolector para continuar el trabajo con la tarea.
	 * @return
	 */
	private Collection<String> obtenerEstadosTareaRecolectorContinuarTrabajar () {
		
		Collection<String> listaEstadosTarea = new ArrayList<String>();
		listaEstadosTarea.add(EnumEstadosTareaRecolector.ASIGNADA.getEstado());
		listaEstadosTarea.add(EnumEstadosTareaRecolector.ENPROCESO.getEstado());
		return listaEstadosTarea;
	}

}
