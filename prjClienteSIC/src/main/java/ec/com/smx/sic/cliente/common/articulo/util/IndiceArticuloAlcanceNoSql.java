/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.util;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.index.OIndex;
import com.orientechnologies.orient.core.metadata.schema.OType;

import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalIndices;



/**
 * Clase que va contener todos los indices que se necesitan en el proceso de alcances desde orientDB
 * @author wcaiza
 *
 */
public final class IndiceArticuloAlcanceNoSql {
	
	private static final IndiceArticuloAlcanceNoSql INSTANCIA = new IndiceArticuloAlcanceNoSql();
	
	private IndiceArticuloAlcanceNoSql () {}
	
	public static IndiceArticuloAlcanceNoSql getInstancia(){
		return INSTANCIA;
	}
	
	// Indices requeridos en todo el proceso
	// Indices para la class articuloEstablecimientoDTO
	private OIndex<?> indiceArticuloEstablecimiento;
	private OIndex<?> indiceEstablecimientoArticulo;
	// --
	// indices para la class articuloLocalDTO 
	private OIndex<?> indiceFechaIniAlcRidArtLoc;
	private OIndex<?> indiceFechaFinAlcRidArtLoc;
	private OIndex<?> indiceArticuloAreatrabajo;
	private OIndex<?> indiceAreatrabajoArticulo;
	// --
	// Indices para la class ArticuloAreaTrabajoBitacoraDTO
	private OIndex<?> indiceBitRidArtLocRidBitArt;

	public OIndex<?> getIndiceBitRidArtLocRidBitArt(ODatabaseDocumentTx db) {
		if (this.indiceBitRidArtLocRidBitArt == null){
			this.indiceBitRidArtLocRidBitArt = this.obtenerIndiceBitRidArtLocRidBitArt(db);
		}
		return indiceBitRidArtLocRidBitArt;
	}
	
	/**
	 * return OIndex indexArticuloEstablecimiento key = [codCom, codArt, codEst, rid]
	 * @param db pool de la base de datos orientDB
	 * @return
	 */
	public OIndex<?> getIndiceArticuloEstablecimiento(ODatabaseDocumentTx db) {
		if (this.indiceArticuloEstablecimiento == null) {
			this.indiceArticuloEstablecimiento = this.obtenerIndiceArticuloEstablecimiento(db);
		}
		return indiceArticuloEstablecimiento;
	}
	
	/**
	 * return OIndex indexEstablecimientoArticulo key = [codCom, codEst, codArt, rid]
	 * @param db pool de la base de datos orientDB
	 * @return
	 */
	public OIndex<?> getIndiceEstablecimientoArticulo(ODatabaseDocumentTx db) {
		if (this.indiceEstablecimientoArticulo == null) {
			this.indiceEstablecimientoArticulo = this.obtenerIndiceEstablecimientoArticulo(db);
		}
		return indiceEstablecimientoArticulo;
	}
	
	/**
	 * return OIndex indiceFechaIniAlcRidArtLoc key = [codCom, fechaIniAlc, ridArticuloLocal]
	 * @param db pool de la base de datos orientDB
	 * @return
	 */
	public OIndex<?> getIndiceFechaIniAlcRidArtLoc(ODatabaseDocumentTx db) {
		if (this.indiceFechaIniAlcRidArtLoc == null){
			this.indiceFechaIniAlcRidArtLoc = this.obtenerIndiceFechaIniAlcRidArticulo(db);
		}
		return indiceFechaIniAlcRidArtLoc;
	}

	/**
	 * return OIndex indiceFechaFinAlcRidArtLoc key = [codCom, fechaFinAlc, ridArticuloLocal]
	 * @param db pool de la base de datos orientDB
	 * @return
	 */
	public OIndex<?> getIndiceFechaFinAlcRidArtLoc(ODatabaseDocumentTx db) {
		if (this.indiceFechaFinAlcRidArtLoc == null){
			this.indiceFechaFinAlcRidArtLoc = this.obtenerIndiceFechaFinAlcRidArticulo(db);
		}
		return indiceFechaFinAlcRidArtLoc;
	}
	
	/**
	 * return OIndex indexAreaTrabajoArticulo key = [codCom, tipAreTra, codAreTra, codArt,ridArticuloLocal]
	 * @param db pool de la base de datos orientDB
	 * @return
	 */
	public OIndex<?> getIndiceAreaTrabajoArticulo(ODatabaseDocumentTx db) {
		if (this.indiceAreatrabajoArticulo == null){
			this.indiceAreatrabajoArticulo = this.obtenerIndiceAreaTrabajoArticulo(db);
		}
		return indiceAreatrabajoArticulo;
	}
	
	/**
	 * return OIndex indexArticuloAreaTrabajo key = [codCom, tipAreTra, codArt, codAreTra, ridArticuloLocal]
	 * @param db pool de la base de datos orientDB
	 * @return
	 */
	public OIndex<?> getIndiceArticuloAreaTrabajo(ODatabaseDocumentTx db) {
		if (this.indiceArticuloAreatrabajo == null){
			this.indiceArticuloAreatrabajo = this.obtenerIndiceArticuloAreaTrabajo(db);
		}
		return indiceArticuloAreatrabajo;
	}

	// INICIO INDICES PARA ARTICULO ESTABLECIMIENTO
	
	/**
	 * Validar si existe el indiceArticuloEstablecimiento, caso contrario se crea
	 * @param db pool de la base de datos orientDB
	 * @return
	 */
	private OIndex<?> obtenerIndiceArticuloEstablecimiento(ODatabaseDocumentTx db){
		return ArticuloAlcanceIndexNoSqlUtil.obtenerOIndex(
				db, ArticuloLocalIndices.INDEX_ARTICULO_ESTABLECIMIENTO, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER, OType.LINK});
	}
		
	/**
	 *  Validar si existe el indexEstablecimientoArticulo, caso contrario se crea
	 * @param db pool de la base de datos orientDB
	 * @return
	 */
	private OIndex<?> obtenerIndiceEstablecimientoArticulo(ODatabaseDocumentTx db){
		return ArticuloAlcanceIndexNoSqlUtil.obtenerOIndex(
				db, ArticuloLocalIndices.INDEX_ESTABLECIMIENTO_ARTICULO, new OType[]{OType.INTEGER, OType.INTEGER, OType.STRING, OType.LINK});
	}
	
	// FIN INDICES PARA ARTICULO ESTABLECIMIENTO

	// INICIO INDICES PARA ARTICULO LOCAL
	/**
	 * indice para gestionar la tarea programada de activar alcances 
	 * @param db
	 * @return
	 */
	private OIndex<?> obtenerIndiceFechaIniAlcRidArticulo(ODatabaseDocumentTx db){
		return ArticuloAlcanceIndexNoSqlUtil.obtenerOIndex(db, ArticuloLocalIndices.INDEX_FECHA_INI_ALC_ARTICULO, new OType[]{OType.INTEGER, OType.STRING, OType.LINK});
	}

	/**
	 * indice para gestionar la tarea programada de desactivar alcances 
	 * @param db
	 * @return
	 */
	private OIndex<?> obtenerIndiceFechaFinAlcRidArticulo(ODatabaseDocumentTx db){
		return ArticuloAlcanceIndexNoSqlUtil.obtenerOIndex(db, ArticuloLocalIndices.INDEX_FECHA_FIN_ALC_ARTICULO, new OType[]{OType.INTEGER, OType.STRING, OType.LINK});
	}
	
	private OIndex<?> obtenerIndiceArticuloAreaTrabajo(ODatabaseDocumentTx db){
		return ArticuloAlcanceIndexNoSqlUtil.obtenerOIndex(db, ArticuloLocalIndices.INDEX_ARTICULO_AREATRABAJO, new OType[]{OType.INTEGER, OType.STRING, OType.STRING, OType.INTEGER,OType.LINK});
	}
	
	private OIndex<?> obtenerIndiceAreaTrabajoArticulo(ODatabaseDocumentTx db){
		return ArticuloAlcanceIndexNoSqlUtil.obtenerOIndex(db, ArticuloLocalIndices.INDEX_AREATRABAJO_ARTICULO, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER, OType.STRING, OType.LINK});
	}
	// FIN INDICES PARA ARTICULO LOCAL
	
	private OIndex<?> obtenerIndiceBitRidArtLocRidBitArt(ODatabaseDocumentTx db){
		return ArticuloAlcanceIndexNoSqlUtil.obtenerOIndex(db, ArticuloLocalIndices.INDEX_BIT_RIDARTARETRA_RIDBITARTARETRA, new OType[]{OType.LINK, OType.LINK});
	}
}


