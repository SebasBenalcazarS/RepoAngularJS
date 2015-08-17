package ec.com.smx.sic.cliente.gestor.articulo.admin;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;

public interface IArticuloEdicionMasivaGestor {
	public String registrarArticulo(Collection<ArticuloEdicionMasivaVO> articuloCol, Boolean envioMail) throws SICException;
	
	public void registrarArticuloMasivamente(ArticuloEdicionMasivaVO articulo)throws SICException;
	
	public void registroArticulosMasivoInterno(String sqlQuery , ArticuloEdicionMasivaVO plantillaRegistro , String usuarioModificacion , Integer numArticulos , String fechaModificacion , Integer codigoCompania)throws SICException;
	
	public void registrarArticuloIntegracion(ArticuloEdicionMasivaVO articulo)throws SICException;
	
	public Integer consultarNumeroArticulosRegistrados(String sqlQuery) throws SICException;
	
	public void registrarArticuloInternamente(Collection<ArticuloEdicionMasivaVO> articuloCol , Integer totalArticulos , Long fechaModificacion)throws SICException;
	
	/**
	 * Envia un mail luego de procesarlos articulos que hayan sido modificados sus prototipos
	 * @param codigoCompania
	 * @param userId
	 * @param articulosNoRegistrados
	 * @param datosRegistrados
	 * @throws SICException
	 */
	void envioMailEdicionMasivaArticulo(Integer codigoCompania, String userId, Collection<ArticuloEdicionMasivaVO> articulosNoRegistrados , Boolean datosRegistrados)throws SICException;
	
	void envioMailEdicionInternaArticulo(Integer codigoCompania, String userId, Integer datosRegistrados , Long fechaModificacion)throws SICException;
	
	public void registrarAuditoriaExtendida(Integer codigoCompania , String codigoArticulo , String codigoSistema , String codigoOpcion) throws SICException;
}
