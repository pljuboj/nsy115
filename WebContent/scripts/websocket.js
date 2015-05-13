/**
 * 
 */

var wsUri = "ws://" + document.location.host + "/nsy115/tictactoe";
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