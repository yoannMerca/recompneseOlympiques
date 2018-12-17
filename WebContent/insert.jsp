<%@ include file="fragment/header.jsp"%>
<%@ include file="fragment/navbar.jsp"%>
<div class="container" style="margin-top: 100px">

	<form action="insert" method="POST">
		<div class="form-group row">
	<c:if test="${!empty err }">
	  <script type="text/javascript">alert("cette discipline et cette medaille sont deja affectées")</script> 
	</c:if>
			<c:if test="${ idPersonne !=null}">
				<label class="col-sm-2 col-form-label offset-sm-2">Nom</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="name" disabled
						value="${ personnes[idPersonne].nom}">
				</div>
				<label class="col-sm-2 col-form-label offset-sm-2">prenom</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="name"
						value="${ personnes[idPersonne].prenom}" disabled>
				</div>
			</c:if>
			<c:if test="${ idPersonne ==null }">
				<label class="col-sm-2 col-form-label offset-sm-2">Nom</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="name" required
						value="">
				</div>

				<label class="col-sm-2 col-form-label offset-sm-2">prenom</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="firstname" required>
				</div>
			</c:if>
		</div>
</div>
<div class="form-group row">
<div class="col-sm-6 offset-sm-3">
<select multiple class="form-control" name="recompense" required>
		<!-- <option value="">--Please choose an option--</option> -->
		<c:forEach items="${recompenses}" var="r" varStatus="status">
			<option value="${r}">${r.recompense}</option>
		</c:forEach>
	</select> <select multiple class="form-control" name="discipline" required>
		<!-- <option value="">--Please choose an option--</option> -->
		<c:forEach items="${disciplines}" var="d" varStatus="status">
			<option value="${d}">${d.discipline}</option>
		</c:forEach>
	</select>
</div>
	
</div>

<div class="form-group row">
	<div class="col-sm-6 offset-sm-3">
		<button type="submit" class="btn btn-warning btn-lg btn-block">Insert</button>
	</div>
</div>
</form>
</div>


<%@ include file="fragment/footer.jsp"%>