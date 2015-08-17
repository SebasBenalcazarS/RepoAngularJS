/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.calculo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloLocalGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloLocalDAO;

/**
 * @author fmunoz
 *
 */
public class CalculoArticuloLocalGestor implements ICalculoArticuloLocalGestor {

	private IArticuloLocalDAO articuloLocalDAO;
	private DataGestor dataGestor;
	/**
	 * 
	 * @param registros
	 * @param registrosActuales
	 * @throws SICException
	 */
	@Override
	public void registrarArticuloLocalCupon(ArticuloDTO articuloDTO, Collection<ArticuloLocalDTO> registrosRecibidos, Collection<ArticuloLocalDTO> registrosActuales)throws SICException{
		Collection<Integer> registrosActualizables = new ArrayList<Integer>();
		Collection<ArticuloLocalDTO> registrosInsertables = new ArrayList<ArticuloLocalDTO>();
		for(final ArticuloLocalDTO al : registrosRecibidos){
			ArticuloLocalDTO finded = (ArticuloLocalDTO)CollectionUtils.find(registrosActuales, new Predicate() {
				@Override
				public boolean evaluate(Object reg) {
					return ((ArticuloLocalDTO)reg).getId().getCodigoLocal().intValue() == al.getId().getCodigoLocal().intValue();
				}
			});
			if(finded != null){
				registrosActualizables.add(finded.getId().getCodigoLocal());
			}else{
				registrosInsertables.add(al);
			}
		}
		//se actualizan los registros
		if(!registrosActualizables.isEmpty()){
			articuloLocalDAO.actualizarEstadoPorArticulo(articuloDTO.getId().getCodigoCompania(), articuloDTO.getId().getCodigoArticulo(), 
				SICConstantes.ESTADO_ACTIVO_NUMERICO, articuloDTO.getUserId(), registrosActualizables);}
		//se insertan los registros
		for(ArticuloLocalDTO al : registrosInsertables){
			al.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			al.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
			al.setUserId(articuloDTO.getUserId());
			asignarCamposArticuloLocal(al);
			dataGestor.create(al);
		}
	}
	
	
	/**
	 * 
	 * @param articuloLocalDTO
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposArticuloLocal(ArticuloLocalDTO articuloLocalDTO)throws SICRuleException{
		if(StringUtils.isEmpty(articuloLocalDTO.getEstadoArticuloLocal())){
			articuloLocalDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
		if(articuloLocalDTO.getFechaInicialAlcance() == null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			articuloLocalDTO.setFechaInicialAlcance(cal.getTime());
		}
		if(articuloLocalDTO.getFechaFinalAlcance() == null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(articuloLocalDTO.getFechaInicialAlcance());
			cal.add(Calendar.YEAR, SICArticuloConstantes.ANIOS_AGREGADOS_FECHAFINALALCANCE);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			articuloLocalDTO.setFechaFinalAlcance(cal.getTime());
		}
		if(StringUtils.isEmpty(articuloLocalDTO.getEstadoCodigoReferencia())){
			articuloLocalDTO.setEstadoCodigoReferencia(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
	}
	
	/**
	 * @param articuloLocalDAO the articuloLocalDAO to set
	 */
	public void setArticuloLocalDAO(IArticuloLocalDAO articuloLocalDAO) {
		this.articuloLocalDAO = articuloLocalDAO;
	}
	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
}
