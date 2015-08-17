package ec.com.smx.sic.articulo.servicio;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.corpv2.plantillas.dto.ConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.DetalleGrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.GrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorGrupoCampoPlantillaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.rotulado.IArticuloRotuladoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.rotulado.IArticuloRotuladoReporteGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloValorConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio;

public class ArticuloRotuladoServicio implements IArticuloRotuladoServicio {

	private IArticuloRotuladoGestor articuloRotuladoGestor;
	
	private IArticuloRotuladoReporteGestor articuloRotuladoReporteGestor;
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.obtenerPlantillasByClasificacion(String)
	 */
	@Override
	public Collection<ClasificacionConfiguracionPlantillaDTO> obtenerPlantillasByClasificacion(String codigoClasificacion) throws SICException {
		Collection<ClasificacionConfiguracionPlantillaDTO> coll = articuloRotuladoGestor.obtenerClasificacionConfiguracionPlantillaByClasificacion(codigoClasificacion); 
		return coll;
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transRegistrarClasificacionConfiguracionPlantilla(ClasificacionConfiguracionPlantillaDTO)
	 */
	@Override
	public void transRegistrarClasificacionConfiguracionPlantilla(ClasificacionConfiguracionPlantillaDTO ccp) throws SICException {
		articuloRotuladoGestor.registrarClasificacionConfiguracionPlantilla(ccp);
	}
	
	@Override
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionesPlantillaByArticulo(ArticuloDTO articulo, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO, Integer codigoCompania, String estado) throws SICException {
		Collection<ConfiguracionPlantillaDTO> coll = articuloRotuladoGestor.obtenerConfiguracionesPlantillaByArticulo(articulo, valorConfiguracionPlantillaDTO, codigoCompania, estado); 
		return coll;
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.obtenerConfiguracionPlantillas(Set<Integer>, ValorConfiguracionPlantillaDTO, String)
	 */
	@Override
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionPlantillas(Set<Integer> codigosConPla, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO, String estado) throws SICException {
		Collection<ConfiguracionPlantillaDTO> coll = articuloRotuladoGestor.obtenerConfiguracionPlantillas(codigosConPla, valorConfiguracionPlantillaDTO, estado); 
		return coll;
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transGrabarValoresPlantilla(ArticuloDTO, Collection<ConfiguracionPlantillaDTO>, String, ProveedorDTO)
	 */
	@Override
	public void transGrabarValoresPlantilla(ArticuloDTO articuloDTO, Collection<ConfiguracionPlantillaDTO> configuracionPlantillaDTOs, String codigoUsuario, ProveedorDTO proveedorDTO) throws SICException {
		articuloRotuladoGestor.grabarValoresPlantilla(articuloDTO, configuracionPlantillaDTOs, codigoUsuario, proveedorDTO);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transGrabarValoresPlantilla(ArticuloDTO, ConfiguracionPlantillaDTO, String, ProveedorDTO)
	 */
	@Override
	public ArticuloValorConfiguracionPlantillaDTO transGrabarValoresPlantilla(ArticuloDTO articuloDTO, ConfiguracionPlantillaDTO configuracionPlantillaDTO, String codigoUsuario, ProveedorDTO proveedorDTO, Integer codigoPadreAVCP) throws SICException {
		return articuloRotuladoGestor.grabarValoresPlantilla(articuloDTO, configuracionPlantillaDTO, codigoUsuario, proveedorDTO, codigoPadreAVCP);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transActualizarValoresPlantilla(ArticuloDTO, Collection<ConfiguracionPlantillaDTO>, String)
	 */
	@Override
	public void transActualizarValoresPlantilla(ArticuloDTO articuloDTO, Collection<ConfiguracionPlantillaDTO> configuracionPlantillaDTOs, String codigoUsuario) throws SICException {
		articuloRotuladoGestor.actualizarValoresPlantilla(articuloDTO, configuracionPlantillaDTOs, codigoUsuario);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transActualizarValoresPlantilla(ArticuloDTO, ConfiguracionPlantillaDTO, String)
	 */
	@Override
	public void transActualizarValoresPlantilla(ArticuloDTO articuloDTO, ConfiguracionPlantillaDTO configuracionPlantillaDTO, String codigoUsuario) throws SICException {
		articuloRotuladoGestor.actualizarValoresPlantilla(articuloDTO, configuracionPlantillaDTO, codigoUsuario);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transActualizarValoresPlantilla(ArticuloDTO, ValorConfiguracionPlantillaDTO, Collection<ValorGrupoCampoPlantillaDTO>, String)
	 */
	@Override
	public void transActualizarValoresPlantilla(ArticuloDTO articuloDTO, ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Collection<ValorGrupoCampoPlantillaDTO> valorGrupoCampoPlantillaDTOs, String codigoUsuario) throws SICException {
		articuloRotuladoGestor.actualizarValoresPlantilla(articuloDTO, articuloValorConfiguracionPlantillaDTO, valorGrupoCampoPlantillaDTOs, codigoUsuario);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transObtenerValorConfiguracionPlantillaByArticulo(ArticuloDTO, ProveedorDTO, Timestamp, Timestamp)
	 */
	@Override
	public Collection<ValorConfiguracionPlantillaDTO> transObtenerValorConfiguracionPlantillaByArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, Timestamp fechaInicio, Timestamp fechaFin) throws SICException {
		return articuloRotuladoGestor.obtenerValorConfiguracionPlantillaByArticulo(articuloDTO, proveedorDTO, fechaInicio, fechaFin);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transObtenerArticuloValorConfiguracionPlantillaByArticulo(ArticuloDTO, ProveedorDTO, Timestamp, Timestamp)
	 */
	@Override
	public Collection<ArticuloValorConfiguracionPlantillaDTO> transObtenerArticuloValorConfiguracionPlantillaByArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, Timestamp fechaInicio, Timestamp fechaFin) throws SICException {
		return articuloRotuladoGestor.obtenerArticuloValorConfiguracionPlantillaByArticulo(articuloDTO, proveedorDTO, fechaInicio, fechaFin);
	}
	
	/**
	 * @return the articuloRotuladoGestor
	 */
	public IArticuloRotuladoGestor getArticuloRotuladoGestor() {
		return articuloRotuladoGestor;
	}

	/**
	 * @param articuloRotuladoGestor the articuloRotuladoGestor to set
	 */
	public void setArticuloRotuladoGestor(IArticuloRotuladoGestor articuloRotuladoGestor) {
		this.articuloRotuladoGestor = articuloRotuladoGestor;
	}
	
	/**
	 * @return the articuloRotuladoReporteGestor
	 */
	public IArticuloRotuladoReporteGestor getArticuloRotuladoReporteGestor() {
		return articuloRotuladoReporteGestor;
	}

	/**
	 * @param articuloRotuladoReporteGestor the articuloRotuladoReporteGestor to set
	 */
	public void setArticuloRotuladoReporteGestor(IArticuloRotuladoReporteGestor articuloRotuladoReporteGestor) {
		this.articuloRotuladoReporteGestor = articuloRotuladoReporteGestor;
	}

	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.validarCreacionRotuladoArticulo(ArticuloDTO, ProveedorDTO, String)
	 */
	public Boolean validarCreacionRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException {
		return articuloRotuladoGestor.validarCreacionRotuladoArticulo(articuloDTO, proveedorDTO);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.validarEdicionRotuladoArticulo(ArticuloDTO, ProveedorDTO, String)
	 */
	public Boolean validarEdicionRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, String codigoUsuario) throws SICException {
		return articuloRotuladoGestor.validarEdicionRotuladoArticulo(articuloDTO, proveedorDTO, codigoUsuario);
	}

	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.diasRestantesCrearControlRotuladoArticulo(ArticuloDTO, ProveedorDTO)
	 */
	@Override
	public Integer diasRestantesCrearControlRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException {
		return articuloRotuladoGestor.diasRestantesCrearControlRotuladoArticulo(articuloDTO, proveedorDTO);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.obtenerUltimoControlRotuladoArticulo(ArticuloDTO, ProveedorDTO)
	 */
	@Override
	public ArticuloValorConfiguracionPlantillaDTO obtenerUltimoControlRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException {
		return articuloRotuladoGestor.obtenerUltimoControlRotuladoArticulo(articuloDTO, proveedorDTO);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.diasHabilesEdicionControlRotuladoArticulo(ArticuloValorConfiguracionPlantillaDTO)
	 */
	@Override
	public Integer diasHabilesEdicionControlRotuladoArticulo(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO) throws SICException {
		return articuloRotuladoGestor.diasHabilesEdicionControlRotuladoArticulo(articuloValorConfiguracionPlantillaDTO);
	}
	
	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.obtenerArticuloPorCodigoBarras(String)
	 */
	@Override
	public ArticuloDTO obtenerArticuloPorCodigoBarras(String codigoBarras) throws SICException {
		return articuloRotuladoGestor.obtenerArticuloPorCodigoBarras(codigoBarras);
	}

	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.obtenerReporteControlRotulado(ArticuloValorConfiguracionPlantillaDTO,Set<Integer>)
	 */
	@Override
	public Collection<ArticuloValorConfiguracionPlantillaDTO> obtenerReporteControlRotulado(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Set<Integer> codigosPreguntas, Timestamp fechaInicio, Timestamp fechaFin) throws SICException {
		return articuloRotuladoReporteGestor.obtenerReporteControlRotulado(articuloValorConfiguracionPlantillaDTO, codigosPreguntas, fechaInicio, fechaFin);
	}

	/**
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio.transActualizarNovedadArticuloValorConfiguracionPlantilla(ArticuloValorConfiguracionPlantillaDTO, String, Collection<DetalleGrupoCampoPlantillaDTO>)
	 */
	@Override
	public ArticuloValorConfiguracionPlantillaDTO transActualizarNovedadArticuloValorConfiguracionPlantilla(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, String codigoUsuario, Collection<DetalleGrupoCampoPlantillaDTO> detalleGrupoCampoPlantillaDTOCol, Collection<GrupoCampoPlantillaDTO> grupoCampoPlantillaAuditoriaCol) throws SICException {
		return articuloRotuladoGestor.actualizarNovedadArticuloValorConfiguracionPlantilla(articuloValorConfiguracionPlantillaDTO, codigoUsuario, detalleGrupoCampoPlantillaDTOCol, grupoCampoPlantillaAuditoriaCol);
	}
}
