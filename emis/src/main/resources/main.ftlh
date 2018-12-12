<!--
  Expected Data:
    currUser.type: The type of user the current user is. 
      Values: patient, doctor, nurse, receptionist, admin

    currUser.name: The name of the current user. 
      Value: First name Last Name

    currUser.ID: The UID for the current user

    TODO:
      Instead of passing a single user called nurse, change to passing an arraylist of nurse users

    receptionist.name: If the user is a patient, provide a nurse they could speak with to request an appointment

    receptionist.ID: If the user is a patient, provide the ID of the nurse they could speak to to request an appointment
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
				<form action="loginR.html" style="padding:10px">
					<button class="btn" type="submit">Logout</button>
				</form>
			</div>
		</div>
		<h2 class="text-center" style="color:white;">Main Access Portal: 
      <#switch user.type>
        <#case "doctor"> Doctor
        <#break>
        
        <#case "nurse"> Nurse
        <#break>
        
        <#case "receptionist"> Receptionist
        <#break>
        
        <#case "patient"> Patient
        <#break>

        <#case "admin"> Admin
        <#break>

        <#default> ?????? Shit's Fucked. user.type = ${currUser.type}
        <#break>

      </#switch>
         - ${user.name}
    </h2>

    <#switch user.type>
      <#case "doctor">
        <div class="container bg-light rounded">
          <div class="form-group py-3 " >
            <form action="/patientList.html">
              <div class="input-group">
                <div class="input-group-prepend w-25">
                  <span class="input-group-text w-100">Get My Patient List</span>
                </div>
                <input type="text" class="form-control disable" value="${user.name} : ${user.ID}" readonly/>
                <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                </div>
              </div>
            </form>

            <form action="/schedulePage.html">
              <div class="input-group">
                <div class="input-group-prepend w-25">
                  <span class="input-group-text w-100">Get My Schedule</span>
                </div>
                <input type="date" class="form-control disable" value="2018-12-03" />
                <div class="input-group-append">
                  <button class="btn-secondary" type="submit">Select</button>
                </div>
              </div>
            </form>

            <form action="/prescriptionPage.html">
              <div class="input-group">
                <div class="input-group-prepend w-25">
                  <span class="input-group-text w-100">Get Prescription List</span>
                </div>
                <input type="text" class="form-control disable" value="${user.name} : ${user.ID}" readonly/>
                <div class="input-group-append">
                  <button class="btn-secondary" type="submit">Select</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      <#break>

      <#case "nurse">
      <#break>

      <#case "receptionist">
        <div class="container bg-light rounded">
            <div class="form-group py-3 " >
              <form action="/patientList.html">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Get Patient List</span>
                  </div>
                  <input type="text" class="form-control disable" value="All Names : UID00000" readonly/>
                  <div class="input-group-append">
                      <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/patientList.html">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Add Patient</span>
                  </div>
                  <input type="text" class="form-control disable" placeholder="Patient UID"/>
                  <input type="text" class="form-control disable" placeholder="Patient Name"/>
                  <input type="date" class="form-control disable" />
                  <input type="email" class="form-control disable" placeholder="patient@email.com"/>
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/schedulePage.html">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Get Schedule</span>
                  </div>
                  <input type="text" class="form-control" placeholder="Member UID" />
                  <input type="date" class="form-control" value="2018-12-10" />
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/schedulePage.html">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Add Appointment</span>
                  </div>
                  <input type="text" class="form-control" placeholder="Patient UID" />
                    <input type="text" class="form-control" placeholder="Doctor UID" />
                  <input type="date" class="form-control" />
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/billingPage.html">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Billing and Payment</span>
                  </div>
                  <input type="text" class="form-control disable" placeholder="Patient UID"/>
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>
            </div>
        </div>
      <#break>
      
      <#case "patient">
        <div class="container bg-light rounded">
            <div class="form-group py-3 " >
              <form action="/patientPage.html">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Get My Profile</span>
                  </div>
                  <input type="text" class="form-control disable" value="${user.name} : ${user.ID}" readonly/>
                  <div class="input-group-append">
                      <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/schedulePage.html">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Get My Schedule</span>
                  </div>
                  <input type="date" class="form-control disable" value="2018-12-03" />
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>

              <form action="/schedulePage.html">
                <div class="input-group">
                  <div class="input-group-prepend w-25">
                    <span class="input-group-text w-100">Request Appointment</span>
                  </div>
                  <input type="text" class="form-control" value="${user.name} : ${user.ID}" readonly/>
                    <input type="text" class="form-control" placeholder="${receptionist.name} : ${erceptionist.ID}" readonly/>
                  <input type="date" class="form-control" />
                  <div class="input-group-append">
                    <button class="btn-secondary" type="submit">Select</button>
                  </div>
                </div>
              </form>
            </div>
        </div>
      <#break>

      <#case "admin">
      <#break>

      <#default>
      <div class="text-center" style="color:red;">Some shit went horribly, horribly wrong. User.type = ${currUser.type}</div>
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
