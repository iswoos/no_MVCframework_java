package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

// Lombok 라이브러리를 이용하여 Getter Setter 설정
@Getter
@Setter
public class HelloData {

    private String username;
    private int age;

}
