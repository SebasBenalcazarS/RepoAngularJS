/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.batch.rowmapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import ec.com.smx.sic.cliente.mdl.nopersistente.MigracionArticuloAreaTrabajoTransient;

/**
 * @author jmontenegro
 *
 */
public class MigracionArticuloAreaTrabajoRowMapper implements FieldSetMapper<MigracionArticuloAreaTrabajoTransient> {

	@Override
	public MigracionArticuloAreaTrabajoTransient mapFieldSet(FieldSet fieldSet) throws BindException {
		
		MigracionArticuloAreaTrabajoTransient migracionArticuloAreaTrabajoTransient=new MigracionArticuloAreaTrabajoTransient();
		migracionArticuloAreaTrabajoTransient.setCodigoAreaTrabajo(fieldSet.readString("CODIGOAREATRABAJO"));
		migracionArticuloAreaTrabajoTransient.setCodigoBarras(fieldSet.readString("CODIGOBARRAS"));
		migracionArticuloAreaTrabajoTransient.setEstadoAlcance(fieldSet.readString("ESTADOALCANCE"));
		
		return migracionArticuloAreaTrabajoTransient;
	}

	
	
	
}
