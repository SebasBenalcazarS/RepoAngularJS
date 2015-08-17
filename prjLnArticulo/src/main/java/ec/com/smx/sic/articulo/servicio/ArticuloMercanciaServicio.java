/**
 * 
 */
package ec.com.smx.sic.articulo.servicio;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.annotations.NoTransaction;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.generadorexportacion.estructura.InfoRecepcionEST;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.garantia.IArticuloGarantiaGestor;
import ec.com.smx.sic.cliente.gestor.articulo.mercancias.IArticuloMercanciaGestor;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoCaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.GarantiaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.EtiquetaMercanciaVO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloMercanciaServicio;

/**
 * @author eharo
 *
 */
public class ArticuloMercanciaServicio implements IArticuloMercanciaServicio, Logeable {
	IArticuloMercanciaGestor articuloMercanciaGestor;
	IArticuloGarantiaGestor articuloGarantiaGestor;

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloMercanciaServicio#obtenerListaTipoCaracteristicas(java.lang.Integer)
	 */
	@Override
	public List<TipoCaracteristicaDTO> obtenerListaTipoCaracteristicas(Integer codigoCompania) throws SICException {
		return this.articuloMercanciaGestor.obtenerListaTipoCaracteristicas(codigoCompania);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloMercanciaServicio#obtenerListaCaracteristicas(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<CaracteristicaDTO> obtenerListaCaracteristicas(Integer codigoCompania, Collection<Integer> tipoCaracteristicaId, String codigoArticulo) throws SICException {
		return this.articuloMercanciaGestor.obtenerListaCaracteristicas(codigoCompania, tipoCaracteristicaId, codigoArticulo);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloMercanciaServicio#transGuardarCaracteristicas(java.lang.Integer, java.util.List)
	 */
	@Override
	public void transGuardarCaracteristicas(String usuario, List<CaracteristicaDTO> lstCaracteristicas) throws SICException {
		this.articuloMercanciaGestor.transGuardarCaracteristicas(usuario, lstCaracteristicas);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloMercanciaServicio#transEliminarCaracteristica(ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO)
	 */
	@Override
	public void transEliminarCaracteristica(String usuario, Set<CaracteristicaDTO> caracteristicasEliminar) throws SICException {
		this.articuloMercanciaGestor.transEliminarCaracteristica(usuario, caracteristicasEliminar);
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloMercanciaServicio#obtenerRangosGE(ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO, java.lang.Double)
	 */
	@Override
	public Collection<ArticuloRangoExtensionGarantiaDTO> obtenerRangosGE(ArticuloRangoExtensionGarantiaDTO rangoExtensionGarantiaDTO, Double precioBaseImp) throws SICException {
		return this.articuloGarantiaGestor.obtenerRangosGE(rangoExtensionGarantiaDTO, precioBaseImp);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloMercanciaServicio#buscarPrecioExtension(java.util.Collection, java.lang.Double)
	 */
	@Override
	public Collection<GarantiaArticuloDTO> buscarPrecioExtension(Collection<ArticuloRangoExtensionGarantiaDTO> rangosGE, Double precioBaseImp) throws SICException {
		return this.articuloGarantiaGestor.buscarPrecioExtension(rangosGE, precioBaseImp);
	}
	
	public Collection<EtiquetaMercanciaVO> obtenerEtiquetaCaracteristicaMasivaCol(Integer codigoCompania,Collection<String> codigoArtBarCol, Boolean esCodigoBarra, Integer areaTrabajoFuncionario,String codigoClasificacion) throws SICException{
		return this.articuloMercanciaGestor.obtenerEtiquetaCaracteristicaMasivaCol(codigoCompania, codigoArtBarCol,esCodigoBarra, areaTrabajoFuncionario,codigoClasificacion);
	}
	/***************************************************************************************************************************************/
	/**************************************METODOS**SETTER**********************************************************************************/
	/***************************************************************************************************************************************/
	
	

	/**
	 * @param articuloMercanciaGestor the articuloMercanciaGestor to set
	 */
	public void setArticuloMercanciaGestor(IArticuloMercanciaGestor articuloMercanciaGestor) {
		this.articuloMercanciaGestor = articuloMercanciaGestor;
	}

	/**
	 * @param articuloGarantiaGestor the articuloGarantiaGestor to set
	 */
	public void setArticuloGarantiaGestor(IArticuloGarantiaGestor articuloGarantiaGestor) {
		this.articuloGarantiaGestor = articuloGarantiaGestor;
	}

	@Override
	public Collection<EtiquetaMercanciaVO> obtenerEtiquetaMercanciaMasivaPaginada(Integer first, Integer pageSize, Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException{
		return this.articuloMercanciaGestor.obtenerEtiquetaMercanciaMasivaPaginada(first, pageSize, codigoCompania, areaTrabajo, codigoClasificacion, promocion);

	}

	@Override
	public Integer totalRegistrosEtiquetaMercanciaMasiva(Integer codigoCompania, Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException {
		Integer totalRegistros = this.articuloMercanciaGestor.totalRegistrosEtiquetaMercanciaMasiva(codigoCompania, areaTrabajo, codigoClasificacion, promocion);
		return totalRegistros;
	}
	
	/**
	 * @author aquingaluisa
	 * Copia y modificacion del metodo original en el proyecto de mercancias
	 * Metodo que procesa un archivo inputstream con generación exportación al objeto deseado dado el codigo del formato
	 * @param usuario
	 * @param codigoFormato
	 * @param archivoImportacion
	 * @param archivoImportacionF
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	@NoTransaction
	public InfoRecepcionEST obtenerEstructuraDesdeArchivo(String usuario, String codigoFormato, InputStream archivoImportacion, File archivoImportacionF, String codigoCompania) throws SICException{
		return this.articuloMercanciaGestor.obtenerEstructuraDesdeArchivo(usuario, codigoFormato, archivoImportacion, archivoImportacionF, codigoCompania);
	}
	
	/**
	 * Metodo para obtner las clasificacion de un funcionario
	 * @param funcionario
	 * @return
	 * @throws SICException
	 */
	public Collection<String> obtenerCodigosClasificacionFuncionario(FuncionarioDTO funcionario,Boolean tieneLineaComercial) throws SICException{
		return this.articuloMercanciaGestor.obtenerCodigosClasificacionFuncionario(funcionario, tieneLineaComercial);
	}
}
