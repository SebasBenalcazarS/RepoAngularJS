package ec.com.smx.sic.cliente.mdl.dto.b2b;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.DetalleOrdenCompraDescuentoID;

/**
 * Registra los descuentos correpondientes a un detalle de Orden de Compra
 * 
 * @author kruger
 * @author jbalcazar
 */

@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.DetalleOrdenCompraDescuentoDTO")
@Table(name = "SSB2BTDETORDCOMDES")
@SuppressWarnings("serial")
@Deprecated
public class DetalleOrdenCompraDescuentoDTO extends SimpleAuditDTO {

	@Id
	@EmbeddedId
	DetalleOrdenCompraDescuentoID id = new DetalleOrdenCompraDescuentoID();

	/**
	 * El codigo correspondiente al descuento en la tabla TipoDecsuento del
	 * SISPE
	 */
	private String codigoTipoDescuento;

	/**
	 * Valor correspondiente al descuento
	 * 
	 */
	private Double valorDescuento;
	
	@Column(name = "IDUSUARIOREGISTRO")
	private String registerUserId;
	
	@Column(name = "FECHAREGISTRO")
	private Timestamp registerDate;
	
	@Column(name = "IDUSUARIOACTUALIZACION")
	private String lastModifierUserId;
	
	@Column(name = "FECHAACTUALIZACION")
	private Timestamp lastModificationDate;
	
	/**
	 * unidad de manejo del aticulo.
	 * 
	 */
	private Long unidadManejo;
	
	/**
	 * Valor correspondiente al descuento modificables para cálculos
	 * 
	 */
	@Transient
	private Double valorDescuentoTmp = new Double(0);
	
	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOPEDIDO", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
			@JoinColumn(name = "SECDETORDCOM", referencedColumnName = "SECDETORDCOM", insertable = false, updatable = false)})
	private DetalleOrdenCompraDTO detalleOrdenCompraDTO;

	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPODESCUENTO", referencedColumnName = "CODIGOTIPODESCUENTO", insertable = false, updatable = false)
	})
	private TipoDescuentoDTO tipoDescuentoDTO;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public DetalleOrdenCompraDescuentoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(DetalleOrdenCompraDescuentoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoDescuento</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoDescuento</code>
	 */
	public String getCodigoTipoDescuento() {
		return this.codigoTipoDescuento;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>codigoTipoDescuento</code>.
	 * 
	 * @param codigoTipoDescuento1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoTipoDescuento</code>.
	 */
	public void setCodigoTipoDescuento(String codigoTipoDescuento1) {
		this.codigoTipoDescuento = codigoTipoDescuento1;

		if (codigoTipoDescuento != null && codigoTipoDescuento.length() > 10) {
			codigoTipoDescuento = codigoTipoDescuento.substring(0, 10);
		}
	}

	/**
	 * Retorna valor de propiedad <code>valorDescuento</code>
	 * 
	 * @return Retorna valor de propiedad <code>valorDescuento</code>
	 */
	public Double getValorDescuento() {
		return this.valorDescuento;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorDescuento</code>.
	 * 
	 * @param valorDescuento1
	 *            El valor a establecer para la propiedad
	 *            <code>valorDescuento</code>.
	 */
	public void setValorDescuento(Double valorDescuento1) {
		this.valorDescuento = valorDescuento1;
	}

	public Double getValorDescuentoTmp() {
		if (valorDescuentoTmp == 0)
			return (valorDescuento);
		else
			return valorDescuentoTmp;
	}

	public void setValorDescuentoTmp(Double valorDescuentoTmp) {
		this.valorDescuentoTmp = valorDescuentoTmp;
	}

	/**
	 * @return the detalleOrdenCompraDTO
	 */
	public DetalleOrdenCompraDTO getDetalleOrdenCompraDTO() {
		return detalleOrdenCompraDTO;
	}

	/**
	 * @param detalleOrdenCompraDTO
	 *            the detalleOrdenCompraDTO to set
	 */
	public void setDetalleOrdenCompraDTO(DetalleOrdenCompraDTO detalleOrdenCompraDTO) {
		this.detalleOrdenCompraDTO = detalleOrdenCompraDTO;
	}

	/**
	 * @return the tipoDescuentoDTO
	 */
	public TipoDescuentoDTO getTipoDescuentoDTO() {
		return tipoDescuentoDTO;
	}

	/**
	 * @param tipoDescuentoDTO
	 *            the tipoDescuentoDTO to set
	 */
	public void setTipoDescuentoDTO(TipoDescuentoDTO tipoDescuentoDTO) {
		this.tipoDescuentoDTO = tipoDescuentoDTO;
	}

	/**
	 * @return the registerUserId
	 */
	public String getRegisterUserId() {
		return registerUserId;
	}

	/**
	 * @param registerUserId the registerUserId to set
	 */
	public void setRegisterUserId(String registerUserId) {
		this.registerUserId = registerUserId;
	}

	/**
	 * @return the registerDate
	 */
	public Timestamp getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the lastModifierUserId
	 */
	public String getLastModifierUserId() {
		return lastModifierUserId;
	}

	/**
	 * @param lastModifierUserId the lastModifierUserId to set
	 */
	public void setLastModifierUserId(String lastModifierUserId) {
		this.lastModifierUserId = lastModifierUserId;
	}

	/**
	 * @return the lastModificationDate
	 */
	public Timestamp getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Timestamp lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	/**
	 * @return the unidadManejo
	 */
	public Long getUnidadManejo() {
		return unidadManejo;
	}

	/**
	 * @param unidadManejo the unidadManejo to set
	 */
	public void setUnidadManejo(Long unidadManejo) {
		this.unidadManejo = unidadManejo;
	}
}
