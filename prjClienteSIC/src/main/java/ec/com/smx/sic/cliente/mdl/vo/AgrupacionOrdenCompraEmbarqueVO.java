package ec.com.smx.sic.cliente.mdl.vo;

import java.util.ArrayList;
import java.util.Collection;


import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaEstadoImpDTO;

/**
 * @author erodriguez
 *
 */
public class AgrupacionOrdenCompraEmbarqueVO {

	private String comprador;
	private String proveedor;
	private String subBodega;
	private Collection<FacturaEstadoImpDTO> listFacturaEstadoDTOCol;
	private Collection<OrdenCompraEstadoDTO> listOrdenCompraEstadoDTO;
	private Boolean plegarDesplegar;


	/**
	 * Constructor de la clase
	 * @param codigoEmbarqueValidado
	 */
	public AgrupacionOrdenCompraEmbarqueVO(String comprador, String proveedor, String subBodega ) {
		this.comprador = comprador;
		this.proveedor = proveedor;
		this.subBodega = subBodega;
		listFacturaEstadoDTOCol = new ArrayList<FacturaEstadoImpDTO>();
		listOrdenCompraEstadoDTO = new ArrayList<OrdenCompraEstadoDTO>();
		setPlegarDesplegar(false);
	}
	
	/*GETTERS AND SETTERS*/

	/**
	 * @return the comprador
	 */
	public String getComprador() {
		return comprador;
	}
	/**
	 * @param comprador the comprador to set
	 */
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	/**
	 * @return the proveedor
	 */
	public String getProveedor() {
		return proveedor;
	}
	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	/**
	 * @return the subBodega
	 */
	public String getSubBodega() {
		return subBodega;
	}
	/**
	 * @param subBodega the subBodega to set
	 */
	public void setSubBodega(String subBodega) {
		this.subBodega = subBodega;
	}

	
	/**
	 * @return the listOrdenCompraEstadoDTO
	 */
	public Collection<OrdenCompraEstadoDTO> getListOrdenCompraEstadoDTO() {
		return listOrdenCompraEstadoDTO;
	}
	/**
	 * @param listOrdenCompraEstadoDTO the listOrdenCompraEstadoDTO to set
	 */
	public void setListOrdenCompraEstadoDTO(Collection<OrdenCompraEstadoDTO> listOrdenCompraEstadoDTO) {
		this.listOrdenCompraEstadoDTO = listOrdenCompraEstadoDTO;
	}

	/**
	 * @return the listFacturaEstadoDTOCol
	 */
	public Collection<FacturaEstadoImpDTO> getListFacturaEstadoDTOCol() {
		return listFacturaEstadoDTOCol;
	}

	/**
	 * @param listFacturaEstadoDTOCol the listFacturaEstadoDTOCol to set
	 */
	public void setListFacturaEstadoDTOCol(Collection<FacturaEstadoImpDTO> listFacturaEstadoDTOCol) {
		this.listFacturaEstadoDTOCol = listFacturaEstadoDTOCol;
	}

	/**
	 * @return the plegarDesplegar
	 */
	public Boolean getPlegarDesplegar() {
		return plegarDesplegar;
	}

	/**
	 * @param plegarDesplegar the plegarDesplegar to set
	 */
	public void setPlegarDesplegar(Boolean plegarDesplegar) {
		this.plegarDesplegar = plegarDesplegar;
	}

	
}
