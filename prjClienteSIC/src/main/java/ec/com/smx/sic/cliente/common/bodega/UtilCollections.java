package ec.com.smx.sic.cliente.common.bodega;

import static ec.com.smx.framework.common.util.ClasesUtil.invocarMetodoGet;
import static ec.com.smx.framework.common.util.ClasesUtil.invocarMetodoSet;
import static ec.com.smx.framework.common.util.ClasesUtil.invokeMethod;
import static ec.com.smx.framework.common.util.ClasesUtil.valorComparacion;
import static ec.com.smx.framework.common.util.ComparadorBeanFramework.ORDEN_ASC;
import static ec.com.smx.framework.common.util.ComparadorBeanFramework.ORDEN_DESC;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.framework.common.util.dto.MethodInformation;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author osaransig
 * Oct 8, 2013
 */
public class UtilCollections {
	
	/**
	 * Metodo para encontrar los elementos comunes entre la coleccion a y la b
	 * @param a		Colleccion de datos
	 * @param b		Colleccion de datos
	 * @param nombresAtributos		nombre de los atributos por los que se validara la igualdad 
	 * entre los elementos de las colecciones a y b
	 * 
	 * @return Coleccion donde el primer elemento representa una coleccion con solo datos de a que no estan en b,
	 * el segundo elemento representa los datos de b que no estan en a
	 * y el tercer elemento representa los elementos comunes en ambas colecciones
	 * @throws Exception
	 * @author osaransig
	 */
	public static <T> List<Collection<T>> intersection(Collection<T> a, Collection<T> b, final List<PropertyCompare> listPropiedadesCompare) throws SICException {
		
		return intersection(a, b, listPropiedadesCompare, null);
	}
	
	/**
	 * Metodo para encontrar los elementos comunes y diferencias entre la coleccion a y la b
	 * @param a							Colleccion de datos 
	 * @param b							Colleccion de datos
	 * @param listPropiedadesCompare	Nombre de los atributos por los que se validara la igualdad
	 * entre los elementos de las colecciones a y b
	 * @param propertiesCopy			Array de string para especificar las propiedades que se copiaran del objetos de <b>b</b> al objeto <b>a</b>
	 * en caso de que existan objetos comunes 
	 * @return
	 * @throws Exception
	 * @author osaransig
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<Collection<T>> intersection(Collection<T> a, Collection<T> b, final List<PropertyCompare> listPropiedadesCompare, String [] propertiesCopy) throws SICException {

		final UtilCollections.UtilComparator comparator = new UtilCollections().new UtilComparator(ORDEN_ASC, listPropiedadesCompare);
		List<T> aList = new ArrayList<T>(a); // lista correspondiente a la colection a
		List<T> bList = new ArrayList<T>(b);
		
		Collections.sort(aList, comparator);
		Collections.sort(bList, comparator);
		
		removeRepeatedData(aList, comparator);
		removeRepeatedData(bList, comparator);
		
		List<T> commonData = new ArrayList<T>();
		List<T> aData = new ArrayList<T>();
		List<T> bData = new LinkedList<T>();
		
		for (T t : aList) {
			int i = Collections.binarySearch(bList, t, comparator); //buscar elementos de a en b
			if (i >= 0) { // elemento encontrado
				
				copyPropertyBtoA(t, bList.get(i), propertiesCopy);
				
				commonData.add(t);  // se agrega a los datos comunes
				bList.remove(i);
				
			} else {
		
				aData.add(t);
					
			}
		}
		
		bData = bList;
		
		List<Collection<T>> respuesta = new ArrayList<Collection<T>>();
		respuesta.add(aData); // solo datos de a que no estan en b
		respuesta.add(bData); // solo datos de b que no estan en a
		respuesta.add(commonData);  // datos comunes en a y b
		
		return respuesta;
		
	}
	
	
	/**
	 * Copiar propiedades para objetos iguales
	 * @param a					objeto respuesta
	 * @param b					objeto de donde se obtendran las propiedades para se copiadas en el objeto a
	 * @param propertiesCopy	colleccion de propiedades a copiarse
	 * @throws SICException
	 */
	public static <T> void copyPropertyBtoA(T a, T b, String... propertiesCopy) throws SICException {
		
		if (propertiesCopy != null && propertiesCopy.length > 0) {
			for (String property : propertiesCopy) {
				invocarMetodoSet(a, property, invocarMetodoGet(b, property));
			}
		}
		
	}
	
	/**
	 * Remover datos repetidos de una lista
	 * @param list			lista a elimiar datos repetidos
	 * @param comparator	Comparator con la especificacion de los atributos a compararse
	 * @author osaransig
	 */
	public static <T> void removeRepeatedData(List<T> list, Comparator<T> comparator) {
		
		if (CollectionUtils.isNotEmpty(list) && list.size() >= 2) {

			int i; // indice del objeto buscado
			int j = 1; // indice para controlar los bucles
			T key = list.get(0);
			
			do {
				i = Collections.binarySearch(list.subList(j, list.size()), key, comparator);
				if (i >= 0) { // objeto encontrado
					list.remove(i + j); //eliminar datos repetidos
				} else { // objeto no encontrado
					key = list.get(j++); // obtenemos el siguiente elemento para continuar con la busqueda
				}
			} while(j < list.size());
		}
		
	}

	/**
	 * Comparador util para atributos de la clase y tambien los propiedades dinamicas
	 * @author osaransig
	 * Oct 14, 2013
	 */
	@SuppressWarnings("rawtypes")
	public class UtilComparator implements Comparator {

		private int tipoOrden;
		private MethodInformation methodInformation;
		
		private List<PropertyCompare> listPropiedadesCompare;
		
		public UtilComparator(final int tipoOrden, List<PropertyCompare> listPropiedadesCompare) {
			
			this.tipoOrden = tipoOrden;
			this.listPropiedadesCompare = listPropiedadesCompare;
		
			//metodo para obtener valores de las propiedades dinamicas
			this.methodInformation = new MethodInformation();
			this.methodInformation.setMethodName("getDynamicProperty");
			this.methodInformation.setMethodParametersClasses(new Class[]{String.class});
			this.methodInformation.setMethodParametersValues(new Object[]{""});
		
		}
		
		public int compare(Object o1, Object o2) {
			
			int valor = 0; //valor de la comparacion
			Object o3, o4, oc1, oc2;
			
			if (this.tipoOrden == ORDEN_ASC || tipoOrden == ORDEN_DESC) {
				
				if (tipoOrden == ORDEN_ASC) {
					oc1 = o1;
					oc2 = o2;
				} else {
					oc1 = o2;
					oc2 = o1;
				}
				
				if (CollectionUtils.isNotEmpty(listPropiedadesCompare)) {
					for (PropertyCompare propertyCompare : listPropiedadesCompare) {
						
						if (propertyCompare.getIsDynamicProperty()) { // la propiedad a comparar es una propiedad dinamica
							methodInformation.getMethodParametersValues()[0] = propertyCompare.getNameAttribute();
							
							o3 = invokeMethod(oc1, methodInformation);
							o4 = invokeMethod(oc2, methodInformation);
							
						} else { // atributo perteneciente al objeto
							o3 = invocarMetodoGet(oc1, propertyCompare.getNameAttribute());
							o4 = invocarMetodoGet(oc2, propertyCompare.getNameAttribute());
							
						}
						
						valor = propertyCompare.getPorcentageTolerance() != null && 
								valorComparacionConTolerancia(o4, o3, propertyCompare.getPorcentageTolerance()) == 0 ? 0 : valorComparacion(o3, o4);
					
						if (valor != 0) {
							return valor;
						}
						
					}
				}
				
			}
			
			return valor;
		}
		
		
		public int valorComparacionConTolerancia(Object o1, Object o2, Double porcentajeTolerancia) {
			int valor = 0;

			if (o1 == null && o2 != null) {
				valor = 1;
				
			} else if (o1 != null && o2 == null) {
				valor = -1;
				
			} else if (o1 != null && o2 != null) {
				
				if (o1 instanceof Double && o2 instanceof Double) {
					
					valor = equalWithPorcTolerance((Double) o1, (Double) o2, porcentajeTolerancia);
					
				} else if (o1 instanceof Long && o2 instanceof Long) {
					
					valor = equalWithPorcTolerance(((Long) o1).doubleValue(), ((Long) o2).doubleValue(), porcentajeTolerancia);
					
				} else if (o1 instanceof Integer && o2 instanceof Integer) {
					
					valor = equalWithPorcTolerance(((Integer) o1).doubleValue(), ((Integer) o2).doubleValue(), porcentajeTolerancia);
					
					
				} else if (o1 instanceof BigDecimal && o2 instanceof BigDecimal) {
					
					valor = equalWithPorcTolerance(((BigDecimal) o1).doubleValue(), ((BigDecimal) o2).doubleValue(), porcentajeTolerancia);
				}
			}

			return valor;
		}

		
		/**
		 * Igualdad con porcentaje de tolerancia
		 */
		public int equalWithPorcTolerance(Double num1, Double num2, Double porTolerancia) {
			
			int respuesta = -1;
			
			if (num1.compareTo(num2) == 0) {
				respuesta = 0;
				
			} else {
			
				Double tolerancia = porTolerancia / 100D;
				
				Double dmin = num1 - num1 * tolerancia;
				Double dmax = num1 + num1 * tolerancia;
				
				if (num2 >= dmin && num2 <= dmax) {
					respuesta = 0;
				}
			
			}
			return respuesta;
		}
		
	}
	
	/**
	 * Pojo para representar la propiedad del objeto por el que se va 
	 * a comparar la igualdad, por defaul la propiedad no es una propiedad 
	 * dinamica
	 * @author osaransig
	 * Nov 6, 2013
	 */
	@SuppressWarnings("serial")
	public class PropertyCompare implements Serializable {
		
		/**
		 * Nombre de la propiedad del objeto a comparar
		 */
		private String nameAttribute;
		
		/**
		 * porcenta de tolerancia
		 */
		private Double porcentageTolerance;
		
		/**
		 * indicador propiedades dinamicas
		 */
		private boolean isDynamicProperty;
		
		
		public PropertyCompare(String nameAttribute) {
			this.nameAttribute = nameAttribute;
			
		}
		
		public PropertyCompare(String nameAttribute, boolean isDynamicProperty) {
			this.nameAttribute = nameAttribute;
			this.isDynamicProperty = isDynamicProperty;
			
		}
		
		public PropertyCompare(String nameAttribute, Double  porcentageTolerance) {
			this.nameAttribute = nameAttribute;
			this.porcentageTolerance = porcentageTolerance;
			
		}
		
		public PropertyCompare(String nameAttribute, Double  porcentageTolerance, boolean isDynamicProperty) {
			this.nameAttribute = nameAttribute;
			this.porcentageTolerance = porcentageTolerance;
			this.isDynamicProperty = isDynamicProperty;
			
		}

		public String getNameAttribute() {
			return nameAttribute;
		}

		public void setNameAttribute(String nameAttribute) {
			this.nameAttribute = nameAttribute;
		}

		public Double getPorcentageTolerance() {
			return porcentageTolerance;
		}

		public void setPorcentageTolerance(Double porcentageTolerance) {
			this.porcentageTolerance = porcentageTolerance;
		}

		public boolean getIsDynamicProperty() {
			return this.isDynamicProperty;
		}

		public void setIsDynamicProperty(boolean isDynamicProperty) {
			this.isDynamicProperty = isDynamicProperty;
		}
		
	}
	
	
	/**
	 * Agregar propiedad a comparar
	 * @param attibuteCompare		nombre del atributo del objeto a comparar
	 * @return
	 */
	public static PropertyCompare addPropertyCompare(String attibuteCompare) {
		return new UtilCollections().new PropertyCompare(attibuteCompare);
		
	}
	
	/**
	 * Agregar propiedad dinamica a comparar
	 * @param attibuteCompare			nombre de la propiedad dinamica a comparar
	 * @return
	 */
	public static PropertyCompare addDynamicPropertyCompare(String attibuteCompare) {
		return new UtilCollections().new PropertyCompare(attibuteCompare, true);
		
	}
	
	
	/**
	 * Agregar propiedad a comparar con rango de tolerancia
	 * @param attibuteCompare			nombre del atributo del objeto a comparar
	 * @param porcentajeTolerancia		porcentaje de tolerancia para validar igualdad
	 * @return
	 */
	public static PropertyCompare addPropertyCompare(String attibuteCompare, Double porcentajeTolerancia) {
		return new UtilCollections().new PropertyCompare(attibuteCompare, porcentajeTolerancia);
		
	}
	
	/**
	 * Agregar propiedad dinamica a comparar con rango de tolerancia
	 * @param attibuteCompare			nombre del atributo del objeto a comparar
	 * @param porcentajeTolerancia		porcentaje de tolerancia para validar igualdad
	 * @return
	 */
	public static PropertyCompare addDynamicPropertyCompare(String attibuteCompare, Double porcentajeTolerancia) {
		return new UtilCollections().new PropertyCompare(attibuteCompare, porcentajeTolerancia, true);
		
	}
}
