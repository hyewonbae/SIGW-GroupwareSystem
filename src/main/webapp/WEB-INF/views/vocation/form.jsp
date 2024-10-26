<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>vocation insert form</title>
</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<%@ include file="../horimenu.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				<!-- contents start -->
				<h1 class="text-center mb-3">휴가 신청</h1>

				<form action="">
					<table class="table table-bordered table-hover">
						<c:forEach items="${deptList}">
							<col class="col-${Math.round(12/deptList.size())}">
						</c:forEach>
						<thead>
							<tr>
								<c:forEach var="dept" items="${deptList}">
									<th class="text-center">${dept.deptname}</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forEach var="dept" items="${deptList}" varStatus="status">
									<td class="text-center">
										${dept.empname} ${dept.hrjpname}
										<input type="hidden" id="apprvid${status.count}" name="apprvid${status.count}"
												value="${dept.empid}">
									</td>
								</c:forEach>
							</tr>
						</tbody>
					</table>

					<table class="table table-bordered table-hover">
						<tbody>
							<tr>
								<th>부서</th>
								<td>
									${employee.deptname}
									<input type="hidden" id="deptid" name="deptid" value="${employee.deptid}">
								</td>
								<th>신청자</th>
								<td>
									${employee.empname} (${employee.empid})
									<input type="hidden" id="empid" name="empid" value="${employee.empid}">
								</td>
								<th>신청일</th>
								<td>
									${toDate}
									<input type="hidden" id="year" name="year" value="${toDate.substring(0,4)}">
								</td>
							</tr>
							<tr>
								<th>문서 구분</th>
								<td>
									<c:forEach var="dto" items="${docCategoryList}">
										<input type="radio" id="doccategory" name="doccategory" value="${dto.code}"
											<c:if test="${dto.code == 1}">checked</c:if> onclick="return(false);">
										${dto.codename}
									</c:forEach>
								</td>
								<th>문서 양식</th>
								<td>
									<c:forEach var="dto" items="${docTypeList}">
										<input type="radio" id="doctype" name="doctype" value="${dto.code}"
											<c:if test="${dto.code == 11}">checked</c:if> onclick="return(false);">
										${dto.codename}
									</c:forEach>
								</td>
								<th>신청 종류</th>
								<td>
									<select id="voctype" name="voctype">
										<c:forEach var="dto" items="${vocTypeList}">
											<option value="${dto.code}">${dto.codename}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<th>문서 제목</th>
								<td colspan="5">
									<input type="text" id="doctitle" name="doctitle" class="form-control">
								</td>
							</tr>
							<tr>
								<th>시작일</th>
								<td>
									<input type="date" id="satartdate" name="satartdate" value="${toDate}">
								</td>
								<th>종료일</th>
								<td>
									<input type="date" id="enddate" name="enddate" value="${toDate}">
								</td>
								<th>신청시간</th>
								<td>
									<input type="text" id="reqtime" name="reqtime" readonly="readonly">
								</td>
							</tr>
							<tr>
								<th>문서 내용</th>
								<td colspan="5">
									<textarea rows="2" id="doccontent" name="doccontent" class="form-control"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				<div class="text-right">
					<button class="btn btn-info" id="btn1"> 신 청 </button>
				</div>

				<!-- contents end -->
			</div>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>

	<script type="text/javascript">
	$(document).ready(function() {
		$("#btn1").click(function() {

			let apprvArray = new Array();
			$("[id^='apprvid']").each(function(index, element) {
				apprvArray.push( element.value );
			});

			let date1 = new Date($("#satartdate").val());
			let date2 = new Date($("#enddate").val());
			$("#reqtime").val( (date2 - date1) / 60 / 60 / 24 / 1000 ); // set value
			if( $("#reqtime").val() < 0 ) { // get value
				alert("종료일이 시작일보다 앞선 날자 입니다.");
				return false;
			}
			if($("#satartdate").val() == $("#enddate").val()) {
				$("#reqtime").val( 8 ); // set value
			}

			if( $("#doctitle").val().trim() == '' ) {
				alert("문서 제목은 필수 입력 입니다.");
				return false;
			}

			if( $.trim($("#doccontent").val()) == '' ) {
				alert("문서 내용은 필수 입력 입니다.");
				return false;
			}

			$.post(
					"${root}/vocation/insert"
					, {
						year : $("#year").val().substring(0,4)
						,doccategory : $("#doccategory").val()
						,deptid : $("#deptid").val()
						,empid : $("#empid").val()
						,doctypedocid : $("#doctypedocid").val()
						,doctitle : $("#doctitle").val()
						,voctype : $("#voctype").val()
						,reqtime : $("#reqtime").val()
						,doccontent : $("#doccontent").val()
						,satartdate : $("#satartdate").val()
						,enddate : $("#enddate").val()
						,apprvids : apprvArray.toString()
						,apprvArray : apprvArray
					}
					, function(data, status) {
						if(status == "success" && data > 0) {
							location.href="/";
						}
					}
			); // post
		}); // click
	}); // ready
	</script>
</body>
</html>













