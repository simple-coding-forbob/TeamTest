<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Dept</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 	부트스트랩 css  -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 	개발자 css -->
	<link rel="stylesheet" href="/css/style.css">

</head>
<body>
${depts}<br>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="page mt3">
	<form id="listForm" name="listForm" method="get">
	    
		<div class="input-group mb3 mt3">
		  <input type="text" 
		         class="form-control" 
		         placeholder="부서명입력"
		  >
		  <button class="btn btn-primary" 
		          type="button" 
		  >
		          검색
		  </button>
		</div>
	    <div id="result"></div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">dno</th>
		      <th scope="col">dname</th>
		      <th scope="col">loc</th>
		    </tr>
		  </thead>
		  <tbody>
	 		    <tr>
			      <td>
			      	aa
			      </td>
			      <td>bb</td>
			      <td>cc</td>
			    </tr>
		  </tbody>
		</table>
	</form>

</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>



