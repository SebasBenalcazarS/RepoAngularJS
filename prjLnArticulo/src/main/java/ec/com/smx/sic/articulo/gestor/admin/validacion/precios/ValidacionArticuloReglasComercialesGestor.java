package ec.com.smx.sic.articulo.gestor.admin.validacion.precios;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.loggin.resources.LogUtilMessages;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.articulo.gestor.admin.calculo.CalculoArticuloGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloValidacion;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.precios.IValidacionArticuloReglasComercialesGestor;
import ec.com.smx.sic.cliente.gestor.bodega.administracion.calculo.ICalculoAlmacenamientoEstructuraLogisticaGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

@SuppressWarnings("serial")
public class ValidacionArticuloReglasComercialesGestor implements IValidacionArticuloReglasComercialesGestor, Serializable, Logeable {

	private CalculoArticuloGestor calculoArticuloGestor;
	
	private ICalculoAlmacenamientoEstructuraLogisticaGestor calculoAlmacenamientoEstructuraLogisticaGestor;
	
	private IParametroGestor parametroGestor;
	
	private final String[] PARAMETROS_MAX = new String[] { 
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
	
	@Override
	public void validarPreciosCostos(final Integer presentacion, final Boolean ventaPrecioAfiliado, final Double porcentajeNA, Double costoBruto, Double precioBase, Double pvp, Collection<ArticuloImpuestoDTO> articuloImpuestos
			, final Collection<DescuentoProveedorArticuloDTO> descuentosProveedor , final Set<EnumCaracteristicaDinamica> caracteristicasDinamicas) throws SICRuleException{
		try{
			Double precioBaseNA = precioBase;
			Double costoBrutoImp = null;
			Double costoNeto = null;
			Double costoNetoImp = null;
			Double precioBaseImp = null;
			Double pvpImp = null;
			Double margen = null;
			
			LOG_SICV2.info("==================ENTRADAS =====================");
			LOG_SICV2.info("Presentacion: {}",presentacion);
			LOG_SICV2.info("Costo bruto: {}",costoBruto);
			LOG_SICV2.info("Precio base: {}",precioBase);
			LOG_SICV2.info("Pvp: {}",pvp);
			LOG_SICV2.info("Porcentaje NA: {}", porcentajeNA);
			LOG_SICV2.info("Venta Precio Afiliado: {}", ventaPrecioAfiliado);
			
			/**Validaciones para costos del articulo**/
			

			if(costoBruto == null || costoBruto.compareTo(Double.valueOf(0)) == 0){
				throw new SICRuleException("El costo bruto no puede ser "+ Double.valueOf(0) + " o nulo");
			}else{
				Map<String, Double> impuestosCompra = SICArticuloCalculo.getInstancia().obtenerValoresImpuesto(articuloImpuestos, presentacion, Boolean.FALSE);		
				
				costoBrutoImp = impuestosCompra == null ? costoBruto : SICArticuloCalculo.getInstancia().calcularValorConImpuestos(costoBruto, impuestosCompra, Boolean.FALSE);
				
				costoNeto = this.calculoArticuloGestor.calcularCostoNeto(costoBruto, descuentosProveedor, null);
				
				if(costoNeto != null && impuestosCompra != null){
					costoNetoImp = SICArticuloCalculo.getInstancia().calcularValorConImpuestos(costoNeto, impuestosCompra, Boolean.FALSE);
				}
			}
			
			if(precioBase == null){
				throw new SICRuleException("El precio base no puede ser nulo.");
			}else{
				if(BooleanUtils.isFalse(ventaPrecioAfiliado)){
					precioBaseNA = SICArticuloCalculo.getInstancia().calcularPrecioBaseNoAfiliado(precioBase, porcentajeNA);
				}
				
				if(caracteristicasDinamicas != null && !caracteristicasDinamicas.contains(EnumCaracteristicaDinamica.CARACTERISTICA_NOAPLICAPVP)){
					if(precioBaseNA > pvp){
						DecimalFormat formatter = new DecimalFormat("0.00");
						formatter.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
						throw new SICRuleException(MessageFormat.format("El precio supermaxi NA: {0} no debe ser mayor al PVP: {1}", new Object[]{formatter.format(precioBaseNA), formatter.format(pvp)}));
					}
				}
				
				Map<String, Double> impuestosVenta = SICArticuloCalculo.getInstancia().obtenerValoresImpuesto(articuloImpuestos, presentacion, Boolean.TRUE);
				
				if(impuestosVenta != null && precioBase != null){
					precioBaseImp = SICArticuloCalculo.getInstancia().calcularValorConImpuestos(precioBase, impuestosVenta, Boolean.TRUE);
				}
				if(caracteristicasDinamicas != null && !caracteristicasDinamicas.contains(EnumCaracteristicaDinamica.CARACTERISTICA_NOAPLICAPVP)){
					pvpImp = (impuestosVenta == null || pvp == null)  ? pvp : SICArticuloCalculo.getInstancia().calcularValorConImpuestos(pvp, impuestosVenta, Boolean.TRUE);
					if(pvp != null && pvp < precioBase){
						throw new SICRuleException(MessageFormat.format("El PVP debe ser mayor al precio supermaxi: {0}",precioBase));
					}
				}
			}
			
			if(caracteristicasDinamicas != null && !caracteristicasDinamicas.contains(EnumCaracteristicaDinamica.CARACTERISTICA_COSTOBRUTOMAYORPVP)){
				if(precioBase < costoNeto){
					throw new SICRuleException(MessageFormat.format("El precio base debe ser mayor a costo neto: {0}",costoNeto));
				}
			}else if(caracteristicasDinamicas != null &&  !caracteristicasDinamicas.contains(EnumCaracteristicaDinamica.CARACTERISTICA_PSUPMAYORCOSTONETO)){
				if(pvp != null && pvp < costoNeto){
					throw new SICRuleException(MessageFormat.format("El PVP debe ser mayor a costo neto: {0}",costoNeto));
				}
			}else{
				if(precioBase < costoNeto){
					throw new SICRuleException(MessageFormat.format("El precio base debe ser mayor a costo neto: {0}",costoNeto));
				}
				if(pvp != null && pvp < costoNeto){
					throw new SICRuleException(MessageFormat.format("El PVP debe ser mayor a costo neto: {0}",costoNeto));
				}
			}
			
			/*Validacion para que el costo neto no sea igual a 0*/
			
			if(costoNeto != null && costoNeto.compareTo(Double.valueOf(0)) == 0){
				throw new SICRuleException(MessageFormat.format("El Costo Neto no puede ser igual a 0", costoNeto));
			}
			
			/*Validacion para el margen entre el costo neto y el precio base*/
			if(costoNeto != null && costoNeto > 0 && precioBase != null){
				margen = SICArticuloCalculo.getInstancia().calcularMargenPrecio(precioBase, costoNeto);
				if(margen == null){
					throw new SICRuleException("El margen no puede ser nulo.");
				}
				String costoNetoString = String.valueOf(costoNeto);
				costoNetoString = StringUtils.replace(costoNetoString, ",", ".");
				if(caracteristicasDinamicas != null && caracteristicasDinamicas.contains(EnumCaracteristicaDinamica.CARACTERISTICA_MSMX_MAYOR_IGUAL_DOCE_PORCIENTO)){
					if(margen != null && (margen < SICArticuloConstantes.VALOR_MINIMO_MARGEN || margen > 99.99)){
						throw new SICRuleException(MessageFormat.format("El margen calculado entre el Costo neto {0} y el Precio Supermaxi {1} debe ser mayor o igual a {2} % y menor a {3} %", costoNetoString, Double.valueOf(precioBase), SICArticuloConstantes.VALOR_MINIMO_MARGEN, Double.valueOf(100)));
					}
				}else{
					if(margen != null && (margen < 0 || margen > 99.99)){
						throw new SICRuleException(MessageFormat.format("El margen calculado entre el Costo neto {0} y el Precio Supermaxi {1} debe ser mayor a {2} % y menor a {3} %", costoNetoString, Double.valueOf(precioBase), Double.valueOf(0), Double.valueOf(100)));
					}
				}
			}
			
			LOG_SICV2.info("==================COSTOS =====================");
			LOG_SICV2.info("Costo bruto: {}",costoBruto);
			LOG_SICV2.info("Costo bruto imp: {}",costoBrutoImp);
			LOG_SICV2.info("Costo neto: {}",costoNeto);
			LOG_SICV2.info("Costo neto imp: {}",costoNetoImp);
			
			LOG_SICV2.info("==================PRECIOS =====================");
			LOG_SICV2.info("Precio base: {}",precioBase);
			LOG_SICV2.info("Precio base imp: {}",precioBaseImp);
			LOG_SICV2.info("Pvp: {}",pvp);
			LOG_SICV2.info("Pvp imp: {}",pvpImp);
			
		}catch(SICRuleException e){
			throw e;
		}catch(Exception ex){
			throw new SICRuleException("Ocurrio un error al evaluar reglas comerciales.",ex);
		}
	}
	
	/**
	 * metodo booleano que verifica en base a varias condiciones si el articulo aplcia mayoreo o no
	 * @param parametros
	 * @param codigoCompania
	 * @param articuloVO
	 * @return
	 */
	@Override
	public Boolean validarAplicaMayoreo(ArticuloDTO articuloDTO) throws SICException{
		
		try{
			
			Logeable.LOG_SICV2.info("Ingreso al metodo validarAplicaMayoreo");
			
			Collection<ParametroDTO> parametrosCol = this.parametroGestor.obtenerParametros(articuloDTO.getId().getCodigoCompania(), articuloDTO.getCodigoSistemaOrigen(), PARAMETROS_MAX);
			
			Boolean aplicaMayoreo = Boolean.FALSE;
			
			//propiedad usada para validar al momento de cambiar la clase, desde la parte web
			articuloDTO.removeDynamicProperty("clasificacionValida");
			
			aplicaMayoreo = this.validarMayoreoDivisiones(articuloDTO , parametrosCol);
			
			if(BooleanUtils.isFalse(aplicaMayoreo)){
				aplicaMayoreo = this.validarMayoreoCodigoSecuencia(articuloDTO , parametrosCol);
				
				if(BooleanUtils.isFalse(aplicaMayoreo)){
					aplicaMayoreo = this.validarMayoreoDepartamento(articuloDTO , parametrosCol);
					
					if(BooleanUtils.isFalse(aplicaMayoreo)){
						aplicaMayoreo = this.validarMayoreoClasificacion(articuloDTO , parametrosCol);
						
						if(BooleanUtils.isFalse(aplicaMayoreo)){
							aplicaMayoreo = this.validarMayoreoClasificacionSubclasificacion(articuloDTO , parametrosCol);
							
							if(BooleanUtils.isFalse(aplicaMayoreo)){
								aplicaMayoreo = this.validarMayoreoProveedor(articuloDTO , parametrosCol);
								
								if(BooleanUtils.isFalse(aplicaMayoreo)){
									aplicaMayoreo = this.validarMayoreoClase(articuloDTO , parametrosCol);
								}
							}
						}
					}
				}
			}
			
			return BooleanUtils.isFalse(aplicaMayoreo);
		}catch (Exception e){
			LOG_SICV2.info("ocurrio un  error al validar las condiciones de mayoreo "+e.getMessage());
			throw new SICException("Ocurrio un error al validar los articulos.",e);
		}
		
	}
	
	/**
	 * @author mgranda
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	@Override
	public EnumTipoPrecio obtenerTipoPrecioLocal(ArticuloDTO articuloDTO) throws SICException{
		try{
			EnumTipoPrecio enumTipoPrecio = EnumTipoPrecio.NINGUNO;
			if(this.aplicaPrecioCajaLocal(articuloDTO)){
				enumTipoPrecio = EnumTipoPrecio.PRECIO_CAJA;
			}else if(this.aplicaPrecioMayoreoLocal(articuloDTO)){
				enumTipoPrecio = EnumTipoPrecio.PRECIO_MAYORISTA;
			}
			return  enumTipoPrecio;
		}catch(SICException exception){
			throw exception;
		}catch(Exception exception){
			throw new SICException("Ocurrio un error al obtener el tipo de precio por local.",exception);
		}
	}
	
	private Boolean habilitadoTipoPrecioLocal(ArticuloDTO articuloDTO, String tipo){
		if(articuloDTO.getTieneArticuloPrecio()){
			Boolean habilitado = Boolean.FALSE;
			for(ArticuloPrecioDTO ap: articuloDTO.getArticuloPrecioCol()){
				if(ap.getId().getCodigoTipoPrecio().equals(tipo) && this.esUnidadActivaDesdePrecio(ap)){
					habilitado = ap.getNpArticuloLocalPrecio() != null && ap.getNpArticuloLocalPrecio().getEstadoPrecio().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					if(tipo.equals(SICArticuloConstantes.TIPO_PRECIO_MAYORISTA))
						return habilitado && SICArticuloValidacion.getInstancia().calcularPrecioMayorista(articuloDTO);
					return habilitado;
				}
			}
			return Boolean.FALSE;
		}
		return null;
	}
	
	private Boolean esUnidadActivaDesdePrecio(ArticuloPrecioDTO ap){
		return ap.getCodigoUnidadManejo() != null ? SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(ap.getArticuloUnidadManejo().getEstadoUnidadManejo()) : Boolean.TRUE;
	}
	
	/**
	 * @author mgranda
	 * @param articuloVO
	 * @return
	 */
	@Override
	public Boolean aplicaPrecioMayoreoLocal(ArticuloDTO articuloDTO) throws SICException{
		try{
			Boolean aplicaPrecioMayoreoEnLocal = Boolean.FALSE;		
			if(articuloDTO.getNpCodigoLocal() == null){
				throw new SICException("El art\u00EDculo no posee c\u00F3digo de local.");
			}
			Boolean aplicaPrecioMayoreoArticulo = this.validarAplicaMayoreo(articuloDTO) && articuloDTO.getTienePrecioMayoreo() && SICArticuloValidacion.getInstancia().calcularPrecioMayorista(articuloDTO);
			if(BooleanUtils.isTrue(aplicaPrecioMayoreoArticulo)){
				Collection<ParametroDTO> localesMayoreo = this.parametroGestor.obtenerParametros(articuloDTO.getId().getCodigoCompania(),LogUtilMessages.getInstancia().getString("log.sistema.SISPE"), SICParametros.PARAMETRO_CODIGO_LOCALES_PRECIO_MAYOREO);
				if(CollectionUtils.isNotEmpty(localesMayoreo)){
					String[] codicionLocalesMayoreo = this.buscarParametro(SICParametros.PARAMETRO_CODIGO_LOCALES_PRECIO_MAYOREO, localesMayoreo);
					aplicaPrecioMayoreoEnLocal = this.verificarCondicionEnParametro (String.valueOf(articuloDTO.getNpCodigoLocal()), codicionLocalesMayoreo);
				}
			}
			return (aplicaPrecioMayoreoArticulo && (aplicaPrecioMayoreoEnLocal || this.aplicaPrecioMayoreoEstablecimiento(articuloDTO))) || this.habilitadoTipoPrecioLocal(articuloDTO, SICArticuloConstantes.TIPO_PRECIO_MAYORISTA);
		}catch(Exception e){
			LOG_SICV2.info("Ocurrio un  error al validar las condiciones de precio mayoreo en local: " + e.getMessage());
			throw new SICException("Ocurrio un error al validar los articulos.",e);
		}
	}
	
	/**
	 * @author mgranda
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	private Boolean aplicaPrecioMayoreoEstablecimiento(ArticuloDTO articuloDTO) throws SICException{
		try{
			Boolean aplPreMayEst = Boolean.FALSE;
			AreaTrabajoDTO areaTrabajoDTO = new AreaTrabajoDTO();
			if(articuloDTO.getId().getCodigoCompania() == null){
				throw new SICException("El art\u00EDculo no posee c\u00F3digo de compa\u00F1ia.");
			}
			if(articuloDTO.getNpCodigoLocal() == null){
				throw new SICException("El art\u00EDculo no posee c\u00F3digo de local.");
			}
			areaTrabajoDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			areaTrabajoDTO.getId().setCodigoAreaTrabajo(articuloDTO.getNpCodigoLocal());
			
			areaTrabajoDTO = this.calculoAlmacenamientoEstructuraLogisticaGestor.obtenerCodigoEstablecimiento(areaTrabajoDTO);
			if(areaTrabajoDTO != null){
				Collection<ParametroDTO> establecimientosMayorista = this.parametroGestor.obtenerParametros(articuloDTO.getId().getCodigoCompania(),LogUtilMessages.getInstancia().getString("log.sistema.MAX"), SICParametros.PARAMETRO_CODIGO_ESTABLECIMIENTO_PRECIO_MAYOREO);
				if(CollectionUtils.isNotEmpty(establecimientosMayorista)){
					String[] codicionEstablecimientosCaja = this.buscarParametro(SICParametros.PARAMETRO_CODIGO_ESTABLECIMIENTO_PRECIO_MAYOREO, establecimientosMayorista);
					aplPreMayEst = this.verificarCondicionEnParametro (String.valueOf(areaTrabajoDTO.getCodigoEstablecimiento()), codicionEstablecimientosCaja);
				}
			}
			return aplPreMayEst;
		}catch(Exception e){
			LOG_SICV2.info("Ocurrio un  error al validar las condiciones de precio caja en local: " + e.getMessage());
			throw new SICException("Ocurrio un error al validar los articulos.",e);
		}
	}	
	
	/**
	 * @author mgranda
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	@Override
	public Boolean aplicaPrecioCajaLocal(ArticuloDTO articuloDTO) throws SICException{
		try{
			Boolean aplicaPrecioCajaEnLocal = Boolean.FALSE;
			if(articuloDTO.getId().getCodigoCompania() == null){
				throw new SICException("El art\u00EDculo no posee c\u00F3digo de compa\u00F1ia.");
			}
			if(articuloDTO.getNpCodigoLocal() == null){
				throw new SICException("El art\u00EDculo no posee c\u00F3digo de local.");
			}
			Collection<ParametroDTO> localesCaja = this.parametroGestor.obtenerParametros(articuloDTO.getId().getCodigoCompania(),LogUtilMessages.getInstancia().getString("log.sistema.MAX"), SICParametros.PARAMETRO_CODIGO_LOCALES_PRECIO_CAJA);
			if(CollectionUtils.isNotEmpty(localesCaja)){
				String[] codicionLocalesCaja = this.buscarParametro(SICParametros.PARAMETRO_CODIGO_LOCALES_PRECIO_CAJA, localesCaja);
				aplicaPrecioCajaEnLocal = this.verificarCondicionEnParametro (String.valueOf(articuloDTO.getNpCodigoLocal()), codicionLocalesCaja);
			}
			return articuloDTO.getTienePrecioCaja() && (aplicaPrecioCajaEnLocal || this.aplicaPrecioCajaEstablecimiento(articuloDTO) || this.habilitadoTipoPrecioLocal(articuloDTO, SICArticuloConstantes.TIPO_PRECIO_CAJA));
		}catch(Exception e){
			LOG_SICV2.info("Ocurrio un  error al validar las condiciones de precio caja en local: " + e.getMessage());
			throw new SICException("Ocurrio un error al validar los articulos.",e);
		}
	}
	
	/**
	 * @author mgranda
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	private Boolean aplicaPrecioCajaEstablecimiento(ArticuloDTO articuloDTO) throws SICException{
		try{
			Boolean aplicaPrecioCajaEnLocal = Boolean.FALSE;
			AreaTrabajoDTO areaTrabajoDTO = new AreaTrabajoDTO();
			if(articuloDTO.getId().getCodigoCompania() == null){
				throw new SICException("El art\u00EDculo no posee c\u00F3digo de compa\u00F1ia.");
			}
			if(articuloDTO.getNpCodigoLocal() == null){
				throw new SICException("El art\u00EDculo no posee c\u00F3digo de local.");
			}
			areaTrabajoDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			areaTrabajoDTO.getId().setCodigoAreaTrabajo(articuloDTO.getNpCodigoLocal());
			
			areaTrabajoDTO = this.calculoAlmacenamientoEstructuraLogisticaGestor.obtenerCodigoEstablecimiento(areaTrabajoDTO);
			if(areaTrabajoDTO != null){
				Collection<ParametroDTO> establecimientosCaja = this.parametroGestor.obtenerParametros(articuloDTO.getId().getCodigoCompania(),LogUtilMessages.getInstancia().getString("log.sistema.MAX"), SICParametros.PARAMETRO_CODIGO_LOCALES_PRECIO_CAJA);
				if(CollectionUtils.isNotEmpty(establecimientosCaja)){
					String[] codicionEstablecimientosCaja = this.buscarParametro(SICParametros.PARAMETRO_CODIGO_ESTABLECIMIENTO_PRECIO_CAJA, establecimientosCaja);
					aplicaPrecioCajaEnLocal = this.verificarCondicionEnParametro (String.valueOf(areaTrabajoDTO.getCodigoEstablecimiento()), codicionEstablecimientosCaja);
				}
			}
			return aplicaPrecioCajaEnLocal;
		}catch(Exception e){
			LOG_SICV2.info("Ocurrio un  error al validar las condiciones de precio caja en local: " + e.getMessage());
			throw new SICException("Ocurrio un error al validar los articulos.",e);
		}
	}
	
	/**
	 * Metodo que permite validar el Mayoreo de acuerdo al departamento
	 * @param articuloVO
	 * @param parametrosCol
	 * @return
	 */
	private Boolean validarMayoreoDepartamento(ArticuloDTO articuloDTO , Collection<ParametroDTO> parametrosCol) {
		Boolean verifica = Boolean.FALSE;
		String departamento = articuloDTO.getClasificacionDTO().getCodigoClasificacionPadre();
		if (departamento != null) {
			String[] condicionesValidadasMayoreo = this.buscarParametro(SICParametros.PARAMETRO_MAYOREO_DEPARTAMENTOS , parametrosCol);
			verifica = this.verificarCondicionEnParametro (departamento , condicionesValidadasMayoreo);
		}
		return verifica;
	}
	
	/**
	 * verifica una condicion en un parametro
	 * @param condicion
	 * @param condicionesValidadas
	 * @return
	 */
	private Boolean verificarCondicionEnParametro(String condicion , String [] condicionesValidadas){
		Boolean validar = Boolean.FALSE;
		if (condicionesValidadas != null && condicionesValidadas.length > 0) {
			for (int i = 0; i < condicionesValidadas.length; i++) {
				if (StringUtils.equals(condicion, condicionesValidadas[i].toString())) {
					validar = Boolean.TRUE;
					break;
				}
			}
		}
		return validar;
	}
	
	/**
	 * Metodo que permite validar el Mayoreo de acuerdo al codigo de secuencia
	 * @param articuloVO
	 * @param parametrosCol
	 * @return
	 */
	private Boolean validarMayoreoCodigoSecuencia(ArticuloDTO articuloDTO , Collection<ParametroDTO> parametrosCol) {
		Boolean verifica = Boolean.FALSE;
		String codigoSecuencia = articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras();
		String valorTipoSecuencia = articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia();
		if(valorTipoSecuencia != null && valorTipoSecuencia.equals(SICArticuloConstantes.TIPSECART_PESOPRECIO) && 
				articuloDTO.getCodigoEstado().equals(SICArticuloConstantes.ESTADOARTICULO_PRECODIFICADO)){	
			verifica = Boolean.TRUE;
		}else if (codigoSecuencia != null && articuloDTO.getCodigoEstado().equals(SICArticuloConstantes.ESTADOARTICULO_CODIFICADO)) {
			String[] condicionesValidadasMayoreo = this.buscarParametro(SICParametros.PARAMETRO_MAYOREO_PESO_VARIABLE_RANGO , parametrosCol);
			if (condicionesValidadasMayoreo != null && condicionesValidadasMayoreo.length > 0) {
				if (Long.valueOf(codigoSecuencia) >= Long.valueOf(condicionesValidadasMayoreo[0]) && 
					Long.valueOf(codigoSecuencia) <= Long.valueOf(condicionesValidadasMayoreo[1])) {
					verifica = Boolean.TRUE;
				}
			}
		}
		return verifica;
	}
	
	/**
	 * Metodo que permite validar el Mayoreo de acuerdo a las divisiones
	 * @param articuloVO
	 * @param parametrosCol
	 * @return
	 */
	private Boolean validarMayoreoDivisiones(ArticuloDTO articuloDTO , Collection<ParametroDTO> parametrosCol) {
		Boolean verifica = Boolean.FALSE;
		String codigoClasificacionPadre = articuloDTO.getClasificacionDTO().getCodigoClasificacionPadre();
		if (codigoClasificacionPadre != null) {
			ClasificacionDTO clasificacionPadrePlantilla = new ClasificacionDTO();
			clasificacionPadrePlantilla.getId().setCodigoClasificacion(codigoClasificacionPadre);
			clasificacionPadrePlantilla.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			ClasificacionDTO clasificacionPadre = SICFactory.getInstancia().administracion.getDataService().findUnique(clasificacionPadrePlantilla);
			if (clasificacionPadre != null) {
				String[] condicionesValidadasMayoreo = this.buscarParametro(SICParametros.PARAMETRO_MAYOREO_DIVISIONES , parametrosCol);
				verifica = this.verificarCondicionEnParametro (clasificacionPadre.getCodigoClasificacionPadre() , condicionesValidadasMayoreo);
			}
		}
		return verifica;
	}
	
	/**
	 * Metodo que permite validar el Mayoreo de acuerdo a la clasificacion
	 * @param articuloVO
	 * @param parametrosCol
	 * @return
	 */
	private Boolean validarMayoreoClasificacion(ArticuloDTO articuloDTO , Collection<ParametroDTO> parametrosCol) {
		Boolean verifica = Boolean.FALSE;
		String clasificacion = articuloDTO.getClasificacionDTO().getId().getCodigoClasificacion();
		if (clasificacion != null) {			
			String[] condicionesValidadasMayoreo = this.buscarParametro(SICParametros.PARAMETRO_MAYOREO_CLASIFICACION1 , parametrosCol);			
			verifica = this.verificarCondicionEnParametro (clasificacion , condicionesValidadasMayoreo);
		}
		return verifica;
	}
	
	/**
	 * Metodo que permite validar el Mayoreo de acuerdo a la clasificacion y
	 * subclasificacion
	 * @param articuloVO
	 * @param parametrosCol
	 * @return
	 */
	private Boolean validarMayoreoClasificacionSubclasificacion(ArticuloDTO articuloDTO , Collection<ParametroDTO> parametrosCol) {
		Boolean verifica = Boolean.FALSE;
		String subClasificacion = articuloDTO.getCodigoSubClasificacion();
		String clasificacion = articuloDTO.getCodigoClasificacion();
		if (subClasificacion != null && clasificacion != null) {			
			String[] condicionesValidadasClasificacion = buscarParametro(SICParametros.PARAMETRO_MAYOREO_CLASIFICACION3 , parametrosCol);
			if (this.verificarCondicionEnParametro (clasificacion, condicionesValidadasClasificacion)) {
				String[] condicionesValidadasSubClasificacion = buscarParametro(SICParametros.PARAMETRO_MAYOREO_SUBCLASIFICACION , parametrosCol);	
				verifica = this.verificarCondicionEnParametro (subClasificacion , condicionesValidadasSubClasificacion);
			}
		}
		return verifica;
	}
	
	/**
	 * Metodo que permite validar el Mayoreo de acuerdo al proveedor y la
	 * clasificacion
	 * @param articuloVO
	 * @param parametrosCol
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Boolean validarMayoreoProveedor(ArticuloDTO articuloDTO , Collection<ParametroDTO> parametrosCol) {
		Boolean verifica = Boolean.FALSE;
//		if (articuloVO.getProveedor() != null) {
//			proveedor = articuloVO.getProveedor().getId().getCodigoProveedor();
//		} else {
//			proveedor = articuloVO.getArticuloProveedorDTO().getId().getCodigoProveedor();
//		}
		
		if(articuloDTO.getTieneArticuloProveedor()){
			String subClasificacion = articuloDTO.getCodigoSubClasificacion();
			
			String[] condicionesValidadasProveedor = this.buscarParametro(SICParametros.PARAMETRO_MAYOREO_PROVEEDOR , parametrosCol);
			
			if(condicionesValidadasProveedor != null && condicionesValidadasProveedor.length > 0){
				Collection<ArticuloProveedorDTO> articuloProveedorCol = (List<ArticuloProveedorDTO>)CollectionUtils.select(articuloDTO.getArticuloProveedorCol(), 
						new BeanPredicate("estadoArticuloProveedor", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
				for(ArticuloProveedorDTO articuloProveedorDTO : articuloProveedorCol){
					if(articuloProveedorDTO.getTieneVistaProveedor() && StringUtils.equals(articuloProveedorDTO.getEstadoArticuloProveedor(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
						if(this.verificarCondicionEnParametro(articuloProveedorDTO.getVistaProveedor().getCodigoJDEProveedor(), condicionesValidadasProveedor)){
							String[] condicionesValidadasMarca = buscarParametro(SICParametros.PARAMETRO_MAYOREO_MARCAPROPIA , parametrosCol);
							if (Integer.parseInt(subClasificacion) < Integer.parseInt(condicionesValidadasMarca[0])) {
								verifica = Boolean.TRUE;
								break;
							}
						}
					}
				}
			}
		}
		return verifica;
	}
	
	/**
	 * Metodo que permite validar el mayoreo de acuerdo a la clase del articulo
	 * y la clasificacion
	 * @param articuloVO
	 * @param parametrosCol
	 * @return
	 */
	private Boolean validarMayoreoClase(ArticuloDTO articuloDTO , Collection<ParametroDTO> parametrosCol) {
		Boolean verifica = Boolean.FALSE;
		String[] condicionesValidadasClase = this.buscarParametro(SICParametros.PARAMETRO_MAYOREO_CLASE , parametrosCol);			
		if(this.verificarCondicionEnParametro(articuloDTO.getClaseArticulo(), condicionesValidadasClase)){
			String[] condicionesValidadasClasificacion = this.buscarParametro(SICParametros.PARAMETRO_MAYOREO_CLASIFICACION2 , parametrosCol);
			String clasificacion = articuloDTO.getClasificacionDTO().getId().getCodigoClasificacion();
			verifica = this.verificarCondicionEnParametro(clasificacion, condicionesValidadasClasificacion);
			//se usa en la parte web, al realizar la accion de cambiar de clase
			if(verifica){ articuloDTO.addDynamicProperty("clasificacionValida", Boolean.TRUE); }
		}
		return verifica;
	}
	
	/**
	 * busca el valor de un parametro en una coleccion de parametrosDTO
	 * @param parametro
	 * @param parametrosCol
	 * @return
	 */
	private String[] buscarParametro(String parametro , Collection<ParametroDTO> parametrosCol) {
		String[] parametros = null;
		ParametroDTO parametroDTO = (ParametroDTO) CollectionUtils.find(parametrosCol, new BeanPredicate("id.codigoParametro", PredicateUtils.equalPredicate(parametro)));
		if (parametroDTO != null) {
			return parametroDTO.getValorParametro().split(",");
		}
		return parametros;
	}
	
	/**
	 * @param calculoArticuloGestor the calculoArticuloGestor to set
	 */
	public void setCalculoArticuloGestor(CalculoArticuloGestor calculoArticuloGestor) {
		this.calculoArticuloGestor = calculoArticuloGestor;
	}

	/**
	 * @param parametroGestor the parametroGestor to set
	 */
	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}

	public void setCalculoAlmacenamientoEstructuraLogisticaGestor(ICalculoAlmacenamientoEstructuraLogisticaGestor calculoAlmacenamientoEstructuraLogisticaGestor) {
		this.calculoAlmacenamientoEstructuraLogisticaGestor = calculoAlmacenamientoEstructuraLogisticaGestor;
	}
}
