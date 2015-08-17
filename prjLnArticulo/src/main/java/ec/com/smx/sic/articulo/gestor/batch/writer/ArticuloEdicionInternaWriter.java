package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.encriptacion.util.CodificacionUtil;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.EnumRegistroEdicionMasiva;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEdicionInternaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;

public class ArticuloEdicionInternaWriter<T extends SearchDTO> implements ItemWriter<ArticuloEdicionInternaDTO> {
	
	private ArticuloEdicionMasivaVO plantillaRegistro;
	
	private String plantillaRegistroString;
	
	private String usuarioModificacion;
	
	private Collection<ArticuloEdicionMasivaVO> articulosModificadosCol;
	
	private String totalArticulosString;
	
	private Integer totalArticulos;
	
	private String fechaModificacion; 
	
	private String codigoCompania;
	
	@Override
	public void write(List<? extends ArticuloEdicionInternaDTO> articulosFoundCol) throws SICException {
		Logeable.LOG_SICV2.info("****************************---------------********************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando ArticuloEdicionInternaWriter*******************");
		Logeable.LOG_SICV2.info("****************************---------------********************************");
		try {
			//Actualizar la informacion en articulo local y articulo
			if(CollectionUtils.isNotEmpty(articulosFoundCol)){
				Logeable.LOG_SICV2.info("Total de articulos {}",articulosFoundCol.size());
				if(plantillaRegistro == null){
					plantillaRegistro = CodificacionUtil.getInstancia().decodificarStringAObjeto(plantillaRegistroString, ArticuloEdicionMasivaVO.class);
				}
				if(totalArticulos == null){
					totalArticulos = Integer.parseInt(totalArticulosString);
				}
				asignarCambiosArticulos(articulosFoundCol);
			}
		} catch (SICException e) {
			// TODO: handle exception
//			throw new SICException("Error en ArticuloAlcanceItemWriter {}", e);
			Logeable.LOG_SICV2.info("Total de articulos  plantilla {}",e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void asignarCambiosArticulos(List<? extends ArticuloEdicionInternaDTO> articulosList){
		ArticuloEdicionMasivaVO articuloEdicionMasivaVO = null;
		if(CollectionUtils.isNotEmpty(articulosList)){
			articulosModificadosCol = new ArrayList<ArticuloEdicionMasivaVO>();
			for(ArticuloEdicionInternaDTO articulo : articulosList){
				articuloEdicionMasivaVO = new ArticuloEdicionMasivaVO();
				articuloEdicionMasivaVO.setEnumRegistroEdicionMasiva(new HashSet<EnumRegistroEdicionMasiva>());
				articuloEdicionMasivaVO.setCodigoCompania(Integer.parseInt(codigoCompania));
				articuloEdicionMasivaVO.setCodigoArticulo(articulo.getCodigoArticulo());
				articuloEdicionMasivaVO.setCodigoBarrasArticulo(articulo.getCodigoBarras());
				Logeable.LOG_SICV2.info("codigoArticulo: "+articulo.getCodigoArticulo());
				
				if(plantillaRegistro.getSubClasificacion() != null){
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOGENERAL);
					articuloEdicionMasivaVO.setSubClasificacion(plantillaRegistro.getSubClasificacion());
				}
				
				if(plantillaRegistro.getCodigoClase() != null ){
					//agregamos como caracteristica dinamica el codigo de la clase a modificar, para que no afecte en otro proceso
					articuloEdicionMasivaVO.addDynamicProperty("codigoClaseNueva", plantillaRegistro.getCodigoClase());
					articuloEdicionMasivaVO.setValorTipoCausal(plantillaRegistro.getValorTipoCausal());
					articuloEdicionMasivaVO.setCodigoTipoCausal(plantillaRegistro.getCodigoTipoCausal());
					articuloEdicionMasivaVO.setCausal(plantillaRegistro.getCausal());
					
					//validamos datos de articulo temporada
					if(plantillaRegistro.getFechaInicialTemporada() != null){
						articuloEdicionMasivaVO.setFechaInicioTemporada(new SimpleDateFormat("yyyy-MM-dd").format(plantillaRegistro.getFechaInicialTemporada()));
					}
					if(plantillaRegistro.getFechaFinalTemporada() != null){
						articuloEdicionMasivaVO.setFechaFinTemporada(new SimpleDateFormat("yyyy-MM-dd").format(plantillaRegistro.getFechaFinalTemporada()));
					}
					
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOCLASEINTERNO);
				}
				
				if(plantillaRegistro.getMarcaParticipacion() != null || plantillaRegistro.getVerificaFechaCaducidad() != null
					|| plantillaRegistro.getCodigoPaisOrigen() != null || plantillaRegistro.getCodigoLugarCompra() != null){
					Boolean modificado = Boolean.FALSE;
					
					if(plantillaRegistro.getMarcaParticipacion() != null){
						articuloEdicionMasivaVO.setMarcaParticipacion(plantillaRegistro.getMarcaParticipacion());
						modificado = Boolean.TRUE;
					}
					if(plantillaRegistro.getVerificaFechaCaducidad() != null){
						articuloEdicionMasivaVO.setVerificaFechaCaducidad(plantillaRegistro.getVerificaFechaCaducidad());
						modificado = Boolean.TRUE;
					}
					if(plantillaRegistro.getCodigoPaisOrigen() != null ){
						articuloEdicionMasivaVO.setCodigoPaisOrigen(plantillaRegistro.getCodigoPaisOrigen());
						modificado = Boolean.TRUE;
					}
					if(plantillaRegistro.getCodigoLugarCompra() != null){
						articuloEdicionMasivaVO.setCodigoLugarCompra(plantillaRegistro.getCodigoLugarCompra());
						modificado = Boolean.TRUE;
					}
					if(modificado){
						articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOCOMERCIAL);
					}
				}
				
				if(plantillaRegistro.getCodigoMarcaComercial() != null){
					//agregamos la marca comercial en la propiedad dinamica para que no intervenga en otro proceso
					articuloEdicionMasivaVO.addDynamicProperty("codigoMarcaComercial", plantillaRegistro.getCodigoMarcaComercial());
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOMARCACOMERCIALINTERNO);
				}
				
				if(plantillaRegistro.getCodigoTipoControlPrecio() != null){
					//enviamos el valor mediante caracteristica dinamica para que no ingrese en el proceso de articulo comercial
					articuloEdicionMasivaVO.addDynamicProperty("valorTipoControlCosto", plantillaRegistro.getCodigoTipoControlPrecio());
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOCONTROLTIPOPRECIO);
				}
				
				if(plantillaRegistro.getTiempoVidaUtil() != null){
					articuloEdicionMasivaVO.setTiempoVidaUtil(plantillaRegistro.getTiempoVidaUtil());
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOVIDAUTILINTERNO);
				}
				
				if(plantillaRegistro.getTiempoRefrigeracion() != null){
					articuloEdicionMasivaVO.setTiempoRefrigeracion(plantillaRegistro.getTiempoRefrigeracion());
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOTIEMPOREFRIGERACIONINTERNO);
				}
				
				if(plantillaRegistro.getTiempoCongelacion() != null){
					articuloEdicionMasivaVO.setTiempoCongelacion(plantillaRegistro.getTiempoCongelacion());
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOTIEMPOCONGENLACIONINTERNO);
				}
				
				
				if(plantillaRegistro.getTamanio() != null){
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOMEDIDAINTERNO);
					articuloEdicionMasivaVO.setTamanio(plantillaRegistro.getTamanio());
				}
				
				if(plantillaRegistro.getAgrupador() != null){
					articuloEdicionMasivaVO.setCodigoTipoAgrupador(plantillaRegistro.getCodigoTipoAgrupador());
					articuloEdicionMasivaVO.setValorTipoAgrupador(plantillaRegistro.getValorTipoAgrupador());
					if(!StringUtils.equals(plantillaRegistro.getAgrupador(), SICArticuloConstantes.getInstancia().VALOR_AGRUPADOR_VACIO)){
						articuloEdicionMasivaVO.setAgrupador(plantillaRegistro.getAgrupador());
					}else{
						articuloEdicionMasivaVO.setAgrupador(null);
					}
					
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOAGRUPADORINTERNO);
				}
				
				if(plantillaRegistro.getMaterial() != null){
					articuloEdicionMasivaVO.setMaterial(plantillaRegistro.getMaterial());
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOMATERIAL);
				}
				
				if(plantillaRegistro.getReferenciaExterna() != null || plantillaRegistro.getReferenciaInterna() != null){
					articuloEdicionMasivaVO.setReferenciaInterna(plantillaRegistro.getReferenciaInterna());
					articuloEdicionMasivaVO.setReferenciaExterna(plantillaRegistro.getReferenciaExterna());
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOPROVEEDORINTERNO);
				}
				
				if(plantillaRegistro.getCostoMonedaOrigen() != null || plantillaRegistro.getPorcentajeComision() != null){
					articuloEdicionMasivaVO.setCostoMonedaOrigen(plantillaRegistro.getCostoMonedaOrigen());
					articuloEdicionMasivaVO.setPorcentajeComision(plantillaRegistro.getPorcentajeComision());
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOIMPORTACIONINTERNO);
				}
				
				if(plantillaRegistro.hasDynamicProperty("articuloImpuestoCol")){
					Collection<ArticuloImpuestoDTO> impuestosCol = (Collection<ArticuloImpuestoDTO>) plantillaRegistro.getDynamicProperty("articuloImpuestoCol"); 
					
					for(ArticuloImpuestoDTO articuloImpuestoDTO : impuestosCol){
						articuloImpuestoDTO.getId().setCodigoCompania(articuloEdicionMasivaVO.getCodigoCompania());
						articuloImpuestoDTO.getId().setCodigoArticulo(articuloEdicionMasivaVO.getCodigoArticulo());
						articuloImpuestoDTO.setIdUsuarioModificacion(usuarioModificacion);
						articuloImpuestoDTO.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
					}
					
					articuloEdicionMasivaVO.addDynamicProperty("articuloImpuestoCol", impuestosCol);
					articuloEdicionMasivaVO.getEnumRegistroEdicionMasiva().add(EnumRegistroEdicionMasiva.ARTICULOIMPUESTOINTERNO);
				}
					
				articuloEdicionMasivaVO.setUsuarioModificacion(usuarioModificacion);
				articuloEdicionMasivaVO.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
				
				articulosModificadosCol.add(articuloEdicionMasivaVO);
			}
			
			SICFactory.getInstancia().articulo.getArticuloService().registrarArticuloInternamente(articulosModificadosCol, totalArticulos , Long.parseLong(fechaModificacion));
		}
	}
	
	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @param plantillaRegistroString the plantillaRegistroString to set
	 */
	public void setPlantillaRegistroString(String plantillaRegistroString) {
		this.plantillaRegistroString = plantillaRegistroString;
	}

	/**
	 * @param totalArticulosString the totalArticulosString to set
	 */
	public void setTotalArticulosString(String totalArticulosString) {
		this.totalArticulosString = totalArticulosString;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}


}
