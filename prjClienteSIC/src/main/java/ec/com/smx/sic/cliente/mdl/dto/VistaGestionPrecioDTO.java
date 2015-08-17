package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import ec.com.smx.sic.cliente.mdl.nopersistente.GestionPrecioTransient;

@Entity
@Table(name="SCPRETGESPRE")
@SuppressWarnings("serial")
public class VistaGestionPrecioDTO extends GestionPrecioTransient{

    
    @Formula("(select case when count(*) > 0 then 1 else 0 end " +
    		"from SCCEMTCONPAR cp" +
    		" where cp.CODIGOCOMPANIA = gestionpre1_.CODIGOCOMPANIA AND cp.CODIGOGESTIONPRECIO = gestionpre1_.CODIGOGESTIONPRECIORELACIONADO AND cp.ESTADO = '1')")
    private Boolean tieneParticipantes;

	/* Metodo que retorna tieneParticipantes del objeto
	 * @author srodriguez
	 * 15/10/2014
	 * @return Boolean tieneParticipantes 
	 */
	public Boolean getTieneParticipantes() {
		return tieneParticipantes;
	}

	/* Metodo que asigna el tieneParticipantes del objeto
	 * @author srodriguez
	 * 15/10/2014
	 * @param tieneParticipantes parametro de tipo Boolean
	 */
	public void setTieneParticipantes(Boolean tieneParticipantes) {
		this.tieneParticipantes = tieneParticipantes;
	}
    
    
}
