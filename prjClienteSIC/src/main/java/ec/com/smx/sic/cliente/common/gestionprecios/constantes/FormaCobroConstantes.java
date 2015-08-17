package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.common.convenio.ConveniosConstantes;

public enum FormaCobroConstantes {
	
	 FACTURA (ConveniosConstantes.FACTURA),
	 ORDEN_COMPRA(ConveniosConstantes.ORDEN_COMPRA), 
	 COSTO (ConveniosConstantes.COSTO);
	 
	 private String valorFormaCobro;
	 private FormaCobroConstantes (String valorFormaCobro){
		 this.valorFormaCobro = valorFormaCobro;
	 }
	public String getValorFormaCobro() {
		return valorFormaCobro;
	}
	 
	 
}
