<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script></head>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<c:set var="root" value="<%= request.getContextPath() %>" />
	<div class="text-right">
	    <c:choose>
	    	<c:when test="${rebmem.empid != null && rebmem.empid != null && rebmem.empid != ''}">
			      <a href="${root}/login_logout">로그아웃</a>
	    	</c:when>
	    	<c:otherwise>
			      <a href="${root}/login_form">로그인</a>
	    	</c:otherwise>
	    </c:choose>
	</div>
	<div class="jumbotron text-center m-0">
	  <h1>* SI Group Ware *</h1>
	  <p>그룹웨어 솔루션의 완성을 목표로 화이팅!</p>
	</div>