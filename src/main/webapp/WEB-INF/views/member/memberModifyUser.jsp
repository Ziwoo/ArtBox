<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<div id="page_write" class="page-main-style">
	<form:form action="update.do" commandName="command" id="register_form">
		<fieldset>
			<legend>회원가입</legend>
			<form:errors element="div" class="error-color"/>
			<ul>
				<li>
					<label>아이디</label>
					${command.mem_id}
				</li>
				<li>
					<label for="mem_name">이름</label>
					<form:input path="mem_name"/><br>
					<form:errors path="mem_name" class="error-color"/>
				</li>
				<li>
					<label for="mem_pwd">비밀번호</label>
					<form:password path="mem_pwd"/><br>
					<form:errors path="mem_pwd" class="error-color"/>
				</li>  
				<li>
					<label for="mem_phone1">번호1</label>
					<form:input path="mem_phone1"/><br>
					<form:errors path="mem_phone1" class="error-color"/>
				</li>
				<li>
					<label for="mem_phone2">번호2</label>
					<form:input path="mem_phone2"/><br>
					<form:errors path="mem_phone2" class="error-color"/>
				</li>
				<li>
					<label for="mem_phone3">번호3</label>
					<form:input path="mem_phone3"/><br>
					<form:errors path="mem_phone3" class="error-color"/>
				</li>
				<!-- 성별은 나중에 체크박스로 -->
				<li>
					<label for="mem_sex">성별</label>
					<form:input path="mem_sex"/><br>
					<form:errors path="mem_sex" class="error-color"/>
				</li>
				<li>
					<label for="mem_email1">이메일1</label>
					<form:input path="mem_email1"/><br>
					<form:errors path="mem_email1" class="error-color"/>
				</li>
				<li>
					<label for="mem_email2">이메일2</label>
					<form:input path="mem_email2"/><br>
					<form:errors path="mem_email2" class="error-color"/>
				</li>
				<li class="align-center">
					<input type="submit" value="전송" class="write-btn">
				</li>
			</ul>
		</fieldset>
	</form:form>
</div>