package ec.com.smx.sic.webservices.commons.mindata.frameworkv2;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lchasipanta
 *
 */
public class MinifiedFavoriteObjectData{
	List<SimpleModuleData> lstSimpleModuleDatas = new ArrayList<MinifiedFavoriteObjectData.SimpleModuleData>();
	
	/**
	 * @param moduleName
	 * @param moduleUrl
	 */
	public void addMinModuleData(String moduleName, String moduleUrl){
		SimpleModuleData simpleModuleData = new SimpleModuleData(moduleName, moduleUrl);
		lstSimpleModuleDatas.add(simpleModuleData);
	}
	
	/**
	 * @param index
	 * @param optionName
	 * @param optionUrl
	 * @param styleName
	 */
	public void addMinModuleOptionData(int index, String optionName, String optionUrl, String styleName){
		SimpleOptionData simpleOptionData = new SimpleOptionData(optionName, optionUrl, styleName);
		lstSimpleModuleDatas.get(index).addMinOptionData(simpleOptionData);
	}
	
	class SimpleModuleData{
		String idModule;
		String nameModule;
		List<SimpleOptionData> lstSimpleOptionDatas = new ArrayList<MinifiedFavoriteObjectData.SimpleOptionData>();
		
		/**
		 * @param idModule
		 * @param nameModule
		 */
		public SimpleModuleData(String idModule, String nameModule) {
			this.nameModule = nameModule;
			this.idModule = idModule;
		}
		
		/**
		 * @param simpleOptionData
		 */
		public void addMinOptionData(SimpleOptionData simpleOptionData){
			lstSimpleOptionDatas.add(simpleOptionData);
		}
	}
	
	/**
	 * @author lchasipanta
	 *
	 */
	class SimpleOptionData{
		String nameOption;
		String urlOption;
		String styleName;
		
		/**
		 * @param nameOption
		 * @param urlOption
		 * @param styleName
		 */
		public SimpleOptionData(String nameOption, String urlOption, String styleName){
			this.nameOption = nameOption;
			this.urlOption = urlOption;
			this.styleName = styleName;
		}
	}
	
}