package ec.com.smx.sic.articulo.gestor.novedad;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.mensajeria.commons.resources.MensajeriaMessages;
import ec.com.smx.mensajeria.dto.EventoDTO;
import ec.com.smx.mensajeria.dto.id.EventoID;
import ec.com.smx.mensajeria.estructura.MailMensajeEST;
import ec.com.smx.mensajeria.gestor.MensajeriaG;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.novedad.IArticuloNovedadGestor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloNovedadCuponDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.novedad.IArticuloNovedadDAO;

public class ArticuloNovedadGestor implements IArticuloNovedadGestor {
	
	private IArticuloNovedadDAO articuloNovedadDAO;
	private MensajeriaG mensajeriaG;
	private IParametroGestor parametroGestor;

	@Override
	public void resolverInconsistenciasArticuloRelacionadoCupon(Integer codigoCompania, Integer numeroEjecucion) throws SICException {
		Collection<ArticuloNovedadCuponDTO> articuloNovedadCuponProcesadosCol = null;
		
		//Ejecutar procedimiento
		this.articuloNovedadDAO.ejecutarResolverInconsistenciasArticuloRelacionadoCupon(codigoCompania, numeroEjecucion);
		//Consultar registros procesados
		articuloNovedadCuponProcesadosCol = this.articuloNovedadDAO.obtenerRegistrosProcesados(codigoCompania);
		//Notificar al Correo
		if(CollectionUtils.isNotEmpty(articuloNovedadCuponProcesadosCol)) {
			this.enviarMail(codigoCompania, articuloNovedadCuponProcesadosCol);
		}
	}
	
	/**
	 * Permite enviar los mails de notificacion del procedimiento ejecutado
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param articuloNovedadCuponProcesadosCol Lista de Novedades de Cupones a notificar
	 */
	private void enviarMail(Integer codigoCompania, Collection<ArticuloNovedadCuponDTO> articuloNovedadCuponProcesadosCol) {
		EventoID eventoId = null;
		EventoDTO eventoDto = null;
		MailMensajeEST mailMensajeEst = null;
		ParametroDTO parametroDTO = parametroGestor.obtenerParametroSIC(codigoCompania, SICParametros.getInstancia().PARAMETRO_NOTIFICACION_MAILS_NOVEDADES_CUPONES);
		
		try {
			eventoId = new EventoID();
			eventoId.setCodigoEvento(SICArticuloConstantes.getInstancia().CODIGO_EVENTO_NOVEDAD_CUPON);
			eventoId.setCompanyId(codigoCompania);
			eventoId.setSystemId(SICConstantes.getInstancia().CODIGO_SISTEMA_MAX);
			eventoDto = this.mensajeriaG.obtenerEventoPorID(eventoId);
			
			if(eventoDto == null) {
				throw new SICException("El id del evento no existe");
			} else {
				mailMensajeEst = new MailMensajeEST();
				mailMensajeEst.setMensajeXML(this.construirMensajeXML(articuloNovedadCuponProcesadosCol));
				String[] para = parametroDTO.getValorParametro().split(",");
				mailMensajeEst.setPara(para);
				mailMensajeEst.setEventoDTO(eventoDto);
				mailMensajeEst.setGuardarMensaje(Boolean.FALSE);
				mailMensajeEst.setHost(MensajeriaMessages.getString("mail.serverHost"));
				mailMensajeEst.setPuerto(MensajeriaMessages.getString("mail.puerto"));
				mailMensajeEst.setFormatoHTML(true);
				this.mensajeriaG.envioMail(mailMensajeEst, Boolean.FALSE);
			}
		} catch(Exception ex) {
			throw new SICException("Error al enviar el mail de confirmaci\u00F3n", ex);
		}
	}
	
	/**
	 * Permite construir la estructura XML del mensaje
	 * @param articuloNovedadCuponProcesadosCol Coleccion de novedades de cupones ha ser notificados
	 * @return
	 */
	private String construirMensajeXML(Collection<ArticuloNovedadCuponDTO> articuloNovedadCuponProcesadosCol) {
		StringBuilder stringBuilder = new StringBuilder(150)
					  .append("<?xml version='1.0' encoding='UTF-8'?>")
					  .append("<novedadescupon>");
		
		for(ArticuloNovedadCuponDTO novedadCupon : articuloNovedadCuponProcesadosCol) {
			stringBuilder.append("<novedad><observacion>")
						 .append(novedadCupon.getMensaje())
						 .append("</observacion></novedad>");
		}
		
		stringBuilder.append("</novedadescupon>");
		
		return stringBuilder.toString();
	}

	/**
	 * 
	 * @param articuloNovedadDAO the articuloNovedadDAO to set
	 */
	public void setArticuloNovedadDAO(IArticuloNovedadDAO articuloNovedadDAO) {
		this.articuloNovedadDAO = articuloNovedadDAO;
	}

	/**
	 * @param mensajeriaG the mensajeriaG to set
	 */
	public void setMensajeriaG(MensajeriaG mensajeriaG) {
		this.mensajeriaG = mensajeriaG;
	}

	/**
	 * @param parametroGestor the parametroGestor to set
	 */
	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}
}
