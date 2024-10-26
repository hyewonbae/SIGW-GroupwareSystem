<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script></head>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<c:set var="root" value="<%= request.getContextPath() %>" />
	<div class="text-right">
		<sec:authorize access="isAuthenticated()">
			      <a href="${root}/logout">SECU 로그아웃</a>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			      <a href="${root}/security/form">SECU 로그인</a>
		</sec:authorize>
	</div>
	<div class="jumbotron text-center m-0">
	  <h1>* SI Group Ware *</h1>
	  <p>그룹웨어 솔루션의 완성을 목표로 화이팅!</p>
	</div>