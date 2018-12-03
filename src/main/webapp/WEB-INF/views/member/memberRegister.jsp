<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>  

<div id="page_write" class="page-main-style">
	<form:form action="write.do" commandName="command" id="register_form">
		<fieldset>
			<legend>회원가입</legend>
			<form:errors element="div" cssClass="error-color"/>
			<ul>
				<li>
					<label for="mem_id">아이디</label>
					<form:input path="mem_id"/>
					<input type="button" id="confirmId" value="ID중복체크">
					<span id="message_id"></span>
					<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif"
						width="16" height="16" style="display:none;">
					<form:errors path="mem_id" cssClass="error-color"/>
				</li>
				<li>
					<label for="mem_pwd">비밀번호</label>
					<form:password path="mem_pwd"/><br>
					<form:errors path="mem_pwd" cssClass="error-color"/>
				</li>
				<li>
					<label for="mem_name">이름</label>
					<form:input path="mem_name"/><br>
					<form:errors path="mem_name" cssClass="error-color"/>
				</li>  
				<li>
					<label for="mem_phone1">번호1</label>
					<form:input path="mem_phone1"/><br>
					<form:errors path="mem_phone1" cssClass="error-color"/>
				</li>
				<li>
					<label for="mem_phone2">번호2</label>
					<form:input path="mem_phone2"/><br>
					<form:errors path="mem_phone2" cssClass="error-color"/>
				</li>
				<li>
					<label for="mem_phone3">번호3</label>
					<form:input path="mem_phone3"/><br>
					<form:errors path="mem_phone3" cssClass="error-color"/>
				</li>
				<!-- 성별은 나중에 체크박스로 -->
				<li>
					<label for="mem_sex">성별</label>
					<form:input path="mem_sex"/><br>
					<form:errors path="mem_sex" cssClass="error-color"/>
				</li>
				<li>
					<label for="mem_email1">이메일1</label>
					<form:input path="mem_email1"/><br>
					<form:errors path="mem_email1" cssClass="error-color"/>
				</li>
				<li>
					<label for="mem_email2">이메일2</label>
					<form:input path="mem_email2"/><br>
					<form:errors path="mem_email2" cssClass="error-color"/>
				</li>
				<li class="align-center">
					<input type="submit" value="회원가입" class="write-btn">
					<input type="button" value="홈으로" class="write-btn"
						onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
				</li>
			</ul>
		</fieldset>
	</form:form>
</div>