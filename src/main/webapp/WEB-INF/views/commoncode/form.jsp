<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>common code form</title>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<%@ include file="../horimenu.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				<!-- contents start -->
				<h1 class="text-center mb-3">Registry Common Code</h1>

				<table class="table table-hover">
					<tbody>
						<tr>
							<th class="text-center">Code Class</th>
							<td><input type="text" id="codeclass" name="codeclass" class="form-control"></td>
						</tr>
						<tr>
							<th class="text-center">Code</th>
							<td><input type="text" id="code" name="code" class="form-control"></td>
						</tr>
						<tr>
							<th class="text-center">Code Name</th>
							<td><input type="text" id="codename" name="codename" class="form-control"></td>
						</tr>
						<tr>
							<th class="text-center">Code Description</th>
							<td><input type="text" id="codedesc" name="codedesc" class="form-control"></td>
						</tr>
						<tr class="text-right">
							<td colspan="2"><button type="button" class="btn btn-info" id="btn_ins"> Code 등록 </button></td>
						</tr>
					</tbody>
				</table>

				<form action="/commoncode/form" method="get">
				<table class="table table-hover">
					<tbody>
						<tr>
							<td>
								<div class="input-group">
									<input type="text" id="kwClass" name="kwClass"
											value="${searchDTO.kwClass}"
											class="form-control" placeholder="Code Class">
									<input type="text" id="kwCode" name="kwCode"
											value="${searchDTO.kwCode}"
											class="form-control" placeholder="Code">
									<input type="text" id="kwName" name="kwName"
											value="${searchDTO.kwName}"
											class="form-control" placeholder="Code Name">
									<input type="text" id="kwDesc" name="kwDesc"
											value="${searchDTO.kwDesc}"
											class="form-control" placeholder="Code Description">
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
							<th>분류</th>
							<th>코드</th>
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
						<c:forEach var="dto" items="${codeList}" varStatus="status">
							<tr>
								<td>${dto.codeclass}</td>
								<td>${dto.code}</td>
								<td>${dto.codename}</td>
								<td>${dto.codedesc}</td>
								<td>${dto.created}</td>
								<td>${dto.createdat}</td>
								<td>${dto.updated}</td>
								<td>${dto.updatedat}</td>
								<td>
									<button type="button" id="${dto.code}" name="${dto.codeclass}"
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
			$.post( "${root}/commoncode/insert",
					{
						codeclass : $("#codeclass").val()
						, code : $("#code").val()
						, codename : $("#codename").val()
						, codedesc : $("#codedesc").val()
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
						//alert(this.id);alert(this.name);
						if( confirm("정말 삭제 하시겠습니까?") == false ) return false;
						$.post(
								"/commoncode/delete"
								, {
									code : this.id
									, codeclass : this.name
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
