package ec.com.smx.sic.cliente.mdl.dto.articulo.auditoria;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.AccessItemDto;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;

/**
 * 
 * @author corbe
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTAUD")
public class ArticuloAuditoriaDTO extends SimpleAuditDTO{

	
	@EmbeddedId
	private ArticuloID id = new ArticuloID();
	
	@Column(name = "CODOPCCRE")
	private String codigoOpcionCreacion;
	
	@Column(name = "CODSISCRE")
	private String codigoSistemaCreacion;
	
	@Column(name = "CODOPCACT")
	private String codigoOpcionActualizacion;
	
	@Column(name = "CODSISACT")
	private String codigoSistemaActualizacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
	@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODSISCRE", insertable=false, updatable=false, referencedColumnName="SYSID"),
		@JoinColumn(name="CODOPCCRE", referencedColumnName="ACCITEID", insertable=false, updatable=false)})
	private AccessItemDto opcionCreacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODSISACT", insertable=false, updatable=false, referencedColumnName="SYSID"),
		@JoinColumn(name="CODOPCACT", referencedColumnName="ACCITEID", insertable=false, updatable=false)})
	private AccessItemDto opcionActualizacion;
	
	public ArticuloID getId() {
		return id;
	}

	public void setId(ArticuloID id) {
		this.id = id;
	}
	
	public String getCodigoOpcionCreacion() {
		return codigoOpcionCreacion;
	}

	public void setCodigoOpcionCreacion(String codigoOpcionCreacion) {
		this.codigoOpcionCreacion = codigoOpcionCreacion;
	}

	public String getCodigoSistemaCreacion() {
		return codigoSistemaCreacion;
	}

	public void setCodigoSistemaCreacion(String codigoSistemaCreacion) {
		this.codigoSistemaCreacion = codigoSistemaCreacion;
	}

	public String getCodigoOpcionActualizacion() {
		return codigoOpcionActualizacion;
	}

	public void setCodigoOpcionActualizacion(String codigoOpcionActualizacion) {
		this.codigoOpcionActualizacion = codigoOpcionActualizacion;
	}

	public String getCodigoSistemaActualizacion() {
		return codigoSistemaActualizacion;
	}

	public void setCodigoSistemaActualizacion(String codigoSistemaActualizacion) {
		this.codigoSistemaActualizacion = codigoSistemaActualizacion;
	}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}
	
}
