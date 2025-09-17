package backend.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller             //스트링 부트의 컨트롤러
public class MainController {
    @GetMapping("/blog")                // URL과의 매핑 담당
    @ResponseBody                          // 요청에 대한 응답
    public String index() {
        return "안녕하세요. 환영합니다.";
    }
}
