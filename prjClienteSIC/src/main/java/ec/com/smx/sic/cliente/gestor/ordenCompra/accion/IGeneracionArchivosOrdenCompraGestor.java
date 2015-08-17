package ec.com.smx.sic.cliente.gestor.ordenCompra.accion;

import java.io.File;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraEstadoID;

/**
 * @author aguato
 *
 */
public interface IGeneracionArchivosOrdenCompraGestor {

	/**
	 * Metodo que genera los archivos correspondientes de la orden de compra
	 * @param ordenCompraEstadoDTO
	 * @param url
	 * @param archivosPlanos
	 * @param archivoNotaPedido
	 * @param archivoReporte
	 	 * @throws SICException
	 */
	@Deprecated
	public void generarArchivosOrdenCompra(PedidoDTO pedidoDTO, String url, boolean archivosPlanos, boolean archivoReporte,boolean archivoNotaPedido) throws SICException;
	

	/**
	 * 
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public String generarArchivoTxtOrdenCompra(PedidoDTO pedidoDTO) throws SICException;
	
	/**
	 * Generar reporte de orden de compra en proceso Batch
	 * 
	 * @param pedidoDTO
	 * @param mensajeReporteSubbodega
	 * @return
	 * @throws SICException
	 */
	public String generarArchivoTxtOrdenCompraBatch(PedidoDTO pedidoDTO,String mensajeReporteSubbodega) throws SICException;
	
	/**
	 * 
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public String generarArchivoExcelOrdenCompra(PedidoDTO pedidoDTO) throws SICException;
	
	/**
	 * 
	 * @param pedidoDTO
	 * @param archivosPlanos
	 * @throws SICException
	 */
	public void guardarPedidoArchivoInformacion(PedidoDTO pedidoDTO, boolean archivosPlanos) throws SICException;
	
	/**
	 * @param pedidoDTO
	 * @param url
	 * @param mensajeReporteSubbodega
	 * @param planContingenicaB2B
	 * @param archivoPlano
	 * @return
	 * @throws SICException
	 */
	public byte[] generarDatosReporteOrdenCompra(PedidoDTO pedidoDTO, String url, String mensajeReporteSubbodega, Boolean planContingenicaB2B, Boolean archivoPlano) throws SICException;

	/**
	 * 
	 * @param pedidoDTO
	 * @param url
	 * @return
	 * @throws SICException
	 */
	public byte[] generarDatosReporteNotaPedido(PedidoDTO pedidoDTO, String url)throws SICException;
	
	/**
	 * @param file
	 * @return byte[]
	 */
	public byte[] cargarArchivo(File file);

	/**
	 * 
	 * @param ordenCompraEstadoID
	 * @param url
	 * @return
	 * @throws SICException
	 */
	public byte[] generarDatosReporteOrdenesCompra(Collection<OrdenCompraEstadoID> ordenCompraEstadoID, String url,	Boolean planContingenicaB2B) throws SICException;

}
