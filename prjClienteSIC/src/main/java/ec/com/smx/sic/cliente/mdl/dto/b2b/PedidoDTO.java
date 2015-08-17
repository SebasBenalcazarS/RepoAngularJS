package ec.com.smx.sic.cliente.mdl.dto.b2b;

/*
 * Java Import's
 */
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CompradorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.PedidoID;

/**
 * almacena los pedidos solicitados por los compradores
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoDTO")
@Table(name = "SSB2BTPEDIDO")
@Deprecated
public class PedidoDTO extends SimpleAuditDTO {
	/**
	 * Campo identificador
	 */
	@EmbeddedId
	private PedidoID id = new PedidoID();

	/**
	 * Relacion de pedidos y archivos
	 */
	
	@OneToMany(mappedBy = "pedido")
	private Set<PedidoArchivoDTO> pedidoArchivos = new LinkedHashSet<PedidoArchivoDTO>();

	// Relacion con la tabla SSB2BTPEDIDODETALLE
	@OneToMany(mappedBy = "pedidoDTO")
	private Collection<PedidoDetalleDTO> listaPedidosDetalle;

	@Transient
	private Collection<PedidoDetalleDTO> npOrdenesCompra = new ArrayList<PedidoDetalleDTO>();

	@Transient
	private Boolean npMostrarOrdenes;

	/**
	 * Coleccion de ordenes de compra [pedido detalle] relacionadas con el
	 * pedido
	 */
	@OneToMany(mappedBy = "pedidoDTO")
	private Set<PedidoDetalleDTO> ordenesCompra = new LinkedHashSet<PedidoDetalleDTO>();

	/**
	 * Coleccion de archivos relacionados con el pedido
	 */
	@Transient
	private Collection archivos = new ArrayList();

	/**
	 * Flag para indicar si el pedido tiene o no ordenes canceladas 0 No tiene
	 * ordenes canceladas 1 Tiene al menos una orden cancelada
	 */
	private String tieneCancelacionOrden;

	/**
	 * Propiedad no persistente de descripcion del tipo de pedido
	 */
	@Transient
	private String descripcionTipoPedido;

	/**
	 * Propiedad no persistente de descripcion del estado de pedido
	 */
	@Transient
	private String descripcionEstadoPedido;

	/**
	 * Numero asignado al pedido por sistema SIC
	 */
	private java.lang.Long numeroPedido;

	/**
	 * Fecha de elaboracion del pedido
	 * 
	 */
	private Date fechaElaboracion;

	/**
	 * Fecha asignada para la entrega de la orden de compra
	 */
	private Date fechaEntrega;

	/**
	 * Fecha de vencimiento/caducidad del pedido
	 * 
	 */
	private Date fechaCaducidad;

	private Timestamp fechaRegistroPedido;

	private Timestamp fechaActualizacionPedido;

	/**
	 * Codigo del comprador que realiza el pedido
	 */
	private String codigoComprador;

	/**
	 * Codigo del proveedor a quien se le realiza el pedido
	 * 
	 */
	@ComparatorTypeField
	private String codigoProveedor;

	/**
	 * Codigo rel area de trabajo que corresponde � a la unidad operativa
	 * 
	 */
	private Integer codigoAreaTrabajo;

	/**
	 * Codigo de la bodega
	 */
	private String codigoBodega;

	/**
	 * Estado que indica si ha sido consultado un pedido 0: no consultado 1: si
	 * consultado
	 */
	private String estadoConsultado;

	/**
	 * Estado de pedido
	 */
	@ComparatorTypeField
	private String estadoPedido;

	/**
	 * Tipo del pedido
	 */
	private String tipoPedido;

	private String nombreResponsableOrdenCompra;
	/**
	 * En este campo se almacena el id del usuario responsable de la orden de
	 * compra, este id de usuario corresponde a los usuarios que tenemos en
	 * nuestra base de datos en la tabla KSSEGTUSER
	 * Transient hasta crear el campo en produccion
	 */
	@Transient
	private String idUsuarioResponsableOrdenCompra;
	/**
	 * Indica un cambio en el Pedido. SIN : Sin Notificaci�n CFC: Caducidad
	 * 
	 */
	private String tipoNotificacion;
	/**
	 * Secuencial Caracteristica Pedido
	 */
	private String codigoCaracteristicaPedido;
	
	/**
	 * Bandera para saber si un pedido ya fue procesado
	 */
	private String procesado;

	@Transient
	private Boolean npTraerProveedor = false;

	/**
	 * Comprador que solicita pedido al proveedor
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCOMPRADOR", referencedColumnName = "CODIGOCOMPRADOR", insertable = false, updatable = false)
	})
	private CompradorDTO comprador;

	/**
	 * Referencia a la bodega en la que se recepta el pedido
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBODEGA", referencedColumnName = "CODIGOBODEGA", insertable = false, updatable = false)
	})
	private BodegaDTO bodega;

	/**
	 * Referencia al proveedor al que pertenece el pedido
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private VistaProveedorDTO proveedor;

	/**
	 * Referencia a la unidad operativa que maneja el pedido
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
	})
	private AreaTrabajoDTO unidadOperativa;

	// referencia al tipo de pedido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPOPEDIDO", referencedColumnName = "TIPOPEDIDO", updatable = false, insertable = false)
	private TipoPedidoDTO tipoPedidoDTO;

	// referencia al estado del pedido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTADOPEDIDO", referencedColumnName = "ESTADOPEDIDO", insertable = false, updatable = false)
	private EstadoPedidoDTO estadoPedidoDTO;

	// referencia a la caracteristicaPedido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOCARACTERISTICAPEDIDO", referencedColumnName = "CODIGOCARACTERISTICAPEDIDO", insertable = false, updatable = false)
	private CaracteristicaPedidoDTO caracteristicaPedidoDTO;

	// campos no persistentes

	/**
	 * Estado que indica si ha sido consultado un pedido Propiedad no
	 * persistente 0: no consultado 1: si consultado
	 */
	@Transient
	private String estadoConsultadoNP;

	/**
	 * Propiedad que indica si el Pedido pertenece a la fecha actual (HOY) 0: No
	 * es de hoy 1: Si es de hoy
	 */
	@Transient
	private String perteneceFechaActualNP;

	// atributos no persistentes para el ingreso de los rangos de fechas
	@Transient
	private Timestamp npFechaConsultaInicial;
	
	@Transient
	private Timestamp npFechaConsultaFinal;

	// objeto para la consulta sobre el detalle del pedido
	@Transient
	private PedidoDetalleDTO pedidoDetalleDTO;
	// Esta propiedad me indica si los pedidos que voy a traer son de
	// Importaciones
	
	@Transient
	private Boolean npSonPedidosImportaciones = Boolean.FALSE;
	
	@Transient
	private Collection<String> npCodigosProveedores;
	
	@Transient
	private Collection<String> npCodigosCompradores;
	/**
	 * Esta propiedad indica si voy a tener una consulta si las ordenes de
	 * compra son nuevas o no
	 */
	@Transient
	private boolean npConsultaEsNueva = false;
	/**
	 * Esta propiedad me indica si en la consulta del pedido voy a trer o no los
	 * PedidoDetalleRelacionados de los PedidoDetalle
	 */
	@Transient
	private boolean npTraerRelacionadosPedidoDetalles = false;
	/**
	 * Contiene los c�digos de ordenes de compra separados por coma
	 */
	@Transient
	private String ordenesCompraString;

	/**
	 * @return the npFechaInicioPedidosEspeciales
	 */
	public Date getNpFechaInicioPedidosEspeciales() {
		return npFechaInicioPedidosEspeciales;
	}

	/**
	 * @param npFechaInicioPedidosEspeciales
	 *            the npFechaInicioPedidosEspeciales to set
	 */
	public void setNpFechaInicioPedidosEspeciales(Date npFechaInicioPedidosEspeciales) {
		this.npFechaInicioPedidosEspeciales = npFechaInicioPedidosEspeciales;
	}

	/**
	 * @return the npFechaFinPedidosEspeciales
	 */
	public Date getNpFechaFinPedidosEspeciales() {
		return npFechaFinPedidosEspeciales;
	}

	/**
	 * @param npFechaFinPedidosEspeciales
	 *            the npFechaFinPedidosEspeciales to set
	 */
	public void setNpFechaFinPedidosEspeciales(Date npFechaFinPedidosEspeciales) {
		this.npFechaFinPedidosEspeciales = npFechaFinPedidosEspeciales;
	}

	/**
	 * @return the npUnidadesOperativasEspeciales
	 */
	public Integer[] getNpUnidadesOperativasEspeciales() {
		return npUnidadesOperativasEspeciales;
	}

	/**
	 * @param npUnidadesOperativasEspeciales
	 *            the npUnidadesOperativasEspeciales to set
	 */
	public void setNpUnidadesOperativasEspeciales(Integer[] npUnidadesOperativasEspeciales) {
		this.npUnidadesOperativasEspeciales = npUnidadesOperativasEspeciales;
	}
	
	@Transient
	private Date npFechaInicioPedidosEspeciales;

	@Transient
	private Date npFechaFinPedidosEspeciales;

	@Transient
	private Integer[] npUnidadesOperativasEspeciales;

	/**
	 * Constructor por defecto
	 */
	public PedidoDTO() {
		this.estadoConsultadoNP = "0";
		this.perteneceFechaActualNP = "0";
	}

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public PedidoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(PedidoID id1) {
		this.id = id1;
	}

	/**
	 * @return Devuelve archivos.
	 */
	public Collection getArchivos() {
		return archivos;
	}

	/**
	 * Establecer coleccion de archivos de pedidos
	 * 
	 * @param archivos
	 *            La coleccion de archivos a establecer.
	 */
	public void setArchivos(Collection archivos) {
		this.archivos = archivos;
	}

	/**
	 * Retorna valor de propiedad <code>fechaElaboracion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaElaboracion</code>
	 */
	public java.util.Date getFechaElaboracion() {
		return this.fechaElaboracion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaElaboracion</code>.
	 * 
	 * @param fechaElaboracion1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaElaboracion</code>.
	 */
	public void setFechaElaboracion(java.util.Date fechaElaboracion1) {
		this.fechaElaboracion = fechaElaboracion1;
	}

	/**
	 * Retorna propiedad <code>fechaElaboracion</code> como String
	 * 
	 * @return Retorna propiedad <code>fechaElaboracion</code> como String
	 */
	public String getFechaElaboracionS() {
		return (this.fechaElaboracion != null) ? ec.com.smx.corporativo.commons.util.CorporativoUtil.getYMDDateFormat().format(this.fechaElaboracion) : null;
	}

	/**
	 * Permite establecer el valor de la propiedad <code>fechaElaboracion</code>
	 * a partir de un String de fecha
	 * 
	 * @param cadena
	 *            String que representa el valor formateado para establecer
	 *            <code>fechaElaboracion</code>.
	 */
	public void setFechaElaboracionS(String cadena) {
		try {
			this.fechaElaboracion = (cadena != null) ? ec.com.smx.corporativo.commons.util.CorporativoUtil.getYMDDateFormat().parse(cadena) : null;
		} catch (Exception ex) {
			throw new SICException("La fecha de elaboracion no se puede transformar a cadena",ex);
		}
	}

	/**
	 * Retorna valor de propiedad <code>fechaEntrega</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaEntrega</code>
	 */
	public java.util.Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaEntrega</code>.
	 * 
	 * @param fechaEntrega1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaEntrega</code>.
	 */
	public void setFechaEntrega(java.util.Date fechaEntrega1) {
		this.fechaEntrega = fechaEntrega1;

	}

	/**
	 * Retorna propiedad <code>fechaEntrega</code> como String
	 * 
	 * @return Retorna propiedad <code>fechaEntrega</code> como String
	 */
	public String getFechaEntregaS() {
		return (this.fechaEntrega != null) ? ec.com.smx.corporativo.commons.util.CorporativoUtil.getYMDDateFormat().format(this.fechaEntrega) : null;
	}

	/**
	 * Permite establecer el valor de la propiedad <code>fechaEntrega</code> a
	 * partir de un String de fecha
	 * 
	 * @param cadena
	 *            String que representa el valor formateado para establecer
	 *            <code>fechaEntrega</code>.
	 */
	public void setFechaEntregaS(String cadena) {
		try {
			this.fechaEntrega = (cadena != null) ? ec.com.smx.corporativo.commons.util.CorporativoUtil.getYMDDateFormat().parse(cadena) : null;
		} catch (Exception ex) {
			throw new SICException("La fecha de entrega no se puede transformar a cadena",ex);
		}
	}

	/**
	 * Retorna valor de propiedad <code>fechaCaducidad</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaCaducidad</code>
	 */
	public java.util.Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaCaducidad</code>.
	 * 
	 * @param fechaCaducidad1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaCaducidad</code>.
	 */
	public void setFechaCaducidad(java.util.Date fechaCaducidad1) {
		this.fechaCaducidad = fechaCaducidad1;

	}

	/**
	 * Retorna propiedad <code>fechaCaducidad</code> como String
	 * 
	 * @return Retorna propiedad <code>fechaCaducidad</code> como String
	 */
	public String getFechaCaducidadS() {
		return (this.fechaCaducidad != null) ? ec.com.smx.corporativo.commons.util.CorporativoUtil.getYMDDateFormat().format(this.fechaCaducidad) : null;
	}

	/**
	 * Permite establecer el valor de la propiedad <code>fechaCaducidad</code> a
	 * partir de un String de fecha
	 * 
	 * @param cadena
	 *            String que representa el valor formateado para establecer
	 *            <code>fechaCaducidad</code>.
	 */
	public void setFechaCaducidadS(String cadena) {
		try {
			this.fechaCaducidad = (cadena != null) ? ec.com.smx.corporativo.commons.util.CorporativoUtil.getYMDDateFormat().parse(cadena) : null;
		} catch (Exception ex) {
			throw new SICException("La fecha de caducidad no se puede transformar a cadena",ex);
		}
	}

	/**
	 * Retorna valor de propiedad <code>codigoComprador</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoComprador</code>
	 */
	public String getCodigoComprador() {
		return this.codigoComprador;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoComprador</code>.
	 * 
	 * @param codigoComprador1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoComprador</code>.
	 */
	public void setCodigoComprador(String codigoComprador1) {
		this.codigoComprador = codigoComprador1;

		if (codigoComprador != null && codigoComprador.length() > 10) {
			codigoComprador = codigoComprador.substring(0, 10);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoProveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoProveedor</code>
	 */
	public String getCodigoProveedor() {
		return this.codigoProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoProveedor</code>.
	 * 
	 * @param codigoProveedor1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoProveedor</code>.
	 */
	public void setCodigoProveedor(String codigoProveedor1) {
		this.codigoProveedor = codigoProveedor1;

		if (codigoProveedor != null && codigoProveedor.length() > 10) {
			codigoProveedor = codigoProveedor.substring(0, 10);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoAreaTrabajo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoAreaTrabajo</code>
	 */
	public Integer getCodigoAreaTrabajo() {
		return this.codigoAreaTrabajo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoAreaTrabajo</code>
	 * .
	 * 
	 * @param codigoAreaTrabajo1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoAreaTrabajo</code>.
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo1) {
		this.codigoAreaTrabajo = codigoAreaTrabajo1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoBodega</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoBodega</code>
	 */
	public String getCodigoBodega() {
		return this.codigoBodega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoBodega</code>.
	 * 
	 * @param codigoBodega1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoBodega</code>.
	 */
	public void setCodigoBodega(String codigoBodega1) {
		this.codigoBodega = codigoBodega1;

		if (codigoBodega != null && codigoBodega.length() > 10) {
			codigoBodega = codigoBodega.substring(0, 10);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estadoConsultado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoConsultado</code>
	 */
	public String getEstadoConsultado() {
		return this.estadoConsultado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoConsultado</code>.
	 * 
	 * @param estadoConsultado1
	 *            El valor a establecer para la propiedad
	 *            <code>estadoConsultado</code>.
	 */
	public void setEstadoConsultado(String estadoConsultado1) {
		this.estadoConsultado = estadoConsultado1;

		if (estadoConsultado != null && estadoConsultado.length() > 1) {
			estadoConsultado = estadoConsultado.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>comprador</code>
	 * 
	 * @return Retorna valor de propiedad <code>comprador</code>
	 */
	public CompradorDTO getComprador() {
		return this.comprador;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>comprador</code>.
	 * 
	 * @param comprador1
	 *            El valor a establecer para la propiedad <code>comprador</code>
	 *            .
	 */
	public void setComprador(CompradorDTO comprador1) {
		this.comprador = comprador1;
	}

	/**
	 * Retorna valor de propiedad <code>bodega</code>
	 * 
	 * @return Retorna valor de propiedad <code>bodega</code>
	 */
	public BodegaDTO getBodega() {
		return this.bodega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>bodega</code>.
	 * 
	 * @param bodega1
	 *            El valor a establecer para la propiedad <code>bodega</code>.
	 */
	public void setBodega(BodegaDTO bodega1) {
		this.bodega = bodega1;
	}

	/**
	 * Retorna valor de propiedad <code>proveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>proveedor</code>
	 */
	public VistaProveedorDTO getProveedor() {
		return this.proveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * 
	 * @param proveedor1
	 *            El valor a establecer para la propiedad <code>proveedor</code>
	 *            .
	 */
	public void setProveedor(VistaProveedorDTO proveedor1) {
		this.proveedor = proveedor1;
	}

	/**
	 * Retorna valor de propiedad <code>unidadOperativa</code>
	 * 
	 * @return Retorna valor de propiedad <code>unidadOperativa</code>
	 */
	public AreaTrabajoDTO getUnidadOperativa() {
		return this.unidadOperativa;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>unidadOperativa</code>.
	 * 
	 * @param unidadOperativa1
	 *            El valor a establecer para la propiedad
	 *            <code>unidadOperativa</code>.
	 */
	public void setUnidadOperativa(AreaTrabajoDTO unidadOperativa1) {
		this.unidadOperativa = unidadOperativa1;
	}

	/**
	 * Devuelve el numero de pedido
	 * 
	 * @return
	 */
	public java.lang.Long getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * 
	 * @param numeroPedido
	 *            El numero de pedido a establecer
	 */
	public void setNumeroPedido(java.lang.Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	/**
	 * 
	 * @param estadoPedido
	 *            El estado de pedido a establecer
	 */
	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	/**
	 * 
	 * @param tipoPedido
	 *            El tipo de pedido a establecer
	 */
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getDescripcionEstadoPedido() {
		return descripcionEstadoPedido;
	}

	public void setDescripcionEstadoPedido(String descripcionEstadoPedido) {
		this.descripcionEstadoPedido = descripcionEstadoPedido;
	}

	public String getDescripcionTipoPedido() {
		return descripcionTipoPedido;
	}

	public void setDescripcionTipoPedido(String descripcionTipoPedido) {
		this.descripcionTipoPedido = descripcionTipoPedido;
	}

	/**
	 * Indica si el pedido tiene cancelaciones
	 * 
	 * @return
	 */
	public String getTieneCancelacionOrden() {
		return tieneCancelacionOrden;
	}

	/**
	 * Establece si el pedido tiene cancelacion
	 * 
	 * @param tieneCancelacionOrden
	 */
	public void setTieneCancelacionOrden(String tieneCancelacionOrden) {
		this.tieneCancelacionOrden = tieneCancelacionOrden;
	}

	public String getEstadoConsultadoNP() {
		return estadoConsultadoNP;
	}

	public void setEstadoConsultadoNP(String estadoConsultadoNP) {
		this.estadoConsultadoNP = estadoConsultadoNP;
	}

	public String getPerteneceFechaActualNP() {
		return perteneceFechaActualNP;
	}

	public void setPerteneceFechaActualNP(String perteneceFechaActualNP) {
		this.perteneceFechaActualNP = perteneceFechaActualNP;
	}

	/**
	 * @return el tipoPedidoDTO
	 */
	public TipoPedidoDTO getTipoPedidoDTO() {
		return tipoPedidoDTO;
	}

	/**
	 * @param tipoPedidoDTO
	 *            el tipoPedidoDTO a establecer
	 */
	public void setTipoPedidoDTO(TipoPedidoDTO tipoPedidoDTO) {
		this.tipoPedidoDTO = tipoPedidoDTO;
	}

	/**
	 * @return el estadoPedidoDTO
	 */
	public EstadoPedidoDTO getEstadoPedidoDTO() {
		return estadoPedidoDTO;
	}

	/**
	 * @param estadoPedidoDTO
	 *            el estadoPedidoDTO a establecer
	 */
	public void setEstadoPedidoDTO(EstadoPedidoDTO estadoPedidoDTO) {
		this.estadoPedidoDTO = estadoPedidoDTO;
	}

	/**
	 * @return el npFechaConsultaFinal
	 */
	public Date getNpFechaConsultaFinal() {
		return npFechaConsultaFinal;
	}

	/**
	 * @return el npFechaConsultaInicial
	 */
	public Date getNpFechaConsultaInicial() {
		return npFechaConsultaInicial;
	}

	/**
	 * @return el pedidoDetalleDTO
	 */
	public PedidoDetalleDTO getPedidoDetalleDTO() {
		return pedidoDetalleDTO;
	}

	/**
	 * @param pedidoDetalleDTO
	 *            el pedidoDetalleDTO a establecer
	 */
	public void setPedidoDetalleDTO(PedidoDetalleDTO pedidoDetalleDTO) {
		this.pedidoDetalleDTO = pedidoDetalleDTO;
	}

	/**
	 * @return el ordenesCompra
	 */
	public Set<PedidoDetalleDTO> getOrdenesCompra() {
		return ordenesCompra;
	}

	/**
	 * @param ordenesCompra
	 *            el ordenesCompra a establecer
	 */
	public void setOrdenesCompra(Set<PedidoDetalleDTO> ordenesCompra) {
		this.ordenesCompra = ordenesCompra;
	}

	/**
	 * @return el pedidoArchivos
	 */
	public Set<PedidoArchivoDTO> getPedidoArchivos() {
		return pedidoArchivos;
	}

	/**
	 * @param pedidoArchivos
	 *            el pedidoArchivos a establecer
	 */
	public void setPedidoArchivos(Set<PedidoArchivoDTO> pedidoArchivos) {
		this.pedidoArchivos = pedidoArchivos;
	}

	/**
	 * @param npFechaConsultaFinal
	 *            el npFechaConsultaFinal a establecer
	 */
	public void setNpFechaConsultaFinal(Timestamp npFechaConsultaFinal) {
		this.npFechaConsultaFinal = npFechaConsultaFinal;
	}

	/**
	 * @param npFechaConsultaInicial
	 *            el npFechaConsultaInicial a establecer
	 */
	public void setNpFechaConsultaInicial(Timestamp npFechaConsultaInicial) {
		this.npFechaConsultaInicial = npFechaConsultaInicial;
	}

	/**
	 * @return el nombreResponsableOrdenCompra
	 */
	public String getNombreResponsableOrdenCompra() {
		return nombreResponsableOrdenCompra;
	}

	/**
	 * @param nombreResponsableOrdenCompra
	 *            el nombreResponsableOrdenCompra a establecer
	 */
	public void setNombreResponsableOrdenCompra(String nombreResponsableOrdenCompra) {
		this.nombreResponsableOrdenCompra = nombreResponsableOrdenCompra;
	}

	/**
	 * @return el idUsuarioResponsableOrdenCompra
	 */
	public String getIdUsuarioResponsableOrdenCompra() {
		return idUsuarioResponsableOrdenCompra;
	}

	/**
	 * @param idUsuarioResponsableOrdenCompra
	 *            el idUsuarioResponsableOrdenCompra a establecer
	 */
	public void setIdUsuarioResponsableOrdenCompra(String idUsuarioResponsableOrdenCompra) {
		this.idUsuarioResponsableOrdenCompra = idUsuarioResponsableOrdenCompra;
	}

	/**
	 * Retorna valor de propiedad <code>tipoNotificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>tipoNotificacion</code>
	 */
	public String getTipoNotificacion() {
		return this.tipoNotificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoNotificacion</code>.
	 * 
	 * @param tipoNotificacion
	 *            El valor a establecer para la propiedad
	 *            <code>tipoNotificacion</code>.
	 */
	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}

	/**
	 * @return el fechaRegistroPedido
	 */
	public Timestamp getFechaRegistroPedido() {
		return fechaRegistroPedido;
	}

	/**
	 * @param fechaRegistroPedido
	 *            el fechaRegistroPedido a establecer
	 */
	public void setFechaRegistroPedido(Timestamp fechaRegistroPedido) {
		this.fechaRegistroPedido = fechaRegistroPedido;
	}

	/**
	 * @return el fechaActualizacionPedido
	 */
	public Timestamp getFechaActualizacionPedido() {
		return fechaActualizacionPedido;
	}

	/**
	 * @param fechaActualizacionPedido
	 *            el fechaActualizacionPedido a establecer
	 */
	public void setFechaActualizacionPedido(Timestamp fechaActualizacionPedido) {
		this.fechaActualizacionPedido = fechaActualizacionPedido;
	}

	/**
	 * @return el codigoCaracteristicaPedido
	 */
	public String getCodigoCaracteristicaPedido() {
		return codigoCaracteristicaPedido;
	}

	/**
	 * @param codigoCaracteristicaPedido
	 *            el codigoCaracteristicaPedido a establecer
	 */
	public void setCodigoCaracteristicaPedido(String codigoCaracteristicaPedido) {
		this.codigoCaracteristicaPedido = codigoCaracteristicaPedido;
	}

	/**
	 * @return el caracteristicaPedidoTO
	 */
	public CaracteristicaPedidoDTO getCaracteristicaPedidoDTO() {
		return caracteristicaPedidoDTO;
	}

	/**
	 * @param caracteristicaPedidoDTO
	 *            el caracteristicaPedidoDTO a establecer
	 */
	public void setCaracteristicaPedidoDTO(CaracteristicaPedidoDTO caracteristicaPedidoDTO) {
		this.caracteristicaPedidoDTO = caracteristicaPedidoDTO;
	}

	public Boolean getNpSonPedidosImportaciones() {
		return npSonPedidosImportaciones;
	}

	public void setNpSonPedidosImportaciones(Boolean npSonPedidosImportaciones) {
		this.npSonPedidosImportaciones = npSonPedidosImportaciones;
	}

	public Collection<String> getNpCodigosCompradores() {
		return npCodigosCompradores;
	}

	public void setNpCodigosCompradores(Collection<String> npCodigosCompradores) {
		this.npCodigosCompradores = npCodigosCompradores;
	}

	public Collection<String> getNpCodigosProveedores() {
		return npCodigosProveedores;
	}

	public void setNpCodigosProveedores(Collection<String> npCodigosProveedores) {
		this.npCodigosProveedores = npCodigosProveedores;
	}

	public Boolean getNpTraerProveedor() {
		return npTraerProveedor;
	}

	public void setNpTraerProveedor(Boolean npTraerProveedor) {
		this.npTraerProveedor = npTraerProveedor;
	}

	/**
	 * @return el npConsultaEsNueva
	 */
	public boolean getNpConsultaEsNueva() {
		return npConsultaEsNueva;
	}

	/**
	 * @param npConsultaEsNueva
	 *            el npConsultaEsNueva a establecer
	 */
	public void setNpConsultaEsNueva(boolean npConsultaEsNueva) {
		this.npConsultaEsNueva = npConsultaEsNueva;
	}

	public boolean isNpTraerRelacionadosPedidoDetalles() {
		return npTraerRelacionadosPedidoDetalles;
	}

	public void setNpTraerRelacionadosPedidoDetalles(boolean npTraerRelacionadosPedidoDetalles) {
		this.npTraerRelacionadosPedidoDetalles = npTraerRelacionadosPedidoDetalles;
	}

	public Boolean tieneOrdenesCompra() {
		return isLoaded(this.ordenesCompra) && !this.ordenesCompra.isEmpty();
	}

	/**
	 * @return the ordenesCompraString
	 */
	public String getOrdenesCompraString() {
		if (tieneOrdenesCompra()) {
			StringBuilder ordenesCompra = new StringBuilder();
			for (PedidoDetalleDTO pedidoDetalleDTO : this.ordenesCompra) {
				ordenesCompra.append(pedidoDetalleDTO.getId().getCodigoOrdenCompra()).append(",");
			}
			ordenesCompra.delete(ordenesCompra.length() - 1, ordenesCompra.length()); // se
																						// elimina
																						// el
																						// �ltimo
																						// caracter
			ordenesCompraString = ordenesCompra.toString();
		}
		return ordenesCompraString;
	}

	/**
	 * @param ordenesCompraString
	 *            the ordenesCompraString to set
	 */
	public void setOrdenesCompraString(String ordenesCompraString) {
		this.ordenesCompraString = ordenesCompraString;
	}

	// /////////
	/**
	 * @return the npOrdenesCompra
	 */
	public Collection<PedidoDetalleDTO> getNpOrdenesCompra() {
		return npOrdenesCompra;
	}

	/**
	 * @param npOrdenesCompra
	 *            the npOrdenesCompra to set
	 */
	public void setNpOrdenesCompra(Collection<PedidoDetalleDTO> npOrdenesCompra) {
		this.npOrdenesCompra = npOrdenesCompra;
	}

	/**
	 * @return the npMostrarOrdenes
	 */
	public Boolean getNpMostrarOrdenes() {
		return npMostrarOrdenes;
	}

	/**
	 * @param npMostrarOrdenes
	 *            the npMostrarOrdenes to set
	 */
	public void setNpMostrarOrdenes(Boolean npMostrarOrdenes) {
		this.npMostrarOrdenes = npMostrarOrdenes;
	}

	public Collection<PedidoDetalleDTO> getListaPedidosDetalle() {
		return listaPedidosDetalle;
	}

	public void setListaPedidosDetalle(Collection<PedidoDetalleDTO> listaPedidosDetalle) {
		this.listaPedidosDetalle = listaPedidosDetalle;
	}

	/**
	 * @return the procesado
	 */
	public String getProcesado() {
		return procesado;
	}

	/**
	 * @param procesado the procesado to set
	 */
	public void setProcesado(String procesado) {
		this.procesado = procesado;
	}

}