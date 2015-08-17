/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.id.CatalogoValorID;
import ec.com.smx.sic.cliente.common.proveedor.TipoValidacionProveedor;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class IdentificadorDocumentoProveedorVO implements
		IIdentificadorProveedorVO {

	
	private Integer codigoCompania;
	private CatalogoValorID tipoDocumento;
	private String tipoProveedor;
	private String numeroDocumento;
	private final TipoValidacionProveedor tipoValidacionProveedor;
	private Integer codigoEntidad;
	
	/**
	 * Constructor que recibe el tipo de proveedor
	 * 
	 * @author ivasquez
	 * @param codigoCompania
	 * @param valorTipoDocumento
	 * @param numeroDocumento
	 * @param tipoProveedor
	 */
	public IdentificadorDocumentoProveedorVO(Integer codigoCompania, String valorTipoDocumento, String numeroDocumento, String tipoProveedor) {
		this.tipoValidacionProveedor = TipoValidacionProveedor.DOCUMENTO;
		this.codigoCompania = codigoCompania;
		this.tipoDocumento = new CatalogoValorID();
		this.tipoDocumento.setCodigoCatalogoTipo(TiposCatalogoConstantes.TIPO_DOCUMENTO_EMPRESA);
		this.tipoDocumento.setCodigoCatalogoValor(valorTipoDocumento);
		this.numeroDocumento = numeroDocumento;
		this.tipoProveedor = tipoProveedor;
	}
	
	public IdentificadorDocumentoProveedorVO(Integer codigoCompania, 
			String valorTipoDocumento,
			String numeroDocumento){
		
		this.tipoValidacionProveedor = TipoValidacionProveedor.DOCUMENTO;
		this.codigoCompania = codigoCompania;
		this.tipoDocumento = new CatalogoValorID();
		this.tipoDocumento.setCodigoCatalogoTipo(TiposCatalogoConstantes.TIPO_DOCUMENTO_EMPRESA);
		this.tipoDocumento.setCodigoCatalogoValor(valorTipoDocumento);
		this.numeroDocumento = numeroDocumento;
	}
	

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the tipoDocumento
	 */
	public CatalogoValorID getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(CatalogoValorID tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	/**
	 * @return the tipoValidacionProveedor
	 */
	public TipoValidacionProveedor getTipoValidacionProveedor() {
		return tipoValidacionProveedor;
	}


	/**
	 * @return the codigoEntidad
	 */
	public Integer getCodigoEntidad() {
		return codigoEntidad;
	}


	/**
	 * @param codigoEntidad the codigoEntidad to set
	 */
	public void setCodigoEntidad(Integer codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}
	

	/**
	 * @return the tipoProveedor
	 */
	public String getTipoProveedor() {
		return tipoProveedor;
	}

	/**
	 * @param tipoProveedor the tipoProveedor to set
	 */
	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}
}
