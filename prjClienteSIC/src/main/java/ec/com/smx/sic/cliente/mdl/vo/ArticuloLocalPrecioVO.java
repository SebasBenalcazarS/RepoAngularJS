package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;

public class ArticuloLocalPrecioVO extends BaseVO<ArticuloLocalPrecioDTO> implements Serializable, Comparable<ArticuloLocalPrecioVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Establecimiento padre
	 */
	private EstablecimientoDTO establecimientoDTO;
	/**
	 * Local
	 */
	private AreaTrabajoDTO localDTO;
	/**
	 * Bandera para identificar si es un establecimiento
	 */
	private Boolean esEstab = Boolean.FALSE;
	/**
	 * Bandera para identificar si es un articulo local precio
	 */
	private Boolean esArtLocPrec = Boolean.FALSE;
	/**
	 * Bandera para identificar si es un local.
	 */
	private Boolean esLocal = Boolean.FALSE;

	private Boolean seleccionado = Boolean.FALSE;

	private Boolean rendered = Boolean.TRUE;

	private Integer numHijosEstab = 0;

	private Boolean detalle = Boolean.TRUE;

	private Double valorSesion;

	private String codTipoPrecioSesion;

	private String codEstadoSesion;

	private ArticuloUnidadManejoDTO unidadManejoSesion;

	private Boolean tieneAlcance = Boolean.FALSE;
	
	private Collection<ArticuloLocalPrecioDTO> articuloLocalPrecioCol;
	
	private ArticuloLocalDTO articuloLocal;
	
	private Integer numLocales;
	
	/**
	 * Campos utilizados para la asignacion masiva de alcances
	 */
	private Boolean notificarLocal = Boolean.FALSE;
	
	private Boolean aperturaLocal = Boolean.FALSE;

	/**
	 * @return the establecimientoDTO
	 */
	public EstablecimientoDTO getEstablecimientoDTO() {
		return establecimientoDTO;
	}

	/**
	 * @param establecimientoDTO
	 *            the establecimientoDTO to set
	 */
	public void setEstablecimientoDTO(EstablecimientoDTO establecimientoDTO) {
		this.establecimientoDTO = establecimientoDTO;
	}

	/**
	 * @return the localDTO
	 */
	public AreaTrabajoDTO getLocalDTO() {
		return localDTO;
	}

	/**
	 * @param localDTO
	 *            the localDTO to set
	 */
	public void setLocalDTO(AreaTrabajoDTO localDTO) {
		this.localDTO = localDTO;
	}

	/**
	 * @return the esEstab
	 */
	public Boolean getEsEstab() {
		return esEstab;
	}

	/**
	 * @param esEstab
	 *            the esEstab to set
	 */
	public void setEsEstab(Boolean esEstab) {
		this.esEstab = esEstab;
	}

	/**
	 * @return the esArtLocPrec
	 */
	public Boolean getEsArtLocPrec() {
		return esArtLocPrec;
	}

	/**
	 * @param esArtLocPrec
	 *            the esArtLocPrec to set
	 */
	public void setEsArtLocPrec(Boolean esArtLocPrec) {
		this.esArtLocPrec = esArtLocPrec;
	}

	/**
	 * @return the esLocal
	 */
	public Boolean getEsLocal() {
		return esLocal;
	}

	/**
	 * @param esLocal
	 *            the esLocal to set
	 */
	public void setEsLocal(Boolean esLocal) {
		this.esLocal = esLocal;
	}

	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado
	 *            the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	/**
	 * @return the rendered
	 */
	public Boolean getRendered() {
		return rendered;
	}

	/**
	 * @param rendered
	 *            the rendered to set
	 */
	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	/**
	 * @return the numHijosEstab
	 */
	public Integer getNumHijosEstab() {
		return numHijosEstab;
	}

	/**
	 * @param numHijosEstab
	 *            the numHijosEstab to set
	 */
	public void setNumHijosEstab(Integer numHijosEstab) {
		this.numHijosEstab = numHijosEstab;
	}

	/**
	 * @return the detalle
	 */
	public Boolean getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *            the detalle to set
	 */
	public void setDetalle(Boolean detalle) {
		this.detalle = detalle;
	}

	public int compareTo(ArticuloLocalPrecioVO es) {
		Boolean tieneAlcance = Boolean.FALSE;
		Boolean tieneAlc = Boolean.FALSE;
		if (this.localDTO != null && this.localDTO.getDynamicProperty("tieneAlcance") != null && es.localDTO != null && es.localDTO.getDynamicProperty("tieneAlcance") != null) {
			tieneAlcance = (Boolean)this.localDTO.getDynamicProperty("tieneAlcance");
			tieneAlc = (Boolean)es.localDTO.getDynamicProperty("tieneAlcance");
		}
		tieneAlcance = Boolean.FALSE;
		tieneAlc = Boolean.FALSE;;
		int compare = 0;
		if (this.establecimientoDTO.getId().getCodigoEstablecimiento().compareTo(es.getEstablecimientoDTO().getId().getCodigoEstablecimiento()) == 0 && es.getEsArtLocPrec() && this.localDTO != null) {
			compare = this.localDTO.getId().getCodigoAreaTrabajo().compareTo(es.getLocalDTO().getId().getCodigoAreaTrabajo());
		} else if (tieneAlcance && tieneAlc) {
			compare = this.localDTO.getId().getCodigoAreaTrabajo().compareTo(es.getLocalDTO().getId().getCodigoAreaTrabajo());
		} else {
			compare = this.establecimientoDTO.getId().getCodigoEstablecimiento().compareTo(es.getEstablecimientoDTO().getId().getCodigoEstablecimiento());
		}
		return (compare);
	}

	/**
	 * @return the valorSesion
	 */
	public Double getValorSesion() {
		return valorSesion;
	}

	/**
	 * @param valorSesion
	 *            the valorSesion to set
	 */
	public void setValorSesion(Double valorSesion) {
		this.valorSesion = valorSesion;
	}

	/**
	 * @return the codTipoPrecioSesion
	 */
	public String getCodTipoPrecioSesion() {
		return codTipoPrecioSesion;
	}

	/**
	 * @param codTipoPrecioSesion
	 *            the codTipoPrecioSesion to set
	 */
	public void setCodTipoPrecioSesion(String codTipoPrecioSesion) {
		this.codTipoPrecioSesion = codTipoPrecioSesion;
	}

	/**
	 * @return the codEstadoSesion
	 */
	public String getCodEstadoSesion() {
		return codEstadoSesion;
	}

	/**
	 * @param codEstadoSesion
	 *            the codEstadoSesion to set
	 */
	public void setCodEstadoSesion(String codEstadoSesion) {
		this.codEstadoSesion = codEstadoSesion;
	}

	/**
	 * @return the unidadManejoSesion
	 */
	public ArticuloUnidadManejoDTO getUnidadManejoSesion() {
		return unidadManejoSesion;
	}

	/**
	 * @param unidadManejoSesion
	 *            the unidadManejoSesion to set
	 */
	public void setUnidadManejoSesion(ArticuloUnidadManejoDTO unidadManejoSesion) {
		this.unidadManejoSesion = unidadManejoSesion;
	}

	/**
	 * @return the tieneAlcance
	 */
	public Boolean getTieneAlcance() {
		return tieneAlcance;
	}

	/**
	 * @param tieneAlcance
	 *            the tieneAlcance to set
	 */
	public void setTieneAlcance(Boolean tieneAlcance) {
		this.tieneAlcance = tieneAlcance;
	}

	/**
	 * @return the articuloLocalPrecioCol
	 */
	public Collection<ArticuloLocalPrecioDTO> getArticuloLocalPrecioCol() {
		return articuloLocalPrecioCol;
	}

	/**
	 * @param articuloLocalPrecioCol the articuloLocalPrecioCol to set
	 */
	public void setArticuloLocalPrecioCol(
			Collection<ArticuloLocalPrecioDTO> articuloLocalPrecioCol) {
		this.articuloLocalPrecioCol = articuloLocalPrecioCol;
	}
	
	public ArticuloLocalPrecioDTO getArticuloPrecioDTOBase() {
		if (!CollectionUtils.isEmpty(this.articuloLocalPrecioCol)){
			for (ArticuloLocalPrecioDTO artLocPre : this.articuloLocalPrecioCol) {
				if (StringUtils.equals(artLocPre.getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)) {
					return artLocPre;
				}
			}
		}
		return null;
	}
	
	public ArticuloLocalPrecioDTO getArticuloPrecioDTOCaja() {
		if (!CollectionUtils.isEmpty(this.articuloLocalPrecioCol)){
			for (ArticuloLocalPrecioDTO artLocPre : this.articuloLocalPrecioCol) {
				if (StringUtils.equals(artLocPre.getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA)) {
					return artLocPre;
				}
			}
		}
		return null;
	}

	public ArticuloLocalPrecioDTO getArticuloPrecioDTOMayorista() {
		if (!CollectionUtils.isEmpty(this.articuloLocalPrecioCol)){
			for (ArticuloLocalPrecioDTO artLocPre : this.articuloLocalPrecioCol) {
				if (StringUtils.equals(artLocPre.getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA)) {
					return artLocPre;
				}
			}
		}
		return null;
	}
	
	public ArticuloLocalPrecioDTO getArticuloPrecioDTOBaseActivo() {
		if (!CollectionUtils.isEmpty(this.articuloLocalPrecioCol)){
			for (ArticuloLocalPrecioDTO artLocPre : this.articuloLocalPrecioCol) {
				if (StringUtils.equals(artLocPre.getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)
						&& StringUtils.equals(artLocPre.getEstadoPrecio(),SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)) {
					return artLocPre;
				}
			}
		}
		return null;
	}
	
	public ArticuloLocalPrecioDTO getArticuloPrecioDTOCajaActivo() {
		if (!CollectionUtils.isEmpty(this.articuloLocalPrecioCol)){
			for (ArticuloLocalPrecioDTO artLocPre : this.articuloLocalPrecioCol) {
				if (StringUtils.equals(artLocPre.getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA)
						&& StringUtils.equals(artLocPre.getEstadoPrecio(),SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)) {
					return artLocPre;
				}
			}
		}
		return null;
	}

	public ArticuloLocalPrecioDTO getArticuloPrecioDTOMayoristaActivo() {
		if (!CollectionUtils.isEmpty(this.articuloLocalPrecioCol)){
			for (ArticuloLocalPrecioDTO artLocPre : this.articuloLocalPrecioCol) {
				if (StringUtils.equals(artLocPre.getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA)
						&& StringUtils.equals(artLocPre.getEstadoPrecio(),SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)) {
					return artLocPre;
				}
			}
		}
		return null;
	}
	
	public Collection<ArticuloLocalPrecioDTO> getArticulosLocalesPreciosActivos() {
		Collection<ArticuloLocalPrecioDTO> listaArtLocPreActivos = new ArrayList<ArticuloLocalPrecioDTO>();
		if (!CollectionUtils.isEmpty(this.articuloLocalPrecioCol)) {
			for (ArticuloLocalPrecioDTO artlocpre : this.articuloLocalPrecioCol) {
				if (StringUtils.equals(artlocpre.getEstadoPrecio(),SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)) {
					listaArtLocPreActivos.add(artlocpre);
				}
			}
		}
		return listaArtLocPreActivos;
	}
	
	public Collection<ArticuloPrecioDTO> getObtenerTodosArticulosPrecios() {
		Collection<ArticuloPrecioDTO> articulosPreciosCol = new ArrayList<ArticuloPrecioDTO>();
		if (!CollectionUtils.isEmpty(getArticulosLocalesPreciosActivos())) {
			for (ArticuloLocalPrecioDTO articuloLocalPrecioDTO : getArticulosLocalesPreciosActivos()) {
				articulosPreciosCol.add(articuloLocalPrecioDTO.getArticuloPrecio());
			}
		}
		return articulosPreciosCol;
	}

	/**
	 * @return the articuloLocal
	 */
	public ArticuloLocalDTO getArticuloLocal() {
		return articuloLocal;
	}

	/**
	 * @param articuloLocal the articuloLocal to set
	 */
	public void setArticuloLocal(ArticuloLocalDTO articuloLocal) {
		this.articuloLocal = articuloLocal;
	}
	
	public ArticuloPrecioDTO getArticuloPrecioBase () {
		if (!CollectionUtils.isEmpty(getArticulosLocalesPreciosActivos())) {
			for (ArticuloLocalPrecioDTO articuloLocalPrecioDto : getArticulosLocalesPreciosActivos()) {
				if (articuloLocalPrecioDto.getArticuloPrecio() != null
						&& StringUtils.equals(articuloLocalPrecioDto.getArticuloPrecio().getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)) {
					return articuloLocalPrecioDto.getArticuloPrecio();
				}
			}
		}
		return null;
	}
	
	public ArticuloPrecioDTO getArticuloPrecioCaja () {
		if (!CollectionUtils.isEmpty(getArticulosLocalesPreciosActivos())) {
			for (ArticuloLocalPrecioDTO articuloLocalPrecioDto : getArticulosLocalesPreciosActivos()) {
				if (articuloLocalPrecioDto.getArticuloPrecio() != null
						&& StringUtils.equals(articuloLocalPrecioDto.getArticuloPrecio().getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA)) {
					return articuloLocalPrecioDto.getArticuloPrecio();
				}
			}
		}
		return null;
	}
	
	public ArticuloPrecioDTO getArticuloPrecioMayorista () {
		if (!CollectionUtils.isEmpty(getArticulosLocalesPreciosActivos())) {
			for (ArticuloLocalPrecioDTO articuloLocalPrecioDto : getArticulosLocalesPreciosActivos()) {
				if (articuloLocalPrecioDto.getArticuloPrecio() != null
						&& StringUtils.equals(articuloLocalPrecioDto.getArticuloPrecio().getId().getCodigoTipoPrecio(), SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA)) {
					return articuloLocalPrecioDto.getArticuloPrecio();
				}
			}
		}
		return null;
	}

	/**
	 * @return the notificarLocal
	 */
	public Boolean getNotificarLocal() {
		return notificarLocal;
	}

	/**
	 * @param notificarLocal the notificarLocal to set
	 */
	public void setNotificarLocal(Boolean notificarLocal) {
		this.notificarLocal = notificarLocal;
	}

	/**
	 * @return the aperturaLocal
	 */
	public Boolean getAperturaLocal() {
		return aperturaLocal;
	}

	/**
	 * @param aperturaLocal the aperturaLocal to set
	 */
	public void setAperturaLocal(Boolean aperturaLocal) {
		this.aperturaLocal = aperturaLocal;
	}

	/**
	 * @return the numLocales
	 */
	public Integer getNumLocales() {
		return numLocales;
	}

	/**
	 * @param numLocales the numLocales to set
	 */
	public void setNumLocales(Integer numLocales) {
		this.numLocales = numLocales;
	}

	
	
}
