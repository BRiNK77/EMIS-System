<!--
  Expected Data:
    PRIVLEVEL: The privLevel of user the current user is. 
      Values: patient, doctor, nurse, receptionist, admin

    NAME: The name of the current user. 
      Value: First name Last Name

    UID: The UID for the current user
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
	<div class="containter">

		<div class="row">
			<div class="col">
				<form action="login/" style="padding:10px">
					<button class="btn" type="submit">Logout</button>
				</form>
			</div>
		</div>
		<h2 class="text-center" style="color:white;">Main Access Portal: 
      <#switch PRIVLEVEL>
        <#case "DOC"> Doctor
        <#break>
        
        <#case "NUR"> Nurse
        <#break>
        
        <#case "REC"> Receptionist
        <#break>
        
        <#case "PAT"> Patient
        <#break>

        <#default> ?????? Shit's Fucked. PRIVLEVEL = ${PRIVLEVEL}
        <#break>

      </#switch>
         - ${NAME}
    </h2>

    <#switch PRIVLEVEL>
      <#case "DOC">
      <#case "NUR">
        <div class="container bg-light rounded">
          <div class="form-group py-3 " >
            <form action="/patientList/">
              <div class="input-group">
                <div class="input-group-prepend w-25">
                  <span class="input-group-text w-100">Get My Patient List</span>
                </div>
                <input type="text" class="form-control" id="arg0" value="${UID?string.computer}" readonly/>
                <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                </div>
              </div>
            </form>

            <form action="/schedule/">
              <div class="input-group">
                <div class="input-group-prepend w-25">
                  <span class="input-group-text w-100">Get My Schedule</span>
                </div>
                <input type="date" class="form-control" id="arg0"/>
                <div class="input-group-append">
                  <button class="btn-secondary" type="submit">Select</button>
                </div>
              </div>
            </form>

            <form action="/prescription/">
              <div class="input-group">
                <div class="input-group-prepend w-25">
                  <span class="input-group-text w-100">Get Patient Chart</span>
                </div>
                <input type="text" class="form-control" id="arg0" value="${UID?string.computer}"/>
                <div class="input-group-append">
                  <button class="btn-secondary" type="submit">Select</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      <#break>

      <#case "REC">
        <div class="container bg-light rounded">
            <div class="form-group py-3">
              <form action="/patientList/">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Get Patient List</span>
                  </div>
                  <span class="form-control disable"></span>
                  <div class="input-group-append">
                      <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/patientList/">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Add Patient</span>
                  </div>
                  <input type="text" class="form-control disable" id="arg0" placeholder="Patient UID"/>
                  <input type="text" class="form-control disable" id="arg1" placeholder="Patient Name"/>
                  <input type="date" class="form-control disable" id="arg2"/>
                  <input type="email" class="form-control disable" id="arg3" placeholder="patient@email.com"/>
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/schedule/">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Get Schedule</span>
                  </div>
                  <input type="text" class="form-control" id="arg0" placeholder="Member UID" />
                  <input type="date" class="form-control" id="arg1"/>
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/schedule/">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Add Appointment</span>
                  </div>
                  <input type="text" class="form-control" id="arg0" placeholder="Patient UID" />
                  <input type="text" class="form-control" id="arg1" placeholder="Doctor UID" />
                  <input type="date" class="form-control" id="arg2"/>
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/billing/">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Billing and Payment</span>
                  </div>
                  <input type="text" class="form-control disable" id="arg0" placeholder="Patient UID"/>
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>
            </div>
        </div>
      <#break>
      
      <#case "PAT">
        <div class="container bg-light rounded">
            <div class="form-group py-3 " >
              <form action="/profile/">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Get My Profile</span>
                  </div>
                  <input type="text" class="form-control disable" id="arg0" value="${UID?string.computer}" readonly/>
                  <div class="input-group-append">
                      <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/schedule/">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Get My Schedule</span>
                  </div>
                  <input type="text" class="form-control" id="arg1" value="${UID?string.computer}" readonly/>
                  <input type="date" class="form-control" id="arg0"/>
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/schedule/">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Request Appointment</span>
                  </div>
                  <input type="date" class="form-control" id="arg0"/>
                  <input type="time" class="form-control" id="arg1"/>
                  <input type="text" class="form-control" id="arg2" placeholder="Reason"/>
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>
            </div>
        </div>
      <#break>

      <#default>
      <div class="text-center" style="color:red;">Some shit went horribly, horribly wrong. PRIVLEVEL = ${PRIVLEVEL}</div>
      <#break>

    </#switch>

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
