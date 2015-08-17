
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ConvenioDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ClienteArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;


/**
 * Permite gestionar la informacion correspondiente a ClienteArticulo
 *
 * @author mrivera
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTCLIART")
public class ClienteArticuloDTO extends AuditoriaBaseDTO<ClienteArticuloID> {
	
	/**
	 * Especifica el codigo cliente pedido
	 */
	private Long codigoClientePedido;
	/**
	 * Especifica el codigo articulo relacionado
	 */
	@ComparatorTypeField(comparatorType=ComparatorTypeEnum.EQUAL_COMPARATOR)
	private String codigoArticulo;
	/**
	 * Especifica el estado, los posibles valores son:
	 * ACT: Activo
	 * INA: Inactivo
	 */
	@ComparatorTypeField(comparatorType=ComparatorTypeEnum.EQUAL_COMPARATOR)
	private String estado ;
	
	/**
	 * Fecha en que el articulo (cupon) fue utilizado por el cliente en sus compras. 
	 */
	private java.sql.Timestamp fechaUso;
	
	/**
	 * Entidad que representa al articulo
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)	
	})
	private ArticuloDTO articulo;	
		
	/**
	 * Entidad que representa al Cliente pedido
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOCLIENTEPEDIDO", referencedColumnName="CODIGOCLIENTEPEDIDO", insertable=false, updatable=false)	
	})
	private ClienteDTO clientePedido;
	
	@Transient
	private String valorTipoAgrupador;
	
	private Long secuencialConvenio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="SECUENCIALCONVENIO", referencedColumnName="SECUENCIALCONVENIO", insertable=false, updatable=false)
	})
	private ConvenioDTO convenioDTO;
	
	/**
	 * @return the codigoClientePedido
	 */
	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	/**
	 * @param codigoClientePedido the codigoClientePedido to set
	 */
	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado(){
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * @param estado1 
	 *		El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado( String estado1 ){
		this.estado=estado1;
		
		if(estado!=null && estado.length()>3){
			estado = estado.substring(0,3);
		}	
	}

	/**
	 * @return the fechaUso
	 */
	public java.sql.Timestamp getFechaUso() {
		return fechaUso;
	}

	/**
	 * @param fechaUso the fechaUso to set
	 */
	public void setFechaUso(java.sql.Timestamp fechaUso) {
		this.fechaUso = fechaUso;
	}

	/**
	 * @return the articulo
	 */
	public ArticuloDTO getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	/**
	 * @return the clientePedido
	 */
	public ClienteDTO getClientePedido() {
		return clientePedido;
	}

	/**
	 * @param clientePedido the clientePedido to set
	 */
	public void setClientePedido(ClienteDTO clientePedido) {
		this.clientePedido = clientePedido;
	}

	/**
	 * @return the valorTipoAgrupador
	 */
	public String getValorTipoAgrupador() {
		return valorTipoAgrupador;
	}

	/**
	 * @param valorTipoAgrupador the valorTipoAgrupador to set
	 */
	public void setValorTipoAgrupador(String valorTipoAgrupador) {
		this.valorTipoAgrupador = valorTipoAgrupador;
	}

	public Long getSecuencialConvenio() {
		return secuencialConvenio;
	}

	public void setSecuencialConvenio(Long secuencialConvenio) {
		this.secuencialConvenio = secuencialConvenio;
	}

	public ConvenioDTO getConvenioDTO() {
		return convenioDTO;
	}

	public void setConvenioDTO(ConvenioDTO convenioDTO) {
		this.convenioDTO = convenioDTO;
	}


	
}