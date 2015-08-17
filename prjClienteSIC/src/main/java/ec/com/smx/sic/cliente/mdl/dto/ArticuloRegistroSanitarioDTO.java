package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.frameworkv2.multicompany.dto.SystemDto;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloRegistroSanitarioID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IntegrableMQ;
import ec.com.smx.sic.cliente.mdl.vo.InformacionNutricionalVO;

/**
 * Tabla para vincular el registro sanitario de cada art�culo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETARTREGSAN")
public class ArticuloRegistroSanitarioDTO extends SimpleAuditDTO implements IntegrableMQ{

	/**
	 * Clave primaria del registro sanitario del art�culo
	 */
	@EmbeddedId
	private ArticuloRegistroSanitarioID id = new ArticuloRegistroSanitarioID();

	/**
	 * la cantidad de energ�a medida en calor�as por porci�n de art�culo.
	 * 
	 */
	private Double energiaCaloria;

	/**
	 * la cantidad de energ�a medida en KJulios por porci�n de art�culo.
	 * 
	 */
	private Double energiaKJ;

	/**
	 * la cantidad de energ�a medida en calor�as proporcionada por grasa por cada porci�n de art�culo.
	 * 
	 */
	private Double energiaGrasaCaloria;

	/**
	 * la cantidad de energ�a medida en KJulios proporcionada por grasa por cada porci�n de art�culo.
	 * 
	 */
	private Double energiaGrasaKJ;

	/**
	 * Estado del registro sanitario del art�culo. Valores permitidos: [1] Estado Activo [0] Estado Inactivo
	 * 
	 * 
	 * 
	 * <b>Valid Values for Field</b>
	 * 
	 * <table border="1" >
	 * <tr>
	 * <td><b>Key</b></td>
	 * <td><b>Value</b></td>
	 * <td><b>Observations</b></td>
	 * </tr>
	 * 
	 * <tr>
	 * <td>ACTIVO</td>
	 * <td>1</td>
	 * <td>ACTIVO. Estado Activo</td>
	 * </tr>
	 * 
	 * <tr>
	 * <td>INACTIVO</td>
	 * <td>0</td>
	 * <td>INACTIVO. Estado Inactivo</td>
	 * </tr>
	 * 
	 * </table>
	 */
	@ComparatorTypeField
	private String estadoRegistroSanitario;

	/**
	 * Fecha en la cual caduca el art�culo
	 * 
	 */
	private Date fechaCaducidad;
	/**
	 * Fecha en la cual caduca el registro sanitario
	 * 
	 */
	@Column(name="FECCADREGSAN")
	private Date fechaCaducidadRegistroSanitario;

	/**
	 * Fecha de elaboraci�n del art�culo
	 * 
	 */
	private Date fechaElaboracion;

	/**
	 * la forma en que se debe conservar el art�culo.
	 * 
	 */
	private String formaConservacion;


	/**
	 * el importador del art�culo.
	 * 
	 */
	private String importador;

	/**
	 * ingredientes que componen al art�culo paramostrar en su registro sanitario
	 * 
	 */
	private String ingredientes;

	/**
	 * la leyenda del porcentaje del porcentaje de valores diarios del art�culo que se muestra en su registro sanitario
	 * 
	 */
	private String leyenda;

	/**
	 * el lote al que pertenece el art�culo.
	 * 
	 */
	private String lote;

	/**
	 * la marca del art�culo que se muestra en su registro sanitario
	 * 
	 */
	private String marca;

	/**
	 * el nte del art�culo que se muestra en su registro sanitario
	 * 
	 */
	private String nte;

	/**
	 * el proveedor del art�culo.
	 * 
	 */
	private String proveedor;

	/**
	 * el registro sanitario del art�culo.
	 * 
	 */
	private String registroSanitario;

	/**
	 * Descripci&oacute;n de la referencia de medida, en relaci�n a la cantidad y unidad de medida
	 */
	private String referenciaMedida;
	
	/**
	 * porsiones de envase
	 */
	@Transient
	private Double porcionesEnvase;
	
	/**
	 * valor que indica si el tamanio de la porcion es aproximado
	 */
	@Transient
	private Boolean esPorcionAproximado;
	
	/**
	 * Valor de las porciones por envase establecido en un rango
	 */
	@Transient
	private String rangoPorcionesEnvase;
	
	/**
	 * indica si el valor de las porciones por envase es Rango o no
	 */
	@Transient
	private Boolean esRangoPorcionesEnvase;
	
	/**
	 * indica si el rango establecido es aproximado o no
	 */
	@Transient
	private Boolean esRangoAproximado;
	
	/**
	 * Usuario que realiz� el registro
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO", updatable=false)
	private String usuarioRegistro;

	/**
	 * Fecha en la cual se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private Date fechaRegistro;

	/**
	 * Usuario que modific� los datos del registro sanitario
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private String usuarioModificacion;

	/**
	 * Fecha en la cual se realiza la modificaci�n
	 * 
	 */
	@LastModificationDateField
	private Date fechaModificacion;

	/**
	 * la cantidad de impresiones que se van a realizar del registro sanitario.
	 */
	private Integer cantidadImpresion;

	/**
	 * el formato en que se va a imprimir el regsitro sanitario.
	 */
	private String formato;
	
	@Column(name="DESARTREGSAN", nullable = false)
	private String descripcionArticulo;
	/**
	 * Almacena la ciudad para el registro sanitario
	 */
	private String ciudadPais;
	/**
	 * 
	 */
	@Column(name="TIECON")
	private Double tiempoConservacion;
	/**
	 * Indica si el registro sanitario est� habilitado para que se imprima su etiqueta de registro sanitario en el formato correspondiente, posibles valores:
	 * 1=Habilitado y 0=Inabilitado
	 */
	@ComparatorTypeField
	private Boolean estadoImpresionEtiquetas;
	
	@Column(name="SISTEMAORIGEN", updatable=false)
	private String sistemaOrigen;
	
	/**
	 * el registro sanitario impreso en el envase de la etiqueta
	 * 
	 */
	private String registroSanitarioEtiquetaEnvase;
	
	/**
	 * Indica si coinciden los ingredientes del registro sanitario con los del proveedor
	 * 
	 */
	private Boolean coincidenIngredientesConProveedor;
	
	/**
	 * Indica si el registro sanitario viene impreso en el envase
	 * 
	 */
	private Boolean tieneImpresoRegistroSanitarioEnEnvase;
	
	/**
	 * Material del envase
	 */
	private String materialEnvase;
	
	/**
	 * Indica la fecha de emisi�n del registro sanitario
	 * 
	 */
	private Date fechaEmision;
	/**
	 * Valor del tipo de la unidad de conservaci&oacute;n
	 */
	@Column(name="VALORTIPOUNIDADTIEMPOCONSERVACION")
	@ComparatorTypeField
	private String valorTipoUnidadTiempoConservacion;
	/**
	 * C&oacute;digo del tipo de la unidad de conservaci&oacute;n
	 */
	@Column(name="CODIGOTIPOUNIDADTIEMPOCONSERVACION")
	private Integer codigoTipoUnidadTiempoConservacion;
	
	/**
	 * Codigo del catalogo tipo del tipo unidad
	 */
	@Column(name="CODIGOUNIDADTAMANIOPORCION")
	private Integer codigoUnidadTamanioporcion;
	
	/**
	 * Codigo del catalogo valor del tipo unidad
	 */
	@Column(name="VALORUNIDADTAMANIOPORCION")
	@ComparatorTypeField
	private String valorUnidadTamanioporcion;
	
	/**
	 * valor del tamanio de la porcion
	 */
	private Double valorTamanioPorcion;
	
	/**
	 * Codigo del catalogo tipo del tipo unidad para al valor del rango
	 */
	@Column(name="CODIGOUNIDADRANGOTAMANIOPORCION")
	private Integer codigoUnidadRangoTamanioPorcion;
	
	/**
	 * Codigo del catalogo valor del tipo unidad para el valor del rango
	 */
	@Column(name="VALORUNIDADRANGOTAMANIOPORCION")
	@ComparatorTypeField
	private String valorUnidadRangoTamanioPorcion;
	
	/**
	 * indica si el valor del tamanio de la porcion es Rango o no
	 */
	@Column(name = "ESRANGOTAMANIOPORCION")
	private Boolean esRangoTamanioPorcion;
	
	/**
	 * Valor del tamanio de la porcion establecido en un rango
	 */
	@Column(name = "RANGOTAMANIOPORCION")
	private String rangoTamanioPorcion;
	
	@Deprecated
	private Boolean estaValidado;
	
	/**
	 * Valor del catalogo tipo de estudio nutricional
	 */
	@ComparatorTypeField
	private String valorTipoEstudioNutricional;
	
	/**
	 * Codigo del catalogo tipo de estudio nutricional
	 */
	private Integer codigoTipoEstudioNutricional;
	
	/**
	 * Relaci�n con las definiciones de archivos
	 */
	@OneToMany(mappedBy="articuloRegistroSanitario")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloDefinicionArchivoDTO> artDefArcCol;
	
	@OneToMany(mappedBy = "registroSanitario")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<RelacionArticuloRegistroSanitarioDTO> articulos;
	
	/**
	 * Relaci�n con la bit�cora de revisiones
	 */
	@OneToMany(mappedBy="registroSanitario")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<BitacoraRevisionRegistroSanitarioDTO> bitRevRegSanCol;
	
	@OneToMany(mappedBy = "articuloRegistroSanitarioDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloInformacionNutricionalDTO> informacionNutricionalCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "SISTEMAORIGEN", referencedColumnName = "SYSID", insertable = false, updatable = false)
	private SystemDto sistemaOrigenDto;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORUNIDADTAMANIOPORCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOUNIDADTAMANIOPORCION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoTamanioPorcion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORUNIDADRANGOTAMANIOPORCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOUNIDADRANGOTAMANIOPORCION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoRangoTamanioPorcion;
		
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOUNIDADTIEMPOCONSERVACION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOUNIDADTIEMPOCONSERVACION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoUnidadTiempoConservacion;
		
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioCreacionDTO;
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;
	
	@Transient
	private Collection<ArticuloDefinicionArchivoDTO> docRegSanCol;
	
	@Transient
	private Collection<ArticuloDefinicionArchivoDTO> imgRegSanCol;
	
	/**
	 * Objeto que representa la �ltima revisi�n en la bit�cora, para que el dato sea correcto la colecci�n de bit�coras 
	 * debe estar ordenada por fecha de registro descendente
	 */
	@Transient
	private BitacoraRevisionRegistroSanitarioDTO bitRevRegSan;
	/**
	 * Colecci�n de registros sanitarios anteriores
	 */
	@Transient
	private Collection<ArticuloRegistroSanitarioDTO> listaRegSan;
	@Transient
	private Boolean transferirDatosSIC = Boolean.TRUE;
	@Transient
	private Collection<InformacionNutricionalVO> informacionNutricionalVOCol;
	
	//bandera que indica si un registro sanitario tiene detalle(consta en otros articulos)
	@Transient
	private Boolean detalle;
	
	public ArticuloRegistroSanitarioDTO() {
		id = new ArticuloRegistroSanitarioID();
	}
	public ArticuloRegistroSanitarioDTO(Boolean initID) {
		id = new ArticuloRegistroSanitarioID(initID);
	}
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ArticuloRegistroSanitarioID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ArticuloRegistroSanitarioID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>estadoRegistroSanitario</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoRegistroSanitario</code>
	 */
	public String getEstadoRegistroSanitario() {
		return this.estadoRegistroSanitario;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoRegistroSanitario</code>.
	 * 
	 * @param estadoRegistroSanitario1
	 *            El valor a establecer para la propiedad <code>estadoRegistroSanitario</code>.
	 */
	public void setEstadoRegistroSanitario(String estadoRegistroSanitario1) {
		this.estadoRegistroSanitario = estadoRegistroSanitario1;

		if (estadoRegistroSanitario != null && estadoRegistroSanitario.length() > 1) {
			estadoRegistroSanitario = estadoRegistroSanitario.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaCaducidad</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaCaducidad</code>
	 */
	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaCaducidad</code>.
	 * 
	 * @param fechaCaducidad1
	 *            El valor a establecer para la propiedad <code>fechaCaducidad</code>.
	 */
	public void setFechaCaducidad(Date fechaCaducidad1) {
		this.fechaCaducidad = fechaCaducidad1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaElaboracion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaElaboracion</code>
	 */
	public Date getFechaElaboracion() {
		return this.fechaElaboracion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaElaboracion</code>.
	 * 
	 * @param fechaElaboracion1
	 *            El valor a establecer para la propiedad <code>fechaElaboracion</code>.
	 */
	public void setFechaElaboracion(Date fechaElaboracion1) {
		this.fechaElaboracion = fechaElaboracion1;

	}

	/**
	 * Retorna valor de propiedad <code>formaConservacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>formaConservacion</code>
	 */
	public String getFormaConservacion() {
		return this.formaConservacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>formaConservacion</code>.
	 * 
	 * @param formaConservacion1
	 *            El valor a establecer para la propiedad <code>formaConservacion</code>.
	 */
	public void setFormaConservacion(String formaConservacion1) {
		this.formaConservacion = formaConservacion1;

		if (formaConservacion != null && formaConservacion.length() > 128) {
			formaConservacion = formaConservacion.substring(0, 128);
		}

	}

	/**
	 * Retorna valor de propiedad <code>importador</code>
	 * 
	 * @return Retorna valor de propiedad <code>importador</code>
	 */
	public String getImportador() {
		return this.importador;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>importador</code>.
	 * 
	 * @param importador1
	 *            El valor a establecer para la propiedad <code>importador</code>.
	 */
	public void setImportador(String importador1) {
		this.importador = importador1;

		if (importador != null && importador.length() > 128) {
			importador = importador.substring(0, 128);
		}

	}

	/**
	 * Retorna valor de propiedad <code>ingredientes</code>
	 * 
	 * @return Retorna valor de propiedad <code>ingredientes</code>
	 */
	public String getIngredientes() {
		return this.ingredientes;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>ingredientes</code>.
	 * 
	 * @param ingredientes1
	 *            El valor a establecer para la propiedad <code>ingredientes</code>.
	 */
	public void setIngredientes(String ingredientes1) {
		this.ingredientes = ingredientes1;
	}

	/**
	 * Retorna valor de propiedad <code>leyenda</code>
	 * 
	 * @return Retorna valor de propiedad <code>leyenda</code>
	 */
	public String getLeyenda() {
		return this.leyenda;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>leyenda</code>.
	 * 
	 * @param leyenda1
	 *            El valor a establecer para la propiedad <code>leyenda</code>.
	 */
	public void setLeyenda(String leyenda1) {
		this.leyenda = leyenda1;

		if (leyenda != null && leyenda.length() > 128) {
			leyenda = leyenda.substring(0, 128);
		}

	}

	/**
	 * Retorna valor de propiedad <code>lote</code>
	 * 
	 * @return Retorna valor de propiedad <code>lote</code>
	 */
	public String getLote() {
		return this.lote;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>lote</code>.
	 * 
	 * @param lote1
	 *            El valor a establecer para la propiedad <code>lote</code>.
	 */
	public void setLote(String lote1) {
		this.lote = lote1;

		if (lote != null && lote.length() > 64) {
			lote = lote.substring(0, 64);
		}

	}

	/**
	 * Retorna valor de propiedad <code>marca</code>
	 * 
	 * @return Retorna valor de propiedad <code>marca</code>
	 */
	public String getMarca() {
		return this.marca;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>marca</code>.
	 * 
	 * @param marca1
	 *            El valor a establecer para la propiedad <code>marca</code>.
	 */
	public void setMarca(String marca1) {
		this.marca = marca1;

		if (marca != null && marca.length() > 64) {
			marca = marca.substring(0, 64);
		}

	}

	/**
	 * Retorna valor de propiedad <code>nte</code>
	 * 
	 * @return Retorna valor de propiedad <code>nte</code>
	 */
	public String getNte() {
		return this.nte;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nte</code>.
	 * 
	 * @param nte1
	 *            El valor a establecer para la propiedad <code>nte</code>.
	 */
	public void setNte(String nte1) {
		this.nte = nte1;

		if (nte != null && nte.length() > 64) {
			nte = nte.substring(0, 64);
		}

	}

	/**
	 * Retorna valor de propiedad <code>proveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>proveedor</code>
	 */
	public String getProveedor() {
		return this.proveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * 
	 * @param proveedor1
	 *            El valor a establecer para la propiedad <code>proveedor</code>.
	 */
	public void setProveedor(String proveedor1) {
		this.proveedor = proveedor1;

		if (proveedor != null && proveedor.length() > 128) {
			proveedor = proveedor.substring(0, 128);
		}

	}

	/**
	 * Retorna valor de propiedad <code>registroSanitario</code>
	 * 
	 * @return Retorna valor de propiedad <code>registroSanitario</code>
	 */
	public String getRegistroSanitario() {
		return this.registroSanitario;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>registroSanitario</code>.
	 * 
	 * @param registroSanitario1
	 *            El valor a establecer para la propiedad <code>registroSanitario</code>.
	 */
	public void setRegistroSanitario(String registroSanitario1) {
		this.registroSanitario = registroSanitario1;

		if (registroSanitario != null) {
			registroSanitario = registroSanitario.toUpperCase();
		}

	}

	/**
	 * Retorna valor de propiedad <code>usuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioRegistro</code>
	 */
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioRegistro</code>.
	 * 
	 * @param usuarioRegistro1
	 *            El valor a establecer para la propiedad <code>usuarioRegistro</code>.
	 */
	public void setUsuarioRegistro(String usuarioRegistro1) {
		this.usuarioRegistro = usuarioRegistro1;

		if (usuarioRegistro != null && usuarioRegistro.length() > 32) {
			usuarioRegistro = usuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(Date fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * 
	 * @param usuarioModificacion1
	 *            El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion(String usuarioModificacion1) {
		this.usuarioModificacion = usuarioModificacion1;

		if (usuarioModificacion != null && usuarioModificacion.length() > 32) {
			usuarioModificacion = usuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(Date fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * Retorna valor de propiedad <code>cantidadImpresion</code>
	 * 
	 * @return Retorna valor de propiedad <code>cantidadImpresion</code>
	 */
	public Integer getCantidadImpresion() {
		return this.cantidadImpresion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadImpresion</code>.
	 * 
	 * @param cantidadImpresion1
	 *            El valor a establecer para la propiedad <code>cantidadImpresion</code>.
	 */
	public void setCantidadImpresion(Integer cantidadImpresion1) {
		this.cantidadImpresion = cantidadImpresion1;
	}

	/**
	 * Retorna valor de propiedad <code>formato</code>
	 * 
	 * @return Retorna valor de propiedad <code>formato</code>
	 */
	public String getFormato() {
		return this.formato;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>formato</code>.
	 * 
	 * @param formato1
	 *            El valor a establecer para la propiedad <code>formato</code>.
	 */
	public void setFormato(String formato1) {
		this.formato = formato1;

		if (formato != null && formato.length() > 64) {
			formato = formato.substring(0, 64);
		}
	}

	/**
	 * @return el energiaCaloria
	 */
	public Double getEnergiaCaloria() {
		return energiaCaloria;
	}

	/**
	 * @param energiaCaloria
	 *            el energiaCaloria a establecer
	 */
	public void setEnergiaCaloria(Double energiaCaloria) {
		this.energiaCaloria = energiaCaloria;
	}

	/**
	 * @return el energiaGrasaCaloria
	 */
	public Double getEnergiaGrasaCaloria() {
		return energiaGrasaCaloria;
	}

	/**
	 * @param energiaGrasaCaloria
	 *            el energiaGrasaCaloria a establecer
	 */
	public void setEnergiaGrasaCaloria(Double energiaGrasaCaloria) {
		this.energiaGrasaCaloria = energiaGrasaCaloria;
	}

	/**
	 * @return el energiaGrasaKJ
	 */
	public Double getEnergiaGrasaKJ() {
		return energiaGrasaKJ;
	}

	/**
	 * @param energiaGrasaKJ
	 *            el energiaGrasaKJ a establecer
	 */
	public void setEnergiaGrasaKJ(Double energiaGrasaKJ) {
		this.energiaGrasaKJ = energiaGrasaKJ;
	}

	/**
	 * @return el energiaKJ
	 */
	public Double getEnergiaKJ() {
		return energiaKJ;
	}

	/**
	 * @param energiaKJ
	 *            el energiaKJ a establecer
	 */
	public void setEnergiaKJ(Double energiaKJ) {
		this.energiaKJ = energiaKJ;
	}

	/**
	 * @return el descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo
	 *            el descripcionArticulo a establecer
	 */
	public void setDescripcionArticulo(String descripcionArticuloAux) {
		String descripcionArticulo = descripcionArticuloAux;
		if (descripcionArticulo != null && descripcionArticulo.length() > 300) {
			descripcionArticulo = descripcionArticulo.substring(0, 300);
		}
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * @return el ciudadPais
	 */
	public String getCiudadPais() {
		return ciudadPais;
	}

	/**
	 * @param ciudadPais
	 *            el ciudadPais a establecer
	 */
	public void setCiudadPais(String ciudadPais) {
		this.ciudadPais = ciudadPais;
	}

	/**
	 * @return el tiempoConservacion
	 */
	public Double getTiempoConservacion() {
		return tiempoConservacion;
	}

	/**
	 * @param tiempoConservacion
	 *            el tiempoConservacion a establecer
	 */
	public void setTiempoConservacion(Double tiempoConservacion) {
		this.tiempoConservacion = tiempoConservacion;
	}

	

	public Boolean getTieneArticuloDefinicionArchivo() {
		return isLoaded(this.artDefArcCol) && !this.artDefArcCol.isEmpty();
	}
	/**
	 * @return the bitRevRegSanCol
	 */
	public Collection<BitacoraRevisionRegistroSanitarioDTO> getBitRevRegSanCol() {
		return bitRevRegSanCol;
	}
	/**
	 * @param bitRevRegSanCol the bitRevRegSanCol to set
	 */
	public void setBitRevRegSanCol(Collection<BitacoraRevisionRegistroSanitarioDTO> bitRevRegSanCol) {
		this.bitRevRegSanCol = bitRevRegSanCol;
	}
	/**
	 * Indica si el registro sanitario tiene cargadas bit�coras
	 * @return
	 */
	public Boolean getTieneBitRevRegSan() {
		return isLoaded(this.bitRevRegSanCol) && !this.bitRevRegSanCol.isEmpty();
	}
	
	/**
	 * @return the bitRevRegSan
	 */
	public BitacoraRevisionRegistroSanitarioDTO getBitRevRegSan() {
		if(this.bitRevRegSan == null && this.getTieneBitRevRegSan()){
			this.bitRevRegSanCol = new LinkedHashSet<BitacoraRevisionRegistroSanitarioDTO>(ColeccionesUtil.sort(this.bitRevRegSanCol, ColeccionesUtil.ORDEN_DESC, "fechaRegistro"));
			this.bitRevRegSan = this.bitRevRegSanCol.iterator().next();
		}
		return bitRevRegSan;
	}
	/**
	 * @param bitRevRegSan the bitRevRegSan to set
	 */
	public void setBitRevRegSan(BitacoraRevisionRegistroSanitarioDTO bitRevRegSan) {
		this.bitRevRegSan = bitRevRegSan;
	}

	/**
	 * @return the estadoImpresionEtiquetas
	 */
	public Boolean getEstadoImpresionEtiquetas() {
		return estadoImpresionEtiquetas;
	}

	/**
	 * @param estadoImpresionEtiquetas the estadoImpresionEtiquetas to set
	 */
	public void setEstadoImpresionEtiquetas(Boolean estadoImpresionEtiquetas) {
		this.estadoImpresionEtiquetas = estadoImpresionEtiquetas;
	}


	public Collection<ArticuloRegistroSanitarioDTO> getListaRegSan() {
		return listaRegSan;
	}

	public void setListaRegSan(Collection<ArticuloRegistroSanitarioDTO> listaRegSan) {
		this.listaRegSan = listaRegSan;
	}

	/**
	 * @return the fechaCaducidadRegistroSanitario
	 */
	public Date getFechaCaducidadRegistroSanitario() {
		return fechaCaducidadRegistroSanitario;
	}

	/**
	 * @param fechaCaducidadRegistroSanitario the fechaCaducidadRegistroSanitario to set
	 */
	public void setFechaCaducidadRegistroSanitario(Date fechaCaducidadRegistroSanitario) {
		this.fechaCaducidadRegistroSanitario = fechaCaducidadRegistroSanitario;
	}

	/**
	 * @return the usuarioCreacionDTO
	 */
	public UserDto getUsuarioCreacionDTO() {
		return usuarioCreacionDTO;
	}

	/**
	 * @param usuarioCreacionDTO the usuarioCreacionDTO to set
	 */
	public void setUsuarioCreacionDTO(UserDto usuarioCreacionDTO) {
		this.usuarioCreacionDTO = usuarioCreacionDTO;
	}

	/**
	 * @return the usuarioModificacionDTO
	 */
	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}

	/**
	 * @param usuarioModificacionDTO the usuarioModificacionDTO to set
	 */
	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}

	/**
	 * @return the sistemaOrigen
	 */
	public String getSistemaOrigen() {
		return sistemaOrigen;
	}

	/**
	 * @param sistemaOrigen the sistemaOrigen to set
	 */
	public void setSistemaOrigen(String sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}

	/**
	 * @return the sistemaOrigenDto
	 */
	public SystemDto getSistemaOrigenDto() {
		return sistemaOrigenDto;
	}

	/**
	 * @param sistemaOrigenDto the sistemaOrigenDto to set
	 */
	public void setSistemaOrigenDto(SystemDto sistemaOrigenDto) {
		this.sistemaOrigenDto = sistemaOrigenDto;
	}
	public Collection<ArticuloDefinicionArchivoDTO> getArtDefArcCol() {
		return artDefArcCol;
	}
	public void setArtDefArcCol(
			Collection<ArticuloDefinicionArchivoDTO> artDefArcCol) {
		this.artDefArcCol = artDefArcCol;
	}
	/**
	 * @return the transferirDatosSIC
	 */
	public Boolean getTransferirDatosSIC() {
		return transferirDatosSIC;
	}
	/**
	 * @param transferirDatosSIC the transferirDatosSIC to set
	 */
	public void setTransferirDatosSIC(Boolean transferirDatosSIC) {
		this.transferirDatosSIC = transferirDatosSIC;
	}
	public Boolean getCoincidenIngredientesConProveedor() {
		return coincidenIngredientesConProveedor;
	}
	public void setCoincidenIngredientesConProveedor(Boolean coincidenIngredientesConProveedor) {
		this.coincidenIngredientesConProveedor = coincidenIngredientesConProveedor;
	}
	public Boolean getTieneImpresoRegistroSanitarioEnEnvase() {
		return tieneImpresoRegistroSanitarioEnEnvase;
	}
	public void setTieneImpresoRegistroSanitarioEnEnvase(Boolean tieneImpresoRegistroSanitarioEnEnvase) {
		this.tieneImpresoRegistroSanitarioEnEnvase = tieneImpresoRegistroSanitarioEnEnvase;
	}
	public String getRegistroSanitarioEtiquetaEnvase() {
		return registroSanitarioEtiquetaEnvase;
	}
	public void setRegistroSanitarioEtiquetaEnvase(String registroSanitarioEtiquetaEnvase) {
		this.registroSanitarioEtiquetaEnvase = registroSanitarioEtiquetaEnvase;
		if(StringUtils.isNotEmpty(registroSanitarioEtiquetaEnvase)){
			this.registroSanitarioEtiquetaEnvase = registroSanitarioEtiquetaEnvase.toUpperCase();
		}
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getMaterialEnvase() {
		return materialEnvase;
	}
	public void setMaterialEnvase(String materialEnvase) {
		this.materialEnvase = materialEnvase;
	}
	public String getReferenciaMedida() {
		return referenciaMedida;
	}
	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}
	public String getValorTipoUnidadTiempoConservacion() {
		return valorTipoUnidadTiempoConservacion;
	}
	public void setValorTipoUnidadTiempoConservacion(String valorTipoUnidadTiempoConservacion) {
		this.valorTipoUnidadTiempoConservacion = valorTipoUnidadTiempoConservacion;
	}
	public Integer getCodigoTipoUnidadTiempoConservacion() {
		return codigoTipoUnidadTiempoConservacion;
	}
	public void setCodigoTipoUnidadTiempoConservacion(Integer codigoTipoUnidadTiempoConservacion) {
		this.codigoTipoUnidadTiempoConservacion = codigoTipoUnidadTiempoConservacion;
	}
	public CatalogoValorDTO getTipoUnidadTiempoConservacion() {
		return tipoUnidadTiempoConservacion;
	}
	public void setTipoUnidadTiempoConservacion(CatalogoValorDTO tipoUnidadTiempoConservacion) {
		this.tipoUnidadTiempoConservacion = tipoUnidadTiempoConservacion;
	}
	
	/**
	 * @return the tipoTamanioPorcion
	 */
	public CatalogoValorDTO getTipoTamanioPorcion() {
		return tipoTamanioPorcion;
	}
	/**
	 * @param tipoTamanioPorcion the tipoTamanioPorcion to set
	 */
	public void setTipoTamanioPorcion(CatalogoValorDTO tipoTamanioPorcion) {
		this.tipoTamanioPorcion = tipoTamanioPorcion;
	}
	public String getValorUnidadTamanioporcion() {
		return valorUnidadTamanioporcion;
	}
	public void setValorUnidadTamanioporcion(String valorUnidadTamanioporcion) {
		this.valorUnidadTamanioporcion = valorUnidadTamanioporcion;
	}
	public Double getValorTamanioPorcion() {
		return valorTamanioPorcion;
	}
	public void setValorTamanioPorcion(Double valorTamanioPorcion) {
		this.valorTamanioPorcion = valorTamanioPorcion;
	}
	public Collection<ArticuloInformacionNutricionalDTO> getInformacionNutricionalCol() {
		return informacionNutricionalCol;
	}
	public void setInformacionNutricionalCol(Collection<ArticuloInformacionNutricionalDTO> informacionNutricionalCol) {
		this.informacionNutricionalCol = informacionNutricionalCol;
	}
	public Collection<RelacionArticuloRegistroSanitarioDTO> getArticulos() {
		return articulos;
	}
	public void setArticulos(Collection<RelacionArticuloRegistroSanitarioDTO> articulos) {
		this.articulos = articulos;
	}
	public Collection<InformacionNutricionalVO> getInformacionNutricionalVOCol() {
		return informacionNutricionalVOCol;
	}
	public void setInformacionNutricionalVOCol(Collection<InformacionNutricionalVO> informacionNutricionalVOCol) {
		this.informacionNutricionalVOCol = informacionNutricionalVOCol;
	}
	public Integer getCodigoUnidadTamanioporcion() {
		return codigoUnidadTamanioporcion;
	}
	public void setCodigoUnidadTamanioporcion(Integer codigoUnidadTamanioporcion) {
		this.codigoUnidadTamanioporcion = codigoUnidadTamanioporcion;
	}
	@Deprecated
	public Boolean getEstaValidado() {
		return estaValidado;
	}
	@Deprecated
	public void setEstaValidado(Boolean estaValidado) {
		this.estaValidado = estaValidado;
	}
	
	public Boolean getTieneInformacionNutricional(){
		return isLoaded(informacionNutricionalCol);
	}
	public String getValorTipoEstudioNutricional() {
		return valorTipoEstudioNutricional;
	}
	public void setValorTipoEstudioNutricional(String valorTipoEstudioNutricional) {
		this.valorTipoEstudioNutricional = valorTipoEstudioNutricional;
	}
	public Integer getCodigoTipoEstudioNutricional() {
		return codigoTipoEstudioNutricional;
	}
	public void setCodigoTipoEstudioNutricional(Integer codigoTipoEstudioNutricional) {
		this.codigoTipoEstudioNutricional = codigoTipoEstudioNutricional;
	}
	public Collection<ArticuloDefinicionArchivoDTO> getDocRegSanCol() {
		return docRegSanCol;
	}
	public void setDocRegSanCol(Collection<ArticuloDefinicionArchivoDTO> docRegSanCol) {
		this.docRegSanCol = docRegSanCol;
	}
	public Collection<ArticuloDefinicionArchivoDTO> getImgRegSanCol() {
		return imgRegSanCol;
	}
	public void setImgRegSanCol(Collection<ArticuloDefinicionArchivoDTO> imgRegSanCol) {
		this.imgRegSanCol = imgRegSanCol;
	}
	/**
	 * @return the detalle
	 */
	public Boolean getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(Boolean detalle) {
		this.detalle = detalle;
	}
	/**
	 * @return the porcionesEnvase
	 */
	public Double getPorcionesEnvase() {
		return porcionesEnvase;
	}
	/**
	 * @param porcionesEnvase the porcionesEnvase to set
	 */
	public void setPorcionesEnvase(Double porcionesEnvase) {
		this.porcionesEnvase = porcionesEnvase;
	}
	
	public Boolean getEsPorcionAproximado() {
		return esPorcionAproximado;
	}
	
	public void setEsPorcionAproximado(Boolean esPorcionAproximado) {
		this.esPorcionAproximado = esPorcionAproximado;
	}
	
	/*GETTERS AND SETTERS RANGO PORCION ENVASE*/
	

	public String getRangoPorcionesEnvase() {
		return rangoPorcionesEnvase;
	}
	
	public void setRangoPorcionesEnvase(String rangoPorcionesEnvase) {
		this.rangoPorcionesEnvase = rangoPorcionesEnvase;
	}
	
	public Boolean getEsRangoPorcionesEnvase() {
		return esRangoPorcionesEnvase;
	}
	
	public void setEsRangoPorcionesEnvase(Boolean esRangoPorcionesEnvase) {
		this.esRangoPorcionesEnvase = esRangoPorcionesEnvase;
	}
	
	public Boolean getEsRangoAproximado() {
		return esRangoAproximado;
	}
	
	public void setEsRangoAproximado(Boolean esRangoAproximado) {
		this.esRangoAproximado = esRangoAproximado;
	}
	
	/*GETTERS AND SETTERS RANGO TAMANIO PORCION*/
	/**
	 * @return the codigoUnidadRangoTamanioPorcion
	 */
	public Integer getCodigoUnidadRangoTamanioPorcion() {
		return codigoUnidadRangoTamanioPorcion;
	}
	
	/** 
	 * @param codigoUnidadRangoTamanioPorcion
	 */
	public void setCodigoUnidadRangoTamanioPorcion(Integer codigoUnidadRangoTamanioPorcion) {
		this.codigoUnidadRangoTamanioPorcion = codigoUnidadRangoTamanioPorcion;
	}
	
	/**
	 * @return the valorUnidadRangoTamanioPorcion
	 */
	public String getValorUnidadRangoTamanioPorcion() {
		return valorUnidadRangoTamanioPorcion;
	}
	
	/**
	 * @param valorUnidadRangoTamanioPorcion
	 */
	public void setValorUnidadRangoTamanioPorcion(String valorUnidadRangoTamanioPorcion) {
		this.valorUnidadRangoTamanioPorcion = valorUnidadRangoTamanioPorcion;
	}
	
	/**
	 * @return the esRangoTamanioPorcion
	 */
	public Boolean getEsRangoTamanioPorcion() {
		return esRangoTamanioPorcion;
	}
	
	/**
	 * @param esRangoTamanioPorcion
	 */
	public void setEsRangoTamanioPorcion(Boolean esRangoTamanioPorcion) {
		this.esRangoTamanioPorcion = esRangoTamanioPorcion;
	}
	
	/**
	 * @return the rangoTamanioPorcion
	 */
	public String getRangoTamanioPorcion() {
		return rangoTamanioPorcion;
	}
	
	/**
	 * @param rangoTamanioPorcion
	 */
	public void setRangoTamanioPorcion(String rangoTamanioPorcion) {
		this.rangoTamanioPorcion = rangoTamanioPorcion;
	}
	
	/**
	 * @return the tipoRangoTamanioPorcion
	 */
	public CatalogoValorDTO getTipoRangoTamanioPorcion() {
		return tipoRangoTamanioPorcion;
	}
	
	/**
	 * @param tipoRangoTamanioPorcion
	 */
	public void setTipoRangoTamanioPorcion(CatalogoValorDTO tipoRangoTamanioPorcion) {
		this.tipoRangoTamanioPorcion = tipoRangoTamanioPorcion;
	}
	
}
