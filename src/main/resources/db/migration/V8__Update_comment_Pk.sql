alter table comment drop foreign key comment_ibfk_2;

alter table comment
	add constraint comment_ibfk_2
		foreign key (questionId) references question (id)
			on update cascade on delete cascade;