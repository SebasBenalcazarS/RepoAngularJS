/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.ManejoFechas;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.mensajeria.commons.resources.MensajeriaMessages;
import ec.com.smx.mensajeria.commons.util.ConstantesSMS;
import ec.com.smx.mensajeria.dto.EventoDTO;
import ec.com.smx.mensajeria.dto.id.EventoID;
import ec.com.smx.mensajeria.estructura.MailMensajeEST;
import ec.com.smx.mensajeria.gestor.MensajeriaG;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.articulo.CaracteristicaDinamicaUtil;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.common.articulo.EnumCreacionPorArchivoCabecera;
import ec.com.smx.sic.cliente.common.articulo.EnumSubProcesoGuardadoArticulo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.proveedor.TipoCatalogosProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloCreacionPorArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.precios.IValidacionArticuloReglasComercialesGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDuracionConservacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloTemporadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloCreacionPorArchivoDAO;

/**
 * @author eharo
 *
 */

public class ArticuloCreacionPorArchivoGestor implements IArticuloCreacionPorArchivoGestor, Logeable{

	private IArticuloGestor articuloGestor;
	private IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO;
	private IValidacionArticuloReglasComercialesGestor validacionReglasComerciales;
	private DataGestor dataGestor;
	private MensajeriaG mensajeriaG;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void realizarCreacionArticuloPorArchivo(ArticuloVO articuloVOPlantillaValores, Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos, String nombreArchivo) throws SICException {
		ArticuloVO articuloVO = null;
		Set<MultiKey> keys = null;
		Set<Integer> keyListas = null;
		Collection<Integer> keyLista = null;
		Set<Integer> keyListaNoValidos = null;
		Set<Integer> keyListaValidos = null;
		LinkedHashMap objectListCarDin [] = null;
		String fechaCreacion = ManejoFechas.convertDateAsString("yyyy-MM-dd HH:mm:ss", new Date());
		try{
			if(MapUtils.isNotEmpty(datosValidos.getSecondObject())){
				LOG_SICV2.info("==> Inicio Registro Articulo Por Archivo");
				keys = new HashSet<MultiKey>();
				keyListas = new HashSet<Integer>();
				keyLista = new ArrayList<Integer>();
				keyListaNoValidos = new HashSet<Integer>();
				keyListaValidos = new HashSet<Integer>();
				keys = datosValidos.getSecondObject().keySet();
				objectListCarDin = new LinkedHashMap[1];
				for(MultiKey key : keys){
					keyListas.add((Integer) key.getKey(0));
				}
				for(Integer valor: keyListas){
					keyLista.add(valor);
				}
				keyLista = ColeccionesUtil.sort(keyListas, ColeccionesUtil.ORDEN_ASC);
				for(Integer key : keyLista){
					try{
						LOG_SICV2.info("Numero de articulos: "+key);
						articuloVO = SICFactory.getInstancia().articulo.getArticuloMasivoServicio().obtenerDatosArticuloVO(articuloVOPlantillaValores,key,datosValidos.getSecondObject(), objectListCarDin);
							if(articuloVO != null){
								SICFactory.getInstancia().articulo.getArticuloMasivoServicio().crearArticuloPorArchivo(articuloVO);
							}
							keyListaValidos.add(Integer.valueOf(key.toString()));
					}catch(Exception e){
						LOG_SICV2.error("Error al crear articulo {}", e.getMessage());
						keyListaNoValidos.add(Integer.valueOf(key.toString()));
					}
				}
				LOG_SICV2.info("Numero de articulos con errores: "+keyListaNoValidos.size());
			}
		}catch(SICException e){
			throw e;
		}catch (Exception e) {
			throw new SICException(e.getMessage());
		}finally{
			SICFactory.getInstancia().articulo.getArticuloMasivoServicio().envioMailCreacionArticuloPorArchivo(articuloVOPlantillaValores.getCodigoCompania(), articuloVOPlantillaValores.getBaseDTO().getUserId(), keyListaNoValidos, keyListaValidos.size(), fechaCreacion, nombreArchivo);
			keys = null;
			keyLista = null;
			keyListaNoValidos = null;
			keyListaValidos = null;
			objectListCarDin = null;
		}
	}
	
	@Override
	public void envioMailCreacionArticuloPorArchivo(Integer codigoCompania, String userId, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo)throws SICException{
		//Obtenemos el mail del usuario
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		userDto = dataGestor.findUnique(userDto);
		//Validar el usuario
		if(userDto == null || StringUtils.isBlank(userDto.getUserEmail())){
			throw new SICException("El usuario no posee mail");
		}
		
		EventoID eventoID = new EventoID();
		eventoID.setCodigoEvento(SICConstantes.CODIGO_EVENTOID_MAIL_CREACION_ARTICULOS_POR_ARCHIVO);
		eventoID.setSystemId(SICConstantes.CODIGO_SISTEMA_MAX);
		eventoID.setCompanyId(codigoCompania);		
		enviarMail(eventoID, new String[]{userDto.getUserEmail()},userDto.getUserCompleteName(),null, "Creaci\u00F3n de art\u00EDculos por archivo excel", articulosNoRegistrados, totalArticulosRegistrados, fechaCreacion, nombreArchivo);
	}
	
	
	/**
	 * METODO QUE PERMITE ENVIAR UN EMAIL AL USUARIO LOGUEADO AL FINALIZAR LA CODIFICACION
	 * @param eventoID
	 * @param para
	 * @param userRecipient
	 * @param cc
	 * @param asunto
	 * @param articulosNoRegistrados
	 * @param totalArticulosRegistrados
	 * @param fechaCreacion
	 * @param nombreArchivo
	 * @throws SICException
	 */
	private void enviarMail(EventoID eventoID, String para[],String userRecipient, String[] cc, String asunto, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo) throws SICException {
		try {			
			EventoDTO eventoDTO = mensajeriaG.obtenerEventoPorID(eventoID);
			LOG_SICV2.info("El evento es: {}",eventoDTO.getAsuntoEvento());			
			MailMensajeEST mailMensajeEST = new MailMensajeEST();
			mailMensajeEST.setPara(para);
			mailMensajeEST.setCc(cc);
			mailMensajeEST.setCco(cc);
			mailMensajeEST.setAsunto(asunto);
			mailMensajeEST.setMensajeXML(obtenerXMLMensaje(userRecipient, articulosNoRegistrados, totalArticulosRegistrados, fechaCreacion, nombreArchivo));
			mailMensajeEST.setEventoDTO(eventoDTO);
			mailMensajeEST.setHost(MensajeriaMessages.getString("mail.serverHost"));
			mailMensajeEST.setPuerto(MensajeriaMessages.getString("mail.puerto"));
			mailMensajeEST.setFormatoHTML(true);

			mensajeriaG.envioMail(mailMensajeEST, ConstantesSMS.BORRAR_ARCHIVOS_NO);
		} catch (Exception e) {
			LOG_SICV2.error("Error en el metodo enviarMail",e);
			throw new SICException("Error al enviar mail {}",e);
		}
	}
	
	
	/**
	 * METODO QUE OBTIENE LA PLANTILLA XML PARA ENVIAR EL MAIL
	 * @param para
	 * @param articulosNoRegistrados
	 * @param totalArticulosRegistrados
	 * @param fechaCreacion
	 * @param nombreArchivo
	 * @return
	 */
	private String obtenerXMLMensaje(String para, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo){
		StringBuilder mensajeXML = new StringBuilder();
		mensajeXML.append("<?xml version='1.0' encoding='UTF-8'?>");
		mensajeXML.append("<mensaje>");
		mensajeXML.append("<para>"+para+"</para>");
		if(articulosNoRegistrados.size() > 0 && totalArticulosRegistrados == 0){
			mensajeXML.append("<mensajeTexto>no se registraron correctamente. A continuaci\u00F3n puede observar los detalles del proceso de registro.</mensajeTexto>");
		}else if(articulosNoRegistrados.size() == 0 && totalArticulosRegistrados > 0){
			mensajeXML.append("<mensajeTexto>se registraron correctamente. A continuaci\u00F3n puede observar los detalles del proceso de registro. </mensajeTexto>");
		}else if(articulosNoRegistrados.size() > 0 && totalArticulosRegistrados > 0){
			mensajeXML.append("<mensajeTexto> no fueron registrados en su totalidad. A continuaci\u00F3n puede observar los detalles del proceso de registro.</mensajeTexto>");
		}
		mensajeXML.append("<fechaCreacion> Fecha creaci\u00F3n: "+fechaCreacion+"</fechaCreacion>");
		mensajeXML.append("<nombreArchivo> Nombre archivo: "+nombreArchivo+"</nombreArchivo>");
		if(totalArticulosRegistrados > 0){
			mensajeXML.append("<textoFilaCorrecto>Total de art\u00EDculos registrados: "+totalArticulosRegistrados+" </textoFilaCorrecto>");
		}
		if(CollectionUtils.isNotEmpty(articulosNoRegistrados)){
			mensajeXML.append("<textoFilaIncorrecto>Filas del archivo no registradas</textoFilaIncorrecto>");
			for(Integer fila:articulosNoRegistrados){
				mensajeXML.append("<articulosInc>");
				mensajeXML.append("<tituloFilaIncorrecto>No. Fila</tituloFilaIncorrecto>");
				mensajeXML.append("<articuloInc>");
				mensajeXML.append("<fila>"+fila+"</fila>");
				mensajeXML.append("</articuloInc>");
				mensajeXML.append("</articulosInc>");
			}
		}
		mensajeXML.append("</mensaje>");
		return mensajeXML.toString();
	}
	
	
	@Override
	public void crearArticulo(ArticuloVO articuloVO) throws SICException {
		LOG_SICV2.info("==> Registrando Articulo Por Archivo");
		try {
			this.articuloGestor.registrarArticulo(articuloVO);
			this.finalizarCodificacion(articuloVO);
		} catch (Exception e) {
			throw new SICException(e.getMessage());
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ArticuloVO obtenerDatosArticuloVO(ArticuloVO articuloVOPlantillaValores, Integer key, MultiKeyMap datosListaValidos, LinkedHashMap[] objectListCarDin)throws SICException{
		LOG_SICV2.info("==> Asignando Valores al Articulo Por Archivo");
		ArticuloVO articuloVO = null;
		ClasificacionDTO clasificacionDTO = null;
		Set<EnumCaracteristicaDinamica> caracteristicasDinamicasLista = null;
		LinkedHashMap<String, Set<EnumCaracteristicaDinamica>> carDinMap = null;
		try{
			if(datosListaValidos != null){
				LinkedList<String> listaProveedor = (LinkedList<String>) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_CODIGO_PROVEEDOR.getNombreFormato());
				String indicadorI= listaProveedor.get(0);
				String codigoProveedor = listaProveedor.get(1);
				LinkedList<String> listaUnidadMedida = (LinkedList<String>) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_UNIDAD_MEDIDA.getNombreFormato());
				String unidadMedida = listaUnidadMedida.get(0);
				String codigoMedida = listaUnidadMedida.get(1);
				String clasificacion = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_CODIGO_CLASIFICACION.getNombreFormato());
				String subClasificacion = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_CODIGO_SUBCLASIFICACION.getNombreFormato());	
				String codigoBarras = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_CODIGO_BARRAS.getNombreFormato());
				String descripcion = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_DESCRIPCION.getNombreFormato());
				String clase = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_CLASE.getNombreFormato());
				String fechaInicioTemporada = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_FECHA_INICIO_TEMPORADA.getNombreFormato());
				String fechaFinTemporada = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_FECHA_FIN_TEMPORADA.getNombreFormato());
				String unidadManejo = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_UNIDAD_MANEJO.getNombreFormato());
				String ean14 = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_EAN14.getNombreFormato());
				String costoMonedaOrigen = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_COSTO_MONEDA_ORIGEN.getNombreFormato());
				String tamanio = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_TAMANIO.getNombreFormato());
				String marca = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_MARCA.getNombreFormato());
				String marcaParticipacion = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_MARCA_PARTICIPACION.getNombreFormato());
				String garantia = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_GARANTIA.getNombreFormato());
				String referencia = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_REFERENCIA.getNombreFormato());
				String referenciaInterna = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_REFERENCIA_INTERNA.getNombreFormato());
				String alcancePrototipo = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_ALCANCE_PROTOTIPO.getNombreFormato());
				String agrupador = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_AGRUPADOR.getNombreFormato());
				String costoBruto = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_COSTO_BRUTO.getNombreFormato());
				String des1 = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_DES1.getNombreFormato());
				String des2 = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_DES2.getNombreFormato());
				String des3 = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_DES3.getNombreFormato());
				String des4 = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_DES4.getNombreFormato());
				String precioVenta = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_PRECIO_VENTA.getNombreFormato());
				String precioSupermaxi = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_PRECIO_SUPERMAXI.getNombreFormato());
				String plazoPago = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_PLAZO_PAGO.getNombreFormato());
				String importancia = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_IMPORTANCIA.getNombreFormato());
				String cantidadMedida = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_CANTIDAD_MEDIDA.getNombreFormato());				
				String empaque = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_EMPAQUE.getNombreFormato());
				String ventaPrecioAfiliado = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_VENTA_PRECIO_AFILIADO.getNombreFormato());
				
				String tipoSecuencia = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_TIPO_SECUENCIA.getNombreFormato());
				String codigoPaisOrigen = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_PAIS_ORIGEN.getNombreFormato());
				String codigoLugarCompra = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_LUGAR_COMPRA.getNombreFormato());
				String pesoAproximadoRecepcion = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_PESO_APROX_RECEPCION.getNombreFormato());
				String pesoAproximadoVenta = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_PESO_APROX_VENTA.getNombreFormato());
				String presentacion = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_PRESENTACION.getNombreFormato());
				String valorEstadoTransgenico = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_TRANSGENICO.getNombreFormato());
				String valorRegistroSanitario = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_REGISTRO_SANITARIO.getNombreFormato());
				String fechaCaducidad = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_FECHA_CADUCIDAD_REG_SAN.getNombreFormato());
				String diasVidaUtilLocal = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_DURACION_CONS_LOCAL.getNombreFormato());
				String diasVidaUtilCongelado = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_DURACION_CONS_CONGELADO.getNombreFormato());
				String diasVidaUtilRefrigerado = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_DURACION_CONS_REFRIGERADO.getNombreFormato());
				String codigoUso = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_USOS.getNombreFormato());
				String controlPrecios = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_CONTROL_PRECIOS.getNombreFormato());
				
				cargarCaracteriticasDinamicasClasificacion(articuloVOPlantillaValores.getCodigoCompania(), clasificacion, objectListCarDin);
				carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
				caracteristicasDinamicasLista = carDinMap.get(clasificacion);
				articuloVO = new ArticuloVO();
				clasificacionDTO = new ClasificacionDTO();
				//Campos Requeridos
				this.asignarCamposRequeridos(articuloVOPlantillaValores, articuloVO);
				//Campos Basicos Articulo
				this.asignarCamposArticulo(articuloVO, indicadorI, importancia, descripcion);
				//Clasificacion
				this.asignarClasificacionSubclasificacionArticulo(articuloVO, clasificacionDTO, clasificacion, subClasificacion);
				//Articulo Comercial
				this.asignarArticuloComercial(articuloVO, clasificacionDTO, ventaPrecioAfiliado, codigoPaisOrigen, codigoLugarCompra,
						pesoAproximadoRecepcion, pesoAproximadoVenta, caracteristicasDinamicasLista, controlPrecios);
				//Codigo de barras
				this.asignarCodigoBarrasArticulo(articuloVO, codigoBarras, tipoSecuencia);
				//Clase
				this.asignarClaseArticulo(articuloVO, clase, fechaInicioTemporada, fechaFinTemporada);
				//Garantias
				this.asignarGarantias(articuloVO, garantia, caracteristicasDinamicasLista);
				//Tamanio
				this.asignarArticuloUnidadMedida(articuloVO, tamanio, cantidadMedida, unidadMedida, codigoMedida, presentacion, caracteristicasDinamicasLista);
				//Proveedor
				this.asignarArticuloProveedor(articuloVO, codigoProveedor, referencia, costoBruto, costoMonedaOrigen, plazoPago, referenciaInterna);
				//Marca
				this.asignarMarcaArticulo(articuloVO, marca, marcaParticipacion);
				//Unidad de manejo
				this.asignarUnidadManejo(articuloVO, unidadManejo, ean14, empaque);
				//Unidad Mayoreo
				this.asignarUnidadMayoreo(articuloVO);
				//Descuentos
				this.asignarDescuentos(articuloVO, des1, des2, des3, des4, clasificacion, codigoProveedor);
				//Precios
				this.asignarPreciosArticulo(articuloVO, precioVenta, precioSupermaxi);
				//Agrupador
				this.asignarAgrupadorArticulo(articuloVO, agrupador);
				//Alcance prototipo
				this.asignarAlcancePrototipo(articuloVO, alcancePrototipo);
				//Impuestos
				this.asignarImpuesto(articuloVO, key, datosListaValidos);
				//Duracion Conservacion
				this.asignarArticuloDuracion(articuloVO, diasVidaUtilLocal, diasVidaUtilCongelado, diasVidaUtilRefrigerado, caracteristicasDinamicasLista);
				//Usos
				this.asignarArticuloUsos(articuloVO, codigoUso, caracteristicasDinamicasLista);
				//Transgenico Registro Sanitario
				this.asignarArticuloTransReg(articuloVO, valorEstadoTransgenico, valorRegistroSanitario, fechaCaducidad);
				//Guardar
				this.guardarPasos(articuloVO);
				//asignamos la opcion de la creacion por archivo
				articuloVO.addDynamicProperty("opcionCreacionArchivo", SICArticuloConstantes.getInstancia().CODIGO_OPCION_CREACION_ARCHIVO);
			}
		}catch(SICException e){
			throw e;
		}catch (Exception e) {
			LOG_SICV2.error("Error al obtener los datos del articulo. {}",e.getMessage());
			throw new SICException(e.getMessage());
		}finally{
			clasificacionDTO = null;
			caracteristicasDinamicasLista = null;
		}
		return articuloVO;
	}
	
	
	/**
	 * @param codigoCompania
	 * @param codigoClasificacion
	 * @param objectListCarDin
	 * @author aecaiza
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void cargarCaracteriticasDinamicasClasificacion(Integer codigoCompania, String codigoClasificacion, LinkedHashMap[] objectListCarDin){
		Set<EnumCaracteristicaDinamica> lstCarDina = null;
		LinkedHashMap<String, Set<EnumCaracteristicaDinamica>> carDinMap = null;
		Object object = null;
		try{
			object = objectListCarDin[0];
			carDinMap = (object == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : (LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>)  object);
			if(!carDinMap.containsKey(codigoClasificacion)){
				lstCarDina = obtenerCaracteristicaDinamica(codigoCompania, codigoClasificacion);
				carDinMap.put(codigoClasificacion, lstCarDina);
				objectListCarDin[0] = carDinMap;
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al buscar las caracteristicas dinamicas por clasificacion. {}", e.getMessage());
		}finally{
			object = null;
			lstCarDina = null;
			carDinMap = null;
		}
	}
	/**
	 * @param articuloVOPlantillaValores
	 * @param articuloVO
	 * @throws SICException
	 * @author a
	 */
	private void asignarCamposRequeridos(ArticuloVO articuloVOPlantillaValores, ArticuloVO articuloVO) throws SICException{
		try{
			if(articuloVOPlantillaValores == null || articuloVO == null){
				throw new SICException("Error al asignar los campos requeridos para creacion articulo por archivo.");
			}
				articuloVO.setBaseDTO(new ArticuloDTO());
				//Auditoria
				articuloVO.getBaseDTO().setUserId(articuloVOPlantillaValores.getBaseDTO().getUserId());
				articuloVO.getBaseDTO().getId().setCodigoCompania(articuloVOPlantillaValores.getCodigoCompania());
				
				articuloVO.setUserId(articuloVOPlantillaValores.getBaseDTO().getUserId());
				articuloVO.setCodigoCompania(articuloVOPlantillaValores.getCodigoCompania());
				
				articuloVO.getBaseDTO().setCodigoTipoArticulo(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_PRODUCTO);
				//Estado Precodificaco articulo
				articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO);
				//Estado articulo
				articuloVO.getBaseDTO().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				//Sistema origen
				articuloVO.getBaseDTO().setCodigoSistemaOrigen(SICConstantes.CODIGO_SISTEMA_MAX);
				
				articuloVO.setSystemId(articuloVOPlantillaValores.getSystemId());
				
				articuloVO.setAccessItemId(articuloVOPlantillaValores.getAccessItemId());
				//Es creacion
				articuloVO.setEsCreacion(Boolean.TRUE);
				
				articuloVO.addDynamicProperty("esCreacion", Boolean.TRUE);
				
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar los campos requeridos para creacion articulo por archivo.", e.getMessage());
			throw new SICException(e.getMessage());
		}
	}
	
	
	/**
	 * Metodo que asigna campos basicos al articulo
	 * 
	 * @param articuloVO
	 * @param indicadorI
	 * @param importancia
	 * @param descripcion
	 * @author eharo
	 */
	private void asignarCamposArticulo(ArticuloVO articuloVO, String indicadorI, String importancia, String descripcion){
		try {
			if(articuloVO == null  || StringUtils.isEmpty(indicadorI)){
				throw new SICException("Error los valores indicadorI no pueden ser nulo ni vacio.");
			}
			if(StringUtils.isNotEmpty(importancia)){
				articuloVO.getBaseDTO().setImportancia(Integer.valueOf(importancia));
			}
			if(StringUtils.equals(indicadorI, "1")){
				articuloVO.getBaseDTO().setIndicadorI(Boolean.TRUE);
			}else if(StringUtils.equals(indicadorI, "0")){
				articuloVO.getBaseDTO().setIndicadorI(Boolean.FALSE);
			}
			articuloVO.getBaseDTO().setDescripcionArticulo(descripcion);
		} catch (Exception e) {
			LOG_SICV2.error("Error al asginar indicador, decripcion",e.getMessage());
			throw new SICException(e.getMessage());
		}
		
	}
	
	/**
	 * Metodo que asigna la clasificacion y subclasificacion al articulo
	 * @param articuloVO
	 * @param clasificacion
	 * @param subClasificacion
	 * @param ventaPrecioAfiliado
	 * @throws SICException
	 */
	private void asignarClasificacionSubclasificacionArticulo(ArticuloVO articuloVO, ClasificacionDTO clasificacionDTOS, String clasificacion, String subClasificacion)throws SICException{
		ClasificacionDTO clasificacionDTO = null;
		try{
			if(clasificacion == null || subClasificacion == null || StringUtils.isEmpty(clasificacion) || StringUtils.isEmpty(subClasificacion)){
				throw new SICException("Los valores clasificacion, subClasificacion no pueden ser nulos o vacios");
			}
			clasificacionDTO = new ClasificacionDTO();
			clasificacionDTO.getId().setCodigoClasificacion(clasificacion);
			clasificacionDTO = this.dataGestor.findUnique(clasificacionDTO);
			if(clasificacionDTO != null){
				articuloVO.getBaseDTO().setClasificacionDTO(clasificacionDTO);
				articuloVO.getBaseDTO().setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
				articuloVO.getBaseDTO().setCodigoSubClasificacion(subClasificacion);
				articuloVO.getBaseDTO().getClasificacionDTO().setClasificacionPadre(clasificacionDTO.getClasificacionPadre());
				clasificacionDTOS.getId().setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
				clasificacionDTOS.setValorTipoDeducible(clasificacionDTO.getValorTipoDeducible());
				clasificacionDTOS.setTipoDeducible(clasificacionDTO.getTipoDeducible());
				clasificacionDTOS.setPorcentajeNoAfiliado(clasificacionDTO.getPorcentajeNoAfiliado());
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar clasificacion, subClasificacion no pueden ser nulos o vacios",e.getMessage());
			throw new SICException(e.getMessage());
		}finally{
			clasificacionDTO = null;
		}
	}
	
	/**
	 * Metodo que asigna el articulo proveedor 
	 * @param articuloVO
	 * @param codigoProveedor
	 * @param codigoReferenciaProveedor
	 * @param costoSinIVA
	 * @param costoMonedaOrigen
	 * @param plazoPago
	 * @throws SICException
	 */
	private void asignarArticuloProveedor(ArticuloVO articuloVO, String codigoProveedor, String codigoReferenciaProveedor, String costoSinIVA, String costoMonedaOrigen, String plazoPago, String referenciaInterna)throws SICException{
		ArticuloProveedorDTO articuloProveedorDTO = null;
		ArticuloImportacionDTO articuloImportacion = null;
		try{
			if(codigoProveedor == null || costoSinIVA == null || StringUtils.isEmpty(costoSinIVA)
					|| StringUtils.isEmpty(codigoProveedor)	|| StringUtils.isEmpty(plazoPago)){
				throw new SICException("Los valores codigoProveedor, codigoReferenciaProveedor, plazoPago no pueden ser nulos ni vacios");
			}
			articuloProveedorDTO = new ArticuloProveedorDTO();
			
			articuloProveedorDTO.getId().setCodigoProveedor(codigoProveedor);
			//Referencia
			articuloProveedorDTO.setCodigoReferenciaProveedor(codigoReferenciaProveedor);
			articuloProveedorDTO.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			//Costo sin IVA
			articuloProveedorDTO.setCostoBruto(Double.valueOf(costoSinIVA));
			articuloProveedorDTO.setCodigoPlazoPago(TipoCatalogosProveedor.TIPO_PLAZO_PAGO_DIAS);
			articuloProveedorDTO.setValorPlazoPago(plazoPago);
			if(StringUtils.isNotEmpty(StringUtils.trim(referenciaInterna))){
				articuloProveedorDTO.setCodigoReferenciaInterna(referenciaInterna);
			}
			//Costo Moneda Origen
			if(costoMonedaOrigen != null && StringUtils.isNotEmpty(costoMonedaOrigen.trim())){
				articuloImportacion = new ArticuloImportacionDTO();
				articuloImportacion.setCostoMonedaOrigen(BigDecimal.valueOf(Double.valueOf(costoMonedaOrigen)));
				articuloProveedorDTO.setArticuloImportacion(articuloImportacion);
			}
			articuloVO.setArticuloProveedorDTO(articuloProveedorDTO);
			articuloVO.getBaseDTO().setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
			articuloVO.getBaseDTO().getArticuloProveedorCol().add(articuloProveedorDTO);
			
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar el articulo proveedor. {}",e.getMessage());
			throw new SICException("Error al asignar el articulo proveedor. {}",e.getMessage());
		}finally{
			articuloProveedorDTO = null;
			articuloImportacion = null;
		}
	}
	
	/**
	 * Metodo que asignar el codigo de barras al articulo
	 * @param articuloVO
	 * @param codigoBarras
	 * @throws SICException
	 */
	private void asignarCodigoBarrasArticulo(ArticuloVO articuloVO, String codigoBarras, String valorTipoSecuencia) throws SICException{
		try{
			articuloVO.getBaseDTO().setCodigoBarrasActivo(new ArticuloBitacoraCodigoBarrasDTO());
			if(valorTipoSecuencia != null){
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setValorTipoSecuencia(valorTipoSecuencia);
			}else{
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setValorTipoSecuencia(SICArticuloConstantes.getInstancia().TIPSECART_PESOFIJO);
			}
			if(StringUtils.isNotEmpty(codigoBarras)){
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setCodigoTipoCodigoArticulo(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN);
				articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().setCodigoBarras(codigoBarras);
			}else{
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setCodigoTipoCodigoArticulo(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar el codigo de barras al articulo. {}",e.getMessage());
			throw new SICException("Error al asignar el codigo de barras al articulo. {}",e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite asignar el tamanio al articulo
	 * @param articuloVO
	 * @param tamanio
	 * @param cantidadMedida
	 * @param unidadMedida
	 * @throws SICException
	 */
	private void asignarArticuloUnidadMedida(ArticuloVO articuloVO, String tamanio, String cantidadMedida, String unidadMedida, String codigoMedida, String presentacion, Set<EnumCaracteristicaDinamica> caracteristicasDinamicasLista) throws SICException{
		ArticuloMedidaDTO articuloMedidaDTO = null;
		try{			
			articuloMedidaDTO = new ArticuloMedidaDTO();
			if(CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEPRESENTACIONES)){
				articuloMedidaDTO.setReferenciaMedida(tamanio);
				if(StringUtils.isNotEmpty(StringUtils.trim(codigoMedida))){
					articuloMedidaDTO.setCodigoTipoMedida(Integer.valueOf(codigoMedida));
				}else{
					articuloMedidaDTO.setCodigoTipoMedida(SICArticuloConstantes.getInstancia().CODIGO_CATALOGO_UNIDAD_MEDIDA);
				}
				articuloMedidaDTO.setCantidadMedida(Double.valueOf(cantidadMedida));
				articuloMedidaDTO.setValorTipoMedida(unidadMedida);
				if(presentacion != null && StringUtils.isNotEmpty(presentacion.trim())){
					articuloMedidaDTO.setPresentacion(Integer.valueOf(presentacion));
				}
			}
			articuloVO.getBaseDTO().setArticuloMedidaDTO(articuloMedidaDTO);
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar el articuloMedida del articulo. {}", e.getMessage());
			throw new SICException("Error al asignar el articuloMedida del articulo. {}", e.getMessage());
		}finally{
			articuloMedidaDTO = null;
		}
	}
	
	/**
	 * Metodo que asigna el articulo comercial	
	 * @param articuloVO
	 * @param clasificacionDTO
	 * @param ventaPrecioAfiliado
	 */
	private void asignarArticuloComercial(ArticuloVO articuloVO, ClasificacionDTO clasificacionDTO, String ventaPrecioAfiliado, 
			String codigoPaisOrigen, String codigoLugarCompra, String pesoAproximadoRecepcion, String pesoAproximadoVenta, Set<EnumCaracteristicaDinamica> caracteristicasDinamicasLista, String contolPrecios){
		ArticuloComercialDTO articuloComercialDTO = null;
		try{			
			if(articuloVO != null || clasificacionDTO != null){
				articuloComercialDTO = new ArticuloComercialDTO();
				articuloVO.getBaseDTO().setArticuloComercialDTO(articuloComercialDTO);
				articuloVO.getBaseDTO().getArticuloComercialDTO().setCodigoTipoDeducible(clasificacionDTO.getCodigoTipoDeducible());
				articuloVO.getBaseDTO().getArticuloComercialDTO().setValorTipoDeducible(clasificacionDTO.getValorTipoDeducible());
				if(StringUtils.isNotEmpty(StringUtils.trim(ventaPrecioAfiliado))){
					articuloVO.getBaseDTO().getArticuloComercialDTO().setVentaPrecioAfiliado(Boolean.valueOf(ventaPrecioAfiliado));
				}
				articuloVO.getBaseDTO().getArticuloComercialDTO().setPorcentajeNoAfiliado(clasificacionDTO.getPorcentajeNoAfiliado());
				if(codigoPaisOrigen != null && StringUtils.isNotEmpty(codigoPaisOrigen.trim())){
					articuloVO.getBaseDTO().getArticuloComercialDTO().setCodigoPaisOrigen(codigoPaisOrigen);
				}
				if(codigoLugarCompra != null && StringUtils.isNotEmpty(codigoLugarCompra.trim())){
					articuloVO.getBaseDTO().getArticuloComercialDTO().setCodigoLugarCompra(Long.valueOf(codigoLugarCompra));
				}
				if(pesoAproximadoRecepcion !=null && StringUtils.isNotEmpty(pesoAproximadoRecepcion.trim())){
					articuloVO.getBaseDTO().getArticuloComercialDTO().setPesoAproximadoRecepcion(Double.valueOf(pesoAproximadoRecepcion));
				}
				if(pesoAproximadoVenta != null && StringUtils.isNotEmpty(pesoAproximadoVenta.trim())){
					articuloVO.getBaseDTO().getArticuloComercialDTO().setPesoAproximadoVenta(Double.valueOf(pesoAproximadoVenta));
				}
				if(contolPrecios != null && StringUtils.isNotEmpty(contolPrecios.trim())){
					articuloVO.getBaseDTO().getArticuloComercialDTO().setCodigoTipoControlCosto(SICConstantes.TIPO_CONTROL_COSTO);
					articuloVO.getBaseDTO().getArticuloComercialDTO().setValorTipoControlCosto(contolPrecios);
				}else{
					articuloVO.getBaseDTO().getArticuloComercialDTO().setCodigoTipoControlCosto(SICConstantes.TIPO_CONTROL_COSTO);
					articuloVO.getBaseDTO().getArticuloComercialDTO().setValorTipoControlCosto(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE);
				}
				if(CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_VERIFICA_FECHACADUCIDAD)){
					articuloVO.getBaseDTO().getArticuloComercialDTO().setVerFecCadRec(Boolean.TRUE);
				}else{
					articuloVO.getBaseDTO().getArticuloComercialDTO().setVerFecCadRec(Boolean.FALSE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar el articulo comercial. {}", e.getMessage());
			throw new SICException("Error al asignar el articulo comercial. {}", e.getMessage());
		}finally{
			articuloComercialDTO = null;
			clasificacionDTO = null;
		}
	}
	
	/**
	 * Metodo que asigna la marca al articulo
	 * @param articuloVO
	 * @param marca
	 * @param marcaParticipacion
	 * @throws SICException
	 */
	private void asignarMarcaArticulo(ArticuloVO articuloVO, String marca, String marcaParticipacion)throws SICException{
		MarcaArticuloDTO marcaArticuloDTO = null;
		try{
			if(marca == null || marcaParticipacion == null || StringUtils.isEmpty(marca) || StringUtils.isEmpty(marcaParticipacion)){
				throw new SICException("Los valores marca, marcaParticipacion no pueden ser nulos ni vacios");
			}
			marcaArticuloDTO = new MarcaArticuloDTO();
			marcaArticuloDTO.getId().setSecuencialMarca(Long.valueOf(marca));
			
			articuloVO.getBaseDTO().getArticuloComercialDTO().setMarcaComercialArticulo(marcaArticuloDTO);
			articuloVO.getBaseDTO().getArticuloComercialDTO().setCodigoMarcaComercial(Long.valueOf(marca));
			articuloVO.getBaseDTO().getArticuloComercialDTO().setMarcaParticipaciones(marcaParticipacion);
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar marca al articulo. {}",e.getMessage());
			throw new SICException(e.getMessage());
		}finally{
			marcaArticuloDTO = null;
		}
	}
	
	/**
	 * Metodo que asigna la clase al articulo
	 * @param articuloVO
	 * @param clase
	 * @param fechaInicioTemporada
	 * @param fechaFinTemporada
	 * @throws SICException
	 */
	private void asignarClaseArticulo( ArticuloVO articuloVO, String clase, String fechaInicioTemporada, String fechaFinTemporada)throws SICException{
		ClaseArticuloDTO claseArticuloDTO = null;
		ArticuloTemporadaDTO articuloTemporadaDTO = null;
		try{
			if(clase == null || StringUtils.isEmpty(clase)){
				throw new SICException("Los valores clase no puede ser nulo ni vacio");
			}
			claseArticuloDTO = new ClaseArticuloDTO();
			claseArticuloDTO.getId().setCodigoClaseArticulo(clase);
			articuloVO.getBaseDTO().setClaseArticuloDTO(claseArticuloDTO);
			articuloVO.getBaseDTO().setClaseArticulo(clase);
			//Fecha Inicio Fin Temporada
			if(StringUtils.equals(clase, SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_T) 
					&& StringUtils.isNotEmpty(fechaInicioTemporada)
					&& StringUtils.isNotEmpty(fechaFinTemporada) ){
				articuloTemporadaDTO = new ArticuloTemporadaDTO();
				articuloTemporadaDTO.setFechaInicioTemporada(ManejoFechas.convertStringDate(fechaInicioTemporada));
				articuloTemporadaDTO.setFechaFinTemporada(ManejoFechas.convertStringDate(fechaFinTemporada));
				articuloVO.getBaseDTO().setArticuloTemporadaDTO(articuloTemporadaDTO);
			}
		}catch(Exception e){
			throw new SICException("Error al asignar la clase articulo. {}",e.getMessage());
		}finally{
			claseArticuloDTO = null;
			articuloTemporadaDTO = null;
		}
	}
	
	/**
	 * Metodo que asigna la unidad de manejo
	 * @param articuloVO
	 * @param unidadManejo
	 * @param EAN14
	 * @param empaque
	 * @throws SICException
	 */
	private void asignarUnidadManejo(ArticuloVO articuloVO, String unidadManejo, String ean14, String empaque) throws SICException{
		ArticuloUnidadManejoDTO articuloUnidadManejoDTO = null;
		ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedor = null;
		try{
			if(unidadManejo == null || StringUtils.isEmpty(unidadManejo)){
				throw new SICException("Los valores unidadManejo no puede ser nulo ni vacio");
			}
			articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
			articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
			articuloUnidadManejoDTO.setValorUnidadManejo(Integer.valueOf(unidadManejo));
			articuloUnidadManejoDTO.setCodigoTipoUnidadEmpaque(SICArticuloConstantes.getInstancia().CODIGOTIPOEMPAQUE);
			articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			articuloUnidadManejoProveedor  = new ArticuloUnidadManejoProveedorDTO();
			articuloUnidadManejoDTO.setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
			articuloUnidadManejoProveedor.getId().setCodigoProveedor(articuloVO.getArticuloProveedorDTO().getId().getCodigoProveedor());
			articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedor);
			
			//usos de um  
			articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
			this.asignacionUnidadesManejo(articuloUnidadManejoDTO, SICArticuloConstantes.getInstancia().VALORUSOUNIMANCOMPRA);
			this.asignacionUnidadesManejo(articuloUnidadManejoDTO, SICArticuloConstantes.getInstancia().VALORUSOUNIMANDESPACHO);
			articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(empaque);		
			articuloUnidadManejoDTO.setPrioridad(1);
				
			//EAN14
			if(StringUtils.isNotEmpty(ean14)){
				articuloUnidadManejoDTO.setCodigoBarrasUnidadManejo(ean14);
			}
			articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoDTO);
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar la unidad de manejo. {}",e.getMessage());
			throw new SICException("Error al asignar la unidad de manejo. {}",e.getMessage());
		}finally{
			articuloUnidadManejoDTO = null;
			articuloUnidadManejoProveedor = null;
		}
	}
	private void asignarUnidadMayoreo(ArticuloVO articuloVO)throws SICException{
		Boolean asignarMayoreo = Boolean.FALSE;
		ArticuloUnidadManejoDTO articuloUnidadManejoMayoreo = null;
		final String[] PARAMETROS_MAX = new String[] { 
				SICParametros.PARAMETRO_MAYOREO_DIVISIONES, 
				SICParametros.PARAMETRO_MAYOREO_PESO_VARIABLE_RANGO,
				SICParametros.PARAMETRO_MAYOREO_DEPARTAMENTOS, 
				SICParametros.PARAMETRO_MAYOREO_CLASIFICACION1, 
				SICParametros.PARAMETRO_MAYOREO_CLASIFICACION2, 
				SICParametros.PARAMETRO_MAYOREO_CLASE, 
				SICParametros.PARAMETRO_MAYOREO_PROVEEDOR, 
				SICParametros.PARAMETRO_MAYOREO_CLASIFICACION3,
				SICParametros.PARAMETRO_MAYOREO_SUBCLASIFICACION, 
				SICParametros.PARAMETRO_MAYOREO_MARCAPROPIA };
		try {
			if( CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloUnidadManejoCol() ) ){
				asignarMayoreo = this.validacionReglasComerciales.validarAplicaMayoreo(articuloVO.getBaseDTO());
				if(asignarMayoreo){
					articuloUnidadManejoMayoreo = new ArticuloUnidadManejoDTO();
					articuloUnidadManejoMayoreo.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
					articuloUnidadManejoMayoreo.setValorUnidadManejo(5);
					articuloUnidadManejoMayoreo.setDescuentoVenta(5D);
					articuloUnidadManejoMayoreo.setCodigoTipoUnidadEmpaque(SICArticuloConstantes.CODIGOTIPOEMPAQUE);
					articuloUnidadManejoMayoreo.setValorTipoUnidadEmpaque(SICArticuloConstantes.TIPOEMPAQUE_MAYORISTA);
					articuloUnidadManejoMayoreo.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					this.asignacionUnidadesManejo(articuloUnidadManejoMayoreo, SICArticuloConstantes.VALORUSOUNIMANVENTA);		
					articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoMayoreo);
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al asignar unidad de mayoreo {}", e.getMessage());
			throw new SICException("Error al asignar unidad de mayoreo {}", e.getMessage());
		}
		
	}
	
	/**
	 * Asigna los descuentos al articulo
	 * @param articuloVO
	 * @param des1
	 * @param des2
	 * @param des3
	 * @param des4
	 * @param codigoClasificacion
	 * @param codigoProveedor
	 * @throws SICException
	 * @author eharo
	 */
	private void asignarDescuentos(ArticuloVO articuloVO, String des1, String des2, String des3, String des4, String codigoClasificacion, String codigoProveedor) throws SICException{
		try {
			
			String descuentoNotaCredito = StringUtils.EMPTY;
			
			Collection<AsignacionTipoDescuentoDTO> asignacionTipoDescuentoCol = buscarAsignacionTipoDescuentoCol(articuloVO.getBaseDTO().getId().getCodigoCompania());
			
			if(StringUtils.isBlank(des1) && StringUtils.isBlank(des2) && StringUtils.isBlank(des3) && StringUtils.isBlank(des4)) {
				des1 = this.asignarDescuentosPorProveedor(articuloVO, codigoClasificacion, codigoProveedor, des1, SICArticuloConstantes.TIPODESCUENTO1, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
				des2 = this.asignarDescuentosPorProveedor(articuloVO, codigoClasificacion, codigoProveedor, des2, SICArticuloConstantes.TIPODESCUENTO2, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
				des3 = this.asignarDescuentosPorProveedor(articuloVO, codigoClasificacion, codigoProveedor, des3, SICArticuloConstantes.TIPODESCUENTO3, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
				des4 = this.asignarDescuentosPorProveedor(articuloVO, codigoClasificacion, codigoProveedor, des4, SICArticuloConstantes.TIPODESCUENTO4, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
			}
			articuloVO.getArticuloProveedorDTO().setDescuentoProveedorArticuloCol(new ArrayList<DescuentoProveedorArticuloDTO>());
			if(StringUtils.isNotEmpty(des1) && !StringUtils.isWhitespace(des1) && (Double.valueOf(des1) > 0D)){
				asignacionDescuento(articuloVO, SICArticuloConstantes.TIPODESCUENTO1, des1, asignacionTipoDescuentoCol);
			}
			if(StringUtils.isNotEmpty(des2) && !StringUtils.isWhitespace(des2) && (Double.valueOf(des2) > 0D)){
				asignacionDescuento(articuloVO, SICArticuloConstantes.TIPODESCUENTO2, des2, asignacionTipoDescuentoCol);
			}
			if(StringUtils.isNotEmpty(des3) && !StringUtils.isWhitespace(des3) && (Double.valueOf(des3) > 0D)){
				asignacionDescuento(articuloVO, SICArticuloConstantes.TIPODESCUENTO3, des3, asignacionTipoDescuentoCol);
			}
			if(StringUtils.isNotEmpty(des4) && !StringUtils.isWhitespace(des4) && (Double.valueOf(des4) > 0D)){
				asignacionDescuento(articuloVO, SICArticuloConstantes.TIPODESCUENTO4, des4, asignacionTipoDescuentoCol);
			}
			
			//Agregando el descuento de Nota de credito
			descuentoNotaCredito = this.asignarDescuentosPorProveedor(articuloVO, codigoClasificacion, codigoProveedor, des4, SICArticuloConstantes.TIPODESCUENTONOTACREDITO, EnumTipoAplicacionDescuento.COSTO_CONVENIO.getValorTipoAplicacionDescuento());
			if(StringUtils.isNotEmpty(descuentoNotaCredito) && !StringUtils.isWhitespace(descuentoNotaCredito) && (Double.valueOf(descuentoNotaCredito) > 0D)){
				asignacionDescuento(articuloVO, SICArticuloConstantes.TIPODESCUENTONOTACREDITO, descuentoNotaCredito, asignacionTipoDescuentoCol);
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al asignar los descuentos al articulo {}", e.getMessage());
			throw new SICException("Error al asignar los descuentos al articulo {}", e.getMessage());
		}
	}
	
	/**
	 * Metodo que asigna el agrupador al articulo
	 * @param articuloVO
	 * @param agrupador
	 * @throws SICException
	 */
	private void asignarAgrupadorArticulo(ArticuloVO articuloVO, String agrupador)throws SICException{
		ArticuloAgrupadorDTO articuloAgrupadorDTO = null;
		try{
			if(agrupador == null || StringUtils.isEmpty(agrupador)){
				throw new SICException("Error el agrupador no puede ser nulo ni vacio");
			}
			articuloAgrupadorDTO = new ArticuloAgrupadorDTO();
			articuloAgrupadorDTO.getId().setValorTipoAgrupador(agrupador);
			articuloAgrupadorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			articuloAgrupadorDTO.getId().setCodigoTipoAgrupador(SICArticuloConstantes.getInstancia().CATALOGOTIPO_AGRUPADOR);
			articuloVO.getBaseDTO().setArticuloAgrupadorCol(new ArrayList<ArticuloAgrupadorDTO>());
			articuloVO.getBaseDTO().getArticuloAgrupadorCol().add(articuloAgrupadorDTO);
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar el agrupador al articulo. {}", e.getMessage());
			throw new SICException("Error al asignar el agrupador al articulo. {}", e.getMessage());
		}finally{
			articuloAgrupadorDTO = null;
		}
	}
	
	/**
	 * Asigna el alcance prototipo al articulo
	 * @param articuloVO
	 * @param alcancePrototipo
	 * @throws SICException
	 */
	private void asignarAlcancePrototipo(ArticuloVO articuloVO, String alcancePrototipo)throws SICException{
			try {
				//validamos cuando el prototipo viene nulo
				if(StringUtils.isEmpty(alcancePrototipo)){
					articuloVO.getBaseDTO().setCodigoGrupoAlcance(null);
				}else{
					articuloVO.getBaseDTO().setGrupoAlcanceDTO(new GrupoTrabajoDTO());
					articuloVO.getBaseDTO().setCodigoGrupoAlcance(Long.valueOf(alcancePrototipo));
					articuloVO.setCodigoGrupoAlcanceAnterior(SICArticuloConstantes.CODIGOPROTOTIPOPERSONALIZADO);
				}
				
				articuloVO.getBaseDTO().addDynamicProperty(ArticuloTransient.PROCESO_CREACION_MASIVA_ARTICULO, Boolean.TRUE);
			} catch (Exception e) {
				LOG_SICV2.error("Error al asignar alcance prototipo. {}", e.getMessage());
				throw new SICException("Error al asignar alcance prototipo. {}", e.getMessage());
			}
			
	}
	
	/**
	 * Asigna los precios al articulo
	 * @param articuloVO
	 * @param precioVenta
	 * @param precioRebajado
	 * @throws SICException
	 */
	private void asignarPreciosArticulo( ArticuloVO articuloVO, String precioVenta, String precioRebajado) throws SICException{
		ArticuloPrecioDTO articuloPrecioVenta = null;
		ArticuloPrecioDTO articuloPrecioRebajado = null;
		try {
			articuloVO.getBaseDTO().setArticuloPrecioCol(new ArrayList<ArticuloPrecioDTO>());
			if(StringUtils.isNotEmpty(StringUtils.trim(precioVenta))){
				articuloPrecioVenta = new ArticuloPrecioDTO();
				articuloPrecioVenta.getId().setCodigoTipoPrecio(SICArticuloConstantes.TIPO_PRECIO_PVP);
				articuloPrecioVenta.setValorActual(Double.valueOf(precioVenta));
				articuloVO.getBaseDTO().getArticuloPrecioCol().add(articuloPrecioVenta);
			}
			if(StringUtils.isNotEmpty(StringUtils.trim(precioRebajado))){
				articuloPrecioRebajado = new ArticuloPrecioDTO();
				articuloPrecioRebajado.getId().setCodigoTipoPrecio(SICArticuloConstantes.TIPO_PRECIO_BASE);
				articuloPrecioRebajado.setValorActual(Double.valueOf(precioRebajado));
				articuloVO.getBaseDTO().getArticuloPrecioCol().add(articuloPrecioRebajado);
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al asignar los precios {}", e.getMessage());
			throw new SICException("Error al asignar los precios {}", e.getMessage());
		}finally{
			articuloPrecioVenta = null;
			articuloPrecioRebajado = null;
		}
	}
	
	/**
	 * Metodo que asignar las garantias
	 * @param articuloVO
	 * @param garantia
	 * @throws SICException
	 */
	private void asignarGarantias(ArticuloVO articuloVO, String garantia, Set<EnumCaracteristicaDinamica> caracteristicasDinamicasLista)throws SICException{
		ArticuloGarantiaDTO articuloGarantia = null;
		try {			
			if(CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEGARANTIA)){
				articuloGarantia = new ArticuloGarantiaDTO();
				articuloGarantia.setEstadoGarantia(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				if(StringUtils.isNotEmpty(garantia)){
					articuloGarantia.setTieMaxGarNor(Integer.valueOf(garantia));
				}
				articuloVO.getBaseDTO().setArticuloGarantiaDTO(articuloGarantia);
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al asignar la garantia. {}", e.getMessage());
			throw new SICException(e.getMessage());
		}finally{
			articuloGarantia = null;
		}
	}
	
	/**
	 * Metodo que asigna los impuestos
	 * @param articuloVO
	 * @param datosRegistros
	 */
	private void asignarImpuesto(ArticuloVO articuloVO, Integer key, MultiKeyMap datosRegistros){
		ArticuloImpuestoDTO articuloImpuestoDTO = null;
		TipoImpuestoDTO tipoImpuestoDTO = null;
		Collection<TipoImpuestoDTO> impuestoDTOs = null;
		StringBuilder codigoImpuestoCompra = null;
		StringBuilder codigoImpuestoVenta = null;
		try {
			tipoImpuestoDTO = new TipoImpuestoDTO();
			tipoImpuestoDTO.setEstadoTipoImpuesto(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			impuestoDTOs = dataGestor.findObjects(tipoImpuestoDTO);
			if(impuestoDTOs != null){
				articuloVO.getBaseDTO().setArticuloImpuestoCol(new ArrayList<ArticuloImpuestoDTO>());
				for(TipoImpuestoDTO impuesto : impuestoDTOs){
					codigoImpuestoCompra = new StringBuilder(impuesto.getNombreTipoImpuesto());
					codigoImpuestoVenta= new StringBuilder(impuesto.getNombreTipoImpuesto());
					if(impuesto.getId().getCodigoTipoImpuesto() != null && impuesto.getId().getCodigoTipoImpuesto().compareTo(SICArticuloConstantes.TIPOIMPUESTO_OMISION_IVE) != 0){
						codigoImpuestoCompra.append(impuesto.getPorcentajeImpuesto().intValue());
						codigoImpuestoVenta.append(impuesto.getPorcentajeImpuesto().intValue());
					}
					Boolean esParaCompra = BooleanUtils.toBoolean((String) datosRegistros.get(key, codigoImpuestoCompra.append(" (C)").toString()));
					Boolean esParaVenta = BooleanUtils.toBoolean((String) datosRegistros.get(key, codigoImpuestoVenta.append(" (V)").toString()));
					if(esParaVenta || esParaCompra){
						articuloImpuestoDTO = new ArticuloImpuestoDTO();
						articuloImpuestoDTO.getId().setCodigoTipoImpuesto(impuesto.getId().getCodigoTipoImpuesto());
						articuloImpuestoDTO.setEstadoArticuloImpuesto(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						articuloImpuestoDTO.setEsParaCompra(esParaCompra);
						articuloImpuestoDTO.setEsParaVenta(esParaVenta);
						articuloVO.getBaseDTO().getArticuloImpuestoCol().add(articuloImpuestoDTO);
					}
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al asignar Impuesto. {}", e.getMessage());
			throw new SICException("Error al asignar Impuesto", e.getMessage());
		}finally{
			articuloImpuestoDTO = null;
			tipoImpuestoDTO = null;
			impuestoDTOs = null;
			codigoImpuestoCompra = null;
			codigoImpuestoVenta = null;
		}
	}
	/**
	 * Metodo que asigna el valor transgenico y el registro sanitario
	 * @param articuloVO
	 * @param valorEstadoTransgenico
	 * @param valorAplicaRegistroSanitario
	 * @param fechaCaducidad
	 */
	private void asignarArticuloTransReg(ArticuloVO articuloVO, String valorEstadoTransgenico, String  valorRegistroSanitario, String fechaCaducidad){
		ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO = null;
		RelacionArticuloRegistroSanitarioDTO relacionRegistroSanitarioDTO = null;
		try {
			if(StringUtils.isNotEmpty(valorEstadoTransgenico)){
				articuloVO.getBaseDTO().setValorEstadoTransgenico(valorEstadoTransgenico);
				articuloVO.getBaseDTO().setCodigoEstadoTransgenico(TipoCatalogoArticulo.TIPO_CARACTERISTICA_TRANSGENICO);
			}
			if(valorRegistroSanitario != null && fechaCaducidad != null){
				if(StringUtils.isNotEmpty(valorRegistroSanitario.trim()) && StringUtils.isNotEmpty(fechaCaducidad.trim())){
					articuloRegistroSanitarioDTO = new ArticuloRegistroSanitarioDTO();
					relacionRegistroSanitarioDTO = new RelacionArticuloRegistroSanitarioDTO();
					articuloVO.getBaseDTO().setRegistroSanitarioCol(new ArrayList<RelacionArticuloRegistroSanitarioDTO>());
					articuloVO.getBaseDTO().setValorAplicaRegistroSanitario(TipoCatalogoArticulo.VALOR_APLICA_REGISTRO_SANITARIO);
					
					articuloVO.getBaseDTO().setCodigoAplicaRegistroSanitario(TipoCatalogoArticulo.TIPO_ESTADO_APLICA_REGISTRO_SANITARIO);				
					articuloRegistroSanitarioDTO.setFechaCaducidadRegistroSanitario(ManejoFechas.convertStringDate(fechaCaducidad));
					articuloRegistroSanitarioDTO.setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO);
					articuloRegistroSanitarioDTO.setRegistroSanitario(valorRegistroSanitario);
					relacionRegistroSanitarioDTO.setArticulo(articuloVO.getBaseDTO());
					relacionRegistroSanitarioDTO.setRegistroSanitario(articuloRegistroSanitarioDTO);
					relacionRegistroSanitarioDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloVO.getBaseDTO().getRegistroSanitarioCol().add(relacionRegistroSanitarioDTO);
				}
			}else{
				articuloVO.getBaseDTO().setValorAplicaRegistroSanitario(TipoCatalogoArticulo.VALOR_NO_APLICA_REGISTRO_SANITARIO);
				articuloVO.getBaseDTO().setCodigoAplicaRegistroSanitario(TipoCatalogoArticulo.TIPO_ESTADO_APLICA_REGISTRO_SANITARIO);
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al asignar registro sanitario y transgenico al articulo. {}", e.getMessage());
			throw new SICException("Error al asignar registro sanitario y transgenico al articulo", e.getMessage());
		}finally{
			articuloRegistroSanitarioDTO = null;
			relacionRegistroSanitarioDTO = null;
		}
	}
	/**
	 * Metodo que asigna la duracion de conservacion al articulo
	 * @param articuloVO
	 * @param diasVidaUtilLocal
	 * @param diasVidaUtilCongelado
	 * @param diasVidaUtilRefrigerado
	 * @throws SICException
	 */
	private void asignarArticuloDuracion(ArticuloVO articuloVO, String diasVidaUtilLocal, String diasVidaUtilCongelado, String diasVidaUtilRefrigerado, Set<EnumCaracteristicaDinamica> caracteristicasDinamicasLista) throws SICException{
		try {
			articuloVO.getBaseDTO().setArticuloDuracionConservacionCol(new ArrayList<ArticuloDuracionConservacionDTO>());
			if(CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_LOCAL)){
				if(StringUtils.isNotEmpty(diasVidaUtilLocal) && diasVidaUtilLocal != null){
					asignarDuracionConservacion(articuloVO, diasVidaUtilLocal, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL);
				}
			}
			if(CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_CONGELADO)){
				if(StringUtils.isNotEmpty(diasVidaUtilCongelado) && diasVidaUtilCongelado != null){
					asignarDuracionConservacion(articuloVO, diasVidaUtilCongelado, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO);
				}
			}
			if(CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_REFRIGERADO)){
				if(StringUtils.isNotEmpty(diasVidaUtilRefrigerado) && diasVidaUtilRefrigerado != null){
					asignarDuracionConservacion(articuloVO, diasVidaUtilRefrigerado, SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO);
				}
			}
			
		} catch (Exception e) {
			LOG_SICV2.error("Error al asignar duracion conservacion al articulo {}", e.getMessage());
			throw new SICException("Error al asignar duracion conservacion al articulo {}", e.getMessage());
		}
	}
	
	private void asignarDuracionConservacion(ArticuloVO articuloVO, String diasVidaUtil, String codigoDuracionConservacion){
		ArticuloDuracionConservacionDTO articuloDuracionConservacionDTO = null;
		try {
			articuloDuracionConservacionDTO = new ArticuloDuracionConservacionDTO();
			articuloDuracionConservacionDTO.getId().setCodigoTipoConservacion(TipoCatalogoArticulo.TIPO_CODIGO_DURACION_CONSERVACION);
			articuloDuracionConservacionDTO.getId().setValorTipoConservacion(codigoDuracionConservacion);
			articuloDuracionConservacionDTO.setDiasVidaUtil(Integer.valueOf(diasVidaUtil));
			
			articuloVO.getBaseDTO().getArticuloDuracionConservacionCol().add(articuloDuracionConservacionDTO);
		}catch(Exception e){
			LOG_SICV2.error("Error al asignar duracion conservacion. {}", e.getMessage());
			throw new SICException("Error al asignar duracion conservacion. {}", e.getMessage());
		}finally{
			articuloDuracionConservacionDTO = null;
		}
	}
	
	/**
	 * Metodo que asigna solo un uso al articulo
	 * @param articuloVO
	 * @param codigoUso
	 * @throws SICException
	 */
	private void asignarArticuloUsos(ArticuloVO articuloVO, String codigoUso, Set<EnumCaracteristicaDinamica> caracteristicasDinamicasLista) throws SICException{
		ArticuloUsoDTO articuloUsoDTO = null;
		try {
			if(CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && StringUtils.isNotEmpty(codigoUso) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEUSOS)){
				articuloUsoDTO = new ArticuloUsoDTO();
				articuloVO.getBaseDTO().setArticuloUsoCol(new ArrayList<ArticuloUsoDTO>());
				articuloUsoDTO.getId().setCodigoTipoUso(TipoCatalogoArticulo.TIPOS_USO_CARNES);
				articuloUsoDTO.getId().setValorTipoUso(codigoUso);
				articuloVO.getBaseDTO().getArticuloUsoCol().add(articuloUsoDTO);
			}
			
		} catch (Exception e) {
			LOG_SICV2.error("Error al asignar usos al articulo. {}", e.getMessage());
			throw new SICException("Error al asignar usos al articulo. {}", e.getMessage());
		}finally{
			articuloUsoDTO = null;
		}
	}
	/**
	 * Metodo que permite tener los valores, para que la validacion al guardar se realize en un solo paso
	 * @param articuloVO
	 * @author aecaiza
	 */
	public void guardarPasos(ArticuloVO articuloVO)throws SICException{
		try {
			articuloVO.setSubProcesoGuardadoArticulo(new HashSet<EnumSubProcesoGuardadoArticulo>());
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULO);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.CODIGOBARRAS);				
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOMEDIDA);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOPROVEEDOR);
			//Segundo Paso
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOCOMERCIAL);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOIMPUESTO);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.DESCUENTOVENTAARTICULO);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOPRECIOS);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOTEMPORADA);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOUNIDADMANEJO);
			//Cuarto Paso
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOGARANTIA);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.AGRUPADOR);
			//Departamento Abastos
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULODURACIONCONSERVACION);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOUSO);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.REGISTROSANITARIO);
			
			//Quinto Paso
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.PRECIOSPORLOCAL);
			articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOALCANCE);
		} catch (Exception e) {
			LOG_SICV2.error("Error al guardar el articulo por los pasos. {}",e.getMessage());
			throw new SICException("Error al guardar el articulo por los pasos. {}",e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite finalizar la creacion 
	 * @param articuloVO
	 */
	public void finalizarCodificacion(ArticuloVO articuloVO){
		articuloVO.getBaseDTO().getCodigoBarrasActivo().setPendienteCodigoBarras(Boolean.FALSE);
		articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO);
		articuloVO.setCodigoSubbodega(articuloVO.getBaseDTO().getClasificacionDTO().getCodigoBodega());
		articuloVO.getBaseDTO().addDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO_ARCHIVO, Boolean.TRUE);	
		
		articuloVO.setSubProcesoGuardadoArticulo(new HashSet<EnumSubProcesoGuardadoArticulo>());
		articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULO);
		articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.CODIGOBARRAS);
		articuloVO.getSubProcesoGuardadoArticulo().add(EnumSubProcesoGuardadoArticulo.ARTICULOPROVEEDOR);
		//asignamos la propiedad para que no registre la auditoria extendida por segunda vez
		articuloVO.addDynamicProperty("registrarAuditoriaExtendida", true);
		//agregamos la propiedad dinamica al proveedor para que registre las condiciones comerciales a nivel de clasificacion
		if(CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloProveedorCol())){
			for(ArticuloProveedorDTO articuloProveedorDTO : articuloVO.getBaseDTO().getArticuloProveedorCol()){
				articuloProveedorDTO.addDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO, true);
			}
		}
		this.articuloGestor.registrarArticulo(articuloVO);
	}
	@SuppressWarnings("unchecked")
	private Set<EnumCaracteristicaDinamica> obtenerCaracteristicaDinamica(Integer codigoCompania, String codigoClasificacion){
		Collection<CaracteristicaDinamicaDTO> caracteristicaDinamicaDTOs = null;
		CaracteristicaDinamicaDTO caracteristicaDinamicaDTO = null;
		Set<EnumCaracteristicaDinamica>  caracteristicaDinamicas = null;
		try {
			caracteristicaDinamicaDTO = new CaracteristicaDinamicaDTO();
			caracteristicaDinamicaDTOs = new ArrayList<CaracteristicaDinamicaDTO>();
			List<Integer> codigosCaracteristicaDinamica = new ArrayList<Integer>();
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_VERIFICA_FECHACADUCIDAD);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_TIENEGARANTIA);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_TIENEUSOS);
			codigosCaracteristicaDinamica.add(SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_TIENEPRESENTACIONES);
			
			caracteristicaDinamicaDTO.addCriteriaSearchParameter("codigoTipoCaracteristica", ComparatorTypeEnum.IN_COMPARATOR, codigosCaracteristicaDinamica);
			caracteristicaDinamicaDTO.setCodigoClasificacion(codigoClasificacion);
			caracteristicaDinamicaDTO.setCodigoCompania(codigoCompania);
			caracteristicaDinamicaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			caracteristicaDinamicaDTOs = this.dataGestor.findObjects(caracteristicaDinamicaDTO);
			caracteristicaDinamicas = CaracteristicaDinamicaUtil.transformarCaracteristicasDinamicas(caracteristicaDinamicaDTOs);
		} catch (Exception e) {
			LOG_SICV2.error("Error al consultar las caracteristicas dinamicas {}", e.getMessage());
			throw new SICException("Error al consultar las caracteristicas dinamicas {}", e.getMessage());
		}
		return caracteristicaDinamicas;
	}
	
	/**
	 * Metodo que asigna a la lista de descuentos
	 * 
	 * @param articuloVO
	 * @param descuento
	 * @param des
	 * @throws SICException
	 */
	private void asignacionDescuento(ArticuloVO articuloVO, String descuento, String des, Collection<AsignacionTipoDescuentoDTO> asignacionTipoDescuentoCol) throws SICException{
		DescuentoProveedorArticuloDTO descuentoArticuloProveedor = null;
		try {
			descuentoArticuloProveedor = new DescuentoProveedorArticuloDTO();
			descuentoArticuloProveedor.setPorcentajeDescuento(Double.valueOf(des));
			descuentoArticuloProveedor.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);

			// <>TIPODESCUENTO
			if( CollectionUtils.isNotEmpty(asignacionTipoDescuentoCol) ){
				AsignacionTipoDescuentoDTO asigTipDes = (AsignacionTipoDescuentoDTO) CollectionUtils.find(asignacionTipoDescuentoCol, new BeanPredicate("codigoTipoDescuento", PredicateUtils.equalPredicate(descuento)));
				descuentoArticuloProveedor.setSecuencialAsignacionTipoDescuento(asigTipDes.getId().getSecuencialAsignacionTipoDescuento());
				descuentoArticuloProveedor.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
				descuentoArticuloProveedor.getAsignacionTipoDescuento().setCodigoTipoDescuento(asigTipDes.getCodigoTipoDescuento());
				descuentoArticuloProveedor.getAsignacionTipoDescuento().setCodigoAplicacionTipoDescuento(asigTipDes.getCodigoAplicacionTipoDescuento());
				descuentoArticuloProveedor.getAsignacionTipoDescuento().setValorAplicacionTipoDescuento(asigTipDes.getValorAplicacionTipoDescuento());
			}

			articuloVO.getArticuloProveedorDTO().getDescuentoProveedorArticuloCol().add(descuentoArticuloProveedor);
		} catch (Exception e) {
			LOG_SICV2.error("Error al obtener los descuentos. {}", e.getMessage());
			throw new SICException("Error al obtener los descuentos. {}",e.getMessage());
		}finally{
			descuentoArticuloProveedor = null;
		}
	}
	
	/**
	 * Busca los tipos de descuentos del articulo (COMPRA, CONVENIO)
	 * @param codigoCompania
	 * @return
	 */
	private Collection<AsignacionTipoDescuentoDTO> buscarAsignacionTipoDescuentoCol(Integer codigoCompania)throws SICException{
		Collection<AsignacionTipoDescuentoDTO> asiTipoDes = null;
		try{			
			AsignacionTipoDescuentoDTO asignacionTipoDescuentoDTO = new AsignacionTipoDescuentoDTO();
			asignacionTipoDescuentoDTO.getId().setCodigoCompania(codigoCompania);
			asignacionTipoDescuentoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			asignacionTipoDescuentoDTO.setCodigoAsignacionTipoDescuento(EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO);
			asignacionTipoDescuentoDTO.setValorAsignacionTipoDescuento(EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento());
			asignacionTipoDescuentoDTO.setCodigoAplicacionTipoDescuento(EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
			asignacionTipoDescuentoDTO.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.IN_COMPARATOR, new String[] { EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento(), EnumTipoAplicacionDescuento.COSTO_CONVENIO.getValorTipoAplicacionDescuento() }));
			asiTipoDes = SICFactory.getInstancia().administracion.getDataService().findObjects(asignacionTipoDescuentoDTO);
		}catch (SICException e) {
			Logeable.LOG_SICV2.error("Error al consultar los tipos de descuentos del art\u00EDculo.", e.getMessage());
			throw new SICException("Error al consultar los tipos de descuentos del art\u00EDculo.. {}",e.getMessage());
		}
		return asiTipoDes;
	}
	
	/**
	 * Metodo para asignar usos unidad de manejo
	 * @param articuloVO
	 * @param articuloUnidadManejoDTO
	 * @param valorUso
	 */
	private void asignacionUnidadesManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String valorUso ){
		ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoCompraDTO = null;
		try {
			if(articuloUnidadManejoDTO == null || valorUso == null || StringUtils.isEmpty(valorUso)){
				throw new SICException("Error los valores articuloUnidadManejoDTO, valorUso no pueden ser nulos ni vacios");
			}
			articuloUnidadManejoUsoCompraDTO = new ArticuloUnidadManejoUsoDTO();
			articuloUnidadManejoUsoCompraDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			articuloUnidadManejoUsoCompraDTO.setCodigoTipoUso(SICArticuloConstantes.getInstancia().CODIGOTIPOUSOUNIMAN);
			articuloUnidadManejoUsoCompraDTO.getId().setValorTipoUso(valorUso);
			articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoCompraDTO);
		} catch (Exception e) {
			throw new SICException(e.getMessage());
		}finally{
			articuloUnidadManejoUsoCompraDTO = null;
		}
	}
	
	/**
	 * Metodo para obtener los descuentos por proveedor
	 * @param articuloVOPlantillaValores
	 * @param codigoClasificacion
	 * @param codigoProveedor
	 * @param des
	 * @param codigoTipoDescuento
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	private String asignarDescuentosPorProveedor(ArticuloVO articuloVOPlantillaValores, String codigoClasificacion, String codigoProveedor, String des, String codigoTipoDescuento, String valorAplicacionTipoDescuento) throws SICException{
		Double porcentaje = null;
		try {
			porcentaje = this.creacionPorArchivoDAO.obtenerPorcentajeDescuento(articuloVOPlantillaValores.getBaseDTO().getId().getCodigoCompania(), codigoProveedor, codigoClasificacion, codigoTipoDescuento, valorAplicacionTipoDescuento);
			if(porcentaje == null){
				des = StringUtils.EMPTY;
			}else{
				des = String.valueOf(porcentaje);
			}
		} catch (SICException e) {
			throw new SICException("Error al consultar los descuentos por proveedor {}", e.getMessage());
		}
		return des;
	}
	
	/**
	 * Agrega los valores de asignarTipoDescuento
	 * @param descuentoProveedorArticuloDTOs
	 */
//	private void agregarAsignacionTipoDescuento(DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO){
//		if( descuentoProveedorArticuloDTO != null ){
//			AsignacionTipoDescuentoDTO asignacionTipoDescuentoDTO = new AsignacionTipoDescuentoDTO();
//			asignacionTipoDescuentoDTO.getId().setCodigoCompania(descuentoProveedorArticuloDTO.getId().getCodigoCompania());
//			asignacionTipoDescuentoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//			asignacionTipoDescuentoDTO.setCodigoAsignacionTipoDescuento(EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO);
//			asignacionTipoDescuentoDTO.setValorAsignacionTipoDescuento(EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento());
//			asignacionTipoDescuentoDTO.setCodigoAplicacionTipoDescuento(EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
//			asignacionTipoDescuentoDTO.setValorAplicacionTipoDescuento(EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
//			
//			Collection<AsignacionTipoDescuentoDTO> coll = SICFactory.getInstancia().administracion.getDataService().findObjects(asignacionTipoDescuentoDTO);
//			// <>TIPODESCUENTO
//			if( CollectionUtils.isNotEmpty(coll) ){
//				AsignacionTipoDescuentoDTO artTipDes = (AsignacionTipoDescuentoDTO) CollectionUtils.find(coll, new BeanPredicate("codigoTipoDescuento", PredicateUtils.equalPredicate(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getCodigoTipoDescuento())));
//				descuentoProveedorArticuloDTO.setSecuencialAsignacionTipoDescuento(artTipDes.getId().getSecuencialAsignacionTipoDescuento());
//				descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setCodigoAplicacionTipoDescuento(artTipDes.getCodigoAplicacionTipoDescuento());
//				descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setValorAplicacionTipoDescuento(artTipDes.getValorAplicacionTipoDescuento());
//			}
//		}
//	}
	
	/**
	 * @param mensajeriaG the mensajeriaG to set
	 */
	public void setMensajeriaG(MensajeriaG mensajeriaG) {
		this.mensajeriaG = mensajeriaG;
	}
	
	
	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	
	/**
	 * @param articuloGestor the articuloGestor to set
	 */
	public void setArticuloGestor(IArticuloGestor articuloGestor) {
		this.articuloGestor = articuloGestor;
	}
	
	/**
	 * @return the creacionPorArchivoDAO
	 */
	public IArticuloCreacionPorArchivoDAO getCreacionPorArchivoDAO() {
		return creacionPorArchivoDAO;
	}

	/**
	 * @param creacionPorArchivoDAO the creacionPorArchivoDAO to set
	 */
	public void setCreacionPorArchivoDAO(IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO) {
		this.creacionPorArchivoDAO = creacionPorArchivoDAO;
	}	

	
	/**
	 * @return the validacionReglasComerciales
	 */
	public IValidacionArticuloReglasComercialesGestor getValidacionReglasComerciales() {
		return validacionReglasComerciales;
	}

	/**
	 * @param validacionReglasComerciales the validacionReglasComerciales to set
	 */
	public void setValidacionReglasComerciales(IValidacionArticuloReglasComercialesGestor validacionReglasComerciales) {
		this.validacionReglasComerciales = validacionReglasComerciales;
	}
}
