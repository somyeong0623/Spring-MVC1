package hello.servlet.web.frontcontroller.v1;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//이것을 왜 만드냐면, ControllerV1을 이용해서 구현을 여러개 할 것임(회원 폼, 회원 저장, 회원 리스트 컨트롤러)
public interface ControllerV1 {

    //서블릿과 똑같은 형태
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
