package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.AfectacionCobroID;

/**
 * Clase DTO que extiende de SimpleAuditDTO, representa la tabla SFCORTCUECON
 * del Schema DSMXSIC
 * 
 * @author srodriguez
 * 2014-09-10
*/


@SuppressWarnings({ "serial", "deprecation" })
@Entity
@Table(name = "SCCEMTAFECOB")
@Deprecated
public class AfectacionCobroDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla Convenio participante
	 * 
	 */
	@EmbeddedId
	private AfectacionCobroID id = new AfectacionCobroID();
	
	
	/**
	 * Codigo de llave foranea de la tabla convenioParticipante que representa la vinculacion de un proveedor con una promocion
	 */
	@Column(name = "CODIGOPARTICIPACION")
	@ComparatorTypeField
	private java.lang.Long codigoParticipacion;
	
	/**
	 * Especifica el tipo del catalogo condicion cobro
	 */
	@Column(name = "CODIGOTIPOCONDICIONCOBRO")
	@ComparatorTypeField
	private java.lang.Integer codigoTipoCondicionCobro;
	
	/**
	 * Especifica el valor del catalogo condicion cobro
	 */
	@Column(name = "CODIGOVALORCONDICIONCOBRO")
	@ComparatorTypeField
	private java.lang.String codigoValorCondicionCobro;
	
	/**
	 * Especifica el tipo del catalogo Afectacion
	 */
	@Column(name = "CODIGOTIPOAFECTACION")
	@ComparatorTypeField
	private java.lang.Integer codigoTipoAfectacion;
	
	/**
	 * Especifica el valor del catalogo Afectacion
	 */
	@Column(name = "CODIGOVALORAFECTACION")
	@ComparatorTypeField
	private java.lang.String codigoValorAfectacion;
	
	/**
	 * Especifica el tipo del catalogo FormaCobro
	 */
	@Column(name = "CODIGOTIPOFORMACOBRO")
	@ComparatorTypeField
	private java.lang.Integer codigoTipoFormaCobro;
	
	/**
	 * Especifica el valor del catalogo FormaCobro
	 */
	@Column(name = "CODIGOVALORFORMACOBRO")
	@ComparatorTypeField
	private java.lang.String codigoValorFormaCobro;
	
	/**
	 * Especifica el tipo del catalogo PeriocidadCorte
	 */
	@Column(name = "CODIGOTIPOPERIOCIDADCORTE")
	@ComparatorTypeField
	private java.lang.Integer codigoTipoPeriocidadCorte;
	
	/**
	 * Especifica el valor del catalogo PeriocidadCorte
	 */
	@Column(name = "CODIGOVALORPERIOCIDADCORTE")
	@ComparatorTypeField
	private java.lang.String codigoValorPeriocidadCorte;
	
	/**
	 * Especifica el tipo del catalogo PeriocidadCorte
	 */
	@Column(name = "CODIGOTIPOPLAZOPAGO")
	@ComparatorTypeField
	private java.lang.Integer codigoTipoPlazoPago;
	
	/**
	 * Especifica el valor del catalogo PeriocidadCorte
	 */
	@Column(name = "CODIGOVALORPLAZOPAGO")
	@ComparatorTypeField
	private java.lang.String codigoValorPlazoPago;
	
	
	/**
	 * Columna que representa la llave foranea con la tabla cuenta contable
	 */
	@Column(name = "CODIGOCUENTACONTABLE")
	@ComparatorTypeField
	private java.lang.Integer codigoCuentaContable;
	
	/**
	 * Columna que representa la llave foranea con la tabla cuenta contable
	 */
	@Column(name = "CODIGOARTICULO")
	@ComparatorTypeField
	private java.lang.String codigoArticulo;
	
	
	/**
	 * Columna que representa el valor
	 */
	@Column(name = "VALOR")
	@ComparatorTypeField
	private java.lang.Double valor;
	
	/**
	 * Columna que representa la meta
	 */
	@Column(name = "META")
	@ComparatorTypeField
	private java.lang.Double meta;
	
	/**
	 * Columna que representa la fecha del primer pago
	 */
	@Column(name = "FECHAPRIMERPAGO")
	@ComparatorTypeField
	private java.lang.Double fechaPrimerPago;
	
	/**
	 * Columna que representa el estado
	 */
	@Column(name = "APLICAIVA")
	@ComparatorTypeField
	private java.lang.String aplicaIva;

	
	/**
	 * Columna que representa el estado
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private java.lang.String estado;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;

	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return AfectacionCobroID id 
	 */
	public AfectacionCobroID getId() {
		return id;
	}

	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param id parametro de tipo AfectacionCobroID
	 */
	public void setId(AfectacionCobroID id) {
		this.id = id;
	}

	/* Metodo que retorna codigoParticipacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Long codigoParticipacion 
	 */
	public java.lang.Long getCodigoParticipacion() {
		return codigoParticipacion;
	}

	/* Metodo que asigna el codigoParticipacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoParticipacion parametro de tipo java.lang.Long
	 */
	public void setCodigoParticipacion(java.lang.Long codigoParticipacion) {
		this.codigoParticipacion = codigoParticipacion;
	}

	/* Metodo que retorna codigoTipoCondicionCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Integer codigoTipoCondicionCobro 
	 */
	public java.lang.Integer getCodigoTipoCondicionCobro() {
		return codigoTipoCondicionCobro;
	}

	/* Metodo que asigna el codigoTipoCondicionCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoTipoCondicionCobro parametro de tipo java.lang.Integer
	 */
	public void setCodigoTipoCondicionCobro(java.lang.Integer codigoTipoCondicionCobro) {
		this.codigoTipoCondicionCobro = codigoTipoCondicionCobro;
	}

	/* Metodo que retorna codigoValorCondicionCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String codigoValorCondicionCobro 
	 */
	public java.lang.String getCodigoValorCondicionCobro() {
		return codigoValorCondicionCobro;
	}

	/* Metodo que asigna el codigoValorCondicionCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoValorCondicionCobro parametro de tipo java.lang.String
	 */
	public void setCodigoValorCondicionCobro(java.lang.String codigoValorCondicionCobro) {
		this.codigoValorCondicionCobro = codigoValorCondicionCobro;
	}

	/* Metodo que retorna codigoTipoAfectacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Integer codigoTipoAfectacion 
	 */
	public java.lang.Integer getCodigoTipoAfectacion() {
		return codigoTipoAfectacion;
	}

	/* Metodo que asigna el codigoTipoAfectacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoTipoAfectacion parametro de tipo java.lang.Integer
	 */
	public void setCodigoTipoAfectacion(java.lang.Integer codigoTipoAfectacion) {
		this.codigoTipoAfectacion = codigoTipoAfectacion;
	}

	/* Metodo que retorna codigoValorAfectacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String codigoValorAfectacion 
	 */
	public java.lang.String getCodigoValorAfectacion() {
		return codigoValorAfectacion;
	}

	/* Metodo que asigna el codigoValorAfectacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoValorAfectacion parametro de tipo java.lang.String
	 */
	public void setCodigoValorAfectacion(java.lang.String codigoValorAfectacion) {
		this.codigoValorAfectacion = codigoValorAfectacion;
	}

	/* Metodo que retorna codigoTipoFormaCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Integer codigoTipoFormaCobro 
	 */
	public java.lang.Integer getCodigoTipoFormaCobro() {
		return codigoTipoFormaCobro;
	}

	/* Metodo que asigna el codigoTipoFormaCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoTipoFormaCobro parametro de tipo java.lang.Integer
	 */
	public void setCodigoTipoFormaCobro(java.lang.Integer codigoTipoFormaCobro) {
		this.codigoTipoFormaCobro = codigoTipoFormaCobro;
	}

	/* Metodo que retorna codigoValorFormaCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String codigoValorFormaCobro 
	 */
	public java.lang.String getCodigoValorFormaCobro() {
		return codigoValorFormaCobro;
	}

	/* Metodo que asigna el codigoValorFormaCobro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoValorFormaCobro parametro de tipo java.lang.String
	 */
	public void setCodigoValorFormaCobro(java.lang.String codigoValorFormaCobro) {
		this.codigoValorFormaCobro = codigoValorFormaCobro;
	}

	/* Metodo que retorna codigoTipoPeriocidadCorte del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Integer codigoTipoPeriocidadCorte 
	 */
	public java.lang.Integer getCodigoTipoPeriocidadCorte() {
		return codigoTipoPeriocidadCorte;
	}

	/* Metodo que asigna el codigoTipoPeriocidadCorte del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoTipoPeriocidadCorte parametro de tipo java.lang.Integer
	 */
	public void setCodigoTipoPeriocidadCorte(java.lang.Integer codigoTipoPeriocidadCorte) {
		this.codigoTipoPeriocidadCorte = codigoTipoPeriocidadCorte;
	}

	/* Metodo que retorna codigoValorPeriocidadCorte del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String codigoValorPeriocidadCorte 
	 */
	public java.lang.String getCodigoValorPeriocidadCorte() {
		return codigoValorPeriocidadCorte;
	}

	/* Metodo que asigna el codigoValorPeriocidadCorte del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoValorPeriocidadCorte parametro de tipo java.lang.String
	 */
	public void setCodigoValorPeriocidadCorte(java.lang.String codigoValorPeriocidadCorte) {
		this.codigoValorPeriocidadCorte = codigoValorPeriocidadCorte;
	}

	/* Metodo que retorna codigoTipoPlazoPago del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Integer codigoTipoPlazoPago 
	 */
	public java.lang.Integer getCodigoTipoPlazoPago() {
		return codigoTipoPlazoPago;
	}

	/* Metodo que asigna el codigoTipoPlazoPago del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoTipoPlazoPago parametro de tipo java.lang.Integer
	 */
	public void setCodigoTipoPlazoPago(java.lang.Integer codigoTipoPlazoPago) {
		this.codigoTipoPlazoPago = codigoTipoPlazoPago;
	}

	/* Metodo que retorna codigoValorPlazoPago del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String codigoValorPlazoPago 
	 */
	public java.lang.String getCodigoValorPlazoPago() {
		return codigoValorPlazoPago;
	}

	/* Metodo que asigna el codigoValorPlazoPago del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoValorPlazoPago parametro de tipo java.lang.String
	 */
	public void setCodigoValorPlazoPago(java.lang.String codigoValorPlazoPago) {
		this.codigoValorPlazoPago = codigoValorPlazoPago;
	}

	/* Metodo que retorna codigoCuentaContable del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Integer codigoCuentaContable 
	 */
	public java.lang.Integer getCodigoCuentaContable() {
		return codigoCuentaContable;
	}

	/* Metodo que asigna el codigoCuentaContable del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoCuentaContable parametro de tipo java.lang.Integer
	 */
	public void setCodigoCuentaContable(java.lang.Integer codigoCuentaContable) {
		this.codigoCuentaContable = codigoCuentaContable;
	}

	/* Metodo que retorna codigoArticulo del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String codigoArticulo 
	 */
	public java.lang.String getCodigoArticulo() {
		return codigoArticulo;
	}

	/* Metodo que asigna el codigoArticulo del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param codigoArticulo parametro de tipo java.lang.String
	 */
	public void setCodigoArticulo(java.lang.String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/* Metodo que retorna valor del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Double valor 
	 */
	public java.lang.Double getValor() {
		return valor;
	}

	/* Metodo que asigna el valor del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param valor parametro de tipo java.lang.Double
	 */
	public void setValor(java.lang.Double valor) {
		this.valor = valor;
	}

	/* Metodo que retorna meta del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Double meta 
	 */
	public java.lang.Double getMeta() {
		return meta;
	}

	/* Metodo que asigna el meta del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param meta parametro de tipo java.lang.Double
	 */
	public void setMeta(java.lang.Double meta) {
		this.meta = meta;
	}

	/* Metodo que retorna fechaPrimerPago del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.Double fechaPrimerPago 
	 */
	public java.lang.Double getFechaPrimerPago() {
		return fechaPrimerPago;
	}

	/* Metodo que asigna el fechaPrimerPago del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param fechaPrimerPago parametro de tipo java.lang.Double
	 */
	public void setFechaPrimerPago(java.lang.Double fechaPrimerPago) {
		this.fechaPrimerPago = fechaPrimerPago;
	}

	/* Metodo que retorna aplicaIva del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String aplicaIva 
	 */
	public java.lang.String getAplicaIva() {
		return aplicaIva;
	}

	/* Metodo que asigna el aplicaIva del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param aplicaIva parametro de tipo java.lang.String
	 */
	public void setAplicaIva(java.lang.String aplicaIva) {
		this.aplicaIva = aplicaIva;
	}

	/* Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String estado 
	 */
	public java.lang.String getEstado() {
		return estado;
	}

	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param estado parametro de tipo java.lang.String
	 */
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	/* Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String idUsuarioRegistro 
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/* Metodo que asigna el idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param idUsuarioRegistro parametro de tipo java.lang.String
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/* Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.util.Date fechaRegistro 
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/* Metodo que asigna el fechaRegistro del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param fechaRegistro parametro de tipo java.util.Date
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/* Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String idUsuarioModificacion 
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/* Metodo que asigna el idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param idUsuarioModificacion parametro de tipo java.lang.String
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/* Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.util.Date fechaModificacion 
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/* Metodo que asigna el fechaModificacion del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param fechaModificacion parametro de tipo java.util.Date
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	
}
