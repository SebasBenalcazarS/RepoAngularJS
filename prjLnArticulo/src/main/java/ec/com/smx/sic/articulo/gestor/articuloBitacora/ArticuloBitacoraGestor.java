/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.articuloBitacora;

import java.text.MessageFormat;
import java.util.Collection;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.exception.DAOException;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.articulo.persistence.dao.ArticuloBitacoraCodigoBarrasDAO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.EnumEANConversionCodigoInterno;
import ec.com.smx.sic.cliente.common.bodega.EnumEan;
import ec.com.smx.sic.cliente.common.bodega.ValidacionEanUtil;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.ValidadorEanException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloBitacoraGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloBitacora.IArticuloBitacoraGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;


/**
 * @author gaortiz
 *
 */
public class ArticuloBitacoraGestor implements IArticuloBitacoraGestor{
	
	private ICalculoArticuloBitacoraGestor calculoArticuloBitacoraGestor;
	private DataGestor dataGestor;
	private ArticuloBitacoraCodigoBarrasDAO articuloBitacoraCodigoBarrasDAO;
	
	/**
	 * 
	 * @param articuloVO
	 * @throws SICException
	 */
	public void registrar( ArticuloVO articuloVO )throws SICException{
		//verificamos si viene con true la bandera ReutilizacionCodigoBarras, para inactivarle
		if(BooleanUtils.isTrue(articuloVO.getEsReutilizacionCodigoBarras()) && StringUtils.isNotEmpty(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras())){
			this.calculoArticuloBitacoraGestor.reutilizarCodigoBarrasEan(articuloVO);
		}
		this.calculoArticuloBitacoraGestor.asignarCamposCodigoBarras(articuloVO);
		articuloVO.getBaseDTO().getCodigoBarrasActivo().setUserId(articuloVO.getBaseDTO().getUserId());
		this.registrar(articuloVO.getBaseDTO().getCodigoBarrasActivo());
		
	}
	
	/**
	 * 
	 * @param articuloBitacoraCodigoBarrasDTO
	 * @throws SICException
	 */
	public void registrar( final ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO ) throws SICException{
		try{
			Logeable.LOG_SICV2.info("==> Registrando articuloBitacoraCodigoBarrasDTO ");
			this.dataGestor.createOrUpdate(articuloBitacoraCodigoBarrasDTO);
		}catch (DAOException e) {
			Logeable.LOG_SICV2.error(MessageFormat.format("Ha ocurrido un error al registrar la bitacora {0} de articulo {1}", articuloBitacoraCodigoBarrasDTO.getId().getCodigoBarras(), articuloBitacoraCodigoBarrasDTO.getId().getCodigoArticulo()));
			throw new SICException(MessageFormat.format("Ha ocurrido un error al registrar la bitacora {0} de articulo {1}", articuloBitacoraCodigoBarrasDTO.getId().getCodigoBarras(), articuloBitacoraCodigoBarrasDTO.getId().getCodigoArticulo()), e);
		}catch (Exception e) {
			Logeable.LOG_SICV2.error(MessageFormat.format("Ha ocurrido un error al registrar la bitacora {0} de articulo {1}", articuloBitacoraCodigoBarrasDTO.getId().getCodigoBarras(), articuloBitacoraCodigoBarrasDTO.getId().getCodigoArticulo()));
			throw new SICException(MessageFormat.format("Ha ocurrido un error al registrar la bitacora {0} de articulo {1}", articuloBitacoraCodigoBarrasDTO.getId().getCodigoBarras(), articuloBitacoraCodigoBarrasDTO.getId().getCodigoArticulo()), e);
		}
	}
	
	public Collection<String> obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> artUniMnjCol) throws SICException{
		return articuloBitacoraCodigoBarrasDAO.obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(articuloVO, artUniMnjCol);
	}
	
	public Collection<ArticuloDTO> obtenerArticuloPorUnidadesManejoCodBarras(Integer compania, String codigoBarras) throws SICException{
		return articuloBitacoraCodigoBarrasDAO.obtenerArticuloPorUnidadesManejoCodBarras(compania, codigoBarras);
	}
	
	public String obtenerCodigoBarrasActivoPorArticulo(String codigoArticulo,Integer codigoCompania) throws SICException{
		return articuloBitacoraCodigoBarrasDAO.obtenerCodigoBarrasActivoPorArticulo(codigoArticulo, codigoCompania);
	}
	
	public String transformarCodigoBarras(String codigoBarras){
		//Codigo de barras resultante 
		String codigoBarrasCodificado = null;
		//Si el codigo de barras ingresado no es nulo o blanco
		if(StringUtils.isNotBlank(codigoBarras)){
			if(EnumEANConversionCodigoInterno.LONGITUD_CODIGO_EAN_SCANNER.getParametro() == codigoBarras.length()){
				try{
					if(ValidacionEanUtil.getInstancia().validarEan(codigoBarras, EnumEan.EAN13.getTipo())){
						Integer identificador = Integer.valueOf(codigoBarras.substring(1,3));
						if(EnumEANConversionCodigoInterno.IDENTIFICADOR_RANGO_PESO_FIJO.getParametro() == identificador){//Si el identificador es peso fijo
							codigoBarrasCodificado = codigoBarras.substring(3, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_FIJO.getParametro()+3);
						}else if(EnumEANConversionCodigoInterno.IDENTIFICADOR_RANGO_PESO_VARIABLE.getParametro() == identificador){//Si el identificador es peso variable
							codigoBarrasCodificado = codigoBarras.substring(2, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_VARIABLE.getParametro()+2);
						}else{//Si el identificador es codigo de barras de proveedor
							codigoBarrasCodificado = codigoBarras;
						}
						return codigoBarrasCodificado;
					}
				}catch(Exception e){
					return codigoBarras;
				}
			}else if(EnumEANConversionCodigoInterno.LONGITUD_CODIGO_EAN.getParametro() == codigoBarras.length()){
				//TODO validar EAN
				try {
					if(ValidacionEanUtil.getInstancia().validarEan(EnumEan.EAN13.getIdentificadorCodigo()+codigoBarras, EnumEan.EAN13.getTipo())){
						Integer identificador = Integer.valueOf(codigoBarras.substring(0,2));
						if(EnumEANConversionCodigoInterno.IDENTIFICADOR_RANGO_PESO_FIJO.getParametro() == identificador){//Si el identificador es peso fijo
							codigoBarrasCodificado = codigoBarras.substring(2, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_FIJO.getParametro()+2);
						}else if(EnumEANConversionCodigoInterno.IDENTIFICADOR_RANGO_PESO_VARIABLE.getParametro() == identificador){//Si el identificador es peso variable
							codigoBarrasCodificado = codigoBarras.substring(1, EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_VARIABLE.getParametro()+1);
						}else{//Si el identificador es codigo de barras de proveedor
							codigoBarrasCodificado = codigoBarras;
						}
						return codigoBarrasCodificado;
					}
				} catch (ValidadorEanException e) {
					return codigoBarras;
				}
//					}else if(EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_VARIABLE.getParametro() == codigoBarras.length() || 
//								EnumEANConversionCodigoInterno.LONGITUD_RANGO_PESO_FIJO.getParametro() == codigoBarras.length()){
//						codigoBarrasCodificado = codigoBarras;
//					}else{
//						return codigoBarras;
			}
		}
		return codigoBarras;
	}
	/**
	 * @param dataGestor the dataGestor to set
	 */
	public final void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @param calculoArticuloBitacoraGestor the calculoArticuloBitacoraGestor to set
	 */
	public final void setCalculoArticuloBitacoraGestor(ICalculoArticuloBitacoraGestor calculoArticuloBitacoraGestor) {
		this.calculoArticuloBitacoraGestor = calculoArticuloBitacoraGestor;
	}

	public void setArticuloBitacoraCodigoBarrasDAO(ArticuloBitacoraCodigoBarrasDAO articuloBitacoraCodigoBarrasDAO) {
		this.articuloBitacoraCodigoBarrasDAO = articuloBitacoraCodigoBarrasDAO;
	}

	@Override
	public Collection<ArticuloDTO> obtenerArticuloPorCodBarras(Integer compania, String codbar, String codart) throws SICException {
		return this.articuloBitacoraCodigoBarrasDAO.obtenerArticuloPorCodBarras(compania, codbar, codart);
	}

	
}
