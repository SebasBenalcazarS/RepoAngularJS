/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.dto.ISearchDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.frameworkv2.multicompany.dto.SystemDto;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorB2BDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorFinancieroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorImportadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorNegociacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.auditoria.IAuditoriaBase;

/**
 * @author Mario Braganza
 *
 */
public interface IProveedor extends ISearchDTO, IAuditoriaBase, IBaseEntidad {

	ProveedorID getId();
	void setId(ProveedorID id);
	
	String getCodigoJDEProveedor();
	void setCodigoJDEProveedor(String codigoJDEProveedor);

	String getNombreProveedor();
	void setNombreProveedor(String nombreProveedor);
	
	String getRazonSocialProveedor();
	void setRazonSocialProveedor(String razonSocialProveedor);
	
	String getAbreviaturaNombreProveedor();
	void setAbreviaturaNombreProveedor(String abreviaturaNombreProveedor);
	
	void setCodigoLocalizacionProveedor(Long codigoLocalizacionProveedor);
	Long getCodigoLocalizacionProveedor();
	
	void setCodigoEmpresaProveedor(Long codigoEmpresaProveedor);
	Long getCodigoEmpresaProveedor();
	
	void setCodigoEntidadProveedor(Long codigoEntidadProveedor);
	Long getCodigoEntidadProveedor();
	
	void setValorTipoEntidadProveedor(String valorTipoEntidadProveedor);
	String getValorTipoEntidadProveedor();
	
	void setCodigoTipoEntidadProveedor(Integer codigoTipoEntidadProveedor);
	Integer getCodigoTipoEntidadProveedor();
	
	String getValortipoDocumento();
	void setValortipoDocumento(String valortipoDocumento);
	
	String getNumeroDocumentoProveedor();
	void setNumeroDocumentoProveedor(String numeroDocumentoProveedor);
	
	String getOrigenProveedor();
	void setOrigenProveedor(String origenProveedor);
	
	Integer getCodigoOrigenProveedor();
	void setCodigoOrigenProveedor(Integer codigoOrigenProveedor);
	
	Integer getCodigoCondicionProveedor();
	void setCodigoCondicionProveedor(Integer codigoCondicionProveedor);
	
	void setCondicionProveedor(String condicionProveedor);
	String getCondicionProveedor();
	
	String getCodigoSistemaOrigenProveedor();
	void setCodigoSistemaOrigenProveedor(String codigoSistemaOrigenProveedor);
	
	String getEstadoProveedor();
	void setEstadoProveedor(String estadoProveedor);
	
	String getUsuarioCreacion();
	void setUsuarioCreacion( String usuarioCreacion1 );

	java.sql.Timestamp getFechaCreacion();
	void setFechaCreacion( java.sql.Timestamp fechaCreacion1 );

	String getUsuarioActualizacion();
	void setUsuarioActualizacion( String usuarioActualizacion1 );

	java.sql.Timestamp getFechaUltimaActualizacion();
	void setFechaUltimaActualizacion( java.sql.Timestamp fechaUltimaActualizacion1 );
	
	UserDto getUsuarioActualizacionDTO();
	void setUsuarioActualizacionDTO(UserDto usuarioActualizacionDTO1 );

	UserDto getUsuarioCreacionDTO();
	void setUsuarioCreacionDTO(UserDto usuarioCreacionDTO1 );
	
	CatalogoValorDTO getCaracteristicaOrigenProveedor();
	void setCaracteristicaOrigenProveedor(CatalogoValorDTO caracteristicaOrigenProveedor);	

	ProveedorFinancieroDTO getProveedorFinanciero();
	void setProveedorFinanciero(ProveedorFinancieroDTO proveedorFinanciero);
	
	ProveedorB2BDTO getProveedorB2B();
	void setProveedorB2B(ProveedorB2BDTO proveedorB2B);
	
	ProveedorNegociacionDTO getProveedorNegociacion();
	void setProveedorNegociacion(ProveedorNegociacionDTO proveedorNegociacion);
	
	ProveedorComercialDTO getProveedorComercial();
	void setProveedorComercial(ProveedorComercialDTO proveedorComercial);
	Set<ProveedorOficinaExteriorDTO> getProveedorOficinaExteriorCol();
	void setProveedorOficinaExteriorCol(Set<ProveedorOficinaExteriorDTO> proveedorOficinaExteriorCol);
	
	Set<TipoProveedorDTO> getTiposProveedor();
	void setTiposProveedor(Set<TipoProveedorDTO> tiposProveedor);
	
	SystemDto getSistemaOrigenProveedor();
	void setSistemaOrigenProveedor(SystemDto sistemaOrigenProveedor);
	
	ProveedorImportadoDTO getProveedorImportado();
	void setProveedorImportado(ProveedorImportadoDTO proveedorImportado);
	
	String getUserId();
	void setUserId(String userId);
	
	CatalogoValorDTO getCaracteristicaCondicionProveedor();
	void setCaracteristicaCondicionProveedor(CatalogoValorDTO caracteristicaCondicionProveedor);
	
	DatoContactoPersonaLocalizacionDTO getContactoPrincipal();
	void setContactoPrincipal(DatoContactoPersonaLocalizacionDTO contactoPrincipal);
	
	List<CaracteristicaProveedorDTO> getCaracteristicasProveedor();
	void setCaracteristicasProveedor(List<CaracteristicaProveedorDTO> caracteristicasProveedor);
	
	Collection<ProveedorClasificacionDTO> getClasificacionesProveedor();
	void setClasificacionesProveedor(Collection<ProveedorClasificacionDTO> clasificacionesProveedor);
	
	/**
	 * @deprecated Metodo para compatibilidad de proyectos anteriores que usan la version
	 * anterior de Corporativo y Framework. En proyectos nuevos (que usan
	 * la version 2 de Corporativo y Framework, por ejemplo MAX) usar el metodo
	 * getPersona()
	 * 
	 */
	@Deprecated
	ec.com.smx.corporativo.admparamgeneral.dto.PersonaDTO getPersonaDTO();

	/**
	 * @deprecated Metodo para compatibilidad de proyectos anteriores que usan la version
	 * anterior de Corporativo y Framework. En proyectos nuevos (que usan
	 * la version 2 de Corporativo y Framework, por ejemplo MAX) usar el metodo
	 * setPersona(ec.com.smx.corpv2.dto.PersonaDTO persona)
	 * 
	 */
	@Deprecated
	void setPersonaDTO(ec.com.smx.corporativo.admparamgeneral.dto.PersonaDTO personaDTO);


	/**
	 * @deprecated Metodo para compatibilidad de proyectos anteriores que usan la version
	 * anterior de Corporativo y Framework. En proyectos nuevos (que usan
	 * la version 2 de Corporativo y Framework, por ejemplo MAX) usar el metodo
	 * getLocalizacion()
	 * 
	 */
	@Deprecated
	ec.com.smx.corporativo.gestionservicios.dto.LocalizacionDTO getLocalizacionDTO();

	/**
	 * @deprecated  Metodo para compatibilidad de proyectos anteriores que usan la version
	 * anterior de Corporativo y Framework. En proyectos nuevos (que usan
	 * la version 2 de Corporativo y Framework, por ejemplo MAX) usar el metodo
	 * setLocalizacion(ec.com.smx.corpv2.dto.LocalizacionDTO localizacion)
	 * 
	 */
	@Deprecated
	void setLocalizacionDTO(ec.com.smx.corporativo.gestionservicios.dto.LocalizacionDTO localizacionDTO);
	
}
