package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// servlet 어노테이션
@WebServlet(name = "helloServlet", urlPatterns = "/hello") // name: 서블릿 이름, urlPatterns: URL 매핑 (이름은 아무거나 해도됨)
public class HelloServlet extends HttpServlet {//원래 서블릿은 HttpServlet 클래스를 상속받아야 함.

    @Override // HTTP 요청을 통해 URL이 호출되면 서블릿 컨테이너는 다음 메서드(service)를 실행한다.
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //control+O 에서 protected형 service 선택해야함

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //아래와 같이 servlet이 개발자가 요구하는 값을 알아서 파싱해줌.
        String username = request.getParameter("username");//username 이라는 쿼리파라미터에 해당하는 값을 가져옴.
        System.out.println("username = " + username);


        response.setContentType("text/plain"); // http 헤더 정보 - content type
        response.setCharacterEncoding("utf-8");// 문자 인코딩은 요즘에는 utf-8을 보통 씀
        response.getWriter().write("hello " + username); //write란? -> http 메시지 바디에 데이터가 들어감
    }
}
