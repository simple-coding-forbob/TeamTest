<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/common/link.jsp"></jsp:include>
    <script src="/js/emp/emp-validation-config.js"></script>
    <script type="text/javascript" defer="defer">
    	function fn_save() {
			$("#addForm").attr("action",'<c:out value="/emp/edit.do" />')
							.submit();
		}
		function fn_delete() {
			$("#addForm").attr("action",'<c:out value="/emp/delete.do" />')
							.submit();
		}
    </script>
    
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="container">
    <form id="addForm" name="addForm" method="post">
    	<input type="hidden" name="eno" value="<c:out value="${empVO.eno}" />">
        <div class="mb3">
            <label for="ename" class="form-label">ename</label>
            <input 
                   class="form-control"
                   id="ename"
                   name="ename"
                   value="<c:out value="${empVO.ename}" />"
                   placeholder="ename" />
        </div>
        <div class="mb3">
            <label for="job" class="form-label">job</label>
            <input 
                   class="form-control"
                   id="job"
                   name="job"
                   value="<c:out value="${empVO.job}" />"
                   placeholder="job" />
        </div>
        <div class="mb3">
            <label for="manager" class="form-label">manager</label>
            <input 
                   class="form-control"
                   id="manager"
                   name="manager"
                   value="<c:out value="${empVO.manager}" />"
                   placeholder="manager" />
        </div>
        <div class="mb3">
            <label for="hiredate" class="form-label">hiredate</label>
            <input 
                   class="form-control"
                   id="hiredate"
                   name="hiredate"         
                   value="<c:out value="${empVO.hiredate}" />"          
                   placeholder="hiredate" />
        </div>
        <div class="mb3">
            <label for="salary" class="form-label">salary</label>
            <input 
                   class="form-control"
                   id="salary"
                   name="salary"
                   value="<c:out value="${empVO.salary}" />" 
                   placeholder="salary" />
        </div>
        <div class="mb3">
            <label for="commission" class="form-label">commission</label>
            <input 
                   class="form-control"
                   id="commission"
                   name="commission"
                   value="<c:out value="${empVO.commission}" />" 
                   placeholder="commission" />
        </div>
        <div class="mb3">
            <label for="dno" class="form-label">dno</label>
            <input 
                   class="form-control"
                   id="dno"
                   name="dno"
                   value="<c:out value="${empVO.dno}" />"
                   placeholder="dno" />
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
