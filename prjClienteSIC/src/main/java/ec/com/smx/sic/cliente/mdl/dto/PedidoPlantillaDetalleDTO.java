/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoPlantillaDetalleID;

/**
 * @author jvillacis
 *
 */
@Entity
@Table(name = "SCORCTPEDPLADET")
@SuppressWarnings("serial")
public class PedidoPlantillaDetalleDTO extends SimpleAuditDTO{
	@EmbeddedId
	private PedidoPlantillaDetalleID id = new PedidoPlantillaDetalleID();
	
	@Column(name = "CODIGOPLANTILLA")
	private Long codigoPlantilla;
	
	@Column(name = "CODIGOUNIDADMANEJO")
	private Long codigoUnidadManejo;
	
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	@Column(name = "NUMEROLINEA")
	private Integer numeroLinea;
	
	@Column(name = "CANTIDADPEDIDA")
	private Integer cantidadPedida;
	
	@Column(name = "PESOPEDIDO")
	private BigDecimal pesoPedido;
	
	@Column(name = "DISPONIBLE")
	@ComparatorTypeField
	private String disponible;
	
	@Column(name = "ESTADO", nullable = false)
	@ComparatorTypeField
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable = false)
    private String idUsuarioRegistro;
    
    @RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
  
    @LastModifierUserIdField	
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
    })
    private ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	 @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
         @JoinColumn(name = "CODIGOPLANTILLA", referencedColumnName = "CODIGOPLANTILLA", insertable = false, updatable = false)
    })
    private PedidoPlantillaDTO pedidoPlantilla;
    

    
    /**
	 * @return the id
	 */
	public PedidoPlantillaDetalleID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoPlantillaDetalleID id) {
		this.id = id;
	}

	/**
	 * @return the codigoPlantilla
	 */
	public Long getCodigoPlantilla() {
		return codigoPlantilla;
	}

	/**
	 * @param codigoPlantilla the codigoPlantilla to set
	 */
	public void setCodigoPlantilla(Long codigoPlantilla) {
		this.codigoPlantilla = codigoPlantilla;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the numeroLinea
	 */
	public Integer getNumeroLinea() {
		return numeroLinea;
	}

	/**
	 * @param numeroLinea the numeroLinea to set
	 */
	public void setNumeroLinea(Integer numeroLinea) {
		this.numeroLinea = numeroLinea;
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
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsarioModificacion
	 */
	public String getIdUsarioModificacion() {
		return idUsarioModificacion;
	}

	/**
	 * @param idUsarioModificacion the idUsarioModificacion to set
	 */
	public void setIdUsarioModificacion(String idUsarioModificacion) {
		this.idUsarioModificacion = idUsarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the cantidadPedida
	 */
	public Integer getCantidadPedida() {
		return cantidadPedida;
	}

	/**
	 * @param cantidadPedida the cantidadPedida to set
	 */
	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	/**
	 * @return the pesoPedido
	 */
	public BigDecimal getPesoPedido() {
		return pesoPedido;
	}

	/**
	 * @param pesoPedido the pesoPedido to set
	 */
	public void setPesoPedido(BigDecimal pesoPedido) {
		this.pesoPedido = pesoPedido;
	}

	/**
	 * @return the disponible
	 */
	public String getDisponible() {
		return disponible;
	}

	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	/**
	 * @return the pedidoPlantilla
	 */
	public PedidoPlantillaDTO getPedidoPlantilla() {
		return pedidoPlantilla;
	}

	/**
	 * @param pedidoPlantilla the pedidoPlantilla to set
	 */
	public void setPedidoPlantilla(PedidoPlantillaDTO pedidoPlantilla) {
		this.pedidoPlantilla = pedidoPlantilla;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the articuloUnidadManejoProveedor
	 */
	public ArticuloUnidadManejoProveedorDTO getArticuloUnidadManejoProveedor() {
		return articuloUnidadManejoProveedor;
	}

	/**
	 * @param articuloUnidadManejoProveedor the articuloUnidadManejoProveedor to set
	 */
	public void setArticuloUnidadManejoProveedor(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedor) {
		this.articuloUnidadManejoProveedor = articuloUnidadManejoProveedor;
	}

	/**
	 * Método que obtiene la cantidad de unidades de manejor necesarias para completar un palet
	 * @return
	 */
	public Integer getCantidadUnidadManejoPorPalet(){
		//verifica si el artículo es paletizado
		//if(this.getEsPaletizado()){
			//verifica si tiene unidad de manejo padre de tipo palet
			if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol() != null
					&& SearchDTO.isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol())
					&& !this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol().isEmpty()){
				//obtiene el valor de la unidad de manejo contenedora
				return this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol().iterator().next().getValorUnidadManejo();
			}
		//}
		return null;
	}
}
