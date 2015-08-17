/**
 * 
 */
package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.annotations.NoTransaction;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.validacion.IValidacionUnidadManejoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloValidacionServicio;

/**
 * @author fmunoz
 *
 */
public class ArticuloValidacionServicio implements IArticuloValidacionServicio{

	private IValidacionArticuloGestor validacionArticuloGestor;
	private IValidacionUnidadManejoGestor validacionUnidadManejoGestor;

	@NoTransaction
	public Boolean esRequeridoPesoAproximado(String tipoControlCosto) {
		return this.validacionArticuloGestor.esRequeridoPesoAproximado(tipoControlCosto);
	}

	/**
	 * Verifica si los c�digos de barras de las unidades de manejo est�n en otros art�culos actualmente
	 * @param idArticulo
	 * @param unidades
	 * @return
	 */
	@Override
	public Collection<ArticuloUnidadManejoDTO> validarUnicidadEAN14(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> unidades)throws SICException{
		return validacionUnidadManejoGestor.validarUnicidadEAN14(articuloVO, unidades);
	}
	
	/**
	* @see IArticuloValidacionServicio#validarCondigoEANunico(String, Integer)
	*/ 
	@Override
	public void validarCondigoEANunico(String codigoEAN, Integer codigoCompania) throws SICException {
		validacionUnidadManejoGestor.validarCondigoEANunico(codigoEAN, codigoCompania);
	}
	
	/**
	 * 
	 * @param sca
	 * @return
	 */
	public void validarPasoCreacion(SegmentoCreacionArticuloDTO sca, ArticuloVO articuloVO){
		validacionArticuloGestor.validarPasoCreacion(sca, articuloVO);
	}
	
	/**
	 * @param validacionArticuloGestor the validacionArticuloGestor to set
	 */
	public void setValidacionArticuloGestor(IValidacionArticuloGestor validacionArticuloGestor) {
		this.validacionArticuloGestor = validacionArticuloGestor;
	}

	/**
	 * @param validacionUnidadManejoGestor the validacionUnidadManejoGestor to set
	 */
	public void setValidacionUnidadManejoGestor(IValidacionUnidadManejoGestor validacionUnidadManejoGestor) {
		this.validacionUnidadManejoGestor = validacionUnidadManejoGestor;
	}
	
	public void validarRangoSecuenciaCodigoInterno(ArticuloDTO articuloDTO)throws SICException{
		this.validacionArticuloGestor.validarRangoSecuenciaCodigoInterno(articuloDTO);
	}

}
