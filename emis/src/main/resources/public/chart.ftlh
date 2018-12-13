<!--
  Expected Data:
    NAME: The name of the current user. 
      Value: First name Last Name

    Everything that is 1 to 1 entry is a list of values.
    Everything that is many to 1 entry is a list of arraylists.
    	Each nested arraylist will be looped.

    DATEList: 1 to 1 chart entry
    DOCTORNOTEList: 1 to 1 chart entry
    DIAGNOSEList: Many to 1 chart entry
    PRESCRIPTIONList: Many to 1 chart entry
    AILMENTList: Many to 1 chart entry
    BPList: 1 to 1 chart entry
    HEIGHTList: 1 to 1 chart entry
    WEIGHTList: 1 to 1 chart entry
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
		<a class="navbar-brand" href="#">EMIS - Company Name Here</a>
	</nav>

	<h2 class="text-center" style="color:white;"> Patient Chart - ${NAME}</h2>

	<div class="container bg-light rounded">
		<form method="POST" action="/chart/">
			<div class="form-group py-3">

				<div class = "input-group">
					<div class="input-group-prepend w-25">
	                  <span class="input-group-text w-100">Date:</span>
	                </div>
					<input type="date" class="form-control .addDate disable" id="arg0" readonly/>
				</div>

				<div class="input-group">
					<div class="input-group-prepend w-25">
	                  <span class="input-group-text w-100">Doctor Note:</span>
	                </div>
					<input type="text" class="form-control" id="arg1"/>
				</div>

				<div class="input-group">
					<div class="input-group-prepend w-25">
	                  <span class="input-group-text w-100">Diagnoses:</span>
	                </div>
					<input type="text" class="form-control" id="arg2"/>
				</div>

				<div class="input-group">
					<div class="input-group-prepend w-25">
	                  <span class="input-group-text w-100">Prescriptions:</span>
	                </div>
					<input type="text" class="form-control" id="arg3" placeholder="Generic Name"/>
					<input type="text" class="form-control" id="arg4" placeholder="Dosage"/>
					<input type="text" class="form-control" id="arg5" placeholder="Count"/>
	                <div class="input-group-append">
	                    <button class="btn-secondary" type="submit">Select</button>
	                </div>
				</div>

				<div class="input-group">
					<div class="input-group-prepend w-25">
	                  <span class="input-group-text w-100">General:</span>
	                </div>
					<input type="text" class="form-control" id="arg6" placeholder="Blood Pressure"/>
					<input type="text" class="form-control" id="arg7" placeholder="Height"/>
					<input type="text" class="form-control" id="arg8" placeholder="Weight"/>
	                <div class="input-group-append">
	                    <button class="btn-secondary" type="submit">Select</button>
	                </div>
				</div>


			</div>
		</form>
	</div>

	<div class="container bg-light rounded">
		<div class="py-2">
			<#list DATEList as DATE>
			<form>
				<div class="form-group py-1">
					<div class="input-group">
						<div class="input-group-prepend w-25">
		                  <span class="input-group-text w-100">Date:</span>
		                </div>
						<input type="text" class="form-control disable" value="${DATE}" readonly/>
					</div>

					<div class="input-group">
						<div class="input-group-prepend w-25">
		                  <span class="input-group-text w-100">Doctor Note:</span>
		                </div>
						<input type="text" class="form-control disable" value="${DOCTORNOTEList[DATE?index]}" readonly/>
					</div>
						
	                <#list DIAGNOSEList[DATE?index] as DIAGNOSE>
					<div class="input-group">
						<div class="input-group-prepend w-25">
		                  <span class="input-group-text w-100">Diagnoses:</span>
		                </div>
						<input type="text" class="form-control disable" value="${DIAGNOSE}" readonly/>
					</div>
					</#list>
						
	                <#list PRESCRIPTIONList[DATE?index] as PRESCRIPTION>
					<div class="input-group">
						<div class="input-group-prepend w-25">
		                  <span class="input-group-text w-100">Prescriptions:</span>
		                </div>
						<input type="text" class="form-control disable" value="${PRESCRIPTION}" readonly/>
					</div>
					</#list>

					<div class="input-group">
						<div class="input-group-prepend w-25">
		                  <span class="input-group-text w-100">Blood Pressure:</span>
		                </div>
						<input type="text" class="form-control disable" value="${BPList[DATE?index]}" readonly/>
					</div>

					<div class="input-group">
						<div class="input-group-prepend w-25">
		                  <span class="input-group-text w-100">Height:</span>
		                </div>
						<input type="text" class="form-control disable" value="${HEIGHTList[DATE?index]}" readonly/>
					</div>

					<div class="input-group">
						<div class="input-group-prepend w-25">
		                  <span class="input-group-text w-100">Weight:</span>
		                </div>
						<input type="text" class="form-control disable" value="${WEIGHTList[DATE?index]}" readonly/>
					</div>
				</div>
			</form>
	        </#list>
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

  <script> 
    $(document).ready( function() {
      $('.addDate').val(new Date().toDateInputValue());
    });
</script>

</body>
</html>
