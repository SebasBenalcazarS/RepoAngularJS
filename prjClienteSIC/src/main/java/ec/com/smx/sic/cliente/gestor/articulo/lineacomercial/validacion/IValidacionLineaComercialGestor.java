package ec.com.smx.sic.cliente.gestor.articulo.lineacomercial.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaFuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.vo.LineaComercialVO;

/**
 * 
 * @author fcollaguazo
 *
 */
public interface IValidacionLineaComercialGestor {

	public abstract void crearLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException;

	public abstract void actualizarLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException;

	public abstract void crearLineaComercialClasificacion(LineaComercialDTO lineaComercialDTO) throws SICException;

	public abstract void eliminarLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException;

	public abstract void eliminarLineaComercialClasificacion(Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol, LineaComercialDTO lineaComercialDTO, String userId) throws SICException;
	
	public abstract void crearLineaComercialFuncionario(LineaComercialDTO lineaComercialDTO) throws SICException;
	
	public abstract void obtenerLineasComerciales(LineaComercialVO lineaComercialVO)throws SICException;
	
	public abstract void eliminarLineaComercialFuncionario(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException;
	
	public abstract void activarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException;
	
	public abstract void asignarTiposMarca(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws Exception;
	
	public abstract void reasignarClasificacionesLineaComercial (LineaComercialDTO lineaComercialDTO, Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol)throws SICException;
	
	public abstract void crearMarcasFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO, Collection<MarcaArticuloDTO> marcasAsignadas)throws SICException;
	
	public abstract void eliminarMarcaFuncionarioTipoMarca(MarcaFuncionarioTipoMarcaDTO marcaFuncionarioTipoMarcaDTO)throws SICException;
	
	public abstract void eliminarMarcaFuncionarioTipoMarca(Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol, String userId)throws SICException;
	
	public abstract void eliminarFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO)throws SICException;
}