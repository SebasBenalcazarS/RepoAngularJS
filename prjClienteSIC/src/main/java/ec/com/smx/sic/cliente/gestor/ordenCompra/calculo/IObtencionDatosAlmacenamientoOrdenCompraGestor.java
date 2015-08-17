package ec.com.smx.sic.cliente.gestor.ordenCompra.calculo;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.MonedaDTO;
import ec.com.smx.corpv2.dto.ProcesoRelacionAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.integracion.IConsultarDatosArticuloIDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraRecepcionVO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloImportadoVO;
import ec.com.smx.sic.cliente.mdl.vo.PlantillaOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.SumatoriaUnidadManejoOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.ValidacionOrdenCompraEmbarqueVO;

/**
 * 
 * @author amunoz
 *
 */
public interface IObtencionDatosAlmacenamientoOrdenCompraGestor extends Serializable{
	
	/**
	 * 
	 * @param ordenCompraCreacionVO
	 * @throws SICException
	 */
	public void obtenerDatosGeneralesCreacionOrdenCompra(AdminOrdenCompraVO ordenCompraCreacionVO) throws SICException;
	/**
	 * 
	 * @param ordenCompraCreacionVO
	 * @throws SICException
	 */
	public void obtenerPlazoPagoPorSubbodega(AdminOrdenCompraVO ordenCompraCreacionVO) throws SICException;

	/**
	 * 
	 * @param ordenCompraCreacionVO
	 * @throws SICException
	 */
	public void obtenerClasificacionPorCodigo(AdminOrdenCompraVO ordenCompraCreacionVO) throws SICException;
	
	/**
	 * 
	 * @param vistaProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<VistaProveedorDTO> obtenerProveedorFuncionario(VistaProveedorDTO vistaProveedorDTO, String codigoFuncionario) throws SICException;
	
	/**
	 * @param adminOrdenCompraVO
	 * @param consultarPrecodificados 		  : Consulta articulos PRECODIFICADOS
	 * @param suprimirRestriccionesOrdenCompra: Elimina ciertas restricciones de articulos
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoProveedorDTO> obtenerArticulosUnidadManejo(AdminOrdenCompraVO adminOrdenCompraVO, boolean consultarPrecodificados, boolean suprimirRestriccionesOrdenCompra) throws SICException;
	
	/**
	 * @param adminOrdenCompraVO
	 * @param artUniManProDTO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloUnidadManejoProveedorDTO> obtenerArticulosUnidadManejoPaginado(AdminOrdenCompraVO adminOrdenCompraVO, 
			ArticuloUnidadManejoProveedorDTO artUniManProDTO) throws SICException;
	
	/**
	 * @param ordenCompraCreacionVO
	 * @param artUniManProDTO
	 * @param consultarPrecios
	 * @param consultarPrecodificados
	 * @param suprimirRestriccionesOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> obtenerItemsOrdenCompraCreacion(AdminOrdenCompraVO ordenCompraCreacionVO, ArticuloUnidadManejoProveedorDTO artUniManProDTO, boolean consultarPrecios, boolean consultarPrecodificados, boolean suprimirRestriccionesOrdenCompra) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void asignarPropiedadesDinamicas(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoPedido
	 * @param codigoSubbodega
	 * @return
	 * @throws SICException
	 */
	public ProcesoRelacionAreaTrabajoDTO obtenerAreaTrabajoDestinoLocal(AreaTrabajoDTO areaTrabajoPedido, BodegaDTO subbodegaDTO) throws SICException;
	
	/**
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public IConsultarDatosArticuloIDTO consultarDatosArticulosOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, Collection<OrdenCompraDetalleEstadoDTO> detalles) throws SICException;
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void asignarDatosIntegracionOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO,  Collection<OrdenCompraDetalleEstadoDTO> obtenerItemsOrdenCompraCreacionAsistida) throws SICException;
	
	/**
	 * 
	 * @param articuloUnidadManejoProveedorDTO
	 * @param ordenCompraVO
	 * @throws SICException
	 */
	public void agregarRestriccionesArticuloBusqueda(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO, AdminOrdenCompraVO ordenCompraVO) throws SICException;
	
	/**
	 * @param ordenCompraCreacionVO
	 * @param inputStreamArchOrdenCompra
	 * @return LinkedHashMap<String, ArrayList<String>>
	 * @throws SICException
	 */
	public LinkedHashMap<String, List> procesarArchivoCreacionOrdenCompra(AdminOrdenCompraVO ordenCompraCreacionVO, InputStream inputStreamArchOrdenCompra) throws SICException;
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void obtenerDatosProveedorSubbodegaOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;
	
	/**
	 * 
	 * @param configuracion Coleccion con las sumatorias de los pedidos de los cuales se deben generar las ordenes de compra.
	 * @param funcionario Funcionario que genera la orden de compra
	 * @param proveedor Proveedor al cual se le solicitara la orden de compra
	 * @param codigoCompania
	 * @param fechaDespacho
	 * @param fechaCaducidad
	 * @param areaTrabajo Area de trabajo a la cual se le hara la orden de compra.
	 * @param subbodega Subbodega a la cual pertenece la orden de compra.
	 * @param moneda
	 * @return
	 * @throws SICException
	 */
	public AdminOrdenCompraVO obtenerAdminOrdenCompraVO(Collection<SumatoriaUnidadManejoOrdenCompraVO> configuracion, FuncionarioDTO funcionario,
			VistaProveedorDTO proveedor, int codigoCompania, Date fechaDespacho,  Date fechaCaducidad, AreaTrabajoDTO areaTrabajo, BodegaDTO subbodega, MonedaDTO moneda) throws SICException;	
	/**
	 * 
	 * @param plantillaOrdenCompraVO
	 * @param vistaProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public AdminOrdenCompraVO obtenerAdminOrdenCompraVO (PlantillaOrdenCompraVO plantillaOrdenCompraVO, VistaProveedorDTO vistaProveedorDTO) throws SICException;
	
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param datosValidados
	 * @return
	 * @throws SICException
	 */
	public AdminOrdenCompraVO obtenerAdminOrdenCompraVO (AdminOrdenCompraVO adminOrdenCompraVO, List datosValidados) throws SICException;
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param datosArchivoValidado
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloImportadoVO> consultarNovedadesArticulosNuevosPorArchivo(AdminOrdenCompraVO adminOrdenCompraVO, LinkedHashMap<String, List> datosArchivoValidado) throws SICException;
	
	/**
	 * 
	 * @throws SICException
	 */
	public void crearNuevoDetalleArticuloOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * @param ordenCompraCreacionVO
	 * @param embarquesSeleccionados
	 * @return
	 * @throws SICException
	 */
	public Collection<ValidacionOrdenCompraEmbarqueVO> procesarEmbarqueCreacionOrdenCompra(AdminOrdenCompraRecepcionVO ordenCompraRecepcionVO, Collection<EmbarqueEstadoImpDTO> embarquesSeleccionados) throws SICException;
	
	/**
	 * @param vistaProveedorDTO
	 * @param subBodegaDTO
	 * @param areaTrabajoDTO
	 * @param facturaDetalleEstadoImpDTOs
	 * @return
	 * @throws SICException
	 */
	public AdminOrdenCompraVO obtenerAdminOrdenCompraVO (AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO, VistaProveedorDTO vistaProveedorDTO, BodegaDTO subBodegaDTO,
			Integer codigoAreaTrabajo, boolean subbodegaCaracteristicaJuguetes) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarEsNotaPedido(AdminOrdenCompraVO adminOrdenCompraVO, boolean creacionPorArchivo) throws SICException;
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param clasificacionValida flag para validar si la clasificacion enviada corresponde a una estructura valida
	 * @throws SICException
	 */
	public Collection<ArticuloImportadoVO> consultarNovedadesArticulosNuevos(Collection<ArticuloImportadoVO> artImpVoNueCol, boolean clasificacionValida) throws SICException;
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param artImpVoNueCol
	 * @throws SICException
	 */
	
	public void crearDetallesArticulosNuevosOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, Collection<ArticuloDTO> articuloImportadoCreadosCol) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraCreacionVO
	 * @throws SICException
	 */
	public void obtenerPlazoPago(AdminOrdenCompraVO ordenCompraCreacionVO) throws SICException;
	/**
	 * @param ordenCompraVO
	 * @throws SICException
	 */
	public void buscarCostosEdicion(AdminOrdenCompraVO ordenCompraVO) throws SICException;
	/**
	 * @param itemsOrdenCompraAsistida
	 * @throws SICException
	 */
	public void obtenerPrecios(AdminOrdenCompraVO ordenCompraCreacionVO,Collection<OrdenCompraDetalleEstadoDTO> itemsOrdenCompraAsistida) throws SICException;
	/**
	 * @param adminOrdenCompraVO
	 * @param ordenCompraDetalleEstadoCol
	 * @throws SICException
	 */
	public void buscarInformacionEdicionArticulos(AdminOrdenCompraVO adminOrdenCompraVO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol)throws SICException;
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param artUniManUsoCol
	 * @param casoDatos
	 * @param itemsOrdenCompra
	 * @param codArtCol
	 * @param codUniManOrdComDetEstCol
	 * @throws SICException
	 */
	public void obtenerInformacionAdicionalOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO,
													   ArrayList<ArticuloUnidadManejoProveedorDTO>artUniManProCol,
													   Integer casoDatos, 
													   ArrayList<OrdenCompraDetalleEstadoDTO> itemsOrdenCompra, 
													   ArrayList<String> codArtCol,
													   ArrayList<Long> codUniManOrdComDetEstCol) throws SICException;
	
	/**
	 * Crea un articulo importado
	 * @param articuloImportadoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> registrarArticuloImportado(Collection<ArticuloImportadoVO> articuloImportadoCol,
															 VistaProveedorDTO vistaProveedorDTO) throws SICException;
	
	/**
	 * @param ordenCompraDetalleEstadoDTO
	 * @throws SICException
	 */
	public void obtenerDescuentosIniciales(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) throws SICException;

	/**
	 * Metodo para obtener el adminOrdenCompraVO a partir de una
	 * ordenCompraEstadoDTO.
	 * 
	 * @param ordenCompraEstado
	 * @param codigoCompania
	 * @param userId
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	public AdminOrdenCompraVO obtenerAdminOrdenCompraVO(OrdenCompraEstadoDTO ordenCompraEstado, Integer codigoCompania, String userId, FuncionarioDTO codigoFuncionario) throws SICException;

	public BodegaDTO buscarBodegaParaOrdenCompra(Integer codigoCompania, String codigoBodega);

	public AreaTrabajoDTO buscarAreaTrabajoParaOrdenCompra(Integer codigoCompania, String codigoAreaTrabajo);

	public FuncionarioDTO buscarFuncionarioParaOrdenCompra(Integer codigoCompania, String userId);

	/**
	 * Obtiene las LineaComercialClienteImportacion dada una lista de codigos de lineas comerciales.
	 * @param lineas Codigos de lineas comerciales.
	 * @return Listado de LineaComercialClienteImportacionDTO.
	 */
	public Collection<LineaComercialClienteImportacionDTO> obtenerLineaComercialCliente(Collection<Long> codigoLineaComercial);
	
	/**
	 * Obtiene las LineaComercialClasificacion dada una lista de codigos de lineas comerciales.
	 * @param lineas Codigos de lineas comerciales.
	 * @return Listado de LineaComercialClasificacionDTO.
	 */
	public Collection<LineaComercialClasificacionDTO> obtenerLineaComercialClasificacionPorLineaComercial(Collection<Long> lineas,String codigoSub);
	
	/**
	 * @param codigoCompania
	 * @param codigoParametro
	 * @return
	 * @throws SICException
	 */
	public ParametroDTO obtenerParametroOrdeCompra(Integer codigoCompania, String codigoParametro) throws SICException;
	
	
	/**
	 * Obtiene el plazo de pago apartir de un valor entero
	 * @param ordenCompraCreacionVO
	 * @param plazoPago
	 * @throws SICException
	 */
	public void obtenerPlazoPagoAPartirDeValorEntero(AdminOrdenCompraVO ordenCompraCreacionVO, Integer plazoPago) throws SICException;
	
	/**
	 * Busca los códigos de barras de cada artículo en una orden de compra
	 * @param codigoCompania
	 * @param numeroOrdenCompra
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	public Collection<String> obtenerCodigoBarrasEtiquetado(Integer codigoCompania,String numeroOrdenCompra, String codigoFuncionario) throws SICException;

}
