package ec.com.smx.sic.articulo.gestor.batch;

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

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.AlcanceArticuloTransient;

public class AlcanceBatchUtilGestor implements IAlcanceBatchUtilGestor{
	private JobLauncher jobLauncher;
	public Collection<AlcanceArticuloTransient> alcanceArticuloErrorCol;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void generarArchivoErrorAlcance(
			Collection<AlcanceArticuloTransient> alcanceArticuloErrorCol,
			Job job,
			String rutaDepositarArchivoT,
			String columnasT) throws SICException{
		
		try{
			this.alcanceArticuloErrorCol = alcanceArticuloErrorCol;
			Map parametros = new HashMap();
	        //parametros.put("separadorCamposArchivo", new JobParameter(separadorCamposArchivo));
	        parametros.put("rutaDepositarArchivoT", new JobParameter(rutaDepositarArchivoT));
	        parametros.put("columnasT", new JobParameter(columnasT));
	        parametros.put("tiempoEjecucion", new JobParameter(System.currentTimeMillis()));
	        
	        JobExecution jobExecution = this.jobLauncher.run(job, new JobParameters(parametros));
	        Logeable.LOG_SICV2.error("Job ejecutandose: {}", jobExecution.getJobInstance());
	        	        	    
		}catch (JobExecutionAlreadyRunningException e) {
			Logeable.LOG_SICV2.error("JobExecutionAlreadyRunningException: {}", e);
			throw new SICException("Ya existe un trabajo ejecutandose actualmente");
        } catch (JobRestartException e) {
        	Logeable.LOG_SICV2.error("JobRestartException: {}", e);
        	throw new SICException("Error al reiniciar el trabajo");
        } catch (JobInstanceAlreadyCompleteException e) {
        	Logeable.LOG_SICV2.error("JobInstanceAlreadyCompleteException: {}", e);
        	throw new SICException("El trabajo ya se encuentra finalizado anteriormente");
        } catch (JobParametersInvalidException e) {
			Logeable.LOG_SICV2.error("Los parametros son ivalidos: {}", e);
			throw new SICException("Los parametros son iv\u00E1lidos");
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al ejecutar: {}", e);
			throw new SICException("Ocurrio un error al ejecutar");
		}
	}

	@Override
	public Collection<AlcanceArticuloTransient> alcanceArticuloErrorCol() {
		return this.alcanceArticuloErrorCol;
	}
		
	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}
}
