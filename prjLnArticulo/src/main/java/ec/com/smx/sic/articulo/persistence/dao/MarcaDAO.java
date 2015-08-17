package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IMarcaDAO;

public class MarcaDAO implements Logeable, IMarcaDAO{
	
	private IHibernateH<ProveedorMarcaDTO> hibernateH;
	
	@Override
	public int cambiarEstadoMarcaProveedor(Collection<ProveedorMarcaDTO> proveedorMarcaCol,String estado,UserDto userDto){
		StringBuilder query = new StringBuilder();
		Session session;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();		
			query.append("update ").append(ProveedorMarcaDTO.class.getName()).append(" pm set pm.estado = :pEstado, idUsuarioModificacion = :pUserAuditId, fechaModificacion = :pDate where pm.id.codigoProveedor in ")
			.append("(:pCodProveedores) and pm.id.codigoCompania = :pCompania and pm.id.secuencialMarca = :pSecuencialMarca");
			Query update =session.createQuery(query.toString());
			update.setString("pEstado", estado);
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));		
			update.setString("pUserAuditId",userDto.getUserId());
			update.setLong("pSecuencialMarca",proveedorMarcaCol.iterator().next().getId().getSecuencialMarca());
			update.setInteger("pCompania",proveedorMarcaCol.iterator().next().getId().getCodigoCompania());
			Collection<String> proveedorMarcaIDList = new ArrayList<String>();		
			for(ProveedorMarcaDTO proveedorMarcaDTO:proveedorMarcaCol){
				proveedorMarcaIDList.add(proveedorMarcaDTO.getId().getCodigoProveedor());
			}
			update.setParameterList("pCodProveedores",proveedorMarcaIDList);
			return update.executeUpdate();
		}catch(Exception e){
			throw new SICException("Error al cambiar de estado en proveedoresMarca",e);
		}
	}

	public void setHibernateH(IHibernateH<ProveedorMarcaDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
	
	

}
