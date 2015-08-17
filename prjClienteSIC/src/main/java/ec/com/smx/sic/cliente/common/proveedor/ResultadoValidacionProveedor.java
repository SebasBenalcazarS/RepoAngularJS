package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.smx.framework.common.enumeration.TipoEmpresaEnum;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedorCodigo.ResultadoValidacionRUCFinanciero;
import ec.com.smx.sic.cliente.common.proveedor.bean.InformacionDocumentoProveedorDuplicado;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;

@SuppressWarnings("serial")
public class ResultadoValidacionProveedor extends ResultadoValidacionEntidad<IProveedor> {
	
	private Integer codigoJDEProveedor;	
	private DatosProveedor proveedorFinanciero;
	private CodigoResultadoValidacionProveedor codigoValidacionRUC;
	private String tipoProveedor;
	
	//FirstObject: Proveedores corporativos, SecondObject: Proveeedor financieros
	private Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> informacionDocumentoProveedorDuplicado;
	private ResultadoValidacionRUCFinanciero resultadoValidacionRUCFinanciero;
	private Boolean existeProveedorSinRUC;
	private Boolean realizarRegistroNuevoProveedor;
	
	
	public ResultadoValidacionProveedor(){
		//
	}
	
	
	/**
	 * 
	 * @param tipoPersonaProveedor
	 * @param numeroDocumento
	 * @param nombreProveedor
	 * @param proveedor
	 * @param codigoValidacionJDE
	 */
	public ResultadoValidacionProveedor(Integer codigoJDEProveedor,
			TipoPersonaEntidad tipoPersonaEntidad,
			TipoEmpresaEnum tipoEmpresa,
			String numeroDocumento,
			String valorTipoDocumento,
			String nombreProveedor,
			IProveedor proveedor,
			DatosProveedor proveedorFinanciero,
			Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> informacionDocumentoProveedorDuplicado,
			CodigoResultadoValidacionProveedor codigoResultadoValidacionProveedor) {
		
		this.codigoJDEProveedor = codigoJDEProveedor;
		super.setTipoEmpresa(tipoEmpresa);
		super.setNumeroDocumento(numeroDocumento);
		super.setValorTipoDocumento(valorTipoDocumento);
		super.setEntidad(proveedor);
		this.proveedorFinanciero = proveedorFinanciero;
		super.setCodigoResultadoValidacionProveedor(codigoResultadoValidacionProveedor);
		super.setTipoPersonaEntidad(tipoPersonaEntidad);
		////this.nombreProveedor = nombreProveedor;
		super.setNombreEntidad(nombreProveedor);
		this.informacionDocumentoProveedorDuplicado = informacionDocumentoProveedorDuplicado;
	}
	
	
	/**
	 * 
	 * @param tipoPersonaProveedor
	 * @param tipoEmpresa
	 * @param numeroDocumento
	 * @param nombreProveedor
	 * @param proveedor
	 * @param proveedorFinanciero
	 * @param codigoValidacionJDE
	 * @param codigoValidacionRUC
	 */
	public ResultadoValidacionProveedor(Integer codigoJDEProveedor,
			TipoPersonaEntidad tipoPersonaEntidad,
			TipoEmpresaEnum tipoEmpresa,
			String numeroDocumento,
			String valorTipoDocumento,
			String nombreProveedor,
			IProveedor proveedor,
			DatosProveedor proveedorFinanciero,
			Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> informacionDocumentoProveedorDuplicado,
			CodigoResultadoValidacionProveedor codigoResultadoValidacionProveedor,
			CodigoResultadoValidacionProveedor codigoValidacionRUC) {
		
		this(codigoJDEProveedor, 
				tipoPersonaEntidad, 
				tipoEmpresa, 
				numeroDocumento, 
				valorTipoDocumento, 
				nombreProveedor, 
				proveedor, 
				proveedorFinanciero, 
				informacionDocumentoProveedorDuplicado,
				codigoResultadoValidacionProveedor);
		
		this.codigoValidacionRUC = codigoValidacionRUC;
	}
	
	/**
	 * 
	 * @param tipoPersonaProveedor
	 * @param tipoEmpresa
	 * @param numeroDocumento
	 */
	public ResultadoValidacionProveedor(Integer codigoJDEProveedor,
			TipoPersonaEntidad tipoPersonaEntidad,
			TipoEmpresaEnum tipoEmpresa,
			String numeroDocumento){
		
		this.codigoJDEProveedor = codigoJDEProveedor;
		super.setTipoPersonaEntidad(tipoPersonaEntidad);
		super.setTipoEmpresa(tipoEmpresa);
		super.setNumeroDocumento(numeroDocumento);
	}
	
	/**
	 * 
	 * @param tipoPersonaProveedor
	 * @param tipoEmpresa
	 * @param numeroDocumento
	 * @param nombreProveedor
	 * @param proveedor
	 * @param codigoValidacionJDE
	 */
	public ResultadoValidacionProveedor(Integer codigoJDEProveedor,
			TipoPersonaEntidad tipoPersonaEntidad,
			TipoEmpresaEnum tipoEmpresa,
			String numeroDocumento,
			String valorTipoDocumento,
			String nombreProveedor,
			IProveedor proveedor,
			Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> informacionDocumentoProveedorDuplicado,
			CodigoResultadoValidacionProveedor codigoValidacionJDE) {
		
		this(codigoJDEProveedor, 
				tipoPersonaEntidad, 
				tipoEmpresa, 
				numeroDocumento, 
				valorTipoDocumento, 
				nombreProveedor, 
				proveedor, 
				null,
				informacionDocumentoProveedorDuplicado,
				codigoValidacionJDE);
	}
	
	

	/**
	 * @return the proveedorFinanciero
	 */
	public DatosProveedor getProveedorFinanciero() {
		return proveedorFinanciero;
	}

	/**
	 * @param proveedorFinanciero the proveedorFinanciero to set
	 */
	public void setProveedorFinanciero(DatosProveedor proveedorFinanciero) {
		this.proveedorFinanciero = proveedorFinanciero;
	}



	/**
	 * @return the codigoValidacionRUC
	 */
	public CodigoResultadoValidacionProveedor getCodigoValidacionRUC() {
		return codigoValidacionRUC;
	}


	/**
	 * @param codigoValidacionRUC the codigoValidacionRUC to set
	 */
	public void setCodigoValidacionRUC(
			CodigoResultadoValidacionProveedor codigoValidacionRUC) {
		this.codigoValidacionRUC = codigoValidacionRUC;
	}


	/**
	 * @return the codigoJDEProveedor
	 */
	public Integer getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}


	/**
	 * @param codigoJDEProveedor the codigoJDEProveedor to set
	 */
	public void setCodigoJDEProveedor(Integer codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}


	


	/**
	 * @return the informacionDocumentoProveedorDuplicado
	 */
	public Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> getInformacionDocumentoProveedorDuplicado() {
		return informacionDocumentoProveedorDuplicado;
	}


	/**
	 * @param informacionDocumentoProveedorDuplicado the informacionDocumentoProveedorDuplicado to set
	 */
	public void setInformacionDocumentoProveedorDuplicado(
			Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> informacionDocumentoProveedorDuplicado) {
		this.informacionDocumentoProveedorDuplicado = informacionDocumentoProveedorDuplicado;
	}


	/**
	 * @return the resultadoValidacionRUCFinanciero
	 */
	public ResultadoValidacionRUCFinanciero getResultadoValidacionRUCFinanciero() {
		return resultadoValidacionRUCFinanciero;
	}


	/**
	 * @param resultadoValidacionRUCFinanciero the resultadoValidacionRUCFinanciero to set
	 */
	public void setResultadoValidacionRUCFinanciero(
			ResultadoValidacionRUCFinanciero resultadoValidacionRUCFinanciero) {
		this.resultadoValidacionRUCFinanciero = resultadoValidacionRUCFinanciero;
	}


	/**
	 * @return the existeProveedorSinRUC
	 */
	public Boolean getExisteProveedorSinRUC() {
		return existeProveedorSinRUC;
	}


	/**
	 * @param existeProveedorSinRUC the existeProveedorSinRUC to set
	 */
	public void setExisteProveedorSinRUC(Boolean existeProveedorSinRUC) {
		this.existeProveedorSinRUC = existeProveedorSinRUC;
	}


	/**
	 * @return the realizarRegistroNuevoProveedor
	 */
	public Boolean getRealizarRegistroNuevoProveedor() {
		return realizarRegistroNuevoProveedor;
	}


	/**
	 * @param realizarRegistroNuevoProveedor the realizarRegistroNuevoProveedor to set
	 */
	public void setRealizarRegistroNuevoProveedor(
			Boolean realizarRegistroNuevoProveedor) {
		this.realizarRegistroNuevoProveedor = realizarRegistroNuevoProveedor;
	}

	/**
	 * @return the tipoProveedor
	 */
	public String getTipoProveedor() {
		return tipoProveedor;
	}

	/**
	 * @param tipoProveedor the tipoProveedor to set
	 */
	public void setTipoProveedor(String tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}
}