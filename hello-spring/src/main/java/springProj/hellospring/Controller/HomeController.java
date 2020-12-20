package springProj.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    //root 경로의 home.html 호출
    // / <- url이 있기 때문에 home 호출하고 static 안감
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
