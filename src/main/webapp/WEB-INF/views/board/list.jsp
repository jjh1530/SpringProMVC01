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
<script>
	$(document).ready(function(){
		var result = '${result}';
		checkModal(result);		
		
		//글스기 버튼
		$("#regBtn").click(function(){
			location.href="/board/register";
		});
		//페이지 번호 쿨릭시 이동 하기
		var pageFrm=$("#pageFrm");
		$(".paginate_button a").on("click", function(e){
			e.preventDefault(); // a tag의 기능을 막는 부분
			var page =$(this).attr("href"); // 페이지번호
			pageFrm.find("#page").val(page);
			pageFrm.submit(); //
		});
	});
	
	function checkModal(result) {
		if (result =='') {
			return;
		}
		if (parseInt(result)>0) {
			$(".modal-body").html("게시글 " + parseInt(result) +"번이 등록되었습니다.");
		}
		$("#myModal").modal("show");
	}
	
	function goMsg() {
		alert("삭제된 게시글입니다.");
	}
</script>
</head>
<body>
	<div class="container">
	  <h2>Spring MVC</h2>
	  <div class="panel panel-default">
	    <!-- 로그인 폼 -->
	    <div class="panel-heading">
	    	<c:if test="${empty mvo }">
	    	<form class="form-inline" action="/login/loginProcess" method="post">
			  <div class="form-group">
			    <label for="memID">ID:</label>
			    <input type="text" class="form-control" id="memID" name="memID">
			  </div>
			  <div class="form-group">
			    <label for="memPwd">Password:</label>
			    <input type="password" class="form-control" id="memPwd" name="memPwd">
			  </div>
			  <button type="submit" class="btn btn-default">로그인</button>
			</form>
			</c:if>
			<c:if test="${!empty mvo }">
			 <form class="form-inline" action="/login/logoutProcess" method="post">
			  <div class="form-group">
			    <label>${mvo.memID }</label>
			  </div>
			  <button type="submit" class="btn btn-default">로그아웃</button>
			</form>
			</c:if>
	    </div>
	    <div class="panel-body">
	    	<table class="table table-bordered table-hover">
	    		<thead>
	    			<tr>
		    			<th>번호</th>
		    			<th>제목</th>
		    			<th>작성자</th>
		    			<th>작성일</th>
		    			<th>조회수</th>
	    			</tr>
	    		</thead>
	    		<c:forEach var="vo" items="${list }">	
	    			<tr>
		    			<td>${vo.idx }</td>
		    			<td>
		    			<c:if test="${vo.boardLevel > 0 }">
		    				<c:forEach begin="1" end="${vo.boardLevel}">
		    					<span style="padding-left:10px"></span>
		    				</c:forEach>
		    			</c:if>
		    			<c:if test="${vo.boardLevel > 0}">
		    				<c:if test="${vo.boardAvailable >0 }">
		    				<a href="/board/get?idx=${vo.idx}">[RE]<c:out value="${vo.title }"/></a>
		    				</c:if>
		    				<c:if test="${vo.boardAvailable ==0 }">
		    					<a href="javascript:goMsg()">[RE]삭제된 게시글입니다.</a>
		    				</c:if>
		    			</c:if>
		    			<c:if test="${vo.boardLevel == 0}">
		    				<c:if test="${vo.boardAvailable >0 }">
		    					<a href="/board/get?idx=${vo.idx}"><c:out value="${vo.title }"/></a>
		    				</c:if>
		    				<c:if test="${vo.boardAvailable ==0 }">
		    					<a href="javascript:goMsg()">삭제된 게시글입니다.</a>
		    				</c:if>
		    			</c:if>
		    			
		    			</td>
		    			<td>${vo.writer }</td>
		    			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.indate }"/></td>
		    			<td>${vo.count }</td>
	    			</tr>
	    		</c:forEach>
	    		<c:if test="${!empty mvo }">
	    		<tr>
	    			<td colspan="5">
	    			<button id="regBtn" class="btn btn-sm btn-primary pull-right">글쓰기</button>
	    			</td>
	    		</tr>
	    		</c:if>
	    	</table>
	    	
	    	<!-- 페이징 START -->
		      <div style="text-align: center">
			    <ul class="pagination">
		      <!-- 이전처리 -->
		      <c:if test="${pageMaker.prev}">
		        <li class="paginate_button previous">
		          <a href="${pageMaker.startPage-1}">◀</a>
		        </li>
		      </c:if>      
		      <!-- 페이지번호 처리 -->
		          <c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			         <li class="paginate_button ${pageMaker.cri.page==pageNum ? 'active' : ''}"><a href="${pageNum}">${pageNum}</a></li>
				  </c:forEach>    
		      <!-- 다음처리 -->
		      <c:if test="${pageMaker.next}">
		        <li class="paginate_button next">
		          <a href="${pageMaker.endPage+1}">▶</a>
		        </li>
		      </c:if> 
		        </ul>
		      </div>
		      <!-- END -->
    	<form id="pageFrm" action="/board/list" method="get">
         <!-- 게시물 번호(idx)추가 -->         
         <input type="hidden" id="page" name="page" value="${pageMaker.cri.page}"/>
         <input type="hidden" name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
      </form>      
	    	<!-- end -->
	    	
	    	<!-- 모달 -->
	    	<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Modal Header</h4>
			      </div>
			      <div class="modal-body">
			        <p>Some text in the modal.</p>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			
			  </div>
			</div>
			<!-- 모달끝 -->
			
		</div>
	    <div class="panel-footer">스프2탄(답변형 게시판)</div>
	  </div>
	</div>

</body>
</html>