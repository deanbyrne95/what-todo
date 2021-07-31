INSERT INTO TDTD_USERS (USER_USERNAME,
                        USER_NAME,
                        USER_SURNAME,
                        USER_EMAIL,
                        USER_DOB)
VALUES ('Admin123', 'Admin', 'Admin', 'admin@admin.com', PARSEDATETIME('01/01/1979', 'dd/MM/yyyy'));

INSERT INTO TDTD_TODO (USER_USER_ID,
                       TODO_TASK)
VALUES ((SELECT user_id FROM tdtd_users WHERE user_username = 'Admin123'), 'Sample Task');