package ec.com.smx.sic.cliente.common.bodega;

import static ec.com.smx.corpv2.common.util.CorporativoConstantes.TIPO_AREATRABAJO_BODEGA;
import static ec.com.smx.corpv2.common.util.CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DE_DISTRIBUCION;
import static ec.com.smx.corpv2.common.util.CorporativoConstantes.TIPO_AREATRABAJO_MACRO_BODEGA;
import static ec.com.smx.corpv2.common.util.CorporativoConstantes.TIPO_AREATRABAJO_SUBBODEGA;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.map.MultiKeyMap;
import org.hibernate.SQLQuery;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.VistaFuncionarioPerfilOpcionDTO;
import ec.com.smx.framework.common.util.ClasesUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;

public final class CentroDistribucionUtil {
	
	private static final CentroDistribucionUtil INSTANCIA = new CentroDistribucionUtil();
	
	private CentroDistribucionUtil () {}
	
	public static CentroDistribucionUtil getInstancia(){
		return INSTANCIA;
	}
	
	/**
	 * Retorna el nombre del frame 
	 * @return
	 */
	public String obtenerNombreFrame(String currentAccessItemId, Collection<VistaFuncionarioPerfilOpcionDTO> vistaFuncionarioPerfilOpcionCol){
		String name = "";
		try{
			for(VistaFuncionarioPerfilOpcionDTO accessItemModulo : vistaFuncionarioPerfilOpcionCol){
				for(VistaFuncionarioPerfilOpcionDTO accessItemFrame : accessItemModulo.getVistaFuncionarioPerfilOpcionCol()){
					if(currentAccessItemId.equals(accessItemFrame.getId().getCodigoOpcion())){
						name = accessItemFrame.getCodigoVentana();
						break;
					}
				}
				if(!"".equals(name)){
					break;
				}
			}
			
//			if(name == ""){
			if ("".equals(name)){
				Logeable.LOG_SICV2.info("No se encontro el nombre del frame actual");
			}
		}catch(SICException e){
			Logeable.LOG_SICV2.info("Ocurrio un error al obtener el nombre del frame...");
		}
		
		return name;
	}
	
	/**
	 * Se obtiene el id del area de trabajo seleccionada del componene de areas de trabajo
	 * @param collectionCombo
	 * @param areaTrabajoBuscar
	 * @return
	 */
	public Integer obtenerCodigoAreaTrabajoSeleccion(Collection<AreaTrabajoDTO> collectionCombo, String areaTrabajoBuscar){
		
		Integer codigoAreaTrabajo = null;
		AreaTrabajoDTO areaTrabajoSeleccion = this.obtenerAreaTrabajoSeleccion(collectionCombo, areaTrabajoBuscar);
		if (areaTrabajoSeleccion != null) {
			codigoAreaTrabajo = areaTrabajoSeleccion.getId().getCodigoAreaTrabajo();
		}
		return codigoAreaTrabajo;
		
	}
	
	/**
	 * Se obtiene el codigo de referencia del area de trabajo seleccionada del componene de areas de trabajo
	 * @param collectionCombo
	 * @param areaTrabajoBuscar
	 * @return
	 */
	public Integer obtenerCodigoReferenciaAreaTrabajoSeleccion(Collection<AreaTrabajoDTO> collectionCombo, String areaTrabajoBuscar){
		
		Integer codigoReferenciaAreaTrabajo = null;
		AreaTrabajoDTO areaTrabajoSeleccion = this.obtenerAreaTrabajoSeleccion(collectionCombo, areaTrabajoBuscar);
		if (areaTrabajoSeleccion != null) {
			codigoReferenciaAreaTrabajo = areaTrabajoSeleccion.getCodigoReferencia();
		}
		return codigoReferenciaAreaTrabajo;
		
	}
	
	/**
	 * Se obtiene el area de trabajo seleccionada del componene de areas de trabajo
	 * @param collectionCombo
	 * @param areaTrabajoBuscar
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public AreaTrabajoDTO obtenerAreaTrabajoSeleccion(Collection<AreaTrabajoDTO> collectionCombo, String areaTrabajoBuscar){
//		Logeable.logSICV2.info("****************************Selecion comboActionAreaTrabajo ******************************");
		AreaTrabajoDTO areaTrabajoSeleccion=null;
		if(CollectionUtils.isNotEmpty(collectionCombo)){
			
			if(collectionCombo != null && CollectionUtils.isNotEmpty(collectionCombo)){
				Collection<AreaTrabajoDTO> collectionComboBodega = CollectionUtils.select(collectionCombo, new BeanPredicate("tipoAreaTrabajoValor", PredicateUtils.equalPredicate(areaTrabajoBuscar)));
				if(CollectionUtils.isNotEmpty(collectionComboBodega)){
					areaTrabajoSeleccion = (AreaTrabajoDTO)CollectionUtils.get(collectionComboBodega, 0);
//					Logeable.logSICV2.info("codigoAreaTrabajo:{}",areaTrabajoSeleccion.getId().getCodigoAreaTrabajo());
//					Logeable.logSICV2.info("tipoAreaTrabajo:{}",areaTrabajoSeleccion.getTipoAreaTrabajoValor());
//					Logeable.logSICV2.info("NombreAreaTrabajo:{}",areaTrabajoSeleccion.getNombreAreaTrabajo());
//					Logeable.logSICV2.info("*******************************************************************************");
				}
			}
		} else{
			Logeable.LOG_SICV2.info("No existen \u00E1reas de trabajo configuradas para el usuario actual.");
		}
		return areaTrabajoSeleccion;
	}
	
	/**
	 * Obtener los c&oacute;digos de las &aacute;reas de trabajo clasificadas por el parametro tipoAreaTrabajoValor 
	 * @param collectionCombo
	 * @param tipoAreaTrabajoValor
	 * @return
	 */
	public Collection<Integer> obtenerCodigoAreasTrabajoBodega (Collection<AreaTrabajoDTO> collectionCombo, String tipoAreaTrabajoValor) {
		
		Collection<Integer> colCodigoAreasTrabajo = new ArrayList<Integer>();
		
		Collection<AreaTrabajoDTO> colAreaTrabajoCDT = this.collectCollection(collectionCombo, "tipoAreaTrabajoValor", TIPO_AREATRABAJO_CENTRO_DE_DISTRIBUCION);
		
		for (AreaTrabajoDTO areaTrabajoCDT : colAreaTrabajoCDT) {
			if (CollectionUtils.isNotEmpty(areaTrabajoCDT.getAreasTrabajoHijas())) {
				Collection<Integer> colCodigoAreaTrabajoHija = this.obtenerColeccionDesdeAtributo(areaTrabajoCDT.getAreasTrabajoHijas(), "id.codigoAreaTrabajo");
				colCodigoAreasTrabajo.addAll(colCodigoAreaTrabajoHija);
			}
		}
		
		return colCodigoAreasTrabajo;
		
	}
	
	public String obtenerAreaTrabajoProvedorVisualizar (String tipoAreaTrabajoVisualizar) throws SICException {
		
		String vistaAreaTrabajoProvedor=null;
		
//		//vista para subbodegas
//		if(tipoAreaTrabajoVisualizar.equals(EnumCatalogoValorBodega.VALOR_BODEGA_SBO.getCodigoCatalogoValor())){
//			vistaAreaTrabajoProvedor="SCSPEVPROSBODART";
//		}else{//vista para bodegas
//			if(tipoAreaTrabajoVisualizar.equals(EnumCatalogoValorBodega.VALOR_BODEGA_BOD.getCodigoCatalogoValor())){
//				vistaAreaTrabajoProvedor="SCSPEVPROBODART";
//			}else{//vista para cd
//				if(tipoAreaTrabajoVisualizar.equals(EnumCatalogoValorBodega.VALOR_BODEGA_CD.getCodigoCatalogoValor())){
//					vistaAreaTrabajoProvedor="SCSPEVPROCDTART";
//				}else{//vista para macrobodega
//					if(tipoAreaTrabajoVisualizar.equals(EnumCatalogoValorBodega.VALOR_BODEGA_MBO.getCodigoCatalogoValor())){
//						vistaAreaTrabajoProvedor="SCSPEVPROMBOART";
//					}else{
//						new IllegalArgumentException("El parametro tipoAreaTrabajo  debe ser de tipo bodega/subbodega/cd/macro");
//						throw new SICException("El parametro tipoAreaTrabajo  debe ser de tipo SBO/BOD/macro/CDT");
//					}
//				}
//			}
//		}
		
		if(tipoAreaTrabajoVisualizar.equals(TIPO_AREATRABAJO_SUBBODEGA)){ //vista para subbodegas
			vistaAreaTrabajoProvedor="SCSPEVPROSBODART";
		} else if(tipoAreaTrabajoVisualizar.equals(TIPO_AREATRABAJO_BODEGA)){ //vista para bodegas
			vistaAreaTrabajoProvedor="SCSPEVPROBODART";
		} else if(tipoAreaTrabajoVisualizar.equals(TIPO_AREATRABAJO_CENTRO_DE_DISTRIBUCION)){ //vista para cd
			vistaAreaTrabajoProvedor="SCSPEVPROCDTART";
		} else if(tipoAreaTrabajoVisualizar.equals(TIPO_AREATRABAJO_MACRO_BODEGA)){ //vista para macrobodega
			vistaAreaTrabajoProvedor="SCSPEVPROMBOART";
		} else{
			new IllegalArgumentException("El parametro tipoAreaTrabajo  debe ser de tipo bodega/subbodega/cd/macro");
			throw new SICException("El parametro tipoAreaTrabajo  debe ser de tipo SUB/BOD/macro/CDT");
		}
		
		return vistaAreaTrabajoProvedor;
	}
	
	public Calendar obtenerFechaInicio (Date date) {
		Calendar calInicio = Calendar.getInstance();
		calInicio.setTime(date);
		calInicio.set(Calendar.HOUR_OF_DAY, 0);
		calInicio.set(Calendar.MINUTE, 0);
		calInicio.set(Calendar.SECOND, 0);
		calInicio.set(Calendar.MILLISECOND, 0);
		return calInicio;
	}
	
	public Calendar obtenerFechaFin (Date date) {
		Calendar calFin = Calendar.getInstance();
		calFin.setTime(date);
		calFin.set(Calendar.HOUR_OF_DAY, 23);
		calFin.set(Calendar.MINUTE, 59);
		calFin.set(Calendar.SECOND, 59);
		calFin.set(Calendar.MILLISECOND, 0);
		calFin.add(Calendar.DATE, 0);
		return calFin;
	}
	
	/**
	 * 
	 * @param colInput
	 * @param propiedadBuscar
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T,S> Collection<S> obtenerColeccionDesdeAtributo (Collection<T> colInput, final String propiedadBuscar) {
		
		if (CollectionUtils.isEmpty(colInput)) {
			return Collections.emptyList();
		} else {
			
			Set<S> setValueReturn = new HashSet<S>(CollectionUtils.collect(colInput, new Transformer() {
				@Override
				public Object transform(Object input) {
					return ClasesUtil.invocarMetodoGet(input, propiedadBuscar);
				}
			}));
			setValueReturn.remove(null);
			return setValueReturn;
			
		}
		
	}
	
	/**
	 * Recolectar los objetos de una coleccion en base a un 
	 * atributo del objeto que se compara que sea igual que un valor
	 * @param colInput
	 * @param atributoBuscar
	 * @param valorComparar
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Collection<T> collectCollection (Collection<T> colInput, final String atributoBuscar, final String valorComparar) {
		
		if (CollectionUtils.isEmpty(colInput)) {
			return Collections.emptyList();
		} else {
			
			Set<T> colretornar = new HashSet<T>(CollectionUtils.collect(colInput, new Transformer() {
				@Override
				public Object transform(Object arg0) {
					if (ClasesUtil.invocarMetodoGet(arg0, atributoBuscar).equals(valorComparar)) {
						return arg0;
					}
					return null;
				}
			}));
			colretornar.remove(null);
			return colretornar;
			
		}
	}
	
	/**
	 * Realiza un append a una vector 
	 * @param args
	 * @return StringBuilder con los datos concatenados
	 */
	public StringBuilder appendObject (Object ... args) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		if (args != null && args.length > 0) {
			for (int i = 0; i<args.length; i++) {
				stringBuilder.append(args[i]);
			}
		}
		
		return stringBuilder;
		
	}
	
	public StringBuilder appendObject (StringBuilder stringBuilder, Object ... args) {
		
		StringBuilder stringBuilderOut = stringBuilder;
		
		if (stringBuilderOut == null) {
			stringBuilderOut = new StringBuilder();
		}
		
		if (args != null && args.length > 0) {
			for (int i = 0; i<args.length; i++) {
				stringBuilderOut.append(args[i]);
			}
		}
		
		return stringBuilderOut;
	}
	
	/**
	 * Generar un HashMap a partir de una Collection
	 * @param colInput Collection de la que se va generar el mapa
	 * @param propiedadBuscar attributo del objeto <code>T</code> del que se 
	 * va invocar el metodo get, para que sea la clave del mapa.
	 * @return
	 */
	public <T, S> Map<S, T> generarMapDesdeColeccion (Collection<T> colInput, final String propiedadBuscar) {
		
		if (colInput == null || colInput.isEmpty()) {
			return new HashMap<S, T>();
		} else {
			Map<S, T> mapOut = new HashMap<S, T>();
			for (T dto : colInput) {
				mapOut.put((S) ClasesUtil.invocarMetodoGet(dto, propiedadBuscar), dto);
			}
			return mapOut;
		}
		
	}
	
	/**
	 * Generar un MultiKeyMap a partir de una Collection
	 * @param colInput
	 * @param key1
	 * @param key2
	 * @return
	 */
	public <T, S> Map<S, T> generarMultiKeyMapDesdeColeccion (Collection<T> colInput, final String key1, final String key2 ) {
		
		if (colInput == null || colInput.isEmpty()) {
			return new HashMap<S, T>();
		} else {
			MultiKeyMap mapOut = new MultiKeyMap();
			for (T dto : colInput) {
				mapOut.put((S) ClasesUtil.invocarMetodoGet(dto, key1), (S) ClasesUtil.invocarMetodoGet(dto, key2), dto);
			}
			return mapOut;
		}
		
	}
	
	/**
	 * Aplicar diferencia de conjuntos mapDos - mapUno
	 * @param <T>
	 * @param mapUno
	 * @param mapDos
	 * @return
	 */
	public <T> Collection<T> subtract(Map<String, T> mapUno, Map<String, T> mapDos, final String propiedadBuscar) {
		Collection<T> colReturn = new ArrayList<T>();
		for (T dto : mapDos.values()) {
			if (!mapUno.containsKey(ClasesUtil.invocarMetodoGet(dto, propiedadBuscar))) {
				colReturn.add(dto);
			}
		}
		return colReturn;
	}
	
	/**
	 * Asignar los par&aacute;metros en una consulta realizada con sql nativo
	 * @param query
	 * @param parameterMap
	 */
	public void asignarParametrosConsulta (SQLQuery query, Map<String, Object> parameterMap) {
		
		for (Entry<String, Object> parameterEntry : parameterMap.entrySet()) {
			if(parameterEntry.getValue()instanceof Collection<?>){
				query.setParameterList(parameterEntry.getKey(), (Collection<?>)parameterEntry.getValue());
			} else {
				query.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
			}
		}
		
	}
	
}
