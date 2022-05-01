package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository  = MemberRepository.getInstance();

//    @RequestMapping(value="/new-form", method= RequestMethod.GET) //두번째 인자를 이렇게 설정하면 GET호출만 가능하다.
    @GetMapping("/new-form")
    public String newForm() { //이렇게 String타입으로 반환받으면, 알아서 뷰 이름으로 알고 프로세스가 진행이 된다.
        return "new-form";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model){ //타입 변환까지 스프링에서 자동으로 처리해준다.


        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member); //모델에 담는 부분
        return "save-result";

    }

//    @RequestMapping(method=RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members",members);
        return "members";
    }

}
