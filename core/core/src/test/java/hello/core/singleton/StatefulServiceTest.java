package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService",StatefulService.class);
    // A사용자가 10000원 주문
        int userAPrice = statefulService1.order("userA",10000);
    // B가 20000원 주문
        int userBPrice = statefulService2.order("userB",20000);

        // 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice); //10000 이 아닌 20000이 출력됨.

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000); // 확인해보면 sS1 의 가격은 20000으로 되어있다.
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
