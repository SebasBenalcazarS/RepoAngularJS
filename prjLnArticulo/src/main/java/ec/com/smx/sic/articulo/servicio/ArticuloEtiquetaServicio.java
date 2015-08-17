package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.etiquetado.IArticuloControlEtiquetadoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoArticuloDTO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloEtiquetaServicio;

public class ArticuloEtiquetaServicio implements IArticuloEtiquetaServicio {
	
	private IArticuloControlEtiquetadoGestor articuloControlEtiquetado;

	@Override
	public Collection<ArticuloEtiquetaDTO> obtenerArticuloEtiquetaPorTipo(Integer codigoCompania, Long codigoEtiqueta, String codigoTipoArticulo) throws SICException {
		return this.articuloControlEtiquetado.obtenerArticuloEtiquetaPorTipo(codigoCompania, codigoEtiqueta, codigoTipoArticulo);
	}
	
	@Override
	public Collection<TipoArticuloDTO> obtenerArticuloRecipientes(Integer codigoCompania, String codigoArticuloTipoPadre) throws SICException {
		return this.articuloControlEtiquetado.obtenerArticuloRecipientes(codigoCompania, codigoArticuloTipoPadre);
	}
	
	public void setArticuloControlEtiquetado(IArticuloControlEtiquetadoGestor articuloControlEtiquetado) {
		this.articuloControlEtiquetado = articuloControlEtiquetado;
	}

	@Override
	public Integer obtenerSecuencialArticuloEtiqueta(Integer codigoCompania, String codigoArticulo, Long codigoEtiqueta) throws SICException {
		return this.articuloControlEtiquetado.obtenerSecuencialArticuloEtiqueta(codigoCompania, codigoArticulo, codigoEtiqueta);
	}

	@Override
	public void actualizarArticuloEtiquetaDTO(ArticuloEtiquetaDTO articuloEtiquetaDTO) throws SICException {
		this.articuloControlEtiquetado.actualizarArticuloEtiquetaDTO(articuloEtiquetaDTO);
		
	}


}
