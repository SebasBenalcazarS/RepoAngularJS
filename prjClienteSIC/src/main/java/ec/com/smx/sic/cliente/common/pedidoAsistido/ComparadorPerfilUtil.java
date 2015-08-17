/**
 * 
 */
package ec.com.smx.sic.cliente.common.pedidoAsistido;

import ec.com.smx.sic.cliente.common.pedidoAsistido.SICPedidoAsistidoConstantes;

/**
 * @author bsandoval
 *
 */
public class ComparadorPerfilUtil {

	public ComparadorPerfilUtil(){

	}

	public static String verificarPerfil(String perfil){

		String perfilDevuelto="";

		String perfilesComercialesCad[]=SICPedidoAsistidoConstantes.CODIGO_PERFIL_COMERCIAL.toString().split(",");
		String perfilesBodegasCad[]=SICPedidoAsistidoConstantes.CODIGO_PERFIL_BODEGA.toString().split(",");
		String perfilesLocalesCad[]=SICPedidoAsistidoConstantes.CODIGO_PERFIL_LOCAL.toString().split(",");
		String perfilesSistemasCad[]=SICPedidoAsistidoConstantes.CODIGO_PERFIL_SISTEMAS.toString().split(",");
		String perfilesAdminLocalCad[]=SICPedidoAsistidoConstantes.CODIGO_PERFIL_ADMINISTRADOR_LOCAL.toString().split(",");

		for (String sistemas : perfilesSistemasCad) {
			if(sistemas.equalsIgnoreCase(perfil))
				perfilDevuelto=SICPedidoAsistidoConstantes.NOMBRE_PERFIL_SISTEMAS;
		}
		if(perfilDevuelto.equalsIgnoreCase("")){

			for (String local : perfilesLocalesCad) {
				if(local.equalsIgnoreCase(perfil)){
					perfilDevuelto=SICPedidoAsistidoConstantes.NOMBRE_PERFIL_LOCAL;
				}
			}
		}
		if(perfilDevuelto.equalsIgnoreCase("")){

			for (String local : perfilesAdminLocalCad) {
				if(local.equalsIgnoreCase(perfil)){
					perfilDevuelto=SICPedidoAsistidoConstantes.NOMBRE_PERFIL_ADMIN_LOCAL;
				}
			}
		}
		if(perfilDevuelto.equalsIgnoreCase("")){
			for (String bodega : perfilesBodegasCad) {
				if(bodega.equalsIgnoreCase(perfil)){
					perfilDevuelto=SICPedidoAsistidoConstantes.NOMBRE_PERFIL_BODEGA;
				}
			}
		}
		if(perfilDevuelto.equalsIgnoreCase("")){
			for (String comercial : perfilesComercialesCad) {
				if(comercial.equalsIgnoreCase(perfil)){
					perfilDevuelto=SICPedidoAsistidoConstantes.NOMBRE_PERFIL_COMERCIAL;
				}
			}
		}
		return perfilDevuelto;


	}

}
