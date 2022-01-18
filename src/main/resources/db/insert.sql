insert into posts (name, description)
values ('О чем этот форум?', 'По своей сути рыбатекст является альтернативой традиционному lorem ipsum, который ' ||
                             'вызывает у некторых людей недоумение при попытках прочитать рыбу текст.');
insert into posts (name, description)
values ('Правила форума', 'По своей сути рыбатекст является альтернативой традиционному lorem ipsum, который ' ||
                          'вызывает у некторых людей недоумение при попытках прочитать рыбу текст.');

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');