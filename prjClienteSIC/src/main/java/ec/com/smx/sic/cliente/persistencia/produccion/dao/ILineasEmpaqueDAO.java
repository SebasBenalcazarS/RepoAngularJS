package ec.com.smx.sic.cliente.persistencia.produccion.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.produccion.lineasEmpaque.filtros.IPlantillaBusquedaLineasEmpaque;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueFuncionarioDTO;

public interface ILineasEmpaqueDAO {
	
	public Long obtenerTotalLineasEmpaque(final LineaEmpaqueDTO lineaEmpaqueDTO, IPlantillaBusquedaLineasEmpaque filtrosBusqueda) throws SICException;
	
	public Collection<LineaEmpaqueDTO> buscarLineasEmpaque(final LineaEmpaqueDTO lineaEmpaqueDTO, final IPlantillaBusquedaLineasEmpaque filtrosBusqueda,
			   final Integer firstResult, final Integer pageSize, final Boolean countAgain);
	
	public Collection<LineaEmpaqueDTO> buscarOtrasLineasEmpaque(LineaEmpaqueDTO lineaEmpaqueDTO,
			   final Integer firstResult, final Integer pageSize, final Boolean countAgain, final String codigoArticulo) throws SICException;
	
	public Collection<LineaEmpaqueFuncionarioDTO> buscarFuncionariosLineaEmpaque(Integer codigoLineaEmpaque)throws SICException;
	
	public FuncionarioAreaTrabajoDTO buscarFuncionario(IPlantillaBusquedaLineasEmpaque filtrosBusqueda, Integer codigoAreaTrabajo) throws SICException;
	
	 public Collection<FuncionarioAreaTrabajoDTO> buscarFuncionarios(IPlantillaBusquedaLineasEmpaque filtrosBusqueda, 
			   final Integer codigoAreaTrabajo, final Integer firstResult, final Integer pageSize, final Boolean countAgain) throws SICException;
	 
	 public Long obtenerTotalArticulos(ArticuloDTO articuloDTO, IPlantillaBusquedaLineasEmpaque filtrosBusqueda) throws SICException;
	
	 public Collection<ArticuloDTO> buscarArticulos(ArticuloDTO articuloDTO, IPlantillaBusquedaLineasEmpaque filtrosBusqueda,
			   Integer firstResult, Integer pageSize, Boolean countAgain) throws SICException;
	 
	 public ArticuloDTO buscarArticuloPorCodigoBarras(ArticuloDTO articuloDTO, IPlantillaBusquedaLineasEmpaque filtrosBusqueda) throws SICException;
	 
	 public Collection<LineaEmpaqueArticuloDTO> buscarArticulosLineaEmpaque(LineaEmpaqueArticuloDTO lineaEmpaqueArticuloDTO) throws SICException;
	 
	 public Long obtenerTotalFuncionarios(Integer codigoAreaTrabajo, IPlantillaBusquedaLineasEmpaque filtrosBusqueda) throws SICException;
	 
	 public void guardarLineaEmpaque(LineaEmpaqueDTO lineaEmpaqueDTO) throws SICException;
	 
	 public void guardarArticuloOtrasLE(Collection<LineaEmpaqueArticuloDTO> articuloLineasDisponiblesDTO, 
			   Collection<LineaEmpaqueArticuloDTO> articuloLineasAsignadasDTO) throws SICException;
	 
	 public void actualizarLineaEmpaque(LineaEmpaqueDTO lineaEmpaqueDTO)throws SICException;
	 
	 
	 public Collection<LineaEmpaqueDTO> buscarLineasEmpaqueDisponibles(final LineaEmpaqueDTO lineaEmpaqueDTO, final String codigoArticulo, final Integer firstResult, final Integer pageSize, final Boolean countAgain) throws SICException;
	 
	 public Collection<LineaEmpaqueDTO> buscarLineasEmpaqueAsignadas(final LineaEmpaqueDTO lineaEmpaqueDTO, final String codigoArticulo, final Integer firstResult, final Integer pageSize, final Boolean countAgain) throws SICException;
}
