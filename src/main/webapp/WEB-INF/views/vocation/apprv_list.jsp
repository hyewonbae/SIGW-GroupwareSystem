<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>approve list</title>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<%@ include file="../horimenu.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				<!-- contents start -->
				<h1 class="text-center mb-3">결제 목록</h1>

				<table class="table table-hover">
					<thead>
						<tr>
							<th>결제 번호</th>
							<th>년도</th>	<th>문서카테고리</th>	<th>문서번호</th>
							<th>상신부서</th>	<th>상신자</th>
							<th>문서유형</th>	<th>결제상태</th>
							<th>승인/반려</th>	<th>승인/반려 사유</th>	<th>전송</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dto" items="${aprvDocList}" varStatus="status">
							<c:if test="${dto.apprvseq == 0 || dto.preStatus == 3}">
								<tr>
									<td>${dto.apprvid}</td>
									<td>${dto.year}</td>	<td>${dto.doccategorynm}</td>	<td>${dto.docid}</td>
									<td>${dto.deptname}</td>	<td>${dto.empname}</td>
									<td>${dto.doctypenm}</td>	<td>${dto.apprvstatusnm}</td>
									<c:choose>
										<c:when test="${dto.apprvProStatus == 1 && dto.apprvstatus != 4}">
											<td>
												<select id="sel_apprv_${dto.apprvid}">
													<option value="3">승인</option>
													<option value="4">반려</option>
												</select>
											</td>
											<td>
												<input type="text" id="apprv_comment_${dto.apprvid}">
											</td>
											<td>
												<button type="button" id="${dto.apprvid}" name="${dto.docid}"
														class="insert btn btn-danger"> 결재 전송 </button>
											</td>
										</c:when>
										<c:otherwise>
											<td>${dto.apprvProStatusNM}</td>
											<td>${dto.apprvcomment}</td>
											<td></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>

				<!-- contents end -->
			</div>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>

	<script type="text/javascript">
	$(document).ready(function() {
		let insBtns = document.getElementsByClassName("insert");
		Array.from(insBtns)
				.forEach(function(element) {
					element.addEventListener('click', function() {
						$.post(
								"/vocation/apprv/update"
								, {
									apprvid : this.id
									, docid : this.name
									, apprvstatus : $("#sel_apprv_" + this.id).val()
									, apprvcomment : $("#apprv_comment_" + this.id).val()
								}
								, function(data, result) {
									if(result == "success" && data > 0) {
										location.reload();
									}
								} // function
						); // post
					}); // addEventListener
				}); // forEach
	}); // ready
	</script>

</body>
</html>
