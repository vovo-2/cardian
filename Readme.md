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
* 24.01.08 ~ 24.02.16

## 🙎 멤버 구성
### FE
* 김민준: 카드 이용내역, Auth, 카테고리별 카드 추천
* 문성현: 연말정산, 매장 별 혜택 검색
* 임소현: 카테고리별 통계 및 이용내역, 전체 메뉴, 라우팅

### BE
* 김은비 : 카드(전체 목록, 이용내역, 상세정보), 통계(소비금액, 월별, 카테고리별 소비내역 및 금액) 
* 배유열 : 검색(카테고리, 제휴사, 추천 카드), 연말정산(연봉정보, 기준 및 달성여부), 추천 (혜택 정보)
* 정여민 : 카드사 제공 API(카드, 이용내역), 로그인, 카드(혜택, 카테고리별 제휴사 및 혜택)

### INFRA
* 정여민 : AWS Lightsail, Docker, Jenkins 를 사용한 CI/CD 구축

## 기술 스택 
![기술_스택](https://github.com/vovo-2/cardian/assets/153492321/8c707096-d5b2-49ed-aaf2-8c3aa01d042a)


## README

### Cardian
#### BE
[Cardian BE Readme 보러가기](https://lab.ssafy.com/s10-webmobile1-sub2/S10P12A803/-/blob/master/BackEnd/cardian/ReadMe.md?ref_type=heads)

#### FE
[Cardian FE Readme 보러가기](https://lab.ssafy.com/s10-webmobile1-sub2/S10P12A803/-/blob/master/FrontEnd/README.md?ref_type=heads
)

### Card Company
[Card Company BE Readme 보러가기](https://lab.ssafy.com/s10-webmobile1-sub2/S10P12A803/-/blob/master/BackEnd/cardcompany/README.md?ref_type=heads)



