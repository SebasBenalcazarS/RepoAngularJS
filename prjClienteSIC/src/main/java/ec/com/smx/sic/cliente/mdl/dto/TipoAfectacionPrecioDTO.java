/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoAfectacionPrecioID;

/**
 * @author cjara
 *
 */
@Entity
@Table(name="SCPRETTIPAFEPRE")
@SuppressWarnings("serial")
public class TipoAfectacionPrecioDTO extends AuditoriaBaseDTO{

	@EmbeddedId
	private TipoAfectacionPrecioID id = new TipoAfectacionPrecioID();
	
	@Column(name = "NOMBRETIPOAFECTACION", nullable = false)
	private String nombreTipoAfectacion;
	
	@Column(name = "DESCRIPCIONTIPOAFECTACION", nullable = false)
	private String descripcionTipoAfectacion;
	
	@Column(name = "PRIORIDAD", nullable = false)
	private Integer prioridad;

	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@OneToMany(mappedBy = "tipoAfectacionPrecio")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ConfiguracionAfectacionPrecioDTO> configuracionAfectacionPrecios;

	/**
	 * @return the id
	 */
	public TipoAfectacionPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TipoAfectacionPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the nombreTipoAfectacion
	 */
	public String getNombreTipoAfectacion() {
		return nombreTipoAfectacion;
	}

	/**
	 * @param nombreTipoAfectacion the nombreTipoAfectacion to set
	 */
	public void setNombreTipoAfectacion(String nombreTipoAfectacion) {
		this.nombreTipoAfectacion = nombreTipoAfectacion;
	}

	/**
	 * @return the descripcionTipoAfectacion
	 */
	public String getDescripcionTipoAfectacion() {
		return descripcionTipoAfectacion;
	}

	/**
	 * @param descripcionTipoAfectacion the descripcionTipoAfectacion to set
	 */
	public void setDescripcionTipoAfectacion(String descripcionTipoAfectacion) {
		this.descripcionTipoAfectacion = descripcionTipoAfectacion;
	}

	/**
	 * @return the prioridad
	 */
	public Integer getPrioridad() {
		return prioridad;
	}

	/**
	 * @param prioridad the prioridad to set
	 */
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the configuracionAfectacionPrecios
	 */
	public Collection<ConfiguracionAfectacionPrecioDTO> getConfiguracionAfectacionPrecios() {
		return configuracionAfectacionPrecios;
	}

	/**
	 * @param configuracionAfectacionPrecios the configuracionAfectacionPrecios to set
	 */
	public void setConfiguracionAfectacionPrecios(Collection<ConfiguracionAfectacionPrecioDTO> configuracionAfectacionPrecios) {
		this.configuracionAfectacionPrecios = configuracionAfectacionPrecios;
	}
}
