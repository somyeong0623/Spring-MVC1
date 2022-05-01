package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //ControllerV2에서는 HttpServletRequest, HttpServletResponse같은 서블릿 기술들이 들어갔는데, V3에는 전혀 안들어감
    ModelView process(Map<String, String> paramMap); //프레임워크에 종속적일 뿐, 서블릿에 종속적이지 않음.

}
