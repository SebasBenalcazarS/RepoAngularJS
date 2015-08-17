package ec.com.smx.sic.cliente.gestor.articulo.auditoria.almacenamiento;

import ec.com.smx.frameworkv2.auditoria.excepcion.AuditException;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * 
 * @author acastillo
 *
 */
public interface IAlmacenamientoAuditoriaArticuloGestor {
	
	/**
	 * Metodo que sirve para guardar la auditoria de un objeto tipo Object
	 * @param objectAuditable: Objeto que se va a auditar
	 * @param definicionID: Definicion que se encuentra en la tabla KSAUDTTIPOLOG
	 * @param sysID: Sistema que hace la auditoria, se encuentra en la tabla KSAUDTTIPOLOG
	 * @param accesItemID: se encuentra en la tabla KSAUDTTIPOLOG
	 * @return TRUE: si existió cambios, FALSE: no hubo cambios
	 * @throws SICException
	 * @throws AuditException 
	 */
	public Boolean registrarLogAuditoriaArticulo(ArticuloVO articuloDTOAuditable, String definicionID, String sysID, String accesItemID) throws SICException, AuditException;
	/**
	 * 
	 * @param proveedorVO
	 * @throws SICException
	 */
	//void registrarAuditoriaArticulo(ArticuloVO articuloVO) throws SICException;
	public void registrarLogAuditoriaArticulo(ArticuloVO articulo) throws SICException ;
}
