package ec.com.smx.sic.cliente.gestor.produccion.administracion.lineasEmpaque;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminLineaEmpaqueVO;


/**
 * Interface de acceso a datos para lineas de empaque
 * 
 * @author srodriguez
 */
public interface ILineasEmpaqueGestor {
	
public AdminLineaEmpaqueVO buscarLineasEmpaque(final AdminLineaEmpaqueVO adminLineaEmpaqueVO) throws SICException;
	
	public void actualizarLineaEmpaque(final LineaEmpaqueDTO lineaEmpaqueDTO) throws SICException;
	
	public void guardarLineaEmpaque(final AdminLineaEmpaqueVO adminLineaEmpaqueVO) throws SICException;	
	
	public Collection<LineaEmpaqueArticuloDTO> buscarArticulosLineaEmpaque(final LineaEmpaqueArticuloDTO lineaEmpaqueArticuloDTO) throws SICException;
	
	public AdminLineaEmpaqueVO buscarArticulos(final AdminLineaEmpaqueVO adminLineaEmpaqueVO) throws SICException;
	
	public AdminLineaEmpaqueVO buscarOtrasLineasEmpaque(final AdminLineaEmpaqueVO adminLineaEmpaqueVO) throws SICException;
	
	public AdminLineaEmpaqueVO buscarFuncionarios(final AdminLineaEmpaqueVO adminLineaEmpaqueVO) throws SICException;
	
	public Collection<LineaEmpaqueFuncionarioDTO> buscarFuncionariosLineaEmpaque(final Integer codigoLineaEmpaque) throws SICException;
	
	public AdminLineaEmpaqueVO buscarLineasEmpaqueDisponibles(final AdminLineaEmpaqueVO adminLineaEmpaqueVO) throws SICException;
	
	public AdminLineaEmpaqueVO buscarLineasEmpaqueAsignadas(final AdminLineaEmpaqueVO adminLineaEmpaqueVO) throws SICException;
	
}
