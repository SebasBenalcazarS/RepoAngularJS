package ec.com.smx.sic.cliente.persistencia.restricciones.comprador;

import java.io.Serializable;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.restricciones.ArticuloClienteRestriction;
import ec.com.smx.sic.cliente.persistencia.articulos.restricciones.UsuarioClasificacionRestriction;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.ClasificacionesPorClasificacionFuncionarioCompradorRestriction;

@SuppressWarnings("serial")
public class ClasificacionPorFuncionario implements Serializable{
	
	private FuncionarioDTO funcionarioDTO;
	private Boolean tieneLineaComercial;
	private String patternIn;
	private Boolean omitirRestriccionCliente = Boolean.FALSE;

	public ClasificacionPorFuncionario(Boolean tieneLineaComercial, FuncionarioDTO funcionarioDTO,String patternIn) {		
		this.funcionarioDTO = funcionarioDTO;		
		this.patternIn = patternIn;
		this.tieneLineaComercial = tieneLineaComercial;
		//PREGUNTAR SI DEBEN TENER LINCOMCLA ACT Y CLA ACT		
	}
	
	public CriteriaRestriction getCriteriaRestriction(){
		if(this.tieneLineaComercial){
			if(!this.omitirRestriccionCliente){
				final Disjunction disjunction = Restrictions.disjunction();
				ClasificacionesPorClasificacionFuncionarioCompradorRestriction clasificacionesPorClasificacionFuncionarioCompradorRestriction = new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(this.funcionarioDTO.getId().getCodigoFuncionario(), null, null, null, null, this.patternIn);
				ArticuloClienteRestriction articuloClienteRestriction = new ArticuloClienteRestriction(this.funcionarioDTO.getId().getCodigoFuncionario(), this.funcionarioDTO.getId().getCodigoCompania(), "codigoClienteImportacion");
				
				disjunction.add(clasificacionesPorClasificacionFuncionarioCompradorRestriction.getCriteriaRestriction());
				disjunction.add(articuloClienteRestriction.getCriteriaRestriction());
				
				CriteriaRestriction criteriaRestriction = new CriteriaRestriction() {
					
					@Override
					public Criterion getCriteriaRestriction() {
						// TODO Auto-generated method stub
						return disjunction;
					}
				};
				return criteriaRestriction;
			}else{
				return new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(this.funcionarioDTO.getId().getCodigoFuncionario(), null, null, null, null, this.patternIn);
			}
		}else{
			return new UsuarioClasificacionRestriction(funcionarioDTO.getUsuarioDTO(),this.patternIn);//Restriccion de usuarioclasificacion
		}
	}

	public void setOmitirRestriccionCliente(Boolean omitirRestriccionCliente) {
		this.omitirRestriccionCliente = omitirRestriccionCliente;
	}
}
