/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.PalletJackPesoID;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTPALJACPES")
public class PalletJackPesoDTO extends AuditoriaBaseDTO {
	/**
	 * Clave primaria de la tabla PalletJackPeso
	 *
	 */
	@EmbeddedId
	PalletJackPesoID id = new PalletJackPesoID();
	
	/**
	 * Peso del pallet jack
	 */
	@Column(name = "PESO")
	private BigDecimal peso;
	
	/**
	 * Fecha de ingreso del peso
	 */
	@Column(name = "FECHAINGRESO")
	private Date fechaIngreso;
	
	/**
	 * Consecutivo
	 */
	@Column(name = "CONSECUTIVO", columnDefinition="INTEGER DEFAULT 1")
	private Integer consecutivo;
	
	/**
	 * Bandera que indica si para el peso se tomo en cuenta el funcionario del pallet o no
	 */
	@Column(name = "TIENEFUNCIONARIO" , columnDefinition="CHAR(1) DEFAULT '1'")
	private Boolean tieneFuncionario;
	
	/**
	 * Estado del registro
	 */
	@Column(name = "ESTADO")
	private String estado ;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPALLETJACK", insertable=false, updatable=false, referencedColumnName="CODIGOPALLETJACK")})
	private PalletJackDTO palletJackDTO;
	
	/**
	 * 
	 * SETTERS & GETTERS
	 * 
	 */
	
	/**
	 * @return the id
	 */
	public PalletJackPesoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PalletJackPesoID id) {
		this.id = id;
	}

	/**
	 * @return the peso
	 */
	public BigDecimal getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	/**
	 * @return the fechaIngreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the consecutivo
	 */
	public Integer getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = (consecutivo != null)? consecutivo : 1;
	}

	/**
	 * @return the tieneFuncionario
	 */
	public Boolean getTieneFuncionario() {
		return tieneFuncionario;
	}

	/**
	 * @param tieneFuncionario the tieneFuncionario to set
	 */
	public void setTieneFuncionario(Boolean tieneFuncionario) {
		this.tieneFuncionario = tieneFuncionario ;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the palletJackDTO
	 */
	public PalletJackDTO getPalletJackDTO() {
		return palletJackDTO;
	}

	/**
	 * @param palletJackDTO the palletJackDTO to set
	 */
	public void setPalletJackDTO(PalletJackDTO palletJackDTO) {
		this.palletJackDTO = palletJackDTO;
	}
	
}
