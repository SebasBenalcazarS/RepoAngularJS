package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.TransportistaDTO;
import ec.com.smx.corpv2.dto.VehiculoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ChoferDTO;
import ec.com.smx.sic.cliente.mdl.dto.GuiaTransporteDTO;
import ec.com.smx.sic.cliente.mdl.dto.GuiaTransporteDocumentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VehiculoChoferDTO;
import ec.com.smx.sic.cliente.mdl.dto.VehiculoFurgonDTO;


public class VehiculosVO extends BaseVO<VehiculoDTO>{


	private static final long serialVersionUID = 1L;

	private Collection<VehiculoChoferDTO> listaChoferes;
	private ChoferDTO choferDTO;
	private Boolean desactivarControles;
	private String tipoChofer;
	private TransportistaDTO transportistaDTO;
	private AreaTrabajoDTO areaTrabajoLocal;
	private BodegaDTO bodega;
	private Integer codigoReferencia;
	
	private GuiaTransporteDTO guiaTransporteDTO;
//	private GuiaTransporteDestinoDTO guiaTransporteDestinoDTO;
//	private Collection<GuiaTransporteDestinoDTO> listaGuiaTransporteDestinoCols;
	private GuiaTransporteDocumentoDTO guiaTransporteDocumentoDTO;
	private Collection<GuiaTransporteDocumentoDTO> listaGuiaTransporteDocumentoCols;
	private Collection<VehiculoChoferDTO> listaChoferesPrincipal;
	private Collection<VehiculoChoferDTO> listaChoferesAyudante;
	private VehiculoFurgonDTO vehiculoFurgonDTO;
	
	/**
	 * @return the tipoChofer
	 */
	public String getTipoChofer() {
		return tipoChofer;
	}
	/**
	 * @param tipoChofer the tipoChofer to set
	 */
	public void setTipoChofer(String tipoChofer) {
		this.tipoChofer = tipoChofer;
	}
	/**
	 * @return the listaChoferes
	 */
	public Collection<VehiculoChoferDTO> getListaChoferes() {
		return listaChoferes;
	}
	/**
	 * @param listaChoferes the listaChoferes to set
	 */
	public void setListaChoferes(Collection<VehiculoChoferDTO> listaChoferes) {
		this.listaChoferes = listaChoferes;
	}
	/**
	 * @return the choferDTO
	 */
	public ChoferDTO getChoferDTO() {
		return choferDTO;
	}
	/**
	 * @param choferDTO the choferDTO to set
	 */
	public void setChoferDTO(ChoferDTO choferDTO) {
		this.choferDTO = choferDTO;
	}
	/**
	 * @return the desactivarControles
	 */
	public Boolean getDesactivarControles() {
		return desactivarControles;
	}
	/**
	 * @param desactivarControles the desactivarControles to set
	 */
	public void setDesactivarControles(Boolean desactivarControles) {
		this.desactivarControles = desactivarControles;
	}
	/**
	 * @return the guiaTransporteDTO
	 */
	public GuiaTransporteDTO getGuiaTransporteDTO() {
		return guiaTransporteDTO;
	}
	/**
	 * @param guiaTransporteDTO the guiaTransporteDTO to set
	 */
	public void setGuiaTransporteDTO(GuiaTransporteDTO guiaTransporteDTO) {
		this.guiaTransporteDTO = guiaTransporteDTO;
	}
	/**
	 * @return the guiaTransporteDestinoDTO
	 */
//	public GuiaTransporteDestinoDTO getGuiaTransporteDestinoDTO() {
//		return guiaTransporteDestinoDTO;
//	}
//	/**
//	 * @param guiaTransporteDestinoDTO the guiaTransporteDestinoDTO to set
//	 */
//	public void setGuiaTransporteDestinoDTO(GuiaTransporteDestinoDTO guiaTransporteDestinoDTO) {
//		this.guiaTransporteDestinoDTO = guiaTransporteDestinoDTO;
//	}
//	/**
//	 * @return the listaGuiaTransporteDestinoCols
//	 */
//	public Collection<GuiaTransporteDestinoDTO> getListaGuiaTransporteDestinoCols() {
//		return listaGuiaTransporteDestinoCols;
//	}
//	/**
//	 * @param listaGuiaTransporteDestinoCols the listaGuiaTransporteDestinoCols to set
//	 */
//	public void setListaGuiaTransporteDestinoCols(Collection<GuiaTransporteDestinoDTO> listaGuiaTransporteDestinoCols) {
//		this.listaGuiaTransporteDestinoCols = listaGuiaTransporteDestinoCols;
//	}
	/**
	 * @return the guiaTransporteDocumentoDTO
	 */
	public GuiaTransporteDocumentoDTO getGuiaTransporteDocumentoDTO() {
		return guiaTransporteDocumentoDTO;
	}
	/**
	 * @param guiaTransporteDocumentoDTO the guiaTransporteDocumentoDTO to set
	 */
	public void setGuiaTransporteDocumentoDTO(GuiaTransporteDocumentoDTO guiaTransporteDocumentoDTO) {
		this.guiaTransporteDocumentoDTO = guiaTransporteDocumentoDTO;
	}
	/**
	 * @return the listaGuiaTransporteDocumentoCols
	 */
	public Collection<GuiaTransporteDocumentoDTO> getListaGuiaTransporteDocumentoCols() {
		return listaGuiaTransporteDocumentoCols;
	}
	/**
	 * @param listaGuiaTransporteDocumentoCols the listaGuiaTransporteDocumentoCols to set
	 */
	public void setListaGuiaTransporteDocumentoCols(Collection<GuiaTransporteDocumentoDTO> listaGuiaTransporteDocumentoCols) {
		this.listaGuiaTransporteDocumentoCols = listaGuiaTransporteDocumentoCols;
	}
	/**
	 * @return the listaChoferesPrincipal
	 */
	public Collection<VehiculoChoferDTO> getListaChoferesPrincipal() {
		return listaChoferesPrincipal;
	}
	/**
	 * @param listaChoferesPrincipal the listaChoferesPrincipal to set
	 */
	public void setListaChoferesPrincipal(Collection<VehiculoChoferDTO> listaChoferesPrincipal) {
		this.listaChoferesPrincipal = listaChoferesPrincipal;
	}
	/**
	 * @return the listaChoferesAyudante
	 */
	public Collection<VehiculoChoferDTO> getListaChoferesAyudante() {
		return listaChoferesAyudante;
	}
	/**
	 * @param listaChoferesAyudante the listaChoferesAyudante to set
	 */
	public void setListaChoferesAyudante(Collection<VehiculoChoferDTO> listaChoferesAyudante) {
		this.listaChoferesAyudante = listaChoferesAyudante;
	}
	/**
	 * @return the vehiculoFurgonDTO
	 */
	public VehiculoFurgonDTO getVehiculoFurgonDTO() {
		return vehiculoFurgonDTO;
	}
	/**
	 * @param vehiculoFurgonDTO the vehiculoFurgonDTO to set
	 */
	public void setVehiculoFurgonDTO(VehiculoFurgonDTO vehiculoFurgonDTO) {
		this.vehiculoFurgonDTO = vehiculoFurgonDTO;
	}
	/**
	 * @return the transportistaDTO
	 */
	public TransportistaDTO getTransportistaDTO() {
		return transportistaDTO;
	}
	/**
	 * @param transportistaDTO the transportistaDTO to set
	 */
	public void setTransportistaDTO(TransportistaDTO transportistaDTO) {
		this.transportistaDTO = transportistaDTO;
	}
	/**
	 * @return the areaTrabajoLocal
	 */
	public AreaTrabajoDTO getAreaTrabajoLocal() {
		return areaTrabajoLocal;
	}
	/**
	 * @param areaTrabajoLocal the areaTrabajoLocal to set
	 */
	public void setAreaTrabajoLocal(AreaTrabajoDTO areaTrabajoLocal) {
		this.areaTrabajoLocal = areaTrabajoLocal;
	}
	/**
	 * @return the bodega
	 */
	public BodegaDTO getBodega() {
		return bodega;
	}
	/**
	 * @param bodega the bodega to set
	 */
	public void setBodega(BodegaDTO bodega) {
		this.bodega = bodega;
	}
	/**
	 * @return the codigoReferencia
	 */
	public Integer getCodigoReferencia() {
		return codigoReferencia;
	}
	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(Integer codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
}
