package ec.com.smx.sic.cliente.mdl.dto.b2b;

import java.text.ParseException;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.ArchivoID;

/************************************
 * Permite guardar un archivo 		*
 * de pedidos en la base de datos	*
 *									*
 * @author kruger					*
 ************************************ 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.ArchivoDatoDTO")
@Table(name = "SSB2BTARCHIVO")
@Deprecated
public class ArchivoDatoDTO extends SimpleAuditDTO
{

/**
 * Nombre del archivo
 */
 private String nombreArchivo;


 /**
  * @return 
  * 	Retorna propiedad nombreArchivo
  */
 public String getNombreArchivo()
 {
   return this.nombreArchivo;
 }

 /**
  * @param nombreArchivo1 
  *		El valor para a setear para la propiedad nombreArchivo.

  */
 public void setNombreArchivo( String nombreArchivo1 )
 {
 	this.nombreArchivo=nombreArchivo1;

	if(nombreArchivo!=null && nombreArchivo.length()>32){
		nombreArchivo = nombreArchivo.substring(0,32);
	}
	
	if(this.nombreArchivo !=null){
		this.nombreArchivo = ec.com.smx.corporativo.commons.util.CorporativoUtil.toUpperCase(this.nombreArchivo);
	}

 }

/**
 * Descripcion del archivo
 */
 private String descripcionArchivo;


 /**
  * @return 
  * 	Retorna propiedad descripcionArchivo
  */
 public String getDescripcionArchivo()
 {
   return this.descripcionArchivo;
 }

 /**
  * @param descripcionArchivo1 
  *		El valor para a setear para la propiedad descripcionArchivo.
  */
 public void setDescripcionArchivo( String descripcionArchivo1 )
 {
 	this.descripcionArchivo=descripcionArchivo1;

	if(descripcionArchivo!=null && descripcionArchivo.length()>200)
	{
		descripcionArchivo = descripcionArchivo.substring(0,200);
	}
	
	if(this.descripcionArchivo !=null)
	{
		this.descripcionArchivo = ec.com.smx.corporativo.commons.util.CorporativoUtil.toUpperCase(this.descripcionArchivo);
	}
	

 }



/**
 * Dato,  informacion
 * contenida en el archivo	
 */
 private byte[] datoArchivo;


 /**
  * @return 
  * 	Retorna propiedad datoArchivo
  */
 public byte[] getDatoArchivo()
 {
   return this.datoArchivo;
 }

 /**
  * @param datoArchivo1 
  *		El valor para a setear para la propiedad datoArchivo.

  */
 public void setDatoArchivo( byte[] datoArchivo1 )
 {
 	this.datoArchivo=datoArchivo1;


 }

/**
 * Estado del archivo
 * 0 No usado
 * 1 Usado 
 */
 private String estadoArchivo;


 /**
  * @return 
  * 	Retorna propiedad estadoArchivo
  */
 public String getEstadoArchivo()
 {
   return this.estadoArchivo;
 }

 /**
  * @param estadoArchivo1 
  *		El valor para a setear para la propiedad estadoArchivo.

  */
 public void setEstadoArchivo( String estadoArchivo1 )
 {
 	this.estadoArchivo=estadoArchivo1;

	if(estadoArchivo!=null && estadoArchivo.length()>1)
	{
		estadoArchivo = estadoArchivo.substring(0,1);
	}
	
	if(this.estadoArchivo !=null)
	{
		this.estadoArchivo = ec.com.smx.corporativo.commons.util.CorporativoUtil.toUpperCase(this.estadoArchivo);
	}

 }

/**
 * Origen del dato
 */
 @Transient
 private String origenDato;


 /**
  * @return 
  * 	Retorna propiedad origenDato
  */
 public String getOrigenDato()
 {
   return this.origenDato;
 }

 /**
  * @param origenDato1 
  *		El valor para a setear para la propiedad origenDato.
  */
 public void setOrigenDato( String origenDato1 )
 {
 	this.origenDato=origenDato1;

	if(origenDato!=null && origenDato.length()>3)
	{
		origenDato = origenDato.substring(0,3);
	}
	
	if(this.origenDato !=null)
	{
		this.origenDato = ec.com.smx.corporativo.commons.util.CorporativoUtil.toUpperCase(this.origenDato);
	}
	

 }

/**
 * Propiedad ID, identificador 
 * unico del objeto ArchivoDTO
 */
 @EmbeddedId
 private ArchivoID id= new ArchivoID();


 /**
  * @return 
  * 	Retorna propiedad id
  */
 public ArchivoID getId()
 {
   return this.id;
 }

 /**
  * @param id1 
  *		El valor para a setear para la propiedad id.

  */
 public void setId( ArchivoID id1 )
 {
 	this.id=id1;
 }

/**
 * Origen dato TIC
 */
 @Transient
 private Integer origenDatoTIC;


 /**
  * @return 
  * 	Retorna propiedad origenDatoTIC
  */
 public Integer getOrigenDatoTIC()
 {
   return this.origenDatoTIC;
 }

 /**
  * @param origenDatoTIC1 
  *		El valor para a setear para la propiedad origenDatoTIC.

  */
 public void setOrigenDatoTIC( Integer origenDatoTIC1 )
 {
 	this.origenDatoTIC=origenDatoTIC1;
 }

/**
 * Fecha de creacion del archivo
 */
 private java.util.Date fechaArchivo;


 /**
  * @return 
  * 	Retorna propiedad fechaArchivo
  */
 public java.util.Date getFechaArchivo()
 {
   return this.fechaArchivo;
 }

 /**
  * @param fechaArchivo1 
  *		El valor para a setear para la propiedad fechaArchivo.

  */
 public void setFechaArchivo( java.util.Date fechaArchivo1 )
 {
 	this.fechaArchivo=fechaArchivo1;
 }


 /**
  * @return 
  * 	Retorna propiedad fechaArchivo en formato de Cadena

  */
	public String getFechaArchivoS() 
	{
		return (this.fechaArchivo!=null)?ec.com.smx.corporativo.commons.util.CorporativoUtil.getYMDDateFormat().format(this.fechaArchivo):null;
	}
	/**
	 * @param cadena 	String que representa el valor formateado para establecer fechaArchivo.

	 */
	public void setFechaArchivoS(String cadena) 
	{
		try {
			this.fechaArchivo = (cadena!=null)?ec.com.smx.corporativo.commons.util.CorporativoUtil.getYMDDateFormat().parse(cadena):null;
		} catch (ParseException e) {
			throw new SICException("No se puede transformar la fecha a cadena",e);
		}
	}	


/**
 * Catalogo Valores archivo
 */
@Transient
private ec.com.smx.corporativo.admparamgeneral.dto.CatalogoValorDTO origenDatoDTO;


 /**
  * @return 
  * 	Retorna propiedad origenDatoDTO
  */
 public ec.com.smx.corporativo.admparamgeneral.dto.CatalogoValorDTO getOrigenDatoDTO()
 {
   return this.origenDatoDTO;
 }

 /**
  * @param origenDatoDTO1 
  *		El valor para a setear para la propiedad origenDatoDTO.

  */
 public void setOrigenDatoDTO( ec.com.smx.corporativo.admparamgeneral.dto.CatalogoValorDTO origenDatoDTO1 )
 {
 	this.origenDatoDTO=origenDatoDTO1;
 }


/**
 * Tipo de archivo
 */
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "CODIGOARCHIVOTIPO", referencedColumnName = "CODIGOARCHIVOTIPO", updatable = false, insertable = false)
 private ArchivoTipoDTO archivoTipo;


 /**
  * @return 
  * 	Retorna propiedad archivoTipo
  */
 public ArchivoTipoDTO getArchivoTipo()
 {
   return this.archivoTipo;
 }

 /**
  * @param archivoTipo1 
  *		El valor para a setear para la propiedad archivoTipo.

  */
 public void setArchivoTipo( ArchivoTipoDTO archivoTipo1 )
 {
 	this.archivoTipo=archivoTipo1;
 }

/**
 * Codigo del tipo de archivo
 */
 private String codigoArchivoTipo;


 /**
  * @return 
  * 	Retorna propiedad codigoArchivoTipo
  */
 public String getCodigoArchivoTipo()
 {
   return this.codigoArchivoTipo;
 }

 /**
  * @param codigoArchivoTipo1 
  *		El valor para a setear para la propiedad codigoArchivoTipo.
  */
 public void setCodigoArchivoTipo( String codigoArchivoTipo1 )
 {
 	this.codigoArchivoTipo=codigoArchivoTipo1;

	if(codigoArchivoTipo!=null && codigoArchivoTipo.length()>3)
	{
		codigoArchivoTipo = codigoArchivoTipo.substring(0,3);
	}
	
	if(this.codigoArchivoTipo !=null)
	{
		this.codigoArchivoTipo = ec.com.smx.corporativo.commons.util.CorporativoUtil.toUpperCase(this.codigoArchivoTipo);
	}

 }
 
 /**
  * Obtener archivo
  * de archivoDato
  * @return
  */
 public ArchivoDTO getArchivo()
 {
       ArchivoDTO archivo = new ArchivoDTO();
       
       try
       {
	       archivo.setId(this.getId());
	       archivo.setArchivoTipo(this.getArchivoTipo());
	       archivo.setCodigoArchivoTipo(this.getCodigoArchivoTipo());
	       archivo.setDescripcionArchivo(this.getDescripcionArchivo());
	       archivo.setEstadoArchivo(this.getEstadoArchivo());
	       archivo.setFechaArchivo(this.getFechaArchivo());
	       //archivo.setFechaArchivoS(this.getFechaArchivoS());
	       archivo.setNombreArchivo(this.getNombreArchivo());
	       archivo.setOrigenDato(this.getOrigenDato());
	       archivo.setOrigenDatoDTO(this.getOrigenDatoDTO());
	       archivo.setOrigenDatoTIC(this.getOrigenDatoTIC());
       }
       catch(Exception e){
    	   archivo = null;   
       }
       return archivo;
 }
}

