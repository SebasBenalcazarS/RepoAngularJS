package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.common.convenio.ConveniosConstantes;

public enum PerioricidadesCorte {

	SEMANAL(ConveniosConstantes.SEMANAL), 
	QUINCENAL(ConveniosConstantes.QUINCENAL), 
	MENSUAL(ConveniosConstantes.MENSUAL); 

	private String valorPerioricidad;

	private PerioricidadesCorte(String valorPerioricidad) {
		this.valorPerioricidad = valorPerioricidad;
	}

	public String getValorPerioricidad() {
		return valorPerioricidad;
	}

}
