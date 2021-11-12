--테이블 만들기

create table mms_member(
--PRIMARY KEY : 기본키(UNIQUE+NOT NULL), 다른 테이블에서 외래키로 쓰임
  id number CONSTRAINT member_id_seq PRIMARY KEY,
-- UNIQUE : 컬럼에서 유일한 값(중복 안됨)
  name varchar2(12) FOREIGN Key,
-- NOT NULL : null 값 불가
  Addr varchar2(50) NOT NULL,
  nation varchar2(12) NOT NULL,
  email varchar2(30) NOT NULL,
-- NULL : NULL 허용
  age number null
);