# SpringBoot-Project-Cardian(A803)
스프링부트 + JPA_Cardian

## 🖥 프로젝트 소개
> **소비 습관에 기반하여 보유 중인 카드의 혜택을 효율적으로 받을 수 있게 도와주는 서비스**

카드의 피킹률이란, 지출액 대비 카드 혜택이 얼마나 좋은지 평가하는 일종의 자가 진단 지표입니다. 3~5%를 유지하는 것이 좋은 카드라 할 수 있는데, 조사에 따르면 이 값은 연령대별로 평균 0.89 ~ 1.8%를 보이고 있습니다. 카드사 입장에서도 피킹률이 낮으면 결과적으로 소비자가 당사 카드를 계속 사용해야하는 이유를 알지 못하므로 좋지 않은 상황입니다. 또한, 1인당 평균 보유 카드 수는 연령대에 따라 6장 ~ 10장으로 다양하다는 조사 결과가 있습니다. 
위의 두 가지 조사를 종합했을 때, 카드의 피킹률이 낮은 이유는 소비자가 자신이 사용 중인 카드의 혜택에 대해 잘 모르기 때문이라는 결론을 내렸습니다.


이 프로젝트는, 사용자가 자신이 보유 중인 카드의 혜택을 효율적으로 받을 수 있게 도와주는 것을 목표로 하고 있으며, 크게 다음과 같은 7가지 기능을 갖고 있습니다.


1. 카드 사용 내역 조회
2. 소유한 카드별 혜택 조회
3. 카테고리 및 카테고리에 속해있는 제휴사 검색 및 조회 & 제휴사 별 카드추천
4. 소비 패턴 분석 결과를 그래프로 조회
5. 카드별 혜택받은 금액 조회
6. 소비 패턴 분석을 통해 혜택을 더 볼 수 있는 카드 조회
7. 사용자의 연봉에 따른연말정산 기준 달성여부 제공 및 달성여부에 따른 결과 제공

## 목차


## 📆 개발 기간
* 24.01.08일 ~ 24.02.16일

## 🙎 멤버 구성
### FE
* 김민준 : 팀장, FE 리더, 로그인, 카드별 이용내역, 마이페이지
* 문성현 : 제휴사 검색, 통계(연말정산)
* 임소현 : 카드별 혜택, 통계(월별 소비 추이)

### BE
* 김은비 : 카드(전체 목록, 이용내역, 상세정보), 통계(소비금액, 월별, 카테고리별 소비내역 및 금액) 
* 배유열 : 검색(카테고리, 제휴사, 추천 카드), 연말정산(연봉정보, 기준 및 달성여부), 추천 (혜택 정보)
* 정여민 : 카드사 제공 API(카드, 이용내역), 로그인, 카드(혜택, 카테고리별 제휴사 및 혜택)

### INFRA
* 정여민 : AWS Lightsail, Docker, Jenkins 를 사용한 CI/CD 구축



## ⚙ 개발 환경
* Java 17
* JDK 17.0.9
* IDE : intelliJ 2023.3.2
* Framework : SpringBoot(3.2.2)
* ORM : JPA
* DB : MariaDB v.10
* 웹서버 : Apache Tomcat


## 🎁 필수 조건
* Gradle : groovy
* 사용한 dependency
    * lombok
    * Hibernate
    * MySQL
    * Spring Web
    * Spring Data JPA
    * JSON

## 💾 용어
* 예외 혜택 : 혜택을 받을 수 있는 제휴사 목록 중 일반적인 혜택률 보다 더 큰 혜택을 받을 수 있는 경우.


## 📌주요 기능 (API)
### 0. 내 카드 조회
사용자가 소유중인 카드 목록을 보여줌.

```JSON
{
  "memberId": 1,
  "cardList": [
    {
      "mycardId": int,
      "myCardName": "String",
      "myCardImage": "String"
    }
  ]
}
```

### 1. 카드 소비내역 조회
해당 카드의 소비내역과 받은 혜택(할인, 캐시백, 적립)을 보여줌.
#### 1-1. 소비내역을 월별, 일별로 묶어서 가져옴.
#### 1-2. 월, 일, 시간 최신순으로 정렬해서 가져옴.
#### 1-3. 소비내역의 사용처로 해당 사용처에 해당 카드에 혜택을 가지고 있는지 확인하기
#### 1-4. 예외 혜택일 때와 카테고리 혜택일 때를 구분해서 혜택 금액 계산해주기
#### 1-5. 카드 종류가 할인형인지 적립,캐시백형인지 구분해서 혜택 금액 계산해주기

```JSON
{
  "myCardId": int,
  "yearTransactionDetailsList": [
    {
      "month": int,
      "monthlyTransactionDetailsList": [
        {
          "day": int,
          "dailyTransactionDetailsList": [
            {
              "transactionId": int,
              "store": "String",
              "date": "String",
              "price": int,
              "associateImage": "String",
              "discountAmount": int,
              "benefitCode": "String"
            }
          ]
        }
      ]
    }
  }
}
```

### 2. 카드별 혜택 조회
소유한 카드의 혜택을 카테고리별로 조회하고, 카테고리에 속한 제휴사 리스트를 조회하는 API.

#### 2-1. 카테고리별 조회
* 카테고리 혜택이 존재하지 않으면 null을, 혜택이 존재하면 카테고리 코드, 할인 크기, 기호, 카테고리 혜택 아이디, 카테고리 아이콘 이미지를 JSON 형식으로 반환한다.

```JSON
{
          "benefitList":[
          {
               "categoryCode": "String",
               “iconImage”: “String”,
               "discountAmount": int,
               "sign": "String"
               “categorybenefitId”:”String”,
               “cardId”: int,
               “name”: “String”
          }
     ],
          "HTTP status":{
                    "code": "String",
                    "description": "String"
          }
}

```

#### 2-2. 카테고리별 제휴사 목록 조회
* 카테고리별 제휴사 목록을 반환하는데, 예외 혜택과 일반 혜택을 나누어 JSON 형식으로 반환한다.

```JSON
{
          "exceptionBenefitStore":
               {
                    "storeName": "String",
                    "discountAmount": int,
                    "sign": "String"
               }
          ,
          "storeList":[
               {
                    "storeName": "String",
                    "discountAmount": int,
                    "sign": "String"
               }
          ],
          "HTTP status":{
               "code": "String",
               "description": "String"
          }
}

```


### 3. 카테고리 및 카테고리에 속해있는 제휴사 검색 및 조회 & 제휴사 별 카드추천
#### 3-1. 카테고리 목록 조회
```JSON
{
  "categoryList": [
    {
      "categoryImage": "String",
      "categoryCode": "String",
      "categoryName": "String"
    }
  ]
}
```
#### 3-2. 카테고리별 제휴사 목록 조회
```JSON
{
  "associationList": [
    {
      "associationId": int,
      "associationName": "String",
      "associationImage": "String"
    }
  ]
}
```
#### 3-3. 검색어에 대해 해당하는 제휴사 목록 조회
```JSON
{
  "asssociationSearchList": [
    {
      "associationId": int,
      "associationName": "String",
      "associationImage": "String",
      "categoryCode": "String",
      "categoryName": "String"
    }
  ]
}
```
#### 3-4. 제휴사 선택 시 전 월 실적을 충족하고 혜택 상한이 남아있는 카드 중 해당 제휴사에 대해 가장 좋은 혜택을 받을 수 있는 순으로 카드 목록 조회
```JSON
{
  "cardList": [
    "card": {
      "myCardId":int,
      "cardImage": "String",
      "cardCompany": "String",
      "cardName": "String",
      "associateName":"String",
      "goal":  int,
      "consume":int,
      "thisMonthAchieve":boolean,
      "cardType": "String",
      "benefitCode": "String", 
      "benefitLimitation": int,
      "currentBenefit": int,
      "discountAmount": int,
      "discountSign": "String"
      "goalAchieve":boolean
    }       
  ]
}
```



### 4. 소비 패턴 분석 결과를 그래프로 조회
#### 4-1. 사용자의 카드별 월별 카테고리별 소비 금액 계산
사용내역의 카드아이디와 사용처이름으로 해당 사용처와 카드의 카테고리의 관계를 가져온 후 카테고리별로 누적하여 계산
#### 4-2. 사용자의 카드별 월별 소비 금액 계산
4-1에서 계산된 값을 이용하여 계산
#### 4-3. 사용자의 총 월별 소비 금액 계산
4-2에서 계산된 값을 이용하여 계산
#### 4-4. 카테고리별 소비 금액을 내림차순으로 정렬하여 보내줌
#### 4-5. 사용자의 월별 총 소비 내역을 카테고리별로 조회
카드별로 특정 카테고리의 소비 내역을 가져와 합해준 후 보내줌
#### 4-6. 소비 내역을 시간순으로 보내줌

```JSON
{
  "memberId": int,
  "month": int,
  "entireCategoryConsume": int,
  "categoryConsumeList": [
    {
      "categoryName": "String",
      "categoryConsume": int
    }
  ]
}
```
```JSON
{
  "categoryName": "String",
  "month": int,
  "monthlyTransactionDetailsList": [
    {
      "day": int,
      "dailyTransactionDetailsList": [
        {
          "store": "String",
          "price": int,
          "date": "String",
          "associateImage": "String"
        }
      ]
    }
  ]
}
```


### 5. 카드별 혜택받은 금액 조회
#### 5-1. 당월 카드별 소비내역 가져오기
#### 5-2. 소비내역의 사용처로 해당 사용처에 해당 카드에 혜택을 가지고 있는지 확인하기
#### 5-3. 예외 혜택일 때와 카테고리 혜택일 때를 구분해서 혜택 금액 계산해주기
#### 5-4. 카드 종류가 할인형인지 적립,캐시백형인지 구분해서 혜택 금액 계산해주기
#### 5-5. 당월 카드별 예외혜택별 누적 혜택 금액을 저장
5-4에서 계산된 값을 이용하여 계산
#### 5-6. 당월 카드별 카테고리혜택별 누적 혜택 금액을 저장
5-4에서 계산된 값을 이용하여 계산
#### 5-7. 당월 카드별 누적 혜택 금액을 저장
5-5, 5-6에서 저장된 값을 이용하여 저장

```JSON
{
  "myCardId": int,
  "myCardInfoDetails": {
    "companyName": "String",
    "cardName": "String",
    "cardImage": "String",
    "goal": int,
    "accumulate": int,
    "type": "String",
    "benefitCode": "String",
    "totalBenefit": int
  }
}
```


### 6. 소비 패턴 분석을 통해 혜택을 더 볼 수 있는 카드 조회
#### 6-1. 당월 카드별 소비내역 가져오기
#### 6-2. 소비내역의 사용처로 해당 사용처에 해당 카드에 혜택을 가지고 있는지 확인하기
#### 6-3. 예외 혜택일 때와 카테고리 혜택일 때를 구분해서 혜택 금액 계산해주기
#### 6-4. 카드 종류가 할인형인지 적립,캐시백형인지 구분해서 혜택 금액 계산해주기
#### 6-5. 당월 카드별 예외혜택별 누적 혜택 금액을 저장
6-4에서 계산된 값을 이용하여 계산
#### 6-6. 당월 카드별 카테고리혜택별 누적 혜택 금액을 저장
6-4에서 계산된 값을 이용하여 계산
#### 6-7. 사용자가 선택한 카테고리에서 이미 받은 혜택을 보여줌
위의 계산 결과들을 이용하여 보여줌
#### 6-8. 카드의 혜택을 적용하여 당월 전체 소비 내역을 계산하며, 최대 혜택값과 추천해줄 카드 정보를 갱신
당월 전체 소비내역을 특정 카드를 이용했다고 가정한 후 계산
#### 6-9. 사용자가 선택한 카테고리에서, 사용자가 사용했다면 이미 받은 혜택값보다 더 많은 혜택을 받을 수 있는 카드와 예상 혜택값을 보여줌
6-8에서 계산된 값을 이용하여 보여줌
#### 6-10. 예상혜택값이 더 작거나 같으면 이미 잘 사용 중인 카드를 보여줌

```JSON
{
  "cardId": int,
  "companyName": "String",
  "cardName": "String",
  "cardImage": "String",
  "benefitCode": "String",
  "type": "String",
  "cardBenefitDetailsList": [
    {
      "associateName": "String",
      "discountAmount": int,
      "sign": "String"
    }
  ],
  "recievedBenefitAmount": int,
  "maxBenefitAmount": int
}
```

### 7. 사용자의 연봉에 따른연말정산 기준 달성여부 제공 및 달성여부에 따른 결과 제공
#### 7-1. 사용자의 연봉 정보 제공 및 연봉정보 변경시 수정 기능 제공
#### 7-2. 사용자의 연봉과 1년 총소비금액을 기준으로 연말정산 공제혜택 기준치인 연봉의 25%이상을 사용했는지에 따라 true,false 값 반환
#### 7-3. 체크카드와 신용카드를 구분하여 각각의 소비 금액을 제공
#### 7-4. 기준 달성, 미달성에 따라 정보 제공
#### 7-4-1. 기준 달성 시 연말 정산 기준에 따른 최대 공제 금액과 사용자의 총소비를 기반으로 얼마만큼의 공제혜택을 받을 수 있는지 제공
```JSON
{
"settlement":{
    "annualCheckConsume": int,
    "annualCreditConsume": int,
    "maxSettlement": int,
    "mySettlement": int
  }
}
```
#### 7-4-2. 기준 미달성 시 연봉의 25%와 총 소비량을 제공
```JSON
{
"settlement":{
     "annualConsume": int,
     "settlementStandard": int,
     "annualCheckConsume": int,
     “annualCreditConsume": int,
  }
}
```


