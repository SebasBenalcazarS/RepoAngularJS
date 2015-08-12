angular.module('asignacionUsuarios').controller('IntercambioController' , ['$scope', '$http','PROPIEDADES',  function ($scope,$http,PROPIEDADES) {

	var intercambioController = this;
	"use strict";
	intercambioController.listaOrigen=[];
	intercambioController.listaDestino=[];
	intercambioController.accion;
	intercambioController.funcionarioSeleccionadoOrigen;
	intercambioController.funcionarioSeleccionadoDestino;
	intercambioController.funcionarioSeleccionadoOrigenActualizar;
	intercambioController.funcionarioSeleccionadoDestinoActualizar;
	intercambioController.listaOrigenActualizar=[];
	intercambioController.listaDestinoActualizar=[];
	intercambioController.selecFuncionarioOrigen=false;
	intercambioController.selecFuncionarioDestino=false;
	intercambioController.funcionarioOrigen= false;
	intercambioController.funcionarioDestino= false;

	$scope.$on('listaIntercambioOrigen', function(event,result, funcionario) {
		intercambioController.funcionarioOrigen= true;
		intercambioController.selecFuncionarioOrigen=true;
		intercambioController.funcionarioSeleccionadoOrigen= funcionario.userId;
		intercambioController.funcionarioSeleccionadoOrigenActualizar= funcionario;
		intercambioController.listaOrigen=[];
		intercambioController.listaOrigenActualizar=result;
			if( result!= undefined){
				for(var i = 0; i<result.length; i++){				
					intercambioController.listaOrigen.push(result[i].codigoClasificacion);
				}
			}
		if(intercambioController.listaOrigen.length==0){
			intercambioController.selecFuncionarioOrigen=false;
		}else{
			intercambioController.selecFuncionarioOrigen=true;
		}
		
		console.log('origen IntercambioController: '+ intercambioController.listaOrigen);
		console.log(' Funcionario origen IntercambioController: '+ intercambioController.funcionarioSeleccionadoOrigen);
	});

	$scope.$on('listaIntercambioDestino', function(event,result, funcionario) {
		intercambioController.funcionarioDestino= true;
		intercambioController.selecFuncionarioDestino=true;
		intercambioController.funcionarioSeleccionadoDestino= funcionario.userId;
		intercambioController.funcionarioSeleccionadoDestinoActualizar=funcionario;
		intercambioController.listaDestino=[];
		intercambioController.listaDestinoActualizar=result;
			if( result!= undefined){
				for(var i = 0; i<result.length; i++){
				intercambioController.listaDestino.push(result[i].codigoClasificacion);
				}
			}
		if(intercambioController.listaDestino.length==0){
			intercambioController.selecFuncionarioDestino=false;
		}else{
			intercambioController.selecFuncionarioDestino=true;
		}
		console.log('destino IntercambioController: '+ intercambioController.listaDestino);
		console.log('Funcionario destino IntercambioController: '+ intercambioController.funcionarioSeleccionadoDestino);
	});

	intercambioController.clickAccion=function(){
	if (intercambioController.funcionarioSeleccionadoOrigen&&intercambioController.funcionarioSeleccionadoDestino) {
		if(intercambioController.accion=='intercambio'){		
			console.log('recibido origen IntercambioController: '+ intercambioController.listaOrigen);
			console.log('recibido destino IntercambioController: '+ intercambioController.listaDestino);
			console.log('accion: '+ intercambioController.accion);
			var req = {
			       method: 'POST',
			       url: 'http://localhost:8080/prjWebServicesSICWeb/ws/autorizacionUsuariosCreacion/intercambiarClasificacionesFuncionario',
			       headers: {
			         'Content-Type': 'application/json; charset=utf-8',
			         'dataType': 'json'
			       },
			       data: {	maxResult:500,
							firstResult: 0,
							usuarioSesion:'FRM0',
							usuarioOrigen: intercambioController.funcionarioSeleccionadoOrigen,
							codigoCompaniaUsuOrigen:1, 
							usuarioDestino: intercambioController.funcionarioSeleccionadoDestino,
							clasificaciones:{listaClasificacionesUsuarioOrigen:intercambioController.listaOrigen,																				
															 listaClasificacionesUsuarioDestino:intercambioController.listaDestino}
						}
			     }
			     $scope.$root.$broadcast('actualizarIntercambios', false,intercambioController.funcionarioSeleccionadoOrigenActualizar,intercambioController.listaOrigenActualizar,intercambioController.funcionarioSeleccionadoDestinoActualizar,intercambioController.listaDestinoActualizar);		    	  
			$http(req).success(function(result){
			    	  $scope.$root.$broadcast('actualizarIntercambios', true,intercambioController.funcionarioSeleccionadoOrigenActualizar,intercambioController.listaOrigenActualizar,intercambioController.funcionarioSeleccionadoDestinoActualizar,intercambioController.listaDestinoActualizar);		    	  
			      	}).error(function(data){
			    		  $scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
			    	  });			
		}else if(intercambioController.accion=='reemplazar'){
			var reemp = {
			       method: 'POST',
			       url: 'http://localhost:8080/prjWebServicesSICWeb/ws/autorizacionUsuariosCreacion/reemplazarClasificacionesFuncionario',
			       headers: {
			         'Content-Type': 'application/json; charset=utf-8',
			         'dataType': 'json'
			       },
			       data: {	maxResult:500,
							firstResult: 0,
							usuarioSesion:'FRM0',
							usuario: intercambioController.funcionarioSeleccionadoDestino,
							codigoCompania:1,
							clasificaciones:{listaClasificacionesUsuarioOrigen:intercambioController.listaOrigen}
						}
			     }
			     $scope.$root.$broadcast('actualizarReemplazo', false,intercambioController.funcionarioSeleccionadoOrigenActualizar,intercambioController.listaOrigenActualizar,intercambioController.funcionarioSeleccionadoDestinoActualizar);		    	  
			     $http(reemp).success(function(result){
			    	  $scope.$root.$broadcast('actualizarReemplazo', true,intercambioController.funcionarioSeleccionadoOrigenActualizar,intercambioController.listaOrigenActualizar,intercambioController.funcionarioSeleccionadoDestinoActualizar);		    	  
			      	}).error(function(data){
			    		  $scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
			    	  });	
			
		}else if (intercambioController.accion=='adicionar') {
			var add = {
			       method: 'POST',
			       url: 'http://localhost:8080/prjWebServicesSICWeb/ws/autorizacionUsuariosCreacion/adicionarClasificacionesFuncionario',
			       headers: {
			         'Content-Type': 'application/json; charset=utf-8',
			         'dataType': 'json'
			       },
			       data: {	maxResult:500,
							firstResult: 0,
							usuarioSesion:'FRM0',
							usuario: intercambioController.funcionarioSeleccionadoDestino,
							codigoCompania:1, //revisar que lista de clasificaciones se va a enviar
							clasificaciones:{listaClasificacionesUsuarioOrigen:intercambioController.listaOrigen}
						}
			     }
			     $scope.$root.$broadcast('actualizarAdicion', false,intercambioController.funcionarioSeleccionadoOrigenActualizar,intercambioController.listaOrigenActualizar,intercambioController.funcionarioSeleccionadoDestinoActualizar,intercambioController.listaDestinoActualizar);		    	  
			     $http(add).success(function(result){
			    	  $scope.$root.$broadcast('actualizarAdicion', true,intercambioController.funcionarioSeleccionadoOrigenActualizar,intercambioController.listaOrigenActualizar,intercambioController.funcionarioSeleccionadoDestinoActualizar,intercambioController.listaDestinoActualizar);		    	  
			      	}).error(function(data){
			    		  $scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
			    	  });	
		}else if(intercambioController.accion==undefined){
			alert('Seleccione asignacion a realizar');
		}
	}else{
		alert('seleccione usuarios');
		
	};
	}


}]);