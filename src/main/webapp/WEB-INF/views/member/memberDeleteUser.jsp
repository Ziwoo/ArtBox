<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<h2>회원탈퇴</h2>
	<form:form action="delete.do" commandName="command">
		<form:errors element="div" class="error-color"/>
		<ul>
			<li>
				<label for="mem_pwd">비밀번호</label>
				<form:password path="mem_pwd"/>
				<form:errors path="mem_pwd" class="error-color"/>
			</li>
			<li class="align-center">
				<input type="submit" value="삭제">
				<input type="button" value="회원상세정보"
				      onclick="location.href='detail.do'">
			</li>
		</ul>
	</form:form>
</div>


