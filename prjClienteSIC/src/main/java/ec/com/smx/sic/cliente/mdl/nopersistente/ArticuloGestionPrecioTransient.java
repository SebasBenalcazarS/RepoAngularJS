package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ec.com.smx.sic.cliente.common.annotation.Compare;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.BaseComparator;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.SeveridadConflictoArticulo;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;


/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public abstract class ArticuloGestionPrecioTransient extends BaseComparator {
	
	// Datos calculados
	protected Double precioSMXNoAfiliadoAnterior;
	@Compare  
	protected Double precioSMXNoAfiliadoNuevo;

	private Boolean aplicar = Boolean.TRUE;
	private Boolean esEditable;
	private Boolean seleccionar;
	private Boolean existeConflicto;
	private Boolean existeValidacionConflicto;
	private Boolean existeMensajeValidacionConflicto;
	private Boolean existeProveedorRelacionado;
	private Boolean tieneArticulosRelacionados;
	private Boolean unificarCostoProveedores;
	private Boolean existePrecioDiferenciado;
	private Boolean eliminarPVP;
	
	protected String valorTipoEstadoEtiqueta;

	private Map<String, Set<String>> relacionesArticulos;
	private Map<SeveridadConflictoArticulo, Set<String>> mensajesConflictosArticulo;

	private ArticuloGestionPrecioDTO articuloGestionPrecioRelacionado;
	protected ArticuloProveedorGestionPrecioDTO articuloProveedorBaseGestionPrecio;

	protected Collection<ArticuloProveedorGestionPrecioDTO> articuloProveedoresGestionPrecioRelacionados;
	private Collection<DatosOrdenCompra> ordenesCompra;

	private Set<EnumCaracteristicaDinamica> reglasCalculoPrecios;

	protected Double pvpAnteriorVsPsmxAnterior;
	protected Double pvpNuevoVsPsmxNuevo;
	
	protected Double variacionVenta;
	protected Double porcentajeVariacionVenta;
	
	/**
	 * @return the aplicar
	 */
	public Boolean getAplicar() {
		return aplicar;
	}

	/**
	 * @param aplicar the aplicar to set
	 */
	public void setAplicar(Boolean aplicar) {
		this.aplicar = aplicar;
	}

	/**
	 * @return the seleccionar
	 */
	public Boolean getSeleccionar() {
		return seleccionar;
	}

	/**
	 * @param seleccionar the seleccionar to set
	 */
	public void setSeleccionar(Boolean seleccionar) {
		this.seleccionar = seleccionar;
	}

	/**
	 * @return the existeConflicto
	 */
	public Boolean getExisteConflicto() {
		return existeConflicto;
	}

	/**
	 * @param existeConflicto the existeConflicto to set
	 */
	public void setExisteConflicto(Boolean existeConflicto) {
		this.existeConflicto = existeConflicto;
	}

	/**
	 * @return the existeValidacionConflicto
	 */
	public Boolean getExisteValidacionConflicto() {
		return existeValidacionConflicto;
	}

	/**
	 * @param existeValidacionConflicto the existeValidacionConflicto to set
	 */
	public void setExisteValidacionConflicto(Boolean existeValidacionConflicto) {
		this.existeValidacionConflicto = existeValidacionConflicto;
	}

	/**
	 * @return the existeProveedorRelacionado
	 */
	public Boolean getExisteProveedorRelacionado() {
		return existeProveedorRelacionado;
	}

	/**
	 * @param existeProveedorRelacionado the existeProveedorRelacionado to set
	 */
	public void setExisteProveedorRelacionado(Boolean existeProveedorRelacionado) {
		this.existeProveedorRelacionado = existeProveedorRelacionado;
	}

	/**
	 * @return the tieneArticulosRelacionados
	 */
	public Boolean getTieneArticulosRelacionados() {
		return tieneArticulosRelacionados;
	}

	/**
	 * @param tieneArticulosRelacionados the tieneArticulosRelacionados to set
	 */
	public void setTieneArticulosRelacionados(Boolean tieneArticulosRelacionados) {
		this.tieneArticulosRelacionados = tieneArticulosRelacionados;
	}

	/**
	 * @return the relacionesArticulos
	 */
	public Map<String, Set<String>> getRelacionesArticulos() {
		return relacionesArticulos;
	}

	/**
	 * @param relacionesArticulos the relacionesArticulos to set
	 */
	public void setRelacionesArticulos(Map<String, Set<String>> relacionesArticulos) {
		this.relacionesArticulos = relacionesArticulos;
	}

	/**
	 * @return the articuloGestionPrecioRelacionado
	 */
	public ArticuloGestionPrecioDTO getArticuloGestionPrecioRelacionado() {
		return articuloGestionPrecioRelacionado;
	}

	/**
	 * @param articuloGestionPrecioRelacionado the articuloGestionPrecioRelacionado to set
	 */
	public void setArticuloGestionPrecioRelacionado(ArticuloGestionPrecioDTO articuloGestionPrecioRelacionado) {
		this.articuloGestionPrecioRelacionado = articuloGestionPrecioRelacionado;
	}

	/**
	 * @return the mensajesConflictosArticulo
	 */
	public Map<SeveridadConflictoArticulo, Set<String>> getMensajesConflictosArticulo() {
		return mensajesConflictosArticulo;
	}

	/**
	 * @param mensajesConflictosArticulo the mensajesConflictosArticulo to set
	 */
	public void setMensajesConflictosArticulo(Map<SeveridadConflictoArticulo, Set<String>> mensajesConflictosArticulo) {
		this.mensajesConflictosArticulo = mensajesConflictosArticulo;
	}

	/**
	 * @return the esEditable
	 */
	public Boolean getEsEditable() {
		return esEditable;
	}

	/**
	 * @param esEditable the esEditable to set
	 */
	public void setEsEditable(Boolean esEditable) {
		this.esEditable = esEditable;
	}

	/**
	 * @return the ordenesCompra
	 */
	public Collection<DatosOrdenCompra> getOrdenesCompra() {
		return ordenesCompra;
	}

	/**
	 * @param ordenesCompra the ordenesCompra to set
	 */
	public void setOrdenesCompra(Collection<DatosOrdenCompra> ordenesCompra) {
		this.ordenesCompra = ordenesCompra;
	}

	/**
	 * @return the existeMensajeValidacionConflicto
	 */
	public Boolean getExisteMensajeValidacionConflicto() {
		return existeMensajeValidacionConflicto;
	}

	/**
	 * @param existeMensajeValidacionConflicto the existeMensajeValidacionConflicto to set
	 */
	public void setExisteMensajeValidacionConflicto(Boolean existeMensajeValidacionConflicto) {
		this.existeMensajeValidacionConflicto = existeMensajeValidacionConflicto;
	}

	/**
	 * @return the unificarCostoProveedores
	 */
	public Boolean getUnificarCostoProveedores() {
		return unificarCostoProveedores;
	}

	/**
	 * @param unificarCostoProveedores the unificarCostoProveedores to set
	 */
	public void setUnificarCostoProveedores(Boolean unificarCostoProveedores) {
		this.unificarCostoProveedores = unificarCostoProveedores;
	}

	/**
	 * @return the reglasCalculoPrecios
	 */
	public Set<EnumCaracteristicaDinamica> getReglasCalculoPrecios() {
		return reglasCalculoPrecios;
	}

	/**
	 * @param reglasCalculoPrecios the reglasCalculoPrecios to set
	 */
	public void setReglasCalculoPrecios(Set<EnumCaracteristicaDinamica> reglasCalculoPrecios) {
		this.reglasCalculoPrecios = reglasCalculoPrecios;
	}

	public Boolean getExistePrecioDiferenciado() {
		return existePrecioDiferenciado;
	}

	public void setExistePrecioDiferenciado(Boolean existePrecioDiferenciado) {
		this.existePrecioDiferenciado = existePrecioDiferenciado;
	}

	/**
	 * @return the eliminarPVP
	 */
	public Boolean getEliminarPVP() {
		return eliminarPVP;
	}

	/**
	 * @param eliminarPVP the eliminarPVP to set
	 */
	public void setEliminarPVP(Boolean eliminarPVP) {
		this.eliminarPVP = eliminarPVP;
	}

}
