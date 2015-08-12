package ec.com.smx.sic.webservices.inventario;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.com.smx.framework.ad.json.JsonPojoMapper;
import ec.com.smx.sic.cliente.exception.SICException;


/**
 * web service para la visualizacion de kardex
 * @author bomontesdeoca
 * 10/11/2014	
 */
@Controller
@RequestMapping("/ws/inventarioKardex")
@Scope(value = "request")
public class KardexWebService {

	public String getMesLetras(int mes){
		if (mes==1){
			return "Enero";
		}
		if (mes==2){
			return "Febrero";
		}
		if (mes==3){
			return "Marzo";
		}
		if (mes==4){
			return "Abril";
		}
		if (mes==5){
			return "Mayo";
		}
		if (mes==6){
			return "Junio";
		}
		if (mes==7){
			return "Julio";
		}
		if (mes==8){
			return "Agosto";
		}
		if (mes==9){
			return "Septiembre";
		}
		if (mes==10){
			return "Octubre";
		}
		if (mes==11){
			return "Noviembre";
		}
		if (mes==12){
			return "Diciembre";
		}
		return "";
	}




	// retorna una fila con el mes y el anio seleccionados para visualizar el detalle del kardex

	@RequestMapping(value = "/filaKardexAnioMes", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody
	ResponseEntity<String> getFilaResumenKardexAnioMes(
			@RequestParam(value = "index", required = true) String index,
			@RequestParam(value = "anio", required = true) String anio,
			@RequestParam(value = "mes", required = true) Integer mes) {

		LOG_SICV2.info("Inicio web service find resumen kardex, anio", anio+" mes: {}", mes);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Type", "text/html; charset=utf-8");

		return new ResponseEntity<String>(getFilaKardexAnioMesFormatoJSON(anio,mes,index), headers, HttpStatus.OK);
	}

	public String getFilaKardexAnioMesFormatoJSON(String anio, Integer mes,String indexInicial) throws SICException{
		try{


			Collection<resumenKardexDTO> respForm=new ArrayList<KardexWebService.resumenKardexDTO>();
			Integer index = 1;
			resumenKardexDTO rk=new resumenKardexDTO();
			rk.setIndex(indexInicial+"."+index);
			rk.setId(indexInicial+"."+index);
			rk.setAnio(anio);
			rk.setMes(getMesLetras(mes));
			rk.setMesNumero(mes);
			respForm.add(rk);
			index++;

			return JsonPojoMapper.getInstance().writeValueAsString(respForm);
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);

		}

	}



	// inner class para la visualizar el kardex
	public class resumenKardexDTO {


		private String id;
		private String index;
		private Integer codCompania;
		private Integer codigoAreaTrabajo;
		private Integer valorUnidadManejo;

		private Boolean hijo;

		private String anio;
		private String mes;
		private Integer mesNumero;

		private String codArticulo;

		private String cantidadExistenciaAnterior;
		private String cantidadExistenciaActual;
		private String cantidadTotalIngresos;
		private String cantidadTotalEgresos;

		private String pesoExistenciaAnterior;
		private String pesoExistenciaActual;
		private String pesoTotalIngresos;
		private String pesoTotalEgresos;

		private String[] lisTransacciones;

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getIndex() {
			return index;
		}
		public void setIndex(String index) {
			this.index = index;
		}
		public String getCantidadTotalIngresos() {
			return cantidadTotalIngresos;
		}
		public void setCantidadTotalIngresos(String cantidadTotalIngresos) {
			this.cantidadTotalIngresos = cantidadTotalIngresos;
		}
		public String getCantidadTotalEgresos() {
			return cantidadTotalEgresos;
		}
		public void setCantidadTotalEgresos(String cantidadTotalEgresos) {
			this.cantidadTotalEgresos = cantidadTotalEgresos;
		}
		public String getCantidadExistenciaActual() {
			return cantidadExistenciaActual;
		}
		public void setCantidadExistenciaActual(String cantidadExistenciaActual) {
			this.cantidadExistenciaActual = cantidadExistenciaActual;
		}
		public String getAnio() {
			return anio;
		}
		public void setAnio(String anio) {
			this.anio = anio;
		}
		public String getMes() {
			return mes;
		}
		public void setMes(String mes) {
			this.mes = mes;
		}
		public String getCantidadExistenciaAnterior() {
			return cantidadExistenciaAnterior;
		}
		public void setCantidadExistenciaAnterior(String cantidadExistenciaAnterior) {
			this.cantidadExistenciaAnterior = cantidadExistenciaAnterior;
		}
		public String getPesoExistenciaAnterior() {
			return pesoExistenciaAnterior;
		}
		public void setPesoExistenciaAnterior(String pesoExistenciaAnterior) {
			this.pesoExistenciaAnterior = pesoExistenciaAnterior;
		}
		public String getPesoExistenciaActual() {
			return pesoExistenciaActual;
		}
		public void setPesoExistenciaActual(String pesoExistenciaActual) {
			this.pesoExistenciaActual = pesoExistenciaActual;
		}
		public String getPesoTotalIngresos() {
			return pesoTotalIngresos;
		}
		public void setPesoTotalIngresos(String pesoTotalIngresos) {
			this.pesoTotalIngresos = pesoTotalIngresos;
		}
		public String getPesoTotalEgresos() {
			return pesoTotalEgresos;
		}
		public void setPesoTotalEgresos(String pesoTotalEgresos) {
			this.pesoTotalEgresos = pesoTotalEgresos;
		}
		public String getCodArticulo() {
			return codArticulo;
		}
		public void setCodArticulo(String codArticulo) {
			this.codArticulo = codArticulo;
		}

		public Boolean getHijo() {
			return hijo;
		}
		public void setHijo(Boolean hijo) {
			this.hijo = hijo;
		}
		public Integer getMesNumero() {
			return mesNumero;
		}
		public void setMesNumero(Integer mesNumero) {
			this.mesNumero = mesNumero;
		}
		public Integer getCodCompania() {
			return codCompania;
		}
		public void setCodCompania(Integer codCompania) {
			this.codCompania = codCompania;
		}
		public Integer getCodigoAreaTrabajo() {
			return codigoAreaTrabajo;
		}
		public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
			this.codigoAreaTrabajo = codigoAreaTrabajo;
		}
		public Integer getValorUnidadManejo() {
			return valorUnidadManejo;
		}
		public void setValorUnidadManejo(Integer valorUnidadManejo) {
			this.valorUnidadManejo = valorUnidadManejo;
		}
		public String[] getLisTransacciones() {
			return lisTransacciones;
		}
		public void setLisTransacciones(String[] lisTransacciones) {
			this.lisTransacciones = lisTransacciones;
		}
	}
	
	
//	private List<String> lisColumnasTransacciones;
//
//
//
//	// servicio que se consume cuando se acciona el boton buscar del arbol busqueda de kardex   
//	// consulta el resumen de kardex por compania,articulo,anios(Ej: 2012,2013,2014),area de trabajo y unidad de manejo
//	@RequestMapping(value = "/resumenKardexAnios", method = RequestMethod.GET, headers = "Accept= application/json")
//	public @ResponseBody
//	ResponseEntity<String> findResumenKardexAnios(
//			@RequestParam(value = "codigoAreaTrabajo", required = true) Integer codigoAreaTrabajo,
//			@RequestParam(value = "valorUnidadManejo", required = true) Integer valorUnidadManejo,
//			@RequestParam(value = "codigoArticulo", required = true) String codigoArticulo,
//			@RequestParam(value = "codigoCompania", required = true) String codigoCompania,
//			@RequestParam(value = "anios", required = true) String anios,
//			@RequestParam(value = "columnsTransacciones", required = true) String columnsTransacciones) {
//
//		LOG_SICV2.info("Inicio web service find resumen kardex, codigoArticulo", codigoArticulo+" codigoCompania: {}", codigoCompania);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/html; charset=utf-8");
//		cargarListaColumnasTransacciones(columnsTransacciones);
//		return new ResponseEntity<String>(consultaResumenKardexSoloAniosFormatoJSON(codigoCompania,codigoArticulo,codigoAreaTrabajo,valorUnidadManejo,anios), headers, HttpStatus.OK);
//	}
//
//	public String consultaResumenKardexSoloAniosFormatoJSON(String codigoCompania, String codigoArticulo,Integer codigoAreaTrabajo,Integer valorUnidadManejo,String anios) throws SICException{
//		try{
//
//			String[] vecAnios=anios.split(",");
//			Collection<resumenKardexDTO> respForm=new ArrayList<KardexWebService.resumenKardexDTO>();
//			int cont=0;
//			Integer index = 1;
//			for (int i = 0; i < vecAnios.length; i++) {
//				List<ODocument> lisODoc=InventarioFactory.getInstancia().getInventarioKardexServicio().findResumenKardex(Integer.parseInt(codigoCompania),codigoArticulo,codigoAreaTrabajo,valorUnidadManejo,vecAnios[i]);
//
//				for (ODocument fila:lisODoc) {
//
//					resumenKardexDTO rk=new resumenKardexDTO();
//					rk.setIndex(index+"");
//					rk.setId(cont+1+"");
//					rk.setCodCompania(Integer.parseInt(codigoCompania));
//					rk.setCodigoAreaTrabajo(Integer.parseInt(String.valueOf(fila.field("codigoAreaTrabajo"))));
//					rk.setValorUnidadManejo(Integer.parseInt(String.valueOf(fila.field("valorUnidadManejo"))));
//					rk.setCodArticulo(codigoArticulo);
//					rk.setAnio(String.valueOf(fila.field("anio")));
//
//					rk.setLisTransacciones(llenarListaTransacciones((List<ODocument>)fila.field("listTransaccion")));
//					
//					rk.setCantidadExistenciaAnterior(fila.field("cantidadExistenciaAnterior")==null?"":String.valueOf(fila.field("cantidadExistenciaAnterior")));
//					rk.setCantidadExistenciaActual(fila.field("cantidadExistenciaActual")==null?"":String.valueOf(fila.field("cantidadExistenciaActual")));
//					rk.setCantidadTotalEgresos(fila.field("cantidadTotalEgresos")==null?"":String.valueOf(fila.field("cantidadTotalEgresos")));
//					rk.setCantidadTotalIngresos(fila.field("cantidadTotalIngresos")==null?"":String.valueOf(fila.field("cantidadTotalIngresos")));
//					rk.setPesoExistenciaAnterior(fila.field("pesoExistenciaAnterior")==null?"":String.valueOf(fila.field("pesoExistenciaAnterior")));
//					rk.setPesoExistenciaActual(fila.field("pesoExistenciaActual")==null?"":String.valueOf(fila.field("pesoExistenciaActual")));
//					rk.setPesoTotalEgresos(fila.field("pesoTotalEgresos")==null?"":String.valueOf(fila.field("pesoTotalEgresos")));
//					rk.setPesoTotalIngresos(fila.field("pesoTotalIngresos")==null?"":String.valueOf(fila.field("pesoTotalIngresos")));
//
//					rk.setHijo(Boolean.FALSE);
//					respForm.add(rk);
//					cont++;
//					index++;
//				}
//			}
//			return JsonPojoMapper.getInstance().writeValueAsString(respForm);
//		} catch (Exception e) {
//			LOG_SICV2.error("Error: {}", e);
//			throw new SICException(e);
//
//		}
//
//	}
//	private String[] llenarListaTransacciones(List<ODocument> lisTransaciones){
//
//		if (lisTransaciones!=null && lisTransaciones.size()>0 ){
//			String[] lisT=new String[lisTransaciones.size()];
//			int cont=0;
//			boolean insertado;
//			for(String idColumnaTransaccion:lisColumnasTransacciones){
//				insertado=false;
//
//				for (int i = 0; i < lisTransaciones.size(); i++) {
//					ODocument oDoc=(ODocument)lisTransaciones.get(i);
//					if (idColumnaTransaccion.equalsIgnoreCase(String.valueOf(oDoc.field("codigoTransaccion")))){
//						lisT[cont]=String.valueOf(oDoc.field("cantidadEjecucion"));
//						cont++;
//						insertado=true;
//						lisTransaciones.remove(i);
//						break;
//					}
//				}
//				if (!insertado){
//					lisT[cont]="0";
//					cont++;
//				}
//
//			}
//			return lisT;
//
//		}else{
//			if (lisColumnasTransacciones!=null){
//			String[] lisT=new String[lisColumnasTransacciones.size()];
//			int cont=0;
//			for(String idColumnaTransaccion:lisColumnasTransacciones){
//				lisT[cont]="0";
//				cont++;
//			}
//			return lisT;
//			}else{
//				return new String[0];
//			}
//		}
//
//	}
//
//	private void cargarListaColumnasTransacciones(String columnsTransacciones){
//		
//		if (columnsTransacciones!=null && !columnsTransacciones.isEmpty()){
//		String[] vecColTra=columnsTransacciones.split(",");
//		lisColumnasTransacciones = new ArrayList<String>();
//		for (int i = 0; i < vecColTra.length; i=i+2) {
//			lisColumnasTransacciones.add(vecColTra[i]);
//		}
//		}
//	}
//
//
//
//	// servicio que se consume cuando se presiona en el expand(+) del anio del arbol de visualizacion de kardex 
//	// consulta en el resumen de kardex por compania,articulo,anio,mes,area de trabajo y unidad de manejo
//	@RequestMapping(value = "/getMesesResumenKardexArticulo", method = RequestMethod.GET, headers = "Accept= application/json")
//	public @ResponseBody
//	ResponseEntity<String> getMesesResumenKardexArticulo(
//			@RequestParam(value = "index", required = true) String index,
//			@RequestParam(value = "anio", required = true) String anio,
//			@RequestParam(value = "meses", required = true) String meses,
//			@RequestParam(value = "codigoAreaTrabajo", required = true) Integer codigoAreaTrabajo,
//			@RequestParam(value = "valorUnidadManejo", required = true) Integer valorUnidadManejo,
//			@RequestParam(value = "codigoArticulo", required = true) String codigoArticulo,
//			@RequestParam(value = "codigoCompania", required = true) String codigoCompania,
//			@RequestParam(value = "columnsTransacciones", required = true) String columnsTransacciones) {
//
//
//
//		Long timeIni=System.currentTimeMillis();
//
//		LOG_SICV2.info("Inicio web service find resumen kardex meses, codigoArticulo", codigoArticulo+" codigoCompania: {}", codigoCompania);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/html; charset=utf-8");
//		cargarListaColumnasTransacciones(columnsTransacciones);
//
//		ResponseEntity<String> res=new ResponseEntity<String>(getMesesResumenKardexArticuloFormatoJSON(codigoCompania,anio,meses,codigoArticulo,index,codigoAreaTrabajo,valorUnidadManejo), headers, HttpStatus.OK);
//
//		Long timeFin=System.currentTimeMillis();
//
//		LOG_SICV2.info("tiempo total "+(timeFin-timeIni));
//
//		return res; 
//
//	}
//
//
//
//	public String getMesesResumenKardexArticuloFormatoJSON(String codigoCompania, String anio,String mesesFiltro,String codigoArticulo,String indexInicial,Integer codigoAreaTrabajo,Integer valorUnidadManejo) throws SICException{
//		try{
//			Long timeIni=System.currentTimeMillis();
//			Integer index=1;
//			Collection<resumenKardexDTO> respForm=new ArrayList<KardexWebService.resumenKardexDTO>();
//			List<ODocument> oDoc=InventarioFactory.getInstancia().getInventarioKardexServicio().findResumenKardex(Integer.parseInt(codigoCompania),codigoArticulo,codigoAreaTrabajo,valorUnidadManejo,anio);
//			Long timeFin=System.currentTimeMillis();
//			LOG_SICV2.info("tiempo total en consultar "+(timeFin-timeIni));
//			timeIni=System.currentTimeMillis();
//			if(oDoc.size()>0) {
//				resumenKardexDTO rk;
//
//				List<ODocument> oDocMeses=(List<ODocument>)oDoc.get(0).field("listMonth");//lista que contiene los meses
//
//				if (oDocMeses.size()>0){
//					index=oDocMeses.size();
//					int mes;
//					if (mesesFiltro!=null && !mesesFiltro.isEmpty()){
//						int [] lisMesesFiltro=getArrayMesesSeleccionadosFiltro(mesesFiltro);
//						if (oDocMeses.size()>lisMesesFiltro.length){
//							index=lisMesesFiltro.length;	
//						}
//
//						for (int i = 0; i < lisMesesFiltro.length; i++) {
//							for (ODocument filaMes:oDocMeses) {
//								mes=Integer.parseInt(String.valueOf(filaMes.field("month")))+1;
//								if (mes==lisMesesFiltro[i]){
//									rk=new resumenKardexDTO();
//									rk.setIndex(indexInicial+"."+index);
//									rk.setId(indexInicial+"."+index);
//									rk.setCodCompania(Integer.parseInt(codigoCompania));
//									rk.setCodArticulo(codigoArticulo);
//									rk.setCodigoAreaTrabajo(Integer.parseInt(String.valueOf(oDoc.get(0).field("codigoAreaTrabajo"))));
//									rk.setValorUnidadManejo(Integer.parseInt(String.valueOf(oDoc.get(0).field("valorUnidadManejo"))));
//									rk.setHijo(Boolean.TRUE);
//									rk.setAnio(String.valueOf(oDoc.get(0).field("anio")));
//									rk.setMes(getMesLetras(mes));
//									rk.setMesNumero(mes);
//									rk.setLisTransacciones(llenarListaTransacciones((List<ODocument>)filaMes.field("listTransaccion")));
//									rk.setCantidadExistenciaAnterior(filaMes.field("cantidadExistenciaAnterior")==null?"":String.valueOf(filaMes.field("cantidadExistenciaAnterior")));
//									rk.setCantidadExistenciaActual(filaMes.field("cantidadExistenciaActual")==null?"":String.valueOf(filaMes.field("cantidadExistenciaActual")));
//									rk.setCantidadTotalEgresos(filaMes.field("cantidadTotalEgresos")==null?"":String.valueOf(filaMes.field("cantidadTotalEgresos")));
//									rk.setCantidadTotalIngresos(filaMes.field("cantidadTotalIngresos")==null?"":String.valueOf(filaMes.field("cantidadTotalIngresos")));
//									rk.setPesoExistenciaAnterior(filaMes.field("pesoExistenciaAnterior")==null?"":String.valueOf(filaMes.field("pesoExistenciaAnterior")));
//									rk.setPesoExistenciaActual(filaMes.field("pesoExistenciaActual")==null?"":String.valueOf(filaMes.field("pesoExistenciaActual")));
//									rk.setPesoTotalEgresos(filaMes.field("pesoTotalEgresos")==null?"":String.valueOf(filaMes.field("pesoTotalEgresos")));
//									rk.setPesoTotalIngresos(filaMes.field("pesoTotalIngresos")==null?"":String.valueOf(filaMes.field("pesoTotalIngresos")));
//
//									respForm.add(rk);
//									index--;
//									break;
//								}
//							}
//						}
//
//					}else{
//						// muestra de todos los meses en el cual existan movimientos
//						for (ODocument filaMes:oDocMeses) {
//							mes=Integer.parseInt(String.valueOf(filaMes.field("month")))+1;
//							rk=new resumenKardexDTO();
//							rk.setIndex(indexInicial+"."+index);
//							rk.setId(indexInicial+"."+index);
//							rk.setCodCompania(Integer.parseInt(codigoCompania));
//							rk.setCodArticulo(codigoArticulo);
//							rk.setCodigoAreaTrabajo(Integer.parseInt(String.valueOf(oDoc.get(0).field("codigoAreaTrabajo"))));
//							rk.setValorUnidadManejo(Integer.parseInt(String.valueOf(oDoc.get(0).field("valorUnidadManejo"))));
//							rk.setHijo(Boolean.TRUE);
//							rk.setAnio(String.valueOf(oDoc.get(0).field("anio")));
//							rk.setMes(getMesLetras(mes));
//							rk.setMesNumero(mes);
//							rk.setCantidadExistenciaAnterior(filaMes.field("cantidadExistenciaAnterior")==null?"":String.valueOf(filaMes.field("cantidadExistenciaAnterior")));
//							rk.setCantidadExistenciaActual(filaMes.field("cantidadExistenciaActual")==null?"":String.valueOf(filaMes.field("cantidadExistenciaActual")));
//							rk.setCantidadTotalEgresos(filaMes.field("cantidadTotalEgresos")==null?"":String.valueOf(filaMes.field("cantidadTotalEgresos")));
//							rk.setCantidadTotalIngresos(filaMes.field("cantidadTotalIngresos")==null?"":String.valueOf(filaMes.field("cantidadTotalIngresos")));
//							rk.setPesoExistenciaAnterior(filaMes.field("pesoExistenciaAnterior")==null?"":String.valueOf(filaMes.field("pesoExistenciaAnterior")));
//							rk.setPesoExistenciaActual(filaMes.field("pesoExistenciaActual")==null?"":String.valueOf(filaMes.field("pesoExistenciaActual")));
//							rk.setPesoTotalEgresos(filaMes.field("pesoTotalEgresos")==null?"":String.valueOf(filaMes.field("pesoTotalEgresos")));
//							rk.setPesoTotalIngresos(filaMes.field("pesoTotalIngresos")==null?"":String.valueOf(filaMes.field("pesoTotalIngresos")));
//							respForm.add(rk);
//							index--;
//						}
//					}
//
//				}
//			}
//			String resp= JsonPojoMapper.getInstance().writeValueAsString(respForm);
//			timeFin=System.currentTimeMillis();
//
//			LOG_SICV2.info("tiempo total en el metodo "+(timeFin-timeIni));
//			return resp;
//
//		} catch (Exception e) {
//			LOG_SICV2.error("Error: {}", e);
//			throw new SICException(e);
//
//		}
//
//	}
//
//
//
//	public int[] getArrayMesesSeleccionadosFiltro(String meses){
//
//		String [] mesesFiltro=meses.split(",");
//		int [] lisMesesFiltro=new int [mesesFiltro.length];
//
//		for (int i = 0; i < mesesFiltro.length; i++) {
//			lisMesesFiltro[i]=Integer.parseInt(mesesFiltro[i]);
//		}
//		// ordena ascendente los meses
//		int aux;
//		for (int i = 0; i < lisMesesFiltro.length-1; i++) {
//			for (int j = i+1; j < lisMesesFiltro.length; j++) {
//				if (lisMesesFiltro[j]<lisMesesFiltro[i]){
//					aux=lisMesesFiltro[i];
//					lisMesesFiltro[i]=lisMesesFiltro[j];
//					lisMesesFiltro[j]=aux;
//				}
//			}
//		}
//
//		return lisMesesFiltro;
//	}
//
	
}
