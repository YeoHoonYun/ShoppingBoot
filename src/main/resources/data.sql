insert into role (idrole, name) values (1, 'USER');
insert into role (idrole, name) values (2, 'ADMIN');

-- insert into user (iduser, name, address, email, nickname, passwd)
--  values(1, "admin", "경기도 안산시", "admin@naver.com","Admin", "1234");
--  insert into user (iduser, name, address, email, nickname, passwd)
--  values(2, "윤여훈", "경기도 안산시", "cjswo9207@naver.com","Yun", "1234");

insert into role_user(user_iduser, role_idrole) values( 1, 1);
insert into role_user(user_iduser, role_idrole) values( 2, 2);