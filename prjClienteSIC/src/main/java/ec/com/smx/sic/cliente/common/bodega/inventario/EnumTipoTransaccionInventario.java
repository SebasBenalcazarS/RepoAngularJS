package ec.com.smx.sic.cliente.common.bodega.inventario;

public enum EnumTipoTransaccionInventario {
	INICIALIZACION_INVENTARIO_FISICO(551);
	EnumTipoTransaccionInventario(Integer codigoInterno){
		this.codigoInterno = codigoInterno;
	}
	private final Integer codigoInterno;
	
	public Integer getCodigoInterno() {
		return codigoInterno;
	}
	
}
