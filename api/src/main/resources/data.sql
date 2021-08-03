INSERT INTO TDTD_USERS (USER_USERNAME,
                        USER_NAME,
                        USER_SURNAME,
                        USER_EMAIL,
                        USER_DOB)
VALUES ('Admin123', 'Admin', 'Admin', 'admin@admin.com', PARSEDATETIME('01/01/1979', 'dd/MM/yyyy'));

INSERT INTO TDTD_TODO (USER_ID, TODO_TASK, TODO_IS_COMPLETED)
VALUES ((SELECT user_id FROM tdtd_users WHERE user_username = 'Admin123'), 'Sample Task 1', TRUE),
       ((SELECT user_id FROM tdtd_users WHERE user_username = 'Admin123'), 'Sample Task 2', FALSE),
       ((SELECT user_id FROM tdtd_users WHERE user_username = 'Admin123'), 'Sample Task 3', FALSE),
       ((SELECT user_id FROM tdtd_users WHERE user_username = 'Admin123'), 'Sample Task 4', TRUE),
       ((SELECT user_id FROM tdtd_users WHERE user_username = 'Admin123'), 'Sample Task 5', FALSE)

;