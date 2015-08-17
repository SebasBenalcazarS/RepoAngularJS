package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.bodega.EnumCatalogoValorBodega;
import ec.com.smx.sic.cliente.common.bodega.EnumValorFiltrosUbicacion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAndenesPasillosDTO;

/**
 * 
 * @author fcollaguazo
 *
 */
public interface IDetalleSeccionDAO {

	public Collection<VistaAndenesPasillosDTO> obtenerAndenesPorClasificacion(List<String> codigosClasificacion, Integer codigoAreaTrabajo)throws SICException;
	
	/**
	 * devuelve un detalle segun la plantilla
	 * @param detalleSeccionDTO
	 * @return detalle seccion
	 * @throws SICException
	 */
	public DetalleSeccionDTO consultarDetalleSeccionUnico(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	
	/**
	 * Permite buscar el detalle seccion segun el area de trabajo e identificador
	 * @param detalleSeccionDTO
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	
	/**
	 * Permite la modificacion de tipo de almacenamiento a surtido o reserva 
	 * @param codigoDetalleSeccion
	 * @param codigoValorTipoAlmacenamiento
	 * @param userID
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void actualizarTipoAlmacenamiento(Long codigoDetalleSeccion, String codigoValorTipoAlmacenamiento,String userID,Integer codigoCompania,String valorTipoUbicacion)throws SICException;
	
	/**
	 * actualiza un detalle seccion
	 * @param detalleSeccionDTO
	 */
	public void actualizarDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO);
	
	/**
	 * Permite buscar las ubciaciones virtuales de una ubicacion
	 * @param detalleSeccionDTO
	 * @return
	 */
	public Collection<DetalleSeccionDTO> obtenerUbicacionesVirtuales(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	
	/**
	 * Metodo para actualizar el detalle secion de un anden
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	public void actualizarDetalleSeccionAnden(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	
	/**
	 * Metodo para obtener el maximo del orden de los andenes
	 * @param codigoCompania
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	public Integer maxOrdenAndenes(Integer codigoCompania,Integer codigoBodega)throws SICException;

	/**
	 * Obtiene el detalle seccion filtrado por identificador y codigo de area de trabajo
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param identificador
	 * @param valorTipoSeccion
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerDetalleSeccionPorIdentificador(Integer codigoCompania, Integer codigoAreaTrabajo, String identificador, String valorTipoSeccion) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> consultarDetalleSeccionAreasAreaTrabajo(Integer codigoCompania, Integer codigoBodega)throws SICException;
	
	/**
	 * Valida si la ubicacion rac o pasillo existe con su respectiva jerarquia
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoSubbodega
	 * @param identificador
	 * @param tipoSeccionIdentificador
	 * @return
	 * @throws SICException
	 */
	public Boolean validarUbicacion(Integer codigoCompania, Integer codigoBodega, Integer codigoSubbodega, String identificador, String tipoSeccionIdentificador)throws SICException;
	
	/**
	 * Permite buscar el detalle seccion segun el area de trabajo
	 * @param detalleSeccionDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerDetalleSeccionCol(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	
	/**
	 * Permite consultar ubicaciones con rango de pasillos, rack, o ubicaciones
	 * @param codigoCompania
	 * @param codigoSUbBodega
	 * @param codigoBodega
	 * @param valorRangos
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> consultarUbicacionesPorRango(Integer codigoCompania,Integer codigoBodega ,Integer codigoSubBodega,HashMap<EnumValorFiltrosUbicacion, Long> valorRangos)throws SICException;
	
	/**
	 * Permite obtener los detalle seccion dado el nombre.
	 * @param codigoCompania
	 * @param nombre
	 * @return Collection<DetalleSeccionDTO>
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerDetalleSeccionPorNombre(Integer codigoCompania, String nombre)throws SICException;
	
	/**
	 * Permite obtener los detalle seccion dado el nombre.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param listaAnden
	 * @return 
	 * @throws SICException
	 */
	void cambiarEstadoAnden(Integer codigoCompania, Collection<Long> listaAnden, String estado)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerDetalleSeccionRelacionados(Integer codigoCompania, Collection<Long> andenesOcupados)throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDetalleSeccion
	 * @return
	 */
	public Collection<RecepcionProveedorDetalleSeccionDTO> consultarAndenesProveedorOcupados(Integer codigoCompania, Collection<Long> codigoDetalleSeccion);
	
	/**
	 * Obtener andenes asignados en la recepcion
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param valorTipoSeccion
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> consultarCodigoDetalleSeccionIdentificador(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;
	
	/**
	 * Obtener el anden por bodega
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param identificador
	 * @return
	 */
	DetalleSeccionDTO obtenerAndenPorBodega(Integer codigoCompania, Integer codigoAreaTrabajo, String identificador) throws SICException;

	/**
	 * Obtiene la relacion de una seccion hija con un tipo de seccion padre
	 * @param codigoCompania
	 * @param codigoSeccionHija
	 * @param valorTipoSeccion
	 * @return
	 * @throws SICException
	 */
	RelacionSeccionDTO obtenerRelacionSeccionTipo(Integer codigoCompania, Long codigoSeccionHija, String valorTipoSeccion,Integer codigoAreaTrabajoPadre,Integer codigoAreaTrabajo) throws SICException;

	/**
	 * Obtener los andenes por un rango asignados a un funcionario 
	 * @author Yuniesky Armentero Moreno
	 * @param funcionario
	 * @param ordeninicio
	 * @param ordenfin
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerAndenesPorOrden(FuncionarioProcesoPerfilAreaTrabajoDTO funcionario, Integer ordeninicio, Integer ordenfin) throws SICException;

	/**
	 * Obtener los andenes de una area de trabajo
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerAndenPorAreaTrabajo(Integer codigoCompania, Integer codigoAreaTrabajo) throws SICException;

	/**
	 * Obtener los andenes de una area de trabajo y por su nombre
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param nombre
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerAndenPorAreaTrabajoPorNombre(Integer codigoCompania, Integer codigoAreaTrabajo, String nombre) throws SICException;
	
	/**
	 * Obtener los andenes de una coleccion de recepcion proveedor
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param recepcionProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerAndenesPorRecepcionProveedor(Integer codigoCompania, Collection<Long> recepcionProveedor) throws SICException;
	
	/**
	 * obtiene un detalle seccion por id
	 * @param codigoCompania
	 * @param codigoDetalleSeccion
	 * @return
	 * @throws SICException
	 */
	DetalleSeccionDTO obtenerDetalleSeccionId(Integer codigoCompania, Long codigoDetalleSeccion) throws SICException ;
	
	/**
	 * Sirve para consultar los detallesSeccion de acuerdo al area de trabajo, la compania y el tiposeccion (NAV,SNA,etc).
	 * @param codigoCompania
	 * @param areasTrabajo
	 * @param valorTipoSeccion
	 * @return
	 */
	Collection<DetalleSeccionDTO> obtenerDetalleSeccionPorAreaTrabajoValorTipoSeccion(Integer codigoCompania,Collection<Integer> areasTrabajo,EnumCatalogoValorBodega valorTipoSeccion) throws SICException;
	
	/**
	 * Sirve para consultar los detallesSeccion de acuerdo al area de trabajo, la compania y el tiposeccion (NAV,SNA,etc) y que sean hijos
	 * de un detalleseccion enviado como parametro.
	 * @param codigoCompania
	 * @param detalleSeccionPadre
	 * @param areasTrabajo
	 * @param valorTipoSeccion
	 * @return
	 */
	Collection<DetalleSeccionDTO> obtenerDetalleSeccionRelacionadoPorAreaTrabajoValorTipoSeccion(Integer codigoCompania,Long detalleSeccionPadre,Collection<Integer> areasTrabajo,EnumCatalogoValorBodega valorTipoSeccion) throws SICException;
	
	/**
	 * Devuelve los detalles seccion con el identificador de acuerdo a la lista de codigos enviados.
	 * @param codigosDetalleSeccion
	 * @return
	 */
	Collection<DetalleSeccionDTO> obtenerIdentificadorCodigosDetalleSeccion(Integer codigoCompania,Collection<Long> codigosDetalleSeccion) throws SICException;

	/**
	 * Cambiar el estado a los andenes dado la recepcion del proveedor.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @param estado
	 * @return 
	 * @throws SICException
	 */
	void cambiarEstadoAnden(Integer codigoCompania, Long recepcionProveedor, String estado) throws SICException;
	/**
	 * 
	 * @param detalleSeccionDTO
	 * @param tipoSeccion
	 * @throws SICException
	 */
	public void crearDetalleSeccionNativo(DetalleSeccionDTO detalleSeccionDTO,String tipoSeccion)throws SICException;
	/**
	 * 
	 * @param detalleSeccionDTO
	 * @param tipoSeccion
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO consultarDetalleSeccionUnico(DetalleSeccionDTO detalleSeccionDTO,String tipoSeccion) throws SICException;
}
