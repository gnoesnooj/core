package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없이 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1 조회 호출마다 객체 생성
        MemberService memberService1 = appConfig.memberService();

        //2 조회 호출마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        // 둘의 참조 값이 다름. 그 말은 고객의 요청이 올 때 마다 하나씩 객체가 따로 생성됨 -> 5만번 오면 memberService50000 까지 생성 되어버리는 것임
        // 두 객체가 똑같은 지 보는건 sout으로 보지 말고 assertion 으로 확인
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingletonServiceTest() {
        // private 때문에 new SingletonService() 가 XXX
//        System.out.println("singletonService1 = " + singletonService1);
//        System.out.println("singletonService2 = " + singletonService2);
//
//        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
            //1. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
            //2. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
            //참조값이 같은 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
            //memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }
   
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        assertThat(memberService1).isSameAs(memberService2);

    }
}
