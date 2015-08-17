package ec.com.smx.sic.cliente.common.convenio.estructura;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.convenio.enums.SelecionNegociacionEnum;

/**
 * CampaniaPromocionParticipanteEstructura, calse de representacion de la jerarquia de un arbol
 * @author srodriguez
 * @author aquingaluisa
 * **/
public class CampaniaPromocionParticipanteEstructura {
	
	private Long codigo;
	
	private Long codigoCampaniaPromocionParticipante;
	
	private SelecionNegociacionEnum tipoMiembroNegociacion ;
	
	private boolean modificable;
	
	private String agrupador;
	//propiedad para validar si se aplico  un filtro en el arbol 
	
	private boolean contieneFiltro;
	/**
	 * Propiedad que valida si los hijos  tienen diferente agrupador., solo debera tomarce en cuenta en la estructura padre principal
	 */
	private boolean tieneHijosAgrupadorDiferente;
	
	private Collection<CampaniaPromocionParticipanteEstructura> promocionesParticipantes;
	/**
	 * Bandera que permite validar si se debe crear una negociacion o utilizar la misma que se encuentra ligada
	 */
	private boolean crearNegociacion;
	/* Metodo que retorna codigo del objeto
	 * @author srodriguez
	 * 9/1/2015
	 * @return String codigo 
	 */
	public Long getCodigo() {
		return codigo;
	}
	/* Metodo que asigna el codigo del objeto
	 * @author srodriguez
	 * 9/1/2015
	 * @param codigo parametro de tipo String
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	/* Metodo que retorna promocionesParticipantes del objeto
	 * @author srodriguez
	 * 9/1/2015
	 * @return Collection<CampaniaPromocionParticipanteEstructura> promocionesParticipantes 
	 */
	public Collection<CampaniaPromocionParticipanteEstructura> getPromocionesParticipantes() {
		return promocionesParticipantes;
	}
	/* Metodo que asigna el promocionesParticipantes del objeto
	 * @author srodriguez
	 * 9/1/2015
	 * @param promocionesParticipantes parametro de tipo Collection<CampaniaPromocionParticipanteEstructura>
	 */
	public void setPromocionesParticipantes(Collection<CampaniaPromocionParticipanteEstructura> promocionesParticipantes) {
		this.promocionesParticipantes = promocionesParticipantes;
	}
	/* Metodo que retorna modificable del objeto
	 * @author srodriguez
	 * 9/1/2015
	 * @return boolean modificable 
	 */
	public boolean isModificable() {
		return modificable;
	}
	/* Metodo que asigna el modificable del objeto
	 * @author srodriguez
	 * 9/1/2015
	 * @param modificable parametro de tipo boolean
	 */
	public void setModificable(boolean modificable) {
		this.modificable = modificable;
	}
	
	/* Metodo que retorna tipoMiembroNegociacion del objeto
	 * @author srodriguez
	 * 10/1/2015
	 * @return SelecionNegociacionEnum tipoMiembroNegociacion 
	 */
	public SelecionNegociacionEnum getTipoMiembroNegociacion() {
		return tipoMiembroNegociacion;
	}
	/* Metodo que asigna el tipoMiembroNegociacion del objeto
	 * @author srodriguez
	 * 10/1/2015
	 * @param tipoMiembroNegociacion parametro de tipo SelecionNegociacionEnum
	 */
	public void setTipoMiembroNegociacion(SelecionNegociacionEnum tipoMiembroNegociacion) {
		this.tipoMiembroNegociacion = tipoMiembroNegociacion;
	}
	public boolean isCrearNegociacion() {
		return crearNegociacion;
	}
	public void setCrearNegociacion(boolean crearNegociacion) {
		this.crearNegociacion = crearNegociacion;
	}
	public boolean isTieneHijosAgrupadorDiferente() {
		return tieneHijosAgrupadorDiferente;
	}
	public void setTieneHijosAgrupadorDiferente(boolean tieneHijosAgrupadorDiferente) {
		this.tieneHijosAgrupadorDiferente = tieneHijosAgrupadorDiferente;
	}
	/** Metodo que retorna codigoCampaniaPromocionParticipante del objeto
	 * @author srodriguez
	 * 13/1/2015
	 * @return Long codigoCampaniaPromocionParticipante 
	 */
	public Long getCodigoCampaniaPromocionParticipante() {
		return codigoCampaniaPromocionParticipante;
	}
	/** Metodo que asigana el valor de codigoCampaniaPromocionParticipante del objeto
	 * @author srodriguez
	 * 13/1/2015
	 * @return Long codigoCampaniaPromocionParticipante 
	 */
	public void setCodigoCampaniaPromocionParticipante(Long codigoCampaniaPromocionParticipante) {
		this.codigoCampaniaPromocionParticipante = codigoCampaniaPromocionParticipante;
	}
	public String getAgrupador() {
		return agrupador;
	}
	public void setAgrupador(String agrupador) {
		this.agrupador = agrupador;
	}
	public boolean isContieneFiltro() {
		return contieneFiltro;
	}
	public void setContieneFiltro(boolean contieneFiltro) {
		this.contieneFiltro = contieneFiltro;
	}
	
}
