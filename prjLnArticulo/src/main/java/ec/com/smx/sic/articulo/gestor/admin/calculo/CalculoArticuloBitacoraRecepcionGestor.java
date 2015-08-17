/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.calculo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.framework.common.validator.Validator;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloBitacoraGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.RangoSecuenciaCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.SecuenciaCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloBitacoraCodigoBarrasDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;


/**
 * @author fmunoz
 *
 */
public class CalculoArticuloBitacoraRecepcionGestor implements ICalculoArticuloBitacoraGestor{

	private DataGestor dataGestor;
	private IArticuloDAO articuloDAO;
	private IArticuloBitacoraCodigoBarrasDAO articuloBitacoraCodigoBarrasDAO;
	
	private void validarArticuloEnTransaccionesActivas(ArticuloBitacoraCodigoBarrasDTO abcb)throws SICRuleException{
		//no se puede asignar el c�digo de barras porque pertenece a otro art�culo activo en otras transacciones
		String mensaje = "El c\u00F3digo de barras " + abcb.getId().getCodigoBarras()
				+ " ya est\u00E1 asignado al art\u00EDculo de c\u00F3digo \u00FAnico " + abcb.getId().getCodigoArticulo() + " - " + abcb.getArticulo().getDescripcionArticulo();
		if(abcb.getArticulo().getCodigoClasificacion() != null){
			mensaje = mensaje.concat(" con clasificaci\u00F3n " + abcb.getArticulo().getCodigoClasificacion());
		}
		throw new SICRuleException(mensaje);
	}
	
	/**
	 * Metodo que permite obtener la bitacora
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 */
	private ArticuloBitacoraCodigoBarrasDTO obtenerArticuloBitacoraCodigoBarras(Integer codigoCompania, String codigoArticulo, String codigoBarras ){
		
		ArticuloBitacoraCodigoBarrasDTO abcbFiltro = new ArticuloBitacoraCodigoBarrasDTO();
		
		abcbFiltro.getId().setCodigoCompania(codigoCompania);
		abcbFiltro.getId().setCodigoArticulo(codigoArticulo);
		abcbFiltro.getId().setCodigoBarras(codigoBarras);
		abcbFiltro.setArticulo(new ArticuloDTO());
		abcbFiltro.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		abcbFiltro = dataGestor.findUnique(abcbFiltro);
		
		return abcbFiltro;		
		
	}
	
	/**
	 * Obtiene el c&oacute;digo de barras que debe ser enviado al POS
	 * @param tipoCodigo
	 * @param codigoBarras
	 * @param calcularCodigoVentaPOS
	 * @return
	 */
	private String calcularCodigoBarrasPOS(String tipoCodigo, String codigoBarras, Boolean calcularCodigoOrigenPOS, Boolean aumentarPrefijoCuponEspecial) {
		String codigoPOS = codigoBarras.trim();
		if(tipoCodigo.equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO)){
//			RangoSecuenciaCodigoBarrasDTO filtro = new RangoSecuenciaCodigoBarrasDTO();
//			filtro.setCodigoTipoSecuencia(SICArticuloConstantes.getInstancia().TIPOCATALOGO_SECUENCIAINTERNA);
			
			RangoSecuenciaCodigoBarrasDTO filtro = new RangoSecuenciaCodigoBarrasDTO();
			SecuenciaCodigoBarrasDTO secuencia = new SecuenciaCodigoBarrasDTO();
			secuencia.setCodigoTipoSecuencia(SICArticuloConstantes.getInstancia().TIPOCATALOGO_SECUENCIAINTERNA);
			Collection<SecuenciaCodigoBarrasDTO> secuencias = new ArrayList<SecuenciaCodigoBarrasDTO>();
			secuencias.add(secuencia);
			filtro.setSecuencias(secuencias);
			
			Collection<RangoSecuenciaCodigoBarrasDTO> rangos = dataGestor.findObjects(filtro);
			for(RangoSecuenciaCodigoBarrasDTO rango : rangos){
				Integer prefijo = rango.getPrefijoPOS();
				for (SecuenciaCodigoBarrasDTO detalleCabeceraSecuenciaDTO : rango.getSecuencias()) {
					if(aumentarPrefijoCuponEspecial && detalleCabeceraSecuenciaDTO.getValorTipoSecuencia().equals(SICArticuloConstantes.getInstancia().TIPSECART_CUPONESPECIAL)){
						prefijo = Integer.valueOf(SICArticuloCalculo.PREFIJO_CUPON_ESPECIAL);
					}
					if(prefijo > 0 && Long.valueOf(codigoBarras) >= rango.getValorMinimo() && Long.valueOf(codigoBarras) <= rango.getValorMaximo()){
						codigoPOS = String.valueOf(prefijo).concat(codigoPOS);
						if(calcularCodigoOrigenPOS){
							if(SICArticuloConstantes.getInstancia().TIPSECART_PESOFIJO.equals(detalleCabeceraSecuenciaDTO.getValorTipoSecuencia())){
								codigoPOS = StringUtils.rightPad(codigoPOS, SICArticuloConstantes.LONGITUD_CODIGOPOS, "0");
							}else{
								codigoPOS = StringUtils.leftPad(codigoPOS, SICArticuloConstantes.LONGITUD_CODIGOPOS, "0");
							}
						}else{
							codigoPOS = StringUtils.rightPad(codigoPOS, SICArticuloConstantes.LONGITUD_CODIGOPOS, "0");
						}
						break;
					}
				}
			}
		}else{
			//se elimina el digito verificador, se debera completar con ceros a la izquierda hasta la longitud limite cuando se envie al POS
			codigoPOS = codigoPOS.substring(0, codigoPOS.length() - 1);
			if(codigoPOS.length() < SICArticuloConstantes.LONGITUD_CODIGOPOS){
				codigoPOS = StringUtils.leftPad(codigoPOS, SICArticuloConstantes.LONGITUD_CODIGOPOS, "0");
			}
		}
		return codigoPOS;
	}
	
	/**
	 * Metodo que permite validar si el codigo de barras existe en otro articulo
	 * @param articuloVO
	 * @return
	 * @throws SICRuleException
	 */
		
	public Boolean validarAsignacionCodigoBarras(ArticuloVO articuloVO)throws SICRuleException{
		try{
			
			Boolean desactivarBitacora = Boolean.FALSE;
			
			Logeable.LOG_SICV2.info("===> valida la asignacion del codigo de barras");
			
			ArticuloBitacoraCodigoBarrasDTO abcb = null;
			if(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())){
				//se consulta la bitacora del articulo actual
				if(StringUtils.isNotEmpty(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
					
					desactivarBitacora = this.debeDesactivarCodigoBarrasAnterior(articuloVO);
				}
			}else if(StringUtils.isNotEmpty(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras())){
				
				Validator validator = new ValidatorImpl();
				if(!validator.validateEAN(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras())){
					validator = null;
					throw new SICRuleException(SICArticuloMessages.getInstancia().getString("mensaje.error.codigoBarras.noValido"));
				}
				
				abcb = this.obtenerArticuloBitacoraCodigoBarras(articuloVO.getBaseDTO().getId().getCodigoCompania(), null, articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras());
				
				if(abcb != null){
					//solamente si el secuencial del art�culo no coincide se verifica, ya que si los secuenciales coinciden significa que se est� realizando
					//la actualizacion de un art�culo cuyo c�digo de barras no fue cambiado.
					if(!abcb.getId().getCodigoArticulo().equals(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
						if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(abcb.getArticulo().getEstadoArticulo())){
							//se verifica si el art�culo est� incluido en otras transacciones activas
							this.validarArticuloEnTransaccionesActivas(abcb);
						}else{
							abcb.setEstadoArticuloBitacora(SICConstantes.ESTADO_INACTIVO_NUMERICO);
							abcb.setFechaFinalActivo(new Date());
							abcb.setUserId(articuloVO.getBaseDTO().getUserId());
							dataGestor.update(abcb);
						}
					}
				}
				
				desactivarBitacora = this.debeDesactivarCodigoBarrasAnterior(articuloVO);
				
			}
			return desactivarBitacora;
		}catch (SICRuleException e) {
			Logeable.LOG_SICV2.info("Error al validar la asignacion de codigo barras de articulo: {0}", articuloVO.getBaseDTO().getId().getCodigoArticulo());
			throw e;
		}catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al validar la asignacion de codigo barras de articulo: {0}", articuloVO.getBaseDTO().getId().getCodigoArticulo());
			throw new SICRuleException(SICArticuloMessages.getInstancia().getString("mensaje.error.validacion.codigobarras"),e);
		}
	}
	
	/**
	 * Metodo que permite verificar si debe desactivar el codigo anterior de barras
	 * @return
	 */
	private Boolean debeDesactivarCodigoBarrasAnterior(ArticuloVO articuloVO){
		
		ArticuloBitacoraCodigoBarrasDTO abcb = null;
		Boolean desactivarBitacora = Boolean.FALSE;
		
		abcb = this.obtenerArticuloBitacoraCodigoBarras(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), null);
		
		final Boolean existeArticuloBitacora = abcb != null;
		
		if(existeArticuloBitacora){
			
			if(!StringUtils.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getValorTipoSecuencia(), abcb.getValorTipoSecuencia())){
				desactivarBitacora = Boolean.TRUE;
			}else if( !StringUtils.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras(), abcb.getId().getCodigoBarras()) ){
				desactivarBitacora = Boolean.TRUE;
			}
		}
		
		return desactivarBitacora;
		
	}
	

	/**
	 * 
	 * @param articuloVO
	 * @param bitacoraActual
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposCodigoBarras(ArticuloVO articuloVO)throws SICRuleException, SICException{
		
		//valida el codigo de barras
		final Boolean desactivarBitacora = this.validarAsignacionCodigoBarras(articuloVO);
		
		//si es un articulo interno
		if(desactivarBitacora && SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())){
			this.calcularCodigoBarrasInterno(articuloVO.getBaseDTO());	
		}
		
		final String CodigoBarrasPOS = this.calcularCodigoBarrasPOS(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo(), articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras());
		articuloVO.getBaseDTO().getCodigoBarrasActivo().setCodigoBarrasPOS(CodigoBarrasPOS);
		
		this.asignarBitacoraCodigoBarras(articuloVO, desactivarBitacora);
	}

	/**
	 * 
	 * @param articuloVO
	 * @param abcb
	 * @throws SICRuleException
	 */
	@Override
	public void asignarBitacoraCodigoBarras(ArticuloVO articuloVO, Boolean desactivarBitacora)throws SICRuleException{
		try{
			//SE DESACTIVA LA BITACORA DEL ARTICULO ACTUAL
			if(desactivarBitacora){
				Logeable.LOG_SICV2.info("===> desactivar el codigo de barras anterior");
				Date fechaFinalActivo = new Date();
				articuloBitacoraCodigoBarrasDAO.desactivarBitacoraActual(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId(), fechaFinalActivo);
				//se asignan los datos para la nueva bitacora, pero todavia no se registra en base
				articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().setFechaInicialActivo(DateUtils.addMilliseconds(fechaFinalActivo, 1));
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setUserId(articuloVO.getBaseDTO().getUserId());
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setFechaFinalActivo(null);
			}

			if(articuloVO.getBaseDTO().getCodigoBarrasActivo().getPendienteCodigoBarras() == null){
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setPendienteCodigoBarras(Boolean.FALSE);
			}
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Error al inactivar la bitacora de codigo de barras anterior del articulo: {}", articuloVO.getBaseDTO().getId().getCodigoArticulo());
			throw e;
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al inactivar la bitacora de codigo de barras anterior del articulo: {}", articuloVO.getBaseDTO().getId().getCodigoArticulo());
			throw new SICRuleException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.bitacora"), e);
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	@Override
	public String calcularCodigoBarrasInterno(ArticuloDTO articuloDTO)throws SICException{
		//se obtiene la secuencia interna del articulo
		Logeable.LOG_SICV2.info(MessageFormat.format("Ingreso a obtener secuencaia interna para el nuevo art\u00EDculo: {0}", articuloDTO.getDescripcionArticulo()));
		articuloDTO.getCodigoBarrasActivo().getId().setCodigoBarras(String.valueOf(articuloBitacoraCodigoBarrasDAO.obtenerSecuenciaInternaDisponible(articuloDTO.getId().getCodigoCompania(), articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia(),articuloDTO.getUserId())));
		return articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras();
	}


	@Override
	public String calcularCodigoBarrasPOS(String tipoCodigo, String codigoBarras){
		Logeable.LOG_SICV2.info(MessageFormat.format("Ingreso a calculo codigo POS: {0}", codigoBarras));
		return calcularCodigoBarrasPOS(tipoCodigo, codigoBarras, Boolean.TRUE, Boolean.FALSE);
	}
	
	/**
	 * @author corbe
	 * metodo que inactiva el codigobarras existente
	 */
	@Override
	public void reutilizarCodigoBarrasEan(ArticuloVO articuloVO)throws SICException{
		articuloBitacoraCodigoBarrasDAO.reutilizarCodigoBarrasEan(articuloVO.getBaseDTO().getId().getCodigoArticulo() , articuloVO.getBaseDTO().getId().getCodigoCompania() , articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras() , articuloVO.getBaseDTO().getUserId());
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public final void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @param articuloDAO the articuloDAO to set
	 */
	public final void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	/**
	 * @param articuloBitacoraCodigoBarrasDAO the articuloBitacoraCodigoBarrasDAO to set
	 */
	public final void setArticuloBitacoraCodigoBarrasDAO(IArticuloBitacoraCodigoBarrasDAO articuloBitacoraCodigoBarrasDAO) {
		this.articuloBitacoraCodigoBarrasDAO = articuloBitacoraCodigoBarrasDAO;
	}
	

}
