/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.framework.common.util.ClasesUtil;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.annotation.Compare;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.resources.cambioprecios.SICCambioPreciosMessages;

/**
 * 
 * @author Luis Yacchirema
 *
 */
public final class CambioPreciosUtil {

	private static final CambioPreciosUtil INSTANCE = new CambioPreciosUtil();

	private CambioPreciosUtil(){}

	public static CambioPreciosUtil getInstance(){
		return INSTANCE;
	}

	/**
	 * Metodo para obtener el articuloPrecio de un gestion o gestiones de precio obtenidas.
	 * @param articulosPrecio
	 * @param tipoPrecio
	 * @return
	 * @throws SICException
	 */
	public ArticuloPrecioDTO obtenerArticuloPrecioPorTipo(Collection<ArticuloPrecioDTO> articulosPrecio, String tipoPrecio) throws SICException {

		ArticuloPrecioDTO resultadoArticuloPrecio;

		try {

			// Inicializar variables
			resultadoArticuloPrecio = null;

			if (StringUtils.isNotEmpty(tipoPrecio) && CollectionUtils.isNotEmpty(articulosPrecio)) {
				resultadoArticuloPrecio = (ArticuloPrecioDTO) CollectionUtils.find(articulosPrecio,
						PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoTipoPrecio"),PredicateUtils.equalPredicate(tipoPrecio)));
			}

			return resultadoArticuloPrecio;

		} catch (Exception e) {
			throw new SICException("Error al obtener un tipo de precio de un art\u00EDculo", e);
		} finally {
			resultadoArticuloPrecio = null;
		}
	}


	/**
	 * 
	 * @param date
	 * @return
	 */
	public Date getDateFormated(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(SICCambioPreciosMessages.getInstancia().getString("formato.fecha"));

		try {
			String lsDate = sdf.format(date);
			return sdf.parse(lsDate);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al obtener el formato de fecha. Mensaje de error: "+ e);
			return null;
		}
	}


	public Integer calcularIteracionesConsultasDinamicas(Integer totalItems, Integer totalItemsPorConsulta) {

		return ((totalItems % totalItemsPorConsulta) == 0 ? (totalItems / totalItemsPorConsulta) : ((totalItems / totalItemsPorConsulta) + 1));

	}

	private Duplex<Integer,Integer> calcularIndexInicioYFinParaConsultasDinamicas(Integer totalItems, Integer totalItemsPorConsulta, Integer iteracionActual) {

		return new Duplex<Integer, Integer>((totalItemsPorConsulta * iteracionActual),
				((totalItemsPorConsulta * (iteracionActual+1)) <= totalItems ? (totalItemsPorConsulta * (iteracionActual+1)) : totalItems));

	}

	public <T extends Object> Set<T> obtenerItemsConsultaPorIteracionActual(Set<T> itemsTotales, Integer totalItemsPorConsulta, Integer iteracionActual) {

		Duplex<Integer,Integer> indicesConsulta = this.calcularIndexInicioYFinParaConsultasDinamicas(itemsTotales.size(), totalItemsPorConsulta, iteracionActual);

		return new HashSet<T>(new ArrayList<T>(itemsTotales).subList(indicesConsulta.getFirstObject(), indicesConsulta.getSecondObject()));

	}

	public <T extends SearchDTO> void respaldarValorPropiedadesComparables(T objetoPorRespaldar) {

		// Campos a comparar del objeto principal
		Collection<Field> campos = ClasesUtil.getFieldsByAnnotation(objetoPorRespaldar, Compare.class);

		// Existen campos por comparar
		if (CollectionUtils.isNotEmpty(campos))
			for (Field campoActual : campos) {
				objetoPorRespaldar.addDynamicProperty(campoActual.getName(), ClasesUtil.invocarMetodoGet(objetoPorRespaldar, campoActual.getName()));
			}

	}

	public <T extends SearchDTO> void respaldarValorPropiedadesComparables(Collection<T> objetosPorRespaldar) {

		// Respaldar datos de cada objeto
		if (CollectionUtils.isNotEmpty(objetosPorRespaldar)) {
			for (T objetoRespaldar : objetosPorRespaldar) {
				respaldarValorPropiedadesComparables(objetoRespaldar);
			}
		}

	}


	public String parsearValor(String cellValue) throws SICException {

		if (StringUtils.isEmpty(cellValue) && StringUtils.equals(cellValue, ""))
			return "";
		
		String celdaTexto = (new BigDecimal(cellValue)).toPlainString();

		if (StringUtils.contains(celdaTexto, ".")){
			String[] arrayFomato = StringUtils.split(celdaTexto,"\\.");
			return arrayFomato[0];
		} else {
			return celdaTexto;
		}
	}
}
