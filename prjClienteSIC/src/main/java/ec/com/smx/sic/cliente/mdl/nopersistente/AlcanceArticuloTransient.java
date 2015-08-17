package ec.com.smx.sic.cliente.mdl.nopersistente;


/**
 * Clase usada como estructura par los row mapper de los trabajos del spring batch
 * @author fcollaguazo
 *
 */

public class AlcanceArticuloTransient {
	
	//Variables comunes
	private Integer codigoCompania;
	private String codigoBarras;
	private String descripcionArticulo;
	
	//Variables para articulo local
	private String estadoArticuloLocal;
	private Integer codigoLocal;
	private String descripcionLocal;
	
	//Variables para el articulo
	private String estadoArticulo;
	private String codigoReferenciaGrupoAlcance;
	
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
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	/**
	 * @return the estadoArticuloLocal
	 */
	public String getEstadoArticuloLocal() {
		return estadoArticuloLocal;
	}
	/**
	 * @param estadoArticuloLocal the estadoArticuloLocal to set
	 */
	public void setEstadoArticuloLocal(String estadoArticuloLocal) {
		this.estadoArticuloLocal = estadoArticuloLocal;
	}
	
	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}
	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	
	public String getDescripcionLocal() {
		return descripcionLocal;
	}
	
	public void setDescripcionLocal(String descripcionLocal) {
		this.descripcionLocal = descripcionLocal;
	}
	/**
	 * @return the estadoArticulo
	 */
	public String getEstadoArticulo() {
		return estadoArticulo;
	}
	/**
	 * @param estadoArticulo the estadoArticulo to set
	 */
	public void setEstadoArticulo(String estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}
	/**
	 * @return the codigoReferenciaGrupoAlcance
	 */
	public String getCodigoReferenciaGrupoAlcance() {
		return codigoReferenciaGrupoAlcance;
	}
	/**
	 * @param codigoReferenciaGrupoAlcance the codigoReferenciaGrupoAlcance to set
	 */
	public void setCodigoReferenciaGrupoAlcance(String codigoReferenciaGrupoAlcance) {
		this.codigoReferenciaGrupoAlcance = codigoReferenciaGrupoAlcance;
	}
}
