package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que califican a la tabla CaracteristicaDetalleSeccionDTO
 * 
 */
public enum EnumCaracteristicaDetalleSeccion {
	
	

	//VALORES TIPO DE CONFIGURACION RECEPCION
	IMPORTADO(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.codigo.catalogo.caracteristica.detalle.seccion"), SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.valor.catalogo.caracteristica.detalle.seccion.importado")),
	INDUSTRIA(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.codigo.catalogo.caracteristica.detalle.seccion"), SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.valor.catalogo.caracteristica.detalle.seccion.industria")),
	NACIONAL(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.codigo.catalogo.caracteristica.detalle.seccion"), SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.valor.catalogo.caracteristica.detalle.seccion.nacional")),
	;
	
	private Integer codigoCatTipoConfRecepcion;
	
	private String valorCatTipoConfRecepcion;
	
	private EnumCaracteristicaDetalleSeccion(Integer codigoCatTipoConfRecepcion, String valorCatTipoConfRecepcion) {
		this.codigoCatTipoConfRecepcion = codigoCatTipoConfRecepcion;
		this.valorCatTipoConfRecepcion = valorCatTipoConfRecepcion;
	}

	/**
	 * @return the codigoCatTipoConfRecepcion
	 */
	public Integer getCodigoCatTipoConfRecepcion() {
		return codigoCatTipoConfRecepcion;
	}

	/**
	 * @param codigoCatTipoConfRecepcion the codigoCatTipoConfRecepcion to set
	 */
	public void setCodigoCatTipoConfRecepcion(Integer codigoCatTipoConfRecepcion) {
		this.codigoCatTipoConfRecepcion = codigoCatTipoConfRecepcion;
	}

	/**
	 * @return the valorCatTipoConfRecepcion
	 */
	public String getValorCatTipoConfRecepcion() {
		return valorCatTipoConfRecepcion;
	}

	/**
	 * @param valorCatTipoConfRecepcion the valorCatTipoConfRecepcion to set
	 */
	public void setValorCatTipoConfRecepcion(String valorCatTipoConfRecepcion) {
		this.valorCatTipoConfRecepcion = valorCatTipoConfRecepcion;
	}
	
}
