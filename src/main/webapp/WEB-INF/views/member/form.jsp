<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member form</title>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<%@ include file="../horimenu.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				<!-- contents start -->
				<h1 class="text-center mb-3">사용자 등록</h1>

				<table class="table table-hover">
					<tbody>
						<tr>
							<th class="text-center">Employee ID</th>
							<td>
								<div class="input-group">
									<input type="text" id="username" name="username" class="form-control">
									<button type="button" id="btn_emp" class="btn btn-primary">Employee 확인</button>
									<input type="hidden" id="search_result">
								</div>
							</td>
						</tr>
						<tr>
							<th class="text-center">Password</th>
							<td><input type="text" id="password" name="password" class="form-control"></td>
						</tr>
						<tr>
							<th class="text-center">Role</th>
							<td>
								<button type="button" id="btn_role_add" class="btn btn-sm btn-secondary">
									Role 추가 (최대 3개)
								</button>
								<div id="div_role" class="mt-1"></div>
							</td>
						</tr>
						<tr class="text-right">
							<td colspan="2"><button type="button" class="btn btn-info" id="btn_ins"> Member 등록 </button></td>
						</tr>
					</tbody>
				</table>

				<form action="/member/form" method="get">
				<table class="table table-hover">
					<tbody>
						<tr>
							<td>
								<div class="input-group">
									<input type="text" id="kwCode" name="kwCode"
											value="${searchDTO.kwCode}"
											class="form-control" placeholder="Employee ID">
									<input type="text" id="kwName" name="kwName"
											value="${searchDTO.kwName}"
											class="form-control" placeholder="Employee Name">
									<button type="submit" class="btn btn-warning">검색</button>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				</form>

				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>Role</th>
							<th>생성자</th>
							<th>생성일</th>
							<th>수정자</th>
							<th>수정일</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dto" items="${userList}" varStatus="status">
							<tr>
								<td>${dto.id}</td>
								<td>${dto.username}</td>
								<td>${dto.empname}</td>
								<td>${dto.roleNames}</td>
								<td>${dto.createdEmpname}</td>
								<td>${dto.createdat}</td>
								<td>${dto.updatedEmpname}</td>
								<td>${dto.updatedat}</td>
								<td>
									<button type="button" id="${dto.id}"
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
	let selectRoleOption = '';
	$(document).ready( function() {
		$.get(
				"/common/combo/role_all"
				, function(data, result) {
					selectRoleOption = "<select class='sel_role mr-1'>";
					data.forEach(function(dto, idx){
						selectRoleOption = selectRoleOption
						+ "<option value='"+ dto.roleid +"''>"
						+ dto.rolename + "</option>";
					}); //forEach
					selectRoleOption = selectRoleOption + "</select>";
					$("#div_role").append(selectRoleOption);
				} // function
		); // get

		$("#btn_role_add").click( function() {
			let selArr = document.getElementsByClassName("sel_role");
			if(selArr.length < 3) {
				$("#div_role").append(selectRoleOption);
			} //if
		}); //click
	}); // document.ready

	$(document).ready( function() {
		$("#btn_emp").click( function() {
			let tmpNm = $("#username").val();
			$.post( "${root}/member/emp_check",
					{
						username : $("#username").val()
					},
					function(data, status) {
						alert(data.messageDesc);

						if(data.messageName == "success") {
							search_result.value = tmpNm;
						} else {
							search_result.value = '';
						}
					}
			); // post
		}); //click

		$("#btn_ins").click( function() {
			if( $("#username").val() == '' || search_result.value != $("#username").val() ) {
				//alert("Employee 확인을 클릭해 주세요.");
				//return;
			}

			let selArr = document.getElementsByClassName("sel_role");
			let roleArr = new Array();
			for(let i=0; i<selArr.length; i++) {
				roleArr.push(selArr[i].value);
			}

			$.post( "${root}/member/insert",
					{
						username : $("#username").val()
						, password : $("#password").val()
						, roleArr : roleArr
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
						//alert(this.id);
						if( confirm("정말 삭제 하시겠습니까?") == false ) return false;
						$.post(
								"/member/delete"
								, {
									id : this.id
								}
								, function(data, status){
									if(status == "success" && data > 0) {
										alert("삭제 하였습니다.");
										location.reload();
									} // if
								} // function
						); // post
					}); // addEventListener
				}); // forEach
	}); // document.ready
	</script>
</body>
</html>
