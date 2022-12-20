package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 서블릿을 통한 실제 동작 요청응답은 아래와 같이 이루어진다.

// hello라는 url로 접근할 시, 아래와 같이 실행된다.
// @WebServlet : 서블릿 에노테이션
// name = 서블릿 이름
// urlPatterns = URL 매핑

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // HTTP 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 메서드를 실행한다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // request에 아래와 같이 HTTP 메시지를 기반으로 생성함
        // /hello?username="~~"입력할 시, username 값이 ~~로 설정됨
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // response에 username을 wirte함으로써, 웹 브라우저 출력화면에 해당 값이 나오게됨
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);

    }
}
