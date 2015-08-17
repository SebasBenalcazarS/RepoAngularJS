/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.proveedor.TipoCatalogosProveedor;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;

/**
 * @author Mario Braganza
 *
 */

//TODO cuando se instancia un controlador
@SuppressWarnings("serial")
public abstract class CaracteristicaProveedorVO extends CaracteristicaNivelReporteVO<IProveedor> {
	

	/**
	 * 
	 * @return
	 */
	public Collection<ConfiguracionNivelPagoDTO> getConfiguracionesNivelesPagosReportes(){
		return super.getDatosConfiguracionNivelPagoReportes().getConfiguracionesNivelesPago();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasInterproveedor(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_INTERPROVEEDOR);
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaInterproveedor(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_INTERPROVEEDOR);
	}
	
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaInterproveedor(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_INTERPROVEEDOR);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasOrigenProveedor(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_ORIGEN_PROVEEDOR);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaOrigenProveedor(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_ORIGEN_PROVEEDOR);
	}
	
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaOrigenProveedor(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_ORIGEN_PROVEEDOR);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasAutorizadoProntoPago(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_AUTORIZADO_PRONTOPAGO);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaAutorizadoProntoPago(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_AUTORIZADO_PRONTOPAGO);
	}
	
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaAutorizadoProntoPago(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_AUTORIZADO_PRONTOPAGO);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasPagaEspacioPercha(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PAGA_ESPACIO_PERCHA);
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaPagaEspacioPercha(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PAGA_ESPACIO_PERCHA);
	}
	
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaPagaEspacioPercha(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PAGA_ESPACIO_PERCHA);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasPagaEspacioPerchaIgualAnterior(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PAGO_ESPACIO_PERCHA_IGUAL_ANTERIOR);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaPagaEspacioPerchaIgualAnterior(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PAGO_ESPACIO_PERCHA_IGUAL_ANTERIOR);
	}
	
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaPagaEspacioPerchaIgualAnterior(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PAGO_ESPACIO_PERCHA_IGUAL_ANTERIOR);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasRegistroParticipaciones(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_REGISTRO_PARTICIPACIONES);
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaRegistroParticipaciones(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_REGISTRO_PARTICIPACIONES);
	}
	
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaRegistroParticipaciones(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_REGISTRO_PARTICIPACIONES);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasProcesoEnvioEmail(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PROCESO_ENVIO_EMAIL);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaProcesoEnvioEmail(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PROCESO_ENVIO_EMAIL);
	}
	
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaProcesoEnvioEmail(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_PROCESO_ENVIO_EMAIL);
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaAccesoPedidosDevoluciones(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_ACCESO_PEDIDOS_DEVOLUCIONES);
	}
	
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaAccesoPedidosDevoluciones(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_ACCESO_PEDIDOS_DEVOLUCIONES);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasAccesoPedidosDevoluciones(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PERFIL_ACCESO_PEDIDOS_DEVOLUCIONES);
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaCondicionProveedor(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_CONDICION_PROVEEDOR);
	}
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaCondicionProveedor(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_CONDICION_PROVEEDOR);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasCondicionProveedor(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_CONDICION_PROVEEDOR);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicaEsImportador(){
		return this.getIndiceCaracteristicaSeleccionada(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PROVEEDOR_IMPORTADOR);
	}
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicaEsImportador(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TiposCatalogoConstantes.TIPO_CARACTERISTICA_PROVEEDOR_IMPORTADOR);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasEsImportador(){
		return this.getCaracteristicas(TiposCatalogoConstantes.TIPO_CARACTERISTICA_PROVEEDOR_IMPORTADOR);
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getIndiceCaracteristicasFacturaEnSitio(){
		return this.getIndiceCaracteristicaSeleccionada(TipoCatalogosProveedor.TIPO_CARACTERISTICA_FACTURA_EN_SITIO);
	}
	
	/**
	 * 
	 * @param indiceCaracteristica
	 */
	public void setIndiceCaracteristicasFacturaEnSitio(Integer indiceCaracteristica){
		this.setIndiceCaracteristicaSeleccionada(indiceCaracteristica, TipoCatalogosProveedor.TIPO_CARACTERISTICA_FACTURA_EN_SITIO);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCaracteristicasFacturaEnSitio(){
		return this.getCaracteristicas(TipoCatalogosProveedor.TIPO_CARACTERISTICA_FACTURA_EN_SITIO);
	}
}
