package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.util.List;

import org.springframework.batch.item.file.FlatFileItemWriter;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.nopersistente.AlcanceArticuloTransient;

public class ArticuloAlcanceErrorItemWriter extends FlatFileItemWriter<AlcanceArticuloTransient>
{
	public void write(List<? extends AlcanceArticuloTransient> alcanceArticuloCol) throws Exception {
		try{
			super.write(alcanceArticuloCol);
		} catch (Exception e){
			Logeable.LOG_SICV2.error("Error al escribir el archivo: {}", e);
			throw e;
		}
	}
}