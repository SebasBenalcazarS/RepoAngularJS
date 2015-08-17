/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraArticuloGestionPrecioID;

/**
 * @author Luis Yacchirema
 * 
 * @author Victor Jaramillo
 *
 */
@Entity
@Table( name = "SCPRETBITARTGESPRE")
@SuppressWarnings("serial")
public class BitacoraArticuloGestionPrecioDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private BitacoraArticuloGestionPrecioID id  = new BitacoraArticuloGestionPrecioID();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAINICIO", nullable = false)
	private Date fechaVigenciaInicio ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAFIN")
	private Date fechaVigenciaFin ;
	
	@Column(name = "PRECIOPVP", nullable = false)
	private Double precioPVP;
	
	@Column(name = "PRECIOSMX", nullable = false)
	private Double precioSMX;
	
	@Column(name = "PRECIOSMXNOAFILIADO", nullable = false)
	private Double precioSMXNoAfiliado;
	
	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name = "CODIGOGESTIONPRECIO" , referencedColumnName="CODIGOGESTIONPRECIO", insertable = false, updatable = false),
	    @JoinColumn(name = "CODIGOARTICULO" , referencedColumnName="CODIGOARTICULO", insertable = false, updatable = false)})
	private ArticuloGestionPrecioDTO articuloGestionPrecio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTADO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOESTADO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable=false, updatable = false)})
	private CatalogoValorDTO tipoEstado;

	/**
	 * @return the id
	 */
	public BitacoraArticuloGestionPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BitacoraArticuloGestionPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the fechaVigenciaInicio
	 */
	public Date getFechaVigenciaInicio() {
		return fechaVigenciaInicio;
	}

	/**
	 * @param fechaVigenciaInicio the fechaVigenciaInicio to set
	 */
	public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}

	/**
	 * @return the fechaVigenciaFin
	 */
	public Date getFechaVigenciaFin() {
		return fechaVigenciaFin;
	}

	/**
	 * @param fechaVigenciaFin the fechaVigenciaFin to set
	 */
	public void setFechaVigenciaFin(Date fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}

	/**
	 * @return the precioPVP
	 */
	public Double getPrecioPVP() {
		return precioPVP;
	}

	/**
	 * @param precioPVP the precioPVP to set
	 */
	public void setPrecioPVP(Double precioPVP) {
		this.precioPVP = precioPVP;
	}

	/**
	 * @return the precioSMX
	 */
	public Double getPrecioSMX() {
		return precioSMX;
	}

	/**
	 * @param precioSMX the precioSMX to set
	 */
	public void setPrecioSMX(Double precioSMX) {
		this.precioSMX = precioSMX;
	}

	/**
	 * @return the precioSMXNoAfiliado
	 */
	public Double getPrecioSMXNoAfiliado() {
		return precioSMXNoAfiliado;
	}

	/**
	 * @param precioSMXNoAfiliado the precioSMXNoAfiliado to set
	 */
	public void setPrecioSMXNoAfiliado(Double precioSMXNoAfiliado) {
		this.precioSMXNoAfiliado = precioSMXNoAfiliado;
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
	 * @return the articuloGestionPrecio
	 */
	public ArticuloGestionPrecioDTO getArticuloGestionPrecio() {
		return articuloGestionPrecio;
	}

	/**
	 * @param articuloGestionPrecio the articuloGestionPrecio to set
	 */
	public void setArticuloGestionPrecio(ArticuloGestionPrecioDTO articuloGestionPrecio) {
		this.articuloGestionPrecio = articuloGestionPrecio;
	}

	/**
	 * @return the tipoEstado
	 */
	public CatalogoValorDTO getTipoEstado() {
		return tipoEstado;
	}

	/**
	 * @param tipoEstado the tipoEstado to set
	 */
	public void setTipoEstado(CatalogoValorDTO tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

}
