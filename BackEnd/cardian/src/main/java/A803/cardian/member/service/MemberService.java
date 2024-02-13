package A803.cardian.member.service;


/*
 *   작성자 : 정여민
 *   작성 일시 : 2024.02.02
 *   업데이트 : 2024.02.02
 *   내용 : 유저 추가 (회원가입, 로그인)
 *
 * */

import A803.cardian.card.service.UpdateService;
import A803.cardian.member.data.request.MemberRequestDto;
import A803.cardian.member.domain.Gender;
import A803.cardian.member.domain.Member;
import A803.cardian.member.domain.embbeded.PhoneNumber;
import A803.cardian.member.repository.MemberRepository;
import A803.cardian.statistic.service.AccumulateBenefitService;
import A803.cardian.statistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final AccumulateBenefitService accumulateBenefitService;
    private final StatisticService statisticService;


    // 새로운 유저 추가
//    @Transactional
//    public Member registerMember(MemberRequestDto memberRequestDto, Integer memberId) throws ParseException {
//
//        String name = memberRequestDto.getName();
//        String residentRegistrationNumber = memberRequestDto.getResidentRegistrationNumber();
//        String phoneNumber = memberRequestDto.getPhoneNumber();
//
//
//        // 이미 등록된 유저인지 판별
//        Optional<Member> member = memberRepository.findMemberByPhoneNumberAndName(PhoneNumber.from(phoneNumber), name);
//
//        // 이미 등록된 유저면 로그인
//        if(member.isPresent()){
//
//            return member.get();
//
//        }
//        // 새로운 유저면 회원가입
//        else{
//            String birthDateStr = residentRegistrationNumber.substring(0, 6);
//            String genderDigitStr = residentRegistrationNumber.substring(7, 8);
//
//            // 성별 정보 가져오기
//            Gender gender = getGenderFromFirstDigit(genderDigitStr);
//
//            // 생년월일 문자열을 날짜로 변환
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
//            LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
//
//            Member newMember = Member.builder()
//                    .name(name)
//                    .phoneNumber(PhoneNumber.from(phoneNumber))
//                    .updateDate(LocalDateTime.parse("0000-01-01T00:00:00"))
//                    .birth(birthDate)
//                    .gender(gender)
//                    .age(calculateAge(birthDate))
//                    .cardMemberId(memberId)
//                    .build();
//
//            memberRepository.save(newMember);
//
//            memberRepository.flush();
//
//            Optional<Member> member1 = memberRepository.findMemberByPhoneNumberAndName(PhoneNumber.from(phoneNumber), name);
//
//            if(member1.isPresent()){
//                Integer member1Id = member1.get().getId();
//                System.out.println("member1Id = " + member1Id);
//                updateService.updateTransactions(member1Id);
//                updateService.updateMyCard(member1Id);
//                updateService.updateMemberUpdateDate(member1Id);
//            }else{
//                log.info("조회된 사용자가 없습니다.");
//            }
//
//            return member1.get();
//        }
//
//    }
    @Transactional
    public void updateTable(int memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new RuntimeException());
        //update 필요한 테이블들 update
        //1. 누적 혜택 테이블 3개
//            accumulateBenefitService.updateAccumulateBenefit(member.getId());
        accumulateBenefitService.updateAccumulateBenefit(member.getId());
        //2. 카드 월별 통계
//            statisticService.updateMonthlyCardStatistic(member.getId());
        statisticService.updateMonthlyCardStatistic(member.getId());
        //카테고리별 월별 통계
//            statisticService.updateCategoryMonthConsume(member.getId());
        statisticService.updateCategoryMonthConsume(member.getId());
        //update 필요한 테이블들 update
    }

    @Transactional
    public void saveTable(int memberId){
        System.out.println("테이블 save ");
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new RuntimeException());
        //save
        //1. 누적 혜택 테이블 3개
//            accumulateBenefitService.updateAccumulateBenefit(member.getId());
        accumulateBenefitService.saveAccumulateBenefit(member.getId());
        //2. 카드 월별 통계
//            statisticService.updateMonthlyCardStatistic(member.getId());
//        statisticService.saveMonthlyCardStatistic(member.getId());
        //카테고리별 월별 통계
//            statisticService.updateCategoryMonthConsume(member.getId());
//        statisticService.saveCategoryMonthConsume(member.getId());
        //save

        //멤버테이블 update 날짜 현재로 변경해주기
//        LocalDateTime newUpdateDate = LocalDateTime.now();
        LocalDateTime newUpdateDate = LocalDateTime.of(2023,12,31,23,59,59);
        member.updateUpdateDate(newUpdateDate);
    }

    @Transactional
    public Member loginMember(MemberRequestDto memberRequestDto) throws ParseException {

        String name = memberRequestDto.getName();
        String residentRegistrationNumber = memberRequestDto.getResidentRegistrationNumber();
        String phoneNumber = memberRequestDto.getPhoneNumber();


        // 이미 등록된 유저인지 판별
        Optional<Member> member = memberRepository.findMemberByPhoneNumberAndName(PhoneNumber.from(phoneNumber), name);

        // 이미 등록된 유저면 로그인
        if(member.isPresent()){
            return member.get();
        }
        // 등록되지 않은 유저면 null 반환
        return null;

    }

    // 새로운 유저인 경우 DB에 넣어주기

    // 기존 유저인 경우 -> 로그인

    // 성별
    static Gender getGenderFromFirstDigit(String genderDigitStr) {
        int genderDigit = Integer.parseInt(genderDigitStr);
        return (genderDigit == 1 || genderDigit == 3) ? Gender.MALE : Gender.FEMALE;
    }

    // 나이 계산
    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }


}


