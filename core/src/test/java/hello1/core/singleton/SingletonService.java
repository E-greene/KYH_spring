package hello1.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 프라이빗 스태틱으로 가지고 있다. 하나만 존재
    private static final SingletonService instance = new SingletonService();

    // 객체 인스턴스가 필요하면 이 스태틱 메서드를 통해서 조회
    public static SingletonService getInstance() {
        return instance;
    }

    // private 생성자를 만들어서 다른데에서 new로 못만들게 한다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
