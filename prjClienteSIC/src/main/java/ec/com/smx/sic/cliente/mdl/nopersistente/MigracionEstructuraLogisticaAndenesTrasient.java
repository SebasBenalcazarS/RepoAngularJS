package ec.com.smx.sic.cliente.mdl.nopersistente;

/**
 * Objeto para la migracion de andenes
 * @author cortiz
 *
 */
public class MigracionEstructuraLogisticaAndenesTrasient {

	private Integer anden;
	private Integer bodega;
	private String tipoAnden;
	private Integer local;
	/**
	 * @return the anden
	 */
	public Integer getAnden() {
		return anden;
	}
	/**
	 * @param anden the anden to set
	 */
	public void setAnden(Integer anden) {
		this.anden = anden;
	}
	/**
	 * @return the bodega
	 */
	public Integer getBodega() {
		return bodega;
	}
	/**
	 * @param bodega the bodega to set
	 */
	public void setBodega(Integer bodega) {
		this.bodega = bodega;
	}
	/**
	 * @return the tipoAnden
	 */
	public String getTipoAnden() {
		return tipoAnden;
	}
	/**
	 * @param tipoAnden the tipoAnden to set
	 */
	public void setTipoAnden(String tipoAnden) {
		this.tipoAnden = tipoAnden;
	}
	/**
	 * @return the local
	 */
	public Integer getLocal() {
		return local;
	}
	/**
	 * @param local the local to set
	 */
	public void setLocal(Integer local) {
		this.local = local;
	}
}
