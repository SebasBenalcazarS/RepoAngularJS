package ec.com.smx.sic.cliente.common;

/**
 * Clase para verificar en que sistema operativo esta ejecut&aacute;ndose la aplicaci&oacute;n
 * @author fnaranjo
 *
 */
public class OSValidator {
	private static String operativeSystemName = System.getProperty("os.name").toLowerCase();
	 
	public static boolean isWindows() {
 
		return (operativeSystemName.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac() {
 
		return (operativeSystemName.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix() {
 
		return (operativeSystemName.indexOf("nix") >= 0 || operativeSystemName.indexOf("nux") >= 0 || operativeSystemName.indexOf("aix") > 0 );
 
	}
 
	public static boolean isSolaris() {
 
		return (operativeSystemName.indexOf("sunos") >= 0);
 
	}
}
