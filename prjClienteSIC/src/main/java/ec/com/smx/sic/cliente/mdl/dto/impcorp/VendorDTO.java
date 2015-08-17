
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.VendorID;




/**
 * Entidad Proveedor
 *
 * @author kruger
 * @author walvarez
 */
@SuppressWarnings("serial")
public class VendorDTO extends AuditoriaBaseDTO<VendorID>{

	/**
	 * nombre
	 */
	private String name ;

	/**
	 * direccion1
	 */
	private String address1 ;

	/**
	 * direccion2
	 */
	private String address2 ;

	/**
	 * ciudad
	 */
	private String city ;

	/**
	 * estado
	 */
	private String state ;

	

	/**
	 * ZIP
	 */
	private String zip ;

	

	/**
	 * pais
	 */
	private String country ;

	/**
	 * telefono
	 */
	private String telephone ;

	/**
	 * FAX
	 */
	private String fax ;

	/**
	 * contacto1
	 */
	private String contact1 ;

	/**
	 * contacto2
	 */
	private String contact2 ;

	/**
	 * justo
	 */
	private String fair ;

	/**
	 * representantes
	 */
	private String represen ;

	/**
	 * mostrar agregar
	 */
	private String showadd ;

	/**
	 * mostrar ciudad
	 */
	private String showcity ;

	/**
	 * mostrar telefono
	 */
	private String showtel ;

	/**
	 * mostrar fax
	 */
	private String showfax ;
	
	/**
	 * nombre sig
	 */
	private String follnam ;

	/**
	 * telefono sig
	 */
	private String folltel ;

	/**
	 * fax sig
	 */
	private String follfax ;

	/**
	 * descuento
	 */
	private String discount ;

	/**
	 * pago term
	 */
	private String payterm ;

	/**
	 * FRGTERM
	 */
	private Integer frgterm ;

	/**
	 * CORREO
	 */
	private String email ;

	/**
	 * UPC
	 */
	private String upc ;

	/**
	 * OTRO TERM
	 */
	private String otherterm ;

	/**
	 * BANCO
	 */
	private String bank ;

	/**
	 * RAMA
	 */
	private String branch ;

	/**
	 * SWIFT
	 */
	private String swift ;

	/**
	 * BLZ
	 */
	private String blz ;

	/**
	 * ABA
	 */
	private String aba ;

	/**
	 * ABI
	 */
	private String abi ;

	/**
	 * CAB
	 */
	private String cab ;

	/**
	 * CUENTA
	 */
	private String account ;

	/**
	 * COMENTARIO
	 */
	private String comment ;
	
	private String replicationStatus;
	
	private String estado;
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

	/**
	 * Retorna valor de propiedad <code>name</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>name</code>
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>name</code>.
	 * @param name1 
	 *		El valor a establecer para la propiedad <code>name</code>.
	 */
	public void setName( String name1 ){
		this.name=name1;
	}

		

	/**
	 * Retorna valor de propiedad <code>address1</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>address1</code>
	 */
	public String getAddress1(){
		return this.address1;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>address1</code>.
	 * @param address11 
	 *		El valor a establecer para la propiedad <code>address1</code>.
	 */
	public void setAddress1( String address11 ){
		this.address1=address11;
	}

	/**
	 * Retorna valor de propiedad <code>address2</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>address2</code>
	 */
	public String getAddress2(){
		return this.address2;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>address2</code>.
	 * @param address21 
	 *		El valor a establecer para la propiedad <code>address2</code>.
	 */
	public void setAddress2( String address21 ){
		this.address2=address21;
	}

		

	/**
	 * Retorna valor de propiedad <code>city</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>city</code>
	 */
	public String getCity(){
		return this.city;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>city</code>.
	 * @param city1 
	 *		El valor a establecer para la propiedad <code>city</code>.
	 */
	public void setCity( String city1 ){
		this.city=city1;
	}

		

	/**
	 * Retorna valor de propiedad <code>state</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>state</code>
	 */
	public String getState(){
		return this.state;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>state</code>.
	 * @param state1 
	 *		El valor a establecer para la propiedad <code>state</code>.
	 */
	public void setState( String state1 ){
		this.state=state1;
	}

		

	/**
	 * Retorna valor de propiedad <code>zip</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>zip</code>
	 */
	public String getZip(){
		return this.zip;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>zip</code>.
	 * @param zip1 
	 *		El valor a establecer para la propiedad <code>zip</code>.
	 */
	public void setZip( String zip1 ){
		this.zip=zip1;
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
	 * Retorna valor de propiedad <code>telephone</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>telephone</code>
	 */
	public String getTelephone(){
		return this.telephone;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>telephone</code>.
	 * @param telephone1 
	 *		El valor a establecer para la propiedad <code>telephone</code>.
	 */
	public void setTelephone( String telephone1 ){
		this.telephone=telephone1;
	}

		

	/**
	 * Retorna valor de propiedad <code>fax</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fax</code>
	 */
	public String getFax(){
		return this.fax;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fax</code>.
	 * @param fax1 
	 *		El valor a establecer para la propiedad <code>fax</code>.
	 */
	public void setFax( String fax1 ){
		this.fax=fax1;
	}

		

	/**
	 * Retorna valor de propiedad <code>contact1</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>contact1</code>
	 */
	public String getContact1(){
		return this.contact1;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>contact1</code>.
	 * @param contact11 
	 *		El valor a establecer para la propiedad <code>contact1</code>.
	 */
	public void setContact1( String contact11 ){
		this.contact1=contact11;
	}

		

	/**
	 * Retorna valor de propiedad <code>contact2</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>contact2</code>
	 */
	public String getContact2(){
		return this.contact2;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>contact2</code>.
	 * @param contact21 
	 *		El valor a establecer para la propiedad <code>contact2</code>.
	 */
	public void setContact2( String contact21 ){
		this.contact2=contact21;
	}

		

	/**
	 * Retorna valor de propiedad <code>fair</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fair</code>
	 */
	public String getFair(){
		return this.fair;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fair</code>.
	 * @param fair1 
	 *		El valor a establecer para la propiedad <code>fair</code>.
	 */
	public void setFair( String fair1 ){
		this.fair=fair1;
	}

		

	/**
	 * Retorna valor de propiedad <code>represen</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>represen</code>
	 */
	public String getRepresen(){
		return this.represen;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>represen</code>.
	 * @param represen1 
	 *		El valor a establecer para la propiedad <code>represen</code>.
	 */
	public void setRepresen( String represen1 ){
		this.represen=represen1;
	}

		

	/**
	 * Retorna valor de propiedad <code>showadd</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>showadd</code>
	 */
	public String getShowadd(){
		return this.showadd;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>showadd</code>.
	 * @param showadd1 
	 *		El valor a establecer para la propiedad <code>showadd</code>.
	 */
	public void setShowadd( String showadd1 ){
		this.showadd=showadd1;
	}

		

	/**
	 * Retorna valor de propiedad <code>showcity</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>showcity</code>
	 */
	public String getShowcity(){
		return this.showcity;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>showcity</code>.
	 * @param showcity1 
	 *		El valor a establecer para la propiedad <code>showcity</code>.
	 */
	public void setShowcity( String showcity1 ){
		this.showcity=showcity1;
	}

		

	/**
	 * Retorna valor de propiedad <code>showtel</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>showtel</code>
	 */
	public String getShowtel(){
		return this.showtel;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>showtel</code>.
	 * @param showtel1 
	 *		El valor a establecer para la propiedad <code>showtel</code>.
	 */
	public void setShowtel( String showtel1 ){
		this.showtel=showtel1;
	}

		

	/**
	 * Retorna valor de propiedad <code>showfax</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>showfax</code>
	 */
	public String getShowfax(){
		return this.showfax;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>showfax</code>.
	 * @param showfax1 
	 *		El valor a establecer para la propiedad <code>showfax</code>.
	 */
	public void setShowfax( String showfax1 ){
		this.showfax=showfax1;
	}

		

	/**
	 * Retorna valor de propiedad <code>follnam</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>follnam</code>
	 */
	public String getFollnam(){
		return this.follnam;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>follnam</code>.
	 * @param follnam1 
	 *		El valor a establecer para la propiedad <code>follnam</code>.
	 */
	public void setFollnam( String follnam1 ){
		this.follnam=follnam1;
	}

		

	/**
	 * Retorna valor de propiedad <code>folltel</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>folltel</code>
	 */
	public String getFolltel(){
		return this.folltel;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>folltel</code>.
	 * @param folltel1 
	 *		El valor a establecer para la propiedad <code>folltel</code>.
	 */
	public void setFolltel( String folltel1 ){
		this.folltel=folltel1;
	}

		

	/**
	 * Retorna valor de propiedad <code>follfax</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>follfax</code>
	 */
	public String getFollfax(){
		return this.follfax;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>follfax</code>.
	 * @param follfax1 
	 *		El valor a establecer para la propiedad <code>follfax</code>.
	 */
	public void setFollfax( String follfax1 ){
		this.follfax=follfax1;
	}

		

	/**
	 * Retorna valor de propiedad <code>discount</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>discount</code>
	 */
	public String getDiscount(){
		return this.discount;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>discount</code>.
	 * @param discount1 
	 *		El valor a establecer para la propiedad <code>discount</code>.
	 */
	public void setDiscount( String discount1 ){
		this.discount=discount1;
	}

		

	/**
	 * Retorna valor de propiedad <code>payterm</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>payterm</code>
	 */
	public String getPayterm(){
		return this.payterm;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>payterm</code>.
	 * @param payterm1 
	 *		El valor a establecer para la propiedad <code>payterm</code>.
	 */
	public void setPayterm( String payterm1 ){
		this.payterm=payterm1;
	}

		

	/**
	 * Retorna valor de propiedad <code>frgterm</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>frgterm</code>
	 */
	public Integer getFrgterm(){
		return this.frgterm;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>frgterm</code>.
	 * @param frgterm1 
	 *		El valor a establecer para la propiedad <code>frgterm</code>.
	 */
	public void setFrgterm( Integer frgterm1 ){
		this.frgterm=frgterm1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>email</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>email</code>
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>email</code>.
	 * @param email1 
	 *		El valor a establecer para la propiedad <code>email</code>.
	 */
	public void setEmail( String email1 ){
		this.email=email1;
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
	 * Retorna valor de propiedad <code>otherterm</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>otherterm</code>
	 */
	public String getOtherterm(){
		return this.otherterm;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>otherterm</code>.
	 * @param otherterm1 
	 *		El valor a establecer para la propiedad <code>otherterm</code>.
	 */
	public void setOtherterm( String otherterm1 ){
		this.otherterm=otherterm1;
	}

		

	/**
	 * Retorna valor de propiedad <code>bank</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>bank</code>
	 */
	public String getBank(){
		return this.bank;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>bank</code>.
	 * @param bank1 
	 *		El valor a establecer para la propiedad <code>bank</code>.
	 */
	public void setBank( String bank1 ){
		this.bank=bank1;
	}

		

	/**
	 * Retorna valor de propiedad <code>branch</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>branch</code>
	 */
	public String getBranch(){
		return this.branch;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>branch</code>.
	 * @param branch1 
	 *		El valor a establecer para la propiedad <code>branch</code>.
	 */
	public void setBranch( String branch1 ){
		this.branch=branch1;
	}

		

	/**
	 * Retorna valor de propiedad <code>swift</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>swift</code>
	 */
	public String getSwift(){
		return this.swift;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>swift</code>.
	 * @param swift1 
	 *		El valor a establecer para la propiedad <code>swift</code>.
	 */
	public void setSwift( String swift1 ){
		this.swift=swift1;
	}

		

	/**
	 * Retorna valor de propiedad <code>blz</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>blz</code>
	 */
	public String getBlz(){
		return this.blz;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>blz</code>.
	 * @param blz1 
	 *		El valor a establecer para la propiedad <code>blz</code>.
	 */
	public void setBlz( String blz1 ){
		this.blz=blz1;
	}

		

	/**
	 * Retorna valor de propiedad <code>aba</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>aba</code>
	 */
	public String getAba(){
		return this.aba;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>aba</code>.
	 * @param aba1 
	 *		El valor a establecer para la propiedad <code>aba</code>.
	 */
	public void setAba( String aba1 ){
		this.aba=aba1;
	}

		

	/**
	 * Retorna valor de propiedad <code>abi</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>abi</code>
	 */
	public String getAbi(){
		return this.abi;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>abi</code>.
	 * @param abi1 
	 *		El valor a establecer para la propiedad <code>abi</code>.
	 */
	public void setAbi( String abi1 ){
		this.abi=abi1;
	}

		

	/**
	 * Retorna valor de propiedad <code>cab</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cab</code>
	 */
	public String getCab(){
		return this.cab;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cab</code>.
	 * @param cab1 
	 *		El valor a establecer para la propiedad <code>cab</code>.
	 */
	public void setCab( String cab1 ){
		this.cab=cab1;
	}

		

	/**
	 * Retorna valor de propiedad <code>account</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>account</code>
	 */
	public String getAccount(){
		return this.account;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>account</code>.
	 * @param account1 
	 *		El valor a establecer para la propiedad <code>account</code>.
	 */
	public void setAccount( String account1 ){
		this.account=account1;
	}

		

	/**
	 * Retorna valor de propiedad <code>comment</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>comment</code>
	 */
	public String getComment(){
		return this.comment;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>comment</code>.
	 * @param comment1 
	 *		El valor a establecer para la propiedad <code>comment</code>.
	 */
	public void setComment( String comment1 ){
		this.comment=comment1;
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
}

