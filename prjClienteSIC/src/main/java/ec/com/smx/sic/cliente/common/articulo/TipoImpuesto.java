package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

public interface TipoImpuesto {
	 public Integer IVA = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.tipo.impuesto.iva");
	 public Integer IVE = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.tipo.impuesto.ive");
	 public Integer ICE = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.tipo.impuesto.ice"); 
}
