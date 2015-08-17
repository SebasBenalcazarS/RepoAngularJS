/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.procesamientoventas.ventas;

import java.io.Serializable;

import org.springframework.batch.item.ItemWriter;

import ec.com.smx.sic.cliente.mdl.nopersistente.procesamientoventas.MigrarDatosProcesoVentaDTO;

/**
 * @author vjaramillo
 *
 */
public interface IMigracionProcesamientoVentasItemWriter extends ItemWriter<MigrarDatosProcesoVentaDTO>, Serializable {

}
