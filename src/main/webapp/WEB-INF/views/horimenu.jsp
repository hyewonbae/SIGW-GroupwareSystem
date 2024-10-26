<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-5">
	<!-- Brand -->
	<a class="navbar-brand" href="${root}/">* SI Group Ware *</a>

	<!-- Links -->
	<ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="/commoncode/form">공통 코드 등록</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/role/form">사용자 Role 등록</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/member/form">사용자 등록</a>
	    </li>

		<sec:authorize access="isAuthenticated()">
		    <li class="nav-item">
		      <a class="nav-link" href="${root}/vocation/form">휴가원 제출</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="${root}/vocation/apprv/list">휴가원 승인</a>
		    </li>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
		    <li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
		        Dropdown link
		      </a>
		      <div class="dropdown-menu">
		        <a class="dropdown-item" href="#">Link 1</a>
		        <a class="dropdown-item" href="#">Link 2</a>
		        <a class="dropdown-item" href="#">Link 3</a>
		      </div>
		    </li>
		</sec:authorize>
	</ul>
</nav>