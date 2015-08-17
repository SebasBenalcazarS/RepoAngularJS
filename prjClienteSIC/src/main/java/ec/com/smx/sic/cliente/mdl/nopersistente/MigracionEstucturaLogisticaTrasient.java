package ec.com.smx.sic.cliente.mdl.nopersistente;

/**
 * 
 * @author cortiz
 *
 */
public class MigracionEstucturaLogisticaTrasient {

	private Integer cd;
	private Integer bodega;
	private Integer subbodega;
	private Integer nave;
	private String subnave;
	private String nombre;
	
	public Integer getCd() {
		return cd;
	}
	
	public void setCd(Integer cd) {
		this.cd = cd;
	}
	
	public Integer getBodega() {
		return bodega;
	}
	
	public void setBodega(Integer bodega) {
		this.bodega = bodega;
	}
	
	public Integer getSubbodega() {
		return subbodega;
	}
	
	public void setSubbodega(Integer subbodega) {
		this.subbodega = subbodega;
	}
	
	public Integer getNave() {
		return nave;
	}

	public void setNave(Integer nave) {
		this.nave = nave;
	}

	public String getSubnave() {
		return subnave;
	}

	public void setSubnave(String subnave) {
		this.subnave = subnave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
