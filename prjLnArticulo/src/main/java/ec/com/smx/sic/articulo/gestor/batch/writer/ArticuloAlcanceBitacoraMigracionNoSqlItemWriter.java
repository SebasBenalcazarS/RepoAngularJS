package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento.IAlmacenamientoArticuloAlcanceNoSqlGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;

/**
 * 
 * @author wcaiza
 *
 * @param <T>
 */
public class ArticuloAlcanceBitacoraMigracionNoSqlItemWriter<T extends SearchDTO> implements ItemWriter<ArticuloAreaTrabajoBitacoraDTO>, Logeable {
	
	private IAlmacenamientoArticuloAlcanceNoSqlGestor almacenamientoArticuloAlcanceNoSqlGestor;
	private Integer codigoCompania;
	/**
	 * Sufijo de la tabla de donde se va consultar los datos OFI, LOC, BOD
	 */
	private String sufijoTabla;
	
	/**
	 * @param almacenamientoArticuloAlcanceNoSqlGestor the almacenamientoArticuloAlcanceNoSqlGestor to set
	 */
	public void setAlmacenamientoArticuloAlcanceNoSqlGestor(IAlmacenamientoArticuloAlcanceNoSqlGestor almacenamientoArticuloAlcanceNoSqlGestor) {
		this.almacenamientoArticuloAlcanceNoSqlGestor = almacenamientoArticuloAlcanceNoSqlGestor;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @param sufijoTabla the sufijoTabla to set
	 */
	public void setSufijoTabla(String sufijoTabla) {
		this.sufijoTabla = sufijoTabla;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void write(List<? extends ArticuloAreaTrabajoBitacoraDTO> objetoCol) throws Exception {
		
		if (CollectionUtils.isEmpty(objetoCol)) {
			LOG_SICV2.info("No hay ArticuloAreaTrabajoBitacoraDTO para migrar");
		} else {
			
			LOG_SICV2.info("Total ArticuloAreaTrabajoBitacoraDTO a procesar {}", objetoCol.size());
			
			Collection<ArticuloAreaTrabajoBitacoraDTO> colArticuloAreaTrabajoBitacoraDTO = (Collection<ArticuloAreaTrabajoBitacoraDTO>) objetoCol;
			this.almacenamientoArticuloAlcanceNoSqlGestor.migrarArticuloLocalBitacora(this.codigoCompania, colArticuloAreaTrabajoBitacoraDTO, this.sufijoTabla);
		}
		
	}
	
}