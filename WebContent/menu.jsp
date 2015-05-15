<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="scripts/tools.js"></script>
<title>Parties</title>

</head>
<body>



<div class="container">
    	<div class="row">
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Parties</h3>
					</div>
					<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
								<th># </th>
								<th>Player</th>
								<th>Ranking</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<form id="menuform" class="form-horizontal" role="form" action="Menu" method="post">	
		<input type="hidden" id="CODE_OP" value="" name="CODE_OP">
		<input type="hidden" id="ID_PARTIE" value="" name="ID_PARTIE">			
		<button type="button" class="btn btn-primary" onclick="creer()">Créer une partie</button>		
		<button type="button" class="btn btn-primary" onclick="rejoindre()">Rejoindre une partie</button>
		<button type="button" class="btn btn-primary" onclick="deco()">Déconnexion</button>
	</form>
	
	<script>
		function creer(){
			document.getElementById("CODE_OP").value = "CREER";
		    document.getElementById("menuform").submit();
		}
		
		function rejoindre(){
			var partie = prompt("Entrez l'ID de la partie");
			document.getElementById("ID_PARTIE").value = partie;
			document.getElementById("CODE_OP").value = "REJOINDRE";
		    document.getElementById("menuform").submit();
		}
		
		function deco(){			
			document.getElementById("CODE_OP").value = "DECO";			
		    document.getElementById("menuform").submit();
		}
	</script>

</body>
</html>