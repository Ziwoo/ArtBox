<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<h2>회원 로그인</h2>
	<form:form action="login.do" commandName="command" 
	                                        id="login_form">
		<form:errors element="div" class="error-color"/>
		<ul>
			<li>
				<label for="mem_id">아이디</label>
				<form:input path="mem_id"/>
				<form:errors path="mem_id" class="error-color"/>
			</li>
			<li>
				<label for="mem_pwd">비밀번호</label>
				<form:password path="mem_pwd"/>
				<form:errors path="mem_pwd" class="error-color"/>
			</li>
			<li class="align-center">
				<input type="submit" value="로그인">
				<input type="button" value="홈으로" 
				   onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			</li>
		</ul>
	</form:form>
</div>




