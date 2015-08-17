package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaNovedadRecepcionArticuloID extends BaseID {
	
	private Integer codigoCompania;
	
	private Long codigoProcesoLogistico;
	
	private Long codigoNovedadArticulo;
	
	private Long codigoGrupoNovedadArticulo;
	
	private Long codigoNovedadArticuloJustificacion ;
	
	private String codigoArticulo;
	
	private Long codigoUnidadManejo;
	
	private Long codigoJustificacion;
	
	private String codigoFuncionario;
	
	private String profileId;

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
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

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
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the codigoJustificacion
	 */
	public Long getCodigoJustificacion() {
		return codigoJustificacion;
	}

	/**
	 * @param codigoJustificacion the codigoJustificacion to set
	 */
	public void setCodigoJustificacion(Long codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}

	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	/**
	 * @return the profileId
	 */
	public String getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the codigoNovedadArticulo
	 */
	public Long getCodigoNovedadArticulo() {
		return codigoNovedadArticulo;
	}

	/**
	 * @param codigoNovedadArticulo the codigoNovedadArticulo to set
	 */
	public void setCodigoNovedadArticulo(Long codigoNovedadArticulo) {
		this.codigoNovedadArticulo = codigoNovedadArticulo;
	}

	/**
	 * @return the codigoGrupoNovedadArticulo
	 */
	public Long getCodigoGrupoNovedadArticulo() {
		return codigoGrupoNovedadArticulo;
	}

	/**
	 * @param codigoGrupoNovedadArticulo the codigoGrupoNovedadArticulo to set
	 */
	public void setCodigoGrupoNovedadArticulo(Long codigoGrupoNovedadArticulo) {
		this.codigoGrupoNovedadArticulo = codigoGrupoNovedadArticulo;
	}

	/**
	 * @return the codigoNovedadArticuloJustificacion
	 */
	public Long getCodigoNovedadArticuloJustificacion() {
		return codigoNovedadArticuloJustificacion;
	}

	/**
	 * @param codigoNovedadArticuloJustificacion the codigoNovedadArticuloJustificacion to set
	 */
	public void setCodigoNovedadArticuloJustificacion(Long codigoNovedadArticuloJustificacion) {
		this.codigoNovedadArticuloJustificacion = codigoNovedadArticuloJustificacion;
	}
	
}
