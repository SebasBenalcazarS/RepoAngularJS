package ec.com.smx.sic.cliente.gestor.procesamientoventas.administracion.accion.ftp;

import java.io.Serializable;

import org.springframework.batch.repeat.RepeatStatus;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAccionArchivosProcesamientoVentasGestor extends Serializable {

	RepeatStatus copiarArchivosFTP(final Long codigoProceso, final Integer codigoCompania) throws SICException;
}
