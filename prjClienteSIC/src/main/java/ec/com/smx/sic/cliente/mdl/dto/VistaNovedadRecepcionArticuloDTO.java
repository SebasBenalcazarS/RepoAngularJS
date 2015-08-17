package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaNovedadRecepcionArticuloID;

@Entity
@SuppressWarnings("serial")
public class VistaNovedadRecepcionArticuloDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaNovedadRecepcionArticuloID id = new VistaNovedadRecepcionArticuloID();
	
	private String nombreFuncionario;
	
	private String descripcionNovedad;
	
	private Integer cantidad;
	
	private Integer codigoTipoOperacion;

	private String valorTipoOperacion;
	
	@Transient
	private String valorSigno;
	
	//Bandera para identificar las novedades registradas en base
	@Transient
	private Boolean novedadRegistrada = Boolean.FALSE;

	/**
	 * @return the id
	 */
	public VistaNovedadRecepcionArticuloID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaNovedadRecepcionArticuloID id) {
		this.id = id;
	}

	/**
	 * @return the nombreFuncionario
	 */
	public String getNombreFuncionario() {
		return nombreFuncionario;
	}

	/**
	 * @param nombreFuncionario the nombreFuncionario to set
	 */
	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}

	/**
	 * @return the descripcionNovedad
	 */
	public String getDescripcionNovedad() {
		return descripcionNovedad;
	}

	/**
	 * @param descripcionNovedad the descripcionNovedad to set
	 */
	public void setDescripcionNovedad(String descripcionNovedad) {
		this.descripcionNovedad = descripcionNovedad;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the novedadRegistrada
	 */
	public Boolean getNovedadRegistrada() {
		return novedadRegistrada;
	}

	/**
	 * @param novedadRegistrada the novedadRegistrada to set
	 */
	public void setNovedadRegistrada(Boolean novedadRegistrada) {
		this.novedadRegistrada = novedadRegistrada;
	}

	/**
	 * @return the valorSigno
	 */
	public String getValorSigno() {
		return valorSigno;
	}

	/**
	 * @param valorSigno the valorSigno to set
	 */
	public void setValorSigno(String valorSigno) {
		this.valorSigno = valorSigno;
	}

	/**
	 * @return the codigoTipoOperacion
	 */
	public Integer getCodigoTipoOperacion() {
		return codigoTipoOperacion;
	}

	/**
	 * @param codigoTipoOperacion the codigoTipoOperacion to set
	 */
	public void setCodigoTipoOperacion(Integer codigoTipoOperacion) {
		this.codigoTipoOperacion = codigoTipoOperacion;
	}

	/**
	 * @return the valorTipoOperacion
	 */
	public String getValorTipoOperacion() {
		return valorTipoOperacion;
	}

	/**
	 * @param valorTipoOperacion the valorTipoOperacion to set
	 */
	public void setValorTipoOperacion(String valorTipoOperacion) {
		this.valorTipoOperacion = valorTipoOperacion;
	}
	
}
