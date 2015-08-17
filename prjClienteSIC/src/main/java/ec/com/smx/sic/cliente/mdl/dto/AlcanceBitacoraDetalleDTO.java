package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ShardDiscriminator;
import ec.com.kruger.utilitario.dao.commons.annotations.ShardDiscriminatorColumn;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ShardDiscriminatorType;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.AlcanceBitacoraDetalleID;

/**
 * @author gnolivos
 *
 */

@Entity
@Table(name="SCSADTALCBITDET")
@ShardDiscriminator(type=ShardDiscriminatorType.TABLE_SUFFIX,concatenator="",discriminatorColumn=@ShardDiscriminatorColumn(fieldDiscriminator="tipoAreaTrabajo"))
@SuppressWarnings("serial")
public class AlcanceBitacoraDetalleDTO extends SimpleAuditDTO{

	@EmbeddedId
	private AlcanceBitacoraDetalleID id = new AlcanceBitacoraDetalleID();
	
	@Transient
	private String tipoAreaTrabajo=SICConstantes.getInstancia().SUFIJO_TIPO_AREA_TRABAJO_LOCAL;
	
	/**
	 * 
	 */
	@Column(name = "DESCRIPCIONERROR")
	private String descripcionError;

	public AlcanceBitacoraDetalleID getId() {
		return id;
	}
	
	public void setId(AlcanceBitacoraDetalleID id) {
		this.id = id;
	}

	public String getDescripcionError() {
		return descripcionError;
	}

	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

	public String getTipoAreaTrabajo() {
		return tipoAreaTrabajo;
	}

	public void setTipoAreaTrabajo(String tipoAreaTrabajo) {
		this.tipoAreaTrabajo = tipoAreaTrabajo;
	}
	
}
