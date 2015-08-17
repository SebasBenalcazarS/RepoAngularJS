/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import org.hibernate.criterion.Criterion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaDatosLogisticosVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author jdvasquez
 *
 */
public interface IEdicionDatosExtraDAO {

	public Long obtenerCantidadArticulosEdicion(ArticuloVO articuloVO, Criterion criterion) throws SICException;

	public Collection<ArticuloEdicionMasivaDatosLogisticosVO> obtenerArticulosEdicion(ArticuloVO articuloVO, Criterion criterion) throws SICException;

	public void actualizarDatosLogisticosUnidadManejoArticulo(ArticuloEdicionMasivaDatosLogisticosVO articulo) throws SICException;

	public void actualizarDatosLogisticosProcesoLogisticoArticulo(ArticuloEdicionMasivaDatosLogisticosVO articulo) throws SICException;

	public void desactivarRelacionArticuloRecipiente(ArticuloEdicionMasivaDatosLogisticosVO articulo) throws SICException;

	public void registrarDatosLogisticosProcesoLogisticoArticulo(ArticuloEdicionMasivaDatosLogisticosVO articulo) throws SICException;

	public ClasificacionDTO obtenerTipoDistricucionArticulo(Integer codigoCompania, String codigoArticulo) throws SICException;

	public void registrarDatosLogisticosProcesoLogisticoArticulo(ArticuloProcesoLogisticoDTO articulo) throws SICException;

}
