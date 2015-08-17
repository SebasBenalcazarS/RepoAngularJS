/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import org.apache.commons.lang3.StringUtils;

/**
 * @author eharo
 *
 */
public enum EnumCreacionPorArchivoCabecera {
	
	//PRECIO VENTA	PRECIO SUPERMAXI

	CABECERA_CODIGO_PROVEEDOR (SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR),
	CABECERA_CODIGO_CLASIFICACION (SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION),
	CABECERA_CODIGO_SUBCLASIFICACION (SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_SUBCLASIFICACION),
	CABECERA_CODIGO_BARRAS (SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS),
	CABECERA_DESCRIPCION (SICArticuloConstantes.getInstancia().VALOR_CABECERA_DESCRIPCION),
	CABECERA_CLASE (SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE),
	CABECERA_UNIDAD_MANEJO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MANEJO),
	CABECERA_FECHA_INICIO_TEMPORADA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA),
	CABECERA_FECHA_FIN_TEMPORADA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA),
	CABECERA_EAN14 (SICArticuloConstantes.getInstancia().VALOR_CABECERA_EAN14),
	CABECERA_COSTO_MONEDA_ORIGEN (SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_MONEDA_ORIGEN),
	CABECERA_TAMANIO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_TAMANIO),
	CABECERA_MARCA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_MARCA),
	CABECERA_MARCA_PARTICIPACION (SICArticuloConstantes.getInstancia().VALOR_CABECERA_MARCA_PARTICIPACION),
	CABECERA_GARANTIA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_GARANTIA),
	CABECERA_REFERENCIA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_REFERENCIA),
	CABECERA_REFERENCIA_INTERNA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_REFERENCIA_INTERNA),
	CABECERA_ALCANCE_PROTOTIPO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_ALCANCE_PROTOTIPO),
	CABECERA_AGRUPADOR (SICArticuloConstantes.getInstancia().VALOR_CABECERA_AGRUPADOR),
	CABECERA_COSTO_BRUTO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO),
	CABECERA_DES1 (SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1),
	CABECERA_DES2 (SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2),
	CABECERA_DES3 (SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3),
	CABECERA_DES4 (SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4),
	CABECERA_PRECIO_VENTA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA),
	CABECERA_PRECIO_SUPERMAXI (SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI),
	CABECERA_CANTIDAD_MEDIDA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_CANTIDAD_MEDIDA),
	CABECERA_UNIDAD_MEDIDA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA),
	CABECERA_EMPAQUE (SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE),
	CABECERA_VENTA_PRECIO_AFILIADO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO),
	CABECERA_PLAZO_PAGO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_PLAZO_PAGO),
	CABECERA_IMPORTANCIA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPORTANCIA),
	
	CABECERA_TIPO_SECUENCIA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA),
	CABECERA_PRESENTACION (SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION),
	CABECERA_CONTROL_PRECIOS (SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS),
	CABECERA_PESO_APROX_VENTA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_PESO_APROX_VENTA),
	CABECERA_PESO_APROX_RECEPCION (SICArticuloConstantes.getInstancia().VALOR_CABECERA_PESO_APROX_RECEPCION),
	CABECERA_PAIS_ORIGEN (SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN),
	CABECERA_LUGAR_COMPRA (SICArticuloConstantes.getInstancia().VALOR_CABECERA_LUGAR_COMPRA),
	CABECERA_USOS (SICArticuloConstantes.getInstancia().VALOR_CABECERA_USOS),
	CABECERA_DURACION_CONS_LOCAL (SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_LOCAL),
	CABECERA_DURACION_CONS_REFRIGERADO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_REFRIGERADO),
	CABECERA_DURACION_CONS_CONGELADO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_CONGELADO),
	CABECERA_TRANSGENICO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_TRANSGENICO),
	CABECERA_REGISTRO_SANITARIO (SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO),
	CABECERA_FECHA_CADUCIDAD_REG_SAN (SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN);
	
	private final String nombreFormato;
	
	/**
	 * Contructor del Enumerado.
	 * @author mgranda
	 * @param nombreFormato
	 */
	private EnumCreacionPorArchivoCabecera(final String nombreFormato) {
		this.nombreFormato = nombreFormato;
	}
	
	public String getNombreFormato(){
		return this.nombreFormato;
	}
	
	public static EnumCreacionPorArchivoCabecera valueOfNombre(final String nombreFormato){
		if(StringUtils.isNotEmpty(nombreFormato)){
			for(EnumCreacionPorArchivoCabecera enumCreacionPorArchivoCabecera: EnumCreacionPorArchivoCabecera.values()){
				if(StringUtils.equals(nombreFormato, enumCreacionPorArchivoCabecera.getNombreFormato())){
					return enumCreacionPorArchivoCabecera;
				}
			}	
		}		
		return null;
		
	}
}

