package ec.com.smx.sic.cliente.gestor.ordenCompra.calculo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.integracion.IConsultarDatosArticuloDetalleIDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;

/**
 * 
 * @author amunoz
 *
 */
public interface ICalculoValoresRotacionArticulos {

	/**
	 * 
	 * @param consultarDatosArticuloDetalleIDTO
	 * @return
	 */
	public BigDecimal calcularCostoNetoRotacion(IConsultarDatosArticuloDetalleIDTO consultarDatosArticuloDetalleIDTO) throws SICException;;
	/**
	 * 
	 * @param costoBruto
	 * @param descuentos
	 * @return
	 * @throws SICException
	 */
	public BigDecimal calcularCostoNetoRotacion(BigDecimal costoBruto, LinkedHashMap<String, BigDecimal> descuentos) throws SICException;

	/**
	 * 
	 * @param diasMenor
	 * @param cantidadTransito
	 * @param existencia
	 * @param promedio
	 * @return
	 * @throws SICException
	 */
	public Integer calcularValorSugeridoNacional(Integer diasMenor, 
												Double cantidadTransito, 
												Double existencia, 
												Double promedio,
												Integer diasRotacion) throws SICException;
	
	
	/**
	 * @param adminOrdenCompraVO
	 * @param existencia
	 * @param cantidadTransito
	 * @param tiempoMora
	 * @param promedio
	 * @param diasRotacion
	 * @param tiempoEspera
	 * @param valorUnidadManejo
	 * @return
	 * @throws SICException
	 */
	public Integer calcularValorSugeridoImportada(AdminOrdenCompraVO adminOrdenCompraVO, 
												  Double existencia,
												  Double cantidadTransito, 
												  Double tiempoMora,
												  Double promedio, 
												  Integer diasRotacion,
												  Integer tiempoEspera,
												  Integer valorUnidadManejo) throws SICException;

	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @throws SICException
	 */
	public Double calcularPromedio(Boolean esImportado,
								  IConsultarDatosArticuloDetalleIDTO consultarDatosArticuloDetalleIDTO) throws SICException;

}
