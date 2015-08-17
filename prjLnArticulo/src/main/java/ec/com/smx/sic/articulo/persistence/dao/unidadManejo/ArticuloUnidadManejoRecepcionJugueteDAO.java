/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.unidadManejo;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.unidadManejo.IArticuloUnidadManejoRecepcionJugueteDAO;

/**
 * @author gaortiz
 *
 */
public class ArticuloUnidadManejoRecepcionJugueteDAO implements IArticuloUnidadManejoRecepcionJugueteDAO{
	
	private IHibernateH<ArticuloUnidadManejoDTO> hibernateH;

	@Override
	public void registrarUnidadMenajo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			//Esto es para actualizar
			if(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo() != null){
				
				final String setUpdate = this.construirSet(articuloUnidadManejoDTO);
				session = hibernateH.getHibernateSession();
				session.clear();
				if(StringUtils.isNotEmpty(setUpdate)){
					
					
					query.append("update ArticuloUnidadManejoDTO artUniMan ")
					.append("set")
					.append(setUpdate)
					.append("where artUniMan.id.codigoCompania = :pCompania ")
					.append("and artUniMan.id.codigoArticulo = :pcodigoArticulo ")
					.append("and artUniMan.id.codigoUnidadManejo = :pcodigoUnidadManejo ");
					
					Query update = session.createQuery(query.toString());
					//parametros actualizar
					this.addParameterSet(articuloUnidadManejoDTO, update);
					
					//parametros where
					update.setInteger("pCompania", articuloUnidadManejoDTO.getId().getCodigoCompania());
					update.setString("pcodigoArticulo", articuloUnidadManejoDTO.getId().getCodigoArticulo());
					update.setLong("pcodigoUnidadManejo", articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
					
					update.executeUpdate();
					
				}
			
			}
//			//Esto es para crear la unidad de manejo
//			else{
//				
//				this.hibernateH.crearObjeto(articuloUnidadManejoDTO);
//			}
		} catch (Exception e) {
			throw new SICException("Error al actualizar unidad manejo", e);
		}
	}
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @return
	 */
	private String construirSet(ArticuloUnidadManejoDTO articuloUnidadManejoDTO){
		StringBuilder set = new StringBuilder();
		
		if( null != articuloUnidadManejoDTO.getValorTipoUnidadEmpaque() ){
			set.append(" artUniMan.valorTipoUnidadEmpaque = :pvalorTipoUnidadEmpaque, ");
		}
		
		if( null != articuloUnidadManejoDTO.getValorUnidadManejo() ){
			set.append(" artUniMan.valorUnidadManejo = :pvalorUnidadManejo, ");
		}
		
		if( null != articuloUnidadManejoDTO.getUserId() ){
			set.append(" artUniMan.idUsuarioModificacion = :pidUsuarioModificacion, ");
		}
		
		if( set.length() > 0 ){
			set.append(" artUniMan.fechaModificacion = :pDate, ");
			
			int position = set.lastIndexOf(",");
			set.deleteCharAt(position);
			
			return set.toString();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @return
	 */
	private void addParameterSet(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Query update){
		
		if( null != articuloUnidadManejoDTO.getValorTipoUnidadEmpaque() ){
			update.setString("pvalorTipoUnidadEmpaque", articuloUnidadManejoDTO.getValorTipoUnidadEmpaque());
			Logeable.LOG_SICV2.info("======> valorTipoUnidadEmpaque {}", articuloUnidadManejoDTO.getValorTipoUnidadEmpaque() );
		}
		
		if( null != articuloUnidadManejoDTO.getValorUnidadManejo() ){
			update.setInteger("pvalorUnidadManejo", articuloUnidadManejoDTO.getValorUnidadManejo());
			Logeable.LOG_SICV2.info("======> ValorUnidadManejo {}", articuloUnidadManejoDTO.getValorUnidadManejo() );
		}
		
		if( null != articuloUnidadManejoDTO.getUserId() ){
			update.setString("pidUsuarioModificacion", articuloUnidadManejoDTO.getUserId());
			Logeable.LOG_SICV2.info("======> UserId {}", articuloUnidadManejoDTO.getUserId() );
		}
		
		update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
	}
	
	

	/**
	 * @param hibernateH the hibernateH to set
	 */
	public final void setHibernateH(IHibernateH<ArticuloUnidadManejoDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
