/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.calculo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import ec.com.kruger.utilitario.dao.commons.dto.ListSet;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.Util;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.framework.common.validator.Validator;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.frameworkv2.auditoria.common.util.AuditLogConstant;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.EnumSubProcesoGuardadoArticulo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloValidacion;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDuracionConservacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloInternetDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLeyendaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMaterialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorCostoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoVentaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorImportadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RangoSecuenciaCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.SecuenciaCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloBitacoraCodigoBarrasDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;


/**
 * @author fmunoz
 *
 */
public class CalculoArticuloGestor implements ICalculoArticuloGestor,Logeable{

	private DataGestor dataGestor;
	private IArticuloDAO articuloDAO;
	private IArticuloBitacoraCodigoBarrasDAO articuloBitacoraCodigoBarrasDAO;

	/**
	 * 
	 * @param articuloDTO
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposArticulo(ArticuloVO articuloVO)throws SICRuleException{
		//se verifica si esta asignada la relacion con la clasificacion
		if(!articuloVO.getBaseDTO().getTieneClasificacion() && StringUtils.isNotEmpty(articuloVO.getBaseDTO().getCodigoClasificacion())){
			ClasificacionDTO clasificacionDTO = new ClasificacionDTO();
			clasificacionDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			clasificacionDTO.getId().setCodigoClasificacion(articuloVO.getBaseDTO().getCodigoClasificacion());
			articuloVO.getBaseDTO().setClasificacionDTO(dataGestor.findUnique(clasificacionDTO));
		}
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getEstadoArticulo())){
			articuloVO.getBaseDTO().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
		if(articuloVO.getBaseDTO().getAplicaRegistroSanitario() == null){
			if(articuloVO.getBaseDTO().getTieneClasificacion()){
				articuloVO.getBaseDTO().setAplicaRegistroSanitario(articuloVO.getBaseDTO().getClasificacionDTO().getAplicaRegistroSanitario());
			}else{
				articuloVO.getBaseDTO().setAplicaRegistroSanitario(Boolean.FALSE);
			}
		}
		if(articuloVO.getBaseDTO().getValorAplicaRegistroSanitario() == null){
			if(articuloVO.getBaseDTO().getTieneClasificacion()){
				articuloVO.getBaseDTO().setValorAplicaRegistroSanitario(articuloVO.getBaseDTO().getClasificacionDTO().getValorAplicaRegistroSanitario());
				articuloVO.getBaseDTO().setCodigoAplicaRegistroSanitario(articuloVO.getBaseDTO().getClasificacionDTO().getCodigoAplicaRegistroSanitario());
			}else{
				articuloVO.getBaseDTO().setValorAplicaRegistroSanitario(TipoCatalogoArticulo.VALOR_NO_APLICA_REGISTRO_SANITARIO);
				articuloVO.getBaseDTO().setCodigoAplicaRegistroSanitario(TipoCatalogoArticulo.TIPO_ESTADO_APLICA_REGISTRO_SANITARIO);
			}
		}		
		if(articuloVO.getBaseDTO().getCostoBrutoArticulo() == null){
			articuloVO.getBaseDTO().setCostoBrutoArticulo(0D);}
		if(articuloVO.getBaseDTO().getEsComercializado() == null){
			articuloVO.getBaseDTO().setEsComercializado(Boolean.TRUE);}
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getCodigoEstado())){
			articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO);}
		if(articuloVO.getBaseDTO().getCodigoBarrasActivo().getValorTipoSecuencia() != null){
			articuloVO.getBaseDTO().getCodigoBarrasActivo().setCodigoTipoSecuencia(SICArticuloConstantes.getInstancia().TIPOCATALOGO_SECUENCIAINTERNA);}
		if(articuloVO.getBaseDTO().getId().getCodigoArticulo() == null && StringUtils.isEmpty(articuloVO.getBaseDTO().getCodigoSistemaOrigen())){
			//solo si es creacion
			articuloVO.getBaseDTO().setCodigoSistemaOrigen(SICConstantes.CODIGO_SISTEMA_MAX);
		}
		if(StringUtils.isNotEmpty(articuloVO.getBaseDTO().getValorEstadoTransgenico())){
			articuloVO.getBaseDTO().setCodigoEstadoTransgenico(TipoCatalogoArticulo.TIPO_CARACTERISTICA_TRANSGENICO);
		}else{
			articuloVO.getBaseDTO().setCodigoEstadoTransgenico(null);
		}
		
		if(articuloVO.getBaseDTO().getCantidadRegistroSanitario() == null){
			articuloVO.getBaseDTO().setCantidadRegistroSanitario(1);
		}
		if(articuloVO.getBaseDTO().getAplicaTransgenico() == null){
			if(articuloVO.getBaseDTO().getTieneClasificacion()){
				articuloVO.getBaseDTO().setAplicaTransgenico(articuloVO.getBaseDTO().getClasificacionDTO().getAplicaTransgenico());
			}else{
				articuloVO.getBaseDTO().setAplicaTransgenico(Boolean.FALSE);
			}
		}

		if( StringUtils.equals(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON, articuloVO.getBaseDTO().getCodigoTipoArticulo()) ){
			articuloVO.getBaseDTO().setAplicaRegistroSanitario(Boolean.FALSE);
			articuloVO.getBaseDTO().setValorAplicaRegistroSanitario(TipoCatalogoArticulo.VALOR_NUNCA_APLICA_REGISTRO_SANITARIO);//TODO verificar cupones nunca reg san
			articuloVO.getBaseDTO().setCodigoAplicaRegistroSanitario(TipoCatalogoArticulo.TIPO_ESTADO_APLICA_REGISTRO_SANITARIO);
		}
	}

	/**
	 * 
	 * @param articuloVO
	 * @param bitacoraActual
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposCodigoBarras(ArticuloVO articuloVO, ArticuloBitacoraCodigoBarrasDTO bitacoraActual)throws SICRuleException{
		//si es un articulo interno
		if(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())){
			// se verifica si el articulo es nuevo
			if (articuloVO.getBaseDTO().getId().getCodigoArticulo() == null) {
				String secuencialArticulo = dataGestor.findNextSequenceValue(SICConstantes.ESQUEMABD, SICArticuloConstantes.getInstancia().NOMBRE_SECUENCIA_ARTICULO, String.class, null);
				articuloVO.getBaseDTO().getId().setCodigoArticulo(secuencialArticulo);

				if (SICConstantes.CODIGO_SISTEMA_SISPE.equals(articuloVO.getBaseDTO().getCodigoSistemaOrigen())){
					// condicion especial para el SISPE
					articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO);
				}
			}

			if(articuloVO.getBaseDTO().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO)) {
				articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().setCodigoBarras("C"+articuloVO.getBaseDTO().getId().getCodigoArticulo());
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setCodigoBarrasPOS(SICConstantes.VALOR_NOASIGNADO);
			}else{
				if((bitacoraActual != null && bitacoraActual.getArticulo().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO))
						|| (SICConstantes.CODIGO_SISTEMA_SISPE.equals(articuloVO.getBaseDTO().getCodigoSistemaOrigen())
								&& StringUtils.isEmpty(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras()))){
					// Verificar si en la edicion del articulo se podria cambiar el tipo de secuencia interna para un articulo
					this.calcularCodigoBarrasInterno(articuloVO.getBaseDTO());
					articuloVO.setEstValCodBar(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_DESACTIVARCREAR);
				}
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setCodigoBarrasPOS(calcularCodigoBarrasPOS(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo(), 
						articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras()));
			}
			articuloVO.getBaseDTO().getCodigoBarrasActivo().setPendienteCodigoBarras(Boolean.FALSE);
		}else{
			Boolean validarCodigoBarras = Boolean.TRUE;
			if(articuloVO.getBaseDTO().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO)){
				if(BooleanUtils.isTrue(articuloVO.getBaseDTO().getCodigoBarrasActivo().getPendienteCodigoBarras())
						|| StringUtils.isEmpty(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras())){
					//si el articulo es nuevo
					if(articuloVO.getBaseDTO().getId().getCodigoArticulo() == null) {
						String secuencialArticulo = dataGestor.findNextSequenceValue(SICConstantes.ESQUEMABD, SICArticuloConstantes.getInstancia().NOMBRE_SECUENCIA_ARTICULO, String.class, null);
						articuloVO.getBaseDTO().getId().setCodigoArticulo(secuencialArticulo);
					}
					articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().setCodigoBarras("C"+articuloVO.getBaseDTO().getId().getCodigoArticulo());
					articuloVO.getBaseDTO().getCodigoBarrasActivo().setCodigoBarrasPOS(SICConstantes.VALOR_NOASIGNADO);
					articuloVO.getBaseDTO().getCodigoBarrasActivo().setPendienteCodigoBarras(Boolean.TRUE);

					validarCodigoBarras = Boolean.FALSE;

					//se verifica si el articulo anterior tuvo asignado un codigo de barras, ya que si el codigo actual y el anterior no fueron asignados no se debe modificar la bitacora de codigos de barra
					if(!articuloVO.getEsCreacion() && articuloVO.getBaseDTOAnterior() != null 
							&& BooleanUtils.isTrue(articuloVO.getBaseDTOAnterior().getCodigoBarrasActivo().getPendienteCodigoBarras())){
						articuloVO.setEstValCodBar(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_ACTUALIZAR);
					}
				}
			}
			if(validarCodigoBarras){
				Validator validator = new ValidatorImpl();
				if(!validator.validateEAN(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras())){
					validator = null;
					throw new SICRuleException(SICArticuloMessages.getInstancia().getString("mensaje.error.codigoBarras.noValido"));
				}
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setCodigoBarrasPOS(calcularCodigoBarrasPOS(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo(),
						articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras()));
			}
		}

		if(SICConstantes.CODIGO_SISTEMA_SISPE.equals(articuloVO.getBaseDTO().getCodigoSistemaOrigen())){
			articuloVO.getBaseDTO().setDescripcionArticulo(articuloVO.getBaseDTO().getDescripcionArticulo().concat("-").concat(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras()));
		}
		asignarBitacoraCodigoBarras(articuloVO, bitacoraActual);
	}

	/**
	 * 
	 * @param articuloVO
	 * @param abcb
	 * @throws SICRuleException
	 */
	@Override
	public void asignarBitacoraCodigoBarras(ArticuloVO articuloVO, ArticuloBitacoraCodigoBarrasDTO abcb)throws SICRuleException{
		try{
			//SE DESACTIVA LA BITACORA DEL ARTICULO ACTUAL
			if(articuloVO.getEstValCodBar().equals(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_DESACTIVARCREAR)){
				Date fechaFinalActivo = new Date();
				articuloBitacoraCodigoBarrasDAO.desactivarBitacoraActual(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId(), fechaFinalActivo);
				//se asignan los datos para la nueva bitacora, pero todavia no se registra en base
				articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().setFechaInicialActivo(DateUtils.addMilliseconds(fechaFinalActivo, 1));
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setUserId(articuloVO.getBaseDTO().getUserId());
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setFechaFinalActivo(null);

//				if(!articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo().equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO)
//						&& abcb != null){
//					//se desactiva el registro en la bitacora de codigos de barras para el articulo que actualmente tiene el codigo
//					abcb.setEstadoArticuloBitacora(SICConstantes.ESTADO_INACTIVO_NUMERICO);
//					abcb.setFechaFinalActivo(new Date());
//					dataGestor.update(abcb);
//				}
			}else if(articuloVO.getEstValCodBar().equals(SICArticuloValidacion.getInstancia().VALIDACIONCODIGOBARRAS_ACTUALIZAR) && abcb != null){
				abcb.setCodigoTipoSecuencia(SICArticuloConstantes.getInstancia().TIPOCATALOGO_SECUENCIAINTERNA);
				abcb.setValorTipoSecuencia(articuloVO.getBaseDTO().getCodigoBarrasActivo().getValorTipoSecuencia());
				abcb.setUserId(articuloVO.getBaseDTO().getUserId());
				dataGestor.update(abcb);
			}

			if(articuloVO.getBaseDTO().getCodigoBarrasActivo().getPendienteCodigoBarras() == null){
				articuloVO.getBaseDTO().getCodigoBarrasActivo().setPendienteCodigoBarras(Boolean.FALSE);
			}
		}catch(SICException e){
			throw e;
		}catch(Exception e){
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
		articuloDTO.getCodigoBarrasActivo().getId().setCodigoBarras(String.valueOf(articuloBitacoraCodigoBarrasDAO.obtenerSecuenciaInternaDisponible(articuloDTO.getId().getCodigoCompania(), 
				articuloDTO.getCodigoBarrasActivo().getValorTipoSecuencia(),articuloDTO.getUserId())));
		return articuloDTO.getCodigoBarrasActivo().getId().getCodigoBarras();
	}

	/**
	 * 
	 * @param artmat
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposArticuloMaterial(ArticuloMaterialDTO artmat){
		if(StringUtils.isEmpty(artmat.getEstado())){
			artmat.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);}
		if(artmat.getEsPrincipal()== null){
			artmat.setEsPrincipal(Boolean.FALSE);}

		if(StringUtils.isNotEmpty(artmat.getId().getValorTipoMaterial()) && !SICConstantes.VALOR_NOASIGNADO.equals(artmat.getId().getValorTipoMaterial())){
			artmat.getId().setCodigoTipoMaterial(SICArticuloConstantes.getInstancia().CODIGOTIPOMATERIAL);
		}else{
			artmat.getId().setValorTipoMaterial(SICConstantes.VALOR_NOASIGNADO);
			artmat.getId().setCodigoTipoMaterial(SICConstantes.CODIGO_CATALOGO_OMISION);
		}

	}
	/**
	 * 
	 * @param artgat
	 */
	@Override
	public void asignarCamposArticuloGarantia(ArticuloGarantiaDTO artgat){
		if(StringUtils.isEmpty(artgat.getEstadoGarantia())){
			artgat.setEstadoGarantia(SICConstantes.ESTADO_INACTIVO_NUMERICO);
		}
		if(StringUtils.isEmpty(artgat.getEstadoExtensionGarantia())){
			artgat.setEstadoExtensionGarantia(SICConstantes.ESTADO_INACTIVO_NUMERICO);
		}
	}

	/**
	 * 
	 * @param dto
	 */
	@Override
	public void asignarCamposArticuloInternet(ArticuloInternetDTO dto){
		if(StringUtils.isEmpty(dto.getEstadoPublicacion())){
			dto.setEstadoPublicacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
	}
	/**
	 * 
	 * @param aum
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposArticuloComercial(ArticuloDTO art){
		ArticuloComercialDTO ac = art.getArticuloComercialDTO();
		//VALOR POR DEFECTO FECHA DE CADUCIDAD REQUERIDO
		if(ac.getVerFecCadRec() == null){
			ac.setVerFecCadRec(Boolean.FALSE);}
		if(StringUtils.isNotEmpty(ac.getValorTipoControlCosto()) && !SICConstantes.VALOR_NOASIGNADO.equals(ac.getValorTipoControlCosto())){
			ac.setCodigoTipoControlCosto(SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoControlCosto"));}
		else{
			ac.setValorTipoControlCosto(SICConstantes.VALOR_NOASIGNADO);
			ac.setCodigoTipoControlCosto(SICConstantes.CODIGO_CATALOGO_OMISION);
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

		ac.setEstadoOrigenArticulo(obtenerOrigenArticulo(art));

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
	}

	public String obtenerOrigenArticulo(ArticuloDTO art){
		String origenImportado = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado");
		String estadoOrigenArticulo = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.nacional");
		Collection<ArticuloProveedorDTO> registros = null;
		if(!art.getTieneArticuloProveedor()){
			ArticuloProveedorDTO ap = new ArticuloProveedorDTO();
			ap.getId().setCodigoCompania(art.getId().getCodigoCompania());
			ap.getId().setCodigoArticulo(art.getId().getCodigoArticulo());
			ap.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			ap.setProveedor(new ProveedorDTO());
			ap.getProveedor().setProveedorImportado(new ProveedorImportadoDTO());

			registros = dataGestor.findObjects(ap);
		}else{
			registros = art.getArticuloProveedorCol();
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

	/**
	 * 
	 * @param articuloUsoDTO
	 * @throws SICException
	 */
	@Override
	public void asignarCamposArticuloUso(ArticuloUsoDTO articuloUsoDTO)throws SICException{
		if(StringUtils.isNotEmpty(articuloUsoDTO.getId().getValorTipoUso()) && !SICConstantes.VALOR_NOASIGNADO.equals(articuloUsoDTO.getId().getValorTipoUso())){
			articuloUsoDTO.getId().setCodigoTipoUso(TipoCatalogoArticulo.TIPOS_USO_CARNES);
		}else{
			articuloUsoDTO.getId().setValorTipoUso(SICConstantes.VALOR_NOASIGNADO);
			articuloUsoDTO.getId().setCodigoTipoUso(SICConstantes.CODIGO_CATALOGO_OMISION);
		}
	}
	/**
	 * 
	 * @param articuloEtiquetaDTO
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposArticuloDespacho(ArticuloProcesoLogisticoDTO articuloProcesoLogisticoDTO){
		if(StringUtils.isNotEmpty(articuloProcesoLogisticoDTO.getValorTipoDistribucion()) &&
				!SICConstantes.VALOR_NOASIGNADO.equals(articuloProcesoLogisticoDTO.getValorTipoDistribucion())){
			articuloProcesoLogisticoDTO.setCodigoTipoDistribucion(SICArticuloConstantes.getInstancia().CODIGOCATALOGO_TIPODISTRIBUCION);
		}else{
			articuloProcesoLogisticoDTO.setCodigoTipoDistribucion(SICConstantes.CODIGO_CATALOGO_OMISION);
			articuloProcesoLogisticoDTO.setValorTipoDistribucion(SICConstantes.VALOR_NOASIGNADO);
		}

		if(articuloProcesoLogisticoDTO.getTieneTara() == null){
			articuloProcesoLogisticoDTO.setTieneTara(Boolean.FALSE);
		}

		if(articuloProcesoLogisticoDTO.getCodigoIndicadorPropietario() == null){
			articuloProcesoLogisticoDTO.setCodigoIndicadorPropietario(SICArticuloConstantes.getInstancia().INDICADORPROPIETARIOGENERAL);
		}

		//valorContenedorDistribucion
		if(StringUtils.isNotEmpty(articuloProcesoLogisticoDTO.getValorContenedorDistribucion()) &&
				!SICConstantes.VALOR_NOASIGNADO.equals(articuloProcesoLogisticoDTO.getValorContenedorDistribucion())){
			articuloProcesoLogisticoDTO.setCodigoContenedorDistribucion(SICArticuloConstantes.getInstancia().CODIGOTIPOEMPAQUE);
		}else {
			articuloProcesoLogisticoDTO.setCodigoContenedorDistribucion(null);
			articuloProcesoLogisticoDTO.setValorContenedorDistribucion(null);}

		//AREA DE BODEGA
		if(StringUtils.isNotEmpty(articuloProcesoLogisticoDTO.getValorAreaConservacionBodega()) &&
				!SICConstantes.VALOR_NOASIGNADO.equals(articuloProcesoLogisticoDTO.getValorAreaConservacionBodega())){
			articuloProcesoLogisticoDTO.setCodigoAreaConservacionBodega(SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOAREASBODEGA);
		}else{
			articuloProcesoLogisticoDTO.setValorAreaConservacionBodega(null);
			articuloProcesoLogisticoDTO.setCodigoAreaConservacionBodega(null);
		}
	}

	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOPROCESOLOGISTICO
	 * @param articuloVO
	 * @param esCreacion
	 */
	public void registrarArticuloProcesoLogistico(ArticuloVO articuloVO,Boolean esCreacion){

		Logeable.LOG_SICV2.info("==> Registrando Articulo Proceso Logistico");

		if(articuloVO.getBaseDTO().getTieneArticuloProcesoLogistico()){
			articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
			articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
			articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setUserId(articuloVO.getBaseDTO().getUserId());
			this.asignarCamposArticuloDespacho(articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO());
			if(esCreacion){
				dataGestor.create(articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO());
			}else{
				dataGestor.createOrUpdate(articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO());
			}
		}
	}

	/**
	 * 
	 * @param articuloMedidaDTO
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposArticuloMedida(ArticuloMedidaDTO articuloMedidaDTO){
		if(StringUtils.isEmpty(articuloMedidaDTO.getValorTipoMedida())){
			articuloMedidaDTO.setCodigoTipoMedida(SICConstantes.CODIGO_CATALOGO_OMISION);
			articuloMedidaDTO.setValorTipoMedida(SICConstantes.VALOR_NOASIGNADO);
		}
		if(articuloMedidaDTO.getReferenciaMedida() == null){
			articuloMedidaDTO.setReferenciaMedida("");}

		if(articuloMedidaDTO.getPresentacion() == null){
			articuloMedidaDTO.setPresentacion(SICArticuloConstantes.getInstancia().VALOR_PRESENTACION_ARTICULO_MEDIDA);
		}

		if(articuloMedidaDTO.getCantidadMedida() == null){
			articuloMedidaDTO.setCantidadMedida(1D);
		}
	}

	/**
	 * 
	 * @param articuloVO
	 * @param unidadesManejo
	 */
	@Override
	public final void refrescarUnidadesManejo(ArticuloVO articuloVO , Collection<ArticuloUnidadManejoDTO> unidadesManejo){
		if(CollectionUtils.isNotEmpty(unidadesManejo)){
			if(CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())){

				//se busca las unidades de manejo que con tenga codigounidadmanejo para actualizar sus usos
				Collection<ArticuloUnidadManejoDTO> unidadesManejoFounds = CollectionUtils.select(articuloVO.getBaseDTO().getArticuloUnidadManejoCol(), PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoUnidadManejo"), PredicateUtils.nullPredicate()));

				if(CollectionUtils.isNotEmpty(unidadesManejoFounds)){

					for(ArticuloUnidadManejoDTO unidadManejoDTO : unidadesManejoFounds){

						Predicate predicate = null;

						//si contiene codigo de compania se construye su predicado
						if(unidadManejoDTO.getId().getCodigoCompania() != null){
							predicate = PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoCompania"), PredicateUtils.equalPredicate(unidadManejoDTO.getId().getCodigoCompania()));
						}

						//si contiene valorUnidadManejo se construye su predicado
						if(unidadManejoDTO.getValorUnidadManejo() != null){
							predicate = PredicateUtils.andPredicate(
									predicate, 
									new BeanPredicate("valorUnidadManejo", PredicateUtils.equalPredicate(unidadManejoDTO.getValorUnidadManejo()))
									);
						}

						//si contiene valorTipoUnidadEmpaque se construye su predicado
						if(unidadManejoDTO.getValorTipoUnidadEmpaque() != null){
							predicate = PredicateUtils.andPredicate(
									predicate, 
									new BeanPredicate("valorTipoUnidadEmpaque", PredicateUtils.equalPredicate(unidadManejoDTO.getValorTipoUnidadEmpaque()))
									);
						}

						//busca en la collecion de unidades de manejo para obtener sus usos
						Collection<ArticuloUnidadManejoDTO> unidadManejoFound =  CollectionUtils.select(unidadesManejo, predicate);

						if(CollectionUtils.isNotEmpty(unidadManejoFound)){
							for(ArticuloUnidadManejoUsoDTO usoSinID : unidadManejoDTO.getArticuloUnidadManejoUsoCol()){

								for(ArticuloUnidadManejoDTO unidadManejoConUso : unidadManejoFound)	{

									ArticuloUnidadManejoUsoDTO usoID =  (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(unidadManejoConUso.getArticuloUnidadManejoUsoCol() , 
											PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), PredicateUtils.equalPredicate(usoSinID.getId().getValorTipoUso())));

									if(usoID != null){

										usoSinID.setId(usoID.getId());
										break;
									}
								}
							}
						}
					}
				}else{

					for(ArticuloUnidadManejoDTO articuloUnidadManejoDTO : articuloVO.getBaseDTO().getArticuloUnidadManejoCol()){

						Collection<ArticuloUnidadManejoDTO> articuloUnidadesManejo = CollectionUtils.select(unidadesManejo, new BeanPredicate("valorUnidadManejo", PredicateUtils.equalPredicate(articuloUnidadManejoDTO.getValorUnidadManejo())));

						if(CollectionUtils.isNotEmpty(articuloUnidadesManejo)){

							for(ArticuloUnidadManejoUsoDTO usoDTO : articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol()){

								for(ArticuloUnidadManejoDTO unidadManejoDTO : articuloUnidadesManejo){

									ArticuloUnidadManejoUsoDTO usoID =  (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(unidadManejoDTO.getArticuloUnidadManejoUsoCol() , 
											PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), PredicateUtils.equalPredicate(usoDTO.getId().getValorTipoUso())));

									if(usoID != null){

										usoDTO.setId(usoID.getId());
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public String obtenerTipoCalculoPrecio(ArticuloDTO articuloDTO){
		//TODO falta implementacion
		return null;
	}

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public Boolean esPosibleIncluirArticuloEnReceta(ArticuloDTO articuloDTO){
		//TODO definir regla
		return Boolean.TRUE;
	}

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public void calcularPrecios(ArticuloDTO articuloDTO, Boolean calcularMargenPVP, Boolean calcularMargenPBase){
		Double costoNeto = calcularCostoNeto(articuloDTO.getArticuloProveedorCol());
		ArticuloPrecioDTO pvp = null;
		ArticuloPrecioDTO pbase = null;
		for(ArticuloPrecioDTO ap : articuloDTO.getArticuloPrecioCol()){
			if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP)){
				pvp = ap;}
			if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)){
				pbase = ap;}
		}
		if(calcularMargenPVP){
			calcularMargenPrecio(pvp, costoNeto);}
		else{
			calcularPVP(pvp, costoNeto);}

		if(calcularMargenPBase){
			calcularMargenPrecio(pbase, costoNeto);}
		else{
			calcularPrecioBase(pbase, costoNeto);}
	}

	/**
	 * 
	 * @param artPros
	 * @return
	 */
	@Override
	public Double calcularCostoNeto(Collection<ArticuloProveedorDTO> artPros){
		if(artPros.size() == 1){
			return calcularCostoNeto(artPros.iterator().next());
		}
		//TODO esta implementacion es temporal
		Double costoNeto = 0d;
		for(ArticuloProveedorDTO ap : artPros){
			costoNeto = costoNeto + calcularCostoNeto(ap);
		}
		//se obtiene el promedio
		return SICUtil.getInstance().roundNumber(costoNeto/artPros.size(), SICConstantes.CANTIDADDECIMALCUATRO);
	}

	/**
	 * 
	 * @param ap
	 * @return
	 */
	@Override
	public Double calcularCostoNeto(ArticuloProveedorDTO ap) throws SICException{
		return calcularCostoNeto(ap, Boolean.FALSE, Boolean.FALSE);
	}
	
	/**
	 * 
	 * @param ap
	 * @return
	 */
	@Override
	public Double calcularCostoNeto(ArticuloProveedorDTO ap, Boolean usarCostoMonedaOrigen, Boolean calcularConComisionImportacion) throws SICException{
		if(usarCostoMonedaOrigen && !ap.getTieneArticuloImportacion()){
			throw new SICException("No se puede calcular el costo neto porque faltan los datos de la importaci\u00F3n");
		}	
		Double costoNeto = usarCostoMonedaOrigen ? (Double)ap.getArticuloImportacion().getCostoMonedaOrigen().doubleValue() : ap.getCostoBruto();
		if(costoNeto != null){
			if(usarCostoMonedaOrigen && calcularConComisionImportacion && ap.getArticuloImportacion().getPorcentajeComision() != null){
				costoNeto = costoNeto * (1 + ap.getArticuloImportacion().getPorcentajeComision()/100);
			}
			
			costoNeto = this.calcularCostoNeto(costoNeto, ap.getDescuentoProveedorArticuloCol(), ap.getUnidadesManejo());

			if(usarCostoMonedaOrigen){
				if(calcularConComisionImportacion){
					ap.setCostoNetoImportacionComision(costoNeto);
				}else{
					ap.setCostoNetoImportacion(costoNeto);}
			}else{
				ap.setCostoNeto(costoNeto);}
		}
		return costoNeto;
	}
	
	/**
	 * Procesa los valores de costos brutos y devuelve valores netos
	 * @param ap
	 * @param codigoProyectado
	 * @author adgonzalez
	 * @return
	 */
	@Override
	public Double calcularCostoNeto(ArticuloProveedorDTO ap, String codigoProyectado) throws SICException {
		Double costoNeto = null;
		//Se comprueba que los parametros no sean nulos
		if(ap != null && codigoProyectado != null 
				&& CollectionUtils.isNotEmpty(ap.getArticuloProveedorCostoCol()) 
				&& SearchDTO.isLoaded(ap.getArticuloProveedorCostoCol())){
			//Recorre los articulos para asignar el costo neto
			for(ArticuloProveedorCostoDTO apc:ap.getArticuloProveedorCostoCol()){
				if(StringUtils.equals(apc.getId().getValorTipoCosto(), codigoProyectado)){	
					costoNeto = apc.getValor();
				}
			}	
		}
				
		if(costoNeto != null){
			costoNeto = this.calcularCostoNeto(costoNeto, ap.getDescuentoProveedorArticuloCol(), ap.getUnidadesManejo());
		}
		return costoNeto;
	}
	

	/**
	 * Procesa los valores de costos brutos y devuelve valores netos
	 * @param ap
	 * @author adgonzalez
	 * @return
	 */
	@Override
	public void calcularCostoNetoProyectado(ArticuloProveedorDTO ap) throws SICException {
		//Se comprueba que los parametros no sean nulos
		if(ap != null && CollectionUtils.isNotEmpty(ap.getArticuloProveedorCostoCol()) 
				&& SearchDTO.isLoaded(ap.getArticuloProveedorCostoCol())){
			//Recorre los articulos para asignar el costo neto
			for(ArticuloProveedorCostoDTO apc:ap.getArticuloProveedorCostoCol()){
				Double costoNetoProyectado = apc.getValor();			
				costoNetoProyectado = this.calcularCostoNeto(costoNetoProyectado, ap.getDescuentoProveedorArticuloCol(), ap.getUnidadesManejo());
				apc.setCostoNetoProyectado(costoNetoProyectado);	
			}	
		}
	}
	
	
	public Double calcularCostoNeto(Double costoBruto, final Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, final Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo) throws SICException {
		Double costoNetoReal = null;
		if(costoBruto != null){
			costoNetoReal = this.calcularCadenaDescuentos(costoBruto, descuentoProveedorArticuloCol, unidadesManejo);
			costoNetoReal = SICUtil.getInstance().roundNumber(costoNetoReal, SICConstantes.CANTIDADDECIMALCUATRO);
		}
		return costoNetoReal;
	}
	
	@Deprecated
	@SuppressWarnings("unchecked")
	public final Double calcularCadenaDescuentos( Double costoNeto , final Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, final Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo){

		// Aplicar cadena de descuentos
		if( CollectionUtils.isNotEmpty(descuentoProveedorArticuloCol) ){

			// Ordernar cadena de descuentos por prioridad
			Collection<DescuentoProveedorArticuloDTO> desProArtCol = ColeccionesUtil.sort(descuentoProveedorArticuloCol, ColeccionesUtil.ORDEN_ASC, "asignacionTipoDescuento.prioridad");
			
			// Aplicar cadena de descuentos al costo bruto
			for(DescuentoProveedorArticuloDTO dpa : desProArtCol){

				if(StringUtils.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO, dpa.getEstado()) 
						&& EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento().equals(dpa.getAsignacionTipoDescuento().getValorAplicacionTipoDescuento())) {

					if(dpa.getEquivalenciaPorcentajeDescuento() != null){
						costoNeto = costoNeto * (1 - dpa.getEquivalenciaPorcentajeDescuento().getDescuento()/100);
						dpa.addDynamicProperty(DescuentoProveedorArticuloDTO.COSTO_NETO_PARCIAL, SICUtil.getInstance().roundNumber(costoNeto, SICConstantes.CANTIDADDECIMALCUATRO));
					} else if( dpa.getPorcentajeDescuento() != null  ) {
						costoNeto = costoNeto * (1 - dpa.getPorcentajeDescuento()/100);
						dpa.addDynamicProperty(DescuentoProveedorArticuloDTO.COSTO_NETO_PARCIAL, SICUtil.getInstance().roundNumber(costoNeto, SICConstantes.CANTIDADDECIMALCUATRO));
					} else{
						dpa.addDynamicProperty(DescuentoProveedorArticuloDTO.COSTO_NETO_PARCIAL, new Double(0));
					}

				}

			}

		}

		// Aplicar cadena de descuentos por unidad de manejo
		if( CollectionUtils.isNotEmpty(unidadesManejo) ) {

			Double costoNetoPromedio = 0d;
			Double costoNetoIndividual = 0d;
			int cantidadPromediar = 0;

			for(ArticuloUnidadManejoProveedorDTO aum : unidadesManejo) {

				if(aum.getEquivalenciaPorcentajeDescuentoDTO() != null
						&& aum.getEquivalenciaPorcentajeDescuentoDTO().getId().getCodigoEquivalencia() != null
						&& aum.getEquivalenciaPorcentajeDescuentoDTO().getDescuento() != null
						&& SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(aum.getEstado())) {
					
					costoNetoIndividual = costoNeto * (1 - aum.getEquivalenciaPorcentajeDescuentoDTO().getDescuento()/100);
					costoNetoPromedio = costoNetoPromedio + costoNetoIndividual;
					aum.addDynamicProperty(ArticuloUnidadManejoProveedorDTO.COSTO_NETO_PARCIAL, SICUtil.getInstance().roundNumber(costoNetoIndividual, SICConstantes.CANTIDADDECIMALCUATRO));
					cantidadPromediar++;
						
				} else {
					aum.addDynamicProperty(ArticuloUnidadManejoProveedorDTO.COSTO_NETO_PARCIAL, new Double(0));
				}

			}

			// Caclcular promedio de la sumatoria de los descuentos individuales por unidad de manejo 
			if(costoNetoPromedio > 0) {
				costoNetoPromedio = costoNetoPromedio / cantidadPromediar;
				costoNeto = costoNetoPromedio;
			}

		}

		return costoNeto;
	}

	/**
	 * 
	 * Permite obtener el costo bruto a partir del costo neto, quitando al costo neto los descuentos
	 * por unidades de manejo y la cadena de descuentos. Es obligatorio que el parametro
	 * <code>articuloProveedorCostoNeto<code> tenga fijado el costo neto, y todas las relaciones de descuentos
	 * 
	 * @param articuloProveedorCostoNeto      Datos articulo proveedor y sus descuentos
	 * @return Double                         Costo bruto
	 */
	@SuppressWarnings("unchecked")
	public Double calcularCostoBrutoInversoCostoNeto(ArticuloProveedorDTO articuloProveedorCostoNeto) throws SICException {

		// Reversar calculos de costo neto para obtener el costo bruto inicial
		Double costoBruto = articuloProveedorCostoNeto.getCostoNeto();

		if(costoBruto != null) {

			// 1. Reversar calculo de costo neto por unidades de manejo
			if(CollectionUtils.isNotEmpty(articuloProveedorCostoNeto.getUnidadesManejo())){

				Double sumaPorcentajesUnidadesManejo = 0D;
				Integer contadorPorcentajesUnidadesManejo = 0;

				for(ArticuloUnidadManejoProveedorDTO aum : articuloProveedorCostoNeto.getUnidadesManejo()) {
					if(aum.getEquivalenciaPorcentajeDescuentoDTO() != null && SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(aum.getEstado())) {
						contadorPorcentajesUnidadesManejo++;
						sumaPorcentajesUnidadesManejo = sumaPorcentajesUnidadesManejo + (1 - aum.getEquivalenciaPorcentajeDescuentoDTO().getDescuento() / Double.valueOf("100"));
					}
				}

				if(sumaPorcentajesUnidadesManejo != 0){
					costoBruto = (costoBruto * contadorPorcentajesUnidadesManejo) / sumaPorcentajesUnidadesManejo;
				}

			}


			// 2. Reversar calculo de costo neto por cadena de descuentos
			if(CollectionUtils.isNotEmpty(articuloProveedorCostoNeto.getDescuentoProveedorArticuloCol())) {

				// Ordenar cadena de descuentos
				Collection<DescuentoProveedorArticuloDTO> descuentosCondicionesComerciales = ColeccionesUtil.sort(articuloProveedorCostoNeto.getDescuentoProveedorArticuloCol(), ColeccionesUtil.ORDEN_DESC, "asignacionTipoDescuento.prioridad");

				for(DescuentoProveedorArticuloDTO dpa : descuentosCondicionesComerciales){
					// <>TIPODESCUENTO
					if(dpa.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) &&
							dpa.getAsignacionTipoDescuento().getValorAplicacionTipoDescuento().equals(EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento())) {

						if(dpa.getEquivalenciaPorcentajeDescuento() != null) {
							costoBruto = costoBruto / (1 - dpa.getEquivalenciaPorcentajeDescuento().getDescuento() / Double.valueOf("100"));
						} else {
							costoBruto = costoBruto / (1 - dpa.getPorcentajeDescuento() / Double.valueOf("100"));
						}

					}
				}
			}

		}

		return (costoBruto != null) ? SICUtil.getInstance().roundNumber(costoBruto, SICConstantes.CANTIDADDECIMALCUATRO) : null;
	}

	/**
	 * 
	 * @param ap
	 * @return
	 */
	@Override
	public Double calcularCostoNeto(ArticuloProveedorDTO ap, Boolean usarCostoMonedaOrigen) throws SICException{
		if(usarCostoMonedaOrigen){
			ParametroDTO par = new ParametroDTO();
			par.getId().setCodigoCompania(ap.getId().getCodigoCompania());
			par.getId().setCodigoParametro(SICParametros.getInstancia().CALCULARCOSTONETO_CONCOMISIONIMPORTACION);
			par = dataGestor.findUnique(par);
			if(par != null && par.getValorParametro() != null){
				return calcularCostoNeto(ap, Boolean.TRUE, par.getValorParametro().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO));
			}
			return null;
		}
		return calcularCostoNeto(ap, Boolean.FALSE, Boolean.FALSE);
	}
	


	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public Double calcularCostoNetoNotaCredito(ArticuloProveedorDTO ap){
		return this.calcularCostoNetoNotaCredito(ap.getDescuentoProveedorArticuloCol(), ap.getCostoNeto());
	}
	
	/**
	 * Calcula el costoNC neto nuevo tomando en cuenta los descuentos anteriores
	 */
	@Override
	public Double calcularCostoNetoNotaCredito(Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, Double costoNeto) {
		if(costoNeto != null) {
			for(DescuentoProveedorArticuloDTO dpa : descuentoProveedorArticuloCol) {
				if(dpa.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && 
						SICArticuloConstantes.getInstancia().TIPODESCUENTONOTACREDITO.equals(dpa.getAsignacionTipoDescuento().getCodigoTipoDescuento())){
					costoNeto = costoNeto * (1 - dpa.getPorcentajeDescuento()/100);
					break;}
			}
			costoNeto = SICUtil.getInstance().roundNumber(costoNeto, SICConstantes.CANTIDADDECIMALCUATRO);
		}
		return costoNeto;
	}

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public Double calcularPVP(ArticuloPrecioDTO pvp, Double costoNeto){
		if(costoNeto != null && pvp.getMargenPrecio() != null){
			pvp.setValorActual(SICUtil.getInstance().roundNumber(costoNeto / (1 - pvp.getMargenPrecio()/100), SICConstantes.CANTIDADDECIMALFINAL));
		}else{
			pvp.setValorActual(null);}
		return pvp.getValorActual();
	}
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public Double calcularPrecioBase(ArticuloPrecioDTO precioBase, Double costoNeto){
		if(costoNeto != null && precioBase.getMargenPrecio() != null){
			precioBase.setValorActualSinDescuento(SICUtil.getInstance().roundNumber(costoNeto / (1 - precioBase.getMargenPrecio()/100), SICConstantes.CANTIDADDECIMALFINAL));
			precioBase.setValorActual(precioBase.getValorActualSinDescuento()); //este valor es usado en el siguiente metodo
		}else{
			precioBase.setValorActualSinDescuento(null);
			precioBase.setValorActual(null);}
		return precioBase.getValorActual();
	}
	

	/**
	 * @param precioBase
	 * @param articuloComercial
	 * @return
	 */
	@Override
	public Double calcularPrecioBaseNoAfiliado(Double precioBase, ArticuloComercialDTO articuloComercial) {
		if(precioBase != null && SearchDTO.isLoaded(articuloComercial) && !articuloComercial.getVentaPrecioAfiliado()) {
			return SICArticuloCalculo.getInstancia().calcularPrecioBaseNoAfiliado(precioBase, articuloComercial.getPorcentajeNoAfiliado());
		}
		return precioBase;
	}
	
//	@Override
//	public Double calcularPrecioBaseNoAfiliado(Double precioBase, Double porcentajeNoAfiliado) {
//		if(precioBase != null && porcentajeNoAfiliado != null) {
//			return SICUtil.getInstance().roundNumber(precioBase * (1 + porcentajeNoAfiliado/100), SICConstantes.CANTIDADDECIMALFINAL);
//		}
//		return precioBase;
//	}

	/**
	 * 
	 * @param precioBase
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Double calcularPrecioBaseSinDescuento(ArticuloPrecioDTO precioBase){
		if(precioBase.getArticulo().getDescuentoVentaArticuloCol() != null){
			Double precioInicial = precioBase.getValorActual();
			Collection<DescuentoVentaArticuloDTO> desVenArtCol = ColeccionesUtil.sort(precioBase.getArticulo().getDescuentoVentaArticuloCol(), ColeccionesUtil.ORDEN_DESC, "asignacionTipoDescuento.prioridad");
			for(DescuentoVentaArticuloDTO dva : desVenArtCol){
				if(dva.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
					precioInicial = precioInicial / (1 - dva.getPorcentajeDescuento()/100);}
			}
			return SICUtil.getInstance().roundNumber(precioInicial, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return precioBase.getValorActual();
	}

	/**
	 * 
	 * @param precioBase
	 * @return
	 */
	@Override
	public Double calcularPrecioBaseConDescuento(ArticuloPrecioDTO precioBase){
		if(precioBase.getArticulo().getDescuentoVentaArticuloCol() != null){
			Double precioInicial = precioBase.getValorActual();
			Collection<DescuentoVentaArticuloDTO> desVenArtCol = ColeccionesUtil.sort(precioBase.getArticulo().getDescuentoVentaArticuloCol(), ColeccionesUtil.ORDEN_ASC, "asignacionTipoDescuento.prioridad");
			for(DescuentoVentaArticuloDTO dva : desVenArtCol){
				if(dva.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){ 
					precioInicial = precioInicial * (1 - dva.getPorcentajeDescuento()/100);}
			}
			return SICUtil.getInstance().roundNumber(precioInicial, SICConstantes.CANTIDADDECIMALFINAL);
		}
		return precioBase.getValorActual();
	}

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public Double calcularMargenPrecio(ArticuloPrecioDTO precio, Double costoNeto){
		if(costoNeto != null && precio.getValorActual() != null && precio.getValorActual() > 0){
			precio.setMargenPrecio(SICArticuloCalculo.getInstancia().calcularMargenPrecio(precio.getValorActual(), costoNeto));
		}else{
			precio.setMargenPrecio(null);}
		return precio.getMargenPrecio();
	}

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public Double calcularDistanciamiento(ArticuloPrecioDTO precioBase, ArticuloPrecioDTO pvp){
		if(precioBase.getValorActual() != null && pvp.getValorActual() != null && pvp.getValorActual() > 0){
			return SICUtil.getInstance().roundNumber((1 - precioBase.getValorActual() / pvp.getValorActual())*100,SICConstantes.CANTIDADDECIMALFINAL);
		}
		return null;
	}

	@Override
	public void asignarPrototipoAlcance(ArticuloDTO articuloDTO)throws SICRuleException{
		Long prototipo = articuloDAO.obtenerPrototipoAlcance(articuloDTO.getId().getCodigoCompania(), articuloDTO.getId().getCodigoArticulo());
		articuloDTO.setCodigoGrupoAlcance(prototipo);
	}
	
//	@Override
//	public void asignarPrototipoCoincidente(ArticuloDTO articuloDTO , String areasTrabajo)throws SICRuleException{
//		Logeable.LOG_SICV2.info("verificando locales en prototipos");
//		Logeable.LOG_SICV2.info("locales asignados: "+areasTrabajo);
//		Long prototipo = SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO;
//		VistaGrupoAlcanceLocalDTO vga = new VistaGrupoAlcanceLocalDTO();
//		vga.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
//		vga.setAreasTrabajo(areasTrabajo);
//		if(!StringUtils.isEmpty(vga.getAreasTrabajo())){
//			Collection<VistaGrupoAlcanceLocalDTO> col = dataGestor.findObjects(vga);
//			if(!col.isEmpty()){
//				prototipo = col.iterator().next().getId().getCodigoGrupoTrabajo();}
//		}
//		Logeable.LOG_SICV2.info("nuevo prototipo: "+prototipo.toString());
//		if(!SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO.equals(prototipo)){
//			articuloDAO.actualizarPrototipoAlcance(articuloDTO, prototipo);
//		}
//		articuloDTO.setCodigoGrupoAlcance(prototipo);
//	}

	private String agruparLocales(Collection<ArticuloLocalDTO> col){
		Collection<ArticuloLocalDTO> ordCol = ColeccionesUtil.sort(col, ColeccionesUtil.ORDEN_ASC, "id.codigoLocal");
		String locales = "";
		for(ArticuloLocalDTO al : ordCol){
			if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(al.getEstadoArticuloLocal())){
				locales = locales.concat(",").concat(al.getId().getCodigoLocal().toString());
			}
		}
		if(locales.length() > 0){
			locales = locales.substring(1);
		}
		//se elimina el primer separador
		return locales;
	}

	/**
	 * Retorna el precio de caja usando el precio unitario base y la unidad de manejo 
	 */
	@Override
	@Deprecated
	public Double calcularPrecioCaja(ArticuloUnidadManejoDTO aum, Double precioBase, Double precioBaseImp){
		try{
			Double precioCaja = precioBase.doubleValue() * aum.getValorUnidadManejo().intValue();
			Double divisor = calcularDivisorPrecioCaja(aum, precioBaseImp);
			if(divisor != null){
				//se calcula un precio de caja fraccionado
				double descuento = 0d;
				double unidadManejoFraccion = Math.floor(aum.getValorUnidadManejo().intValue() / divisor.doubleValue());
				if(unidadManejoFraccion == 0d){
					unidadManejoFraccion = 1d;
				}
				if(aum.getDescuentoVenta() != null){
					descuento = precioCaja.doubleValue() * aum.getDescuentoVenta().doubleValue()/100;
					descuento = descuento/divisor.doubleValue();
				}
				precioCaja = precioBase.doubleValue() * unidadManejoFraccion;
				precioCaja = precioCaja.doubleValue() - descuento;
				LOG_SICV2.info("descuento: "+descuento);
				LOG_SICV2.info("unidad manejo: "+unidadManejoFraccion);
				return SICUtil.getInstance().roundNumber(precioCaja, SICConstantes.CANTIDADDECIMALFINAL);
			}
			if(aum.getDescuentoVenta() != null){
				precioCaja = precioCaja * (1 - aum.getDescuentoVenta()/100);}
			return SICUtil.getInstance().roundNumber(precioCaja, SICConstantes.CANTIDADDECIMALFINAL);
		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}

	/**
	 * Retorna el precio de caja usando el precio unitario base y la unidad de manejo 
	 */
	@Override
	@Deprecated
	public Double calcularPrecioMayorista(ArticuloUnidadManejoDTO aum, Double precioBase){
		try{
			Double precioMayorista = precioBase;
			if(aum.getDescuentoVenta() != null){
				precioMayorista = precioMayorista * (1 - aum.getDescuentoVenta()/100);}
			return SICUtil.getInstance().roundNumber(precioMayorista, SICConstantes.CANTIDADDECIMALFINAL);
		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}

	/**
	 * Retorna la unidad de manejo prorrateada para la venta
	 * @param aum
	 * @param precioBase
	 * @return
	 */
	@Override
	@Deprecated
	public Integer calcularUnidadManejoVenta(ArticuloUnidadManejoDTO aum, Double precioBase){
		try{
			Double divisor = calcularDivisorPrecioCaja(aum, precioBase);
			if(divisor != null){
				return Integer.valueOf(Double.valueOf(Math.floor(aum.getValorUnidadManejo().intValue() / divisor.doubleValue())).intValue());
			}
			return aum.getValorUnidadManejo();
		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}

	/**
	 * Retorna el valor divisor para calcular el precio de caja fraccionado para la venta
	 * @param aum
	 * @param precioBase
	 * @return
	 */
	@Deprecated
	private Double calcularDivisorPrecioCaja(ArticuloUnidadManejoDTO aum, Double precioBase){
		try{
			double fraccion = 0d;
			Double precioCaja = precioBase.doubleValue() * aum.getValorUnidadManejo().intValue();
			if(aum.getValorUnidadManejo() > SICArticuloCalculo.getInstancia().VALORMAXIMO_UNIDADVENTA_POS){
				fraccion = (double)(aum.getValorUnidadManejo().intValue() + SICArticuloCalculo.getInstancia().VALORMAXIMO_UNIDADVENTA_POS.intValue()) / SICArticuloCalculo.getInstancia().VALORMAXIMO_UNIDADVENTA_POS.intValue();
			}else if(precioCaja > SICArticuloCalculo.getInstancia().VALORMAXIMO_PRECIOVENTAVENTA_POS){
				fraccion = (precioCaja.doubleValue() + SICArticuloCalculo.getInstancia().VALORMAXIMO_PRECIOVENTAVENTA_POS.doubleValue()) / SICArticuloCalculo.getInstancia().VALORMAXIMO_PRECIOVENTAVENTA_POS.doubleValue();
			}else{
				return null;
			}
			return Double.valueOf(fraccion);

		}catch (Exception e) {Logeable.LOG_SICV2.error("", e);}
		return null;
	}

	public ArticuloDTO asignarRelacionesArticuloCodigoBarrasActivo(Integer codigoCompania, String codigoBarras) throws SICException {
		ArticuloBitacoraCodigoBarrasDTO abcb = new ArticuloBitacoraCodigoBarrasDTO();
		abcb.getId().setCodigoBarras(codigoBarras);
		abcb.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		ArticuloDTO art = new ArticuloDTO();
		art.getId().setCodigoCompania(codigoCompania);
		art.setArtBitCodBarCol(new HashSet<ArticuloBitacoraCodigoBarrasDTO>());
		art.getArtBitCodBarCol().add(abcb);
		art.setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		return art;
	}

	public ClasificacionDTO asignarRelacionesEstructuraComercialCliente() throws SICException {
		ClasificacionDTO cla = new ClasificacionDTO();
		cla.setClasificacionRelacionadaPrincipal(new ArrayList<ClasificacionRelacionadaDTO>());
		cla.getClasificacionRelacionadaPrincipal().add(new ClasificacionRelacionadaDTO());
		return cla;
	}

	/**
	 * Obtiene el art&iacute;culo activo en base al c&oacute;digo de barras, si no encuentra uno activo devuelve nulo
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	@Override
	public ArticuloDTO obtenerArticuloCodigoBarrasActivo(Integer codigoCompania, String codigoBarras) throws SICException {
		try{
			Collection<ArticuloDTO> arts = dataGestor.findObjects(asignarRelacionesArticuloCodigoBarrasActivo(codigoCompania, codigoBarras));
			if(!arts.isEmpty()){
				return arts.iterator().next();}
		}catch (Exception e) {
			throw new SICException(e);
		}
		return null;
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	@Override
	public void asignarRelacionRegistroSanitario(ArticuloDTO articuloDTO){
		RelacionArticuloRegistroSanitarioDTO artRegSan = new RelacionArticuloRegistroSanitarioDTO();
		artRegSan.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
		artRegSan.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
		artRegSan.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
		articuloDTO.setRegistroSanitarioCol(new ArrayList<RelacionArticuloRegistroSanitarioDTO>());
		articuloDTO.getRegistroSanitarioCol().add(artRegSan);
	}


	@Override
	public void asignarCamposArticuloDuracionConservacion(ArticuloDuracionConservacionDTO dto){
		if(StringUtils.isNotEmpty(dto.getId().getValorTipoConservacion())
				&& !SICConstantes.VALOR_NOASIGNADO.equals(dto.getId().getValorTipoConservacion())){
			dto.getId().setCodigoTipoConservacion(SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION);
		}else{
			dto.getId().setValorTipoConservacion(SICConstantes.VALOR_NOASIGNADO);
			dto.getId().setCodigoTipoConservacion(SICConstantes.CODIGO_CATALOGO_OMISION);
		}
	}

	/**
	 * Obtiene el c&oacute;digo de barras para enviar al POS
	 * @param tipoCodigo	- Indica si el codigo es interno o de origen del proveedor
	 * @param codigoBarras
	 */
	@Override
	public String calcularCodigoBarrasPOS(String tipoCodigo, String codigoBarras){
		return calcularCodigoBarrasPOS(tipoCodigo, codigoBarras, Boolean.TRUE, Boolean.FALSE);
	}

	/**
	 * Obtiene el c&oacute;digo de barras EAN13 desde un c&oacute;digo interno
	 * @param codigoBarras
	 */
	@Override
	public String calcularEAN13DesdeCodigoInterno(String codigoInterno){
		String codigoEAN = calcularCodigoBarrasPOS(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO, codigoInterno, Boolean.FALSE, Boolean.TRUE);
		return codigoEAN.concat(String.valueOf(Util.calcularDigitoVerificadorEAN(codigoEAN)));
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

//			Collection<RangoSecuenciaCodigoBarrasDTO> rangos = dataGestor.findObjects(filtro);
//			for(RangoSecuenciaCodigoBarrasDTO rango : rangos){
//				Integer prefijo = rango.getPrefijoPOS();
//				if(aumentarPrefijoCuponEspecial && rango.getValorTipoSecuencia().equals(SICArticuloConstantes.getInstancia().TIPSECART_CUPONESPECIAL)){
//					prefijo = Integer.valueOf(SICArticuloCalculo.PREFIJO_CUPON_ESPECIAL);
//				}
//				if(prefijo > 0 && Long.valueOf(codigoBarras) >= rango.getValorMinimo() && Long.valueOf(codigoBarras) <= rango.getValorMaximo()){
//					codigoPOS = String.valueOf(prefijo).concat(codigoPOS);
//					if(calcularCodigoOrigenPOS){
//						if(SICArticuloConstantes.getInstancia().TIPSECART_PESOFIJO.equals(rango.getValorTipoSecuencia())){
//							codigoPOS = StringUtils.rightPad(codigoPOS, SICArticuloConstantes.LONGITUD_CODIGOPOS, "0");
//						}else{
//							codigoPOS = StringUtils.leftPad(codigoPOS, SICArticuloConstantes.LONGITUD_CODIGOPOS, "0");
//						}
//					}else{
//						codigoPOS = StringUtils.rightPad(codigoPOS, SICArticuloConstantes.LONGITUD_CODIGOPOS, "0");
//					}
//					break;
//				}
//			}
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
	 * Construye el c&oacute;digo de barras como si viniera desde el archivo de ventas del POS
	 * @param tipoCodigo
	 * @param codigoBarras
	 * @return
	 */
	public String calcularCodigoBarrasVentaPOS(String tipoCodigo, String codigoBarras){
		/*Boolean calcularCodigoVentaPOS = Boolean.FALSE;
		if(Long.valueOf(codigoBarras)>= 60000 && Long.valueOf(codigoBarras)<=69999){
			calcularCodigoVentaPOS = Boolean.TRUE;
		}*/
		return this.calcularCodigoBarrasPOS(tipoCodigo, codigoBarras, Boolean.TRUE, Boolean.FALSE);
	}

	public ArticuloDTO respaldarDatosArticulo(ArticuloVO vo, Boolean registrarSubProceso){
		ArticuloDTO articuloDTO = new ArticuloDTO();
		if(registrarSubProceso || vo.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULOUNIDADMANEJO)){
			if(vo.getBaseDTO().getTieneUnidadManejoCol()){
				Map<String, Object> relations = null;
				articuloDTO.setArticuloUnidadManejoCol(new ListSet());
				for(ArticuloUnidadManejoDTO aum : vo.getBaseDTO().getArticuloUnidadManejoCol()){
					relations = SICUtil.getInstance().clearRelations(aum);
					ArticuloUnidadManejoDTO aumClone = SerializationUtils.clone(aum);
					articuloDTO.getArticuloUnidadManejoCol().add(aumClone);
					SICUtil.getInstance().restoreRelations(aum, relations, Boolean.FALSE);
					SICUtil.getInstance().restoreRelations(aumClone, relations);
					relations = null;
				}
			}
		}
		return articuloDTO;
	}
	
	public void restablecerArticuloVO(ArticuloVO vo, ArticuloDTO respaldo, Boolean registrarSubProceso, Boolean hayError){
		if(vo.getEsCreacion() && hayError){
			vo.getBaseDTO().getId().setCodigoArticulo(null);
		}
		//restablece secuencial del registro sanitario
		if(registrarSubProceso || vo.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.REGISTROSANITARIO)){
			if(vo.getBaseDTO().getTieneRegistroSanitario()){
				for(RelacionArticuloRegistroSanitarioDTO rel : vo.getBaseDTO().getRegistroSanitarioCol()){
					if(rel.getTieneRegistroSanitario() && rel.getRegistroSanitario().hasDynamicProperty(SICConstantes.EVENTO_INSERTAR)){
						if(hayError){
							rel.getRegistroSanitario().getId().setCodigoRegistroSanitario(null);
							rel.getId().setCodigoRegistroSanitario(null);
						}
						rel.getRegistroSanitario().removeDynamicProperty(SICConstantes.EVENTO_INSERTAR);
					}
				}
			}
		}
		if(registrarSubProceso || vo.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.LEYENDA)){
			//restablece secuencial del registro sanitario
			if(vo.getBaseDTO().getTieneArticuloLeyenda()){
				for(ArticuloLeyendaDTO ley : vo.getBaseDTO().getArticuloLeyendaCol()){
					if(ley.hasDynamicProperty(SICConstantes.EVENTO_INSERTAR)){
						if(hayError)
							ley.getId().setSecuencial(null);
						ley.removeDynamicProperty(SICConstantes.EVENTO_INSERTAR);
					}
				}
			}
		}
		if(registrarSubProceso || vo.getSubProcesoGuardadoArticulo().contains(EnumSubProcesoGuardadoArticulo.ARTICULODEFINICIONARCHIVO)){
			//restablece secuencial del registro sanitario
			if(vo.getBaseDTO().getTieneArticuloDefinicionArchivo()){
				for(ArticuloDefinicionArchivoDTO ada : vo.getBaseDTO().getArticuloDefinicionArchivoCol()){
					if(ada.hasDynamicProperty(SICConstantes.EVENTO_INSERTAR)){
						if(hayError){
							ada.getId().setCodigoArchivo(null);
							if(ada.getTieneArticuloArchivo()){
								ada.getArticuloArchivo().getId().setCodigoArchivo(null);
							}
						}
						ada.removeDynamicProperty(SICConstantes.EVENTO_INSERTAR);
					}
				}
			}
		}
		
		if(respaldo != null){
			if(respaldo.getTieneArticuloProveedor()){
				vo.getBaseDTO().setArticuloProveedorCol(respaldo.getArticuloProveedorCol());
				if(vo.getBaseDTO().getDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO) != null){
					vo.setArticuloProveedorDTO(respaldo.getArticuloProveedorCol().iterator().next());
				}
			}
			if(respaldo.getTieneUnidadManejoCol()){
				vo.getBaseDTO().setArticuloUnidadManejoCol(respaldo.getArticuloUnidadManejoCol());
			}
		}
	}
	
	public void registrarArticuloPendienteIntegracion(ArticuloVO vo)throws SICException{
		try{
			if(!SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO.equals(vo.getBaseDTO().getCodigoEstado())){
				ArticuloPendienteIntegracionDTO api = new ArticuloPendienteIntegracionDTO();
				api.getId().setCodigoCompania(vo.getBaseDTO().getId().getCodigoCompania());
				api.setValorTipoProceso(TipoCatalogoArticulo.PROCESO_INTEGRACION_EDICIONARTICULO);
				api.setCodigoArticulo(vo.getBaseDTO().getId().getCodigoArticulo());
				api.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				api.setUserId(vo.getBaseDTO().getUserId());
				api.setCodigoTipoProceso(TipoCatalogoArticulo.TIPO_PROCESO_INTEGRACION);
				if(vo.hasDynamicProperty("notificarSIC") && (Boolean)vo.getDynamicProperty("notificarSIC")){
					api.setNotificar(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				}else{
					api.setNotificar(SICConstantes.ESTADO_INACTIVO_NUMERICO);
				}
				if(vo.getBaseDTOAnterior() != null){
					if(vo.getBaseDTO().hasDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO)
							&& SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO.equals(vo.getBaseDTOAnterior().getCodigoEstado())
							&& SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO.equals(vo.getBaseDTO().getCodigoEstado())){
						api.setValorTipoProceso(TipoCatalogoArticulo.PROCESO_INTEGRACION_CREACIONARTICULO);
					}else if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(vo.getBaseDTO().getEstadoArticulo())
							&& SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(vo.getBaseDTOAnterior().getEstadoArticulo())){
						api.setValorTipoProceso(TipoCatalogoArticulo.PROCESO_INTEGRACION_ACTIVACIONARTICULO);
					}else if(vo.getBaseDTOAnterior().getTieneArtBitCodBar() && vo.getBaseDTO().getTieneArtBitCodBar() && !vo.getBaseDTOAnterior().getCodigoBarrasActivo().getId().getCodigoBarras().equals(vo.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras())){
						api.setValorTipoProceso(TipoCatalogoArticulo.PROCESO_INTEGRACION_MODIFICACIONCODIGOBARRAS);
					}
				}else if (vo.getBaseDTO().hasDynamicProperty(ArticuloTransient.PROCESO_CODIFICACIONARTICULO_ARCHIVO)){
						api.setValorTipoProceso(TipoCatalogoArticulo.PROCESO_INTEGRACION_CREACIONMASIVAARTICULOS);
				}

				dataGestor.create(api);
			}
		}catch(Exception e){
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.pendiente.integracion"),e);
		}
	}
	
	/**
	 * Obtiene el c&oacute;digo de barras EAN13 desde un c&oacute;digo interno
	 * @param codigoBarras
	 */
	@Override
	public String obtenerCodigoBarrasDesdeEAN(String codigoBarras){
		return SICArticuloCalculo.getInstancia().obtenerCodigoBarrasParaBusqueda(codigoBarras);
	}
	
	@Override
	public void registrarSecuenciaDisponible(Integer codigoCompania, String codigoArticulo, String userId) throws SICException{
		this.articuloBitacoraCodigoBarrasDAO.registrarSecuenciaDisponible(codigoCompania, codigoArticulo, userId);
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @param articuloBitacoraCodigoBarrasDAO the articuloBitacoraCodigoBarrasDAO to set
	 */
	public void setArticuloBitacoraCodigoBarrasDAO(IArticuloBitacoraCodigoBarrasDAO articuloBitacoraCodigoBarrasDAO) {
		this.articuloBitacoraCodigoBarrasDAO = articuloBitacoraCodigoBarrasDAO;
	}

	/**
	 * @param articuloDAO the articuloDAO to set
	 */
	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}
	
	// permite obtener id para registro de auditoria
	public String obtenerIdLogAuditoriaArticulo(Integer codigoCompania, String codigoArticulo) throws SICException {
		return codigoCompania + AuditLogConstant.SEPARADOR_IDENTIFICADOR + codigoArticulo;
	}

//	@Override
//	public Double calcularPrecioBaseNoAfiliado(Double precioBase, Double porcentajeNoAfiliado) {
//		return SICArticuloCalculo.getInstancia().calcularPrecioBaseNoAfiliado(precioBase, porcentajeNoAfiliado);
//	}
	
	public String obtenerIdLogAuditoriaNotificacionArticulo (Integer codigoCompania, String codigoArticulo) throws SICException{
		String notificacion = "NOT";
		return codigoCompania + AuditLogConstant.SEPARADOR_IDENTIFICADOR + codigoArticulo + AuditLogConstant.SEPARADOR_IDENTIFICADOR + notificacion;
	}
	
	public ArticuloVO crearArticuloEAN(String codigoBarras , Integer codigoCompania){
		//primeramente validamos que el codigo de barras sea valido
		
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setBaseDTO(new ArticuloDTO());
		articuloVO.getBaseDTO().setTransferirDatosSIC(false);
		
		//articulo comercial
		ArticuloComercialDTO articuloComercialDTO = new ArticuloComercialDTO();
		articuloComercialDTO.setValorTipoControlCosto(SICConstantes.VALOR_NOASIGNADO);
		articuloComercialDTO.setCodigoTipoControlCosto(SICConstantes.CODIGO_CATALOGO_OMISION);
		articuloVO.getBaseDTO().setArticuloComercialDTO(articuloComercialDTO);
		
		//articulo medida
		ArticuloMedidaDTO articuloMedidaDTO = new ArticuloMedidaDTO();
		articuloMedidaDTO.setValorTipoMedida(SICArticuloConstantes.getInstancia().TIPOMEDIDA_UNIDAD);
		articuloMedidaDTO.setCodigoTipoMedida(SICArticuloConstantes.getInstancia().CODIGO_CATALOGO_UNIDAD_MEDIDA);
		
		articuloVO.getBaseDTO().setArticuloMedidaDTO(articuloMedidaDTO);
		
		//codigo barras
		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
		articuloBitacoraCodigoBarrasDTO.setCodigoTipoCodigoArticulo(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN);
		articuloBitacoraCodigoBarrasDTO.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articuloBitacoraCodigoBarrasDTO.getId().setCodigoCompania(codigoCompania);
		articuloBitacoraCodigoBarrasDTO.getId().setCodigoBarras(codigoBarras);
		articuloBitacoraCodigoBarrasDTO.setCodigoBarrasPOS(SICConstantes.VALOR_NOASIGNADO);
		articuloBitacoraCodigoBarrasDTO.setPendienteCodigoBarras(false);
		articuloBitacoraCodigoBarrasDTO.getId().setFechaInicialActivo(DateUtils.addMilliseconds(new Date(), 1));
		
		articuloVO.getBaseDTO().setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		articuloVO.getBaseDTO().getArtBitCodBarCol().add(articuloBitacoraCodigoBarrasDTO);
		
		//asignamos el segmento paso creacion(paso 0)
		SegmentoCreacionArticuloDTO segmentoCreacionArticuloDTO = new SegmentoCreacionArticuloDTO();
		segmentoCreacionArticuloDTO.getId().setValorPasoCreacion(SICArticuloConstantes.getInstancia().VALORPASOCEROCODIFICACION);
		articuloVO.getBaseDTO().setSegmentoCreacionArticulos(new ArrayList<SegmentoCreacionArticuloDTO>());
		articuloVO.getBaseDTO().getSegmentoCreacionArticulos().add(segmentoCreacionArticuloDTO);
		
		return articuloVO;
	}
	
	public void asignarValoresArticuloEAN(ArticuloVO articuloVO , Integer codigoCompania , String idUsuario){
		//asignamos usuario y fecha de creacion
		articuloVO.getBaseDTO().setUsuarioCreacion(idUsuario);
		articuloVO.getBaseDTO().setUserId(idUsuario);
		articuloVO.getBaseDTO().setFechaCreacion(new Timestamp(System.currentTimeMillis()));
		//asignamos tipo de articulo comercializable
		articuloVO.getBaseDTO().setCodigoTipoArticulo(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_PRODUCTO);
		articuloVO.getBaseDTO().getCodigoBarrasActivo().setIdUsuarioRegistro(idUsuario);
		articuloVO.getBaseDTO().getCodigoBarrasActivo().setFechaRegistro(new Timestamp(System.currentTimeMillis()));
		
		
		//registramos la descripcion que se encontrara en un parametro
		ParametroDTO parametroDescripcionDTO = new ParametroDTO();
		parametroDescripcionDTO.getId().setCodigoCompania(codigoCompania);
		parametroDescripcionDTO.getId().setCodigoParametro(SICArticuloConstantes.getInstancia().VALOR_PARAMETRO_DESCRIPCION_ARTICULO_NOVALIDO);
		ParametroDTO parametroDescripcionFound = (ParametroDTO) dataGestor.findUnique(parametroDescripcionDTO);
		articuloVO.getBaseDTO().setDescripcionArticulo(parametroDescripcionFound.getValorParametro());
		articuloVO.getBaseDTO().getId().setCodigoCompania(codigoCompania);
		
		//consultamos el proveedor parametrizado
		ParametroDTO parametroProveedorDTO = new ParametroDTO();
		parametroProveedorDTO.getId().setCodigoCompania(codigoCompania);
		parametroProveedorDTO.getId().setCodigoParametro(SICArticuloConstantes.getInstancia().VALOR_PARAMETRO_PROVEEDOR_ARTICULO_NOVALIDO);
		ParametroDTO parametroProveedorFound = (ParametroDTO) dataGestor.findUnique(parametroProveedorDTO);
		ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
		articuloProveedorDTO.getId().setCodigoCompania(codigoCompania);
		articuloProveedorDTO.getId().setCodigoProveedor(parametroProveedorFound.getValorParametro());
		articuloVO.getBaseDTO().setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
		articuloVO.getBaseDTO().getArticuloProveedorCol().add(articuloProveedorDTO);
	}
}
