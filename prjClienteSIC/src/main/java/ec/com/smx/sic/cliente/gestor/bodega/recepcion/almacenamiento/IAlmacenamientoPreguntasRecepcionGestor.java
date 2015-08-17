package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.plantillas.dto.ConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.DetalleGrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * 
 * @author lguaman
 *
 */
public interface IAlmacenamientoPreguntasRecepcionGestor {

	/**
	 * Guarda los valores de una plantilla
	 * 
	 * @param ConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public ValorConfiguracionPlantillaDTO guardarValoresPlantilla(ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;
	
	/**
	 * Actualizar valores de una plantilla
	 * 
	 * @param ConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public ValorConfiguracionPlantillaDTO actualizarValoresParaEdicion(ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;
	
	/**
	 * Registro del valor de una configuracion plantilla
	 * 
	 * @param ConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public ValorConfiguracionPlantillaDTO guardarValorConfiguracionPlantilla(ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;
	
	/**
	 * Registro de los valores asignados a un grupo plantilla
	 * 
	 * @param String
	 * @param DetalleGrupoCampoPlantillaDTO
	 * @param ValorConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public void guardarValoresGrupoPlantilla(String valor, DetalleGrupoCampoPlantillaDTO dgcp, ValorConfiguracionPlantillaDTO vcp) throws SICException;	
	
	/**
	 * Obtener los datos configurados en una plantilla
	 * 
	 * @param cargarDatos
	 * @param codConfPlantilla
	 * @param codValorPlantilla
	 * @throws SICException
	 */
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionPlantilla(Boolean cargarDatos, Integer codConfPlantilla, Integer codValorPlantilla) throws SICException;	
}
