package springProj.hellospring.Controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*Controller는 비즈니스 로직이나 내부적인 것을 처리하는 데에 집중해야 함 */
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http body부에 데이터를 직접 넣어주겠다!
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //페이지 소스 보면 html 없이 문자만 그대로 내려감.
    }

    @GetMapping("hello-api")
    @ResponseBody
    // ResponseBody가 오면 return 값에 따라 converter가 달라짐.
    // 객체가 return되면 JsonConverter(MappingJackson2 라이브러리 사용), 문자열이 return되면 StringConverter
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); //ctrl + shift + enter
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
