/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.edicion;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

import ec.com.smx.framework.common.validator.Validator;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloCamposCreacionPorArchivoGestor;
import ec.com.smx.sic.cliente.mdl.vo.articulos.informacion.ArticuloInfoVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloCreacionPorArchivoDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.clase.IArticuloClaseDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.ClasificacionesPorClasificacionFuncionarioCompradorRestriction;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author eharo
 *
 */
public class ValidacionArticuloCamposEdicionArchivoGestor implements IValidacionArticuloCamposEdicionArchivoGestor, Logeable{

	private IArticuloEdicionArchivoDAO articuloEdicionArchivoDAO;
	//Varialble de acceso a la validacion de los campos del archivo
	private IValidacionArticuloCamposCreacionPorArchivoGestor validacionArticuloCampos;
	//Variable de acceso al DAO de la creacion por archivo
	private IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO;
	
	private IArticuloClaseDAO articuloClaseDAO;
	

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor#validacionesCodigoBarras(org.apache.poi.ss.usermodel.Cell, java.util.List, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.util.Set, boolean[])
	 */
	@Override
	public String validacionesCodigoBarras(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, String codigoFuncionario, Set<String> listaCodigosBarras, boolean[] esFilaValida, Map<String, String> codigosCabeceras, String claseArticulo) throws SICException {
		String codigoBarras = StringUtils.EMPTY;
		String codigoBarrasTmp = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		Boolean existeCodigoBarras = Boolean.FALSE;
		ArticuloInfoVO articulo = null;
		ClasificacionesPorClasificacionFuncionarioCompradorRestriction cpcf = null;
		try{
			codigoBarrasTmp = obtenerValorCeldaString(celdaExcel);
			
			if(StringUtils.isNotEmpty(StringUtils.trim(codigoBarrasTmp)) && StringUtils.contains(codigoBarrasTmp, "E")){
				codigoBarras = new BigDecimal(codigoBarrasTmp).toPlainString();//Big Decimal en formato decimal
			}else{
				codigoBarras = String.valueOf(Double.valueOf(codigoBarrasTmp).intValue());
			}
			
			codigoBarras = SICArticuloCalculo.getInstancia().obtenerCodigoBarrasParaBusqueda(codigoBarras);
			
			if(StringUtils.isEmpty(StringUtils.trim(codigoBarras))){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						getString("ec.com.smx.sic.articulo.validacion.archivo.celda.vacia"), String.valueOf(numeroFila), numeroColumna, codigosCabeceras.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS), validacionArticuloCampos.indiceAlfabeticoColumna(numeroColumna).concat(String.valueOf(numeroFila)));
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				if(CollectionUtils.exists(listaCodigosBarras, PredicateUtils.equalPredicate(codigoBarras))){
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}else{
					cpcf = new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(codigoFuncionario, null, null, null, null, "articulo.codigoClasificacion");
					existeCodigoBarras = this.articuloEdicionArchivoDAO.validarExisteCodigoBarras(codigoCompania, codigoBarras, cpcf.getCriteriaRestriction());
					if(existeCodigoBarras){
						articulo = this.articuloEdicionArchivoDAO.obtenerArticuloEdicionArchivo(codigoCompania, codigoBarras);
						if(StringUtils.isNotEmpty(articulo.getCodigoTipoArticulo()) && StringUtils.equals(articulo.getCodigoTipoArticulo(), SICArticuloConstantes.CODIGO_TIPOARTICULO_CUPON)){
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
									getString("ec.com.smx.sic.articulo.edicion.excel.validacion.valor.celda.articulo.tipo.cupon"), String.valueOf(numeroFila), numeroColumna, codigoBarras);
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						}else{
							if(StringUtils.equals(articulo.getClaseArticulo(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O) && !StringUtils.equals(claseArticulo, SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O)){
								Boolean existeCausal = this.articuloClaseDAO.existeArticuloClase(codigoCompania, articulo.getCodigoArticulo());
								if(BooleanUtils.isFalse(existeCausal)){
									observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
											getString("ec.com.smx.sic.articulo.edicion.excel.validacion.valor.celda.articulo.sincausal"), String.valueOf(numeroFila), numeroColumna, codigoBarras, SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O);
									LOG_SICV2.error(observacion.substring(4));
									observaciones.add(observacion);
									agregarEsFilaValida(esFilaValida, Boolean.FALSE);
								}else{
									listaCodigosBarras.add(codigoBarras);
									agregarEsFilaValida(esFilaValida, Boolean.TRUE);
								}
							} else if(StringUtils.equals(articulo.getClaseArticulo(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_E) && !StringUtils.equals(claseArticulo, SICArticuloConstantes.CODIGO_CLASE_ARTICULO_E)){
								Boolean existeCausal = this.articuloClaseDAO.existeArticuloClase(codigoCompania, articulo.getCodigoArticulo());
								if(BooleanUtils.isFalse(existeCausal)){
									observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
											getString("ec.com.smx.sic.articulo.edicion.excel.validacion.valor.celda.articulo.sincausal"), String.valueOf(numeroFila), numeroColumna, codigoBarras, SICArticuloConstantes.CODIGO_CLASE_ARTICULO_E);
									LOG_SICV2.error(observacion.substring(4));
									observaciones.add(observacion);
									agregarEsFilaValida(esFilaValida, Boolean.FALSE);
								}else{
									listaCodigosBarras.add(codigoBarras);
									agregarEsFilaValida(esFilaValida, Boolean.TRUE);
								}
							}else if(StringUtils.equals(articulo.getClaseArticulo(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_I) && !StringUtils.equals(claseArticulo, SICArticuloConstantes.CODIGO_CLASE_ARTICULO_I)){
								Boolean existeCausal = this.articuloClaseDAO.existeArticuloClase(codigoCompania, articulo.getCodigoArticulo());
								if(BooleanUtils.isFalse(existeCausal)){
									observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
											getString("ec.com.smx.sic.articulo.edicion.excel.validacion.valor.celda.articulo.sincausal"), String.valueOf(numeroFila), numeroColumna, codigoBarras, SICArticuloConstantes.CODIGO_CLASE_ARTICULO_I);
									LOG_SICV2.error(observacion.substring(4));
									observaciones.add(observacion);
									agregarEsFilaValida(esFilaValida, Boolean.FALSE);
								}else{
									listaCodigosBarras.add(codigoBarras);
									agregarEsFilaValida(esFilaValida, Boolean.TRUE);
								}
							}else{
								listaCodigosBarras.add(codigoBarras);
								agregarEsFilaValida(esFilaValida, Boolean.TRUE);
							}
						}
					}else{
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
								getString("ec.com.smx.sic.articulo.edicion.excel.validacion.valor.celda.no.existe.generico"), String.valueOf(numeroFila), numeroColumna, codigosCabeceras.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS));
						observaciones.add(observacion);
						LOG_SICV2.error(observacion);
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar realizar la validacion del codigo de barras. {}", e.getMessage());
		}
		return codigoBarras;
	}

	
	/**
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	@SuppressWarnings("unused")
	private Boolean validarCodigoEAN(String codigoBarras) throws SICException {
		boolean eanValido = Boolean.FALSE;
		Validator validator = null;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(codigoBarras))){
				validator = new ValidatorImpl();
				eanValido = validator.validateEAN(codigoBarras);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar el EAN. {}", e.getMessage());
//			throw new SICException("Error al validar el EAN. {}", e.getMessage());
		}finally{
			validator = null;
		}
		return eanValido;
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor#validacionesClase(org.apache.poi.ss.usermodel.Cell, java.util.List, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.util.Set, boolean[], java.util.Map)
	 */
	@Override
	public String validacionesClase(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, Set<String> listaClases, boolean[] esFilaValida, Map<String, String> codigosCabeceras) throws SICException {
		String claseArticulo = StringUtils.EMPTY;
		try{
			claseArticulo = validacionArticuloCampos.validacionesClase(celdaExcel, observaciones, numeroFila, numeroColumna, listaClases, codigoCompania, esFilaValida, codigosCabeceras.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), Boolean.FALSE);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la clase articulo {}", e.getMessage());
		}
		return claseArticulo;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor#validacionesFechaInicioFinTemporada(org.apache.poi.ss.usermodel.Cell, java.util.List, java.lang.Integer, java.lang.Integer, boolean, boolean[], java.util.Map)
	 */
	@Override
	public String validacionesFechaInicioFinTemporada(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFechaInicio, boolean[] esFilaValida, Map<String, String> codigosCabeceras) throws SICException {
		return this.validacionArticuloCampos.validacionesFechaInicioFinTemporada(celdaExcel, observaciones, numeroFila, numeroColumna, esFechaInicio, esFilaValida, codigosCabeceras);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor#obtenerValorCeldaString(org.apache.poi.ss.usermodel.Cell)
	 */
	@Override
	public String obtenerValorCeldaString(Cell celda) throws SICException {
		return this.validacionArticuloCampos.obtenerValorCeldaString(celda);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor#parsearValor(java.lang.String)
	 */
	@Override
	public String parsearValor(String cellValue) throws SICException {
		// TODO Auto-generated method stub
		return this.validacionArticuloCampos.parsearValor(cellValue);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor#agregarEsFilaValida(boolean[], boolean)
	 */
	@Override
	public void agregarEsFilaValida(boolean[] esFilaValida, boolean esValido) throws SICException {
		this.validacionArticuloCampos.agregarEsFilaValida(esFilaValida, esValido);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor#validacionesClaseObsoletoNoResurtible(org.apache.poi.ss.usermodel.Cell, java.util.List, java.lang.Integer, java.lang.Integer, boolean[], java.util.Map)
	 */
	@Override
	public String validacionesCausal(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompaia, String clase, boolean[] esFilaValida, List<MultiKeyMap> listaCausales, Map<String, String> codigosCabeceras) throws SICException {
		String causal = StringUtils.EMPTY;
		String codigoCausal = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		MultiKeyMap mapCausales = null;
		try{
			causal = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaCausales)){
				mapCausales = new MultiKeyMap();
				mapCausales.putAll(listaCausales.get(0) == null ? new MultiKeyMap() : listaCausales.get(0));
			}else{
				mapCausales = new MultiKeyMap();
			}
			
			if(mapCausales.containsKey(causal, clase)){
				codigoCausal = String.valueOf(mapCausales.get(causal, clase));
				this.validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}else{
				codigoCausal = verificarExisteCausal(clase, causal);
				if(codigoCausal == null || StringUtils.equals(codigoCausal,"null")){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigosCabeceras.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CAUSAL));
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoCausal = causal;
					this.validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					mapCausales.put(causal,clase, codigoCausal);
					listaCausales.clear();
					listaCausales.add(mapCausales);
					this.validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}
			
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar validar las ");
		}
		return codigoCausal;
	}
	
	/**
	 * METODO QUE PERMITE VERIFICAR SI EXISTE EL CAUSAL
	 * @param clase
	 * @param causalIngreso
	 * @return
	 */
	private String verificarExisteCausal(String clase, String causalIngreso){
		String causal = StringUtils.EMPTY;
		if(StringUtils.isNotEmpty(clase) && StringUtils.isNotEmpty(causalIngreso)){
			if(StringUtils.equals(clase, SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_O)){
				causal = creacionPorArchivoDAO.obtenerCatalogoValor(TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_O, causalIngreso, Boolean.TRUE);
			}else if(StringUtils.equals(clase, SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_E)){
				causal = creacionPorArchivoDAO.obtenerCatalogoValor(TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_E, causalIngreso, Boolean.TRUE);
			}else if(StringUtils.equals(clase, SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_I)){
				causal = creacionPorArchivoDAO.obtenerCatalogoValor(TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_I, causalIngreso, Boolean.TRUE);
			}
		}
		return (causal == null || StringUtils.equals(causal, "null") || StringUtils.isEmpty(StringUtils.trim(causal))) ? "null" : causal;
	}
	
	
	/************************************************************************************************/
	/**************SETTERS***************************************************************************/
	/************************************************************************************************/
	
	
	/**
	 * @param articuloEdicionArchivoDAO the articuloEdicionArchivoDAO to set
	 */
	public void setArticuloEdicionArchivoDAO(IArticuloEdicionArchivoDAO articuloEdicionArchivoDAO) {
		this.articuloEdicionArchivoDAO = articuloEdicionArchivoDAO;
	}

	/**
	 * @param validacionArticuloCampos the validacionArticuloCampos to set
	 */
	public void setValidacionArticuloCampos(IValidacionArticuloCamposCreacionPorArchivoGestor validacionArticuloCampos) {
		this.validacionArticuloCampos = validacionArticuloCampos;
	}
	
	
	/**
	 * @param creacionPorArchivoDAO the creacionPorArchivoDAO to set
	 */
	public void setCreacionPorArchivoDAO(IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO) {
		this.creacionPorArchivoDAO = creacionPorArchivoDAO;
	}


	public void setArticuloClaseDAO(IArticuloClaseDAO articuloClaseDAO) {
		this.articuloClaseDAO = articuloClaseDAO;
	}
}
