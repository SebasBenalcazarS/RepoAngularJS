/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.HibernateH;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IEstructuraComercialDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.restricciones.CodigoClasificacionPorProveedorRestriction;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.ClasificacionesPorClasificacionFuncionarioCompradorRestriction;

/**
 * @author gnolivos
 *
 */
public class EstructuraComercialDAO implements IEstructuraComercialDAO{

	private HibernateH<SearchDTO> hibernateH;
	
	@Override
	public ClasificacionDTO obtenerClasificacionesLineaComercial(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, String codigoBodega, String codigoClasificacion, String codigoDepartamento, Long codigoLineaComercial) throws SICException {
		
		ClasificacionDTO resultado;
		
		try {
			
			// Inicializar variables
			this.hibernateH.getSession().clear();

			// Select
			Criteria cr = this.hibernateH.getSession().createCriteria(ClasificacionDTO.class, "cla");	
			
			// Clasificacion
			cr.add(Restrictions.eq("cla.id.codigoCompania", codigoCompania));
			cr.add(Restrictions.eq("cla.estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			if(codigoClasificacion != null){
				cr.createAlias("cla.clasificacionPadre", "clasificacionPadre");
				
				// Departamento
				cr.add(Restrictions.eq("clasificacionPadre.id.codigoCompania", codigoCompania));
				cr.add(Restrictions.eq("clasificacionPadre.estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				
				// Restriccion de por proveedor clasificacion, linea comercial y funcionario
				cr.add(new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(codigoFuncionario, codigoBodega, codigoClasificacion, codigoDepartamento, codigoLineaComercial, "cla.id.codigoClasificacion").getCriteriaRestriction());
				
				cr.createAlias("cla.proveedorClasificacionCol", "proveedorClasificacion");
				
				// Clasificacion proveedor
				cr.add(Restrictions.eq("proveedorClasificacion.id.codigoProveedor", codigoProveedor));
				cr.add(Restrictions.eq("proveedorClasificacion.estadoProveedorClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				
			}else{
				cr.add(new CodigoClasificacionPorProveedorRestriction(codigoFuncionario, codigoBodega, codigoClasificacion, codigoDepartamento, codigoLineaComercial, "cla.id.codigoClasificacion", codigoProveedor).getCriteriaRestriction());
			}
			
			// Ejecutar consulta
			resultado = (ClasificacionDTO) cr.uniqueResult();
			
			return resultado;
			
		} catch (Exception e) {
			throw new SICException("Error al consultar las clasificaciones por linea comercial", e);
		}		
		
	}
	
	public HibernateH<SearchDTO> getHibernateH() {
		return hibernateH;
	}

	public void setHibernateH(HibernateH<SearchDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}

}
