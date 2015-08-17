package ec.com.smx.sic.articulo.gestor.auditoria.almacenamiento;

import java.util.Collection;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.hibernate.envers.exception.AuditException;
import org.hibernate.proxy.HibernateProxy;

import ec.com.smx.frameworkv2.auditoria.common.util.AuditStructure;
import ec.com.smx.frameworkv2.auditoria.gestor.AuditoriaGestor;
import ec.com.smx.frameworkv2.auditoria.gestor.IAuditoriaGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.auditoria.almacenamiento.IAlmacenamientoAuditoriaArticuloGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoCaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.resources.SICMessages;

public class AlmacenamientoAuditoriaArticuloGestor implements IAlmacenamientoAuditoriaArticuloGestor {
	
	private IAuditoriaGestor auditoriaGestor;
	private AuditoriaGestor auditoriaGestorDirecto;
	private ICalculoArticuloGestor calculoArticuloGestor;

	@Override
	public Boolean registrarLogAuditoriaArticulo(ArticuloVO articuloDTOAuditable, String definicionID, String sysID, String accesItemID) throws SICException, AuditException, ec.com.smx.frameworkv2.auditoria.excepcion.AuditException{
		Boolean huboCambios = Boolean.FALSE;
		
		try {
			AuditStructure objetoActual = this.auditoriaGestor.obtenerObjetoAuditable(articuloDTOAuditable.getBaseDTO().getId().getCodigoCompania(), sysID, accesItemID, definicionID, articuloDTOAuditable.getBaseDTO());
			
			AuditStructure objetoAnterior = this.auditoriaGestor.obtenerObjetoAuditable(articuloDTOAuditable.getBaseDTO().getId().getCodigoCompania(), sysID, accesItemID, definicionID, articuloDTOAuditable.getBaseDTOAnterior());
			
			try {
				huboCambios = this.auditoriaGestor.registrarLogAuditoria(articuloDTOAuditable.getBaseDTO().getId().getCodigoCompania(),articuloDTOAuditable.getDynamicProperty("codigoTipoAuditoria", Integer.class)+definicionID+sysID, articuloDTOAuditable.getDynamicProperty("codigoTipoAuditoria", Integer.class), definicionID,objetoActual, 
						objetoAnterior, articuloDTOAuditable.getUserId(), Boolean.TRUE);
			} catch (ec.com.smx.frameworkv2.auditoria.excepcion.AuditException e) {
				// TODO Auto-generated catch block
				throw new AuditException("Ocurri\u00F3 un error al momento de guardar la auditoria del articulo");
			}
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.error("Ocurri\u00F3 un error al momento de guardar la auditoria {}",e.getMessage());
			throw new SICException(e.getMessage());
		} 
		return huboCambios;
	}

	// registra la auditoria de los campos en la edicion del articulo
	@SuppressWarnings("deprecation")
	@Override
	public void registrarLogAuditoriaArticulo(ArticuloVO articulo) throws SICException {

		try{
			AuditStructure objetoOriginal= null;
			AuditStructure objetoActual = null;

			if (articulo.getBaseDTOAnterior() !=null){
				
				//registro de auditoria para historial de cambios
				objetoActual = this.auditoriaGestor.obtenerObjetoAuditable(articulo.getBaseDTO().getId().getCodigoCompania(),
						SICMessages.getInstancia().getString("ec.com.smx.codigo.sistema.sic"), 
						articulo.getAccessItemId(), 
						SICArticuloConstantes.IDENTIFICADOR_AUDITORIA_REG, 
						obtenerArticuloDTO(articulo.getBaseDTO()));
				
				objetoOriginal = this.auditoriaGestor.obtenerObjetoAuditable(
						articulo.getBaseDTO().getId().getCodigoCompania(),
						SICMessages.getInstancia().getString("ec.com.smx.codigo.sistema.sic"),
						articulo.getAccessItemId(),
						SICArticuloConstantes.IDENTIFICADOR_AUDITORIA_REG,
						obtenerArticuloDTO(articulo.getBaseDTOAnterior()));
				
				this.auditoriaGestor.registrarLogAuditoria(
						articulo.getBaseDTO().getId().getCodigoCompania(), 
						this.getCalculoArticuloGestor().obtenerIdLogAuditoriaArticulo(articulo.getBaseDTO().getId().getCodigoCompania(), articulo.getBaseDTO().getId().getCodigoArticulo()),
						SICArticuloConstantes.TIPOLOG_AUDITORIAARTICULO, 
						null,
						objetoActual, 
						objetoOriginal, 
						articulo.getUserId(),
						Boolean.TRUE);
				
				//registro de auditoria para notificaciones
				objetoActual = this.auditoriaGestor.obtenerObjetoAuditable(articulo.getBaseDTO().getId().getCodigoCompania(),
						SICMessages.getInstancia().getString("ec.com.smx.codigo.sistema.sic"), 
						articulo.getAccessItemId(), 
						SICArticuloConstantes.IDENTIFICADOR_AUDITORIA_NOT, 
						obtenerArticuloDTO(articulo.getBaseDTO()));
				
				objetoOriginal = this.auditoriaGestor.obtenerObjetoAuditable(
						articulo.getBaseDTO().getId().getCodigoCompania(),
						SICMessages.getInstancia().getString("ec.com.smx.codigo.sistema.sic"),
						articulo.getAccessItemId(),
						SICArticuloConstantes.IDENTIFICADOR_AUDITORIA_NOT,
						obtenerArticuloDTO(articulo.getBaseDTOAnterior()));
				
				this.auditoriaGestor.registrarLogAuditoria(
						articulo.getBaseDTO().getId().getCodigoCompania(), 
						this.getCalculoArticuloGestor().obtenerIdLogAuditoriaNotificacionArticulo(articulo.getBaseDTO().getId().getCodigoCompania(), 
								articulo.getBaseDTO().getId().getCodigoArticulo()), 
						SICArticuloConstantes.TIPOLOG_AUDITORIA_NOTIFICACION, 
						null,
						objetoActual, 
						objetoOriginal,
						articulo.getUserId(),
						Boolean.TRUE);
			}
			
		}catch (AuditException e) {
			throw new SICException(e);
		} catch (ec.com.smx.frameworkv2.auditoria.excepcion.AuditException e) {
			// TODO Auto-generated catch block
			throw new SICException(e);
		}
	}
	
	/**
	 * Obtiene del ArticuloDTO con los cambios necesarios para realizar la auditor&#237;a
	 * de historial de cambios  
	 * @param ArticuloDTO
	 */
	@SuppressWarnings("unchecked")
	private ArticuloDTO obtenerArticuloDTO(ArticuloDTO articuloDTO){
		ArticuloDTO articuloDTO2 = SerializationUtils.clone(articuloDTO);		
		//obtener ArticuloUnidadManejoDTO activos
		if(articuloDTO2.getTieneUnidadManejoCol()){
			Collection<ArticuloUnidadManejoDTO> unidadManejoCol = (Collection<ArticuloUnidadManejoDTO>) CollectionUtils.select(articuloDTO2.getArticuloUnidadManejoCol(), 
					new BeanPredicate("estadoUnidadManejo", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));			
			articuloDTO2.setArticuloUnidadManejoCol(CollectionUtils.isNotEmpty(unidadManejoCol) ? unidadManejoCol : null);
		}
		
		//obtener ArticuloImpuestoDTO activos
		if(articuloDTO2.getTieneArticuloImpuestoCol()){
			Collection<ArticuloImpuestoDTO> articuloImpuestoCol = (Collection<ArticuloImpuestoDTO>) CollectionUtils.select(articuloDTO2.getArticuloImpuestoCol(), 
					new BeanPredicate("estadoArticuloImpuesto", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
			articuloDTO2.setArticuloImpuestoCol(CollectionUtils.isNotEmpty(articuloImpuestoCol) ? articuloImpuestoCol : null);
		}
		
		if(articuloDTO2.getTieneArticuloProveedor()){
			for(ArticuloProveedorDTO articuloProveedorDTO : articuloDTO2.getArticuloProveedorCol()){
				//control sobre ArticuloImportacionDTO
				if(articuloProveedorDTO.getArticuloImportacion() instanceof HibernateProxy){
					articuloProveedorDTO.setArticuloImportacion(new ArticuloImportacionDTO());
					articuloProveedorDTO.getArticuloImportacion().setPorcentajeComision(null);
					articuloProveedorDTO.getArticuloImportacion().setCostoMonedaOrigen(null);
				}
				//control sobre Unidades de Manejo
				if(articuloProveedorDTO.getTieneUnidadesManejo()){
					for(ArticuloUnidadManejoProveedorDTO unidadManejoProveedorDTO : articuloProveedorDTO.getUnidadesManejo()){
						unidadManejoProveedorDTO.setArticuloProveedor(articuloProveedorDTO);
					}
				}
				//control sobre DescuentosProveedor
				if(articuloProveedorDTO.getTieneDescuentoProveedorArticuloCol()){
					for(DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO : articuloProveedorDTO.getDescuentoProveedorArticuloCol()){
						descuentoProveedorArticuloDTO.setArticuloProveedor(articuloProveedorDTO);
					}
					//obtener DescuentoProveedorArticulo activos
					Collection<DescuentoProveedorArticuloDTO> descProvArticuloCol = (Collection<DescuentoProveedorArticuloDTO>) CollectionUtils.select(articuloProveedorDTO.getDescuentoProveedorArticuloCol(), 
							new BeanPredicate("estado", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
					articuloProveedorDTO.setDescuentoProveedorArticuloCol(CollectionUtils.isNotEmpty(descProvArticuloCol) ? descProvArticuloCol : null);
				}
			}
		}
		
		//control sobre Caracteristicas
		if(articuloDTO2.getTieneCaracteristicasCol()){
			for(CaracteristicaDTO caracteristicaDTO : articuloDTO2.getCaracteristicaDTOSet()){
				if(caracteristicaDTO.getTipoCaracteristica() instanceof HibernateProxy){
					caracteristicaDTO.setTipoCaracteristica(new TipoCaracteristicaDTO());
					caracteristicaDTO.getTipoCaracteristica().setName(null);
				}
			}
		}		
		return articuloDTO2;
	}

	public ICalculoArticuloGestor getCalculoArticuloGestor() {
		return calculoArticuloGestor;
	}

	public void setCalculoArticuloGestor(ICalculoArticuloGestor calculoArticuloGestor) {
		this.calculoArticuloGestor = calculoArticuloGestor;
	}

	public AuditoriaGestor getAuditoriaGestorDirecto() {
		return auditoriaGestorDirecto;
	}

	public void setAuditoriaGestorDirecto(AuditoriaGestor auditoriaGestorDirecto) {
		this.auditoriaGestorDirecto = auditoriaGestorDirecto;
	}

	public IAuditoriaGestor getAuditoriaGestor() {
		return auditoriaGestor;
	}
	
	public void setAuditoriaGestor(IAuditoriaGestor auditoriaGestor) {
		this.auditoriaGestor = auditoriaGestor;
	}
	
	
}
