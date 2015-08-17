/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import static ec.com.smx.sic.cliente.common.proveedor.ProveedorConstantes.getInstancia;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;


import ec.com.smx.framework.common.util.StringUtil;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.proveedor.DatosProveedor;
import ec.com.smx.sic.cliente.common.proveedor.ProveedorConstantes;
import ec.com.smx.sic.cliente.common.proveedor.TipoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.bean.InformacionDocumentoProveedorDuplicado;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class IdentificadorJDEProveedorVO implements IIdentificadorProveedorVO {
	
	private Integer codigoCompania;
	private String tipoProveedor;
	private String codigoJDE;
	private String codigoJDEOriginal;
	private Integer codigoJDENumerico;
	private final TipoValidacionProveedor tipoValidacionProveedor;
	
	
	//TODO: temporal
	private DatosProveedor proveedorJDE;
	
	//TODO: temporal
	private Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> datosProveedorRUCDuplicado;
	
	
	/**
	 * 
	 * @param identificadorJDEProveedorVO
	 * @return
	 */
	public static final Boolean isNotEmptyIdentificadorJDEProveedor(IdentificadorJDEProveedorVO identificadorJDEProveedorVO){
		
		return identificadorJDEProveedorVO != null 
			&& identificadorJDEProveedorVO.getCodigoCompania() != null
			&& StringUtils.isNotEmpty(identificadorJDEProveedorVO.getCodigoJDE());
	}
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoJDE
	 */
	public IdentificadorJDEProveedorVO(Integer codigoCompania, String codigoJDE){
		Character rellenoCodigoProveedorPorDefecto;
		
		this.tipoValidacionProveedor = TipoValidacionProveedor.CODIGO;
		this.codigoCompania = codigoCompania;
		this.codigoJDEOriginal = codigoJDE;
		
		Logeable.LOG_SICV2.info("---------en identificadorProveedorVO");
		Logeable.LOG_SICV2.info("codigoJDE: {}, patron: {}, matches: {}", new Object[]{codigoJDE, 
				ProveedorConstantes.getInstancia().PATRON_CODIGO_PROVEEDOR, 
				codigoJDE.matches(ProveedorConstantes.getInstancia().PATRON_CODIGO_PROVEEDOR)});
		
		
		if (BooleanUtils.isTrue(SICProveedorMessages.getInstancia().getBoolean("ec.com.smx.max.rellenar.codigoProveedor"))){
			if (codigoJDE.matches(ProveedorConstantes.getInstancia().PATRON_CODIGO_PROVEEDOR)){
				this.codigoJDE = codigoJDE.replaceFirst(getInstancia().PATRON_PREFIJO_CODIGO_PROVEEDOR, getInstancia().RELLENO_PREFIJO_CODIGO_PROVEEDOR);
			} else {
				this.codigoJDE = codigoJDE;
			}
			
			rellenoCodigoProveedorPorDefecto = SICProveedorMessages.getInstancia().getCharacter("ec.com.smx.max.relleno.prefijo.defecto.codigoProveedor");
			if (rellenoCodigoProveedorPorDefecto != null && rellenoCodigoProveedorPorDefecto > Character.MIN_VALUE){
				
				this.codigoJDE = StringUtil.leftFiller(this.codigoJDE, 
						SICProveedorMessages.getInstancia().getInteger("ec.com.smx.max.longitud.defecto.codigoProveedor"), 
						rellenoCodigoProveedorPorDefecto);
			}
			
		}
		else {
			this.codigoJDE = codigoJDE;
		}
		
		this.codigoJDENumerico = Integer.valueOf(codigoJDE);
	}
	
	/**
	 * Constructor que recibe el tipo de proveedor
	 * 
	 * @author ivasquez
	 * @param codigoCompania
	 * @param codigoJDE
	 * @param tipoProveedor
	 */
	public IdentificadorJDEProveedorVO(Integer codigoCompania, String codigoJDE, String tipoProveedor) {
		Character rellenoCodigoProveedorPorDefecto;

		this.tipoValidacionProveedor = TipoValidacionProveedor.CODIGO;
		this.codigoCompania = codigoCompania;
		this.codigoJDEOriginal = codigoJDE;
		this.tipoProveedor = tipoProveedor;

		Logeable.LOG_SICV2.info("---------en identificadorProveedorVO");
		Logeable.LOG_SICV2.info("codigoJDE: {}, patron: {}, matches: {}", new Object[] { codigoJDE, ProveedorConstantes.getInstancia().PATRON_CODIGO_PROVEEDOR, codigoJDE.matches(ProveedorConstantes.getInstancia().PATRON_CODIGO_PROVEEDOR) });

		if (BooleanUtils.isTrue(SICProveedorMessages.getInstancia().getBoolean("ec.com.smx.max.rellenar.codigoProveedor"))) {
			if (codigoJDE.matches(ProveedorConstantes.getInstancia().PATRON_CODIGO_PROVEEDOR)) {
				this.codigoJDE = codigoJDE.replaceFirst(getInstancia().PATRON_PREFIJO_CODIGO_PROVEEDOR, getInstancia().RELLENO_PREFIJO_CODIGO_PROVEEDOR);
			} else {
				this.codigoJDE = codigoJDE;
			}

			rellenoCodigoProveedorPorDefecto = SICProveedorMessages.getInstancia().getCharacter("ec.com.smx.max.relleno.prefijo.defecto.codigoProveedor");
			
			if (rellenoCodigoProveedorPorDefecto != null && rellenoCodigoProveedorPorDefecto > Character.MIN_VALUE) {
				this.codigoJDE = StringUtil.leftFiller(this.codigoJDE, SICProveedorMessages.getInstancia().getInteger("ec.com.smx.max.longitud.defecto.codigoProveedor"), rellenoCodigoProveedorPorDefecto);
			}
		} else {
			this.codigoJDE = codigoJDE;
		}

		this.codigoJDENumerico = Integer.valueOf(codigoJDE);
	}

	/**
	 * @return the codigoJDENumerico
	 */
	public Integer getCodigoJDENumerico() {
		return codigoJDENumerico;
	}
	
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoJDE
	 */
	public String getCodigoJDE() {
		return codigoJDE;
	}
	/**
	 * @param codigoJDE the codigoJDE to set
	 */
	public void setCodigoJDE(String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}
	/**
	 * @return the codigoJDEOriginal
	 */
	public String getCodigoJDEOriginal() {
		return codigoJDEOriginal;
	}


	/**
	 * @return the tipoValidacionProveedor
	 */
	public TipoValidacionProveedor getTipoValidacionProveedor() {
		return tipoValidacionProveedor;
	}

	/**
	 * @return the proveedorJDE
	 */
	public DatosProveedor getProveedorJDE() {
		return proveedorJDE;
	}

	/**
	 * @param proveedorJDE the proveedorJDE to set
	 */
	public void setProveedorJDE(DatosProveedor proveedorJDE) {
		this.proveedorJDE = proveedorJDE;
	}

	/**
	 * @return the datosProveedorRUCDuplicado
	 */
	public Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> getDatosProveedorRUCDuplicado() {
		return datosProveedorRUCDuplicado;
	}

	/**
	 * @param datosProveedorRUCDuplicado the datosProveedorRUCDuplicado to set
	 */
	public void setDatosProveedorRUCDuplicado(
			Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> datosProveedorRUCDuplicado) {
		this.datosProveedorRUCDuplicado = datosProveedorRUCDuplicado;
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
