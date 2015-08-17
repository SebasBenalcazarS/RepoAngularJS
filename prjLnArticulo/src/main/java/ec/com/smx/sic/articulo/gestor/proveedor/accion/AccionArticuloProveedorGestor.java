/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.proveedor.accion;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;

import ec.com.integration.exception.IntegrationException;
import ec.com.integration.service.IntegrationServiceI;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.accion.IAccionArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.validacion.IValidacionUnidadManejoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.EquivalenciaPorcentajeDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.integracion.dto.articulo.RegistroArticuloProveedorDetalleIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroArticuloProveedorIDTO;
import ec.com.smx.sic.integracion.dto.articulo.UnidadManejoIDTO;
import ec.com.smx.sic.integracion.resources.SICIntegracionMessages;
import ec.com.smx.sic.integracion.util.SICIntegracion;
import ec.com.smx.sic.integracion.util.UtilIntegracion;

/**
 * @author fmunoz
 *
 */
public class AccionArticuloProveedorGestor implements IAccionArticuloProveedorGestor{
	
	private DataGestor dataGestor;
	private IValidacionUnidadManejoGestor validacionUnidadManejoGestor;
	private final String FORMATO_DOS_DECIMALES= "0.00";
	private final String FORMATO_CUATRO_DECIMALES= "0.0000";
	private final String DESCUENTO_CERO = "0000";
	private final Double CERO_DOUBLE = 0D;
	private final String STRING_VACIO= " ";
	private Boolean esIntegracionActiva = Boolean.TRUE;
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.proveedor.accion.IAccionArticuloProveedorGestor#transferirDatosArticuloProveedorSIC(java.util.Collection)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void transferirDatosArticuloProveedorSIC(Collection<ArticuloProveedorDTO> artProCol, Boolean esAsincrono, Object servicioIntegracion) throws SICException{
		
		try{
			if(esIntegracionActiva){
				DecimalFormat df = new DecimalFormat(FORMATO_DOS_DECIMALES, DecimalFormatSymbols.getInstance(Locale.US));
				Collection<CatalogoValorDTO> unidadesEmpaque = null;
				ArticuloProveedorDTO referencia = artProCol.iterator().next();
				Boolean usarIntegracionCompleta = referencia.getDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA) != null;
				List<ArticuloProveedorDTO> artProList = new ArrayList<ArticuloProveedorDTO>(artProCol);
				Collections.sort(artProList, new Comparator<ArticuloProveedorDTO>() {
					@Override
					public int compare(ArticuloProveedorDTO o1, ArticuloProveedorDTO o2) {
						return o1.getId().getCodigoArticulo().compareTo(o2.getId().getCodigoArticulo());
					}
				});
				String tipoProceso = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.articuloProveedor");
				//ArticuloProveedorDTO primero = artProList.iterator().next();
				if(usarIntegracionCompleta){
					tipoProceso = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.articuloProveedor.max");
				}
				Collection<ArticuloUnidadManejoDTO> eansDuplicados = null;
				int inicio = 0;
				int fin = SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_PROVEEDOR.intValue();
				int iteraciones = 1;
				int residuo = 0;
				iteraciones = artProCol.size() / SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_PROVEEDOR.intValue();
				residuo = artProCol.size() % SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_PROVEEDOR.intValue();
				Collection<ArticuloProveedorDTO> subcoleccion = artProList;
				if(iteraciones == 0){
					iteraciones = 1;
				}else if(residuo > 0){
					iteraciones++;
				}
				//se envia los datos particionados
				for(int i = 1; i<=iteraciones;i++){
					if(iteraciones > 1){
						if(iteraciones > i){
							subcoleccion = artProList.subList(inicio, fin);
						}else{
							subcoleccion = artProList.subList(inicio, artProList.size());
						}
					}
					inicio = inicio + SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_PROVEEDOR.intValue();
					fin = fin + SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_PROVEEDOR.intValue();
					
					RegistroArticuloProveedorIDTO regArtPro = new RegistroArticuloProveedorIDTO();
					regArtPro.getControlProceso().setCodigoCompania(!artProCol.isEmpty() ? referencia.getId().getCodigoCompania(): null);
					regArtPro.getControlProceso().setProceso(tipoProceso);
					regArtPro.setUsuarioRegistro(!artProCol.isEmpty() ? referencia.getUserId() : null);
					regArtPro.setDetalle(new ArrayList<RegistroArticuloProveedorDetalleIDTO>());
					
					String codigoArticuloReferencia = null;
					for(ArticuloProveedorDTO dto : subcoleccion){
						if(dto.getTransferirDatosSIC()){
							RegistroArticuloProveedorDetalleIDTO item = new RegistroArticuloProveedorDetalleIDTO();
							if(esAsincrono){
								if(TipoCatalogoArticulo.PROCESO_INTEGRACION_CREACIONARTICULO.equals((String)dto.getArticulo().getDynamicProperty(ArticuloTransient.PROCESO_INTEGRACION_SIC))){
									inicializacionPrimeraUnidadManejo(item);
								}
							}else if(usarIntegracionCompleta){
								completarDatosCreacionArticuloProveedor(dto, item);
							}
							item.setCodigoBarras(dto.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
							item.setCodigoProveedor(dto.getVistaProveedor().getCodigoJDEProveedor());
							
							if(StringUtils.isNotEmpty(dto.getCodigoReferenciaProveedor())){
								item.setCodigoReferenciaProveedor(dto.getCodigoReferenciaProveedor());
							}else{
								item.setCodigoReferenciaProveedor(STRING_VACIO);
							}
							if(StringUtils.isNotEmpty(dto.getCodigoReferenciaInterna())){
								item.setCodigoReferenciaInterna(dto.getCodigoReferenciaInterna());
							}else{
								item.setCodigoReferenciaInterna(STRING_VACIO);
							}
							if(StringUtils.isNotEmpty(dto.getEstadoArticuloProveedor())){
								item.setEstado(dto.getEstadoArticuloProveedor());}
							if(dto.getCostoBruto() != null){
								df.applyPattern(FORMATO_CUATRO_DECIMALES);
								item.setCostoBruto(df.format(dto.getCostoBruto()));}
							if(dto.getPorcentajeExesoRecepcion() != null){
								item.setPorcentajeExesoRecepcion(dto.getPorcentajeExesoRecepcion());}
							//datos de importacion
							if(dto.getTieneArticuloImportacion()){
								df.applyPattern(FORMATO_DOS_DECIMALES);
								if(dto.getArticuloImportacion().getCostoMonedaOrigen() != null){
									item.setCostoMonedaOrigen(df.format(dto.getTieneArticuloProveedorImpuestos() ? dto.getArticuloImportacion().getCostoMonedaOrigenImp() :dto.getArticuloImportacion().getCostoMonedaOrigen()));
								}
								if(dto.getArticuloImportacion().getPorcentajeComision() != null){
									item.setPorcentajeComision(dto.getArticuloImportacion().getPorcentajeComision());
								}
								if(dto.getArticuloImportacion().getCostoMonedaOrigen() != null){
									item.setCostoDerechoImportacion(df.format(dto.getTieneArticuloProveedorImpuestos() ? dto.getArticuloImportacion().getCostoDerechoImportacionImp() : dto.getArticuloImportacion().getCostoDerechoImportacion()));
								}
								
							}
							//cadena de descuento
							if(dto.getDescuentoProveedorArticuloCol() != null && !SearchDTO.isLazy(dto.getDescuentoProveedorArticuloCol())){
								item.setPorcentajeDescuento1(DESCUENTO_CERO);
								item.setPorcentajeDescuento2(DESCUENTO_CERO);
								item.setPorcentajeDescuento3(DESCUENTO_CERO);
								item.setPorcentajeDescuento4(DESCUENTO_CERO);
								item.setPorcentajeExedenteProducto(DESCUENTO_CERO);
								for(DescuentoProveedorArticuloDTO dpa : dto.getDescuentoProveedorArticuloCol()){ // <>TIPODESCUENTO
									if(dpa.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
										if(SICArticuloConstantes.getInstancia().TIPODESCUENTO1.equals(dpa.getAsignacionTipoDescuento().getCodigoTipoDescuento())){
											item.setPorcentajeDescuento1(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(dpa.getPorcentajeDescuento()));
											
										}else if(SICArticuloConstantes.getInstancia().TIPODESCUENTO2.equals(dpa.getAsignacionTipoDescuento().getCodigoTipoDescuento())){
											item.setPorcentajeDescuento2(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(dpa.getPorcentajeDescuento()));
											
										}else if(SICArticuloConstantes.getInstancia().TIPODESCUENTO3.equals(dpa.getAsignacionTipoDescuento().getCodigoTipoDescuento())){
											item.setPorcentajeDescuento3(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(dpa.getPorcentajeDescuento()));
											
										}else if(SICArticuloConstantes.getInstancia().TIPODESCUENTO4.equals(dpa.getAsignacionTipoDescuento().getCodigoTipoDescuento())){
											item.setPorcentajeDescuento4(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(dpa.getPorcentajeDescuento()));
											
										}else if(SICArticuloConstantes.getInstancia().TIPODESCUENTO_PORCENTAJEPRODUCTO.equals(dpa.getAsignacionTipoDescuento().getCodigoTipoDescuento())
												&& dpa.getTieneEquivalenciaPorcentajeDescuento()){
											item.setPorcentajeExedenteProducto(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(dpa.getEquivalenciaPorcentajeDescuento().getDescuento()));
										}
									}
								}
							}
							
							//unidades de manejo
							if(dto.getTieneUnidadesManejo()){
								Collection<ArticuloUnidadManejoProveedorDTO> unidadesRecepcion = null;
								if(dto.getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) != null || esAsincrono){
									unidadesRecepcion = dto.getUnidadesManejo();
								}else{
									ArticuloUnidadManejoProveedorDTO filtro = construirRelacionesUnidadManejo();
									filtro.getId().setCodigoCompania(dto.getId().getCodigoCompania());
									filtro.getId().setCodigoProveedor(dto.getId().getCodigoProveedor());
									filtro.setCodigoArticulo(dto.getId().getCodigoArticulo());
									filtro.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									unidadesRecepcion = dataGestor.findObjects(filtro);
								}
								
								if(unidadesRecepcion != null){
									Collections.sort((List<ArticuloUnidadManejoProveedorDTO>)unidadesRecepcion, new Comparator<ArticuloUnidadManejoProveedorDTO>() {
										@Override
										public int compare(ArticuloUnidadManejoProveedorDTO o1, ArticuloUnidadManejoProveedorDTO o2) {
											return o1.getArticuloUnidadManejoDTO().getPrioridad().compareTo(o2.getArticuloUnidadManejoDTO().getPrioridad());
										}
									});
									for(final ArticuloUnidadManejoProveedorDTO aum : unidadesRecepcion){
										// validar que no se envie unidad de manejo mayoreo si existiera
										if(StringUtils.isNotEmpty(aum.getArticuloUnidadManejoDTO().getValorTipoUnidadEmpaque()) 
												&& !aum.getArticuloUnidadManejoDTO().getValorTipoUnidadEmpaque().equals(SICArticuloConstantes.TIPOEMPAQUE_MAYORISTA)){
											UnidadManejoIDTO unidad = new UnidadManejoIDTO();
											unidad.setDescuentoDocenas(DESCUENTO_CERO);
											unidad.setAlto(CERO_DOUBLE);
											unidad.setAncho(CERO_DOUBLE);
											unidad.setProfundidad(CERO_DOUBLE);
											unidad.setPeso(CERO_DOUBLE);
											unidad.setCantidadCajasPallet(0);
											if(StringUtils.isNotEmpty(aum.getArticuloUnidadManejoDTO().getCodigoBarrasUnidadManejo())){
												unidad.setCodigoBarrasEAN14(Long.valueOf(aum.getArticuloUnidadManejoDTO().getCodigoBarrasUnidadManejo()));
											}
											unidad.setCantidad(aum.getArticuloUnidadManejoDTO().getValorUnidadManejo());
											if(StringUtils.isNotEmpty(aum.getArticuloUnidadManejoDTO().getValorTipoUnidadEmpaque()) && !aum.getArticuloUnidadManejoDTO().getValorTipoUnidadEmpaque().equals(SICConstantes.VALOR_NOASIGNADO)){
												String unidadEmpaque = null;
												if(aum.getArticuloUnidadManejoDTO().getTieneTipoUnidadEmpaque() && StringUtils.isNotEmpty(aum.getArticuloUnidadManejoDTO().getTipoUnidadEmpaque().getCodigoExterno())){
													unidadEmpaque = aum.getArticuloUnidadManejoDTO().getTipoUnidadEmpaque().getCodigoExterno();
												}else{
													CatalogoValorDTO cat = null;
													if(unidadesEmpaque == null){
														cat = new CatalogoValorDTO();
														cat.getId().setCodigoCatalogoTipo(SICArticuloConstantes.getInstancia().CODIGOTIPOEMPAQUE);
														unidadesEmpaque = dataGestor.findObjects(cat);
													}
													cat = (CatalogoValorDTO)CollectionUtils.find(unidadesEmpaque, new Predicate() {
														@Override
														public boolean evaluate(Object arg0) {
															return ((CatalogoValorDTO)arg0).getId().getCodigoCatalogoValor().equals(aum.getArticuloUnidadManejoDTO().getValorTipoUnidadEmpaque());
														}
													});
													unidadEmpaque = cat.getCodigoExterno();
												}
												unidad.setUnidadEmpaque(Integer.valueOf(unidadEmpaque));
											}else{
												unidad.setUnidadEmpaque(Integer.valueOf(SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PIEZA_SIC));
											}
											
											if(aum.getArticuloUnidadManejoDTO().getAlto() != null){
												unidad.setAlto(aum.getArticuloUnidadManejoDTO().getAlto());
											}
											if(aum.getArticuloUnidadManejoDTO().getAncho() != null){
												unidad.setAncho(aum.getArticuloUnidadManejoDTO().getAncho());
											}
											if(aum.getArticuloUnidadManejoDTO().getProfundidad() != null){
												unidad.setProfundidad(aum.getArticuloUnidadManejoDTO().getProfundidad());
											}
											if(aum.getArticuloUnidadManejoDTO().getPeso() != null){
												unidad.setPeso(aum.getArticuloUnidadManejoDTO().getPeso());
											}
											if(aum.getArticuloUnidadManejoDTO().getTieneArticuloUnidadManejoContenedora()){
												for(ArticuloUnidadManejoDTO umc : aum.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol()){
													if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(umc.getEstadoUnidadManejo()) && umc.getValorUnidadManejo() != null){
														unidad.setCantidadCajasPallet(umc.getValorUnidadManejo());
														break;
													}
												}
											}
											if(aum.getTieneEquivalenciaPorcentajeDescuento() && aum.getEquivalenciaPorcentajeDescuentoDTO().getDescuento() != null ){
												unidad.setDescuentoDocenas(UtilIntegracion.construirCadenaNumericaDescuentoValidaSIC(aum.getEquivalenciaPorcentajeDescuentoDTO().getDescuento()));
											}
											if(aum.getArticuloUnidadManejoDTO().getPrioridad().intValue() == 1 && StringUtils.equals(aum.getArticuloUnidadManejoDTO().getEstadoUnidadManejo(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
												item.setUnidadManejo1(unidad);
											}else if(aum.getArticuloUnidadManejoDTO().getPrioridad().intValue() == 2 && StringUtils.equals(aum.getArticuloUnidadManejoDTO().getEstadoUnidadManejo(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
												item.setUnidadManejo2(unidad);
											}else if(aum.getArticuloUnidadManejoDTO().getPrioridad().intValue() == 3 && StringUtils.equals(aum.getArticuloUnidadManejoDTO().getEstadoUnidadManejo(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
												item.setUnidadManejo3(unidad);
											}else if(aum.getArticuloUnidadManejoDTO().getPrioridad().intValue() == 4 && StringUtils.equals(aum.getArticuloUnidadManejoDTO().getEstadoUnidadManejo(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
												item.setUnidadManejo4(unidad);
											}
										}
									}
								}
							}
							regArtPro.getDetalle().add(item);
							
							if(!dto.getId().getCodigoArticulo().equals(codigoArticuloReferencia)){
								if(esAsincrono){
									ArticuloUnidadManejoDTO aumFiltro = new ArticuloUnidadManejoDTO();
									aumFiltro.getId().setCodigoCompania(dto.getId().getCodigoCompania());
									aumFiltro.getId().setCodigoArticulo(dto.getId().getCodigoArticulo());
									aumFiltro.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									//se realiza la consulta de los EANs duplicados en ese momento
									eansDuplicados = validacionUnidadManejoGestor.validarUnicidadEAN14(new ArticuloVO(dto.getArticulo()), dataGestor.findObjects(aumFiltro));
								}else{
									eansDuplicados = (Collection<ArticuloUnidadManejoDTO>)dto.getArticulo().getDynamicProperty(ArticuloTransient.CODIGOS_EAN_DUPLICADOS);
								}
								
								//se envian los registros donde se deben borrar los EANs
								if(!CollectionUtils.isEmpty(eansDuplicados)){
									RegistroArticuloProveedorDetalleIDTO item2 = null;
									String codigoProveedor = "";
									String codigoArticulo = "";
									for(ArticuloUnidadManejoDTO aum : eansDuplicados){
										codigoProveedor = "";
										item2 = null;
										if(CollectionUtils.isNotEmpty(aum.getArticuloUnidadManejoProveedorCol())){
											aum.setArticuloUnidadManejoProveedorCol(ColeccionesUtil.sort(aum.getArticuloUnidadManejoProveedorCol(), ColeccionesUtil.ORDEN_ASC, "id.codigoProveedor"));
											for(ArticuloUnidadManejoProveedorDTO ump : aum.getArticuloUnidadManejoProveedorCol()){
												if(ump.getVistaProveedorDTO() != null && !StringUtils.isEmpty(ump.getVistaProveedorDTO().getCodigoJDEProveedor())){
													if(!codigoArticulo.equals(aum.getId().getCodigoArticulo()) || !codigoProveedor.equals(ump.getId().getCodigoProveedor())){
														item2 = new RegistroArticuloProveedorDetalleIDTO();
														item2.setCodigoBarras(aum.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
														item2.setCodigoProveedor(ump.getVistaProveedorDTO().getCodigoJDEProveedor());
														regArtPro.getDetalle().add(item2);
													}
													if(item2 != null){
														//se crea la unidad de manejo
														UnidadManejoIDTO unidad = new UnidadManejoIDTO();
														unidad.setCodigoBarrasEAN14(0l);
														if(aum.getPrioridad().intValue() == 1){
															item2.setUnidadManejo1(unidad);
														}else if(aum.getPrioridad().intValue() == 2){
															item2.setUnidadManejo2(unidad);
														}else if(aum.getPrioridad().intValue() == 3){
															item2.setUnidadManejo3(unidad);
														}else if(aum.getPrioridad().intValue() == 4){
															item2.setUnidadManejo4(unidad);
														}
													}
												}
												codigoProveedor = ump.getId().getCodigoProveedor();
												codigoArticulo = aum.getId().getCodigoArticulo();
											}
										}
									}
								}
							}
							codigoArticuloReferencia = dto.getId().getCodigoArticulo();
						}
					}
				
					if(!regArtPro.getDetalle().isEmpty()){
						IntegrationServiceI integrationServiceI = (IntegrationServiceI)servicioIntegracion;
						if(integrationServiceI != null){
							SICIntegracion.procesarMensaje(regArtPro, integrationServiceI);
						}else{
							SICIntegracion.procesarMensaje(regArtPro);
						}
					}
					
					regArtPro = null;
				}
			}
		}catch (IntegrationException e) {
			StringBuilder mensajeError = new StringBuilder(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.proveedor"))
			.append("en el SIC: {0}");
			SICException se = new SICException(MessageFormat.format(mensajeError.toString(), e.getMessage()), e);
			se.setCodigoError(SICIntegracionMessages.CODIGO_ERROR_INTEGRACION);
			throw se;
		}catch (Exception e) {
			throw new SICException("Error al intentar enviar los datos del art\u00EDculo-proveedor al SIC",e);
		}
	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.proveedor.accion.IAccionArticuloProveedorGestor#transferirDatosArticuloProveedorSIC(ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO)
	 */
	@Override
	public void transferirDatosArticuloProveedorSIC(ArticuloProveedorDTO ap, Boolean esAsincrono, Object servicioIntegracion) throws SICException{
		Collection<ArticuloProveedorDTO> items = new ArrayList<ArticuloProveedorDTO>();
		items.add(ap);
		transferirDatosArticuloProveedorSIC(items, esAsincrono, servicioIntegracion);
	}
	
	private void completarDatosCreacionArticuloProveedor(ArticuloProveedorDTO ap, RegistroArticuloProveedorDetalleIDTO item){
		if(ap.getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) != null){
			
			ArticuloProveedorDTO filtro = new ArticuloProveedorDTO();
			filtro.getId().setCodigoCompania(ap.getId().getCodigoCompania());
			filtro.getId().setCodigoArticulo(ap.getId().getCodigoArticulo());
			filtro.getId().setCodigoProveedor(ap.getId().getCodigoProveedor());
			construirRelacionesArticuloProveedor(filtro);
			
			filtro = dataGestor.findUnique(filtro);
			ap.setArticuloImportacion(filtro.getArticuloImportacion());
			ap.setUnidadesManejo(filtro.getUnidadesManejo());
			ap.setDescuentoProveedorArticuloCol(filtro.getDescuentoProveedorArticuloCol());
			
			inicializacionPrimeraUnidadManejo(item);
			filtro = null;
		}
	}
	
	public void construirRelacionesArticuloProveedor(ArticuloProveedorDTO filtro){
		filtro.setArticuloImportacion(new ArticuloImportacionDTO());
		filtro.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
		filtro.setDescuentoProveedorArticuloCol(new ArrayList<DescuentoProveedorArticuloDTO>());
		//relacion con los descuentos
		DescuentoProveedorArticuloDTO dpa = new DescuentoProveedorArticuloDTO();
		dpa.setEquivalenciaPorcentajeDescuento(new EquivalenciaPorcentajeDescuentoDTO());
		dpa.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
		//relacion con la unidad de manejo
		ArticuloUnidadManejoProveedorDTO aum = construirRelacionesUnidadManejo();
		//aum.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("articuloUnidadManejoDTO.codigoUnidadManejoContenida", ComparatorTypeEnum.IS_NULL));
		//asignacion de relaciones
		filtro.getUnidadesManejo().add(aum);
		filtro.getDescuentoProveedorArticuloCol().add(dpa);
	}

	private ArticuloUnidadManejoProveedorDTO construirRelacionesUnidadManejo(){
		ArticuloUnidadManejoProveedorDTO filtro = new ArticuloUnidadManejoProveedorDTO();
		filtro.setArticuloUnidadManejoDTO(new ArticuloUnidadManejoDTO());
		filtro.getArticuloUnidadManejoDTO().setArticuloUnidadManejoContenedoraCol(new ArrayList<ArticuloUnidadManejoDTO>());
		filtro.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol().add(new ArticuloUnidadManejoDTO());

		filtro.setEquivalenciaPorcentajeDescuentoCol(new ArrayList<EquivalenciaPorcentajeDescuentoDTO>());
		filtro.getEquivalenciaPorcentajeDescuentoCol().add(new EquivalenciaPorcentajeDescuentoDTO());
		filtro.getEquivalenciaPorcentajeDescuentoCol().iterator().next().setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
		//filtro.setEquivalenciaPorcentajeDescuentoDTO(new EquivalenciaPorcentajeDescuentoDTO());
		return filtro;
	}
	
	private void inicializacionPrimeraUnidadManejo(RegistroArticuloProveedorDetalleIDTO item){
		//inicializacion de la primera unidad de manejo
		item.getUnidadManejo1().setCantidad(1);
		item.getUnidadManejo1().setUnidadEmpaque(Integer.valueOf(SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PIEZA_SIC));
		item.getUnidadManejo1().setCantidadCajasPallet(0);
	}
	/**
	 * @return the dataGestor
	 */
	public DataGestor getDataGestor() {
		return dataGestor;
	}
	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	public void setValidacionUnidadManejoGestor(IValidacionUnidadManejoGestor validacionUnidadManejoGestor) {
		this.validacionUnidadManejoGestor = validacionUnidadManejoGestor;
	}
}
