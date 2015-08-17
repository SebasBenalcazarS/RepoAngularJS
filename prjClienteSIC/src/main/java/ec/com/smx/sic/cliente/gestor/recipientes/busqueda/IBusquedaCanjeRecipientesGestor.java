package ec.com.smx.sic.cliente.gestor.recipientes.busqueda;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.TareaEntregaRecipientesTrasient;

/**
 * Metodos de busqueda para el canje de recipientes
 * @author amunoz
 *
 */
public interface IBusquedaCanjeRecipientesGestor {
	 /**
     * Retorna una coleccion  catalogo valor de todos los causales
     * @return
     */
    public Collection<CatalogoValorDTO> obtenerCausalesAjuste() throws SICException;
   
    
    /**
     * Busca los funcionarios que tengan el perfil de despachador
     * @param codigoCompania
     * @param profileId
     * @return
     * @throws SICException
     */
    public Collection<FuncionarioDTO> obtenerFuncionariosTarea(Integer codigoCompania,  Integer referenceCode, String usuario, String nombreUsuario) throws SICException;
    
    
    /**
     * Busca las tareas asignadas para el despacho de recipientes
     * @return
     */
	public Collection<TareaEntregaRecipientesTrasient> buscarTareasEstadoRecipientes();

}
