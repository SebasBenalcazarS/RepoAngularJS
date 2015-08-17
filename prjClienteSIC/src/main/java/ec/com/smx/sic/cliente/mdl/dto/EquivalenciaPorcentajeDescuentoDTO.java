
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Contiene las relaciones entre un porcentaje o cantidad con su respectivo porcentaje de descuento
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTEQUPORDES")
public class EquivalenciaPorcentajeDescuentoDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.EquivalenciaPorcentajeDescuentoID id = new ec.com.smx.sic.cliente.mdl.dto.id.EquivalenciaPorcentajeDescuentoID();

	/**
	 * Contiene la cantidad asociada al descuento
	 *
	 */
	private Integer valorCantidad ;	

	/**
	 * Contiene el porcentaje asociado al descuento
	 *
	 */
	private Double valorPorcentaje ;

	@Column(name = "SECUENCIALASITIPDES", nullable = false)
	private Integer secuencialAsignacionTipoDescuento;
		
	/**
	 * Contiene el porcentaje de descuento
	 */
	private Double descuento ;
	
	@ComparatorTypeField
	private String estado;

	/**
	 * Especifica el usuario que realiza el registro.
	 */
	
	@RegisterUserIdField
	private String idUsuarioRegistro ;	

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro ;
	
	@OneToMany(mappedBy="equivalenciaPorcentajeDescuento")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloUnidadManejoProveedorEquivalenciaDTO> articuloUnidadManejoProveedorEquivalenciaCol;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "SECUENCIALASITIPDES", referencedColumnName = "SECUENCIALASITIPDES", insertable = false, updatable = false)
	})
	private AsignacionTipoDescuentoDTO asignacionTipoDescuento;

//	@ManyToOne(fetch = LAZY)
//	@JoinColumns({@JoinColumn(name="CODIGOTIPODESCUENTO", insertable=false, updatable=false, referencedColumnName="CODIGOTIPODESCUENTO"),
//		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA")})
	@Transient
	private TipoDescuentoDTO npTipoDescuento;
	

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	
	public ec.com.smx.sic.cliente.mdl.dto.id.EquivalenciaPorcentajeDescuentoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.EquivalenciaPorcentajeDescuentoID id1 ){
		this.id=id1;
	}		

	/**
	 * Retorna valor de propiedad <code>valorCantidad</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>valorCantidad</code>
	 */
	public Integer getValorCantidad(){
		return this.valorCantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorCantidad</code>.
	 * @param valorCantidad1 
	 *		El valor a establecer para la propiedad <code>valorCantidad</code>.
	 */
	public void setValorCantidad( Integer valorCantidad1 ){
		this.valorCantidad=valorCantidad1;
		
	}		

	/**
	 * Retorna valor de propiedad <code>valorPorcentaje</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>valorPorcentaje</code>
	 */
	public Double getValorPorcentaje(){
		return this.valorPorcentaje;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorPorcentaje</code>.
	 * @param valorPorcentaje1 
	 *		El valor a establecer para la propiedad <code>valorPorcentaje</code>.
	 */
	public void setValorPorcentaje( Double valorPorcentaje1 ){
		this.valorPorcentaje=valorPorcentaje1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>descuento</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>descuento</code>
	 */
	public Double getDescuento(){
		return this.descuento;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descuento</code>.
	 * @param descuento1 
	 *		El valor a establecer para la propiedad <code>descuento</code>.
	 */
	public void setDescuento( Double descuento1 ){
		this.descuento=descuento1;
		
	}		

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro(){
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * @param idUsuarioRegistro1 
	 *		El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro( String idUsuarioRegistro1 ){
		this.idUsuarioRegistro=idUsuarioRegistro1;
		
		if(idUsuarioRegistro!=null && idUsuarioRegistro.length()>32){
			idUsuarioRegistro = idUsuarioRegistro.substring(0,32);
		}				
				
	}		

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro(){
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * @param fechaRegistro1 
	 *		El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro( java.sql.Timestamp fechaRegistro1 ){
		this.fechaRegistro=fechaRegistro1;
		
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TipoDescuentoDTO getNPTipoDescuento() {
		return npTipoDescuento;
	}

	public void setNPTipoDescuento(TipoDescuentoDTO npTipoDescuento) {
		this.npTipoDescuento = npTipoDescuento;
	}

	/**
	 * @return the secuencialAsignacionTipoDescuento
	 */
	public Integer getSecuencialAsignacionTipoDescuento() {
		return secuencialAsignacionTipoDescuento;
	}

	/**
	 * @param secuencialAsignacionTipoDescuento the secuencialAsignacionTipoDescuento to set
	 */
	public void setSecuencialAsignacionTipoDescuento(Integer secuencialAsignacionTipoDescuento) {
		this.secuencialAsignacionTipoDescuento = secuencialAsignacionTipoDescuento;
	}

	/**
	 * @return the asignacionTipoDescuento
	 */
	public AsignacionTipoDescuentoDTO getAsignacionTipoDescuento() {
		return asignacionTipoDescuento;
	}

	/**
	 * @param asignacionTipoDescuento the asignacionTipoDescuento to set
	 */
	public void setAsignacionTipoDescuento(AsignacionTipoDescuentoDTO asignacionTipoDescuento) {
		this.asignacionTipoDescuento = asignacionTipoDescuento;
	}

	/**
	 * @return the articuloUnidadManejoProveedorEquivalenciaCol
	 */
	public Collection<ArticuloUnidadManejoProveedorEquivalenciaDTO> getArticuloUnidadManejoProveedorEquivalenciaCol() {
		return articuloUnidadManejoProveedorEquivalenciaCol;
	}

	/**
	 * @param articuloUnidadManejoProveedorEquivalenciaCol the articuloUnidadManejoProveedorEquivalenciaCol to set
	 */
	public void setArticuloUnidadManejoProveedorEquivalenciaCol(Collection<ArticuloUnidadManejoProveedorEquivalenciaDTO> articuloUnidadManejoProveedorEquivalenciaCol) {
		this.articuloUnidadManejoProveedorEquivalenciaCol = articuloUnidadManejoProveedorEquivalenciaCol;
	}

}

