<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
<div class="page-main-style">
	<h2 class="align-center">${event.ev_title}</h2>
	<ul>
		<li>번호 : ${event.ev_num}</li>
		<li>아이디 : ${event.mem_id}</li>
		<li>등록날짜 : ${event.ev_regdate}</li>
		<c:if test="${!empty event.filename}">
		<li>첨부파일 : <a href="file.do?ev_num=${event.ev_num}">${event.filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width="100%">
	<c:if test="${event.filename.endsWith('.jpg') ||
					event.filename.endsWith('.JPG') ||
					event.filename.endsWith('.gif') ||
					event.filename.endsWith('.GIF') ||
					event.filename.endsWith('.png') ||
					event.filename.endsWith('.PNG')}">
	<div class="align-center">
		<img src="uploadImageView.do?ev_num=${event.ev_num}" style="max-width:600px;">
	</div>
	</c:if>		
	<p>
		
		${event.ev_content}
		
	</p>
	<hr size="1" width="100%">
	<p class="align-right">
		<c:if test="${!empty userId && userId == event.mem_id}">
		 <input type="button" value="수정" 
		     onclick="location.href='update.do?ev_num=${event.ev_num}'">
		<input type="button" value="삭제" 
		     onclick="location.href='delete.do?ev_num=${event.ev_num}'"> 
		</c:if>
		<input type="button" value="목록" 
		                        onclick="location.href='eventList.do'">
	</p>
	

</div>    








 





