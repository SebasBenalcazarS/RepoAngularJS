package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.dto.FuncionarioSublugarTrabajoRelacionadoDTO;
import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaRecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecipienteTaraDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaListaProveedoresRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

public interface IRecepcionProveedorDAO {

	
	/**
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param catalogoValorDTO
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	CaracteristicaProcesoAreaTrabajoDTO obtenerCaracteristicaValidacionesRecepcion(Integer codigoCompania, Integer codigoAreaTrabajo, CatalogoValorDTO catalogoValorDTO, Long codigoProceso) throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaRecepcionProveedorDTO> obtenerEntregasEnRecepcion(RecepcionProveedorDTO recepcionProveedorDTO)  throws SICException;
	
	
	
	/**
	 * 
	 * @param parametroDTO
	 * @return
	 * @throws SICException
	 */
	String obtenerParametroRecepcion(ParametroDTO parametroDTO)  throws SICException;	
	
	/**
	 * 
	 * @param codigosEntrega
	 * @return
	 * @throws SICException
	 */
	Object[] obtenerBultosItemsOrdenCompra(Collection<Long> codigosEntrega)  throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigoCD
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProveedorDTO> obtenerRecepcionProveedoresPorEntrega(Date fecha, final Time hora, final String codigoNombreProveedor, Collection<Integer> codigosATBodega) throws SICException;
	
	/**
	 * 
	 * @param codigoRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaOrdenCompraEstadoDTO> obtenerEntregaOrdenCompraEstadoPorRecepcion(Long codigoRecepcionProveedor, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigosProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProveedorDTO> obtenerRecepcionProveedoresPorPlanificacion(Date fecha, Time hora, String codigoNombreProveedor, Collection<String> codigosProveedor) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigosATBodega
	 * @return
	 * @throws SICException
	 */
	Collection<VistaListaProveedoresRecepcionEntregaDTO> obtenerListaRecepcionProveedoresPorEntrega(Date fecha, Time hora, String codigoNombreProveedor, Integer codigoATCD, Integer codigoATBodega) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigoATBodega
	 * @param codigosATBodega
	 * @return
	 * @throws SICException
	 */
	Collection<VistaListaProveedoresRecepcionEntregaDTO> obtenerListaRecepcionProveedoresPorPlanificacion(Date fecha, Time hora, String codigoNombreProveedor, Collection<String> codigosProveedor, Integer codigoATCD, Integer codigosATBodega) throws SICException;
	
	/**
	 * 
	 * @param vistaProveedorDTO
	 * @param fechaEntrega
	 * @param hora
	 * @return
	 * @throws SICException
	 */
	Integer contarCantidadDisponibleAndenes(VistaProveedorDTO vistaProveedorDTO, Date fechaEntrega, Time hora, Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * 
	 * @param vistaProveedorDTO
	 * @param fecha
	 * @param hora
	 * @param codigoBodegaAT
	 * @return
	 * @throws SICException
	 */
	Integer contarFurgonesRegistrados(Long codigoRecepcionProveedor, String codigoProveedor, Date fecha, Time hora, Integer codigoBodegaAT) throws SICException;

	/**
	 * obtiene el numero de pallets en el que se encuentra registrado los articulos de una orden de compra
	 * 
	 * @param recepcion
	 * @param codigosOrdenCompraDetalleEstados
	 * @param tareaPerfilDTO
	 */
	Integer obtenerNumeroPalletsArtRegistrados(RecepcionProveedorDTO recepcion, Collection<Long> codigosOrdenCompraDetalleEstados, TipoTareaPerfilDTO tareaPerfilDTO) throws SICException;
	
	
	/**
	 * Busca las entregas que se encuentran en la recepcion por tipo de entrega (FDI, PLA)
	 * 
	 * @param tipoEntrega
	 * @param codigosRecepcion
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<EntregaDTO> obtenerEntregasDesdeRecepcion(CatalogoValorDTO tipoEntrega, Collection<Long> codigosRecepcion) throws SICException;

	
	/**
	 * Obtiene la transaccion para el proceso de recepcion
	 *
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param catalogoTipoRecepcion
	 * @param contextoValor
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	TransaccionDTO obtenerTransaccionRecepcion(Integer codigoCompania, Long codigoProceso, CatalogoValorDTO catalogoTipoRecepcion, String contextoValor) throws SICException;

	/**
	 * Obtener el funcionario y area de trabajo relacionado que esta configurado por defecto.
	 *
	 * @param codigoFuncionario
	 * @param codigoCompania
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	FuncionarioSublugarTrabajoRelacionadoDTO obtenerFuncionarioAreaTrabajoRelacionado(String codigoFuncionario, Integer codigoCompania) throws SICException;

	
	/**
	 * <b> Obtiene el tipo de control de costos<b>
	 * <p>
	 * [Author: aecaiza, Date: 27/10/2014]
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 */
	String obtenerTipoControlCostos(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * 
	 * @param recepcionEnProceso
	 * @param cantidadBultosActualizar
	 * @param pesoActualizar
	 * @param palletsActualizar
	 * @param idUsuarioModificacion
	 * @throws SICException
	 */
	void actualizarDatosRecepcion(RecepcionProveedorDTO recepcionEnProceso, Integer cantidadBultosActualizar, BigDecimal pesoActualizar, Integer palletsActualizar, String idUsuarioModificacion) throws SICException;

	
	/**
	 * Obtine el total actual de bultos y pallets recibidos de la recepcion enviada
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	RecepcionProveedorDTO obtenerDatosRecepcion(RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * <b>  Actualizar los totales de la recepcion<b>
	 * <p>
	 * [Author: lguaman, Date: 12/11/2014]
	 * @param recepcion
	 * @return
	 */
	void actualizarTotalesRecepcion(RecepcionProveedorDTO recepcion) throws SICException;

	/**
	 * Obtener la lista de caracteristica area valor
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param caracteristicaCatalogoTipo
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	Map<String, String> obtenerCaracteristicaValidacionesRecepcionCol(Integer codigoCompania, Integer codigoAreaTrabajo, Integer caracteristicaCatalogoTipo, Long codigoProceso) throws SICException;

	/**
	 * Obtener las recepciones del dia actual de un proveedor
	 * @param recepcionProveedorPlantilla
	 * @param fecha
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorDTO> obtenerRecepcionProveedorDia(RecepcionProveedorDTO recepcionProveedorPlantilla, Date fecha) throws SICException;

	/**
	 * <b> Comprobar si la recepcion tiene tareas<b>
	 * <p>
	 * [Author: lguaman, Date: 24/11/2014]
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @return
	 */
	Boolean comprobarRecepcionTieneTarea(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;

	
//	/**
//	 * Obtiene una coleccion de jabas de recepcion de pallets
//	 * @param codigoCompania
//	 * @param colCodigoDatosTarea
//	 * @return
//	 * @throws SICException
//	 */
//	Collection<VistaJabasPalletRecepcionDTO> obtenerJabasRecepcionPallets(Integer codigoCompania, Collection<Long> colCodigoDatosTarea) throws SICException;
	
	/**
	 * Obtiene un recipiente filtrado por codigo de barras 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	RecipienteTaraDTO obtenerRecipienteCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;

	/**
	 * Obtiene las recepciones configuradas del proveedor
	 * @param recepcion
	 * @param valoresExcluirEstadoRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorDTO> obtenerRecepcionesPorProveedor(RecepcionProveedorDTO recepcion, Collection<String> valoresExcluirEstadoRecepcion) throws SICException;

	/**
	 * Obtiene el numero de proveedores en recepcion en el dia
	 * @param recepcionProveedorPlantilla
	 * @param estadosExcluir
	 * @return
	 * @throws SICException
	 */
	Long obtenerNumeroProveedoresRecepcion (RecepcionProveedorDTO recepcionProveedorPlantilla, Collection<String> estadosExcluir) throws SICException;
	
	/**
	 * <b> Obtiene el tipo de control de costos por el catalogo valor relacionado<b>
	 * <p>
	 * [Author: aecaiza, Date: 12/02/2015]
	 * @param codigoCompania
	 * @param codigoTipoControlCosto
	 * @param codigoCatalogoValorTipoPadre
	 * @param codigoValorTipoRelacionado
	 * @return
	 * @throws SICException
	 */
	CatalogoValorRelacionadoDTO obtenerCatalogoValorTipoControlCostos(Integer codigoCompania, String codigoTipoControlCosto, Integer codigoCatalogoValorTipoPadre, Integer codigoValorTipoRelacionado) throws SICException;
	
	/**
	 * Activa o desactiva el escaneo manual
	 * @param codigoCompania
	 * @param activarEscaneoManual
	 * @param secuencialRecepcionProveedor
	 * @throws SICException
	 */
	void administrarIngresoManual(Integer codigoCompania, Boolean activarEscaneoManual, Long secuencialRecepcionProveedor) throws SICException;
	
	/**
	 * Consulta el estado del ingreso manual en la recepcion
	 * @param recepcion
	 * @return
	 * @throws SICException
	 */
	Boolean consultarEstadoIngresoManual(Integer codigoCompania, Long secuencialRecepcionProveedor) throws SICException;
	
	/**
	 * Consulta el nombre del tipo de recepcion a partir del codigo
	 * @param codigoCatalogoValorTipoRecepcion
	 * @return
	 * @throws SICException
	 */
	String consultarNombreTipoRecepcionPorCodigoTipo(String codigoCatalogoValorTipoRecepcion) throws SICException;
}