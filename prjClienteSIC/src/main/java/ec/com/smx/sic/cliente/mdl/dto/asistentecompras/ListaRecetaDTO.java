/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ListaRecetaID;

/**
 * @author dvillafuerte
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCSACTLISREC")
public class ListaRecetaDTO  extends SimpleAuditDTO implements Cloneable {

	@EmbeddedId
	private ListaRecetaID id = new ListaRecetaID();

	private Integer codigoTipoLista;
	@ComparatorTypeField
	private String valorTipoLista;
	private String descripcionListaReceta;
	private String preparacion;
	private String tiempoPreparacion;
	private Double numeroPorciones;
	@ComparatorTypeField
	private String  idApp;
	private Date fechaInicioTemporada;
	private Date fechaFinTemporada;
	@ComparatorTypeField
	private String estado;

	@Transient
	private String nombreCatalogoValor;

	@Transient
	private Map<String, ComparatorTypeEnum> comparatorTypeEnum;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO",updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	//relaciones
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOTIPOLISTA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "VALORTIPOLISTA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)})
	private CatalogoValorDTO catalogoValor;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="listaRecetaDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ListaDTO> listaDtoCol;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="listaRecetaDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleListaRecetaDTO> detalleListaRecetaDtoCol;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="listaRecetaDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<RecetaClientePedidoDTO> recetaClientePedidoDtoCol;

	//METODOS GET Y SET
	public ListaRecetaID getId() {
		return id;
	}

	public void setId(ListaRecetaID id) {
		this.id = id;
	}

	public Integer getCodigoTipoLista() {
		return codigoTipoLista;
	}

	public void setCodigoTipoLista(Integer codigoTipoLista) {
		this.codigoTipoLista = codigoTipoLista;
	}

	public String getValorTipoLista() {
		return valorTipoLista;
	}

	public void setValorTipoLista(String valorTipoLista) {
		this.valorTipoLista = valorTipoLista;
	}

	public String getDescripcionListaReceta() {
		return descripcionListaReceta;
	}

	public void setDescripcionListaReceta(String descripcionListaReceta) {
		if(descripcionListaReceta!= null && descripcionListaReceta.length()>100){
			this.descripcionListaReceta = descripcionListaReceta.substring(0, 99);
		}else{
			this.descripcionListaReceta=descripcionListaReceta;
		}
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(String tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	/**
	 * @return the numeroPorciones
	 */
	public Double getNumeroPorciones() {
		return numeroPorciones;
	}

	/**
	 * @param numeroPorciones the numeroPorciones to set
	 */
	public void setNumeroPorciones(Double numeroPorciones) {
		this.numeroPorciones = numeroPorciones;
	}

	public Date getFechaInicioTemporada() {
		return fechaInicioTemporada;
	}

	public void setFechaInicioTemporada(Date fechaInicioTemporada) {
		this.fechaInicioTemporada = fechaInicioTemporada;
	}

	public Date getFechaFinTemporada() {
		return fechaFinTemporada;
	}

	public void setFechaFinTemporada(Date fechaFinTemporada) {
		this.fechaFinTemporada = fechaFinTemporada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public CatalogoValorDTO getCatalogoValor() {
		return catalogoValor;
	}

	public void setCatalogoValor(CatalogoValorDTO catalogoValor) {
		this.catalogoValor = catalogoValor;
	}

	public Collection<ListaDTO> getListaDtoCol() {
		return listaDtoCol;
	}

	public void setListaDtoCol(Collection<ListaDTO> listaDtoCol) {
		this.listaDtoCol = listaDtoCol;
	}

	public Collection<DetalleListaRecetaDTO> getDetalleListaRecetaDtoCol() {
		return detalleListaRecetaDtoCol;
	}

	public void setDetalleListaRecetaDtoCol(Collection<DetalleListaRecetaDTO> detalleListaRecetaDtoCol) {
		this.detalleListaRecetaDtoCol = detalleListaRecetaDtoCol;
	}

	/**
	 * @return the recetaClientePedidoDtoCol
	 */
	public Collection<RecetaClientePedidoDTO> getRecetaClientePedidoDtoCol() {
		return recetaClientePedidoDtoCol;
	}

	/**
	 * @param recetaClientePedidoDtoCol the recetaClientePedidoDtoCol to set
	 */
	public void setRecetaClientePedidoDtoCol(Collection<RecetaClientePedidoDTO> recetaClientePedidoDtoCol) {
		this.recetaClientePedidoDtoCol = recetaClientePedidoDtoCol;
	}
	public String getIdApp() {
		return idApp;
	}
	public void setIdApp(String idAppAux) {
		String idApp = idAppAux;
		if(idApp!=null && idApp.length()>32){
			idApp=idApp.substring(0, 31);
		}
		this.idApp = idApp;
	}

	/**
	 * @return the nombreCatalogoValor
	 */
	public String getNombreCatalogoValor() {
		return nombreCatalogoValor;
	}
	public void setNombreCatalogoValor(String nombreCatalogoValor) {
		this.nombreCatalogoValor = nombreCatalogoValor;
	}
	public ListaRecetaDTO clone() throws CloneNotSupportedException{
		ListaRecetaDTO listaRecetaDTOClone = (ListaRecetaDTO)super.clone();
		listaRecetaDTOClone.setId(id.clone());
		return listaRecetaDTOClone;
	}
	public Map<String, ComparatorTypeEnum> getComparatorTypeEnum() {
		return comparatorTypeEnum;
	}
	public void setComparatorTypeEnum(Map<String, ComparatorTypeEnum> comparatorTypeEnum) {
		this.comparatorTypeEnum = comparatorTypeEnum;
	}
}
