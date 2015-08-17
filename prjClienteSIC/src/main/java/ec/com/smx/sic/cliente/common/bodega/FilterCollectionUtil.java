/*
 * Kruger 2015 
 */ 
package ec.com.smx.sic.cliente.common.bodega;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;

import ec.com.smx.framework.common.util.ClasesUtil;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * <b> Utilitario para filtrar colecciones. </b>
 *
 * @author mchiliquinga, Date: 11/6/2015
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public final class FilterCollectionUtil {
	
	private FilterCollectionUtil() { }
	
	public static <E> E filterForNotEqualProperty(E inputData, String filterField, Object comparator) {
		BeanPredicate predicate = new BeanPredicate(filterField, PredicateUtils.notPredicate(PredicateUtils.equalPredicate(comparator)));
		return (E) CollectionUtils.select((Collection) inputData, predicate);
	}
	
	public static <E> E filterForEqualProperty(E inputData, String filterField, Object comparator) {
		BeanPredicate predicate = new BeanPredicate(filterField, PredicateUtils.equalPredicate(comparator));
		return (E) CollectionUtils.select((Collection) inputData, predicate);
	}
	
	public static <E, T> T collectForField(E inputData, String collectField) {
		validateParameters(inputData, collectField);
		BeanToPropertyValueTransformer transformer = new BeanToPropertyValueTransformer(collectField);
		return (T) CollectionUtils.collect((Collection) inputData, transformer);
	}
	
	public static <E, T> T collectForNotNullField(E inputData, String collectField) {
		E notNullData = filterForNotEqualProperty(inputData, collectField, null);
		BeanToPropertyValueTransformer transformer = new BeanToPropertyValueTransformer(collectField);
		return (T) CollectionUtils.collect((Collection) notNullData, transformer);
	}
	
	public static <E, T> T findForEqualProperty(E inputData, String filterField, Object comparator) {
		BeanPredicate predicate = new BeanPredicate(filterField, PredicateUtils.equalPredicate(comparator));
		return (T) CollectionUtils.find((Collection) inputData, predicate);
	}
	
	public static <E, T> T findForEqualAndProperty(E inputData, Object comparatorA, Object comparatorB, String filterFieldA,
			String filterFieldB) {
		BeanPredicate beanPredicateA = new BeanPredicate(filterFieldA, PredicateUtils.equalPredicate(comparatorA));
		BeanPredicate beanPredicateB = new BeanPredicate(filterFieldB, PredicateUtils.equalPredicate(comparatorB));
		return (T) CollectionUtils.find((Collection) inputData, PredicateUtils.andPredicate(beanPredicateA, beanPredicateB));
	}
	
	public static <E, T> T findForDateData(Collection<E> inputData, String fechaInicio, String fechaFin) {
		BeanPredicate beanPredicateA = new BeanPredicate(fechaInicio, PredicateUtils.notNullPredicate());
		BeanPredicate beanPredicateB = new BeanPredicate(fechaFin, PredicateUtils.nullPredicate());
		return (T) CollectionUtils.find(inputData, PredicateUtils.andPredicate(beanPredicateA, beanPredicateB));
	}
	
	public static <T> List<T> filterDistinctData(Collection<T> inputData) {
		Set<T> distinctSet = new HashSet<T>(inputData);
		return  new ArrayList<T>(distinctSet);
	}
	
	public static <E> boolean isEmptyArray(E... array) {
		return (array == null || array.length == 0);
	}
	
	public static <E> boolean isNotEmptyArray(E... array) {
		return !(isEmptyArray(array));
	}

	/**
	 * <b> Filtra una coleccion por un campo especifico (atributo dentro del DTO), el filtro se realiza por todos los valores del DTO que
	 * empiecen con el valor definido en el parametro 'comparator'; si no existe ninguna coincdencia retorna una coleccion vacia.
	 * </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 11/6/2015]
	 * </p>
	 *
	 * @param inputData
	 *            coleccion base para filtra los datos
	 * @param filterField
	 *            nombre del atributo dentro del DTO por el cual filtra la coleccion
	 * @param comparator
	 *            valor para realizar el filtro
	 * @return Colecion que tiene los datos filtrados.
	 */
	public static <T> T filterForStartsWithProperty(T inputData, final String filterField, final Object comparator) {
		validateParameters(inputData, filterField, comparator);
		final String[] filterFields = filterField.split("\\.");
		Collection filterResult = CollectionUtils.select((Collection) inputData, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Object filterValue = getSearchValue(object, filterFields);
				return filterValue == null ? false : filterValue.toString().startsWith(comparator.toString());
			}
		});
		return (T) filterResult;
	}
	
	public static <T> T setValueForAllData(T inputData, final String setField, final Object valueFild) {
		validateParameters(inputData, setField, valueFild);
		Collection filterResult = CollectionUtils.select((Collection) inputData, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				ClasesUtil.invocarMetodoSet(object, setField, valueFild);
				return true;
			}
		});
		return (T) filterResult;
	}
	
	public static <T> T setValueForDataNotNull(T inputData, final String setField, final Object valueFild) {
		validateParameters(inputData, setField, valueFild);
		Collection filterResult = CollectionUtils.select((Collection) inputData, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				if (object != null) {
					ClasesUtil.invocarMetodoSet(object, setField, valueFild);
				}
				return true;
			}
		});
		return (T) filterResult;
	}
	
	public static <E> boolean existEqualAndPredicate(E inputData, String filterFieldA, String filterFieldB, Object comparatorA, 
			Object comparatorB) {
		BeanPredicate beanPredicateA = new BeanPredicate(filterFieldA, PredicateUtils.equalPredicate(comparatorA));
		BeanPredicate beanPredicateB = new BeanPredicate(filterFieldB, PredicateUtils.equalPredicate(comparatorB));
		return CollectionUtils.exists((Collection) inputData, PredicateUtils.andPredicate(beanPredicateA, beanPredicateB));
	}
	
	public static <E> boolean existEqualProperty(E inputData, String filterField, Object comparator) {
		BeanPredicate beanPredicate = new BeanPredicate(filterField, PredicateUtils.equalPredicate(comparator));
		return CollectionUtils.exists((Collection) inputData, beanPredicate);
	}
	
	/**
	 * <b> Busca un dato dentro de una coleccion para todos los campos y valores
	 * que se le pase al metodo; los campos(atributos del DTO) deben coincidir
	 * con los valores a comparar. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 18/6/2015]
	 * </p>
	 *
	 * @param inputData
	 *            coleccion base para filtrar la busqueda
	 * @param filterFields
	 *            campos por los cuales se evaluara el predicado
	 * @param comparators
	 *            valor por los que se evaluara el predicado
	 * @return primera coincidencia que cumpla con el predicado; null de no
	 *         existir
	 */
	public static <E, T> T findForAllEqualProperty(E inputData, String[] filterFields, Object... comparators) {
		validateParametersForAllPredicate(filterFields, comparators);
		Collection<BeanPredicate> allPredicate = new ArrayList<BeanPredicate>();
		for (int i = 0; i < filterFields.length; i++) {
			BeanPredicate predicate = new BeanPredicate(filterFields[i], PredicateUtils.equalPredicate(comparators[i]));
			allPredicate.add(predicate);
		}
		return (T) CollectionUtils.find((Collection) inputData, PredicateUtils.allPredicate(allPredicate));
	}
	
	/**
	 * <b> Valida que el arreglo que se le pasa no contenga valores nulos. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 11/6/2015]
	 * </p>
	 *
	 * @param parameters
	 *            parametros usados en los metodos para realizar los filtros
	 */
	private static void validateParameters(Object... parameters) {
		for (Object object : parameters) {
			if (object == null) {
				throw new SICException("Existen par\u00e1metros nulos para filtrar la busqueda, revise por favor.");
			}
		}
	}
	
	/**
	 * <b> Obtiene el valor dentro del DTO para realizar el filtro; en el caso de que el objeto tenga atributos compuestos
	 * (a.b.c.valorRequerido) itera todos los atributoa hasta obtener el valor requerido. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 11/6/2015]
	 * </p>
	 *
	 * @param object
	 *            Representa un objeto dentro de la coleccion base para realizar el filtro
	 * @param filterFields
	 *            define en que atributo del DTO se encuentra en valor requerido
	 * @return valor con en cual filtrar la coleccion
	 */
	private static Object getSearchValue(Object object, String... filterFields) {
		Object searchObject = object;
		String methodName = "";
		final String GET = "get";
		try {
			for (String field : filterFields) {
				methodName = GET.concat(field.substring(0, 1).toUpperCase()).concat(field.substring(1, field.length()));
				searchObject = searchObject.getClass().getMethod(methodName).invoke(searchObject);
				if (searchObject == null) {
					break;
				}
			}
			return searchObject;
		} catch (IllegalAccessException e) {
			throw new SICException("No se puede acceder al m\u00e9todo ".concat(methodName), e);
		} catch (IllegalArgumentException e) {
			throw new SICException("Argumento no permitido revise por favor", e);
		} catch (InvocationTargetException e) {
			throw new SICException("No se pudo obtener el valor del m\u00e9todo ".concat(methodName), e);
		} catch (NoSuchMethodException e) {
			throw new SICException("No existe el m\u00e9todo ".concat(methodName), e);
		} catch (SecurityException e) {
			throw new SICException("Notiene permiso para acceder al m\u00e9todo ".concat(methodName), e);
		}
	}
	
	/**
	 * <b> Valida que exista coherencia entre los campos del DTO y los valores para filtrar la busqueda. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 18/6/2015]
	 * </p>
	 *
	 * @param filterFields
	 *            campos por los cuales se evaluara el predicado
	 * @param comparators
	 *            valor por los que se evaluara el predicado
	 */
	private static void validateParametersForAllPredicate(String[] filterFields, Object... comparators) {
		if (filterFields == null || filterFields.length == 0) {
			throw new SICException("Los campos para filtrar la busqueda no pueden ser nulos o vacios.");
		}
		
		if (comparators == null || comparators.length == 0) {
			throw new SICException("Los valores para filtrar la busqueda no pueden ser nulos o vacios.");
		}
		
		if (filterFields.length != comparators.length) {
			throw new SICException("El numero de campos y valores para filtrar la busqueda deben ser iguales.");
		}
	}

}
