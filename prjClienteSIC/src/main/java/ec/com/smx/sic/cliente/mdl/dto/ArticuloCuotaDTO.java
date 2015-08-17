
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloCuotaID;


/**
 * Almacena las cuotas a la que un articulo tiene acceso
 *
 * @author xmino,fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTICULOCUOTA")
public class ArticuloCuotaDTO extends SimpleAuditDTO{

	/**
	 * Identificador del objeto.
	 */
	@EmbeddedId
	private ArticuloCuotaID id;
	@Column(name = "ESTADO")
	private String status;
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String registerUserId;
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String lastModifierUserId;
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	private Timestamp registerDate;
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	private Timestamp lastModificationDate;
	
	public ArticuloCuotaDTO(){
		this.id = new ArticuloCuotaID();
	}
	
	/**
	 * Valor no persistente para el calculo de la cuota del articulo
	 */
	@Transient
	private Double npValorCuota;

	/**
	 * Especifica la cuota aplicable al articulo
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="secuencialcuota", referencedColumnName="secuencialcuota", insertable=false, updatable=false)})
	private CuotaDTO cuota;

	/**
	 * Especifica el articulo seleccionado
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;


	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 */
	public ArticuloCuotaID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 */
	public void setId( ArticuloCuotaID id1 ){
		this.id=id1;
	}

	/**
	 * Retorna valor de propiedad <code>cuota</code>
	 * @return 
	 */
	public CuotaDTO getCuota(){
		return this.cuota;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cuota</code>.
	 * @param cuota1 
	 */
	public void setCuota(CuotaDTO cuota1 ){
		this.cuota=cuota1;
	}

	/**
	 * Retorna valor de propiedad <code>articulo</code>
	 * @return 
	 */
	public ArticuloDTO getArticulo(){
		return this.articulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articulo</code>.
	 * @param articulo1 
	 */
	public void setArticulo( ArticuloDTO articulo1 ){
		this.articulo=articulo1;
	}

	public Double getNpValorCuota() {
		return npValorCuota;
	}

	public void setNpValorCuota(Double npValorCuota) {
		this.npValorCuota = npValorCuota;
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
	 * @return the registerUserId
	 */
	public String getRegisterUserId() {
		return registerUserId;
	}

	/**
	 * @param registerUserId the registerUserId to set
	 */
	public void setRegisterUserId(String registerUserId) {
		this.registerUserId = registerUserId;
	}

	/**
	 * @return the lastModifierUserId
	 */
	public String getLastModifierUserId() {
		return lastModifierUserId;
	}

	/**
	 * @param lastModifierUserId the lastModifierUserId to set
	 */
	public void setLastModifierUserId(String lastModifierUserId) {
		this.lastModifierUserId = lastModifierUserId;
	}

	/**
	 * @return the registerDate
	 */
	public Timestamp getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the lastModificationDate
	 */
	public Timestamp getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Timestamp lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}


}

