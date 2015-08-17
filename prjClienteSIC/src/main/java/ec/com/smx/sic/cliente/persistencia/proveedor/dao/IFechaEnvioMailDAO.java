package ec.com.smx.sic.cliente.persistencia.proveedor.dao;

import java.sql.Timestamp;

public interface IFechaEnvioMailDAO {

	public abstract Timestamp obtenerFechaEnvioMail(String email,
			String codigoSistema, String codigoEvento, int codigoCompania);

}