/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.CaracteristicaPedidoID;

/**
 * @author fnaranjo
 *
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.CaracteristicaPedidoDTO")
@Table(name = "SSB2BTCARPED")
@Deprecated
public class CaracteristicaPedidoDTO extends SimpleAuditDTO{
	//id
	@EmbeddedId
	private CaracteristicaPedidoID id;

	@Column(name = "IDUSUARIOREGISTRO")
	private String registerUserId;
	
	@Column(name = "FECHAREGISTRO")
	private Timestamp registerDate;
	
	@Column(name = "IDUSUARIOACTUALIZACION")
	private String lastModifierUserId;
	
	@Column(name = "FECHAACTUALIZACION")
	private Timestamp lastModificationDate;
	
	@Column(name = "NOMBRE")
	private String name;

	
	/**
	 * @return el id
	 */
	public CaracteristicaPedidoID getId() {
		return id;
	}

	/**
	 * @param id el id a establecer
	 */
	public void setId(CaracteristicaPedidoID id) {
		this.id = id;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
