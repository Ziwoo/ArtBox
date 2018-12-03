<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="menu">
	<li><a href="${pageContext.request.contextPath}/main/main.do">홈으로</a></li>
	<li><a href="${pageContext.request.contextPath}/notice/noticeList.do">공지사항</a></li>
	<li><a href="${pageContext.request.contextPath}/event/eventList.do">이벤트</a></li>
	
	<c:if test="${empty userId}">
		<li><a href="${pageContext.request.contextPath}/member/write.do">회원가입</a></li>
		<li><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
	</c:if>
	<c:if test="${!empty userId}">
		<li><a href="${pageContext.request.contextPath}/member/list.do">회원목록</a></li>
		<li>${userId}님 로그인 중</li>
		<li><a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
	</c:if>
</ul>