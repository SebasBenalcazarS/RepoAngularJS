
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.CuotaID;

/**
 * Almacena las cuotas para los pagos diferidos que se pueden realizar para un articulo
 *
 * @author xmino
 */
@Entity
@Table(name="SCSADTCUOTA")
public class CuotaDTO  extends SimpleAuditDTO{

    /**
     * UID Generado 
     */
    private static final long serialVersionUID = -8852156890229340329L;

    /**
     * Identificador del objeto.
     */
    @EmbeddedId
    private CuotaID id;

	@Column(name="NOMBRE")
	private String name;
	@Column(name="DESCRIPCION")
	private String description;
	@Column(name="ESTADO")
	private String status;
    /**
     * Numero de cuotas a la que se dividira el precio de venta al publico
     */
    private Integer numeroCuotas ;

    /**
     * En caso de tener interes es el factor del interes a la cuota
     */
    private Double valorInteres ;
	@RegisterUserIdField
	private String usuarioRegistro;
	@LastModifierUserIdField
	private String usuarioModificacion;
	@RegisterDateField
	private Timestamp fechaRegistro;
	@LastModificationDateField
	private Timestamp fechaModificacion;	
	
    public CuotaDTO(){
    	this.id = new CuotaID();
    }


    /**
     * Retorna valor de propiedad <code>id</code>
     * @return 
     */
    public CuotaID getId(){
	return this.id;
    }

    /**
     * Establece un nuevo valor para la propiedad <code>id</code>.
     * @param id1 
     */
    public void setId( CuotaID id1 ){
	this.id=id1;
    }

    /**
     * Retorna valor de propiedad <code>numeroCuotas</code>
     * @return 
     * 		Retorna valor de propiedad <code>numeroCuotas</code>
     */
    public Integer getNumeroCuotas(){
	return this.numeroCuotas;
    }

    /**
     * Establece un nuevo valor para la propiedad <code>numeroCuotas</code>.
     * @param numeroCuotas1 
     *		El valor a establecer para la propiedad <code>numeroCuotas</code>.
     */
    public void setNumeroCuotas( Integer numeroCuotas1 ){
	this.numeroCuotas=numeroCuotas1;

    }


    /**
     * Retorna valor de propiedad <code>factorInteres</code>
     * @return 
     */
    public Double getValorInteres(){
	return this.valorInteres;
    }

    /**
     * Establece un nuevo valor para la propiedad <code>valorInteres</code>.
     * @param factorInteres1 
     */
    public void setValorInteres( Double valorInteres1 ){
	this.valorInteres=valorInteres1;

    }


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @return the usuarioRegistro
	 */
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}


	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
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
	 * @return the fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}


	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

}

