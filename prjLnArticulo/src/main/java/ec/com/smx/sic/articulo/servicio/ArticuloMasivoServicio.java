/**
 * 
 */
package ec.com.smx.sic.articulo.servicio;

import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.com.kruger.utilitario.dao.commons.annotations.NoTransaction;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloCreacionPorArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IArticuloEdicionArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloCreacionPorArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.masivo.IArticuloMasivoGestor;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloMasivoServicio;

/**
 * @author eharo
 *
 */
public class ArticuloMasivoServicio implements IArticuloMasivoServicio {
	
	private IArticuloMasivoGestor articuloMasivoGestor;
	private IArticuloEdicionArchivoGestor articuloEdicionArchivoGestor;
	private IArticuloCreacionPorArchivoGestor articuloCreacionPorArchivoGestor;
	private IValidacionArticuloCreacionPorArchivoGestor articuloValidacionCreacionPorArchivoGestor;
	

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloMasivoServicio#obtenerMapaClasificacionCarDin(java.lang.Integer, java.util.Set, java.util.Collection)
	 */
	@Override
	public Map<String, Set<EnumCaracteristicaDinamica>> obtenerMapaClasificacionCarDin(Integer codigoCompania, Set<String> listaClasificaciones, Collection<Integer> codigosCaracteristicasDinamicas) throws SICException {
		return this.articuloMasivoGestor.obtenerMapaClasificacionCarDin(codigoCompania, listaClasificaciones, codigosCaracteristicasDinamicas);
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
		return this.articuloMasivoGestor.obtenerTamanioFilasArchivoExcel(inputStreamArchivo);
	}
	
	
	/**
	 * CREACION ARTICULO POR ARCHIVO INICIO
	 */
	@Override
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoArticulo(ArticuloVO articuloVOPlantillaValores, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException {
		return this.articuloValidacionCreacionPorArchivoGestor.procesarArchivoArticulo(articuloVOPlantillaValores, inputStreamArchivo, tipoCabeceras);
	}
	@Override
	public void obtenerCabeceraArchivoArticulo(XSSFWorkbook wb, XSSFSheet sheet, Integer tipoCabecera) throws SICException {
		this.articuloValidacionCreacionPorArchivoGestor.obtenerCabeceraArchivo(wb, sheet, tipoCabecera);
	}

	@NoTransaction
	public void realizarCreacionArticuloPorArchivo(ArticuloVO articuloVOPlantillaValores, Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos, String nombreArchivo)throws SICException{
		this.articuloCreacionPorArchivoGestor.realizarCreacionArticuloPorArchivo(articuloVOPlantillaValores,datosValidos, nombreArchivo);
	}
	
	public void crearArticuloPorArchivo(ArticuloVO articuloVO) throws SICException {
		this.articuloCreacionPorArchivoGestor.crearArticulo(articuloVO);		
	}
	@SuppressWarnings("rawtypes")
	@Override
	public ArticuloVO obtenerDatosArticuloVO(ArticuloVO articuloVOPlantillaValores, Integer key, MultiKeyMap datosValidos, LinkedHashMap[] objectListCarDin) throws SICException {
		return this.articuloCreacionPorArchivoGestor.obtenerDatosArticuloVO(articuloVOPlantillaValores, key, datosValidos, objectListCarDin);
	}
	@Override
	public void envioMailCreacionArticuloPorArchivo(Integer codigoCompania, String userId, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo) throws SICException {
		this.articuloCreacionPorArchivoGestor.envioMailCreacionArticuloPorArchivo(codigoCompania, userId, articulosNoRegistrados, totalArticulosRegistrados, fechaCreacion, nombreArchivo);
	}
	/**
	 * CREACION ARTICULO POR ARCHIVO FIN
	 */
	

	/**
	 * EDICION ARTICULO POR ARCHIVO INICIO
	 */
	
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#procesarArchivoArticulo(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO, java.io.InputStream, java.lang.Integer)
	 */
	@Override
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoEdicionArticulo(ArticuloVO articuloVO, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException {
		return this.articuloEdicionArchivoGestor.procesarArchivoEdicionArticulo(articuloVO, articuloEdicionMasivaArchivoVO, inputStreamArchivo, tipoCabeceras);
	}
	
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#realizarEdicionArticuloPorArchivo(ec.com.smx.sic.cliente.mdl.vo.ArticuloVO, ec.com.smx.framework.common.util.dto.Duplex, java.lang.String)
	 */
	@Override
	@NoTransaction
	public void realizarEdicionArticuloPorArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos, String nombreArchivo) throws SICException {
		this.articuloEdicionArchivoGestor.realizarEdicionArticuloPorArchivo(articuloEdicionMasivaArchivoVO, datosValidos, nombreArchivo);
	}
	

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#editarArticuloArchivo(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO)
	 */
	@Override
	public Integer editarArticuloArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException {
		return this.articuloEdicionArchivoGestor.editarArticuloArchivo(articuloEdicionMasivaArchivoVO);
	}
	
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#envioMailEdicionArticuloPorArchivo(java.lang.Integer, java.lang.String, java.util.Set, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public void envioMailEdicionArticuloPorArchivo(Integer codigoCompania, String userId, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo) throws SICException {
		this.articuloEdicionArchivoGestor.envioMailEdicionArticuloPorArchivo(codigoCompania, userId, articulosNoRegistrados, totalArticulosRegistrados, fechaCreacion, nombreArchivo);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#obtnerArticuloEdicionMasivaVO(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO, java.lang.Integer, org.apache.commons.collections.map.MultiKeyMap)
	 */
	@Override
	public ArticuloEdicionMasivaArchivoVO obtnerArticuloEdicionMasivaVO(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Integer key, MultiKeyMap datosListaValidos) throws SICException {
		return this.articuloEdicionArchivoGestor.obtnerArticuloEdicionMasivaVO(articuloEdicionMasivaArchivoVO, key, datosListaValidos);
	}
	
	/**
	 * EDICION ARTICULO POR ARCHIVO FIN
	 */
	
	/*********************************************************************************************/
	/****************************METODOS**SETTER**************************************************/
	/*********************************************************************************************/
	
	/**
	 * @param articuloMasivoGestor the articuloMasivoGestor to set
	 */
	public void setArticuloMasivoGestor(IArticuloMasivoGestor articuloMasivoGestor) {
		this.articuloMasivoGestor = articuloMasivoGestor;
	}


	/**
	 * @param articuloEdicionArchivoGestor the articuloEdicionArchivoGestor to set
	 */
	public void setArticuloEdicionArchivoGestor(IArticuloEdicionArchivoGestor articuloEdicionArchivoGestor) {
		this.articuloEdicionArchivoGestor = articuloEdicionArchivoGestor;
	}


	/**
	 * @param articuloCreacionPorArchivoGestor the articuloCreacionPorArchivoGestor to set
	 */
	public void setArticuloCreacionPorArchivoGestor(IArticuloCreacionPorArchivoGestor articuloCreacionPorArchivoGestor) {
		this.articuloCreacionPorArchivoGestor = articuloCreacionPorArchivoGestor;
	}


	/**
	 * @param articuloValidacionCreacionPorArchivoGestor the articuloValidacionCreacionPorArchivoGestor to set
	 */
	public void setArticuloValidacionCreacionPorArchivoGestor(IValidacionArticuloCreacionPorArchivoGestor articuloValidacionCreacionPorArchivoGestor) {
		this.articuloValidacionCreacionPorArchivoGestor = articuloValidacionCreacionPorArchivoGestor;
	}
}
