/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.articulo.alcance.nosql.almacenamiento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import ec.com.kruger.encriptacion.excepcion.EncriptacionExcepcion;
import ec.com.smx.generadorexportacion.spring.batch.core.ExtendedJobParameter;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.bodega.CentroDistribucionUtil;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IArticuloAlcanceMigracionNoSqlGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.VistaArticuloLocalNoSqlDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAlcanceDAO;

/**
 * @author wcaiza
 *
 */
public class ArticuloAlcanceMigracionNoSqlGestor implements IArticuloAlcanceMigracionNoSqlGestor, Logeable {
	
	private IArticuloAlcanceDAO articuloAlcanceDAO;
	
	// Proceso batch para migrar articulo local
	private JobLauncher jobLauncherMigracionArticuloAlcanceNoSql;
	private Job migracionArticuloAlcanceNoSqlJob;
	
	/**
	 * @param articuloAlcanceDAO the articuloAlcanceDAO to set
	 */
	public void setArticuloAlcanceDAO(IArticuloAlcanceDAO articuloAlcanceDAO) {
		this.articuloAlcanceDAO = articuloAlcanceDAO;
	}

	/**
	 * @param jobLauncherMigracionArticuloAlcanceNoSql the jobLauncherMigracionArticuloAlcanceNoSql to set
	 */
	public void setJobLauncherMigracionArticuloAlcanceNoSql(JobLauncher jobLauncherMigracionArticuloAlcanceNoSql) {
		this.jobLauncherMigracionArticuloAlcanceNoSql = jobLauncherMigracionArticuloAlcanceNoSql;
	}

	/**
	 * @param migracionArticuloAlcanceNoSqlJob the migracionArticuloAlcanceNoSqlJob to set
	 */
	public void setMigracionArticuloAlcanceNoSqlJob(Job migracionArticuloAlcanceNoSqlJob) {
		this.migracionArticuloAlcanceNoSqlJob = migracionArticuloAlcanceNoSqlJob;
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.IArticuloAlcanceMigracionNoSqlGestor#obtenerColCodigoLocalMigrar(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Collection<Integer> obtenerColCodigoLocalMigrar (Integer codigoCompania, String sufijoTabla) throws SICException {
		
		Collection<ArticuloLocalDTO> colArticuloLocal = this.articuloAlcanceDAO.obtenerColArticuloLocalDTO(codigoCompania, sufijoTabla);
		Collection<Integer> colCodigoLocalMigrar = new ArrayList<>();
		
		//Asi para no perder el orden que viene de la BD
		for (ArticuloLocalDTO articuloLocal : colArticuloLocal) {
			colCodigoLocalMigrar.add(articuloLocal.getId().getCodigoLocal());
		}
		colArticuloLocal = null;
		
		return colCodigoLocalMigrar;
		
	}
	
	@Override
	public void migrarArticuloAlcanceDTONoSql(Integer codigoCompania, String sufijoTabla) throws SICException {
		
		Collection<Integer> colCodigoLocalMigrar = 
				SICFactory.getInstancia().articulo.getArticuloAlcanceNoSqlServicio().obtenerColCodigoLocalMigrar(codigoCompania, sufijoTabla);
		
		for (Integer codigoLocal : colCodigoLocalMigrar) {
			this.ejecutarProcesoBatchMigrarArticuloLocal(codigoCompania, codigoLocal, sufijoTabla);
		}
		
	}
	
	@Override
	public void migrarArticuloAlcanceDTONoSql(Integer codigoCompania, Integer codigoLocal, String sufijoTabla) throws SICException {
		
		try {
			
			this.ejecutarProcesoBatchMigrarArticuloLocal(codigoCompania, codigoLocal, sufijoTabla);
			
		} catch (Exception e) {
			LOG_SICV2.error("Error al migrarArticuloAlcanceDTONoSql: {}", e.toString());
			throw new SICException(e);
		}
		
	}
	
	private void ejecutarProcesoBatchMigrarArticuloLocal (Integer codigoCompania, Integer codigoLocal, String sufijoTabla) throws SICException {
		
		Logeable.LOG_SICV2.info("Se ejecutarProcesoBatchMigrarArticuloLocal para el local: {}", codigoLocal);
		JobExecution jobExecution = null;
		
		try {
			
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			
			// Parametros para la consulta sql para AArticuloLocalDTO
			params.put("consultaSql", new JobParameter(this.buildConsultaArticuloLocal(sufijoTabla)));
			params.put("viewAlias", new JobParameter("vista"));
			params.put("vistaArticuloLocalNoSqlDTO", new ExtendedJobParameter(new VistaArticuloLocalNoSqlDTO()));
			
			// Parametros para la consulta sql para ArticuloAreaTrabajoBitacoraDTO
			params.put("consultaArticuloBitacoraSql", new JobParameter(this.buildConsultaArticuloAreaTrabajoBitacoraDTO(sufijoTabla)));
			params.put("viewAlias", new JobParameter("vista"));
			params.put("articuloAreaTrabajoBitacoraDTO", new ExtendedJobParameter(new ArticuloAreaTrabajoBitacoraDTO()));
			
			// Parametros para la consulta sql para ArticuloAreaTrabajoBitacoraDTO
			params.put("consultaArticuloEstablecimientoSql", new JobParameter(this.buildConsultaArticuloEstablecimientoDTO(sufijoTabla)));
			params.put("viewAlias", new JobParameter("vista"));
			params.put("articuloEstablecimientoDTO", new ExtendedJobParameter(new ArticuloEstablecimientoDTO()));
			
			//Parametros para las consultas
			params.put("pCodigoCompania", new JobParameter(String.valueOf(codigoCompania)));
			params.put("pCodigoLocal", new JobParameter(String.valueOf(codigoLocal)));
			params.put("pSufijoTabla", new JobParameter(String.valueOf(sufijoTabla)));
			
			//parametro para evitar JobInstanceAlreadyCompleteException
			params.put("time", new JobParameter(System.currentTimeMillis()));
			
			jobExecution = jobLauncherMigracionArticuloAlcanceNoSql.run(migracionArticuloAlcanceNoSqlJob, new JobParameters(params));
			jobExecution.getExitStatus();
			
			Logeable.LOG_SICV2.info("El trabajo ha finalizado con estado:{} ", jobExecution.getExitStatus());
			
		} catch (EncriptacionExcepcion | JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
			Logeable.LOG_SICV2.error("Error al ejecutar migrarArticuloAlcanceDTONoSqlBatch: {}", e.toString());
			throw new SICException(e);
		}
	}
	
	private String buildConsultaArticuloLocal (String sufijoTabla) {

		StringBuilder sql = CentroDistribucionUtil.getInstancia().appendObject(
				"SELECT ",
				"ARTLOC.CODIGOCOMPANIA {vista.id.codigoCompania}, ", 
				"ARTLOC.CODIGOARTICULO {vista.id.codigoArticulo}, ",
				"ARTLOC.CODIGOLOCAL {vista.id.codigoLocal}, ",
				"ARTLOC.ESTADOARTICULOLOCAL {vista.estadoArticuloLocal}, ",
				"ARTLOC.FECHAINICIALALCANCE {vista.fechaInicialAlcance}, ",
				"ARTLOC.FECHAFINALALCANCE {vista.fechaFinalAlcance}, ",
				"ARTLOC.MINIMOSTOCK {vista.minimoStock}, ",
				"ARTLOC.MAXIMOSTOCK {vista.maximoStock}, ",
				"ARTLOC.CODIGOREFERENCIA {vista.codigoReferencia}, ",
				"ARTLOC.ESTADOCODIGOREFERENCIA {vista.estadoCodigoReferencia}, ",
				"ARTLOC.ESTADOINTEGRACIONALCANCE {vista.estadoIntegracionAlcance}, ",
				"ARTLOC.USUARIOACTIVACION {vista.idUsuarioActivacion}, ",
				"ARTLOC.FECHAACTIVACION {vista.fechaActivacion}, ",
				"ARTLOC.USUARIOINACTIVACION {vista.idUsuarioInactivacion}, ",
				"ARTLOC.FECHAINACTIVACION {vista.fechaInactivacion}, ",
				"ARTLOC.CODIGOSISTEMA {vista.codigoSistema}, ",
				"ARTLOC.CODIGOOPCION {vista.codigoOpcion}, ",
				"ARTLOC.VALORTIPOASIGNACION {vista.valorTipoAsignacion}, ",
				"ARTLOC.CODIGOTIPOASIGNACION {vista.codigoTipoAsignacion}, ",
				"ARTLOC.NOTIFICARLOCAL {vista.notificarLocal}, ",
				"ARTLOC.APERTURALOCAL {vista.aperturaLocal}, ",
				"ARTLOC.IDUSUARIOREGISTRO {vista.idUsuarioRegistro}, ",
				"ARTLOC.FECHAREGISTRO {vista.fechaRegistro}, ",
				"ARTLOC.IDUSUARIOMODIFICACION {vista.idUsuarioModificacion}, ",
				"ARTLOC.FECHAMODIFICACION {vista.fechaModificacion}, ",
				"ART.CODIGOGRUPOALCANCE {vista.codigoGrupoAlcance} ",
				"FROM SCSADTART", sufijoTabla, " ARTLOC ", 
				"INNER JOIN SCSPETARTICULO ART ON ART.CODIGOARTICULO=ARTLOC.CODIGOARTICULO ",
				"WHERE ARTLOC.CODIGOCOMPANIA = :pCodigoCompania ", 
				"AND ARTLOC.CODIGOLOCAL = :pCodigoLocal ");
		
		return sql.toString();
	}
	
	private String buildConsultaArticuloAreaTrabajoBitacoraDTO (String sufijoTabla) {

		StringBuilder sql = CentroDistribucionUtil.getInstancia().appendObject(
				"SELECT ",
				"ARTBIT.CODIGOCOMPANIA {vista.id.codigoCompania}, ", 
				"ARTBIT.CODARTARETRABIT {vista.id.codigoArticuloAreaTrabajoBitacora}, ",
				"ARTBIT.CODIGOAREATRABAJO {vista.codigoAreaTrabajo}, ",
				"ARTBIT.CODIGOARTICULO {vista.codigoArticulo}, ",
				"ARTBIT.CODIGOSISTEMA {vista.codigoSistema}, ",
				"ARTBIT.CODIGOOPCION {vista.codigoOpcion}, ",
				"ARTBIT.ESTADOALCANCE {vista.estadoAlcance}, ",
				"ARTBIT.USUARIOALCANCE {vista.usuarioAlcance}, ",
				"ARTBIT.FECHAALCANCE {vista.fechaAlcance}, ",
				"ARTBIT.FECHAREGISTRO {vista.fechaRegistro}, ",
				"ARTBIT.ESTADO {vista.estado}, ",
				"ARTBIT.FECHAINICIALALCANCE {vista.fechaInicialAlcance}, ",
				"ARTBIT.FECHAFINALALCANCE {vista.fechaFinalAlcance}, ",
				"ARTBIT.TIPOASIGNACIONVALOR {vista.tipoAsignacionValor}, ",
				"ARTBIT.CODIGOTIPOASIGNACION {vista.codigoTipoAsignacion}, ",
				"ARTBIT.TIPOBITACORAVALOR {vista.tipoBitacoraValor}, ",
				"ARTBIT.CODIGOTIPOBITACORA {vista.codigoTipoBitacora} ",
				"FROM SCSADTARTARETRABIT", sufijoTabla, " ARTBIT ", 
				"WHERE ARTBIT.CODIGOCOMPANIA = :pCodigoCompania ", 
				"AND ARTBIT.CODIGOAREATRABAJO = :pCodigoLocal ");
		
//		StringBuilder sql = CentroDistribucionUtil.getInstancia().appendObject(
//				"SELECT * FROM ( ",
//					"SELECT ",
//					"ARTBIT.CODIGOCOMPANIA {vista.id.codigoCompania}, ", 
//					"ARTBIT.CODARTARETRABIT {vista.id.codigoArticuloAreaTrabajoBitacora}, ",
//					"ARTBIT.CODIGOAREATRABAJO {vista.codigoAreaTrabajo}, ",
//					"ARTBIT.CODIGOARTICULO {vista.codigoArticulo}, ",
//					"ARTBIT.CODIGOSISTEMA {vista.codigoSistema}, ",
//					"ARTBIT.CODIGOOPCION {vista.codigoOpcion}, ",
//					"ARTBIT.ESTADOALCANCE {vista.estadoAlcance}, ",
//					"ARTBIT.USUARIOALCANCE {vista.usuarioAlcance}, ",
//					"ARTBIT.FECHAALCANCE {vista.fechaAlcance}, ",
//					"ARTBIT.FECHAREGISTRO {vista.fechaRegistro}, ",
//					"ARTBIT.ESTADO {vista.estado}, ",
//					"ARTBIT.FECHAINICIALALCANCE {vista.fechaInicialAlcance}, ",
//					"ARTBIT.FECHAFINALALCANCE {vista.fechaFinalAlcance}, ",
//					"ARTBIT.TIPOASIGNACIONVALOR {vista.tipoAsignacionValor}, ",
//					"ARTBIT.CODIGOTIPOASIGNACION {vista.codigoTipoAsignacion}, ",
//					"ARTBIT.TIPOBITACORAVALOR {vista.tipoBitacoraValor}, ",
//					"ARTBIT.CODIGOTIPOBITACORA {vista.codigoTipoBitacora}, ",
//					"rownumber() OVER (ORDER BY CODIGOCOMPANIA)  AS ROW_NEXT ",
//					"FROM SCSADTARTARETRABIT", sufijoTabla, " ARTBIT ", 
//					"WHERE ARTBIT.CODIGOCOMPANIA = :pCodigoCompania ", 
//					"AND ARTBIT.CODIGOAREATRABAJO = :pCodigoLocal ",
//				" ) AS PRODUCT_TEMP WHERE ROW_NEXT BETWEEN :pMin and :pMax"
//				);
		
		return sql.toString();
	}
	
	private String buildConsultaArticuloEstablecimientoDTO (String sufijoTabla) {

		StringBuilder sql = CentroDistribucionUtil.getInstancia().appendObject(
				"SELECT ",
				"ARTEST.CODIGOCOMPANIA {vista.id.codigoCompania}, ", 
				"ARTEST.CODIGOARTICULO {vista.id.codigoArticulo}, ",
				"ARTEST.CODIGOESTABLECIMIENTO {vista.id.codigoEstablecimiento}, ",
				"ARTEST.ESTADOARTICULOESTABLECIMIENTO {vista.estadoArticuloEstablecimiento}, ",
				"ARTEST.CODIGOARTICULOEXTERNO {vista.codigoArticuloExterno}, ",
				"ARTEST.IDUSUARIOREGISTRO {vista.idUsuarioRegistro}, ",
				"ARTEST.FECHAREGISTRO {vista.fechaRegistro}, ",
				"ARTEST.IDUSUARIOMODIFICACION {vista.idUsuarioModificacion}, ",
				"ARTEST.FECHAMODIFICACION {vista.fechaModificacion}, ",
				"ARTEST.CODIGOARTICULOESTABLECIMIENTO {vista.codigoArticuloEstablecimiento} ",
				
				"FROM SCARTTARTEST", " ARTEST ",
				"INNER JOIN SSPCOTESTABLECIMIENTO EST ON EST.CODIGOCOMPANIA = ARTEST.CODIGOCOMPANIA AND EST.CODIGOESTABLECIMIENTO = ARTEST.CODIGOESTABLECIMIENTO ",
				"INNER JOIN SCSPETARTICULO ART ON ART.CODIGOCOMPANIA = ARTEST.CODIGOCOMPANIA AND ARTEST.CODIGOARTICULO = ART.CODIGOARTICULO ",
				"INNER JOIN SCSADTARTLOC ARTLOC ", "ON ARTLOC.CODIGOCOMPANIA = ART.CODIGOCOMPANIA AND ARTLOC.CODIGOARTICULO = ART.CODIGOARTICULO ", 
				"WHERE ARTEST.CODIGOCOMPANIA = :pCodigoCompania ", 
				"AND ARTLOC.CODIGOLOCAL = :pCodigoLocal ");
		
		/*
		 * INNER JOIN SCSPETARTICULO ART ON ART.CODIGOCOMPANIA = ARTEST.CODIGOCOMPANIA AND ARTEST.CODIGOARTICULO = ART.CODIGOARTICULO 
			INNER JOIN SCSADTARTLOC ARTLOC ON ARTLOC.CODIGOCOMPANIA = ART.CODIGOCOMPANIA AND ARTLOC.CODIGOARTICULO = ART.CODIGOARTICULO 
		 * */
		
		return sql.toString();
	}
	
}
