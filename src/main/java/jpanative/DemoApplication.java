package jpanative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@Controller
class Ctrl {
    @RequestMapping({"/", ""})
    String home(Model m) {
        m.addAttribute("person", new Person("Bob", 20));
        return "home";
    }
}

record Person(String name, int age) {
}