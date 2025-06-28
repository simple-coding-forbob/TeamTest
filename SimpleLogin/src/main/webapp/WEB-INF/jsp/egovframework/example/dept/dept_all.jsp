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
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="page mt3">
	<form id="listForm" name="listForm" method="get">
	    <input type="hidden" id="dno" name="dno">
	    <input type="hidden" id="pageIndex" name="pageIndex">
	    
		<div class="input-group mb3 mt3">
		  <input type="text" 
		         class="form-control" 
		         id="searchKeyword"
		         name="searchKeyword"
		         placeholder="부서명입력"
		  >
		  <button class="btn btn-primary" 
		          type="button" 
		          onclick="fn_egov_selectList()"
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
		   <c:forEach var="data" items="${depts}">
	 		    <tr>
			      <td>
			      	<a href="javascript:fn_select('<c:out value="${data.dno}" />')">
			      		<c:out value="${data.dno}" />
			      	</a>
			      </td>
			      <td><c:out value="${data.dname}" /></td>
			      <td><c:out value="${data.loc}" /></td>
			    </tr>
		   </c:forEach>

		  </tbody>
		</table>
	
		<div id="paging" class="flex-center">
		    <ul class="pagination" id="pagination"></ul>
		</div>
	</form>

</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 유효성체크 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<!-- 페이징 라이브러리 -->
<script src="/js/jquery.twbsPagination.js" type="text/javascript"></script>

<script src="/js/dept/dept-autocomplete.js" type="text/javascript"></script>
<script type="text/javascript">
	function fn_egov_link_page(pageNo) {
		$("#pageIndex").val(pageNo); 
		$("#listForm").attr("action",'<c:out value="/dept/dept.do" />')
					.submit();
	}
	function fn_egov_selectList() {
		$("#pageIndex").val(1); 
		$("#listForm").attr("action",'<c:out value="/dept/dept.do" />')
					.submit();
	}
	function fn_select(dno) {
		$("#dno").val(dno); 
		$("#listForm").attr("action",'<c:out value="/dept/edition.do" />')
					.submit();
	}
</script>
		
<script type="text/javascript">
    $(function () {
        $('#pagination').twbsPagination({
            totalPages: "${paginationInfo.totalPageCount}",
	            startPage: parseInt("${paginationInfo.currentPageNo}"), 
            visiblePages: "${paginationInfo.recordCountPerPage}",
        	initiateStartPageClick: false,
            onPageClick: function (event, page) {
	        	fn_egov_link_page(page);
            }
        });
    });
</script>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>



