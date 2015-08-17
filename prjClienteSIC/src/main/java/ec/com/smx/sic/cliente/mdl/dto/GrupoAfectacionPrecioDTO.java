/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.GrupoAfectacionPrecioID;

/**
 * @author cjara
 *
 */
@Entity
@Table(name="SCPRETGRUAFEPRE")
@SuppressWarnings("serial")
public class GrupoAfectacionPrecioDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private GrupoAfectacionPrecioID id = new GrupoAfectacionPrecioID();
	
	@Column(name = "CODIGOGESTIONPRECIO", nullable = false)
	private Long codigoGestionPrecio;
	
	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)	
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOGESTIONPRECIO", referencedColumnName="CODIGOGESTIONPRECIO", insertable=false, updatable=false) 
	})
	private GestionPrecioDTO gestionPrecio;
	
	@OneToMany(mappedBy = "grupoAfectacionPrecio")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ValorAfectacionPrecioDTO> valorAfectacionPrecios;

	/**
	 * @return the id
	 */
	public GrupoAfectacionPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(GrupoAfectacionPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the codigoGestionPrecio
	 */
	public Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}

	/**
	 * @param codigoGestionPrecio the codigoGestionPrecio to set
	 */
	public void setCodigoGestionPrecio(Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the gestionPrecio
	 */
	public GestionPrecioDTO getGestionPrecio() {
		return gestionPrecio;
	}

	/**
	 * @param gestionPrecio the gestionPrecio to set
	 */
	public void setGestionPrecio(GestionPrecioDTO gestionPrecio) {
		this.gestionPrecio = gestionPrecio;
	}

	/**
	 * @return the valorAfectacionPrecios
	 */
	public Collection<ValorAfectacionPrecioDTO> getValorAfectacionPrecios() {
		return valorAfectacionPrecios;
	}

	/**
	 * @param valorAfectacionPrecios the valorAfectacionPrecios to set
	 */
	public void setValorAfectacionPrecios(Collection<ValorAfectacionPrecioDTO> valorAfectacionPrecios) {
		this.valorAfectacionPrecios = valorAfectacionPrecios;
	}
}
