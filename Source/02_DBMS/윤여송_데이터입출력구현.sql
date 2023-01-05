DROP TABLE ORDERDETAIL;
DROP TABLE ORDERS;
DROP TABLE CART;
DROP TABLE PRODUCT;
DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    mID VARCHAR2(50) PRIMARY KEY,
    mNAME VARCHAR2(20) NOT NULL,
    mADDR VARCHAR2(300),
    mTEL VARCHAR2(30),
    mMAIL VARCHAR2(40)
);

INSERT INTO MEMBER VALUES('abc','홍길동','서울 서대문구','010-9999-9999','hong@hong.com');
INSERT INTO MEMBER VALUES('def','김김동','경기도 수원시','010-8888-8888','kim@kim.com');

CREATE TABLE PRODUCT(
    pCODE VARCHAR2(50) PRIMARY KEY,
    pNAME VARCHAR2(200)NOT NULL,
    PRICE NUMBER(10) NOT NULL CHECK(PRICE>0),
    STOCK NUMBER(4) NOT NULL CHECK(STOCK>=0)
);

INSERT INTO PRODUCT VALUES('A1', '맥주', 3000, 100);
INSERT INTO PRODUCT VALUES('B1', '땅콩', 3000, 200);
INSERT INTO PRODUCT VALUES('A2', '마스크', 200, 9000);
INSERT INTO PRODUCT VALUES('B2', '오징어', 5000, 400);
INSERT INTO PRODUCT VALUES('C1', '소독약', 7000, 50);

DROP SEQUENCE CARTNO;
CREATE SEQUENCE CARTNO
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 999
    MINVALUE 1
    NOCACHE;

DROP SEQUENCE CARTNO; 
CREATE SEQUENCE CARTNO MAXVALUE 999999999 NOCACHE;
CREATE TABLE CART(
    cNO NUMBER(3) PRIMARY KEY,
    mID VARCHAR2(50) REFERENCES MEMBER(mID) NOT NULL,
    pCODE1 VARCHAR2(50) NOT NULL UNIQUE,
    QTY1 NUMBER(3) NOT NULL,
    COST1 NUMBER(11) NOT NULL
);

DROP SEQUENCE ORDERNO;
CREATE SEQUENCE ORDERNO
    START WITH 001
    INCREMENT BY 1
    MAXVALUE 999
    MINVALUE 1
    NOCACHE;
    
CREATE TABLE ORDERS(
    oNO VARCHAR2(50) PRIMARY KEY,
    oNAME VARCHAR2(20) NOT NULL,
    oADDR VARCHAR2(300) NOT NULL,
    oTEL VARCHAR2(30) NOT NULL,
    oDATE DATE DEFAULT SYSDATE,
    mID VARCHAR2(50) REFERENCES MEMBER(mID) NOT NULL
);

INSERT INTO ORDERS VALUES(TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERNO.NEXTVAL, '000')), '홍길동', '서울시 서대문구 대현동', '010-9999-9999', DEFAULT, 'abc');
-- INSERT INTO ORDERS VALUES(TO_CHAR(oDATE, 'YYYYMMDD')||ORDERNO.NEXTVAL, '김김동', '경기도 수원시', '010-8888-8888', '2023년 01월 10일', 'def');
-- INSERT INTO ORDERS VALUES(TO_CHAR(oDATE, 'YYYYMMDD')||ORDERNO.NEXTVAL, '홍아빠', '제주도 제주시', '010-7777-9999', '2023년 01월 12일', 'abc');
CREATE TABLE ORDERDETAIL(
    oNO VARCHAR2(50) REFERENCES ORDERS(oNO) NOT NULL,
    pCODE VARCHAR2(50) REFERENCES PRODUCT(pCODE) NOT NULL,
    QTY NUMBER(3) NOT NULL,
    COST NUMBER(11) NOT NULL
);

INSERT INTO ORDERDETAIL VALUES((SELECT oNO FROM ORDERS WHERE mID='abc'), 'A1', 3, 3*(SELECT PRICE FROM PRODUCT WHERE pCODE='A1'));
INSERT INTO ORDERDETAIL VALUES((SELECT oNO FROM ORDERS WHERE mID='abc'), 'B1', 1, 1*(SELECT PRICE FROM PRODUCT WHERE pCODE='B1'));

SELECT O.ONO "주문번호",MID "고객번호", ONAME "배송받을 분", OADDR "배송 주소", OTEL "배송지 전화", ODATE "주문일",P.PCODE "상품코드", PNAME "상품명", PRICE "단가", QTY "수량", COST "금액", STOCK-QTY "재고" 
    FROM PRODUCT P, ORDERDETAIL OD, ORDERS O
    WHERE P.PCODE=OD.PCODE 
        AND O.ONO=OD.ONO;

