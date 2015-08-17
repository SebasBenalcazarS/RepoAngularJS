package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.produccion.lineasEmpaque.filtros.IPlantillaBusquedaLineasEmpaque;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueDTO;

@SuppressWarnings({ "serial", "deprecation" })
public class AdminLineaEmpaqueVO  extends BaseVO<LineaEmpaqueDTO>{

	private LineaEmpaqueDTO lineaEmpaqueDTO;
	private Collection<LineaEmpaqueDTO> lineasEmpaqueDTO;
	private IPlantillaBusquedaLineasEmpaque filtrosBusqueda;
	private Collection<LineaEmpaqueArticuloDTO> articulosLineaEmpaque;
	private Collection<LineaEmpaqueArticuloDTO> articuloLineasDisponiblesDTO;
	private Collection<LineaEmpaqueArticuloDTO> articuloLineasAsignadasDTO;
	private Collection<ArticuloDTO> articulosDTO;
	private ArticuloDTO articuloDTO;
	private String codigoArticulo;
	
	private Collection<FuncionarioAreaTrabajoDTO> funcionariosAreaTrabajoDTO;
	private FuncionarioAreaTrabajoDTO funcionarioAreaTrabajoDTO;
	private Integer codigoAreaTrabajo;
	
	private Long totalRegistros;
	
	
	public LineaEmpaqueDTO getLineaEmpaqueDTO() {
		return lineaEmpaqueDTO;
	}
	
	public void setLineaEmpaqueDTO(LineaEmpaqueDTO lineaEmpaqueDTO) {
		this.lineaEmpaqueDTO = lineaEmpaqueDTO;
	}
	
	public Collection<LineaEmpaqueDTO> getLineasEmpaqueDTO() {
		return lineasEmpaqueDTO;
	}

	public void setLineasEmpaqueDTO(Collection<LineaEmpaqueDTO> lineasEmpaqueDTO) {
		this.lineasEmpaqueDTO = lineasEmpaqueDTO;
	}

	public IPlantillaBusquedaLineasEmpaque getFiltrosBusqueda() {
		return filtrosBusqueda;
	}

	public void setFiltrosBusqueda(IPlantillaBusquedaLineasEmpaque filtrosBusqueda) {
		this.filtrosBusqueda = filtrosBusqueda;
	}

	public Collection<LineaEmpaqueArticuloDTO> getArticuloLineasDisponiblesDTO() {
		return articuloLineasDisponiblesDTO;
	}

	public void setArticuloLineasDisponiblesDTO(Collection<LineaEmpaqueArticuloDTO> articuloLineasDisponiblesDTO) {
		this.articuloLineasDisponiblesDTO = articuloLineasDisponiblesDTO;
	}

	public Collection<LineaEmpaqueArticuloDTO> getArticuloLineasAsignadasDTO() {
		return articuloLineasAsignadasDTO;
	}

	public void setArticuloLineasAsignadasDTO(Collection<LineaEmpaqueArticuloDTO> articuloLineasAsignadasDTO) {
		this.articuloLineasAsignadasDTO = articuloLineasAsignadasDTO;
	}

	public Collection<ArticuloDTO> getArticulosDTO() {
		return articulosDTO;
	}

	public void setArticulosDTO(Collection<ArticuloDTO> articulosDTO) {
		this.articulosDTO = articulosDTO;
	}

	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Collection<FuncionarioAreaTrabajoDTO> getFuncionariosAreaTrabajoDTO() {
		return funcionariosAreaTrabajoDTO;
	}

	public void setFuncionariosAreaTrabajoDTO(Collection<FuncionarioAreaTrabajoDTO> funcionariosAreaTrabajoDTO) {
		this.funcionariosAreaTrabajoDTO = funcionariosAreaTrabajoDTO;
	}

	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	public FuncionarioAreaTrabajoDTO getFuncionarioAreaTrabajoDTO() {
		return funcionarioAreaTrabajoDTO;
	}

	public void setFuncionarioAreaTrabajoDTO(FuncionarioAreaTrabajoDTO funcionarioAreaTrabajoDTO) {
		this.funcionarioAreaTrabajoDTO = funcionarioAreaTrabajoDTO;
	}

	public void setTotalRegistros(Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public Long getTotalRegistros() {
		return totalRegistros;
	}

	public Collection<LineaEmpaqueArticuloDTO> getArticulosLineaEmpaque() {
		return articulosLineaEmpaque;
	}

	public void setArticulosLineaEmpaque(Collection<LineaEmpaqueArticuloDTO> articulosLineaEmpaque) {
		this.articulosLineaEmpaque = articulosLineaEmpaque;
	}

	
}
