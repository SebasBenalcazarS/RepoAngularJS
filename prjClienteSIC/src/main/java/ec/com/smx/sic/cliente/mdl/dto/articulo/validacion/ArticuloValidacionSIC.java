package ec.com.smx.sic.cliente.mdl.dto.articulo.validacion;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SCARTTVALDATART")
public class ArticuloValidacionSIC {	
	
	@EmbeddedId
	private ArticuloValidacionSICID id = new ArticuloValidacionSICID();
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String codigoBarras;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String codigoArticulo;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String codigoClasificacion;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String codigoSubclasificacion;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String claseArticulo;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double pvp;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double precioBase;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String estadoArticulo;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String codigoEstado;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String ean14UM1;
		
	@Column(insertable =  true, updatable = true, nullable =  false)
	private Integer cantidadUM1;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private Integer codUniEmpUM1;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String valUniEmpUM1;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String uniEmpUM1;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double descDocUM1;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String ean14UM2;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Integer cantidadUM2;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Integer codUniEmpUM2;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String valUniEmpUM2;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String uniEmpUM2;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double descDocUM2;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String ean14UM3;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Integer cantidadUM3;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Integer codUniEmpUM3;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String valUniEmpUM3;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String uniEmpUM3;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double descDocUM3;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String ean14UM4;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Integer cantidadUM4;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Integer codUniEmpUM4;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String valUniEmpUM4;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String uniEmpUM4;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double descDocUM4;
	
	/* INFORMACION DE PROVEEDOR*/
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String codigoProveedor;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private String estadoArticuloProveedor;
	
	@Column(insertable =  true, updatable = true, nullable =  false)
	private Double costoBruto;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String referenciaProveedor;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String referenciaInterna;
	
	/* INFORMACION DE DESCUENTOS*/
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcDes1;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcDes2;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcDes3;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcDes4;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcExePro;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcdesProm;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcdesProm1;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcdesProm2;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcdesProm3;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcdesProm4;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double porcExeProm;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private Double descDocProm;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String estadoIntegracion;
	
	@Column(insertable =  true, updatable = true, nullable =  true)
	private String observacion;

	//TODO
	//=============================================================================
	//		METODOS DE ACCESO - GETTERS Y SETTERS
	//=============================================================================
		
	public ArticuloValidacionSICID getId() {
		return id;
	}

	public void setId(ArticuloValidacionSICID id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public String getCodigoSubclasificacion() {
		return codigoSubclasificacion;
	}

	public void setCodigoSubclasificacion(String codigoSubclasificacion) {
		this.codigoSubclasificacion = codigoSubclasificacion;
	}

	public String getClaseArticulo() {
		return claseArticulo;
	}

	public void setClaseArticulo(String claseArticulo) {
		this.claseArticulo = claseArticulo;
	}

	public Double getPvp() {
		return pvp;
	}

	public void setPvp(Double pvp) {
		this.pvp = pvp;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}

	public String getEstadoArticulo() {
		return estadoArticulo;
	}

	public void setEstadoArticulo(String estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getEan14UM1() {
		return ean14UM1;
	}

	public void setEan14UM1(String ean14um1) {
		ean14UM1 = ean14um1;
	}

	public Integer getCantidadUM1() {
		return cantidadUM1;
	}

	public void setCantidadUM1(Integer cantidadUM1) {
		this.cantidadUM1 = cantidadUM1;
	}

	public Integer getCodUniEmpUM1() {
		return codUniEmpUM1;
	}

	public void setCodUniEmpUM1(Integer codUniEmpUM1) {
		this.codUniEmpUM1 = codUniEmpUM1;
	}

	public String getValUniEmpUM1() {
		return valUniEmpUM1;
	}

	public void setValUniEmpUM1(String valUniEmpUM1) {
		this.valUniEmpUM1 = valUniEmpUM1;
	}

	public String getUniEmpUM1() {
		return uniEmpUM1;
	}

	public void setUniEmpUM1(String uniEmpUM1) {
		this.uniEmpUM1 = uniEmpUM1;
	}

	public Double getDescDocUM1() {
		return descDocUM1;
	}

	public void setDescDocUM1(Double descDocUM1) {
		this.descDocUM1 = descDocUM1;
	}

	public String getEan14UM2() {
		return ean14UM2;
	}

	public void setEan14UM2(String ean14um2) {
		ean14UM2 = ean14um2;
	}

	public Integer getCantidadUM2() {
		return cantidadUM2;
	}

	public void setCantidadUM2(Integer cantidadUM2) {
		this.cantidadUM2 = cantidadUM2;
	}

	public Integer getCodUniEmpUM2() {
		return codUniEmpUM2;
	}

	public void setCodUniEmpUM2(Integer codUniEmpUM2) {
		this.codUniEmpUM2 = codUniEmpUM2;
	}

	public String getValUniEmpUM2() {
		return valUniEmpUM2;
	}

	public void setValUniEmpUM2(String valUniEmpUM2) {
		this.valUniEmpUM2 = valUniEmpUM2;
	}

	public String getUniEmpUM2() {
		return uniEmpUM2;
	}

	public void setUniEmpUM2(String uniEmpUM2) {
		this.uniEmpUM2 = uniEmpUM2;
	}

	public Double getDescDocUM2() {
		return descDocUM2;
	}

	public void setDescDocUM2(Double descDocUM2) {
		this.descDocUM2 = descDocUM2;
	}

	public String getEan14UM3() {
		return ean14UM3;
	}

	public void setEan14UM3(String ean14um3) {
		ean14UM3 = ean14um3;
	}

	public Integer getCantidadUM3() {
		return cantidadUM3;
	}

	public void setCantidadUM3(Integer cantidadUM3) {
		this.cantidadUM3 = cantidadUM3;
	}

	public Integer getCodUniEmpUM3() {
		return codUniEmpUM3;
	}

	public void setCodUniEmpUM3(Integer codUniEmpUM3) {
		this.codUniEmpUM3 = codUniEmpUM3;
	}

	public String getValUniEmpUM3() {
		return valUniEmpUM3;
	}

	public void setValUniEmpUM3(String valUniEmpUM3) {
		this.valUniEmpUM3 = valUniEmpUM3;
	}

	public String getUniEmpUM3() {
		return uniEmpUM3;
	}

	public void setUniEmpUM3(String uniEmpUM3) {
		this.uniEmpUM3 = uniEmpUM3;
	}

	public Double getDescDocUM3() {
		return descDocUM3;
	}

	public void setDescDocUM3(Double descDocUM3) {
		this.descDocUM3 = descDocUM3;
	}

	public String getEan14UM4() {
		return ean14UM4;
	}

	public void setEan14UM4(String ean14um4) {
		ean14UM4 = ean14um4;
	}

	public Integer getCantidadUM4() {
		return cantidadUM4;
	}

	public void setCantidadUM4(Integer cantidadUM4) {
		this.cantidadUM4 = cantidadUM4;
	}

	public Integer getCodUniEmpUM4() {
		return codUniEmpUM4;
	}

	public void setCodUniEmpUM4(Integer codUniEmpUM4) {
		this.codUniEmpUM4 = codUniEmpUM4;
	}

	public String getValUniEmpUM4() {
		return valUniEmpUM4;
	}

	public void setValUniEmpUM4(String valUniEmpUM4) {
		this.valUniEmpUM4 = valUniEmpUM4;
	}

	public String getUniEmpUM4() {
		return uniEmpUM4;
	}

	public void setUniEmpUM4(String uniEmpUM4) {
		this.uniEmpUM4 = uniEmpUM4;
	}

	public Double getDescDocUM4() {
		return descDocUM4;
	}

	public void setDescDocUM4(Double descDocUM4) {
		this.descDocUM4 = descDocUM4;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getEstadoArticuloProveedor() {
		return estadoArticuloProveedor;
	}

	public void setEstadoArticuloProveedor(String estadoArticuloProveedor) {
		this.estadoArticuloProveedor = estadoArticuloProveedor;
	}

	public Double getCostoBruto() {
		return costoBruto;
	}

	public void setCostoBruto(Double costoBruto) {
		this.costoBruto = costoBruto;
	}

	public String getReferenciaProveedor() {
		return referenciaProveedor;
	}

	public void setReferenciaProveedor(String referenciaProveedor) {
		this.referenciaProveedor = referenciaProveedor;
	}

	public String getReferenciaInterna() {
		return referenciaInterna;
	}

	public void setReferenciaInterna(String referenciaInterna) {
		this.referenciaInterna = referenciaInterna;
	}

	public Double getPorcDes1() {
		return porcDes1;
	}

	public void setPorcDes1(Double porcDes1) {
		this.porcDes1 = porcDes1;
	}

	public Double getPorcDes2() {
		return porcDes2;
	}

	public void setPorcDes2(Double porcDes2) {
		this.porcDes2 = porcDes2;
	}

	public Double getPorcDes3() {
		return porcDes3;
	}

	public void setPorcDes3(Double porcDes3) {
		this.porcDes3 = porcDes3;
	}

	public Double getPorcDes4() {
		return porcDes4;
	}

	public void setPorcDes4(Double porcDes4) {
		this.porcDes4 = porcDes4;
	}

	public Double getPorcExePro() {
		return porcExePro;
	}

	public void setPorcExePro(Double porcExePro) {
		this.porcExePro = porcExePro;
	}

	public Double getPorcdesProm() {
		return porcdesProm;
	}

	public void setPorcdesProm(Double porcdesProm) {
		this.porcdesProm = porcdesProm;
	}

	public Double getPorcdesProm1() {
		return porcdesProm1;
	}

	public void setPorcdesProm1(Double porcdesProm1) {
		this.porcdesProm1 = porcdesProm1;
	}

	public Double getPorcdesProm2() {
		return porcdesProm2;
	}

	public void setPorcdesProm2(Double porcdesProm2) {
		this.porcdesProm2 = porcdesProm2;
	}

	public Double getPorcdesProm3() {
		return porcdesProm3;
	}

	public void setPorcdesProm3(Double porcdesProm3) {
		this.porcdesProm3 = porcdesProm3;
	}

	public Double getPorcdesProm4() {
		return porcdesProm4;
	}

	public void setPorcdesProm4(Double porcdesProm4) {
		this.porcdesProm4 = porcdesProm4;
	}

	public Double getPorcExeProm() {
		return porcExeProm;
	}

	public void setPorcExeProm(Double porcExeProm) {
		this.porcExeProm = porcExeProm;
	}

	public Double getDescDocProm() {
		return descDocProm;
	}

	public void setDescDocProm(Double descDocProm) {
		this.descDocProm = descDocProm;
	}

	public String getEstadoIntegracion() {
		return estadoIntegracion;
	}

	public void setEstadoIntegracion(String estadoIntegracion) {
		this.estadoIntegracion = estadoIntegracion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}