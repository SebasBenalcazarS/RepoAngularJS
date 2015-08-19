package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;

/**
 * 
 * @author wcaiza
 *
 * @param <T>
 */
public class ArticuloEstablecimientoMigracionNoSqlItemWriter<T extends SearchDTO> implements ItemWriter<ArticuloEstablecimientoDTO>, Logeable {
	
//	private IAlmacenamientoArticuloAlcanceNoSqlGestor almacenamientoArticuloAlcanceNoSqlGestor;
	private Integer codigoCompania;
	/**
	 * Sufijo de la tabla de donde se va consultar los datos OFI, LOC, BOD
	 */
	private String sufijoTabla;
	
//	/**
//	 * @param almacenamientoArticuloAlcanceNoSqlGestor the almacenamientoArticuloAlcanceNoSqlGestor to set
//	 */
//	public void setAlmacenamientoArticuloAlcanceNoSqlGestor(IAlmacenamientoArticuloAlcanceNoSqlGestor almacenamientoArticuloAlcanceNoSqlGestor) {
//		this.almacenamientoArticuloAlcanceNoSqlGestor = almacenamientoArticuloAlcanceNoSqlGestor;
//	}

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
	public void write(List<? extends ArticuloEstablecimientoDTO> objetoCol) throws Exception {
		
		if (CollectionUtils.isEmpty(objetoCol)) {
			LOG_SICV2.info("No hay ArticuloEstablecimientoDTO para migrar");
		} else {
			
			LOG_SICV2.info("Total ArticuloEstablecimientoDTO a procesar {}", objetoCol.size());
			
			Collection<ArticuloEstablecimientoDTO> colArticuloEstablecimientoDTO = (Collection<ArticuloEstablecimientoDTO>) objetoCol;
//			this.almacenamientoArticuloAlcanceNoSqlGestor.migrarArticuloEstablecimiento(this.codigoCompania, colArticuloEstablecimientoDTO, this.sufijoTabla);
			SICFactory.getInstancia().articulo.getArticuloAlcanceNoSqlServicio().
					findMigrarArticuloEstablecimientoWriter(this.codigoCompania, colArticuloEstablecimientoDTO, this.sufijoTabla);
			
		}
		
	}
	
}