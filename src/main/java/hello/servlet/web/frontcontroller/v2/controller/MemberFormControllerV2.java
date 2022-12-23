package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 해당 2줄을 아래 1줄로 인라인 시킬 수 있음        
        MyView myView = new MyView("/WEB-INF/views/new-form.jsp");
        return myView;
        */

        return new MyView("/WEB-INF/views/new-form.jsp");

    }
}
