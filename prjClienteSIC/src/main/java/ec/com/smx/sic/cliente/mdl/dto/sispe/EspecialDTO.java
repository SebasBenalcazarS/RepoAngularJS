package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.EspecialID;

@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.EspecialDTO")
@Table(name = "SCSPETESPECIAL")
public class EspecialDTO extends AuditoriaBaseDTO<EspecialID> {
	
	private String descripcionEspecial;
	private String estadoEspecial;
	private String publicado;
	private String codigoTipoPedido;
	private String codigoBodega;

	@Transient
	private Integer npCodigoLocal;

	@Transient
	private Collection<ArticuloDTO> articulos;

	@Transient
	private Collection<EspecialClasificacionDTO> especialesClasificaciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@javax.persistence.JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@javax.persistence.JoinColumn(name = "CODIGOTIPOPEDIDO", referencedColumnName = "CODIGOTIPOPEDIDO", insertable = false, updatable = false) })
	private TipoPedidoDTO tipoPedidoDTO;

	public EspecialDTO() {
		EspecialID especialID = new EspecialID();
		setId(especialID);
	}

	public EspecialDTO (Boolean valor) {
		this.id = new EspecialID(valor);
	}
	
	public String getDescripcionEspecial() {
		return this.descripcionEspecial;
	}

	public void setDescripcionEspecial(String descripcionEspecial) {
		this.descripcionEspecial = descripcionEspecial;
	}

	public String getEstadoEspecial() {
		return this.estadoEspecial;
	}

	public void setEstadoEspecial(String estadoEspecial) {
		this.estadoEspecial = estadoEspecial;
	}

	public String getPublicado() {
		return this.publicado;
	}

	public void setPublicado(String publicado) {
		this.publicado = publicado;
	}

	public Integer getNpCodigoLocal() {
		return this.npCodigoLocal;
	}

	public void setNpCodigoLocal(Integer npCodigoLocal) {
		this.npCodigoLocal = npCodigoLocal;
	}

	public EspecialID getId() {
		return ((EspecialID) this.id);
	}

	public void setId(EspecialID id) {
		this.id = id;
	}

	public Collection<ArticuloDTO> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(Collection<ArticuloDTO> articulos) {
		this.articulos = articulos;
	}

	public String getCodigoTipoPedido() {
		return this.codigoTipoPedido;
	}

	public void setCodigoTipoPedido(String codigoTipoPedido) {
		this.codigoTipoPedido = codigoTipoPedido;
	}

	public TipoPedidoDTO getTipoPedidoDTO() {
		return this.tipoPedidoDTO;
	}

	public void setTipoPedidoDTO(TipoPedidoDTO tipoPedidoDTO) {
		this.tipoPedidoDTO = tipoPedidoDTO;
	}

	public String getCodigoBodega() {
		return this.codigoBodega;
	}

	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	public Collection<EspecialClasificacionDTO> getEspecialesClasificaciones() {
		return this.especialesClasificaciones;
	}

	public void setEspecialesClasificaciones(
			Collection<EspecialClasificacionDTO> especialesClasificaciones) {
		this.especialesClasificaciones = especialesClasificaciones;
	}
}