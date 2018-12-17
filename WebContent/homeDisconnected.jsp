<div style="padding-left: 30%;padding-top: 6%">

<c:if test="${!empty personnes}">
	<table>
		<c:forEach items="${personnes}" var="p" varStatus="status">
			<tr>
			
				<td><c:out value="${ p.nom }" /></td>
				<td><c:out value="${ p.prenom }" /></td>
				<c:forEach items="${p.recompenses}" var="rec" varStatus="status">
					<td><c:out value="${rec.recompense}" /></td>
				</c:forEach>
				<c:forEach items="${p.disciplines}" var="rec" varStatus="status">
					<td><c:out value="${rec.discipline}" /></td>
				</c:forEach>
			</tr>
		</c:forEach>
		<table>
</c:if>
<c:if test="${empty personnes}">
	<a href="<c:url value ="personne"/>">
		<button type="button" class="btn btn-outline-warning">Display</button>
	</a>
</c:if>

</div>
