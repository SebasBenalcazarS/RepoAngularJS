package ec.com.smx.sic.articulo.gestor.batch.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ec.com.smx.sic.cliente.mdl.nopersistente.AlcanceArticuloTransient;

public class ArticuloRowMapper implements RowMapper<AlcanceArticuloTransient>{

	@Override
	public AlcanceArticuloTransient mapRow(ResultSet rs, int numRow)
			throws SQLException {
		
		AlcanceArticuloTransient alcanceArticuloTransient=new AlcanceArticuloTransient();
		alcanceArticuloTransient.setCodigoBarras(rs.getString("codigobarras"));
		alcanceArticuloTransient.setCodigoReferenciaGrupoAlcance(rs.getString("codigoreferencia"));
		alcanceArticuloTransient.setEstadoArticulo(rs.getString("estadoarticulo"));
		
		return alcanceArticuloTransient;
	}
}
