<!DOCTYPE html>
<%@ tag description="Template Site Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="title" fragment="true"%>
<html lang="en">
	<head>
		<title><jsp:invoke fragment="title"/></title>
		<spring:url value="/resources/css/bootstrap-theme.css" var="bootstraptheme"></spring:url>
		<spring:url value="/resources/css/bootstrap.css" var="bootstrap"></spring:url>
		<spring:url value="/resources/css/starter-template.css" var="startertemplate"></spring:url>
		
		<link href="${bootstraptheme}" rel="stylesheet">
		<link href="${bootstrap}" rel="stylesheet">
		<link href="${startertemplate}" rel="stylesheet">
						
		<spring:url value="/resources/angularjs/angular.min.js" var="angular"></spring:url>
		<spring:url value="/resources/js/bootstrap.min.js" var="bootstrap"></spring:url>
		<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jquery"></spring:url>
		<spring:url value="/resources/angularjs/angular-customer-login.js" var="customerlogin"></spring:url>
		
		<script src="${angular}" type="text/javascript"></script>
		<script src="${bootstrap}" type="text/javascript"></script>
		<script src="${jquery}" type="text/javascript"></script>
		<script src="${customerlogin}" type="text/javascript"></script>
		
	</head>
	<body>
	    <nav class="navbar navbar-inverse navbar-fixed-top">
	      <div class="container">
	        <div class="navbar-header">
	          <b><a class="navbar-brand" href="${pageContext.request.contextPath}">Your way</a></b>
	        </div>

	     	<div id="navbar" class="navbar-collapse collapse">
	          	<ul class="nav navbar-nav">
	             <li><a href="${pageContext.request.contextPath}">Home</a></li>
				
	            <c:url value="/signup.html" var="signupURL" />
	            <li><a href="${signupURL}">Signup</a></li>
	            
	            <c:if test='${sessionScope.username==null}'>
	            	<c:url value="/login.html" var="loginURL" />
	            	<li><a href="${loginURL}">Login</a></li>
	          	</c:if>
	          	<c:if test='${sessionScope.username!=null}'>
	          		<c:url value="/logout.html" var="logoutURL" />
	            	<li><a href="${logoutURL}">Logout</a></li>
	          	</c:if>
	          	<c:if test='${sessionScope.username!=null}'>
	          		<c:url value="/setprofile.html" var="setprofileURL" />
	            	<li><a href="${setprofileURL}">Set Your Profile</a></li>
	          	</c:if>
	          </ul>
	  
	        </div>
	      </div>
	    </nav>

		<div id="containerGreeting" class="jumbotron text-center">
		    <div class="container">
		      <div class="row">
		        <div class="col col-lg-12 col-sm-12">
		          <p style="color:red;">We'll make your immigration process much easier!</p>
		        </div>
		      </div>
		    </div>
		</div>

		<div class="container">
			<div class="starter-template">
				<jsp:doBody/>
			</div>
 	    </div>

  	 <footer class="footer">
      	<div class="container">
        	<p class="text-muted"><b>Your way company's property &copy</b></p>
        </div>
    </footer>

  </body>
</html>