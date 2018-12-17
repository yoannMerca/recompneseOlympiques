<%@ include file="fragment/header.jsp" %>


<c:if test="${!empty error}">
	<script >alert('mots de passe ou login faux')</script>
</c:if>

	<div class="container" style="margin-top: 100px">
	
  <form action="connexion" method="POST">
    <div class="form-group row">
      <label  class="col-sm-2 col-form-label" >Nom</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="name" required>
      </div>
    </div>
    <div class="form-group row">
      <label  class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" name="password" required>
      </div>
    </div>

    <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
        <button type="submit" class="btn btn-warning btn-lg btn-block">Connection</button>
      </div>
    </div>
  </form>
</div>


<%@ include file="fragment/footer.jsp" %>