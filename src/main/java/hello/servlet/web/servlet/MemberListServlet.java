package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 해당 서블릿은 모든 멤버들을 보여주는 것이니 findAll로 모두 가져옴
        List<Member> members = memberRepository.findAll();

        // 결과를 HTML로 반환하기 위해 response 세팅
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        /*
        지금까지 서블릿과 자바 코드만으로 HTML을 만들어보았다.
        위 작업으로 인해 회원 목록같은 동적인 HTML을 만들 수 있게 되었다.

        그런데 아래처럼, 자바 코드로 HTML을 만들어내는 것은 매우 비효율적이다.
        차라리 HTML 문서 안에 동적으로 변경되어야 하는 부분에 자바 코드를 넣으면 더욱 편리할 것이다.
        그런 이유로 템플릿 엔진이 나오게 됐다. 이걸로 우리는 HTML 문서에서 필요한 곳만
        코드를 적용하여 동적으로 변경할 수 있게 된다!

        템플릿 엔진에는 JSP, Thymeleaf, Freemarker, Velocity 등이 있다.
        */

        PrintWriter w = response.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write(" <meta charset=\"UTF-8\">");
        w.write(" <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write(" <thead>");
        w.write(" <th>id</th>");
        w.write(" <th>username</th>");
        w.write(" <th>age</th>");
        w.write(" </thead>");
        w.write(" <tbody>");
/*
 w.write(" <tr>");
 w.write(" <td>1</td>");
 w.write(" <td>userA</td>");
 w.write(" <td>10</td>");
 w.write(" </tr>");
*/

        // for 루프를 통해서 회원 수만큼 동적으로 생성하고 응답함으로써, 저장된 회원 목록을 확인
        for (Member member : members) {
            w.write(" <tr>");
            w.write(" <td>" + member.getId() + "</td>");
            w.write(" <td>" + member.getUsername() + "</td>");
            w.write(" <td>" + member.getAge() + "</td>");
            w.write(" </tr>");
        }
        w.write(" </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");

    }
}
