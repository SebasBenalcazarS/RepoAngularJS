package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.ConceptoCatalogoValorImpID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTCONCATVAL")
public class ConceptoCatalogoValorImpDTO extends AuditoriaBaseDTO<ConceptoCatalogoValorImpID>{
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	String estado;
	
	@Column(name = "DESCRIPCION")
	String descripcion;

	@OneToMany(mappedBy = "conceptoCatalogoValorImp")
	private Collection<CatalogoValorTipoImpDTO> catalogoValorTipo;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the catalogoValorTipo
	 */
	public Collection<CatalogoValorTipoImpDTO> getCatalogoValorTipo() {
		return catalogoValorTipo;
	}

	/**
	 * @param catalogoValorTipo the catalogoValorTipo to set
	 */
	public void setCatalogoValorTipo(
			Collection<CatalogoValorTipoImpDTO> catalogoValorTipo) {
		this.catalogoValorTipo = catalogoValorTipo;
	}
	
	
}
