/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.estructuracomercial;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

import com.enterprisedt.net.ftp.FTPException;

import ec.com.kruger.utilitario.dao.commons.annotations.RelationField.JoinType;
import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.exception.DAOException;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearch;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utils.ftp.FtpManager;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.ProcesoConfiguracionDTO;
import ec.com.smx.corpv2.dto.ProcesoServidorDTO;
import ec.com.smx.corpv2.dto.ServidorAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.ServidorDTO;
import ec.com.smx.framework.common.util.predicate.EqualsCompositePredicate;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.framework.gestor.ISequenceDataBaseGestor;
import ec.com.smx.sic.articulo.persistence.dao.estructuraComercial.ClasificacionDAO;
import ec.com.smx.sic.articulo.util.ResizeUtil;
import ec.com.smx.sic.articulo.util.ResizeUtil.Method;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.IEstructuraComercialGestor;
import ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.accion.IAccionEstructuraComercialGestor;
import ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.validacion.IValidacionEstComGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionContenidoArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConceptoClasificacionID;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IEstructuraComercialDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IUsuarioClasificacionDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponMessages;


/**
 * @author fmunoz
 *
 */

public class EstructuraComercialGestor implements IEstructuraComercialGestor{

	private DataGestor dataGestor;
	private IUsuarioClasificacionDAO usuarioClasificacionDAO;
	private IArticuloDAO articuloDAO;
	private IValidacionEstComGestor validacionEstComGestor;
	private IAccionEstructuraComercialGestor accionEstructuraComercialGestor;
	private ISequenceDataBaseGestor sequenceDataBaseGestor;
	private IEstructuraComercialDAO estructuraComercialDAO;
	private ClasificacionDAO clasificacionDAO;
	/**
	 * 
	 * @param conceptoClasificacionID
	 * @return
	 * @throws SICRuleException
	 */
	public Boolean esActivoConceptoClasificacion(ConceptoClasificacionID conceptoClasificacionID)throws SICRuleException{
		return this.validacionEstComGestor.esActivoConceptoClasificacion(conceptoClasificacionID);
	}
	
	/**
	 * Funcion para desactivar las clasificaciones de un grupo de usuarios
	 * @param usuarios
	 * @param clasificaciones
	 * @param compania
	 * @throws SICException
	 */
	public void desactivarEstadoPorClasificacionUsuario(Collection<String> usuarios, Collection<String> clasificaciones, Integer compania) throws SICException{
		this.usuarioClasificacionDAO.desactivarEstadoPorClasificacionUsuario(usuarios, clasificaciones, compania);
	}
	
	/**
	 * Funcion que nos permite crear o actualizar una coleccion de ClasificacionUsuarios
	 * @param clasificacionUsuarioDTO
	 */
	public void registrarUsuarioClasificacion(Collection<ClasificacionUsuarioDTO> clasificacionUsuarioDTO) throws SICException{
		ClasificacionUsuarioDTO claUsuPlantilla= new ClasificacionUsuarioDTO();
		for(ClasificacionUsuarioDTO claUsu:clasificacionUsuarioDTO){
			claUsu.setEstadoClasificacionUsuario(null);
			claUsuPlantilla=dataGestor.findUnique(claUsu);
			if(claUsuPlantilla != null){
				claUsuPlantilla.setEstadoClasificacionUsuario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				dataGestor.update(claUsuPlantilla);
			}else{
				claUsu.setEstadoClasificacionUsuario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				dataGestor.create(claUsu);
			}
		}
		
	}
	
	
	/**
	 * permite buscar el arbol estructura orientado al cliente EOC
	 */
	
	public Collection<ClasificacionDTO> buscarArbolEOC(ClasificacionVO clafiltro){
		Collection<ClasificacionDTO> busquedaClasificacion=new ArrayList<ClasificacionDTO>();
		
		
		Collection<ClasificacionDTO> clasificacionDTOs=dataGestor.findObjects(clafiltro);
		/**
		 * Se utiliza los diferentes for para poder navegar en los niveles de las
		 * relaciones asta encontrar al padre y poder guardarlo y pintar como resultado de
		 * la consultado
		 */
		ClasificacionDTO clasificacionTemp2 = new ClasificacionDTO();
		clasificacionTemp2.setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE);
		clasificacionTemp2.setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);
		
		/* Relacion con la imagen  de la clasificacion*/
		ClasificacionContenidoArchivoDTO clasificacionContenidoArchivoDTO = new ClasificacionContenidoArchivoDTO();
		
		ClasificacionArchivoDTO clasificacionArchivoDTO = new ClasificacionArchivoDTO();
		clasificacionArchivoDTO.setClasificacionContenidoArchivoDTO(clasificacionContenidoArchivoDTO);
		
		clasificacionTemp2.setClasificacionArchivoCol(new ArrayList<ClasificacionArchivoDTO>());
		clasificacionTemp2.getClasificacionArchivoCol().add(clasificacionArchivoDTO);
		
		
		for(ClasificacionDTO clasificacionDTO: clasificacionDTOs){
			ClasificacionRelacionadaDTO clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
			clasificacionRelacionadaDTO.setCodigoClasificacionRelacionada(clasificacionDTO.getId().getCodigoClasificacion());
			clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			clasificacionRelacionadaDTO.setClasificacion(clasificacionTemp2);
			
			Collection<ClasificacionDTO> clasificacionDTOs2= CollectionUtils.collect(dataGestor.findObjects(clasificacionRelacionadaDTO), new GetInvokerTransformer("clasificacion")) ;
			
				if(clasificacionDTO.getCodigoTipoClasificacion().equals(SICConstantes.TIPCLA_DIVISION)){
					if(! CollectionUtils.exists(busquedaClasificacion, new EqualsCompositePredicate(clasificacionDTO, new String[]{"id.codigoClasificacion","id.codigoCompania"}))){
						busquedaClasificacion.add(clasificacionDTO);
					}
				}else{
					Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTO2s;
						for(ClasificacionDTO clasificacionDTO2: clasificacionDTOs2){
								ClasificacionRelacionadaDTO clasificacionRelacionadaDTO2=new ClasificacionRelacionadaDTO();
								clasificacionRelacionadaDTO2.setCodigoClasificacionRelacionada(clasificacionDTO2.getId().getCodigoClasificacion());
								clasificacionRelacionadaDTO2.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								clasificacionRelacionadaDTO2.setClasificacion(clasificacionTemp2);
								
								ClasificacionContenidoArchivoDTO clasificacionContenidoArchivoDTO3 = new ClasificacionContenidoArchivoDTO();
								
								ClasificacionArchivoDTO clasificacionArchivoDTO3 = new ClasificacionArchivoDTO();
								clasificacionArchivoDTO3.setClasificacionContenidoArchivoDTO(clasificacionContenidoArchivoDTO3);
								
								ClasificacionDTO clasificacionSecundaria = new ClasificacionDTO();
								clasificacionSecundaria.setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE);
								clasificacionSecundaria.setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);	
								clasificacionSecundaria.setClasificacionArchivoCol(new ArrayList<ClasificacionArchivoDTO>());
								clasificacionSecundaria.getClasificacionArchivoCol().add(clasificacionArchivoDTO3);
								
								clasificacionRelacionadaDTO2.setClasificacionRelacionada(clasificacionSecundaria);
								clasificacionRelacionadaDTO2s = dataGestor.findObjects(clasificacionRelacionadaDTO2);
								Collection<ClasificacionDTO> clasificacionDTOs3= CollectionUtils.collect(clasificacionRelacionadaDTO2s, new GetInvokerTransformer("clasificacion")) ;
								
						if(clasificacionDTO2.getCodigoTipoClasificacion().equals(SICConstantes.TIPCLA_DIVISION)){
							if(! CollectionUtils.exists(busquedaClasificacion, new EqualsCompositePredicate(clasificacionDTO2, new String[]{"id.codigoClasificacion","id.codigoCompania"}))){
								busquedaClasificacion.add(clasificacionDTO2);
							}
						}else{			
								for(ClasificacionDTO clasificacionDTO3: clasificacionDTOs3){
										ClasificacionRelacionadaDTO clasificacionRelacionadaDTO3=new ClasificacionRelacionadaDTO();
										clasificacionRelacionadaDTO3.setCodigoClasificacionRelacionada(clasificacionDTO3.getId().getCodigoClasificacion());
										clasificacionRelacionadaDTO3.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										Collection<ClasificacionDTO> clasificacionDTOs4= CollectionUtils.collect(dataGestor.findObjects(clasificacionRelacionadaDTO3), new GetInvokerTransformer("clasificacion")) ;
									if(clasificacionDTO3.getCodigoTipoClasificacion().equals(SICConstantes.TIPCLA_DIVISION)){
										if(! CollectionUtils.exists(busquedaClasificacion, new EqualsCompositePredicate(clasificacionDTO3, new String[]{"id.codigoClasificacion","id.codigoCompania"}))){	
											establecerNumSubClasificaciones(clasificacionRelacionadaDTO2s);
											clasificacionDTO3.setClasificacionRelacionadaSecundaria(new ArrayList<ClasificacionRelacionadaDTO>());
											clasificacionDTO3.setClasificacionRelacionadaSecundaria(clasificacionRelacionadaDTO2s);
											busquedaClasificacion.add(clasificacionDTO3);
										}
									}else{
										for(ClasificacionDTO clasificacionDTO4: clasificacionDTOs4){
											if(clasificacionDTO4.getCodigoTipoClasificacion().equals(SICConstantes.TIPCLA_DIVISION)){
												if(! CollectionUtils.exists(busquedaClasificacion, new EqualsCompositePredicate(clasificacionDTO4, new String[]{"id.codigoClasificacion","id.codigoCompania"}))){	
													busquedaClasificacion.add(clasificacionDTO4);
												}
											}
										}
									}
									
									
								}
								
							 } 
						}
				}
		}
		
		/*
		 * este metodo permite contar el siguiente nivel 
		 * tomando la colleccion 
		 * la instancia del DTO relacionado
		 * variable que contendra el valor count que debe estar en el DTO
		 * el cuarto parametro es el nombre de la relacion en el DTO
		 */				
		ClasificacionRelacionadaDTO clasificacionRelacionadaDTOCount=new ClasificacionRelacionadaDTO();
		clasificacionRelacionadaDTOCount.setEstadoClasificacionRelacionada(clafiltro.getBaseDTO().getEstadoClasificacion());
		this.dataGestor.addChildrenCount(busquedaClasificacion, clasificacionRelacionadaDTOCount, "numeroSubClasificacion", "clasificacionRelacionadaPrincipal");
		
		
		return busquedaClasificacion;
		
	}
	
	/**
	 * Setea el numero de subclasificaciones relacionadas a la clasificacion
	 * @param clasificacionRelacionadaCol
	 */
	@SuppressWarnings("unchecked")
	private void establecerNumSubClasificaciones(Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaCol){
		ClasificacionRelacionadaDTO clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
		clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		Collection<ClasificacionDTO> clasificacionDTOCol= CollectionUtils.collect(clasificacionRelacionadaCol, new GetInvokerTransformer("clasificacionRelacionada")) ;
		this.dataGestor.addChildrenCount(clasificacionDTOCol,clasificacionRelacionadaDTO, "numeroSubClasificacion", "clasificacionRelacionadaPrincipal");
	}

	/**
	 * Metodo para devolver una estructura comercial por medio de una estructura WRT
	 * @param estWRT
	 * @return clasificacionDTO
	 */
	public Collection<ClasificacionDTO> obtenerECDesdeWRT(ClasificacionDTO estWRT){
		try{
			return articuloDAO.obtenerECdesdeWRT(estWRT);
		}
		catch(SICException e){
			throw new SICException("Error al verificar articulos de la subclasificacion");
		}
	}
	
	/**
	 * Metodo para validar que existe almenos un articulo de la clasificacion dada que tenga alguno de los estados PEN, CON, AUT
	 * @param clasificacionDTO
	 * @return
	 * @throws SICException
	 */
	@Override
	public Boolean existeArticuloUnificarCosto(ClasificacionDTO clasificacionDTO)throws SICException{
		return articuloDAO.existeArticuloUnificarCosto(clasificacionDTO);
	}
	
	/**
	 * Permite consultar si la clasificacion tiene asignado clasificaciones en la
	 * ClasificacionRelacionadaDTO asignadas de la estructura comercial ESC
	 */
	public Collection<ClasificacionRelacionadaDTO> buscarClasificacionesAsignadas(ClasificacionDTO clasificacionDTO){
		
		Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOs=new ArrayList<ClasificacionRelacionadaDTO>();
		
		ClasificacionRelacionadaDTO clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
		clasificacionRelacionadaDTO.setCodigoClasificacionRelacionada(clasificacionDTO.getId().getCodigoClasificacion());		
		clasificacionRelacionadaDTO.getId().setCodigoCompania(clasificacionDTO.getId().getCodigoCompania());
		clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		
		clasificacionRelacionadaDTO.setClasificacionRelacionada(new ClasificacionDTO());
		clasificacionRelacionadaDTO.getClasificacionRelacionada().setValorTipoEstructura(null);
		clasificacionRelacionadaDTO.getClasificacionRelacionada().setCodigoTipoEstructura(null);
		clasificacionRelacionadaDTO.getClasificacionRelacionada().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoEstructura",ComparatorTypeEnum.EQUAL_COMPARATOR,CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE));
		
		clasificacionRelacionadaDTO.setClasificacion(new ClasificacionDTO());
		clasificacionRelacionadaDTO.getClasificacion().setValorTipoEstructura(null);
		clasificacionRelacionadaDTO.getClasificacion().setCodigoTipoEstructura(null);
		clasificacionRelacionadaDTO.getClasificacion().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoEstructura",ComparatorTypeEnum.EQUAL_COMPARATOR,CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
		
		clasificacionRelacionadaDTO.setSubClasificacion(new SubClasificacionDTO());
		
		clasificacionRelacionadaDTO.getSubClasificacion().setClasificacionDTO(new ClasificacionDTO());
		
		clasificacionRelacionadaDTO.getSubClasificacion().getClasificacionDTO().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoEstructura",ComparatorTypeEnum.EQUAL_COMPARATOR,CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
		clasificacionRelacionadaDTO.getSubClasificacion().getClasificacionDTO().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoTipoEstructura",ComparatorTypeEnum.EQUAL_COMPARATOR,TiposCatalogoConstantes.TIPO_ESTRUCTURA));
		
		clasificacionRelacionadaDTO.getSubClasificacion().getClasificacionDTO().setValorTipoEstructura(null);
		clasificacionRelacionadaDTO.getSubClasificacion().getClasificacionDTO().setCodigoTipoEstructura(null);
		
		Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOsAux=dataGestor.findObjects(clasificacionRelacionadaDTO);
		
		for(ClasificacionRelacionadaDTO cDto: clasificacionRelacionadaDTOsAux){
			
			Logeable.LOG_SICV2.info("Codigos Clasificacion {} Codigo Clasificacion Relacionada {}", cDto.getCodigoClasificacion().substring(0,2) ,cDto.getCodigoClasificacionRelacionada().substring(0,2));
			
			if(!cDto.getCodigoClasificacion().substring(0,2).equals(cDto.getCodigoClasificacionRelacionada().substring(0,2))){
				clasificacionRelacionadaDTOs.add(cDto);
			}
			
			
		}
		
		Logeable.LOG_SICV2.info("El valor de la consulta es ---_Z>{}",clasificacionRelacionadaDTOs.size());
		
		
		return clasificacionRelacionadaDTOs;
	}
	/**
	 * Este metodo permite cambiar el estado de las ClasificacionRelacionadaDTO
	 * dependiendo de si el usuario decide ingresar una clasificacion o sub clasificacion 
	 * ya sea a un nivel clasificacion o de departamente en la linea comercial orientada al cliente
	 */
	public void actualizarClasificacionesAsignadas(Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOs){
		for(ClasificacionRelacionadaDTO clasificacionRelacionadaDTO: clasificacionRelacionadaDTOs){
			clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			dataGestor.update(clasificacionRelacionadaDTO);
		}
	}
	
	

	/**
	 * permite actualizar el reguistro de la clasificacion
	 * @param clasificacionVO
	 * @throws SICException
	 */
	public void actualizarClasificacion(ClasificacionVO clasificacionVO)throws SICException {
		 
		try {
			if(CorporativoConstantes.TIPO_ESTRUCTURA_WRT.equals(clasificacionVO.getBaseDTO().getValorTipoEstructura())){
				dataGestor.update(clasificacionVO.getBaseDTO());
			}else{
				if(clasificacionVO.getBaseDTO().getEsPublicadoInternet().equals(Boolean.FALSE)){
					clasificacionVO.getBaseDTO().setDescripcionPublicacionInternet(null);
				}
				dataGestor.update(clasificacionVO);
				//Actualizamos aplicaRegistroSanitario a los hijos
				if(StringUtils.isNotBlank(clasificacionVO.getBaseDTO().getValorAplicaRegistroSanitario()) && (clasificacionVO.getBaseDTO().getValorAplicaRegistroSanitario().equals(TipoCatalogoArticulo.VALOR_APLICA_REGISTRO_SANITARIO) ||
						clasificacionVO.getBaseDTO().getValorAplicaRegistroSanitario().equals(TipoCatalogoArticulo.VALOR_NUNCA_APLICA_REGISTRO_SANITARIO))){
					
					articuloDAO.actualizarAplicaRegistroSanitario(clasificacionVO.getBaseDTO().getUserId(),	clasificacionVO.getBaseDTO().getId().getCodigoClasificacion()
								,clasificacionVO.getBaseDTO().getCodigoAplicaRegistroSanitario() ,clasificacionVO.getBaseDTO().getValorAplicaRegistroSanitario());
				}
				if(clasificacionVO.getTipoEstructura().equals(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL)){
					actualizarClasificacionRelacionadaEC(clasificacionVO);
					actualizarEstructuraWRT(clasificacionVO);
				}else{
					actualizarClasificacionRelacionadaEOC(clasificacionVO);
				}
				
				if (CollectionUtils.isNotEmpty(clasificacionVO.getBaseDTO().getClasificacionArchivoCol()) && clasificacionVO.getBaseDTO().getValorTipoEstructura().equals(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE)){
					ClasificacionArchivoDTO clasificacionArchivoDTO = (ClasificacionArchivoDTO)SerializationUtils.clone(clasificacionVO.getBaseDTO().getClasificacionArchivoCol().iterator().next());
					ClasificacionContenidoArchivoDTO clasificacionContenidoArchivoDTO = clasificacionArchivoDTO.getClasificacionContenidoArchivoDTO();
					
					clasificacionArchivoDTO.setUserId(clasificacionVO.getBaseDTO().getUserId());
					clasificacionArchivoDTO.setCodigoClasificacion(clasificacionVO.getBaseDTO().getId().getCodigoClasificacion());
					clasificacionArchivoDTO.setClasificacionContenidoArchivoDTO(null);
					
					dataGestor.createOrUpdate(clasificacionArchivoDTO);
					
					clasificacionContenidoArchivoDTO.getId().setCodigoCompania(1);
					clasificacionContenidoArchivoDTO.getId().setCodigoArchivo(clasificacionArchivoDTO.getId().getCodigoArchivo());
					
					dataGestor.createOrUpdate(clasificacionContenidoArchivoDTO);
				}
				
				accionEstructuraComercialGestor.transferirDatosClasificacionSIC(clasificacionVO.getBaseDTO());
				
			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al actualizar la clasificacion: {}",e);
			throw new SICException(e);
		}
	}

	/**
	 * este metodo permite actualizar los registros asignados de ECC a la ESC
	 * permitiendo la administracion adecuada
	 * @param clasificacionVO
	 */
	private void actualizarClasificacionRelacionadaEOC(ClasificacionVO clasificacionVO){
		Logeable.LOG_SICV2.info("ingreso en el metodosdsdsd actualizarClasificacionRelacionadaEOC");
		
		if(! CollectionUtils.isEmpty(clasificacionVO.getClasificacionEstructura())){
			for(ClasificacionRelacionadaDTO clasificacionRelacionadaDTO:  clasificacionVO.getClasificacionEstructura()){
				
				ClasificacionRelacionadaDTO clasificacionRelacionada=new ClasificacionRelacionadaDTO();
				clasificacionRelacionada.setCodigoClasificacionRelacionada(clasificacionVO.getBaseDTO().getId().getCodigoClasificacion());
				clasificacionRelacionada.setCodigoClasificacion(clasificacionRelacionadaDTO.getCodigoClasificacion());
				clasificacionRelacionada.getId().setCodigoCompania(clasificacionRelacionadaDTO.getId().getCodigoCompania());
				if(clasificacionRelacionadaDTO.getCodigoSubClasificacion()==null){
					clasificacionRelacionada.setCriteriaSearch(new CriteriaSearch());
					clasificacionRelacionada.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoSubClasificacion",ComparatorTypeEnum.IS_NULL));
//					ClasificacionDTO sDto=new ClasificacionDTO();
//					sDto.setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL);
//					sDto.setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);	
//					clasificacionRelacionada.setClasificacion(sDto);
//					clasificacionRelacionada.setClasificacionRelacionada(sDto);
				}else{
					clasificacionRelacionada.setCodigoSubClasificacion(clasificacionRelacionadaDTO.getCodigoSubClasificacion());
				}
				
				//busca si ya existe esa clasificacion relacionada
				ClasificacionRelacionadaDTO clasificacionRelacionadaDTO2=dataGestor.findUnique(clasificacionRelacionada);
				if(SearchDTO.isLoaded(clasificacionRelacionadaDTO2)){
					if(clasificacionRelacionadaDTO2.getEstadoClasificacionRelacionada() != clasificacionRelacionadaDTO.getEstadoClasificacionRelacionada()){
						//si existe la actualiza
						Logeable.LOG_SICV2.info("actualizarClasificacionRelacionadaEOC(ClasificacionVO clasificacionVO)");
						clasificacionRelacionadaDTO2.setEstadoClasificacionRelacionada(clasificacionRelacionadaDTO.getEstadoClasificacionRelacionada());
						clasificacionRelacionadaDTO2.setUserId(clasificacionVO.getBaseDTO().getUserId());
						dataGestor.update(clasificacionRelacionadaDTO2);
					}
				}else{
					//caso contrario la crea
					clasificacionRelacionada.setEstadoClasificacionRelacionada(clasificacionRelacionadaDTO.getEstadoClasificacionRelacionada());
					clasificacionRelacionada.setUserId(clasificacionVO.getBaseDTO().getUserId());
					dataGestor.create(clasificacionRelacionada);
				}
			}
		}
	}
	/**
	 * metodo para actualizar o crear las estructuras relacionadas WRT
	 * @param clasificacionVO
	 */
	private void actualizarEstructuraWRT(ClasificacionVO clasificacionVO){
		Logeable.LOG_SICV2.info("ingreso a actualizar estructuras relacionadas");
		
		if(! CollectionUtils.isEmpty(clasificacionVO.getClasificacionEstructura())){
			for(ClasificacionRelacionadaDTO clasificacionRelacionadaDTO:  clasificacionVO.getClasificacionEstructura()){
					ClasificacionRelacionadaDTO clasificacionRelacionada=new ClasificacionRelacionadaDTO();
					clasificacionRelacionada.setCodigoClasificacionRelacionada(clasificacionVO.getBaseDTO().getId().getCodigoClasificacion());
					clasificacionRelacionada.setCodigoClasificacion(clasificacionRelacionadaDTO.getCodigoClasificacion());
					clasificacionRelacionada.getId().setCodigoCompania(clasificacionVO.getBaseDTO().getId().getCodigoCompania());
					if(clasificacionRelacionadaDTO.getCodigoSubClasificacion()==null){
						clasificacionRelacionada.setCriteriaSearch(new CriteriaSearch());
						clasificacionRelacionada.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoSubClasificacion",ComparatorTypeEnum.IS_NULL));
					}else{
						clasificacionRelacionada.setCodigoSubClasificacion(clasificacionRelacionadaDTO.getCodigoSubClasificacion());
					}
					
					//busca si ya existe esa clasificacion relacionada
					ClasificacionRelacionadaDTO clasificacionRelacionadaDTO2=dataGestor.findUnique(clasificacionRelacionada);
					if(SearchDTO.isLoaded(clasificacionRelacionadaDTO2)){
						//si existe la actualiza
						Logeable.LOG_SICV2.info("actualizarClasificacionRelacionadaEOC(ClasificacionVO clasificacionVO)");
						clasificacionRelacionadaDTO2.setEstadoClasificacionRelacionada(clasificacionRelacionadaDTO.getEstadoClasificacionRelacionada());
						clasificacionRelacionadaDTO2.setUserId(clasificacionVO.getBaseDTO().getUserId());
						dataGestor.update(clasificacionRelacionadaDTO2);						
					}else{
						//caso contrario la crea
						clasificacionRelacionada.setEstadoClasificacionRelacionada(clasificacionRelacionadaDTO.getEstadoClasificacionRelacionada());
						clasificacionRelacionada.setUserId(clasificacionVO.getBaseDTO().getUserId());
						dataGestor.create(clasificacionRelacionada);
					}
				}
			}
	}
	/**
	 * * este metodo permite actualizar los registros asignados de ESC a la ECC
	 * permitiendo la administracion adecuada
	 * @param clasificacionVO
	 */
	private void actualizarClasificacionRelacionadaEC(ClasificacionVO clasificacionVO){
		
		if(SearchDTO.isLoaded(clasificacionVO.getClasificacionEstructuraCliente()) && clasificacionVO.getClasificacionEstructuraCliente().getId().getCodigoCompania()!=null){				
			ingresarClasificacionRelacionadaEC(clasificacionVO.getClasificacionEstructuraCliente(), 
					clasificacionVO.getBaseDTO().getId().getCodigoClasificacion(),
					clasificacionVO.getBaseDTO().getUserId());
		}else{
			ClasificacionRelacionadaDTO clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
			clasificacionRelacionadaDTO.setCodigoClasificacionRelacionada(clasificacionVO.getBaseDTO().getId().getCodigoClasificacion());
			clasificacionRelacionadaDTO.getId().setCodigoCompania(clasificacionVO.getBaseDTO().getId().getCodigoCompania());
			clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			ClasificacionDTO cla=new ClasificacionDTO();
			cla.setValorTipoEstructura((CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE));
			clasificacionRelacionadaDTO.setClasificacion(cla);
			Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOs =dataGestor.findObjects(clasificacionRelacionadaDTO);
			if(! CollectionUtils.isEmpty(clasificacionRelacionadaDTOs)){
				for(ClasificacionRelacionadaDTO clDto: clasificacionRelacionadaDTOs){
					clDto.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					dataGestor.update(clDto);
				}
			}		
			
		}
		
		
	}
	
	/**
	 * Permite el ingreso opcional de la ClasificacionRelacionadaDTO en la estructura comercial normal
	 * este dato viene de  el arbol de estructura comercial orientado al cliente
	 * estos paramaetros vienen de el metodo actualizarClasificacion
	 * @param clasificacionDTO
	 * @param codigoClasificacion
	 * @param userId
	 */
	private void ingresarClasificacionRelacionadaEC(ClasificacionDTO clasificacionDTO, String codigoClasificacion,String userId){
		try {

			ClasificacionRelacionadaDTO clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
			clasificacionRelacionadaDTO.setCodigoClasificacionRelacionada(codigoClasificacion);
			clasificacionRelacionadaDTO.getId().setCodigoCompania(clasificacionDTO.getId().getCodigoCompania());
			clasificacionRelacionadaDTO.setUserId(userId);
			
			Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOs =dataGestor.findObjects(clasificacionRelacionadaDTO);
			
			if(CollectionUtils.isEmpty(clasificacionRelacionadaDTOs)){
				clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				clasificacionRelacionadaDTO.setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
				dataGestor.create(clasificacionRelacionadaDTO);
			}else{
				clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				ClasificacionRelacionadaDTO clDto=(ClasificacionRelacionadaDTO)CollectionUtils.find(clasificacionRelacionadaDTOs, new EqualsCompositePredicate(clasificacionRelacionadaDTO, new String[] {"estadoClasificacionRelacionada"}));
				if(SearchDTO.isLoaded(clDto)){
					if(! clDto.getCodigoClasificacion().equals(clasificacionDTO.getId().getCodigoClasificacion())){
						clDto.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_INACTIVO_NUMERICO);
						dataGestor.update(clDto);
						clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_INACTIVO_NUMERICO);
						clasificacionRelacionadaDTO.setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
						ClasificacionRelacionadaDTO clDto2=(ClasificacionRelacionadaDTO)CollectionUtils.find(clasificacionRelacionadaDTOs, new EqualsCompositePredicate(clasificacionRelacionadaDTO, new String[] {"codigoClasificacion"}));
						if(SearchDTO.isLoaded(clDto2)){
							clDto2.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							dataGestor.update(clDto2);
						}else{
							clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							clasificacionRelacionadaDTO.setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
							dataGestor.create(clasificacionRelacionadaDTO);
						}
					}
				}else{
					clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					clasificacionRelacionadaDTO.setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
					ClasificacionRelacionadaDTO clDto2=(ClasificacionRelacionadaDTO)CollectionUtils.find(clasificacionRelacionadaDTOs, new EqualsCompositePredicate(clasificacionRelacionadaDTO, new String[] {"codigoClasificacion"}));
					if(SearchDTO.isLoaded(clDto2)){
						clDto2.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.update(clDto2);
					}else{
						clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						clasificacionRelacionadaDTO.setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
						dataGestor.create(clasificacionRelacionadaDTO);
					}
				}
			}
			
		} catch (DAOException e) {
			throw new SICException(e);
		}
	}
	
	private void crearClasificacionWRT(ClasificacionVO clasificacionVO){
		try {
				clasificacionVO.getBaseDTO().setUserId(clasificacionVO.getBaseDTO().getUserId());
				dataGestor.create(clasificacionVO);
		} catch (DAOException e) {
			Logeable.LOG_SICV2.info("Error al crear la clasificacion: {}",e);
			throw new SICException(e);
		}
	}
	/**
	 * Permite crear clasificaciones y sus relacionadas
	 * @param clasificacionVO
	 * @throws SICException
	 */
	public void crearClasificacion(ClasificacionVO clasificacionVO) throws SICException {
		try {
			if(clasificacionVO.getBaseDTO().getValorTipoEstructura().equals(CorporativoConstantes.TIPO_ESTRUCTURA_WRT)){
				crearClasificacionWRT(clasificacionVO);
			}
			else{
				//Validacion si es estructura comercial
				String codigoClasificacionPadre=null;
				
				if (clasificacionVO.getBaseDTO().getValorTipoEstructura().equals(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE)){
					clasificacionVO.getBaseDTO().setEsPublicadoInternet(Boolean.FALSE);
						//Llenamos la secuencia
						Long secuencia = this.sequenceDataBaseGestor.getSequenceValue(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.estructura.comercial.cliente.numero.secuencia.prefijo"));
						clasificacionVO.getBaseDTO().getId().setCodigoClasificacion(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.estructura.comercial.cliente.secuencia.prefijo").concat(secuencia.toString()));
						clasificacionVO.getBaseDTO().setCodigoReferencia(clasificacionVO.getBaseDTO().getId().getCodigoClasificacion());
						//Se envia el valor nulo del codigo Padre
						codigoClasificacionPadre=clasificacionVO.getBaseDTO().getCodigoClasificacionPadre();
						clasificacionVO.getBaseDTO().setCodigoClasificacionPadre(null);
				}
				dataGestor.create(clasificacionVO);
				
				if (CollectionUtils.isNotEmpty(clasificacionVO.getBaseDTO().getClasificacionArchivoCol()) && clasificacionVO.getBaseDTO().getValorTipoEstructura().equals(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE)){
					//Se guarda ka informacion de la imagen
					ClasificacionArchivoDTO clasificacionArchivoDTO = (ClasificacionArchivoDTO)SerializationUtils.clone(clasificacionVO.getBaseDTO().getClasificacionArchivoCol().iterator().next());
					ClasificacionContenidoArchivoDTO clasificacionContenidoArchivoDTO = clasificacionArchivoDTO.getClasificacionContenidoArchivoDTO();
					
					clasificacionArchivoDTO.setUserId(clasificacionVO.getBaseDTO().getUserId());
					clasificacionArchivoDTO.setCodigoClasificacion(clasificacionVO.getBaseDTO().getId().getCodigoClasificacion());
					clasificacionArchivoDTO.setClasificacionContenidoArchivoDTO(null);
					
					dataGestor.create(clasificacionArchivoDTO);
					
					clasificacionContenidoArchivoDTO.getId().setCodigoCompania(1);
					clasificacionContenidoArchivoDTO.getId().setCodigoArchivo(clasificacionArchivoDTO.getId().getCodigoArchivo());
					
					dataGestor.create(clasificacionContenidoArchivoDTO);
					
				}
				
				if(clasificacionVO.getBaseDTO().getValorTipoEstructura().equals(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL)){
					actualizarClasificacionRelacionadaEC(clasificacionVO);
					actualizarEstructuraWRT(clasificacionVO);
				}else{
					actualizarClasificacionRelacionadaEOC(clasificacionVO);
				}	
				
				
				//Validamos si es estructura comercial del cliente y si posee padre
				if(codigoClasificacionPadre!=null
						&& clasificacionVO.getBaseDTO().getValorTipoEstructura().equals(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE)){
					//Insertamos en la clasificacion relacionada
					ClasificacionRelacionadaDTO clasificacionRelacionadaDTO = new ClasificacionRelacionadaDTO();
					clasificacionRelacionadaDTO.getId().setCodigoCompania(clasificacionVO.getBaseDTO().getId().getCodigoCompania());				
					clasificacionRelacionadaDTO.setCodigoClasificacion(codigoClasificacionPadre);
					clasificacionRelacionadaDTO.setCodigoClasificacionRelacionada(clasificacionVO.getBaseDTO().getId().getCodigoClasificacion());
					clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					clasificacionRelacionadaDTO.setUserId(clasificacionVO.getBaseDTO().getUserId());
					dataGestor.create(clasificacionRelacionadaDTO);
				}
				
				
				accionEstructuraComercialGestor.transferirDatosClasificacionSIC(clasificacionVO.getBaseDTO());
			}
		} catch (DAOException e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * 
	 * @param articulos
	 */
	public ArticuloVO reclasificarArticulos(Collection<ArticuloDTO> articulos, SubClasificacionDTO subClasificacionDTO)  throws SICException {
		ArticuloVO resultado = new ArticuloVO();
		Map<String, Object> relations = null;
		for(ArticuloDTO dto : articulos){
			try{
				ProveedorClasificacionDTO proveedorClasificacionDTOFiltro = new ProveedorClasificacionDTO();
				proveedorClasificacionDTOFiltro.setClasificacion(new ClasificacionDTO());
				proveedorClasificacionDTOFiltro.getClasificacion().getId().setCodigoClasificacion(subClasificacionDTO.getId().getCodigoClasificacion());
				proveedorClasificacionDTOFiltro.setProveedor(new ProveedorDTO());
				
				ProveedorClasificacionDTO proveedorClasificacionDTO = null;
				for(ArticuloProveedorDTO articuloProveedorDTO : dto.getArticuloProveedorCol()) {
					proveedorClasificacionDTOFiltro.getProveedor().getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
					proveedorClasificacionDTO = dataGestor.findUnique(proveedorClasificacionDTOFiltro);
					if (proveedorClasificacionDTO == null) {
						proveedorClasificacionDTO = new ProveedorClasificacionDTO();
						proveedorClasificacionDTO.getId().setCodigoCompania(dto.getId().getCodigoCompania());
						proveedorClasificacionDTO.getId().setCodigoClasificacion(subClasificacionDTO.getId().getCodigoClasificacion());
						proveedorClasificacionDTO.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
						proveedorClasificacionDTO.setEstadoProveedorClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						proveedorClasificacionDTO.setUserId(dto.getUserId());
						dataGestor.create(proveedorClasificacionDTO);
					} else {
						SICUtil.getInstance().clearRelations(proveedorClasificacionDTO);
						proveedorClasificacionDTO.setEstadoProveedorClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.createOrUpdate(proveedorClasificacionDTO);
					}
				}
				
				dto.setCodigoClasificacion(subClasificacionDTO.getId().getCodigoClasificacion());
				dto.setCodigoSubClasificacion(subClasificacionDTO.getId().getCodigoSubClasificacion());
				//se respaldan y anulan las relaciones del articulo antes de guardar
				relations = SICUtil.getInstance().clearRelations(dto);
				dataGestor.update(dto);
			}catch (Exception e) {
				resultado.addError(dto.getCodigoBarrasActivo().getId().getCodigoBarras() + ": "+ e.getMessage());
			}finally{
				SICUtil.getInstance().restoreRelations(dto, relations);
			}
		}
		return resultado;
	}
	
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setUsuarioClasificacionDAO(
			IUsuarioClasificacionDAO usuarioClasificacionDAO) {
		this.usuarioClasificacionDAO = usuarioClasificacionDAO;
	}

	public void setValidacionEstComGestor(
			IValidacionEstComGestor validacionEstComGestor) {
		this.validacionEstComGestor = validacionEstComGestor;
	}

	@Override
	public void actualizarSubClasificacion(SubClasificacionDTO subClasificacionDTO) throws SICException {
		try {
			dataGestor.update(subClasificacionDTO);
			accionEstructuraComercialGestor.transferirDatosSubClasificacionSIC(subClasificacionDTO);
		} catch (DAOException e) {
			throw new SICException(e);
		}
	}

	@Override
	public void crearSubClasificacion(SubClasificacionDTO subClasificacionDTO) throws SICException {
		try {
			dataGestor.create(subClasificacionDTO);
			accionEstructuraComercialGestor.transferirDatosSubClasificacionSIC(subClasificacionDTO);
		} catch (DAOException e) {
			throw new SICException(e);
		}
	}
	
	public Map<String, Object> obtenerCompradoresLineaComercial(String codigoFuncionario, Integer codigoCompania) throws SICException {
		//Collection<FuncionarioDTO> compradoresLineaComercial = null;
		Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTO = null;
		//Collection<LineaComercialFuncionarioDTO> lineaComercialCompradorDTO = null;
		LineaComercialDTO lineaComercialPadre = null;
		HashSet<Long> codigosHijosLineaComercialPadre = null;
		boolean buscarHijosClasificacion = true;
		Map<String, Object> compradoresLineaComercialMap = new HashMap<String, Object>();
		//Se busca a que linea comercial pertenece el usuario logueado
		try {
			//lineas comercial comprador funcionario
			lineaComercialFuncionarioDTO = obtenerLineaComercialFuncionario(codigoFuncionario, codigoCompania);
			
			if (lineaComercialFuncionarioDTO != null && !lineaComercialFuncionarioDTO.isEmpty()) {
				codigosHijosLineaComercialPadre = new HashSet<Long>();
				for (LineaComercialFuncionarioDTO lineaComercial : lineaComercialFuncionarioDTO) {
					lineaComercialPadre = null;
					buscarHijosClasificacion = true;
					//linea comercial padre
					if(lineaComercial  != null && lineaComercial.getLineaComercial() != null){
						lineaComercialPadre = obtenerLineaComercialPadre(lineaComercial.getLineaComercial(), codigoCompania);
					}
					
					//Lineas comerciales hijos de linea comercial padre
					if(lineaComercialPadre != null){
						if(codigosHijosLineaComercialPadre != null && !codigosHijosLineaComercialPadre.isEmpty()){
							buscarHijosClasificacion = !codigosHijosLineaComercialPadre.contains(lineaComercialPadre.getId().getCodigoLineaComercial()); 
						}
						if (buscarHijosClasificacion) {
							codigosHijosLineaComercialPadre.add(lineaComercialPadre.getId().getCodigoLineaComercial());//Codigo padre
							obtenerHijosLineaComercialPadre(lineaComercialPadre.getId().getCodigoLineaComercial(), codigosHijosLineaComercialPadre, codigoCompania);
						}
					}
				}
			}
						
			//Se obtiene los funcionarios en base a los codigos de las lineas comerciales
			if(codigosHijosLineaComercialPadre != null && !codigosHijosLineaComercialPadre.isEmpty()){
//				compradoresLineaComercial = new ArrayList<FuncionarioDTO>();
//				lineaComercialCompradorDTO = new ArrayList<LineaComercialFuncionarioDTO>();
//				LineaComercialFuncionarioDTO lineaComercialFuncionarioPlantillaDTO = new LineaComercialFuncionarioDTO();
//				lineaComercialFuncionarioPlantillaDTO.getId().setCodigoCompania(codigoCompania);
//				lineaComercialFuncionarioPlantillaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//				lineaComercialFuncionarioPlantillaDTO.setCriteriaSearch(new CriteriaSearch());
//				lineaComercialFuncionarioPlantillaDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Long>("codigoLineaComercial", ComparatorTypeEnum.IN_COMPARATOR, codigosHijosLineaComercialPadre.toArray(new Long[0])));
//				lineaComercialFuncionarioPlantillaDTO.getCriteriaSearch().addDistinctSearchParameter(LineaComercialFuncionarioDTO.class, new String[] { "codigoFuncionario"});
//				lineaComercialCompradorDTO = this.dataGestor.findDistinct(lineaComercialFuncionarioPlantillaDTO, LineaComercialFuncionarioDTO.class);
//				if(!lineaComercialCompradorDTO.isEmpty()){
//					for (LineaComercialFuncionarioDTO comercialFuncionarioDTO: lineaComercialCompradorDTO) {
//						if (StringUtils.isNotEmpty(comercialFuncionarioDTO.getCodigoFuncionario())) {
//							FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
//							funcionarioDTO.getId().setCodigoFuncionario(comercialFuncionarioDTO.getCodigoFuncionario());
//							funcionarioDTO.setUsuarioDTO(new UserDto());
//							compradoresLineaComercial.add(this.dataGestor.findUnique(funcionarioDTO));
//						}
//					}
//				}
//				compradoresLineaComercialMap.put("compradoresLineaComercial", compradoresLineaComercial);
				compradoresLineaComercialMap.put("codigosHijosLineaComercialPadre", codigosHijosLineaComercialPadre);
			}
		} catch (SICException e) {
			throw e;			
		} catch (Exception e) {
			throw new SICException(e.getMessage());
		}
		return compradoresLineaComercialMap;
	}
		
	/**
	 * Metodo que obtiene la linea comercial
	 * funcionarioDTO
	 * @param funcionario
	 * @param userId
	 * @param codigoLineaComercial
	 * @return
	 * @throws SICException
	 */
	private Collection<LineaComercialFuncionarioDTO> obtenerLineaComercialFuncionario(String codigoFuncionario, Integer codigoCompania) throws SICException{
		LineaComercialFuncionarioDTO lineaComercialFuncionarioPlantillaDTO = null;
		Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTOColl = null;
		try {
			lineaComercialFuncionarioPlantillaDTO = new LineaComercialFuncionarioDTO();
			lineaComercialFuncionarioPlantillaDTO.getId().setCodigoCompania(codigoCompania);
			lineaComercialFuncionarioPlantillaDTO.setLineaComercial(new LineaComercialDTO());
			lineaComercialFuncionarioPlantillaDTO.getLineaComercial().setLineaComercialPadre(new LineaComercialDTO());
			
			//Criterios de busqueda
			lineaComercialFuncionarioPlantillaDTO.setCriteriaSearch(new CriteriaSearch());
			lineaComercialFuncionarioPlantillaDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoFuncionario", 
					ComparatorTypeEnum.EQUAL_COMPARATOR, codigoFuncionario));
			lineaComercialFuncionarioPlantillaDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", 
					ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			lineaComercialFuncionarioDTOColl = dataGestor.findObjects(lineaComercialFuncionarioPlantillaDTO);
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e.getMessage());
		}
		return lineaComercialFuncionarioDTOColl;
	}

	/**
	 * Metodo que setea los codigos de las lineas 
	 * comerciales hijos correspondientes a la linea comercial padre
	 * @param codigoLineaComercialPadre
	 * @param codigosHijosLineaComercialPadre
	 * @throws SICException
	 */
	private void obtenerHijosLineaComercialPadre(Long codigoLineaComercialPadre, HashSet<Long> codigosHijosLineaComercialPadre, Integer codigoCompania) throws SICException {
		LineaComercialDTO lineaComercialPlantilla = null;
		Collection<LineaComercialDTO> collectionComercialDTOs = null; 
		try {
			lineaComercialPlantilla = new LineaComercialDTO();
			lineaComercialPlantilla.getId().setCodigoCompania(codigoCompania);
			lineaComercialPlantilla.setCodigoLineaComercialPadre(codigoLineaComercialPadre);
			
			//Criterios de busqueda
			lineaComercialPlantilla.setCriteriaSearch(new CriteriaSearch());
			lineaComercialPlantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", 
					ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			collectionComercialDTOs = this.dataGestor.findObjects(lineaComercialPlantilla);
			if(collectionComercialDTOs != null && !collectionComercialDTOs.isEmpty()){
				for (LineaComercialDTO lineaComercialDTO : collectionComercialDTOs) {
					codigosHijosLineaComercialPadre.add(lineaComercialDTO.getId().getCodigoLineaComercial());
					obtenerHijosLineaComercialPadre(lineaComercialDTO.getId().getCodigoLineaComercial(), codigosHijosLineaComercialPadre, codigoCompania);
				}
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e.getMessage());
		}
	}

	/**
	 * Metodo que obtiene la linea comercial padre
	 * de un funcionario
	 * @param lineaComercial
	 * @return
	 * @throws Exception 
	 */
	private LineaComercialDTO obtenerLineaComercialPadre(LineaComercialDTO lineaComercial, Integer codigoCompania) throws SICException {
		try {
			if (lineaComercial.getCodigoLineaComercialPadre() == null) {
				return lineaComercial;
			} else {
				LineaComercialDTO comercialDTO = null;
				comercialDTO = new LineaComercialDTO();
				comercialDTO.getId().setCodigoCompania(codigoCompania);
				comercialDTO.getId().setCodigoLineaComercial(lineaComercial.getCodigoLineaComercialPadre());
				
				//Criterios de busqueda
				comercialDTO.setCriteriaSearch(new CriteriaSearch());
				comercialDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", 
						ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				comercialDTO = this.dataGestor.findUnique(comercialDTO);
				return obtenerLineaComercialPadre(comercialDTO, codigoCompania);	
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e.getMessage());
		}
	}
	
	/**
	 * Metodo para consultar el numero de estructuras hijas
	 * @param claCol
	 */
	@Override
	public Collection<ClasificacionDTO> contarHijosClasificacion(Collection<ClasificacionDTO> claCol,ClasificacionDTO claHijo,String propLista, SubClasificacionDTO subCla) throws SICException{
		try {
			//se procedera a particionar la coleccion ingresada
			int count = 1;
			Collection<Collection<ClasificacionDTO>> particiones = new ArrayList<Collection<ClasificacionDTO>>();
			Collection<ClasificacionDTO> clasificacionPartes = new ArrayList<ClasificacionDTO>();
			for (ClasificacionDTO clasificacion : claCol) {
				clasificacionPartes.add(clasificacion);
				count++;
				if (count == 200) {
					particiones.add(clasificacionPartes);
					clasificacionPartes = new ArrayList<ClasificacionDTO>();
					count = 1;
				}
			}
			if (CollectionUtils.isNotEmpty(clasificacionPartes)) {
				particiones.add(clasificacionPartes);
			}
			//de cada particion se cuenta sus hijos
			for (Collection<ClasificacionDTO> clasificacionesParticionado : particiones) {
				if (subCla == null) {
					this.dataGestor.addChildrenCount(clasificacionesParticionado, claHijo, "numeroSubClasificacion", propLista);
				} else {
					this.dataGestor.addChildrenCount(clasificacionesParticionado, subCla, "numeroSubClasificacion", propLista);
				}
			}
			//se vuelve a restablecer las coleccion original para retornarla
			Collection<ClasificacionDTO> clasificacionesHijos=new ArrayList<ClasificacionDTO>();
			for(Collection<ClasificacionDTO> partesClasificaciones : particiones){
				clasificacionesHijos.addAll(partesClasificaciones);
			}
			return clasificacionesHijos;
		} catch (SICException e) {
			throw new SICException(e.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Collection<ClasificacionRelacionadaDTO> obtenerSubClasificacionRelacionada(String codigoClasificacion,Integer codigoCompania, String estadoClasificacionRelacionada, CriteriaSearchParameter filtroBusqueda )throws SICException{
		
		ClasificacionDTO clasificacionTemp = new ClasificacionDTO();
		clasificacionTemp.setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE);
		clasificacionTemp.setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);
		
		
		ClasificacionContenidoArchivoDTO clasificacionContenidoArchivoDTO = new ClasificacionContenidoArchivoDTO();
		ClasificacionArchivoDTO clasificacionArchivoDTO = new ClasificacionArchivoDTO();
		//clasificacionArchivoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArchivo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_INACTIVO_NUMERICO));
		clasificacionArchivoDTO.setClasificacionContenidoArchivoDTO(clasificacionContenidoArchivoDTO);
		
		clasificacionTemp.setClasificacionArchivoCol(new ArrayList<ClasificacionArchivoDTO>());
		clasificacionTemp.getClasificacionArchivoCol().add(clasificacionArchivoDTO);
		
		
		if(filtroBusqueda != null){
			clasificacionTemp.addCriteriaSearchParameter(filtroBusqueda);
		}
		
		
		
		ClasificacionDTO clasificacionPadreTemp = new ClasificacionDTO();
		clasificacionPadreTemp.setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE);
		clasificacionPadreTemp.setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);
		
		Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOs=new ArrayList<ClasificacionRelacionadaDTO>();
		try {
			ClasificacionRelacionadaDTO clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
			clasificacionRelacionadaDTO.setClasificacionRelacionada(clasificacionTemp);
			clasificacionRelacionadaDTO.setClasificacion(clasificacionPadreTemp);
//			clasificacionRelacionadaDTO.getClasificacionRelacionada().setClasificacionPadre(clasificacionPadreTemp);
			clasificacionRelacionadaDTO.setCodigoClasificacion(codigoClasificacion);
			clasificacionRelacionadaDTO.getId().setCodigoCompania(codigoCompania);
			clasificacionRelacionadaDTO.setOrderByField(OrderBy.orderAsc("clasificacionRelacionada.descripcionClasificacion"));
			
			clasificacionRelacionadaDTOs=this.dataGestor.findObjects(clasificacionRelacionadaDTO);
			
			ClasificacionRelacionadaDTO clasificacionRelacionadaDTOCount=new ClasificacionRelacionadaDTO();
			clasificacionRelacionadaDTOCount.setEstadoClasificacionRelacionada(estadoClasificacionRelacionada);
			/*
			 * este metodo permite contar el siguiente nivel 
			 * tomando la colleccion 
			 * la instancia del DTO relacionado
			 * variable que contendra el valor count que debe estar en el DTO
			 * el cuarto parametro es el nombre de la relacion en el DTO
			 */				
		/*
		 * CollectionUtils.collect(
		 * permite obtener el objeto interna que se encuentra 
		 * en la relacion la retorna en forma de colleccion
		 */
			this.dataGestor.addChildrenCount(CollectionUtils.collect(clasificacionRelacionadaDTOs, new GetInvokerTransformer("clasificacionRelacionada")) , clasificacionRelacionadaDTOCount,  "numeroSubClasificacion", "clasificacionRelacionadaPrincipal");
			
//			clasificacionDTO.setClasificacionRelacionadaSecundaria(clasificacionRelacionadaDTOs);
			
		}catch (SICException e) {
			throw new SICException(e);
		}
		return clasificacionRelacionadaDTOs;
	}
	
	
	public Collection<ClasificacionDTO> obtenerClasificaciones(String tipoEstructura, String estado){
		Logeable.LOG_SICV2.info("obtenerClasificaciones(String tipoEstructura, String estado)");
		Collection<ClasificacionDTO> clasificacionDTOs=new ArrayList<ClasificacionDTO>();
		try {
			ClasificacionDTO clasificacionDTO=new ClasificacionDTO();
			clasificacionDTO.setEstadoClasificacion(estado);
			clasificacionDTO.setCodigoTipoClasificacion(SICConstantes.TIPCLA_DIVISION);
			clasificacionDTO.setValorTipoEstructura(tipoEstructura);	
			clasificacionDTO.setOrderByField(OrderBy.orderAsc("descripcionClasificacion"));
			
			if(StringUtils.equalsIgnoreCase(tipoEstructura, CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE)){
				ClasificacionContenidoArchivoDTO clasificacionContenidoArchivoDTO = new ClasificacionContenidoArchivoDTO();
				
				ClasificacionArchivoDTO clasificacionArchivoDTO = new ClasificacionArchivoDTO();
				//clasificacionArchivoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArchivo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_INACTIVO_NUMERICO));
				clasificacionArchivoDTO.setClasificacionContenidoArchivoDTO(clasificacionContenidoArchivoDTO);
				
				clasificacionDTO.setClasificacionArchivoCol(new ArrayList<ClasificacionArchivoDTO>());
				clasificacionDTO.getClasificacionArchivoCol().add(clasificacionArchivoDTO);
			}
			
			
			clasificacionDTOs=this.dataGestor.findObjects(clasificacionDTO);
			
			
			
			
			/*
			 * este metodo permite contar el siguiente nivel 
			 * tomando la colleccion 
			 * la instancia del DTO relacionado
			 * variable que contendra el valor count que debe estar en el DTO
			 * el cuarto parametro es el nombre de la relacion en el DTO
			 */
			ClasificacionRelacionadaDTO clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
			clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			
			this.dataGestor.addChildrenCount(clasificacionDTOs,clasificacionRelacionadaDTO, "numeroSubClasificacion", "clasificacionRelacionadaPrincipal");
			
			
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e.getMessage());
		}
			
		return clasificacionDTOs;
		
	}
	
	@Override
	public ClasificacionDTO obtenerClasificacionesLineaComercial(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, String codigoBodega, String codigoClasificacion, String codigoDepartamento, Long codigoLineaComercial) throws SICException {
		return this.estructuraComercialDAO.obtenerClasificacionesLineaComercial(codigoCompania, codigoFuncionario, codigoProveedor, codigoBodega, codigoClasificacion, codigoDepartamento, codigoLineaComercial);
	}	
	
	@SuppressWarnings("unchecked")
	public Collection<ClasificacionDTO> obtenerClasificaciones(Collection<String> codigos, Collection<String>codigosSubClasificacion){
		Collection<ClasificacionDTO> clasificacionDTOs =new ArrayList<ClasificacionDTO>();
		try{
			Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOslist=new ArrayList<ClasificacionRelacionadaDTO>();
			ClasificacionDTO clasificacionDTO=new ClasificacionDTO();
			clasificacionDTO.setEstadoClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			clasificacionDTO.setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE);
			ClasificacionRelacionadaDTO clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
			clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			clasificacionRelacionadaDTO.setCriteriaSearch(new CriteriaSearch());
			clasificacionRelacionadaDTO.setClasificacionRelacionada(clasificacionDTO);
			clasificacionRelacionadaDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter("codigoClasificacion", ComparatorTypeEnum.IN_COMPARATOR, codigos));
			clasificacionRelacionadaDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter("codigoSubClasificacion", ComparatorTypeEnum.IN_COMPARATOR, codigosSubClasificacion));
			clasificacionRelacionadaDTO.setOrderByField(OrderBy.orderAsc("clasificacionRelacionada.id.codigoClasificacion"));
			clasificacionRelacionadaDTOslist = dataGestor.findObjects(clasificacionRelacionadaDTO);
			/*
			 * Obtenemos las ClasificacionesDTO de la consulta y eliminamos los datos repetidos
			 */
			if(CollectionUtils.isNotEmpty(clasificacionRelacionadaDTOslist)){
				clasificacionDTOs = (Collection<ClasificacionDTO>)CollectionUtils.collect(clasificacionRelacionadaDTOslist, new GetInvokerTransformer("clasificacionRelacionada"));
				//Eliminamos objetos repetidos
				Set<ClasificacionDTO> set = new LinkedHashSet<ClasificacionDTO>();
				set.addAll(clasificacionDTOs);
				clasificacionDTOs.clear();
				clasificacionDTOs.addAll(set);
			}
			
			/*
			 * este metodo permite contar el siguiente nivel 
			 * tomando la colleccion 
			 * la instancia del DTO relacionado
			 * variable que contendra el valor count que debe estar en el DTO
			 * el cuarto parametro es el nombre de la relacion en el DTO
			 */
			clasificacionRelacionadaDTO=new ClasificacionRelacionadaDTO();
			clasificacionRelacionadaDTO.setEstadoClasificacionRelacionada(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			this.dataGestor.addChildrenCount(clasificacionDTOs,clasificacionRelacionadaDTO, "numeroSubClasificacion", "clasificacionRelacionadaPrincipal");
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al buscar Clasificacion {}", e);
		}
		return clasificacionDTOs;
	}
	/**
	 * Verifica si existen articulos y subclasificaciones dentro de las clasificaciones padres e hijas  
	 * @param clasificacion
	 * @return
	 * @throws SICException
	 */
	@Override
	public boolean verificarArticulosClasificaciones(ClasificacionVO clasificacion) throws SICException{
		try{
			Collection<String> codigosArticulos = articuloDAO.obtenerCodigosArticulosClasificaciones(clasificacion.getBaseDTO());
			SubClasificacionDTO subClaDTO=new SubClasificacionDTO();
			subClaDTO.getId().setCodigoClasificacion(clasificacion.getBaseDTO().getId().getCodigoClasificacion());
			subClaDTO.getId().setCodigoCompania(clasificacion.getBaseDTO().getId().getCodigoCompania());
			subClaDTO.setEstadoSubClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			if(CollectionUtils.isNotEmpty(codigosArticulos) || dataGestor.findExists(subClaDTO)){
				return Boolean.FALSE;
			}
			
		}catch(Exception e){
			throw new SICException("Ocurrio un error al verificar los articulos de las clasificaciones ");
		}
		return Boolean.TRUE;
	}
	/**
	 * Verifica si la division tiene clasificaciones asignadas
	 * @param clasificacion
	 * @return
	 * @throws SICException
	 */
	public boolean verificarClasificaciones(ClasificacionVO clasificacion)throws SICException{
		try{
			ClasificacionDTO clasifDTO=new ClasificacionDTO();
			clasifDTO.setCodigoClasificacionPadre(clasificacion.getBaseDTO().getId().getCodigoClasificacion());
			clasifDTO.getId().setCodigoCompania(clasificacion.getBaseDTO().getId().getCodigoCompania());
//			clasifDTO.setCodigoTipoClasificacion(clasificacion.getBaseDTO().getCodigoTipoClasificacion());
			clasifDTO.setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);
			clasifDTO.setValorTipoEstructura(clasificacion.getBaseDTO().getValorTipoEstructura());
			clasifDTO.setEstadoClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			if(dataGestor.findExists(clasifDTO)){
				return Boolean.FALSE;
			}
		}catch(SICException e){
			throw new SICException("Ocurrio un error al verificar las clasificaciones del departamento");
		}
		return Boolean.TRUE;
	}
	/**
	 * Verifica si existen articulos relacionados con la subclasificacion enviada como parametro  
	 * @param subClasificacion
	 * @return
	 * @throws SICException
	 */
	public boolean verificarArticulosSubClasificaciones(SubClasificacionDTO subClasificacion) throws SICException{
		try{
			Collection<String> listaCodigos = new ArrayList<String>();
			listaCodigos = articuloDAO.obtenerCodigosArticulosSubClasificaciones(subClasificacion);
			if(CollectionUtils.isNotEmpty(listaCodigos)){
				return Boolean.FALSE;
			}
			
		}catch(Exception e){
			throw new SICException("Error al verificar articulos de la subclasificacion");
		}
		return Boolean.TRUE;
	}
	/**
	 * Obtiene la lista de las estructuras WRT de una estructura comercial
	 * @param estComercialDTO
	 * @return
	 */
	public Collection<ClasificacionDTO> obtenerEstComercialRelacionadaEstWRT(ClasificacionDTO estComercialDTO)throws SICException{
		try{
			return articuloDAO.obtenerEstWRTRelacionada(estComercialDTO);
		}
		catch(SICException e){
			throw new SICException("Error al verificar articulos de la subclasificacion");
		}
	}
	
	
	/**
	 * Proceso que redimensiona las imagenes de las clasificaciones cuando son orientadas al cliente,
	 * este proceso es necesario para el sistema Asistente de Compras (cupones) 
	 * @param clasificacionArchivoDTO
	 * @throws IOException 
	 */
	public void procesoRedimensionarImagenesYEnviarPorFTP(ClasificacionArchivoDTO clasificacionArchivoDTO) throws SICException {
		Logeable.LOG_SICV2.info(":::::::::::::Inicio de procesoRedimensionarImagenesYEnviarPorFTP::::::::::::");
		try {
			String directorioArchivoImagen = SICArticuloMessages.getInstancia().getString("ec.com.smx.estructura.comercial.imagenes.resize.path");

			Collection<ParametroDTO> parametrosImagenes = this.consultaParametrosImagenes();

			for (ParametroDTO parametroDTO : parametrosImagenes) {
				String[] tamanioImagenes = parametroDTO.getValorParametro().split("-");

				Integer dimension = Integer.parseInt(tamanioImagenes[0]);
				String descripcionTamanio = tamanioImagenes[1];

				this.redimensionarImagen(clasificacionArchivoDTO.getClasificacionContenidoArchivoDTO().getContenidoArchivo(), clasificacionArchivoDTO.getNombreArchivo(), descripcionTamanio, dimension, dimension, directorioArchivoImagen);
			}

			this.enviarPorFTPImagenesCategoria(clasificacionArchivoDTO.getNombreArchivo(), parametrosImagenes, directorioArchivoImagen);
		} catch (SICException e) {
			Logeable.LOG_SICV2.error("Error al enviar imagen de clasificaci\u00F3n por FTP {}", e);
			throw new SICException("Error al enviar imagen de clasificaci\u00F3n por FTP");
		} catch(IOException e){
			Logeable.LOG_SICV2.error("Error al enviar imagen de clasificaci\u00F3n por FTP {}", e);
			throw new SICException("Error al enviar imagen de clasificaci\u00F3n por FTP");
		}
		Logeable.LOG_SICV2.info("::::::::::::FIN de procesoRedimensionarImagenesYEnviarPorFTP::::::::::::::");
	}
	
	public void redimensionarImagen(byte[] datoImagen, String imageName, String descripcionTamanio, Integer width, Integer height, String directorio) throws IOException{
		try {
			
		InputStream imagenIn = new ByteArrayInputStream(datoImagen);
		BufferedImage imagenOriginal = ImageIO.read(imagenIn);
		BufferedImage imageResize = ResizeUtil.resize(imagenOriginal,Method.QUALITY,width,height,null);
		File rutaImagen = new File(directorio + File.separator + descripcionTamanio);
		String[] nombreImagen = imageName.split("\\.");
		String nombreImagenFinal = nombreImagen[0]+"."+"png"; 
		if(!rutaImagen.exists()){
			rutaImagen.mkdirs();
		}
		ImageIO.write(imageResize, "png", new File(rutaImagen + File.separator +nombreImagenFinal));
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al redimensionar la imagen de la clasificacion {}", e);
			throw new IOException("Error al redimensionar la imagen de la clasificaci\u00F3n");
		}
	}
	
	
	/**
	 * Envia las imagenes de los cupones por FTP
	 * @param imagenes
	 * @param parametrosImagenes
	 */
	public void enviarPorFTPImagenesCategoria(String nombreArchivo, Collection<ParametroDTO> parametrosImagenes, String directorioImagenes)throws SICException{
		Logeable.LOG_SAC.info(":...Inicio metodo enviar imagenes por FTP...:");
		try {
			ProcesoConfiguracionDTO procesoConfiguracionDTO = this.obtenerProcesoConfiguracionImagenes();
			String pathLocal = directorioImagenes;
			FtpManager ftpManager = new FtpManager();

				for (ParametroDTO parametroDTO : parametrosImagenes) {
					String[] tamanioImagenes = parametroDTO.getValorParametro().split("-");
					String rutaImagenLocal = pathLocal + File.separator + tamanioImagenes[1];
					String rutaImagenRemota = "/" + tamanioImagenes[1];
					ftpManager.sendFile(procesoConfiguracionDTO, rutaImagenLocal, nombreArchivo, rutaImagenRemota, nombreArchivo);
				}
			Logeable.LOG_SAC.info(":...Fin metodo enviar imagenes por FTP...:");
		} catch (IOException e) {
			Logeable.LOG_SAC.error("Error al enviar imagenes por ftp",e);
			throw new SICException("Error al enviar la imagen por FTP");
		} catch (FTPException e) {
			Logeable.LOG_SAC.error("Error al enviar imagenes por ftp",e);
			throw new SICException("Error al enviar la imagen por FTP");
		} catch (Exception e) {
			Logeable.LOG_SAC.error("Error al enviar imagenes por ftp",e);
			throw new SICException("Error al enviar la imagen por FTP");
		}
	}
	
	/**
	 * Metodo que consulta los parametros con los tamanos de las imagenes
	 * @return
	 */
	public Collection<ParametroDTO> consultaParametrosImagenes()throws SICException{
		ParametroDTO parametroDTO = new ParametroDTO();
		parametroDTO.addCriteriaSearchParameter("id.codigoParametro",ComparatorTypeEnum.IN_COMPARATOR, new String[]{SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.estructura.comercial.parametro.tamanio.imagen.small"),
				SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.estructura.comercial.parametro.tamanio.imagen.normal"),
				SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.estructura.comercial.parametro.tamanio.imagen.large"),
				SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.estructura.comercial.parametro.tamanio.imagen.xlarge"),
				SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.estructura.comercial.parametro.tamanio.imagen.xxlarge")});

		Collection<ParametroDTO> parametroDTOs = new ArrayList<ParametroDTO>();
		parametroDTOs = dataGestor.findObjects(parametroDTO);
		return parametroDTOs;
	}
	
	/**
	 * Obtiene el procesoConfiguracion para el envio por FTP de imagenes de cupones
	 */
	public ProcesoConfiguracionDTO obtenerProcesoConfiguracionImagenes(){
		AreaTrabajoDTO areaTrabajoDTO = new AreaTrabajoDTO();
		areaTrabajoDTO.setJoinType(JoinType.INNER);
		areaTrabajoDTO.setEstadoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);

		ServidorAreaTrabajoDTO servidorAreaTrabajoDTO = new ServidorAreaTrabajoDTO();
		servidorAreaTrabajoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		servidorAreaTrabajoDTO.setAreaTrabajoDTO(areaTrabajoDTO);

		ServidorDTO servidorDTODestino = new ServidorDTO();
		servidorDTODestino.setJoinType(JoinType.INNER);
		servidorDTODestino.setLstServidorAreaTrabajoDTOs(new HashSet<ServidorAreaTrabajoDTO>());
		servidorDTODestino.getLstServidorAreaTrabajoDTOs().add(servidorAreaTrabajoDTO);		

		ProcesoServidorDTO procesoServidorOrigen = new ProcesoServidorDTO();
		procesoServidorOrigen.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		procesoServidorOrigen.setCodigoProceso(Long.valueOf(RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.imagenes.cupones.codigo.proceso.envio")));
		procesoServidorOrigen.setJoinType(JoinType.INNER);

		ProcesoServidorDTO procesoServidorDestino = new ProcesoServidorDTO();
		procesoServidorDestino.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		procesoServidorDestino.setServidorDTO(servidorDTODestino);
		procesoServidorDestino.setJoinType(JoinType.INNER);

		ProcesoConfiguracionDTO procesoConfiguracionBusqueda = new ProcesoConfiguracionDTO();
		procesoConfiguracionBusqueda.getId().setCodigoCompania(1);
		procesoConfiguracionBusqueda.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		procesoConfiguracionBusqueda.setProcesoServidorOrigenDTO(procesoServidorOrigen);
		procesoConfiguracionBusqueda.setProcesoServidorDestinoDTO(procesoServidorDestino);

		ProcesoConfiguracionDTO procesoConfiguracionDTOBusqueda = dataGestor.findUnique(procesoConfiguracionBusqueda);

		//GC
		procesoConfiguracionBusqueda = null;
		servidorDTODestino = null;
		servidorAreaTrabajoDTO =null;
		procesoServidorOrigen=null;
		procesoServidorDestino=null;

		return procesoConfiguracionDTOBusqueda;
	}
	
	@Override
	public Boolean validarDescripcionClasificacion(ClasificacionDTO clasificacion)throws SICException{
		return articuloDAO.validarDescripcionClasificacion(clasificacion);
	}
	@Override
	public Collection<SubClasificacionDTO> validarDescripcionSubclasificacion( SubClasificacionDTO subcla)throws SICException{
		return articuloDAO.validarDescripcionSubclasificacion(subcla);
	}
	
	/**
	 * Obtener la clasificacion con la colecion de subclasificacion correspondiente.
	 * @author aquingaluisa
	 * @param codigoCompania
	 * @param codigoClasificacion en el caso de no traer este dato trae todas las clasificaciones
	 * @param codigoBodega
	 * @param codigoProveedor 
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<ClasificacionDTO> obtenerClasificacionesConSubClasificion(Integer codigoCompania,String codigoClasificacion,String codigoBodega,String codigoProveedor) throws SICException{
		return this.clasificacionDAO.obtenerClasificacionesConSubClasificion(codigoCompania, codigoClasificacion, codigoBodega, codigoProveedor);
	}
	
	/**
	 * Obtener la  subclasificacion especifica por codigoClasificacion, y subclasificacion
	 * @param codigoCompania
	 * @param codigoClasificacion
	 * @param codigoSubClasificacion
	 * @return
	 * @throws SICException
	 */
	@Override
	public SubClasificacionDTO  obtenerSubClasificacionDTO(Integer codigoCompania,String codigoClasificacion,String codigoSubClasificacion) throws SICException{
		return this.clasificacionDAO.obtenerSubClasificacionDTO(codigoCompania, codigoClasificacion, codigoSubClasificacion);
	}
	/**
	 * @return the accionEstructuraComercialGestor
	 */
	public IAccionEstructuraComercialGestor getAccionEstructuraComercialGestor() {
		return accionEstructuraComercialGestor;
	}

	/**
	 * @param accionEstructuraComercialGestor the accionEstructuraComercialGestor to set
	 */
	public void setAccionEstructuraComercialGestor(IAccionEstructuraComercialGestor accionEstructuraComercialGestor) {
		this.accionEstructuraComercialGestor = accionEstructuraComercialGestor;
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

	public IArticuloDAO getArticuloDAO() {
		return articuloDAO;
	}

	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	public IEstructuraComercialDAO getEstructuraComercialDAO() {
		return estructuraComercialDAO;
	}

	public void setEstructuraComercialDAO(IEstructuraComercialDAO estructuraComercialDAO) {
		this.estructuraComercialDAO = estructuraComercialDAO;
	}

	public ClasificacionDAO getClasificacionDAO() {
		return clasificacionDAO;
	}

	public void setClasificacionDAO(ClasificacionDAO clasificacionDAO) {
		this.clasificacionDAO = clasificacionDAO;
	}

}
