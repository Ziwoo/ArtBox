
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
create sequence notice_board_seq;

--테이블 전체삭제
drop table ab_notice cascade constraints;


