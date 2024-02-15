# SpringBoot-Project-CardCompany(A803)
스프링부트 + JPA_카드사

## 🖥 프로젝트 소개
현존하는 카드사 API를 참고하여 만든 카드사 API 제공 프로그램입니다.
* 카드사의 API는 금융 기관으로 인정받은 회사만 사용 가능하므로, 프로젝트 진행을 위해 카드사 API를 모방한 백엔드 서버를 구축했습니다. 가상의 더미데이터를 넣고, 실제 카드사에서 데이터를 끌어와 사용하는 것처럼 구현하기 위해 제작했습니다.

## 📆 개발 기간
* 24.01.08 ~ 24.02.16 (6주)

## 🙎 멤버 구성
* 정여민 : 카드사 제공 API 제작

## ⚙ 개발 환경
* Java 17
* JDK 17.0.9
* IDE : intelliJ 2023.3.2
* Framework : SpringBoot(3.2.2)
* ORM : JPA
* DB : MySQL (server 5.7 & client 8.0)
* 웹서버 : Apache Tomcat


## 필수 조건
* Gradle : groovy
* 사용한 dependency
    * lombok
    * Hibernate
    * MySQL
    * Spring Web
    * Spring Data JPA
    * JSON

## 📌주요 기능
### 유저 정보 조회 API
* 주소 : 서버주소:8082/user/{member-id}
* 유저의 아이디, 이름을 JSON 형식으로 반환합니다.
 ``` JSON
{
          "member":{
               "memberId":int,
               "name": "String"
          }
          "HTTP status":{
                    "code": "String",
                    "description": "String"
          }
}
```


### 유저가 갖고 있는 카드 정보 조회 API
* 주소 : 서버주소:8082/card/{member-id}
* 유저가 갖고 있는 카드 목록을 JSON 형식으로 반환합니다. 카드 정보에는 카드 아이디, 유저 정보(유저 아이디, 이름), 카드사 이름, 카드 종류(신용, 체크), 카드 이름, 카드 번호, 카드 이미지, 목표 실적, 만료일자, 연회비, 혜택 코드(할인, 적립, 캐쉬백)이 있습니다.
```JSON
{
          "cardList": [
               {
               "id": int,
               "member": {
               "id": int,
               "name": "String",
               "hibernateLazyInitializer": {}
               },
               "cardCompany": "String",
               "type": "String",
               "name": "String",
               "number": "String",
               "image": "String",
               "goal": int,
               "expireDate": "String",
               "annualFee": int,
               "benefitCode": "String"
               },
]
          "HTTP status":{
                    "code": "String",
                    "description": "String"
          }
}
```

### 유저의 거래내역 조회 API 
* 주소 : 서버주소:8082/transaction/{member-id}/{updateDate}
* updateDate 형식 : yyyy-MM-ddHH:ss:mm
* 유저의 거래내역을 JSON 형식으로 반환합니다. 마지막 거래내역 갱신일 이후의 값만 반환하며, 거래내역 정보에는 거래내역 아이디, 카드 정보, 거래번호, 일자, 일시, 사용처, 거래 금액, 거래 상태(승인, 취소), 혜택 여부가 있습니다. 
``` JSON
{
          "transactionList":[
               {
               "id": int,
               "card": {
                              "id": int,
                              "member": {
                                             "id": int,
                                             "name": "String",
                                            "hibernateLazyInitializer": {}
                              },
                              "cardCompany": "String",
                              "type": "String",
                              "name": "String",
                              "number": "String",
                              "image": "String",
                              "goal": int,
                              "expireDate": "String",
                              "annualFee": int,
                              "benefitCode": "String"
               },
               "number": int,
               "day": "String",
               "date": "String",
               "store": "String",
               "price": int,
               "status": boolean,
               "discount": boolean
               },
]
          "HTTP status":{
                    "code": "String",
                    "description": "String"
          }
}

```

## 프로젝트 디렉터리 구조

📦cardcompany
 ┣ 📂gradle
 ┃ ┗ 📂wrapper
 ┃ ┃ ┣ 📜gradle-wrapper.jar
 ┃ ┃ ┗ 📜gradle-wrapper.properties
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂A803
 ┃ ┃ ┃ ┃ ┗ 📂cardian
 ┃ ┃ ┃ ┃ ┃ ┣ 📂card
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CardController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Card.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Company.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyCard.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Transaction.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CardRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜CardianApplication.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┗ 📜application.yml
 ┃ ┗ 📂test
 ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┗ 📂A803
 ┃ ┃ ┃ ┃ ┗ 📂cardian
 ┃ ┃ ┃ ┃ ┃ ┗ 📜CardianApplicationTests.java
 ┣ 📜.gitignore
 ┣ 📜.gitkeep
 ┣ 📜build.gradle
 ┣ 📜Dockerfile
 ┣ 📜gradlew
 ┣ 📜gradlew.bat
 ┗ 📜settings.gradle



