package ec.com.smx.sic.cliente.common.convenio.estructura;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import ec.com.smx.sic.cliente.common.convenio.ConveniosConstantes;
import ec.com.smx.sic.cliente.common.convenio.enums.CorteConveniosEnum;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * Estructura que  tiene los datos  para poder calcular las formas de cobro al proveedor
 * @author aquingaluisa
 *
 */
public class DatosPlanFechaCobroEstructura {
	//fecha de inicio de la promocion
	private Date fechaInicioPromocion;
	//fecha fin de la promocion
	private Date fechaFinPromocion;
	//fecha de cobro a configurar
	private Date fechaCobro;
	//numero de cuotas a cobrar, en el caso de que no exista el numero   la fecha esta dentro de la fecha de la promocion
	private Integer numeroCuotas;
	//tipo de corte semanal, mensual, quincenal
	private CorteConveniosEnum corte;
	//Tipo de forma de cobro
	private String tipoFormaCobro;
	
	//constructor
	public DatosPlanFechaCobroEstructura(Date fechaInicioPromocion,Date fechaFinPromocion,Date fechaCobro,Integer numeroCuotas,CorteConveniosEnum corte, String tipoFormaCobro){
		this.fechaInicioPromocion = fechaInicioPromocion;
		this.fechaFinPromocion = fechaFinPromocion;
		this.fechaCobro = fechaCobro;
		this.numeroCuotas = numeroCuotas;
		this.corte = corte;
		this.tipoFormaCobro = tipoFormaCobro;
	}
	
	public Collection<Date> calcularPagos(){
		GregorianCalendar calendar = new GregorianCalendar();
		Collection<Date> dateCol = new ArrayList<Date>();
		Date fechaBandera;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaCobro = sdf.parse(sdf.format(fechaCobro));
			fechaInicioPromocion= sdf.parse(sdf.format(fechaInicioPromocion));
			fechaFinPromocion= sdf.parse(sdf.format(fechaFinPromocion));
		} catch (ParseException e) {
			throw new SICException(e);
		}
	
		/**
		 * el valor es 0 si las dos fechas son iguales
		 * el valor menor a 0 si la fecha es menor al argumento
		 * el valor mayor a 0 si la fechas e mayor al argumento
		 */
		//el caso de cobro este dentro  de la promocion
		if((fechaCobro.after(fechaInicioPromocion)||fechaCobro.compareTo(fechaInicioPromocion)==0) && fechaCobro.before(fechaFinPromocion) && (tipoFormaCobro.equals(ConveniosConstantes.TIPO_FORMA_VENTA) || tipoFormaCobro.equals(ConveniosConstantes.TIPO_FORMA_COSTO))){
			fechaBandera = fechaCobro;
			//en este caso se debe validar solo corte
			if(corte.equals(CorteConveniosEnum.SEMANAL)){
				dateCol.add(fechaBandera);
				while (fechaBandera.compareTo(fechaFinPromocion)<0) {
					calendar.setTime(fechaBandera);
					calendar.add(Calendar.WEEK_OF_YEAR, 1);
					if(calendar.getTime().compareTo(fechaFinPromocion)==0){
						calendar.add(Calendar.DATE, 1);
					}
					fechaBandera = calendar.getTime();
					dateCol.add(fechaBandera);
				}
				return dateCol;
			}
			if(corte.equals(CorteConveniosEnum.QUINCENAL)){
				dateCol.add(fechaBandera);
				while (fechaBandera.compareTo(fechaFinPromocion)<0) {
					calendar.setTime(fechaBandera);
				    calendar.add(Calendar.WEEK_OF_YEAR, 1);
				    calendar.add(Calendar.WEEK_OF_YEAR, 1);
					if(calendar.getTime().compareTo(fechaFinPromocion)==0){
						calendar.add(Calendar.DATE, 1);
					}
				    fechaBandera = calendar.getTime(); 
					dateCol.add(fechaBandera);
				}
				return dateCol;
			}
			if(corte.equals(CorteConveniosEnum.MENSUAL)){
				dateCol.add(fechaBandera);
				while (fechaBandera.compareTo(fechaFinPromocion)<0) {
					calendar.setTime(fechaBandera);
					calendar.add(Calendar.MONTH, 1);
					if(calendar.getTime().compareTo(fechaFinPromocion)==0){
						calendar.add(Calendar.DATE, 1);
					}
					fechaBandera = calendar.getTime(); 
					dateCol.add(fechaBandera);
				}
				return dateCol;
			}
			
		}else{//el caso de que la fecha cobro sea mayor que la duracion de la promocion
			//solo en este caso se debe validar el numero de cuotas y el corte
			fechaBandera = fechaCobro;
			if(fechaBandera.compareTo(fechaFinPromocion)==0){
				calendar.setTime(fechaBandera);
				calendar.add(Calendar.DATE, 1);
				fechaBandera = calendar.getTime(); 
			}
			if(corte.equals(CorteConveniosEnum.SEMANAL)){
				for(int i=1;i <= this.numeroCuotas;i++){
					dateCol.add(fechaBandera);
					calendar.setTime(fechaBandera);
					calendar.add(Calendar.WEEK_OF_YEAR, 1);
					fechaBandera = calendar.getTime(); 
				}
				return dateCol;
			}
			if(corte.equals(CorteConveniosEnum.QUINCENAL)){
				for(int i=1;i <= this.numeroCuotas;i++){
					dateCol.add(fechaBandera);
					calendar.setTime(fechaBandera);
					calendar.add(Calendar.WEEK_OF_YEAR, 1);
					calendar.add(Calendar.WEEK_OF_YEAR, 1);
					fechaBandera = calendar.getTime(); 
				}
				return dateCol;
			}
			if(corte.equals(CorteConveniosEnum.MENSUAL)){
				for(int i=1;i <= this.numeroCuotas;i++){
					dateCol.add(fechaBandera);
					calendar.setTime(fechaBandera);
					calendar.add(Calendar.MONTH, 1);
					fechaBandera = calendar.getTime(); 
				}
				return dateCol;
			}
			
		}
		//retorna el plan de fechas en las que se le debe cobrar
		return null;
	}
	
	/**
	 * getter y setter
	 */
	public Date getFechaInicioPromocion() {
		return fechaInicioPromocion;
	}

	public void setFechaInicioPromocion(Date fechaInicioPromocion) {
		this.fechaInicioPromocion = fechaInicioPromocion;
	}

	public Date getFechaFinPromocion() {
		return fechaFinPromocion;
	}

	public void setFechaFinPromocion(Date fechaFinPromocion) {
		this.fechaFinPromocion = fechaFinPromocion;
	}

	public Date getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public Integer getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(Integer numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public CorteConveniosEnum getCorte() {
		return corte;
	}

	public void setCorte(CorteConveniosEnum corte) {
		this.corte = corte;
	}

	public String getTipoFormaCobro() {
		return tipoFormaCobro;
	}

	public void setTipoFormaCobro(String tipoFormaCobro) {
		this.tipoFormaCobro = tipoFormaCobro;
	}
}
