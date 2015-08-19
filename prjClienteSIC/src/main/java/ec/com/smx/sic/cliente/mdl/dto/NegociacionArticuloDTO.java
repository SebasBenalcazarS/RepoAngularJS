package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.mdl.dto.id.NegociacionArticuloID;
import ec.com.smx.sic.cliente.mdl.nopersistente.NegociacionArticuloTransient;


/**
 * Clase DTO que extiende de SimpleAuditDTO, representa la tabla SFCORTCUECON
 * del Schema DSMXSIC
 * 
 * @author cbarahona
 * 2014-09-10
*/
@Entity
@Table(name="SCCEMTNEGART")
public class NegociacionArticuloDTO extends NegociacionArticuloTransient implements Serializable{
	private static final long serialVersionUID = 7863262235394607247L;
	
	@EmbeddedId
	private NegociacionArticuloID id = new NegociacionArticuloID();
	
	/**
	 * Llave foranea del codigo de negociacion
	 */
	@Column(name="CODIGODETALLENEGOCIACION")
	private Long codigoDetalleNegociacion;
	
	/** Variable del tipo Long NegociacionArticuloDTO.java
	 * @author srodriguez
	 * 5/3/2015
	 */
	@Column(name="CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	
	@Column(name="CODIGOSUBBODEGA")
	private String codigoSubbodega;
	
	/**
	 * Llave foranea del codigo de articulo
	 */
	@Column(name="CODIGODEPARTAMENTO")
	private String codigoDepartamento;
	
	@Column(name="CODIGOCLASIFICACION")
	private String codigoClasificacion;
	
	@Column(name="CODIGOSUBCLASIFICACION")
	private String codigoSubClasificacion;
	
	
	@Column(name="CODIGOTIPOMARCA")
	private String codigoTipoMarca;
	
	@Column(name="CODIGOMARCA")
	private String codigoMarca;
	
	/**
	 * Llave foranea del codigo de articulo
	 */
	@Column(name="CODIGOARTICULO")
	private String codigoArticulo;
	
	/**
	 * valor del porcentaje de cobro
	 */
	@Column(name="PORCENTAJECOBRO")
	private Double porcentajeCobro;
	
	/**
	 * valor del porcentaje de descuento
	 */
	@Column(name="PORCENTAJEDESCUENTO")
	private Double porcentajeDescuento;
	
	/**
	 * valor del porcentaje de cobro
	 */
	@Column(name="COSTONETO")
	private BigDecimal costoNeto;
	
	/**
	 * Columna de prioridad de filtros de orden de compras
	 */
	@Column(name="PRIORIDAD")
	private Integer prioridad;
	
	/**
	 * valor del estado de registro
	 */
	@Column(name="ESTADO")
	private Boolean estado;
	
	/**
	 * Columna del usuario de registro
	 */
	@Column(name="IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	@Column(name="FECHAREGISTRO")
	private Date fechaRegistro;
	
	/**
	 * Columna del usuario de modificacion
	 */
	@Column(name="IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	
	/**
	 * valor tipo de marca: Propia
	 */
	@Transient
	private boolean marcaPropia;
	
	/**
	 * valor tipo marca: proveedor
	 */
	@Transient
	private boolean marcaProveedor;
	
	
	/**
	 * valor marca comercial
	 */
	@Transient
	private Long codigoMarcaComercial;
	
	/**
	 * valor nombre de la marca
	 */
	@Transient
	private String nombreMarca;
	
	/**
	 * Columna de la fecha de modificacion
	 */
	@Column(name="FECHAMODIFICACION")
	private Date fechaModificacion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGODETALLENEGOCIACION", referencedColumnName = "CODIGODETALLENEGOCIACION", insertable = false, updatable = false) })
	private DetalleNegociacionDTO detalleNegociacionDTO;
	/**
	 * Obtiene la relacion con el catalogo de articulo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOARTICULO", insertable = false, updatable = false, referencedColumnName = "CODIGOARTICULO") })
	private ArticuloDTO articuloDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOSUBBODEGA", insertable = false, updatable = false, referencedColumnName = "CODIGOBODEGA") })
	private BodegaDTO subBodegaDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGODEPARTAMENTO", insertable = false, updatable = false, referencedColumnName = "CODIGOCLASIFICACION") })
	private ClasificacionDTO departamentoDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOCLASIFICACION", insertable = false, updatable = false, referencedColumnName = "CODIGOCLASIFICACION") })
	private ClasificacionDTO clasificacionDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOCLASIFICACION", insertable = false, updatable = false, referencedColumnName = "CODIGOCLASIFICACION"),
		 @JoinColumn(name = "CODIGOSUBCLASIFICACION", insertable = false, updatable = false, referencedColumnName = "CODIGOSUBCLASIFICACION")})
	private SubClasificacionDTO subClasificacionDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor;
	
	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return NegociacionArticuloID id 
	 */
	public NegociacionArticuloID getId() {
		return id;
	}
	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param id parametro de tipo NegociacionArticuloID
	 */
	public void setId(NegociacionArticuloID id) {
		this.id = id;
	}
	
	
	
	public Long getCodigoDetalleNegociacion() {
		return codigoDetalleNegociacion;
	}
	public void setCodigoDetalleNegociacion(Long codigoDetalleNegociacion) {
		this.codigoDetalleNegociacion = codigoDetalleNegociacion;
	}
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	public String getCodigoSubClasificacion() {
		return codigoSubClasificacion;
	}
	public void setCodigoSubClasificacion(String codigoSubClasificacion) {
		this.codigoSubClasificacion = codigoSubClasificacion;
	}
	/* Metodo que retorna codigoArticulo del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return String codigoArticulo 
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/* Metodo que asigna el codigoArticulo del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoArticulo parametro de tipo String
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/* Metodo que retorna porcentajeCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return Double porcentajeCobro 
	 */
	public Double getPorcentajeCobro() {
		return porcentajeCobro;
	}
	/* Metodo que asigna el porcentajeCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param porcentajeCobro parametro de tipo Double
	 */
	public void setPorcentajeCobro(Double porcentajeCobro) {
		this.porcentajeCobro = porcentajeCobro;
	}
	
	/* Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return String idUsuarioRegistro 
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}
	/* Metodo que asigna el idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param idUsuarioRegistro parametro de tipo String
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}
	/* Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return Date fechaRegistro 
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/* Metodo que asigna el fechaRegistro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param fechaRegistro parametro de tipo Date
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/* Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return String idUsuarioModificacion 
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	/* Metodo que asigna el idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param idUsuarioModificacion parametro de tipo String
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	/* Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return Date fechaModificacion 
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/* Metodo que asigna el fechaModificacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param fechaModificacion parametro de tipo Date
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	public DetalleNegociacionDTO getDetalleNegociacionDTO() {
		return detalleNegociacionDTO;
	}
	public void setDetalleNegociacionDTO(DetalleNegociacionDTO detalleNegociacionDTO) {
		this.detalleNegociacionDTO = detalleNegociacionDTO;
	}
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}
	/* Metodo que asigna el articuloDTO del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param articuloDTO parametro de tipo ArticuloDTO
	 */
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}
	/* Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return Boolean estado 
	 */
	public Boolean getEstado() {
		return estado;
	}
	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param estado parametro de tipo Boolean
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public ClasificacionDTO getDepartamentoDTO() {
		return departamentoDTO;
	}
	public void setDepartamentoDTO(ClasificacionDTO departamentoDTO) {
		this.departamentoDTO = departamentoDTO;
	}
	public SubClasificacionDTO getSubClasificacionDTO() {
		return subClasificacionDTO;
	}
	public void setSubClasificacionDTO(SubClasificacionDTO subClasificacionDTO) {
		this.subClasificacionDTO = subClasificacionDTO;
	}
	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}
	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}
	/** Metodo que retorna codigoSubbodega del objeto
	 * @author srodriguez
	 * 5/3/2015
	 * @return Long codigoSubbodega 
	 */
	public String getCodigoSubbodega() {
		return codigoSubbodega;
	}
	/** Metodo que asigna el valor codigoSubbodega en codigoSubbodega del objeto
	 * @author srodriguez
	 * 5/3/2015
	 * @param codigoSubbodega
	 */
	
	public void setCodigoSubbodega(String codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}
	/** Metodo que retorna subBodegaDTO del objeto
	 * @author srodriguez
	 * 6/3/2015
	 * @return BodegaDTO subBodegaDTO 
	 */
	public BodegaDTO getSubBodegaDTO() {
		return subBodegaDTO;
	}
	/** Metodo que asigna el valor subBodegaDTO en subBodegaDTO del objeto
	 * @author srodriguez
	 * 6/3/2015
	 * @param subBodegaDTO
	 */
	
	public void setSubBodegaDTO(BodegaDTO subBodegaDTO) {
		this.subBodegaDTO = subBodegaDTO;
	}
	
	/**
	 * Asigna valor y retorna para MarcaPropia
	 * @author dbravo
	 * @return
	 */
	public boolean getMarcaPropia() {
		return marcaPropia;
	}
	public void setMarcaPropia(boolean marcaPropia) {
		this.marcaPropia = marcaPropia;
	}
	
	/**
	 * Asigna valor y retorna para MarcaProveedor
	 * @author dbravo
	 * @return
	 */
	public boolean getMarcaProveedor() {
		return marcaProveedor;
	}
	public void setMarcaProveedor(boolean marcaProveedor) {
		this.marcaProveedor = marcaProveedor;
	}
	
	
	/**
	 * Asignar valor y retorna para Marca Comercial
	 * @author dbravo
	 */
	public Long getCodigoMarcaComercial() {
		return codigoMarcaComercial;
	}
	/**
	 * @param codigoMarcaComercial the codigoMarcaComercial to set
	 */
	public void setCodigoMarcaComercial(Long codigoMarcaComercial) {
		this.codigoMarcaComercial = codigoMarcaComercial;
	}
	/** Metodo que retorna codigoProveedor del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @return String codigoProveedor 
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	/** Metodo que asigna el valor codigoProveedor en codigoProveedor del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @param codigoProveedor
	 */
	
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	/** Metodo que retorna codigoTipoMarca del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @return String codigoTipoMarca 
	 */
	public String[] getCodigoTipoMarca() {
		return StringUtils.split(codigoTipoMarca, ".") ;
	}
	/** Metodo que asigna el valor codigoTipoMarca en codigoTipoMarca del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @param codigoTipoMarca
	 */
	
	public void setCodigoTipoMarca(String[] codigoTipoMarca) {
		this.codigoTipoMarca = StringUtils.join(codigoTipoMarca, ".");
	}
	/** Metodo que retorna codigoMarca del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @return String codigoMarca 
	 */
	public String getCodigoMarca() {
		return codigoMarca;
	}
	/** Metodo que asigna el valor codigoMarca en codigoMarca del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @param codigoMarca
	 */
	
	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}
	public ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO getProveedor() {
		return proveedor;
	}
	public void setProveedor(ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}
	
	/**
	 * Obtener nombre marca
	 * @author dbravo
	 * @return the nombreMarca
	 */
	public String getNombreMarca() {
		return nombreMarca;
	}
	/**
	 * Asigna nombre de la marca
	 * @author dbravo
	 * @param nombreMarca the nombreMarca to set
	 */
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	/**
	 * @return the costoNeto
	 */
	public BigDecimal getCostoNeto() {
		return costoNeto;
	}
	/**
	 * @param costoNeto the costoNeto to set
	 */
	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}
	
	/**
	 * Obtiene la prioridad del articulo negociacion
	 * @author dbravo
	 * @return the prioridad
	 * 08/04/2015
	 */
	public Integer getPrioridad() {
		return prioridad;
	}
	/**
	 * Ingresa la prioridad del articulo negocio
	 * @author dbravo
	 * @param prioridad the prioridad to set
	 * 08/04/2015
	 */
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
}
