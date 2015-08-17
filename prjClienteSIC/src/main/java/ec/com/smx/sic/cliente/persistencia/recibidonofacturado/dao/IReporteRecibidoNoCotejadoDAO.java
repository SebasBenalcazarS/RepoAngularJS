package ec.com.smx.sic.cliente.persistencia.recibidonofacturado.dao;

import java.util.Collection;

import org.hibernate.criterion.Criterion;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;

public interface IReporteRecibidoNoCotejadoDAO {

	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteDiferencias(final Criterion criterion, final VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteTotales(final Criterion criterion, final VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteGeneral(final Criterion criterion, final VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<VistaRecibidoNoFacturadoDTO> obtenerReporteFechaEstado(final Criterion criterion, final VistaRecibidoNoFacturadoDTO plantillaBusqueda) throws SICException;
	
	Collection<CatalogoValorDTO> obtenerCatalogoValorPorTipo(final Integer codigoCatalogoTipo) throws SICException;
	
	Collection<CatalogoValorRelacionadoDTO> obtenerCatalogoValorRelacionado(final Integer codigoCatalogoTipo) throws SICException;
}
