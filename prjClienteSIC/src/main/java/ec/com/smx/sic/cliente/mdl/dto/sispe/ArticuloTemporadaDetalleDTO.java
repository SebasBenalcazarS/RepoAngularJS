package ec.com.smx.sic.cliente.mdl.dto.sispe;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.sispe.ArticuloTemporadaDetalleID;


/**
 * Cabecera del detalle de los kardex
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Entity (name = "ec.com.smx.sic.cliente.mdl.dto.sispe.ArticuloTemporadaDetalleDTO")
@Table (name = "SCSPETARTTEMDET")
public class ArticuloTemporadaDetalleDTO extends AuditoriaBaseDTO<ArticuloTemporadaDetalleID> {


		
	/**
	 * Cantidad para un tipo determinado de stock
	 *

	 */
	@Column (name = "CANTIDADTOTAL")
	private Double cantidadTotal ;

	

	/**
	 * estado, valores: 1(Activo), 0(Inactivo)
	 *

	 */
	@Column (name = "ESTADO")
	private String estado ;
	

	/**
	 * articuloTemporadaDTO
	 *
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTEMPORADA", referencedColumnName = "CODIGOTEMPORADA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)

	})
	private ArticuloTemporadaDTO articuloTemporadaDTO;



	/**
	 * tipoStockDTO
	 *
	 */
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumns ({
		@JoinColumn (name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn (name = "CODIGOTIPOSTOCK", referencedColumnName = "CODIGOTIPOSTOCK", insertable = false, updatable = false)
		
	})
	private TipoStockDTO tipoStockDTO;


	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ArticuloTemporadaDetalleID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ArticuloTemporadaDetalleID id1 ){
		this.id=id1;
	}


		
		

	/**
	 * Retorna valor de propiedad <code>cantidadTotal</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cantidadTotal</code>
	 */
	public Double getCantidadTotal(){
		return this.cantidadTotal;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadTotal</code>.
	 * @param cantidadTotal1 
	 *		El valor a establecer para la propiedad <code>cantidadTotal</code>.
	 */
	public void setCantidadTotal( Double cantidadTotal1 ){
		this.cantidadTotal=cantidadTotal1;
		
	}

		

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

	public ArticuloTemporadaDTO getArticuloTemporadaDTO() {
		return articuloTemporadaDTO;
	}

	public void setArticuloTemporadaDTO(ArticuloTemporadaDTO articuloTemporadaDTO) {
		this.articuloTemporadaDTO = articuloTemporadaDTO;
	}

	public TipoStockDTO getTipoStockDTO() {
		return tipoStockDTO;
	}

	public void setTipoStockDTO(TipoStockDTO tipoStockDTO) {
		this.tipoStockDTO = tipoStockDTO;
	}


}

