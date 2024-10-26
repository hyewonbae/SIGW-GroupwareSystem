<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form</title>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<%@ include file="../horimenu.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				<!-- contents start -->
				<h1 class="text-center mb-3">로그인</h1>

				<form action="${root}/login_login" method="post">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th class="text-center">아이디</th>
								<td><input type="text" id="login_id" name="loginID" class="form-control" value="2024070901"></td>
							</tr>
							<tr>
								<th class="text-center">비밀번호</th>
								<td><input type="password" id="login_pwd" name="loginPWD" class="form-control" value="1111"></td>
							</tr>
							<tr class="text-right">
								<td colspan="2"><button class="btn btn-info"> form 로그인 </button></td>
							</tr>
						</tbody>
					</table>
				</form>

				<div class="text-right">
					<button type="button" id="btn1" class="btn btn-warning"> jQuery AJAX 로그인 </button>
				</div>

				<!-- contents end -->
			</div>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>

	<script>
	// $(document).ready : 현재 html 문서가 로딩이 완료되면.
	// () 내부의 function : 기능을 수행한다.
	$(document).ready( function() {
		$("#btn1").click( function() {
			$.post( "${root}/login_rest_login", // 서버 주소
					{
						loginID : $("#login_id").val()
						, loginPWD : $("#login_pwd").val()
					}, // 서버로 전송할 데이터
					function(data, status) {
						// callback function : 서버에서 리턴해 주는 값을 받는 function.
						// data : 서버에서 리턴해 주는 값
						// status : http status (주의!! 통신 성공 여부만 가린다.)
						if(status == "success" && data.length > 0) {
							location.replace("${pageContext.request.contextPath}/");
						}
					}
					// , "json" : data type
			); // post
		}); //click
	}); // document.ready
	</script>
</body>
</html>
