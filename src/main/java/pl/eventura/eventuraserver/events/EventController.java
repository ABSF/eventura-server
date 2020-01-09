package pl.eventura.eventuraserver.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/events")
public class EventController {

    private final EventRepository eventRepository;
    private Optional<String> text;
    private Optional<String> dateStart;
    private Optional<String> dateEnd;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewEvent (@RequestParam String name, @RequestParam String summary, @RequestParam String event_category, @RequestParam String venue, @RequestParam String date, @RequestParam String logo) {
        LocalDate dateParsed = LocalDate.parse(date);
        Event n = new Event();
        n.setName(name);
        n.setSummary(summary);
        n.setEvent_category(event_category);
        n.setVenue(venue);
        n.setDate(dateParsed);
        n.setLogo(logo);
        eventRepository.save(n);
        return "New event saved!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }

    @GetMapping(path="/search")
    public @ResponseBody
    List<Event> getEvent(@RequestParam(value = "text", required = false) String text,
                         @RequestParam(value = "dateStart", required = false) String dateStart,
                         @RequestParam(value = "dateEnd", required = false) String dateEnd){
        if (dateStart == null || dateStart.isEmpty()) {
            String currentDate = String.valueOf(LocalDate.now());
            dateStart = currentDate;
        }

        if (dateEnd == null || dateEnd.isEmpty()) {
            dateEnd = "2999-01-01";
        }
        LocalDate dateStartParsed = LocalDate.parse(dateStart);
        LocalDate dateEndParsed = LocalDate.parse(dateEnd);
        if (text == null) {
            text = "";
        }
        return eventRepository.findByNameOrSummaryContainingOrDateIsBetween(text, dateStartParsed, dateEndParsed);

    }

    @GetMapping(path="/search/{id}")
    public @ResponseBody
    Optional<Event> getSpecificEvent(@PathVariable int id) {
        return eventRepository.findById(id);
    }

}
