package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;


public interface IValidacionRecepcionProveedorGestor {

	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @param andenes
	 * @param listaEntregas
	 * @throws SICException
	 */
	public abstract void validarIniciarRecepcionProveedor(RecepcionProveedorDTO recepcionProveedorDTO, Collection<DetalleSeccionDTO> andenes, Collection<EntregaDTO> listaEntregas) throws SICException;
	
	/**
	 * 
	 * @param codigoCatalogoTipo
	 * @throws SICException
	 */
	public abstract void validarObtenerCategoriasDetalleSeccion(Integer codigoCatalogoTipo) throws SICException;
	
	/**
	 * 
	 * @param catalogo
	 * @param codigosAreaTrabajoEntregas
	 * @throws SICException
	 */
	public abstract void validarObtenerAndenPorCategoria(CatalogoValorDTO catalogo, Collection<Integer> codigosAreaTrabajoEntregas) throws SICException;
	
	/**
	 * 
	 * @param entregasDTO
	 */
	public abstract void validarObtenerFacturasProveedor(Collection<EntregaDTO> entregasDTO);

	/**
	 * 
	 * @param listaRecepcion
	 * @param facturaEstadoDTO
	 */
	public abstract void validarFacturasPorCodBarras(Collection<RecepcionProveedorDTO> listaRecepcion, FacturaEstadoDTO facturaEstadoDTO);

	/**
	 * 
	 * @param facturaEstadoDTO
	 */
	public abstract void validarRegistroFacturas(FacturaEstadoDTO facturaEstadoDTO);
	
	/**
	 * @param facturaEstadoDTO
	 */
	public abstract void validarRegistroFacturasElectronicas(FacturaEstadoDTO facturaEstadoDTO);
	
	/**
	 * 
	 * @param facturaEstadoDTOs
	 * @param entregaDTO
	 */
	public abstract void validarRegistroFacturas(Collection<FacturaEstadoDTO> facturaEstadoDTOs, EntregaDTO entregaDTO);
	
	/**
	 * Valida los datos que se necesitan para registrar un furgon de un proveedor
	 * 
	 * @param recepcionProveedorVO
	 * @throws SICException
	 */
	public abstract void validarRegistrarFurgonProveedorRecepcion(RecepcionProveedorVO recepcionProveedorVO) throws SICException;

	/**
	 * Valida los datos para obtener la informacion del articulo unidad de manejo en una recepcion
	 * 
	 * @param recepcionProveedorDTO
	 * @param codigoBarrasArticulo
	 * @param codigoBarrasCaja
	 * @throws SICException
	 */
	public void obtenerDatosArticuloUnidadManejo(RecepcionProveedorDTO recepcionProveedorDTO, String codigoBarrasArticulo, String codigoBarrasCaja) throws SICException;

	/**
	 * Validar que existan los datos necesarios para registrar la recepci&oacute;n de perecibles
	 * @param recepcionProveedorDTO
	 * @param listaEntregas
	 * @throws SICException
	 */
	void validarIniciarRecepcionPerecibles(RecepcionProveedorDTO recepcionProveedorDTO, Collection<EntregaDTO> listaEntregas) throws SICException;

	/**
	 * Validar los campos requeridos para registrar un articulo recibido por tipo control costos
	 * @param tipoControlCostos
	 * @param listaJabasRecibidas
	 * @throws SICException
	 */
	public void recibirArticuloPorTipoControlCostos(String tipoControlCostos, Collection<ControlRecipienteTaraDetalleDTO> listaJabasRecibidas) throws SICException;

	/**
	 * Validar campos requeridos para crear la cabecera de la recepcion
	 * @param plantillaRecepcion
	 * @throws SICException
	 */
	void validarCrearCabecerarecepcion(RecepcionProveedorDTO plantillaRecepcion) throws SICException;

	/**
	 * Validar campos requeridos para buscar una recepcion configurada por proveedor
	 * @param plantillaRecepcion
	 * @throws SICException
	 */
	void validarCamposObtenerRecepcionesProveedor(RecepcionProveedorDTO plantillaRecepcion) throws SICException;

}