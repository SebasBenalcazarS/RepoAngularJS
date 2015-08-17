
package ec.com.smx.sic.cliente.common.bodega;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en la recepcion al momento de crear y recibir
 * 
 * @author lguaman
 *
 */
public enum EnumValidacionRecepcion {

	//VALORES PARA VALIDACIONES EN LA RECEPCION
	VALIDAR_FECHA_CADUCIDAD_ARTICULO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.fecha.caducidad.articulo")),
	VALIDAR_SELECCIONAR_ENTREGAS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.fecha.seleccionar.entregas")),
	VALIDAR_RELACIONAR_ARTICULO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.relacionar.articulo")),
	VALIDAR_TECLADO_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.verificar.teclado")),
	VALIDAR_SELECCIONAR_PROGRAMA_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.seleccionar.programa.recepcion")),
	INGRESAR_TOTALES_FACTURAS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.ingresar.totales.factura")),
	SELECCIONAR_ARTICULOS_TOMAR_PESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.seleccionar.articulos.tomar.peso")),
	NUMERO_FACTURAS_INGRESAR_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.numero.facturas.ingresar.recepcion")),
	PALLET_PESADO_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.pallet.pesado.recepcion")),
	CANTIDAD_MAXIMA_PESAR_PALLETS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.cantidad.maxima.pesar.pallets")),
	CAMBIAR_PRECIO_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.configuracion.recepcion.parametro.cambio.precio.recepcion")),
	VALIDAR_EDICION_FACTURAS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.configuracion.recepcion.parametro.edicion.facturas")),
	CONFIGURAR_VALIDACIONES_ETIQUETADO_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.configurar.validaciones.etiquetado")),
	CONFIGURAR_MENU_CONTEXTUAL_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.configurar.menu.contextual.recepcion")),
	ENVIAR_INTEGRACION_INVENTARIOS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.enviar.integracion.inventarios")),
	
	//Valores para la ubicacion de despcho arriba, medio, abajo
	UBICACION_ARRIBA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.valor.ubicacion.despacho.arriba")),
	UBICACION_MEDIO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.valor.ubicacion.despacho.medio")),
	UBICACION_ABAJO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.valor.ubicacion.despacho.abajo")),
	
	//Valor para obtener el articulo que corresponde al pallet de recepcion
	CARACTERISTICA_PALLET_RECEPCION_MADERA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.pallet.madera")),
	CARACTERISTICA_PALLET_RECEPCION_PLASTICO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.pallet.plastico")),
	
	//Valor para la cantidad minima de pallets que tiene que llevar el recolector
	CANTIDAD_MINIMA_RECOLECTAR_PALLETS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.cantidad.minima.recolectar")),
	
	//VALORES PARA EL ALGORITMO DE RECEPCION
	SELECCIONAR_ALGORITMO_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.seleccionar.algoritmo.recepcion")),
	ORDENAR_ORDENCOMPRA_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.ordenar.ordenCompra.recepcion")),
	
	
	//VALORES ASINGACION ANDENES
	PERMITIR_ANDEN_COMPARTIDO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.recepcion.permitir.anden.compartido")),
	;
		
	
	private String codigoCatalogoValor;
	
	private EnumValidacionRecepcion(String codigoCatalogoValor){
		this.codigoCatalogoValor = codigoCatalogoValor;
	}

	/**
	 * @return the codigoCatalogoValor
	 */
	public String getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}

	/**
	 * @param codigoCatalogoValor the codigoCatalogoValor to set
	 */
	public void setCodigoCatalogoValor(String codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}
}
