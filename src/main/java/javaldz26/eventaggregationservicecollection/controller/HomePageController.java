package javaldz26.eventaggregationservicecollection.controller;

import javaldz26.eventaggregationservicecollection.dto.EventDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomePageController {
    private final RestTemplate restTemplate;

    public HomePageController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/")
    public String showHomePage(Model model){
        List<EventDto> eventList = restTemplate.getForObject(
                "http://localhost:7070/api/events",
                List.class);

        model.addAttribute("events", eventList);
        return "homePage";

    }
}
