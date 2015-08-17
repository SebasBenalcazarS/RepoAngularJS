package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;
/**
 * 
 * @author jlcayo
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaLogProcesoMigracion extends BaseSearchTemplate{

	public PlantillaBusquedaLogProcesoMigracion(Integer codigoCompania) {
		super(codigoCompania);
	}
	
	//Componentes de busqueda tipo intputText
		private SearchTemplateDTO<String> nombreProcesoFil;
		private SearchTemplateDTO<String> numeroDocumentoFil;
		private List<ArrayList<String>> resultadoProcesoList;
		public List<ArrayList<String>> getResultadoProcesoList() {
			return resultadoProcesoList;
		}
		public void setResultadoProcesoList(List<ArrayList<String>> resultadoProcesoList) {
			this.resultadoProcesoList = resultadoProcesoList;
		}

		@ComparatorTypeField	 
		private Date fechaInicialProceso;
		@ComparatorTypeField
		private Date fechaFinalProceso;
		@ComparatorTypeField
		private Date fechaInicialDocumento;
		@ComparatorTypeField
		private Date fechaFinalDocumento;
		@ComparatorTypeField
		private Boolean filtarFechaProceso;
		@ComparatorTypeField
		private Boolean filtarFechaDocumento;
		
		public SearchTemplateDTO<String> getNombreProcesoFil() {
			return nombreProcesoFil;
		}
		public void setNombreProcesoFil(SearchTemplateDTO<String> nombreProcesoFil) {
			this.nombreProcesoFil = nombreProcesoFil;
		}
		public SearchTemplateDTO<String> getNumeroDocumentoFil() {
			return numeroDocumentoFil;
		}
		public void setNumeroDocumentoFil(SearchTemplateDTO<String> numeroDocumentoFil) {
			this.numeroDocumentoFil = numeroDocumentoFil;
		}
		public Date getFechaInicialProceso() {
			return fechaInicialProceso;
		}
		public void setFechaInicialProceso(Date fechaInicialProceso) {
			this.fechaInicialProceso = fechaInicialProceso;
		}
		public Date getFechaFinalProceso() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaFinalProceso);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			fechaFinalProceso = calendar.getTime();
			return fechaFinalProceso;
		}
		public void setFechaFinalProceso(Date fechaFinalProceso) {
			this.fechaFinalProceso = fechaFinalProceso;
		}
		public Date getFechaInicialDocumento() {
			return fechaInicialDocumento;
		}
		public void setFechaInicialDocumento(Date fechaInicialDocumento) {
			this.fechaInicialDocumento = fechaInicialDocumento;
		}
		public Date getFechaFinalDocumento() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaFinalDocumento);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			fechaFinalDocumento = calendar.getTime();
			return fechaFinalDocumento;
		}
		public void setFechaFinalDocumento(Date fechaFinalDocumento) {
			this.fechaFinalDocumento = fechaFinalDocumento;
		}
		public Boolean getFiltarFechaProceso() {
			return filtarFechaProceso;
		}
		public void setFiltarFechaProceso(Boolean filtarFechaProceso) {
			this.filtarFechaProceso = filtarFechaProceso;
		}
		public Boolean getFiltarFechaDocumento() {
			return filtarFechaDocumento;
		}
		public void setFiltarFechaDocumento(Boolean filtarFechaDocumento) {
			this.filtarFechaDocumento = filtarFechaDocumento;
		}
	
		

}
