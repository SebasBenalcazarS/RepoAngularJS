package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.BinTarjetaID;

/**
 * @author ediaz
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSACTBINTARJETA")
public class BinTarjetaDTO extends SimpleAuditDTO {
	@EmbeddedId
	private BinTarjetaID id;
	private String estado;
	private String descripcion;
	private Integer rangoInicial;
	private Integer rangoFinal;
	
	@RegisterUserIdField
	@Column(updatable = false)
	private String usuarioRegistro;

	@RegisterUserIdField
	@Column(updatable = false)
	private Timestamp fechaRegistro;

	@LastModifierUserIdField
	@Column(updatable = false)
	private String usuarioModificacion;

	@LastModifierUserIdField
	@Column(updatable = false)
	private Timestamp fechaModificacion;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "binTarjetaDTO", cascade = CascadeType.ALL)
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<BinTarjetaDefinicionArchivoDTO> binTarjetaDefinicionArchivoDTOs;


	public BinTarjetaID getId() {
		return id;
	}


	public void setId(BinTarjetaID id) {
		this.id = id;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getRangoInicial() {
		return rangoInicial;
	}


	public void setRangoInicial(Integer rangoInicial) {
		this.rangoInicial = rangoInicial;
	}


	public Integer getRangoFinal() {
		return rangoFinal;
	}


	public void setRangoFinal(Integer rangoFinal) {
		this.rangoFinal = rangoFinal;
	}


	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}


	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}


	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}


	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}


	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public Collection<BinTarjetaDefinicionArchivoDTO> getBinTarjetaDefinicionArchivoDTOs() {
		return binTarjetaDefinicionArchivoDTOs;
	}


	public void setBinTarjetaDefinicionArchivoDTOs(Collection<BinTarjetaDefinicionArchivoDTO> binTarjetaDefinicionArchivoDTOs) {
		this.binTarjetaDefinicionArchivoDTOs = binTarjetaDefinicionArchivoDTOs;
	}
	
	
}