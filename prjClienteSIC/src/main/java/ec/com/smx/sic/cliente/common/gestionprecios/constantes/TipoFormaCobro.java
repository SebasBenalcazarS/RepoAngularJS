package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.common.convenio.ConveniosConstantes;

public enum TipoFormaCobro {
	
	MONTO_FIJO(ConveniosConstantes.MONTO_FIJO), 
	PORCENTAJE(ConveniosConstantes.PORCENTAJE) ;
	
	private String valorTipoFormaCobro ;
	
	private TipoFormaCobro (String valorTipoFormaCobro){
		this.valorTipoFormaCobro = valorTipoFormaCobro;
	}

	public String getValorTipoFormaCobro() {
		return valorTipoFormaCobro;
	}

}
