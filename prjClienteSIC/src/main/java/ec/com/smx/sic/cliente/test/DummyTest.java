package ec.com.smx.sic.cliente.test;

import ec.com.smx.sic.cliente.common.Logeable;

public class DummyTest {
	private static Long pasillo = 801L;
	private static Long desdeRack = 10L;
	private static Long nivel = 5L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cargar();

	}
	
	public static void cargar(){
		long numNivel = 1;
		int i=0;
		for (i = 0; i <nivel ; i++){
			
		}
		while (i<nivel*2) {
			for(int j=0;j<3;j++){	
				if(i!=0){
					numNivel = i * 10;
				}
			}
			Logeable.LOG_SICV2.info(pasillo+ " "+desdeRack+ " "+numNivel);
			if(i!=5)
				i++;
			else if (i==10) {
				break;
			}
			else
				i=0;
				
		}
			
		
	}
}
