/**
 * 
 */
package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.annotations.NoTransaction;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IAlmacenamientoArticuloAlcanceNoSqlGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IArticuloAlcanceMigracionNoSqlGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.calculo.ICalculoArticuloAlcanceNoSqlGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.ArticuloAreaTrabajoNoSqlDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.VistaArticuloLocalNoSqlDTO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceNoSqlServicio;

/**
 * @author wcaiza
 *
 */
public class ArticuloAlcanceNoSqlServicio implements IArticuloAlcanceNoSqlServicio {
	
	private IArticuloAlcanceMigracionNoSqlGestor articuloAlcanceMigracionNoSqlGestor;
	private ICalculoArticuloAlcanceNoSqlGestor calculoArticuloAlcanceNoSqlGestor;
	private IAlmacenamientoArticuloAlcanceNoSqlGestor almacenamientoArticuloAlcanceNoSqlGestor;

	
	
	
	@Override
	public List<ArticuloLocalDTO> findAlcanceAreaTrabajo(Integer codCompania, String tipAreTra, Integer codigoAreaTrabajo, Integer estado) throws SICException {
		return this.almacenamientoArticuloAlcanceNoSqlGestor.findAlcanceAreaTrabajo(codCompania, tipAreTra, codigoAreaTrabajo, estado);
	}

	public void setAlmacenamientoArticuloAlcanceNoSqlGestor(IAlmacenamientoArticuloAlcanceNoSqlGestor almacenamientoArticuloAlcanceNoSqlGestor) {
		this.almacenamientoArticuloAlcanceNoSqlGestor = almacenamientoArticuloAlcanceNoSqlGestor;
	}

	/**
	 * @param articuloAlcanceMigracionNoSqlGestor the articuloAlcanceMigracionNoSqlGestor to set
	 */
	public void setArticuloAlcanceMigracionNoSqlGestor(IArticuloAlcanceMigracionNoSqlGestor articuloAlcanceMigracionNoSqlGestor) {
		this.articuloAlcanceMigracionNoSqlGestor = articuloAlcanceMigracionNoSqlGestor;
	}
	
	/**
	 * @param calculoArticuloAlcanceNoSqlGestor the calculoArticuloAlcanceNoSqlGestor to set
	 */
	public void setCalculoArticuloAlcanceNoSqlGestor(ICalculoArticuloAlcanceNoSqlGestor calculoArticuloAlcanceNoSqlGestor) {
		this.calculoArticuloAlcanceNoSqlGestor = calculoArticuloAlcanceNoSqlGestor;
	}
	

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceNoSqlServicio#obtenerColCodigoLocalMigrar(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Collection<Integer> obtenerColCodigoLocalMigrar(Integer codigoCompania, String sufijoTabla) throws SICException {
		return this.articuloAlcanceMigracionNoSqlGestor.obtenerColCodigoLocalMigrar(codigoCompania, sufijoTabla);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceNoSqlServicio#migrarArticuloAlcanceDTONoSqlBatch(java.lang.Integer)
	 */
	@Override
	@NoTransaction
	public void migrarArticuloAlcanceDTONoSqlBatch(Integer codigoCompania, Integer codigoLocal, String sufijoTabla) throws SICException {
		this.articuloAlcanceMigracionNoSqlGestor.migrarArticuloAlcanceDTONoSql(codigoCompania, codigoLocal, sufijoTabla);
	}
	
	@Override
	public void findMigrarArticuloLocalDTOWriter(Integer codigoCompania, 
			Collection<VistaArticuloLocalNoSqlDTO> colVistaMigrarArticuloLocalDTO, String sufijoTabla) throws SICException {
		
		this.almacenamientoArticuloAlcanceNoSqlGestor.migrarArticuloLocal(codigoCompania, colVistaMigrarArticuloLocalDTO, sufijoTabla);
		
	}
	
	@Override
	public void findMigrarArticuloAreaTrabajoBitacoraWriter(Integer codigoCompania, 
			Collection<ArticuloAreaTrabajoBitacoraDTO> colArticuloAreaTrabajoBitacoraDTO, String sufijoTabla) throws SICException{
		
		this.almacenamientoArticuloAlcanceNoSqlGestor.migrarArticuloLocalBitacora(codigoCompania, colArticuloAreaTrabajoBitacoraDTO, sufijoTabla);
		
	}
	
	@Override
	public void findMigrarArticuloEstablecimientoWriter (Integer codigoCompania, 
			Collection<ArticuloEstablecimientoDTO> colArticuloEstablecimientoDTO, String sufijoTabla) throws SICException {
		this.almacenamientoArticuloAlcanceNoSqlGestor.migrarArticuloEstablecimiento(codigoCompania, colArticuloEstablecimientoDTO, sufijoTabla);
	}
	
//	/* (non-Javadoc)
//	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceNoSqlServicio#migrarArticuloAlcanceBitacoraNoSqlBatch(java.lang.Integer, java.lang.String)
//	 */
//	@Override
//	@NoTransaction
//	public void migrarArticuloAlcanceBitacoraNoSqlBatch(Integer codigoCompania, String sufijoTabla) throws SICException {
//		this.articuloAlcanceMigracionNoSqlGestor.migrarArticuloAlcanceBitacoraDTONoSql(codigoCompania, sufijoTabla);
//	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceNoSqlServicio#findExisteArticuloEnLocal(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public String findExisteArticuloEnLocal (Integer codigoCompania, Integer codigoLocal, String codigoArticulo) throws SICException {
		return this.calculoArticuloAlcanceNoSqlGestor.verificarExisteArticuloEnLocal(codigoCompania, codigoLocal, codigoArticulo);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceNoSqlServicio#obtenerEstadoArticuloLocal(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public Integer obtenerEstadoArticuloLocal(Integer codigoCompania, Integer codigoLocal, String codigoArticulo) throws SICException {
		return this.calculoArticuloAlcanceNoSqlGestor.verificarHayArticuloEnLocal(codigoCompania, codigoLocal, codigoArticulo);
	}
	
	@Override
	public Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerColArticuloAreaTrabajoBitacora(String sufijoTabla, Integer codigoCompania, Integer codigoLocal, String... colCodigoArticulo) throws SICException {
		return this.calculoArticuloAlcanceNoSqlGestor.obtenerColArticuloAreaTrabajoBitacora(sufijoTabla, codigoCompania, codigoLocal, colCodigoArticulo);
	}
	

	
	
	/*
	 * Servicios que se utilizan en el modulo de articulos
	 * 
	 * */
	
	@Override
	public void executeAlcanceArticulos(ArticuloAreaTrabajoNoSqlDTO ... artAreTraNoSql) throws SICException {
		this.almacenamientoArticuloAlcanceNoSqlGestor.executeAlcanceArticulos(artAreTraNoSql);
	}


	@Override
	public List<ArticuloLocalDTO> findAlcanceArticulo(Integer codCompania, String tipAreTra, String codigoArticulo, Integer estado) throws SICException {
		return this.almacenamientoArticuloAlcanceNoSqlGestor.findAlcanceArticulo(codCompania, tipAreTra, codigoArticulo, estado);
	}

//	/* (non-Javadoc)
//	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceNoSqlServicio#obtenerAreasTrabajoAsignadas(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO, java.lang.Boolean)
//	 */
//	@Override
//	public Collection<ArticuloLocalDTO> obtenerAreasTrabajoAsignadas(ArticuloDTO articuloDTO, Boolean validarEstado) throws SICException {
//		return this.calculoArticuloAlcanceNoSqlGestor.obtenerAreasTrabajoAsignadas(articuloDTO, validarEstado);
//	}

	@Override
	public Set<String> getArticulosPruebaAlcance() throws SICException {
		return this.almacenamientoArticuloAlcanceNoSqlGestor.getArticulosPruebaAlcance();
	}

	@Override
	public void copiarAlcances(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql,Integer codLocalOrigen) throws SICException {
		this.almacenamientoArticuloAlcanceNoSqlGestor.copiarAlcances(artAreTraNoSql,codLocalOrigen);
	}

	@Override
	public Long getNumRegistrosAlcanceEnAreaTrabajo(Integer codigoCompania, String tipAreaTrabajo, Integer codAreaTrabajo, String codArticulo) throws SICException {
		return new Long(this.almacenamientoArticuloAlcanceNoSqlGestor.getNumRegistrosAlcanceEnAreaTrabajo(codigoCompania, tipAreaTrabajo, codAreaTrabajo, codArticulo));
	}


	
	

}
