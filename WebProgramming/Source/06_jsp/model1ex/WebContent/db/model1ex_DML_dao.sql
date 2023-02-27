-- CustomerDao(아이디 중복 체크, 회원가입, 로그인, 상세 보기(pk로 dto 가져오기), 정보 수정, Top-N 리스트, 회원수)
-- 1. 아이디 중복 체크
SELECT COUNT(*) FROM CUSTOMER WHERE CID='aaa';
-- 2. 회원가입
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)
    VALUES ('ggg', '111', '오태식', '010-4848-8282', 'sunflower@lycos.com', '대전광역시', 'M', '1970-07-07');
-- 3. 로그인
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';
-- 4. 상세 보기(pk로 DTO 가져오기)
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 5. 정보 수정
UPDATE CUSTOMER SET CPW = '111',
                    CNAME = '무존재감',
                    CTEL = '02-0000-0000',
                    CEMAIL = 'void@hotmail.com',
                    CADDRESS = '독도',
                    CGENDER = 'M',
                    CBIRTH = '1960-10-10'
                WHERE CID='eee';
-- 6. TOP-N 리스트
SELECT * FROM CUSTOMER ORDER BY CRDATE; -- 전체 보기
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM CUSTOMER ORDER BY CRDATE) A)
    WHERE RN BETWEEN 1 AND 3;
-- 7. 회원 수
SELECT COUNT(*) FROM CUSTOMER;

-- FileboardDao(top-N 리스트, 글 갯수, 글 쓰기(원글 1개, 답변글 2개 query), hit올리기, 글 상세 보기, 글 수정, 글 삭제)
-- 1. TOP-N 리스트
SELECT F.*, CNAME, CEMAIL
    FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID = C. CID
    ORDER BY FREF DESC, FRE_STEP; -- 전체 출력

SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT F.*, CNAME, CEMAIL
            FROM FILEBOARD F, CUSTOMER C
            WHERE F.CID = C.CID
            ORDER BY FREF DESC, FRE_STEP) A)
    WHERE RN BETWEEN 2 AND 3; -- 완성된 TOP-N

-- 2. 등록된 글 수
SELECT COUNT(*) FROM FILEBOARD;

-- 3. 원글 쓰기
INSERT INTO FILEBOARD (fNUM, CID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '글3','본문3',null,'1', 
            FILEBOARD_SEQ.CURRVAL, 0,0,'198.12.1.1');

-- 4. 답변글 쓰기전 step A -- 4번글에 대한 답변글 쓰기 전작업
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fREF=4 AND fRE_STEP>0;

-- 5. 답변글 쓰기 -- 4번글의 답변
INSERT INTO FILEBOARD (fNUM, CID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '글3-답1', null,null, '1', 4, 1, 1, '192.1.1.1');
    
SELECT * FROM FILEBOARD WHERE fREF = 4 ORDER BY FRE_STEP; -- 4번 그룹 확인

-- 6. 글 상세 보기
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID AND FNUM=2;

-- 7. HIT 올리기
UPDATE FILEBOARD SET fHIT = fHIT + 1 WHERE fNUM=2;

-- 8. 글 수정
UPDATE FILEBOARD SET fSUBJECT = '수정된 제목',
                    fCONTENT = '수정된 본문',
                    fFILENAME = NULL,
                    fPW = '111',
                    fIP = '192.168.10.30'
                WHERE fNUM=4;

-- 9. 글 삭제
COMMIT;
DELETE FROM FILEBOARD WHERE fNUM=1 AND fPW='1';
ROLLBACK;

-- BookDao(top-N 리스트, 책 갯수, 책 등록, 상세 보기)
-- 1. TOP-N 리스트
SELECT * FROM BOOK ORDER BY BRDATE DESC;-- 신간 도서 순으로 전체 리스트 출력
SELECT * 
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3; -- 완성된 top-N
-- 2. 책 갯수
SELECT COUNT(*) FROM BOOK;
-- 3. 책 등록
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은 자바다', 30000, 'noImg.png','NOTHING.JPG','책설명',20);
-- 4. 상세 보기
SELECT * FROM BOOK WHERE BID=1;

COMMIT;