package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;
	
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.CatalogoValorImpID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTCATVAL")
public class CatalogoValorImpDTO extends AuditoriaBaseDTO<CatalogoValorImpID> {

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "VALOR")
	private String valor;

	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;

	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOCATALOGOTIPO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private CatalogoTipoImpDTO catalogoTipoImp;

	
	@OneToMany(mappedBy = "catalogoValorImp")
	@CollectionTypeInfo(name = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<CatalogoValorTipoImpDTO> catalogoValorTipoImp;

	public Collection<CatalogoValorTipoImpDTO> getCatalogoValorTipoImp() {
		return catalogoValorTipoImp;
	}

	public void setCatalogoValorTipoImp(Collection<CatalogoValorTipoImpDTO> catalogoValorTipoImp) {
		this.catalogoValorTipoImp = catalogoValorTipoImp;
	}

	@Transient
	private Double npDiasDemoraje;

	@Transient
	private Double npValorTHC;

	@Transient
	private Double npEmisionBL;

	/**
	 * @return devuelve el valor de la propiedad nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            establece el valor a la propiedad nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return devuelve el valor de la propiedad valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            establece el valor a la propiedad valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return devuelve el valor de la propiedad estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            establece el valor a la propiedad estado
	 */
	public void setEstado(String estado) {
		if (estado != null) {
			this.estado = estado;
		}
	}

	/**
	 * @return devuelve el valor de la propiedad codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia
	 *            establece el valor a la propiedad codigoReferencia
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the catalogoValorTipoImp
	 */

	/**
	 * @return the npDiasDemoraje
	 */
	public Double getNpDiasDemoraje() {
		return npDiasDemoraje;
	}

	/**
	 * @param npDiasDemoraje
	 *            the npDiasDemoraje to set
	 */
	public void setNpDiasDemoraje(Double npDiasDemoraje) {
		this.npDiasDemoraje = npDiasDemoraje;
	}

	/**
	 * @return the npValorTHC
	 */
	public Double getNpValorTHC() {
		return npValorTHC;
	}

	/**
	 * @param npValorTHC
	 *            the npValorTHC to set
	 */
	public void setNpValorTHC(Double npValorTHC) {
		this.npValorTHC = npValorTHC;
	}

	public Double getNpEmisionBL() {
		return npEmisionBL;
	}

	public void setNpEmisionBL(Double npEmisionBL) {
		this.npEmisionBL = npEmisionBL;
	}

	
	/**
	 * @return the catalogoTipoImp
	 */
	public CatalogoTipoImpDTO getCatalogoTipoImp() {
		return catalogoTipoImp;
	}

	/**
	 * @param catalogoTipoImp
	 *            the catalogoTipoImp to set
	 */
	public void setCatalogoTipoImp(CatalogoTipoImpDTO catalogoTipoImp) {
		this.catalogoTipoImp = catalogoTipoImp;
	}
}
