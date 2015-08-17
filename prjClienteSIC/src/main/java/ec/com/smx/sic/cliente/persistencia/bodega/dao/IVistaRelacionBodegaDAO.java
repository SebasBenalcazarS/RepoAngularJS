package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPerchasArticulosDTO;

public interface IVistaRelacionBodegaDAO {

	/**
	 * Busca las ubiciciones de las perchas de los articulos de una entrega
	 * 
	 * @param codigoEntrega Codigo de la entregaa de un proveedor
	 * @return Un Collection de VistaPerchasArticulosDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract Collection<VistaPerchasArticulosDTO> findPerchasArticulosPorProveedor(Long codigoEntrega) throws SICException;
	
	/**
	 * Busca la secciones relacionasa de una seccion de una area de trabajo
	 * 
	 * @param seccionDTO Una seccion de un area de trabajo
	 * @param tipoSeccionRelacion El tipo de relacion asociada a la seccion
	 * @return Un Collection de RelacionSeccionDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract Collection<RelacionSeccionDTO> findSeccionesRelacionadas(SeccionDTO seccionDTO, CatalogoValorDTO tipoSeccionRelacion) throws SICException;

}