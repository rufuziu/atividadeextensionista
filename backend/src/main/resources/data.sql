INSERT INTO users(full_name,email,username,password,enabled)
VALUES('iury',
'test@test.com',
'test',
'$2a$10$j/dF6tCQUKYgom.AUfd7IOPHBA25Dj3jWj1uvCz9t8kPb4yePmgcC',
--password bencrypted = test
false);

INSERT INTO roles(user_role)
VALUES(0);
INSERT INTO roles(user_role)
VALUES(1);
INSERT INTO roles(user_role)
VALUES(2);

INSERT INTO users_roles(role_id, user_id)
VALUES(1,1);