package ec.com.smx.sic.articulo.persistence.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroAsignacionLocalDAO;


/**
 * clase que administra la asignacion de unidades por local
 * @author corbe
 *
 */
public class ArticuloRegistroAsignacionLocalDAO implements IArticuloRegistroAsignacionLocalDAO{
	
	private SessionFactory sessionFactory;
	
	/**
	 * metodo que actualiza los datos de asignacion de pedido por local, recibe una coleccion
	 */
	public void registrarArticuloLocalPedido(Collection<ArticuloLocalPedidoDTO> articuloLocalPedidoCol) throws SICException{
		for(ArticuloLocalPedidoDTO articuloLocalPedidoDTO : articuloLocalPedidoCol){
			try{
				this.registrarAsignacionLocal(articuloLocalPedidoDTO);
			}catch (Exception e){
				throw new SICException(e);
			}
		}
	}
	
	/**
	 * metodo que actualiza los datos de asignacion de pedido por local, recibe un objeto articuloLocal
	 * @param articuloLocalDTO
	 * @throws Exception
	 */
	private void registrarAsignacionLocal(ArticuloLocalPedidoDTO articuloLocalPedidoDTO) throws Exception{
		try{
			
			Session session = sessionFactory.getCurrentSession();
			StringBuilder query = new StringBuilder();
			Query sqlQuery = null;
			if(articuloLocalPedidoDTO.getEsCreacion()){
				query.append("INSERT INTO SCSADTARTLOCPED (CODIGOCOMPANIA , CODIGOLOCAL, CODIGOARTICULO , CANTIDADMAXIMA , " +
						"FECHAINICIO , FECHAFIN , CODIGOTIPOEMPAQUE , VALORTIPOEMPAQUE , FECHAREGISTRO , IDUSUARIOREGISTRO) VALUES ("); 
				query.append(" "+articuloLocalPedidoDTO.getId().getCodigoCompania()+" ,");
				query.append(" "+articuloLocalPedidoDTO.getId().getCodigoLocal()+" ,");
				query.append(" '"+articuloLocalPedidoDTO.getId().getCodigoArticulo()+"' ,");
				query.append(" "+articuloLocalPedidoDTO.getCantidadMaxima()+" ,");
				
				if(articuloLocalPedidoDTO.getFechaInicio() != null){
					query.append(" '"+articuloLocalPedidoDTO.getFechaInicio()+"' ,");
				}else{
					query.append(" "+null+" ,");
				}
				
				if(articuloLocalPedidoDTO.getFechaFin() != null){
					query.append(" '"+articuloLocalPedidoDTO.getFechaFin()+"' ,");
				}else{
					query.append(" "+null+" ,");
				}
				
				query.append(" "+articuloLocalPedidoDTO.getCodigoTipoEmpaque()+" ,");
				query.append(" '"+articuloLocalPedidoDTO.getValorTipoEmpaque()+"' ,");
				query.append(" '"+articuloLocalPedidoDTO.getFechaRegistro()+"' ,");
				query.append(" '"+articuloLocalPedidoDTO.getIdUsuarioRegistro()+"')");
			}
			else{
				query.append("UPDATE SCSADTARTLOCPED SET"); 
				query.append(" CANTIDADMAXIMA = "+articuloLocalPedidoDTO.getCantidadMaxima()+" ,");
				
				if(articuloLocalPedidoDTO.getFechaInicio() != null){
					query.append(" FECHAINICIO = '"+articuloLocalPedidoDTO.getFechaInicio()+"' ,");
				}else{
					query.append(" FECHAINICIO = "+null+" ,");
				}
				
				if(articuloLocalPedidoDTO.getFechaFin() != null){
					query.append(" FECHAFIN = '"+articuloLocalPedidoDTO.getFechaFin()+"' ,");
				}else{
					query.append(" FECHAFIN = "+null+" ,");
				}
				
				query.append(" FECHAMODIFICACION= '"+articuloLocalPedidoDTO.getFechaModificacion()+"' ,");
				query.append(" IDUSUARIOMODIFICACION = '"+articuloLocalPedidoDTO.getIdUsuarioModificacion()+"'");
				query.append(" WHERE CODIGOCOMPANIA = "+articuloLocalPedidoDTO.getId().getCodigoCompania());
				query.append(" AND CODIGOLOCAL = "+articuloLocalPedidoDTO.getId().getCodigoLocal());
				query.append(" AND CODIGOARTICULO = '"+articuloLocalPedidoDTO.getId().getCodigoArticulo()+"'");
			}
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch (Exception e){
			throw e;
		}
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
