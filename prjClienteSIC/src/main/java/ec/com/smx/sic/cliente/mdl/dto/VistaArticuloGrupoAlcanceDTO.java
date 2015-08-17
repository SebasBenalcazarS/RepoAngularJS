package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * 
 * @author jmontenegro
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
@Entity
public class VistaArticuloGrupoAlcanceDTO extends SearchDTO {

	private String codigosLocales;
	
	@Id
	private String codigoArticulo;

	public String getCodigosLocales() {
		return codigosLocales;
	}

	public void setCodigosLocales(String codigosLocales) {
		this.codigosLocales = codigosLocales;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
}
