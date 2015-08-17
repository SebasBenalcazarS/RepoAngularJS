/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.rotulado;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearch;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.plantillas.common.util.PlantillasConstantes;
import ec.com.smx.corpv2.plantillas.dto.ConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.DetalleConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.DetalleGrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.GrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorGrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.id.ConfiguracionPlantillaID;
import ec.com.smx.corpv2.plantillas.dto.id.GrupoCampoPlantillaID;
import ec.com.smx.corpv2.plantillas.dto.id.ValorConfiguracionPlantillaID;
import ec.com.smx.corpv2.plantillas.dto.id.ValorGrupoCampoPlantillaID;
import ec.com.smx.corpv2.plantillas.gestor.IPlantillasGestor;
import ec.com.smx.corpv2.plantillas.gestor.ISicronizacionComponentesRotuladoGestor;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.rotulado.IArticuloRotuladoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloValorConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloValorConfiguracionPlantillaID;
import ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionConfiguracionPlantillaID;
import ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionID;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;
import ec.com.smx.sic.cliente.persistencia.restricciones.ArticuloValorConfiguracionPlantillaRestriction;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author acaiza
 * 
 */

public class ArticuloRotuladoGestor implements IArticuloRotuladoGestor {

	private DataGestor dataGestor;
	
	private IParametroGestor parametroGestor; 

	private IPlantillasGestor plantillasGestor;
	
	/**
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.obtenerClasificacionConfiguracionPlantillaByClasificacion(String)
	 */
	@Override
	public Collection<ClasificacionConfiguracionPlantillaDTO> obtenerClasificacionConfiguracionPlantillaByClasificacion(String codigoClasificacion) throws SICException {

		Collection<ClasificacionConfiguracionPlantillaDTO> coll = null;

		ClasificacionDTO clasificacion = new ClasificacionDTO();
		ConfiguracionPlantillaDTO configuracionPlantilla = new ConfiguracionPlantillaDTO();

		ClasificacionConfiguracionPlantillaDTO claconpla = new ClasificacionConfiguracionPlantillaDTO();
		claconpla.setId(new ClasificacionConfiguracionPlantillaID());
		claconpla.getId().setCodigoClasificacion(codigoClasificacion);
		claconpla.setClasificacion(clasificacion);
		claconpla.setConfiguracionPlantilla(configuracionPlantilla);

		coll = dataGestor.findObjects(claconpla);

		return coll;
	}

	/**
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.obtenerConfiguracionesPlantillaByArticulo(ArticuloDTO, ValorConfiguracionPlantillaDTO)
	 */
	@Override
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionesPlantillaByArticulo(ArticuloDTO articulo, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO, Integer codigoCompania, String estado) throws SICException {

		Collection<ConfiguracionPlantillaDTO> coll = null;
		//Integer codigoCompania = 1;

		Set<String> codigosClasificaciones = null;
		codigosClasificaciones = buscarJerarquiaCodigosClasificaciones(articulo, codigoCompania);
		//Logeable.LOG_SICV2.info("CLASIFICACIONES: " + codigosClasificaciones);

		Set<Integer> codigosConPla = null;
		//codigosConPla = buscarCodigosConfiguracionesPlantilla(codigosClasificaciones);
		Integer codigoConfiguracionPlantilla = buscarCodigoConfiguracionPlantillaPorClasificacion(articulo.getCodigoClasificacion(), codigoCompania);
		if (codigoConfiguracionPlantilla != null) {
			codigosConPla = new HashSet<Integer>();
			codigosConPla.add(codigoConfiguracionPlantilla);
		}
		
		//Logeable.LOG_SICV2.info("PLANTILLAS: " + codigosConPla);
		
		if (CollectionUtils.isEmpty(codigosConPla)) {
			throw new SICException("No existen plantillas para la clasificacion " + articulo.getCodigoClasificacion());
		}

		coll = plantillasGestor.obtenerConfiguracionPlantillas(codigosConPla, valorConfiguracionPlantillaDTO, estado);

		return coll;
	}

	/**
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.grabarValoresPlantilla(ArticuloDTO, Collection<ConfiguracionPlantillaDTO>, String)
	 */
	@Override
	public void grabarValoresPlantilla(ArticuloDTO articuloDTO, Collection<ConfiguracionPlantillaDTO> configuracionPlantillaDTOs, String codigoUsuario, ProveedorDTO proveedorDTO) throws SICException {
		try {
			plantillasGestor.grabarValoresPlantilla(configuracionPlantillaDTOs, codigoUsuario);
			if (CollectionUtils.isNotEmpty(configuracionPlantillaDTOs)) {
				for (ConfiguracionPlantillaDTO configuracionPlantillaDTO : configuracionPlantillaDTOs) {
					this.grabarValoresPlantilla(articuloDTO, configuracionPlantillaDTO, codigoUsuario, proveedorDTO, null);				
				}				
			}			
		} catch (Exception e) {
			throw new SICException(e);
		}		
	}
	
	/**
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.grabarValoresPlantilla(ArticuloDTO, ConfiguracionPlantillaDTO, String)
	 */
	@Override
	public ArticuloValorConfiguracionPlantillaDTO grabarValoresPlantilla(ArticuloDTO articuloDTO, ConfiguracionPlantillaDTO configuracionPlantillaDTO, String codigoUsuario, ProveedorDTO proveedorDTO, Integer codigoPadreAVCP) throws SICException {
		//Logeable.LOG_SICV2.info("METODO: grabarValoresPlantilla() ArticuloRotuladoGestor");
		try {
			Timestamp fechaRegistro = new Timestamp(System.currentTimeMillis());
			configuracionPlantillaDTO.setIdUsuarioModificacion(codigoUsuario);
			
			//GRABA UNA NUEVA INSTACION DE CONTROL DE ROTULADO PARA OBTENERE UN ValorConfiguracionPlantillaDTO
			plantillasGestor.grabarValoresPlantilla(configuracionPlantillaDTO, codigoUsuario, fechaRegistro);
			
			if (configuracionPlantillaDTO.getValorConfiguracionPlantillaDTO() == null) {				
				throw new SICException("ERROR No existe la referencia a la plantilla para el articulo actual");				
			}
			
			//Registra los datos de la plantilla con un articulo
			ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO = configuracionPlantillaDTO.getValorConfiguracionPlantillaDTO();
			//Logeable.LOG_SICV2.info("VALCONPLA: " + configuracionPlantillaDTO.getValorConfiguracionPlantillaDTO().getId().getCodigoValorConfiguracionPlantilla());
			
			ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO = new ArticuloValorConfiguracionPlantillaDTO();
			articuloValorConfiguracionPlantillaDTO.setId(new ArticuloValorConfiguracionPlantillaID());
			articuloValorConfiguracionPlantillaDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
			articuloValorConfiguracionPlantillaDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			articuloValorConfiguracionPlantillaDTO.getId().setCodigoValorConfiguracionPlantilla(valorConfiguracionPlantillaDTO.getId().getCodigoValorConfiguracionPlantilla());
			articuloValorConfiguracionPlantillaDTO.setIdUsuarioRegistro(codigoUsuario);
			articuloValorConfiguracionPlantillaDTO.setFechaRegistro(fechaRegistro);
			articuloValorConfiguracionPlantillaDTO.setEstado(PlantillasConstantes.ESTADO_ACTIVO_BOOLEANO);
			articuloValorConfiguracionPlantillaDTO.setFechaAuditoria(null);
			articuloValorConfiguracionPlantillaDTO.setCodigoProveedor(proveedorDTO.getId().getCodigoProveedor());
			articuloValorConfiguracionPlantillaDTO.setCodigoPadre(codigoPadreAVCP);
						
			dataGestor.create(articuloValorConfiguracionPlantillaDTO);
			
			articuloValorConfiguracionPlantillaDTO.setValorConfiguracionPlantilla(valorConfiguracionPlantillaDTO);
			
			return articuloValorConfiguracionPlantillaDTO;
			
		} catch (Exception e) {
			throw new SICException(e);
		}		
	}
	
	/**
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.actualizarValoresPlantilla(ArticuloDTO, Collection<ConfiguracionPlantillaDTO>, String)
	 */
	@Override
	public void actualizarValoresPlantilla(ArticuloDTO articuloDTO, Collection<ConfiguracionPlantillaDTO> configuracionPlantillaDTOs, String codigoUsuario) throws SICException {
		try {
			plantillasGestor.grabarValoresPlantilla(configuracionPlantillaDTOs, codigoUsuario);
			if (CollectionUtils.isNotEmpty(configuracionPlantillaDTOs)) {
				for (ConfiguracionPlantillaDTO configuracionPlantillaDTO : configuracionPlantillaDTOs) {
					actualizarValoresPlantilla(articuloDTO, configuracionPlantillaDTO, codigoUsuario);				
				}				
			}			
		} catch (Exception e) {
			throw new SICException(e);
		}		
	}
	
	/**
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.actualizarValoresPlantilla(ArticuloDTO, ConfiguracionPlantillaDTO, String)
	 */
	@Override
	public void actualizarValoresPlantilla(ArticuloDTO articuloDTO, ConfiguracionPlantillaDTO configuracionPlantillaDTO, String codigoUsuario) throws SICException {
		try {
			Timestamp fechaActualizacion = new Timestamp(System.currentTimeMillis());			
			Collection<ValorGrupoCampoPlantillaDTO> valorGrupoCampoPlantillaDTOs = new ArrayList<ValorGrupoCampoPlantillaDTO>();
			if (configuracionPlantillaDTO != null) {
				for (GrupoCampoPlantillaDTO grupoCampoPlantillaDTO : configuracionPlantillaDTO.getGrupoCampoPlantillaDTOCol()) {
					for (DetalleGrupoCampoPlantillaDTO detalleGrupoCampoPlantillaDTO : grupoCampoPlantillaDTO.getDetalleGrupoCampoPlantillaDTOCol()) {
						valorGrupoCampoPlantillaDTOs.addAll(detalleGrupoCampoPlantillaDTO.getValorGrupoCampoPlantillaDTOCol());
					}					
				}
			}
			if (CollectionUtils.isNotEmpty(valorGrupoCampoPlantillaDTOs)) {
				for (ValorGrupoCampoPlantillaDTO valorGrupoCampoPlantillaDTO : valorGrupoCampoPlantillaDTOs) {
					valorGrupoCampoPlantillaDTO.setFechaModificacion(fechaActualizacion);
					valorGrupoCampoPlantillaDTO.setIdUsuarioModificacion(codigoUsuario);
				}
			}	
			plantillasGestor.actualizarValorGrupoCampoPlantilla(valorGrupoCampoPlantillaDTOs);
			
		} catch (Exception e) {
			throw new SICException(e);
		}		
	}
	
	@Override
	public void actualizarValoresPlantilla(ArticuloDTO articuloDTO, ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Collection<ValorGrupoCampoPlantillaDTO> valorGrupoCampoPlantillaDTOs, String codigoUsuario) throws SICException {
		try {
			Timestamp fechaActualizacion = new Timestamp(System.currentTimeMillis());
			if (CollectionUtils.isNotEmpty(valorGrupoCampoPlantillaDTOs)) {
				for (ValorGrupoCampoPlantillaDTO valorGrupoCampoPlantillaDTO : valorGrupoCampoPlantillaDTOs) {
					valorGrupoCampoPlantillaDTO.setFechaModificacion(fechaActualizacion);
					valorGrupoCampoPlantillaDTO.setIdUsuarioModificacion(codigoUsuario);
				}
			}	
			plantillasGestor.actualizarValorGrupoCampoPlantilla(valorGrupoCampoPlantillaDTOs);
			
			ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO = articuloValorConfiguracionPlantillaDTO.getValorConfiguracionPlantilla();
			valorConfiguracionPlantillaDTO.setFechaModificacion(fechaActualizacion);
			valorConfiguracionPlantillaDTO.setIdUsuarioModificacion(codigoUsuario);
			dataGestor.update(valorConfiguracionPlantillaDTO);
			
			articuloValorConfiguracionPlantillaDTO.setFechaModificacion(fechaActualizacion);
			articuloValorConfiguracionPlantillaDTO.setIdUsuarioModificacion(codigoUsuario);
			dataGestor.update(articuloValorConfiguracionPlantillaDTO);
			
		} catch (Exception e) {
			throw new SICException(e);
		}	
	}
	
	public Integer buscarCodigoConfiguracionPlantillaPorClasificacion(String codigoClasificacion, Integer codigoCompania) {
		Integer codigoConfiguracionPlantilla = null;
		
		boolean band = true;
		do {
			ClasificacionConfiguracionPlantillaDTO ccp =buscarClasificacionConfiguracionPlantilla(codigoClasificacion, codigoCompania);
			if (ccp != null) {
				codigoConfiguracionPlantilla = ccp.getId().getCodigoConfiguracionPlantilla();
				band = false;
			} else {
				String codigoClasificacionPadre = buscarCodigoClasificacionPadre(codigoClasificacion, codigoCompania); 
				codigoClasificacion = codigoClasificacionPadre; 
				if (StringUtils.isEmpty(codigoClasificacion)) {
					band = false;
				}
			}
		} while(band);
		
		return codigoConfiguracionPlantilla;		
	}	
	
	public Set<String> buscarJerarquiaCodigosClasificaciones(ArticuloDTO articulo, Integer codigoCompania) throws SICException {
		Set<String> codigoClasificaciones = new HashSet<String>();

		if (articulo != null && StringUtils.isNotEmpty(articulo.getCodigoClasificacion())) {
			String codigoClasificacion = articulo.getCodigoClasificacion();
			ClasificacionDTO plantilla = new ClasificacionDTO();
			plantilla.setId(new ClasificacionID());
			plantilla.getId().setCodigoClasificacion(codigoClasificacion);
			plantilla.getId().setCodigoCompania(codigoCompania);
			plantilla.setCriteriaSearch(new CriteriaSearch());
			//TRAE SOLO LAS DOS COLUMNAS DEL ARRAY
			plantilla.getCriteriaSearch().addDistinctSearchParameter(ClasificacionDTO.class, new String[] { "id.codigoClasificacion", "codigoClasificacionPadre" });
			ClasificacionDTO clasificacion = dataGestor.findDistinct(plantilla, ClasificacionDTO.class).iterator().next();

			codigoClasificaciones.add(codigoClasificacion);

			while (StringUtils.isNotEmpty(clasificacion.getCodigoClasificacionPadre())) {
				codigoClasificacion = clasificacion.getCodigoClasificacionPadre();
				plantilla = new ClasificacionDTO();
				plantilla.setId(new ClasificacionID());
				plantilla.getId().setCodigoClasificacion(codigoClasificacion);
				plantilla.getId().setCodigoCompania(codigoCompania);
				plantilla.setCriteriaSearch(new CriteriaSearch());
				plantilla.getCriteriaSearch().addDistinctSearchParameter(ClasificacionDTO.class, new String[] { "id.codigoClasificacion", "codigoClasificacionPadre" });
				clasificacion = dataGestor.findDistinct(plantilla, ClasificacionDTO.class).iterator().next();

				codigoClasificaciones.add(clasificacion.getId().getCodigoClasificacion());
			}
		}
		return codigoClasificaciones;
	}
	
	
	public String buscarCodigoClasificacionPadre(String codigoClasificacion, Integer codigoCompania) throws SICException {
		String codigoClasificacionPadre = null;

		if (StringUtils.isNotEmpty(codigoClasificacion)) {			
			ClasificacionDTO plantilla = new ClasificacionDTO();
			plantilla.setId(new ClasificacionID());
			plantilla.getId().setCodigoClasificacion(codigoClasificacion);
			plantilla.getId().setCodigoCompania(codigoCompania);
			plantilla.setCriteriaSearch(new CriteriaSearch());
			//TRAE SOLO LAS DOS COLUMNAS DEL ARRAY EN EL OBJETO
			plantilla.getCriteriaSearch().addDistinctSearchParameter(ClasificacionDTO.class, new String[] { "id.codigoClasificacion", "codigoClasificacionPadre" });
			ClasificacionDTO clasificacion = dataGestor.findDistinct(plantilla, ClasificacionDTO.class).iterator().next();

			codigoClasificacionPadre = clasificacion.getCodigoClasificacionPadre();			
		}
		return codigoClasificacionPadre;
	}
	
	public ClasificacionConfiguracionPlantillaDTO buscarClasificacionConfiguracionPlantilla(String codigoClasificacion, Integer codigoCompania) throws SICException {
		ClasificacionConfiguracionPlantillaDTO clasificacionConfiguracionPlantillaDTO = null;

		if (StringUtils.isNotEmpty(codigoClasificacion)) {			
			ClasificacionConfiguracionPlantillaDTO plantilla = new ClasificacionConfiguracionPlantillaDTO();
			plantilla.setId(new ClasificacionConfiguracionPlantillaID());
			plantilla.getId().setCodigoClasificacion(codigoClasificacion);
			plantilla.getId().setCodigoCompania(codigoCompania);
			ConfiguracionPlantillaDTO configuracionPlantillaDTO = new ConfiguracionPlantillaDTO();
			configuracionPlantillaDTO.setEstadoConfiguracionPlantilla(PlantillasConstantes.ESTADO_ACTIVO_BOOLEANO);
			plantilla.setConfiguracionPlantilla(configuracionPlantillaDTO);
			plantilla.setCriteriaSearch(new CriteriaSearch());
			//TRAE SOLO LAS DOS COLUMNAS DEL ARRAY EN EL OBJETO
			plantilla.getCriteriaSearch().addDistinctSearchParameter(ClasificacionDTO.class, new String[] { "id.codigoClasificacion", "id.codigoConfiguracionPlantilla" });
			Collection<ClasificacionConfiguracionPlantillaDTO> clasificacionConfiguracionPlantillaCol = dataGestor.findDistinct(plantilla, ClasificacionConfiguracionPlantillaDTO.class);

			if (CollectionUtils.isNotEmpty(clasificacionConfiguracionPlantillaCol)) {
				clasificacionConfiguracionPlantillaDTO = clasificacionConfiguracionPlantillaCol.iterator().next();
			}			
		}
		return clasificacionConfiguracionPlantillaDTO;
	}

	public Set<Integer> buscarCodigosConfiguracionesPlantilla(String codigoClasificacion) throws SICException {
		Set<Integer> codigosConPla = new HashSet<Integer>();

		if (StringUtils.isNotEmpty(codigoClasificacion)) {
			ClasificacionConfiguracionPlantillaDTO plantilla = new ClasificacionConfiguracionPlantillaDTO();
			plantilla.setCriteriaSearch(new CriteriaSearch());
			plantilla.getCriteriaSearch().addDistinctSearchParameter(new String[] { "id.codigoConfiguracionPlantilla" });

			Collection<ClasificacionConfiguracionPlantillaDTO> coll = dataGestor.findDistinct(plantilla, ClasificacionConfiguracionPlantillaDTO.class);
			for (ClasificacionConfiguracionPlantillaDTO codConPla : coll) {
				codigosConPla.add(codConPla.getId().getCodigoConfiguracionPlantilla());
			}
		}
		return codigosConPla;
	}

	public Set<Integer> buscarCodigosConfiguracionesPlantilla(Set<String> codigosClasificaciones) throws SICException {
		Set<Integer> codigosConPla = new HashSet<Integer>();

		if (CollectionUtils.isNotEmpty(codigosClasificaciones)) {
			ClasificacionConfiguracionPlantillaDTO plantilla = new ClasificacionConfiguracionPlantillaDTO();
			plantilla.setCriteriaSearch(new CriteriaSearch());
			plantilla.getCriteriaSearch().addDistinctSearchParameter(ClasificacionConfiguracionPlantillaDTO.class, new String[] { "id.codigoConfiguracionPlantilla" });
			//INVIERTE EL VECTOR PARA QUE QUEDE: 'CLA', 'DET', 'DIV'
			String[] vecCodigosClasificaciones = codigosClasificaciones.toArray(new String[0]);
			String[] vecCodigosClasificacionesTemp = codigosClasificaciones.toArray(new String[0]);
			if (vecCodigosClasificaciones != null && vecCodigosClasificacionesTemp != null) {			
				for (int i=0, j = vecCodigosClasificaciones.length-1; i<vecCodigosClasificaciones.length; ) {
					vecCodigosClasificaciones[i] = vecCodigosClasificacionesTemp[j];
					i++;
					j--;
				}			
			}
			plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoClasificacion", ComparatorTypeEnum.IN_COMPARATOR, vecCodigosClasificaciones));

			Collection<ClasificacionConfiguracionPlantillaDTO> coll = dataGestor.findDistinct(plantilla, ClasificacionConfiguracionPlantillaDTO.class);
			for (ClasificacionConfiguracionPlantillaDTO codConPla : coll) {
				codigosConPla.add(codConPla.getId().getCodigoConfiguracionPlantilla());
			}
		}
		return codigosConPla;
	}

	public Collection<ClasificacionConfiguracionPlantillaDTO> buscarClasificacionConfiguracionByClasificacion(Set<String> codigosClasificaciones, Integer codigoCompania) throws SICException {

		Collection<ClasificacionConfiguracionPlantillaDTO> coll = null;

		String[] vecCodCla = codigosClasificaciones.toArray(new String[0]);

		ClasificacionConfiguracionPlantillaDTO plantillaBusqueda = new ClasificacionConfiguracionPlantillaDTO();
		plantillaBusqueda.getId().setCodigoCompania(codigoCompania);
		plantillaBusqueda.setCriteriaSearch(new CriteriaSearch());
		plantillaBusqueda.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoClasificacion", ComparatorTypeEnum.IN_COMPARATOR, vecCodCla));

		coll = dataGestor.findObjects(plantillaBusqueda);

		return coll;
	}

	@Override
	public void registrarClasificacionConfiguracionPlantilla(ClasificacionConfiguracionPlantillaDTO ccp) throws SICException {
		dataGestor.create(ccp);
	}
	
	@Override
	public Collection<ValorConfiguracionPlantillaDTO> obtenerValorConfiguracionPlantillaByArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, Timestamp fechaInicio, Timestamp fechaFin) throws SICException {
		ArticuloValorConfiguracionPlantillaDTO plantillaArtValConPla = new ArticuloValorConfiguracionPlantillaDTO();
		plantillaArtValConPla.setId(new ArticuloValorConfiguracionPlantillaID());
		plantillaArtValConPla.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
		plantillaArtValConPla.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
		plantillaArtValConPla.setCriteriaSearch(new CriteriaSearch());
		plantillaArtValConPla.getCriteriaSearch().addDistinctSearchParameter(ArticuloValorConfiguracionPlantillaDTO.class, new String[] { "id.codigoValorConfiguracionPlantilla"});
		
		if (proveedorDTO != null && proveedorDTO.getId() != null) {
			plantillaArtValConPla.setCodigoProveedor(proveedorDTO.getId().getCodigoProveedor());
		}
		
		Collection<ArticuloValorConfiguracionPlantillaDTO> collArtValConPla = dataGestor.findDistinct(plantillaArtValConPla, ArticuloValorConfiguracionPlantillaDTO.class);
		
		Collection<Integer> codigosValConPLa = new ArrayList<Integer>();
		for (ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO : collArtValConPla) {
			codigosValConPLa.add(articuloValorConfiguracionPlantillaDTO.getId().getCodigoValorConfiguracionPlantilla());
		}
		
		Collection<ValorConfiguracionPlantillaDTO> coll =  new ArrayList<ValorConfiguracionPlantillaDTO>();
		
		if (CollectionUtils.isNotEmpty(codigosValConPLa)) {
			ValorConfiguracionPlantillaDTO plantilla = new ValorConfiguracionPlantillaDTO();		
			plantilla.setId(new ValorConfiguracionPlantillaID());
			plantilla.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			plantilla.setCriteriaSearch(new CriteriaSearch());
			//plantilla.getCriteriaSearch().addDistinctSearchParameter(ValorConfiguracionPlantillaDTO.class, new String[] { "id.codigoValorConfiguracionPlantilla", "fechaRegistro", "idUsuarioRegistro"});
			plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoValorConfiguracionPlantilla", ComparatorTypeEnum.IN_COMPARATOR, codigosValConPLa.toArray(new Integer[0])));
			plantilla.setRegisterUser(new UserDto());
			plantilla.setLastModifierUser(new UserDto());
			
			if (fechaInicio != null) {
				plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Timestamp>("fechaRegistro",ComparatorTypeEnum.GREATER_THAN_OR_EQUAL_COMPARATOR ,fechaInicio));
			}			
			if (fechaFin != null) {
				plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Timestamp>("fechaRegistro",ComparatorTypeEnum.LESS_THAN_COMPARATOR ,fechaFin));
			}
			
			//coll = dataGestor.findDistinct(plantilla, ValorConfiguracionPlantillaDTO.class);
			coll = dataGestor.findObjects(plantilla);
		}
		
		//Collection<ValorConfiguracionPlantillaDTO> coll = dataGestor.findObjects(plantilla);
		return coll;
	}
	
	
	@Override
	public Collection<ArticuloValorConfiguracionPlantillaDTO> obtenerArticuloValorConfiguracionPlantillaByArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, Timestamp fechaInicio, Timestamp fechaFin) throws SICException {
		ArticuloValorConfiguracionPlantillaDTO plantillaArtValConPla = new ArticuloValorConfiguracionPlantillaDTO();
		if (articuloDTO != null && articuloDTO.getId() != null) {
			plantillaArtValConPla.setId(new ArticuloValorConfiguracionPlantillaID());
			plantillaArtValConPla.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			plantillaArtValConPla.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
		}
		if (proveedorDTO != null && proveedorDTO.getId() != null) {
			plantillaArtValConPla.setCodigoProveedor(proveedorDTO.getId().getCodigoProveedor());
		}
		plantillaArtValConPla.setUsuarioRegistro(new UserDto());
		plantillaArtValConPla.setUsuarioModificacion(new UserDto());
		plantillaArtValConPla.setUsuarioAuditoria(new UserDto());
		
		ValorConfiguracionPlantillaDTO plantillaVCP = new ValorConfiguracionPlantillaDTO();
		plantillaVCP.setRegisterUser(new UserDto());
		plantillaVCP.setLastModifierUser(new UserDto());
		plantillaArtValConPla.setValorConfiguracionPlantilla(plantillaVCP);
		
		plantillaArtValConPla.setCriteriaSearch(new CriteriaSearch());
		//plantillaArtValConPla.getCriteriaSearch().addDistinctSearchParameter(ArticuloValorConfiguracionPlantillaDTO.class, new String[] { "id.codigoValorConfiguracionPlantilla"});
		if (fechaInicio != null) {
			plantillaArtValConPla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Timestamp>("fechaRegistro",ComparatorTypeEnum.GREATER_THAN_OR_EQUAL_COMPARATOR ,fechaInicio));
		}			
		if (fechaFin != null) {
			plantillaArtValConPla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Timestamp>("fechaRegistro",ComparatorTypeEnum.LESS_THAN_COMPARATOR ,fechaFin));
		}
		
		Collection<ArticuloValorConfiguracionPlantillaDTO> coll = dataGestor.findObjects(plantillaArtValConPla);
		
		return coll;
	}
	
	/**
	 * 
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.validarCreacionRotuladoArticulo(ArticuloDTO, ProveedorDTO)
	 */
	@Override
	public Boolean validarCreacionRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException {
		Boolean band = Boolean.FALSE;
		
		ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO = obtenerUltimoControlRotuladoArticulo(articuloDTO, proveedorDTO);
		
		//SI ES NULL NO EXISTEN REGISTROS DE CONTROL DE ROTULADO
		if (articuloValorConfiguracionPlantillaDTO == null) {
			return Boolean.TRUE;
		}
		
		//Busca el valor del parametro NUMERO_DIAS_CREAR_CONTROL_ROTULADO
		Integer codigoCompania = articuloDTO.getId().getCodigoCompania();
		String codigoParametro = SICParametros.getInstancia().NUMERO_DIAS_CREAR_CONTROL_ROTULADO;				
		ParametroDTO parametro = parametroGestor.obtenerParametro(codigoCompania, codigoParametro);
		
		if (parametro == null) {
			throw new SICException("NO EXISTE EL PARAMETRO " + SICParametros.getInstancia().NUMERO_DIAS_CREAR_CONTROL_ROTULADO);
		}
		
		if (parametro != null) {
			//FECHA DEL ULTIMO ROTULADO
			Timestamp timestamp = articuloValorConfiguracionPlantillaDTO.getFechaRegistro();
			Date fechaRotulado = new Date(timestamp.getTime());		
			fechaRotulado = DateUtils.truncate(fechaRotulado, Calendar.DATE);
			//NUMERO DE DIAS PARA EL CONTROL DE ROTULADO
			Integer numeroDiasControlRotulado = Integer.valueOf(parametro.getValorParametro().trim());
			//FECHA ACTUAL
			Date fechaActual = new Date(System.currentTimeMillis());
			fechaActual = DateUtils.truncate(fechaActual, Calendar.DATE);
			
			int numeroDias = diferenciasDeFechas(fechaActual, fechaRotulado);
			int diasTranscurridos = Math.abs(numeroDias);
			if (diasTranscurridos >= numeroDiasControlRotulado) {
				return Boolean.TRUE;
			}
		}
		return band;
	}
	
	/**
	 * 
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.diasRestantesControlRotuladoArticulo(ArticuloDTO, ProveedorDTO, String)
	 */
	@Override
	public Integer diasRestantesCrearControlRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException {
		Integer diasRestantes = null;
		
		ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO = obtenerUltimoControlRotuladoArticulo(articuloDTO, proveedorDTO);
		
		//SI ES NULL NO EXISTEN REGISTROS DE CONTROL DE ROTULADO
		if (articuloValorConfiguracionPlantillaDTO == null) {
			return 0;
		}
		
		//Busca el valor del parametro NUMERO_DIAS_CREAR_CONTROL_ROTULADO
		Integer codigoCompania = articuloDTO.getId().getCodigoCompania();
		String codigoParametro = SICParametros.getInstancia().NUMERO_DIAS_CREAR_CONTROL_ROTULADO;
		
		ParametroDTO parametro = parametroGestor.obtenerParametro(codigoCompania, codigoParametro);
		
		if (parametro == null) {
			throw new SICException("NO EXISTE EL PARAMETRO " + SICParametros.getInstancia().NUMERO_DIAS_CREAR_CONTROL_ROTULADO);
		}
		
		if (parametro != null) {
			//FECHA DEL ULTIMO ROTULADO
			Timestamp timestamp = articuloValorConfiguracionPlantillaDTO.getFechaRegistro();
			Date fechaRotulado = new Date(timestamp.getTime());		
			fechaRotulado = DateUtils.truncate(fechaRotulado, Calendar.DATE);
			//NUMERO DE DIAS PARA EL CONTROL DE ROTULADO
			Integer numeroDiasControlRotulado = Integer.valueOf(parametro.getValorParametro().trim());
			//FECHA ACTUAL
			Date fechaActual = new Date(System.currentTimeMillis());
			fechaActual = DateUtils.truncate(fechaActual, Calendar.DATE);
			
			int numeroDias = diferenciasDeFechas(fechaActual, fechaRotulado);
			int diasTranscurridos = Math.abs(numeroDias);
			if (diasTranscurridos >= numeroDiasControlRotulado) {
				return 0;
			} else {
				diasRestantes = numeroDiasControlRotulado - diasTranscurridos;
			}
			
		}
		return diasRestantes;
	}
	
	@Override
	public Integer diasHabilesEdicionControlRotuladoArticulo(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO) throws SICException {
		Integer diasHabiles = -1;
		
		//SI ES NULL NO EXISTEN REGISTROS DE CONTROL DE ROTULADO
		if (articuloValorConfiguracionPlantillaDTO == null) {
			return 0;
		}
		
		//Busca el valor del parametro NUMERO_DIAS_CREAR_CONTROL_ROTULADO
		Integer codigoCompania = articuloValorConfiguracionPlantillaDTO.getId().getCodigoCompania();
		String codigoParametro = SICParametros.getInstancia().NUMERO_DIAS_EDITAR_CONTROL_ROTULADO;
		
		ParametroDTO parametro = parametroGestor.obtenerParametro(codigoCompania, codigoParametro);
		
		if (parametro == null) {
			throw new SICException("NO EXISTE EL PARAMETRO " + SICParametros.getInstancia().NUMERO_DIAS_EDITAR_CONTROL_ROTULADO);
		}
		
		if (parametro != null) {
			//FECHA DEL ULTIMO ROTULADO
			Timestamp timestamp = articuloValorConfiguracionPlantillaDTO.getFechaRegistro();
			Date fechaRotulado = new Date(timestamp.getTime());		
			fechaRotulado = DateUtils.truncate(fechaRotulado, Calendar.DATE);
			//NUMERO DE DIAS PARA EL CONTROL DE ROTULADO
			Integer numeroDiasEditarControlRotulado = Integer.valueOf(parametro.getValorParametro().trim());
			//FECHA ACTUAL
			Date fechaActual = new Date(System.currentTimeMillis());
			fechaActual = DateUtils.truncate(fechaActual, Calendar.DATE);
			
			int numeroDias = diferenciasDeFechas(fechaActual, fechaRotulado);
			int diasTranscurridos = Math.abs(numeroDias);			 
			if (diasTranscurridos <= numeroDiasEditarControlRotulado) {
				diasHabiles = numeroDiasEditarControlRotulado - diasTranscurridos;
			} else {
				diasHabiles = 0;
			}
		}
		return diasHabiles;
	}
	
	/**
	 * 
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.validarEdicionRotuladoArticulo(ArticuloDTO, ProveedorDTO, String)
	 */
	public Boolean validarEdicionRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO, String codigoUsuario) throws SICException {
		Boolean band = Boolean.FALSE;
		return band;
	}
	
	/**
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.obtenerConfiguracionPlantillas(Set<Integer>, Timestamp, ValorConfiguracionPlantillaDTO, String)
	 */
	public Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionPlantillas(Set<Integer> codigosConPla, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO, String estado) throws SICException {
		return plantillasGestor.obtenerConfiguracionPlantillas(codigosConPla, valorConfiguracionPlantillaDTO, estado);
	}
	
	/**
	 * 
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.obtenerUltimoControlRotuladoArticulo(ArticuloDTO,ProveedorDTO)
	 */
	public ArticuloValorConfiguracionPlantillaDTO obtenerUltimoControlRotuladoArticulo(ArticuloDTO articuloDTO, ProveedorDTO proveedorDTO) throws SICException {
		
		if (proveedorDTO==null || proveedorDTO.getId() == null || "".equals(proveedorDTO.getId().getCodigoProveedor())) {
			throw new SICException("Debe existir un proveedor para el control de rotulado");
		}
		
		ArticuloValorConfiguracionPlantillaDTO plantilla = new ArticuloValorConfiguracionPlantillaDTO();
		plantilla.setId(new ArticuloValorConfiguracionPlantillaID());
		plantilla.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
		plantilla.setCodigoProveedor(proveedorDTO.getId().getCodigoProveedor());
		
		plantilla.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
		plantilla.getCriteriaRestrictions().add(new ArticuloValorConfiguracionPlantillaRestriction(articuloDTO.getId().getCodigoArticulo(), proveedorDTO.getId().getCodigoProveedor()));
		
		Collection<ArticuloValorConfiguracionPlantillaDTO> coll = dataGestor.findObjects(plantilla);
		
		//Logeable.LOG_SICV2.info("coll: " + coll);
		//Logeable.LOG_SICV2.info("coll: " + coll.size());
		
		ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO = null;
		
		for (ArticuloValorConfiguracionPlantillaDTO a : coll) {			
			articuloValorConfiguracionPlantillaDTO = a;
		}
		
		return articuloValorConfiguracionPlantillaDTO;
	}
	
	/**
	 * 
	 * @see ec.com.smx.sic.articulo.gestor.rotulado.IArticuloRotuladoGestor.obtenerArticuloPorCodigoBarras(String)
	 */
	public ArticuloDTO obtenerArticuloPorCodigoBarras(String codigoBarras) throws SICException {
		ArticuloDTO plantilla = new ArticuloDTO();
		ArticuloBitacoraCodigoBarrasDTO artBitCodBar = new ArticuloBitacoraCodigoBarrasDTO();
		artBitCodBar.getId().setCodigoBarras(codigoBarras);
		artBitCodBar.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		Collection<ArticuloBitacoraCodigoBarrasDTO> artBitCodBarCol = new ArrayList<ArticuloBitacoraCodigoBarrasDTO>();
		artBitCodBarCol.add(artBitCodBar);
		plantilla.setArtBitCodBarCol(artBitCodBarCol);
		plantilla.setArticuloMedidaDTO(new ArticuloMedidaDTO());
		plantilla.setClasificacionDTO(new ClasificacionDTO());
		ArticuloDTO articuloDTO = dataGestor.findUnique(plantilla);
		return articuloDTO;
	}
	
	/**
	 * Actualiza los valores de auditoria del control de rotulado
	 * @param articuloValorConfiguracionPlantillaDTO
	 * @param codigoUsuario
	 * @param detalleGrupoCampoPlantillaDTOCol
	 * @param fecha
	 * @throws SICException
	 */
	public void actualizarControlRotuladoConValoresAuditoria(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, String codigoUsuario, Collection<DetalleGrupoCampoPlantillaDTO> detalleGrupoCampoPlantillaDTOCol, Timestamp fecha)  throws SICException {
		
		articuloValorConfiguracionPlantillaDTO.setFechaAuditoria(fecha);
		articuloValorConfiguracionPlantillaDTO.setIdUsuarioAuditoria(codigoUsuario);
		
		//ACTUALIZA LOS VALORES DE NOVEDAD DE AUDITORIA EN EL CONTROL DE ROTULADO
		dataGestor.update(articuloValorConfiguracionPlantillaDTO);
		
		if (detalleGrupoCampoPlantillaDTOCol != null) {
			for (DetalleGrupoCampoPlantillaDTO detalleGrupoCampoPlantillaDTO : detalleGrupoCampoPlantillaDTOCol) {
				if (detalleGrupoCampoPlantillaDTO.getId() != null && detalleGrupoCampoPlantillaDTO.getId().getCodigoDetalleGrupoCampoPlantilla() != null) {
					ValorGrupoCampoPlantillaDTO plantillaDTO = new ValorGrupoCampoPlantillaDTO();
					plantillaDTO.setCodigoDetalleGrupoCampoPlantilla(detalleGrupoCampoPlantillaDTO.getId().getCodigoDetalleGrupoCampoPlantilla());
					plantillaDTO.setCodigoValorConfiguracionPlantilla(articuloValorConfiguracionPlantillaDTO.getId().getCodigoValorConfiguracionPlantilla());
					ValorGrupoCampoPlantillaDTO valorGrupoCampoPlantillaDTO = dataGestor.findUnique(plantillaDTO);
					if (valorGrupoCampoPlantillaDTO != null) {
						valorGrupoCampoPlantillaDTO.setValor(PlantillasConstantes.ESTADO_ACTIVO_BOOLEANO);
						dataGestor.update(valorGrupoCampoPlantillaDTO);
					}
				} else {
					//Busca el campo de auditoria en el componente de rotulado
					GrupoCampoPlantillaDTO grupoCampoPlantillaDTO = new GrupoCampoPlantillaDTO();
					grupoCampoPlantillaDTO.setCodigoConfiguracionPlantilla(articuloValorConfiguracionPlantillaDTO.getValorConfiguracionPlantilla().getCodigoConfiguracionPlantilla());
					grupoCampoPlantillaDTO.setId(new GrupoCampoPlantillaID());
					grupoCampoPlantillaDTO.getId().setCodigoGrupoCampoPlantilla(detalleGrupoCampoPlantillaDTO.getCodigoGrupoCampoPlantilla());
					DetalleConfiguracionPlantillaDTO detalleConfiguracionPlantillaDTO = new DetalleConfiguracionPlantillaDTO();
					detalleConfiguracionPlantillaDTO.setCodigoConfiguracionPlantilla(articuloValorConfiguracionPlantillaDTO.getValorConfiguracionPlantilla().getCodigoConfiguracionPlantilla());
					detalleConfiguracionPlantillaDTO.setCodigoCampoPlantilla(ISicronizacionComponentesRotuladoGestor.CODIGO_CAMPO_PLANTILLA_AUDITORIA_CHECKBOX);
					
					//Logeable.LOG_SICV2.info("conpla: " + articuloValorConfiguracionPlantillaDTO.getValorConfiguracionPlantilla().getCodigoConfiguracionPlantilla());
					//Logeable.LOG_SICV2.info("grucampla: " + detalleGrupoCampoPlantillaDTO.getCodigoGrupoCampoPlantilla());
					//Logeable.LOG_SICV2.info("campla: " + ISicronizacionComponentesRotuladoGestor.CODIGO_CAMPO_PLANTILLA_AUDITORIA_CHECKBOX);
					
					DetalleGrupoCampoPlantillaDTO plantillaDTO = new DetalleGrupoCampoPlantillaDTO();
					plantillaDTO.setCodigoGrupoCampoPlantilla(detalleGrupoCampoPlantillaDTO.getCodigoGrupoCampoPlantilla());
					plantillaDTO.setGrupoCampoPlantillaDTO(grupoCampoPlantillaDTO);
					plantillaDTO.setDetalleConfiguracionPlantillaDTO(detalleConfiguracionPlantillaDTO);
					
					Collection<DetalleGrupoCampoPlantillaDTO> detalleGrupoCampoPlantillaDTOs = dataGestor.findObjects(plantillaDTO);
					if (CollectionUtils.isEmpty(detalleGrupoCampoPlantillaDTOs)) {
						throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.rotulado.campo.auditoria.noexiste.plantilla"));
					}
					try {
						DetalleGrupoCampoPlantillaDTO detalleGrupoCampoPlantillaDTONuevo = detalleGrupoCampoPlantillaDTOs.iterator().next();
						ValorGrupoCampoPlantillaDTO valorGrupoCampoPlantillaDTONuevo = new ValorGrupoCampoPlantillaDTO();
						valorGrupoCampoPlantillaDTONuevo.setCodigoDetalleGrupoCampoPlantilla(detalleGrupoCampoPlantillaDTONuevo.getId().getCodigoDetalleGrupoCampoPlantilla());
						valorGrupoCampoPlantillaDTONuevo.setCodigoValorConfiguracionPlantilla(articuloValorConfiguracionPlantillaDTO.getId().getCodigoValorConfiguracionPlantilla());
						valorGrupoCampoPlantillaDTONuevo.setValor(PlantillasConstantes.ESTADO_ACTIVO_BOOLEANO);
						valorGrupoCampoPlantillaDTONuevo.setEstado(PlantillasConstantes.ESTADO_ACTIVO_BOOLEANO);
						valorGrupoCampoPlantillaDTONuevo.setFechaRegistro(fecha);
						valorGrupoCampoPlantillaDTONuevo.setIdUsuarioRegistro(codigoUsuario);
						valorGrupoCampoPlantillaDTONuevo.setId(new ValorGrupoCampoPlantillaID());
						valorGrupoCampoPlantillaDTONuevo.getId().setCodigoCompania(detalleGrupoCampoPlantillaDTONuevo.getId().getCodigoCompania());
						dataGestor.create(valorGrupoCampoPlantillaDTONuevo);
					} catch (Exception e) {
						throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.rotulado.registrar.valor.campo.auditoria"), e);
					}
				}
			}
		}
	}
	
	public ArticuloValorConfiguracionPlantillaDTO crearControlRotuladoAuditoria(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Collection<GrupoCampoPlantillaDTO> grupoCampoPlantillaAuditoriaCol, String codigoUsuario)  throws SICException {
		
		ArticuloDTO articuloDTO = new ArticuloDTO();
		articuloDTO.setId(new ArticuloID());
		articuloDTO.getId().setCodigoArticulo(articuloValorConfiguracionPlantillaDTO.getId().getCodigoArticulo());
		articuloDTO.getId().setCodigoCompania(articuloValorConfiguracionPlantillaDTO.getId().getCodigoCompania());
		
		ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO = articuloValorConfiguracionPlantillaDTO.getValorConfiguracionPlantilla();
		Integer codigoPadreAVCP = valorConfiguracionPlantillaDTO.getId().getCodigoValorConfiguracionPlantilla();
		
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		proveedorDTO.setId(new ProveedorID());
		proveedorDTO.getId().setCodigoProveedor(articuloValorConfiguracionPlantillaDTO.getCodigoProveedor());
		
		ConfiguracionPlantillaDTO configuracionPlantillaDTOAuditoria = new ConfiguracionPlantillaDTO();
		configuracionPlantillaDTOAuditoria.setId(new ConfiguracionPlantillaID());
		configuracionPlantillaDTOAuditoria.getId().setCodigoCompania(articuloValorConfiguracionPlantillaDTO.getId().getCodigoCompania());
		configuracionPlantillaDTOAuditoria.getId().setCodigoConfiguracionPlantilla(valorConfiguracionPlantillaDTO.getCodigoConfiguracionPlantilla());
		configuracionPlantillaDTOAuditoria.setGrupoCampoPlantillaDTOCol(grupoCampoPlantillaAuditoriaCol);
		
		ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaAuditoria = this.grabarValoresPlantilla(articuloDTO, configuracionPlantillaDTOAuditoria, codigoUsuario, proveedorDTO, codigoPadreAVCP);
		return articuloValorConfiguracionPlantillaAuditoria;
	}
	
	@Override
	public ArticuloValorConfiguracionPlantillaDTO actualizarNovedadArticuloValorConfiguracionPlantilla(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, String codigoUsuario, Collection<DetalleGrupoCampoPlantillaDTO> detalleGrupoCampoPlantillaDTOCol, Collection<GrupoCampoPlantillaDTO> grupoCampoPlantillaAuditoriaCol) throws SICException {
		Timestamp fecha = new Timestamp(System.currentTimeMillis());
		
		//ACTUALIZA LOS VALORES DE NOVEDAD DE AUDITORIA EN EL CONTROL DE ROTULADO
		this.actualizarControlRotuladoConValoresAuditoria(articuloValorConfiguracionPlantillaDTO, codigoUsuario, detalleGrupoCampoPlantillaDTOCol, fecha);
		
		//CREA EL NUEVO CONTROL DE ROTULADO DE AUDITORIA
		ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaAuditoria = null;
		if (PlantillasConstantes.ESTADO_ACTIVO_BOOLEANO.equals(articuloValorConfiguracionPlantillaDTO.getNovedadAuditoria())) {
			if (CollectionUtils.isEmpty(grupoCampoPlantillaAuditoriaCol)) {
				throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.rotulado.valores.control.rotulado.auditoria.vacio"));
			}
			articuloValorConfiguracionPlantillaAuditoria = this.crearControlRotuladoAuditoria(articuloValorConfiguracionPlantillaDTO, grupoCampoPlantillaAuditoriaCol, codigoUsuario);
		}
		
		return articuloValorConfiguracionPlantillaAuditoria;
	}
	
	private int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        	Logeable.LOG_SICV2.error(ex.getMessage());
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        	Logeable.LOG_SICV2.error(ex.getMessage());
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }
	

	/**
	 * @return the dataGestor
	 */
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	/**
	 * @param dataGestor
	 *            the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @return the plantillasGestor
	 */
	public IPlantillasGestor getPlantillasGestor() {
		return plantillasGestor;
	}

	/**
	 * @param plantillasGestor
	 *            the plantillasGestor to set
	 */
	public void setPlantillasGestor(IPlantillasGestor plantillasGestor) {
		this.plantillasGestor = plantillasGestor;
	}

	/**
	 * 
	 * @return
	 */
	public IParametroGestor getParametroGestor() {
		return parametroGestor;
	}

	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}

}
