package ec.com.smx.sic.cliente.persistencia.articulos.dao.pendienteintegracion;

public interface IArticuloPendienteIntegracionDAO {

	Long contarArticuloNovedad(Integer codigoCompania, String codigoArticulo, String valorTipoProceso);

}
