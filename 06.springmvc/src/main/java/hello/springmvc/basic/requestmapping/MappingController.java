package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value={"/hello-basic","/hello-go"}, method= RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value="/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "ok";
    }


    /**
     *  PathVariable 사용
     *  변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String userId -> @PathVariable userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){ // 경로의 변수명과 매개변수 이름 같으면 생략 가능
        log.info("mappingPath userId={}", userId); //log 형식 주의하기

        return "ok";
    }

    /**
     *  PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId={}, orderId={}", userId, orderId);

        return "ok~";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode"
     * params-"!mode"
     * params="mode=debug"
     * params="mode!=debug" (!=)
     * params={"mode=debug", "data=good"}
     */
    @GetMapping(value="/mapping-param", params="mode=debug") //거의 잘 사용 안함
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode"
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug"
     */
    @GetMapping(value="/mapping-header", headers="mode=debug") //header에 mode=debug 라는 key,value  값을 넣어야 정상적으로 호출됨
    public String mappingHeader(){
        log.info("mappingHeaders");
        return "ok";
    }


    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value="/mapping-consume", consumes= MediaType.APPLICATION_JSON_VALUE)//header에 content type이 appllication/json일때만 정상적으로 호출됨
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }


    /**
     * Accept 헤더 기반 Media Type
     * produces="text/html"
     * produces="!text/html"
     * produces="text/*"
     * produces="*\/*"
     */
    @PostMapping(value="mapping-produce", produces=MediaType.TEXT_HTML_VALUE)
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }






}
