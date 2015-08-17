package ec.com.smx.sic.articulo.gestor.lineacomercial.validacion;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.lineacomercial.validacion.IValidacionLineaComercialGestor;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaFuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.vo.LineaComercialVO;

/**
 * Validaciones de la linea comercial
 * @author fcollaguazo
 *
 */
public class ValidacionLineaComercialGestor implements IValidacionLineaComercialGestor {

	@Override
	public void crearLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		if(lineaComercialDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(StringUtils.isEmpty(lineaComercialDTO.getNombre())){
			throw new SICException("El nombre de la linea comercial se encuentra vacia");
		}
		if(lineaComercialDTO.getId().getCodigoCompania()==null){
			throw new SICException("El codigo de la compania se encuentra vacia");
		}
		if(lineaComercialDTO.getUserId()==null){
			throw new SICException("El usuario de registro se encuentra vacia");
		}
		
	}

	@Override
	public void actualizarLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		if(lineaComercialDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(StringUtils.isEmpty(lineaComercialDTO.getNombre())){
			throw new SICException("El nombre de la linea comercial se encuentra vacia");
		}
		if(lineaComercialDTO.getId().getCodigoCompania()==null){
			throw new SICException("El codigo de la compania se encuentra vacia");
		}
		if(lineaComercialDTO.getCodigoEstablecimiento()==null){
			throw new SICException("El codigo del establecimiento se encuentra vacio");
		}
		if(lineaComercialDTO.getUserId()==null){
			throw new SICException("El usuario de registro se encuentra vacia");
		}
	}

	@Override
	public void crearLineaComercialClasificacion(LineaComercialDTO lineaComercialDTO) throws SICException {
		if(lineaComercialDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialDTO.getId().getCodigoCompania()==null){
			throw new SICException("El codigo de la compania se encuentra vacia");
		}
		if(lineaComercialDTO.getUserId()==null){
			throw new SICException("El usuario de registro se encuentra vacia");
		}
		if(CollectionUtils.isEmpty(lineaComercialDTO.getLineaComercialClasificaciones())&& lineaComercialDTO.getDivisionesCol().isEmpty() && lineaComercialDTO.getDepartamentosCol().isEmpty()){
			throw new SICException("La coleccion de lineaComercialClasificacion se encuentra vacia");
		}
	}
	
	@Override
	public void eliminarLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		if(lineaComercialDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialDTO.getId().getCodigoCompania()==null){
			throw new SICException("El codigo de la compania se encuentra vacia");
		}
		if(lineaComercialDTO.getId().getCodigoLineaComercial()==null){
			throw new SICException("El codigo de la compania se encuentra vacia");
		}
		if(lineaComercialDTO.getUserId()==null){
			throw new SICException("El codigo de la compania se encuentra vacia");
		}
	}

	@Override
	public void eliminarLineaComercialClasificacion(Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol, LineaComercialDTO lineaComercialDTO, String userId) throws SICException {
		if(CollectionUtils.isEmpty(lineaComercialClasificacionCol)){
			throw new SICException("La coleccion de clasificaciones de la linea comercial se encuentra vacia");
		}
		if(StringUtils.isEmpty(userId)){
			throw new SICException("El userId se encuentra vacia");
		}
		if(lineaComercialDTO == null){
			throw new SICException("La linea comercial se encuentra vacia");
		}
		for(LineaComercialClasificacionDTO lineaComercialClasificacionDTO:lineaComercialClasificacionCol){
			if(lineaComercialClasificacionDTO==null){
				throw new SICException("La plantilla se encuentra vacia");
			}
			if(lineaComercialClasificacionDTO.getId().getCodigoClasificacion()==null){
				throw new SICException("El codigo de la clasificacion se encuentra vacia");
			}
			if(lineaComercialClasificacionDTO.getId().getCodigoCompania()==null){
				throw new SICException("El codigo de la compania se encuentra vacia");
			}
			if(lineaComercialClasificacionDTO.getCodigoLineaComercial()==null){
				throw new SICException("El codigo de la linea comercial se encuentra vacia");
			}
		}
	}
	
	@Override
	public void crearLineaComercialFuncionario(LineaComercialDTO lineaComercialDTO) throws SICException {
		if(lineaComercialDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialDTO.getId().getCodigoCompania()==null){
			throw new SICException("El codigo de la compania se encuentra vacia");
		}
		if(lineaComercialDTO.getUserId()==null){
			throw new SICException("El usuario de registro se encuentra vacia");
		}
		if(CollectionUtils.isEmpty(lineaComercialDTO.getLineaComercialFuncionarios())){
			throw new SICException("La coleccion de lineaComercialFuncionarios se encuentra vacia");
		}
		
		//Validamos si posee cada funcionario las marcas
		for(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO:lineaComercialDTO.getLineaComercialFuncionarios()){
			if(CollectionUtils.isEmpty(lineaComercialFuncionarioDTO.getFuncionarioTipoMarcaCol())){
				throw new SICException("La coleccion de funcionarioTipoMarcaCol se encuentra vacia");
			}
		}
	}
	
	@Override
	public void obtenerLineasComerciales(LineaComercialVO lineaComercialVO)throws SICException{
		if(lineaComercialVO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialVO.getBaseDTO()==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialVO.getBaseDTO().getId().getCodigoCompania()==null){
			throw new SICException("El codigo de la compania se encuentra vacia");
		}
	}
	
	@Override
	public void eliminarLineaComercialFuncionario(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException{
		if(lineaComercialFuncionarioDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialFuncionarioDTO.getUserId()==null){
			throw new SICException("La userId se encuentra vacio");
		}
		if(lineaComercialFuncionarioDTO.getId().getCodigoCompania()==null){
			throw new SICException("El codigoCompania se encuentra vacio");
		}
		if(lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario()==null){
			throw new SICException("El codigoLineaComercialFuncionario se encuentra vacio");
		}
	}
	
	@Override
	public void activarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException{
		if(lineaComercialDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialDTO.getUserId()==null){
			throw new SICException("La userId se encuentra vacio");
		}
		if(lineaComercialDTO.getId().getCodigoLineaComercial()==null){
			throw new SICException("El codigoLineaComercial se encuentra vacio");
		}
	}
	
	@Override
	public void asignarTiposMarca(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws Exception{
		if(lineaComercialFuncionarioDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialFuncionarioDTO.getUserId()==null){
			throw new SICException("La userId se encuentra vacio");
		}
		if(lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario()==null){
			throw new SICException("El codigoLineaComercialFuncionario se encuentra vacio");
		}
	}
	
	@Override
	public void reasignarClasificacionesLineaComercial (LineaComercialDTO lineaComercialDTO, Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol)throws SICException{
		if(lineaComercialDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(lineaComercialDTO.getUserId()==null){
			throw new SICException("La userId se encuentra vacio");
		}
		if(CollectionUtils.isEmpty(lineaComercialClasificacionCol)){
			throw new SICException("Las clasificaciones a reasignar se encuentra vacio");
		}
	}
	
	@Override
	public void crearMarcasFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO, Collection<MarcaArticuloDTO> marcasAsignadas)throws SICException{
		if(funcionarioTipoMarcaDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(funcionarioTipoMarcaDTO.getUserId()==null){
			throw new SICException("La userId se encuentra vacio");
		}
		if(CollectionUtils.isEmpty(marcasAsignadas)){
			throw new SICException("La coleccion de marcas del articulo se encuentra vacio");
		}
		if(!SearchDTO.isLoaded(funcionarioTipoMarcaDTO.getMarcaFuncionarioTipoMarcaCol())){
			throw new SICException("La coleccion de marcaFuncionarioTipoMarcaCol se encuentra vacio");
		}
	}
	
	@Override
	public void eliminarMarcaFuncionarioTipoMarca(MarcaFuncionarioTipoMarcaDTO marcaFuncionarioTipoMarcaDTO)throws SICException{
		if(marcaFuncionarioTipoMarcaDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(marcaFuncionarioTipoMarcaDTO.getUserId()==null){
			throw new SICException("El userId se encuentra vacio");
		}
	}
	
	
	@Override
	public void eliminarMarcaFuncionarioTipoMarca(Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol, String userId)throws SICException{
		if(StringUtils.isEmpty(userId)){
			throw new SICException("El userId se encuentra vacio");
		}
	}
	
	@Override
	public void eliminarFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO)throws SICException{
		if(funcionarioTipoMarcaDTO==null){
			throw new SICException("La plantilla se encuentra vacia");
		}
		if(funcionarioTipoMarcaDTO.getUserId()==null){
			throw new SICException("El userId se encuentra vacio");
		}
		if(!SearchDTO.isLoaded(funcionarioTipoMarcaDTO.getLineaComercialFuncionarioDTO())){
			throw new SICException("La lineaComercialFuncionarioDTO se encuentra vacio");
		}
	}
}
