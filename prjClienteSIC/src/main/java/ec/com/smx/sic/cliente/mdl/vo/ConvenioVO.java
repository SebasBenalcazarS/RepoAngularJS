/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ConvenioDTO;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;

/**
 * @author fvallejo
 *
 */
public class ConvenioVO {

	private ConvenioDTO convenioDTO;

	private Long codigoPersona;

	private Long codigoConvenio;
	
	private Long secuencialConvenio;
	
	private String userID;
	
	private Collection<ArticuloDTO> articuloDTOCol;
	
	private Collection<CatalogoValorDTO> catalogoValorEstadosDTOCol;

	private Collection<CatalogoValorDTO> catalogoValorTipoConvenioDTOCol;
	
	private Collection<ClienteDTO> clienteDTOCol;
	
	public ConvenioDTO getConvenioDTO() {
		return convenioDTO;
	}

	public void setConvenioDTO(ConvenioDTO convenioDTO) {
		this.convenioDTO = convenioDTO;
	}

	public Long getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public Long getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(Long codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public Long getSecuencialConvenio() {
		return secuencialConvenio;
	}

	public void setSecuencialConvenio(Long secuencialConvenio) {
		this.secuencialConvenio = secuencialConvenio;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Collection<ArticuloDTO> getArticuloDTOCol() {
		return articuloDTOCol;
	}

	public void setArticuloDTOCol(Collection<ArticuloDTO> articuloDTOCol) {
		this.articuloDTOCol = articuloDTOCol;
	}

	public Collection<CatalogoValorDTO> getCatalogoValorEstadosDTOCol() {
		return catalogoValorEstadosDTOCol;
	}

	public void setCatalogoValorEstadosDTOCol(Collection<CatalogoValorDTO> catalogoValorEstadosDTOCol) {
		this.catalogoValorEstadosDTOCol = catalogoValorEstadosDTOCol;
	}

	public Collection<CatalogoValorDTO> getCatalogoValorTipoConvenioDTOCol() {
		return catalogoValorTipoConvenioDTOCol;
	}

	public void setCatalogoValorTipoConvenioDTOCol(Collection<CatalogoValorDTO> catalogoValorTipoConvenioDTOCol) {
		this.catalogoValorTipoConvenioDTOCol = catalogoValorTipoConvenioDTOCol;
	}

	public Collection<ClienteDTO> getClienteDTOCol() {
		return clienteDTOCol;
	}

	public void setClienteDTOCol(Collection<ClienteDTO> clienteDTOCol) {
		this.clienteDTOCol = clienteDTOCol;
	}
	
}
