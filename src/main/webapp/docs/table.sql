create table smember(
	id varchar2(12) not null primary key,
	passwd varchar2(12) not null,
	name varchar2(30) not null,
	email varchar2(30) not null,
	reg_date date not null
);

create table sboard(
	seq number not null primary key,
	title varchar2(150) not null,
	content clob not null,
	hit number(5) default 0 not null,
	regdate date not null,
	uploadfile blob,
	filename varchar2(200),
	id varchar2(12) not null,
	constraint sboard_smember_fk1 foreign key (id) references smember (id)
);

create sequence board_seq;

create table sreply(
	re_no number primary key,
	re_content varchar2(900) not null,
	re_date date not null,
	seq number not null,
	id varchar2(12) not null,
	constraint sreply_sboard_fk1 foreign key (seq) references sboard (seq),
	constraint sreply_smember_fk2 foreign key (id) references smember (id)
);

create sequence reply_seq;