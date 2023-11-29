-- Inserting products
INSERT INTO PRODUCT (id, name, category, price, purchasePrice) VALUES (1, 'Alexa' , null, 153, 120);
INSERT INTO PRODUCT (id, name, category, price, purchasePrice) VALUES (2, 'Iwatch' , null, 300, 200);
INSERT INTO PRODUCT (id, name, category, price, purchasePrice) VALUES (3, 'Arduino' , null, 50, 40);

-- Inserting users
INSERT INTO USER_DATA (id, username, password) VALUES (1, 'Safia' , 'Crea2023');
INSERT INTO USER_DATA (id, username, password) VALUES (2, 'Damien' , 'Crea2023');
INSERT INTO USER_DATA (id, username, password) VALUES (3, 'Synda' , 'Crea2023');

-- Inserting user favorites
INSERT INTO USER_PRODUCT_FAVORITE (user_id, product_id) VALUES (1, 1); -- Safia -> Alexa
INSERT INTO USER_PRODUCT_FAVORITE (user_id, product_id) VALUES (1, 2); -- Safia -> Iwatch
INSERT INTO USER_PRODUCT_FAVORITE (user_id, product_id) VALUES (2, 2); -- Damien -> Iwatch
INSERT INTO USER_PRODUCT_FAVORITE (user_id, product_id) VALUES (3, 3); -- Synda -> Arduino
