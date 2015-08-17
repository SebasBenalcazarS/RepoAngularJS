package ec.com.smx.sic.cliente.mdl.dto.articulo.adicional;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;

/**
 * 
 * @author mgranda
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTDATADIART")
public class ArticuloInformacionAdicionalDTO extends SimpleAuditDTO{

	/**
	 * Variable identificador de la entidad ArticuloInformacionAdicionalDTO
	 */
	@EmbeddedId
	private ArticuloID id = new ArticuloID();
		
	/**
	 * Variable que identifica si un cupon aplica o no a una familia
	 */
	@ComparatorTypeField
	@Column(name="APLICAFAMILIA", nullable=false)
	private Boolean aplicaFamilia;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
	@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;

	public ArticuloInformacionAdicionalDTO() {
		super();
	}

	/**
	 * Metodo de acceso para obtener el identificador de la entidad ArticuloInformacionAdicionalDTO
	 */
	public ArticuloID getId() {
		return id;
	}

	/**
	 * Metodo de acceso para asignar el identificador de la entidad ArticuloInformacionAdicionalDTO
	 * @param id
	 */
	public void setId(final ArticuloID id) {
		this.id = id;
	}

	/**
	 * Metodo de acceso para obtener si un cupon aplicaFamilia
	 */
	public Boolean getAplicaFamilia() {
		return aplicaFamilia;
	}

	/**
	 * Metodo de acceso para asignar si un cupon aplicaFamilia
	 * @param aplicaFamilia
	 */
	public void setAplicaFamilia(final Boolean aplicaFamilia) {
		this.aplicaFamilia = aplicaFamilia;
	}

	/**
	 * Metodo de acceso para obtener el ArticuloDTO
	 * @param articulo
	 */
	public ArticuloDTO getArticulo() {
		return articulo;
	}

	/**
	 * Metodo de acceso para asignar el ArticuloDTO
	 * @param articulo
	 */
	public void setArticulo(final ArticuloDTO articulo) {
		this.articulo = articulo;
	}
}
