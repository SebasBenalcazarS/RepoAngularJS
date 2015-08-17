package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;

import ec.com.smx.interfaz.jde.mdl.vo.InterfazBase;
import ec.com.smx.interfaz.jde.mdl.vo.InterfazComplemento;
import ec.com.smx.interfaz.jde.mdl.vo.InterfazCuentaPorPagar;

/**
 * Permite almacenar las estructuras para enviar al JDE
 * @author fcollaguazo
 *
 */
public class InterfacesEstructurasJDE {

	private Collection<InterfazBase> f0911Col;
	
	private Collection<InterfazCuentaPorPagar> f0411Col;
	
	private Collection<InterfazComplemento> f550411Col;

	public Collection<InterfazBase> getF0911Col() {
		return f0911Col;
	}

	public void setF0911Col(Collection<InterfazBase> f0911Col) {
		this.f0911Col = f0911Col;
	}

	public Collection<InterfazCuentaPorPagar> getF0411Col() {
		return f0411Col;
	}

	public void setF0411Col(Collection<InterfazCuentaPorPagar> f0411Col) {
		this.f0411Col = f0411Col;
	}

	public Collection<InterfazComplemento> getF550411Col() {
		return f550411Col;
	}

	public void setF550411Col(Collection<InterfazComplemento> f550411Col) {
		this.f550411Col = f550411Col;
	}
}
