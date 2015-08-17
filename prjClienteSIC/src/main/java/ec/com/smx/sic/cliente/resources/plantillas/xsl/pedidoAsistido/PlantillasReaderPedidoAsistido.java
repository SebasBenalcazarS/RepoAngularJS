package ec.com.smx.sic.cliente.resources.plantillas.xsl.pedidoAsistido;

import java.net.URL;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author finga
 *
 */
public class PlantillasReaderPedidoAsistido implements Logeable {

	private final static PlantillasReaderPedidoAsistido INSTANCIA = new PlantillasReaderPedidoAsistido();

	public Document obtenerPlantilla(String name) {
		SAXBuilder builder;
		builder = new SAXBuilder(false);
		Document document;
		URL url = null;

		try {
			url = this.getClass().getResource((name));
			document = builder.build(url);
			return document;
		} catch (Exception ex) {
			LOG_SICV2.error("error al obtener plantilla {}", ex);
			throw new SICException(ex);
		}

	}

	public URL obtenerPlantillaUrl(String name) {
		URL url = null;
		try {
			url = this.getClass().getResource((name));
			return url;
		} catch (Exception ex) {
			LOG_SICV2.error("error al obtener plantilla {}", ex);
			throw new SICException(ex);
		}

	}

	/**
	 * @return the instancia
	 */
	public static PlantillasReaderPedidoAsistido getInstancia() {
		return INSTANCIA;
	}
}
