/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConfiguracionNivelPagoReporteCaracteristicaID;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTCONNIVPAGREPCAR")
public class ConfiguracionNivelPagoReporteCaracteristicaDTO extends AuditoriaBaseDTO{

	@EmbeddedId
	private ConfiguracionNivelPagoReporteCaracteristicaID id;
	
	private Integer prioridad;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCARACTERISTICA", referencedColumnName="CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOCARACTERISTICATIPO", referencedColumnName="CODIGOCATALOGOTIPO", insertable = false, updatable = false)
		})
	private CatalogoValorDTO caracteristica;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "SECCONNIVPAG", referencedColumnName = "SECCONNIVPAG", insertable = false, updatable = false)
	})
	private ConfiguracionNivelPagoDTO configuracionNivelPagoReporte;

	/**
	 * @return the id
	 */
	public ConfiguracionNivelPagoReporteCaracteristicaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ConfiguracionNivelPagoReporteCaracteristicaID id) {
		this.id = id;
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
	 * @return the caracteristica
	 */
	public CatalogoValorDTO getCaracteristica() {
		return caracteristica;
	}

	/**
	 * @param caracteristica the caracteristica to set
	 */
	public void setCaracteristica(CatalogoValorDTO caracteristica) {
		this.caracteristica = caracteristica;
	}

	/**
	 * @return the configuracionNivelPagoReporte
	 */
	public ConfiguracionNivelPagoDTO getConfiguracionNivelPagoReporte() {
		return configuracionNivelPagoReporte;
	}

	/**
	 * @param configuracionNivelPagoReporte the configuracionNivelPagoReporte to set
	 */
	public void setConfiguracionNivelPagoReporte(
			ConfiguracionNivelPagoDTO configuracionNivelPagoReporte) {
		this.configuracionNivelPagoReporte = configuracionNivelPagoReporte;
	}

	
	
}
