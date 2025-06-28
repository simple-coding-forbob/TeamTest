<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/common/link.jsp"></jsp:include>
    <script src="/js/dept/dept-validation-config.js"></script>
    <script type="text/javascript" defer="defer">
    	function fn_save() {
 			$("#addForm").attr("action",'<c:out value="/dept/edit.do" />')
							.submit();
		}
		function fn_delete() {
			$("#addForm").attr("action",'<c:out value="/dept/delete.do" />')
							.submit();
		}
    </script>
    
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="page mt3">
    <form id="addForm" name="addForm" method="post">
    	<input type="hidden" name="dno" value="<c:out value="${deptVO.dno}" />">
        <div class="mb3">
            <label for="dname" class="form-label">dname</label>
            <input 
                   class="form-control"
                   id="dname"
                   name="dname"
                   value="<c:out value="${deptVO.dname}" />"
                   placeholder="dname" />
        </div>
        <div class="mb3">
            <label for="loc" class="form-label">loc</label>
            <input 
                   class="form-control"
                   id="loc"
                   name="loc"
                   value="<c:out value="${deptVO.loc}" />"
                   placeholder="loc" />
        </div>
        <div class="mb3">
            <button class="btn btn-warning" onclick="fn_save()">수정</button>
                        
            <button class="btn btn-danger" onclick="fn_delete()">삭제</button>
        </div>
    </form>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>
