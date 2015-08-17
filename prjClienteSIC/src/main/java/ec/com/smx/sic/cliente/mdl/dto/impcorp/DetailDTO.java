
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import org.apache.commons.lang.StringUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.DetailID;





/**
 * Entidad Detalle
 *
 * @author kruger
 * @author walvarez
 */
@SuppressWarnings("serial")
public class DetailDTO extends AuditoriaBaseDTO<DetailID>{
	
	private Integer codigoCompania;
	
	private String codigoArticulo;
		
	private String codigoProveedor;
	
	/**
	 * numero cons
	 *
	 */
	private String consnumber ;
	/**
	 * parte
	 */
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	private String part ;

	/**
	 * descripcion
	 */
	private String descrip ;

	/**
	 * UPC
	 */
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	private String upc ;

	/**
	 * qty
	 */
	private Integer qty ;

	/**
	 * unidad
	 */
	private String unit ;

	/**
	 * precio
	 */
	private java.math.BigDecimal price ;

	/**
	 * clase
	 */
	private String clazz ;

	/**
	 * AMTDIS
	 */
	private java.math.BigDecimal amtdis ;

	/**
	 * Es grupo
	 */
	private String isgroup ;

	/**
	 * interior
	 */
	private Integer inner ;

	/**
	 * pack
	 */
	private Integer pack ;

	/**
	 * cubo
	 */
	private java.math.BigDecimal cube ;

	/**
	 * pais
	 */
	private String country ;

	/**
	 * material
	 */
	private String material ;

	/**
	 * marca
	 */
	private String brand ;

	/**
	 * EAN14
	 */
	private String ean14 ;

	/**
	 * gpeso
	 */
	private java.math.BigDecimal gweight ;

	/**
	 * n peso
	 */
	private java.math.BigDecimal nweight ;

	/**
	 * unidad
	 */
	private String unidad ;
	
	private String replicationStatus;
	
	private String estado;
	
	private String coleccion;//Aumentado cambio 2013-03-20
//	/**
//	 *Campo no persistente para setear la compania 
//	 */
//	private String npCompanyId;
	/**
	 * Especifica el usuario que realiza el registro.
	 */
	@RegisterUserIdField
	private String usuarioRegistro ;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	private java.util.Date fechaRegistro ;


	/**
	 * Id del usuario que realizó la última actualización
	 */
	@LastModifierUserIdField
	private String usuarioModificacion ;


	/**
	 * Fecha en la que se realizó la última actualización
	 */
	@LastModificationDateField
	private java.util.Date fechaModificacion ;
	
	//Relacion del Detail con el articulo
	private ArticuloProveedorDTO articuloProveedorDTO;

	/**
	 * @return the consnumber
	 */
	public String getConsnumber() {
		return consnumber;
	}

	/**
	 * @param consnumber the consnumber to set
	 */
	public void setConsnumber(String consnumber) {
		this.consnumber = consnumber;
	}

		

	/**
	 * Retorna valor de propiedad <code>part</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>part</code>
	 */
	public String getPart(){
		return this.part;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>part</code>.
	 * @param part1 
	 *		El valor a establecer para la propiedad <code>part</code>.
	 */
	public void setPart( String part1 ){
		this.part=part1;
	}

		

	/**
	 * Retorna valor de propiedad <code>descrip</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>descrip</code>
	 */
	public String getDescrip(){
		return this.descrip;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descrip</code>.
	 * @param descrip1 
	 *		El valor a establecer para la propiedad <code>descrip</code>.
	 */
	public void setDescrip( String descrip1 ){
		if(this.descrip==null){
			if(!StringUtils.isEmpty(descrip1)){
				char[] cadena=descrip1.toCharArray();
				for(int i=0;i<cadena.length;i++){
					if((Character.getType(cadena[i])!=Character.OTHER_SYMBOL)){
						if(this.descrip==null){
							this.descrip = String.valueOf(cadena[i]);
						}else{
							this.descrip += cadena[i];										
						}
					}
				}
			}else{
			this.descrip="";	
			}
		}else{
			this.descrip=descrip1;
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>upc</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>upc</code>
	 */
	public String getUpc(){
		return this.upc;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>upc</code>.
	 * @param upc1 
	 *		El valor a establecer para la propiedad <code>upc</code>.
	 */
	public void setUpc( String upc1 ){
		this.upc=upc1;
	}

		

	/**
	 * Retorna valor de propiedad <code>qty</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>qty</code>
	 */
	public Integer getQty(){
		return this.qty;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>qty</code>.
	 * @param qty1 
	 *		El valor a establecer para la propiedad <code>qty</code>.
	 */
	public void setQty( Integer qty1 ){
		this.qty=qty1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>unit</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>unit</code>
	 */
	public String getUnit(){
		return this.unit;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>unit</code>.
	 * @param unit1 
	 *		El valor a establecer para la propiedad <code>unit</code>.
	 */
	public void setUnit( String unit1 ){
		this.unit=unit1;
	}

		

	/**
	 * Retorna valor de propiedad <code>price</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>price</code>
	 */
	public java.math.BigDecimal getPrice(){
		return this.price;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>price</code>.
	 * @param price1 
	 *		El valor a establecer para la propiedad <code>price</code>.
	 */
	public void setPrice( java.math.BigDecimal price1 ){
		this.price=price1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>class</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>class</code>
	 */
	public String getClazz(){
		return this.clazz;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>class</code>.
	 * @param class1 
	 *		El valor a establecer para la propiedad <code>class</code>.
	 */
	public void setClazz( String clazz ){
		this.clazz=clazz;
	}

		

	/**
	 * Retorna valor de propiedad <code>amtdis</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>amtdis</code>
	 */
	public java.math.BigDecimal getAmtdis(){
		return this.amtdis;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>amtdis</code>.
	 * @param amtdis1 
	 *		El valor a establecer para la propiedad <code>amtdis</code>.
	 */
	public void setAmtdis( java.math.BigDecimal amtdis1 ){
		this.amtdis=amtdis1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>isgroup</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>isgroup</code>
	 */
	public String getIsgroup(){
		return this.isgroup;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>isgroup</code>.
	 * @param isgroup1 
	 *		El valor a establecer para la propiedad <code>isgroup</code>.
	 */
	public void setIsgroup( String isgroup1 ){
		this.isgroup=isgroup1;
	}

		

	/**
	 * Retorna valor de propiedad <code>inner</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>inner</code>
	 */
	public Integer getInner(){
		return this.inner;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>inner</code>.
	 * @param inner1 
	 *		El valor a establecer para la propiedad <code>inner</code>.
	 */
	public void setInner( Integer inner1 ){
		this.inner=inner1;
	}

		

	/**
	 * Retorna valor de propiedad <code>pack</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>pack</code>
	 */
	public Integer getPack(){
		return this.pack;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>pack</code>.
	 * @param pack1 
	 *		El valor a establecer para la propiedad <code>pack</code>.
	 */
	public void setPack( Integer pack1 ){
		this.pack=pack1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>cube</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cube</code>
	 */
	public java.math.BigDecimal getCube(){
		return this.cube;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cube</code>.
	 * @param cube1 
	 *		El valor a establecer para la propiedad <code>cube</code>.
	 */
	public void setCube( java.math.BigDecimal cube1 ){
		this.cube=cube1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>country</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>country</code>
	 */
	public String getCountry(){
		return this.country;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>country</code>.
	 * @param country1 
	 *		El valor a establecer para la propiedad <code>country</code>.
	 */
	public void setCountry( String country1 ){
		this.country=country1;
	}

		

	/**
	 * Retorna valor de propiedad <code>material</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>material</code>
	 */
	public String getMaterial(){
		return this.material;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>material</code>.
	 * @param material1 
	 *		El valor a establecer para la propiedad <code>material</code>.
	 */
	public void setMaterial( String material1 ){
		if(this.material==null){
			if(!StringUtils.isEmpty(material1)){
				char[] cadena=material1.toCharArray();
				for(int i=0;i<cadena.length;i++){
					if((Character.getType(cadena[i])!=Character.OTHER_SYMBOL)){
						if(this.material==null){
							this.material = String.valueOf(cadena[i]);
						}else{
							this.material += cadena[i];										
						}
					}
				}
			}else{
				this.material="";
			}
		}else{
			this.material=material1;
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>brand</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>brand</code>
	 */
	public String getBrand(){
		return this.brand;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>brand</code>.
	 * @param brand1 
	 *		El valor a establecer para la propiedad <code>brand</code>.
	 */
	public void setBrand( String brand1 ){
		if(this.brand==null){
			if(!StringUtils.isEmpty(brand1)){
				char[] cadena=brand1.toCharArray();
				for(int i=0;i<cadena.length;i++){
					if((Character.getType(cadena[i])!=Character.OTHER_SYMBOL)){
						if(this.brand==null){
							this.brand = String.valueOf(cadena[i]);
						}else{
							this.brand += cadena[i];										
						}
					}
				}
			}else{
				this.brand="";
			}
		}else{
			this.brand=brand1;
		}
		
	}

		

	/**
	 * Retorna valor de propiedad <code>ean14</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>ean14</code>
	 */
	public String getEan14(){
		return this.ean14;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>ean14</code>.
	 * @param ean141 
	 *		El valor a establecer para la propiedad <code>ean14</code>.
	 */
	public void setEan14( String ean14 ){
		this.ean14=ean14;
	}

		

	/**
	 * Retorna valor de propiedad <code>gweight</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>gweight</code>
	 */
	public java.math.BigDecimal getGweight(){
		return this.gweight;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>gweight</code>.
	 * @param gweight1 
	 *		El valor a establecer para la propiedad <code>gweight</code>.
	 */
	public void setGweight( java.math.BigDecimal gweight1 ){
		this.gweight=gweight1;
	}

		

	/**
	 * Retorna valor de propiedad <code>nweight</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>nweight</code>
	 */
	public java.math.BigDecimal getNweight(){
		return this.nweight;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nweight</code>.
	 * @param nweight1 
	 *		El valor a establecer para la propiedad <code>nweight</code>.
	 */
	public void setNweight( java.math.BigDecimal nweight1 ){
		this.nweight=nweight1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>unidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>unidad</code>
	 */
	public String getUnidad(){
		return this.unidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>unidad</code>.
	 * @param unidad1 
	 *		El valor a establecer para la propiedad <code>unidad</code>.
	 */
	public void setUnidad( String unidad1 ){
		this.unidad=unidad1;
	}

	/**
	 * @return the usuarioRegistro
	 */
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the replicationStatus
	 */
	public String getReplicationStatus() {
		return replicationStatus;
	}

	/**
	 * @param replicationStatus the replicationStatus to set
	 */
	public void setReplicationStatus(String replicationStatus) {
		this.replicationStatus = replicationStatus;
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
	 * @return the coleccion
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * @param coleccion the coleccion to set
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	public void setArticuloProveedorDTO(ArticuloProveedorDTO articuloProveedorDTO) {
		this.articuloProveedorDTO = articuloProveedorDTO;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public ArticuloProveedorDTO getArticuloProveedorDTO() {
		return articuloProveedorDTO;
	}


}

