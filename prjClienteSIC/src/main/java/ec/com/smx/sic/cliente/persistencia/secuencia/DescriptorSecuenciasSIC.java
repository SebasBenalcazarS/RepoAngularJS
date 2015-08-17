package ec.com.smx.sic.cliente.persistencia.secuencia;

import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.SequenceDataBaseDescriptor;
import ec.com.smx.sic.cliente.resources.SICMessages;

/**
 * @author jmena
 *
 */
public class DescriptorSecuenciasSIC implements SequenceDataBaseDescriptor {
	public static final String NOMBRE_ESQUEMA = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.esquema.nombre");
	public String getSchemaName() {		
		return NOMBRE_ESQUEMA;
	}

}
