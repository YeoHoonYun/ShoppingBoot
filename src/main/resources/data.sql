-- insert into user (iduser, name, address, email, nickname, passwd)
--  values(1, "admin", "경기도 안산시", "admin@naver.com","Admin", "1234");
--  insert into user (iduser, name, address, email, nickname, passwd)
--  values(2, "윤여훈", "경기도 안산시", "cjswo9207@naver.com","Yun", "1234");

insert into role (idrole, name) values (1, 'USER');
insert into role (idrole, name) values (2, 'ADMIN');

insert into role_user(user_iduser, role_idrole) values( 1, 1);
insert into role_user(user_iduser, role_idrole) values( 2, 2);

insert into company(idcompany, email, name) values(1, "Company@gmail.com","Company");

insert into product(idproduct, file_path, name, price, quanity, idcompany) values(1, "key.jpg","Key",1000,5,1);
insert into product(idproduct, file_path, name, price, quanity, idcompany) values(2, "stay.jpg","Stay",2000,5,1);
insert into product(idproduct, file_path, name, price, quanity, idcompany) values(3, "zi.jpg","Zi",3000,5,1);


