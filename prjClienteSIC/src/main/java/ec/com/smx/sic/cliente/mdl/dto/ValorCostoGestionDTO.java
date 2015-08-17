/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.annotation.Compare;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.BaseComparator;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoEjecucionGestionPrecio;
import ec.com.smx.sic.cliente.mdl.dto.id.ValorCostoGestionID;

/**
 * @author Victor Jaramillo
 *
 */
@Entity
@Table(name = "SCPRETVALCOSGES")
@SuppressWarnings("serial")
public class ValorCostoGestionDTO extends BaseComparator {

	@EmbeddedId
	private ValorCostoGestionID id  = new ValorCostoGestionID();

	@Column(name = "CODIGOGESTIONPRECIO" , nullable = false)
	private Long codigoGestionPrecio;

	@Compare
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAINICIO", nullable = false)	
	private Date fechaVigenciaInicio ;

	@Compare
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAFIN")	
	private Date fechaVigenciaFin ;

	@Compare
	@Column(name="COSTOBRUTO" , nullable = false)
	private Double costoBruto;

	@ComparatorTypeField
	@Column(name = "ESTADO" , nullable = false)
	private String estado;

	@Compare
	@ComparatorTypeField
	@Column(name = "VALORTIPOESTADO" , nullable = false)
	private String valorTipoEstado;

	@Column(name = "CODIGOTIPOESTADO" , nullable = false)
	private Integer codigoTipoEstado;

	@ComparatorTypeField
	@Column (name = "VALORESTADOEJECUCION", nullable = false)
	private String valorEstadoEjecucion;

	@Column (name = "CODIGOVALORESTADOEJECUCION", nullable = false)
	private Integer codigoEstadoEjecucion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOGESTIONPRECIO", referencedColumnName = "CODIGOGESTIONPRECIO", insertable = false, updatable = false)})
	private GestionPrecioDTO gestionPrecio;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOESTADO", referencedColumnName="CODIGOCATALOGOTIPO", insertable=false, updatable=false)})
	private CatalogoValorDTO tipoEstado;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORESTADOEJECUCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOVALORESTADOEJECUCION", referencedColumnName="CODIGOCATALOGOTIPO", insertable=false, updatable=false)})
	private CatalogoValorDTO tipoEstadoEjecucion;

	@OneToMany(mappedBy = "valorCostoGestion")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloProveedorGestionPrecioDTO> articulosProveedoresGestionPrecio;

	/**
	 * @return the id
	 */
	public ValorCostoGestionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ValorCostoGestionID id) {
		this.id = id;
	}

	/**
	 * @return the codigoGestionPrecio
	 */
	public Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}

	/**
	 * @param codigoGestionPrecio the codigoGestionPrecio to set
	 */
	public void setCodigoGestionPrecio(Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
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
	 * @return the costoBruto
	 */
	public Double getCostoBruto() {
		return costoBruto;
	}

	/**
	 * @param costoBruto the costoBruto to set
	 */
	public void setCostoBruto(Double costoBruto) {
		this.costoBruto = costoBruto;
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
	 * @return the valorTipoEstado
	 */
	public String getValorTipoEstado() {
		return valorTipoEstado;
	}

	/**
	 * @param valorTipoEstado the valorTipoEstado to set
	 */
	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	/**
	 * @return the codigoTipoEstado
	 */
	public Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	/**
	 * @param codigoTipoEstado the codigoTipoEstado to set
	 */
	public void setCodigoTipoEstado(Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	/**
	 * @return the gestionPrecio
	 */
	public GestionPrecioDTO getGestionPrecio() {
		return gestionPrecio;
	}

	/**
	 * @param gestionPrecio the gestionPrecio to set
	 */
	public void setGestionPrecio(GestionPrecioDTO gestionPrecio) {
		this.gestionPrecio = gestionPrecio;
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

	/**
	 * @return the articulosProveedoresGestionPrecio
	 */
	public Collection<ArticuloProveedorGestionPrecioDTO> getArticulosProveedoresGestionPrecio() {
		return articulosProveedoresGestionPrecio;
	}

	/**
	 * @param articulosProveedoresGestionPrecio the articulosProveedoresGestionPrecio to set
	 */
	public void setArticulosProveedoresGestionPrecio(Collection<ArticuloProveedorGestionPrecioDTO> articulosProveedoresGestionPrecio) {
		this.articulosProveedoresGestionPrecio = articulosProveedoresGestionPrecio;
	}

	/**
	 * @return the valorEstadoEjecucion
	 */
	public String getValorEstadoEjecucion() {
		return valorEstadoEjecucion;
	}

	/**
	 * @param valorEstadoEjecucion the valorEstadoEjecucion to set
	 */
	public void setValorEstadoEjecucion(String valorEstadoEjecucion) {
		this.valorEstadoEjecucion = valorEstadoEjecucion;
	}
	
	/**
	 * @return the valorEstadoEjecucionCostoEtiqueta
	 */
	public String getValorEstadoEjecucionCostoEtiqueta() {
		if(EstadoEjecucionGestionPrecio.PENDIENTE.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucion)){
			valorEstadoEjecucion = EstadoEjecucionGestionPrecio.PENDIENTE.getLabelEstadoEjecucionGestionPrecio(); 
		}else if (EstadoEjecucionGestionPrecio.PROCESADO.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucion)) {
			valorEstadoEjecucion = EstadoEjecucionGestionPrecio.PROCESADO.getLabelEstadoEjecucionGestionPrecio();
		}else if (EstadoEjecucionGestionPrecio.FINALIZADO.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucion)) {
			valorEstadoEjecucion = EstadoEjecucionGestionPrecio.FINALIZADO.getLabelEstadoEjecucionGestionPrecio();
		}
		return valorEstadoEjecucion;
	}

	/**
	 * @return the codigoEstadoEjecucion
	 */
	public Integer getCodigoEstadoEjecucion() {
		return codigoEstadoEjecucion;
	}

	/**
	 * @param codigoEstadoEjecucion the codigoEstadoEjecucion to set
	 */
	public void setCodigoEstadoEjecucion(Integer codigoEstadoEjecucion) {
		this.codigoEstadoEjecucion = codigoEstadoEjecucion;
	}

	/**
	 * @return the tipoEstadoEjecucion
	 */
	public CatalogoValorDTO getTipoEstadoEjecucion() {
		return tipoEstadoEjecucion;
	}

	/**
	 * @param tipoEstadoEjecucion the tipoEstadoEjecucion to set
	 */
	public void setTipoEstadoEjecucion(CatalogoValorDTO tipoEstadoEjecucion) {
		this.tipoEstadoEjecucion = tipoEstadoEjecucion;
	}

}
