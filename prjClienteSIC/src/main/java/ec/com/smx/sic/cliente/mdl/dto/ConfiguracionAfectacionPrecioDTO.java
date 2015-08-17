/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoCatalogosGestionPrecios;
import ec.com.smx.sic.cliente.mdl.dto.id.ConfiguracionAfectacionPrecioID;

/**
 * @author cjara
 *
 */
@Entity
@Table(name="SCPRETCONAFEPRE")
@SuppressWarnings("serial")
public class ConfiguracionAfectacionPrecioDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private ConfiguracionAfectacionPrecioID id;
	
	@ComparatorTypeField
	@Column(name = "CODIGOREFERENCIAVARIACION", nullable = false)
	private String codigoReferenciaVariacion;
	
	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)	
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOTIPOAFECTACION", referencedColumnName="CODIGOTIPOAFECTACION", insertable=false, updatable=false)})
	private TipoAfectacionPrecioDTO tipoAfectacionPrecio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOTIPOVARIACION", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "VALORTIPOVARIACION", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)})
	private CatalogoValorDTO tipoVariacion;
	
	/**
	 * Entrega los signos +, -, = debe cargarse el valor relacionado del tipo de variacion
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection<CatalogoValorDTO> getSignosTipoVariacion(){
		Collection<CatalogoValorDTO> signos = null;
		if(isLoaded(tipoVariacion)){
			if(CollectionUtils.isNotEmpty(tipoVariacion.getCatalogosRelacionadosDTO())){
				signos = (Collection<CatalogoValorDTO>) CollectionUtils.select(tipoVariacion.getCatalogosRelacionadosDTO(),
						PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoCatalogoTipo"), 
								PredicateUtils.equalPredicate(TipoCatalogosGestionPrecios.SIGNO_VARIACION_PRECIO)));
			}
		}
		if(CollectionUtils.isNotEmpty(signos)){
			signos = ColeccionesUtil.sort(signos, ColeccionesUtil.ORDEN_ASC, "orden");
		}
		return signos;
	}
	
	/**
	 * Entrega los simbolos de %, $ debe cargarse el valor relacionado del tipo de variacion
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection<CatalogoValorDTO> getUnidadesTipoVariacion(){
		Collection<CatalogoValorDTO> simbolos = null;
		if(isLoaded(tipoVariacion)){
			if(CollectionUtils.isNotEmpty(tipoVariacion.getCatalogosRelacionadosDTO())){
				simbolos = (Collection<CatalogoValorDTO>) CollectionUtils.select(tipoVariacion.getCatalogosRelacionadosDTO(),
						PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoCatalogoTipo"), 
								PredicateUtils.equalPredicate(TipoCatalogosGestionPrecios.UNIDAD_VARIACION_PRECIO)));
			}
		}
		if(CollectionUtils.isNotEmpty(simbolos)){
			simbolos = ColeccionesUtil.sort(simbolos, ColeccionesUtil.ORDEN_ASC, "orden");
		}
		return simbolos;
	}
	
	/**
	 * @return the id
	 */
	public ConfiguracionAfectacionPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ConfiguracionAfectacionPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the tipoVariacion
	 */
	public CatalogoValorDTO getTipoVariacion() {
		return tipoVariacion;
	}

	/**
	 * @param tipoVariacion the tipoVariacion to set
	 */
	public void setTipoVariacion(CatalogoValorDTO tipoVariacion) {
		this.tipoVariacion = tipoVariacion;
	}

	/**
	 * @return the codigoReferenciaVariacion
	 */
	public String getCodigoReferenciaVariacion() {
		return codigoReferenciaVariacion;
	}

	/**
	 * @param codigoReferenciaVariacion the codigoReferenciaVariacion to set
	 */
	public void setCodigoReferenciaVariacion(String codigoReferenciaVariacion) {
		this.codigoReferenciaVariacion = codigoReferenciaVariacion;
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
	 * @return the tipoAfectacionPrecio
	 */
	public TipoAfectacionPrecioDTO getTipoAfectacionPrecio() {
		return tipoAfectacionPrecio;
	}

	/**
	 * @param tipoAfectacionPrecio the tipoAfectacionPrecio to set
	 */
	public void setTipoAfectacionPrecio(TipoAfectacionPrecioDTO tipoAfectacionPrecio) {
		this.tipoAfectacionPrecio = tipoAfectacionPrecio;
	}
}
