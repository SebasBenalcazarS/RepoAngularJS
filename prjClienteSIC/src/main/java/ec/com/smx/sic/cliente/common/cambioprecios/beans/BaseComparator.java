package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.lang.reflect.Field;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;

import ec.com.smx.framework.common.util.ClasesUtil;
import ec.com.smx.sic.cliente.common.annotation.Compare;
import ec.com.smx.sic.cliente.mdl.dto.AuditoriaBaseDTO;

/**
 *
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public abstract class BaseComparator extends AuditoriaBaseDTO {

	public Boolean existenCambios() {

		Boolean existenCambios = Boolean.FALSE;

		// Campos a comparar del objeto principal 
		Collection<Field> campos = ClasesUtil.getFieldsByAnnotation(this, Compare.class);

		// Existen campos a comparar
		if (CollectionUtils.isNotEmpty(campos) 
				&& MapUtils.isNotEmpty(this.getDynamicProperties())) {

			EqualsBuilder valorCamposComparar = new EqualsBuilder();

			for (Field campoActual : campos) {
				if (this.getDynamicProperties().containsKey(campoActual.getName())) {
					valorCamposComparar.append(ClasesUtil.invocarMetodoGet(this, campoActual.getName()), this.getDynamicProperties().get(campoActual.getName()));
				}				
			}

			return !valorCamposComparar.isEquals();

		}

		return existenCambios;
	}
}
