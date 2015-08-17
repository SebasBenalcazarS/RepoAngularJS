/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.regsan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;

import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.loggin.resources.LogUtilMessages;
import ec.com.smx.corpv2.vo.FuncionarioVO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.generadorexportacion.dto.EnvioDTO;
import ec.com.smx.generadorexportacion.dto.id.FormatoID;
import ec.com.smx.generadorexportacion.exception.GeneradorExportacionException;
import ec.com.smx.generadorexportacion.listener.GeneracionExportacionListener;
import ec.com.smx.generadorexportacion.util.GeneradorExportacionService;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.articulo.gestor.archivo.ArticuloArchivoGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.articulo.EnumFormatoImpresionRegSan;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloValidacion;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.proveedor.OrigenProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.accion.IAccionArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.regsan.IArticuloRegistroSanitarioGestor;
import ec.com.smx.sic.cliente.gestor.articulo.regsan.validacion.IValidacionRegSanGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloInformacionNutricionalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.BitacoraRevisionRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ComponenteNutricionalDTO;
import ec.com.smx.sic.cliente.mdl.dto.FormulaComponenteRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ImpresionRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroSanitarioDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author fmunoz
 * 
 */

public class ArticuloRegistroSanitarioGestor implements IArticuloRegistroSanitarioGestor, Logeable {

	private DataGestor dataGestor;
	private IParametroGestor parametroGestor;
	private ArticuloArchivoGestor articuloArchivoGestor;
	private IArticuloRegistroSanitarioDAO articuloRegistroSanitarioDAO;
	private IAccionArticuloGestor accionArticuloGestor;
	private IValidacionRegSanGestor validacionRegSanGestor;

	/**
	 * 
	 */
	public void registrarDatosNutricionalesDesdeArticulo(ArticuloVO articuloVO) throws SICException {
		if (articuloVO.getBaseDTO().getTieneRegistroSanitario()) {
			// solamente se procesan los registros sanitarios activos
			for (RelacionArticuloRegistroSanitarioDTO dto : articuloVO.getBaseDTO().getRegistroSanitarioCol()) {
				dto.setUserId(articuloVO.getBaseDTO().getUserId());
				if (SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(dto.getEstado())) {
					dto.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					dto.getRegistroSanitario().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					dto.setTransferirDatosSIC(Boolean.FALSE);
					if (TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO.equals(dto.getRegistroSanitario().getValorTipoEstudioNutricional())) {
						registrarRegistroSanitarioArticulo(dto);
						if(articuloVO.getDynamicProperty("esCreacion") != null && BooleanUtils.isNotTrue((Boolean) articuloVO.getDynamicProperty("esCreacion")) && articuloVO.getArticuloProveedorDTO() != null){//Validacion para el registro de informacion en B2B
							asignarConfirmaRegistroSanitarioArticuloProveedor(dto.getId().getCodigoCompania(), dto.getId().getCodigoArticulo(), dto.getUserId());
							articuloVO.getArticuloProveedorDTO().setEsConfirmadoRegistroSanitario(Boolean.TRUE);
						}
					} else if (TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_ANALISIS_BROMATOLOGICO.equals(dto.getRegistroSanitario().getValorTipoEstudioNutricional())) {
						registrarAnalisisBromatologico(dto, articuloVO.getBaseDTO().getId().getCodigoCompania());
					}
				} else {
					articuloRegistroSanitarioDAO.desactivarRegistroSanitarioArticulo(dto);
					// articuloRegistroSanitarioDAO.desactivarArchivosRegistroSanitario(dto,
					// articuloVO.getBaseDTO().getUserId());
				}
			}
		} else if ( !getAplicaRegistroSanitario(articuloVO.getBaseDTO()) ){
			RelacionArticuloRegistroSanitarioDTO ars = new RelacionArticuloRegistroSanitarioDTO();
			ars.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			ars.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			ars.setUserId(articuloVO.getBaseDTO().getUserId());
			ars.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
			ars.getRegistroSanitario().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			ars.getRegistroSanitario().setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO);
			articuloRegistroSanitarioDAO.desactivarRegistroSanitarioArticulo(ars);
			// articuloRegistroSanitarioDAO.desactivarArchivosRegistroSanitario(ars,
			// articuloVO.getBaseDTO().getUserId());
		}
	}

	
	/**
	 * METODO QUE PERMITE AGREGA EL VALOR DE TRUE EN EL CAMPO CONFIRMAREGISTROSANITARIO EN LA TABLA {@linkArticuloProveedorDTO}
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param idUsuarioModificacion
	 */
	private void asignarConfirmaRegistroSanitarioArticuloProveedor(Integer codigoCompania, String codigoArticulo, String idUsuarioModificacion) {
		if(codigoCompania != null && StringUtils.isNotBlank(codigoArticulo) && StringUtils.isNotBlank(idUsuarioModificacion)){
			
			articuloRegistroSanitarioDAO.asignarConfirmaRegistroSanitarioArticuloProveedor(codigoCompania, codigoArticulo, idUsuarioModificacion);
			
		}else{
			if(codigoCompania == null){
				throw new SICException("El codigoCompania no puede ser nulo en asignarConfirmaRegistroSanitarioArticuloProveedor");
			}
			if(codigoArticulo == null || StringUtils.isBlank(codigoArticulo)){
				throw new SICException("El codigoArticulo no puede ser nulo en asignarConfirmaRegistroSanitarioArticuloProveedor");
			}
			if(idUsuarioModificacion == null || StringUtils.isBlank(idUsuarioModificacion)){
				throw new SICException("El idUsuarioModificacion no puede ser nulo en asignarConfirmaRegistroSanitarioArticuloProveedor");
			}
		}
	}
	
	/**
	 * Este proceso solamente actualiza el valor del registro sanitario
	 * 
	 * @param articuloRegistroSanitarioDTOCol
	 * @throws SICException
	 */
	public void actualizarArticuloRegistroSanitarioCol(Collection<RelacionArticuloRegistroSanitarioDTO> articuloRegistroSanitarioDTOCol) throws SICException {
		if (articuloRegistroSanitarioDTOCol != null) {
			RelacionArticuloRegistroSanitarioDTO filtro = new RelacionArticuloRegistroSanitarioDTO();
			for (RelacionArticuloRegistroSanitarioDTO ars : articuloRegistroSanitarioDTOCol) {
				filtro.getId().setCodigoCompania(ars.getId().getCodigoCompania());
				filtro.getId().setCodigoArticulo(ars.getId().getCodigoArticulo());
				filtro.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				filtro.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
				filtro.getRegistroSanitario().setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				// se realiza la consulta por codigo de articulo
				Collection<RelacionArticuloRegistroSanitarioDTO> registros = dataGestor.findObjects(filtro);

				for (RelacionArticuloRegistroSanitarioDTO regActual : registros) {
					if (!StringUtils.isEmpty(ars.getRegistroSanitario().getRegistroSanitario())) {
						regActual.getRegistroSanitario().setRegistroSanitario(ars.getRegistroSanitario().getRegistroSanitario().trim());
						asignarValoresOmision(regActual.getRegistroSanitario());
						// se actualiza en la base
						dataGestor.update(regActual.getRegistroSanitario());
					}
				}
			}
		}
	}

	public void registrarRegistroSanitarioArticulo(Collection<RelacionArticuloRegistroSanitarioDTO> artRegSanCol) throws SICException {
		Collection<ArticuloVO> articulos = new ArrayList<ArticuloVO>();
		for (RelacionArticuloRegistroSanitarioDTO ars : artRegSanCol) {
			ars.setTransferirDatosSIC(Boolean.FALSE); // para que NO se envie
														// articulo por articulo
			registrarRegistroSanitarioArticulo(ars);
			articulos.add(new ArticuloVO(ars.getArticulo()));
		}
		// se envia el total
		accionArticuloGestor.transferirDatosArticuloSIC(articulos, Boolean.FALSE, null);
	}

	/**
	 * Este proceso Verifica si es necesario crear una nuevo registro sanitario
	 * debido a la modificacion del valor, o solamente actualizar ciertos datos
	 * 
	 * @param ars
	 */
	public void registrarRegistroSanitarioArticulo(RelacionArticuloRegistroSanitarioDTO ars) throws SICException {
		ArticuloDTO artActual = null;
		ArticuloDTO respaldoArticulo = null;
		ArticuloRegistroSanitarioDTO arsActual = null;
		ArticuloRegistroSanitarioDTO respaldoRegSan = null;
		// se respaldan las relaciones
		Boolean esCreacion = Boolean.FALSE;
		try {
			validacionRegSanGestor.validarAsignacionesRegistroSanitario(ars);
			respaldoArticulo = ars.getArticulo();
			respaldoRegSan = ars.getRegistroSanitario();
			respaldoRegSan.getId().setCodigoCompania(ars.getId().getCodigoCompania());
			respaldoRegSan.setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO);
			Boolean aplicaRegistroSanitario = getAplicaRegistroSanitario(ars.getArticulo());
			// se anula las relaciones antes de los registros
			ars.setArticulo(null);
			ars.setRegistroSanitario(null);

			if (StringUtils.isNotEmpty(respaldoRegSan.getId().getCodigoRegistroSanitario())) {
				// es un registro existente
				arsActual = new ArticuloRegistroSanitarioDTO();
				arsActual.getId().setCodigoCompania(ars.getId().getCodigoCompania());
				arsActual.getId().setCodigoRegistroSanitario(respaldoRegSan.getId().getCodigoRegistroSanitario());
				ArticuloDefinicionArchivoDTO adf = new ArticuloDefinicionArchivoDTO();
				adf.setArticuloArchivo(new ArticuloArchivoDTO());
				arsActual.setArtDefArcCol(new ArrayList<ArticuloDefinicionArchivoDTO>());
				arsActual.getArtDefArcCol().add(adf);
				arsActual.setBitRevRegSanCol(new HashSet<BitacoraRevisionRegistroSanitarioDTO>());
				arsActual.getBitRevRegSanCol().add(new BitacoraRevisionRegistroSanitarioDTO());
				Collection<ArticuloRegistroSanitarioDTO> col = dataGestor.findObjects(arsActual);
				if (!col.isEmpty()) {
					arsActual = col.iterator().next();
					if (crearNuevoRegistroSanitario(respaldoRegSan, arsActual)) {
						// primero se desactiva el regsan-articulo actual
						ars.getId().setCodigoRegistroSanitario(arsActual.getId().getCodigoRegistroSanitario());
						ars.setRegistroSanitario(respaldoRegSan);
						articuloRegistroSanitarioDAO.desactivarRegistroSanitarioArticulo(ars);
						ars.setRegistroSanitario(null);
						// se desactivan los archivos del registro sanitario actual y se actualizan sus datos de auditoria
						// articuloRegistroSanitarioDAO.desactivarArchivosRegistroSanitario(arsActual, ars.getUserId());
						// articuloRegistroSanitarioDAO.actualizarDatosAuditoria(arsActual);

						// se actualiza la numeracion sin espacios en blanco
						respaldoRegSan.setRegistroSanitario(respaldoRegSan.getRegistroSanitario().trim());
						respaldoRegSan.setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						// se anula el codigo secuencial y los datos de auditoria antes del registro
						respaldoRegSan.getId().setCodigoRegistroSanitario(null);
						respaldoRegSan.setFechaRegistro(new Date());
						respaldoRegSan.setUsuarioRegistro(ars.getUserId());
						respaldoRegSan.setFechaModificacion(null);
						respaldoRegSan.setUsuarioModificacion(null);
						asignarValoresOmision(respaldoRegSan);
						// se crea el nuevo registro sanitario
						dataGestor.create(respaldoRegSan);

						// se crea el registro de union
						ars.getId().setCodigoRegistroSanitario(respaldoRegSan.getId().getCodigoRegistroSanitario());
						ars.setFechaRegistro(null);
						ars.setIdUsuarioRegistro(ars.getUserId());
						ars.setFechaModificacion(null);
						ars.setIdUsuarioModificacion(null);
						dataGestor.create(ars);

						aplicaRegistroSanitario = Boolean.TRUE;
						esCreacion = Boolean.TRUE;

						// se verifica si el registro sanitario actual tiene archivos adjuntos
						if (arsActual.getTieneArticuloDefinicionArchivo()) {
							if (!respaldoRegSan.getTieneArticuloDefinicionArchivo()) {
								respaldoRegSan.setArtDefArcCol(new ArrayList<ArticuloDefinicionArchivoDTO>());
							}
							Collection<ArticuloDefinicionArchivoDTO> adfCol = new ArrayList<ArticuloDefinicionArchivoDTO>();
							for (final ArticuloDefinicionArchivoDTO dto : arsActual.getArtDefArcCol()) {
								if (!CollectionUtils.exists(respaldoRegSan.getArtDefArcCol(), new Predicate() {
									@Override
									public boolean evaluate(Object object) {
										return StringUtils.equals(dto.getValorTipoArchivo(), ((ArticuloDefinicionArchivoDTO) object).getValorTipoArchivo());
									}
								})) {
									adfCol.add(dto);
								}
							}
							respaldoRegSan.getArtDefArcCol().addAll(adfCol);
						}
					} else {
						if (!aplicaRegistroSanitario) {
							String secuencial = ars.getId().getCodigoRegistroSanitario();
							ars.getId().setCodigoRegistroSanitario(null); // se anula el secuencial para que en los siguientes metodos no se tome en cuenta para la actualizacion

							// primero se desactivan todos los registros sanitarios del articulo
							ars.setRegistroSanitario(respaldoRegSan);
							articuloRegistroSanitarioDAO.desactivarRegistroSanitarioArticulo(ars);
							ars.setRegistroSanitario(null);
							// se desactivan los archivos del registro sanitario actual y se actualizan sus datos de auditoria
							// articuloRegistroSanitarioDAO.desactivarArchivosRegistroSanitario(ars, ars.getUserId());
							ars.getId().setCodigoRegistroSanitario(secuencial); // se restituye el valor
						} else {
							respaldoRegSan.setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							respaldoRegSan.setUserId(ars.getUserId());
							asignarValoresOmision(respaldoRegSan);
							dataGestor.update(respaldoRegSan);

							if (!StringUtils.equals(ars.getId().getCodigoRegistroSanitario(), respaldoRegSan.getId().getCodigoRegistroSanitario())) {
								if (StringUtils.isNotEmpty(ars.getId().getCodigoRegistroSanitario())) {
									ars.setRegistroSanitario(respaldoRegSan);
									articuloRegistroSanitarioDAO.desactivarRegistroSanitarioArticulo(ars);
									ars.setRegistroSanitario(null);
								}
								ars.getId().setCodigoRegistroSanitario(respaldoRegSan.getId().getCodigoRegistroSanitario());
								ars.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								ars.setIdUsuarioRegistro(ars.getUserId());
								ars.setFechaRegistro(null);
								ars.setFechaModificacion(null);
								ars.setIdUsuarioModificacion(null);
								dataGestor.createOrUpdate(ars);
							} else {
								ars.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								dataGestor.update(ars);
							}
						}
					}
				}
				col = null;
			} else {
				respaldoRegSan.addDynamicProperty(SICConstantes.EVENTO_INSERTAR, Boolean.TRUE);
				// se crea el nuevo registro sanitario o se actualiza
				respaldoRegSan.setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				respaldoRegSan.setUserId(ars.getUserId());
				asignarValoresOmision(respaldoRegSan);
				dataGestor.create(respaldoRegSan);

				ars.getId().setCodigoRegistroSanitario(respaldoRegSan.getId().getCodigoRegistroSanitario());
				dataGestor.create(ars);
				aplicaRegistroSanitario = Boolean.TRUE;
				esCreacion = Boolean.TRUE;
			}

			// se registra la informacion nutricional
			if (SearchDTO.isLoaded(respaldoRegSan.getInformacionNutricionalCol())) {
				for (ArticuloInformacionNutricionalDTO inf : respaldoRegSan.getInformacionNutricionalCol()) {
					inf.setUserId(ars.getUserId());
					inf.getId().setCodigoCompania(respaldoRegSan.getId().getCodigoCompania());
					inf.getId().setCodigoRegistroSanitario(respaldoRegSan.getId().getCodigoRegistroSanitario());
					if (esCreacion) {
						inf.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(inf);
					} else {
						dataGestor.createOrUpdate(inf);
					}
				}
			}

			// se verifica si es necesario registrar una bitacora
			if (respaldoRegSan.getEstadoRegistroSanitario().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && respaldoRegSan.getTieneBitRevRegSan()) {
				if (arsActual != null && arsActual.getTieneBitRevRegSan()) {
					BitacoraRevisionRegistroSanitarioDTO bit = arsActual.getBitRevRegSan();
					bit.setFechaFinRevision(new Timestamp(System.currentTimeMillis()));
					dataGestor.update(bit);
				}

				BitacoraRevisionRegistroSanitarioDTO revision = new BitacoraRevisionRegistroSanitarioDTO();
				if (StringUtils.isEmpty(respaldoRegSan.getBitRevRegSanCol().iterator().next().getCodigoProveedor())) {
					// se consulta el proveedor del articulo
					ArticuloProveedorDTO ap = new ArticuloProveedorDTO();
					ap.getId().setCodigoCompania(ars.getId().getCodigoCompania());
					ap.getId().setCodigoArticulo(ars.getId().getCodigoArticulo());
					ap.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					ap.setProveedor(new ProveedorDTO());
					ap.setOrderByField(OrderBy.orderAsc("fechaRegistro"));
					Collection<ArticuloProveedorDTO> aps = dataGestor.findObjects(ap);
					if (CollectionUtils.isNotEmpty(aps)) {
						ap = (ArticuloProveedorDTO) CollectionUtils.find(aps, new Predicate() {
							@Override
							public boolean evaluate(Object object) {
								return OrigenProveedor.IMPORTADO.getValue().equals(((ArticuloProveedorDTO) object).getProveedor().getOrigenProveedor());
							}
						});

						revision.setCodigoProveedor(ap == null ? aps.iterator().next().getId().getCodigoProveedor() : ap.getId().getCodigoProveedor());
					}
				} else {
					revision.setCodigoProveedor(respaldoRegSan.getBitRevRegSanCol().iterator().next().getCodigoProveedor());
				}

				if (StringUtils.isNotEmpty(revision.getCodigoProveedor())) {
					revision.getId().setCodigoCompania(ars.getId().getCodigoCompania());
					// revision.setCodigoArticulo(ars.getId().getCodigoArticulo());
					revision.setCodigoRegistroSanitario(ars.getId().getCodigoRegistroSanitario());
					revision.setUserId(ars.getUserId());
					revision.setFechaInicioRevision(new Timestamp(System.currentTimeMillis()));
					revision.setFechaFinRevision(null);
					revision.setEstadoRevisionTC(TipoCatalogoArticulo.TIPOESTADO_REVISIONREGISTROSANITARIO_INTERNO);
					revision.setEstadoRevision(respaldoRegSan.getBitRevRegSanCol().iterator().next().getEstadoRevision());
					dataGestor.create(revision);
				}
			}

			// se registran los archivos del registro sanitario
			if (respaldoRegSan.getEstadoRegistroSanitario().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && respaldoRegSan.getTieneArticuloDefinicionArchivo()) {
				for (ArticuloDefinicionArchivoDTO ada : respaldoRegSan.getArtDefArcCol()) {
					if (SICArticuloValidacion.getInstancia().esArchivoRegistroSanitario(ada.getValorTipoArchivo())) {
						if (esCreacion) {
							ada.getId().setCodigoArchivo(null);
						}
						ada.setCodigoRegistroSanitarioArticulo(respaldoRegSan.getId().getCodigoRegistroSanitario());
						ada.getId().setCodigoCompania(ars.getId().getCodigoCompania());
						ada.setUserId(ars.getUserId());
						articuloArchivoGestor.registrarArticuloArchivo(ada);
					}
				}
			}

			// se consulta el articulo actual
			artActual = new ArticuloDTO();
			artActual.getId().setCodigoCompania(ars.getId().getCodigoCompania());
			artActual.getId().setCodigoArticulo(ars.getId().getCodigoArticulo());
			Collection<ArticuloDTO> artCol = dataGestor.findObjects(artActual);
			if (!artCol.isEmpty()) {
				artActual = artCol.iterator().next();
				artActual.setCodigoRegistroSanitario(aplicaRegistroSanitario ? respaldoRegSan.getRegistroSanitario() : null);
				if(aplicaRegistroSanitario){
					artActual.setCodigoAplicaRegistroSanitario(TipoCatalogoArticulo.TIPO_ESTADO_APLICA_REGISTRO_SANITARIO);
					artActual.setValorAplicaRegistroSanitario(TipoCatalogoArticulo.VALOR_APLICA_REGISTRO_SANITARIO);
				}
				
				artActual.setUserId(ars.getUserId());
				if (getAplicaRegistroSanitario(artActual)) {
					artActual.setEsComercializado(Boolean.TRUE);
					artActual.setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				}
				dataGestor.update(artActual);
				artActual.setCodigoBarrasActivo(respaldoArticulo.getCodigoBarrasActivo());
				artActual.setRegistroSanitarioCol(new ArrayList<RelacionArticuloRegistroSanitarioDTO>());
				artActual.getRegistroSanitarioCol().add(ars);

				// se actualiza tambien el respaldo del articulo
				respaldoArticulo.setCodigoRegistroSanitario(artActual.getCodigoRegistroSanitario());
				respaldoArticulo.setCodigoAplicaRegistroSanitario(artActual.getCodigoAplicaRegistroSanitario());
				respaldoArticulo.setValorAplicaRegistroSanitario(artActual.getValorAplicaRegistroSanitario());
				respaldoArticulo.setEsComercializado(artActual.getEsComercializado());
				respaldoArticulo.setEstadoArticulo(artActual.getEstadoArticulo());

				if (ars.getTransferirDatosSIC()) {
					// se realiza la integracion
					accionArticuloGestor.transferirDatosArticuloSIC(new ArticuloVO(artActual), Boolean.FALSE, null);
				}
			}

			artCol = null;
		} catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.registrosanitario"), e);
		} finally {
			arsActual = null;
			ars.setArticulo(respaldoArticulo);
			ars.setRegistroSanitario(respaldoRegSan);
		}
	}
	
	/**
	 * get aplica registro sanitario
	 */
	//private Bo

	/**
	 * 
	 * @param ars
	 */
	public void registrarAnalisisBromatologico(RelacionArticuloRegistroSanitarioDTO ars,Integer codigoCompania) throws SICException {
		Boolean esCreacion = Boolean.FALSE;
		try {
			ars.getRegistroSanitario().setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_ANALISIS_BROMATOLOGICO);
			asignarValoresOmision(ars.getRegistroSanitario());
			// se consulta el parametro de la cantidad referencial para medir la concetracion
			if(ars.getRegistroSanitario().getValorTamanioPorcion() == null){
				ParametroDTO parametroDTO = new ParametroDTO();
				parametroDTO.getId().setCodigoCompania(codigoCompania);
				parametroDTO.getId().setCodigoParametro(SICParametros.getInstancia().CANTIDAD_REFERENCIAL_MEDICION_CONCETRACION_NUTRICIONAL);
				ars.getRegistroSanitario().setValorTamanioPorcion(Double.valueOf(dataGestor.findUnique(parametroDTO).getValorParametro()));
			}
			ars.getRegistroSanitario().setCodigoUnidadTamanioporcion(TipoCatalogoArticulo.TIPO_UNIDAD_MASA);
			ars.getRegistroSanitario().setValorUnidadTamanioporcion(TipoCatalogoArticulo.UNIDAD_MEDIDA_GRAMO);
			ars.getRegistroSanitario().setUserId(ars.getUserId());
			ars.getRegistroSanitario().getId().setCodigoCompania(ars.getId().getCodigoCompania());
			if (StringUtils.isEmpty(ars.getRegistroSanitario().getId().getCodigoRegistroSanitario())) {
				esCreacion = Boolean.TRUE;
				// se crea el maestro
				ars.getRegistroSanitario().addDynamicProperty(SICConstantes.EVENTO_INSERTAR, Boolean.TRUE);
				ars.getRegistroSanitario().setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				dataGestor.create(ars.getRegistroSanitario());
				// se crea el detalle
				ars.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				ars.getId().setCodigoRegistroSanitario(ars.getRegistroSanitario().getId().getCodigoRegistroSanitario());
				dataGestor.create(ars);
			} else {
				dataGestor.update(ars.getRegistroSanitario());
				dataGestor.update(ars);
			}

			// se registra la informacion nutricional
			if (SearchDTO.isLoaded(ars.getRegistroSanitario().getInformacionNutricionalCol())) {
				for (ArticuloInformacionNutricionalDTO inf : ars.getRegistroSanitario().getInformacionNutricionalCol()) {
					inf.setUserId(ars.getUserId());
					inf.getId().setCodigoCompania(ars.getRegistroSanitario().getId().getCodigoCompania());
					inf.getId().setCodigoRegistroSanitario(ars.getRegistroSanitario().getId().getCodigoRegistroSanitario());
					if (esCreacion) {
						inf.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						dataGestor.create(inf);
					} else {
						dataGestor.createOrUpdate(inf);
					}
				}
			}
		} catch (Exception e) {
			if (esCreacion) {
				ars.getRegistroSanitario().getId().setCodigoRegistroSanitario(null);
				ars.getId().setCodigoRegistroSanitario(null);
			}
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.analisisBromatologico"), e);
		}
	}

	/**
	 * 
	 * @param ars
	 */
	private void asignarValoresOmision(ArticuloRegistroSanitarioDTO ars) {
		if (ars.getEstadoImpresionEtiquetas() == null) {
			ars.setEstadoImpresionEtiquetas(Boolean.TRUE);
		}
		if (ars.getCoincidenIngredientesConProveedor() == null) {
			ars.setCoincidenIngredientesConProveedor(Boolean.FALSE);
		}
		if (ars.getTieneImpresoRegistroSanitarioEnEnvase() == null) {
			ars.setTieneImpresoRegistroSanitarioEnEnvase(Boolean.FALSE);
		}
		if (StringUtils.isEmpty(ars.getSistemaOrigen())) {
			ars.setSistemaOrigen(SICConstantes.CODIGO_SISTEMA_MAX);
		}
		if (StringUtils.isEmpty(ars.getEstadoRegistroSanitario())) {
			ars.setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
		if (StringUtils.isEmpty(ars.getDescripcionArticulo())) {
			ars.setDescripcionArticulo(SICConstantes.VALOR_NOASIGNADO);
		}

		if(ars.getEstaValidado() == null){
			ars.setEstaValidado(Boolean.TRUE);
		}

		if (ars.getCodigoTipoEstudioNutricional() == null) {
			ars.setCodigoTipoEstudioNutricional(TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL);
			if (StringUtils.isEmpty(ars.getValorTipoEstudioNutricional())) {
				ars.setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO);
			}
		}
	}

	private Boolean crearNuevoRegistroSanitario(ArticuloRegistroSanitarioDTO nuevo, ArticuloRegistroSanitarioDTO actual) {
		return !StringUtils.equalsIgnoreCase(nuevo.getRegistroSanitario().trim(), actual.getRegistroSanitario().trim()) || (nuevo.getFechaCaducidadRegistroSanitario() != null && actual.getFechaCaducidadRegistroSanitario() == null)
				|| (nuevo.getFechaCaducidadRegistroSanitario() != null && actual.getFechaCaducidadRegistroSanitario() != null && !DateUtils.isSameInstant(nuevo.getFechaCaducidadRegistroSanitario(), actual.getFechaCaducidadRegistroSanitario()));
	}

	/**
	 * 
	 * @param bitRevRegSanCol
	 * @return
	 */
	public void crearBitacoraRevisionRegistroSanitario(Collection<BitacoraRevisionRegistroSanitarioDTO> bitRevRegSanCol) throws SICException {
		Collection<ArticuloDTO> artCol = new ArrayList<ArticuloDTO>();
		for (BitacoraRevisionRegistroSanitarioDTO brrs : bitRevRegSanCol) {
			this.crearBitacoraRevisionRegistroSanitario(brrs, artCol);
		}
		// se realiza la integracion con el SIC para cambiar la clase de
		// articulo
		// SICIntegracion.modificarClaseArticulo(artCol,
		// SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.noObsoletoNoResurtible"));
		artCol = null;
	}

	/**
	 * 
	 * @param brrs
	 * @return
	 */
	private void crearBitacoraRevisionRegistroSanitario(BitacoraRevisionRegistroSanitarioDTO brrs, Collection<ArticuloDTO> artCol) throws SICException {
		try {
			if (brrs.getEstadoRevisionTC() == null) {
				brrs.setEstadoRevisionTC(TipoCatalogoArticulo.TIPOESTADO_REVISIONREGISTROSANITARIO_IMPORTADO);
			}
			dataGestor.create(brrs);
			if (brrs.getEstadoRevision().equals(SICConstantes.ESTADO_INVALIDO)) {
				// se desactiva el registro del articulo en la tabla principal
				// del articulo y en el registro sanitario
				RelacionArticuloRegistroSanitarioDTO regsanFiltro = new RelacionArticuloRegistroSanitarioDTO();
				regsanFiltro.getId().setCodigoCompania(brrs.getId().getCodigoCompania());
				regsanFiltro.getId().setCodigoRegistroSanitario(brrs.getCodigoRegistroSanitario());
				regsanFiltro.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				regsanFiltro.setArticulo(new ArticuloDTO());
				regsanFiltro.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
				Collection<RelacionArticuloRegistroSanitarioDTO> registros = dataGestor.findObjects(regsanFiltro);

				for (RelacionArticuloRegistroSanitarioDTO dto : registros) {
					dto.getArticulo().setClaseArticulo(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.noObsoletoNoResurtible"));
					dto.getArticulo().setFechaUltimaActualizacion(new Timestamp(System.currentTimeMillis()));
					dto.getArticulo().setUsuarioActualizacion(brrs.getUserId());
					dataGestor.update(dto.getArticulo());

					dto.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					dto.setUserId(brrs.getUserId());
					dataGestor.update(dto);

					if (SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(dto.getRegistroSanitario().getEstadoRegistroSanitario())) {
						dto.getRegistroSanitario().setEstadoRegistroSanitario(SICConstantes.ESTADO_INACTIVO_NUMERICO);
						dto.getRegistroSanitario().setUserId(brrs.getUserId());
						asignarValoresOmision(dto.getRegistroSanitario());
						dataGestor.update(dto.getRegistroSanitario());
					}

					artCol.add(dto.getArticulo());
				}
				regsanFiltro = null;
			}
		} catch (SICException e) {
			throw e;
		} catch (Exception e) {
			throw new SICException(e);
		}
	}

	/**
	 * Asigna los niveles de concentraci&oacute;n a las pantallas
	 * 
	 * @param registros
	 */
	public Map<String, Integer> asignarNivelesConcentracionSemaforo(Collection<RelacionArticuloRegistroSanitarioDTO> registros) throws SICException {
		try {
			String unidadReferencial = TipoCatalogoArticulo.UNIDAD_MEDIDA_GRAMO;
			Double cantidadGrasa = 0d;
			Double cantidadAzucar = 0d;
			Double cantidadSal = 0d;

			Double grasaMayorGramo = 0d;
			Double grasaMayorMililitro = 0d;
			Double azucarMayorGramo = 0d;
			Double azucarMayorMililitro = 0d;
			Double salMayorGramo = 0d;
			Double salMayorMililitro = 0d;

			Map<String, Integer> nivelesConcetracion = new LinkedHashMap<String, Integer>();
			// se consulta la formula de configuracion
			FormulaComponenteRegistroSanitarioDTO filtro = new FormulaComponenteRegistroSanitarioDTO();
			filtro.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			filtro.setComponenteNutricionalDTO(new ComponenteNutricionalDTO());
			Collection<FormulaComponenteRegistroSanitarioDTO> configuraciones = dataGestor.findObjects(filtro);

			if (SearchDTO.isLoaded(registros)) {
				for (RelacionArticuloRegistroSanitarioDTO dto : registros) {
					cantidadGrasa = 0d;
					cantidadAzucar = 0d;
					cantidadSal = 0d;
					// se obtiene la informacion nutricional de cada registro
					// sanitario
					if (SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(dto.getEstado()) && TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_ANALISIS_BROMATOLOGICO.equals(dto.getRegistroSanitario().getValorTipoEstudioNutricional())) {
						if (dto.getRegistroSanitario().getTieneInformacionNutricional()) {
							for (ArticuloInformacionNutricionalDTO inf : dto.getRegistroSanitario().getInformacionNutricionalCol()) {
								if (TipoCatalogoArticulo.CODIGO_NUTRICIONAL_GRASA.intValue() == inf.getId().getCodigoComponenteNutricional().intValue()) {
									cantidadGrasa = inf.getValorCantidad().doubleValue();
									if (inf.getValorDensidad() != null && inf.getValorDensidad() > 0 && cantidadGrasa > 0) {
										unidadReferencial = TipoCatalogoArticulo.UNIDAD_MEDIDA_MILILITRO;
										// se realiza la transformacion en base a la densidad
//										cantidadGrasa = ((dto.getRegistroSanitario().getValorTamanioPorcion() / inf.getValorDensidad()) * dto.getRegistroSanitario().getValorTamanioPorcion()) / inf.getValorCantidad();
										cantidadGrasa = cantidadGrasa * inf.getValorDensidad();
									}

								} else if (TipoCatalogoArticulo.CODIGO_NUTRICIONAL_AZUCAR.intValue() == inf.getId().getCodigoComponenteNutricional().intValue()) {
									cantidadAzucar = inf.getValorCantidad().doubleValue();
									if (inf.getValorDensidad() != null && inf.getValorDensidad() > 0 && cantidadAzucar > 0) {
										unidadReferencial = TipoCatalogoArticulo.UNIDAD_MEDIDA_MILILITRO;
										// se realiza la transformacion en base a la densidad
//										cantidadAzucar = ((dto.getRegistroSanitario().getValorTamanioPorcion() / inf.getValorDensidad()) * dto.getRegistroSanitario().getValorTamanioPorcion()) / inf.getValorCantidad();
										cantidadAzucar = cantidadAzucar * inf.getValorDensidad();
									}
								} else if (TipoCatalogoArticulo.CODIGO_NUTRICIONAL_SAL.intValue() == inf.getId().getCodigoComponenteNutricional().intValue()) {
									cantidadSal = inf.getValorCantidad().doubleValue();
									if (inf.getValorDensidad() != null && inf.getValorDensidad() > 0 && cantidadSal > 0) {
										unidadReferencial = TipoCatalogoArticulo.UNIDAD_MEDIDA_MILILITRO;
										// se realiza la transformacion en base a la densidad
//										cantidadSal = ((dto.getRegistroSanitario().getValorTamanioPorcion() / inf.getValorDensidad()) * dto.getRegistroSanitario().getValorTamanioPorcion()) / inf.getValorCantidad();
										cantidadSal = cantidadSal * inf.getValorDensidad();
									}
								}
							}
						}

						if (cantidadGrasa > 0 || cantidadAzucar > 0 || cantidadSal > 0) {
							if (TipoCatalogoArticulo.UNIDAD_MEDIDA_GRAMO.equals(unidadReferencial)) {
								if (cantidadGrasa > grasaMayorGramo) {
									grasaMayorGramo = cantidadGrasa;
								}
								if (cantidadAzucar > azucarMayorGramo) {
									azucarMayorGramo = cantidadAzucar;
								}
								if (cantidadSal > salMayorGramo) {
									salMayorGramo = cantidadSal;
								}
							} else {
								if (cantidadGrasa > grasaMayorMililitro) {
									grasaMayorMililitro = cantidadGrasa;
								}
								if (cantidadAzucar > azucarMayorMililitro) {
									azucarMayorMililitro = cantidadAzucar;
								}
								if (cantidadSal > salMayorMililitro) {
									salMayorMililitro = cantidadSal;
								}
							}
						}
					}
				}
			}

			String[] valorA1 = obtenerNivelConcentracion(TipoCatalogoArticulo.CODIGO_NUTRICIONAL_AZUCAR, TipoCatalogoArticulo.UNIDAD_MEDIDA_GRAMO, azucarMayorGramo, configuraciones);
			String[] valorA2 = obtenerNivelConcentracion(TipoCatalogoArticulo.CODIGO_NUTRICIONAL_AZUCAR, TipoCatalogoArticulo.UNIDAD_MEDIDA_MILILITRO, azucarMayorMililitro, configuraciones);
			Integer nivelA = Integer.valueOf(valorA1[1]) > Integer.valueOf(valorA2[1]) ? Integer.valueOf(valorA1[1]) : Integer.valueOf(valorA2[1]);
			
			String[] valorG1 = obtenerNivelConcentracion(TipoCatalogoArticulo.CODIGO_NUTRICIONAL_GRASA, TipoCatalogoArticulo.UNIDAD_MEDIDA_GRAMO, grasaMayorGramo, configuraciones);
			String[] valorG2 = obtenerNivelConcentracion(TipoCatalogoArticulo.CODIGO_NUTRICIONAL_GRASA, TipoCatalogoArticulo.UNIDAD_MEDIDA_MILILITRO, grasaMayorMililitro, configuraciones);
			Integer nivelG = Integer.valueOf(valorG1[1]) > Integer.valueOf(valorG2[1]) ? Integer.valueOf(valorG1[1]) : Integer.valueOf(valorG2[1]);

			String[] valorS1 = obtenerNivelConcentracion(TipoCatalogoArticulo.CODIGO_NUTRICIONAL_SAL, TipoCatalogoArticulo.UNIDAD_MEDIDA_GRAMO, salMayorGramo, configuraciones);
			String[] valorS2 = obtenerNivelConcentracion(TipoCatalogoArticulo.CODIGO_NUTRICIONAL_SAL, TipoCatalogoArticulo.UNIDAD_MEDIDA_MILILITRO, salMayorMililitro, configuraciones);
			Integer nivelS = Integer.valueOf(valorS1[1]) > Integer.valueOf(valorS2[1]) ? Integer.valueOf(valorS1[1]) : Integer.valueOf(valorS2[1]);
			
			nivelesConcetracion.put(valorA1[0], nivelA);
			nivelesConcetracion.put(valorG1[0], nivelG);
			nivelesConcetracion.put(valorS1[0], nivelS);
			
			if((nivelA.intValue() > 0 || nivelG.intValue() > 0 || nivelS.intValue() > 0) 
					&& nivelA.intValue() != nivelG.intValue() && nivelA.intValue() != nivelS.intValue() && nivelG.intValue() != nivelS.intValue()){
				List<Integer> values = new ArrayList<Integer>(nivelesConcetracion.values());
				Map<String, Integer> nivelesConcetracion2 = new LinkedHashMap<String, Integer>();
				Collections.sort(values);
				for(int i = values.size()-1 ; i>=0; i--){
					for(String cla : nivelesConcetracion.keySet()){
						if(nivelesConcetracion.get(cla).intValue() == values.get(i).intValue()){
							nivelesConcetracion2.put(cla, values.get(i));
							break;
						}
					}
				}
				return nivelesConcetracion2;
			}
			return nivelesConcetracion;
		} catch (SICException e) {
			throw e;
		} catch (Exception e) {
			throw new SICException(e);
		}
	}

	private String[] obtenerNivelConcentracion(final Integer codigoAgrupadorNutricional, String unidadReferencial, Double cantidadNutricional, Collection<FormulaComponenteRegistroSanitarioDTO> configuraciones) {
		String[] nivelesConcentracion = null;
		
		if(cantidadNutricional > 0){
			for (FormulaComponenteRegistroSanitarioDTO formula : configuraciones) {
				if (unidadReferencial.equals(formula.getValorTipoMedidaReferencia()) && codigoAgrupadorNutricional.intValue() == formula.getCodAgrComNut().intValue()) {
					if (formula.getValorMinimoRango() == null && formula.getValorMaximoRango() != null && 
							((formula.getIncluirValorMaximo() && cantidadNutricional <= formula.getValorMaximoRango()) || (!formula.getIncluirValorMaximo() && cantidadNutricional < formula.getValorMaximoRango()))) {
						return new String[] { formula.getComponenteNutricionalDTO().getNombre(), formula.getValorNivelConcentracion() };
					} else if (formula.getValorMinimoRango() != null && formula.getValorMaximoRango() != null && 
							(((formula.getIncluirValorMaximo() && cantidadNutricional <= formula.getValorMaximoRango()) || (!formula.getIncluirValorMaximo() && cantidadNutricional < formula.getValorMaximoRango())) &&
							((formula.getIncluirValorMinimo() && cantidadNutricional >= formula.getValorMinimoRango()) || (!formula.getIncluirValorMinimo() && cantidadNutricional > formula.getValorMinimoRango())))) {
						return new String[] { formula.getComponenteNutricionalDTO().getNombre(), formula.getValorNivelConcentracion() };
					} else if (formula.getValorMinimoRango() != null  && formula.getValorMaximoRango() == null && 
							((formula.getIncluirValorMinimo() && cantidadNutricional >= formula.getValorMinimoRango()) || (!formula.getIncluirValorMinimo() && cantidadNutricional > formula.getValorMinimoRango()))) {
						return new String[] { formula.getComponenteNutricionalDTO().getNombre(), formula.getValorNivelConcentracion() };
					}
				}
			}
		}else{
			FormulaComponenteRegistroSanitarioDTO formula = (FormulaComponenteRegistroSanitarioDTO)CollectionUtils.find(configuraciones, new Predicate() {
				public boolean evaluate(Object object) {
					return ((FormulaComponenteRegistroSanitarioDTO)object).getCodAgrComNut().intValue() == codigoAgrupadorNutricional.intValue();
				}
			});
			return new String[] { formula.getComponenteNutricionalDTO().getNombre(), "0"};
		}

		return nivelesConcentracion;
	}
	private final static String LEYENDA_CONTIENE_COMP_TRANS = "CONTIENE COMPONENTES TRANSGENICOS";
	private final static String LEYENDA_NO_CONTIENE_COMP_TRANS = "NO CONTIENE COMPONENTES TRANSGENICOS";

	public void generarArchivoImpresion(RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO, UserDto userDto, EnumFormatoImpresionRegSan enumFormatoImpresionRegSan, String remoteHost, FuncionarioVO funcionarioVO) throws SICException {
		if (relacionArticuloRegistroSanitarioDTO.getTieneRegistroSanitario() && relacionArticuloRegistroSanitarioDTO.getTieneArticulo()) {
			// se crea el objeto de impresion que va a dar origen al archivo
			// plano de texto
			ImpresionRegistroSanitarioDTO impresionRegistroSanitarioDTO = new ImpresionRegistroSanitarioDTO();
			//formateador de numeros
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			simbolos.setGroupingSeparator(',');
			NumberFormat nf = new DecimalFormat("#0.00",simbolos);
			
			// GENERAL
			ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO = relacionArticuloRegistroSanitarioDTO.getRegistroSanitario();
			articuloRegistroSanitarioDTO.setUserId(userDto.getUserId());
			dataGestor.update(articuloRegistroSanitarioDTO);				
			ArticuloDTO articuloDTO = relacionArticuloRegistroSanitarioDTO.getArticulo();

			impresionRegistroSanitarioDTO.setCantidadImpresion(articuloRegistroSanitarioDTO.getCantidadImpresion());
			impresionRegistroSanitarioDTO.setFechaCaducidad(articuloRegistroSanitarioDTO.getFechaCaducidad());
			impresionRegistroSanitarioDTO.setFechaElaboracion(articuloRegistroSanitarioDTO.getFechaElaboracion());
			impresionRegistroSanitarioDTO.setLote(articuloRegistroSanitarioDTO.getLote());
			impresionRegistroSanitarioDTO.setMarca(articuloRegistroSanitarioDTO.getMarca());
			impresionRegistroSanitarioDTO.setNombreArticulo(articuloDTO.getDescripcionArticulo());
			impresionRegistroSanitarioDTO.setNte(articuloRegistroSanitarioDTO.getNte());
			impresionRegistroSanitarioDTO.setPorcionEnvase(relacionArticuloRegistroSanitarioDTO.getPorcionesEnvase() != null ? String.valueOf(relacionArticuloRegistroSanitarioDTO.getPorcionesEnvase()) : null);
			impresionRegistroSanitarioDTO.setRegistroSanitario(articuloRegistroSanitarioDTO.getRegistroSanitario());
			impresionRegistroSanitarioDTO.setTamanioPorcion(articuloRegistroSanitarioDTO.getTipoTamanioPorcion().getNombreCatalogoValor());
			impresionRegistroSanitarioDTO.getId().setCodigoArticulo(articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras());// TODO
			impresionRegistroSanitarioDTO.setPrecio(articuloDTO.getPVPImp() != null ? String.valueOf(nf.format(articuloDTO.getPVPImp())) : null);
			if (articuloDTO.getValorEstadoTransgenico() != null) {
				impresionRegistroSanitarioDTO.setLeyendaCompuestosTransgenicos(StringUtils.equals(articuloDTO.getValorEstadoTransgenico(), SICConstantes.ESTADO_ACTIVO_NUMERICO) ? LEYENDA_CONTIENE_COMP_TRANS : LEYENDA_NO_CONTIENE_COMP_TRANS);
			} else {
				impresionRegistroSanitarioDTO.setLeyendaCompuestosTransgenicos("");
			}
			String regex = ""; 
			ParametroDTO parametroDTO = parametroGestor.obtenerParametro(articuloRegistroSanitarioDTO.getId().getCodigoCompania(),SICArticuloConstantes.getInstancia().VALOR_ID_PARAMETRO_PATERN_ETIQUETA_REGSAN);
			if(parametroDTO != null && StringUtils.isNotEmpty(parametroDTO.getValorParametro())){//iteretro todas las etiquetas enviadas
				regex = parametroDTO.getValorParametro();
			}
			// se eliminan los enters para generar el archivo
			impresionRegistroSanitarioDTO.setDescripcionArticulo(eliminarEnters(articuloRegistroSanitarioDTO.getDescripcionArticulo(),regex));
			impresionRegistroSanitarioDTO.setFormaConservacion(eliminarEnters(articuloRegistroSanitarioDTO.getFormaConservacion(),regex));
			impresionRegistroSanitarioDTO.setIngredientes(eliminarEnters(articuloRegistroSanitarioDTO.getIngredientes(),regex));
			impresionRegistroSanitarioDTO.setProveedor(eliminarEnters(articuloRegistroSanitarioDTO.getProveedor(),regex));
			impresionRegistroSanitarioDTO.setCiudadPais(articuloRegistroSanitarioDTO.getCiudadPais());

			// AZUCARES
			ArticuloInformacionNutricionalDTO articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_AZUCAR);
			impresionRegistroSanitarioDTO.setAzucaresCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setAzucaresPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// CALCIO
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_CALCIO);
			impresionRegistroSanitarioDTO.setCalcioPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// CARBOHIDRATOS
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_CARBOHIDRATOS);
			impresionRegistroSanitarioDTO.setCarbohidratosTotalesCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setCarbohidratosTotalesPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// COLESTEROL
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_COLESTEROL);
			impresionRegistroSanitarioDTO.setColesterolCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setColesterolPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// ENERGIA
			impresionRegistroSanitarioDTO.setEnergiaCaloria(articuloRegistroSanitarioDTO.getEnergiaCaloria());
			impresionRegistroSanitarioDTO.setEnergiaGrasaCaloria(articuloRegistroSanitarioDTO.getEnergiaGrasaCaloria());
			impresionRegistroSanitarioDTO.setEnergiaGrasaKJ(articuloRegistroSanitarioDTO.getEnergiaGrasaKJ());
			impresionRegistroSanitarioDTO.setEnergiaKJ(articuloRegistroSanitarioDTO.getEnergiaKJ());

			// FIBRA ALIMENTARIA
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_FIBRAALIMENTARIA);
			impresionRegistroSanitarioDTO.setFibraAlimentariaCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setFibraAlimentariaPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// GRASA SATURADA
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_GRASASATURADA);
			impresionRegistroSanitarioDTO.setGrasaSaturadaCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setGrasaSaturadaPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// GRASA TOTAL
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_GRASATOTAL);
			impresionRegistroSanitarioDTO.setGrasaTotalCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setGrasaTotalPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// GRASA TRANS
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_GRASATOTAL);
			impresionRegistroSanitarioDTO.setGrasaTransCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setGrasaTransPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// GRASA MONOINSATURADA
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_GRASAMONOINSATURADA);
			impresionRegistroSanitarioDTO.setGrasaMonoinsaturadaCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setGrasaMonoinsaturadaPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// GRASA POLIINSTATURADA
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_GRASAPOLIINSATURADA);
			impresionRegistroSanitarioDTO.setGrasaPoliinsaturadaCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setGrasaPoliinsaturadaPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// HIERRO
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_HIERRO);
			impresionRegistroSanitarioDTO.setHierroPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// PROTEINA
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_PROTEINA);
			impresionRegistroSanitarioDTO.setProteinaCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setProteinaPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// SODIO
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_PROTEINA);
			impresionRegistroSanitarioDTO.setSodioCantidad(articuloInformacionNutricionalDTO != null && articuloInformacionNutricionalDTO.getValorCantidad() != null ? String.valueOf(articuloInformacionNutricionalDTO.getValorCantidad()).concat(" ").concat(articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() != null ? articuloInformacionNutricionalDTO.getValorTipoUnidadMedida() :"") : null);
			impresionRegistroSanitarioDTO.setSodioPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// VITAMINA A
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_VITAMINAA);
			impresionRegistroSanitarioDTO.setVitaminaAPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// VITAMINA C
			articuloInformacionNutricionalDTO = obtenerInformacionNutricional(articuloRegistroSanitarioDTO.getInformacionNutricionalCol(), TipoCatalogoArticulo.COMPONENTE_NUTRICIONAL_VITAMINAA);
			impresionRegistroSanitarioDTO.setVitaminaCPorcentaje(articuloInformacionNutricionalDTO != null ? articuloInformacionNutricionalDTO.getValorPorcentaje() : null);

			// se genera la coleccion del detalle de impresion
			Collection<ImpresionRegistroSanitarioDTO> detallesCol = new ArrayList<ImpresionRegistroSanitarioDTO>();
			detallesCol.add(impresionRegistroSanitarioDTO);

			SimpleDateFormat tiempo = new SimpleDateFormat("yyyyMMddHHmmssSS");
			String carpeta = tiempo.format(new Date());

			File directorio = new File(System.getProperty("java.io.tmpdir"), carpeta);
			if (directorio.mkdir()) {
				LOG_SICV2.info("Creando la carpeta temporal:{}", directorio.getAbsolutePath());
			}

			String nombreArchivo = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.nombreTexto");

			// se genera el archivo de texto para su impresion se declara el
			// contenedor de registros obtenidos de la vista
			Collection<Object> impresionesCol = new ArrayList<Object>();
			// se agregan los detalles de impresion
			impresionesCol.addAll(detallesCol);

			// Generar archivo
			File file = new File(directorio, nombreArchivo);
			GeneradorExportacionService exportacionService = new GeneradorExportacionService();
			FormatoID formatoID = new FormatoID();
			try {
				formatoID.setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			} catch (Exception e) {
				throw new SICException("El formato no se pudo establecer", e);
			}
			formatoID.setCodigoSistema(LogUtilMessages.getInstancia().getString("log.sistema.CORP"));
			formatoID.setCodigoFormato(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.codigoFormato"));
			GeneracionExportacionListener listener = new GeneracionExportacionListener() {

				/**
				 * @see ec.com.smx.generadorexportacion.listener.GeneracionExportacionListener#recibirNotificacionInclusionObjeto(ec.com.smx.generadorexportacion.dto.EnvioDTO,
				 *      java.lang.Object, java.util.Date)
				 */
				public void recibirNotificacionInclusionObjeto(EnvioDTO arg0, Object arg1, Date arg2) throws GeneradorExportacionException {
				}

				/**
				 * @see ec.com.smx.generadorexportacion.listener.GeneracionExportacionListener#recibirNotificacionFinalizacionExitosaEnvio(ec.com.smx.generadorexportacion.dto.EnvioDTO,
				 *      java.util.Collection, java.util.Date)
				 */
				@SuppressWarnings({ "rawtypes" })
				public void recibirNotificacionFinalizacionExitosaEnvio(EnvioDTO arg0, Collection arg1, Date arg2) throws GeneradorExportacionException {
				}

				/**
				 * @see ec.com.smx.generadorexportacion.listener.GeneracionExportacionListener#recibirNotificacionErrorEnvio(ec.com.smx.generadorexportacion.dto.EnvioDTO,
				 *      java.util.Collection, java.lang.Object,
				 *      java.lang.Throwable, java.util.Date)
				 */
				@SuppressWarnings({ "rawtypes" })
				public void recibirNotificacionErrorEnvio(EnvioDTO arg0, Collection arg1, Object arg2, Throwable arg3, Date arg4) throws GeneradorExportacionException {
				}
			};
			exportacionService.addListener(listener);

			try {
				// si existen datos del detalle se exporta el archivo...
				if (detallesCol != null && detallesCol.size() > 0) {
					String usuarioId = userDto.getUserId();
					EnvioDTO envio = exportacionService.inicializarEnvio(formatoID, usuarioId);
					exportacionService.transRealizarEnvioDatos(impresionesCol, envio.getId(), file, usuarioId);
				}

			} catch (Exception e) {
				throw new SICException("Ha ocurrido un error al generar el archivo", e);
			}

			LOG_SICV2.info("El archivo {} ha sido creado correctamente", file.getAbsolutePath());

			// se genera un bat que determina cual es el formato que se debe
			// ejecutar
			String nombreBat = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.nombreBat");
			File fileExec = new File(directorio, nombreBat);
			FileWriter fw = null;
			PrintWriter pw = null;

			try {
				fw = new FileWriter(fileExec);
				pw = new PrintWriter(fw);
				pw.println("cd " + SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.directorioRemotoCompleto"));

				switch (enumFormatoImpresionRegSan) {
				case FORMATO_UNO:
					pw.println(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.archivoImpresionFormato1"));
					break;
				case FORMATO_DOS:
					pw.println(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.archivoImpresionFormato2"));
					break;
				case FORMATO_TRES:
					pw.println(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.archivoImpresionFormato3"));
					break;
				case FORMATO_CUATRO:
					pw.println(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.archivoImpresionFormato4"));
					break;
				case FORMATO_CINCO:
					pw.println(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.archivoImpresionFormato5"));
					break;
				default:
					LOG_SICV2.info("default");
				}
				;
				pw.close();
				LOG_SICV2.info("El archivo {} ha sido creado correctamente", fileExec.getAbsolutePath());
			} catch (IOException e2) {
				LOG_SICV2.error("Error: ", e2);
				throw new SICException("No se pudo generar el archivo bat", e2);
			} finally {
				if (null != fw)
					try {
						fw.close();
						pw.close();
					} catch (IOException e) {
						LOG_SICV2.error("Error: ", e);
					}
			}
			LOG_SICV2.info("****Datos actualizar*****");
			//asignamos el codigo functionario al articuloVO
//			FuncionarioVO funcionarioVO = (FuncionarioVO) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("funcionarioVO");
			if(funcionarioVO != null && funcionarioVO.getBaseDTO() != null && SearchDTO.isLoaded(funcionarioVO.getBaseDTO().getAreaTrabajoDTO())){
				if(funcionarioVO.getBaseDTO().getAreaTrabajoDTO().getId().getCodigoAreaTrabajo() != null){
					LOG_SICV2.info("Codigo area trabajo actual: "+funcionarioVO.getBaseDTO().getAreaTrabajoDTO().getId().getCodigoAreaTrabajo());
				}
				if(funcionarioVO.getBaseDTO().getAreaTrabajoDTO().getNombreAreaTrabajo() != null){
					LOG_SICV2.info("Nombre area trabajo actual: "+funcionarioVO.getBaseDTO().getAreaTrabajoDTO().getNombreAreaTrabajo());
				}
			}
			LOG_SICV2.info("Codigo Articulo: "+articuloDTO.getId().getCodigoArticulo());
			LOG_SICV2.info("Lote: "+articuloRegistroSanitarioDTO.getLote());
			if(articuloRegistroSanitarioDTO.getFechaCaducidad() != null){
				LOG_SICV2.info("Fecha caducidad: "+articuloRegistroSanitarioDTO.getFechaCaducidad());
			}
			if(articuloRegistroSanitarioDTO.getFechaElaboracion() != null){
				LOG_SICV2.info("Fecha Elaboracion: "+articuloRegistroSanitarioDTO.getFechaElaboracion());
			}
			LOG_SICV2.info("Num Impresiones: "+articuloRegistroSanitarioDTO.getCantidadImpresion());
			// datos para subir por FTP los archivos
			String directorioRemotoFTP = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.directorioRemotoFTP");
			String user = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.ftp.us");
			String pass = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.ftp.ps");

			FTPClient ftpClient = new FTPClient();
			boolean successful = false;
			try {
				String remoteHostToConnect = null;
				if(StringUtils.equals(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.ftp.skip.serverRequest"), SICConstantes.ESTADO_ACTIVO_NUMERICO)){
					remoteHostToConnect = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.ftp.serverName");
				}else{
					remoteHostToConnect = InetAddress.getByName(remoteHost).getCanonicalHostName();
				}
				LOG_SICV2.info("Connecting to server: " + remoteHostToConnect);
				LOG_SICV2.info("Port: " + SICArticuloConstantes.getInstancia().VALOR_PUERTO_FTP);
				ftpClient.connect(remoteHostToConnect, SICArticuloConstantes.getInstancia().VALOR_PUERTO_FTP);			
				ftpClient.setFileType(FTP.ASCII_FILE_TYPE);				
				boolean conectado = ftpClient.login(user, pass);			
				LOG_SICV2.info("Connected to server {}: " + conectado,remoteHostToConnect);
				if(!conectado){
					throw new SICException("Ha ocurrido un error al autenticarse con el servidor FTP.");
				}
		        ftpClient.changeWorkingDirectory(directorioRemotoFTP);
		        Collection<File> archivosCol = new ArrayList<File>();
				archivosCol.add(file);
				archivosCol.add(fileExec);
				for (File archivo : archivosCol) {
					InputStream in = new FileInputStream(archivo);
					ftpClient.storeFile(archivo.getName(),in);	
					in.close();
				}
				LOG_SICV2.info(ftpClient.getReplyString());
				LOG_SICV2.info("Connection is working: " + ftpClient.noop()); // check that control connection is working OK
				ftpClient.logout();
				successful = true;
				LOG_SICV2.info("Send successful:" + successful);				
			} catch (SocketException e){
				LOG_SICV2.error("Server closed connection: ", e.getMessage());
				throw new SICException("Ha ocurrido un error al comunicarse con el servidor FTP", e);
	        }catch (FTPConnectionClosedException e){
				LOG_SICV2.error("Server closed connection: ", e.getMessage());
				throw new SICException("Ha ocurrido un error al comunicarse con el servidor FTP", e);
	        }catch (IOException e) {
	        	LOG_SICV2.error("Error al transferir archivos: ", e.getMessage());
	        	throw new SICException("Ha ocurrido un error al transferir los archivos", e);
			} finally {
				try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	            	LOG_SICV2.error("Error al cerrar la conexion.");
	            	throw new SICException("Ha ocurrido un error al cerrar la conexion", ex);
	            }
				try {
					LOG_SICV2.info("Eliminando carpeta temporal:{}", directorio.getAbsoluteFile());
					FileUtils.deleteDirectory(directorio);
				} catch (IOException e) {
					Logeable.LOG_SICV2.error(e.getMessage());
					LOG_SICV2.error("Error al eliminar la carpeta temporal.");
		        	throw new SICException("Error al eliminar la carpeta temporal.", e);
				}
			}			
			
		}
	}

	public ArticuloInformacionNutricionalDTO obtenerInformacionNutricional(Collection<ArticuloInformacionNutricionalDTO> informacionNutricionalDTOCol, final Integer codigoInformacionNutricional) {
		if (CollectionUtils.isNotEmpty(informacionNutricionalDTOCol) && codigoInformacionNutricional != null) {
			return (ArticuloInformacionNutricionalDTO) CollectionUtils.find(informacionNutricionalDTOCol, new Predicate() {

				@Override
				public boolean evaluate(Object arg0) {
					ArticuloInformacionNutricionalDTO articuloInformacionNutricionalDTO = (ArticuloInformacionNutricionalDTO) arg0;
					if (articuloInformacionNutricionalDTO != null && codigoInformacionNutricional.compareTo(articuloInformacionNutricionalDTO.getId().getCodigoComponenteNutricional()) == 0) {
						return true;
					}
					return false;
				}
			});
		}
		return null;
	}

	public String eliminarEnters(String cadena,String regex) {
		String dato = cadena;
		if (StringUtils.isNotEmpty(dato)) {
			if(StringUtils.isNotEmpty(regex)){//iteretro todas las etiquetas enviadas
				dato = dato.replaceAll(regex, " ").replaceAll("\\s+", " ");
			}else{
				dato = dato.replaceAll("\\r\\n", " ");
			}
		}
		return dato;
	}

	@Override
	public SearchResultDTO<ArticuloRegistroSanitarioDTO> obtenerArticuloRegistroSanitarioPaginados(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException {

		if (articuloRegistroSanitarioDTO != null)
			return this.articuloRegistroSanitarioDAO.obtenerArticulosRegistroSanitarioPaginados(articuloRegistroSanitarioDTO);

		return null;
	}

	@Override
	public Collection<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitario(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException {
		if (articuloRegistroSanitarioDTO != null)
			return this.articuloRegistroSanitarioDAO.obtenerArticulosRegistroSanitario(articuloRegistroSanitarioDTO);

		return null;
	}

	@Override
	public Collection<BitacoraRevisionRegistroSanitarioDTO> obtenerBitacoraRevisioRegistroSanitario(BitacoraRevisionRegistroSanitarioDTO bitacoraRevisionRegSan) throws SICException {
		if (bitacoraRevisionRegSan != null)
			return this.dataGestor.findObjects(bitacoraRevisionRegSan);

		return null;
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setArticuloArchivoGestor(ArticuloArchivoGestor articuloArchivoGestor) {
		this.articuloArchivoGestor = articuloArchivoGestor;
	}

	public void setArticuloRegistroSanitarioDAO(IArticuloRegistroSanitarioDAO articuloRegistroSanitarioDAO) {
		this.articuloRegistroSanitarioDAO = articuloRegistroSanitarioDAO;
	}

	public void setValidacionRegSanGestor(IValidacionRegSanGestor validacionRegSanGestor) {
		this.validacionRegSanGestor = validacionRegSanGestor;
	}

	/**
	 * @return the accionArticuloGestor
	 */
	public IAccionArticuloGestor getAccionArticuloGestor() {
		return accionArticuloGestor;
	}

	/**
	 * @param accionArticuloGestor
	 *            the accionArticuloGestor to set
	 */
	public void setAccionArticuloGestor(IAccionArticuloGestor accionArticuloGestor) {
		this.accionArticuloGestor = accionArticuloGestor;
	}
	


	
	
	
	
	/**
	 * Permite buscar los registros sanitarios activos de un articulo
	 * 
	 * @param articuloDTO
	 * @throws SICException
	 * @return
	 */
	@Override
	public Collection<ArticuloRegistroSanitarioDTO> buscarRegistrosSanitariosActivos(ArticuloDTO articuloDTO) throws SICException {
		Collection<ArticuloRegistroSanitarioDTO> articuloRegistroSanitarioDTOs = articuloRegistroSanitarioDAO.buscarRegistrosSanitariosActivos(articuloDTO);
		return articuloRegistroSanitarioDTOs;
	}
	
//	/**
//	 * Permite buscar los registros sanitarios activos de un articulo
//	 * 
//	 * @param articuloDTO
//	 * @throws SICException
//	 * @return
//	 */
//	public Collection<String> buscarCodigosRegistrosSanitarios(ArticuloDTO articuloDTO) throws SICException {
//		Collection<String> codigosRegSan = articuloRegistroSanitarioDAO.buscarCodigosRegistrosSanitarios(articuloDTO);
//		return codigosRegSan;
//	}
	
	
	/**
	 * TODO: comentado porque al momento el metodo no se encuentra en uso
	 */
	/*private PrintConfigurationDto initDefaultTemplate(){
		PrintConfigurationDto printConfigurationDto = new PrintConfigurationDto();
		PageDto pageDto = new PageDto();
		pageDto.setFormat("A3");
		pageDto.setPageHeight(NumberUtils.createBigDecimal("420"));
		pageDto.setPageWidth(NumberUtils.createBigDecimal("297"));
		
		printConfigurationDto.setMarginLeft(NumberUtils.createBigDecimal("10"));
		printConfigurationDto.setMarginTop(NumberUtils.createBigDecimal("10"));
		printConfigurationDto.setMarginRight(NumberUtils.createBigDecimal("10"));
		printConfigurationDto.setMarginBottom(NumberUtils.createBigDecimal("10"));
		printConfigurationDto.setCellpadding(NumberUtils.createBigDecimal("1"));
		printConfigurationDto.setCellspacing(NumberUtils.createBigDecimal("0"));
	    
		printConfigurationDto.setPageDto(pageDto);
		
		return printConfigurationDto;
		
	}*/
	
	private Boolean getAplicaRegistroSanitario( ArticuloDTO articuloDTO ){
		if(articuloDTO.getCodigoAplicaRegistroSanitario() != null && articuloDTO.getCodigoAplicaRegistroSanitario().compareTo(TipoCatalogoArticulo.TIPO_ESTADO_APLICA_REGISTRO_SANITARIO) == 0
				&& StringUtils.equals(articuloDTO.getValorAplicaRegistroSanitario(), TipoCatalogoArticulo.VALOR_APLICA_REGISTRO_SANITARIO)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;	
	}

	public IParametroGestor getParametroGestor() {
		return parametroGestor;
	}

	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}
	
}