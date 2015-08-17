package ec.com.smx.sic.cliente.persistencia.convenio.dao;


import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RangoSecuenciaCodigoBarrasDTO;

/**
 * DAO para obtener los cat&aacute;logos utilizados en el m&oacute;dulo de convenios
 * Created by cbarahona on 25/09/2014.
 */
public interface ICatalogoConvenioDAO {
    /**
     * @author cbarahona
     * @param codigoCatalogoTipo
     * @return
     */
    Collection<CatalogoValorDTO> findCatalogoConvenio(Integer codigoCatalogoTipo);
    
    Collection<RangoSecuenciaCodigoBarrasDTO> findRangoSecuenciaCupones() throws SICException;
    
    Collection<CatalogoValorDTO> findCatalogoConvenio(ArrayList<Integer>codigos) throws SICException;
    
}
