/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.articulo.alcance.nosql.almacenamiento;

import static ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalIndices.INDEX_AREATRABAJO_ARTICULO;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.framework.utilitario.nosql.common.constants.AuditoriaFields;
import ec.com.smx.framework.utilitario.nosql.common.exception.NoSQLException;
import ec.com.smx.framework.utilitario.nosql.orientdb.SimpleOrientDocumentDbManager;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumClasesArticuloAlcanceNoSql;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.util.ArticuloAlcanceIndexNoSqlUtil;
import ec.com.smx.sic.cliente.common.articulo.util.ArticuloAlcanceNoSqlUtil;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloAreaTrabajoBitacoraFields;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalFields;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IAlmacenamientoArticuloAlcanceNoSqlGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.validacion.IValidacionArticuloAlcanceNoSqlGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.ArticuloAreaTrabajoNoSqlDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.VistaArticuloLocalNoSqlDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAlcanceDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloAlcanceNoSqlDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloAreaTrabajoBitacoraODocumentDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloLocalODocumentDAO;
import ec.com.smx.sic.cliente.resources.SICMessages;

/**
 * @author wcaiza
 * @author bymontesdeoca 
 */
@SuppressWarnings("deprecation")
public class AlmacenamientoArticuloAlcanceNoSqlGestor implements IAlmacenamientoArticuloAlcanceNoSqlGestor, Logeable {
	
	public static final Locale LOCALE_ES = new Locale("es", "ES");
	
	private SimpleOrientDocumentDbManager simpleOrientDocumentDbManager;
	private IValidacionArticuloAlcanceNoSqlGestor validacionArticuloAlcanceNoSqlGestor;
	private IArticuloLocalODocumentDAO articuloLocalODocumentDAO;
	private IArticuloAreaTrabajoBitacoraODocumentDAO articuloAreaTrabajoBitacoraODocumentDAO;
	private IArticuloAlcanceNoSqlDAO articuloAlcanceNoSqlDAO;
	private IArticuloAlcanceDAO articuloAlcanceDAO;

	
	public void setArticuloAlcanceDAO(IArticuloAlcanceDAO articuloAlcanceDAO) {
		this.articuloAlcanceDAO = articuloAlcanceDAO;
	}

	public void setArticuloAlcanceNoSqlDAO(IArticuloAlcanceNoSqlDAO articuloAlcanceNoSqlDAO) {
		this.articuloAlcanceNoSqlDAO = articuloAlcanceNoSqlDAO;
	}

	/**
	 * @param simpleOrientDocumentDbManager the simpleOrientDocumentDbManager to set
	 */
	public void setSimpleOrientDocumentDbManager(SimpleOrientDocumentDbManager simpleOrientDocumentDbManager) {
		this.simpleOrientDocumentDbManager = simpleOrientDocumentDbManager;
	}

	/**
	 * @param validacionArticuloAlcanceNoSqlGestor the validacionArticuloAlcanceNoSqlGestor to set
	 */
	public void setValidacionArticuloAlcanceNoSqlGestor(IValidacionArticuloAlcanceNoSqlGestor validacionArticuloAlcanceNoSqlGestor) {
		this.validacionArticuloAlcanceNoSqlGestor = validacionArticuloAlcanceNoSqlGestor;
	}

	/**
	 * @param articuloLocalODocumentDAO the articuloLocalODocumentDAO to set
	 */
	public void setArticuloLocalODocumentDAO(IArticuloLocalODocumentDAO articuloLocalODocumentDAO) {
		this.articuloLocalODocumentDAO = articuloLocalODocumentDAO;
	}

	/**
	 * @param articuloAreaTrabajoBitacoraODocumentDAO the articuloAreaTrabajoBitacoraODocumentDAO to set
	 */
	public void setArticuloAreaTrabajoBitacoraODocumentDAO(IArticuloAreaTrabajoBitacoraODocumentDAO articuloAreaTrabajoBitacoraODocumentDAO) {
		this.articuloAreaTrabajoBitacoraODocumentDAO = articuloAreaTrabajoBitacoraODocumentDAO;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IAlmacenamientoArticuloAlcanceNoSqlGestor#registrarArticuloLocal(java.lang.Integer, java.util.Collection)
	 */
	@Override
	public void migrarArticuloLocal(Integer codigoCompania, Collection<VistaArticuloLocalNoSqlDTO> colVistaMigrarArticuloLocalDTO, String sufijoTabla) throws SICException {
		
		ODatabaseDocumentTx db = null;
		
		try {
			
			if (CollectionUtils.isNotEmpty(colVistaMigrarArticuloLocalDTO)) {
				
				db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
				
				Collection<ODocument> colODocumentArticuloLocalRegistrar = this.colODocumentArticuloLocalMigrar(colVistaMigrarArticuloLocalDTO, sufijoTabla);
				
				// incio transaccion
				db.begin();
				
				String iClusterName = ArticuloAlcanceNoSqlUtil.validarCrearClusterPorLocal(
						db, EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName(), colVistaMigrarArticuloLocalDTO.iterator().next().getId().getCodigoLocal());
				this.articuloLocalODocumentDAO.registrarArticuloLocalDocument(iClusterName, colODocumentArticuloLocalRegistrar);
				
				// fin transaccion
				db.commit();
				
				ArticuloAlcanceIndexNoSqlUtil.registrarIndicesODocumentArticuloLocalDTO(
						db, colODocumentArticuloLocalRegistrar.toArray(new ODocument[colODocumentArticuloLocalRegistrar.size()]));
				
//				Collection<String> colCodigoArticulo = CentroDistribucionUtil.getInstancia().obtenerColeccionDesdeAtributo(colVistaMigrarArticuloLocalDTO, "id.codigoArticulo");
//				this.migrarArticuloLocalBitacora(codigoCompania, colCodigoArticulo, sufijoTabla);
			}
			
		} catch (NoSQLException e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw new SICException(e);
			
		} catch (SICException e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw e;
			
		} catch (Exception e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw new SICException(e);
			
		} finally {
			
			if (db != null) {
				db.close();
			}
			
		}
	}
	
//@Override
//	private void migrarArticuloLocalBitacora (Integer codigoCompania, Collection<String> colCodigoArticulo, String sufijoTabla) throws SICException {
//		
//		ODatabaseDocumentTx db = null;
//		
//		try {
//			
//			if (CollectionUtils.isNotEmpty(colCodigoArticulo)) {
//				
//				Collection<ArticuloAreaTrabajoBitacoraDTO> colArticuloAreaTrabajoBitacoraDTO = 
//						SICFactory.getInstancia().articulo.getArticuloAlcanceNoSqlServicio().obtenerColArticuloAreaTrabajoBitacora(
//								sufijoTabla, codigoCompania, colCodigoArticulo.toArray(new String[colCodigoArticulo.size()]));
//				
//				db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
//				
////				Map<String, Collection<ArticuloAreaTrabajoBitacoraDTO>> mapArticuloLocalBitacora = new HashMap<>();
////				
////				for (ArticuloAreaTrabajoBitacoraDTO areaTrabajoBitacoraDTO : colArticuloAreaTrabajoBitacoraDTO) {
////				
////					String clusterName = ArticuloAlcanceNoSqlUtil.obtenerNombreClusterArticuloLocalBitacora(
////							EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName(), areaTrabajoBitacoraDTO.getFechaRegistro());
////				
////					if (mapArticuloLocalBitacora.containsKey(clusterName)) {
////					
////						Collection<ArticuloAreaTrabajoBitacoraDTO> temp = new ArrayList<>();
////						temp.addAll(mapArticuloLocalBitacora.get(clusterName));
////						temp.add(areaTrabajoBitacoraDTO);
////						mapArticuloLocalBitacora.put(clusterName, colArticuloAreaTrabajoBitacoraDTO);
////					
////					} else {
////						Collection<ArticuloAreaTrabajoBitacoraDTO> temp = new ArrayList<>();
////						temp.add(areaTrabajoBitacoraDTO);
////						mapArticuloLocalBitacora.put(clusterName, colArticuloAreaTrabajoBitacoraDTO);
////					}
////				}
//				
//				// incio transaccion
//				db.begin();
//				
//				//Collection<ODocument> colODocumentArticuloLocalBitacora = this.registrarArticuloLocalBitacora(db, sufijoTabla, mapArticuloLocalBitacora);
//				Collection<ODocument> colODocumentArticuloLocalBitacora = this.registrarArticuloLocalBitacora(db, sufijoTabla, colArticuloAreaTrabajoBitacoraDTO);
//				
//				// fin transaccion
//				db.commit();
//				
//				ArticuloAlcanceIndexNoSqlUtil.registrarIndicesODocumentArticuloLocalBitacora(db, 
//						colODocumentArticuloLocalBitacora.toArray(new ODocument[colODocumentArticuloLocalBitacora.size()]));
//				
//			}
//		} catch (NoSQLException e) {
//			
//			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
//			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
//			throw new SICException(e);
//			
//		} catch (SICException e) {
//			
//			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
//			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
//			throw e;
//			
//		} catch (Exception e) {
//			
//			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
//			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
//			throw new SICException(e);
//			
//		} finally {
//			
//			if (db != null) {
//				db.close();
//			}
//			
//		}
//		
//	}
	
	@Override
	public void migrarArticuloLocalBitacora(Integer codigoCompania, Collection<ArticuloAreaTrabajoBitacoraDTO> colArticuloAreaTrabajoBitacoraDTO, String sufijoTabla) throws SICException {
		
		ODatabaseDocumentTx db = null;
		
		try {
			
				db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
				
//				Map<String, Collection<ArticuloAreaTrabajoBitacoraDTO>> mapArticuloLocalBitacora = new HashMap<>();
//				
//				for (ArticuloAreaTrabajoBitacoraDTO areaTrabajoBitacoraDTO : colArticuloAreaTrabajoBitacoraDTO) {
//				
//					String clusterName = ArticuloAlcanceNoSqlUtil.obtenerNombreClusterArticuloLocalBitacora(
//							EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName(), areaTrabajoBitacoraDTO.getFechaRegistro());
//				
//					if (mapArticuloLocalBitacora.containsKey(clusterName)) {
//					
//						Collection<ArticuloAreaTrabajoBitacoraDTO> temp = new ArrayList<>();
//						temp.addAll(mapArticuloLocalBitacora.get(clusterName));
//						temp.add(areaTrabajoBitacoraDTO);
//						mapArticuloLocalBitacora.put(clusterName, colArticuloAreaTrabajoBitacoraDTO);
//					
//					} else {
//						Collection<ArticuloAreaTrabajoBitacoraDTO> temp = new ArrayList<>();
//						temp.add(areaTrabajoBitacoraDTO);
//						mapArticuloLocalBitacora.put(clusterName, colArticuloAreaTrabajoBitacoraDTO);
//					}
//				}
				
				// incio transaccion
				db.begin();
				
				Collection<ODocument> colODocumentArticuloLocalBitacora = this.registrarArticuloLocalBitacora(db, sufijoTabla, colArticuloAreaTrabajoBitacoraDTO);
				
				// fin transaccion
				db.commit();
				
				ArticuloAlcanceIndexNoSqlUtil.registrarIndicesODocumentArticuloLocalBitacora(db, 
						colODocumentArticuloLocalBitacora.toArray(new ODocument[colODocumentArticuloLocalBitacora.size()]));
				
		} catch (NoSQLException e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw new SICException(e);
			
		} catch (SICException e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw e;
			
		} catch (Exception e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw new SICException(e);
			
		} finally {
			
			if (db != null) {
				db.close();
			}
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IAlmacenamientoArticuloAlcanceNoSqlGestor#migrarArticuloEstablecimiento(java.lang.Integer, java.util.Collection, java.lang.String)
	 */
	@Override
	public void migrarArticuloEstablecimiento(Integer codigoCompania, Collection<ArticuloEstablecimientoDTO> colArticuloEstablecimientoDTO, String sufijoTabla) throws SICException {
		
		ODatabaseDocumentTx db = null;
		
		try {
			
			if (CollectionUtils.isNotEmpty(colArticuloEstablecimientoDTO)) {
				
				
				Collection<ODocument> colODocumentArticuloEstablecimiento = this.colODocumentArticuloEstablecimientoMigrar(colArticuloEstablecimientoDTO);
				
				db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
				
				// incio transaccion
				db.begin();
				
				String idClusterName = ArticuloAlcanceNoSqlUtil.validarCrearClusterPorArticuloEstablecimiento(
						db, EnumClasesArticuloAlcanceNoSql.ArticuloEstablecimientoDTO.getName(), colArticuloEstablecimientoDTO.iterator().next().getId().getCodigoEstablecimiento());
				
				this.articuloAlcanceNoSqlDAO.registrarArticuloEstablecimientoDocument(idClusterName, colODocumentArticuloEstablecimiento);
				
				// fin transaccion
				db.commit();
				
				//Registrar indices
				this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloEstablecimiento(db, 
						colODocumentArticuloEstablecimiento.toArray(new ODocument[colODocumentArticuloEstablecimiento.size()]));
				
			}
			
		} catch (NoSQLException e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al migrarArticuloEstablecimiento: {}", e.toString());
			throw new SICException(e);
			
		} catch (SICException e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al migrarArticuloEstablecimiento: {}", e.toString());
			throw e;
			
		} catch (Exception e) {
			
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al migrarArticuloEstablecimiento: {}", e.toString());
			throw new SICException(e);
			
		} finally {
			
			if (db != null) {
				db.close();
			}
			
		}
	}
	
	private Collection<ODocument> colODocumentArticuloLocalMigrar (Collection<VistaArticuloLocalNoSqlDTO> colVistaArticuloLocalNoSqlDTO, String sufijoTabla) throws SICException {
		Collection<ODocument> colODocumentArticuloLocal = new ArrayList<>();
		for (VistaArticuloLocalNoSqlDTO vistaArticuloLocalDTO : colVistaArticuloLocalNoSqlDTO) {
			this.validacionArticuloAlcanceNoSqlGestor.validarArticuloLocalRegistrar(vistaArticuloLocalDTO);
			colODocumentArticuloLocal.add(ArticuloAlcanceNoSqlUtil.generarODocumentMigrarArticuloLocal(vistaArticuloLocalDTO, sufijoTabla));
		}
		return colODocumentArticuloLocal;
	}
	
	private Collection<ODocument> colODocumentArticuloEstablecimientoMigrar (Collection<ArticuloEstablecimientoDTO> colArticuloEstablecimiento) throws SICException {
		Collection<ODocument> colODocumentArticuloEstablecimiento = new ArrayList<>();
		for (ArticuloEstablecimientoDTO articuloEstablecimientoDTO : colArticuloEstablecimiento) {
			colODocumentArticuloEstablecimiento.add(ArticuloAlcanceNoSqlUtil.generarODocumentMigrarArticuloEstablecimiento(articuloEstablecimientoDTO));
		}
		return colODocumentArticuloEstablecimiento;
	}
	
	/**
	 * Generar el odocument a registrar, se consulta el link hacia el ArticuloLocal
	 * @param db
	 * @param sufijoTabla El sufijo de la tabla de donde provienen los datos OFI, LOC, BOD
	 * @param mapArticuloLocalBitacora
	 * @return
	 * @throws SICException
	 */
//	private Collection<ODocument> registrarArticuloLocalBitacora (ODatabaseDocumentTx db, String sufijoTabla, Map<String, Collection<ArticuloAreaTrabajoBitacoraDTO>> mapArticuloLocalBitacora) throws SICException {
	private Collection<ODocument> registrarArticuloLocalBitacora (ODatabaseDocumentTx db, String sufijoTabla, Collection<ArticuloAreaTrabajoBitacoraDTO> colArticuloLocalBitacora) throws SICException {		
		Collection<ODocument> colODocumentArticuloLocalBitacora = new ArrayList<>();
		try {
			
//		for (String clusterName : mapArticuloLocalBitacora.keySet()) {
			
			//ArticuloAlcanceNoSqlUtil.validarCrearClusterArticuloLocalBitacora(db, EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName() , clusterName);
			
			for (ArticuloAreaTrabajoBitacoraDTO articuloAreaTrabajoBitacoraDTO : colArticuloLocalBitacora) {
				
				ODocument oDocumentRegistrar = ArticuloAlcanceNoSqlUtil.generarODocumentMigrarArticuloLocalBitacora(articuloAreaTrabajoBitacoraDTO, sufijoTabla);
				
				List<Object[]> listKey = new ArrayList<>();
				listKey.add(new Object[] {
						articuloAreaTrabajoBitacoraDTO.getId().getCodigoCompania(), 
						sufijoTabla,
						articuloAreaTrabajoBitacoraDTO.getCodigoAreaTrabajo(), 
						articuloAreaTrabajoBitacoraDTO.getCodigoArticulo()});
				
				Collection<ODocument> colODocumentIndiceArtLoc = 
						this.articuloLocalODocumentDAO.obtenerIndiceLocalArticulo(INDEX_AREATRABAJO_ARTICULO, listKey, ArticuloAreaTrabajoBitacoraFields.RID_ARTICULO_LOCAL);
				
				if (!CollectionUtils.isEmpty(colODocumentIndiceArtLoc)){
					oDocumentRegistrar.field(ArticuloAreaTrabajoBitacoraFields.RID_ARTICULO_LOCAL, colODocumentIndiceArtLoc.iterator().next().field("rid"));
				}
				colODocumentArticuloLocalBitacora.add(oDocumentRegistrar);
				
				String clusterName = ArticuloAlcanceNoSqlUtil.obtenerNombreClusterArticuloLocalBitacora(
						EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName(), articuloAreaTrabajoBitacoraDTO.getFechaRegistro());
				ArticuloAlcanceNoSqlUtil.validarCrearClusterArticuloLocalBitacora(db, EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName() , clusterName);
				this.articuloAreaTrabajoBitacoraODocumentDAO.registrarArticuloLocalBitacoraDocument(clusterName, oDocumentRegistrar);
				
			}
			
			//this.articuloAreaTrabajoBitacoraODocumentDAO.registrarArticuloLocalBitacoraDocument(null, colODocumentArticuloLocalBitacora);
		//}
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrarArticuloLocalBitacora: {}", e);
			new SICException("Error al registrarArticuloLocalBitacora", e);
		}

		return colODocumentArticuloLocalBitacora;
	}
	
	/*
	 * Metodos q se ocupan desde el modulo de articulos
	 * 
	 * */
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IAlmacenamientoArticuloAlcanceNoSqlGestor#registrarAlcanceBodegasSubbodega(ec.com.smx.sic.cliente.mdl.vo.ArticuloVO, java.util.Collection)
	 */
	
	@Override
	public void registrarAlcanceBodegasSubbodega(ArticuloVO articuloVO, Collection<Integer> codigosAreaTrabajo, String opcionTipoAsignacionAlcance) throws SICException {
		
		ODatabaseDocumentTx db = null;
		
		try {
			
			if(CollectionUtils.isNotEmpty(codigosAreaTrabajo)){
				
				db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
				
				// incio transaccion
				db.begin();
				
				for(Integer idBodega : codigosAreaTrabajo){
					
					List<Object[]> listKey = new ArrayList<>();
					listKey.add(new Object[] {
							articuloVO.getCodigoCompania(), idBodega, articuloVO.getBaseDTO().getId().getCodigoArticulo()});
					Collection<ODocument> colODocumentIndiceArtLoc = this.articuloLocalODocumentDAO.obtenerIndiceLocalArticulo(INDEX_AREATRABAJO_ARTICULO, listKey);
					
					String iClusterName = ArticuloAlcanceNoSqlUtil.validarCrearClusterPorLocal(db, EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName(), idBodega);
					ODocument oDocumentArticuloLocalDTO = null;
					
					if (CollectionUtils.isEmpty(colODocumentIndiceArtLoc)) {
						
						oDocumentArticuloLocalDTO = new ODocument(EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName());
						oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_COMPANIA, articuloVO.getBaseDTO().getId().getCodigoCompania());
						oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_LOCAL, idBodega);
						oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_ARTICULO, articuloVO.getBaseDTO().getId().getCodigoArticulo());
						oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL, SICConstantes.ESTADO_ACTIVO_NUMERICO);
						ArticuloAlcanceNoSqlUtil.setearPlantilla(oDocumentArticuloLocalDTO, null, articuloVO, Boolean.TRUE);
						this.articuloLocalODocumentDAO.registrarArticuloLocalDocument(iClusterName, oDocumentArticuloLocalDTO);
						
					} else {
						
						oDocumentArticuloLocalDTO = colODocumentIndiceArtLoc.iterator().next();
						ArticuloAlcanceNoSqlUtil.setearPlantilla(oDocumentArticuloLocalDTO, null, articuloVO, Boolean.TRUE);
						this.articuloLocalODocumentDAO.registrarArticuloLocalDocument(iClusterName, oDocumentArticuloLocalDTO);
					}
					
					this.insertarBitacoraArticuloAreaTrabajo(oDocumentArticuloLocalDTO, articuloVO.getFechaAplicacion(), opcionTipoAsignacionAlcance);
				}
				
				// fin transaccion
				db.commit();
			}
		} catch (Exception e) {
			
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}
	
//	public void asignarQuitarRemplazarMasivaArticulosLocales(List<? extends ArticuloDTO> articuloCol, ArticuloVO articuloVO) throws SICException {
//		
//		StringBuilder cadenaArticuloAreatrabajo = new StringBuilder();
//		String opcionSeleccionada = articuloVO.getOpcionAlcance();
//		
//		if(CollectionUtils.isNotEmpty(articuloVO.getCodigosArticuloAreaTrabajo())){
////			cadenaArticuloAreatrabajo = StringUtils.join(articuloVO.getCodigosArticuloAreaTrabajo(),",");
//			cadenaArticuloAreatrabajo.append(articuloVO.getCodigosArticuloAreaTrabajo()).append(",");
//		}
//		
//	}
//
//	private void insertarArticulosMasivoLocalesNoSql(String accessItemId, String systemId, 
//			String codigoArticulo, String cadenaArticuloAreatrabajo, ArticuloVO articuloVO, ArticuloLocalPrecioVO articuloLocalPrecioVO) throws SICException {
//		
//		ODatabaseDocumentTx db = null;
//		
//		try {
//			
//			db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
//			
//			//validar si existe el articulo
//			List<Object[]> listKey = new ArrayList<>();
//			listKey.add(new Object[] {
//					articuloVO.getCodigoCompania(), articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo(), codigoArticulo});
//			Collection<ODocument> colODocumentIndiceArtLoc = this.articuloLocalODocumentDAO.obtenerIndiceLocalArticulo(INDEX_LOCAL_ARTICULO, listKey);
//			
//			if (CollectionUtils.isEmpty(colODocumentIndiceArtLoc)) {
//				 
//				ODocument oDocumentArticuloLocal = ArticuloAlcanceNoSqlUtil.
//						generarODocumentRegistarArticuloLocal(accessItemId, systemId, codigoArticulo, cadenaArticuloAreatrabajo, articuloVO, articuloLocalPrecioVO);
//				// incio transaccion
//				db.begin();
//				
//				String iClusterName = ArticuloAlcanceNoSqlUtil.validarCrearClusterPorLocal(
//						db, EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName(), articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo());
//				this.articuloLocalODocumentDAO.registrarArticuloLocalDocument(iClusterName, oDocumentArticuloLocal);
//				
//				// fin transaccion
//				db.commit();
//				
//				ArticuloAlcanceIndexNoSqlUtil.registrarIndicesODocumentArticuloLocalDTO(db, oDocumentArticuloLocal);
//				
//			}
//			
//		} catch (NoSQLException e) {
//			
//			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
//			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
//			throw new SICException(e);
//			
//		} catch (SICException e) {
//			
//			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
//			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
//			throw e;
//			
//		} catch (Exception e) {
//			
//			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
//			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
//			throw new SICException(e);
//			
//		} finally {
//			
//			if (db != null) {
//				db.close();
//			}
//			
//		}
//		
//	}

	@Override
	public void insertarBitacoraArticuloAreaTrabajo(ODocument oDocumentArticuloLocal, Date fechaAplicacion, String opcionTipoAsignacionAlcance) throws SICException {
		
//		if(StringUtils.isBlank(opcionTipoAsignacionAlcance)){
//			opcionTipoAsignacionAlcance = SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_LOCALES_ESPECIFICOS;
//		}
		
		ODocument oDocArtAreTraBit = new ODocument(EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName());
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.RID_ARTICULO_LOCAL, oDocumentArticuloLocal.fieldType("rid"));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.CODIGO_COMPANIA));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.CODIGO_LOCAL));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.CODIGO_ARTICULO));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_SISTEMA, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.CODIGO_SISTEMA));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_OPCION, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.CODIGO_OPCION));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.ESTADO_ALCANCE, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL));
		
//		oDocumentArticuloLocal fechaAplicacion
		if (((Date)(oDocumentArticuloLocal.field(ArticuloLocalFields.FECHA_ACTIVACION))).equals(fechaAplicacion)) {
			oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.USUARIO_ALCANCE, ArticuloLocalFields.ID_USUARIO_ACTIVACION);
		} else {
			oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.USUARIO_ALCANCE, ArticuloLocalFields.ID_USUARIO_INACTIVACION);
		}
		
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.USUARIO_ALCANCE, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.FECHA_ALCANCE, fechaAplicacion);
		oDocArtAreTraBit.field(AuditoriaFields.ESTADO, SICConstantes.ESTADO_ACTIVO_NUMERICO);
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.FECHA_INICIAL_ALCANCE, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.FECHA_INICIAL_ALCANCE));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.FECHA_FIN_ALCANCE, oDocumentArticuloLocal.fieldType(ArticuloLocalFields.FECHA_FINAL_ALCANCE));
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_BITACORA, SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_BITACORA_NORMAL);
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_TIPO_BITACORA, SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_BITACORA);
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_ASIGNACION, opcionTipoAsignacionAlcance);
		oDocArtAreTraBit.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_TIPO_ASIGNACION, SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_ASIGNACION);
		
		String iClusterName = ArticuloAlcanceNoSqlUtil.obtenerNombreClusterArticuloLocalBitacora(
				EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName(), fechaAplicacion);
		
		this.articuloAreaTrabajoBitacoraODocumentDAO.registrarArticuloLocalBitacoraDocument(iClusterName, oDocArtAreTraBit);
		
	}


	private Calendar getFechaActualFormatYearMonthDay(){
		Calendar fechaActual = Calendar.getInstance(LOCALE_ES);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFechaActual;
		String strFechaActual=fechaActual.get(Calendar.YEAR)+"-"+(fechaActual.get(Calendar.MONTH)+1)+"-"+fechaActual.get(Calendar.DAY_OF_MONTH); 
		try {
			dateFechaActual = sdf.parse(strFechaActual);
		} catch (ParseException e) {
			dateFechaActual=null;
		}
		fechaActual.setTime(dateFechaActual);
		return fechaActual;
	}
	
	private Set<String> getConjuntoLocalesUnion(String strLocalesInput,String strLocalesExistentes){
		
		if (strLocalesExistentes==null || strLocalesInput==null ){
			return null;
		}
		Set<String> set=new TreeSet<>(new Comparator<String>() {//ordena ascendente
			@Override
			public int compare(String o1, String o2) {
				Integer int1 = Integer.valueOf(o1);
				Integer int2 = Integer.valueOf(o2);
				return int1.compareTo(int2);
			}
		});
		set.addAll(Arrays.asList(strLocalesExistentes.concat(",").concat(strLocalesInput).split(",")));
		return set;
	}
	
	
	
	@Override
	public void executeAlcanceArticulos(Collection<ArticuloAreaTrabajoNoSqlDTO> colArtAreTraNoSql) throws SICException {
		try{
			if (colArtAreTraNoSql==null || CollectionUtils.isEmpty(colArtAreTraNoSql)){
				return;
			}
			for(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql:colArtAreTraNoSql){
				executeAlcanceArticulos(artAreTraNoSql);
			}
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw new SICException(e);
		} 
		
	}

	@Override
	public void executeAlcanceArticulos(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql) throws SICException {
		try {
			if (artAreTraNoSql==null){
				return;
			}
			if (artAreTraNoSql.getOpcionAsignacion()==null || artAreTraNoSql.getOpcionAsignacion().isEmpty()){// valida q exista opcion asignacion
				return;
			}
			if (artAreTraNoSql.getTipoAsignacionAlcance() == null || artAreTraNoSql.getTipoAsignacionAlcance().isEmpty()){// valida exista tipo asignacion
				return;
			}
			if (artAreTraNoSql.getTipoAreaTrabajo() == null || artAreTraNoSql.getTipoAreaTrabajo().isEmpty()){// valida exista tipo area trabajo
				return;
			}
			if (CollectionUtils.isEmpty(artAreTraNoSql.getSetCodAreTra())){ // valida q exista areas de trabajo 
				return;
			}
			if (artAreTraNoSql.getFechaRegistro()==null){ // valida q existe fecha de registro
				Calendar calendar = Calendar.getInstance(LOCALE_ES);
				artAreTraNoSql.setFechaRegistro(calendar.getTime());
			}

			artAreTraNoSql.setEstadoIntegracionAlcance(SICConstantes.ESTADO_INACTIVO_NUMERICO);// estado integracion inactivo
			
			artAreTraNoSql.setCodigoTipoAsignacion(TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE); // tipo asignacion 

			if (artAreTraNoSql.getValorTipoAsignacion()==null || artAreTraNoSql.getValorTipoAsignacion().isEmpty()){
				artAreTraNoSql.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL); // valor tipo asignacion 
			}

			
			// valida el grupo alcance(prototipo) solo locales deben tener prototipo; 
//			if (artAreTraNoSql.getTipoAreaTrabajo()==null || artAreTraNoSql.getTipoAreaTrabajo().isEmpty()
//					|| !artAreTraNoSql.getTipoAreaTrabajo().equalsIgnoreCase(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL)){
//			//	artAreTraNoSql.setCodigoGrupoAlcance(-1);  // -1 significa no tiene prototipo(grupo alcance)
//			}
				
			if (artAreTraNoSql.getOpcionAsignacion().equalsIgnoreCase(SICConstantes.ALCANCE_OPCION_ANADIR)
					|| artAreTraNoSql.getOpcionAsignacion().equalsIgnoreCase(SICConstantes.ALCANCE_OPCION_REMPLAZAR)){
				Calendar fechaIniAlc = Calendar.getInstance(LOCALE_ES);
				fechaIniAlc.setTime(artAreTraNoSql.getFechaInicialAlcance()); // format yyyy-mm-dd 
				if (fechaIniAlc.compareTo(getFechaActualFormatYearMonthDay())==0
						|| artAreTraNoSql.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"))){  
					// activar estado alcance, // si la fechaInicialAlcance es igual a la fechaActual o si el tipo de asignacion de alcance e Bodega epecificas
					artAreTraNoSql.setEstadoAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					artAreTraNoSql.setIdUsuarioActivacion(artAreTraNoSql.getIdUsuario());
					artAreTraNoSql.setFechaActivacion(artAreTraNoSql.getFechaRegistro());
				}else{
					// desactivar estado alcance
					artAreTraNoSql.setEstadoAlcance(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					artAreTraNoSql.setIdUsuarioInactivacion(artAreTraNoSql.getIdUsuario());
					artAreTraNoSql.setFechaInactivacion(artAreTraNoSql.getFechaRegistro());
				}
				
				this.registrarAlcance(artAreTraNoSql);// registra o reemplaza el alcance
				
			}else if (artAreTraNoSql.getOpcionAsignacion().equalsIgnoreCase(SICConstantes.ALCANCE_OPCION_QUITAR)){
				// quitar alcance
				// activa o desactiva el estado del alcance dependiendo de la fecha final del alcance 
				Calendar fechaFinAlc = Calendar.getInstance(LOCALE_ES);
				fechaFinAlc.setTime(artAreTraNoSql.getFechaFinalAlcance()); // format yyyy-mm-dd 
				if (fechaFinAlc.compareTo(getFechaActualFormatYearMonthDay())==0 
					|| artAreTraNoSql.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"))){  
					// desactiva el estado alcance, si la fechaFinalAlcance es igual a la fechaActual o si el tipo de asignacion de alcance es Bodega especificas
					artAreTraNoSql.setEstadoAlcance(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					artAreTraNoSql.setIdUsuarioInactivacion(artAreTraNoSql.getIdUsuario());
					artAreTraNoSql.setFechaInactivacion(artAreTraNoSql.getFechaRegistro());
				}else{
					// activa estado alcance
					artAreTraNoSql.setEstadoAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					artAreTraNoSql.setIdUsuarioActivacion(artAreTraNoSql.getIdUsuario());
					artAreTraNoSql.setFechaActivacion(artAreTraNoSql.getFechaRegistro());
				}
				
				this.quitarAlcance(artAreTraNoSql);// quita el alcance 
			}

		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw new SICException(e);
		} 
		
	}

	@Override
	public void registrarAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO) throws SICException {
		
		ODatabaseDocumentTx db = null;
//		List<ODocument> lisAlcancesRegistrados=new ArrayList<>(); // contiene todos los alcances registrados para poder registrar los indices
//		List<ODocument> lisBitacoraAlcancesRegistrados=new ArrayList<>(); // contiene todas las bitacoras de alcances registrados para poder registrar los indices
//		List<ODocument> lisArtEstRegistrados=new ArrayList<>(); // contiene todos los articulo establecimiento registrados para despues poder registrar los indices
		
		//mapas para gestionar la relacion grupo alcance en el articulo en DB2		
		//mapa que almacena los articulos q deben ser actualizados el grupo alcance del articulo en DB2
		Map<Integer,List<String>> mapGruAlcArt=new HashMap<Integer,List<String>>(); // clave:grupo alcance, valor: lista codigos de Articulo  
		Map<String,Integer> mapPrototipos=this.articuloAlcanceDAO.getMapVistaPrototipoAlcance(artAreTraNoSqlDTO.getCodigoCompania());// mapa con los prototipos traidos de la vista
		
		//mapa para gestionar articuloEstablecimiento 
		Map<Integer,Integer> mapLocalEstablecimiento=this.articuloAlcanceDAO.getMapLocalEstablecimiento(artAreTraNoSqlDTO.getCodigoCompania());//mapa con los locales y su establecimiento
		try {
			if (artAreTraNoSqlDTO!=null) {
				db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
				this.articuloAlcanceNoSqlDAO.validateCreateIndexAlcances(db);// valida q existan los indices necesarios, si no existen los crea
				
				registrarAlcanceNoSql(artAreTraNoSqlDTO, db, mapGruAlcArt, mapPrototipos,mapLocalEstablecimiento);
				actualizarGrupoAlcanceArticulo(artAreTraNoSqlDTO, mapGruAlcArt);
			}
		} catch (NoSQLException e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw new SICException(e);
		} catch (SICException e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw e;
		} catch (Exception e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal: {}", e.toString());
			throw new SICException(e);
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

//	private void registrarAlcanceNoSql(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, ODatabaseDocumentTx db, Map<Integer, List<String>> mapGruAlcArt, 
//			List<ODocument> lisAlcancesRegistrados, List<ODocument> lisBitacoraAlcancesRegistrados, List<ODocument> lisArtEstRegistrados, Map<String, Integer> mapPrototipos,
//			Map<Integer,Integer> mapLocalEstablecimiento) throws SICException{
	private void registrarAlcanceNoSql(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, ODatabaseDocumentTx db, Map<Integer, List<String>> mapGruAlcArt, 
			Map<String, Integer> mapPrototipos,Map<Integer,Integer> mapLocalEstablecimiento) throws SICException{
		
		String codArticulo="";
		boolean isTipoAsignacionLocalCopiaPrototipo=false;
		if (artAreTraNoSqlDTO.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.local"))
				|| artAreTraNoSqlDTO.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.prototipo"))
				|| artAreTraNoSqlDTO.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia"))){
			isTipoAsignacionLocalCopiaPrototipo=true;
		}

		for (Iterator iterator = artAreTraNoSqlDTO.getSetCodArt().iterator(); iterator.hasNext();) {
			try {
				codArticulo = (String) iterator.next();
				if (artAreTraNoSqlDTO.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.prototipo"))
						&& artAreTraNoSqlDTO.getOpcionAsignacion().equalsIgnoreCase(SICConstantes.ALCANCE_OPCION_REMPLAZAR)){
					// si es alcance por prototipo y la opcion de asignacion es reemplazar
					// quita los alcances del articulo en todas las areas q exista
					quitarAlcance(artAreTraNoSqlDTO, db, codArticulo);
				}
				
				//db.begin();
				for(Integer codAreaTrabajo:artAreTraNoSqlDTO.getSetCodAreTra()){
					db.begin();
					ODocument oDocBitacoraAlcance;
					ODocument articuloAreTraSaved=this.articuloAlcanceNoSqlDAO.findAlcanceUnique(artAreTraNoSqlDTO.getCodigoCompania(), 
									artAreTraNoSqlDTO.getTipoAreaTrabajo(),
									codArticulo, 
									codAreaTrabajo);
					
					if (articuloAreTraSaved!=null){
						
						if (artAreTraNoSqlDTO.getOpcionAsignacion().equalsIgnoreCase(SICConstantes.ALCANCE_OPCION_QUITAR)){
							changeFechaInicialAndFinalAlcance(artAreTraNoSqlDTO, articuloAreTraSaved);// cambia la fecha inicial y final del alcance
						}
						// actualiza alcance
						ODocument oDocArtAreTra=this.articuloAlcanceNoSqlDAO.registrarAlcance(db, codArticulo, codAreaTrabajo,artAreTraNoSqlDTO, ((ODocument)articuloAreTraSaved.field("rid")).getIdentity());
						oDocBitacoraAlcance=this.articuloAlcanceNoSqlDAO.registrarBitacoraAlcance(db, oDocArtAreTra, artAreTraNoSqlDTO.getFechaRegistro());
						db.commit();
						this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloAreatrabajoBitacora(db,oDocBitacoraAlcance);
						//lisBitacoraAlcancesRegistrados.add(oDocBitacoraAlcance);
						// valida si la fecha inicial alcance recibida es diferente a la fecha inicial alcance guardado 
						// entonces borrar y registrar indiceFechaIniAlcRidArtLoc 
						if (articuloAreTraSaved.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE)!=null 
								&& !String.valueOf(articuloAreTraSaved.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE)).isEmpty()){
							if (isFechasDiferentes((Date)articuloAreTraSaved.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE), artAreTraNoSqlDTO.getFechaInicialAlcance())){
								// borrar indice y registrar con nueva fecha ini
								this.articuloAlcanceNoSqlDAO.borrarRegistrarIndiceFechaIniAlcRidArtLoc(db, articuloAreTraSaved, oDocArtAreTra);
							}
						}
						// valida si la fecha final alcance recibida es diferente a la fecha final alcance guardado 
						// entonces borrar y registrar indiceFechaFinAlcRidArtLoc 
						if (articuloAreTraSaved.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE)!=null 
								&& !String.valueOf(articuloAreTraSaved.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE)).isEmpty()){
							if (isFechasDiferentes((Date)articuloAreTraSaved.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE), artAreTraNoSqlDTO.getFechaInicialAlcance())){
								// borrar indice y registrar con nueva fecha fin
								this.articuloAlcanceNoSqlDAO.borrarRegistrarIndiceFechaFinAlcRidArtLoc(db, articuloAreTraSaved, oDocArtAreTra);
							}
						}
					}else{
						if (!artAreTraNoSqlDTO.getOpcionAsignacion().equalsIgnoreCase(SICConstantes.ALCANCE_OPCION_QUITAR)){
							// crea alcance
							ODocument oDocArtAreTra=this.articuloAlcanceNoSqlDAO.registrarAlcance(db, codArticulo, codAreaTrabajo,artAreTraNoSqlDTO, null);
							oDocBitacoraAlcance=this.articuloAlcanceNoSqlDAO.registrarBitacoraAlcance(db, oDocArtAreTra, artAreTraNoSqlDTO.getFechaRegistro());
							db.commit();
							this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloAreatrabajo(db,oDocArtAreTra);
							this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloAreatrabajoBitacora(db,oDocBitacoraAlcance);
//							lisAlcancesRegistrados.add(oDocArtAreTra);
//							lisBitacoraAlcancesRegistrados.add(oDocBitacoraAlcance);
						}
					}
				}
				LOG_SICV2.info("articulo "+codArticulo);
				
				//db.commit();
				// despues de dar alcance
				if (isTipoAsignacionLocalCopiaPrototipo){
					// verifica si el articulo necesita cambiar de prototipo (si encaja en algun prototipo) y lo carga en el mapa (mapGruAlcArt).
					cargarMapaPrototipoArticulos(artAreTraNoSqlDTO, mapGruAlcArt, mapPrototipos, codArticulo);
					//registrarArticuloEstablecimiento
					// registra con el estado inactivo
					String strLocalesExistentesAlcanceInactivo=this.articuloAlcanceNoSqlDAO.findLocalesArticuloAsString(artAreTraNoSqlDTO.getCodigoCompania(), codArticulo,0);// locales en los cuales existe alcance en estado inactivo para el articulo.
					registrarArticuloEstablecimiento(artAreTraNoSqlDTO, db, mapLocalEstablecimiento, codArticulo, strLocalesExistentesAlcanceInactivo, 0);
					// registra con el estado activo
					String strLocalesExistentesAlcanceActivo=this.articuloAlcanceNoSqlDAO.findLocalesArticuloAsString(artAreTraNoSqlDTO.getCodigoCompania(), codArticulo,1);// locales en los cuales existe alcance en estado activo para el articulo.
					registrarArticuloEstablecimiento(artAreTraNoSqlDTO, db, mapLocalEstablecimiento, codArticulo, strLocalesExistentesAlcanceActivo, 1);

				}
			} catch (SICException e) {
				LOG_SICV2.info("error alcance articulo "+codArticulo);
			}			
		}
	}

	private boolean isFechasDiferentes(Date fecha1,Date fecha2){
		if (fecha1 != null && fecha2 != null){
			Calendar calFecha1=Calendar.getInstance(LOCALE_ES);
			calFecha1.setTime(fecha1);
			Calendar calFecha2=Calendar.getInstance(LOCALE_ES);
			calFecha2.setTime(fecha2);
			if (calFecha1.compareTo(calFecha2)!=0){
				return true;
			}
		}
		return false;
	}
	
//	private void registrarArticuloEstablecimiento(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, ODatabaseDocumentTx db, Map<Integer, Integer> mapLocalEstablecimiento, 
//			String codArticulo, String strLocalesExistentes,Integer estado,List<ODocument> lisArtEstRegistrados) {
	private void registrarArticuloEstablecimiento(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, ODatabaseDocumentTx db, Map<Integer, Integer> mapLocalEstablecimiento, 
			String codArticulo, String strLocalesExistentes,Integer estado) {
		if (strLocalesExistentes!=null && !strLocalesExistentes.isEmpty()){
			for(String strCodAreTra:strLocalesExistentes.split(",")){
				if (mapLocalEstablecimiento.get(Integer.parseInt(strCodAreTra))!=null){
				ODocument oDocArtEst= this.articuloAlcanceNoSqlDAO.findArticuloEstablecimientoUnique(artAreTraNoSqlDTO.getCodigoCompania(), 
						codArticulo, 
						mapLocalEstablecimiento.get(Integer.parseInt(strCodAreTra)));
				if (oDocArtEst==null){
					//registrar
					ODocument oDocArtEstInserted=this.articuloAlcanceNoSqlDAO.registrarArticuloEstablecimiento(db, codArticulo, 
							mapLocalEstablecimiento.get(Integer.parseInt(strCodAreTra)),estado, artAreTraNoSqlDTO, null);
					
					this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloEstablecimiento(db,oDocArtEstInserted);

					//lisArtEstRegistrados.add(oDocArtEstInserted);
				}else{
					//actualizar
					this.articuloAlcanceNoSqlDAO.registrarArticuloEstablecimiento(db, codArticulo, 
							mapLocalEstablecimiento.get(Integer.parseInt(strCodAreTra)),estado, artAreTraNoSqlDTO,((ODocument)oDocArtEst.field("rid")).getIdentity());
				}
				}
			}
		}
	}

	
//	private void quitarAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, ODatabaseDocumentTx db, List<ODocument> lisBitacoraAlcancesRegistrados, String codArticulo) throws SICException{
	private void quitarAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, ODatabaseDocumentTx db, String codArticulo) throws SICException{	
		String strLocalesExistentes=this.articuloAlcanceNoSqlDAO.findLocalesArticuloAsString(artAreTraNoSqlDTO.getCodigoCompania(), codArticulo,null);// locales en los cuales existe registrado alcance para el articulo q se esta recorriendo (OrientDB)
		if (strLocalesExistentes!=null && !strLocalesExistentes.isEmpty()){
			db.begin();
			//desactivar los q ya se encuentran dado alcance
			for(String strCodAreTra:strLocalesExistentes.split(",")){
				ODocument oDocBitacoraAlcance;
				ODocument articuloAreTra=this.articuloAlcanceNoSqlDAO.findAlcanceUnique(artAreTraNoSqlDTO.getCodigoCompania(), 
								artAreTraNoSqlDTO.getTipoAreaTrabajo(),
								codArticulo, 
								Integer.parseInt(strCodAreTra));
				if (articuloAreTra!=null){
					// desactivar estado alcance
					articuloAreTra.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL,SICConstantes.ESTADO_INACTIVO_NUMERICO);
					articuloAreTra.field(ArticuloLocalFields.ID_USUARIO_INACTIVACION,artAreTraNoSqlDTO.getIdUsuario());
					articuloAreTra.field(ArticuloLocalFields.FECHA_INACTIVACION,artAreTraNoSqlDTO.getFechaRegistro());
					articuloAreTra.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE,sumarFechasDias(getFechaActualFormatYearMonthDay().getTime(), -1));
					articuloAreTra.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE,getFechaActualFormatYearMonthDay().getTime());
					// actualiza alcance
					ODocument oDocArtAreTra=this.articuloAlcanceNoSqlDAO.updateAlcance(db, codArticulo, Integer.parseInt(strCodAreTra),articuloAreTra);
					oDocBitacoraAlcance=this.articuloAlcanceNoSqlDAO.registrarBitacoraAlcance(db, oDocArtAreTra, artAreTraNoSqlDTO.getFechaRegistro());
//					lisBitacoraAlcancesRegistrados.add(oDocBitacoraAlcance);
				}
			}	
			db.commit();
		}
	}

	private void changeFechaInicialAndFinalAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, ODocument articuloAreTra) throws SICException{
		if (articuloAreTra.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE)==null 
				|| String.valueOf(articuloAreTra.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE)).isEmpty()){
			artAreTraNoSqlDTO.setFechaInicialAlcance(sumarFechasDias(artAreTraNoSqlDTO.getFechaFinalAlcance(), -1));
		}else{
			Date dateFechaIniAlcSaved=(Date)articuloAreTra.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE); 
			if (dateFechaIniAlcSaved==null){
				artAreTraNoSqlDTO.setFechaInicialAlcance(sumarFechasDias(artAreTraNoSqlDTO.getFechaFinalAlcance(), -1));
			}else{
				Calendar fechaIniAlcSaved=Calendar.getInstance(LOCALE_ES);
				fechaIniAlcSaved.setTime(dateFechaIniAlcSaved);
				Calendar fechaQuitarAlcInput = Calendar.getInstance(LOCALE_ES);
				fechaQuitarAlcInput.setTime(artAreTraNoSqlDTO.getFechaFinalAlcance()); // format yyyy-mm-dd 
				if (fechaIniAlcSaved.compareTo(fechaQuitarAlcInput)>=0){
					artAreTraNoSqlDTO.setFechaInicialAlcance(sumarFechasDias(artAreTraNoSqlDTO.getFechaFinalAlcance(), -1));
				}else{
					artAreTraNoSqlDTO.setFechaInicialAlcance(dateFechaIniAlcSaved);
				}
			}
		}
	}
	
	private void registrarAlcancePorCopiaNoSql(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, List<ODocument> lisArticuloLocal,ODatabaseDocumentTx db,
			 Map<Integer, List<String>> mapGruAlcArt, Map<String, Integer> mapPrototipos,Map<Integer,Integer> mapLocalEstablecimiento) throws SICException {
		
		String codArticulo="";
		boolean cargarMapaPrototipoArticulo=false;
		if (artAreTraNoSqlDTO.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.local"))
				|| artAreTraNoSqlDTO.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.prototipo"))
				|| artAreTraNoSqlDTO.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia"))){
			cargarMapaPrototipoArticulo=true;
		}
		
		for(ODocument oDoc:lisArticuloLocal){
			try {
				db.begin();
				codArticulo=String.valueOf(oDoc.field(ArticuloLocalFields.CODIGO_ARTICULO));
				// area de trabajo destino 
				Integer codAreTraDestino=artAreTraNoSqlDTO.getSetCodAreTra().iterator().next();
				ODocument oDocBitacoraAlcance;
				// consulta si ya existe registrado el alcance
				ODocument articuloAreTraSaved=this.articuloAlcanceNoSqlDAO.findAlcanceUnique(artAreTraNoSqlDTO.getCodigoCompania(), 
								artAreTraNoSqlDTO.getTipoAreaTrabajo(),
								codArticulo, 
								codAreTraDestino);
				if (articuloAreTraSaved!=null){
					// actualiza alcance
					ODocument oDocArtAreTra=this.articuloAlcanceNoSqlDAO.registrarAlcance(db, codArticulo, codAreTraDestino,artAreTraNoSqlDTO, ((ODocument)articuloAreTraSaved.field("rid")).getIdentity());
					oDocBitacoraAlcance=this.articuloAlcanceNoSqlDAO.registrarBitacoraAlcance(db, oDocArtAreTra, artAreTraNoSqlDTO.getFechaRegistro());
					db.commit();
					this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloAreatrabajoBitacora(db,oDocBitacoraAlcance);
				//	lisBitacoraAlcancesRegistrados.add(oDocBitacoraAlcance);
					// valida si la fecha inicial alcance recibida es diferente a la fecha inicial alcance guardado 
					// entonces borrar y registrar el indice indiceFechaIniAlcRidArtLoc 
					if (articuloAreTraSaved.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE)!=null 
							&& !String.valueOf(articuloAreTraSaved.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE)).isEmpty()){
						if (isFechasDiferentes((Date)articuloAreTraSaved.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE), artAreTraNoSqlDTO.getFechaInicialAlcance())){
							// borrar indice y registrar con nueva fecha ini
							this.articuloAlcanceNoSqlDAO.borrarRegistrarIndiceFechaIniAlcRidArtLoc(db, articuloAreTraSaved, oDocArtAreTra);
						}
					}
					// valida si la fecha final alcance recibida es diferente a la fecha final alcance guardado 
					// entonces borrar y registrar el indice indiceFechaFinAlcRidArtLoc 
					if (articuloAreTraSaved.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE)!=null 
							&& !String.valueOf(articuloAreTraSaved.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE)).isEmpty()){
						if (isFechasDiferentes((Date)articuloAreTraSaved.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE), artAreTraNoSqlDTO.getFechaInicialAlcance())){
							// borrar indice y registrar con nueva fecha fin
							this.articuloAlcanceNoSqlDAO.borrarRegistrarIndiceFechaFinAlcRidArtLoc(db, articuloAreTraSaved, oDocArtAreTra);
						}
					}
					
				}else{
					// crea alcance
					ODocument oDocArtAreTra=this.articuloAlcanceNoSqlDAO.registrarAlcance(db, codArticulo, codAreTraDestino,artAreTraNoSqlDTO, null);
					oDocBitacoraAlcance=this.articuloAlcanceNoSqlDAO.registrarBitacoraAlcance(db, oDocArtAreTra, artAreTraNoSqlDTO.getFechaRegistro());
					
					db.commit();
					this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloAreatrabajo(db,oDocArtAreTra);
					this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloAreatrabajoBitacora(db,oDocBitacoraAlcance);
					//lisAlcancesRegistrados.add(oDocArtAreTra);
					//lisBitacoraAlcancesRegistrados.add(oDocBitacoraAlcance);
				}
				//LOG_SICV2.info("articulo copia "+codArticulo);
				//db.commit();
				
				if (cargarMapaPrototipoArticulo){
					// verifica si el articulo necesita cambiar de prototipo (si encaja en algun prototipo) y lo carga en el mapa (mapGruAlcArt).
					cargarMapaPrototipoArticulos(artAreTraNoSqlDTO, mapGruAlcArt, mapPrototipos, codArticulo);
					
					//registrarArticuloEstablecimiento
					// registra con el estado inactivo
					String strLocalesExistentesAlcanceInactivo=this.articuloAlcanceNoSqlDAO.findLocalesArticuloAsString(artAreTraNoSqlDTO.getCodigoCompania(), codArticulo,0);// locales en los cuales existe alcance en estado inactivo para el articulo.
					registrarArticuloEstablecimiento(artAreTraNoSqlDTO, db, mapLocalEstablecimiento, codArticulo, strLocalesExistentesAlcanceInactivo, 0);
					// registra con el estado activo
					String strLocalesExistentesAlcanceActivo=this.articuloAlcanceNoSqlDAO.findLocalesArticuloAsString(artAreTraNoSqlDTO.getCodigoCompania(), codArticulo,1);// locales en los cuales existe alcance en estado activo para el articulo.
					registrarArticuloEstablecimiento(artAreTraNoSqlDTO, db, mapLocalEstablecimiento, codArticulo, strLocalesExistentesAlcanceActivo, 1);
				}	
				
			} catch (SICException e) {
				LOG_SICV2.info("error articulo copia "+codArticulo);
			}
		}
		
	}
	

	@Override
	public void quitarAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO) throws SICException {
		ODatabaseDocumentTx db = null;
		//mapa que almacena los articulos q deben ser actualizados el grupo alcance del articulo en DB2
		Map<Integer,List<String>> mapGruAlcArt=new HashMap<Integer,List<String>>(); // clave:grupo alcance, valor: codigo Articulo
//		List<ODocument> lisBitacoraAlcancesRegistrados=new ArrayList<>(); // contiene todas las bitacoras de alcances registrados para poder registrar los indices
//		List<ODocument> lisArtEstRegistrados=new ArrayList<>(); // contiene todos los articulo establecimiento registrados para despues poder registrar los indices
		// mapa con los prototipos traidos de la vista
		Map<String,Integer> mapPrototipos=this.articuloAlcanceDAO.getMapVistaPrototipoAlcance(artAreTraNoSqlDTO.getCodigoCompania());
		//mapa para gestionar articuloEstablecimiento 
		Map<Integer,Integer> mapLocalEstablecimiento=this.articuloAlcanceDAO.getMapLocalEstablecimiento(artAreTraNoSqlDTO.getCodigoCompania());//mapa con los locales y su establecimiento
		try {
			if (artAreTraNoSqlDTO!=null) {
				db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
				this.articuloAlcanceNoSqlDAO.validateCreateIndexAlcances(db);// valida q existan los indices necesarios, si no existen los crea

				registrarAlcanceNoSql(artAreTraNoSqlDTO, db, mapGruAlcArt, mapPrototipos, mapLocalEstablecimiento);
				actualizarGrupoAlcanceArticulo(artAreTraNoSqlDTO, mapGruAlcArt);
			}
		} catch (NoSQLException e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al quitarAlcance: {}", e.toString());
			throw new SICException(e);
		} catch (SICException e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al quitarAlcance: {}", e.toString());
			throw e;
		} catch (Exception e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al quitarAlcance: {}", e.toString());
			throw new SICException(e);
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	
	public static Date sumarFechasDias(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }

	@Override
	public List<ArticuloLocalDTO> findAlcanceArticulo(Integer codCompania, String tipAreTra, String codigoArticulo, Integer estado) throws SICException {
		ODatabaseDocumentTx db = null;
		List<ArticuloLocalDTO> lisArtLocDTO;
		try {
			db = simpleOrientDocumentDbManager.getCurrentDatabase();
			lisArtLocDTO=this.articuloAlcanceNoSqlDAO.findAlcanceArticulo(codCompania, tipAreTra, codigoArticulo, estado);
		} catch (Exception e) {
			LOG_SICV2.error("Error al buscar el alcance de articulos. findAlcanceArticulo");
			throw new SICException(e);
		} finally{
			if (db != null) {
				db.close();
			}
		}	
		return lisArtLocDTO;	
	}

	@Override
	public Set<String> getArticulosPruebaAlcance() throws SICException {
		return this.articuloAlcanceDAO.getArticulosPruebaAlcance();
	}

	
	
	
	@Override
	public List<ODocument> findAlcancesEnAreaTrabajo(Integer codigoCompania, String tipAreaTrabajo, 
			Integer codAreaTrabajo,String codArticulo,Integer skip,Integer limit) throws SICException {
		ODatabaseDocumentTx db = null;
		List<ODocument> oDoc;
		try {
			db = simpleOrientDocumentDbManager.getCurrentDatabase();
			oDoc=this.articuloAlcanceNoSqlDAO.findAlcancesEnAreaTrabajo(codigoCompania, tipAreaTrabajo, codAreaTrabajo,codArticulo,skip,limit);
		} catch (Exception e) {
			LOG_SICV2.error("Error al buscar el alcance de articulos. findAlcancesEnAreaTrabajo");
			throw new SICException(e);
		} finally{
			if (db != null) {
				db.close();
			}
		}	
		return oDoc;	
	}

	

	@Override
	public Integer getNumRegistrosAlcanceEnAreaTrabajo(Integer codigoCompania, String tipAreaTrabajo, Integer codAreaTrabajo, String codArticulo) throws SICException {
		ODatabaseDocumentTx db = null;
		Integer numReg=0;
		try {
			numReg=this.articuloAlcanceNoSqlDAO.getNumRegistrosAlcanceEnAreaTrabajo(codigoCompania, tipAreaTrabajo, codAreaTrabajo, codArticulo);
		} catch (Exception e) {
			LOG_SICV2.error("Error al obtener numero registros alcance en area trabajo getNumRegistrosAlcanceEnAreaTrabajo");
			throw new SICException(e);
		} finally{
			if (db != null) {
				db.close();
			}
		}	
		return numReg;
		
	}

	@Override
	public void copiarAlcances(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql,Integer codLocalOrigen) throws SICException {
		LOG_SICV2.info("inicia copia alcance");
		Calendar calendar = Calendar.getInstance(LOCALE_ES);
		String horaIni=calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
		if (artAreTraNoSql==null){
			return;
		}
		if (artAreTraNoSql.getTipoAsignacionAlcance() == null || artAreTraNoSql.getTipoAsignacionAlcance().isEmpty()){// valida exista tipo asignacion
			return;
		}
		if (artAreTraNoSql.getTipoAreaTrabajo() == null || artAreTraNoSql.getTipoAreaTrabajo().isEmpty()){// valida exista tipo area trabajo
			return;
		}
		if (CollectionUtils.isEmpty(artAreTraNoSql.getSetCodAreTra())){ // valida q exista area de trabajo destino
			return;
		}
		if (codLocalOrigen==null){// valida q exista codigoLocal Origen
			return;
		}
		if (artAreTraNoSql.getFechaRegistro()==null){ // valida q existe fecha de registro
			artAreTraNoSql.setFechaRegistro(calendar.getTime());
		}
		
		if (artAreTraNoSql.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia"))
				|| artAreTraNoSql.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina"))){
			artAreTraNoSql.setEstadoIntegracionAlcance(SICConstantes.ESTADO_INACTIVO_NUMERICO);// estado integracion inactivo	
			
			Calendar fechaIniAlc = Calendar.getInstance(LOCALE_ES);
			fechaIniAlc.setTime(artAreTraNoSql.getFechaInicialAlcance()); // format yyyy-mm-dd 
			if (fechaIniAlc.compareTo(getFechaActualFormatYearMonthDay())==0){  
				// activar estado alcance, // si la fechaInicialAlcance es igual a la fechaActual 
				artAreTraNoSql.setEstadoAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				artAreTraNoSql.setIdUsuarioActivacion(artAreTraNoSql.getIdUsuario());
				artAreTraNoSql.setFechaActivacion(artAreTraNoSql.getFechaRegistro());
			}else{
				// desactivar estado alcance
				artAreTraNoSql.setEstadoAlcance(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				artAreTraNoSql.setIdUsuarioInactivacion(artAreTraNoSql.getIdUsuario());
				artAreTraNoSql.setFechaInactivacion(artAreTraNoSql.getFechaRegistro());
			}

			
			Integer numReg=this.articuloAlcanceNoSqlDAO.getNumRegistrosAlcanceEnAreaTrabajo(artAreTraNoSql.getCodigoCompania(), artAreTraNoSql.getTipoAreaTrabajo(), codLocalOrigen,null);
			Integer numRegistrosXTrama=1000;
			Integer numTramas=1;
			if (numReg>numRegistrosXTrama){
				numTramas=(numReg/numRegistrosXTrama);
				if ((numTramas*numRegistrosXTrama)<numReg){
					numTramas++;
				}
			}
			// mapa de la vista de prototipos. clave:Combinacion locales orden ascendente; valor:codigoGrupoAlcance
			Map<String,Integer> mapPrototipos=this.articuloAlcanceDAO.getMapVistaPrototipoAlcance(artAreTraNoSql.getCodigoCompania());
			//mapa para gestionar articuloEstablecimiento 
			Map<Integer,Integer> mapLocalEstablecimiento=this.articuloAlcanceDAO.getMapLocalEstablecimiento(artAreTraNoSql.getCodigoCompania());//mapa con los locales y su establecimiento

			if (CollectionUtils.isEmpty(artAreTraNoSql.getSetCodArt())){
				for (int i=0;i<numTramas;i++){
					// copia sin filtros de la seccion 1 de pantalla de alcances
					List<ODocument> lisArtLocDTO=this.findAlcancesEnAreaTrabajo(artAreTraNoSql.getCodigoCompania(), artAreTraNoSql.getTipoAreaTrabajo(), 
							codLocalOrigen,null,(i*numRegistrosXTrama),numRegistrosXTrama);//lista registros a copiar
					this.registrarAlcancePorCopia(artAreTraNoSql, lisArtLocDTO,mapPrototipos,mapLocalEstablecimiento);
				}
			}else{
				List<ODocument> lisArtLocDTO=new ArrayList<>();//lista registros a copiar
				// copia con filtros de la seccion 1 de pantalla de alcances
				for (String codArt:artAreTraNoSql.getSetCodArt()){
					List<ODocument> lis=this.findAlcancesEnAreaTrabajo(artAreTraNoSql.getCodigoCompania(), artAreTraNoSql.getTipoAreaTrabajo(), codLocalOrigen,codArt,null,null);
					if (!CollectionUtils.isEmpty(lis)){
						lisArtLocDTO.add(lis.get(0));
					}
				}
				this.registrarAlcancePorCopia(artAreTraNoSql, lisArtLocDTO,mapPrototipos,mapLocalEstablecimiento);
			}
			
		}
		Calendar calendarFin = Calendar.getInstance(LOCALE_ES);
		String horaFin=calendarFin.get(Calendar.HOUR_OF_DAY)+":"+calendarFin.get(Calendar.MINUTE)+":"+calendarFin.get(Calendar.SECOND);
		LOG_SICV2.info("fin copia alcance "+horaIni+" / "+horaFin);
		
	}
	
	/**
	 * Para registrar alcances por copia 
	 * @param artAreTraNoSql
	 * @param lisArticuloLocal
	 * @throws SICException
	 */
	private void registrarAlcancePorCopia(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql,List<ODocument> lisArticuloLocal,Map<String,Integer> mapPrototipos,Map<Integer,Integer> mapLocalEstablecimiento) throws SICException {
		
		ODatabaseDocumentTx db = null;
		//mapa que almacena los articulos q deben ser actualizados el grupo alcance del articulo en DB2
		Map<Integer,List<String>> mapGruAlcArt=new HashMap<Integer,List<String>>(); // clave:grupo alcance, valor: conjunto codigos Articulo  
//		List<ODocument> lisAlcancesRegistrados=new ArrayList<>(); // contiene todos los alcances registrados para poder registrar los indices
//		List<ODocument> lisBitacoraAlcancesRegistrados=new ArrayList<>(); // contiene todas las bitacoras de alcances registrados para poder registrar los indices
//		List<ODocument> lisArtEstRegistrados=new ArrayList<>(); // contiene todos los articulo establecimiento registrados para despues poder registrar los indices
//		// mapa de la vista de prototipos. clave:Combinacion locales orden ascendente; valor:codigoGrupoAlcance
//		Map<String,Integer> mapPrototipos=this.articuloAlcanceDAO.getMapVistaPrototipoAlcance(artAreTraNoSql.getCodigoCompania());
//		//mapa para gestionar articuloEstablecimiento 
//		Map<Integer,Integer> mapLocalEstablecimiento=this.articuloAlcanceDAO.getMapLocalEstablecimiento(artAreTraNoSql.getCodigoCompania());//mapa con los locales y su establecimiento
		try {
			if (artAreTraNoSql!=null) {
				db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
				this.articuloAlcanceNoSqlDAO.validateCreateIndexAlcances(db);// valida q existan los indices necesarios, si no existen los crea
				registrarAlcancePorCopiaNoSql(artAreTraNoSql, lisArticuloLocal, db, mapGruAlcArt, mapPrototipos,mapLocalEstablecimiento);
				// actualiza el grupo alcance a los articulos en DB2 si fuese el caso
				//actualizarGrupoAlcanceArticulo(artAreTraNoSql, mapGruAlcArt);
			}
		} catch (NoSQLException e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal por copia: {}", e.toString());
			throw new SICException(e);
		} catch (SICException e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal por copia: {}", e.toString());
			throw e;
		} catch (Exception e) {
			db.rollback(); //solo se hace rollback de lo que esta dentro de la transaccion
			Logeable.LOG_SICV2.error("Ocurrio un error al registrarArticuloLocal por copia: {}", e.toString());
			throw new SICException(e);
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	/**
	 * metodo q actualiza el grupo alcance en la tabla SCSPETARTICULO en DB2.
	 * @param artAreTraNoSql
	 * @param mapGruAlcArt
	 */
	private void actualizarGrupoAlcanceArticulo(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql, Map<Integer, List<String>> mapGruAlcArt) throws SICException {
		int numRegUpdate=100;// numero de registros para update
		for (Entry<Integer, List<String>> e:mapGruAlcArt.entrySet()){
			int numTramas = 1;
			if (mapGruAlcArt.get(e.getKey()).size()>numRegUpdate){
				numTramas = mapGruAlcArt.get(e.getKey()).size()/numRegUpdate;
				if ((numTramas*numRegUpdate)<mapGruAlcArt.get(e.getKey()).size()){
					numTramas=numTramas+1;
				}
			}
			int limSup=0;
			for(int i=0;i<numTramas;i++){
				try {
					if (i==numTramas-1){
						limSup=mapGruAlcArt.get(e.getKey()).size();
					}else{
						limSup=(i*numRegUpdate)+numRegUpdate;
					}
					this.articuloAlcanceDAO.updateGrupoAlcanceArticulo(artAreTraNoSql.getCodigoCompania(), 
							e.getKey(), 
							mapGruAlcArt.get(e.getKey()).subList(i*numRegUpdate, limSup),
							new Timestamp(artAreTraNoSql.getFechaRegistro().getTime()),
							artAreTraNoSql.getIdUsuario());
				} catch (Exception e2) {
					LOG_SICV2.error("Error al actualizar el grupo alcance en DB2 "+mapGruAlcArt.get(e.getKey()).subList(i*numRegUpdate, limSup)+": {}",e.toString());
				}
			}
		}
		
//		for (Entry<Integer, List<String>> e:mapGruAlcArt.entrySet()){
//			int numTramas = 1;
//			if (mapGruAlcArt.get(e.getKey()).size()>numRegUpdate){
//				numTramas = mapGruAlcArt.get(e.getKey()).size()/numRegUpdate;						
//				for(int i=0;i<numTramas;i++){
//					if (i==numTramas-1){
//						this.articuloAlcanceDAO.updateGrupoAlcanceArticulo(artAreTraNoSql.getCodigoCompania(), 
//								e.getKey(), 
//								mapGruAlcArt.get(e.getKey()).subList(i*numRegUpdate, mapGruAlcArt.get(e.getKey()).size()),
//								new Timestamp(artAreTraNoSql.getFechaRegistro().getTime()),
//								artAreTraNoSql.getIdUsuario());
//					}else{
//						this.articuloAlcanceDAO.updateGrupoAlcanceArticulo(artAreTraNoSql.getCodigoCompania(), 
//								e.getKey(), 
//								mapGruAlcArt.get(e.getKey()).subList(i*numRegUpdate, ((i*numRegUpdate)+numRegUpdate)),
//								new Timestamp(artAreTraNoSql.getFechaRegistro().getTime()),
//								artAreTraNoSql.getIdUsuario());
//					}
//				}
//			}else{
//				this.articuloAlcanceDAO.updateGrupoAlcanceArticulo(artAreTraNoSql.getCodigoCompania(), 
//						e.getKey(), 
//						mapGruAlcArt.get(e.getKey()),
//						new Timestamp(artAreTraNoSql.getFechaRegistro().getTime()),
//						artAreTraNoSql.getIdUsuario());
//			}
//		}
	}


	private void cargarMapaPrototipoArticulos(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql, Map<Integer, List<String>> mapGruAlcArt, 
			Map<String, Integer> mapPrototipos, String codArticulo) throws SICException{
		List<String> setArt;
		Integer codGrupoAlcance;
		if (artAreTraNoSql.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.local"))
			|| artAreTraNoSql.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.prototipo"))
			|| artAreTraNoSql.getTipoAsignacionAlcance().equalsIgnoreCase(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia"))){
			//String strLocalesInput=StringUtils.join(artAreTraNoSql.getSetCodAreTra(), ",");// locales recibidos para dar alcance
			// locales en los cuales existe dado alcance con estado alcance activo del articulo q se esta recorriendo (OrientDB)
			String strLocalesExistentes=this.articuloAlcanceNoSqlDAO.findLocalesArticuloAsString(artAreTraNoSql.getCodigoCompania(), codArticulo,1);
//			String strLocalesMerge=""; // union de los locales recibios con los locales existentes ordenados ascendentemente
//			if (strLocalesExistentes==null || strLocalesExistentes.isEmpty()){
//				strLocalesMerge=strLocalesInput;
//			}else{
//				strLocalesMerge=StringUtils.join(getConjuntoLocalesUnion(strLocalesInput, strLocalesExistentes),",");
//			}
			//se obtiene el prototipo que coincida con la conbinacion de locales recibidos y existentes en OrientDB
			//codGrupoAlcance=mapPrototipos.get(strLocalesMerge);
			codGrupoAlcance=mapPrototipos.get(strLocalesExistentes);
			if (codGrupoAlcance!=null){
				setArt=new ArrayList<>();
				if (!CollectionUtils.isEmpty(mapGruAlcArt.get(codGrupoAlcance))){
					setArt=mapGruAlcArt.get(codGrupoAlcance);
					setArt.add(codArticulo);
					mapGruAlcArt.put(codGrupoAlcance,setArt);
				}else{
					setArt.add(codArticulo);
					mapGruAlcArt.put(codGrupoAlcance,setArt);
				}
			}else{
				setArt=new ArrayList<>();
				if (!CollectionUtils.isEmpty(mapGruAlcArt.get(Integer.valueOf(String.valueOf(SICArticuloConstantes.CODIGOPROTOTIPOPERSONALIZADO))))){
					setArt=mapGruAlcArt.get(Integer.valueOf(String.valueOf(SICArticuloConstantes.CODIGOPROTOTIPOPERSONALIZADO)));
					setArt.add(codArticulo);
					mapGruAlcArt.put(Integer.valueOf(String.valueOf(SICArticuloConstantes.CODIGOPROTOTIPOPERSONALIZADO)),setArt);
				}else{
					setArt.add(codArticulo);
					mapGruAlcArt.put(Integer.valueOf(String.valueOf(SICArticuloConstantes.CODIGOPROTOTIPOPERSONALIZADO)),setArt);
				}
			}
		}
	}
	

/*	private void registrarIndicesAlcancesNoSql(ODatabaseDocumentTx db, List<ODocument> lisAlcancesRegistrados, 
			List<ODocument> lisBitacoraAlcancesRegistrados) throws SICException {
		
		LOG_SICV2.info("indices");
		// registra indices de ArticuloLocalDTO
		if (lisAlcancesRegistrados!=null){
			for(ODocument oDocArtAreTra:lisAlcancesRegistrados){
				this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloAreatrabajo(db, 
						Integer.valueOf(String.valueOf(oDocArtAreTra.field(ArticuloLocalFields.CODIGO_COMPANIA))), 
						String.valueOf(oDocArtAreTra.field(ArticuloLocalFields.CODIGO_ARTICULO)), 
						Integer.valueOf(String.valueOf(oDocArtAreTra.field(ArticuloLocalFields.CODIGO_LOCAL))), 
						String.valueOf(oDocArtAreTra.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO)), 
						oDocArtAreTra.getIdentity());
			}
		}
		
		// registra indices de bitacora articuloLocalDTO
		if (lisBitacoraAlcancesRegistrados!=null){
			for(ODocument oDocBitArtAreTra:lisBitacoraAlcancesRegistrados){
				this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloAreatrabajoBitacora(db, 
						Integer.valueOf(String.valueOf(oDocBitArtAreTra.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA))), 
						String.valueOf(oDocBitArtAreTra.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO)), 
						Integer.valueOf(String.valueOf(oDocBitArtAreTra.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO))), 
						String.valueOf(oDocBitArtAreTra.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_AREA_TRABAJO)), 
						oDocBitArtAreTra.getIdentity());
			}
		}
	}*/

/*	private void registrarIndicesArticuloEstablecimientoNoSql(ODatabaseDocumentTx db, List<ODocument> lisArtEstRegistrados) throws SICException {
		LOG_SICV2.info("indices articulo establecimiento");
		// registra indices de ArticuloEstablecimientoDTO
		if (lisArtEstRegistrados!=null){
			for(ODocument oDocArtEst:lisArtEstRegistrados){
				this.articuloAlcanceNoSqlDAO.registrarIndicesArticuloEstablecimiento(db, 
						Integer.valueOf(String.valueOf(oDocArtEst.field(ArticuloEstablecimientoFields.CODIGO_COMPANIA))), 
						String.valueOf(oDocArtEst.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO)), 
						Integer.valueOf(String.valueOf(oDocArtEst.field(ArticuloEstablecimientoFields.CODIGO_ESTABLECIMIENTO))), 
						oDocArtEst.getIdentity());
			}
		}
	}*/
	
//	@Override
//	public List<ODocument> findArticuloAreaTrabajo(Integer codigoCompania, String tipAreTra, String codigoArticulo, Integer codigoAreaTrabajo) throws SICException {
//		ODatabaseDocumentTx db = null;
//		List<ODocument> oDoc;
//		try {
//			db = simpleOrientDocumentDbManager.getCurrentDatabase();
//			oDoc=this.articuloLocalODocumentDAO.findArticuloAreaTrabajo(codigoCompania, tipAreTra,codigoArticulo, codigoAreaTrabajo);
//		} catch (Exception e) {
//			LOG_SICV2.error("Error al buscar articulos en el kardex.");
//			throw new SICException(e);
//		} finally{
//			if (db != null) {
//				db.close();
//			}
//		}	
//		return oDoc;		
//	}
	
}

