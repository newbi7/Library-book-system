# Library-book-system

## 기능 구현 완료 목록

아이디 찾기, 비밀번호찾기, 로그인, 회원가입, 관리자 - 손님구별로그인 및 다른 창 띄우기, 아이디-이름-포인트 갱신,    
회원정보수정 및 삭제, 도서보유여부검색 및 반납(관리자 자유, 손님은 본인것만), 회원검색기능, 도서상세검색기능, 도서대여기능,    
도서정보수정-삭제-추가, 미납도서만검색하기, 포인트 추가, 반납일-대여일찍기   

두가지 방법을 통해 프로젝트를 만들어 보고자 FXML 비사용, 사용을 나누었습니다.   

```
-----------FXML 비사용

1. 로그인 창
ID찾기
lecture.jdbc.view  -> IDFind
PW찾기
lecture.jdbc.view  -> PWFind
회원가입
lecture.jdbc.view  -> NewAssign
로그인
lecture.jdbc.view  -> LoginView_1

관리자 로그인 
ID : admin // PW : admin 
손님 로그인
ID : 자유롭게 작성 // PW : 
```

```
-------------FXML 사용

2. 메인페이지

lecture.jdbc.fxmlcontroller ->MainPageAdc_2 (관리자로그인), MainPageCuc_3 (손님로그인)


3. 각 버튼 별 컨트롤러 설명

lecture.jdbc.fxmlcontroller

PeopleInfdel_insc -> 회원정보수정

BookHaveReturnc -> 도서보유여부/ 반납           

PeopleSearchc -> 회원검색

BookDetailnfc -> 도서상세검색

BookInfdelc -> 도서 정보수정/삭제

BookInfaddc -> 도서추가

BookNonPaymentc -> 미납도서검색


4. 사용 VO
peopleVO, bookVO, bookInfVO
```
