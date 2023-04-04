----------------------------------------------------------------------
-------------------------  MemberDao query  --------------------------
----------------------------------------------------------------------
-- (1) 회원id 중복체크
SELECT * FROM MVC_MEMBER WHERE MID='kim';
-- (2) 회원 EMAIL 중복체크
SELECT COUNT(*) CNT FROM MVC_MEMBER WHERE MEMAIL='hong@naver.com';
-- (3) 회원가입
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('aaa','1','홍길동','hong@naver.com','NOIMG.JPG','1998/12/12','서대문');
COMMIT;
-- (4) 로그인
SELECT * FROM MVC_MEMBER WHERE mID='aaa' and mPW='1';
-- (5) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
SELECT * FROM MVC_MEMBER WHERE MID='aaa';
-- (6) 회원정보 수정
UPDATE MVC_MEMBER 
  SET MPW='1',
      MNAME='송중기',
      MEMAIL='SONG@S.COM',
      MPHOTO = 'NOIMG.JPG',
      MBIRTH = '1995-12-12',
      MADDRESS = '서대문'
  WHERE MID='song';
-- (7) 회원 리스트(top-n)
SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC; -- 신입회원순
SELECT *
  FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A)
  WHERE RN BETWEEN 4 AND 6;
-- (8) 전체 등록된 회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
-- (9) 회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID='eee';
COMMIT;

----------------------------------------------------------------------
-------------------------  BoardDao query  ---------------------------
----------------------------------------------------------------------
-- (1) 글목록(startRow~endRow)
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT F.*, MNAME, MEMAIL
            FROM FILEBOARD F, MVC_MEMBER M
            WHERE F.MID = M.MID
            ORDER BY FGROUP DESC, FSTEP) A)
    WHERE RN BETWEEN 1 AND 4;
-- (2) 글갯수
SELECT COUNT(*) FROM FILEBOARD;
-- (3) 글쓰기(원글쓰기)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '길동이가 싼 글', '뿌직', '파일', FILEBOARD_SEQ.CURRVAL, 0, 0, '192.1.1.1');
-- (4) hit 1회 올리기
UPDATE FILEBOARD SET fHIT = fHIT + 1 WHERE fID=1;
-- (5) 글번호(fid)로 글전체 내용(boardDto) 가져오기
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M  WHERE F.MID=M.MID AND FID='1';
-- (6) 글 수정하기(fid, ftitle, fcontent, ffilename, frdate(SYSDATE), fip 수정)
UPDATE FILEBOARD 
    SET fTITLE = '제목 바꿈',
        fCONTENT = '본문 바꿈',
        fFILENAME = '바꾼파일',
        fRDATE = SYSDATE,
        fIP = '163.1.1.1'
    WHERE fID = 4;
-- (7) 글 삭제하기
COMMIT;
DELETE FROM FILEBOARD WHERE FID=1;
ROLLBACK;
-- (8) 답변글 쓰기 전 단계(원글의 fgroup과 같고, 원글의 fstep보다 크면 fstep을 하나 증가하기)
UPDATE FILEBOARD SET FSTEP = FSTEP + 1 WHERE fGROUP=2 AND FSTEP>0;
-- (9) 답변글 쓰기
INSERT INTO FILEBOARD (fID, MID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'han', '글3-답1', '답변이요','파일이요', 2, 1, 1, '192.1.1.753');
-- (10) 회원탈퇴 시 탈퇴하는 회원(mid)이 쓴 글 모두 삭제하기
DELETE FROM FILEBOARD WHERE MID='han';
COMMIT;

----------------------------------------------------------------------
-------------------------  AdminDao query  ---------------------------
----------------------------------------------------------------------
-- (1) admin 로그인
SELECT * FROM ADMIN WHERE AID='admin' AND APW='1';
-- (2) 로그인 후 세션에 넣을 용도 admin aid로 AdminDto 가져오기
SELECT * FROM ADMIN WHERE AID='admin';