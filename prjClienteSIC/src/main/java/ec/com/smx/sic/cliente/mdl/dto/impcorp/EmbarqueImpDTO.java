/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.EmbarqueImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTEMBARQUE")
public class EmbarqueImpDTO extends AuditoriaBaseDTO<EmbarqueImpID>{
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "ANIO")
	private String anio;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "FECHAEMBARQUE")
	private Date fechaEmbarque;
	
	@Column(name = "FECHADESCARGA")
	private Date fechaDescarga;
	
	@Column(name = "FECHALLEGADABODEGA")
	private Date fechaLlegadaBodega;
	
	@Column(name = "CODIGOPUERTOEMBARQUE")
	private String codigoPuertoEmbarque;
	
	@Column(name = "CODIGOPUERTODESCARGA")
	private String codigoPuertoDescarga;
	
	@Column(name = "CODIGOMODTRACATVAL")
	private Long codigoModTraCatVal;
	
	@Column(name = "CODIGOMODTRACATTIP")
	private Long codigoModTraCatTip;
	
	@Column(name = "CODIGOTIPCARCATTIP")
	private Long codigoTipCarCatTip;
	
	@Column(name = "CODIGOTIPCARCATVAL")
	private Long codigoTipCarCatVal;
	
	@Column(name = "CODIGOTIPDECEMBCATTIP")
	private Long codigoTipDecEmbCatTip;
	
	@Column(name = "CODIGOTIPDECEMBCATVAL")
	private Long codigoTipDecEmbCatVal;
	
	@Column(name = "CODIGOADUANACATTIP")
	private Long codigoAduanaCatTip;
	
	@Column(name = "CODIGOADUANACATVAL")
	private Long codigoAduanaCatVal;
	
	@Column(name = "CODIGOALMACENCATTIP")
	private Long codigoAlmacenCatTip;
	
	@Column(name = "CODIGOALMACENCATVAL")
	private Long codigoAlmacenCatVal;
	
	@Column(name = "CODIGOAGENTEADUANERO")
	private String codigoAgenteAduanero;
	
	@Column(name = "CODIGOLINTRACATTIP")
	private Long codigoLinTraCatTip;
	
	@Column(name = "CODIGOLINTRACATVAL")
	private Long codigoLinTraCatVal;
	
	@Column(name = "CODIGOAGECARCATTIP")
	private Long codigoAgeCarCatTip;
	
	@Column(name = "CODIGOAGECARCATVAL")
	private Long codigoAgeCarCatVal;
	
	@Column(name = "CODIGOBANDERACATTIP") 
	private Long codigoBanderaCatTip;
	 
	@Column(name = "CODIGOBANDERACATVAL") 
	 private Long codigoBanderaCatVal;
	
	@Column(name = "CODIGOMERCADERIACATTIP")
	private Long codigoMercaderiaCatTip;
	
	@Column(name = "CODIGOMERCADERIACATVAL")
	private Long codigoMercaderiaCatVal;
	
	@Column(name = "CODIGOINCOTERMSCATTIP")
	private Long codigoIncotermsCatTip;
	
	@Column(name = "CODIGOINCOTERMSCATVAL")
	private Long codigoIncotermsCatVal;
	
	@Column(name = "CODIGOCIUDADTRANSACCION")
	private String codigoCiudadTransaccion;
	
	@Column(name = "CODIGOFUNCIONARIODECLARANTE")
	private String codigoFuncionarioDeclarante;
	
	@Column(name = "NUMEROBL")
	private String numeroBL;
	
	@Column(name = "FECHABL")
	private Date fechaBL;
	
	@Column(name = "REFRENDO")
	private String refrendo;
	
	@Column(name = "MANIFIESTO")
	private String manifiesto;
	
	@Column(name = "NUMEROVIAJE")
	private String numeroViaje;
	
	@Column(name = "NOMBREREFERENCIA")
	private String nombreReferencia;
	
	@Column(name = "NUMEROCONTENEDORES")
	private Integer numeroContenedores;

	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "NUMDESPACHOPARCIAL")
	private String numDespachoParcial;
	
//	@Column(name = "LUGARENTREGA")
//	private String lugarEntrega;
	
	@Column(name = "CODIGOREGIMENCATTIP")
	private Long codigoRegimenCatTip;
	
	@Column(name = "CODIGOREGIMENCATVAL")
	private Long codigoRegimenCatVal;
	
	@Column(name = "CODIGOTIPODESPACATTIP")
	private Long codigoTipoDespachoCatTip;
	
	@Column(name = "CODIGOTIPODESPACATVAL")
	private Long codigoTipoDespachoCatVal;
	
	
	@Column(name = "CODIGOTIPOPAGOCATTIP")
	private Long codigoTipoPagoCatTip;
	
	@Column(name = "CODIGOTIPOPAGOCATVAL")
	private Long codigoTipoPagoCatVal;
	
	@Column(name = "CODIGOENDOSOCATTIP")
	private Long codigoEndosoCatTip;
	
	@Column(name = "CODIGOENDOSOCATVAL")
	private Long codigoEndosoCatVal;
	
	@Column(name="RECIBIDO")
	private String recibido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOREGIMENCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOREGIMENCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoRegimen;
	
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPODESPACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPODESPACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoDespacho;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOPAGOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOPAGOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoPago;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOENDOSOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOENDOSOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO endoso;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOPUERTOEMBARQUE", referencedColumnName = "CODIGODIVGEOPOL", insertable = false, updatable = false)
	})
	private DivisionGeoPoliticaDTO puertoEmbarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOPUERTODESCARGA", referencedColumnName = "CODIGODIVGEOPOL", insertable = false, updatable = false)
	})
	private DivisionGeoPoliticaDTO puertoDescarga;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPCARCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPCARCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoCarga;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMODTRACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMODTRACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO modoTransporte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPDECEMBCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPDECEMBCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoDeclaracionEmbarque; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOADUANACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOADUANACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO aduana;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOALMACENCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOALMACENCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO almacen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLINTRACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLINTRACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO lineaTransporte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAGECARCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAGECARCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO agenciaCarga;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName ="CODIGOCOMPANIA", insertable = false, updatable = false),
	@JoinColumn(name = "CODIGOBANDERACATTIP", referencedColumnName ="CODIGOCATALOGOTIPO", insertable = false, updatable = false),
	@JoinColumn(name = "CODIGOBANDERACATVAL", referencedColumnName ="CODIGOCATALOGOVALOR", insertable = false, updatable = false) }) 
	private CatalogoValorImpDTO bandera;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMERCADERIACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMERCADERIACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO mercaderia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOINCOTERMSCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOINCOTERMSCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO incoterms;
	
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFUNCIONARIODECLARANTE", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
	})
	private FuncionarioDTO funcionarioDeclarante;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOCIUDADTRANSACCION", referencedColumnName = "CODIGODIVGEOPOL", updatable = false, insertable = false)
	private DivisionGeoPoliticaDTO ciudadTransaccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAGENTEADUANERO", referencedColumnName = "CODIGOAGENTEADUANERO", insertable = false, updatable = false)
	})
	private AgenteAduaneroDTO agenteAduanero;
	
	@OneToMany(mappedBy = "embarque")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<EmbarqueContenedorImpDTO> embarqueContenedores;
	
	@OneToMany(mappedBy = "embarque")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ObservacionImpDTO> embarqueObservaciones;
	
		
	@OneToMany(mappedBy = "embarque")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FacturaImpDTO> facturas;
	
	/**
	 * @return devuelve el valor de la propiedad codigoReferencia
	 */
	public String getCodigoReferencia() {
		return this.codigoReferencia != null ? this.codigoReferencia.toUpperCase() : this.codigoReferencia;
	}

	/**
	 * @param codigoReferencia establece el valor a la propiedad codigoReferencia
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia != null ? codigoReferencia.toUpperCase() : codigoReferencia;
	}

	/**
	 * @return devuelve el valor de la propiedad nombreReferencia
	 */
	public String getNombreReferencia() {
		return nombreReferencia;
	}

	/**
	 * @param nombreReferencia establece el valor a la propiedad nombreReferencia
	 */
	public void setNombreReferencia(String nombreReferencia) {
		this.nombreReferencia = nombreReferencia;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaEmbarque
	 */
	public Date getFechaEmbarque() {
		return fechaEmbarque;
	}

	/**
	 * @param fechaEmbarque establece el valor a la propiedad fechaEmbarque
	 */
	public void setFechaEmbarque(Date fechaEmbarque) {
		this.fechaEmbarque = fechaEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaDescarga
	 */
	public Date getFechaDescarga() {
		return fechaDescarga;
	}

	/**
	 * @param fechaDescarga establece el valor a la propiedad fechaDescarga
	 */
	public void setFechaDescarga(Date fechaDescarga) {
		this.fechaDescarga = fechaDescarga;
	}

	/**
	 * @return devuelve el valor de la propiedad numeroBL
	 */
	public String getNumeroBL() {
		return numeroBL;
	}

	/**
	 * @param numeroBL establece el valor a la propiedad numeroBL
	 */
	public void setNumeroBL(String numeroBL) {
		this.numeroBL = numeroBL;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaBL
	 */
	public Date getFechaBL() {
		return fechaBL;
	}

	/**
	 * @param fechaBL establece el valor a la propiedad fechaBL
	 */
	public void setFechaBL(Date fechaBL) {
		this.fechaBL = fechaBL;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoPuertoEmbarque
	 */
	public String getCodigoPuertoEmbarque() {
		return codigoPuertoEmbarque;
	}

	/**
	 * @param codigoPuertoEmbarque establece el valor a la propiedad codigoPuertoEmbarque
	 */
	public void setCodigoPuertoEmbarque(String codigoPuertoEmbarque) {
		this.codigoPuertoEmbarque = codigoPuertoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoPuertoDescarga
	 */
	public String getCodigoPuertoDescarga() {
		return codigoPuertoDescarga;
	}

	/**
	 * @param codigoPuertoDescarga establece el valor a la propiedad codigoPuertoDescarga
	 */
	public void setCodigoPuertoDescarga(String codigoPuertoDescarga) {
		this.codigoPuertoDescarga = codigoPuertoDescarga;
	}

	/**
	 * @return devuelve el valor de la propiedad refrendo
	 */
	public String getRefrendo() {
		return refrendo;
	}

	/**
	 * @param refrendo establece el valor a la propiedad refrendo
	 */
	public void setRefrendo(String refrendo) {
		this.refrendo = refrendo;
	}

	/**
	 * @return devuelve el valor de la propiedad manifiesto
	 */
	public String getManifiesto() {
		return manifiesto;
	}

	/**
	 * @param manifiesto establece el valor a la propiedad manifiesto
	 */
	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoAgenteAduanero
	 */
	public String getCodigoAgenteAduanero() {
		return codigoAgenteAduanero;
	}

	/**
	 * @param codigoAgenteAduanero establece el valor a la propiedad codigoAgenteAduanero
	 */
	public void setCodigoAgenteAduanero(String codigoAgenteAduanero) {
		this.codigoAgenteAduanero = codigoAgenteAduanero;
	}

	/**
	 * @return devuelve el valor de la propiedad numeroViaje
	 */
	public String getNumeroViaje() {
		return numeroViaje;
	}

	/**
	 * @param numeroViaje establece el valor a la propiedad numeroViaje
	 */
	public void setNumeroViaje(String numeroViaje) {
		this.numeroViaje = numeroViaje;
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
	 * @return devuelve el valor de la propiedad puertoEmbarque
	 */
	public DivisionGeoPoliticaDTO getPuertoEmbarque() {
		return puertoEmbarque;
	}

	/**
	 * @param puertoEmbarque establece el valor a la propiedad puertoEmbarque
	 */
	public void setPuertoEmbarque(DivisionGeoPoliticaDTO puertoEmbarque) {
		this.puertoEmbarque = puertoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad puertoDescarga
	 */
	public DivisionGeoPoliticaDTO getPuertoDescarga() {
		return puertoDescarga;
	}

	/**
	 * @param puertoDescarga establece el valor a la propiedad puertoDescarga
	 */
	public void setPuertoDescarga(DivisionGeoPoliticaDTO puertoDescarga) {
		this.puertoDescarga = puertoDescarga;
	}

	/**
	 * @return devuelve el valor de la propiedad embarqueContenedores
	 */
	

	/**
	 * @param embarqueContenedores establece el valor a la propiedad embarqueContenedores
	 */
	

	/**
	 * @return devuelve el valor de la propiedad descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion establece el valor a la propiedad descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return devuelve el valor de la propiedad tipoCarga
	 */
	public CatalogoValorImpDTO getTipoCarga() {
		return tipoCarga;
	}

	/**
	 * @param tipoCarga establece el valor a la propiedad tipoCarga
	 */
	public void setTipoCarga(CatalogoValorImpDTO tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaLlegadaBodega
	 */
	public Date getFechaLlegadaBodega() {
		return fechaLlegadaBodega;
	}

	/**
	 * @param fechaLlegadaBodega establece el valor a la propiedad fechaLlegadaBodega
	 */
	public void setFechaLlegadaBodega(Date fechaLlegadaBodega) {
		this.fechaLlegadaBodega = fechaLlegadaBodega;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoModTraCatVal
	 */
	public Long getCodigoModTraCatVal() {
		return codigoModTraCatVal;
	}

	/**
	 * @param codigoModTraCatVal establece el valor a la propiedad codigoModTraCatVal
	 */
	public void setCodigoModTraCatVal(Long codigoModTraCatVal) {
		this.codigoModTraCatVal = codigoModTraCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoModTraCatTip
	 */
	public Long getCodigoModTraCatTip() {
		return codigoModTraCatTip;
	}

	/**
	 * @param codigoModTraCatTip establece el valor a la propiedad codigoModTraCatTip
	 */
	public void setCodigoModTraCatTip(Long codigoModTraCatTip) {
		this.codigoModTraCatTip = codigoModTraCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipCarCatTip
	 */
	public Long getCodigoTipCarCatTip() {
		return codigoTipCarCatTip;
	}

	/**
	 * @param codigoTipCarCatTip establece el valor a la propiedad codigoTipCarCatTip
	 */
	public void setCodigoTipCarCatTip(Long codigoTipCarCatTip) {
		this.codigoTipCarCatTip = codigoTipCarCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipCarCatVal
	 */
	public Long getCodigoTipCarCatVal() {
		return codigoTipCarCatVal;
	}

	/**
	 * @param codigoTipCarCatVal establece el valor a la propiedad codigoTipCarCatVal
	 */
	public void setCodigoTipCarCatVal(Long codigoTipCarCatVal) {
		this.codigoTipCarCatVal = codigoTipCarCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipDecEmbCatTip
	 */
	public Long getCodigoTipDecEmbCatTip() {
		return codigoTipDecEmbCatTip;
	}

	/**
	 * @param codigoTipDecEmbCatTip establece el valor a la propiedad codigoTipDecEmbCatTip
	 */
	public void setCodigoTipDecEmbCatTip(Long codigoTipDecEmbCatTip) {
		this.codigoTipDecEmbCatTip = codigoTipDecEmbCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipDecEmbCatVal
	 */
	public Long getCodigoTipDecEmbCatVal() {
		return codigoTipDecEmbCatVal;
	}

	/**
	 * @param codigoTipDecEmbCatVal establece el valor a la propiedad codigoTipDecEmbCatVal
	 */
	public void setCodigoTipDecEmbCatVal(Long codigoTipDecEmbCatVal) {
		this.codigoTipDecEmbCatVal = codigoTipDecEmbCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoAduanaCatTip
	 */
	public Long getCodigoAduanaCatTip() {
		return codigoAduanaCatTip;
	}

	/**
	 * @param codigoAduanaCatTip establece el valor a la propiedad codigoAduanaCatTip
	 */
	public void setCodigoAduanaCatTip(Long codigoAduanaCatTip) {
		this.codigoAduanaCatTip = codigoAduanaCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoAduanaCatVal
	 */
	public Long getCodigoAduanaCatVal() {
		return codigoAduanaCatVal;
	}

	/**
	 * @param codigoAduanaCatVal establece el valor a la propiedad codigoAduanaCatVal
	 */
	public void setCodigoAduanaCatVal(Long codigoAduanaCatVal) {
		this.codigoAduanaCatVal = codigoAduanaCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoAlmacenCatTip
	 */
	public Long getCodigoAlmacenCatTip() {
		return codigoAlmacenCatTip;
	}

	/**
	 * @param codigoAlmacenCatTip establece el valor a la propiedad codigoAlmacenCatTip
	 */
	public void setCodigoAlmacenCatTip(Long codigoAlmacenCatTip) {
		this.codigoAlmacenCatTip = codigoAlmacenCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoAlmacenCatVal
	 */
	public Long getCodigoAlmacenCatVal() {
		return codigoAlmacenCatVal;
	}

	/**
	 * @param codigoAlmacenCatVal establece el valor a la propiedad codigoAlmacenCatVal
	 */
	public void setCodigoAlmacenCatVal(Long codigoAlmacenCatVal) {
		this.codigoAlmacenCatVal = codigoAlmacenCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoLinTraCatTip
	 */
	public Long getCodigoLinTraCatTip() {
		return codigoLinTraCatTip;
	}

	/**
	 * @param codigoLinTraCatTip establece el valor a la propiedad codigoLinTraCatTip
	 */
	public void setCodigoLinTraCatTip(Long codigoLinTraCatTip) {
		this.codigoLinTraCatTip = codigoLinTraCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoLinTraCatVal
	 */
	public Long getCodigoLinTraCatVal() {
		return codigoLinTraCatVal;
	}

	/**
	 * @param codigoLinTraCatVal establece el valor a la propiedad codigoLinTraCatVal
	 */
	public void setCodigoLinTraCatVal(Long codigoLinTraCatVal) {
		this.codigoLinTraCatVal = codigoLinTraCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad modoTransporte
	 */
	public CatalogoValorImpDTO getModoTransporte() {
		return modoTransporte;
	}

	/**
	 * @param modoTransporte establece el valor a la propiedad modoTransporte
	 */
	public void setModoTransporte(CatalogoValorImpDTO modoTransporte) {
		this.modoTransporte = modoTransporte;
	}

	/**
	 * @return devuelve el valor de la propiedad tipoDeclaracionEmbarque
	 */
	public CatalogoValorImpDTO getTipoDeclaracionEmbarque() {
		return tipoDeclaracionEmbarque;
	}

	/**
	 * @param tipoDeclaracionEmbarque establece el valor a la propiedad tipoDeclaracionEmbarque
	 */
	public void setTipoDeclaracionEmbarque(
			CatalogoValorImpDTO tipoDeclaracionEmbarque) {
		this.tipoDeclaracionEmbarque = tipoDeclaracionEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad aduana
	 */
	public CatalogoValorImpDTO getAduana() {
		return aduana;
	}

	/**
	 * @param aduana establece el valor a la propiedad aduana
	 */
	public void setAduana(CatalogoValorImpDTO aduana) {
		this.aduana = aduana;
	}

	/**
	 * @return devuelve el valor de la propiedad almacen
	 */
	public CatalogoValorImpDTO getAlmacen() {
		return almacen;
	}

	/**
	 * @param almacen establece el valor a la propiedad almacen
	 */
	public void setAlmacen(CatalogoValorImpDTO almacen) {
		this.almacen = almacen;
	}

	/**
	 * @return devuelve el valor de la propiedad lineaTransporte
	 */
	public CatalogoValorImpDTO getLineaTransporte() {
		return lineaTransporte;
	}

	/**
	 * @param lineaTransporte establece el valor a la propiedad lineaTransporte
	 */
	public void setLineaTransporte(CatalogoValorImpDTO lineaTransporte) {
		this.lineaTransporte = lineaTransporte;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoMercaderiaCatTip
	 */
	public Long getCodigoMercaderiaCatTip() {
		return codigoMercaderiaCatTip;
	}

	/**
	 * @param codigoMercaderiaCatTip establece el valor a la propiedad codigoMercaderiaCatTip
	 */
	public void setCodigoMercaderiaCatTip(Long codigoMercaderiaCatTip) {
		this.codigoMercaderiaCatTip = codigoMercaderiaCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoMercaderiaCatVal
	 */
	public Long getCodigoMercaderiaCatVal() {
		return codigoMercaderiaCatVal;
	}

	/**
	 * @param codigoMercaderiaCatVal establece el valor a la propiedad codigoMercaderiaCatVal
	 */
	public void setCodigoMercaderiaCatVal(Long codigoMercaderiaCatVal) {
		this.codigoMercaderiaCatVal = codigoMercaderiaCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoIncotermsCatTip
	 */
	public Long getCodigoIncotermsCatTip() {
		return codigoIncotermsCatTip;
	}

	/**
	 * @param codigoIncotermsCatTip establece el valor a la propiedad codigoIncotermsCatTip
	 */
	public void setCodigoIncotermsCatTip(Long codigoIncotermsCatTip) {
		this.codigoIncotermsCatTip = codigoIncotermsCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoIncotermsCatVal
	 */
	public Long getCodigoIncotermsCatVal() {
		return codigoIncotermsCatVal;
	}

	/**
	 * @param codigoIncotermsCatVal establece el valor a la propiedad codigoIncotermsCatVal
	 */
	public void setCodigoIncotermsCatVal(Long codigoIncotermsCatVal) {
		this.codigoIncotermsCatVal = codigoIncotermsCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad mercaderia
	 */
	public CatalogoValorImpDTO getMercaderia() {
		return mercaderia;
	}

	/**
	 * @param mercaderia establece el valor a la propiedad mercaderia
	 */
	public void setMercaderia(CatalogoValorImpDTO mercaderia) {
		this.mercaderia = mercaderia;
	}

	/**
	 * @return devuelve el valor de la propiedad incoterms
	 */
	public CatalogoValorImpDTO getIncoterms() {
		return incoterms;
	}

	/**
	 * @param incoterms establece el valor a la propiedad incoterms
	 */
	public void setIncoterms(CatalogoValorImpDTO incoterms) {
		this.incoterms = incoterms;
	}

	/**
	 * @return devuelve el valor de la propiedad agenteAduanero
	 */
	

	/**
	 * @param agenteAduanero establece el valor a la propiedad agenteAduanero
	 */
	
	/**
	 * @return devuelve el valor de la propiedad codigoCiudadTransaccion
	 */
	public String getCodigoCiudadTransaccion() {
		return codigoCiudadTransaccion;
	}

	/**
	 * @param codigoCiudadTransaccion establece el valor a la propiedad codigoCiudadTransaccion
	 */
	public void setCodigoCiudadTransaccion(String codigoCiudadTransaccion) {
		this.codigoCiudadTransaccion = codigoCiudadTransaccion;
	}

	/**
	 * @return devuelve el valor de la propiedad ciudadTransaccion
	 */
	public DivisionGeoPoliticaDTO getCiudadTransaccion() {
		return ciudadTransaccion;
	}

	/**
	 * @param ciudadTransaccion establece el valor a la propiedad ciudadTransaccion
	 */
	public void setCiudadTransaccion(DivisionGeoPoliticaDTO ciudadTransaccion) {
		this.ciudadTransaccion = ciudadTransaccion;
	}

	/**
	 * @return devuelve el valor de la propiedad numeroContenedores
	 */
	public Integer getNumeroContenedores() {
		return numeroContenedores;
	}

	/**
	 * @param numeroContenedores establece el valor a la propiedad numeroContenedores
	 */
	public void setNumeroContenedores(Integer numeroContenedores) {
		this.numeroContenedores = numeroContenedores;
	}

	/**
	 * @return devuelve el valor de la propiedad anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio establece el valor a la propiedad anio
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	public Long getCodigoBanderaCatTip() {
		return codigoBanderaCatTip;
	}

	public void setCodigoBanderaCatTip(Long codigoBanderaCatTip) {
		this.codigoBanderaCatTip = codigoBanderaCatTip;
	}

	
	public Long getCodigoBanderaCatVal() {
		return codigoBanderaCatVal;
	}

	public void setCodigoBanderaCatVal(Long codigoBanderaCatVal) {
		this.codigoBanderaCatVal = codigoBanderaCatVal;
	}
	
	/**
	 * @return devuelve el valor de la propiedad codigoAgeCarCatTip
	 */
	public Long getCodigoAgeCarCatTip() {
		return codigoAgeCarCatTip;
	}

	/**
	 * @param codigoAgeCarCatTip establece el valor a la propiedad codigoAgeCarCatTip
	 */
	public void setCodigoAgeCarCatTip(Long codigoAgeCarCatTip) {
		this.codigoAgeCarCatTip = codigoAgeCarCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoAgeCarCatVal
	 */
	public Long getCodigoAgeCarCatVal() {
		return codigoAgeCarCatVal;
	}

	/**
	 * @param codigoAgeCarCatVal establece el valor a la propiedad codigoAgeCarCatVal
	 */
	public void setCodigoAgeCarCatVal(Long codigoAgeCarCatVal) {
		this.codigoAgeCarCatVal = codigoAgeCarCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad agenciaCarga
	 */
	public CatalogoValorImpDTO getAgenciaCarga() {
		return agenciaCarga;
	}

	/**
	 * @param agenciaCarga establece el valor a la propiedad agenciaCarga
	 */
	public void setAgenciaCarga(CatalogoValorImpDTO agenciaCarga) {
		this.agenciaCarga = agenciaCarga;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFuncionarioDeclarante
	 */
	public String getCodigoFuncionarioDeclarante() {
		return codigoFuncionarioDeclarante;
	}

	/**
	 * @param codigoFuncionarioDeclarante establece el valor a la propiedad codigoFuncionarioDeclarante
	 */
	public void setCodigoFuncionarioDeclarante(String codigoFuncionarioDeclarante) {
		this.codigoFuncionarioDeclarante = codigoFuncionarioDeclarante;
	}

	/**
	 * @return devuelve el valor de la propiedad funcionarioDeclarante
	 */
	public FuncionarioDTO getFuncionarioDeclarante() {
		return funcionarioDeclarante;
	}

	/**
	 * @param funcionarioDeclarante establece el valor a la propiedad funcionarioDeclarante
	 */
	public void setFuncionarioDeclarante(FuncionarioDTO funcionarioDeclarante) {
		this.funcionarioDeclarante = funcionarioDeclarante;
	}

	/**
	 * @return the bandera
	 */
	public CatalogoValorImpDTO getBandera() {
		return bandera;
	}

	/**
	 * @param bandera the bandera to set
	 */
	public void setBandera(CatalogoValorImpDTO bandera) {
		this.bandera = bandera;
	}

	/**
	 * @return the embarqueObservaciones
	 */
	

	/**
	 * @param embarqueObservaciones the embarqueObservaciones to set
	 */
	

	/**
	 * @return the numDespachoParcial
	 */
	public String getNumDespachoParcial() {
		return numDespachoParcial;
	}

	/**
	 * @param numDespachoParcial the numDespachoParcial to set
	 */
	public void setNumDespachoParcial(String numDespachoParcial) {
		this.numDespachoParcial = numDespachoParcial;
	}

//	/**
//	 * @return the lugarEntrega
//	 */
//	public String getLugarEntrega() {
//		return lugarEntrega;
//	}
//
//	/**
//	 * @param lugarEntrega the lugarEntrega to set
//	 */
//	public void setLugarEntrega(String lugarEntrega) {
//		this.lugarEntrega = lugarEntrega;
//	}

	/**
	 * @return the codigoRegimenCatTip
	 */
	public Long getCodigoRegimenCatTip() {
		return codigoRegimenCatTip;
	}

	/**
	 * @param codigoRegimenCatTip the codigoRegimenCatTip to set
	 */
	public void setCodigoRegimenCatTip(Long codigoRegimenCatTip) {
		this.codigoRegimenCatTip = codigoRegimenCatTip;
	}

	/**
	 * @return the codigoRegimenCatVal
	 */
	public Long getCodigoRegimenCatVal() {
		return codigoRegimenCatVal;
	}

	/**
	 * @param codigoRegimenCatVal the codigoRegimenCatVal to set
	 */
	public void setCodigoRegimenCatVal(Long codigoRegimenCatVal) {
		this.codigoRegimenCatVal = codigoRegimenCatVal;
	}

	/**
	 * @return the codigoTipoDespachoCatTip
	 */
	public Long getCodigoTipoDespachoCatTip() {
		return codigoTipoDespachoCatTip;
	}

	/**
	 * @param codigoTipoDespachoCatTip the codigoTipoDespachoCatTip to set
	 */
	public void setCodigoTipoDespachoCatTip(Long codigoTipoDespachoCatTip) {
		this.codigoTipoDespachoCatTip = codigoTipoDespachoCatTip;
	}

	/**
	 * @return the codigoTipoDespachoCatVal
	 */
	public Long getCodigoTipoDespachoCatVal() {
		return codigoTipoDespachoCatVal;
	}

	/**
	 * @param codigoTipoDespachoCatVal the codigoTipoDespachoCatVal to set
	 */
	public void setCodigoTipoDespachoCatVal(Long codigoTipoDespachoCatVal) {
		this.codigoTipoDespachoCatVal = codigoTipoDespachoCatVal;
	}

	/**
	 * @return the tipoRegimen
	 */
	public CatalogoValorImpDTO getTipoRegimen() {
		return tipoRegimen;
	}

	/**
	 * @param tipoRegimen the tipoRegimen to set
	 */
	public void setTipoRegimen(CatalogoValorImpDTO tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}

	/**
	 * @return the tipoDespacho
	 */
	public CatalogoValorImpDTO getTipoDespacho() {
		return tipoDespacho;
	}

	/**
	 * @param tipoDespacho the tipoDespacho to set
	 */
	public void setTipoDespacho(CatalogoValorImpDTO tipoDespacho) {
		this.tipoDespacho = tipoDespacho;
	}

	/**
	 * @return the codigoTipoPagoCatTip
	 */
	public Long getCodigoTipoPagoCatTip() {
		return codigoTipoPagoCatTip;
	}

	/**
	 * @param codigoTipoPagoCatTip the codigoTipoPagoCatTip to set
	 */
	public void setCodigoTipoPagoCatTip(Long codigoTipoPagoCatTip) {
		this.codigoTipoPagoCatTip = codigoTipoPagoCatTip;
	}

	/**
	 * @return the codigoTipoPagoCatVal
	 */
	public Long getCodigoTipoPagoCatVal() {
		return codigoTipoPagoCatVal;
	}

	/**
	 * @param codigoTipoPagoCatVal the codigoTipoPagoCatVal to set
	 */
	public void setCodigoTipoPagoCatVal(Long codigoTipoPagoCatVal) {
		this.codigoTipoPagoCatVal = codigoTipoPagoCatVal;
	}

	/**
	 * @return the tipoPago
	 */
	public CatalogoValorImpDTO getTipoPago() {
		return tipoPago;
	}

	/**
	 * @param tipoPago the tipoPago to set
	 */
	public void setTipoPago(CatalogoValorImpDTO tipoPago) {
		this.tipoPago = tipoPago;
	}

	/**
	 * @return the codigoEndosoCatTip
	 */
	public Long getCodigoEndosoCatTip() {
		return codigoEndosoCatTip;
	}

	/**
	 * @param codigoEndosoCatTip the codigoEndosoCatTip to set
	 */
	public void setCodigoEndosoCatTip(Long codigoEndosoCatTip) {
		this.codigoEndosoCatTip = codigoEndosoCatTip;
	}

	/**
	 * @return the codigoEndosoCatVal
	 */
	public Long getCodigoEndosoCatVal() {
		return codigoEndosoCatVal;
	}

	/**
	 * @param codigoEndosoCatVal the codigoEndosoCatVal to set
	 */
	public void setCodigoEndosoCatVal(Long codigoEndosoCatVal) {
		this.codigoEndosoCatVal = codigoEndosoCatVal;
	}

	/**
	 * @return the endoso
	 */
	public CatalogoValorImpDTO getEndoso() {
		return endoso;
	}

	/**
	 * @param endoso the endoso to set
	 */
	public void setEndoso(CatalogoValorImpDTO endoso) {
		this.endoso = endoso;
	}

	/**
	 * @return the recibido
	 */
	public String getRecibido() {
		return recibido;
	}

	/**
	 * @param recibido the recibido to set
	 */
	public void setRecibido(String recibido) {
		this.recibido = recibido;
	}

	/**
	 * @return the agenteAduanero
	 */
	public AgenteAduaneroDTO getAgenteAduanero() {
		return agenteAduanero;
	}

	/**
	 * @param agenteAduanero the agenteAduanero to set
	 */
	public void setAgenteAduanero(AgenteAduaneroDTO agenteAduanero) {
		this.agenteAduanero = agenteAduanero;
	}

	/**
	 * @return the embarqueContenedores
	 */
	public Collection<EmbarqueContenedorImpDTO> getEmbarqueContenedores() {
		return embarqueContenedores;
	}

	/**
	 * @param embarqueContenedores the embarqueContenedores to set
	 */
	public void setEmbarqueContenedores(Collection<EmbarqueContenedorImpDTO> embarqueContenedores) {
		this.embarqueContenedores = embarqueContenedores;
	}

	/**
	 * @return the embarqueObservaciones
	 */
	public Collection<ObservacionImpDTO> getEmbarqueObservaciones() {
		return embarqueObservaciones;
	}

	/**
	 * @param embarqueObservaciones the embarqueObservaciones to set
	 */
	public void setEmbarqueObservaciones(Collection<ObservacionImpDTO> embarqueObservaciones) {
		this.embarqueObservaciones = embarqueObservaciones;
	}
	
	/**
	 * @return the facturas
	 */
	public Collection<FacturaImpDTO> getFacturas() {
		return facturas;
	}

	/**
	 * @param facturas the facturas to set
	 */
	public void setFacturas(Collection<FacturaImpDTO> facturas) {
		this.facturas = facturas;
	}
}
