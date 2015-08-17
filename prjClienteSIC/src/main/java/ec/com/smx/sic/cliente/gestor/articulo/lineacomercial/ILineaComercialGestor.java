package ec.com.smx.sic.cliente.gestor.articulo.lineacomercial;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioLineaComercial;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioTipoMarca;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.VistaAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.id.AreaTrabajoID;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaFuncionarioTipoMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.ClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.LineaComercialVO;

/**
 * 
 * @author fcollaguazo
 *
 */
public interface ILineaComercialGestor {

	/**
	 * Crea la linea comercial
	 * @param lineaComercialDTO
	 * @throws SICException
	 */
	void crearLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException;
	
	/**
	 * Actualiza la linea comercial
	 * @param lineaComercialDTO
	 * @throws SICException
	 */
	void actualizarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException;

	/**
	 * Crea las clasificaciones de la linea comercial
	 * @param lineaComercialDTO
	 * @throws SICException
	 */
	void crearLineaComercialClasificacion(LineaComercialDTO lineaComercialDTO)throws SICException;
	
	/**
	 * Elimina toda la linea comercial
	 * @param lineaComercialDTO
	 * @throws SICException
	 */
	void eliminarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException;
	
	/**
	 * Elimina la clasificacion asignada a la linea comercial
	 * @param lineaComercialClasificacionCol
	 * @param lineaComercialDTO
	 * @param userId
	 * @throws SICException
	 */
	void eliminarLineaComercialClasificacion(Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol, LineaComercialDTO lineaComercialDTO, String userId)throws SICException;
	/**
	 * 
	 * @param lineaComercialFuncionarioCol
	 * @param lineaComercialDTO
	 * @param userId
	 * @throws SICException
	 */
	void eliminarLineaComercialFuncionarios(Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioCol,LineaComercialDTO lineaComercialDTO, String userId) throws SICException;
	/**
	 * Registra las lineas comerciales del funcionarios por tipo de marca
	 * @param lineaComercialDTO
	 * @throws SICException
	 */
	public void crearLineaComercialFuncionario(LineaComercialDTO lineaComercialDTO,Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioDTOs) throws SICException;
	
	/**
	 * 
	 * @param lineaComercialFuncionarioDTO
	 * @throws SICException
	 */
	public void crearFuncionarioTipoMarca(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException;
	/**
	 * Obtiene la lista de lineas comerciales
	 * @param lineaComercialVO
	 */
	public Collection<LineaComercialDTO> obtenerLineasComerciales(LineaComercialVO lineaComercialVO) throws SICException;
	
	/**
	 * Obtiene la lista de lineas comerciales del funcionario
	 * @param codigoCompania Codigo de la compania
	 * @param codigoLineaComercial Codigo de la linea comercial
	 * @param estado parametro para la busqueda
	 * @param restrictionMap Mapa con restricciones para aniadir a la consulta
	 */
	Collection<LineaComercialFuncionarioDTO> obtenerFuncionariosPorLineaComercial(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction>  restrictionMap) throws SICException;
	
	/**
	 * Obtiene la lista de lineas comerciales por funcionario
	 */
	public Collection<LineaComercialFuncionarioDTO> obtenerLineasComercialesPorFuncionario(Integer codigoCompania, String codigoFuncionario) throws SICException;
	/**
	 * Metodo que valida que el funcionario logeado tenga lineas comerciales para proceso de compra
	 * @author mgranda
	 * @param funcionarioDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarFuncionarioLineaComercial(FuncionarioDTO funcionarioDTO) throws SICException;
	
	/**
	 * Elimina el funcionario asignado a la linea comercial
	 * @param lineaComercialFuncionarioDTO
	 * @throws SICException
	 */
	void eliminarLineaComercialFuncionario(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException;
	
	/**
	 * Activa la linea comercial con sus clasificaciones y funcionarios
	 * @param lineaComercialDTO
	 * @throws SICException
	 */
	void activarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException;
	
	/**
	 * Inserta, activa e inactiva las marcas de linea comercial de un funcionario
	 * @param lineaComercialFuncionarioDTO
	 * @param marcasNuevas
	 * @throws Exception
	 */
	void asignarTiposMarca(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO, List<String> marcasNuevas)throws Exception;
	
	/**
	 * Permite reasignar las clasificaciones de una linea comercial a otra
	 * @param lineaComercialDTO
	 * @param lineaComercialClasificacionCol
	 * @throws SICException
	 */
	String reasignarClasificacionesLineaComercial (LineaComercialDTO lineaComercialDTO, Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol)throws SICException;
	
	/**
	 * Permite configurar las marcas de un funcionario por tipo de marca
	 * @param funcionarioTipoMarcaDTO
	 * @param marcasAsignadas
	 * @throws SICException
	 */
	void crearMarcasFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO, Collection<MarcaArticuloDTO> marcasAsignadas)throws SICException;
	
	/**
	 * Permite eliminar la marca del funcionario por el tipo de marca
	 * @param marcaFuncionarioTipoMarcaDTO
	 * @throws SICException
	 */
	void eliminarMarcaFuncionarioTipoMarca(MarcaFuncionarioTipoMarcaDTO marcaFuncionarioTipoMarcaDTO)throws SICException;
	
	/**
	 * Permite eliminar las marcas del funcionario por el tipo de marca
	 * @param marcaFuncionarioTipoMarcaCol
	 * @throws SICException
	 */
	void eliminarMarcaFuncionarioTipoMarca(Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol, String userId)throws SICException;
	
	/**
	 * Permite eliminar el tipo de marca del funcionario
	 * @param funcionarioTipoMarcaDTO
	 * @throws SICException
	 */
	void eliminarFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarcaDTO)throws SICException;
	
	/**
	 * Este metodo permite crear y validar clasificaciones solo puede estar en linea comercial de distinto tipo
	 * 
	 * @param userId
	 * @param lineaComercialDTO
	 * @return
	 */
	public Collection<LineaComercialClasificacionDTO> crearObtenerLineaComercialClasificacionAsignadas(String userId,LineaComercialDTO lineaComercialDTO)throws SICException;
	/**
	 * 
	 * @param codigoLineaComercial
	 * @param codigoLineaComercialFuncionario
	 * @return
	 * @throws SICException
	 */
	public Collection<LineaComercialClasificacionDTO> obtenerClasificacionesFuncionario(Long codigoLineaComercial, Long codigoLineaComercialFuncionario)throws SICException;
	 
	/**
	 * permite guardar LineaComercialFuncionarioClasificacion
	 * @param lineaComercialFuncionarioClasificacionDTOs
	 */
	public void guardarLineaComercialFuncionarioClasificacion(Collection<LineaComercialFuncionarioClasificacionDTO> lineaComercialFuncionarioClasificacionDTOs)throws SICException;
	
	/**
	 * Elimina la clasificacion especifica de la linea comercial del funcionario
	 * @param linComFunCl
	 * @throws SICException
	 */
	public void eliminarLineaComercialFuncionarioClasificacion(LineaComercialFuncionarioClasificacionDTO linComFunCl)throws SICException;
	/**
	 * Consulta los tipos de marca por funcionario
	 * @param funcionarioDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<InformacionFuncionarioTipoMarca> consultarFuncionarioTipoMarca(FuncionarioDTO funcionarioDTO) throws SICException;
	
	/**
	 * Consulta las lineas comercial del funcionario 
	 * @param funcionarioDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<InformacionFuncionarioLineaComercial> consultarFuncionarioLineasComerciales(FuncionarioDTO funcionarioDTO) throws SICException;
	
	/**
	 * A�ade una restriccion al pefil para no mostrar el perfil colaboradores
	 * @param searchDTO
	 * @throws SICException
	 */
	public void addCriterioRestriccionPerfilColaborador(SearchDTO searchDTO)throws SICException;
	
	/**
	 * Obtiene las areas de trabajo verificando si tiene perfiles atados o no
	 * @param areaTrabajoDTO, tiposAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaAreaTrabajoDTO> findAreasTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<String> tiposAreaTrabajo) throws SICException;
	/**
	 * Agrega una restriccion a la linea comercial para comparar el codigo de referencia
	 * @param searchDTO
	 */
	public void addCriterioRestriccionCodigoReferencia(LineaComercialDTO searchDTO);
	
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
	 * @return
	 * @throws SICException
	 */
	public Collection<ClienteImportacionDTO> consultarClienteImportacion()throws SICException;
	
	/**
	 * 
	 * @param linComDTO
	 * @param clienteImpDTO
	 * @param userID
	 * @throws SICException
	 */
	public void guardarClienteImportacionLineaComercial(LineaComercialDTO linComDTO,Collection<ClienteImportacionDTO> clienteImpDTOCol,Integer codigoCompania,String userID)throws SICException;
	
	/**
	 * 
	 * @param lineaComercialDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<LineaComercialClienteImportacionDTO> consultarLinComClienImp(LineaComercialDTO lineaComercialDTO)throws SICException;
	/**
	 * 
	 * @param linComCliImpDTOCol
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	public void actualizarLinComClienImp(Collection<LineaComercialClienteImportacionDTO> linComCliImpDTOCol,String estado,String userId)throws SICException;
	/**
	 * 
	 * @param codigoClienteImportacion
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public boolean validarClienImpLinComEstFilial(Long codigoClienteImportacion,Integer codigoCompania)throws SICException;
	/**
	 * 
	 * @param LineaComercialClasificacionDTO
	 * @return
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
	
}
