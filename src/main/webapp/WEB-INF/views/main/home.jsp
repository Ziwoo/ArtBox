<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div id="container">
		<!-- contents -->
		<section id="contents">
			<div class="set_banner ui_main_banner">
				
				<!-- 전시 배너 -->
				<nav class="indicator ui_indicator">
					<button type="button" class="btn stop ui_play_state" data-stop-text="배너 일시정지" data-start-text="배너 자동 재생"><span class="hide">배너 일시정지</span></button>
					<a href="#banner01" class="active">
						첫번째 배너 상세보기
					</a> <!-- 활성화시 .active 추가 -->
				</nav>
				<ul class="ui_list">
					<li id="banner01" class="ui_slide active">
						<a href="/onViewTab1.do" style="background:url('${pageContext.request.contextPath}/resources/img/[329766_355571]20161004163842.png') no-repeat center 0;">
							<div class="area_text">
								<span class="text ui_main_motion"><img src="${pageContext.request.contextPath}/resources/img/[329766_355590]20161004182325.png" alt="nick night" /></span>
							</div>
						</a>
					</li>
				</ul>
				<!-- //전시 배너 -->

				<!-- 안내 -->
				<div class="content_wide01">
					<div class="content_in">
						
						<div class="set_guide">
							<ul>
								<li class="guide01">
											<a href="/member/joinStep1.do?CD_CL_MBR=2" class="cont">
												<strong class="tit">ONLINE MEMBER</strong>
												<span class="text">온라인 회원만의 특별한 혜택! 전시 20% 할인!</span>
											</a>
											<a href="/member/joinStep1.do?CD_CL_MBR=2" class="btn btn_sm transparent">회원가입 하기</a>
								</li>
								<li class="guide02">
									<a href="/infoShowing.do?info=3" class="cont">
										<strong class="tit">MOBILE APP</strong>
										<span class="text">오디오 가이드로 전시관람을 더 재미있게!</span>
									</a>
									<a href="/infoShowing.do?info=3" class="btn btn_sm transparent">모바일로 미술관 즐기기</a>
								</li>
								<li class="guide03">
									<a href="/infoShowing.do?info=2" class="cont">
										<strong class="tit">D MEMBERSHIP</strong>
										<span class="text">다채롭게 즐기는 전시 3회+문화 프로그램+커피</span>
									</a>
									<a href="/infoShowing.do?info=2" class="btn btn_sm transparent">자세한 혜택보기</a>
								</li>
							</ul>
						</div>
						
						<!-- 관람 시간 -->
						<div class="opening_hours">
							<div class="today ui_open_date">
								<img src="/front/images/main/text_hour_sunday.png" class="none" alt="오늘의 관람시간 10:00AM – 6:00PM">
								<img src="/front/images/main/text_hour_monday.png" class="none" alt="오늘은 미술관이 쉽니다.">
								<img src="/front/images/main/text_hour_tuesday.png" class="none" alt="오늘의 관람시간 10:00AM – 6:00PM">
								<img src="/front/images/main/text_hour_wednesday.png" class="none" alt="오늘의 관람시간 10:00AM – 6:00PM">
								<img src="/front/images/main/text_hour_thursday.png" class="none" alt="오늘의 관람시간 10:00AM – 8:00PM">
								<img src="/front/images/main/text_hour_friday.png" class="none" alt="오늘의 관람시간 10:00AM – 6:00PM">
								<img src="/front/images/main/text_hour_saturday.png" class="none" alt="오늘의 관람시간 10:00AM – 8:00PM">
							</div>							
							<div class="info">
								화-일요일 l 10:00AM – 6:00PM <br>
								목, 토요일 l 10:00AM – 8:00PM <br>
								전시종료 30분전 매표 마감<br>
								매주 월요일 휴관, 설/추석 연휴 휴관
							</div>
							<div class="link">
								<a href="/infoShowing.do">관람 안내</a>
								<a href="/infoComming.do">오시는 길</a>
							</div>
						</div>
						<!-- //관람 시간 -->
						
						<span class="icon_arrow ui_icon_arrow none"></span> <!-- 하단 컨텐츠 인식 화살표 -->
					</div>
				</div>
				<!-- //안내 -->
			</div>

			<div class="content_wide02">
				<div class="content_in">
					<!-- PROGRAM -->
					<div class="set_program" >
						
						<!-- WEEK -->
						<div class="program_week">
							<div class="title02">
								<h2>UPCOMING PROGRAM</h2>
								<div class="text_sub">대림미술관의 특별한 프로그램</div>
							</div>
							<ul class="list_banner">
								<li>
									<div class="banner_cont">
										<a href="/talkLectureView.do?no_prgm_seq=811" class="thumbnail"><img src="${pageContext.request.contextPath}/resources/img/[330226_362732]20170222090158.jpg" alt="#6  크리에이티브 디렉터 박웅현" /></a>
										<a href="/talkLectureView.do?no_prgm_seq=811" class="tit"><em>TALK &amp; LECTURE #6 - 크리에이티브 디렉터 박웅현</em></a>
										<span class="date">2017.03.15 WED 17:00 - 18:30</span>
									</div>
								</li>
								<li>
									<div class="banner_cont">
										<a href="/sundayView.do?no_prgm_seq=817" class="thumbnail"><img src="${pageContext.request.contextPath}/resources/img/[357774_363249]20170308082425.jpg" alt="pc웹메인" /></a>
										<a href="/sundayView.do?no_prgm_seq=817" class="tit"><em>SUNDAY CLASS #5 - 테라리움, 플라워 박스 워크샵</em></a>
										<span class="date">2017.03.19 SUN 13:00 / 16:00</span>
									</div>
								</li>
							</ul>
						</div>
						<!-- WEEK -->
						
						<!-- D MOMENT -->
						<div class="program_moment">
							<div class="title02">
								<h2>REVIEW</h2>
								<div class="text_sub">미술관 현장의 생생한 이야기</div>
							</div>
							<div class="set_moment ui_mement_banner">
								<nav class="indicator ui_indicator">
									<button type="button" class="btn stop ui_play_state"><span class="hide">배너 일시정지</span></button>
										<a href="#moment01" class="active">
											첫번째 배너 상세보기
										</a>
										<a href="#moment02" >
											두번째 배너 상세보기
										</a>
										<a href="#moment03" >
											세번째 배너 상세보기
										</a>
								</nav>
								<ul class="ui_list">
									<li id="moment01" class="ui_slide active">
										<div class="moment_text">
											<a href="javascript:goMoment('6026');">[SUNDAY LIVE] 당신이 꿈꾸던 크리스마스의 모든 것 &lt;WINTER JAZZ LAND&gt;</a>
										</div>
										<div class="thumbnail"><img src="/att/[357763_363228]20170307150312.jpg" alt="웹메인배너" /></div>
									</li>
									<li id="moment02" class="ui_slide ">
										<div class="moment_text">
											<a href="javascript:goMoment('6008');">[TALK &amp; LECTURE] #5 홍경한 평론가 - ‘회화’에서 ‘3D 프린팅’까지! IMAGE 읽기</a>
										</div>
										<div class="thumbnail"><img src="/att/[357544_362976]20170227174812.jpg" alt="웹메인" /></div>
									</li>
									<li id="moment03" class="ui_slide ">
										<div class="moment_text">
											<a href="javascript:goMoment('6006');">[SUNDAY CLASS] #4 단 하나의 자화상 - 포토콜라주 워크샵</a>
										</div>
										<div class="thumbnail"><img src="/att/[357542_362970]20170227174438.jpg" alt="웹메인배너" /></div>
									</li>
								</ul>
							</div>
						</div>
						<!-- //D MOMENT -->
					</div>
					<!-- //PROGRAM -->
				</div>
			</div>

			<div class="content_wide03">
				<div class="content_in">
					<!-- FUN -->
					<div class="set_fun">
						<div class="title02">
							<h2>WHAT’S ON</h2>
							<div class="text_sub">미술관의 다양한 소식</div>
						</div>
						<!-- ART SHOP -->
						<div class="fun_banner ui_shop_banner" >
							<a href="#" class="title03">
								<h3>ART SHOP</h3>
								<div class="text_sub">전시의 감동을 그대로</div>
							</a>
							<nav class="indicator ui_indicator">
								<button type="button" class="btn stop ui_play_state" data-stop-text="배너 일시정지" data-start-text="배너 자동 재생"><span class="hide">배너 일시정지</span></button>
									<a href="#product01" class="active">
										첫번째 배너 상세보기
									</a>
									<a href="#product02" >
										두번째 배너 상세보기
									</a>
									<a href="#product03" >
										세번째 배너 상세보기
									</a>
							</nav>
							<ul class="">
								<li id="product01" class="_active ui_list">
									<a href="onViewTab5.do">
										<span class="banner_text">
											<span class="ui_slide">
												<strong class="tit">폰케이스</strong>
												<span class="text">전시의 감동을 손 안에 담다</span>
												<span class="price">12,000원</span>
											</span>
										</span>
										<span class="thumbnail"><img src="/att/[294930_355580]20161004170118.png" alt="폰케이스" /></span>
									</a>
								</li>
								<li id="product02" class="_active ui_list">
									<a href="onViewTab5.do">
										<span class="banner_text">
											<span class="ui_slide">
												<strong class="tit">엽서</strong>
												<span class="text">개성있는 스타일로 마음을 전하다</span>
												<span class="price">2,000원</span>
											</span>
										</span>
										<span class="thumbnail"><img src="/att/[294931_355581]20161004170145.png" alt="엽서" /></span>
									</a>
								</li>
							
								<li id="product03" class="_active ui_list">
									<a href="onViewTab5.do">
										<span class="banner_text">
											<span class="ui_slide">
												<strong class="tit">에코백</strong>
												<span class="text">세기의 디자이너 작품으로 패션을 완성하다</span>
												<span class="price">12,000원</span>
											</span>
										</span>
										<span class="thumbnail"><img src="/att/[294933_355582]20161004170213.png" alt="에코백" /></span>
									</a>
								</li>
							</ul>
						</div>
						
						<!-- //ART SHOP -->
						<!-- NOTICE -->
						<div class="fun_news">
							<div class="title03"><h3>NOTICE</h3></div>
							<ul>
								<li>
									<a href="javascript:goNotice('1148');" class="tit">대림문화재단 2017년 상반기 채용 공고</a>
									<span class="date">2017.03.10</span>
								</li>
								<li>
									<a href="javascript:goNotice('1147');" class="tit">3/16(목) - 3/26(일) 야간 개관 안내 </a>
									<span class="date">2017.03.10</span>
								</li>
							</ul>
							<a href="/support/noticeList.do" class="btn_text more02">more</a>
							
							<!-- EVENT -->
							<div class="fun_event">
								<div class="title03"><h3>EVENT</h3></div>
								<ul>
									<li>
										<a href="javascript:goEvnt('721');" class="tit">닉 나이트 사진전 종료 D-10, 야간개관 이벤트!</a>
										<span class="date">2017.03.16 - 2017.03.26</span>
									</li>
								</ul>
								<a href="/support/eventList.do" class="btn_text more02">more</a>
							</div>
							<!-- //EVENT -->
						</div>
						<!-- //NOTICE -->
						
						<!-- 캘린더 -->
						<div class="fun_calendar">
							<div class="ui_main_picker none" data-enable-date="20170220,20170221,20170222,20170223,20170224,20170225,20170226,20170227,20170228,20170301,20170302,20170303,20170304,20170305,20170306,20170307,20170308,20170309,20170310,20170311,20170312,20170313,20170314,20170315,20170316,20170317,20170318,20170319,20170320,20170321,20170322,20170323,20170324,20170325,20170326,20170327,20170328,20170329,20170330,20170331"><!-- data-enable-date: 이벤트가 있는 날짜: yyyyMMdd -->
								<div class="title03"><h3>이달의 행사</h3></div>
								<div class="datepicker_state">
									<div class="state_today ui_picker_today"><!-- 2015.06.14 수 --></div>
									<div class="state_event ui_relative_banner">
										<nav class="indicator ui_indicator none">
											<!--a href="#funEvent01" class="active">첫번째 행사/이벤트 상세보기</a> <!-- 활성화시 .active 추가 -->
											<!--a href="#funEvent02">두번째 행사/이벤트 상세보기</a>
											<a href="#funEvent03">세번째 행사/이벤트 상세보기</a-->
										</nav>
										<!-- 이전/다음 버튼: 이벤트 없을 경우 숨김 -->
										<div class="set_btn">
											<button type="button" class="btn_img prev_sm ui_prev none">이전 내용 보기</button>	<!-- ui_prev -->
											<button type="button" class="btn_img next_sm ui_next none">다음 내용 보기</button>	<!-- ui_next -->
										</div>
										<!-- //이전/다음 버튼: 이벤트 없을 경우 숨김 -->
									</div>
								</div>
								<div class="ui_main_datepicker"></div>
								<a href="javascript:goCalendar();" class="btn_text more02">more</a>
							</div>
						</div>
						<!-- //캘린더 -->
					</div>
					<!-- //FUN -->
				</div>
			</div>
		</section>
		<!-- contents -->
	</div>