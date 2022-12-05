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
			<table class="table table-bordered table-hover">
	    			<tr>
		    			<td>번호</td>
		    			<td><input type="text" value="${vo.idx }" class="form-control" name="idx" readonly="readonly"/></td>
	    			</tr>
	    			<tr>
		    			<td>제목</td>
		    			<td><input type="text" value="${vo.title }" class="form-control" name="idx" readonly="readonly"/></td>
	    			</tr>
	    			
	    			<tr>
		    			<td>내용</td>
		    			<td><textarea rows="10" class="form-control" readonly="readonly">${vo.content }</textarea></td>
	    			</tr>
	    			<tr>
		    			<td>작성자</td>
		    			<td><input type="text" value="${vo.writer }" class="form-control" name="idx" readonly="readonly"/></td>
	    			</tr>
	    			<tr>
	    				<td colspan="2" style="text-align:center;">
	    					<c:if test="${!empty mvo }">
		    					<button class="btn btn-sm btn-primary">답글</button>
		    					<button class="btn btn-sm btn-success" onclick="location.href='/board/modify?idx=${vo.idx}'">수정</button>
		    				</c:if>
		    				<c:if test="${empty mvo }">
		    					<button disabled="disabled" class="btn btn-sm btn-primary">답글</button>
		    					<button disabled="disabled" class="btn btn-sm btn-success" onclick="location.href='/board/modify?idx=${vo.idx}'">수정</button>
		    				</c:if>
		    				<button class="btn btn-sm btn-info" onclick="location.href='/board/list'">목록</button>
	    				
	    				</td>
	    			</tr>
	    	</table>
		</div>
	    <div class="panel-footer">스프2탄(답변형 게시판)</div>
	  </div>
	</div>

</body>
</html>