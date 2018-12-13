<!--
  Expected Data:
    NAMEList: an arraylist of the names of all the patients
    UIDList: an arraylist of the UID's of all the patients	
-->
<!DOCTYPE html>
<html lang="en">
<head>
	<title>EMIS</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body class="bg-dark">
	<nav class="navbar navbar-expand navbar-light bg-light border-bottom">
		<a class="navbar-brand" href="#">EMIS</a>
	</nav>
	<div class="containter">

		<div class="row">
			<div class="col">
				<form action="/main/" style="padding:10px">
					<button class="btn" type="submit">Back to Main</button>
				</form>
			</div>
		</div>

		<h2 class="text-center" style="color:white;">Patient List</h2>

		<div class="container bg-light rounded">
			<div class="form-group py-3">
				<#list NAMEList as NAME>
				<form action="/profile/">
					<div class="input-group">
						<input type="text" class="form-control disable" id="arg0" value="${NAME}" readonly/>

						<input type="text" class="form-control disable" id="arg1" value="${UIDList[NAME?index]}" readonly/>

	                  	<div class="input-group-append">
	                      <button class="btn-secondary" type="submit">Select</button>
	                  	</div>
					</div>
				</form>
	          	</#list>
          	</div>
		</div>
	</div>

	<footer class="bg-dark">
		<br>
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</body>
</html>
