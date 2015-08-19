package ec.com.smx.sic.webservices.pedidoAsistido;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.id.AreaTrabajoID;
import ec.com.smx.framework.ad.json.JsonPojoMapper;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.pedidoAsistido.SICPedidoAsistidoConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoInformacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;
import ec.com.smx.sic.cliente.resources.pedidoAsistido.SICPedidoAsistidoMessages;

@Controller
@Scope(value = "request")
public class PedidoAsistidoCreacionWebService {

	private AreaTrabajoDTO areaTrabajoLocal;
	/** CD actual en el ciclo */
	AreaTrabajoDTO cdActual;
	Boolean tipoApertura;
	String perfil = "98";
	String codFuncionario = "51304";
	String idUsuario = "USR16321";
	Integer codigoLocal = 711;
	Integer codigoCompania = 1;

	Integer cantidadTotalArticulos = 0;
	Integer cantidadTotalArticulosRevisados = 0;

	String rotaciones[] = new String[6];
	final Locale locale = new Locale("es", "EC");

	private HttpHeaders createHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/jsonp; charset=utf-8");
		responseHeaders.add("Access-Control-Allow-Origin", "*");
		return responseHeaders;
	}

	/** Obtener scheduler */
	public static Scheduler getScheduler(HttpServletRequest request) throws SchedulerException {
		ServletContext ctx = request.getSession().getServletContext();
		StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute("org.quartz.impl.StdSchedulerFactory.KEY");

		return factory.getScheduler();
	}

	/**
	 * Actualiza la informaci&oacute;n de las rotaciones de un pedido, por
	 * defecto 6 d&iacute;as antes de la fecha de recepci&oacute;n del pedido.
	 * 
	 * @param fechaRecepcionDate
	 *            fecha de recepcion del pedido
	 */
	public void actualizarRotacionesPedidoAsistido(String frecuenciaRotacion) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd");

		Calendar fechaActual = Calendar.getInstance(locale);
		fechaActual.setTime(new Date());

		rotaciones = new String[6];
		Collection<Date> fechasRotacionCol = null;

		if (fechaActual != null) {

			fechasRotacionCol = new ArrayList<Date>();

			// validacion tipo de frecuencia a calcular
			if (frecuenciaRotacion.equals("diario")) {

				fechaActual.add(Calendar.DAY_OF_YEAR, -1);

				for (int i = 0; i < rotaciones.length; i++) {

					// Numero de fechas y numero dia en semana
					Date fechaRotacionDate = fechaActual.getTime();
					String diaFechaRot = sdf.format(fechaRotacionDate);

					Integer numDiaSemRot = fechaActual.get(Calendar.DAY_OF_WEEK);
					String diaStrRot = null;

					if (numDiaSemRot == 1) {
						diaStrRot = "Dom";
					} else if (numDiaSemRot == 2) {
						diaStrRot = "Lun";
					} else if (numDiaSemRot == 3) {
						diaStrRot = "Mar";
					} else if (numDiaSemRot == 4) {
						diaStrRot = "Mie";
					} else if (numDiaSemRot == 5) {
						diaStrRot = "Jue";
					} else if (numDiaSemRot == 6) {
						diaStrRot = "Vie";
					} else if (numDiaSemRot == 7) {
						diaStrRot = "Sab";
					}

					StringBuffer rotacionSB = new StringBuffer();
					rotacionSB.append(diaStrRot).append(" ").append(diaFechaRot);

					// LOG_SICV2.info("Fecha Rotacion : " +
					// rotacionSB.toString() + " dia de la semana : " +
					// numDiaSemRot);
					rotaciones[i] = rotacionSB.toString();
					fechasRotacionCol.add(fechaRotacionDate);

					// Frecuencia diaria
					fechaActual.add(Calendar.DAY_OF_YEAR, -1);
				}

				return;

			} else if (frecuenciaRotacion.equals("semanal")) {

				Integer numDiaSemRot = ((fechaActual.get(Calendar.DAY_OF_WEEK)) - 1);
				fechaActual.add(Calendar.DAY_OF_YEAR, -numDiaSemRot);

				for (int i = 0; i < rotaciones.length; i++) {

					// dia de la fecha
					Date fechaRotacionDate = fechaActual.getTime();
					String diaFechaRot = sdf.format(fechaRotacionDate);
					Integer numMesRot = fechaActual.get(Calendar.MONTH);
					String diaStrRot = null;

					if (numMesRot == 0) {
						diaStrRot = "Ene";
					} else if (numMesRot == 1) {
						diaStrRot = "Feb";
					} else if (numMesRot == 2) {
						diaStrRot = "Mar";
					} else if (numMesRot == 3) {
						diaStrRot = "Abr";
					} else if (numMesRot == 4) {
						diaStrRot = "May";
					} else if (numMesRot == 5) {
						diaStrRot = "Jun";
					} else if (numMesRot == 6) {
						diaStrRot = "Jul";
					} else if (numMesRot == 7) {
						diaStrRot = "Ago";
					} else if (numMesRot == 8) {
						diaStrRot = "Sep";
					} else if (numMesRot == 9) {
						diaStrRot = "Oct";
					} else if (numMesRot == 10) {
						diaStrRot = "Nov";
					} else if (numMesRot == 11) {
						diaStrRot = "Dic";
					}

					StringBuffer rotacionSB = new StringBuffer();
					rotacionSB.append(diaStrRot).append(" ").append(diaFechaRot);

					// LOG_SICV2.info("Fecha Rotacion : " +
					// rotacionSB.toString() + " mes del anio : " + numMesRot);
					rotaciones[i] = rotacionSB.toString();
					fechasRotacionCol.add(fechaRotacionDate);

					// Frecuencia semanal
					fechaActual.add(Calendar.WEEK_OF_YEAR, -1);
				}

				return;

			} else if (frecuenciaRotacion.equals("mensual")) {

				fechaActual.add(Calendar.MONTH, -1);

				for (int i = 0; i < rotaciones.length; i++) {
					// dia de la fecha
					Date fechaRotacionDate = fechaActual.getTime();
					String diaFechaRot = sdf.format(fechaRotacionDate);
					Integer numMesRot = fechaActual.get(Calendar.MONTH);
					String diaStrRot = null;

					if (numMesRot == 0) {
						diaStrRot = "ENE";
					} else if (numMesRot == 1) {
						diaStrRot = "FEB";
					} else if (numMesRot == 2) {
						diaStrRot = "MAR";
					} else if (numMesRot == 3) {
						diaStrRot = "ABR";
					} else if (numMesRot == 4) {
						diaStrRot = "MAY";
					} else if (numMesRot == 5) {
						diaStrRot = "JUN";
					} else if (numMesRot == 6) {
						diaStrRot = "JUL";
					} else if (numMesRot == 7) {
						diaStrRot = "AGO";
					} else if (numMesRot == 8) {
						diaStrRot = "SEP";
					} else if (numMesRot == 9) {
						diaStrRot = "OCT";
					} else if (numMesRot == 10) {
						diaStrRot = "NOV";
					} else if (numMesRot == 11) {
						diaStrRot = "DIC";
					}

					StringBuffer rotacionSB = new StringBuffer();
					rotacionSB.append(diaStrRot);

					// LOG_SICV2.info("Fecha Rotacion : " +
					// rotacionSB.toString() + " mes del anio : " + numMesRot);
					rotaciones[i] = rotacionSB.toString();
					fechasRotacionCol.add(fechaRotacionDate);

					// Frecuencia mensual
					fechaActual.add(Calendar.MONTH, -1);
				}

				return;
			}
		}
	}


	/** Datos del pedido seleccionado */
	@RequestMapping(value = "/pedidoAsistidoDetalles", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> gestionarDetalles(
			@RequestParam(value = "idPedidoHijo", required = false) String idPedidoHijo,
			@RequestParam(value = "idPedidoPadre", required = false) String idPedidoPadre,
			@RequestParam(value = "codigoBodega", required = true) String codigoBodega,
			@RequestParam(value = "tipoPedido", required = true) String tipoPedido,
			@RequestParam(value = "tipoCreacionPedido", required = true) String tipoCreacionPedido,
			@RequestParam(value = "frecuenciaRotacion", required = true) String frecuenciaRotacion,
			@RequestParam(value = "pedidoNuevo", required = true) String pedidoNuevo,
			@RequestParam(value = "codigoAreTraSubBodega", required = true) String codigoAreTraSubBodega,
			HttpServletRequest request) throws JsonProcessingException, ParseException, SchedulerException {

		PedidoAsistidoVO pedidoAsistidoVO = new PedidoAsistidoVO();
		Scheduler scheduler = getScheduler(request);

		String retorno = "";
		Map<String, Object> detallesCol = new HashMap<String, Object>();
		Map<String, Object> articuloMap = new HashMap<String, Object>();
		Collection<Map<String, Object>> clasificacionesColMap = new ArrayList<Map<String, Object>>();
		Collection<Map<String, Object>> articulosCol = new ArrayList<Map<String, Object>>();
		Collection<PedidoAreaTrabajoClasificacionDTO> clasificacionesCol = new ArrayList<PedidoAreaTrabajoClasificacionDTO>();
		Map<String, Object> clasificacionMap = null;
		try {

			/** Obtener codigo de subbodega en tbl bodega */
			String codigoSubbodegaBodega = SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoCalculoServicio()
					.obtenerSubbodegaDeBodegaDTO(1, Integer.parseInt(codigoAreTraSubBodega));

			pedidoAsistidoVO.setScheduler(scheduler);
			pedidoAsistidoVO.setBaseDTO(new PedidoAreaTrabajoDTO());
			pedidoAsistidoVO.getBaseDTO().getId().setCodigoCompania(1);
			pedidoAsistidoVO.setCodigoBodegaSubbodega(codigoSubbodegaBodega);
			pedidoAsistidoVO.setUserId(this.idUsuario);
			pedidoAsistidoVO.setCodigoATBodegaSel(Integer.parseInt(codigoBodega));
			pedidoAsistidoVO.getBaseDTO().setPedidoPadre(new PedidoAreaTrabajoDTO());
			pedidoAsistidoVO.getBaseDTO().getPedidoPadre().setPedidoInformacion(new PedidoAreaTrabajoInformacionDTO());
			pedidoAsistidoVO.getBaseDTO().getPedidoPadre().getPedidoInformacion()
					.setCodigoAreaTrabajoPedido(this.codigoLocal);
			pedidoAsistidoVO.getBaseDTO().getId().setCodigoPedidoAreaTrabajo(Long.parseLong(idPedidoHijo));
			pedidoAsistidoVO.getBaseDTO().setCodigoPedidoAreaTrabajoPadre(Long.parseLong(idPedidoPadre));

			pedidoAsistidoVO.getBaseDTO().getPedidoPadre().getPedidoInformacion()
					.setAreaTrabajoPedido(new AreaTrabajoDTO());
			pedidoAsistidoVO.getBaseDTO().getPedidoPadre().getPedidoInformacion().getAreaTrabajoPedido()
					.setTipoAreaTrabajoValor("LOC");

			pedidoAsistidoVO.setMaxResults(28);
			pedidoAsistidoVO.setFirstResult(0);
			pedidoAsistidoVO.setCountAgain(Boolean.TRUE);

			pedidoAsistidoVO.setNumeroDiasArticuloNuevo(SICPedidoAsistidoMessages.getInstancia()
					.getInteger("ec.com.smx.sic.pedidoAsistido.numeroDiasNuevo"));
			pedidoAsistidoVO.setNumeroDiasArticuloAlcance(SICPedidoAsistidoMessages.getInstancia()
					.getInteger("ec.com.smx.sic.pedidoAsistido.numeroDiasAlcance"));
			pedidoAsistidoVO.setLlenarCantidadPedida(Boolean.FALSE);

			pedidoAsistidoVO.setFrecuenciaRotacion(frecuenciaRotacion);

			/** Gestionar clasificaciones */
			clasificacionesCol = SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoAlmacenamientoServicio()
					.actualizarEstructuraPedidoClasificacion(pedidoAsistidoVO);

			PedidoAreaTrabajoClasificacionDTO clasificacionSel = new PedidoAreaTrabajoClasificacionDTO();
			Integer index = 1;

			for (PedidoAreaTrabajoClasificacionDTO clasificacionDTO : clasificacionesCol) {
				if (index.equals(1)) {
					clasificacionSel = clasificacionDTO;

				}
				clasificacionMap = new HashMap<String, Object>();
				clasificacionMap.put("idClasif", clasificacionDTO.getId().getCodigoClasificacion());
				clasificacionMap.put("descripcion", clasificacionDTO.getDescripcionClasificacion());
				clasificacionMap.put("totalArt", clasificacionDTO.getTotalArticulos());
				clasificacionMap.put("totalRev", clasificacionDTO.getTotalArticulosRevisados());
				clasificacionMap.put("totalPed", clasificacionDTO.getTotalArticulosPedidos());

				clasificacionesColMap.add(clasificacionMap);
				index++;
			}

			detallesCol.put("clasificaciones", clasificacionesColMap);

			// Actualizar de acuerdo al pedido
			if (tipoCreacionPedido.equals("asistido")) {

				/*Rotaciones
				actualizarRotacionesPedidoAsistido(frecuenciaRotacion);
				detallesCol.put("rotacionesCabecera", this.rotaciones);		*/		

				// Obtener cantidades maximas de articulo por local
				Collection<Map<String, Object>> articulosRef = SICFactory.getInstancia().pedidoAsistido
						.getPedidoAsistidoCalculoServicio()
						.obtenerCantidadMaximaPorArticuloLocalWS(this.codigoLocal, Long.parseLong(idPedidoPadre));

				if (CollectionUtils.isNotEmpty(articulosRef)) {
					detallesCol.put("articulosReferencia", articulosRef);

				}

				pedidoAsistidoVO.setClasificacionSelect(clasificacionSel);

				pedidoAsistidoVO.getBaseDTO()
						.setPedidoAreaTrabajoDetalleCol(new ArrayList<PedidoAreaTrabajoDetalleDTO>());
				SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoCalculoServicio()
						.obtenerDetallesPedidoAsistido(pedidoAsistidoVO);

				for (PedidoAreaTrabajoDetalleDTO pedidoAreaTrabajoDetalleDTO : pedidoAsistidoVO.getBaseDTO()
						.getPedidoAreaTrabajoDetalleCol()) {
					articuloMap = new HashMap<String, Object>();
					articuloMap.put("idArticulo", pedidoAreaTrabajoDetalleDTO.getCodigoArticulo());
					articuloMap.put("descripcion", pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO()
							.getArticulo().getDescripcionArticulo());
					articuloMap.put("articuloMarcado",
							pedidoAreaTrabajoDetalleDTO.getDynamicProperty("articuloMarcado"));
					articuloMap.put("tieneVariasUM", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("tieneVariasUM"));
					articuloMap.put("articuloRelacionado",
							pedidoAreaTrabajoDetalleDTO.getDynamicProperty("articuloRelacionado"));
					articuloMap.put("anomaliaValor", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("anomaliaValor"));
					articuloMap.put("codBarras", pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getArticulo()
							.getCodigoBarrasActivo().getId().getCodigoBarras());
					articuloMap.put("unidadManejo",
							pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getValorUnidadManejo());
					articuloMap.put("marca",
							pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getArticulo()
									.getTieneArticuloComercial()
											? pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getArticulo()
													.getArticuloComercialDTO().getMarcaComercialArticulo().getNombre()
											: "");
					articuloMap.put("exiCd", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("exiCd"));
					articuloMap.put("exiLoc", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("exiLoc"));
					articuloMap.put("ventaAyer", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("sugerido"));
					articuloMap.put("proyeccion", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("sugerido"));
					articuloMap.put("volumen", pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getCubicaje());
					articuloMap.put("cantidadPedida", pedidoAreaTrabajoDetalleDTO.getCantidadPedida());
					articuloMap.put("cantidadReservada", pedidoAreaTrabajoDetalleDTO.getCantidadReservada());
					articuloMap.put("promedioRot", pedidoAreaTrabajoDetalleDTO.getPromedioRotacion());
					articuloMap.put("rotacion1", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion1"));
					articuloMap.put("rotacion2", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion2"));
					articuloMap.put("rotacion3", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion3"));
					articuloMap.put("rotacion4", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion4"));
					articuloMap.put("rotacion5", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion5"));
					articuloMap.put("rotacion6", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion6"));
					articulosCol.add(articuloMap);
				}
				detallesCol.put("articulos", articulosCol);

			}

			retorno = JsonPojoMapper.getInstance().writeValueAsString(detallesCol);

			return new ResponseEntity<String>(retorno, createHttpHeaders(), HttpStatus.OK);
		} catch (SICException se) {
			throw new SICException(se.getMessage());
		}

	}

	/** Insertar nuevo pedido */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/pedidoAsistidoNuevo", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> nuevoPedido(
			@RequestParam(value = "apertura", required = true) String apertura,
			@RequestParam(value = "codSubbodega", required = true) String codSubbodega,
			@RequestParam(value = "codigoBodega", required = true) String codBodega,
			@RequestParam(value = "codCd", required = true) String codCd,			
			@RequestParam(value = "fechaDespacho", required = false) String fechaDes,
			@RequestParam(value = "fechaPedido", required = false) String fechaPed,
			@RequestParam(value = "fechaRecepcion", required = false) String fechaRec,
			HttpServletRequest request) throws JsonProcessingException, ParseException, SchedulerException {
		
		Scheduler scheduler = getScheduler(request);
		
		Map<String, Object> detallesCol = new HashMap<String, Object>();
		Map<String, Object> articuloMap = new HashMap<String, Object>();
		Collection<Map<String, Object>> clasificacionesColMap = new ArrayList<Map<String, Object>>();
		Collection<Map<String, Object>> articulosCol = new ArrayList<Map<String, Object>>();
		Collection<PedidoAreaTrabajoClasificacionDTO> clasificacionesCol = new ArrayList<PedidoAreaTrabajoClasificacionDTO>();
		Map<String, Object> clasificacionMap = null;
		
		/** Obtener codigo de subbodega en tbl bodega */
		String codigoSubbodegaBodega = SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoCalculoServicio()
				.obtenerSubbodegaDeBodegaDTO(1, Integer.parseInt(codSubbodega));

		Boolean tipoApertura = Boolean.parseBoolean(apertura);
		CatalogoValorDTO tipoPedidoInicial = new CatalogoValorDTO();
		tipoPedidoInicial.getId().setCodigoCatalogoTipo(SICPedidoAsistidoConstantes.CODIGO_TIPO_PEDIDO_ASISTIDO);
		

		try {
			/**Inicializar el area de trabajo del pedido*/
			this.areaTrabajoLocal = new AreaTrabajoDTO();
			this.areaTrabajoLocal.setId(new AreaTrabajoID());
			this.areaTrabajoLocal.getId().setCodigoAreaTrabajo(codigoLocal);
			this.areaTrabajoLocal.getId().setCodigoCompania(1);
			this.areaTrabajoLocal.setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL);
			this.areaTrabajoLocal.setTipoAreaTrabajoTIC(TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
			String horaMaximaTransmisionString = SICPedidoAsistidoMessages.getInstancia()
					.getString("ec.com.smx.sic.pedidoAsistido.hora.maxima.pedido.tipo.apertura");
			Time horaMaximaTransmision = new Time(formatoHora.parse(horaMaximaTransmisionString).getTime());

			Date fechaDespacho = sdf.parse(fechaDes);
			Date fechaRecepcion = sdf.parse(fechaRec);
			Date fechaPedido = formatoFecha.parse(fechaPed);
			
			Integer codigoCd = Integer.parseInt(codCd);
			Integer codigoSubb = Integer.parseInt(codSubbodega);
			Integer codigoBodega = Integer.parseInt(codBodega);
			
			String tipoCreacionPedido = "asistido";
			
			// Validar el tipo de pedido a crearse (APERTURA O ASISTIDO)
			if (tipoApertura) {
				// Tipo pedido : APERTURA
				tipoPedidoInicial.getId()
						.setCodigoCatalogoValor(SICPedidoAsistidoConstantes.CODIGO_VALOR_TIPO_PEDIDO_APERTURA);

				// Hora y fechas de pedido apertura
				
				horaMaximaTransmisionString = SICPedidoAsistidoMessages.getInstancia()
						.getString("ec.com.smx.sic.pedidoAsistido.hora.maxima.pedido.tipo.apertura");
				horaMaximaTransmision = new Time(formatoHora.parse(horaMaximaTransmisionString).getTime());				

			} else {
				// Tipo pedido : ASISTIDO
				tipoPedidoInicial.getId()
						.setCodigoCatalogoValor(SICPedidoAsistidoConstantes.CODIGO_VALOR_TIPO_PEDIDO_ASISTIDO);
			}		

			PedidoAsistidoVO pedidoAsistidoVO = new PedidoAsistidoVO();
			
			pedidoAsistidoVO.setScheduler(scheduler);
			
			pedidoAsistidoVO.setBaseDTO(new PedidoAreaTrabajoDTO());
			pedidoAsistidoVO.getBaseDTO().setPedidoInformacion(new PedidoAreaTrabajoInformacionDTO());			
			pedidoAsistidoVO.setUserId(this.idUsuario);
			pedidoAsistidoVO.setCodigoBodegaSubbodega(codigoSubbodegaBodega);
			pedidoAsistidoVO.setCodigoATBodegaSel(codigoBodega);
			
			
			// PedidoAreaTrabajoDTO
			pedidoAsistidoVO.getBaseDTO().getId().setCodigoCompania(1);
			pedidoAsistidoVO.getBaseDTO().setCantidadTotalPedida(0);
			pedidoAsistidoVO.getBaseDTO().setCantidadTotalReservada(0);
			pedidoAsistidoVO.getBaseDTO().setCantidadTotalDespachada(0);
			pedidoAsistidoVO.getBaseDTO().setCantidadTotalItems(0);
			pedidoAsistidoVO.getBaseDTO().setCantidadTotalVolumen(new BigDecimal(0));
			pedidoAsistidoVO.getBaseDTO().setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			pedidoAsistidoVO.getBaseDTO().setUserId(this.idUsuario);
			pedidoAsistidoVO.getBaseDTO().setIdUsuarioRegistro(this.idUsuario);
			pedidoAsistidoVO.getBaseDTO().setFechaRegistro(new Date());

			// PedidoAreaTrabajoInformacionDTO
			pedidoAsistidoVO.getBaseDTO().setPedidoInformacion(new PedidoAreaTrabajoInformacionDTO());
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().getId().setCodigoCompania(this.codigoCompania);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setCodigoAreaTrabajoCentroDistribucion(codigoCd);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setCodigoAreaTrabajoSubbodega(codigoSubb);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setCodigoAreaTrabajoPedido(this.codigoLocal);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setHoraMaximaPedido(horaMaximaTransmision);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setFechaPedido(fechaPedido);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setFechaDespacho(fechaDespacho);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setFechaRecepcion(fechaRecepcion);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setUserId(this.idUsuario);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setIdUsuarioRegistro(this.idUsuario);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setFechaRegistro(new Date());		
			
			pedidoAsistidoVO
					.getBaseDTO()
					.getPedidoInformacion()
					.setAreaTrabajoPedido(this.areaTrabajoLocal);

			// tipo pedido
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setCodigoTipoPedidoCatalogoTipo(tipoPedidoInicial.getId().getCodigoCatalogoTipo());
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setCodigoTipoPedidoCatalogoValor(tipoPedidoInicial.getId().getCodigoCatalogoValor());

			// PedidoAreaTrabajoEstadoDTO
			if (pedidoAsistidoVO.getBaseDTO().getPedidoAreaTrabajoEstado() == null) {
				pedidoAsistidoVO.getBaseDTO().setPedidoAreaTrabajoEstado(new PedidoAreaTrabajoEstadoDTO());
			}
			pedidoAsistidoVO.getBaseDTO().getPedidoAreaTrabajoEstado()
					.setCodigoEstadoCatalogoValor(SICPedidoAsistidoConstantes.CODIGO_VALOR_ESTADO_PEDIDO_SIN_PEDIDO);
			
			

			/** creacion del pedido asistido padre **/
			SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoAlmacenamientoServicio().generarNuevoEstadoPedidoAsistido(
					pedidoAsistidoVO, SICPedidoAsistidoConstantes.CODIGO_VALOR_ACCION_PEDIDO_CREAR);		
			
			
			/**Para obtencion de detalles*/
			pedidoAsistidoVO.getBaseDTO().setPedidoPadre(new PedidoAreaTrabajoDTO());
			pedidoAsistidoVO.getBaseDTO().getPedidoPadre().setPedidoInformacion(new PedidoAreaTrabajoInformacionDTO());
			pedidoAsistidoVO.getBaseDTO().getPedidoPadre().getPedidoInformacion().setAreaTrabajoPedido(new AreaTrabajoDTO());	
			pedidoAsistidoVO.getBaseDTO().getPedidoPadre().getPedidoInformacion().getAreaTrabajoPedido().setTipoAreaTrabajoValor("LOC");
			pedidoAsistidoVO.getBaseDTO().getPedidoPadre().getPedidoInformacion().setCodigoAreaTrabajoPedido(this.codigoLocal);
			pedidoAsistidoVO.setNumeroDiasArticuloNuevo(SICPedidoAsistidoMessages.getInstancia()
					.getInteger("ec.com.smx.sic.pedidoAsistido.numeroDiasNuevo"));
			pedidoAsistidoVO.setNumeroDiasArticuloAlcance(SICPedidoAsistidoMessages.getInstancia()
					.getInteger("ec.com.smx.sic.pedidoAsistido.numeroDiasAlcance"));
			pedidoAsistidoVO.setLlenarCantidadPedida(Boolean.FALSE);

			pedidoAsistidoVO.setFrecuenciaRotacion("diario");	
			
			
			
			/** Gestionar clasificaciones */
			clasificacionesCol = pedidoAsistidoVO.getBaseDTO().getPedidoAreaTrabajoClasificacionCol();

			PedidoAreaTrabajoClasificacionDTO clasificacionSel = new PedidoAreaTrabajoClasificacionDTO();
			Integer index = 1;

			for (PedidoAreaTrabajoClasificacionDTO clasificacionDTO : clasificacionesCol) {
				if (index.equals(1)) {
					clasificacionSel = clasificacionDTO;

				}
				clasificacionMap = new HashMap<String, Object>();
				clasificacionMap.put("idClasif", clasificacionDTO.getId().getCodigoClasificacion());
				clasificacionMap.put("descripcion", clasificacionDTO.getDescripcionClasificacion());
				clasificacionMap.put("totalArt", clasificacionDTO.getTotalArticulos());
				clasificacionMap.put("totalRev", clasificacionDTO.getTotalArticulosRevisados());
				clasificacionMap.put("totalPed", clasificacionDTO.getTotalArticulosPedidos());

				clasificacionesColMap.add(clasificacionMap);
				index++;
			}

			detallesCol.put("clasificaciones", clasificacionesColMap);

			// Actualizar de acuerdo al pedido
			if (tipoCreacionPedido.equals("asistido")) {

				// Obtener cantidades maximas de articulo por local
				Long codigoPedidoPadre = pedidoAsistidoVO.getBaseDTO().getPedidoPadre().getId().getCodigoPedidoAreaTrabajo();
				Collection<Map<String, Object>> articulosRef = SICFactory.getInstancia().pedidoAsistido
						.getPedidoAsistidoCalculoServicio()
						.obtenerCantidadMaximaPorArticuloLocalWS(this.codigoLocal,codigoPedidoPadre);

				if (CollectionUtils.isNotEmpty(articulosRef)) {
					detallesCol.put("articulosReferencia", articulosRef);

				}

				pedidoAsistidoVO.setClasificacionSelect(clasificacionSel);

				pedidoAsistidoVO.getBaseDTO()
						.setPedidoAreaTrabajoDetalleCol(new ArrayList<PedidoAreaTrabajoDetalleDTO>());
				SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoCalculoServicio()
						.obtenerDetallesPedidoAsistido(pedidoAsistidoVO);

				for (PedidoAreaTrabajoDetalleDTO pedidoAreaTrabajoDetalleDTO : pedidoAsistidoVO.getBaseDTO()
						.getPedidoAreaTrabajoDetalleCol()) {
					articuloMap = new HashMap<String, Object>();
					articuloMap.put("idArticulo", pedidoAreaTrabajoDetalleDTO.getCodigoArticulo());
					articuloMap.put("descripcion", pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO()
							.getArticulo().getDescripcionArticulo());
					articuloMap.put("articuloMarcado",
							pedidoAreaTrabajoDetalleDTO.getDynamicProperty("articuloMarcado"));
					articuloMap.put("tieneVariasUM", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("tieneVariasUM"));
					articuloMap.put("articuloRelacionado",
							pedidoAreaTrabajoDetalleDTO.getDynamicProperty("articuloRelacionado"));
					articuloMap.put("anomaliaValor", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("anomaliaValor"));
					articuloMap.put("codBarras", pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getArticulo()
							.getCodigoBarrasActivo().getId().getCodigoBarras());
					articuloMap.put("unidadManejo",
							pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getValorUnidadManejo());
					articuloMap.put("marca",
							pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getArticulo()
									.getTieneArticuloComercial()
											? pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getArticulo()
													.getArticuloComercialDTO().getMarcaComercialArticulo().getNombre()
											: "");
					articuloMap.put("exiCd", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("exiCd"));
					articuloMap.put("exiLoc", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("exiLoc"));
					articuloMap.put("ventaAyer", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("sugerido"));
					articuloMap.put("proyeccion", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("sugerido"));
					articuloMap.put("volumen", pedidoAreaTrabajoDetalleDTO.getArticuloUnidadManejoDTO().getCubicaje());
					articuloMap.put("cantidadPedida", pedidoAreaTrabajoDetalleDTO.getCantidadPedida());
					articuloMap.put("cantidadReservada", pedidoAreaTrabajoDetalleDTO.getCantidadReservada());
					articuloMap.put("promedioRot", pedidoAreaTrabajoDetalleDTO.getPromedioRotacion());
					articuloMap.put("rotacion1", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion1"));
					articuloMap.put("rotacion2", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion2"));
					articuloMap.put("rotacion3", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion3"));
					articuloMap.put("rotacion4", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion4"));
					articuloMap.put("rotacion5", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion5"));
					articuloMap.put("rotacion6", pedidoAreaTrabajoDetalleDTO.getDynamicProperty("rotacion6"));
					articulosCol.add(articuloMap);
				}
				detallesCol.put("articulos", articulosCol);

			}
			String retorno = "";

			retorno = JsonPojoMapper.getInstance().writeValueAsString(detallesCol);
			
			return new ResponseEntity<String>(retorno, createHttpHeaders(), HttpStatus.OK);
			
			
		} catch (ParseException e) {
			Logeable.LOG_SICV2.info("Error al crear pedido por primera vez", e.getCause());
			throw new SICException("Error al crear pedido por primera vez");
		} catch (SICException se) {
			throw new SICException(se.getMessage());
		}
	}

}
