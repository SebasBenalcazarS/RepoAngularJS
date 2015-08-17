/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.TransformerUtils;

import ec.com.kruger.utilitario.dao.commons.constants.EventTypeEnum;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public abstract class CodigoResultadoValidacionProveedor implements Comparable<CodigoResultadoValidacionProveedor>, Serializable {
	
	private final Accion accion;
	private final Boolean mostrarAlerta;
	private final EventTypeEnum eventType;
	
	public enum Accion{
		EDITAR,
		CREAR,
		VALIDAR,
		ERROR,
		VISUALIZAR;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(CodigoResultadoValidacionProveedor objeto) {
		
		if (objeto == null || this != objeto){
			return -1;
		}
		
		return 0;
	}

	protected CodigoResultadoValidacionProveedor(Accion accion, Boolean mostrarAlerta, EventTypeEnum eventType){
		this.accion = accion;
		this.mostrarAlerta = mostrarAlerta;
		this.eventType = eventType;
	}
	
	/**
	 * @return the accion
	 */
	public Accion getAccion() {
		return accion;
	}
	
	
	/**
	 * @return the mostrarAlerta
	 */
	public Boolean getMostrarAlerta() {
		return mostrarAlerta;
	}
	
	
	/**
	 * @return the eventType
	 */
	public EventTypeEnum getEventType() {
		return eventType;
	}
	
	public abstract TipoValidacionProveedor getTipoValidacionProveedor();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Field field = (Field) CollectionUtils.find(Arrays.asList(this.getClass().getFields()), 
				PredicateUtils.transformedPredicate(TransformerUtils.invokerTransformer("get", new Class[]{Object.class}, new Object[]{null}), PredicateUtils.equalPredicate(this)));
		
		return (field != null ? field.getName() : "");
	}
	
	

}
