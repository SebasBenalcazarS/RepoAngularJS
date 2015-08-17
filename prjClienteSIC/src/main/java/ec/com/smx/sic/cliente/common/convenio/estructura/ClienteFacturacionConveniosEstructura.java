package ec.com.smx.sic.cliente.common.convenio.estructura;

import ec.com.smx.facturacion.dto.ClienteDTO;

/**
 * Estructura creada para tener un cliente con sus respectivos codigos, mensajes de error si no fue encontrado
 * @author aquingaluisa
 *
 */
public class ClienteFacturacionConveniosEstructura {
	private ClienteDTO clienteFacturacion;
	private String codigoCliente;
	/**
	 * 1:persona
	 * 2:localizacion
	 * 3:codigoProveedor
	 */
	private String tipoCodigoCliente;
	
	/**
	 * 1. no encontrado
	 * 2. no encontrado oficina exterior
	 */
	private String error;

	public ClienteDTO getClienteFacturacion() {
		return clienteFacturacion;
	}

	public void setClienteFacturacion(ClienteDTO clienteFacturacion) {
		this.clienteFacturacion = clienteFacturacion;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getTipoCodigoCliente() {
		return tipoCodigoCliente;
	}

	public void setTipoCodigoCliente(String tipoCodigoCliente) {
		this.tipoCodigoCliente = tipoCodigoCliente;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
