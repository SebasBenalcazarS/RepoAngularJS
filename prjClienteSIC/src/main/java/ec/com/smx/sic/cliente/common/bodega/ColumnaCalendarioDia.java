package ec.com.smx.sic.cliente.common.bodega;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRawValue;

@SuppressWarnings("serial")
public class ColumnaCalendarioDia implements Serializable {
		private String id;
		private String name;
		private String field;
		private String cssClass;
		private boolean unselectable;
		private Integer width = 100;
		@JsonRawValue
		private String editor;
		@JsonRawValue
		private String validator;
		@JsonRawValue
		private Object formatter;
		private String options;
		private String toolTip;
		private static final String TEMPLATE = "{id: \"%s\", name: \"%s\", field: \"%s\", toolTip: \"%s\",formatter:%s, editor: %s, validator:%s, unselectable:%s, options:%s, cssClass:\"%s\", width: %s}";


		public String getToolTip() {
			return toolTip;
		}

		public void setToolTip(String toolTip) {
			this.toolTip = toolTip;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getCssClass() {
			return cssClass;
		}

		public void setCssClass(String cssClass) {
			this.cssClass = cssClass;
		}

		public boolean isUnselectable() {
			return unselectable;
		}

		public void setUnselectable(boolean unselectable) {
			this.unselectable = unselectable;
		}

		public Integer getWidth() {
			return width;
		}

		public void setWidth(Integer width) {
			this.width = width;
		}

		public String getEditor() {
			return editor;
		}

		public void setEditor(String editor) {
			this.editor = editor;
		}

		public String getValidator() {
			return validator;
		}

		public void setValidator(String validator) {
			this.validator = validator;
		}

		public Object getFormatter() {
			return formatter;
		}

		public void setFormatter(Object formatter) {
			this.formatter = formatter;
		}

		public String getOptions() {
			return options;
		}

		public void setOptions(String options) {
			this.options = options;
		}

		@Override
		public String toString() {
			return String.format(TEMPLATE, id, name, field, toolTip, formatter, editor, validator, unselectable, options, cssClass, width);
		}

}