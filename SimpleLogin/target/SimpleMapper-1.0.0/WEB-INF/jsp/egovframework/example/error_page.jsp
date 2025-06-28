<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="/common/link.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/common/header.jsp" />
	<div class="page mt5">
		<h1>${errors}</h1>
	</div>
<jsp:include page="/common/footer.jsp" />
</body>
</html>