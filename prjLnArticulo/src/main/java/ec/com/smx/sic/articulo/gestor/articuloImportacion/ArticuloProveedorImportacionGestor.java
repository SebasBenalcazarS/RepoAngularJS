package ec.com.smx.sic.articulo.gestor.articuloImportacion;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.articuloImportacion.IArticuloProveedorImportacionGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionHistoricoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.proveedorimportacion.IArticuloProveedorImportacionDAO;

public class ArticuloProveedorImportacionGestor implements IArticuloProveedorImportacionGestor, Logeable {
	
	private DataGestor dataGestor;
	
	private IArticuloProveedorImportacionDAO articuloProveedorImportacionDAO; 

	public void registrarArticuloImportacion(ArticuloProveedorDTO articuloProveedorDTO, Boolean esCreacion) throws SICException{
		articuloProveedorDTO.getArticuloImportacion().getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
		articuloProveedorDTO.getArticuloImportacion().getId().setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
		articuloProveedorDTO.getArticuloImportacion().getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
		articuloProveedorDTO.getArticuloImportacion().setUserId(articuloProveedorDTO.getUserId());
		this.registrarArticuloImportacion(articuloProveedorDTO.getArticuloImportacion(), esCreacion, articuloProveedorDTO.getArticulo().getDescripcionArticulo());
	}
	
	public void registrarArticuloImportacion(ArticuloImportacionDTO articuloImportacionDTO, Boolean esCreacion, String descripcionArticulo) throws SICException{
		if(articuloImportacionDTO.getUserId() == null){
			throw new SICException("No existe identificador de usuario para campos de auditoria");
		}
		if(articuloImportacionDTO.getDescripcionArticulo() == null && descripcionArticulo != null){
			articuloImportacionDTO.setDescripcionArticulo(descripcionArticulo);
		}else if (articuloImportacionDTO.getDescripcionArticulo() == null){
			throw new SICException("Descripci\u00F3n importaci\u00F3n no v\u00E1lido.");
		}
		if(articuloImportacionDTO.getCodigoMonedaOrigen() == null){
			articuloImportacionDTO.setCodigoMonedaOrigen(SICArticuloConstantes.getInstancia().VALOR_MONEDA_DOLAR);
		}
		if(articuloImportacionDTO.getCostoMonedaOrigen() == null){
			throw new SICException("Costo moneda origen no v\u00E1lido.");
		}
		if(esCreacion){
			dataGestor.create(articuloImportacionDTO);
		}else{
			this.verificarArticuloImportacionHistorico(articuloImportacionDTO, Boolean.FALSE);
			dataGestor.createOrUpdate(articuloImportacionDTO);
		}
	}
	
	public void registrarArticuloImportacionJuguetes(ArticuloImportacionDTO articuloImportacionDTO, String descripcionArticulo) throws SICException{
		if(articuloImportacionDTO.getUserId() == null){
			throw new SICException("No existe identificador de usuario para campos de auditoria");
		}
		if(articuloImportacionDTO.getDescripcionArticulo() == null && descripcionArticulo != null){
			articuloImportacionDTO.setDescripcionArticulo(descripcionArticulo);
		}else if (articuloImportacionDTO.getDescripcionArticulo() == null){
			throw new SICException("Descripci\u00F3n importaci\u00F3n no v\u00E1lido.");
		}
		if(articuloImportacionDTO.getCodigoMonedaOrigen() == null){
			articuloImportacionDTO.setCodigoMonedaOrigen(SICArticuloConstantes.getInstancia().VALOR_MONEDA_DOLAR);
		}
		if(articuloImportacionDTO.getCostoMonedaOrigen() == null){
			throw new SICException("Costo moneda origen no v\u00E1lido.");
		}
		
		Long count = this.articuloProveedorImportacionDAO.contarArticuloImportado(articuloImportacionDTO.getId().getCodigoCompania(), articuloImportacionDTO.getId().getCodigoArticulo(), articuloImportacionDTO.getId().getCodigoProveedor());
		
		if(count > 0){
			this.verificarArticuloImportacionHistorico(articuloImportacionDTO, Boolean.FALSE);
			this.articuloProveedorImportacionDAO.actualizarArticuloImportacion(articuloImportacionDTO.getId().getCodigoCompania(), articuloImportacionDTO.getId().getCodigoArticulo(), articuloImportacionDTO.getId().getCodigoProveedor(), articuloImportacionDTO.getCostoMonedaOrigen(), articuloImportacionDTO.getPorcentajeComision(), articuloImportacionDTO.getUserId());
		}else{
			this.dataGestor.create(articuloImportacionDTO);
		}
	}
	
	@Override
	public void verificarArticuloImportacionHistorico(ArticuloImportacionDTO articuloImportacionDTO, Boolean esEdicionMasiva) throws SICException{
		try{
			ArticuloImportacionDTO articuloImportacionHis = new ArticuloImportacionDTO();
			articuloImportacionHis.getId().setCodigoCompania(articuloImportacionDTO.getId().getCodigoCompania());
			articuloImportacionHis.getId().setCodigoArticulo(articuloImportacionDTO.getId().getCodigoArticulo());
			articuloImportacionHis.getId().setCodigoProveedor(articuloImportacionDTO.getId().getCodigoProveedor());
			articuloImportacionHis = dataGestor.findUnique(articuloImportacionHis);
			if(BooleanUtils.isNotTrue(esEdicionMasiva)){
				if(articuloImportacionHis != null && (existenCambiosBasico(articuloImportacionDTO, articuloImportacionHis) || existenCambiosAvanzado(articuloImportacionDTO, articuloImportacionHis))){
					this.registrarArticuloImportacionHistorico(articuloImportacionHis);
				}
			}else{
				if(articuloImportacionHis != null && existenCambiosBasico(articuloImportacionDTO, articuloImportacionHis)){
					this.registrarArticuloImportacionHistorico(articuloImportacionHis);
				}
			}
		}catch(Exception exception){
			LOG_SICV2.error("Ha ocurrido un error al registrar historico: " + exception.getMessage());
			throw new SICException("Ha ocurrido un error al registrar el historico.", exception);
		}
	}
	
	private void registrarArticuloImportacionHistorico(ArticuloImportacionDTO articuloImportacionDTO) throws SICException{
		try{
			ArticuloImportacionHistoricoDTO articuloImportacionHistoricoDTO = new ArticuloImportacionHistoricoDTO();
			articuloImportacionHistoricoDTO.getId().setCodigoCompania(articuloImportacionDTO.getId().getCodigoCompania());
			articuloImportacionHistoricoDTO.setCodigoArticulo(articuloImportacionDTO.getId().getCodigoArticulo());
			articuloImportacionHistoricoDTO.setCodigoProveedor(articuloImportacionDTO.getId().getCodigoProveedor());
			articuloImportacionHistoricoDTO.setCostoMonedaOrigen(articuloImportacionDTO.getCostoMonedaOrigen());
			articuloImportacionHistoricoDTO.setCodigoMonedaOrigen(articuloImportacionDTO.getCodigoMonedaOrigen());			
			articuloImportacionHistoricoDTO.setDescripcionArticulo(articuloImportacionDTO.getDescripcionArticulo());
			articuloImportacionHistoricoDTO.setPorcentajeComision(articuloImportacionDTO.getPorcentajeComision());
			articuloImportacionHistoricoDTO.setValorFactor(articuloImportacionDTO.getValorFactor());
			articuloImportacionHistoricoDTO.setFechaAplicacionFactor(articuloImportacionDTO.getFechaAplicacionFactor());
			articuloImportacionHistoricoDTO.setIdUsuarioRegistro(articuloImportacionDTO.getIdUsuarioRegistro());
			articuloImportacionHistoricoDTO.setFechaRegistro(articuloImportacionDTO.getFechaRegistro());
			articuloImportacionHistoricoDTO.setIdUsuarioModificacion(articuloImportacionDTO.getIdUsuarioModificacion());
			articuloImportacionHistoricoDTO.setFechaModificacion(articuloImportacionDTO.getFechaModificacion());
			articuloImportacionHistoricoDTO.setFechaRevision(new Date());
			
			dataGestor.create(articuloImportacionHistoricoDTO);
		}catch(Exception exception){
			LOG_SICV2.error("Ha ocurrido un error al registrar historico: " + exception.getMessage());
			throw new SICException("Ha ocurrido un error al registrar el historico.", exception);
		}
	}
	
	
	private Boolean existenCambiosBasico(ArticuloImportacionDTO articuloImportacionDTO, ArticuloImportacionDTO articuloImportacion){
		Boolean existeCambios = Boolean.FALSE;
		if(articuloImportacionDTO != null && articuloImportacion != null
				&& articuloImportacionDTO.getId().getCodigoCompania().compareTo(articuloImportacion.getId().getCodigoCompania()) != 0
				|| !StringUtils.equals(articuloImportacionDTO.getId().getCodigoArticulo(), articuloImportacion.getId().getCodigoArticulo())
				|| !StringUtils.equals(articuloImportacionDTO.getId().getCodigoProveedor(), articuloImportacion.getId().getCodigoProveedor())
				|| (articuloImportacionDTO.getCostoMonedaOrigen() != null && articuloImportacion.getCostoMonedaOrigen() != null && articuloImportacionDTO.getCostoMonedaOrigen().compareTo(articuloImportacion.getCostoMonedaOrigen()) != 0)
				|| (articuloImportacionDTO.getCodigoMonedaOrigen() != null && articuloImportacionDTO.getCodigoMonedaOrigen().compareTo(articuloImportacion.getCodigoMonedaOrigen()) != 0)
				
				|| (articuloImportacionDTO.getPorcentajeComision() != null && articuloImportacion.getPorcentajeComision() == null)
				|| (articuloImportacionDTO.getPorcentajeComision() == null && articuloImportacion.getPorcentajeComision() != null)
				|| (articuloImportacionDTO.getPorcentajeComision() != null && articuloImportacion.getPorcentajeComision() != null && articuloImportacionDTO.getPorcentajeComision().compareTo(articuloImportacion.getPorcentajeComision()) != 0)
				
		){
			existeCambios = Boolean.TRUE;
		}
		return existeCambios;
	}
	
	private Boolean existenCambiosAvanzado(ArticuloImportacionDTO articuloImportacionDTO, ArticuloImportacionDTO articuloImportacion){
		Boolean existeCambios = Boolean.FALSE;
		if(articuloImportacionDTO != null && articuloImportacion != null
				&&  (articuloImportacionDTO.getDescripcionArticulo() != null && !StringUtils.equals(articuloImportacionDTO.getDescripcionArticulo(), articuloImportacion.getDescripcionArticulo())) 
				
				|| (articuloImportacionDTO.getValorFactor() != null && articuloImportacion.getValorFactor() == null)
				|| (articuloImportacionDTO.getValorFactor() == null && articuloImportacion.getValorFactor() != null)
				|| (articuloImportacionDTO.getValorFactor() != null && articuloImportacion.getValorFactor() != null && articuloImportacionDTO.getValorFactor().compareTo(articuloImportacion.getValorFactor()) != 0)
				
				|| (articuloImportacionDTO.getFechaAplicacionFactor() != null && articuloImportacion.getFechaAplicacionFactor() == null)
				|| (articuloImportacionDTO.getFechaAplicacionFactor() == null && articuloImportacion.getFechaAplicacionFactor() != null)
				|| (articuloImportacionDTO.getFechaAplicacionFactor() != null && articuloImportacion.getFechaAplicacionFactor() != null && !DateUtils.isSameInstant(articuloImportacionDTO.getFechaAplicacionFactor(),articuloImportacion.getFechaAplicacionFactor()))
		){
			existeCambios = Boolean.TRUE;
		}
		return existeCambios;
	}
	
	@SuppressWarnings("unchecked")
	public void registrarArticuloImportacion(Collection<ArticuloImportacionDTO> articuloImportacionCol, String descripcionArticulo) throws SICException{
		if(CollectionUtils.isNotEmpty(articuloImportacionCol)){
			articuloImportacionCol = ColeccionesUtil.sort(articuloImportacionCol, ColeccionesUtil.ORDEN_ASC, "costoMonedaOrigen");
			ArticuloImportacionDTO articuloImportacionDTO = articuloImportacionCol.iterator().next();
			this.registrarArticuloImportacionJuguetes(articuloImportacionDTO, descripcionArticulo);
			articuloImportacionCol.remove(articuloImportacionDTO);
			for(ArticuloImportacionDTO importacionDTO : articuloImportacionCol){
				ArticuloImportacionHistoricoDTO articuloImportacionHistoricoDTO = new ArticuloImportacionHistoricoDTO();
				articuloImportacionHistoricoDTO.getId().setCodigoCompania(importacionDTO.getId().getCodigoCompania());
				articuloImportacionHistoricoDTO.setCodigoArticulo(importacionDTO.getId().getCodigoArticulo());
				articuloImportacionHistoricoDTO.setCodigoProveedor(importacionDTO.getId().getCodigoProveedor());
				articuloImportacionHistoricoDTO.setCostoMonedaOrigen(importacionDTO.getCostoMonedaOrigen());
				articuloImportacionHistoricoDTO.setCodigoMonedaOrigen(importacionDTO.getCodigoMonedaOrigen());			
				articuloImportacionHistoricoDTO.setDescripcionArticulo(importacionDTO.getDescripcionArticulo());
				articuloImportacionHistoricoDTO.setFechaRevision(new Date());
				articuloImportacionHistoricoDTO.setUserId(importacionDTO.getUserId());
				dataGestor.create(articuloImportacionHistoricoDTO);
			}
		}
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setArticuloProveedorImportacionDAO(IArticuloProveedorImportacionDAO articuloProveedorImportacionDAO) {
		this.articuloProveedorImportacionDAO = articuloProveedorImportacionDAO;
	}
}
