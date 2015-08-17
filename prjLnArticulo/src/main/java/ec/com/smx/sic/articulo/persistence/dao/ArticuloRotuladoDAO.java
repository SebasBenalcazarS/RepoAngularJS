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
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRotuladoDAO;

public class ArticuloRotuladoDAO implements Logeable, IArticuloRotuladoDAO {
	private IHibernateH<ArticuloVO> hibernateH;
	
	@Override
	public int cambiarEstadoArticulo(Collection<ArticuloDTO> articuloDTOCol,String estado,UserDto userDto){
		
		StringBuilder sql = new StringBuilder();
		Session session;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();		
			sql.append("update ").append(ArticuloDTO.class.getName()).append(" a set a.estadoArticulo = :pEstadoArticulo, usuarioActualizacion = :pUserAuditId, fechaUltimaActualizacion = :pDate where a.id.codigoArticulo in ")
			.append("(:pCodArticulos) and a.id.codigoCompania = :pCompania");
			Query update =session.createQuery(sql.toString());
			update.setString("pEstadoArticulo", estado);
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));		
			update.setString("pUserAuditId",userDto.getUserId());
			update.setInteger("pCompania",articuloDTOCol.iterator().next().getId().getCodigoCompania());
			Collection<String> articuloIDList = new ArrayList<String>();		
			for(ArticuloDTO articuloDTO:articuloDTOCol){
				articuloIDList.add(articuloDTO.getId().getCodigoArticulo());
			}
			update.setParameterList("pCodArticulos",articuloIDList);
			return update.executeUpdate();
		}catch(Exception e){
			throw new SICException("Error al cambiar de estado en los articulos",e);
		}
	}
	
}
