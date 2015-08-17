package ec.com.smx.sic.articulo.gestor.estructuracomercial.accion;

import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.accion.IAccionEstructuraComercialGestor;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroClasificacionDetalleIDTO;
import ec.com.smx.sic.integracion.dto.articulo.RegistroClasificacionIDTO;
import ec.com.smx.sic.integracion.resources.SICIntegracionMessages;

/**
 * @author fmunoz
 *
 */
public class AccionEstructuraComercialGestor implements IAccionEstructuraComercialGestor{
	
	/**
	 * Envia los datos de una coleccion de articulos al SIC
	 * @param articulos
	 * @throws SICException
	 */
	@Override
	public void transferirDatosClasificacionSIC(Collection<ClasificacionDTO> clasificaciones)throws SICException{
		final String TIPOPROCESO = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.registro.clasificacion");
		//se crea el objeto para enviar los datos del articulo
		RegistroClasificacionIDTO registroClasificacion = new RegistroClasificacionIDTO();
		registroClasificacion.getControlProceso().setCodigoCompania(!clasificaciones.isEmpty() ? clasificaciones.iterator().next().getId().getCodigoCompania() : null);
		registroClasificacion.getControlProceso().setProceso(TIPOPROCESO);
		registroClasificacion.setDetalle(new ArrayList<RegistroClasificacionDetalleIDTO>());
		
		for(ClasificacionDTO dto : clasificaciones){
			RegistroClasificacionDetalleIDTO item = new RegistroClasificacionDetalleIDTO();
			item.setCodigoClasificacion(dto.getId().getCodigoClasificacion());
			item.setEstado(dto.getEstadoClasificacion());
			item.setTipoClasificacion(dto.getCodigoTipoClasificacion());
			item.setDescripcion(dto.getDescripcionClasificacion());
			if(dto.getCodigoClasificacionPadre() != null)
				item.setCodigoClasificacionPadre(dto.getCodigoClasificacionPadre());
			if(dto.getCodigoBodega() != null)
				item.setCodigoSubBodega(dto.getCodigoBodega());
			registroClasificacion.getDetalle().add(item);
		}
//		try{
//			if(!registroClasificacion.getDetalle().isEmpty()){
//				SICIntegracion.procesarMensaje(registroClasificacion, SICIntegracionMessages.getString("ec.com.smx.sic.integracion.xsl.MODCLAS"), 
//						SICIntegracionMessages.getString("ec.com.smx.sic.integracion.xsl.MODCLAE"));
//				SICIntegracion.procesarMensaje(registroClasificacion);
//			}
//		}catch (Exception e) {
//			throw new SICException(e.getMessage(),e);
//		}finally{
//			registroClasificacion = null;
//		}
	}
	/**
	 * Envia los datos de un articulo al SIC
	 * @param articulo
	 * @throws SICException
	 */
	@Override
	public void transferirDatosClasificacionSIC(ClasificacionDTO clasificacionDTO)throws SICException{
		Collection<ClasificacionDTO> items = new ArrayList<ClasificacionDTO>();
		items.add(clasificacionDTO);
		transferirDatosClasificacionSIC(items);
	}
	/**
	 * Envia los datos de una coleccion de articulos al SIC
	 * @param articulos
	 * @throws SICException
	 */
	@Override
	public void transferirDatosSubClasificacionSIC(Collection<SubClasificacionDTO> clasificaciones)throws SICException{
		final String TIPOPROCESO = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.registro.clasificacion");
		//se crea el objeto para enviar los datos del articulo
		RegistroClasificacionIDTO registroClasificacion = new RegistroClasificacionIDTO();
		registroClasificacion.getControlProceso().setCodigoCompania(!clasificaciones.isEmpty() ? clasificaciones.iterator().next().getId().getCodigoCompania() : null);
		registroClasificacion.getControlProceso().setProceso(TIPOPROCESO);
		registroClasificacion.setDetalle(new ArrayList<RegistroClasificacionDetalleIDTO>());
		
		for(SubClasificacionDTO dto : clasificaciones){
			RegistroClasificacionDetalleIDTO item = new RegistroClasificacionDetalleIDTO();
			item.setCodigoClasificacion(dto.getId().getCodigoSubClasificacion());
			item.setCodigoClasificacionPadre(dto.getId().getCodigoClasificacion());
			item.setEstado(dto.getEstadoSubClasificacion());
			item.setTipoClasificacion(SICConstantes.TIPCLA_SUBCLA);
			item.setDescripcion(dto.getDescripcionSubClasificacion());
			registroClasificacion.getDetalle().add(item);
		}
//		try{
//			if(!registroClasificacion.getDetalle().isEmpty()){
//				SICIntegracion.procesarMensaje(registroClasificacion, SICIntegracionMessages.getString("ec.com.smx.sic.integracion.xsl.MODCLAS"), 
//						SICIntegracionMessages.getString("ec.com.smx.sic.integracion.xsl.MODCLAE"));
//				SICIntegracion.procesarMensaje(registroClasificacion);
//			}
//		}catch (Exception e) {
//			throw new SICException(e.getMessage(),e);
//		}finally{
//			registroClasificacion = null;
//		}
	}
	/**
	 * Envia los datos de un articulo al SIC
	 * @param articulo
	 * @throws SICException
	 */
	@Override
	public void transferirDatosSubClasificacionSIC(SubClasificacionDTO clasificacionDTO)throws SICException{
		Collection<SubClasificacionDTO> items = new ArrayList<SubClasificacionDTO>();
		items.add(clasificacionDTO);
		transferirDatosSubClasificacionSIC(items);
	}
}
