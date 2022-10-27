package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 웹 어플리케이션에서 /hello라고 들어오면 이 메서드 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // hello.html을 찾아서 렌더링 해라 controller에서 리턴 값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아 처리
                        // 스프링부트 템플릿엔진 기본 viewName 매핑 `resources:templates/` + {ViewName} + `.html`
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
