<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-main-style">
	<h2>회원상세정보</h2>
	<ul>
		<li>아이디 : ${member.mem_id}</li>
		<li>이름 : ${member.mem_name}</li>
		<li>이메일 : ${member.mem_email1}@${member.mem_email2}</li>
		<li>가입날짜 : ${member.mem_regdate}</li>
	</ul>
	<hr size="1" width="100%">
	<p class="align-right">
		<input type="button" value="수정" 
		                  onclick="location.href='update.do'">
		<input type="button" value="회원탈퇴" 
		                  onclick="location.href='delete.do'">                  
	</p>
</div>




