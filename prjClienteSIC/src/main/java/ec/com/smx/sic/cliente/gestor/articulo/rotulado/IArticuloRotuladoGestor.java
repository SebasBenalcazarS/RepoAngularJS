package ec.com.smx.sic.cliente.gestor.articulo.rotulado;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.corpv2.plantillas.dto.ConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.DetalleGrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.GrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorGrupoCampoPlantillaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloValorConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;

/**
 * 
 * @author acaiza
 *
 */

public interface IArticuloRotuladoGestor {
	
	/**
	 * 
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionConfiguracionPlantillaDTO> obtenerClasificacionConfiguracionPlantillaByClasificacion(String codigoClasificacion) throws SICException;
	
	/**
	 * 
	 * @param ccp
	 * @throws SICException
	 */
	public void registrarClasificacionConfiguracionPlantilla(ClasificacionConfiguracionPlantillaDTO ccp) throws SICException;
	
	/**
	 * 
	 * @param articulo
	 * @param valorConfiguracionPlantillaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionesPlantillaByArticulo(ArticuloDTO articulo, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO, Integer codigoCompania, String estado) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param configuracionPlantillaDTOs
	 * @param codigoUsuario
	 * @param proveedorDTO
	 * @throws SICException
	 */
	public void grabarValoresPlantilla(ArticuloDTO articuloDTO, Collection<ConfiguracionPlantillaDTO> configuracionPlantillaDTOs, String codigoUsuario, ProveedorDTO proveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param configuracionPlantillaDTO
	 * @param codigoUsuario
	 * @param proveedorDTO
	 * @throws SICException
	 */
	public ArticuloValorConfiguracionPlantillaDTO grabarValoresPlantilla(ArticuloDTO articuloDTO, ConfiguracionPlantillaDTO configuracionPlantillaDTO, String codigoUsuario, ProveedorDTO proveedorDTO, Integer codigoPadreAVCP) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param configuracionPlantillaDTOs
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void actualizarValoresPlantilla(ArticuloDTO articuloDTO, Collection<ConfiguracionPlantillaDTO> configuracionPlantillaDTOs, String codigoUsuario) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param configuracionPlantillaDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void actualizarValoresPlantilla(ArticuloDTO articuloDTO, ConfiguracionPlantillaDTO configuracionPlantillaDTO, String codigoUsuario) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param valorConfiguracionPlantillaDTO
	 * @param valorGrupoCampoPlantillaDTOs
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void actualizarValoresPlantilla(ArticuloDTO articuloDTO, ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Collection<ValorGrupoCampoPlantillaDTO> valorGrupoCampoPlantillaDTOs, String codigoUsuario) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ValorConfiguracionPlantillaDTO> obtenerValorConfiguracionPlantillaByArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, Timestamp fechaInicio, Timestamp fechaFin) throws SICException;
	
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloValorConfiguracionPlantillaDTO> obtenerArticuloValorConfiguracionPlantillaByArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, Timestamp fechaInicio, Timestamp fechaFin) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param proveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarCreacionRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param proveedorDTO
	 * @param codigoUsuario
	 * @return
	 * @throws SICException
	 */
	public Boolean validarEdicionRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, String codigoUsuario) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param proveedorDTO
	 * @param accionRotulado
	 * @return
	 * @throws SICException
	 */
	public Integer diasRestantesCrearControlRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param proveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Integer diasHabilesEdicionControlRotuladoArticulo(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param proveedorDTO
	 * @return
	 * @throws SICException
	 */
	public ArticuloValorConfiguracionPlantillaDTO obtenerUltimoControlRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param codigosConPla
	 * @param fechaRegistroValor
	 * @param valorConfiguracionPlantillaDTO
	 * @param estado
	 * @return
	 * @throws PlantillasException
	 */
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionPlantillas(Set<Integer> codigosConPla, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO, String estado) throws SICException;
	
	/**
	 * 
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO obtenerArticuloPorCodigoBarras(String codigoBarras) throws SICException;
	
	/**
	 * 
	 * @param ArticuloValorConfiguracionPlantillaDTO Un articuloValorConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public ArticuloValorConfiguracionPlantillaDTO actualizarNovedadArticuloValorConfiguracionPlantilla(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, String codigoUsuario, Collection<DetalleGrupoCampoPlantillaDTO> detalleGrupoCampoPlantillaDTOCol, Collection<GrupoCampoPlantillaDTO> grupoCampoPlantillaAuditoriaCol) throws SICException;
	
}
