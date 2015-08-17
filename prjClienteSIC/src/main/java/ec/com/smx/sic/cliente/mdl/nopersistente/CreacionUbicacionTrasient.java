/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.bodega.EnumValorFiltrosUbicacion;
import ec.com.smx.sic.cliente.common.bodega.SICBodegaConstantes;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;



public class CreacionUbicacionTrasient {
	
	Boolean bandera = Boolean.TRUE;
	
	Boolean error = Boolean.FALSE;
	
	private Object object = new Object();
	
	private List<Boolean> listEstadoTareas = new ArrayList<Boolean>();
	
	private Map<String, Long> idsSeccion;
	
	private Map<String, Collection<Object[]>> idsDetalleSeccion;
	

	private void inicializarSeccion(Map<EnumValorFiltrosUbicacion, Object> datos,SeccionDTO seccion){
		seccion.getId().setCodigoCompania((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOCOMPANIA));
		seccion.setCodigoAreaTrabajo((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOAREATRABAJO));
		seccion.setCodigoAreaTrabajoPadre((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOAREATRABAJOPADRE));
		seccion.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		seccion.setUserId((String) datos.get(EnumValorFiltrosUbicacion.USERID));
		seccion.setCodigoTipoSeccion(SICBodegaConstantes.CODIGO_TIPO_SECCION);
	}
	
	
	public Collection<SeccionDTO> platillasSeccionUbicacion(Map<EnumValorFiltrosUbicacion, Object> datos){
		Collection<SeccionDTO> seccionDTOCol = new ArrayList<SeccionDTO>();
		SeccionDTO seccion = null;
		
		if(!datos.containsKey(EnumValorFiltrosUbicacion.CODIGODETSECNAVE)){
			seccion = new SeccionDTO();
			inicializarSeccion(datos, seccion);
			seccion.setValorTipoSeccion(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_NAVE);
			seccionDTOCol.add(seccion);
		}
		if(!datos.containsKey(EnumValorFiltrosUbicacion.CODIGODETSECSUBNAVE)){
			seccion = new SeccionDTO();
			inicializarSeccion(datos, seccion);
			seccion.setCodigoAreaTrabajo((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOSUBAREATRABAJO));
			seccion.setCodigoAreaTrabajoPadre((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOAREATRABAJO));
			seccion.setValorTipoSeccion(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_SUBNAVE);
			seccionDTOCol.add(seccion);
		}
		
		seccion = new SeccionDTO();
		inicializarSeccion(datos, seccion);
		seccion.setValorTipoSeccion(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_PASILLO);
		seccionDTOCol.add(seccion);
		
		seccion = new SeccionDTO();
		inicializarSeccion(datos, seccion);
		seccion.setValorTipoSeccion(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_RACK);
		seccionDTOCol.add(seccion);
		
		seccion = new SeccionDTO();
		inicializarSeccion(datos, seccion);
		seccion.setCodigoAreaTrabajo((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOSUBAREATRABAJO));
		seccion.setCodigoAreaTrabajoPadre((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOAREATRABAJO));
		seccion.setValorTipoSeccion(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION);
		seccionDTOCol.add(seccion);
		
		return seccionDTOCol;
	}
	
	private void inicializarDetalleSeccion(Map<EnumValorFiltrosUbicacion, Object> datos,DetalleSeccionDTO detalleSeccionDTO,String tipoSeccion){
		detalleSeccionDTO.getId().setCodigoCompania((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOCOMPANIA));
		detalleSeccionDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		detalleSeccionDTO.setUserId((String) datos.get(EnumValorFiltrosUbicacion.USERID));
		detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.TIPOSECCION.getValorFiltroUbicacion(),tipoSeccion);
	}
	
	private DetalleSeccionDTO plantillaDetalleSeccionNaveSubnave(Map<EnumValorFiltrosUbicacion, Object> datos,String tipDetalle){
		Long codigoSeccionPasillo = getIdsSeccion().get(tipDetalle);
		DetalleSeccionDTO detalleSeccionDTO = new DetalleSeccionDTO();		
		String identificador = (String)datos.get((
					SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_NAVE.equals(tipDetalle))?EnumValorFiltrosUbicacion.IDENTIFICADORNAVE:EnumValorFiltrosUbicacion.IDENTIFICADORSUBNAVE
				);
		
		String detalle = (SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_NAVE.equals(tipDetalle))?identificador:(String) datos.get(EnumValorFiltrosUbicacion.DESCRIPCIONSUBNAVE);
		
		inicializarDetalleSeccion(datos, detalleSeccionDTO,tipDetalle);
		detalleSeccionDTO.setCodigoSeccion(codigoSeccionPasillo);
		detalleSeccionDTO.setNombre(identificador);
		detalleSeccionDTO.setIdentificador(identificador);
		detalleSeccionDTO.setDescripcion(detalle);
		
		if(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_SUBNAVE.equals(tipDetalle)){
			String identificadorPadre = (String) datos.get(EnumValorFiltrosUbicacion.IDENTIFICADORNAVE);
			detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.IDENTIFICADOR.getValorFiltroUbicacion(), identificadorPadre);
		}
		return detalleSeccionDTO;
	}
	
	private Collection<DetalleSeccionDTO> plantillaDetalleSeccionPasillo(Map<EnumValorFiltrosUbicacion, Object> datos){
		Collection<DetalleSeccionDTO> detalleSeccionDTOCol = new ArrayList<DetalleSeccionDTO>();
		DetalleSeccionDTO detalleSeccionDTO = null;
		Integer pasilloIni = (Integer)datos.get(EnumValorFiltrosUbicacion.PASILLO_INICIAL);
		Integer pasilloFin = (Integer)datos.get(EnumValorFiltrosUbicacion.PASILLO_FINAL);
		Long codigoSeccionPasillo = getIdsSeccion().get(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_PASILLO);
		String pasIni;
		Boolean senPas = Boolean.TRUE; 
		
		if(pasilloIni == pasilloFin){
			detalleSeccionDTO = new DetalleSeccionDTO();
			pasIni = pasilloIni.toString();
			
			inicializarDetalleSeccion(datos, detalleSeccionDTO,SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_PASILLO);
			if(codigoSeccionPasillo == null){
				Logeable.LOG_SICV2.info(""+codigoSeccionPasillo);
			}
			detalleSeccionDTO.setCodigoSeccion(codigoSeccionPasillo);
			detalleSeccionDTO.setNombre(pasIni);
			detalleSeccionDTO.setDescripcion(pasIni);
			detalleSeccionDTO.setIdentificador(pasIni);
			detalleSeccionDTO.setOrden(pasilloIni);
			detalleSeccionDTO.setOrdenar(Long.valueOf(pasIni));
			detalleSeccionDTO.setValorTipoSentido(SICBodegaConstantes.CODIGO_VALOR_TIPO_SENTIDO_ENTRADA);
			detalleSeccionDTO.setCodigoTipoSentido(SICBodegaConstantes.CODIGO_TIPO_SENTIDO);
			
			detalleSeccionDTOCol.add(detalleSeccionDTO);
		}else{
			for(Integer i = pasilloIni; i<= pasilloFin ; i++ ){
				detalleSeccionDTO = new DetalleSeccionDTO();
				pasIni = i.toString();
				
				if(senPas){
					detalleSeccionDTO.setValorTipoSentido(SICBodegaConstantes.CODIGO_VALOR_TIPO_SENTIDO_ENTRADA);
					senPas = Boolean.FALSE;
				}else{
					detalleSeccionDTO.setValorTipoSentido(SICBodegaConstantes.CODIGO_VALOR_TIPO_SENTIDO_SALIDA);
					senPas = Boolean.TRUE;
				}
				
				inicializarDetalleSeccion(datos, detalleSeccionDTO,SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_PASILLO);
				detalleSeccionDTO.setCodigoSeccion(codigoSeccionPasillo);
				detalleSeccionDTO.setNombre(pasIni);
				detalleSeccionDTO.setDescripcion(pasIni);
				detalleSeccionDTO.setIdentificador(pasIni);
				detalleSeccionDTO.setOrden(i);
				detalleSeccionDTO.setOrdenar(Long.valueOf(pasIni));
				detalleSeccionDTO.setCodigoTipoSentido(SICBodegaConstantes.CODIGO_TIPO_SENTIDO);
				
				detalleSeccionDTOCol.add(detalleSeccionDTO);
			}
		}
		
		return detalleSeccionDTOCol;
	}
	
	private void setearValoresDetalleSeccionRack(
			DetalleSeccionDTO detalleSeccionDTO, String opcionLado,
			int rackvalor, String rack,
			Map<EnumValorFiltrosUbicacion, Object> datos,
			Long codigoSeccionRack) {
				
		inicializarDetalleSeccion(datos, detalleSeccionDTO,SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_RACK);
		detalleSeccionDTO.setCodigoSeccion(codigoSeccionRack);
		detalleSeccionDTO.setNombre(rack);
		detalleSeccionDTO.setDescripcion(rack);
		detalleSeccionDTO.setIdentificador(rack);
		detalleSeccionDTO.setOrden(rackvalor);
		detalleSeccionDTO.setOrdenar(Long.valueOf(rackvalor));
		detalleSeccionDTO.setValorTipoLado(opcionLado);
		detalleSeccionDTO.setCodigoTipoLado(SICBodegaConstantes.CODIGO_TIPO_LADO);
	}
	
	private Collection<DetalleSeccionDTO> plantillaDetalleSeccionRack(Map<EnumValorFiltrosUbicacion, Object> datos,int numPasillos){
		Collection<DetalleSeccionDTO> detalleSeccionDTOCol = new ArrayList<DetalleSeccionDTO>();
		DetalleSeccionDTO detalleSeccionDTO = null;
		Long codigoSeccionRack = getIdsSeccion().get(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_RACK);
		String opcionLado = (String)datos.get(EnumValorFiltrosUbicacion.VALORTIPOLADO);
		Integer rackIni = (Integer)datos.get(EnumValorFiltrosUbicacion.RACK_INICIAL);
		Integer rackFin = (Integer)datos.get(EnumValorFiltrosUbicacion.RACK_FINAL);
		Integer pasilloIni = (Integer)datos.get(EnumValorFiltrosUbicacion.PASILLO_INICIAL);
		Integer pasilloFin = (Integer)datos.get(EnumValorFiltrosUbicacion.PASILLO_FINAL);
		int rackvalor;
		String rack ;
		
		for(Integer i = pasilloIni; i<= pasilloFin ; i++ ){
			
			for (int e = rackIni; e <= rackFin; e = e + 10) {
				
				rackvalor = e<=9? 1 : (int) e / 10;
				String pasillo = i.toString();
				
				if(SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_NON.equals(opcionLado)
						|| SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_PAR.equals(opcionLado)){
					int j = SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_NON.equals(opcionLado)?1:0;
					rackvalor = (rackvalor * 10) + j;
					rack = valorIdentificador(rackvalor, SICBodegaConstantes.FORMATO_UBICACION_RACK);
					
					detalleSeccionDTO = new DetalleSeccionDTO();
					detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.IDENTIFICADOR.getValorFiltroUbicacion(), pasillo);
					setearValoresDetalleSeccionRack(detalleSeccionDTO, opcionLado,
							rackvalor, rack,datos,codigoSeccionRack);
					
					detalleSeccionDTOCol.add(detalleSeccionDTO);
					
				}else if(SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_PARNON.equals(opcionLado)){
					rackvalor = (rackvalor * 10) ;
					rack = valorIdentificador(rackvalor, SICBodegaConstantes.FORMATO_UBICACION_RACK);
					rackvalor = e<=9? 1 : (int) e / 10;
					int rackvalorNon = (rackvalor * 10) + 1;
					String rackNon = valorIdentificador(rackvalorNon, SICBodegaConstantes.FORMATO_UBICACION_RACK);
					
					detalleSeccionDTO = new DetalleSeccionDTO();
					detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.IDENTIFICADOR.getValorFiltroUbicacion(), pasillo);
					setearValoresDetalleSeccionRack(detalleSeccionDTO, SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_PAR,
							rackvalor, rack,datos,codigoSeccionRack);
					
					detalleSeccionDTOCol.add(detalleSeccionDTO);
					
					detalleSeccionDTO = new DetalleSeccionDTO();
					detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.IDENTIFICADOR.getValorFiltroUbicacion(), pasillo);
					setearValoresDetalleSeccionRack(detalleSeccionDTO, SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_NON,
							rackvalorNon, rackNon,datos,codigoSeccionRack);
					
					detalleSeccionDTOCol.add(detalleSeccionDTO);
				}
			}
		}
		
		return detalleSeccionDTOCol;
	}
	
	private void formatearUbicacion(String pasillo,String rack,int a,DetalleSeccionDTO detalleSeccionDTO,Integer codAreaTra,Integer codSubAreaTra){
		String ubicacion = "" ;
		String nivel = "" ;
		String tipAlmacenamiento = "";
		int valNivel = 0;
		Long ubicLong;
		
		valNivel = (a == 0)?1:(a*10); 
		tipAlmacenamiento = (a == 1)?SICBodegaConstantes.CODIGO_VALOR_TIPO_ALMACENAMIENTO_SURTIDO:SICBodegaConstantes.CODIGO_VALOR_TIPO_ALMACENAMIENTO_RESERVA;
		nivel = valorIdentificador((valNivel),SICBodegaConstantes.FORMATO_UBICACION_NIVEL);
		
		ubicacion = pasillo.concat(rack).concat(nivel);
		
		ubicLong = Long.valueOf(ubicacion);
		
		ubicacion = pasillo.concat(" ").concat(rack).concat(" ").concat(nivel);
		
		detalleSeccionDTO.setNombre(ubicacion);
		detalleSeccionDTO.setDescripcion(ubicacion);
		detalleSeccionDTO.setIdentificador(ubicacion);
		detalleSeccionDTO.setOrdenar(ubicLong);
		detalleSeccionDTO.setValorTipoAlmacenamiento(tipAlmacenamiento);
		detalleSeccionDTO.setCodigoTipoAlmacenamiento(SICBodegaConstantes.CODIGO_TIPO_ALMACENAMIENTO);
		detalleSeccionDTO.setValorTipoUbicacion(SICBodegaConstantes.CODIGO_VALOR_TIPO_UBICACION_FISICA);
		detalleSeccionDTO.setCodigoTipoUbicacion(SICBodegaConstantes.CODIGO_TIPO_UBICACION);
		detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.CODIGOSUBAREATRABAJO.getValorFiltroUbicacion(), codSubAreaTra);
		detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.CODIGOAREATRABAJO.getValorFiltroUbicacion(), codAreaTra);
		detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.RACK.getValorFiltroUbicacion(), rack);
		detalleSeccionDTO.addDynamicProperty(EnumValorFiltrosUbicacion.PASILLO.getValorFiltroUbicacion(), pasillo);
	}
	
	private Collection<DetalleSeccionDTO> plantillaDetalleSeccionUbicacion(Map<EnumValorFiltrosUbicacion, Object> datos){
		Collection<DetalleSeccionDTO> detalleSeccionDTOCol = new ArrayList<DetalleSeccionDTO>();
		Long codigoSeccionUbi = getIdsSeccion().get(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION);
		DetalleSeccionDTO detalleSeccionDTO = null;
		Integer pasilloIni = (Integer)datos.get(EnumValorFiltrosUbicacion.PASILLO_INICIAL);
		Integer pasilloFin = (Integer)datos.get(EnumValorFiltrosUbicacion.PASILLO_FINAL);
		String opcionLado = (String)datos.get(EnumValorFiltrosUbicacion.VALORTIPOLADO);
		Integer rackIni = (Integer)datos.get(EnumValorFiltrosUbicacion.RACK_INICIAL);
		Integer rackFin = (Integer)datos.get(EnumValorFiltrosUbicacion.RACK_FINAL);
		Integer nivelvalor = (Integer)datos.get(EnumValorFiltrosUbicacion.NIVEL);
		Integer codAreaTra = (Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOAREATRABAJO);
		Integer codSubAreaTra = (Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOSUBAREATRABAJO);
		
		int rackvalor;
		String rack;
		String pasillo;
		
		for(Integer i = pasilloIni; i<= pasilloFin ; i++ ){
			for (int e = rackIni; e <= rackFin; e = e + 10) {
				for (int a = 0; a < nivelvalor; a++) {
					rackvalor = e<=9? 1 : (int) e / 10;
					pasillo = i.toString();
					if(SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_NON.equals(opcionLado)
							|| SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_PAR.equals(opcionLado)){
						int j = SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_NON.equals(opcionLado)?1:0;
						rackvalor = (rackvalor * 10) + j;
						rack = valorIdentificador(rackvalor, SICBodegaConstantes.FORMATO_UBICACION_RACK);
						
						detalleSeccionDTO= new DetalleSeccionDTO();
						inicializarDetalleSeccion(datos, detalleSeccionDTO,SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION);
						formatearUbicacion(pasillo, rack, a, detalleSeccionDTO,codAreaTra,codSubAreaTra);
						detalleSeccionDTO.setCodigoSeccion(codigoSeccionUbi);
						detalleSeccionDTOCol.add(detalleSeccionDTO);
						
					}else if(SICBodegaConstantes.CODIGO_VALOR_TIPO_LADO_PARNON.equals(opcionLado)){
						rackvalor = (rackvalor * 10) ;
						rack = valorIdentificador(rackvalor, SICBodegaConstantes.FORMATO_UBICACION_RACK);
						rackvalor =  e<=9? 1 : (int) e / 10;
						int rackvalorNon = (rackvalor * 10) + 1;
						String rackNon = valorIdentificador(rackvalorNon, SICBodegaConstantes.FORMATO_UBICACION_RACK);
						
						detalleSeccionDTO= new DetalleSeccionDTO();
						inicializarDetalleSeccion(datos, detalleSeccionDTO,SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION);
						formatearUbicacion(pasillo, rack, a, detalleSeccionDTO,codAreaTra,codSubAreaTra);
						detalleSeccionDTO.setCodigoSeccion(codigoSeccionUbi);
						detalleSeccionDTOCol.add(detalleSeccionDTO);
						
						detalleSeccionDTO= new DetalleSeccionDTO();
						inicializarDetalleSeccion(datos, detalleSeccionDTO,SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION);
						formatearUbicacion(pasillo, rackNon, a, detalleSeccionDTO,codAreaTra,codSubAreaTra);
						detalleSeccionDTO.setCodigoSeccion(codigoSeccionUbi);
						detalleSeccionDTOCol.add(detalleSeccionDTO);
					}
				}
			}
		}
		return detalleSeccionDTOCol;
	}
	
	public Collection<DetalleSeccionDTO> platillasDetalleSeccionUbicacion(Map<EnumValorFiltrosUbicacion, Object> datos,Collection<DetalleSeccionDTO> detalleSeccionDTOCol){
		
		//DETALLE SECCION PASILLO
		DetalleSeccionDTO detSecNave = plantillaDetalleSeccionNaveSubnave(datos, SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_NAVE);
		DetalleSeccionDTO detSecSubNave = plantillaDetalleSeccionNaveSubnave(datos, SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_SUBNAVE);
		Collection<DetalleSeccionDTO> detSecPasillo = plantillaDetalleSeccionPasillo(datos);
		Collection<DetalleSeccionDTO> detSecRack = plantillaDetalleSeccionRack(datos,detSecPasillo.size());
		Collection<DetalleSeccionDTO> detSecUbi = plantillaDetalleSeccionUbicacion(datos);
		
		detalleSeccionDTOCol.add(detSecNave);
		detalleSeccionDTOCol.add(detSecSubNave);
		detalleSeccionDTOCol.addAll(detSecPasillo);
		detalleSeccionDTOCol.addAll(detSecRack);
		detalleSeccionDTOCol.addAll(detSecUbi);
		
		return detalleSeccionDTOCol;
	}
	
	private void inicializarRelacionSeccion(RelacionSeccionDTO relacionSeccionDTO, Map<EnumValorFiltrosUbicacion, Object> datos,Long codigoDetSecP,Long codigoDetSecH){
		relacionSeccionDTO.getId().setCodigoCompania((Integer)datos.get(EnumValorFiltrosUbicacion.CODIGOCOMPANIA));
		relacionSeccionDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		relacionSeccionDTO.setUserId((String) datos.get(EnumValorFiltrosUbicacion.USERID));
		relacionSeccionDTO.getId().setCodigoDetalleSeccionPadre(codigoDetSecP);
		relacionSeccionDTO.getId().setCodigoDetalleSeccion(codigoDetSecH);
	}
	
	private Collection<RelacionSeccionDTO> plantillasCrearEstructura(Map<EnumValorFiltrosUbicacion, Object> datos,Collection<Object[]> detSecPadre,Collection<Object[]> detSecHija){
		Collection<RelacionSeccionDTO> relacionSeccionDTOs = new ArrayList<RelacionSeccionDTO>();
		RelacionSeccionDTO relacionSeccionDTO = null;
		
		for(Object[] codigoDetSecP:detSecPadre){
			for(Object[] codigoDetSecH:detSecHija){
				Long codDetSecP = (Long)codigoDetSecP[1];
				Long codDetSecH = (Long)codigoDetSecH[1];
				
					relacionSeccionDTO = new RelacionSeccionDTO();
					inicializarRelacionSeccion(relacionSeccionDTO, datos,codDetSecP,codDetSecH);
					relacionSeccionDTOs.add(relacionSeccionDTO);
			}
		}
		
		return relacionSeccionDTOs;
	}
	
	private Collection<Collection<Object[]>>  separarCodigosDetalleSeccion(Collection<Object[]> codigoDetSecCol){
		
		List<String> aux= new ArrayList<String>();
		String valRack ;
		String valRack2 ;
		Collection<Collection<Object[]>> codigoRackCol = new ArrayList<Collection<Object[]>>();
		
		for(Object[] rack1: codigoDetSecCol){
			Collection<Object[]> codigos = new ArrayList<Object[]>();
			valRack = (String)rack1[0];
			for(Object[] rack2: codigoDetSecCol){
				valRack2 = (String)rack2[0];
				
				if(!aux.contains(valRack) && valRack.equals(valRack2)){
					codigos.add(rack2);
				}
			}
			if(CollectionUtils.isNotEmpty(codigos)){
				codigoRackCol.add(codigos);
			}
			if(!aux.contains(valRack)){
				aux.add(valRack);
			}
		}
		return codigoRackCol;
	}
	
	
	public void platillasRelacionesSeccion(Map<EnumValorFiltrosUbicacion, Object> datos,Collection<RelacionSeccionDTO> relacionSeccionDTOCol){
		Collection<Object[]> codigosDetSecNav = getIdsDetalleSeccion().get(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_NAVE);
		Collection<Object[]> codigosDetSecSubnav = getIdsDetalleSeccion().get(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_SUBNAVE);
		Collection<Object[]> codigosDetSecPas = getIdsDetalleSeccion().get(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_PASILLO);
		Collection<Object[]> codigosDetSecRac = getIdsDetalleSeccion().get(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_RACK);
		Collection<Object[]> codigosDetSecUbi = getIdsDetalleSeccion().get(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION);
		Long codigoAreaDetalleSeccion =(Long) datos.get(EnumValorFiltrosUbicacion.CODIGODETSECAREA);
		
		Collection<RelacionSeccionDTO> relsec = plantillasCrearEstructura(datos, codigosDetSecNav, codigosDetSecSubnav);
		
		relacionSeccionDTOCol.addAll(relsec);
		
		relsec = plantillasCrearEstructura(datos, codigosDetSecNav, codigosDetSecPas);
		
		relacionSeccionDTOCol.addAll(relsec);
		
		relsec = plantillasCrearEstructura(datos, codigosDetSecNav, codigosDetSecUbi);
		
		relacionSeccionDTOCol.addAll(relsec);
		
		relsec = plantillasCrearEstructura(datos, codigosDetSecSubnav, codigosDetSecPas);
		
		relacionSeccionDTOCol.addAll(relsec);
		
		Collection<Collection<Object[]>> codigoRackCol = separarCodigosDetalleSeccion(codigosDetSecRac);
		Collection<RelacionSeccionDTO> relacionSeccionDTOs = crearPlantillaRelacionDetalleSeparado(datos, codigosDetSecPas, codigoRackCol);
		
		relacionSeccionDTOCol.addAll(relacionSeccionDTOs);
		
		relacionSeccionDTOs = new ArrayList<RelacionSeccionDTO>();
		RelacionSeccionDTO relacionSeccionDTO = null;
		
		for(Object[] rackObj:  codigosDetSecRac){
			for(Object[] ubicObj:  codigosDetSecUbi){
				String rack1 = (String)ubicObj[2];
				String pas1 = (String)ubicObj[3];
				String rack2 = (String)rackObj[0];
				String pas2 = (String)rackObj[2];
				if(rack1.equals(rack2) && pas1.equals(pas2)){
					
					Long codDetSecH = (Long)ubicObj[1];
					Long codDetSecP = (Long)rackObj[1];
					
					relacionSeccionDTO = new RelacionSeccionDTO();
					inicializarRelacionSeccion(relacionSeccionDTO, datos,codDetSecP,codDetSecH);
					relacionSeccionDTOs.add(relacionSeccionDTO);
				}
				Logeable.LOG_SICV2.info("--"+rack1+"--"+pas1+"--"+rack2+"--"+pas2);
			}
		}
		
		relacionSeccionDTOCol.addAll(relacionSeccionDTOs);
		
		Collection<Object[]> codDetSecAreaCol = new ArrayList<Object[]>();
		codDetSecAreaCol.add(new Object[]{"",codigoAreaDetalleSeccion});
		
		relsec = plantillasCrearEstructura(datos, codDetSecAreaCol, codigosDetSecUbi);
		
		relacionSeccionDTOCol.addAll(relsec);
		
		
	}


	/**
	 * @param datos
	 * @param codigosDetSecPas
	 * @param codigoRackCol
	 * @return
	 */
	private Collection<RelacionSeccionDTO> crearPlantillaRelacionDetalleSeparado(Map<EnumValorFiltrosUbicacion, Object> datos, Collection<Object[]> codigosDetSecPas, Collection<Collection<Object[]>> codigoRackCol) {
		Collection<RelacionSeccionDTO> relacionSeccionDTOs = new ArrayList<RelacionSeccionDTO>();
		RelacionSeccionDTO relacionSeccionDTO = null;		
		
		for (Collection<Object[]> scRack:codigoRackCol) {
			for(Object[] pas:codigosDetSecPas){
				for(Object[] rack:scRack){
					
					Long codDetSecP = (Long)pas[1];
					Long codDetSecH = (Long)rack[1];
					
						relacionSeccionDTO = new RelacionSeccionDTO();
						inicializarRelacionSeccion(relacionSeccionDTO, datos,codDetSecP,codDetSecH);
						relacionSeccionDTOs.add(relacionSeccionDTO);
					
					scRack.remove(rack);
					break;
				}
			}
		}
		return relacionSeccionDTOs;
	}
	
	public void registrarIdsDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO){
		String tipoSeccion = (String) detalleSeccionDTO.getDynamicProperties().get(EnumValorFiltrosUbicacion.TIPOSECCION.getValorFiltroUbicacion());
		
		if(idsDetalleSeccion == null){
			idsDetalleSeccion = new HashMap<String, Collection<Object[]>>();
		}
		
		if(idsDetalleSeccion.containsKey(tipoSeccion)){
			Collection<Object[]> codDetSec = idsDetalleSeccion.get(tipoSeccion);
			if(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION.equals(tipoSeccion)){
				codDetSec.add(new Object[]{detalleSeccionDTO.getIdentificador(),
						detalleSeccionDTO.getId().getCodigoDetalleSeccion(),
						detalleSeccionDTO.getDynamicProperties().get(EnumValorFiltrosUbicacion.RACK.getValorFiltroUbicacion()),
						detalleSeccionDTO.getDynamicProperties().get(EnumValorFiltrosUbicacion.PASILLO.getValorFiltroUbicacion())
						});
			}else{
				codDetSec.add(new Object[]{detalleSeccionDTO.getIdentificador(),detalleSeccionDTO.getId().getCodigoDetalleSeccion(),detalleSeccionDTO.getDynamicProperties().get(EnumValorFiltrosUbicacion.IDENTIFICADOR.getValorFiltroUbicacion())});
			}
		}else{
			Collection<Object[]> codDetSec = new ArrayList<Object[]>();
			if(SICBodegaConstantes.CODIGO_VALOR_TIPO_SECCION_UBICACION.equals(tipoSeccion)){
				codDetSec.add(new Object[]{detalleSeccionDTO.getIdentificador(),
						detalleSeccionDTO.getId().getCodigoDetalleSeccion(),
						detalleSeccionDTO.getDynamicProperties().get(EnumValorFiltrosUbicacion.RACK.getValorFiltroUbicacion()),
						detalleSeccionDTO.getDynamicProperties().get(EnumValorFiltrosUbicacion.PASILLO.getValorFiltroUbicacion())
						});
			}else{
				codDetSec.add(new Object[]{detalleSeccionDTO.getIdentificador(),detalleSeccionDTO.getId().getCodigoDetalleSeccion(),detalleSeccionDTO.getDynamicProperties().get(EnumValorFiltrosUbicacion.IDENTIFICADOR.getValorFiltroUbicacion())});
			}
			idsDetalleSeccion.put(tipoSeccion, codDetSec);
		}
	}
	
	public void notificarThread(){
		synchronized (object) {
			object.notifyAll();
		}
	}
	
	/**
	 * metodo para completar el identificador de un detalle seccion
	 * @param valorIni
	 * @param constanteHasta
	 * @return
	 */
	private String valorIdentificador(int valorIni,int constanteHasta){
		String valor=String.valueOf(valorIni);
		String aux=String.valueOf(valorIni);
		for(int i=0;i < (constanteHasta-aux.length());i++){
			valor="0".concat(valor);
		}
		return valor;	
	}
	
	/**
	 * @return the listEstadoTareas
	 */
	public List<Boolean> getListEstadoTareas() {
		return listEstadoTareas;
	}


	/**
	 * @param listEstadoTareas the listEstadoTareas to set
	 */
	public void setListEstadoTareas(List<Boolean> listEstadoTareas) {
		this.listEstadoTareas = listEstadoTareas;
	}

	/**
	 * @return the bandera
	 */
	public Boolean getBandera() {
		return bandera;
	}

	/**
	 * @param bandera the bandera to set
	 */
	public void setBandera(Boolean bandera) {
		this.bandera = bandera;
	}

	/**
	 * @return the error
	 */
	public Boolean getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(Boolean error) {
		this.error = error;
	}

	

	/**
	 * @return the idsSeccion
	 */
	public Map<String, Long> getIdsSeccion() {
		return idsSeccion;
	}

	/**
	 * @return the idsDetalleSeccion
	 */
	public Map<String, Collection<Object[]>> getIdsDetalleSeccion() {
		return idsDetalleSeccion;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @param idsSeccion the idsSeccion to set
	 */
	public void setIdsSeccion(Map<String, Long> idsSeccion) {
		this.idsSeccion = idsSeccion;
	}


	/**
	 * @param idsDetalleSeccion the idsDetalleSeccion to set
	 */
	public void setIdsDetalleSeccion(Map<String, Collection<Object[]>> idsDetalleSeccion) {
		this.idsDetalleSeccion = idsDetalleSeccion;
	}

	
	
	
}
