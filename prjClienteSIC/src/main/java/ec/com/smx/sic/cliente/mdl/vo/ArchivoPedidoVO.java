/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;

/**
 * @author aguato
 *
 */
public class ArchivoPedidoVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoCompania;
	private byte[] datoArchivo;
	
	 
	/**
	 * 
	 */
	public ArchivoPedidoVO() {
		
	}
	
	
	/**
	 * @param codigoCompania
	 * @param datoArchivo
	 */
	public ArchivoPedidoVO(Integer codigoCompania, byte[] datoArchivo) {
		super();
		this.codigoCompania = codigoCompania;
		this.datoArchivo = datoArchivo;
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
	 * @return the datoArchivo
	 */
	public byte[] getDatoArchivo() {
		return datoArchivo;
	}
	/**
	 * @param datoArchivo the datoArchivo to set
	 */
	public void setDatoArchivo(byte[] datoArchivo) {
		this.datoArchivo = datoArchivo;
	}

}
