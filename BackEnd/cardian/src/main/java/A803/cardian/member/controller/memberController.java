package A803.cardian.member.controller;

import A803.cardian.card.service.UpdateService;
import A803.cardian.member.data.request.MemberRequestDto;
import A803.cardian.member.domain.Member;
import A803.cardian.member.service.MemberService;
import A803.cardian.statistic.service.AccumulateBenefitService;
import A803.cardian.statistic.service.StatisticService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/*
 *  작성자 : 정여민
 *  작성일시 : 2024.02.05
 *  내용 : 멤버 컨트롤러 - 로그인 기능
 */


@Tag(name = "멤버 컨트롤러", description = "멤버 관련 정보")
@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
//@CrossOrigin(origins = {"http://i10a803.p.ssafy.io", "http://localhost:5173"}, allowCredentials = "true")
public class memberController {
    private final MemberService memberService;
    private final UpdateService updateService;


    @PostMapping("/login")
    public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response, @RequestBody MemberRequestDto memberRequestDto) throws ParseException {

        System.out.println("memberRequestDto = " + memberRequestDto.getName());

        // registerMember 로직을 memberService를 통해 호출하도록 수정
        Member member = memberService.loginMember(memberRequestDto);

        // 로그인 성공
        if(member != null){
            // 로그인 정보
            // 세션 쿠키
            createCookie(request, response, "memberId", String.valueOf(member.getId()), "session");
<<<<<<< HEAD

=======

//            memberService.saveTable(member.getId());

>>>>>>> 321de00cfa3f94e1232139e4a0d9bd82011429a7
            return ResponseEntity.ok("로그인 성공!");
        }
        return ResponseEntity.ok("로그인 실패!");

    }

    @GetMapping
    public void sample(){
        System.out.println("GET은 잘 동작합!");
    }

    /*
     *   작성자 : 정여민
     *   작성일시 : 2024.02.05
     *   내용 : 쿠키 생성하는 메서드
     */
    private void createCookie(HttpServletRequest request, HttpServletResponse response, String key, String value, String type) {
        // 세션 생성
        // 여기서는 간단하게 username을 세션에 저장

        HttpSession session = request.getSession();
        session.setAttribute(key, value);

        // 쿠키 생성
        Cookie cookie = new Cookie(key, value);
        // 일반 쿠키면 유효시간 설정, 세션이면 유효시간 X
        if(type.equals("cookie")) {
            cookie.setMaxAge(20*20*60); // 쿠키 유효기간 설정 (초 단위)
        }

        response.addCookie(cookie);

    }

}
