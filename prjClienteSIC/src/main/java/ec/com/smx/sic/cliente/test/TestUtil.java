/**
 * 
 */
package ec.com.smx.sic.cliente.test;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import ec.com.smx.framework.common.util.Util;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.framework.gestor.util.NumberManager;
import ec.com.smx.frameworkv2.multicompany.dto.SystemDto;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.CompradorDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.ContenedorArticulo;
import ec.com.smx.sic.cliente.servicio.articulo.IEstructuraComercialServicio;
/**
 * @author fmunoz
 *
 */
public class TestUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#");
		//df.setMaximumFractionDigits(0);
		//df.setRoundingMode(RoundingMode.DOWN);
		df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
		Logeable.LOG_SICV2.info("{}",df.getDecimalFormatSymbols().getDecimalSeparator());
		double d = 345.9999999999;
		Logeable.LOG_SICV2.info("int value: "+Double.valueOf(d).intValue());
		//Logeable.LOG_SICV2.info("formateado: "+df.format(d));
		redondeoTest(d);
		//Logeable.LOG_SICV2.info("formateado: "+Math.floor(d * 100)/100);
		//prueba2(); 
		Logeable.LOG_SICV2.info(SICUtil.getInstance().addCodeBarRestrictionByDate("ab", "d.fechaRegistro"));
		
		Collection<ArticuloDTO> articulos = new ArrayList<ArticuloDTO>();
		ArticuloDTO a1 = new ArticuloDTO();
		a1.setDescripcionArticulo("uno");
		articulos.add(a1);
		ArticuloDTO a2 = new ArticuloDTO();
		a2.setDescripcionArticulo("dos");
		articulos.add(a2);
		ArticuloDTO a3 = new ArticuloDTO();
		a3.setDescripcionArticulo("tres");
		articulos.add(a3);
		
		Collection<ArticuloDTO> nuevos = (Collection<ArticuloDTO>) SerializationUtils.clone((Serializable)articulos);
		nuevos.add(new ArticuloDTO());
		iterarArticulos(articulos);
		iterarArticulos(nuevos);
		
		Logeable.LOG_SICV2.info("size 1: "+articulos.size());
//		acepta(new HashSet<ArticuloDTO>(articulos));
		Logeable.LOG_SICV2.info("INTEGER: "+Integer.MAX_VALUE + ", LONG: "+Long.MAX_VALUE);
//		HashSet<ArticuloDTO> set = new HashSet<ArticuloDTO>(articulos);
//		Collection<ArticuloDTO> artcol = ColeccionesUtil.sort(set, ColeccionesUtil.ORDEN_ASC, "descripcionArticulo");
//		for(ArticuloDTO art : artcol){
//			Logeable.LOG_SICV2.info("descripcion: "+art.getDescripcionArticulo());
//		}
		
		//String numero = "2058263452699";
		String numero = "502020110";
		Logeable.LOG_SICV2.info("sin ceros: "+StringUtils.stripStart(numero,"0"));
		Logeable.LOG_SICV2.info("SUBSTRING: "+ numero.substring(0,1));
		Logeable.LOG_SICV2.info("char at: "+ numero.charAt(2));
		Logeable.LOG_SICV2.info("RIGHT PAD: "+StringUtils.rightPad(numero, 12, "0"));
		Logeable.LOG_SICV2.info("LEFT PAD: "+(Double.valueOf(StringUtils.leftPad("", 7, "9")) + 0.99d) ); 
		//Logeable.LOG_SICV2.info(numero.substring(2,4));
		Logeable.LOG_SICV2.info("inicial: "+numero + ", MAX: "+SICArticuloCalculo.getInstancia().obtenerCodigoEstructuraComercialMAX(numero));
		Logeable.LOG_SICV2.info("inicial: "+numero + ", SIC: "+SICArticuloCalculo.getInstancia().obtenerCodigoEstructuraComercialSIC(numero));
		
		double dd=3.00000000000000;
		Logeable.LOG_SICV2.info("truncado("+dd+"): "+Math.floor(dd));
		
		String ruta ="C:\\SmxLibrerias\\Archivos\\Max\\Migracion\\Archivo\\AAG.TXT";
		String rutaDir = ruta.substring(0, ruta.lastIndexOf(File.separator));
		
		Logeable.LOG_SICV2.info("nueva ruta: "+rutaDir);
		File f = new File(rutaDir);
		for(File file : f.listFiles()){
			Logeable.LOG_SICV2.info(file.getName()+": "+(file.getName().endsWith(".txt") || file.getName().endsWith(".TXT")));
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		File f1 = new File(ruta);
		String nuevoNombre = f1.getName().substring(0,f1.getName().lastIndexOf("."));
		String extension = f1.getName().substring(f1.getName().lastIndexOf("."),f1.getName().length());
		nuevoNombre = nuevoNombre.concat("-").concat(String.valueOf(System.currentTimeMillis()));
		Logeable.LOG_SICV2.info("nombre: "+nuevoNombre+",ext: "+extension);
		
		/*File f2 = new File(rutaDir.concat(File.separator).concat("Procesados").concat(File.separator).concat(sdf.format(new Date())).concat(File.separator)
					.concat(nuevoNombre.concat(extension)));
		try{
			FileUtils.moveFile(f1, f2);
		}catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
		}*/
		
		/*Logeable.LOG_SICV2.info("files: "+f.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File paramFile, String paramString) {
				Logeable.LOG_SICV2.info("name: "+paramFile.getName());
				return paramFile.getName().startsWith("AAG");
			}
		}).length);*/
		
		//Logeable.LOG_SICV2.info("ddwewe".matches("dd[a-zA-Z0-9]"));
		//divion2();
		
		df.setMaximumFractionDigits(5);
		//Double d2 = SICUtil.getInstance().roundNumber(7.21 * (1 + 12d/100), SICConstantes.getInstancia().CANTIDADDECIMALINICIAL);
		Double d2 = SICUtil.getInstance().roundNumber(434343.43434d, SICConstantes.getInstancia().CANTIDADDECIMALFINAL);
		//Double d2 = 1399.0032;
		for(int i=SICConstantes.getInstancia().CANTIDADDECIMALINICIAL-1;i>=SICConstantes.getInstancia().CANTIDADDECIMALFINAL;i--){
			Logeable.LOG_SICV2.info("intermedio: "+d2);
			df.setMaximumFractionDigits(i);
			//d2 = Double.valueOf(df.format(d2));
			d2 = Double.valueOf(SICUtil.getInstance().roundNumber(d2, i));
		}
		//2012-08-08 21:43:47.823
		Logeable.LOG_SICV2.info("final con iva: "+d2);
		Logeable.LOG_SICV2.info("final no afiliado: "+Util.roundDoubleMath(d2 * (1 + 5d/100),SICConstantes.getInstancia().CANTIDADDECIMALFINAL));
		try{Logeable.LOG_SICV2.info("truncado: "+NumberManager.truncateNumber(5.10,SICConstantes.getInstancia().CANTIDADDECIMALFINAL));}catch (Exception e) {Logeable.LOG_SICV2.error(e.getMessage());};
		
		sdf.applyPattern("HH.mm.ss");
		Logeable.LOG_SICV2.info(sdf.format(new Timestamp(1344518035908l)));
		//Logeable.LOG_SICV2.info(new Timestamp(1344480227823l));

		CompradorDTO c = new CompradorDTO();
		c.setAreaReferencia("ddd");
		pruebaClone(c);
		Logeable.LOG_SICV2.info("referencia: "+c.getAreaReferencia());
		
		//calcular margen
		//calcularMargenPrecio(45d,0d);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, 2012);
		cal2.set(Calendar.MONTH, Calendar.DECEMBER);
		cal2.set(Calendar.DAY_OF_MONTH, 27);
		
		Logeable.LOG_SICV2.info("cal2: "+cal.getTime());
		
		Logeable.LOG_SICV2.info("iguales: "+(cal.getTimeInMillis() == cal2.getTimeInMillis()));
		
		Double dob = (double)7/3;
		Logeable.LOG_SICV2.info("dob: "+dob);

	}
	
	@Test
	public void test1(){
		try{
			ClaseArticuloDTO c1 = new ClaseArticuloDTO();
			c1.setDescription("c1");
			ClaseArticuloDTO c2 = new ClaseArticuloDTO();
			c2.setDescription("c2");
			Collection<ArticuloDTO> acol = new ArrayList<ArticuloDTO>();
			ArticuloDTO a = new ArticuloDTO();
			a.setDescripcionArticulo("a1");
			a.setClaseArticuloDTO(c1);
			acol.add(a);
			
			a = new ArticuloDTO();
			a.setDescripcionArticulo("a2");
			a.setClaseArticuloDTO(c1);
			acol.add(a);
			
			a = new ArticuloDTO();
			a.setDescripcionArticulo("a3");
			a.setClaseArticuloDTO(c2);
			acol.add(a);
			
			a = new ArticuloDTO();
			//a.setDescripcionArticulo("a4");
			a.setClaseArticuloDTO(c2);
			acol.add(a);
			
			a = new ArticuloDTO();
			//a.setDescripcionArticulo("a5");
			a.setClaseArticuloDTO(c1);
			acol.add(a);
			
			Set<String> clases = new HashSet<String>(CollectionUtils.collect(acol, new Transformer() {
				@Override
				public Object transform(Object arg0) {
					return ((ArticuloDTO)arg0).getDescripcionArticulo() == null ? "." : ((ArticuloDTO)arg0).getDescripcionArticulo();
				}
			}));
			for(String clase : clases){
				Logeable.LOG_SICV2.info(clase);
			}
		
			ArticuloDTO a2 = new ArticuloDTO();
			a2.setArticulos(acol);
			Logeable.LOG_SICV2.info("{}",a2.getArticulos());
			ArticuloDTO a3 = SerializationUtils.clone(a2);
			Logeable.LOG_SICV2.info("{}",a3.getArticulos());
			a2.getArticulos().add(new ArticuloDTO());
			Logeable.LOG_SICV2.info("{}",a2.getArticulos());
			Logeable.LOG_SICV2.info("{}",a3.getArticulos());
			a2 = a3;
			Logeable.LOG_SICV2.info("{}",a2.getArticulos());
			
			Collection<ArticuloDTO> col = null;
			ArticuloDTO finded = (ArticuloDTO)CollectionUtils.find(col, new Predicate() {
				@Override
				public boolean evaluate(Object paramObject) {
					return ((ArticuloDTO)paramObject).getTieneArticuloAgrupador();
				}
			});
			Logeable.LOG_SICV2.info("finded: "+finded);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("1", "uno");
			map.put("2", "dos");
			map.put("1", "uno");
			Logeable.LOG_SICV2.info("{}",map.size());
			for(String s : map.keySet()){
				Logeable.LOG_SICV2.info(map.get(s));
			}
			verificarCODBAR(null);
			
			//EnumAlertaImportacionArticulo e = EnumAlertaImportacionArticulo.CODIGOBARRAS_DIFERENTE;
			//Logeable.LOG_SICV2.info("codigo barras 1: "+e.getCodigoBarras());
			//e.setCodigoBarras("pruebas");
			//Logeable.LOG_SICV2.info("codigo barras 1: "+e.getCodigoBarras());
			//Logeable.LOG_SICV2.info("codigo barras 2: "+EnumAlertaImportacionArticulo.CODIGOBARRAS_DIFERENTE.getCodigoBarras());
			
//			DecimalFormat df = new DecimalFormat("#.00",DecimalFormatSymbols.getInstance(Locale.US));
//			Double d1 = Double.valueOf(StringUtils.leftPad("", 9, UtilIntegracion.NUMERO_COMPLETAR)) + 0.99d;
//			Double d2 = 0d;
//			Long l1 = Long.valueOf(StringUtils.leftPad("", 14, UtilIntegracion.NUMERO_COMPLETAR));
//			Logeable.LOG_SICV2.info("d1: "+df.format(d1));
//			Logeable.LOG_SICV2.info("d2: "+StringUtils.leftPad(StringUtils.remove(df.format(d2),"."),4,"0"));
//			Logeable.LOG_SICV2.info("l1: "+l1);
		}catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	
	@Test
	public void test2(){
		try{
			Collection<String> coleccion = new ArrayList<String>();
			for(int i = 1;i<=754;i++){
				coleccion.add(String.valueOf(i));
			}
			int inicio = 0;
			int fin = SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
			int iteraciones = 1;
			int residuo = 0;
			iteraciones = coleccion.size() / SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
			residuo = coleccion.size() % SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
			Collection<String> subcoleccion = coleccion;
			if(iteraciones == 0){
				iteraciones = 1;
			}else if(residuo > 0){
				iteraciones++;
			}
			Logeable.LOG_SICV2.info("iteraciones: "+iteraciones);
			Logeable.LOG_SICV2.info("residuo: "+residuo);
			
			//se envia los datos particionados
			for(int i = 1; i<=iteraciones;i++){
				if(iteraciones > 1){
					if(iteraciones > i){
						subcoleccion = ((List<String>)coleccion).subList(inicio, fin);
					}else{
						subcoleccion = ((List<String>)coleccion).subList(inicio, coleccion.size());
					}
				}
				Logeable.LOG_SICV2.info("inicio "+inicio+", fin: "+fin);
				inicio = inicio + SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
				fin = fin + SICArticuloConstantes.getInstancia().CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO.intValue();
				Logeable.LOG_SICV2.info(StringUtils.join(subcoleccion, ","));
			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	
	public static void prueba(){
		try{
		Collection<String> codigos= new ArrayList<String>();
		codigos.add("1000");
		codigos.add("2226");
		Collection<String> codigosUsuarios = new ArrayList<String>();
		codigosUsuarios.add("SISPE2");
		codigosUsuarios.add("SISPE103");		
		IEstructuraComercialServicio a = SICFactory.getInstancia().articulo.getEstructuraComercialService();
		Logeable.LOG_SICV2.info("{}",a);
		a.desactivarEstadoPorClasificacionUsuario(codigosUsuarios, codigos, 1);
		}catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	private static void verificarCODBAR(String ean){
		Long.valueOf("99999999999999");
		Logeable.LOG_SICV2.info(ean + " es EAN: "+(new ValidatorImpl()).validateEAN(ean));
	}
	
	public static void prueba2(){
		Logeable.LOG_SICV2.info("pruebaSpring");
		Collection<SystemDto> parametros = SICFactory.getInstancia().administracion.getParametroService().obtenerSistemasParametro(1);
		for(SystemDto dto:parametros){
			Logeable.LOG_SICV2.info(dto.getSystemDescription());
		}
	}
	
	private static void iterarArticulos(Collection<? extends ContenedorArticulo> col) {
		Logeable.LOG_SICV2.info("antes de iterar");
		for(ContenedorArticulo iart : col){
			ArticuloDTO dto = iart.getArticuloContenido();
			Logeable.LOG_SICV2.info("descripcion: "+dto.getDescripcionArticulo());
			dto.setClaseArticulo("a");
		}
	}
	
	
	/**
	 * Retorna el precio de caja usando el precio unitario base y la unidad de manejo 
	 */
	public static Double calcularPrecioMayorista(Double descuento, Double precioBase){
		try{
			Double precioMayorista = precioBase;
			if(descuento != null)
				precioMayorista = precioMayorista * (1 - descuento/100);
			//return precioMayorista;
			return NumberManager.truncateNumber(precioMayorista, SICConstantes.getInstancia().CANTIDADDECIMALFINAL);
		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}
	
	public static void pruebaClone(CompradorDTO cAux){
		CompradorDTO c = cAux;
		CompradorDTO c2 = SerializationUtils.clone(c);
		c2.setAreaReferencia("tra");
		c = c2;
		Logeable.LOG_SICV2.info("referencia: "+c.getAreaReferencia());
	}
	
	public static void redondeoTest(Double value) {
		try {
			BigDecimal tstBd = BigDecimal.valueOf(value);
			Double valorFinal = tstBd.setScale(2, RoundingMode.DOWN).doubleValue();
			Logeable.LOG_SICV2.info("redondeo test: "+ valorFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	public static Double calcularMargenPrecio(Double costoNeto, Double precio){
		ArticuloPrecioDTO ap = new ArticuloPrecioDTO();
		 if(costoNeto != null && precio != null)
			ap.setMargenPrecio(SICUtil.getInstance().roundNumber((1 - costoNeto/precio)*100, SICConstantes.getInstancia().CANTIDADDECIMALFINAL));
		else
			ap.setMargenPrecio(null);
		return ap.getMargenPrecio();
	}
}

