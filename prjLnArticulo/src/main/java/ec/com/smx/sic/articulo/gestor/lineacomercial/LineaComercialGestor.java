package ec.com.smx.sic.articulo.gestor.lineacomercial;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.exception.DAOException;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioLineaComercial;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioTipoMarca;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.VistaAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.id.AreaTrabajoID;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.predicate.EqualsCompositePredicate;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.framework.gestor.ISequenceDataBaseGestor;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.articulo.gestor.lineacomercial.validacion.ValidacionLineaComercialGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.lineacomercial.ILineaComercialGestor;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaFuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.ClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.LineaComercialVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.ILineaComercialDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * 
 * @author fcollaguazo
 *
 */
public class LineaComercialGestor implements ILineaComercialGestor{

	private ValidacionLineaComercialGestor validacionLineaComercialGestor;
	private DataGestor dataGestor;
	private ILineaComercialDAO lineaComercialDAO;
	private ISequenceDataBaseGestor sequenceDataBaseGestor;
	
	Boolean validar=Boolean.TRUE;
	
	/**
	 * Obntenci&oacute;n del par&aacute;metro de validaci&oacute;n para funcionarios
	 * en l&iacute;neas comerciales de diferente tipo
	 * @return
	 * @throws SICException
	 */
	private Boolean obtenerValidacionFuncionarioTipoLineaComercial() throws SICException{
		Boolean parametroValor = null;
		//Obtenci�n del parametro para validar
		ParametroDTO parametroFiltro = new ParametroDTO();
		parametroFiltro.getId().setCodigoParametro(SICParametros.getInstancia().ACTIVAR_VALIDACION_FUNCIONARIO_TIPO_LINEA_COMERCIAL);
		
		ParametroDTO parametroValidacion = dataGestor.findUnique(parametroFiltro);
		parametroValor = Boolean.valueOf(parametroValidacion.getValorParametro());
		return parametroValor;
	}
	
	/**
	 * Obntenci&oacute;n del par&aacute;metro de validaci&oacute;n para clasificaciones
	 * en l&iacute;neas comerciales de diferente tipo
	 * @return
	 * @throws SICException
	 */
	private Boolean obtenerValidacionClasificacionTipoLineaComercial() throws SICException{
		Boolean parametroValor = null;
		//Obtenci�n del parametro para validar
		ParametroDTO parametroFiltro = new ParametroDTO();
		parametroFiltro.getId().setCodigoParametro(SICParametros.getInstancia().ACTIVAR_VALIDACION_CLASIFICACION_TIPO_LINEA_COMERCIAL);
		
		ParametroDTO parametroValidacion = dataGestor.findUnique(parametroFiltro);
		parametroValor = Boolean.valueOf(parametroValidacion.getValorParametro());
		return parametroValor;
	}
	
	@Override
	public void crearLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		validacionLineaComercialGestor.crearLineaComercial(lineaComercialDTO);
		try{
			//Transformamos a mayusculas
			lineaComercialDTO.setNombre(lineaComercialDTO.getNombre().toUpperCase());
			if(StringUtils.isNotEmpty(lineaComercialDTO.getDescripcion())){
				lineaComercialDTO.setDescripcion(lineaComercialDTO.getDescripcion().toUpperCase());
			}
			
			//Validar si es nuevo a es actualizar
			if(lineaComercialDTO.getId().getCodigoLineaComercial()!=null){
				actualizarLineaComercial(lineaComercialDTO);
			}else{
				//Llenamos la secuencia
				lineaComercialDTO.getId().setCodigoLineaComercial(this.sequenceDataBaseGestor.getSequenceValue(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.linea.comercial.numero.secuencia.prefijo")));
				
				//Validar si posee padre
				if(lineaComercialDTO.getLineaComercialPadre()!=null){
					lineaComercialDTO.setCodigoLineaComercialPadre(lineaComercialDTO.getLineaComercialPadre().getId().getCodigoLineaComercial());
					lineaComercialDTO.setCodigoLineaComercialRaiz(lineaComercialDTO.getLineaComercialPadre().getCodigoLineaComercialRaiz());
				}else{
					lineaComercialDTO.setCodigoLineaComercialRaiz(lineaComercialDTO.getId().getCodigoLineaComercial());
				}
				
				EstablecimientoDTO establecimientoDTOClone = SerializationUtils.clone(lineaComercialDTO.getEstablecimiento());
				lineaComercialDTO.setEstablecimiento(null);
				lineaComercialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				
				dataGestor.create(lineaComercialDTO);
				lineaComercialDTO.setEstablecimiento(establecimientoDTOClone);
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al crear la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al crear la linea comercial {}",e);
		}
	}

	@Override
	public void actualizarLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		validacionLineaComercialGestor.actualizarLineaComercial(lineaComercialDTO);
		try{
			//Transformamos a mayusculas
			lineaComercialDTO.setNombre(lineaComercialDTO.getNombre().toUpperCase());
			if(StringUtils.isNotEmpty(lineaComercialDTO.getDescripcion())){
				lineaComercialDTO.setDescripcion(lineaComercialDTO.getDescripcion().toUpperCase());
			}
			
			lineaComercialDAO.actualizarLineaComercial(lineaComercialDTO);
//			dataGestor.update(lineaComercialDTO);
			
			//Actualizamos el establecimiento a los hijos
			if(lineaComercialDTO.getLineaComercialPadre()==null 
					|| SearchDTO.isLoaded(lineaComercialDTO.getSubLineaComercialCol())
					|| CollectionUtils.isNotEmpty(lineaComercialDTO.getSubLineaComercialCol())){
				lineaComercialDAO.actualizarEstablecimientoSubLineasComerciales(lineaComercialDTO.getUserId(), 
						lineaComercialDTO.getId().getCodigoLineaComercial(), lineaComercialDTO.getCodigoEstablecimiento(),
						lineaComercialDTO.getValorTipoLineaComercial(), lineaComercialDTO.getCodigoTipoLineaComercial());
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al actualizar la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al actualizar la linea comercial {}",e);
		}
	}

	@Override
	public void crearLineaComercialClasificacion(LineaComercialDTO lineaComercialDTO) throws SICException {
		validacionLineaComercialGestor.crearLineaComercialClasificacion(lineaComercialDTO);
		try{
			/**
			 * esta restriccion esta dada por que se puede inactivar la 
			 * regla de que una clasificacion solo puede estar en linea comercial de distinto tipo.
			 * 
			 */
			if(!obtenerValidacionClasificacionTipoLineaComercial()){
				if (CollectionUtils.isNotEmpty(lineaComercialDTO.getDivisionesCol())){
					if(lineaComercialDTO.getLineaComercialPadre()!=null){
						lineaComercialDAO.activarClasificacionesDivision(lineaComercialDTO.getUserId(), lineaComercialDTO.getCodigoLineaComercialPadre(), lineaComercialDTO.getDivisionesCol());
					}
					lineaComercialDAO.activarClasificacionesDivision(lineaComercialDTO.getUserId(), lineaComercialDTO.getId().getCodigoLineaComercial(), lineaComercialDTO.getDivisionesCol());
					
				}
				if (CollectionUtils.isNotEmpty(lineaComercialDTO.getDepartamentosCol())){
					if(lineaComercialDTO.getLineaComercialPadre()!=null){
						lineaComercialDAO.activarClasificacionesDepartamento(lineaComercialDTO.getUserId(), lineaComercialDTO.getCodigoLineaComercialPadre(), lineaComercialDTO.getDepartamentosCol());
					}
					lineaComercialDAO.activarClasificacionesDepartamento(lineaComercialDTO.getUserId(), lineaComercialDTO.getId().getCodigoLineaComercial(), lineaComercialDTO.getDepartamentosCol());
				}
			}
			//Crear las clasificaciones a la linea comercial padre
			if(lineaComercialDTO.getLineaComercialPadre()!=null){
				lineaComercialDTO.getLineaComercialPadre().setUserId(lineaComercialDTO.getUserId());
				crearClasificacionLineaComercial(lineaComercialDTO.getLineaComercialPadre());
			}
			//Crear las clasificaciones a la linea comercial
			crearClasificacionLineaComercial(lineaComercialDTO);
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al crear la clasificacion de la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al crear la clasificacion de la linea comercial {}",e);
		}
	
	}
	
	@Override
	public void crearLineaComercialFuncionario(LineaComercialDTO lineaComercialDTO,Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTOs) throws SICException {
		validacionLineaComercialGestor.crearLineaComercialFuncionario(lineaComercialDTO);
		
		try{
			Integer codigoCompania = lineaComercialDTO.getId().getCodigoCompania();
			String userId = lineaComercialDTO.getUserId();
			for(LineaComercialFuncionarioDTO lineaComercialFuncionario:lineaComercialDTO.getLineaComercialFuncionarios()){
				
				//Obtenemos las lineas comerciales del funcionario que se encuentran en otro tipo de linea comercial
				LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO = new LineaComercialFuncionarioDTO();
				lineaComercialFuncionarioDTO.getId().setCodigoCompania(codigoCompania);
				lineaComercialFuncionarioDTO.getId().setCodigoFuncionario(lineaComercialFuncionario.getFuncionario().getId().getCodigoFuncionario());
				lineaComercialFuncionarioDTO.setUserId(userId);
				lineaComercialFuncionarioDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				lineaComercialFuncionarioDTO.setFuncionario(new FuncionarioDTO());
				lineaComercialFuncionarioDTO.getFuncionario().setUsuarioDTO(new UserDto());
				lineaComercialFuncionarioDTO.setLineaComercial(new LineaComercialDTO());
				lineaComercialFuncionarioDTO.getLineaComercial().setTipoLineaComercial(new CatalogoValorDTO());
				lineaComercialFuncionarioDTO.addCriteriaSearchParameter("lineaComercial.valorTipoLineaComercial",ComparatorTypeEnum.NOT_EQUAL_COMPARATOR,lineaComercialDTO.getValorTipoLineaComercial());
				Collection<LineaComercialFuncionarioDTO> lDtos=dataGestor.findObjects(lineaComercialFuncionarioDTO);
				
				validar=Boolean.TRUE;
							
				//Validaci�n para que el funcionario pertenezca solo a lineas comerciales de un mismo tipo
				if(CollectionUtils.isNotEmpty(lDtos)&& obtenerValidacionFuncionarioTipoLineaComercial()){			
					lineaComercialFuncionarioDTOs.addAll(lDtos);
					validar=Boolean.FALSE;
				}
				
				//Validaci�n para que un funcionario no pertenezca a las mismas sublineas o a la sublinea padre a la vez
				LineaComercialFuncionarioDTO lcfFiltro = new LineaComercialFuncionarioDTO();
				lcfFiltro.setLineaComercial(new LineaComercialDTO());
				lcfFiltro.getLineaComercial().setTipoLineaComercial(new CatalogoValorDTO());
				lcfFiltro.getId().setCodigoCompania(codigoCompania);
				lcfFiltro.setFuncionario(new FuncionarioDTO());
				lcfFiltro.getFuncionario().setUsuarioDTO(new UserDto());
				lcfFiltro.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				lcfFiltro.getLineaComercial().addCriteriaSearchParameter("id.codigoLineaComercial", ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, lineaComercialDTO.getId().getCodigoLineaComercial());
				//Si es sublinea
				if(lineaComercialDTO.getCodigoLineaComercialPadre()!=null){
					//Validar si existe el funcionario en la lineaPadre
					lcfFiltro.setCodigoLineaComercial(lineaComercialDTO.getCodigoLineaComercialPadre());
					Collection<LineaComercialFuncionarioDTO> lcfPadreCol = dataGestor.findObjects(lcfFiltro);
					if(CollectionUtils.isNotEmpty(lcfPadreCol)){
						asignarValidacionFuncionario(lcfPadreCol,lineaComercialFuncionario,lineaComercialFuncionarioDTOs);
					}
				    //Validar si existe el funcionario las Sublineas
//					if(CollectionUtils.isNotEmpty(lineaComercialDTO.getLineaComercialPadre().getSubLineaComercialCol())){
//						validarFuncionarioEnSubLineas(lineaComercialFuncionarioDTOs,lineaComercialFuncionario,lcfFiltro,lineaComercialDTO,lineaComercialDTO.getLineaComercialPadre().getSubLineaComercialCol());
//					}
				}
				//Si es linea padre
				else{
					//Validar si existe el funcionario las Sublineas
					if(CollectionUtils.isNotEmpty(lineaComercialDTO.getSubLineaComercialCol())){
						validarFuncionarioEnSubLineas(lineaComercialFuncionarioDTOs,lineaComercialFuncionario,lcfFiltro,lineaComercialDTO,lineaComercialDTO.getSubLineaComercialCol());
					}
				}
					
				if(validar){
					lineaComercialFuncionarioDTO.setCriteriaSearch(null);
					lineaComercialFuncionarioDTO.setCodigoLineaComercial(lineaComercialDTO.getId().getCodigoLineaComercial());	
					lineaComercialFuncionarioDTO.setEstado(null);
					LineaComercialFuncionarioDTO lDto=
						dataGestor.findUnique(lineaComercialFuncionarioDTO);
					
					if(!SearchDTO.isLoaded(lDto)){
						lineaComercialFuncionarioDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(lineaComercialFuncionarioDTO);
						lineaComercialDAO.activarClasificacionesFuncionario(userId, lineaComercialFuncionarioDTO.getCodigoLineaComercial());
						//Creamos las marcas del funcionario
						lineaComercialFuncionarioDTO.setFuncionarioTipoMarcaCol(lineaComercialFuncionario.getFuncionarioTipoMarcaCol());
						crearFuncionarioTipoMarca(lineaComercialFuncionarioDTO);
						//crear la relacion linea comercial, clasificacion, funcionario
						lineaComercialDAO.agregarLineaComercialFuncionarioClasificacion(lineaComercialDTO, lineaComercialFuncionarioDTO);
					}else{
						//Si el estado es inactivo lo activamos
						if(lDto.getEstado().equals(SICConstantes.ESTADO_INACTIVO_NUMERICO)){
							lineaComercialFuncionarioDTO.getId().setCodigoLineaComercialFuncionario(lDto.getId().getCodigoLineaComercialFuncionario());
							lDto.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							dataGestor.update(lDto);
							lineaComercialDAO.activarClasificacionesFuncionario(userId, lineaComercialFuncionarioDTO.getCodigoLineaComercial());
							//Creamos las marcas del funcionario
							lineaComercialFuncionarioDTO.setFuncionarioTipoMarcaCol(lineaComercialFuncionario.getFuncionarioTipoMarcaCol());
							crearFuncionarioTipoMarca(lineaComercialFuncionarioDTO);
							//crear la relacion linea comercial, clasificacion, funcionario
							lineaComercialDAO.agregarLineaComercialFuncionarioClasificacion(lineaComercialDTO, lineaComercialFuncionarioDTO);
						}
						else{
							//Agregamos a la lista a mostrar
							lineaComercialFuncionarioDTOs.add(lDto);
						}
					}
				}
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al crear la clasificacion de la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al crear la clasificacion de la linea comercial {}",e);
		}
		
	}
	
	/**
	 * Permite validar si el funcionario se encuentra en las sublineas
	 * @param lineaComercialFuncionarioDTOs
	 * @param lcfSeleccionado
	 * @param lcfFiltro
	 * @param lcSeleccionada
	 * @param subLineaCol
	 */
	private void validarFuncionarioEnSubLineas(Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTOs,LineaComercialFuncionarioDTO lcfSeleccionado ,LineaComercialFuncionarioDTO lcfFiltro,LineaComercialDTO lcSeleccionada,Collection<LineaComercialDTO> subLineaCol){
		for(LineaComercialDTO lcHijas:subLineaCol){
			if(lcSeleccionada.getCodigoLineaComercialPadre()==null){
				lcfFiltro.getLineaComercial().setCodigoLineaComercialPadre(lcSeleccionada.getId().getCodigoLineaComercial());
			}else{
				lcfFiltro.getLineaComercial().setCodigoLineaComercialPadre(lcSeleccionada.getCodigoLineaComercialPadre());
			}
			lcfFiltro.setCodigoLineaComercial(lcHijas.getId().getCodigoLineaComercial());
			Collection<LineaComercialFuncionarioDTO> lcfHijasCol = dataGestor.findObjects(lcfFiltro);
			if(CollectionUtils.isNotEmpty(lcfHijasCol)){
				asignarValidacionFuncionario(lcfHijasCol,lcfSeleccionado,lineaComercialFuncionarioDTOs);
			}
		}
	}
	
	/**
	 * Permite asignar el tipo de validaci�n al funcionario 
	 * @param lcfCol
	 * @param lcfSeleccionado
	 * @param lineaComercialFuncionarioDTOs
	 */
	//***********************************************************
	//OJO: NO Borrar, hasta definir reasignaci�n de funcionario
	//	   La linea comentada sirve para identificar las lineas
	//     comerciales donde se encontr{o al funcionario
	//***********************************************************
	private void asignarValidacionFuncionario(Collection<LineaComercialFuncionarioDTO> lcfCol,LineaComercialFuncionarioDTO lcfSeleccionado,Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTOs){
		for(LineaComercialFuncionarioDTO lcfHermanas :lcfCol){
			if(lcfHermanas.getId().getCodigoFuncionario().equalsIgnoreCase(lcfSeleccionado.getFuncionario().getId().getCodigoFuncionario())){
//				lcfHermanas.setTipoValidacion(Boolean.TRUE);
				lcfSeleccionado.setLineaComercial(lcfHermanas.getLineaComercial());
				lineaComercialFuncionarioDTOs.add(lcfHermanas);
				validar=Boolean.FALSE;
			}
		}
	}
	
	/**
	 * Crea las marcas del funcionario (Propia / Proveedor)
	 * @param lineaComercialFuncionarioDTO
	 */
	@Override
	public void crearFuncionarioTipoMarca(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException{
		//Validamos si posee marcas seleccionadas
		if(CollectionUtils.isEmpty(lineaComercialFuncionarioDTO.getFuncionarioTipoMarcaCol())){
			throw new SICException("Las marcas del funcionario no deben ser vacias");
		}
		try{
			Integer codigoCompania = lineaComercialFuncionarioDTO.getId().getCodigoCompania();
			String codigoFuncionario = lineaComercialFuncionarioDTO.getId().getCodigoFuncionario();
			Long codigoLineaComercialFuncionario = lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario();
			String userId = lineaComercialFuncionarioDTO.getUserId();
			Logeable.LOG_SICV2.info("Codigo funcionario a buscar las marcas: {}",codigoFuncionario);
			for(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTOAux : lineaComercialFuncionarioDTO.getFuncionarioTipoMarcaCol() ){
				
				FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO=new FuncionarioTipoMarcaDTO();
				funcionarioTipoMarcaDTO.setValorTipoMarca(funcionarioTipoMarcaDTOAux.getValorTipoMarca());
				funcionarioTipoMarcaDTO.setCodigoFuncionario(codigoFuncionario);
				FuncionarioTipoMarcaDTO fTMDto=dataGestor.findUnique(funcionarioTipoMarcaDTO);
				
				if(! SearchDTO.isLoaded(fTMDto)){
					funcionarioTipoMarcaDTO.getId().setCodigoCompania(codigoCompania);
					funcionarioTipoMarcaDTO.setCodigoFuncionario(codigoFuncionario);
					funcionarioTipoMarcaDTO.setCodigoTipoMarca(TiposCatalogoConstantes.TIPO_MARCA);
					funcionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					funcionarioTipoMarcaDTO.setUserId(userId);
					dataGestor.create(funcionarioTipoMarcaDTO);
					
					//Creamos la linea comercial funcionario tipo de marca
					crearLineaComercialFuncionarioTipoMarca(codigoCompania, codigoLineaComercialFuncionario, codigoFuncionario, funcionarioTipoMarcaDTO.getId().getCodigoFuncionarioTipoMarca(), userId,Boolean.FALSE);
					
					}else{
					
						LineaComercialFuncionarioTipoMarcaDTO linComFunTipMar = new LineaComercialFuncionarioTipoMarcaDTO();
						linComFunTipMar.getId().setCodigoCompania(codigoCompania);
						linComFunTipMar.setCodigoFuncionarioTipoMarca(fTMDto.getId().getCodigoFuncionarioTipoMarca());
						linComFunTipMar.setCodigoLineaComercialFuncionario(codigoLineaComercialFuncionario);	
						linComFunTipMar.setUserId(userId);
						LineaComercialFuncionarioTipoMarcaDTO lCFTM=dataGestor.findUnique(linComFunTipMar);
						
						if(SearchDTO.isLoaded(lCFTM)){
							lCFTM.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							dataGestor.update(lCFTM);
						}else{
						linComFunTipMar.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						crearLineaComercialFuncionarioTipoMarca(codigoCompania, codigoLineaComercialFuncionario, codigoFuncionario, fTMDto.getId().getCodigoFuncionarioTipoMarca(), userId,Boolean.FALSE);
						}
					
					
					
				}
				
			}
			
//			LineaComercialFuncionarioTipoMarcaDTO linComFunTipMar = new LineaComercialFuncionarioTipoMarcaDTO();
//			linComFunTipMar.getId().setCodigoCompania(codigoCompania);
//			linComFunTipMar.setCodigoLineaComercialFuncionario(codigoLineaComercialFuncionario);	
//			linComFunTipMar.setFuncionarioTipoMarca(new FuncionarioTipoMarcaDTO());
//			linComFunTipMar.setUserId(userId);
//			
//			Collection<LineaComercialFuncionarioTipoMarcaDTO> lineaComercialFuncionarioTipoMarcaDTOs=dataGestor.findObjects(linComFunTipMar);
//			
//			for(LineaComercialFuncionarioTipoMarcaDTO lCFTM:lineaComercialFuncionarioTipoMarcaDTOs ){
//				if(lCFTM.getEstado().equals(SICConstantes.ESTADO_INACTIVO_NUMERICO)){
//					final String marca= lCFTM.getFuncionarioTipoMarca().getValorTipoMarca();
//					if(CollectionUtils.exists(lineaComercialFuncionarioDTO.getFuncionarioTipoMarcaCol(), new Predicate() {
//						@Override
//						public boolean evaluate(Object arg0) {
//							return marca.equals(((FuncionarioTipoMarcaDTO)arg0).getValorTipoMarca());
//						}})){
//						lCFTM.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//						dataGestor.update(lCFTM);
//						
//					}
//				}
//			}
			
			
			
			
			
			//Obtenemos los Funcionarios
//			ArrayList<String> codigosFuncionarios = new ArrayList<String>();
//			ArrayList<String> valoresTipoMarca = new ArrayList<String>();
//			for(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO : lineaComercialFuncionarioDTO.getFuncionarioTipoMarcaCol() ){
//				codigosFuncionarios.add(codigoFuncionario);
//				valoresTipoMarca.add(funcionarioTipoMarcaDTO.getValorTipoMarca());
//			}
//			/**
//			 * permite comprobar las marcas asignadas al funcionario
//			 * si estas se encuentras ingresadas en la base
//			 * para evitar la clave duplicada
//			 */
//			Collection<FuncionarioTipoMarcaDTO> funcionarioTipoMarcaCol=new ArrayList<FuncionarioTipoMarcaDTO>();
//			FuncionarioTipoMarcaDTO funcionarioTipoMarcaTemplate = new FuncionarioTipoMarcaDTO();
//			funcionarioTipoMarcaTemplate.addCriteriaSearchParameter("codigoFuncionario", ComparatorTypeEnum.IN_COMPARATOR, codigosFuncionarios);
//			funcionarioTipoMarcaTemplate.addCriteriaSearchParameter("valorTipoMarca", ComparatorTypeEnum.IN_COMPARATOR, valoresTipoMarca);
//			funcionarioTipoMarcaCol = dataGestor.findObjects(funcionarioTipoMarcaTemplate);
//			/**
//			 * valida si no existen marcas con funcionarios en la base para
//			 * que de esta manera solo se realice el ingreso de lo que envia el usuario
//			 */
//			if(CollectionUtils.isEmpty(funcionarioTipoMarcaCol)){
//			
//				for(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO: lineaComercialFuncionarioDTO.getFuncionarioTipoMarcaCol()){
//					funcionarioTipoMarcaDTO.getId().setCodigoCompania(codigoCompania);
//					funcionarioTipoMarcaDTO.setCodigoFuncionario(codigoFuncionario);
//					funcionarioTipoMarcaDTO.setCodigoTipoMarca(TiposCatalogoConstantes.TIPO_MARCA);
//					funcionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//					funcionarioTipoMarcaDTO.setUserId(userId);
//					dataGestor.create(funcionarioTipoMarcaDTO);
//					
//					//Creamos la linea comercial funcionario tipo de marca
//					crearLineaComercialFuncionarioTipoMarca(codigoCompania, codigoLineaComercialFuncionario, funcionarioTipoMarcaDTO.getId().getCodigoFuncionarioTipoMarca(), userId,Boolean.FALSE);
//				}
//				/**
//				 * Con esta condicion establecemos que las marcas que se asignara al usuario son 
//				 * mas que las que ya se encuentran en la base esto se hace para 
//				 * que se pueda realizar el ingreso de las faltantes
//				 */
//			}else{
//				if(lineaComercialFuncionarioDTO.getFuncionarioTipoMarcaCol().size() > funcionarioTipoMarcaCol.size()){
				
//				for(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO: lineaComercialFuncionarioDTO.getFuncionarioTipoMarcaCol()){
//					if(!CollectionUtils.exists(funcionarioTipoMarcaCol, new EqualsCompositePredicate(funcionarioTipoMarcaDTO, new String[]{"valorTipoMarca"}))){
//							funcionarioTipoMarcaDTO.getId().setCodigoCompania(codigoCompania);
//							funcionarioTipoMarcaDTO.setCodigoFuncionario(codigoFuncionario);
//							funcionarioTipoMarcaDTO.setCodigoTipoMarca(TiposCatalogoConstantes.TIPO_MARCA);
//							funcionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//							funcionarioTipoMarcaDTO.setUserId(userId);
//							dataGestor.create(funcionarioTipoMarcaDTO);
//							
//							//Creamos la linea comercial funcionario tipo de marca
//							crearLineaComercialFuncionarioTipoMarca(codigoCompania, codigoLineaComercialFuncionario, funcionarioTipoMarcaDTO.getId().getCodigoFuncionarioTipoMarca(), userId,Boolean.FALSE);
//					}	
//				}
//				
//				funcionarioTipoMarcaCol = dataGestor.findObjects(funcionarioTipoMarcaTemplate);
//				}
				
				/**
				 * si existieran los dos valores este metodo se encarga de verificar las parcas que 
				 * el usuario necesita que esten abilitadas
				 */
			
//			else{
//					
//				LineaComercialFuncionarioTipoMarcaDTO linComFunTipMar = new LineaComercialFuncionarioTipoMarcaDTO();
//				linComFunTipMar.getId().setCodigoCompania(codigoCompania);
//				linComFunTipMar.setCodigoLineaComercialFuncionario(codigoLineaComercialFuncionario);			
//				linComFunTipMar.setUserId(userId);
//				
//				Collection<LineaComercialFuncionarioTipoMarcaDTO> lineaComercialFuncionarioTipoMarcaDTOs=dataGestor.findObjects(linComFunTipMar);
//				
//				for(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTOs:funcionarioTipoMarcaCol){
//					final LineaComercialFuncionarioTipoMarcaDTO lDto=new LineaComercialFuncionarioTipoMarcaDTO();
//					lDto.setCodigoFuncionarioTipoMarca(funcionarioTipoMarcaDTOs.getId().getCodigoFuncionarioTipoMarca());
//					
//					LineaComercialFuncionarioTipoMarcaDTO lMarcaDTO= 
//						(LineaComercialFuncionarioTipoMarcaDTO)CollectionUtils.find(lineaComercialFuncionarioTipoMarcaDTOs, new EqualsCompositePredicate(lDto, new String[]{"codigoFuncionarioTipoMarca"}));
//					if(SearchDTO.isLoaded(lMarcaDTO)){
//						if(lMarcaDTO.getEstado().equals(SICConstantes.ESTADO_INACTIVO_NUMERICO)){
//								lMarcaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//								dataGestor.update(lMarcaDTO);
//						}
//					}else{
//						linComFunTipMar = new LineaComercialFuncionarioTipoMarcaDTO();
//						linComFunTipMar.getId().setCodigoCompania(codigoCompania);
//						linComFunTipMar.setCodigoLineaComercialFuncionario(codigoLineaComercialFuncionario);			
//						linComFunTipMar.setUserId(userId);
//						linComFunTipMar.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//						linComFunTipMar.setCodigoFuncionarioTipoMarca(funcionarioTipoMarcaDTOs.getId().getCodigoFuncionarioTipoMarca());
//						dataGestor.create(linComFunTipMar);
//					}
//					if(funcionarioTipoMarcaCol.size()==1){
//						LineaComercialFuncionarioTipoMarcaDTO lTipoMarcaDTO=(LineaComercialFuncionarioTipoMarcaDTO)CollectionUtils.find(lineaComercialFuncionarioTipoMarcaDTOs, new Predicate() {
//							@Override
//							public boolean evaluate(Object arg0) {
//								// TODO Auto-generated method stub
//								String v1=String.valueOf(((LineaComercialFuncionarioTipoMarcaDTO)arg0).getCodigoFuncionarioTipoMarca()),
//								v2=String.valueOf(lDto.getCodigoFuncionarioTipoMarca());
//								return !(v1.equals(v2)) ;
//							}
//						});
//						
//						if(SearchDTO.isLoaded(lTipoMarcaDTO) && lTipoMarcaDTO.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
//							lTipoMarcaDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
//							dataGestor.update(lTipoMarcaDTO);
//						}
//					}
//					
//				
//				}
//				for(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTOs:funcionarioTipoMarcaCol){
//						//Creamos la linea comercial funcionario tipo de marca
////						crearLineaComercialFuncionarioTipoMarca(funcionarioTipoMarcaDTOs.getId().getCodigoCompania(),
////								lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario(),
////								funcionarioTipoMarcaDTOs.getId().getCodigoFuncionarioTipoMarca(),
////								userId, unMarca);
//					
//					
//				}
				
				
//			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al crear el tipo de marca al funcionario {}",e);
			throw new SICException("Ha ocurrido un error al crear el tipo de marca al funcionario {}",e);
		}
	}
	
	/**
	 * Crea la marca de la linea comercial del funcionario
	 * @param codigoCompania
	 * @param codigoLineaComercialFuncionario
	 * @param codigoFuncionarioTipoMarca
	 * @param userId
	 */
	private void crearLineaComercialFuncionarioTipoMarca(Integer codigoCompania, Long codigoLineaComercialFuncionario, String codigoFuncionario, 
			Long codigoFuncionarioTipoMarca, String userId, Boolean unMarca)throws SICException{
		try{	
			LineaComercialFuncionarioTipoMarcaDTO linComFunTipMar = new LineaComercialFuncionarioTipoMarcaDTO();
			linComFunTipMar.getId().setCodigoCompania(codigoCompania);
			linComFunTipMar.setCodigoLineaComercialFuncionario(codigoLineaComercialFuncionario);
			linComFunTipMar.setCodigoFuncionario(codigoFuncionario);
			
			linComFunTipMar.setUserId(userId);
			
			Collection<LineaComercialFuncionarioTipoMarcaDTO> lineaComercialFuncionarioTipoMarcaDTOs=dataGestor.findObjects(linComFunTipMar);
			
			if(unMarca && CollectionUtils.isNotEmpty(lineaComercialFuncionarioTipoMarcaDTOs) && lineaComercialFuncionarioTipoMarcaDTOs.size()>1){
				
				for(LineaComercialFuncionarioTipoMarcaDTO lineaComercialFuncionarioTipoMarcaDTO: lineaComercialFuncionarioTipoMarcaDTOs){
					String val1=String.valueOf(lineaComercialFuncionarioTipoMarcaDTO.getCodigoFuncionarioTipoMarca()),
					val2=String.valueOf(codigoFuncionarioTipoMarca);
					
					if(val1.equals(val2) &&
							lineaComercialFuncionarioTipoMarcaDTO.getEstado().equals(SICConstantes.ESTADO_INACTIVO_NUMERICO)){					
						
						lineaComercialFuncionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.update(lineaComercialFuncionarioTipoMarcaDTO);
						
					}else if(!val1.equals(val2)){
						lineaComercialFuncionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
						dataGestor.update(lineaComercialFuncionarioTipoMarcaDTO);
					}
					
				}				
			}else{
				linComFunTipMar.setCodigoFuncionarioTipoMarca(codigoFuncionarioTipoMarca);
				LineaComercialFuncionarioTipoMarcaDTO lineaComercialFuncionarioTipoMarcaDTO= dataGestor.findUnique(linComFunTipMar);
				if(SearchDTO.isLoaded(lineaComercialFuncionarioTipoMarcaDTO)){
					if(lineaComercialFuncionarioTipoMarcaDTO.getEstado().equals(SICConstantes.ESTADO_INACTIVO_NUMERICO)){
						
						lineaComercialFuncionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.update(lineaComercialFuncionarioTipoMarcaDTO);
						
					}
				}else{
					linComFunTipMar.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					dataGestor.create(linComFunTipMar);
				}
			}
			
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al crear los tipos de marca del funcionario en la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al crear los tipos de marca del funcionario en la linea comercial {}",e);
		}
	}
	
	
	/**
	 * Registra la clasificacion a la linea comercial
	 * @param lineaComercialCol
	 */
	@SuppressWarnings("unchecked")
	private void crearClasificacionLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException{
		String userId = lineaComercialDTO.getUserId();
		
		//Obtenemos los codigo de clasificaciones para saber si estan inactivos
		List<String> codigosClasificacion = new ArrayList<String>();
		for(LineaComercialClasificacionDTO lineaComercialClasificacionDTO : lineaComercialDTO.getLineaComercialClasificaciones()){
			if(SearchDTO.isLoaded(lineaComercialClasificacionDTO.getClasificacion())){
				codigosClasificacion.add(lineaComercialClasificacionDTO.getClasificacion().getId().getCodigoClasificacion());
			}
		}
		
		//Validamos los codigos de las clasificaciones
		if(CollectionUtils.isNotEmpty(codigosClasificacion)){
			//Obtenemos la coleccion de inactivos
			
			LineaComercialClasificacionDTO linComClaTemplate = new LineaComercialClasificacionDTO();
			linComClaTemplate.setCodigoLineaComercial(lineaComercialDTO.getId().getCodigoLineaComercial());
			linComClaTemplate.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			linComClaTemplate.addCriteriaSearchParameter("id.codigoClasificacion", ComparatorTypeEnum.IN_COMPARATOR, codigosClasificacion);

	
			
			

			
			Collection<LineaComercialClasificacionDTO> lineaComercialClasificaciones = dataGestor.findObjects(linComClaTemplate);
			//Activamos las clasificaciones
			if(CollectionUtils.isNotEmpty(lineaComercialClasificaciones)){
				lineaComercialDAO.activarInactivarClasificacionesLineaComercial(userId, lineaComercialDTO.getId().getCodigoLineaComercial(),null, lineaComercialClasificaciones, SICConstantes.ESTADO_ACTIVO_NUMERICO);
			}
			
			//Clasificaciones que se va a crear
			for(LineaComercialClasificacionDTO linComClaDTOIna : lineaComercialClasificaciones){
				for(LineaComercialClasificacionDTO linComClaDTO:lineaComercialDTO.getLineaComercialClasificaciones()){
					if(linComClaDTOIna.getId().getCodigoClasificacion().equals(linComClaDTO.getClasificacion().getId().getCodigoClasificacion())){
						lineaComercialDTO.getLineaComercialClasificaciones().remove(linComClaDTO);
						break;
					}
				}
			}
			
			for(LineaComercialClasificacionDTO lineaComercialClasificacionDTO : lineaComercialDTO.getLineaComercialClasificaciones()){
				if(lineaComercialClasificacionDTO.getId().getCodigoClasificacion()==null 
						&& lineaComercialClasificacionDTO.getId().getCodigoCompania()==null
						&& lineaComercialClasificacionDTO.getCodigoLineaComercial()==null ){
					LineaComercialClasificacionDTO lineaComercialClasificacionDTOCrear = new LineaComercialClasificacionDTO();
					lineaComercialClasificacionDTOCrear.getId().setCodigoClasificacion(lineaComercialClasificacionDTO.getClasificacion().getId().getCodigoClasificacion());
					lineaComercialClasificacionDTOCrear.getId().setCodigoCompania(lineaComercialDTO.getId().getCodigoCompania());
					lineaComercialClasificacionDTOCrear.setCodigoLineaComercial(lineaComercialDTO.getId().getCodigoLineaComercial());
					lineaComercialClasificacionDTOCrear.setUserId(lineaComercialDTO.getUserId());
					lineaComercialClasificacionDTOCrear.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					dataGestor.create(lineaComercialClasificacionDTOCrear);
				}
			}
		}
	}

	@Override
	public void eliminarLineaComercial(LineaComercialDTO lineaComercialDTO) throws SICException {
		validacionLineaComercialGestor.eliminarLineaComercial(lineaComercialDTO);
		try{
			String userId = lineaComercialDTO.getUserId();
			
			//Inactivar los hijos
			if(SearchDTO.isLoaded(lineaComercialDTO.getSubLineaComercialCol())
					&& CollectionUtils.isNotEmpty(lineaComercialDTO.getSubLineaComercialCol())){
				lineaComercialDAO.eliminarClasificacionesSubLineasComerciales(userId, lineaComercialDTO.getSubLineaComercialCol());
				lineaComercialDAO.eliminarFuncionariosSubLineasComerciales(userId, lineaComercialDTO.getSubLineaComercialCol());
				eliminarClienteImportacionLineaComercial(lineaComercialDTO.getSubLineaComercialCol(), null, userId);
				lineaComercialDAO.eliminarSubLineasComerciales(userId, lineaComercialDTO.getId().getCodigoLineaComercial());
			}
			
			//Inactivar las clasificaciones de la linea comercial
			lineaComercialDAO.eliminarClasificacionesLineaComercial(userId, lineaComercialDTO.getId().getCodigoLineaComercial());
			
			//Inactivar los funcionarios de la linea comercial
			lineaComercialDAO.eliminarFuncionariosLineaComercial(userId, lineaComercialDTO.getId().getCodigoLineaComercial());
			
			eliminarClienteImportacionLineaComercial(null, lineaComercialDTO, userId);
			
			//Eliminar la linea comercial
			lineaComercialDAO.eliminarLineaComercial(userId, lineaComercialDTO.getId().getCodigoLineaComercial());
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al inactivar la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al inactivar la linea comercial {}",e);
		}
	}
	
	/**
	 * Permite inactivar los clientes importacion asignados a una linea comercial o varias lineas
	 * @param lineaComercialDTOCol
	 * @param lineaComercialDTO
	 * @param userID
	 * @throws SICException
	 */
	private void eliminarClienteImportacionLineaComercial(Collection<LineaComercialDTO> lineaComercialDTOCol,LineaComercialDTO lineaComercialDTO,String userID)throws SICException{
		try {
			LineaComercialClienteImportacionDTO linComCliImpDto;
			
			if(CollectionUtils.isNotEmpty(lineaComercialDTOCol)){
				linComCliImpDto = new LineaComercialClienteImportacionDTO();
				for(LineaComercialDTO linCom : lineaComercialDTOCol){
					linComCliImpDto.getId().setCodigoLineaComercial(linCom.getId().getCodigoLineaComercial());
					linComCliImpDto.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					linComCliImpDto.setUserId(userID);
					lineaComercialDAO.actualizarLinComClienImp(linComCliImpDto);
				}
			}
			if(lineaComercialDTO != null){
				linComCliImpDto = new LineaComercialClienteImportacionDTO();
				linComCliImpDto.getId().setCodigoLineaComercial(lineaComercialDTO.getId().getCodigoLineaComercial());
				linComCliImpDto.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				linComCliImpDto.setUserId(userID);
				lineaComercialDAO.actualizarLinComClienImp(linComCliImpDto);
			}
			
		} catch (SICException e) {
			throw new SICException("Error eliminarClienteImportacionLineaComercial: ",e);
		}
	}

	@Override
	public void eliminarLineaComercialClasificacion(Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol,LineaComercialDTO lineaComercialDTO, String userId) throws SICException {
		validacionLineaComercialGestor.eliminarLineaComercialClasificacion(lineaComercialClasificacionCol,lineaComercialDTO, userId);
		try{
			for(LineaComercialClasificacionDTO lineaComercialClasificacionDTO:lineaComercialClasificacionCol){
				lineaComercialClasificacionDTO.setClasificacion(null);
				
				//Si es linea comercial padre inactivar la clasificacion a los hijos
				if(lineaComercialDTO.getCodigoLineaComercialPadre()==null
						&& SearchDTO.isLoaded(lineaComercialDTO.getSubLineaComercialCol())
						&& CollectionUtils.isNotEmpty(lineaComercialDTO.getSubLineaComercialCol())){
					LineaComercialDTO lineaComercialPadre = lineaComercialDTO;
					lineaComercialDAO.eliminarClasificacionSubLineasComerciales(userId, lineaComercialPadre, lineaComercialClasificacionDTO.getId().getCodigoClasificacion());
				}
				
				lineaComercialDAO.eliminarClasificacionLineaComercial(userId, lineaComercialClasificacionDTO.getCodigoLineaComercial(), lineaComercialClasificacionDTO.getId().getCodigoClasificacion());
				
				//Linea que se usa para eliminar del papa, eliminando al hijo
//				if(lineaComercialDTO.getCodigoLineaComercialPadre()!=null)
//					lineaComercialDAO.eliminarClasificacionLineaComercial(userId, lineaComercialDTO.getCodigoLineaComercialPadre(), lineaComercialClasificacionDTO.getCodigoClasificacion());
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al eliminar la clasificacion de la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al eliminar la clasificacion de la linea comercial {}",e);
		}
	}
	
	@Override
	public void eliminarLineaComercialFuncionarios(Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioCol,LineaComercialDTO lineaComercialDTO, String userId) throws SICException {
		
		try{
			Transformer transformer =new GetInvokerTransformer("id.codigoFuncionario");
			List<String> codigoFuncionarios= (List<String>)CollectionUtils.collect(lineaComercialFuncionarioCol, transformer);
			
			LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO=new LineaComercialFuncionarioDTO();
			lineaComercialFuncionarioDTO.addCriteriaSearchParameter("id.codigoFuncionario",ComparatorTypeEnum.IN_COMPARATOR,codigoFuncionarios);
			lineaComercialFuncionarioDTO.setCodigoLineaComercial(lineaComercialDTO.getId().getCodigoLineaComercial());
			lineaComercialFuncionarioDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTOs=dataGestor.findObjects(lineaComercialFuncionarioDTO);
			
			for(LineaComercialFuncionarioDTO lCFDto: lineaComercialFuncionarioDTOs){
				lCFDto.setUserId(userId);
				lCFDto.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				lCFDto.setLineaComercial(lineaComercialDTO);
				dataGestor.update(lCFDto);
				lineaComercialDAO.removerLineaComercialFuncionarioClasificacion(lCFDto);
			}
			
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Error al eliminar los funcionarios de la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al eliminar el funcionario de la linea comercial {}",e);
		}
	}
	
	

	@Override
	public Collection<LineaComercialDTO> obtenerLineasComerciales(LineaComercialVO lineaComercialVO) throws SICException{
		try{
			Collection<LineaComercialDTO> lineasComercialCol;
				lineasComercialCol = lineaComercialDAO.buscarLineaComercial(lineaComercialVO); 
			return lineasComercialCol;
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Error al obtener las lineas comerciales {}",e);
			throw new SICException("Ha ocurrido un error al obtener las lineas comerciales",e);
		}
	}
	
	@Override
	public Collection<LineaComercialFuncionarioDTO> obtenerFuncionariosPorLineaComercial(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction> restrictionMap) throws SICException{
		try{
			Collection<LineaComercialFuncionarioDTO> lineasComercialCol;
				lineasComercialCol = lineaComercialDAO.obtenerFuncionariosPorLineaComercial(codigoCompania, codigoLineaComercial, estado, restrictionMap); 
			return lineasComercialCol;
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Error al obtener las lineas comerciales del funcionario",e);
			throw new SICException("Ha ocurrido un error al obtener las lineas comerciales del funcionario",e);
		}
	}
	
	@Override
	/**
	 * Obtiene la lista de lineas comerciales por funcionario
	 * 
	 */
	public Collection<LineaComercialFuncionarioDTO> obtenerLineasComercialesPorFuncionario(Integer codigoCompania, String codigoFuncionario) throws SICException{
		try {
			return lineaComercialDAO.obtenerLineaComercialPorFuncionario(codigoCompania, codigoFuncionario); 
		} catch (Exception e) {
			throw new SICException("Ha ocurrido un error al obtener las lineas comerciales por funcionario",e);
		}
	}
	
	@Override
	public Boolean validarFuncionarioLineaComercial(FuncionarioDTO funcionarioDTO) throws SICException {
		
		Boolean tieneLineaComercial = Boolean.FALSE;				
		LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO = new LineaComercialFuncionarioDTO();
		lineaComercialFuncionarioDTO.setFuncionario(new FuncionarioDTO());
		lineaComercialFuncionarioDTO.getFuncionario().getId().setCodigoFuncionario(funcionarioDTO.getId().getCodigoFuncionario());
		lineaComercialFuncionarioDTO.getFuncionario().getId().setCodigoCompania(funcionarioDTO.getId().getCodigoCompania());
		lineaComercialFuncionarioDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTOs = dataGestor.findObjects(lineaComercialFuncionarioDTO);
		if(CollectionUtils.isNotEmpty(lineaComercialFuncionarioDTOs)){
			tieneLineaComercial = Boolean.TRUE;
		}
		return tieneLineaComercial;
	}
	
	@Override
	public void eliminarLineaComercialFuncionario(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException{
		validacionLineaComercialGestor.eliminarLineaComercialFuncionario(lineaComercialFuncionarioDTO);
		try{
			lineaComercialDAO.eliminarFuncionarioLineaComercial(lineaComercialFuncionarioDTO);
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al inactivar el funcionario de la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al inactivar el funcionario de la linea comercial {}",e);
		}
	}
	
	@Override
	public void activarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException{
		validacionLineaComercialGestor.activarLineaComercial(lineaComercialDTO);
		try{
			//String userId = lineaComercialDTO.getUserId();
			
			//Activar la linea comercial
			lineaComercialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			dataGestor.dynamicUpdate(lineaComercialDTO);
			
//			//Activamos las clasificaciones
//			lineaComercialDAO.activarClasificacionesLineaComercial(userId, lineaComercialDTO.getId().getCodigoLineaComercial());
//			
//			//Activamos los funcionarios
//			lineaComercialDAO.activarFuncionariosLineaComercial(userId, lineaComercialDTO.getId().getCodigoLineaComercial());
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al activar la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al activar la linea comercial {}",e);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void asignarTiposMarca(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO, List<String> marcasNuevas)throws Exception{
		validacionLineaComercialGestor.asignarTiposMarca(lineaComercialFuncionarioDTO);
		try{
			String userId = lineaComercialFuncionarioDTO.getUserId();
			//Integer codigoCompania = lineaComercialFuncionarioDTO.getId().getCodigoCompania();
			//Long codigoLineaComercialFuncionario = lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario();
			
			//Si es el mismo tama�o se inserta o se activa
			if(CollectionUtils.isNotEmpty(lineaComercialFuncionarioDTO.getMarcasClone()) 
					&& CollectionUtils.isNotEmpty(marcasNuevas)
					&& lineaComercialFuncionarioDTO.getMarcasClone().size() == marcasNuevas.size()){
				activarMarcasInactivas(lineaComercialFuncionarioDTO, marcasNuevas);
				//Validar el q no existe para insertar
				Collection<String> marcasInsertar = CollectionUtils.disjunction(lineaComercialFuncionarioDTO.getMarcasClone(), marcasNuevas);
				if(CollectionUtils.isNotEmpty(marcasInsertar)){
					for(String marca:marcasInsertar){
						//crearLineaComercialFuncionarioTipoMarca(codigoCompania, codigoLineaComercialFuncionario, marca, userId);//TODO ARRELAR
					}
				}
			}
			//Si las nuevas son mayores a las de la base
			else if(CollectionUtils.isNotEmpty(lineaComercialFuncionarioDTO.getMarcasClone()) 
					&& CollectionUtils.isNotEmpty(marcasNuevas)
					&& marcasNuevas.size() > lineaComercialFuncionarioDTO.getMarcasClone().size()){
				activarMarcasInactivas(lineaComercialFuncionarioDTO, marcasNuevas);
			}
			
			//Si las nuevas son mayores a las de la base
			else if(CollectionUtils.isNotEmpty(lineaComercialFuncionarioDTO.getMarcasClone()) 
					&& CollectionUtils.isNotEmpty(marcasNuevas)
					&& lineaComercialFuncionarioDTO.getMarcasClone().size() > marcasNuevas.size()){
				//Obtenemos las que no existe para inactivar
				Collection<String> marcasInactivar = CollectionUtils.disjunction(lineaComercialFuncionarioDTO.getMarcasClone(), marcasNuevas);
				if(CollectionUtils.isNotEmpty(marcasInactivar)){
					for(String marca:marcasInactivar){
						for(LineaComercialFuncionarioTipoMarcaDTO linComFunTipMarDTO:lineaComercialFuncionarioDTO.getLineaComercialFuncionarioTipoMarcaCol()){
							//if(linComFunTipMarDTO.getTipoMarcaValor().equals(marca)){//TODO ARREGLAR
								linComFunTipMarDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
								linComFunTipMarDTO.setUserId(userId);
								dataGestor.dynamicUpdate(linComFunTipMarDTO);
							//}
						}
					}
				}
			}
			
			//Si no posee registros activos en base
			else if(CollectionUtils.isEmpty(lineaComercialFuncionarioDTO.getMarcasClone())
					&& CollectionUtils.isNotEmpty(marcasNuevas)){
				activarMarcasInactivas(lineaComercialFuncionarioDTO, marcasNuevas);
			}
			
			//Si no posee marcas en memoria
			else if(CollectionUtils.isEmpty(marcasNuevas)
					&& CollectionUtils.isNotEmpty(lineaComercialFuncionarioDTO.getMarcasClone())
					&& SearchDTO.isLoaded(lineaComercialFuncionarioDTO.getLineaComercialFuncionarioTipoMarcaCol())
					&& CollectionUtils.isNotEmpty(lineaComercialFuncionarioDTO.getLineaComercialFuncionarioTipoMarcaCol())){
				//Inactivar las marcas de base
				for(LineaComercialFuncionarioTipoMarcaDTO linComFunTipMarDTO:lineaComercialFuncionarioDTO.getLineaComercialFuncionarioTipoMarcaCol()){
					linComFunTipMarDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					linComFunTipMarDTO.setUserId(userId);
					dataGestor.dynamicUpdate(linComFunTipMarDTO);
				}
			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al asignar las marcas del funcionario de la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al al asignar las marcas del funcionario de la linea comercial {}",e);
		}
	}
	
	/**
	 * Obtiene las marcas inactivas de la linea comercial del funcionario
	 * @param lineaComercialFuncionarioDTO
	 */
	@SuppressWarnings("unchecked")
	public void activarMarcasInactivas(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO, List<String> marcasNuevas)throws SICException{
		try{
			//Obtenemos las marcas nuevas que esten inactivas
			LineaComercialFuncionarioTipoMarcaDTO linComFunTipMar = new LineaComercialFuncionarioTipoMarcaDTO();
			linComFunTipMar.getId().setCodigoCompania(lineaComercialFuncionarioDTO.getId().getCodigoCompania());
			linComFunTipMar.setCodigoLineaComercialFuncionario(lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario());
			linComFunTipMar.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			linComFunTipMar.addCriteriaSearchParameter("tipoMarcaValor", ComparatorTypeEnum.IN_COMPARATOR, marcasNuevas);
			Collection<LineaComercialFuncionarioTipoMarcaDTO> linComFunTipMarCol = dataGestor.findObjects(linComFunTipMar);
			
			//Valida si existe inactivos
			List<String> marcasInactivas = new ArrayList<String>();
			if(CollectionUtils.isNotEmpty(linComFunTipMarCol)){
				for(LineaComercialFuncionarioTipoMarcaDTO linComFunTipMarIna : linComFunTipMarCol){
					//marcasInactivas.add(linComFunTipMarIna.getTipoMarcaValor());//TODO ARREGLAR
					//Activamos los registros
					linComFunTipMarIna.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					linComFunTipMarIna.setUserId(lineaComercialFuncionarioDTO.getUserId());
					dataGestor.dynamicUpdate(linComFunTipMarIna);
				}
			}
			
			//Insertamos los que no existen
			Collection<String> marcasInsertar = CollectionUtils.disjunction(marcasInactivas, marcasNuevas);
			if(CollectionUtils.isNotEmpty(marcasInsertar)){
				for(String marca:marcasInsertar){
					//Consultamos si existe
					LineaComercialFuncionarioTipoMarcaDTO linComFunTipMarTem = new LineaComercialFuncionarioTipoMarcaDTO();
					linComFunTipMarTem.setCodigoLineaComercialFuncionario(lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario());
					//linComFunTipMarTem.setTipoMarcaValor(marca);//TODO ARREGLAR
					linComFunTipMarTem = dataGestor.findUnique(linComFunTipMarTem);
					//Si no existe insertamos
					//if(linComFunTipMarTem == null){
						//crearLineaComercialFuncionarioTipoMarca(lineaComercialFuncionarioDTO.getId().getCodigoCompania(), 
								//lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario(), marca, lineaComercialFuncionarioDTO.getUserId());//TODO ARRELAR
					//}
				}
			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al activar las marcas inactivas del funcionario de la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al activar las marcas inactivas del funcionario de la linea comercial {}",e);
		}
	}
	
	/**
	 * Permite reasignar las clasificaciones de una linea comercial a otra
	 * @param lineaComercialDTO
	 * @param lineaComercialClasificacionCol
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public String reasignarClasificacionesLineaComercial (LineaComercialDTO lineaComercialDTO, Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol)throws SICException{
		validacionLineaComercialGestor.reasignarClasificacionesLineaComercial(lineaComercialDTO,lineaComercialClasificacionCol);
		/**
		 * lineaComercialDTO esta es el objeto que recibe las clasificaciones
		 * lineaComercialClasificacionCol es la coleccion que tiene las clasificaciones
		 */
		try{
			String message="";
			/**
			 * parametros a utilizar 
			 */
			String userId = lineaComercialDTO.getUserId();
			Long codigoLineaComercial = lineaComercialDTO.getId().getCodigoLineaComercial();
			Integer codigoCompania = lineaComercialDTO.getId().getCodigoCompania();
			Long codigoLineaComercialDrag = lineaComercialClasificacionCol.iterator().next().getCodigoLineaComercial();
			/**
			 * se obtiene la informacion completa de la linea comercial due�a de las 
			 * clasificaciones de donde se arrastro 
			 */			
			LineaComercialDTO l=new LineaComercialDTO();
			l.getId().setCodigoLineaComercial(codigoLineaComercialDrag);
			LineaComercialDTO linCom=dataGestor.findUnique(l);
			
					
			if(lineaComercialDTO.getCodigoLineaComercialPadre()!=null && linCom.getCodigoLineaComercialPadre()!=null && lineaComercialDTO.getCodigoLineaComercialPadre().toString().equals(linCom.getCodigoLineaComercialPadre().toString())){
			/**
			 * Aqui se reasigna las clasificaciones de una linea clasificaciones hija a otra hija del mismo padre
			 * se consulta todas las clasificaciones de la linea comercial a ser asignada
			 */
				LineaComercialClasificacionDTO lC=new LineaComercialClasificacionDTO();
				lC.setCodigoLineaComercial(codigoLineaComercial);
				Transformer secTransformer =new GetInvokerTransformer("id.codigoClasificacion");
				lC.addCriteriaSearchParameter("id.codigoClasificacion",ComparatorTypeEnum.IN_COMPARATOR,(List<String>)CollectionUtils.collect(lineaComercialClasificacionCol, secTransformer));

				Collection<LineaComercialClasificacionDTO> linComClas= dataGestor.findObjects(lC);
				
				for(LineaComercialClasificacionDTO lcc: linComClas){
					/**
					 * Aqui se busca el objeto que se encuentra en base para actualizar en la linea due�a de las clasificaciones y se les inactiva
					 * y a la que se le asigna se les activa 
					 */
					LineaComercialClasificacionDTO lccDto= (LineaComercialClasificacionDTO)CollectionUtils.find(lineaComercialClasificacionCol, new EqualsCompositePredicate(lcc, new String[]{"id.codigoClasificacion"}));
						lcc.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						lccDto.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
						dataGestor.update(lcc);
						dataGestor.update(lccDto);
						
						//se remueve las relaciones para la linea comercial que se esta quitando la clasificacion 
						lineaComercialDAO.removerLineaComercialFuncionarioClasificacion(codigoLineaComercialDrag.toString(), Arrays.asList(lccDto.getId().getCodigoClasificacion()));						
						//se agregar las relaciones para la linea comercial que esta recibiendo la clasificacion
						lineaComercialDAO.agregarLineaComercialFuncionarioClasificacion(codigoLineaComercial, userId, Arrays.asList(lcc.getId().getCodigoClasificacion()));
						lineaComercialClasificacionCol.remove(lccDto);
				}
				/**
				 * este caso es cuando las clasificaciones no se encuentren en base en la linea comercial a asignar
				 * en este caso se les modifica el due�o de las clasificaciones ala nueva linea
				 */
				if(CollectionUtils.isNotEmpty(lineaComercialClasificacionCol)){
					lineaComercialDAO.activarInactivarClasificacionesLineaComercial(userId,codigoLineaComercialDrag, codigoLineaComercial, lineaComercialClasificacionCol, SICConstantes.ESTADO_ACTIVO_NUMERICO);
				}
				
			}else if(lineaComercialDTO.getCodigoLineaComercialPadre()!=null && linCom.getCodigoLineaComercialPadre()==null){
				/**
				 * variables a utilizar
				 */
				String codigosClasificaciones = "";
				List<String> codigoClas=new ArrayList<String>();
				/**
				 * 	el IF y ELSE es para obtener los datos para
				 * @param codigosClasificaciones
				 */
				if(lineaComercialClasificacionCol.size()<2){
					codigosClasificaciones=lineaComercialClasificacionCol.iterator().next().getId().getCodigoClasificacion();
					codigoClas.add(codigosClasificaciones);
				}else{
					Transformer transformer =new GetInvokerTransformer("id.codigoClasificacion");
					codigoClas=(List<String>)CollectionUtils.collect(lineaComercialClasificacionCol, transformer);
				}
				Logeable.LOG_SICV2.info("Codigos de clasificaciones a ser asignados: {}",codigosClasificaciones);
				
				/**
				 * aqui se comprueba que las clasificaciones no se encuentren asignadas en otro hijo
				 */
				LineaComercialDTO l1=new LineaComercialDTO();
				l1.addCriteriaSearchParameter("id.codigoLineaComercial",ComparatorTypeEnum.NOT_EQUAL_COMPARATOR,lineaComercialDTO.getId().getCodigoLineaComercial());
				l1.setCodigoLineaComercialPadre(lineaComercialDTO.getCodigoLineaComercialPadre());
				LineaComercialClasificacionDTO lCC=new LineaComercialClasificacionDTO();		
				lCC.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				lCC.addCriteriaSearchParameter("id.codigoClasificacion",ComparatorTypeEnum.IN_COMPARATOR,codigoClas);
				lCC.setLineaComercial(l1);
				
				Collection<LineaComercialClasificacionDTO> linComClasOtrosH=dataGestor.findObjects(lCC);
				/**
				 * aqui se remueve las clasificaciones que se quieren asignar para poder de esta manera solo dejar las que si se pueden modificar
				 */
				if(CollectionUtils.isNotEmpty(linComClasOtrosH)){
					for(LineaComercialClasificacionDTO linComClaEnBaseOH: linComClasOtrosH){
						final String codCAOH=linComClaEnBaseOH.getId().getCodigoClasificacion();
						
						codigoClas.remove((String)CollectionUtils.find(codigoClas, new Predicate() {
							@Override
							public boolean evaluate(Object arg0) {
								return codCAOH.equals(((String)arg0));
							}
						}));
					}
				}
				
				
		if(CollectionUtils.isNotEmpty(codigoClas)){
		/**
		 * aqui se busca en la linea comercial que se quiere asignar
		 * las clasificaciones para realizar el update 
		 */
			LineaComercialDTO l2=new LineaComercialDTO();
			l2.getId().setCodigoLineaComercial(lineaComercialDTO.getId().getCodigoLineaComercial());
			LineaComercialClasificacionDTO lc=new LineaComercialClasificacionDTO();				
			lc.addCriteriaSearchParameter("id.codigoClasificacion",ComparatorTypeEnum.IN_COMPARATOR,codigoClas);
			lc.setLineaComercial(l2);
			
			Collection<LineaComercialClasificacionDTO> linComClas=dataGestor.findObjects(lc);
				
				if(CollectionUtils.isNotEmpty(linComClas)){
					for(LineaComercialClasificacionDTO linComClaEnBase: linComClas){
						/**
						 * se verifica si la LineaComercialClasificacionDTO ya existe en base y si esta en estado false para 
						 * realizar el update
						 */
								if(linComClaEnBase.getEstado().equals(SICConstantes.ESTADO_INACTIVO_NUMERICO)){
									linComClaEnBase.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									dataGestor.update(linComClaEnBase);
								}
							/**
							 * aqui se verifica si las clasificaciones se encuentra en base o si las clasificaciones se deben ingresar		
							 */
								final String codCA=linComClaEnBase.getId().getCodigoClasificacion();
								
								codigoClas.remove((String)CollectionUtils.find(codigoClas, new Predicate() {
									@Override
									public boolean evaluate(Object arg0) {
										return codCA.equals(((String)arg0));
									}
								}));
								
					}
				}
				for(String codC:codigoClas){
					LineaComercialClasificacionDTO linComClaAdd = new LineaComercialClasificacionDTO();
					linComClaAdd.getId().setCodigoCompania(codigoCompania);
					linComClaAdd.getId().setCodigoClasificacion(codC);
					linComClaAdd.setCodigoLineaComercial(codigoLineaComercial);
					linComClaAdd.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					linComClaAdd.setUserId(userId);
					dataGestor.create(linComClaAdd);
				}
		}else{
			message="Las clasificaciones que se desean reasignar ya se encuentran en otra l\u00EDnea comercial ";
	}
}
return message;
//			}
//			linComFunTipMar.addCriteriaSearchParameter("tipoMarcaValor", ComparatorTypeEnum.IN_COMPARATOR, marcasNuevas);
			//Obtenemos las clasificaciones de la linea comercial activa
//			LineaComercialClasificacionDTO linComClaDTO = new LineaComercialClasificacionDTO();
//			linComClaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//			linComClaDTO.getId().setCodigoCompania(codigoCompania);
//			linComClaDTO.setCodigoLineaComercial(codigoLineaComercialDrag);
//			Collection<LineaComercialClasificacionDTO> linComClaCol = dataGestor.findObjects(linComClaDTO);
//			
//			//Removemos de la lista de principal las que existe en la lista obtenida de base
//			if(CollectionUtils.isNotEmpty(linComClaCol)){
//				for(LineaComercialClasificacionDTO linComClaBas : linComClaCol){
//					for(LineaComercialClasificacionDTO linComClaAsi : lineaComercialClasificacionCol){
//						//Validar si existe el codigo
//						if(linComClaBas.getCodigoClasificacion().equals(linComClaAsi.getCodigoClasificacion())){
//							lineaComercialClasificacionCol.remove(linComClaAsi);
//						}
//						break;
//					}
//				}
//			}
			
			//Inactivar clasificaciones de la linea comercial
//			lineaComercialDAO.activarInactivarClasificacionesLineaComercial(userId, codigoLineaComercialDrag,null, lineaComercialClasificacionColClone, SICConstantes.ESTADO_INACTIVO_NUMERICO);
			
			//Insertamos las clasificaciones a la linea comercial
//			if(CollectionUtils.isNotEmpty(lineaComercialClasificacionCol)){
//				for(LineaComercialClasificacionDTO linComCla:lineaComercialClasificacionCol){
//					LineaComercialClasificacionDTO linComClaAdd = new LineaComercialClasificacionDTO();
//					linComClaAdd.getId().setCodigoCompania(linComCla.getId().getCodigoCompania());
//					linComClaAdd.setCodigoClasificacion(linComCla.getCodigoClasificacion());
//					linComClaAdd.setCodigoLineaComercial(codigoLineaComercial);
//					linComClaAdd.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//					linComClaAdd.setUserId(userId);
//					dataGestor.create(linComClaAdd);
//				}
//			}
			
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al reasignar clasificaciones de una linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al reasignar clasificaciones de una linea comercial {}",e);
		}
	}
	
	/**
	 * Permite configurar las marcas de un funcionario por tipo de marca
	 * @param funcionarioTipoMarcaDTO
	 * @param marcasAsignadas
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public void crearMarcasFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO, Collection<MarcaArticuloDTO> marcasAsignadas)throws SICException{
		validacionLineaComercialGestor.crearMarcasFuncionarioTipoMarca(funcionarioTipoMarcaDTO, marcasAsignadas);
		try{
			Collection<MarcaArticuloDTO> marcasFinales = marcasAsignadas;
			//Obtenemos los codigos de las marcas
			Transformer secuencialMarcaTransformer = new GetInvokerTransformer("id.secuencialMarca");
			List<Long> codigosMarcasFuncionario = (List<Long>)CollectionUtils.collect(marcasAsignadas, secuencialMarcaTransformer);
			
			//Obtenemos las marcas inactivas asignadas al tipo de marca del funcionario
			MarcaFuncionarioTipoMarcaDTO marFunTipMarDTO = new MarcaFuncionarioTipoMarcaDTO();
			marFunTipMarDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			marFunTipMarDTO.setCodigoFuncionarioTipoMarca(funcionarioTipoMarcaDTO.getId().getCodigoFuncionarioTipoMarca());
			marFunTipMarDTO.addCriteriaSearchParameter("codigoMarca", ComparatorTypeEnum.IN_COMPARATOR, codigosMarcasFuncionario);
			Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol = dataGestor.findObjects(marFunTipMarDTO);
			if(CollectionUtils.isNotEmpty(marcaFuncionarioTipoMarcaCol)){
				//Activamos las marcas para el tipo de marca del funcionario
				codigosMarcasFuncionario.clear();
				for(MarcaFuncionarioTipoMarcaDTO marcaFuncionarioTipoMarca:marcaFuncionarioTipoMarcaCol){
					marcaFuncionarioTipoMarca.setUserId(funcionarioTipoMarcaDTO.getUserId());
					marcaFuncionarioTipoMarca.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					dataGestor.dynamicUpdate(marcaFuncionarioTipoMarca);
					codigosMarcasFuncionario.add(marcaFuncionarioTipoMarca.getCodigoMarca());
				}
				
				//Obtenemos las marcas finales que se debe insertar
				marcasFinales = ColeccionesUtil.getInstance().selectWithNotIn(marcasAsignadas, "id.secuencialMarca", codigosMarcasFuncionario);
				
			}
			
			
			//Iteramos las marcas a asignar al funcionario
			for(MarcaArticuloDTO marcaArticuloDTO:marcasFinales){
				MarcaFuncionarioTipoMarcaDTO marcaFuncionarioTipoMarcaDTO = new MarcaFuncionarioTipoMarcaDTO();
				marcaFuncionarioTipoMarcaDTO.getId().setCodigoCompania(funcionarioTipoMarcaDTO.getId().getCodigoCompania());
				marcaFuncionarioTipoMarcaDTO.setCodigoFuncionarioTipoMarca(funcionarioTipoMarcaDTO.getId().getCodigoFuncionarioTipoMarca());
				marcaFuncionarioTipoMarcaDTO.setCodigoMarca(marcaArticuloDTO.getId().getSecuencialMarca());
				marcaFuncionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				marcaFuncionarioTipoMarcaDTO.setUserId(funcionarioTipoMarcaDTO.getUserId());
				dataGestor.create(marcaFuncionarioTipoMarcaDTO);
			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al crear las marcas del funcionario por tipos de marca {}",e);
			throw new SICException("Ha ocurrido un error al crear las marcas del funcionario por tipo de marca {}",e);
		}
	}
	
	
	/**
	 * Permite eliminar la marca del funcionario por el tipo de marca
	 * @param marcaFuncionarioTipoMarcaDTO
	 * @throws SICException
	 */
	public void eliminarMarcaFuncionarioTipoMarca(MarcaFuncionarioTipoMarcaDTO marcaFuncionarioTipoMarcaDTO)throws SICException{
		validacionLineaComercialGestor.eliminarMarcaFuncionarioTipoMarca(marcaFuncionarioTipoMarcaDTO);
		try{
			marcaFuncionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			dataGestor.dynamicUpdate(marcaFuncionarioTipoMarcaDTO);
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al inactivar la marca del funcionario por tipo de marca {}",e);
			throw new SICException("Ha ocurrido un error al inactivar la marca del funcionario por tipo de marca {}",e);
		}
	}
	
	/**
	 * Permite eliminar las marcas del funcionario por el tipo de marca
	 * @param marcaFuncionarioTipoMarcaCol
	 * @throws SICException
	 */
	public void eliminarMarcaFuncionarioTipoMarca(Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol, String userId)throws SICException{
		validacionLineaComercialGestor.eliminarMarcaFuncionarioTipoMarca(marcaFuncionarioTipoMarcaCol, userId);
		try{
			for(MarcaFuncionarioTipoMarcaDTO marcaFuncionarioTipoMarcaDTO:marcaFuncionarioTipoMarcaCol){
				marcaFuncionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				dataGestor.update(marcaFuncionarioTipoMarcaDTO);
			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al inactivar las marcas del funcionario por tipo de marca {}",e);
			throw new SICException("Ha ocurrido un error al inactivar las marcas del funcionario por tipo de marca {}",e);
		}
	}
	
	/**
	 * Permite eliminar el tipo de marca del funcionario
	 * @param funcionarioTipoMarcaDTO
	 * @throws SICException
	 */
	public void eliminarFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO)throws SICException{
		validacionLineaComercialGestor.eliminarFuncionarioTipoMarca(funcionarioTipoMarcaDTO);
		try{
			funcionarioTipoMarcaDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
//			dataGestor.dynamicUpdate(funcionarioTipoMarcaDTO);
			//	//LineaComercialFuncionarioTipoMarcaDTO
			//Buscamos la linea comercial del funcionario del tipo de marca
			LineaComercialFuncionarioTipoMarcaDTO linComFunTipMarDTO = new LineaComercialFuncionarioTipoMarcaDTO();
			linComFunTipMarDTO.setCodigoFuncionarioTipoMarca(funcionarioTipoMarcaDTO.getId().getCodigoFuncionarioTipoMarca());
			linComFunTipMarDTO.setCodigoLineaComercialFuncionario(funcionarioTipoMarcaDTO.getLineaComercialFuncionarioDTO().getId().getCodigoLineaComercialFuncionario());
			linComFunTipMarDTO = dataGestor.findUnique(linComFunTipMarDTO);
			if(SearchDTO.isLoaded(linComFunTipMarDTO)){
				linComFunTipMarDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				linComFunTipMarDTO.setUserId(funcionarioTipoMarcaDTO.getUserId());
				dataGestor.dynamicUpdate(linComFunTipMarDTO);
			}
			
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al inactivar el tipo de marca del funcionario {}",e);
			throw new SICException("Ha ocurrido un error al inactivar el tipo de marca del funcionario {}",e);
		}
	}
	
	/**
	 * Este metodo permite la validacion de 
	 * clasificacion solo puede estar en linea comercial de distinto tipo
	 * 
	 * @param userId
	 * @param lineaComercialDTO
	 * @return
	 */
	public Collection<LineaComercialClasificacionDTO> crearObtenerLineaComercialClasificacionAsignadas(String userId,LineaComercialDTO lineaComercialDTO)throws SICException{
		
		ParametroDTO parametroClasificaciones = new ParametroDTO();
		parametroClasificaciones.getId().setCodigoParametro(SICParametros.getInstancia().ACTIVAR_VALIDACION_CLASIFICACION_TIPO_LINEA_COMERCIAL);
		
		long codigoLinCom=lineaComercialDTO.getId().getCodigoLineaComercial();
		Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionDTOs=new ArrayList<LineaComercialClasificacionDTO>();
		
		try{
			parametroClasificaciones = dataGestor.findUnique(parametroClasificaciones);

			if(Boolean.valueOf(parametroClasificaciones.getValorParametro())){
			
				String tipLinCom=lineaComercialDTO.getValorTipoLineaComercial();
				
				Logeable.LOG_SICV2.info("codigo hijo: {} codigo padre: {}",codigoLinCom,lineaComercialDTO.getCodigoLineaComercialPadre());
				
				/**
				 * se establece si la lineaComercialDTO trae clasificaciones de tipo divicion
				 */
				for(ClasificacionDTO divisionesCol:lineaComercialDTO.getDivisionesCol()){
					String codigoDivDep="'"+divisionesCol.getId().getCodigoClasificacion()+"'";
					String tipClas=SICConstantes.TIPCLA_DIVISION;
					/**
					 * se obtiene los codigos de las clasificaciones que si se ingresaran
					 */
					Collection<String> codigosClasificacion= lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaIngresar(codigoDivDep,tipClas,tipLinCom,lineaComercialDTO.getCodigoLineaComercialPadre(),lineaComercialDTO.getId().getCodigoLineaComercial());
					/**
					 * se obtiene los LineaComercialClasificacionDTO para mostrar 
					 * esplicando que nop cumplen la regla
					 */
					Collection<LineaComercialClasificacionDTO> lcs=lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaNoIngresar(codigoDivDep,tipClas,tipLinCom,String.valueOf(lineaComercialDTO.getCodigoLineaComercialPadre()));
					/**
					 * aqui se ingresara las clasificaciones seleccionadas y aprobadas para ingresar
					 */
					if(CollectionUtils.isNotEmpty(codigosClasificacion)){
						lineaComercialDAO.activarClasificaciones(userId, codigoLinCom, codigosClasificacion);
						lineaComercialDAO.activarClasificacionesFuncionario(userId, codigoLinCom);
						if(lineaComercialDTO.getCodigoLineaComercialPadre() != null){
							lineaComercialDAO.activarClasificaciones(userId, lineaComercialDTO.getCodigoLineaComercialPadre(), codigosClasificacion);
							lineaComercialDAO.activarClasificacionesFuncionario(userId, lineaComercialDTO.getCodigoLineaComercialPadre());
						}
					}
					
					lineaComercialClasificacionDTOs.addAll(lcs);
				}
				
				
				for(ClasificacionDTO departamentosCol:lineaComercialDTO.getDepartamentosCol()){
					
					String codigoDivDep="'"+departamentosCol.getId().getCodigoClasificacion()+"'";
					String tipClas=SICConstantes.TIPCLA_DEPARTAMENTO;
					
					Collection<String> codigosClasificacion= lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaIngresar(codigoDivDep,tipClas,tipLinCom,lineaComercialDTO.getCodigoLineaComercialPadre(),lineaComercialDTO.getId().getCodigoLineaComercial());
					Collection<LineaComercialClasificacionDTO> lcs=lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaNoIngresar(codigoDivDep,tipClas,tipLinCom,String.valueOf(lineaComercialDTO.getCodigoLineaComercialPadre()));
					
					if(CollectionUtils.isNotEmpty(codigosClasificacion)){
						lineaComercialDAO.activarClasificaciones(userId, codigoLinCom, codigosClasificacion);
						lineaComercialDAO.activarClasificacionesFuncionario(userId, codigoLinCom);
						if(lineaComercialDTO.getCodigoLineaComercialPadre() != null){
							lineaComercialDAO.activarClasificaciones(userId, lineaComercialDTO.getCodigoLineaComercialPadre(), codigosClasificacion);
							lineaComercialDAO.activarClasificacionesFuncionario(userId, lineaComercialDTO.getCodigoLineaComercialPadre());
						}
					}
					lineaComercialClasificacionDTOs.addAll(lcs);
				}
				
				if(CollectionUtils.isNotEmpty(lineaComercialDTO.getClasificacionesCol())){
					gestionarClasificaciones(lineaComercialDTO.getClasificacionesCol(), lineaComercialClasificacionDTOs, tipLinCom, lineaComercialDTO.getCodigoLineaComercialPadre(), codigoLinCom, userId);
				}
			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al consultar las clasificaciones asignadas a la linea comercial {}",e);
			throw new SICException("Ha ocurrido un error al consultar las clasificaciones asignadas a la linea comercial {}",e);
		}
		return lineaComercialClasificacionDTOs;
	}
	
	
	private void gestionarClasificaciones(Collection<ClasificacionDTO> clasificacionCol,Collection<LineaComercialClasificacionDTO> lCCDto,String tipLinCom,Long codLinComP,Long codigoLinCom, String userId){
		int max=1000;
		Transformer t2=new GetInvokerTransformer("id.codigoClasificacion");
		List<String> codigoClasificacionCla=(List<String>)CollectionUtils.collect(clasificacionCol, t2);
		String tipClas=SICConstantes.TIPCLA_CLASIFICACION;
		Collection<String> codigosClasificacion=new ArrayList<String>();
		Collection<LineaComercialClasificacionDTO> lcs=new ArrayList<LineaComercialClasificacionDTO>();
		
		if(CollectionUtils.isNotEmpty(codigoClasificacionCla)){
			Collections.sort(codigoClasificacionCla);
			String codigoClaDep="";
			if(codigoClasificacionCla.size()< max){
				codigoClaDep=StringUtils.join(codigoClasificacionCla,"','");
				codigoClaDep="'"+codigoClaDep+"'";
				//metodo consulta las clasificaciones a asignar 
				codigosClasificacion= lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaIngresar(codigoClaDep,tipClas,tipLinCom,codLinComP,codigoLinCom);
				//metodo consulta las clasificaciones que no se van a asignar
				lcs=lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaNoIngresar(codigoClaDep,tipClas,tipLinCom,String.valueOf(codLinComP));
			}else{
				List<String> aux=new ArrayList<String>();
				int i=0;
				for(String cC: codigoClasificacionCla){
					aux.add(cC);
					if(i == max){
						codigoClaDep=StringUtils.join(aux,"','");
						codigoClaDep="'"+codigoClaDep+"'";
						//metodo consulta las clasificaciones a asignar 
						codigosClasificacion.addAll(lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaIngresar(codigoClaDep,tipClas,tipLinCom,codLinComP,codigoLinCom)) ;
						//metodo consulta las clasificaciones que no se van a asignar
						lcs.addAll(lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaNoIngresar(codigoClaDep,tipClas,tipLinCom,String.valueOf(codLinComP)));									
						aux=new ArrayList<String>();
						i=0;
					}								
					i++;
				}
				if(CollectionUtils.isNotEmpty(aux)){
					codigoClaDep=StringUtils.join(aux,"','");
					codigoClaDep="'"+codigoClaDep+"'";
					//metodo consulta las clasificaciones a asignar 
					codigosClasificacion.addAll(lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaIngresar(codigoClaDep,tipClas,tipLinCom,codLinComP,codigoLinCom)) ;
					//metodo consulta las clasificaciones que no se van a asignar
					lcs.addAll(lineaComercialDAO.consultarLineaComercialClasificacionAsignacionMasivaNoIngresar(codigoClaDep,tipClas,tipLinCom,String.valueOf(codLinComP)));					
				}
				
			}
		}
		
		if(CollectionUtils.isNotEmpty(lcs)){
			lCCDto.addAll(lcs);
		}
		
		if(CollectionUtils.isNotEmpty(codigosClasificacion)){
			if(codigosClasificacion.size()<max){
				//metodo
				lineaComercialDAO.activarClasificaciones(userId, codigoLinCom, codigosClasificacion);
				lineaComercialDAO.activarClasificacionesFuncionario(userId, codigoLinCom);
				if(codLinComP != null){
					//metodo
					lineaComercialDAO.activarClasificaciones(userId, codLinComP, codigosClasificacion);
					lineaComercialDAO.activarClasificacionesFuncionario(userId, codLinComP);
				}
			}else{
				List<String> aux=new ArrayList<String>();
				int i=0;
				for(String cC: codigosClasificacion){
					aux.add(cC);
					if(i == max){
						lineaComercialDAO.activarClasificaciones(userId, codigoLinCom, aux);
						lineaComercialDAO.activarClasificacionesFuncionario(userId, codigoLinCom);
						if(codLinComP != null){
							lineaComercialDAO.activarClasificaciones(userId, codLinComP, aux);
							lineaComercialDAO.activarClasificacionesFuncionario(userId, codLinComP);
						}									
						aux=new ArrayList<String>();
						i=0;
					}								
					i++;
				}
				if(CollectionUtils.isNotEmpty(aux)){
					lineaComercialDAO.activarClasificaciones(userId, codigoLinCom, aux);
					lineaComercialDAO.activarClasificacionesFuncionario(userId, codigoLinCom);
					if(codLinComP != null){
						lineaComercialDAO.activarClasificaciones(userId, codLinComP, aux);
						lineaComercialDAO.activarClasificacionesFuncionario(userId, codLinComP);
					}
				}
			}
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	/**
	 * Permite obtener las LineaComercialClasificacionDTO
	 * que no se an asignado a un funcionario
	 * en especifico
	 * @param codigoLineaComercial
	 * @param codigoLineaComercialFuncionario
	 * @return
	 */
	public Collection<LineaComercialClasificacionDTO> obtenerClasificacionesFuncionario(Long codigoLineaComercial, Long codigoLineaComercialFuncionario)throws SICException{
		try{
			return lineaComercialDAO.consultarClaificacionesFuncionario(codigoLineaComercial,codigoLineaComercialFuncionario);
		}catch (Exception e) {
				Logeable.LOG_SICV2.error("Error al consultar las clasificaciones asignadas a un funcionario de la linea comercial {}",e);
				throw new SICException("Ha ocurrido un error al consultar las clasificaciones asignadas a un funcionario de la linea comercial {}",e);
			}
		}
	/**
	 * permite guardar LineaComercialFuncionarioClasificacion
	 * @param lineaComercialFuncionarioClasificacionDTOs
	 */
	public void guardarLineaComercialFuncionarioClasificacion(Collection<LineaComercialFuncionarioClasificacionDTO> lineaComercialFuncionarioClasificacionDTOs)throws SICException{
		try{
			ArrayList<Long> codLinComCl=new ArrayList<Long>();
			ArrayList<Long> codLinComFun=new ArrayList<Long>();
			for(LineaComercialFuncionarioClasificacionDTO linComFunCl: lineaComercialFuncionarioClasificacionDTOs){
				codLinComCl.add(linComFunCl.getCodigoLineaComercialClasificacion());
				codLinComFun.add(linComFunCl.getCodigoLineaComercialFuncionario());
			}
						
			LineaComercialFuncionarioClasificacionDTO linComFCDto=new LineaComercialFuncionarioClasificacionDTO();
			
			linComFCDto.addCriteriaSearchParameter("codigoLineaComercialClasificacion",ComparatorTypeEnum.IN_COMPARATOR,codLinComCl);
			linComFCDto.addCriteriaSearchParameter("codigoLineaComercialFuncionario",ComparatorTypeEnum.IN_COMPARATOR,codLinComFun);
			Collection<LineaComercialFuncionarioClasificacionDTO> lDtos=dataGestor.findObjects(linComFCDto);
			if(CollectionUtils.isEmpty(lDtos)){
				for(LineaComercialFuncionarioClasificacionDTO linComFunCl: lineaComercialFuncionarioClasificacionDTOs){
					dataGestor.create(linComFunCl);
				}
			}else{
				Boolean existe=Boolean.FALSE;
				for(LineaComercialFuncionarioClasificacionDTO linComFunCl2: lineaComercialFuncionarioClasificacionDTOs){
				for(LineaComercialFuncionarioClasificacionDTO linComFunCl3: lDtos)	{
					
					if(String.valueOf(linComFunCl2.getCodigoLineaComercialClasificacion()).equals(String.valueOf(linComFunCl3.getCodigoLineaComercialClasificacion())) &&
							String.valueOf(linComFunCl2.getCodigoLineaComercialFuncionario()).equals(String.valueOf(linComFunCl3.getCodigoLineaComercialFuncionario()))){
					
						linComFunCl3.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.update(linComFunCl3);
						existe=Boolean.TRUE;
						break;
					}
				}
				if(!existe){
					dataGestor.create(linComFunCl2);
				}
				
				}
			}
			
			
			
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al guardar Linea Comercial Funcionario Clasificacion {}",e);
			throw new SICException("Ha ocurrido un error al guardar Linea Comercial Funcionario Clasificacion {}",e);
		}
	}
	
	/**
	 * Elimina la clasificacion especifica de la linea comercial del funcionario
	 * @param linComFunCl
	 * @throws SICException
	 */
	public void eliminarLineaComercialFuncionarioClasificacion(LineaComercialFuncionarioClasificacionDTO linComFunCl)throws SICException{
		try{
			linComFunCl.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			dataGestor.update(linComFunCl);
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al eliminar LineaComercialFuncionarioClasificacion {}",e);
			throw new SICException("Ha ocurrido un error al eliminar LineaComercialFuncionarioClasificacion {}",e);
		}
	}
	
	@Override
	public Collection<InformacionFuncionarioTipoMarca> consultarFuncionarioTipoMarca(FuncionarioDTO funcionarioDTO) throws SICException {
		Collection<InformacionFuncionarioTipoMarca> tiposMarcaFuncionarioCol = null;
		Collection<FuncionarioTipoMarcaDTO> funcionarioTipoMarcaCol = null;
		MarcaFuncionarioTipoMarcaDTO plantillaMarcaFuncionarioTipoMarca = null;
		try{
			FuncionarioTipoMarcaDTO funcionarioTipoMarcaPlantilla = new FuncionarioTipoMarcaDTO();
			funcionarioTipoMarcaPlantilla.addCriteriaSearchParameter("codigoFuncionario", ComparatorTypeEnum.EQUAL_COMPARATOR,funcionarioDTO.getId().getCodigoFuncionario()); 
			funcionarioTipoMarcaPlantilla.getId().setCodigoCompania(funcionarioDTO.getId().getCodigoCompania());
			funcionarioTipoMarcaPlantilla.setTipoMarca(new  CatalogoValorDTO());
			funcionarioTipoMarcaPlantilla.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			funcionarioTipoMarcaCol = dataGestor.findObjects(funcionarioTipoMarcaPlantilla);
			if(!CollectionUtils.isEmpty(funcionarioTipoMarcaCol)){
				tiposMarcaFuncionarioCol = new ArrayList<InformacionFuncionarioTipoMarca>();
				
				for(FuncionarioTipoMarcaDTO funTipMar : funcionarioTipoMarcaCol){
					if(funTipMar.getTipoMarca() != null &&
							funTipMar.getCodigoTipoMarca() != null &&
							funTipMar.getValorTipoMarca() != null){
						InformacionFuncionarioTipoMarca informacionFuncionario = new InformacionFuncionarioTipoMarca();
						plantillaMarcaFuncionarioTipoMarca = new MarcaFuncionarioTipoMarcaDTO();
						plantillaMarcaFuncionarioTipoMarca.getId().setCodigoCompania(funcionarioDTO.getId().getCodigoCompania());
						plantillaMarcaFuncionarioTipoMarca.setCodigoFuncionarioTipoMarca(funTipMar.getId().getCodigoFuncionarioTipoMarca());
						plantillaMarcaFuncionarioTipoMarca.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						Long numeroRegistros = dataGestor.findCount(plantillaMarcaFuncionarioTipoMarca);
						if(numeroRegistros != null && numeroRegistros > 0){
							informacionFuncionario.setTieneMarcasAgregadas(Boolean.TRUE);
						}else{
							informacionFuncionario.setTieneMarcasAgregadas(Boolean.FALSE);
						}
						informacionFuncionario.setFuncionarioTipoMarca(funTipMar.getTipoMarca());
						informacionFuncionario.setCodigoFuncionarioTipoMarca(funTipMar.getId().getCodigoFuncionarioTipoMarca());
						tiposMarcaFuncionarioCol.add(informacionFuncionario);
						
					}
				}
				Logeable.LOG_SICV2.info("*Ha consultado : {} tipos de marca para el funcionario: {}", tiposMarcaFuncionarioCol.size(), funcionarioDTO.getId().getCodigoFuncionario());
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar los tipos de marca del funcionario {}",e);
			throw new SICException("Ha ocurrido un error al consultar los tipos de marca del funcionario {}",e);
		}
		
		// TODO Auto-generated method stub
		return tiposMarcaFuncionarioCol;
	}
	
	/**
	 * Consulta las lineas comercial del funcionario 
	 * @param funcionarioDTO
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public Collection<InformacionFuncionarioLineaComercial> consultarFuncionarioLineasComerciales(FuncionarioDTO funcionarioDTO) throws SICException{
		Collection<InformacionFuncionarioLineaComercial> lineasComercialFuncionarios = null;
		try{
			LineaComercialDTO lineaComercialDTO = new LineaComercialDTO();
			lineaComercialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			LineaComercialFuncionarioDTO lineaComercialFuncionarioPlantilla = new LineaComercialFuncionarioDTO();
			lineaComercialFuncionarioPlantilla.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			lineaComercialFuncionarioPlantilla.getId().setCodigoCompania(funcionarioDTO.getId().getCodigoCompania());
			lineaComercialFuncionarioPlantilla.getId().setCodigoFuncionario(funcionarioDTO.getId().getCodigoFuncionario());
			lineaComercialFuncionarioPlantilla.setLineaComercial(lineaComercialDTO);
			lineaComercialFuncionarioPlantilla.setOrderByField(OrderBy.orderDesc("lineaComercial.codigoLineaComercialPadre"));
			
			Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioCol = dataGestor.findObjects(lineaComercialFuncionarioPlantilla);
			if(CollectionUtils.isNotEmpty(lineaComercialFuncionarioCol)){
				
				//Obtenemos las lineas comerciales
				Transformer lineaComercialTransformer = new GetInvokerTransformer("lineaComercial");
				Collection<LineaComercialDTO> lineaComercialCol = CollectionUtils.collect(lineaComercialFuncionarioCol, lineaComercialTransformer);
				
				//Obtenemos las lineas comerciales solo padres y solo hijas
				Collection<LineaComercialDTO> lineaComercialPadres = new ArrayList<LineaComercialDTO>();
				Collection<LineaComercialDTO> lineaComercialHijos = new ArrayList<LineaComercialDTO>();
				for(LineaComercialDTO lineaComercial: lineaComercialCol){
					if(lineaComercial.getCodigoLineaComercialPadre()==null){
						lineaComercialPadres.add(lineaComercial);
					}else{
						lineaComercialHijos.add(lineaComercial);
					}
				}
				
				//Almacena todas las lineas comerciales consultadas
				Collection<LineaComercialDTO> lineasComercialFinales = new ArrayList<LineaComercialDTO>();
				//consultar las lineas comerciales  
				lineasComercialFinales = obtenerTodasLineasComerciales(lineaComercialHijos,lineaComercialPadres);
				
				//LLenamos la lista de informacion de las lineas comerciales
				if(CollectionUtils.isNotEmpty(lineasComercialFinales)){
					lineasComercialFuncionarios = new ArrayList<InformacionFuncionarioLineaComercial>();
					InformacionFuncionarioLineaComercial informacionFuncionarioLineaComercial;
					for(LineaComercialDTO lineaComercial : lineasComercialFinales){
						informacionFuncionarioLineaComercial = new InformacionFuncionarioLineaComercial();
						informacionFuncionarioLineaComercial.setCodigoLineaComercial(lineaComercial.getId().getCodigoLineaComercial());
						informacionFuncionarioLineaComercial.setNombre(lineaComercial.getNombre());
						informacionFuncionarioLineaComercial.setDescripcion(lineaComercial.getDescripcion());
						informacionFuncionarioLineaComercial.setCodigoLineaComercialPadre(lineaComercial.getCodigoLineaComercialPadre());
						informacionFuncionarioLineaComercial.setCodigoEstablecimiento(lineaComercial.getCodigoEstablecimiento());
						informacionFuncionarioLineaComercial.setNivel(lineaComercial.getNivel());
						informacionFuncionarioLineaComercial.setValorTipoLineaComercial(lineaComercial.getValorTipoLineaComercial());
						informacionFuncionarioLineaComercial.setCodigoTipoLineaComercial(lineaComercial.getCodigoTipoLineaComercial());
						informacionFuncionarioLineaComercial.setCodigoReferencia(lineaComercial.getCodigoReferencia());
						lineasComercialFuncionarios.add(informacionFuncionarioLineaComercial);
					}
					
					Logeable.LOG_SICV2.info("*Ha consultado : {} lineas comerciales del funcionario: {}", lineasComercialFuncionarios.size(), funcionarioDTO.getId().getCodigoFuncionario());
				}
			}
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar las lineas comerciales del funcionario {}",e);
			throw new SICException("Ha ocurrido un error al consultar las lineas comerciales del funcionario {}",e);
		}
		return lineasComercialFuncionarios;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	private Collection<LineaComercialDTO> obtenerTodasLineasComerciales(Collection<LineaComercialDTO> linComHijos,Collection<LineaComercialDTO> linComPadre){
		try {
			Transformer codigosLineasHTransformer = new GetInvokerTransformer("codigoLineaComercialRaiz");
			Collection<Long> codlinComHijos = CollectionUtils.collect(linComHijos, codigosLineasHTransformer);
			
			Transformer codigosLineasPTransformer = new GetInvokerTransformer("codigoLineaComercialRaiz");
			Collection<Long> codLinComPadres = CollectionUtils.collect(linComPadre, codigosLineasPTransformer);
			
			Collection<LineaComercialDTO> lineasComercialFinales = new ArrayList<LineaComercialDTO>();
			
			Set<Long> codigosLineasComerciales = new HashSet<Long>();
			
			codigosLineasComerciales.addAll(codlinComHijos);			
			codigosLineasComerciales.addAll(codLinComPadres);
			
			codigosLineasComerciales.remove(null);
			
			if(CollectionUtils.isNotEmpty(codigosLineasComerciales)){
				LineaComercialDTO lineaComercialDTO = new LineaComercialDTO();
				lineaComercialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				lineaComercialDTO.addCriteriaSearchParameter("codigoLineaComercialRaiz", ComparatorTypeEnum.IN_COMPARATOR, codigosLineasComerciales);
				lineasComercialFinales = dataGestor.findObjects(lineaComercialDTO);
			}
			
			
			return lineasComercialFinales;
			
		} catch (DAOException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}
	}
	
	
	//----------------------------------------------------------------------------------------------------------------
	// 	INICIO DE METODOS PRIVADOS
	//----------------------------------------------------------------------------------------------------------------
	/**
	 * Permite obetener los hijos de las lineas comerciales padre
	 * @param lineaComercialPadres
	 */
	@SuppressWarnings("unchecked")
	private void obtenerHijosLineaComercial(Collection<LineaComercialDTO> lineaComercialPadres, Collection<LineaComercialDTO> lineasComercialFinales){
		if(CollectionUtils.isNotEmpty(lineaComercialPadres)){
			//Obtenemos los codigos de las lineas comerciales para consultar si poseen hijos
			Transformer codigosLineasTransformer = new GetInvokerTransformer("id.codigoLineaComercial");
			Collection<Long> codLinPadres = CollectionUtils.collect(lineaComercialPadres, codigosLineasTransformer);
			Collection<Long> codigosLineasPadres = new ArrayList<Long>();
			
			for(Long codlinP: codLinPadres){
				if(codlinP != null){
					codigosLineasPadres.add(codlinP);
				}
			}
			
			Collection<LineaComercialDTO> lineaComercialHijasCol = null;

			if(CollectionUtils.isNotEmpty(codigosLineasPadres)){
				LineaComercialDTO lineaComercialDTO = new LineaComercialDTO();
				lineaComercialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				lineaComercialDTO.addCriteriaSearchParameter("codigoLineaComercialPadre", ComparatorTypeEnum.IN_COMPARATOR, codigosLineasPadres);
				lineaComercialHijasCol = dataGestor.findObjects(lineaComercialDTO);
			}
			
			if(CollectionUtils.isNotEmpty(lineaComercialHijasCol)){
				//Agregamos las lineas comerciales a las finales
				lineasComercialFinales.addAll(lineaComercialHijasCol);
				obtenerHijosLineaComercial(lineaComercialHijasCol, lineasComercialFinales);
			}
		}
	}
	
	/**
	 * Permite obtener los padres de las lineas comerciales
	 * @param lineaComercialHijas
	 * @param lineasComercialFinales
	 */
	@SuppressWarnings("unchecked")
	private void obtenerPadresLineaComercial(Collection<LineaComercialDTO> lineaComercialHijas, Collection<LineaComercialDTO> lineasComercialFinales){
		if(CollectionUtils.isNotEmpty(lineaComercialHijas)){
			//Obtenemos los codigos de las lineas comerciales para consultar sus padres
			Transformer codigosLineasTransformer = new GetInvokerTransformer("codigoLineaComercialPadre");
			Collection<Long> codigLinHijas = CollectionUtils.collect(lineaComercialHijas, codigosLineasTransformer);
			Collection<Long> codigosLineasHijas = new ArrayList<Long>();
			for(Long codLinH : codigLinHijas){
				if(codLinH != null){
					codigosLineasHijas.add(codLinH);
				}
			}
			Collection<LineaComercialDTO> lineaComercialPadresCol = null;
			if(CollectionUtils.isNotEmpty(codigosLineasHijas)){
				LineaComercialDTO lineaComercialDTO = new LineaComercialDTO();
				lineaComercialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				lineaComercialDTO.addCriteriaSearchParameter("id.codigoLineaComercial", ComparatorTypeEnum.IN_COMPARATOR, codigosLineasHijas);
				lineaComercialPadresCol = dataGestor.findObjects(lineaComercialDTO);
			}
			if(CollectionUtils.isNotEmpty(lineaComercialPadresCol)){
				//Agregamos las lineas comerciales a las finales
				lineasComercialFinales.addAll(lineaComercialPadresCol);
				obtenerPadresLineaComercial(lineaComercialPadresCol, lineasComercialFinales);
			}
		}
	}
	@Override
	public void addCriterioRestriccionCodigoReferencia(LineaComercialDTO searchDTO){
		String nombre=searchDTO.getNombre();
		String codReferencia=searchDTO.getCodigoReferencia();
		searchDTO.setNombre(null);
		searchDTO.setCodigoReferencia(null);
		if(CollectionUtils.isEmpty(searchDTO.getCriteriaRestrictions())){
			searchDTO.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
		}
		searchDTO.getCriteriaRestrictions().add(new RestriccionCodigoReferencia(codReferencia,nombre));
	}
	
	@SuppressWarnings("serial")
	class RestriccionCodigoReferencia implements CriteriaRestriction{
		private String codRef;
		private String nom;
		public RestriccionCodigoReferencia(String codigoReferencia,String nombre){
			this.codRef =  codigoReferencia;
			this.nom= nombre;
		}
		@Override
		public Criterion getCriteriaRestriction() {
			Disjunction disjunction= Restrictions.disjunction();
			disjunction.add(Restrictions.eq("codigoReferencia", codRef));
			disjunction.add(Restrictions.eq("nombre", nom));
			return disjunction;
		}
	}
	
	@Override
	public void addCriterioRestriccionPerfilColaborador(SearchDTO searchDTO){
		if(CollectionUtils.isEmpty(searchDTO.getCriteriaRestrictions())){
			searchDTO.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
		}
		searchDTO.getCriteriaRestrictions().add(new RestriccionPerfilColaborador());
	}
	
	@SuppressWarnings("serial")
	class RestriccionPerfilColaborador implements CriteriaRestriction{
		
		@Override
		public Criterion getCriteriaRestriction() {
			Disjunction disjunction= Restrictions.disjunction();
			disjunction.add(Restrictions.ne("referenceCode", CorporativoConstantes.REFERENCECODE_PERFIL_COLABORADOR));
			disjunction.add(Restrictions.isNull("referenceCode"));
			return disjunction;
		}
	}
	/**
	 * METODOS PARA RELACION DE CLIENTE IMPORTACION
	 */
	@Override
	public Collection<ClienteImportacionDTO> consultarClienteImportacion()throws SICException{
		return lineaComercialDAO.consultarClienteImportacion();
	}
	
	
	@Override
	public void guardarClienteImportacionLineaComercial(LineaComercialDTO linComDTO,Collection<ClienteImportacionDTO> clienteImpDTOCol,Integer codigoCompania,String userID)throws SICException{
		try {
			for(ClienteImportacionDTO clientImpDTO : clienteImpDTOCol){
				clientImpDTO.getId().setCodigoCompania(codigoCompania);
				guardarClientImpLinCom(linComDTO, clientImpDTO, userID);
			}
			
		} catch (SICException e) {
			throw new SICException("Error guardarClienteImportacionLineaComercial: ",e);
		}
	}
	
	private void guardarClientImpLinCom(LineaComercialDTO linComDTO,ClienteImportacionDTO clienteImpDTO,String userID)throws SICException{
		try {
			LineaComercialClienteImportacionDTO lineaComClienImpDTO = new LineaComercialClienteImportacionDTO();
			lineaComClienImpDTO.getId().setCodigoLineaComercial(linComDTO.getId().getCodigoLineaComercial());
			lineaComClienImpDTO.getId().setCodigoClienteImportacion(clienteImpDTO.getId().getCodigoClienteImportacion());
			lineaComClienImpDTO.setUserId(userID);
			
			Collection<LineaComercialClienteImportacionDTO> linComClienImpDTOResultCol = lineaComercialDAO.consultarLinComClienImp(lineaComClienImpDTO);

			if(CollectionUtils.isNotEmpty(linComClienImpDTOResultCol)){
				LineaComercialClienteImportacionDTO linComClienImpDTOResult = linComClienImpDTOResultCol.iterator().next();
			
				if(SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(linComClienImpDTOResult.getEstado())){
					/**update**/
					lineaComClienImpDTO.setEstado(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
					if(lineaComClienImpDTO.getId().getCodigoClienteImportacion() != null
							&& lineaComClienImpDTO.getId().getCodigoLineaComercial() != null){
						lineaComercialDAO.actualizarLinComClienImp(lineaComClienImpDTO);
					}
					
				}
				/**relacion activa**/
			}else{
				/**Insert**/
				lineaComClienImpDTO.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
				lineaComClienImpDTO.getId().setCodigoCompania(clienteImpDTO.getId().getCodigoCompania());
				lineaComClienImpDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				dataGestor.create(lineaComClienImpDTO);
			}
			
		} catch (SICException e) {
			throw new SICException("Error guardarClientImpLinCom: ",e);
		}
	}
	
	
	@Override
	public Collection<LineaComercialClienteImportacionDTO> consultarLinComClienImp(LineaComercialDTO lineaComercialDTO)throws SICException{
		try {
			LineaComercialClienteImportacionDTO lineaComClienImpDTO = new LineaComercialClienteImportacionDTO();
			lineaComClienImpDTO.getId().setCodigoLineaComercial(lineaComercialDTO.getId().getCodigoLineaComercial());
			lineaComClienImpDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			lineaComClienImpDTO.addDynamicProperty("linComCliImp", lineaComercialDTO.getDynamicProperty("linComCliImp"));
			
			Collection<LineaComercialClienteImportacionDTO> lineaComercialClienteImportacionDTOCol = lineaComercialDAO.consultarLinComClienImp(lineaComClienImpDTO);
			
			return lineaComercialClienteImportacionDTOCol;
		} catch (SICException e) {
			throw new SICException("Error consultarLinComClienImp: ",e);
		}
	}
	
	@Override
	public void actualizarLinComClienImp(Collection<LineaComercialClienteImportacionDTO> linComCliImpDTOCol,String estado,String userId)throws SICException{
		for(LineaComercialClienteImportacionDTO linComCliImpDTO: linComCliImpDTOCol){
			/**se inicializa los valores de usuario de modifiacion y el estado a modificar que puede ser 0 o 1 **/
			linComCliImpDTO.setUserId(userId);
			linComCliImpDTO.setEstado(estado);
			if(linComCliImpDTO.getId().getCodigoClienteImportacion() != null &&
					linComCliImpDTO.getId().getCodigoLineaComercial() != null){
				lineaComercialDAO.actualizarLinComClienImp(linComCliImpDTO);
			}
		}
	}
	
	
	/**
	 * FIN METODOS PARA RELACION DE CLIENTE IMPORTACION
	 */
	
	
	/**
	 * Obtiene las areas de trabajo verificando si tiene perfiles atados o no
	 */
	public Collection<VistaAreaTrabajoDTO> findAreasTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<String> tiposAreaTrabajo) throws SICException{
		return lineaComercialDAO.findAreasTrabajo(areaTrabajoDTO, tiposAreaTrabajo);
	}
	@Override
	public Collection<Integer> consultarAreaTrabajoPorFuncionario(Collection<Integer> listaCodigoReferencia, String tipoAreaTrabajoValor, Integer tipoAreaTrabajoTIC, String codigoFuncionario) throws SICException {
		return lineaComercialDAO.consultarAreaTrabajoPorFuncionario(listaCodigoReferencia, tipoAreaTrabajoValor, tipoAreaTrabajoTIC, codigoFuncionario);
	}
	@Override
	public  Collection<String> buscarProcesoPerfil()throws SICException{
		return lineaComercialDAO.buscarProcesoPerfil();
	}
	/**
	 * Permite buscar los perfiles de funcionarios
	 * @param areaTrabajoID
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaAreaTrabajoPerfilDTO> findAreasTrabajoPerfil(AreaTrabajoID areaTrabajoID)throws SICException{
		return lineaComercialDAO.findAreasTrabajoPerfil(areaTrabajoID);
	}
	
	@Override
	public boolean validarClienImpLinComEstFilial(Long codigoClienteImportacion,Integer codigoCompania)throws SICException{
		return lineaComercialDAO.validarClienImpLinComEstFilial(codigoClienteImportacion, codigoCompania);
	}
	
	@Override
	public Collection<LineaComercialClasificacionDTO> buscarClasificacionesLinCom(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction> restrictionMap) throws SICException {
		return lineaComercialDAO.buscarClasificacionesLinCom(codigoCompania, codigoLineaComercial, estado, restrictionMap);
	}
	
	@Override
	public Long contarLineaComercialClasificacion(Integer codigoCompania, Long codigoLineaComercial) throws SICException{
		return lineaComercialDAO.contarLineaComercialClasificacion(codigoCompania, codigoLineaComercial);
	}
	//----------------------------------------------------------------------------------------------------------------
	// 	FIN DE METODOS PRIVADOS
	//----------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return the validacionLineaComercialGestor
	 */
	public ValidacionLineaComercialGestor getValidacionLineaComercialGestor() {
		return validacionLineaComercialGestor;
	}

	/**
	 * @param validacionLineaComercialGestor the validacionLineaComercialGestor to set
	 */
	public void setValidacionLineaComercialGestor(ValidacionLineaComercialGestor validacionLineaComercialGestor) {
		this.validacionLineaComercialGestor = validacionLineaComercialGestor;
	}

	/**
	 * @return the dataGestor
	 */
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @return the lineaComercialDAO
	 */
	public ILineaComercialDAO getLineaComercialDAO() {
		return lineaComercialDAO;
	}

	/**
	 * @param lineaComercialDAO the lineaComercialDAO to set
	 */
	public void setLineaComercialDAO(ILineaComercialDAO lineaComercialDAO) {
		this.lineaComercialDAO = lineaComercialDAO;
	}

	/**
	 * @return the sequenceDataBaseGestor
	 */
	public ISequenceDataBaseGestor getSequenceDataBaseGestor() {
		return sequenceDataBaseGestor;
	}

	/**
	 * @param sequenceDataBaseGestor the sequenceDataBaseGestor to set
	 */
	public void setSequenceDataBaseGestor(ISequenceDataBaseGestor sequenceDataBaseGestor) {
		this.sequenceDataBaseGestor = sequenceDataBaseGestor;
	}
}
