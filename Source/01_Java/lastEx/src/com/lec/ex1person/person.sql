-- 테이블 및 시퀀스 삭제
DROP TABLE PERSON;
DROP TABLE JOB;
DROP SEQUENCE pNO_SEQ;
-- 테이블 및 시퀀스 생성
CREATE TABLE JOB(
    jNO NUMBER(2) PRIMARY KEY,
    jNAME VARCHAR2(50)
);
CREATE TABLE PERSON(
    pNO NUMBER(5) PRIMARY KEY,
    pNAME VARCHAR2(50) NOT NULL,
    jNO NUMBER(2) NOT NULL,
    KOR NUMBER(3) CHECK(KOR>=0),
    ENG NUMBER(3) CHECK(ENG>=0),
    MAT NUMBER(3) CHECK(MAT>=0)
);
CREATE SEQUENCE PERSON_NO_SQ
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
-- 더미데이터 insert (정우성 ~ 송혜교)
INSERT INTO JOB VALUES(10, '배우');
INSERT INTO JOB VALUES(20, '가수');
INSERT INTO JOB VALUES(30, '엠씨');

INSERT INTO PERSON VALUES(TO_CHAR(PERSON_NO_SQ.NEXTVAL), '정우성', 10, 90, 80, 81 );
INSERT INTO PERSON VALUES(TO_CHAR(PERSON_NO_SQ.NEXTVAL), '박세영', 10, 80, 90, 80 );
INSERT INTO PERSON VALUES(TO_CHAR(PERSON_NO_SQ.NEXTVAL), '배수지', 20, 20, 90, 90 );
INSERT INTO PERSON VALUES(TO_CHAR(PERSON_NO_SQ.NEXTVAL), '설수현', 20, 95, 95, 95 );
INSERT INTO PERSON VALUES(TO_CHAR(PERSON_NO_SQ.NEXTVAL), '송혜교', 10, 100, 100, 100 );
-- 기능별 query 작성 (1, 2, 3)
-- 그냥 SELECT
SELECT pNO, pNAME, P.jNO, KOR, ENG, MAT
    FROM PERSON P, JOB J
    WHERE P.jNO=J.jNO;
SELECT JNAME FROM JOB;
-- 1
INSERT INTO PERSON VALUES(TO_CHAR(PERSON_NO_SQ.NEXTVAL), '이상해씨', (SELECT JNO FROM JOB WHERE JNAME='가수'), 90, 80, 81 );
-- 2  
SELECT pNAME, SUM(KOR+ENG+MAT)"총점" FROM PERSON GROUP BY pNAME ORDER BY "총점" DESC;

SELECT *
    FROM (SELECT ROWNUM || '등' "등수", P.PNAME ||'(' || PNO || '번)' "이름(pNO)", JNAME "직업", KOR "국어(kor)", ENG"영어(eng)", MAT"수학(mat)", "총점"
        FROM PERSON P, JOB J, (SELECT pNAME, SUM(KOR+ENG+MAT) "총점" FROM PERSON GROUP BY pNAME ORDER BY "총점" DESC)A WHERE P.PNAME=A.PNAME 
            AND P.JNO=J.JNO
            AND P.jNO=(SELECT jNO FROM JOB WHERE JNAME='가수'));


    
-- 3
SELECT *
    FROM (SELECT ROWNUM || '등' "등수", P.PNAME ||'(' || PNO || '번)' "이름(pNO)", JNAME "직업", KOR "국어(kor)", ENG"영어(eng)", MAT"수학(mat)", "총점"
        FROM PERSON P, JOB J, (SELECT pNAME, SUM(KOR+ENG+MAT) "총점" FROM PERSON GROUP BY pNAME ORDER BY "총점" DESC)A WHERE P.PNAME=A.PNAME 
            AND P.JNO=J.JNO);
COMMIT;
    
