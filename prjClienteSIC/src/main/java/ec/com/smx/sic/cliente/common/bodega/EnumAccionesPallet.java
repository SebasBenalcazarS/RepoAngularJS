package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumAccionesPallet {
	INICIAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.iniciar")),
	RECOLECTAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.recolectar")),
	DEJAR_PALLET_UBICACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.dejarPalletUbicacion")),
	DEJAR_PALLET_PASILLO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.dejarPalletPasillo")),
	ANULAR_PALLET(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.anular")),
	RECIBIR_PALLET(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.recibir")),
	MODIFICAR_PALLET(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.modificar")),
	ELIMINAR_PALLET(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.eliminar")),
	DEJE_PALLET_BALANZA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.balanza")),
	REGISTRAR_PESO_PALLET(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.registrar.peso")),
	ENCERAR_PESO_PALLET(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.encerar.peso")),
	;
	
	String accion;
	
	EnumAccionesPallet(String accion){
		this.accion = accion;
	}
	public String getAccion() {
		return accion;
	}

	public static EnumAccionesPallet getEnumOrdenRecepcionBodega(String accion) {
		for (EnumAccionesPallet enumAccionesPallet : EnumAccionesPallet.values()) {
			if (enumAccionesPallet.getAccion().equals(accion))  {
				return enumAccionesPallet;
			}
		}
		return null;
	}
}
