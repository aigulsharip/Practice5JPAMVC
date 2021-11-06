CREATE TABLE PRODUCT (
    ID INT NOT NULL AUTO_INCREMENT
    , PRODUCT_NAME VARCHAR(60) NOT NULL
    , PRODUCT_PRICE INT NOT NULL
    , PRODUCT_QUANTITY INT NOT NULL
    , PRIMARY KEY (ID)
);

CREATE TABLE CLIENT (
    ID INT NOT NULL AUTO_INCREMENT
    , CLIENT_NAME VARCHAR(100) NOT NULL
    , PRODUCT_ID INT NOT NULL
    , CLIENT_EMAIL VARCHAR (100) NOT NULL
    , PRIMARY KEY (ID)
    , CONSTRAINT FK_CLIENT_PRODUCT FOREIGN KEY (PRODUCT_ID)
        REFERENCES PRODUCT (ID)
);

