/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.articulo;

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
 * @author kruger
 *
 */
public interface IArticuloRotuladoServicio {

	/**
	 * 
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionConfiguracionPlantillaDTO> obtenerPlantillasByClasificacion(String codigoClasificacion) throws SICException;
	
	/**
	 * 
	 * @param ccp
	 * @throws SICException
	 */
	public void transRegistrarClasificacionConfiguracionPlantilla(ClasificacionConfiguracionPlantillaDTO ccp) throws SICException;
	
	/**
	 * 
	 * @param articulo
	 * @param valorConfiguracionPlantillaDTO
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionesPlantillaByArticulo(ArticuloDTO articulo, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO, Integer codigoCompania, String estado) throws SICException;
	
	/**
	 * 
	 * @param codigosConPla
	 * @param fechaRegistroValor
	 * @param valorConfiguracionPlantillaDTO
	 * @param estado
	 * @return
	 * @throws SICException
	 */
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionPlantillas(Set<Integer> codigosConPla, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO, String estado) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param configuracionPlantillaDTOs
	 * @param codigoUsuario
	 * @param proveedorDTO
	 * @throws SICException
	 */
	public void transGrabarValoresPlantilla(ArticuloDTO articuloDTO, Collection<ConfiguracionPlantillaDTO> configuracionPlantillaDTOs, String codigoUsuario, ProveedorDTO proveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param configuracionPlantillaDTO
	 * @param codigoUsuario
	 * @param proveedorDTO
	 * @throws SICException
	 */
	public ArticuloValorConfiguracionPlantillaDTO transGrabarValoresPlantilla(ArticuloDTO articuloDTO, ConfiguracionPlantillaDTO configuracionPlantillaDTO, String codigoUsuario, ProveedorDTO proveedorDTO, Integer codigoPadreAVCP) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param configuracionPlantillaDTOs
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void transActualizarValoresPlantilla(ArticuloDTO articuloDTO, Collection<ConfiguracionPlantillaDTO> configuracionPlantillaDTOs, String codigoUsuario) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param configuracionPlantillaDTOs
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void transActualizarValoresPlantilla(ArticuloDTO articuloDTO, ConfiguracionPlantillaDTO configuracionPlantillaDTOs, String codigoUsuario) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param valorConfiguracionPlantillaDTO
	 * @param valorGrupoCampoPlantillaDTOs
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void transActualizarValoresPlantilla(ArticuloDTO articuloDTO, ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Collection<ValorGrupoCampoPlantillaDTO> valorGrupoCampoPlantillaDTOs, String codigoUsuario) throws SICException;
	
	/**
	 * 
	 * @param articuloValorConfiguracionPlantillaDTO Instancia del control de rotulado
	 * @param codigoUsuario Codigo del usuario de registro
	 * @param detalleGrupoCampoPlantillaDTOCol Valores de la plantilla de rotulado para el control de auditoria
	 * @throws SICException
	 */
	public ArticuloValorConfiguracionPlantillaDTO transActualizarNovedadArticuloValorConfiguracionPlantilla(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, String codigoUsuario, Collection<DetalleGrupoCampoPlantillaDTO> detalleGrupoCampoPlantillaDTOCol, Collection<GrupoCampoPlantillaDTO> grupoCampoPlantillaAuditoriaCol) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param proveedorDTO
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 * @throws SICException
	 */
	public Collection<ValorConfiguracionPlantillaDTO> transObtenerValorConfiguracionPlantillaByArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, Timestamp fechaInicio, Timestamp fechaFin) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param proveedorDTO
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloValorConfiguracionPlantillaDTO> transObtenerArticuloValorConfiguracionPlantillaByArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, Timestamp fechaInicio, Timestamp fechaFin) throws SICException;
	
	
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
	 * @param codigoUsuario
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
	public ArticuloValorConfiguracionPlantillaDTO obtenerUltimoControlRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloValorConfiguracionPlantillaDTO
	 * @return
	 * @throws SICException
	 */
	public Integer diasHabilesEdicionControlRotuladoArticulo(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO) throws SICException;
	
	/**
	 * 
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO obtenerArticuloPorCodigoBarras(String codigoBarras) throws SICException;
	
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloValorConfiguracionPlantillaDTO> obtenerReporteControlRotulado(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Set<Integer> codigosPreguntas, Timestamp fechaInicio, Timestamp fechaFin) throws SICException;
	
}
