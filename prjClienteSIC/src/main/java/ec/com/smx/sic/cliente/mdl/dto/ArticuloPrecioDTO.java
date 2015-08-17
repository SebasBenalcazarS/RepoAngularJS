package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.factory.SICFactory;

/**
 * Entidad que almacena los tipos de precios actuales de un articulo
 * 
 * @author kruger
 * <b>TIPOS DE REGLAS</b>
 * <ul>
 * <li>Si el tipo de precio en el articulo se desactiva se deben desactivar en todos los locales ?</li>
 * </ul>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTPRE")
public class ArticuloPrecioDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPrecioID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPrecioID();

	/**
	 * Secuencial de unidad de manejo
	 */
	@Column(name="CODIGOUNIDADMANEJO")
	private Long codigoUnidadManejo;
	
	/**
	 * Estado que indica si un precio esta activo o no. Los valores permitidos son: [0] Inactivo [1] Activo
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
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@Column(name="PORCENTAJEMARGEN")
	private Double margenPrecio;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@OneToMany(mappedBy = "articuloPrecio")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloLocalPrecioDTO> articuloLocalPrecioCol;

	@OneToMany(mappedBy = "articuloPrecio")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloPrecioDiferenciadoDTO> preciosDiferenciados;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOUNIDADMANEJO", referencedColumnName="CODIGOUNIDADMANEJO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO articuloUnidadManejo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOTIPOPRECIO", referencedColumnName="CODIGOTIPOPRECIO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.TipoPrecioArticuloDTO tipoPrecioArticulo;
	
	@Transient
	private ArticuloLocalPrecioDTO npArticuloLocalPrecio;
	@Transient
	private Double valorActualCalculado;
	@Transient
	private Double valorActualCalculadoIRBP;
	@Transient
	private Double valorAnteriorCalculado;
	@Transient
	private Double valorActualSinDescuento;
	
	@Transient
	private Boolean isNew = Boolean.FALSE;
	
	@Transient
	private Boolean ejecutado = Boolean.FALSE;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPrecioID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPrecioID id1) {
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
	 * Retorna valor de propiedad <code>valorActual</code>
	 * 
	 * @return Retorna valor de propiedad <code>valorActual</code>
	 */
	public Double getValorActual() {
		return this.valorActual;
	}
	
	/**
	 * Establece un nuevo valor para la propiedad <code>valorActual</code>.
	 * 
	 * @param valorActual1
	 *            El valor a establecer para la propiedad <code>valorActual</code>.
	 */
	public void setValorActual(Double valorActual1) {
		this.valorActual = valorActual1;

	}
	
	/**
	 * Retorna el valor del precio calculado en base a ciertas condiciones especiales
	 * 
	 */
	public Double getValorActualCalculado() {
			valorActualCalculado = null;
    		if(npArticuloLocalPrecio != null){
    			valorActualCalculado = npArticuloLocalPrecio.getValorActualCalculado();
    		}else if(this.getId().getCodigoTipoPrecio() != null){
    			Double precioBase = null;
    			if(!this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE.getCodigoTipoPrecio())
    					&& !this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_PVP.getCodigoTipoPrecio())
    					&& !this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE_DESCUENTO_DIARIO.getCodigoTipoPrecio())
    					&& !this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_DIARIO.getCodigoTipoPrecio())
    					&& !this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE_DESCUENTO_ACUMULADO.getCodigoTipoPrecio())
    					&& !this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_ACUMULADO.getCodigoTipoPrecio())){
    				
    				if(getTieneArticuloUnidadManejo() && !CollectionUtils.isEmpty(articuloUnidadManejo.getArticuloUnidadManejoUsoCol())){
    					if(this.getValorActual() != null){
    						return this.getValorActual();
    					}
    					
    					//cuando el registro no se refiere al precio base se busca el precio base para el cálculo
        				precioBase = obtenerPrecioBase(Boolean.FALSE);
        				
        				if(precioBase != null && SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(articuloUnidadManejo.getEstadoUnidadManejo())){
        					Boolean tieneUsoVenta = Boolean.FALSE;
        					for(ArticuloUnidadManejoUsoDTO uso : articuloUnidadManejo.getArticuloUnidadManejoUsoCol()){
        						if(SICArticuloConstantes.VALORUSOUNIMANVENTA.equals(uso.getId().getValorTipoUso()) && SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(uso.getEstado())){
        							tieneUsoVenta = Boolean.TRUE;
        						}
        					}
        					if(tieneUsoVenta){
    	        				if(this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_CAJA.getCodigoTipoPrecio())){    	        					
    	        					valorActualCalculado = SICArticuloCalculo.getInstancia().calcularPrecioCaja(this.articuloUnidadManejo, precioBase, obtenerPrecioBase(Boolean.TRUE));
    	        				}else if(this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_MAYORISTA.getCodigoTipoPrecio())){    	        					
    	        					valorActualCalculado = SICArticuloCalculo.getInstancia().calcularPrecioMayorista(this.articuloUnidadManejo, precioBase);
    	        				}
        					}
        				}
    				}
    				return valorActualCalculado;
    			}
    			Map<String, Double> valoresImpuestos = this.obtenerImpuestos();
				if(valoresImpuestos != null && valorActual != null && !StringUtils.equals(this.getId().getCodigoTipoPrecio(), EnumTipoPrecio.PRECIO_PVP.getCodigoTipoPrecio())){
					valorActualCalculado = SICArticuloCalculo.getInstancia().calcularValorConImpuestoVerde(valorActual, valoresImpuestos);
				}else{
					valorActualCalculado = valorActual;	
				}
    		}
		return this.valorActualCalculado;
	}
	
	public Double getValorActualCalculadoIRBP() {
		if(valorActualCalculadoIRBP == null){
			Map<String, Double> valoresImpuestos = this.obtenerImpuestos();
			if(valoresImpuestos != null && valorActual != null){
				valorActualCalculadoIRBP = SICArticuloCalculo.getInstancia().calcularValorConImpuestoVerde(valorActual, valoresImpuestos);
			}else{
				valorActualCalculadoIRBP = valorActual;
			}
		}
		return valorActualCalculadoIRBP;
	}
	
	/**
	 * Retorna el valor anterior del precio calculado en base a ciertas condiciones especiales
	 * 
	 */
	public Double getValorAnteriorCalculado() {
		if (valorAnteriorCalculado == null){
    		if(npArticuloLocalPrecio != null){
    			valorAnteriorCalculado = npArticuloLocalPrecio.getValorAnteriorCalculado();
    		}else if(this.getId().getCodigoTipoPrecio() != null){
    			valorAnteriorCalculado = valorAnterior;
    		}
		}
		return this.valorAnteriorCalculado;
	}
	
	private Double obtenerPrecioBase(Boolean conImpuesto){
		Double precioBase = null;		
		//cuando el registro no se refiere al precio base se busca el precio base para el calculo
		if(this.getTieneArticulo() && this.articulo.getTieneArticuloPrecio()){
			for(ArticuloPrecioDTO ap : this.getArticulo().getArticuloPrecioCol()){
				if(ap.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.TIPO_PRECIO_BASE)){
					if(conImpuesto){
						precioBase = ap.getValorActualImp(npArticuloLocalPrecio != null || ap.getNpArticuloLocalPrecio() != null ? ap.getValorActualCalculado() : ap.getValorActualCalculado());
					}else{
						precioBase = (npArticuloLocalPrecio != null || ap.getNpArticuloLocalPrecio() != null ? ap.getValorActualCalculado() : ap.getValorActual());
						Map<String, Double> valoresImpuestos = this.obtenerImpuestos();
						if(valoresImpuestos != null && precioBase != null){
							precioBase = SICArticuloCalculo.getInstancia().calcularValorConImpuestoVerde(precioBase, valoresImpuestos);
						}
					}
					return precioBase;
				}
			}
		}
		return precioBase;
	}
	
	/**
	 * Retorna valor de propiedad <code>valorAnterior</code>
	 * 
	 * @return Retorna valor de propiedad <code>valorAnterior</code>
	 */
	public Double getValorAnterior() {
		return this.valorAnterior;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorAnterior</code>.
	 * 
	 * @param valorAnterior1
	 *            El valor a establecer para la propiedad <code>valorAnterior</code>.
	 */
	public void setValorAnterior(Double valorAnterior1) {
		this.valorAnterior = valorAnterior1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaCambioPrecio</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaCambioPrecio</code>
	 */
	public java.util.Date getFechaCambioPrecio() {
		return this.fechaCambioPrecio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaCambioPrecio</code>.
	 * 
	 * @param fechaCambioPrecio1
	 *            El valor a establecer para la propiedad <code>fechaCambioPrecio</code>.
	 */
	public void setFechaCambioPrecio(java.util.Date fechaCambioPrecio1) {
		this.fechaCambioPrecio = fechaCambioPrecio1;

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
	 * Retorna valor de propiedad <code>articulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>articulo</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return this.articulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articulo</code>.
	 * 
	 * @param articulo1
	 *            El valor a establecer para la propiedad <code>articulo</code>.
	 */
	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo1) {
		this.articulo = articulo1;
	}

	/**
	 * Retorna valor de propiedad <code>tipoPrecioArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>tipoPrecioArticulo</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.TipoPrecioArticuloDTO getTipoPrecioArticulo() {
		return this.tipoPrecioArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoPrecioArticulo</code>.
	 * 
	 * @param tipoPrecioArticulo1
	 *            El valor a establecer para la propiedad <code>tipoPrecioArticulo</code>.
	 */
	public void setTipoPrecioArticulo(ec.com.smx.sic.cliente.mdl.dto.TipoPrecioArticuloDTO tipoPrecioArticulo1) {
		this.tipoPrecioArticulo = tipoPrecioArticulo1;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the articuloUnidadManejo
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO getArticuloUnidadManejo() {
		return articuloUnidadManejo;
	}

	/**
	 * @param articuloUnidadManejo the articuloUnidadManejo to set
	 */
	public void setArticuloUnidadManejo(ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO articuloUnidadManejo) {
		this.articuloUnidadManejo = articuloUnidadManejo;
	}
	
	public Boolean getTieneArticulo(){
		return isLoaded(articulo) && articulo != null;
	}
	public Boolean getTieneArticuloUnidadManejo(){
		return isLoaded(articuloUnidadManejo) && articuloUnidadManejo != null;
	}
	public Boolean getTieneArticuloLocalPrecio(){
		return isLoaded(articuloLocalPrecioCol) && !articuloLocalPrecioCol.isEmpty();
	}
	/**
	 * Obtiene el precio actual con impuestos
	 * @return
	 */
	public Double getValorActualImp(){ 
		Double precio = null;
		if(this.getId().getCodigoTipoPrecio() != null){
			if(this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE.getCodigoTipoPrecio())
				|| this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_PVP.getCodigoTipoPrecio())
				|| this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE_DESCUENTO_DIARIO.getCodigoTipoPrecio())
				|| this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_DIARIO.getCodigoTipoPrecio())
				|| this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE_DESCUENTO_ACUMULADO.getCodigoTipoPrecio())
				|| this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_ACUMULADO.getCodigoTipoPrecio())){
        		precio = getValorActualImp(getValorActualCalculado());
			}else if(this.getTieneArticuloUnidadManejo() && SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(this.getArticuloUnidadManejo().getEstadoUnidadManejo())){
				if(!CollectionUtils.isEmpty(articuloUnidadManejo.getArticuloUnidadManejoUsoCol())){
					if(npValorActualImp != null){
						return npValorActualImp;
					}
					Boolean tieneUsoVenta = Boolean.FALSE;
					for(ArticuloUnidadManejoUsoDTO uso : articuloUnidadManejo.getArticuloUnidadManejoUsoCol()){
						if(SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA.equals(uso.getId().getValorTipoUso()) && SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO.equals(uso.getEstado())){
							tieneUsoVenta = Boolean.TRUE;
						}
					}
					if(tieneUsoVenta){
						if(this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_CAJA.getCodigoTipoPrecio())){
							Double precioBaseImpuesto = obtenerPrecioBase(Boolean.TRUE);
							precio = SICArticuloCalculo.getInstancia().calcularPrecioCaja(this.articuloUnidadManejo, precioBaseImpuesto, precioBaseImpuesto);
						}else if(this.getId().getCodigoTipoPrecio().equals(EnumTipoPrecio.PRECIO_MAYORISTA.getCodigoTipoPrecio())){
							precio = SICArticuloCalculo.getInstancia().calcularPrecioMayorista(this.articuloUnidadManejo, obtenerPrecioBase(Boolean.TRUE));
						}
					}
				}
			}
		}
		return precio;
	}
	
	public void setNpValorActualImp(Double npValorActualImp) {
		this.npValorActualImp = npValorActualImp;
	}

	/**
	 * Obtiene el precio anterior con impuestos
	 * @return
	 */
	public Double getValorAnteriorImp(){ 
		Double precio = null;
		if(this.getId().getCodigoTipoPrecio() != null){
			if(this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)
				|| this.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP)){
        		precio = getValorActualImp(getValorAnteriorCalculado());
			}
		}
		return precio;
	}
	
	private Double getValorActualImp(Double precioBase){
		Map<String, Double> valoresImpuestos = this.obtenerImpuestos();
		if(valoresImpuestos != null && precioBase != null){
			return SICArticuloCalculo.getInstancia().calcularValorConImpuestos(precioBase, valoresImpuestos, Boolean.TRUE);
		}
		return precioBase;
	}
	
	/**
	 * Obtiene el precio actual de no afiliado sin impuestos
	 * @return
	 */
	public Double getValorActualNA(){
		return calcularValorNoAfiliado(getValorActualCalculado());
	}

	/**
	 * Obtiene el precio actual de no afiliado con impuestos
	 * @return
	 */
	public Double getValorActualNAImp(){
		return calcularValorNoAfiliado(getValorActualImp());
	}
	
	/**
	 * Obtiene el precio aneriror de no afiliado con impuestos
	 * @return
	 */
	public Double getValorAnteriorNAImp(){
		return calcularValorNoAfiliado(getValorAnteriorImp());
	}
	
	protected Double calcularValorNoAfiliado(Double precioBase){
		if(getTieneArticulo() && precioBase != null && SearchDTO.isLoaded(articulo.getArticuloComercialDTO()) && !articulo.getArticuloComercialDTO().getVentaPrecioAfiliado()) {
			return SICArticuloCalculo.getInstancia().calcularPrecioBaseNoAfiliado(precioBase, articulo.getArticuloComercialDTO().getPorcentajeNoAfiliado());
		}
		return precioBase;
	}
	
	protected Map<String, Double> obtenerImpuestos(){
		if(this.getTieneArticulo()){
			return SICArticuloCalculo.getInstancia().obtenerValoresImpuesto(articulo, Boolean.TRUE);
		}
		return null;
	}
	
	/**
	 * @return the articuloLocalPrecioCol
	 */
	public Collection<ArticuloLocalPrecioDTO> getArticuloLocalPrecioCol() {
		return articuloLocalPrecioCol;
	}

	/**
	 * @param articuloLocalPrecioCol the articuloLocalPrecioCol to set
	 */
	public void setArticuloLocalPrecioCol(Collection<ArticuloLocalPrecioDTO> articuloLocalPrecioCol) {
		this.articuloLocalPrecioCol = articuloLocalPrecioCol;
	}

	/**
	 * @return the npArticuloLocalPrecio
	 */
	public ArticuloLocalPrecioDTO getNpArticuloLocalPrecio() {
		return npArticuloLocalPrecio;
	}

	/**
	 * @param npArticuloLocalPrecio the npArticuloLocalPrecio to set
	 */
	public void setNpArticuloLocalPrecio(ArticuloLocalPrecioDTO npArticuloLocalPrecio) {
		this.npArticuloLocalPrecio = npArticuloLocalPrecio;
	}
	
	@Deprecated
	public Double calcularMargen(Double costoNeto){		
		return SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularMargenPrecio(this, costoNeto);
	}

	/**
	 * @return the valorActualSinDescuento
	 */
	public Double getValorActualSinDescuento() {
		return valorActualSinDescuento;
	}

	/**
	 * @param valorActualSinDescuento the valorActualSinDescuento to set
	 */
	public void setValorActualSinDescuento(Double valorActualSinDescuento) {
		this.valorActualSinDescuento = valorActualSinDescuento;
	}

	/**
	 * Obtiene el precio actual sin descuentos con impuestos
	 * @return
	 */
	public Double getValorActualSinDescuentoImp(){
		return getValorActualImp(valorActualSinDescuento);
	}
	

	/**
	 * @param valorActualCalculado the valorActualCalculado to set
	 */
	public void nulificarValorActualCalculado() {
		this.valorActualCalculado = null;
	}

	/**
	 * @return the margenPrecio
	 */
	public Double getMargenPrecio() {
		return margenPrecio;
	}

	/**
	 * @param margenPrecio the margenPrecio to set
	 */
	public void setMargenPrecio(Double margenPrecio) {
		this.margenPrecio = margenPrecio;
	}

	public Collection<ArticuloPrecioDiferenciadoDTO> getPreciosDiferenciados() {
		return preciosDiferenciados;
	}

	public void setPreciosDiferenciados(Collection<ArticuloPrecioDiferenciadoDTO> preciosDiferenciados) {
		this.preciosDiferenciados = preciosDiferenciados;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public Boolean getEjecutado() {
		return ejecutado;
	}

	public void setEjecutado(Boolean ejecutado) {
		this.ejecutado = ejecutado;
	}
	
}
