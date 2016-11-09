<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroPedido">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	
	<!--Import angular.js-->
	<script type="text/javascript" src="/springtaller/resources/angular/angular.js"></script>
	
	
	<!--Import Google Icon Font-->
	<link href="/springtaller/resources/materialize/iconos/index.css" rel="stylesheet">
	
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="/springtaller/resources/materialize/css/materialize.min.css"  media="screen,projection"/>
	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>



<script type="text/javascript">
		angular.module("registroPedido",[]);
		
		angular.module("registroPedido").controller("pedidoController", function($scope,$http){
			
			$scope.aplicativo="Registro de Pedido";
			
			$scope.registrarPedido = function(pedido){
				
				$http.post("http://localhost:8080/springtaller/pedido", pedido).success(function(){
					
					//Vaciar los campos del formulario
					$scope.pedido = undefined;
					
					cargarPedidos();
					
				});
			};
			var cargarPedidos=function(){
				$http.get("http://localhost:8080/springtaller/pedido").success(function(pedidos){
					
					$scope.pedidos = pedidos;
				});
			};
			
			cargarPedidos();
		});
</script>

</head>

<body ng-controller="pedidoController">

<h2 ng-bind="aplicativo"></h2>


	<div class="row">

		<div class="col s2"></div>

		{{pedido}}

		<form class="col s8">

			<div class="card-panel">
				<div class="row">
					<div class="input-field col s6">
					<i class="material-icons prefix">today</i> 
						<input id="descripcion" type="date" class="datepicker" ng-model="pedido.fechaToma"> 
						<label for="descripcion">Fecha de Pedido</label>
					</div>

					<div class="input-field col s6">
						<i class="material-icons prefix">today</i> 
						<input id="fecha" type="date" class="datepicker" ng-model="pedido.fechaEntrega"> 
						<label for="fecha">Fecha de Entrega</label>
					</div>

					<div class="input-field col s6">
					<!--  	<i class="material-icons prefix">phone</i>  -->
					 <input id="precio" type="number" class="validate" ng-model="pedido.total">
						<label for="precio">Total</label>
					</div>
				</div>

			</div>

			<button ng-click="registrarPedido(pedido)" class="btn waves-effect waves-light" type="submit" name="action"> Registrar 
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
	<th>Eliminar</th>
	<th>Fecha de Toma</th>
	<th>Fecha de Entrega</th>
	<th>Total</th>
	<th>Editar</th>
	
	</tr>
	</thead>
	<tbody>
	<tr ng-repeat="pedido in pedidos">
	
	<td></td>
	<td>{{pedido.fechaToma}}</td>
	<td>{{pedido.fechaEntrega}}</td>
	<td>{{pedido.total}}</td>
	<td></td>
	
	
	</tr>
	</tbody>
	
	</table>
	
	</div>
	</div>













<!--Import jQuery before materialize.js-->
	<script type="text/javascript" src="/springtaller/resources/jquery.js"></script>
	<script type="text/javascript" src="/springtaller/resources/materialize/js/materialize.min.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
    
		$('.datepicker').pickadate();
	
     });
</script>
</body>
</html>