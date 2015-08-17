/**
 * 
 */
package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * @author jmontenegro
 *
 */
public enum EnumValorFiltrosUbicacion {

	NAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.nave")),
	SUBNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.subnave")),
	PASILLO_INICIAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.pasilloini")),
	PASILLO_FINAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.pasillofin")),
	RACK_INICIAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.rackini")),
	RACK_FINAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.rackfin")),
	UBICACION_INICIAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.ubicacionini")),
	UBICACION_FINAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.ubicacionfin")),
	SUBBODEGA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.subbodega")),
	BODEGA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.bodega")),
	AREA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.area")),
	AREAT(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.area.todo")),
	CODIGOAREA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codigoarea")),
	TIPOALMACENAMIENTO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.tipoalmacenamiento")),
	CODIGOALMACENAMIENTO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codigoalmacenamiento")),
	CODIGOBARRAS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codigobarras")),
	CODIGOBARRASUNIDADMANEJO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codigobarrasunidadmanejo")),
	DESCRIPCIONARTICULO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.descripcionarticulo")),
	CANTIDADUNIDADMANEJO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.cantidadunidadmanejo")),
	ISARTICULO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.is.articulo")),
	ISQUITARUBICACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.is.quitar.ubicacion")),
	SINARTICULO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.sinarticulo")),
	CONARTICULO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.conarticulo")),	
	CODIGOAREATRABAJO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codareatra")),
	CODIGOAREATRABAJOPADRE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codareatrapadre")),
	CODIGOCOMPANIA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codcom")),
	USERID(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.userid")),
	VALORTIPOLADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.valortipolado")),
	NIVEL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.nivel")),
	CODIGODETSECAREA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.coddetsecarea")),
	CODIGODETSECNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.coddetsecnave")),
	CODIGODETSECSUBNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.coddetsecsubnave")),
	IDENTIFICADORNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.identificadornave")),
	IDENTIFICADORSUBNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.identificadorsubnave")),
	DESCRIPCIONSUBNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.descripcionsubnave")),
	CODIGOSECCIONNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codseccnave")),
	CODIGOSECCIONSUBNAVE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codseccsubnave")),
	CODIGOSECCIONPASILLO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codseccpas")),
	CODIGOSECCIONRACK(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codseccrack")),
	CODIGOSECCIONUBI(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codseccubi")),
	CODIGOSUBAREATRABAJO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.codsubareatra")),
	TIPOSECCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.tiposeccion")),
	PASILLO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.pasillo")),
	IDENTIFICADOR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.identificador")),
	RACK(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.filter.rack"));
	
	private String valorFiltroUbicacion;

	private  EnumValorFiltrosUbicacion(String valorFiltroUbicacion){
		this.valorFiltroUbicacion = valorFiltroUbicacion;
	}
	
	/**
	 * @return the valorFiltroUbicacion
	 */
	public String getValorFiltroUbicacion() {
		return valorFiltroUbicacion;
	}

	/**
	 * @param valorFiltroUbicacion the valorFiltroUbicacion to set
	 */
	public void setValorFiltroUbicacion(String valorFiltroUbicacion) {
		this.valorFiltroUbicacion = valorFiltroUbicacion;
	}
	
	
	
}
