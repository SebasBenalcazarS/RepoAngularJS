package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;

@SuppressWarnings("serial")
@MappedSuperclass
public class ClienteImportacionAbstract<T extends BaseID> extends AuditoriaBaseDTO<T>{
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "SIGLAS")
	private String siglas;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "CODIGOCLIENTEFACTURACION")
	private Long codigoClienteFacturacion;
	
	@OneToMany(mappedBy = "clienteImportacion")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ClienteImportacionCompradorDTO> compradores;
	
	@OneToMany(mappedBy = "clienteImportacion")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<CondicionGastoEmbarqueDTO> condicionesGastoEmbarque;
	
	
	public Long getCodigoClienteFacturacion() {
		return codigoClienteFacturacion;
	}

	public void setCodigoClienteFacturacion(Long codigoClienteFacturacion) {
		this.codigoClienteFacturacion = codigoClienteFacturacion;
	}

	/**
	 * @return devuelve el valor de la propiedad nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre establece el valor a la propiedad nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return devuelve el valor de la propiedad siglas
	 */
	public String getSiglas() {
		return siglas;
	}

	/**
	 * @param siglas establece el valor a la propiedad siglas
	 */
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	/**
	 * @return devuelve el valor de la propiedad estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado establece el valor a la propiedad estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return devuelve el valor de la propiedad compradores
	 */
	public Collection<ClienteImportacionCompradorDTO> getCompradores() {
		return compradores;
	}

	/**
	 * @param compradores establece el valor a la propiedad compradores
	 */
	public void setCompradores(
			Collection<ClienteImportacionCompradorDTO> compradores) {
		this.compradores = compradores;
	}

	/**
	 * @return the condicionesGastoEmbarque
	 */
	public Collection<CondicionGastoEmbarqueDTO> getCondicionesGastoEmbarque() {
		return condicionesGastoEmbarque;
	}

	/**
	 * @param condicionesGastoEmbarque the condicionesGastoEmbarque to set
	 */
	public void setCondicionesGastoEmbarque(Collection<CondicionGastoEmbarqueDTO> condicionesGastoEmbarque) {
		this.condicionesGastoEmbarque = condicionesGastoEmbarque;
	}

}
