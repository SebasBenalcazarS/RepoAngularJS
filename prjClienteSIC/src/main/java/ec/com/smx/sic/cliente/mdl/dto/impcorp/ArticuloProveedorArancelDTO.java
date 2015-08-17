/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.ArticuloProveedorArancelID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTARTPROARA")
public class ArticuloProveedorArancelDTO extends AuditoriaBaseDTO<ArticuloProveedorArancelID>{
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	@Column(name = "CODIGOARANCEL")
	private Long codigoArancel;
	
	/*@Column(name = "PORCENTAJE")
	private Double porcentaje;*/
	
	@Column(name = "FECHAINICIO")
	private Timestamp fechaInicio;
	
	@Column(name = "FECHAFIN")
	private Timestamp fechaFin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARANCEL", referencedColumnName = "CODIGOARANCEL", insertable = false, updatable = false)
	})
	private ArancelDTO arancel;
	
	/**
	 * @return devuelve el valor de la propiedad arancel
	 */
	public ArancelDTO getArancel() {
		return arancel;
	}

	/**
	 * @param arancel establece el valor a la propiedad arancel
	 */
	public void setArancel(ArancelDTO arancel) {
		this.arancel = arancel;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo establece el valor a la propiedad codigoArticulo
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor establece el valor a la propiedad codigoProveedor
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoArancel
	 */
	public Long getCodigoArancel() {
		return codigoArancel;
	}

	/**
	 * @param codigoArancel establece el valor a la propiedad codigoArancel
	 */
	public void setCodigoArancel(Long codigoArancel) {
		this.codigoArancel = codigoArancel;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio establece el valor a la propiedad fechaInicio
	 */
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin establece el valor a la propiedad fechaFin
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
}
