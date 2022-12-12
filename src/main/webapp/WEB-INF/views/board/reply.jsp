<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>Spring MVC</h2>
	  <div class="panel panel-default">
	    <div class="panel-heading">Board</div>
	    <div class="panel-body">
			<form action="/board/reply" method="post">
				<input type="hidden" name="idx" value="${vo.idx }"/>
				<input type="hidden" name="memID" value="${mvo.memID }">
				<div class="form-group">
					<label>제목</label>
					<input type="text" name="title" id="title" class="form-control" value="<c:out value='${vo.title }'/>">
				</div>
				<div class="form-group">
					<label>답변</label>
					<textarea rows="10" name="content" id="content" class="form-control"></textarea>
				</div>
				<div class="form-group">
					<label>작성자</label>
					<input type="text" name="writer" id="writer" value="${mvo.memName }" readonly="readonly" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-defualt btn-sm">답변</button>
				<button type="reset" class="btn btn-warning btn-sm">취소</button>
				<button type="button" class="btn btn-primary btn-sm" onclick="location.href='/board/list'">목록</button>
			</form>
		</div>
	    <div class="panel-footer">스프2탄(답변형 게시판)</div>
	  </div>
	</div>

</body>
</html>