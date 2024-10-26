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
				<form action="${root}/login" method="post">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th class="text-center">아이디</th>
								<td><input type="text" id="username" name="username" class="form-control" value="2024070901"></td>
							</tr>
							<tr>
								<th class="text-center">비밀번호</th>
								<td><input type="password" id="password" name="password" class="form-control" value="1111"></td>
							</tr>
							<tr class="text-right">
								<td colspan="2"><button class="btn btn-info"> form 로그인 </button></td>
							</tr>
						</tbody>
					</table>
				</form>
				<!-- contents end -->
			</div>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>

</body>
</html>
