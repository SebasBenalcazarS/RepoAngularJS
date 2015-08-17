/**
 * 
 */
package ec.com.smx.sic.cliente.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

import javax.naming.Context;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.service.DataService;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.GrupoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.restricciones.ArticuloCodigoBarrasRestriction;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio;

/**
 * @author fmunoz
 * 
 */
public class ArticuloTest{

	public static Properties properties;
	@BeforeClass
	public static void init() {
		DOMConfigurator.configure("logging.xml");
		properties = new Properties();
		properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		properties.setProperty(Context.PROVIDER_URL, "localhost:1099");
	}

	@Test
	public void findArticuloLocal() {

		//Context ctx;
		try {
			//ctx = new InitialContext(properties);
			//System.out.println(ctx.lookup("max/maxArticuloS/remote"));
			//ArticuloS service = (ArticuloS)ctx.lookup("max/maxArticuloS/remote");
			ArticuloVO articuloVO = new ArticuloVO();
			articuloVO.setArticuloLocalDTO(new ArticuloLocalDTO());
			articuloVO.getArticuloLocalDTO().getId().setCodigoLocal(101);
			articuloVO.setBaseDTO(new ArticuloDTO());
			articuloVO.getBaseDTO().getId().setCodigoCompania(1);
			articuloVO.getBaseDTO().setCodigoClasificacion("1602");
			//articuloVO.setCollectionJoin("artBitCodBarCol");
			articuloVO.getBaseDTO().setArtBitCodBarCol(new HashSet<ArticuloBitacoraCodigoBarrasDTO>());
			articuloVO.getBaseDTO().getArtBitCodBarCol().add(new ArticuloBitacoraCodigoBarrasDTO());
			Collection<ArticuloDTO> resultados = SICFactory.getInstancia().articulo.getArticuloService().obtenerArticuloVenta(articuloVO.getBaseDTO());
			//Collection<ArticuloDTO> articuloCol = service.obtenerArticuloLocal(articuloVO);
			for (ArticuloDTO dto : resultados) {
				//Logeable.logSICV2.info("bit: {}, uniman: {}", dto.getArtBitCodBarCol().size(), dto.getArticuloUnidadManejoCol().size());
				
				Logeable.LOG_SICV2.info(
						"id: {}, codigoBarras: {}, descripcion: {}, PVP: {}, PVPimp: {}, BASE: {}, BASEimp: {}, BASE_NA: {}, BASEimp_NA: {}, CAJA: {}, CAJAimp: {}, CAJA_NA: {}, "
								+ "CAJAimp_NA: {}, MAY: {}, MAYimp: {}, MAY_NA: {}, MAYimp_NA: {}, tienePrecioCaja: {}, tienePrecioMayoreo: {}, tieneAlcance: {}",
						new Object[] {dto.getId().getCodigoArticulo(),
								dto.getCodigoBarrasActivo() != null ? dto.getCodigoBarrasActivo().getId().getCodigoBarras() : "",
								dto.getDescripcionArticulo(), dto.getPVP(), dto.getPVPImp(), dto.getPrecioBase(), dto.getPrecioBaseImp(),
								dto.getPrecioBaseNoAfi(), dto.getPrecioBaseNoAfiImp(), dto.getPrecioCaja(), dto.getPrecioCajaImp(),
								dto.getPrecioCajaNoAfi(), dto.getPrecioCajaNoAfiImp(), dto.getPrecioMayorista(), dto.getPrecioMayoristaImp(),
								dto.getPrecioMayoristaNoAfi(), dto.getPrecioMayoristaNoAfiImp(), dto.getHabilitadoPrecioCaja(), dto.getHabilitadoPrecioMayoreo()});
				/*
				 * for (ArticuloLocalDTO al : dto.getArticuloLocalCol()){ Logeable.logSICV2.info("local: {}, precioIVA: {}",al.getId().getCodigoLocal(),
				 * al.getPrecioArticuloAfiConIVA()); }
				 */
			}
			articuloVO = null;
			/*
			 * ArticuloPrecioDTO articuloPrecioDTO = new ArticuloPrecioDTO(); articuloPrecioDTO.getId().setCodigoCompania(1);
			 * articuloPrecioDTO.getId().setCodigoLocal(0); articuloPrecioDTO.getId().setCodigoArticulo("606");
			 * articuloPrecioDTO.getId().setCodigoTipoPrecio("BAS"); articuloPrecioDTO.setArticuloLocal(new ArticuloLocalDTO()); ArticuloPrecioDTO ap
			 * = dataService.findUnique(articuloPrecioDTO); if(ap!= null){
			 * Logeable.logSICV2.info("codigolocal: {}, estadolocal: {}",ap.getId().getCodigoLocal(), ap.getArticuloLocal().getEstadoArticuloLocal()); }
			 */

		}catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Logeable.LOG_SICV2.error(e.getMessage());
		}

	}
	
	@Test
	public void findUsuario(){

		//Context ctx=null;
		try {
			//ctx = new InitialContext(properties);
			ClasificacionDTO cls = new ClasificacionDTO();
			cls.getId().setCodigoCompania(1);
			cls.getId().setCodigoClasificacion("1602");
			cls.setSubClasificacionCol(new HashSet<SubClasificacionDTO>());
			cls.getSubClasificacionCol().add(new SubClasificacionDTO());
			DataService ds = (DataService)SICFactory.getInstancia().administracion.getDataService();
			Collection<ClasificacionDTO> clasiCol = ds.findObjects(cls);
			
			for(ClasificacionDTO dto : clasiCol){
				Logeable.LOG_SICV2.info("cla: {}", dto);
				for(SubClasificacionDTO sc : dto.getSubClasificacionCol()){
					Logeable.LOG_SICV2.info("  subcla: {}, ref {}", sc.getDescripcionSubClasificacion(), sc.getClasificacionDTO());
				}
			}
			
			ArticuloPrecioDTO ap = new ArticuloPrecioDTO();
			ap.getId().setCodigoCompania(1);
			ap.getId().setCodigoArticulo("108923");
			ap.getId().setCodigoTipoPrecio("BAS");
			ap.setArticulo(new ArticuloDTO());
			ap.getArticulo().setArticuloPrecioCol(new HashSet<ArticuloPrecioDTO>());
			ap.getArticulo().getArticuloPrecioCol().add(new ArticuloPrecioDTO());
			Collection<ArticuloPrecioDTO> apc = ds.findObjects(ap);
			
			for(ArticuloPrecioDTO dto : apc){
				Logeable.LOG_SICV2.info("tipoPrecio: {}", dto.getId().getCodigoTipoPrecio());
				for(ArticuloPrecioDTO dto2 : dto.getArticulo().getArticuloPrecioCol()){
					Logeable.LOG_SICV2.info("  art tipoPrecio: {}", dto2.getId().getCodigoTipoPrecio());
				}
			}
			
			/*System.out.println(ctx.lookup("corp/securityService/remote"));
			ISecurityService sec = (ISecurityService)FrameworkLocator.getInstancia().getSecurityService();
			UserDto user = sec.getUserById("FRM0");
			Logeable.logSICV2.info("userNom: {}", user.getUserCompleteName());*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Logeable.LOG_SICV2.error(e.getMessage());
			
		}

	}
	
	@Test
	public void findObjects(){
		try{
			DataService ds = (DataService)SICFactory.getInstancia().administracion.getDataService();
			/*ArticuloBitacoraCodigoBarrasDTO abcb = new ArticuloBitacoraCodigoBarrasDTO();
			abcb.getId().setCodigoCompania(1);
			abcb.getId().setCodigoArticulo("75005184");
			Collection<ArticuloBitacoraCodigoBarrasDTO> col = ds.findObjects(abcb);*/
			ArticuloDTO a = new ArticuloDTO();
			a.getId().setCodigoCompania(1);
			a.getId().setCodigoArticulo("75005184");
			ArticuloBitacoraCodigoBarrasDTO abcb = new ArticuloBitacoraCodigoBarrasDTO();
			abcb.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
			abcb.getCriteriaRestrictions().add(new ArticuloCodigoBarrasRestriction("fechaUltimaActualizacion"));
			a.setArtBitCodBarCol(new HashSet<ArticuloBitacoraCodigoBarrasDTO>());
			a.getArtBitCodBarCol().add(abcb);
			Collection<ArticuloDTO> col = ds.findObjects(a);
			Logeable.LOG_SICV2.info("col: {}", col.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	
	@Test
	public void crearTipoImpuesto(){
		try{
			DataService ds = (DataService)SICFactory.getInstancia().administracion.getDataService();
			GrupoImpuestoDTO gi = new GrupoImpuestoDTO();
			gi.getId().setCodigoCompania(1);
			gi.getId().setCodigoGrupoImpuesto("IVA");
			
			TipoImpuestoDTO ti = new TipoImpuestoDTO();
			ti.getId().setCodigoCompania(1);
			//ti.getId().setCodigoTipoImpuesto(14);
			ti.setCodigoGrupoImpuesto("IVA");
			ti.setNombreTipoImpuesto("ds");
			ti.setPorcentajeImpuesto(30d);
			ti.setDescripcionTipoImpuesto("sddsd");
			ti.setEstadoTipoImpuesto("1");
			/*ti.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
			ti.setIdUsuarioRegistro("FRM0");*/
			ti.setUserId("FRM0");
			/*GrupoImpuestoDTO gim = ds.findUnique(gi);
			ti.setGrupoImpuesto(gim);*/
			ds.transCreate(ti);
			/*TipoImpuestoArticuloDTO tim = ds.findUnique(ti);
			tim.setDescripcionTipoImpuesto("prueba");
			tim.setGrupoImpuesto(new GrupoImpuestoDTO());
			ds.transUpdate(tim);*/
			//Logeable.logSICV2.info("grupo: {}", tim.getGrupoImpuesto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	
	@Test
	public void obtenerPrecioArticulo(){
		try{
			IArticuloServicio ds = SICFactory.getInstancia().articulo.getArticuloService();
			
			ArticuloPrecioDTO a = new ArticuloPrecioDTO();
			a.getId().setCodigoCompania(1);
			a.getId().setCodigoArticulo("108923");
			Collection<ArticuloPrecioDTO> arpCol = ds.obtenerArticuloPrecio(a);
			for(ArticuloPrecioDTO dto : arpCol){
				Logeable.LOG_SICV2.info("descripcion: {}, tipoPrecio: {}, valor: {}, valor na: {}, valor imp: {}, valor na imp: {}",
						new Object[] {dto.getArticulo().getDescripcionArticulo(), dto.getId().getCodigoTipoPrecio(), dto.getValorActual(), dto.getValorActualNA(),
								dto.getValorActualImp(), dto.getValorActualNAImp()});
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	@Test
	public void registrarArticuloRegistroSanitario(){
		ArticuloRegistroSanitarioDTO ars;
		//CatalogoValorDTO restra = null;
		try{
			DataService ds = (DataService)SICFactory.getInstancia().administracion.getDataService();
			/*ars = new ArticuloRegistroSanitarioDTO();
			ars.getId().setCodigoCompania(1);
			ars.getId().setCodigoArticulo("75005184");
			ars.getId().setCodigoRegistroSanitario("238");
			ars.setArticuloDTO(new ArticuloDTO());
			ArticuloDefinicionArchivoDTO ada = new ArticuloDefinicionArchivoDTO();
			ada.setArticuloArchivo(new ArticuloArchivoDTO());
			ars.setArtDefArcCol(new HashSet<ArticuloDefinicionArchivoDTO>());
			ars.getArtDefArcCol().add(ada);
			ars = ds.findUnique(ars);
			Logeable.logSICV2.info("exige registro sanitario: {}", ars.getArticuloDTO().getAplicaRegistroSanitario());
			
			ars.setRegistroSanitario("asd76127");
			ars.setUserId("FRM0");*/
			//ArticuloRegistroSanitarioS service = (ArticuloRegistroSanitarioS)SICLocator.getInstancia().getArticuloRegistroSanitarioService();
			//service.registrarRegistroSanitarioArticulo(ars);
			
			/*ArticuloDTO art = new ArticuloDTO();
			art.getId().setCodigoCompania(1);
			art.getId().setCodigoArticulo("7750902016410");
			art.setArticuloInternetDTO(new ArticuloInternetDTO());
			//art.setArticuloPedidoEspecialDTO(new ArticuloPedidoEspecialDTO());
			art = ds.findUnique(art);
			//art.setArticuloInternetDTO(art.getArticuloInternetDTO() == null ? new ArticuloInternetDTO() : null);
			if(art.getArticuloInternetDTO() == null){
				Logeable.logSICV2.info("hola");
			}*/
			
			//CREACION TEMPORAL
			ars = new ArticuloRegistroSanitarioDTO();
			ars.getId().setCodigoCompania(1);
			ars.setEstadoRegistroSanitario("1");
			ars.setUserId("FRM0");
			ds.transCreate(ars);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}

}
