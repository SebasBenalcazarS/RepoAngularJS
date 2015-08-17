
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.ArticuloTemporadaID;


/**
 * Almacenara los articulos por temporada
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.ArticuloTemporadaDTO")
@Table(name = "SCSPETARTTEM")
public class ArticuloTemporadaDTO extends AuditoriaBaseDTO<ArticuloTemporadaID> implements Cloneable {


	/**
	 * estado, valores: 1(Activo), 0(Inactivo)
	 *

	 */
	@Column(name = "ESTADO")
	private String estado ;

	

	/**
	 * TemporadaDTO
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA",  insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTEMPORADA", referencedColumnName = "CODIGOTEMPORADA",  insertable = false, updatable = false)
		})
	private TemporadaDTO temporadaDTO;



	/**
	 * articuloDTO
	 *
	 */
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumns ({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO" , insertable = false, updatable = false),
		@JoinColumn(name ="CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ArticuloProveedorDTO articuloProveedorDTO;


	
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "articuloTemporadaDTO")
	@CollectionTypeInfo(name = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ArticuloTemporadaDetalleDTO> articuloTemporadaDetalleCol;
	
	@Transient
	private Integer npCantidadDespachada;
	
	@Transient
	private Integer npCantidadEntregada;
	
	@Transient
	private Integer npCodigoLocal;
	
	@Transient
	private Boolean npConsultarStockReal=Boolean.FALSE;
	
	@Transient
	private String npUserLogged;

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado(){
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * @param estado1 
	 *		El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado( String estado1 ){
		this.estado=estado1;
		
		if(estado!=null && estado.length()>1){
			estado = estado.substring(0,1);
		}
				
				
	}

		


	@Override
	protected Object clone() throws CloneNotSupportedException {

		ArticuloTemporadaDTO clon = null;
		try {
			clon = (ArticuloTemporadaDTO) super.clone();
			clon.setId((ArticuloTemporadaID) super.id.clone());

		} catch (CloneNotSupportedException ex) {
			throw new SICException("No se puede clonar el objeto",ex);
		}
		return clon;

	}

	public TemporadaDTO getTemporadaDTO() {
		return temporadaDTO;
	}

	public void setTemporadaDTO(TemporadaDTO temporadaDTO) {
		this.temporadaDTO = temporadaDTO;
	}

	public Collection<ArticuloTemporadaDetalleDTO> getArticuloTemporadaDetalleCol() {
		return articuloTemporadaDetalleCol;
	}

	public void setArticuloTemporadaDetalleCol(
			Collection<ArticuloTemporadaDetalleDTO> articuloTemporadaDetalleCol) {
		this.articuloTemporadaDetalleCol = articuloTemporadaDetalleCol;
	}

	public ArticuloProveedorDTO getArticuloProveedorDTO() {
		return articuloProveedorDTO;
	}

	public void setArticuloProveedorDTO(ArticuloProveedorDTO articuloProveedorDTO) {
		this.articuloProveedorDTO = articuloProveedorDTO;
	}

	public Integer getNpCantidadDespachada() {
		return npCantidadDespachada;
	}

	public void setNpCantidadDespachada(Integer npCantidadDespachada) {
		this.npCantidadDespachada = npCantidadDespachada;
	}

	public Integer getNpCantidadEntregada() {
		return npCantidadEntregada;
	}

	public void setNpCantidadEntregada(Integer npCantidadEntregada) {
		this.npCantidadEntregada = npCantidadEntregada;
	}

	public Boolean getNpConsultarStockReal() {
		return npConsultarStockReal;
	}

	public void setNpConsultarStockReal(Boolean npConsultarStockReal) {
		this.npConsultarStockReal = npConsultarStockReal;
	}

	public Integer getNpCodigoLocal() {
		return npCodigoLocal;
	}

	public void setNpCodigoLocal(Integer npCodigoLocal) {
		this.npCodigoLocal = npCodigoLocal;
	}

	public String getNpUserLogged() {
		return npUserLogged;
	}

	public void setNpUserLogged(String npUserLogged) {
		this.npUserLogged = npUserLogged;
	}


}

