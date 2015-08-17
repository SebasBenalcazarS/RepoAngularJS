package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.BaseID;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseDTO<T extends BaseID> extends SimpleAuditDTO {
	@EmbeddedId
	protected T id;
	@Transient
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
			throw new SICException("Error al tratar de instanciar el objeto",e);
		} catch (IllegalAccessException e) {
			throw new SICException("Accesso ilegal a la clase",e);
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
	
	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioRegistro</code>.
	 * @param usuarioRegistro1 
	 *		El valor a establecer para la propiedad <code>usuarioRegistro</code>.
	 */
	public abstract void setUsuarioRegistro( String usuarioRegistro );

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * @param fechaRegistro1 
	 *		El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public abstract void setFechaRegistro( java.util.Date fechaRegistro );

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * @param usuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public abstract void setUsuarioModificacion( String usuarioModificacion );


	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * @param fechaModificacion1 
	 *		El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public abstract void setFechaModificacion( java.util.Date fechaModificacion );

}
