<%@ include file="fragment/header.jsp" %>
<%@ include file="fragment/navbar.jsp" %>
		<c:if test="${empty name}">

			<%@ include file="homeDisconnected.jsp" %>
		</c:if>
		<c:if test="${!empty name}">
			<%@ include file="homeConnected.jsp" %>
		</c:if>


<%@ include file="fragment/footer.jsp" %>