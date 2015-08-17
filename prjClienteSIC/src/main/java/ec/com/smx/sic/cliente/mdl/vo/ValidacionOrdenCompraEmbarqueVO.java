package ec.com.smx.sic.cliente.mdl.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author aguato
 *
 */
public class ValidacionOrdenCompraEmbarqueVO {

	private String codigoEmbarqueValidado;
	private HashMap<String, List<ArrayList<String>>> facturasArticulosError = new HashMap<String, List<ArrayList<String>>>();//CodigoFactura, ListadoErrores(CodigoArticulo,DescripcionError)
	private List<String> codigosFacturas = new ArrayList<String>();
	private String errorGeneralEmbarque = null;
		
	/**
	 * Constructor de la clase
	 * @param codigoEmbarqueValidado
	 */
	public ValidacionOrdenCompraEmbarqueVO(String codigoEmbarqueValidado) {
		super();
		this.codigoEmbarqueValidado = codigoEmbarqueValidado;
	}
	/*GETTERS AND SETTERS*/
	/**
	 * @return the codigoEmbarqueValidado
	 */
	public String getCodigoEmbarqueValidado() {
		return codigoEmbarqueValidado;
	}
	/**
	 * @param codigoEmbarqueValidado the codigoEmbarqueValidado to set
	 */
	public void setCodigoEmbarqueValidado(String codigoEmbarqueValidado) {
		this.codigoEmbarqueValidado = codigoEmbarqueValidado;
	}
	/**
	 * @return the facturasArticulosError
	 */
	public HashMap<String, List<ArrayList<String>>> getFacturasArticulosError() {
		return facturasArticulosError;
	}
	/**
	 * @param facturasArticulosError the facturasArticulosError to set
	 */
	public void setFacturasArticulosError(HashMap<String, List<ArrayList<String>>> facturasArticulosError) {
		this.facturasArticulosError = facturasArticulosError;
	}
	/**
	 * @return the codigosFacturas
	 */
	public List<String> getCodigosFacturas() {
		return codigosFacturas;
	}
	/**
	 * @param codigosFacturas the codigosFacturas to set
	 */
	public void setCodigosFacturas(List<String> codigosFacturas) {
		this.codigosFacturas = codigosFacturas;
	}
	/**
	 * @return the errorGeneralEmbarque
	 */
	public String getErrorGeneralEmbarque() {
		return errorGeneralEmbarque;
	}
	/**
	 * @param errorGeneralEmbarque the errorGeneralEmbarque to set
	 */
	public void setErrorGeneralEmbarque(String errorGeneralEmbarque) {
		this.errorGeneralEmbarque = errorGeneralEmbarque;
	}
}
