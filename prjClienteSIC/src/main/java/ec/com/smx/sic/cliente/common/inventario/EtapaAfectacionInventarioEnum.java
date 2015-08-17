package ec.com.smx.sic.cliente.common.inventario;

import ec.com.smx.sic.cliente.resources.inventario.SICInventarioMessages;

/**
 * Constantes para el manejo de catalogo valor etapa afectacion
 * @author osaransig
 * Jun 20, 2014
 */
public enum EtapaAfectacionInventarioEnum {

	//ETAPA DE AFECTACION AL INVENTARIO, ORIGEN O DESTINO TOMANDO COMO REFERENCIA DONDE SE EJECUTA LA TRANSACCION COMO ORIGEN;
  	ETAPA_AFECTACION_INVENTARIO_ORIGEN(SICInventarioMessages.getInstancia().getString("ec.com.smx.sic.inventario.etapaafectacion.origen")),
  	ETAPA_AFECTACION_INVENTARIO_DESTINO(SICInventarioMessages.getInstancia().getString("ec.com.smx.sic.inventario.etapaafectacion.destino")),
	ETAPA_AFECTACION_INVENTARIO_TIPO(SICInventarioMessages.getInstancia().getString("ec.com.smx.sic.inventario.etapaafectacion.tipo"));

	private String codigoCatalogoValor;

	private EtapaAfectacionInventarioEnum(final String codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}

	public String getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}

	public void setCodigoCatalogoValor(final String codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}

}
