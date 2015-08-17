/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo.articulos.edicion;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author eharo
 *
 */
@SuppressWarnings("serial")
public abstract class ArticuloEdicionBase implements Serializable{
	
	protected String codigoArticulo;
	protected Integer codigoCompania;
	protected String clase;
	protected String claseAnterior;
	protected String fechaInicioTemporada;
	protected String fechaFinTemporada;
	protected String usuarioModificacion;
	protected Timestamp fechaModificacion;
	protected String causalCambioClase;
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}
	/**
	 * @param clase the clase to set
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}
	/**
	 * @return the fechaInicioTemporada
	 */
	public String getFechaInicioTemporada() {
		return fechaInicioTemporada;
	}
	/**
	 * @param fechaInicioTemporada the fechaInicioTemporada to set
	 */
	public void setFechaInicioTemporada(String fechaInicioTemporada) {
		this.fechaInicioTemporada = fechaInicioTemporada;
	}
	/**
	 * @return the fechaFinTemporada
	 */
	public String getFechaFinTemporada() {
		return fechaFinTemporada;
	}
	/**
	 * @param fechaFinTemporada the fechaFinTemporada to set
	 */
	public void setFechaFinTemporada(String fechaFinTemporada) {
		this.fechaFinTemporada = fechaFinTemporada;
	}
	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the claseAnterior
	 */
	public String getClaseAnterior() {
		return claseAnterior;
	}
	/**
	 * @param claseAnterior the claseAnterior to set
	 */
	public void setClaseAnterior(String claseAnterior) {
		this.claseAnterior = claseAnterior;
	}
	/**
	 * @return the causalCambioClase
	 */
	public String getCausalCambioClase() {
		return causalCambioClase;
	}
	/**
	 * @param causalCambioClase the causalCambioClase to set
	 */
	public void setCausalCambioClase(String causalCambioClase) {
		this.causalCambioClase = causalCambioClase;
	}
}
