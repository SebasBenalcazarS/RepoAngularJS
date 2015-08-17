package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.almacenamiento;

import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.FacturaInternaVO;


public interface IAlmacenamientoFacturaInternaGestor {
	
	/**
	 * <b> Registra la factura interna; esto implica cambiar los estados de la orden de compra, con este nuevo estado generarar la FIN(factura
	 * interna); para la FIN se necesita generar la cabecera, el estado, los impuestos(en caso de existir) y finalmente los detalles; finalizado este
	 * proceso hay que actualizar el estado de los procesos logisticos, esto en cuanto a la FIN. Este metodo tambien realiza procesos para los modulos
	 * de recibido no facturado e inventario; si se termian de registrar la FIN pero existe algun problema en el resto de procesos hay que realizar un
	 * retroceso de todo lo realizado antes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 03/12/2014]
	 * </p>
	 * 
	 * @param facturaInternaVO
	 *            contiene los datos de la factura
	 * @param empresa
	 *            empresa asociada al usuario logeado
	 * @param userId
	 *            indentificador del usuario logeado
	 * @param secNotaIngreso
	 *            secuencial para la nota de ingreso
	 * @param secNumeroFactura
	 *            secuencial para el nuemro de factura
	 * @param codigoSistema
	 *            sistema desde donde se realiza la factura interna(para la auditoria de recibido no facturado)
	 * @param codigoOpcion
	 *            opcion desde donde se realiza la factura interna
	 * @return retorna la factura interna(nota de ingreso de mercaderia) registrada
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error
	 */
	FacturaEstadoDTO registrarFacturaInterna(FacturaInternaVO facturaInternaVO, EmpresaDTO empresa, String userId, String secNotaIngreso,
			String secNumeroFactura, String codigoSistema, String codigoOpcion) throws SICException;

}
