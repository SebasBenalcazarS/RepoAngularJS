package ec.com.smx.sic.webservices.commons.mindata.frameworkv2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aecaiza
 *
 */
public class MinifiedSystemData{
	/**
	 * Lista para guardar la lista de sistemas
	 */
	List<SimpleSystemData> lstSimpleSystemDatas = new ArrayList<MinifiedSystemData.SimpleSystemData>();
	/**
	 * @param idSystem
	 * @param nameSystem
	 * @param aliasSystem
	 * @param urlSystem
	 * @param contextpathSystem
	 * @param defaultInitPage
	 */
	public void addMinSystemData(String idSystem, String nameSystem, String aliasSystem, String urlSystemTarget, String contextpathSystem, String defaultInitPage ) {
		SimpleSystemData simpleSystemData = new SimpleSystemData(idSystem, nameSystem, aliasSystem, urlSystemTarget, contextpathSystem, defaultInitPage);
		lstSimpleSystemDatas.add(simpleSystemData);
	}
	
	class SimpleSystemData{
		String idSystem;
		String nameSystem;
		String aliasSystem;
		String urlSystem;
		String contextpathSystem;
		String defaultInitPage;
		
		/**
		 * @param idSystem
		 * @param nameSystem
		 * @param aliasSystem
		 * @param urlSystem
		 * @param contextpathSystem
		 * @param defaultInitPage
		 */
		public SimpleSystemData(String idSystem, String nameSystem, String aliasSystem, String urlSystemTarget, String contextpathSystem, String defaultInitPage){
			this.idSystem = idSystem;
			this.nameSystem = nameSystem;
			this.aliasSystem = aliasSystem;
			this.urlSystem = urlSystemTarget;
			this.contextpathSystem = contextpathSystem;
			this.defaultInitPage= defaultInitPage;
		}
	}
}