# MyBatis 매퍼 설정 및 테스트
Sample 클래스와 Sample 테이블간의 매핑 설정

## Mybatis 접속 서비스를 테스트

1. AbstractApplicationContext 객체로 빈을 로드하여 테스트
2. @ContextConfiguration 어노테이션으로 빈을 로드하여 테스트

## Mysql 버전 및 기초 스크립트

- Mysql 8 
- DDL
  ```sql 
  create table sample
    (
        id       varchar(20)                        not null
            primary key,
        title    varchar(100)                       null,
        reg_user varchar(20)                        null,
        content  varchar(500)                       null,
        reg_date datetime default CURRENT_TIMESTAMP null
    );
  ```
- Insert Queries
  ```sql
    INSERT INTO ex.sample (id, title, reg_user, content, reg_date) VALUES ('SAMPLE-00001', 'new1', '관리자', '내용입니다.', '2020-05-21 09:21:59');
    INSERT INTO ex.sample (id, title, reg_user, content, reg_date) VALUES ('SAMPLE-00002', 'SAMPLE 등록입니다.', 'new', 'SAMPLE 등록 테스트 중입니다.good12', '2020-05-21 09:23:58');
    INSERT INTO ex.sample (id, title, reg_user, content, reg_date) VALUES ('SAMPLE-00003', 'idgen 확인', '테스터', 'idgen = 3', '2020-05-21 11:13:20');
    INSERT INTO ex.sample (id, title, reg_user, content, reg_date) VALUES ('SAMPLE-00004', 'jdbc로 등록', '테스터', 'SAMPLE 등록 테스트 중입니다.', '2020-05-21 11:16:33');
    INSERT INTO ex.sample (id, title, reg_user, content, reg_date) VALUES ('SAMPLE-00005', 'ibatis로 등록', '테스터', 'ibatis 테스트', '2020-05-22 09:30:10');
    INSERT INTO ex.sample (id, title, reg_user, content, reg_date) VALUES ('SAMPLE-00006', 'mybatis로 등록', '테스터', 'mybatis로 등록합니다.e', '2020-05-22 11:45:47');
    ```