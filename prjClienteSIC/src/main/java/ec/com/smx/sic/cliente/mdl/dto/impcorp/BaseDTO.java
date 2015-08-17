package ec.com.smx.sic.cliente.mdl.dto.impcorp;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.BaseID;

@SuppressWarnings("serial")
//@MappedSuperclass
public class BaseDTO<T extends BaseID> extends SimpleAuditDTO implements Logeable {
	//@EmbeddedId
	protected T id;
	//@Transient
	protected Class<T> idClass;

	@SuppressWarnings("unchecked")
	public BaseDTO() {
		try {
			final Type thisType = getClass().getGenericSuperclass();
			final Type type;
			if (thisType instanceof ParameterizedType) {
				type = ((ParameterizedType) thisType).getActualTypeArguments()[0];
			} else if (thisType instanceof Class) {
				type = ((ParameterizedType) ((Class<?>) thisType).getGenericSuperclass()).getActualTypeArguments()[0];
			} else {
				throw new IllegalArgumentException("Problem handling type construction for " + getClass());
			}
			if(type instanceof Class){
				idClass = ((Class<T>)type);
				id = idClass.newInstance();
			}
		} catch (InstantiationException e) {
			LOG_SICV2.error(e.getMessage());
			
		} catch (IllegalAccessException e) {
			LOG_SICV2.error(e.getMessage());
		}
	}
	

	/**
	 * @return the id
	 */

	public T getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(T id) {
		this.id = id;
	}

	/**
	 * @return the idClass
	 */
	public Class<T> getIdClass() {
		return idClass;
	}

	/**
	 * @param idClass
	 *            the idClass to set
	 */
	public void setIdClass(Class<T> idClass) {
		this.idClass = idClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? super.hashCode() : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseDTO))
			return false;
		BaseDTO<?> other = (BaseDTO<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
