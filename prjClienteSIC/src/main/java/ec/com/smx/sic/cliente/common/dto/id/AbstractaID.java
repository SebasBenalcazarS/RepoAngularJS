package ec.com.smx.sic.cliente.common.dto.id;

/**
 * Java Imports
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author xmino
 *
 */
public abstract class AbstractaID implements Serializable, Cloneable {

	/**
	 * Comentario para <code>arrayId</code> Arreglo de objetos ID
	 * 
	 * @generated 
	 *            "UML en Java (com.ibm.xtools.transform.uml2.java.internal.UML2JavaTransform)"
	 */
	private Object arrayId[];

	/**
	 * Comentario para <code>colId</code> Colecci�n de objetos ID
	 * 
	 * @generated 
	 *            "UML en Java (com.ibm.xtools.transform.uml2.java.internal.UML2JavaTransform)"
	 */
	private Collection colId = new ArrayList();

	/**
	 * Comentario para <code>hashcodeValue</code> Un entero primo como semilla
	 * de hascode
	 * 
	 * @generated 
	 *            "UML en Java (com.ibm.xtools.transform.uml2.java.internal.UML2JavaTransform)"
	 */
	private Integer hashcodeValue = null;

	/**
	 * Comentario para <code>sclassName</code> Es el nombre de la clase a la que
	 * pertenece el objeto
	 * 
	 * @generated 
	 *            "UML en Java (com.ibm.xtools.transform.uml2.java.internal.UML2JavaTransform)"
	 */

	private String sclassName;

	/**
	 * Comentario para <code>logger</code>
	 * 
	 * @generated 
	 *            "UML en Java (com.ibm.xtools.transform.uml2.java.internal.UML2JavaTransform)"
	 */
	private Log logger;

	/**
	 * Constructor por defecto Sin parametros
	 */
	public AbstractaID() {
		logger = LogFactory.getLog(getClass());
	}

	/**
	 * Constructor recibe un entero para hashCode
	 * 
	 * @param iHashCodeValue
	 */
	public AbstractaID(int iHashCodeValue) {
		super();
		logger = LogFactory.getLog(getClass());
		hashcodeValue = new Integer(iHashCodeValue);
	}

	/**
	 * Constructor recibe secuencial y codigo
	 * 
	 * @param col
	 */
	public AbstractaID(Collection col) {
		super();
		logger = LogFactory.getLog(getClass());
		this.setArrayId(col.toArray());
	}

	/**
	 * Constructor recibe un arreglo de objectos ID
	 * 
	 * @param arrayId
	 */
	public AbstractaID(Object[] arrayId) {
		super();
		logger = LogFactory.getLog(getClass());
		// this.arrayId = arrayId;
		this.setArrayId(arrayId);
	}

	/**
	 * Getters and Setters
	 */

	/**
	 * @return Devuelve hashcodeValue.
	 */
	public Integer getHashcodeValue() {
		return hashcodeValue;
	}

	/**
	 * @return Devuelve sclassName.
	 */
	public String getSclassName() {
		return sclassName;
	}

	/**
	 * @param sclassName
	 *            El sclassName a establecer.
	 */
	public void setSclassName(String sclassName) {
		this.sclassName = sclassName;
	}

	/**
	 * @param hashcodeValue
	 *            El hashcodeValue a establecer.
	 */
	public void setHashcodeValue(Integer hashcodeValue) {
		this.hashcodeValue = hashcodeValue;
	}

	/**
	 * @return Devuelve arrayId.
	 */
	public Object[] getArrayId() {
		return arrayId;
	}

	/**
	 * @param arrayId
	 *            El arrayId a establecer.
	 */
	public void setArrayId(Object[] arrayId) {
		// this.arrayId = arrayId;
		this.arrayId = new Object[arrayId.length];
		for (int i = 0; i < arrayId.length; i++) {
			this.arrayId[i] = arrayId[i];
		}
	}

	/**
	 * @return Devuelve colId.
	 */
	public Collection getColId() {
		return colId;
	}

	/**
	 * @param colId
	 *            El colId a establecer.
	 */
	public void setColId(Collection colId) {
		this.colId = colId;
	}

	/**
	 * Llamado dentro de equals y hashCode Encargado de llenar la coleccion
	 */
	public abstract void configureColIds();

	/**
	 * Return an object by index
	 * 
	 * @param index
	 * @return
	 */
	public Object getArrayObject(int index) {
		try {
			// devolver un objecto id del
			// indice correspondiente
			return this.arrayId[index];
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Added an element to collection
	 * 
	 * @param obj
	 */
	@SuppressWarnings("unchecked")
	public void addElement(Object obj) {
		// if(this.colId.size()<1)
		this.colId.add(obj);
	}

	/**
	 * Change collection to array
	 */
	@SuppressWarnings("unchecked")
	public void collectionToArray() {
		this.setArrayId(this.colId.toArray());
	}

	/**
	 * Resetear la coleccion
	 */
	public void resetCollection() {
		this.colId = new ArrayList();
	}

	/**
	 * Return a hashCode
	 */
	public synchronized int hashCode() {

		this.configureColIds(); // Obligar a que el objecto est� cargado
		if (hashcodeValue == null) {

			hashcodeValue = new Integer(super.hashCode());

		}
		return hashcodeValue.intValue();
	}

	/**
	 * Return a hascode composite
	 * 
	 * @return
	 */
	public int hashCodeCompositeArray() {
		int result = this.hashCode();
		for (int i = 0; i < this.arrayId.length; i++) {
			if ((i % 2) == 0) {
				result = result * arrayId[i].hashCode();
			} else {
				result = result + arrayId[i].hashCode();
			}

		}
		return result;
	}

	/**
	 * Replace the equals method
	 */

	public boolean equals(Object o) {
		// this.setIsdebug(SICMessages.getString("ec.com.smx.sic.plugin.commons.isdebug"));
		logger = LogFactory.getLog(getClass());
		if (this == o)
			return true;
		if (o == null)
			return false;

		try {

			if (!(o.getClass().getName().equals(this.getClass().getName())))
				return false;

			final AbstractaID objetoaux = (AbstractaID) o;

			this.configureColIds(); // Obligar a que el objecto est� cargado
			objetoaux.configureColIds(); // para el objeto de comparacion

			if (objetoaux.arrayId.length != this.arrayId.length)
				return false;

			for (int i = 0; i < this.arrayId.length; i++) {
				if (this.arrayId[i] == null) {
					if (objetoaux.getArrayObject(i) != null)
						return false;
				} else {
					if (objetoaux.arrayId[i] == null)
						return false;
					if (!this.arrayId[i].equals(objetoaux.arrayId[i]))
						return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Return the error message
	 * 
	 * @param ex
	 * @return
	 */

	private String getErrorMessage(Exception ex) {
		return (new java.util.Date()).toString() + ": Excepcion en: " + this.getClass().getName() + ": debido a :" + ex.getClass().getName() + ": " + ex.getMessage();
	}

	/**
	 * Sobreescribir el m�todo clone
	 */
	public Object clone() {
		logger = LogFactory.getLog(getClass());
		try {

			AbstractaID idClone = (AbstractaID) super.clone();
			idClone.setColId(this.getColId());
			idClone.setArrayId(this.getArrayId());
			idClone.setSclassName(this.getSclassName());
			idClone.setHashcodeValue(new Integer(this.hashCode()));
			return idClone;
		} catch (Exception e) {
			return null;
		}
	}

}
