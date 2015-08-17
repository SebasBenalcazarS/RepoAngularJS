package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioTipoMarca;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.MarcaFuncionarioTipoMarcaDTO;
/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
public class ArticuloMarcaTipoFuncionarioMarcaRestriction implements CriteriaRestriction {
	
	private Collection<InformacionFuncionarioTipoMarca> infoTipMarFunList= null;
	private String patternCodigoMarca = null;
	private String patternValorTipoMarca = null;
	private String nombreCodigoMarca = null;
	public ArticuloMarcaTipoFuncionarioMarcaRestriction(Collection<InformacionFuncionarioTipoMarca> tipMarFunList, 
														String paternCodigoMarca, String paternValorTipoMarca, String nombreCodigoMarca){
		this.infoTipMarFunList = tipMarFunList;
		this.patternCodigoMarca = paternCodigoMarca;
		this.patternValorTipoMarca = paternValorTipoMarca;
		this.nombreCodigoMarca = nombreCodigoMarca;
		
	}
	
	
	@Override
	public Criterion getCriteriaRestriction() {
		
		Criterion criterion = null;
		ArrayList<Long> infoTipMarFunListConMarca = null;
		ArrayList<Long> infoTipMarFunListSinMarca = null;
		String patternTipo = StringUtils.isNotEmpty(this.patternValorTipoMarca) ? SearchDTO.getPropertyAlias(this.patternValorTipoMarca).concat(".valorTipoMarca") : "valorTipoMarca";
		try{
			/******RESTRICCI�N PARA N TIPOS DE MARCAS**********/
			infoTipMarFunListConMarca = new ArrayList<Long>();
			infoTipMarFunListSinMarca = new ArrayList<Long>();
			ArrayList<String> codigosCatalogoValor = new ArrayList<String>();
			//Se divide los tipos de marca con marca y sin marca asignados
			for(InformacionFuncionarioTipoMarca infFunTipMar:this.infoTipMarFunList ){
				if(infFunTipMar.getTieneMarcasAgregadas()){
					infoTipMarFunListConMarca.add(infFunTipMar.getCodigoFuncionarioTipoMarca());
				}else{
					infoTipMarFunListSinMarca.add(infFunTipMar.getCodigoFuncionarioTipoMarca());
					codigosCatalogoValor.add(infFunTipMar.getFuncionarioTipoMarca().getId().getCodigoCatalogoValor());
				}
			}
			
			//CASO 1 **** NING�N TIPO DE MARCA TIENE ASIGNADO MARCAS **********/
			if(CollectionUtils.isEmpty(infoTipMarFunListConMarca) && !CollectionUtils.isEmpty(infoTipMarFunListSinMarca)){
				if(infoTipMarFunListSinMarca.size() == this.infoTipMarFunList.size() && !CollectionUtils.isEmpty(codigosCatalogoValor)){
					criterion = Restrictions.in(patternTipo,codigosCatalogoValor);
				}
			}
			//CASO 2 ***** TODOS LOS TIPO DE MARCA TIENEN ASIGNADO MARCAS ********/
			else if(!CollectionUtils.isEmpty(infoTipMarFunListConMarca) && CollectionUtils.isEmpty(infoTipMarFunListSinMarca)){
				if(infoTipMarFunListConMarca.size() == this.infoTipMarFunList.size()){
					DetachedCriteria subSelectMarFunTipMar = DetachedCriteria.forClass(MarcaFuncionarioTipoMarcaDTO.class, "marcaFuncionarioTipoMarca");
					subSelectMarFunTipMar.setProjection(Projections.property("marcaFuncionarioTipoMarca.codigoMarca"));
					subSelectMarFunTipMar.add(Restrictions.in("marcaFuncionarioTipoMarca.codigoFuncionarioTipoMarca", infoTipMarFunListConMarca));
					subSelectMarFunTipMar.add(Restrictions.eq("marcaFuncionarioTipoMarca.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
					criterion = Subqueries.propertyIn(SearchDTO.getPropertyAlias(this.patternCodigoMarca).concat(".").concat(this.nombreCodigoMarca), subSelectMarFunTipMar);
				}
			}
			//CASO 3 ****** EXISTEN TIPOS CON MARCA Y TIPOS SIN MARCA ************/
			else if(!CollectionUtils.isEmpty(infoTipMarFunListConMarca) && 
					!CollectionUtils.isEmpty(infoTipMarFunListSinMarca) && 
					!CollectionUtils.isEmpty(codigosCatalogoValor)){
				//Armamos el array de codigos para hacer el IN en la restriccion..
				DetachedCriteria subSelectMarFunTipMar = DetachedCriteria.forClass(MarcaFuncionarioTipoMarcaDTO.class, "marcaFuncionarioTipoMarca");
				subSelectMarFunTipMar.setProjection(Projections.property("marcaFuncionarioTipoMarca.codigoMarca"));
				subSelectMarFunTipMar.add(Restrictions.in("marcaFuncionarioTipoMarca.codigoFuncionarioTipoMarca", infoTipMarFunListConMarca));
				subSelectMarFunTipMar.add(Restrictions.eq("marcaFuncionarioTipoMarca.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				criterion = Restrictions.or(Subqueries.propertyIn(SearchDTO.getPropertyAlias(this.patternCodigoMarca).concat(".").concat(this.nombreCodigoMarca), subSelectMarFunTipMar),
						Restrictions.in(patternTipo, codigosCatalogoValor));
			}
			
			
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n");
		}
		
		return criterion;
	}

}
