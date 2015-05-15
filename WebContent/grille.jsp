<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/gameboard.css">	
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="scripts/tools.js"></script>
<title>Grille</title>
<script>
var idpartie = '<c:out value="${idpartie}"/>';
var wsUri = "ws://" + document.location.host + "/nsy115/tictactoe/" + idpartie;
var websocket = new WebSocket(wsUri);

//websocket.onerror = function(evt) { onError(evt) };

function init() {
	websocket.onopen = function(evt) {
		onOpen(evt)
	};
	websocket.onmessage = function(evt) {
		onMessage(evt)
	};
	websocket.onerror = function(evt) {
		onError(evt)
	};
}

function onError(evt) {
	writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function onMessage(evt) {
//	writeToScreen(evt.data);
    var json = JSON.parse(evt.data);
    document.getElementById("1").innerHTML = json.x1;
    document.getElementById("2").innerHTML = json.x2;
    document.getElementById("3").innerHTML = json.x3;
    document.getElementById("4").innerHTML = json.y1;
    document.getElementById("5").innerHTML = json.y2;
    document.getElementById("6").innerHTML = json.y3;
    document.getElementById("7").innerHTML = json.z1;
    document.getElementById("8").innerHTML = json.z2;
    document.getElementById("9").innerHTML = json.z3;    
    
	document.getElementById('gameboard').style.pointerEvents = 'auto';
	document.getElementById('message').innerHTML = 'A vous de jouer !';
}

function envoyer() {
	var message = "blabla";
	writeToScreen("ENVOYE : " + message);
	websocket.send(message);
}

function json(){
	var x1 = document.getElementById("1").innerHTML;
	var x2 = document.getElementById("2").innerHTML;
	var x3 = document.getElementById("3").innerHTML;
	var y1 = document.getElementById("4").innerHTML;
	var y2 = document.getElementById("5").innerHTML;
	var y3 = document.getElementById("6").innerHTML;
	var z1 = document.getElementById("7").innerHTML;
	var z2 = document.getElementById("8").innerHTML;
	var z3 = document.getElementById("9").innerHTML;

	var obj = JSON.stringify({"x1":x1, 
			"x2":x2, 
			"x3":x3, 
			"y1":y1,
			"y2":y2,
			"y3":y3,
			"z1":z1,
			"z2":z2,
			"z3":z3});
	
	websocket.send(obj);

}


//For testing purposes
var output = document.getElementById("output");
websocket.onopen = function(evt) { onOpen(evt) };

function writeToScreen(message) {
	document.getElementById("output").innerHTML += message + "<br>";
}

function onOpen() {
	writeToScreen("Connected to " + wsUri);
}
//End test functions
window.addEventListener("load", init, false);
</script>
</head>

<body>
	<div id="output"></div>
	
	<div class='wrapper'>
		<h1>Tic Tac Toe</h1>
		<div id='gameboard' class='gameboard'>
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
			<div id="idpartie">idpartie : ${idpartie}</div>
			<div id="username">username : ${username}</div>
			<div id="message"></div>
		</div>
	</div>	
	<script>
		<c:choose>
			<c:when test="${yourturn == 'no'}">
				document.getElementById('gameboard').style.pointerEvents = 'none';
				document.getElementById('message').innerHTML = 'A votre adversaire de jouer !';
			</c:when>
			<c:when test="${yourturn == 'yes'}">
				document.getElementById('message').innerHTML = 'A vous de jouer !';
			</c:when>
		</c:choose>
	</script>
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
			
			document.getElementById('gameboard').style.pointerEvents = 'none';
			document.getElementById('message').innerHTML = 'A votre adversaire de jouer !';
			
			json();
		}
	</script>
</body>
</html>