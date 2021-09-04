create table person
(
    id         bigint not null auto_increment,
    name       varchar(255),
    therapy_id bigint,
    primary key (id)
) engine = InnoDB;
create table therapy
(
    id        bigint not null auto_increment,
    date_time datetime(6),
    place     varchar(255),
    terapeuta varchar(255),
    primary key (id)
) engine = InnoDB;
alter table person
    add constraint FKac6sqysibe0iuevfawbrauwdf foreign key (therapy_id) references therapy (id);