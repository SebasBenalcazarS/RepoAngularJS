/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.vo.FuncionarioVO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.articulo.EnumFormatoImpresionRegSan;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.BitacoraRevisionRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;

/**
 * @author fmunoz
 *
 */
public interface IArticuloRegistroSanitarioServicio {

	void registrarRegistroSanitarioArticulo(Collection<RelacionArticuloRegistroSanitarioDTO> artRegSanCol) throws SICException;
	
	void registrarRegistroSanitarioArticulo(RelacionArticuloRegistroSanitarioDTO artRegSan) throws SICException;
	
	SearchResultDTO<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitarioPaginados(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException;
	
	Collection<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitario(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException;
	
	Collection<BitacoraRevisionRegistroSanitarioDTO> obtenerBitacoraRevisioRegistroSanitario(BitacoraRevisionRegistroSanitarioDTO bitacoraRevisionRegSan) throws SICException;
	
	Map<String, Integer> asignarNivelesConcentracionSemaforo(Collection<RelacionArticuloRegistroSanitarioDTO> registros)throws SICException;
	
	void generarArchivoImpresion(RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO,UserDto userDto,EnumFormatoImpresionRegSan enumFormatoImpresionRegSan,String remoteHost,FuncionarioVO funcionarioVO) throws SICException;
	
	
	
	/**
	 * Busqueda de registros sanitarios por articulo
	 * @param articuloDTO
	 * @return
	 */
	Collection<ArticuloRegistroSanitarioDTO> buscarRegistrosSanitariosActivos(ArticuloDTO articuloDTO) throws SICException;

	
}
