SELECT * FROM EMP WHERE JOB='MANAGER'; -- 실행하고자 하는 SQL문을 블럭잡고 ALT+X로 실행 ex2_oracle.jsp
-- ex3
SELECT * FROM DEPT;
SELECT * FROM EMP WHERE DEPTNO LIKE '%'||'';

-- example.jsp
SELECT E.*, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%'||UPPER(TRIM(''))||'%';