/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jmontenegro
 *
 */
@Deprecated
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTBOD")
public class ArticuloBodegaDTO extends ArticuloAlcanceBaseDTO{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBodegaID id;
	
	/**
	 * Estado del art�culo en una bodega, puede tener los valores: [1] Activo, [0] Inactivo
	 */
	@ComparatorTypeField
	private String estadoArticuloBodega;
	
	public  ArticuloBodegaDTO() {
		id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBodegaID();
	}
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOBODEGA", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
	private AreaTrabajoDTO bodega;
	
	
	@Column(name = "CODIGOARTICULOBODEGA", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECARTBOD")
	private Long codigoArticuloBodega;
	
	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBodegaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBodegaID id) {
		this.id = id;
	}

	/**
	 * @return the estadoArticuloBodega
	 */
	public String getEstadoArticuloBodega() {
		return estadoArticuloBodega;
	}

	/**
	 * @param estadoArticuloBodega the estadoArticuloBodega to set
	 */
	public void setEstadoArticuloBodega(String estadoArticuloBodega) {
		this.estadoArticuloBodega = estadoArticuloBodega;
	}

	/**
	 * @return the bodega
	 */
	public AreaTrabajoDTO getBodega() {
		return bodega;
	}

	/**
	 * @param bodega the bodega to set
	 */
	public void setBodega(AreaTrabajoDTO bodega) {
		this.bodega = bodega;
	}

	/**
	 * @return the codigoArticuloBodega
	 */
	public Long getCodigoArticuloBodega() {
		return codigoArticuloBodega;
	}

	/**
	 * @param codigoArticuloBodega the codigoArticuloBodega to set
	 */
	public void setCodigoArticuloBodega(Long codigoArticuloBodega) {
		this.codigoArticuloBodega = codigoArticuloBodega;
	}
	
	
	
}
