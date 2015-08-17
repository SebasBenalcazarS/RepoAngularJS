/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.proveedor;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.ListSet;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.common.proveedor.ProveedorConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.articuloImportacion.IArticuloProveedorImportacionGestor;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.IArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.accion.IAccionArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.calculo.ICalculoArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.almacenamiento.IAlmacenamientoDatosCambioPreciosGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloProveedorDAO;
import ec.com.smx.sic.cliente.persistencia.proveedor.dao.IProveedorClasificacionDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author fmunoz
 *
 */
public class ArticuloProveedorGestor implements IArticuloProveedorGestor{

	private DataGestor dataGestor;
	private ICalculoArticuloProveedorGestor calculoArticuloProveedorGestor;
	private IAccionArticuloProveedorGestor accionArticuloProveedorGestor;
	private IArticuloProveedorDAO articuloProveedorDAO;
	private IArticuloDAO articuloDAO;
	private IParametroGestor parametroGestor;
	private final String CAMPOARTICULO="codigoArticulo";
	private IArticuloProveedorImportacionGestor articuloProveedorImportacionGestor;
	private IAlmacenamientoDatosCambioPreciosGestor almacenamientoDatosCambioPreciosGestor;
	private IProveedorClasificacionDAO proveedorClasificacionDAO;
	
	/**
	 * Realiza el registro de una colecci&oacute;n de datos art&iacute;culo-proveedor
	 * @param artPros
	 */
	public void registrarArticuloProveedor(Collection<ArticuloProveedorDTO> artPros) throws SICException{
		for(ArticuloProveedorDTO ap : artPros){
			Boolean enviarDatos = ap.getTransferirDatosSIC();
			ap.setTransferirDatosSIC(Boolean.FALSE);
			registrarArticuloProveedor(ap);
			ap.setTransferirDatosSIC(enviarDatos);
		}
		accionArticuloProveedorGestor.transferirDatosArticuloProveedorSIC(artPros, Boolean.FALSE, null);
	}
	
	/**
	 * Realiza el registro de una condici&oacute;n comercial para un art&iacute;culo (ARTICULO-PROVEEDOR-CLASIFICACION)
	 * @param articuloVO
	 */
	public void registrarArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO) throws SICException{
		Map<String, Object> relations = null;
		Boolean esCreacion = null;
		try{			
			calculoArticuloProveedorGestor.asignarCamposArticuloProveedor(articuloProveedorDTO);
			relations = SICUtil.getInstance().clearRelations(articuloProveedorDTO);
			esCreacion = articuloProveedorDTO.hasDynamicProperty(SICConstantes.EVENTO_INSERTAR);
			
			if(esCreacion){
				dataGestor.create(articuloProveedorDTO);
			}else{
				dataGestor.createOrUpdate(articuloProveedorDTO);}
			
			dataGestor.detach(articuloProveedorDTO);
			
			SICUtil.getInstance().restoreRelations(articuloProveedorDTO,relations);
			relations = null;
			
			//registrar articulo importaciones
			if(articuloProveedorDTO.getTieneArticuloImportacion()){ 
				articuloProveedorImportacionGestor.registrarArticuloImportacion(articuloProveedorDTO,esCreacion);
			}
			
			this.registrarArticuloProveedorImpuesto(articuloProveedorDTO, esCreacion);
			
			if(articuloProveedorDTO.getTieneDescuentoProveedorArticuloCol()){
				if(articuloProveedorDTO.getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) == null){
					articuloProveedorDAO.actualizarEstadoDesArtPro(articuloProveedorDTO, SICConstantes.ESTADO_INACTIVO_NUMERICO);
				}
				for(DescuentoProveedorArticuloDTO dpa : articuloProveedorDTO.getDescuentoProveedorArticuloCol()){
					dpa.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
					dpa.setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
					dpa.setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
//					dpa.setCodigoAplicacionTipoDescuento(TipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
//					dpa.setValorAplicacionTipoDescuento(TipoAplicacionDescuento.NORMAL.getValorTipoAplicacionDescuento());
					dpa.setUserId(articuloProveedorDTO.getUserId());
				}
				if(esCreacion){
					dataGestor.createAll(articuloProveedorDTO.getDescuentoProveedorArticuloCol());
				}else{
					for (DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO : articuloProveedorDTO.getDescuentoProveedorArticuloCol()) {
						DescuentoProveedorArticuloDTO dpa = this.articuloProveedorDAO.obtenerDescuentoArticuloProveedor(descuentoProveedorArticuloDTO);
						if( dpa != null ){
							descuentoProveedorArticuloDTO.getId().setSecuencialDescuentoArticuloProveedor(dpa.getId().getSecuencialDescuentoArticuloProveedor());
							dataGestor.update(descuentoProveedorArticuloDTO);
						}else{
							dataGestor.create(descuentoProveedorArticuloDTO);
						}
					}
					//dataGestor.createOrUpdateAll(articuloProveedorDTO.getDescuentoProveedorArticuloCol());
				}
			}
			
			this.verificarCambiosEnArticuloProveedor(articuloProveedorDTO);
			
			//validamos si existen datos de orden de compra asosiados al articulo proveedor(cuando este se dio de baja)
			if(CollectionUtils.isNotEmpty(articuloProveedorDTO.getDatosOrdenCompra())){
				almacenamientoDatosCambioPreciosGestor.registrarDatosOrdenCompraGestion(articuloProveedorDTO.getDatosOrdenCompra(), articuloProveedorDTO.getId().getCodigoCompania(), articuloProveedorDTO.getUserId());
			}
			
			//realiza la integracion al SIC
			if(articuloProveedorDTO.getTransferirDatosSIC()){
				accionArticuloProveedorGestor.transferirDatosArticuloProveedorSIC(articuloProveedorDTO, Boolean.FALSE, null);
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.proveedor"),e);
		}finally{
			SICUtil.getInstance().restoreRelations(articuloProveedorDTO,relations);
			relations = null;
		}
	}
	

	
	public void registrarArticuloProveedorImpuesto(ArticuloProveedorDTO articuloProveedorDTO,Boolean esCreacion) throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Articulo Proveedor Impuesto");
		Map<String, Object> relations = null;
		ArticuloProveedorImpuestoDTO apiActual = null;
		try{
			if(articuloProveedorDTO.getArticuloProveedorImpuestoCol() != null && !SearchDTO.isLazy(articuloProveedorDTO.getArticuloProveedorImpuestoCol())){
				for(ArticuloProveedorImpuestoDTO dto : articuloProveedorDTO.getArticuloProveedorImpuestoCol()){
					dto.setEsParaVenta(Boolean.FALSE);
					if(BooleanUtils.isTrue(dto.getEsParaCompra()) && BooleanUtils.isFalse(dto.getEsParaVenta())){
						dto.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
						dto.getId().setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
						dto.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
						dto.setUserId(articuloProveedorDTO.getUserId());
						apiActual = dto;
						relations = SICUtil.getInstance().clearRelations(dto);
						if(esCreacion){
							dto.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							dataGestor.create(dto);
						}else{
							dataGestor.createOrUpdate(dto);}
						SICUtil.getInstance().restoreRelations(dto, relations);
						relations = null;
					}
				}
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException("Error al registrar impuestos de articulo-proveedor",e);
		}finally{
			SICUtil.getInstance().restoreRelations(apiActual, relations);
			relations = null;
			apiActual = null;
		}
		
	}	
	
	/**
	 *   
	 * @param articuloDTO
	 * @param respaldoArticulo
	 * @param esCreacionArticulo
	 */
	@SuppressWarnings("unchecked")
	public void registrarArticuloProveedorDesdeArticulo(ArticuloVO articuloVO, Boolean esCreacionArticulo) throws SICException{
		
		if(articuloVO.getBaseDTO().getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) != null){
			articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().removeDynamicProperty(SICConstantes.ENTIDAD_ANTERIOR);
			articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().removeDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO);
			if(articuloVO.getBaseDTOAnterior() != null && articuloVO.getBaseDTOAnterior().getTieneArticuloProveedor()){
				
				ArticuloProveedorDTO articuloProveedorDTO = (ArticuloProveedorDTO) CollectionUtils.find(articuloVO.getBaseDTO().getArticuloProveedorCol(), new BeanPredicate("estadoArticuloProveedor", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
				ArticuloProveedorDTO articuloProveedorAnteriorDTO = (ArticuloProveedorDTO) CollectionUtils.find(articuloVO.getBaseDTOAnterior().getArticuloProveedorCol(), new BeanPredicate("estadoArticuloProveedor", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
				
				articuloProveedorDTO.addDynamicProperty(SICConstantes.ENTIDAD_ANTERIOR, articuloProveedorAnteriorDTO);
				articuloProveedorDTO.addDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO, Boolean.TRUE);
				
			}
		}
		articuloVO.getBaseDTO().setArticuloProveedorCol(ColeccionesUtil.sort(articuloVO.getBaseDTO().getArticuloProveedorCol(), ColeccionesUtil.ORDEN_ASC, "estadoArticuloProveedor"));
		Boolean asignarConfiRegSan = asignarConfirmarRegistroSanitario(articuloVO.getBaseDTO().getArticuloProveedorCol());
		for(ArticuloProveedorDTO dto : articuloVO.getBaseDTO().getArticuloProveedorCol()){
			dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			dto.setUserId(articuloVO.getBaseDTO().getUserId());
			dto.setArticulo(articuloVO.getBaseDTO());
			dto.setTransferirDatosSIC(Boolean.FALSE);
			if(asignarConfiRegSan){
				dto.setEsConfirmadoRegistroSanitario(Boolean.TRUE);
			}
			if(esCreacionArticulo){
				dto.addDynamicProperty(SICConstantes.EVENTO_INSERTAR, "1");
			}else{
				dto.removeDynamicProperty(SICConstantes.EVENTO_INSERTAR);}
			
			registrarArticuloProveedor(dto);
			dto.setTransferirDatosSIC(Boolean.TRUE);
			
			//se trasladan las unidades de manejo del proveedor directamente a las unidades del articulo, cuando no es la creacion
			if(dto.getTieneUnidadesManejo() && articuloVO.getBaseDTO().getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) == null){
				if(!articuloVO.getBaseDTO().getTieneUnidadManejoCol()){
					articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ListSet());
				}
				for(final ArticuloUnidadManejoProveedorDTO ump : dto.getUnidadesManejo()){
					if(ump.getTieneArticuloUnidadManejo()){
						ArticuloUnidadManejoDTO aum = (ArticuloUnidadManejoDTO)CollectionUtils.find(articuloVO.getBaseDTO().getArticuloUnidadManejoCol(), new Predicate() {
							@Override
							public boolean evaluate(Object object) {
								ArticuloUnidadManejoDTO um = (ArticuloUnidadManejoDTO)object;
								return ((ump.getArticuloUnidadManejoDTO().getId().getCodigoUnidadManejo() != null && ump.getId().getCodigoUnidadManejo() != null &&
										ump.getArticuloUnidadManejoDTO().getId().getCodigoUnidadManejo().longValue() == um.getId().getCodigoUnidadManejo().longValue()) || 
										(ump.getArticuloUnidadManejoDTO().getId().getCodigoUnidadManejo() == null 
										&& um.getValorUnidadManejo().intValue() == ump.getArticuloUnidadManejoDTO().getValorUnidadManejo().intValue()
										&& um.getValorTipoUnidadEmpaque().equals(ump.getArticuloUnidadManejoDTO().getValorTipoUnidadEmpaque())));
							}
						});
						
						if(aum == null){
							if(!articuloVO.getBaseDTO().getArticuloUnidadManejoCol().contains(ump.getArticuloUnidadManejoDTO())){
								articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(ump.getArticuloUnidadManejoDTO());
							}
							aum = ump.getArticuloUnidadManejoDTO();
						}else{
							//Collections.replaceAll((List<ArticuloUnidadManejoDTO>)articuloVO.getBaseDTO().getArticuloUnidadManejoCol(), aum, ump.getArticuloUnidadManejoDTO());
							aum.setAlto(ump.getArticuloUnidadManejoDTO().getAlto());
							aum.setAncho(ump.getArticuloUnidadManejoDTO().getAncho());
							aum.setProfundidad(ump.getArticuloUnidadManejoDTO().getProfundidad());
							aum.setPeso(ump.getArticuloUnidadManejoDTO().getPeso());
							aum.setCubicaje(ump.getArticuloUnidadManejoDTO().getCubicaje());
							aum.setPrioridad(ump.getArticuloUnidadManejoDTO().getPrioridad());
							aum.setCodigoBarrasUnidadManejo(ump.getArticuloUnidadManejoDTO().getCodigoBarrasUnidadManejo());
							aum.setArticuloUnidadManejoContenedoraCol(ump.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol());
							aum.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						}
						
						//se verifican los usos
						if(!aum.getTieneUnidadesManejoUso()){
							aum.setArticuloUnidadManejoUsoCol(new ListSet());
						}
						
						verificarUso(aum.getArticuloUnidadManejoUsoCol(), SICArticuloConstantes.getInstancia().VALORUSOUNIMANCOMPRA);
						verificarUso(aum.getArticuloUnidadManejoUsoCol(), SICArticuloConstantes.getInstancia().VALORUSOUNIMANDESPACHO);
						
						//se verifica la coleccion de las unidades del proveedor
						if(!aum.getTieneUnidadesManejoProveedor()){
							aum.setArticuloUnidadManejoProveedorCol(new ListSet());
						}
						
						ArticuloUnidadManejoProveedorDTO umpfinded = (ArticuloUnidadManejoProveedorDTO)CollectionUtils.find(aum.getArticuloUnidadManejoProveedorCol(), new Predicate() {
							@Override
							public boolean evaluate(Object object) {
								return ump.getId().getCodigoProveedor().equals(((ArticuloUnidadManejoProveedorDTO)object).getId().getCodigoProveedor());
							}
						});
						
						if(umpfinded == null){
							aum.getArticuloUnidadManejoProveedorCol().add(ump);
						}else{
							if (umpfinded.getEquivalenciaPorcentajeDescuentoDTO() != null && ump.getEquivalenciaPorcentajeDescuentoDTO() != null){// <>TIPODESCUENTO
								//validamos si las relaciones vienen cargadas
								if(SearchDTO.isLoaded(ump.getEquivalenciaPorcentajeDescuentoDTO().getAsignacionTipoDescuento()) && ump.getEquivalenciaPorcentajeDescuentoDTO().getAsignacionTipoDescuento() != null){
									umpfinded.getEquivalenciaPorcentajeDescuentoDTO().getId().setCodigoEquivalencia(ump.getEquivalenciaPorcentajeDescuentoDTO().getId().getCodigoEquivalencia());
									umpfinded.getEquivalenciaPorcentajeDescuentoDTO().getAsignacionTipoDescuento().setCodigoTipoDescuento(ump.getEquivalenciaPorcentajeDescuentoDTO().getAsignacionTipoDescuento().getCodigoTipoDescuento());
									umpfinded.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * METODO QUE VERIFICA SI SE DEBE ASIGNAR TRUE EN EL CAMPO esConfirmadoRegistroSanitario
	 * DEL ARTICULO PROVEEDOR CUANDO SE AGREGA UN NUEVO PROVEEDOR Y SI EL PROVEEDOR ANTERIOR
	 * TIENE ASIGNADO EL VALOR TRUE, SI ES FALSE O NULL NO HACE NADA
	 * @param articuloProveedorDTOs
	 * @return
	 * @author eharo
	 */
	private Boolean asignarConfirmarRegistroSanitario(Collection<ArticuloProveedorDTO> articuloProveedorDTOs){
		Boolean asignar = Boolean.FALSE;
		if(CollectionUtils.isNotEmpty(articuloProveedorDTOs)){
			for (ArticuloProveedorDTO articuloProveedorDTO : articuloProveedorDTOs) {
				if(articuloProveedorDTO.getEsConfirmadoRegistroSanitario() != null && articuloProveedorDTO.getEsConfirmadoRegistroSanitario()){
					asignar = articuloProveedorDTO.getEsConfirmadoRegistroSanitario();
				}
			}
		}
		return asignar;
	}
	
	private void verificarUso(Collection<ArticuloUnidadManejoUsoDTO> usos, final String tipoUso){
		ArticuloUnidadManejoUsoDTO uso = (ArticuloUnidadManejoUsoDTO)CollectionUtils.find(usos, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return tipoUso.equals(((ArticuloUnidadManejoUsoDTO)object).getId().getValorTipoUso());
			}
		});
		
		if(uso == null){
			ArticuloUnidadManejoUsoDTO umuso = new ArticuloUnidadManejoUsoDTO();
			umuso.getId().setValorTipoUso(tipoUso);
			usos.add(umuso);
		}else{
			uso.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
	}
	
	/**
	 * @param articuloProveedorDTO
	 */
	@SuppressWarnings("deprecation")
	private void verificarCambiosEnArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO) throws SICException{
		try{
			if(articuloProveedorDTO.getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) != null){
				ArticuloProveedorDTO apAnterior = (ArticuloProveedorDTO)articuloProveedorDTO.getDynamicProperty(SICConstantes.ENTIDAD_ANTERIOR);
				if(apAnterior != null && StringUtils.isNotEmpty(apAnterior.getId().getCodigoProveedor())){
					if((apAnterior.getArticulo() != null && articuloProveedorDTO.getArticulo() != null
							&& apAnterior.getArticulo().getCodigoClasificacion() != null && articuloProveedorDTO.getArticulo().getCodigoClasificacion() != null
							&& !apAnterior.getArticulo().getCodigoClasificacion().equals(articuloProveedorDTO.getArticulo().getCodigoClasificacion()))
						|| !articuloProveedorDTO.getId().getCodigoProveedor().equals(apAnterior.getId().getCodigoProveedor())){
						//descuentos del articulo proveedor
						if(!articuloProveedorDTO.getTieneDescuentoProveedorArticuloCol()){
							DescuentoProveedorArticuloDTO dpaFiltro = new DescuentoProveedorArticuloDTO();
							dpaFiltro.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
							dpaFiltro.setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
							dpaFiltro.setCodigoProveedor(apAnterior.getId().getCodigoProveedor()); //se consulta con el codigo de proveedor anterior
							dpaFiltro.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//							dpaFiltro.getAsignacionTipoDescuento().setCodigoAplicacionTipoDescuento(EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
//							dpaFiltro.getAsignacionTipoDescuento().setValorAplicacionTipoDescuento(EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
							// <>TIPODESCUENTO
							dpaFiltro.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
//							dpaFiltro.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
							dpaFiltro.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
							dpaFiltro.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
							dpaFiltro.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
							dpaFiltro.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento()));
							dpaFiltro.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
							articuloProveedorDTO.setDescuentoProveedorArticuloCol(dataGestor.findObjects(dpaFiltro));
						}
					}
					
					if(!articuloProveedorDTO.getId().getCodigoProveedor().equals(apAnterior.getId().getCodigoProveedor())){
						//se desactiva el proveedor anterior
						articuloProveedorDAO.actualizarEstado(apAnterior, SICConstantes.ESTADO_INACTIVO_NUMERICO,
								"estadoArticuloProveedor", null, ArticuloProveedorDTO.class);
						//ANTES se cambia la referencia de las unidades de manejo
	//					articuloProveedorDAO.actualizarCodigoProveedorEnRelaciones(articuloProveedorDTO, nombreCampoProveedor, apAnterior.getId().getCodigoProveedor(), 
	//							ArticuloUnidadManejoDTO.class);
						//AHORA
						ArticuloUnidadManejoProveedorDTO unimanpro = new ArticuloUnidadManejoProveedorDTO();
						unimanpro.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
						unimanpro.getId().setCodigoProveedor(apAnterior.getId().getCodigoProveedor());
						unimanpro.setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
						unimanpro.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						Collection<ArticuloUnidadManejoProveedorDTO> unidades = dataGestor.findObjects(unimanpro);
						for(ArticuloUnidadManejoProveedorDTO ump : unidades){
							ump.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
							//dataGestor.detach(ump);
							dataGestor.createOrUpdate(ump);
						}
						articuloProveedorDAO.actualizarEstado(apAnterior, SICConstantes.ESTADO_INACTIVO_NUMERICO,
								"estado", CAMPOARTICULO, ArticuloUnidadManejoProveedorDTO.class);
						
						//descuentos del articulo proveedor
						for(DescuentoProveedorArticuloDTO dpa : articuloProveedorDTO.getDescuentoProveedorArticuloCol()){
							dpa.setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
							dpa.setUserId(articuloProveedorDTO.getUserId());
							dataGestor.createOrUpdate(dpa);
						}
						
						articuloProveedorDAO.actualizarEstadoDesArtPro(apAnterior, SICConstantes.ESTADO_INACTIVO_NUMERICO);
						
						//articulo importacion
						if(!articuloProveedorDTO.getTieneArticuloImportacion()){
							ArticuloImportacionDTO aimp = new ArticuloImportacionDTO();
							aimp.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
							aimp.getId().setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
							aimp.getId().setCodigoProveedor(apAnterior.getId().getCodigoProveedor());
							aimp = dataGestor.findUnique(aimp);
							if(aimp != null){
								aimp.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
								aimp.setUserId(articuloProveedorDTO.getUserId());
								dataGestor.createOrUpdate(aimp);
							}
						}
						
						if(articuloProveedorDTO.getTieneArticulo() && SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON.equals(articuloProveedorDTO.getArticulo().getCodigoTipoArticulo())){
							String codigoJDECorpFavorita = parametroGestor.obtenerParametro(articuloProveedorDTO.getId().getCodigoCompania(), 
									ProveedorConstantes.getInstancia().CODIGO_PROVEEDOR_SUPER_USUARIO_PRINCIPAL,
									ProveedorConstantes.getInstancia().CODIGO_SISTEMA_B2B).getValorParametro();
							Integer codigoJde = Integer.valueOf(codigoJDECorpFavorita);
							if(!StringUtils.equals(articuloProveedorDTO.getId().getCodigoProveedor(), codigoJde.toString())){
								articuloDAO.actualizarEstadoArticuloRelacion(articuloProveedorDTO.getId().getCodigoCompania(), articuloProveedorDTO.getId().getCodigoArticulo(), 
										SICConstantes.ESTADO_INACTIVO_NUMERICO, articuloProveedorDTO.getId().getCodigoProveedor(), SICConstantes.ESTADO_ACTIVO_NUMERICO,articuloProveedorDTO.getUserId());
								articuloDAO.actualizarDatosPrecioDescuentos(articuloProveedorDTO.getId().getCodigoCompania(), articuloProveedorDTO.getId().getCodigoArticulo(),articuloProveedorDTO.getUserId());
							}
							
						}
					}
				}
				
				if( articuloProveedorDTO.getTieneArticulo() &&  SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO.compareTo(articuloProveedorDTO.getArticulo().getCodigoEstado()) == 0 )
					calculoArticuloProveedorGestor.asignarCondicionComercial(articuloProveedorDTO);
				
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException("Error en el proceso que verifica los cambios en el proveedor del art\u00EDculo",e);
		}
	}
	
	public Boolean verificarArticuloImportado(String codigoArticulo , Integer codigoCompania) throws SICException{
		return articuloProveedorDAO.verificarArticuloImportado(codigoArticulo, codigoCompania);
	}
	
	public Collection<ArticuloUnidadManejoProveedorDTO> obtenerDescuentosUnidadManejo(Collection<String> codArticuloProveedorCol,Integer codigoCompania) throws SICException{
		return articuloProveedorDAO.obtenerDescuentosUnidadManejo(codArticuloProveedorCol,codigoCompania);
		
	}
	
	public Collection<DescuentoProveedorArticuloDTO> obtenerDescuentosArticuloProv(Collection<String> codArticuloProveedorCol,Integer codigoCompania) throws SICException{
		return articuloProveedorDAO.obtenerDescuentosArticuloProv(codArticuloProveedorCol,codigoCompania);
	}
	
	/**
	 * Metodo que permite obtener las clasificaciones de un proveedor en las que se debe visualizar los precios en B2B
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<String> obtenerClasificacionesConPreciosB2B(Integer codigoCompania, String codigoProveedor) throws SICException{
		if(codigoCompania == null){
			throw new SICException("No existe codigo compania.");
		}
		if(codigoProveedor == null){
			throw new SICException("No existe codigo proveedor.");
		}
		String[] codigoDepartamentos = null;
		ParametroDTO parametroDTO = this.parametroGestor.obtenerParametro(codigoCompania, "ART6", "MAX");
		if(parametroDTO != null){
			codigoDepartamentos = parametroDTO.getValorParametro().split(",");
		}
		Collection<String> codigoClasificaciones = this.proveedorClasificacionDAO.obtenerClasificacionesPorDepartamento(codigoCompania, codigoProveedor, codigoDepartamentos);
		return codigoClasificaciones;
	}
	
	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @param accionArticuloProveedorGestor the accionArticuloProveedorGestor to set
	 */
	public void setAccionArticuloProveedorGestor(IAccionArticuloProveedorGestor accionArticuloProveedorGestor) {
		this.accionArticuloProveedorGestor = accionArticuloProveedorGestor;
	}

	/**
	 * @return the calculoArticuloProveedorGestor
	 */
	public ICalculoArticuloProveedorGestor getCalculoArticuloProveedorGestor() {
		return calculoArticuloProveedorGestor;
	}

	/**
	 * @param calculoArticuloProveedorGestor the calculoArticuloProveedorGestor to set
	 */
	public void setCalculoArticuloProveedorGestor(ICalculoArticuloProveedorGestor calculoArticuloProveedorGestor) {
		this.calculoArticuloProveedorGestor = calculoArticuloProveedorGestor;
	}

	/**
	 * @return the articuloProveedorDAO
	 */
	public IArticuloProveedorDAO getArticuloProveedorDAO() {
		return articuloProveedorDAO;
	}

	/**
	 * @param articuloProveedorDAO the articuloProveedorDAO to set
	 */
	public void setArticuloProveedorDAO(IArticuloProveedorDAO articuloProveedorDAO) {
		this.articuloProveedorDAO = articuloProveedorDAO;
	}

	/**
	 * @param articuloDAO the articuloDAO to set
	 */
	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}

	public void setArticuloProveedorImportacionGestor(IArticuloProveedorImportacionGestor articuloProveedorImportacionGestor) {
		this.articuloProveedorImportacionGestor = articuloProveedorImportacionGestor;
	}
	
	public ArticuloImportacionDTO obtenerArticuloImportacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException {
		return this.articuloProveedorDAO.obtenerArticuloImportacion(codigoCompania, codigoArticulo, codigoProveedor);
	}
	
	public Boolean tieneImpuestoDisney(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException {
		return this.articuloProveedorDAO.tieneImpuestoDisney(codigoCompania, codigoArticulo, codigoProveedor);
	}

	public IAlmacenamientoDatosCambioPreciosGestor getAlmacenamientoDatosCambioPreciosGestor() {
		return almacenamientoDatosCambioPreciosGestor;
	}

	public void setAlmacenamientoDatosCambioPreciosGestor(IAlmacenamientoDatosCambioPreciosGestor almacenamientoDatosCambioPreciosGestor) {
		this.almacenamientoDatosCambioPreciosGestor = almacenamientoDatosCambioPreciosGestor;
	}

	public void setProveedorClasificacionDAO(IProveedorClasificacionDAO proveedorClasificacionDAO) {
		this.proveedorClasificacionDAO = proveedorClasificacionDAO;
	}
}
