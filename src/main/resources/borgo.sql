-- create database borgo;
-- use borgo;

-- drop table user;
CREATE TABLE user (
  id  BIGINT NOT NULL AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  PRIMARY KEY (id));

-- drop table role;
CREATE TABLE role (
  id BIGINT NOT NULL AUTO_INCREMENT,
  rolename VARCHAR(100) NOT NULL,
  pretty_Rolename VARCHAR(100) NOT NULL,
  PRIMARY KEY (id));


INSERT INTO Role (rolename, pretty_Rolename) VALUES ('ROLE_ADMIN', 'Administrator');
INSERT INTO Role (rolename, pretty_Rolename) VALUES ('ROLE_EMPLOYEE', 'Employee');

-- password for admin is 123
INSERT INTO User (username, password) VALUES ('Admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');

select * from role;
select * from user;


-- = INSERT INTO User_Roles (users_id, roles_id) VALUES (1,1);
select user.id as user_id, username, role.id as roles_id, rolename
from user join Role on user.id  = role.id;

-- select *from user_roles;

create table user_roles
(
user_id bigint,
 FOREIGN KEY (user_id)
        REFERENCES user(id),
 roles_id bigint,
 FOREIGN KEY (roles_id)
        REFERENCES role(id)
);

INSERT INTO user_roles (user_id,roles_id) VALUES (1,1);

-- drop table user_roles;
-- delete role, user from user inner join role on user.id  = role.id where user.id=1;

