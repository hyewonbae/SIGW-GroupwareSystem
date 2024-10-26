<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-5">
  <!-- Brand -->
  <a class="navbar-brand" href="${root}/">* SI Group Ware *</a>

  <!-- Links -->
  <ul class="navbar-nav">
  	<c:choose>
	  	<c:when test="${rebmem.empid != null && rebmem.empid != null && rebmem.empid != ''}">
		    <li class="nav-item">
		      <a class="nav-link" href="${root}/vocation/form">휴가원 제출</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="#">휴가원 승인</a>
		    </li>
	  	</c:when>
	  	<c:otherwise>
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
	  	</c:otherwise>
  	</c:choose>
    <!-- Dropdown -->
  </ul>
</nav>