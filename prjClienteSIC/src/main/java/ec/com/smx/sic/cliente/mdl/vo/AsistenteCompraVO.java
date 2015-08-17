package ec.com.smx.sic.cliente.mdl.vo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.frameworkv2.security.dto.UserDeviceDto;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClienteArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaClienteArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.BinTarjetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.DetalleListaDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ListaDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ListaRecetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.RecetaClientePedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;

/**
 * 
 * @author fvallejo
 *
 */
public class AsistenteCompraVO {
	
	/**
	 * C�dula o pasaporte del cliente
	 */
	private String numeroDocumento;	
	/**
	 * N�mero de tarjeta del cliente.
	 */
	private String numeroTarjeta;
	/**
	 *  Fecha de la �ltima actualizaci�n. NULL si es que nunca ha sido actualizada.
	 */
	private Timestamp fechaUltimaActualizacion;
	
	private Collection<VistaClienteArticuloDTO> misCupones;
	private Collection<ClienteArticuloDTO> misCuponesKiosko;
	private Collection<ArticuloDTO> cupones;
	private Collection<ArticuloDTO> cuponesRecomendados;
	private Collection<ArticuloDTO> cuponesRecomendadosMejorAhorro;
	private Collection<ArticuloDTO> cuponesPopulares;
	private Collection<ParametroDTO> parametros;
	private Collection<ClasificacionDTO> categorias;
	private Collection<ParametroDTO> tiposNotificaciones;
	private Collection<RecetaClientePedidoDTO> recetaClientePedidoCol;
	private Collection<BinTarjetaDTO> binTarjetaDTOs;
	
	private FuncionarioDTO funcionarioDTO;
	private String jsonEntrada;
	private String jsonRespuesta;
	private Double valorDescuento;
	private Double valorTotalConsumo;
	private Long fechaInicial;
	
	//Boolean que indica si se debe consultar el objeto UserDeviceDTO
	private boolean realizaConsulta;
	//Objeto UserDeviceDTO consultado. Si la bandera realizaConsulta es true se consulta
	private UserDeviceDto userDeviceDto;
	
	private Long codigoClientePedido;
	private Collection<DetalleListaDTO> itemsInsertCol;
	private Collection<DetalleListaDTO> itemsUpdateCol;
	private Collection<DetalleListaDTO> itemsDeleteCol;
	private Collection<DetalleListaDTO> misItems;
	private Collection<Long> codigosListasPush;
	private Collection<String> numerosDocumentosPush;
	
	private String destinatario;
	private Long idLista;
	private Boolean destinatarioEsCorreo;
	private ClienteDTO clienteDTO;
	private Boolean mantenerColaboracion;
	
	private Collection<ListaDTO> listasInsertCol;
	private Collection<ListaDTO> listasUpdateCol;
	private Collection<ListaDTO> listasDeleteCol;
	private Collection<ListaDTO> misListas;
	private Collection<ListaDTO> misRecetas;
	private Collection<DetalleListaDTO> itemsMisRecetas;
	private String email;
	private HashMap<String, String> topCodigoBarras;
	
	private String idReceta;
	private Integer numeroPorciones;
	private ListaRecetaDTO listaRecetaDTO;
	private String nombreCliente;
	
	private Integer  codigoLocal;
	
	private Boolean aceptaLista;
	private Integer numeroPersonas;
	private Character accion;
	
	private String nombreUsuario;
	private Map<String, String> mapNumeroDocumento;
	
	private Collection<String> destinatariosCompartir;
	
	private Integer estado;
	
	private Collection<String> tarjetasCliente;
	
	private Integer codigoError;
	
	private String mensajeError;
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Collection<String> getTarjetasCliente() {
		return tarjetasCliente;
	}

	public void setTarjetasCliente(Collection<String> tarjetasCliente) {
		this.tarjetasCliente = tarjetasCliente;
	}

	public Integer getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	/**
	 * @return the fechaUltimaActualizacion
	 */
	public Timestamp getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}
	
	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(Long fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = new Timestamp(fechaUltimaActualizacion);
	}

	/**
	 * @return the misCupones
	 */
	public Collection<VistaClienteArticuloDTO> getMisCupones() {
		return misCupones;
	}

	/**
	 * @param misCupones the misCupones to set
	 */
	public void setMisCupones(Collection<VistaClienteArticuloDTO> misCupones) {
		this.misCupones = misCupones;
	}

	/**
	 * @return the cupones
	 */
	public Collection<ArticuloDTO> getCupones() {
		return cupones;
	}

	/**
	 * @param cupones the cupones to set
	 */
	public void setCupones(Collection<ArticuloDTO> cupones) {
		this.cupones = cupones;
	}
	
	
	/**
	 * 
	 * @return the cuponesRecomendados
	 */
	public Collection<ArticuloDTO> getCuponesRecomendados() {
		return cuponesRecomendados;
	}

	/**
	 * 
	 * @param cuponesRecomendados the cuponesRecomendados to set
	 */
	public void setCuponesRecomendados(Collection<ArticuloDTO> cuponesRecomendados) {
		this.cuponesRecomendados = cuponesRecomendados;
	}

	/**
	 * @return the parametros
	 */
	public Collection<ParametroDTO> getParametros() {
		return parametros;
	}

	/**
	 * @param parametros the parametros to set
	 */
	public void setParametros(Collection<ParametroDTO> parametros) {
		this.parametros = parametros;
	}
	
	/**
	 * @return the categorias
	 */
	public Collection<ClasificacionDTO> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(Collection<ClasificacionDTO> categorias) {
		this.categorias = categorias;
	}

	/**
	 * 
	 * @return the funcionarioDTO
	 */
	public FuncionarioDTO getFuncionarioDTO() {
		return funcionarioDTO;
	}

	/**
	 * 
	 * @param funcionarioDTO the funcionarioDTO to set
	 */
	public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
		this.funcionarioDTO = funcionarioDTO;
	}

	/**
	 * 
	 * @return the numeroTarjeta
	 */
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
	 * 
	 * @param numeroTarjeta the numeroTarjeta to set
	 */
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	
	/**
	 * @return the jsonEntrada
	 */
	public String getJsonEntrada() {
		return jsonEntrada;
	}

	/**
	 * 
	 * @param jsonEntrada the jsonEntrada to set
	 */
	public void setJsonEntrada(String jsonEntrada) {
		this.jsonEntrada = jsonEntrada;
	}

	/**
	 * 
	 * @return the jsonRespuesta
	 */
	public String getJsonRespuesta() {
		return jsonRespuesta;
	}

	/**
	 * 
	 * @param jsonRespuesta the jsonRespuesta to set
	 */
	public void setJsonRespuesta(String jsonRespuesta) {
		this.jsonRespuesta = jsonRespuesta;
	}

	/**
	 * @return the realizaConsulta
	 */
	public boolean getRealizaConsulta() {
		return realizaConsulta;
	}

	/**
	 * @param realizaConsulta the realizaConsulta to set
	 */
	public void setRealizaConsulta(boolean realizaConsulta) {
		this.realizaConsulta = realizaConsulta;
	}

	/**
	 * @return the userDeviceDto
	 */
	public UserDeviceDto getUserDeviceDto() {
		return userDeviceDto;
	}

	/**
	 * @param userDeviceDto the userDeviceDto to set
	 */
	public void setUserDeviceDto(UserDeviceDto userDeviceDto) {
		this.userDeviceDto = userDeviceDto;
	}

	public Double getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	/**
	 * 
	 * @return the cuponesRecomendadosMejorAhorro
	 */
	public Collection<ArticuloDTO> getCuponesRecomendadosMejorAhorro() {
		return cuponesRecomendadosMejorAhorro;
	}

	/**
	 * 
	 * @param cuponesRecomendadosMejorAhorro the cuponesRecomendadosMejorAhorro to set
	 */
	public void setCuponesRecomendadosMejorAhorro(Collection<ArticuloDTO> cuponesRecomendadosMejorAhorro) {
		this.cuponesRecomendadosMejorAhorro = cuponesRecomendadosMejorAhorro;
	}

	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

	/**
	 * 
	 * @return the itemsInsertCol
	 */
	public Collection<DetalleListaDTO> getItemsInsertCol() {
		return itemsInsertCol;
	}

	/**
	 * 
	 * @param itemsInsertCol the itemsInsertCol to set
	 */
	public void setItemsInsertCol(Collection<DetalleListaDTO> itemsInsertCol) {
		this.itemsInsertCol = itemsInsertCol;
	}

	/**
	 * 
	 * @return the itemsUpdateCol
	 */
	public Collection<DetalleListaDTO> getItemsUpdateCol() {
		return itemsUpdateCol;
	}

	/**
	 * 
	 * @param itemsUpdateCol the itemsUpdateCol to set
	 */
	public void setItemsUpdateCol(Collection<DetalleListaDTO> itemsUpdateCol) {
		this.itemsUpdateCol = itemsUpdateCol;
	}

	/**
	 * 
	 * @return the itemsDeleteCol
	 */
	public Collection<DetalleListaDTO> getItemsDeleteCol() {
		return itemsDeleteCol;
	}

	/**
	 * 
	 * @param itemsDeleteCol the itemsDeleteCol to set
	 */
	public void setItemsDeleteCol(Collection<DetalleListaDTO> itemsDeleteCol) {
		this.itemsDeleteCol = itemsDeleteCol;
	}

	/**
	 * 
	 * @return the misItems
	 */
	public Collection<DetalleListaDTO> getMisItems() {
		return misItems;
	}

	/**
	 * 
	 * @param misItems the misItems to set
	 */
	public void setMisItems(Collection<DetalleListaDTO> misItems) {
		this.misItems = misItems;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public Long getIdLista() {
		return idLista;
	}

	public void setIdLista(Long idLista) {
		this.idLista = idLista;
	}

	public Boolean getDestinatarioEsCorreo() {
		return destinatarioEsCorreo;
	}

	public void setDestinatarioEsCorreo(Boolean destinatarioEsCorreo) {
		this.destinatarioEsCorreo = destinatarioEsCorreo;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	/**
	 * @return the listasInsertCol
	 */
	public Collection<ListaDTO> getListasInsertCol() {
		return listasInsertCol;
	}

	/**
	 * @param listasInsertCol the listasInsertCol to set
	 */
	public void setListasInsertCol(Collection<ListaDTO> listasInsertCol) {
		this.listasInsertCol = listasInsertCol;
	}

	/**
	 * @return the listasUpdateCol
	 */
	public Collection<ListaDTO> getListasUpdateCol() {
		return listasUpdateCol;
	}

	/**
	 * @param listasUpdateCol the listasUpdateCol to set
	 */
	public void setListasUpdateCol(Collection<ListaDTO> listasUpdateCol) {
		this.listasUpdateCol = listasUpdateCol;
	}

	/**
	 * @return the listasDeleteCol
	 */
	public Collection<ListaDTO> getListasDeleteCol() {
		return listasDeleteCol;
	}

	/**
	 * @param listasDeleteCol the listasDeleteCol to set
	 */
	public void setListasDeleteCol(Collection<ListaDTO> listasDeleteCol) {
		this.listasDeleteCol = listasDeleteCol;
	}

	/**
	 * @return the misListas
	 */
	public Collection<ListaDTO> getMisListas() {
		return misListas;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param misListas the misListas to set
	 */
	public void setMisListas(Collection<ListaDTO> misListas) {
		this.misListas = misListas;
	}

	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Boolean getMantenerColaboracion() {
		return mantenerColaboracion;
	}

	public void setMantenerColaboracion(Boolean mantenerColaboracion) {
		this.mantenerColaboracion = mantenerColaboracion;
	}

	/**
	 * @return the fechaInicial
	 */
	public Long getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Long fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the valorTotal
	 */
	public Double getValorTotalConsumo() {
		return valorTotalConsumo;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotalConsumo(Double valorTotalConsumo) {
		this.valorTotalConsumo = valorTotalConsumo;
	}

	/**
	 * @return the topCodigoBarras
	 */
	public HashMap<String, String> getTopCodigoBarras() {
		return topCodigoBarras;
	}

	/**
	 * @param topCodigoBarras the topCodigoBarras to set
	 */
	public void setTopCodigoBarras(HashMap<String, String> topCodigoBarras) {
		this.topCodigoBarras = topCodigoBarras;
	}

	public Collection<ListaDTO> getMisRecetas() {
		return misRecetas;
	}

	public void setMisRecetas(Collection<ListaDTO> misRecetas) {
		this.misRecetas = misRecetas;
	}

	public Collection<DetalleListaDTO> getItemsMisRecetas() {
		return itemsMisRecetas;
	}

	public void setItemsMisRecetas(Collection<DetalleListaDTO> itemsMisRecetas) {
		this.itemsMisRecetas = itemsMisRecetas;
	}

	/**
	 * @return the idReceta
	 */
	public String getIdReceta() {
		return idReceta;
	}

	/**
	 * @param idReceta the idReceta to set
	 */
	public void setIdReceta(String idReceta) {
		this.idReceta = idReceta;
	}

	/**
	 * @return the numeroPorciones
	 */
	public Integer getNumeroPorciones() {
		return numeroPorciones;
	}

	/**
	 * @param numeroPorciones the numeroPorciones to set
	 */
	public void setNumeroPorciones(Integer numeroPorciones) {
		this.numeroPorciones = numeroPorciones;
	}

	/**
	 * @return the listaRecetaDTO
	 */
	public ListaRecetaDTO getListaRecetaDTO() {
		return listaRecetaDTO;
	}

	/**
	 * @param listaRecetaDTO the listaRecetaDTO to set
	 */
	public void setListaRecetaDTO(ListaRecetaDTO listaRecetaDTO) {
		this.listaRecetaDTO = listaRecetaDTO;
	}

	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Boolean getAceptaLista() {
		return aceptaLista;
	}

	public void setAceptaLista(Boolean aceptaLista) {
		this.aceptaLista = aceptaLista;
	}

	/**
	 * @return the misCuponesKiosko
	 */
	public Collection<ClienteArticuloDTO> getMisCuponesKiosko() {
		return misCuponesKiosko;
	}

	/**
	 * @param misCuponesKiosko the misCuponesKiosko to set
	 */
	public void setMisCuponesKiosko(Collection<ClienteArticuloDTO> misCuponesKiosko) {
		this.misCuponesKiosko = misCuponesKiosko;
	}

	/**
	 * @return the numeroPersonas
	 */
	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}

	/**
	 * @param numeroPersonas the numeroPersonas to set
	 */
	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	/**
	 * @return the accion
	 */
	public Character getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(Character accion) {
		this.accion = accion;
	}

	/**
	 * @return the recetaClientePedidoCol
	 */
	public Collection<RecetaClientePedidoDTO> getRecetaClientePedidoCol() {
		return recetaClientePedidoCol;
	}

	/**
	 * @param recetaClientePedidoCol the recetaClientePedidoCol to set
	 */
	public void setRecetaClientePedidoCol(Collection<RecetaClientePedidoDTO> recetaClientePedidoCol) {
		this.recetaClientePedidoCol = recetaClientePedidoCol;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the mapNumeroDocumento
	 */
	public Map<String, String> getMapNumeroDocumento() {
		return mapNumeroDocumento;
	}

	/**
	 * @param mapNumeroDocumento the mapNumeroDocumento to set
	 */
	public void setMapNumeroDocumento(Map<String, String> mapNumeroDocumento) {
		this.mapNumeroDocumento = mapNumeroDocumento;
	}

	public Collection<ParametroDTO> getTiposNotificaciones() {
		return tiposNotificaciones;
	}

	public void setTiposNotificaciones(Collection<ParametroDTO> tiposNotificaciones) {
		this.tiposNotificaciones = tiposNotificaciones;
	}

	public Collection<String> getDestinatariosCompartir() {
		return destinatariosCompartir;
	}

	public void setDestinatariosCompartir(Collection<String> destinatariosCompartir) {
		this.destinatariosCompartir = destinatariosCompartir;
	}

	/**
	 * @return the cuponesPopulares
	 */
	public Collection<ArticuloDTO> getCuponesPopulares() {
		return cuponesPopulares;
	}

	/**
	 * @param cuponesPopulares the cuponesPopulares to set
	 */
	public void setCuponesPopulares(Collection<ArticuloDTO> cuponesPopulares) {
		this.cuponesPopulares = cuponesPopulares;
	}

	public Collection<Long> getCodigosListasPush() {
		return codigosListasPush;
	}

	public void setCodigosListasPush(Collection<Long> codigosListasPush) {
		this.codigosListasPush = codigosListasPush;
	}

	public Collection<String> getNumerosDocumentosPush() {
		return numerosDocumentosPush;
	}

	public void setNumerosDocumentosPush(Collection<String> numerosDocumentosPush) {
		this.numerosDocumentosPush = numerosDocumentosPush;
	}

	public Collection<BinTarjetaDTO> getBinTarjetaDTOs() {
		return binTarjetaDTOs;
	}

	public void setBinTarjetaDTOs(Collection<BinTarjetaDTO> binTarjetaDTOs) {
		this.binTarjetaDTOs = binTarjetaDTOs;
	}

}
