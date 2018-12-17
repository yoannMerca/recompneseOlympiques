<nav class="navbar navbar-light bg-light justify-content-between"
		style="background-color: orange">
		<a class="navbar-brand">Accueil</a>
		<form class="form-inline">

			<c:if test="${empty name}">

				<a href="<c:url value ="home?action=con"/>">
					<button type="button" class="btn btn-outline-warning">connexion</button>
				</a>
				<!-- <a href="http://localhost:8383/recompenseOlympiques/home?action=con">
   		 			<button type="button" class="btn btn-outline-warning"></button>
				</a> -->
			</c:if>
			<c:if test="${!empty name}">
				<a href="<c:url value ="home?action=discon"/>">
					<button type="button" class="btn btn-outline-warning">Disconnect</button>
				</a>
				<!-- <a href="http://localhost:8383/recompenseOlympiques/home?action=discon" >
   		 			<button type="button" class="btn btn-outline-warning">Disconnect</button>
				</a> -->
			</c:if>

		</form>

	</nav>