package ec.com.smx.sic.cliente.common.bodega;

public enum EnumCalendarioDiaSemana {
	
	DOMINGO(1), LUNES(2),MARTES(3),MIERCOLES(4),JUEVES(5),VIERNES(6),SABADO(7);
	
	EnumCalendarioDiaSemana(int numeroDiaSemana){
		this.numeroDiaSemana = numeroDiaSemana;
	}
	
	private int numeroDiaSemana;
	
	public int getNumeroDiaSemana(){
		return numeroDiaSemana;
	}
	
	public static EnumCalendarioDiaSemana getEnumCalendarioDiaSemana(int numeroDiaSemana) {
		for (EnumCalendarioDiaSemana enumCalendarioDiaSemana : EnumCalendarioDiaSemana.values()) {
			if (enumCalendarioDiaSemana.getNumeroDiaSemana() == numeroDiaSemana)  {
				return enumCalendarioDiaSemana;
			}
		}
		return null;
	}
}
