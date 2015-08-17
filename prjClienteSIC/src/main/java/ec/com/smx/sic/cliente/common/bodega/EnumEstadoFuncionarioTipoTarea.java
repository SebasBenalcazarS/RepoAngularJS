package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos del estado que puede tener el
 * funcionario deacuerdo al tipo de tarea que esta realizando
 * OCU El funcionario esta en receso 
 * DIS El funcionario esta disponible
 * 
 * @author wcaiza
 *
 */
public enum EnumEstadoFuncionarioTipoTarea {
	
	LIBRE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.valor.estado.funcionario.libre")),
	OCUPADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.valor.estado.funcionario.ocupado")),
	RECESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.valor.estado.funcionario.receso")),
	ALMUERZO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.valor.estado.funcionario.almuerzo"));
	
	private String codigoCatalogoValor;
	
	private EnumEstadoFuncionarioTipoTarea(String codigoCatalogoValor){
		this.codigoCatalogoValor = codigoCatalogoValor;
	}
	
	/**
	 * @return the codigoCatalogoValor
	 */
	public String getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}
	
}
