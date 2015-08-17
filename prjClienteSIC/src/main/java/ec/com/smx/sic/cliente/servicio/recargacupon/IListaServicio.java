/*
 * Creado el 2013-03-14
 */
package ec.com.smx.sic.cliente.servicio.recargacupon;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.LocalDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.DetalleListaRecetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ListaRecetaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.HistorialDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecetasPopularesDTO;
import ec.com.smx.sic.cliente.mdl.vo.AsistenteCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.ClienteCuponCompartidoVO;


/** 
 * Interfaz que expone los servicios de cupones
 * @author cgalarza
 */
public interface IListaServicio{

	/**
	 * Obtiene la lista de compras del cliente registrado.
	 * @param clienteDTO
	 * @return the SearchResultDTO<CuponDTO>
	 * @throws SICException
	 */
	public void transRegistrarLista(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * Permite la creacion y modificacion de items en listas de compras.
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public void transRegistrarDetalleLista(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * Obtiene detalles de lista creados o modificados a partir de la fecha de ultima actualizacion.
	 * @param fechaUltimaActualizacion
	 * @return Collection<DetalleListaDTO>
	 */
	public AsistenteCompraVO findDetalleListaModificados(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * Obtiene la clasificacion mediante el codigo de clasificacion (Categoria).
	 * @param codigoCompania
	 * @param codigoClasificacion
	 * @return ClasificacionDTO
	 * @throws SICException
	 */
	public ClasificacionDTO findClasificacion(Integer codigoCompania, String codigoClasificacion) throws SICException;

	/**
	 * Obtiene listas sugeridas o recetas dependiendo del tipo de lista proporcionado,
	 * @param tipoLista
	 * @param fechaUltimaActualizacion
	 * @return
	 * @throws SICException
	 */
	public Collection<ListaRecetaDTO> findListasSugeridas(String lista, Timestamp fechaUltimaActualizacion) throws SICException;

	/**
	 * Permite compartir listas entre usuarios manteniendo la sincronizaci�n o creando una copia de la lista
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public AsistenteCompraVO transProcesoCompartirListasEntreUsuariosWS(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * Obtiene listas dependiendo del codigoClientePedido y de la fechaUltimaActualizacion enviados en el asistenteComprasVO
	 * @param asistenteCompraVO
	 * @return asistenteCompraVO
	 * @throws SICException
	 */
	public AsistenteCompraVO findListasCliente(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * M�todo por el cu�l se notifica aquellos cupones que se han compartido por las redes sociales.
	 * @param clienteCuponCompartidoVO
	 * @throws SICException
	 */
	public void transRegistrarCuponesCompartidos(ClienteCuponCompartidoVO clienteCuponCompartidoVO)throws SICException;

	/**
	 * Obtiene los cupones m�s populares 
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO transTopCupones()throws SICException;
	/**
	 * Busca el historial de descuento de un cliente a partir de una fecha
	 * @param codigoPersona
	 * @param fechaDesde
	 * @return
	 * @throws SICException
	 */
	public HistorialDescuentoDTO obtenerClienteDescuento(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * Obtiene la informaci�n de locales a partir de la fechaUltimaActualizacion
	 * @param asistenteCompraVO
	 * @return
	 * @throws SICException
	 */
	public Collection<LocalDTO> findInformacionLocales(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * Otiene la cantidad de ingredientes de acuerdo al n�mero de porciones enviado
	 * @param asistenteCompraVO
	 * @return asistenteCompraVO
	 * @throws SICException
	 */
	public AsistenteCompraVO findCantidadReceta(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * Metodo que permite crear una lista en base al codigo de receta proporcionado.
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public void transCrearListaBaseReceta(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * Obtiene recetas dependiendo del codigoClientePedido y de la fechaUltimaActualizacion enviados en el asistenteComprasVO
	 * @param asistenteCompraVO
	 * @return asistenteCompraVO
	 * @throws SICException
	 */
	public AsistenteCompraVO findRecetaCliente(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * Obtiene detalles de las recetas creados o modificados a partir de la fecha de ultima actualizacion.
	 * @param asistenteCompraVO
	 * @return asistenteCompraVO
	 * @throws SICException
	 */
	public AsistenteCompraVO findDetalleRecetaModificados(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * M�todo que consume un servicio de sistar para devolver los cupos disponibles en la tarjeta de un afiliado
	 * @param asistenteCompraVO
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO consultarCuposWS(AsistenteCompraVO asistenteCompraVO)throws SICException;
	/**
	 * M�todo que consume un servicio de sistar para devolver el nombre del cliente al que pertenece el numero de tarjeta ingresado
	 * @param asistenteCompraVO
	 */
	public AsistenteCompraVO obtenerClientePorNumeroTarjeta(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * M�todo que obtiene los cupones del cliente
	 * @param asistenteCompraVO
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO obtenerCuponesCliente(AsistenteCompraVO asistenteCompraVO)throws SICException;


	/**
	 * M�todo para notificar si un cliente acept� o no una lista que le hayan compartido
	 * @param asistenteCompraVO
	 * @return
	 * @throws SICException
	 */
	public void transNotificarRecepcionListasCompartidasWS(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * M�todo para notificar que el cliente acaba de marcar/desmarcar una receta como favorita
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public void transNotificarRecetaFavoritaWS(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * M�todo para consultar las recetas que el cliente que ha marcado anteriormente como favoritas
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public AsistenteCompraVO transConsutarRecetasFavoritasWS(AsistenteCompraVO asistenteCompraVO)throws SICException;


	/**
	 * M�todo que obtiene las recetas  
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public SearchResultDTO<ListaRecetaDTO> obtenerListaRecetas(ListaRecetaDTO listaRecetaDTO)throws SICException;

	/**
	 * M�todo que obtiene los items de la receta
	 * @param codigoListaReceta
	 * @param estado 		de los items de la receta	1 = Activo ; 0 = Inactivo
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleListaRecetaDTO> obtenerDetalleListaReceta(Long codigoListaReceta,String estado)throws SICException;
	/**
	 * M�todo que obtiene tipos de receta
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> obtenerCatalogoValor(Integer codigoCatalogoTipo)throws SICException;

	/**
	 * M�todo que registra o actualiza una receta y su detalle
	 * @param listaRecetaDTO
	 * @throws SICException
	 */
	public void transRegistrarReceta(ListaRecetaDTO listaRecetaDTO)throws SICException;

	/**
	 * 
	 * @param numeroDocumento
	 * @param sysId
	 * @return
	 * @throws SICException
	 */
	public PersonaDTO obtenerDispositivosByUser(String numeroDocumento,String sysId)throws SICException;

	/**
	 * Busca las recetas mas populares 
	 * @param codigoReceta
	 * @param cantidad
	 * @return
	 * @throws SICException
	 */
	public Collection<RecetasPopularesDTO> obtenerRecetasPopulares()throws SICException;

	/**
	 * Metodo que obtiene el propietario de la lista a partir del codigoClienteRelacionado
	 * @param codigoClienteRelacionado
	 * @return
	 * @throws SICException
	 */
	public PersonaDTO obtenerPropietarioLista(Long codigoClienteRelacionado)throws SICException;


	/**
	 * Metodo que permite crear una lista en base al codigo de receta proporcionado.
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public ListaRecetaDTO findBaseReceta(AsistenteCompraVO asistenteCompraVO)throws SICException;


	/**
	 * M�todo que registra recetas
	 * @param listaRecetaDTO
	 * @throws SICException
	 */
	public void transRegistrarRecetas(Collection<ListaRecetaDTO> listaRecetaDTO)throws SICException;


	/**
	 * Metodo que verifica si existe la receta por el codigo externo = idApp
	 * @param idApp
	 * @return
	 * @throws SICException
	 */
	public Boolean obtenerCodigoExternoReceta(String idApp)throws SICException;

	/**
	 * Obtiene una ListaRecetaDTO
	 * @param listaRecetaDTO
	 * @return
	 * @throws SICException
	 */
	public ListaRecetaDTO findListaReceta(ListaRecetaDTO listaRecetaDTO)throws SICException;
}
