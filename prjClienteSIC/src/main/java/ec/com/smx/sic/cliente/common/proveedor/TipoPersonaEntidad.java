/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.framework.common.enumeration.TipoEmpresaEnum;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author Mario Braganza
 *
 */
public enum TipoPersonaEntidad {

	PERSONA_NATURAL(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipoEntidad.persona.codigo")),
	PERSONA_JURIDICA(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipoEntidad.empresa.codigo")),
	PERSONA_JURIDICA_INTERNACIONAL(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipoEntidad.empresa.codigo")),
	SIN_DEFINIR(null),
	ERROR(null);
	
	
	private final String valorTipoPersonaEntidad;
	
	/**
	 * 
	 * @param tipoUsuario
	 */
	private TipoPersonaEntidad(String valorTipoPersonaEntidad){
		this.valorTipoPersonaEntidad = valorTipoPersonaEntidad;
	}
	

	

	/**
	 * @return the valorTipoPersonaProveedor
	 */
	public String getValorTipoPersonaEntidad() {
		return valorTipoPersonaEntidad;
	}


	/**
	 * 
	 * @param proveedorDTO
	 * @return
	 * @throws SICException
	 */
	public static TipoPersonaEntidad obtenerTipoPersonaEntidad(IBaseEntidad entidad){
		
		if (!SearchDTO.isLoaded(entidad)){
			return TipoPersonaEntidad.ERROR;
		}
		
		if (entidad.getCodigoPersona() == null){
			if (entidad.getCodigoLocalizacionProveedor() != null){
				return TipoPersonaEntidad.PERSONA_JURIDICA;
			} 
			return TipoPersonaEntidad.SIN_DEFINIR;

		} else {
			if (entidad.getCodigoLocalizacionProveedor() != null){
				return TipoPersonaEntidad.ERROR;
			} 

			return TipoPersonaEntidad.PERSONA_NATURAL;
		}
	}
	
	/**
	 * 
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	public static Long obtenerCodigoEntidad(IBaseEntidad entidad) {
		TipoPersonaEntidad tipoPersonaProveedor;
		
		tipoPersonaProveedor = TipoPersonaEntidad.obtenerTipoPersonaEntidad(entidad);
		
		if (tipoPersonaProveedor.esPersona()){
			return entidad.getCodigoPersona();
		}
		else if (tipoPersonaProveedor.esEmpresa()){
			return entidad.getCodigoLocalizacionProveedor();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @param proveedor
	 * @param numeroDocumento
	 * @return
	 * @throws SICException
	 */
	public static TipoPersonaEntidad obtenerTipoPersonaEntidad(TipoPersonaEntidad tipoPersonaPorEntidad, String numeroDocumento){		
		return TipoPersonaEntidad.obtenerTipoPersonaEntidad(tipoPersonaPorEntidad, TipoPersonaEntidad.obtenerTipoPersonaEntidad(numeroDocumento));
	}
	
	
	/**
	 * 
	 * @param tipoPersonaPorProveedor
	 * @param tipoPersonaPorDocumento
	 * @return
	 */
	private static TipoPersonaEntidad obtenerTipoPersonaEntidad(TipoPersonaEntidad tipoPersonaPorEntidad, TipoPersonaEntidad tipoPersonaPorDocumento){
		if (tipoPersonaPorDocumento.compareTo(SIN_DEFINIR) == 0
				&& (tipoPersonaPorEntidad.compareTo(PERSONA_JURIDICA) == 0 || tipoPersonaPorEntidad.compareTo(PERSONA_NATURAL) == 0)){
			
			return PERSONA_JURIDICA_INTERNACIONAL;
			
		}
		
		if (tipoPersonaPorDocumento.compareTo(ERROR) == 0 || tipoPersonaPorEntidad.compareTo(ERROR) == 0){
			return ERROR;
		}
		
		//tiene prioridad la validacion por proveedor
		return tipoPersonaPorEntidad;
	}
	
	
	/**
	 * 
	 * @param tipoPersonaPorProveedor
	 * @param tipoEmpresa
	 * @return
	 */
	public static TipoPersonaEntidad obtenerTipoPersonaEntidad(TipoPersonaEntidad tipoPersonaPorEntidad, TipoEmpresaEnum tipoEmpresa){
		return TipoPersonaEntidad.obtenerTipoPersonaEntidad(tipoPersonaPorEntidad, TipoPersonaEntidad.obtenerTipoPersonaEntidad(tipoEmpresa));
	}
	
	
	/**
	 * 
	 * @param numeroDocumento
	 * @return
	 */
	public static TipoPersonaEntidad obtenerTipoPersonaEntidad(String numeroDocumento){
		return TipoPersonaEntidad.obtenerTipoPersonaEntidad(new ValidatorImpl().validateTipoRUC(numeroDocumento));
	}
	
	
	/**
	 * 
	 * @param tipoEmpresa
	 * @return
	 */
	public static TipoPersonaEntidad obtenerTipoPersonaEntidad(TipoEmpresaEnum tipoEmpresa){

		if (tipoEmpresa == null){
			return ERROR;
		}

		if (tipoEmpresa.compareTo(TipoEmpresaEnum.FICTICIA) == 0 || 
				tipoEmpresa.compareTo(TipoEmpresaEnum.PRIVADA) == 0 ||
				tipoEmpresa.compareTo(TipoEmpresaEnum.PUBLICA) == 0){

			return PERSONA_JURIDICA;
		}

		if (tipoEmpresa.compareTo(TipoEmpresaEnum.NATURAL) == 0){
			return PERSONA_NATURAL;
		}

		return SIN_DEFINIR;
	}
	
	
	/**
	 * 
	 * @param tipoPersonaProveedor
	 * @return
	 */
	public static String obtenerValorTipoDocumentoPorTipoPersonaEntidad(TipoPersonaEntidad tipoPersonaPorEntidad, String numeroDocumento){
		return TipoPersonaEntidad.obtenerValorTipoDocumentoPorTipoPersonaEntidad(TipoPersonaEntidad.obtenerTipoPersonaEntidad(tipoPersonaPorEntidad, numeroDocumento));
	}
	
	
	/**
	 * 
	 * @param tipoPersonaPorProveedor
	 * @param numeroDocumento
	 * @return
	 */
	public static String obtenerValorTipoDocumentoPorTipoPersonaEntidad(TipoPersonaEntidad tipoPersonaPorEntidad, TipoEmpresaEnum tipoEmpresa){
		return TipoPersonaEntidad.obtenerValorTipoDocumentoPorTipoPersonaEntidad(TipoPersonaEntidad.obtenerTipoPersonaEntidad(tipoPersonaPorEntidad, tipoEmpresa));
	}
	
	
	/**
	 * 
	 * @param tipoPersonaPorProveedor
	 * @param tipoPersonaPorDocumento
	 * @return
	 */
	private static String obtenerValorTipoDocumentoPorTipoPersonaEntidad(TipoPersonaEntidad tipoPersonaPorDocumento){
		
		String tipoDocumento;
		
		switch (tipoPersonaPorDocumento) {
			case PERSONA_NATURAL:
				tipoDocumento =  CorporativoConstantes.TIPO_DOCUMENTO_CEDULA;
				break;
	
			case PERSONA_JURIDICA:
				tipoDocumento = CorporativoConstantes.TIPO_DOCUMENTO_EMPRESA_RUC;
				break;
					
			default:
				tipoDocumento = CorporativoConstantes.TIPO_DOCUMENTO_EMPRESA_INTERNACIONAL;
		}
	
		return tipoDocumento;
	}
	
	/**
	 * 
	 * @param tipoPersonaEntidad
	 * @param tipoDocumento
	 * @return
	 */
	public static String transformarValorTipoDocumentoPorTipoPersonaEntidad(final TipoPersonaEntidad tipoPersonaEntidad, final String tipoDocumento){
		
		switch (tipoPersonaEntidad) {
		case PERSONA_NATURAL:
			if ( CorporativoConstantes.TIPO_DOCUMENTO_CEDULA.equals(tipoDocumento) || 
					CorporativoConstantes.TIPO_DOCUMENTO_EMPRESA_RUC.equals(tipoDocumento) )
				return CorporativoConstantes.TIPO_DOCUMENTO_EMPRESA_RUC;
			else
				return CorporativoConstantes.TIPO_DOCUMENTO_EMPRESA_INTERNACIONAL;
		case PERSONA_JURIDICA:
			if ( CorporativoConstantes.TIPO_DOCUMENTO_EMPRESA_INTERNACIONAL.equals(tipoDocumento)
					|| CorporativoConstantes.TIPO_DOCUMENTO_EMPRESA_RUC.equals(tipoDocumento) )
				return tipoDocumento;
			else
				return CorporativoConstantes.TIPO_DOCUMENTO_EMPRESA_RUC;

		default:
			return null;
		}
	}
	
	
	/**
	 * 
	 * @param tipoPersonaProveedor
	 * @return
	 */
	public static Integer obtenerCodigoTipoDocumentoPorTipoPersonaEntidad(TipoPersonaEntidad tipoPersonaEntidad){
		if (tipoPersonaEntidad != null){
			
			if (tipoPersonaEntidad.esPersona()){
				return TiposCatalogoConstantes.TIPO_DOCUMENTO_PERSONA;
			}
			
			if (tipoPersonaEntidad.esEmpresa()){
				return TiposCatalogoConstantes.TIPO_DOCUMENTO_EMPRESA;
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean esPersona(){
		return PERSONA_NATURAL.compareTo(this) == 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean esEmpresa(){
		return PERSONA_JURIDICA.compareTo(this) == 0 
			|| PERSONA_JURIDICA_INTERNACIONAL.compareTo(this) == 0;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Boolean esPersonaNaturalOJuridica(){
		return this.esPersona() || this.esEmpresa();
	}
	
	
	/**
	 * 
	 * @param baseEntidad
	 * @return
	 */
	public Boolean existenDatosPersona(IBaseEntidad baseEntidad){
		return this.esPersona() && SearchDTO.isLoaded(baseEntidad.getPersona()); 
	}
	
	/**
	 * 
	 * @param baseEntidad
	 * @return
	 */
	public Boolean existenDatosLocalizacion(IBaseEntidad baseEntidad){
		return this.esEmpresa() && SearchDTO.isLoaded(baseEntidad.getLocalizacion());
	}
}
