package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

import java.util.Collection;

/**
 * @author ediaz
 *
 */

public class BinesTarjetas {

	Collection<BinTarjeta> insert;
	Collection<BinTarjeta> update;
	Collection<BinTarjeta> delete;
	Collection<BinTarjetaDelete> deleteCards;

	public Collection<BinTarjeta> getInsert() {
		return insert;
	}

	public void setInsert(Collection<BinTarjeta> insert) {
		this.insert = insert;
	}

	public Collection<BinTarjeta> getUpdate() {
		return update;
	}

	public void setUpdate(Collection<BinTarjeta> update) {
		this.update = update;
	}

	public Collection<BinTarjeta> getDelete() {
		return delete;
	}

	public void setDelete(Collection<BinTarjeta> delete) {
		this.delete = delete;
	}

	public Collection<BinTarjetaDelete> getDeleteCards() {
		return deleteCards;
	}

	public void setDeleteCards(Collection<BinTarjetaDelete> deleteCards) {
		this.deleteCards = deleteCards;
	}

}
