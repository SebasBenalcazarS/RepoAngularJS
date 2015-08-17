/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorImportadoID;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTPROIMP")
public class ProveedorImportadoDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private ProveedorImportadoID id;
	private String codigoReferenciaProveedor;
		
	public ProveedorImportadoDTO() {
		this.id = new ProveedorImportadoID();
	}
	

	/**
	 * 
	 * @param tiempoEspera
	 * @param tiempoStock
	 */
	public ProveedorImportadoDTO(Long tiempoEspera, Long tiempoStock) {
		this();
		this.tiempoEspera = tiempoEspera;
		this.tiempoStock = tiempoStock;
	}
	
	
	/**
	 * Cantidad de dias que la corporacion espera a que los productos del proveedor lleguen a sus bodegas.
	 *

	 */
	private java.lang.Long tiempoEspera ;



	/**
	 * Tiempo en dias de sus articulos en Stock.
	 *

	 */
	private Long tiempoStock ;
	
	
	/**
	 * Codigo del catalogo para los valores que indican si un proveedor es importador o no
	 */
	
	private Integer codigoEsImportador;
	
	/**
	 * Indica si un proveedor es importador, los valores son:

		[0] No
		[1] SI

		El valor por defecto es 0 para proveedores nacionales y 1 para importados
	 */
	
	private String esImportador;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "ESIMPORTADOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESIMPORTADOR", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaEsImportador;
	
	

	/**
	 * @return the id
	 */
	public ProveedorImportadoID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ProveedorImportadoID id) {
		this.id = id;
	}
	/**
	 * @return the codigoReferenciaProveedor
	 */
	public String getCodigoReferenciaProveedor() {
		return codigoReferenciaProveedor;
	}
	/**
	 * @param codigoReferenciaProveedor the codigoReferenciaProveedor to set
	 */
	public void setCodigoReferenciaProveedor(String codigoReferenciaProveedor) {
		this.codigoReferenciaProveedor = codigoReferenciaProveedor;
	}
	
	
	/**
	 * Retorna valor de propiedad <code>tiempoEspera</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>tiempoEspera</code>
	 */
	public java.lang.Long getTiempoEspera(){
		return this.tiempoEspera;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tiempoEspera</code>.
	 * @param tiempoEspera1 
	 *		El valor a establecer para la propiedad <code>tiempoEspera</code>.
	 */
	public void setTiempoEspera( java.lang.Long tiempoEspera1 ){
		this.tiempoEspera=tiempoEspera1;

	}



	

	/**
	 * @return the tiempoStock
	 */
	public Long getTiempoStock() {
		return tiempoStock;
	}


	/**
	 * @param tiempoStock the tiempoStock to set
	 */
	public void setTiempoStock(Long tiempoStock) {
		this.tiempoStock = tiempoStock;
	}


	/**
	 * @return the codigoEsImportador
	 */
	public Integer getCodigoEsImportador() {
		return codigoEsImportador;
	}


	/**
	 * @param codigoEsImportador the codigoEsImportador to set
	 */
	public void setCodigoEsImportador(Integer codigoEsImportador) {
		this.codigoEsImportador = codigoEsImportador;
	}


	/**
	 * @return the esImportador
	 */
	public String getEsImportador() {
		return esImportador;
	}


	/**
	 * @param esImportador the esImportador to set
	 */
	public void setEsImportador(String esImportador) {
		this.esImportador = esImportador;
	}


	/**
	 * @return the caracteristicaEsImportador
	 */
	public CatalogoValorDTO getCaracteristicaEsImportador() {
		return caracteristicaEsImportador;
	}


	/**
	 * @param caracteristicaEsImportador the caracteristicaEsImportador to set
	 */
	public void setCaracteristicaEsImportador(
			CatalogoValorDTO caracteristicaEsImportador) {
		this.caracteristicaEsImportador = caracteristicaEsImportador;
	}
	
	

}
