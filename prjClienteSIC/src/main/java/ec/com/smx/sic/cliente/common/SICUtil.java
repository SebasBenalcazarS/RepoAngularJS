/**
 * 
 */
package ec.com.smx.sic.cliente.common;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * @author fmunoz
 * 
 */
public final class SICUtil {
	
	private static final SICUtil INSTANCIA = new SICUtil();
	private SICUtil() {}
	
	public static SICUtil getInstance(){
		return INSTANCIA;
	}
	/**
	 * Construye una restricci�n para obtener el c�digo de barras de un art�culo tomando como referencia una fecha de transacci�n
	 * @param criteria					- Criterio de busqueda
	 * @param aliasBitacora				- Alias de la relaci�n con la bit�cora de c�digos de barra
	 * @param referenceDateProperty		- Fecha de referencia de la transacci�n realizada con el art�culo
	 */
	public void addCodeBarRestrictionByDate(Criteria criteria, String aliasBitacora, String referenceDateProperty){
		criteria.add(Restrictions.or(Restrictions.and(Restrictions.eq(aliasBitacora.concat(".estadoArticuloBitacora"), SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO),Restrictions.leProperty(aliasBitacora.concat(".id.fechaInicialActivo"), referenceDateProperty)), Restrictions.and(Restrictions.leProperty(aliasBitacora.concat(".id.fechaInicialActivo"), referenceDateProperty), Restrictions.geProperty(aliasBitacora.concat(".fechaFinalActivo"), referenceDateProperty))));
	}
	
	/**
	 * Construye una restricci�n para obtener el c�digo de barras de un art�culo tomando como referencia una fecha de transacci�n
	 * @param aliasBitacora				- Alias de la relaci�n con la bit�cora de c�digos de barra
	 * @param referenceDateProperty		- Fecha de referencia de la transacci�n realizada con el art�culo
	 */
	public String addCodeBarRestrictionByDate(String aliasBitacora, String referenceDateProperty){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" and ((").append(aliasBitacora).append(".estadoArticuloBitacora = '").append(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO).append("'").append(" and ").append(aliasBitacora).append(".id.fechaInicialActivo <= ").append(referenceDateProperty).append(") or (").append(aliasBitacora).append(".id.fechaInicialActivo <= ").append(referenceDateProperty).append(" and ").append(aliasBitacora).append(".fechaFinalActivo >= ").append(referenceDateProperty).append("))");
		return stringBuilder.toString();
	}
	
	/**
	 * Respalda las relaciones del objecto en un mapa y luego las anula
	 * @param object	- Objeto base
	 * @return			- Mapa (propiedad/valor) con las relaciones del objeto base
	 */
	public <T extends SearchDTO> Map<String, Object> clearRelations(T object){
		Field [] fields = object.getPOJO().getClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		for(Field field : fields){
			if(field.isAnnotationPresent(ManyToOne.class) || field.isAnnotationPresent(OneToOne.class) || field.isAnnotationPresent(OneToMany.class)){
				try{ 
					map.put(field.getName(), PropertyUtils.getProperty(object, field.getName()));
					PropertyUtils.setProperty(object, field.getName(), null);
				}catch (Exception e) {Logeable.LOG_SICV2.error(e.getMessage());}
			}
		}
		if(map.isEmpty())
			map = null;
		return map;
	}
	
	/**
	 * Obtiene las relaciones del objecto en un mapa
	 * @param object	- Objeto base
	 * @return			- Mapa (propiedad/valor) con las relaciones del objeto base
	 */
	public <T extends SearchDTO> Map<String, Object> getRelations(T object){
		if(object != null){
			
			Field [] fields = object.getPOJO().getClass().getDeclaredFields();
			Map<String, Object> map = new HashMap<String, Object>();
			for(Field field : fields){
				if(field.isAnnotationPresent(ManyToOne.class) || field.isAnnotationPresent(OneToOne.class) || field.isAnnotationPresent(OneToMany.class)){
					try{ 
						Object relation =PropertyUtils.getProperty(object, field.getName());
						if(SearchDTO.isLoaded(relation)){
							map.put(field.getName(), relation);
						}
					}catch (Exception e) {Logeable.LOG_SICV2.error(e.getMessage());}
				}
			}
			if(map.isEmpty())
				map = null;
			return map;
			
		}
		return null;
	}
	
	/**
	 * Restaura las relaciones de un objeto previamente limpiadas con el m�todo <code>clearRelations</code>
	 * @param object
	 */
	public <T extends SearchDTO> void restoreRelations(T object, Map<String, Object> relations){
		restoreRelations(object, relations, Boolean.TRUE);
	}
	
	/**
	 * Restaura las relaciones de un objeto previamente limpiadas con el m�todo <code>clearRelations</code>
	 * @param object
	 */
	public <T extends SearchDTO> void restoreRelations(T object, Map<String, Object> relations, Boolean clearRelations){
		if(object != null && relations != null){
    		for(String key : relations.keySet()){
    			try{
    				PropertyUtils.setProperty(object, key, relations.get(key));
    			}catch (Exception e) {Logeable.LOG_SICV2.error(e.getMessage());}
    		}
    		if(clearRelations){
    			relations.clear();
    		}
		}
	}
	
	/**
	 * Redondea un valor decimal en base a la precisi�n
	 * @param valor
	 * @param precisionDecimal
	 * @return
	 */
	public Double roundNumber(Double valor, Integer precisionDecimal){
		BigDecimal bd = BigDecimal.valueOf(valor);
		return bd.setScale(precisionDecimal, RoundingMode.HALF_UP).doubleValue();
	}
	
	/**
	 * Trunca un valor decimal en base a la precisi�n
	 * @param valor
	 * @param precisionDecimal
	 * @return
	 */
	public Double truncateNumber(Double valor, Integer precisionDecimal){
		BigDecimal bd = BigDecimal.valueOf(valor);
		return bd.setScale(precisionDecimal, RoundingMode.DOWN).doubleValue();
	}
}
