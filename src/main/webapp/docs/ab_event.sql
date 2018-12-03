create table ab_member(
	mem_id varchar2(30) not null primary key,
	mem_name varchar2(30) not null,
	mem_pwd varchar2(30) not null,
	mem_phone1 varchar2(3) not null,
	mem_phone2 varchar2(4) not null,
	mem_phone3 varchar2(4) not null,
	mem_sex varchar2(6) not null,
	mem_email1 varchar2(40) not null,
	mem_email2 varchar2(30) not null,
	mem_regdate date not null,
	mem_level varchar2(4) default 1 not null 
);
create table ab_notice(
 no_num number not null primary key,
 no_title varchar2(150) not null,
 no_content clob not null,
 no_regdate date not null,
 uploadfile blob,
 filename varchar2(200),
 mem_id varchar2(12) not null,
 constraint notice_ab_member_fk1 foreign key (mem_id) references ab_member (mem_id)
);

create table noticereply(
 re_no number primary key,
 re_content varchar2(900) not null,
 re_date date not null,
 no_num number not null,
 mem_id varchar2(12) not null,
 constraint noticereply_ab_notice_fk1 foreign key (no_num) references ab_notice (no_num),
 constraint noticereply_ab_member_fk2 foreign key (mem_id) references ab_member (mem_id)
);

create sequence reply_no_num;


--시퀀스
create sequence event_board_seq;

--테이블 전체삭제
drop table ab_notice cascade constraints;


create table ab_event(
 ev_num number not null primary key,
 ev_title varchar2(150) not null,
 ev_content clob not null,
 ev_regdate date not null,
 uploadfile blob,
 filename varchar2(200),
 mem_id varchar2(12) not null,
 constraint event_ab_member_fk1 foreign key (mem_id) references ab_member (mem_id)
);

