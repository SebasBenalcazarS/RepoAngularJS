/**
 * 
 */
package ec.com.smx.sic.cliente.common;

/**
 * @author Mario Braganza
 *
 */
public class SICNombresPointcuts {
	
	public static final String VALIDAR_PROVEEDOR_POINTCUT = "execution(* ec.com.smx.sic.proveedor.gestor.administracion.validacion.ValidacionJDEProveedorGestor.validarProveedor(..))";
	public static final String ESTABLECER_DATOS_PERSONA_LOCALIZACION_PROVEEDOR_POINTCUT 
		= "execution(* ec.com.smx.sic.proveedor.gestor.datosexternosproveedor.calculo.CalculoDatosExternosProveedorGestor.establecerDatosPersonaLocalizacionProveedor()) && args(codigoCompania, proveedor, resultadoValidacionProveedor)";
	
	// Pointcuts para la bodega
	public static final String REGISTRAR_TAREA_RECESO_POINTCUT = "execution(* ec.com.smx.sic.bodega.gestor.tareas.almacenamiento.AlmacenamientoTareasGestor.asignarTareaFuncionario(..))";
}
