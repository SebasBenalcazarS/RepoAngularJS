/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ConfiguracionNivelPagoReporteCaracteristicaDTO;


/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
public class DatosConfiguracionNivelPagoReportesVO implements Serializable {

	private Collection<ConfiguracionNivelPagoDTO> configuracionesNivelesPago;
	private Collection<ConfiguracionNivelPagoReporteCaracteristicaDTO> configuracionesNivelesCaracteristicas;
	/**
	 * @return the configuracionesNivelesPago
	 */
	public Collection<ConfiguracionNivelPagoDTO> getConfiguracionesNivelesPago() {
		return configuracionesNivelesPago;
	}
	/**
	 * @param configuracionesNivelesPago the configuracionesNivelesPago to set
	 */
	public void setConfiguracionesNivelesPago(
			Collection<ConfiguracionNivelPagoDTO> configuracionesNivelesPago) {
		this.configuracionesNivelesPago = configuracionesNivelesPago;
	}
	/**
	 * @return the configuracionesNivelesCaracteristicas
	 */
	public Collection<ConfiguracionNivelPagoReporteCaracteristicaDTO> getConfiguracionesNivelesCaracteristicas() {
		return configuracionesNivelesCaracteristicas;
	}
	
	
	/**
	 * @param configuracionesNivelesCaracteristicas the configuracionesNivelesCaracteristicas to set
	 */
	public void setConfiguracionesNivelesCaracteristicas(
			Collection<ConfiguracionNivelPagoReporteCaracteristicaDTO> configuracionesNivelesCaracteristicas) {
		
		this.configuracionesNivelesCaracteristicas = configuracionesNivelesCaracteristicas;
		
		/*if (CollectionUtils.isNotEmpty(this.configuracionesNivelesCaracteristicas)){
			this.configuracionesNivelesCaracteristicas = ColeccionesUtil.sort(this.configuracionesNivelesCaracteristicas, 
					ColeccionesUtil.ORDEN_ASC, 
					"prioridad");
		}*/
		
	}
	
	
	/**
	 * 
	 * @param datosConfiguracionNivelPagoReportesVO
	 * @return
	 */
	public static Boolean existenDatosConfiguracionNivelPagoReportes(DatosConfiguracionNivelPagoReportesVO datosConfiguracionNivelPagoReportesVO){
		return datosConfiguracionNivelPagoReportesVO != null &&
			CollectionUtils.isNotEmpty(datosConfiguracionNivelPagoReportesVO.getConfiguracionesNivelesCaracteristicas()) &&
			CollectionUtils.isNotEmpty(datosConfiguracionNivelPagoReportesVO.getConfiguracionesNivelesPago());
	}
	
}
