package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.convenio.ConveniosConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.DatosAcumuladosID;

/**
 * Clase DTO que extiende, representa la tabla SCCEMTDATACU
 * del Schema DSMXSIC
 * 
 * @author srodriguez
 * 2014-11-21
*/

@Entity
@Table(name = "SCCEMTDATACU")
public class DatosAcumuladosDTO {
	
	/**
	 * Clave primaria de la tabla DatosAcumuladosDTO
	 * 
	 */
	@EmbeddedId
	private DatosAcumuladosID id = new DatosAcumuladosID();
	
	/**
	 * Llave foranea del codigo campania
	 */
	@Column(name = "CODIGOCAMPANIA")
	private Long codigoCampania;
	
	/**
	 * Llave foranea del codigo promocion
	 */
	@Column(name = "CODIGOPROMOCION")
	private Long codigoPromocion;
	
	/**
	 * Llave foranea del codigo articulo
	 */
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	/**
	 * Llave foranea del codigo articulo
	 */
	@Column(name = "CODIGOLOCAL")
	private String codigoLocal;
	
	
	/** Variable del tipo Long DatosAcumuladosDTO.java
	 * @author srodriguez
	 * 16/3/2015
	 */
	@Column(name = "CODIGOCAMPANIALOYALTY")
	private Long codigoCampaniaLoyalty;
	
	/** Variable del tipo Long DatosAcumuladosDTO.java
	 * @author srodriguez
	 * 16/3/2015
	 */
	@Column(name = "CODIGOPROMOCIONLOYALTY")
	private Long codigoPromocionLoyalty;
	
	
	/** Variable del tipo String DatosAcumuladosDTO.java
	 * @author srodriguez
	 * 16/3/2015
	 */
	@Column(name = "CODIGOARTICULOLOYALTY")
	private String codigoArticuloLoyalty;
	
	/** Variable del tipo String DatosAcumuladosDTO.java
	 * @author srodriguez
	 * 16/3/2015
	 */
	@Column(name = "CODIGOLOCALLOYALTY")
	private String codigoLocalLoyalty;
	
	/**
	 * Cantidad monetaria del procesamiento
	 */
	@Column(name = "CANTIDAD")
	private BigDecimal cantidad;
	
	/**
	 * Valor acumulado de las ventas
	 */
	@Column(name = "VALORACUMULADO")
	private BigDecimal valorAcumulado;

	/**
	 * precio de venta
	 */
	@Column(name = "PRECIO")
	private BigDecimal precio;
	
	
	/**
	 * tipo de descuento
	 */
	@Column(name = "TIPO")
	private String tipo;
	
	/**
	 * Cantidad total de productos
	 */
	@Column(name = "TOTALPRD")
	private BigDecimal totalProductos;
	/**
	 * Estado del registro
	 * 
	 */
	@Column(name = "ESTADO")
	private String estado;
	
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name = "IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name = "FECHAREGISTRO")
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@Column(name = "IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;
	
	@OneToMany(mappedBy = "datosAcumuladosDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ConfiguracionDatosProcesadosAcumuladosDTO> configuracionDatosProcesadosAcumuladosCol;
	
	
	/**
	 * Obtiene la relacion con la tabla GestionPrecioDTO 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOCAMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOGESTIONPRECIO") })
	private GestionPrecioDTO campaniaDTO;
	
	/**
	 * Obtiene la relacion con la tabla GestionPrecioDTO 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOPROMOCION", insertable = false, updatable = false, referencedColumnName = "CODIGOGESTIONPRECIO") })
	private GestionPrecioDTO promocionDTO;
	
	
	/**
	 * Obtiene la relacion con la tabla de articulo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOARTICULO", insertable = false, updatable = false, referencedColumnName = "CODIGOARTICULO") })
	private ArticuloDTO articuloDTO;
	

	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return DatosAcumuladosID id 
	 */
	public DatosAcumuladosID getId() {
		return id;
	}

	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param id parametro de tipo DatosAcumuladosID
	 */
	public void setId(DatosAcumuladosID id) {
		this.id = id;
	}

	/* Metodo que retorna codigoCampania del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Long codigoCampania 
	 */
	public Long getCodigoCampania() {
		return codigoCampania;
	}

	/** Metodo que asigna el codigoCampania del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoCampania parametro de tipo Long
	 */
	public void setCodigoCampania(Long codigoCampania) {
		this.codigoCampania = codigoCampania;
	}

	/* Metodo que retorna codigoPromocion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Long codigoPromocion 
	 */
	public Long getCodigoPromocion() {
		return codigoPromocion;
	}

	/* Metodo que asigna el codigoPromocion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoPromocion parametro de tipo Long
	 */
	public void setCodigoPromocion(Long codigoPromocion) {
		this.codigoPromocion = codigoPromocion;
	}

	/* Metodo que retorna codigoArticulo del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return String codigoArticulo 
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/* Metodo que asigna el codigoArticulo del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoArticulo parametro de tipo String
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/* Metodo que retorna cantidad del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return BigDecimal cantidad 
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}

	/* Metodo que asigna el cantidad del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param cantidad parametro de tipo BigDecimal
	 */
	public void setCantidad(BigDecimal cantidad) {
		if(cantidad == null){
			this.cantidad = cantidad;
		}
		else{
			this.cantidad = cantidad.setScale(ConveniosConstantes.NUMERO_DECIMALES_MONEDA,ConveniosConstantes.METODO_REDONDEO);
			
		}
	}

	/* Metodo que retorna valorAcumulado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return BigDecimal valorAcumulado 
	 */
	public BigDecimal getValorAcumulado() {
		return valorAcumulado;
	}

	/* Metodo que asigna el valorAcumulado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param valorAcumulado parametro de tipo BigDecimal
	 */
	public void setValorAcumulado(BigDecimal valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	

	/* Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.lang.String idUsuarioRegistro 
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/* Metodo que asigna el idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param idUsuarioRegistro parametro de tipo java.lang.String
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/* Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.util.Date fechaRegistro 
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/* Metodo que asigna el fechaRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaRegistro parametro de tipo java.util.Date
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/* Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.lang.String idUsuarioModificacion 
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/* Metodo que asigna el idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param idUsuarioModificacion parametro de tipo java.lang.String
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/* Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.util.Date fechaModificacion 
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/* Metodo que asigna el fechaModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaModificacion parametro de tipo java.util.Date
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/* Metodo que retorna configuracionDatosProcesadosAcumuladosCol del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Collection<ConfiguracionDatosProcesadosAcumuladosDTO> configuracionDatosProcesadosAcumuladosCol 
	 */
	public Collection<ConfiguracionDatosProcesadosAcumuladosDTO> getConfiguracionDatosProcesadosAcumuladosCol() {
		return configuracionDatosProcesadosAcumuladosCol;
	}

	/* Metodo que asigna el configuracionDatosProcesadosAcumuladosCol del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param configuracionDatosProcesadosAcumuladosCol parametro de tipo Collection<ConfiguracionDatosProcesadosAcumuladosDTO>
	 */
	public void setConfiguracionDatosProcesadosAcumuladosCol(Collection<ConfiguracionDatosProcesadosAcumuladosDTO> configuracionDatosProcesadosAcumuladosCol) {
		this.configuracionDatosProcesadosAcumuladosCol = configuracionDatosProcesadosAcumuladosCol;
	}

	/* Metodo que retorna campaniaDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return GestionPrecioDTO campaniaDTO 
	 */
	public GestionPrecioDTO getCampaniaDTO() {
		return campaniaDTO;
	}

	/* Metodo que asigna el campaniaDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param campaniaDTO parametro de tipo GestionPrecioDTO
	 */
	public void setCampaniaDTO(GestionPrecioDTO campaniaDTO) {
		this.campaniaDTO = campaniaDTO;
	}

	/* Metodo que retorna promocionDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return GestionPrecioDTO promocionDTO 
	 */
	public GestionPrecioDTO getPromocionDTO() {
		return promocionDTO;
	}

	/* Metodo que asigna el promocionDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param promocionDTO parametro de tipo GestionPrecioDTO
	 */
	public void setPromocionDTO(GestionPrecioDTO promocionDTO) {
		this.promocionDTO = promocionDTO;
	}

	/* Metodo que retorna articuloDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return ArticuloDTO articuloDTO 
	 */
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	/* Metodo que asigna el articuloDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param articuloDTO parametro de tipo ArticuloDTO
	 */
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	/* Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 24/11/2014
	 * @return String estado 
	 */
	public String getEstado() {
		return estado;
	}

	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 24/11/2014
	 * @param estado parametro de tipo String
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/** Metodo que retorna codigoCampaniaLoyalty del objeto
	 * @author srodriguez
	 * 16/3/2015
	 * @return Long codigoCampaniaLoyalty 
	 */
	public Long getCodigoCampaniaLoyalty() {
		return codigoCampaniaLoyalty;
	}

	/** Metodo que asigna el valor codigoCampaniaLoyalty en codigoCampaniaLoyalty del objeto
	 * @author srodriguez
	 * 16/3/2015
	 * @param codigoCampaniaLoyalty
	 */
	
	public void setCodigoCampaniaLoyalty(Long codigoCampaniaLoyalty) {
		this.codigoCampaniaLoyalty = codigoCampaniaLoyalty;
	}

	/** Metodo que retorna codigoPromocionLoyalty del objeto
	 * @author srodriguez
	 * 16/3/2015
	 * @return Long codigoPromocionLoyalty 
	 */
	public Long getCodigoPromocionLoyalty() {
		return codigoPromocionLoyalty;
	}

	/** Metodo que asigna el valor codigoPromocionLoyalty en codigoPromocionLoyalty del objeto
	 * @author srodriguez
	 * 16/3/2015
	 * @param codigoPromocionLoyalty
	 */
	
	public void setCodigoPromocionLoyalty(Long codigoPromocionLoyalty) {
		this.codigoPromocionLoyalty = codigoPromocionLoyalty;
	}

	/** Metodo que retorna codigoArticuloLoyalty del objeto
	 * @author srodriguez
	 * 16/3/2015
	 * @return String codigoArticuloLoyalty 
	 */
	public String getCodigoArticuloLoyalty() {
		return codigoArticuloLoyalty;
	}

	/** Metodo que asigna el valor codigoArticuloLoyalty en codigoArticuloLoyalty del objeto
	 * @author srodriguez
	 * 16/3/2015
	 * @param codigoArticuloLoyalty
	 */
	
	public void setCodigoArticuloLoyalty(String codigoArticuloLoyalty) {
		this.codigoArticuloLoyalty = codigoArticuloLoyalty;
	}

	/**
	 * @return the codigoLocal
	 */
	public String getCodigoLocal() {
		return codigoLocal;
	}

	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(String codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	/**
	 * @return the codigoLocalLoyalty
	 */
	public String getCodigoLocalLoyalty() {
		return codigoLocalLoyalty;
	}

	/**
	 * @param codigoLocalLoyalty the codigoLocalLoyalty to set
	 */
	public void setCodigoLocalLoyalty(String codigoLocalLoyalty) {
		this.codigoLocalLoyalty = codigoLocalLoyalty;
	}

	/**
	 * @return the precio
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getTotalProductos() {
		return totalProductos;
	}

	public void setTotalProductos(BigDecimal totalProductos) {
		this.totalProductos = totalProductos;
	}	
	
}
