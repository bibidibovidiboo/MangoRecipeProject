# 망고의 레시피 🥭🍴

식문화 정보 제공 웹 사이트 구축 프로젝트

## 프로젝트 소개

### ✔ 개발 목표

Spring Framework를 활용한 사용자 데이터 기반의 웹 사이트 개발

### ✔ 개발 기간

20.11.16 - 20.12.18

### ✔ 개발 환경

```
- Language : Java, JavaScript, Kotlin
- DB : Oracle, MongoDB
- DevelopmentTools : sts-3.8.4.RELEASE, Sql development, WebStorm
```

### ✔ 사용 기술

```
React, JSP, HTML5, CSS3, Ajax, jQuery, Mybatis, Jsoup, Open API
```

- 카카오 API를 활용한 로그인 기능
- PL/SQL을 활용한 자유게시판
- 네이버 데이터를 활용한 날씨별 요리 추천
- React를 활용한 마트 리스트 및 검색 기능
- 레시피 및 추천 맛집 상세 정보 제공
- 최저가 상품 정보제공 및 댓글 분석 기능

## 주요 기능

### 1️⃣ 메인페이지

- REST API를 활용한 카카오 로그인

### 2️⃣ 식재료

- Ajax를 활용한 관심 식재료 등록 기능
- 관심 식재료의 최저가 제공 ( 네이버 API )
- D3.js를 활용한 지도 데이터 시각화

### 3️⃣ 레시피 & 맛집

- 추천 레시피 및 맛집 리스트 제공

### 4️⃣ 추천

- 네이버 날씨 데이터를 활용한 요리 추천 기능
- 셰프의 레시피 태그 별 추천 & 검색 기능

### 5️⃣ 커뮤니티

- 프로시저를 사용한 CRUD 게시판 페이지

### 6️⃣ 최저가

- 카테고리 별 농수산물 상품 정보 페이지
- 구매 후기 댓글의 파이 그래프 반영 기능

### 7️⃣ 마트 찾기

- 경기도 공공데이터를 활용한 마트 정보 페이지
- 카카오 지도 API를 활용한 마트 별 지도 제공

## 담당 기능

### 프론트엔드 & 백엔드 💻🧡

- 메인페이지 전체
- CRUD 자유게시판
- 우리 동네 마트 찾기
- DB 설계 및 데이터수집

|메인페이지|자유게시판|
|-|-|
|![메인페이지](https://user-images.githubusercontent.com/66943451/117270889-a0bbff00-ae94-11eb-8564-5910818a5556.png)|![자유게시판](https://user-images.githubusercontent.com/66943451/117271263-f690a700-ae94-11eb-8d42-613e62be6cad.jpg)|
|- 인기 레시피, 날씨 별 추천 요리, 맛집 정보등을 시각화하여 제공합니다.|- 프로시저를 이용한 CRUD 게시판입니다. <br> - 비밀번호 유효성 검사 후 글 수정 및 삭제가 가능합니다. <br> - 로그인 후 댓글 작성, 수정, 삭제가 가능하도록 구현했습니다.|

|우리 동네 마트 찾기|
|-|
|![마트페이지](https://user-images.githubusercontent.com/66943451/117272629-576caf00-ae96-11eb-960a-1a7fd26d1806.png)|
|- React로 페이지 구현 후 Webpack으로 배포하여 스프링과 연동한 페이지입니다.<br> - 경기도 공공데이터를 활용하여 마트 데이터를 수집했습니다. <br> - 마트 별 정보 제공 및 찾기 기능을 제공합니다. ( 지도는 카카오 Open API를 활용 )|

## ERD

![DB](https://user-images.githubusercontent.com/66943451/117270043-c72d6a80-ae93-11eb-8a1c-c21e0a1f4664.png)

## Organizations

[@망고의 레시피](https://github.com/SIST-Team3-Spring-Project)
