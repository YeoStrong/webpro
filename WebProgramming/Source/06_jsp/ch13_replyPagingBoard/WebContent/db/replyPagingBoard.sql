-- BOARD TABLE DROP & CREATE
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM     NUMBER(5,0) PRIMARY KEY, -- 글번호
    WRITER  VARCHAR2(30) NOT NULL,   -- 글작성자
    SUBJECT VARCHAR2(100) NOT NULL,  -- 글제목
    CONTENT VARCHAR2(4000) NOT NULL, -- 본문
    EMAIL   VARCHAR2(30),            -- 작성자 이메일
    READCOUNT NUMBER(5) DEFAULT 0,   -- 글 HIT수 (조회수)
    PW      VARCHAR2(30) NOT NULL,   -- 글 삭제시 쓸 비밀번호
    REF     NUMBER(5,0) NOT NULL,    -- 글그룹(원글의 경우 글번호 / 답글일 경우 원글의 REF)
    RE_STEP NUMBER(3) NOT NULL,      -- 글그룹내 출력 순서(원글 0)
    RE_INDENT NUMBER(3) NOT NULL,    -- 글 LIST 출력시 글 제목 들여쓰기 정도(원글:0)
    IP      VARCHAR2(30) NOT NULL,   -- 글 작성시 컴퓨터 IP 주소
    RDATE   DATE DEFAULT SYSDATE     -- 글 쓴 시점(날짜+시간)
);
-- 1. 글 갯수
SELECT COUNT(*) FROM BOARD;
-- 2. 글 목록(글 그룹이 최신인 글이 위로)
SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP; -- ★ ★ ★ ★ ★

-- 2. 글 목록(TOP_N구문)
SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A; -- 전단계
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A)
    WHERE RN BETWEEN 11 AND 20; -- 완성(DAO에 들어갈 SQL)

-- 3. 글 쓰기(원글 쓰기) - 글쓴이, 글제목, 글본문, 이메일, PW
    -- 글번호를 생성
    SELECT NVL(MAX(NUM),0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '김길동', '제목2', '본문\n방구', 
                    null, '111', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.2');
                    
-- 4. 글번호로 글 상세보기 내용(DTO) 가져오기
SELECT * FROM BOARD WHERE NUM=2;

-- 5. 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM=2;

-- 6. 글 수정
UPDATE BOARD SET SUBJECT = '수정된제목1',
                CONTENT = '수정된 본문\n방가',
                EMAIL   = 'hong@hong.com',
                PW      = '111',
                IP      = '127.0.0.1'
            WHERE NUM=1;

-- 7. 글 삭제(비밀번호를 맞게 입력한 경우만 삭제)
COMMIT;
DELETE FROM BOARD WHERE NUM=1 AND PW='111';
ROLLBACK;

-- 답글달기
SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP ASC;
-- 218번(원글)
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
    VALUES (218, '홍준표', '나 대선출마한다', '진짜 할건데 뽑아주냐? 뽑아주라', NULL, '111', 218, 0, 0, '222.222.222.222');
-- 218번의 1번째 답글 달기
    -- 8. 답변글 추가 전단계(엑셀의 a단계 - 원글의 REF=218 원글의 REF_STEP:0)
    UPDATE BOARD SET RE_STEP = RE_STEP+1
        WHERE REF=218 AND RE_STEP > 0;
    -- 답변글 INSERT (REF=218, RE_STEP=1, RE_INDENT=1)
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES (219, '홍빠', '무조건 찍는다', '나오기만해 대통령 가즈아~', 'hongbba@strength.com', '111', 218, 1, 1, '242.242.242.242');
-- 218번의 2번째 답글 달기
    SELECT MAX(NUM) FROM BOARD;
    UPDATE BOARD SET RE_STEP = RE_STEP+1
        WHERE REF=218 AND RE_STEP > 0;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES (220, '홍빠2', '나도 무조건 찍는다', '나오기만해 대통령 가쥬아~', 'hongbba2@strength.com', '111', 218, 1, 1, '242.242.242.222'); -- 9. 답글 달기

SELECT MAX(NUM) FROM BOARD; -- 최고 번호
SELECT * FROM BOARD WHERE REF=(SELECT REF FROM BOARD WHERE NUM=220);

-- 220번 글의 1번째 답글 달기
    -- 답변글 추가 전단계(엑셀의 a단계 - 원글의 REF=218 원글의 REF_STEP:1 원글의 RE_INDENT:1)
    UPDATE BOARD SET RE_STEP = RE_STEP+1
        WHERE REF=218 AND RE_STEP > 1;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '홍안티', '응 안찍어', '나오기만해 바로 광탈~', 'hongAnti@nohong.com', '111', 218, 1, 2, '131.131.131.131');

-- 데이터 조작
DELETE FROM BOARD WHERE NUM=221;
COMMIT;

-- 조회수 조작
UPDATE BOARD SET READCOUNT = 99900 WHERE NUM=3;
SELECT * FROM BOARD ORDER BY REF DESC;