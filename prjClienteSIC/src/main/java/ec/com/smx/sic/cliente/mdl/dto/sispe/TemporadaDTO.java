
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.TemporadaID;


/**
 * Entidad que almacena la informaci�n de las temporadas.
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Entity(name="ec.com.smx.sic.cliente.mdl.dto.sispe.TemporadaDTO")
@Table(name = "SCSPETTEMPORADA")
public class TemporadaDTO extends AuditoriaBaseDTO<TemporadaID> {


	/**
	 * Descripci�n de la tempodara
	 *

	 */
	@Column (name = "DESCRIPCIONTEMPORADA")
	private String descripcionTemporada ;

	

	/**
	 * Observaci�n de la temporada
	 *

	 */
	@Column (name = "OBSERVACIONTEMPORADA")
	private String observacionTemporada ;

	

	/**
	 * Estado de la temporada, permite valores [1] Activo, [0] Inactivo
	 *

	 */
	@Column (name = "ESTADOTEMPORADA")
	private String estadoTemporada ;

	

	/**
	 * Fecha inicial de la temporada
	 *

	 */
	@Column (name = "FECHAINICIALTEMPORADA")
	private java.util.Date fechaInicialTemporada ;

	

	/**
	 * Fecha final de la temporada
	 *

	 */
	@Column (name = "FECHAFINALTEMPORADA")
	private java.util.Date fechaFinalTemporada ;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy  = "temporadaDTO")
	@CollectionTypeInfo(name = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ArticuloTemporadaDTO> articuloTemporadaCol;

	
	/**
	 * Retorna valor de propiedad <code>descripcionTemporada</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>descripcionTemporada</code>
	 */
	public String getDescripcionTemporada(){
		return this.descripcionTemporada;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcionTemporada</code>.
	 * @param descripcionTemporada1 
	 *		El valor a establecer para la propiedad <code>descripcionTemporada</code>.
	 */
	public void setDescripcionTemporada( String descripcionTemporada1 ){
		this.descripcionTemporada=descripcionTemporada1;
		
		if(descripcionTemporada!=null && descripcionTemporada.length()>100){
			descripcionTemporada = descripcionTemporada.substring(0,100);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>observacionTemporada</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>observacionTemporada</code>
	 */
	public String getObservacionTemporada(){
		return this.observacionTemporada;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>observacionTemporada</code>.
	 * @param observacionTemporada1 
	 *		El valor a establecer para la propiedad <code>observacionTemporada</code>.
	 */
	public void setObservacionTemporada( String observacionTemporada1 ){
		this.observacionTemporada=observacionTemporada1;
		
		if(observacionTemporada!=null && observacionTemporada.length()>1000){
			observacionTemporada = observacionTemporada.substring(0,1000);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>estadoTemporada</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estadoTemporada</code>
	 */
	public String getEstadoTemporada(){
		return this.estadoTemporada;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoTemporada</code>.
	 * @param estadoTemporada1 
	 *		El valor a establecer para la propiedad <code>estadoTemporada</code>.
	 */
	public void setEstadoTemporada( String estadoTemporada1 ){
		this.estadoTemporada=estadoTemporada1;
		
		if(estadoTemporada!=null && estadoTemporada.length()>1){
			estadoTemporada = estadoTemporada.substring(0,1);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>fechaInicialTemporada</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaInicialTemporada</code>
	 */
	public java.util.Date getFechaInicialTemporada(){
		return this.fechaInicialTemporada;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaInicialTemporada</code>.
	 * @param fechaInicialTemporada1 
	 *		El valor a establecer para la propiedad <code>fechaInicialTemporada</code>.
	 */
	public void setFechaInicialTemporada( java.util.Date fechaInicialTemporada1 ){
		this.fechaInicialTemporada=fechaInicialTemporada1;
		
	}

		
	/**
	 * Retorna propiedad <code>fechaInicialTemporada</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaInicialTemporada</code> como String
	 */
	public String getFechaInicialTemporadaS() {
		return (this.fechaInicialTemporada != null) ? ConverterUtil.getYMDDateFormat().format(this.fechaInicialTemporada) : null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaInicialTemporada</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaInicialTemporada</code>.
	 */
	public void setFechaInicialTemporadaS(String cadena) {
		try{
			this.fechaInicialTemporada = (cadena != null) ? ConverterUtil .getYMDDateFormat().parse(cadena) : null;
		}catch(Exception ex){Logeable.LOG_SICV2.error(ex.getMessage());}
	}	
			

	/**
	 * Retorna valor de propiedad <code>fechaFinalTemporada</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaFinalTemporada</code>
	 */
	public java.util.Date getFechaFinalTemporada(){
		return this.fechaFinalTemporada;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaFinalTemporada</code>.
	 * @param fechaFinalTemporada1 
	 *		El valor a establecer para la propiedad <code>fechaFinalTemporada</code>.
	 */
	public void setFechaFinalTemporada( java.util.Date fechaFinalTemporada1 ){
		this.fechaFinalTemporada=fechaFinalTemporada1;
		
	}

		
	/**
	 * Retorna propiedad <code>fechaFinalTemporada</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaFinalTemporada</code> como String
	 */
	public String getFechaFinalTemporadaS() {
		return (this.fechaFinalTemporada != null) ? ConverterUtil.getYMDDateFormat().format(this.fechaFinalTemporada) : null;
	}
	
	/**
	 * Permite establecer el valor de la propiedad <code>fechaFinalTemporada</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaFinalTemporada</code>.
	 */
	public void setFechaFinalTemporadaS(String cadena) {
		try{
			this.fechaFinalTemporada = (cadena != null) ? ConverterUtil.getYMDDateFormat().parse(cadena):null;
		}catch(Exception ex){Logeable.LOG_SICV2.error(ex.getMessage());}
	}

	public Collection<ArticuloTemporadaDTO> getArticuloTemporadaCol() {
		return articuloTemporadaCol;
	}

	public void setArticuloTemporadaCol(
			Collection<ArticuloTemporadaDTO> articuloTemporadaCol) {
		this.articuloTemporadaCol = articuloTemporadaCol;
	}	
			

}

