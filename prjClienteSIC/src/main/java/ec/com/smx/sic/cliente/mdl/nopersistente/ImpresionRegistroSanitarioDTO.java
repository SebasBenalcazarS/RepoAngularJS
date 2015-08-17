
package ec.com.smx.sic.cliente.mdl.nopersistente;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;


/**
 * clase para imprimir un registro sanitario
 *
 * @author kruger
 */
@SuppressWarnings("serial")
public class ImpresionRegistroSanitarioDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la impresion del registro sanitario
	 *
	 */
	private ImpresionRegistroSanitarioID id = new ImpresionRegistroSanitarioID();


	/**
	 * la cantidad de azucares por cada porción de artículo
	 *
	 */
	private String azucaresCantidad ;

	

	/**
	 * la cantidad de azucares en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double azucaresPorcentaje ;

	

	/**
	 * la cantidad de calcio en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double calcioPorcentaje ;

	

	/**
	 * la cantidad de carbohidratos totales por cada porción de artículo
	 *
	 */
	private String carbohidratosTotalesCantidad ;

	

	/**
	 * la cantidad de carbohidratos totales en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double carbohidratosTotalesPorcentaje ;

	

	/**
	 * la cantidad de colesterol por cada porción de artículo
	 *
	 */
	private String colesterolCantidad ;

	

	/**
	 * la cantidad de colesterol en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double colesterolPorcentaje ;

	

	/**
	 * la cantidad de energía medida en calorías por porción de artículo.
	 *
	 */
	private Double energiaCaloria ;

	

	/**
	 * la cantidad de energía medida en KJulios por porción de artículo.
	 *
	 */
	private Double energiaKJ ;

	

	/**
	 * la cantidad de energía medida en calorías proporcionada por grasa por cada porción de artículo.
	 *
	 */
	private Double energiaGrasaCaloria ;

	

	/**
	 * la cantidad de energía medida en KJulios proporcionada por grasa por cada porción de artículo.
	 *
	 */
	private Double energiaGrasaKJ ;

	

	/**
	 * Fecha en la cual caduca el artículo
	 *
	 */
	private java.util.Date fechaCaducidad ;

	

	/**
	 * Fecha de elaboración del artículo
	 *
	 */
	private java.util.Date fechaElaboracion ;

	

	/**
	 * la cantidad de fibra alimentaria por cada porción de artículo
	 *
	 */
	private String fibraAlimentariaCantidad ;

	

	/**
	 * la cantidad de fibre alimentaria en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double fibraAlimentariaPorcentaje ;

	

	/**
	 * la forma en que se debe conservar el artículo.
	 *
	 */
	private String formaConservacion ;

	

	/**
	 * la cantidad de grasa saturada por cada porción de artículo
	 *
	 */
	private String grasaSaturadaCantidad ;

	

	/**
	 * la cantidad de grasa saturada en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double grasaSaturadaPorcentaje ;

	

	/**
	 * la cantidad de grasa total por cada porción de artículo
	 *
	 */
	private String grasaTotalCantidad ;

	

	/**
	 * la cantidad de grasa total en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double grasaTotalPorcentaje ;

	

	/**
	 * la cantidad de grasa trans por cada porción de artículo
	 *

	 */
	private String grasaTransCantidad ;

	

	/**
	 * la cantidad de grasa trans en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *

	 */
	private Double grasaTransPorcentaje ;

	

	/**
	 * la cantidad de hierro en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *

	 */
	private Double hierroPorcentaje ;

	

	/**
	 * el importador del artículo.
	 */
	private String importador ;

	

	/**
	 * ingredientes que componen al artículo paramostrar en su registro sanitario
	 */
	private String ingredientes ;

	

	/**
	 * la leyenda del porcentaje del porcentaje de valores diarios del artículo que se muestra en su registro sanitario
	 */
	private String leyenda ;

	

	/**
	 * el lote al que pertenece el artículo.
	 */
	private String lote ;

	

	/**
	 * la marca del artículo que se muestra en su registro sanitario
	 */
	private String marca ;

	

	/**
	 * el nombre del artículo que se muestra en su registro sanitario
	 */
	private String nombreArticulo ;

	

	/**
	 * el nte del artículo que se muestra en su registro sanitario
	 */
	private String nte ;

	

	/**
	 * la cantidad de porciones por envase de artículo.
	 */
	private String porcionEnvase ;

	

	/**
	 * la cantidad de proteína por cada porción de artículo
	 */
	private String proteinaCantidad ;

	

	/**
	 * la cantidad de proteína en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 */
	private Double proteinaPorcentaje ;

	

	/**
	 * el proveedor del artículo.
	 */
	private String proveedor ;

	

	/**
	 * el registro sanitario del artículo.
	 */
	private String registroSanitario ;

	

	/**
	 * la cantidad de socio por cada porción de artículo
	 */
	private String sodioCantidad ;

	

	/**
	 * la cantidad de sodio en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 */
	private Double sodioPorcentaje ;

	

	/**
	 * el tamaño de cada porción del artículo.
	 */
	private String tamanioPorcion ;

	

	/**
	 * la cantidad de vitamina A en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double vitaminaAPorcentaje ;

	

	/**
	 * la cantidad de vitamina C en porcentaje del valor diario recomendado basado en una dieta de 2000 calorías por cada porción de artículo.
	 *
	 */
	private Double vitaminaCPorcentaje ;

	
	/**
	 * la cantidad de impresiones que se van a realizar del registro sanitario.
	 */
	private Integer cantidadImpresion ;

	
	/**
	 * el precio de venta del artículo.
	 */
	private String precio ;

	/**
	 * Descripción del artículo para el registro sanitario
	 */
	private String descripcionArticulo;
 
	/**
	 * Almacena la ciudad para el registro sanitario
	 */
	private String ciudadPais;
	
	/**
	 * la cantidad en porcentaje de los acidos grasos monoinsaturados
	 */
	private Double grasaMonoinsaturadaPorcentaje;
	
	/**
	 * la cantidad en gramos de los acidos grasos monoinsaturados
	 */
	private String grasaMonoinsaturadaCantidad;
	
	
	/**
	 * la cantidad en porcentaje de los acidos grasos poliinsaturados
	 */
	private Double grasaPoliinsaturadaPorcentaje;
	
	/**
	 * la cantidad en gramos de los acidos grasos poliinsaturados
	 */
	private String grasaPoliinsaturadaCantidad;
	
	/**
	 * la cantidad en porcentaje de la fibra dietetica
	 */
	private Double fibraDieteticaPorcentaje;
	
	/**
	 * la cantidad en gramos de la fibra dietetica
	 */
	private String fibraDieteticaCantidad;
	
	private String leyendaCompuestosTransgenicos;
	
	//campos auditoria
	private String estado;
	  
	@RegisterUserIdField
	private String usuarioRegistro ;

	@RegisterDateField
	private java.util.Date fechaRegistro ;

	@LastModifierUserIdField
	private String usuarioModificacion ;
	
	@LastModificationDateField
	private java.util.Date fechaModificacion ;

	private UserDto usuarioRegistroDTO;
	private UserDto usuarioModificacionDTO;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ImpresionRegistroSanitarioID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ImpresionRegistroSanitarioID id1 ){
		this.id=id1;
	}

	/**
	 * Retorna valor de propiedad <code>azucaresCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>azucaresCantidad</code>
	 */
	public String getAzucaresCantidad(){
		return this.azucaresCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>azucaresCantidad</code>.
	 * @param azucaresCantidad1 
	 *		El valor a establecer para la propiedad <code>azucaresCantidad</code>.
	 */
	public void setAzucaresCantidad( String azucaresCantidad1 ){
		this.azucaresCantidad=azucaresCantidad1;
		
		if(azucaresCantidad!=null && azucaresCantidad.length()>8){
			azucaresCantidad = azucaresCantidad.substring(0,8);
		}
				
				
	}

	/**
	 * Retorna valor de propiedad <code>carbohidratosTotalesCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>carbohidratosTotalesCantidad</code>
	 */
	public String getCarbohidratosTotalesCantidad(){
		return this.carbohidratosTotalesCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>carbohidratosTotalesCantidad</code>.
	 * @param carbohidratosTotalesCantidad1 
	 *		El valor a establecer para la propiedad <code>carbohidratosTotalesCantidad</code>.
	 */
	public void setCarbohidratosTotalesCantidad( String carbohidratosTotalesCantidad1 ){
		this.carbohidratosTotalesCantidad=carbohidratosTotalesCantidad1;
		
		if(carbohidratosTotalesCantidad!=null && carbohidratosTotalesCantidad.length()>8){
			carbohidratosTotalesCantidad = carbohidratosTotalesCantidad.substring(0,8);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>colesterolCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>colesterolCantidad</code>
	 */
	public String getColesterolCantidad(){
		return this.colesterolCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>colesterolCantidad</code>.
	 * @param colesterolCantidad1 
	 *		El valor a establecer para la propiedad <code>colesterolCantidad</code>.
	 */
	public void setColesterolCantidad( String colesterolCantidad1 ){
		this.colesterolCantidad=colesterolCantidad1;
		
		if(colesterolCantidad!=null && colesterolCantidad.length()>8){
			colesterolCantidad = colesterolCantidad.substring(0,8);
		}
	}


	/**
	 * Retorna valor de propiedad <code>fechaCaducidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaCaducidad</code>
	 */
	public java.util.Date getFechaCaducidad(){
		return this.fechaCaducidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaCaducidad</code>.
	 * @param fechaCaducidad1 
	 *		El valor a establecer para la propiedad <code>fechaCaducidad</code>.
	 */
	public void setFechaCaducidad( java.util.Date fechaCaducidad1 ){
		this.fechaCaducidad=fechaCaducidad1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>fechaElaboracion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaElaboracion</code>
	 */
	public java.util.Date getFechaElaboracion(){
		return this.fechaElaboracion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaElaboracion</code>.
	 * @param fechaElaboracion1 
	 *		El valor a establecer para la propiedad <code>fechaElaboracion</code>.
	 */
	public void setFechaElaboracion( java.util.Date fechaElaboracion1 ){
		this.fechaElaboracion=fechaElaboracion1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>fibraAlimentariaCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fibraAlimentariaCantidad</code>
	 */
	public String getFibraAlimentariaCantidad(){
		return this.fibraAlimentariaCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fibraAlimentariaCantidad</code>.
	 * @param fibraAlimentariaCantidad1 
	 *		El valor a establecer para la propiedad <code>fibraAlimentariaCantidad</code>.
	 */
	public void setFibraAlimentariaCantidad( String fibraAlimentariaCantidad1 ){
		this.fibraAlimentariaCantidad=fibraAlimentariaCantidad1;
		
		if(fibraAlimentariaCantidad!=null && fibraAlimentariaCantidad.length()>8){
			fibraAlimentariaCantidad = fibraAlimentariaCantidad.substring(0,8);
		}
	}


	/**
	 * Retorna valor de propiedad <code>formaConservacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>formaConservacion</code>
	 */
	public String getFormaConservacion(){
		return this.formaConservacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>formaConservacion</code>.
	 * @param formaConservacion1 
	 *		El valor a establecer para la propiedad <code>formaConservacion</code>.
	 */
	public void setFormaConservacion( String formaConservacion1 ){
		this.formaConservacion=formaConservacion1;
		
		if(formaConservacion!=null && formaConservacion.length()>128){
			formaConservacion = formaConservacion.substring(0,128);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>grasaSaturadaCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>grasaSaturadaCantidad</code>
	 */
	public String getGrasaSaturadaCantidad(){
		return this.grasaSaturadaCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>grasaSaturadaCantidad</code>.
	 * @param grasaSaturadaCantidad1 
	 *		El valor a establecer para la propiedad <code>grasaSaturadaCantidad</code>.
	 */
	public void setGrasaSaturadaCantidad( String grasaSaturadaCantidad1 ){
		this.grasaSaturadaCantidad=grasaSaturadaCantidad1;
		
		if(grasaSaturadaCantidad!=null && grasaSaturadaCantidad.length()>8){
			grasaSaturadaCantidad = grasaSaturadaCantidad.substring(0,8);
		}
	}

	/**
	 * Retorna valor de propiedad <code>grasaTotalCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>grasaTotalCantidad</code>
	 */
	public String getGrasaTotalCantidad(){
		return this.grasaTotalCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>grasaTotalCantidad</code>.
	 * @param grasaTotalCantidad1 
	 *		El valor a establecer para la propiedad <code>grasaTotalCantidad</code>.
	 */
	public void setGrasaTotalCantidad( String grasaTotalCantidad1 ){
		this.grasaTotalCantidad=grasaTotalCantidad1;
		
		if(grasaTotalCantidad!=null && grasaTotalCantidad.length()>8){
			grasaTotalCantidad = grasaTotalCantidad.substring(0,8);
		}
	}


	/**
	 * Retorna valor de propiedad <code>grasaTransCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>grasaTransCantidad</code>
	 */
	public String getGrasaTransCantidad(){
		return this.grasaTransCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>grasaTransCantidad</code>.
	 * @param grasaTransCantidad1 
	 *		El valor a establecer para la propiedad <code>grasaTransCantidad</code>.
	 */
	public void setGrasaTransCantidad( String grasaTransCantidad1 ){
		this.grasaTransCantidad=grasaTransCantidad1;
		
		if(grasaTransCantidad!=null && grasaTransCantidad.length()>8){
			grasaTransCantidad = grasaTransCantidad.substring(0,8);
		}
	}

	/**
	 * Retorna valor de propiedad <code>importador</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>importador</code>
	 */
	public String getImportador(){
		return this.importador;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>importador</code>.
	 * @param importador1 
	 *		El valor a establecer para la propiedad <code>importador</code>.
	 */
	public void setImportador( String importador1 ){
		this.importador=importador1;
		
		if(importador!=null && importador.length()>128){
			importador = importador.substring(0,128);
		}
	}

	/**
	 * Retorna valor de propiedad <code>ingredientes</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>ingredientes</code>
	 */
	public String getIngredientes(){
		return this.ingredientes;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>ingredientes</code>.
	 * @param ingredientes1 
	 *		El valor a establecer para la propiedad <code>ingredientes</code>.
	 */
	public void setIngredientes( String ingredientes1 ){
		this.ingredientes=ingredientes1;
	}

		

	/**
	 * Retorna valor de propiedad <code>leyenda</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>leyenda</code>
	 */
	public String getLeyenda(){
		return this.leyenda;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>leyenda</code>.
	 * @param leyenda1 
	 *		El valor a establecer para la propiedad <code>leyenda</code>.
	 */
	public void setLeyenda( String leyenda1 ){
		this.leyenda=leyenda1;
		
		if(leyenda!=null && leyenda.length()>128){
			leyenda = leyenda.substring(0,128);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>lote</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>lote</code>
	 */
	public String getLote(){
		return this.lote;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>lote</code>.
	 * @param lote1 
	 *		El valor a establecer para la propiedad <code>lote</code>.
	 */
	public void setLote( String lote1 ){
		this.lote=lote1;
		
		if(lote!=null && lote.length()>64){
			lote = lote.substring(0,64);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>marca</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>marca</code>
	 */
	public String getMarca(){
		return this.marca;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>marca</code>.
	 * @param marca1 
	 *		El valor a establecer para la propiedad <code>marca</code>.
	 */
	public void setMarca( String marca1 ){
		this.marca=marca1;
		
		if(marca!=null && marca.length()>64){
			marca = marca.substring(0,64);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>nombreArticulo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>nombreArticulo</code>
	 */
	public String getNombreArticulo(){
		return this.nombreArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombreArticulo</code>.
	 * @param nombreArticulo1 
	 *		El valor a establecer para la propiedad <code>nombreArticulo</code>.
	 */
	public void setNombreArticulo( String nombreArticulo1 ){
		this.nombreArticulo=nombreArticulo1;
		
		if(nombreArticulo!=null && nombreArticulo.length()>128){
			nombreArticulo = nombreArticulo.substring(0,128);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>nte</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>nte</code>
	 */
	public String getNte(){
		return this.nte;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nte</code>.
	 * @param nte1 
	 *		El valor a establecer para la propiedad <code>nte</code>.
	 */
	public void setNte( String nte1 ){
		this.nte=nte1;
		
		if(nte!=null && nte.length()>64){
			nte = nte.substring(0,64);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>porcionEnvase</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>porcionEnvase</code>
	 */
	public String getPorcionEnvase(){
		return this.porcionEnvase;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>porcionEnvase</code>.
	 * @param porcionEnvase1 
	 *		El valor a establecer para la propiedad <code>porcionEnvase</code>.
	 */
	public void setPorcionEnvase( String porcionEnvase1 ){
		this.porcionEnvase=porcionEnvase1;
		
		if(porcionEnvase!=null && porcionEnvase.length()>16){
			porcionEnvase = porcionEnvase.substring(0,16);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>proteinaCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>proteinaCantidad</code>
	 */
	public String getProteinaCantidad(){
		return this.proteinaCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proteinaCantidad</code>.
	 * @param proteinaCantidad1 
	 *		El valor a establecer para la propiedad <code>proteinaCantidad</code>.
	 */
	public void setProteinaCantidad( String proteinaCantidad1 ){
		this.proteinaCantidad=proteinaCantidad1;
		
		if(proteinaCantidad!=null && proteinaCantidad.length()>8){
			proteinaCantidad = proteinaCantidad.substring(0,8);
		}
	}


	/**
	 * Retorna valor de propiedad <code>proveedor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>proveedor</code>
	 */
	public String getProveedor(){
		return this.proveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * @param proveedor1 
	 *		El valor a establecer para la propiedad <code>proveedor</code>.
	 */
	public void setProveedor( String proveedor1 ){
		this.proveedor=proveedor1;
		
		if(proveedor!=null && proveedor.length()>128){
			proveedor = proveedor.substring(0,128);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>registroSanitario</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>registroSanitario</code>
	 */
	public String getRegistroSanitario(){
		return this.registroSanitario;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>registroSanitario</code>.
	 * @param registroSanitario1 
	 *		El valor a establecer para la propiedad <code>registroSanitario</code>.
	 */
	public void setRegistroSanitario( String registroSanitario1 ){
		this.registroSanitario=registroSanitario1;
		
		if(registroSanitario!=null && registroSanitario.length()>64){
			registroSanitario = registroSanitario.substring(0,64);
		}
	}

		

	/**
	 * Retorna valor de propiedad <code>sodioCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>sodioCantidad</code>
	 */
	public String getSodioCantidad(){
		return this.sodioCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>sodioCantidad</code>.
	 * @param sodioCantidad1 
	 *		El valor a establecer para la propiedad <code>sodioCantidad</code>.
	 */
	public void setSodioCantidad( String sodioCantidad1 ){
		this.sodioCantidad=sodioCantidad1;
		
		if(sodioCantidad!=null && sodioCantidad.length()>8){
			sodioCantidad = sodioCantidad.substring(0,8);
		}
	}

	/**
	 * Retorna valor de propiedad <code>tamanioPorcion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>tamanioPorcion</code>
	 */
	public String getTamanioPorcion(){
		return this.tamanioPorcion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tamanioPorcion</code>.
	 * @param tamanioPorcion1 
	 *		El valor a establecer para la propiedad <code>tamanioPorcion</code>.
	 */
	public void setTamanioPorcion( String tamanioPorcion1 ){
		this.tamanioPorcion=tamanioPorcion1;
		
		if(tamanioPorcion!=null && tamanioPorcion.length()>16){
			tamanioPorcion = tamanioPorcion.substring(0,16);
		}
	}


	/**
	 * Retorna valor de propiedad <code>cantidadImpresion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cantidadImpresion</code>
	 */
	public Integer getCantidadImpresion(){
		return this.cantidadImpresion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadImpresion</code>.
	 * @param cantidadImpresion1 
	 *		El valor a establecer para la propiedad <code>cantidadImpresion</code>.
	 */
	public void setCantidadImpresion( Integer cantidadImpresion1 ){
		this.cantidadImpresion=cantidadImpresion1;		
	}
	
	/**
	 * Retorna valor de propiedad <code>precio</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>precio</code>
	 */
	public String getPrecio(){
		return this.precio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>precio</code>.
	 * @param precio1 
	 *		El valor a establecer para la propiedad <code>precio</code>.
	 */
	public void setPrecio( String precio1 ){
		this.precio=precio1;
		
		if(precio!=null && precio.length()>7){
			precio = precio.substring(0,7);
		}			
	}

	/**
	 * @return el azucaresPorcentaje
	 */
	public Double getAzucaresPorcentaje() {
		return azucaresPorcentaje;
	}

	/**
	 * @param azucaresPorcentaje el azucaresPorcentaje a establecer
	 */
	public void setAzucaresPorcentaje(Double azucaresPorcentaje) {
		this.azucaresPorcentaje = azucaresPorcentaje;
	}

	/**
	 * @return el calcioPorcentaje
	 */
	public Double getCalcioPorcentaje() {
		return calcioPorcentaje;
	}

	/**
	 * @param calcioPorcentaje el calcioPorcentaje a establecer
	 */
	public void setCalcioPorcentaje(Double calcioPorcentaje) {
		this.calcioPorcentaje = calcioPorcentaje;
	}

	/**
	 * @return el carbohidratosTotalesPorcentaje
	 */
	public Double getCarbohidratosTotalesPorcentaje() {
		return carbohidratosTotalesPorcentaje;
	}

	/**
	 * @param carbohidratosTotalesPorcentaje el carbohidratosTotalesPorcentaje a establecer
	 */
	public void setCarbohidratosTotalesPorcentaje(
			Double carbohidratosTotalesPorcentaje) {
		this.carbohidratosTotalesPorcentaje = carbohidratosTotalesPorcentaje;
	}

	/**
	 * @return el colesterolPorcentaje
	 */
	public Double getColesterolPorcentaje() {
		return colesterolPorcentaje;
	}

	/**
	 * @param colesterolPorcentaje el colesterolPorcentaje a establecer
	 */
	public void setColesterolPorcentaje(Double colesterolPorcentaje) {
		this.colesterolPorcentaje = colesterolPorcentaje;
	}

	/**
	 * @return el energiaCaloria
	 */
	public Double getEnergiaCaloria() {
		return energiaCaloria;
	}

	/**
	 * @param energiaCaloria el energiaCaloria a establecer
	 */
	public void setEnergiaCaloria(Double energiaCaloria) {
		this.energiaCaloria = energiaCaloria;
	}

	/**
	 * @return el energiaGrasaCaloria
	 */
	public Double getEnergiaGrasaCaloria() {
		return energiaGrasaCaloria;
	}

	/**
	 * @param energiaGrasaCaloria el energiaGrasaCaloria a establecer
	 */
	public void setEnergiaGrasaCaloria(Double energiaGrasaCaloria) {
		this.energiaGrasaCaloria = energiaGrasaCaloria;
	}

	/**
	 * @return el energiaGrasaKJ
	 */
	public Double getEnergiaGrasaKJ() {
		return energiaGrasaKJ;
	}

	/**
	 * @param energiaGrasaKJ el energiaGrasaKJ a establecer
	 */
	public void setEnergiaGrasaKJ(Double energiaGrasaKJ) {
		this.energiaGrasaKJ = energiaGrasaKJ;
	}

	/**
	 * @return el energiaKJ
	 */
	public Double getEnergiaKJ() {
		return energiaKJ;
	}

	/**
	 * @param energiaKJ el energiaKJ a establecer
	 */
	public void setEnergiaKJ(Double energiaKJ) {
		this.energiaKJ = energiaKJ;
	}

	/**
	 * @return el fibraAlimentariaPorcentaje
	 */
	public Double getFibraAlimentariaPorcentaje() {
		return fibraAlimentariaPorcentaje;
	}

	/**
	 * @param fibraAlimentariaPorcentaje el fibraAlimentariaPorcentaje a establecer
	 */
	public void setFibraAlimentariaPorcentaje(Double fibraAlimentariaPorcentaje) {
		this.fibraAlimentariaPorcentaje = fibraAlimentariaPorcentaje;
	}

	/**
	 * @return el grasaSaturadaPorcentaje
	 */
	public Double getGrasaSaturadaPorcentaje() {
		return grasaSaturadaPorcentaje;
	}

	/**
	 * @param grasaSaturadaPorcentaje el grasaSaturadaPorcentaje a establecer
	 */
	public void setGrasaSaturadaPorcentaje(Double grasaSaturadaPorcentaje) {
		this.grasaSaturadaPorcentaje = grasaSaturadaPorcentaje;
	}

	/**
	 * @return el grasaTotalPorcentaje
	 */
	public Double getGrasaTotalPorcentaje() {
		return grasaTotalPorcentaje;
	}

	/**
	 * @param grasaTotalPorcentaje el grasaTotalPorcentaje a establecer
	 */
	public void setGrasaTotalPorcentaje(Double grasaTotalPorcentaje) {
		this.grasaTotalPorcentaje = grasaTotalPorcentaje;
	}

	/**
	 * @return el grasaTransPorcentaje
	 */
	public Double getGrasaTransPorcentaje() {
		return grasaTransPorcentaje;
	}

	/**
	 * @param grasaTransPorcentaje el grasaTransPorcentaje a establecer
	 */
	public void setGrasaTransPorcentaje(Double grasaTransPorcentaje) {
		this.grasaTransPorcentaje = grasaTransPorcentaje;
	}

	/**
	 * @return el hierroPorcentaje
	 */
	public Double getHierroPorcentaje() {
		return hierroPorcentaje;
	}

	/**
	 * @param hierroPorcentaje el hierroPorcentaje a establecer
	 */
	public void setHierroPorcentaje(Double hierroPorcentaje) {
		this.hierroPorcentaje = hierroPorcentaje;
	}

	/**
	 * @return el proteinaPorcentaje
	 */
	public Double getProteinaPorcentaje() {
		return proteinaPorcentaje;
	}

	/**
	 * @param proteinaPorcentaje el proteinaPorcentaje a establecer
	 */
	public void setProteinaPorcentaje(Double proteinaPorcentaje) {
		this.proteinaPorcentaje = proteinaPorcentaje;
	}

	/**
	 * @return el sodioPorcentaje
	 */
	public Double getSodioPorcentaje() {
		return sodioPorcentaje;
	}

	/**
	 * @param sodioPorcentaje el sodioPorcentaje a establecer
	 */
	public void setSodioPorcentaje(Double sodioPorcentaje) {
		this.sodioPorcentaje = sodioPorcentaje;
	}

	/**
	 * @return el vitaminaAPorcentaje
	 */
	public Double getVitaminaAPorcentaje() {
		return vitaminaAPorcentaje;
	}

	/**
	 * @param vitaminaAPorcentaje el vitaminaAPorcentaje a establecer
	 */
	public void setVitaminaAPorcentaje(Double vitaminaAPorcentaje) {
		this.vitaminaAPorcentaje = vitaminaAPorcentaje;
	}

	/**
	 * @return el vitaminaCPorcentaje
	 */
	public Double getVitaminaCPorcentaje() {
		return vitaminaCPorcentaje;
	}

	/**
	 * @param vitaminaCPorcentaje el vitaminaCPorcentaje a establecer
	 */
	public void setVitaminaCPorcentaje(Double vitaminaCPorcentaje) {
		this.vitaminaCPorcentaje = vitaminaCPorcentaje;
	}

	/**
	 * @return el descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo el descripcionArticulo a establecer
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * @return el ciudadPais
	 */
	public String getCiudadPais() {
		return ciudadPais;
	}

	/**
	 * @param ciudadPais el ciudadPais a establecer
	 */
	public void setCiudadPais(String ciudadPais) {
		this.ciudadPais = ciudadPais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}

	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}

	/**
	 * @return the grasaMonoinsaturadaPorcentaje
	 */
	public Double getGrasaMonoinsaturadaPorcentaje() {
		return grasaMonoinsaturadaPorcentaje;
	}

	/**
	 * @param grasaMonoinsaturadaPorcentaje the grasaMonoinsaturadaPorcentaje to set
	 */
	public void setGrasaMonoinsaturadaPorcentaje(Double grasaMonoinsaturadaPorcentaje) {
		this.grasaMonoinsaturadaPorcentaje = grasaMonoinsaturadaPorcentaje;
	}

	/**
	 * @return the grasaMonoinsaturadaCantidad
	 */
	public String getGrasaMonoinsaturadaCantidad() {
		return grasaMonoinsaturadaCantidad;
	}

	/**
	 * @param grasaMonoinsaturadaCantidad the grasaMonoinsaturadaCantidad to set
	 */
	public void setGrasaMonoinsaturadaCantidad(String grasaMonoinsaturadaCantidad) {
		this.grasaMonoinsaturadaCantidad = grasaMonoinsaturadaCantidad;
	}

	/**
	 * @return the grasaPoliinsaturadaPorcentaje
	 */
	public Double getGrasaPoliinsaturadaPorcentaje() {
		return grasaPoliinsaturadaPorcentaje;
	}

	/**
	 * @param grasaPoliinsaturadaPorcentaje the grasaPoliinsaturadaPorcentaje to set
	 */
	public void setGrasaPoliinsaturadaPorcentaje(Double grasaPoliinsaturadaPorcentaje) {
		this.grasaPoliinsaturadaPorcentaje = grasaPoliinsaturadaPorcentaje;
	}

	/**
	 * @return the grasaPoliinsaturadaCantidad
	 */
	public String getGrasaPoliinsaturadaCantidad() {
		return grasaPoliinsaturadaCantidad;
	}

	/**
	 * @param grasaPoliinsaturadaCantidad the grasaPoliinsaturadaCantidad to set
	 */
	public void setGrasaPoliinsaturadaCantidad(String grasaPoliinsaturadaCantidad) {
		this.grasaPoliinsaturadaCantidad = grasaPoliinsaturadaCantidad;
	}

	/**
	 * @return the fibraDieteticaPorcentaje
	 */
	public Double getFibraDieteticaPorcentaje() {
		return fibraDieteticaPorcentaje;
	}

	/**
	 * @param fibraDieteticaPorcentaje the fibraDieteticaPorcentaje to set
	 */
	public void setFibraDieteticaPorcentaje(Double fibraDieteticaPorcentaje) {
		this.fibraDieteticaPorcentaje = fibraDieteticaPorcentaje;
	}

	/**
	 * @return the fibraDieteticaCantidad
	 */
	public String getFibraDieteticaCantidad() {
		return fibraDieteticaCantidad;
	}

	/**
	 * @param fibraDieteticaCantidad the fibraDieteticaCantidad to set
	 */
	public void setFibraDieteticaCantidad(String fibraDieteticaCantidad) {
		this.fibraDieteticaCantidad = fibraDieteticaCantidad;
	}

	public String getLeyendaCompuestosTransgenicos() {
		return leyendaCompuestosTransgenicos;
	}

	public void setLeyendaCompuestosTransgenicos(String leyendaCompuestosTransgenicos) {
		this.leyendaCompuestosTransgenicos = leyendaCompuestosTransgenicos;
	}

}

