package ec.com.smx.sic.cliente.mdl.dto.impcorp;


import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.sic.cliente.common.Logeable;

@SuppressWarnings("serial")

public class OrderAbstract <T extends BaseID> extends AuditoriaBaseDTO<T>{
	
	/**
	 * Cons numero
	 */
	private String consnumber ;

	/**
	 * fecha
	 */
	private java.util.Date date ;

	/**
	 * cliente
	 */
	private String client ;

	/**
	 * proveedor
	 */
	private String vendor ;

	/**
	 * cantidad
	 */
	private java.math.BigDecimal amount ;

	/**
	 * facturar a
	 */
	private Integer billto ;

	/**
	 * buque
	 */
	private Integer shipto ;

	/**
	 * id buque
	 */
	private String shiptoid ;

	/**
	 * pagar
	 */
	private String payterm ;

	/**
	 * moneda
	 */
	private String currency ;

	/**
	 * tasa de
	 */
	private java.math.BigDecimal rate ;

	/**
	 * justo
	 */
	private String fair ;

	/**
	 * justo 2
	 */
	private String fair2 ;

	/**
	 * representar
	 */
	private String represen ;

	/**
	 * primera fecha
	 */
	private java.util.Date firstdate ;

	/**
	 * ultima fecha
	 */
	private java.util.Date lastdate ;

	/**
	 * periodo de pago
	 */
	private Integer buyterm ;

	/**
	 * otro perdiodo
	 */
	private String otherterm ;

	/**
	 * origen
	 */
	private Integer origin ;

	/**
	 * numero de buque
	 */
	private Integer shipnumber ;

	/**
	 * comprador
	 */
	private String buyer ;

	/**
	 * titulo
	 */
	private String title ;

	/**
	 * pais
	 */
	private String country ;

	/**
	 * articulos
	 */
	private Integer items ;

	/**
	 * cerrar
	 */
	private String close ;

	/**
	 * descarga
	 */
	private String download ;

	/**
	 * EC.
	 */
	private String ecuador ;

	/**
	 * typo de vol
	 */
	private Integer voltype ;

	/**
	 * navide�o
	 */
	private String navideno ;

	/**
	 * textil
	 */
	private String textil ;

	/**
	 * ceramica
	 */
	private String ceramica ;

	/**
	 * inen
	 */
	private String inen ;

	/**
	 * licencia
	 */
	private String license ;

	/**
	 * licencia wrt
	 */
	private String licensewrt ;
	
	/**
	 * campo que indica desde donde se origino la orden si desde WRT, FAV.
	 */			   
	private String originorder ;

	/**
	 * campo que indica desde donde se origino la orden si desde WRT, FAV.
	 */
	private String statusfav ;
	
	/**
	 * numero de caso generado para el sic
	 */
	private String numberCase;
	
	/**
	 * Estado que indica si el registro ya fue replicado o no.
	 */
	private String replicationStatus;
	
	/**
	 * Estado de los registros	ACT Activo,INA Inactivo
	 */
	private String estado;
	
	
	private VendorDTO vendorDTO;
	
	
	/**
	 *Campos no persistentes para setear nombres de campos respectivos 
	 */
	private String npClientName;
	private String npVendorName;
	private String npFair1Name;
	private String npFair2Name;
	private String npRepresentName;
	private String npShipDescription;
	private String npPaymentDescription;
	private String npCurrencyName;
	
	/**
	 *Campo no persistente para setear la compania 
	 */
	private String npCompanyId;
	
	
	private Boolean npExistVendorDTO;
	
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
	 * Retorna valor de propiedad <code>date</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>date</code>
	 */
	public java.util.Date getDate(){
		return this.date;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>date</code>.
	 * @param date1 
	 *		El valor a establecer para la propiedad <code>date</code>.
	 */
	public void setDate( java.util.Date date1 ){
		this.date=date1;
		
	}

		
	/**
	 * Retorna propiedad <code>date</code> como String
	 * @return 
	 * 	Retorna propiedad <code>date</code> como String
	 */
	public String getDateS() {
		return (this.date!=null)?ConverterUtil.getYMDDateFormat().format(this.date):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>date</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>date</code>.
	 */
	public void setDateS(String cadena) {
		try{
			this.date = (cadena!=null)?ConverterUtil.getYMDDateFormat().parse(cadena):null;
		}catch(Exception ex){
			Logeable.LOG_SICV2.info("mensaje info");
		}
	}	
			

	/**
	 * Retorna valor de propiedad <code>client</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>client</code>
	 */
	public String getClient(){
		return this.client;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>client</code>.
	 * @param client1 
	 *		El valor a establecer para la propiedad <code>client</code>.
	 */
	public void setClient( String client1 ){
		this.client=client1;
	}

		

	/**
	 * Retorna valor de propiedad <code>vendor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>vendor</code>
	 */
	public String getVendor(){
		return this.vendor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>vendor</code>.
	 * @param vendor1 
	 *		El valor a establecer para la propiedad <code>vendor</code>.
	 */
	public void setVendor( String vendor1 ){
		this.vendor=vendor1;
	}

		

	/**
	 * Retorna valor de propiedad <code>amount</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>amount</code>
	 */
	public java.math.BigDecimal getAmount(){
		return this.amount;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>amount</code>.
	 * @param amount1 
	 *		El valor a establecer para la propiedad <code>amount</code>.
	 */
	public void setAmount( java.math.BigDecimal amount1 ){
		this.amount=amount1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>billto</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>billto</code>
	 */
	public Integer getBillto(){
		return this.billto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>billto</code>.
	 * @param billto1 
	 *		El valor a establecer para la propiedad <code>billto</code>.
	 */
	public void setBillto( Integer billto1 ){
		this.billto=billto1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>shipto</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>shipto</code>
	 */
	public Integer getShipto(){
		return this.shipto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>shipto</code>.
	 * @param shipto1 
	 *		El valor a establecer para la propiedad <code>shipto</code>.
	 */
	public void setShipto( Integer shipto1 ){
		this.shipto=shipto1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>shiptoid</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>shiptoid</code>
	 */
	public String getShiptoid(){
		return this.shiptoid;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>shiptoid</code>.
	 * @param shiptoid1 
	 *		El valor a establecer para la propiedad <code>shiptoid</code>.
	 */
	public void setShiptoid( String shiptoid1 ){
		this.shiptoid=shiptoid1;
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
	 * Retorna valor de propiedad <code>currency</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>currency</code>
	 */
	public String getCurrency(){
		return this.currency;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>currency</code>.
	 * @param currency1 
	 *		El valor a establecer para la propiedad <code>currency</code>.
	 */
	public void setCurrency( String currency1 ){
		this.currency=currency1;
	}

		

	/**
	 * Retorna valor de propiedad <code>rate</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>rate</code>
	 */
	public java.math.BigDecimal getRate(){
		return this.rate;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>rate</code>.
	 * @param rate1 
	 *		El valor a establecer para la propiedad <code>rate</code>.
	 */
	public void setRate( java.math.BigDecimal rate1 ){
		this.rate=rate1;
		
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
	 * Retorna valor de propiedad <code>fair2</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fair2</code>
	 */
	public String getFair2(){
		return this.fair2;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fair2</code>.
	 * @param fair21 
	 *		El valor a establecer para la propiedad <code>fair2</code>.
	 */
	public void setFair2( String fair21 ){
		this.fair2=fair21;
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
	 * Retorna valor de propiedad <code>firstdate</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>firstdate</code>
	 */
	public java.util.Date getFirstdate(){
		return this.firstdate;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>firstdate</code>.
	 * @param firstdate1 
	 *		El valor a establecer para la propiedad <code>firstdate</code>.
	 */
	public void setFirstdate( java.util.Date firstdate1 ){
		this.firstdate=firstdate1;
		
	}

		
	/**
	 * Retorna propiedad <code>firstdate</code> como String
	 * @return 
	 * 	Retorna propiedad <code>firstdate</code> como String
	 */
	public String getFirstdateS() {
		return (this.firstdate!=null)?ConverterUtil.getYMDDateFormat().format(this.firstdate):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>firstdate</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>firstdate</code>.
	 */
	public void setFirstdateS(String cadena) {
		try{
			this.firstdate = (cadena!=null)?ConverterUtil.getYMDDateFormat().parse(cadena):null;
		}catch(Exception ex){
			Logeable.LOG_SICV2.info("mensaje info");
		}
	}	
			

	/**
	 * Retorna valor de propiedad <code>lastdate</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>lastdate</code>
	 */
	public java.util.Date getLastdate(){
		return this.lastdate;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>lastdate</code>.
	 * @param lastdate1 
	 *		El valor a establecer para la propiedad <code>lastdate</code>.
	 */
	public void setLastdate( java.util.Date lastdate1 ){
		this.lastdate=lastdate1;
		
	}

		
	/**
	 * Retorna propiedad <code>lastdate</code> como String
	 * @return 
	 * 	Retorna propiedad <code>lastdate</code> como String
	 */
	public String getLastdateS() {
		return (this.lastdate!=null)?ConverterUtil.getYMDDateFormat().format(this.lastdate):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>lastdate</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>lastdate</code>.
	 */
	public void setLastdateS(String cadena) {
		try{
			this.lastdate = (cadena!=null)?ConverterUtil.getYMDDateFormat().parse(cadena):null;
		}catch(Exception ex){
			Logeable.LOG_SICV2.info("mensaje info");}
	}	
			

	/**
	 * Retorna valor de propiedad <code>buyterm</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>buyterm</code>
	 */
	public Integer getBuyterm(){
		return this.buyterm;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>buyterm</code>.
	 * @param buyterm1 
	 *		El valor a establecer para la propiedad <code>buyterm</code>.
	 */
	public void setBuyterm( Integer buyterm1 ){
		this.buyterm=buyterm1;
		
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
	 * Retorna valor de propiedad <code>origin</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>origin</code>
	 */
	public Integer getOrigin(){
		return this.origin;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>origin</code>.
	 * @param origin1 
	 *		El valor a establecer para la propiedad <code>origin</code>.
	 */
	public void setOrigin( Integer origin1 ){
		this.origin=origin1;
	}

		

	/**
	 * Retorna valor de propiedad <code>shipnumber</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>shipnumber</code>
	 */
	public Integer getShipnumber(){
		return this.shipnumber;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>shipnumber</code>.
	 * @param shipnumber1 
	 *		El valor a establecer para la propiedad <code>shipnumber</code>.
	 */
	public void setShipnumber( Integer shipnumber1 ){
		this.shipnumber=shipnumber1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>buyer</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>buyer</code>
	 */
	public String getBuyer(){
		return this.buyer;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>buyer</code>.
	 * @param buyer1 
	 *		El valor a establecer para la propiedad <code>buyer</code>.
	 */
	public void setBuyer( String buyer1 ){
		this.buyer=buyer1;
	}

		

	/**
	 * Retorna valor de propiedad <code>title</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>title</code>
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>title</code>.
	 * @param title1 
	 *		El valor a establecer para la propiedad <code>title</code>.
	 */
	public void setTitle( String title1 ){
		this.title=title1;
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
	 * Retorna valor de propiedad <code>items</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>items</code>
	 */
	public Integer getItems(){
		return this.items;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>items</code>.
	 * @param items1 
	 *		El valor a establecer para la propiedad <code>items</code>.
	 */
	public void setItems( Integer items1 ){
		this.items=items1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>close</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>close</code>
	 */
	public String getClose(){
		return this.close;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>close</code>.
	 * @param close1 
	 *		El valor a establecer para la propiedad <code>close</code>.
	 */
	public void setClose( String close1 ){
		this.close=close1;
	}

		

	/**
	 * Retorna valor de propiedad <code>download</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>download</code>
	 */
	public String getDownload(){
		return this.download;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>download</code>.
	 * @param download1 
	 *		El valor a establecer para la propiedad <code>download</code>.
	 */
	public void setDownload( String download1 ){
		this.download=download1;
	}

		

	/**
	 * Retorna valor de propiedad <code>ecuador</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>ecuador</code>
	 */
	public String getEcuador(){
		return this.ecuador;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>ecuador</code>.
	 * @param ecuador1 
	 *		El valor a establecer para la propiedad <code>ecuador</code>.
	 */
	public void setEcuador( String ecuador1 ){
		this.ecuador=ecuador1;
	}

		

	/**
	 * Retorna valor de propiedad <code>voltype</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>voltype</code>
	 */
	public Integer getVoltype(){
		return this.voltype;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>voltype</code>.
	 * @param voltype1 
	 *		El valor a establecer para la propiedad <code>voltype</code>.
	 */
	public void setVoltype( Integer voltype1 ){
		this.voltype=voltype1;
		
	}


	/**
	 * Retorna valor de propiedad <code>navideno</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>navideno</code>
	 */
	public String getNavideno(){
		return this.navideno;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>navideno</code>.
	 * @param navideno1 
	 *		El valor a establecer para la propiedad <code>navideno</code>.
	 */
	public void setNavideno( String navideno1 ){
		this.navideno=navideno1;
	}

		

	/**
	 * Retorna valor de propiedad <code>textil</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>textil</code>
	 */
	public String getTextil(){
		return this.textil;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>textil</code>.
	 * @param textil1 
	 *		El valor a establecer para la propiedad <code>textil</code>.
	 */
	public void setTextil( String textil1 ){
		this.textil=textil1;
	}

		

	/**
	 * Retorna valor de propiedad <code>ceramica</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>ceramica</code>
	 */
	public String getCeramica(){
		return this.ceramica;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>ceramica</code>.
	 * @param ceramica1 
	 *		El valor a establecer para la propiedad <code>ceramica</code>.
	 */
	public void setCeramica( String ceramica1 ){
		this.ceramica=ceramica1;
	}

		

	/**
	 * Retorna valor de propiedad <code>inen</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>inen</code>
	 */
	public String getInen(){
		return this.inen;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>inen</code>.
	 * @param inen1 
	 *		El valor a establecer para la propiedad <code>inen</code>.
	 */
	public void setInen( String inen1 ){
		this.inen=inen1;
	}

		

	/**
	 * Retorna valor de propiedad <code>license</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>license</code>
	 */
	public String getLicense(){
		return this.license;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>license</code>.
	 * @param license1 
	 *		El valor a establecer para la propiedad <code>license</code>.
	 */
	public void setLicense( String license1 ){
		this.license=license1;
	}

		

	/**
	 * Retorna valor de propiedad <code>licensewrt</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>licensewrt</code>
	 */
	public String getLicensewrt(){
		return this.licensewrt;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>licensewrt</code>.
	 * @param licensewrt1 
	 *		El valor a establecer para la propiedad <code>licensewrt</code>.
	 */
	public void setLicensewrt( String licensewrt1 ){
		this.licensewrt=licensewrt1;
	}

	/**
	 * @return the usuarioRegistro
	 */
//	public String getUsuarioRegistro() {
//		return usuarioRegistro;
//	}
//
//	/**
//	 * @param usuarioRegistro the usuarioRegistro to set
//	 */
//	public void setUsuarioRegistro(String usuarioRegistro) {
//		this.usuarioRegistro = usuarioRegistro;
//	}
//
//	/**
//	 * @return the fechaRegistro
//	 */
//	public java.util.Date getFechaRegistro() {
//		return fechaRegistro;
//	}
//
//	/**
//	 * @param fechaRegistro the fechaRegistro to set
//	 */
//	public void setFechaRegistro(java.util.Date fechaRegistro) {
//		this.fechaRegistro = fechaRegistro;
//	}

	/**
	 * @return the usuarioModificacion
	 */
//	public String getUsuarioModificacion() {
//		return usuarioModificacion;
//	}
//
//	/**
//	 * @param usuarioModificacion the usuarioModificacion to set
//	 */
//	public void setUsuarioModificacion(String usuarioModificacion) {
//		this.usuarioModificacion = usuarioModificacion;
//	}
//
//	/**
//	 * @return the fechaModificacion
//	 */
//	public java.util.Date getFechaModificacion() {
//		return fechaModificacion;
//	}
//
//	/**
//	 * @param fechaModificacion the fechaModificacion to set
//	 */
//	public void setFechaModificacion(java.util.Date fechaModificacion) {
//		this.fechaModificacion = fechaModificacion;
//	}

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
	 * @return the npCompanyId
	 */
	public String getNpCompanyId() {
		return npCompanyId;
	}

	/**
	 * @param npCompanyId the npCompanyId to set
	 */
	public void setNpCompanyId(String npCompanyId) {
		this.npCompanyId = npCompanyId;
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
	 * @return the statusfav
	 */
	public String getStatusfav() {
		return statusfav;
	}

	/**
	 * @param statusfav the statusfav to set
	 */
	public void setStatusfav(String statusfav) {
		this.statusfav = statusfav;
	}

	/**
	 * @return the originorder
	 */
	public String getOriginorder() {
		return originorder;
	}

	/**
	 * @param originorder the originorder to set
	 */
	public void setOriginorder(String originorder) {
		this.originorder = originorder;
	}

	/**
	 * @return the numberCase
	 */
	public String getNumberCase() {
		return numberCase;
	}

	/**
	 * @param numberCase the numberCase to set
	 */
	public void setNumberCase(String numberCase) {
		this.numberCase = numberCase;
	}

	/**
	 * @return the vendorDTO
	 */
	public VendorDTO getVendorDTO() {
		return vendorDTO;
	}

	/**
	 * @param vendorDTO the vendorDTO to set
	 */
	public void setVendorDTO(VendorDTO vendorDTO) {
		this.vendorDTO = vendorDTO;
	}
	
	

	/**
	 * @return the npExistVendorDTO
	 */
	public Boolean getNpExistVendorDTO() {	
		npExistVendorDTO=isLoaded(vendorDTO);
		return npExistVendorDTO;
	}

	/**
	 * @param npExistVendorDTO the npExistVendorDTO to set
	 */
	public void setNpExistVendorDTO(Boolean npExistVendorDTO) {
		this.npExistVendorDTO = npExistVendorDTO;
	}

	
	/**
	 * @return the npClientName
	 */
	public String getNpClientName() {
		return npClientName;
	}

	/**
	 * @param npClientName the npClientName to set
	 */
	public void setNpClientName(String npClientName) {
		this.npClientName = npClientName;
	}

	/**
	 * @return the npVendorName
	 */
	public String getNpVendorName() {
		return npVendorName;
	}

	/**
	 * @param npVendorName the npVendorName to set
	 */
	public void setNpVendorName(String npVendorName) {
		this.npVendorName = npVendorName;
	}

	/**
	 * @return the npFair1Name
	 */
	public String getNpFair1Name() {
		return npFair1Name;
	}

	/**
	 * @param npFair1Name the npFair1Name to set
	 */
	public void setNpFair1Name(String npFair1Name) {
		this.npFair1Name = npFair1Name;
	}

	/**
	 * @return the npFair2Name
	 */
	public String getNpFair2Name() {
		return npFair2Name;
	}

	/**
	 * @param npFair2Name the npFair2Name to set
	 */
	public void setNpFair2Name(String npFair2Name) {
		this.npFair2Name = npFair2Name;
	}

	/**
	 * @return the npRepresentName
	 */
	public String getNpRepresentName() {
		return npRepresentName;
	}

	/**
	 * @param npRepresentName the npRepresentName to set
	 */
	public void setNpRepresentName(String npRepresentName) {
		this.npRepresentName = npRepresentName;
	}

	/**
	 * @return the npShipDescription
	 */
	public String getNpShipDescription() {
		return npShipDescription;
	}

	/**
	 * @param npShipDescription the npShipDescription to set
	 */
	public void setNpShipDescription(String npShipDescription) {
		this.npShipDescription = npShipDescription;
	}

	/**
	 * @return the npPaymentDescription
	 */
	public String getNpPaymentDescription() {
		return npPaymentDescription;
	}

	/**
	 * @param npPaymentDescription the npPaymentDescription to set
	 */
	public void setNpPaymentDescription(String npPaymentDescription) {
		this.npPaymentDescription = npPaymentDescription;
	}

	/**
	 * @return the npCurrencyName
	 */
	public String getNpCurrencyName() {
		return npCurrencyName;
	}

	/**
	 * @param npCurrencyName the npCurrencyName to set
	 */
	public void setNpCurrencyName(String npCurrencyName) {
		this.npCurrencyName = npCurrencyName;
	}

	
	
	}
