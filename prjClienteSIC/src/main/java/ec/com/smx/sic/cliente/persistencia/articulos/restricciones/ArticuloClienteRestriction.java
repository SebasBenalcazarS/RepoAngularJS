package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;

/** 
 * Clase que implementa una res
 * en el cual se muestran un arbol de EC
 * @author fmunoz, mgranda
 * @version 1.0
 * @since 17/02/2012  
 */
@SuppressWarnings("serial")
public class ArticuloClienteRestriction implements CriteriaRestriction{

	private String codigoFuncionario = null;
	private Integer codigoCompania = null;
	private String patternIn;	
	
	public ArticuloClienteRestriction(String codigoFuncionario, Integer codigoCompania, String patternIn) {
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.codigoCompania = codigoCompania;
		this.patternIn = patternIn;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		try{
			
			StringBuilder subSelectCliente = new StringBuilder(this.patternIn);
			subSelectCliente.append(" IN (SELECT LCLI.CODIGOCLIENTEIMPORTACION FROM SCADMTLINCOMFUN LCF")
			.append(" INNER JOIN SCADMTLINCOM LC ON LCF.CODIGOCOMPANIA = LC.CODIGOCOMPANIA AND LCF.CODIGOLINEACOMERCIAL = LC.CODIGOLINEACOMERCIAL")
			.append(" INNER JOIN SCADMTLINCOMCLIIMP LCLI ON LC.CODIGOCOMPANIA = LCLI.CODIGOCOMPANIA AND LC.CODIGOLINEACOMERCIAL = LCLI.CODIGOLINEACOMERCIAL")
			.append(" WHERE LCF.CODIGOCOMPANIA = ? AND LCF.CODIGOFUNCIONARIO = ? AND LCF.ESTADO = ? AND LC.ESTADO = ? AND LCLI.ESTADO = ?)");
			
			criterion = Restrictions.sqlRestriction(subSelectCliente.toString(), new Object[]{this.codigoCompania, this.codigoFuncionario, SICConstantes.ESTADO_ACTIVO_NUMERICO, SICConstantes.ESTADO_ACTIVO_NUMERICO, SICConstantes.ESTADO_ACTIVO_NUMERICO}, new Type[]{StandardBasicTypes.INTEGER, StandardBasicTypes.STRING, StandardBasicTypes.STRING, StandardBasicTypes.STRING, StandardBasicTypes.STRING} );	
			return 	criterion;
		}catch (Exception e) {
			throw new SICException("Se produjo un error al momento de armar la restricci\u00F3n de cliente.");
		}
	}

}
