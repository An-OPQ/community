create table userinfo
(
    userid      int(10) auto_increment
        primary key,
    accountName varchar(255) not null,
    email       varchar(255) not null,
    password    varchar(255) not null,
    mobile      varchar(255) null,
    icon        varchar(255) null,
    constraint email
        unique (email)
);