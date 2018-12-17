<div style="padding-left: 30%; padding-top: 6%">

	<c:if test="${!empty personnes}">
		<table>
			<c:forEach items="${personnes}" var="p" varStatus="status">
			
				<tr>
					<th rowspan="${p.taille+1}"><c:out value="${ p.nom }" /> <c:out
							value="${ p.prenom }" /> <a
					href="<c:url value ="personne?action=update&personne=${status.index}"/>">
						<button type="button" class="btn btn-outline-warning">update</button>
				</a>  <a
					href="<c:url value ="personne?action=delete&personne=${status.index}"/>">
						<button type="button" class="btn btn-outline-danger">delete</button>
				</a></th>
				</tr>
				<c:forEach items="${p.recompenses}" var="rec" varStatus="stat">
					<tr>
						<td><c:out value="${rec.recompense}" /> => <c:out value="${disciplines[stat.index].discipline}" /> </td>
					</tr>
				</c:forEach>
			
		
			</c:forEach>
			<table>



				<a href="<c:url value ="insert"/>">
					<button type="button" class="btn btn-success btn-lg">insert
					</button>
				</a>
				</c:if>
				<c:if test="${empty personnes}">
					<a href="<c:url value ="personne"/>">
						<button type="button" class="btn btn-outline-warning">Display</button>
					</a>
				</c:if>

				</div>