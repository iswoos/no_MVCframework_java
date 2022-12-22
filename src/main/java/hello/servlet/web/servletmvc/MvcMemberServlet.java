package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberServlet extends HttpServlet {


    /*
    WEB_INF 폴더에 있는 파일들은 외부에서 호출해도 그냥 호출되지 않는다. 항상 컨트롤러(서블릿)을 거쳐서
    호출해야 호출된다.
    */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
