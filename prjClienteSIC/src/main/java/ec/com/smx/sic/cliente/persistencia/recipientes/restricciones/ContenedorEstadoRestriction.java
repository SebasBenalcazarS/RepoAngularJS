package ec.com.smx.sic.cliente.persistencia.recipientes.restricciones;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaTransferencia;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminContenedorVO;
/**
 * Restriccion para obtner las cajas por area de trabajo
 * @author cherrera
 *
 */
@SuppressWarnings("serial")
public class ContenedorEstadoRestriction implements CriteriaRestriction{
	private String propertyIn;
	private PlantillaBusquedaTransferencia plantillaBusquedaTransferencia;
	private AdminContenedorVO adminContenedorVO;
	//Constructor
	public	ContenedorEstadoRestriction (String propertyIn,Map<String, Object> componentesBusqueda, AdminContenedorVO adminContenedorVO){
		this.propertyIn = propertyIn;
		this.plantillaBusquedaTransferencia = (PlantillaBusquedaTransferencia) componentesBusqueda.get("filtroBusquedaTransferencia");
		this.adminContenedorVO = adminContenedorVO;
	}
	@Override
	public Criterion getCriteriaRestriction() {
		 Criterion criterion = null;
			
			try{
				DetachedCriteria subSelectContenedorEstado = DetachedCriteria.forClass(ContenedorEstadoDTO.class, "contenedorEstado");
				subSelectContenedorEstado.setProjection(Projections.property("contenedorRelacionado.id.codigoContenedorPadre"));
				subSelectContenedorEstado.createAlias("contenedorEstado.contenedorDTO", "contenedor");
				subSelectContenedorEstado.createAlias("contenedor.contenedorRelacionadoDTOCol", "contenedorRelacionado");
				subSelectContenedorEstado.createAlias("contenedor.procesoLogisticoDTO", "procesoLogistico");
				subSelectContenedorEstado.createAlias("procesoLogistico.procesoLogisticoTransaccionDTOCol", "procesoLogisticoTransaccion");
				subSelectContenedorEstado.createAlias("procesoLogistico.transferenciaDTO", "transferencia");
				subSelectContenedorEstado.createAlias("transferencia.areaTrabajoOrigenDTO", "areaTrabajoOrigen");
				subSelectContenedorEstado.createAlias("transferencia.areaTrabajoDestinoDTO", "areaTrabajoDestino");
				
				//Estado activos
				subSelectContenedorEstado.add(Restrictions.eq("contenedorEstado.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				
				//Departamento
				if(plantillaBusquedaTransferencia.getCodigoDepartamentoFil() != null){
					String[] departamentoCol= plantillaBusquedaTransferencia.getCodigoDepartamentoFil().getParameterValues();
					subSelectContenedorEstado.add(Restrictions.in("contenedor.codigoClasificacion", departamentoCol));
				}
				
				//Tipo de transaccion
				if(adminContenedorVO.getTipoTransaccionSeleccionada() != null){
					if(adminContenedorVO.getTransaccionSeleccionada() != null && adminContenedorVO.getTransaccionSeleccionada().equals("todos") && adminContenedorVO.getTipoTransaccionSsaLiqCol() != null ){
						ArrayList<Integer> codigoTipoTransaccion = new ArrayList<Integer>();
						for(TransaccionDTO transaccionDTO: adminContenedorVO.getTipoTransaccionSsaLiqCol()){
							codigoTipoTransaccion.add(transaccionDTO.getId().getCodigoTipoTransaccion());
						}
						subSelectContenedorEstado.add(Restrictions.in("procesoLogisticoTransaccion.id.codigoTransaccion", codigoTipoTransaccion));
					}else{
						subSelectContenedorEstado.add(Restrictions.eq("procesoLogisticoTransaccion.id.codigoTransaccion", adminContenedorVO.getTipoTransaccionSeleccionada().getId().getCodigoTipoTransaccion()));
					}
				}
			
				//Tipo pallet
				subSelectContenedorEstado.add(Restrictions.isNotNull("contenedor.codigoClasificacion"));
				
				//Codigo area trabajo origen
				if(plantillaBusquedaTransferencia.getCodigoAreaTrabajoOrigenFil() != null){
					Integer[] areaTrabajoOrigenCol= plantillaBusquedaTransferencia.getCodigoAreaTrabajoOrigenFil().getParameterValues();
					subSelectContenedorEstado.add(Restrictions.in("areaTrabajoOrigen.codigoReferencia", areaTrabajoOrigenCol));
				}
				//Codigo area trabajo destino
				if(plantillaBusquedaTransferencia.getCodigoAreaTrabajoDestinoFil() != null){
					Integer[] areaTrabajoDestinoCol= plantillaBusquedaTransferencia.getCodigoAreaTrabajoDestinoFil().getParameterValues();
					subSelectContenedorEstado.add(Restrictions.in("areaTrabajoDestino.codigoReferencia", areaTrabajoDestinoCol));
				}
				
				criterion = Subqueries.propertyIn(this.propertyIn, subSelectContenedorEstado);
			}catch(Exception e){
				throw new SICException("Se produjo un error al momento de armar la restricci�n");
			}
			
		return criterion;
	}
}

