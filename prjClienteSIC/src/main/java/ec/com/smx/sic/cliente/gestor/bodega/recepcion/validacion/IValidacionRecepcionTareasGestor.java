package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;

public interface IValidacionRecepcionTareasGestor {
	
	/**
	 *
	 * @param datosTareaDTO
	 * @param funcionarioSubTraRel
	 * @throws SICException
	 */
	void crearTareaMontacarguista(DatosTareaDTO datosTareaDTO, FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 * 
	 * @param datosTareaDTO
	 * @param detalleTareaDTO	
	 * @throws SICException
	 */
	void crearTareaRecelector(DatosTareaDTO datosTareaDTO, DetalleTareaDTO detalleTareaDTO) throws SICException;

	/**
	 * 
	 * @param andenes
	 * @param recepcionProveedor
	 * @throws SICException
	 */
	void crearTareaRecibidor(Collection<DetalleSeccionDTO> andenes, RecepcionProveedorDTO recepcionProveedor) throws SICException;

	/**
	 * 
	 * @param tareaPerfilDTO
	 * @throws SICException
	 */
	void validarTareaPerfilParaRegistroProveedor(TipoTareaPerfilDTO tareaPerfilDTO) throws SICException;
	
	/**
	 * 
	 * @param tareaRecolector
	 * @param artUniManRecepcion
	 * @param codigoAreaTrabajoBodega
	 * @param codigoDetalleSeccionOrigen
	 * @throws SICException
	 */
	void validarCamposProcesarTareasRecepcionRecolector(TareaDTO tareaRecolector, ArticuloUnidadManejoDTO artUniManRecepcion, Integer codigoAreaTrabajoBodega, Long codigoDetalleSeccionOrigen) throws SICException;
	
	/**
	 * @param tareaDTO
	 * @throws SICException
	 */
	void validarCrearTarea(TareaDTO tareaDTO, CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO) throws SICException;
	
	/**
	 * @param datosTarea
	 * @param codigoTarea
	 */
	void validarCrearTareaDatosTareaRecibidor(DatosTareaDTO datosTarea, Long codigoTarea);
}