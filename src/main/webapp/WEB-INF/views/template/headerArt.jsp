<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header id="header">

	<ul>
		<c:if test="${empty userId}">
			<li><a href="${pageContext.request.contextPath}/member/write.do">회원가입</a></li>
			<li><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
		</c:if>
		<c:if test="${!empty userId}">
			<li><a
				href="${pageContext.request.contextPath}/member/detail.do">회원정보</a></li>
			<li>${userId}님로그인중</li>
			<li><a
				href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
		</c:if>
	</ul>

	<div id="lnb" class="ui_header_slide">
		<div class="set_lnb ui_header_slide_menu">
			<div class="lnb_in">
				<div class="logo_museum"><a href="">대림미술관</a></div>
				<ul>
					
					<li class="menu01">
						<a href="">VISIT</a>
						<ul class="depth02">
							<li><a href="infoShowing.do">관람 안내</a></li>
							<li><a href="infoMuseum.do">미술관 소개</a></li>
							<li><a href="infoComming.do">오시는길</a></li>
						</ul>
					</li>
					
					<li class="menu02">
						<a href="">EXHIBITION</a>
						<ul class="depth02">
							<li><a href="onViewTab1.do">현재 전시</a></li>
							<li><a href="pastList.do">지난 전시</a></li>
						</ul>
					</li>
					
					<li class="menu03">
						<a href="">PROGRAM</a>
						<ul class="depth02">
							<li><a href="sundayList.do">SUNDAY LIVE ＆ CLASS</a></li>
							<li><a href="talkLectureList.do">TALK ＆ LECTURE</a></li>
							<li><a href="happyChildrenList.do">교육프로그램</a>
								<div class="depth03">
									<ul>
										<li><a href="happyChildrenList.do">어린이 (해피 칠드런)</a></li>
										<li><a href="teenDaelimerList.do">청소년 (틴 대리머)</a></li>
										<li><a href="museumPeopleList.do">청소년 (미술관 사람들)</a></li>
										<li><a href="teacherEduList.do">교사</a></li>
										<li><a href="universityList.do">대학생, 직장인 (필드트립)</a></li>
									</ul>
								</div>
							</li>
							<li><a href="bridgeLocIndex.do">지역연계프로젝트</a>
								<div class="depth03">
									<ul>
										<li><a href="bridgeLocOneView.do">DA+E 데이트 프로젝트</a></li>
										<li><a href="bridgeLocTwoView.do">통의동~통인동 프로젝트</a></li>
										<li><a href="bridgeLocThreeView.do">2010 만안의 이미지-기록과 기억</a></li>
										<li><a href="bridgeLocFourView.do">해피투게더</a></li>
									</ul>
								</div>
							</li>
						</ul>
					</li>
					
					<li class="menu04">
						<a href="library/episodeList.do">LIBRARY</a>
						<ul class="depth02">
							<li><a href="library/episodeList.do">D STORY</a></li>
							<li><a href="library/momentList.do">D MOMENT</a></li>
							<li><a href="library/wallpaperList.do">D WALLPAPER</a></li>
						</ul>
					</li>

					<li class="menu05">
						<a href="support/dCalendarView.do">NEWS</a>
						<ul class="depth02">
							<li><a href="support/dCalendarView.do">캘린더</a></li>
							<li><a href="support/noticeList.do">공지사항</a></li>
							<li><a href="support/eventList.do">이벤트</a></li>
							<li><a href="support/faq.do">FAQ</a></li>
							<li><a href="support/inquiryWrite.do">1:1 문의하기</a></li>
							<li><a href="">모바일앱 소개</a></li>
						</ul>
					</li>
				</ul>

				<div class="about_museum">
					<a href="javascript:frontMenuLink('115');">
						<span class="img"><img src="" alt=""></span>
						<p class="txt"><span>About DAELIM MUSEUM</span>일상이 예술이 되는 대림미술관</p>
					</a>
				</div>
				

			</div>
		</div>
	</div>
</header>