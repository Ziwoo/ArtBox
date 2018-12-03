<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<h2>글쓰기</h2>
	<form:form action="noticeWrite.do" enctype="multipart/form-data"
	                                 commandName="command"
	                                 id="register_form">
		<form:errors element="div" class="error-color"/>
		<ul>
			<li>
				<label for="no_title">제목</label>
				<form:input path="no_title"/>
				<form:errors path="no_title" class="error-color"/>
			</li>
			<li>
				<label for="no_content">내용</label>
				<form:textarea path="no_content"/>
				<form:errors path="no_content" class="error-color"/>
			</li>
			<li>
				<label for="upload">파일업로드</label>
				<input type="file" name="upload" id="upload">
			</li>
			<li class="align-center">
				<input type="submit" value="전송">
				<input type="button" value="목록"
				            onclick="location.href='noticeList.do'">
			</li>
		</ul>                                 
	</form:form>
</div>    





