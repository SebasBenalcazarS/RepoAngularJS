package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author cpescobar
 *
 */
@SuppressWarnings("serial")
public class ProcesoLogisticoAutorizacionID implements Serializable{

	/**
	 * Especifica el codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/*
	 * Inicio campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * 
	 * */
	@Column(name="CODIGOPROCESOLOGISTICOAUTORIZACION") 
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECPROLOGAUT" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoProcesoLogisticoAutorizacion;
	
	
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
	 * @return the codigoProcesoLogisticoAutorizacion
	 */
	public Long getCodigoProcesoLogisticoAutorizacion() {
		return codigoProcesoLogisticoAutorizacion;
	}

	/**
	 * @param codigoProcesoLogisticoAutorizacion the codigoProcesoLogisticoAutorizacion to set
	 */
	public void setCodigoProcesoLogisticoAutorizacion(Long codigoProcesoLogisticoAutorizacion) {
		this.codigoProcesoLogisticoAutorizacion = codigoProcesoLogisticoAutorizacion;
	}
}
