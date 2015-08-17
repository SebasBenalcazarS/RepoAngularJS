package ec.com.smx.sic.cliente.common.articulo.filtros;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;

@SuppressWarnings("serial")
public class PlantillaFiltrosBusquedaB2B extends PlantillaFiltrosBusquedaBase {
	
	/**
	 * Seccion de Filtro Generica
	 */

	private String codigoProveedor;	
	
	/**
	 * Seccion de filtros de articulos
	 */
	
	private Boolean aplicaRegistroSanitario;// si aplica o no registro sanitario en ArticuloDTO B2B
	
	/**
	 * Seccion de filtros de busqueda para proveedores
	 */
	
	private String codigoReferenciaProveedor; // codigo referencia en ArticuloProveedorDTO
	
	private String estadoProveedor; //estado proveedor en VistaProveedor
	
	// Campos de estadoArticuloProveedor que ya se encuentra registrado anteriormente
	
	//Codigo referencia proveedor que se encuentra registrado B2B
	
	/**
	 * Seccion de busqueda de marca articulo
	 */	
	
	private Boolean visualizarFiltros; 
	
	private String registroSanitario;	
	
	private Date fCadRegSinicio;
	
	private Date fCadRegSfin;
	
	private Boolean regSanCaducados = Boolean.FALSE;
	
	private Collection<ClasificacionDTO> clasificacionCol;//Colección de clasificaciones
	
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getCodigoReferenciaProveedor() {
		return codigoReferenciaProveedor;
	}

	public void setCodigoReferenciaProveedor(String codigoReferenciaProveedor) {
		this.codigoReferenciaProveedor = codigoReferenciaProveedor;
	}

	public String getEstadoProveedor() {
		return estadoProveedor;
	}

	public void setEstadoProveedor(String estadoProveedor) {
		this.estadoProveedor = estadoProveedor;
	}

	public Boolean getVisualizarFiltros() {
		return visualizarFiltros;
	}

	public void setVisualizarFiltros(Boolean visualizarFiltros) {
		this.visualizarFiltros = visualizarFiltros;
	}

	public String getRegistroSanitario() {
		return registroSanitario;
	}

	public void setRegistroSanitario(String registroSanitario) {
		this.registroSanitario = registroSanitario;
	}

	public Date getfCadRegSinicio() {
		return fCadRegSinicio;
	}

	public void setfCadRegSinicio(Date fCadRegSinicio) {
		this.fCadRegSinicio = fCadRegSinicio;
	}

	public Date getfCadRegSfin() {
		return fCadRegSfin;
	}

	public void setfCadRegSfin(Date fCadRegSfin) {
		this.fCadRegSfin = fCadRegSfin;
	}

	public Boolean getRegSanCaducados() {
		return regSanCaducados;
	}

	public void setRegSanCaducados(Boolean regSanCaducados) {
		this.regSanCaducados = regSanCaducados;
	}

	public Boolean getAplicaRegistroSanitario() {
		return aplicaRegistroSanitario;
	}

	public void setAplicaRegistroSanitario(Boolean aplicaRegistroSanitario) {
		this.aplicaRegistroSanitario = aplicaRegistroSanitario;
	}

	public Collection<ClasificacionDTO> getClasificacionCol() {
		return clasificacionCol;
	}

	public void setClasificacionCol(Collection<ClasificacionDTO> clasificacionCol) {
		this.clasificacionCol = clasificacionCol;
	}
	
}

