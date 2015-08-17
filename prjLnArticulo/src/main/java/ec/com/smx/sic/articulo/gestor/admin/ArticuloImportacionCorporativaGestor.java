package ec.com.smx.sic.articulo.gestor.admin;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.framework.common.validator.Validator;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.IArticuloOrigenProveedor;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloImportacionCorporativaGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.IArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloComercial.IArticuloComercialGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloImportacion.IArticuloProveedorImportacionGestor;
import ec.com.smx.sic.cliente.gestor.articulo.auditoria.almacenamiento.IAlmacenamientoAuditoriaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.IEstructuraComercialGestor;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.accion.IAccionArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor;
import ec.com.smx.sic.cliente.gestor.proveedor.marcaProveedor.calculo.ICalculoDatosMarcaProveedorGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMaterialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloImportadoVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.ILineaComercialDAO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.dao.IArticuloNuevoImportadoDAO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.BodegasEnCentroDistribucionRestriction;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.resources.ordenCompra.SICOrdenCompraMessages;

public class ArticuloImportacionCorporativaGestor implements IArticuloImportacionCorporativaGestor {
	
	private DataGestor dataGestor;
	
	private IArticuloGestor articuloGestor;
	
	private IArticuloUnidadManejoGestor articuloUnidadManejoGestor;
	
	private IArticuloComercialGestor articuloComercialGestor;
	
	private IArticuloAlcanceGestor articuloAlcanceGestor;
	
	private ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor;
	
	private IAccionArticuloProveedorGestor accionArticuloProveedorGestor;
	
	private ICalculoDatosMarcaProveedorGestor calculoDatosMarcaProveedorGestor;
	
	private IEstructuraComercialGestor estructuraComercialGestor;
	
	private IAlmacenamientoAuditoriaArticuloGestor almacenamientoAuditoriaArticuloGestor;
	
	private IArticuloProveedorImportacionGestor articuloProveedorImportacionGestor;
	
	private IArticuloNuevoImportadoDAO articuloNuevoImportadoDAO;
	
	private ILineaComercialDAO lineaComercialDAO;
	
	private IArticuloDAO articuloDAO; 
	
	@Override
	public ArticuloDTO registrarArticuloImportado(ArticuloImportadoVO articuloImportadoVO, boolean generarNovedadImportacion, boolean realizarIntegracion) throws SICException{
		ArticuloDTO articuloDTO = null;
		ArticuloImportadoVO articuloImportadoVOClon = null;
		ClasificacionDTO clasificacionDTO = null;
		Validator validator = null;
		ArticuloVO articuloVO = null;
				
		try{

			//valida datos obligatorios
			if(articuloImportadoVO.getCodigoCompania() == null){
				throw new SICException("El c\u00F3digo de la compan\u00EDa se encuentra vac\u00EDo");
			}
			if(articuloImportadoVO.getDescripcionArticulo() == null){
				throw new SICException("La descripci\u00F3n se encuentra vac\u00EDa");
			}
			if(articuloImportadoVO.getCodigoBarras() == null && articuloImportadoVO.getCodigoReferenciaExterna() == null){
				throw new SICException("Debe existir un c\u00F3digo de barras o una referencia externa");
			}
			if(articuloImportadoVO.getCodigoProveedor() == null){
				throw new SICException("El c\u00F3digo del proveedor se encuentra vac\u00EDo");
			}
			if(articuloImportadoVO.getCostoBruto() == null){
				throw new SICException("El costo bruto se encuentra vac\u00EDo");
			}
			if(articuloImportadoVO.getUserId() == null){
				throw new SICException("El id del usuario registro se encuentra vac\u00EDo");
			}
			
			//clona el articuloImportadoVO
			articuloImportadoVOClon = SerializationUtils.clone(articuloImportadoVO);
			
			if(generarNovedadImportacion){
				//busca el articulo y genera la novedad correspondiente en caso de tenerla
				articuloImportadoVOClon.setArticuloProveedorNovedadDTO(this.calculoBusquedaArticuloGestor.buscarArticuloProveedorNovedadImportacion(articuloImportadoVOClon));
			}
			
			//existente
			if(articuloImportadoVOClon.getArticuloProveedorNovedadDTO() != null && articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getArticuloProveedor() != null && !articuloImportadoVOClon.hasDynamicProperty("esNuevo")){
				ArticuloProveedorDTO articuloProveedorDTONuevo = null;
				ArticuloProveedorDTO articuloProveedorDTOActual = null;
				Collection<ArticuloUnidadManejoProveedorDTO> articuloUnidadManejoProveedorDTOCol = null;
				boolean creoArticuloProveedor = false;

				articuloDTO = articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getArticuloProveedor().getArticulo();
				articuloProveedorDTOActual = articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getArticuloProveedor();
				
				articuloVO = new ArticuloVO(SerializationUtils.clone(articuloDTO));
				articuloVO.setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				articuloVO.setUserId(articuloImportadoVO.getUserId());
				articuloVO.getBaseDTO().setUserId(articuloImportadoVO.getUserId());
				articuloVO.setAccessItemId(articuloImportadoVOClon.getAccessItemId());
				articuloVO.setSystemId(articuloImportadoVOClon.getSystemId());
				articuloVO.getBaseDTO().setCodigoSistemaOrigen(articuloImportadoVOClon.getSystemId());
				articuloVO.setBaseDTOAnterior(new ArticuloDTO());
				
				//Actualiza el codigo del cliente siempre y cuando no sea asociado a filial
				if(articuloDTO.getCodigoClienteImportacion() != null){
					if(BooleanUtils.isFalse(this.lineaComercialDAO.validarClienImpLinComEstFilial(articuloDTO.getCodigoClienteImportacion(), articuloImportadoVOClon.getCodigoCompania()))){
						this.articuloDAO.actualizarClienteImportacionArticulo(articuloImportadoVOClon.getCodigoCompania(), articuloImportadoVO.getUserId(), articuloDTO.getCodigoClienteImportacion(), articuloDTO.getId().getCodigoArticulo());
					}
				}
				
				//Registra marca comercial del articulo si no la tiene
				if (articuloImportadoVOClon.getCodigoMarcaComercial() == null) {//TODO
					VistaProveedorDTO vistaProveedorDTO = new VistaProveedorDTO();
					vistaProveedorDTO.getId().setCodigoCompania(articuloProveedorDTOActual.getId().getCodigoCompania());
					vistaProveedorDTO.getId().setCodigoProveedor(articuloProveedorDTOActual.getId().getCodigoProveedor());
					vistaProveedorDTO = this.dataGestor.findUnique(vistaProveedorDTO);
					if(vistaProveedorDTO == null){
						throw new SICException("No se pudo obtener el proveedor");
					}
					final String origenProveedor =  vistaProveedorDTO.getOrigenProveedor();
					
					ArticuloComercialDTO articuloComercialDTO = new ArticuloComercialDTO();
					
					
					if (SearchDTO.isLoaded(articuloProveedorDTOActual.getArticulo().getArticuloComercialDTO()) && 
							articuloProveedorDTOActual.getArticulo().getArticuloComercialDTO() != null) {
						articuloComercialDTO = SerializationUtils.clone(articuloProveedorDTOActual.getArticulo().getArticuloComercialDTO());
					} else {
						articuloComercialDTO.getId().setCodigoArticulo(articuloProveedorDTOActual.getId().getCodigoArticulo());
						articuloComercialDTO.getId().setCodigoCompania(articuloProveedorDTOActual.getId().getCodigoCompania());
						articuloComercialDTO.setCodigoPaisOrigen(articuloImportadoVOClon.getCodigoPaisOrigen());
						articuloComercialDTO.setCodigoTipoControlCosto(SICConstantes.TIPO_CONTROL_COSTO);
						articuloComercialDTO.setValorTipoControlCosto(SICArticuloConstantes.TIPCONCOS_PIEPIE);
						if (SearchDTO.isLoaded(articuloProveedorDTOActual.getArticulo().getClasificacionDTO()) &&
								articuloProveedorDTOActual.getArticulo().getClasificacionDTO() != null) {
							articuloComercialDTO.setPorcentajeNoAfiliado(articuloProveedorDTOActual.getArticulo().getClasificacionDTO().getPorcentajeNoAfiliado());
						}
					}
					if(articuloComercialDTO.getCodigoMarcaComercial() == null){
						Collection<ProveedorMarcaDTO> proveedorMarcaDTOs = calculoDatosMarcaProveedorGestor.obtenerTotalDatosProveedorMarca(articuloProveedorDTOActual.getId().getCodigoCompania()
								, articuloProveedorDTOActual.getId().getCodigoProveedor());
						//Asigna marca comercial
						if (CollectionUtils.isEmpty(proveedorMarcaDTOs)) {
							articuloComercialDTO.setCodigoMarcaComercial(SICArticuloConstantes.CODIGO_MARCA_PENDIENTE);						
						} else {
							articuloComercialDTO.setCodigoMarcaComercial(proveedorMarcaDTOs.iterator().next().getMarcaArticuloDTO().getId().getSecuencialMarca());
						}
						articuloComercialDTO.setUserId(articuloImportadoVOClon.getUserId());
						articuloComercialGestor.registrarArticuloComercial(articuloComercialDTO, false, new IArticuloOrigenProveedor() {
							@Override
							public String getOrigenArticulo() throws SICException {
								return origenProveedor;
							}
						});
					}
					
				}
				
				if(StringUtils.isNotEmpty(articuloImportadoVOClon.getMaterialArticulo())){
					//articulo material
					ArticuloMaterialDTO articuloMaterialDTO = new ArticuloMaterialDTO();
					articuloMaterialDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloMaterialDTO.getId().setCodigoArticulo(articuloProveedorDTOActual.getId().getCodigoArticulo());
					articuloMaterialDTO.getId().setCodigoTipoMaterial(SICArticuloConstantes.CODIGOTIPOMATERIAL);
					articuloMaterialDTO.getId().setValorTipoMaterial(SICArticuloConstantes.VALOR_TIPOMATERIAL_OTRO);
					
					ArticuloMaterialDTO articuloMaterialActual = dataGestor.findUnique(articuloMaterialDTO);
					Boolean esCreacion = articuloMaterialActual == null;
					if(esCreacion){
						articuloMaterialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						articuloMaterialDTO.setEsPrincipal(Boolean.FALSE);
						articuloMaterialDTO.setObservacion(articuloImportadoVOClon.getMaterialArticulo());
						articuloMaterialDTO.setUserId(articuloImportadoVOClon.getUserId());
						articuloVO.getBaseDTO().setArticuloMaterialDTOs(new ArrayList<ArticuloMaterialDTO>());
						articuloVO.getBaseDTO().getArticuloMaterialDTOs().add(articuloMaterialDTO);
					}else{
						//para guardar auditoria del material del articulo
						articuloVO.getBaseDTOAnterior().setArticuloMaterialDTOs(new ArrayList<ArticuloMaterialDTO>());
						articuloVO.getBaseDTOAnterior().getArticuloMaterialDTOs().add(articuloMaterialActual);
						//para guardar la auditoria
						ArticuloMaterialDTO articuloMaterialAuditoria = SerializationUtils.clone(articuloMaterialActual);
						articuloMaterialAuditoria.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						articuloMaterialAuditoria.setObservacion(articuloImportadoVOClon.getMaterialArticulo());
						articuloMaterialAuditoria.setUserId(articuloImportadoVOClon.getUserId());
						articuloVO.getBaseDTO().setArticuloMaterialDTOs(new ArrayList<ArticuloMaterialDTO>());
						articuloVO.getBaseDTO().getArticuloMaterialDTOs().add(articuloMaterialAuditoria);
						articuloImportadoVOClon.addDynamicProperty("definicionID", SICMessages.getInstancia().getString("ec.com.smx.sic.auditoria.articulo.material.descripcion"));
						articuloVO.addDynamicProperty("codigoTipoAuditoria", SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.auditoria.codigo.material"));
					}
					this.articuloGestor.registrarArticuloMaterial(articuloVO, esCreacion);
					if(articuloImportadoVOClon.getDynamicProperty("definicionID")!=null){
						articuloDTO.addDynamicProperty("auditoriaMaterial", this.almacenamientoAuditoriaArticuloGestor.registrarLogAuditoriaArticulo(articuloVO, articuloImportadoVOClon.getDynamicProperty("definicionID", String.class), articuloVO.getSystemId(), articuloVO.getAccessItemId()));
					
					}
				}
				
				//crea el articulo proveedor en caso de tener un proveedor diferente
				if(!articuloProveedorDTOActual.getId().getCodigoProveedor().equals(articuloImportadoVOClon.getCodigoProveedor())){
					//verifica que no exista el articulo proveedor
					articuloProveedorDTONuevo = new ArticuloProveedorDTO();
					articuloProveedorDTONuevo.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloProveedorDTONuevo.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					articuloProveedorDTONuevo.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
					articuloProveedorDTONuevo.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloProveedorDTONuevo.setArticuloImportacion(new ArticuloImportacionDTO());
					articuloProveedorDTONuevo.setArticulo(new ArticuloDTO());
					articuloProveedorDTONuevo.setVistaProveedor(new VistaProveedorDTO());
					articuloProveedorDTONuevo.getArticulo().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloProveedorDTONuevo.getArticulo().setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
					articuloProveedorDTONuevo.getArticulo().getArtBitCodBarCol().add(new ArticuloBitacoraCodigoBarrasDTO());
					articuloProveedorDTONuevo.getArticulo().getArtBitCodBarCol().iterator().next().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>(
							"estadoArticuloBitacora", 
							ComparatorTypeEnum.EQUAL_COMPARATOR, 
							SICConstantes.ESTADO_ACTIVO_NUMERICO
					));
					articuloProveedorDTONuevo = this.dataGestor.findUnique(articuloProveedorDTONuevo);
					if(articuloProveedorDTONuevo == null){
						//articulo proveedor
						articuloProveedorDTONuevo = new ArticuloProveedorDTO();
						articuloProveedorDTONuevo.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
						articuloProveedorDTONuevo.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
						articuloProveedorDTONuevo.setCodigoReferenciaInterna(articuloProveedorDTOActual.getCodigoReferenciaInterna());
						articuloProveedorDTONuevo.setCodigoReferenciaProveedor(articuloProveedorDTOActual.getCodigoReferenciaProveedor());
						articuloProveedorDTONuevo.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						articuloProveedorDTONuevo.setCostoBruto(articuloImportadoVOClon.getCostoBruto().doubleValue());
						articuloProveedorDTONuevo.addDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA, true);
						
						//articulo importacion
						ArticuloImportacionDTO articuloImportacionDTO = new ArticuloImportacionDTO();
						articuloImportacionDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
						articuloImportacionDTO.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
						articuloImportacionDTO.setCodigoMonedaOrigen(articuloImportadoVOClon.getCodigoMoneda());
						articuloImportacionDTO.setCostoMonedaOrigen(articuloImportadoVOClon.getCostoBruto());
						articuloImportacionDTO.setDescripcionArticulo(articuloImportadoVOClon.getDescripcionArticulo());
						articuloProveedorDTONuevo.setArticuloImportacion(articuloImportacionDTO);
						
						articuloVO.getBaseDTO().setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
						articuloVO.getBaseDTO().getArticuloProveedorCol().add(articuloProveedorDTONuevo);
						this.articuloGestor.registrarArticuloProveedor(articuloVO, Boolean.TRUE);
						creoArticuloProveedor = true;

						articuloDTO.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
						articuloDTO.getArticuloProveedorCol().add(articuloProveedorDTONuevo);
						articuloProveedorDTONuevo.setVistaProveedor(articuloImportadoVO.getVistaProveedorDTO());
						
						//obtiene las unidades de manejo del articulo proveedor actual
						ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO = new ArticuloUnidadManejoProveedorDTO();
						articuloUnidadManejoProveedorDTO.getId().setCodigoCompania(articuloProveedorDTOActual.getId().getCodigoCompania());
						articuloUnidadManejoProveedorDTO.getId().setCodigoProveedor(articuloProveedorDTOActual.getId().getCodigoProveedor());
						articuloUnidadManejoProveedorDTO.setCodigoArticulo(articuloProveedorDTOActual.getId().getCodigoArticulo());
						articuloUnidadManejoProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						
						articuloUnidadManejoProveedorDTO.setArticuloUnidadManejoDTO(new ArticuloUnidadManejoDTO());
						articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
						articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
						articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().addCriteriaSearchParameter("codigoUnidadManejoContenida", ComparatorTypeEnum.IS_NULL);
						articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().addCriteriaSearchParameter("valorTipoUnidadEmpaque", ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, 
								SICArticuloConstantes.getInstancia().TIPOEMPAQUE_MAYORISTA);
						
						ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTO = new ArticuloUnidadManejoUsoDTO();
						articuloUnidadManejoUsoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, 
								SICConstantes.ESTADO_ACTIVO_NUMERICO));
						articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
						articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTO);
						
						articuloUnidadManejoProveedorDTOCol = this.dataGestor.findObjects(articuloUnidadManejoProveedorDTO);
						
						articuloUnidadManejoProveedorDTO = null;
						if(articuloUnidadManejoProveedorDTOCol != null && !articuloUnidadManejoProveedorDTOCol.isEmpty()){
							//replica las unidades de manejo del proveedor
							for(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTOIte : articuloUnidadManejoProveedorDTOCol){
								articuloUnidadManejoProveedorDTOIte.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
								articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
								articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTOIte);
								
								if(articuloVO.getBaseDTO().getArticuloUnidadManejoCol() == null || !SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())){
									articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
								}
								articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO());
								
								//verifica si la unidad de manejo ya existe en el otro proveedor
								if(articuloImportadoVOClon.getValorUnidadManejo() != null && articuloImportadoVOClon.getValorUnidadManejo().intValue() > 0
										&& articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getValorUnidadManejo().intValue() 
										== articuloImportadoVOClon.getValorUnidadManejo().intValue()){
									articuloUnidadManejoProveedorDTO = articuloUnidadManejoProveedorDTOIte;
								}
							}
						}
						
						//verifica si crea una nueva unidad de manejo
						if(articuloImportadoVOClon.getValorUnidadManejo() != null && articuloImportadoVOClon.getValorUnidadManejo().intValue() > 0){
							if(articuloUnidadManejoProveedorDTO == null){
								if(SICArticuloConstantes.NUMEROMAXIMOUNIDADESMANEJO.intValue() == 0 
										|| articuloVO.getBaseDTO().getArticuloUnidadManejoCol() == null
										|| !SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())
										|| (SICArticuloConstantes.NUMEROMAXIMOUNIDADESMANEJO.intValue() > 0 
												&& articuloVO.getBaseDTO().getArticuloUnidadManejoCol() != null 
												&& articuloVO.getBaseDTO().getArticuloUnidadManejoCol().size() < SICArticuloConstantes.NUMEROMAXIMOUNIDADESMANEJO.intValue())){
									//verifica si existe el articulo unidad de manejo//TODO
									ArticuloUnidadManejoDTO articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
									articuloUnidadManejoDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
									articuloUnidadManejoDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
									articuloUnidadManejoDTO.setValorUnidadManejo(articuloImportadoVOClon.getValorUnidadManejo());
//									articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									articuloUnidadManejoDTO.addCriteriaSearchParameter("codigoUnidadManejoContenida", 
											ComparatorTypeEnum.IS_NULL);
									articuloUnidadManejoDTO.addCriteriaSearchParameter("valorTipoUnidadEmpaque", ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, 
											SICArticuloConstantes.TIPOEMPAQUE_MAYORISTA);
									
									articuloUnidadManejoUsoDTO = new ArticuloUnidadManejoUsoDTO();
									articuloUnidadManejoUsoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, 
											SICConstantes.ESTADO_ACTIVO_NUMERICO));
									articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
									articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTO);
									Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoDTOs = this.dataGestor.findObjects(articuloUnidadManejoDTO);
									if(CollectionUtils.isNotEmpty(articuloUnidadManejoDTOs)){
										articuloUnidadManejoDTO = articuloUnidadManejoDTOs.iterator().next();
									}else{
										articuloUnidadManejoDTO = null;
									}
									
									if(articuloUnidadManejoDTO == null){
										//articulo unidad de manejo
										articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
										articuloUnidadManejoDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
										articuloUnidadManejoDTO.setValorUnidadManejo(articuloImportadoVOClon.getValorUnidadManejo());
										articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);

										//obtiene la prioridad
										if(articuloVO.getBaseDTO().getArticuloUnidadManejoCol() != null 
												&& SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloUnidadManejoCol()) 
												&& !articuloVO.getBaseDTO().getArticuloUnidadManejoCol().isEmpty()){
											for(ArticuloUnidadManejoDTO artUniManDTOIte : articuloVO.getBaseDTO().getArticuloUnidadManejoCol()){
												if(articuloUnidadManejoDTO.getPrioridad() == null && artUniManDTOIte.getPrioridad() != null 
														&& artUniManDTOIte.getPrioridad().compareTo(SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO) != 0){
													articuloUnidadManejoDTO.setPrioridad(artUniManDTOIte.getPrioridad());
												}else if(articuloUnidadManejoDTO.getPrioridad() != null && artUniManDTOIte.getPrioridad() != null
														&& artUniManDTOIte.getPrioridad().compareTo(SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO) != 0
														&& artUniManDTOIte.getPrioridad().intValue() > articuloUnidadManejoDTO.getPrioridad().intValue()){
													articuloUnidadManejoDTO.setPrioridad(artUniManDTOIte.getPrioridad());
												}
											}
											articuloUnidadManejoDTO.setPrioridad(articuloUnidadManejoDTO.getPrioridad() + 1);
										}else{
											articuloUnidadManejoDTO.setPrioridad(1);
										}
										
										articuloUnidadManejoDTO.setCodigoTipoUnidadEmpaque(SICArticuloConstantes.CODIGOTIPOEMPAQUE);
										if(articuloImportadoVOClon.getCodigoCatalogoUnidadManejo() != null){
											articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(articuloImportadoVOClon.getCodigoCatalogoUnidadManejo());
										}else{
											if(articuloImportadoVOClon.getValorUnidadManejo().intValue() == 1){
												articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(SICArticuloConstantes.VALOREMPAQUEUNIDAD);
											}else{
												articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(SICArticuloConstantes.VALOREMPAQUECAJA);
											}
										}
										
										//articulo unidad de manejo uso compra
										ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTOCompra = new ArticuloUnidadManejoUsoDTO();
										articuloUnidadManejoUsoDTOCompra.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
										articuloUnidadManejoUsoDTOCompra.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANCOMPRA);
										articuloUnidadManejoUsoDTOCompra.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
										articuloUnidadManejoUsoDTOCompra.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
										articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTOCompra);
										
										//articulo unidad de manejo uso despacho
										ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTODespacho = new ArticuloUnidadManejoUsoDTO();
										articuloUnidadManejoUsoDTODespacho.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
										articuloUnidadManejoUsoDTODespacho.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANDESPACHO);
										articuloUnidadManejoUsoDTODespacho.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
										articuloUnidadManejoUsoDTODespacho.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTODespacho);
										
										//articulo unidad de manejo proveedor
										articuloUnidadManejoProveedorDTO = new ArticuloUnidadManejoProveedorDTO();
										articuloUnidadManejoProveedorDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
										articuloUnidadManejoProveedorDTO.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
										articuloUnidadManejoProveedorDTO.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
										articuloUnidadManejoProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										articuloUnidadManejoProveedorDTO.setArticuloUnidadManejoDTO(articuloUnidadManejoDTO);
										articuloUnidadManejoDTO.setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
										articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTO);
										
										if(articuloVO.getBaseDTO().getArticuloUnidadManejoCol() == null 
												|| !SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())){
											articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
										}
										articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoDTO);
										
										articuloProveedorDTONuevo.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
										articuloProveedorDTONuevo.getUnidadesManejo().add(articuloUnidadManejoProveedorDTO);
										
										//asigna la nueva unidad de manejo al resto de proveedores
										ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
										articuloProveedorDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
										articuloProveedorDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
										articuloProveedorDTO.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										articuloProveedorDTO.addCriteriaSearchParameter("id.codigoProveedor", ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, 
												articuloProveedorDTONuevo.getId().getCodigoProveedor());
										articuloProveedorDTO.setVistaProveedor(new VistaProveedorDTO());
										articuloProveedorDTO.setArticulo(new ArticuloDTO());
										articuloProveedorDTO.getArticulo().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										articuloProveedorDTO.getArticulo().setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
										articuloProveedorDTO.getArticulo().getArtBitCodBarCol().add(new ArticuloBitacoraCodigoBarrasDTO());
										articuloProveedorDTO.getArticulo().getArtBitCodBarCol().iterator().next().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>(
												"estadoArticuloBitacora", 
												ComparatorTypeEnum.EQUAL_COMPARATOR, 
												SICConstantes.ESTADO_ACTIVO_NUMERICO
										));
										
										Collection<ArticuloProveedorDTO> articuloProveedorDTOCol = this.dataGestor.findObjects(articuloProveedorDTO);
										if(articuloProveedorDTOCol != null && !articuloProveedorDTOCol.isEmpty()){
											for(ArticuloProveedorDTO articuloProveedorDTOIte : articuloProveedorDTOCol){
												ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTOIte = new ArticuloUnidadManejoProveedorDTO();
												articuloUnidadManejoProveedorDTOIte.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
												articuloUnidadManejoProveedorDTOIte.getId().setCodigoProveedor(articuloProveedorDTOIte.getId().getCodigoProveedor());
												articuloUnidadManejoProveedorDTOIte.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
												articuloUnidadManejoProveedorDTOIte.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
												articuloUnidadManejoProveedorDTOIte.setArticuloUnidadManejoDTO(articuloUnidadManejoDTO);
												articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTOIte);
												
												articuloProveedorDTOIte.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
												articuloProveedorDTOIte.getUnidadesManejo().add(articuloUnidadManejoProveedorDTOIte);
											}
											articuloVO.getBaseDTO().getArticuloProveedorCol().addAll(articuloProveedorDTOCol);
										}
										
									}else{
										
										if(StringUtils.equals(articuloUnidadManejoDTO.getEstadoUnidadManejo(), SICConstantes.ESTADO_INACTIVO_NUMERICO)){
											if(articuloImportadoVOClon.getPrioridad() != null && SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO.compareTo(articuloImportadoVOClon.getPrioridad()) == 0){
												articuloUnidadManejoDTO.setPrioridad(articuloImportadoVOClon.getPrioridad());
											}else{
												Integer prioridadDisponible = this.articuloUnidadManejoGestor.obtenerPrioridadDisponible(articuloImportadoVOClon.getCodigoCompania(), articuloUnidadManejoDTO.getId().getCodigoArticulo());
												articuloUnidadManejoDTO.setPrioridad(prioridadDisponible);
											}
										}
										articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										
										ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTOCompra = null;
										ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTODespacho = null;

										//verifica que tenga la unidad de manejo compra
										if(articuloUnidadManejoDTO.getTieneUnidadesManejoUso()){
											articuloUnidadManejoUsoDTOCompra = (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(
													articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol(), 
													PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), 
															PredicateUtils.equalPredicate(SICArticuloConstantes.getInstancia().VALORUSOUNIMANCOMPRA)));
										}
										
										if(articuloUnidadManejoUsoDTOCompra == null){
											articuloUnidadManejoUsoDTOCompra = new ArticuloUnidadManejoUsoDTO();
											articuloUnidadManejoUsoDTOCompra.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
											articuloUnidadManejoUsoDTOCompra.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
											articuloUnidadManejoUsoDTOCompra.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANCOMPRA);
											articuloUnidadManejoUsoDTOCompra.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
											articuloUnidadManejoUsoDTOCompra.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
											if(articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol() == null){
												articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
											}
											articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTOCompra);
										}
										
										//verifica que tenga la unidad de manejo despacho
										if(articuloUnidadManejoDTO.getTieneUnidadesManejoUso()){
											articuloUnidadManejoUsoDTODespacho = (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(
													articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol(), 
													PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), 
															PredicateUtils.equalPredicate(SICArticuloConstantes.VALORUSOUNIMANDESPACHO)));
										}
										
										if(articuloUnidadManejoUsoDTODespacho == null){
											articuloUnidadManejoUsoDTODespacho = new ArticuloUnidadManejoUsoDTO();
											articuloUnidadManejoUsoDTODespacho.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
											articuloUnidadManejoUsoDTODespacho.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
											articuloUnidadManejoUsoDTODespacho.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANDESPACHO);
											articuloUnidadManejoUsoDTODespacho.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
											articuloUnidadManejoUsoDTODespacho.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);

											if(articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol() == null){
												articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
											}
											articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTODespacho);
										}
										
										//articulo unidad de manejo proveedor
										articuloUnidadManejoProveedorDTO = new ArticuloUnidadManejoProveedorDTO();
										articuloUnidadManejoProveedorDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
										articuloUnidadManejoProveedorDTO.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
										articuloUnidadManejoProveedorDTO.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
										articuloUnidadManejoProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										articuloUnidadManejoProveedorDTO.setArticuloUnidadManejoDTO(articuloUnidadManejoDTO);
										articuloUnidadManejoDTO.setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
										articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTO);
										
										if(articuloVO.getBaseDTO().getArticuloUnidadManejoCol() == null 
												|| !SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())){
											articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
										}
										articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoDTO);
										
										articuloProveedorDTONuevo.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
										articuloProveedorDTONuevo.getUnidadesManejo().add(articuloUnidadManejoProveedorDTO);
									}
								}else{
									throw new SICException("El art\u00edculo ".concat(articuloImportadoVO.getDescripcionArticulo())
											.concat(", tiene el n\u00famero m\u00e1ximo de unidades de manejo"));
								}
								
							}else{
								//verifica que tenga la unidad de manejo compra
								ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTOCompra = (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(
										articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol(), 
										PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), 
												PredicateUtils.equalPredicate(SICArticuloConstantes.VALORUSOUNIMANCOMPRA)));
								
								if(articuloUnidadManejoUsoDTOCompra == null){
									articuloUnidadManejoUsoDTOCompra = new ArticuloUnidadManejoUsoDTO();
									articuloUnidadManejoUsoDTOCompra.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
									articuloUnidadManejoUsoDTOCompra.getId().setCodigoUnidadManejo(articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo());
									articuloUnidadManejoUsoDTOCompra.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANCOMPRA);
									articuloUnidadManejoUsoDTOCompra.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
									articuloUnidadManejoUsoDTOCompra.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
									articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTOCompra);
								}
								
								//verifica que tenga la unidad de manejo despacho
								ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTODespacho = (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(
										articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol(), 
										PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), 
												PredicateUtils.equalPredicate(SICArticuloConstantes.VALORUSOUNIMANCOMPRA)));
								if(articuloUnidadManejoUsoDTODespacho == null){
									articuloUnidadManejoUsoDTODespacho = new ArticuloUnidadManejoUsoDTO();
									articuloUnidadManejoUsoDTODespacho.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
									articuloUnidadManejoUsoDTODespacho.getId().setCodigoUnidadManejo(articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo());
									articuloUnidadManejoUsoDTODespacho.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANDESPACHO);
									articuloUnidadManejoUsoDTODespacho.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
									articuloUnidadManejoUsoDTODespacho.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTODespacho);
								}
								
								articuloProveedorDTONuevo.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
								articuloProveedorDTONuevo.getUnidadesManejo().add(articuloUnidadManejoProveedorDTO);
							}
						}
						
						reasignarPrioridadesUnidadManejo(articuloVO);
						
						//registra las unidades de manejo
						this.articuloUnidadManejoGestor.registrarArticuloUnidadManejo(articuloVO);
						
						//llama a la integracion
						if(realizarIntegracion && (articuloImportadoVOClon.getPrioridad() == null ||(articuloImportadoVOClon.getPrioridad() != null && articuloImportadoVOClon.getPrioridad().intValue() != SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO))){
							articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().setUserId(articuloImportadoVO.getUserId());
							if (StringUtils.isNotBlank(articuloVO.getBaseDTO().getCodigoEstado()) && articuloVO.getBaseDTO().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO)) {
								articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().addDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA, ArticuloTransient.ADMINISTRACIONCOMPLETA);
								articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
								articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getUnidadesManejo().add(articuloUnidadManejoProveedorDTO);
								articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().setVistaProveedor(articuloImportadoVO.getVistaProveedorDTO());
								this.accionArticuloProveedorGestor.transferirDatosArticuloProveedorSIC(articuloVO.getBaseDTO().getArticuloProveedorCol(), Boolean.FALSE, null);
							}
						}
						if(articuloImportadoVOClon.getValorUnidadManejo() != null && articuloImportadoVOClon.getValorUnidadManejo().intValue() > 0 
								&& articuloUnidadManejoProveedorDTO != null){
							articuloDTO.setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
							articuloDTO.getArticuloUnidadManejoCol().add(articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO());
						}
						
					}else{
						articuloVO.getBaseDTO().setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
						articuloVO.getBaseDTO().getArticuloProveedorCol().add(articuloProveedorDTONuevo);
						
						articuloDTO.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
						articuloDTO.getArticuloProveedorCol().add(articuloProveedorDTONuevo);
						articuloProveedorDTONuevo.setVistaProveedor(articuloImportadoVO.getVistaProveedorDTO());
					}
				}else{
					articuloProveedorDTONuevo = articuloProveedorDTOActual;
					//AUDITORIA ARTICULO PROVEEDOR IMPORTADO
					articuloVO.getBaseDTOAnterior().setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
					articuloVO.getBaseDTOAnterior().getArticuloProveedorCol().add(articuloProveedorDTONuevo);
					
					ArticuloProveedorDTO articuloProveedorAuditado = SerializationUtils.clone(articuloProveedorDTOActual);
					articuloVO.getBaseDTO().setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
					if(!SearchDTO.isLoaded(articuloProveedorAuditado.getArticuloImportacion())){ 
						articuloProveedorAuditado.setArticuloImportacion(new ArticuloImportacionDTO());
						articuloProveedorAuditado.setUserId(articuloImportadoVO.getUserId());
						articuloProveedorAuditado.getArticuloImportacion().setUserId(articuloImportadoVO.getUserId());
						articuloProveedorAuditado.getArticuloImportacion().setCodigoMonedaOrigen(articuloImportadoVO.getCodigoMoneda());
						articuloProveedorAuditado.getArticuloImportacion().setCostoMonedaOrigen(articuloImportadoVO.getCostoBruto());
						articuloProveedorAuditado.getArticuloImportacion().setDescripcionArticulo(articuloImportadoVO.getDescripcionArticulo());
						articuloProveedorImportacionGestor.registrarArticuloImportacion(articuloProveedorAuditado,true);
					}
					else{
						articuloProveedorAuditado.getArticuloImportacion().setDescripcionArticulo(articuloImportadoVOClon.getDescripcionArticulo());
						if(articuloProveedorAuditado.getUserId()==null){
							articuloProveedorAuditado.setUserId(articuloImportadoVO.getUserId());
						}
						if(!(articuloImportadoVOClon.getDescripcionArticulo().equals(articuloProveedorDTOActual.getArticuloImportacion().getDescripcionArticulo()))){
						articuloProveedorImportacionGestor.registrarArticuloImportacion(articuloProveedorAuditado,false);
						articuloImportadoVOClon.addDynamicProperty("definicionID", SICMessages.getInstancia().getString("ec.com.smx.sic.auditoria.articulo.material.descripcion"));
						articuloVO.addDynamicProperty("codigoTipoAuditoria", SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.auditoria.codigo.descripcion"));
						if(articuloImportadoVOClon.getDynamicProperty("definicionID")!=null){
							articuloDTO.addDynamicProperty("auditoriaDescripcion", this.almacenamientoAuditoriaArticuloGestor.registrarLogAuditoriaArticulo(articuloVO, articuloImportadoVOClon.getDynamicProperty("definicionID", String.class), articuloVO.getSystemId(), articuloVO.getAccessItemId()));					
						}
						
						
						}
					}
					articuloVO.getBaseDTO().getArticuloProveedorCol().add(articuloProveedorAuditado);
					articuloDTO.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
					articuloDTO.getArticuloProveedorCol().add(articuloProveedorDTONuevo);
					articuloProveedorDTONuevo.setVistaProveedor(articuloImportadoVO.getVistaProveedorDTO());
				}
				
				if(!creoArticuloProveedor && articuloImportadoVOClon.getValorUnidadManejo() != null && articuloImportadoVOClon.getValorUnidadManejo().intValue() > 0){
					//obtiene las unidades de manejo del articulo proveedor actual
					ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO = new ArticuloUnidadManejoProveedorDTO();
					articuloUnidadManejoProveedorDTO.getId().setCodigoCompania(articuloProveedorDTONuevo.getId().getCodigoCompania());
					articuloUnidadManejoProveedorDTO.getId().setCodigoProveedor(articuloProveedorDTONuevo.getId().getCodigoProveedor());
					articuloUnidadManejoProveedorDTO.setCodigoArticulo(articuloProveedorDTONuevo.getId().getCodigoArticulo());
					articuloUnidadManejoProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					
					articuloUnidadManejoProveedorDTO.setArticuloUnidadManejoDTO(new ArticuloUnidadManejoDTO());
					articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
					articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().addCriteriaSearchParameter("codigoUnidadManejoContenida", 
							ComparatorTypeEnum.IS_NULL);
					articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().addCriteriaSearchParameter("valorTipoUnidadEmpaque", ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, 
							SICArticuloConstantes.TIPOEMPAQUE_MAYORISTA);
					
					ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTO = new ArticuloUnidadManejoUsoDTO();
					articuloUnidadManejoUsoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, 
							SICConstantes.ESTADO_ACTIVO_NUMERICO));
					articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
					articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTO);
					
					articuloUnidadManejoProveedorDTOCol = this.dataGestor.findObjects(articuloUnidadManejoProveedorDTO);
					
					articuloUnidadManejoProveedorDTO = null;
					if(articuloUnidadManejoProveedorDTOCol != null && !articuloUnidadManejoProveedorDTOCol.isEmpty()){
						for(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTOIte : articuloUnidadManejoProveedorDTOCol){
							//verifica si la unidad de manejo ya existe en el otro proveedor
							if(articuloImportadoVOClon.getValorUnidadManejo() != null && articuloImportadoVOClon.getValorUnidadManejo().intValue() > 0
									&& articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getValorUnidadManejo().intValue() 
									== articuloImportadoVOClon.getValorUnidadManejo().intValue()){
								articuloUnidadManejoProveedorDTO = articuloUnidadManejoProveedorDTOIte;
								break;
							}
						}
					}
					
					if(articuloUnidadManejoProveedorDTO == null){
						if(SICArticuloConstantes.NUMEROMAXIMOUNIDADESMANEJO.intValue() == 0 
								|| articuloUnidadManejoProveedorDTOCol == null 
								|| (SICArticuloConstantes.NUMEROMAXIMOUNIDADESMANEJO.intValue() > 0 && articuloUnidadManejoProveedorDTOCol != null
										&& articuloUnidadManejoProveedorDTOCol.size() < SICArticuloConstantes.NUMEROMAXIMOUNIDADESMANEJO.intValue())){
							//verifica si existe el articulo unidad de manejo//TODO
							ArticuloUnidadManejoDTO articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
							articuloUnidadManejoDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
							articuloUnidadManejoDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
							articuloUnidadManejoDTO.setValorUnidadManejo(articuloImportadoVOClon.getValorUnidadManejo());
//							articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							articuloUnidadManejoDTO.addCriteriaSearchParameter("codigoUnidadManejoContenida", 
									ComparatorTypeEnum.IS_NULL);
							articuloUnidadManejoDTO.addCriteriaSearchParameter("valorTipoUnidadEmpaque", ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, 
									SICArticuloConstantes.getInstancia().TIPOEMPAQUE_MAYORISTA);
							
							articuloUnidadManejoUsoDTO = new ArticuloUnidadManejoUsoDTO();
							articuloUnidadManejoUsoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, 
									SICConstantes.ESTADO_ACTIVO_NUMERICO));
							articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
							articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTO);
							Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoDTOs = this.dataGestor.findObjects(articuloUnidadManejoDTO);
							if(CollectionUtils.isNotEmpty(articuloUnidadManejoDTOs)){
								articuloUnidadManejoDTO = articuloUnidadManejoDTOs.iterator().next();
							}else{
								articuloUnidadManejoDTO = null;
							}
							
							if(articuloUnidadManejoDTO == null){
								//articulo unidad de manejo
								articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
								articuloUnidadManejoDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
								articuloUnidadManejoDTO.setValorUnidadManejo(articuloImportadoVOClon.getValorUnidadManejo());
								articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								if(articuloImportadoVOClon.getPrioridad() == null){
									//obtiene la prioridad
									if(articuloUnidadManejoProveedorDTOCol != null && !articuloUnidadManejoProveedorDTOCol.isEmpty()){
										for(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTOIte : articuloUnidadManejoProveedorDTOCol){
											if(articuloUnidadManejoDTO.getPrioridad() == null && articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO() != null && articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getPrioridad() != null
													&& articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getPrioridad().compareTo(SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO) != 0){
												articuloUnidadManejoDTO.setPrioridad(articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getPrioridad());
											}else if(articuloUnidadManejoDTO.getPrioridad() != null 
													&& articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getPrioridad() != null
													&& articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getPrioridad().compareTo(SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO) != 0
													&& articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getPrioridad().intValue() > articuloUnidadManejoDTO.getPrioridad().intValue()){
												articuloUnidadManejoDTO.setPrioridad(articuloUnidadManejoProveedorDTOIte.getArticuloUnidadManejoDTO().getPrioridad());
											}
										}
										articuloUnidadManejoDTO.setPrioridad(articuloUnidadManejoDTO.getPrioridad() + 1);
									}else{
										articuloUnidadManejoDTO.setPrioridad(1);
									}
								} else {
									articuloUnidadManejoDTO.setPrioridad(articuloImportadoVOClon.getPrioridad());
									articuloUnidadManejoDTO.setEsCambioPrioridad(articuloImportadoVOClon.getEsCambioPrioridad());
								}
								
								articuloUnidadManejoDTO.setCodigoTipoUnidadEmpaque(SICArticuloConstantes.CODIGOTIPOEMPAQUE);
								if(articuloImportadoVOClon.getCodigoCatalogoUnidadManejo() != null){
									articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(articuloImportadoVOClon.getCodigoCatalogoUnidadManejo());
								}else{
									if(articuloImportadoVOClon.getValorUnidadManejo().intValue() == 1){
										articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(SICArticuloConstantes.VALOREMPAQUEUNIDAD);
									}else{
										articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(SICArticuloConstantes.VALOREMPAQUECAJA);
									}
								}
								
								//articulo unidad de manejo uso compra
								ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTOCompra = new ArticuloUnidadManejoUsoDTO();
								articuloUnidadManejoUsoDTOCompra.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
								articuloUnidadManejoUsoDTOCompra.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANCOMPRA);
								articuloUnidadManejoUsoDTOCompra.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
								articuloUnidadManejoUsoDTOCompra.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
								articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTOCompra);
								
								//articulo unidad de manejo uso despacho
								ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTODespacho = new ArticuloUnidadManejoUsoDTO();
								articuloUnidadManejoUsoDTODespacho.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
								articuloUnidadManejoUsoDTODespacho.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANDESPACHO);
								articuloUnidadManejoUsoDTODespacho.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
								articuloUnidadManejoUsoDTODespacho.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTODespacho);
								
								//articulo unidad de manejo proveedor
								articuloUnidadManejoProveedorDTO = new ArticuloUnidadManejoProveedorDTO();
								articuloUnidadManejoProveedorDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
								articuloUnidadManejoProveedorDTO.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
								articuloUnidadManejoProveedorDTO.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
								articuloUnidadManejoProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								articuloUnidadManejoProveedorDTO.setArticuloUnidadManejoDTO(articuloUnidadManejoDTO);
								articuloUnidadManejoDTO.setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
								articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTO);
								
								articuloProveedorDTONuevo.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
								articuloProveedorDTONuevo.getUnidadesManejo().add(articuloUnidadManejoProveedorDTO);
							
								//asigna la nueva unidad de manejo al resto de proveedores
								ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
								articuloProveedorDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
								articuloProveedorDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
								articuloProveedorDTO.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								articuloProveedorDTO.addCriteriaSearchParameter("id.codigoProveedor", ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, 
										articuloProveedorDTONuevo.getId().getCodigoProveedor());
								articuloProveedorDTO.setArticulo(new ArticuloDTO());
								articuloProveedorDTO.setVistaProveedor(new VistaProveedorDTO());
								articuloProveedorDTO.getArticulo().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								articuloProveedorDTO.getArticulo().setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
								articuloProveedorDTO.getArticulo().getArtBitCodBarCol().add(new ArticuloBitacoraCodigoBarrasDTO());
								articuloProveedorDTO.getArticulo().getArtBitCodBarCol().iterator().next().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>(
										"estadoArticuloBitacora", 
										ComparatorTypeEnum.EQUAL_COMPARATOR, 
										SICConstantes.ESTADO_ACTIVO_NUMERICO
								));
								
								Collection<ArticuloProveedorDTO> articuloProveedorDTOCol = this.dataGestor.findObjects(articuloProveedorDTO);
								if(articuloProveedorDTOCol != null && !articuloProveedorDTOCol.isEmpty()){
									for(ArticuloProveedorDTO articuloProveedorDTOIte : articuloProveedorDTOCol){
										ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTOIte = new ArticuloUnidadManejoProveedorDTO();
										articuloUnidadManejoProveedorDTOIte.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
										articuloUnidadManejoProveedorDTOIte.getId().setCodigoProveedor(articuloProveedorDTOIte.getId().getCodigoProveedor());
										articuloUnidadManejoProveedorDTOIte.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
										articuloUnidadManejoProveedorDTOIte.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
										articuloUnidadManejoProveedorDTOIte.setArticuloUnidadManejoDTO(articuloUnidadManejoDTO);
										articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTOIte);
										
										articuloProveedorDTOIte.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
										articuloProveedorDTOIte.getUnidadesManejo().add(articuloUnidadManejoProveedorDTOIte);
									}
									articuloVO.getBaseDTO().getArticuloProveedorCol().addAll(articuloProveedorDTOCol);
								}
								
								if(articuloVO.getBaseDTO().getArticuloUnidadManejoCol() == null || !SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())){
									articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
								}
								articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoDTO);
							}else{
								if(StringUtils.equals(articuloUnidadManejoDTO.getEstadoUnidadManejo(), SICConstantes.ESTADO_INACTIVO_NUMERICO)){
									if(articuloImportadoVOClon.getPrioridad() != null && SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO.compareTo(articuloImportadoVOClon.getPrioridad()) == 0){
										articuloUnidadManejoDTO.setPrioridad(articuloImportadoVOClon.getPrioridad());
									}else{
										Integer prioridadDisponible = this.articuloUnidadManejoGestor.obtenerPrioridadDisponible(articuloImportadoVOClon.getCodigoCompania(), articuloUnidadManejoDTO.getId().getCodigoArticulo());
										articuloUnidadManejoDTO.setPrioridad(prioridadDisponible);
									}									
								}
								articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								
								ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTOCompra = null;
								ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTODespacho = null;
								
								//verifica que tenga la unidad de manejo compra
								if(articuloUnidadManejoDTO.getTieneUnidadesManejoUso()){
									articuloUnidadManejoUsoDTOCompra = (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(
											articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol(), 
											PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), 
													PredicateUtils.equalPredicate(SICArticuloConstantes.VALORUSOUNIMANCOMPRA)));
								}
								
								if(articuloUnidadManejoUsoDTOCompra == null){
									articuloUnidadManejoUsoDTOCompra = new ArticuloUnidadManejoUsoDTO();
									articuloUnidadManejoUsoDTOCompra.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
									articuloUnidadManejoUsoDTOCompra.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
									articuloUnidadManejoUsoDTOCompra.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANCOMPRA);
									articuloUnidadManejoUsoDTOCompra.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
									articuloUnidadManejoUsoDTOCompra.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									if(articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol() == null){
										articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
									}
									articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTOCompra);
								}
								
								//verifica que tenga la unidad de manejo despacho
								if(articuloUnidadManejoDTO.getTieneUnidadesManejoUso()){
									articuloUnidadManejoUsoDTODespacho = (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(
											articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol(), 
											PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), 
													PredicateUtils.equalPredicate(SICArticuloConstantes.VALORUSOUNIMANCOMPRA)));
								}
								
								if(articuloUnidadManejoUsoDTODespacho == null){
									articuloUnidadManejoUsoDTODespacho = new ArticuloUnidadManejoUsoDTO();
									articuloUnidadManejoUsoDTODespacho.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
									articuloUnidadManejoUsoDTODespacho.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
									articuloUnidadManejoUsoDTODespacho.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANDESPACHO);
									articuloUnidadManejoUsoDTODespacho.setCodigoTipoUso(SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);
									articuloUnidadManejoUsoDTODespacho.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
									if(articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol() == null){
										articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
									}
									articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTODespacho);
								}
								
								//articulo unidad de manejo proveedor
								articuloUnidadManejoProveedorDTO = new ArticuloUnidadManejoProveedorDTO();
								articuloUnidadManejoProveedorDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
								articuloUnidadManejoProveedorDTO.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
								articuloUnidadManejoProveedorDTO.getId().setCodigoUnidadManejo(articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
								articuloUnidadManejoProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								articuloUnidadManejoProveedorDTO.setArticuloUnidadManejoDTO(articuloUnidadManejoDTO);
								articuloUnidadManejoDTO.setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
								articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTO);
								
								articuloProveedorDTONuevo.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
								articuloProveedorDTONuevo.getUnidadesManejo().add(articuloUnidadManejoProveedorDTO);
							}
							
							if(articuloVO.getBaseDTO().getArticuloUnidadManejoCol() == null || !SearchDTO.isLoaded(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())){
								articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
							}
							articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoDTO);
							articuloProveedorDTONuevo.addDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA, true);
							
							if(BooleanUtils.isTrue(articuloImportadoVOClon.getEsCambioPrioridad())){
								//verificamos si la unidad de manejo que se va a crear ya existen en base
								if(!verificarExistenciaUnidadManejo(articuloVO)){
									reasignarPrioridadesUnidadManejo(articuloVO);
									//registra las unidades de manejo
									this.articuloUnidadManejoGestor.registrarArticuloUnidadManejo(articuloVO);
								}else{
									Logeable.LOG_SICV2.info("La unidad de manejo ya existe y no se creara");
								}
							}else{
								this.articuloUnidadManejoGestor.registrarArticuloUnidadManejo(articuloVO);
							}
							
							//llama a la integracion
							if(realizarIntegracion && (articuloImportadoVOClon.getPrioridad() == null ||(articuloImportadoVOClon.getPrioridad() != null && articuloImportadoVOClon.getPrioridad().intValue() != SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO))){
								articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().setUserId(articuloImportadoVO.getUserId());
								if (StringUtils.isNotBlank(articuloVO.getBaseDTO().getCodigoEstado()) && articuloVO.getBaseDTO().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO)) {
									articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().addDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA, ArticuloTransient.ADMINISTRACIONCOMPLETA);
									articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
								  //articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getUnidadesManejo().add(articuloUnidadManejoProveedorDTO);
									articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getUnidadesManejo().add(articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().iterator().next());
									articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().setVistaProveedor(articuloImportadoVO.getVistaProveedorDTO());
									this.accionArticuloProveedorGestor.transferirDatosArticuloProveedorSIC(articuloVO.getBaseDTO().getArticuloProveedorCol(), Boolean.FALSE, null);
								}
							}
						}else{
							throw new SICException("El art\u00edculo ".concat(articuloImportadoVO.getDescripcionArticulo())
									.concat(", tiene el n\u00famero m\u00e1ximo de unidades de manejo"));
						}
					}else{
						ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTOCompra = null;
						ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTODespacho = null;
						
						articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
						articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO());
						
						//verifica que tenga la unidad de manejo compra
						if(articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getTieneUnidadesManejoUso()){
							articuloUnidadManejoUsoDTOCompra = (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(
									articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol(), 
									PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), 
											PredicateUtils.equalPredicate(SICArticuloConstantes.getInstancia().VALORUSOUNIMANCOMPRA)));
						}
						
						if(articuloUnidadManejoUsoDTOCompra == null){
							articuloUnidadManejoUsoDTOCompra = new ArticuloUnidadManejoUsoDTO();
							articuloUnidadManejoUsoDTOCompra.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
							articuloUnidadManejoUsoDTOCompra.getId().setCodigoUnidadManejo(articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo());
							articuloUnidadManejoUsoDTOCompra.getId().setValorTipoUso(SICArticuloConstantes.getInstancia().VALORUSOUNIMANCOMPRA);
							articuloUnidadManejoUsoDTOCompra.setCodigoTipoUso(SICArticuloConstantes.getInstancia().CODIGOTIPOUSOUNIMAN);
							articuloUnidadManejoUsoDTOCompra.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							if(articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol() == null){
								articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
							}
							articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTOCompra);
						}
						
						//verifica que tenga la unidad de manejo despacho
						if(articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getTieneUnidadesManejoUso()){
							articuloUnidadManejoUsoDTODespacho = (ArticuloUnidadManejoUsoDTO) CollectionUtils.find(
									articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol(), 
									PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.valorTipoUso"), 
											PredicateUtils.equalPredicate(SICArticuloConstantes.getInstancia().VALORUSOUNIMANDESPACHO)));
						}
						
						if(articuloUnidadManejoUsoDTODespacho == null){
							articuloUnidadManejoUsoDTODespacho = new ArticuloUnidadManejoUsoDTO();
							articuloUnidadManejoUsoDTODespacho.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
							articuloUnidadManejoUsoDTODespacho.getId().setCodigoUnidadManejo(articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo());
							articuloUnidadManejoUsoDTODespacho.getId().setValorTipoUso(SICArticuloConstantes.getInstancia().VALORUSOUNIMANDESPACHO);
							articuloUnidadManejoUsoDTODespacho.setCodigoTipoUso(SICArticuloConstantes.getInstancia().CODIGOTIPOUSOUNIMAN);
							articuloUnidadManejoUsoDTODespacho.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							if(articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol() == null){
								articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
							}
							articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO().getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTODespacho);
						}
						
						if(articuloUnidadManejoUsoDTOCompra != null || articuloUnidadManejoUsoDTODespacho != null){
							
							if(BooleanUtils.isTrue(articuloImportadoVOClon.getEsCambioPrioridad())){
								//verificamos si la unidad de manejo que se va a crear ya existen en base
								if(!verificarExistenciaUnidadManejo(articuloVO)){
									reasignarPrioridadesUnidadManejo(articuloVO);
									//registra las unidades de manejo
									this.articuloUnidadManejoGestor.registrarArticuloUnidadManejo(articuloVO);
								}else{
									Logeable.LOG_SICV2.info("La unidad de manejo ya existe y no se creara");
								}
							}else{
								this.articuloUnidadManejoGestor.registrarArticuloUnidadManejo(articuloVO);
							}
						}
					}
					
					articuloDTO.setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
					articuloDTO.getArticuloUnidadManejoCol().add(articuloUnidadManejoProveedorDTO.getArticuloUnidadManejoDTO());
				}
				//articulo local (alcance)
				if(articuloImportadoVOClon.getCodigoAreaTrabajoPedido() != null){
					//valida si existe la clasificacion
					if(articuloImportadoVOClon.getCodigoClasificacion() != null){
						clasificacionDTO = new ClasificacionDTO();
						clasificacionDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
						clasificacionDTO.getId().setCodigoClasificacion(articuloImportadoVOClon.getCodigoClasificacion());
						clasificacionDTO.setEstadoClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						clasificacionDTO.setCodigoTipoClasificacion(SICConstantes.TIPCLA_CLASIFICACION);
						clasificacionDTO = this.dataGestor.findUnique(clasificacionDTO);
					}else {
						clasificacionDTO = this.articuloNuevoImportadoDAO.obtenerClasificacionPorCliente(articuloImportadoVOClon.getCodigoCompania(), articuloImportadoVOClon.getCodigoClienteImportacion());
					}
					
					if(clasificacionDTO == null){
						throw new SICException("La clasificaci\u00F3n ".concat(articuloImportadoVOClon.getCodigoClasificacion()).concat(" del art\u00EDculo ")
								.concat(articuloImportadoVOClon.getDescripcionArticulo()).concat(" no existe"));
					}
					validarDatosAlcanceArticuloImportado(articuloVO, articuloImportadoVOClon, clasificacionDTO);
					articuloVO.setBaseDTOAnterior(null);
					this.articuloAlcanceGestor.asignarArticuloAlcanceAreasTrabajo(articuloVO);
				}
				
				if(articuloImportadoVOClon.getDynamicProperty("definicionID")!=null){
					articuloDTO.addDynamicProperty("auditoria", this.almacenamientoAuditoriaArticuloGestor.registrarLogAuditoriaArticulo(articuloVO, articuloImportadoVOClon.getDynamicProperty("definicionID", String.class), articuloVO.getSystemId(), articuloVO.getAccessItemId()));					
				}
			}
			//nuevo
			else{
				articuloVO = new ArticuloVO(new ArticuloDTO());
				articuloVO.setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				articuloVO.setUserId(articuloImportadoVO.getUserId());
				articuloVO.setAccessItemId(articuloImportadoVOClon.getAccessItemId());
				articuloVO.setSystemId(articuloImportadoVOClon.getSystemId());
				articuloVO.getBaseDTO().setCodigoSistemaOrigen(articuloImportadoVOClon.getSystemId());
				articuloVO.getBaseDTO().setSegmentoCreacionArticulos(new ArrayList<SegmentoCreacionArticuloDTO>());
				SegmentoCreacionArticuloDTO segmentoCreacionArticuloDTO = new SegmentoCreacionArticuloDTO();
				segmentoCreacionArticuloDTO.getId().setCodigoPasoCreacion(TipoCatalogoArticulo.PASOS_CREACION_ARTICULO);
				segmentoCreacionArticuloDTO.getId().setValorPasoCreacion(TipoCatalogoArticulo.VALOR_PASOCREACION_OMISION);
				segmentoCreacionArticuloDTO.setEstadoSegmento(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloVO.getBaseDTO().getSegmentoCreacionArticulos().add(segmentoCreacionArticuloDTO);
				
				ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
				
				//valida novedad
				if(articuloImportadoVOClon.getArticuloProveedorNovedadDTO() != null && articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getValorTipoNovedad() != null){
					
					if(articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getReferencias() == null 
							|| (articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getReferencias() != null 
							&& articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getReferencias().isEmpty())){
						throw new SICException("La novedad debe tener al menos un art\u00EDculo referenciado");
					}
					articuloProveedorDTO.addDynamicProperty(ArticuloTransient.ALERTA_IMPORTACION, articuloImportadoVOClon.getArticuloProveedorNovedadDTO());

					//vacia el codigo de barras si el articulo posee una novedad de nuevo con novedad en: 
					//referencia externa 
					//referencia externa y codigo de barras
					//descripcion diferente en la proforma
					if(articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getValorTipoNovedad().equals(TipoCatalogoArticulo.VALOR_NOVEDAD_REFERENCIAPROVEEDOR) 
									|| articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getValorTipoNovedad().equals(TipoCatalogoArticulo.VALOR_NOVEDAD_CODIGOBARRAS_REFERENCIAPROVEEDOR)
									|| articuloImportadoVOClon.getArticuloProveedorNovedadDTO().getValorTipoNovedad().equals(TipoCatalogoArticulo.VALOR_NOVEDAD_EXISTENTE_DIFERENCIAS_PROFORMA)){
						articuloImportadoVOClon.setCodigoBarras(null);
					}
				}
				
				if(articuloImportadoVOClon.getClaseArticulo() != null && !articuloImportadoVOClon.getClaseArticulo().isEmpty()){
					//valida si existe la clase
					ClaseArticuloDTO claseArticuloDTO = new ClaseArticuloDTO();
					claseArticuloDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					claseArticuloDTO.getId().setCodigoClaseArticulo(articuloImportadoVOClon.getClaseArticulo());
					claseArticuloDTO.setStatus(SICConstantes.ESTADO_ACTIVO_LITERAL);
					claseArticuloDTO = this.dataGestor.findUnique(claseArticuloDTO);
					if(claseArticuloDTO == null){
						throw new SICException("La clase ".concat(articuloImportadoVOClon.getClaseArticulo()).concat(" del art\u00EDculo ")
								.concat(articuloImportadoVOClon.getDescripcionArticulo()).concat(" no existe"));
					}
				}
				
				if(articuloImportadoVOClon.getCodigoClasificacion() != null && !articuloImportadoVOClon.getCodigoClasificacion().isEmpty()){
					//valida si existe la clasificacion
					clasificacionDTO = new ClasificacionDTO();
					clasificacionDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					clasificacionDTO.getId().setCodigoClasificacion(articuloImportadoVOClon.getCodigoClasificacion());
					clasificacionDTO.setEstadoClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					clasificacionDTO.setCodigoTipoClasificacion(SICConstantes.TIPCLA_CLASIFICACION);
					clasificacionDTO = this.dataGestor.findUnique(clasificacionDTO);
					if(clasificacionDTO == null){
						throw new SICException("La clasificaci\u00F3n ".concat(articuloImportadoVOClon.getCodigoClasificacion()).concat(" del art\u00EDculo ")
								.concat(articuloImportadoVOClon.getDescripcionArticulo()).concat(" no existe"));
					}
				}else if(StringUtils.isNotEmpty(articuloImportadoVOClon.getCodigoClasificacionWRT())){//TODO
					//valida si existe la clasificacion de EC seun la clasificacion WRT
					Collection<ClasificacionDTO> clasificacionCol = new ArrayList<ClasificacionDTO>();
					clasificacionDTO = new ClasificacionDTO();
					clasificacionDTO.getId().setCodigoCompania(articuloVO.getCodigoCompania());
					clasificacionDTO.getId().setCodigoClasificacion(articuloImportadoVOClon.getCodigoClasificacionWRT());
					clasificacionDTO.setEstadoClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					
					clasificacionCol = estructuraComercialGestor.obtenerECDesdeWRT(clasificacionDTO);
					if(CollectionUtils.isNotEmpty(clasificacionCol)){
						
						clasificacionDTO = (ClasificacionDTO) CollectionUtils.get(clasificacionCol, 0);
						articuloVO.getBaseDTO().setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
					}
				}
				
				if(clasificacionDTO == null){
					clasificacionDTO = this.articuloNuevoImportadoDAO.obtenerClasificacionPorCliente(articuloImportadoVOClon.getCodigoCompania(), articuloImportadoVOClon.getCodigoClienteImportacion());
				}
				
				if(clasificacionDTO == null && articuloImportadoVOClon.getCodigoClienteImportacion() == null){
					throw new SICException("No ha podido asociar el art\u00EDculo a un cliente o a una clasificaci\u00F3n.");
				}
				
				//articulo
				articuloVO.getBaseDTO().getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				articuloVO.getBaseDTO().setCodigoClienteImportacion(articuloImportadoVOClon.getCodigoClienteImportacion());
				articuloVO.getBaseDTO().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloVO.getBaseDTO().setDescripcionArticulo(articuloImportadoVOClon.getDescripcionArticulo());
				articuloVO.getBaseDTO().setClaseArticulo(articuloImportadoVOClon.getClaseArticulo());
				if(articuloImportadoVOClon.getCodigoClasificacion() != null){
					articuloVO.getBaseDTO().setCodigoClasificacion(articuloImportadoVOClon.getCodigoClasificacion());
				}			
				articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO);
				articuloVO.getBaseDTO().setCodigoTipoArticulo(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_PRODUCTO);
				articuloVO.getBaseDTO().setUserId(articuloImportadoVOClon.getUserId());
				
				//articulo codigo de barras
				ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
				articuloBitacoraCodigoBarrasDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				articuloBitacoraCodigoBarrasDTO.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				validator = new ValidatorImpl();
				if(articuloImportadoVOClon.getCodigoBarras() != null 
						&& !articuloImportadoVOClon.getCodigoBarras().isEmpty()
						&& validator.validateEAN(articuloImportadoVO.getCodigoBarras())){
					articuloBitacoraCodigoBarrasDTO.getId().setCodigoBarras(articuloImportadoVOClon.getCodigoBarras());
					articuloBitacoraCodigoBarrasDTO.setCodigoTipoCodigoArticulo(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN);
				}else{
					articuloBitacoraCodigoBarrasDTO.setCodigoTipoCodigoArticulo(SICArticuloConstantes.getInstancia().TIPO_CODBAR_INTERNO);
					articuloBitacoraCodigoBarrasDTO.setValorTipoSecuencia(SICArticuloConstantes.getInstancia().TIPSECART_PESOFIJO);
					articuloBitacoraCodigoBarrasDTO.setCodigoTipoSecuencia(SICArticuloConstantes.getInstancia().TIPOCATALOGO_SECUENCIAINTERNA);
				}
				articuloVO.getBaseDTO().setCodigoBarrasActivo(articuloBitacoraCodigoBarrasDTO);
				
				//articulo comercial
				ArticuloComercialDTO articuloComercialDTO = new ArticuloComercialDTO();
				articuloComercialDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				articuloComercialDTO.setCodigoMarcaComercial(articuloImportadoVOClon.getCodigoMarcaComercial());
				articuloComercialDTO.setMarcaParticipaciones(SICArticuloConstantes.getInstancia().MARCA_PARTICIPACIONES_PREDETERMINADA);
				articuloComercialDTO.setCodigoTipoControlCosto(SICConstantes.TIPO_CONTROL_COSTO);
				articuloComercialDTO.setValorTipoControlCosto(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE);
				//registra pais
				articuloComercialDTO.setCodigoPaisOrigen(articuloImportadoVOClon.getCodigoPaisOrigen());
				//Registra el lugar
				articuloComercialDTO.setCodigoLugarCompra(articuloImportadoVOClon.getCodigoLugarCompra());
				articuloVO.getBaseDTO().setArticuloComercialDTO(articuloComercialDTO);
				articuloComercialDTO.setPorcentajeNoAfiliado(clasificacionDTO == null ? 5.00 : clasificacionDTO.getPorcentajeNoAfiliado());
				
				if(articuloImportadoVOClon.getMaterialArticulo() != null && !articuloImportadoVOClon.getMaterialArticulo().isEmpty()){
					//articulo material
					ArticuloMaterialDTO articuloMaterialDTO = new ArticuloMaterialDTO();
					articuloMaterialDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloMaterialDTO.getId().setCodigoTipoMaterial(SICArticuloConstantes.getInstancia().CODIGOTIPOMATERIAL);
					articuloMaterialDTO.getId().setValorTipoMaterial(SICArticuloConstantes.getInstancia().VALOR_TIPOMATERIAL_OTRO);
					articuloMaterialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloMaterialDTO.setEsPrincipal(Boolean.FALSE);
					articuloMaterialDTO.setObservacion(articuloImportadoVOClon.getMaterialArticulo());
					articuloVO.getBaseDTO().setArticuloMaterialDTOs(new ArrayList<ArticuloMaterialDTO>());
					articuloVO.getBaseDTO().getArticuloMaterialDTOs().add(articuloMaterialDTO);
				}
				
				//articulo proveedor
				articuloProveedorDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				articuloProveedorDTO.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
				articuloProveedorDTO.setCodigoReferenciaInterna(articuloImportadoVOClon.getCodigoReferenciaExterna());
				articuloProveedorDTO.setCodigoReferenciaProveedor(articuloImportadoVOClon.getCodigoReferenciaExterna());
				articuloProveedorDTO.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloProveedorDTO.setCostoBruto(SICArticuloConstantes.getInstancia().VALOR_PREDETERMINADO_COSTO);
				articuloProveedorDTO.addDynamicProperty(ArticuloTransient.ADMINISTRACIONCOMPLETA, Boolean.TRUE);
				
				//articulo importacion
				ArticuloImportacionDTO articuloImportacionDTO = new ArticuloImportacionDTO();
				articuloImportacionDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				articuloImportacionDTO.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
				articuloImportacionDTO.setCodigoMonedaOrigen(articuloImportadoVOClon.getCodigoMoneda());
				articuloImportacionDTO.setCostoMonedaOrigen(articuloImportadoVOClon.getCostoBruto());
				articuloProveedorDTO.setArticuloImportacion(articuloImportacionDTO);
				articuloVO.getBaseDTO().setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
				articuloVO.getBaseDTO().getArticuloProveedorCol().add(articuloProveedorDTO);
				
				//Impuestos del articulo
				if(articuloImportadoVOClon.getAplicaIva() || (clasificacionDTO != null && StringUtils.equals(clasificacionDTO.getCodigoBodega(),SICArticuloConstantes.getInstancia().CODIGO_SUBBODEGA_JUGUETES) && !StringUtils.equals(articuloImportadoVOClon.getCodigoProveedor(),SICArticuloConstantes.getInstancia().CODIGO_PROVEEDOR_OMISION_IVA_JUGUETES))){
					//articulo impuesto IVA
					ArticuloImpuestoDTO articuloImpuestoDTOIva = new ArticuloImpuestoDTO();
					articuloImpuestoDTOIva.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloImpuestoDTOIva.getId().setCodigoTipoImpuesto(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVA);
					articuloImpuestoDTOIva.setEstadoArticuloImpuesto(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloImpuestoDTOIva.setEsParaCompra(Boolean.TRUE);
					articuloImpuestoDTOIva.setEsParaVenta(clasificacionDTO != null && StringUtils.equals(clasificacionDTO.getCodigoBodega(),SICArticuloConstantes.getInstancia().CODIGO_SUBBODEGA_JUGUETES) ? Boolean.TRUE : Boolean.FALSE);
					
					articuloVO.getBaseDTO().setArticuloImpuestoCol(new ArrayList<ArticuloImpuestoDTO>());
					articuloVO.getBaseDTO().getArticuloImpuestoCol().add(articuloImpuestoDTOIva);
				}
				
				if(articuloImportadoVOClon.getAplicaIve()){
					//articulo impuesto IVE
					ArticuloImpuestoDTO articuloImpuestoDTOIve = new ArticuloImpuestoDTO();
					articuloImpuestoDTOIve.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloImpuestoDTOIve.getId().setCodigoTipoImpuesto(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVE);
					articuloImpuestoDTOIve.setEstadoArticuloImpuesto(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloImpuestoDTOIve.setEsParaCompra(Boolean.TRUE);
					articuloImpuestoDTOIve.setEsParaVenta(Boolean.FALSE);
					
					if(articuloVO.getBaseDTO().getArticuloImpuestoCol() == null){
						articuloVO.getBaseDTO().setArticuloImpuestoCol(new ArrayList<ArticuloImpuestoDTO>());
					}
					articuloVO.getBaseDTO().getArticuloImpuestoCol().add(articuloImpuestoDTOIve);
				}
				
				//Validacion de datos de precios para articulos importados
				if(!articuloVO.getBaseDTO().getTieneArticuloPrecio()){
					articuloVO.getBaseDTO().setArticuloPrecioCol(new ArrayList<ArticuloPrecioDTO>());
					articuloVO.addDynamicProperty(ArticuloTransient.PRECIO_ARTICULO_PROVEEDOR_IMPORTADO, Boolean.FALSE);
					
					ArticuloPrecioDTO precioBase = new ArticuloPrecioDTO();
					precioBase.getId().setCodigoTipoPrecio(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE);
					precioBase.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					precioBase.setValorActual(SICArticuloConstantes.getInstancia().VALOR_PREDETERMINADO_PRECIO);
					articuloVO.getBaseDTO().getArticuloPrecioCol().add(precioBase);
					
					ArticuloPrecioDTO precioVentaPublico = new ArticuloPrecioDTO();
					precioVentaPublico.getId().setCodigoTipoPrecio(SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP);
					precioVentaPublico.setEstadoPrecio(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					precioVentaPublico.setValorActual(SICArticuloConstantes.getInstancia().VALOR_PREDETERMINADO_PRECIO_PVP);
					articuloVO.getBaseDTO().getArticuloPrecioCol().add(precioVentaPublico);
				}
				
				//Campos predeterminados para juguetes (PENDIENTE CAMBIAR)//TODO
				
				if(clasificacionDTO != null && StringUtils.equals(clasificacionDTO.getCodigoBodega(),SICArticuloConstantes.getInstancia().CODIGO_SUBBODEGA_JUGUETES)){
					
					//Asignar la primera clasificacion de la linea comercial asociada al cliente siempre y cuando esta sea de juguetes
					articuloVO.getBaseDTO().setClasificacionDTO(clasificacionDTO);
					articuloVO.getBaseDTO().setCodigoClasificacion(clasificacionDTO.getId().getCodigoClasificacion());
					
					articuloVO.getBaseDTO().setClaseArticulo(SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_R);
					if(articuloImportadoVOClon.getCodigoClienteCompra() != null && StringUtils.equals(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.cliente.wrt.jec"),articuloImportadoVOClon.getCodigoClienteCompra())){
						if(articuloVO.getBaseDTO().getTieneArticuloProcesoLogistico()){
							articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setCodigoIndicadorPropietario(SICArticuloConstantes.getInstancia().INDICADORPROPIETARIOGENERAL);
						}else{
							articuloVO.getBaseDTO().setArticuloProcesoLogisticoDTO(new ArticuloProcesoLogisticoDTO());
							articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setCodigoIndicadorPropietario(SICArticuloConstantes.getInstancia().INDICADORPROPIETARIOGENERAL);
						}
						articuloVO.getBaseDTO().setCodigoGrupoAlcance(SICArticuloConstantes.getInstancia().PROTOTIPO_ALCANCE_PREDETERMINADO_JUGUETES);
					}else if(articuloImportadoVOClon.getCodigoClienteCompra() != null && StringUtils.equals(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.cliente.wrt.grk"),articuloImportadoVOClon.getCodigoClienteCompra())){
						if(articuloVO.getBaseDTO().getTieneArticuloProcesoLogistico()){
							articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setCodigoIndicadorPropietario(SICArticuloConstantes.getInstancia().INDICADORPROPIETARIOGENERAL_AKI);
						}else{
							articuloVO.getBaseDTO().setArticuloProcesoLogisticoDTO(new ArticuloProcesoLogisticoDTO());
							articuloVO.getBaseDTO().getArticuloProcesoLogisticoDTO().setCodigoIndicadorPropietario(SICArticuloConstantes.getInstancia().INDICADORPROPIETARIOGENERAL_AKI);
						}
						articuloVO.getBaseDTO().setCodigoGrupoAlcance(SICArticuloConstantes.getInstancia().PROTOTIPO_ALCANCE_PREDETERMINADO_JUGUETES);//CONFIMAR PROTOTIPO TODO
					}
					
					
					if(articuloVO.getBaseDTO().getTieneArticuloComercial() && articuloVO.getBaseDTO().getArticuloComercialDTO().getCodigoMarcaComercial() == null){
						ProveedorMarcaDTO proveedorMarcaDTO = new ProveedorMarcaDTO();
						proveedorMarcaDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
						proveedorMarcaDTO.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
						proveedorMarcaDTO.setMarcaArticuloDTO(new MarcaArticuloDTO());
						proveedorMarcaDTO.getMarcaArticuloDTO().setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						proveedorMarcaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						Collection<ProveedorMarcaDTO> proveedorMarcaDTOs = dataGestor.findObjects(proveedorMarcaDTO);
						if(CollectionUtils.isNotEmpty(proveedorMarcaDTOs)){
							articuloVO.getBaseDTO().getArticuloComercialDTO().setCodigoMarcaComercial(proveedorMarcaDTOs.iterator().next().getId().getSecuencialMarca());
						}else{
							articuloVO.getBaseDTO().getArticuloComercialDTO().setCodigoMarcaComercial(SICArticuloConstantes.getInstancia().CODIGO_MARCA_PENDIENTE);
						}
					}
					
					if(!articuloVO.getBaseDTO().getTieneArticuloMedida()){
						articuloVO.getBaseDTO().setArticuloMedidaDTO(new ArticuloMedidaDTO());
						articuloVO.getBaseDTO().getArticuloMedidaDTO().getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
						articuloVO.getBaseDTO().getArticuloMedidaDTO().getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
						articuloVO.getBaseDTO().getArticuloMedidaDTO().setCantidadMedida(SICArticuloConstantes.getInstancia().CANTIDAD_MEDIDA_PREDETERMINADO_JUGUETES);
						articuloVO.getBaseDTO().getArticuloMedidaDTO().setValorTipoMedida(SICArticuloConstantes.getInstancia().TIPOMEDIDA_UNIDAD);
						articuloVO.getBaseDTO().getArticuloMedidaDTO().setCodigoTipoMedida(SICArticuloConstantes.getInstancia().CODIGO_CATALOGO_UNIDAD_MEDIDA);
					}
				}
				
				
				ArticuloUnidadManejoDTO articuloUnidadManejoDTO = null;
				ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO = null;
				if(articuloImportadoVOClon.getValorUnidadManejo() != null && articuloImportadoVOClon.getValorUnidadManejo().intValue() > 0){
					//articulo unidad de manejo
					articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
					articuloUnidadManejoDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloUnidadManejoDTO.setValorUnidadManejo(articuloImportadoVOClon.getValorUnidadManejo());
					articuloUnidadManejoDTO.setCodigoTipoUnidadEmpaque(SICArticuloConstantes.getInstancia().CODIGOTIPOEMPAQUE);
					articuloUnidadManejoDTO.setPrioridad(1);
					if(articuloImportadoVOClon.getCodigoCatalogoUnidadManejo() != null){
						articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(articuloImportadoVOClon.getCodigoCatalogoUnidadManejo());
					}else{
						if(articuloImportadoVOClon.getValorUnidadManejo().intValue() == 1){
							articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(SICArticuloConstantes.getInstancia().VALOREMPAQUEUNIDAD);
						}else{
							articuloUnidadManejoDTO.setValorTipoUnidadEmpaque(SICArticuloConstantes.getInstancia().VALOREMPAQUECAJA);
						}
					}
					
					//articulo unidad de manejo proveedor
					articuloUnidadManejoProveedorDTO = new ArticuloUnidadManejoProveedorDTO();
					articuloUnidadManejoProveedorDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloUnidadManejoProveedorDTO.getId().setCodigoProveedor(articuloImportadoVOClon.getCodigoProveedor());
					articuloUnidadManejoProveedorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloUnidadManejoDTO.setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
					articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTO);
					
					//articulo unidad de manejo uso compra
					ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTOCompra = new ArticuloUnidadManejoUsoDTO();
					articuloUnidadManejoUsoDTOCompra.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloUnidadManejoUsoDTOCompra.getId().setValorTipoUso(SICArticuloConstantes.getInstancia().VALORUSOUNIMANCOMPRA);
					articuloUnidadManejoUsoDTOCompra.setCodigoTipoUso(SICArticuloConstantes.getInstancia().CODIGOTIPOUSOUNIMAN);
					articuloUnidadManejoUsoDTOCompra.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
					articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTOCompra);
					
					//articulo unidad de manejo uso despacho
					ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTODespacho = new ArticuloUnidadManejoUsoDTO();
					articuloUnidadManejoUsoDTODespacho.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					articuloUnidadManejoUsoDTODespacho.getId().setValorTipoUso(SICArticuloConstantes.getInstancia().VALORUSOUNIMANDESPACHO);
					articuloUnidadManejoUsoDTODespacho.setCodigoTipoUso(SICArticuloConstantes.getInstancia().CODIGOTIPOUSOUNIMAN);
					articuloUnidadManejoUsoDTODespacho.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTODespacho);
					
					articuloVO.getBaseDTO().setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
					articuloVO.getBaseDTO().getArticuloUnidadManejoCol().add(articuloUnidadManejoDTO);
				}
				
				//articulo local (alcance)
				if(articuloImportadoVOClon.getCodigoAreaTrabajoPedido() != null){
					validarDatosAlcanceArticuloImportado(articuloVO, articuloImportadoVOClon, clasificacionDTO);
				}
				
				//articulo establecimiento
				if(!CollectionUtils.isEmpty(articuloImportadoVO.getCodigosLineasComerciales())){
					Collection<Integer> codigosEstablecimientosCol = null;
					LineaComercialDTO lineaComercialDTO = new LineaComercialDTO();
					lineaComercialDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					lineaComercialDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					lineaComercialDTO.addCriteriaSearchParameter("id.codigoLineaComercial", ComparatorTypeEnum.IN_COMPARATOR, articuloImportadoVO.getCodigosLineasComerciales());
					lineaComercialDTO.getCriteriaSearch().addDistinctSearchParameter("codigoEstablecimiento");
					codigosEstablecimientosCol = this.dataGestor.findDistinct(lineaComercialDTO, Integer.class);
					if(CollectionUtils.isEmpty(codigosEstablecimientosCol)){
						throw new SICException("No se encontraron establecimientos de las l\u00EDneas comerciales enviadas");
					}
					
					articuloVO.getBaseDTO().setArticuloEstablecimientoCol(new ArrayList<ArticuloEstablecimientoDTO>());
					for(Integer codigoEstablecimiento : codigosEstablecimientosCol){
						ArticuloEstablecimientoDTO articuloEstablecimientoDTO = new ArticuloEstablecimientoDTO();
						articuloEstablecimientoDTO.getId().setCodigoEstablecimiento(codigoEstablecimiento);
						articuloVO.getBaseDTO().getArticuloEstablecimientoCol().add(articuloEstablecimientoDTO);
					}
				}else if(articuloImportadoVO.getCodigoClienteImportacion() != null){
					articuloVO.getBaseDTO().setArticuloEstablecimientoCol(new ArrayList<ArticuloEstablecimientoDTO>());
					Collection<Integer> codigosEstablecimientosCol = null;
					LineaComercialClienteImportacionDTO lineaComercialClienteImportacionDTO = new LineaComercialClienteImportacionDTO();
					lineaComercialClienteImportacionDTO.addCriteriaSearchParameter("id.codigoClienteImportacion", ComparatorTypeEnum.EQUAL_COMPARATOR, articuloImportadoVO.getCodigoClienteImportacion());
					lineaComercialClienteImportacionDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					lineaComercialClienteImportacionDTO.setLineaComercialDTO(new LineaComercialDTO());
					lineaComercialClienteImportacionDTO.getLineaComercialDTO().getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
					lineaComercialClienteImportacionDTO.getLineaComercialDTO().setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					lineaComercialClienteImportacionDTO.getCriteriaSearch().addDistinctSearchParameter("lineaComercialDTO.codigoEstablecimiento");
					codigosEstablecimientosCol = this.dataGestor.findDistinct(lineaComercialClienteImportacionDTO, Integer.class);
					if(CollectionUtils.isEmpty(codigosEstablecimientosCol)){
						throw new SICException("No se encontraron establecimientos de las l\u00EDneas comerciales enviadas");
					}
					
					articuloVO.getBaseDTO().setArticuloEstablecimientoCol(new ArrayList<ArticuloEstablecimientoDTO>());
					for(Integer codigoEstablecimiento : codigosEstablecimientosCol){
						ArticuloEstablecimientoDTO articuloEstablecimientoDTO = new ArticuloEstablecimientoDTO();
						articuloEstablecimientoDTO.getId().setCodigoEstablecimiento(codigoEstablecimiento);
						articuloVO.getBaseDTO().getArticuloEstablecimientoCol().add(articuloEstablecimientoDTO);
					}
				}else{
					throw new SICException("Debe enviar los c\u00F3digos o el c\u00F3digo de cliente de la l\u00EDnea comercial");
				}
				
				articuloVO = this.articuloGestor.registrarArticulo(articuloVO);
				articuloImportadoVO.addDynamicProperty("esNuevo", Boolean.TRUE);				
				articuloDTO = articuloVO.getBaseDTO();
				articuloDTO.addDynamicProperty("esNuevo", Boolean.TRUE);
				
				if(articuloUnidadManejoDTO != null && articuloUnidadManejoProveedorDTO != null){
					articuloDTO.setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
					articuloDTO.getArticuloUnidadManejoCol().add(articuloUnidadManejoDTO);
					
					articuloUnidadManejoDTO.setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
					articuloUnidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(articuloUnidadManejoProveedorDTO);
				}
				
				if(articuloProveedorDTO != null){
					articuloDTO.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
					articuloDTO.getArticuloProveedorCol().add(articuloProveedorDTO);
				}
				
			}
			
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Error al registrar el art\u00EDculo importado desde la orden de compra: {}", e);
			throw e;
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al registrar el art\u00EDculo importado desde la orden de compra: {}", e);
			throw new SICException(e.getMessage());
		}
		return articuloDTO;
	}

	/**
	 * reasigna las prioridades de las unidades de manejo dependiendo de la bandera esCambioPrioridad
	 * @author corbe
	 * @param articuloVO
	 */
	private void reasignarPrioridadesUnidadManejo(ArticuloVO articuloVO) {
		
		//verificamos si existe una nueva unidad de manejo a crearse y si tiene la bandera de cambio de prioridad
		if(CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())){
			ArticuloUnidadManejoDTO articuloUnidadManejoPrioridadUno = null;
			for(ArticuloUnidadManejoDTO articuloUnidadManejo : articuloVO.getBaseDTO().getArticuloUnidadManejoCol()){
				if(BooleanUtils.isTrue(articuloUnidadManejo.getId().getCodigoUnidadManejo() == null && BooleanUtils.isTrue(articuloUnidadManejo.getEsCambioPrioridad()))){
					//condicionamos para cuando venga con prioridad uno
					if(articuloUnidadManejo.getPrioridad().equals(1)){
						articuloUnidadManejoPrioridadUno = SerializationUtils.clone(articuloUnidadManejo);
						break;
					}
				}
			}
			
			if(articuloUnidadManejoPrioridadUno != null){
				//aumentamos las prioridades de las unidades 
				articuloUnidadManejoGestor.aumentarPrioridadUnidadManejo(articuloUnidadManejoPrioridadUno.getPrioridad() , articuloUnidadManejoPrioridadUno.getId().getCodigoCompania() , articuloVO.getBaseDTO().getId().getCodigoArticulo());
			}
		}
	}
	
	/**
	 * busca la unidad de manejo en base para saber si debe crear o no
	 * @author corbe
	 * @param articuloVO
	 * @return
	 */
	private Boolean verificarExistenciaUnidadManejo(ArticuloVO articuloVO){
		try{
			if(CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloUnidadManejoCol())){
				ArticuloUnidadManejoDTO articuloUnidadManejoFound = articuloVO.getBaseDTO().getArticuloUnidadManejoCol().iterator().next();
				
				ArticuloUnidadManejoDTO articuloUnidadManejoTemplate = new ArticuloUnidadManejoDTO();
				articuloUnidadManejoTemplate.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				articuloUnidadManejoTemplate.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
				articuloUnidadManejoTemplate.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloUnidadManejoTemplate.setValorUnidadManejo(articuloUnidadManejoFound.getValorUnidadManejo());
				
				ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTO = new ArticuloUnidadManejoUsoDTO();
				articuloUnidadManejoUsoDTO.getId().setValorTipoUso(SICArticuloConstantes.VALORUSOUNIMANCOMPRA);
				articuloUnidadManejoUsoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloUnidadManejoTemplate.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
				articuloUnidadManejoTemplate.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTO);
				
				ArticuloUnidadManejoDTO articuloUnidadManejoExistente = dataGestor.findUnique(articuloUnidadManejoTemplate);
				if(articuloUnidadManejoExistente != null){
					return true;
				}
			}
			return false;
		}catch(Exception e){
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException("ocurrio un error al consultar la unidad de manejo");
		}
	}
	
	@Override
	public void validarDatosAlcanceArticuloImportado(ArticuloVO articuloVO, ArticuloImportadoVO articuloImportadoVOClon, 
			ClasificacionDTO clasificacionDTO) throws SICException{

		try {
			//verifica si el area de trabajo pedido es un local
			AreaTrabajoDTO areaTrabajoDTOPedido = new AreaTrabajoDTO();
			areaTrabajoDTOPedido.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
			areaTrabajoDTOPedido.getId().setCodigoAreaTrabajo(articuloImportadoVOClon.getCodigoAreaTrabajoPedido());
			areaTrabajoDTOPedido.setEstadoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);
			areaTrabajoDTOPedido = this.dataGestor.findUnique(areaTrabajoDTOPedido);
			if(areaTrabajoDTOPedido == null){
				throw new SICException("No se pudo encontrar el \u00E1rea de pedido ");
			}
			if(areaTrabajoDTOPedido.getTipoAreaTrabajoValor().equals(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL)){
				//crea el alcance al local pedido
				ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
				articuloLocalDTO.getId().setCodigoLocal(areaTrabajoDTOPedido.getId().getCodigoAreaTrabajo());
				articuloLocalDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloVO.getBaseDTO().setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
				articuloVO.getBaseDTO().getArticuloLocalCol().add(articuloLocalDTO);
			}
			
			//obtiene el area de trabajo destino
			AreaTrabajoDTO areaTrabajoDTODestino = new AreaTrabajoDTO();
			areaTrabajoDTODestino.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
			areaTrabajoDTODestino.getId().setCodigoAreaTrabajo(articuloImportadoVOClon.getCodigoAreaTrabajoDestino() != null 
					? articuloImportadoVOClon.getCodigoAreaTrabajoDestino() : articuloImportadoVOClon.getCodigoAreaTrabajoPedido());
			areaTrabajoDTODestino.setEstadoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);
			areaTrabajoDTODestino = this.dataGestor.findUnique(areaTrabajoDTODestino);
			if(areaTrabajoDTODestino == null){
				throw new SICException("No se pudo encontrar el \u00E1rea de trabajo ");
			}
			//verifica si el area de trabajo pedido es CD, bodega o local
			if(areaTrabajoDTODestino.getTipoAreaTrabajoValor().equals(CorporativoConstantes.TIPO_AREATRABAJO_BODEGA)){
				ArticuloLocalDTO articuloBodegaDTO = new ArticuloLocalDTO();
				articuloBodegaDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
				articuloBodegaDTO.getId().setCodigoLocal(areaTrabajoDTODestino.getId().getCodigoAreaTrabajo());
				articuloBodegaDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				if(CollectionUtils.isEmpty(articuloVO.getBaseDTO().getArticuloLocalCol())){
					articuloVO.getBaseDTO().setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
				}
				articuloVO.getBaseDTO().getArticuloLocalCol().add(articuloBodegaDTO);
			}else if(clasificacionDTO != null && areaTrabajoDTODestino.getTipoAreaTrabajoValor().equals(CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DISTRIBUCION)){
				//obtiene la subbodega de la clasificacion
				BodegaDTO bodegaDTO = new BodegaDTO();
				bodegaDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				bodegaDTO.getId().setCodigoBodega(clasificacionDTO.getCodigoBodega());
				bodegaDTO = this.dataGestor.findUnique(bodegaDTO);
				if(bodegaDTO == null){
					throw new SICException("No se pudo encontrar la subbodega " + clasificacionDTO.getCodigoBodega());
				}
				
				//obtiene la bodega
				AreaSublugarTrabajoDTO areaSublugarTrabajoDTO = new AreaSublugarTrabajoDTO();
				areaSublugarTrabajoDTO.getId().setCodigoCompania(articuloImportadoVOClon.getCodigoCompania());
				areaSublugarTrabajoDTO.getId().setCodigoAreaSublugarTrabajo(bodegaDTO.getCodigoAreaTrabajo());
				areaSublugarTrabajoDTO.setEstado(Boolean.TRUE);
				areaSublugarTrabajoDTO.setTipoRelacionValor(CorporativoConstantes.TIPO_RELACION_JERARQUIA_AREA_TRABAJO);
				Collection<Integer> areaTrabajoCd = new ArrayList<Integer>();
				areaTrabajoCd.add(areaTrabajoDTODestino.getId().getCodigoAreaTrabajo());
				areaSublugarTrabajoDTO.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
				areaSublugarTrabajoDTO.getCriteriaRestrictions().add(
						new BodegasEnCentroDistribucionRestriction(areaTrabajoCd, "id.codigoAreaTrabajo"));
				Collection<AreaSublugarTrabajoDTO> areaSublugarTrabajoDTOCol = this.dataGestor.findObjects(areaSublugarTrabajoDTO);
				if (CollectionUtils.isEmpty(areaSublugarTrabajoDTOCol)){ 
					throw new SICException("No se pudo encontrar la subbodega " + clasificacionDTO.getCodigoBodega() 
							+ " en el CD " + areaTrabajoDTODestino.getId().getCodigoAreaTrabajo());
				}
				areaSublugarTrabajoDTO = areaSublugarTrabajoDTOCol.iterator().next();
				
				ArticuloLocalDTO articuloBodegaDTO = new ArticuloLocalDTO();
				articuloBodegaDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
				articuloBodegaDTO.getId().setCodigoLocal(areaSublugarTrabajoDTO.getId().getCodigoAreaTrabajo());
				articuloBodegaDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				if(CollectionUtils.isEmpty(articuloVO.getBaseDTO().getArticuloLocalCol())){
					articuloVO.getBaseDTO().setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
				}
				articuloVO.getBaseDTO().getArticuloLocalCol().add(articuloBodegaDTO);
				articuloVO.setCodigoCompania(areaSublugarTrabajoDTO.getId().getCodigoCompania());
			}
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Error al validar y setear datos para alcance de articulo: {}", e);
			throw e;
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al validar y setear datos para alcance de articulo: {}", e);
			throw new SICException("Error al validar alcance del articulo: " + articuloImportadoVOClon.getCodigoBarras());
		}
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setArticuloGestor(IArticuloGestor articuloGestor) {
		this.articuloGestor = articuloGestor;
	}

	public void setArticuloUnidadManejoGestor(IArticuloUnidadManejoGestor articuloUnidadManejoGestor) {
		this.articuloUnidadManejoGestor = articuloUnidadManejoGestor;
	}

	public void setArticuloComercialGestor(IArticuloComercialGestor articuloComercialGestor) {
		this.articuloComercialGestor = articuloComercialGestor;
	}

	public void setArticuloAlcanceGestor(IArticuloAlcanceGestor articuloAlcanceGestor) {
		this.articuloAlcanceGestor = articuloAlcanceGestor;
	}

	public void setCalculoBusquedaArticuloGestor(ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor) {
		this.calculoBusquedaArticuloGestor = calculoBusquedaArticuloGestor;
	}

	public void setAccionArticuloProveedorGestor(IAccionArticuloProveedorGestor accionArticuloProveedorGestor) {
		this.accionArticuloProveedorGestor = accionArticuloProveedorGestor;
	}

	public void setCalculoDatosMarcaProveedorGestor(ICalculoDatosMarcaProveedorGestor calculoDatosMarcaProveedorGestor) {
		this.calculoDatosMarcaProveedorGestor = calculoDatosMarcaProveedorGestor;
	}

	public void setEstructuraComercialGestor(IEstructuraComercialGestor estructuraComercialGestor) {
		this.estructuraComercialGestor = estructuraComercialGestor;
	}

	public void setAlmacenamientoAuditoriaArticuloGestor(IAlmacenamientoAuditoriaArticuloGestor almacenamientoAuditoriaArticuloGestor) {
		this.almacenamientoAuditoriaArticuloGestor = almacenamientoAuditoriaArticuloGestor;
	}

	public void setArticuloProveedorImportacionGestor(IArticuloProveedorImportacionGestor articuloProveedorImportacionGestor) {
		this.articuloProveedorImportacionGestor = articuloProveedorImportacionGestor;
	}

	public void setArticuloNuevoImportadoDAO(IArticuloNuevoImportadoDAO articuloNuevoImportadoDAO) {
		this.articuloNuevoImportadoDAO = articuloNuevoImportadoDAO;
	}

	public void setLineaComercialDAO(ILineaComercialDAO lineaComercialDAO) {
		this.lineaComercialDAO = lineaComercialDAO;
	}

	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}
}