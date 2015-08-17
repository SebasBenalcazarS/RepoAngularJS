package ec.com.smx.sic.cliente.gestor.articulo.admin.calculo;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface ICalculoArticuloBitacoraGestor {
	
	/**
	 * Metodo que permite asignar el codigo de barras al articulo
	 * @param articuloVO
	 * @throws SICRuleException
	 */
	void asignarCamposCodigoBarras(ArticuloVO articuloVO) throws SICRuleException;
	
	/**
	 * Indica si el codigo es interno o de origen del proveedor
	 * @param tipoCodigo
	 * @param codigoBarras
	 * @return
	 */
	String calcularCodigoBarrasPOS(String tipoCodigo, String codigoBarras);
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	String calcularCodigoBarrasInterno(ArticuloDTO articuloDTO)throws SICException;
	
	/**
	 * 
	 * @param articuloVO
	 * @param abcb
	 * @throws SICRuleException
	 */
	void asignarBitacoraCodigoBarras(ArticuloVO articuloVO, Boolean desactivarBitacora)throws SICRuleException;
	
	void reutilizarCodigoBarrasEan(ArticuloVO articuloVO)throws SICRuleException;
}