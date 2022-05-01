package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    //이번에는 ModelView가 아니라 String 타입의 process
    String process(Map<String, String> paramMap, Map<String, Object> model);
}

