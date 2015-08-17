package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;

/**
 * Entidad que almacena los tipos de precios actuales de un art&iacute;culo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTLOCPRE")
public class ArticuloLocalPrecioDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalPrecioID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalPrecioID();

	/**
	 * Estado que indica si un precio est&aacute; activo o no. Los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoPrecio;
	
	/**
	 * Valor actual del precio
	 * 
	 */
	private Double valorActual;
	/**
	 * Valor anterior del precio
	 * 
	 */
	private Double valorAnterior;
	
	@Transient
	private Double npValorActualImp;
	

	/**
	 * Fecha de cambio del valorActual
	 * 
	 */
	private java.util.Date fechaCambioPrecio;
	
	/**
	 * Secuencial del precio diferenciado
	 * 
	 */
	@Column(name="SECPREDIF")
	private Long secuencialPrecioDiferenciado;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiz&oacute; la &uacute;ltima actualizaci&oacute;n.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz&oacute; la &uacute;ltima actualizaci&oacute;n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOLOCAL", referencedColumnName="CODIGOLOCAL", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO articuloLocal;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOPRECIO", referencedColumnName="CODIGOTIPOPRECIO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO articuloPrecio;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="SECPREDIF", referencedColumnName="SECUENCIAL", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciado;
	
	@Transient
	private Double valorActualCalculado;
	@Transient
	private Double valorAnteriorCalculado;
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalPrecioID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalPrecioID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>estadoPrecio</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoPrecio</code>
	 */
	public String getEstadoPrecio() {
		return this.estadoPrecio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoPrecio</code>.
	 * 
	 * @param estadoPrecio1
	 *            El valor a establecer para la propiedad <code>estadoPrecio</code>.
	 */
	public void setEstadoPrecio(String estadoPrecio1) {
		this.estadoPrecio = estadoPrecio1;

		if (estadoPrecio != null && estadoPrecio.length() > 1) {
			estadoPrecio = estadoPrecio.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}
	
	
	/**
	 * @return the articuloLocal
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO getArticuloLocal() {
		return articuloLocal;
	}

	/**
	 * @param articuloLocal the articuloLocal to set
	 */
	public void setArticuloLocal(ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO articuloLocal) {
		this.articuloLocal = articuloLocal;
	}

	/**
	 * @return the articuloPrecio
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO getArticuloPrecio() {
		return articuloPrecio;
	}

	/**
	 * @param articuloPrecio the articuloPrecio to set
	 */
	public void setArticuloPrecio(ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO articuloPrecio) {
		this.articuloPrecio = articuloPrecio;
	}
	
	public Boolean getTieneArticuloLocal(){
		return isLoaded(articuloLocal) && articuloLocal != null;
	}
	
	public Boolean getTieneArticuloPrecio(){
		return isLoaded(articuloPrecio) && articuloPrecio != null;
	}
	
	/**
	 * Obtiene el precio sin impuestos asociado al registro
	 * @return
	 */
	public Double getValorActualCalculado(){
		valorActualCalculado = null;
		if(this.getId().getCodigoTipoPrecio() != null){
			Double precioBase = null;
			if(!this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)){
				//cuando el registro no se refiere al precio base se busca el precio base para el calculo
				//TODO EL CALCULO EN EL FUTURO DEBERA SER SOBRE EL MARGEN Y PROMOCION
				//TEMPORALMENTE EL PRECIO BASE ES UN VALOR FIJO
				if(this.getTieneArticuloPrecio() && articuloPrecio.getTieneArticuloUnidadManejo() && 
						!CollectionUtils.isEmpty(articuloPrecio.getArticuloUnidadManejo().getArticuloUnidadManejoUsoCol())){
					if(this.getValorActual() != null){
						return this.getValorActual();
					}
					
					precioBase = obtenerPrecioBase(Boolean.FALSE);
					
					if(precioBase != null && SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(articuloPrecio.getArticuloUnidadManejo().getEstadoUnidadManejo())){
						Boolean tieneUsoVenta = Boolean.FALSE;
						for(ArticuloUnidadManejoUsoDTO uso : articuloPrecio.getArticuloUnidadManejo().getArticuloUnidadManejoUsoCol()){
							if(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA.equals(uso.getId().getValorTipoUso()) && SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(uso.getEstado())){
								tieneUsoVenta = Boolean.TRUE;
							}
						}
						if(tieneUsoVenta){
			    			if(this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA)){
		    					valorActualCalculado = SICArticuloCalculo.getInstancia().calcularPrecioCaja(this.articuloPrecio.getArticuloUnidadManejo(), precioBase, obtenerPrecioBase(Boolean.TRUE));

			    			}else if(this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA)){
			    				valorActualCalculado = SICArticuloCalculo.getInstancia().calcularPrecioMayorista(this.articuloPrecio.getArticuloUnidadManejo(), precioBase);
			    			}
			    		}
					}
				}
				return valorActualCalculado;
			}
			Map<String, Double> valoresImpuesto = this.getArticuloPrecio().obtenerImpuestos();
			if(valoresImpuesto != null && valorActual != null && !StringUtils.equals(this.getId().getCodigoTipoPrecio(), EnumTipoPrecio.PRECIO_PVP.getCodigoTipoPrecio())){
				valorActualCalculado = SICArticuloCalculo.getInstancia().calcularValorConImpuestoVerde(valorActual, valoresImpuesto);
			}else{
				valorActualCalculado = valorActual;
			}
		}
		return valorActualCalculado;
	}
	
	/**
	 * Obtiene el anterior precio sin impuestos asociado al registro
	 * @return
	 */
	public Double getValorAnteriorCalculado(){		
		if(valorAnteriorCalculado == null && this.getId().getCodigoTipoPrecio() != null){			
			valorAnteriorCalculado = valorAnterior;
		}
		return valorAnteriorCalculado;
	}
	
	/**
	 * Busca el precio base desde otro tipo de precio
	 * @param conImpuesto
	 * @return
	 */
	private Double obtenerPrecioBase(Boolean conImpuesto){
		Double precio = null;
		//PRIMERO SE BUSCA EN LA RELACION CON ARTICULO LOCAL
		//cuando el registro no se refiere al precio base se busca el precio base para el calculo
		if(this.getTieneArticuloLocal() && this.articuloLocal.getTieneArticuloLocalPrecioCol()){
			for(ArticuloLocalPrecioDTO alp : this.getArticuloLocal().getArticuloLocalPrecioCol()){
				if(SICArticuloConstantes.TIPO_PRECIO_BASE.equals(alp.getId().getCodigoTipoPrecio())
						&& SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(alp.getEstadoPrecio())){
					if(conImpuesto){
						precio = alp.getValorActualImp();
					}else{
						precio = alp.getValorActual();
						Map<String, Double> valoresImpuesto = this.getArticuloPrecio().obtenerImpuestos();
						if(valoresImpuesto != null && precio != null){
							precio = SICArticuloCalculo.getInstancia().calcularValorConImpuestoVerde(precio, valoresImpuesto);
						}
					}
				}
			}
		}
		
		//si no se obtubo un precio valido por local se busca en el maestro
		if(precio == null && getTieneArticuloPrecio() && articuloPrecio.getTieneArticulo() && articuloPrecio.getArticulo().getTieneArticuloPrecio()){
			for(ArticuloPrecioDTO ap : articuloPrecio.getArticulo().getArticuloPrecioCol()){
				if(SICArticuloConstantes.TIPO_PRECIO_BASE.equals(ap.getId().getCodigoTipoPrecio()) && ap.getTieneArticuloLocalPrecio()){
					ArticuloLocalPrecioDTO alp = ap.getArticuloLocalPrecioCol().iterator().next();
					if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(alp.getEstadoPrecio())){
						if(conImpuesto){
							precio = alp.getValorActualImp();
						}else{
							precio = alp.getValorActual();
							Map<String, Double> valoresImpuesto = this.getArticuloPrecio().obtenerImpuestos();
							if(valoresImpuesto != null && precio != null){
								precio = SICArticuloCalculo.getInstancia().calcularValorConImpuestoVerde(precio, valoresImpuesto);
							}
						}
					}
					break;
				}
			}
			
			if(precio == null){
				for(ArticuloPrecioDTO ap : articuloPrecio.getArticulo().getArticuloPrecioCol()){
					if(SICArticuloConstantes.TIPO_PRECIO_BASE.equals(ap.getId().getCodigoTipoPrecio())){
						if(conImpuesto){
							precio = ap.getValorActualImp();
						}else{
							precio = ap.getValorActual();
							Map<String, Double> valoresImpuesto = this.getArticuloPrecio().obtenerImpuestos();
							if(valoresImpuesto != null && precio != null){
								precio = SICArticuloCalculo.getInstancia().calcularValorConImpuestoVerde(precio, valoresImpuesto);
							}
						}
						break;
					}
				}
			}
		}
		
		return precio;
	}

	/**
	 * Obtiene el precio de no afiliado sin impuestos asociado al registro
	 * @return
	 */
	public Double getValorActualNA(){
		if(getTieneArticuloPrecio()){
			return articuloPrecio.calcularValorNoAfiliado(getValorActualCalculado());
		}
		return getValorActualCalculado();
	}
	
	/**
	 * Obtiene el precio de no afiliado con impuestos asociado al registro
	 * @return
	 */
	public Double getValorActualNAImp(){
		if(getTieneArticuloPrecio()){
			return articuloPrecio.calcularValorNoAfiliado(getValorActualImp());
		}
		return getValorActualImp();
	}
	
	/**
	 * Obtiene el precio anterior de no afiliado con impuestos asociado al registro
	 * @return
	 */
	public Double getValorAnteriorNAImp(){
		if(getTieneArticuloPrecio()){
			return articuloPrecio.calcularValorNoAfiliado(getValorAnteriorImp());
		}
		return getValorAnteriorImp();
	}

	/**
	 * Obtiene el precio con impuestos asociado al registro
	 * @return
	 */
	public Double getValorActualImp(){
		Double precio = null;
		if(this.getId().getCodigoTipoPrecio() != null && this.getTieneArticuloPrecio()){
			if(this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)){
        		precio = getValorActualImp(getValorActualCalculado());
			}else if(articuloPrecio.getTieneArticuloUnidadManejo() && SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(articuloPrecio.getArticuloUnidadManejo().getEstadoUnidadManejo())){
				if(!CollectionUtils.isEmpty(articuloPrecio.getArticuloUnidadManejo().getArticuloUnidadManejoUsoCol())){
					if(npValorActualImp != null){
						return npValorActualImp;
					}
					Boolean tieneUsoVenta = Boolean.FALSE;
					for(ArticuloUnidadManejoUsoDTO uso : articuloPrecio.getArticuloUnidadManejo().getArticuloUnidadManejoUsoCol()){
						if(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA.equals(uso.getId().getValorTipoUso()) && SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(uso.getEstado())){
							tieneUsoVenta = Boolean.TRUE;
						}
					}
					if(tieneUsoVenta){
						if(this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_CAJA)){
							Double precioBaseImpuesto = obtenerPrecioBase(Boolean.TRUE);
//							precio = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularPrecioCaja(this.articuloPrecio.getArticuloUnidadManejo(), precioBaseImpuesto, precioBaseImpuesto);
							precio = SICArticuloCalculo.getInstancia().calcularPrecioCaja(this.articuloPrecio.getArticuloUnidadManejo(), precioBaseImpuesto, precioBaseImpuesto);

						}else if(this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_MAYORISTA)){
//							precio = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularPrecioMayorista(this.articuloPrecio.getArticuloUnidadManejo(), obtenerPrecioBase(Boolean.TRUE));
							precio = SICArticuloCalculo.getInstancia().calcularPrecioMayorista(this.articuloPrecio.getArticuloUnidadManejo(), obtenerPrecioBase(Boolean.TRUE));
						}
					}
				}
			}
		}
		return precio;
	}
	
	public Double getValorAnteriorImp(){
		Double precio = null;
		if(this.getId().getCodigoTipoPrecio() != null && this.getTieneArticuloPrecio()){
			if(this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)){
        		precio = getValorActualImp(this.getValorAnterior());
			}
		}
		return precio;
	}

	public void setNpValorActualImp(Double npValorActualImp) {
		this.npValorActualImp = npValorActualImp;
	}
	
	private Double getValorActualImp(Double precioBase){
		Map<String, Double> valoresImpuesto = this.getArticuloPrecio().obtenerImpuestos();
		if(precioBase != null && valoresImpuesto !=null){
			return SICArticuloCalculo.getInstancia().calcularValorConImpuestos(precioBase, valoresImpuesto, Boolean.TRUE);
		}
		return precioBase;
	}
	
	/**
	 * @return the valorAnterior
	 */
	public Double getValorAnterior() {
		return valorAnterior;
	}

	/**
	 * @param valorAnterior the valorAnterior to set
	 */
	public void setValorAnterior(Double valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	/**
	 * @return the fechaCambioPrecio
	 */
	public java.util.Date getFechaCambioPrecio() {
		return fechaCambioPrecio;
	}

	/**
	 * @param fechaCambioPrecio the fechaCambioPrecio to set
	 */
	public void setFechaCambioPrecio(java.util.Date fechaCambioPrecio) {
		this.fechaCambioPrecio = fechaCambioPrecio;
	}

	/**
	 * @param valorActual the valorActual to set
	 */
	public Double getValorActual() {
		return this.valorActual;
	}
	/**
	 * @param valorActual the valorActual to set
	 */
	public void setValorActual(Double valorActual) {
		this.valorActual = valorActual;
	}

	/**
	 * @param valorActualCalculado the valorActualCalculado to set
	 */
	public void nulificarValorActualCalculado() {
		this.valorActualCalculado = null;
	}

	public Long getSecuencialPrecioDiferenciado() {
		return secuencialPrecioDiferenciado;
	}

	public void setSecuencialPrecioDiferenciado(Long secuencialPrecioDiferenciado) {
		this.secuencialPrecioDiferenciado = secuencialPrecioDiferenciado;
	}

	public ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO getArticuloPrecioDiferenciado() {
		return articuloPrecioDiferenciado;
	}

	public void setArticuloPrecioDiferenciado(ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciado) {
		this.articuloPrecioDiferenciado = articuloPrecioDiferenciado;
	}

}
