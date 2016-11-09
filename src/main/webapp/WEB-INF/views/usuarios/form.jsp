<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroUsuario">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Usuario</title>


<script type="text/javascript" src="/springtaller/resources/angular/angular.js"></script>

<!--Import Google Icon Font-->
<link href="/springtaller/resources/materialize/iconos/index.css" rel="stylesheet">

<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="/springtaller/resources/materialize/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="widtd=device-widtd, initial-scale=1.0" />


<script type="text/javascript">
			angular.module("registroUsuario",[]);
			angular.module("registroUsuario").controller("usuarioController", function($scope,$http){ 
				$scope.aplicativo="Registro de Usuario";
				$scope.registrarUsuario=function(usuario){
					$http.post("http://localhost:8080/springtaller/usuario", usuario).success(function(){
						delete $scope.usuario;
						cargarUsuario();
				});
			};//fin registroProducto
			var cargarUsuario=function(){
				$http.get("http://localhost:8080/springtaller/usuario").success(function(usuarios){  
				$scope.usuarios=usuarios;
				});	
			};
			cargarUsuario();
			});
	</script>






</head>
<body ng-controller="usuarioController">


	<h2 ng-bind="aplicativo"></h2>


	<div class="row">

		<div class="col s2"></div>

		<!--  {{usuario} -->

		<form class="col s8">

			<div class="card-panel">
				<div class="row">
				<div class="input-field col s6">
					
						<input id="login" type="text" class="validate" ng-model="usuario.login"> 
						<label for="Login">Login</label>
					</div>
					<div class="input-field col s6">
					
						<input id="descripcion" type="text" class="validate" ng-model="usuario.name"> 
						<label for="descripcion">Nombre</label>
					</div>

					<div class="input-field col s6">
						<!--  <i class="material-icons prefix">today</i> -->
						<input id="fecha" type="password" class="validate" ng-model="usuario.password"> 
						<label for="fecha">Contraseña</label>
					</div>

				</div>

			</div>

			<button ng-click="registrarUsuario(usuario)" class="btn waves-effect waves-light" type="submit" name="action"> Registrar 
			<i class="material-icons right">save</i>
			</button>


		</form>


		<div class="col s2"></div>
	</div>
	
	
	<div class="row">
	
	<div class="col s12">
	
	<table class="responsive-table highlight">
	<thead>
	<tr>
	
	<th>Login</th> 
	<th>Nombre</th>
	<th>Contraseña</th>
	
	
	</tr>
	</thead>
	<tbody>
	<tr ng-repeat="usuario in usuarios">
	
	<td></td>
	<td>{{usuario.login}}</td>
	<td>{{usuario.name}}</td>
	<td>{{usuario.password}}</td>
	<td></td>
	
	
	</tr>
	</tbody>
	
	</table>
	
	</div>
	</div>










	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="/springtaller/resources/jquery.js"></script>
	<script type="text/javascript"
		src="/springtaller/resources/materialize/js/materialize.js"></script>



	<script type="text/javascript">
	$(document).ready(function() {
    
		$('.datepicker').pickadate();
	
     });
</script>


</body>
</html>