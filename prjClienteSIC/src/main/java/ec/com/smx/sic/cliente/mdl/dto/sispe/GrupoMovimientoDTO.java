
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.sispe.GrupoMovimientoID;


/**
 * Entidad que se utilizara para identificar el tipo de motivo movimiento Ejm: perecibles
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.GrupoMovimientoDTO")
@Table(name = "SCSPETGRUMOV")
public class GrupoMovimientoDTO extends AuditoriaBaseDTO<GrupoMovimientoID> {



	/**
	 * nombreMovimiento
	 *

	 */
	@Column(name = "NOMBREMOVIMIENTO")
	private String nombreMovimiento ;

	

	/**
	 * descripcionMovimiento
	 *

	 */
	@Column(name = "DESCRIPCIONMOVIMIENTO")
	private String descripcionMovimiento ;

	

	/**
	 * estado, valores: 1(Activo), 0(Inactivo)
	 *

	 */
	@Column(name = "ESTADO")
	private String estado ;

	

	/**
	 * Retorna valor de propiedad <code>nombreMovimiento</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>nombreMovimiento</code>
	 */
	public String getNombreMovimiento(){
		return this.nombreMovimiento;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombreMovimiento</code>.
	 * @param nombreMovimiento1 
	 *		El valor a establecer para la propiedad <code>nombreMovimiento</code>.
	 */
	public void setNombreMovimiento( String nombreMovimiento1 ){
		this.nombreMovimiento=nombreMovimiento1;
		
		if(nombreMovimiento!=null && nombreMovimiento.length()>128){
			nombreMovimiento = nombreMovimiento.substring(0,128);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>descripcionMovimiento</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>descripcionMovimiento</code>
	 */
	public String getDescripcionMovimiento(){
		return this.descripcionMovimiento;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcionMovimiento</code>.
	 * @param descripcionMovimiento1 
	 *		El valor a establecer para la propiedad <code>descripcionMovimiento</code>.
	 */
	public void setDescripcionMovimiento( String descripcionMovimiento1 ){
		this.descripcionMovimiento=descripcionMovimiento1;
		
		if(descripcionMovimiento!=null && descripcionMovimiento.length()>256){
			descripcionMovimiento = descripcionMovimiento.substring(0,256);
		}
				
	}

		

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado(){
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * @param estado1 
	 *		El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado( String estado1 ){
		this.estado=estado1;
		
		if(estado!=null && estado.length()>1){
			estado = estado.substring(0,1);
		}
				
				
	}

}

