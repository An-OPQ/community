create table userinfo
(
	id bigint auto_increment
		primary key,
	email varchar(50) not null,
	accountName varchar(50) not null,
	sex varchar(5) null,
	icon varchar(255) null,
	sginName varchar(25) null,
	QQ varchar(15) null,
	WeChat varchar(20) null,
	mobile varchar(15) null,
	github varchar(50) null,
	microblog varchar(50) null,
	constraint user_accountName_uindex
		unique (accountName),
	constraint user_email_uindex
		unique (email)
);

