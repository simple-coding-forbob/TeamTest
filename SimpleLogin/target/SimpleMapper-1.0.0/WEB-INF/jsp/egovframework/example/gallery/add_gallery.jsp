<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/common/link.jsp"></jsp:include>
    <script src="/js/gallery/gallery-validation-config.js"></script>
    <script type="text/javascript" defer="defer">
		function fn_save() {
			$("#addForm").attr("action",'<c:out value="/gallery/add.do" />')
						.submit();
		}
    </script>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="page mt3">
	<form id="addForm" 
			name="addForm" 
			method="post"
			enctype="multipart/form-data"
	>
        <div class="mb3">
            <label for="galleryTitle" class="form-label">galleryTitle</label>
            <input  
            		class="form-control"
            		id="galleryTitle"
            		name="galleryTitle"
            		placeholder="제목" />
        </div>
		<div class="input-group">
		  <input type="file" 
		         class="form-control" 
		         id="image"
		         name="image"
		         >
		  <button class="btn btn-primary" 
		          type="button"
		          onclick="fn_save()"
		          >저장</button>
		</div>
    </form>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>
