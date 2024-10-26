<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>* SI Group Ware *</title>
</head>
<body>
	<div class="container">
		<%@ include file="./header.jsp" %>
		<%@ include file="./horimenu.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				<!-- contents start -->
				<sec:authorize access="isAnonymous()">
					<div class="row">
						<div class="col-sm-4">
							<h3>Column 1</h3>
							<p>Lorem ipsum dolor..</p>
						</div>
						<div class="col-sm-4">
							<h3>Column 2</h3>
							<p>Lorem ipsum dolor..</p>
						</div>
						<div class="col-sm-4">
							<h3>Column 3</h3>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<div class="row">
						<div class="card" class="col-sm-6">
							<div class="card-header">결제 문서 현황</div>
							<div class="card-body">
								<h6>상신 : ${apprvDtO.cntApprvUp}</h6>
								<h6>진행 : ${apprvDtO.cntApprvIng}</h6>
								<h6>완료 : ${apprvDtO.cntApprvComplete}</h6>
								<h6>반려 : ${apprvDtO.cntApprvReturn}</h6>
								<h6>대기 : ${apprvDtO.cntApprvWait}</h6>
							</div>
						</div>
						<div class="card" class="col-sm-6">
							<div class="card-header">휴가 소진 현황</div>
							<div class="card-body">
								<h6>초기 연차 : ${vocationDtO.totalVocationTime}</h6>
								<h6>사용 연차 : ${vocationDtO.usedYearVocationTime}</h6>
								<h6>잔여 연차 : ${vocationDtO.totalVocationTime - vocationDtO.usedYearVocationTime}</h6>
							</div>
						</div>
					</div>
				</sec:authorize>
				<!-- contents end -->
			</div>
		</div>
		<%@ include file="./footer.jsp" %>
	</div>
</body>
</html>
