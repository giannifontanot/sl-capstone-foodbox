drop table if exists orden;
drop table if exists user;
drop table if exists box;
drop table if exists food;

create table food
(
    id          integer not null auto_increment,
    cuisine     varchar(255),
    description varchar(255),
    food_name   varchar(255),
    image_url   varchar(255),
    is_enabled  varchar(255),
    price       bigint,
    primary key (id)
);


create table user
(
    id       bigint not null auto_increment,
    contact  varchar(255),
    email    varchar(255),
    password varchar(255),
    username varchar(255),
    profile varchar(255),
    credit varchar(255),
    primary key (id)
);


create table box
(
    id      bigint not null,
    food_id integer,
    primary key (id, food_id)
);



create table orden
(
    id      bigint not null auto_increment,
    box_id  bigint not null,
    user_id bigint not null,
    status  varchar(255),
    primary key (id)
);
--
--
-- alter table box
--     add constraint UK_rb6npe7305gao860lxnuj2g7t unique (box_id);
--
--
-- alter table box
--     add constraint FKry8rla6994n8hd9579ia6a7k8
--         foreign key (food_id)
--             references food (id);
--
-- alter table orden
--     add constraint UK_rb6npe7305gao860lxnuj2g7t unique (box_id);
--
-- alter table orden
--     add constraint FKev4ou7yydtyartj534k0v82gx
--         foreign key (box_id)
--             references box (id);
--
--
-- alter table orden
--     add constraint FKdkqdxtdujrqslotkp947lgvqy
--         foreign key (client_id)
--             references client (id);