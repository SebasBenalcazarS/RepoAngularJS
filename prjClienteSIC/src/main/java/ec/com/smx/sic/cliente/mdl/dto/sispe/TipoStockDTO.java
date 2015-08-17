
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.sic.cliente.mdl.dto.id.sispe.TipoStockID;


/**
 * Almacenara el tipo de stock
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.TipoStockDTO")
@Table (name = "SCSPETTIPSTO")
public class TipoStockDTO extends AuditoriaBaseDTO<TipoStockID> {



	/**
	 * nombreStock
	 *

	 */
	@Column(name = "NOMBRESTOCK")
	private String nombreStock ;

	

	/**
	 * descripcion
	 *

	 */
	@Column(name = "DESCRIPCION")
	private String descripcion ;

	

	/**
	 * estado, valores: 1(Activo), 0(Inactivo)
	 *

	 */
	@Column(name = "ESTADO")
	private String estado ;


	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "tipoStockDTO")
	@CollectionTypeInfo(name = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ArticuloTemporadaDetalleDTO> articuloTemporadaDetalleCol;


	/**
	 * Retorna valor de propiedad <code>nombreStock</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>nombreStock</code>
	 */
	public String getNombreStock(){
		return this.nombreStock;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombreStock</code>.
	 * @param nombreStock1 
	 *		El valor a establecer para la propiedad <code>nombreStock</code>.
	 */
	public void setNombreStock( String nombreStock1 ){
		this.nombreStock=nombreStock1;
		
		if(nombreStock!=null && nombreStock.length()>128){
			nombreStock = nombreStock.substring(0,128);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>descripcion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>descripcion</code>
	 */
	public String getDescripcion(){
		return this.descripcion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcion</code>.
	 * @param descripcion1 
	 *		El valor a establecer para la propiedad <code>descripcion</code>.
	 */
	public void setDescripcion( String descripcion1 ){
		this.descripcion=descripcion1;
		
		if(descripcion!=null && descripcion.length()>1024){
			descripcion = descripcion.substring(0,1024);
		}
				
				
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

	public Collection<ArticuloTemporadaDetalleDTO> getArticuloTemporadaDetalleCol() {
		return articuloTemporadaDetalleCol;
	}

	public void setArticuloTemporadaDetalleCol(
			Collection<ArticuloTemporadaDetalleDTO> articuloTemporadaDetalleCol) {
		this.articuloTemporadaDetalleCol = articuloTemporadaDetalleCol;
	}
		

}

