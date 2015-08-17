/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.validacion;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearch;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.validator.Validator;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICCodigosError;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumMensajePasosCreacionArticulo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloValidacion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.validacion.IValidacionUnidadManejoGestor;
import ec.com.smx.sic.cliente.gestor.recargacupon.ICuponGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloTemporadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RangoSecuenciaCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.nopersistente.CantidadCuponLocal;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloLocalDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author fmunoz
 *
 */

public class ValidacionArticuloGestor implements Logeable, IValidacionArticuloGestor{

	private DataGestor dataGestor;
	private IArticuloLocalDAO articuloLocalDAO;
	private IValidacionUnidadManejoGestor validacionUnidadManejoGestor;
	private ICuponGestor cuponGestor;
	
	/**
	 * Realiza la validación de los datos del articulo
	 * @param articuloVO
	 */
	@Override
	public void validarConsistenciaDatos(ArticuloDTO articuloDTO)throws SICRuleException{
		try{
			if(articuloDTO.getCodigoBarrasActivo().getCodigoTipoCodigoArticulo() == null){
				throw new SICRuleException(SICArticuloMessages.getInstancia().getString("mensaje.error.tipoArticulo.requerido"));}
			if(articuloDTO.getCodigoBarrasActivo().getCodigoTipoCodigoArticulo().equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO)
					&& !SICArticuloConstantes.getInstancia().TIPSECART_PESOFIJO.equals(articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia())
					&& !SICArticuloConstantes.getInstancia().TIPSECART_PESOPRECIO.equals(articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia())
					&& !SICArticuloConstantes.getInstancia().TIPSECART_CUPONELECTRONICO.equals(articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia())
					&& !SICArticuloConstantes.getInstancia().TIPSECART_CUPONESPECIAL.equals(articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia())
					&& !SICArticuloConstantes.getInstancia().TIPSECART_AUTOLIQUIDABLE.equals(articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia())
					&& !SICArticuloConstantes.getInstancia().TIPSECART_MAXICOMBO.equals(articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia())){
				throw new SICRuleException(SICArticuloMessages.getInstancia().getString("mensaje.error.secuenciaInterna.noValido"));
			}
		}catch (SICRuleException e) {
			throw e;
		}catch (Exception e) {
			throw new SICRuleException(e);
		}
	}
	
	public void validarDatosArticuloCupon(ArticuloVO articuloVO)throws SICException{
		if(SICArticuloConstantes.getInstancia().TIPSECART_CUPONESPECIAL.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getValorTipoSecuencia())
				&& !articuloVO.getBaseDTO().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO)){
			//se realiza la validacion de la cantidad maxima de cupones
			validarCantidadMaximaCuponesActivosLocal(articuloVO);
			//verificar la modificación del estado del cupón
			if(articuloVO.getBaseDTOAnterior() != null && ((SICArticuloConstantes.getInstancia().ESTADOARTICULO_VIGENTE.equals(articuloVO.getBaseDTOAnterior().getCodigoEstado())
					&& SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO.equals(articuloVO.getBaseDTO().getCodigoEstado()))
					|| (SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(articuloVO.getBaseDTOAnterior().getEstadoArticulo())
						&& SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(articuloVO.getBaseDTO().getEstadoArticulo())))){
				cuponGestor.inactivarCuponAClientes(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			}
		}
	}
	
	/**
	 * 
	 * @param articuloDTO
	 * @throws SICException
	 */
	public void validarCantidadMaximaCuponesActivosLocal(ArticuloVO articuloVO)throws SICException{
		//realiza la validacion de la cantidad de cupones activos en un local (esto es temporal)
		Collection<Integer> locales = null;
		if(articuloVO.getBaseDTO().getTieneArticuloLocal()){
			locales = new ArrayList<Integer>();
			for(ArticuloLocalDTO dto : articuloVO.getBaseDTO().getArticuloLocalCol()){
				locales.add(dto.getId().getCodigoLocal());
			}
		}else if(!StringUtils.isEmpty(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
			ArticuloLocalDTO filtro = new ArticuloLocalDTO();
			filtro.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			filtro.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			filtro.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			Collection<ArticuloLocalDTO> items = dataGestor.findObjects(filtro);
			if(!items.isEmpty()){
				locales = new ArrayList<Integer>(items.size());
				for(ArticuloLocalDTO dto : items){
					locales.add(dto.getId().getCodigoLocal());
				}
			}
		}
		Collection<CantidadCuponLocal> resultado = null;
		if(locales != null){
			if(!articuloVO.getBaseDTO().getTieneArticuloTemporada()){
				ArticuloTemporadaDTO at = new ArticuloTemporadaDTO();
				at.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				at.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				articuloVO.getBaseDTO().setArticuloTemporadaDTO(dataGestor.findUnique(at));
			}
			String localesError = "";
			resultado = articuloLocalDAO.obtenerCantidadCuponesLocal(locales, articuloVO.getBaseDTO().getArticuloTemporadaDTO().getFechaInicioTemporada(), articuloVO.getBaseDTO().getArticuloTemporadaDTO().getFechaFinTemporada());
			articuloVO.setCantidadCuponLocalCol(resultado); //se asigna en el VO para que pueda ser usado en la capa del cliente
			for(final CantidadCuponLocal dto : resultado){
				if(dto.getCantidadCupones() > SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_CUPONES_ACTIVOS){
					localesError.concat(dto.getCodigoLocal().toString()).concat(", ");
				}
			}
			
			if(!StringUtils.isEmpty(localesError)){
				throw new SICException(SICCodigosError.CANTIDAD_MAXIMA_CUPONES_LOCAL, MessageFormat.format("No se puede completar el registro en los locales: {} porque se exedera el m\u00E1ximo de cupones activos {} en las fechas indicadas", 
					localesError, SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_CUPONES_ACTIVOS));
			}
		}
	}
	
	/**
	 * 
	 * @param articuloVO
	 * @return objeto bit&aacute;cora que ya tiene el c&oacute;digo de barras, es nulo si el c&oacute;digo de barras no est&Aacute; asignado a ning&uacute;n art&iacute;culo
	 */
	@Override
	public ArticuloBitacoraCodigoBarrasDTO validarAsignacionCodigoBarras(ArticuloVO articuloVO)throws SICRuleException{
		ArticuloBitacoraCodigoBarrasDTO abcbFiltro = new ArticuloBitacoraCodigoBarrasDTO();
		try{
			ArticuloBitacoraCodigoBarrasDTO abcb = null;
			articuloVO.setEstValCodBar(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_DESACTIVARCREAR);
			if(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())
					&& articuloVO.getBaseDTO().hasDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO)){
				//se consulta la bitacora del articulo actual
				if(StringUtils.isNotEmpty(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
					abcbFiltro.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					abcbFiltro.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					abcbFiltro.setArticulo(new ArticuloDTO());
					abcbFiltro.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					abcb = dataGestor.findUnique(abcbFiltro);
					
					if(abcb != null && StringUtils.equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO, abcb.getCodigoTipoCodigoArticulo())){
						if(!StringUtils.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getValorTipoSecuencia(), abcb.getValorTipoSecuencia())){
							articuloVO.setEstValCodBar(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_ACTUALIZAR);
						}else{
							articuloVO.setEstValCodBar(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_SINACCION);
						}
						
//						if(articuloVO.getBaseDTO().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO)
//								|| StringUtils.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getValorTipoSecuencia(), abcb.getValorTipoSecuencia())){
//							articuloVO.setEstValCodBar(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_ACTUALIZAR);
//						}
					}
				}
			}else if(StringUtils.isNotEmpty(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras())){
//				validarRangoSecuenciaCodigoInterno(articuloVO.getBaseDTO());
				abcbFiltro.getId().setCodigoCompania(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoCompania());
				abcbFiltro.getId().setCodigoBarras(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras());
				abcbFiltro.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				abcbFiltro.setArticulo(new ArticuloDTO());
				abcb = dataGestor.findUnique(abcbFiltro);
				
				if(abcb != null){
					//solamente si el secuencial del artículo no coincide se verifica, ya que si los secuenciales coinciden significa que se está realizando
					//la actualizacion de un artículo cuyo código de barras no fue cambiado.
					if(!abcb.getId().getCodigoArticulo().equals(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
						if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(abcb.getArticulo().getEstadoArticulo())){
							//se verifica si el artículo está incluido en otras transacciones activas
							this.validarArticuloEnTransaccionesActivas(abcb);
						}else{
							abcb.setEstadoArticuloBitacora(SICConstantes.ESTADO_INACTIVO_NUMERICO);
							abcb.setFechaFinalActivo(new Date());
							abcb.setUserId(articuloVO.getBaseDTO().getUserId());
							dataGestor.update(abcb);
						}
					}else{
						articuloVO.setEstValCodBar(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_SINACCION);
					}
				}
			}
			return abcb;
		}catch (SICRuleException e) {
			throw e;
		}catch (Exception e) {
			throw new SICRuleException(SICArticuloMessages.getInstancia().getString("mensaje.error.validacion.codigobarras"),e);
		}finally{
			abcbFiltro = null;
		}
	}
	
	
	public void validarAsignacionCodigoBarras(Integer codigoCompania, String codigoArticulo, String codigoBarras)throws SICRuleException{
		ArticuloBitacoraCodigoBarrasDTO abcbFiltro = new ArticuloBitacoraCodigoBarrasDTO();
		try{
			ArticuloBitacoraCodigoBarrasDTO abcb = null;
			abcbFiltro.getId().setCodigoCompania(codigoCompania);
			abcbFiltro.getId().setCodigoBarras(codigoBarras);
			abcbFiltro.setCriteriaSearch(new CriteriaSearch());
			abcbFiltro.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoArticulo", ComparatorTypeEnum.NOT_IN_COMPARATOR, codigoArticulo));
			abcbFiltro.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			abcbFiltro.setArticulo(new ArticuloDTO());
			abcb = dataGestor.findUnique(abcbFiltro);
			
			if(abcb != null){
				this.validarArticuloEnTransaccionesActivas(abcb);
			}
		}catch (SICRuleException e) {
			throw e;
		}catch (Exception e) {
			throw new SICRuleException(SICArticuloMessages.getInstancia().getString("mensaje.error.validacion.codigobarras"),e);
		}finally{
			abcbFiltro = null;
		}
	}
	
	
	/**
	 * 
	 * @param articuloVO
	 * @param abcb
	 * @throws SICRuleException
	 */
	private void validarArticuloEnTransaccionesActivas(ArticuloBitacoraCodigoBarrasDTO abcb)throws SICRuleException{
		//no se puede asignar el código de barras porque pertenece a otro artículo activo en otras transacciones
		String mensaje = "El c\u00F3digo de barras " + abcb.getId().getCodigoBarras()
				+ " ya est\u00E1 asignado al art\u00EDculo de c\u00F3digo \u00FAnico " + abcb.getId().getCodigoArticulo() + " - " + abcb.getArticulo().getDescripcionArticulo();
		if(abcb.getArticulo().getCodigoClasificacion() != null){
			mensaje = mensaje.concat(" con clasificaci\u00F3n " + abcb.getArticulo().getCodigoClasificacion());
		}
		throw new SICRuleException(mensaje);
	}
	
	/***
	 * Verifica si es requerido el peso aproximado dependiento del control de costo
	 * @param tipoControlCosto
	 * @return
	 */
	@Override
	public Boolean esRequeridoPesoAproximado(String tipoControlCosto){
		if(tipoControlCosto!= null && (tipoControlCosto.equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPES)
				|| tipoControlCosto.equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPESUM)
				|| tipoControlCosto.equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PESPES))){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/***
	 * Verifica si un c&oacute;digo es un EAN v&aacute;lido
	 * @param tipoControlCosto
	 * @return
	 */
	@Override
	public Boolean esEANValido(String codigoEAN){
		//se realizan las validaciones correspondientes
		Validator validator = new ValidatorImpl();
		if(codigoEAN == null || !validator.validateEAN(codigoEAN)){
			validator = null;
			return Boolean.FALSE;
		}
		return Boolean.FALSE;
	}
	/**
	 * 
	 * @param sca
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void validarPasoCreacion(SegmentoCreacionArticuloDTO sca, ArticuloVO articuloVO){
		//validaciones especiales
		Boolean segmentoConAdvertencia = Boolean.FALSE;
		Boolean segmentoProveedorDesincronizado = Boolean.FALSE;
		Boolean segmentoComercialDesincronizado = Boolean.FALSE;
		Boolean segmentoCompleto = Boolean.FALSE;
		ArticuloDTO articuloDTO = articuloVO.getBaseDTO();
		if(!sca.hasDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)){
			sca.addDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES, new HashSet<EnumMensajePasosCreacionArticulo>());
		}
		if(sca.getId().getValorPasoCreacion().equals(SICArticuloConstantes.getInstancia().VALORPRIMERPASOCODIFICACION)){
			if(!SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO.equals(articuloDTO.getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())
					&& (BooleanUtils.isTrue(articuloDTO.getCodigoBarrasActivo().getPendienteCodigoBarras()) || StringUtils.isEmpty(articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras()))){
				segmentoConAdvertencia = Boolean.TRUE;
				((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES))
					.add(EnumMensajePasosCreacionArticulo.CODIGOBARRASPENDIENTE);
			}else{
				segmentoCompleto = Boolean.TRUE;
				((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).remove(EnumMensajePasosCreacionArticulo.CODIGOBARRASPENDIENTE);
			}
		}else if(sca.getId().getValorPasoCreacion().equals(SICArticuloConstantes.getInstancia().VALORSEGUNDOPASOCODIFICACION)){
			
			if(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_PRODUCTO.equals(articuloVO.getBaseDTO().getCodigoTipoArticulo())){
				//solo si es un articulo COMERCIALIZABLE
				if(BooleanUtils.isTrue((Boolean)articuloVO.getBaseDTO().getDynamicProperty(ArticuloTransient.REUTILIZAR_CODIGOSEAN14))
						&& SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO.equals(articuloVO.getBaseDTO().getCodigoEstado())){
					segmentoCompleto = Boolean.TRUE;
					((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).remove(EnumMensajePasosCreacionArticulo.CODIGOBARRASPENDIENTE);
				}else if(articuloVO.getBaseDTO().getTieneUnidadManejoCol()){
					//validacion de las unidades de manejo
					Collection<ArticuloUnidadManejoDTO> eansDuplicados = (Collection<ArticuloUnidadManejoDTO>)articuloVO.getBaseDTO().getDynamicProperty(ArticuloTransient.CODIGOS_EAN_DUPLICADOS);
					if(eansDuplicados == null){
						eansDuplicados = validacionUnidadManejoGestor.validarUnicidadEAN14(articuloVO, articuloVO.getBaseDTO().getArticuloUnidadManejoCol());
					}
					if(!CollectionUtils.isEmpty(eansDuplicados)){
						segmentoConAdvertencia = Boolean.TRUE;
						((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).add(EnumMensajePasosCreacionArticulo.EAN14DUPLICADO);
					}else{
						segmentoCompleto = Boolean.TRUE;
						((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).remove(EnumMensajePasosCreacionArticulo.CODIGOBARRASPENDIENTE);
					}
				}
				if(!verificarMargenPrecios(articuloVO)){
					segmentoConAdvertencia = Boolean.TRUE;
					((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).add(EnumMensajePasosCreacionArticulo.MARGENINCORRECTO);
				}
			}

			//eliminar mensajes
			((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).remove(EnumMensajePasosCreacionArticulo.ARTICULOSRELACIONADOS_CUPON);
			((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).remove(EnumMensajePasosCreacionArticulo.MARCACOMERCIAL);
			((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).remove(EnumMensajePasosCreacionArticulo.CONTROLPRECIO);
			((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES)).remove(EnumMensajePasosCreacionArticulo.PRECIO);
			
			segmentoProveedorDesincronizado = verificarCambioProveedor(SICArticuloConstantes.getInstancia().VALORSEGUNDOPASOCODIFICACION, articuloVO, sca);
			segmentoComercialDesincronizado = verificarCambioTipoCodigo(SICArticuloConstantes.getInstancia().VALORSEGUNDOPASOCODIFICACION, articuloVO, sca);
		}
		
		if(segmentoProveedorDesincronizado || segmentoComercialDesincronizado){
			sca.setEstadoSegmento(SICArticuloConstantes.getInstancia().ESTADO_SEGMENTO_ERROR);
			if(segmentoProveedorDesincronizado){
				agregarObservacionSegmento(sca, SICArticuloConstantes.getInstancia().CAMBIO_PROVEEDOR);
			}
			if(segmentoComercialDesincronizado){
				agregarObservacionSegmento(sca, SICArticuloConstantes.getInstancia().CAMBIO_TIPO_CODIGO);				
			}		
		}else if(segmentoConAdvertencia){
			sca.setEstadoSegmento(SICArticuloConstantes.getInstancia().ESTADO_SEGMENTO_ADVERTENCIA);
			sca.setObservacion(null);
		}else if(segmentoCompleto){
			sca.setEstadoSegmento(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			sca.setObservacion(null);
		}
	}
	
	private Boolean verificarMargenPrecios(ArticuloVO articuloVO){
		Boolean validadorPrecios = Boolean.TRUE;
		ArticuloPrecioDTO precioBase = null;
		if(CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloPrecioCol())){
			for(ArticuloPrecioDTO articuloPrecioDTO : articuloVO.getBaseDTO().getArticuloPrecioCol()){
				if(StringUtils.equals(articuloPrecioDTO.getId().getCodigoTipoPrecio(),SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)){
					precioBase = articuloPrecioDTO;
					break;
				}
			}
		}
		if(precioBase != null && articuloVO.hasDynamicProperty("validacionMargen") && BooleanUtils.isTrue( (Boolean) articuloVO.getDynamicProperty("validacionMargen"))) {
			if(precioBase.getMargenPrecio() != null && precioBase.getMargenPrecio().compareTo(SICArticuloConstantes.getInstancia().VALOR_MINIMO_MARGEN) < 0){
				validadorPrecios = Boolean.FALSE;
			}
		}
		return validadorPrecios;
	}
	
	/**
	 * Permite agregar una observacion al segmento de creacion del articulo
	 * @param sca SegmentoCreacionArticuloDTO
	 * @param parametroValidacion parametro a agregar
	 */
	private void agregarObservacionSegmento(SegmentoCreacionArticuloDTO sca, String parametroValidacion){
		if(StringUtils.isEmpty(sca.getObservacion())){
			sca.setObservacion(parametroValidacion);
		}else if (!sca.getObservacion().contains(parametroValidacion)){
			sca.setObservacion(sca.getObservacion() + "," + parametroValidacion);
		}
		LOG_SICV2.info("observacion: " + sca.getObservacion());
	}
	
	/**
	 * Permite validar si existen observaciones en la creacion del segmento, y corresponden a un cambio
	 * @param sca SegmentoCreacionArticuloDTO
	 * @param parametroValidacion parametro a validar en el cambio
	 * @return True si se realizo un cambio, False en caso contrario
	 */
	private Boolean validarCambio(SegmentoCreacionArticuloDTO sca, String parametroValidacion){
		boolean agregarMensaje = Boolean.FALSE;
		if(StringUtils.isNotEmpty(sca.getObservacion())){
			String[] cambios = sca.getObservacion().split(",");
			if(cambios != null && cambios.length > 0){
				for(int i = 0; i < cambios.length; i++){
					if(parametroValidacion.equals(cambios[i])){
						agregarMensaje = Boolean.TRUE;
						break;
					}
				}
			}
		}
		return agregarMensaje;
	}
	
	@SuppressWarnings("unchecked")
	private Boolean verificarCambioProveedor(String codigoPaso, ArticuloVO articuloVO, SegmentoCreacionArticuloDTO sca){
		LOG_SICV2.info("Paso a verificar: " + codigoPaso);
		Boolean segmentoIncompleto = Boolean.FALSE;
		boolean agregarMensaje = validarCambio(sca, SICArticuloConstantes.getInstancia().CAMBIO_PROVEEDOR);
		if(SICArticuloConstantes.getInstancia().ESTADO_SEGMENTO_ERROR.equals(sca.getEstadoSegmento()) && agregarMensaje){
			agregarMensajesCambioProveedor(articuloVO, sca);
			segmentoIncompleto = Boolean.TRUE;
		}else if(articuloVO.getBaseDTO().getTieneArticuloProveedor()){
			articuloVO.getBaseDTO().setArticuloProveedorCol(ColeccionesUtil.sort(articuloVO.getBaseDTO().getArticuloProveedorCol(), ColeccionesUtil.ORDEN_DESC, "estadoArticuloProveedor"));			
			if( articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getDynamicProperty(SICConstantes.ENTIDAD_ANTERIOR) != null){
				ArticuloProveedorDTO ap = articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next();
				ArticuloProveedorDTO apAnterior = (ArticuloProveedorDTO)ap.getDynamicProperty(SICConstantes.ENTIDAD_ANTERIOR);				
				if(!ap.getId().getCodigoProveedor().equals(apAnterior.getId().getCodigoProveedor())){
					sca.addDynamicProperty(SegmentoCreacionArticuloDTO.CARGAR_DATOS, Boolean.TRUE);
					segmentoIncompleto = Boolean.TRUE;
					agregarMensajesCambioProveedor(articuloVO, sca);
				}
			}
		}
		return segmentoIncompleto;
	}
	
	@SuppressWarnings("unchecked")
	private Boolean verificarCambioTipoCodigo(String codigoPaso, ArticuloVO articuloVO, SegmentoCreacionArticuloDTO sca){
		LOG_SICV2.info("Paso a verificar: " + codigoPaso);
		Boolean segmentoIncompleto = Boolean.FALSE;
		boolean agregarMensaje = validarCambio(sca, SICArticuloConstantes.getInstancia().CAMBIO_TIPO_CODIGO);
		if(SICArticuloConstantes.getInstancia().ESTADO_SEGMENTO_ERROR.equals(sca.getEstadoSegmento()) && agregarMensaje){
			agregarMensajesCambioTipoCodigo(articuloVO, sca);
			segmentoIncompleto = Boolean.TRUE;
		}else if(!articuloVO.getBaseDTO().getCodigoTipoArticulo().equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON) && articuloVO.getBaseDTOAnterior() != null){
			if(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())){
				ArticuloBitacoraCodigoBarrasDTO artBit = articuloVO.getBaseDTO().getCodigoBarrasActivo();
				ArticuloBitacoraCodigoBarrasDTO artBitAnterior = articuloVO.getBaseDTOAnterior().getCodigoBarrasActivo();
				if(articuloVO.getBaseDTO().getTieneArtBitCodBar()
						&& artBitAnterior != null){
					if(!artBit.getValorTipoSecuencia().equals(artBitAnterior.getValorTipoSecuencia())){
 						if(SICArticuloConstantes.getInstancia().TIPSECART_PESOPRECIO.equals(artBit.getValorTipoSecuencia())){
							sca.addDynamicProperty(SegmentoCreacionArticuloDTO.CARGAR_DATOS, Boolean.TRUE);
							segmentoIncompleto = Boolean.TRUE;
							((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES))
							.add(EnumMensajePasosCreacionArticulo.CONTROLPRECIO);
						}else{
							sca.setEstadoSegmento(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						}
					}
				}
			}
		}
		return segmentoIncompleto;	
	}
	
	@SuppressWarnings("unchecked")
	private void agregarMensajesCambioProveedor(ArticuloVO articuloVO, SegmentoCreacionArticuloDTO sca){
		if(articuloVO.getBaseDTO().getCodigoTipoArticulo().equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON)){
			((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES))
				.add(EnumMensajePasosCreacionArticulo.ARTICULOSRELACIONADOS_CUPON);
		}else{
			((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES))
				.add(EnumMensajePasosCreacionArticulo.MARCACOMERCIAL);
			((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES))
				.add(EnumMensajePasosCreacionArticulo.PRECIO);				
		}
	}
	
	@SuppressWarnings("unchecked")
	private void agregarMensajesCambioTipoCodigo(ArticuloVO articuloVO, SegmentoCreacionArticuloDTO sca){
		if(!articuloVO.getBaseDTO().getCodigoTipoArticulo().equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON)){
			((Set<EnumMensajePasosCreacionArticulo>)sca.getDynamicProperty(SegmentoCreacionArticuloDTO.MENSAJES))
				.add(EnumMensajePasosCreacionArticulo.CONTROLPRECIO);
		}
	}
	
//	public void validarArchivosAdjuntosCupones(ArticuloVO articuloVO)throws SICException{ Eliminar
//		//si el artículo es cupón
//		if(articuloVO.getBaseDTO().getCodigoTipoArticulo().equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON)
//				&& !SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO.equals(articuloVO.getBaseDTO().getCodigoEstado())
//				&& !articuloVO.getBaseDTO().hasDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO)){
//			
////			if(existeTipoImagen(articuloVO, SICArticuloConstantes.getInstancia().TIPOARCHIVO_IMGGENERAL)
////					&& !existeTipoImagen(articuloVO, SICArticuloConstantes.getInstancia().TIPOARCHIVO_IMAGEN_MOVIL)){
////				throw new SICException("El cup\u00F3n tambi\u00E9n necesita una im\u00E1gen para dispositivos m\u00F3viles");
////			}
//		}
//	}
	
	public Boolean existeTipoImagen(final ArticuloVO articuloVO, final String tipoImagen){
		return CollectionUtils.exists(articuloVO.getBaseDTO().getArticuloDefinicionArchivoCol(), new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				ArticuloDefinicionArchivoDTO ada = (ArticuloDefinicionArchivoDTO)arg0;
				return ada.getValorTipoArchivo().equals(tipoImagen) && ada.getEstadoArchivo().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			}
		});
	}
	
	public void validarRangoSecuenciaCodigoInterno(ArticuloDTO articuloDTO)throws SICRuleException{
		
		if(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO.equals(articuloDTO.getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())){
			RangoSecuenciaCodigoBarrasDTO filtro = new RangoSecuenciaCodigoBarrasDTO();
			filtro.setCodigoTipoSecuencia(SICArticuloConstantes.getInstancia().TIPOCATALOGO_SECUENCIAINTERNA);
			filtro.setValorTipoSecuencia(articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia());
			Collection<RangoSecuenciaCodigoBarrasDTO> rangos = dataGestor.findObjects(filtro);
			Boolean rangoCorrecto = Boolean.FALSE;
			String mensaje = "El c\u00F3digo de barras interno no est\u00E1 en el rango correcto, recuerde que debe estar entre ";
			for(RangoSecuenciaCodigoBarrasDTO rango : rangos){
				mensaje = mensaje + rango.getValorMinimo() + " y " + rango.getValorMaximo() + " \u00F3 ";
				if(Long.valueOf(articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras()) >= rango.getValorMinimo() && Long.valueOf(articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras()) <= rango.getValorMaximo()){
					rangoCorrecto = Boolean.TRUE;
				}
			}
			if(!rangoCorrecto){
				throw new SICRuleException(mensaje.substring(0, mensaje.length() - 3));
			}
		}
	}
	
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @param articuloLocalDAO the articuloLocalDAO to set
	 */
	public void setArticuloLocalDAO(IArticuloLocalDAO articuloLocalDAO) {
		this.articuloLocalDAO = articuloLocalDAO;
	}

	/**
	 * @param validacionUnidadManejoGestor the validacionUnidadManejoGestor to set
	 */
	public void setValidacionUnidadManejoGestor(IValidacionUnidadManejoGestor validacionUnidadManejoGestor) {
		this.validacionUnidadManejoGestor = validacionUnidadManejoGestor;
	}

	public void setCuponGestor(ICuponGestor cuponGestor) {
		this.cuponGestor = cuponGestor;
	}
	
	
}
