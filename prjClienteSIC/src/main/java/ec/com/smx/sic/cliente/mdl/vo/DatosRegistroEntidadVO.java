/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.corpv2.dto.ContactoPersonaLocalizacionRelacionadoDTO;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionEntidad;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class DatosRegistroEntidadVO<RESULTADO_VALIDACION extends ResultadoValidacionEntidad<? extends IBaseEntidad>, VO extends EntidadVO<? extends IBaseEntidad>> implements Serializable {
	
	private VO entidadVO;
	private RESULTADO_VALIDACION resultadoValidacionEntidad;
	private DatoContactoPersonaLocalizacionDTO datoContactoPersonaLocalizacion;
	private DatoContactoPersonaLocalizacionDTO datoContactoPersonaLocalizacionInicial;
	private Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados;
	private Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionadosInicial;
	private Collection<ContactoPersonaLocalizacionRelacionadoDTO> contactosRelacionadosProveedorOficinaExterior;
	
	
	/**
	 * 
	 * @param entidad
	 * @param resultadoValidacionEntidad
	 */
	public DatosRegistroEntidadVO(VO entidadVO, RESULTADO_VALIDACION resultadoValidacionEntidad){
		this.entidadVO = entidadVO;
		this.resultadoValidacionEntidad = resultadoValidacionEntidad;
	}
	
	
	/**
	 * 
	 * @param datosRegistroProveedorVO
	 * @return
	 */
	public static Boolean isEmpty(DatosRegistroEntidadVO<?, ?> datosRegistroProveedorVO){
		return datosRegistroProveedorVO == null
			|| datosRegistroProveedorVO.getEntidadVO() == null
			|| datosRegistroProveedorVO.getResultadoValidacionEntidad() == null;
	}
	
	
	/**
	 * @return the entidad
	 */
	public VO getEntidadVO() {
		return entidadVO;
	}
	/**
	 * @param entidad the entidad to set
	 */
	public void setEntidadVO(VO entidadVO) {
		this.entidadVO = entidadVO;
	}
	/**
	 * @return the resultadoValidacionEntidad
	 */
	public RESULTADO_VALIDACION getResultadoValidacionEntidad() {
		return resultadoValidacionEntidad;
	}
	/**
	 * @param resultadoValidacionEntidad the resultadoValidacionEntidad to set
	 */
	public void setResultadoValidacionEntidad(
			RESULTADO_VALIDACION resultadoValidacionEntidad) {
		this.resultadoValidacionEntidad = resultadoValidacionEntidad;
	}
	/**
	 * @return the datoContactoPersonaLocalizacion
	 */
	public DatoContactoPersonaLocalizacionDTO getDatoContactoPersonaLocalizacion() {
		return datoContactoPersonaLocalizacion;
	}
	/**
	 * @param datoContactoPersonaLocalizacion the datoContactoPersonaLocalizacion to set
	 */
	public void setDatoContactoPersonaLocalizacion(
			DatoContactoPersonaLocalizacionDTO datoContactoPersonaLocalizacion) {
		this.datoContactoPersonaLocalizacion = datoContactoPersonaLocalizacion;
	}
	/**
	 * @return the datoContactoPersonaLocalizacionInicial
	 */
	public DatoContactoPersonaLocalizacionDTO getDatoContactoPersonaLocalizacionInicial() {
		return datoContactoPersonaLocalizacionInicial;
	}
	/**
	 * @param datoContactoPersonaLocalizacionInicial the datoContactoPersonaLocalizacionInicial to set
	 */
	public void setDatoContactoPersonaLocalizacionInicial(
			DatoContactoPersonaLocalizacionDTO datoContactoPersonaLocalizacionInicial) {
		this.datoContactoPersonaLocalizacionInicial = datoContactoPersonaLocalizacionInicial;
	}
	/**
	 * @return the contactosRelacionados
	 */
	public Collection<DatoContactoPersonaLocalizacionDTO> getContactosRelacionados() {
		return contactosRelacionados;
	}
	/**
	 * @param contactosRelacionados the contactosRelacionados to set
	 */
	public void setContactosRelacionados(
			Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados) {
		this.contactosRelacionados = contactosRelacionados;
	}
	/**
	 * @return the contactosRelacionadosInicial
	 */
	public Collection<DatoContactoPersonaLocalizacionDTO> getContactosRelacionadosInicial() {
		return contactosRelacionadosInicial;
	}
	/**
	 * @param contactosRelacionadosInicial the contactosRelacionadosInicial to set
	 */
	public void setContactosRelacionadosInicial(
			Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionadosInicial) {
		this.contactosRelacionadosInicial = contactosRelacionadosInicial;
	}


	/**
	 * @return the contactosRelacionadosProveedorOficinaExterior
	 */
	public Collection<ContactoPersonaLocalizacionRelacionadoDTO> getContactosRelacionadosProveedorOficinaExterior() {
		return contactosRelacionadosProveedorOficinaExterior;
	}


	/**
	 * @param contactosRelacionadosProveedorOficinaExterior the contactosRelacionadosProveedorOficinaExterior to set
	 */
	public void setContactosRelacionadosProveedorOficinaExterior(
			Collection<ContactoPersonaLocalizacionRelacionadoDTO> contactosRelacionadosProveedorOficinaExterior) {
		this.contactosRelacionadosProveedorOficinaExterior = contactosRelacionadosProveedorOficinaExterior;
	}
}
