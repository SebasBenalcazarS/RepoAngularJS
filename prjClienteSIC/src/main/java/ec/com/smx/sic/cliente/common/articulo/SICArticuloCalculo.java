/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.bodega.EnumEan;
import ec.com.smx.sic.cliente.common.bodega.ValidacionEanUtil;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.ValidadorEanException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RangoSecuenciaCodigoBarrasDTO;

/**
 * @author fmunoz
 *
 */
public final class SICArticuloCalculo implements Logeable{
	private static final SICArticuloCalculo INSTANCIA = new SICArticuloCalculo();
	public static final String CLAVE_VALORIMPUESTO = "VI";
	public static final String CLAVE_PORCENTAJEIMPUESTO = "PI";
	public static final Integer VALORMAXIMO_UNIDADVENTA_POS = 99;
	public static final Double VALORMAXIMO_PRECIOVENTAVENTA_POS = 999.99d;
	private static final String PREFIJO_PESOVARIABLE_POS = "26";
	private static final String PREFIJO_PESOFIJO_POS = "20";
	public static final String PREFIJO_CUPON_ESPECIAL="200";
	private static final Long RANGO_INICIAL_CODIGOINTERNOPOS = 2000000000000L;
	private static final Long RANGO_FINAL_CODIGOINTERNOPOS = 2999999999999L;
	
	
	private SICArticuloCalculo() {}
	/**
	 * @return the INSTANCIA
	 */
	public static SICArticuloCalculo getInstancia() {
		return INSTANCIA;
	}
	
	/**
	 * Calcula el costo (Bruto, Neto), en base al precio supermaxi y el margen supermaxi,
	 * no utilizar este metodo cuando se desea calcular el costo neto en base a la cadena de descuentos.
	 * F�rmula: Costo = Precio * (1 - Margen/100)
	 * 
	 * @param precioSupermaxi
	 * @param margenSupermaxi
	 * @return
	 */
	public Double calcularCostoArticulo(Double precioSupermaxi, Double margenSupermaxi) {		
		return (precioSupermaxi != null && margenSupermaxi != null) ? SICUtil.getInstance().roundNumber(precioSupermaxi * (1 - margenSupermaxi/Double.valueOf("100")), SICConstantes.CANTIDADDECIMALCUATRO) : null;
	}
	
	
	/**
	 * Calcula el margen sobre venta en base al precio (Supermaxi o PVP) y costo (Bruto o Neto)
	 * F�rmula: Margen = (1 - Costo / Precio) * 100
	 * 
	 * @param precio
	 * @param costo
	 * @return
	 */
	public Double calcularMargenPrecio(Double precio,Double costo) {		
		return (precio != null && costo != null) ? SICUtil.getInstance().roundNumber((1 - costo/precio) * Double.valueOf("100"), SICConstantes.CANTIDADDECIMALFINAL) : null;
	}
	
	/**
	 * Calcula el margen sobre compra en base al precio (Supermaxi o PVP) y costo (Bruto o Neto)
	 * F�rmula: Margen = (1 - Costo / Precio) * 100
	 * 
	 * @param precio
	 * @param costo
	 * @return
	 */
	public Double calcularMargenCosto(final Double precio, final Double costo) {		
		return (precio != null && costo != null) ? SICUtil.getInstance().roundNumber((1 - precio/costo) * Double.valueOf("100"), SICConstantes.CANTIDADDECIMALFINAL) : null;
	}
	
	/**
	 * Metodo para calcular el porcentaje aplicado a un precioBase basandonos en el precioFinal
	 * F\u00F3rmula : Porcentaje = ((PrecioPorcentaje-Precio)/Precio)*100
	 * @param precioBase
	 * @param precioConPorcentaje
	 * @return
	 */
	public Double obtenerPorcentajeValorBase(Double precioBase, Double precioConPorcentaje){
		return ((100 * precioConPorcentaje) / precioBase) - 100;
	}
	
	/**
	 * Metodo para calcular el precioBase en base al porcentaje
	 * @author guvidia
	 * @param precioBase
	 * @param porcentaje
	 * formula PB+(PB*POR)/100
	 * @return
	 */
	public BigDecimal obtenerValorBasePorPorcentaje(Double precioBase, Double porcentaje){
		BigDecimal precioBaseBig = new BigDecimal(precioBase);
		BigDecimal porcentajeBig = new BigDecimal(porcentaje.doubleValue());		
		return precioBaseBig.add((precioBaseBig.multiply(porcentajeBig)).divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP) ;
	}
	
	
	/**
	 * Este m�todo empieza redondeando el resultado con una cierta cantidad de deciamales que luego va decrementando
	 * @param precioInicial
	 * @param esParaVenta
	 * @param impuestos
	 * @param artmed
	 * @return
	 */
	public Double calcularValorConImpuestos(Double precioInicial, Boolean esParaVenta, ArticuloDTO articuloDTO){
		Map<String, Double> valoresImpuesto = obtenerValoresImpuesto(articuloDTO, esParaVenta);
		return calcularValorConImpuestos(precioInicial,valoresImpuesto,esParaVenta);
	}
	
	/**
	 * Este m�todo empieza redondeando el resultado con una cierta cantidad de decimales que luego va decrementando
	 * @param precioInicial
	 * @param valoresImpuesto
	 * @param esParaVenta
	 * @return
	 */
	public Double calcularValorConImpuestos(Double precioInicial, Map<String, Double> valoresImpuesto, Boolean esParaVenta){
		Double precioFinal = precioInicial;
		if(valoresImpuesto != null){
    		Integer cantidadDecimalFinal = esParaVenta ? SICConstantes.CANTIDADDECIMALFINAL : SICConstantes.CANTIDADDECIMALCUATRO;
//    		if(valoresImpuesto.get(CLAVE_VALORIMPUESTO) != null){
//    			precioFinal = precioFinal.doubleValue() + valoresImpuesto.get(CLAVE_VALORIMPUESTO).doubleValue();
//    		}
    		precioFinal = SICUtil.getInstance().roundNumber(precioFinal * (1 + valoresImpuesto.get(CLAVE_PORCENTAJEIMPUESTO)/100), SICConstantes.CANTIDADDECIMALINICIAL);
    		for(int i=SICConstantes.CANTIDADDECIMALINICIAL-1;i>=cantidadDecimalFinal;i--){
    			precioFinal = SICUtil.getInstance().roundNumber(precioFinal, i);
    		}
		}
		return precioFinal;
	}
	
	public Double calcularValorConImpuestoVerde(Double precioInicial, Map<String, Double> valoresImpuesto){
		Double precioFinal = precioInicial;
		if(valoresImpuesto != null){
    		if(valoresImpuesto.get(CLAVE_VALORIMPUESTO) != null){
    			precioFinal = precioFinal.doubleValue() + valoresImpuesto.get(CLAVE_VALORIMPUESTO).doubleValue();
    		}
		}
		return precioFinal;
	}
	
	/**
	 * Este m�todo empieza redondeando el resultado con una cierta cantidad de decimales que luego va decrementando
	 * @param precioInicial
	 * @param valoresImpuesto
	 * @param esParaVenta
	 * @return
	 */
	public BigDecimal calcularValorConImpuestos(BigDecimal precioInicial, Map<String, Double> valoresImpuesto, Boolean esParaVenta){
		BigDecimal precioFinal = precioInicial;
		if(valoresImpuesto != null){
    		Integer cantidadDecimalFinal = esParaVenta ? SICConstantes.CANTIDADDECIMALFINAL : SICConstantes.CANTIDADDECIMALCUATRO;
    		precioFinal = precioFinal.multiply(new BigDecimal(1 + valoresImpuesto.get(CLAVE_PORCENTAJEIMPUESTO)/100)).setScale(SICConstantes.CANTIDADDECIMALINICIAL,BigDecimal.ROUND_HALF_UP);
    		for(int i=SICConstantes.CANTIDADDECIMALINICIAL-1;i>=cantidadDecimalFinal;i--){
    			precioFinal = precioFinal.setScale(i, BigDecimal.ROUND_HALF_UP);
    		}
		}
		return precioFinal;
	}
	
	public Double calcularPrecioBaseNoAfiliado(Double precioBase, Double porcentajeNoAfiliado) {
		if(precioBase != null && porcentajeNoAfiliado != null) {
			return SICUtil.getInstance().roundNumber(precioBase * (1 + porcentajeNoAfiliado/100), SICConstantes.CANTIDADDECIMALFINAL);
		}
		return precioBase;
	}
	
	/**
	 * Retorna la unidad de manejo prorrateada para la venta
	 * @param aum
	 * @param precioBase
	 * @return
	 */
	public Integer calcularUnidadManejoVenta(ArticuloUnidadManejoDTO aum, Double precioBase){
		try{
			Double divisor = calcularDivisorPrecioCaja(aum, precioBase);
			if(divisor != null){
				return Integer.valueOf(Double.valueOf(Math.floor(aum.getValorUnidadManejo().intValue() / divisor.doubleValue())).intValue());
			}
			return aum.getValorUnidadManejo();
		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}
	
	
	/**
	 * Construye una estructura con los totales del impuesto de un art&iacute;culo
	 * @param articulo
	 * @param esParaVenta
	 * @return
	 */
	public Map<String, Double> obtenerValoresImpuesto(ArticuloDTO articulo, Boolean esParaVenta){
		if( CollectionUtils.isNotEmpty(articulo.getArticuloImpuestoCol()) ){
			Integer presentacion = articulo.getTieneArticuloMedida() && articulo.getArticuloMedidaDTO().getPresentacion() != null ? articulo.getArticuloMedidaDTO().getPresentacion() : null;
			return obtenerValoresImpuesto(articulo.getArticuloImpuestoCol(), presentacion, esParaVenta);
		}		
		return null;		
	}
	
	public Map<String, Double> obtenerValoresImpuesto(Collection<ArticuloImpuestoDTO> articuloImpuestos, Integer presentacion, Boolean esParaVenta){
		if( CollectionUtils.isNotEmpty(articuloImpuestos) ){
			double porcentaje = 0;
			double valor = 0;
			double valorImpuestoVerde = 0;
			Map<String, Double> resultado = new HashMap<String, Double>();
			for(ArticuloImpuestoDTO ai : articuloImpuestos){
				if(ai.getEstadoArticuloImpuesto().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) 
						&& (esParaVenta ? ai.getEsParaVenta() : ai.getEsParaCompra()) 
						&& !StringUtils.equals(ai.getTipoImpuestoArticulo().getCodigoGrupoImpuesto(),SICArticuloConstantes.GRUPOIMPUESTO_DISNEY)){
					porcentaje = porcentaje + ai.getTipoImpuestoArticulo().getPorcentajeImpuesto();
					if(ai.getTipoImpuestoArticulo().getValorImpuesto() != null){
						if(ai.getTipoImpuestoArticulo().getCodigoGrupoImpuesto().equals(SICArticuloConstantes.GRUPOIMPUESTO_VERDE)){
							valorImpuestoVerde = valorImpuestoVerde + ai.getTipoImpuestoArticulo().getValorImpuesto();
						}else{
							valor = valor + ai.getTipoImpuestoArticulo().getValorImpuesto();}
					}
				}
			}
			resultado.put(SICArticuloCalculo.CLAVE_PORCENTAJEIMPUESTO, porcentaje);
			if(presentacion != null && presentacion > 0){
				valorImpuestoVerde = presentacion * valorImpuestoVerde;
			}
			resultado.put(SICArticuloCalculo.CLAVE_VALORIMPUESTO, valor + valorImpuestoVerde);
			return resultado;
		}
		return null;
		
	}
	
	public Map<String, Double> obtenerValoresImpuestoProveedor(Collection<ArticuloProveedorImpuestoDTO> articuloProveedorImpuestoDTOs, Boolean esParaVenta){
		if( CollectionUtils.isNotEmpty(articuloProveedorImpuestoDTOs) ){
			double porcentaje = 0;
			Map<String, Double> resultado = new HashMap<String, Double>();
			for(ArticuloProveedorImpuestoDTO api : articuloProveedorImpuestoDTOs){
				if(api.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) 
						&& (esParaVenta ? api.getEsParaVenta() : api.getEsParaCompra()) 
						&& StringUtils.equals(api.getTipoImpuestoDTO().getCodigoGrupoImpuesto(),SICArticuloConstantes.GRUPOIMPUESTO_DISNEY)){
					porcentaje = porcentaje + api.getTipoImpuestoDTO().getPorcentajeImpuesto();
				}
			}
			resultado.put(SICArticuloCalculo.CLAVE_PORCENTAJEIMPUESTO, porcentaje);
			return resultado;
		}
		return null;
		
	}
	
	public static Double getFormatoDecimal(Double valor){
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#.##");
		df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));		
		return Double.parseDouble(df.format(valor));
	}

	
	/**
	 * Obtiene el nuevo c�digo de cada nivel de la estructura comercial para el MAX desde un c�digo SIC
	 * @param codigoSIC
	 * @return
	 */
	public String obtenerCodigoEstructuraComercialMAX(String codigoSIC){
		String codigoMAX = StringUtils.stripStart(codigoSIC,"0");
		if(codigoMAX.length() == SICArticuloConstantes.LONGITUD_CODIGODIVISION_SIC){
			codigoMAX = construirCodigoDivisionMAX(codigoMAX);
		}else if(codigoMAX.length() == SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_SIC){
			codigoMAX = construirCodigoDepartamentoMAX(codigoMAX);
		}else if(codigoMAX.length() == SICArticuloConstantes.LONGITUD_CODIGOCLASIFICACION_SIC){
			codigoMAX = construirCodigoClasificacionMAX(codigoMAX);
		}else{
			codigoMAX = codigoSIC;
		}
		return codigoMAX;
	}
	
	private String construirCodigoDivisionMAX(String codigoDivisionSIC){
		return StringUtils.leftPad(codigoDivisionSIC, SICArticuloConstantes.LONGITUD_CODIGODIVISION_MAX, '0');
	}
	
	private String construirCodigoDepartamentoMAX(String codigoDepartamentoSIC){
		return construirCodigoDivisionMAX(codigoDepartamentoSIC.substring(0,SICArticuloConstantes.LONGITUD_CODIGODIVISION_SIC))
				.concat(StringUtils.leftPad(codigoDepartamentoSIC, SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_MAX - SICArticuloConstantes.LONGITUD_CODIGODIVISION_MAX, '0'));
	}
	
	private String construirCodigoClasificacionMAX(String codigoClasificacionSIC){
		String departamento = codigoClasificacionSIC.substring(0,SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_SIC);
		String clasificacion = codigoClasificacionSIC.substring(SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_SIC,codigoClasificacionSIC.length());
		
		return construirCodigoDepartamentoMAX(departamento)
					.concat(StringUtils.leftPad(clasificacion, SICArticuloConstantes.LONGITUD_CODIGOCLASIFICACION_MAX - SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_MAX, '0'));
	}
	
	/**
	 * Obtiene el c�digo SIC de cada nivel de la estructura comercial desde un c�digo MAX
	 * @param codigoMAX
	 * @return
	 */
	public String obtenerCodigoEstructuraComercialSIC(String codigoMAX){
		String codigoSIC = codigoMAX;
		if(codigoMAX.length() == SICArticuloConstantes.LONGITUD_CODIGODIVISION_MAX){
			codigoSIC = StringUtils.stripStart(codigoMAX, "0");
		}else if(codigoMAX.length() == SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_MAX){
			codigoSIC = extraerCodigoDepartamentoSIC(codigoMAX);
		}else if(codigoMAX.length() == SICArticuloConstantes.LONGITUD_CODIGOCLASIFICACION_MAX){
			codigoSIC = extraerCodigoClasificacionSIC(codigoMAX);
		}
		return codigoSIC;
	}

	private String extraerCodigoDepartamentoSIC(String codigoDepartamentoMAX){
		return codigoDepartamentoMAX.substring(SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_MAX - SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_SIC, SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_MAX);
	}
	
	private String extraerCodigoClasificacionSIC(String codigoClasificacionMAX){
		return extraerCodigoDepartamentoSIC(codigoClasificacionMAX)
				.concat(codigoClasificacionMAX.substring(SICArticuloConstantes.LONGITUD_CODIGOCLASIFICACION_MAX - SICArticuloConstantes.LONGITUD_CODIGODEPARTAMENTO_SIC, 
				SICArticuloConstantes.LONGITUD_CODIGOCLASIFICACION_MAX));
	}
	
	
	/**
	 * 
	 * @param articuloComercialDTO
	 * @return
	 */
	public String getTipoCalculoPrecio(ArticuloComercialDTO articuloComercialDTO){
		if(articuloComercialDTO != null){
			if(StringUtils.equals(articuloComercialDTO.getValorTipoControlCosto(),SICArticuloConstantes.TIPCONCOS_PIEPES)
					|| StringUtils.equals(articuloComercialDTO.getValorTipoControlCosto(),SICArticuloConstantes.TIPCONCOS_PESPES)
					|| StringUtils.equals(articuloComercialDTO.getValorTipoControlCosto(),SICArticuloConstantes.TIPCONCOS_PIEPESUM)){
				if(articuloComercialDTO.getPesoAproximadoVenta() != null && articuloComercialDTO.getPesoAproximadoVenta() > 0){
					return SICArticuloConstantes.PRECIOCANTIDADPESO;}
				return SICArticuloConstantes.PRECIOPESOTOTAL;
			}
			return SICArticuloConstantes.PRECIOCANTIDAD;
		}
		return null;
	}
	
	/**
	 * Retorna el precio de caja usando el precio unitario base y la unidad de manejo 
	 */
	public Double calcularPrecioCaja(ArticuloUnidadManejoDTO aum, Double precioBase, Double precioBaseImp){
		try{
			Double precioCaja = precioBase.doubleValue() * aum.getValorUnidadManejo().intValue();
			Double divisor = calcularDivisorPrecioCaja(aum, precioBaseImp);
			if(divisor != null){
				//se calcula un precio de caja fraccionado
				double descuento = 0d;
				double unidadManejoFraccion = Math.floor(aum.getValorUnidadManejo().intValue() / divisor.doubleValue());
				if(unidadManejoFraccion == 0d){
					unidadManejoFraccion = 1d;
				}
				if(aum.getDescuentoVenta() != null){
					descuento = precioCaja.doubleValue() * aum.getDescuentoVenta().doubleValue()/100;
					descuento = descuento/divisor.doubleValue();
				}
				precioCaja = precioBase.doubleValue() * unidadManejoFraccion;
				precioCaja = precioCaja.doubleValue() - descuento;
				LOG_SICV2.info("descuento: "+descuento);
				LOG_SICV2.info("unidad manejo: "+unidadManejoFraccion);
				return SICUtil.getInstance().roundNumber(precioCaja, SICConstantes.CANTIDADDECIMALFINAL);
			}
			if(aum.getDescuentoVenta() != null){
				precioCaja = precioCaja * (1 - aum.getDescuentoVenta()/100);}
			return SICUtil.getInstance().roundNumber(precioCaja, SICConstantes.CANTIDADDECIMALFINAL);
		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}
	
	/**
	 * Retorna el precio de caja usando el precio unitario base y la unidad de manejo 
	 */
	public Double calcularPrecioMayorista(ArticuloUnidadManejoDTO aum, Double precioBase){
		try{
			Double precioMayorista = precioBase;
			if(aum.getDescuentoVenta() != null){
				precioMayorista = precioMayorista * (1 - aum.getDescuentoVenta()/100);}
			return SICUtil.getInstance().roundNumber(precioMayorista, SICConstantes.CANTIDADDECIMALFINAL);
		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}
	
	/**
	 * Retorna el valor divisor para calcular el precio de caja fraccionado para la venta
	 * @param aum
	 * @param precioBase
	 * @return
	 */
	private Double calcularDivisorPrecioCaja(ArticuloUnidadManejoDTO aum, Double precioBase){
		try{
			double fraccion = 0d;
			Double precioCaja = precioBase.doubleValue() * aum.getValorUnidadManejo().intValue();
			if(aum.getValorUnidadManejo() > SICArticuloCalculo.getInstancia().VALORMAXIMO_UNIDADVENTA_POS){
				fraccion = (double)(aum.getValorUnidadManejo().intValue() + SICArticuloCalculo.getInstancia().VALORMAXIMO_UNIDADVENTA_POS.intValue()) / SICArticuloCalculo.getInstancia().VALORMAXIMO_UNIDADVENTA_POS.intValue();
			}else if(precioCaja > SICArticuloCalculo.getInstancia().VALORMAXIMO_PRECIOVENTAVENTA_POS){
				fraccion = (precioCaja.doubleValue() + SICArticuloCalculo.getInstancia().VALORMAXIMO_PRECIOVENTAVENTA_POS.doubleValue()) / SICArticuloCalculo.getInstancia().VALORMAXIMO_PRECIOVENTAVENTA_POS.doubleValue();
			}else{
				return null;
			}
			return Double.valueOf(fraccion);

		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}
	
	
	/**
	 * propuesta
	 * @param codigoBarras
	 * @return
	 */
	public String obtenerCodigoBarrasParaBusqueda(String codigoBarras){
		//Codigo de barras resultante 
		String codigoBarrasCodificado = StringUtils.stripStart(codigoBarras,"0");;
		//Si el codigo de barras ingresado no es nulo o blanco
		if(StringUtils.isNotBlank(codigoBarras)){
			if(EnumEANConversionCodigoInterno.LONGITUD_CODIGO_EAN_SCANNER.getParametro() == codigoBarras.length()){
				try{
					if(ValidacionEanUtil.getInstancia().validarEan(codigoBarras, EnumEan.EAN13.getTipo())){
						Integer identificador = Integer.valueOf(codigoBarras.substring(1,3));
						if(EnumEANConversionCodigoInterno.IDENTIFICADOR_RANGO_PESO_FIJO.getParametro() == identificador){//Si el identificador es peso fijo
							codigoBarrasCodificado = codigoBarras.substring(3, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_FIJO.getParametro()+3);
						}else if(EnumEANConversionCodigoInterno.IDENTIFICADOR_RANGO_PESO_VARIABLE.getParametro() == identificador){//Si el identificador es peso variable
							codigoBarrasCodificado = codigoBarras.substring(2, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_VARIABLE.getParametro()+2);
						}else{//Si el identificador es codigo de barras de proveedor
							codigoBarrasCodificado = codigoBarras;
						}
						return codigoBarrasCodificado;
					}
				}catch(Exception e){
					return codigoBarras;
				}
			}else if(EnumEANConversionCodigoInterno.LONGITUD_CODIGO_EAN.getParametro() == codigoBarrasCodificado.length()){
				//TODO validar EAN
				try {
					if(ValidacionEanUtil.getInstancia().validarEan(EnumEan.EAN13.getIdentificadorCodigo()+codigoBarrasCodificado, EnumEan.EAN13.getTipo())){
						if(Long.valueOf(codigoBarrasCodificado) >= RANGO_INICIAL_CODIGOINTERNOPOS && Long.valueOf(codigoBarrasCodificado) <= RANGO_FINAL_CODIGOINTERNOPOS){
							Integer identificador = Integer.valueOf(codigoBarrasCodificado.substring(0,2));
							if(EnumEANConversionCodigoInterno.IDENTIFICADOR_RANGO_PESO_FIJO.getParametro() == identificador){//Si el identificador es peso fijo 20
								if(codigoBarrasCodificado.charAt(2) == '5'){
									codigoBarrasCodificado = codigoBarrasCodificado.substring(2, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_FIJO.getParametro()+6);
			        			}else{
			        				codigoBarrasCodificado = codigoBarrasCodificado.substring(2, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_FIJO.getParametro()+2);
			        			}
							}else if(EnumEANConversionCodigoInterno.IDENTIFICADOR_RANGO_PESO_VARIABLE.getParametro() == identificador){//Si el identificador es peso variable 26
								codigoBarrasCodificado = codigoBarrasCodificado.substring(1, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_VARIABLE.getParametro()+1);
							}
							return StringUtils.stripStart(codigoBarrasCodificado,"0");
						}
					}
				} catch (ValidadorEanException e) {
					return codigoBarrasCodificado;
				}
			}
		}
		return codigoBarras;
	}
	
	/**
	 * Metodo para obtener el precio por unidad minima
	 * @author mgranda
	 * @param precio
	 * @param cantidadMedida
	 * @param valorUnidadMinima
	 * @return
	 * @throws SICException
	 */
	public BigDecimal obtenerPrecioUnidadMinima(Double precio, Double cantidadMedida, String valorUnidadMinima) throws SICException{
		BigDecimal precioFinal = null;
		try{
			
			if(precio != null && cantidadMedida != null && cantidadMedida > 0 && valorUnidadMinima != null){
				precioFinal = BigDecimal.valueOf(precio).divide(BigDecimal.valueOf(cantidadMedida),6 , RoundingMode.HALF_UP).multiply(new BigDecimal(valorUnidadMinima)).setScale(3, BigDecimal.ROUND_HALF_UP);
			}
			
		}catch(Exception exception){
			LOG_SICV2.error("Ha ocurrido un error: {0}", exception.getMessage());
			throw new SICException("Ha ocurrido un error al calcular el precio por unidad m\u00EDnima.");
		}
		return precioFinal;
	}
	

	/**
	 * Metodo para obtener el codigo del barras del articulo MAX dado el codigo del cupon desde loyalty
	 * @param codigoCuponLoyalty: Codigo del cupon loyalty
	 * @param rangosSecuenciasCuponesDTO: Rango de secuencias para los articulos MAX tipo cupones
	 * @return Codigo de barras del articulo MAX
	 */
	@SuppressWarnings("unchecked")
	public String obtenerCodigoBarrasArticuloMAX(final String codigoCuponLoyalty, 
			final Collection<RangoSecuenciaCodigoBarrasDTO> rangosSecuenciasCuponesDTO){
		String respuesta = null;
		Long valorMaximoSecuencia = null;
		Integer tamanioSecuencia = null;
		Collection<RangoSecuenciaCodigoBarrasDTO> rangosSecuenciasCuponesOrdenados = null;
		StringBuilder codigoBarras = new StringBuilder();
		
		try{
			if(CollectionUtils.isNotEmpty(rangosSecuenciasCuponesDTO)){
				//obtener el valor maximo del rango de la secuencia para cupones
				rangosSecuenciasCuponesOrdenados = ColeccionesUtil.sort(rangosSecuenciasCuponesDTO, ColeccionesUtil.ORDEN_DESC, "valorMaximo");
				valorMaximoSecuencia = rangosSecuenciasCuponesOrdenados.iterator().next().getValorMaximo();
				//obtener tamanio secuencia
				tamanioSecuencia = StringUtils.length(String.valueOf(valorMaximoSecuencia));
				//obtener codigo de barras
				codigoBarras.append(codigoCuponLoyalty.trim().substring(codigoCuponLoyalty.trim().length()-tamanioSecuencia, codigoCuponLoyalty.trim().length()));
				//transformar a numero y retornar el codigo de barras
				respuesta = String.valueOf(new Long(codigoBarras.toString().trim()));
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al obtener codigo de barras para el codigo de cupon: {}", codigoCuponLoyalty, e);
			throw new SICException(e);
		}
		return respuesta;
	}
	
	/**
	 * Calcula el precio con descuento de un articulo
	 * F�rmula: Precio = precioBase - {(precioBase * ((totalAcumuladoDescuento * 100) / (totalAcumuladoVentas - totalAcumuladoDevolucion)) )/ 100} 
	 * 
	 * @param totalAcumuladoVentas
	 * @param totalAcumuladoDevolucion
	 * @param totalAcumuladoDescuento
	 * @param precioBase
	 * @return
	 */
	public BigDecimal calcularPrecioConDescuento(BigDecimal totalAcumuladoVentas, BigDecimal totalAcumuladoDevolucion, BigDecimal totalAcumuladoDescuento, Double precioBase) throws SICException {
		BigDecimal totalAcumuladoVentasReal = (totalAcumuladoVentas.subtract(totalAcumuladoDevolucion)).setScale(SICConstantes.CANTIDADDECIMALOCHO, BigDecimal.ROUND_HALF_UP);
		BigDecimal precioBaseDecimal = new BigDecimal(precioBase);
		
		if (!(new BigDecimal("0").setScale(SICConstantes.CANTIDADDECIMALOCHO, BigDecimal.ROUND_HALF_UP)).equals(totalAcumuladoVentasReal)) {

			BigDecimal porcentajeDescuento = (totalAcumuladoDescuento.multiply(new BigDecimal("100"))).divide(totalAcumuladoVentasReal,SICConstantes.CANTIDADDECIMALOCHO,RoundingMode.CEILING);
			
			BigDecimal precioDescuento = precioBaseDecimal.subtract((precioBaseDecimal.multiply(porcentajeDescuento)).divide(new BigDecimal("100"),SICConstantes.CANTIDADDECIMALOCHO,RoundingMode.CEILING));
			return precioDescuento;
		}
		return BigDecimal.ZERO;
	}
	
	/**
	 * Calcula el precio con recuperacion de un articulo
	 * F�rmula: Precio = precioBase - {(precioBase * (((totalAcumuladoDescuento - totalAcumuladoRecuperacion) * 100) / (totalAcumuladoVentas - totalAcumuladoDevolucion)) )/ 100} 
	 * 
	 * @param totalAcumuladoVentas
	 * @param totalAcumuladoDevolucion
	 * @param totalAcumuladoDescuento
	 * @param totalAcumuladoRecuperacion
	 * @param precioBase
	 * @return
	 */
	public BigDecimal calcularPrecioConRecuperacionDescuento(BigDecimal totalAcumuladoVentas, BigDecimal totalAcumuladoDevolucion, BigDecimal totalAcumuladoDescuento, BigDecimal totalAcumuladoRecuperacion, Double precioBase) throws SICException {
		BigDecimal totalAcumuladoVentasReal = (totalAcumuladoVentas.subtract(totalAcumuladoDevolucion)).setScale(SICConstantes.CANTIDADDECIMALOCHO, BigDecimal.ROUND_HALF_UP);
		BigDecimal precioBaseDecimal = new BigDecimal(precioBase);
		
		if (!(new BigDecimal("0").setScale(SICConstantes.CANTIDADDECIMALOCHO, BigDecimal.ROUND_HALF_UP)).equals(totalAcumuladoVentasReal)) {
			
			BigDecimal porcentajeRecuperacion = ((totalAcumuladoDescuento.subtract(totalAcumuladoRecuperacion)).multiply(new BigDecimal("100"))).divide(totalAcumuladoVentasReal, SICConstantes.CANTIDADDECIMALOCHO,RoundingMode.CEILING);

			BigDecimal precioDescuentoRecuperacion = precioBaseDecimal.subtract((precioBaseDecimal.multiply(porcentajeRecuperacion)).divide(new BigDecimal("100"),SICConstantes.CANTIDADDECIMALOCHO,RoundingMode.CEILING));
			return precioDescuentoRecuperacion;
		}
		return BigDecimal.ZERO;
	}
	
	/**
	 * Calcula la diferencia del Costo Bruto
	 * Diferencia de Costo = Costo Bruto Nuevo - Costo Bruto Anterior
	 * 
	 * @param costoBrutoNuevo
	 * @param costoBrutoAnterior
	 * @return
	 */
	public Double calcularVariacionCostoBruto(Double costoBrutoNuevo, Double costoBrutoAnterior) {
		if (costoBrutoNuevo != null && costoBrutoAnterior != null) {
			return SICUtil.getInstance().roundNumber(costoBrutoNuevo - costoBrutoAnterior, SICConstantes.CANTIDADDECIMALCUATRO);
		}
		return null;
	}

	/**
	 * Calcula la Variacion del Costo Bruto expresado en Porcentaje
	 * @param variacionCostoBruto
	 * @param costoBrutoAnterior
	 * @return
	 */
	public Double calcularPorcentajeVariacionCostoBruto(Double variacionCostoBruto, Double costoBrutoAnterior) {
		if (variacionCostoBruto != null && costoBrutoAnterior != null && costoBrutoAnterior != 0) {
			return SICUtil.getInstance().roundNumber(variacionCostoBruto * 100 / costoBrutoAnterior, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return null;
	}

	/**
	 * Calcula la Diferencia en el Precio de Venta
	 * Diferencia Venta = Precio de Venta Nuevo - Precio de Venta Anterior
	 * 
	 * @param precioPVPNuevo
	 * @param precioPVPAnterior
	 * @return
	 */
	public Double calcularVariacionVenta(Double precioPVPNuevo, Double precioPVPAnterior) {
		if (precioPVPNuevo != null && precioPVPAnterior != null) {
			return SICUtil.getInstance().roundNumber(precioPVPNuevo - precioPVPAnterior, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return null;
	}
	
	/**
	 * Calcula la Variacion del Precio de Venta expresado en Porcentaje
	 * @param variacionVenta
	 * @param precioSMXAnterior
	 * @return
	 */
	public Double calcularPorcentajeVariacionVenta(Double variacionVenta, Double precioSMXAnterior) {
		if (variacionVenta != null && precioSMXAnterior != null && precioSMXAnterior != 0) {
			return SICUtil.getInstance().roundNumber(variacionVenta * 100 / precioSMXAnterior, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return null;
	}
	
	/**
	 * Calculo del Costo Neto con Nota Credito
	 * Formula = Costo Neto Nota Crédito  Precio de Venta 
	 * @param costoNetoNc
	 * @param precioPVP
	 * @return
	 */
	public Double calcularCostoNetoNotaCreditoVsPvp(Double costoNetoNc, Double precioPVP) {
		if (costoNetoNc != null && precioPVP != null && precioPVP != 0) {
			return SICUtil.getInstance().roundNumber(costoNetoNc / precioPVP, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return null;
	}
	
	/**
	 * Calcula la relación entre el Precio de Venta y el Precio de Venta SMX
	 * Formula = Precio de Venta / Precio de Venta SMX
	 * @param precioPVP
	 * @param precioSMX
	 * @return
	 */
	public Double calcularPvpVsPsmx(Double precioPVP, Double precioSMX) {
		if (precioPVP != null && precioSMX != null && precioSMX != 0) {
			return SICUtil.getInstance().roundNumber(precioPVP / precioSMX, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return null;
	}
	
	/**
	 * Calcula de Relación de Incremento entre Precio de Venta y Costo Neto de Nota Credito
	 * @param precioPVPAnterior
	 * @param costoNetoNcAnterior
	 * @return
	 */
	public Double calcularVentaCostoNetoNotaCredito(Double precioPVP, Double costoNetoNc) {
		if (precioPVP!= null && costoNetoNc != null && precioPVP != 0) {
			return SICUtil.getInstance().roundNumber((precioPVP - costoNetoNc) / precioPVP, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return null;
	}

	/**
	 * Calcula la relación entre el precio de Venta y el Costo Neto Nota de Crédito
	 * @param precioPVP
	 * @param costoNetoNc
	 * @return
	 */
	public Double calcularPvpVsCostoNetoNotaCredito(Double precioPVP, Double costoNetoNc) {
		if (precioPVP != null && costoNetoNc != null && costoNetoNc != 0) {
			return SICUtil.getInstance().roundNumber(precioPVP / costoNetoNc, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return null;
	}
}
