package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.VistaColaboracionID;

@Entity
@Table(name = "SCSACVCOLABORACION")
public class VistaColaboracionDTO extends BaseDto<VistaColaboracionID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5531103718947741594L;

	private Long codigoLista;

	private Long codigoClientePedido;

	@ComparatorTypeField
	private String mantenerColaboracion;

	private Long codigoClientePedidoInvitado;

	@ComparatorTypeField
	private String estado;

	private String nombreCompleto;
	
	private String primerNombre;
	
	private String primerApellido;
	
	private String numeroDocumento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLISTA", referencedColumnName = "CODIGOLISTA", insertable = false, updatable = false)		   
		 })
	private ListaDTO listaDto;

	public Long getCodigoLista() {
		return codigoLista;
	}

	public void setCodigoLista(Long codigoLista) {
		this.codigoLista = codigoLista;
	}

	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

	public String getMantenerColaboracion() {
		return mantenerColaboracion;
	}

	public void setMantenerColaboracion(String mantenerColaboracion) {
		this.mantenerColaboracion = mantenerColaboracion;
	}

	public Long getCodigoClientePedidoInvitado() {
		return codigoClientePedidoInvitado;
	}

	public void setCodigoClientePedidoInvitado(Long codigoClientePedidoInvitado) {
		this.codigoClientePedidoInvitado = codigoClientePedidoInvitado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public ListaDTO getListaDto() {
		return listaDto;
	}

	public void setListaDto(ListaDTO listaDto) {
		this.listaDto = listaDto;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
}
