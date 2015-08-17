package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.corpv2.plantillas.dto.DetalleGrupoCampoPlantillaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;

public interface IBusquedaAndenesRecepcionGestor {

	/**
	 * Buscar andenes disponibles para la recepcion de un proveedor:
	 * 
	 * 1. Parametrizacion de andenes para Importados
	 * 2. Parametrizacion de andenes para Industrias
	 * 3. Parametrizacion de andenes para proveedores grandes
	 * 4. Parametrizacion de andenes por categorias
	 * 5. Parametrizacion de andenes para proveedores logisticos
	 * 6. Asignacion de andenes compartidos
	 * 7. Asignacion de andenes seguidos
	 * 8. Validacion de andenes ocupados
	 * 9. Asignacion de andenes mas proximos
	 * 10. Asignacion de un mismo anden a un proveedor
	 * 
	 * @param recepcionProveedorVO
	 * @param andenesNoDisponibles
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerAndenesRecepcion(RecepcionProveedorVO recepcionProveedorVO, Collection<DetalleSeccionDTO> andenesNoDisponibles, DetalleSeccionDTO andenReferencia, Integer cantidadAndenesSolicitados, Collection<String> clasificacionesProductosProveedor, Collection<DetalleGrupoCampoPlantillaDTO> listaDetGrupoCampoPla, Integer codigoAreaTrabajoPadre) throws SICException;
	
	/**
	 * Consultar los andenes disponibles en la bodega y clasificarlos en disponibles y ocupados
	 * @param codigoAreaTrabajo
	 * @param fechaRecepcion
	 * @param andenesNoDisponibles andenes no disponibles desde una variable de aplicaci&oacute;n
	 * @param numeroAnden restriccion para la busqueda de andenes por numero
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerAndenesLibresYOcupados(Integer codigoCompania, Integer codigoAreaTrabajo, Date fechaRecepcion, Collection<DetalleSeccionDTO> andenesNoDisponibles, String numeroAnden, Integer codigoAreaTrabajoPadre) throws SICException;
	
	/**
	 * Obtener los andenes asignados a un proveedor para editar la recepci&oacute;n
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleTareaDTO> obtenerAndenesAsignadosProveedor(RecepcionProveedorDTO recepcionProveedorDTO) throws SICException; 
	
}