<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

  <div class="head">
    <div class="container">
        <div class="header">
          <h6 class="navbar-brand">Happy<b class="text-primary logo">Share</b></h6>
          <div class="btn-logoout">
                <c:if test="${not empty sessionScope.loginUser}">
                    ${sessionScope.loginUser.name}
                    <a href="${contextPath}/auth/logout" 
                  class="btn btn-primary btn-sm btn-logo">로그아웃</a>
                </c:if>
          </div>
        </div>
      </div> 
    </div>
