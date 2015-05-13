<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="scripts/tools.js"></script>
<script type="text/javascript" src="scripts/websocket.js"></script>
<title>Grille</title>
</head>

<style>
body {
	font-family: 'Lobster', sans-serif;
}

.wrapper {
	width: 500px;
	margin: 0 auto;
	text-align: center;
}

.gameboard {
	width: 330px;
	height: 310px;
	border: 1px solid #ccc;
	z-index: 1;
	margin: 0 auto;
}

.tile {
	display: inline-flex;
	border: 1px solid #333;
	width: 100px;
	height: 100px;
}

.table {
	width: 100%;
	height: 100%;
	font-family: Arial;
	font-size: 50px;
	font-weight: 600;
}

.table tr {
	margin: 0px;
	padding: 0px;
}

.table td {
	padding: 0px;
	border: 1px solid #ccc;
	cursor: pointer;
	width: 100px;
	height: 100px
}

.cell:hover {
	background-color: #27ae60;
}
</style>


<body>
	<div id="output"></div>
	
	<div class='wrapper'>
		<h1>Tic Tac Toe</h1>
		<div class='gameboard'>
			<table border='0' class='table'>
				<tr>
					<td class='cell' id='1' onclick='move("1");'></td>
					<td class='cell' id='2' onclick='move("2");'></td>
					<td class='cell' id='3' onclick='move("3");'></td>
				</tr>
				<tr>
					<td class='cell' id='4' onclick='move("4");'></td>
					<td class='cell' id='5' onclick='move("5");'></td>
					<td class='cell' id='6' onclick='move("6");'></td>
				</tr>
				<tr>
					<td class='cell' id='7' onclick='move("7");'></td>
					<td class='cell' id='8' onclick='move("8");'></td>
					<td class='cell' id='9' onclick='move("9");'></td>
				</tr>
			</table>
			<br>
			<button id='clear' onclick="envoyer();">Envoyer</button>
		</div>
	</div>
	<script>
		function move(cell){
			var x1 = document.getElementById("1").innerHTML;
			var x2 = document.getElementById("2").innerHTML;
			var x3 = document.getElementById("3").innerHTML;
			var y1 = document.getElementById("4").innerHTML;
			var y2 = document.getElementById("5").innerHTML;
			var y3 = document.getElementById("6").innerHTML;
			var z1 = document.getElementById("7").innerHTML;
			var z2 = document.getElementById("8").innerHTML;
			var z3 = document.getElementById("9").innerHTML;
			
			var cells = [x1, x2, x3, y1, y2, y3, z1, z2, z3];
			cells = cells.filter(function(e){return e}); 

			if(cells.length%2 == 0)			
				document.getElementById(cell).innerHTML = "X";
			else 
				document.getElementById(cell).innerHTML = "O";
			
			json();
		}
	</script>
</body>
</html>