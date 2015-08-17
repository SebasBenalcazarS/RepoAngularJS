package ec.com.smx.sic.articulo.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.MultiKeyMap;
import org.hibernate.HibernateException;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.BasicTransformerAdapter;
import org.hibernate.transform.ResultTransformer;

import ec.com.smx.framework.common.util.ClasesUtil;

@SuppressWarnings("serial")
public class AliasToBeanNestedResultTransformer extends BasicTransformerAdapter {
	
	private final Class<?> resultClass;
	
	public AliasToBeanNestedResultTransformer(Class<?> resultClass) {
		
		this.resultClass = resultClass;
	}
	
	@SuppressWarnings("unchecked")
	public Object transformTuple(Object[] tuple, String[] aliases) {
		
		Map<Class<?>, List<?>> subclassToAlias = new HashMap<Class<?>, List<?>>();
		Map<Class<?>, List<?>> subCollectionToAlias = new HashMap<Class<?>, List<?>>();
		List<String> nestedAliases = new ArrayList<String>();
		
		try {
			for (int i = 0; i < aliases.length; i++) {
				String alias = aliases[i];
				if (alias.contains("_")) {
					nestedAliases.add(alias);
					
					String[] sp = alias.split("\\_");
					String fieldName = sp[0];
					String aliasName = sp[1];
					
					Type type = resultClass.getDeclaredField(fieldName).getGenericType();
					
					if (type instanceof ParameterizedType) {
		                ParameterizedType pType = (ParameterizedType)type;
//		                System.out.println("Tipo: " + ((Class<?>)pType.getRawType()).getName());		                
		                Type[] arr = pType.getActualTypeArguments();
		                Class<?> clzz = (Class<?>)arr[0];
//	                    System.out.println("Coleccion de tipo: " + clzz.getName());
	                    this.asignarValoresASubClases(subCollectionToAlias, clzz, fieldName, tuple, aliasName, i);
		            }else{
		            	Class<?> subclass = (Class<?>) type;
		            	this.asignarValoresASubClases(subclassToAlias, subclass, fieldName, tuple, aliasName, i);
		            }
				}
			}
		} catch (NoSuchFieldException e) {
			throw new HibernateException( "Could not instantiate resultclass: " + resultClass.getName() );
		}
		
		Map nivel = new HashMap<String, Object>();
		Object[] newTuple = new Object[aliases.length - nestedAliases.size()];
		String[] newAliases = new String[aliases.length - nestedAliases.size()];
		int i = 0;
		for (int j = 0; j < aliases.length; j++) {
			if (!nestedAliases.contains(aliases[j])) {
				newTuple[i] = tuple[j];
				newAliases[i] = aliases[j];
				nivel.put(newAliases[i], newTuple[i]);
				++i;
			}
		}
		
		
		MultiKeyMap rootMap = new MultiKeyMap();
		rootMap.put("1", 0, nivel);
		rootMap.put("1", 1, subclassToAlias);
		rootMap.put("1", 2, subCollectionToAlias);
		
		
		return rootMap;
	}
	
	public List transformList(List list) {
		List transformedList = new ArrayList();
		for(Object element : list){
			MultiKeyMap rootMap = (MultiKeyMap) element;
			Object root = null;
			for(int i = 0; i < rootMap.keySet().size(); i++){
				
				switch (i) {
				case 0:
					/**
					 * ATRIBUTOS
					 */
					Map nivel = (Map) rootMap.get("1", i);
					ResultTransformer rootTransformer = new AliasToBeanResultTransformer(resultClass);
					String[] newAliases = (String[]) nivel.keySet().toArray(new String[0]);
					List<Object> newTuple = new ArrayList<Object>();
					for (String key : newAliases){
						newTuple.add(nivel.get(key));
					}
					
					root = rootTransformer.transformTuple(newTuple.toArray(), newAliases);
					break;
				case 1:
					/**
					 * CLASES
					 */
					
					Map<Class<?>, List<?>> subclassToAlias = (Map<Class<?>, List<?>>) rootMap.get("1", i);
					
					for (Class<?> subclass : subclassToAlias.keySet()) {
						ResultTransformer subclassTransformer = new AliasToBeanResultTransformer(subclass);
						String[] aliasClass = (String[]) (((List<Object>)subclassToAlias.get(subclass).get(1)).toArray(new String[0]));
						Object[] tupleClass = ((List<Object>)subclassToAlias.get(subclass).get(0)).toArray();
						Object subObject = subclassTransformer.transformTuple(tupleClass, aliasClass);
						
						PropertyAccessor accessor = PropertyAccessorFactory.getPropertyAccessor("property");
						accessor.getSetter(resultClass, (String)subclassToAlias.get(subclass).get(2)).set(root, subObject, null);
					}
					
				case 2:
					/**
					 * COLECCIONES
					 */
					
					Map<Class<?>, List<?>> subCollectionToAlias = (Map<Class<?>, List<?>>) rootMap.get("1", i);
					
					
					for (Class<?> subclass : subCollectionToAlias.keySet()){
						ResultTransformer subclassTransformer = new AliasToBeanResultTransformer(subclass);
						String[] aliasCol = (String[]) (((List<Object>)subCollectionToAlias.get(subclass).get(1)).toArray(new String[0]));
						Object[] tupleCol = ((List<Object>)subCollectionToAlias.get(subclass).get(0)).toArray();
						Object subObject = subclassTransformer.transformTuple(tupleCol, aliasCol);
						
						Map<String, Object> projection = (Map<String, Object>) ClasesUtil.invocarMetodoGet(root, "projection");
						projection.put((String)subCollectionToAlias.get(subclass).get(2), subObject);
					}

				default:
					break;
				}
			}
			transformedList.add(root);
		}
		
		return transformedList;
	}
	
	private void asignarValoresASubClases(Map<Class<?>, List<?>> subclassToAlias, Class<?> clase, String fieldName, Object[] tuple, String aliasName, Integer count){
		if (!subclassToAlias.containsKey(clase)) {
			List<Object> list = new ArrayList<Object>();
			list.add(new ArrayList<Object>());
			list.add(new ArrayList<String>());
			list.add(fieldName);
			subclassToAlias.put(clase, list);
		}
		((List<Object>)subclassToAlias.get(clase).get(0)).add(tuple[count]);
		((List<String>)subclassToAlias.get(clase).get(1)).add(aliasName);
	}
}