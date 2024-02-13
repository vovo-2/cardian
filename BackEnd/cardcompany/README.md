# SpringBoot-Project-CardCompany(A803)
스프링부트 + JPA_카드사

## 🖥 프로젝트 소개
현존하는 카드사 API를 참고하여 만든 카드사 API 제공 프로그램입니다.
* 카드사의 API는 금융 기관으로 인정받은 회사만 사용 가능하므로, 프로젝트 진행을 위해 카드사 API를 모방한 백엔드 서버를 구축했습니다. 가상의 더미데이터를 넣고, 실제 카드사에서 데이터를 끌어와 사용하는 것처럼 구현하기 위해 제작했습니다.

## 📆 개발 기간
* 24.01.08일 ~ 24.02.16일

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
* 반환 JSON
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
* 반환 JSON
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
* 반환 JSON
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




