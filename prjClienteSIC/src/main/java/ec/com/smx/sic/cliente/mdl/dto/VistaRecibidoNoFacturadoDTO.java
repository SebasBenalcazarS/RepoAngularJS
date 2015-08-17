package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
@SuppressWarnings("serial")
public class VistaRecibidoNoFacturadoDTO extends SearchDTO{
	private Integer codigoCompania;
	private Long codigoFactura;
	private String numeroFactura;
	private String numeroFacturaProveedor;
	private Long codigoFacturaEstado;
	//Codigo del catalogo estado unificado
	private String estado;
	//Lista de estados relacionados
	private List<String> estadosRelacionados;
	//Nombre corto del catalogo valor
	private String estadoNombreCorto;
	//Nombre del catalogo valor
	private String estadoNombreCompleto;
	private String codigoJDEProveedor;
	private String codigoProveedor;
	private String nombreProveedor;
	private String rucProveedor;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubbodega;
	private Integer codigoReferenciaAreaTrabajo;
	private String nombreAreaTrabajo;
	private Date fechaFactura;
	private Date fechaFacturaProveedor;
	private BigDecimal valorTarifaCero;
	private BigDecimal valorTarifaDoce;
	private BigDecimal valorImpuestoVerde;
	private BigDecimal valorTotalFacturasProveedor;
	private BigDecimal valorTotalProveedorConImpuestos;
	private BigDecimal valorTotalDiferenciaRecepcion;
	private BigDecimal valorTotalCalculado;
	private Long numeroFacturasConsolidadas;
	private BigDecimal valorTotalAjustesManual;
	private BigDecimal valorTotalAjusteAutomatico;
	private String contabilizado;
	private String numeroAutorizacion;
	private Integer tipoTransaccion;
	private String valorTipoFactura;
	private Long codigoDetalleAjusteFacturaEstado;
	private BigDecimal valor;
	private BigDecimal valorTotal;
	private Integer codigoInternoTransaccion;
	private String nombreTransaccion;
	private Boolean poseeDatosFinancieros;
	private String aplicarRangoTolerancia;
	private BigDecimal valorDiferenciaAplicarAjuste;
	
	private String cuentaUsuarioEstado;
	private String nombreUsuarioEstado;
	private Date fechaEstado;
	private String valorFacturaEnSitio;
	private BigDecimal totalImpuesto;
	private Long codigoFacturaProveedor;
	private String codigoAccesoProveedor;
	private String codigoValorTipoValidacion;
	
	private String envioManualContabilizacion;
	private String envioAutomaticoContabilizacion;
	private String envioManualCuentasPorPagar;
	private String envioAutomaticoCuentasPorPagar;
	private String validarCuadre;

	private BigDecimal valorTotalFacturaInterna;//Es la suma del valorTotalTarifaCero + valorTotalTarifaCero
	private BigDecimal diferenciaValoresFacturas;
	private Boolean seleccionado = Boolean.FALSE;
	public Date codigoJDEProvedor;
	public Date fechaInicio;
	public Date fechaFinal;
	private Collection<VistaFacturaRelacionadaDTO> facturasRelacionadas;
	private Boolean esFacturaPadre = Boolean.FALSE;
	private Boolean traerPrimerDetalle;
	private String tipoAsignacion;
	private BigDecimal valorTotalConAjustes;
	private BigDecimal valorDiferencia;
	private BigDecimal valorDiferenciaConImpuestos;
	private BigDecimal valorDiferenciaAnterior;
	private BigDecimal valorTotalAjustesAnterior;
	private String codigoSistema;
	private String codigoOpcion;
	private String codigoDepartamento;
	private BigDecimal valorDepartamento;
	private String valorTipoAjuste;
	private BigDecimal valorTotalNotasCredito;
	private BigDecimal valorTotalNotasDebito;
	private BigDecimal valorTotalSubTotal;
	private String tipoDocumento;
	private String cuentaContableNoCotejado;
	private Boolean validarFlujoEstadoFactura = Boolean.TRUE;
	private Collection<FacturaDatoFinancieroDTO> facturasDatosFinanciero;
	private String tipoDocumentoFinanciero;
	private String observacionFinanciera;
	private Integer ordenNotaIngreso;
	
	public Date fechaEstadoInicio;
	public Date fechaEstadoFinal;
	private Boolean traerNotasIngresoEnSitio;
	private Boolean existeDiferenciaRecepcionImpuestos;
	private Boolean plegar = Boolean.FALSE;
	private Collection<VistaRecibidoNoFacturadoDTO> notasIngresoConsolidadas;
	private String estadoFactura;//Estado 1 o 0 de la tabla Factura 
	private BigDecimal valorTotalProveedor;//Total de las facturas con impuestos del proveedor
	private String valorTipoCuadre;//Especifica el flujo si fue tipo cuadre manual o automatico
	
	private BigDecimal valorTotalAjustesManualAutomatico;
	private Long numeroFacturasRepetidas;//Especifica el numero de facturas repetidas del proveedor
	private String valorCambioInformacion;//posee la marca de revisado si todas las facturas del proveedor han sido revisadas
	private Boolean traerFacturasRevisadas;//Se obtiene las notas de ingreso que poseen el estado revisada
	private String valorTipoDocumentoFactura;//Especifica el tipo de documento
	private String opcionFechaNotaIngreso;//Especifica el tipo de filtro, si es por fecha de la nota de ingreso o pendientes de fechas atras
	private Boolean traerNotasIngresoPorHacer;//Se obtiene las notas de ingreso que quedaron pendientes por hacer
	
	private Boolean aprobadoForzado;//Bandera que especifica si paso por algun estado aprobado forzado, se usa en la generacion del archivo F0411
	
	private String observacionNotaIngreso;//Observacion de la nota de ingreso
	private String porRealizar;//Trabajo pendiente en la nota de ingreso
	
	private String nombrePlazoPago;//Nombre del plazo de pago
	private Long valorPlazoPago;//Valor del plazo de pago
	
	private Integer codigoTipoPlazoPago;//Codigo del tipo plazo de pago de la nota de ingreso
	private String valorTipoPlazoPago;//Codigo del tipo plazo de pago de la nota de ingreso
	
	private Date fechaVencimientoPlazoPago;//Valor calculado para la fecha de vencimiento de pago del documento
	
	/** CAMPOS REPORTES ***/
	private Collection<ResumenTotalDocumentoDTO> resumenTotalDocumentoDTOCol;
	private BigDecimal valorAjusteResumenTotalDocumento;
	private Integer numeroFacturasFisicas;
	private Integer numeroFacturasElectronicas;
	private Integer numeroNotasCreditoFisicas;
	private Integer numeroNotasCreditoElectronicas;
	private Integer numeroNotasDebitoFisicas;
	private Integer numeroNotasDebitoElectronicas;
	private String campoConDiferencia;
	private String campoSinDiferencia;
	private Integer numeroNotasIngreso;
	private Integer numeroFacturasProveedor;
	private String estiloRegistro;
	private Collection<ISearchTemplate> filtrosBusqueda;//Se almacena los filtros de busqueda para obtener los reportes excel
	private String numeroDocumentos;

	
	
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}
	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstadoNombreCorto() {
		return estadoNombreCorto;
	}
	public void setEstadoNombreCorto(String estadoNombreCorto) {
		this.estadoNombreCorto = estadoNombreCorto;
	}
	public String getEstadoNombreCompleto() {
		return estadoNombreCompleto;
	}
	public void setEstadoNombreCompleto(String estadoNombreCompleto) {
		this.estadoNombreCompleto = estadoNombreCompleto;
	}
	public String getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}
	public void setCodigoJDEProveedor(String codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}
	public Integer getCodigoAreaTrabajoSubbodega() {
		return codigoAreaTrabajoSubbodega;
	}
	public void setCodigoAreaTrabajoSubbodega(Integer codigoAreaTrabajoSubbodega) {
		this.codigoAreaTrabajoSubbodega = codigoAreaTrabajoSubbodega;
	}
	public Integer getCodigoReferenciaAreaTrabajo() {
		return codigoReferenciaAreaTrabajo;
	}
	public void setCodigoReferenciaAreaTrabajo(Integer codigoReferenciaAreaTrabajo) {
		this.codigoReferenciaAreaTrabajo = codigoReferenciaAreaTrabajo;
	}
	public String getNombreAreaTrabajo() {
		return nombreAreaTrabajo;
	}
	public void setNombreAreaTrabajo(String nombreAreaTrabajo) {
		this.nombreAreaTrabajo = nombreAreaTrabajo;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public BigDecimal getValorTotalFacturaInterna() {
		return valorTotalFacturaInterna;
	}
	public void setValorTotalFacturaInterna(BigDecimal valorTotalFacturaInterna) {
		this.valorTotalFacturaInterna = valorTotalFacturaInterna;
	}
	public BigDecimal getValorTotalFacturasProveedor() {
		if(valorTotalFacturasProveedor == null){
			valorTotalFacturasProveedor = BigDecimal.ZERO;
		}
		return valorTotalFacturasProveedor;
	}
	public void setValorTotalFacturasProveedor(BigDecimal valorTotalFacturasProveedor) {
		this.valorTotalFacturasProveedor = valorTotalFacturasProveedor;
	}
	public Boolean getSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	public Date getCodigoJDEProvedor() {
		return codigoJDEProvedor;
	}
	public void setCodigoJDEProvedor(Date codigoJDEProvedor) {
		this.codigoJDEProvedor = codigoJDEProvedor;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Collection<VistaFacturaRelacionadaDTO> getFacturasRelacionadas() {
		return facturasRelacionadas;
	}
	public void setFacturasRelacionadas(Collection<VistaFacturaRelacionadaDTO> facturasRelacionadas) {
		this.facturasRelacionadas = facturasRelacionadas;
	}
	public void setDiferenciaValoresFacturas(BigDecimal diferenciaValoresFacturas) {
		this.diferenciaValoresFacturas = diferenciaValoresFacturas;
	}
	public BigDecimal getDiferenciaValoresFacturas() {
		diferenciaValoresFacturas = this.getValorTotalFacturaInterna().subtract(this.getValorTotalFacturasProveedor()); 
		
		return  diferenciaValoresFacturas.signum() ==-1 ? diferenciaValoresFacturas.multiply(new BigDecimal(-1)):diferenciaValoresFacturas;
	}
	public String getProveedor(){
		return this.getCodigoJDEProveedor()+" - "+this.getNombreProveedor();
	}
	public String getSubBodega(){
		if(this.getCodigoReferenciaAreaTrabajo() != null){
			return this.getCodigoReferenciaAreaTrabajo()+" - "+this.getNombreAreaTrabajo();
		}
		return null;
	}
	public Boolean getEsFacturaPadre() {
		return esFacturaPadre;
	}
	public void setEsFacturaPadre(Boolean esFacturaPadre) {
		this.esFacturaPadre = esFacturaPadre;
	}
	public Boolean getTraerPrimerDetalle() {
		return traerPrimerDetalle;
	}
	public void setTraerPrimerDetalle(Boolean traerPrimerDetalle) {
		this.traerPrimerDetalle = traerPrimerDetalle;
	}
	public Long getNumeroFacturasConsolidadas() {
		return numeroFacturasConsolidadas;
	}
	public void setNumeroFacturasConsolidadas(Long numeroFacturasConsolidadas) {
		this.numeroFacturasConsolidadas = numeroFacturasConsolidadas;
	}
	public String getTipoAsignacion() {
		return tipoAsignacion;
	}
	public void setTipoAsignacion(String tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}
	public String getRucProveedor() {
		return rucProveedor;
	}
	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}
	
	public BigDecimal getValorTotalConAjustes() {
		return  this.valorTotalConAjustes;
	}
	public void setValorTotalConAjustes(BigDecimal valorTotalConAjustes) {
		this.valorTotalConAjustes = valorTotalConAjustes;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public BigDecimal getValorDiferencia() {
		return this.valorDiferencia;
	}
	public void setValorDiferencia(BigDecimal valorDiferencia) {
		
		this.valorDiferencia = valorDiferencia;
	}
	public String getCodigoSistema() {
		return codigoSistema;
	}
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	public String getCodigoOpcion() {
		return codigoOpcion;
	}
	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}
	public BigDecimal getValorTotalAjustesManual() {
		return valorTotalAjustesManual;
	}
	public void setValorTotalAjustesManual(BigDecimal valorTotalAjustesManual) {
		this.valorTotalAjustesManual = valorTotalAjustesManual;
	}
	public BigDecimal getValorTotalAjusteAutomatico() {
		return valorTotalAjusteAutomatico;
	}
	public void setValorTotalAjusteAutomatico(BigDecimal valorTotalAjusteAutomatico) {
		this.valorTotalAjusteAutomatico = valorTotalAjusteAutomatico;
	}
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	public BigDecimal getValorDepartamento() {
		return valorDepartamento;
	}
	public void setValorDepartamento(BigDecimal valorDepartamento) {
		this.valorDepartamento = valorDepartamento;
	}
	public String getContabilizado() {
		return contabilizado;
	}
	public void setContabilizado(String contabilizado) {
		this.contabilizado = contabilizado;
	}
	public String getValorTipoAjuste() {
		return valorTipoAjuste;
	}
	public void setValorTipoAjuste(String valorTipoAjuste) {
		this.valorTipoAjuste = valorTipoAjuste;
	}
	public String getNumeroFacturaProveedor() {
		return numeroFacturaProveedor;
	}
	public void setNumeroFacturaProveedor(String numeroFacturaProveedor) {
		this.numeroFacturaProveedor = numeroFacturaProveedor;
	}
	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}
	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}
	public BigDecimal getValorTarifaCero() {
		return valorTarifaCero;
	}
	public void setValorTarifaCero(BigDecimal valorTarifaCero) {
		this.valorTarifaCero = valorTarifaCero;
	}
	public BigDecimal getValorTarifaDoce() {
		return valorTarifaDoce;
	}
	public void setValorTarifaDoce(BigDecimal valorTarifaDoce) {
		this.valorTarifaDoce = valorTarifaDoce;
	}
	/**
	 * @return the valorTotalNotasCredito
	 */
	public BigDecimal getValorTotalNotasCredito() {
		return valorTotalNotasCredito;
	}
	/**
	 * @param valorTotalNotasCredito the valorTotalNotasCredito to set
	 */
	public void setValorTotalNotasCredito(BigDecimal valorTotalNotasCredito) {
		this.valorTotalNotasCredito = valorTotalNotasCredito;
	}
	/**
	 * @return the valorTotalNotasDebito
	 */
	public BigDecimal getValorTotalNotasDebito() {
		return valorTotalNotasDebito;
	}
	/**
	 * @param valorTotalNotasDebito the valorTotalNotasDebito to set
	 */
	public void setValorTotalNotasDebito(BigDecimal valorTotalNotasDebito) {
		this.valorTotalNotasDebito = valorTotalNotasDebito;
	}
	/**
	 * @return the valorTotalSubTotal
	 */
	public BigDecimal getValorTotalSubTotal() {
		return valorTotalSubTotal;
	}
	/**
	 * @param valorTotalSubTotal the valorTotalSubTotal to set
	 */
	public void setValorTotalSubTotal(BigDecimal valorTotalSubTotal) {
		this.valorTotalSubTotal = valorTotalSubTotal;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(Integer tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getValorTipoFactura() {
		return valorTipoFactura;
	}
	public void setValorTipoFactura(String valorTipoFactura) {
		this.valorTipoFactura = valorTipoFactura;
	}
	public Long getCodigoDetalleAjusteFacturaEstado() {
		return codigoDetalleAjusteFacturaEstado;
	}
	public void setCodigoDetalleAjusteFacturaEstado(Long codigoDetalleAjusteFacturaEstado) {
		this.codigoDetalleAjusteFacturaEstado = codigoDetalleAjusteFacturaEstado;
	}
	public BigDecimal getValorDiferenciaAnterior() {
		return valorDiferenciaAnterior;
	}
	public void setValorDiferenciaAnterior(BigDecimal valorDiferenciaAnterior) {
		this.valorDiferenciaAnterior = valorDiferenciaAnterior;
	}
	public String getCuentaContableNoCotejado() {
		return cuentaContableNoCotejado;
	}
	public void setCuentaContableNoCotejado(String cuentaContableNoCotejado) {
		this.cuentaContableNoCotejado = cuentaContableNoCotejado;
	}
	/**
	 * @return the facturasDatosFinanciero
	 */
	public Collection<FacturaDatoFinancieroDTO> getFacturasDatosFinanciero() {
		return facturasDatosFinanciero;
	}
	/**
	 * @param facturasDatosFinanciero the facturasDatosFinanciero to set
	 */
	public void setFacturasDatosFinanciero(Collection<FacturaDatoFinancieroDTO> facturasDatosFinanciero) {
		this.facturasDatosFinanciero = facturasDatosFinanciero;
	}
	/**
	 * @return the tipoDocumentoFinanciero
	 */
	public String getTipoDocumentoFinanciero() {
		return tipoDocumentoFinanciero;
	}
	/**
	 * @param tipoDocumentoFinanciero the tipoDocumentoFinanciero to set
	 */
	public void setTipoDocumentoFinanciero(String tipoDocumentoFinanciero) {
		this.tipoDocumentoFinanciero = tipoDocumentoFinanciero;
	}
	/**
	 * @return the observacionFinanciera
	 */
	public String getObservacionFinanciera() {
		return observacionFinanciera;
	}
	/**
	 * @param observacionFinanciera the observacionFinanciera to set
	 */
	public void setObservacionFinanciera(String observacionFinanciera) {
		this.observacionFinanciera = observacionFinanciera;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the codigoInternoTransaccion
	 */
	public Integer getCodigoInternoTransaccion() {
		return codigoInternoTransaccion;
	}
	/**
	 * @param codigoInternoTransaccion the codigoInternoTransaccion to set
	 */
	public void setCodigoInternoTransaccion(Integer codigoInternoTransaccion) {
		this.codigoInternoTransaccion = codigoInternoTransaccion;
	}
	/**
	 * @return the nombreTransaccion
	 */
	public String getNombreTransaccion() {
		return nombreTransaccion;
	}
	/**
	 * @param nombreTransaccion the nombreTransaccion to set
	 */
	public void setNombreTransaccion(String nombreTransaccion) {
		this.nombreTransaccion = nombreTransaccion;
	}
	public Boolean getValidarFlujoEstadoFactura() {
		return validarFlujoEstadoFactura;
	}
	public void setValidarFlujoEstadoFactura(Boolean validarFlujoEstadoFactura) {
		this.validarFlujoEstadoFactura = validarFlujoEstadoFactura;
	}
	/**
	 * @return the envioManualContabilizacion
	 */
	public String getEnvioManualContabilizacion() {
		return envioManualContabilizacion;
	}
	/**
	 * @param envioManualContabilizacion the envioManualContabilizacion to set
	 */
	public void setEnvioManualContabilizacion(String envioManualContabilizacion) {
		this.envioManualContabilizacion = envioManualContabilizacion;
	}
	/**
	 * @return the envioautomaticoContabilizacion
	 */
	public String getEnvioAutomaticoContabilizacion() {
		return envioAutomaticoContabilizacion;
	}
	/**
	 * @param envioautomaticoContabilizacion the envioautomaticoContabilizacion to set
	 */
	public void setEnvioAutomaticoContabilizacion(String envioAutomaticoContabilizacion) {
		this.envioAutomaticoContabilizacion = envioAutomaticoContabilizacion;
	}
	/**
	 * @return the validarCuadre
	 */
	public String getValidarCuadre() {
		return validarCuadre;
	}
	/**
	 * @param validarCuadre the validarCuadre to set
	 */
	public void setValidarCuadre(String validarCuadre) {
		this.validarCuadre = validarCuadre;
	}
	/**
	 * @return the poseeDatosFinancieros
	 */
	public Boolean getPoseeDatosFinancieros() {
		return poseeDatosFinancieros;
	}
	/**
	 * @param poseeDatosFinancieros the poseeDatosFinancieros to set
	 */
	public void setPoseeDatosFinancieros(Boolean poseeDatosFinancieros) {
		this.poseeDatosFinancieros = poseeDatosFinancieros;
	}
	
	public String getCuentaUsuarioEstado() {
		return cuentaUsuarioEstado;
	}
	public void setCuentaUsuarioEstado(String cuentaUsuarioEstado) {
		this.cuentaUsuarioEstado = cuentaUsuarioEstado;
	}
	public String getNombreUsuarioEstado() {
		return nombreUsuarioEstado;
	}
	public void setNombreUsuarioEstado(String nombreUsuarioEstado) {
		this.nombreUsuarioEstado = nombreUsuarioEstado;
	}
	public Date getFechaEstado() {
		return fechaEstado;
	}
	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}
	public void setValorFacturaEnSitio(String valorFacturaEnSitio){
		this.valorFacturaEnSitio = valorFacturaEnSitio;
	}

	public Boolean getFacturaEnSitio() {
		Boolean respuesta = Boolean.TRUE;
		if(this.valorFacturaEnSitio == null || this.valorFacturaEnSitio.equals(SICConstantes.ESTADO_INACTIVO_NUMERICO)){
			respuesta = Boolean.FALSE;
		}
		return respuesta;
	}
	
	public Boolean getTraerNotasIngresoEnSitio() {
		return traerNotasIngresoEnSitio;
	}
	public void setTraerNotasIngresoEnSitio(Boolean traerNotasIngresoEnSitio) {
		this.traerNotasIngresoEnSitio = traerNotasIngresoEnSitio;
	}
	/**
	 * @return the ordenNotaIngreso
	 */
	public Integer getOrdenNotaIngreso() {
		return ordenNotaIngreso;
	}
	/**
	 * @param ordenNotaIngreso the ordenNotaIngreso to set
	 */
	public void setOrdenNotaIngreso(Integer ordenNotaIngreso) {
		this.ordenNotaIngreso = ordenNotaIngreso;
	}
	public BigDecimal getValorImpuestoVerde() {
		return valorImpuestoVerde;
	}
	public void setValorImpuestoVerde(BigDecimal valorImpuestoVerde) {
		this.valorImpuestoVerde = valorImpuestoVerde;
	}
	public BigDecimal getValorTotalProveedorConImpuestos() {
		return valorTotalProveedorConImpuestos;
	}
	public void setValorTotalProveedorConImpuestos(BigDecimal valorTotalProveedorConImpuestos) {
		this.valorTotalProveedorConImpuestos = valorTotalProveedorConImpuestos;
	}
	public BigDecimal getValorDiferenciaConImpuestos() {
		return valorDiferenciaConImpuestos;
	}
	public void setValorDiferenciaConImpuestos(BigDecimal valorDiferenciaConImpuestos) {
		this.valorDiferenciaConImpuestos = valorDiferenciaConImpuestos;
	}
	public BigDecimal getValorTotalDiferenciaRecepcion() {
		return valorTotalDiferenciaRecepcion;
	}
	public void setValorTotalDiferenciaRecepcion(BigDecimal valorTotalDiferenciaRecepcion) {
		this.valorTotalDiferenciaRecepcion = valorTotalDiferenciaRecepcion;
	}
	public Date getFechaEstadoInicio() {
		return fechaEstadoInicio;
	}
	public void setFechaEstadoInicio(Date fechaEstadoInicio) {
		this.fechaEstadoInicio = fechaEstadoInicio;
	}
	public Date getFechaEstadoFinal() {
		return fechaEstadoFinal;
	}
	public void setFechaEstadoFinal(Date fechaEstadoFinal) {
		this.fechaEstadoFinal = fechaEstadoFinal;
	}
	public Date getFechaFacturaProveedor() {
		return fechaFacturaProveedor;
	}
	public void setFechaFacturaProveedor(Date fechaFacturaProveedor) {
		this.fechaFacturaProveedor = fechaFacturaProveedor;
	}
	/**
	 * @return the aplicarRangoTolerancia
	 */
	public String getAplicarRangoTolerancia() {
		return aplicarRangoTolerancia;
	}
	/**
	 * @param aplicarRangoTolerancia the aplicarRangoTolerancia to set
	 */
	public void setAplicarRangoTolerancia(String aplicarRangoTolerancia) {
		this.aplicarRangoTolerancia = aplicarRangoTolerancia;
	}
	/**
	 * @return the valorDiferenciaAplicarAjuste
	 */
	public BigDecimal getValorDiferenciaAplicarAjuste() {
		return valorDiferenciaAplicarAjuste;
	}
	/**
	 * @param valorDiferenciaAplicarAjuste the valorDiferenciaAplicarAjuste to set
	 */
	public void setValorDiferenciaAplicarAjuste(BigDecimal valorDiferenciaAplicarAjuste) {
		this.valorDiferenciaAplicarAjuste = valorDiferenciaAplicarAjuste;
	}
	/**
	 * @return the totalImpuesto
	 */
	public BigDecimal getTotalImpuesto() {
		return totalImpuesto;
	}
	/**
	 * @param totalImpuesto the totalImpuesto to set
	 */
	public void setTotalImpuesto(BigDecimal totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}
	public Boolean getExisteDiferenciaRecepcionImpuestos() {
		return existeDiferenciaRecepcionImpuestos;
	}
	public void setExisteDiferenciaRecepcionImpuestos(Boolean existeDiferenciaRecepcionImpuestos) {
		this.existeDiferenciaRecepcionImpuestos = existeDiferenciaRecepcionImpuestos;
	}
	public Boolean getPlegar() {
		return plegar;
	}
	public void setPlegar(Boolean plegar) {
		this.plegar = plegar;
	}
	public Collection<VistaRecibidoNoFacturadoDTO> getNotasIngresoConsolidadas() {
		return notasIngresoConsolidadas;
	}
	public void setNotasIngresoConsolidadas(Collection<VistaRecibidoNoFacturadoDTO> notasIngresoConsolidadas) {
		this.notasIngresoConsolidadas = notasIngresoConsolidadas;
	}
	public String getEstadoFactura() {
		return estadoFactura;
	}
	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}
	public String getValorFacturaEnSitio() {
		return valorFacturaEnSitio;
	}
	public BigDecimal getValorTotalProveedor() {
		return valorTotalProveedor;
	}
	public void setValorTotalProveedor(BigDecimal valorTotalProveedor) {
		this.valorTotalProveedor = valorTotalProveedor;
	}
	public BigDecimal getValorTotalAjustesAnterior() {
		return valorTotalAjustesAnterior;
	}
	public void setValorTotalAjustesAnterior(BigDecimal valorTotalAjustesAnterior) {
		this.valorTotalAjustesAnterior = valorTotalAjustesAnterior;
	}
	
	public void setValorTotalAjustesManualAutomatico(BigDecimal valorTotalAjustesManualAutomatico) {
		this.valorTotalAjustesManualAutomatico = valorTotalAjustesManualAutomatico;
	}
	public BigDecimal getValorTotalAjustesManualAutomatico() {
		BigDecimal valorTotal = (this.valorTotalAjustesManual == null ? BigDecimal.ZERO : this.valorTotalAjustesManual).add(this.valorTotalAjusteAutomatico == null ? BigDecimal.ZERO : this.valorTotalAjusteAutomatico); 
		return valorTotal;
	}
	
	public Boolean getMostrarDetallesAjustes() {
		Boolean respuesta = Boolean.FALSE;
		Integer valor = this.getValorTotalAjustesManualAutomatico().compareTo(new BigDecimal(0.0000)); 
		if(valor != 0){
			respuesta = Boolean.TRUE;
		}
		return respuesta;
	}
	public BigDecimal getValorTotalNotaIngresoConAjustes() {
		return this.valorTotal.add(this.getValorTotalAjustesManualAutomatico());
	}
	
	
	public String getValorTipoCuadre() {
		return valorTipoCuadre;
	}
	public void setValorTipoCuadre(String valorTipoCuadre) {
		this.valorTipoCuadre = valorTipoCuadre;
	}
	/**
	 * @return the estadosRelacionados
	 */
	public List<String> getEstadosRelacionados() {
		return estadosRelacionados;
	}
	/**
	 * @param estadosRelacionados the estadosRelacionados to set
	 */
	public void setEstadosRelacionados(List<String> estadosRelacionados) {
		this.estadosRelacionados = estadosRelacionados;
	}
	/**
	 * @return the envioManualCuentasPorPagar
	 */
	public String getEnvioManualCuentasPorPagar() {
		return envioManualCuentasPorPagar;
	}
	/**
	 * @param envioManualCuentasPorPagar the envioManualCuentasPorPagar to set
	 */
	public void setEnvioManualCuentasPorPagar(String envioManualCuentasPorPagar) {
		this.envioManualCuentasPorPagar = envioManualCuentasPorPagar;
	}
	/**
	 * @return the envioAutomaticoCuentasPorPagar
	 */
	public String getEnvioAutomaticoCuentasPorPagar() {
		return envioAutomaticoCuentasPorPagar;
	}
	/**
	 * @param envioAutomaticoCuentasPorPagar the envioAutomaticoCuentasPorPagar to set
	 */
	public void setEnvioAutomaticoCuentasPorPagar(String envioAutomaticoCuentasPorPagar) {
		this.envioAutomaticoCuentasPorPagar = envioAutomaticoCuentasPorPagar;
	}
	public BigDecimal getValorTotalCalculado() {
		return valorTotalCalculado;
	}
	public void setValorTotalCalculado(BigDecimal valorTotalCalculado) {
		this.valorTotalCalculado = valorTotalCalculado;
	}
	/**
	 * @return the codigoFacturaProveedor
	 */
	public Long getCodigoFacturaProveedor() {
		return codigoFacturaProveedor;
	}
	/**
	 * @param codigoFacturaProveedor the codigoFacturaProveedor to set
	 */
	public void setCodigoFacturaProveedor(Long codigoFacturaProveedor) {
		this.codigoFacturaProveedor = codigoFacturaProveedor;
	}
	/**
	 * @return the codigoValorTipoValidacion
	 */
	public String getCodigoValorTipoValidacion() {
		return codigoValorTipoValidacion;
	}
	/**
	 * @param codigoValorTipoValidacion the codigoValorTipoValidacion to set
	 */
	public void setCodigoValorTipoValidacion(String codigoValorTipoValidacion) {
		this.codigoValorTipoValidacion = codigoValorTipoValidacion;
	}
	/**
	 * @return the codigoAccesoProveedor
	 */
	public String getCodigoAccesoProveedor() {
		return codigoAccesoProveedor;
	}
	/**
	 * @param codigoAccesoProveedor the codigoAccesoProveedor to set
	 */
	public void setCodigoAccesoProveedor(String codigoAccesoProveedor) {
		this.codigoAccesoProveedor = codigoAccesoProveedor;
	}
	/**
	 * @return the numeroFacturasRepetidas
	 */
	public Long getNumeroFacturasRepetidas() {
		return numeroFacturasRepetidas;
	}
	/**
	 * @param numeroFacturasRepetidas the numeroFacturasRepetidas to set
	 */
	public void setNumeroFacturasRepetidas(Long numeroFacturasRepetidas) {
		this.numeroFacturasRepetidas = numeroFacturasRepetidas;
	}
	/**
	 * @return the valorCambioInformacion
	 */
	public String getValorCambioInformacion() {
		return valorCambioInformacion;
	}
	/**
	 * @param valorCambioInformacion the valorCambioInformacion to set
	 */
	public void setValorCambioInformacion(String valorCambioInformacion) {
		this.valorCambioInformacion = valorCambioInformacion;
	}
	/**
	 * @return the traerFacturasRevisadas
	 */
	public Boolean getTraerFacturasRevisadas() {
		return traerFacturasRevisadas;
	}
	/**
	 * @param traerFacturasRevisadas the traerFacturasRevisadas to set
	 */
	public void setTraerFacturasRevisadas(Boolean traerFacturasRevisadas) {
		this.traerFacturasRevisadas = traerFacturasRevisadas;
	}
	/**
	 * @return the valorTipoDocumentoFactura
	 */
	public String getValorTipoDocumentoFactura() {
		return valorTipoDocumentoFactura;
	}
	/**
	 * @param valorTipoDocumentoFactura the valorTipoDocumentoFactura to set
	 */
	public void setValorTipoDocumentoFactura(String valorTipoDocumentoFactura) {
		this.valorTipoDocumentoFactura = valorTipoDocumentoFactura;
	}
	/**
	 * @return the opcionFechaNotaIngreso
	 */
	public String getOpcionFechaNotaIngreso() {
		return opcionFechaNotaIngreso;
	}
	/**
	 * @param opcionFechaNotaIngreso the opcionFechaNotaIngreso to set
	 */
	public void setOpcionFechaNotaIngreso(String opcionFechaNotaIngreso) {
		this.opcionFechaNotaIngreso = opcionFechaNotaIngreso;
	}
	/**
	 * @return the aprobadoForzado
	 */
	public Boolean getAprobadoForzado() {
		return aprobadoForzado;
	}
	/**
	 * @param aprobadoForzado the aprobadoForzado to set
	 */
	public void setAprobadoForzado(Boolean aprobadoForzado) {
		this.aprobadoForzado = aprobadoForzado;
	}
	/**
	 * @return the traerNotasIngresoPorHacer
	 */
	public Boolean getTraerNotasIngresoPorHacer() {
		return traerNotasIngresoPorHacer;
	}
	/**
	 * @param traerNotasIngresoPorHacer the traerNotasIngresoPorHacer to set
	 */
	public void setTraerNotasIngresoPorHacer(Boolean traerNotasIngresoPorHacer) {
		this.traerNotasIngresoPorHacer = traerNotasIngresoPorHacer;
	}
	/**
	 * @return the observacionNotaIngreso
	 */
	public String getObservacionNotaIngreso() {
		return observacionNotaIngreso;
	}
	/**
	 * @param observacionNotaIngreso the observacionNotaIngreso to set
	 */
	public void setObservacionNotaIngreso(String observacionNotaIngreso) {
		this.observacionNotaIngreso = observacionNotaIngreso;
	}
	/**
	 * @return the porRealizar
	 */
	public String getPorRealizar() {
		return porRealizar;
	}
	/**
	 * @param porRealizar the porRealizar to set
	 */
	public void setPorRealizar(String porRealizar) {
		this.porRealizar = porRealizar;
	}
	/**
	 * @return the nombrePlazoPago
	 */
	public String getNombrePlazoPago() {
		return nombrePlazoPago;
	}
	/**
	 * @param nombrePlazoPago the nombrePlazoPago to set
	 */
	public void setNombrePlazoPago(String nombrePlazoPago) {
		this.nombrePlazoPago = nombrePlazoPago;
	}
	/**
	 * @return the valorPlazoPago
	 */
	public Long getValorPlazoPago() {
		return valorPlazoPago;
	}
	/**
	 * @param valorPlazoPago the valorPlazoPago to set
	 */
	public void setValorPlazoPago(Long valorPlazoPago) {
		this.valorPlazoPago = valorPlazoPago;
	}
	/**
	 * @return the codigoTipoPlazoPago
	 */
	public Integer getCodigoTipoPlazoPago() {
		return codigoTipoPlazoPago;
	}
	/**
	 * @param codigoTipoPlazoPago the codigoTipoPlazoPago to set
	 */
	public void setCodigoTipoPlazoPago(Integer codigoTipoPlazoPago) {
		this.codigoTipoPlazoPago = codigoTipoPlazoPago;
	}
	/**
	 * @return the valorTipoPlazoPago
	 */
	public String getValorTipoPlazoPago() {
		return valorTipoPlazoPago;
	}
	/**
	 * @param valorTipoPlazoPago the valorTipoPlazoPago to set
	 */
	public void setValorTipoPlazoPago(String valorTipoPlazoPago) {
		this.valorTipoPlazoPago = valorTipoPlazoPago;
	}
	
	public Date getFechaVencimientoPlazoPago() {
		return fechaVencimientoPlazoPago;
	}
	
	public void setFechaVencimientoPlazoPago(Date fechaVencimientoPlazoPago) {
		this.fechaVencimientoPlazoPago = fechaVencimientoPlazoPago;
	}
	
	public Collection<ResumenTotalDocumentoDTO> getResumenTotalDocumentoDTOCol() {
		return resumenTotalDocumentoDTOCol;
	}
	
	public void setResumenTotalDocumentoDTOCol(Collection<ResumenTotalDocumentoDTO> resumenTotalDocumentoDTOCol) {
		this.resumenTotalDocumentoDTOCol = resumenTotalDocumentoDTOCol;
	}
	
	public BigDecimal getValorAjusteResumenTotalDocumento() {
		return valorAjusteResumenTotalDocumento;
	}
	
	public void setValorAjusteResumenTotalDocumento(BigDecimal valorAjusteResumenTotalDocumento) {
		this.valorAjusteResumenTotalDocumento = valorAjusteResumenTotalDocumento;
	}
	
	public Integer getNumeroFacturasFisicas() {
		return numeroFacturasFisicas;
	}
	
	public void setNumeroFacturasFisicas(Integer numeroFacturasFisicas) {
		this.numeroFacturasFisicas = numeroFacturasFisicas;
	}
	
	public Integer getNumeroFacturasElectronicas() {
		return numeroFacturasElectronicas;
	}
	
	public void setNumeroFacturasElectronicas(Integer numeroFacturasElectronicas) {
		this.numeroFacturasElectronicas = numeroFacturasElectronicas;
	}
	
	public Integer getNumeroNotasCreditoFisicas() {
		return numeroNotasCreditoFisicas;
	}
	
	public void setNumeroNotasCreditoFisicas(Integer numeroNotasCreditoFisicas) {
		this.numeroNotasCreditoFisicas = numeroNotasCreditoFisicas;
	}
	
	public Integer getNumeroNotasCreditoElectronicas() {
		return numeroNotasCreditoElectronicas;
	}
	
	public void setNumeroNotasCreditoElectronicas(Integer numeroNotasCreditoElectronicas) {
		this.numeroNotasCreditoElectronicas = numeroNotasCreditoElectronicas;
	}
	
	public Integer getNumeroNotasDebitoFisicas() {
		return numeroNotasDebitoFisicas;
	}
	
	public void setNumeroNotasDebitoFisicas(Integer numeroNotasDebitoFisicas) {
		this.numeroNotasDebitoFisicas = numeroNotasDebitoFisicas;
	}
	
	public Integer getNumeroNotasDebitoElectronicas() {
		return numeroNotasDebitoElectronicas;
	}
	
	public void setNumeroNotasDebitoElectronicas(Integer numeroNotasDebitoElectronicas) {
		this.numeroNotasDebitoElectronicas = numeroNotasDebitoElectronicas;
	}
	
	public String getCampoConDiferencia() {
		return campoConDiferencia;
	}
	
	public void setCampoConDiferencia(String campoConDiferencia) {
		this.campoConDiferencia = campoConDiferencia;
	}
	
	public String getCampoSinDiferencia() {
		return campoSinDiferencia;
	}
	
	public void setCampoSinDiferencia(String campoSinDiferencia) {
		this.campoSinDiferencia = campoSinDiferencia;
	}
	
	public Integer getNumeroNotasIngreso() {
		return numeroNotasIngreso;
	}
	
	public void setNumeroNotasIngreso(Integer numeroNotasIngreso) {
		this.numeroNotasIngreso = numeroNotasIngreso;
	}
	
	public Integer getNumeroFacturasProveedor() {
		return numeroFacturasProveedor;
	}
	
	public void setNumeroFacturasProveedor(Integer numeroFacturasProveedor) {
		this.numeroFacturasProveedor = numeroFacturasProveedor;
	}
	public String getEstiloRegistro() {
		return estiloRegistro;
	}
	public void setEstiloRegistro(String estiloRegistro) {
		this.estiloRegistro = estiloRegistro;
	}
	public Collection<ISearchTemplate> getFiltrosBusqueda() {
		return filtrosBusqueda;
	}
	public void setFiltrosBusqueda(Collection<ISearchTemplate> filtrosBusqueda) {
		this.filtrosBusqueda = filtrosBusqueda;
	}
	public String getNumeroDocumentos() {
		return numeroDocumentos;
	}
	public void setNumeroDocumentos(String numeroDocumentos) {
		this.numeroDocumentos = numeroDocumentos;
	}
	
}