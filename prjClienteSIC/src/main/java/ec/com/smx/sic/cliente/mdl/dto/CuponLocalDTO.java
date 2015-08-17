
package ec.com.smx.sic.cliente.mdl.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.CuponLocalID;
import ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponMessages;



/**
 * Vista utilizada para generar el archivo de cupones por local
 *
 * @author mrivera
 */
@Entity
public class CuponLocalDTO extends BaseDto<CuponLocalID> {
	
	private static final long serialVersionUID = -7374783205252361279L;
	
	@Transient
	NumberFormat formatoDecimal = new DecimalFormat(RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.formatos.numeros"));
	@Transient
	SimpleDateFormat dateFormat = new SimpleDateFormat(RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.fecha.formato.anioMesDia"));
	/**
	 * Tipo del registro detalles, por defecto 2
	 */
	@Transient
	@Column(length=1)
	private String tipoRegistro;

	/**
	 * Almacena el tipo de cupon, es 1 si es muchos y 0 si es uno
	 */
	@Column(length=1)
	private String tipoCupon;
	
	/**
	 * Almacena el c�digo de barras del art�culo (Cup�n).
	 * Se solicita que sea 12 d�gitos, complementada con ceros a la izquierda y a�adir un cero a la derecha
	 */
	@Column(length=5)
	private String codigoBarras;
	/**
	 * Almacena el c�digo de barras del art�culo al cual aplica el cup�n.
	 */
	@Column(length=13)
	private String codigoBarrasArticuloRelacionado;
	
	private String codigoPromocion;
	
	
	/**
	 * Si el cup�n debe anadirse enviar 01, si debe eliminarse se envia 02
	 */
	@Column(length=2)
	@ComparatorTypeField
	private String codigoEstado;
	
//	@Transient
//	@Column(length=1)
//	private String cr;
//	
//	@Transient
//	@Column(length=1)
//	private String lf;
//	
//	
//	
//
//	
//	public String getCr() {
//		this.cr = new String();
//		return String.format("%1$-1s", cr);
//	}
//	public void setCr(String cr) {
//		this.cr = cr;
//		
//	}
//	public String getLf() {
//		this.lf = new String();
//		return String.format("%1$-1s", lf);
//	}
//	public void setLf(String lf) {
//		this.lf = lf;
//	}
	
	
	
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {		
		return StringUtils.leftPad(codigoBarras != null? codigoBarras:"",5, "0");
		//return codigoBarras;
	}
	public String getCodigoPromocion() {
		return codigoPromocion;
	}
	public void setCodigoPromocion(String codigoPromocion) {
		this.codigoPromocion = codigoPromocion;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	/**
	 * @return the codigoBarrasArticuloRelacionado
	 */
	public String getCodigoBarrasArticuloRelacionado() {		
		return StringUtils.rightPad(codigoBarrasArticuloRelacionado != null? codigoBarrasArticuloRelacionado:"", 13, "0");
		//return codigoBarrasArticuloRelacionado;
	}
	/**
	 * @param codigoBarrasArticuloRelacionado the codigoBarrasArticuloRelacionado to set
	 */
	public void setCodigoBarrasArticuloRelacionado(
			String codigoBarrasArticuloRelacionado) {
		this.codigoBarrasArticuloRelacionado = codigoBarrasArticuloRelacionado;
	}
	
	/**
	 * @return the codigoEstado
	 */
	public String getCodigoEstado() {
		String estado = RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.archivo.cupones.agregar");
		if(codigoEstado.equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_NOVIGENTE)){
			estado = RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.archivo.cupones.eliminar");
		}
		return estado;
	}
	/**
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	/**
	 * @return the tipoRegistro
	 */
	public String getTipoRegistro() {
		this.tipoRegistro = "2";
		return this.tipoRegistro;
	}
	/**
	 * @param tipoRegistro the tipoRegistro to set
	 */
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	
	public NumberFormat getFormatoDecimal() {
		return formatoDecimal;
	}
	public String getTipoCupon() {
		return tipoCupon;
	}
	public void setTipoCupon(String tipoCupon) {
		this.tipoCupon = tipoCupon;
	}
	public void setFormatoDecimal(NumberFormat formatoDecimal) {
		this.formatoDecimal = formatoDecimal;
	}
	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
}

