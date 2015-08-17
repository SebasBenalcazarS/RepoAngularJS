package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.common.convenio.ConveniosConstantes;

public enum TipoInicioCobroNegociacion {

	VALOR_TIPO_INICIO_COBRO_INICIO_PROMOCION(ConveniosConstantes.VALOR_TIPO_INICIO_COBRO_INICIO_PROMOCION), 
	VALOR_TIPO_INICIO_COBRO_FIN_PROMOCION(ConveniosConstantes.VALOR_TIPO_INICIO_COBRO_FIN_PROMOCION), 
	VALOR_TIPO_INICIO_COBRO_FECHA_ESPECIFICA_PROMOCION(ConveniosConstantes.VALOR_TIPO_INICIO_COBRO_FECHA_ESPECIFICA_PROMOCION);
	String valorTipoInicioCobro;

	private TipoInicioCobroNegociacion(String valorTipoInicioCobro) {
		this.valorTipoInicioCobro = valorTipoInicioCobro;
	}

	public String getValorTipoInicioCobro() {
		return valorTipoInicioCobro;
	}
}
