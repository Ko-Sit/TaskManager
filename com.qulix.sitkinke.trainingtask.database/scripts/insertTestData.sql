INSERT INTO PROJECTS
VALUES (1, 'PHPixie PHP Framework', 'PHPixie', 'PHPixie started as a micro framework and has gradually grown');

INSERT INTO EMPLOYEES VALUES (1, 'Buckland', 'Adam', 'Bernadette', 'Software Engineer', 'buck@gmail.com', 123, 'ADMINISTRATOR');
INSERT INTO EMPLOYEES VALUES (2, 'Anna', 'Cameron', 'Bower', 'Test Software Programmer', 'Buckland@gmail.com', 22, 'USER');
INSERT INTO EMPLOYEES
VALUES (3, 'Elizabeth', 'Christopher', 'Carr', 'Entry Level Programmer', 'Christopher@yandex.ru', 443, 'USER');
INSERT INTO EMPLOYEES VALUES (4, 'Lawrence', 'MacDonald', 'Johnston', 'Java Developer', 'MacDonald@mail.ru', 543, 'USER');
INSERT INTO EMPLOYEES VALUES (5, 'Rebecca', 'Manning', 'Kerr', 'Web Programmer', 'Manning@gmail.com', 32, 'USER');

INSERT INTO TASKS VALUES (1, 'Development Phase', 260, '1970-01-01', '1970-01-01', 'INPROGRESS', 'PHPixie');
INSERT INTO TASKS VALUES (2, 'Deploy application', 100, '1970-01-01', '1970-01-01', 'NOTSTARTED', 'PHPixie');
INSERT INTO TASKS VALUES (3, 'Gather Requirements', 50, '1970-01-01', '1970-01-01', 'COMPLETED', 'PHPixie');

INSERT INTO REFLIST_PROJ VALUES (1, 1, 1);
INSERT INTO REFLIST_PROJ VALUES (2, 1, 2);
INSERT INTO REFLIST_PROJ VALUES (3, 1, 3);

INSERT INTO REFLIST_EMPL VALUES (1, 1, 1);
INSERT INTO REFLIST_EMPL VALUES (2, 3, 1);
INSERT INTO REFLIST_EMPL VALUES (3, 4, 2);
INSERT INTO REFLIST_EMPL VALUES (4, 5, 2);
INSERT INTO REFLIST_EMPL VALUES (5, 3, 3);
