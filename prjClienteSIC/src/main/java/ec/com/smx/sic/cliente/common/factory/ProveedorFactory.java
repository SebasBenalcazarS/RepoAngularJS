package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.marcaProveedor.IMarcaProveedorServicio;
import ec.com.smx.sic.cliente.servicio.proveedor.IAuditoriaProveedorServicio;
import ec.com.smx.sic.cliente.servicio.proveedor.ICalculoDatosUsuariosProveedorServicio;
import ec.com.smx.sic.cliente.servicio.proveedor.IDatosProveedorServicio;
import ec.com.smx.sic.cliente.servicio.proveedor.IProveedorClasificacionServicio;
import ec.com.smx.sic.cliente.servicio.proveedor.IProveedorServicio;
import ec.com.smx.sic.cliente.servicio.proveedor.IValidacionProveedorServicio;
import ec.com.smx.sic.cliente.servicio.proveedorAreaTrabajo.IProveedorAreaTrabajoServicio;

public class ProveedorFactory extends SICSpringContextFactory {
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IDatosProveedorServicio getDatosProveedorServicio() throws SICException{
		return (IDatosProveedorServicio) getBean(SICFactoryConstantes.PROVEEDOR_DATOS_SERVICIO);
	}
	
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IProveedorServicio getAdministracionProveedorServicio() throws SICException{
		return (IProveedorServicio) getBean(SICFactoryConstantes.PROVEEDOR_ADMINISTRACION_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IValidacionProveedorServicio getValidacionProveedorServicio() throws SICException{
		return (IValidacionProveedorServicio) getBean(SICFactoryConstantes.PROVEEDOR_VALIDACION_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IAuditoriaProveedorServicio getAuditoriaProveedorServicio() throws SICException{
		return (IAuditoriaProveedorServicio) getBean(SICFactoryConstantes.PROVEEDOR_AUDITORIA_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public ICalculoDatosUsuariosProveedorServicio getUsuariosProveedorServicio() throws SICException{
		return (ICalculoDatosUsuariosProveedorServicio) getBean(SICFactoryConstantes.PROVEEDOR_DATOS_USUARIOS_SERVICIO);
	}
	
	public IProveedorClasificacionServicio getProveedorClasificacionServicio() throws SICException{
		return (IProveedorClasificacionServicio) getBean(SICFactoryConstantes.PROVEEDOR_CLASIFICACION_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IMarcaProveedorServicio getMarcaProveedorServicio() throws SICException{
		return (IMarcaProveedorServicio) getBean(SICFactoryConstantes.MARCA_PROVEEDOR_SERVICIO);
	}
	
	/**
	 * @author ivasquez
	 * @return
	 * @throws SICException
	 */
	public IProveedorAreaTrabajoServicio getProveedorAreaTrabajoServicio() throws SICException {
		return (IProveedorAreaTrabajoServicio) getBean(SICFactoryConstantes.PROVEEDOR_AREA_TRABAJO_SERVICIO);
	}
	
}
