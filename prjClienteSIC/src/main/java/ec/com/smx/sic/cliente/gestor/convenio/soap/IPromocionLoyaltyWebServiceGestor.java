/** ec.com.smx.sic.cliente.gestor.convenio.soap
 * IPromocionLoyaltyWebServiceGestor.java
 * @author srodriguez
 * 27/2/2015
 */
package ec.com.smx.sic.cliente.gestor.convenio.soap;

/**
 * @author srodriguez
 *
 */
public interface IPromocionLoyaltyWebServiceGestor {

	/** Metodo activarPromocionLoyalty, utilizado para activar la promocion en Loyalty
	 * @author srodriguez
	 * 27/2/2015
	 * @param codigoPromocion
	 * @param estadoActivacion
	 * @return
	 * @return int
	 */
	int activarPromocionLoyalty(Long codigoPromocion,Boolean estadoActivacion);
	
}
