package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 static으로 가지고 있음.
    // static 영역 공부 !
    public static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){ // 본인 싱글톤 하나만 만들어 놓고 return , 조회는 getInstance로만 가능
        return instance;
    }

    private SingletonService(){ //  new를 통한 생성 못하게 막기

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
