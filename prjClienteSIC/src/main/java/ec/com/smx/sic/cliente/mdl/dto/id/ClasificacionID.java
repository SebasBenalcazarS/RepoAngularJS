/*
 * Creado el 19/04/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author bmontesdeoca
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class ClasificacionID implements Serializable
{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOCLASIFICACION", nullable = false)
	private String codigoClasificacion;
  
    public ClasificacionID() {}
    
    public ClasificacionID(Boolean initID) {
    	if(initID){
    		codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
    		codigoClasificacion = SICConstantes.getInstancia().VALOR_INICIAL_ID;
    	}
    }
  /**
   * @return Devuelve codigoCompania.
   */
  public Integer getCodigoCompania()
  {
    return codigoCompania;
  }
  /**
   * @param codigoCompania El codigoCompania a establecer.
   */
  public void setCodigoCompania(Integer codigoCompania)
  {
    this.codigoCompania = codigoCompania;
  }
  /**
   * @return Devuelve codigoClasificacion.
   */
  public String getCodigoClasificacion()
  {
    return codigoClasificacion;
  }
  /**
   * @param codigoClasificacion El codigoClasificacion a establecer.
   */
  public void setCodigoClasificacion(String codigoClasificacion)
  {
    this.codigoClasificacion = codigoClasificacion;
  }
}
