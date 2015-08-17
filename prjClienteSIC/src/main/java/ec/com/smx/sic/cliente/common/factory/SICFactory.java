package ec.com.smx.sic.cliente.common.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author cbarahona
 *
 */
public final class SICFactory  {

	private final BeanFactory applicationContext;
	
	private static final SICFactory INSTANCIA = new SICFactory();

	public final ArticuloFactory articulo;
	public final AdministracionFactory administracion;
	public final ProveedorFactory proveedor;
	public final SICOficinaExteriorFactory oficinaExterior;
	public final OrdenCompraFactory ordenCompra;
	public final PedidoAsistidoFactory pedidoAsistido;
	public final BodegaFactory bodega;
	public final RecargaCuponFactory recargaCupon;
	public final CambioPreciosFactory cambioPrecios;
	public final RecipientesFactory recipientes;
	public final ProduccionFactory produccion;
	public final ControlRutasFactory controlRutas;
	public final OfertasFactory ofertas;
	public final ConveniosFactory convenios;
	public final RecibidoNoContabilizadoFactory recibidoNoContabilizado;
	public final ProcesamientoVentasFactory procesamientoVentas;
	public final FruverFactory fruver;
	
	private SICFactory(){
		BeanFactoryLocator locator = ContextSingletonBeanFactoryLocator.getInstance(SICFactoryConstantes.BEANREF_CONTEXTPATH);
		applicationContext = locator.useBeanFactory(SICFactoryConstantes.APPLICATION_CONTEXT_BEAN).getFactory();
		articulo = applicationContext.getBean(ArticuloFactory.class);
		administracion = applicationContext.getBean(AdministracionFactory.class);
		proveedor = applicationContext.getBean(ProveedorFactory.class);
		oficinaExterior = applicationContext.getBean(SICOficinaExteriorFactory.class);
		ordenCompra = applicationContext.getBean(OrdenCompraFactory.class);
		pedidoAsistido = applicationContext.getBean(PedidoAsistidoFactory.class);
		bodega = applicationContext.getBean(BodegaFactory.class);
		recargaCupon = applicationContext.getBean(RecargaCuponFactory.class);
		cambioPrecios = applicationContext.getBean(CambioPreciosFactory.class);
		recipientes = applicationContext.getBean(RecipientesFactory.class);
		produccion = applicationContext.getBean(ProduccionFactory.class);
		controlRutas = applicationContext.getBean(ControlRutasFactory.class);
		ofertas = applicationContext.getBean(OfertasFactory.class);
		convenios = applicationContext.getBean(ConveniosFactory.class);
		recibidoNoContabilizado = applicationContext.getBean(RecibidoNoContabilizadoFactory.class);
		procesamientoVentas = applicationContext.getBean(ProcesamientoVentasFactory.class);
		fruver = applicationContext.getBean(FruverFactory.class);
	}
	
	public static SICFactory getInstancia() {
		return INSTANCIA;
	}

	/**
	 * 
	 * @param bean
	 * @return
	 * @throws SICException
	 */
	public static Object getBean(String bean) throws SICException {
		return INSTANCIA.applicationContext.getBean(bean);
	}
}
