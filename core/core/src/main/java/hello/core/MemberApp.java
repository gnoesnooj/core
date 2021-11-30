package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); // appConfig를 통해서 실행, memberService 객체는 memberServiceImpl 이 들어가 있다. AppConfig 에서 생성자로 생성되어있기 때문
//        MemberService memberService = new MemberServiceImpl();

        // AppConfig 에있는 설정정보를 가져와서 스프링 컨테이너에 객체생성한 내용들을 다 넣어서 관리해준다.
        // 기존 memberService에 appConfig의 정보를 가져와 넣어줘서 사용했으나, 이제는 applicationContext을 거쳐 접근해야한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
