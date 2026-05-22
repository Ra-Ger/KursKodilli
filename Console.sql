set global log_bin_trust_function_creators=1;

show DATABASES;
use kodilla_course;

CREATE TABLE BOOKS (

                       BOOK_ID int(11) NOT NULL AUTO_INCREMENT,
                       TITLE varchar(255) NOT NULL,
                       PUBYEAR int(4) NOT NULL,
                       PRIMARY KEY (BOOK_ID)
);

CREATE TABLE READERS (
                         READER_ID int(11) NOT NULL AUTO_INCREMENT,
                         FIRSTNAME varchar(255) NOT NULL,
                         LASTNAME varchar(255) NOT NULL,
                         PESELID varchar(11) NOT NULL,
                         PRIMARY KEY (READER_ID)
);

CREATE TABLE RENTS (
                       RENT_ID int(11) NOT NULL AUTO_INCREMENT,
                       BOOK_ID int(11) NOT NULL,
                       READER_ID int(11) NOT NULL,
                       RENT_DATE datetime NOT NULL,
                       RETURN_DATE datetime,
                       PRIMARY KEY (RENT_ID),
                       FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID),
                       FOREIGN KEY (READER_ID) REFERENCES READERS(READER_ID)
);

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ("John", "Smith", "83012217938");

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ("Curtis", "Wilson", "75121002790");

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ("Cathy", "Booker", "90112801727");

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ("Marissa", "Cain", "84061908044");

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ("Muriel", "Fulton", "76081409269");

COMMIT;

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ("The Stranger", 1942);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ("In Search of Lost Time", 1927);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ("The Trial", 1925);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ("The Little Prince", 1943);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ("Man's Fate", 1933);

COMMIT;

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (2, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (4, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 5 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 3, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 3, DATE_SUB(CURDATE(), INTERVAL 4 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 4, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 8 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 5, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

COMMIT;

DELIMITER $$

CREATE PROCEDURE ListBooks()
BEGIN
    SELECT * FROM BOOKS;
END $$

DELIMITER ;

DROP PROCEDURE IF EXISTS ListBooks;

DELIMITER $$

CREATE PROCEDURE ListBooks()
BEGIN
    SELECT BOOK_ID, TITLE, PUBYEAR FROM BOOKS;
END $$

DELIMITER ;

CALL ListBooks();

DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel() RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    RETURN 'Standard customer';
END $$

DELIMITER ;

SELECT VipLevel() AS LEVEL;


DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel(booksrented INT) RETURNS VARCHAR(20) DETERMINISTIC -- [1]
BEGIN									                                    -- [2]
    DECLARE result VARCHAR(20) DEFAULT 'Standard customer';	                -- [3]
    IF booksrented >= 10 THEN						                        -- [4]
        SET result = 'Gold customer';					                        -- [5]
    ELSEIF booksrented >= 5 AND booksrented < 10 THEN			            -- [6]
        SET result = 'Silver customer';				                        -- [7]
    ELSEIF booksrented >= 2 AND booksrented < 5 THEN			            -- [8]
        SET result = 'Bronze customer';		           		                -- [9]
    ELSE				      					                                -- [10]
        SET result = 'Standard customer';				                        -- [11]
    END IF;				    				                                -- [12]
    RETURN result;
END $$

DELIMITER ;

SELECT VipLevel(12) AS LEVEL;


DROP FUNCTION IF EXISTS GetUserNameById;

DELIMITER $$

CREATE PROCEDURE GetUserNameById(IN user_id INT)
BEGIN
    IF user_id <= 0 THEN
        SELECT 'Bad ID' AS komunikat;
    ELSE
        SELECT FIRSTNAME
        FROM users
        WHERE id = user_id;
    END IF;
END $$

DELIMITER ;

CALL GetUserNameById(1);

CALL GetUserNameById(-3);


ALTER TABLE READERS ADD VIP_LEVEL VARCHAR(20);

DROP PROCEDURE IF EXISTS UpdateVipLevels;

DELIMITER $$

CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD INT;

    SELECT COUNT(*) FROM RENTS
    WHERE READER_ID = 3
    INTO BOOKSREAD;

    SELECT BOOKSREAD;
END $$

DELIMITER ;


DROP PROCEDURE IF EXISTS UpdateVipLevels;

DELIMITER $$

CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD INT;
    DECLARE DAYS INT;
    DECLARE BOOKSPERMONTH DECIMAL(5,2);

    SELECT COUNT(*) FROM RENTS
    WHERE READER_ID = 3
    INTO BOOKSREAD;

    SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS -- [1]
    WHERE READER_ID = 3	                                  -- [2]
    INTO DAYS;                                           -- [3]

    SET BOOKSPERMONTH = BOOKSREAD / DAYS * 30;                 -- [4]

    SELECT BOOKSREAD, DAYS, BOOKSPERMONTH;                     -- [5]
END $$

DELIMITER ;

CALL UpdateVipLevels();




DROP PROCEDURE IF EXISTS UpdateVipLevels;

DELIMITER $$

CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD, DAYS, RDR_ID INT;				 -- [1]
    DECLARE BOOKSPERMONTH DECIMAL(5,2);				 -- [2]
    DECLARE FINISHED INT DEFAULT 0;			   	     -- [3]
    DECLARE ALL_READERS CURSOR FOR SELECT READER_ID FROM READERS;        -- [4]
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;	            -- [5]
    OPEN ALL_READERS;			   		         	 -- [6]
    WHILE (FINISHED = 0) DO			   		         -- [7]
    FETCH ALL_READERS INTO RDR_ID;			   	 -- [8]
    IF (FINISHED = 0) THEN			   		     -- [9]
        SELECT COUNT(*) FROM RENTS			   	     -- [10]
        WHERE READER_ID = RDR_ID			     -- [11]
        INTO BOOKSREAD;			   		     -- [12]

        SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS -- [13]
        WHERE READER_ID = RDR_ID                           		    -- [14]
        INTO DAYS;                                       	    -- [15]

        SET BOOKSPERMONTH = BOOKSREAD / DAYS * 30;              	    -- [16]

        UPDATE READERS SET VIP_LEVEL = VipLevel(BOOKSPERMONTH)		    -- [17]
        WHERE READER_ID = RDR_ID;			   		                -- [18]
        COMMIT;			   				                            -- [19]
    END IF;			   					                            -- [20]
        END WHILE;			   					                            -- [21]

    CLOSE ALL_READERS;   			   			                        -- [22]
END $$

DELIMITER ;

CALL UpdateVipLevels();

SELECT * FROM READERS;


-- zadanie

ALTER TABLE BOOKS
    ADD COLUMN BESTSELLER BOOLEAN NOT NULL DEFAULT 0;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
    DECLARE DONE INT DEFAULT 0;
    DECLARE CURRENT_BOOK_ID INT;
    DECLARE TOTAL_RENTS INT;
    DECLARE RENT_DAYS INT;
    DECLARE BOOKS_PER_MONTH DECIMAL(5,2);

    DECLARE BOOKS_CURSOR CURSOR FOR SELECT BOOK_ID FROM BOOKS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = 1;

    UPDATE BOOKS SET BESTSELLER = 0 WHERE BOOK_ID > 0;
    COMMIT;

    OPEN BOOKS_CURSOR;

    READ_LOOP: LOOP
        FETCH BOOKS_CURSOR INTO CURRENT_BOOK_ID;

        IF DONE THEN
            LEAVE READ_LOOP;
        END IF;

        SELECT COUNT(*) INTO TOTAL_RENTS
        FROM RENTS
        WHERE BOOK_ID = CURRENT_BOOK_ID;

        IF TOTAL_RENTS = 0 THEN
            SET BOOKS_PER_MONTH = 0;
        ELSE
            SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1
            INTO RENT_DAYS
            FROM RENTS
            WHERE BOOK_ID = CURRENT_BOOK_ID;

            SET BOOKS_PER_MONTH = (TOTAL_RENTS / RENT_DAYS) * 30;
        END IF;

        UPDATE BOOKS
        SET BESTSELLER = IF(BOOKS_PER_MONTH > 2, TRUE, FALSE)
        WHERE BOOK_ID = CURRENT_BOOK_ID;

    END LOOP;

    CLOSE BOOKS_CURSOR;
    COMMIT;
END $$

DELIMITER ;

CALL UpdateBestsellers();

SELECT * FROM BOOKS;