
package ec.com.smx.sic.cliente.gestor.recargacupon;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ContenidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ContenidoDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ContenidoVO;


public interface IContenidoGestor {
	
	public Long crearContenido(ContenidoVO contenidoVO) throws SICException;
	public Collection<ContenidoDTO> findContenido() throws SICException;
	public Collection<ContenidoDTO> findContent() throws SICException;
	public void showPromotions(Collection<Long> promotionIds,Boolean showPromotions);
	public List<ContenidoDefinicionArchivoDTO> findFiles(Collection<Long> fileIds);

}
