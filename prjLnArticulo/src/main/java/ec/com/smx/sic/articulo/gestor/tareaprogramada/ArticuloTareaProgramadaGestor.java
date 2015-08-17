/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.tareaprogramada;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.MultiKeyMap;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;

import ec.com.integration.service.IntegrationServiceI;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.novedad.IArticuloNovedadGestor;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.accion.IAccionArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.IArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.gestor.articulo.tareaprogramada.IArticuloTareaProgramadaGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAlcanceDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.resources.SICMessages;

/**
 * @author jmontenegro
 * @author fcollaguazo
 */
public class ArticuloTareaProgramadaGestor implements IArticuloTareaProgramadaGestor{
	
	private IArticuloAlcanceGestor articuloAlcanceGestor;
	private IArticuloAlcanceDAO articuloAlcanceDAO;
	private IAccionArticuloGestor accionArticuloGestor;
	private JobLauncher jobLauncher;
	private Job migracionArticuloAreaTrabajoJob;
	private IArticuloNovedadGestor articuloNovedadGestor;
	private IArticuloDAO articuloDAO;
	
	@Override
	public void activarDesactivarArticulosAlcance(Integer codigoCompania, String tipoAreaTrabajo)throws SICException{
		
		
		Logeable.LOG_SICV2.info("*********************************************************");
		Logeable.LOG_SICV2.info("***********activarDesactivarArticulosAlcance ************");
		Logeable.LOG_SICV2.info("*********************************************************");
		try {

			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			Timestamp fechAct=new Timestamp(System.currentTimeMillis());
//			Timestamp fechAct=Timestamp.valueOf("2014-05-19 18:48:05.123");

			//
			String fechaActual= formateador.format(new Date()) ,  fechaActualTime=fechAct.toString();
			
		    Logeable.LOG_SICV2.info("fechaActual --------> "+fechaActual+" fechaActualTime ************ "+fechaActualTime);
		    
		    Logeable.LOG_SICV2.info("*********************************************************");
			Logeable.LOG_SICV2.info("***********Activar Alcances ************");
			Logeable.LOG_SICV2.info("*********************************************************");
			
		    articuloAlcanceDAO.activarDesactivarArticulosAlcance(fechaActual, fechaActualTime, tipoAreaTrabajo, SICConstantes.ESTADO_ACTIVO_NUMERICO,codigoCompania);
		    
		    Logeable.LOG_SICV2.info("*********************************************************");
			Logeable.LOG_SICV2.info("***********Desactivar Alcances ************");
			Logeable.LOG_SICV2.info("*********************************************************");
		    
			articuloAlcanceDAO.activarDesactivarArticulosAlcance(fechaActual, fechaActualTime, tipoAreaTrabajo, SICConstantes.ESTADO_INACTIVO_NUMERICO,codigoCompania);
			
			Logeable.LOG_SICV2.info("*********************************************************");
			Logeable.LOG_SICV2.info("***********insertarBitacoraArticuloAreaTrabajo **********");
			Logeable.LOG_SICV2.info("*********************************************************");
			
			String tipAreaTrabajo=SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.local");
			if(tipoAreaTrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA)){
				tipAreaTrabajo = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina");
			}else if(tipoAreaTrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA)){
				tipAreaTrabajo = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega");
			}
			
			//LLenar los articulos en los establecimientos
			if(tipoAreaTrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL)){
				articuloAlcanceDAO.activarDesactivarArticulosMasivoEstablecimientos(SICConstantes.USERID, null, fechAct);
				articuloAlcanceDAO.insertarArticulosMasivoEstablecimientos(SICConstantes.USERID, null, fechAct);
			}
			
			articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(fechAct,tipAreaTrabajo,codigoCompania,null);
			
			Logeable.LOG_SICV2.info("*********************************************************");
			Logeable.LOG_SICV2.info("*********** actualizacionSubbodegas ******");
			Logeable.LOG_SICV2.info("*********************************************************");
			//si no es oficina insertar y actualizar sublugartrabajo
			if(!tipAreaTrabajo.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"))){
				articuloAlcanceDAO.actualizacionSubbodegas(SICConstantes.USERID, null ,SICConstantes.ESTADO_ACTIVO_NUMERICO, fechAct,tipAreaTrabajo, null,codigoCompania);
				articuloAlcanceDAO.actualizacionSubbodegas(SICConstantes.USERID, null ,SICConstantes.ESTADO_INACTIVO_NUMERICO, fechAct,tipAreaTrabajo, null,codigoCompania);
			}
			Logeable.LOG_SICV2.info("****************************************************************");
			Logeable.LOG_SICV2.info("*********** asignacionMasivaArticulosActualizarPrototipo *******");
			Logeable.LOG_SICV2.info("****************************************************************");
			//Valida si se va a dar alcances a locales 
			if(tipoAreaTrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL)){
				articuloAlcanceGestor.asignacionMasivaArticulosActualizarPrototipo(fechAct,SICConstantes.USERID,tipAreaTrabajo,codigoCompania);
			}
			
			Logeable.LOG_SICV2.info("*********************************************************");
			Logeable.LOG_SICV2.info("*********** fin de tarea programada ******");
			Logeable.LOG_SICV2.info("*********************************************************");
			//comunicar al sic
//			ArticuloVO articuloVO=new ArticuloVO();
//			articuloVO.setUsuarioAlcance(SICConstantes.USERID);
//			articuloVO.setFechaAplicacion(fechAct);
//			articuloVO.setOpcionTipoAsignacionAlcance(tipoAreaTrabajo);
//			this.articuloAlcanceGestor.obtenerArticuloLocalSIC(articuloVO);
			
		}catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activarDesactivarArticulosAlcance {}",e);
			throw new SICException("Error en la activarDesactivarArticulosAlcance(Integer codigoCompania) "+e);
		}
	}
	
	@Override
	public void migracionArticuloAreaTrabajo(String url)throws SICException{
		Logeable.LOG_SICV2.info("*********************************************************");
		Logeable.LOG_SICV2.info("***********Inicio migracionArticuloAreaTrabajo ******");
		Logeable.LOG_SICV2.info("*********************************************************");
		
		try{
		    
		    //Lanzamos el job
		    JobExecution jobExecution;
			
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("fechaEjecucion", new JobParameter(new Date()));
			params.put("rutaArchivo", new JobParameter(url));// ejemplo "C:\\Users\\jmontenegro\\Documents\\pruebaLeerArchivo.csv"
			jobExecution = jobLauncher.run(migracionArticuloAreaTrabajoJob, new JobParameters(params));
			
			Logeable.LOG_SICV2.info("El trabajo ha finalizado con estado:{} ", jobExecution.getExitStatus());
					
			 if(jobExecution.getExitStatus().equals(ExitStatus.FAILED)){
				 throw new SICException("El trabajo  obtenerArticuloLocalSIC ha finalizado con estado: " + ExitStatus.FAILED);
			 }
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error: {}",e);
		}
		
		
		Logeable.LOG_SICV2.info("*********************************************************");
		Logeable.LOG_SICV2.info("***********Fin migracionArticuloAreaTrabajo ******");
		Logeable.LOG_SICV2.info("*********************************************************");
	}
	
	public void resolverInconsistenciasArticuloRelacionadoCupon(Integer codigoCompania, Integer numeroEjecucion) throws SICException {
		this.articuloNovedadGestor.resolverInconsistenciasArticuloRelacionadoCupon(codigoCompania, numeroEjecucion);
	}
	
	//TODO
	@Override
	public void enviarArticulosPendientesAlSIC(final Integer codigoCompania) throws SICException {
		Collection<ArticuloPendienteIntegracionDTO> pendienteIntegracionCol = SICFactory.getInstancia().administracion.getTareaProgramadaService().obtenerArticuloPendientesIntegracion(codigoCompania, null);
		this.accionArticuloGestor.transferirDatosArticuloSICAsincrona(codigoCompania, pendienteIntegracionCol);
	}
	
	@Override
	public void enviarArticulosPendientesEdicionMasivaAlSIC(final Integer codigoCompania) throws SICException {
		Collection<ArticuloPendienteIntegracionDTO> pendienteIntegracionCol = SICFactory.getInstancia().administracion.getTareaProgramadaService().obtenerArticuloPendientesIntegracion(codigoCompania, TipoCatalogoArticulo.PROCESO_INTEGRACION_EDICIONMASIVAARTICULOS);
		this.accionArticuloGestor.transferirDatosArticuloSICAsincrona(codigoCompania, pendienteIntegracionCol);
	}
	
	@Override
	public void enviarArticulosPendientesCreacionMasivaAlSIC(final Integer codigoCompania) throws SICException {
		Collection<ArticuloPendienteIntegracionDTO> pendienteIntegracionCol = SICFactory.getInstancia().administracion.getTareaProgramadaService().obtenerArticuloPendientesIntegracion(codigoCompania, TipoCatalogoArticulo.PROCESO_INTEGRACION_CREACIONMASIVAARTICULOS);
		this.accionArticuloGestor.transferirDatosArticuloSICAsincrona(codigoCompania, pendienteIntegracionCol);
	}
	
	@Override
	public void enviarArticulosPendientesActualizacionArchivoAlSIC(final Integer codigoCompania) throws SICException {
		Collection<ArticuloPendienteIntegracionDTO> pendienteIntegracionCol = SICFactory.getInstancia().administracion.getTareaProgramadaService().obtenerArticuloPendientesIntegracion(codigoCompania, TipoCatalogoArticulo.PROCESO_INTEGRACION_ACTUALIZACIONARTICULOSPORARCHIVO);
		this.accionArticuloGestor.transferirDatosArticuloSICAsincrona(codigoCompania, pendienteIntegracionCol);
	}
	
	@Override
	public void enviarArticulosPendientesActualizacionCondicionesComercialesAlSIC(Integer codigoCompania) throws SICException {
		Collection<ArticuloPendienteIntegracionDTO> pendienteIntegracionCol = SICFactory.getInstancia().administracion.getTareaProgramadaService().obtenerArticuloPendientesIntegracion(codigoCompania, TipoCatalogoArticulo.PROCESO_INTEGRACION_ACTUALIZACION_CONDICIONES_COMERCIALES);
		this.accionArticuloGestor.transferirDatosArticuloProveedorSIC(codigoCompania, pendienteIntegracionCol);
	}
	//TODO
	@Override
	public Collection<ArticuloPendienteIntegracionDTO> obtenerArticuloPendientesIntegracion(Integer codigoCompania, String valorTipoProceso) throws SICException {
		return this.accionArticuloGestor.obtenerArticuloPendientesIntegracion(codigoCompania, valorTipoProceso);
	}
	
	@Override
	public void transferirArticuloSICAsincrona(Integer codigoCompania, ArticuloDTO articuloPlantilla, Collection<ArticuloPendienteIntegracionDTO> artPenIntCol, ArticuloPendienteIntegracionDTO articuloPendienteIntegracionDTO, MultiKeyMap multiKey, IntegrationServiceI integrationServiceI, ArticuloVO vo, ArticuloLocalDTO al, ArticuloProveedorDTO apFiltro, RelacionArticuloRegistroSanitarioDTO ars)throws SICException{
		this.accionArticuloGestor.transferirArticuloSICAsincrona(codigoCompania, articuloPlantilla, artPenIntCol, articuloPendienteIntegracionDTO, multiKey, integrationServiceI, vo, al, apFiltro, ars);
	}
	
	@Override
	public void migrarArticulosInformacionPortal(Integer codigoCompania)throws SICException{
		this.accionArticuloGestor.migrarArticulosInformacionPortal(codigoCompania);
	}
	
	/**
	 * sincroniza la informacion de articulo ley de mercado(es nuevo, dependiendo de la fecha
	 */
	public void sincronizarInformacionArticuloLeyMercado(Integer codigoCompania)throws SICException{
		this.accionArticuloGestor.sincronizarInformacionArticuloLeyMercado(codigoCompania);
	}
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	@Override
	public void enviarErroresIntegracionSIC(Integer codigoCompania)throws SICException{
		this.accionArticuloGestor.enviarErroresIntegracionSIC(codigoCompania);
	}
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoEstado
	 * @param habilitaFechaCreacion
	 * @param codigoLineaComercial
	 */
	public void invalidarArticulosFecha(Integer codigoCompania,String codigoEstado, Integer habilitaFechaCreacion,String codigoLineaComercial){
		articuloDAO.invalidarArticulosFecha(codigoCompania,codigoEstado,habilitaFechaCreacion,codigoLineaComercial);
	}
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.tareaprogramada.IArticuloTareaProgramadaGestor#enviarArticulosPendientesCondicionesComercialesAlSIC(java.lang.Integer, java.lang.String)
	 */
//	@Override
//	public void enviarArticulosPendientesPorProcesoAlSIC(final Integer codigoCompania, final String valorTipoProceso) throws SICException {
//		this.accionArticuloGestor.enviarArticulosPendientesPorProcesoAlSIC(codigoCompania, valorTipoProceso);
//		
//	}

	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	/**
	 * @param jobLauncher the jobLauncher to set
	 */
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}


	/**
	 * @param migracionArticuloAreaTrabajoJob the migracionArticuloAreaTrabajoJob to set
	 */
	public void setMigracionArticuloAreaTrabajoJob(Job migracionArticuloAreaTrabajoJob) {
		this.migracionArticuloAreaTrabajoJob = migracionArticuloAreaTrabajoJob;
	}


	/**
	 * @param articuloAlcanceGestor the articuloAlcanceGestor to set
	 */
	public void setArticuloAlcanceGestor(IArticuloAlcanceGestor articuloAlcanceGestor) {
		this.articuloAlcanceGestor = articuloAlcanceGestor;
	}

	/**
	 * @param articuloAlcanceDAO the articuloAlcanceDAO to set
	 */
	public void setArticuloAlcanceDAO(IArticuloAlcanceDAO articuloAlcanceDAO) {
		this.articuloAlcanceDAO = articuloAlcanceDAO;
	}

	public void setAccionArticuloGestor(IAccionArticuloGestor accionArticuloGestor) {
		this.accionArticuloGestor = accionArticuloGestor;
	}

	public void setArticuloNovedadGestor(IArticuloNovedadGestor articuloNovedadGestor) {
		this.articuloNovedadGestor = articuloNovedadGestor;
	}
	
	
	
}
