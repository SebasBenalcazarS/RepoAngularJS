/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.calculo;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.articulo.persistence.dao.ArticuloAgrupadorDAO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloLeyenda;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLeyendaDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author fmunoz
 *
 */
public class CalculoArticuloLeyenda implements ICalculoArticuloLeyenda {

	private DataGestor dataGestor;
	private ArticuloAgrupadorDAO articuloAgrupadorDAO;
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.admin.calculo.ICalculoArticuloCupon#guardarArticuloLeyenda(ec.com.smx.sic.cliente.mdl.vo.ArticuloVO)
	 */
	@Override
	public void guardarArticuloLeyenda(ArticuloVO articuloVO)throws SICException{
		try{
			//se verifica si el articulo tiene la caracteristica PAPEL/VIRTUAL
			Boolean registrarLeyenda = articuloAgrupadorDAO.existeCaracteristicaArticulo(articuloVO.getBaseDTO(), TipoCatalogoArticulo.AGRUPADOR_NATURALEZA, 
					TipoCatalogoArticulo.VALOR_NATURALEZA_VIRTUAL);
			
			
	
			if(registrarLeyenda && SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloLeyendaCol())){
				ArticuloLeyendaDTO leyendaActual = null;
				ArticuloLeyendaDTO leyendaAnterior = null;
				for(ArticuloLeyendaDTO al : articuloVO.getBaseDTO().getArticuloLeyendaCol()){
					if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(al.getEstado())){
						leyendaActual = al;
						break;
					}
				}
				//se obtiene la leyenda del articulo actual
				
				ArticuloLeyendaDTO leyendaFiltro = new ArticuloLeyendaDTO();
				leyendaFiltro.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				leyendaFiltro.setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				leyendaFiltro.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				leyendaFiltro.setOrderByField(OrderBy.orderDesc("fechaRegistro"));
				Collection<ArticuloLeyendaDTO> leyendas = dataGestor.findObjects(leyendaFiltro);
				leyendaFiltro = null;
				
				if(!CollectionUtils.isEmpty(leyendas)){
					leyendaAnterior = leyendas.iterator().next();
				}
				if(leyendaActual != null){
					leyendaActual.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					leyendaActual.setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					leyendaActual.setUserId(articuloVO.getBaseDTO().getUserId());
					if(articuloVO.getBaseDTO().getTieneArticuloTemporada()){
						leyendaActual.setFechaInicioVigencia(articuloVO.getBaseDTO().getArticuloTemporadaDTO().getFechaInicioTemporada());
						leyendaActual.setFechaFinVigencia(articuloVO.getBaseDTO().getArticuloTemporadaDTO().getFechaFinTemporada());
					}
					asignarCamposLeyenda(articuloVO, leyendaActual);
					if(leyendaActual.getId().getSecuencial() == null && leyendaAnterior == null){
						leyendaActual.addDynamicProperty(SICConstantes.EVENTO_INSERTAR, Boolean.TRUE);
						dataGestor.create(leyendaActual);
					}else if(existenDiferenciasEnLeyendaActual(leyendaActual, leyendaAnterior)){
						leyendaActual.getId().setSecuencial(null);
						dataGestor.create(leyendaActual);
						leyendaAnterior.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
						leyendaAnterior.setUserId(articuloVO.getBaseDTO().getUserId());
						dataGestor.update(leyendaAnterior);
					}else{
						if(leyendaAnterior != null){
							dataGestor.update(leyendaAnterior);
						}else{
							dataGestor.update(leyendaActual);
						}
					}
				}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.leyenda"),e);
		}
	}

	private void asignarCamposLeyenda(ArticuloVO articuloVO, ArticuloLeyendaDTO articuloLeyendaDTO){
		if(StringUtils.isEmpty(articuloLeyendaDTO.getEstado())){
			articuloLeyendaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
		if(StringUtils.isEmpty(articuloLeyendaDTO.getDescripcionArticulo())){
			articuloLeyendaDTO.setDescripcionArticulo(articuloVO.getBaseDTO().getDescripcionArticulo());
		}
		if(StringUtils.isEmpty(articuloLeyendaDTO.getCodigoBarras())){
			articuloLeyendaDTO.setCodigoBarras(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras());
		}
		if(articuloLeyendaDTO.getPrecionormal() == null){
			articuloLeyendaDTO.setPrecionormal(0.01d);
		}
		
		final Boolean tieneTipoControCosto = validarCuponEsPesoVariable(articuloVO);
		
		if( tieneTipoControCosto ){
			articuloLeyendaDTO.setLeyendaPrecioFinal(SICArticuloConstantes.getInstancia().LEYENDA_CADA_KILO);
			articuloLeyendaDTO.setPreciofinal(NumberUtils.DOUBLE_ZERO);
		}
		
	}
	
	/**
	 * Valida si el cupon creado es de Peso variable para asignarle valores distintos en la leyenda
	 * @return
	 */
	public Boolean validarCuponEsPesoVariable(ArticuloVO articuloVO){
		
		Boolean esPesoVariable = Boolean.FALSE;
		
		final Boolean tieneArticuloComercial = tieneArticuloComercial(articuloVO);
		
		final Boolean esPiezaPeso =  tieneArticuloComercial && articuloVO.getBaseDTO().getArticuloRelacionCol().iterator().next().getArticuloRelacion().getArticuloComercialDTO().getValorTipoControlCosto().equalsIgnoreCase(SICArticuloConstantes.getInstancia().TIPCONCOS_PESPES);
		final Boolean esPesoPeso = tieneArticuloComercial && articuloVO.getBaseDTO().getArticuloRelacionCol().iterator().next().getArticuloRelacion().getArticuloComercialDTO().getValorTipoControlCosto().equalsIgnoreCase(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPES);;
		final Boolean esPiezaPesoUniman = tieneArticuloComercial && articuloVO.getBaseDTO().getArticuloRelacionCol().iterator().next().getArticuloRelacion().getArticuloComercialDTO().getValorTipoControlCosto().equalsIgnoreCase(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPESUM);
		
		if( esPiezaPeso || esPesoPeso || esPiezaPesoUniman ){
			esPesoVariable =  Boolean.TRUE;
		}
		
		return esPesoVariable;
		
	}
	
	private Boolean tieneArticuloComercial(ArticuloVO articuloVO){
		return articuloVO.getBaseDTO().getTieneArticuloRelacionado() && articuloVO.getBaseDTO().getArticuloRelacionCol().iterator().next().getTieneArticuloRelacion() && articuloVO.getBaseDTO().getArticuloRelacionCol().iterator().next().getArticuloRelacion().getTieneArticuloComercial();
	}
	
	private Boolean existenDiferenciasEnLeyendaActual(ArticuloLeyendaDTO articuloLeyendaActual, ArticuloLeyendaDTO articuloLeyendaAnterior){
		if(articuloLeyendaActual != null &&  articuloLeyendaAnterior != null && (!StringUtils.equals(articuloLeyendaActual.getDescripcionArticulo(), articuloLeyendaAnterior.getDescripcionArticulo())
				|| !StringUtils.equals(articuloLeyendaActual.getTerminosCondiciones(), articuloLeyendaAnterior.getTerminosCondiciones())
				|| !StringUtils.equals(articuloLeyendaActual.getLeyendaDescuento(), articuloLeyendaAnterior.getLeyendaDescuento())
				|| !StringUtils.equals(articuloLeyendaActual.getLeyendaVigencia(), articuloLeyendaAnterior.getLeyendaVigencia())
				
				|| (articuloLeyendaActual.getValorDescuento() != null && articuloLeyendaAnterior.getValorDescuento() == null)
				|| (articuloLeyendaActual.getValorDescuento() == null && articuloLeyendaAnterior.getValorDescuento() != null)				
				|| ((articuloLeyendaActual.getValorDescuento() != null && articuloLeyendaAnterior.getValorDescuento() != null) && (articuloLeyendaActual.getValorDescuento().compareTo(articuloLeyendaAnterior.getValorDescuento()) != 0))
				
				|| (articuloLeyendaActual.getPorcentajeDescuento() != null && articuloLeyendaAnterior.getPorcentajeDescuento() == null)
				|| (articuloLeyendaActual.getPorcentajeDescuento() == null && articuloLeyendaAnterior.getPorcentajeDescuento() != null)
				|| ((articuloLeyendaActual.getPorcentajeDescuento() != null && articuloLeyendaAnterior.getPorcentajeDescuento() != null) && (articuloLeyendaActual.getPorcentajeDescuento().compareTo(articuloLeyendaAnterior.getPorcentajeDescuento()) != 0))
				
				|| (articuloLeyendaActual.getPreciofinal() != null && articuloLeyendaAnterior.getPreciofinal() == null)
				|| (articuloLeyendaActual.getPreciofinal() == null && articuloLeyendaAnterior.getPreciofinal() != null)
				|| ((articuloLeyendaActual.getPreciofinal() != null && articuloLeyendaAnterior.getPreciofinal() != null) && (articuloLeyendaActual.getPreciofinal().compareTo(articuloLeyendaAnterior.getPreciofinal()) !=0))
				
				|| (articuloLeyendaActual.getFechaInicioVigencia() != null && articuloLeyendaAnterior.getFechaInicioVigencia() != null && articuloLeyendaActual.getFechaFinVigencia() != null && articuloLeyendaAnterior.getFechaFinVigencia() != null
				 	&& (!DateUtils.isSameInstant(articuloLeyendaActual.getFechaInicioVigencia(), articuloLeyendaAnterior.getFechaInicioVigencia()) || !DateUtils.isSameInstant(articuloLeyendaActual.getFechaFinVigencia(), articuloLeyendaAnterior.getFechaFinVigencia()))))
		){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setArticuloAgrupadorDAO(ArticuloAgrupadorDAO articuloAgrupadorDAO) {
		this.articuloAgrupadorDAO = articuloAgrupadorDAO;
	}
}
