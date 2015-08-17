package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioLineaComercial;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioTipoMarca;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.VistaAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.id.AreaTrabajoID;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.lineacomercial.ILineaComercialGestor;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaFuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.ClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.LineaComercialVO;
import ec.com.smx.sic.cliente.servicio.articulo.ILineaComercialServicio;

public class LineaComercialServicio implements ILineaComercialServicio{

	private ILineaComercialGestor lineaComercialGestor;
	
	@Override
	public void crearLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		lineaComercialGestor.crearLineaComercial(lineaComercialDTO);
	}

	@Override
	public void actualizarLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		lineaComercialGestor.actualizarLineaComercial(lineaComercialDTO);
	}

	@Override
	public void crearLineaComercialClasificacion(LineaComercialDTO lineaComercialDTO) throws SICException {
		lineaComercialGestor.crearLineaComercialClasificacion(lineaComercialDTO);
	}

	@Override
	public void eliminarLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		lineaComercialGestor.eliminarLineaComercial(lineaComercialDTO);
	}

	@Override
	public void eliminarLineaComercialClasificacion(Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol,LineaComercialDTO lineaComercialDTO, String userId) throws SICException {
		lineaComercialGestor.eliminarLineaComercialClasificacion(lineaComercialClasificacionCol, lineaComercialDTO, userId);
	}
	
	@Override
	public void eliminarLineaComercialFuncionarios(Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioCol,LineaComercialDTO lineaComercialDTO, String userId) throws SICException {
		lineaComercialGestor.eliminarLineaComercialFuncionarios(lineaComercialFuncionarioCol, lineaComercialDTO, userId);
	}

	@Override
	public void crearLineaComercialFuncionario(LineaComercialDTO lineaComercialDTO,Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTOs) throws SICException{
		lineaComercialGestor.crearLineaComercialFuncionario(lineaComercialDTO,lineaComercialFuncionarioDTOs);
	}
	
	@Override
	public void crearFuncionarioTipoMarca(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException{
		lineaComercialGestor.crearFuncionarioTipoMarca(lineaComercialFuncionarioDTO);
	}
	
	@Override
	public Collection<LineaComercialDTO> obtenerLineasComerciales(LineaComercialVO lineaComercialVO) throws SICException{
		return lineaComercialGestor.obtenerLineasComerciales(lineaComercialVO);
	}
	
	@Override
	public Collection<LineaComercialFuncionarioDTO> obtenerFuncionariosPorLineaComercial(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction>  restrictionMap) throws SICException{
		return lineaComercialGestor.obtenerFuncionariosPorLineaComercial(codigoCompania, codigoLineaComercial, estado, restrictionMap);
	}	
	
	@Override
	public 	Collection<LineaComercialFuncionarioDTO> obtenerLineasComercialesPorFuncionario(Integer codigoCompania, String codigoFuncionario) throws SICException{
		return lineaComercialGestor.obtenerLineasComercialesPorFuncionario(codigoCompania, codigoFuncionario);
	}
	
	@Override
	public Boolean validarFuncionarioLineaComercial(FuncionarioDTO funcionarioDTO) throws SICException {
		return lineaComercialGestor.validarFuncionarioLineaComercial(funcionarioDTO);
	}
	
	@Override
	public void eliminarLineaComercialFuncionario(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException{
		lineaComercialGestor.eliminarLineaComercialFuncionario(lineaComercialFuncionarioDTO);
	}
	
	@Override
	public void activarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException{
		lineaComercialGestor.activarLineaComercial(lineaComercialDTO);
	}
	
	@Override
	public void asignarTiposMarca(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO, List<String> marcasNuevas)throws Exception{
		lineaComercialGestor.asignarTiposMarca(lineaComercialFuncionarioDTO, marcasNuevas);
	}
	
	@Override
	public String reasignarClasificacionesLineaComercial (LineaComercialDTO lineaComercialDTO, Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol)throws SICException{
		return lineaComercialGestor.reasignarClasificacionesLineaComercial(lineaComercialDTO, lineaComercialClasificacionCol);
	}
	
	@Override
	public void crearMarcasFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO, Collection<MarcaArticuloDTO> marcasAsignadas)throws SICException{
		lineaComercialGestor.crearMarcasFuncionarioTipoMarca(funcionarioTipoMarcaDTO, marcasAsignadas);
	}
	
	@Override
	public void eliminarMarcaFuncionarioTipoMarca(MarcaFuncionarioTipoMarcaDTO marcaFuncionarioTipoMarcaDTO)throws SICException{
		lineaComercialGestor.eliminarMarcaFuncionarioTipoMarca(marcaFuncionarioTipoMarcaDTO);
	}
	
	@Override
	public void eliminarMarcaFuncionarioTipoMarca(Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol, String userId)throws SICException{
		lineaComercialGestor.eliminarMarcaFuncionarioTipoMarca(marcaFuncionarioTipoMarcaCol, userId);
	}
	
	@Override
	public void eliminarFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO)throws SICException{
		lineaComercialGestor.eliminarFuncionarioTipoMarca(funcionarioTipoMarcaDTO);
	}
	
	@Override
	public Collection<LineaComercialClasificacionDTO> crearObtenerLineaComercialClasificacionAsignadas(String userId,LineaComercialDTO lineaComercialDTO)throws SICException{
		return lineaComercialGestor.crearObtenerLineaComercialClasificacionAsignadas(userId,lineaComercialDTO);
	}
	
	@Override
	public Collection<LineaComercialClasificacionDTO> obtenerClasificacionesFuncionario(Long codigoLineaComercial, Long codigoLineaComercialFuncionario)throws SICException{
		return lineaComercialGestor.obtenerClasificacionesFuncionario(codigoLineaComercial, codigoLineaComercialFuncionario);
	}
	
	@Override
	public void guardarLineaComercialFuncionarioClasificacion(Collection<LineaComercialFuncionarioClasificacionDTO> lineaComercialFuncionarioClasificacionDTOs)throws SICException{
		lineaComercialGestor.guardarLineaComercialFuncionarioClasificacion(lineaComercialFuncionarioClasificacionDTOs);
	}
	
	@Override
	public void eliminarLineaComercialFuncionarioClasificacion(LineaComercialFuncionarioClasificacionDTO lineaComercialFuncionarioClasificacionDTO)throws SICException{
		lineaComercialGestor.eliminarLineaComercialFuncionarioClasificacion(lineaComercialFuncionarioClasificacionDTO);
	}

	@Override
	public Collection<InformacionFuncionarioTipoMarca> consultarFuncionarioTipoMarca(FuncionarioDTO funcionarioDTO) throws SICException {
		return lineaComercialGestor.consultarFuncionarioTipoMarca(funcionarioDTO);
	}
	
	@Override
	public Collection<InformacionFuncionarioLineaComercial> consultarFuncionarioLineasComerciales(FuncionarioDTO funcionarioDTO) throws SICException{
		return lineaComercialGestor.consultarFuncionarioLineasComerciales(funcionarioDTO);
	}
	
	@Override
	public void addCriterioRestriccionPerfilColaborador(SearchDTO searchDTO)throws SICException{
		lineaComercialGestor.addCriterioRestriccionPerfilColaborador(searchDTO);
	}
	@Override
	public void addCriterioRestriccionCodigoReferencia(LineaComercialDTO searchDTO){
		lineaComercialGestor.addCriterioRestriccionCodigoReferencia(searchDTO);
	}
	/**
	 * @return the lineaComercialGestor
	 */
	public ILineaComercialGestor getLineaComercialGestor() {
		return lineaComercialGestor;
	}

	/**
	 * @param lineaComercialGestor the lineaComercialGestor to set
	 */
	public void setLineaComercialGestor(ILineaComercialGestor lineaComercialGestor) {
		this.lineaComercialGestor = lineaComercialGestor;
	}
	
	@Override
	public Collection<VistaAreaTrabajoDTO> findAreasTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<String> tiposAreaTrabajo) throws SICException{
		return lineaComercialGestor.findAreasTrabajo(areaTrabajoDTO, tiposAreaTrabajo);
	}

	@Override
	public Collection<Integer> consultarAreaTrabajoPorFuncionario(Collection<Integer> listaCodigoReferencia, String tipoAreaTrabajoValor, Integer tipoAreaTrabajoTIC, String codigoFuncionario) throws SICException {
		return lineaComercialGestor.consultarAreaTrabajoPorFuncionario(listaCodigoReferencia, tipoAreaTrabajoValor, tipoAreaTrabajoTIC, codigoFuncionario);
	}
	
	@Override
	public Collection<VistaAreaTrabajoPerfilDTO> findAreasTrabajoPerfil(AreaTrabajoID areaTrabajoID)throws SICException{
		return lineaComercialGestor.findAreasTrabajoPerfil(areaTrabajoID);
	}
	@Override
	public  Collection<String> buscarProcesoPerfil()throws SICException{
		return lineaComercialGestor.buscarProcesoPerfil();
	}
	public Collection<ClienteImportacionDTO> consultarClienteImportacion()throws SICException{
		return lineaComercialGestor.consultarClienteImportacion();
	}
	public void guardarClienteImportacionLineaComercial(LineaComercialDTO linComDTO,Collection<ClienteImportacionDTO> clienteImpDTOCol,Integer codigoCompania,String userID)throws SICException{
		 lineaComercialGestor.guardarClienteImportacionLineaComercial(linComDTO, clienteImpDTOCol, codigoCompania, userID);
	}
	public Collection<LineaComercialClienteImportacionDTO> consultarLinComClienImp(LineaComercialDTO lineaComercialDTO)throws SICException{
		return lineaComercialGestor.consultarLinComClienImp(lineaComercialDTO);
	}
	public void actualizarLinComClienImp(Collection<LineaComercialClienteImportacionDTO> linComCliImpDTOCol,String estado,String userId)throws SICException{
		lineaComercialGestor.actualizarLinComClienImp(linComCliImpDTOCol,estado,userId);
	}
	public boolean validarClienImpLinComEstFilial(Long codigoClienteImportacion,Integer codigoCompania)throws SICException{
		return lineaComercialGestor.validarClienImpLinComEstFilial(codigoClienteImportacion, codigoCompania);
	}
	
	@Override
	public  Collection<LineaComercialClasificacionDTO> buscarClasificacionesLinCom(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction>  restrictionMap)throws SICException{
		return lineaComercialGestor.buscarClasificacionesLinCom(codigoCompania, codigoLineaComercial, estado, restrictionMap);
	} 
	
	@Override
	public Long contarLineaComercialClasificacion(Integer codigoCompania, Long codigoLineaComercial) throws SICException{
		return lineaComercialGestor.contarLineaComercialClasificacion(codigoCompania, codigoLineaComercial);
	}
}
