/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorNovedadDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class ArticuloImportadoVO extends SimpleAuditDTO implements Serializable {
	
	private Integer codigoCompania;
	private String claseArticulo;
	private String codigoClasificacion;
	private String codigoClasificacionWRT;
	private String descripcionArticulo;
	private String codigoBarras;
	private Long codigoMarcaComercial;
	private String codigoPaisOrigen;
	private Long codigoLugarCompra;
	private String materialArticulo;
	private String codigoProveedor; 
	private String codigoReferenciaExterna;
	private BigDecimal costoBruto; 
	private Integer valorUnidadManejo;
	private String codigoCatalogoUnidadManejo;
	private Integer prioridad;
	private Boolean esCambioPrioridad;
	private boolean aplicaIva; 
	private boolean aplicaIve; 
	private String userId; 
	private String nombreMarca;
	private Long codigoMoneda;
	private BigDecimal tasaCambio;
	private Integer codigoAreaTrabajoPedido;
	private Integer codigoAreaTrabajoDestino;
	private String accessItemId;
	private String systemId;
	private String codigoClienteCompra;
	private Long codigoClienteImportacion;
	private ArrayList<Long> codigosLineasComerciales;
	
	private boolean noResolverCaso4;
	private boolean validarCodigoBarras;
	
	private ArticuloProveedorNovedadDTO articuloProveedorNovedadDTO;
	private VistaProveedorDTO vistaProveedorDTO;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the claseArticulo
	 */
	public String getClaseArticulo() {
		return claseArticulo;
	}

	/**
	 * @param claseArticulo the claseArticulo to set
	 */
	public void setClaseArticulo(String claseArticulo) {
		this.claseArticulo = claseArticulo;
	}

	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
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
	 * @return the codigoMarcaComercial
	 */
	public Long getCodigoMarcaComercial() {
		return codigoMarcaComercial;
	}

	/**
	 * @param codigoMarcaComercial the codigoMarcaComercial to set
	 */
	public void setCodigoMarcaComercial(Long codigoMarcaComercial) {
		this.codigoMarcaComercial = codigoMarcaComercial;
	}

	/**
	 * @return the codigoPaisOrigen
	 */
	public String getCodigoPaisOrigen() {
		return codigoPaisOrigen;
	}

	/**
	 * @param codigoPaisOrigen the codigoPaisOrigen to set
	 */
	public void setCodigoPaisOrigen(String codigoPaisOrigen) {
		this.codigoPaisOrigen = codigoPaisOrigen;
	}

	/**
	 * @return the materialArticulo
	 */
	public String getMaterialArticulo() {
		return materialArticulo;
	}

	/**
	 * @param materialArticulo the materialArticulo to set
	 */
	public void setMaterialArticulo(String materialArticulo) {
		this.materialArticulo = materialArticulo;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the codigoReferenciaExterna
	 */
	public String getCodigoReferenciaExterna() {
		return codigoReferenciaExterna;
	}

	/**
	 * @param codigoReferenciaExterna the codigoReferenciaExterna to set
	 */
	public void setCodigoReferenciaExterna(String codigoReferenciaExterna) {
		this.codigoReferenciaExterna = codigoReferenciaExterna;
	}

	/**
	 * @return the costoBruto
	 */
	public BigDecimal getCostoBruto() {
		return costoBruto;
	}

	/**
	 * @param costoBruto the costoBruto to set
	 */
	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}

	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}

	/**
	 * @return the aplicaIva
	 */
	public boolean getAplicaIva() {
		return aplicaIva;
	}

	/**
	 * @param aplicaIva the aplicaIva to set
	 */
	public void setAplicaIva(boolean aplicaIva) {
		this.aplicaIva = aplicaIva;
	}

	/**
	 * @return the aplicaIve
	 */
	public boolean getAplicaIve() {
		return aplicaIve;
	}

	/**
	 * @param aplicaIve the aplicaIve to set
	 */
	public void setAplicaIve(boolean aplicaIve) {
		this.aplicaIve = aplicaIve;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the articuloProveedorNovedadDTO
	 */
	public ArticuloProveedorNovedadDTO getArticuloProveedorNovedadDTO() {
		return articuloProveedorNovedadDTO;
	}

	/**
	 * @param articuloProveedorNovedadDTO the articuloProveedorNovedadDTO to set
	 */
	public void setArticuloProveedorNovedadDTO(ArticuloProveedorNovedadDTO articuloProveedorNovedadDTO) {
		this.articuloProveedorNovedadDTO = articuloProveedorNovedadDTO;
	}

	/**
	 * @return the vistaProveedorDTO
	 */
	public VistaProveedorDTO getVistaProveedorDTO() {
		return vistaProveedorDTO;
	}

	/**
	 * @param vistaProveedorDTO the vistaProveedorDTO to set
	 */
	public void setVistaProveedorDTO(VistaProveedorDTO vistaProveedorDTO) {
		this.vistaProveedorDTO = vistaProveedorDTO;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	public Long getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(Long codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public BigDecimal getTasaCambio() {
		return tasaCambio;
	}

	public void setTasaCambio(BigDecimal tasaCambio) {
		this.tasaCambio = tasaCambio;
	}

	/**
	 * @return the codigoAreaTrabajoDestino
	 */
	public Integer getCodigoAreaTrabajoDestino() {
		return codigoAreaTrabajoDestino;
	}

	/**
	 * @param codigoAreaTrabajoDestino the codigoAreaTrabajoDestino to set
	 */
	public void setCodigoAreaTrabajoDestino(Integer codigoAreaTrabajoDestino) {
		this.codigoAreaTrabajoDestino = codigoAreaTrabajoDestino;
	}

	/**
	 * @return the codigoAreaTrabajoPedido
	 */
	public Integer getCodigoAreaTrabajoPedido() {
		return codigoAreaTrabajoPedido;
	}

	/**
	 * @param codigoAreaTrabajoPedido the codigoAreaTrabajoPedido to set
	 */
	public void setCodigoAreaTrabajoPedido(Integer codigoAreaTrabajoPedido) {
		this.codigoAreaTrabajoPedido = codigoAreaTrabajoPedido;
	}

	/**
	 * @return the noResolverCaso4
	 */
	public boolean getNoResolverCaso4() {
		return noResolverCaso4;
	}

	/**
	 * @param noResolverCaso4 the noResolverCaso4 to set
	 */
	public void setNoResolverCaso4(boolean noResolverCaso4) {
		this.noResolverCaso4 = noResolverCaso4;
	}

	/**
	 * @return the accessItemId
	 */
	public String getAccessItemId() {
		return accessItemId;
	}

	/**
	 * @param accessItemId the accessItemId to set
	 */
	public void setAccessItemId(String accessItemId) {
		this.accessItemId = accessItemId;
	}

	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/**
	 * @return the codigoCatalogoUnidadManejo
	 */
	public String getCodigoCatalogoUnidadManejo() {
		return codigoCatalogoUnidadManejo;
	}

	/**
	 * @param codigoCatalogoUnidadManejo the codigoCatalogoUnidadManejo to set
	 */
	public void setCodigoCatalogoUnidadManejo(String codigoCatalogoUnidadManejo) {
		this.codigoCatalogoUnidadManejo = codigoCatalogoUnidadManejo;
	}

	public Long getCodigoLugarCompra() {
		return codigoLugarCompra;
	}

	public void setCodigoLugarCompra(Long codigoLugarCompra) {
		this.codigoLugarCompra = codigoLugarCompra;
	}

	public String getCodigoClienteCompra() {
		return codigoClienteCompra;
	}

	public void setCodigoClienteCompra(String codigoClienteCompra) {
		this.codigoClienteCompra = codigoClienteCompra;
	}

	public String getCodigoClasificacionWRT() {
		return codigoClasificacionWRT;
	}

	public void setCodigoClasificacionWRT(String codigoClasificacionWRT) {
		this.codigoClasificacionWRT = codigoClasificacionWRT;
	}

	/**
	 * @return the validarCodigoBarras
	 */
	public boolean getValidarCodigoBarras() {
		return validarCodigoBarras;
	}

	/**
	 * @param validarCodigoBarras the validarCodigoBarras to set
	 */
	public void setValidarCodigoBarras(boolean validarCodigoBarras) {
		this.validarCodigoBarras = validarCodigoBarras;
	}

	/**
	 * @return the codigosLineasComerciales
	 */
	public ArrayList<Long> getCodigosLineasComerciales() {
		return codigosLineasComerciales;
	}

	/**
	 * @param codigosLineasComerciales the codigosLineasComerciales to set
	 */
	public void setCodigosLineasComerciales(ArrayList<Long> codigosLineasComerciales) {
		this.codigosLineasComerciales = codigosLineasComerciales;
	}

	public Long getCodigoClienteImportacion() {
		return codigoClienteImportacion;
	}

	public void setCodigoClienteImportacion(Long codigoClienteImportacion) {
		this.codigoClienteImportacion = codigoClienteImportacion;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public Boolean getEsCambioPrioridad() {
		return esCambioPrioridad;
	}

	public void setEsCambioPrioridad(Boolean esCambioPrioridad) {
		this.esCambioPrioridad = esCambioPrioridad;
	}
	
	
}
