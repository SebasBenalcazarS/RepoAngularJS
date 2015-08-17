/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.secuencia;


import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.SequenceDataBaseDescriptor;
import ec.com.smx.sic.cliente.resources.SICMessages;

/**
 * @author jvillacis
 *
 */
public class ImpcorpDescriptorSecuencias implements SequenceDataBaseDescriptor{
	public String getSchemaName(){
		return SICMessages.getInstancia().getString("esquema.impcorp");
	}
}
