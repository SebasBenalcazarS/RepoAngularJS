/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao.mercancias;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoCaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloCaracteristicasMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;

/**
 * @author eharo
 *
 */
public interface IArticuloMercanciaDAO {

	
	public List<TipoCaracteristicaDTO> obtenerListaTipoCaracteristicas(final Integer codigoCompania) throws SICException;
	
	public List<CaracteristicaDTO> obtenerListaCaracteristicas(Integer codigoCompania, Collection<Integer> tipoCaracteristicaId, String codigoArticulo) throws SICException;
	
	public void transGuardarCaracteristicas(String usuario, List<CaracteristicaDTO> lstCaracteristicas) throws SICException;
	
	public void transEliminarCaracteristica(String usuario, Set<CaracteristicaDTO> caracteristicasEliminar) throws SICException;
	
	public void transGuardarCaracteristicas(String usuario, Collection<CaracteristicaDTO> lstCaracteristicas)throws SICException; 
	
	public Collection<VistaArticuloCaracteristicasMercanciaDTO> obtenerCaracterisiticasMercancias(Integer codigoCompania,String codigoBarras,String areaTrabajoFuncionario)throws SICException;
	
	public Collection<ArticuloRangoExtensionGarantiaDTO> obtenerRangosExtensionGarantia(Integer codigoCompania,Double precioBaseImp)throws SICException;
	
	public Collection<ArticuloDTO> obtenerArticulosParaCaracteristicasMercancia(Integer codigoCompania,Collection<String> codigoArtBarCol, Boolean esCodigoBarra, Integer areaTrabajoFuncionario,String codigoClasificacion) throws SICException;
	
	public Collection<String> obtenerArticuloPaginado(Integer first, Integer pageSize, Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException;
	
	public Integer totalRegistrosEtiquetaMercanciaMasiva(Integer codigoCompania, Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException;
	
	public Collection<String> obtenerCodigosClasificacionFuncionario(FuncionarioDTO funcionario,Boolean tieneLineaComercial) throws SICException;
}
