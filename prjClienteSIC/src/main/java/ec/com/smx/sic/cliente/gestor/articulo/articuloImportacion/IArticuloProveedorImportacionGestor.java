package ec.com.smx.sic.cliente.gestor.articulo.articuloImportacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;

public interface IArticuloProveedorImportacionGestor {
	public void registrarArticuloImportacion(ArticuloProveedorDTO articuloProveedorDTO, Boolean esCreacion) throws SICException;
	public void registrarArticuloImportacion(ArticuloImportacionDTO articuloImportacionDTO, Boolean esCreacion, String descripcionArticulo) throws SICException;	
	public void registrarArticuloImportacion(Collection<ArticuloImportacionDTO> articuloImportacionCol, String descripcionArticulo) throws SICException;
	void verificarArticuloImportacionHistorico(ArticuloImportacionDTO articuloImportacionDTO, Boolean esEdicionMasiva) throws SICException;
}
