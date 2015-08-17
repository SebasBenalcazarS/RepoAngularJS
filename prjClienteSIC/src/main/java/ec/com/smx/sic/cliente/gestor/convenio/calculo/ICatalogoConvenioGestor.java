package ec.com.smx.sic.cliente.gestor.convenio.calculo;


import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RangoSecuenciaCodigoBarrasDTO;

/**
 * Created by cbarahona on 25/09/2014.
 */
public interface ICatalogoConvenioGestor {
	
	/** Metodo que retorna los estados de procesos de una promocion
	 * @author srodriguez
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO>
	 */
    Collection<CatalogoValorDTO> findEstadosProcesoPromocion();

    /** Metodo que retorna formas de cobro de una promocion
	 * @author srodriguez
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO>
	 */
    Collection<CatalogoValorDTO> findFormasCobroPromocion() ;
    
    /** Metodo que retorna formas de cobro de una promocion
	 * @author srodriguez
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO>
	 */
    Collection<CatalogoValorDTO> findPeriodicidadCortePromocion() ;
    
    /** Metodo que retorna plazo de cobro de una promocion
	 * @author srodriguez
	 * @author khidalgo
	 * @author cbarahona
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO>
	 */
    Collection<CatalogoValorDTO> findPlazoCobroPromocion() ;
    
    /** Metodo que retorna tipos de inicio de cobro promocion
	 * @author srodriguez
	 * @author khidalgo
	 * @author cbarahona
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO> 
	 */
    Collection<CatalogoValorDTO> findTiposInicioCobroPromocion();
    
    /** Metodo que retorna tipos aplicacion descuentos
	 * @author srodriguez
	 * @author khidalgo
	 * @author cbarahona
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO> 
	 */
    Collection<CatalogoValorDTO> findTiposAplicacionDescuentos();
    
    /** Metodo que retorna aplicaciones de descuento
	 * @author srodriguez
	 * @author khidalgo
	 * @author cbarahona
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO> 
	 */
    Collection<CatalogoValorDTO> findTiposInicioCobroCampania();
    
    /** Metodo que retorna estados caducidad de una campania
	 * @author srodriguez
	 * @author khidalgo
	 * @author cbarahona
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO>
	 */
    Collection<CatalogoValorDTO> findEstadosCaducidadCampania();
    
    /** Metodo que retorna periodicidad de corte promocion venta costo
	 * @author srodriguez
	 * @author khidalgo
	 * @author cbarahona
	 * 9/1/2015
	 * @return Collection<CatalogoValorDTO> 
	 */
    Collection<CatalogoValorDTO> findPeriodicidadCortePromocionVentaCosto() ;
    
    /**
     * 
     * @return
     * @throws SICException
     */
    Collection<RangoSecuenciaCodigoBarrasDTO> findRangoSecuenciaCupones() throws SICException;
    
    /**
     * Consulta todos los catalogos utilizados en una sola consulta 
     * @author amunoz
     * @return
     * @throws SICException
     */
      Collection<CatalogoValorDTO> findInicializarCatalogosTipoFormaCobro(ArrayList<Integer>codigos) throws SICException;
    
}
