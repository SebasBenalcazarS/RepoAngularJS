/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.constants.EventTypeEnum;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.ClasesUtil;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICNombresAtributosUtil;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public abstract class CaracteristicaVO <T extends IBaseEntidad> extends EntidadVO<T> {

	private Boolean seEstablecioCaracteristicas;
	private Integer codigoCaracteristicaActual;
	private Duplex<Integer, List<CatalogoValorDTO>> caracteristicaActual;
	private Map<Integer, Duplex<Integer, List<CatalogoValorDTO>>> caracteristicas;

	private EventTypeEnum tipoEventoPersistencia;




	/**
	 * @return the caracteristicaActual
	 */
	protected Duplex<Integer, List<CatalogoValorDTO>> getCaracteristicaActual() {
		return this.caracteristicaActual;
	}


	/**
	 * 
	 * @param caracteristicas
	 * @param tipoEventoPersistencia
	 */
	public void setCaracteristicasConSeleccionPorDefecto(Map<Integer, List<CatalogoValorDTO>> caracteristicas, 
			EventTypeEnum tipoEventoPersistencia){

		this.setCaracteristicasConSeleccionPorDefecto(caracteristicas, tipoEventoPersistencia, Boolean.FALSE);

	}

	/**
	 * 
	 * @param caracteristicas
	 * @param tipoEventoPersistencia
	 */
	public void addCaracteristicasConSeleccionPorDefecto(Map<Integer, List<CatalogoValorDTO>> caracteristicas, 
			EventTypeEnum tipoEventoPersistencia){

		this.setCaracteristicasConSeleccionPorDefecto(caracteristicas, tipoEventoPersistencia, Boolean.TRUE);

	}


	/*
	 * TODO: actualmente se asume que solamente esta configurado un catalogo valor
	 * por defecto, falta implementar la caracteristica de que haya mas de
	 * un valor por defecto; una opcion para implementar esto es tener un Map de
	 * caracteristicas de tipo Map<Set<Integer>, Duplex<Integer, List<CatalogoValorDTO>>>
	 * en lugar del actual Map<Integer, Duplex<Integer, List<CatalogoValorDTO>>>
	 */
	/**
	 * 
	 * @param caracteristicas
	 * @param tipoEventoPersistencia
	 * @param agregarCaracteristicas
	 */
	private void setCaracteristicasConSeleccionPorDefecto(Map<Integer, List<CatalogoValorDTO>> caracteristicas, 
			EventTypeEnum tipoEventoPersistencia,
			Boolean agregarCaracteristicas){

		Integer posicionValorPorDefecto;
		Predicate esValorPorDefectoPredicado;

		if (MapUtils.isNotEmpty(caracteristicas)){

			if (BooleanUtils.isTrue(agregarCaracteristicas)){
				if (this.caracteristicas == null){
					this.caracteristicas = new HashMap<Integer, Duplex<Integer,List<CatalogoValorDTO>>>();
				}
			} else {
				this.caracteristicas = new HashMap<Integer, Duplex<Integer,List<CatalogoValorDTO>>>();
			}

			esValorPorDefectoPredicado = PredicateUtils.transformedPredicate(SICNombresAtributosUtil.getInstancia().ES_VALOR_POR_DEFECTO_CATALOGO_TRANSFORMADOR, PredicateUtils.equalPredicate(Boolean.TRUE));

			for (Map.Entry<Integer, List<CatalogoValorDTO>> caracteristica : caracteristicas.entrySet()){
				posicionValorPorDefecto = ColeccionesUtil.getInstance().search(caracteristica.getValue(), esValorPorDefectoPredicado);

				if (BooleanUtils.isTrue(agregarCaracteristicas)) {
					if (!this.caracteristicas.containsKey(caracteristica.getKey())) {
						this.caracteristicas.put(caracteristica.getKey(), new Duplex<Integer, List<CatalogoValorDTO>>(posicionValorPorDefecto > 0 ? posicionValorPorDefecto : 0, caracteristica.getValue()));
					}
				} else {
					this.caracteristicas.put(caracteristica.getKey(), new Duplex<Integer, List<CatalogoValorDTO>>(posicionValorPorDefecto > 0 ? posicionValorPorDefecto : 0, caracteristica.getValue()));
				}
			}
		}

		this.tipoEventoPersistencia = tipoEventoPersistencia;
		if (this.esConfigurable(tipoEventoPersistencia)){
			this.establecerCaracteristicasRelacionadas(this.caracteristicas);
		}

	}


	/**
	 * 
	 * @param caracteristicas
	 */
	public void setCaracteristicas(Map<Integer, Duplex<Integer, List<CatalogoValorDTO>>> caracteristicas, 
			EventTypeEnum tipoEventoPersistencia){

		this.caracteristicas = caracteristicas;
		this.tipoEventoPersistencia = tipoEventoPersistencia;

		if (this.esConfigurable(tipoEventoPersistencia)){
			this.establecerCaracteristicasRelacionadas(this.caracteristicas);
		}
	}


	/**
	 * 
	 * @param caracteristicas
	 */
	public void setCaracteristicasSinSeleccionPorDefecto(Map<Integer, List<CatalogoValorDTO>> caracteristicas, 
			EventTypeEnum tipoEventoPersistencia){

		if (MapUtils.isNotEmpty(caracteristicas)){
			this.caracteristicas = new HashMap<Integer, Duplex<Integer,List<CatalogoValorDTO>>>(caracteristicas.size());
			for (Entry<Integer, List<CatalogoValorDTO>> caracteristica : caracteristicas.entrySet()){
				this.caracteristicas.put(caracteristica.getKey(), new Duplex<Integer, List<CatalogoValorDTO>>(0, caracteristica.getValue()));
			}
		}

		this.tipoEventoPersistencia = tipoEventoPersistencia;

		if (this.esConfigurable(tipoEventoPersistencia)){
			this.establecerCaracteristicasRelacionadas(this.caracteristicas);
		}
	}


	/**
	 * 
	 * @param caracteristicas
	 */
	private void establecerCaracteristicasRelacionadas(Map<Integer, Duplex<Integer, List<CatalogoValorDTO>>> caracteristicas){
		if (MapUtils.isNotEmpty(caracteristicas)){
			for(Duplex<Integer, List<CatalogoValorDTO>> caracteristica : caracteristicas.values()){
				this.setValoresCarateristicaRelacionadas(caracteristica);
			}
		}
	}


	/**
	 * 
	 * @param codigoCaracteristicas
	 * @return
	 */
	private Duplex<Integer, List<CatalogoValorDTO>> getCaracteristica(Integer codigoCaracteristica){

		if (MapUtils.isNotEmpty(this.caracteristicas)){

			if (this.codigoCaracteristicaActual == null || this.codigoCaracteristicaActual != codigoCaracteristica){
				this.codigoCaracteristicaActual = codigoCaracteristica;	
				this.caracteristicaActual = this.caracteristicas.get(codigoCaracteristica);

				return this.caracteristicaActual;
			}

			return this.caracteristicaActual;
		}

		return null;

	}


	/**
	 * 
	 * @param codigoCaracteristica
	 * @return
	 */
	public List<CatalogoValorDTO> getCaracteristicas(Integer codigoCaracteristica){

		this.getCaracteristica(codigoCaracteristica); //se establece this.caracteristicaActual
		if (this.caracteristicaActual != null){
			return this.caracteristicaActual.getSecondObject();
		}
		return null;
	}


	/**
	 * 
	 * @param indiceCaracteristica
	 * @param codigoCaracteristica
	 */
	protected void setIndiceCaracteristicaSeleccionada(Integer indiceCaracteristica, Integer codigoCaracteristica){
		this.getCaracteristica(codigoCaracteristica); //se establece this.caracteristicaActual

		if (this.caracteristicaActual != null && CollectionUtils.isNotEmpty(this.caracteristicaActual.getSecondObject())){
			if (this.caracteristicaActual.getSecondObject().size() < indiceCaracteristica){
				throw new SICException("el indice es: " + indiceCaracteristica + " y las caracteristicas: " + this.caracteristicaActual.getSecondObject().size());
			}

			this.caracteristicaActual.setFirstObject(indiceCaracteristica);


			//caracteristicas relacionadas
			if (this.esConfigurable(this.tipoEventoPersistencia)){
				Logeable.LOG_SICV2.info("---es---configurable");
				this.setValoresCarateristicaRelacionadas(this.caracteristicaActual);
			}

		}
	}


	/**
	 * 
	 * @return
	 */
	public Boolean esConfigurable(EventTypeEnum tipoEventoPersistencia){
		return EventTypeEnum.CREATE.equals(tipoEventoPersistencia);
	}



	/**
	 * 
	 * @param caracteristicaActual
	 */
	protected void setValoresCarateristicaRelacionadas(Duplex<Integer, List<CatalogoValorDTO>> caracteristicaActual){
		CatalogoValorDTO caracteristicaSeleccionada;

		try {
			caracteristicaSeleccionada = this.getCaracteristicaSeleccionada(caracteristicaActual);
			if (caracteristicaSeleccionada != null && CollectionUtils.isNotEmpty(caracteristicaSeleccionada.getCatalogosRelacionadosDTO())){
				for (CatalogoValorDTO caracteristicaRelacionada : caracteristicaSeleccionada.getCatalogosRelacionadosDTO()){
					this.setCaracteristicaSeleccionada(caracteristicaRelacionada);
				}
			}
		} finally {
			caracteristicaSeleccionada = null;
		}

	}


	/**
	 * 
	 * @param codigoCaracteristica
	 * @return
	 */
	protected Integer getIndiceCaracteristicaSeleccionada(Integer codigoCaracteristica){
		this.getCaracteristica(codigoCaracteristica); //se establece this.caracteristicaActual
		if (this.caracteristicaActual != null){
			return this.caracteristicaActual.getFirstObject();
		}

		return null;
	}


	/**
	 * 
	 * @param codigoCaracteristica
	 * @return
	 */
	public CatalogoValorDTO getCaracteristicaSeleccionada(Integer codigoCaracteristica){

		this.getCaracteristica(codigoCaracteristica); //se establece this.caracteristicaActual

		if (this.caracteristicaActual != null){
			return this.getCaracteristicaSeleccionada(this.caracteristicaActual);
		}

		return null;
	}

	/**
	 * 
	 * @param codigoCaracteristica
	 * @param valorCaracteristica
	 * @return
	 */
	public Boolean esCaracteristicaSeleccionada(Integer codigoCaracteristica, String valorCaracteristica){
		CatalogoValorDTO caracteristicaSeleccionada;

		try {
			caracteristicaSeleccionada = this.getCaracteristicaSeleccionada(codigoCaracteristica);
			if (caracteristicaSeleccionada != null){
				return StringUtils.equals(caracteristicaSeleccionada.getId().getCodigoCatalogoValor(), valorCaracteristica);
			}

			return Boolean.FALSE;
		} catch (Exception e){
			throw new SICException(e);
		} finally {
			caracteristicaSeleccionada = null;
		}

	}


	/**
	 * 
	 * @param caracteristicaActual
	 * @return
	 */
	protected CatalogoValorDTO getCaracteristicaSeleccionada(Duplex<Integer, List<CatalogoValorDTO>> caracteristicaActual){
		return caracteristicaActual.getSecondObject().get(caracteristicaActual.getFirstObject());
	}



	/**
	 * 
	 * @param caracteristicas
	 */
	public void setCaracteristicasSeleccionadas(Collection<CatalogoValorDTO> caracteristicas){

		if (CollectionUtils.isNotEmpty(caracteristicas)){
			for (CatalogoValorDTO caracteristica : caracteristicas){
				this.setCaracteristicaSeleccionada(caracteristica);
			}
		}
	}


	/**
	 * 
	 * @param codigoCaracteristica
	 */
	public void setCaracteristicaSeleccionada(CatalogoValorDTO caracteristica){

		Integer indiceCaracteristicaSeleccionada;

		this.getCaracteristica(caracteristica.getId().getCodigoCatalogoTipo()); //se establece this.caracteristicaActual
		if (this.caracteristicaActual != null && CollectionUtils.isNotEmpty(this.caracteristicaActual.getSecondObject())){
			indiceCaracteristicaSeleccionada = ColeccionesUtil.getInstance().search(this.caracteristicaActual.getSecondObject(), 
					PredicateUtils.andPredicate(
							PredicateUtils.transformedPredicate(SICNombresAtributosUtil.getInstancia().CODIGO_VALOR_TRANSFORMADOR, PredicateUtils.equalPredicate(caracteristica.getId().getCodigoCatalogoValor())), 
							PredicateUtils.transformedPredicate(SICNombresAtributosUtil.getInstancia().CODIGO_TIPO_TRANSFORMADOR, PredicateUtils.equalPredicate(caracteristica.getId().getCodigoCatalogoTipo()))
							));

			if (indiceCaracteristicaSeleccionada >= 0){
				this.caracteristicaActual.setFirstObject(indiceCaracteristicaSeleccionada);
			}
		}
	}

	/**
	 * 
	 * @param entidad
	 * @param codigoCaracteristica
	 * @param nombresAtributos
	 */
	public void setValoresCaracteristica(Object entidad, Integer codigoCaracteristica, String... nombresAtributos){
		CatalogoValorDTO caracteristicaSeleccionada;

		this.seEstablecioCaracteristicas = Boolean.FALSE;

		if (entidad != null && !ArrayUtils.isEmpty(nombresAtributos)){
			
			caracteristicaSeleccionada = this.getCaracteristicaSeleccionada(codigoCaracteristica);
			
			if (caracteristicaSeleccionada != null){
				for (int i = 0; i < nombresAtributos.length; i++){
					ClasesUtil.invocarMetodoSet(entidad, nombresAtributos[i], ClasesUtil.invocarMetodoGet(caracteristicaSeleccionada, SICNombresAtributosUtil.getInstancia().NOMBRES_ATRIBUTOS_ID_CATALOGO_VALOR[i]));
				}
				this.seEstablecioCaracteristicas = Boolean.TRUE;
			}
		}
	}




	/**
	 * @return the seEstablecioCaracteristicas
	 */
	public Boolean getSeEstablecioCaracteristicas() {
		return seEstablecioCaracteristicas;
	}


	/**
	 * @return the tipoEventoPersistencia
	 */
	public EventTypeEnum getTipoEventoPersistencia() {
		return tipoEventoPersistencia;
	}




}
