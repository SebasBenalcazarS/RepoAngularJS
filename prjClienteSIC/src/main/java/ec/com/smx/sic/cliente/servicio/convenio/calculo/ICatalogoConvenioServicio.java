package ec.com.smx.sic.cliente.servicio.convenio.calculo;


import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RangoSecuenciaCodigoBarrasDTO;

/**
 * Created by cbarahona on 25/09/2014.
 */
public interface ICatalogoConvenioServicio {
    
	/**
	 * @author cbarahona
	 * @return Collection<CatalogoValorDTO>
	 */
	Collection<CatalogoValorDTO> findEstadosProcesoPromocion();
    
    /**
     * @author cbarahona
     * @return Collection<CatalogoValorDTO>
     */
    Collection<CatalogoValorDTO> findFormasCobroPromocion() ;

    /**
     * @author cbarahona
     * @return Collection<CatalogoValorDTO>
     */
    Collection<CatalogoValorDTO> findPeriodicidadCortePromocion() ;

    /**
     * @author cbarahona
     * @return Collection<CatalogoValorDTO>
     */
    Collection<CatalogoValorDTO> findPlazoCobroPromocion() ;
    
    /**
     * @author cbarahona
     * @return Collection<CatalogoValorDTO>
     */
    Collection<CatalogoValorDTO> findTiposInicioCobroPromocion();
    
    /**
     * @author cbarahona
     * @return Collection<CatalogoValorDTO>
     */
    Collection<CatalogoValorDTO> findTiposAplicacionDescuentos();
    
    /**
     * @author cbarahona
     * @return Collection<CatalogoValorDTO>
     */
    Collection<CatalogoValorDTO> findTiposInicioCobroCampania();
    
    /**
     * @author cbarahona
     * @return Collection<CatalogoValorDTO>
     */
    Collection<CatalogoValorDTO> findEstadosCaducidadCampania();
    
    /**
     * @author cbarahona
     * @return Collection<CatalogoValorDTO>
     */
    Collection<CatalogoValorDTO> findPeriodicidadCortePromocionVentaCosto() ;
    
    Collection<RangoSecuenciaCodigoBarrasDTO> findRangoSecuenciaCupones() throws SICException ;
    
    /**
     * Consulta todos los catalogos utilizados en una sola consulta 
     * @author amunoz
     * @return
     * @throws SICException
     */
      Collection<CatalogoValorDTO> findInicializarCatalogosTipoFormaCobro(ArrayList<Integer>codigos) throws SICException;
    
}
