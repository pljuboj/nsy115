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
							<c:forEach var="partie" items="${parties}">
								<tr class='clickable-row' style='cursor: pointer' data-href='Menu?idpartie=${partie.idpartie}'>
									<th>${partie.idpartie}</th>
									<c:forEach var="joueur" items="${partie.joueurs}">
										<th>${joueur.idjoueur}</th>
									</c:forEach>
									<th></th>
								</tr>
							</c:forEach>	
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div id ="output">${message}</div>	
	
	<form id="menuform" class="form-horizontal" role="form" action="Menu" method="post" style="text-align:center">	
		<input type="hidden" id="CODE_OP" value="" name="CODE_OP">
		<input type="hidden" id="ID_PARTIE" value="" name="ID_PARTIE">			
		<button type="button" class="btn btn-primary" onclick="creer()">Cr�er une partie</button>		
		<button type="button" class="btn btn-primary" onclick="rejoindre()">Rejoindre une partie</button>
		<button type="button" class="btn btn-primary" onclick="deco()">D�connexion</button>
	</form>
	
	<script>
		jQuery(document).ready(function($) {
		    $(".clickable-row").click(function() {
		        window.document.location = $(this).data("href");
		    });
		});
		
		function creer(){
			document.getElementById("CODE_OP").value = "CREER";
		    document.getElementById("menuform").submit();
		}
		
		function rejoindre(){
			var partie = prompt("Entrez l'ID de la partie");
			if(partie=='' || partie==null){
				return;
			}
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