package javaldz26.eventaggregationservicecollection.controller;

import javaldz26.eventaggregationservicecollection.dto.EventDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class EventController {

    private final RestTemplate restTemplate;

    public EventController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/search-events")
    public String showEventsFromEventAggregationService(
            @RequestParam(required = false) String afterDate,
            @RequestParam(required = false) String beforeDate,
            Model model
    ) {
        final String encodedParam =  URLEncoder.encode(afterDate, StandardCharsets.UTF_8);
        String url = String.format("http://localhost:7070/api/events?dateFilter=true&after=%s&before=%s", encodedParam,beforeDate);

        List<EventDto> eventList = restTemplate.getForObject(url, List.class);

        model.addAttribute("afterDate", afterDate);
        model.addAttribute("beforeDate", beforeDate);
        model.addAttribute("events", eventList);

        return "showSearchedEventsView";
    }
}

