/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.articulo.alcance.nosql.calculo;

import static ec.com.smx.sic.cliente.common.SICConstantes.ESTADO_INACTIVO_NUMERICO;
import static ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalFields.ESTADO_ARTICULO_LOCAL;
import static ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalIndices.INDEX_AREATRABAJO_ARTICULO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.framework.utilitario.nosql.common.exception.NoSQLException;
import ec.com.smx.framework.utilitario.nosql.orientdb.SimpleOrientDocumentDbManager;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.calculo.ICalculoArticuloAlcanceNoSqlGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAlcanceDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloLocalODocumentDAO;

/**
 * @author wcaiza
 *
 */
public class CalculoArticuloAlcanceNoSqlGestor implements ICalculoArticuloAlcanceNoSqlGestor {
	
	private SimpleOrientDocumentDbManager simpleOrientDocumentDbManager;
	private IArticuloLocalODocumentDAO articuloLocalODocumentDAO;
	private IArticuloAlcanceDAO articuloAlcanceDAO;

	/**
	 * @param simpleOrientDocumentDbManager the simpleOrientDocumentDbManager to set
	 */
	public void setSimpleOrientDocumentDbManager(SimpleOrientDocumentDbManager simpleOrientDocumentDbManager) {
		this.simpleOrientDocumentDbManager = simpleOrientDocumentDbManager;
	}
	
	/**
	 * @param articuloLocalODocumentDAO the articuloLocalODocumentDAO to set
	 */
	public void setArticuloLocalODocumentDAO(IArticuloLocalODocumentDAO articuloLocalODocumentDAO) {
		this.articuloLocalODocumentDAO = articuloLocalODocumentDAO;
	}

	/**
	 * @param articuloAlcanceDAO the articuloAlcanceDAO to set
	 */
	public void setArticuloAlcanceDAO(IArticuloAlcanceDAO articuloAlcanceDAO) {
		this.articuloAlcanceDAO = articuloAlcanceDAO;
	}
	
	@Override
	public Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerColArticuloAreaTrabajoBitacora(String sufijoTabla, Integer codigoCompania, Integer codigoLocal, String... colCodigoArticulo) throws SICException {
		return this.articuloAlcanceDAO.obtenerColArticuloAreaTrabajoBitacoraDTO(sufijoTabla, codigoCompania, codigoLocal, colCodigoArticulo);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.calculo.ICalculoArticuloAlcanceNoSqlGestor#verificarExisteArticuloEnLocal(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public String verificarExisteArticuloEnLocal(Integer codigoCompania, Integer codigoLocal, String codigoArticulo) throws SICException {
		
		ODatabaseDocumentTx db = null;
		String exiteArticulo = ESTADO_INACTIVO_NUMERICO;
		
		try {
			
			db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
			
			List<Object[]> listKey = new ArrayList<>();
			listKey.add(new Object[] {codigoCompania, codigoLocal, codigoArticulo});
			
			Collection<ODocument> colODocumentIndiceArtLoc = this.articuloLocalODocumentDAO.obtenerIndiceLocalArticulo(INDEX_AREATRABAJO_ARTICULO, listKey);
			
			if (CollectionUtils.isNotEmpty(colODocumentIndiceArtLoc)) {
				exiteArticulo = colODocumentIndiceArtLoc.iterator().next().field(ESTADO_ARTICULO_LOCAL).toString();
			}
			
		} catch (NoSQLException e) {
			
			Logeable.LOG_SICV2.error("Ocurrio un error al verificarExisteArticuloEnLocal: {}", e.toString());
			throw new SICException(e);
			
		} finally {
			
			if (db != null) {
				db.close();
			}
			
		}
		return exiteArticulo;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.calculo.ICalculoArticuloAlcanceNoSqlGestor#verificarHayArticuloEnLocal(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public Integer verificarHayArticuloEnLocal(Integer codigoCompania, Integer codigoLocal, String codigoArticulo) throws SICException {
		
		Integer estadoArticulo = 0;
		ODatabaseDocumentTx db = null;
		
		try {
			 
			db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
			estadoArticulo = this.articuloLocalODocumentDAO.obtenerEstadoLocalArticulo(codigoCompania, codigoLocal, codigoArticulo, INDEX_AREATRABAJO_ARTICULO);
			
		} catch (NoSQLException e) {
			
			Logeable.LOG_SICV2.error("Ocurrio un error al verificarExisteArticuloEnLocal: {}", e.toString());
			throw new SICException(e);
			
		} catch (SICException e) {
			
			Logeable.LOG_SICV2.error("Ocurrio un error al verificarExisteArticuloEnLocal: {}", e.toString());
			throw e;
			
		} finally {
			
			if (db != null) {
				db.close();
			}
			
		}
		return estadoArticulo;
	}
	
//	/* (non-Javadoc)
//	 * @see ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.calculo.ICalculoArticuloAlcanceNoSqlGestor#obtenerAreasTrabajoAsignadas(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO, java.lang.Boolean)
//	 */
//	@Override
//	@SuppressWarnings("unchecked")
//	public Collection<ArticuloLocalDTO> obtenerAreasTrabajoAsignadas(ArticuloDTO articuloDTO, Boolean validarEstado) throws SICException {
//		
//		ODatabaseDocumentTx db = null;
//		Collection<ArticuloLocalDTO> coArticuloLocalDTO = new ArrayList<>();
//		
//		try {
//			
//			db = this.simpleOrientDocumentDbManager.getCurrentDatabaseFromPool();
//			
//			List<Object[]> listKey = new ArrayList<>();
//			listKey.add(new Object[] {articuloDTO.getId().getCodigoCompania(), articuloDTO.getId().getCodigoArticulo()});
//			Collection<ODocument> colODocumentIndiceArtLoc = this.articuloLocalODocumentDAO.obtenerIndiceLocalArticulo(INDEX_ARTICULO_AREATRABAJO, listKey);
//			
//			if (CollectionUtils.isNotEmpty(colODocumentIndiceArtLoc)) {
//				
//				Collection<Integer> colCodigoLocal = CollectionUtils.collect(colODocumentIndiceArtLoc, new Transformer() {
//					@Override
//					public Object transform(Object input) {
//						return Integer.valueOf(((ODocument)input).field(ArticuloLocalFields.CODIGO_LOCAL).toString());
//					}
//				});
//				
//				Collection<AreaTrabajoDTO>  colAreaTrabajoDTO = this.articuloAlcanceDAO.consultarDatosAreaTrabajo(
//						articuloDTO.getId().getCodigoCompania(), colCodigoLocal.toArray(new Integer[colCodigoLocal.size()]));
//				
//				this.mapearValoresODocument(coArticuloLocalDTO, colAreaTrabajoDTO, colODocumentIndiceArtLoc);
//				
//			}
//			
//		} finally {
//			
//			if (db != null) {
//				db.close();
//			}
//			
//		}
//		
//		return coArticuloLocalDTO;
//	}
	
	
//	private void mapearValoresODocument (Collection<ArticuloLocalDTO> coArticuloLocalDTO, 
//			Collection<AreaTrabajoDTO>  colAreaTrabajoDTO, Collection<ODocument> colODocumentIndiceArtLoc) {
//		
//		for (ODocument oDocument : colODocumentIndiceArtLoc) {
//			ArticuloLocalDTO articuloLocal = new ArticuloLocalDTO();
//			articuloLocal.getId().setCodigoCompania(Integer.valueOf(oDocument.field(ArticuloLocalFields.CODIGO_COMPANIA).toString()));
//			articuloLocal.getId().setCodigoArticulo(oDocument.field(ArticuloLocalFields.CODIGO_ARTICULO).toString());
//			articuloLocal.getId().setCodigoLocal(Integer.valueOf(oDocument.field(ArticuloLocalFields.CODIGO_LOCAL).toString()));
//			articuloLocal.setEstadoArticuloLocal(oDocument.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL).toString());
//			articuloLocal.setFechaInicialAlcance((Date) oDocument.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE));
//			articuloLocal.setFechaFinalAlcance((Date) oDocument.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE));
//			this.asignarAreaTrabajo(colAreaTrabajoDTO, articuloLocal, articuloLocal.getId().getCodigoLocal());
//			coArticuloLocalDTO.add(articuloLocal);
//			articuloLocal = null;
//		}
//		
//	}
//	
//	private void asignarAreaTrabajo (Collection<AreaTrabajoDTO>  colAreaTrabajoDTO, ArticuloLocalDTO articuloLocal, final Integer codigoAreaTrabajo) {
//		AreaTrabajoDTO areaTrabajoDTO = (AreaTrabajoDTO) CollectionUtils.find(colAreaTrabajoDTO, new Predicate() {
//			@Override
//			public boolean evaluate(Object object) {
//				return Integer.valueOf(ClasesUtil.invocarMetodoGet(object, "id.codigoAreaTrabajo").toString()).intValue() == codigoAreaTrabajo.intValue();
//			}
//		});
//		
//		articuloLocal.setLocal(areaTrabajoDTO);
//	}
	
}
