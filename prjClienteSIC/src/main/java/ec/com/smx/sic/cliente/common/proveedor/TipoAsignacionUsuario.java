package ec.com.smx.sic.cliente.common.proveedor;

public enum TipoAsignacionUsuario {
	
	USUARIOCLASIFICACION{
	    public String toString() {
	        return "clasificaciones";
	    }
	},
	USUARIOCOMPRADOR{
	    public String toString() {
	        return "comprador";
	    }
	}, 
	TODOS,
	NULL;
	
	
}
