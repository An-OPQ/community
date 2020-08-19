create table question
(
	id bigint auto_increment
		primary key,
	title varchar(50) null,
	description text null,
	creatorid bigint not null,
	comment_count int default 0 null,
	view_count int default 0 null,
	like_count int default 0 null,
	tag varchar(256) null,
	constraint question_userinfo_id_fk
		foreign key (creatorid) references userinfo (id)
);

