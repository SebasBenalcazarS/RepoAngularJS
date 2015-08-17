package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;

public interface IRelacionSeccionDAO {

	/**
	 * Permite buscar las relaciones con ubciaciones virtuales de una ubicacion real
	 * @param detalleSeccionDTO
	 * @return
	 */
	public Collection<RelacionSeccionDTO> buscarRelacionUbicacionesVirtuales(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	
	/**
	 * Permite actualizar el estado de la relacion seccion
	 * @param codigoDetalleSeccionPadre
	 * @param codigoDetalleSeccion
	 * @param codigoCompania
	 * @param userID
	 * @param estado
	 * @throws SICException
	 */
	public void actualizarRelacionSeccion(Long codigoDetalleSeccionPadre,Long codigoDetalleSeccion,Integer codigoCompania,String userID,String estado)throws SICException;
	
	/**
	 * valida que el pasillo existe en una subnave
	 * @param subnave
	 * @param codigosDetalles
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Boolean validarPadreHijoUnico(String identificador, Collection<String> codigosDetalles,Integer codigoCompania,Integer codigoBodega,String valorTipoSeccionPadre,String valorTipoSeccionHijo, Long codigoDetalleSeccion,Integer codigoSubbodega)throws SICException;
	

	/**
	 * Metodo para obtener el rango de pasillos de la nave
	 * @param nave
	 * @return
	 * @throws SICException
	 */
	public String rangoPasillosPadre(DetalleSeccionDTO detalleSeccion,String valorTipoSeccion)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoPadre
	 * @param codigoAreaTrabajoHijo
	 * @param cod
	 * @param valorTipoSeccionPadre
	 * @param valorTipoSeccionHijo
	 * @return
	 * @throws SICException
	 */
	public Collection<RelacionSeccionDTO> buscarDetalleSeccion(Integer codigoCompania , Integer codigoAreaTrabajoPadre,
			Integer codigoAreaTrabajoHijo,String valorTipoSeccionPadre,String valorTipoSeccionHijo,
			String valorTipoSeccionHijoContar,Long codigoDetSeccPadre,Long codigoDetSeccHijo)throws SICException;
	
	/**
	 * 
	 * @param detseccPadre
	 * @param detseccHijo
	 * @return
	 * @throws SICException
	 */
	public Collection<RelacionSeccionDTO> buscarDetalleSeccionPasillosDisponibles(DetalleSeccionDTO detseccPadre, DetalleSeccionDTO detseccHijo)throws SICException;

	/**
	 * Metodo que busca un rango de pasillos con su nave y subnave
	 * @param pasilloDesde
	 * @param pasilloHasta
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<RelacionSeccionDTO> busquedaPasillos(Integer pasilloDesde, Integer pasilloHasta, Integer codigoAreaTrabajo, Integer codigoCompania, Integer firstResult, Integer maxResult)throws SICException;
	
	/**
	 * Metdodo para contar la busquedaPasillos
	 * @param pasilloDesde
	 * @param pasilloHasta
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Long contarBusquedaPasillos(Integer pasilloDesde, Integer pasilloHasta, Integer codigoAreaTrabajo, Integer codigoCompania)throws SICException;
	
	/**
	 * Metodo para consultar los pasillos que pertenecen a un anden
	 * @param codigoAreaTrabajo
	 * @param codigoCompania
	 * @param codigoAnden
	 * @return
	 * @throws SICException
	 */
	public Collection<RelacionSeccionDTO> busquedaPasillosAnden(Integer codigoAreaTrabajo, Integer codigoCompania, Long codigoAnden)throws SICException;
	
	/**
	 * Metodo para consultar una relacion detalle seccion en base al codigo
	 * @param codigoCompania
	 * @param codigoDetalleSeccionPadre
	 * @param codigoDetalleSeccion
	 * @return
	 * @throws SICException
	 */
	public RelacionSeccionDTO buscarRelacionSeccion(Integer codigoCompania, Long codigoDetalleSeccionPadre, Long codigoDetalleSeccion)throws SICException;
	
	/**
	 * Metodo para obtener las relaciones activas de los padres, por ejemplo si envio un codigoDetalleSeccion de una ubicacion obtendra
	 * las relaciones de sus padres como la relacion con la nave, rack y area
	 * @param detalleSeccion
	 * @return
	 * @throws SICException
	 */
	public Collection<RelacionSeccionDTO> obtenerRelacionesPadres(DetalleSeccionDTO detalleSeccion)throws SICException;

	/**
	 * Metodo para buscar los otros registros de detalle seccion de los andenes compartidos 
	 * @param andenes
	 * @return
	 * @throws SICException
	 */
	//public Collection<DetalleSeccionDTO> buscarDetalleSeccionDeAndenesCompartidos(Collection<DetalleSeccionDTO> lista)throws SICException;
}
