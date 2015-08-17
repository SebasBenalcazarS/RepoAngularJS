/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.proveedor.calculo;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.ListSet;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.common.proveedor.TipoCatalogosProveedor;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.calculo.ICalculoArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.proveedor.condicionescomerciales.almacenamiento.IAlmacenamientoProveedorClasificacionGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;

/**
 * @author fmunoz
 *
 */
public class CalculoArticuloProveedorGestor implements ICalculoArticuloProveedorGestor {

	private DataGestor dataGestor;
	private IAlmacenamientoProveedorClasificacionGestor almProClaGestor;
	
	/**
	 * @param articuloProveedorDTO
	 * @throws SICRuleException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void asignarCondicionComercial(ArticuloProveedorDTO articuloProveedorDTO)throws SICRuleException{
		ProveedorClasificacionDTO procla = new ProveedorClasificacionDTO();
		try{
			
			if(articuloProveedorDTO.getTieneArticulo() && !StringUtils.isEmpty(articuloProveedorDTO.getArticulo().getCodigoClasificacion())){
				procla.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
				procla.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
				procla.getId().setCodigoClasificacion(articuloProveedorDTO.getArticulo().getCodigoClasificacion());
				procla = dataGestor.findUnique(procla);
				
				if(procla == null){
					procla = new ProveedorClasificacionDTO();
					procla.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
					procla.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
					procla.getId().setCodigoClasificacion(articuloProveedorDTO.getArticulo().getCodigoClasificacion());
				}
				
				if(!articuloProveedorDTO.getTieneDescuentoProveedorArticuloCol()){// <>TIPODESCUENTO
					DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO = new DescuentoProveedorArticuloDTO();
					descuentoProveedorArticuloDTO.setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
					descuentoProveedorArticuloDTO.setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
					descuentoProveedorArticuloDTO.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
					descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setCodigoAsignacionTipoDescuento(EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO);
					descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setValorAsignacionTipoDescuento(EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento());
					descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setCodigoAplicacionTipoDescuento(EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
					descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setValorAplicacionTipoDescuento(EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
					descuentoProveedorArticuloDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					
					Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloDTOs = dataGestor.findObjects(descuentoProveedorArticuloDTO);
					
					if(CollectionUtils.isNotEmpty(descuentoProveedorArticuloDTOs)){
						articuloProveedorDTO.setDescuentoProveedorArticuloCol(descuentoProveedorArticuloDTOs);
					}
				}
				procla.setUserId(articuloProveedorDTO.getUserId());
				procla.setDescuentosProveedorClasificacion(this.construirCondicionesComerciales(articuloProveedorDTO));
				procla.setValorTipoPlazoPago(articuloProveedorDTO.getValorPlazoPago());
				procla.setCodigoTipoPlazoPago(TipoCatalogosProveedor.TIPO_PLAZO_PAGO_DIAS);
				if(StringUtils.isEmpty(procla.getEstadoProveedorClasificacion()) || (StringUtils.isNotEmpty(procla.getEstadoProveedorClasificacion()) && StringUtils.equals(procla.getEstadoProveedorClasificacion(), SICConstantes.ESTADO_INACTIVO_NUMERICO))){
					procla.setEstadoProveedorClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				}
				//se almacenan los datos
				almProClaGestor.almacenarClasificacionProveedor(procla);
			}
			
		}catch (SICRuleException e) {
			throw e;
		}catch (Exception e) {
			throw new SICRuleException("Error al asignar la condici\u00F3n comercial",e);
		}
	}

	/**
	 * armamos la estructura de los descuentos proveedor clasificacion en base a los descuentos del articulo proveedor
	 * @param ap
	 * @return
	 */
	private ListSet construirCondicionesComerciales(ArticuloProveedorDTO ap){
		if(ap.getTieneDescuentoProveedorArticuloCol()){
			ListSet desProClaCol = new ListSet();
			for(DescuentoProveedorArticuloDTO dpa : ap.getDescuentoProveedorArticuloCol()){
				//verificamos que es activo y que no sea nota de credito
				if(StringUtils.equals(dpa.getEstado(), SICConstantes.ESTADO_ACTIVO_NUMERICO) && !EnumTipoAplicacionDescuento.COSTO_CONVENIO.equals(dpa.getAsignacionTipoDescuento().getValorAplicacionTipoDescuento())){
					DescuentoProveedorClasificacionDTO dpc = new DescuentoProveedorClasificacionDTO();
					dpc.getId().setCodigoCompania(ap.getId().getCodigoCompania());
					dpc.setCodigoProveedor(ap.getId().getCodigoProveedor());
					dpc.setCodigoClasificacion(ap.getArticulo().getCodigoClasificacion());// <>TIPODESCUENTO
					dpc.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
					dpc.getAsignacionTipoDescuento().setCodigoTipoDescuento(dpa.getAsignacionTipoDescuento().getCodigoTipoDescuento());
					dpc.setSecuencialAsignacionTipoDescuento(dpa.getSecuencialAsignacionTipoDescuento());
					dpc.getAsignacionTipoDescuento().setValorAplicacionTipoDescuento(dpa.getAsignacionTipoDescuento().getValorAplicacionTipoDescuento());
					dpc.getAsignacionTipoDescuento().setCodigoAplicacionTipoDescuento(dpa.getAsignacionTipoDescuento().getCodigoAplicacionTipoDescuento());
					dpc.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					dpc.setPorcentajeDescuento(dpa.getPorcentajeDescuento());
					desProClaCol.add(dpc);
				}
			}
			return desProClaCol;
		}
		return null;
	}
	/**
	 * 
	 * @param articuloProveedorDTO
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO)throws SICRuleException{
		if(articuloProveedorDTO.getCostoBruto() == null){
			articuloProveedorDTO.setCostoBruto(0d);
		}
		if(articuloProveedorDTO.getPorcentajeExesoRecepcion() == null){
			articuloProveedorDTO.setPorcentajeExesoRecepcion(0d);
		}
		if(StringUtils.isEmpty(articuloProveedorDTO.getEstadoArticuloProveedor())){
			articuloProveedorDTO.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
	}
	
	/**
	 * @return the dataGestor
	 */
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public IAlmacenamientoProveedorClasificacionGestor getAlmProClaGestor() {
		return almProClaGestor;
	}

	public void setAlmProClaGestor(IAlmacenamientoProveedorClasificacionGestor almProClaGestor) {
		this.almProClaGestor = almProClaGestor;
	}	
}
