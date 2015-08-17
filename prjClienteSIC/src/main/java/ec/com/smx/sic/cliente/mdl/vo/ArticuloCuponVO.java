package ec.com.smx.sic.cliente.mdl.vo;


import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;

/**
 * 
 * @author corbe
 *
 */
public class ArticuloCuponVO {
	//articulo del cupon
	ArticuloDTO articuloDTO;
	
	//articulo relacionado con el cupon
	ArticuloDTO articuloRelacionado;
	
	//local en el cual el articulo tiene alcance
	AreaTrabajoDTO localDTO;
	
	//usado para la clasificacion segun la jerarquia gestion precio
	GestionPrecioDTO gestionPrecioDTO;
	
	Collection<ArticuloCuponVO> articuloCuponCol;

	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	public ArticuloDTO getArticuloRelacionado() {
		return articuloRelacionado;
	}

	public void setArticuloRelacionado(ArticuloDTO articuloRelacionado) {
		this.articuloRelacionado = articuloRelacionado;
	}

	public AreaTrabajoDTO getLocalDTO() {
		return localDTO;
	}

	public void setLocalDTO(AreaTrabajoDTO localDTO) {
		this.localDTO = localDTO;
	}

	public GestionPrecioDTO getGestionPrecioDTO() {
		return gestionPrecioDTO;
	}

	public void setGestionPrecioDTO(GestionPrecioDTO gestionPrecioDTO) {
		this.gestionPrecioDTO = gestionPrecioDTO;
	}

	public Collection<ArticuloCuponVO> getArticuloCuponCol() {
		return articuloCuponCol;
	}

	public void setArticuloCuponCol(Collection<ArticuloCuponVO> articuloCuponCol) {
		this.articuloCuponCol = articuloCuponCol;
	}	
}
