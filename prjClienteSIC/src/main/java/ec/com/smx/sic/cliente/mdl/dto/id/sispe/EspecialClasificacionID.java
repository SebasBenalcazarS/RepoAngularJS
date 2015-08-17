/*
 * Creado el 15/03/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author walvarez
 * 
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class EspecialClasificacionID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	@Column(name = "CODIGOESPECIAL")
	private String codigoEspecial;

	@Column(name = "CODIGOCLASIFICACION")
	private String codigoClasificacion;

	
	
	public EspecialClasificacionID() {
		super();
	}

	public EspecialClasificacionID(Boolean initId) {
		if(initId){
			this.codigoCompania =  Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			this.codigoEspecial = SICConstantes.getInstancia().VALOR_INICIAL_ID;
			this.codigoClasificacion = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	
	/**
	 * @return Devuelve codigoClasificacion.
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion
	 *            El codigoClasificacion a establecer.
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return Devuelve codigoCompania.
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania
	 *            El codigoCompania a establecer.
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return Devuelve codigoEspecial.
	 */
	public String getCodigoEspecial() {
		return codigoEspecial;
	}

	/**
	 * @param codigoEspecial
	 *            El codigoEspecial a establecer.
	 */
	public void setCodigoEspecial(String codigoEspecial) {
		this.codigoEspecial = codigoEspecial;
	}
}
