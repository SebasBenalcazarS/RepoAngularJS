/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.recargacupon;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.vo.PersonaVO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ConvenioDTO;
import ec.com.smx.sic.cliente.mdl.vo.ConvenioVO;


/**
 * @author fvallejo
 *
 */
public interface IConvenioCuponServicio {
	
	/**
	 * Crea el convenio enviado
	 * @param convenioVO
	 * @throws SICException
	 */
	public void transCrearConvenio(ConvenioVO convenioVO) throws SICException;
	
	public void transEditConvenio(ConvenioVO convenioVO) throws SICException; 
	
	public PersonaVO transCrearCliente(String tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String genero, String estadoCivil, String userID);
	
	public void transAsignarCuponesCliente(ConvenioVO convenioVO) throws SICException;
	
	public Collection<ConvenioDTO> findConvenios(ConvenioVO convenioVO) throws SICException;

	public ConvenioVO findCatalogoConvenio () throws SICException;
	
	public Collection<Map<String, String>> findArticulo (Collection<String> codigoBarras, String valorTipoConvenio, String descripcionArticulo, Date fechaInicioVigencia, Date fechaFinVigencia, String codigoBarrasArticuloRelacionado, String descripcionArticuloRelacionado, String tituloCupon, String nombreLocal, String codigoLocal) throws SICException;
	
	public Collection<Map<String, String>> findCliente (Collection<String> numeroDocumento, String tipoDocumento, String primerNombre, String primerApellido, Integer min, Integer max) throws SICException;
	
	public Collection<Map<String, String>> findArticulosConvenio (Long secuencialConvenio) throws SICException;
	
	public Collection<Map<String, String>> findClientesConvenio (Long secuencialConvenio) throws SICException;
}
