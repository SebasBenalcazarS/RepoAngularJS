package ec.com.smx.sic.cliente.common.articulo;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

public enum EnumCaracteristicaDinamica { 	
	
	@Deprecated
	CARACTERISTICA_APLICAPRECIOVARIABLE(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.precioVariable"),TipoCatalogoArticulo.CARACTERISTICA_APLICAPRECIOVARIABLE),
	CARACTERISTICA_TIENEETIQUETAS(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneEtiquetas"),TipoCatalogoArticulo.CARACTERISTICA_TIENEETIQUETAS),
	CARACTERISTICA_TIENEUSOS(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneUsos"),TipoCatalogoArticulo.CARACTERISTICA_TIENEUSOS),
	CARACTERISTICA_TIENEGARANTIA(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneGarantia"),TipoCatalogoArticulo.CARACTERISTICA_TIENEGARANTIA),
	CARACTERISTICA_NOPERMITIDOENRECETA(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.noPermitidoEnReceta"),TipoCatalogoArticulo.CARACTERISTICA_NOPERMITIDOENRECETA),
	CARACTERISTICA_TIENETALLAS(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneTallas"),TipoCatalogoArticulo.CARACTERISTICA_TIENETALLAS),
	CARACTERISTICA_TIENECOLORES(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneColores"),TipoCatalogoArticulo.CARACTERISTICA_TIENECOLORES),
	CARACTERISTICA_TIENESABORES(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneSabores"),TipoCatalogoArticulo.CARACTERISTICA_TIENESABORES),
	CARACTERISTICA_TIENEAROMAS(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneAromas"),TipoCatalogoArticulo.CARACTERISTICA_TIENEAROMAS),
	CARACTERISTICA_TIENECARACTERISTICAS(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneCaracteristicas"),TipoCatalogoArticulo.CARACTERISTICA_TIENECARACTERISTICAS),
	CARACTERISTICA_TIENEPRESENTACIONES(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tienePresentaciones"),TipoCatalogoArticulo.CARACTERISTICA_TIENEPRESENTACIONES),
	CARACTERISTICA_TIENEDIMENSIONES(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneDimensiones"),TipoCatalogoArticulo.CARACTERISTICA_TIENEDIMENSIONES),
	CARACTERISTICA_NOTIENECONTROLROTULADO(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.noTieneControlRotulado"),TipoCatalogoArticulo.CARACTERISTICA_NOTIENECONTROLROTULADO),
	CARACTERISTICA_ESPERECIBLE(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.esperecible"),TipoCatalogoArticulo.CARACTERISTICA_ESPERECIBLE),
	CARACTERISTICA_TIENEINDICADORPROPIETARIO(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.tieneIndicadorPropietario"),TipoCatalogoArticulo.CARACTERISTICA_TIENEINDICADORPROPIETARIO),
	CARACTERISTICA_VALIDACION_REGISTROSANITARIO(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.validacionRegistroSanitario"),TipoCatalogoArticulo.CARACTERISTICA_VALIDACION_REGISTROSANITARIO),
	CARACTERISTICA_VERIFICA_FECHACADUCIDAD(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.verificaFechaCaducidad"), TipoCatalogoArticulo.CARACTERISTICA_VERIFICA_FECHACADUCIDAD),
	CARACTERISTICA_VALIDACION_PESO_VARIABLE(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.validacionPesoVariable"), TipoCatalogoArticulo.VERIFICA_PESO_VARIABLE),
	CARACTERISTICA_VALIDACION_LEY_ETIQUETADO(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.validaSegmentoEtiquetas"), TipoCatalogoArticulo.VERIFICA_LEY_ETIQUETADO),
	CARACTERISTICA_VALIDACION_ETIQUETADOMERCANCIAS(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.validaEtiquetadoMercancias"),TipoCatalogoArticulo.VERIFICA_ETIQUETA_MERCANCIAS),
	CARACTERISTICA_VALIDACION_OMISION_ASIGNACION_ALCANCES(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.omision.validacion.alcances"),TipoCatalogoArticulo.CARACTERISTICA_OMISION_ASIGNACION_ALCANCES),
	@Deprecated
	CARACTERISTICA_NOAPLICAPVP(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.noAplicaPVP"),TipoCatalogoArticulo.CARACTERISTICA_NOAPLICAPVP),
	@Deprecated
	CARACTERISTICA_COSTOBRUTOMAYORPVP(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.costoBrutoMayorPVP"),TipoCatalogoArticulo.CARACTERISTICA_COSTOBRUTOMAYORPVP),
	@Deprecated
	CARACTERISTICA_PSUPMAYORCOSTONETO(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.PSUPmayorCostoNeto"),TipoCatalogoArticulo.CARACTERISTICA_PSUPMAYORCOSTONETO),
	CARACTERISTICA_TIENECONSERVACION_REFRIGERADO(SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO,SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),
	CARACTERISTICA_TIENECONSERVACION_CONGELADO(SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO,SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),
	CARACTERISTICA_TIENECONSERVACION_LOCAL(SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL,SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),

	// REGLAS DE CALCULO DE PRECIOS
	CARACTERISTICA_PVP_OPCIONAL(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.calculo.precio.pvp.opcional"),TipoCatalogoArticulo.CARACTERISTICA_CALCULO_PRECIO),
	CARACTERISTICA_PRECIOS_PVP_SMX_PERMITEN_MENOR_COSTONETO(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.calculo.precios.pvp.smx.permiten.menor.costoneto"),TipoCatalogoArticulo.CARACTERISTICA_CALCULO_PRECIO),
	CARACTERISTICA_PSMX_PERMITE_MENOR_COSTONETO(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.calculo.precio.psmx.permite.menor.costoneto"),TipoCatalogoArticulo.CARACTERISTICA_CALCULO_PRECIO),
	CARACTERISTICA_MSMX_MAYOR_IGUAL_DOCE_PORCIENTO(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.calculo.precio.msmx.mayor.igual.doce.porciento") , TipoCatalogoArticulo.CARACTERISTICA_CALCULO_PRECIO),
	CARACTERISTICA_NO_APLICA_VALIDACION_TEMPORADA(SICArticuloMessages.getInstancia().getString("catalogo.valor.caracteristica.noAplicaValidacionTemporada") , TipoCatalogoArticulo.CARACTERISTICA_NO_APLICA_VALIDACION_TEMPORADA);
	
	
	
	private String keyId;
	
	private Integer codigoTipo;
	
	private EnumCaracteristicaDinamica(String keyId, Integer codigoTipo) {
		this.keyId = keyId;
		this.codigoTipo = codigoTipo;
	}
	
	public String getKeyId() {
		return keyId;
	}
	
	public Integer getCodigoTipo() {
		return codigoTipo;
	}

	public static EnumCaracteristicaDinamica getEnumByCode(Integer code) {
		if (code != null) {
			for (EnumCaracteristicaDinamica c : EnumCaracteristicaDinamica.values()) {
				if (code.compareTo(c.getCodigoTipo()) == 0) {
					return c;
				}
			}
		}
		return null;
	}
	
	public static EnumCaracteristicaDinamica getEnumByValueCode(final String key, final Integer codigoTipo){
		if(StringUtils.isNotEmpty(key) && codigoTipo != null){
			for(EnumCaracteristicaDinamica enumCaracteristicaDinamica: EnumCaracteristicaDinamica.values()){
				if(StringUtils.equals(key, enumCaracteristicaDinamica.getKeyId()) && (codigoTipo != null && codigoTipo.compareTo(enumCaracteristicaDinamica.getCodigoTipo()) == 0)){
					return enumCaracteristicaDinamica;
				}
			}	
		}		
		return null;
	}
}
