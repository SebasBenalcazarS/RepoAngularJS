package ec.com.smx.sic.cliente.common.factory;

import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ADMINSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ALCANCESERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ALCANCE_NOSQL_SERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ARCHIVOSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_CALCULOSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_CATALOGOSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ESTCOMSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ETIQUETA;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_LINCOMSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_MASIVO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_MERCANCIASERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_PROMSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_REGSANSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_RELSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ROTULADOSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_SOLICITUDIMPRESION;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_USUARIO_AUTORIZACION;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_VALIDACIONSERVICIO;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.MARCA_ARTICULO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceNoSqlServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloArchivoServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloCalculoServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloEtiquetaServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloMasivoServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloMercanciaServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloPromocionServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloRegistroSanitarioServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloRelacionadoServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloRotuladoServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloSolicitudImpresionEtiquetasServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloValidacionServicio;
import ec.com.smx.sic.cliente.servicio.articulo.ICatalogoArticuloServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IEstructuraComercialServicio;
import ec.com.smx.sic.cliente.servicio.articulo.ILineaComercialServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IMarcaArticuloServicio;
import ec.com.smx.sic.cliente.servicio.articulo.IUsuarioAutorizacionServicio;

public final class ArticuloFactory extends SICSpringContextFactory{
	
	public IArticuloServicio getArticuloService() throws SICException {
		return (IArticuloServicio) getBean(ARTICULO_ADMINSERVICIO);
	}
	
	public IArticuloArchivoServicio getArticuloArchivoService() throws SICException {
		return (IArticuloArchivoServicio) getBean(ARTICULO_ARCHIVOSERVICIO);
	}
	
	public IEstructuraComercialServicio getEstructuraComercialService() throws SICException {
		return (IEstructuraComercialServicio) getBean(ARTICULO_ESTCOMSERVICIO);
	}
	
	public ICatalogoArticuloServicio getCatalogoArticuloService() throws SICException {
		return (ICatalogoArticuloServicio) getBean(ARTICULO_CATALOGOSERVICIO);
	}
	
	public IArticuloRegistroSanitarioServicio getArticuloRegistroSanitarioService() throws SICException {
		return (IArticuloRegistroSanitarioServicio) getBean(ARTICULO_REGSANSERVICIO);
	}
		
	public IArticuloCalculoServicio getArticuloCalculoService() throws SICException {
		return (IArticuloCalculoServicio) getBean(ARTICULO_CALCULOSERVICIO);
	}
	
	public IArticuloRotuladoServicio getArticuloRotuladoServicio() throws SICException {
		return (IArticuloRotuladoServicio) getBean(ARTICULO_ROTULADOSERVICIO);
	}
	
	public IArticuloValidacionServicio getArticuloValidacionServicio() throws SICException {
		return (IArticuloValidacionServicio) getBean(ARTICULO_VALIDACIONSERVICIO);
	}
	
	public IArticuloAlcanceServicio getArticuloAlcanceServicio() throws SICException {
		return (IArticuloAlcanceServicio) getBean(ARTICULO_ALCANCESERVICIO);
	}
	
	public ILineaComercialServicio getLineaComercialServicio() throws SICException {
		return (ILineaComercialServicio) getBean(ARTICULO_LINCOMSERVICIO);
	}
	
	public IArticuloPromocionServicio getArticuloPromocionServicio() throws SICException {
		return (IArticuloPromocionServicio) getBean(ARTICULO_PROMSERVICIO);
	}
	
	public IArticuloRelacionadoServicio getArticuloRelacionadoServicio() throws SICException {
		return (IArticuloRelacionadoServicio) getBean(ARTICULO_RELSERVICIO);
	}
	
	public IUsuarioAutorizacionServicio getUsuarioAutorizacionServicio() throws SICException {
		return (IUsuarioAutorizacionServicio) getBean(ARTICULO_USUARIO_AUTORIZACION);
	}
	
	public IArticuloSolicitudImpresionEtiquetasServicio getArticuloSolicitudImpresionServicio() throws SICException {
		return (IArticuloSolicitudImpresionEtiquetasServicio) getBean(ARTICULO_SOLICITUDIMPRESION);
	}
	
	/**
	 * SERVICIO MERCANCIAS ARTICULOS
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public IArticuloMercanciaServicio getArticuloMercanciaServicio() throws SICException {
		return (IArticuloMercanciaServicio) getBean(ARTICULO_MERCANCIASERVICIO);
	}
	
	
	/**
	 * SERVICIO ARTICULO PROCESOS MASIVOS
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public IArticuloMasivoServicio getArticuloMasivoServicio() throws SICException {
		return (IArticuloMasivoServicio) getBean(ARTICULO_MASIVO);
	}
	
	/**
	 * Servicio articulo por Etiqueta
	 * @return
	 * @throws SICException
	 * @author dbravo
	 */
	public IArticuloEtiquetaServicio getArticuloEtiquetaServicio() throws SICException {
		return (IArticuloEtiquetaServicio) getBean(ARTICULO_ETIQUETA);
	}
	
	/**
	 * Servicio marca articulo
	 * @return
	 * @throws SICException
	 * @author dbravo
	 */
	public IMarcaArticuloServicio getMarcaArticuloServicio() throws SICException{
		return (IMarcaArticuloServicio) getBean(MARCA_ARTICULO);
	}
	
	/**
	 * Servicio articulo alcance noSql
	 * @return
	 * @throws SICException
	 */
	public IArticuloAlcanceNoSqlServicio getArticuloAlcanceNoSqlServicio () throws SICException {
		return (IArticuloAlcanceNoSqlServicio) getBean(ARTICULO_ALCANCE_NOSQL_SERVICIO);
	}
}
