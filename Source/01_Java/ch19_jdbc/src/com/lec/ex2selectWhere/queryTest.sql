-- Ex1. 부서번호 받고 부서정보 출력하기
SELECT * FROM DEPT WHERE DEPTNO=40;
-- 40번 삭제

-- Ex2. 부서번호 받고 부서정보와 사원정보 출력
SELECT * FROM DEPT WHERE DEPTNO=20;
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=20;
-- Ex3. 
SELECT * FROM DEPT WHERE DNAME=UPPER('SALES');
-- Ex4. 