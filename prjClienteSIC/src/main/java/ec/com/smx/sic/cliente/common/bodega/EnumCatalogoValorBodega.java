package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en los procesos de bodega
 * @author fcollaguazo
 *
 */
public enum EnumCatalogoValorBodega {

	//VALORES DE BODEGA
	VALOR_BODEGA_MBO(CorporativoConstantes.TIPO_AREATRABAJO_MACRO_BODEGA),
	VALOR_BODEGA_CD(CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DE_DISTRIBUCION),
	VALOR_BODEGA_CDT(CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DE_DISTRIBUCION),
	VALOR_BODEGA_UOP(CorporativoConstantes.TIPO_AREATRABAJO_UNIDAD_OPERATIVA),
	VALOR_BODEGA_BOD(CorporativoConstantes.TIPO_AREATRABAJO_BODEGA),
	VALOR_BODEGA_SBO(CorporativoConstantes.TIPO_AREATRABAJO_SUBBODEGA),
	
	//VALORES DE SECCIONES
	VALOR_SECCION_ANDEN(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.anden")),
	VALOR_SECCION_NAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.nave")),
	VALOR_SECCION_SUBNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.subnave")),
	VALOR_SECCION_PASILLO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.pasillo")),
	VALOR_SECCION_RACK(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.rack")),
	VALOR_SECCION_UBICACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.ubicacion")),
	VALOR_SECCION_PERCHA(SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorSeccionPercha")),
	VALOR_SECCION_FURGON(SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorSeccionFurgon")),
	VALOR_SECCION_AREA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.area")),
	VALOR_SECCION_BALANZA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.seccion.balanza")),
	
	//VALORES DE SECCIONES
	VALOR_AREA_TRABAJO_BODEGA(SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorAreaTrabajoBodega")),
	VALOR_AREA_TRABAJO_LOCAL(SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorAreaTrabajoLocal")),	
	VALOR_AREA_TRABAJO_CDT(SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorAreaTrabajoCDT")),
	
	//VALORES DE TIPO UBICACION
	VALOR_TIPO_UBICACION_REAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.ubicacion.fisica")),
	VALOR_TIPO_UBICACION_VIRTUAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.ubicacion.valor.tipo.ubicacion.virtual")),
	
	//VALORES DE TIPO ALMACENAMIENTO
	VALOR_TIPO_ALMACENAMIENTO_SURTIDO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.valor.tipo.almacenamiento.surtido")),
	VALOR_TIPO_ALMACENAMIENTO_RESERVA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.logistica.bodega.valor.tipo.almacenamiento.reserva")),
	
	
	//VALOR BODEGA MENU
	VALOR_BODEGA_MENU(SICMessages.getInstancia().getString("ec.com.smx.sic.web.logistica.bodega.valorBodegaMenu")),
	
	//VALORES PARA OBTENER EL TIPO DE CALENDARIO A UTILIZAR
	VALOR_TIPOAREATRABAJO_VISUALIZACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.tipo.visualizacion")),
	VALOR_TIPOAREATRABAJO_RELACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.tipo.relacion")),
	VALOR_CODIGOCATALOGO_CONFIGURACION_CALENDARIO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.codigo.catalogo.configuracion.calendario")),
	VALOR_TIPOAREATRABAJO_PADRE_CALENDARIO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.calendario.valor.relacion.padre")),
	
	
	//VADIDACION DE FACTURAS
	VALOR_VALIDACION_FACTURAS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.valor.catalogo.configuracion.validacion.facturas")),
	;
	
	
	
	private String codigoCatalogoValor;
	
	private EnumCatalogoValorBodega(String codigoCatalogoValor){
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
