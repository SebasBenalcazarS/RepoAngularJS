/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConfiguracionTablaMasivaID;


/**
 * @author guvidia
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTCONTABMAS")
public class ConfiguracionTablaMasivaDTO extends SearchDTO{
	
	@EmbeddedId
	private ConfiguracionTablaMasivaID id = new ConfiguracionTablaMasivaID();
	
	@Column(name = "ID")
	private String identificador;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "FIELD")
	private String field;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "CSSCLASS")
	private String cssclass;
	
	@Column(name = "UNSELECTABLE")
	private String unselectable;
	
	@Column(name = "WIDTH")
	private Integer width;
	
	@Column(name = "EDITOR")
	private String editor;
	
	@Column(name = "VALIDATOR")
	private String validator;
	
	@Column(name = "FORMATTER")
	private String formater;
	
	@Column(name = "OPTIONS")
	private String options;
	
	@Column(name = "TOOLTIP")
	private String tooltip;
	
	@Column(name = "MENUORDENAMIENTO")
	private String menuOrdenamiento;
	
	@Column(name = "CAMBIOMASIVO")
	private String cambioMasivo;
	
	@Column(name = "EDITABLE")
	private String editable;
	
	@Column(name = "ORDEN")
	private String orden;
	
	// especifica la longitud del campo
	@Column(name = "LONGITUD")
	private Integer longitud;
	
	@Column( name = "HEADERCSSCLASS")
	private String headerCssClass;
	
	private Long codigoProceso;
	
	public String getHeaderCssClass() {
		return headerCssClass;
	}
	public void setHeaderCssClass(String headerCssClass) {
		this.headerCssClass = headerCssClass;
	}
	/**
	 * @return the id
	 */
	public ConfiguracionTablaMasivaID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ConfiguracionTablaMasivaID id) {
		this.id = id;
	}
	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the cssclass
	 */
	public String getCssclass() {
		return cssclass;
	}
	/**
	 * @param cssclass the cssclass to set
	 */
	public void setCssclass(String cssclass) {
		this.cssclass = cssclass;
	}

	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}
	/**
	 * @return the editor
	 */
	public String getEditor() {
		return editor;
	}
	/**
	 * @param editor the editor to set
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}
	/**
	 * @return the validator
	 */
	public String getValidator() {
		return validator;
	}
	/**
	 * @param validator the validator to set
	 */
	public void setValidator(String validator) {
		this.validator = validator;
	}
	/**
	 * @return the formater
	 */
	public String getFormater() {
		return formater;
	}
	/**
	 * @param formater the formater to set
	 */
	public void setFormater(String formater) {
		this.formater = formater;
	}
	/**
	 * @return the options
	 */
	public String getOptions() {
		return options;
	}
	/**
	 * @param options the options to set
	 */
	public void setOptions(String options) {
		this.options = options;
	}
	/**
	 * @return the tooltip
	 */
	public String getTooltip() {
		return tooltip;
	}
	/**
	 * @param tooltip the tooltip to set
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the unselectable
	 */
	public String getUnselectable() {
		return unselectable;
	}
	/**
	 * @param unselectable the unselectable to set
	 */
	public void setUnselectable(String unselectable) {
		this.unselectable = unselectable;
	}
	/**
	 * @return the menuOrdenamiento
	 */
	public String getMenuOrdenamiento() {
		return menuOrdenamiento;
	}
	/**
	 * @param menuOrdenamiento the menuOrdenamiento to set
	 */
	public void setMenuOrdenamiento(String menuOrdenamiento) {
		this.menuOrdenamiento = menuOrdenamiento;
	}
	/**
	 * @return the cambioMasivo
	 */
	public Boolean getCambioMasivo() {		
		return StringUtils.equals("1", cambioMasivo);
	}
	/**
	 * @param cambioMasivo the cambioMasivo to set
	 */
	public void setCambioMasivo(String cambioMasivo) {
		this.cambioMasivo = cambioMasivo;
	}
	/**
	 * @return the orden
	 */
	public String getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}
	/**
	 * @return the editable
	 */
	public String getEditable() {
		return editable;
	}
	/**
	 * @param editable the editable to set
	 */
	public void setEditable(String editable) {
		this.editable = editable;
	}
	/**
	 * @return the longitud
	 */
	public Integer getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	public Long getCodigoProceso() {
		return codigoProceso;
	}
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}
		
}
