
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaClienteArticuloID;


/**
 * Permite gestionar la informaci�n correspondiente a VistaClienteArticulo
 *
 * @author mrivera
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTVCLIART")
public class VistaClienteArticuloDTO extends BaseDto<VistaClienteArticuloID> {
	/**
	 * C�digo del cliente
	 */
	private Long codigoClientePedido;
	
	/**
	 * C�digo del articulo
	 */
	private String codigoArticulo;
	/**
	 * C�digo de barras del cup�n
	 */
	@ComparatorTypeField
	private String codigoBarras;
	
	/**
	 * C�digo de la persona
	 */
	private Long codigoPersona;
	/**
	 * N�mero de documento: C�dula o pasaporte
	 */
	@ComparatorTypeField
	private String numeroDocumento;
	/**
	 * Nombre completo de la persona
	 */
	private String nombreCompleto;
	/**
	 * Nombre del archivo correspondiente a la imagen del cup�n.
	 */
//	private String nombreArchivo;
	/**
	 * Valor del Tipo de agrupador del Articulo
	 */
	@ComparatorTypeField
	private String valorTipoAgrupador;
	/**
	 * Estado del registro cliente art�culo
	 */
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Fecha en que el art�culo (cup�n) fue utilizado por el cliente en sus compras. 
	 */
	private Date fechaUso;
	/**
	 * Fecha de inicio de vigencia del art�culo
	 */
//	private Date fechaInicioTemporada;

	/**
	 * Fecha de fin de vigencia del art�culo
	 */
//	private Date fechaFinTemporada;
	/**
	 * Descripci�n de art�culo relacionado al cup�n
	 */
//	private String descripcionArticulo;
	
	/**
	 * Fecha registro del cup�n en el cliente
	 */
	private Date fechaRegistro;
	/**
	 * Fecha �ltima modificaci�n del cup�n en el cliente
	 */
	private Date fechaModificacion;
	
	/**
	 * @return the codigoClientePedido
	 */
	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}
	
	/**
	 * @param codigoClientePedido the codigoClientePedido to set
	 */
	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}
	
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * @return the codigoPersona
	 */
	public Long getCodigoPersona() {
		return codigoPersona;
	}
	/**
	 * @param codigoPersona the codigoPersona to set
	 */
	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}	

	/**
	 * @return the valorTipoAgrupador
	 */
	public String getValorTipoAgrupador() {
		return valorTipoAgrupador;
	}

	/**
	 * @param valorTipoAgrupador the valorTipoAgrupador to set
	 */
	public void setValorTipoAgrupador(String valorTipoAgrupador) {
		this.valorTipoAgrupador = valorTipoAgrupador;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the fechaUso
	 */
	public Date getFechaUso() {
		return fechaUso;
	}
	/**
	 * @param fechaUso the fechaUso to set
	 */
	public void setFechaUso(Date fechaUso) {
		this.fechaUso = fechaUso;
	}	
	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}