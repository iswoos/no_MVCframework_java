package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         /*상태코드를 지정하는 메소드이나, 아래 줄에 있는 내용대로 쓰는 게 더 낫다!
        response.setStatus(200);
        */

        // 상태코드 200이라는 의미임.
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
        // 이걸로 귀찮게 세팅하는 방법을 떠나, 아래에 있는 "Header 편의 메서드"들로 간편하게 세팅할 수 있다.
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, mustrevalidate");
        response.setHeader("Pragma", "no-cache");
        //내가 원하는 임의의 header "my-header"를 만들 수 있음.
        response.setHeader("my-header","hello");

        // [Header 편의 메서드]
//        content(response);
//        cookie(response);
//        redirect(response);


        //[message body]
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }


    // Content 편의 메서드
    // 해당 값으로 Header의 Content를 간편하게 세팅할 수 있다.
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    // 쿠키 편의 메서드
    // 해당 값으로 쿠키를 간편하게 세팅할 수 있다.
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    // redirect 편의 메서드
    // 해당 값으로 redirect를 간편하게 세팅할 수 있다.
    // 해당 코드로 인해 /basic/hello-form.html 주소지로 redirect된다.
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
