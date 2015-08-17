/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.masivo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.CaracteristicaDinamicaUtil;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.masivo.IArticuloMasivoGestor;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.masivo.IArticuloMasivoDAO;

/**
 * @author eharo
 *
 */
public class ArticuloMasivoGestor implements IArticuloMasivoGestor, Logeable {
	
	IArticuloMasivoDAO articuloMasivoDAO;

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.masivo.IArticuloMasivoGestor#obtenerMapaClasificacionCarDin(java.lang.Integer, java.util.Set, java.util.Collection)
	 */
	@Override
	public Map<String, Set<EnumCaracteristicaDinamica>> obtenerMapaClasificacionCarDin(Integer codigoCompania, Set<String> listaClasificaciones, Collection<Integer> codigosCaracteristicasDinamicas) throws SICException {
		Map<String, Set<EnumCaracteristicaDinamica>> mapaClasificacionCarDic = null;
		Collection<CaracteristicaDinamicaDTO> lstCaracteristicaDinamicaDTO = null;
		Set<EnumCaracteristicaDinamica> enumCaracteristicaDinamicas = null;
		Collection<CaracteristicaDinamicaDTO> lstCarDinClasificacion = null;
		try{
			if(codigoCompania != null && CollectionUtils.isNotEmpty(listaClasificaciones)){
				mapaClasificacionCarDic = new HashMap<String, Set<EnumCaracteristicaDinamica>>();
				lstCaracteristicaDinamicaDTO = this.articuloMasivoDAO.obtenerCaracteristiacasDinamicas(codigoCompania, listaClasificaciones, codigosCaracteristicasDinamicas);
				if(CollectionUtils.isNotEmpty(lstCaracteristicaDinamicaDTO)){
					for(String clasificacion : listaClasificaciones){
						lstCarDinClasificacion = new ArrayList<CaracteristicaDinamicaDTO>();
						for(CaracteristicaDinamicaDTO dinamicaDTO : lstCaracteristicaDinamicaDTO){
							if(StringUtils.equals(clasificacion, dinamicaDTO.getCodigoClasificacion())){
								lstCarDinClasificacion.add(dinamicaDTO);
							}
						}
						enumCaracteristicaDinamicas = CaracteristicaDinamicaUtil.transformarCaracteristicasDinamicas(lstCarDinClasificacion);
						mapaClasificacionCarDic.put(clasificacion, enumCaracteristicaDinamicas);
					}
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener el mapa de clasificaci\u00F3n y caracter\u00EDsticas ", e.getMessage());
			throw new SICException("Ha ocurrido un error al obtener el mapa de clasificaci\u00F3n y caracter\u00EDsticas ", e.getMessage());
		}
		return mapaClasificacionCarDic;
	}

	
	/**
	 * METODO QUE OBTIENE EL NUMERO DE FILAS INGRESADO EN UN ARCHIVO EXCEL
	 * @param inputStreamArchivo
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	@Override
	public Integer obtenerTamanioFilasArchivoExcel(final InputStream inputStreamArchivo) throws SICException {
		Integer tamanio = null;
		Workbook workbook = null;
		Sheet sheet = null;
		try {
			if (inputStreamArchivo != null) {
				workbook = WorkbookFactory.create(inputStreamArchivo);
				if (workbook != null) {
					sheet = workbook.getSheetAt(0);
					tamanio = sheet.getLastRowNum();
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al obtener el tamanio de las filas del archivo. {}", e.getMessage());
			throw new SICException("Error al obtener el tamanio de las filas del archivo. {}", e.getMessage());
		}
		return tamanio;
	}
	
	
	/*********************************************************************************************/
	/****************************METODOS**SETTER**************************************************/
	/*********************************************************************************************/
	
	
	/**
	 * @param articuloMasivoDAO the articuloMasivoDAO to set
	 */
	public void setArticuloMasivoDAO(IArticuloMasivoDAO articuloMasivoDAO) {
		this.articuloMasivoDAO = articuloMasivoDAO;
	}
}
