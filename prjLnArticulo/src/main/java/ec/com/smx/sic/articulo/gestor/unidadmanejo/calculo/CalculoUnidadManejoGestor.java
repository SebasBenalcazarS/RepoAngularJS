/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.unidadmanejo.calculo;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.calculo.ICalculoUnidadManejoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloLocalPrecioDAO;


/**
 * Implementaci&oacute;n de la l&oacute;gica del negocio para el registro de unidades de manejo
 * @author fmunoz
 *
 */
public class CalculoUnidadManejoGestor implements ICalculoUnidadManejoGestor{

	private IArticuloLocalPrecioDAO articuloLocalPrecioDAO;
	
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.unidadmanejo.calculo.ICalculoUnidadManejoGestor#relacionarUnidadManejoPrecio(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO, java.util.Collection)
	 */
	@Override
	public void relacionarUnidadManejoPrecio(ArticuloDTO articuloDTO, Collection<ArticuloUnidadManejoDTO> unidades){
		if(articuloDTO.getTieneArticuloPrecio() && SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_PRODUCTO.equals(articuloDTO.getCodigoTipoArticulo())){
			Boolean asignadoPrecioCaja = relacionarUnidadManejoPrecio(articuloDTO, SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA);
			Boolean asignadoPrecioMayorista = relacionarUnidadManejoPrecio(articuloDTO, SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA);
			
			if(!asignadoPrecioMayorista){
				desactivarPrecio(articuloDTO, SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA);
			}
			if(!asignadoPrecioCaja){
				desactivarPrecio(articuloDTO, SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA);
			}
		}
	}
	
	private void desactivarPrecio(final ArticuloDTO articuloDTO, final String tipo){
		ArticuloPrecioDTO ap = (ArticuloPrecioDTO)CollectionUtils.find(articuloDTO.getArticuloPrecioCol(), new Predicate() {
			@Override
			public boolean evaluate(Object pre) {
				return tipo.equals(((ArticuloPrecioDTO)pre).getId().getCodigoTipoPrecio());
			}
		});
		if(ap != null){
			ap.setEstadoPrecio(SICConstantes.ESTADO_INACTIVO_NUMERICO);
		}else{
			articuloLocalPrecioDAO.desactivarTipoPrecio(articuloDTO.getId().getCodigoCompania(), articuloDTO.getId().getCodigoArticulo(), tipo);
		}
	}
	
	private Boolean relacionarUnidadManejoPrecio(ArticuloDTO articuloDTO, String tipoPrecio){
		ArticuloUnidadManejoDTO aum = encontrarUnidadManejoVenta(articuloDTO.getArticuloUnidadManejoCol(), tipoPrecio);
		for(ArticuloPrecioDTO ap : articuloDTO.getArticuloPrecioCol()){
			if(tipoPrecio.equals(ap.getId().getCodigoTipoPrecio())){
				if(aum != null){
					if(ap.getTieneArticuloUnidadManejo()){
						//se asigna la relacion en caso de una nueva unidad de manejo
						if(ap.getArticuloUnidadManejo().getId().getCodigoUnidadManejo() != null){
							final Long codigoUnidadManejo = ap.getArticuloUnidadManejo().getId().getCodigoUnidadManejo();
							ArticuloUnidadManejoDTO aumModificada = (ArticuloUnidadManejoDTO)CollectionUtils.find(articuloDTO.getArticuloUnidadManejoCol(), new Predicate() {
								@Override
								public boolean evaluate(Object object) {
									ArticuloUnidadManejoDTO item = (ArticuloUnidadManejoDTO)object;
									return item.getId().getCodigoUnidadManejo().longValue() == codigoUnidadManejo.longValue() && 
											item.hasDynamicProperty(ArticuloUnidadManejoDTO.NUEVO_REGISTRO);
								}
							});
							
							if(aumModificada != null){
								ArticuloUnidadManejoDTO nuevaUnidad = (ArticuloUnidadManejoDTO)aumModificada.getDynamicProperty(ArticuloUnidadManejoDTO.NUEVO_REGISTRO);
								ap.setArticuloUnidadManejo(nuevaUnidad);
								ap.setCodigoUnidadManejo(nuevaUnidad.getId().getCodigoUnidadManejo());
								ap.nulificarValorActualCalculado();
								aumModificada.removeDynamicProperty(ArticuloUnidadManejoDTO.NUEVO_REGISTRO);
							}else{
								ap.setCodigoUnidadManejo(codigoUnidadManejo);
							}
							ap.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							ap.getArticuloUnidadManejo().removeDynamicProperty(ArticuloUnidadManejoDTO.NUEVO_REGISTRO);
						}else{
							ap.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							ap.setCodigoUnidadManejo(aum.getId().getCodigoUnidadManejo());
							ap.setArticuloUnidadManejo(aum);
							ap.nulificarValorActualCalculado();
						}

					}else if(ap.getCodigoUnidadManejo() == null){
						ap.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						ap.setCodigoUnidadManejo(aum.getId().getCodigoUnidadManejo());
						ap.setArticuloUnidadManejo(aum);
						ap.nulificarValorActualCalculado();
					}
				}else{
					ap.setEstadoPrecio(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				}
				
				return SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(ap.getEstadoPrecio());
			}
		}
		if(aum != null){
			ArticuloPrecioDTO ap = new ArticuloPrecioDTO();
			ap.getId().setCodigoTipoPrecio(tipoPrecio);
			ap.setCodigoUnidadManejo(aum.getId().getCodigoUnidadManejo());
			ap.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			ap.setArticuloUnidadManejo(aum);
			articuloDTO.getArticuloPrecioCol().add(ap);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private ArticuloUnidadManejoDTO encontrarUnidadManejoVenta(Collection<ArticuloUnidadManejoDTO> unidades, String tipoPrecio){
		if(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA.equals(tipoPrecio)){
			for(ArticuloUnidadManejoDTO aum : unidades){
				if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(aum.getEstadoUnidadManejo())
						&& SICArticuloConstantes.getInstancia().TIPOEMPAQUE_MAYORISTA.equals(aum.getValorTipoUnidadEmpaque())){
					if(aum.getTieneUnidadesManejoUso()){
						for(ArticuloUnidadManejoUsoDTO aumu : aum.getArticuloUnidadManejoUsoCol()){
							if(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA.equals(aumu.getId().getValorTipoUso())
									&& SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(aumu.getEstado())){
								return aum;
							}
						}
					}
				}
			}
		}else{
			for(ArticuloUnidadManejoDTO aum : unidades){
				if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(aum.getEstadoUnidadManejo())
					&& !SICArticuloConstantes.getInstancia().TIPOEMPAQUE_MAYORISTA.equals(aum.getValorTipoUnidadEmpaque())
					&& aum.getValorUnidadManejo() > 1 && aum.getDescuentoVenta() != null && aum.getDescuentoVenta().doubleValue() > 0d){
					if(aum.getTieneUnidadesManejoUso()){
						for(ArticuloUnidadManejoUsoDTO aumu : aum.getArticuloUnidadManejoUsoCol()){
							if(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA.equals(aumu.getId().getValorTipoUso())
									&& SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(aumu.getEstado())){
								return aum;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.unidadmanejo.calculo.ICalculoUnidadManejoGestor#asignarCamposUnidadManejo(ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO)
	 */
	@Override
	public void asignarCamposUnidadManejo(ArticuloUnidadManejoDTO aum){
		if(StringUtils.isEmpty(aum.getEstadoUnidadManejo())){
			aum.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);}
		if(StringUtils.isEmpty(aum.getValorTipoUnidadEmpaque())){
			aum.setValorTipoUnidadEmpaque(SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PIEZA);
		}
		if(!SICConstantes.VALOR_NOASIGNADO.equals(aum.getValorTipoUnidadEmpaque())){
			aum.setCodigoTipoUnidadEmpaque(SICArticuloConstantes.getInstancia().CODIGOTIPOEMPAQUE);
		}else{
			aum.setCodigoTipoUnidadEmpaque(SICConstantes.CODIGO_CATALOGO_OMISION);
		}
		
//		if(aum.getEsPrincipal() == null){
//			aum.setEsPrincipal(Boolean.FALSE);}
//		if(aum.getCodigoEquivalenciaDescuento() == null || aum.getCodigoTipoDescuento() == null){
//			aum.setCodigoTipoDescuento(null);
//			aum.setCodigoEquivalenciaDescuento(null);
//		}
		if(aum.getValorUnidadManejo() == null){
			aum.setValorUnidadManejo(1);
		}
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.unidadmanejo.calculo.ICalculoUnidadManejoGestor#asignarCamposUnidadManejoUso(ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO)
	 */
	@Override
	public void asignarCamposUnidadManejoUso(ArticuloUnidadManejoUsoDTO dto){
		if(StringUtils.isEmpty(dto.getEstado())){
			dto.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);}
		if(StringUtils.isNotEmpty(dto.getId().getValorTipoUso()) && !SICConstantes.VALOR_NOASIGNADO.equals(dto.getId().getValorTipoUso())){
			dto.setCodigoTipoUso(SICArticuloConstantes.getInstancia().CODIGOTIPOUSOUNIMAN);
		}else{
			dto.getId().setValorTipoUso(SICConstantes.VALOR_NOASIGNADO);
			dto.setCodigoTipoUso(SICConstantes.CODIGO_CATALOGO_OMISION);
		}
	}
	/**
	 * @param articuloLocalPrecioDAO the articuloLocalPrecioDAO to set
	 */
	public void setArticuloLocalPrecioDAO(IArticuloLocalPrecioDAO articuloLocalPrecioDAO) {
		this.articuloLocalPrecioDAO = articuloLocalPrecioDAO;
	}
}
