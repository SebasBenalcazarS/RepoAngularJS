package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.text.DecimalFormat;

import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.CuponKioskoID;
import ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponMessages;

public class CuponKioskoDTO extends BaseDto<CuponKioskoID>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8650921378022725058L;
	private static final DecimalFormat FORMATTER = new DecimalFormat(RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.formatos.numeros"));
	@Transient
	private String codigoCupon;
	private String codigoProducto;
	@Transient
	private String codigoBarrasCupon;
	private String nombreProducto;
	private String nombreImagen;
	private Double porcentajeDescuento;
	private Double valorDescuento;
	@Transient
	private String valor;
	private String descuento;
	private String leyendaPrecioNormal;
	private Double precioNormal;
	@Transient
	private String precioAfiliado;
	private String leyendaPrecioFinal;
	private Double precioFinalConCupon;
	@Transient
	private String precioFinal;
	private String leyendaVigencia;
	private String terminosCondiciones;
	@Transient 
	private String condiciones;
	private Integer esRecomendado;
	private Integer orden;
	private String archivo;
	@Transient
	private String locales;
	
	public String getCodigoCupon() {
		if(id.getCodigoBarras()!= null){
			codigoCupon =  id.getCodigoBarras();
		}
		return codigoCupon;
	}
	public void setCodigoCupon(String codigoCupon) {
		this.codigoCupon = codigoCupon;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getCodigoBarrasCupon() {
		if(id.getCodigoBarras()!=null){
			codigoBarrasCupon = this.obtenerCodigoBarrasConDigitoVerificador(id.getCodigoBarras());
		}
		return codigoBarrasCupon;
	}
	public void setCodigoBarrasCupon(String codigoBarrasCupon) {
		this.codigoBarrasCupon = codigoBarrasCupon;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getNombreImagen() {
		return nombreImagen;
	}
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	public Double getValorDescuento() {
		return valorDescuento;
	}
	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}
	public String getValor() {
		if(porcentajeDescuento!=null && porcentajeDescuento!=0){
			valor = FORMATTER.format(porcentajeDescuento) + "%";
		}else if (valorDescuento!=null && valorDescuento!=0){
			valor = "$" + FORMATTER.format(valorDescuento);
		}
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescuento() {
		return descuento;
	}
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	public String getLeyendaPrecioNormal() {
		return leyendaPrecioNormal;
	}
	public void setLeyendaPrecioNormal(String leyendaPrecioNormal) {
		this.leyendaPrecioNormal = leyendaPrecioNormal;
	}
	public Double getPrecioNormal() {
		return precioNormal;
	}
	public void setPrecioNormal(Double precioNormal) {
		this.precioNormal = precioNormal;
	}
	public String getPrecioAfiliado() {
		if(leyendaPrecioNormal!= null && precioNormal!=null){
			precioAfiliado = leyendaPrecioNormal + FORMATTER.format(precioNormal);
		}
		return precioAfiliado;
	}
	public void setPrecioAfiliado(String precioAfiliado) {
		this.precioAfiliado = precioAfiliado;
	}
	public String getLeyendaPrecioFinal() {
		return leyendaPrecioFinal;
	}
	public void setLeyendaPrecioFinal(String leyendaPrecioFinal) {
		this.leyendaPrecioFinal = leyendaPrecioFinal;
	}
	public Double getPrecioFinalConCupon() {
		return precioFinalConCupon;
	}
	public void setPrecioFinalConCupon(Double precioFinalConCupon) {
		this.precioFinalConCupon = precioFinalConCupon;
	}
	public String getPrecioFinal() {
		if(leyendaPrecioFinal!=null && leyendaPrecioFinal.equals(RecargaCuponMessages.getInstancia().getString("ec.com.smc.recargacupones.leyenda.cada.Kilo"))){
			precioFinal = leyendaPrecioFinal;
		}else if(leyendaPrecioFinal!=null && precioFinalConCupon!=null){
			precioFinal = leyendaPrecioFinal + FORMATTER.format(precioFinalConCupon);
		}
		return precioFinal;
	}
	public void setPrecioFinal(String precioFinal) {
		this.precioFinal = precioFinal;
	}
	public String getLeyendaVigencia() {
		return leyendaVigencia;
	}
	public void setLeyendaVigencia(String leyendaVigencia) {
		this.leyendaVigencia = leyendaVigencia;
	}
	public String getTerminosCondiciones() {
		return terminosCondiciones;
	}
	public void setTerminosCondiciones(String terminosCondiciones) {
		this.terminosCondiciones = terminosCondiciones;
	}
	public String getCondiciones() {
		condiciones = leyendaVigencia + " " + terminosCondiciones; 
		return condiciones;
	}
	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	public Integer getEsRecomendado() {
		return esRecomendado;
	}
	public void setEsRecomendado(Integer esRecomendado) {
		this.esRecomendado = esRecomendado;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}	
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getLocales() {
		return locales;
	}
	public void setLocales(String locales) {
		this.locales = locales;
	}
	private String obtenerCodigoBarrasConDigitoVerificador(String codigoBarrasValidoAux){
		String codigoBarrasValido = StringUtils.leftPad(codigoBarrasValidoAux, 12, "0");
		int suma = 0;
		int pares = 0;
		int impares = 0;
		int verificador = 0;
		char[] caracteres = codigoBarrasValido.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			if(i%2==0){
				pares = pares+Character.getNumericValue(caracteres[i]);
			}else{
				impares = impares+(3*Character.getNumericValue(caracteres[i]));
			}
		}
		suma = pares + impares;
		int decenaSuperior = 0;
		if(suma%10>0){
			decenaSuperior = ((suma/10)+1)*10;
		}
		if(decenaSuperior>suma){
			verificador = decenaSuperior-suma;
		}
		codigoBarrasValido = codigoBarrasValido.concat(String.valueOf(verificador));
		return codigoBarrasValido;
	}

}
