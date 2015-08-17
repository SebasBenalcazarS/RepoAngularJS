package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en los procesos de bodega
 * @author fcollaguazo
 *
 */
public enum EnumTipoChecklist {

	//VALORES TIPO DE RECEPCION
	NORMAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.recepcion.normal"),
			SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.recepcion.normal.codigo.configuracion.plantilla"),
			SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.recepcion.normal.codigo.tipo.plantilla")),
	INDUSTRIA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.recepcion.industria"),
			SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.recepcion.industria.codigo.configuracion.plantilla"),
			SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.recepcion.industria.codigo.tipo.plantilla")),
	IMPORTADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.recepcion.importado"),
			SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.recepcion.importado.codigo.configuracion.plantilla"),
			SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.tipo.recepcion.importado.codigo.tipo.plantilla"));
	
	/**
	 * The tipoRecepcion
	 */
	private String tipoRecepcion;
	private int codigoConfiguracionPlantilla;
	private int codigoTipoPlantilla;
	
	
	
	private EnumTipoChecklist(String tipoRecepcion, int codigoConfiguracionPlantilla, int codigoTipoPlantilla) {
		this.tipoRecepcion = tipoRecepcion;
		this.codigoConfiguracionPlantilla = codigoConfiguracionPlantilla;
		this.codigoTipoPlantilla = codigoTipoPlantilla;
	}
	/**
	 * @return the tipoRecepcion
	 */
	public final String getTipoRecepcion() {
		return tipoRecepcion;
	}
	/**
	 * @param tipoRecepcion the tipoRecepcion to set
	 */
	public final void setTipoRecepcion(String tipoRecepcion) {
		this.tipoRecepcion = tipoRecepcion;
	}
	/**
	 * @return the codigoConfiguracionPlantilla
	 */
	public final int getCodigoConfiguracionPlantilla() {
		return codigoConfiguracionPlantilla;
	}
	/**
	 * @param codigoConfiguracionPlantilla the codigoConfiguracionPlantilla to set
	 */
	public final void setCodigoConfiguracionPlantilla(int codigoConfiguracionPlantilla) {
		this.codigoConfiguracionPlantilla = codigoConfiguracionPlantilla;
	}
	/**
	 * @return the codigoTipoPlantilla
	 */
	public final int getCodigoTipoPlantilla() {
		return codigoTipoPlantilla;
	}
	/**
	 * @param codigoTipoPlantilla the codigoTipoPlantilla to set
	 */
	public final void setCodigoTipoPlantilla(int codigoTipoPlantilla) {
		this.codigoTipoPlantilla = codigoTipoPlantilla;
	}
	
	
		
}
