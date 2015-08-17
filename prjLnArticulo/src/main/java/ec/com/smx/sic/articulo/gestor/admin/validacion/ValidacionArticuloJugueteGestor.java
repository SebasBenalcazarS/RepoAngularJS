/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.validacion;

import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloJugueteGestor;
import ec.com.smx.sic.cliente.resources.SICMessages;

/**
 * @author jvillacis
 *
 */
public class ValidacionArticuloJugueteGestor implements Logeable, IValidacionArticuloJugueteGestor {

	private IParametroGestor parametroGestor;
	private DataGestor dataGestor;
	
	@Override
	public boolean esArticuloJuguete(String parametroCodigosClientes, String siglaCliente) throws SICException {
		boolean esArticuloJuguete;
		
		try{
			esArticuloJuguete = (Arrays.asList(parametroCodigosClientes.split(","))).contains(siglaCliente);
		}catch(Exception e){
			LOG_SICV2.error("Error en esArticuloJuguete: {}", e);
			throw new SICException("Error al validar si el cliente de importaciones es de la l\u00EDnea de juguetes");
		}
		
		return esArticuloJuguete;
	}

	@Override
	public boolean validarEsOrdenCompraJuguetes(Integer codigoCompania, HashSet<String> codigosReferenciaLineaComercialUsuario) throws SICException {
		String codigosClientes = null;
		boolean esOrdenCompraJuguetes = false;
		try {
			//Consulta codigo de clientes para generar ordenes de compra para la recepcion de juguetes
			codigosClientes = this.parametroGestor.obtenerParametro(codigoCompania, 
			 				SICParametros.getInstancia().CODIGOS_CLIENTES_CORPORACION_PRECODIFICADOS_ORDENCOMPRA, 
			 				SICMessages.getInstancia().getString("ec.com.smx.codigo.sistema.sic")).getValorParametro();
			if (StringUtils.isBlank(codigosClientes)) {
				throw new SICException("No se obtuvo los c\u00F3digos de cliente autorizados para generar \u00F3rdenes de compra para la recepci\u00F3n");
			}
			//Se consulta si el usuario tiene asociado el codigo de referencia de la linea comercial a los codigos de cliente de juguetes
			for (String codigoReferencia : codigosReferenciaLineaComercialUsuario) {
				if (StringUtils.isNotBlank(codigoReferencia) && esArticuloJuguete(codigosClientes, codigoReferencia)) {
					esOrdenCompraJuguetes = true;
					break;
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error en validar orden de compra manual para juguetes: {}", e);
			throw new SICException("Error al validar si las l\u00EDneas comerciales del usuario generan ordenes de compra manuales para la l\u00EDnea de juguetes");
		}
		return esOrdenCompraJuguetes;
	}
	
	@Override
	public boolean esAreaTrabajoCaracteristicaJuguetes(Integer codigoCompania, Integer codigoAreaTrabajoSubbodega) throws SICException{
		CaracteristicaProcesoAreaTrabajoDTO carBodOrdComFiltro;
		boolean areaTrabajoJuguetes;
		try {
			carBodOrdComFiltro = new CaracteristicaProcesoAreaTrabajoDTO();
			carBodOrdComFiltro.getId().setCodigoCompania(codigoCompania);
			carBodOrdComFiltro.setCaracteristicaCatalogoTipo(9123);
			carBodOrdComFiltro.setCodigoAreaTrabajo(codigoAreaTrabajoSubbodega);
			carBodOrdComFiltro.setCaracteristicaCatalogoValor("MAN");
			carBodOrdComFiltro.addCriteriaSearchParameter("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO);
			carBodOrdComFiltro = dataGestor.findUnique(carBodOrdComFiltro);
			
			areaTrabajoJuguetes = (carBodOrdComFiltro == null) ? false : Boolean.parseBoolean(carBodOrdComFiltro.getValorCaracteristica());
			
		} catch (Exception ex) {
			LOG_SICV2.error("Error al validar subbodega de juguetes, {}, {}", codigoAreaTrabajoSubbodega, ex);
			throw new SICException("Error al validar el area de trabajo de la subbodega: " + codigoAreaTrabajoSubbodega, ex);
		}
		return areaTrabajoJuguetes;
	}

	
	/*GETTERS AND SETTERS*/
	/**
	 * @param parametroGestor the parametroGestor to set
	 */
	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
}
