package ec.com.smx.sic.cliente.common.articulo.filtros;

import java.io.Serializable;

import ec.com.smx.frameworkv2.security.dto.UserDto;

@SuppressWarnings("serial")
public class PlantillaFiltrosBusquedaBase implements Serializable {
	
	/**
	 * Seccion de Filtro Generica
	 */
	private Integer companiaId;
	
	private UserDto userDto;
	
	private String sistemaOrigen;	
	
//	private Integer firstResult;
//	
//	private Integer maxResults;
//	
//	private Boolean isPaginable = Boolean.FALSE;
//
//	private OrderBy orderByField;
//	
//	private List<OrderBy> orderFields;
//
//	private Boolean countAgain = Boolean.TRUE;
	
	/**
	 * Seccion de filtro de busqueda de articulos
	 */
	private String codigoBarras; // codigo de barras del ArticuloDTO
		
	private String descripcionArticulo;// descripcion de ArticuloDTO	
	
	private String estadoArticulo;//estado de ArticuloDTO
	
	private String estadoArticuloProveedor;//estado del ArticuloProveedorDTO B2B
	
	
	/**
	 * Seccion de filtros de busqueda para proveedores
	 */
	
	private String codigoReferenciaProveedor; // codigo referencia en ArticuloProveedorDTO


	public Integer getCompaniaId() {
		return companiaId;
	}


	public void setCompaniaId(Integer companiaId) {
		this.companiaId = companiaId;
	}


	public UserDto getUserDto() {
		return userDto;
	}


	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}


	public String getSistemaOrigen() {
		return sistemaOrigen;
	}


	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}


//	public Integer getFirstResult() {
//		return firstResult;
//	}
//
//
//	public void setFirstResult(Integer firstResult) {
//		this.firstResult = firstResult;
//	}
//
//
//	public Integer getMaxResults() {
//		return maxResults;
//	}
//
//
//	public void setMaxResults(Integer maxResults) {
//		this.maxResults = maxResults;
//	}
//
//
//	public Boolean getIsPaginable() {
//		return isPaginable;
//	}
//
//
//	public void setIsPaginable(Boolean isPaginable) {
//		this.isPaginable = isPaginable;
//	}
//
//
//	public OrderBy getOrderByField() {
//		return orderByField;
//	}
//
//
//	public void setOrderByField(OrderBy orderByField) {
//		this.orderByField = orderByField;
//	}
//
//
//	public List<OrderBy> getOrderFields() {
//		return orderFields;
//	}
//
//
//	public void setOrderFields(List<OrderBy> orderFields) {
//		this.orderFields = orderFields;
//	}
//
//
//	public Boolean getCountAgain() {
//		return countAgain;
//	}
//
//
//	public void setCountAgain(Boolean countAgain) {
//		this.countAgain = countAgain;
//	}


	public String getCodigoBarras() {
		return codigoBarras;
	}


	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}


	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}


	public String getEstadoArticuloProveedor() {
		return estadoArticuloProveedor;
	}


	public void setEstadoArticuloProveedor(String estadoArticuloProveedor) {
		this.estadoArticuloProveedor = estadoArticuloProveedor;
	}


	public String getCodigoReferenciaProveedor() {
		return codigoReferenciaProveedor;
	}


	public void setCodigoReferenciaProveedor(String codigoReferenciaProveedor) {
		this.codigoReferenciaProveedor = codigoReferenciaProveedor;
	}


	public String getEstadoArticulo() {
		return estadoArticulo;
	}


	public void setEstadoArticulo(String estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}
}
