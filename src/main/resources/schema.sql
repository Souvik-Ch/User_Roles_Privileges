DROP TABLE user_account IF EXISTS;
CREATE TABLE user_account (
                              userid INT NOT NULL,
                              username VARCHAR(50) NOT NULL,
                              password VARCHAR(50) NOT NULL,
                              active INT NOT NULL,
                              PRIMARY KEY (userid)
);

DROP TABLE user_role IF EXISTS;
CREATE TABLE user_role (
                           id INT NOT NULL,
                           role_name VARCHAR(50) NOT NULL,
                           PRIMARY KEY (id)
);

DROP TABLE user_to_role IF EXISTS;
CREATE TABLE user_to_role (
                              id INT NOT NULL,
                              userid INT NOT NULL,
                              role_id INT NOT NULL,
                              PRIMARY KEY (id)
);

DROP TABLE user_privilege IF EXISTS;
CREATE TABLE user_privilege (
                                id INT NOT NULL,
                                privilege_name VARCHAR(50) NOT NULL,
                                PRIMARY KEY (id)
);

DROP TABLE user_role_to_privilege IF EXISTS;
CREATE TABLE user_role_to_privilege (
                                        id INT NOT NULL,
                                        role_id INT NOT NULL,
                                        privilege_id INT NOT NULL,
                                        PRIMARY KEY (id)
);