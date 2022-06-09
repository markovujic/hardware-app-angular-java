delete from hardware;
delete from review;
delete from users;
delete from authority;
delete from users_authority;

insert into hardware (ID, NAME, CODE, PRICE, TYPE, STOCK)
values (1, 'Asus TUF RTX 3080','7731', 1539.99, 'GPU', 14);

insert into hardware (ID, NAME, CODE, PRICE, TYPE, STOCK)
values (2, 'AMD Ryzen 5 3500U','8832', 509.99, 'CPU', 12);

insert into hardware (ID, NAME, CODE, PRICE, TYPE, STOCK)
values (3, 'Corsair Dominator Platinum RGB', '9933', 11499.99, 'CPU', 9);

insert into review (ID, TITLE, TEXT, RATING, HARDWARE_ID)
values (1, 'Najbolja grafička na tržištu', 'Jako dobro za korištenje', 5, 1);

insert into review (ID, TITLE, TEXT, RATING, HARDWARE_ID)
values (2, 'Bad equipment', 'It is not very good to use.', 3, 2);

insert into review (ID, TITLE, TEXT, RATING, HARDWARE_ID)
values (3, 'Radi prihvatljivo', 'Radi prihvatljivo', 3, 1);

insert into users(id, username, password)
values
    (1, 'user', '$2a$10$M5VyNa8Y2O5X.Zp3ivt56u3VAhdrqJ9YxGXaPnohCQvRcAGTeGLA6'), -- password = user
    (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin
insert into authority (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');
insert into users_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1);




