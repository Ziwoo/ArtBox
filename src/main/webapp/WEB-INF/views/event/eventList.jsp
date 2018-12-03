<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-main-style">
	<h2>게시판 목록</h2>
	<form action="eventList.do" id="search_form" method="get">
		<ul class="search">
			<li>
				<select name="keyfield">
					<option value="ev_title">제목</option>
					<option value="mem_id">ID</option>
					<option value="ev_content">내용</option>
					<option value="all">전체</option>
				</select>
			</li>
			<li>
				<input type="text" name="keyword">
			</li>
			<li>
				<input type="submit" value="찾기">
			</li>
		</ul>
	</form>
	<table>
		<tr>
			<td class="align-right">
				<input type="button" value="글쓰기"
				     onclick="location.href='eventWrite.do'">
			</td> 
		</tr>
	</table>
	 <c:if test="${count == 0}">
	<div class="align-center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<table border="1">
		<tr> 
			<th>번호</th>
			<th width="400">제목</th>
			<th>ID</th>
			<th>등록날짜</th>
		
		</tr>
		<c:forEach var="article" items="${list}">
		<tr>
			<td>${article.ev_num}</td>
			<td><a href="detail.do?ev_num=${article.ev_num}">${article.ev_title}</a></td>
			<td>${article.mem_id}</td>
			<td>${article.ev_regdate}</td>
		</tr>
		</c:forEach> 
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if> 
</div>









