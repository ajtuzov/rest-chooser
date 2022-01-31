INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES ('user@gmail.com', 'User_First', 'User_Last', '{noop}password'),
       ('admin@javaops.ru', 'Admin_First', 'Admin_Last', '{noop}admin');

INSERT INTO USER_ROLE (USER_ID, ROLE)
VALUES (1, 'USER'),
       (2, 'ADMIN'),
       (2, 'USER');

INSERT INTO RESTAURANT (ID, NAME, ADDRESS)
VALUES (1, 'Los Pollos Hermanos', 'Albuquerque'),
       (2, 'Bronto Burgers & Ribs Drive-In', 'Bedrock');

INSERT INTO MEAL (DISH, PRICE, RESTAURANT_ID)
VALUES ('Tacos', 14, 1),
       ('Chicken', 30, 1),
       ('Dino Steak', 40, 2),
       ('Bronto fries', 15, 2);
