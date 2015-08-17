package ec.com.smx.sic.cliente.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.bodega.EnumEan;
import ec.com.smx.sic.cliente.common.bodega.ValidacionEanUtil;
import ec.com.smx.sic.cliente.exception.ValidadorEanException;

public class TestEAN {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int opcion = 1;
		TestEAN testEan = new TestEAN();
		switch (opcion) {
		case 1:
			testEan.validarEan13();
			break;
		case 2:
			testEan.validarEan14();
			break;
		case 3:
			testEan.validarEan128();
			break;
		case 4:
			testEan.leerDatosDesdeScannerEan13();
			break;
		case 5:
			testEan.leerDatosDesdeScannerEan14();
			break;
		case 6:
			testEan.leerDatosDesdeScannerEan128();
			break;
		case 7:
			testEan.obtenerEan14DesdeEan128();
			break;
		case 8:
			testEan.obtenerEan13DesdeEan14();
			break;	
		case 9:
			testEan.obtenerTipoEan();
			break;	
		case 10:
			testEan.calcularDigitoVerificadorCodigosInternosPesoVariable();
		}
	}

	private void validarEan13() {
		List<String> listCodigosBarras = new ArrayList<String>();
		listCodigosBarras.add("A2010100010012");
		listCodigosBarras.add("A9686893060003");
//		listCodigosBarras.add("123109129823");
//		listCodigosBarras.add("123109129824");
//		listCodigosBarras.add("123109129825");
//		listCodigosBarras.add("123109129826");
//		listCodigosBarras.add("123109129827");
//		listCodigosBarras.add("123109129828");
//		listCodigosBarras.add("123109129829");
//		listCodigosBarras.add("123109129820");
//		listCodigosBarras.add("123109129831");
//		listCodigosBarras.add("123109129832");
//		listCodigosBarras.add("123109129833");
//		listCodigosBarras.add("123109129834");
//		listCodigosBarras.add("123109129835");
//		listCodigosBarras.add("123109129836");
//		listCodigosBarras.add("123109129837");
//		listCodigosBarras.add("123109129838");
//		listCodigosBarras.add("123109129839");
//		listCodigosBarras.add("123109129840");
//		listCodigosBarras.add("123109129811");		
		/*listCodigosBarras.add("A8011607014569");
		listCodigosBarras.add("A7501027273796");
		listCodigosBarras.add("8011607014569");
		listCodigosBarras.add("A01");
		listCodigosBarras.add("8011607014569");
		listCodigosBarras.add("F8011607014569");
		listCodigosBarras.add("F08853347000187");
		listCodigosBarras.add("08853347000187");
		listCodigosBarras.add("1234567891234");
		listCodigosBarras.add("F3355997000296");
		listCodigosBarras.add("333143092682567");
		listCodigosBarras.add("A737052265155");
		listCodigosBarras.add("A737052265292");
		listCodigosBarras.add("A737052265209");
		listCodigosBarras.add("A8011607014569");
		listCodigosBarras.add("A8011607014590");
		listCodigosBarras.add("A8011607014606");
		listCodigosBarras.add("A8011607014620");
		listCodigosBarras.add("A8005026713684");
		listCodigosBarras.add("A85805390402");
		listCodigosBarras.add("A85805390501");
		listCodigosBarras.add("A85805390600");
		listCodigosBarras.add("A8411061801406");
		listCodigosBarras.add("C8411061801406");
		listCodigosBarras.add("A3355992000090");
		listCodigosBarras.add("b33559f2000095");
		listCodigosBarras.add("F8411061801406");*/
		Logeable.LOG_SICV2.info("NUMERO ARTICULOS: " + listCodigosBarras.size());
		Logeable.LOG_SICV2.info("----------------------------------------------------------------------");
		for (String ean : listCodigosBarras) {
			try {
//				int codigo=ValidacionEanUtil.getInstancia().obtenerDigitoVerificador(ean);
//				Logeable.LOG_SICV2.info("\"A" + ean + codigo + "\", ");
				if (ValidacionEanUtil.getInstancia().validarEan(ean, EnumEan.EAN13.getTipo())) {
					Logeable.LOG_SICV2.info("CodigoBarras: " + ean + " v�lido");
				} else {
					Logeable.LOG_SICV2.info("CodigoBarras: " + ean + " No v�lido <--------");
				}
			} catch (Exception e) {
				Logeable.LOG_SICV2.info(e.getMessage());
			}
		}

	}

	private void validarEan14() {
		List<String> listCodigosBarras = new ArrayList<String>();
		listCodigosBarras.add("FF00000000000000");
		/*
		listCodigosBarras.add("F12389091298212");
		listCodigosBarras.add("08853347001269");
		listCodigosBarras.add("F01854554");
		listCodigosBarras.add("");
		listCodigosBarras.add("A08853347001269");
		listCodigosBarras.add("K08853347001269");
		listCodigosBarras.add("A8011607014569");
		listCodigosBarras.add("8011607014569");
		listCodigosBarras.add("12345678912345");
		listCodigosBarras.add("A8011607014569");
		listCodigosBarras.add("08853347000262");
		listCodigosBarras.add("a08853347001030");
		listCodigosBarras.add("F08853g347001192");
		listCodigosBarras.add("z08853347001207");
		listCodigosBarras.add("F088533470yh01221");
		listCodigosBarras.add("F08853347001948");
		listCodigosBarras.add("F08853347001344");
		listCodigosBarras.add("F00843956353116");
		listCodigosBarras.add("F08853347001511");
		listCodigosBarras.add("F08853347000187");
		listCodigosBarras.add("F08853347001139");
		listCodigosBarras.add("F17894993653943");
		listCodigosBarras.add("F17894993666202");
		listCodigosBarras.add("F17894993666440");
		listCodigosBarras.add("F20100200898031");
		listCodigosBarras.add("A77250200815955");
		listCodigosBarras.add("F00546871458544");
		listCodigosBarras.add("K17894993666202");*/
		Logeable.LOG_SICV2.info("NUMERO ARTICULOS: " + listCodigosBarras.size());
		Logeable.LOG_SICV2.info("----------------------------------------------------------------------");
		for (String ean : listCodigosBarras) {
			try {
				if (ValidacionEanUtil.getInstancia().validarEan(ean, EnumEan.EAN14.getTipo())) {
					Logeable.LOG_SICV2.info("CodigoBarras: " + ean + " v�lido");
				} else {
					Logeable.LOG_SICV2.info("CodigoBarras: " + ean + " No v�lido <--------");
				}
			} catch (Exception e) {
				Logeable.LOG_SICV2.info(e.getMessage());
			}
		}
	}

	private void validarEan128() {
		List<String> listCodigosBarras = new ArrayList<String>();
		listCodigosBarras.add("K104512xA");
		listCodigosBarras.add("K15001600");
		listCodigosBarras.add("K0127861006755854(17)130809");
		Logeable.LOG_SICV2.info("NUMERO ARTICULOS: " + listCodigosBarras.size());
		Logeable.LOG_SICV2.info("----------------------------------------------------------------------");
		for (String ean : listCodigosBarras) {
			try {
				if (ValidacionEanUtil.getInstancia().validarEan128(ean, EnumEan.EAN128.getTipo())) {
					Logeable.LOG_SICV2.info("CodigoBarras: " + ean + " v�lido");
				} else {
					Logeable.LOG_SICV2.info("CodigoBarras: " + ean + " No v�lido <--------");
				}
			} catch (Exception e) {
				Logeable.LOG_SICV2.info(e.getMessage());
			}
		}
	}

	private void leerDatosDesdeScannerEan13(){
		BufferedReader br = null;
		String ean = "";
		br = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				ean = br.readLine();
				boolean resultado = ValidacionEanUtil.getInstancia().validarEan(ean, EnumEan.EAN13.getTipo());
				if (resultado){
					Logeable.LOG_SICV2.info(ean);	
				}else{
					Logeable.LOG_SICV2.info("Codigo no valido");
				}
				
			} catch (IOException io) {
				Logeable.LOG_SICV2.error(io.getMessage());
			}catch (ValidadorEanException vee){
				Logeable.LOG_SICV2.info(vee.getMessage());
			}
		} while (!ean.equals("ZZZ"));
	}

	private void leerDatosDesdeScannerEan14(){
		BufferedReader br = null;
		String ean = "";
		br = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				ean = br.readLine();
				boolean resultado = ValidacionEanUtil.getInstancia().validarEan(ean, EnumEan.EAN14.getTipo());
				if (resultado){
					Logeable.LOG_SICV2.info(ean);	
				}else{
					Logeable.LOG_SICV2.info("Codigo no valido");
				}
				
			} catch (IOException io) {
				Logeable.LOG_SICV2.error(io.getMessage());
			}catch (ValidadorEanException vee){
				Logeable.LOG_SICV2.info(vee.getMessage());
			}
		} while (!ean.equals("ZZZ"));
	}

	private void leerDatosDesdeScannerEan128() {
		BufferedReader br = null;
		String ean = "";
		br = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				ean = br.readLine();
				boolean resultado = ValidacionEanUtil.getInstancia().validarEan(ean, EnumEan.EAN128.getTipo());
				if (resultado){
					Logeable.LOG_SICV2.info(ean);	
				}else{
					Logeable.LOG_SICV2.info("Codigo no valido");
				}
			} catch (IOException io) {
				Logeable.LOG_SICV2.error(io.getMessage());
			}catch (ValidadorEanException vee){
				Logeable.LOG_SICV2.info(vee.getMessage());
			}

		} while (!ean.equals("ZZZ"));
	}

	private void obtenerEan14DesdeEan128() {
		BufferedReader br = null;
		String ean = "";
		Logeable.LOG_SICV2.info("------------------------Ingrese un ean128-----------------------");
		br = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				ean = br.readLine();
				String resultado = ValidacionEanUtil.getInstancia().obtenerEan14DesdeEan128(ean);
				Logeable.LOG_SICV2.info(resultado);
			} catch (IOException io) {
				Logeable.LOG_SICV2.error(io.getMessage());
			} catch (ValidadorEanException e) {
				Logeable.LOG_SICV2.info("Error: " + e.getMessage());
			}

		} while (!ean.equals("ZZZ"));
	}
	
	private void obtenerEan13DesdeEan14() {
		BufferedReader br = null;
		String ean = "";
		Logeable.LOG_SICV2.info("------------------------Ingrese un ean14------------------------");
		br = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {

				ean = br.readLine();
				String resultado = ValidacionEanUtil.getInstancia().obtenerEan13DesdeEan14(ean);
				Logeable.LOG_SICV2.info(resultado);
			} catch (IOException io) {
				Logeable.LOG_SICV2.error(io.getMessage());
			} catch (ValidadorEanException vee){
				Logeable.LOG_SICV2.info(vee.getMessage());
			}

		} while (!ean.equals("ZZZ"));
	}

	private void obtenerTipoEan() {
		BufferedReader br = null;
		String ean = "";
		br = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				ean = br.readLine();
				int resultado = ValidacionEanUtil.getInstancia().obtenerTipoEan(ean);
				Logeable.LOG_SICV2.info("{}",resultado);
			} catch (IOException io) {
				Logeable.LOG_SICV2.error(io.getMessage());
			} catch (ValidadorEanException e) {
				Logeable.LOG_SICV2.info("Error: " + e.getMessage());
			}
		} while (!ean.equals("ZZZ"));
	}
	private void calcularDigitoVerificadorCodigosInternosPesoVariable(){
		/*CODIGOS INTERNOS
		 *PRODUCTOS DE PESO VARIABLE
		 *RANGO DESDE 60000 HASTA 69999 
		 * 1.	Se antepone al c�digo el n�mero 2
		 * 2.	Luego se coloca el c�digo del art�culo 60453
		 * 3.	Se completa con 6 ceros o con el precio del art�culo en el caso de las balanzas
		 * 4.	Se calcula el d�gito verificador
		 * 5.	Ejemplo  2604530000000V 
		 */
		String ean ="2604530000000";
		try {
			Logeable.LOG_SICV2.info("Codigos internos RANGO DESDE 60000 HASTA 69999 ");
			int digito = ValidacionEanUtil.getInstancia().obtenerDigitoVerificador(ean);
			Logeable.LOG_SICV2.info("Codigo Interno : " + ean);
			Logeable.LOG_SICV2.info("Digito verificador calculado : " + digito);
			Logeable.LOG_SICV2.info("Ean13 : " + ean.concat(String.valueOf(digito)));	

		} catch (Exception e) {
			Logeable.LOG_SICV2.info(e.getMessage());
		}
	}
	
	public void calcularDigitoVerificadorCodigosInternosPesoFijo(){

		/*CODIGOS INTERNOS
		 *PRODUCTOS DE PESO FIJO
		 *RANGO DESDE 100000 HASTA 799999
		 *1.	Se antepone al c�digo el n�mero 20 
		 *2.	Luego se coloca el c�digo del art�culo 189804
		 *3.	Se completa con 4 ceros
		 *4.	Se calcula el d�gito verificador
		 *5.	Ejemplo  2018980400000V
 		 */
		//String ean ="2018980400000";
		
		/*CODIGOS INTERNOS
		 *PRODUCTOS DE PESO FIJO
		 *RANGO DESDE 5000000000  HASTA 5999999999
		 *1.	Se antepone al c�digo el n�mero 20 
		 *2.	Luego se coloca el c�digo del art�culo 5070400030 
		 *3.	Se calcula el d�gito verificador
		 *4.	Ejemplo  205070400030V
		 */
		try {
			Logeable.LOG_SICV2.info("Codigos internos RANGO DESDE 5000000000  HASTA 5999999999"); 
			String ean ="205070400030";
			int digito = ValidacionEanUtil.getInstancia().obtenerDigitoVerificador(ean);
			Logeable.LOG_SICV2.info("Codigo Interno : " + ean);
			Logeable.LOG_SICV2.info("Digito verificador calculado : " + digito);
			Logeable.LOG_SICV2.info("Ean13 : " + ean.concat(String.valueOf(digito)));	
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.info(e.getMessage());
		}
	}
}