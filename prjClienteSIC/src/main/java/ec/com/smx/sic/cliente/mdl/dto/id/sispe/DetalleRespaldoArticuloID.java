/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class DetalleRespaldoArticuloID extends DatosArticuloID {

	@Column(name="CODIGORESPALDOARTICULO")
	private Long codigoRespaldoArticulo;
	
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name="CODIGOARTICULO")
	private String codigoArticulo;
//	
//	@Column(name="CODIGOPROVEEDOR")
//	private String codigoProveedor ;
	
	/**
	 * @return el codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo el codigoArticulo a establecer
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return el codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania el codigoCompania a establecer
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return el codigoRespaldoArticulo
	 */
	public Long getCodigoRespaldoArticulo() {
		return codigoRespaldoArticulo;
	}

	/**
	 * @param codigoRespaldoArticulo el codigoRespaldoArticulo a establecer
	 */
	public void setCodigoRespaldoArticulo(Long codigoRespaldoArticulo) {
		this.codigoRespaldoArticulo = codigoRespaldoArticulo;
	}
//	public String getCodigoProveedor() {
//		return codigoProveedor;
//	}
//	public void setCodigoProveedor(String codigoProveedor) {
//		this.codigoProveedor = codigoProveedor;
//	}
//	
	
}
