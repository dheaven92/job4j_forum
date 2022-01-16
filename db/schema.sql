create table posts (
    id          serial primary key,
    name        text,
    description text,
    created     timestamp without time zone not null default now(),
    updated     timestamp without time zone not null default now()
);

insert into posts (name, description)
values ('О чем этот форум?', 'По своей сути рыбатекст является альтернативой традиционному lorem ipsum, который ' ||
                             'вызывает у некторых людей недоумение при попытках прочитать рыбу текст.');
insert into posts (name, description)
values ('Правила форума', 'По своей сути рыбатекст является альтернативой традиционному lorem ipsum, который ' ||
                             'вызывает у некторых людей недоумение при попытках прочитать рыбу текст.');

create table authorities (
    id serial primary key,
    authority varchar(50) not null unique
);

create table users (
    id serial primary key,
    username varchar(50) not null unique,
    password varchar(100) not null,
    enabled boolean default true,
    authority_id int not null references authorities(id)
);

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');