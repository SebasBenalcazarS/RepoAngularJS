/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.DetalleRespaldoArticuloID;

/**
 * @author mbraganza
 * @author osaransig
 * 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.DetalleRespaldoArticuloDTO")
@Table(name = "SCSPETDETRESART")
public class DetalleRespaldoArticuloDTO extends DatosArticuloDTO {

	@EmbeddedId
	private DetalleRespaldoArticuloID id;

	private String codigoArticuloPadre;
	private String codigoTipoArticulo;
	private String codigoClasificacion;
	private String codigoSubClasificacion;
	private String codigoProveedor;
	private String descripcionArticulo;
	private String marca;
	private String codigoInternoProveedor;
	private String tipoArticuloCalculoPrecio;
	private String estadoArticulo;
	private String claseArticulo;
	private String leyendaArticulo;
	private String tamanio;
	private Long unidadManejo;
	private String tieneRelaciones;
	private String marcaArticulo;
	private String estadoInterproveedor;
	@RegisterUserIdField
	private String idUsuarioRegistro;
	@RegisterDateField
	private Timestamp fechaRegistro;
	
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	@LastModificationDateField
	private Timestamp fechaActualizacion;
	
	@ManyToOne(fetch=FetchType.LAZY)	
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
	@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;
	
	private String codigoBarras;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public DetalleRespaldoArticuloDTO() {
		this.id = new DetalleRespaldoArticuloID();
	}

	/**
	 * Creación de un respaldo a partir de los datos de un artículo
	 * 
	 * @param codigoRespaldoArticulo
	 * @param articuloBase
	 */
	public DetalleRespaldoArticuloDTO(Long codigoRespaldoArticulo,
			ArticuloDTO articuloBase) {

		// id
		this.id = new DetalleRespaldoArticuloID();
		this.id.setCodigoCompania(articuloBase.getId().getCodigoCompania());
		this.id.setCodigoRespaldoArticulo(codigoRespaldoArticulo);
		this.id.setCodigoArticulo(articuloBase.getId().getCodigoArticulo());

		// atributos
		this.setCodigoArticuloPadre(articuloBase.getCodigoArticuloPadre());
		this.setCodigoTipoArticulo(articuloBase.getCodigoTipoArticulo());
		this.setCodigoClasificacion(articuloBase.getCodigoClasificacion());
		// this.setCodigoProveedor(articuloBase.getCodigoProveedor());
		this.setCodigoSubClasificacion(articuloBase.getCodigoSubClasificacion());
		this.setDescripcionArticulo(articuloBase.getDescripcionArticulo());
		// this.setLeyendaArticulo(articuloBase.getLeyendaArticulo());
		// this.setTamanio(articuloBase.getTamanio());
		// this.setUnidadManejo(articuloBase.getUnidadManejo());
		// this.setTipoArticuloCalculoPrecio(articuloBase.getTipoArticuloCalculoPrecio());
		this.setEstadoArticulo(articuloBase.getEstadoArticulo());
		// this.setMarca(articuloBase.getMarca());
		// this.setTieneRelaciones(articuloBase.getTieneRelaciones());
		// this.setCodigoInternoProveedor(articuloBase.getCodigoInternoProveedor());
		this.setClaseArticulo(articuloBase.getClaseArticulo());
		// this.setMarcaArticulo(articuloBase.getMarcaArticulo());
		// this.setEstadoInterproveedor(articuloBase.getEstadoInterproveedor());
	}


	// relaciones
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@javax.persistence.JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@javax.persistence.JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private ClasificacionDTO clasificacionDTO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@javax.persistence.JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@javax.persistence.JoinColumn(name = "CODIGOSUBCLASIFICACION", referencedColumnName = "CODIGOSUBCLASIFICACION", insertable = false, updatable = false),
			@javax.persistence.JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private SubClasificacionDTO subClasificacionDTO;

	/**
	 * @return el id
	 */
	public DetalleRespaldoArticuloID getId() {
		return id;
	}

	/**
	 * @param id
	 *            el id a establecer
	 */
	public void setId(DetalleRespaldoArticuloID id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getCodigoCompania() {
		if (this.id != null) {
			return this.id.getCodigoCompania();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public Long getCodigoRespaldoArticulo() {
		if (this.id != null) {
			return this.id.getCodigoRespaldoArticulo();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String getCodigoArticulo() {
		if (this.id != null) {
			return this.id.getCodigoArticulo();
		}
		return null;
	}

	/**
	 * @param codigoArticulo
	 *            el codigoArticulo a establecer
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.id.setCodigoArticulo(codigoArticulo);
	}

	/**
	 * @param codigoCompania
	 *            el codigoCompania a establecer
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.id.setCodigoCompania(codigoCompania);
	}

	/**
	 * @param codigoRespaldoArticulo
	 *            el codigoRespaldoArticulo a establecer
	 */
	public void setCodigoRespaldoArticulo(Long codigoRespaldoArticulo) {
		this.id.setCodigoRespaldoArticulo(codigoRespaldoArticulo);
	}

	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}

	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}

	public SubClasificacionDTO getSubClasificacionDTO() {
		return subClasificacionDTO;
	}

	public void setSubClasificacionDTO(SubClasificacionDTO subClasificacionDTO) {
		this.subClasificacionDTO = subClasificacionDTO;
	}

	public String getCodigoArticuloPadre() {
		return codigoArticuloPadre;
	}

	public void setCodigoArticuloPadre(String codigoArticuloPadre) {
		this.codigoArticuloPadre = codigoArticuloPadre;
	}

	public String getCodigoTipoArticulo() {
		return codigoTipoArticulo;
	}

	public void setCodigoTipoArticulo(String codigoTipoArticulo) {
		this.codigoTipoArticulo = codigoTipoArticulo;
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

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodigoInternoProveedor() {
		return codigoInternoProveedor;
	}

	public void setCodigoInternoProveedor(String codigoInternoProveedor) {
		this.codigoInternoProveedor = codigoInternoProveedor;
	}

	public String getTipoArticuloCalculoPrecio() {
		return tipoArticuloCalculoPrecio;
	}

	public void setTipoArticuloCalculoPrecio(String tipoArticuloCalculoPrecio) {
		this.tipoArticuloCalculoPrecio = tipoArticuloCalculoPrecio;
	}

	public String getEstadoArticulo() {
		return estadoArticulo;
	}

	public void setEstadoArticulo(String estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}

	public String getClaseArticulo() {
		return claseArticulo;
	}

	public void setClaseArticulo(String claseArticulo) {
		this.claseArticulo = claseArticulo;
	}

	public String getLeyendaArticulo() {
		return leyendaArticulo;
	}

	public void setLeyendaArticulo(String leyendaArticulo) {
		this.leyendaArticulo = leyendaArticulo;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public Long getUnidadManejo() {
		return unidadManejo;
	}

	public void setUnidadManejo(Long unidadManejo) {
		this.unidadManejo = unidadManejo;
	}

	public String getTieneRelaciones() {
		return tieneRelaciones;
	}

	public void setTieneRelaciones(String tieneRelaciones) {
		this.tieneRelaciones = tieneRelaciones;
	}

	public String getMarcaArticulo() {
		return marcaArticulo;
	}

	public void setMarcaArticulo(String marcaArticulo) {
		this.marcaArticulo = marcaArticulo;
	}

	public String getEstadoInterproveedor() {
		return estadoInterproveedor;
	}

	public void setEstadoInterproveedor(String estadoInterproveedor) {
		this.estadoInterproveedor = estadoInterproveedor;
	}

	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

}
