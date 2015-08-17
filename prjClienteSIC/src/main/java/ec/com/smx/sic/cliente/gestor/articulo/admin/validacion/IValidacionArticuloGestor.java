package ec.com.smx.sic.cliente.gestor.articulo.admin.validacion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IValidacionArticuloGestor {

	/**
	 * Realiza la validacion de los datos del articulo
	 * @param articuloVO
	 */
	public abstract void validarConsistenciaDatos(ArticuloDTO articuloDTO) throws SICRuleException;

	/**
	 * 
	 * @param articuloVO
	 * @return objeto bit&aacute;cora que ya tiene el c&oacute;digo de barras, es nulo si el c&oacute;digo de barras no est&Aacute; asignado a ning&uacute;n art&iacute;culo
	 */
	public abstract ArticuloBitacoraCodigoBarrasDTO validarAsignacionCodigoBarras(ArticuloVO articuloVO) throws SICRuleException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoBarras
	 * @throws SICRuleException
	 */
	void validarAsignacionCodigoBarras(Integer codigoCompania, String codigoArticulo, String codigoBarras)throws SICRuleException;

	/***
	 * Verifica si es requerido el peso aproximado dependiento del control de costo
	 * @param tipoControlCosto
	 * @return
	 */
	public abstract Boolean esRequeridoPesoAproximado(String tipoControlCosto);

	/***
	 * Verifica si un c&oacute;digo es un EAN v&aacute;lido
	 * @param tipoControlCosto
	 * @return
	 */
	public abstract Boolean esEANValido(String codigoEAN);
	
	public void validarCantidadMaximaCuponesActivosLocal(ArticuloVO articuloVO)throws SICException;

	/**
	 * 
	 * @param sca
	 * @return
	 */
	public void validarPasoCreacion(SegmentoCreacionArticuloDTO sca, ArticuloVO articuloVO);
	
//	public void validarArchivosAdjuntosCupones(ArticuloVO articuloVO) throws SICException;
	
	public void validarRangoSecuenciaCodigoInterno(ArticuloDTO articuloDTO)throws SICException;
	
	public void validarDatosArticuloCupon(ArticuloVO articuloVO)throws SICException;
}