# AI기반 문답형 MBTI 추정 서비스

<div align="center">
<img width="329" alt="image" src="https://github.com/hotcoa922/Java-Algorithm-KTH/assets/81072997/20bbb08b-74bb-423a-b127-ea83c4558df6">


</div>

# MBTI_AI_Analysis Web Page v1.0.0
**캡스톤 프로젝트2** <br/>


## 🖥️ 프로젝트 소개
AI를 활용하여 주관식 문답을 기반으로 MBTI를 측정하는 복합 웹 서비스
<br>

## 🕰️ 개발 기간
**2022-09-26 ~ 2022-12-05**


### 🧑‍🤝‍🧑 멤버구성
<!--깃허브 링크 달아주기, 담당 서비스 더 자세히 적으면 좋을듯-->
 - 팀장 : [김태현](https://github.com/hotcoa922) - 백엔드 개발
 - 팀원 : 김은희 - 프론트엔드 개발
 - 팀원 : 김규영 - 인공지능 개발
 - 팀원 : 박성준 - 인공지능 개발
 - 팀원 : 이정재 - 인공지능 개발
---
---
<!--추가할 내용 의논-->
## Stacks 🐈

### 개발 환경
`Java 11` </br>
`IntelliJ` </br>
`Ubuntu 18.04` </br>
`Spring Boot 2.7.8` </br>

### 사용 기술
`AWS EC2, RDS, S3` </br>
`OAuth2.0 & JWT` </br>
`Spring Security` </br>
`MySQL` </br>
`JPA` </br>
`Junit` </br>

### 보안 기술
`JWT`  </br>

### 협업 도구
`Discord` </br>
`Git` </br>

### 문서화 도구
`Postman`

---
<!--추가할 내용 의논-->
## 주요 기능 📦
### ⭐️ 회원관리
① MBTI 측정 기능
-주관식 문답을 통해서 사용자의 MBTI를 측정하여 제공한다.

② 이상형 MBTI 측정 기능
-① 기능과 동일하게 MBTI에 대한 질문을 묻지만 사용자는 자신의 이상형이 그 질문에 대해 어떤 답을 했으면 좋겠는지를 생각하며, 주관식 문답을 진행한 뒤 측정 결과를 토대로 사용자의 이상형의 MBTI를 제공한다.
</br></br>
### ⭐️ MBTI 측정
① 자신 MBTI의 유사 질문 및 답변 통계 출력 기능
-자신에게 주어졌던 질문들과 가장 유사했던 질문의 다른 사용자의 답변을 사용자에게 제공

② 이상형 MBTI의 실제 유사 질문 및 답변 통계 출력 기능
-이상형의 MBTI 측정 기능을 통해 측정된 MBTI 결과와 일치하는 실제 사용자의 답변을 제공한다.
</br>
③ MBTI별 결과 통계 출력 기능
-MBTI별 사용자와 관련된 통계를 그래프 및 정보로 제공한다.
</br></br>
### ⭐️ 유형별 통계
① 노래 추천 기능
-사전에 노래 가사에 MBTI 측정 모델을 시행해 노래별 MBTI를 측정한 뒤, 해당 결과를 기반으로 사용자의 MBTI에 맞는 노래를 추천

② 영화 추천 기능
-만족, 불만족으로 레이팅을 형성 및 개선해 MBTI별로 영화를 추천
</br></br>

### ⭐️ 컨텐츠 추천
① 로그인 / 로그아웃 기능
② 소셜 네트워크 서비스 로그인 기능
③ 개인 프로필 화면 제공 및 수정 기능
</br></br>

---
## 데이터베이스 ERD
<img width="1000" alt="image" src="https://github.com/aucison/Aucison_Service/assets/81072997/9d1fce2e-e461-4605-90bc-087cd307ebb6"> 


---
## 시스템 구조도
![1번 구조도](https://github.com/Myers-Team/MBTI_AI_Analysis_BE/assets/81072997/a3b53143-3f64-418b-b2db-b8f0a9d85311)
![2번 구조도](https://github.com/Myers-Team/MBTI_AI_Analysis_BE/assets/81072997/25b73ed1-3569-4a57-af5b-060349978853)

