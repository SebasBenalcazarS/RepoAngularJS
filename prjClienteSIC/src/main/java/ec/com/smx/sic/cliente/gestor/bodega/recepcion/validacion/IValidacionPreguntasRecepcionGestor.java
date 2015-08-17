package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Collection;

import ec.com.smx.corpv2.plantillas.dto.ConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.DetalleGrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.GrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IValidacionPreguntasRecepcionGestor {

	/**
	 * 
	 * @param Collection<GrupoCampoPlantillaDTO>
	 * @param Boolean
	 * @param Integer
	 * @param ConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public abstract void guardarValoresPlantilla(Collection<GrupoCampoPlantillaDTO> listaGrupoCampoPla, Boolean modoEdicion, Integer codValorPlantilla, ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;
	
	/**
	 * 
	 * @param ConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public abstract void guardarValorConfiguracionPlantilla(ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;		
	
	/**
	 * 
	 * @param String
	 * @param DetalleGrupoCampoPlantillaDTO
	 * @param ValorConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public void guardarValoresGrupoPlantilla(String valor, DetalleGrupoCampoPlantillaDTO dgcp, ValorConfiguracionPlantillaDTO vcp) throws SICException;
	
	/**
	 * 
	 * @param ConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	public abstract void actualizarValoresParaEdicion(ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;	
}