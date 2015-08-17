package ec.com.smx.sic.articulo.persistence.dao;


import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloCodBarrasEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCampoMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRazonSocialProveedorDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IVistaCampoMercanciaDAO;

/**
 * Ejecucion consultas para campos de etiquetas mercancias
 * @author dbravo
 *
 */
public class VistaCampoMercanciaDAO  implements IVistaCampoMercanciaDAO, Logeable   {

	private SessionFactory sessionFactory;
	
	private boolean importado;

	/**
	 * Metodo para  obtener los datos de mercancia por articulo
	 */
	public VistaArticuloCodBarrasEtiquetaMercanciaDTO obtenerMercanciaporCodigoBarras(String codigoBarras, Integer codigoCompania)throws SICException{
		try {
			if(codigoBarras==null || codigoCompania==null){				
				LOG_SICV2.error("El codigoBarras y codigoCompania son requeridos para consulta");
				new IllegalArgumentException("El codigoBarras y codigoCompania son requeridos para consulta");
			}	
				StringBuilder sql = new StringBuilder();
				Map<String, Object> parameterMap =new HashMap<String, Object>();
				sql.append("SELECT ART.CODIGOCOMPANIA {vista.id.codCompania},"
						+"	   ART.CODIGOARTICULO {vista.id.codArticulo}, "
						+"       ARTBIT.CODIGOBARRAS {vista.codigoBarras}, "
						+"       ART.DESCRIPCIONARTICULO {vista.descripcionArticulo}, "
						+"       ARTMERC.NOMBREPRODUCTO {vista.nombreProductoMerc}, "
						+"       ARTMERC.MARCACOMERCIAL {vista.marcaComercialMerc}, "
						+"       ARTMERC.LOTE {vista.loteMerc}, "
						+"       ARTMERC.MODELO {vista.modeloMerc}, "
						+"       ARTMERC.CONTENIDONETO {vista.contenidoNetoMerc}, "
						+"       ARTMERC.RAZONSOCIALFABRICANTE {vista.razonSocialFabricanteMerc}, "
						+"       ARTMERC.DIRECCIONFABRICANTE {vista.direccionFabricanteMerc}, "
						+"       ARTMERC.RAZONSOCIALIMPORTADOR {vista.razonSocialImportadorMerc}, "
						+"       ARTMERC.DIRECCIONIMPORTADOR {vista.direcionImportadorMerc}, "
						+"       ARTMERC.LISTACOMPONETES {vista.listaComponentesMerc}, "
						+"       ARTMERC.CODIGODIVGEOPOL {vista.codigoDivisionGeopolMerc}, "
						+"       ARTMERC.FECHAMAXIMAUSO {vista.fechaMaximaUsoMerc}, "
						+"       ARTMERC.CONDICIONESCONSERVACION {vista.condicionesConservacionMerc}, "
						+"       ARTMERC.NORMATECNICAREFERENCIA {vista.nteMerc}, "
						+"       ARTMERC.ADVERTENCIA {vista.advertencia}, "
						+"       ARTMERC.TRADUCCION {vista.traduccionMerc} ," 
						+"       ASTMED.REFERENCIAMEDIDA {vista.tamanio} "
						+"FROM   SCSADTARTBITCODBAR ARTBIT "
						+"       INNER JOIN SCSPETARTICULO ART "
						+"               ON ARTBIT.CODIGOARTICULO = ART.CODIGOARTICULO "
						+"                  AND ART.CODIGOCOMPANIA =:codigoCompania "
						+"       LEFT JOIN SCSADTARTETIMERC ARTMERC "
						+"              ON ART.CODIGOARTICULO = ARTMERC.CODIGOARTICULO "
						+"                 AND ARTMERC.CODIGOCOMPANIA =:codigoCompania "
						+"		 LEFT JOIN SCSADTARTMED ASTMED "
						+"              ON ART.codigoarticulo = ASTMED.codigoarticulo " 
			            +"                 AND ASTMED.codigocompania = 1 "
						+"WHERE  ARTBIT.CODIGOCOMPANIA =:codigoCompania "
						+"       AND ARTBIT.ESTADOARTICULOBITACORA =:estado "
						+"       AND ARTBIT.CODIGOBARRAS =:codigoBarras ");
				parameterMap.put("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				parameterMap.put("codigoBarras", codigoBarras);
				parameterMap.put("codigoCompania", codigoCompania);
				
				this.sessionFactory.getCurrentSession().clear();
				SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
				
				for(Entry<String, Object> parameterEntry : parameterMap.entrySet()){
					LOG_SICV2.info("key:*"+parameterEntry.getKey()+"* value:*"+ parameterEntry.getValue()+"*");
					query.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
				}
				
				query.addEntity("vista", VistaArticuloCodBarrasEtiquetaMercanciaDTO.class);
				
				VistaArticuloCodBarrasEtiquetaMercanciaDTO resultado = (VistaArticuloCodBarrasEtiquetaMercanciaDTO)query.uniqueResult();
				return resultado;
			
		} catch (Exception ex) {
			LOG_SICV2.error(ex.getMessage());
			 throw new SICException(ex);
		}
	}
	
	/*
	 * Metodo para ejecutar el sql para obtener campos del etiquetado para mercancias
	 */
	@SuppressWarnings("unchecked")
	public VistaCampoMercanciaDTO obtenerCamposMercancia(String codigoArticulo, Integer codigoCompania) throws SICException{
		
		try{
			if(codigoArticulo==null || codigoCompania==null){				
				LOG_SICV2.error("El codigoArticulo y codigoCompania son requeridos para consulta");
				new IllegalArgumentException("El codigoArticulo y codigoCompania son requeridos para consulta");				
			}
			
			StringBuilder sql = new StringBuilder();
			
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			sql.append( "SELECT  ROWNUMBER() OVER()  {vista.id.rowId}, " +
						"  ART.CODIGOCOMPANIA {vista.id.codCompania},"+
						"  ART.CODIGOARTICULO {vista.id.codArticulo},"+
					    "  ART.DESCRIPCIONARTICULO {vista.descripcionArticulo},"+ 
					    "  MARCAARTICULO.NOMBREMARCA {vista.nombreMarca},"+ 
					    "  ARTPROVE.CODIGOREFERENCIAPROVEEDOR {vista.codigoReferenciaProveedor},"+ 
					    "  ARTPROVE.CODIGOPROVEEDOR {vista.codigoProveedor},"+ 
//					    "  MARCAARTICULO.PAISORIGEN {vista.paisOrigen},"+ 
					    "  '' {vista.paisOrigen},"+
					    "  ARTMEDIDA.CANTIDADMEDIDA {vista.cantidadMedida},"+ 
					    "  ARTMEDIDA.VALORTIPOMEDIDA {vista.tamanioArticulo},"+ 
//					    "  ARTDUR.DIASVIDAUTIL {vista.diasVidaUtil}"+
						"  0 {vista.diasVidaUtil}"+
					" FROM   SCSPETARTICULO ART "+
					       "LEFT JOIN (SELECT ARTICULOCOMERCIAL.CODIGOARTICULO,"+ 
					                       " MARCAARTICULO.NOMBRE AS NOMBREMARCA "+ 
//					                       " ,PAIS.CODIGODIVGEOPOL AS PAISORIGEN "+
					                  "FROM   SCSADTARTCOM ARTICULOCOMERCIAL "+ 
					                        "LEFT JOIN SCSADTMARCA MARCAARTICULO "+ 
					                               "ON ARTICULOCOMERCIAL.CODIGOMARCACOMERCIAL = "+ 
					                                  "MARCAARTICULO.SECUENCIALMARCA"+ 
					                                 " AND MARCAARTICULO.CODIGOCOMPANIA = "+
					                                       "ARTICULOCOMERCIAL.CODIGOCOMPANIA"+ 
					                                 " AND MARCAARTICULO.ESTADO =:estado "+ 
//					                        "LEFT JOIN SSPCOTDIVISIONGEOPOLITICA PAIS "+ 
//					                               "ON PAIS.CODIGODIVGEOPOL = "+
//					                                  "ARTICULOCOMERCIAL.CODIGOPAISORIGEN "+ 
					                 "WHERE  ARTICULOCOMERCIAL.CODIGOARTICULO =:codigoArticulo "+ 
					                        "AND ARTICULOCOMERCIAL.CODIGOCOMPANIA =:codigoCompania) AS "+
					                "MARCAARTICULO "+ 
					             "ON MARCAARTICULO.CODIGOARTICULO = ART.CODIGOARTICULO "+
					      "LEFT JOIN SCSADTARTPRO ARTPROVE "+
					             "ON ARTPROVE.CODIGOARTICULO = ART.CODIGOARTICULO "+
					                "AND ARTPROVE.CODIGOCOMPANIA = ART.CODIGOCOMPANIA "+
					                "AND ARTPROVE.ESTADOARTICULOPROVEEDOR =:estado "+ 
					      "LEFT JOIN SCSADTARTMED ARTMEDIDA "+
					             "ON ARTMEDIDA.CODIGOARTICULO = ART.CODIGOARTICULO "+
					                "AND ARTMEDIDA.CODIGOCOMPANIA = ART.CODIGOCOMPANIA "+ 
//					      "LEFT JOIN SCSADTARTDURCON ARTDUR "+ 
//					             "ON ARTDUR.CODIGOARTICULO = ART.CODIGOARTICULO "+ 
//					                "AND ARTDUR.CODIGOCOMPANIA = ART.CODIGOCOMPANIA "+ 
//					                "AND ARTDUR.ESTADO =:estado "+ 
//					                "AND ARTDUR.VALORTIPOCONSERVACION =:valortipoconservacion "+
					"WHERE  ART.CODIGOARTICULO =:codigoArticulo "+
					      "AND ART.CODIGOCOMPANIA =:codigoCompania"); 
			
			parameterMap.put("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			parameterMap.put("codigoArticulo", codigoArticulo);
			parameterMap.put("codigoCompania", codigoCompania);
//			parameterMap.put("valortipoconservacion", SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL);
			
			this.sessionFactory.getCurrentSession().clear();
			SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
			
			for(Entry<String, Object> parameterEntry : parameterMap.entrySet()){
				Logeable.LOG_SICV2.info("key:*"+parameterEntry.getKey()+"* value:*"+ parameterEntry.getValue()+"*");
				query.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
			}
			
			query.addEntity("vista", VistaCampoMercanciaDTO.class);
			
			
			Collection<VistaCampoMercanciaDTO> resultados = query.list();
			
			if(resultados != null && resultados.size()>0){
				return (VistaCampoMercanciaDTO) CollectionUtils.get(resultados, 0);
			}
			else{
				LOG_SICV2.error("Resultado de la ejecucion consulta: null");
				return new VistaCampoMercanciaDTO();
			}
			
			
		}catch(Exception ex){
			 LOG_SICV2.error(ex.getMessage());
			 throw new SICException(ex);
		}

	}
	
	
	/*
	 * Metodo para ejecutar el sql que devuelve la razon social y el proveedor 
	 * para el etiquetado de mercancias
	 */
	@SuppressWarnings("unchecked")
	public VistaRazonSocialProveedorDTO obtenerRazonSocialProveedor(String codigoArticulo, String codigoProveedor, Integer codigoCompania) throws SICException{
		
		if(codigoArticulo == null || codigoProveedor == null || codigoCompania ==null ){
			LOG_SICV2.error("campos vacios");
			new IllegalArgumentException("codigo Articulo, codigo Proveedor, codigo Compania son requeridos para consulta");
		}
		
		try{
			StringBuilder sql = new StringBuilder();
			
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			sql.append("SELECT ROWNUMBER() OVER() {vista.id.rowId}, "+
					  "PROV.CODIGOPROVEEDOR {vista.codigoProveedor}, "+ 
					  "ARTPRO.CODIGOARTICULO {vista.id.codigoArticulo}, "+
					  "ARTPRO.CODIGOCOMPANIA {vista.id.codigoCompania}, "+
				      "DATCONPERLOC.DIRECCIONPRINCIPAL {vista.direccionPrincipal}, "+ 
				      "PROV.RAZONSOCIALPROVEEDOR {vista.razonSocialProveedor}, "+ 
				      "PROV.ORIGENPROVEEDOR {vista.origenProveedor} "+ 
			"FROM   SCSADTARTPRO ARTPRO "+
				      "LEFT JOIN SCSPETPROVEEDOR PROV "+
				              "ON ARTPRO.CODIGOPROVEEDOR = PROV.CODIGOPROVEEDOR "+
				              "and ARTPRO.codigocompania= PROV.codigocompania "+
				              "and PROV.ESTADOPROVEEDOR =:estadoNumerico "+
				      "LEFT JOIN SSPCOTDATCONPERLOC DATCONPERLOC "+ 
				              "ON PROV.CODIGOPERSONA = DATCONPERLOC.CODIGOPERSONA "+
				                  "OR PROV.CODIGOLOCALIZACIONPROVEEDOR = "+
				                     "DATCONPERLOC.CODIGOLOCALIZACION "+
				                     "AND DATCONPERLOC.CODIGOTIPOCONTACTO = :codigoTipoContacto "+
				                     "and DATCONPERLOC.codigocompania = ARTPRO.codigocompania "+
				                     "and DATCONPERLOC.ESTADO =:estadoString "+
			"WHERE  ARTPRO.CODIGOARTICULO = :codigoArticulo "+
				"and  ARTPRO.CODIGOPROVEEDOR = :codigoProveedor "+
				"and ARTPRO.codigocompania = :codigoCompania ");
			
			parameterMap.put("codigoArticulo", codigoArticulo);
			parameterMap.put("codigoProveedor", codigoProveedor);
			parameterMap.put("codigoCompania", codigoCompania);
			parameterMap.put("estadoString", SICConstantes.ESTADO_ACTIVO_LITERAL);
			parameterMap.put("estadoNumerico", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			parameterMap.put("codigoTipoContacto", CorporativoConstantes.CODIGO_TIPO_CONTACTO_PRINCIPAL);
			
			SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
			
			for(Entry<String, Object> parameterEntry : parameterMap.entrySet()){
				query.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
			}
		
			query.addEntity("vista", VistaRazonSocialProveedorDTO.class);
			
			
			Collection<VistaRazonSocialProveedorDTO> resultados = query.list();
			
			if(resultados != null && resultados.size()>0){
				return (VistaRazonSocialProveedorDTO) CollectionUtils.get(resultados, 0);
			}
			else{
				LOG_SICV2.error("resultado de la consulta: null");
				return new VistaRazonSocialProveedorDTO();
			}
				
		}catch(Exception ex){
			LOG_SICV2.error(ex.getMessage());
			throw new SICException(ex);
		}
				
	}
	
	/*
	 * Metodo que obtiene la fecha del lote
	 */
//	@SuppressWarnings("unchecked")
//	public Date obtenerFechaLote(String codigoArticulo, Integer codigoCompania) throws SICException{
//		try{
//			StringBuilder sql = new StringBuilder();
//			
//			Map<String, Object> parameterMap =new HashMap<String, Object>();
//			
//			sql.append("SELECT MAX(E.FECHADESCARGA) "+ 
//				"FROM   SISIMTEMBARQUE E "+
//				       "INNER JOIN SISIMTEMBEST ES "+
//				               "ON ES.CODIGOEMBARQUE = E.CODIGOEMBARQUE	"+
//				               "and ES.CODIGOCOMPANIA = :codigoCompania "+
//				       "INNER JOIN SISIMTFACTURA F  "+
//				               "ON F.CODIGOEMBARQUE = E.CODIGOEMBARQUE "+
//				               "and F.CODIGOCOMPANIA = :codigoCompania "+
//				               "and F.ESTADO = :estadoString "+
//				       "INNER JOIN SISIMTFACDET FD "+
//				               "ON FD.CODIGOFACTURA = F.CODIGOFACTURA "+
//				               "and FD.CODIGOCOMPANIA = :codigoCompania "+
//				               "and FD.ESTADO = :estadoString "+
//				       "INNER JOIN SCSADTARTPRO AP "+ 
//				               "ON FD.CODIGOARTICULO = AP.CODIGOARTICULO "+ 
//				                  "AND FD.CODIGOPROVEEDOR = AP.CODIGOPROVEEDOR "+
//				                  "and AP.CODIGOCOMPANIA = :codigoCompania "+
//				       "INNER JOIN SISIMTEMBFCT EF "+
//				               "ON EF.CODIGOEMBARQUE = E.CODIGOEMBARQUE "+ 
//				                  "AND EF.CODIGOEMBARQUEESTADO = ES.CODIGOEMBARQUEESTADO "+
//				                  "and EF.CODIGOCOMPANIA = :codigoCompania "+
//				       "INNER JOIN SISIMTEMBFCTFACDOC EFD "+
//				               "ON EFD.CODIGOEMBARQUEFACTOR = EF.CODIGOEMBARQUEFACTOR "+ 
//				                  "AND EFD.CODIGOFACTURA = F.CODIGOFACTURA "+
//				                  "and EFD.CODIGOCOMPANIA = :codigoCompania "+
//				                  "and EFD.ESTADO = :estadoString "+
//				"WHERE  ES.FECHAFIN IS NULL "+ 
//				       "AND E.ESTADO = :estadoString "+ 
//				       "AND F.ESTADO = :estadoString "+ 
//				       "AND AP.ESTADOARTICULOPROVEEDOR = :estado "+ 
//				       "AND AP.CODIGOARTICULO = :codigoArticulo");
//			
//			parameterMap.put("codigoArticulo", codigoArticulo);
//			parameterMap.put("codigoCompania", codigoCompania);
//			parameterMap.put("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
//			parameterMap.put("estadoString", SICConstantes.ESTADO_ACTIVO_LITERAL);
//			
//			SQLQuery query = hibernateH.getHibernateSession().createSQLQuery(sql.toString());
//			
//			for(Entry<String, Object> parameterEntry : parameterMap.entrySet()){
//				query.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
//			}
//
//			Collection<Date> fecha = query.list();
//			
//			if(fecha != null){
//				return (Date) CollectionUtils.get(fecha, 0);
//			}
//			else{
//				LOG_SICV2.error("resultado de la consulta: null");
//				return null;
//			}
//				
//		}catch(Exception ex){
//			LOG_SICV2.error(ex.getMessage());
//			throw new SICException(ex);
//		}
//				
//	}
	
	/*
	 * Metodo que obtiene la fecha del lote
	 */
	@SuppressWarnings("unchecked")
	public Date obtenerFechaLote(String codigoArticulo, Integer codigoCompania) throws SICException{
		
		try{
			StringBuilder sql = new StringBuilder();
			
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			
			sql.append("SELECT A.FECHAAPLICACIONFACTOR "+
				"FROM SCSADTARTPROIMP A "+
				"WHERE A.CODIGOARTICULO=:codigoArticulo "+
				"	AND A.CODIGOCOMPANIA=:codigoCompania");
			
			parameterMap.put("codigoArticulo", codigoArticulo);
			parameterMap.put("codigoCompania", codigoCompania);
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
			
			for(Entry<String, Object> parameterEntry : parameterMap.entrySet()){
				query.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
			}

			Collection<Date> fecha = query.list();
			
			if(fecha != null && fecha.size()>0){
				return (Date) CollectionUtils.get(fecha, 0);
			}
			else{
				LOG_SICV2.error("resultado de la consulta: null");
				return null;
			}
				
		}catch(Exception ex){
			LOG_SICV2.error(ex.getMessage());
			throw new SICException(ex);
		}
		
	}
	/**
	 * Devuele  la clasificacion del articulo  para poder validar si es importado o nacional
	 */
	public String obtenerCodigoClasificacionParaValidacionImportado(String codigoArticulo, Integer codigoCompania) throws SICException{
		try {
			StringBuilder sql= new StringBuilder();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			sql.append("SELECT ART.CODIGOCLASIFICACION ");
			sql.append("FROM   SCSPETARTICULO ART ");
			sql.append("       INNER JOIN SCSPETCLASIFICACION CLA ");
			sql.append("               ON ART.CODIGOCLASIFICACION = CLA.CODIGOCLASIFICACION ");
			sql.append("                  AND ART.CODIGOCOMPANIA = CLA.CODIGOCOMPANIA ");
			sql.append("WHERE  ART.CODIGOARTICULO = :codigoArticulo ");
			sql.append("       AND NIVELCLASIFICACION = :nivelClasificacion ");
			sql.append("       AND VALORTIPOESTRUCTURA = :valorTipoEstructura ");
			sql.append("       AND ART.CODIGOCOMPANIA = :codigoCompania ");
			
			parameterMap.put("codigoArticulo", codigoArticulo);
			parameterMap.put("codigoCompania", codigoCompania);
			parameterMap.put("nivelClasificacion", 3);
			parameterMap.put("valorTipoEstructura", "ESC");
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
			
			for(Entry<String, Object> parameterEntry : parameterMap.entrySet()){
				query.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
			}
			String codigoClasificacion = (String) query.uniqueResult();
			return codigoClasificacion;
		} catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean isImportado() {
		return importado;
	}


	public void setImportado(boolean importado) {
		this.importado = importado;
	}
}
