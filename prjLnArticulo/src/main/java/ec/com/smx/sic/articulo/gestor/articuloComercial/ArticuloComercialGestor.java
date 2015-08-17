/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.articuloComercial;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.IArticuloOrigenProveedor;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.articuloComercial.IArticuloComercialGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorImportadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloComercialDAO;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author gaortiz
 *
 */
public class ArticuloComercialGestor implements IArticuloComercialGestor{
	
	private DataGestor dataGestor;
	
	private IArticuloComercialDAO articuloComercialDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.articuloComercial.IArticuloComercialGestor#registrarArticuloComercial(ec.com.smx.sic.cliente.mdl.vo.ArticuloVO, java.lang.Boolean)
	 */
	public void registrarArticuloComercial(final ArticuloVO articuloVO,Boolean esCreacion){
		
		try{
			
			if(articuloVO.getBaseDTO().getTieneArticuloComercial()){
				IArticuloOrigenProveedor articuloOrigenProveedor = new IArticuloOrigenProveedor() {
					
					@Override
					public String getOrigenArticulo() throws SICException {
						
						return obtenerOrigenArticulo(articuloVO.getBaseDTO());
					}
				};
				this.registrarArticuloComercial(articuloVO.getBaseDTO().getArticuloComercialDTO(), esCreacion, articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId(), articuloOrigenProveedor);
			}
		}catch(Exception e){
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.comercial"),e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.articuloComercial.IArticuloComercialGestor#registrarArticuloComercial(ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO, java.lang.Boolean)
	 */
	public void registrarArticuloComercial(final ArticuloComercialDTO articuloComercialDTO, Boolean esCreacion, Integer codigoCompania, String codigoArticulo, String userId, IArticuloOrigenProveedor articuloOrigenProveedor){
		
		try{
			
			if(SearchDTO.isLoaded(articuloComercialDTO)){
				articuloComercialDTO.getId().setCodigoCompania(codigoCompania);
				articuloComercialDTO.getId().setCodigoArticulo(codigoArticulo);
				articuloComercialDTO.setUserId(userId);
				this.registrarArticuloComercial(articuloComercialDTO, esCreacion, articuloOrigenProveedor);
			}
		}catch(Exception e){
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.comercial"),e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.articuloComercial.IArticuloComercialGestor#registrarArticuloComercial(ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO, java.lang.Boolean)
	 */
	public void registrarArticuloComercial(final ArticuloComercialDTO articuloComercialDTO, Boolean esCreacion, IArticuloOrigenProveedor articuloOrigenProveedor){
		try{
			
			if(SearchDTO.isLoaded(articuloComercialDTO)){
				
				Logeable.LOG_SICV2.info("==> Registrando articulo comercial");
				
				this.validarArticuloComercialDTO(articuloComercialDTO);
				this.asignarCamposArticuloComercial(articuloComercialDTO, articuloOrigenProveedor);
				if(esCreacion){
					dataGestor.create(articuloComercialDTO);
				}else{
					dataGestor.createOrUpdate(articuloComercialDTO);
				}
			}
		}catch(Exception e){
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.comercial"),e);
		}
	}
	
	/**
	 * 
	 * @param articuloComercialDTO
	 */
	public void validarArticuloComercialDTO( final ArticuloComercialDTO articuloComercialDTO){
		if( null == articuloComercialDTO.getId().getCodigoCompania() ){
			throw new SICException("El campo codigoCompania no puede ser nulo");
		}
		
		if( null == articuloComercialDTO.getId().getCodigoArticulo() ){
			throw new SICException("El campo codigoArticulo no puede ser nulo");
		}
		
		if( null == articuloComercialDTO.getUserId() ){
			throw new SICException("El campo userId no puede ser nulo");
		}
		
		if(StringUtils.isEmpty(articuloComercialDTO.getValorTipoControlCosto())){
			throw new SICException("El campo control de costo no puede ser nulo");
		}
	}
	
	/**
	 * 
	 * @param aum
	 * @throws SICRuleException
	 */
	public void asignarCamposArticuloComercial(final ArticuloComercialDTO articuloComercialDTO, IArticuloOrigenProveedor articuloOrigenProveedor){
		ArticuloComercialDTO ac = articuloComercialDTO;
		//VALOR POR DEFECTO FECHA DE CADUCIDAD REQUERIDO
		if(ac.getVerFecCadRec() == null){
			ac.setVerFecCadRec(Boolean.FALSE);}
		if(StringUtils.isNotEmpty(ac.getValorTipoControlCosto()) && !SICConstantes.VALOR_NOASIGNADO.equals(ac.getValorTipoControlCosto())){
			ac.setCodigoTipoControlCosto(SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoControlCosto"));
		}else{
			ac.setValorTipoControlCosto(SICConstantes.VALOR_NOASIGNADO);
			ac.setCodigoTipoControlCosto(SICConstantes.CODIGO_CATALOGO_OMISION);			
//			ac.setCodigoTipoControlCosto(SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoControlCosto"));
//			ac.setValorTipoControlCosto(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE);
		}
		if(ac.getVentaPrecioAfiliado() == null){
			ac.setVentaPrecioAfiliado(Boolean.FALSE);
		}

		if(ac.getVentaPrecioAfiliado()){
			ac.setPorcentajeNoAfiliado(0d);
		}else{
			ac.setPorcentajeNoAfiliado(ac.getPorcentajeNoAfiliado());
		}

		if(StringUtils.isEmpty(ac.getCodigoPaisOrigen())){
			ac.setCodigoPaisOrigen(CorporativoConstantes.CODIGO_DIVGEOPOL_ECUADOR);}
		if(ac.getPorcentajeNoAfiliado() == null){
			ac.setPorcentajeNoAfiliado(0d);}

		if(ac.getCodigoLugarCompra() == null){
			ac.setCodigoLugarCompra(SICArticuloConstantes.CODIGO_LUGAR_COMPRA_ECUADOR);
		}
		
		if(null == ac.getEstadoOrigenArticulo()){
			ac.setEstadoOrigenArticulo(articuloOrigenProveedor.getOrigenArticulo());
		}

		if(ac.getTienePrecioFijo() == null){
			ac.setTienePrecioFijo(Boolean.TRUE);}
		if(ac.getGeneraFacturaVenta() == null){
			ac.setGeneraFacturaVenta(Boolean.TRUE);}

		if( StringUtils.isBlank(ac.getValorTipoDeducible()) ){
			ac.setValorTipoDeducible(null);
			ac.setCodigoTipoDeducible(null);
		}

		if(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE.equals(ac.getValorTipoControlCosto())){
			ac.setPesoAproximadoRecepcion(0d);
			ac.setPesoAproximadoVenta(0d);
		}
		
		if(ac.getMarcaParticipaciones() == null){//Se asigna de forma predeterminada esta marca participacion para todos los articulos
			ac.setMarcaParticipaciones(SICArticuloConstantes.MARCA_PARTICIPACIONES_PREDETERMINADA);
		}
	}
	
	/**
	 * 
	 * @param art
	 * @return
	 */
	public String obtenerOrigenArticulo(ArticuloDTO art){
		String origenImportado = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado");
		String estadoOrigenArticulo = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.nacional");
		Collection<ArticuloProveedorDTO> registros = null;
		if(art.getTieneArticuloProveedor()){
			registros = art.getArticuloProveedorCol();
		}else{
			ArticuloProveedorDTO ap = new ArticuloProveedorDTO();
			ap.getId().setCodigoCompania(art.getId().getCodigoCompania());
			ap.getId().setCodigoArticulo(art.getId().getCodigoArticulo());
			ap.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			ap.setProveedor(new ProveedorDTO());
			ap.getProveedor().setProveedorImportado(new ProveedorImportadoDTO());

			registros = dataGestor.findObjects(ap);
		}

		ProveedorDTO filtro = new ProveedorDTO();
		filtro.setProveedorImportado(new ProveedorImportadoDTO());
		filtro.getId().setCodigoCompania(art.getId().getCodigoCompania());
		for(ArticuloProveedorDTO dto : registros){
			if(!dto.getTieneProveedor() || !SearchDTO.isLoaded(dto.getProveedor().getProveedorImportado())){
				filtro.getId().setCodigoProveedor(dto.getId().getCodigoProveedor());
				dto.setProveedor(dataGestor.findUnique(filtro));
			}
			if(origenImportado.equals(dto.getProveedor().getOrigenProveedor()) || SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(dto.getProveedor().getProveedorImportado().getEsImportador())){
				estadoOrigenArticulo = origenImportado;
				break;
			}
		}

		return estadoOrigenArticulo;

		/*if(SICArticuloConstantes.CODIGO_LUGAR_COMPRA_ECUADOR.equals(ac.getCodigoLugarCompra())){
			ac.setEstadoOrigenArticulo(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.nacional"));
		}else{
			UbicacionTransaccionDivisionGeoPoliticaDTO lc = new UbicacionTransaccionDivisionGeoPoliticaDTO();
			lc.getId().setCodigoUbicacionTransaccionDivisionGeoPolitica(ac.getCodigoLugarCompra());
			lc.getId().setCodigoCompania(ac.getId().getCodigoCompania());
			lc.setDivisionGeoPoliticaDTO(new DivisionGeoPoliticaDTO());
			lc = dataGestor.findUnique(lc);
			if(CorporativoConstantes.CODIGO_DIVGEOPOL_ECUADOR.equals(lc.getCodigoDivisionGeoPolitica()) || 
					CorporativoConstantes.CODIGO_DIVGEOPOL_ECUADOR.equals(lc.getDivisionGeoPoliticaDTO().getCodigoDivGeoPolRoot())){
				ac.setEstadoOrigenArticulo(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.nacional"));
			}else{
				ac.setEstadoOrigenArticulo(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado"));
			}
		}*/
	}

	public Integer actualizarMarcaComercial(Integer codigoCompania, String codigoArticulo, String userId, Long codigoMarca) throws SICException {
		return articuloComercialDAO.actualizarMarcaComercial(codigoCompania, codigoArticulo, userId, codigoMarca);
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public final void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setArticuloComercialDAO(IArticuloComercialDAO articuloComercialDAO) {
		this.articuloComercialDAO = articuloComercialDAO;
	}
}
