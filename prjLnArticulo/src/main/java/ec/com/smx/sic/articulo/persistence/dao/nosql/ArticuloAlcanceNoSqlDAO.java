/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.nosql;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.db.record.OTrackedList;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.index.OCompositeKey;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

import ec.com.smx.framework.utilitario.nosql.common.util.ODocumentUtil;
import ec.com.smx.framework.utilitario.nosql.common.util.OIndexUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumClasesArticuloAlcanceNoSql;
import ec.com.smx.sic.cliente.common.articulo.util.ArticuloAlcanceIndexNoSqlUtil;
import ec.com.smx.sic.cliente.common.articulo.util.ArticuloAlcanceNoSqlUtil;
import ec.com.smx.sic.cliente.common.articulo.util.IndiceArticuloAlcanceNoSql;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloAreaTrabajoBitacoraFields;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloEstablecimientoFields;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalFields;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalIndices;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.ArticuloAreaTrabajoNoSqlDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloAlcanceNoSqlDAO;

/**
 * Jul, 27 2015
 * @author bymontesdeoca
 */
public class ArticuloAlcanceNoSqlDAO implements IArticuloAlcanceNoSqlDAO, Logeable {

	
	
	private OCompositeKey articuloAreaTrabajoKey =  new OCompositeKey();
	private OCompositeKey areaTrabajoArticuloKey =  new OCompositeKey();
	private OCompositeKey articuloAreaTrabajoBitKey =  new OCompositeKey();
	private OCompositeKey areaTrabajoArticuloBitKey =  new OCompositeKey();
	private OCompositeKey fecIniKey =  new OCompositeKey();
	private	OCompositeKey fecFinKey =  new OCompositeKey();
	private OCompositeKey fecIniKeyDelete =  new OCompositeKey();
	private	OCompositeKey fecFinKeyDelete =  new OCompositeKey();
	private OCompositeKey artEstKey =  new OCompositeKey();
	private OCompositeKey estArtKey =  new OCompositeKey();

	@Override
	public void validateCreateIndexAlcances(ODatabaseDocumentTx db) throws SICException {
		try {
			// si no existe el indice lo crea
			// articuloLocalDTO
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceAreaTrabajoArticulo(db);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceArticuloAreaTrabajo(db);
//			ArticuloAlcanceIndexNoSqlUtil.getIndiceAreaTrabajoArticuloTipoAreTra(db);
//			ArticuloAlcanceIndexNoSqlUtil.getIndiceArticuloAreaTrabajoTipoAreTra(db);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceFechaIniAlcRidArtLoc(db);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceFechaFinAlcRidArtLoc(db);
			
			//bitacoraArticuloLocalDTO
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceBitRidArtLocRidBitArt(db);
			ArticuloAlcanceIndexNoSqlUtil.getIndiceBitacoraAreaTrabajoArticulo(db);
			ArticuloAlcanceIndexNoSqlUtil.getIndiceBitacoraArticuloAreaTrabajo(db);
			
			// articuloEstablecimientoDTO
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceEstablecimientoArticulo(db);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceArticuloEstablecimiento(db);
			
		} catch (Exception e) {
			LOG_SICV2.error("Error al validar la creacion de indices para alcances: {}", e.toString());
			throw new SICException(e);
		}
			
	}

	@Override
	public List<ArticuloLocalDTO> findAlcanceArticulo(Integer codCompania, String tipAreTra, String codigoArticulo, Integer estado) throws SICException {
		List<ArticuloLocalDTO> lisResult=null; 
		try {
			if (codCompania==null
					|| tipAreTra==null || tipAreTra.isEmpty()
					|| codigoArticulo==null || codigoArticulo.isEmpty()){
				return lisResult;
			}
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from (")
			.append("select rid.* as '' from index:").append(ArticuloLocalIndices.INDEX_ARTICULO_AREATRABAJO)
			.append(" where key=[").append(codCompania)
			.append(",'").append(tipAreTra).append("'")
			.append(",'").append(codigoArticulo).append("'")
			.append("])");
			if (estado!=null){
				sql.append(" where estArtLoc=").append(estado);
			}
			
			final OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<>(sql.toString());
			lisResult=ODocumentUtil.tranformODocumentObject(query.run(), ArticuloLocalDTO.class);
		} catch (Exception e) {
			LOG_SICV2.error("Error en findAlcanceUnique: {}", e.toString());
			throw new SICException(e);
		}
		
		return lisResult;
	}

	@Override
	public Set<String> findLocalesArticuloAsSet(Integer codigoCompania, String codigoArticulo) throws SICException {
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select unionall(codLoc) as codLocAsString from (")
			.append(" select codLoc from (")
			.append(" select rid.codLoc as codLoc,rid.estArtLoc as estArtLoc from index:").append(ArticuloLocalIndices.INDEX_ARTICULO_AREATRABAJO)
			.append(" where key = [").append(codigoCompania)
			.append(",'").append(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL).append("',")
			.append(codigoArticulo)
			.append("])")
			.append(" where estArtLoc=1 order by codLoc asc)");
			
			final OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<>(sql.toString());
			ODocument oDocResult = query.runFirst();
			if (oDocResult!=null){

				Set<String> set=new TreeSet<>(new Comparator<String>() {//ordena ascendente
					@Override
					public int compare(String o1, String o2) {
						Integer int1 = Integer.valueOf(o1);
						Integer int2 = Integer.valueOf(o2);
						return int1.compareTo(int2);
					}
				});
				set.addAll(Arrays.asList(StringUtils.join(((OTrackedList)oDocResult.field("codLocAsString")).toArray(), ",").split(",")));
				return set; 
			}
			
		} catch (Exception e) {
			LOG_SICV2.error("Error en findLocalesArticuloAsString: {}", e.toString());
			throw new SICException(e);
		} 	
		return null;
		
	}



	@Override
	public String findLocalesArticuloAsString(Integer codigoCompania, String codigoArticulo, Integer estadoAlcance) throws SICException {
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select unionall(codLoc) as codLocAsString from (")
			.append(" select codLoc from (")
			.append(" select rid.codLoc as codLoc,rid.estArtLoc as estArtLoc from index:").append(ArticuloLocalIndices.INDEX_ARTICULO_AREATRABAJO)
			.append(" where key = [").append(codigoCompania)
			.append(",'").append(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL).append("',")
			.append(codigoArticulo)
			.append("])");
			if (estadoAlcance!=null){
				sql.append(" where estArtLoc=").append(estadoAlcance);
			}
			sql.append(" order by codLoc asc)");
			
			final OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<>(sql.toString());
			ODocument oDocResult = query.runFirst();
			if (oDocResult!=null){
				return StringUtils.join(((OTrackedList)oDocResult.field("codLocAsString")).toArray(), ",");
			}
			
		} catch (Exception e) {
			LOG_SICV2.error("Error en findLocalesArticuloAsString: {}", e.toString());
			throw new SICException(e);
		} 	
		return "";
	}

	
	

	@Override
	public ODocument findAlcanceUnique(Integer codigoCompania,String tipAreTra, String codigoArticulo, Integer codigoAreaTrabajo) throws SICException {
		ODocument oDocResult=null;
		try {
			if (codigoCompania==null
					|| tipAreTra==null || tipAreTra.isEmpty()
					|| codigoArticulo==null || codigoArticulo.isEmpty()
					|| codigoAreaTrabajo==null
					){
				return oDocResult;
			}
			
			StringBuilder sql = new StringBuilder();
			sql.append("select rid.* as '', rid from index:").append(ArticuloLocalIndices.INDEX_ARTICULO_AREATRABAJO)
			.append(" where key=[").append(codigoCompania)
			.append(",'").append(tipAreTra).append("'")
			.append(",'").append(codigoArticulo).append("'")
			.append(",").append(codigoAreaTrabajo);
			
			sql.append("]");
			final OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<>(sql.toString());
			oDocResult = query.runFirst();
		} catch (Exception e) {
			LOG_SICV2.error("Error en findAlcanceUnique: {}", e.toString());
			throw new SICException(e);
		} 	
		return oDocResult;
	}
	
	
	

	
	@Override
	public ODocument registrarAlcance(ODatabaseDocumentTx db,String codArt, Integer codAreTra, ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql, ORID ridArticuloLocalDTO) throws SICException {
		ODocument oDocArtAreTra=null;
		try{
			// registra el alcance en articuloLocalDTO
			String clusterName=ArticuloAlcanceNoSqlUtil.obtenerNombreClusterArticuloLocal(EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName(),codAreTra);
			ODocumentUtil.addClusterToClass(db, EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName(), clusterName);
			oDocArtAreTra=ArticuloAlcanceNoSqlUtil.getODocumentArticuloAreaTrabajo(codArt, codAreTra, artAreTraNoSql,ridArticuloLocalDTO);
			oDocArtAreTra.save(clusterName);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el alcance para el articulo : {}", codArt +" "+ codAreTra +" error: "+e.toString());
			throw new SICException(e);
		}	
		return oDocArtAreTra;
	}

	
	
	
	@Override
	public ODocument updateAlcance(ODatabaseDocumentTx db, String codArt, Integer codAreTra, ODocument artAreTraNoSql) throws SICException {
		try{
			// actualiza el alcance en articuloLocalDTO
			String clusterName=ArticuloAlcanceNoSqlUtil.obtenerNombreClusterArticuloLocal(EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName(),codAreTra);
			ODocumentUtil.addClusterToClass(db, EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName(), clusterName);
			artAreTraNoSql.save(clusterName);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el alcance para el articulo : {}", codArt +" "+ codAreTra +" error: "+e.toString());
			throw new SICException(e);
		}	
		return artAreTraNoSql;
	}

	/**
	 * registra los indices para la clase ArticuloLocalDTO
	 */
	@Override
//	public void registrarIndicesArticuloAreatrabajo(ODatabaseDocumentTx db, Integer codigoCompania, String codigoArticulo, 
//			Integer codigoAreatrabajo, String tipAreTra,ORID ridArticuloLocalDTO) throws SICException {
	public void registrarIndicesArticuloAreatrabajo(ODatabaseDocumentTx db, ODocument oDocArticuloLocalDTO) throws SICException {
		
		registrarIndiceArticuloAreaTrabajo(db, Integer.valueOf(String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_COMPANIA))), 
				String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO)),
				String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_ARTICULO)), 
				Integer.valueOf(String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_LOCAL))), 
				oDocArticuloLocalDTO.getIdentity());
		
		registrarIndiceAreaTrabajoArticulo(db, Integer.valueOf(String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_COMPANIA))), 
				String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO)),
				Integer.valueOf(String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_LOCAL))), 
				String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_ARTICULO)), 
				oDocArticuloLocalDTO.getIdentity());
		
		registrarIndiceFechaIniAlcRidArtLoc(db, 
				Integer.valueOf(String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_COMPANIA))), 
				(Date)oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE), 
				oDocArticuloLocalDTO.getIdentity());
		
		if (oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE)!=null
				&& !oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE).toString().isEmpty()){
			registrarIndiceFechaFinAlcRidArtLoc(db, 
					Integer.valueOf(String.valueOf(oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_COMPANIA))), 
					(Date)oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE), 
					oDocArticuloLocalDTO.getIdentity());
		}
	}
	
	public void registrarIndiceFechaIniAlcRidArtLoc(ODatabaseDocumentTx db,Integer codigoCompania, Date fechaIniAlc,ORID ridArtLoc) throws SICException {
		try {
			fecIniKey.reset();
			fecIniKey.addKey(codigoCompania);
			fecIniKey.addKey(ArticuloAlcanceNoSqlUtil.getFechaAsStringToIndex(fechaIniAlc));
			fecIniKey.addKey(ridArtLoc);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceFechaIniAlcRidArtLoc(db).put(fecIniKey, ridArtLoc);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el indice fecha ini alcance - rid articulo local {}", e.toString());
			throw new SICException(e);
		}
	}
	
	public void registrarIndiceFechaFinAlcRidArtLoc(ODatabaseDocumentTx db,Integer codigoCompania, Date fechaFinAlc,ORID ridArtLoc) throws SICException {
		try {
			fecFinKey.reset();
			fecFinKey.addKey(codigoCompania);
			fecFinKey.addKey(ArticuloAlcanceNoSqlUtil.getFechaAsStringToIndex(fechaFinAlc));
			fecFinKey.addKey(ridArtLoc);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceFechaFinAlcRidArtLoc(db).put(fecFinKey, ridArtLoc);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el indice fecha fin alcance - rid articulo local {}", e.toString());
			throw new SICException(e);
		}
	}
	
	@Override
	public ODocument registrarBitacoraAlcance(ODatabaseDocumentTx db, ODocument oDocArticuloLocalDTO,Date fecha) throws SICException {
		ODocument oDocBitacoraAlcance=null;
		try{
			// registra el alcance en la bitacora
			String clusterName=ArticuloAlcanceNoSqlUtil.obtenerNombreClusterArticuloLocalBitacora(EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName(),fecha);
			ODocumentUtil.addClusterToClass(db, EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName(), clusterName);
			oDocBitacoraAlcance=ArticuloAlcanceNoSqlUtil.getODocumentBitacoraArticuloAreaTrabajo(oDocArticuloLocalDTO);
			oDocBitacoraAlcance.save(clusterName);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar la bitacora para el alcance: {}", oDocBitacoraAlcance.getIdentity()+" error: "+e.toString());
			throw new SICException(e);
		}	
		return oDocBitacoraAlcance;
	}

	@Override
//	public void registrarIndicesArticuloAreatrabajoBitacora(ODatabaseDocumentTx db, Integer codigoCompania, String codigoArticulo, 
//			Integer codigoAreatrabajo, String tipAreTra, ORID ridBitacora) throws SICException {
	public void registrarIndicesArticuloAreatrabajoBitacora(ODatabaseDocumentTx db, ODocument articuloAreaTrabajoBitacoraDTO) throws SICException {
		
		registrarIndiceArticuloLocalBitacoraRid(db,articuloAreaTrabajoBitacoraDTO);
		registrarIndiceArticuloAreaTrabajoBitacora(db, 
				Integer.valueOf(String.valueOf(articuloAreaTrabajoBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA))), 
				String.valueOf(articuloAreaTrabajoBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO)), 
				Integer.valueOf(String.valueOf(articuloAreaTrabajoBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO))), 
				articuloAreaTrabajoBitacoraDTO.getIdentity());
		registrarIndiceAreaTrabajoArticuloBitacora(db, 
				Integer.valueOf(String.valueOf(articuloAreaTrabajoBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA))), 
				Integer.valueOf(String.valueOf(articuloAreaTrabajoBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO))), 
				String.valueOf(articuloAreaTrabajoBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO)), 
				articuloAreaTrabajoBitacoraDTO.getIdentity());
	}

	/**
	 * Registrar el indice artLocBitIndexRid (rid, link ArticuloLocal)
	 * @param oDocumentArticuloLocalBitacora
	 * @param indexArticuloLocalAreaTrabajo
	 */
	public void registrarIndiceArticuloLocalBitacoraRid(ODatabaseDocumentTx db,ODocument oDocumentArticuloLocalBitacora) {
		
		OCompositeKey articuloLocalKey =  new OCompositeKey();
		articuloLocalKey.reset();
		articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.RID_ARTICULO_LOCAL));
		articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.getIdentity());
		IndiceArticuloAlcanceNoSql.getInstancia().getIndiceBitRidArtLocRidBitArt(db).put(articuloLocalKey, oDocumentArticuloLocalBitacora.getIdentity());
		
	}


	/**
	 * registra el indice para la clase bitacoraAreatrabajoDTO o para la clase articuloLocalDTO, esto depende del booleano isIndexBitacora; true bitacora
	 * @param db
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoAreatrabajo
	 * @param isIndexBitacora
	 * @param rid
	 * @throws SICException
	 */
	
	public void registrarIndiceArticuloAreaTrabajo(ODatabaseDocumentTx db,Integer codigoCompania, String tipAreTra,String codigoArticulo, 
			Integer codigoAreatrabajo, ORID rid) throws SICException {
		try {
			
			articuloAreaTrabajoKey.reset();
			articuloAreaTrabajoKey.addKey(codigoCompania);
			articuloAreaTrabajoKey.addKey(tipAreTra);
			articuloAreaTrabajoKey.addKey(codigoArticulo);
			articuloAreaTrabajoKey.addKey(codigoAreatrabajo);
			articuloAreaTrabajoKey.addKey(rid);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceArticuloAreaTrabajo(db).put(articuloAreaTrabajoKey, rid);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el indice articulo - area de trabajo: {}", e.toString());
			throw new SICException(e);
		}
	}

	public void registrarIndiceAreaTrabajoArticulo(ODatabaseDocumentTx db, Integer codigoCompania, String tipAreTra,Integer codigoAreatrabajo, 
			String codigoArticulo, ORID rid) throws SICException {
		try {
			areaTrabajoArticuloKey.reset();
			areaTrabajoArticuloKey.addKey(codigoCompania);
			areaTrabajoArticuloKey.addKey(tipAreTra);
			areaTrabajoArticuloKey.addKey(codigoAreatrabajo);
			areaTrabajoArticuloKey.addKey(codigoArticulo);
			areaTrabajoArticuloKey.addKey(rid);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceAreaTrabajoArticulo(db).put(areaTrabajoArticuloKey, rid);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el indice area de trabajo - articulo: {}", e.toString());
			throw new SICException(e);
		}
	}

	public void registrarIndiceArticuloAreaTrabajoBitacora(ODatabaseDocumentTx db,Integer codigoCompania, String codigoArticulo, 
			Integer codigoAreatrabajo, ORID rid) throws SICException {
		try {
			articuloAreaTrabajoBitKey.reset();
			articuloAreaTrabajoBitKey.addKey(codigoCompania);
			articuloAreaTrabajoBitKey.addKey(codigoArticulo);
			articuloAreaTrabajoBitKey.addKey(codigoAreatrabajo);
			articuloAreaTrabajoBitKey.addKey(rid);
			ArticuloAlcanceIndexNoSqlUtil.getIndiceBitacoraArticuloAreaTrabajo(db).put(articuloAreaTrabajoBitKey, rid);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el indice articulo - area de trabajo: {}", e.toString());
			throw new SICException(e);
		}
	}

	public void registrarIndiceAreaTrabajoArticuloBitacora(ODatabaseDocumentTx db, Integer codigoCompania, Integer codigoAreatrabajo, 
			String codigoArticulo, ORID rid) throws SICException {
		try {
			areaTrabajoArticuloBitKey.reset();
			areaTrabajoArticuloBitKey.addKey(codigoCompania);
			areaTrabajoArticuloBitKey.addKey(codigoAreatrabajo);
			areaTrabajoArticuloBitKey.addKey(codigoArticulo);
			areaTrabajoArticuloBitKey.addKey(rid);
			ArticuloAlcanceIndexNoSqlUtil.getIndiceBitacoraAreaTrabajoArticulo(db).put(areaTrabajoArticuloBitKey, rid);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el indice area de trabajo - articulo: {}", e.toString());
			throw new SICException(e);
		}
	}

	
	@Override
	public List<ODocument> findAlcancesEnAreaTrabajo(Integer codigoCompania, String tipAreaTrabajo, Integer codAreaTrabajo,String codArticulo,Integer skip,Integer limit) throws SICException {
		List<ODocument> lisResult=null; 
		try {
			if (codigoCompania==null
					|| tipAreaTrabajo==null || tipAreaTrabajo.isEmpty()
					|| codAreaTrabajo==null){
				return lisResult;
			}
			
			StringBuilder sql = new StringBuilder();
			sql.append("select rid.* as '' from index:").append(ArticuloLocalIndices.INDEX_AREATRABAJO_ARTICULO)
			.append(" where key=[").append(codigoCompania)
			.append(",'").append(tipAreaTrabajo).append("'")
			.append(",").append(codAreaTrabajo);
			
			if (codArticulo!=null && !codArticulo.isEmpty()){
				sql.append(",'").append(codArticulo).append("'");
			}
			sql.append("]");
			
			if (skip!=null && limit!=null){
				sql.append(" skip ").append(skip)
				.append(" limit ").append(limit);
			}
			
			final OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<>(sql.toString());
			lisResult = query.run();
			
		} catch (Exception e) {
			LOG_SICV2.error("Error en findAlcancesEnAreaTrabajo: {}", e.toString());
			throw new SICException(e);
		}
		
		return lisResult;
	}

	@Override
	public Integer getNumRegistrosAlcanceEnAreaTrabajo(Integer codigoCompania, String tipAreaTrabajo, Integer codAreaTrabajo, String codArticulo) throws SICException {
		Integer numReg=0;
		try {
			if (codigoCompania==null
					|| tipAreaTrabajo==null || tipAreaTrabajo.isEmpty()
					|| codAreaTrabajo==null){
				return 0;
			}
			
			StringBuilder sql = new StringBuilder();
			sql.append("select count(*) as numReg from index:").append(ArticuloLocalIndices.INDEX_AREATRABAJO_ARTICULO)
			.append(" where key=[").append(codigoCompania)
			.append(",'").append(tipAreaTrabajo).append("'")
			.append(",").append(codAreaTrabajo);
			
			if (codArticulo!=null && !codArticulo.isEmpty()){
				sql.append(",'").append(codArticulo).append("'");
			}
			sql.append("]");
			
			final OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<>(sql.toString());
			List<ODocument> lisResult = query.run();
			if (!CollectionUtils.isEmpty(lisResult)){
				numReg=Integer.parseInt(String.valueOf(lisResult.get(0).field("numReg")));
			}
			
		} catch (Exception e) {
			LOG_SICV2.error("Error en findAlcancesEnAreaTrabajo: {}", e.toString());
			throw new SICException(e);
		}
		return numReg;
	}

	@Override
	public Collection<ODocument> registrarArticuloEstablecimientoDocument(String idClusterName, Collection<ODocument> colODocumentArticuloEstablecimiento) throws SICException {
		
		Collection<ODocument> colOdDocument = new ArrayList<>();
		
		try {
			
			for (ODocument oDocumentArticuloEstablecimiento : colODocumentArticuloEstablecimiento) {
				colOdDocument.add(this.registrarArticuloEstablecimientoDocument(idClusterName, oDocumentArticuloEstablecimiento));
			}
			
		} catch (SICException e) {
			LOG_SICV2.error("Error al ejecutar registrarArticuloEstablecimientoDocument: {}", e.toString());
			throw e;
		}
		
		return colOdDocument;
	}

	@Override
	public ODocument registrarArticuloEstablecimientoDocument(String idClusterName, ODocument oDocumentArticuloEstablecimiento) throws SICException {
		try {
			return oDocumentArticuloEstablecimiento.save(idClusterName);
		} catch (Exception e) {
			LOG_SICV2.error("Error al ejecutar registrarArticuloEstablecimientoDocument: {}", e.toString());
			throw new SICException(e);
		}
	}

	@Override
	public void registrarIndicesArticuloEstablecimiento(ODatabaseDocumentTx db, ODocument ... colODocumentArticuloEstablecimiento) throws SICException {
		
		try {
			
			ArticuloAlcanceIndexNoSqlUtil.registrarIndicesODocumentArticuloEstablecimiento(db, colODocumentArticuloEstablecimiento);
			
		} catch (Exception e) {
			LOG_SICV2.error("Error al ejecutar registrarIndicesArticuloEstablecimiento: {}", e.toString());
			throw new SICException(e);
		}
		
	}

	@Override
	public ODocument findArticuloEstablecimientoUnique(Integer codigoCompania, String codigoArticulo, Integer codigoEstablecimiento) throws SICException {
		ODocument oDocResult=null;
		try {
			if (codigoCompania==null
					|| codigoArticulo==null || codigoArticulo.isEmpty()
					|| codigoEstablecimiento==null){
				return oDocResult;
			}
			
			StringBuilder sql = new StringBuilder();
			sql.append("select rid.* as '', rid from index:").append(ArticuloLocalIndices.INDEX_ARTICULO_ESTABLECIMIENTO)
			.append(" where key=[").append(codigoCompania)
			.append(",'").append(codigoArticulo).append("'")
			.append(",").append(codigoEstablecimiento);
			sql.append("]");
			final OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<>(sql.toString());
			oDocResult = query.runFirst();
		} catch (Exception e) {
			LOG_SICV2.error("Error en findArticuloEstablecimientoUnique: {}", e.toString());
			throw new SICException(e);
		} 	
		return oDocResult;	
	}

	@Override
	public ODocument registrarArticuloEstablecimiento(ODatabaseDocumentTx db, String codArticulo, Integer codEstablecimiento, Integer estadoArtEst, 
			ArticuloAreaTrabajoNoSqlDTO artAreTraNoSqlDTO, ORID ridArtEstDTO) throws SICException {
		ODocument oDocArtEst=null;
		try{
			// registra en articuloEstablecimientoDTO
			String clusterName=ArticuloAlcanceNoSqlUtil.obtenerNombreClusterArticuloEstablecimiento(EnumClasesArticuloAlcanceNoSql.ArticuloEstablecimientoDTO.getName(), codEstablecimiento);
			ODocumentUtil.addClusterToClass(db, EnumClasesArticuloAlcanceNoSql.ArticuloEstablecimientoDTO.getName(), clusterName);
			oDocArtEst=ArticuloAlcanceNoSqlUtil.getODocumentArticuloEstablecimiento(artAreTraNoSqlDTO.getCodigoCompania(), codArticulo, codEstablecimiento, estadoArtEst, artAreTraNoSqlDTO, ridArtEstDTO);
			oDocArtEst.save(clusterName);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el el articulo establecimiento: {}",e.toString());
			throw new SICException(e);
		}	
		return oDocArtEst;	
	}

	@Override
	public void registrarIndicesArticuloEstablecimiento(ODatabaseDocumentTx db, ODocument oDocArtEstInserted) throws SICException {
		registrarIndiceArticuloEstablecimiento(db, Integer.valueOf(String.valueOf(oDocArtEstInserted.field(ArticuloEstablecimientoFields.CODIGO_COMPANIA))), 
				String.valueOf(oDocArtEstInserted.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO)), 
				Integer.valueOf(String.valueOf(oDocArtEstInserted.field(ArticuloEstablecimientoFields.CODIGO_ESTABLECIMIENTO))), 
				oDocArtEstInserted.getIdentity());
		registrarIndiceEstablecimientoArticulo(db, Integer.valueOf(String.valueOf(oDocArtEstInserted.field(ArticuloEstablecimientoFields.CODIGO_COMPANIA))), 
				Integer.valueOf(String.valueOf(oDocArtEstInserted.field(ArticuloEstablecimientoFields.CODIGO_ESTABLECIMIENTO))), 
				String.valueOf(oDocArtEstInserted.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO)), 
				oDocArtEstInserted.getIdentity());
	}

	private void registrarIndiceArticuloEstablecimiento(ODatabaseDocumentTx db,Integer codigoCompania, String codigoArticulo, 
			Integer codigoEstablecimiento,ORID rid) throws SICException {
		try {
			
			artEstKey.reset();
			artEstKey.addKey(codigoCompania);
			artEstKey.addKey(codigoArticulo);
			artEstKey.addKey(codigoEstablecimiento);
			artEstKey.addKey(rid);
			
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceArticuloEstablecimiento(db).put(artEstKey, rid);			
			//ArticuloAlcanceIndexNoSqlUtil.getIndiceArticuloEstablecimiento(db).put(articuloEstKey, rid);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el indice articulo - area de trabajo: {}", e.toString());
			throw new SICException(e);
		}
	}	
	
	private void registrarIndiceEstablecimientoArticulo(ODatabaseDocumentTx db,Integer codigoCompania, Integer codigoEstablecimiento,
			String codigoArticulo,ORID rid) throws SICException {
		try {
			estArtKey.reset();
			estArtKey.addKey(codigoCompania);
			estArtKey.addKey(codigoEstablecimiento);
			estArtKey.addKey(codigoArticulo);
			estArtKey.addKey(rid);
			IndiceArticuloAlcanceNoSql.getInstancia().getIndiceEstablecimientoArticulo(db).put(estArtKey, rid);
			//ArticuloAlcanceIndexNoSqlUtil.getIndiceEstablecimientoArticulo(db).put(articuloEstKey, rid);
		} catch (Exception e) {
			LOG_SICV2.error("Error al registrar el indice articulo - area de trabajo: {}", e.toString());
			throw new SICException(e);
		}
	}

	@Override
	public void borrarRegistrarIndiceFechaIniAlcRidArtLoc(ODatabaseDocumentTx db, ODocument artAreTraSaved, ODocument artAreTraUpdate) throws SICException {
		//OCompositeKey fecIniKey =  new OCompositeKey();
		fecIniKeyDelete.reset();
		fecIniKeyDelete.addKey(Integer.valueOf(String.valueOf(artAreTraSaved.field(ArticuloLocalFields.CODIGO_COMPANIA))));
		fecIniKeyDelete.addKey(ArticuloAlcanceNoSqlUtil.getFechaAsStringToIndex((Date)artAreTraSaved.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE)));
		fecIniKeyDelete.addKey(((ODocument)artAreTraSaved.field("rid")).getIdentity());
		OIndexUtil.removeIndex(IndiceArticuloAlcanceNoSql.getInstancia().getIndiceFechaIniAlcRidArtLoc(db),fecIniKeyDelete,db);
		
		registrarIndiceFechaIniAlcRidArtLoc(db, Integer.valueOf(String.valueOf(artAreTraUpdate.field(ArticuloLocalFields.CODIGO_COMPANIA))), 
				(Date)artAreTraUpdate.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE), 
				artAreTraUpdate.getIdentity());
	}

	@Override
	public void borrarRegistrarIndiceFechaFinAlcRidArtLoc(ODatabaseDocumentTx db, ODocument artAreTraSaved, ODocument artAreTraUpdate) throws SICException {
		//OCompositeKey fecFinKey =  new OCompositeKey();
		fecFinKeyDelete.reset();
		fecFinKeyDelete.addKey(Integer.valueOf(String.valueOf(artAreTraSaved.field(ArticuloLocalFields.CODIGO_COMPANIA))));
		fecFinKeyDelete.addKey(ArticuloAlcanceNoSqlUtil.getFechaAsStringToIndex((Date)artAreTraSaved.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE)));
		fecFinKeyDelete.addKey(((ODocument)artAreTraSaved.field("rid")).getIdentity());
		OIndexUtil.removeIndex(IndiceArticuloAlcanceNoSql.getInstancia().getIndiceFechaFinAlcRidArtLoc(db),fecFinKeyDelete,db);
		
		registrarIndiceFechaFinAlcRidArtLoc(db, Integer.valueOf(String.valueOf(artAreTraUpdate.field(ArticuloLocalFields.CODIGO_COMPANIA))), 
				(Date)artAreTraUpdate.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE), 
				artAreTraUpdate.getIdentity());
	}	
	
	

}

//@Override
//public void registrarIndiceArticuloAreatrabajoGrupoAlcance(ODatabaseDocumentTx db, Integer codigoCompania, String codigoArticulo, Integer codigoAreatrabajo, String tipAreTra, Integer codigoGrupoAlcance, ORID ridArticuloLocalDTO) throws SICException {
//	registrarIndiceArticuloAreaTrabajoGrupoAlcance(db, codigoCompania, tipAreTra, codigoArticulo, codigoAreatrabajo, codigoGrupoAlcance, ridArticuloLocalDTO);		
//}

//
//public void registrarIndiceArticuloAreaTrabajoGrupoAlcance(ODatabaseDocumentTx db, Integer codigoCompania, String tipAreTra,String codigoArticulo,
//		Integer codigoAreatrabajo,Integer codigoGrupoAlcance, ORID rid) throws SICException {
//	try {
//		OCompositeKey articuloLocalKey =  new OCompositeKey();
//		articuloLocalKey.reset();
//		articuloLocalKey.addKey(codigoCompania);
//		articuloLocalKey.addKey(tipAreTra);
//		articuloLocalKey.addKey(codigoArticulo);
//		articuloLocalKey.addKey(codigoAreatrabajo);
//		articuloLocalKey.addKey(codigoGrupoAlcance);
//		articuloLocalKey.addKey(rid);
//		ArticuloAlcanceIndexNoSqlUtil.getIndiceArticuloAreaTrabajoGrupoAlcance(db).put(articuloLocalKey, rid);
//	} catch (Exception e) {
//		LOG_SICV2.error("Error al registrar el indice area de trabajo - articulo: {}", e.toString());
//		throw new SICException(e);
//	}
//}
