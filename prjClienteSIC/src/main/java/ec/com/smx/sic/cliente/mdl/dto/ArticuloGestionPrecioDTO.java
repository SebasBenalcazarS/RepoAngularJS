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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.annotation.Compare;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoEjecucionGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloGestionPrecioID;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloGestionPrecioTransient;

/**
 * @author Luis Yacchirema
 *  
 * @author Victor Jaramillo
 *
 */
@Entity
@Table(name="SCPRETARTGESPRE")
@SuppressWarnings("serial")
public class ArticuloGestionPrecioDTO extends ArticuloGestionPrecioTransient {

	@EmbeddedId
	private ArticuloGestionPrecioID id = new ArticuloGestionPrecioID();

	@Compare
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAINICIO", nullable = false)	
	private Date fechaVigenciaInicio ;

	@Compare
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAFIN")	
	private Date fechaVigenciaFin ;

	@Column( name = "PRECIOPVPANTERIOR", nullable = false)
	private Double precioPVPAnterior;

	@Compare
	@Column( name = "PRECIOPVPNUEVO", nullable = false )	
	private Double precioPVPNuevo;

	@Column(name = "PRECIOSMXANTERIOR", nullable = false)
	private Double precioSMXAnterior;

	@Compare
	@Column ( name = "PRECIOSMXNUEVO", nullable = false)	
	private Double precioSMXNuevo;

	@Compare
	@Column (name = "OBSERVACION")
	private String observacion;

	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;

	@Compare
	@ComparatorTypeField
	@Column (name = "VALORTIPOESTADO", nullable = false)
	private String valorTipoEstado;

	@Column (name = "CODIGOTIPOESTADO", nullable = false)
	private Integer codigoTipoEstado;

	@ComparatorTypeField
	@Column (name = "VALORESTADOEJECUCION", nullable = false)
	private String valorEstadoEjecucion;

	@Column (name = "CODIGOVALORESTADOEJECUCION", nullable = false)
	private Integer codigoEstadoEjecucion;

	@ComparatorTypeField
	@Column (name = "VALORTIPOARTICULO", nullable = false)
	private String valorTipoArticulo;

	@Column (name = "CODIGOTIPOARTICULO", nullable = false)
	private Integer codigoTipoArticulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOGESTIONPRECIO", referencedColumnName="CODIGOGESTIONPRECIO", insertable=false, updatable=false)})
	private GestionPrecioDTO gestionPrecio;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOESTADO", referencedColumnName="CODIGOCATALOGOTIPO", insertable=false, updatable=false)})
	private CatalogoValorDTO tipoEstado;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORESTADOEJECUCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOVALORESTADOEJECUCION", referencedColumnName="CODIGOCATALOGOTIPO", insertable=false, updatable=false)})
	private CatalogoValorDTO tipoEstadoEjecucion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOARTICULO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOARTICULO", referencedColumnName="CODIGOCATALOGOTIPO", insertable=false, updatable=false)})
	private CatalogoValorDTO tipoArticulo;

	@OneToMany(mappedBy="articuloGestionPrecio")
	@CollectionTypeInfo(name=SICConstantes.USERTYPE_COLLECTION)
	private Collection<PrecioDiferenciadoArticuloGestionDTO> preciosDiferenciadosArticuloGestion;

	@OneToMany(mappedBy = "articuloGestionPrecio")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloProveedorGestionPrecioDTO> articulosProveedoresGestionPrecio;


	/**
	 * @return the id
	 */
	public ArticuloGestionPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloGestionPrecioID id) {
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
	 * @return the precioPVPAnterior
	 */
	public Double getPrecioPVPAnterior() {
		return precioPVPAnterior;
	}

	/**
	 * @param precioPVPAnterior the precioPVPAnterior to set
	 */
	public void setPrecioPVPAnterior(Double precioPVPAnterior) {
		this.precioPVPAnterior = precioPVPAnterior;
	}

	/**
	 * @return the precioPVPNuevo
	 */
	public Double getPrecioPVPNuevo() {
		return precioPVPNuevo;
	}

	/**
	 * @param precioPVPNuevo the precioPVPNuevo to set
	 */
	public void setPrecioPVPNuevo(Double precioPVPNuevo) {
		this.precioPVPNuevo = precioPVPNuevo;
	}

	/**
	 * @return the precioSMXAnterior
	 */
	public Double getPrecioSMXAnterior() {
		return precioSMXAnterior;
	}

	/**
	 * @param precioSMXAnterior the precioSMXAnterior to set
	 */
	public void setPrecioSMXAnterior(Double precioSMXAnterior) {
		this.precioSMXAnterior = precioSMXAnterior;
	}

	/**
	 * @return the precioSMXNuevo
	 */
	public Double getPrecioSMXNuevo() {
		return precioSMXNuevo;
	}

	/**
	 * @param precioSMXNuevo the precioSMXNuevo to set
	 */
	public void setPrecioSMXNuevo(Double precioSMXNuevo) {
		this.precioSMXNuevo = precioSMXNuevo;
	}

	/**
	 * @return the precioSMXNoAfiliadoAnterior
	 */
	public Double getPrecioSMXNoAfiliadoAnterior() {

		if (super.precioSMXNoAfiliadoAnterior == null && SearchDTO.isLoaded(this.articulo)) {
			super.precioSMXNoAfiliadoAnterior = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularPrecioBaseNoAfiliado(this.precioSMXAnterior,
					articulo.getArticuloComercialDTO());
		}

		return super.precioSMXNoAfiliadoAnterior;
	}

	/**
	 * @param precioSMXNoAfiliadoAnterior the precioSMXNoAfiliadoAnterior to set
	 */
	public void setPrecioSMXNoAfiliadoAnterior(Double precioSMXNoAfiliadoAnterior) {
		this.precioSMXNoAfiliadoAnterior = precioSMXNoAfiliadoAnterior;
	}

	/**
	 * @return the precioSMXNoAfiliadoNuevo
	 */
	public Double getPrecioSMXNoAfiliadoNuevo() {

		if (super.precioSMXNoAfiliadoNuevo == null && SearchDTO.isLoaded(this.articulo)) {
			super.precioSMXNoAfiliadoNuevo = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularPrecioBaseNoAfiliado(this.precioSMXNuevo,
					articulo.getArticuloComercialDTO());
		}

		return super.precioSMXNoAfiliadoNuevo;
	}

	/**
	 * @param precioSMXNoAfiliadoNuevo the precioSMXNoAfiliadoNuevo to set
	 */
	public void setPrecioSMXNoAfiliadoNuevo(Double precioSMXNoAfiliadoNuevo) {
		super.precioSMXNoAfiliadoNuevo = precioSMXNoAfiliadoNuevo;
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
	 * @return the valorTipoEstadoEtiqueta
	 */
	public String getValorTipoEstadoEtiqueta() {

		if(EstadoGestionPrecio.PENDIENTE.getValorEstadoGestionPrecio().equals(valorTipoEstado)){
			super.valorTipoEstadoEtiqueta = EstadoGestionPrecio.PENDIENTE.getLabelEstadoGestionPrecio(); 
		}else if (EstadoGestionPrecio.CONFIRMADO.getValorEstadoGestionPrecio().equals(valorTipoEstado)) {
			super.valorTipoEstadoEtiqueta = EstadoGestionPrecio.CONFIRMADO.getLabelEstadoGestionPrecio();;
		}else if (EstadoGestionPrecio.AUTORIZADO.getValorEstadoGestionPrecio().equals(valorTipoEstado)) {
			super.valorTipoEstadoEtiqueta = EstadoGestionPrecio.AUTORIZADO.getLabelEstadoGestionPrecio();;
		}else if (EstadoGestionPrecio.DESAUTORIZADO.getValorEstadoGestionPrecio().equals(valorTipoEstado)) {
			super.valorTipoEstadoEtiqueta = EstadoGestionPrecio.DESAUTORIZADO.getLabelEstadoGestionPrecio();;
		}

		return super.valorTipoEstadoEtiqueta;
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
	 * @return the articulo
	 */
	public ArticuloDTO getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
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
	 * @return the preciosDiferenciadosArticuloGestion
	 */
	public Collection<PrecioDiferenciadoArticuloGestionDTO> getPreciosDiferenciadosArticuloGestion() {
		return preciosDiferenciadosArticuloGestion;
	}

	/**
	 * @param preciosDiferenciadosArticuloGestion the preciosDiferenciadosArticuloGestion to set
	 */
	public void setPreciosDiferenciadosArticuloGestion(Collection<PrecioDiferenciadoArticuloGestionDTO> preciosDiferenciadosArticuloGestion) {
		this.preciosDiferenciadosArticuloGestion = preciosDiferenciadosArticuloGestion;
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
	 * @return the articuloProveedorBaseGestionPrecio
	 */
	public ArticuloProveedorGestionPrecioDTO getArticuloProveedorBaseGestionPrecio() {

		if (super.articuloProveedorBaseGestionPrecio == null && SearchDTO.isLoaded(this.articulosProveedoresGestionPrecio)) {
			super.articuloProveedorBaseGestionPrecio = (ArticuloProveedorGestionPrecioDTO) CollectionUtils.find(this.articulosProveedoresGestionPrecio,
					PredicateUtils.transformedPredicate(new GetInvokerTransformer("esProveedorBase"), PredicateUtils.equalPredicate(Boolean.TRUE)));
		}

		return super.articuloProveedorBaseGestionPrecio;
	}

	/**
	 * @param articuloProveedorBaseGestionPrecio the articuloProveedorBaseGestionPrecio to set
	 */
	public void setArticuloProveedorBaseGestionPrecio(ArticuloProveedorGestionPrecioDTO articuloProveedorBaseGestionPrecio) {
		super.articuloProveedorBaseGestionPrecio = articuloProveedorBaseGestionPrecio;
	}

	/**
	 * @return the articuloProveedoresGestionPrecioRelacionados
	 */
	@SuppressWarnings("unchecked")
	public Collection<ArticuloProveedorGestionPrecioDTO> getArticuloProveedoresGestionPrecioRelacionados() {

		if (CollectionUtils.isEmpty(super.articuloProveedoresGestionPrecioRelacionados) 
				&& SearchDTO.isLoaded(this.articulosProveedoresGestionPrecio) && this.articulosProveedoresGestionPrecio.size() > 1) {

			super.articuloProveedoresGestionPrecioRelacionados = (Collection<ArticuloProveedorGestionPrecioDTO>) CollectionUtils.select(this.articulosProveedoresGestionPrecio,
					PredicateUtils.transformedPredicate(new GetInvokerTransformer("esProveedorBase"), PredicateUtils.equalPredicate(Boolean.FALSE)));
		}

		return super.articuloProveedoresGestionPrecioRelacionados;
	}

	/**
	 * @param articuloProveedoresGestionPrecioRelacionados the articuloProveedoresGestionPrecioRelacionados to set
	 */
	public void setArticuloProveedoresGestionPrecioRelacionados(Collection<ArticuloProveedorGestionPrecioDTO> articuloProveedoresGestionPrecioRelacionados) {
		super.articuloProveedoresGestionPrecioRelacionados = articuloProveedoresGestionPrecioRelacionados;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	 * @return the valorEstadoEjecucionVentaEtiqueta
	 */
	public String getValorEstadoEjecucionVentaEtiqueta() {
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
	 * @return the estadoEjecucion
	 */
	public CatalogoValorDTO getTipoEstadoEjecucion() {
		return tipoEstadoEjecucion;
	}

	/**
	 * @param estadoEjecucion the estadoEjecucion to set
	 */
	public void setTipoEstadoEjecucion(CatalogoValorDTO tipoEstadoEjecucion) {
		this.tipoEstadoEjecucion = tipoEstadoEjecucion;
	}

	public Double getPvpAnteriorVsPsmxAnterior() {
		if (super.pvpAnteriorVsPsmxAnterior == null) {
			super.pvpAnteriorVsPsmxAnterior = SICArticuloCalculo.getInstancia().calcularPvpVsPsmx(this.getPrecioPVPAnterior(), this.getPrecioSMXAnterior());
		}
		return super.pvpAnteriorVsPsmxAnterior;
	}

	public void setPvpAnteriorVsPsmxAnterior(Double pvpAnteriorVsPsmxAnterior){
		super.pvpAnteriorVsPsmxAnterior = pvpAnteriorVsPsmxAnterior;
	}
	
	public Double getPvpNuevoVsPsmxNuevo() {
		if (super.pvpNuevoVsPsmxNuevo == null) {
			super.pvpNuevoVsPsmxNuevo = SICArticuloCalculo.getInstancia().calcularPvpVsPsmx(this.getPrecioPVPNuevo(), this.getPrecioSMXNuevo());
		}
		return super.pvpNuevoVsPsmxNuevo;
	}
	
	public void setPvpNuevoVsPsmxNuevo(Double pvpNuevoVsPsmxNuevo){
		super.pvpNuevoVsPsmxNuevo = pvpNuevoVsPsmxNuevo;
	}
	
	public Double getVariacionVenta() {
		if (super.variacionVenta == null) {
			super.variacionVenta = SICArticuloCalculo.getInstancia().calcularVariacionVenta(this.getPrecioPVPNuevo(), this.getPrecioPVPAnterior());
		}
		return super.variacionVenta;
	}

	public void setVariacionVenta(Double variacionVenta) {
		super.variacionVenta = variacionVenta;
	}
	
	public Double getPorcentajeVariacionVenta() {
		if (super.porcentajeVariacionVenta == null) {
			super.porcentajeVariacionVenta = SICArticuloCalculo.getInstancia().calcularPorcentajeVariacionVenta(this.getVariacionVenta(), this.getPrecioSMXAnterior());
		}
		return super.porcentajeVariacionVenta;
	}
	
	public void setPorcentajeVariacionVenta(Double porcentajeVariacionVenta) {
		this.porcentajeVariacionVenta = porcentajeVariacionVenta;
	}

	/**
	 * @return the valorTipoArticulo
	 */
	public String getValorTipoArticulo() {
		return valorTipoArticulo;
	}

	/**
	 * @param valorTipoArticulo the valorTipoArticulo to set
	 */
	public void setValorTipoArticulo(String valorTipoArticulo) {
		this.valorTipoArticulo = valorTipoArticulo;
	}

	/**
	 * @return the codigoTipoArticulo
	 */
	public Integer getCodigoTipoArticulo() {
		return codigoTipoArticulo;
	}

	/**
	 * @param codigoTipoArticulo the codigoTipoArticulo to set
	 */
	public void setCodigoTipoArticulo(Integer codigoTipoArticulo) {
		this.codigoTipoArticulo = codigoTipoArticulo;
	}

	/**
	 * @return the tipoArticulo
	 */
	public CatalogoValorDTO getTipoArticulo() {
		return tipoArticulo;
	}

	/**
	 * @param tipoArticulo the tipoArticulo to set
	 */
	public void setTipoArticulo(CatalogoValorDTO tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

}
