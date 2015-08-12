package ec.com.smx.sic.webservices.pedidoAsistido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
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
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.LocalDTO;
import ec.com.smx.corpv2.dto.id.AreaTrabajoID;
import ec.com.smx.framework.ad.json.JsonPojoMapper;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.pedidoAsistido.ComparadorPerfilUtil;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoInformacionDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaAreaTrabajoEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaPedidoAsistidoWS;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.EstructuraConfiguracionPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;


@Controller
@Scope(value = "request")
public class PedidoAsistidoFiltrosWebService {

	private DatosBusquedaPedidoAsistidoWS datosBusquedaPedidoAsistidoWS;
	private AreaTrabajoDTO areaTrabajoLocal;
	/** CD actual en el ciclo */
	AreaTrabajoDTO cdActual;
	Boolean tipoApertura;
	String perfil = "98";
	String codFuncionario = "51304";
	String idUsuario = "USR16321";
	Integer codigoLocal = 711;


	private HttpHeaders createHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/jsonp; charset=utf-8");
		responseHeaders.add("Access-Control-Allow-Origin", "*");
		return responseHeaders;
	}

	@RequestMapping(value = "/datosGenerales", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findCDsFuncConf() throws JsonProcessingException {

		/** Para retorno JSON **/
		Map<String, Object> datosCDsJSON = new HashMap<String, Object>();
		String retorno = "";

		/* Para busqueda de CDs por asignados a usuario y en configuracion **/
		this.datosBusquedaPedidoAsistidoWS = new DatosBusquedaPedidoAsistidoWS();
		this.areaTrabajoLocal = new AreaTrabajoDTO();
		areaTrabajoLocal.setId(new AreaTrabajoID());
		areaTrabajoLocal.getId().setCodigoAreaTrabajo(codigoLocal);
		areaTrabajoLocal.getId().setCodigoCompania(1);
		areaTrabajoLocal.setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL);
		areaTrabajoLocal.setTipoAreaTrabajoTIC(TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		this.tipoApertura = this.validarCreacionTipoPedido(areaTrabajoLocal);

		try {

			
			String perfilUsuario = ComparadorPerfilUtil.verificarPerfil(this.perfil);

			SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoCalculoServicio()
			.inicializarDatosBusquedaAreaTrabajoWS(1, this.codFuncionario, this.idUsuario, this.perfil,
					this.datosBusquedaPedidoAsistidoWS, this.areaTrabajoLocal);

			/** Armando el JSON */
			Map<String, Object> datosCDMap = null;
			Map<String, Object> datosSubbodegaMap = null;
			Collection<Map<String, Object>> datosCDCol = new ArrayList<Map<String, Object>>();
			Collection<Map<String, Object>> datosSubbodegaCol = new ArrayList<Map<String, Object>>();
			EstructuraConfiguracionPedidoAsistidoVO estructuraConfiguracionDia = null;
			Date fechaPedido = new Date();
			int id = 0;

			// recorremos CD validos
			for (AreaTrabajoDTO aretraDTO : this.datosBusquedaPedidoAsistidoWS.getCdsUsuarioCollection()) {
				this.cdActual = aretraDTO;
				datosSubbodegaCol = new ArrayList<Map<String, Object>>();
				LinkedHashSet<AreaSublugarTrabajoDTO> subbodegas = new LinkedHashSet<AreaSublugarTrabajoDTO>();
				datosCDMap = new HashMap<String, Object>();
				id++;
				datosCDMap.put("id", id);
				datosCDMap.put("codigoAreTra", aretraDTO.getId().getCodigoAreaTrabajo());
				datosCDMap.put("nombreAreTra",
						aretraDTO.getCodigoReferencia() + " - " + aretraDTO.getNombreAreaTrabajo());
				if (aretraDTO.getId().getCodigoAreaTrabajo()
						.equals(this.datosBusquedaPedidoAsistidoWS.getCdDefault())) {
					datosCDMap.put("selected", Boolean.TRUE);

				}

				// Obtiene subbodegas del CD actual
				subbodegas = getSubbodegasCD(this.cdActual);
//				subbodegas = (HashSet<AreaSublugarTrabajoDTO>) ColeccionesUtil.sort(subbodegas, ColeccionesUtil.ORDEN_ASC, "subLugarTrabajoDTO.nombreAreaTrabajo");
				
				
				if (CollectionUtils.isNotEmpty(subbodegas)) {
					Integer idSubbodega = 1;
					for (AreaSublugarTrabajoDTO areaSublugarTrabajoDTO : subbodegas) {
						
						AreaTrabajoDTO areaTrabajo= areaSublugarTrabajoDTO.getSubLugarTrabajoDTO();

						datosSubbodegaMap = new HashMap<String, Object>();
						datosSubbodegaMap.put("id", areaTrabajo.getId().getCodigoAreaTrabajo());
						datosSubbodegaMap.put("nombreSubbodega",
								areaTrabajo.getCodigoReferencia() + "-" + areaTrabajo.getNombreAreaTrabajo());						
						datosSubbodegaMap.put("codigoAreTraBodega", areaSublugarTrabajoDTO.getId().getCodigoAreaTrabajo());

						if (idSubbodega.equals(1)) {
							datosSubbodegaMap.put("selected", Boolean.TRUE);

							// Valida configuracion de la primera subbodega
							if (cdActual.getId().getCodigoAreaTrabajo()
									.equals(this.datosBusquedaPedidoAsistidoWS.getCdDefault())) {
								estructuraConfiguracionDia = validarConfiguracionBodega(this.cdActual, areaTrabajo,
										1, fechaPedido, this.areaTrabajoLocal, this.tipoApertura);
								if (estructuraConfiguracionDia != null) {

									/** Primero chequea bloqueo */
									boolean bloqueo = Boolean.FALSE;

									Integer diaSemanaComponente = fechaPedido.getDay() + 1;

									if (estructuraConfiguracionDia.getCodigoTipoBloqueo() != null) {
										Long tiempoPedido = fechaPedido.getTime();
										Long tiempoInicial = estructuraConfiguracionDia.getDetalleDiaBloqueoPedido()
												.getAreaTrabajoCalendarioProcesoDetalleDTO().getFechaInicioBloqueo()
												.getTime();
										Long tiempoFinal = estructuraConfiguracionDia.getDetalleDiaBloqueoPedido()
												.getAreaTrabajoCalendarioProcesoDetalleDTO().getFechaFinBloqueo()
												.getTime();

										if (diaSemanaComponente == estructuraConfiguracionDia
												.getDetalleDiaBloqueoPedido()
												.getAreaTrabajoCalendarioProcesoDetalleDTO().getCodigoDiaSemana()
												.intValue()) {
											if (tiempoPedido >= tiempoInicial && tiempoPedido <= tiempoFinal) {
												datosSubbodegaMap.put("bloqueo", Boolean.TRUE);
												bloqueo = Boolean.TRUE;

											}
										}
									}
									/** Si no bloqueo escribe config en JSON */
									if (!bloqueo) {
										datosSubbodegaMap.put("valida", Boolean.TRUE);
										datosSubbodegaMap.put("fechaDes", this.calcularFechaPedido(
												estructuraConfiguracionDia.getCodigoDiaDespacho()));
										datosSubbodegaMap.put("fechaRec", this.calcularFechaPedido(
												estructuraConfiguracionDia.getCodigoDiaRecepcion()));
										datosSubbodegaMap.put("horaConf",
												estructuraConfiguracionDia.getHoraMaximaTransmisionText());

									}

								} else {
									datosSubbodegaMap.put("valida", Boolean.FALSE);
								}

							}
						} else
							datosSubbodegaMap.put("selected", Boolean.FALSE);

						idSubbodega++;
						datosSubbodegaCol.add(datosSubbodegaMap);

					}
					datosCDMap.put("subbodegas", datosSubbodegaCol);
				} else
					datosCDMap.put("subbodegas", "");

				datosCDCol.add(datosCDMap);
			}
			// datosTempJSON = gson.toJson(datosCDCol);
			datosCDsJSON.put("id", 1);
			datosCDsJSON.put("codigoRetorno", Boolean.TRUE);
			datosCDsJSON.put("datosCDs", datosCDCol);
			datosCDsJSON.put("errorMessage", "");
			datosCDsJSON.put("apertura", this.tipoApertura);
			datosCDsJSON.put("perfil", perfilUsuario);

		} catch (SICException se) {
			datosCDsJSON.put("id", 0);
			datosCDsJSON.put("codigoRetorno", Boolean.FALSE);
			datosCDsJSON.put("datosCDs", "");
			datosCDsJSON.put("errorMessage", se.getMessage());
			Logeable.LOG_SICV2.info("error: {}", se);
		}

		retorno = JsonPojoMapper.getInstance().writeValueAsString(datosCDsJSON);
		Logeable.LOG_SICV2.info("datos cds: {}", retorno);
		return new ResponseEntity<String>(retorno, createHttpHeaders(), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	public LinkedHashSet<AreaSublugarTrabajoDTO> getSubbodegasCD(final AreaTrabajoDTO cdActual) {
		LinkedHashSet<AreaSublugarTrabajoDTO> subbodegas = new LinkedHashSet<AreaSublugarTrabajoDTO>();
		Collection<AreaSublugarTrabajoDTO> subbodegasCol = null;

		Collection<AreaSublugarTrabajoDTO> bodegas = this.datosBusquedaPedidoAsistidoWS.getBodegasUsuarioCollection();

		// Bodegas del CD
		Collection<AreaSublugarTrabajoDTO> bodegasCol = null;
		if (CollectionUtils.isNotEmpty(bodegas)) {
			bodegasCol = CollectionUtils.select(bodegas, new Predicate() {
				@Override
				public boolean evaluate(Object object) {
					AreaSublugarTrabajoDTO bodegaAST = (AreaSublugarTrabajoDTO) object;
					if (bodegaAST.getId().getCodigoAreaTrabajo().intValue() == cdActual.getId()
							.getCodigoAreaTrabajo()) {
						return true;
					} else {
						return false;
					}
				}
			});

			// Eliminar de coleccion de bodegas las del CD actual
			bodegas = CollectionUtils.removeAll(bodegas, bodegasCol);

			// Subbodegas relacionadas a bodegas del CD
			
			if (CollectionUtils.isNotEmpty(this.datosBusquedaPedidoAsistidoWS.getSubbodegasUsuarioCollection())
					&& CollectionUtils.isNotEmpty(bodegasCol)) {

				// codigoAreaSublugarTrabajo de las bodegas encontradas
				final Collection<Integer> codigoAreaTrabajoBodCol = CollectionUtils.collect(bodegasCol,
						new GetInvokerTransformer("id.codigoAreaSublugarTrabajo"));

				subbodegasCol = CollectionUtils
						.select(this.datosBusquedaPedidoAsistidoWS.getSubbodegasUsuarioCollection(), new Predicate() {
							@Override
							public boolean evaluate(Object object) {
								AreaSublugarTrabajoDTO subbodegaAST = (AreaSublugarTrabajoDTO) object;

								for (Integer codigoAreaTrabajo : codigoAreaTrabajoBodCol) {
									if (subbodegaAST.getId().getCodigoAreaTrabajo().intValue() == codigoAreaTrabajo) {
										return true;
									}
								}
								return false;
							}
						});

				// Add areaSublugarTrabajoDTO de subbodega
//				if (CollectionUtils.isNotEmpty(subbodegasCol)) {
//					for (AreaSublugarTrabajoDTO areaSublugarTrabajoDTO : subbodegasCol) {
//						subbodegas.add(areaSublugarTrabajoDTO);
//					}
//				}

			}

		}
		subbodegas = new LinkedHashSet<AreaSublugarTrabajoDTO>(subbodegasCol) ;
		return subbodegas;

	}

	/**
	 * 
	 * @param argNumDiaConfigurado
	 * @return String
	 */
	public String calcularFechaPedido(Integer argNumDiaConfigurado) {

		// 1 Domingo , 2 Lunes,... , 7 Sabado

		Calendar calendarActual = new GregorianCalendar();
		// calendarActual = Calendar.getInstance();
		String fechaConfigurada = null;

		int numDiaSemActual = calendarActual.get(Calendar.DAY_OF_WEEK);
		int numDiaConfigurado = argNumDiaConfigurado.intValue();

		int diferencia = 0;

		diferencia = numDiaConfigurado - numDiaSemActual;

		if (diferencia > 0) {
			calendarActual.add(Calendar.DAY_OF_YEAR, diferencia);
		} else if (diferencia < 0) {
			calendarActual.add(Calendar.DAY_OF_YEAR, numDiaConfigurado);
		}

		Date calendarActualDate = calendarActual.getTime();

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		fechaConfigurada = formatoFecha.format(calendarActualDate);

		return fechaConfigurada;
	}

	/**
	 * 
	 * @param areaTrabajoPedido
	 * @return Boolean
	 */
	private Boolean validarCreacionTipoPedido(AreaTrabajoDTO areaTrabajoPedido) {

		LocalDTO localDTO = null;
		Boolean esApertura = Boolean.FALSE;

		try {
			// Validar tipo de area de trabajo de usuario logueado : TIPO LOCAL
			if (areaTrabajoPedido != null
					&& areaTrabajoPedido.getTipoAreaTrabajoValor().equals(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL)
					&& areaTrabajoPedido.getTipoAreaTrabajoTIC()
					.intValue() == TiposCatalogoConstantes.TIPO_AREA_TRABAJO) {

				// Validar estado operativo del local
				localDTO = SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoCalculoServicio()
						.obtenerEstadoOperativoLocal(areaTrabajoPedido);

				// Local en operacion
				if (localDTO != null && localDTO.getEstadoOperativo() != null
						&& localDTO.getEstadoOperativo()
						.equals(CorporativoConstantes.TIPO_ESTADO_OPERATIVO_LOCAL_APERTURA)
						&& localDTO.getEstadoOperativoTIC()
						.intValue() == TiposCatalogoConstantes.TIPO_ESTADOS_OPERATIVO_LOCAL) {
					esApertura = Boolean.TRUE;
				}
			}

		} catch (SICException se) {
			Logeable.LOG_SICV2.info("Error al validar creacion tipo pedido {} ", se);
		}

		return esApertura;
	}

	/**
	 * Metodo para validar configuracion de la subbodega
	 * 
	 * @param cd
	 * @param subbodega
	 * @param codigoCompania
	 * @param fechaPedido
	 * @return EstructuraConfiguracionPedidoAsistidoVO
	 */
	@SuppressWarnings("deprecation")
	public EstructuraConfiguracionPedidoAsistidoVO validarConfiguracionBodega(AreaTrabajoDTO cd,
			AreaTrabajoDTO subbodega, Integer codigoCompania, Date fechaPedido, AreaTrabajoDTO local,
			Boolean tipoApertura) {

		// fecha del componente
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaPedido);
		int diaSemanaActual = calendar.get(Calendar.DAY_OF_WEEK);
		EstructuraConfiguracionPedidoAsistidoVO ecpaHoraTransmision = null;

		// Plantilla
		ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO = null;
		configuracionPedidoAsistidoVO = new ConfiguracionPedidoAsistidoVO();
		configuracionPedidoAsistidoVO.setBaseDTO(new AreaTrabajoCalendarioProcesoDTO());
		configuracionPedidoAsistidoVO.getBaseDTO().getId().setCodigoCompania(codigoCompania);
		configuracionPedidoAsistidoVO.setDatosBusquedaAreaTrabajoEST(new DatosBusquedaAreaTrabajoEST());
		configuracionPedidoAsistidoVO.getDatosBusquedaAreaTrabajoEST().setSubbodegaSelect(subbodega);
		configuracionPedidoAsistidoVO.getDatosBusquedaAreaTrabajoEST().setCentroDistribucionSelect(cd);
		configuracionPedidoAsistidoVO.getDatosBusquedaAreaTrabajoEST().setLocalSelect(local);

		if (!tipoApertura) {
			ecpaHoraTransmision = SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoCalculoServicio()
					.buscarConfiguracionDiaAreaTrabajo(configuracionPedidoAsistidoVO, diaSemanaActual);
		}

		return ecpaHoraTransmision;
	}

	/** Validar configuracion para datos seleccionados */
	@RequestMapping(value = "/validaConfig", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findValidarSubbodega(
			@RequestParam(value = "fechaPedido", required = true) String fechaPedido,
			@RequestParam(value = "codigoSubbodega", required = true) String codigoSubbodega,
			@RequestParam(value = "codigoCD", required = true) String codigoCD)
					throws JsonProcessingException, ParseException {

		String retorno = "";
		Map<String, Object> configuracionBodega = new HashMap<String, Object>();
		EstructuraConfiguracionPedidoAsistidoVO ecpaHoraTransmision = null;

		try {
			AreaTrabajoDTO cd = new AreaTrabajoDTO();
			cd.setId(new AreaTrabajoID());
			cd.getId().setCodigoAreaTrabajo(Integer.parseInt(codigoCD));
			cd.getId().setCodigoCompania(1);

			AreaTrabajoDTO subbodega = new AreaTrabajoDTO();
			subbodega.setId(new AreaTrabajoID());
			subbodega.getId().setCodigoAreaTrabajo(Integer.parseInt(codigoSubbodega));
			subbodega.getId().setCodigoCompania(1);

			AreaTrabajoDTO local = new AreaTrabajoDTO();
			local.setId(new AreaTrabajoID());
			local.getId().setCodigoAreaTrabajo(711);
			local.getId().setCodigoCompania(1);
			local.setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL);
			local.setTipoAreaTrabajoTIC(TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
			Date fecha = formatoFecha.parse(fechaPedido);
			ecpaHoraTransmision = this.validarConfiguracionBodega(cd, subbodega, 1, fecha, local, false);

			if (ecpaHoraTransmision != null) {
				/** Primero chequea bloqueo */
				boolean bloqueo = Boolean.FALSE;

				Integer diaSemanaComponente = fecha.getDay() + 1;

				if (ecpaHoraTransmision.getCodigoTipoBloqueo() != null) {
					Long tiempoPedido = fecha.getTime();
					Long tiempoInicial = ecpaHoraTransmision.getDetalleDiaBloqueoPedido()
							.getAreaTrabajoCalendarioProcesoDetalleDTO().getFechaInicioBloqueo().getTime();
					Long tiempoFinal = ecpaHoraTransmision.getDetalleDiaBloqueoPedido()
							.getAreaTrabajoCalendarioProcesoDetalleDTO().getFechaFinBloqueo().getTime();

					if (diaSemanaComponente == ecpaHoraTransmision.getDetalleDiaBloqueoPedido()
							.getAreaTrabajoCalendarioProcesoDetalleDTO().getCodigoDiaSemana().intValue()) {
						if (tiempoPedido >= tiempoInicial && tiempoPedido <= tiempoFinal) {
							configuracionBodega.put("bloqueo", Boolean.TRUE);
							bloqueo = Boolean.TRUE;

						}
					}
				}
				if (!bloqueo) {
					configuracionBodega.put("valida", Boolean.TRUE);
					configuracionBodega.put("fechaDes",
							this.calcularFechaPedido(ecpaHoraTransmision.getCodigoDiaDespacho()));
					configuracionBodega.put("fechaRec",
							this.calcularFechaPedido(ecpaHoraTransmision.getCodigoDiaRecepcion()));
					configuracionBodega.put("horaConf", ecpaHoraTransmision.getHoraMaximaTransmisionText());

				}

			} else {
				configuracionBodega.put("subbodegaValida", Boolean.FALSE);
			}

			HttpHeaders headers = new HttpHeaders();

			headers.add("Content-Type", "text/html; charset=utf-8");
			retorno = JsonPojoMapper.getInstance().writeValueAsString(configuracionBodega);
			return new ResponseEntity<String>(retorno, createHttpHeaders(), HttpStatus.OK);

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al validar configuracion {}.", e);
			throw new SICException(e);
		}

	}

	/**Metodo que obtiene los pedidos del dia*/
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/pedidoDia", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findPedidoDia(
			@RequestParam(value = "fechaPedido", required = true) String fechaPedido,
			@RequestParam(value = "codigoSubbodega", required = true) String codigoSubbodega,
			@RequestParam(value = "codigoCD", required = true) String codigoCD)
					throws JsonProcessingException, ParseException {

		String retorno = "";
		Collection<Map<String, Object>> pedidosPadresCol = new ArrayList<Map<String, Object>>();

		Map<String, Object> datosPedidosDiaMap = null;
		Map<String, Object> datosPedidosDiaHijosMap = null;

		Collection<PedidoAreaTrabajoDTO> pedidosHijosDia = null;

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha = formatoFecha.parse(fechaPedido);

		try {
			PedidoAsistidoVO pedidoAsistidoVO = new PedidoAsistidoVO();
			pedidoAsistidoVO.setBaseDTO(new PedidoAreaTrabajoDTO());
			pedidoAsistidoVO.getBaseDTO().setPedidoInformacion(new PedidoAreaTrabajoInformacionDTO());
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().getId().setCodigoCompania(1);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setCodigoAreaTrabajoPedido(711);
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion()
			.setCodigoAreaTrabajoCentroDistribucion(Integer.parseInt(codigoCD));
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion()
			.setCodigoAreaTrabajoSubbodega(Integer.parseInt(codigoSubbodega));
			pedidoAsistidoVO.getBaseDTO().getPedidoInformacion().setFechaPedido(fecha);

			pedidosHijosDia = SICFactory.getInstancia().pedidoAsistido.getPedidoAsistidoCalculoServicio()
					.obtenerPedidoAreaTrabajoCreadosCriteria(pedidoAsistidoVO);

			if (CollectionUtils.isNotEmpty(pedidosHijosDia)) {

				@SuppressWarnings("unchecked")
				Collection<PedidoAreaTrabajoDTO> pedidosPadres = CollectionUtils.collect(pedidosHijosDia,
						new GetInvokerTransformer("pedidoPadre"));
				pedidosPadres = new HashSet<PedidoAreaTrabajoDTO>(pedidosPadres);

				for (PedidoAreaTrabajoDTO pedidoAreaTrabajoDTO : pedidosPadres) {
					datosPedidosDiaMap = new HashMap<String, Object>();
					datosPedidosDiaMap.put("numeroPedido",
							pedidoAreaTrabajoDTO.getPedidoInformacion().getNumeroPedido());
					datosPedidosDiaMap.put("subbodega",
							pedidoAreaTrabajoDTO.getPedidoInformacion().getAreaTrabajoSubbodega().getCodigoReferencia()
							+ "-" + pedidoAreaTrabajoDTO.getPedidoInformacion().getAreaTrabajoSubbodega()
							.getNombreAreaTrabajo());
					datosPedidosDiaMap.put("tipoPedido",
							pedidoAreaTrabajoDTO.getPedidoInformacion().getCodigoTipoPedidoCatalogoValor());
					datosPedidosDiaMap.put("horaConfig",
							pedidoAreaTrabajoDTO.getPedidoInformacion().getHoraMaximaPedido());
					datosPedidosDiaMap.put("fechaPedido",
							formatoFecha.format(pedidoAreaTrabajoDTO.getPedidoInformacion().getFechaPedido()));
					datosPedidosDiaMap.put("fechaDespacho",
							formatoFecha.format(pedidoAreaTrabajoDTO.getPedidoInformacion().getFechaDespacho()));
					datosPedidosDiaMap.put("fechaRecepcion",
							formatoFecha.format(pedidoAreaTrabajoDTO.getPedidoInformacion().getFechaRecepcion()));
					datosPedidosDiaMap.put("estadoPedido",
							pedidoAreaTrabajoDTO.getPedidoAreaTrabajoEstado().getCodigoEstadoCatalogoValor());
					datosPedidosDiaMap.put("usuario",
							pedidoAreaTrabajoDTO.getPedidoInformacion().getUsuarioRegistroDTO().getUserName());
					datosPedidosDiaMap.put("idPedPadre", pedidoAreaTrabajoDTO.getId().getCodigoPedidoAreaTrabajo());
					datosPedidosDiaMap.put("cantTotalVolumen", pedidoAreaTrabajoDTO.getCantidadTotalVolumen());

					@SuppressWarnings({ "unused", "unchecked" })
					Collection<PedidoAreaTrabajoDTO> pedidosHijos = CollectionUtils.select(pedidosHijosDia,
							PredicateUtils.transformedPredicate(
									new GetInvokerTransformer("pedidoPadre.id.codigoPedidoAreaTrabajo"),
									PredicateUtils.equalPredicate(
											pedidoAreaTrabajoDTO.getId().getCodigoPedidoAreaTrabajo())));
					Collection<Map<String, Object>> pedidosHijosCol = new ArrayList<Map<String, Object>>();
					for (PedidoAreaTrabajoDTO pedidoHijoAreaTrabajoDTO : pedidosHijos) {
						if (pedidoHijoAreaTrabajoDTO.getIdUsuarioRegistro().equals(this.idUsuario)) {
							datosPedidosDiaHijosMap = new HashMap<String, Object>();
							datosPedidosDiaHijosMap.put("idPedHijo",
									pedidoHijoAreaTrabajoDTO.getId().getCodigoPedidoAreaTrabajo());
							datosPedidosDiaHijosMap.put("estadoPedidoHijo", pedidoHijoAreaTrabajoDTO
									.getPedidoAreaTrabajoEstado().getCodigoEstadoCatalogoValor());
							datosPedidosDiaHijosMap.put("idUsuarioRegistro",
									pedidoHijoAreaTrabajoDTO.getIdUsuarioRegistro());
							datosPedidosDiaHijosMap.put("cantTotalPedida",
									pedidoHijoAreaTrabajoDTO.getCantidadTotalPedida());
							datosPedidosDiaHijosMap.put("cantTotalReservada",
									pedidoHijoAreaTrabajoDTO.getCantidadTotalReservada());
							datosPedidosDiaHijosMap.put("cantTotalItems",
									pedidoHijoAreaTrabajoDTO.getCantidadTotalItems());
							datosPedidosDiaHijosMap.put("cantTotalVolumen",
									pedidoHijoAreaTrabajoDTO.getCantidadTotalVolumen());
							pedidosHijosCol.add(datosPedidosDiaHijosMap);
							
							break;
						}

					}

					datosPedidosDiaMap.put("pedidosHijos", pedidosHijosCol);
					pedidosPadresCol.add(datosPedidosDiaMap);
				}

			}

			else {
				pedidosPadresCol.add(datosPedidosDiaMap);
			}

			retorno = JsonPojoMapper.getInstance().writeValueAsString(pedidosPadresCol);

			return new ResponseEntity<String>(retorno, createHttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error en obtener pedidos del dia {}.", e);
			throw new SICException(e);
		}

	}




}
