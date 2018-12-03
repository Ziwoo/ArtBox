<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/notice.reply.js"></script>
<div class="page-main-style">
	<h2 class="align-center">${notice.no_title}</h2>
	<ul>
		<li>번호 : ${notice.no_num}</li>
		<li>아이디 : ${notice.mem_id}</li>
		<li>등록날짜 : ${notice.no_regdate}</li>
		<c:if test="${!empty notice.filename}">
		<li>첨부파일 : <a href="file.do?no_num=${notice.no_num}">${notice.filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width="100%">
	<c:if test="${notice.filename.endsWith('.jpg') ||
					notice.filename.endsWith('.JPG') ||
					notice.filename.endsWith('.gif') ||
					notice.filename.endsWith('.GIF') ||
					notice.filename.endsWith('.png') ||
					notice.filename.endsWith('.PNG')}">
	<div class="align-center">
		<img src="uploadImageView.do?no_num=${notice.no_num}" style="max-width:600px;">
	</div>
	</c:if>		
	<p>
		
		${notice.no_content}
		
	</p>
	<hr size="1" width="100%">
	<p class="align-right">
		<c:if test="${!empty userId && userId == notice.mem_id}">
		 <input type="button" value="수정" 
		     onclick="location.href='update.do?no_num=${notice.no_num}'">
		<input type="button" value="삭제" 
		     onclick="location.href='delete.do?no_num=${notice.no_num}'"> 
		</c:if>
		<input type="button" value="목록" 
		                        onclick="location.href='noticeList.do'">
	</p>
	 <div id="reply_div">
		<span class="reply-title">댓글 달기</span>
		<form id="re_form">
			<input type="hidden" name="no_num" value="${notice.no_num}" id="no_num">
			<input type="hidden" name="mem_id" value="${userId}" id="userId">
			<textarea rows="3" cols="50" name="re_content"
			  id="re_content" maxlength="300" class="rep-content"
			  <c:if test="${empty userId}">disabled="disabled"</c:if>
			  ><c:if test="${empty userId}">로그인해야 작성할 수 있습니다.</c:if></textarea>
			<c:if test="${!empty userId}">
			<div id="re_first">
				<span class="letter-count">300/300</span>
			</div>
			<div id="re_second" class="align-right">
				<input type="submit" value="전송">
			</div>
			</c:if>	
		</form>
	</div> 
	
	<!-- 목록 출력 -->
	<div id="output"></div>
	<div class="paging_button" style="display:none;">
		<input type="button" value="다음글 보기">
	</div>
	<div id="loading" style="display:none;">
		<img src="${pageContext.request.contextPath}/main/resources/images/ajax-loader.gif">
	</div>
	<!-- 수정폼 -->	
	<div id="modify_div" style="display:none;">
		<form id="mre_form">
			<input type="hidden" name="re_no" id="mre_no">
			<input type="hidden" name="id" id="muserId">
			<textarea rows="3" cols="50" name="re_content"
			  id="mre_content" class="rep-content"></textarea>
			<div id="mre_first">
				<span class="letter-count">300/300</span>
			</div>  
			<div id="mre_second" class="align-right">
				<input type="submit" value="수정">
				<input type="button" value="취소" class="re-reset">
			</div>
			<hr size="1" noshade width="96%">
		</form>
	</div>
</div>   








 





