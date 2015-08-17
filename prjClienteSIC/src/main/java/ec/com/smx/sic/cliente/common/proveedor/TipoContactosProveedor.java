/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.smx.corpv2.common.enums.ContactEntityType;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author Luis Yacchirema
 * @author Mario Braganza
 * 
 */
public class TipoContactosProveedor {

	private final String codigoTipoContacto;
		
	public TipoContactosProveedor(String codigoTipoContacto){
		this.codigoTipoContacto = codigoTipoContacto;
	}
	
	/**
	 * @return the codigoTipoContacto
	 */
	public String getCodigoTipoContacto() {
		return codigoTipoContacto;
	}

	public static final TipoContactosProveedor CONTACTO_PRINCIPAL = new TipoContactosProveedor(CorporativoConstantes.CODIGO_TIPO_CONTACTO_PRINCIPAL){};
	public static final TipoContactosProveedor CONTACTO_PORTAL_B2B = new TipoContactosProveedor(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.codigo.tipo.contacto.b2b")){};
	public static final TipoContactosProveedor CONTACTO_OFICINA_EXTERIOR = new TipoContactosProveedor(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.codigo.tipo.contacto.oficina.exterior")){};
	
	
	/**
	 * 
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	public static ContactEntityType obtenerTipoContactoProveedor(IProveedor proveedor) throws SICException{
		
		TipoPersonaEntidad tipoPersonaProveedor;
		
		tipoPersonaProveedor = TipoPersonaEntidad.obtenerTipoPersonaEntidad(proveedor);
		if (tipoPersonaProveedor.esPersona()){
			return ContactEntityType.PERSON;
		} else if (tipoPersonaProveedor.esEmpresa()){
			return ContactEntityType.LOCATION;
		}
		
		throw new SICException("El proveedor no es persona ni empresa y no puede obtenerse el tipo de contacto");
		 
	}
	
}