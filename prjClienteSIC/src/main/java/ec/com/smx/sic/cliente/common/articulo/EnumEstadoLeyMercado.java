package ec.com.smx.sic.cliente.common.articulo;

import org.apache.commons.lang3.StringUtils;

/**
 * Enumerado que representa los estados que puede tener un art\u00EDculo seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
 * @author mgranda
 *
 */
public enum EnumEstadoLeyMercado {

	/**
	 * Estado de un articulo que fue recibido por primera vez en bodega
	 */
	CODIFICADO(TipoCatalogoArticulo.ESTADO_LEY_MERCADO_CODIFICADO, TipoCatalogoArticulo.TIPO_ESTADO_LEY_MERCADO),
	
	/**
	 * Estado de un articulo que fue catalogado con clase OBSOLETO o estado INACTIVO
	 */
	DESCODIFICADO(TipoCatalogoArticulo.ESTADO_LEY_MERCADO_DESCODIFICADO, TipoCatalogoArticulo.TIPO_ESTADO_LEY_MERCADO),
	
	/**
	 * Estado de un articulo que cambio de clase OBSOLETA o de estado INACTIVO
	 */
	REACTIVADO(TipoCatalogoArticulo.ESTADO_LEY_MERCADO_REACTIVADO, TipoCatalogoArticulo.TIPO_ESTADO_LEY_MERCADO);
	
	//=============================================================================
	//							CONSTRUCTOR
	//=============================================================================
	
	/**
	 * Constructor del enumerado para que cada valor posee el c\u00F3digo del cat\u00E1logo y c\u00F3digo del tipo correspondiente
	 * @author mgranda
	 * @param codigoValor
	 * @param codigoTipo
	 */
	private EnumEstadoLeyMercado(String codigoValor, Integer codigoTipo) {
		this.codigoValor = codigoValor;
		this.codigoTipo = codigoTipo;
	}

	//=============================================================================
	//							ATRIBUTOS
	//=============================================================================	
	private String codigoValor;//valor del catalogo de estados	
	private Integer codigoTipo;//codigo del catalogo de estados
	
	/**
	 * Metodo que permite obtener el enumerado de estados segun el codigo y valor del catalogo equivalente
	 * @author mgranda
	 * @param codigoValor
	 * @param codigoTipo
	 * @return 
	 */
	public static EnumCaracteristicaDinamica getEnumByValueCode(final String codigoValor, final Integer codigoTipo){
		if(StringUtils.isNotEmpty(codigoValor) && codigoTipo != null){
			for(EnumCaracteristicaDinamica enumCaracteristicaDinamica: EnumCaracteristicaDinamica.values()){
				if(StringUtils.equals(codigoValor, enumCaracteristicaDinamica.getKeyId()) && (codigoTipo != null && codigoTipo.compareTo(enumCaracteristicaDinamica.getCodigoTipo()) == 0)){
					return enumCaracteristicaDinamica;
				}
			}	
		}		
		return null;
	}

	//=============================================================================
	//		METODOS DE ACCESO - GETTERS Y SETTERS
	//=============================================================================
	
	public String getCodigoValor() {
		return codigoValor;
	}

	public void setCodigoValor(String codigoValor) {
		this.codigoValor = codigoValor;
	}

	public Integer getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(Integer codigoTipo) {
		this.codigoTipo = codigoTipo;
	}
}
