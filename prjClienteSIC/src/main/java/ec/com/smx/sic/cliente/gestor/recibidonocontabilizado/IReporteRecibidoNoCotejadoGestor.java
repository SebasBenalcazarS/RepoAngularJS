package ec.com.smx.sic.cliente.gestor.recibidonocontabilizado;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;

public interface IReporteRecibidoNoCotejadoGestor {

	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteDiferencias(final Collection<ISearchTemplate> filtrosBusqueda, final VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteDiferenciasExcel(VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteTotales(final Collection<ISearchTemplate> filtrosBusqueda, final VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteTotalesExcel(VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteGeneral(final Collection<ISearchTemplate> filtrosBusqueda, final VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteGeneralExcel(VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteFechaEstado(final Collection<ISearchTemplate> filtrosBusqueda, final VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteFechaEstadoExcel(VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Duplex<Collection<CatalogoValorDTO>, Collection<CatalogoValorRelacionadoDTO>> obtenerEstadosNotaIngreso(final Integer codigoCatalogoTipo)throws SICException;
	
}
