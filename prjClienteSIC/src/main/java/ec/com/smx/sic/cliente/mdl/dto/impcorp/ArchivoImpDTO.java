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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.ArchivoImpID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTARCHIVO")
public class ArchivoImpDTO extends AuditoriaBaseDTO<ArchivoImpID>{
	
	@Column(name = "TIPOARCHIVO")
	private String tipoArchivo;
	
	@Column(name = "CODIGOTIPOARCHIVO")
	private Integer codigoTipoArchivo;
	
	@Column(name = "CODIGOVALORARCHIVO")
	private Integer codigoValorArchivo;
	
	@Column(name = "TAMANIOARCHIVO")
	private Integer tamanioArchivo;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name =  "NOMBREARCHIVO")
	private String nombreArchivo;
	
	
	@OneToMany(mappedBy="archivoImpDTO")
	//@LazyCollection(LazyCollectionOption.FALSE)
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<CabeceraEnvioDetalleImpDTO> cabeceraEnvioDetalleImpDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOVALORARCHIVO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOARCHIVO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO catalogoValorImp;
	
	@OneToMany(mappedBy="archivo")
	private Collection<ContenidoArchivoImpDTO> contenidosArchivo;
	
	/**
	 * @return the tipoArchivo
	 */
	public String getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * @param tipoArchivo the tipoArchivo to set
	 */
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	/**
	 * @return the tamanioArchivo
	 */
	public Integer getTamanioArchivo() {
		return tamanioArchivo;
	}

	/**
	 * @param tamanioArchivo the tamanioArchivo to set
	 */
	public void setTamanioArchivo(Integer tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
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

//	/**
//	 * @return the cabeceraEnvioImpDTO
//	 */
//	public Collection<CabeceraEnvioImpDTO> getCabeceraEnvioImpDTO() {
//		return cabeceraEnvioImpDTO;
//	}
//
//	/**
//	 * @param cabeceraEnvioImpDTO the cabeceraEnvioImpDTO to set
//	 */
//	public void setCabeceraEnvioImpDTO(
//			Collection<CabeceraEnvioImpDTO> cabeceraEnvioImpDTO) {
//		this.cabeceraEnvioImpDTO = cabeceraEnvioImpDTO;
//	}

	/**
	 * @return the catalogoValorImp
	 */
	public CatalogoValorImpDTO getCatalogoValorImp() {
		return catalogoValorImp;
	}

	/**
	 * @param catalogoValorImp the catalogoValorImp to set
	 */
	public void setCatalogoValorImp(CatalogoValorImpDTO catalogoValorImp) {
		this.catalogoValorImp = catalogoValorImp;
	}

	/**
	 * @return the codigoTipoArchivo
	 */
	public Integer getCodigoTipoArchivo() {
		return codigoTipoArchivo;
	}

	/**
	 * @param codigoTipoArchivo the codigoTipoArchivo to set
	 */
	public void setCodigoTipoArchivo(Integer codigoTipoArchivo) {
		this.codigoTipoArchivo = codigoTipoArchivo;
	}

	/**
	 * @return the codigoValorArchivo
	 */
	public Integer getCodigoValorArchivo() {
		return codigoValorArchivo;
	}

	/**
	 * @param codigoValorArchivo the codigoValorArchivo to set
	 */
	public void setCodigoValorArchivo(Integer codigoValorArchivo) {
		this.codigoValorArchivo = codigoValorArchivo;
	}

	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		if(this.nombreArchivo!=null && this.nombreArchivo.length()>32){
			this.nombreArchivo = this.nombreArchivo.substring(0,32);
		}
	}

	/**
	 * @return the cabeceraEnvioDetalleImpDTO
	 */
	public Collection<CabeceraEnvioDetalleImpDTO> getCabeceraEnvioDetalleImpDTO() {
		return cabeceraEnvioDetalleImpDTO;
	}

	/**
	 * @param cabeceraEnvioDetalleImpDTO the cabeceraEnvioDetalleImpDTO to set
	 */
	public void setCabeceraEnvioDetalleImpDTO(
			Collection<CabeceraEnvioDetalleImpDTO> cabeceraEnvioDetalleImpDTO) {
		this.cabeceraEnvioDetalleImpDTO = cabeceraEnvioDetalleImpDTO;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArchivoImpDTO other = (ArchivoImpDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @return the contenidosArchivo
	 */
	public Collection<ContenidoArchivoImpDTO> getContenidosArchivo() {
		return contenidosArchivo;
	}

	/**
	 * @param contenidosArchivo the contenidosArchivo to set
	 */
	public void setContenidosArchivo(
			Collection<ContenidoArchivoImpDTO> contenidosArchivo) {
		this.contenidosArchivo = contenidosArchivo;
	}
	
	

}
