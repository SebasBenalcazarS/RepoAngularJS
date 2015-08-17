package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.observacion.ArticuloObservacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;


public interface IArticuloRegistroMasivoDAO {
	public void actualizarDatosArticulo(ArticuloEdicionMasivaVO articuloDTO) throws SICException;
	
	public void actualizarTemporadaArticulo(ArticuloEdicionMasivaVO articuloDTO , String fechaInicio , String fechaFin) throws SICException;
	
	public void actualizarArticuloMedida(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException;
	
	public void actualizarArticuloComercial(ArticuloEdicionMasivaVO articuloEdicionMasivaVO)throws SICException;
	
	public String actualizarMarcaComercialInternamente(ArticuloEdicionMasivaVO articuloEdicionMasivaVO)throws SICException;
	
	public void actualizarReferenciaProveedor(ArticuloEdicionMasivaVO articuloEdicionMasivaVO) throws SICException;
	
	public String actualizarValorTipoControlCosto(ArticuloEdicionMasivaVO articuloEdicionMasivaVO)throws SICException;
	
	public void actualizarProveedorInternamente(ArticuloEdicionMasivaVO articuloEdicionMasivaVO) throws SICException;
	
	public Collection<String> obtenerCodigosProveedores(ArticuloEdicionMasivaVO articuloEdicionMasivaVO , Boolean esImportado)throws SICException;
	
	public Integer contarArticuloImportacion(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException;
	
	public void registrarArticuloImportacion(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException;
	
	public void actualizarArticuloImportacion(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException;
	
	public void registrarArticuloPendienteIntegracion(Integer codigoCompania , String codigoArticulo , String usuarioModificacion , String valorTipoProceso)throws SICException;
	
	public void actualizarDatosDuracionConservacion(ArticuloEdicionMasivaVO articuloEdicionVO , Integer codigoTipoConservacion, String valorTipoConservacion, Integer valorVidaUtil)throws SICException;
	
	public void actualizarArticuloMaterial(ArticuloEdicionMasivaVO articuloEdicionVO, Integer codigoTipoMaterial , String valorTipoMaterial)throws SICException;
	
	public void actualizarArticuloAgrupador(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException;
	
	public void inactivarAgrupadorArticulo(ArticuloEdicionMasivaVO articuloEdicionVO)throws SICException;
	
	public void actualizarPrototipoArticulo(ArticuloEdicionMasivaVO articuloDTO) throws SICException;
		
	/**
	 * Registra o actualiza el uso de los articulos (articuloImpuesto) desde la edicion masiva
	 * @param articuloImpuestoDTO
	 * @throws SICException
	 */
	void registrarActualizarArticuloImpuesto(ArticuloImpuestoDTO articuloImpuestoDTO) throws SICException;
	
	public String registrarImpuestosInternamente(ArticuloImpuestoDTO articuloImpuestoDTO) throws SICException;
	
	public Boolean validarValoresArticuloClase(ArticuloEdicionMasivaVO articuloEdicionMasivaVO) throws SICException;
	
	public Boolean validarCaracteristicaDinamica(ArticuloEdicionMasivaVO articuloEdicionMasivaVO , Integer tipoCaracteristica , String valorTipoCaracteristica) throws SICException;
	
	void crearOActualizarCaracteristicaEspecial(ArticuloEdicionMasivaVO articuloEdicionVO) throws SICException;
	
	public void registrarAuditoriaArticulo(ArticuloEdicionMasivaVO articuloDTO ) throws SICException;
	
	public Boolean verificarExistenciaAuditoriaExtendida(Integer codigoCompania , String codigoArticulo) throws SICException;
	
	public void registrarAuditoriaExtendida(Integer codigoCompania , String codigoArticulo , String codigoSistema , String codigoOpcion) throws SICException;
	
	public void actualizarAuditoriaExtendida(Integer codigoCompania , String codigoArticulo , String codigoSistema , String codigoOpcion) throws SICException;
	
	public void registrarArticuloObservacion(String codigoBarras , String observaciones , String usuarioModificacion , Long fechaModificacion) throws SICException;
	
	public Collection<ArticuloObservacionDTO> obtenerArticuloObservacion(String usuarioModificacion , Long fechaModificacion) throws SICException;
	
	public void removerArticuloObservacion(String usuarioModificacion , Long fechaModificacion) throws SICException;
}
