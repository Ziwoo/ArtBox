<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-main-style">
	<h2>글수정</h2>
	<form:form action="update.do" enctype="multipart/form-data"
	                                 commandName="command"
	                                 id="modify_form">
		<form:errors element="div" class="error-color"/>
		<ul> 
			<li>
				<label for="ev_title">제목</label>
				<form:input path="ev_title"/>
				<form:errors path="ev_title" class="error-color"/>
			</li>
			<li>
				<label for="ev_content">내용</label>
				<form:textarea path="ev_content"/>
				<form:errors path="ev_content" class="error-color"/>
			</li>
			<li>
				<label for="upload">파일업로드</label>
				<input type="file" name="upload" id="upload">
				<c:if test="${!empty command.filename}">
				<br>
				<span>(${command.filename})파일이 등록되어 있습니다.
				다시 업로드하면 기존 파일은 삭제됩니다.</span>
				</c:if>
			</li>
			<li class="align-center">
				<input type="submit" value="전송">
				<input type="button" value="목록"
				            onclick="location.href='eventList.do'">
			</li>
		</ul>                                 
	</form:form>
</div>    





