package ec.com.smx.sic.articulo.gestor.promocion;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoEjecucionGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoGestionPrecio;
import ec.com.smx.sic.cliente.gestor.articulo.promocion.IArticuloPromocionGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloTemporadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
/**
 * @author corbe
 */
public class ArticuloPromocionGestor implements IArticuloPromocionGestor{
	private DataGestor dataGestor;
	
	public Collection<GestionPrecioDTO> buscarPromociones(){
		Collection<GestionPrecioDTO> gestionPrecioCol;
		GestionPrecioDTO gestionPrecioDTO = new GestionPrecioDTO();
		CatalogoValorDTO catalogoGestionPrecio = new CatalogoValorDTO();
		catalogoGestionPrecio.getId().setCodigoCatalogoTipo(TipoGestionPrecio.CODIGO_TIPO_GESTION_PRECIO);
		catalogoGestionPrecio.getId().setCodigoCatalogoValor(TipoGestionPrecio.PROMOCION.getValorTipoGestionPrecio());
		gestionPrecioDTO.setTipoGestionPrecio(catalogoGestionPrecio);
		gestionPrecioCol = dataGestor.findObjects(gestionPrecioDTO);
		return gestionPrecioCol;
	}
	
	public Collection<GestionPrecioDTO> buscarPromocionesCriterio(CriteriaSearchParameter<?> criteriaSearchParameter){
		
		Collection<GestionPrecioDTO> gestionPrecioCol;
		GestionPrecioDTO gestionPrecioDTO = new GestionPrecioDTO();
		CatalogoValorDTO catalogoGestionPrecio = new CatalogoValorDTO();
		catalogoGestionPrecio.getId().setCodigoCatalogoTipo(TipoGestionPrecio.CODIGO_TIPO_GESTION_PRECIO);
		catalogoGestionPrecio.getId().setCodigoCatalogoValor(TipoGestionPrecio.PROMOCION.getValorTipoGestionPrecio());
		gestionPrecioDTO.setTipoGestionPrecio(catalogoGestionPrecio);
		if(criteriaSearchParameter != null){
			gestionPrecioDTO.addCriteriaSearchParameter(criteriaSearchParameter);
		}
		gestionPrecioCol = dataGestor.findObjects(gestionPrecioDTO);
		return gestionPrecioCol;
	}
	
	public Collection<ArticuloGestionPrecioDTO> buscarPromocionesArticulo(GestionPrecioDTO gestionPrecioDTO){
		Collection<ArticuloGestionPrecioDTO> gestPrecArtCol;
		ArticuloGestionPrecioDTO gestionPrecioArticuloDTO = new ArticuloGestionPrecioDTO();
		GestionPrecioDTO gestionPrecio = new GestionPrecioDTO();
		gestionPrecio.getId().setCodigoCompania(gestionPrecioDTO.getId().getCodigoCompania());
		gestionPrecio.getId().setCodigoGestionPrecio(gestionPrecioDTO.getId().getCodigoGestionPrecio());
		gestionPrecioArticuloDTO.setGestionPrecio(gestionPrecio);
		ArticuloDTO articuloDTO =new ArticuloDTO();
		articuloDTO.setArticuloTemporadaDTO(new ArticuloTemporadaDTO());
		ArticuloBitacoraCodigoBarrasDTO abcb =new ArticuloBitacoraCodigoBarrasDTO();
		abcb.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articuloDTO.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		articuloDTO.getArtBitCodBarCol().add(abcb);
		gestionPrecioArticuloDTO.setArticulo(articuloDTO);
		gestPrecArtCol = dataGestor.findObjects(gestionPrecioArticuloDTO);
		return gestPrecArtCol;
	}
	
	public void registrarPromocion(GestionPrecioDTO gestionPrecioDTO) {
		
		gestionPrecioDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		dataGestor.create(gestionPrecioDTO);
		
		if(CollectionUtils.isNotEmpty(gestionPrecioDTO.getArticulosGestionPrecios())){
			for(ArticuloGestionPrecioDTO gestionPrecioArticuloDTO : gestionPrecioDTO.getArticulosGestionPrecios()){
				
				this.fijarDatosPorDefecto(gestionPrecioDTO.getId().getCodigoGestionPrecio(), gestionPrecioArticuloDTO);				
				
				dataGestor.create(gestionPrecioArticuloDTO);
			}
		}
	}
	
	private void fijarDatosPorDefecto(Long codigoGestionPrecio, ArticuloGestionPrecioDTO articuloGestionPrecioDTO) {
		
		// Datos por defecto
		articuloGestionPrecioDTO.getId().setCodigoGestionPrecio(codigoGestionPrecio);
		articuloGestionPrecioDTO.setFechaVigenciaInicio(new Timestamp(System.currentTimeMillis()));
		articuloGestionPrecioDTO.setPrecioPVPAnterior(0D);
		articuloGestionPrecioDTO.setPrecioPVPNuevo(0D);
		articuloGestionPrecioDTO.setPrecioSMXAnterior(0D);
		articuloGestionPrecioDTO.setPrecioSMXNuevo(0D);
		articuloGestionPrecioDTO.setPrecioSMXNoAfiliadoAnterior(0D);
		articuloGestionPrecioDTO.setPrecioSMXNoAfiliadoNuevo(0D);
		articuloGestionPrecioDTO.setValorTipoEstado(EstadoGestionPrecio.NO_APLICA.getValorEstadoGestionPrecio());
		articuloGestionPrecioDTO.setCodigoTipoEstado(EstadoGestionPrecio.CODIGO_ESTADO_GESTION_PRECIO);
		articuloGestionPrecioDTO.setValorEstadoEjecucion(EstadoEjecucionGestionPrecio.NO_APLICA.getValorEstadoEjecucionGestionPrecio());
		articuloGestionPrecioDTO.setCodigoEstadoEjecucion(EstadoEjecucionGestionPrecio.CODIGO_ESTADO_EJECUCION_GESTION_PRECIO);
		
	}
	
	public void actualizarPromocion(GestionPrecioDTO gestionPrecioDTO){
		dataGestor.update(gestionPrecioDTO);
		if(CollectionUtils.isNotEmpty(gestionPrecioDTO.getArticulosGestionPrecios())){
			for(ArticuloGestionPrecioDTO gestionPrecioArticuloDTO : gestionPrecioDTO.getArticulosGestionPrecios()){
				
				this.fijarDatosPorDefecto(gestionPrecioDTO.getId().getCodigoGestionPrecio(), gestionPrecioArticuloDTO);	
				
				dataGestor.createOrUpdate(gestionPrecioArticuloDTO);
			}
		}
	}
	
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
}
