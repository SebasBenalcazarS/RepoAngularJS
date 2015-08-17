/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor.bean;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class InformacionDocumentoProveedorDuplicado implements Serializable {
	
	private Collection<String> codigosJDE;
	private String numeroDocumento;
	
	
	/**
	 * 
	 * @param codigosJDE
	 * @param numeroDocumento
	 */
	public InformacionDocumentoProveedorDuplicado(String numeroDocumento,
			Collection<String> codigosJDE) {
		
		this.codigosJDE = codigosJDE;
		this.numeroDocumento = numeroDocumento;
	}
	
	
	/**
	 * 
	 * @return
	 */
	/*public Boolean existenDocumentosDuplicados(){
		return CollectionUtils.isNotEmpty(this.codigosJDE) && this.codigosJDE.size() >= 1;
	}*/
	
	
	/**
	 * @return the codigosJDE
	 */
	public Collection<String> getCodigosJDE() {
		return codigosJDE;
	}
	

	/**
	 * @param codigosJDE the codigosJDE to set
	 */
	public void setCodigosJDE(Collection<String> codigosJDE) {
		this.codigosJDE = codigosJDE;
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
	
	

}
