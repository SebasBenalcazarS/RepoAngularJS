package ec.com.smx.sic.cliente.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.OrderDTO;

public class SICFactoryTest {
	@Test
	public void testFactory(){
		DOMConfigurator.configure("logging.xml");		
//		Logeable.LOG_SICV2.info("======================================================");
//		Logeable.LOG_SICV2.info(SICFactory.administracion);
//		Logeable.LOG_SICV2.info("======================================================");
		SICFactory.getInstancia().administracion.getDataService().findObjects(new OrderDTO());
	}
}
