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
    private final UpdateService updateService;

    // 유저 추가
    @Transactional
    public Member registerMember(MemberRequestDto memberRequestDto) throws ParseException {

        String name = memberRequestDto.getName();
        String residentRegistrationNumber = memberRequestDto.getResidentRegistrationNumber();
        String phoneNumber = memberRequestDto.getPhoneNumber();


        // 이미 등록된 유저인지 판별
        Optional<Member> member = memberRepository.findMemberByPhoneNumberAndName(PhoneNumber.from(phoneNumber), name);

        // 이미 등록된 유저면 로그인
        if(member.isPresent()){

            return member.get();

        }
        // 새로운 유저면 회원가입
        else{
            String birthDateStr = residentRegistrationNumber.substring(0, 6);
            String genderDigitStr = residentRegistrationNumber.substring(7, 8);

            // 성별 정보 가져오기
            Gender gender = getGenderFromFirstDigit(genderDigitStr);

            // 생년월일 문자열을 날짜로 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
            LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);

            Member newMember = Member.builder()
                    .name(name)
                    .phoneNumber(PhoneNumber.from(phoneNumber))
                    .updateDate(LocalDateTime.MIN)
                    .birth(birthDate)
                    .gender(gender)
                    .age(calculateAge(birthDate))
                    .build();

            memberRepository.save(newMember);

            memberRepository.flush();

            Optional<Member> member1 = memberRepository.findMemberByPhoneNumberAndName(PhoneNumber.from(phoneNumber), name);

            if(member1.isPresent()){
                Integer memberId = member1.get().getId();
                updateService.updateTransactions(memberId);
                updateService.updateMyCard(memberId);
                updateService.updateMemberUpdateDate(memberId);
            }else{
                log.info("조회된 사용자가 없습니다.");
            }

            return newMember;
        }

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


