package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/films")
    public String films() {
        return "films";
    }

    @GetMapping("/films/add")
    public String addFilm() {
        return "add-film";
    }
}