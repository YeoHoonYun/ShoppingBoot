insert into users (user_id, name, address, email, nickname, passwd, reg_date)
 values(1, "admin", "경기도 안산시", "admin@naver.com","Admin", "1234", now());
 insert into users (user_id, name, address, email, nickname, passwd, reg_date)
 values(2, "윤여훈", "경기도 안산시", "cjswo9207@naver.com","Yun", "1234", now());

insert into categorys(category_id, name) values (1, "생활용품");
insert into categorys(category_id, name) values (2, "전자제품");

insert into roles (role_id, name) values (1, 'USER');
insert into roles (role_id, name) values (2, 'ADMIN');

insert into roles_users(user_id, role_id) values( 1, 1);
insert into roles_users(user_id, role_id) values( 2, 2);

insert into companys(company_id, email, name) values(1, "Company@gmail.com","YunCompany");
insert into companys(company_id, email, name) values(2, "Computer@gmail.com","YunComputer");

insert into products(product_id, file_path, name, price, quanity, company_id, category_id) values(1, "key.jpg","Key",1000,5,1,1);
insert into products(product_id, file_path, name, price, quanity, company_id, category_id) values(2, "stay.jpg","Stay",2000,5,1,1);
insert into products(product_id, file_path, name, price, quanity, company_id, category_id) values(3, "zi.jpg","Zi",3000,5,1,1);
insert into products(product_id, file_path, name, price, quanity, company_id, category_id) values(4, "mouse.jpg","Mouse",15000,5,2,2);
insert into products(product_id, file_path, name, price, quanity, company_id, category_id) values(5, "keyboard.jpg","Keyboard",35000,5,2,2);
insert into products(product_id, file_path, name, price, quanity, company_id, category_id) values(6, "moniter.jpg","Moniter",30000,5,2,2);

insert into buckets(bucket_id, quantity, product_id, user_id) values(1, 3,1,2);
insert into buckets(bucket_id, quantity, product_id, user_id) values(2, 3,2,1);

insert into orders(order_id, address, quantity, state, product_id, user_id, reg_date) values (1, "경기도 안양시", 2, "배송중", 1, 1, now());
insert into orders(order_id, address, quantity, state, product_id, user_id, reg_date) values (2, "경기도 안산시", 2, "결제중", 2, 2, now());

insert into reviews(review_id, content, reg_date, title, product_id, user_id) values (1, "내용1", now(), "제목1", 1, 1);
insert into reviews(review_id, content, reg_date, title, product_id, user_id) values (2, "내용2", now(), "제목2", 2, 2);
insert into reviews(review_id, content, reg_date, title, product_id, user_id) values (3, "내용3", now(), "제목3", 2, 1);
insert into reviews(review_id, content, reg_date, title, product_id, user_id) values (4, "내용4", now(), "제목4", 3, 2);
insert into reviews(review_id, content, reg_date, title, product_id, user_id) values (5, "추가내용1", now(), "제목5", 1, 1);
insert into reviews(review_id, content, reg_date, title, product_id, user_id) values (6, "추가내용2", now(), "제목6", 1, 2);

insert into contacts(contact_id, content, reg_date, company_id) values (1, "contact1", now(), 1);
insert into contacts(contact_id, content, reg_date, company_id) values (2, "contact2", now(), 1);
insert into contacts(contact_id, content, reg_date, company_id) values (3, "contact3", now(), 2);
insert into contacts(contact_id, content, reg_date, company_id) values (4, "contact4", now(), 2);

