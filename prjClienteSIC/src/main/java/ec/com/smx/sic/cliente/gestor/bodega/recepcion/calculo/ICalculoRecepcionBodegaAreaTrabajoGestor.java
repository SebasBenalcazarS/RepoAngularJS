package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.FuncionarioPerfilDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

/**
 * 
 * @author acaiza
 *
 */
public interface ICalculoRecepcionBodegaAreaTrabajoGestor {

	/**
	 * Obtiene la lista de las areas de trabajo del funcionario en base a los datos del usuario
	 * @param enumCatalogoValorBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajoFuncionario(UserDto usuario) throws SICException;
	
	/**
	 * 
	 * @param vistaProveedorDTO
	 * @param cd
	 * @param fechaEntrega
	 * @return
	 */
	public Collection<FacturaDTO> obtenerFacturasEntregasProveedor(VistaProveedorDTO vistaProveedorDTO, AreaTrabajoDTO cd, Timestamp fechaEntrega) throws SICException;
	
	/**
	 * 
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaDTO> obtenerEntregasFacturasSinAsignarProceso(EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * 
	 * @param bodegaDTO
	 * @param fecha
	 * @return
	 * @throws SICException
	 */
//	public Collection<DetalleSeccionDTO> obtenerAndenesOcupadosPorSubBodega(BodegaDTO bodegaDTO, Timestamp fecha) throws SICException;
	
	/**
	 * 
	 * @param tareaPerfilDTO
	 * @param timestamp
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerSiguienteValorTipoTarea(TipoTareaPerfilDTO tareaPerfilDTO, Timestamp timestamp) throws SICException;
	
	/**
	 * 
	 * @param userDto
	 * @return
	 * @throws SICException
	 */
	public FuncionarioAreaTrabajoPerfilDTO obtenerFuncionarioAreaTrabajoPerfilPorUsuario(UserDto userDto) throws SICException ;

	/**
	 * @param userDto
	 * @param referenceCode
	 * @return
	 * @throws SICException
	 */
	public FuncionarioPerfilDTO obtenerFuncionarioPerfilPorUsuario(UserDto userDto, String referenceCode) throws SICException ;
	
}
