package ec.com.smx.sic.articulo.persistence.dao.ley.podermercado;

import java.text.MessageFormat;

import org.hibernate.Session;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloBitacoraLeyMercadoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.ley.podermercado.IArticuloBitacoraLeyMercadoDAO;

/**
 * Clase que se encarga del registro y obtencion de datos historicos de estados del articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
 * @author mgranda
 *
 */
public class ArticuloBitacoraLeyMercadoDAO implements IArticuloBitacoraLeyMercadoDAO, Logeable {
	
	private IHibernateH<ArticuloBitacoraLeyMercadoDTO> hibernateH;

	/**
	 * Metodo que registra la informacion historica de los estados del articulo
	 * @author mgranda
	 * @param articuloBitacoraLeyMercadoDTO
	 * @throws SICException
	 */
	@Override
	public void crearArticuloBitacoraLeyMercado(ArticuloBitacoraLeyMercadoDTO articuloBitacoraLeyMercadoDTO) throws SICException{
		LOG_SICV2.info("==> Registrando ArticuloBitacoraLeyMercado");
		try{
			final Session session = hibernateH.getHibernateSession();
			session.clear();
			hibernateH.crearObjeto(articuloBitacoraLeyMercadoDTO);
			LOG_SICV2.info(MessageFormat.format("Secuencial generado para ArticuloBitacoraLeyMercado es {0}",articuloBitacoraLeyMercadoDTO.getId().getSecuencial()));
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al registrar ArticuloBitacoraLeyMercado.",e.getMessage());
		}
	}

	public void setHibernateH(IHibernateH<ArticuloBitacoraLeyMercadoDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
