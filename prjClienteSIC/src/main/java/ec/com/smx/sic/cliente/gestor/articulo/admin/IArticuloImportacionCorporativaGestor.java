package ec.com.smx.sic.cliente.gestor.articulo.admin;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloImportadoVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IArticuloImportacionCorporativaGestor {

	ArticuloDTO registrarArticuloImportado(ArticuloImportadoVO articuloImportadoVO, boolean generarNovedadImportacion, boolean realizarIntegracion) throws SICException;

	/**
	 * Setea datos relacionados al alcance
	 * en locales y bodegas del articulo
	 * importado
	 * @param articuloVO
	 * @param articuloImportadoVOClon
	 * @param clasificacionDTO
	 * @throws SICException
	 */
	void validarDatosAlcanceArticuloImportado(ArticuloVO articuloVO, ArticuloImportadoVO articuloImportadoVOClon, ClasificacionDTO clasificacionDTO) throws SICException;

}
