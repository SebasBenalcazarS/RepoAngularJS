package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionID;


/**
 * Se almacena el detalle seccion de un funcionario que pertenece a una subbodega determinada y para un proceso especifico
 * Registrado por la pantalla de asignacion de perfiles a usuarios de recepcion bodegas del MAX
 * @author acaiza, cescobar, dalmeida
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTFUNPROPERARETRADETSEC")
public class FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionID id = new FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionID();
	
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPERFIL", referencedColumnName = "CODIGOPERFIL", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAREASUBLUGARTRABAJO", referencedColumnName = "CODIGOAREASUBLUGARTRABAJO", insertable = false, updatable = false)
	})
	private FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLESECCIONINICIO", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionInicioDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLESECCIONFIN", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionFinDTO;
	
	@Column(name = "CODIGODETALLESECCIONFIN")
	private Long codigoDetalleSeccionFin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
	})
	private ec.com.smx.corpv2.dto.FuncionarioDTO funcionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
	})
	private ec.com.smx.corpv2.dto.ProcesoDTO proceso;
	
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the id
	 */
	public FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionID id) {
		this.id = id;
	}

	/**
	 * @return the funcionarioProcesoPerfilAreaTrabajoDTO
	 */
	public ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO getFuncionarioProcesoPerfilAreaTrabajoDTO() {
		return funcionarioProcesoPerfilAreaTrabajoDTO;
	}

	/**
	 * @param funcionarioProcesoPerfilAreaTrabajoDTO the funcionarioProcesoPerfilAreaTrabajoDTO to set
	 */
	public void setFuncionarioProcesoPerfilAreaTrabajoDTO(ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) {
		this.funcionarioProcesoPerfilAreaTrabajoDTO = funcionarioProcesoPerfilAreaTrabajoDTO;
	}

	/**
	 * @return the detalleSeccionInicioDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionInicioDTO() {
		return detalleSeccionInicioDTO;
	}

	/**
	 * @param detalleSeccionInicioDTO the detalleSeccionInicioDTO to set
	 */
	public void setDetalleSeccionInicioDTO(DetalleSeccionDTO detalleSeccionInicioDTO) {
		this.detalleSeccionInicioDTO = detalleSeccionInicioDTO;
	}

	/**
	 * @return the detalleSeccionFinDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionFinDTO() {
		return detalleSeccionFinDTO;
	}

	/**
	 * @param detalleSeccionFinDTO the detalleSeccionFinDTO to set
	 */
	public void setDetalleSeccionFinDTO(DetalleSeccionDTO detalleSeccionFinDTO) {
		this.detalleSeccionFinDTO = detalleSeccionFinDTO;
	}

	/**
	 * @return the codigoDetalleSeccionFin
	 */
	public Long getCodigoDetalleSeccionFin() {
		return codigoDetalleSeccionFin;
	}

	/**
	 * @param codigoDetalleSeccionFin the codigoDetalleSeccionFin to set
	 */
	public void setCodigoDetalleSeccionFin(Long codigoDetalleSeccionFin) {
		this.codigoDetalleSeccionFin = codigoDetalleSeccionFin;
	}

	/**
	 * @return the funcionario 
	 */
	public ec.com.smx.corpv2.dto.FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(ec.com.smx.corpv2.dto.FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the proceso
	 */
	public ec.com.smx.corpv2.dto.ProcesoDTO getProceso() {
		return proceso;
	}

	/**
	 * @param proceso the proceso to set
	 */
	public void setProceso(ec.com.smx.corpv2.dto.ProcesoDTO proceso) {
		this.proceso = proceso;
	}

	
}
