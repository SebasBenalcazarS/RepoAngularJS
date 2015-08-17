/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ConfiguracionNivelPagoReporteCaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;


/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public abstract class CaracteristicaNivelReporteVO<T extends IBaseEntidad> extends CaracteristicaVO<T> {

	private Integer indiceNivelReporteSeleccionado;
	private Integer indiceNivelReporteSeleccionadoManualmente;
	private String secuencialConfiguracionNivelPagoSeleccionado;
	private DatosConfiguracionNivelPagoReportesVO datosConfiguracionNivelPagoReportes;

	/**
	 * @return the indiceNivelReporteSeleccionado
	 */
	public Integer getIndiceNivelReporteSeleccionado() {
		return indiceNivelReporteSeleccionado;
	}


	/**
	 * @param indiceNivelReporteSeleccionado the indiceNivelReporteSeleccionado to set
	 */
	public void setIndiceNivelReporteSeleccionado(
			Integer indiceNivelReporteSeleccionado) {
		this.indiceNivelReporteSeleccionado = indiceNivelReporteSeleccionado;
		this.indiceNivelReporteSeleccionadoManualmente = indiceNivelReporteSeleccionado;
	}


	/**
	 * @return the datosConfiguracionNivelPagoReportes
	 */
	public DatosConfiguracionNivelPagoReportesVO getDatosConfiguracionNivelPagoReportes() {
		return this.datosConfiguracionNivelPagoReportes;
	}

	/**
	 * @param datosConfiguracionNivelPagoReportes the datosConfiguracionNivelPagoReportes to set
	 */
	public void setDatosConfiguracionNivelPagoReportes(
			DatosConfiguracionNivelPagoReportesVO datosConfiguracionNivelPagoReportes) {
		this.datosConfiguracionNivelPagoReportes = datosConfiguracionNivelPagoReportes;
	}



	/**
	 * 
	 * @param prioridadActual
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Boolean verificarPrioridadConfiguraciones(final Integer prioridadActual){
		Boolean omitirPorPrioridad = Boolean.FALSE;
		Collection<ConfiguracionNivelPagoReporteCaracteristicaDTO> configuracionesPrioritarias;

		if (prioridadActual != null && prioridadActual > 0){
			//Verificar la prioridad de la configuracion

			configuracionesPrioritarias = CollectionUtils.select(this.datosConfiguracionNivelPagoReportes.getConfiguracionesNivelesCaracteristicas(), 
					new Predicate() {

						//@Override
						public boolean evaluate(Object objetoActual) {
							return ((ConfiguracionNivelPagoReporteCaracteristicaDTO) objetoActual).getPrioridad() < prioridadActual;
						}
					});
			
			
			if (CollectionUtils.isNotEmpty(configuracionesPrioritarias)){
				
				for (Iterator<ConfiguracionNivelPagoReporteCaracteristicaDTO> i = configuracionesPrioritarias.iterator(); i.hasNext() && !omitirPorPrioridad;){

					ConfiguracionNivelPagoReporteCaracteristicaDTO configuracionActual = i.next();					
					omitirPorPrioridad = super.esCaracteristicaSeleccionada(configuracionActual.getId().getCodigoCaracteristicaTipo(), configuracionActual.getId().getCodigoCaracteristica());	
					
				}
			}
		}
		
		return omitirPorPrioridad;
	}


	/**
	 * 
	 * @param codigoCompania
	 * @param codigoCaracteristicaTipo
	 * @param codigoCaracteristica
	 * @return
	 */
	private Integer getIndiceConfiguracionNivelReportePorCaracteristicaProveedor(Integer codigoCaracteristicaTipo,
			String codigoCaracteristica) {

		Integer indiceConfiguracionNivelReporte;
		ConfiguracionNivelPagoReporteCaracteristicaDTO configuracionNivelReporteActual;

		if (DatosConfiguracionNivelPagoReportesVO.existenDatosConfiguracionNivelPagoReportes(this.datosConfiguracionNivelPagoReportes)){
			configuracionNivelReporteActual = (ConfiguracionNivelPagoReporteCaracteristicaDTO) CollectionUtils.find(this.datosConfiguracionNivelPagoReportes.getConfiguracionesNivelesCaracteristicas(), 
					PredicateUtils.allPredicate(new Predicate[] {
							PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoCaracteristicaTipo"), PredicateUtils.equalPredicate(codigoCaracteristicaTipo)),
							PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoCaracteristica"), PredicateUtils.equalPredicate(codigoCaracteristica))
					}));

			if (configuracionNivelReporteActual != null){

				//Verificar la prioridad de la configuracion
				if (!this.verificarPrioridadConfiguraciones(configuracionNivelReporteActual.getPrioridad())){
					indiceConfiguracionNivelReporte =  ColeccionesUtil.getInstance().search((List<ConfiguracionNivelPagoDTO>) this.datosConfiguracionNivelPagoReportes.getConfiguracionesNivelesPago(), 
							PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.secuencialConfiguracionNivelPago"), PredicateUtils.equalPredicate(configuracionNivelReporteActual.getId().getSecuencialConfiguracionNivelPago())));

					if (indiceConfiguracionNivelReporte != -1){
						return indiceConfiguracionNivelReporte;
					}	
				}
			}
		}
		
		return this.indiceNivelReporteSeleccionado;
	}



	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.mdl.vo.CaracteristicaVO#setIndiceCaracteristicaSeleccionada(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	protected void setIndiceCaracteristicaSeleccionada(
			Integer indiceCaracteristica, Integer codigoCaracteristica) {

		CatalogoValorDTO caracteristicaSeleccionada;

		try {
			super.setIndiceCaracteristicaSeleccionada(indiceCaracteristica,
					codigoCaracteristica);

			//Nivel del reporte
			//if (this.indiceNivelReporteSeleccionadoManualmente != null && super.esConfigurable(super.getTipoEventoPersistencia())){
				caracteristicaSeleccionada = super.getCaracteristicaSeleccionada(codigoCaracteristica);
				if (caracteristicaSeleccionada != null){
					this.indiceNivelReporteSeleccionado = this.getIndiceConfiguracionNivelReportePorCaracteristicaProveedor(caracteristicaSeleccionada.getId().getCodigoCatalogoTipo(),
							caracteristicaSeleccionada.getId().getCodigoCatalogoValor());
					
					this.secuencialConfiguracionNivelPagoSeleccionado = this.getSecuenciaConfiguracionNivelPagoPorIndiceSeleccionado();
				}
			//}
			
		} catch (Exception e){
			throw new SICException(e);
		} finally {
			caracteristicaSeleccionada = null;
		}
	}


	/**
	 * 
	 * @param codigoCompania
	 * @param secuencialConfiguracionNivelPago
	 */
	public void setSecuencialConfiguracionNivelPagoSeleccionado(String secuencialConfiguracionNivelPago){
		
		Integer indiceConfiguracionNivelPago;
		
		if (StringUtils.isNotEmpty(secuencialConfiguracionNivelPago)){
			indiceConfiguracionNivelPago = ColeccionesUtil.getInstance().search((List<ConfiguracionNivelPagoDTO>) this.datosConfiguracionNivelPagoReportes.getConfiguracionesNivelesPago(),
							PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.secuencialConfiguracionNivelPago"), PredicateUtils.equalPredicate(secuencialConfiguracionNivelPago)
					));
			
			if (indiceConfiguracionNivelPago != -1){
				this.setIndiceNivelReporteSeleccionado(indiceConfiguracionNivelPago);
			}
		}
		
		this.secuencialConfiguracionNivelPagoSeleccionado = secuencialConfiguracionNivelPago;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSecuencialConfiguracionNivelPagoSeleccionado(){
		return this.secuencialConfiguracionNivelPagoSeleccionado;
	}
	
	
	/**
	 * 
	 * @param indiceSeleccionado
	 * @return
	 */
	public ConfiguracionNivelPagoDTO getConfiguracionNivelReportePorIndiceSeleccionado(){
		if (this.indiceNivelReporteSeleccionado != null && 
				this.indiceNivelReporteSeleccionado >= 0 &&
				this.indiceNivelReporteSeleccionado < this.datosConfiguracionNivelPagoReportes.getConfiguracionesNivelesPago().size()){
			
			return (ConfiguracionNivelPagoDTO) CollectionUtils.get(this.datosConfiguracionNivelPagoReportes.getConfiguracionesNivelesPago(), this.indiceNivelReporteSeleccionado);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	protected String getSecuenciaConfiguracionNivelPagoPorIndiceSeleccionado(){
		ConfiguracionNivelPagoDTO configuracionNivelPagoSeleccionado;
		
		configuracionNivelPagoSeleccionado = this.getConfiguracionNivelReportePorIndiceSeleccionado();
		if (configuracionNivelPagoSeleccionado != null){
			return configuracionNivelPagoSeleccionado.getId().getSecuencialConfiguracionNivelPago();
		}
		
		return null;
	}


	public Integer getIndiceNivelReporteSeleccionadoManualmente() {
		return indiceNivelReporteSeleccionadoManualmente;
	}


	public void setIndiceNivelReporteSeleccionadoManualmente(Integer indiceNivelReporteSeleccionadoManualmente) {
		this.indiceNivelReporteSeleccionadoManualmente = indiceNivelReporteSeleccionadoManualmente;
	}
}
