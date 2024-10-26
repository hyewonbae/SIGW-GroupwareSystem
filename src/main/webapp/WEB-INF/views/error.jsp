<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>
	<div class="container">
		<%@ include file="./header.jsp" %>
		<%@ include file="./horimenu.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				<!-- contents start -->

				<h3>${error_message}</h3>

				<!-- contents end -->
			</div>
		</div>
		<%@ include file="./footer.jsp" %>
	</div>
</body>
</html>