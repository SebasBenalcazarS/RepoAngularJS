package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.VistaAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.id.AreaTrabajoID;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.ClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.LineaComercialVO;

public interface ILineaComercialDAO {

	/**
	 * Inactiva las sublineas comerciales que pertenecen a un padre
	 * @param userId
	 * @param codigoLineaComercial
	 */
	public abstract void eliminarSubLineasComerciales(String userId, Long codigoLineaComercial)throws SICException;

	/**
	 * Inactivar la clasificacion de las sublineas comerciales
	 * @param userId
	 * @param lineaComercialPadre
	 * @param codigoClasificacion
	 * @throws SICException
	 */
	public abstract void eliminarClasificacionSubLineasComerciales(String userId, LineaComercialDTO lineaComercialPadre, String codigoClasificacion)throws SICException;
	
	/**
	 * Elimina la clasificacion de la linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @param codigoClasificacion
	 * @throws SICException
	 */
	public abstract void eliminarClasificacionLineaComercial(String userId, Long codigoLineaComercial, String codigoClasificacion)throws SICException;
	
	/**
	 * Inactiva las clasificaciones de las sublineas comerciales
	 * @param userId
	 * @param subLineas
	 */
	public abstract void eliminarClasificacionesSubLineasComerciales(String userId, Collection<LineaComercialDTO> subLineas)throws SICException;
	
	/**
	 * Inactivo las clasificaciones de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	public abstract void eliminarClasificacionesLineaComercial(String userId, Long codigoLineaComercial)throws SICException;
	
	/**
	 * Elimina la linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	public abstract void eliminarLineaComercial(String userId, Long codigoLineaComercial)throws SICException;
	
	/**
	 * Elimina el funcionario asignado a la linea comercial
	 * @param lineaComercialFuncionarioDTO
	 * @throws SICException
	 */
	public abstract void eliminarFuncionarioLineaComercial(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException;
	
	/**
	 * Activa las clasificaciones de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @param lineaComercialClasificacionCol
	 * @param estado
	 * @throws SICException
	 */
	public abstract void activarInactivarClasificacionesLineaComercial(String userId, Long codigoLineaComercial,Long codigoLineaComercialCambio, Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol, String estado)throws SICException;
	
	/**
	 * Activa las clasificaciones de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	public abstract void activarClasificacionesLineaComercial(String userId, Long codigoLineaComercial)throws SICException;
	
	/**
	 * Activa los funcionario de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	public abstract void activarFuncionariosLineaComercial(String userId, Long codigoLineaComercial)throws SICException;
	
	/**
	 * Elimina los funcionarios de las sublineas comerciales
	 * @param subLineas
	 */
	public void eliminarFuncionariosSubLineasComerciales(String userId, Collection<LineaComercialDTO> subLineas)throws SICException;
	
	/**
	 * Inactiva los funcionario de la linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 */
	public void eliminarFuncionariosLineaComercial(String userId, Long codigoLineaComercial)throws SICException;
	
	/**
	 * Actualiza el establecimiento de las sublineas comerciales
	 * @param userId
	 * @param codigoLineaComercial
	 * @param codigoEstablecimiento
	 * @throws SICException
	 */
	public void actualizarEstablecimientoSubLineasComerciales(String userId, Long codigoLineaComercial, Integer codigoEstablecimiento,String valorTipoLineaComercial, Integer codigoTipoLineaComercial)throws SICException;
	
	/**
	 * Activar las Clasificaciones de las Divisiones
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	public void activarClasificacionesDivision(String userId, Long codigoLineaComercial, Collection<ClasificacionDTO> clasificacionCol)throws SICException;
	
	/**
	 * Activa las Clasificaciones de los Departamentos
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	public void activarClasificacionesDepartamento(String userId, Long codigoLineaComercial, Collection<ClasificacionDTO> clasificacionCol)throws SICException;
	/**
	 * Activa las clasificaciones
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	public  void activarClasificaciones(String userId, Long codigoLineaComercial, Collection<String> clasificacionCol)throws SICException;
	
	/**
	 * consultarLineaComercialClasificacionAsignacionMasiva
	 * permite consultar las LineaComercialClasificacion
	 * de una asignacion
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	public  Collection<LineaComercialClasificacionDTO> consultarLineaComercialClasificacionAsignacionMasivaNoIngresar(String codigoClasificacion,String nivelClasificacion,String valorTipoLineaComercial,String codigoLinCom)throws SICException;
	
	/**
	 * Permite obtener las LineaComercialClasificacionDTO
	 * que no se an asignado a un funcionario
	 * en especifico
	 * @throws SICException
	 */
	public Collection<LineaComercialClasificacionDTO> consultarClaificacionesFuncionario(Long codigoLineaComercial, Long codigoLineaComercialFuncionario)throws SICException;
	
	/**
	 * 
	 * @param hibernateHLineaComercialClasificacion
	 * @throws SICException
	 */
	public void setHibernateHLineaComercialClasificacion(IHibernateH<LineaComercialClasificacionDTO> hibernateHLineaComercialClasificacion)throws SICException;
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IHibernateH<LineaComercialClasificacionDTO> getHibernateHLineaComercialClasificacion()throws SICException;
	
	/**
	 * 
	 * @param codigoClasificacion
	 * @param nivelClasificacion
	 * @param valorTipoLineaComercial
	 * @throws SICException
	 */
	public Collection<String> consultarLineaComercialClasificacionAsignacionMasivaIngresar(String codigoClasificacion,String nivelClasificacion,String valorTipoLineaComercial,Long codigoLinPad,Long codigoLinCom)throws SICException;
	
	/**
	 * Activa las clasificaciones asignadas a un funcionario en caso de que se encuentren desactivadas
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	public void activarClasificacionesFuncionario(String userId, Long codigoLineaComercial)throws SICException;
	
	/**
	 * Consulta las areas de trabajo verificando si tiene perfiles atados al area de trabajo
	 * @param areaTrabajoDTO, tiposAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaAreaTrabajoDTO> findAreasTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<String> tiposAreaTrabajo)throws SICException;
	
	/**
	 * @param codigoLineaComercial
	 * @return
	 * @throws SICException
	 * @autor aecaiza
	 */
	public Collection<Integer> consultarAreaTrabajoPorFuncionario(Collection<Integer> listaCodigoReferencia, String tipoAreaTrabajoValor, Integer tipoAreaTrabajoTIC, String codigoFuncionario) throws SICException;
	
	/**
	 * Permite buscar los perfiles de funcionarios
	 * @param areaTrabajoID
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaAreaTrabajoPerfilDTO> findAreasTrabajoPerfil(AreaTrabajoID areaTrabajoID)throws SICException;
	
	/**
	 * Permite consultar los perfiles que se omitiran para la linea comercial
	 * @return
	 * @throws SICException
	 */
	public  Collection<String> buscarProcesoPerfil()throws SICException;
	/**
	 * 
	 * @param lineaComercialVO
	 * @return
	 * @throws SICException
	 */
	public Collection<LineaComercialDTO> buscarLineaComercial(LineaComercialVO lineaComercialVO)throws SICException;
	
	/**
	 * Obtiene la lista de lineas comerciales del funcionario
	 * @param codigoCompania Codigo de la compania
	 * @param codigoLineaComercial Codigo de la linea comercial
	 * @param estado Estado como parametro de busqueda
	 * @param restrictionMap Mapa con restricciones para aniadir a la consulta
	 */
	public Collection<LineaComercialFuncionarioDTO> obtenerFuncionariosPorLineaComercial(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction> restrictionMap)throws SICException;
	
	/**
	 * @param lineaComercialVO
	 * @return
	 * @throws SICException
	 */
	public Collection<LineaComercialFuncionarioDTO> obtenerLineaComercialPorFuncionario(Integer codigoCompania, String codigoFuncionario)throws SICException;
	/**
	 * 
	 * @param lineaComercialDTO
	 * @throws SICException
	 */
	public void actualizarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException;
	
	/**
	 * @return
	 * @throws SICException
	 */
	public Collection<ClienteImportacionDTO> consultarClienteImportacion()throws SICException;
	
	/**
	 * 
	 * @param linComCliImpDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<LineaComercialClienteImportacionDTO> consultarLinComClienImp(LineaComercialClienteImportacionDTO linComCliImpDTO)throws SICException;
	
	/**
	 * 
	 * @param lineaComercialClasificacionDTO
	 * @throws SICException
	 */
	public Collection<LineaComercialClasificacionDTO> buscarClasificacionesLinCom(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction>  restrictionMap)throws SICException;
	
	/**
	 * Permite contar el numero de clasificaciones asignadas a la linea comercial
	 * @param codigoCompania Codigo de la compania
	 * @param codigoLineaComercial Codigo de la linea comercial
	 * @return Numero de clasificaciones
	 * @throws SICException
	 */
	public Long contarLineaComercialClasificacion(Integer codigoCompania, Long codigoLineaComercial) throws SICException;
	
	/**
	 * 
	 * @param linComCliImpDTO
	 * @throws SICException
	 */
	public void actualizarLinComClienImp(LineaComercialClienteImportacionDTO linComCliImpDTO)throws SICException;
	
	/**
	 * 
	 * @param codigoClienteImportacion
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public boolean validarClienImpLinComEstFilial(Long codigoClienteImportacion,Integer codigoCompania)throws SICException;
	
	/**
	 * Permite agregar la informacion entre linea comercial - clasificacion y linea comercial - funcionario
	 * @param lineaComercialDTO Linea comercial a la que se esta asignando un funcionario
	 * @param lineaComercialFuncionarioDTO funcionario que se esta agregando a la linea comercial
	 * @throws SICException
	 */
	public void agregarLineaComercialFuncionarioClasificacion(LineaComercialDTO lineaComercialDTO, LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)
			throws SICException;
	
	/**
	 * Permite agregar la informacion entre linea comercial - clasificacion y linea comercial - funcionario
	 * @param codigoLineaComercial Codigo de la linea comercial que se se esta agregando una clasificacion
	 * @param userId Usuario que esta realizando las operaciones
	 * @param codigosClasificacion Codigos de las clasificaciones que se estan agregando a la linea comercial
	 * @throws SICException
	 */
	public void agregarLineaComercialFuncionarioClasificacion(Long codigoLineaComercial, String userId, Collection<String> codigosClasificacion) 
			throws SICException;
	
	/**
	 * Permite remover la informacion entre linea comercial - clasificacion y linea comercial - funcionario
	 * @param lineaComercialFuncionarioDTO funcionario que se esta removiendo a la linea comercial
	 * @throws SICException
	 */
	public void removerLineaComercialFuncionarioClasificacion(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)
			throws SICException;
	
	/**
	 * Permite remover la informacion entre linea comercial - clasificacion y linea comercial - funcionario
	 * @param codigosLineaComercial Cadena de codigos de las lineas comerciales de la que se remueve una clasificacion
	 * @param codigosClasificacion Lista de Codigos de la clasificacions que se estan removiendo
	 * @throws SICException
	 */
	public void removerLineaComercialFuncionarioClasificacion(String codigosLineaComercial, Collection<String> codigosClasificacion)throws SICException;
}