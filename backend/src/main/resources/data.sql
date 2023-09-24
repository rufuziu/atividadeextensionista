INSERT INTO users(full_name,email,username,password,enabled)
VALUES('iury',
'test@test.com',
'test',
'$2a$12$uGtD8HWhNPLa9AA0yUwrx.FCnwMNo5hH8VMuGQr3CGEY2QndrEoL6',
false);

INSERT INTO roles(user_role)
VALUES(0);

INSERT INTO users_roles(role_id, user_id)
VALUES(1,1);