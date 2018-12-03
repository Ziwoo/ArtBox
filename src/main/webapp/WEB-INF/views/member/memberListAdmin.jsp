<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.list.title"/></title>
<link rel="stylesheet" href="./resources/css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
	<h2>회원 목록 보기</h2>

	<c:if test="${count == 0 }">
		<div class="align-center">출력할 리스트가 없습니다.</div>
	</c:if>
	<c:if test="${count >0 }">
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>가입일자</th>
				<th>성별</th>
				<th>연락처</th>
				<th>이메일</th>
				<th>회원등급</th>
			</tr>
			<c:forEach var="member" items="${list}">
				<tr>
					<td><a href="detail.do?mem_id=${member.mem_id}">${member.mem_id}</a></td>
					<td>${member.mem_pwd}</td>
					<td>${member.mem_name}</td>
					<td>${member.mem_regdate}</td>
					<td>${member.mem_sex}</td>
					<td>${member.mem_phone1}-${member.mem_phone2}-${member.mem_phone3}</td>
					<td>${member.mem_email1}@${member.mem_email2}</td>
					<td>${member.mem_level}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
</body>
</html>