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