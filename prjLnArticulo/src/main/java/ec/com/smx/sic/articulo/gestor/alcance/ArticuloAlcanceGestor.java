package ec.com.smx.sic.articulo.gestor.alcance;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.exception.DAOException;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearch;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EstablecimientoCiudadDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.vo.GrupoTrabajoVO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.generadorexportacion.spring.batch.core.ExtendedJobParameter;
import ec.com.smx.sic.articulo.gestor.batch.IAlcanceBatchUtilGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.articulo.EnumPrototipoAlcance;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.administracion.enviomail.IEnvioMailGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.IArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IAlmacenamientoArticuloAlcanceNoSqlGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.validacion.IValidacionAlcanceGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaGrupoAlcanceLocalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.AlcanceArticuloTransient;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceIntegracionTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloLocalPrecioVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.PrototipoAlcanceVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAlcanceDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroAsignacionLocalDAO;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.integracion.dto.articulo.ActivarDesactivarAlcanceArticuloDetalleIDTO;
import ec.com.smx.sic.integracion.dto.articulo.ActivarDesactivarAlcanceArticuloIDTO;
import ec.com.smx.sic.integracion.resources.SICIntegracionMessages;
import ec.com.smx.sic.integracion.util.SICIntegracion;

/**
 * Permite relizar las operaciones de
 * 
 * @author dalmeida
 * @author fcollaguazo
 * @author jvasquez
 */
public class ArticuloAlcanceGestor implements IArticuloAlcanceGestor {
	private DataGestor dataGestor;
	private IArticuloAlcanceDAO articuloAlcanceDAO;
	private IValidacionAlcanceGestor validacionAlcanceGestor;
	private IArticuloDAO articuloDAO;

	private ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor;

	private Job asignacionMasivaArticulosJob;
	private Job articulosArchivoAlcanceJob;
//	private Job asignacionMasivaArticulosActualizarPrototipoJob;
	private Job comunicarArticuloAlcanceJob;
	private Job actualizarPrototipoComunicarSICJob;
	private Job reporteAlcancesJob;
	private Job generarArchivoErrorTxtJob;
	private IAlcanceBatchUtilGestor alcanceBatchUtilGestor;

	private Collection<ArticuloDTO> artResulArchiv;

	private Job articuloPaginadoJob;

	private IEnvioMailGestor mensajeria;

	private JobLauncher jobLauncher;

	// Almacena la lista de alcances para el reporte de excel
	private Collection<ArticuloAlcanceEST> articuloAlcanceCol;

	private IArticuloRegistroAsignacionLocalDAO articuloRegistroAsignacionLocalDAO;
	
	// Gestor para asignacion de alcances noSql
	private IAlmacenamientoArticuloAlcanceNoSqlGestor almacenamientoArticuloAlcanceNoSqlGestor;

	// ---------------------------------------------------------------------------------------------------------------------------
	// INICIO DE METODOS ADMINISTRACION DE ALCANCES
	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo que permite crear un grupo de alcance. Asigna el codigo de area de
	 * trabajo del local y el codigo de grupo de trabajo para crear un grupo
	 * area de trabajo.
	 * 
	 * @param areaTrabajoCol
	 * @param grupoTrabajoDTO
	 * @throws SICException
	 */
	public void crearGrupoAlcance(GrupoTrabajoDTO grupoTrabajoDTO, Collection<AreaTrabajoDTO> areaTrabajoCol) throws SICException {
		Logeable.LOG_SICV2.info("Entro a ArticuloAlcanceGestor.crearGrupoAlcance()");

		validacionAlcanceGestor.crearGrupoAlcance(grupoTrabajoDTO, areaTrabajoCol);

		try {
			grupoTrabajoDTO.setEstadoGrupoTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
			grupoTrabajoDTO.setTipoGrupoTrabajo(CorporativoConstantes.TIPO_GRUPOTRABAJO_ALCANCE);
			grupoTrabajoDTO.setTipoGrupoTrabajoTIC(TiposCatalogoConstantes.TIPO_GRUPO_TRABAJO);
			dataGestor.create(grupoTrabajoDTO);
			GrupoAreaTrabajoDTO grupoAreaTrabajoDTO;
			for (AreaTrabajoDTO areaTrabajoDTO : areaTrabajoCol) {
				grupoAreaTrabajoDTO = new GrupoAreaTrabajoDTO();
				grupoAreaTrabajoDTO.getId().setCodigoAreaTrabajo(areaTrabajoDTO.getId().getCodigoAreaTrabajo());
				grupoAreaTrabajoDTO.getId().setCodigoGrupoTrabajo(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo());
				grupoAreaTrabajoDTO.getId().setCodigoCompania(areaTrabajoDTO.getId().getCodigoCompania());
				grupoAreaTrabajoDTO.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
				grupoAreaTrabajoDTO.setUserId(grupoTrabajoDTO.getUserId());
				dataGestor.create(grupoAreaTrabajoDTO);
			}

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al crearGrupoAlcance {}", e);
			throw new SICException("Error al crearGrupoAlcance ", e);
		}
	}

	/**
	 * Permite asignar o quitar areas de trabajo a varios prototipos, generar el
	 * archivo de articulo local afectados
	 * 
	 * @param prototipoAlcanceVO
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void asignacionLocalesPrototipos(PrototipoAlcanceVO prototipoAlcanceVO, UserDto userDto) throws SICException {
		Logeable.LOG_SICV2.info("Ejecutando:  ArticuloAlcanceGestor.asignacionLocalesPrototipos");
		try {

			asignacionLocalesPrototipos(prototipoAlcanceVO);
			// Contruimos la plantilla de articuloVO que contiene los parametros
			// necesarios para la integracion
			ArticuloVO articuloVO = new ArticuloVO();
			articuloVO.setUsuarioAlcance(prototipoAlcanceVO.getUsuarioId());
			articuloVO.setFechaAplicacion(prototipoAlcanceVO.getFechaAplicacion());

			// se llama al metodo para actualizar la bitacora de articuloLocal
			articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(prototipoAlcanceVO.getFechaAplicacion(), null, prototipoAlcanceVO.getCodigoCompania(), null);
			if (CollectionUtils.isNotEmpty(prototipoAlcanceVO.getAreaTrabajoDTOs())) {
				Collection<String> codigoLocalesCol = (CollectionUtils.collect(prototipoAlcanceVO.getAreaTrabajoDTOs(), new GetInvokerTransformer("id.codigoAreaTrabajo")));
				String locales = StringUtils.join(codigoLocalesCol, ",");
				// se actualiza las subbodegas
				articuloAlcanceDAO.actualizacionSubbodegas(prototipoAlcanceVO.getUsuarioId(), locales, SICConstantes.ESTADO_ACTIVO_NUMERICO, prototipoAlcanceVO.getFechaAplicacion(), null, null, prototipoAlcanceVO.getCodigoCompania());
				articuloAlcanceDAO.actualizacionSubbodegas(prototipoAlcanceVO.getUsuarioId(), locales, SICConstantes.ESTADO_INACTIVO_NUMERICO, prototipoAlcanceVO.getFechaAplicacion(), null, null, prototipoAlcanceVO.getCodigoCompania());
			}

			prototipoAlcanceVO.setUserDto(userDto);
			if (CollectionUtils.isNotEmpty(articuloVO.getArticuloAlcanceIntegracionTransientsCol())) {
				prototipoAlcanceVO.setArticuloAlcanceIntegracionTransientCol(articuloVO.getArticuloAlcanceIntegracionTransientsCol());
			}
			// llamamos al servicio de envio de mail
			mensajeria.mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ASIGNACION_LOCALES_PROTOTIPOS, prototipoAlcanceVO);

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al asignacionLocalesPrototipos {}", e);
			prototipoAlcanceVO.setMensajeError(Boolean.TRUE);
			mensajeria.mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ASIGNACION_LOCALES_PROTOTIPOS, prototipoAlcanceVO);
			throw new SICException("Error al asignacionLocalesPrototipos {}", e);
		}
	}

	/**
	 * Permite activar,inactivar areas de trabajo del prototipo e insertar
	 * masivamente los articulos en articulo local
	 * 
	 * @param prototipoAlcanceVO
	 */
	public void asignacionLocalesPrototipos(PrototipoAlcanceVO prototipoAlcanceVO) throws SICException {
		try {
			for (GrupoTrabajoDTO grupoTrabajoDTO : prototipoAlcanceVO.getGrupoTrabajoDTOs()) {
				grupoTrabajoDTO.setUserId(prototipoAlcanceVO.getUsuarioId());
				for (AreaTrabajoDTO areaTrabajoDTO : prototipoAlcanceVO.getAreaTrabajoDTOs()) {
					GrupoAreaTrabajoDTO grupoAreaTrabajoDTOTemp = new GrupoAreaTrabajoDTO();
					grupoAreaTrabajoDTOTemp.getId().setCodigoAreaTrabajo(areaTrabajoDTO.getId().getCodigoAreaTrabajo());
					grupoAreaTrabajoDTOTemp.getId().setCodigoGrupoTrabajo(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo());
					grupoAreaTrabajoDTOTemp.getId().setCodigoCompania(Integer.valueOf(prototipoAlcanceVO.getCodigoCompania()));
					GrupoAreaTrabajoDTO grupoAreaTrabajoDTO = dataGestor.findUnique(grupoAreaTrabajoDTOTemp);

					// Si existe el registro
					if (grupoAreaTrabajoDTO != null) {
						if (prototipoAlcanceVO.getAsignacion()) {
							if (grupoAreaTrabajoDTO.getEstadoGrupoAreaTrabajo().equals(CorporativoConstantes.ESTADO_INACTIVO)) {
								grupoAreaTrabajoDTO.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
								grupoAreaTrabajoDTO.setUserId(prototipoAlcanceVO.getUsuarioId());
								dataGestor.update(grupoAreaTrabajoDTO);
								Logeable.LOG_SICV2.info("dataGestor.update(grupoAreaTrabajoDTO) ESTADO_ACTIVO");

								GrupoAreaTrabajoDTO grupoAreaTrabajo = new GrupoAreaTrabajoDTO();
								grupoAreaTrabajo.setAreaTrabajoDTO(areaTrabajoDTO);
								grupoAreaTrabajo.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
								grupoAreaTrabajo.getId().setCodigoAreaTrabajo(areaTrabajoDTO.getId().getCodigoAreaTrabajo());
								grupoAreaTrabajo.getId().setCodigoGrupoTrabajo(grupoAreaTrabajoDTO.getId().getCodigoGrupoTrabajo());

								// Activar los registros inactivos
								articuloAlcanceDAO.activarInactivarArticulosEnLocalMasivo(prototipoAlcanceVO.getAccessItemId(), prototipoAlcanceVO.getSystemId(), grupoTrabajoDTO, grupoAreaTrabajo, prototipoAlcanceVO.getFechaAplicacion(), prototipoAlcanceVO.getCodigoFuncionario(), prototipoAlcanceVO.getCodigoCompania());
								// Insertar los registros que se anadieron al
								// prototipo mientras estaba inactivo
								articuloAlcanceDAO.insertarArticulosEnLocal(prototipoAlcanceVO.getAccessItemId(), prototipoAlcanceVO.getSystemId(), grupoTrabajoDTO, grupoAreaTrabajo, prototipoAlcanceVO.getFechaAplicacion(), prototipoAlcanceVO.getCodigoFuncionario(), prototipoAlcanceVO.getCodigoCompania());
							} else {
								// Si el estadoGrupoAreaTrabajo esta activo
								GrupoAreaTrabajoDTO grupoAreaTrabajo = new GrupoAreaTrabajoDTO();
								grupoAreaTrabajo.setAreaTrabajoDTO(areaTrabajoDTO);
								grupoAreaTrabajo.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
								grupoAreaTrabajo.getId().setCodigoAreaTrabajo(areaTrabajoDTO.getId().getCodigoAreaTrabajo());
								grupoAreaTrabajo.getId().setCodigoGrupoTrabajo(grupoAreaTrabajoDTO.getId().getCodigoGrupoTrabajo());
								// Activar los registros inactivos
								articuloAlcanceDAO.activarInactivarArticulosEnLocalMasivo(prototipoAlcanceVO.getAccessItemId(), prototipoAlcanceVO.getSystemId(), grupoTrabajoDTO, grupoAreaTrabajo, prototipoAlcanceVO.getFechaAplicacion(), prototipoAlcanceVO.getCodigoFuncionario(), prototipoAlcanceVO.getCodigoCompania());
								// Insertar los registros que se anadieron al
								// prototipo mientras estaba inactivo
								articuloAlcanceDAO.insertarArticulosEnLocal(prototipoAlcanceVO.getAccessItemId(), prototipoAlcanceVO.getSystemId(), grupoTrabajoDTO, grupoAreaTrabajo, prototipoAlcanceVO.getFechaAplicacion(), prototipoAlcanceVO.getCodigoFuncionario(), prototipoAlcanceVO.getCodigoCompania());
							}
						} else {
							// Si es quitar al area de trabajo del grupo
							if (!prototipoAlcanceVO.getAsignacion()) {
								grupoAreaTrabajoDTO.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_INACTIVO);
								grupoAreaTrabajoDTO.setUserId(prototipoAlcanceVO.getUsuarioId());
								dataGestor.update(grupoAreaTrabajoDTO);
								Logeable.LOG_SICV2.info("dataGestor.update(grupoAreaTrabajoDTO) ESTADO_INACTIVO");

								GrupoAreaTrabajoDTO grupoAreaTrabajo = new GrupoAreaTrabajoDTO();
								grupoAreaTrabajo.setAreaTrabajoDTO(areaTrabajoDTO);
								grupoAreaTrabajo.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_INACTIVO);
								grupoAreaTrabajo.getId().setCodigoAreaTrabajo(areaTrabajoDTO.getId().getCodigoAreaTrabajo());
								grupoAreaTrabajo.getId().setCodigoGrupoTrabajo(grupoAreaTrabajoDTO.getId().getCodigoGrupoTrabajo());

								articuloAlcanceDAO.activarInactivarArticulosEnLocalMasivo(prototipoAlcanceVO.getAccessItemId(), prototipoAlcanceVO.getSystemId(), grupoTrabajoDTO, grupoAreaTrabajo, prototipoAlcanceVO.getFechaAplicacion(), prototipoAlcanceVO.getCodigoFuncionario(), prototipoAlcanceVO.getCodigoCompania());
							}
						}
					}
					// Si es asignar
					else if (prototipoAlcanceVO.getAsignacion()) {
						GrupoAreaTrabajoDTO grupoAreaTrabajoDTONuevo = new GrupoAreaTrabajoDTO();
						grupoAreaTrabajoDTONuevo.getId().setCodigoAreaTrabajo(areaTrabajoDTO.getId().getCodigoAreaTrabajo());
						grupoAreaTrabajoDTONuevo.getId().setCodigoGrupoTrabajo(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo());
						grupoAreaTrabajoDTONuevo.getId().setCodigoCompania(Integer.valueOf(prototipoAlcanceVO.getCodigoCompania()));
						grupoAreaTrabajoDTONuevo.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
						grupoAreaTrabajoDTONuevo.setUserId(prototipoAlcanceVO.getUsuarioId());
						dataGestor.create(grupoAreaTrabajoDTONuevo);

						GrupoAreaTrabajoDTO grupoAreaTrabajo = new GrupoAreaTrabajoDTO();
						grupoAreaTrabajo.setAreaTrabajoDTO(areaTrabajoDTO);
						grupoAreaTrabajo.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
						grupoAreaTrabajo.getId().setCodigoAreaTrabajo(areaTrabajoDTO.getId().getCodigoAreaTrabajo());

						articuloAlcanceDAO.insertarArticulosEnLocal(prototipoAlcanceVO.getAccessItemId(), prototipoAlcanceVO.getSystemId(), grupoTrabajoDTO, grupoAreaTrabajo, prototipoAlcanceVO.getFechaAplicacion(), prototipoAlcanceVO.getCodigoFuncionario(), prototipoAlcanceVO.getCodigoCompania());
					}
				}
			}
		} catch (SICException e) {
			Logeable.LOG_SICV2.error("Error en asignacionLocalesPrototipos {}", e);
			throw new SICException("Error en asignacionLocalesPrototipos {}", e);
		}
	}

	/**
	 * Permite activar, inactivar, insertar areas de trabajo del prototipo e
	 * insertar masivamente los articulos en articulo local Obtener el archivo
	 * de articulo local afectados
	 * 
	 * @param grupoTrabajoDTO
	 * @param fechaAplicacion
	 * @param areasAsignar
	 * @param areasDesactivar
	 * @param areasActivar
	 * @throws SICException
	 */
	@Override
	public void actualizarGrupoAlcance(String accessItemId, String systemId, GrupoTrabajoDTO grupoTrabajoDTO, Timestamp fechaAplicacion, ArrayList<GrupoAreaTrabajoDTO> areasAsignar, ArrayList<GrupoAreaTrabajoDTO> areasDesactivar, ArrayList<GrupoAreaTrabajoDTO> areasActivar, UserDto userDto, String codigoFuncionario) throws SICException {

		PrototipoAlcanceVO prototipoAlcanceVO = new PrototipoAlcanceVO();
		prototipoAlcanceVO.setUserDto(userDto);
		prototipoAlcanceVO.setFechaAplicacion(fechaAplicacion);
		prototipoAlcanceVO.setAreasActivar(areasActivar);
		prototipoAlcanceVO.setAreasAsignar(areasAsignar);
		prototipoAlcanceVO.setAreasDesactivar(areasDesactivar);
		prototipoAlcanceVO.setGrupoTrabajoDTOs(new ArrayList<GrupoTrabajoDTO>());
		prototipoAlcanceVO.getGrupoTrabajoDTOs().add(grupoTrabajoDTO);
		prototipoAlcanceVO.setCodigoCompania(grupoTrabajoDTO.getId().getCodigoCompania());

		try {
			// LLamamos al metodo de actualizar grupo alcance
			actualizarGrupoAlcance(accessItemId, systemId, grupoTrabajoDTO, fechaAplicacion, areasAsignar, areasDesactivar, areasActivar, codigoFuncionario);

			// Contruimos la plantilla de articuloVO que contiene los parametros
			// necesarios para la integracion
			ArticuloVO articuloVO = new ArticuloVO();
			articuloVO.setUsuarioAlcance(grupoTrabajoDTO.getUserId());
			articuloVO.setFechaAplicacion(fechaAplicacion);
			articuloVO.setCodigoCompania(grupoTrabajoDTO.getId().getCodigoCompania());

			if (CollectionUtils.isNotEmpty(articuloVO.getArticuloAlcanceIntegracionTransientsCol())) {
				prototipoAlcanceVO.setArticuloAlcanceIntegracionTransientCol(articuloVO.getArticuloAlcanceIntegracionTransientsCol());
			}

			// llamamos al servicio de envio de mail
			mensajeria.mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ACTUALIZAR_GRUPO_ALCANCE, prototipoAlcanceVO);

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al actualizarGrupoAlcance {}", e);
			prototipoAlcanceVO.setMensajeError(Boolean.TRUE);
			mensajeria.mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ACTUALIZAR_GRUPO_ALCANCE, prototipoAlcanceVO);
			throw new SICException("Error al actualizarGrupoAlcance {}", e);
		}
	}

	/**
	 * Permite activar, inactivar, insertar areas de trabajo del prototipo e
	 * insertar masivamente los articulos en articulo local
	 * 
	 * @param grupoTrabajoDTO
	 * @param fechaAplicacion
	 * @param areasAsignar
	 * @param areasDesactivar
	 * @param areasActivar
	 * @throws SICException
	 */

	@SuppressWarnings("unchecked")
	public void actualizarGrupoAlcance(String accessItemId, String systemId, GrupoTrabajoDTO grupoTrabajoDTO, Timestamp fechaAplicacion, Collection<GrupoAreaTrabajoDTO> areasAsignar, Collection<GrupoAreaTrabajoDTO> areasDesactivar, Collection<GrupoAreaTrabajoDTO> areasActivar, String codigoFuncionario) throws SICException {
		try {
			Logeable.LOG_SICV2.info("Entro a ArticuloAlcanceGestor.actualizarGrupoAlcance()");
			validacionAlcanceGestor.actualizarGrupoAlcance(grupoTrabajoDTO, fechaAplicacion, areasAsignar, areasDesactivar, areasActivar);
			dataGestor.update(grupoTrabajoDTO);

			if (StringUtils.isNotBlank(grupoTrabajoDTO.getEstadoGrupoTrabajo()) && grupoTrabajoDTO.getEstadoGrupoTrabajo().equals(SICConstantes.ESTADO_INACTIVO_LITERAL) && StringUtils.isNotBlank(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo().toString()) && StringUtils.isNotBlank(grupoTrabajoDTO.getUserId())
					&& StringUtils.isNotBlank(grupoTrabajoDTO.getId().getCodigoCompania().toString())) {
				// Permite actualizar la relacion existente con los locales del
				// prototipo que se esta inactivando
				articuloAlcanceDAO.actualizarRelacionGrupoTrabajoAreaTrabajo(grupoTrabajoDTO.getEstadoGrupoTrabajo(), grupoTrabajoDTO.getId().getCodigoGrupoTrabajo(), grupoTrabajoDTO.getUserId(), grupoTrabajoDTO.getId().getCodigoCompania());
			}

			if (CollectionUtils.isNotEmpty(areasActivar) || CollectionUtils.isNotEmpty(areasAsignar) || CollectionUtils.isNotEmpty(areasDesactivar)) {
				// Actualizamos masivamente los registros
				articuloAlcanceDAO.actualizarGrupoAlcance(accessItemId, systemId, grupoTrabajoDTO, areasAsignar, areasDesactivar, areasActivar, fechaAplicacion, codigoFuncionario);

				articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(fechaAplicacion, null, grupoTrabajoDTO.getId().getCodigoCompania(), null);

				Collection<String> codigoLocalesCol = new ArrayList<String>();

				if (CollectionUtils.isNotEmpty(areasActivar)) {
					codigoLocalesCol.addAll(CollectionUtils.collect(areasActivar, new GetInvokerTransformer("id.codigoAreaTrabajo")));
				}
				if (CollectionUtils.isNotEmpty(areasAsignar)) {
					codigoLocalesCol.addAll(CollectionUtils.collect(areasAsignar, new GetInvokerTransformer("id.codigoAreaTrabajo")));
				}
				if (CollectionUtils.isNotEmpty(areasDesactivar)) {
					codigoLocalesCol.addAll(CollectionUtils.collect(areasDesactivar, new GetInvokerTransformer("id.codigoAreaTrabajo")));
				}

				if (CollectionUtils.isNotEmpty(codigoLocalesCol)) {
					String locales = StringUtils.join(codigoLocalesCol, ",");
					articuloAlcanceDAO.actualizacionSubbodegas(grupoTrabajoDTO.getUserId(), locales, SICConstantes.ESTADO_ACTIVO_NUMERICO, fechaAplicacion, null, null, grupoTrabajoDTO.getId().getCodigoCompania());
					articuloAlcanceDAO.actualizacionSubbodegas(grupoTrabajoDTO.getUserId(), locales, SICConstantes.ESTADO_INACTIVO_NUMERICO, fechaAplicacion, null, null, grupoTrabajoDTO.getId().getCodigoCompania());
				}

			}

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al actualizarGrupoAlcance {}", e);
			throw new SICException("Error al actualizarGrupoAlcance {}", e);
		}
	}

	/**
	 * permite establecer un plantilla ArticuloLocalDTO para realizar la
	 * comunicacion al SIC en un step en el Job articulosAlcanceJob
	 * 
	 * @return
	 */
	private ArticuloLocalDTO paramsStepComunicarSic(ArticuloVO articuloVO) {

		ArticuloDTO articuloDTO = new ArticuloDTO();
		
		articuloDTO.setGrupoAlcanceDTO(new GrupoTrabajoDTO());
		articuloDTO.setCodigoEstado(SICConstantes.ESTADO_ARTICULO_CODIFICADO);
		articuloDTO.setEstadoArticulo(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
		articuloDTO.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoBarras",ComparatorTypeEnum.IS_NOT_NULL));

		ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
		articuloLocalDTO.setArticulo(articuloDTO);
		articuloLocalDTO.getId().setCodigoCompania(articuloVO.getCodigoCompania());
		articuloLocalDTO.setLocal(new AreaTrabajoDTO());
		articuloLocalDTO.getLocal().setTipoAreaTrabajoRestriction(null);

		String columnConsulta = "id.codigoLocal";

		if (StringUtils.isNotEmpty(articuloVO.getOpcionTipoAsignacionAlcance())) {
			if ((articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) || articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega")))) {

				articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
				columnConsulta = "local.areaSublugarTrabajoCol.id.codigoAreaTrabajo";

			} else if ((articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina")) || articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina")))) {

				columnConsulta = "local.codigoReferencia";
				articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA);
			}
		}

		if (articuloVO.getFechaAplicacion() != null) {
			articuloLocalDTO.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
			articuloLocalDTO.getCriteriaRestrictions().add(new Restriccion(articuloVO.getFechaAplicacion()));
		}

		articuloLocalDTO.setOrderByField(OrderBy.orderAsc("id.codigoLocal"));

		// Se llena las proyecciones
		if (articuloLocalDTO.getCriteriaSearch() == null) {
			articuloLocalDTO.setCriteriaSearch(new CriteriaSearch());
		}

		articuloLocalDTO.getCriteriaSearch().addDistinctSearchParameter(
				articuloLocalDTO.getClass(),
				new String[] { "id.codigoCompania", "id.codigoArticulo", columnConsulta, "estadoArticuloLocal", "articulo.grupoAlcanceDTO.codigoReferencia", "articulo.codigoBarras", "codigoOpcion", "codigoSistema", "idUsuarioRegistro", "fechaRegistro", "idUsuarioActivacion", "fechaActivacion", "idUsuarioInactivacion", "fechaInactivacion", "local.nombreAreaTrabajo",
						"articulo.descripcionArticulo", "id.codigoLocal", "notificarLocal", "aperturaLocal" },
				new String[] { "id.codigoCompania", "id.codigoArticulo", "id.codigoLocal", "estadoArticuloLocal", "articulo.grupoAlcanceDTO.codigoReferencia", "articulo.codigoBarras", "codigoOpcion", "codigoSistema", "idUsuarioRegistro", "fechaRegistro", "idUsuarioActivacion", "fechaActivacion", "idUsuarioInactivacion", "fechaInactivacion", "local.nombreAreaTrabajo",
						"articulo.descripcionArticulo", "codigoBodega", "notificarLocal", "aperturaLocal" });

		return articuloLocalDTO;
	}
	
	
	
	/**
	 * Permite copiar los articulos de un local base a otro local, Si el local
	 * no posee articulo-local insertar todos Si el local ya posee articulos ->
	 * inactivar los articulos que actualmente posee e insertar los articulos
	 * del local base Obtener el archivo de articulo local afectados
	 * 
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	@SuppressWarnings("deprecation")
	public void copiarLocal(ArticuloVO articuloVO, UserDto userDto) throws SICException {
		try {
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando copiarLocal(ArticuloVO articuloVO,UserDto userDto)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");

			if (articuloVO.getEnumPrototipoAlcance().equals(EnumPrototipoAlcance.COPIAR_LOCAL_FILTROS)) {
				Logeable.LOG_SICV2.info("Metodo copiarLocalFiltrosNoTransaccional");
				JobExecution jobExecution;

				Map<String, JobParameter> params = new HashMap<String, JobParameter>();
				params.put("fechaEjecucion", new JobParameter(new Date()));
				params.put("plantillaAsignacionMasiva", new ExtendedJobParameter(articuloVO.getBaseDTO()));
				params.put("plantillaParams", new ExtendedJobParameter(articuloVO));
				ArticuloLocalDTO articuloLocalDTO = paramsStepComunicarSic(articuloVO);
				params.put("plantillaComunicarSic", new ExtendedJobParameter(articuloLocalDTO));

				jobExecution = jobLauncher.run(asignacionMasivaArticulosJob, new JobParameters(params));

				Logeable.LOG_SICV2.info("El trabajo ha finalizado con estado:{} ", jobExecution.getExitStatus());

				if (jobExecution.getExitStatus().equals(ExitStatus.FAILED)) {
					throw new SICException("El trabajo  copiarLocal ha finalizado con estado: " + ExitStatus.FAILED);
				}

			} else {
				if(CollectionUtils.isEmpty(articuloVO.getVistaGrupoAlcanceLocalDTOs())){
					articuloVO.setVistaGrupoAlcanceLocalDTOs(
								SICFactory.getInstancia().administracion.getDataService().findObjects(new VistaGrupoAlcanceLocalDTO())
							);
				}
				// Se copia los articulos de local a local
				SICFactory.getInstancia().articulo.getArticuloAlcanceServicio().copiarLocal(articuloVO);
			}


			// llamamos al servicio de envio de mail
			SICFactory.getInstancia().administracion.getEnvioMailServicio().mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.COPIAR_LOCAL, userDto, articuloVO);
		} catch (Exception e) {
			articuloVO.setMensajeError(Boolean.TRUE);
			// mensajeria.mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ERROR_EJECUCION_COPIA_LOCAL,userDto,articuloVO);
			SICFactory.getInstancia().administracion.getEnvioMailServicio().mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.COPIAR_LOCAL, userDto, articuloVO);
			throw new SICException("Error al copiarLocal {}" + e);
		}
	}

	/**
	 * Permite copiar los articulos de un local base a otro local, Si el local
	 * no posee articulo-local insertar todos Si el local ya posee articulos ->
	 * inactivar los articulos que actualmente posee e insertar los articulos
	 * del local base
	 * 
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	@Override
	public void copiarLocal(ArticuloVO articuloVO) throws SICException {
		try {
			Logeable.LOG_SICV2.info("Entro a ArticuloAlcanceGestor.copiarLocal()");
			// Validamos la informacion del local
			validacionAlcanceGestor.copiarLocal(articuloVO);

			// Copia los articulos del local
			articuloAlcanceDAO.copiarLocal(articuloVO);
			
			
			articuloAlcanceDAO.actulaizarArticuloEstablecimientoPrototipo(articuloVO);
			
			//insertar bitacora
			articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(articuloVO.getFechaAplicacion(), articuloVO.getOpcionTipoAsignacionAlcance(), articuloVO.getCodigoCompania(), null);

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al copiarLocal {}", e);
			throw new SICException("Error al copiarLocal {}" + e);
		}
	}

	/**
	 * Obtiene los locales que poseen alcance
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloDTO> consultarAlcanceArticuloMAX(HashSet<String> codigoBarrasArticulos) throws SICException {
		if (codigoBarrasArticulos == null || codigoBarrasArticulos.isEmpty()) {
			throw new SICException("Debe enviar el codigo de barras de los articulos a consultar");
		}

		ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
		articuloLocalDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articuloLocalDTO.setLocal(new AreaTrabajoDTO());
		articuloLocalDTO.getLocal().setTipoAreaTrabajoRestriction(null);
		articuloLocalDTO.getLocal().setEstadoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
		articuloLocalDTO.getLocal().setEstablecimientoCiudadDTO(new EstablecimientoCiudadDTO());
		articuloLocalDTO.getLocal().getEstablecimientoCiudadDTO().setEstado(CorporativoConstantes.ESTADO_ACTIVO);
		articuloLocalDTO.getLocal().getEstablecimientoCiudadDTO().setEstablecimientoDTO(new EstablecimientoDTO());
		articuloLocalDTO.getLocal().getEstablecimientoCiudadDTO().getEstablecimientoDTO().setEstado(CorporativoConstantes.ESTADO_ACTIVO);

		ArticuloDTO articuloDTO = new ArticuloDTO();
		articuloDTO.setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
		articuloDTO.getArticuloLocalCol().add(articuloLocalDTO);
		articuloDTO.setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);

		articuloDTO.addCriteriaSearchParameter("codigoBarras", ComparatorTypeEnum.IN_COMPARATOR, codigoBarrasArticulos);
		

		return dataGestor.findObjects(articuloDTO);
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// FIN DE METODOS ADMINISTRACION DE ALCANCES
	// ---------------------------------------------------------------------------------------------------------------------------

	// ---------------------------------------------------------------------------------------------------------------------------
	// INICIO METODOS DE ASIGNACION MASIVO DE ALCANCES
	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * Permite asignar, quitar masivamente articulos de la tabla SCSADTARTLOC,
	 * Obtiene el archivo de SCSADTARTLOC afectados en una misma fecha
	 * (FECHAALCANCE) Actualiza los prototipos de SCSPETARTICULO que han sido
	 * afectados en SCSADTARTLOC Obtiene el archivo de SCSPETARTICULO afectados
	 * en una misma fecha (FECHAMODIFICACION)
	 * 
	 * @param articuloFiltro
	 * @param plantillaFiltrosBusqueda
	 * @throws SICException
	 */
	@Override
	public void asignacionMasivaArticulos(ArticuloVO articuloVO, UserDto userDto) throws SICException {
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando asignacionMasivaArticulos(ArticuloVO articuloFiltro,UserDto userDto)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		// Validacion de parametros , IPlantillaFiltrosBusquedaArticulos
		// plantillaFiltrosBusqueda
		SICFactory.getInstancia().articulo.getArticuloAlcanceServicio().asignacionMasivaArticulos(articuloVO, articuloVO.getPlantillaFiltrosBusquedaArticulos());
		try {
			// LLamamos al metodo que afecta articulo local
			asignacionMasivaArticulos(articuloVO.getBaseDTO(), articuloVO);
			
			// obtener los registros de alcances que no realizo el proceso de asignacion de alcances
			obtenerArticulosAlcanceError(articuloVO);
			
			// llamamos al servicio de envio de mail
			SICFactory.getInstancia().administracion.getEnvioMailServicio().mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ASIGNACION_MASIVA_ARTICULOS, userDto, articuloVO);
		} catch (SICException e) {
			Logeable.LOG_SICV2.error("Error en la asignacionMasivaArticulos {}", e);
			articuloVO.setMensajeError(Boolean.TRUE);
			// mensajeria.mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ERROR_EJECUCION_ASIGNACION_MASIVA_ARTICULOS,userDto,articuloFiltro);
			SICFactory.getInstancia().administracion.getEnvioMailServicio().mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ASIGNACION_MASIVA_ARTICULOS, userDto, articuloVO);
			throw new SICException("Error en la asignacionMasivaArticulos {}", e);
		}
	}
	
	/**
	 * Permite obtener los articulos que generaron error y no se asigno alcance 
	 */
	private void obtenerArticulosAlcanceError(ArticuloVO articuloVO) throws SICException {		
		
		//definir el tipo de area de trabajo
		int signo = 1;
		String sufijoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL;
		if(articuloVO.getOpcionTipoAsignacionAlcance()!= null && 
				(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) 
						||	articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega")))){
			sufijoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA;
		}else if(articuloVO.getOpcionTipoAsignacionAlcance()!= null && 
				(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"))
						||	articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina")))){
			signo = -1;
			sufijoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA;
		}
		
		//obtener bitacora de alcances con error de asignacion de alcances
		Collection<ArticuloAreaTrabajoBitacoraDTO> artAreTraBitCol = SICFactory.getInstancia().articulo.getArticuloAlcanceServicio()
				.obtenerArticuloAreaTrabajoBitacoraError(articuloVO, sufijoAreaTrabajo);
		
		if(CollectionUtils.isNotEmpty(artAreTraBitCol)){
			
			Collection<String> codigosArticulo = new HashSet<String>();
			CollectionUtils.collect(artAreTraBitCol, new BeanToPropertyValueTransformer("codigoArticulo"), codigosArticulo);
			
			// obtener el tipo de coleccion para generar el archivo
			Collection<ArticuloDTO> articulos = SICFactory.getInstancia().articulo.getArticuloService().obtenerArticulos(codigosArticulo);
			Collection<AlcanceArticuloTransient> alcArtTraCol = new ArrayList<AlcanceArticuloTransient>();	
			for(ArticuloAreaTrabajoBitacoraDTO artAreTraBit : artAreTraBitCol){
				AlcanceArticuloTransient alcArtTra = new  AlcanceArticuloTransient();				
				ArticuloDTO articulo = (ArticuloDTO)CollectionUtils.find(articulos, new BeanPredicate("id.codigoArticulo", PredicateUtils.equalPredicate(artAreTraBit.getCodigoArticulo())));
				if(articulo != null){
					alcArtTra.setCodigoBarras(articulo.getCodigoBarras());
					alcArtTra.setDescripcionArticulo(articulo.getDescripcionArticulo());
					alcArtTra.setCodigoLocal(artAreTraBit.getAreaTrabajo().getCodigoReferencia() * signo);
					alcArtTra.setDescripcionLocal(artAreTraBit.getAreaTrabajo().getNombreAreaTrabajo());
					alcArtTraCol.add(alcArtTra);					
				}
			}
			
			//generar el archivo
			this.alcanceBatchUtilGestor.generarArchivoErrorAlcance(
					alcArtTraCol,
					this.generarArchivoErrorTxtJob,
					SICArticuloConstantes.VALOR_RUTA_LOCAL_ARCHIVOS_ALCANCES.concat(
					SICArticuloConstantes.VALOR_ARCHIVO_ALCANCE_SEPARADOR).concat(
					SICArticuloConstantes.VALOR_ARCHIVO_ALCANCE_CARPETA_ERROR).concat(
					SICArticuloConstantes.VALOR_ARCHIVO_ALCANCE_SEPARADOR).concat(
					String.valueOf(articuloVO.getFechaAplicacion().getTime())).concat(
					SICArticuloConstantes.VALOR_ARCHIVO_ALCANCE_EXTENSION_TXT) , 
					SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.alcances.archivo.columnas.txt"));	
		}
	}

	/**
	 * Obtiene el HQL para obtener todos los registros afectados en articulo
	 * local en la fecha de aplicacion
	 * 
	 * @return
	 */
	private String obtenerHQLArticuloLocalFechaAplicacion() {
		StringBuilder sqlQueryString = new StringBuilder("SELECT CODIGOARTICULO AS {vista.codigoArticulo}, FUNARTLOC(CODIGOARTICULO) AS {vista.codigosLocales} ");
		sqlQueryString.append(" FROM SCSADTARTLOC ");
		sqlQueryString.append(" WHERE FECHAREGISTRO = :pFechaAplicacion OR FECHAACTIVACION = :pFechaAplicacion OR FECHAINACTIVACION = :pFechaAplicacion GROUP BY CODIGOARTICULO ");
		return sqlQueryString.toString();
	}

	/**
	 * permite remplazar todos los articulos del local a ser afectado
	 * 
	 * @param articuloVO
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void remplazarArticulosAreasTrabajoMasivo(ArticuloVO articuloVO, UserDto userDto) throws SICException {
		try {
			Logeable.LOG_SICV2.info("***********************************---------------*******************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando remplazarArticulosAreasTrabajoMasivo(ArticuloVO articuloVO,  UserDto userDto)");
			Logeable.LOG_SICV2.info("*********permite remplazar todos los articulos del local a ser afectado***********************************");
			
			
			String cadenaArticuloAreatrabajoNoQuit = null;
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = null;
			HashSet<String> codigoArticulosHS = null;
			String tipoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL;
			String nameTable = SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL;
			
			
			
			if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
					articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega"))){
				tipoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA;
				nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;
			}else if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina")) ||
					articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina"))){
				tipoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA;
				nameTable = SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA;
			}
			
			if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL.equals(tipoAreaTrabajo)){
				/**permite consultar los prototipos y sus combianacion de locales**/
				if(CollectionUtils.isEmpty(articuloVO.getVistaGrupoAlcanceLocalDTOs())){
					VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO = new VistaGrupoAlcanceLocalDTO();
					Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs = dataGestor.findObjects(vistaGrupoAlcanceLocalDTO);
					articuloVO.setVistaGrupoAlcanceLocalDTOs(vistaGrupoAlcanceLocalDTOs);
				}
			}
			
			Collection<Integer> codigosAreaTrabajo = CollectionUtils.collect(articuloVO.getLocales(), new GetInvokerTransformer("localDTO.id.codigoAreaTrabajo"));
			
			/**se obtiene los codigos de los alcances que no se quitaran**/
			if (CollectionUtils.isNotEmpty(articuloVO.getCodigosArticuloAreaTrabajo())) {
				cadenaArticuloAreatrabajoNoQuit = StringUtils.join(articuloVO.getCodigosArticuloAreaTrabajo(), ",");
			}
			
			if(CollectionUtils.isNotEmpty(codigosAreaTrabajo)){
				codigoArticulosHS = new  HashSet<String>();
				
				for(Integer codigArT : codigosAreaTrabajo ){
					/**Se consulta los alcances a quitar **/
					articuloLocalDTOCol = articuloAlcanceDAO.consultarAlcancesPorLocal(articuloVO.getCodigoCompania(), codigArT,tipoAreaTrabajo,articuloVO.getCodigofuncionario());
					
					for(ArticuloLocalDTO articuLoc :articuloLocalDTOCol){
						
						//articuloAlcanceDAO.remplazarArticulosLocalesMasivo(articuloVO, null, null, cadenaArticuloAreatrabajoNoQuit, null, null,articuLoc.getCodigoArticuloLocal());
						
						/**Se ejecuta el update que actualizara el alcance**/
						articuloAlcanceDAO.quitarAlcancesAsignacionMasiva(nameTable, articuloVO.getAccessItemId(), articuloVO.getSystemId(),
								articuloVO.getUsuarioAlcance(), articuloVO.getFechaAplicacion(), cadenaArticuloAreatrabajoNoQuit,
								SICConstantes.ESTADO_ACTIVO_NUMERICO,  SICConstantes.ESTADO_ACTIVO_NUMERICO, articuLoc.getCodigoArticuloLocal(),
								articuloVO.isRemplazarAlcances(),articuloVO.getFechaFinAlcance());
						
						codigoArticulosHS.add(articuLoc.getId().getCodigoArticulo());
					}
				}
				
				for(String codigArt : codigoArticulosHS){
					if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL.equals(tipoAreaTrabajo)){
						/**permite actualizar los prototipos de los articulos afectados**/
						articuloAlcanceDAO.modificarPrototipoAlcance(articuloVO.getCodigoCompania(), codigArt, articuloVO.getUserId(), articuloVO.getFechaAplicacion(), articuloVO.getVistaGrupoAlcanceLocalDTOs());
					}
					// permite actualizar articuloDTO, comunicar SIC, insertar
					// Actualizamos la bitacora
					articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(articuloVO.getFechaAplicacion(), articuloVO.getOpcionTipoAsignacionAlcance(), articuloVO.getCodigoCompania(), codigArt);
				}
			}
			if (SearchDTO.isLoaded(userDto)) {
				// llamamos al servicio de envio de mail
				mensajeria.mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.QUITAR_ALCANCES_SIN_FILTRO, userDto, articuloVO);
			}
		} catch (SICException e) {
			articuloVO.setMensajeError(Boolean.TRUE);
			mensajeria.mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.QUITAR_ALCANCES_SIN_FILTRO, userDto, articuloVO);
			throw new SICException("Error en la remplazarArticulosAreasTrabajoMasivo {}", e);
		}

	}

	/**
	 * Permite asignar, quitar masivamente articulos de la tabla SCSADTARTLOC,
	 * mediante la plantilla de busqueda de articulos (articuloVO) que se le
	 * envia al cursor TemplateCursorItemReader
	 * 
	 * @param articuloFiltro
	 */
	private void asignacionMasivaArticulos(ArticuloDTO articuloDTO, ArticuloVO articuloVO) throws SICException {
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  asignacionMasivaArticulos(ArticuloDTO articuloDTO)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");

		// LLenamos la plantilla a usar en el cursor
		if (articuloDTO.getCriteriaSearch() == null) {
			articuloDTO.setCriteriaSearch(new CriteriaSearch());
		}
		// parametroComunicacionSic=null;
		articuloDTO.getCriteriaSearch().addDistinctSearchParameter(articuloDTO.getClass(), new String[] { "id.codigoArticulo", "codigoBarras", "descripcionArticulo" }, 
				new String[] { "id.codigoArticulo", "codigoBarras", "descripcionArticulo"});

		JobExecution jobExecution;

		try {

			VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO=new VistaGrupoAlcanceLocalDTO();
			Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs = SICFactory.getInstancia().administracion.getDataService().findObjects(vistaGrupoAlcanceLocalDTO);
			articuloVO.setVistaGrupoAlcanceLocalDTOs(vistaGrupoAlcanceLocalDTOs);
			
			
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("fechaEjecucion", new JobParameter(new Date()));
			params.put("plantillaAsignacionMasiva", new ExtendedJobParameter(articuloDTO));
			params.put("plantillaParams", new ExtendedJobParameter(articuloVO));

			/**
			 * Esta validacion permite establecer si se va a utilizar la vista
			 * la cual busca y asigna el prototipo a los alcances, ya que cuando
			 * establecemos que al tener getOpcionTipoAsignacionAlcance de tipo
			 * prototipo ya consta del prototipo
			 */
				jobExecution = jobLauncher.run(asignacionMasivaArticulosJob, new JobParameters(params));
			
				Logeable.LOG_SICV2.info("El trabajo ha finalizado con estado:{} ", jobExecution.getExitStatus());

			if (jobExecution.getExitStatus().equals(ExitStatus.FAILED)) {
				Logeable.LOG_SICV2.info("El trabajo "+ExitStatus.FAILED);
//				throw new SICException("El trabajo  " + ExitStatus.FAILED);
			}

		} catch (JobExecutionAlreadyRunningException e) {
			throw new SICException("Ya existe un trabajo ejecutandose actualmente", e);
		} catch (JobRestartException e) {
			throw new SICException("Error al reiniciar el trabajo", e);
		} catch (JobInstanceAlreadyCompleteException e) {
			throw new SICException("El trabajo ya se encuentra finalizado anteriormente", e);
		} catch (JobParametersInvalidException e) {
			throw new SICException("Parametros no validos", e);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error en la asignacionMasivaArticulos {}", e);
			throw new SICException("Error en la asignacionMasivaArticulos {}", e);
		}
	}

	/**
	 * Permite actualizar el prototipo en la signacion de alcances masivos
	 */
	@Override
	public void asignacionMasivaArticulosActualizarPrototipo(Timestamp fechaAplicacion, String userId, String opcionTipoAsignacionAlcance, Integer codigoCompania) throws SICException {
		try {
			//permite obtener los articulos modificados por la comparacion de las fechas (fechaRegistro,fechaActivacion,fechaInactivacion)
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = articuloAlcanceDAO.consultarAlcancesModificados(fechaAplicacion);
			
			if(CollectionUtils.isNotEmpty(articuloLocalDTOCol)){
			//permite traer las convinaciones de prototipos y locales
				VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO = new VistaGrupoAlcanceLocalDTO();
				Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs = dataGestor.findObjects(vistaGrupoAlcanceLocalDTO);
			
				//se obtiene el articulo consultado
				for (ArticuloLocalDTO articuloLocalDTO :  articuloLocalDTOCol) {
					//permite modificar el prototipo con su prototipo
					articuloAlcanceDAO.modificarPrototipoAlcance(codigoCompania, articuloLocalDTO.getId().getCodigoArticulo(), userId, fechaAplicacion, vistaGrupoAlcanceLocalDTOs);
				}
			}

		}  catch (SICException e) {
			Logeable.LOG_SICV2.error("Error al actualizar los protoripos en la asignacion masiva de alcances", e);
			throw new SICException("Error al actualizar los protoripos en la asignacion masiva de alcances");
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al actualizar los protoripos en la asignacion masiva de alcances", e);
			throw new SICException("Error al actualizar los protoripos en la asignacion masiva de alcances");
		}
	}
	
	/**
	 * Permite asignar masivamente art&iacute;culos a los locales por archivo
	 * 
	 * @param articuloFiltro
	 * @param codigosBarras
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	@Override
	public void asignacionMasivaArticulosPorArchivo(ArticuloVO articuloVO, ArrayList<ArticuloDTO> articuloCol, UserDto userDto) throws SICException {
		try {
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando asignacionMasivaArticulosPorArchivo(ArticuloVO articuloFiltro, ArrayList<ArticuloDTO> articuloCol,UserDto userDto)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			/**permite buscar los prototipos con su conbinacion de locales**/
			if(CollectionUtils.isEmpty(articuloVO.getVistaGrupoAlcanceLocalDTOs())){
				VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO = new VistaGrupoAlcanceLocalDTO();
				Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs = SICFactory.getInstancia().administracion.getDataService().findObjects(vistaGrupoAlcanceLocalDTO);
				articuloVO.setVistaGrupoAlcanceLocalDTOs(vistaGrupoAlcanceLocalDTOs);
			}
			
			/**Permite la asignacion de alcance,establecimiento,actualizacion prototipo,inserta bitacora**/
			SICFactory.getInstancia().articulo.getArticuloAlcanceServicio().asignarAlcancesAreaTrabajo(articuloCol, articuloVO);
			
			// llamamos al servicio de envio de mail
			SICFactory.getInstancia().administracion.getEnvioMailServicio().mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ASIGNACION_MASIVA_ARTICULOS, userDto, articuloVO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error en la asignacionMasivaArticulosPorArchivo {}", e);
			articuloVO.setMensajeError(Boolean.TRUE);
			SICFactory.getInstancia().administracion.getEnvioMailServicio().mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance.ASIGNACION_MASIVA_ARTICULOS_POR_ARCHIVO, userDto, articuloVO);
			throw new SICException("Error en la asignacionMasivaArticulosPorArchivo {}", e);
		}
	}


	/**
	 * Permite obtener los c&oacute;digos v&aacute;lidos del archivo
	 * 
	 * @param prototipoAlcanceVO
	 * @param inputStreamArchAlcArticulos
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings({ "unchecked" })
	public Collection<ArticuloDTO> obtenerCodigosValidosPorArchivo(ArticuloVO articuloVO, Collection<String> codigosBarras) throws SICException {
		try {
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  obtenerCodigosValidosPorArchivo(ArticuloVO articuloVO,InputStream inputStreamArchAlcArticulos)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			Logeable.LOG_SICV2.info("Entro a ArticuloAlcanceGestor.obtenerCodigosValidosPorArchivo()");
			Collection<String> codigosBarrasTrans = new ArrayList<String>();
			Iterator it = codigosBarras.iterator();
			while(it.hasNext()) { 
				codigosBarrasTrans.add(SICFactory.getInstancia().articulo.getArticuloCalculoService().transformarCodigoBarras(it.next().toString()));
	        }
			
			// permite recuperar los articulos consultados en Batch
			artResulArchiv = new ArrayList<ArticuloDTO>();
			
			// LLenamos la plantilla a usar en el cursor
			if (articuloVO.getBaseDTO().getCriteriaSearch() == null) {
				articuloVO.getBaseDTO().setCriteriaSearch(new CriteriaSearch());
			}

			if(CollectionUtils.isNotEmpty(codigosBarrasTrans)){
				articuloVO.getBaseDTO().addCriteriaSearchParameter("codigoBarras", ComparatorTypeEnum.IN_COMPARATOR, codigosBarrasTrans);
		
				articuloVO.getBaseDTO().getCriteriaSearch().addDistinctSearchParameter(articuloVO.getBaseDTO().getClass(), new String[] { "id.codigoArticulo", "codigoBarras" }, new String[] { "id.codigoArticulo", "codigoBarras" });
				
				JobExecution jobExecution;
	
				try {
					
	
					Map<String, JobParameter> params = new HashMap<String, JobParameter>();
					params.put("fechaEjecucion", new JobParameter(new Date()));
					params.put("plantilla", new ExtendedJobParameter(articuloVO.getBaseDTO()));
					jobExecution = jobLauncher.run(articulosArchivoAlcanceJob, new JobParameters(params));
					Logeable.LOG_SICV2.info("El trabajo ha finalizado con estado:{} ", jobExecution.getExitStatus());
	
					if (jobExecution.getExitStatus().equals(ExitStatus.FAILED)) {
						throw new SICException("El trabajo  " + ExitStatus.FAILED);
					}
	
				} catch (JobExecutionAlreadyRunningException e) {
					throw new SICException("Ya existe un trabajo ejecutandose actualmente", e);
				} catch (JobRestartException e) {
					throw new SICException("Error al reiniciar el trabajo", e);
				} catch (JobInstanceAlreadyCompleteException e) {
					throw new SICException("El trabajo ya se encuentra finalizado anteriormente", e);
				} catch (JobParametersInvalidException e) {
					throw new SICException("Parametros no validos", e);
				} catch (Exception e) {
					Logeable.LOG_SICV2.info("Error en la obtenerCodigosValidosPorArchivo {}", e);
					throw new SICException("Error en la obtenerCodigosValidosPorArchivo {}", e);
				}
	
				Logeable.LOG_SICV2.info("----->TamArticulosValidos{}", artResulArchiv.size());
			}
			return artResulArchiv;

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error en la obtenerCodigosValidosPorArchivo {}", e.getMessage());
			throw new SICException(e.getMessage());
		}
	}

	/**
	 * Permite obtener articulos con su respectivo codigo a partir de plantilla
	 * 
	 * @param prototipoAlcanceVO
	 * @param codigosBarras
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloDTO> obtenerArticulosDeCodigosBarras(ArrayList<String> codigosArticulos, ArticuloVO articuloVO) throws SICException {
		try {
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  obtenerArticulosDeCodigosBarras(ArrayList<String> codigosArticulos,ArticuloVO articuloVO)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			Integer paginacion = Integer.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcance.archivo.paginacion"));
			Collection<ArticuloDTO> articuloDTOs = new ArrayList<ArticuloDTO>();

			if (CollectionUtils.isNotEmpty(codigosArticulos)) {

				ArticuloDTO articuloDTO = new ArticuloDTO();
				articuloDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				articuloDTO.setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);

				if (codigosArticulos.size() < paginacion) {

					articuloDTO.addCriteriaSearchParameter("id.codigoArticulo", ComparatorTypeEnum.IN_COMPARATOR, codigosArticulos);

					// Consultamos todos los articulos que cuentan con los
					// codigos de barra que se envio de parametro
					articuloDTOs = dataGestor.findObjects(articuloDTO);

				} else {
					int i = 0;
					Collection<String> codigoArticulosSeleccionadas = new ArrayList<String>();

					for (String codigoArticulos : codigosArticulos) {
						codigoArticulosSeleccionadas.add(codigoArticulos);
						if (i == paginacion) {
							articuloDTO.addCriteriaSearchParameter("id.codigoArticulo", ComparatorTypeEnum.IN_COMPARATOR, codigoArticulosSeleccionadas);
							articuloDTOs.addAll(dataGestor.findObjects(articuloDTO));

							codigoArticulosSeleccionadas = new ArrayList<String>();
							i = 0;
						} else {
							i++;
						}
					}
					if (CollectionUtils.isNotEmpty(codigoArticulosSeleccionadas)) {
						articuloDTO.addCriteriaSearchParameter("id.codigoArticulo", ComparatorTypeEnum.IN_COMPARATOR, codigoArticulosSeleccionadas);
						articuloDTOs.addAll(dataGestor.findObjects(articuloDTO));
					}
				}
			}

			return articuloDTOs;

		} catch (DAOException e) {
			throw new SICException(e);
		}
	}

	/**
	 * Permite procesar el archivo
	 * 
	 * @param prototipoAlcanceVO
	 * @param inputStreamArchAlcArticulos
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<String> procesarArchivo(InputStream inputStreamArchAlcArticulos) throws SICException {
		try {
			// Se valida el archivo cargado
			return validacionArchivo(inputStreamArchAlcArticulos);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al procesarArchivo {}", e.getMessage());
			throw new SICException(e.getMessage());
		}
	}

	/**
	 * Valida el formato del archivo de articulos
	 * 
	 * @param prototipoAlcanceVO
	 * @param inputStreamArchAlcArticulos
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection<String> validacionArchivo(InputStream inputStreamArchAlcArticulos) throws SICException {
		try {
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  validacionArchivo(InputStream inputStreamArchAlcArticulos)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			List cellDataTmpList = new ArrayList();
			Integer numFila = 1;
			Collection<String> codigosBarras = null;
			HashSet<String> codigosBarrasHS = null;
			Workbook wb = WorkbookFactory.create(inputStreamArchAlcArticulos);
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			codigosBarras = new ArrayList<String>();
			codigosBarrasHS = new HashSet<String>();
			// Itero las filas
			while (rowIterator.hasNext()) {
				Row hssfRow = rowIterator.next();

				// Recorro la columna
				List cellTempList = new ArrayList();
				for (int i = 0; i < Integer.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcance.validacion.tamanio.columnas")); i++) {
					// Seteo el valor de cada columna de la fila
					Cell hssfCell = hssfRow.getCell(i, Row.CREATE_NULL_AS_BLANK);
					cellTempList.add(hssfCell);
				}
				// Se agregan las filas validas
				if (!cellTempList.isEmpty() && cellTempList.size() == Integer.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcance.validacion.tamanio.columnas"))) {
					cellTempList.add(numFila);
					cellDataTmpList.add(cellTempList);
				}
			}
			numFila++;

			// Obtengo los codigos de barras en una lista
			Cell hssfCell;
			String codigoBarras;
			for (int i = 0; i < cellDataTmpList.size(); i++) {
				List cellTempList = (List) cellDataTmpList.get(i);
				hssfCell = (Cell) cellTempList.get(0);
				codigoBarras = (StringUtils.isEmpty(obtenerValorCelda(hssfCell).trim())) ? null : (new BigDecimal(obtenerValorCelda(hssfCell))).toPlainString();

				if (StringUtils.isNotEmpty(codigoBarras)) {
					if (codigoBarras.endsWith(".0"))
						codigoBarras = codigoBarras.substring(0, codigoBarras.length() - 2);
					codigosBarrasHS.add(codigoBarras);
				}
			}
			codigosBarras.addAll(codigosBarrasHS);
			ColeccionesUtil.sort(codigosBarras, ColeccionesUtil.ORDEN_ASC);

			return codigosBarras;
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error en la validacionArchivo {}", e);
			throw new SICException(e.getMessage());
		}

	}

	private String obtenerValorCelda(Cell hssfCell) {
		switch (hssfCell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			return String.valueOf(hssfCell.getNumericCellValue());
		case HSSFCell.CELL_TYPE_STRING:
			String valorCell = hssfCell.getRichStringCellValue().getString();
			String valorCellSinEsp = "";
			for(int i = 0; i< valorCell.length(); i++){
				if(!Character.isSpaceChar(valorCell.charAt(i))){
					valorCellSinEsp += valorCell.charAt(i);
				}
			}
			String valCellSinCaracDel = valorCellSinEsp.replaceAll("^\\s*","");
			String valCellSinCaracDet = valCellSinCaracDel.replaceAll("\\s*$","");
			return (StringUtils.isNumeric(valCellSinCaracDet)) ? valCellSinCaracDet : " ";
		case HSSFCell.CELL_TYPE_BLANK:
			return " ";
		case HSSFCell.CELL_TYPE_BOOLEAN:
			Logeable.LOG_SICV2.info("entro boolean");
			return " ";
		case HSSFCell.CELL_TYPE_FORMULA:
			Logeable.LOG_SICV2.info("entro Formula");
			return (StringUtils.isNumeric(hssfCell.getRichStringCellValue().getString())) ? hssfCell.getRichStringCellValue().getString() : " ";
		}
		return null;
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// FIN METODOS DE ASIGNACION MASIVO DE ALCANCES
	// ---------------------------------------------------------------------------------------------------------------------------

	// ---------------------------------------------------------------------------------------------------------------------------
	// INICIO METODOS DE INTEGRACION CON EL SIC
	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * Permite obtener los articulos local que se afectaron sus alcances
	 * 
	 * @param fechaAplicacion
	 */
	@Override
	public void obtenerArticuloLocalSIC(ArticuloVO articuloVO) throws SICException {
		try {
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  obtenerArticuloLocalSIC(ArticuloVO articuloVO)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			// se establece los valores necesarios para la integracion
			ArticuloLocalDTO articuloLocalDTO = paramsStepComunicarSic(articuloVO);
			articuloLocalDTO.setCriteriaSearch(null);

			JobExecution jobExecution;

			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("fechaEjecucion", new JobParameter(new Date()));
			params.put("plantillaComunicarSic", new ExtendedJobParameter(articuloLocalDTO));
			params.put("plantillaParams", new ExtendedJobParameter(articuloVO));
			jobExecution = jobLauncher.run(comunicarArticuloAlcanceJob, new JobParameters(params));
			Logeable.LOG_SICV2.info("El trabajo ha finalizado con estado:{} ", jobExecution.getExitStatus());

			if (jobExecution.getExitStatus().equals(ExitStatus.FAILED)) {
				throw new SICException("El trabajo  obtenerArticuloLocalSIC ha finalizado con estado: " + ExitStatus.FAILED);
			}

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error en la obtenerArticuloLocalSIC {}", e);
			throw new SICException("Error al obtenerArticuloLocalSIC {}", e);
		}
	}

	// /CMUNICAR SIC SELECT NATIVO INICIO
	@SuppressWarnings("unchecked")
	public void comunicarArticuloLocalSIC(Collection<Object[]> objArtLocCol, String subTipAreaTrabajo, Integer codigoCompania) throws SICException {
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  comunicarArticuloLocalSIC(Collection<ArticuloLocalDTO> articuloLocalCol,ArticuloVO articuloVO)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		if (CollectionUtils.isNotEmpty(objArtLocCol)) {
			try {
				// Se obtiene los codigos de los locales diferentes
				HashSet<Integer> codigosLocales = new HashSet<Integer>();
				for (Object[] arrayObjArtLoc : objArtLocCol) {
					codigosLocales.add((Integer) arrayObjArtLoc[2]);
				}

				// Iteramos los codigos unicos
				for (final Integer codigoLocal : codigosLocales) {
					// Obtenemos la coleccion de articulo local que corresponde
					// a cada local
					Collection<Object[]> articuloLocalColVerificar = CollectionUtils.select(objArtLocCol, new Predicate() {
						@Override
						public boolean evaluate(Object objetoActual) {
							return ((Integer) ((Object[]) objetoActual)[2]).intValue() == codigoLocal.intValue();
						}
					});

					if (CollectionUtils.isNotEmpty(articuloLocalColVerificar)) {
						objArtLocCol.removeAll(articuloLocalColVerificar);
					}

					HashMap<String, Collection<Object[]>> artLocIntegrar = new HashMap<String, Collection<Object[]>>();
					String userId = "";
					// permite agrupar e integrar por usuario de modificacion o
					// registro
					for (Object[] arrayArtLocal : articuloLocalColVerificar) {
						if (StringUtils.isNotBlank((String) arrayArtLocal[18])) {
							userId = (String) arrayArtLocal[18];
						} else {
							userId = (String) arrayArtLocal[8];
						}

						if (artLocIntegrar.containsKey(userId)) {
							artLocIntegrar.get(userId).add(arrayArtLocal);
						} else {
							Collection<Object[]> artLocCol = new ArrayList<Object[]>();
							artLocCol.add(arrayArtLocal);
							artLocIntegrar.put(userId, artLocCol);
						}
					}

					// se recorre toda la agrupacion de idusuario para integrar
					// de forma integrada
					for (String userIdIntegracion : artLocIntegrar.keySet()) {
						Collection<Object[]> articuloLocalColInt = artLocIntegrar.get(userIdIntegracion);

						// Se arma la cabecera y detalle para su integracion
						final String TIPOPROCESO = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.activarDesactivarAlcanceArticulo");
						ActivarDesactivarAlcanceArticuloIDTO actDesAlcArt = new ActivarDesactivarAlcanceArticuloIDTO();
						actDesAlcArt.getControlProceso().setProceso(TIPOPROCESO);
						actDesAlcArt.setUsuarioRegistro(userIdIntegracion);// SICConstantes.USERID

						if (SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA.equals(subTipAreaTrabajo)) {
							actDesAlcArt.setCodigoAreaTrabajo((Integer) articuloLocalColVerificar.iterator().next()[19]);
						} else if (SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA.equals(subTipAreaTrabajo)) {
							actDesAlcArt.setCodigoAreaTrabajo((Integer) articuloLocalColVerificar.iterator().next()[19]);
						} else {
							actDesAlcArt.setCodigoAreaTrabajo(codigoLocal);
						}

						actDesAlcArt.setDetalle(new ArrayList<ActivarDesactivarAlcanceArticuloDetalleIDTO>());

						// Iteramos la coleccion y transformamos a objetos de
						// integracion
						if (CollectionUtils.isNotEmpty(articuloLocalColInt)) {
							ActivarDesactivarAlcanceArticuloDetalleIDTO actDesAlcArtDet;
							for (Object[] objArtLoc : articuloLocalColInt) {
								// Objeto de integracion detalle
								actDesAlcArtDet = new ActivarDesactivarAlcanceArticuloDetalleIDTO();
								actDesAlcArtDet.setCodigoBarras((String) objArtLoc[5]);
								actDesAlcArtDet.setCodigoPrototipo((objArtLoc[4] == null) ? null : (String) objArtLoc[4]);
								// Se realiza la conversion de estado apertura
								// local y notifica local porque en el sistema
								// MAX cuando un local es de apertura tiene el
								// valor de true y en el sistema SIC tiene un
								// valor de false, de igual manera en notifica
								// local
								actDesAlcArtDet.setEsApertura(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals((String) objArtLoc[16]) ? SICConstantes.ESTADO_INACTIVO_NUMERICO : SICConstantes.ESTADO_ACTIVO_NUMERICO); // (articuloVO!=null
																																																																	// &&
																																																																	// StringUtils.isNotEmpty(articuloVO.getEsApertura()))
																																																																	// ?
																																																																	// articuloVO.getEsApertura()
																																																																	// :
																																																																	// actDesAlcArtDet.getEsApertura());
								actDesAlcArtDet.setNotificaAreaTrabajo(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals((String) objArtLoc[17]) ? SICConstantes.ESTADO_INACTIVO_NUMERICO : SICConstantes.ESTADO_ACTIVO_NUMERICO); // (articuloVO!=null
																																																																			// &&
																																																																			// StringUtils.isNotEmpty(articuloVO.getNotificarLocal()))
																																																																			// ?
																																																																			// articuloVO.getNotificarLocal()
																																																																			// :
																																																																			// actDesAlcArtDet.getEsApertura());
								actDesAlcArtDet.setEstadoAlcance((String) objArtLoc[3]);
								actDesAlcArt.getDetalle().add(actDesAlcArtDet);
							}
						}

						// Validar detalles
						if (!actDesAlcArt.getDetalle().isEmpty()) {
							/**
							 * Se establece codigos de integracion los cuales
							 * permitiran entender el resultado de la
							 * integracion
							 * CODIGO_ERROR_INTEGRACION_SIC_LOCAL_NO_EXISTE
							 * cabecera-> no se integro porque el local no
							 * existe
							 * CODIGO_ERROR_INTEGRACION_SIC_PROTOTIPO_NO_EXISTE
							 * cabecera -> no se integro porque el prototipo no
							 * existe
							 * CODIGO_ERROR_INTEGRACION_SIC_ARTICULO_NO_EXISTE
							 * detalle -> el articulo no existe
							 */
							// Este try permite que al momento que exista
							// problemas con el envio de uno de los mensajes al
							// SIC no termine la
							// integracion, permitiendo que se integren los que
							// no tengan estos problemas
							try {
								// aqui se envia el mensaje al SIC
								actDesAlcArt = (ActivarDesactivarAlcanceArticuloIDTO) SICIntegracion.procesarMensaje(actDesAlcArt);

								Transformer codigoArticuloTransformer = new GetInvokerTransformer("codigoBarras");
								ArrayList<String> listCodigosArticulos = (ArrayList<String>) CollectionUtils.collect(actDesAlcArt.getDetalle(), codigoArticuloTransformer);
								StringBuilder codigosbarras = new StringBuilder();
								codigosbarras.append("'" + StringUtils.join(listCodigosArticulos, "','") + "'");

								this.articuloAlcanceDAO.cambiarEstadoIntegracionAlcances(codigosbarras, codigoLocal, SICConstantes.ESTADO_ACTIVO_NUMERICO, userIdIntegracion, subTipAreaTrabajo, codigoCompania);

							} catch (Exception e) {
								Logeable.LOG_SICV2.error("ERROR DE INTEGRACION ALCANCE EN TAREA PROGRAMADA -> ", e);
							}

						}// Validar detalles
					}// for idUserIntegracion
				}
			} catch (Exception e) {
				Logeable.LOG_SICV2.error("Error al comunicarArticuloLocalSIC {}", e);
			}
		}
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************---------------------------------------------------------  FINALIZO INTEGRACION---*************************************************************************************");
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");

	}

	// COMUNICAR SIC SELECT NATIVO FIN

	/**
	 * Permite comunicar los articulos que se afectaron alcance al SIC la
	 * comunicacion es Local y sus Articulos
	 * 
	 * @param articuloLocalCol
	 */
	@SuppressWarnings("unchecked")
	public void comunicarArticuloLocalSIC(Collection<ArticuloLocalDTO> articuloLocalCol, ArticuloVO articuloVO) throws SICException {
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  comunicarArticuloLocalSIC(Collection<ArticuloLocalDTO> articuloLocalCol,ArticuloVO articuloVO)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		if (CollectionUtils.isNotEmpty(articuloLocalCol)) {
			try {
				// Se obtiene los codigos de los locales diferentes
				HashSet<Integer> codigosLocales = new HashSet<Integer>();
				for (ArticuloLocalDTO articuloLocalDTO : articuloLocalCol) {
					codigosLocales.add(articuloLocalDTO.getId().getCodigoLocal());
				}
				// permite obtener los articulos o locales que no fueron
				// integrados
				Collection<ArticuloAlcanceIntegracionTransient> artAlcIntTrCol = new ArrayList<ArticuloAlcanceIntegracionTransient>();

				// Iteramos los codigos unicos
				for (final Integer codigoLocal : codigosLocales) {
					// Obtenemos la coleccion de articulo local que corresponde
					// a cada local
					Collection<ArticuloLocalDTO> articuloLocalColVerificar = CollectionUtils.select(articuloLocalCol, new Predicate() {

						@Override
						public boolean evaluate(Object objetoActual) {
							// TODO Auto-generated method stub
							return ((ArticuloLocalDTO) objetoActual).getId().getCodigoLocal().intValue() == codigoLocal.intValue();
						}
					});

					HashMap<String, Collection<ArticuloLocalDTO>> artLocIntegrar = new HashMap<String, Collection<ArticuloLocalDTO>>();
					String userId = "";
					// permite agrupar e integrar por usuario de modificacion o
					// registro
					for (ArticuloLocalDTO articuloLocalDTO : articuloLocalColVerificar) {
						if (StringUtils.isNotBlank(articuloLocalDTO.getIdUsuarioModificacion())) {
							userId = articuloLocalDTO.getIdUsuarioModificacion();
						} else {
							userId = articuloLocalDTO.getIdUsuarioRegistro();
						}

						if (artLocIntegrar.containsKey(userId)) {
							artLocIntegrar.get(userId).add(articuloLocalDTO);
						} else {
							Collection<ArticuloLocalDTO> artLocCol = new ArrayList<ArticuloLocalDTO>();
							artLocCol.add(articuloLocalDTO);
							artLocIntegrar.put(userId, artLocCol);
						}
					}

					// se recorre toda la agrupacion de idusuario para integrar
					// de forma integrada
					for (String userIdIntegracion : artLocIntegrar.keySet()) {
						Collection<ArticuloLocalDTO> articuloLocalColInt = artLocIntegrar.get(userIdIntegracion);
						// permite obtener el estado para poder validar si es de
						// sispe
						String estadoAlcance = articuloLocalColInt.iterator().next().getEstadoArticuloLocal();

						// Se arma la cabecera y detalle para su integracion
						final String TIPOPROCESO = SICIntegracionMessages.getString("ec.com.smx.sic.integracion.proceso.activarDesactivarAlcanceArticulo");
						ActivarDesactivarAlcanceArticuloIDTO actDesAlcArt = new ActivarDesactivarAlcanceArticuloIDTO();
						actDesAlcArt.getControlProceso().setProceso(TIPOPROCESO);
						// permite validar que el alcance que se debe enviar al
						// sic sea o no de sispe
						if (estadoAlcance.equals(SICConstantes.VALOR_ACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE) || estadoAlcance.equals(SICConstantes.VALOR_INACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE)) {
							actDesAlcArt.setUsuarioRegistro(SICConstantes.VALOR_USUARIO_SISPE_INTEGRACION);
						} else {
							actDesAlcArt.setUsuarioRegistro(userIdIntegracion);// SICConstantes.USERID
						}

						if (StringUtils.isNotEmpty(articuloVO.getOpcionTipoAsignacionAlcance())) {
							if ((articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina")) || articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina")))) {
								AreaTrabajoDTO areaTrabajoDTO = new AreaTrabajoDTO();
								areaTrabajoDTO.getId().setCodigoAreaTrabajo(codigoLocal);
								areaTrabajoDTO = dataGestor.findUnique(areaTrabajoDTO);
								actDesAlcArt.setCodigoAreaTrabajo(areaTrabajoDTO.getCodigoReferencia() * -1);

							} else if (articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"))) {
								AreaSublugarTrabajoDTO areaSublugarTrabajoDTO = new AreaSublugarTrabajoDTO();
								areaSublugarTrabajoDTO.getId().setCodigoAreaSublugarTrabajo(codigoLocal);
								areaSublugarTrabajoDTO.setEstado(Boolean.TRUE);
								areaSublugarTrabajoDTO.setAreaTrabajoDTO(new AreaTrabajoDTO());
								areaSublugarTrabajoDTO.getAreaTrabajoDTO().setTipoAreaTrabajoRestriction(null);
								areaSublugarTrabajoDTO.getAreaTrabajoDTO().setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DE_DISTRIBUCION);
								Collection<AreaSublugarTrabajoDTO> areaSublugarTrabajoCol = dataGestor.findObjects(areaSublugarTrabajoDTO);
								if (CollectionUtils.isNotEmpty(areaSublugarTrabajoCol)) {
									actDesAlcArt.setCodigoAreaTrabajo(areaSublugarTrabajoCol.iterator().next().getAreaTrabajoDTO().getCodigoReferencia());
								}
							}
						} else {
							actDesAlcArt.setCodigoAreaTrabajo(codigoLocal);
						}

						actDesAlcArt.setDetalle(new ArrayList<ActivarDesactivarAlcanceArticuloDetalleIDTO>());

						// Iteramos la coleccion y transformamos a objetos de
						// integracion
						if (CollectionUtils.isNotEmpty(articuloLocalColInt)) {
							ActivarDesactivarAlcanceArticuloDetalleIDTO actDesAlcArtDet;
							for (ArticuloLocalDTO articuloLocalDTO : articuloLocalColInt) {
								// Objeto de integracion detalle
								actDesAlcArtDet = new ActivarDesactivarAlcanceArticuloDetalleIDTO();
								actDesAlcArtDet.setCodigoBarras(articuloLocalDTO.getArticulo().getCodigoBarras());
								actDesAlcArtDet.setCodigoPrototipo(SearchDTO.isLoaded(articuloLocalDTO.getArticulo().getGrupoAlcanceDTO()) ? articuloLocalDTO.getArticulo().getGrupoAlcanceDTO().getCodigoReferencia() : " ");
								// Se realiza la conversion de estado apertura
								// local y notifica local porque en el sistema
								// MAX cuando un local es de apertura tiene el
								// valor de true y en el sistema SIC tiene un
								// valor de false, de igual manera en notifica
								// local
								actDesAlcArtDet.setEsApertura( ( (StringUtils.isEmpty(articuloLocalDTO.getAperturaLocal()))? SICConstantes.ESTADO_ACTIVO_NUMERICO : articuloLocalDTO.getAperturaLocal() ) );//SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(articuloLocalDTO.getAperturaLocal()) ? SICConstantes.ESTADO_INACTIVO_NUMERICO : SICConstantes.ESTADO_ACTIVO_NUMERICO); // (articuloVO!=null
																																																																				// actDesAlcArtDet.getEsApertura());
								actDesAlcArtDet.setNotificaAreaTrabajo( ( (StringUtils.isEmpty(articuloLocalDTO.getNotificarLocal()))? SICConstantes.ESTADO_ACTIVO_NUMERICO : articuloLocalDTO.getNotificarLocal() ) ); //SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(articuloLocalDTO.getNotificarLocal()) ? SICConstantes.ESTADO_INACTIVO_NUMERICO : SICConstantes.ESTADO_ACTIVO_NUMERICO); // (articuloVO!=null

								// permite enviar de manera correcta el estado
								// del alcance modificando los estados de sispe
								// 2->0 y 3->1 y en caso contrario se envia lo
								// que viene en el alcance
								if (estadoAlcance.equals(SICConstantes.VALOR_ACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE) || estadoAlcance.equals(SICConstantes.VALOR_INACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE)) {
									actDesAlcArtDet.setEstadoAlcance((estadoAlcance.equals(SICConstantes.VALOR_INACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE) ? SICConstantes.ESTADO_INACTIVO_NUMERICO : SICConstantes.ESTADO_ACTIVO_NUMERICO));
								} else {
									actDesAlcArtDet.setEstadoAlcance(articuloLocalDTO.getEstadoArticuloLocal());
								}
								actDesAlcArt.getDetalle().add(actDesAlcArtDet);
							}
						}

						// Validar detalles
						if (!actDesAlcArt.getDetalle().isEmpty()) {
							/**
							 * Se establece codigos de integracion los cuales
							 * permitiran entender el resultado de la
							 * integracion
							 * CODIGO_ERROR_INTEGRACION_SIC_LOCAL_NO_EXISTE
							 * cabecera-> no se integro porque el local no
							 * existe
							 * CODIGO_ERROR_INTEGRACION_SIC_PROTOTIPO_NO_EXISTE
							 * cabecera -> nos e integro porque el prototipo no
							 * existe
							 * CODIGO_ERROR_INTEGRACION_SIC_ARTICULO_NO_EXISTE
							 * detalle -> el articulo no existe
							 */
							// Este try permite que al momento que exista
							// problemas con el envio de uno de los mensajes al
							// SIC no termine la
							// integracion, permitiendo que se integren los que
							// no tengan estos problemas
							try {
								// aqui se envia el mensaje al SIC
								actDesAlcArt = (ActivarDesactivarAlcanceArticuloIDTO) SICIntegracion.procesarMensaje(actDesAlcArt);

								if (actDesAlcArt.getControlProceso().getResultado().startsWith(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_LOCAL_NO_EXISTE)) {
									Collection<ArticuloLocalDTO> articuloLocalDTOs = new ArrayList<ArticuloLocalDTO>();
									articuloLocalDTOs.addAll(articuloLocalColInt);
									for (ArticuloLocalDTO artLocDTO : articuloLocalDTOs) {
										ArticuloAlcanceIntegracionTransient artAlIntTr;
										artAlIntTr = removerArticuloLocalPorCodigoBarras(artLocDTO.getArticulo().getCodigoBarras().toString(), articuloLocalColInt);
										artAlIntTr.setTipoError(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_LOCAL_NO_EXISTE);
										artAlcIntTrCol.add(artAlIntTr);
									}

								} else {
									for (ActivarDesactivarAlcanceArticuloDetalleIDTO actDesAlcDet : actDesAlcArt.getDetalle()) {
										if (actDesAlcDet.getObservacion().toString().startsWith(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_PROTOTIPO_NO_EXISTE)) {

											ArticuloAlcanceIntegracionTransient artAlIntTr;
											artAlIntTr = removerArticuloLocalPorCodigoBarras(actDesAlcDet.getCodigoBarras().toString(), articuloLocalColInt);
											// artAlIntTr.setObservacion("El Prototipo no existe en el SIC");
											artAlIntTr.setTipoError(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_PROTOTIPO_NO_EXISTE.toString());
											artAlcIntTrCol.add(artAlIntTr);

										} else if (actDesAlcDet.getObservacion().toString().startsWith(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_ARTICULO_NO_EXISTE)) {

											ArticuloAlcanceIntegracionTransient artAlIntTr;
											artAlIntTr = removerArticuloLocalPorCodigoBarras(actDesAlcDet.getCodigoBarras().toString(), articuloLocalColInt);
											// artAlIntTr.setObservacion("El art\u00EDculo no existe en el SIC");
											artAlIntTr.setTipoError(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_ARTICULO_NO_EXISTE);
											artAlcIntTrCol.add(artAlIntTr);
										}
									}
								}

								if (CollectionUtils.isNotEmpty(articuloLocalColInt)) {
									Integer codLocal = codigoLocal;
									if (StringUtils.isNotEmpty(articuloVO.getOpcionTipoAsignacionAlcance()) && (articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) || articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega")))) {
										codLocal = articuloLocalColInt.iterator().next().getCodigoBodega();
									}

									// Actualizar el estado de la integracion de
									// articulo local
									this.articuloAlcanceDAO.cambiarEstadoIntegracionArticuloLocal(articuloLocalColInt, codLocal, SICConstantes.ESTADO_ACTIVO_NUMERICO, userIdIntegracion, articuloVO.getOpcionTipoAsignacionAlcance(), articuloVO.getCodigoCompania());
								}
								// }
								// Procedemos a validar los articulos no
								// integrados
								else if (CollectionUtils.isNotEmpty(artAlcIntTrCol)) {
									this.articuloAlcanceDAO.cambiarEstadoIntegracionArticuloLocal(artAlcIntTrCol, articuloVO.getOpcionTipoAsignacionAlcance());
									artAlcIntTrCol = new ArrayList<ArticuloAlcanceIntegracionTransient>();
								}

							} catch (Exception e) {
								Logeable.LOG_SICV2.error("ERROR DE INTEGRACION ALCANCE EN TAREA PROGRAMADA -> ", e);
							}

						}// Validar detalles
					}// for idUserIntegracion
				}
			} catch (Exception e) {
				Logeable.LOG_SICV2.error("Error al comunicarArticuloLocalSIC {}", e);
			}
		}
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************---------------------------------------------------------  FINALIZO INTEGRACION---*************************************************************************************");
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");

	}

	@Override
	public void cambiarEstadoIntegracion(Integer codigoCompania, String userId, String tipoAreatrabajo, Boolean esApertura)throws SICException{
		try {
			int interPag = 0, intervaloForIntegrar = 0, maxPage = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.alcances.integracion.alcances.maxpage");
			String estadoAperturaLocal="";
			
			ParametroDTO paramAlcanceTP = new ParametroDTO();
			ParametroDTO paramAlcanceIntTod = new ParametroDTO();
			ParametroDTO paramPagIntAlcance = new ParametroDTO();
			ArticuloVO articuloVO = new ArticuloVO();		
			
			paramPagIntAlcance.setEstado(SICConstantes.ESTADO_ACTIVO_LITERAL);
			paramAlcanceTP.setEstado(SICConstantes.ESTADO_ACTIVO_LITERAL);
			paramAlcanceIntTod.setEstado(SICConstantes.ESTADO_ACTIVO_LITERAL);
			
			if(esApertura){
				paramAlcanceTP.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_TAREAPROGRAMADA_EJECUCION_APERTURA_LOCAL);//MAX213
				paramAlcanceIntTod.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_INTEGRAR_TODO_APERTURA_LOCAL);//MAX211
				interPag = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.paginacion.alcances.integracion.alcances.es.apertura");
				paramPagIntAlcance.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_PAGINADO_ALCANCES_APERTURA);
				estadoAperturaLocal = SICConstantes.ESTADO_INACTIVO_NUMERICO;
				
			}else{
				paramAlcanceTP.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_TAREAPROGRAMADA_EJECUCION_ALCANCE_LOCAL);//MAX212
				paramAlcanceIntTod.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_INTEGRAR_TODO_ALCANCE_LOCAL);//MAX210
				interPag = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.paginacion.alcances.integracion.alcances");
				paramPagIntAlcance.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_PAGINADO_ALCANCES);
				estadoAperturaLocal = SICConstantes.ESTADO_ACTIVO_NUMERICO;
				
				if(tipoAreatrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA)){
					articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"));
					paramAlcanceTP.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_TAREAPROGRAMADA_EJECUCION_ALCANCE_BODEGA);//MAX216
					paramAlcanceIntTod.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_INTEGRAR_TODO_ALCANCE_BODEGA);//MAX218

				}else if(tipoAreatrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA)){
					articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"));
					paramAlcanceTP.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_TAREAPROGRAMADA_EJECUCION_ALCANCE_OFICINA);//MAX217
					paramAlcanceIntTod.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_INTEGRAR_TODO_ALCANCE_OFICINA);//MAX219

				}
			}
			paramAlcanceTP = dataGestor.findUnique(paramAlcanceTP);
			paramAlcanceIntTod = dataGestor.findUnique(paramAlcanceIntTod);
			
			if(SearchDTO.isLoaded(paramAlcanceTP) && SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(paramAlcanceTP.getValorParametro())){
			
				paramAlcanceTP.setValorParametro(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				dataGestor.update(paramAlcanceTP);
				
				
				articuloVO.setCodigoCompania(codigoCompania);
				articuloVO.setUsuarioAlcance(userId);
				
				ArticuloLocalDTO articuloLocalDTO = paramsStepComunicarSic(articuloVO);
				articuloLocalDTO.setCriteriaSearch(null);
				articuloLocalDTO.setFirstResult(0);
				articuloLocalDTO.setCountAgain(Boolean.FALSE);
				
				if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(estadoAperturaLocal)){
					if(CollectionUtils.isEmpty(articuloLocalDTO.getCriteriaRestrictions())){
						articuloLocalDTO.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
					}
					/**Permite agregar la restriccion de operador OR para comparar si es notificaLocal es (1,null) para que tome los alcances que fueron dados por el SISPE**/
					articuloLocalDTO.getCriteriaRestrictions().add(new RestriccionAperturaLocal(estadoAperturaLocal));
				}else{
					/**En caso de que el alcance tenga el estado de notificarlocal en 0**/
					articuloLocalDTO.setAperturaLocal(estadoAperturaLocal);
				}
				
				articuloLocalDTO.addCriteriaSearchParameter("estadoIntegracionAlcance", ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloLocalDTO.setOrderByField(OrderBy.orderAsc(new String[]{"estadoIntegracionAlcance"}));
				articuloLocalDTO.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoOpcion",ComparatorTypeEnum.IS_NOT_NULL));
				
				
				if(SearchDTO.isLoaded(paramAlcanceIntTod) && SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(paramAlcanceIntTod.getValorParametro())){
					
					Integer  countAlcInt = articuloAlcanceDAO.countAlcancesSinIntegrar(codigoCompania, tipoAreatrabajo, estadoAperturaLocal);
					intervaloForIntegrar = (countAlcInt <= maxPage ? 0 : ( countAlcInt / maxPage) );
					interPag = maxPage;
					
				}else{
					paramPagIntAlcance = dataGestor.findUnique(paramPagIntAlcance);					
					interPag = (SearchDTO.isLoaded(paramPagIntAlcance) ? (Integer.parseInt(paramPagIntAlcance.getValorParametro())) : interPag);
					intervaloForIntegrar = (interPag <= maxPage ? 0 : ( interPag / maxPage) );
				}
				
				this.comunicarSICPaginado(articuloLocalDTO, articuloVO, interPag, intervaloForIntegrar);
				
				paramAlcanceTP.setValorParametro(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				dataGestor.update(paramAlcanceTP);
			}
		} catch (SICException e) {
			throw new SICException("Error cambiarEstadoIntegracion: ",e);
		}
	}
	
	
	private void comunicarSICPaginado(ArticuloLocalDTO articuloLocalDTO, ArticuloVO articuloVO, int interPag, int intervaloForIntegrar ){
		try {
			
			for(int i=0; i <= intervaloForIntegrar; i++){
				articuloLocalDTO.setMaxResults(interPag);
				Collection<ArticuloLocalDTO> articuloLocalCol = dataGestor.findObjectsPaged(articuloLocalDTO).getResults();
				
				if(CollectionUtils.isNotEmpty(articuloLocalCol)){
				Collection<ArticuloLocalDTO> articuloLocalDTOs = new ArrayList<ArticuloLocalDTO>();
				int count=0;
					for(ArticuloLocalDTO artLocalDTO: articuloLocalCol){
						if(count == SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.iteracion.alcances.integracion.alcances")){
							comunicarArticuloLocalSIC(articuloLocalDTOs, articuloVO);
							articuloLocalDTOs.clear();
							count=0;
						}	
						if(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_EMERGENTE.equals(artLocalDTO.getValorTipoAsignacion())){
							if(artLocalDTO.getEstadoArticuloLocal().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
								artLocalDTO.setEstadoArticuloLocal(SICConstantes.VALOR_ACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE);
							}else{
								artLocalDTO.setEstadoArticuloLocal(SICConstantes.VALOR_INACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE);
							}
						}
						
						articuloLocalDTOs.add(artLocalDTO);
						count++;
					}
					if(CollectionUtils.isNotEmpty(articuloLocalDTOs) && articuloLocalDTOs.size() > 0){
						comunicarArticuloLocalSIC(articuloLocalDTOs, articuloVO);
					}
				}
			}
			
		} catch (SICException e) {
			throw new SICException("Error comunicarSICPaginado: ",e);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public void envioMailAlcancesErrorIntegradosSIC(Integer codigoCompania, String tipoAreatrabajo) throws SICException {
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setCodigoCompania(codigoCompania);
		if (tipoAreatrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA)) {
			articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"));
		} else if (tipoAreatrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA)) {
			articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"));
		}
		ArticuloLocalDTO articuloLocalDTO = paramsStepComunicarSic(articuloVO);
		articuloLocalDTO.setCriteriaSearch(null);
		Collection<String> aux = new ArrayList<String>();
		aux.add(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		aux.add(SICConstantes.ESTADO_INACTIVO_NUMERICO);
		articuloLocalDTO.addCriteriaSearchParameter("estadoIntegracionAlcance", ComparatorTypeEnum.NOT_IN_COMPARATOR, aux);
		articuloLocalDTO.setFirstResult(0);
		articuloLocalDTO.setMaxResults(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.iteracion.alcances.integracion.alcances"));
		articuloLocalDTO.setCountAgain(Boolean.FALSE);
		articuloLocalDTO.setOrderByField(OrderBy.orderDesc(new String[] { "fechaActivacion", "fechaInactivacion", "fechaRegistro" }));

		Collection<ArticuloLocalDTO> articuloLocalCol = dataGestor.findObjectsPaged(articuloLocalDTO).getResults();
		Logeable.LOG_SICV2.info("numero de integraciones no realizadas" + articuloLocalCol.size());
		Logeable.LOG_SICV2.info("se envio: " + mensajeria.mensajeConfirmacionIntegracionSIC(articuloLocalCol, tipoAreatrabajo).toString());
	}

	/**
	 * Permite integrar los articulos que estan pendientes por integracion
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param tipoAreatrabajo
	 * @throws SICException
	 */
	@Override
	public void cambiarEstadoIntegracion(Integer codigoCompania, String userId, String tipoAreatrabajo) throws SICException {
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setUsuarioAlcance(userId);
		articuloVO.setCodigoCompania(codigoCompania);
		if (tipoAreatrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA)) {
			articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"));
		} else if (tipoAreatrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA)) {
			articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"));
		}
		obtenerArticuloLocalSIC(articuloVO);

	}

	private ArticuloAlcanceIntegracionTransient removerArticuloLocalPorCodigoBarras(final String codigoBarras, Collection<ArticuloLocalDTO> articuloLocalDTOs) {

		ArticuloLocalDTO articuloLocalDTO = (ArticuloLocalDTO) CollectionUtils.find(articuloLocalDTOs, new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return ((ArticuloLocalDTO) arg0).getArticulo().getCodigoBarras().equals(codigoBarras);
			}
		});

		ArticuloAlcanceIntegracionTransient artAlIntTr;
		artAlIntTr = new ArticuloAlcanceIntegracionTransient();
		artAlIntTr.setCodigoLocal(articuloLocalDTO.getId().getCodigoLocal().toString());
		artAlIntTr.setNombreLocal(articuloLocalDTO.getLocal().getNombreAreaTrabajo());
		artAlIntTr.setCodigoArticulo(articuloLocalDTO.getId().getCodigoArticulo());
		artAlIntTr.setNombreArticulo(articuloLocalDTO.getArticulo().getDescripcionArticulo());
		artAlIntTr.setCodigoPrototipo(SearchDTO.isLoaded(articuloLocalDTO.getArticulo().getGrupoAlcanceDTO()) ? articuloLocalDTO.getArticulo().getGrupoAlcanceDTO().getCodigoReferencia() : null);
		artAlIntTr.setEstadoAlcance(articuloLocalDTO.getEstadoArticuloLocal());
		artAlIntTr.setCodigoArticuloLocal(articuloLocalDTO.getCodigoArticuloLocal().toString());
		articuloLocalDTOs.remove(articuloLocalDTO);

		return artAlIntTr;
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// FIN METODOS DE INTEGRACION CON EL SIC
	// ---------------------------------------------------------------------------------------------------------------------------

	// ---------------------------------------------------------------------------------------------------------------------------
	// INICIO DE METODOS DE ALCANCE PARA LA ADMINISTRACION DE ARTICULOS
	// ---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Permite registrar alcances temporales
	 * 
	 * @param articuloVO
	 * @throws SICException
	 */
	@Override
	public void registrarAlcanceTemporal(ArticuloVO articuloVO) throws SICException {
		try {
			validacionAlcanceGestor.validarRegistrarAlcanceTemporal(articuloVO);
			articuloVO.setFechaAplicacion(new Timestamp(System.currentTimeMillis()));

			String codigoArticulo = null;
			Timestamp fechaAplicacion = null;
			if (CollectionUtils.isNotEmpty(articuloVO.getCodigosArticulos())) {
				codigoArticulo = "'" + StringUtils.join(articuloVO.getCodigosArticulos(), "','") + "'";
			}else {
				fechaAplicacion = articuloVO.getFechaAplicacion();
			}

			Logeable.LOG_SICV2.info("Metodo registrarAlcanceTemporal ");
			Logeable.LOG_SICV2.info("Parametro : ");
			Logeable.LOG_SICV2.info("articuloVO.getCodigoCompania(): " + articuloVO.getCodigoCompania());
			Logeable.LOG_SICV2.info("articuloVO.getCodigoLocalAlcance(): " + articuloVO.getCodigoLocalAlcance());
			Logeable.LOG_SICV2.info("articuloVO.getUserId(): " + articuloVO.getUserId());
			Logeable.LOG_SICV2.info("articuloVO.getAccessItemId(): " + articuloVO.getAccessItemId());
			Logeable.LOG_SICV2.info("articuloVO.getSystemId(): " + articuloVO.getSystemId());
			Logeable.LOG_SICV2.info("articuloVO.getAccessItemId(): " + articuloVO.getAccessItemId());
			Logeable.LOG_SICV2.info("codigoArticulo: " + codigoArticulo);
			Logeable.LOG_SICV2.info("articuloVO.getFechaAplicacion(): " + articuloVO.getFechaAplicacion());

			// permite dar alcances articulolocal
			articuloAlcanceDAO.registrarAlcanceTemporal(articuloVO);
			// Se llama al metodo de actualizar articulo establecimiento
			articuloAlcanceDAO.activarDesactivarArticulosMasivoEstablecimientos(articuloVO.getUserId(), codigoArticulo, fechaAplicacion);
//			// Se llama al metodo de insertar articulo establecimiento
			articuloAlcanceDAO.insertarArticulosMasivoEstablecimientos(articuloVO.getUserId(), codigoArticulo, fechaAplicacion);
			// Se llama al metodo para llenar la bitacora de alcances de locales
			for (String codArt : articuloVO.getCodigosArticulos()) {
				articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(articuloVO.getFechaAplicacion(), null, articuloVO.getCodigoCompania(), codArt);
			}

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al registrarAlcanceTemporal {}", e);
			throw new SICException("Error al registrar alcances temporales {}", e);
		}
	}

	/**
	 * Permite registrar alcance a bodegas padres de una subbodega especifica
	 * 
	 * @param articuloVO
	 * @throws SICException
	 */
	@Override
	@SuppressWarnings("deprecation")
	public void registrarAlcanceBodegasSubbodega(ArticuloVO articuloVO) throws SICException {
		try {
			Collection<AreaSublugarTrabajoDTO> areaSubLugarCol = null;
			Collection<Integer> codigosSubLugarTrabajo = null;
			
			//Obtener la lista de areas de trabajo
			Collection<AreaTrabajoDTO> bodegaCol = SICFactory.getInstancia().articulo.getArticuloAlcanceServicio().obtenerAreasTrabajo();
			Collection<AreaTrabajoDTO> bodegasCompletas = this.obtenerBodegasCompletas(bodegaCol);
			//Obtener el codigo de area sublugar de trabajo del articulo
			Integer codigoAreaSublugarTrabajo = this.articuloAlcanceDAO.obtenerCodigoAreaSublugarTrabajo(articuloVO.getCodigoCompania(), articuloVO.getBaseDTO().getClasificacionDTO().getId().getCodigoClasificacion());
			
			if(codigoAreaSublugarTrabajo != null){
				//Obtenemos las subbodegas asociadas a la clasificacion
				areaSubLugarCol = SICFactory.getInstancia().articulo.getArticuloAlcanceServicio().
						obtenerBodegaPorCodigoSubBodega(articuloVO.getCodigoCompania(), codigoAreaSublugarTrabajo);
				//Obtenemos los codigos CD predeterminados
				if(CollectionUtils.isNotEmpty(areaSubLugarCol)){
					codigosSubLugarTrabajo = new ArrayList<Integer>();
					for(AreaTrabajoDTO areaTrabajoDTO : bodegasCompletas){
						for(AreaSublugarTrabajoDTO areaSublugarTrabajoDTO : areaSubLugarCol){
							if (areaTrabajoDTO.getPoseeAreaTrabajoPadre() && areaTrabajoDTO.getId().getCodigoAreaTrabajo().equals(areaSublugarTrabajoDTO.getId().getCodigoAreaTrabajo())) {
								codigosSubLugarTrabajo.add(areaSublugarTrabajoDTO.getId().getCodigoAreaTrabajo());
							}
						}
					}
				}
			}
			
			validacionAlcanceGestor.validarRegistrarAlcanceBodegaSubbodega(articuloVO);
			articuloVO.setFechaAplicacion(new Timestamp(System.currentTimeMillis() + (long) Math.random() * 100));
			
			if(CollectionUtils.isNotEmpty(codigosSubLugarTrabajo)){
				
//				Collection<String> colCodigoArticulo = new ArrayList<>();
//				colCodigoArticulo.add(articuloVO.getBaseDTO().getId().getCodigoArticulo());
//				ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql = 
//						ArticuloAlcanceNoSqlUtil.getPlantillaAlcanceBodegasSubbodega(articuloVO, codigosSubLugarTrabajo, colCodigoArticulo);
//				this.almacenamientoArticuloAlcanceNoSqlGestor.executeAlcanceArticulos(artAreTraNoSql);
//				colCodigoArticulo = null;
				articuloAlcanceDAO.registrarAlcanceBodegasSubbodega(articuloVO, codigosSubLugarTrabajo);
				// Se llama al metodo para llenar la bitacora de alcances de locales
				articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(articuloVO.getFechaAplicacion(), SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"), articuloVO.getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo());
				
			}
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al registrarAlcanceBodegasSubbodega {}", e);
			throw new SICException("Error al registrar alcances a los CDs predeterminados", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private Collection<AreaTrabajoDTO> obtenerBodegasCompletas(Collection<AreaTrabajoDTO> bodegaCol) {
		Collection<AreaTrabajoDTO> areaTrabajoList = null;
		if (CollectionUtils.isNotEmpty(bodegaCol)) {
			Logeable.LOG_SICV2.info("Tamano de bodegas: {}", bodegaCol.size());
			areaTrabajoList = new ArrayList<AreaTrabajoDTO>();
			// Bodegas padre
			for (AreaTrabajoDTO areaTrabajoPadre : bodegaCol) {
				areaTrabajoPadre.setAreaTrabajoPadreDTO(null);
				areaTrabajoList.add(areaTrabajoPadre);
				if (CollectionUtils.isNotEmpty(areaTrabajoPadre.getAreaLugarTrabajoCol())) {
					Collection<AreaSublugarTrabajoDTO> areaSublugarTrabajoColClone = (Collection<AreaSublugarTrabajoDTO>) SerializationUtils.clone((Serializable) areaTrabajoPadre
							.getAreaLugarTrabajoCol());
					for (AreaSublugarTrabajoDTO subAreaTrabajo : areaSublugarTrabajoColClone) {
						subAreaTrabajo.getSubLugarTrabajoDTO().setAreaTrabajoPadreDTO(areaTrabajoPadre);
						areaTrabajoList.add(subAreaTrabajo.getSubLugarTrabajoDTO());
					}
				}
			}
		}
		return areaTrabajoList;
	}

	/**
	 * Permite asignar alcance del articulo a las areas de trabajo
	 * 
	 * @param articuloVO
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloLocalDTO> asignarArticuloAlcanceAreasTrabajo(ArticuloVO articuloVO) throws SICException {
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  asignarArticuloAlcanceAreasTrabajo(ArticuloVO articuloVO)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		validacionAlcanceGestor.asignarArticuloAlcanceAreasTrabajo(articuloVO);
		articuloVO.setFechaAplicacion(new Timestamp(System.currentTimeMillis()));
		Collection<ArticuloLocalDTO> articuloLocalAfectadosCol = new ArrayList<ArticuloLocalDTO>();
		Collection<ArticuloLocalDTO> articuloLocalCol = new ArrayList<ArticuloLocalDTO>();
		Collection<ArticuloLocalDTO> articuloBodegaCol = new ArrayList<ArticuloLocalDTO>();
		if (articuloVO.getBaseDTOAnterior() == null) { // Si se va a dar alcance
														// por orden de compra
			if (CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloLocalCol())) {
				// Obtenemos la lista de articulo local
				articuloLocalCol = CollectionUtils.select(articuloVO.getBaseDTO().getArticuloLocalCol(), new Predicate() {
					@Override
					public boolean evaluate(Object object) {
						ArticuloLocalDTO articulo = (ArticuloLocalDTO) object;
						return articulo.getTipoAreaTrabajo().equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
					}
				});
				// Seteamos los valores faltantes en los objetos previo al
				// registro
				for (ArticuloLocalDTO articuloLocal : articuloLocalCol) {
					articuloLocal.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					articuloLocal.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				}
				// Obtenemos la lista de articulo bodega
				articuloBodegaCol = CollectionUtils.select(articuloVO.getBaseDTO().getArticuloLocalCol(), new Predicate() {
					@Override
					public boolean evaluate(Object object) {
						ArticuloLocalDTO articulo = (ArticuloLocalDTO) object;
						return articulo.getTipoAreaTrabajo().equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
					}
				});
			}
		} else {// Si se da alcance por articulos
			if (articuloVO.getBaseDTO().getCodigoGrupoAlcance() != null && articuloVO.getBaseDTOAnterior().getCodigoGrupoAlcance() != null && articuloVO.getBaseDTO().getCodigoGrupoAlcance().intValue() != articuloVO.getBaseDTOAnterior().getCodigoGrupoAlcance().intValue()) {
				// Inactivar todos los alcances del articulo
				articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.local"));
				articuloVO.setUsuarioAlcance(articuloVO.getBaseDTO().getUserId());
				articuloAlcanceDAO.remplazarArticulosLocalesMasivo(articuloVO, null, "'".concat(articuloVO.getBaseDTO().getId().getCodigoArticulo()).concat("'"), null, null, null,null);

				// Si se cambia a prototipo personalizado
				if (SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO.equals(articuloVO.getBaseDTO().getCodigoGrupoAlcance())) {
					// Obtener la coleccion de articulos local para dar alcance
					// cuya fecha inicial sea vacia o nula
					articuloLocalCol = CollectionUtils.select(articuloVO.getBaseDTO().getArticuloLocalCol(), PredicateUtils.transformedPredicate(new GetInvokerTransformer("fechaInicialAlcance"), PredicateUtils.notNullPredicate()));
				} else {
					// Obtener la coleccion de articulos local para dar alcance
					articuloLocalCol = articuloVO.getBaseDTO().getArticuloLocalCol();
				}

			} else {
				articuloLocalCol = obtenerArticuloLocalAfectar(articuloVO.getBaseDTOAnterior().getArticuloLocalCol(), articuloVO.getBaseDTO().getArticuloLocalCol());
			}
		}

		// Se valida si existe locales a afectar alcance del articulo
		if (CollectionUtils.isNotEmpty(articuloLocalCol)) {
			articuloAlcanceDAO.asignarArticuloAlcanceLocal(articuloVO, articuloLocalCol);

			/**actualizar prototipo**/
			VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO = new VistaGrupoAlcanceLocalDTO();
			Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs = dataGestor.findObjects(vistaGrupoAlcanceLocalDTO);
			articuloAlcanceDAO.modificarPrototipoAlcance(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(),  articuloVO.getBaseDTO().getUserId(), articuloVO.getFechaAplicacion(), vistaGrupoAlcanceLocalDTOs);
			
			// Se llama al metodo para llenar la bitacora de alcances de locales
			articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(articuloVO.getFechaAplicacion(), null, articuloVO.getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo());

			// Se valida si el articulo no es un cupon para dar alcances a las
			// bodegas de los cds predeterminados
			if (!articuloVO.getBaseDTO().getCodigoTipoArticulo().equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON)) {
				Collection<Integer> codigosLocales = (Collection<Integer>) CollectionUtils.collect(articuloLocalCol, new GetInvokerTransformer("id.codigoLocal"));
				String cadenaCodigoslocales = "'" + StringUtils.join(codigosLocales, "','") + "'";
				// permite verificar el tipo de asignacion, para decidir a que
				// tabla pertenece la consulta puede ser SCSADTARTLOC o
				// SCSADTARTOFI
				String opcionTipoAsignacionAlcance = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.local");

				articuloAlcanceDAO.actualizacionSubbodegas(articuloVO.getUserId(), cadenaCodigoslocales, SICConstantes.ESTADO_ACTIVO_NUMERICO, articuloVO.getFechaAplicacion(), opcionTipoAsignacionAlcance, articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getCodigoCompania());
				articuloAlcanceDAO.actualizacionSubbodegas(articuloVO.getUserId(), cadenaCodigoslocales, SICConstantes.ESTADO_INACTIVO_NUMERICO, articuloVO.getFechaAplicacion(), opcionTipoAsignacionAlcance, articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getCodigoCompania());
			}
			articuloLocalAfectadosCol.addAll(articuloLocalCol);
		}

		// Se valida si existe articulo bodega a registrar
		if (CollectionUtils.isNotEmpty(articuloBodegaCol)) {
			articuloAlcanceDAO.asignarArticuloAlcanceBodega(articuloVO, articuloBodegaCol);
			Collection<Integer> codigosBodegas = (Collection<Integer>) CollectionUtils.collect(articuloBodegaCol, new GetInvokerTransformer("id.codigoLocal"));
			String cadenaCodigosBodega = "'" + StringUtils.join(codigosBodegas, "','") + "'";

			articuloAlcanceDAO.actualizacionSubbodegas(articuloVO.getUserId(), cadenaCodigosBodega, SICConstantes.ESTADO_ACTIVO_NUMERICO, articuloVO.getFechaAplicacion(), SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getCodigoCompania());
			articuloAlcanceDAO.actualizacionSubbodegas(articuloVO.getUserId(), cadenaCodigosBodega, SICConstantes.ESTADO_INACTIVO_NUMERICO, articuloVO.getFechaAplicacion(), SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getCodigoCompania());

			/**actualizar prototipo**/
			VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO = new VistaGrupoAlcanceLocalDTO();
			Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs = dataGestor.findObjects(vistaGrupoAlcanceLocalDTO);
			articuloAlcanceDAO.modificarPrototipoAlcance(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(),  articuloVO.getBaseDTO().getUserId(), articuloVO.getFechaAplicacion(), vistaGrupoAlcanceLocalDTOs);
			
			// Se llama al metodo para llenar la bitacora de alcances de bodegas
			articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(articuloVO.getFechaAplicacion(), SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"), articuloVO.getCodigoCompania(), null);
		}

		return articuloLocalAfectadosCol;
	}

	/**
	 * Permite obtener la lista de articuloBodega o articuloOficina a afectar alcances
	 * 
	 * @param articuloOriginalCol
	 * @param articuloFinalCol
	 * @return
	 */
	private Collection<ArticuloLocalPrecioVO> obtenerArticuloBodegaOficinaAfectar(Collection<ArticuloLocalDTO> articuloOriginalCol, Collection<ArticuloLocalPrecioVO> articuloFinalCol){
		
		Collection<ArticuloLocalPrecioVO> resultado = new ArrayList<ArticuloLocalPrecioVO>();

		// Verificamos si las colecciones no se encuentran vacias
		if (CollectionUtils.isNotEmpty(articuloOriginalCol) && CollectionUtils.isNotEmpty(articuloFinalCol)) {
			for (ArticuloLocalPrecioVO articuloFinal : articuloFinalCol) {
				for (ArticuloLocalDTO articuloOriginal : articuloOriginalCol) {
					if(articuloOriginal.getId().getCodigoLocal().equals(articuloFinal.getArticuloLocal().getId().getCodigoLocal())){						
						if (!articuloOriginal.getEstadoArticuloLocal().equals(articuloFinal.getArticuloLocal().getEstadoArticuloLocal())) {
							resultado.add(articuloFinal);
						}else if(articuloOriginal.getFechaInicialAlcance() == null && articuloFinal.getArticuloLocal().getFechaInicialAlcance() != null){
							resultado.add(articuloFinal);
						}else if(articuloOriginal.getFechaFinalAlcance() == null && articuloFinal.getArticuloLocal().getFechaFinalAlcance() != null){
							resultado.add(articuloFinal);
						}else if(articuloOriginal.getFechaFinalAlcance() != null && articuloFinal.getArticuloLocal().getFechaFinalAlcance() == null){
							resultado.add(articuloFinal);
						}else if(articuloOriginal.getFechaInicialAlcance() != null && articuloFinal.getArticuloLocal().getFechaInicialAlcance() != null && articuloOriginal.getFechaInicialAlcance().compareTo(articuloFinal.getArticuloLocal().getFechaInicialAlcance()) != 0){
							resultado.add(articuloFinal);
						}else if(articuloOriginal.getFechaFinalAlcance() != null && articuloFinal.getArticuloLocal().getFechaFinalAlcance() != null && articuloOriginal.getFechaFinalAlcance().compareTo(articuloFinal.getArticuloLocal().getFechaFinalAlcance()) != 0){
							resultado.add(articuloFinal);
						}else if (articuloOriginal.getLocal().hasDynamicProperty("localPlantilla") && (Boolean)articuloOriginal.getLocal().getDynamicProperty("localPlantilla")
								&& StringUtils.equals(articuloFinal.getArticuloLocal().getEstadoArticuloLocal(), SICConstantes.ESTADO_ACTIVO_NUMERICO)) {
							resultado.add(articuloFinal);
						}
					}
				}
			}
		}
		return resultado;
	}
	
	/**
	 * Permite obtener la lista de articuloLocal a afectar alcances
	 * 
	 * @param articuloLocalOriginalCol
	 * @param articuloLocalFinalCol
	 * @return
	 */
	private Collection<ArticuloLocalDTO> obtenerArticuloLocalAfectar(Collection<ArticuloLocalDTO> articuloLocalOriginalCol, Collection<ArticuloLocalDTO> articuloLocalFinalCol) {
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  obtenerArticuloLocalAfectar(Collection<ArticuloLocalDTO> articuloLocalOriginalCol, Collection<ArticuloLocalDTO> articuloLocalFinalCol)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		Collection<ArticuloLocalDTO> articuloLocalCol = new ArrayList<ArticuloLocalDTO>();

		// Verificamos las colecciones
		if (CollectionUtils.isNotEmpty(articuloLocalOriginalCol) && CollectionUtils.isNotEmpty(articuloLocalFinalCol)) {
			for (ArticuloLocalDTO articuloLocalFinal : articuloLocalFinalCol) {
				// Se itera la coleccion de articulo local original
				for (ArticuloLocalDTO articuloLocalOriginal : articuloLocalOriginalCol) {
					if (articuloLocalOriginal.getId().getCodigoLocal().intValue() == articuloLocalFinal.getId().getCodigoLocal().intValue()) {
						if (!articuloLocalOriginal.getEstadoArticuloLocal().equals(articuloLocalFinal.getEstadoArticuloLocal())) {
							// Agregamos a la lista final
							articuloLocalCol.add(articuloLocalFinal);
						} else if (articuloLocalOriginal.getFechaInicialAlcance() == null && articuloLocalFinal.getFechaInicialAlcance() != null) {
							// Agregamos a la lista final
							articuloLocalCol.add(articuloLocalFinal);
						} else if (articuloLocalOriginal.getFechaFinalAlcance() == null && articuloLocalFinal.getFechaFinalAlcance() != null) {
							// Agregamos a la lista final
							articuloLocalCol.add(articuloLocalFinal);
						} else if (articuloLocalOriginal.getFechaFinalAlcance() != null && articuloLocalFinal.getFechaFinalAlcance() == null) {
							// Agregamos a la lista final
							articuloLocalCol.add(articuloLocalFinal);
						} else if (articuloLocalOriginal.getFechaInicialAlcance() != null && articuloLocalFinal.getFechaInicialAlcance() != null && articuloLocalOriginal.getFechaInicialAlcance().compareTo(articuloLocalFinal.getFechaInicialAlcance()) != 0) {
							// Agregamos a la lista final
							articuloLocalCol.add(articuloLocalFinal);
						} else if (articuloLocalOriginal.getFechaFinalAlcance() != null && articuloLocalFinal.getFechaFinalAlcance() != null && articuloLocalOriginal.getFechaFinalAlcance().compareTo(articuloLocalFinal.getFechaFinalAlcance()) != 0) {
							// Agregamos a la lista final
							articuloLocalCol.add(articuloLocalFinal);
						} else if (articuloLocalFinal.hasDynamicProperty("localPlantilla") && StringUtils.equals(articuloLocalFinal.getEstadoArticuloLocal(), SICConstantes.ESTADO_ACTIVO_NUMERICO)) {
							// Agregamos a la lista final
							articuloLocalCol.add(articuloLocalFinal);
						} else if (!StringUtils.equals(articuloLocalOriginal.getValorTipoAsignacion(), articuloLocalFinal.getValorTipoAsignacion())){
							// Agregamos a la lista final considerando si es diferente el valorTipoAsignacion
							articuloLocalCol.add(articuloLocalFinal);
						}
					}
				}
			}
		}
		return articuloLocalCol;
	}

	/**
	 * Retorna una coleccion de articuloLocal con los CD predeterminados a dar
	 * alcances
	 * 
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<ArticuloLocalDTO> obtenerColeccionCDPredeterminadosAlcances(Integer codigoCompania) throws SICException {
		Collection<ArticuloLocalDTO> articuloLocalCDPRedeterminados = new ArrayList<ArticuloLocalDTO>();
		try {
			ParametroDTO parametroDTO = new ParametroDTO();
			parametroDTO.getId().setCodigoCompania(codigoCompania);
			parametroDTO.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_CDS_PREDETERMINADOS_ALCANCE_BODEGAS);
			parametroDTO = dataGestor.findUnique(parametroDTO);
			String codigosCDPredeterminados = parametroDTO.getValorParametro();
			// Obtenemos los codigos de los cd predeterminados para dar alcance
			if (StringUtils.isNotEmpty(codigosCDPredeterminados)) {
				String[] cdAlcance = codigosCDPredeterminados.split(",");
				for (int i = 0; i < cdAlcance.length; i++) {
					ArticuloLocalDTO articuloLocalCD = new ArticuloLocalDTO();
					articuloLocalCD.getId().setCodigoLocal(Integer.valueOf(cdAlcance[i]));
					articuloLocalCDPRedeterminados.add(articuloLocalCD);
				}
			}
		} catch (SICException e) {
			Logeable.LOG_SICV2.error("Error al obtenerColeccionCDPredeterminados {}", e);
			throw new SICException("Error al obtener la lista de CD predeterminados para la comunicaci\u00F3n al SIC");
		}
		return articuloLocalCDPRedeterminados;
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// FIN DE METODOS DE ALCANCE PARA LA ADMINISTRACION DE ARTICULOS
	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * Permite obtener registros de art&iacute;culo local a partir de los
	 * filtros de b&uacute;squeda de art&iacute;culos
	 * 
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloAlcanceEST> obtenerArticulosLocalAlcance(ArticuloVO articuloLocalVO) throws SICException {
		return articuloDAO.obtenerArticulosLocalAlcance(articuloLocalVO);
	}

	@Override
	public void addCriterioRestriccionFechaAlcanceFinal(SearchDTO searchDTO) {
		if (CollectionUtils.isEmpty(searchDTO.getCriteriaRestrictions())) {
			searchDTO.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
		}
		searchDTO.getCriteriaRestrictions().add(new RestriccionFechaFinal());
	}


	/**
	 * Permite obtener el prototipo que recae en la combinacion de locales que
	 * posee el articulo
	 * 
	 * @param articuloDTO
	 */
	public void obtenerPrototipoAlcance(ArticuloDTO articuloDTO) throws SICException {
		// se verifica si los locales del prototipo personalizado ya estan en
		// otro grupo
		VistaGrupoAlcanceLocalDTO vga = new VistaGrupoAlcanceLocalDTO();
		vga.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
		vga.setAreasTrabajo(agruparLocales(articuloDTO.getArticuloLocalCol()));
		Collection<VistaGrupoAlcanceLocalDTO> col = dataGestor.findObjects(vga);
		if (!col.isEmpty()) {
			articuloDTO.setCodigoGrupoAlcance(col.iterator().next().getId().getCodigoGrupoTrabajo());
		}
	}

	/**
	 * Obtiene los codigos de locales del articulo
	 * 
	 * @param col
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String agruparLocales(Collection<ArticuloLocalDTO> col) {
		Collection<ArticuloLocalDTO> ordCol = ColeccionesUtil.sort(col, ColeccionesUtil.ORDEN_ASC, "id.codigoLocal");
		String locales = "";
		for (ArticuloLocalDTO al : ordCol) {
			locales = locales.concat(",").concat(al.getId().getCodigoLocal().toString());
		}
		// se elimina el primer separador
		return locales.substring(1);
	}

	/**
	 * Permite obtener los alcances de las diferentes tablas de alcances para
	 * generar el archivo de excel
	 * 
	 * @param articuloVO
	 * @param plantillaFiltrosBusquedaMAX
	 * @throws SICException
	 */
	public Collection<ArticuloAlcanceEST> obtenerAlcances(ArticuloVO articuloVO, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX) throws SICException {
		articuloAlcanceCol = new ArrayList<ArticuloAlcanceEST>();
		calculoBusquedaArticuloGestor.incluirRestriccionesBusquedaArticulo(articuloVO, plantillaFiltrosBusquedaMAX);
		// Filtro por articulos codificados
		articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO);

		// Se agrega las relaciones faltantes
		articuloVO.getBaseDTO().setGrupoAlcanceDTO(new GrupoTrabajoDTO());
		articuloVO.getBaseDTO().setArticuloMedidaDTO(new ArticuloMedidaDTO());
		articuloVO.getBaseDTO().setClasificacionDTO(new ClasificacionDTO());
		articuloVO.getBaseDTO().getClasificacionDTO().setBodegaDTO(new BodegaDTO());
		articuloVO.getBaseDTO().setSubClasificacionDTO(new SubClasificacionDTO());

		try {
			// Llamamos al job
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("fechaEjecucion", new JobParameter(new Date()));
			params.put("plantillaReporte", new ExtendedJobParameter(articuloVO.getBaseDTO()));
			JobExecution jobExecution = jobLauncher.run(reporteAlcancesJob, new JobParameters(params));

			if (jobExecution.getExitStatus().equals(ExitStatus.FAILED)) {
				throw new SICException("El trabajo  reporteAlcancesJob ha finalizado con estado: " + ExitStatus.FAILED);
			}

			return articuloAlcanceCol;

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al obtenerAlcances {}", e);
			throw new SICException("Error al obtenerAlcances ", e);
		}
	}

	/**
	 * Agrega a la lista de resultados finales para reportes
	 * 
	 * @param articuloCol
	 */
	public void agregarResultados(List<? extends ArticuloDTO> articuloCol) {
		if (CollectionUtils.isEmpty(articuloAlcanceCol)) {
			articuloAlcanceCol = new ArrayList<ArticuloAlcanceEST>();
		}

		ArticuloAlcanceEST articuloAlcanceEST;
		for (ArticuloDTO articuloDTO : articuloCol) {
			for (ArticuloLocalDTO articuloLocalDTO : articuloDTO.getArticuloLocalCol()) {
				articuloAlcanceEST = new ArticuloAlcanceEST();
				articuloAlcanceEST.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
				articuloAlcanceEST.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
				articuloAlcanceEST.setDescripcionArticulo(articuloDTO.getDescripcionArticulo());
				articuloAlcanceEST.setEstadoArticuloAlcance(articuloLocalDTO.getEstadoArticuloLocal());
				articuloAlcanceEST.setEstadoIntegracionAlcance(articuloLocalDTO.getEstadoIntegracionAlcance());
				articuloAlcanceEST.setCodigoAreaTrabajo(articuloLocalDTO.getId().getCodigoLocal());
				articuloAlcanceEST.setCodigosReferencia(articuloLocalDTO.getLocal().getCodigoReferencia());
				articuloAlcanceEST.setNombreAreaTrabajo(articuloLocalDTO.getLocal().getNombreAreaTrabajo());
				articuloAlcanceEST.setIdUsuarioRegistro(articuloLocalDTO.getIdUsuarioRegistro());
				articuloAlcanceEST.setFechaRegistro(articuloLocalDTO.getFechaRegistro());
				articuloAlcanceEST.setIdUsuarioActivacion(articuloLocalDTO.getIdUsuarioActivacion());
				articuloAlcanceEST.setFechaActivacion(articuloLocalDTO.getFechaActivacion());
				articuloAlcanceEST.setIdUsuarioInactivacion(articuloLocalDTO.getIdUsuarioInactivacion());
				articuloAlcanceEST.setFechaInactivacion(articuloLocalDTO.getFechaInactivacion());
				articuloAlcanceEST.setFechaInicialAlcance(articuloLocalDTO.getFechaInicialAlcance());
				articuloAlcanceEST.setFechaFinalAlcance(articuloLocalDTO.getFechaFinalAlcance());
				articuloAlcanceEST.setCodigoArticuloAreaTrabajo(articuloLocalDTO.getCodigoArticuloLocal());
				articuloAlcanceEST.setCodigoReferenciaPrototipo(articuloDTO.getGrupoAlcanceDTO().getCodigoReferencia());
				articuloAlcanceEST.setArticuloMedidaDTO(new ArticuloMedidaDTO());
				articuloAlcanceEST.setClasificacionDTO(new ClasificacionDTO());
				articuloAlcanceEST.getClasificacionDTO().setBodegaDTO(new BodegaDTO());
				articuloAlcanceEST.setSubClasificacionDTO(new SubClasificacionDTO());
				articuloAlcanceEST.getClasificacionDTO().setDescripcionClasificacion(articuloDTO.getClasificacionDTO().getDescripcionClasificacion());
				articuloAlcanceEST.getClasificacionDTO().getId().setCodigoClasificacion(articuloDTO.getClasificacionDTO().getId().getCodigoClasificacion());
				articuloAlcanceEST.getClasificacionDTO().getBodegaDTO().setDescripcionBodega(articuloDTO.getClasificacionDTO().getBodegaDTO().getDescripcionBodega());
				articuloAlcanceEST.getClasificacionDTO().getBodegaDTO().getId().setCodigoBodega(articuloDTO.getClasificacionDTO().getBodegaDTO().getId().getCodigoBodega());
				articuloAlcanceEST.getSubClasificacionDTO().setDescripcionSubClasificacion(articuloDTO.getSubClasificacionDTO().getDescripcionSubClasificacion());
				articuloAlcanceEST.getSubClasificacionDTO().getId().setCodigoSubClasificacion(articuloDTO.getSubClasificacionDTO().getId().getCodigoSubClasificacion());
				articuloAlcanceEST.getArticuloMedidaDTO().setCantidadMedida(!SearchDTO.isLoaded(articuloDTO.getArticuloMedidaDTO()) ? null : articuloDTO.getArticuloMedidaDTO().getCantidadMedida());
				articuloAlcanceEST.getArticuloMedidaDTO().setValorTipoMedida(!SearchDTO.isLoaded(articuloDTO.getArticuloMedidaDTO()) ? null : articuloDTO.getArticuloMedidaDTO().getValorTipoMedida());
				if (StringUtils.isNotEmpty(articuloDTO.getCodigoBarras())) {
					articuloAlcanceEST.setCodigoBarras(articuloDTO.getCodigoBarras());
				}
				articuloAlcanceEST.setNombreUsuarioRegistro(articuloLocalDTO.getUsuarioRegistro().getUserCompleteName());
				articuloAlcanceEST.setNombreUsuarioActivacion(articuloLocalDTO.getUsuarioActivacion() == null ? null : articuloLocalDTO.getUsuarioActivacion().getUserCompleteName());
				articuloAlcanceEST.setNombreUsuarioInactivacion(articuloLocalDTO.getUsuarioInactivacion() == null ? null : articuloLocalDTO.getUsuarioInactivacion().getUserCompleteName());
				articuloAlcanceEST.setNombreOpcion(articuloLocalDTO.getOpcion() == null ? null : articuloLocalDTO.getOpcion().getAccessItemName());
				articuloAlcanceEST.setCodigoSistema(articuloLocalDTO.getOpcion() == null ? null : articuloLocalDTO.getOpcion().getId().getSystemId());
				articuloAlcanceEST.setTipoAsignacion(articuloLocalDTO.getTipoAsignacion().getNombreCorto());
				articuloAlcanceCol.add(articuloAlcanceEST);
			}
		}
	}

	/**
	 * Permite descargar archivo plantilla para la asignacion masiva
	 */
	@Override
	public void obtenerCabeceraArchivoAsignacionMasiva(HSSFWorkbook wb, HSSFSheet sheet) throws SICException {

		try {
			// creamos la cabecera de la tabla de datos
			HSSFRow rowCabecera = sheet.createRow(0);
			// estilos de la cabecera
			HSSFCellStyle estiloCeldaCabecera = wb.createCellStyle();
			// Bordes para la cabecera
			estiloCeldaCabecera.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloCeldaCabecera.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloCeldaCabecera.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloCeldaCabecera.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloCeldaCabecera.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			estiloCeldaCabecera.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			// Valores de la cabecera
			// Codigo de barras
			HSSFCell cellCabecera = rowCabecera.createCell(0);
			cellCabecera.setCellStyle(estiloCeldaCabecera);
			// cellCabecera.setCellValue(new
			// HSSFRichTextString(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.validacion.cabecera.codigoBarras")));
			cellCabecera.setCellValue(new HSSFRichTextString(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.asignacion.masiva.cabecera.codigoBarras")));
			sheet.autoSizeColumn(0);

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al obtener la cabecera {}", e);
		}
	}

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param tipoAreatrabajo
	 * @throws SICException
	 */
	public void comunicarSicPaginadoSpring(Integer codigoCompania, String userId, String tipoAreatrabajo) throws SICException {
		try {

			ArticuloVO articuloVO = new ArticuloVO();
			// this.articuloVO = articuloVO;
			articuloVO.setCodigoCompania(codigoCompania);
			articuloVO.setUsuarioAlcance(userId);
			if (tipoAreatrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA)) {
				articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"));
			} else if (tipoAreatrabajo.equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA)) {
				articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"));
			}
			ArticuloLocalDTO articuloLocalDTO = paramsStepComunicarSic(articuloVO);
			// Armamos la plantilla
			articuloLocalDTO.setCriteriaSearch(null);
			articuloLocalDTO.setFirstResult(0);
			articuloLocalDTO.setMaxResults(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.alcances.integracion.alcances.spring.tampagina"));
			articuloLocalDTO.setCountAgain(Boolean.FALSE);
			articuloLocalDTO.setOrderByField(OrderBy.orderDesc(new String[] { "fechaActivacion", "fechaInactivacion", "fechaRegistro" }));

			// Llamamos al job
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("pageSize", new JobParameter(new Long(articuloLocalDTO.getMaxResults())));
			params.put("pagesNumber", new JobParameter(new Long(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.alcances.integracion.alcances.spring.numpaginas"))));
			params.put("fechaEjecucion", new JobParameter(new Date()));
			params.put("plantillaReporte", new ExtendedJobParameter(articuloLocalDTO));
			params.put("plantillaParams", new ExtendedJobParameter(articuloVO));
			JobExecution jobExecution = jobLauncher.run(articuloPaginadoJob, new JobParameters(params));

			if (jobExecution.getExitStatus().equals(ExitStatus.FAILED)) {
				throw new SICException("El trabajo  reporteAlcancesJob ha finalizado con estado: " + ExitStatus.FAILED);
			}

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al obtenerPaginado {}", e);
			throw new SICException("Error al obtenerPaginado ", e);
		}
	}

	/**
	 * Permite generar el archivo excel con errores de validacion para la
	 * asignacion masiva de alcance
	 */
	@Override
	public HSSFWorkbook generarExcelErroresAsignacionAlcances(HashMap<String, String> observacionCodigoBarras) {
		HSSFWorkbook wb = null;
		HSSFSheet sheet = null;
		try {
			wb = new HSSFWorkbook();
			sheet = wb.createSheet(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.asignacion.masiva.title.excel.archivo.codigo.barras.observaciones"));
			// creamos la cabecera de la tabla de datos
			this.obtenerCabeceraArchivoValidado(wb, sheet, true);
			// Estilo general para las celdas
			HSSFCellStyle estiloCeldaGeneral = wb.createCellStyle();
			estiloCeldaGeneral.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloCeldaGeneral.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloCeldaGeneral.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloCeldaGeneral.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloCeldaGeneral.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			estiloCeldaGeneral.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			// Estilo error para la celda
			HSSFCellStyle estiloCeldaError = wb.createCellStyle();
			estiloCeldaError.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloCeldaError.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloCeldaError.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloCeldaError.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloCeldaError.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			estiloCeldaError.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			// Estilo error para las observaciones
			HSSFCellStyle estiloCeldaErrorObservacion = wb.createCellStyle();
			estiloCeldaErrorObservacion.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloCeldaErrorObservacion.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloCeldaErrorObservacion.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloCeldaErrorObservacion.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloCeldaErrorObservacion.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			estiloCeldaErrorObservacion.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloCeldaErrorObservacion.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			estiloCeldaErrorObservacion.setFillForegroundColor(HSSFColor.WHITE.index);
			HSSFFont fuenteError = wb.createFont();
			fuenteError.setFontName(HSSFFont.FONT_ARIAL);
			fuenteError.setFontHeightInPoints((short) 10);
			// fuenteError.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			fuenteError.setColor(HSSFColor.RED.index);
			estiloCeldaErrorObservacion.setFont(fuenteError);
			int i = 1;
			for (String codigoBarras : observacionCodigoBarras.keySet()) {
				String observacion = observacionCodigoBarras.get(codigoBarras);
				// Se crea la fila
				HSSFRow row = sheet.createRow((short) (i));
				// Se crean las colummnas
				// CODIGO DE BARRAS
				HSSFCell cellObservacion = row.createCell(0);
				cellObservacion.setCellValue(new HSSFRichTextString(codigoBarras));
				cellObservacion.setCellStyle(StringUtils.isEmpty(observacion) ? estiloCeldaGeneral : estiloCeldaError);
				// OBSERVACION
				cellObservacion = row.createCell(1);
				cellObservacion.setCellValue(new HSSFRichTextString(observacion));
				cellObservacion.setCellStyle(StringUtils.isEmpty(observacion) ? estiloCeldaGeneral : estiloCeldaErrorObservacion);
				sheet.autoSizeColumn(1);
				i++;
			}

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al generr el archivo {}", e);
			throw new SICException("Error al generar el archivo ", e);
		}
		return wb;
	}

	/**
	 * . Permite generar la cabecera del archivo validado para la asignacion
	 * masiva de alcances
	 * 
	 * @param wb
	 * @param sheet
	 * @param observacion
	 * @throws SICException
	 */
	public void obtenerCabeceraArchivoValidado(HSSFWorkbook wb, HSSFSheet sheet, boolean observacion) throws SICException {
		try {
			// creamos la cabecera de la tabla de datos
			HSSFRow rowCabecera = sheet.createRow(0);
			// estilos de la cabecera
			HSSFCellStyle estiloCeldaCabecera = wb.createCellStyle();
			// Bordes para la cabecera
			estiloCeldaCabecera.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloCeldaCabecera.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloCeldaCabecera.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloCeldaCabecera.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloCeldaCabecera.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			estiloCeldaCabecera.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			HSSFFont fuenteCabecera = wb.createFont();
			fuenteCabecera.setFontName(HSSFFont.FONT_ARIAL);
			fuenteCabecera.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			estiloCeldaCabecera.setFont(fuenteCabecera);

			// Valores de la cabecera
			// Codigo de barras
			HSSFCell cellCabecera = rowCabecera.createCell(0);
			cellCabecera = rowCabecera.createCell(0);
			cellCabecera.setCellStyle(estiloCeldaCabecera);
			cellCabecera.setCellValue(new HSSFRichTextString(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.asignacion.masiva.cabecera.codigoBarras")));
			sheet.autoSizeColumn(0);
			// Observaciones
			cellCabecera = rowCabecera.createCell(1);
			cellCabecera.setCellStyle(estiloCeldaCabecera);
			cellCabecera.setCellValue(new HSSFRichTextString(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.asignacion.masiva.cabecera.observacion")));
			sheet.autoSizeColumn(1);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al crear la cabecera del archivo");
		}
	}

	/**
	 * Permite registrar alcance a los locales de un prototipo
	 * 
	 * @param articuloVO
	 */
	public void insertarAlcancePorPrototipo(ArticuloVO articuloVO) throws SICException {
		try {
			//validamos que no venga prototipo nulo
			if(articuloVO.getBaseDTO().getCodigoGrupoAlcance() != null){
				// Se valida la informacion
				validacionAlcanceGestor.insertarAlcancePorPrototipo(articuloVO);
				// Se llama al metodo de registrar alcances
				articuloVO.setFechaAplicacion(new Timestamp(System.currentTimeMillis()));
				articuloAlcanceDAO.insertarAlcancePorPrototipo(articuloVO);
				// Se llama al metodo de registrar en la bitacora
				articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(articuloVO.getFechaAplicacion(), null, articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo());
			}
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al insertarAlcancePorPrototipo {}", e);
			throw new SICException("Ha ocurrido un error al registrar los alcances del prototipo ", e);
		}
	}

	/**
	 * * administracion de prototipos Permite validar si uno de los prototipos
	 * se queda sin locales asignados
	 */
	@Override
	@SuppressWarnings("unused")
	public Collection<String> validarPrototiposLocales(Collection<String> refProt, Collection<Integer> codLoc) throws SICException {

		try {
			Collection<Object[]> protRefCod = articuloAlcanceDAO.validarPrototiposLocales(refProt, codLoc);
			Collection<String> refProtVacios = new ArrayList<String>();

			for (Object[] vecPC : protRefCod) {
				final String codRefP = (String) vecPC[0];

				String cRP = (String) CollectionUtils.find(refProt, new Predicate() {
					@Override
					public boolean evaluate(Object arg0) {
						return ((String) arg0).equals(codRefP);
					}
				});
				refProt.remove(cRP);
			}

			return refProt;

		} catch (Exception e) {
			throw new SICException("Error metodo validarPrototiposLocales ", e);
		}

	}

	/**
	 * Activamos e inactivamos los establecimientos dependiendo de los alcances
	 * 
	 * @param articuloVO
	 * @throws SICException
	 */
	public void activarDesactivarArticulosMasivoEstablecimientos(ArticuloVO articuloVO) throws SICException {
		try {
			// Se valida la informacion
			validacionAlcanceGestor.activarDesactivarArticulosMasivoEstablecimientos(articuloVO);
			// Se llama al metodo de actualizar los establecimientos del
			// articulo
			articuloAlcanceDAO.activarDesactivarArticulosMasivoEstablecimientos(articuloVO.getBaseDTO().getUserId(), "'".concat(articuloVO.getBaseDTO().getId().getCodigoArticulo().concat("'")), null);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al activarDesactivarArticulosMasivoEstablecimientos {}", e);
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.establecimiento"), e);
		}
	}

	/**
	 * Insertamos los establecimientos dependiendo de los alcances
	 * 
	 * @param articuloVO
	 * @throws SICException
	 */
	public void insertarArticulosMasivoEstablecimientos(ArticuloVO articuloVO) throws SICException {
		try {
			// Se valida la informacion
			validacionAlcanceGestor.insertarArticulosMasivoEstablecimientos(articuloVO);
			// Se llama al metodo de actualizar los establecimientos del
			// articulo
			articuloAlcanceDAO.insertarArticulosMasivoEstablecimientos(articuloVO.getBaseDTO().getUserId(), "'".concat(articuloVO.getBaseDTO().getId().getCodigoArticulo().concat("'")), null);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al insertarArticulosMasivoEstablecimientos {}", e);
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.establecimiento"), e);
		}
	}

	/**
	 * Permite activar, desactivar, insertar alcances cuando se ha realizado un
	 * cambio de prototipo
	 * 
	 * @param articuloVO
	 * @throws SICException
	 */
	public void insertarAlcancesCambioPrototipo(ArticuloVO articuloVO) throws SICException {
		validacionAlcanceGestor.insertarAlcancesCambioPrototipo(articuloVO);

		Timestamp fechaAplicacion = new Timestamp(System.currentTimeMillis());
		// Si el prototipo final es personalizado
		if (SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO.equals(articuloVO.getBaseDTO().getCodigoGrupoAlcance())) {
			// Se procede a inactivar los alcances del prototipo anterior
			articuloAlcanceDAO.inactivarAlcancesCambioPrototipo(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getUserId(), fechaAplicacion, articuloVO.getSystemId(), articuloVO.getAccessItemId(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getCodigoGrupoAlcance(), articuloVO.getAreasTrabajoCol());
			// Se procede a activar los alcances del nuevo prototipo
			articuloAlcanceDAO.activarAlcancesCambioPrototipo(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getUserId(), fechaAplicacion, articuloVO.getSystemId(), articuloVO.getAccessItemId(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getCodigoGrupoAlcance(), articuloVO.getAreasTrabajoCol());
			// Se procede a insertar los alcances faltantes del nuevo prototipo
			articuloAlcanceDAO.insertarAlcancesCambioPrototipo(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getUserId(), fechaAplicacion, articuloVO.getSystemId(), articuloVO.getAccessItemId(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getCodigoGrupoAlcance(), articuloVO.getAreasTrabajoCol());
		} else if(articuloVO.getBaseDTO().getCodigoGrupoAlcance() != null){
			// Se procede a inactivar los alcances del prototipo anterior
			articuloAlcanceDAO.inactivarAlcancesCambioPrototipo(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getUserId(), fechaAplicacion, articuloVO.getSystemId(), articuloVO.getAccessItemId(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getCodigoGrupoAlcance(), null);
			// Se procede a activar los alcances del nuevo prototipo
			articuloAlcanceDAO.activarAlcancesCambioPrototipo(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getUserId(), fechaAplicacion, articuloVO.getSystemId(), articuloVO.getAccessItemId(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getCodigoGrupoAlcance(), null);
			// Se procede a insertar los alcances faltantes del nuevo prototipo
			articuloAlcanceDAO.insertarAlcancesCambioPrototipo(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getUserId(), fechaAplicacion, articuloVO.getSystemId(), articuloVO.getAccessItemId(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getCodigoGrupoAlcance(), null);
		}else{
			//inactiva todos los alcances de un articulo
			articuloAlcanceDAO.inactivarAlcancesPrototipo(null, articuloVO.getBaseDTO().getId().getCodigoArticulo(), SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL,
					SICConstantes.ESTADO_ACTIVO_NUMERICO, articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getUserId(), fechaAplicacion, articuloVO.getSystemId(), articuloVO.getAccessItemId());
		}
		
		/**actualizar prototipo**/
		VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO = new VistaGrupoAlcanceLocalDTO();
		Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs = dataGestor.findObjects(vistaGrupoAlcanceLocalDTO);
		articuloAlcanceDAO.modificarPrototipoAlcance(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(),  articuloVO.getBaseDTO().getUserId(), fechaAplicacion, vistaGrupoAlcanceLocalDTOs);
		
		// Se procede a insertar en la bitacora de alcances
		articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajo(fechaAplicacion, null, articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo());
		// Se procede a actualizar los establecimientos del articulo
		articuloAlcanceDAO.activarDesactivarArticulosMasivoEstablecimientos(articuloVO.getBaseDTO().getUserId(), "'".concat(articuloVO.getBaseDTO().getId().getCodigoArticulo().concat("'")), null);
//		// Se procede a insertar los establecimientos del articulo
		articuloAlcanceDAO.insertarArticulosMasivoEstablecimientos(articuloVO.getBaseDTO().getUserId(), "'".concat(articuloVO.getBaseDTO().getId().getCodigoArticulo().concat("'")), null);
	}

	/**
	 * @author corbe permite actualizar datos de asignacion de unidades por
	 *         local
	 */
	public void registrarArticuloLocalPedido(Collection<ArticuloLocalPedidoDTO> articuloLocalPedidoCol) throws SICException {
		try {
			Logeable.LOG_SICV2.info("-------actualizacion de datos de asignacion por local --------");
			// asignando valor de unidad de empaque a cada local
			if (CollectionUtils.isNotEmpty(articuloLocalPedidoCol)) {
				for (ArticuloLocalPedidoDTO articuloLocalPedido : articuloLocalPedidoCol) {
					articuloLocalPedido.setCodigoTipoEmpaque(SICArticuloConstantes.getInstancia().CODIGOTIPOEMPAQUE);
					articuloLocalPedido.setValorTipoEmpaque(SICArticuloConstantes.getInstancia().VALOREMPAQUECAJA);
				}

				articuloRegistroAsignacionLocalDAO.registrarArticuloLocalPedido(articuloLocalPedidoCol);
			}

		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Ocurrio un error en la actualizacion de datos de asignacion por local " + e.getMessage());
			throw new SICException("Ocurrio un error al registrar el art\u00EDculo");
		}
	}

	public Collection<BodegaDTO> obtenerBodegasPorCodigoBodega(Integer codigoCompania, String codigoBodega) throws SICException{
		try {
			return articuloAlcanceDAO.obtenerBodegasPorCodigoBodega(codigoCompania, codigoBodega);			
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar BodegaDTO por el codigoBodega",e);
			throw new  SICException("Error al consultar Bodegas",e);
		}
	}
	
	@Override
	public void asignarAlcancesAreaTrabajo(List<? extends ArticuloDTO> articuloCol,ArticuloVO articuloVO)throws SICException{
		
		try {
			if(CollectionUtils.isNotEmpty(articuloCol)){
				List<ArticuloDTO> artCol = new ArrayList<ArticuloDTO>();
				for(ArticuloDTO articuDto : articuloCol){
					artCol.add(articuDto);					
					articuloAlcanceDAO.asignarQuitarRemplazarMasivaArticulosLocales(artCol, articuloVO);
					artCol.clear();
				}
			}
		} catch (SICException e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Metodo que permite consultar las oficinas para la asignacion de articulos
	 * 
	 */
	public Collection<AreaTrabajoDTO> consultarOficinas(String tipoAreaTrabajo, Integer codigoCompania) throws SICException{
		return articuloAlcanceDAO.consultarOficinas(tipoAreaTrabajo, codigoCompania);
	} 
	
	/**
	 * Metodo que permite consultar las areas de trabajo en las que el articulo tiene alcance
	 * 
	 */
	public Collection<ArticuloLocalDTO> consultarAreasTrabajoAsignadas(ArticuloDTO articuloDto, String tipoAreaTrabajo, Boolean validarEstado)throws SICException{
		return articuloAlcanceDAO.consultarAreasTrabajoAsignadas(articuloDto, tipoAreaTrabajo, validarEstado);
	}
	
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajo()throws SICException{
		return articuloAlcanceDAO.obtenerAreasTrabajo();	
	}
	
	public Collection<ArticuloLocalDTO> obtenerBodegasParaCentroDistribucion(ArticuloDTO articuloDto, String tipoAreaTrabajo)throws SICException{
		return articuloAlcanceDAO.obtenerBodegasParaCentroDistribucion(articuloDto, tipoAreaTrabajo);
	}
	
	public Collection<AreaSublugarTrabajoDTO> obtenerCentrosDeDistribucionConEstados(Set<Integer> codigosBodegas)throws SICException{
		return articuloAlcanceDAO.obtenerCentrosDeDistribucionConEstados(codigosBodegas);
	}
	
	/**
	 * Metodo que permite consultar las bodegas para la asignacion de articulos
	 * 
	 */
	public Collection<AreaTrabajoDTO> consultarBodegas(String tipoAreaTrabajo, Integer codigoCompania) throws SICException{
		return articuloAlcanceDAO.consultarBodegas(tipoAreaTrabajo, codigoCompania);
	}
	
	/**
	 * Metodo que permite asignar alcance a oficinas o bodegas
	 * 
	 */
	public void registrarAlcanceAreasTrabajoArticulo(ArticuloVO articuloVO)throws SICException{
		try{
			Logeable.LOG_SICV2.info("-------asignando alcance a areas de trabajo --------");
			if(CollectionUtils.isNotEmpty(articuloVO.getLocales())){
				Collection<ArticuloLocalPrecioVO> bodegas = null;
				Collection<ArticuloLocalPrecioVO> oficinas = null;
				
				List<ArticuloDTO> articuloDTOs = new ArrayList<ArticuloDTO>();
				articuloDTOs.add(articuloVO.getBaseDTO());
				articuloVO.setUsuarioAlcance(articuloVO.getUserId());
				//articuloVO.setFechaAplicacion(new Timestamp(System.currentTimeMillis()));
				
				bodegas = CollectionUtils.select(articuloVO.getLocales(), new Predicate() {
					@Override
					public boolean evaluate(Object object) {
						ArticuloLocalPrecioVO articuloLocalPrecioVO = (ArticuloLocalPrecioVO) object;
						return articuloLocalPrecioVO.getArticuloLocal().getTipoAreaTrabajo().equals(SICConstantes.getInstancia().SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
					}
				});
				oficinas = CollectionUtils.select(articuloVO.getLocales(), new Predicate() {
					@Override
					public boolean evaluate(Object object) {
						ArticuloLocalPrecioVO articuloLocalPrecioVO = (ArticuloLocalPrecioVO) object;
						return articuloLocalPrecioVO.getArticuloLocal().getTipoAreaTrabajo().equals(SICConstantes.getInstancia().SUFIJO_TIPO_AREA_TRABAJO_OFICINA);
					}
				});
				
				if(CollectionUtils.isNotEmpty(oficinas)){
					//Se registra el alcance de oficinas
					articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"));
					this.activaDesactivarAlcancesArticulo(oficinas, articuloVO, articuloDTOs, Boolean.TRUE);
				}
				if(CollectionUtils.isNotEmpty(bodegas)){
					//Se registra el alcance de bodegas
					articuloVO.setOpcionTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"));
					this.activaDesactivarAlcancesArticulo(bodegas, articuloVO, articuloDTOs, Boolean.FALSE);
				}
				articuloVO.getLocales().clear();
			}
		}catch(SICException e){
			Logeable.LOG_SICV2.info("Error al registrar las areas de trabajo por articulo"+e.getMessage());
			throw new SICException("Error al registrar el art\u00EDculo a una \u00E1rea de trabajo");
		}
	}
	
	/***
	 * Permite Activar e Inactivar las bodegas y oficinas asignadas al articulo
	 * @param articuloAlcanceCol
	 * @param articuloVO
	 * @param articuloDTOs
	 * @throws SICException
	 */
	private void activaDesactivarAlcancesArticulo(Collection<ArticuloLocalPrecioVO> articuloAlcanceCol, ArticuloVO articuloVO, List<ArticuloDTO> articuloDTOs, Boolean esOficina)
		throws SICException {
		try{
			if(CollectionUtils.isNotEmpty(articuloAlcanceCol)){
				List<Long> codigosLocal = new ArrayList<Long>();
				Collection<ArticuloLocalPrecioVO> locales = new ArrayList<ArticuloLocalPrecioVO>();
				Collection<ArticuloLocalPrecioVO> listaModificada = new ArrayList<ArticuloLocalPrecioVO>();
				
				articuloAlcanceCol = CollectionUtils.select(articuloAlcanceCol, new Predicate() {
					@Override
					public boolean evaluate(Object object) {
						return ((ArticuloLocalPrecioVO)object).hasDynamicProperty("activar");
					}
				});
				
				// Obtiene las oficinas o bodegas que se han modificado
				if(BooleanUtils.isTrue(esOficina)){
					listaModificada = this.obtenerArticuloBodegaOficinaAfectar(articuloVO.getBaseDTOAnterior().getArticuloOficinaCol(), articuloAlcanceCol);
				}else{
					//validacion para cambio a nueva clasificacion
					if(CollectionUtils.isEmpty(articuloVO.getBaseDTOAnterior().getArticuloBodegaCol())){
						listaModificada = articuloAlcanceCol;
					}else{
						//se valida que cual bodega se modifico en pantalla
						listaModificada = this.obtenerArticuloBodegaOficinaAfectar(articuloVO.getBaseDTOAnterior().getArticuloBodegaCol(), articuloAlcanceCol);						
					}
				}
				
				for(ArticuloLocalPrecioVO artLocPrecioVO: listaModificada){
					locales.clear();
					codigosLocal.clear();
					locales.add(artLocPrecioVO);
					codigosLocal.add(artLocPrecioVO.getArticuloLocal().getCodigoArticuloLocal());
					
					articuloVO.setFechaAplicacion(new Timestamp(System.currentTimeMillis()));
					articuloVO.setOpcionAlcance((Boolean)artLocPrecioVO.getDynamicProperty("activar") ? 
							SICConstantes.getInstancia().ALCANCE_OPCION_ANADIR : SICConstantes.getInstancia().ALCANCE_OPCION_QUITAR);
					articuloVO.setCodigosArticuloAreaTrabajo(codigosLocal);
					articuloVO.setFechaInicioAlcance(artLocPrecioVO.getArticuloLocal().getFechaInicialAlcance());
					articuloVO.setFechaFinAlcance(artLocPrecioVO.getArticuloLocal().getFechaFinalAlcance());
					articuloVO.setLocales(locales);
					
					//Se activa o desactiva el area de trabajo afectada
					this.articuloAlcanceDAO.asignarQuitarRemplazarMasivaArticulosLocales(articuloDTOs, articuloVO);
				}
			}
		}catch(SICException e){
			Logeable.LOG_SICV2.info("Error en la asignacion de areas de trabajo por articulo"+e.getMessage());
			throw new SICException("Error al asignar el art\u00EDculo a una \u00E1rea de trabajo");
		}
	}
	
	public Collection<AreaSublugarTrabajoDTO> obtenerBodegaPorCodigoSubBodega(Integer codigoCompania, Integer codigoSubBod){
		return articuloAlcanceDAO.obtenerBodegaPorCodigoSubBodega(codigoCompania, codigoSubBod);
	}
	
	@Override
	public Collection<EstablecimientoDTO> obtenerEstablecimientos(Integer codigoCompania) throws SICException {
		return articuloAlcanceDAO.obtenerEstablecimientos(codigoCompania) ;
	}
	
	public Collection<GrupoTrabajoDTO> obtenerGruposTrabajo(GrupoTrabajoVO grupoTrabajoVO) throws SICException{
		return articuloAlcanceDAO.obtenerGruposTrabajo(grupoTrabajoVO);
	}
	
	public Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerArticuloAreaTrabajoBitacoraError(ArticuloVO articuloVO, String sufijoAreaTrabajo) throws SICException{
		return articuloAlcanceDAO.obtenerArticuloAreaTrabajoBitacoraError(articuloVO, sufijoAreaTrabajo);
	}
	
	public void insertarBitacoraArticuloAreaTrabajoError(ArticuloVO articuloVO, String codigoArticulo, String errorMsg) throws SICException{
		this.articuloAlcanceDAO.insertarBitacoraArticuloAreaTrabajoError(articuloVO, codigoArticulo, errorMsg);
	}
	
	/**
	 * Setters
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setArticuloAlcanceDAO(IArticuloAlcanceDAO articuloAlcanceDAO) {
		this.articuloAlcanceDAO = articuloAlcanceDAO;
	}

	public void setValidacionAlcanceGestor(IValidacionAlcanceGestor validacionAlcanceGestor) {
		this.validacionAlcanceGestor = validacionAlcanceGestor;
	}

	/**
	 * @param asignacionMasivaArticulosJob
	 *            the asignacionMasivaArticulosJob to set
	 */
	public void setAsignacionMasivaArticulosJob(Job asignacionMasivaArticulosJob) {
		this.asignacionMasivaArticulosJob = asignacionMasivaArticulosJob;
	}

	/**
	 * @param articulosArchivoAlcanceJob
	 *            the articulosArchivoAlcanceJob to set
	 */
	public void setArticulosArchivoAlcanceJob(Job articulosArchivoAlcanceJob) {
		this.articulosArchivoAlcanceJob = articulosArchivoAlcanceJob;
	}

	/**
	 * @param asignacionMasivaArticulosActualizarPrototipoJob
	 *            the asignacionMasivaArticulosActualizarPrototipoJob to set
	 */
//	public void setAsignacionMasivaArticulosActualizarPrototipoJob(Job asignacionMasivaArticulosActualizarPrototipoJob) {
//		this.asignacionMasivaArticulosActualizarPrototipoJob = asignacionMasivaArticulosActualizarPrototipoJob;
//	}

	/**
	 * @param comunicarArticuloAlcanceJob
	 *            the comunicarArticuloAlcanceJob to set
	 */
	public void setComunicarArticuloAlcanceJob(Job comunicarArticuloAlcanceJob) {
		this.comunicarArticuloAlcanceJob = comunicarArticuloAlcanceJob;
	}

	/**
	 * @param actualizarPrototipoComunicarSICJob
	 *            the actualizarPrototipoComunicarSICJob to set
	 */
	public void setActualizarPrototipoComunicarSICJob(Job actualizarPrototipoComunicarSICJob) {
		this.actualizarPrototipoComunicarSICJob = actualizarPrototipoComunicarSICJob;
	}

	/**
	 * @param jobLauncher
	 *            the jobLauncher to set
	 */
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	/**
	 * @param articuloDAO
	 *            the articuloDAO to set
	 */
	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	public void setMensajeria(IEnvioMailGestor mensajeria) {
		this.mensajeria = mensajeria;
	}

	/**
	 * @param calculoBusquedaArticuloGestor
	 *            the calculoBusquedaArticuloGestor to set
	 */
	public void setCalculoBusquedaArticuloGestor(ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor) {
		this.calculoBusquedaArticuloGestor = calculoBusquedaArticuloGestor;
	}

	/**
	 * @return the articuloAlcanceCol
	 */
	public Collection<ArticuloAlcanceEST> getArticuloAlcanceCol() {
		return articuloAlcanceCol;
	}

	/**
	 * @param articuloAlcanceCol
	 *            the articuloAlcanceCol to set
	 */
	public void setArticuloAlcanceCol(Collection<ArticuloAlcanceEST> articuloAlcanceCol) {
		this.articuloAlcanceCol = articuloAlcanceCol;
	}

	/**
	 * @param reporteAlcancesJob
	 *            the reporteAlcancesJob to set
	 */
	public void setReporteAlcancesJob(Job reporteAlcancesJob) {
		this.reporteAlcancesJob = reporteAlcancesJob;
	}

	public void setGenerarArchivoErrorTxtJob(Job generarArchivoErrorTxtJob) {
		this.generarArchivoErrorTxtJob = generarArchivoErrorTxtJob;
	}

	public void setAlcanceBatchUtilGestor(IAlcanceBatchUtilGestor alcanceBatchUtilGestor) {
		this.alcanceBatchUtilGestor = alcanceBatchUtilGestor;
	}

	public void setArticuloPaginadoJob(Job articuloPaginadoJob) {
		this.articuloPaginadoJob = articuloPaginadoJob;
	}

	/**
	 * @return the artResulArchiv
	 */
	public Collection<ArticuloDTO> getArtResulArchiv() {
		return artResulArchiv;
	}

	/**
	 * @param artResulArchiv
	 *            the artResulArchiv to set
	 */
	public void setArtResulArchiv(Collection<ArticuloDTO> artResulArchiv) {
		this.artResulArchiv = artResulArchiv;
	}

	/**
	 * @param articuloRegistroAsignacionLocalDAO the articuloRegistroAsignacionLocalDAO to set
	 */
	public void setArticuloRegistroAsignacionLocalDAO(IArticuloRegistroAsignacionLocalDAO articuloRegistroAsignacionLocalDAO) {
		this.articuloRegistroAsignacionLocalDAO = articuloRegistroAsignacionLocalDAO;
	}

	/**
	 * 
	 * @param almacenamientoArticuloAlcanceNoSqlGestor
	 */
	public void setAlmacenamientoArticuloAlcanceNoSqlGestor(IAlmacenamientoArticuloAlcanceNoSqlGestor almacenamientoArticuloAlcanceNoSqlGestor) {
		this.almacenamientoArticuloAlcanceNoSqlGestor = almacenamientoArticuloAlcanceNoSqlGestor;
	}
	
}

@SuppressWarnings("serial")
class Restriccion implements CriteriaRestriction {
	private Timestamp fechaAplicacionOR;

	public Restriccion(Timestamp fechaAplicacionOR) {
		this.fechaAplicacionOR = fechaAplicacionOR;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.eq("fechaRegistro", fechaAplicacionOR));
		disjunction.add(Restrictions.eq("fechaActivacion", fechaAplicacionOR));
		disjunction.add(Restrictions.eq("fechaInactivacion", fechaAplicacionOR));
		return disjunction;
	}
}

@SuppressWarnings("serial")
class RestriccionFechaFinal implements CriteriaRestriction {

	@Override
	public Criterion getCriteriaRestriction() {
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.gt("fechaFinalAlcance", ConverterUtil.getCurrentTruncDate()));
		disjunction.add(Restrictions.isNull("fechaFinalAlcance"));
		return disjunction;
	}
}
/**
SELECT * FROM SCSADTARTLOC
WHERE ESTADOINTEGRACIONALCANCE = '0'
AND ((APERTURALOCAL != 0
AND VALORTIPOASIGNACION != 'EME')OR
 VALORTIPOASIGNACION = 'EME')
 * @author jmontenegro
 *
 */

@SuppressWarnings("serial")
class RestriccionAperturaLocal implements CriteriaRestriction {
	private String estadoAperturaLocal;

	public RestriccionAperturaLocal(String estadoAperturaLocal) {
		this.estadoAperturaLocal = estadoAperturaLocal;
	}
	@Override
	public Criterion getCriteriaRestriction() {
		Conjunction conjunction = Restrictions.conjunction();
		conjunction.add(Restrictions.eq("aperturaLocal", this.estadoAperturaLocal));
		conjunction.add(Restrictions.ne("valorTipoAsignacion", CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_EMERGENTE));
		
		
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.eq("valorTipoAsignacion", CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_EMERGENTE));
		disjunction.add(conjunction);
		return disjunction;
	}
}

