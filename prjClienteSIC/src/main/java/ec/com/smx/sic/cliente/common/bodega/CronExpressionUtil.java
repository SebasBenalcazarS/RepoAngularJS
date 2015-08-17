package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.common.Logeable;

public class CronExpressionUtil {
	private static final CronExpressionUtil INSTANCIA = new CronExpressionUtil();
	public static CronExpressionUtil getInstancia(){
		return INSTANCIA;
	}
	public String armarExpresion(Integer anio, Integer mes, Integer diaMes, Integer diaSemana){
		StringBuilder expresion = new StringBuilder();
		expresion.append("* ");//Segundos
		expresion.append("* ");//Minutos
		expresion.append("* ");//Horas
		if(diaSemana != null && diaMes == null){
			expresion.append("? ");
			if(mes != null){
				expresion.append(mes+" ");
			}
			else{
				expresion.append("* ");
			}
			expresion.append(diaSemana+" ");
		}
		else if(diaSemana == null && diaMes != null){
			expresion.append(diaMes+" ");
			if(mes != null){
				expresion.append(mes+" ");
			}
			else{
				expresion.append("* ");
			}
			expresion.append("? ");
		}
		else {
			expresion.append("* ");
			if(mes != null){
				expresion.append(mes+" ");
			}
			else{
				expresion.append("* ");
			}
			expresion.append("* ");
		}
		
		if(anio != null){
			expresion.append(anio+" ");
		}
		else{
			expresion.append("*");
		}
		Logeable.LOG_SICV2.info("expresion: {}",expresion.toString());
		return expresion.toString();
	}
}
