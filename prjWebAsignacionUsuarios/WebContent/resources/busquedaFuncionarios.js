angular.module('asignacionUsuarios',['ngRoute','angularGrid', 'checklist-model','ui.bootstrap', 'kendo.directives'])
	.constant('APP_NAME','ASIGNACIONUSUARIOS')
	.constant('APP_VERSION','1.0')
	.constant('PROPIEDADES', {
		"propiedades" :	{
			"codigoCompania": "1",
		  	"server" : "http://localhost",
		  	"port"	: ":8080",
		    "urlWebServiceFuncionarios": "/prjWebServicesSICWeb/ws/autorizacionUsuarios/datosfuncionarios?codigoCompania=1&codigoLocal=101&usuarioSesion=FRM0&usuario",
		    "urlWebServiceClasificacionNoRelacionadaUsuario" : {
		    	"url" : "/prjWebServicesSICWeb/ws/autorizacionUsuarios/clasificacionesUsuario",
		    	"codigoCompania": 1,
		    	"maxResult": 500,
		    	"firstResult" : 0,
		    	"usuarioSesion" : "%22USU03%22",
		    	"codigoEstructuraComercial" : "",
		    	"codigoSubbodega" : ""
		    },
		    "urlWebServiceBuscarArticulos":{
		    	"url" : "/prjWebServicesSICWeb/ws/autorizacionUsuarios/findAllArticulos",
		    	"codigoCompania": 1,
		    	"maxResult": 500,
		    	"firstResult" : 0,
		    	"usuarioSesion" : 'USU03',
		    	"codigoBarras" : "",
		    	"descripcion" : "",
		    	"codigoEstructura" : ""
		    },		    
		    "urlWebServiceArticulosNoRelacionadaUsuario" : {
		    	"url" : "/prjWebServicesSICWeb/ws/autorizacionUsuarios/findAllArticulos",
		    	"codigoCompania": 1,
		    	"maxResult":100,
		    	"firstResult" : 0,
		    	"usuarioSesion" : 'USU03',
		    	"codigoBarras" : "",
		    	"descripcion" : "",
		    	"codigoEstructura" : ""
		    },
		    "urlWebServiceClasificacionRelacionadaUsuario" : {
		    	"url" : "/prjWebServicesSICWeb/ws/autorizacionUsuarios/clasificacionesPorUsuario",
		    	"codigoCompania": 1,
		    	"usuarioSesion" : ""
		    },
		    //pendiente modificar la url del web service para obtener las clases de los articulos
		    "urlWebServiceObtenerClasesArticulos" : "/prjWebServicesSICWeb/ws/autorizacionUsuarios/clasesArticulos?codigoCompania=1",
		    	//"codigoCompania": 1,
		    	//"status" : "ACT"
		    "urlWebServiceArticulosRelacionadosUsuario" : {
		    	"url" : "/prjWebServicesSICWeb/ws/autorizacionUsuarios/articulosPorUsuario",
		    	"codigoCompania": 1,
		    	"usuario" : "",
		    	"maxResult": 500,
		    	"firstResult" : 0,
		    },
		    "urlWebServiceDesactivarClasificaciones" : {
		    	"url" : "/prjWebServicesSICWeb/ws/autorizacionUsuariosCreacion/desactivarClasificacionFuncionario",
		    },
		    "urlWebServiceDesactivarArticulos" : {
		    	"url" : "/prjWebServicesSICWeb/ws/autorizacionUsuariosCreacion/desactivarArticuloFuncionario",
		    },		    
		    "reporteAutorizacionUsuarioClasificaciones" : {
		    	"url" : "/prjWebServicesSICWeb/ws/autorizacionUsuarios/reporteAutorizacionUsuarioClasificaciones",
		    	"codigoCompania": 1,
		    	"maxResult":100,
		    	"firstResult" : 0,
		    	"usuarioSesion" : 'USU03',
		    	"codigoUsuario" : "",
		    	"codigoEstructura" : ""
		    },
		    "urlWebServiceCreacionClasificacionFuncionario"	:"/prjWebServicesSICWeb/ws/autorizacionUsuariosCreacion/creacionClasificacionFuncionario",
		    "urlWebServiceCreacionArticulosRelacionados"	: "/prjWebServicesSICWeb/ws/autorizacionUsuariosCreacion/creacionArticuloFuncionario",
		    "urlWebServiceObtenerUsuarioSesion"	:"TO-DO"
		},
		"propiedadesWeb" : {
		"imagenes" : {
		    "imgBuscar" : "resources/img/buscar16.gif",
		    "imgLimpiar" : "resources/img/limpiar12.gif",
		    "imgPersona" : "resources/img/persona.png",
		    "imgIzq" : "resources/img/pasarIzq.gif",
		    "imgDer" : "resources/img/pasarDer.gif",
		    "img1" : "resources/img/1.gif"
		    }
		}
	})
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/index', {
    templateUrl: 'WebContent/index.html',
    controller: 'asignacionUsuarios'
  });
}])
;
