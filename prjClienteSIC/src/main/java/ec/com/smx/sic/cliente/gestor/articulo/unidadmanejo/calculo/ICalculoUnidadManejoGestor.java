package ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;

public interface ICalculoUnidadManejoGestor {

//	/**
//	 * Metodo que permite construur las unidades de manejo en base a los usos
//	 * 
//	 * @param unidadesManejo
//	 * @return
//	 * @throws SICRuleException
//	 */
//	public abstract Collection<ArticuloUnidadManejoDTO> construirUnidadesManejo(Collection<ArticuloUnidadManejoDTO> unidadesManejoCol) throws SICRuleException;

	public abstract void relacionarUnidadManejoPrecio(ArticuloDTO articuloDTO, Collection<ArticuloUnidadManejoDTO> unidades);

	/**
	 * 
	 * @param aum
	 * @throws SICRuleException
	 */
	public abstract void asignarCamposUnidadManejo(ArticuloUnidadManejoDTO aum);

	/**
	 * 
	 * @param aum
	 * @throws SICRuleException
	 */
	public abstract void asignarCamposUnidadManejoUso(ArticuloUnidadManejoUsoDTO dto);

}