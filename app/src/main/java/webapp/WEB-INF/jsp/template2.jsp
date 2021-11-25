<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
<c:if test="${not empty refresh}">
  <meta http-equiv="Refresh" content="${refresh}">   
</c:if>
  
    <title>${pageTitle}</title>
    <!-- link -->
    <link rel="stylesheet" href="${contextPath}/assets/css/bootstrap.css">
	  <link rel="stylesheet" href="${contextPath}/assets/css/maicons.css">
	  <link rel="stylesheet" href="${contextPath}/assets/vendor/animate/animate.css">
	  <link rel="stylesheet" href="${contextPath}/assets/vendor/owl-carousel/css/owl.carousel.css">
	  <link rel="stylesheet" href="${contextPath}/assets/vendor/fancybox/css/jquery.fancybox.css">
	  <link rel="stylesheet" href="${contextPath}/assets/css/theme.css">
	  <link rel="stylesheet" href="${contextPath}/assets/css/admin.css">
  </head>
<body>
<div id="wrap">

<jsp:include page="AdminHeader.jsp"/>
<jsp:include page="AdminSidebar.jsp"/>
 
<div id="content">
<jsp:include page="${contentUrl}"/>
</div><!-- #content --> 


</div>
<!-- //wrap -->
<script src="${contextPath}/assets/js/jquery-3.5.1.min.js"></script>

</body>
</html>








