/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCatalogoTareaRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaMonitorMontacargaCorredorDTO;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public class VistaMonitorMontacargaCorredorVO extends BaseVO<VistaMonitorMontacargaCorredorDTO>{
	
	private Collection<VistaMonitorMontacargaCorredorDTO> colMonitorMontacargaCorredor;
	
	// Filtros de busqueda
	private Integer codigoCompania;
	private Integer codigoAreaTrabajo;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubBodega;
	//perfil recolector/montacargista
	private String referenceCode;
	//estado de la tarea
	private String estadoProceso;
	private String estadoPallet;
	private String usuario;
//	private String nave;
	private String andenPasilloDesde;
	private String andenPasilloHasta;
	
	// Datos que se muestran en pantalla
//	private String naveMostrar;
	private Integer pasilloDesdeMostrar;
	private Integer pasilloHastaMostrar;
	
	private Collection<VistaCatalogoTareaRecepcionDTO> colEstadoProcesoMonitorMontacarga;
	
	// Paginacion de resultados
	private Integer totalRegistros;
	
	private Long codigoNave;
	private Long codigoSubnave;
	
	//Codigos de barras de pallets ingresados
	private Collection<String> codigoBarrasPallets;
	//Codigos de barras de articulos ingresados
	private Collection<String> codigoBarrasArticulos;
	
	/**
	 * @return the colMonitorMontacargaCorredor
	 */
	public Collection<VistaMonitorMontacargaCorredorDTO> getColMonitorMontacargaCorredor() {
		return colMonitorMontacargaCorredor;
	}
	
	/**
	 * @param colMonitorMontacargaCorredor the colMonitorMontacargaCorredor to set
	 */
	public void setColMonitorMontacargaCorredor(Collection<VistaMonitorMontacargaCorredorDTO> colMonitorMontacargaCorredor) {
		this.colMonitorMontacargaCorredor = colMonitorMontacargaCorredor;
	}
	
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}
	
	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
	
	/**
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}
	
	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}
	
	/**
	 * @return the codigoAreaTrabajoSubBodega
	 */
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}
	
	/**
	 * @param codigoAreaTrabajoSubBodega the codigoAreaTrabajoSubBodega to set
	 */
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}
	
	/**
	 * @return the totalRegistros
	 */
	public Integer getTotalRegistros() {
		return totalRegistros;
	}
	
	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	/**
	 * @return the referenceCode
	 */
	public String getReferenceCode() {
		return referenceCode;
	}

	/**
	 * @param referenceCode the referenceCode to set
	 */
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	/**
	 * @return the estadoProceso
	 */
	public String getEstadoProceso() {
		return estadoProceso;
	}

	/**
	 * @param estadoProceso the estadoProceso to set
	 */
	public void setEstadoProceso(String estadoProceso) {
		this.estadoProceso = estadoProceso;
	}

	/**
	 * @return the colEstadoProcesoMonitorMontacarga
	 */
	public Collection<VistaCatalogoTareaRecepcionDTO> getColEstadoProcesoMonitorMontacarga() {
		return colEstadoProcesoMonitorMontacarga;
	}

	/**
	 * @param colEstadoProcesoMonitorMontacarga the colEstadoProcesoMonitorMontacarga to set
	 */
	public void setColEstadoProcesoMonitorMontacarga(Collection<VistaCatalogoTareaRecepcionDTO> colEstadoProcesoMonitorMontacarga) {
		this.colEstadoProcesoMonitorMontacarga = colEstadoProcesoMonitorMontacarga;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nave
	 */
//	public String getNave() {
//		return nave;
//	}
//
//	/**
//	 * @param nave the nave to set
//	 */
//	public void setNave(String nave) {
//		this.nave = nave;
//	}

	/**
	 * @return the andenPasilloDesde
	 */
	public String getAndenPasilloDesde() {
		return andenPasilloDesde;
	}

	/**
	 * @param andenPasilloDesde the andenPasilloDesde to set
	 */
	public void setAndenPasilloDesde(String andenPasilloDesde) {
		this.andenPasilloDesde = andenPasilloDesde;
	}

	/**
	 * @return the andenPasilloHasta
	 */
	public String getAndenPasilloHasta() {
		return andenPasilloHasta;
	}

	/**
	 * @param andenPasilloHasta the andenPasilloHasta to set
	 */
	public void setAndenPasilloHasta(String andenPasilloHasta) {
		this.andenPasilloHasta = andenPasilloHasta;
	}

//	/**
//	 * @return the naveMostrar
//	 */
//	public String getNaveMostrar() {
//		return naveMostrar;
//	}
//
//	/**
//	 * @param naveMostrar the naveMostrar to set
//	 */
//	public void setNaveMostrar(String naveMostrar) {
//		this.naveMostrar = naveMostrar;
//	}

	/**
	 * @return the pasilloDesdeMostrar
	 */
	public Integer getPasilloDesdeMostrar() {
		return pasilloDesdeMostrar;
	}

	/**
	 * @param pasilloDesdeMostrar the pasilloDesdeMostrar to set
	 */
	public void setPasilloDesdeMostrar(Integer pasilloDesdeMostrar) {
		this.pasilloDesdeMostrar = pasilloDesdeMostrar;
	}

	/**
	 * @return the pasilloHastaMostrar
	 */
	public Integer getPasilloHastaMostrar() {
		return pasilloHastaMostrar;
	}

	/**
	 * @param pasilloHastaMostrar the pasilloHastaMostrar to set
	 */
	public void setPasilloHastaMostrar(Integer pasilloHastaMostrar) {
		this.pasilloHastaMostrar = pasilloHastaMostrar;
	}

	/**
	 * @return the estadoPallet
	 */
	public String getEstadoPallet() {
		return estadoPallet;
	}

	/**
	 * @param estadoPallet the estadoPallet to set
	 */
	public void setEstadoPallet(String estadoPallet) {
		this.estadoPallet = estadoPallet;
	}
	
	/**
	 * 
	 * @return el codigo de la nave
	 */
	public Long getCodigoNave() 
	{
		return codigoNave;
	}
	
	/**
	 * Cambia el codigo de la nave por el parametro dado
	 * @param codigoNave
	 */
	public void setCodigoNave(Long codigoNave) 
	{
		this.codigoNave = codigoNave;
	}
	
	/**
	 * 
	 * @return el codigo de la subnave
	 */
	public Long getCodigoSubnave() 
	{
		return codigoSubnave;
	}
	
	/**
	 * Cambia el codigo de la subnave por el parametro dado
	 * @param codigoSubnave
	 */
	public void setCodigoSubnave(Long codigoSubnave) 
	{
		this.codigoSubnave = codigoSubnave;
	}
	
	/**
	 * 
	 * @return los codigos de barras de los pallets
	 */
	public Collection<String> getCodigoBarrasPallets() 
	{
		return codigoBarrasPallets;
	}
	
	/**
	 * Cambia los codigos de barras de los pallets por los enviados en el 
	 * parametro.
	 * @param codigoBarrasPallets
	 */
	public void setCodigoBarrasPallets(Collection<String> codigoBarrasPallets) 
	{
		this.codigoBarrasPallets = codigoBarrasPallets;
	}
	
	/**
	 * 
	 * @return los codigos de barras de los articulos
	 */
	public Collection<String> getCodigoBarrasArticulos() 
	{
		return codigoBarrasArticulos;
	}
	
	/**
	 * Cambia los codigos de barras de los articulos por los enviados en el 
	 * parametro.
	 * @param codigoBarrasArticulos
	 */
	public void setCodigoBarrasArticulos(Collection<String> codigoBarrasArticulos) 
	{
		this.codigoBarrasArticulos = codigoBarrasArticulos;
	}
}
