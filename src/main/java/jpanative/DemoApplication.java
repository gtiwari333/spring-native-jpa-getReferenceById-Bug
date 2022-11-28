package jpanative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

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


@ImportRuntimeHints(NativeHints.class)
@Configuration
class NativeConfiguration {}

class NativeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints
                .reflection()
                .registerType(Person.class, MemberCategory.values());
    }
}