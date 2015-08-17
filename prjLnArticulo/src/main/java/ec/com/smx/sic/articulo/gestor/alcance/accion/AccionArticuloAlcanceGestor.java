package ec.com.smx.sic.articulo.gestor.alcance.accion;

import java.util.HashSet;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.accion.IAccionArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.integracion.IConsultarAlcanceArticuloIDTO;

/**
 * @author aguato
 *
 */
public class AccionArticuloAlcanceGestor implements IAccionArticuloAlcanceGestor {
	
	/**
	 * Metodo que consulta a que locales
	 * tiene alcance los articulos enviados 
	 * @param codigoBarrasArticulos
	 * @return Collection<ConsultarAlcanceArticuloIDTO>
	 * @throws SICException
	 */
	@Override
	public IConsultarAlcanceArticuloIDTO consultarArticulosAlcance(HashSet<String> codigoBarrasArticulos)throws SICException{
		/*final String TIPOPROCESO = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.consultarAlcanceArticulo");
		ConsultarAlcanceArticuloIDTO conAlcArt = new ConsultarAlcanceArticuloIDTO();
		conAlcArt.getControlProceso().setProceso(TIPOPROCESO);
		conAlcArt.setDetalle(new ArrayList<ConsultarAlcanceArticuloDetalleIDTO>());
		for (String codigoBarras: codigoBarrasArticulos) {
			if(StringUtils.isEmpty(codigoBarras)){
				throw new SICException("El codigo de barras del articulo esta vacio");
			}
			ConsultarAlcanceArticuloDetalleIDTO conArticuloDetalleIDTO = new ConsultarAlcanceArticuloDetalleIDTO();
			conArticuloDetalleIDTO.setCodigoBarras(codigoBarras);
			conArticuloDetalleIDTO.setCodigoLocal("0");
			conAlcArt.getDetalle().add(conArticuloDetalleIDTO);
		}
		try{
			if(!conAlcArt.getDetalle().isEmpty()){
				conAlcArt = (ConsultarAlcanceArticuloIDTO)SICIntegracion.procesarMensaje(conAlcArt);
			}
		}catch (Exception e) {
			throw new SICException(e.getMessage(),e);
		}
		return conAlcArt;*/
		return null;
	}
}