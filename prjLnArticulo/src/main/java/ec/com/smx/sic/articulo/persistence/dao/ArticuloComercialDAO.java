package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;

import org.hibernate.Query;
import org.hibernate.Session;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloComercialDAO;

public class ArticuloComercialDAO implements Logeable, IArticuloComercialDAO {

	private IHibernateH<ArticuloComercialDTO> hibernateH;
	
	public Integer actualizarMarcaComercial(Integer codigoCompania, String codigoArticulo, String userId, Long codigoMarca) throws SICException {
		Logeable.LOG_SICV2.info("==> Actualizacion articuloComercial");
		
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("update ").append(ArticuloComercialDTO.class.getName()).append(" artcom ")
			.append("set ")
			.append("artcom.codigoMarcaComercial = :pCodigoMarcaComercial, ")			
			.append("artcom.idUsuarioModificacion = :pUsuarioActualizacion, ")
			.append("artcom.fechaModificacion = :pDate ")
			.append("where artcom.id.codigoCompania = :pCompania ")
			.append("and artcom.id.codigoArticulo = :pCodigoArticulo ");
			
			Query update = session.createQuery(query.toString());
			
			//parametros actualizar
			update.setLong("pCodigoMarcaComercial", codigoMarca);
			update.setString("pUsuarioActualizacion", userId);
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
			
			//parametros where
			update.setInteger("pCompania", codigoCompania);
			update.setString("pCodigoArticulo", codigoArticulo);
			
			return update.executeUpdate();
			
		} catch (Exception e) {
			throw new SICException("Error al actualizar la informacion de articuloComercial.", e);
		}
		
	}

	public void setHibernateH(IHibernateH<ArticuloComercialDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
