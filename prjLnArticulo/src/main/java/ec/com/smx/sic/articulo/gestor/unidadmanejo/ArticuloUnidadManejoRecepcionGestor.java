package ec.com.smx.sic.articulo.gestor.unidadmanejo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloUnidadManejoDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.unidadManejo.IArticuloUnidadManejoRecepcionJugueteDAO;

/**
 * 
 * @author gaortiz
 *
 */
public class ArticuloUnidadManejoRecepcionGestor implements IArticuloUnidadManejoGestor {
	
	private IArticuloUnidadManejoRecepcionJugueteDAO articuloUnidadManejoRecepcionJugueteDAO;
	
	private IArticuloUnidadManejoDAO articuloUnidadManejoDAO;

	@Override
	public ArticuloUnidadManejoDTO registrarArticuloUnidadManejo(final ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException {
		this.articuloUnidadManejoRecepcionJugueteDAO.registrarUnidadMenajo(articuloUnidadManejoDTO);
		return articuloUnidadManejoDTO;
	}

	@Override
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException {
		 throw new UnsupportedOperationException();
	}

	@Override
	public Integer obtenerNumeroUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException {
		 throw new UnsupportedOperationException();
	}
	
	@Override
	public void registrarArticuloUnidadManejo(final ArticuloVO articuloVO) throws SICException {
		
		if( articuloVO.getBaseDTO().getTieneUnidadManejoCol() ){
			Logeable.LOG_SICV2.info("==> Registrando las unidad Manejo");
			for( ArticuloUnidadManejoDTO articuloUnidadManejoDTO : articuloVO.getBaseDTO().getArticuloUnidadManejoCol() ){
				articuloUnidadManejoDTO.setUserId(articuloVO.getBaseDTO().getUserId());
				this.registrarArticuloUnidadManejo(articuloUnidadManejoDTO);
			}
		}
		
	}

	public void actualizarUnidadManejoRecepcion(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException{
		Logeable.LOG_SICV2.info("==> Actualizando medidas de la unidad de manejo");
	}
	
	public ArticuloUnidadManejoDTO actualizarCantidadMaximaUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, CatalogoValorDTO tipoEmpaque, Integer valorUnidadManejo) throws SICException{
		throw new UnsupportedOperationException();
	}

	public void actualizarCodigoBarrasArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String codigoBarrasUnidadManejo) throws SICException {
		 throw new UnsupportedOperationException();
	}

	@Override
	public void aumentarPrioridadUnidadManejo(Integer prioridad, Integer codigoCompania, String codigoArticulo) throws SICException {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Integer inactivarUnidadManejoPorPrioridad(Integer codigoCompania, String codigoArticulo, Integer prioridad, String userId, Long... codigoUnidadManejo) throws SICException {
		return this.articuloUnidadManejoDAO.inactivarUnidadManejoPorPrioridad(codigoCompania, codigoArticulo, prioridad, userId, codigoUnidadManejo);
	}

	@Override
	public Integer asignarMaximaPrioridadUnidadManejo(Integer codigoCompania, String codigoArticulo, String userId, Long codigoUnidadManejo) throws SICException {
		return this.articuloUnidadManejoDAO.asignarMaximaPrioridadUnidadManejo(codigoCompania, codigoArticulo, userId, codigoUnidadManejo);
	}
	
	/**
	 * @param articuloUnidadManejoRecepcionJugueteDAO the articuloUnidadManejoRecepcionJugueteDAO to set
	 */
	public final void setArticuloUnidadManejoRecepcionJugueteDAO(IArticuloUnidadManejoRecepcionJugueteDAO articuloUnidadManejoRecepcionJugueteDAO) {
		this.articuloUnidadManejoRecepcionJugueteDAO = articuloUnidadManejoRecepcionJugueteDAO;
	}

	public void setArticuloUnidadManejoDAO(IArticuloUnidadManejoDAO articuloUnidadManejoDAO) {
		this.articuloUnidadManejoDAO = articuloUnidadManejoDAO;
	}

	@Override
	public Integer obtenerPrioridadDisponible(Integer codigoCompania, String codigoArticulo) throws SICException {
		throw new UnsupportedOperationException();
	}
}
