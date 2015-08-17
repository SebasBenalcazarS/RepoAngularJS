/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.CatalagoTipoImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTCATTIP")
public class CatalogoTipoImpDTO extends AuditoriaBaseDTO<CatalagoTipoImpID> {
	@Column(name = "NOMBRE")
	private String nombre;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "CATALOGOADUANA")
	private String catalogoAduana;
	
	@OneToMany(mappedBy = "catalogoTipoImp")
//	@LazyCollection(LazyCollectionOption.FALSE)  
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<CatalogoValorImpDTO> catalogosValor;
	
	@Transient
	private boolean showListCatalogoValor;
	
	
	/**
	 * @return devuelve el valor de la propiedad nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre establece el valor a la propiedad nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return devuelve el valor de la propiedad estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado establece el valor a la propiedad estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return devuelve el valor de la propiedad catalogosValor
	 */
	public Collection<CatalogoValorImpDTO> getCatalogosValor() {
		return catalogosValor;
	}

	/**
	 * @param catalogosValor establece el valor a la propiedad catalogosValor
	 */
	public void setCatalogosValor(Collection<CatalogoValorImpDTO> catalogosValor) {
		this.catalogosValor = catalogosValor;
	}
	
	/**
	 * @return devuelve parametro transiente mostrar catalogo valor del tipo
	 */
	public boolean isShowListCatalogoValor() {
		return showListCatalogoValor;
	}

	/**
	 * @param showListCatalogoValor establece el valor transiente a la propiedad showListCatalogoValor
	 */
	public void setShowListCatalogoValor(boolean showListCatalogoValor) {
		this.showListCatalogoValor = showListCatalogoValor;
	}
	
	/**
	 * @return Devuelve el tamaño de los catalogos valor asignados al tipo
	 */
	public Integer getSizeLstCatalogosValor(){
		if(catalogosValor==null || catalogosValor.isEmpty()){
			return 0;
		}
		return catalogosValor.size();
	}

	/**
	 * @return the catalogoAduana
	 */
	public String getCatalogoAduana() {
		return catalogoAduana;
	}

	/**
	 * @param catalogoAduana the catalogoAduana to set
	 */
	public void setCatalogoAduana(String catalogoAduana) {
		this.catalogoAduana = catalogoAduana;
	}
	
}
