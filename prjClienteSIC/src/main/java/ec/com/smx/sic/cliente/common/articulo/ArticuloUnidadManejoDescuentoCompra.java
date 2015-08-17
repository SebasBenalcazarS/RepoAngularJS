/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.EquivalenciaPorcentajeDescuentoDTO;

/**
 * @author gaortiz
 *
 */
public final class ArticuloUnidadManejoDescuentoCompra extends ArticuloDescuentoCompra {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ArticuloUnidadManejoDTO articuloUnidadManejoDTO;
	private ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO;
	private String codigoProveedor;
	
	/**
	 * @param articuloUnidadManejoDTO
	 * @param codigoProveedor
	 */
	public ArticuloUnidadManejoDescuentoCompra(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String codigoProveedor) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
		this.codigoProveedor = codigoProveedor;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getNombreDescuento()
	 */
	@Override
	public String getNombreDescuento() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(this.obtenerValorUnidadManejo());
		stringBuilder.append(" - ");
		stringBuilder.append(this.obtenerNombreUnidadManejo());
		
		return stringBuilder.toString();
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getValorDescuento()
	 */
	@Override
	public Object getValorDescuento() {
		if( this.getArticuloUnidadManejoProveedorDTO() != null && this.getArticuloUnidadManejoProveedorDTO().getEquivalenciaPorcentajeDescuentoDTO() != null ){
			return this.getArticuloUnidadManejoProveedorDTO().getEquivalenciaPorcentajeDescuentoDTO().getId().getCodigoEquivalencia();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#setValorDescuento(java.lang.Object)
	 */
	@Override
	public void setValorDescuento(Object valorDescuento) {
		Integer valor = valorDescuento != null ? Integer.valueOf(valorDescuento.toString()) : null;
		
		if( this.getArticuloUnidadManejoProveedorDTO().getEquivalenciaPorcentajeDescuentoDTO() == null ){
			this.getArticuloUnidadManejoProveedorDTO().setEquivalenciaPorcentajeDescuentoDTO(new EquivalenciaPorcentajeDescuentoDTO());
		}
		this.getArticuloUnidadManejoProveedorDTO().getEquivalenciaPorcentajeDescuentoDTO().getId().setCodigoEquivalencia( valor );
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getCostoNetoParcial()
	 */
	@Override
	public Double getCostoNetoParcial() {
		if( this.getArticuloUnidadManejoProveedorDTO().hasDynamicProperty(ArticuloUnidadManejoProveedorDTO.COSTO_NETO_PARCIAL) ){
			return (Double) this.articuloUnidadManejoProveedorDTO.getDynamicProperty(ArticuloUnidadManejoProveedorDTO.COSTO_NETO_PARCIAL);
		}
		return new Double(0);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getDescuentoDTO()
	 */
	@Override
	public ArticuloUnidadManejoDTO getDescuentoDTO() {
		return this.articuloUnidadManejoDTO;
	}

	/**
	 * @return the articuloUnidadManejoProveedorDTO
	 */
	public ArticuloUnidadManejoProveedorDTO getArticuloUnidadManejoProveedorDTO() {
		if( this.articuloUnidadManejoProveedorDTO == null ){
			this.articuloUnidadManejoProveedorDTO = this.getArticuloUnidadManejoProveedorDTO(codigoProveedor);
		}
		return this.articuloUnidadManejoProveedorDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getCodigoDescuento()
	 */
	@Override
	public Integer getCodigoDescuento() {
		if( this.getArticuloUnidadManejoProveedorDTO() != null && this.getArticuloUnidadManejoProveedorDTO().getEquivalenciaPorcentajeDescuentoDTO() != null){
			return this.getArticuloUnidadManejoProveedorDTO().getEquivalenciaPorcentajeDescuentoDTO().getId().getCodigoEquivalencia();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#setCodigoDescuento(java.lang.Integer)
	 */
	@Override
	public void setCodigoDescuento(Integer codigoDescuento) {
		if (this.getArticuloUnidadManejoProveedorDTO().getEquivalenciaPorcentajeDescuentoDTO() == null ) {
			this.getArticuloUnidadManejoProveedorDTO().setEquivalenciaPorcentajeDescuentoDTO(new EquivalenciaPorcentajeDescuentoDTO());
		}
		this.getArticuloUnidadManejoProveedorDTO().getEquivalenciaPorcentajeDescuentoDTO().getId().setCodigoEquivalencia(codigoDescuento);
	}
	
	/**
	 * 
	 * @return
	 */
	private ArticuloUnidadManejoProveedorDTO getArticuloUnidadManejoProveedorDTO(String codigoProveedor){
		
		if( CollectionUtils.isNotEmpty(articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol()) ){
			return (ArticuloUnidadManejoProveedorDTO) CollectionUtils.find(articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol(), new BeanPredicate("id.codigoProveedor", PredicateUtils.equalPredicate(codigoProveedor)) );
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * @return
	 */
	private String obtenerNombreUnidadManejo(){
		StringBuilder nombreDescuento = new StringBuilder();
		if( this.articuloUnidadManejoDTO.getTieneTipoUnidadEmpaque() ){
			nombreDescuento.append(this.articuloUnidadManejoDTO.getTipoUnidadEmpaque().getNombreCatalogoValor());
		}else{
			nombreDescuento.append(StringUtils.isNotEmpty(this.articuloUnidadManejoDTO.getValorTipoUnidadEmpaque()) ?  this.articuloUnidadManejoDTO.getValorTipoUnidadEmpaque() : StringUtils.EMPTY);
		}
		return nombreDescuento.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private String obtenerValorUnidadManejo(){
		return this.articuloUnidadManejoDTO.getValorUnidadManejo() != null ? this.articuloUnidadManejoDTO.getValorUnidadManejo().toString() : StringUtils.EMPTY;
	}
	

}
