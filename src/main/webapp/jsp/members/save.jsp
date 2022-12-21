<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
<%해당 표시는 자바 코드를 넣을 수 있게 해주는 표시임. 아래와 같이 사용하면 됨
해당 문서에는 MemberSaveServlet에 있던 아래 부분을 그대로 차용하여 적용시키면 됨.

System.out.println("MemberSaveServlet.service");
        // GET의 쿼리 스트링으로 꺼내든,HTML POST form 전송방식이든 둘 다 request.getParameter
        // 방식으로 꺼내올 수 있다.
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);
--%>

<%
    // HttpServlet request response는, jsp도 결국 서블릿으로 바뀌기에 그대로 사용 가능하다.
    // request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>