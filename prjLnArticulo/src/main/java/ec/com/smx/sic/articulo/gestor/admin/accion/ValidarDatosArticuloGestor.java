package ec.com.smx.sic.articulo.gestor.admin.accion;

import java.util.Collection;
import java.util.List;

import ec.com.integration.exception.IntegrationException;
import ec.com.integration.service.IntegrationServiceI;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.accion.IValidarDatosArticuloGestor;
import ec.com.smx.sic.cliente.mdl.dto.articulo.validacion.ArticuloValidacionSIC;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloIntegracionDAO;
import ec.com.smx.sic.integracion.dto.articulo.validar.ValidarArticuloIDTO;
import ec.com.smx.sic.integracion.util.SICIntegracion;
import ec.com.smx.sic.integracion.util.UtilIntegracion;

public class ValidarDatosArticuloGestor implements IValidarDatosArticuloGestor {

	private IArticuloIntegracionDAO articuloIntegracionDAO;
	
	@Override
	public Collection<ValidarArticuloIDTO> obtenerDatosArticulosPorValidar(Integer codigoCompania, List<String> codigosArticulo) throws SICException{
		if(codigoCompania == null){
			throw new SICException("El c\u00F3digo de compania es nulo.");
		}		
		return this.articuloIntegracionDAO.obtenerDatosArticulosPorValidar(codigoCompania, codigosArticulo);
	}
	
	@Override
	public List<String> obtenerArticulosPorValidar(Integer codigoCompania, Integer maxPageSize) throws SICException{
		if(codigoCompania == null){
			throw new SICException("El c\u00F3digo de compania es nulo.");
		}	
		if(maxPageSize == null){
			throw new SICException("La cantidad m\u00E1xima a paginar es nula.");
		}	
		return this.articuloIntegracionDAO.obtenerArticulosPorValidar(codigoCompania, maxPageSize);
	}
	
	public void transferirArticuloPorValidar(Collection<ArticuloValidacionSIC> articuloValidacionCol){
		IntegrationServiceI integrationServiceI;
		try {
			integrationServiceI = SICIntegracion.iniciarConexion(UtilIntegracion.CODIGOSERVICIO_GESTIONARARTICULO);
			if(integrationServiceI == null){
				integrationServiceI = SICIntegracion.iniciarConexion(null);
				SICIntegracion.procesarMensaje(null, integrationServiceI);
			}			
		} catch (IntegrationException e) {
			Logeable.LOG_SICV2.error("Error al transferir la informacion");
		}	
	}

	public void setArticuloIntegracionDAO(IArticuloIntegracionDAO articuloIntegracionDAO) {
		this.articuloIntegracionDAO = articuloIntegracionDAO;
	}
}
