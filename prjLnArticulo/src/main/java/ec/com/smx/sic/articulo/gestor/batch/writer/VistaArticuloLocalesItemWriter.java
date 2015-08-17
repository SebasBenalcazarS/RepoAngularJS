package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.encriptacion.util.CodificacionUtil;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloGrupoAlcanceDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaGrupoAlcanceLocalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.PrototipoArticuloTrasient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAlcanceDAO;

/**
 * Obtiene los datos que retorna el reader del cursor de articulo - locales
 * @author fcollaguazo
 *
 */
public class VistaArticuloLocalesItemWriter<T extends SearchDTO> implements ItemWriter<VistaArticuloGrupoAlcanceDTO>{

	private String  articuloVOString;
	private DataGestor dataGestor;
	private IArticuloAlcanceDAO articuloAlcanceDAO;
	
	@Override
	public void write(List<? extends VistaArticuloGrupoAlcanceDTO> vistaArticuloGrupoAlcanceCol) throws SICException {
		Logeable.LOG_SICV2.info("****************************---------------********************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando VistaArticuloLocalesItemWriter<T extends SearchDTO>");
		Logeable.LOG_SICV2.info("****************************---------------********************************");
		
		try {
			int  inArticulos = 1;//1000;
			ArticuloVO articuloVO = CodificacionUtil.getInstancia().decodificarStringAObjeto(articuloVOString, ArticuloVO.class);
			
			if(CollectionUtils.isNotEmpty(vistaArticuloGrupoAlcanceCol)){
				
				if(CollectionUtils.isEmpty(articuloVO.getVistaGrupoAlcanceLocalDTOs())){
					/**
					 * Se obtiene los prototipos de la vista vistaGrupoAlcanceLocalDTO
					 * para poder comparar si existe un prototipo y realizar el cambio de prototipo 
					 * al articulo
					 */
					VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO=new VistaGrupoAlcanceLocalDTO();
					Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs= dataGestor.findObjects(vistaGrupoAlcanceLocalDTO);
					
					articuloVO.setVistaGrupoAlcanceLocalDTOs(vistaGrupoAlcanceLocalDTOs);
				}
				
				Collection<PrototipoArticuloTrasient> prototipoArticuloTrasients=new ArrayList<PrototipoArticuloTrasient>();
				
				Logeable.LOG_SICV2.info("Total de articulos - locales {}",vistaArticuloGrupoAlcanceCol.size());
				/**Parametro que cuenta con los prototipos a validar*/
				ParametroDTO param = articuloAlcanceDAO.consultarPrototiposANoAsignar();
				
				for(VistaArticuloGrupoAlcanceDTO vaga:vistaArticuloGrupoAlcanceCol){
						final String areasTrabajo = vaga.getCodigosLocales(); 
						VistaGrupoAlcanceLocalDTO vGALDTO = (VistaGrupoAlcanceLocalDTO) CollectionUtils.find(articuloVO.getVistaGrupoAlcanceLocalDTOs(),new Predicate() {
							@Override
							public boolean evaluate(Object arg0) {
								return ((VistaGrupoAlcanceLocalDTO)arg0).getAreasTrabajo().equals(areasTrabajo);
							}
						});
						if(SearchDTO.isLoaded(vGALDTO)){
							Long codigoPrototipo = vGALDTO.getId().getCodigoGrupoTrabajo();
							/**permite la validacion de prototipos que tengan bodegas los cuales se deben ignorar al modificar CodigoGrupoTrabajo del articulo**/
							if(param != null && SearchDTO.isLoaded(param) && StringUtils.isNotBlank(param.getValorParametro())){
								Collection<String> codProtCol = new ArrayList<String>(Arrays.asList(param.getValorParametro().split(",")));
								for(String codigProt : codProtCol){
									if(StringUtils.isNotBlank(codigProt) && vGALDTO.getId().getCodigoGrupoTrabajo().toString().equals(codigProt)){
										codigoPrototipo = SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO;
									}
								}
							}
							
							comprobarPrototipo(codigoPrototipo, prototipoArticuloTrasients, vaga.getCodigoArticulo(), inArticulos);
							
						}else{	
							comprobarPrototipo(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO, prototipoArticuloTrasients, vaga.getCodigoArticulo(), inArticulos);
						}
				}
				Logeable.LOG_SICV2.info("antes del articuloAlcanceDAO.actualizarPrototipoArticulo( -------------->------------>");
				articuloAlcanceDAO.actualizarPrototipoArticulo(prototipoArticuloTrasients, articuloVO.getFechaAplicacion(),articuloVO.getUserId(),articuloVO.getCodigofuncionario(),articuloVO.getOpcionTipoAsignacionAlcance(),articuloVO.getCodigoCompania());
			}
			Logeable.LOG_SICV2.info("fin write -------------->------------>");
			
		} catch (SICException e) {
			// TODO: handle exception
			throw new SICException("Error en ArticuloAlcanceItemWriter {}", e);
		}
	}
	
	/**
	 * Se comprueba en que prototipo coincide el articulo para actualizarlo
	 * @param codigoGT
	 * @param prototipoArticuloTrasients
	 * @param codigoArticulo
	 * @param inArt
	 */
	private void comprobarPrototipo(Long codigoGT,Collection<PrototipoArticuloTrasient> prototipoArticuloTrasients,String codigoArticulo,int inArt){
		final Long codigoGrupoTrabajo=codigoGT;
		final int inArticulos=inArt;
		
		PrototipoArticuloTrasient pr=(PrototipoArticuloTrasient)CollectionUtils.find(prototipoArticuloTrasients,new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return ((PrototipoArticuloTrasient)arg0).getCodigoGrupoAlcance().equals(codigoGrupoTrabajo)&& ((PrototipoArticuloTrasient)arg0).getArticulos().size()< inArticulos;
			}
		});
		
		if(SearchDTO.isLoaded(pr)){
			if(StringUtils.isNotEmpty(codigoArticulo)){
				pr.setCadenaArticulos(pr.getCadenaArticulos()+",'"+codigoArticulo+"'");
				pr.getArticulos().add(",'"+codigoArticulo+"'");
			}
		}else{				
			if(StringUtils.isNotEmpty(codigoArticulo)){
				PrototipoArticuloTrasient p=new PrototipoArticuloTrasient();
				p.setCodigoGrupoAlcance(codigoGrupoTrabajo);
				p.setCadenaArticulos("'"+codigoArticulo+"'");
				p.setArticulos(new ArrayList<String>());
				p.getArticulos().add(",'"+codigoArticulo+"'");
				
				prototipoArticuloTrasients.add(p);
			}	
		}	
	}


	/**
	 * @param articuloVOString the articuloVOString to set
	 */
	public void setArticuloVOString(String articuloVOString) {
		this.articuloVOString = articuloVOString;
	}

	/**
	 * @return the articuloAlcanceDAO
	 */
	public IArticuloAlcanceDAO getArticuloAlcanceDAO() {
		return articuloAlcanceDAO;
	}

	/**
	 * @param articuloAlcanceDAO the articuloAlcanceDAO to set
	 */
	public void setArticuloAlcanceDAO(IArticuloAlcanceDAO articuloAlcanceDAO) {
		this.articuloAlcanceDAO = articuloAlcanceDAO;
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
}