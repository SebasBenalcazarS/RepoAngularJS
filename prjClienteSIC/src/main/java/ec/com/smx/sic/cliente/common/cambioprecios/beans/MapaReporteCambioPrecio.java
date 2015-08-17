package ec.com.smx.sic.cliente.common.cambioprecios.beans;

/**
 * @author dgutierrez
 */
public enum MapaReporteCambioPrecio {
	CODIGO_NOMBRE_PROVEEDOR("nombre"), 
	RUC_PROVEEDOR("ruc"), 
	
	CODIGO_BARRAS("codigoBarras"),
	DESCRIPCION_ARTICULO("nombre"),
	TAMANO("tamano"), 
	
	CODIGO_DESCRIPCION_CLASIFICACION("cdc"), 
	ESTADO("estado"),
	
	FECHA_VIGENCIACOSTOS("fvc"), 
	FECHA_VIGENCIARETORNOCOSTOS("frc"), 
	FECHA_VIGENCIAPRECIOS("fvv"),
	FECHA_VIGENCIARETORNOPRECIOS("frv"), 

	VARIACION_COSTO("vc"), 
	PORCENTAJE_VARIACION_COSTO("pvc"),
	VARIACION_VENTA("vv"), 
	PORCENTAJE_VARIACION_VENTA("pvv"),
	
	COSTO_BRUTO_ANTERIOR("cba"), 
	COSTO_NETONC_ANTERIOR("cnna"), 
	COSTO_NETO_ANTERIOR("cna"), 
	PRECIO_PVP_ANTERIOR("pvpa"), 
	MARGEN_PVP_ANTERIOR("mpvpa"), 
	PRECIO_SMX_ANTERIOR("psa"), 
	MARGEN_SMX_ANTERIOR("msa"),
	PRECIO_SMXNA_ANTERIOR("pnaa"),
	COSTO_NETONOTACREDIRO_PVP_ANTERIOR("cnpvpa"),
	PVP_PSMX_ANTERIOR("ppsa"),
	PVP_COSTO_NETONOTACREDITO_ANTERIOR("pcna"), 
	PSMX_OFERTALOCAL_ANTERIOR("pspla"), 
	VENTA_COSTONETONOTACREDITO_ANTERIOR("vcna"), 
	INFLACION_COSTO("ic"), 
	 
	COSTO_BRUTO_NUEVO("cbn"), 
	COSTO_NETONC_NUEVO("cnnn"), 
	COSTO_NETO_NUEVO("cnn"), 
	PRECIO_PVP_NUEVO("pvpn"), 
	MARGEN_PVP_NUEVO("mpvpn"), 
	PRECIO_SMX_NUEVO("psn"), 
	MARGEN_SMX_NUEVO("msn"), 
	PRECIO_SMXNA_NUEVO("pnan"), 
	COSTO_NETONOTACREDIRO_PVP_NUEVO("cnpvpn"), 
	PVP_PSMX_NUEVO("ppsn"), 
	PVP_COSTO_NETONOTACREDITO_NUEVO("pcnn"), 
	PSMX_OFERTALOCAL_NUEVO("pspln"), 
	VENTA_COSTONETONOTACREDITO_NUEVO("vcnn"),
	INFLACION_VENTA("iv");
	
	private String id;

	public String getId() {
		return this.id;
	}
	
	MapaReporteCambioPrecio(String id) {
		this.id = id;
	}
}
