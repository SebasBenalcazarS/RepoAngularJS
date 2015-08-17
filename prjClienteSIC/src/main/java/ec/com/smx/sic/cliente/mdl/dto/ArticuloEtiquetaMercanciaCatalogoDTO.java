/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEtiquetaMercanciaCatalogoID;

/**
 * @author eharo
 *
 */


@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTETIMERCAT")
public class ArticuloEtiquetaMercanciaCatalogoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ArticuloEtiquetaMercanciaCatalogoID id = new ArticuloEtiquetaMercanciaCatalogoID();
	
	
	@Column(name = "CODIGOARTETIMERCANCIA", nullable = false)
	private Long codigoArticuloEtiquetaMercancia;
	
	
	/**
	 * Este campo sirve para saber si el objeto es catalogado con NTE, RNE o LOTE,Numero Serie
	 */
	@Column(name = "CODIGOVALORCALIFICADOR", nullable = true)
	private String codigoValorCalificador;
	

	/**
	 * Este campo sirve para saber si el objeto es catalogado con NTE, RNE o LOTE,Numero Serie
	 */
	@Column(name = "CODIGOTIPOCALIFICADOR", nullable = true)
	private Integer codigoTipoCalificador;
	
	
	
	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = true)
	private String estado;
	
	
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private String usuarioRegistro;
	
	@Column(name="IDUSUARIOMODIFICACION")
	@LastModifierUserIdField
	private String usuarioActualizacion;
	
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	private Timestamp fechaRegistro;
	
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	private Timestamp fechaUltimaActualizacion;
	
	
	
	/******************************************************************************************************************************/
    /***********RELACIONES*********************************************************************************************************/
    /******************************************************************************************************************************/

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTETIMERCANCIA", referencedColumnName = "CODIGOARTETIMERCANCIA", insertable = false, updatable = false)
	})
	private ArticuloEtiquetaMercanciaDTO articuloEtiquetaMercanciaDTO;
	
	
	 /**
     * Relacion con el catalogo para las saber si el objeto es NTE, RNE o Lote, Numero de Serie
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOVALORCALIFICADOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOCALIFICADOR", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private CatalogoValorDTO catalogoCalificador;


    /******************************************************************************************************************************/
    /******************************************************************************************************************************/
    /******************************************************************************************************************************/
    
    
    
    /****************************************************************************************************************************************************/
    /****************************************************************************************************************************************************/
    /****************METODS******************************************************************************************************************************/
    /************************GETTER**********************************************************************************************************************/
    /********************************SETTER**************************************************************************************************************/
    /****************************************************************************************************************************************************/
    /****************************************************************************************************************************************************/
    
	/**
	 * @return the id
	 */
	public ArticuloEtiquetaMercanciaCatalogoID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloEtiquetaMercanciaCatalogoID id) {
		this.id = id;
	}


	/**
	 * @return the codigoArticuloEtiquetaMercancia
	 */
	public Long getCodigoArticuloEtiquetaMercancia() {
		return codigoArticuloEtiquetaMercancia;
	}


	/**
	 * @param codigoArticuloEtiquetaMercancia the codigoArticuloEtiquetaMercancia to set
	 */
	public void setCodigoArticuloEtiquetaMercancia(Long codigoArticuloEtiquetaMercancia) {
		this.codigoArticuloEtiquetaMercancia = codigoArticuloEtiquetaMercancia;
	}


	/**
	 * @return the codigoValorCalificador
	 */
	public String getCodigoValorCalificador() {
		return codigoValorCalificador;
	}


	/**
	 * @param codigoValorCalificador the codigoValorCalificador to set
	 */
	public void setCodigoValorCalificador(String codigoValorCalificador) {
		this.codigoValorCalificador = codigoValorCalificador;
	}


	/**
	 * @return the codigoTipoCalificador
	 */
	public Integer getCodigoTipoCalificador() {
		return codigoTipoCalificador;
	}


	/**
	 * @param codigoTipoCalificador the codigoTipoCalificador to set
	 */
	public void setCodigoTipoCalificador(Integer codigoTipoCalificador) {
		this.codigoTipoCalificador = codigoTipoCalificador;
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
	 * @return the usuarioCreacion
	 */
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}


	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	/**
	 * @return the usuarioActualizacion
	 */
	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}


	/**
	 * @param usuarioActualizacion the usuarioActualizacion to set
	 */
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}


	/**
	 * @return the fechaCreacion
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}


	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	/**
	 * @return the fechaUltimaActualizacion
	 */
	public Timestamp getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}


	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}


	/**
	 * @return the articuloEtiquetaMercanciaDTO
	 */
	public ArticuloEtiquetaMercanciaDTO getArticuloEtiquetaMercanciaDTO() {
		return articuloEtiquetaMercanciaDTO;
	}


	/**
	 * @param articuloEtiquetaMercanciaDTO the articuloEtiquetaMercanciaDTO to set
	 */
	public void setArticuloEtiquetaMercanciaDTO(ArticuloEtiquetaMercanciaDTO articuloEtiquetaMercanciaDTO) {
		this.articuloEtiquetaMercanciaDTO = articuloEtiquetaMercanciaDTO;
	}


	/**
	 * @return the catalogoCalificador
	 */
	public CatalogoValorDTO getCatalogoCalificador() {
		return catalogoCalificador;
	}


	/**
	 * @param catalogoCalificador the catalogoCalificador to set
	 */
	public void setCatalogoCalificador(CatalogoValorDTO catalogoCalificador) {
		this.catalogoCalificador = catalogoCalificador;
	}
}
