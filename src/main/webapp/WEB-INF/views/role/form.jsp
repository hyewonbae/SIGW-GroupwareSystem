<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>role form</title>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<%@ include file="../horimenu.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				<!-- contents start -->
				<h1 class="text-center mb-3">Registry Role</h1>

				<table class="table table-hover">
					<tbody>
						<tr>
							<th class="text-center">ROlE NAME</th>
							<td><input type="text" id="rolename" name="rolename" class="form-control"></td>
						</tr>
						<tr>
							<th class="text-center">ROLE DESC</th>
							<td><input type="text" id="roledesc" name="roledesc" class="form-control"></td>
						</tr>
						<tr class="text-right">
							<td colspan="2"><button type="button" class="btn btn-info" id="btn_ins"> ROLE 등록 </button></td>
						</tr>
					</tbody>
				</table>

				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>설명</th>
							<th>생성자</th>
							<th>생성일</th>
							<th>수정자</th>
							<th>수정일</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dto" items="${roleList}" varStatus="status">
							<tr>
								<td>${dto.roleid}</td>
								<td>${dto.rolename}</td>
								<td>${dto.roledesc}</td>
								<td>${dto.createdEmpname}</td>
								<td>${dto.createdat}</td>
								<td>${dto.updatedEmpname}</td>
								<td>${dto.updatedat}</td>
								<td>
									<button type="button" id="${dto.roleid}"
											class="btn_del btn btn-sm btn-danger">삭제</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- contents end -->
			</div>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>

	<script>
	$(document).ready( function() {
		$("#btn_ins").click( function() {
			$.post( "${root}/role/insert",
					{
						rolename : $("#rolename").val()
						, roledesc : $("#roledesc").val()
					},
					function(data, status) {
						if(status == "success" && data > 0) {
							alert("등록 하였습니다.");
							location.reload();
						}
					}
			); // post
		}); //click

		let btnDels = document.getElementsByClassName("btn_del");
		Array.from(btnDels)
				.forEach(function(element) {
					element.addEventListener('click', function() {
						// alert(this.id);
						if( confirm("정말 삭제 하시겠습니까?") == false ) return false;
						$.post(
								"/role/delete"
								, {roleid : this.id}
								, function(data, status){
									if(status == "success" && data > 0) {
										alert("삭제 하였습니다.");
										location.reload();
									} // if
								} // function
						); // get
					}); // addEventListener
				}); // forEach


	}); // document.ready
	</script>
</body>
</html>
