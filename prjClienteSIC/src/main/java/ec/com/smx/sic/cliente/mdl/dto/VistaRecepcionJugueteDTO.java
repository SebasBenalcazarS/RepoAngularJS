/*
 * Kruger 2014 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionJugueteID;

/**
 * <b> Estructura para el manejo de la recepcion de juguetes. </b>
 * 
 * @author mchiliquinga, Date: 19/03/2014
 * 
 */
@SuppressWarnings("serial")
@Entity
public class VistaRecepcionJugueteDTO implements Serializable {

	@EmbeddedId
	VistaRecepcionJugueteID id = new VistaRecepcionJugueteID();
	
	@Column(name = "UBICACION")
	private String ubicacion;

	@Column(name = "DESCRIPCIONARTICULO")
	private String descipcionArticulo;

	@Column(name = "TAMANIO")
	private String tamanio;

	@Column(name = "UNIDADEMPAQUE")
	private String unidadEmpaque;

	@Column(name = "CANTIDADUNIDADMANEJO")
	private Integer cantidadUnidadManejo;
	
	//Define el tipo de codigo de barras del articulo (EAN, INT)
	@Column(name = "CODIGOTIPOCODIGOARTICULO")
	private String tipoCodigoArticulo;

	@Column(name = "CODIGOBARRAS")
	private String codigoBarras;

	@Column(name = "CANTIDADPENDIENTERECIBIR")
	private Integer cantidadPendienteRecibir;
	
	//Define si el articulo es codificado o precodificado (COD, PCO)
	@Column(name = "CODIGOESTADO")
	private String estadoArticulo;
	
    @Column(name = "CODIGOSUBBODEGA")
    private String codigoSubbodega;
    
	@Column(name = "CODIGOPEDIDO")
	private Long codigoPedido;
	
	@Column(name = "FECHAINICIALACTIVO")
	private Date fechaInicialActivo;
	
	@Column(name = "CODIGOUNIDADMANEJO")
	private Long codigoUnidadManejo;
	
	//Codigo de referencia del embarque
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
    
    @Column(name="CODIGOCLASIFICACION")
	private String codigoClasificacion;
    
    @Column(name = "ESTADOARTICULOBITACORA")
    private String estadoArticuloBitacora;
    
	@Column(name="VALORTIPOSECUENCIA")
	private String valorTipoSecuencia ;
	
	@Column(name = "MARCACOMERCIAL")
	private String marcaComercial;
	
	@Column(name = "COSTOMONEDAORIGEN")
	private BigDecimal costoMonedaOrigen;
    
	@Column(name ="NOMBREGRUPOTRABAJO")
	private String nombreGrupoTrabajo;
	
	@Column(name ="CODIGOJDEPROVEEDOR")
	private String codigoJdeProveedor;
	
    @Column(name = "CODIGOMIGRACION")
    private Integer codigoMigracion;
    
    @Column(name = "CODIGOORDENCOMPRADETALLEESTADORELACION")
    private Long codigoOrdenCompraDetalleEstadoRelacion;
    
	@Column(name = "SECUENCIALMARCA")
	private Long secuencialMarca;
	
	@Column(name="CODIGOGRUPOTRABAJO")
	private Long codigoGrupoTrabajo;
	
	@Column(name = "NUMEROORDENCOMPRA")
    private String numeroOrdenCompra;
	
	@Column(name = "CODIGOINDICADORPROPIETARIO")
	private Integer codigoIndicadorPropietario;
	
	@Column(name = "CODIGOTIPOIMPUESTO")
	private Integer codigoTipoImpuesto;
	
	@Column(name = "CODIGOMONEDA")
	private Long codigoMoneda;
	
	@Column(name = "CODIGOREFERENCIAPROVEEDOR")
	private String codigoReferenciaProvedor;
	
    @Column(name = "CANTIDADPEDIDA")
    private Integer cantidadPedida;
    
    @Column(name = "COSTOMONEDAORIGENCOMISION")
    private BigDecimal costoMonedaOrigenComision;
    
    @Column(name = "PORCENTAJECOMISIONIMPORTACION")
    private BigDecimal porcentajeComisionImportacion;
    
    @Column(name = "CODIGOAREATRABAJOPEDIDO")
    private Integer codigoAreaTrabajoPedido;

    @Column(name = "PRIORIDAD")
    private Integer prioridad;
	
	@Transient
    private boolean isSelected;
    
    @Transient
    private Integer cantidadEntregada = 0; 
    
    @Transient
    private boolean isChangeCB;
    
    @Transient
    private boolean isChangeSecuencial;
    
    @Transient
    private boolean isChangeGrupoTrabajo;
    
    @Transient
    private boolean changeCostoComision;
    
	// En caso de existir sumarizacion, esta variable almacena los ids que seran inactivados
    @Transient
    private String codigoOrdenCompraDetalleEstadoSumarizado;
    
    @Transient
    private boolean isChangeCostoMoneda; 
    
    //Contiene el porcentaje disney aplicado al costo moneda origen.
    @Transient
    private double costoDisneyPorcentaje = 0;

    //Contiene los codigos de las areas de trabajo seleccionadas mediante un check en caso de que el prototipo se personalizado
    @Transient
    private String codigosAreaTrabajo;
    
    @Transient
    private boolean isChangeCodigoUnidadManejo;
    
  //Si cambia la unidad de manejo a UNI hay que actualizar la cantidad pedida con este valor
    @Transient
	private Integer cantidadPedidaUnidades;
    
  //Si cambia la unidad de manejo a CAJ hay que actualizar la cantidad pedida con este valor.
    @Transient
	private Integer cantidadPedidaCajas;
    
    @Transient
    private boolean changeInidcadorPropietario;
    
    //Esta en blanco si el detalle no tiene indicador propietario
    @Transient
    private String codigoIndicadorPropietarioOrigen;
    
    //Se asigna TRUE si se encontro un codigo de barras asociado a un articulo inactivo 
    @Transient
    private boolean esReutilizacionCodigoBarras;    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VistaRecepcionJugueteDTO other = (VistaRecepcionJugueteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public VistaRecepcionJugueteID getId() {
		return id;
	}

	public void setId(VistaRecepcionJugueteID id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescipcionArticulo() {
		return descipcionArticulo;
	}

	public void setDescipcionArticulo(String descipcionArticulo) {
		this.descipcionArticulo = descipcionArticulo;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getUnidadEmpaque() {
		return unidadEmpaque;
	}

	public void setUnidadEmpaque(String unidadEmpaque) {
		this.unidadEmpaque = unidadEmpaque;
	}

	public Integer getCantidadUnidadManejo() {
		return cantidadUnidadManejo;
	}

	public void setCantidadUnidadManejo(Integer cantidadUnidadManejo) {
		this.cantidadUnidadManejo = cantidadUnidadManejo;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidadPendienteRecibir() {
		return cantidadPendienteRecibir;
	}

	public void setCantidadPendienteRecibir(Integer cantidadPendienteRecibir) {
		this.cantidadPendienteRecibir = cantidadPendienteRecibir;
	}

	public String getEstadoArticulo() {
		return estadoArticulo;
	}

	public void setEstadoArticulo(String estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}

	public String getTipoCodigoArticulo() {
		return tipoCodigoArticulo;
	}

	public void setTipoCodigoArticulo(String tipoCodigoArticulo) {
		this.tipoCodigoArticulo = tipoCodigoArticulo;
	}

	public String getCodigoSubbodega() {
		return codigoSubbodega;
	}

	public void setCodigoSubbodega(String codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}

	public Integer getCantidadEntregada() {
		return cantidadEntregada;
	}

	public void setCantidadEntregada(Integer cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Date getFechaInicialActivo() {
		return fechaInicialActivo;
	}

	public void setFechaInicialActivo(Date fechaInicialActivo) {
		this.fechaInicialActivo = fechaInicialActivo;
	}

	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public String getEstadoArticuloBitacora() {
		return estadoArticuloBitacora;
	}

	public void setEstadoArticuloBitacora(String estadoArticuloBitacora) {
		this.estadoArticuloBitacora = estadoArticuloBitacora;
	}

	public String getValorTipoSecuencia() {
		return valorTipoSecuencia;
	}

	public void setValorTipoSecuencia(String valorTipoSecuencia) {
		this.valorTipoSecuencia = valorTipoSecuencia;
	}
	
	public String getMarcaComercial() {
		return marcaComercial;
	}

	public void setMarcaComercial(String marcaComercial) {
		this.marcaComercial = marcaComercial;
	}
	
    public BigDecimal getCostoMonedaOrigen() {
		return costoMonedaOrigen;
	}

	public void setCostoMonedaOrigen(BigDecimal costoMonedaOrigen) {
		this.costoMonedaOrigen = costoMonedaOrigen;
	}

	public String getNombreGrupoTrabajo() {
		return nombreGrupoTrabajo;
	}

	public void setNombreGrupoTrabajo(String nombreGrupoTrabajo) {
		this.nombreGrupoTrabajo = nombreGrupoTrabajo;
	}

	public String getCodigoJdeProveedor() {
		return codigoJdeProveedor;
	}

	public void setCodigoJdeProveedor(String codigoJdeProveedor) {
		this.codigoJdeProveedor = codigoJdeProveedor;
	}

	public Integer getCodigoMigracion() {
		return codigoMigracion;
	}

	public void setCodigoMigracion(Integer codigoMigracion) {
		this.codigoMigracion = codigoMigracion;
	}

	public Long getCodigoOrdenCompraDetalleEstadoRelacion() {
		return codigoOrdenCompraDetalleEstadoRelacion;
	}

	public void setCodigoOrdenCompraDetalleEstadoRelacion(Long codigoOrdenCompraDetalleEstadoRelacion) {
		this.codigoOrdenCompraDetalleEstadoRelacion = codigoOrdenCompraDetalleEstadoRelacion;
	}

	public boolean isChangeCB() {
		return isChangeCB;
	}

	public void setChangeCB(boolean isChangeCB) {
		this.isChangeCB = isChangeCB;
	}

	public Long getSecuencialMarca() {
		return secuencialMarca;
	}

	public void setSecuencialMarca(Long secuencialMarca) {
		this.secuencialMarca = secuencialMarca;
	}

	public boolean isChangeSecuencial() {
		return isChangeSecuencial;
	}

	public void setChangeSecuencial(boolean isChangeSecuencial) {
		this.isChangeSecuencial = isChangeSecuencial;
	}

	public Long getCodigoGrupoTrabajo() {
		return codigoGrupoTrabajo;
	}

	public void setCodigoGrupoTrabajo(Long codigoGrupoTrabajo) {
		this.codigoGrupoTrabajo = codigoGrupoTrabajo;
	}

	public boolean isChangeGrupoTrabajo() {
		return isChangeGrupoTrabajo;
	}

	public void setChangeGrupoTrabajo(boolean isChangeGrupoTrabajo) {
		this.isChangeGrupoTrabajo = isChangeGrupoTrabajo;
	}

	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public Integer getCodigoIndicadorPropietario() {
		return codigoIndicadorPropietario;
	}

	public void setCodigoIndicadorPropietario(Integer codigoIndicadorPropietario) {
		this.codigoIndicadorPropietario = codigoIndicadorPropietario;
	}

	public String getCodigoOrdenCompraDetalleEstadoSumarizado() {
		return codigoOrdenCompraDetalleEstadoSumarizado;
	}

	public void setCodigoOrdenCompraDetalleEstadoSumarizado(String codigoOrdenCompraDetalleEstadoSumarizado) {
		this.codigoOrdenCompraDetalleEstadoSumarizado = codigoOrdenCompraDetalleEstadoSumarizado;
	}

	public boolean isChangeCostoMoneda() {
		return isChangeCostoMoneda;
	}

	public void setChangeCostoMoneda(boolean isChangeCostoMoneda) {
		this.isChangeCostoMoneda = isChangeCostoMoneda;
	}

	public double getCostoDisneyPorcentaje() {
		return costoDisneyPorcentaje;
	}

	public void setCostoDisneyPorcentaje(double costoDisneyPorcentaje) {
		this.costoDisneyPorcentaje = costoDisneyPorcentaje;
	}

	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}

	public String getCodigosAreaTrabajo() {
		return codigosAreaTrabajo;
	}

	public void setCodigosAreaTrabajo(String codigosAreaTrabajo) {
		this.codigosAreaTrabajo = codigosAreaTrabajo;
	}

	public Long getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(Long codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public boolean isChangeCodigoUnidadManejo() {
		return isChangeCodigoUnidadManejo;
	}

	public void setChangeCodigoUnidadManejo(boolean isChangeCodigoUnidadManejo) {
		this.isChangeCodigoUnidadManejo = isChangeCodigoUnidadManejo;
	}

	public String getCodigoReferenciaProvedor() {
		return codigoReferenciaProvedor;
	}

	public void setCodigoReferenciaProvedor(String codigoReferenciaProvedor) {
		this.codigoReferenciaProvedor = codigoReferenciaProvedor;
	}

	public Integer getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public Integer getCantidadPedidaCajas() {
		return cantidadPedidaCajas;
	}

	public void setCantidadPedidaCajas(Integer cantidadPedidaCajas) {
		this.cantidadPedidaCajas = cantidadPedidaCajas;
	}

	public boolean isChangeInidcadorPropietario() {
		return changeInidcadorPropietario;
	}

	public void setChangeInidcadorPropietario(boolean changeInidcadorPropietario) {
		this.changeInidcadorPropietario = changeInidcadorPropietario;
	}

	public String getCodigoIndicadorPropietarioOrigen() {
		return codigoIndicadorPropietarioOrigen;
	}

	public void setCodigoIndicadorPropietarioOrigen(String codigoIndicadorPropietarioOrigen) {
		this.codigoIndicadorPropietarioOrigen = codigoIndicadorPropietarioOrigen;
	}

	public boolean isChangeCostoComision() {
		return changeCostoComision;
	}

	public void setChangeCostoComision(boolean changeCostoComision) {
		this.changeCostoComision = changeCostoComision;
	}

	public BigDecimal getCostoMonedaOrigenComision() {
		return costoMonedaOrigenComision;
	}

	public void setCostoMonedaOrigenComision(BigDecimal costoMonedaOrigenComision) {
		this.costoMonedaOrigenComision = costoMonedaOrigenComision;
	}

	public BigDecimal getPorcentajeComisionImportacion() {
		return porcentajeComisionImportacion;
	}

	public void setPorcentajeComisionImportacion(BigDecimal porcentajeComisionImportacion) {
		this.porcentajeComisionImportacion = porcentajeComisionImportacion;
	}

	public Integer getCantidadPedidaUnidades() {
		return cantidadPedidaUnidades;
	}

	public void setCantidadPedidaUnidades(Integer cantidadPedidaUnidades) {
		this.cantidadPedidaUnidades = cantidadPedidaUnidades;
	}

	public Integer getCodigoAreaTrabajoPedido() {
		return codigoAreaTrabajoPedido;
	}

	public void setCodigoAreaTrabajoPedido(Integer codigoAreaTrabajoPedido) {
		this.codigoAreaTrabajoPedido = codigoAreaTrabajoPedido;
	}
	
	public boolean isEsReutilizacionCodigoBarras() {
		return esReutilizacionCodigoBarras;
	}

	public void setEsReutilizacionCodigoBarras(boolean esReutilizacionCodigoBarras) {
		this.esReutilizacionCodigoBarras = esReutilizacionCodigoBarras;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}	
}
