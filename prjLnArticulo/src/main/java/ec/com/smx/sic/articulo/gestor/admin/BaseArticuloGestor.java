/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloRegistroGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.IArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloBitacora.IArticuloBitacoraGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloComercial.IArticuloComercialGestor;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.IArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author gaortiz, mgranda
 *
 */
public abstract class BaseArticuloGestor implements IArticuloRegistroGestor{
	
	protected IArticuloUnidadManejoGestor articuloUnidadManejoGestor;
	protected DataGestor dataGestor;
	protected ICalculoArticuloGestor calculoArticuloGestor;	
	protected IArticuloComercialGestor articuloComercialGestor;
	protected IArticuloAlcanceGestor articuloAlcanceGestor;
	protected IArticuloBitacoraGestor articuloBitacoraGestor;
	protected IArticuloProveedorGestor articuloProveedorGestor;
	
	protected abstract void registrarArticuloGeneral(ArticuloVO articuloVO,Boolean esCreacion)throws SICException;
	
	/**
	 * @param articuloUnidadManejoGestor the articuloUnidadManejoGestor to set
	 */
	public final void setArticuloUnidadManejoGestor(IArticuloUnidadManejoGestor articuloUnidadManejoGestor) {
		this.articuloUnidadManejoGestor = articuloUnidadManejoGestor;
	}
	/**
	 * @param dataGestor the dataGestor to set
	 */
	public final void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	/**
	 * @param calculoArticuloGestor the calculoArticuloGestor to set
	 */
	public final void setCalculoArticuloGestor(ICalculoArticuloGestor calculoArticuloGestor) {
		this.calculoArticuloGestor = calculoArticuloGestor;
	}

	public final void setArticuloComercialGestor(IArticuloComercialGestor articuloComercialGestor) {
		this.articuloComercialGestor = articuloComercialGestor;
	}

	public final void setArticuloAlcanceGestor(IArticuloAlcanceGestor articuloAlcanceGestor) {
		this.articuloAlcanceGestor = articuloAlcanceGestor;
	}

	public final void setArticuloBitacoraGestor(IArticuloBitacoraGestor articuloBitacoraGestor) {
		this.articuloBitacoraGestor = articuloBitacoraGestor;
	}

	/**
	 * @param articuloProveedorGestor the articuloProveedorGestor to set
	 */
	public void setArticuloProveedorGestor(IArticuloProveedorGestor articuloProveedorGestor) {
		this.articuloProveedorGestor = articuloProveedorGestor;
	}

	
}
