/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.unidadmanejo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.ListSet;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.calculo.ICalculoUnidadManejoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.validacion.IValidacionUnidadManejoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorEquivalenciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloUnidadManejoID;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloUnidadManejoDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * Implementaci&oacute;n de la l&oacute;gica del negocio para el registro de unidades de manejo
 * @author fmunoz
 *
 */
public class ArticuloUnidadManejoGestor implements IArticuloUnidadManejoGestor{
 
	private DataGestor dataGestor;
	private IArticuloUnidadManejoDAO articuloUnidadManejoDAO;
	private ICalculoUnidadManejoGestor calculoUnidadManejoGestor;
	private IValidacionUnidadManejoGestor validacionUnidadManejoGestor;
	private ICalculoArticuloGestor calculoArticuloGestor;
	
	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOUNIDADMANEJO
	 * @param articuloVO
	 * @param esCreacion
	 * @param campoCodigoArticulo
	 */
	@Override
	public void registrarArticuloUnidadManejo(ArticuloVO articuloVO)throws SICException{
		
		Logeable.LOG_SICV2.info("==> Registrando Unidad Manejo");
		Boolean despachoPorPallet = Boolean.FALSE;
		if(articuloVO.getBaseDTO().getTieneUnidadManejoCol()){
			Collection<ArticuloUnidadManejoDTO> eansRepetidos = validacionUnidadManejoGestor.validarUnicidadEAN14(articuloVO, articuloVO.getBaseDTO().getArticuloUnidadManejoCol());
			if(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO.equals(articuloVO.getBaseDTO().getCodigoEstado())){
				//solo si el articulo esta codificado
				articuloUnidadManejoDAO.eliminarEANs(eansRepetidos, articuloVO.getBaseDTO().getUserId(), articuloVO.getBaseDTO().getId().getCodigoCompania());
			}
			
			Collection<ArticuloUnidadManejoDTO> nuevosRegistros = new ArrayList<ArticuloUnidadManejoDTO>();
			for(ArticuloUnidadManejoDTO dto : articuloVO.getBaseDTO().getArticuloUnidadManejoCol()){
				dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				dto.setUserId(articuloVO.getBaseDTO().getUserId());
				if(dto.getId().getCodigoUnidadManejo() == null){
					dto.addDynamicProperty(SICConstantes.EVENTO_INSERTAR, "1");
				}else{
					dto.removeDynamicProperty(SICConstantes.EVENTO_INSERTAR);}
				ArticuloUnidadManejoDTO nuevoRegistro = registrarArticuloUnidadManejo(dto);
				if(nuevoRegistro != null){
					nuevosRegistros.add(nuevoRegistro);
				}
				if(dto.getTieneArticuloUnidadManejoContenedora()){
					for(ArticuloUnidadManejoDTO aum : dto.getArticuloUnidadManejoContenedoraCol()){
						//se verifica si la unidad de manejo se despacha por pallet
						if(SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PALLET.equals(aum.getValorTipoUnidadEmpaque()) && 
								aum.getValorUnidadManejo() != null && aum.getValorUnidadManejo().intValue() == 1 &&
								SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(aum.getEstadoUnidadManejo())){
							despachoPorPallet = Boolean.TRUE;
							break;
						}
					}
				}
			}
			
			articuloVO.getBaseDTO().getArticuloUnidadManejoCol().addAll(nuevosRegistros);
			
			//calculoUnidadManejoGestor.relacionarUnidadManejoPrecio(articuloVO.getBaseDTO(), articuloUnidadesManejoCol);
			calculoUnidadManejoGestor.relacionarUnidadManejoPrecio(articuloVO.getBaseDTO(), articuloVO.getBaseDTO().getArticuloUnidadManejoCol());
			
			registrarDatosLogisticosDesdeUnidadManejo(articuloVO, despachoPorPallet);
			
		}else if(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO.equals(articuloVO.getBaseDTO().getCodigoEstado())){
			ArticuloUnidadManejoDTO filtro = new ArticuloUnidadManejoDTO();
			filtro.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			filtro.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			filtro.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			Collection<ArticuloUnidadManejoDTO> unidades = dataGestor.findObjects(filtro);
			articuloUnidadManejoDAO.eliminarEANs(validacionUnidadManejoGestor.validarUnicidadEAN14(articuloVO, unidades), articuloVO.getBaseDTO().getUserId(), articuloVO.getBaseDTO().getId().getCodigoCompania());
		}
	}
	
	
	private void registrarDatosLogisticosDesdeUnidadManejo(ArticuloVO articuloVO, Boolean despachoPorPallet){
		Boolean crearProcesoLogistico = articuloVO.getEsCreacion();
		if(!articuloVO.getBaseDTO().getTieneArticuloProcesoLogistico()){
			ArticuloProcesoLogisticoDTO apl = new ArticuloProcesoLogisticoDTO();
			apl.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			apl.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			apl = dataGestor.findUnique(apl);
			if(apl != null){
				articuloVO.getBaseDTO().setArticuloProcesoLogisticoDTO(apl);
			}else{
				articuloVO.getBaseDTO().setArticuloProcesoLogisticoDTO(new ArticuloProcesoLogisticoDTO());
				crearProcesoLogistico = Boolean.TRUE;
			}
		}
		if((despachoPorPallet && !SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PALLET.equals(articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorContenedorDistribucion()))
				|| (!despachoPorPallet && SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PALLET.equals(articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().getValorContenedorDistribucion()))){
			if(despachoPorPallet){
				articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setCodigoContenedorDistribucion(SICArticuloConstantes.getInstancia().CODIGOTIPOEMPAQUE);
				articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setValorContenedorDistribucion(SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PALLET);
			}else{
				articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setCodigoContenedorDistribucion(null);
				articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setValorContenedorDistribucion(null);
			}
			calculoArticuloGestor.registrarArticuloProcesoLogistico(articuloVO, crearProcesoLogistico);
		}
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.unidadmanejo.IArticuloUnidadManejoGestor#registrarArticuloUnidadManejo(ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO)
	 */
	@Override
	public ArticuloUnidadManejoDTO registrarArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO)throws SICException{
		Collection<ArticuloUnidadManejoUsoDTO> articuloUnidadesManejoUsoCol = null;
		Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoContenedoraCol = null;
		ArticuloUnidadManejoDTO newArtUniMan = null;
		Map<String, Object> relations = null;
		try{
			//validacionUnidadManejoGestor.validarArticuloUnidadManejo(articuloUnidadManejoDTO);
			if(articuloUnidadManejoDTO.getTieneUnidadesManejoUso()){
				articuloUnidadesManejoUsoCol = articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol();
				articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(null);
			}
			
			if(articuloUnidadManejoDTO.getTieneArticuloUnidadManejoContenedora()){
				articuloUnidadManejoContenedoraCol = articuloUnidadManejoDTO.getArticuloUnidadManejoContenedoraCol();
				articuloUnidadManejoDTO.setArticuloUnidadManejoContenedoraCol(null);
			}
			
			calculoUnidadManejoGestor.asignarCamposUnidadManejo(articuloUnidadManejoDTO);
			Logeable.LOG_SICV2.info(" -> Unidad manejo valorTipoUnidadEmpaque {} valorUnidadManejo {}",articuloUnidadManejoDTO.getValorTipoUnidadEmpaque(),articuloUnidadManejoDTO.getValorUnidadManejo());
			Logeable.LOG_SICV2.info("   - Estado Unidad manejo {}",articuloUnidadManejoDTO.getEstadoUnidadManejo());
			if(articuloUnidadManejoDTO.getDynamicProperty(SICConstantes.EVENTO_INSERTAR) != null){
				relations = SICUtil.getInstance().clearRelations(articuloUnidadManejoDTO);
				dataGestor.create(articuloUnidadManejoDTO);
				SICUtil.getInstance().restoreRelations(articuloUnidadManejoDTO, relations);
				relations = null;
			}else{
				Integer valorUnidadAnterior = (Integer)articuloUnidadManejoDTO.getDynamicProperty(ArticuloUnidadManejoDTO.VALOR_UNIDAD_ANTERIOR);
				if(valorUnidadAnterior != null && valorUnidadAnterior.intValue() != articuloUnidadManejoDTO.getValorUnidadManejo().intValue()){
					if(articuloUnidadManejoDAO.tieneAsignadoProveedores(articuloUnidadManejoDTO)){
						newArtUniMan = SerializationUtils.clone(articuloUnidadManejoDTO);
						//se crea la nueva unidad de venta
						newArtUniMan.getId().setCodigoUnidadManejo(null);
						relations = SICUtil.getInstance().clearRelations(newArtUniMan);
						dataGestor.create(newArtUniMan);
						SICUtil.getInstance().restoreRelations(newArtUniMan, relations);
						relations = null;
						newArtUniMan.addDynamicProperty(ArticuloUnidadManejoDTO.VALOR_UNIDAD_ANTERIOR, newArtUniMan.getValorUnidadManejo());
						newArtUniMan.addDynamicProperty(SICConstantes.EVENTO_INSERTAR, Boolean.TRUE);
								
						articuloUnidadManejoDTO.addDynamicProperty(ArticuloUnidadManejoDTO.NUEVO_REGISTRO, newArtUniMan);
						articuloUnidadManejoDTO.setValorUnidadManejo(valorUnidadAnterior);
						articuloUnidadManejoDTO.setDescuentoVenta(null);
						//se actualiza la relacion con el uso de la nueva unidad de manejo
						if(newArtUniMan.getTieneUnidadesManejoUso()){
							Collection<ArticuloUnidadManejoUsoDTO> usosInvalidos = new ArrayList<ArticuloUnidadManejoUsoDTO>();
							for(ArticuloUnidadManejoUsoDTO dto : newArtUniMan.getArticuloUnidadManejoUsoCol()){
								if(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA.equals(dto.getId().getValorTipoUso())){
									dto.getId().setCodigoUnidadManejo(newArtUniMan.getId().getCodigoUnidadManejo());
									dto.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									relations = SICUtil.getInstance().clearRelations(dto);
									dataGestor.create(dto);
									SICUtil.getInstance().restoreRelations(dto, relations);
									relations = null;
								}else{
									usosInvalidos.add(dto);
								}
							}
							newArtUniMan.getArticuloUnidadManejoUsoCol().removeAll(usosInvalidos);
						}else{
							ArticuloUnidadManejoUsoDTO newArtUniManUso = new ArticuloUnidadManejoUsoDTO();
							newArtUniManUso.getId().setValorTipoUso(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA);
							asignarValoresUnidadManejoUso(newArtUniMan, newArtUniManUso);
							dataGestor.create(newArtUniManUso);
							newArtUniMan.setArticuloUnidadManejoUsoCol(new ListSet());
							newArtUniMan.getArticuloUnidadManejoUsoCol().add(newArtUniManUso);
						}
						
						//INACTIVA EL USO DE VENTA DE LA UNIDAD DE MANEJO EN LA BASE
						articuloUnidadManejoDAO.cambiarEstadoUso(articuloUnidadManejoDTO, SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA, 
								SICConstantes.ESTADO_INACTIVO_NUMERICO);
						//se desactiva el uso de venta de memoria
						if(SearchDTO.isLoaded(articuloUnidadesManejoUsoCol)){
							ArticuloUnidadManejoUsoDTO aums = null;
							for(ArticuloUnidadManejoUsoDTO dto : articuloUnidadesManejoUsoCol){
								if(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA.equals(dto.getId().getValorTipoUso())){
									aums = dto;
									break;
								}
							}
							if(aums != null){
								articuloUnidadesManejoUsoCol.remove(aums);
							}
						}
					}
				}
				dataGestor.update(articuloUnidadManejoDTO);
			}
			
			dataGestor.detach(articuloUnidadManejoDTO);
			
			articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(articuloUnidadesManejoUsoCol);
			if(articuloUnidadManejoDTO.getTieneUnidadesManejoUso()){
				for(ArticuloUnidadManejoUsoDTO dto : articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol()){
					asignarValoresUnidadManejoUso(articuloUnidadManejoDTO, dto);
					Logeable.LOG_SICV2.info("   - Uso Unidad manejo {}", dto.getId().getValorTipoUso() );
					if(articuloUnidadManejoDTO.getDynamicProperty(SICConstantes.EVENTO_INSERTAR) != null){
						dataGestor.create(dto);
					}else{
						dataGestor.createOrUpdate(dto);}
					dataGestor.detach(dto);
				}
			}
			
			
			//registro de unidades de manejo contenedor
			articuloUnidadManejoDTO.setArticuloUnidadManejoContenedoraCol(articuloUnidadManejoContenedoraCol);
			if(articuloUnidadManejoDTO.getTieneArticuloUnidadManejoContenedora()){
				for(ArticuloUnidadManejoDTO uniManContenedoraDTO : articuloUnidadManejoDTO.getArticuloUnidadManejoContenedoraCol()){
					
					//asigna campos por defecto
					calculoUnidadManejoGestor.asignarCamposUnidadManejo(articuloUnidadManejoDTO);
					//asigna que el contenedor no sea principal
					//uniManContenedoraDTO.setEsPrincipal(Boolean.FALSE);
					//asigna a que unidad de manejo le contiene
					uniManContenedoraDTO.setCodigoUnidadManejoContenida(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
					
					uniManContenedoraDTO.getId().setCodigoCompania(articuloUnidadManejoDTO.getId().getCodigoCompania());
					uniManContenedoraDTO.getId().setCodigoArticulo(articuloUnidadManejoDTO.getId().getCodigoArticulo());
					uniManContenedoraDTO.setUserId(articuloUnidadManejoDTO.getUserId());
					
					relations = SICUtil.getInstance().clearRelations(uniManContenedoraDTO);
					if(uniManContenedoraDTO.getId().getCodigoUnidadManejo() == null && StringUtils.equals(uniManContenedoraDTO.getEstadoUnidadManejo(), SICConstantes.ESTADO_ACTIVO_NUMERICO)){
						dataGestor.create(uniManContenedoraDTO);
					}else{
						if(SICConstantes.ESTADO_ACTIVO_NUMERICO.compareTo(uniManContenedoraDTO.getEstadoUnidadManejo()) == 0){
							dataGestor.createOrUpdate(uniManContenedoraDTO);
						}else if(SICConstantes.ESTADO_INACTIVO_NUMERICO.compareTo(uniManContenedoraDTO.getEstadoUnidadManejo()) == 0){
							dataGestor.delete(uniManContenedoraDTO);
						}
						dataGestor.detach(uniManContenedoraDTO);
						
					}
					SICUtil.getInstance().restoreRelations(uniManContenedoraDTO, relations);
					relations = null;
				}
			}
			
			//se crean las unidades de manejo del proveedor
			if(articuloUnidadManejoDTO.getTieneUnidadesManejoProveedor()){
				for(ArticuloUnidadManejoProveedorDTO ump : articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol()){
					if(StringUtils.isEmpty(ump.getEstado())){
						ump.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					}
					ump.getId().setCodigoCompania(articuloUnidadManejoDTO.getId().getCodigoCompania());
					ump.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
					ump.setCodigoArticulo(articuloUnidadManejoDTO.getId().getCodigoArticulo());
					ump.setUserId(articuloUnidadManejoDTO.getUserId());
					
					ArticuloUnidadManejoProveedorEquivalenciaDTO artEqu = null;
					// completa la informacion de la equivalencia de la unidad de manejo proveedor
					artEqu = this.completarInformacionArtUniManProEqu(ump, artEqu);
					
					Logeable.LOG_SICV2.info("   - Unidad manejo proveedor: {}, {}", ump.getId().getCodigoUnidadManejo(), ump.getId().getCodigoProveedor() );
					if(articuloUnidadManejoDTO.getDynamicProperty(SICConstantes.EVENTO_INSERTAR) != null){
						dataGestor.create(ump);
						if( artEqu != null ){
							artEqu.setIdUsuarioRegistro(ump.getIdUsuarioRegistro());
							artEqu.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
							
							dataGestor.create(artEqu);
						}
					}else{
						ump.setIdUsuarioRegistro(articuloUnidadManejoDTO.getUserId());
						ump.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
						this.articuloUnidadManejoDAO.crearUnidadManejoProveedor(ump);
						if( artEqu != null ){
							//verificamos la existencia
							ArticuloUnidadManejoProveedorEquivalenciaDTO articuloUnidadManejoProveedorEquivalenciaDTO = this.articuloUnidadManejoDAO.buscarArticuloUnidadManejoProveedorEquivalecia(artEqu);
							
							if( articuloUnidadManejoProveedorEquivalenciaDTO != null ){
								//validamos el estado, si es 0, inactivamos
								if(articuloUnidadManejoProveedorEquivalenciaDTO.getId().getCodigoEquivalencia().compareTo(artEqu.getId().getCodigoEquivalencia()) == 0
									&& StringUtils.equals(artEqu.getEstado(), SICConstantes.ESTADO_INACTIVO_NUMERICO)){
									this.articuloUnidadManejoDAO.removerUnidadManejoProveedorEquivalecia(artEqu);
								}else{
									//si es activo, actualizamos con los nuevos valores
									artEqu.setIdUsuarioModificacion(ump.getIdUsuarioModificacion()==null?ump.getIdUsuarioRegistro():ump.getIdUsuarioModificacion());
									artEqu.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
									this.articuloUnidadManejoDAO.actualizarArticuloUnidadManejoProveedorEquivalecia(artEqu);
								}
							}else{
								artEqu.setIdUsuarioRegistro(ump.getIdUsuarioRegistro());
								artEqu.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
								dataGestor.create(artEqu);
							}
						}
					}
				}
			}
			
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.unidadmanejo"),e);
		}finally{
			articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(articuloUnidadesManejoUsoCol);
			articuloUnidadesManejoUsoCol = null;
			relations = null;
		}
		
		return newArtUniMan;
	}
	
	/**
	 * Completa la informacion del articulo equivalencia
	 * @param ump
	 * @param artEqu
	 * @return
	 */
	private ArticuloUnidadManejoProveedorEquivalenciaDTO completarInformacionArtUniManProEqu(ArticuloUnidadManejoProveedorDTO ump, ArticuloUnidadManejoProveedorEquivalenciaDTO artEqu){
		if( ump != null && ump.getEquivalenciaPorcentajeDescuentoDTO() != null ){
			artEqu = new ArticuloUnidadManejoProveedorEquivalenciaDTO();
			artEqu.getId().setCodigoCompaniaArtUniManPro(ump.getId().getCodigoCompania());
			artEqu.getId().setCodigoCompaniaEquPorDes(ump.getEquivalenciaPorcentajeDescuentoDTO().getId().getCodigoCompania());
			artEqu.getId().setCodigoEquivalencia(ump.getEquivalenciaPorcentajeDescuentoDTO().getId().getCodigoEquivalencia());
			artEqu.getId().setCodigoProveedor(ump.getId().getCodigoProveedor());
			artEqu.getId().setCodigoUnidadManejo(ump.getId().getCodigoUnidadManejo());
			artEqu.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			// quitar la relacion de la coleccion de equivalencias
			ump.setEquivalenciaPorcentajeDescuentoCol(null);
			// verificar si es inactivacion
			if( ump.getEquivalenciaPorcentajeDescuentoDTO().getId().getCodigoEquivalencia() == null ){				
				if(	ump.getEquivalenciaPorcentajeDescuentoDTO().hasDynamicProperty("codigoEquivalencia") && ump.getEquivalenciaPorcentajeDescuentoDTO().getDynamicProperty("codigoEquivalencia") != null ){
					artEqu.getId().setCodigoEquivalencia(Integer.valueOf(ump.getEquivalenciaPorcentajeDescuentoDTO().getDynamicProperty("codigoEquivalencia").toString()));
					artEqu.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				}else{
					artEqu = null;
				}
			}
		}
		return artEqu;
	}
	
	private void asignarValoresUnidadManejoUso(ArticuloUnidadManejoDTO aum, ArticuloUnidadManejoUsoDTO aums){
		calculoUnidadManejoGestor.asignarCamposUnidadManejoUso(aums);
		aums.getId().setCodigoCompania(aum.getId().getCodigoCompania());
		aums.getId().setCodigoUnidadManejo(aum.getId().getCodigoUnidadManejo());
		aums.setCodigoArticulo(aum.getId().getCodigoArticulo());
		aums.setUserId(aum.getUserId());
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.unidadmanejo.IArticuloUnidadManejoGestor#obtenerUnidadesManejoActivasPorArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO)
	 */
	@Override
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException {
		if( articuloDTO != null && articuloDTO.getId() != null ){
			return this.articuloUnidadManejoDAO.obtenerUnidadesManejoActivasPorArticulo( articuloDTO.getId().getCodigoArticulo() );
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.unidadmanejo.IArticuloUnidadManejoGestor#obtenerNumeroUnidadesManejoActivasPorArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO)
	 */
	@Override
	public Integer obtenerNumeroUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException {
		if( articuloDTO != null && articuloDTO.getId() != null ){
			Collection<ArticuloUnidadManejoDTO> unidadesManejo = this.articuloUnidadManejoDAO.obtenerUnidadesManejoActivasPorArticulo( articuloDTO.getId().getCodigoArticulo() );
			if( CollectionUtils.isNotEmpty(unidadesManejo) )
				return CollectionUtils.size(unidadesManejo);
		}
		return 0;
	}

	//Metodo para BODEGA utilizado para actualizar los valores de la unidad de manejo como: 
	//Peso, Alto, Ancho, Profundidad, valorUnidadManejo
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor#actualizarUnidadManejoRecepcion(ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO)
	 */
	@Override
	public void actualizarUnidadManejoRecepcion(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException{
		try{
			if(articuloUnidadManejoDTO!= null && articuloUnidadManejoDTO.getId() != null){
				this.articuloUnidadManejoDAO.actualizarUnidadManejo(articuloUnidadManejoDTO);
			}else{
				throw new SICException("Existen valores vacios para actualizar la unidad de manejo");
			}
		} catch(Exception e) {
    		throw new SICException("No se pudo modificar los valores de la unidad de manejo",e);
    	}		
	}
	
	//
	// Comentado por cambio de funcionalidad: CODIGOUNIDADMANEJOPADRE guarda el codigoUnidadManejoContenida (Hija)
	// Las UM hijas son las que tienen null en el CODIGOUNIDADMANEJOPADRE, y son las que aparecen en la administracion de OC
	//
	//Metodo para BODEGA utilizado para actualizar el valor del contenedor PALLET para un articulo
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor#actualizarCantidadMaximaUnidadManejo(ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO, ec.com.smx.corpv2.dto.CatalogoValorDTO, java.lang.Integer)
	 */
//	@Override
//	public ArticuloUnidadManejoDTO actualizarCantidadMaximaUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, CatalogoValorDTO tipoEmpaque, Integer valorUnidadManejo) throws SICException{
//		try{
//			ArticuloUnidadManejoDTO newArtUniMan = null;
//			Timestamp fechaRegistro = new Timestamp(new Date().getTime());
//			if(articuloUnidadManejoDTO!= null && articuloUnidadManejoDTO.getId() != null && tipoEmpaque != null && tipoEmpaque.getId() != null && articuloUnidadManejoDTO.getUserId() != null){
//				
//				//Buscar unidad manejo padre del tipo de contenedor especificado(PALLET)				
//				ArticuloUnidadManejoDTO plantilla = new ArticuloUnidadManejoDTO();
//				plantilla.getId().setCodigoArticulo(articuloUnidadManejoDTO.getId().getCodigoArticulo());
//				plantilla.getId().setCodigoCompania(articuloUnidadManejoDTO.getId().getCodigoCompania());
//				plantilla.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
//				plantilla.setUnidadManejoContenida(new ArticuloUnidadManejoDTO());							
//				plantilla.addJoin("unidadManejoContenida", JoinType.LEFT, 
//						new CriteriaSearchParameter<String>("estadoUnidadManejo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO),
//						new CriteriaSearchParameter<String>("valorTipoUnidadEmpaque", ComparatorTypeEnum.EQUAL_COMPARATOR, tipoEmpaque.getId().getCodigoCatalogoValor()),
//						new CriteriaSearchParameter<Integer>("codigoTipoUnidadEmpaque", ComparatorTypeEnum.EQUAL_COMPARATOR, tipoEmpaque.getId().getCodigoCatalogoTipo()));								
//				ArticuloUnidadManejoDTO resultado = dataGestor.findUnique(plantilla);
//				if(resultado != null){
//					if(resultado.getUnidadManejoContenida()!= null){//Se actualiza el valor del PALLET
//						ArticuloUnidadManejoDTO plantillaActualizar = resultado.getUnidadManejoContenida();
//						plantillaActualizar.setValorUnidadManejo(valorUnidadManejo);
//						plantillaActualizar.setIdUsuarioModificacion(articuloUnidadManejoDTO.getUserId());
//						plantillaActualizar.setFechaModificacion(fechaRegistro);
//						dataGestor.update(plantillaActualizar);
//						return plantillaActualizar;
//					} else{//se crea el registro de la unidad de manejo para el pallet												
//						newArtUniMan = new ArticuloUnidadManejoDTO();
//						newArtUniMan.setId(new ArticuloUnidadManejoID());
//						newArtUniMan.getId().setCodigoArticulo(articuloUnidadManejoDTO.getId().getCodigoArticulo());
//						newArtUniMan.getId().setCodigoCompania(articuloUnidadManejoDTO.getId().getCodigoCompania());
//						newArtUniMan.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//						newArtUniMan.setValorUnidadManejo(valorUnidadManejo);
//						newArtUniMan.setIdUsuarioRegistro(articuloUnidadManejoDTO.getUserId());
//						newArtUniMan.setFechaRegistro(fechaRegistro);
//						newArtUniMan.setValorTipoUnidadEmpaque(tipoEmpaque.getId().getCodigoCatalogoValor());
//						newArtUniMan.setCodigoTipoUnidadEmpaque(tipoEmpaque.getId().getCodigoCatalogoTipo());
//						dataGestor.create(newArtUniMan);
//						resultado.setCodigoUnidadManejoContenida(newArtUniMan.getId().getCodigoUnidadManejo());
//						dataGestor.update(resultado);
//					}
//				}
//				
//			} else{
//				throw new SICException("Existen valores vacios para actualizar la unidad de manejo");
//			}
//			return newArtUniMan;
//		} catch(Exception e) {
//    		throw new SICException("No se pudo actualizar el valor de la unidad de manejo",e);
//    	}		
//	}
	

		//Metodo para BODEGA utilizado para actualizar el valor del contenedor PALLET para un articulo
		/*
		 * (non-Javadoc)
		 * @see ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor#actualizarCantidadMaximaUnidadManejo(ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO, ec.com.smx.corpv2.dto.CatalogoValorDTO, java.lang.Integer)
		 */
		@Override
		public ArticuloUnidadManejoDTO actualizarCantidadMaximaUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, CatalogoValorDTO tipoEmpaque, Integer valorUnidadManejo) throws SICException{
			try{
				ArticuloUnidadManejoDTO newArtUniMan = null;
				Timestamp fechaRegistro = new Timestamp(new Date().getTime());
				if(articuloUnidadManejoDTO!= null && articuloUnidadManejoDTO.getId() != null && tipoEmpaque != null && tipoEmpaque.getId() != null && articuloUnidadManejoDTO.getUserId() != null){
					
					//Buscar unidad manejo padre del tipo de contenedor especificado(PALLET)				
					ArticuloUnidadManejoDTO plantilla = new ArticuloUnidadManejoDTO();
					plantilla.getId().setCodigoArticulo(articuloUnidadManejoDTO.getId().getCodigoArticulo());
					plantilla.getId().setCodigoCompania(articuloUnidadManejoDTO.getId().getCodigoCompania());
					plantilla.setCodigoUnidadManejoContenida(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
					plantilla.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					plantilla.setValorTipoUnidadEmpaque(tipoEmpaque.getId().getCodigoCatalogoValor());
					plantilla.setCodigoTipoUnidadEmpaque(tipoEmpaque.getId().getCodigoCatalogoTipo());
					
					ArticuloUnidadManejoDTO resultado = dataGestor.findUnique(plantilla);
					
					if(resultado != null){//Se actualiza el valor del PALLET
						ArticuloUnidadManejoDTO plantillaActualizar = resultado;
						plantillaActualizar.setValorUnidadManejo(valorUnidadManejo);
						plantillaActualizar.setIdUsuarioModificacion(articuloUnidadManejoDTO.getUserId());
						plantillaActualizar.setFechaModificacion(fechaRegistro);
						dataGestor.update(plantillaActualizar);
						return plantillaActualizar;
					} else{//se crea el registro de la unidad de manejo para el pallet												
						newArtUniMan = new ArticuloUnidadManejoDTO();
						newArtUniMan.setId(new ArticuloUnidadManejoID());
						newArtUniMan.getId().setCodigoArticulo(articuloUnidadManejoDTO.getId().getCodigoArticulo());
						newArtUniMan.getId().setCodigoCompania(articuloUnidadManejoDTO.getId().getCodigoCompania());
						newArtUniMan.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						newArtUniMan.setValorUnidadManejo(valorUnidadManejo);
						newArtUniMan.setIdUsuarioRegistro(articuloUnidadManejoDTO.getUserId());
						newArtUniMan.setFechaRegistro(fechaRegistro);
						newArtUniMan.setValorTipoUnidadEmpaque(tipoEmpaque.getId().getCodigoCatalogoValor());
						newArtUniMan.setCodigoTipoUnidadEmpaque(tipoEmpaque.getId().getCodigoCatalogoTipo());
						newArtUniMan.setCodigoUnidadManejoContenida(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
						dataGestor.create(newArtUniMan);
					}
					
				} else{
					throw new SICException("Existen valores vacios para actualizar la unidad de manejo");
				}
				return newArtUniMan;
			} catch(Exception e) {
	    		throw new SICException("No se pudo actualizar el valor de la unidad de manejo",e);
	    	}		
	}
		
	/**
	 * @see ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor#actualizarCodigoBarrasArticuloUnidadManejo(ArticuloUnidadManejoDTO, String)
	 */
	@Override
	public void actualizarCodigoBarrasArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String codigoBarrasUnidadManejo) throws SICException {
		this.articuloUnidadManejoDAO.actualizarCodigoBarrasArticuloUnidadManejo(articuloUnidadManejoDTO, codigoBarrasUnidadManejo);
	}
	
	public void aumentarPrioridadUnidadManejo(Integer prioridad , Integer codigoCompania , String codigoArticulo) throws SICException{
		this.articuloUnidadManejoDAO.aumentarPrioridadUnidadManejo(prioridad, codigoCompania, codigoArticulo);
	}
	
	/**
	 * Metodo que inactiva las unidades de manejo por una prioridad especifica y puede omitir una unidad de manejo especifica.
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param prioridad
	 * @param codigoUnidadManejo codigo de unidad de manejo que se omite puede anularse este parametro
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	@Override
	public Integer inactivarUnidadManejoPorPrioridad(Integer codigoCompania, String codigoArticulo, Integer prioridad, String userId, Long... codigoUnidadManejo) throws SICException{
		return this.articuloUnidadManejoDAO.inactivarUnidadManejoPorPrioridad(codigoCompania, codigoArticulo, prioridad, userId, codigoUnidadManejo);
	}
	
	/**
	 * Metodo que permite asignar la máxima prioridad al codigo de unidad de manejo de prioridad 1000
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @param codigoUnidadManejo
	 * @return
	 * @throws SICException
	 */
	@Override
	public Integer asignarMaximaPrioridadUnidadManejo(Integer codigoCompania, String codigoArticulo, String userId, Long codigoUnidadManejo) throws SICException{
		return this.articuloUnidadManejoDAO.asignarMaximaPrioridadUnidadManejo(codigoCompania, codigoArticulo, userId, codigoUnidadManejo);
	}
	
	/**
	 * Metodo para obtener la prioridad disponible de las unidades de manejo de compra de un articulo
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer obtenerPrioridadDisponible(Integer codigoCompania, String codigoArticulo) throws SICException{
		Integer prioridadDisponible = null;
		
		if(codigoCompania == null){
			throw new SICException("No existe c\u00F3digo de compania.");
		}
		if(codigoArticulo == null){
			throw new SICException("No existe c\u00F3digo de art\u00EDculo.");
		}
		
		Collection<Integer> prioridades = this.articuloUnidadManejoDAO.obtenerPrioridadesUnidadManejo(codigoCompania, codigoArticulo);
		
		Collection<Integer> totalPrioridades = Arrays.asList(new Integer[]{1,2,3,4});
		
		if(CollectionUtils.isNotEmpty(prioridades)){			
			Collection<Integer> prioridadesDisponibles = CollectionUtils.subtract(totalPrioridades, prioridades);
			if(CollectionUtils.isNotEmpty(prioridadesDisponibles)){
				prioridadDisponible = prioridadesDisponibles.iterator().next();
			}else{
				throw new SICException("No existe una prioridad disponible para la unidad de manejo del art\u00EDculo.");
			}
		}else{
			prioridadDisponible = totalPrioridades.iterator().next();
		}
		
		return prioridadDisponible;
	}
	
	/**
	 * @param articuloUnidadManejoDAO the articuloUnidadManejoDAO to set
	 */
	public void setArticuloUnidadManejoDAO(IArticuloUnidadManejoDAO articuloUnidadManejoDAO) {
		this.articuloUnidadManejoDAO = articuloUnidadManejoDAO;
	}


	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}


	/**
	 * @param calculoUnidadManejoGestor the calculoUnidadManejoGestor to set
	 */
	public void setCalculoUnidadManejoGestor(ICalculoUnidadManejoGestor calculoUnidadManejoGestor) {
		this.calculoUnidadManejoGestor = calculoUnidadManejoGestor;
	}


	/**
	 * @param validacionUnidadManejoGestor the validacionUnidadManejoGestor to set
	 */
	public void setValidacionUnidadManejoGestor(IValidacionUnidadManejoGestor validacionUnidadManejoGestor) {
		this.validacionUnidadManejoGestor = validacionUnidadManejoGestor;
	}


	/**
	 * @param calculoArticuloGestor the calculoArticuloGestor to set
	 */
	public void setCalculoArticuloGestor(ICalculoArticuloGestor calculoArticuloGestor) {
		this.calculoArticuloGestor = calculoArticuloGestor;
	}
}
